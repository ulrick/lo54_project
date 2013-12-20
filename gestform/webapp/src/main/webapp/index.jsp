<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="utbm.lo54.webapp.model.CourseSession"%>
<%@page import="utbm.lo54.webapp.model.Course"%>
<%@page import="utbm.lo54.webapp.model.Location"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="css/index_style.css" />

<link rel="stylesheet" type="text/css" href="js/datatable194/media/css/jquery.dataTables.css" media="all"/>
<link rel="stylesheet" type="text/css" href="js/datatable194/media/css/demo_table.css" media="all"/>
<link rel="stylesheet" type="text/css" href="js/datatable194/media/css/demo_table_jui.css" media="all"/>
<link rel="stylesheet" type="text/css" href="js/datatable194/media/css/jquery.dataTables_themeroller.css" media="all"/>

<title>Gestion des catalogues de Formations</title>
</head>
<body>
	<div id="main_frame">
	
		<section id="main_content">
			<h1>BIENVENU SUR VOTRE SITE DE FORMATION</h1>

			<article class="recherche">
		   	
				<div id="filtre">
					<form action="ListCourseSession" method="get">
						<fieldset>
							<legend>Vos Recherches</legend>
							
							<label for="title_course">Titre Formation :</label> 
							<input type="search" name="key" id="title_course" placeholder="Entrer mot clé" size="30" /> 
							
							<label for="date_formation">Date Début Formation :</label> 
							<input type="date" name="date_formation" id="date_formation" /> 
							
							
							<label for="lieu_formation">Lieu de la formation</label> 
							
							<% List<Location> listelocation=(List<Location>)request.getAttribute("location");%>
							<select name="lieu_formation" id="lieu_formation">
								<option value="" selected>Choisissez un lieu</option>
								 <%for (Location l : listelocation){ %>
								 <option value="<%=l.getId()%>"><%=l.getCity()%></option>
								 <% } %> 
							</select><br />
							
							<input type="submit" value="Submit"><br>
							
						</fieldset>
					</form>
				</div>

			</article>
			
			
			<article class="resultat">
			
			<aside class="course_list">
			
				<div id="list_course>">

					<h2>NOS FORMATIONS</h2>
					<%List<Course> listecourse = (List<Course>)request.getAttribute("course"); %>
					<ul>
						<%for (Course c : listecourse){ %>
							<li><%=c.getCode() %> : <%=c.getTitle() %>
						<%} %>
						
					</ul>

				</div>
			</aside>

			<aside class="list_sessioncourse">
				<h2>PROCHAINES SESSIONS DE FORMATIONS</h2>
				<div id="coursesession_list" >
					<!-- La liste des sessions prochaines -->
					<%List<CourseSession> futursessions = (List<CourseSession>)request.getAttribute("futurcoursesession"); %>
					<table id="session_formation" border="1">
						
						<thead>
							<tr>
								<th>N°</th><th>TITLE</th><th>DEBUT</th><th>FIN</th><th>LIEU</th><th>INSCRIPTION</th>
							</tr>
						</thead>
						
						<tbody>
						<%
							List<CourseSession> course;
							if(futursessions!=null){
								course = futursessions;
							}else{
								course = (List<CourseSession>)request.getAttribute("keywords");
							}
						%>
								<% SimpleDateFormat sdf = new SimpleDateFormat("EEE dd MMM yyyy"); %>
						<%! int i = 0; %>
						<%for (CourseSession cs : course){ i++ ;%>
							<tr>
								<td><%=i %></td>
								<td><a href="#"><%=cs.getCourseCode().getCode()%></a> : <%=cs.getCourseCode().getTitle()%></td>
								<td><%=sdf.format(cs.getStart())%></td>
								<td><%=sdf.format(cs.getEnd())%></td>
								<td><%=cs.getLocationId().getCity() %></td>
								<td>
									<%
									java.util.Date today = new Date();
								
									if(cs.getStart().compareTo(today) > 0 ) {  %>
										<a href="Inscription?sessionId=<%=cs.getId()%>">s'inscrire</a>
									<%} %>
								</td>
							</tr>
							<%} i=0; %>
						</tbody>
						
						<tfoot>
							<tr><th>N°</th><th>TITLE</th><th>DEBUT</th><th>FIN</th><th>LIEU</th><th>INSCRIPTION</th></tr>
						</tfoot>
						
					</table>
				</div>
			</aside>
		</article>
		</section>
	</div>
	
	<script type="text/javascript"  src="js/jquery.js"></script>
	<script type="text/javascript"  src="js/datatable194/media/js/jquery.dataTables.js"></script>
	<script type="text/javascript"  src="js/datatable_script.js" charset="utf-8"></script>

</body>
</html>
