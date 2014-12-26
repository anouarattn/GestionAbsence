package ac.enset.administration.gestionAbsence;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name="module")
public class Module implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name="codemod")
	private String codemod;
	@Column(name="libmod")
	private String libmod;
	@Column(name="dateCreation")
	private Date dateCreation;
	@Column(name="smestre")
	private String smestre;
	
	@OneToMany(mappedBy="module",fetch=FetchType.LAZY)
	private Collection<ElementModule> elementModule;
	
	

	@ManyToOne
	@JoinColumn(name="ref_fil")
	private Filier filier;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCodemod() {
		return codemod;
	}

	public void setCodemod(String codemod) {
		this.codemod = codemod;
	}

	public String getLibmod() {
		return libmod;
	}

	public void setLibmod(String livmod) {
		this.libmod = livmod;
	}

	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	public String getSmestre() {
		return smestre;
	}

	public void setSmestre(String smestre) {
		this.smestre = smestre;
	}

	public Filier getFilier() {
		return filier;
	}

	public void setFilier(Filier fil) {
		this.filier = fil;
	}
	
	public Collection<ElementModule> getElementModule() {
		return elementModule;
	}

	public void setElementModule(Collection<ElementModule> elmModule) {
		this.elementModule = elmModule;
	}
	
	public Module(String codemod, String livmod, Date dateCreation,
			String smestre) {
		super();
		this.codemod = codemod;
		this.libmod = livmod;
		this.dateCreation = dateCreation;
		this.smestre = smestre;
		
	}

	public Module() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}
