package ac.enset.administration.gestionAbsence;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import ac.enset.administration.gestionAbsence.session.IAbsenceRemote;

//import lib.metier.Filier;
//import lib.session.IAbsenceRemote;


@ManagedBean(name="filierBN")
@RequestScoped
public class FilierBN {
	@EJB
	private IAbsenceRemote abs; 
	
	public IAbsenceRemote getAbs() {
		return abs;
	}
	public void setAbs(IAbsenceRemote abs) {
		this.abs = abs;
	}
	private int annee;
	private String code; 
	private String lib_fil ;
	public int getAnnee() {
		return annee;
	}
	public void setAnnee(int annee) {
		this.annee = annee;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getLib_fil() {
		return lib_fil;
	}
	public void setLib_fil(String lib_fil) {
		this.lib_fil = lib_fil;
	} 
	
	public String ajouter(){
		abs.ajouterFilier(new Filier(code, lib_fil, annee, new Date()));
		return "seccess";
	}
	
	public List<Filier> getListFilier(){
		return abs.getListFilier();
	}
	
}
