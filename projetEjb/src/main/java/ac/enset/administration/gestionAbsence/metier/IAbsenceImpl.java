package ac.enset.administration.gestionAbsence.metier;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Set;

import javax.ejb.Stateless;
import javax.persistence.EntityExistsException;
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
import ac.enset.administration.gestionAbsence.metier.exception.IncorrectAcademicYearException;

@Stateless
public class IAbsenceImpl implements IAbsenceLocal {

	protected ResourceBundle bundle = ResourceBundle
			.getBundle("ac.enset.administration.gestionAbsence.properties.IncorrectDataException");

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
	public void ajouterFiliere(Filiere item, Long idDepartement) {
		Departement d = em.find(Departement.class, idDepartement);
		if (d != null) {
			item.setDepartement(d);
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
		ArrayList<TypeFiliere> types = new ArrayList<>();
		types.add(TypeFiliere.MASTER);
		types.add(TypeFiliere.DUT);
		types.add(TypeFiliere.INGENIEUR);
		types.add(TypeFiliere.BTS);
		types.add(TypeFiliere.LICENCEP);
		types.add(TypeFiliere.LICENCE);
		return types;
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

	@Override
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
	public void activateAcademicYear(AnneeScolaire anneeScolaire) {

		AnneeScolaire as = getActivatedAcademicYear();
		if (as != null)
			as.setActivated(false);
		anneeScolaire.setActivated(true);
		em.merge(anneeScolaire);

	}

	@Override
	public void addAcademicYear(AnneeScolaire anneeScolaire)
			throws IncorrectAcademicYearException {

		if (!isValidAcademicYear(anneeScolaire)){
			throw new IncorrectAcademicYearException(
					bundle.getString("IncorrectAcademicYearformat"));
		}
		if (doesNonManagedAcademicYearExist(anneeScolaire))
			throw new IncorrectAcademicYearException(
					bundle.getString("AcademicYearformatAlreadyExists"));

		AnneeScolaire anneeScolaire2;
		if ((anneeScolaire2 = getManagedVersionOfAcademicYear(anneeScolaire)) == null) {
			em.persist(anneeScolaire);
			activateAcademicYear(anneeScolaire);
			setLastAcademicYear(anneeScolaire);
			// migrateClasses(anneeScolaire);
		} else if (anneeScolaire2.isShowable() == false)
			anneeScolaire2.setShowable(true);
	}

	private void setLastAcademicYear(AnneeScolaire anneeScolaire)
			throws IncorrectAcademicYearException {
		AnneeScolaire anneeScolaire2 = getLastAcademicYear();

		if (anneeScolaire2 != null
				&& anneeScolaire2.compareTo(anneeScolaire) == 1) {
			anneeScolaire2.setLast(false);
			anneeScolaire.setLast(true);
		} else if (anneeScolaire2 == null)
			anneeScolaire.setLast(true);
		else
			throw new IncorrectAcademicYearException(
					bundle.getString("GreaterThanTheLastAcademicYearByMoreThanOneYear"));
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

		if (!isValidAcademicYear(classe.getBeginAcademicYear())
				|| !isValidAcademicYear(classe.getBeginAcademicYear()))
			throw new IncorrectAcademicYearException(
					bundle.getString("IncorrectAcademicYearformat"));

		if ((anneeScolaire = getManagedVersionOfAcademicYear(classe
				.getBeginAcademicYear())) == null)
			em.persist(classe.getBeginAcademicYear()); // if no academic year
														// exist add one
		else
			classe.setBeginAcademicYear(anneeScolaire); // else set it in the
														// classe
		if ((anneeScolaire = getManagedVersionOfAcademicYear(classe
				.getPromotionAcademicYear())) == null) {
			classe.getPromotionAcademicYear().setShowable(false);
			em.persist(classe.getPromotionAcademicYear()); // if no academic
															// year exist add
															// one
		} else
			classe.setPromotionAcademicYear(anneeScolaire); // else set it in
															// the classe

		if (!verifyFiliereTypeWithAcademicYears(classe.getFiliere()
				.getTypeFiliere(), classe.getBeginAcademicYear(),
				classe.getPromotionAcademicYear()))
			throw new IncorrectAcademicYearException(
					bundle.getString("FiliereTypeIsNotConsistentWithTheSpecifiedAcademicYears"));
		classe.setCurrentAcademicYear(classe.getBeginAcademicYear());
		classe.setNiveau(Niveau.PremiereAnnee);
		try{
		em.persist(classe);
		}catch(EntityExistsException e){
			em.merge(classe);
			
		}
	}

	public boolean verifyFiliereTypeWithAcademicYears(TypeFiliere typeFiliere,
			AnneeScolaire debut, AnneeScolaire promotion) {
		int numberOfYear = promotion.getJodaEndYear().getYear()
				- debut.getJodaBeginYear().getYear();
		if (typeFiliere.getNumberOfYears() != numberOfYear)
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
	public AnneeScolaire getManagedVersionOfAcademicYear(
			AnneeScolaire anneeScolaire) {
		for (EntityBase annee : get(AnneeScolaire.class))
			if (anneeScolaire.equals(annee))
				return (AnneeScolaire) annee;
		return null;
	}

	/**
	 * this method check wheather a non managed AcademicYear exist in db or not
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
	 * 
	 * @param anneeScolaire
	 * @return
	 */
	public boolean isValidAcademicYear(AnneeScolaire anneeScolaire) {

		if (anneeScolaire == null)
			return false;
		if (anneeScolaire.getBeginYear() == null
				|| anneeScolaire.getEndYear() == null)
			return false;
		if (anneeScolaire.getJodaBeginYear().getYear() >= anneeScolaire
				.getJodaEndYear().getYear())
			return false;
		return true;
	}

	public Semestre[] getSemestres() {
		return new Semestre[] { Semestre.SEMESTRE1, Semestre.SEMESTRE2,
				Semestre.SEMESTRE3, Semestre.SEMESTRE4, Semestre.SEMESTRE5,
				Semestre.SEMESTRE6 };
	}

	@Override
	public ResourceBundle getBundle() {
		return bundle;
	}

	@Override
	public void removeAll(Class<?> clazz) {
		Query q = em.createQuery("delete  from " + clazz.getSimpleName());
		q.executeUpdate();
	}

	@Override
	public void modifyClasse(Classe entityToAdd) {
		// TODO Auto-generated method stub
		
	}
}
