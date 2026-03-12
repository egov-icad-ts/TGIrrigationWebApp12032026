package in.ts.icad.leagal.util;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
//@EnableScheduling
public class MyCronForExtraFloatDigits {
	
	private  JdbcTemplate jdbcTemplate;
	
	//private JdbcTemplate jdbcTemplate1;
	
	private  JdbcTemplate jdbcTemplate3;
	private  JdbcTemplate jdbcTemplate4;
	

	private JdbcTemplate jdbcTemplate6;
	
	private JdbcTemplate jdbcTemplate7;
	
	private JdbcTemplate jdbcTemplate8;
	

	
	//private JdbcTemplate jdbcTemplate9;
	
	private JdbcTemplate jdbcTemplate10;
	
	private JdbcTemplate jdbcTemplate11;
	
	private JdbcTemplate jdbcTemplate12;
	
	//private JdbcTemplate jdbcTemplate13;
	
	//private JdbcTemplate jdbcTemplate14;
	
	private JdbcTemplate jdbcTemplate15;
	

	
	
	

	@Resource(name = "dataSource")
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	/*@Resource(name = "dataSource1")
	public void setDataSource1(DataSource dataSource1) {
		this.jdbcTemplate1 = new JdbcTemplate(dataSource1);
	}*/
	
	@Resource(name = "dataSource3")
	public void setDataSource3(DataSource dataSource3) {
		this.jdbcTemplate3 = new JdbcTemplate(dataSource3);
	}

	@Resource(name = "dataSource4")
	public void setDataSource4(DataSource dataSource4) {
		this.jdbcTemplate4 = new JdbcTemplate(dataSource4);
	}
	
	@Resource(name = "dataSource6")
	public void setDataSource6(DataSource dataSource6) {
		this.jdbcTemplate6 = new JdbcTemplate(dataSource6);
	}
	
	@Resource(name = "dataSource7")
	public void setDataSource7(DataSource dataSource7) {
		this.jdbcTemplate7 = new JdbcTemplate(dataSource7);
	}
	
	
	
	@Resource(name = "dataSource8")
	public void setDataSource8(DataSource dataSource8) {
		this.jdbcTemplate8 = new JdbcTemplate(dataSource8);
	}
	
	/*@Resource(name = "dataSource9")
	public void setDataSource9(DataSource dataSource9) {
		this.jdbcTemplate9 = new JdbcTemplate(dataSource9);
	}
	*/

	@Resource(name = "dataSource10")
	public void setDataSource10(DataSource dataSource10) {
		this.jdbcTemplate10 = new JdbcTemplate(dataSource10);
	}
	
	@Resource(name = "dataSource11")
	public void setDataSource11(DataSource dataSource11) {
		this.jdbcTemplate11 = new JdbcTemplate(dataSource11);
	}
	
	@Resource(name = "dataSource12")
	public void setDataSource12(DataSource dataSource12) {
		this.jdbcTemplate12 = new JdbcTemplate(dataSource12);
	}
	/*@Resource(name = "dataSource13")
	public void setDataSource13(DataSource dataSource13) {
		this.jdbcTemplate13 = new JdbcTemplate(dataSource13);
	}
	@Resource(name = "dataSource14")
	public void setDataSource14(DataSource dataSource14) {
		this.jdbcTemplate14 = new JdbcTemplate(dataSource14);
	}*/
	
