package utbm.lo54.webapp.dao;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.*;

import utbm.lo54.webapp.dao.interf.ICourseSessionDao;
import utbm.lo54.webapp.model.CourseSession;
import utbm.lo54.webapp.persistence.HibernateUtil;

public class CourseSessionDao implements ICourseSessionDao {

	// ajouter des session de cours dans la base de donnée
	public void addCourseSession(CourseSession courseSession) {
		// TODO Auto-generated method stub
		Transaction trns = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			trns = session.beginTransaction();
			session.save(courseSession);
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

	// supprimer une session de cours de la base de données
	public void deleteCourseSession(int sessionId) {
		// TODO Auto-generated method stub
		Transaction trns = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			trns = session.beginTransaction();
			CourseSession coursesession = (CourseSession) session.load(
					CourseSession.class, new Integer(sessionId));
			session.delete(coursesession);
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

	// mettre à jour une session de cours
	public void updateCourseSession(CourseSession courseSession) {
		// TODO Auto-generated method stub
		Transaction trns = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			trns = session.beginTransaction();
			session.update(courseSession);
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

	// Récupérer la liste de tous les cours de la base de données
	public List<CourseSession> getAllCourseSession() {
		// TODO Auto-generated method stub
		List<CourseSession> courseSessions = new ArrayList<CourseSession>();
		Transaction trns = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			trns = session.beginTransaction();
			courseSessions = session.createQuery("from CourseSession").list();
		} catch (RuntimeException e) {
			e.printStackTrace();
		} finally {
			session.flush();
			session.close();
		}
		return courseSessions;
	}

	// liste des prochaines sessions

	public List<CourseSession> getFuturSession(Date today) {
		List<CourseSession> l = new ArrayList<CourseSession>();
		Session session = HibernateUtil.getSessionFactory().openSession();
		Criteria criteria = session.createCriteria(CourseSession.class);

		if (today != null) {
			criteria.add(Restrictions.gt("start", today));
		}

		criteria.addOrder(Order.asc("start"));
		l = criteria.list();
		return l;
	}

	// récupérer les cours par leur id
	public CourseSession getCourseSessionById(int sessionId) {
		// TODO Auto-generated method stub
		CourseSession courseSession = null;
		Transaction trns = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			trns = session.beginTransaction();
			String queryString = "from CourseSession where id = :id";
			Query query = session.createQuery(queryString);
			query.setInteger("id", sessionId);
			courseSession = (CourseSession) query.uniqueResult();
		} catch (RuntimeException e) {
			e.printStackTrace();
		} finally {
			session.flush();
			session.close();
		}
		return courseSession;
	}

	// récuperer les cours par le code
	public CourseSession findByCourseId(String code) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		CourseSession courseSession = new CourseSession();

		try {
			Query query = session
					.createQuery("from CourseSession where courseCode=:code");
			query.setParameter("code", code);
			courseSession = (CourseSession) query.uniqueResult();
		} catch (HibernateException h) {
			h.printStackTrace();
		} finally {
			if (session != null) {
				try {
					HibernateUtil.getSessionFactory().close();
					;
				} catch (HibernateException e) {
					e.printStackTrace();
				}
			}
		}
		return courseSession;
	}

	public List<CourseSession> query(Order[] order, Criterion... cs) {
		List<CourseSession> lcs = new ArrayList<CourseSession>();
		Session session = HibernateUtil.getSessionFactory().openSession();
		Criteria criteria = session.createCriteria(CourseSession.class);
		if (cs != null) {
			for (Criterion c : cs) {
				criteria.add(c);
			}
		}
		if (order != null) {
			for (Order o : order) {
				criteria.addOrder(o);
			}
		}
		lcs = criteria.list();
		return lcs;
	}

	public List<CourseSession> query(Order order, Criterion... cs) {
		return this.query(new Order[] { order }, cs);
	}

	public List<CourseSession> query(Criterion... cs) {
		return this.query(new Order[] {}, cs);
	}

}
