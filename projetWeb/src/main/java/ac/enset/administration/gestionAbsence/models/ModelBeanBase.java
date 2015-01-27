package ac.enset.administration.gestionAbsence.models;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import ac.enset.administration.gestionAbsence.metier.IAbsenceLocal;

public abstract class ModelBeanBase<T> {

    @Inject
    protected IAbsenceLocal metier;
    protected T selectedEntity;
    protected List<T> items;
    protected List<T> selectedEntities;

    @PostConstruct
    public abstract void init();

    public abstract void modifyEntity();

    public abstract void deleteEntity();

    public abstract void cancleModifyEntity();

    public abstract void update();

    public T getSelectedEntity() {
	return selectedEntity;
    }

    public void setSelectedEntity(T selectedEntity) {
	this.selectedEntity = selectedEntity;
    }

    public List<T> getItems() {
	return items;
    }

    public void setItems(List<T> items) {
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