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
@Table(name="elementModule")
public class ElementModule extends EntityBase{
	
	@ManyToOne
    @JoinColumn(name="FK_Module")
	private Module module;
	
	
	@OneToMany(fetch=FetchType.LAZY,mappedBy="elementModule")
    private Set<AbsenceEtud> absenceEtud;
	
	private String codeelem;
	private Date dateCreation;
	private String libelm;
	private int nombreheur;
	
	public ElementModule(
			String codeelem, Date dateCreation, String libelm, int nombreheur) {
		super();
		
		this.codeelem = codeelem;
		this.dateCreation = dateCreation;
		this.libelm = libelm;
		this.nombreheur = nombreheur;
	}
	public int getNombreheur() {
		return nombreheur;
	}
	public void setNombreheur(int nombreheur) {
		this.nombreheur = nombreheur;
	}
	public Set<AbsenceEtud> getAbsenceEtud() {
		return absenceEtud;
	}
	public void setAbsenceEtud(Set<AbsenceEtud> absenceEtud) {
		this.absenceEtud = absenceEtud;
	}
	public Module getModule() {
		return module;
	}
	public void setModule(Module module) {
		this.module = module;
	}
	public String getCodeelem() {
		return codeelem;
	}
	public void setCodeelem(String codeelem) {
		this.codeelem = codeelem;
	}
	public Date getDateCreation() {
		return dateCreation;
	}
	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}
	public String getLibelm() {
		return libelm;
	}
	public void setLibelm(String libelm) {
		this.libelm = libelm;
	}
	public ElementModule() {
		super();
	}
	
	
	
	
}
