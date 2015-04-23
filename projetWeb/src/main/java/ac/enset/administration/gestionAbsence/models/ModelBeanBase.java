package ac.enset.administration.gestionAbsence.models;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import ac.enset.administration.gestionAbsence.entites.EntityBase;
import ac.enset.administration.gestionAbsence.metier.IAbsenceLocal;


public abstract class ModelBeanBase<T> {

    @Inject
    protected IAbsenceLocal metier;
    protected T selectedEntity;
    protected List<? extends EntityBase> items;
    protected List<T> selectedEntities;
    protected Class clazz;
    
    @PostConstruct
    public abstract void init();

    public void unselect() {
	setSelectedEntities(null);
    }

    public void modifyEntity() {
	metier.modify(selectedEntity);
	items =  metier.get(clazz);
	unselect();
    }

    public void deleteEntity() {
	for (T entity : selectedEntities) {
	    metier.remove(entity);
	    items.remove(entity);
	}
	unselect();
    }

    public void cancleModifyEntity()
    {
	update();
    }

    public void update()
    {

	items =  metier.get(clazz);
	unselect();
    }

    public T getSelectedEntity() {
	return selectedEntity;
    }

    public void setSelectedEntity(T selectedEntity) {
	this.selectedEntity = selectedEntity;
    }

    public List<? extends EntityBase> getItems() {
	return items;
    }

    public void setItems(List<? extends EntityBase> items) {
	this.items = items;
    }

    public List<T> getSelectedEntities() {
	return selectedEntities;
    }

    public void setSelectedEntities(List<T> selectedEntities) {
	if (selectedEntities != null && selectedEntities.size() != 0)
	    this.selectedEntity = selectedEntities
		    .get(selectedEntities.size() - 1);
	else
	    this.selectedEntity = null;
	this.selectedEntities = selectedEntities;
    }
}