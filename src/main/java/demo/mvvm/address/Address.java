package demo.mvvm.address;

/**
 * @author DRIESBACH Olivier - olivier.driesbach(at)gmail.com
 */
public class Address {
	
	/** */
	private String number;
	
	/** */
	private String line1;
	
	/** */
	private String line2;
	
	/** */
	private String zipCode;
	
	/** */
	private String city;
	
	/**
	 * 
	 */
	public Address() {
	}
	
	/**
	 * 
	 * @param number
	 * @param line1
	 * @param line2
	 * @param zipCode
	 * @param city
	 */
	public Address(String number, String line1, String line2, String zipCode, String city) {
		this.number = number;
		this.line1 = line1;
		this.line2 = line2;
		this.zipCode = zipCode;
		this.city = city;
	}

	/**
	 * @return the number
	 */
	public String getNumber() {
		return number;
	}

	/**
	 * @param number the number to set
	 */
	public void setNumber(String number) {
		this.number = number;
	}

	/**
	 * @return the line1
	 */
	public String getLine1() {
		return line1;
	}

	/**
	 * @param line1 the line1 to set
	 */
	public void setLine1(String line1) {
		this.line1 = line1;
	}

	/**
	 * @return the line2
	 */
	public String getLine2() {
		return line2;
	}

	/**
	 * @param line2 the line2 to set
	 */
	public void setLine2(String line2) {
		this.line2 = line2;
	}

	/**
	 * @return the zipCode
	 */
	public String getZipCode() {
		return zipCode;
	}

	/**
	 * @param zipCode the zipCode to set
	 */
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getCompleteAddress() {
		return getNumber() +" "+ getLine1() +" "+ getZipCode() +" "+ getCity();
	}
}
