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
    private List<Departement> selectedDepartements;

    

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
	departements = metier.getDepartements();
	unselect();
    }
    
    public void supprimeDepartement(){
	for (Departement departement : selectedDepartements) {
		metier.supprimerDepartement(departement);
		departements.remove(departement);
	}
	unselect();
	}

    public Departement getSelectedDepartement() {
	Departement tmp = selectedDepartement;
        return tmp;
    }

    public void setSelectedDepartement(Departement selectedDepartement) {
        this.selectedDepartement = selectedDepartement;
    }
    
    public void unselect()
    {
	setSelectedDepartements(null);
    }

    public void annulerModifierDepartement()
    {
	departements = metier.getDepartements();
	unselect();
    }

    public List<Departement> getSelectedDepartements() {
        return selectedDepartements;
    }

    public void setSelectedDepartements(List<Departement> selectedDepartements) {
	if(selectedDepartements != null && selectedDepartements.size() != 0)
	this.selectedDepartement = selectedDepartements.get(selectedDepartements.size()-1);
	else 
	this.selectedDepartement = null;
        this.selectedDepartements = selectedDepartements;
    }
    
    public void update()
    {
	departements = metier.getDepartements();
	unselect();
    }
    
}