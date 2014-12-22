package ejb;



import entites.Personne;

@javax.ejb.Local
public interface Local {
	public Personne getPersonne();
	public void addPersonne(Personne p);
}
