package ac.enset.administration.gestionAbsence.controllers;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import ac.enset.administration.gestionAbsence.entites.Module;
import ac.enset.administration.gestionAbsence.entites.NiveauFiliere;
import ac.enset.administration.gestionAbsence.models.ModelBeanModule;

@Named
@RequestScoped
public class ControllerBeanModule extends ControllerBeanBase<Module>
	implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    @Inject
    private ModelBeanModule modelBean;

    List<NiveauFiliere> niveauFiliere;

    String idniveauFiliere;

    
    
    public List<NiveauFiliere> getNiveauFiliere() {
		
		return this.niveauFiliere = metier.getNiveauFiliere();
	}

	public void setNiveauFiliere(List<NiveauFiliere> niveauFiliere) {
		this.niveauFiliere = niveauFiliere;
	}

	public String getIdniveauFiliere() {
		return idniveauFiliere;
	}

	public void setIdniveauFiliere(String idniveauFiliere) {
		this.idniveauFiliere = idniveauFiliere;
	}

	@PostConstruct
    public void init() {
	entityToAdd = new Module();
    }

    public void addEntity() throws NotFoundException {
    	
    	entityToAdd.getCodemodule();
    	System.out.println(entityToAdd.getCodemodule()+idniveauFiliere);
    	
	    metier.ajouterModule(entityToAdd, Long.parseLong(idniveauFiliere));
	    modelBean.update();
    }
    
    
    
}