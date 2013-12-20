package utbm.lo54.webapp.dao.interf;

import java.util.List;

import utbm.lo54.webapp.model.Course;

public interface ICourseDao {
	public void addCourse(Course course);
	public void deleteCourse(int courseId);
	public void updateCourse(Course course);
	public List<Course> getAllCourse();
	public Course getCourseById(String coursecode);
}
