package in.ts.icad.leagal.util;


import javax.servlet.http.HttpSession;

import org.springframework.security.core.session.SessionCreationEvent;
public class HttpSessionCreatedEvent extends SessionCreationEvent {
	// ~ Constructors
	// ===================================================================================================

	public HttpSessionCreatedEvent(HttpSession session) {
		super(session);
	}

	public HttpSession getSession() {
		return (HttpSession) getSource();
	}
}