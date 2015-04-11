package ac.enset.administration.gestionAbsence.entites;


import java.util.Set;

import javax.persistence.*;


@Entity
@Table(name="anneeScolaire")
public class AnneeScolaire extends EntityBase {


    private int beginYear;
    private boolean activated;
    private int endYear;
    private String yearsFormated;
    private boolean isLast;
    
    public boolean isActivated() {
        return activated;
    }

    public void setActivated(boolean activated) {
        this.activated = activated;
    }

    @OneToMany(fetch=FetchType.LAZY)
    private Set<Classe> classes;

  

    public Set<Classe> getClasses() {
        return classes;
    }

    public void setClasses(Set<Classe> classes) {
        this.classes = classes;
    }

   

    public AnneeScolaire() {
	super();
    }

    public int getBeginYear() {
        return beginYear;
    }

    public void setBeginYear(int beginYear) {
        this.beginYear = beginYear;
    }

    public int getEndYear() {
        return endYear;
    }

    public void setEndYear(int endYear) {
        this.endYear = endYear;
    }

    public String getYearsFormated() {
        return yearsFormated;
    }

    public void setYearsFormated(String yearsFormated) {
        this.yearsFormated = yearsFormated;
    }

    public boolean isLast() {
        return isLast;
    }

    public void setLast(boolean isLast) {
        this.isLast = isLast;
    }
    
    
   
    
    
}
