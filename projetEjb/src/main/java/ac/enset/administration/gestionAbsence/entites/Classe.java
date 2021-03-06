package ac.enset.administration.gestionAbsence.entites;


import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@SuppressWarnings("serial")
@Entity
@Table(name = "classe")
public class Classe extends EntityBase  {

    

    @Enumerated(EnumType.STRING)
    private Niveau niveau;
     
    @NotNull
    @ManyToOne
    @JoinColumn(name = "FK_Filiere")
    private Filiere filiere;
    
    @NotNull
    @ManyToOne
    @JoinColumn(name = "FK_currentAcademicYear")
    private AnneeScolaire currentAcademicYear;
    
    @NotNull
    @ManyToOne
    @JoinColumn(name = "FK_promotionAcademicYear")
    private AnneeScolaire promotionAcademicYear;
    
    @NotNull
    @ManyToOne
    @JoinColumn(name = "FK_beginAcademicYear")
    private AnneeScolaire beginAcademicYear;
    
    public Classe() {
	super();
	niveau = Niveau.NonDefini;
	
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


   




    public AnneeScolaire getCurrentAcademicYear() {
        return currentAcademicYear;
    }



    public void setCurrentAcademicYear(AnneeScolaire currentAcademicYear) {
        this.currentAcademicYear = currentAcademicYear;
    }



    public AnneeScolaire getPromotionAcademicYear() {
        return promotionAcademicYear;
    }



    public void setPromotionAcademicYear(AnneeScolaire promotionAcademicYear) {
        this.promotionAcademicYear = promotionAcademicYear;
    }



    public AnneeScolaire getBeginAcademicYear() {
        return beginAcademicYear;
    }



    public void setBeginAcademicYear(AnneeScolaire beginAcademicYear) {
        this.beginAcademicYear = beginAcademicYear;
    }
    
    public String toString() {
        return String.format("%s", getFiliere().getNom() +" - "+getNiveau() );
    }
    
    
}
