package ac.enset.administration.gestionAbsence.models;

import ac.enset.administration.gestionAbsence.entites.Element;

public class ModelBeanElement extends ModelBeanBase<Element> {

    @Override
    public void init() {
	clazz = Element.class;
	items = metier.get(clazz);
    }

    
}
