package utbm.lo54.webapp.guice.interf;

import java.sql.Date;
import java.util.List;

import utbm.lo54.webapp.model.CourseSession;

public interface ICourseSessionService {
	
	public List<CourseSession> listOfCourseSession();
	public CourseSession findCourseSessionById(int sessionId);
	public List<CourseSession> listOfFuturSession();
	public List<CourseSession> getCourseSessionByRestrictions(String keyword, Date filtreDate, String location);
}
