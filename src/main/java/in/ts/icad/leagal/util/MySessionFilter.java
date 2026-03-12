package in.ts.icad.leagal.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;









public class MySessionFilter  implements Filter {
	
	private ArrayList<String> urlList;
	
	  private ServletContext context;

	private String timeoutPage = "/web/logout"; 
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		
	/*	HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		String url = request.getServletPath();
		boolean allowedRequest = false;
		
		System.out.println("url"+url);
		if(urlList.contains(url)) {
			System.out.println("url2"+url);
			allowedRequest = true;
			
		}
  if(allowedRequest){
	  chain.doFilter(req, res);
	  return;
	  
  }
			
		if (!allowedRequest) {
			System.out.println("url3"+url);
			 chain.doFilter(req, res);
			HttpSession session = request.getSession(false);
			 if (null == session ) {
	                System.out.println("session not set");
	                response.sendRedirect("../leagal/home");
	                //return;
	            
		
			}
			
			 return;
		}  */
		//https://medium.com/@kasunpdh/session-management-in-java-using-servlet-filters-and-cookies-7c536b40448f	
		//System.out.println("DoFilter"); 
		 if ((request instanceof HttpServletRequest) && (response instanceof HttpServletResponse)) { 
			 HttpServletRequest req = (HttpServletRequest) request;
			 HttpServletResponse res = (HttpServletResponse) response; // is session expire control required for this request? 

			 Cookie[] allCookies = req.getCookies();
			 String sessionID = null;
			 
			 Cookie[] cookies = req.getCookies();
			 
		      if (allCookies != null) {
		        for (Cookie cookie : cookies) {
		        	
		        	if(cookie.getName().equals("JSESSIONID")){
		        		sessionID = cookie.getValue();
		        	
		        	
		        	
		           cookie.setMaxAge(0);
		            cookie.setValue(null);
		            cookie.setPath("/");
		            cookie.setSecure(true);
		            cookie.setHttpOnly(true);
		            res.addCookie(cookie);
		        	}
		        }
			
		      }
	        	
	        	/* for (Cookie cookie : allCookies) {
	        	      if (sessionId.equalsIgnoreCase(cookie.getValue())) {
	        	        cookie.setMaxAge(0);
	        	        cookie.setValue(null);
	        	        cookie.setDomain(req.getServerName());
	        	        cookie.setPath(req.getServletContext().getContextPath() + "/");
	        	        cookie.setSecure(req.isSecure());
	        	        res.addCookie(cookie);
	        	        break;
	        	      }
	        	    }*/
	           // Cookie session =Arrays.asList(allCookies).filter(x -> x.getName().equals("JSESSIONID")).findFirst().orElse(null);
	 
	           /* if (session != null) {
	                session.setHttpOnly(true);
	                session.setSecure(true);
	                res.addCookie(session);
	            }*/
	       
		      
		  /*    HttpSession session = req.getSession(false);

		        if (session == null) {   //checking whether the session exists
		            this.context.log("Unauthorized access request");
		            res.sendRedirect(req.getContextPath() + "timeoutPage");
		        } else {
		            // pass the request along the filter chain
		            chain.doFilter(request, response);
		        }*/
		 
		 if (isSessionControlRequiredForThisResource(req)) {
			 // is session invalid? 
		 if (isSessionInvalid(req)) {
			 String timeoutUrl = ((HttpServletRequest)req).getContextPath() + getTimeoutPage(); 

		
		 res.sendRedirect(timeoutUrl); 
		 return; 
		 } 
		 } 
		 } 
		 
		
		 chain.doFilter(request, response); 
		 } 

	
		
		
		
		
		
	
		 
		 /** * * session shouldn't be checked for some pages. For example: for timeout page.. * Since we're redirecting to timeout page from this filter, * if we don't disable session control for it, filter will again redirect to it * and this will be result with an infinite loop... */
		 private boolean isSessionControlRequiredForThisResource(HttpServletRequest httpServletRequest) { 
			 String requestPath = httpServletRequest.getRequestURI(); 
			 boolean controlRequired = !StringUtils.contains(requestPath, getTimeoutPage()); 
			 return controlRequired; 
			 } 

			 private boolean isSessionInvalid(HttpServletRequest httpServletRequest) { 
			// System.out.println("is session invalid"); 
			 boolean sessionInValid = (httpServletRequest.getRequestedSessionId() != null) && !httpServletRequest.isRequestedSessionIdValid(); 
			 return sessionInValid; 
			 } 

			

			 public String getTimeoutPage() { 
			 return timeoutPage; 
			 } 

			 public void setTimeoutPage(String timeoutPage) { 
				 this.timeoutPage = timeoutPage; 
				 } 

	@Override
	public void init(FilterConfig config) throws ServletException {
		// TODO Auto-generated method stub
		
		String urls = config.getInitParameter("avoid-urls");
		StringTokenizer token = new StringTokenizer(urls, ",");
		
		//System.out.println("urls"+urls);

		urlList = new ArrayList<String>();

		while (token.hasMoreTokens()) {
			urlList.add(token.nextToken());

		}
		
	}

}
