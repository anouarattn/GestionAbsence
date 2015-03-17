package ac.enset.administration.gestionAbsence.controllers;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import ac.enset.administration.gestionAbsence.entites.Departement;
import ac.enset.administration.gestionAbsence.entites.Filiere;
import ac.enset.administration.gestionAbsence.entites.TypeFiliere;
import ac.enset.administration.gestionAbsence.models.ModelBeanFiliere;

@Named
@RequestScoped
public class ControllerBeanFiliere extends ControllerBeanBase<Filiere>
	implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    @Inject
    private ModelBeanFiliere modelBean;

    List<TypeFiliere> typeFilieres;
    List<Departement> departements;

    String departementString;
    String typeFiliereString;

    

    @PostConstruct
    public void init() {
	entityToAdd = new Filiere();
    }

    public void addEntity() throws NotFoundException {
	
	if(!metier.exist(Departement.class, Long.parseLong(departementString)))
		throw new DepartementNotFoundException("Can't find the specified Departement!!");
	if ( metier.exist(TypeFiliere.class, Long.parseLong(typeFiliereString))) 
	    	throw new TypeFiliereNotFoundException("Can't find the specified TypeFiliere");
	
	    metier.ajouterFiliere(entityToAdd, Long.parseLong(departementString)
		 , Long.parseLong(typeFiliereString));
	    modelBean.update();
    }

    public List<Departement> getDepartements() {
	return this.departements = metier.getDepartements();
    }
    public String getDepartementString() {
	return departementString;
    }

    public void setDepartementString(String departementString) {
	this.departementString = departementString;
    }

    public String getTypeFiliereString() {
	return typeFiliereString;
    }

    public void setTypeFiliereString(String typeFiliereString) {
	this.typeFiliereString = typeFiliereString;
    }

    public List<TypeFiliere> getTypeFilieres() {
	return	this.typeFilieres = metier.getTypesFilieres();
    }

    public void setTypeFilieres(List<TypeFiliere> typeFilieres) {
	this.typeFilieres = typeFilieres;
    }

    public void setDepartements(List<Departement> departements) {
	this.departements = departements;
    }
}