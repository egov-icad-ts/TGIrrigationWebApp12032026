package in.ts.icad.leagal.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import in.ts.icad.leagal.exception.LeagalUserException;
import in.ts.icad.leagal.manager.LeagalAdminManager;
import in.ts.icad.leagal.model.SessionModel;
import in.ts.icad.leagal.model.User;

//@Service
public class SessionListenerService   {
	
	/*@Autowired
	private LeagalAdminManager leagalAdminManager;
	
	

	

	public String  custommethod (HttpServletRequest request,HttpServletResponse response, HttpSession session ){
		
		
		
		
		 long lastAccessTime=0l;
		String result = null;

       // long currentTime = System.currentTimeMillis();
		
		 System.out.println("1  coming to custommethod");
  
         if(request!=null  ){
        	 
        	
        	 
        	 
        	
        	 
        	
        	 
        	 HttpSession sessionnew=request.getSession();
        	 System.out.println("2  coming to custommethod");
        	 
        	 System.out.println("3  coming to custommethod");
        	lastAccessTime=  sessionnew.getLastAccessedTime();
        	
        	 System.out.println("4  coming to custommethod");
        			
        
            // Your code here
         
        	
        
        	
        	//System.out.println("sessionModel.getThreadLocalSession()"+sessionModel.getThreadLocalrequest());
        	
        //	System.out.println("coming to lastAccessTime"+lastAccessTime);
         
         if (lastAccessTime != -1) {
        	 
        	 System.out.println("5  coming to custommethod");
         User user = (User) session.getAttribute("userObj");
       
         System.out.println("lastAccessTime"+lastAccessTime);

        // Assuming a session timeout of 3 minutes (adjust as needed)
     //   long sessionTimeout = 3 * 60 * 1000;

        long inactiveTime = System.currentTimeMillis() - session.getLastAccessedTime();
   	 int maxInactiveInterval = session.getMaxInactiveInterval();
   	 
   	 long maxInactiveIntervalInMinutes = maxInactiveInterval / 60;
   	 
   	 long inactiveTimeInSeconds = inactiveTime / 1000;
   	 
   	 long inactiveTimeInMinutes = inactiveTimeInSeconds / 60;
        
        
       // System.out.println("result " + result);
        
        
       // System.out.println("inactiveTime"+inactiveTime);
   	 
   	// System.out.println("maxInactiveInterval"+maxInactiveInterval);
   	 
   	// System.out.println("inactiveTimeInSeconds"+inactiveTimeInSeconds);
   	 
   	 
   	 System.out.println(" 1 inactiveTimeInMinutes" + inactiveTimeInMinutes);
     System.out.println("1 maxInactiveIntervalInMinutes" + maxInactiveIntervalInMinutes);
  
        
        if(inactiveTimeInSeconds>= (maxInactiveInterval-10) )
   	   {
        	
        	
   		  
        	try {
                if (user != null && user.getUserName() != null) {
                    System.out.println("inactiveTimeInMinutes" + inactiveTimeInMinutes);
                    System.out.println("maxInactiveIntervalInMinutes" + maxInactiveIntervalInMinutes);
                    leagalAdminManager.updateUserLogout(user.getUserName());
                    
                    System.out.println("response custommethod"+response);
                    
                	//response.sendRedirect("../web/logout");
                    
                    SessionUtils.getLastsessionend(session, request);
                    
                  //  redirectUserToLogoutwithsession(session,request);
                    //mav.setViewName("redirect:/home");
                    
                   // session.removeAttribute("user");
                  //  session.invalidate();
                    
                   
                }
            } catch (LeagalUserException e) {
                e.printStackTrace();
            }
   	    
   		  
         }
        
         }
         
         else {
        	 
        	 
        	 System.out.println("coming to else last accesstime");
        	 
        	
			
        	 
         }
        
         } 

        return result;
	}
	
*/

  
	
    }
