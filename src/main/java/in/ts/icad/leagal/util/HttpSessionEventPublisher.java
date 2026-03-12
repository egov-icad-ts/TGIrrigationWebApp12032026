package in.ts.icad.leagal.util;

import java.io.IOException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;

import in.ts.icad.leagal.util.SecurityWebApplicationContextUtils;





import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionIdListener;
import javax.servlet.http.HttpSessionListener;

public class HttpSessionEventPublisher implements HttpSessionListener, HttpSessionIdListener {
	// ~ Static fields/initializers
	// =====================================================================================

	  private int sessionCount = 0;
	  HttpServletResponse response;
	private static final String LOGGER_NAME = HttpSessionEventPublisher.class.getName();

	// ~ Methods
	// ========================================================================================================

	ApplicationContext getContext(ServletContext servletContext) {
		return SecurityWebApplicationContextUtils.findRequiredWebApplicationContext(servletContext);
	}

	/**
	 * Handles the HttpSessionEvent by publishing a {@link HttpSessionCreatedEvent} to the
	 * application appContext.
	 *
	 * @param event HttpSessionEvent passed in by the container
	 */
	public void sessionCreated(HttpSessionEvent event) {
		HttpSessionCreatedEvent e = new HttpSessionCreatedEvent(event.getSession());
		Log log = LogFactory.getLog(LOGGER_NAME);

		if (log.isDebugEnabled()) {
			log.debug("Publishing event: " + e);
		}

		getContext(event.getSession().getServletContext()).publishEvent(e);
		
		sessionCount++; 
		event.getSession().setMaxInactiveInterval(2*60);
	}

	/**
	 * Handles the HttpSessionEvent by publishing a {@link HttpSessionDestroyedEvent} to
	 * the application appContext.
	 *
	 * @param event The HttpSessionEvent pass in by the container
	 */
	public void sessionDestroyed(HttpSessionEvent event) {
		HttpSessionDestroyedEvent e = new HttpSessionDestroyedEvent(event.getSession());
		Log log = LogFactory.getLog(LOGGER_NAME);

		if (log.isDebugEnabled()) {
			log.debug("Publishing event: " + e);
		}

		getContext(event.getSession().getServletContext()).publishEvent(e);
		
		 sessionCount--;
			HttpSession session=event.getSession();
			
			//System.out.println("userName"+session.getAttribute("userName"));
			 try {
			 if(session != null){
		            session.invalidate();
		            response.sendRedirect("/web/logout");
			 }
			 } catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	}

	@Override
	public void sessionIdChanged(HttpSessionEvent event, String oldSessionId) {
		HttpSessionIdChangedEvent e = new HttpSessionIdChangedEvent(event.getSession(), oldSessionId);
		Log log = LogFactory.getLog(LOGGER_NAME);

		if (log.isDebugEnabled()) {
			log.debug("Publishing event: " + e);
		}

		getContext(event.getSession().getServletContext()).publishEvent(e);
	}
}