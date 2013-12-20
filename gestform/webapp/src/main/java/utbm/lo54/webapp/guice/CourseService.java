package utbm.lo54.webapp.guice;

import java.util.ArrayList;
import java.util.List;

import utbm.lo54.webapp.dao.interf.ICourseDao;
import utbm.lo54.webapp.guice.interf.ICourseService;
import utbm.lo54.webapp.model.Course;

import com.google.inject.Inject;

public class CourseService implements ICourseService {
	
	@Inject
	private ICourseDao codao;
	
	List<Course> courses = new ArrayList<Course>();

	public List<Course> listOfCourse() {
		// TODO Auto-generated method stub
		for(Course co : codao.getAllCourse()){
			courses.add(co);
		}
		return courses;
	}

}
