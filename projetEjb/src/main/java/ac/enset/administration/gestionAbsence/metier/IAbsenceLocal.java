package ac.enset.administration.gestionAbsence.metier;


import java.util.List;

import javax.ejb.Local;

import ac.enset.administration.gestionAbsence.entites.AnneeScolaire;
import ac.enset.administration.gestionAbsence.entites.Classe;
import ac.enset.administration.gestionAbsence.entites.Departement;
import ac.enset.administration.gestionAbsence.entites.Filiere;
import ac.enset.administration.gestionAbsence.entites.NiveauFiliere;
import ac.enset.administration.gestionAbsence.entites.TypeFiliere;

@Local
public interface IAbsenceLocal {

    public void ajouterDepartement(Departement d);

    public void ajouterTypeFiliere(TypeFiliere tf);
    
    public void ajouterFiliere(Filiere f, Long idDepartement, Long idTypeFiliere);
    
    public void ajouterNiveauFiliere(NiveauFiliere nf, Long idFiliere);
    
    public void ajouterAnneeScolaire(AnneeScolaire as);
    
    public void ajouterClasse(Classe c, Long idNiveauFiliere, Long idAnneeScolaire);    
    
    public List<AnneeScolaire> getAnneesScollaires();
    

}
