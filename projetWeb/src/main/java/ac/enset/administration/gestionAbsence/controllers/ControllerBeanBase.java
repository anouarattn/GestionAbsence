package ac.enset.administration.gestionAbsence.controllers;

import java.util.List;
import java.util.ResourceBundle;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import ac.enset.administration.gestionAbsence.metier.IAbsenceLocal;


public abstract class ControllerBeanBase<V>
{
    @Inject
    protected IAbsenceLocal metier; 
    
    protected final static ResourceBundle bundle = ResourceBundle.getBundle("ac.enset.administration.gestionAbsence.properties.successFrench");
    

    protected V entityToAdd;

    protected List<V> filtredEntities;
    
  
    

    public abstract void addEntity() throws Exception;

    public V getEntityToAdd() {
        return entityToAdd;
    }


    public void setEntityToAdd(V entityToAdd) {
	System.out.println(entityToAdd);
        this.entityToAdd = entityToAdd;
    }


    public List<V> getFiltredEntities() {
        return filtredEntities;
    }


    public void setFiltredEntities(List<V> filtredEntities) {
        this.filtredEntities = filtredEntities;
    }
    
  
    protected void addSuccessMessage(String msg,String msg2) {
	    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, msg, msg2));
	  }

	  protected void addErrorMessage(Throwable e, String msg, String msg2) {
	      FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,  e.getMessage(), e.getMessage()));
	  }
    
}