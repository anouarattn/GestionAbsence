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
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name="filier")
public class Filier implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name="codefil")
	private String codefil;
	@Column(name="libfil")
	private String libfil; 
	@Column(name="annee")
	private int annee;
	@Column(name="dateCreation")
	private Date dateCreation;
	@OneToMany(mappedBy="filier",fetch=FetchType.LAZY)
	private Collection<Module> module;
	
	@OneToMany(mappedBy="filier",fetch=FetchType.LAZY)
	private Collection<Classe> classe;
	
	public int getAnnee() {
		return annee;
	}
	public void setAnnee(int annee) {
		this.annee = annee;
	}
	public Date getDateCreation() {
		return dateCreation;
	}
	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}
	
	public String getCodefil() {
		return codefil;
	}
	public void setCodefil(String codefil) {
		this.codefil = codefil;
	}
	public String getLibfil() {
		return libfil;
	}
	public void setLibfil(String libfil) {
		this.libfil = libfil;
	}
	
	public Collection<Module> getModule() {
		return module;
	}
	public void setModule(Collection<Module> module) {
		this.module = module;
	}
	
	public Filier(String codefil, String libfil, int annee, Date dateCreation) {
		super();
		this.codefil = codefil;
		this.libfil = libfil;
		this.annee = annee;
		this.dateCreation = dateCreation;
		
	}
	public Filier() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Collection<Classe> getClasse() {
		return classe;
	}
	public void setClasse(Collection<Classe> classe) {
		this.classe = classe;
	}
	
	
	
	

}
