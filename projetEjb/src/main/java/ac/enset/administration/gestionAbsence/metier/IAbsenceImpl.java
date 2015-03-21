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
import ac.enset.administration.gestionAbsence.entites.TypeFiliere;
 
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
    public void ajouterAnneeScolaire(AnneeScolaire item) {
	em.persist(item);
    }

    @Override
    public void ajouterClasse(Classe item, Long idNiveauFiliere,
	    Long idAnneeScolaire) {
	
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
    public List<Classe> getClasses() {
	Query q = em.createQuery("select cls from Classe cls");
	List<Classe> item = q.getResultList();
	return item;
    }
    
    public List<? extends EntityBase> get(Class<? extends EntityBase> clazz)
    {
	Query q = em.createQuery("select type from "+ clazz.getSimpleName() +" type");
	List<? extends EntityBase> item = q.getResultList();
	return item;
    }
    
    public void remove(Object entity)
    {
	em.remove(em.contains(entity) ? entity : em
		.merge(entity));
    }

    @Override
    public void modify(Object selectedEntity) {
	em.merge(selectedEntity);
    }

    @Override
    public void add(Object entity) {
	if (em.contains(entity))
	    em.merge(entity);
	else
	    em.persist(entity);
    }

    @Override
    public EntityBase get(Class<? extends EntityBase> clazz, Long id) {
	return em.find(clazz, id);
    }


}
