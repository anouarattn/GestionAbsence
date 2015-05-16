package ac.enset.administration.gestionAbsence.entites;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "element")
public class Element extends EntityBase {

    @ManyToMany
    @JoinTable(name = "ELEMENT_MODULE", 
    joinColumns = { @JoinColumn(name = "ELEMENT_ID", referencedColumnName = "id") }, 
    inverseJoinColumns = { @JoinColumn(name = "MODULE_ID", referencedColumnName = "id") })
    private Set<Module> modules;

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

    public Set<Module> getModules() {
	return modules;
    }

    public void setModules(Set<Module> modules) {
	this.modules = modules;
    }

}
