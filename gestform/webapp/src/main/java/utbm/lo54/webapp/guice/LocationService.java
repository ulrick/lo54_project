package utbm.lo54.webapp.guice;

import java.util.ArrayList;
import java.util.List;

import utbm.lo54.webapp.dao.LocationDao;
import utbm.lo54.webapp.dao.interf.ILocationDao;
import utbm.lo54.webapp.guice.interf.ILocationService;
import utbm.lo54.webapp.model.Location;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;

public class LocationService implements ILocationService {
	
	@Inject
	private ILocationDao lodao;

	
	List<Location> locations = new ArrayList<Location>();
	
	public List<Location> listOfLocation() {
		// TODO Auto-generated method stub
		Injector injector = Guice.createInjector(new MainModule());
		lodao = injector.getInstance(LocationDao.class);
		
		for(Location lo : lodao.getAllLocation()){
			
			locations.add(lo);
		}
		
		return locations;
	}
}
