package ac.enset.administration.gestionAbsence;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import ac.enset.administration.gestionAbsence.metier.IAbsenceLocal;



@ManagedBean(name ="bean1")
@SessionScoped
public class bean implements Serializable{
	@EJB
    private IAbsenceLocal metier;
	
	private String name;
	private String pass;
	public  boolean isLogin = false;
	
	
	public bean(){
		isLogin = false;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getPass() {
		return pass;
	}


	public void setPass(String pass) {
		this.pass = pass;
	}
	
	public String action(){
		isLogin = false;
		//boolean a= true;
		//System.out.println("name : "+name+" pass : "+ pass);
		//a = metier.User(name, pass);
		//User u = metier.getUser(name);
		//System.err.println("  "+u.getLogin()+" - id "+u.getId());
//		isLogin = metier.User(name,pass ); 
//		if(isLogin){
//			return "index.xhtml?faces-redi";
//		}else{
//			isLogin = false;
//			return "login.xhtml?faces-redi";
//		}
		return "";
		
		
		
	}
}
