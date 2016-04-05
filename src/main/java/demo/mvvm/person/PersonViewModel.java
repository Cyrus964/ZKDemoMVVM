package demo.mvvm.person;

import java.util.List;

import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.GlobalCommand;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;

import demo.mvvm.address.Address;

/**
 * @author DRIESBACH Olivier - olivier.driesbach(at)gmail.com
 */
public class PersonViewModel {
	
	/** */
	protected List<Person> persons;
	
	/** */
	private Person selectedPerson;
	
	/** */
	private boolean selectAddress;
	
	@Init(superclass=true)
	public void initPersonViewModel() {
		initPersons();
		selectAddress = false;
	}
	
	/**
	 * 
	 * @return
	 */
	public List<Person> getPersons() {
		return persons;
	}
	
	/**
	 * 
	 * @return
	 */
	public Person getSelectedPerson() {
		return selectedPerson;
	}
	
	/**
	 * 
	 * @param selectedPerson
	 */
	public void setSelectedPerson(Person selectedPerson) {
		this.selectedPerson = selectedPerson;
	}
	
	/**
	 * @return the selectAddress
	 */
	public boolean isSelectAddress() {
		return selectAddress;
	}

	/**
	 * @param selectAddress the selectAddress to set
	 */
	public void setSelectAddress(boolean selectAddress) {
		this.selectAddress = selectAddress;
	}
	
	@Command
	@NotifyChange("selectAddress")
	public void selectAddress() {
		selectAddress = true; // Activate the address selection mode
	}
	
	@GlobalCommand
	@NotifyChange({"selectedPerson", "selectAddress"})
	public void updateAddress(@BindingParam("address") Address address) {
		getSelectedPerson().setAddress(address);
		selectAddress = false; // Disable the address selection mode
	}
	
	@GlobalCommand
	@NotifyChange("selectAddress")
	public void cancelAddress(@BindingParam("address") Address address) {
		selectAddress = false; // Disable the address selection mode
	}

	/**
	 * 
	 */
	protected void initPersons() {
		persons = new PersonService().findAll();
	}
}
