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
import ac.enset.administration.gestionAbsence.metier.exception.FiliereNotFoundException;
import ac.enset.administration.gestionAbsence.models.ModelBeanElement;

@SuppressWarnings("serial")
@Named
@ViewScoped
public class ModifyElementViewBean implements Serializable {

	@Inject
	private IAbsenceLocal metier;

	@Inject
	private ModelBeanElement modelBeanElement;

	private Filiere filiere;

	private List<Filiere> filieres;
	private List<Module> modules;

	private Element selectedEntity;

	@PostConstruct
	public void init() {
		filieres = (List<Filiere>) metier.get(Filiere.class);
		modules = new ArrayList<Module>();
	}

	public Element getSelectedEntity() {
		 selectedEntity = modelBeanElement.getSelectedEntity();
		 if(selectedEntity == null)
			 return new Element();
		 return selectedEntity;
	}

	public void setSelectedEntity(Element selectedEntity) {
		this.selectedEntity = selectedEntity;
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
		if (filiere != null) {
			List<Module> list = new ArrayList<Module>();
			list.addAll(filiere.getModules());
			return list;
		}
		return new ArrayList<Module>();
	}

	public void setModules(List<Module> modules) {
		this.modules = modules;
	}

	public void filiereChanged() {
		if (filiere != null) {
			modules.clear();
			modules.addAll(filiere.getModules());
		}
	}

	public void reset() {
		filiere = null;
		filieres = (List<Filiere>) metier.get(Filiere.class);
		modules = new ArrayList<Module>();
		selectedEntity = null;
	}

	public ModelBeanElement getModelBeanElement() {
		return modelBeanElement;
	}

	public void setModelBeanElement(ModelBeanElement modelBeanElement) {
		this.modelBeanElement = modelBeanElement;
	}

	public void modifyEntity() {
		metier.modify(selectedEntity);
		modelBeanElement.update();
		modelBeanElement.unselect();
	}

}
