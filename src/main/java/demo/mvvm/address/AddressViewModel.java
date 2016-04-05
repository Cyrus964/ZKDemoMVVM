package demo.mvvm.address;

import java.util.List;

import org.zkoss.bind.annotation.Init;

/**
 * @author DRIESBACH Olivier - olivier.driesbach(at)gmail.com
 */
public class AddressViewModel {

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
 
    private void initAddresses() {
    	addresses = new AddressService().findAll();
	}
}
