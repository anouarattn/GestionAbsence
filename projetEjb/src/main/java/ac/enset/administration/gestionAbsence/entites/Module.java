package ac.enset.administration.gestionAbsence.entites;

import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="module")
public class Module extends EntityBase{
	
	@ManyToOne
    @JoinColumn(name="FK_NiveauFiliere")
	private NiveauFiliere niveauFiliere;
	
	@OneToMany(fetch=FetchType.LAZY,mappedBy="module")
    private Set<ElementModule> elementModule;
	
	private String codemodule;
	private Date dateCreation;
	private String libmodule;
	private String semestre;
	public NiveauFiliere getNiveauFiliere() {
		return niveauFiliere;
	}
	public void setNiveauFiliere(NiveauFiliere niveauFiliere) {
		this.niveauFiliere = niveauFiliere;
	}
	public Set<ElementModule> getElementModule() {
		return elementModule;
	}
	public void setElementModule(Set<ElementModule> elementModule) {
		this.elementModule = elementModule;
	}
	public String getCodemodule() {
		return codemodule;
	}
	public void setCodemodule(String codemodule) {
		this.codemodule = codemodule;
	}
	public Date getDateCreation() {
		return dateCreation;
	}
	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}
	public String getLibmodule() {
		return libmodule;
	}
	public void setLibmodule(String libmodule) {
		this.libmodule = libmodule;
	}
	public String getSemestre() {
		return semestre;
	}
	public void setSemestre(String semestre) {
		this.semestre = semestre;
	}
	public Module( String codemodule,
			Date dateCreation, String libmodule, String semestre) {
		super();
		this.codemodule = codemodule;
		this.dateCreation = dateCreation;
		this.libmodule = libmodule;
		this.semestre = semestre;
	}
	public Module() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
