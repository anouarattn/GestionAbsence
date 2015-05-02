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
import ac.enset.administration.gestionAbsence.models.ModelBeanModule;

@SuppressWarnings("serial")
@Named
@RequestScoped
public class ControllerBeanModule extends ControllerBeanBase<Module>
	implements Serializable {

    private Semestre semestre;
    private String filiereString;
    
    @Inject
    private ModelBeanModule model;
    
    @PostConstruct
    public void init() {
	 entityToAdd = new Module();
    }
    
    @Override
    public void addEntity() throws Exception {
	
	if (!metier.exist(Filiere.class, Long.parseLong(filiereString)))
	    throw new FiliereNotFoundException(
		    "Can't find the specified Filiere!!");
	Filiere filiere = (Filiere) metier.get(Filiere.class,
		Long.parseLong(filiereString));
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


    public String getFiliereString() {
        return filiereString;
    }


    public void setFiliereString(String filiereString) {
        this.filiereString = filiereString;
    }
    
    public List<? extends EntityBase> filieres()
    {
	return metier.get(Filiere.class);
    }

    
    public Semestre[] getSemestres()
    {
	return metier.getSemestres();
    }
    
    


    
    
}