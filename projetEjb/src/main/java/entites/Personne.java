package entites;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Named @RequestScoped
@Entity
@Table(name = "PERSONNE")
public class Personne {
	@Id
	private Long id;
	private String name;

	public Personne() {
		super();

	}

	public Personne(String name) {
		super();
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "entite [id=" + id + ", name=" + name + "]";
	}

}
