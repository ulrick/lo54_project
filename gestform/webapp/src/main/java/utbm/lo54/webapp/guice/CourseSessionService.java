package utbm.lo54.webapp.guice;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import utbm.lo54.webapp.dao.interf.ICourseDao;
import utbm.lo54.webapp.dao.interf.ICourseSessionDao;
import utbm.lo54.webapp.dao.interf.ILocationDao;
import utbm.lo54.webapp.guice.interf.ICourseSessionService;
import utbm.lo54.webapp.model.Course;
import utbm.lo54.webapp.model.CourseSession;
import utbm.lo54.webapp.model.Location;

import com.google.inject.Inject;

public class CourseSessionService implements ICourseSessionService {

	@Inject
	private ICourseSessionDao csdao;

	@Inject
	private ILocationDao lodao;

	@Inject
	private ICourseDao codao;


	List<CourseSession> listsession = new ArrayList<CourseSession>();

	// la liste de toutes les sessions
	public List<CourseSession> listOfCourseSession() {
		// TODO Auto-generated method stub
		listsession = csdao.getAllCourseSession();
		List<CourseSession> listsessions = new ArrayList<CourseSession>();
		for (CourseSession c : listsession) {
			Course co = codao.getCourseById(c.getCourseCode().getCode());
			Location lo = lodao.getLocationById(c.getLocationId().getId());
			c.setCourseCode(co);
			c.setLocationId(lo);
			listsessions.add(c);
		}
		return listsessions;
	}

	public List<CourseSession> listOfFuturSession() {
		java.util.Date uDate = new java.util.Date();
		listsession = csdao.getFuturSession(new java.sql.Date(uDate.getTime()));
		List<CourseSession> futurlist = new ArrayList<CourseSession>();
		for (CourseSession c : listsession) {
			Course co = codao.getCourseById(c.getCourseCode().getCode());
			Location lo = lodao.getLocationById(c.getLocationId().getId());
			c.setCourseCode(co);
			c.setLocationId(lo);
			futurlist.add(c);
		}
		return futurlist;
	}

	// récupération d'une session par son id
	public CourseSession findCourseSessionById(int sessionId) {
		CourseSession session = csdao.getCourseSessionById(sessionId);
		Course course = codao.getCourseById(session.getCourseCode().getCode());
		Location location = lodao.getLocationById(session.getLocationId()
				.getId());
		session.setCourseCode(course);
		session.setLocationId(location);
		return session;
	}

	// récupération d'une session par le code de formation
	/*public CourseSession findCourseSessionByCourseCode(String courseCode) {
		Course course = codao.getCourseById(courseCode);

		return null;
	}*/

	public List<CourseSession> getCourseSessionByRestrictions(String keyword,
			Date filtreDate, String location) {
		List<CourseSession> list;
		if (filtreDate != null) {
			Criterion c = Restrictions.ge("start", filtreDate);
			list = csdao.query(c);
		} else {
			list = csdao.query();
		}
		keyword = (keyword != null && keyword.length() > 0) ? keyword : null;
		location = (location != null && location.length() > 0) ? location : null;
		List<CourseSession> csList = new LinkedList<CourseSession>();
		for (CourseSession cs : list) {
			if ((keyword == null || cs.getCourseCode().getTitle().toLowerCase()
					.matches(".*" + keyword.toLowerCase() + ".*"))
					&& (location == null || cs.getLocationId().getId() == Integer
							.parseInt(location))) {
				csList.add(cs);
			}
		}
		Collections.sort(csList, new Comparator<CourseSession>() {
			public int compare(CourseSession o1, CourseSession o2) {
				return o1.getCourseCode().getCode()
						.compareTo(o2.getCourseCode().getCode());
			}
		});
		return csList;
	}

}
