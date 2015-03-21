package ac.enset.administration.gestionAbsence.entites;



import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="typeFiliere")
public class TypeFiliere extends EntityBase {
    
  
    private String nom;
    private int numberOfYears;
        
    @OneToMany(fetch=FetchType.LAZY,mappedBy="typeFiliere")
    private Set<Filiere> filieres;
   

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public TypeFiliere(String nom) {
	super();
	this.nom = nom;
    }

    public TypeFiliere() {
	super();
	// TODO Auto-generated constructor stub
    }
    
    
}
