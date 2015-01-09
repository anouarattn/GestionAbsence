package ac.enset.administration.gestionAbsence;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import ac.enset.administration.gestionAbsence.entites.Departement;
import ac.enset.administration.gestionAbsence.metier.IAbsenceLocal;


@Named
@RequestScoped
public class DepartementControlleur implements Serializable
{
    @Inject
    private IAbsenceLocal metier;
    
    private List<Departement> departements;
    private List<Departement> filtredDepartements;
    private Departement selectedDepartement;
    
    public List<Departement> getFiltredDepartements() {
        return filtredDepartements;
    }

    public void setFiltredDepartements(List<Departement> filtredDepartements) {
        this.filtredDepartements = filtredDepartements;
    }

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
    
    public void supprimeDepartement(){}

    public Departement getSelectedDepartement() {
        return selectedDepartement;
    }

    public void setSelectedDepartement(Departement selectedDepartement) {
        this.selectedDepartement = selectedDepartement;
    }
    
   
 
    
}