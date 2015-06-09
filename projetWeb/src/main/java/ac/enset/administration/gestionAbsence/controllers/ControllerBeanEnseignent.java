package ac.enset.administration.gestionAbsence.controllers;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.commons.codec.binary.Base64;

import ac.enset.administration.gestionAbsence.entites.Departement;
import ac.enset.administration.gestionAbsence.entites.Enseignent;
import ac.enset.administration.gestionAbsence.entites.EntityBase;
import ac.enset.administration.gestionAbsence.metier.PasswordEncryptionService;
import ac.enset.administration.gestionAbsence.models.ModelBeanEnseignent;


@Named
@RequestScoped
public class ControllerBeanEnseignent extends ControllerBeanBase<Enseignent> {

	@Inject
	private PasswordEncryptionService encryptionService;
	
	@Inject
	private ModelBeanEnseignent model;
	

	
	@PostConstruct
	public void init() 
	{
		entityToAdd = new Enseignent();
		
	}
	@Override
	public void addEntity() throws Exception {
		String imageDataString = null;
		if (model.getPhotoFile() != null)
			imageDataString = Base64
					.encodeBase64String(model.getPhotoFile().getContents());
		else 
			imageDataString = model.getDefaultImage();
		entityToAdd.setPhoto(imageDataString);
		entityToAdd.setAuthentication(encryptionService.generateStorablePassword());
		metier.add(entityToAdd);
		model.setPhotoFile(null);
		reset();
		model.update(); 
	}
	public void reset() {
		entityToAdd = new Enseignent();
	}
	
	public List<? extends EntityBase> departements() {
		return metier.get(Departement.class);
	}
	
	
	
}
