package demo.mvvm.address;

import java.util.ArrayList;
import java.util.List;

/**
 * @author DRIESBACH Olivier - olivier.driesbach(at)gmail.com
 */
public class AddressService {

	/**
	 * 
	 */
	public AddressService() {
	}
		
	/**
	 * 
	 * @return
	 */
	public List<Address> findAll() {
		
		ArrayList<Address> result = new ArrayList<Address>();
		
		result.add(new Address("21", "Jump Street", "", "10001", "New York City"));
		result.add(new Address("23", "Sec. 1", "Changan E. Rd #7F-2", "10441", "Taipei City"));
		result.add(new Address("36", "Quai des Orfèvres", "", "75000", "Paris"));
		result.add(new Address("1600", "Pennsylvania Avenue NW", "", "DC 20500", "Washington"));
		
		return result;
	}
}
