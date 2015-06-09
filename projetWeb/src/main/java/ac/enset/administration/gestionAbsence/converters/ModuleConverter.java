package ac.enset.administration.gestionAbsence.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import ac.enset.administration.gestionAbsence.entites.Module;
import ac.enset.administration.gestionAbsence.metier.IAbsenceLocal;

@FacesConverter("moduleConverter")
public class ModuleConverter implements Converter {

    @Inject
    private IAbsenceLocal metier;
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component,
	    String value) {
	if(value.matches("[0-9]+:([a-zA-Z0-9_-]|\\s)+"))
	{
	    System.out.println("qsdss");
	    System.out.println(metier.get(Module.class, Long.parseLong(value.split(":")[0])));
	   return metier.get(Module.class, Long.parseLong(value.split(":")[0]));
	}
	
	return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component,
	    Object value) {
	if(value instanceof Module)
	{
	    return ((Module)value).getId()+":"+((Module)value).getName();
	}
	return null;
    }

}
