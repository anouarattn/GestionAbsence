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
@Table(name = "filiere")
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

    public Departement getDepartement() {
        return departement;
    }

    public void setDepartement(Departement departement) {
        this.departement = departement;
    }

    public Set<NiveauFiliere> getNiveauFilieres() {
        return niveauFilieres;
    }

    public void setNiveauFilieres(Set<NiveauFiliere> niveauFilieres) {
        this.niveauFilieres = niveauFilieres;
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

}
