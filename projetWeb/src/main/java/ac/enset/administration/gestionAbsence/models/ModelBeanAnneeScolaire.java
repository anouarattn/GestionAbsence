package ac.enset.administration.gestionAbsence.models;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import ac.enset.administration.gestionAbsence.entites.AnneeScolaire;

@Named
@SessionScoped
public class ModelBeanAnneeScolaire extends ModelBeanBase<AnneeScolaire> implements Serializable{

    @Override
    public void init() {
	clazz = AnneeScolaire.class;
	items = metier.get(clazz);
    }

}
