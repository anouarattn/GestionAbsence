package ac.enset.administration.gestionAbsence.entites;


import java.sql.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.joda.time.LocalDate;

/**
 * All academic years must have the endYear = beginYear+1
 * @author anouarattn
 *
 */
@Entity
@Table(name="anneeScolaire")
public class AnneeScolaire extends EntityBase implements Comparable<AnneeScolaire> {


    private boolean activated;
    private boolean isLast;
    
    private Date beginYear;
    private Date endYear;
    
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


  

    public boolean isLast() {
        return isLast;
    }

    public void setLast(boolean isLast) {
        this.isLast = isLast;
    }

    
    
    public Date getBeginYear() {
        return beginYear;
    }

    public void setBeginYear(LocalDate beginYear) {
         setJodaBeginYear(beginYear);
    }

    public Date getEndYear() {
        return endYear;
    }

    public void setEndYear(LocalDate endYear) {
        setJodaEndYear(endYear);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null || !(obj instanceof AnneeScolaire))
            return false;
        AnneeScolaire as = (AnneeScolaire)obj;
        if(this.getBeginYear().equals(as.getBeginYear()) && this.getEndYear().equals(as.getEndYear()))
            return true;
        return false;
    }
    
    /**
     * compare two the current AcademicYear with the passed's one
     * @return
     * 	<p>0 if the two AcademicYears are equals</p>
     * 	<p>x > 0 if this AcademicYear is greater than the passed's one. x represent the number of years between the two</p>
     * 	<p>x < 0 if this AcademicYear is smaller than the passed's one and |x| represent the number of years between the two</p>
     */
    @Override
    public int compareTo(AnneeScolaire o) {
	if(o == null )
           throw new NullPointerException("Cannot compare with null value");
	else if(this.equals(o))
	    return 0;
	else if(this.getJodaBeginYear().isAfter(o.getJodaBeginYear()) && this.getJodaEndYear().isAfter(o.getJodaEndYear()))
	    return this.getJodaBeginYear().getYear()- o.getJodaBeginYear().getYear();
	else if(this.getJodaBeginYear().isBefore(o.getJodaBeginYear()) && this.getJodaEndYear().isBefore(o.getJodaEndYear()))
	    return -(this.getJodaBeginYear().getYear()- o.getJodaBeginYear().getYear());
	throw new RuntimeException("AcademicYear data are not correct");
    }

    @Override
    public String toString() {
	return "AnneeScolaire [activated=" + activated + ", isLast=" + isLast
		+ ", beginYear=" + beginYear + ", endYear=" + endYear + "]";
    }
    
    
    public LocalDate getJodaBeginYear() {
	return new LocalDate(beginYear);
    }

    public void setJodaBeginYear(LocalDate beginYear) {
	this.beginYear = Date.valueOf(beginYear.toString());
    }

    public LocalDate getJodaEndYear() {
	return new LocalDate(endYear);
    }

    public void setJodaEndYear(LocalDate endYear) {
        this.endYear =  Date.valueOf(endYear.toString());;
    }
    
    public String getAcademicYearAsString()
    {
	return getJodaBeginYear().getYear()+"/"+getJodaEndYear().getYear();
    }
}
