package ma.metier;

import java.util.List;

import javax.ejb.Local;

import ma.entites.Zone;

@Local
public interface ZoneLocal {

	// CRUD Zone;
	boolean addZone(Zone z);

	boolean delZone(Long zId);

	boolean updateZone(Zone z);

	List<Zone> getAllZones();
	
	Zone getZone(String nom);
}
