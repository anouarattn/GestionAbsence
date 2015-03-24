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
	clazz = Module.class;
	items = metier.get(clazz);
    }


}