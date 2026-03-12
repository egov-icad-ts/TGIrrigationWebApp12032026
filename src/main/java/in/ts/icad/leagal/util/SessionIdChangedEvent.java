package in.ts.icad.leagal.util;





public abstract class SessionIdChangedEvent extends AbstractSessionEvent {

	public SessionIdChangedEvent(Object source) {
		super(source);
	}

	/**
	 * Returns the old session ID.
	 *
	 * @return the identifier that was previously associated with
	 * the session.
	 */
	public abstract String getOldSessionId();

	/**
	 * Returns the new session ID.
	 *
	 * @return the new identifier that is associated with the session.
	 */
	public abstract String getNewSessionId();
}		