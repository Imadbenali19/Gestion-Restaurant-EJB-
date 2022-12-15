package ma.entites;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Restaurant implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nom;
	private String adress;
	private double lat ;
	private double lon ;
	private String description;
	private String date_open;
	private String date_close;
	private boolean weekend;
	private int rank;
	
	/*@OneToMany(fetch = FetchType.LAZY)
	private List<Photo> photos;
	
	@ManyToOne
	private Zone zone;
	
	@ManyToMany
	
	private List<Specialite> specialites;
	
	@ManyToOne
	private Serie serie;*/
	
	
	
	public Restaurant() {
		super();
	}

	public Restaurant(String nom, String adress, double lat, double lon, String description, String date_open,
			String date_close, boolean weekend, int rank, List<Photo> photos, Zone zone, List<Specialite> specialites,
			Serie serie) {
		super();
		this.nom=nom;
		this.adress = adress;
		this.lat = lat;
		this.lon = lon;
		this.description = description;
		this.date_open = date_open;
		this.date_close = date_close;
		this.weekend = weekend;
		this.rank = rank;
		/*this.photos = photos;
		this.zone = zone;
		this.specialites = specialites;
		this.serie = serie;*/
	}

	/*public List<Photo> getPhotos() {
		return photos;
	}

	public void setPhotos(List<Photo> photos) {
		this.photos = photos;
	}

	public Zone getZone() {
		return zone;
	}

	public void setZone(Zone zone) {
		this.zone = zone;
	}

	public List<Specialite> getSpecialites() {
		return specialites;
	}

	public void setSpecialites(List<Specialite> specialites) {
		this.specialites = specialites;
	}

	public Serie getSerie() {
		return serie;
	}

	public void setSerie(Serie serie) {
		this.serie = serie;
	}*/

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public double getLat() {
		return lat;
	}

	public void setLat(double lat) {
		this.lat = lat;
	}

	public double getLon() {
		return lon;
	}

	public void setLon(double lon) {
		this.lon = lon;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDate_open() {
		return date_open;
	}

	public void setDate_open(String date_open) {
		this.date_open = date_open;
	}

	public String getDate_close() {
		return date_close;
	}

	public void setDate_close(String date_close) {
		this.date_close = date_close;
	}

	public boolean isWeekend() {
		return weekend;
	}

	public void setWeekend(boolean weekend) {
		this.weekend = weekend;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	
	
	
	

}
