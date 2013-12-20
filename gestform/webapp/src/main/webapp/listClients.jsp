<%@page import="utbm.lo54.webapp.model.Client"%>
<%@page import="java.util.List"%>
<h2>LIST DES CLIENTS</h2>
					<%List<Client> listeclient = (List<Client>)request.getAttribute("listClient"); %>
					<ul>
						<%for (Client cl : listeclient){ %>
							<li><%=cl.getFirstName() %> : <%=cl.getLastName() %>
						<%} %>
						
					</ul>