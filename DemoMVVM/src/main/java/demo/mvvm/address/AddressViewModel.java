package demo.mvvm.address;

import java.util.List;

import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;

import demo.mvvm.ui.ViewModel;

/**
 * @author DRIESBACH Olivier - olivier.driesbach(at)gmail.com
 */
public class AddressViewModel extends ViewModel {

	/** */
    private List<Address> addresses;
    
    /** */
    private Address selectedAddress;

    @Init(superclass=true)
    public void initAddressViewModel() {
    	initAddresses();
    }
    
    public List<Address> getAddresses() {
    	return addresses;
    }
 
	public Address getSelectedAddress() {
        return selectedAddress;
    }
	
	public void setSelectedAddress(Address selectedAddress) {
		this.selectedAddress = selectedAddress;
	}
 
    @Command
    public void fireSelectedAddress() {
        fireEvent(ADDRESS_EVENT_QUEUE, ON_ADDRESS_SELECTED, getSelectedAddress());
    }
    
    private void initAddresses() {
    	addresses = new AddressService().findAll();
	}
}
