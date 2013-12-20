package utbm.lo54.webapp.model;

import java.sql.Date;

public class CourseSession {
	private int id;
	private Date start;
	private Date end;
	private Course courseCode;
	private Location locationId;
	
	public CourseSession(){
		
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getStart() {
		return start;
	}
	public void setStart(Date start) {
		this.start = start;
	}
	public Date getEnd() {
		return end;
	}
	public void setEnd(Date end) {
		this.end = end;
	}

	public Course getCourseCode() {
		return courseCode;
	}

	public void setCourseCode(Course courseCode) {
		this.courseCode = courseCode;
	}

	public Location getLocationId() {
		return locationId;
	}

	public void setLocationId(Location locationId) {
		this.locationId = locationId;
	}
	
}
