package ejb;

import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entites.Personne;

@Stateless(name = "ejb/TransportEJBImpl")
@Named("ejbtest")
public class EjbTest implements Local,Remote {

	@PersistenceContext
	EntityManager em;

	@Override
	public Personne getPersonne() {
		Query q = em.createQuery("select c from Personne p");
		return (Personne) q.getResultList().get(0);
	}

	@Override
	public void addPersonne(Personne p) {
		em.persist(p);
	}

}
