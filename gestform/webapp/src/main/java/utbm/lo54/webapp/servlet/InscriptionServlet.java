package utbm.lo54.webapp.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;

import utbm.lo54.webapp.dao.ClientDao;
import utbm.lo54.webapp.dao.interf.IClientDao;
import utbm.lo54.webapp.guice.CourseService;
import utbm.lo54.webapp.guice.CourseSessionService;
import utbm.lo54.webapp.guice.LocationService;
import utbm.lo54.webapp.guice.MainModule;
import utbm.lo54.webapp.guice.interf.ICourseService;
import utbm.lo54.webapp.guice.interf.ICourseSessionService;
import utbm.lo54.webapp.guice.interf.ILocationService;
import utbm.lo54.webapp.model.Client;
import utbm.lo54.webapp.model.CourseSession;

/**
 * Servlet implementation class InscriptionServlet
 */
public class InscriptionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InscriptionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		request.getRequestDispatcher("inscription.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Injector injector = Guice.createInjector(new MainModule());
		
		//ILocationService lodao = injector.getInstance(LocationService.class);
		//ICourseService codao = injector.getInstance(CourseService.class);
		ICourseSessionService csdao = injector.getInstance(CourseSessionService.class);
		
		CourseSession cs = new CourseSession();
		List<Client> clientList = new ArrayList<Client>();
		
		String sessionId = (String) request.getParameter("sessionId");
		System.out.println(sessionId);
		
		cs = csdao.findCourseSessionById(Integer.parseInt(sessionId));
		
        String nomClient = request.getParameter("nomClient");
        
        String prenomClient = request.getParameter("prenomClient");

        String adresseClient = request.getParameter("adresseClient");

        String telephoneClient = request.getParameter("telephoneClient");
        
        String emailClient = request.getParameter("emailClient");
        
        Client c = new Client();
        IClientDao cldao = injector.getInstance(ClientDao.class);
        
        c.setLastName(nomClient);
        c.setFirstName(prenomClient);
        c.setAddress(adresseClient);
        c.setPhone(telephoneClient);
        c.setEmail(emailClient);
        c.setSessionId(cs);
    	
        cldao.addClient(c);
        
        response.sendRedirect("ListCourseSession");
        
        //clientList.add(c);

	}
}
