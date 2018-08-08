package main.java.model;

/**
 * Employee has a status (busy or available) and a type (operator, supervisor or
 * director)
 * 
 * @author Jorge
 *
 */
public class Employee extends Person {
	private String status;
	private String type;

	public Employee(String n, String t) {
		name = n;
		type = t;
		status = "available";
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStatus() {
		return status;
	}

	public String getType() {
		return type;
	}
}
