package ac.enset.administration.gestionAbsence.controllers;


import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;










import ac.enset.administration.gestionAbsence.entites.Departement;
import ac.enset.administration.gestionAbsence.models.ModelBeanDepartement;


@Named
@RequestScoped
public class ControllerBeanDepartement extends ControllerBeanBase<Departement> implements Serializable
{

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

   
    
    @Inject
    private ModelBeanDepartement modelBean;



    @PostConstruct
    public void init() {
	 entityToAdd = new Departement();
    }
   
    public void addEntity()
    {
	if(entityToAdd != null){
	metier.ajouterDepartement(entityToAdd);
	modelBean.update();
	}
    }    
}