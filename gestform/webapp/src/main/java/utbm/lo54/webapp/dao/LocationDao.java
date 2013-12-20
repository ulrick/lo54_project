package utbm.lo54.webapp.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.google.inject.Inject;

import utbm.lo54.webapp.dao.interf.ILocationDao;
import utbm.lo54.webapp.model.Location;
import utbm.lo54.webapp.persistence.HibernateUtil;


public class LocationDao implements ILocationDao {
//@Inject
	public void addLocation(Location location) {
		// TODO Auto-generated method stub
		Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            session.save(location);
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

	public void deleteLocation(int locationId) {
		// TODO Auto-generated method stub
		 Transaction trns = null;
	        Session session = HibernateUtil.getSessionFactory().openSession();
	        try {
	            trns = session.beginTransaction();
	            Location location = (Location) session.load(Location.class, new Integer(locationId));
	            session.delete(location);
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

	public void updateLocation(Location location) {
		// TODO Auto-generated method stub
		Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            session.update(location);
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

	public List<Location> getAllLocation() {
		// TODO Auto-generated method stub
		List<Location> locations = new ArrayList<Location>();
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            locations = session.createQuery("from Location").list();
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        return locations;
	}

	public Location getLocationById(int locationId) {
		// TODO Auto-generated method stub
		Location location = null;
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            String queryString = "from Location where id = :id";
            Query query = session.createQuery(queryString);
            query.setInteger("id", locationId);
            location = (Location) query.uniqueResult();
        } catch (RuntimeException e) {
            e.printStackTrace();           
        } finally {
            session.flush();
            session.close();
        }
        return location;
    }
}
