package ac.enset.administration.gestionAbsence.controllers;

import java.util.List;

import javax.inject.Inject;

import ac.enset.administration.gestionAbsence.metier.IAbsenceLocal;


public abstract class ControllerBeanBase<V>
{
    @Inject
    protected IAbsenceLocal metier; 
    
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
    
    
    
}