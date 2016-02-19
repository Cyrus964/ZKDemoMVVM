package demo.mvvm.ui;

import org.zkoss.zk.ui.IdSpace;
import org.zkoss.zk.ui.ext.Scope;
import org.zkoss.zk.ui.ext.ScopeListener;

/**
 * @author DRIESBACH Olivier - olivier.driesbach(at)gmail.com
 */
public abstract class DetachScopeListener implements ScopeListener {

	@Override
	public void attributeAdded(Scope scope, String name, Object value) {
	}

	@Override
	public void attributeReplaced(Scope scope, String name, Object value) {
	}

	@Override
	public void attributeRemoved(Scope scope, String name) {
	}

	@Override
	public void parentChanged(Scope scope, Scope newparent) {
		if (newparent == null) {
			onDetach();
		}
	}

	@Override
	public void idSpaceChanged(Scope scope, IdSpace newIdSpace) {
	}
	
	/**
	 * 
	 */
	public abstract void onDetach();
}