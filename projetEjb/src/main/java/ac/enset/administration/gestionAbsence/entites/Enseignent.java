package ac.enset.administration.gestionAbsence.entites;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

@SuppressWarnings("serial")
@Entity
@Table(name="enseignent")
public class Enseignent extends EntityBase{
	
	@NotBlank
	private String fName;
	@NotBlank
	private String lName;
	private String adresse;
	/**
	 * school specific code
	 */
	private String tel;
	@Email
	private String email;
	private String cin;
	@Lob
	private String photo;
	
	private byte[] authentication;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "enseignent")
	private Set<Element> elementModule;
	
	@ManyToOne
    @JoinColumn(name="FK_Departement")
	private Departement departement;

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCin() {
		return cin;
	}

	public void setCin(String cin) {
		this.cin = cin;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public byte[] getAuthentication() {
		return authentication;
	}

	public void setAuthentication(byte[] authentication) {
		this.authentication = authentication;
	}

	public Departement getDepartement() {
		return departement;
	}

	public void setDepartement(Departement departement) {
		this.departement = departement;
	}
	
	public Set<Element> getElementModule() {
		return elementModule;
	}


	public void setElementModule(Set<Element> elementModule) {
		this.elementModule = elementModule;
	}
	
	public String toString() {
        return String.format("%s",getfName()+" "+getlName());
        
	}
	

}
