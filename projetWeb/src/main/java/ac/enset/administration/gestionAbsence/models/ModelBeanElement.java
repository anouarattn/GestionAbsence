package ac.enset.administration.gestionAbsence.models;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import ac.enset.administration.gestionAbsence.entites.Element;
import ac.enset.administration.gestionAbsence.views.AddElementViewBean;



@SuppressWarnings("serial")
@Named
@SessionScoped
public class ModelBeanElement extends ModelBeanBase<Element> implements Serializable {

	
	@Inject
	private AddElementViewBean addElementViewBean;
	
    @PostConstruct
    public void init() {
	clazz = Element.class;
	//items = metier.get(clazz);
	items = metier.getElementByActivatedYears();
    }
   
}
