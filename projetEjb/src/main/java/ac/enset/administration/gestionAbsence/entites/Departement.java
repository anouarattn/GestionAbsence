package ac.enset.administration.gestionAbsence.entites;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@SuppressWarnings("serial")
@Entity
@Table(name = "departement")
public class Departement extends EntityBase {

    
	@NotEmpty
    private String nom;
    private String chef;

    @OneToMany(fetch=FetchType.LAZY,mappedBy="departement",cascade={CascadeType.REMOVE},orphanRemoval=true)
    private Set<Filiere> filieres;
    
    @OneToMany(fetch=FetchType.LAZY,mappedBy="departement",cascade={CascadeType.REMOVE},orphanRemoval=true)
    private Set<Enseignent> enseignents;
    
    
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


    public Departement() {
	super();
    }

    public Set<Enseignent> getEnseignents() {
		return enseignents;
	}

	public void setEnseignents(Set<Enseignent> enseignents) {
		this.enseignents = enseignents;
	}

	@Override
    public String toString() {
	return  id+":"+nom;
    }
    

}
