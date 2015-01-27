package ac.enset.administration.gestionAbsence.models;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import ac.enset.administration.gestionAbsence.entites.Departement;
import ac.enset.administration.gestionAbsence.metier.IAbsenceLocal;

@Named
@SessionScoped
public class ModelBeanDepartement extends ModelBeanBase<Departement> implements Serializable
{

    private static final long serialVersionUID = 1L;


    

    @PostConstruct
    public void init() {
	items = metier.getDepartements();
    }

    public void modifyEntity() {
	metier.modifierDepartement(selectedEntity);
	items = metier.getDepartements();
	unselect();
    }

    public void deleteEntity() {
	for (Departement entity : selectedEntities) {
	    metier.supprimerDepartement(entity);
	    items.remove(entity);
	}
	unselect();
    }

    public void cancleModifyEntity() {
	items = metier.getDepartements();
	unselect();
    }

    public void update() {
	items = metier.getDepartements();
	unselect();
    }
    
    public void unselect() {
	setSelectedEntities(null);
    }

}