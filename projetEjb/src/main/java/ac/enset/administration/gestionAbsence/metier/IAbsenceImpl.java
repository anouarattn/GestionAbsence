package ac.enset.administration.gestionAbsence.metier;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ac.enset.administration.gestionAbsence.entites.AnneeScolaire;
import ac.enset.administration.gestionAbsence.entites.Classe;
import ac.enset.administration.gestionAbsence.entites.Departement;
import ac.enset.administration.gestionAbsence.entites.Filiere;
import ac.enset.administration.gestionAbsence.entites.NiveauFiliere;
import ac.enset.administration.gestionAbsence.entites.TypeFiliere;

@Stateless
public class IAbsenceImpl implements IAbsenceLocal {
    @PersistenceContext(unitName = "projetAbsenceTest")
    private EntityManager em;

    @Override
    public void ajouterDepartement(Departement d) {
	if (em.contains(d))
	    em.merge(d);
	else
	    em.persist(d);
	
    }

    @Override
    public void ajouterTypeFiliere(TypeFiliere tf) {
	em.persist(tf);
    }

    @Override
    public void ajouterFiliere(Filiere f, Long idDepartement, Long idTypeFiliere) {
	Departement d = em.find(Departement.class, idDepartement);
	TypeFiliere tf = em.find(TypeFiliere.class, idTypeFiliere);
	// test la condition : l'objet filière doit avoir un typeFiliere et
	// Departement non null
	if (d != null && tf != null) {
	    f.setDepartement(d);
	    f.setTypeFiliere(tf);
	    em.persist(f);
	}
    }

    @Override
    public void ajouterNiveauFiliere(NiveauFiliere nf, Long idFiliere) {
	Filiere f = em.find(Filiere.class, idFiliere);
	if (f != null) {
	    nf.setFiliere(f);
	    em.persist(nf);
	}
    }

    @Override
    public void ajouterAnneeScolaire(AnneeScolaire as) {
	em.persist(as);
    }

    @Override
    public void ajouterClasse(Classe c, Long idNiveauFiliere,
	    Long idAnneeScolaire) {
	NiveauFiliere nf = em.find(NiveauFiliere.class, idNiveauFiliere);
	if (nf != null) {
	    c.setNiveauFiliere(nf);
	    em.persist(c);
	}
    }

    public List<AnneeScolaire> getAnneesScollaires() {
	Query q = em.createQuery("select annees from AnneeScolaire annees");
	return q.getResultList();
    }

    public List<Departement> getDepartements() {

	Query q = em.createQuery("select deps from Departement deps");
	List<Departement> deps = q.getResultList();
	return deps;
    }

    @Override
    public void supprimerDepartement(Departement departement) {
	em.remove(em.contains(departement) ? departement : em
		.merge(departement));
    }

    @Override
    public void modifierDepartement(Departement departement) {
	em.merge(departement);
    }

}