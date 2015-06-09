package ac.enset.administration.gestionAbsence.models;

import java.util.List;
import java.util.ResourceBundle;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import org.apache.commons.lang.StringEscapeUtils;

import ac.enset.administration.gestionAbsence.entites.EntityBase;
import ac.enset.administration.gestionAbsence.metier.IAbsenceLocal;
import ac.enset.administration.gestionAbsence.metier.exception.FiliereNotFoundException;


public abstract class ModelBeanBase<T> {

    @Inject
    protected IAbsenceLocal metier;
    protected T selectedEntity;
    protected List<? extends EntityBase> items;
    protected List<T> selectedEntities;
    protected Class clazz;
    protected final static ResourceBundle bundle = ResourceBundle.getBundle("ac.enset.administration.gestionAbsence.properties.successFrench");

    @PostConstruct
    public abstract void init();

    public void unselect() {
	setSelectedEntities(null);
    }

    public void modifyEntity() throws FiliereNotFoundException {
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
    
    
    protected void addSuccessMessage(String formID, String msg,String msg2) {
	    FacesContext.getCurrentInstance().addMessage(formID, new FacesMessage(FacesMessage.SEVERITY_INFO, msg, msg2));
	  }

	  protected void addErrorMessage(Throwable e, String msg, String msg2,String formID) {
	      FacesContext.getCurrentInstance().addMessage(formID, new FacesMessage(FacesMessage.SEVERITY_ERROR,  StringEscapeUtils.unescapeJava(e.getMessage()), StringEscapeUtils.unescapeJava(e.getMessage())));
	  }
}