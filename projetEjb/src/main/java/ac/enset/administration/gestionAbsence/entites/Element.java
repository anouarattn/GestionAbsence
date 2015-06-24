package ac.enset.administration.gestionAbsence.entites;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;



@SuppressWarnings("serial")
@Entity
@Table(name = "element")
public class Element extends EntityBase {

    @ManyToOne
    @JoinColumn(name = "FK_Module")
    private Module module;
    
    @ManyToOne
    @JoinColumn(name="FK_Enseignent")
	private Enseignent enseignent;
    
    @OneToMany(fetch=FetchType.LAZY,mappedBy="elementModule")
    private Set<AbsenceEtud> absenceEtud;
    
    @NotEmpty
    private String name;

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

   
    public Module getModule() {
        return module;
    }

    public void setModule(Module module) {
        this.module = module;
    }
    

	public Enseignent getEnseignent() {
		return enseignent;
	}
	public void setEnseignent(Enseignent enseignent) {
		this.enseignent = enseignent;
	}
    
	public Set<AbsenceEtud> getAbsenceEtud() {
		return absenceEtud;
	}
	public void setAbsenceEtud(Set<AbsenceEtud> absenceEtud) {
		this.absenceEtud = absenceEtud;
	}

	@Override
    public String toString() {
		
		return String.format("%s",  getName() );
	}

}
