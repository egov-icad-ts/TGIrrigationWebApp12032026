package in.ts.icad.leagal.util;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

public class SingleUserLogin implements HttpSessionBindingListener {

	    private static Map<String, HttpSession> logins = Collections.synchronizedMap(new HashMap<String, HttpSession>());
	    
	    
	    public SingleUserLogin() {
	       
	    }
	    

	    public SingleUserLogin(String username) {
	        this.username = username;        
	    }
	    
	    private String username;


	  
	   
		public String getUsername() {
			return username;
		}


		public void setUsername(String username) {
			this.username = username;
		}


		public static Map<String, HttpSession> getLogins() {
			return logins;
		}


		public static void setLogins(Map<String, HttpSession> logins) {
			SingleUserLogin.logins = logins;
		}


		@Override
	    public void valueBound(HttpSessionBindingEvent event) {
			
			System.out.println("cominglistener"+ getUsername());
			
			
	        if (logins.containsKey(getUsername())) {
	            HttpSession session = logins.remove(getUsername());
	            if (session != null) {
	                session.invalidate();
	            }
	            logins.put(getUsername(), event.getSession());
	        } else {
	            logins.put(getUsername(), event.getSession());
	        }
	    }

	    @Override
	    public void valueUnbound(HttpSessionBindingEvent event) {
	    	
	    	System.out.println("removelistener"+ getUsername());
	        logins.remove(getUsername());
	    }
	}


