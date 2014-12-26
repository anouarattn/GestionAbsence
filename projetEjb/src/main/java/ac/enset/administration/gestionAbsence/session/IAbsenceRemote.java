package ac.enset.administration.gestionAbsence.session;

import java.util.List;

import javax.ejb.Remote;

import ac.enset.administration.gestionAbsence.AbsenceEtudiantElement;
import ac.enset.administration.gestionAbsence.Admin;
import ac.enset.administration.gestionAbsence.Classe;
import ac.enset.administration.gestionAbsence.ElementModule;
import ac.enset.administration.gestionAbsence.Enseignant;
import ac.enset.administration.gestionAbsence.Etudiant;
import ac.enset.administration.gestionAbsence.Filier;
import ac.enset.administration.gestionAbsence.Module;

@Remote
public interface IAbsenceRemote {
	

	public void ajouterEtudiant(Etudiant etud,int id);
	public void ajouterEnseignant(Enseignant ens);
	public void ajouterAdmin(Admin admin);
	public void ajouterFilier(Filier fil);
	public void ajouterModule(Module module,int id);
	public void ajouterElementModule(ElementModule elmod,int idmod ,int idens);
	public void ajouterAbsence(AbsenceEtudiantElement absence,int idetud,int idelm);
	public void ajouterClasse(Classe cl,int id);
	
	/**************************/
	
	public List<Filier> getListFilier();
	
	/**************************/
	
	public void supprimeEtudiant(int id);
	public void supprimeEnseignant(int id);
	public void supprimeAdmin(int id);
	public void supprimeFilier(int id);
	public void supprimeModule(int id);
	public void supprimeElementModule(int id);
	public void supprimeAbsence(int id);
	public void supprimeClasse(int id);
	
	

}
