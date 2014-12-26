package ac.enset.administration.gestionAbsence;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name="classe")
public class Classe implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	private String codeClasse;
	

	private String libClasse;
	private Date dateCreation;
	private int annee;
	

	@OneToMany(mappedBy="classe",fetch=FetchType.LAZY)
	private Collection<Etudiant> etudiant;
	
	@ManyToOne
	@JoinColumn(name="ref_fil")
	private Filier filier;
	public int getAnnee() {
		return annee;
	}

	public void setAnnee(int annee) {
		this.annee = annee;
	}
	public String getCodeClasse() {
		return codeClasse;
	}

	public void setCodeClasse(String codeClasse) {
		this.codeClasse = codeClasse;
	}

	public String getLibClasse() {
		return libClasse;
	}

	public void setLibClasse(String libClasse) {
		this.libClasse = libClasse;
	}

	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	public Collection<Etudiant> getEtudiant() {
		return etudiant;
	}

	public void setEtudiant(Collection<Etudiant> etudiant) {
		this.etudiant = etudiant;
	}

	public Filier getFilier() {
		return filier;
	}

	public void setFilier(Filier filier) {
		this.filier = filier;
	}

	
	
	
	public Classe(String codeClasse, String libClasse, Date dateCreation,
			int annee) {
		super();
		this.codeClasse = codeClasse;
		this.libClasse = libClasse;
		this.dateCreation = dateCreation;
		this.annee = annee;
	}
	
	public Classe() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
}
