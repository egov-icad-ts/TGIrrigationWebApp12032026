package in.ts.icad.leagal.util;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import javax.sql.DataSource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.context.support.WebApplicationContextUtils;

import in.ts.icad.leagal.exception.LeagalUserException;
import in.ts.icad.leagal.manager.LeagalAdminManager;
import in.ts.icad.leagal.manager.LeagalWebManager;
import in.ts.icad.leagal.model.User;

@Service
public class MyHttpSessionListener   implements HttpSessionListener{

	
	
	
	private static final long INTERVAL = 60 * 1000; // 1 minute interval
    private ScheduledExecutorService scheduler=Executors.newScheduledThreadPool(1);;
    
 
    @Autowired
	private LeagalAdminManager leagalAdminManager;
    
  
    private JdbcTemplate jdbcTemplate;
    

	/*@Resource(name = "dataSource")
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}*/
    
    Boolean updateFlag=false;
    
    
	//HttpSessionEventPublisher
	
	  private static final String LOGGER_NAME = HttpSessionEventPublisher.class.getName(); 
	  
	  ApplicationContext getContext(ServletContext servletContext) { 
	        return WebApplicationContextUtils.getWebApplicationContext(servletContext); 
	    } 
	  private int sessionCount = 0;
	  HttpServletResponse response;

	
	@Override
	public void sessionCreated(HttpSessionEvent event) {
		
		//System.out.println("coming to MyHttpSessionListener"+sessionCount);
		
		 HttpSessionCreatedEvent e = new HttpSessionCreatedEvent(event.getSession()); 
	        Log log = LogFactory.getLog(LOGGER_NAME); 
		// TODO Auto-generated method stub
	        
	        if (log.isDebugEnabled()) { 
	            log.debug("Publishing event: " + e); 
	        } 
	 
	      //  getContext(event.getSession().getServletContext()).publishEvent(e); 
		sessionCount++; 
		event.getSession().setMaxInactiveInterval(20*60);
		
		HttpSession session=event.getSession();
		
	
		
		
		 scheduler = Executors.newSingleThreadScheduledExecutor();
	        scheduler.scheduleAtFixedRate(() -> {
	            // Your periodic task logic here
	          //  System.out.println("Running periodic task. invalidateSession.."+session);
	            
	            if (session != null) {
	   	         long inactiveTime = System.currentTimeMillis() - session.getLastAccessedTime();
	   	         int maxInactiveInterval = session.getMaxInactiveInterval();

	   	         long maxInactiveIntervalInMinutes = maxInactiveInterval / 60;

	   	         long inactiveTimeInSeconds = inactiveTime / 1000;

	   	         long inactiveTimeInMinutes = inactiveTimeInSeconds / 60;

	   	         //System.out.println("Inactive time: " + inactiveTimeInMinutes + " minutes");
	   	     // System.out.println("maxInactiveIntervalInMinutes: " + maxInactiveIntervalInMinutes + " minutes");
	   	         
	   	         User user = (User) session.getAttribute("userObj");

	   	         if (inactiveTimeInMinutes >= (maxInactiveIntervalInMinutes-1)) {
	   	        	
	   	        	 if (user != null && user.getUserName() != null) {
	   	                   // System.out.println("inactiveTimeInMinutes" + inactiveTimeInMinutes+user.getUserName());
	   	                   // System.out.println("maxInactiveIntervalInMinutes" + maxInactiveIntervalInMinutes);
	   	                    
	   	                // System.out.println("updateFlag"+updateFlag);
	   	                 //updateFlag=leagalAdminManager.updateUserLogout(user.getUserName());
	   	                
	   	          String     sql = "update access_logs set is_latest = false, logout_time  = now(), remarks_on_logout = 'In active User Logged Out Successfully' where username = ? and is_latest =true" ;
	   	             
	   	          
	   	       //System.out.println("sql"+sql);
	   	       
	   	       String userName=user.getUserName();
	   	      
	   	    Integer rowsUpdated = jdbcTemplate.update(sql,new Object[] { userName });
	   	    
	   	  //System.out.println("rowsUpdated"+rowsUpdated);
	   	           
	   	 if (rowsUpdated > 0) {
	   	   // System.out.println("User logout updated successfully");
	   	    updateFlag = true;
	   	} else {
	   	  //  System.out.println("Failed to update user logout");
	   	  updateFlag = false;
	   	}

	   	   		
	   	           
	   	    
	   	           
	   	           try {
	   	   			
	   	   			jdbcTemplate.getDataSource().getConnection().close();
	   	   			
	   	   		} catch (SQLException ex) {
	   	   			// TODO Auto-generated catch block
	   	   			ex.printStackTrace();
	   	   		}
	   	          
	   	          
	   	          
	   	         // System.out.println("2updateFlag"+updateFlag);
	   	                    
	   	              //System.out.println("Session invalidated at: " + System.currentTimeMillis());//response.sendRedirect("../web/logout");
	   	              
	   	              //if(updateFlag==true){
	   	                    
	   	              
	   	                 
	   	             // }
	   	   	            
	   	                    
	   	                 
	   	                   
	   	                }
	   	        	 
	   	    	    
	   	         
	   	     }
	   	 }
	   	    
	   	 	            
	            //System.out.println("going to  invalidateSession..."+session+updateFlag);
	        }, 0, 19, TimeUnit.MINUTES);
		
	}

	 
	
	@Override
	public void sessionDestroyed(HttpSessionEvent event)  {
		// TODO Auto-generated method stub
		
		 scheduler.shutdown();
		 
		// System.out.println("coming to sessionDestroyed"+sessionCount);
		
		 HttpSessionDestroyedEvent e = new HttpSessionDestroyedEvent(event.getSession()); 
	        Log log = LogFactory.getLog(LOGGER_NAME); 
	 
	        if (log.isDebugEnabled()) { 
	            log.debug("Publishing event: " + e); 
	        } 
	        
	         // getContext(event.getSession().getServletContext()).publishEvent(e);  
		
		 sessionCount--;
		HttpSession session=event.getSession();
		
		if(session != null){
	        session.invalidate();
	       // response.sendRedirect("/web/logout");
	  }
		
	}

}
