package demo.mvvm.ui;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.zkoss.bind.BindUtils;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.bind.annotation.ExecutionArgParam;
import org.zkoss.bind.annotation.Init;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.EventQueue;
import org.zkoss.zk.ui.event.EventQueues;

/**
 * @author DRIESBACH Olivier - olivier.driesbach(at)gmail.com
 */
public abstract class ViewModel implements EventQueueNames {
	
	/** */
	public static final String EVENT_QUEUE_ATTRIBUTE = "eventQueue";
	
	/** */
	private static final Logger log = LoggerFactory.getLogger(ViewModel.class);
	
	/** */
	private Component view;
	
	/** */
	private String eventQueueName;
	
	/** */
	private Map<String, List<EventListener<Event>>> eventListeners = new HashMap<String, List<EventListener<Event>>>(1);

	@Init
	public void initViewModel(@ContextParam(ContextType.VIEW) Component view, @ExecutionArgParam(EVENT_QUEUE_ATTRIBUTE) String eventQueueName) {
		this.view = view;
		this.eventQueueName = eventQueueName;
		subscribeToEventQueues();
	}
	
	/**
	 * 
	 */
	protected void subscribeToEventQueues() {
	}

	/**
	 * 
	 * @param queueName
	 * @param eventListener
	 */
	protected void addEventListener(String queueName, EventListener<Event> eventListener) {
		
		List<EventListener<Event>> listeners = eventListeners.get(queueName);
		if (listeners == null) {
			listeners = new ArrayList<EventListener<Event>>(1);
			eventListeners.put(queueName, listeners);
			
			view.addScopeListener(new DetachScopeListener() {
				
				@Override
				public void onDetach() {
					removeEventListeners();
				}
			});
		}
		listeners.add(eventListener);
		
		EventQueues.lookup(queueName, true).subscribe(eventListener);
	}
	
	/**
	 * 
	 */
	protected void removeEventListeners() {
		for (Entry<String, List<EventListener<Event>>> entry : eventListeners.entrySet()) {
			
			EventQueue<Event> queue = EventQueues.lookup(entry.getKey(), false);
			if (queue == null) { // Prevent from re-creating an already destroy event queue
				continue;
			}
			
			for (EventListener<Event> listener : entry.getValue()) {
				queue.unsubscribe(listener);
			}
		}
	}
	
	protected void fireEvent(String eventName, Object data) {
		fireEvent(eventQueueName, eventName, data);
	}
	
	protected void fireEvent(String eventQueueName, String eventName, Object data) {
		
		String queueName = eventQueueName == null ? EventQueues.DESKTOP : eventQueueName;
	    EventQueue<Event> queue = EventQueues.lookup(queueName, false);
	    if (queue == null) {
	    	log.warn("The ViewModel "+ getClass().getName()
	    			+" try to publish the event "+ eventName
	    			+" on an inexisting queue "+ queueName);
	    }
	    else { // Prevent from publishing on an inexisting event queue
	    	queue.publish(new Event(eventName, null, data));
	    }
	}
	
	protected void notifyChange(String property) {
		BindUtils.postNotifyChange(null, null, this, property);
	}
}