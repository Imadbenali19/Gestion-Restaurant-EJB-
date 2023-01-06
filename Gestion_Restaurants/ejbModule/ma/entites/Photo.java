package ma.entites;

import java.io.Serializable;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Photo  implements Serializable{

	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	
	private Long id;
	private String url;
	private String webUrl;
	
	@ManyToOne
	private Restaurant restaurant;
	
	
	
	public Photo(String url,String webUrl ,Restaurant restaurant) {
		super();
		this.url = url;
		this.webUrl=webUrl;
		this.restaurant = restaurant;
	}

	public Photo() {
		super();
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	public String getWebUrl() {
		return webUrl;
	}

	public void setWebUrl(String webUrl) {
		this.webUrl = webUrl;
	}
	
	
	
	
}
