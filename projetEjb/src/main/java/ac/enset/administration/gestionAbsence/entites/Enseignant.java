package ac.enset.administration.gestionAbsence.entites;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@SuppressWarnings("serial")
@Entity
@Table(name = "enseignant")
public class Enseignant extends EntityBase {
	
	private String nom;
	private String prenom;
	private String specialite;
	
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "enseignant")
	private Set<Element> elementModule;


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getPrenom() {
		return prenom;
	}


	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}


	public String getSpecialite() {
		return specialite;
	}


	public void setSpecialite(String specialite) {
		this.specialite = specialite;
	}


	public Set<Element> getElementModule() {
		return elementModule;
	}


	public void setElementModule(Set<Element> elementModule) {
		this.elementModule = elementModule;
	}
	
	public String toString() {
	        return String.format("%s",getNom()+" "+getPrenom());
	}
	
}
