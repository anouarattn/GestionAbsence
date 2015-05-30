package ac.enset.administration.gestionAbsence.entites;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@SuppressWarnings("serial")
@Entity
@Table(name = "element")
public class Element extends EntityBase {

    @ManyToOne
    @JoinColumn(name = "FK_Module")
    private Module module;

    @NotEmpty
    private String name;

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public Element() {
	super();
    }

    @Override
    public String toString() {
	return name;
    }
    public Module getModule() {
        return module;
    }

    public void setModule(Module module) {
        this.module = module;
    }
    
    

  

}
