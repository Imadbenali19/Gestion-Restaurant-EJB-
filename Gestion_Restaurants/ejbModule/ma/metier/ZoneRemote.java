package ma.metier;

import java.util.List;

import javax.ejb.Remote;

import ma.entites.Zone;

@Remote
public interface ZoneRemote {

	// CRUD Zone;
	boolean addZone(Zone z);

	boolean delZone(Long zId);

	boolean updateZone(Zone z);

	List<Zone> getAllZones();
	
	Zone getZone(String nom);
	
	Zone findById(Long id);
}
