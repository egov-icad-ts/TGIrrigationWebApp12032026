package in.ts.icad.leagal.util;

import org.springframework.context.ApplicationEvent;

public class AbstractSessionEvent extends ApplicationEvent {

	public AbstractSessionEvent(Object source) {
		super(source);
	}
}