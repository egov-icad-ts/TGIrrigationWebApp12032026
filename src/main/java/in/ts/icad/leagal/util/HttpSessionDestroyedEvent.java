package in.ts.icad.leagal.util;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.session.SessionDestroyedEvent;

import java.util.*;

public class HttpSessionDestroyedEvent extends SessionDestroyedEvent {
	// ~ Constructors
	// ===================================================================================================

	public HttpSessionDestroyedEvent(HttpSession session) {
		super(session);
	}

	public HttpSession getSession() {
		return (HttpSession) getSource();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SecurityContext> getSecurityContexts() {
		HttpSession session = getSession();

		Enumeration<String> attributes = session.getAttributeNames();

		ArrayList<SecurityContext> contexts = new ArrayList<>();

		while (attributes.hasMoreElements()) {
			String attributeName = attributes.nextElement();
			Object attributeValue = session.getAttribute(attributeName);
			if (attributeValue instanceof SecurityContext) {
				contexts.add((SecurityContext) attributeValue);
			}
		}

		return contexts;
	}

	@Override
	public String getId() {
		return getSession().getId();
	}
}