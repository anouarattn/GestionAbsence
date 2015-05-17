package ac.enset.administration.gestionAbsence.entites;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "departement")
public class Departement extends EntityBase {

    

    private String nom;
    private String chef;

    @OneToMany(fetch=FetchType.LAZY,mappedBy="departement",cascade={CascadeType.REMOVE})
    private Set<Filiere> filieres;
    

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

    @Override
    public String toString() {
	return  id+":"+nom;
    }
    

}
