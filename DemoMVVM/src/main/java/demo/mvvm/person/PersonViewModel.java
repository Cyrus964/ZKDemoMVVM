package demo.mvvm.person;

import java.util.List;

import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;

import demo.mvvm.address.Address;
import demo.mvvm.ui.ViewModel;

/**
 * @author DRIESBACH Olivier - olivier.driesbach(at)gmail.com
 */
public class PersonViewModel extends ViewModel {
	
	/** */
	protected List<Person> persons;
	
	/** */
	private Person selectedPerson;
	
	@Init(superclass=true)
	public void initPersonViewModel() {
		initPersons();
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
	@NotifyChange("selectedPerson")
	public void setSelectedPerson(Person selectedPerson) {
		this.selectedPerson = selectedPerson;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getAddressEventQueueName() {
		return ADDRESS_EVENT_QUEUE;
	}
	
	/**
	 * 
	 */
	protected void initPersons() {
		persons = new PersonService().findAll();
	}
	
	@Override
	protected void subscribeToEventQueues() {
		
		addEventListener(getAddressEventQueueName(), new EventListener<Event>() {
			@Override
			public void onEvent(Event event) throws Exception {
				
				if (ON_ADDRESS_SELECTED.equals(event.getName())) {
					assignAddress((Address) event.getData());
				}
			}
		});

		// add all listeners you want here ...
	}
	
	/**
	 *
	 */
	private void assignAddress(Address address) {
		getSelectedPerson().setAddress(address);
		notifyChange("selectedPerson");
	}
}
