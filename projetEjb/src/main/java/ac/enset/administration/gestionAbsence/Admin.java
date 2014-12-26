package ac.enset.administration.gestionAbsence;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="admin")
public class Admin implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int idadmin;
	@Column(name="ppr")
	private double ppr;
	@Column(name="login")
	private String login; 
	@Column(name="motdepasse")
	private String motdepasse ;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="DATE_CREATION")
	private Date dateCreation;
	
	public Date getDateCreation() {
		return dateCreation;
	}
	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}
	
	
	public double getPpr() {
		return ppr;
	}
	public void setPpr(double ppr) {
		this.ppr = ppr;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getMotdepasse() {
		return motdepasse;
	}
	public void setMotdepasse(String motdepasse) {
		this.motdepasse = motdepasse;
	}
	
	public int getIdadmin() {
		return idadmin;
	}
	public void setIdadmin(int idadmin) {
		this.idadmin = idadmin;
	}
	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Admin(double ppr, String login, String motdepasse, Date dateCreation) {
		super();
		this.ppr = ppr;
		this.login = login;
		this.motdepasse = motdepasse;
		this.dateCreation=dateCreation;
	}
	
	
}
