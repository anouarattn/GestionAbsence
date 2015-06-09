package ac.enset.administration.gestionAbsence;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import org.omnifaces.cdi.ViewScoped;
import org.primefaces.context.RequestContext;

import ac.enset.administration.gestionAbsence.entites.Element;
import ac.enset.administration.gestionAbsence.entites.Filiere;
import ac.enset.administration.gestionAbsence.entites.Module;
import ac.enset.administration.gestionAbsence.metier.IAbsenceLocal;


@Named
@ViewScoped
public class ViewBeanElement implements Serializable {

    
    private static final long serialVersionUID = 1L;


    @Inject
    private IAbsenceLocal metier;

        
        private Module module;
        
        private Element entityToAdd;
        private Filiere filiere;


        @PostConstruct
        public void init() {
            entityToAdd = new Element();
        }

        public void addEntity() throws Exception {
    	System.out.println(module);
    	
        }

      
       

        public List<?> getFilieres() {
    	return metier.get(Filiere.class);
        }
        public Filiere getFiliere() {
    	return filiere;
        }

        public void setFiliere(Filiere filiere) {
    	this.filiere = filiere;
        }

        public void filiereChanged() {
    	if(filiere != null)
    	RequestContext.getCurrentInstance().update("addForm:modulesMenu");
    	
        }
        
        
        
        public List<?> getModules()
        {
    	if(filiere != null){
    	    List<Module> list = new ArrayList<Module>();
    	    list.addAll(filiere.getModules());
    	    return list;
    	}
    	return null;
        }

        public Module getModule() {
            return module;
        }

        public void setModule(Module module) {
            this.module = module;
        }

	public Element getEntityToAdd() {
	    return entityToAdd;
	}

	public void setEntityToAdd(Element entityToAdd) {
	    this.entityToAdd = entityToAdd;
	}


        
    

}
