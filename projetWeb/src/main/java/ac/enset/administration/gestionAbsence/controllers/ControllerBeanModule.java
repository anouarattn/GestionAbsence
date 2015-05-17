package ac.enset.administration.gestionAbsence.controllers;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import ac.enset.administration.gestionAbsence.entites.EntityBase;
import ac.enset.administration.gestionAbsence.entites.Filiere;
import ac.enset.administration.gestionAbsence.entites.Module;
import ac.enset.administration.gestionAbsence.entites.Semestre;
import ac.enset.administration.gestionAbsence.metier.exception.FiliereNotFoundException;
import ac.enset.administration.gestionAbsence.models.ModelBeanModule;

@SuppressWarnings("serial")
@Named
@RequestScoped
public class ControllerBeanModule extends ControllerBeanBase<Module>
	implements Serializable {

    private Semestre semestre;
    private Filiere filiere;
    
    @Inject
    private ModelBeanModule model;
    
    @PostConstruct
    public void init() {
	 entityToAdd = new Module();
    }
    
    @Override
    public void addEntity() throws Exception {
	
	if (!metier.exist(Filiere.class, filiere.getId()))
	    throw new FiliereNotFoundException(
		    "Can't find the specified Filiere!!");
	entityToAdd.setFiliere(filiere);
	entityToAdd.setSemestre(semestre);
	metier.add(entityToAdd);
	model.update();
    }
    
    
    public Semestre getSemestre() {
        return semestre;
    }
    
    
    public void setSemestre(Semestre semestre)
    {
	this.semestre = semestre;
    }


 
    
    public List<? extends EntityBase> filieres()
    {
	return metier.get(Filiere.class);
    }

    
    public Semestre[] getSemestres()
    {
	return metier.getSemestres();
    }

    public Filiere getFiliere() {
        return filiere;
    }

    public void setFiliere(Filiere filiere) {
        this.filiere = filiere;
    }
    
    


    
    
}