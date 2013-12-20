package utbm.lo54.webapp.dao.interf;

import java.util.List;

import utbm.lo54.webapp.model.Location;

public interface ILocationDao {
	public void addLocation(Location location);
	public void deleteLocation(int locationId);
	public void updateLocation(Location location);
	public List<Location> getAllLocation();
	public Location getLocationById(int locationId);
}
