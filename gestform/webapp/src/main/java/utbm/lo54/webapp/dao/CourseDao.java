package utbm.lo54.webapp.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import utbm.lo54.webapp.dao.interf.ICourseDao;
import utbm.lo54.webapp.model.Course;
import utbm.lo54.webapp.persistence.HibernateUtil;

public class CourseDao implements ICourseDao {

	public void addCourse(Course course) {
		// TODO Auto-generated method stub
		Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            session.save(course);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            if (trns != null) {
                trns.rollback();
            }
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
	}

	public void deleteCourse(int courseId) {
		// TODO Auto-generated method stub
		Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            Course course = (Course) session.load(Course.class, new Integer(courseId));
            session.delete(course);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            if (trns != null) {
                trns.rollback();
            }
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
	}

	public void updateCourse(Course course) {
		// TODO Auto-generated method stub
		Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            session.update(course);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            if (trns != null) {
                trns.rollback();
            }
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
	}

	public List<Course> getAllCourse() {
		// TODO Auto-generated method stub
		List<Course> courses = new ArrayList<Course>();
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            courses = session.createQuery("from Course").list();
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        return courses;
	}

	public Course getCourseById(String coursecode) {
		// TODO Auto-generated method stub
		Course course = null;
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            String queryString = "from Course where code = :coursecode";
            Query query = session.createQuery(queryString);
            query.setParameter("coursecode", coursecode);
            course = (Course) query.uniqueResult();
        } catch (RuntimeException e) {
            e.printStackTrace();           
        } finally {
            session.flush();
            session.close();
        }
        return course;
    }
	

}
