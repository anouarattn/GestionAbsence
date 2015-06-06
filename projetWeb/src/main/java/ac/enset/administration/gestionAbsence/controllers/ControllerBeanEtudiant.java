package ac.enset.administration.gestionAbsence.controllers;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.commons.codec.binary.Base64;

import ac.enset.administration.gestionAbsence.entites.Classe;
import ac.enset.administration.gestionAbsence.entites.EntityBase;
import ac.enset.administration.gestionAbsence.entites.Etudiant;
import ac.enset.administration.gestionAbsence.models.ModelBeanEtudiant;

@SuppressWarnings("serial")
@Named
@RequestScoped
public class ControllerBeanEtudiant extends ControllerBeanBase<Etudiant>
		implements Serializable {

	
	@Inject
	private ModelBeanEtudiant model;
	
 
	@PostConstruct
	public void init() {
		entityToAdd = new Etudiant();
	}

	@Override
	public void addEntity() throws Exception {
		String imageDataString = null;
		if (model.getPhotoFile() != null)
			imageDataString = Base64
					.encodeBase64String(model.getPhotoFile().getContents());
		System.out.println(imageDataString);
		entityToAdd.setPhoto(imageDataString);
		metier.add(entityToAdd);
		model.update(); 
		System.out.println("dd");
	}


	public List<? extends EntityBase> classes() {
		return metier.get(Classe.class);
	}

	public void reset() {
		entityToAdd = new Etudiant();
	}


	

}
