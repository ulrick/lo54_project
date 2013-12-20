package utbm.lo54.webapp.guice;

import java.util.ArrayList;
import java.util.List;

import utbm.lo54.webapp.dao.ClientDao;
import utbm.lo54.webapp.dao.CourseDao;
import utbm.lo54.webapp.dao.CourseSessionDao;
import utbm.lo54.webapp.dao.LocationDao;
import utbm.lo54.webapp.dao.interf.IClientDao;
import utbm.lo54.webapp.dao.interf.ICourseDao;
import utbm.lo54.webapp.dao.interf.ICourseSessionDao;
import utbm.lo54.webapp.dao.interf.ILocationDao;
import utbm.lo54.webapp.guice.interf.IClientService;
import utbm.lo54.webapp.guice.interf.ICourseService;
import utbm.lo54.webapp.guice.interf.ICourseSessionService;
import utbm.lo54.webapp.guice.interf.ILocationService;
import utbm.lo54.webapp.model.CourseSession;

import com.google.inject.Binder;
import com.google.inject.Module;
import com.google.inject.TypeLiteral;

public class MainModule implements Module {

	public void configure(Binder binder) {
		// TODO Auto-generated method stub
		binder.bind(IClientDao.class).to(ClientDao.class);
		binder.bind(ICourseDao.class).to(CourseDao.class);
		binder.bind(ILocationDao.class).to(LocationDao.class);
		binder.bind(ICourseSessionDao.class).to(CourseSessionDao.class);
		binder.bind(ICourseSessionService.class).to(CourseSessionService.class);
		binder.bind(ILocationService.class).to(LocationService.class);
		binder.bind(ICourseService.class).to(CourseService.class);
		binder.bind(IClientService.class).to(ClientService.class);
		binder.bind(new TypeLiteral<List<CourseSession>>() {}).toInstance(new ArrayList<CourseSession>());
		
	}

}
