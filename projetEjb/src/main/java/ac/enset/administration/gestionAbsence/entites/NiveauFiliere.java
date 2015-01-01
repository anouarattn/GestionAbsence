package ac.enset.administration.gestionAbsence.entites;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name="niveauFiliere")
public class NiveauFiliere  implements Serializable {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    
    private String nom;

    @ManyToOne
    @JoinColumn(name="FK_Filiere")
    private Filiere filiere;
    
    @OneToMany(fetch=FetchType.LAZY,mappedBy="niveauFiliere")
    private Set<Classe> classes;
    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
    
    

    public Filiere getFiliere() {
        return filiere;
    }

    public void setFiliere(Filiere filiere) {
        this.filiere = filiere;
    }

    public Set<Classe> getClasses() {
        return classes;
    }

    public void setClasses(Set<Classe> classes) {
        this.classes = classes;
    }

    public NiveauFiliere() {
	super();
	// TODO Auto-generated constructor stub
    }

    public NiveauFiliere(String nom) {
	super();
	this.nom = nom;
    }
    
    
    
}
