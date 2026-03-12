package in.ts.icad.leagal.util;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import in.ts.icad.leagal.model.User;


@Service
public class MyHttpServiceforLogout  {
	
	
   /* private JdbcTemplate jdbcTemplate;
	
	@Resource(name = "dataSource")
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	private static final long INTERVAL = 60 * 1000; // 1 minute interval
    private ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
    
    private Map<String, HttpSession> activeSessions = new ConcurrentHashMap<>();
    
    @PostConstruct
    public void init() {
    	
    	System.out.println("coming to init");
        scheduler.scheduleAtFixedRate(() -> {
            // Iterate over active sessions and check for inactivity
            for (String sessionId : activeSessions.keySet()) {
                HttpSession session = activeSessions.get(sessionId);
                long inactiveTime = System.currentTimeMillis() - session.getLastAccessedTime();
                int maxInactiveInterval = session.getMaxInactiveInterval();
                long maxInactiveIntervalInMinutes = maxInactiveInterval / 60;
                long inactiveTimeInMinutes = inactiveTime / 1000 / 60;
                
                System.out.println("inactiveTimeInMinutes"+inactiveTimeInMinutes);
                System.out.println("maxInactiveIntervalInMinutes"+maxInactiveIntervalInMinutes);

                if (inactiveTimeInMinutes >= (maxInactiveIntervalInMinutes - 2)) {
                    // Perform logout for the inactive session
                    User user = (User) session.getAttribute("userObj");
                    if (user != null && user.getUserName() != null) {
                    	
                    	 System.out.println("user.getUserName()"+user.getUserName());
                        String UPDATE_USER_ACCESS_ON_LOGOUT = "update access_logs set is_latest = false, logout_time  = now(), remarks_on_logout = 'Inactive User Logged Out Successfully' where username = ?";
                        Integer rowupdate=jdbcTemplate.update(UPDATE_USER_ACCESS_ON_LOGOUT, user.getUserName());
                        
                        System.out.println("rowupdate"+rowupdate);
                    }
                    session.invalidate();
                    activeSessions.remove(sessionId);
                }
            }
        }, 0, 2, TimeUnit.MINUTES);
    }

    
    public String logout(HttpSession session) {
        // Invalidate the session immediately when the logout request is received
        session.invalidate();
        return "redirect:/home"; // Redirect to login page after logout
    }
*/

}
