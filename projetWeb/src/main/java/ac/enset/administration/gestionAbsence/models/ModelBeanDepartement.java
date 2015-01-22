package ac.enset.administration.gestionAbsence.models;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;


import ac.enset.administration.gestionAbsence.entites.Departement;
import ac.enset.administration.gestionAbsence.metier.IAbsenceLocal;


@Named
@SessionScoped
public class ModelBeanDepartement implements Serializable
{
  
    private static final long serialVersionUID = 1L;

    @Inject
    private IAbsenceLocal metier;
    
    private List<Departement> departements;
    private Departement selectedDepartement;

    

    @PostConstruct
    public void init() {
	 departements = metier.getDepartements();
    }
    
    public List<Departement> getDepartements() {
	
	return departements;
    }

    public void setDepartements(List<Departement> departements) {
        this.departements = departements;
    }
    
    
    public void modifierDepartement()
    {
	metier.modifierDepartement(selectedDepartement);
	setSelectedDepartement(null);
	// peut etre optimiser
	departements = metier.getDepartements();
    }
    
    public void supprimeDepartement(){
	metier.supprimerDepartement(selectedDepartement);
	departements.remove(selectedDepartement);
	setSelectedDepartement(null);
    }

    public Departement getSelectedDepartement() {
        return selectedDepartement;
    }

    public void setSelectedDepartement(Departement selectedDepartement) {
        this.selectedDepartement = selectedDepartement;
    }

    
  
 
    
}