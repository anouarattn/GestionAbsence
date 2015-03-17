package ac.enset.administration.gestionAbsence.models;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import ac.enset.administration.gestionAbsence.entites.Filiere;

@Named
@SessionScoped
public class ModelBeanFiliere extends ModelBeanBase<Filiere> implements Serializable
{

    private static final long serialVersionUID = 1L;


    

    @PostConstruct
    public void init() {
	items = metier.getFilieres();
    }

    public void modifyEntity() {
	metier.modifierFiliere(selectedEntity);
	items = metier.getFilieres();
	unselect();
    }

    public void deleteEntity() {
	for (Filiere entity : selectedEntities) {
	    metier.supprimerFiliere(entity);
	    items.remove(entity);
	}
	unselect();
    }

    public void cancleModifyEntity() {
	items = metier.getFilieres();
	unselect();
    }

    public void update() {
	items = metier.getFilieres();
	unselect();
    }
    
    public void unselect() {
	setSelectedEntities(null);
    }

}