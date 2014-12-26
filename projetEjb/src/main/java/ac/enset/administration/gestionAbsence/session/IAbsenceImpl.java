package ac.enset.administration.gestionAbsence.session;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ac.enset.administration.gestionAbsence.AbsenceEtudiantElement;
import ac.enset.administration.gestionAbsence.Admin;
import ac.enset.administration.gestionAbsence.Classe;
import ac.enset.administration.gestionAbsence.ElementModule;
import ac.enset.administration.gestionAbsence.Enseignant;
import ac.enset.administration.gestionAbsence.Etudiant;
import ac.enset.administration.gestionAbsence.Filier;
import ac.enset.administration.gestionAbsence.Module;


@Stateless(name="ABSENCE")
public class IAbsenceImpl implements IAbsenceLocal, IAbsenceRemote  {
	
	@PersistenceContext(unitName="projetAbsenceTest")
	private EntityManager em;
	
	@Override
	public void ajouterEtudiant(Etudiant etud,int id) {
		Classe cl= em.find(Classe.class, id);
		etud.setClasse(cl);
		em.persist(etud);
		
	}

	@Override
	public void ajouterEnseignant(Enseignant ens) {
		em.persist(ens);
		
	}

	@Override
	public void ajouterAdmin(Admin admin) {
		em.persist(admin);
		
	}

	@Override
	public void ajouterFilier(Filier fil) {
		em.persist(fil);
		
	}

	@Override
	public void ajouterModule(Module module, int id) {
		Filier fil = em.find(Filier.class,id);
		module.setFilier(fil);
		em.persist(module);
		
	}

	@Override
	public void ajouterElementModule(ElementModule elmod, int idmod ,int idens ) {
		Module module = em.find(Module.class, idmod);
		Enseignant ens=em.find(Enseignant.class, idens);
		elmod.setModule(module);
		elmod.setEnseignant(ens);
		em.merge(elmod);
		//em.persist(elmod);
		
	}

	@Override
	public void ajouterAbsence(AbsenceEtudiantElement absence, int idetud,int idelm) {
		
		
	}

	@Override
	public void ajouterClasse(Classe cl, int id) {
		Filier fil = em.find(Filier.class,id);
		cl.setFilier(fil);
		em.persist(cl);
		
	}
	
public List<Filier> getListFilier(){
		Query qr = em.createQuery("select f from Filier f ");
		return qr.getResultList();
	}
	
	/***********************************************************/
	
	@Override
	public void supprimeEtudiant(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void supprimeEnseignant(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void supprimeAdmin(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void supprimeFilier(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void supprimeModule(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void supprimeElementModule(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void supprimeAbsence(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void supprimeClasse(int id) {
		// TODO Auto-generated method stub
		
	}
	

}
