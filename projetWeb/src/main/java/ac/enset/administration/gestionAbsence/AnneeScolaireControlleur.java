package ac.enset.administration.gestionAbsence;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import ac.enset.administration.gestionAbsence.entites.AnneeScolaire;
import ac.enset.administration.gestionAbsence.metier.IAbsenceLocal;


@Named
@RequestScoped
public class AnneeScolaireControlleur 
{
    @Inject
    private IAbsenceLocal metier;
    
    public AnneeScolaireControlleur() {
    }

    
    public List<AnneeScolaire> getAnneesScolaires() {
	return metier.getAnneesScollaires();
    }

 
    
}