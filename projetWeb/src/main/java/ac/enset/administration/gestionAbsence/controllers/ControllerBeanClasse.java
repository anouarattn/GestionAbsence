package ac.enset.administration.gestionAbsence.controllers;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;
import org.primefaces.context.RequestContext;

import ac.enset.administration.gestionAbsence.converters.StringToAcademicYear;
import ac.enset.administration.gestionAbsence.entites.Classe;
import ac.enset.administration.gestionAbsence.entites.EntityBase;
import ac.enset.administration.gestionAbsence.entites.Filiere;
import ac.enset.administration.gestionAbsence.metier.exception.FiliereNotFoundException;
import ac.enset.administration.gestionAbsence.models.ModelBeanAnneeScolaire;
import ac.enset.administration.gestionAbsence.models.ModelBeanClasse;

@Named
@RequestScoped
public class ControllerBeanClasse extends ControllerBeanBase<Classe> {

    
    @Inject
    private ModelBeanClasse modelBean;
    
    @Inject
    private ModelBeanAnneeScolaire academicYearBean;
    
    @NotEmpty
    @Pattern(regexp="2[0-9]{3}/2[0-9]{3}",message="L'année Scolaire doit être de la forme ex:2014/2015")
    private String promotionAcademicYear;
    
    @NotEmpty
    @Pattern(regexp="2[0-9]{3}/2[0-9]{3}",message="L'année Scolaire doit être de la forme ex:2014/2015")
    private String startAcademicYear;
    
    
    @PostConstruct
    public void init() {
	 entityToAdd = new Classe();
    }

    @Override
    public void addEntity() throws Exception {
	try{
	if (!metier.exist(Filiere.class,entityToAdd.getFiliere().getId())){
	    throw new FiliereNotFoundException(metier.getBundle().getString("FiliereNotFound"));
	}
	entityToAdd.setPromotionAcademicYear(StringToAcademicYear.convert(promotionAcademicYear));
	entityToAdd.setBeginAcademicYear(StringToAcademicYear.convert(startAcademicYear));
	metier.addClasse(entityToAdd);
	modelBean.update();
	getAcademicYearBean().update();
	RequestContext.getCurrentInstance().update("wrapper");
	addSuccessMessage("growl",bundle.getString("addedClasse"),"");
	}catch(Exception e)
	{
    	FacesContext.getCurrentInstance().validationFailed();
    	addErrorMessage(e, "","","addForm:panelGrid");
    	RequestContext.getCurrentInstance().update("addForm");
	}
	
    }
    
    public List<? extends EntityBase> filieres()
    {
	return metier.get(Filiere.class);
    }

    public String getPromotionAcademicYear() {
        return promotionAcademicYear;
    }

    public void setPromotionAcademicYear(String promotionAcademicYear) {
        this.promotionAcademicYear = promotionAcademicYear;
    }

    public String getStartAcademicYear() {
        return startAcademicYear;
    }

    public void setStartAcademicYear(String startAcademicYear) {
        this.startAcademicYear = startAcademicYear;
    }

	public ModelBeanAnneeScolaire getAcademicYearBean() {
		return academicYearBean;
	}

	public void setAcademicYearBean(ModelBeanAnneeScolaire academicYearBean) {
		this.academicYearBean = academicYearBean;
	}


    
}
