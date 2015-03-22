package ac.enset.administration.gestionAbsence.entites;


import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "classe")
public class Classe extends EntityBase  {

    

    private String promotion;
    private String beginDate;
    @Enumerated(EnumType.STRING)
    private Niveau niveau;
     
    @ManyToOne
    @JoinColumn(name = "FK_Filiere")
    private Filiere filiere;
    
    @ManyToOne
    @JoinColumn(name = "FK_AnneeScolaire")
    private AnneeScolaire anneeScolaire;
    
    @ManyToOne
    @JoinColumn(name = "FK_NiveauFiliere")
    private NiveauFiliere niveauFiliere;
    


    public Classe() {
	super();
	niveau = Niveau.NonDefini;
	
    }

   
    public AnneeScolaire getAnneeScolaire() {
        return anneeScolaire;
    }

    public void setAnneeScolaire(AnneeScolaire anneeScolaire) {
        this.anneeScolaire = anneeScolaire;
    }

    public Filiere getFiliere() {
        return filiere;
    }

    public void setFiliere(Filiere filiere) {
        this.filiere = filiere;
    }

    public Niveau getNiveau() {
        return niveau;
    }

    public void setNiveau(Niveau niveau) {
        this.niveau = niveau;
    }


    public String getPromotion() {
        return promotion;
    }


    public void setPromotion(String promotion) {
        this.promotion = promotion;
    }


    public String getBeginDate() {
        return beginDate;
    }


    public void setBeginDate(String beginDate) {
        this.beginDate = beginDate;
    }


    public NiveauFiliere getNiveauFiliere() {
        return niveauFiliere;
    }


    public void setNiveauFiliere(NiveauFiliere niveauFiliere) {
        this.niveauFiliere = niveauFiliere;
    }
    
    
}
