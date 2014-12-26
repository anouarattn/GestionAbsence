package ac.enset.administration.gestionAbsence;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
@Entity
@DiscriminatorValue("ENS")
public class Enseignant extends Personne implements Serializable  {
	
	private double ppr;
	private String departement;
	
	@OneToMany(mappedBy="enseignant",fetch=FetchType.LAZY)
	private Collection<ElementModule> elementModule;
	
	public Collection<ElementModule> getElementModule() {
		return elementModule;
	}
	public void setElementModule(Collection<ElementModule> elementModule) {
		this.elementModule = elementModule;
	}
	public double getPpr() {
		return ppr;
	}
	public void setPpr(double ppr) {
		this.ppr = ppr;
	}
	public String getDepartement() {
		return departement;
	}
	public void setDepartement(String departement) {
		this.departement = departement;
	}
	public Enseignant(String nom, String prenom, String email, String tel,Date dateCreation,
			double ppr, String departement) {
		super(nom, prenom, email, tel,dateCreation);
		this.ppr = ppr;
		this.departement = departement;
	}
	
	public Enseignant() {
		
	}
	
	

}
