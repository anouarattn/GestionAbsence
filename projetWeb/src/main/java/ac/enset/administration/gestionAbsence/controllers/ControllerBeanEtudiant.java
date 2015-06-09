package ac.enset.administration.gestionAbsence.controllers;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.codec.binary.Base64;

import ac.enset.administration.gestionAbsence.entites.Classe;
import ac.enset.administration.gestionAbsence.entites.EntityBase;
import ac.enset.administration.gestionAbsence.entites.Etudiant;
import ac.enset.administration.gestionAbsence.metier.PasswordEncryptionService;
import ac.enset.administration.gestionAbsence.models.ModelBeanEtudiant;

@SuppressWarnings("serial")
@Named
@RequestScoped
public class ControllerBeanEtudiant extends ControllerBeanBase<Etudiant>
		implements Serializable {

	
	@Inject
	private ModelBeanEtudiant model;
	
	@Inject
	private PasswordEncryptionService encryptionService;

	private String defaultImage;
	
	
	@PostConstruct
	public void init() throws IOException {
		entityToAdd = new Etudiant();
//		System.out.println(this.getClass()
//				);
//		defaultImage = Base64.encodeBase64String(IOUtils.toByteArray(this.getClass()
//				.getResourceAsStream("/image-not-found.jpg")));
	}

	@Override
	public void addEntity() throws Exception {

		String imageDataString = null;
		if (model.getPhotoFile() != null)
			imageDataString = Base64
					.encodeBase64String(model.getPhotoFile().getContents());
		else 
			imageDataString = defaultImage;
		entityToAdd.setPhoto(imageDataString);
		entityToAdd.setAuthentication(encryptionService.generateStorablePassword());
		metier.add(entityToAdd);
		model.setPhotoFile(null);
		reset();
		model.update(); 
	}


	public List<? extends EntityBase> classes() {
		return metier.get(Classe.class);
	}

	public void reset() {
		entityToAdd = new Etudiant();
	}


	private Etudiant etudiant ;
	
	 public Etudiant getEtudiant() {
		return etudiant;
	}

	public void setEtudiant(Etudiant etudiant) {
		this.etudiant = etudiant;
	}

	@ManagedProperty(value="#{param.idetu}")
	    private String idetu;
	 
	    
	    public String getIdetu() {
			return idetu;
		}

		public void setIdetu(String idetu) {
			this.idetu = idetu;
		}
		
		private String getidetuFromJSF(FacesContext context) {
			Map<String, String> parameters = context.getExternalContext().getRequestParameterMap();
			
			return parameters.get("idetu");
		}
		
		public String outcome() {
			FacesContext context = FacesContext.getCurrentInstance();
			this.idetu = getidetuFromJSF(context);
					
			HttpServletRequest request = (HttpServletRequest)context.getExternalContext().getRequest();
			HttpSession httpSession = request.getSession(false);
			httpSession.setAttribute("idetu", idetu);
			
			return "absenceetu?facses-redirect=true";
		}
	

}
