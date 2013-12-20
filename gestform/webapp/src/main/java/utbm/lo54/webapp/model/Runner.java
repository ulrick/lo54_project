package utbm.lo54.webapp.model;


import java.text.ParseException;
//import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.List;

import utbm.lo54.webapp.guice.CourseSessionService;
import utbm.lo54.webapp.guice.LocationService;
import utbm.lo54.webapp.guice.MainModule;
import utbm.lo54.webapp.guice.interf.ICourseSessionService;
import utbm.lo54.webapp.guice.interf.ILocationService;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class Runner {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		/*ICourseSessionDao cs = new CourseSessionDao(); 
		String g = cs.findByCourseId("SQ40").getCourseCode().getTitle();
		System.out.println(g);*/
		
		Injector injector = Guice.createInjector(new MainModule());
		ICourseSessionService c = injector.getInstance(CourseSessionService.class);
		
		//List<CourseSession> l = injector.getInstance(ArrayList<CourseSession>.class);
		//List<CourseSession> repo1 = injector.getInstance(new ArrayList<CourseSession>() {});
		List<CourseSession> l = new ArrayList<CourseSession>();
		l = c.listOfFuturSession();
		for(CourseSession co : l){
			System.out.println(co.getStart()+" "+co.getEnd()+" "+co.getId()+" "+co.getCourseCode().getCode()+" "+co.getLocationId().getCity());
		}
		
		/*ICourseSessionDao dao = new CourseSessionDao();*/
		/*for(CourseSession cl : c.listOfCourseSession() ){
			//System.out.println(cl.getId()+" "+cl.getSessionId().getCourseCode().getCode()+" "+cl.getLastName()+" "+cl.getSessionId().getLocationId().getCity());
			System.out.println(cl.getId()+" "+cl.getCourseCode().getCode()+" "+cl.getStart()+" "+cl.getLocationId().getCity());
		}
		System.out.println(l);
		
		/*SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String startDate ="2013-07-01";
		String endDate = "2014-01-01";
		
		
		
		java.util.Date d = formatter.parse(startDate);
		java.util.Date d1 = formatter.parse(endDate);
		
		Course co = new Course();
		co.setCode("GL40");
		co.setTitle("Interfaces Homme-Machine");
		
		Location lo = new Location();
		lo.setCity("Trappes");
		//location.setId(1);
		
		CourseSession cs = new CourseSession();
		cs.setEnd(new java.sql.Date(d1.getTime()));
		cs.setStart(new java.sql.Date(d.getTime()));
		cs.setLocationId(lo);
		cs.setCourseCode(co);
		
		Client c = new Client();
		c.setLastName("PANASSA");
		c.setFirstName("Pignozi");
		c.setAddress("Dans la même chambre");
		c.setPhone("0760797741");
		c.setEmail("pignozi.panassa@utbm.fr");
		c.setSessionId(cs);
		
		IClientDao cldao = new ClientDao();
		ICourseDao codao = new CourseDao();
		ILocationDao lodao = new LocationDao();
		ICourseSessionDao csdao = new CourseSessionDao();
		
		/*System.out.println(codao.getCourseById("SQ40").getTitle());*/
		
		/*codao.addCourse(co);
		lodao.addLocation(lo);
		csdao.addCourseSession(cs);
		cldao.addClient(c);	
		
		
		//Client l = new Client();
		c = cldao.getClientById(4);
		c.setLastName("PANASSE");
		c.setFirstName("Yves");
		cldao.updateClient(c);
		
		ICourseSessionDao dao = new CourseSessionDao();
		for(CourseSession cl : dao.getAllCourseSession() ){
			//System.out.println(cl.getId()+" "+cl.getSessionId().getCourseCode().getCode()+" "+cl.getLastName()+" "+cl.getSessionId().getLocationId().getCity());
		System.out.println(cl.getId()+" "+cl.getCourseCode().getCode()+" "+cl.getLocationId().getCity());
		
		}*/
		
		/*ILocationService lodao = injector.getInstance(LocationService.class);
		for(Location lo : lodao.listOfLocation()){
			System.out.println(lo.getCity());
		}*/
		
	}

}