package ac.enset.administration.gestionAbsence.metier;

import java.util.List;
import java.util.ResourceBundle;

import javax.ejb.Local;

import ac.enset.administration.gestionAbsence.entites.AbsenceEtud;
import ac.enset.administration.gestionAbsence.entites.AnneeScolaire;
import ac.enset.administration.gestionAbsence.entites.Classe;
import ac.enset.administration.gestionAbsence.entites.Departement;
import ac.enset.administration.gestionAbsence.entites.Element;
import ac.enset.administration.gestionAbsence.entites.EntityBase;
import ac.enset.administration.gestionAbsence.entites.Etudiant;
import ac.enset.administration.gestionAbsence.entites.Filiere;
import ac.enset.administration.gestionAbsence.entites.Module;
import ac.enset.administration.gestionAbsence.entites.Semestre;
import ac.enset.administration.gestionAbsence.entites.TypeFiliere;
import ac.enset.administration.gestionAbsence.metier.exception.IncorrectAcademicYearException;

@Local
public interface IAbsenceLocal {

	public void ajouterDepartement(Departement d);

	public void ajouterFiliere(Filiere f, Long idDepartement);

	public void ajouterAnneeScolaire(AnneeScolaire as);

	public List<AnneeScolaire> getAnneesScollaires();

	public List<Departement> getDepartements();

	public void modifierDepartement(Departement departement);

	public void modifierFiliere(Filiere selectedFiliere);

	public boolean exist(Class<? extends EntityBase> clazz, Long id);

	public List<Classe> getClasses();

	public void remove(Object entity);

	public void modify(Object selectedEntity);

	public void add(Object entity);

	public void activateAcademicYear(AnneeScolaire anneeScolaire);

	public void addAcademicYear(AnneeScolaire anneeScolaire)
			throws IncorrectAcademicYearException;

	public AnneeScolaire getActivatedAcademicYear();

	public Long getStatistiqueEtudiantbyYears(Long id, String genre);

	public List<? extends EntityBase> get(Class<? extends EntityBase> clazz);

	public EntityBase get(Class<? extends EntityBase> clazz, Long id);

	public void migrateClasses(AnneeScolaire anneeScolaire);

	public List<Classe> getClassesByActivatedYears();

	public void addClasse(Classe classe) throws IncorrectAcademicYearException;

	public Semestre[] getSemestres();

	public List<TypeFiliere> getTypesFilieres();

	public ResourceBundle getBundle();

	public void removeAll(Class<?> clazz);

	public void modifyClasse(Classe entityToAdd);

	public List<Etudiant> getEtudiantByActivatedYears();

	public List<Element> getElemnentmoduleEtudiant(Long id);

	public List<AbsenceEtud> getElemnentmoduleEtudiantAbsence(Long id);

	public List<Module> getModuleByActivatedYears();

	public List<Element> getElementByActivatedYears();

	List<AbsenceEtud> getElemnentmoduleAbsences(Long id);
}
