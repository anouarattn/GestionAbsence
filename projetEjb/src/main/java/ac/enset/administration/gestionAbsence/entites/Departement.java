package ac.enset.administration.gestionAbsence.entites;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "departement")
public class Departement implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    private String nom;
    private String chef;

    @OneToMany(fetch=FetchType.LAZY,mappedBy="departement")
    private Set<Filiere> filieres;
    
    
    
    public Long getId() {
	return id;
    }

    public void setId(Long id) {
	this.id = id;
    }

    public String getNom() {
	return nom;
    }

    public void setNom(String nom) {
	this.nom = nom;
    }
    

    public String getChef() {
        return chef;
    }

    public void setChef(String chef) {
        this.chef = chef;
    }

    public Departement(String nom) {
	super();
	this.nom = nom;
    }

    public Departement() {
	super();
	// TODO Auto-generated constructor stub
    }

    public Departement(String nom, String chef) {
	super();
	this.nom = nom;
	this.chef = chef;
    }
    

}
