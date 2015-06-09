package ac.enset.administration.gestionAbsence.controllers;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import ac.enset.administration.gestionAbsence.entites.AbsenceEtud;
import ac.enset.administration.gestionAbsence.entites.Classe;
import ac.enset.administration.gestionAbsence.entites.Element;
import ac.enset.administration.gestionAbsence.entites.Etudiant;
import ac.enset.administration.gestionAbsence.entites.Module;
import ac.enset.administration.gestionAbsence.models.ModelBeanAbsenceEtudiant;

@Named
@RequestScoped
public class ControllerBeanAbsenceEtudiant extends ControllerBeanBase<AbsenceEtud>
	implements Serializable {
	
    private Element elementModule;
    private List<Element> elementModules = new ArrayList<Element>();
    private String elmmodstring;
    private Etudiant etudiant;
	@Inject
    private ModelBeanAbsenceEtudiant model;
	
	
	
	   private String idetu ;
	   
	   public String getIdetu() {
			return idetu;
		}

		public void setIdetu(String idetu) {
			this.idetu = idetu;
		}
	
	public String getTotalAbsence(){
		
		int toto = 0;
		for(AbsenceEtud sale : absences()) {
			toto+= sale.getNbrheurAbsence();
		}
		return " "+toto;
	}
		
    @PostConstruct
    public void init() {
    
	 entityToAdd = new AbsenceEtud();
	 FacesContext context = FacesContext.getCurrentInstance();
	 HttpServletRequest request = (HttpServletRequest)context.getExternalContext().getRequest();
	 HttpSession httpSession = request.getSession(false);
	 String reqdObj = (String) httpSession.getAttribute("idetu");
	 idetu = reqdObj;
	 setEtudiant((Etudiant) metier.get(Etudiant.class, Long.parseLong(idetu)));
	 
    }
    
    @Override
    public void addEntity() throws Exception {
    	
    	Element elm = (Element) metier.get(Element.class,Long.parseLong(elmmodstring)) ;
    	
    	
    	entityToAdd.setElementModule(elm);
    	Etudiant etu= (Etudiant) metier.get(Etudiant.class, Long.parseLong(this.getIdetu()));
    	entityToAdd.setEtudiant(etu);
	
	
	metier.add(entityToAdd);
	model.update();
	
    }
        
        
    
    public List<Element> getElementModules() {    	
    	
    	Etudiant et= (Etudiant) metier.get(Etudiant.class, Long.parseLong(idetu));
    	Classe cl = (Classe)metier.get(Classe.class, et.getClasse().getId());    	
    	Module ml = (Module)metier.get(Module.class, cl.getId());    	
    	return metier.getElemnentmoduleEtudiant(ml.getId());
    	
	}
    
    public List<AbsenceEtud> absences(){
    	
    	if(!idetu.isEmpty())
    	return metier.getElemnentmoduleEtudiantAbsence(Long.parseLong(idetu));
    	else return null;
    }
    
	public void setElementModules(List<Element> elementModules) {
		this.elementModules = elementModules;
	}

	public Element getElementModule() {
		return elementModule;
	}

	public void setElement(Element elementModule) {
		this.elementModule = elementModule;
	}

	public String getElmmodstring() {
		return elmmodstring;
	}

	public void setElmmodstring(String elmmodstring) {
		this.elmmodstring = elmmodstring;
	}

	public Etudiant getEtudiant() {
		return etudiant;
	}

	public void setEtudiant(Etudiant etudiant) {
		this.etudiant = etudiant;
	}

	
    
}