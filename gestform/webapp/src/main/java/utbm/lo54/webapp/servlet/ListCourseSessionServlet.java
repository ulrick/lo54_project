package utbm.lo54.webapp.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utbm.lo54.webapp.guice.CourseService;
import utbm.lo54.webapp.guice.CourseSessionService;
import utbm.lo54.webapp.guice.LocationService;
import utbm.lo54.webapp.guice.MainModule;
import utbm.lo54.webapp.guice.interf.ICourseService;
import utbm.lo54.webapp.guice.interf.ICourseSessionService;
import utbm.lo54.webapp.guice.interf.ILocationService;
import utbm.lo54.webapp.model.Course;
import utbm.lo54.webapp.model.CourseSession;
import utbm.lo54.webapp.model.Location;

import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * Servlet implementation class ListCourseSessionServlet
 */
public class ListCourseSessionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ListCourseSessionServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		Injector injector = Guice.createInjector(new MainModule());

		ILocationService lodao = injector.getInstance(LocationService.class);
		ICourseService codao = injector.getInstance(CourseService.class);
		ICourseSessionService csdao = injector.getInstance(CourseSessionService.class);

		List<Location> locations = new ArrayList<Location>();
		List<Course> courses = new ArrayList<Course>();
		// List<CourseSession> coursesessions = new ArrayList<CourseSession>();
		List<CourseSession> futurcoursesessions = new ArrayList<CourseSession>();

		/*filtre de recherche sur les dates, mots clés et les lieux de formations  */
		
		String filtreDateStr = request.getParameter("date_formation");
		String k = request.getParameter("key");
		String location = request.getParameter("lieu_formation");
		
		Date filtreDate = null;
		
		if (filtreDateStr != null) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			try {
				filtreDate = sdf.parse(filtreDateStr);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		

		if (k != null || filtreDate != null || location != null) {
			List<CourseSession> keywords = new ArrayList<CourseSession>();
			java.sql.Date date = null;
			
			if (filtreDate != null) {
				date = new java.sql.Date(filtreDate.getTime());
			}
			
			keywords = csdao.getCourseSessionByRestrictions(k, date, location);
			request.setAttribute("keywords", keywords);
		} else {
			futurcoursesessions = csdao.listOfFuturSession();
			request.setAttribute("futurcoursesession", futurcoursesessions);
		}
		/* Fin procédure de recherche par rapport au paramètres*/
		
		locations = lodao.listOfLocation();
		courses = codao.listOfCourse();

		request.setAttribute("location", locations);
		request.setAttribute("course", courses);

		request.getRequestDispatcher("index.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
