package ac.enset.administration.gestionAbsence.controllers;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import ac.enset.administration.gestionAbsence.entites.Element;
import ac.enset.administration.gestionAbsence.entites.Enseignent;
import ac.enset.administration.gestionAbsence.entites.EntityBase;
import ac.enset.administration.gestionAbsence.entites.Filiere;
import ac.enset.administration.gestionAbsence.entites.Module;
import ac.enset.administration.gestionAbsence.models.ModelBeanElement;


/**
 * 
 * updating selectOneMenu from backing bean problem 
 * http://stackoverflow.com/questions/14898637/populating-a-chlid-jsf-selectonemenu-implicit-value-validation-error
 * http://stackoverflow.com/questions/9069379/validation-error-value-is-not-valid/9069660#9069660
 * @author anouarattn
 *
 */
@SuppressWarnings("serial")
@Named
@RequestScoped
public class ControllerBeanElement extends ControllerBeanBase<Element> implements Serializable {

    
    
	@Inject
	private ModelBeanElement modelBeanElement;
	
    private Filiere filiere;
    private Module module;
    private Enseignent enseignent;
    
    private List<Filiere> filieres;
    private List<Module> modules;


    @PostConstruct
    public void init() {
    	modelBeanElement.unselect();
    }

    @Override
    public void addEntity() throws Exception {
    	entityToAdd.setModule(module);
    	entityToAdd.setEnseignent(enseignent);
    	
    	metier.add(entityToAdd);
    	modelBeanElement.update();
    }

  

    public Module getModule() {
		return module;
	}

	public void setModule(Module module) {
		this.module = module;
	}

	public Enseignent getEnseignent() {
		return enseignent;
	}

	public void setEnseignant(Enseignent enseignent) {
		this.enseignent = enseignent;
	}
    
	

   
    
    public List<Filiere> getFilieres() {
		return filieres;
	}

	public void setFilieres(List<Filiere> filieres) {
		this.filieres = filieres;
	}

	public Filiere getFiliere() {
	return filiere;
    }

    public void setFiliere(Filiere filiere) {
	this.filiere = filiere;
    }

    public void filiereChanged() {
		if(filiere != null){
			modules.clear();
			modules.addAll(filiere.getModules());
		}
    }
    

    public List<? extends EntityBase> enseignents()
    {
	return metier.get(Enseignent.class);
    } 
    
    public List<Module> getModules() {
    	if(filiere != null){
    	    List<Module> list = new ArrayList<Module>();
    	    list.addAll(filiere.getModules());
    	    return list;
    	}
    	return null;
	}

	public void setModules(List<Module> modules) {
		this.modules = modules;
	}



}
