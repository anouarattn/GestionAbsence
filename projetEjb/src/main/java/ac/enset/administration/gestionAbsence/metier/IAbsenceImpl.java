package ac.enset.administration.gestionAbsence.metier;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ac.enset.administration.gestionAbsence.entites.AnneeScolaire;
import ac.enset.administration.gestionAbsence.entites.Classe;
import ac.enset.administration.gestionAbsence.entites.Departement;
import ac.enset.administration.gestionAbsence.entites.EntityBase;
import ac.enset.administration.gestionAbsence.entites.Filiere;
import ac.enset.administration.gestionAbsence.entites.Module;
import ac.enset.administration.gestionAbsence.entites.NiveauFiliere;
import ac.enset.administration.gestionAbsence.entites.TypeFiliere;
import ac.enset.administration.gestionAbsence.entites.User;
 
@Stateless
public class IAbsenceImpl implements IAbsenceLocal {
    @PersistenceContext(unitName = "projetAbsenceTest")
    private EntityManager em;

    @Override
    public void ajouterDepartement(Departement item) {
	if (em.contains(item))
	    em.merge(item);
	else
	    em.persist(item);
	
    }

    @Override
    public void ajouterTypeFiliere(TypeFiliere item) {
	em.persist(item);
    }

    @Override
    public void ajouterFiliere(Filiere item, Long idDepartement, Long idTypeFiliere) {
	Departement d = em.find(Departement.class, idDepartement);
	TypeFiliere tf = em.find(TypeFiliere.class, idTypeFiliere);
	if (d != null && tf != null) {
	    item.setDepartement(d);
	    item.setTypeFiliere(tf);
	    em.persist(item);
	}
    }

    @Override
    public void ajouterNiveauFiliere(NiveauFiliere item, Long idFiliere) {
	Filiere f = em.find(Filiere.class, idFiliere);
	if (f != null) {
	    item.setFiliere(f);
	    em.persist(item);
	}
    }

    @Override
    public void ajouterAnneeScolaire(AnneeScolaire item) {
	em.persist(item);
    }

    @Override
    public void ajouterClasse(Classe item, Long idNiveauFiliere,
	    Long idAnneeScolaire) {
	NiveauFiliere nf = em.find(NiveauFiliere.class, idNiveauFiliere);
	if (nf != null) {
	    item.setNiveauFiliere(nf);
	    em.persist(item);
	}
    }

    public List<AnneeScolaire> getAnneesScollaires() {
	Query q = em.createQuery("select annees from AnneeScolaire annees");
	return q.getResultList();
    }

    public List<Departement> getDepartements() {

	Query q = em.createQuery("select deps from Departement deps");
	List<Departement> items = q.getResultList();
	return items;
    }

    @Override
    public void supprimerDepartement(Departement item) {
	em.remove(em.contains(item) ? item : em
		.merge(item));
    }

    @Override
    public void modifierDepartement(Departement item) {
	em.merge(item);
    }

    
    @Override
    public List<Filiere> getFilieres() {
	Query q = em.createQuery("select fl from Filiere fl");
	List<Filiere> item = q.getResultList();
	return item;
    }

    @Override
    public void modifierFiliere(Filiere item) {
	em.merge(item);
    }

    @Override
    public void supprimerFiliere(Filiere item) {
	em.remove(em.contains(item) ? item : em
		.merge(item));
    }

    @Override
    public List<TypeFiliere> getTypesFilieres() {
	Query q = em.createQuery("select tf from TypeFiliere tf");
	List<TypeFiliere> item = q.getResultList();
	return item;
    }

    @Override
    public void modifierTypeFiliere(TypeFiliere item) {
	em.merge(item);
    }

    @Override
    public void supprimerTypeFiliere(TypeFiliere item) {
	em.remove(em.contains(item) ? item : em
		.merge(item));
    }

    @Override
    public boolean exist(Class<? extends EntityBase> clazz, Long id) {
	return  em.find(clazz, id) != null ? true:false;
    }

    @Override
	public void ajouterModule(Module m, long idNiveauFiliere) {
		
		NiveauFiliere nf = em.find(NiveauFiliere.class, idNiveauFiliere);
		if (nf != null) {
			m.setNiveauFiliere(nf);
			em.persist(m);
		}
		
	}

	@Override
	public List<Module> getModule() {
		Query q = em.createQuery("select m from Module m");
		List<Module> m = q.getResultList();
		return m;
	}

	@Override
	public List<NiveauFiliere> getNiveauFiliere() {
		Query q = em.createQuery("select m from NiveauFiliere m");
		List<NiveauFiliere> m = q.getResultList();
		return m;
	}
	

	@Override
	public boolean User(String login, String pass) {
		try {
			Query req = em.createQuery("select u from User u where u.login like :x and u.pass like :y");
			req.setParameter("x", login);
			req.setParameter("y", pass);
			User u = new User();
			List<User> user = req.getResultList();
			if(!user.isEmpty())
				for(User us:user) u =us;
			else return false;
			if(u.getId()>= 1)
				return true;
			else 
				return false ;
						
		} catch (Exception e) {
			System.err.println("Eror123"+e.getMessage());
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public User getUser(
			String login) {

		Query req = em.createQuery("select u from User u where u.login like :x  ");
		req.setParameter("x", login);
		List<User> user = req.getResultList();
		User u = new User();
		for(User us:user){
			u = us;
			System.out.println(us.getId()+" "+us.getLogin());
		}
		
		if(u == null){
			return null;
		}else {
			return u;
		}
	}


}
