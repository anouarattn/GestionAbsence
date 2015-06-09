package ac.enset.administration.gestionAbsence.controllers;


import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;


import ac.enset.administration.gestionAbsence.entites.Enseignant;
import ac.enset.administration.gestionAbsence.models.ModelBeanEnseignant;


@Named
@RequestScoped
public class ControllerBeanEnseignant extends ControllerBeanBase<Enseignant> implements Serializable
{

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

   
    @Inject
    private ModelBeanEnseignant modelBean;


    @PostConstruct
    public void init() {
	 entityToAdd = new Enseignant();
    }
   
    public void addEntity()
    {
	if(entityToAdd != null){
	metier.add(entityToAdd);
	modelBean.update();
	}
    }    
}