package demo.mvvm.address;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;

import demo.mvvm.ui.DefaultComposer;
import demo.mvvm.ui.EventQueueNames;

/**
 * @author DRIESBACH Olivier - olivier.driesbach(at)gmail.com
 */
public class AddressListComposer<C extends Component> extends DefaultComposer<C> {

	/** */
	private static final long serialVersionUID = -4630827116279732417L;

	@Override
	protected void handleEvent(Event event) {
		if (EventQueueNames.ON_ADDRESS_SELECTED.equals(event.getName())) {
			getSelf().detach();
		}
	}
}
