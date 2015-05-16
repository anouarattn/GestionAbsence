package ac.enset.administration.gestionAbsence.controllers;

import javax.annotation.PostConstruct;

import ac.enset.administration.gestionAbsence.entites.Element;

public class ControllerBeanElement extends ControllerBeanBase<Element>{
    
    
    
    @PostConstruct
    public void init()
    {
	entityToAdd = new Element();
    }
    
    @Override
    public void addEntity() throws Exception {
	// TODO Auto-generated method stub
	
    }

}
