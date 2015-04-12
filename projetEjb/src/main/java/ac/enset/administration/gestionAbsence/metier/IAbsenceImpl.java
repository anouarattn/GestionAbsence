package ac.enset.administration.gestionAbsence.metier;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
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
    public void ajouterFiliere(Filiere item, Long idDepartement,
	    Long idTypeFiliere) {
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
	em.remove(em.contains(item) ? item : em.merge(item));
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
	em.remove(em.contains(item) ? item : em.merge(item));
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
	em.remove(em.contains(item) ? item : em.merge(item));
    }

    @Override
    public boolean exist(Class<? extends EntityBase> clazz, Long id) {
	return em.find(clazz, id) != null ? true : false;
    }

    @Override
    public List<Classe> getClasses() {
	Query q = em.createQuery("select cls from Classe cls");
	List<Classe> item = q.getResultList();
	return item;
    }

    public List<? extends EntityBase> get(Class<? extends EntityBase> clazz) {
	Query q = em.createQuery("select type from " + clazz.getSimpleName()
		+ " type");
	List<? extends EntityBase> item = q.getResultList();
	return item;
    }

    public void remove(Object entity) {
	em.remove(em.contains(entity) ? entity : em.merge(entity));
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

    @Override
    public void ajouterModule(Module m, long idNiveauFiliere) {

	System.out.println("idNiveauFiliere : " + idNiveauFiliere);

	NiveauFiliere nf = em.find(NiveauFiliere.class, idNiveauFiliere);
	System.out.println("nf.getNom : " + nf.getNom());
	if (nf != null) {
	    m.setNiveauFiliere(nf);
	    em.persist(m);
	} else {
	    System.out.println("is null ");
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
	    Query req = em
		    .createQuery("select u from User u where u.login like :x and u.pass like :y");
	    req.setParameter("x", login);
	    req.setParameter("y", pass);
	    User u = new User();
	    List<User> user = req.getResultList();
	    if (!user.isEmpty())
		for (User us : user)
		    u = us;
	    else
		return false;
	    if (u.getId() >= 1)
		return true;
	    else
		return false;

	} catch (Exception e) {
	    System.err.println("Eror123" + e.getMessage());
	    e.printStackTrace();
	    return false;
	}
    }

    @Override
    public User getUser(String login) {

	Query req = em
		.createQuery("select u from User u where u.login like :x  ");
	req.setParameter("x", login);
	List<User> user = req.getResultList();
	User u = new User();
	for (User us : user) {
	    u = us;
	    System.out.println(us.getId() + " " + us.getLogin());
	}

	if (u == null) {
	    return null;
	} else {
	    return u;
	}
    }

    @Override
    public void activateAcademicYear(AnneeScolaire anneeScolaire) {

	AnneeScolaire as = getActivatedAcademicYear();
	if (as != null)
	    as.setActivated(false);
	anneeScolaire.setActivated(true);
	em.merge(anneeScolaire);

    }

    @Override
    public void addAcademicYear(AnneeScolaire anneeScolaire) {
	String[] years=new String[2];
	if(anneeScolaire.getYearsFormated() != null){
	 years = anneeScolaire.getYearsFormated().split("/");
	}
	else{
	    
	    AnneeScolaire anneeScolaire2 = getLastAcademicYear();
	    years[0] = String.valueOf((anneeScolaire2.getBeginYear()+1));
	    years[1] = String.valueOf((anneeScolaire2.getEndYear()+1));
	    anneeScolaire.setYearsFormated(years[0]+"/"+years[1]);
	}
	anneeScolaire.setBeginYear(Integer.parseInt(years[0]));
	anneeScolaire.setEndYear(Integer.parseInt(years[1]));
	activateAcademicYear(anneeScolaire);
	setLastAcademicYear(anneeScolaire);
	migrateClasses(anneeScolaire);
	em.persist(anneeScolaire);
    }

    private void setLastAcademicYear(AnneeScolaire anneeScolaire) {
	    AnneeScolaire anneeScolaire2 = getLastAcademicYear();
	
	    if(anneeScolaire2 != null)
	    anneeScolaire2.setLast(false);
	    anneeScolaire.setLast(true);
    }
    private AnneeScolaire getLastAcademicYear(){
	  Query myQuery = em.createQuery("SELECT annee FROM AnneeScolaire annee WHERE annee.isLast = true");
	    AnneeScolaire anneeScolaire = null;
	    try{
		 anneeScolaire = (AnneeScolaire)myQuery.getSingleResult();
	    }catch(NoResultException e){
		 
	     }
	    return anneeScolaire;
    }

    @Override
	public AnneeScolaire getActivatedAcademicYear()
	{
	    Query myQuery = em.createQuery("SELECT annee FROM AnneeScolaire annee WHERE annee.activated = true");
	    AnneeScolaire anneeScolaire = null;
	    try{
		 anneeScolaire = (AnneeScolaire)myQuery.getSingleResult();
	    }catch(NoResultException e){
		 
	     }
	    return anneeScolaire;
	}

    @Override
    public void migrateClasses(AnneeScolaire anneeScolaire) {
	List<Classe> classes = (List<Classe>) get(Classe.class);
	Set<Classe> classesAfter = new HashSet<>();
	for (Classe classe : classes)
	    if (Integer.parseInt(classe.getPromotion()) >= anneeScolaire
		    .getEndYear())
		classesAfter.add(classe);
	anneeScolaire.setClasses(classesAfter);
    }

    @Override
    public List<Classe> getClassesByActivatedYears() {
	Query myQuery = em
		.createQuery("SELECT classe FROM Classe classe WHERE classe.anneeScolaire.activated = true");
	return myQuery.getResultList();

    }
    
   

}
