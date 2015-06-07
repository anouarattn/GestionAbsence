package ac.enset.administration.gestionAbsence.controllers;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotBlank;
import org.primefaces.context.RequestContext;

import ac.enset.administration.gestionAbsence.converters.StringToAcademicYear;
import ac.enset.administration.gestionAbsence.entites.AnneeScolaire;
import ac.enset.administration.gestionAbsence.metier.exception.IncorrectAcademicYearException;
import ac.enset.administration.gestionAbsence.models.ModelBeanAnneeScolaire;
import ac.enset.administration.gestionAbsence.models.ModelBeanClasse;
import ac.enset.administration.gestionAbsence.models.ModelBeanEtudiant;


@Named
@RequestScoped
public class ControllerBeanAnneesScolaires extends ControllerBeanBase<AnneeScolaire>
{
    @Inject
    private ModelBeanAnneeScolaire modelBean;
    
    @Inject
    private ModelBeanClasse modelBeanClasse;
    
    @Inject
    private ModelBeanEtudiant modelBeanEtudiant;
    
    @NotBlank
    @Pattern(regexp="2[0-9]{3}/2[0-9]{3}",message="L'année Scolaire doit être de la forme ex:2014/2015")
    private String academicYear;
    
    @PostConstruct
    public void init()
    {
	entityToAdd = new AnneeScolaire();
	academicYear = "";
    }
    
 

    
    @Override
    public void addEntity() throws IncorrectAcademicYearException {
        try{
	entityToAdd = StringToAcademicYear.convert(academicYear);
	metier.addAcademicYear(entityToAdd);
	modelBean.update();
	RequestContext.getCurrentInstance().update("wrapper");
	addSuccessMessage("growl",bundle.getString("addedAcademicYear"),"");

        }catch(Exception e)
        {
        	FacesContext.getCurrentInstance().validationFailed();
        	e.printStackTrace();
            addErrorMessage(e, "","","addAnneeScolaireForm:item1Msg");
        	RequestContext.getCurrentInstance().update("wrapper");

        	//RequestContext.getCurrentInstance().update("addAnneeScolaireForm");
        }finally{
        	academicYear = "";
        }
    }
    
    public void activateAcademicYear(AnneeScolaire anneeScolaire)
    {	
	metier.activateAcademicYear(anneeScolaire);
	modelBeanClasse.setItems(metier.getClassesByActivatedYears());
	modelBean.update();	
    }




    public String getAcademicYear() {
        return academicYear;
    }




    public void setAcademicYear(String academicYear) {
        this.academicYear = academicYear;
    }
    

    
}