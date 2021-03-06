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
	private Element elementModule;
	
	private String dateAbsence;
	
	private int nbrheurAbsence;

	public int getNbrheurAbsence() {
		return nbrheurAbsence;
	}

	public void setNbrheurAbsence(int nbrheurAbsence) {
		this.nbrheurAbsence = nbrheurAbsence;
	}

	public Etudiant getEtudiant() {
		return etudiant;
	}

	public void setEtudiant(Etudiant etudiant) {
		this.etudiant = etudiant;
	}

	public Element getElementModule() {
		return elementModule;
	}

	public void setElementModule(Element elementModule) {
		this.elementModule = elementModule;
	}

	public String getDateAbsence() {
		return dateAbsence;
	}

	public void setDateAbsence(String dateAbsence) {
		this.dateAbsence = dateAbsence;
	}

	

	public AbsenceEtud() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
