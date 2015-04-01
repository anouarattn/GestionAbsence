package ac.enset.administration.gestionAbsence.controllers;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import ac.enset.administration.gestionAbsence.entites.AnneeScolaire;
import ac.enset.administration.gestionAbsence.metier.IAbsenceLocal;


@Named
@RequestScoped
public class ControllerBeanAnneesScolaires extends ControllerBeanBase<AnneeScolaire>
{
    
    

    @PostConstruct
    public void init()
    {
	entityToAdd = new AnneeScolaire();
    }
    
    public List<AnneeScolaire> getAnneesScolaires() {
	return metier.getAnneesScollaires();
    }


    @Override
    public void addEntity() throws NotFoundException {
	
	metier.ajouterAnneeScolaire(entityToAdd);
    }

 
    
}