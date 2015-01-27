package ac.enset.administration.gestionAbsence.entites;


import java.util.Set;

import javax.persistence.*;


@Entity
@Table(name="anneeScolaire")
public class AnneeScolaire extends EntityBase {


    private int annee;
    
    @OneToMany(fetch=FetchType.LAZY,mappedBy="anneeScolaire")
    private Set<Classe> classes;

    public int getAnnee() {
        return annee;
    }

    public void setAnnee(int annee) {
        this.annee = annee;
    }

    public Set<Classe> getClasses() {
        return classes;
    }

    public void setClasses(Set<Classe> classes) {
        this.classes = classes;
    }

    public AnneeScolaire(int annee) {
	super();
	this.annee = annee;
    }

    public AnneeScolaire() {
	super();
    }
    
    
}
