package ac.enset.administration.gestionAbsence.models;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import ac.enset.administration.gestionAbsence.entites.Classe;
import ac.enset.administration.gestionAbsence.entites.Filiere;

@Named
@SessionScoped
public class ModelBeanClasse extends ModelBeanBase<Classe> implements Serializable
{

    private static final long serialVersionUID = 1L;


    

@PostConstruct
    public void init() {
       clazz = Classe.class;
	items = metier.get(clazz);
    }



}