package demo.mvvm.ui;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.EventQueues;
import org.zkoss.zk.ui.select.SelectorComposer;

/**
 * @author DRIESBACH Olivier - olivier.driesbach(at)gmail.com
 */
public abstract class DefaultComposer<C extends Component> extends SelectorComposer<C> {

	/** */
	private static final long serialVersionUID = -5145274314707880470L;

	/** */
	private String eventQueue;
	
	/** */
	private EventListener<Event> listener;
		
	@Override
	public void doAfterCompose(C component) {
		
		// Check if the current execution contains the event queue attribute for ViewModel events
		eventQueue = (String) Executions.getCurrent().getArg().get(ViewModel.EVENT_QUEUE_ATTRIBUTE);
		if (eventQueue != null) {
			
			// Subscribe to the event queue
			listener = new EventListener<Event>() {
				
				@Override
				public void onEvent(Event event) throws Exception {
					handleEvent(event);
				}
			};
			EventQueues.lookup(eventQueue, true).subscribe(listener);
			
			// Register a scope listener to detach the event queue listener when the view is detached
			getSelf().addScopeListener(new DetachScopeListener() {
				
				@Override
				public void onDetach() {
					EventQueues.lookup(eventQueue, false).unsubscribe(listener);
				}
			});
		}
	}
		
	/**
	 * 
	 * @param event
	 */
	protected abstract void handleEvent(Event event);
}
