package demo.mvvm.ui;

import java.util.Map;

import org.zkoss.bind.BindContext;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.bind.annotation.GlobalCommand;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.impl.BindContextImpl;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;

/**
 * @author DRIESBACH Olivier - olivier.driesbach(at)gmail.com
 */
public class MainLayoutViewModel {
	
	@Init
	public void initMainLayoutViewModel() {
	}

	@GlobalCommand
	public void createWindow(
			@ContextParam(ContextType.BIND_CONTEXT) BindContext ctx,
			@BindingParam("uri") String uri,
			@BindingParam("parent") Component parent) {
		
		Executions.createComponents(uri, parent, (Map<?,?>) ctx.getAttributes().get(BindContextImpl.COMMAND_ARGS));
	}
}
