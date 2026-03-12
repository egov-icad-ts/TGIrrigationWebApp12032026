package in.ts.icad.leagal.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SessionModel {
	
private HttpSession threadLocalSession;
	
	private HttpServletRequest threadLocalrequest;
	
	private HttpServletResponse threadlocalresponse;

	public HttpSession getThreadLocalSession() {
		return threadLocalSession;
	}

	public void setThreadLocalSession(HttpSession threadLocalSession) {
		this.threadLocalSession = threadLocalSession;
	}

	public HttpServletRequest getThreadLocalrequest() {
		return threadLocalrequest;
	}

	public void setThreadLocalrequest(HttpServletRequest threadLocalrequest) {
		this.threadLocalrequest = threadLocalrequest;
	}

	public HttpServletResponse getThreadlocalresponse() {
		return threadlocalresponse;
	}

	public void setThreadlocalresponse(HttpServletResponse threadlocalresponse) {
		this.threadlocalresponse = threadlocalresponse;
	}
	
	

}
