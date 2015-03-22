package ac.enset.administration.gestionAbsence.entites;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="etudiant")
public class Etudiant  extends EntityBase {
	
	private String nom;
	private String prenom;
	private String adresse;
	private String codind;
	private String tel;
	private String email;
	private double cne;
	
	@ManyToOne
    @JoinColumn(name="FK_Classe")
	private Classe classe;
	
	@OneToMany(fetch=FetchType.LAZY,mappedBy="etudiant")
    private Set<AbsenceEtud> absenceEtud;

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

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getCodind() {
		return codind;
	}

	public void setCodind(String codind) {
		this.codind = codind;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public double getCne() {
		return cne;
	}

	public void setCne(double cne) {
		this.cne = cne;
	}

	public Classe getClasse() {
		return classe;
	}

	public void setClasse(Classe classe) {
		this.classe = classe;
	}

	public Set<AbsenceEtud> getAbsenceEtud() {
		return absenceEtud;
	}

	public void setAbsenceEtud(Set<AbsenceEtud> absenceEtud) {
		this.absenceEtud = absenceEtud;
	}

	public Etudiant(String nom, String prenom, String adresse, String codind,
			String tel, String email, double cne) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.codind = codind;
		this.tel = tel;
		this.email = email;
		this.cne = cne;
	}

	public Etudiant() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
