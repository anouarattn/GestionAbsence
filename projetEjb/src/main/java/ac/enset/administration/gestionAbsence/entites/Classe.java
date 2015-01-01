package ac.enset.administration.gestionAbsence.entites;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "classe")
public class Classe implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    private String nom;

    @ManyToOne
    @JoinColumn(name = "FK_NiveauFiliere")
    private NiveauFiliere niveauFiliere;
    
    @ManyToOne
    @JoinColumn(name = "FK_AnneeScolaire")
    private AnneeScolaire anneeScolaire;

    public int getId() {
	return id;
    }

    public void setId(int id) {
	this.id = id;
    }

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
	// TODO Auto-generated constructor stub
    }

}
