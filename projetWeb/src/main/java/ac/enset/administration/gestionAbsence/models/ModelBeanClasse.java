package ac.enset.administration.gestionAbsence.models;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.context.RequestContext;

import ac.enset.administration.gestionAbsence.controllers.ControllerBeanClasse;
import ac.enset.administration.gestionAbsence.converters.StringToAcademicYear;
import ac.enset.administration.gestionAbsence.entites.Classe;
import ac.enset.administration.gestionAbsence.entites.Filiere;
import ac.enset.administration.gestionAbsence.metier.exception.FiliereNotFoundException;

@Named
@SessionScoped
public class ModelBeanClasse extends ModelBeanBase<Classe> implements
	Serializable {

    private static final long serialVersionUID = 1L;
    
    private String modifyEntityPromotonAcademicYear;
    private String modifyEntityBeginAcademicYear;

    @Inject
    private ControllerBeanClasse controller;
    
    @PostConstruct
    public void init() {
	clazz = Classe.class;
	items = metier.getClassesByActivatedYears();
    }

    @Override
    public void update() {
	items = metier.getClassesByActivatedYears();
	unselect();
    }

    public String getModifyEntityPromotonAcademicYear() {
	if(modifyEntityBeginAcademicYear == null)
	    return selectedEntity.getPromotionAcademicYear().getAcademicYearAsString();
        return modifyEntityPromotonAcademicYear;
    }

    public void setModifyEntityPromotonAcademicYear(
    	String modifyEntityPromotonAcademicYear) {
        this.modifyEntityPromotonAcademicYear = modifyEntityPromotonAcademicYear;
    }

    public String getModifyEntityBeginAcademicYear() {
	if(modifyEntityBeginAcademicYear == null)
	    return selectedEntity.getBeginAcademicYear().getAcademicYearAsString();
        return modifyEntityBeginAcademicYear;
    }

    public void setModifyEntityBeginAcademicYear(
    	String modifyEntityBeginAcademicYear) {
        this.modifyEntityBeginAcademicYear = modifyEntityBeginAcademicYear;
    }

	@Override
	public void modifyEntity() throws FiliereNotFoundException {
		try{
		if (!metier.exist(Filiere.class,controller.getEntityToAdd().getFiliere().getId())){
		    throw new FiliereNotFoundException(metier.getBundle().getString("FiliereNotFound"));
		}
		controller.getEntityToAdd().setBeginAcademicYear(StringToAcademicYear.convert(modifyEntityBeginAcademicYear));
		controller.getEntityToAdd().setPromotionAcademicYear(StringToAcademicYear.convert(modifyEntityPromotonAcademicYear));
		metier.addClasse(controller.getEntityToAdd());
		update();
		controller.getAcademicYearBean().update();
		RequestContext.getCurrentInstance().update("wrapper");
		addSuccessMessage("growl",bundle.getString("modifiedClasse"),"");
		}catch(Exception e)
		{
	    	FacesContext.getCurrentInstance().validationFailed();
	    	addErrorMessage(e, "","","modifyForm:panelGrid");
	    	RequestContext.getCurrentInstance().update("modifyForm");
		}
	}
    
    
    
    

}