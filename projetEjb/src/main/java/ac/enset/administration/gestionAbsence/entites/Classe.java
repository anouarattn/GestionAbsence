package ac.enset.administration.gestionAbsence.entites;


import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "classe")
public class Classe extends EntityBase  {

    

    private String nom;

    @ManyToOne
    @JoinColumn(name = "FK_NiveauFiliere")
    private NiveauFiliere niveauFiliere;
    
    @ManyToOne
    @JoinColumn(name = "FK_AnneeScolaire")
    private AnneeScolaire anneeScolaire;

  
    public String getNom() {
	return nom;
    }

    public void setNom(String nom) {
	this.nom = nom;
    }

    public NiveauFiliere getNiveauFiliere() {
	return niveauFiliere;
    }

    public void setNiveauFiliere(NiveauFiliere niveauFiliere) {
	this.niveauFiliere = niveauFiliere;
    }

    public Classe(String nom) {
	super();
	this.nom = nom;
    }

    public Classe(String nom, NiveauFiliere niveauFiliere) {
	super();
	this.nom = nom;
	this.niveauFiliere = niveauFiliere;
    }

    public Classe() {
	super();
    }

}
