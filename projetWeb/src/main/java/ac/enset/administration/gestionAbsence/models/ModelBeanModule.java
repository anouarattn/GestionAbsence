package ac.enset.administration.gestionAbsence.models;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import ac.enset.administration.gestionAbsence.entites.Filiere;
import ac.enset.administration.gestionAbsence.entites.Module;
import ac.enset.administration.gestionAbsence.metier.exception.FiliereNotFoundException;

@Named
@SessionScoped
public class ModelBeanModule extends ModelBeanBase<Module> implements Serializable
{

    private static final long serialVersionUID = 1L;


    private String filiereString;

    @PostConstruct
    public void init() {
	clazz = Module.class;
	items = metier.get(clazz);
    }
    
    
    

    @Override
    public void modifyEntity() throws FiliereNotFoundException {
	if (!metier.exist(Filiere.class, Long.parseLong(filiereString)))
	    throw new FiliereNotFoundException(
		    metier.getBundle().getString("FiliereNotFound"));
	Filiere filiere = (Filiere) metier.get(Filiere.class,
		Long.parseLong(filiereString));
	selectedEntity.setFiliere(filiere);
	metier.modify(selectedEntity);
	items =  metier.get(clazz);
	unselect();
    }





    public String getFiliereString() {
        return filiereString;
    }




    public void setFiliereString(String filiereString) {
        this.filiereString = filiereString;
    }





    
    
    


}