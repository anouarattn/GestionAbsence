package beans;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import ejb.Local;
import entites.Personne;

@RequestScoped
@Named
public class Controller {

	@Inject private Local ejb;
	private Personne personne = new Personne("prika");
	
	

	public void setPersonne()
	{
		ejb.addPersonne(personne);
	}

	public Local getEjb() {
		return ejb;
	}

	public void setEjb(Local ejb) {
		this.ejb = ejb;
	}

	public Personne getPersonne() {
		return personne;
	}

	public void setPersonne(Personne personne) {
		this.personne = personne;
	}

	public Controller() {
		super();
		
	}

	public Controller(Local ejb, Personne personne) {
		super();
		this.ejb = ejb;
		this.personne = personne;
	}
	
	
	
}
