package ac.enset.administration.gestionAbsence.controllers;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.IOUtils;

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
		defaultImage = Base64.encodeBase64String(IOUtils.toByteArray(this.getClass()
				.getResourceAsStream("/image-not-found.jpg")));
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


	

}
