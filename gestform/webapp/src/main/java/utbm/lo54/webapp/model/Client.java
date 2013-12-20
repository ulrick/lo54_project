package utbm.lo54.webapp.model;


public class Client {
	private int id;
	private String lastName;
	private String firstName;
	private String address;
	private String phone;
	private String email;
	private CourseSession sessionId;
	
	public Client(){
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public CourseSession getSessionId() {
		return sessionId;
	}

	public void setSessionId(CourseSession sessionId) {
		this.sessionId = sessionId;
	}

	

}
