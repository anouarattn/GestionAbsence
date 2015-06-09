package ac.enset.administration.gestionAbsence.views;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import org.omnifaces.cdi.ViewScoped;

import ac.enset.administration.gestionAbsence.entites.Element;
import ac.enset.administration.gestionAbsence.entites.Filiere;
import ac.enset.administration.gestionAbsence.entites.Module;
import ac.enset.administration.gestionAbsence.metier.IAbsenceLocal;
import ac.enset.administration.gestionAbsence.models.ModelBeanElement;


/**
 * 
 * updating selectOneMenu from backing bean problem 
 * http://stackoverflow.com/questions/14898637/populating-a-chlid-jsf-selectonemenu-implicit-value-validation-error
 * http://stackoverflow.com/questions/9069379/validation-error-value-is-not-valid/9069660#9069660
 * @author anouarattn
 *
 */

@Named
@ViewScoped
public class AddElementViewBean implements Serializable {
	
	
	@Inject
    private IAbsenceLocal metier;
	@Inject
	private ModelBeanElement modelBeanElement;
	
	private Element entityToAdd;
	private Filiere filiere;
	
	private List<Filiere> filieres;
    private List<Module> modules;
    
    @PostConstruct
    public void init() {
	entityToAdd = new Element();
	filieres =(List<Filiere>) metier.get(Filiere.class);
	modules= new ArrayList<Module>();
    }

    
	public Element getEntityToAdd() {
		return entityToAdd;
	}
	public void setEntityToAdd(Element entityToAdd) {
		this.entityToAdd = entityToAdd;
	}
	public Filiere getFiliere() {
		return filiere;
	}
	public void setFiliere(Filiere filiere) {
		this.filiere = filiere;
	}
	public List<Filiere> getFilieres() {
		return filieres;
	}
	public void setFilieres(List<Filiere> filieres) {
		this.filieres = filieres;
	}
	 public List<Module> getModules() {
	    	if(filiere != null){
	    	    List<Module> list = new ArrayList<Module>();
	    	    list.addAll(filiere.getModules());
	    	    return list;
	    	}
	    	return new ArrayList<Module>();
		}
	public void setModules(List<Module> modules) {
		this.modules = modules;
	}
	 public void addEntity() throws Exception {
	    	metier.add(entityToAdd);
	    	modelBeanElement.update();
	    	reset();
	    }
    
	 public void filiereChanged() {
			if(filiere != null){
				modules.clear();
				modules.addAll(filiere.getModules());
			}
		    }
	 
	 
	 public void reset()
	 {
		entityToAdd = new Element();
		filiere = null;
		filieres =(List<Filiere>) metier.get(Filiere.class);
		modules= new ArrayList<Module>();
	 }


}
