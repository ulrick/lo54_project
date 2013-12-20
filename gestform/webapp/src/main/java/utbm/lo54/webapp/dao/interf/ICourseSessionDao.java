package utbm.lo54.webapp.dao.interf;

import java.sql.Date;
import java.util.List;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;

import utbm.lo54.webapp.dao.CourseSessionDao;
import utbm.lo54.webapp.model.CourseSession;

import com.google.inject.ImplementedBy;

@ImplementedBy(CourseSessionDao.class)
public interface ICourseSessionDao {

	public void addCourseSession(CourseSession courseSession);

	public void deleteCourseSession(int sessionId);

	public void updateCourseSession(CourseSession courseSession);

	public List<CourseSession> getAllCourseSession();

	public CourseSession getCourseSessionById(int sessionId);

	public CourseSession findByCourseId(String code);

	public List<CourseSession> getFuturSession(Date today);

	public List<CourseSession> query(Order[] order, Criterion... cs);

	public List<CourseSession> query(Order order, Criterion... cs);

	public List<CourseSession> query(Criterion... cs);
}
