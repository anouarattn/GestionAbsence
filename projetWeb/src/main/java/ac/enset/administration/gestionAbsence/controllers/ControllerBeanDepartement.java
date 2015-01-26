package ac.enset.administration.gestionAbsence.controllers;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;







import ac.enset.administration.gestionAbsence.entites.Departement;
import ac.enset.administration.gestionAbsence.metier.IAbsenceLocal;
import ac.enset.administration.gestionAbsence.models.ModelBeanDepartement;


@Named
@RequestScoped
public class ControllerBeanDepartement implements Serializable
{
    
    private static final long serialVersionUID = 1L;
    
    @Inject
    private ModelBeanDepartement modelBeanDepartement;

    @Inject
    private IAbsenceLocal metier;
    
    private Departement departementToAdd;

    @PostConstruct
    public void init() {
	 
    }
    
    private List<Departement> filtredDepartements;


    public List<Departement> getFiltredDepartements() {
        return filtredDepartements;
    }

    public void setFiltredDepartements(List<Departement> filtredDepartements) {
        this.filtredDepartements = filtredDepartements;
    }

    public Departement getDepartementToAdd() {
	if( departementToAdd == null)
	return departementToAdd = new  Departement();
        return departementToAdd;
    }

    public void setDepartementToAdd(Departement departementToAdd) {
        this.departementToAdd = departementToAdd;
    }
   
    public void ajoutDepartement()
    {
	if(departementToAdd != null){
	metier.ajouterDepartement(departementToAdd);
	modelBeanDepartement.update();
	}
    }
    

    public ModelBeanDepartement getModelBeanDepartement() {
        return modelBeanDepartement;
    }

    public void setModelBeanDepartement(ModelBeanDepartement modelBeanDepartement) {
        this.modelBeanDepartement = modelBeanDepartement;
    }
    
    
}