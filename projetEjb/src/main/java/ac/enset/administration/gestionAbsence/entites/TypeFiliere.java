package ac.enset.administration.gestionAbsence.entites;


import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="typeFiliere")
public class TypeFiliere implements Serializable {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    
    private String nom;
 
    @OneToMany(fetch=FetchType.LAZY,mappedBy="typeFiliere")
    private Set<Filiere> filieres;
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

    public TypeFiliere(String nom) {
	super();
	this.nom = nom;
    }

    public TypeFiliere() {
	super();
	// TODO Auto-generated constructor stub
    }
    
    
}
