package demo.mvvm.person;

import demo.mvvm.address.Address;

/**
 * @author DRIESBACH Olivier - olivier.driesbach(at)gmail.com
 */
public class Person {
	
	/** */
	private String firstName;
	
	/** */
	private String lastName;
	
	/** */
	private String email;
	
	/** */
	private Address address;
	
	/**
	 * 
	 */
	public Person() {
	}
	
	/**
	 * 
	 * @param firstName
	 * @param lastName
	 * @param email
	 */
	public Person(String firstName, String lastName, String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the address
	 */
	public Address getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(Address address) {
		this.address = address;
	}
}
