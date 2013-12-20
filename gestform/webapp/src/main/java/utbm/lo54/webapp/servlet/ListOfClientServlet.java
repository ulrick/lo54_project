package utbm.lo54.webapp.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utbm.lo54.webapp.guice.ClientService;
import utbm.lo54.webapp.guice.CourseService;
import utbm.lo54.webapp.guice.CourseSessionService;
import utbm.lo54.webapp.guice.LocationService;
import utbm.lo54.webapp.guice.MainModule;
import utbm.lo54.webapp.guice.interf.IClientService;
import utbm.lo54.webapp.guice.interf.ICourseService;
import utbm.lo54.webapp.guice.interf.ICourseSessionService;
import utbm.lo54.webapp.guice.interf.ILocationService;
import utbm.lo54.webapp.model.Client;
import utbm.lo54.webapp.model.Course;
import utbm.lo54.webapp.model.CourseSession;
import utbm.lo54.webapp.model.Location;

import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * Servlet implementation class ListOfClientServlet
 */
public class ListOfClientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListOfClientServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Injector injector = Guice.createInjector(new MainModule());

		ILocationService lodao = injector.getInstance(LocationService.class);
		ICourseService codao = injector.getInstance(CourseService.class);
		ICourseSessionService csdao = injector.getInstance(CourseSessionService.class);
		IClientService cldao = injector.getInstance(ClientService.class);

		List<Location> locations = new ArrayList<Location>();
		List<Course> courses = new ArrayList<Course>();
		// List<CourseSession> coursesessions = new ArrayList<CourseSession>();
		List<CourseSession> futurcoursesessions = new ArrayList<CourseSession>();
		List<Client> clients = new ArrayList<Client>();
		List<Client> clients2 = new ArrayList<Client>();
		clients = cldao.listOfClient();
		//clients2 = cldao.getClientByRestrictions1(2);
		
		
		request.setAttribute("listClient", clients);
		
		request.getRequestDispatcher("listClients.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
