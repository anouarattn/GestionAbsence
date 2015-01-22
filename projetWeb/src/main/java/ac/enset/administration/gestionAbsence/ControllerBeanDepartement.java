package ac.enset.administration.gestionAbsence.controllers;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;



import ac.enset.administration.gestionAbsence.entites.Departement;


@Named
@RequestScoped
public class ControllerBeanDepartement implements Serializable
{
  
    private static final long serialVersionUID = 1L;

    
    private List<Departement> filtredDepartements;

    public List<Departement> getFiltredDepartements() {
        return filtredDepartements;
    }

    public void setFiltredDepartements(List<Departement> filtredDepartements) {
        this.filtredDepartements = filtredDepartements;
    }
    
}