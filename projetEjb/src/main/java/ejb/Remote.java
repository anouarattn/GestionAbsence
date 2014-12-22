package ejb;

import java.util.List;

import entites.Personne;




@javax.ejb.Remote
public interface Remote {
	public Personne getPersonne();
	public void addPersonne(Personne p);
	

}
