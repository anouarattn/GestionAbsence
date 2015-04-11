package ac.enset.administration.gestionAbsence.controllers;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import ac.enset.administration.gestionAbsence.entites.Classe;
import ac.enset.administration.gestionAbsence.entites.EntityBase;
import ac.enset.administration.gestionAbsence.entites.Filiere;
import ac.enset.administration.gestionAbsence.models.ModelBeanClasse;

@Named
@RequestScoped
public class ControllerBeanClasse extends ControllerBeanBase<Classe> {

    private String filiereString;
    
    @Inject
    private ModelBeanClasse modelBean;
    
    @PostConstruct
    public void init() {
	 entityToAdd = new Classe();
    }

    @Override
    public void addEntity() throws NotFoundException {

	if (!metier.exist(Filiere.class, Long.parseLong(filiereString)))
	    throw new DepartementNotFoundException(
		    "Can't find the specified Filiere!!");

	Filiere filiere = (Filiere) metier.get(Filiere.class,
		Long.parseLong(filiereString));
	entityToAdd.setFiliere(filiere);
	entityToAdd.setAnneeScolaire(metier.getActivatedAcademicYear());
	metier.add(entityToAdd);
	modelBean.update();
	
    }

    public String getFiliereString() {
	return filiereString;
    }

    public void setFiliereString(String filiereString) {
	this.filiereString = filiereString;
    }
    
    public List<? extends EntityBase> filieres()
    {
	return metier.get(Filiere.class);
    }
}
