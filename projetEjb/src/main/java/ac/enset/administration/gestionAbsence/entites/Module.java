package ac.enset.administration.gestionAbsence.entites;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "module")
public class Module extends EntityBase {
    
    
    @Enumerated(EnumType.STRING)
    private Semestre semestre;

    @ManyToOne
    @JoinColumn(name = "FK_Filiere")
    private Filiere filiere;
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "module")
    private Set<Element> elements;
    
    private String name;
    public Filiere getFiliere() {
        return filiere;
    }
    public void setFiliere(Filiere filiere) {
        this.filiere = filiere;
    }
    
    public Set<Element> getElements() {
        return elements;
    }
    public void setElements(Set<Element> elements) {
        this.elements = elements;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Semestre getSemestre() {
        return semestre;
    }
    public void setSemestre(Semestre semestre) {
        this.semestre = semestre;
    }

    @Override
    public String toString() {

        return id+" "+filiere.getNom()+" :"+name;
    }
    
    
    
    
    
 
    
}
