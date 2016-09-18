package beans;


public class Actor {
	int ID;
	String firstName;
	String lastName;
	
	public Actor(int iD, String firstName, String lastName) {
		super();
		ID = iD;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public int getID() {
		return ID;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	};
	
	
}
