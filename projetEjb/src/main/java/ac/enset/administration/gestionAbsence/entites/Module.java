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

@SuppressWarnings("serial")
@Entity
@Table(name = "module")
public class Module extends EntityBase {
    
    
    @Enumerated(EnumType.STRING)
    private Semestre semestre;

    @ManyToOne
    @JoinColumn(name = "FK_Filiere")
    private Filiere filiere;
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "module")
    private Set<ElementModule> elementModule;
    
    private String name;
    public Filiere getFiliere() {
        return filiere;
    }
    public void setFiliere(Filiere filiere) {
        this.filiere = filiere;
    }
    public Set<ElementModule> getElementModule() {
        return elementModule;
    }
    public void setElementModule(Set<ElementModule> elementModule) {
        this.elementModule = elementModule;
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
    
}
