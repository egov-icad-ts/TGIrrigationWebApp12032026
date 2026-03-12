package in.ts.icad.leagal.util;



import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;

import in.ts.icad.leagal.dao.LeagalWebDAO;
import in.ts.icad.leagal.exception.LeagalUserException;
import in.ts.icad.leagal.model.Unit;

@Service
public class UserDBUtil {
	
	/*private static JdbcTemplate jdbcHrmsTemplate;*/

	/*@Resource(name = "dataSource1")
	public void setDataSource1(DataSource dataSource) {
		this.jdbcHrmsTemplate = new JdbcTemplate(dataSource);
	}
	
	@Value("${UNIT_NAME}")
	private static String UNIT_NAME;
	
	@Value("${CIRCLE_NAME}")
	private static String CIRCLE_NAME;
	
	@Value("${DIVISION_NAME}")
	private static String DIVISION_NAME;
	
	@Value("${SUBDIVISION_NAME}")
	private String SUBDIVISION_NAME;
	
	@Value("${SELECT_UNIT}")
	private static String SELECT_UNIT;
	
	
	
	public static String getUnitName(Integer unitId) {
		
		String  sql=UNIT_NAME;
		
		String uName=null;
		


		// TODO Auto-generated method stub
		try{
		final List<Map<String, Object>> rows1 = jdbcHrmsTemplate.queryForList(sql,
				new Object[] {unitId});
		
		
		if (rows1 != null) {

			if (rows1.size() > 0) {						
				for (Map<String, Object> row : rows1) {
				
					uName=row.get("unit_name").toString()	;
					
				}						
			}
			
		}
		jdbcHrmsTemplate.getDataSource().getConnection().close();
		}catch(Exception e){
			
			try {
				jdbcHrmsTemplate.getDataSource().getConnection().close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return uName;
	}


	
	public static String getCircleName(Integer circleId) {
		// TODO Auto-generated method stub
		 String sql=CIRCLE_NAME;
		

			String cName=null;
			


			// TODO Auto-generated method stub
			try{
			final List<Map<String, Object>> rows1 = jdbcHrmsTemplate.queryForList(sql,
					new Object[] {circleId});
			
			
			if (rows1 != null) {

				if (rows1.size() > 0) {						
					for (Map<String, Object> row : rows1) {
					
						cName=row.get("circle_name").toString()	;
						
					}						
				}

			}
			jdbcHrmsTemplate.getDataSource().getConnection().close();
			}catch(Exception e){
				
				try {
					jdbcHrmsTemplate.getDataSource().getConnection().close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			return cName;
	}


	
	public static String getDivisionName(Integer divisionId)  {
		// TODO Auto-generated method stub
		 String sql=DIVISION_NAME;
		

			String dName=null;
			


			// TODO Auto-generated method stub
			try{
			final List<Map<String, Object>> rows1 = jdbcHrmsTemplate.queryForList(sql,
					new Object[] {divisionId});
			
			
			if (rows1 != null) {

				if (rows1.size() > 0) {						
					for (Map<String, Object> row : rows1) {
					
						dName=row.get("division_name").toString()	;
						
					}						
				}

			}
			jdbcHrmsTemplate.getDataSource().getConnection().close();
			}catch(Exception e){
				
				try {
					jdbcHrmsTemplate.getDataSource().getConnection().close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			return dName;
	}


	
	public String getSubdivisionName(Integer subdivisionId) {
		// TODO Auto-generated method stub
		 String sql=SUBDIVISION_NAME;

			String sName=null;
			


			// TODO Auto-generated method stub
			try{
			final List<Map<String, Object>> rows1 = jdbcHrmsTemplate.queryForList(sql,
					new Object[] {subdivisionId});
			
			
			if (rows1 != null) {

				if (rows1.size() > 0) {						
					for (Map<String, Object> row : rows1) {
					
						sName=row.get("subdivision_name").toString()	;
						
					}						
				}

			}
			jdbcHrmsTemplate.getDataSource().getConnection().close();
			}catch(Exception e){
				
				try {
					jdbcHrmsTemplate.getDataSource().getConnection().close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			return sName;
	}
	
	
	
	public static List<Unit> getUnitList() throws LeagalUserException {
		// TODO Auto-generated method stub
		String sql = SELECT_UNIT;
		try {

			List<Unit> unitList = jdbcHrmsTemplate.query(sql,
					new RowMapper<Unit>() {

						public Unit mapRow(ResultSet rs, int rowNum)
								throws SQLException {

							Unit unit = new Unit();
							unit.setUnitId(rs.getInt(1));
							unit.setUnitName(rs.getString(2));
							return unit;
						}

					});

			return unitList;
		} catch (Exception exc) {
			
			return null;
		}
	}*/
	
}
