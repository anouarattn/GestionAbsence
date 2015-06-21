package ac.enset.administration.gestionAbsence.models;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

import ac.enset.administration.gestionAbsence.entites.Etudiant;

@SuppressWarnings("serial")
@Named
@SessionScoped
public class ModelBeanEtudiant extends ModelBeanBase<Etudiant> implements Serializable {

	private UploadedFile photoFile;

	@Override
	public void init() {
		clazz = Etudiant.class;
		//items = metier.get(clazz);
		items = metier.getEtudiantByActivatedYears();
	}

	public UploadedFile getPhotoFile() {
		return photoFile;
	}

	public void setPhotoFile(UploadedFile photoFile) {
		this.photoFile = photoFile;
	}

	public void photoAdded(FileUploadEvent event)
	{
		this.photoFile = event.getFile();
	}

}
