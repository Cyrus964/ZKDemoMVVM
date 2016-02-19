package demo.mvvm.person;

import java.util.ArrayList;
import java.util.List;

/**
 * @author DRIESBACH Olivier - olivier.driesbach(at)gmail.com
 */
public class PersonService {

	/**
	 * 
	 */
	public PersonService() {
	}
	
	/**
	 * 
	 * @return
	 */
	public List<Person> findAll() {
		
		ArrayList<Person> result = new ArrayList<Person>();
		
		result.add(new Person("John", "Doe", "john.doe@unknown.com"));
		result.add(new Person("Oswald", "Cobblepot", "pinguin@linux.com"));
		result.add(new Person("Marcus", "Brody", "mbrody@indiana.com"));
		result.add(new Person("Thomas", "Anderson", "neo@matrix.com"));
		
		return result;
	}
}
