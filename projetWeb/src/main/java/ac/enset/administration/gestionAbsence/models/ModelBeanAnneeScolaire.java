package ac.enset.administration.gestionAbsence.models;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import ac.enset.administration.gestionAbsence.entites.AnneeScolaire;
import ac.enset.administration.gestionAbsence.entites.EntityBase;

@SuppressWarnings("serial")
@Named
@SessionScoped
public class ModelBeanAnneeScolaire extends ModelBeanBase<AnneeScolaire>
		implements Serializable {

	@Override
	public void init() {
		clazz = AnneeScolaire.class;
		items = metier.get(clazz);
	}

	public String getCurrentAcademicYear() {

		for (EntityBase as : items)
			if (((AnneeScolaire) as).isActivated())
				return "Annee Scolaire "
						+ ((AnneeScolaire) as).getAcademicYearAsString();
		return "N/A";
	}
}
