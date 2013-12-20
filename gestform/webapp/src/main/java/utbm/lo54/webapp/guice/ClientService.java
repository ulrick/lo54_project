package utbm.lo54.webapp.guice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import utbm.lo54.webapp.dao.interf.IClientDao;
import utbm.lo54.webapp.guice.interf.IClientService;
import utbm.lo54.webapp.model.Client;

import com.google.inject.Inject;

public class ClientService implements IClientService {

@Inject 
private IClientDao cldao;		
	
	List<Client> clients = new ArrayList<Client>();

	public List<Client> listOfClient() {
		// TODO Auto-generated method stub
		for(Client cl : cldao.getAllClient()){
			clients.add(cl);
		}
		return clients;
	}
	
	/*liste des clients par différents critères*/
	/*public List<Client> getClientByRestrictions(String course_code, String location) {
		
		List<Client> list;
		if ((location!=null)||(course_code!=null)) {
			Criterion lo = Restrictions.eq("location", location);
			Criterion cc = Restrictions.eq("course_code", course_code);
			list = cldao.query(lo,cc);
		} else {
			list = cldao.query();
		}
		
		List<Client> clList = new LinkedList<Client>();
		
		for (Client cl : list) {
			if (course_code == null || (location == null)) {
				clList.add(cl);
			}
		}
		
		return clList;
	}*/
	

	public List<Client> getClientByRestrictions1(int s) {
		List<Client> list;
		if (s!=0) {
			Criterion c = Restrictions.eq("s", s);
			list = cldao.query(c);
		} else {
			list = cldao.query();
		}
		
		List<Client> clList = new LinkedList<Client>();
		
		for (Client cl : list) {
			if (s==0) {
				clList.add(cl);
			}
		}
		
		return clList;
	}

}
