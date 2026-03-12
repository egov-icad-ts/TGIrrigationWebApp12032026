package in.ts.icad.leagal.util;

import in.ts.icad.leagal.util.SessionIdChangedEvent;

import javax.servlet.http.HttpSession;

public class HttpSessionIdChangedEvent extends SessionIdChangedEvent {
	private final String oldSessionId;
	private final String newSessionId;

	public HttpSessionIdChangedEvent(HttpSession session, String oldSessionId) {
		super(session);
		this.oldSessionId = oldSessionId;
		this.newSessionId = session.getId();
	}

	@Override
	public String getOldSessionId() {
		return oldSessionId;
	}

	@Override
	public String getNewSessionId() {
		return newSessionId;
	}
}
