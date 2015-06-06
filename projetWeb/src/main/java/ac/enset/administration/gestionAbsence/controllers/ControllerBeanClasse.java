package ac.enset.administration.gestionAbsence.controllers;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

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
    
    private String promotionAcademicYear;
    private String startAcademicYear;
    
    private Filiere filiere;
    
    @PostConstruct
    public void init() {
	 entityToAdd = new Classe();
    }

    @Override
    public void addEntity() throws Exception {

	try{
	if (!metier.exist(Filiere.class, filiere.getId()))
	    throw new FiliereNotFoundException(metier.getBundle().getString("FiliereNotFound"));
	entityToAdd.setFiliere(filiere);
	entityToAdd.setPromotionAcademicYear(StringToAcademicYear.convert(promotionAcademicYear));
	entityToAdd.setBeginAcademicYear(StringToAcademicYear.convert(startAcademicYear));
	metier.addClasse(entityToAdd);
	modelBean.update();
	academicYearBean.update();
	}catch(Exception e)
	{
	    addErrorMessage(e, "", "");
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

    public Filiere getFiliere() {
        return filiere;
    }

    public void setFiliere(Filiere filiere) {
        this.filiere = filiere;
    }    
    
}
