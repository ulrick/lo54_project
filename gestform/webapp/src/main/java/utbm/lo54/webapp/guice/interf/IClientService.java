package utbm.lo54.webapp.guice.interf;

import java.util.List;

import utbm.lo54.webapp.model.Client;

public interface IClientService {
	public List<Client> listOfClient();
	//public List<Client> getClientByRestrictions(String course_code, String location);
	public List<Client> getClientByRestrictions1(int s);
}
