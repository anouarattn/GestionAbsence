package ac.enset.administration.gestionAbsence.entites;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

@SuppressWarnings("serial")
@Entity
@Table(name = "filiere")
public class Filiere extends EntityBase {

   
	@NotEmpty
    private String nom;

    
    @NotNull
    @ManyToOne
    @JoinColumn(name = "FK_Departement")
    private Departement departement;

    @OneToMany(fetch=FetchType.LAZY,mappedBy="filiere",cascade={CascadeType.REMOVE})
    private Set<Classe> classes;
    
    
    @OneToMany(fetch=FetchType.EAGER,mappedBy="filiere",cascade={CascadeType.REMOVE})
    private Set<Module> modules;

    @NotNull
    @Enumerated(EnumType.STRING)
    private TypeFiliere typeFiliere;

    public String getNom() {
	return nom;
    }

    public void setNom(String nom) {
	this.nom = nom;
    }

    public Departement getDepartement() {
        return departement;
    }

    public void setDepartement(Departement departement) {
        this.departement = departement;
    }


    public TypeFiliere getTypeFiliere() {
        return typeFiliere;
    }

    public void setTypeFiliere(TypeFiliere typeFiliere) {
        this.typeFiliere = typeFiliere;
    }

    public Filiere(String nom) {
	super();
	this.nom = nom;
    }

    public Filiere() {
	super();
    }

    public Set<Classe> getClasses() {
        return classes;
    }

    public void setClasses(Set<Classe> classes) {
        this.classes = classes;
    }

    @Override
    public String toString() {
	return  nom +" ("+ typeFiliere + ")";
    }

    public Set<Module> getModules() {
        return modules;
    }

    public void setModules(Set<Module> modules) {
        this.modules = modules;
    }

    

}
