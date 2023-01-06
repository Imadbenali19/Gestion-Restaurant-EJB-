package ma.entites;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Zone implements Serializable {

	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	
	private Long id;
	private String nom;
	
	@ManyToOne
	private Ville ville;
	
	
	public Zone() {
		super();
	}
	
	public Zone(String nom, Ville ville) {
		super();
		this.nom = nom;
		this.ville = ville;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}

	public Ville getVille() {
		return ville;
	}

	public void setVille(Ville ville) {
		this.ville = ville;
	}
	
	
}
