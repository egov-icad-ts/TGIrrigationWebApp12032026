package in.ts.icad.leagal.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class SessionUtils {
	
	public static long getLastAccessedTime(HttpSession session) {
        try {
        	
        	System.out.println("try");
            return session.getLastAccessedTime();
        } catch (IllegalStateException e) {
        	
        	System.out.println("catch");
            // Session is invalidated, return -1 or handle the situation as needed
            return -1;
        }
    }
	
	
	public static  void getLastsessionend(HttpSession session, HttpServletRequest request) {
        try {
        	
        	
        	session = request.getSession(false);
        	session.invalidate();
          
        } catch (IllegalStateException e) {
            // Session is invalidated, return -1 or handle the situation as needed
           
        }
    }

}
