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
import ac.enset.administration.gestionAbsence.entites.Niveau;
import ac.enset.administration.gestionAbsence.entites.Semestre;
import ac.enset.administration.gestionAbsence.entites.TypeFiliere;
import ac.enset.administration.gestionAbsence.entites.User;
import ac.enset.administration.gestionAbsence.metier.exception.IncorrectAcademicYearException;

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
    public void modifierDepartement(Departement item) {
	em.merge(item);
    }


    @Override
    public void modifierFiliere(Filiere item) {
	em.merge(item);
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
    public void addAcademicYear(AnneeScolaire anneeScolaire) throws IncorrectAcademicYearException {
	
	if(!isValidAcademicYear(anneeScolaire))
	    throw new IncorrectAcademicYearException("Incorrect AcademicYear format");
	if (!doesNonManagedAcademicYearExist(anneeScolaire)) {
	    em.persist(anneeScolaire);
	    activateAcademicYear(anneeScolaire);
	    setLastAcademicYear(anneeScolaire);
	    migrateClasses(anneeScolaire);
	}
    }

    private void setLastAcademicYear(AnneeScolaire anneeScolaire) throws IncorrectAcademicYearException {
	AnneeScolaire anneeScolaire2 = getLastAcademicYear();

	if (anneeScolaire2 != null && anneeScolaire2.compareTo(anneeScolaire) == 1){
	    anneeScolaire2.setLast(false);
	    anneeScolaire.setLast(true);
	}
	else if( anneeScolaire2 == null)
	    anneeScolaire.setLast(true);
	else 
	    throw new IncorrectAcademicYearException("Can't add this Academic year because it is greater than the last academic year by more than one year");
	em.merge(anneeScolaire);
    }

    private AnneeScolaire getLastAcademicYear() {
	Query myQuery = em
		.createQuery("SELECT annee FROM AnneeScolaire annee WHERE annee.isLast = true");
	AnneeScolaire anneeScolaire = null;
	try {
	    anneeScolaire = (AnneeScolaire) myQuery.getSingleResult();
	} catch (NoResultException e) {

	}
	return anneeScolaire;
    }

    @Override
    public AnneeScolaire getActivatedAcademicYear() {
	Query myQuery = em
		.createQuery("SELECT annee FROM AnneeScolaire annee WHERE annee.activated = true");
	AnneeScolaire anneeScolaire = null;
	try {
	    anneeScolaire = (AnneeScolaire) myQuery.getSingleResult();
	} catch (NoResultException e) {

	}
	return anneeScolaire;
    }

    @Override
    public void migrateClasses(AnneeScolaire anneeScolaire) {
	List<Classe> classes = (List<Classe>) get(Classe.class);
	Set<Classe> classesAfter = new HashSet<>();
	for (Classe classe : classes)
	    if (classe.getPromotionAcademicYear().compareTo(anneeScolaire) >= 0)
		classesAfter.add(classe);
	anneeScolaire.setClasses(classesAfter);
    }

    @Override
    public List<Classe> getClassesByActivatedYears() {
	Query myQuery = em
		.createQuery("SELECT classe FROM Classe classe WHERE classe.currentAcademicYear.activated = true");
	return myQuery.getResultList();

    }

    @Override
    public void addClasse(Classe classe) throws IncorrectAcademicYearException {
	AnneeScolaire anneeScolaire;
	if ((anneeScolaire = getMergedVersionOfAcademicYear(classe
		.getBeginAcademicYear())) == null && isValidAcademicYear(classe.getBeginAcademicYear()) )
	    em.persist(classe.getBeginAcademicYear());
	else
	    classe.setBeginAcademicYear(anneeScolaire);
	if ((anneeScolaire = getMergedVersionOfAcademicYear(classe
		.getPromotionAcademicYear())) == null && isValidAcademicYear(classe.getBeginAcademicYear()))
	    em.persist(classe.getPromotionAcademicYear());
	else
	    classe.setPromotionAcademicYear(anneeScolaire);
	
	if( !verifyFiliereTypeWithAcademicYears(classe.getFiliere().getTypeFiliere(), classe.getBeginAcademicYear(), classe.getPromotionAcademicYear()))
	    throw new IncorrectAcademicYearException("FiliereType is not consistent with the specified Academic Years");
	classe.setCurrentAcademicYear(classe.getBeginAcademicYear());
	classe.setNiveau(Niveau.PremiereAnnee);
	em.persist(classe);
    }
    
    
    public boolean verifyFiliereTypeWithAcademicYears(TypeFiliere typeFiliere, AnneeScolaire debut,AnneeScolaire promotion)
    {
	int numberOfYear = promotion.getJodaEndYear().getYear() - debut.getJodaBeginYear().getYear();
	System.out.println(numberOfYear);
	System.out.println(typeFiliere.getNumberOfYears() );
	if(typeFiliere.getNumberOfYears() != numberOfYear)
	    return false;
	return true;
    }

    /**
     * this method return the managed version of an AcademicYear or null if no
     * managed version exist managed entity has an ID!!!
     * 
     * @param anneeScolaire
     * @return
     */
    public AnneeScolaire getMergedVersionOfAcademicYear(
	    AnneeScolaire anneeScolaire) {
	for (EntityBase annee : get(AnneeScolaire.class))
	    if (anneeScolaire.equals(annee))
		return (AnneeScolaire) annee;
	return null;
    }

    /**
     * this method check wheather a non managed AcademicYear exist or not
     * 
     * @return
     */
    public boolean doesNonManagedAcademicYearExist(AnneeScolaire anneeScolaire) {
	for (EntityBase annee : get(AnneeScolaire.class))
	    if (anneeScolaire.equals(annee))
		return true;
	return false;
    }
    
    
    /**
     * check wheather the passed AcademicYear is correct
     * @param anneeScolaire
     * @return
     */
    public boolean isValidAcademicYear(AnneeScolaire anneeScolaire)
    {
	if(anneeScolaire == null)
	    return false;
	if(anneeScolaire.getBeginYear() == null || anneeScolaire.getEndYear() == null)
	    return false;
	if(anneeScolaire.getJodaBeginYear().getYear() >= anneeScolaire.getJodaEndYear().getYear())
	    return false;
	return true;
    }
    
    public Semestre[] getSemestres(){
	return new Semestre[]{Semestre.SEMESTRE1,Semestre.SEMESTRE2};
    }


}
