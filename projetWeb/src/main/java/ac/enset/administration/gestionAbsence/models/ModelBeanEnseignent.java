package ac.enset.administration.gestionAbsence.models;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.IOUtils;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

import ac.enset.administration.gestionAbsence.entites.Enseignent;
@SuppressWarnings("serial")
@Named
@SessionScoped
public class ModelBeanEnseignent extends ModelBeanBase<Enseignent> implements Serializable {

	private UploadedFile photoFile;
	private String defaultImage;


	@Override
	public void init() {	
		clazz = Enseignent.class;
		items = metier.get(Enseignent.class);
		
		try {
			
			InputStream ee = Thread.currentThread().getContextClassLoader().getResourceAsStream("image-not-found.jpg");
			defaultImage = Base64.encodeBase64String(IOUtils.toByteArray(ee));
		} catch (IOException e) {
			e.printStackTrace();
		}
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
	public String getDefaultImage() {
		return defaultImage;
	}
	public void setDefaultImage(String defaultImage) {
		this.defaultImage = defaultImage;
	}
	
	
	
}
