package ac.enset.administration.gestionAbsence.entites;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="absenceEtud")
public class AbsenceEtud  extends EntityBase  {
	
	@ManyToOne
    @JoinColumn(name="FK_Etudiant")
	private Etudiant etudiant;
	
	@ManyToOne
    @JoinColumn(name="FK_elementModule")
	private ElementModule elementModule;
	
	private Date dateAbsence;

	public Etudiant getEtudiant() {
		return etudiant;
	}

	public void setEtudiant(Etudiant etudiant) {
		this.etudiant = etudiant;
	}

	public ElementModule getElementModule() {
		return elementModule;
	}

	public void setElementModule(ElementModule elementModule) {
		this.elementModule = elementModule;
	}

	public Date getDateAbsence() {
		return dateAbsence;
	}

	public void setDateAbsence(Date dateAbsence) {
		this.dateAbsence = dateAbsence;
	}

	public AbsenceEtud(
			Date dateAbsence) {
		super();
		
		this.dateAbsence = dateAbsence;
	}

	public AbsenceEtud() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
