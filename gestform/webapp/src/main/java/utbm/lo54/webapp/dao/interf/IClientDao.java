package utbm.lo54.webapp.dao.interf;

import java.util.List;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;

import com.google.inject.ImplementedBy;

import utbm.lo54.webapp.dao.ClientDao;
import utbm.lo54.webapp.model.Client;


@ImplementedBy(ClientDao.class)//utilise ClientDao comme classe l'implémentant par défaut
public interface IClientDao {
	
	public void addClient(Client client);
	public void deleteClient(int clientId);
	public void updateClient(Client client);
	public List<Client> getAllClient();
	public Client getClientById(int clientId);
	public List<Client> getClientBySession(int session_id);
	public List<Client> query(Order[] order, Criterion... cs);
	public List<Client> query(Order order, Criterion... cs);
	public List<Client> query(Criterion... cs);
}
