package in.ts.icad.leagal.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import in.ts.icad.leagal.manager.LeagalAdminManager;
import in.ts.icad.leagal.model.User;

public class AuthenticationInterceptor extends  HandlerInterceptorAdapter {
	@Autowired
	private LeagalAdminManager leagalAdminManager;
	
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
    	String uri = request.getRequestURI();
    	

    	
    	 HttpSession session = request.getSession();
    	 
    	 long inactiveTime = System.currentTimeMillis() - session.getLastAccessedTime();
    	 int maxInactiveInterval = session.getMaxInactiveInterval();
    	 
    	 long maxInactiveIntervalInMinutes = maxInactiveInterval / 60;
    	 
    	 long inactiveTimeInSeconds = inactiveTime / 1000;
    	 
    	 long inactiveTimeInMinutes = inactiveTimeInSeconds / 60;
    	 
    	 
    	
    	
    	/*&& !uri.endsWith("admin/adminMenu") && !uri.contains("/icad/")  && !uri.contains("/html/")*/
    	
    	 if(!uri.endsWith("web/home")&& !uri.endsWith("web/send-mail")&& !uri.endsWith("web/get-mail")  && !uri.endsWith("/web/getDivisions")   && !uri.endsWith("/task/getCircles")              && !uri.endsWith("web/logout") && !uri.endsWith("webtsimis/login")   && !uri.endsWith("jsp/BaseLayout.jsp") && !uri.contains("/webRest/") && !uri.contains("/parasrest/") &&  !uri.endsWith("/web/disclaimer") && !uri.endsWith("/web/terms")  &&  !uri.endsWith("/web/getencryptpassword") && !uri.contains("/err/errorPage")  )
    	  {
    		 // System.out.println("coming here auth");
    		 
    		 
    		 
    		 String userData=(String)request.getSession().getAttribute("loggedInUser");
    		 
    		 // System.out.println("coming here"+userData);
    		  User user = (User) session.getAttribute("userObj");
    		 
    		 if(inactiveTimeInMinutes>= (maxInactiveIntervalInMinutes-1) )
      	   {
    			 if(user!=null){
    					if(user.getUserName()!=null){
    				
    						response.sendRedirect("../web/logout");
    					
    					}
    					
    	   	     }
      		   }  
    	  
    	   if(userData == null)
    	   {
    		  // System.out.println("userData  if null"+userData);
    	    response.sendRedirect("../web/logout");
    	    return false;
    		   }  
    		  }
    		  return true;
    	 }
    	
    	
    	
    	

	
	@Override
    public void postHandle(HttpServletRequest request,
            HttpServletResponse response, Object handler,
            ModelAndView modelAndView) throws Exception {
       
    }
     
    @Override
    public void afterCompletion(HttpServletRequest request,
            HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        
    }

}

