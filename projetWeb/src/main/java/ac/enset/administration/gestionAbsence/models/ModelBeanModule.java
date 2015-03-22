package ac.enset.administration.gestionAbsence.models;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import ac.enset.administration.gestionAbsence.entites.Module;

@Named
@SessionScoped
public class ModelBeanModule extends ModelBeanBase<Module> implements Serializable
{

    private static final long serialVersionUID = 1L;


    

    @PostConstruct
    public void init() {
	items = metier.getModule();
    }

    public void modifyEntity() {
	//metier.modifierFiliere(selectedEntity);
	items = metier.getModule();
	unselect();
    }

    public void deleteEntity() {
	for (Module entity : selectedEntities) {
	    //metier.supprimerFiliere(entity);
	    items.remove(entity);
	}
	unselect();
    }

    public void cancleModifyEntity() {
	items = metier.getModule();
	unselect();
    }

    public void update() {
	items = metier.getModule();
	unselect();
    }
    
    public void unselect() {
	setSelectedEntities(null);
    }

}