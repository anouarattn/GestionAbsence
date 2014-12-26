package ac.enset.administration.gestionAbsence;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Entity
@DiscriminatorValue("ETU")
public class Etudiant extends Personne implements Serializable  {
	
	private String cne;
	private String  codeapog;
	
	@ManyToOne
	@JoinColumn(name="ref_class")
	private Classe classe;
	
	
	public Classe getClasse() {
		return classe;
	}

	public void setClasse(Classe classe) {
		this.classe = classe;
	}

	public String getCne() {
		return cne;
	}

	public void setCne(String cne) {
		this.cne = cne;
	}

	public String getCodeapog() {
		return codeapog;
	}

	public void setCodeapog(String codeapog) {
		this.codeapog = codeapog;
	}

	public Etudiant(String nom, String prenom, String email, String tel,Date dateCreation,
			String cne, String codeapog) {
		super(nom, prenom, email, tel,dateCreation);
		this.cne = cne;
		this.codeapog = codeapog;
	}

	public Etudiant() {
		
	}

	
	
	

}
