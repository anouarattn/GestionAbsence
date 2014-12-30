package ac.enset.administration.entites;

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
@Table(name = "Filiere")
public class Filiere implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    private String nom;

    @ManyToOne
    @JoinColumn(name = "FK_Departement")
    private Departement departement;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "filiere")
    private Set<NiveauFiliere> niveauFilieres;

    @ManyToOne
    @JoinColumn(name = "FK_TypeFiliere")
    private TypeFiliere typeFiliere;

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

    public Filiere(String nom) {
	super();
	this.nom = nom;
    }

    public Filiere() {
	super();
    }

}
