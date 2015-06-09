package ac.enset.administration.gestionAbsence.models;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import ac.enset.administration.gestionAbsence.entites.Departement;
import ac.enset.administration.gestionAbsence.entites.Enseignant;

@Named
@SessionScoped
public class ModelBeanEnseignant extends ModelBeanBase<Enseignant> implements Serializable
{

    private static final long serialVersionUID = 1L;
   


    

    @PostConstruct
    public void init() {
	clazz = Enseignant.class;
	items = metier.get(clazz);
    }

    

}