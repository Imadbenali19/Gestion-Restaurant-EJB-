package ma.entites;

import java.io.Serializable;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Photo  implements Serializable{

	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	
	private Long id;
	private String url;
	
	
	
	public Photo(String url) {
		super();
		this.url = url;
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
	
	
	
}