	@Resource(name = "dataSource15")
	public void setDataSource15(DataSource dataSource15) {
		this.jdbcTemplate15 = new JdbcTemplate(dataSource15);
	}
	

	
	
	
	
	
	
	
	@Value("${SELECT_CRON_EXTRA_FLOAT}")
	private  String SELECT_CRON_EXTRA_FLOAT;
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	@Scheduled(cron="0 */25 * *  * ?") //Or use this icadcc user
    public   void cronServiceMethod()
    {
       
        
        String sql="SELECT pg_terminate_backend(t.pid) FROM (SELECT pid FROM pg_stat_activity WHERE state = 'idle'  	AND query like '%float%' AND state_change<(now() - interval '10 mins')  And  datname='tsimis'  and usename='icadcc'   ) AS t";
        
      
       // System.out.println("Method executed at every 5 mins. Current time is :: "+sql);
        
        
     
        Boolean boLlist2=false;
        
        try {
 final List<Map<String, Object>> rows2 = jdbcTemplate.queryForList(sql );
        
        if (rows2 != null) {

			if (rows2.size() > 0) {						
				for (Map<String, Object> row : rows2) {
				
					boLlist2=Boolean.parseBoolean(  row.get("pg_terminate_backend").toString())	;
					
					// System.out.println("after executed at every 2 mins. Current time is :: "+boLlist);
					
				}						
			}

		}
        
 
        
     
			
        	jdbcTemplate.getDataSource().getConnection().close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{ 
		
			try {
				
				jdbcTemplate.getDataSource().getConnection().close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
    }
    
  //Or use this  //hrmstg
 //@Scheduled(cron="0 0 */3 *  * ?") 
  /*     public   void cronServiceMethod1()
    {
       
        
        String sql="SELECT pg_terminate_backend(t.pid) FROM (SELECT pid FROM pg_stat_activity WHERE state = 'idle'  	AND query like '%float%' AND state_change<(now() - interval '10 mins')) AS t";
        
      
       // System.out.println("Method executed at every 5 mins. Current time is :: "+sql);
        
        
     
        Boolean boLlist2=false;
        
        try {
 final List<Map<String, Object>> rows2 = jdbcTemplate1.queryForList(sql );
        
        if (rows2 != null) {

			if (rows2.size() > 0) {						
				for (Map<String, Object> row : rows2) {
				
					boLlist2=Boolean.parseBoolean(  row.get("pg_terminate_backend").toString())	;
					
					// System.out.println("after executed at every 2 mins. Current time is :: "+boLlist);
					
				}						
			}

		}
        
 
        
      
			
        	jdbcTemplate1.getDataSource().getConnection().close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{ 
		
			try {
				
				jdbcTemplate1.getDataSource().getConnection().close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
    }*/
    
 // @Scheduled(cron="0 */27 * *  * ?") //Or use this //task user
    public   void cronServiceMethod3()
    {
       
        
        String sql="SELECT pg_terminate_backend(t.pid) FROM (SELECT pid FROM pg_stat_activity WHERE state = 'idle'  	AND query like '%float%' AND state_change<(now() - interval '10 mins')  And  datname='tsimis'  and usename='task' ) AS t";
        
      
       // System.out.println("Method executed at every 5 mins. Current time is :: "+sql);
        
        
     
        Boolean boLlist2=false;
        
        try {
 final List<Map<String, Object>> rows2 = jdbcTemplate3.queryForList(sql );
        
        if (rows2 != null) {

			if (rows2.size() > 0) {						
				for (Map<String, Object> row : rows2) {
				
					boLlist2=Boolean.parseBoolean(  row.get("pg_terminate_backend").toString())	;
					
					// System.out.println("after executed at every 2 mins. Current time is :: "+boLlist);
					
				}						
			}

		}
        
 
        
        
			
        	jdbcTemplate3.getDataSource().getConnection().close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{ 
		
			try {
				
				jdbcTemplate3.getDataSource().getConnection().close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
    }
    
 // @Scheduled(cron="0 */35 * *  * ?") //Or use this//icadcomp user
    public   void cronServiceMethod4()
    {
       
        
        String sql="SELECT pg_terminate_backend(t.pid) FROM (SELECT pid FROM pg_stat_activity WHERE state = 'idle'  	AND query like '%float%' AND state_change<(now() - interval '10 mins')  And  datname='tsimis'  and usename='icadcomp') AS t";
        
      
       // System.out.println("Method executed at every 5 mins. Current time is :: "+sql);
        
        
       Boolean boLlist1=false;
       
       try {
        final List<Map<String, Object>> rows1 = jdbcTemplate4.queryForList(sql );
        
        if (rows1 != null) {

			if (rows1.size() > 0) {						
				for (Map<String, Object> row : rows1) {
				
					boLlist1=Boolean.parseBoolean(  row.get("pg_terminate_backend").toString())	;
					
					// System.out.println("after executed at every 2 mins. Current time is :: "+boLlist);
					
				}						
			}

		}
        
      
      
      
			jdbcTemplate4.getDataSource().getConnection().close();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{ 
		
			try {
				
				jdbcTemplate4.getDataSource().getConnection().close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
    }
	
	
    
 // @Scheduled(cron="0 */32 * *  * ?") //Or use this //irparas
    public   void cronServiceMethod6()
    {
       
        
        String sql="SELECT pg_terminate_backend(t.pid) FROM (SELECT pid FROM pg_stat_activity WHERE state = 'idle'  	AND query like '%float%' AND state_change<(now() - interval '10 mins') And  datname='tsimis'  and usename='irparas' ) AS t";
        
      
       // System.out.println("Method executed at every 5 mins. Current time is :: "+sql);
        
        
     
        Boolean boLlist2=false;
        
        try {
 final List<Map<String, Object>> rows2 = jdbcTemplate6.queryForList(sql );
        
        if (rows2 != null) {

			if (rows2.size() > 0) {						
				for (Map<String, Object> row : rows2) {
				
					boLlist2=Boolean.parseBoolean(  row.get("pg_terminate_backend").toString())	;
					
					// System.out.println("after executed at every 2 mins. Current time is :: "+boLlist);
					
				}						
			}

		}
        
 
        
      
			
			jdbcTemplate6.getDataSource().getConnection().close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{ 
		
			try {
				
				jdbcTemplate6.getDataSource().getConnection().close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
    }
	
	
	
	//@Scheduled(cron="0 */45 * *  * ?") //Or use this //inventory
    public   void cronServiceMethod7()
    {
       
        
        String sql="SELECT pg_terminate_backend(t.pid) FROM (SELECT pid FROM pg_stat_activity WHERE state = 'idle'  	AND query like '%float%' AND state_change<(now() - interval '10 mins') And  datname='tsimis'  and usename='inventory' ) AS t";
        
      
       // System.out.println("Method executed at every 5 mins. Current time is :: "+sql);
        
        
     
        Boolean boLlist2=false;
        
        try {
 final List<Map<String, Object>> rows2 = jdbcTemplate7.queryForList(sql );
        
        if (rows2 != null) {

			if (rows2.size() > 0) {						
				for (Map<String, Object> row : rows2) {
				
					boLlist2=Boolean.parseBoolean(  row.get("pg_terminate_backend").toString())	;
					
					// System.out.println("after executed at every 2 mins. Current time is :: "+boLlist);
					
				}						
			}

		}
        
 
        
      
			
        	jdbcTemplate7.getDataSource().getConnection().close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{ 
		
			try {
				
				jdbcTemplate7.getDataSource().getConnection().close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
    }
    
 // @Scheduled(cron="0 */29 * *  * ?") //Or use this //invom
    public   void cronServiceMethod8()
    {
       
        
        String sql="SELECT pg_terminate_backend(t.pid) FROM (SELECT pid FROM pg_stat_activity WHERE state = 'idle'  	AND query like '%float%' AND state_change<(now() - interval '10 mins') And  datname='tsimis'  and usename='invom' ) AS t";
        
      
       // System.out.println("Method executed at every 5 mins. Current time is :: "+sql);
        
        
     
        Boolean boLlist2=false;
        try {
 final List<Map<String, Object>> rows2 = jdbcTemplate8.queryForList(sql );
        
        if (rows2 != null) {

			if (rows2.size() > 0) {						
				for (Map<String, Object> row : rows2) {
				
					boLlist2=Boolean.parseBoolean(  row.get("pg_terminate_backend").toString())	;
					
					// System.out.println("after executed at every 2 mins. Current time is :: "+boLlist);
					
				}						
			}

		}
        
 
        
     
			
			jdbcTemplate8.getDataSource().getConnection().close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{ 
		
			try {
				
				jdbcTemplate8.getDataSource().getConnection().close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
    }
	
	//@Scheduled(cron="0  0  */2  *  * ?") //Or use this // mkuser
   /* public   void cronServiceMethod9()
    {
       
        
        String sql="SELECT pg_terminate_backend(t.pid) FROM (SELECT pid FROM pg_stat_activity WHERE state = 'idle'  	AND query like '%float%' AND state_change<(now() - interval '10 mins')) AS t";
        
      
       // System.out.println("Method executed at every 5 mins. Current time is :: "+sql);
        
        
     
        Boolean boLlist2=false;
 final List<Map<String, Object>> rows2 = jdbcTemplate9.queryForList(sql );
        
        if (rows2 != null) {

			if (rows2.size() > 0) {						
				for (Map<String, Object> row : rows2) {
				
					boLlist2=Boolean.parseBoolean(  row.get("pg_terminate_backend").toString())	;
					
					// System.out.println("after executed at every 2 mins. Current time is :: "+boLlist);
					
				}						
			}

		}
        
 
        
        try {
			
        	jdbcTemplate9.getDataSource().getConnection().close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{ 
		
			try {
				
				jdbcTemplate9.getDataSource().getConnection().close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
    }*/
    
  //@Scheduled(cron="0 */34 * *  * ?") //Or use this //tims123  stagemk
    public   void cronServiceMethod10()
    {
       
        
        String sql="SELECT pg_terminate_backend(t.pid) FROM (SELECT pid FROM pg_stat_activity WHERE state = 'idle'  	AND query like '%float%' AND state_change<(now() - interval '10 mins') And  datname='tsimis'  and usename='tims123' ) AS t";
        
      
       // System.out.println("Method executed at every 5 mins. Current time is :: "+sql);
        
        
     
        Boolean boLlist2=false;
        
        try {
 final List<Map<String, Object>> rows2 = jdbcTemplate10.queryForList(sql );
        
        if (rows2 != null) {

			if (rows2.size() > 0) {						
				for (Map<String, Object> row : rows2) {
				
					boLlist2=Boolean.parseBoolean(  row.get("pg_terminate_backend").toString())	;
					
					// System.out.println("after executed at every 2 mins. Current time is :: "+boLlist);
					
				}						
			}

		}
        
 
        
      
			
			jdbcTemplate10.getDataSource().getConnection().close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{ 
		
			try {
				
				jdbcTemplate10.getDataSource().getConnection().close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
    }
    
//  @Scheduled(cron="0 */24 * *  * ?") //Or use this // stagehrms123
    public   void cronServiceMethod11()
    {
       
        
        String sql="SELECT pg_terminate_backend(t.pid) FROM (SELECT pid FROM pg_stat_activity WHERE state = 'idle'  	AND query like '%float%' AND state_change<(now() - interval '10 mins') And  datname='tsimis'  and usename='stagehrms123'  ) AS t";
        
      
       // System.out.println("Method executed at every 5 mins. Current time is :: "+sql);
        
        
     
        Boolean boLlist2=false;
        
        try {
 final List<Map<String, Object>> rows2 = jdbcTemplate11.queryForList(sql );
        
        if (rows2 != null) {

			if (rows2.size() > 0) {						
				for (Map<String, Object> row : rows2) {
				
					boLlist2=Boolean.parseBoolean(  row.get("pg_terminate_backend").toString())	;
					
					// System.out.println("after executed at every 2 mins. Current time is :: "+boLlist);
					
				}						
			}

		}
        
 
        
       
			
        	jdbcTemplate11.getDataSource().getConnection().close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{ 
		
			try {
				
				jdbcTemplate11.getDataSource().getConnection().close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
    }
	
	//@Scheduled(cron="0 */40 * *  * ?") //Or use this  //  tsimis_r
    public   void cronServiceMethod12()
    {
       
        
        String sql="SELECT pg_terminate_backend(t.pid) FROM (SELECT pid FROM pg_stat_activity WHERE state = 'idle'  	AND query like '%float%' AND state_change<(now() - interval '10 mins') And  datname='tsimis'  and usename='tsimis_r' ) AS t";
        
      
       // System.out.println("Method executed at every 5 mins. Current time is :: "+sql);
        
        
     
        Boolean boLlist2=false;
        
        try {
 final List<Map<String, Object>> rows2 = jdbcTemplate12.queryForList(sql );
        
        if (rows2 != null) {

			if (rows2.size() > 0) {						
				for (Map<String, Object> row : rows2) {
				
					boLlist2=Boolean.parseBoolean(  row.get("pg_terminate_backend").toString())	;
					
					// System.out.println("after executed at every 2 mins. Current time is :: "+boLlist);
					
				}						
			}

		}
        
 
        
      
			
        	jdbcTemplate12.getDataSource().getConnection().close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{ 
		
			try {
				
				jdbcTemplate12.getDataSource().getConnection().close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
    }
	
	//@Scheduled(cron="0 14 */3  *  * ?") //Or use this // irrigation_ts_wts
  /*  public   void cronServiceMethod13()
    {
       
        
        String sql="SELECT pg_terminate_backend(t.pid) FROM (SELECT pid FROM pg_stat_activity WHERE state = 'idle'  	AND query like '%float%' AND state_change<(now() - interval '10 mins')) AS t";
        
      
       // System.out.println("Method executed at every 5 mins. Current time is :: "+sql);
        
        
     
        Boolean boLlist2=false;
        
        try {
 final List<Map<String, Object>> rows2 = jdbcTemplate13.queryForList(sql );
        
        if (rows2 != null) {

			if (rows2.size() > 0) {						
				for (Map<String, Object> row : rows2) {
				
					boLlist2=Boolean.parseBoolean(  row.get("pg_terminate_backend").toString())	;
					
					// System.out.println("after executed at every 2 mins. Current time is :: "+boLlist);
					
				}						
			}

		}
        
 
        
       
			
        	jdbcTemplate13.getDataSource().getConnection().close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{ 
		
			try {
				
				jdbcTemplate13.getDataSource().getConnection().close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
    }*/
	
	//@Scheduled(cron="0  10  */3 *  * ?") //Or use this // irrigationpmstg
   /* public   void cronServiceMethod14()
    {
       
        
        String sql="SELECT pg_terminate_backend(t.pid) FROM (SELECT pid FROM pg_stat_activity WHERE state = 'idle'  	AND query like '%float%' AND state_change<(now() - interval '10 mins')) AS t";
        
      
       // System.out.println("Method executed at every 5 mins. Current time is :: "+sql);
        
        
     
        Boolean boLlist2=false;
        
        try {
 final List<Map<String, Object>> rows2 = jdbcTemplate14.queryForList(sql );
        
        if (rows2 != null) {

			if (rows2.size() > 0) {						
				for (Map<String, Object> row : rows2) {
				
					boLlist2=Boolean.parseBoolean(  row.get("pg_terminate_backend").toString())	;
					
					// System.out.println("after executed at every 2 mins. Current time is :: "+boLlist);
					
				}						
			}

		}
        
 
        
      
        	jdbcTemplate14.getDataSource().getConnection().close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{ 
		
			try {
				
				jdbcTemplate14.getDataSource().getConnection().close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
    }*/
	
	//@Scheduled(cron="0 */37 * *  * ?") //Or use this  stagepm123
    public   void cronServiceMethod15()
    {
       
        
        String sql="SELECT pg_terminate_backend(t.pid) FROM (SELECT pid FROM pg_stat_activity WHERE state = 'idle'  	AND query like '%float%' AND state_change<(now() - interval '10 mins')  And  datname='tsimis'  and usename='stagepm123'   ) AS t";
        
      
       // System.out.println("Method executed at every 5 mins. Current time is :: "+sql);
        
        
     
        Boolean boLlist2=false;
        
        try {
 final List<Map<String, Object>> rows2 = jdbcTemplate15.queryForList(sql );
        
        if (rows2 != null) {

			if (rows2.size() > 0) {						
				for (Map<String, Object> row : rows2) {
				
					boLlist2=Boolean.parseBoolean(  row.get("pg_terminate_backend").toString())	;
					
					// System.out.println("after executed at every 2 mins. Current time is :: "+boLlist);
					
				}						
			}

		}
        
 
        
       
			
        	jdbcTemplate15.getDataSource().getConnection().close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{ 
		
			try {
				
				jdbcTemplate15.getDataSource().getConnection().close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
    }
	
	
	

}
