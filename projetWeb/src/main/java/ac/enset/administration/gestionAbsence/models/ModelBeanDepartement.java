package ac.enset.administration.gestionAbsence.models;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import ac.enset.administration.gestionAbsence.entites.Departement;

@Named
@SessionScoped
public class ModelBeanDepartement extends ModelBeanBase<Departement> implements Serializable
{

    private static final long serialVersionUID = 1L;
   


    

    @PostConstruct
    public void init() {
	clazz = Departement.class;
	items = metier.getDepartements();
    }

    

}