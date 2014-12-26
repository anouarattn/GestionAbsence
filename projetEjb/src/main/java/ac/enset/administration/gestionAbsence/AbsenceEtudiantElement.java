package ac.enset.administration.gestionAbsence;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity
@Table(name="absenceEtudiantElement")
public class AbsenceEtudiantElement implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name="dateabsence")
	private Date dateabsence;	
	@Column(name="motif")
	private String motif ;
	@ManyToOne
	@JoinColumn(name="ref_elmod")
	private ElementModule elmod;	
	@ManyToOne
	@JoinColumn(name="ref_etudiant")
	private Etudiant etudiant;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public ElementModule getElmod() {
		return elmod;
	}
	public void setElmod(ElementModule elmod) {
		this.elmod = elmod;
	}
	public Etudiant getEtudiant() {
		return etudiant;
	}
	public void setEtudiant(Etudiant etudiant) {
		this.etudiant = etudiant;
	}
	public Date getDateabsence() {
		return dateabsence;
	}
	public void setDateabsence(Date dateabsence) {
		this.dateabsence = dateabsence;
	}
	public String getMotif() {
		return motif;
	}
	public void setMotif(String motif) {
		this.motif = motif;
	}
	public AbsenceEtudiantElement() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AbsenceEtudiantElement(Date dateabsence, String motif) {
		super();
		this.dateabsence = dateabsence;
		this.motif = motif;
	}
	

}
