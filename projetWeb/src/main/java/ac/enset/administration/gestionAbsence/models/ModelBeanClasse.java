package ac.enset.administration.gestionAbsence.models;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import ac.enset.administration.gestionAbsence.entites.Classe;

@Named
@SessionScoped
public class ModelBeanClasse extends ModelBeanBase<Classe> implements
	Serializable {

    private static final long serialVersionUID = 1L;
    
    private String modifyEntityPromotonAcademicYear;
    private String modifyEntityBeginAcademicYear;

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
    
    

}