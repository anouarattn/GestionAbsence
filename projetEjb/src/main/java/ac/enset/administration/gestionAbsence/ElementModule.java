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
@Table(name="elementModule")
public class ElementModule implements Serializable  {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name="codeelm")
	private String codeelm;
	@Column(name="libelm")
	private String libelm;
	@Column(name="dateCreation")
	private Date dateCreation;
	@ManyToOne
	@JoinColumn(name="ref_mod")
	private Module module ;
	
	@ManyToOne
	@JoinColumn(name="ref_ens")
	Enseignant enseignant;
	
	public Enseignant getEnseignant() {
		return enseignant;
	}
	public void setEnseignant(Enseignant enseignant) {
		this.enseignant = enseignant;
	}
	public ElementModule() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ElementModule(String codeelm, String libelm, Date dateCreation) {
		super();
		this.codeelm = codeelm;
		this.libelm = libelm;
		this.dateCreation = dateCreation;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCodeelm() {
		return codeelm;
	}
	public void setCodeelm(String codeelm) {
		this.codeelm = codeelm;
	}
	public String getLibelm() {
		return libelm;
	}
	public void setLibelm(String libelm) {
		this.libelm = libelm;
	}
	public Date getDateCreation() {
		return dateCreation;
	}
	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}
	public Module getModule() {
		return module;
	}
	public void setModule(Module module) {
		this.module = module;
	}
	
	public ElementModule(String codeelm, String libelm, Date dateCreation,
			Module module) {
		super();
		this.codeelm = codeelm;
		this.libelm = libelm;
		this.dateCreation = dateCreation;
		this.module = module;
	}
	
	
}
