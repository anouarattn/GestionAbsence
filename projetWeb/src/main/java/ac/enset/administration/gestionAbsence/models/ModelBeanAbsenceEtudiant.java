package ac.enset.administration.gestionAbsence.models;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import ac.enset.administration.gestionAbsence.controllers.ControllerBeanEtudiant;
import ac.enset.administration.gestionAbsence.entites.AbsenceEtud;
import ac.enset.administration.gestionAbsence.entites.Classe;
import ac.enset.administration.gestionAbsence.entites.Etudiant;
import ac.enset.administration.gestionAbsence.entites.Filiere;
import ac.enset.administration.gestionAbsence.entites.Module;

@Named
@SessionScoped
public class ModelBeanAbsenceEtudiant extends ModelBeanBase<AbsenceEtud> implements Serializable
{

    private static final long serialVersionUID = 1L;
    
	
    @PostConstruct
    public void init() {
    	
	clazz = AbsenceEtud.class;
	items = null;
	
    }

 
}