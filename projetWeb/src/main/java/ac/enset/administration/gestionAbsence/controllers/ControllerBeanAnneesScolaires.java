package ac.enset.administration.gestionAbsence.controllers;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import ac.enset.administration.gestionAbsence.entites.AnneeScolaire;
import ac.enset.administration.gestionAbsence.models.ModelBeanAnneeScolaire;


@Named
@RequestScoped
public class ControllerBeanAnneesScolaires extends ControllerBeanBase<AnneeScolaire>
{
    @Inject
    private ModelBeanAnneeScolaire modelBean;

    @PostConstruct
    public void init()
    {
	entityToAdd = new AnneeScolaire();
    }
    
 


    @Override
    public void addEntity() throws NotFoundException {
	metier.addAcademicYear(entityToAdd);
	modelBean.update();
    }

    
    
 
    
}