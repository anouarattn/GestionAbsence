package ac.enset.administration.gestionAbsence.controllers;


import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import ac.enset.administration.gestionAbsence.entites.Departement;
import ac.enset.administration.gestionAbsence.entites.Filiere;
import ac.enset.administration.gestionAbsence.models.ModelBeanFiliere;


@Named
@RequestScoped
public class ControllerBeanFiliere extends ControllerBeanBase<Filiere> implements Serializable
{

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

   
    
    @Inject
    private ModelBeanFiliere modelBean;



    @PostConstruct
    public void init() {
	 entityToAdd = new Filiere();
    }
   
    public void addEntity()
    {
	if(entityToAdd != null){
	metier.ajouterFiliere(entityToAdd, entityToAdd.getDepartement().getId(), entityToAdd.getTypeFiliere().getId());;
	modelBean.update();
	}
    }    
}