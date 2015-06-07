package ac.enset.administration.gestionAbsence.metier;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Arrays;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.ejb.Stateless;

import ac.enset.administration.gestionAbsence.metier.exception.PasswordException;


@Stateless
public class PasswordEncryptionService {
	
	


	public boolean authenticate(String attemptedPassword,
			byte[] encryptedPassword, byte[] salt)

	throws NoSuchAlgorithmException, InvalidKeySpecException {

		// Encrypt the clear-text password using the same salt that was used to

		// encrypt the original password

		byte[] encryptedAttemptedPassword = getEncryptedPassword(
				attemptedPassword, salt);

		// Authentication succeeds if encrypted password that the user entered

		// is equal to the stored hash

		return Arrays.equals(encryptedPassword, encryptedAttemptedPassword);

	}

	public byte[] getEncryptedPassword(String password, byte[] salt)

	throws NoSuchAlgorithmException, InvalidKeySpecException {

		// PBKDF2 with SHA-1 as the hashing algorithm. Note that the NIST

		// specifically names SHA-1 as an acceptable hashing algorithm for
		// PBKDF2

		String algorithm = "PBKDF2WithHmacSHA1";

		// SHA-1 generates 160 bit hashes, so that's what makes sense here

		int derivedKeyLength = 160;

		// Pick an iteration count that works for you. The NIST recommends at

		// least 1,000 iterations:

		// http://csrc.nist.gov/publications/nistpubs/800-132/nist-sp800-132.pdf

		// iOS 4.x reportedly uses 10,000:

		// http://blog.crackpassword.com/2010/09/smartphone-forensics-cracking-blackberry-backup-passwords/

		int iterations = 20000;

		KeySpec spec = new PBEKeySpec(password.toCharArray(), salt, iterations,
				derivedKeyLength);

		SecretKeyFactory f = SecretKeyFactory.getInstance(algorithm);

		return f.generateSecret(spec).getEncoded();

	}

	public byte[] generateSalt() throws NoSuchAlgorithmException {

		// VERY important to use SecureRandom instead of just Random

		SecureRandom random = SecureRandom.getInstance("SHA1PRNG");

		// Generate a 8 byte (64 bit) salt as recommended by RSA PKCS5

		byte[] salt = new byte[8];

		random.nextBytes(salt);

		return salt;

	}
	

	
	public byte[] getStorablePassword(byte[] encryptedPassword,byte[] salt) throws PasswordException, IOException
	{
		

		if(salt.length != 8 || encryptedPassword.length!= 20)
			throw new PasswordException("salt or encryptedPassword error data(length)");
		byte[] salt1 = new byte[]{salt[0],salt[2],salt[4],salt[6]};
		byte[] salt2 = new byte[]{salt[1],salt[3],salt[5],salt[7]};
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream( );
		outputStream.write( salt1 );
		outputStream.write(encryptedPassword);
		outputStream.write( salt2);
		String tt = Arrays.toString(outputStream.toByteArray());
		
		return outputStream.toByteArray();
	}
	
	
	public byte[] getEncryptedPasswordFromStorablePassword(byte[] storablePassword)
	{

		byte[] data = storablePassword;
		
		return Arrays.copyOfRange(data, 4, 24);
	}
	
	public byte[] getSaltFromStorablePassword(byte[] storablePassword)
	{
		byte[] data = storablePassword;
		byte[] salt1 = new byte[]{data[0],data[1],data[2],data[3]};
		byte[] salt2 = new byte[]{data[data.length -4],data[data.length -3],data[data.length -2],data[data.length -1]};
		
		return new byte[]{salt1[0],salt2[0],salt1[1],salt2[1],salt1[2],salt2[2],salt1[3],salt2[3]};
	}
	
	
	public byte[] generateStorablePassword() throws NoSuchAlgorithmException, InvalidKeySpecException, PasswordException, IOException
	{

		SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
	    String password = new BigInteger(40, random).toString(15);
	    byte[] salt = generateSalt();
	    byte[] encryptedPassword = getEncryptedPassword(password, salt);
	    
	    
	    
	    return getStorablePassword(encryptedPassword, salt);

	}
	
	
}
