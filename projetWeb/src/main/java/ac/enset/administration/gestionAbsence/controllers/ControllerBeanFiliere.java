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
import ac.enset.administration.gestionAbsence.metier.exception.DepartementNotFoundException;
import ac.enset.administration.gestionAbsence.metier.exception.NotFoundException;
import ac.enset.administration.gestionAbsence.metier.exception.TypeFiliereNotFoundException;
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

    String typeFiliereString;
    
    Departement departement;

    @PostConstruct
    public void init() {
	entityToAdd = new Filiere();
    }

    public void addEntity() throws NotFoundException {
	if (!metier.exist(Departement.class, departement.getId()))
	    throw new DepartementNotFoundException(
		    metier.getBundle().getString("DepartementNotFound"));
	if (! typeFilieres.contains(TypeFiliere.valueOf(typeFiliereString)))
	    throw new TypeFiliereNotFoundException(
		    metier.getBundle().getString("TypeFiliereNotFound"));
	entityToAdd.setTypeFiliere(TypeFiliere.valueOf(typeFiliereString));
	entityToAdd.setDepartement(departement);
	metier.add(entityToAdd);
	modelBean.update();
    }

    public List<Departement> getDepartements() {
	return this.departements = metier.getDepartements();
    }
    public String getTypeFiliereString() {
	return typeFiliereString;
    }

    public void setTypeFiliereString(String typeFiliereString) {
	this.typeFiliereString = typeFiliereString;
    }

    public List<TypeFiliere> getTypeFilieres() {
	return this.typeFilieres = metier.getTypesFilieres();
    }

    public void setTypeFilieres(List<TypeFiliere> typeFilieres) {
	this.typeFilieres = typeFilieres;
    }

    public void setDepartements(List<Departement> departements) {
	this.departements = departements;
    }

    public Departement getDepartement() {
        return departement;
    }

    public void setDepartement(Departement departement) {
        this.departement = departement;
    }
    
    
}