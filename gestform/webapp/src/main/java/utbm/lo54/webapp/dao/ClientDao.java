package utbm.lo54.webapp.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;

import utbm.lo54.webapp.dao.interf.IClientDao;
import utbm.lo54.webapp.model.Client;
import utbm.lo54.webapp.persistence.HibernateUtil;

public class ClientDao implements IClientDao {
	

	public void addClient(Client client) {
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            session.save(client);
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

    public void deleteClient(int clientId) {
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            Client client = (Client) session.load(Client.class, new Integer(clientId));
            session.delete(client);
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

    public void updateClient(Client client) {
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            session.update(client);
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
    

    public List<Client> getAllClient() {
        List<Client> clients = new ArrayList<Client>();
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            clients = session.createQuery("from Client").list();
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        return clients;
    }
    

    public Client getClientById(int clientId) {
        Client client = null;
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            String queryString = "from Client where id = :id";
            Query query = session.createQuery(queryString);
            query.setInteger("id", clientId);
            client = (Client) query.uniqueResult();
        } catch (RuntimeException e) {
            e.printStackTrace();           
        } finally {
            session.flush();
            session.close();
        }
        return client;
    }
    
    
    public List<Client> getClientBySession(int session_id) {
    	 List<Client> clients = new ArrayList<Client>();
         Transaction trns = null;
         Session session = HibernateUtil.getSessionFactory().openSession();
         try {
             trns = session.beginTransaction();
             clients = session.createQuery("from Client where session_id =:session_id").list();
         } catch (RuntimeException e) {
             e.printStackTrace();
         } finally {
             session.flush();
             session.close();
         }
         return clients;
    }
    
    public List<Client> query(Order[] order, Criterion... cs) {
		List<Client> lcl = new ArrayList<Client>();
		Session session = HibernateUtil.getSessionFactory().openSession();
		Criteria criteria = session.createCriteria(Client.class);
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
		lcl = criteria.list();
		return lcl;
	}
    
    public List<Client> query(Order order, Criterion... cs) {
		return this.query(new Order[] { order }, cs);
	}

	public List<Client> query(Criterion... cs) {
		return this.query(new Order[] {}, cs);
	}
    
    
}
