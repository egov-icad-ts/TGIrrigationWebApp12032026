package in.ts.icad.leagal.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;



import in.ts.icad.leagal.dao.LeagalAdminDAO;
import in.ts.icad.leagal.exception.LeagalUserException;
import in.ts.icad.leagal.model.CaseGenSub;
import in.ts.icad.leagal.model.CaseStages;
import in.ts.icad.leagal.model.CaseStatus;
import in.ts.icad.leagal.model.CaseType;
import in.ts.icad.leagal.model.CaseTypeOrder;
import in.ts.icad.leagal.model.Cases;
import in.ts.icad.leagal.model.CasesGeneral;
import in.ts.icad.leagal.model.Circle;
import in.ts.icad.leagal.model.ContactPerson;
import in.ts.icad.leagal.model.District;
import in.ts.icad.leagal.model.Division;
import in.ts.icad.leagal.model.Mandal;
import in.ts.icad.leagal.model.Packages;
import in.ts.icad.leagal.model.Petitioner;
import in.ts.icad.leagal.model.PetitionerAdvocate;
import in.ts.icad.leagal.model.Project;
import in.ts.icad.leagal.model.Respondent;
import in.ts.icad.leagal.model.RespondentAdvocate;
import in.ts.icad.leagal.model.Subdivision;
import in.ts.icad.leagal.model.Unit;
import in.ts.icad.leagal.model.User;
import in.ts.icad.leagal.model.Village;
import in.ts.icad.leagal.util.DateUtil;

@Repository
public class LeagalAdminDAOImpl  implements LeagalAdminDAO{
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	private final boolean IS_DEBUG_ENABLED = log.isDebugEnabled();

	private JdbcTemplate jdbcTemplate;
	private JdbcTemplate jdbcTemplate3;
	
	
	@Resource(name = "dataSource")
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Resource(name = "dataSource3")
	public void setDataSource3(DataSource dataSource3) {
		this.jdbcTemplate3 = new JdbcTemplate(dataSource3);
	}

	
	

	/*private JdbcTemplate jdbcHrmsTemplate;

	@Resource(name = "dataSource1")
	public void setDataSource1(DataSource dataSource) {
		this.jdbcHrmsTemplate = new JdbcTemplate(dataSource);
	}
*/
	
	@Value("${SELECT_UNIT}")
	private String SELECT_UNIT;
	
	@Value("${GET_CIRCLE_LIST}")
	private String GET_CIRCLE_LIST;
	
	@Value("${GET_DIVISION_LIST}")
	private String GET_DIVISION_LIST;
	
	
	@Value("${SELECT_CIRCLE}")
	private String SELECT_CIRCLE;
	@Value("${SELECT_DIVISION}")
	private String SELECT_DIVISION;
	@Value("${SELECT_SUBDIVISION}")
	private String SELECT_SUBDIVISION;
	
	@Value("${SELECT_PROJECTS}")
	private String SELECT_PROJECTS;
	@Value("${SELECT_PACKAGES}")
	private String SELECT_PACKAGES;
	@Value("${GET_CIRCLES}")
	private String GET_CIRCLES;
	@Value("${GET_DIVISIONS}")
	private String GET_DIVISIONS;
	@Value("${GET_SUBDIVISIONS_ON_DIVISION}")
	private String GET_SUBDIVISIONS_ON_DIVISION;
	@Value("${GET_SECTION_ON_SUBDIVISION}")
	private String GET_SECTION_ON_SUBDIVISION;
	@Value("${GET_DISTRICTS}")
	private String GET_DISTRICTS;
	@Value("${GET_MANDALS}")
	private String GET_MANDALS;
	@Value("${GET_VILLAGES}")
	private String GET_VILLAGES;
	
	@Value("${SELECT_CASE_TYPES}")
	private String SELECT_CASE_TYPES;
	@Value("${SELECT_CASES_GEN_SUB}")
	private String SELECT_CASES_GEN_SUB;
	@Value("${SELECT_PETITIONERS}")
	private String SELECT_PETITIONERS;
	@Value("${SELECT_PET_ADVOCATES}")
	private String SELECT_PET_ADVOCATES;
	@Value("${SELECT_RESPONDENTS}")
	private String SELECT_RESPONDENTS;
	@Value("${SELECT_RES_ADVOCATES}")
	private String SELECT_RES_ADVOCATES;
	@Value("${SELECT_CASE_STAGES}")
	private String SELECT_CASE_STAGES;
	@Value("${SELECT_CASE_STATUS}")
	private String SELECT_CASE_STATUS;
	
	@Value("${SELECT_CASE_GEN}")
	private String SELECT_CASE_GEN;
	
	
	
	
	
	
	
	
	@Value("${SELECT_COUNT_CM}")
	private String SELECT_COUNT_CM;
	@Value("${INSERT_CASES_MASTER}")
	private String INSERT_CASES_MASTER;
	
	@Value("${INSERT_CASES_PET}")
	private String INSERT_CASES_PET;
	@Value("${INSERT_CASES_PETADV}")
	private String INSERT_CASES_PETADV;
	@Value("${INSERT_CASES_RESADV}")
	private String INSERT_CASES_RESADV;
	@Value("${INSERT_CASES_RES}")
	private String INSERT_CASES_RES;	
	@Value("${INSERT_CON_PER}")
	private String INSERT_CON_PER;
	
	@Value("${GET_USER_DETAILS}")
	private String GET_USER_DETAILS;
	
	@Value("${GET_POST_USER}")
	private String GET_POST_USER;
	
	@Value("${INSERT_PET_MST}")
	private String INSERT_PET_MST;
	
	@Value("${INSERT_PETADV_MST}")
	private String INSERT_PETADV_MST;
	
	@Value("${INSERT_RES_MST}")
	private String INSERT_RES_MST;
	
	@Value("${INSERT_RESADV_MST}")
	private String INSERT_RESADV_MST;
	
	@Value("${INSERT_PACK_MST}")
	private String INSERT_PACK_MST;
	
	@Value("${GET_CASES}")
	private String GET_CASES;
	
	@Value("${SELECT_CASE_BY_CASEID}")
	private String SELECT_CASE_BY_CASEID;
	
	@Value("${INSERT_CASE_GEN}")
	private String INSERT_CASE_GEN;
	
	@Value("${INSERT_CASE_TYPE_MST}")
	private String INSERT_CASE_TYPE_MST;
	
	@Value("${INSERT_CASE_GEN_SUB_MST}")
	private String INSERT_CASE_GEN_SUB_MST;
	
	
	
	
	@Value("${DELETE_CM}")
	private String DELETE_CM;
	
	
	@Value("${DELETE_CCP}")
	private String DELETE_CCP;
	
	@Value("${DELETE_CPA}")
	private String DELETE_CPA;
	
	@Value("${DELETE_CP}")
	private String DELETE_CP;
	
	
	@Value("${DELETE_CRA}")
	private String DELETE_CRA;
	
	@Value("${DELETE_CR}")
	private String DELETE_CR;
	
	@Value("${EDIT_CM}")
	private String EDIT_CM;
	
	@Value("${EDIT_CCP}")
	private String EDIT_CCP;
	
	@Value("${EDIT_CPA}")
	private String EDIT_CPA;
	
	@Value("${EDIT_CP}")
	private String EDIT_CP;
	
	@Value("${EDIT_CRA}")
	private String EDIT_CRA;
	
	@Value("${EDIT_CR}")
	private String EDIT_CR;
	
	@Value("${SELECT_CASE_EDIT}")
	private String SELECT_CASE_EDIT;
	
	@Value("${UNIT_NAME}")
	private String UNIT_NAME;
	
	@Value("${CIRCLE_NAME}")
	private String CIRCLE_NAME;
	
	@Value("${DIVISION_NAME}")
	private String DIVISION_NAME;
	
	@Value("${SUBDIVISION_NAME}")
	private String SUBDIVISION_NAME;
	
	@Value("${SELECT_TYPE_ORDERS}")
	private String SELECT_TYPE_ORDERS;
	
	
	@Value("${EDIT_CDH}")
	private String EDIT_CDH;
	
	@Value("${INSERT_CASE_DATE_HEAR}")
	private String INSERT_CASE_DATE_HEAR;
	
	@Value("${INSERT_CASE_TYPE_OS}")
	private String INSERT_CASE_TYPE_OS;
	
	@Value("${EDIT_CTOS}")
	private String EDIT_CTOS;
	
	@Value("${SELECT_CTOS_STATUS}")
	private String SELECT_CTOS_STATUS;
	
	@Value("${SELECT_CDH_STATUS}")
	private String SELECT_CDH_STATUS;
	
	@Value("${SELECT_PET_BY_CASECOUNT}")
	private String SELECT_PET_BY_CASECOUNT;
	
	@Value("${SELECT_PETADV_BY_CASECOUNT}")
	private String SELECT_PETADV_BY_CASECOUNT;
	
	@Value("${SELECT_TASK_USERPOST}")
	private String SELECT_TASK_USERPOST;
	
	@Value("${SELECT_PETITIONER_BYID}")
	private String SELECT_PETITIONER_BYID;
	
	@Value("${SELECT_PET_ADVOCATE_BY_ID}")
	private String SELECT_PET_ADVOCATE_BY_ID;
	
	@Value("${SELECT_RESPONDENTS_BY_ID}")
	private String SELECT_RESPONDENTS_BY_ID;
	
	@Value("${SELECT_RES_ADVOCATES_BY_Id}")
	private String SELECT_RES_ADVOCATES_BY_Id;
	
	@Value("${CHANGE_PASSWORD}")
	private String CHANGE_PASSWORD;
	
	@Value("${CHANGE_PASSWORD_ADMIN}")
	private String CHANGE_PASSWORD_ADMIN;
	
	@Value("${SELECT_USER_EMP_DATA}")
	private String SELECT_USER_EMP_DATA;
	
	@Value("${CHANGE_PASSWORD_EMP}")
	private String CHANGE_PASSWORD_EMP;
	
	@Value("${SELECT_USER_VALIDITY}")
	private String SELECT_USER_VALIDITY;
	
	@Value("${SELECT_PROJECTS_ADMIN}")
	private String SELECT_PROJECTS_ADMIN;
	
	
	@Value("${SELECT_PROJECTS_ADMIN_UNIT}")
	private String SELECT_PROJECTS_ADMIN_UNIT;
	
	@Value("${INSERT_FAILED_ACCESS_LOGS}")
	private String INSERT_FAILED_ACCESS_LOGS;
	
	@Value("${INSERT_ACCESS_LOG_ON_LOGIN}")
	private String INSERT_ACCESS_LOG_ON_LOGIN;
	
	@Value("${UPDATE_USER_ACCESS_ON_LOGOUT}") 
	private String UPDATE_USER_ACCESS_ON_LOGOUT;
	
	@Value("${GET_LOGOUTDETAILS}")
	private String GET_LOGOUTDETAILS;
	
	@Value("${UPDATE_USER_ACCESS_ON_SESSIONTIMEOUT}")
	private String UPDATE_USER_ACCESS_ON_SESSIONTIMEOUT;
	
	@Value("${SELECT_USER_CONCURRENT_LOGIN}")
	private String SELECT_USER_CONCURRENT_LOGIN;
	
	@Value("${GET_LOGIN_ATTEMPT_COUNT}")
	private String GET_LOGIN_ATTEMPT_COUNT;
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@Override
	public Integer editData(String query) {
		// TODO Auto-generated method stub

		int count = 0;
		Boolean flag = false;
		try {
			count = jdbcTemplate.update(query);
			flag = true;
		} catch (Exception e) {
			flag = false;
			e.printStackTrace();
		}
		//System.out.println("Count in DAO IMPL" + count);
		return count;

	}

@Override
public List<Map<String, Object>> generalqueryforresult(String generalquery) {
	// TODO Auto-generated method stub
	List<Map<String,Object>> rs = new ArrayList<Map<String,Object>>();
	int count = 0;
	try {
		if(generalquery.toLowerCase().contains("select")){
		List<Map<String, Object>> result = jdbcTemplate.queryForList(generalquery);
		for (Map<String, Object> row : result){
			rs.add(row);
		}
		}else
		{
		
		count = jdbcTemplate.update(generalquery);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("1", count);
		rs.add(map);
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
	return rs;
	
	
}

	



@Override
public Boolean getUservalidity(String userName, String password)
		throws LeagalUserException {

	String sql = SELECT_USER_VALIDITY;
	Boolean flag=false;
	Integer usercount=0;
	try {


		List<Map<String, Object>> 	ct=	jdbcTemplate3.queryForList(sql, new Object[] {userName, password,userName, password} );
		
		
		for (Map<String, Object> row : ct) {
			usercount = Integer.parseInt(row.get("usercount").toString());
		}
      
		final Integer casect=usercount;
		
		if(casect>0){
			
			flag=true;
			
		}
		
		if(casect==0){
			
			flag=false;
		}
		

				
				
				
				
				
			
	
		
		jdbcTemplate3.getDataSource().getConnection().close();
        
		return flag;
	} catch (Exception exc) {
		log.error(exc.getMessage());
		return flag;
	}

}
	
	
	@Override
	public List<User> getUserDetails(String userName, String password)
			throws LeagalUserException {

		String sql = SELECT_TASK_USERPOST;
		try {


                //System.out.println("GET_USER_DETAILS"+"--"+userName+"--"+password);
			List<User> User = jdbcTemplate3.query(sql, new Object[] {
					userName, password }, new RowMapper<User>() {

				public User mapRow(ResultSet rs, int rowNum)
						throws SQLException {

					User users = new User();
					users.setUserId(rs.getInt(5));
					users.setUserName(rs.getString(6));
					users.setPassword(rs.getString(7));
					
					users.setRoleId(rs.getInt(8));
					users.setProjectId(rs.getInt(9));
					users.setPackageId(rs.getInt(10));
					users.setUnitId(rs.getInt(11));
					users.setUnitName(rs.getString(1));
					users.setCircleId(rs.getInt(12));
					users.setCircleName(rs.getString(2));
					
					users.setDivisionId(rs.getInt(13));
					users.setDivisionName(rs.getString(3));
					users.setSubdivisionId(rs.getInt(14));
					users.setSubdivisionName(rs.getString(4));
					
					
					/*users.setCircleId(rs.getInt(5));
					users.setCircleName(rs.getString(6));
					users.setUnitId(rs.getInt(7));
					users.setUnitName(rs.getString(8));
					users.setDivisionId(rs.getInt(9));
					users.setDivisionName(rs.getString(10));
					users.setSubdivisionId(rs.getInt(11));
					users.setSubdivisionName(rs.getString(12));*/
					
					

					
					
					
					
					
					return users;

				}

			});
			
			jdbcTemplate3.getDataSource().getConnection().close();

			return User;
		} catch (Exception exc) {
			log.error(exc.getMessage());
			return null;
		}

	}
	
	
	@Override
	public List<User> getEmpDetails(String userName, String password)
			throws LeagalUserException {

		String sql = SELECT_USER_EMP_DATA;
		try {


             //   System.out.println("SELECT_USER_EMP_DATA"+"--"+SELECT_USER_EMP_DATA);
			List<User> User = jdbcTemplate3.query(sql, new Object[] {
					userName, password , userName, password}, new RowMapper<User>() {

				public User mapRow(ResultSet rs, int rowNum)
						throws SQLException {

					User users = new User();
					
					//  System.out.println("rs.getString(1)"+"--"+rs.getString(1)+"--"+rs.getString(1));
					users.setUserEmpId(rs.getString(1));
					users.setUserName(rs.getString(2));
					users.setPassword(rs.getString(3));
					users.setEmpId(rs.getInt(4));
					users.setEmployeeName(rs.getString(5));
					users.setEmail(rs.getString(6));
					users.setPhoneno(rs.getString(7));
					users.setPost(Long.parseLong(rs.getString(8)));
					users.setUnitId(rs.getInt(9));
					users.setCircleId(rs.getInt(10));
					users.setDivisionId(rs.getInt(11));
					//System.out.println("rs.getInt(12)"+rs.getInt(12));
					users.setSubdivisionId(rs.getInt(12));
					users.setSectionId(rs.getInt(13));
					users.setDesignationId(rs.getInt(14));
					users.setEmpId(rs.getInt(15));
					
					users.setDesignationName(rs.getString(16));
					users.setUnitName(rs.getString(17));
					users.setCircleName(rs.getString(18));
					users.setDivisionName(rs.getString(19));
					
					users.setSubdivisionName(rs.getString(20));
					users.setSectionName(rs.getString(21));
					users.setUserCategory(rs.getInt(22));
					users.setOdType(rs.getString(23));
					
					
					return users;

				}

			});
			
			jdbcTemplate3.getDataSource().getConnection().close();

			return User;
		} catch (Exception exc) {
			log.error(exc.getMessage());
			return null;
		}

	}
	
	
	
	
	
	@Override
	public User getUserPostDetails(String userName, String password)
			throws LeagalUserException {
		
		String sql = GET_POST_USER;
		try {
			User postUsers = (User) jdbcTemplate.queryForObject(
					sql, new Object[] { userName, password },
					new RowMapper<Object>() {
						public Object mapRow(ResultSet rs, int rowNum)
								throws SQLException {
							User postgresUsers = new User();
							postgresUsers.setUserId(rs.getInt(1));
						    postgresUsers.setUserName(rs.getString(2));
						  
						    postgresUsers.setRoleId(rs.getInt(3));
						    postgresUsers.setPassword(rs.getString(4));

							return postgresUsers;
						}
					});
			
			jdbcTemplate.getDataSource().getConnection().close();
			return postUsers;
		} catch (Exception exc) {
			log.error(exc.getMessage());
			return null;
		}
	}
	
	
	
	@Override
	public List<Unit> getUnitList() throws LeagalUserException {
		// TODO Auto-generated method stub
		String sql = SELECT_UNIT;
		try {

			List<Unit> unitList = jdbcTemplate.query(sql,
					new RowMapper<Unit>() {

						public Unit mapRow(ResultSet rs, int rowNum)
								throws SQLException {

							Unit unit = new Unit();
							unit.setUnitId(rs.getInt(1));
							unit.setUnitName(rs.getString(2));
							return unit;
						}

					});
			jdbcTemplate.getDataSource().getConnection().close();

			return unitList;
		} catch (Exception exc) {
			log.error(exc.getMessage());
			return null;
		}
	}

	
	@Override
	public List<Circle> getCircleList(Integer unitId) throws LeagalUserException {
		// TODO Auto-generated method stub
		String sql = SELECT_CIRCLE;
		try {

			List<Circle> circleList = jdbcTemplate.query(sql,new Object[] { unitId },
					new RowMapper<Circle>() {

						public Circle mapRow(ResultSet rs, int rowNum)
								throws SQLException {

							Circle circle = new Circle();
							circle.setCircleId(rs.getInt(1));
							circle.setCircleName(rs.getString(2));
							return circle;
						}

					});
			jdbcTemplate.getDataSource().getConnection().close();
			return circleList;
		} catch (Exception exc) {
			log.error(exc.getMessage());
			return null;
		}
	}

	@Override
	public List<Division> getDivisionList(Integer circleId) throws LeagalUserException {
		// TODO Auto-generated method stub
		String sql = SELECT_DIVISION;
		try {

			List<Division> divisionList = jdbcTemplate.query(sql,new Object[] { circleId },
					new RowMapper<Division>() {

						public Division mapRow(ResultSet rs, int rowNum)
								throws SQLException {

							Division division = new Division();
							division.setDivisionId(rs.getInt(1));
							division.setDivisionName(rs.getString(2));
							return division;
						}

					});
			jdbcTemplate.getDataSource().getConnection().close();
			return divisionList;
		} catch (Exception exc) {
			log.error(exc.getMessage());
			return null;
		}
	}

	@Override
	public List<Subdivision> getSubDivisionList(Integer divisionId) throws LeagalUserException {
		// TODO Auto-generated method stub
		String sql = SELECT_SUBDIVISION;
		try {

			List<Subdivision> subdivisionList = jdbcTemplate.query(sql,new Object[] { divisionId },
					new RowMapper<Subdivision>() {

						public Subdivision mapRow(ResultSet rs, int rowNum)
								throws SQLException {

							Subdivision subdivision = new Subdivision();
							subdivision.setSubdivisionId(rs.getInt(1));
							subdivision.setSubdivisionName(rs.getString(2));
							return subdivision;
						}

					});
			jdbcTemplate.getDataSource().getConnection().close();
			return subdivisionList;
		} catch (Exception exc) {
			log.error(exc.getMessage());
			return null;
		}
	}

	
	
	
	@Override
	public List<Project> getProjectList(Integer unitId) throws LeagalUserException {
		String sql = SELECT_PROJECTS;
		
	
		try {

			List<Project> projectList = jdbcTemplate.query(sql,new Object[] { unitId },
					new RowMapper<Project>() {

						public Project mapRow(ResultSet rs, int rowNum)
								throws SQLException {

							Project project = new Project();
							project.setProjectId(rs.getInt(1));
							project.setProjectName(rs.getString(2));
							return project;
						}

					});
			jdbcTemplate.getDataSource().getConnection().close();
			return projectList;
		} catch (Exception exc) {
			log.error(exc.getMessage());
			return null;
		}
	}
	
	@Override
	public List<Project> getProjectListadmin(Integer unitId) throws LeagalUserException {
		
		String sql=SELECT_PROJECTS_ADMIN;
		
		if (unitId==4 ){
	         sql = SELECT_PROJECTS_ADMIN;
		
		} else if (unitId!=4 || unitId!=9832){
		
		
		 sql=SELECT_PROJECTS_ADMIN_UNIT + "and pum.unit_id= "+ unitId  +"  order by project_name";
		
		}
	
		try {

			List<Project> projectList = jdbcTemplate.query(sql,new Object[] {  },
					new RowMapper<Project>() {

						public Project mapRow(ResultSet rs, int rowNum)
								throws SQLException {

							Project project = new Project();
							project.setProjectId(rs.getInt(1));
							project.setProjectName(rs.getString(2));
							project.setUnitId(rs.getInt(3));
							return project;
						}

					});
			jdbcTemplate.getDataSource().getConnection().close();
			return projectList;
		} catch (Exception exc) {
			log.error(exc.getMessage());
			return null;
		}
	}

	@Override
	public List<Packages> getPackageList(Integer projectId) throws LeagalUserException {
		String sql = SELECT_PACKAGES;
		try {

			List<Packages> packageList = jdbcTemplate.query(sql,new Object[] { projectId },
					new RowMapper<Packages>() {

						public Packages mapRow(ResultSet rs, int rowNum)
								throws SQLException {

							Packages packages = new Packages();
							packages.setPkgId(rs.getInt(1));
							packages.setPkgName(rs.getString(2));
							return packages;
						}

					});
			jdbcTemplate.getDataSource().getConnection().close();
			return packageList;
		} catch (Exception exc) {
			log.error(exc.getMessage());
			return null;
		}
	}

	
	
	
	
	/*@Override
	public List<Circle> getProjectCirclesforPCK(int unitId)
			throws LeagalUserException {

		String sql = "";
		if (unitId == 21) {
			sql = SELECT_CIRCLE_BY_UNIT
					+ " union  select DISTINCT C.CIRCLE_NAME, S.CIRCLE_ID from SUBPOSTS S LEFT JOIN CIRCLE_MST C ON C.CIRCLE_ID=S.CIRCLE_ID	WHERE S.CIRCLE_ID in (21122,21128) AND C.STATUS='ACTIVE' ";
		} else {
			sql = SELECT_CIRCLE_BY_UNIT;
		}

		try {
			List<Circle> circle = jdbcHrmsTemplate.query(sql,
					new Object[] { unitId }, new RowMapper<Circle>() {

						public Circle mapRow(ResultSet rs, int rowNum)
								throws SQLException {

							Circle cl = new Circle();
							cl.setCircleId(rs.getInt(2));
							cl.setCircleName(rs.getString(1));

							return cl;
						}

					});

			return circle;
		} catch (Exception exc) {
			log.error(exc.getMessage());
			return null;

		}
	}
*/
	
	
	
	@Override
	public List<Division> getDivisions(Integer circleId)
			throws LeagalUserException {
		try {
			List<Division> divisions = jdbcTemplate.query(GET_DIVISIONS,
					new Object[] { circleId }, new RowMapper<Division>() {
						public Division mapRow(ResultSet rs, int rowNum)
								throws SQLException {
							Division div = new Division();
							div.setDivisionId((rs.getInt(1)));
							div.setDivisionName((rs.getString(2)));
							div.setCircleId(rs.getInt(3));
							return div;
						}
					});
			jdbcTemplate.getDataSource().getConnection().close();
			return divisions;
		} catch (Exception exc) {
			log.error(exc.getMessage());
		}
		return null;
	}

	
	
	
	@Override
	public List<Subdivision> getSubDivisionList(int divisionId)  throws LeagalUserException {

		String sql = SELECT_SUBDIVISION;
				//GET_SUBDIVISIONS_ON_DIVISION;
		try {

			List<Subdivision> subdivisionList = jdbcTemplate.query(sql,
					new Object[] { divisionId }, new RowMapper<Subdivision>() {

						public Subdivision mapRow(ResultSet rs, int rowNum)
								throws SQLException {

							Subdivision subdivision = new Subdivision();
							subdivision.setSubdivisionId(rs.getInt(1));
							subdivision.setSubdivisionName(rs.getString(2));
							return subdivision;
						}

					});
			jdbcTemplate.getDataSource().getConnection().close();
			return subdivisionList;
		} catch (Exception exc) {
			log.error(exc.getMessage());
			return null;
		}
	}
	
	/*@Override
	public List<Subdivision> getSectionList(int subdivisionId)
			throws LeagalUserException {
		String sql = GET_SECTION_ON_SUBDIVISION;
		try {

			List<Subdivision> section = jdbcHrmsTemplate.query(sql,
					new Object[] { subdivisionId },
					new RowMapper<Subdivision>() {

						public Subdivision mapRow(ResultSet rs, int rowNum)
								throws SQLException {

							Subdivision sec = new Subdivision();
							sec.setSectionId(rs.getInt(1));
							sec.setSectionName(rs.getString(2));
							return sec;
						}
					});

			return section;
		} catch (Exception exc) {
			log.error(exc.getMessage());
			return null;
		}

	}*/

	@Override
	public List<District> getDistricts() throws LeagalUserException {
		try {
			List<District> districts = jdbcTemplate.query(GET_DISTRICTS,
					new RowMapper<District>() {
						public District mapRow(ResultSet rs, int rowNum)
								throws SQLException {
							District dist = new District();
							dist.setDistrictId((rs.getInt(1)));
							dist.setDistrictName((rs.getString(2)));
							return dist;
						}
					});
			jdbcTemplate.getDataSource().getConnection().close();
			return districts;
		} catch (Exception exc) {
			log.error(exc.getMessage());
			return null;
		}

	}

	@Override
	public List<Mandal> getMandals(final Integer distId)
			throws LeagalUserException {
		try {
			List<Mandal> mandals = jdbcTemplate.query(GET_MANDALS,
					new Object[] { distId }, new RowMapper<Mandal>() {
						public Mandal mapRow(ResultSet rs, int rowNum)
								throws SQLException {
							
							Mandal mandal = new Mandal();
							mandal.setMandalId((rs.getInt(1)));
							mandal.setMandalName((rs.getString(2)));
							mandal.setMandalCode(rs.getString(3));
							return mandal;
						}
					});
			jdbcTemplate.getDataSource().getConnection().close();
			return mandals;
		} catch (Exception exc) {
			log.error(exc.getMessage());
			return null;
		}

	}

	@Override
	public List<Village> getVillages(Integer dcode,Integer mcode)
			throws LeagalUserException {
		String sql=GET_VILLAGES;
		//System.out.println("I am in village"+sql);
		
		try {
			
			List<Village> villages = jdbcTemplate.query(sql,
					new Object[] {dcode, mcode }, new RowMapper<Village>() {
						public Village mapRow(ResultSet rs, int rowNum)
								throws SQLException {
							
							//System.out.println("first rs.getString(2)");
							
							Village vill = new Village();
							
						//	System.out.println(rs.getString(2)+"rs.getString(2)");
							
							vill.setVillageId((rs.getInt(1)));
							vill.setVillageName((rs.getString(2)));
							vill.setMandalId(rs.getInt(3));
							vill.setDcode(rs.getString(4));
							vill.setMcode(rs.getString(5));
							vill.setVillageCode(rs.getString(6));
							
							return vill;
						}
					});
			jdbcTemplate.getDataSource().getConnection().close();
			return villages;
		} catch (Exception exc) {
			log.error(exc.getMessage());
			return null;
		}

	}
    

	@Override
	public List<CaseType> getCaseTypeList(Integer courtId) throws LeagalUserException {
		String sql = SELECT_CASE_TYPES;
		try {

			List<CaseType> caseTypeList = jdbcTemplate.query(sql,new Object[] { courtId },
					new RowMapper<CaseType>() {

						public CaseType mapRow(ResultSet rs, int rowNum)
								throws SQLException {

							CaseType caseType = new CaseType();
							caseType.setCaseTypeId(rs.getInt(1));
							caseType.setCaseType(rs.getString(2));
							return caseType;
						}

					});
			jdbcTemplate.getDataSource().getConnection().close();
			return caseTypeList;
		} catch (Exception exc) {
			log.error(exc.getMessage());
			return null;
		}
	}
	
	@Override
	public List<CaseGenSub> getCaseGenSubList(Integer caseGenId) throws LeagalUserException {
		String sql = SELECT_CASES_GEN_SUB;
		try {

			List<CaseGenSub> CaseGenSubList = jdbcTemplate.query(sql,new Object[] { caseGenId },
					new RowMapper<CaseGenSub>() {

						public CaseGenSub mapRow(ResultSet rs, int rowNum)
								throws SQLException {

							CaseGenSub caseGenSub = new CaseGenSub();
							caseGenSub.setCaseGenSubId(rs.getInt(1));
							caseGenSub.setCaseGenSubName(rs.getString(2));
							return caseGenSub;
						}

					});
			jdbcTemplate.getDataSource().getConnection().close();
			return CaseGenSubList;
		} catch (Exception exc) {
			log.error(exc.getMessage());
			return null;
		}
	}
	
	@Override
	public List<Petitioner> getPetitionerList() throws LeagalUserException {
		String sql = SELECT_PETITIONERS;
		try {

			List<Petitioner> petitionerList = jdbcTemplate.query(sql,
					new RowMapper<Petitioner>() {

						public Petitioner mapRow(ResultSet rs, int rowNum)
								throws SQLException {

							Petitioner petitioner = new Petitioner();
							petitioner.setPetitionerId(rs.getInt(1));
							petitioner.setPetitionerName(rs.getString(2));
							return petitioner;
						}

					});
			jdbcTemplate.getDataSource().getConnection().close();
			return petitionerList;
		} catch (Exception exc) {
			log.error(exc.getMessage());
			return null;
		}
	}
	
	@Override
	public Petitioner getPetitionerbyId(Integer petId) throws LeagalUserException {
		String sql = SELECT_PETITIONER_BYID;
		try {

			Petitioner petitionerList = (Petitioner) jdbcTemplate.queryForObject(sql, new Object[] {
					petId },
					new RowMapper<Object>() {

						public Object mapRow(ResultSet rs, int rowNum)
								throws SQLException {

							Petitioner petitioner = new Petitioner();
							petitioner.setPetitionerId(rs.getInt(1));
							petitioner.setPetitionerName(rs.getString(2));
							return petitioner;
						}

					});
			jdbcTemplate.getDataSource().getConnection().close();
			return petitionerList;
		} catch (Exception exc) {
			log.error(exc.getMessage());
			return null;
		}
	}

	@Override
	public List<PetitionerAdvocate> getPetitionerAdvocateList() throws LeagalUserException {
		String sql = SELECT_PET_ADVOCATES;
		try {

			List<PetitionerAdvocate> petitionerAdvocateList = jdbcTemplate.query(sql,
					new RowMapper<PetitionerAdvocate>() {

						public PetitionerAdvocate mapRow(ResultSet rs, int rowNum)
								throws SQLException {

							PetitionerAdvocate petitionerAdvocate = new PetitionerAdvocate();
							petitionerAdvocate.setPetitionerAdvId(rs.getInt(1));
							petitionerAdvocate.setPetitionerAdvName(rs.getString(2));
							return petitionerAdvocate;
						}

					});
			jdbcTemplate.getDataSource().getConnection().close();
			return petitionerAdvocateList;
		} catch (Exception exc) {
			log.error(exc.getMessage());
			return null;
		}
	}
	
	@Override
	public PetitionerAdvocate getPetitionerAdvListbyId(Integer petadvId) throws LeagalUserException {
		String sql = SELECT_PET_ADVOCATE_BY_ID;
		try {

			PetitionerAdvocate petitionerAdvocateList = (PetitionerAdvocate) jdbcTemplate.queryForObject(sql, new Object[] {
					petadvId },
					new RowMapper<Object>() {

						public Object mapRow(ResultSet rs, int rowNum)
								throws SQLException {

							PetitionerAdvocate petitionerAdvocate = new PetitionerAdvocate();
							petitionerAdvocate.setPetitionerAdvId(rs.getInt(1));
							petitionerAdvocate.setPetitionerAdvName(rs.getString(2));
							return petitionerAdvocate;
						}

					});
			jdbcTemplate.getDataSource().getConnection().close();
			return petitionerAdvocateList;
		} catch (Exception exc) {
			log.error(exc.getMessage());
			return null;
		}
	}


	@Override
	public Respondent getRespondentListById(Integer resId) throws LeagalUserException {
		String sql = SELECT_RESPONDENTS_BY_ID;
		try {

			Respondent respondentList = (Respondent) jdbcTemplate.queryForObject(sql, new Object[] {
					resId },
					new RowMapper<Object>() {

						public Respondent mapRow(ResultSet rs, int rowNum)
								throws SQLException {

							Respondent respondent = new Respondent();
							respondent.setRespondentId(rs.getInt(1));
							respondent.setRespondentName(rs.getString(2));
							return respondent;
						}

					});
			jdbcTemplate.getDataSource().getConnection().close();
			return respondentList;
		} catch (Exception exc) {
			log.error(exc.getMessage());
			return null;
		}
	}
	
	
	@Override
	public List<Respondent> getRespondentList() throws LeagalUserException {
		String sql = SELECT_RESPONDENTS;
		try {

			List<Respondent> respondentList = jdbcTemplate.query(sql,
					new RowMapper<Respondent>() {

						public Respondent mapRow(ResultSet rs, int rowNum)
								throws SQLException {

							Respondent respondent = new Respondent();
							respondent.setRespondentId(rs.getInt(1));
							respondent.setRespondentName(rs.getString(2));
							return respondent;
						}

					});
			jdbcTemplate.getDataSource().getConnection().close();
			return respondentList;
		} catch (Exception exc) {
			log.error(exc.getMessage());
			return null;
		}
	}


	@Override
	public List<RespondentAdvocate> getRespondentAdvocateList() throws LeagalUserException {
		String sql = SELECT_RES_ADVOCATES;
		try {

			List<RespondentAdvocate> RespondentAdvocate = jdbcTemplate.query(sql,
					new RowMapper<RespondentAdvocate>() {

						public RespondentAdvocate mapRow(ResultSet rs, int rowNum)
								throws SQLException {

							RespondentAdvocate r = new RespondentAdvocate();
							r.setRespondentAdvId(rs.getInt(1));
							r.setRespondentAdvName(rs.getString(2));
							return r;
						}

					});
			jdbcTemplate.getDataSource().getConnection().close();
			return RespondentAdvocate;
		} catch (Exception exc) {
			log.error(exc.getMessage());
			return null;
		}
	}
	
	
	@Override
	public RespondentAdvocate getRespondentAdvocateListById(Integer resAdvId) throws LeagalUserException {
		String sql = SELECT_RES_ADVOCATES_BY_Id;
		try {

			RespondentAdvocate respondentAdvocateList = (RespondentAdvocate) jdbcTemplate.queryForObject(sql, new Object[] {
					resAdvId },
					new RowMapper<Object>() {

						public RespondentAdvocate mapRow(ResultSet rs, int rowNum)
								throws SQLException {

							RespondentAdvocate r = new RespondentAdvocate();
							r.setRespondentAdvId(rs.getInt(1));
							r.setRespondentAdvName(rs.getString(2));
							return r;
						}

					});
			jdbcTemplate.getDataSource().getConnection().close();
			return respondentAdvocateList;
		} catch (Exception exc) {
			log.error(exc.getMessage());
			return null;
		}
	}


	

	@Override
	public List<CaseStatus> getCaseStatusList() throws LeagalUserException {
		String sql = SELECT_CASE_STATUS;
		try {

			List<CaseStatus> caseStatusList = jdbcTemplate.query(sql,
					new RowMapper<CaseStatus>() {

						public CaseStatus mapRow(ResultSet rs, int rowNum)
								throws SQLException {

							CaseStatus caseStatus = new CaseStatus();
							caseStatus.setCaseStatusId(rs.getInt(1));
							caseStatus.setCaseStatus(rs.getString(2));
							return caseStatus;
						}

					});
			jdbcTemplate.getDataSource().getConnection().close();
			return caseStatusList;
		} catch (Exception exc) {
			log.error(exc.getMessage());
			return null;
		}
	}

	@Override
	public List<CaseStages> getCaseStagesList() throws LeagalUserException {
		String sql = SELECT_CASE_STAGES;
		try {

			List<CaseStages> caseStagesList = jdbcTemplate.query(sql,
					new RowMapper<CaseStages>() {

						public CaseStages mapRow(ResultSet rs, int rowNum)
								throws SQLException {

							CaseStages caseStages = new CaseStages();
							caseStages.setCaseStageId(rs.getInt(1));
							caseStages.setCaseStageName(rs.getString(2));
							return caseStages;
						}

					});
			jdbcTemplate.getDataSource().getConnection().close();
			return caseStagesList;
		} catch (Exception exc) {
			log.error(exc.getMessage());
			return null;
		}
	}

	
	@Override
	public List<CasesGeneral> getCaseGeneralList() throws LeagalUserException {
		String sql = SELECT_CASE_GEN;
		try {

			List<CasesGeneral> casesGeneralList = jdbcTemplate.query(sql,
					new RowMapper<CasesGeneral>() {

						public CasesGeneral mapRow(ResultSet rs, int rowNum)
								throws SQLException {

							CasesGeneral casesGen = new CasesGeneral();
							casesGen.setCaseGenId(rs.getInt(1));
							casesGen.setCaseGeneral(rs.getString(2));
							return casesGen;
						}

					});
			jdbcTemplate.getDataSource().getConnection().close();
			return casesGeneralList;
		} catch (Exception exc) {
			log.error(exc.getMessage());
			return null;
		}
	}





	@Override
	public Integer insertCases(Cases caseObject) throws LeagalUserException, SQLException, ParseException {
		// TODO Auto-generated method stub
		
		String sql = INSERT_CASES_MASTER;
		
		String sql1=SELECT_COUNT_CM;
		/*String sql1 = INSERT_CASES_PET;
		String sql2 = INSERT_CASES_PETADV;
		String sql3 = INSERT_CASES_RESADV;
		String sql4 = INSERT_CASES_RES;
		String sql5 = INSERT_CASES_RES;*/
		Integer caseId = 0;
		//DateFormat format = new SimpleDateFormat("dd-mm-yyyy", Locale.ENGLISH);
		Date date1=null;
		Date date2=null;
		Date date3=null;
		Date date4=null;
		Integer casecount=0;
		
		Boolean child=false;
		
		//DateUtil datenow= new DateUtil();
		
		if (caseObject!=null) {
			
			List<Map<String, Object>> 	ct=	jdbcTemplate.queryForList(sql1, new Object[] {
					 caseObject.getCaseWpNumber(),caseObject.getCaseYear() } );
			
			
			for (Map<String, Object> row : ct) {
				casecount = Integer.parseInt(row.get("count").toString());
			}
            final Integer casect=casecount;
			if(casect<1){
				
				
			if(caseObject.getFilingDate()!=null && caseObject.getFilingDate()!="" && !caseObject.getFilingDate().equals('0') ){
			
				//System.out.println("caseObject.getFilingDate()"+caseObject.getFilingDate());
				date1 = DateUtil.getSQLDate(caseObject.getFilingDate());
					
			}
			
			if(caseObject.getCounterDate()!=null && caseObject.getCounterDate()!="" && !caseObject.getCounterDate().equals("0")  ){
			 date2 =  DateUtil.getSQLDate(caseObject.getCounterDate());
					 
			}
			
			if(caseObject.getJudgementDate()!=null &&  caseObject.getJudgementDate()!="" && !caseObject.getJudgementDate().equals("0") ){
			date3 = DateUtil.getSQLDate(caseObject.getJudgementDate());
					
			}
			
			if(caseObject.getDraftdateconttoGP()!=null &&  caseObject.getDraftdateconttoGP()!="" && !caseObject.getDraftdateconttoGP().equals("0") ){
				date4 =DateUtil.getSQLDate(caseObject.getDraftdateconttoGP()); 
						
						
				}
				
			if(caseObject.getIsChildCase()==1){
				
				child=true;
			}else{
				child=false;
				
			}
			List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql,
					caseObject.getCaseWpNumber(),caseObject.getCaseYear(),caseObject.getCaseStatusId(),
					caseObject.getCaseTypeId(), caseObject.getCaseGenId(),caseObject.getRemarks(),caseObject.getOracleUser(),caseObject.getCourtId(),
					caseObject.getBriefPrayer(),date1,date2,date3,
					caseObject.getUnitId(),caseObject.getCircleId(),caseObject.getDivisionId(),caseObject.getSubdivisionId(),"admin",
					caseObject.getProjectId(),caseObject.getPackageId(),child,0,caseObject.getCaseGenSubId(),caseObject.getCaseStageId()
					, caseObject.getCourtdistrictId(),date4,caseObject.getPetOthers(),caseObject.getResOthers(),caseObject.getPostgresUser());

			for (Map<String, Object> row : rows) {
				caseId = Integer.parseInt(row.get("case_id").toString());
			}

			final Integer id = caseId;
			
		//	System.out.println("id"+id);

			
						

						
		}
		

		
		}
		jdbcTemplate.getDataSource().getConnection().close();
		return caseId;
	}

	@Override
	public Integer insertPet(final List<Integer> petId, final Integer caseId) throws LeagalUserException{
		
		Integer rows=0;
		
		String sql1 = INSERT_CASES_PET;
	
		int[] j = null;

		try {
			jdbcTemplate.getDataSource().getConnection().setAutoCommit(false);
		

		if (petId.size() > 0) {
			j = jdbcTemplate.batchUpdate(sql1,
					new BatchPreparedStatementSetter() {
						@Override
						public void setValues(PreparedStatement ps, int i)
								throws SQLException {

							Integer sd = petId.get(i);

							if (petId.get(i)>0) {
								ps.setInt(1, caseId);
								ps.setInt(2, sd);
								

							}
						}

						@Override
						public int getBatchSize() {
							return petId.size();
						}
					});
		}
		jdbcTemplate.getDataSource().getConnection().setAutoCommit(true);
           
		if (j.length > 0) {
			rows=j.length;
			
			//System.out.println("rows"+rows);
			return rows;
		}
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			jdbcTemplate.getDataSource().getConnection().close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rows;
	}

	
	@Override
	public Integer insertPetAdv(final List<Integer> petAdvId, final Integer caseId) throws LeagalUserException{
		
		Integer rows=0;
		
		String sql = INSERT_CASES_PETADV;
	
		int[] j = null;

		try {
			jdbcTemplate.getDataSource().getConnection().setAutoCommit(false);
		

		if (petAdvId.size() > 0) {
			j = jdbcTemplate.batchUpdate(sql,
					new BatchPreparedStatementSetter() {
						@Override
						public void setValues(PreparedStatement ps, int i)
								throws SQLException {

							Integer sd = petAdvId.get(i);

							if (petAdvId.get(i)>0) {
								ps.setInt(1, caseId);
								ps.setInt(2, sd);
								

							}
						}

						@Override
						public int getBatchSize() {
							return petAdvId.size();
						}
					});
		}
		jdbcTemplate.getDataSource().getConnection().setAutoCommit(true);
           
		if (j.length > 0) {
			rows=j.length;
			
			//System.out.println("rows"+rows);
			return rows;
		}
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			jdbcTemplate.getDataSource().getConnection().close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rows;
	}

	
	@Override
	public Integer insertRes(final List<Integer> resId, final Integer caseId) throws LeagalUserException{
		
		Integer rows=0;
		
		
		String sql1 = INSERT_CASES_RES;
	
		int[] j = null;

		try {
			jdbcTemplate.getDataSource().getConnection().setAutoCommit(false);
		

		if (resId.size() > 0) {
			j = jdbcTemplate.batchUpdate(sql1,
					new BatchPreparedStatementSetter() {
						@Override
						public void setValues(PreparedStatement ps, int i)
								throws SQLException {

							Integer sd = resId.get(i);

							if (resId.get(i)>0) {
								ps.setInt(1, caseId);
								ps.setInt(2, sd);
								

							}
						}

						@Override
						public int getBatchSize() {
							return resId.size();
						}
					});
		}
		jdbcTemplate.getDataSource().getConnection().setAutoCommit(true);
           
		if (j.length > 0) {
			rows=j.length;
			
			//System.out.println("rows"+rows);
			return rows;
		}
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			jdbcTemplate.getDataSource().getConnection().close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rows;
	}

	
	
	@Override
	public Integer insertResAdv(final List<Integer> resAdvId, final Integer caseId) throws LeagalUserException{
		
		Integer rows=0;
		
		String sql1 = INSERT_CASES_RESADV;
	
		int[] j = null;

		try {
			jdbcTemplate.getDataSource().getConnection().setAutoCommit(false);
		

		if (resAdvId.size() > 0) {
			j = jdbcTemplate.batchUpdate(sql1,
					new BatchPreparedStatementSetter() {
						@Override
						public void setValues(PreparedStatement ps, int i)
								throws SQLException {

							Integer sd = resAdvId.get(i);

							if (resAdvId.get(i)>0) {
								ps.setInt(1, caseId);
								ps.setInt(2, sd);
								

							}
						}

						@Override
						public int getBatchSize() {
							return resAdvId.size();
						}
					});
		}
		jdbcTemplate.getDataSource().getConnection().setAutoCommit(true);
           
		if (j.length > 0) {
			rows=j.length;
			
			//System.out.println("rows"+rows);
			return rows;
		}
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			jdbcTemplate.getDataSource().getConnection().close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rows;
	}

	@Override
	public Integer insertCaseContact(final List<ContactPerson> contactList,final Integer caseId) throws LeagalUserException {
		// TODO Auto-generated method stub
		
		String sql = INSERT_CON_PER;
		

		Integer rows=0;
		
	
	
		int[] j = null;

		try {
			jdbcTemplate.getDataSource().getConnection().setAutoCommit(false);
		

		if (contactList.size() > 0 && caseId>0 ) {
			
			
			
			j = jdbcTemplate.batchUpdate(sql,
					new BatchPreparedStatementSetter() {
						@Override
						public void setValues(PreparedStatement ps, int i)
								throws SQLException {

							ContactPerson cp =  contactList.get(i);

							if (contactList.size()>0) {
								ps.setInt(1, caseId);
								ps.setString(2, cp.getContactPname());
								ps.setString(3, cp.getContactAddress());
								ps.setString(4, cp.getContactPhone1());
								ps.setString(5, cp.getContactPhone2());
								

							}
						}

						@Override
						public int getBatchSize() {
							return contactList.size();
						}
					});
		}
		jdbcTemplate.getDataSource().getConnection().setAutoCommit(true);
           
		if (j.length > 0) {
			rows=j.length;
			
			//System.out.println("rows"+rows);
			return rows;
		}
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			jdbcTemplate.getDataSource().getConnection().close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rows;
	}
	
	
	@Override
	public Integer insertpetitionermst(Petitioner pet) throws LeagalUserException {
		// TODO Auto-generated method stub
		
		String sql = INSERT_PET_MST;
		
	Integer petitioner_id=0;
		if (pet!=null) {
			
				
			List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql,new Object[] {
					 pet.getPetitionerName(),pet.getPetitionerAddress(),pet.getDistrictId(),pet.getMandalId(),pet.getVillageId() });
					

			
			for (Map<String, Object> row : rows) {
				petitioner_id = Integer.parseInt(row.get("petitioner_id").toString());
			}

			
		
			
			//System.out.println("rowscoming here"+rows);

			
						

						
		}
		
		try {
			jdbcTemplate.getDataSource().getConnection().close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return petitioner_id;
	}
	
	@Override
	public Integer insertpetitionerAdvmst(PetitionerAdvocate petAdv) throws LeagalUserException {
		// TODO Auto-generated method stub
		
		String sql = INSERT_PETADV_MST;
		
	Integer petadvid=0;
		if (petAdv!=null) {
			
				
			List<Map<String, Object>>  rows = jdbcTemplate.queryForList(sql,new Object[] {
					 petAdv.getPetitionerAdvName(),petAdv.getPetitionerAdvAddress() });
					
			
			for (Map<String, Object> row : rows) {
				petadvid = Integer.parseInt(row.get("p_advocate_id").toString());
			}


			

		
			
			//System.out.println("rowscomingAdv here"+rows);

			
						

						
		}
		try {
			jdbcTemplate.getDataSource().getConnection().close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return petadvid;
	}
	
	@Override
	public Integer insertrespondentmst(Respondent res) throws LeagalUserException {
		// TODO Auto-generated method stub
		
		String sql = INSERT_RES_MST;
		
	Integer resId=0;
		if (res!=null) {
			
				
			List<Map<String, Object>>  rows = jdbcTemplate.queryForList(sql,new Object[] {
					 res.getRespondentName(),res.getRespondentAddress(),res.getUnitId(),res.getCircleId(),res.getDivisionId(),res.getSubdivisionId(),res.getDistrictId(),res.getMandalId(),res.getVillageId() });
					

			for (Map<String, Object> row : rows) {
				resId = Integer.parseInt(row.get("respondent_id").toString());
			}


		
			
			//System.out.println("rowscoming here"+rows);

			
						

						
		}
		
		try {
			jdbcTemplate.getDataSource().getConnection().close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resId;
	}
	
	@Override
	public Integer inrespondentAdvmst(RespondentAdvocate resAdv) throws LeagalUserException {
		// TODO Auto-generated method stub
		
		String sql = INSERT_RESADV_MST;
		
	Integer resadvId=0;
		if (resAdv!=null) {
			
				
			List<Map<String, Object>>  rows = jdbcTemplate.queryForList(sql,new Object[] {
					 resAdv.getRespondentAdvName(),resAdv.getRespondentAddress(),resAdv.getResAdvCode() });
					

			

			for (Map<String, Object> row : rows) {
				resadvId = Integer.parseInt(row.get("r_advocate_id").toString());
			}

		
			
			//System.out.println("rowscomingAdv here"+rows);

			
						

						
		}
		
		try {
			jdbcTemplate.getDataSource().getConnection().close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resadvId;
	}
	
	
	@Override
	public Integer insertPackmst(Packages pack) throws LeagalUserException {
		// TODO Auto-generated method stub
		
		String sql = INSERT_PACK_MST;
		
	Integer rows=0;
		if (pack!=null) {
			
				
			 rows = jdbcTemplate.update(sql,new Object[] {
					 pack.getPkgName(),pack.getProjectId(),pack.getCircleId(),pack.getUserId(),pack.getUnitId(),pack.getDivisionId(),pack.getUserName() });
					

			

		
			
			//System.out.println("rowscomingAdv here"+rows);

			
						

						
		}
		
		try {
			jdbcTemplate.getDataSource().getConnection().close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rows;
	}
	
	@Override
	public List<Cases> getCasesList() throws LeagalUserException {
		String sql = GET_CASES;
		try {

			List<Cases> caseList = jdbcTemplate.query(sql,
					new RowMapper<Cases>() {

						public Cases mapRow(ResultSet rs, int rowNum)
								throws SQLException {

							Cases caseobj = new Cases();
							caseobj.setCaseId(rs.getInt(1));;
							caseobj.setCaseWpNumber(rs.getString(2));
							return caseobj;
						}

					});
			jdbcTemplate.getDataSource().getConnection().close();
			return caseList;
		} catch (Exception exc) {
			log.error(exc.getMessage());
			return null;
		}
	}
	
	@Override
	public List<Cases> getcasesbycaseid(Integer caseId) throws LeagalUserException {
		
		
		String sql = SELECT_CASE_EDIT;
		//final String sql2=UNIT_NAME;
		//final String sql3=CIRCLE_NAME;
		//final String sql4=DIVISION_NAME;
		
		// final SimpleDateFormat format1 =  new SimpleDateFormat("yy-mm-dd");
		// final SimpleDateFormat format2 = new SimpleDateFormat("dd/mm/yy");
		 
         
		try {
			
			final List<Unit> unitList=getUnitList();
			final List<Circle> circleList=getCircleList();
			final List<Division> divisionList=getDivisionList();

		//System.out.println("caseId"+caseId);

			List<Cases> CasesList = jdbcTemplate.query(sql, new Object[] {
					caseId }, new RowMapper<Cases>() {

				public Cases mapRow(ResultSet rs, int rowNum)
						throws SQLException {

					Cases cases = new Cases();
					
					cases.setCaseId(rs.getInt(1));
					cases.setCaseWpNumber(rs.getString(2));
					cases.setCaseYear(rs.getInt(3));
					cases.setPetitioner(rs.getString(4));
					cases.setPetetionerAdvocate(rs.getString(5));
					cases.setRespondent(rs.getString(6));
					cases.setRespondentAdvocate(rs.getString(7));
					cases.setCaseStatus(rs.getString(8));
					cases.setCaseStageName(rs.getString(9));
					cases.setRemarks(rs.getString(10));
					cases.setCourtName(rs.getString(11));
					cases.setBriefPrayer(rs.getString(12));
					
					
					
					
						cases.setFilingDate(rs.getString(13));
					
					
					cases.setCounterDate(rs.getString(14));
					cases.setJudgementDate(rs.getString(15));
					
					cases.setUnitId(rs.getInt(16));
					
					cases.setCircleId(rs.getInt(17));
					
					cases.setDivisionId(rs.getInt(18));
					cases.setProjectName(rs.getString(19));
					cases.setPackageName(rs.getString(20));
					cases.setCaseGenSubName(rs.getString(21));
					//System.out.println("rs.getString(22)"+rs.getString(22));
					cases.setDraftdateconttoGP(rs.getString(22));
					cases.setCaseStatusId(rs.getInt(23));
					cases.setCaseTypeId(rs.getInt(24));
					cases.setCaseGenId(rs.getInt(25));
					cases.setCourtId(rs.getInt(26));
					cases.setSubdivisionId(rs.getInt(27));
					cases.setProjectId(rs.getInt(28));
					cases.setPackageId(rs.getInt(29));
					if(rs.getBoolean(30)){
					cases.setIsChildCase(1);
					}else{
						
						cases.setIsChildCase(2);
					}
					cases.setCaseGenSubId(rs.getInt(31));
					cases.setCaseStageId(rs.getInt(32));
					cases.setCourtdistrictId(rs.getInt(33));
					cases.setPetOthers(rs.getInt(34));
					cases.setResOthers(rs.getInt(35));
					cases.setPetitionerIdArray(rs.getString(36));
					cases.setRespondentIdArray(rs.getString(37));
					cases.setRespondentAdvIdArray(rs.getString(38));
					cases.setPetetionerAdvIdArray(rs.getString(39));
					cases.setCaseType(rs.getString(40));
					cases.setCaseNum(rs.getString(41));
					cases.setCaseGeneral(rs.getString(42));
					cases.setOrderDate(rs.getString(43));
					cases.setHearingDate(rs.getString(44));
					cases.setFileName(rs.getString(45));
					cases.setCaseTypeOrderId(rs.getInt(46));
					
					cases.setUnitId(rs.getInt(16));
					cases.setCircleId(rs.getInt(17));
					cases.setDivisionId(rs.getInt(18));
if(rs.getInt(16)>0){
						
						if(unitList.size()>0){	
							
							final int len=unitList.size();
						
						for(int i=0 ; i<len ; i++){
						
							if(unitList.get(i).getUnitId()==rs.getInt(16))
								cases.setUnitName(unitList.get(i).getUnitName());
						}	
						
							}
					}
					
					if(rs.getInt(17)>0){
						
                       if(circleList.size()>0){	
							
							final int len=circleList.size();
						
						for(int i=0 ; i<len ; i++){
						
							if(circleList.get(i).getUnitId()==rs.getInt(16))
								if(circleList.get(i).getCircleId()==rs.getInt(17)){
								cases.setCircleName(circleList.get(i).getCircleName());
								}
						}	
						
							}
						
					
					}
					
					
					if(rs.getInt(18)>0){
						
	                       if(divisionList.size()>0){	
								
								final int len=divisionList.size();
							
							for(int i=0 ; i<len ; i++){
							
								if(divisionList.get(i).getCircleId()==rs.getInt(17))
									if(divisionList.get(i).getDivisionId()==rs.getInt(18)){
									cases.setCircleName(divisionList.get(i).getDivisionName());
									}
							}	
							
								}
							
						
						}
					
					
					return cases;

				}

			});
             // System.out.println("CasesgenCourtList"+CasesList);
			
			jdbcTemplate.getDataSource().getConnection().close();
			return CasesList;
		} catch (Exception exc) {
			log.error(exc.getMessage());
			return null;
		}

		
	}
	
	@Override
	public Integer insertcasegenmst(CasesGeneral caseGen) throws LeagalUserException {
		// TODO Auto-generated method stub
		
		String sql = INSERT_CASE_GEN;
		
	Integer rows=0;
		if (caseGen!=null) {
			
				
			 rows = jdbcTemplate.update(sql,new Object[] {
					 caseGen.getCaseGeneral() });
					

			

		
			
			//System.out.println("rowscoming here"+rows);

			
						

						
		}
		
		try {
			jdbcTemplate.getDataSource().getConnection().close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rows;
	}
	
	@Override
	public Integer insertcasegensubmst(CaseGenSub caseGenSub) throws LeagalUserException {
		// TODO Auto-generated method stub
		
		String sql = INSERT_CASE_GEN_SUB_MST;
		
	Integer rows=0;
		if (caseGenSub!=null) {
			
				
			 rows = jdbcTemplate.update(sql,new Object[] {
					 caseGenSub.getCaseGenSubName(),caseGenSub.getCaseGenId() });
					

			

		
			
			//System.out.println("rowscoming here"+rows);

			
						

						
		}
		
		try {
			jdbcTemplate.getDataSource().getConnection().close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rows;
	}
	
	@Override
	public Integer insertcasetypemst(CaseType caseType) throws LeagalUserException {
		// TODO Auto-generated method stub
		
		String sql = INSERT_CASE_TYPE_MST;
		
	Integer rows=0;
		if (caseType!=null) {
			
				
			 rows = jdbcTemplate.update(sql,new Object[] {
					 caseType.getCaseType(),caseType.getCourtId() });
					

			

		
			
			//System.out.println("rowscoming here"+rows);

			
						

						
		}
		
		try {
			jdbcTemplate.getDataSource().getConnection().close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rows;
	}
	
	
	@Override
	public Integer deleteAllforcase(final Integer caseId) throws LeagalUserException{
		
		Integer rows=0;
		Integer rows1=0;
		Integer rows2=0;
		Integer rows3=0;
		Integer rows4=0;
		Integer rows5=0;
		
		String sql = DELETE_CM;
		String sql1 = DELETE_CCP;
		String sql2 = DELETE_CPA;
		String sql3 = DELETE_CP;
		String sql4 = DELETE_CRA;
		String sql5 = DELETE_CR;
	
		int[] j = null;

		try {
			jdbcTemplate.getDataSource().getConnection().setAutoCommit(false);
		

		if (caseId!=null) {
			if(caseId>0){
			 rows = jdbcTemplate.update(sql,new Object[] {
					 caseId });
			 if(rows>0){
			 rows1 = jdbcTemplate.update(sql1,new Object[] {
					 caseId });
			 rows2 = jdbcTemplate.update(sql2,new Object[] {
					 caseId});
			 rows3 = jdbcTemplate.update(sql3,new Object[] {
					 caseId });
			 rows4 = jdbcTemplate.update(sql4,new Object[] {
					 caseId });
			 rows5 = jdbcTemplate.update(sql5,new Object[] {
					 caseId });
			 }
			}
		}
		jdbcTemplate.getDataSource().getConnection().setAutoCommit(true);
           
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			jdbcTemplate.getDataSource().getConnection().close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rows;
	}
	
	
	@Override
	public Integer editAllforcase(final Cases caseObject) throws LeagalUserException, ParseException{
		
		Integer rows=0;
		Integer rows1=0;
		Integer rows2=0;
		
		Integer rows3=0;
		Integer rows4=0;
		
		
		String sql = EDIT_CM;
		String sql1 = INSERT_CASE_DATE_HEAR;
		String sql2 = INSERT_CASE_TYPE_OS;
		String sql3 = EDIT_CTOS;
		String sql4 = EDIT_CDH;
		String sql5 = SELECT_CDH_STATUS;
		String sql6 = SELECT_CTOS_STATUS;
		
		Integer cdhcount=0;
		Integer ctoscount=0;
		
		
		
		
		Date date1=null;
		Date date2=null;
		Date date3=null;
		Date date4=null;
		Date date5=null;
		Date date6=null;
		
		Boolean childcase=false;
		
		if(caseObject.getFilingDate()!=null && caseObject.getFilingDate()!=" " && !caseObject.getFilingDate().equals('0') ){
			//System.out.println("caseObject.getFilingDate()"+caseObject.getFilingDate());
			
			date1 = DateUtil.getSQLDate(caseObject.getFilingDate());
					
			}
			
			if(caseObject.getCounterDate()!=null && caseObject.getCounterDate()!="" && !caseObject.getCounterDate().equals("0") && !caseObject.getCounterDate().equals("")   ){
			 date2 =  DateUtil.getSQLDate(caseObject.getCounterDate());
					 
			}
			
			if(caseObject.getJudgementDate()!=null &&  caseObject.getJudgementDate()!=" " && !caseObject.getJudgementDate().equals("0") ){
			date3 = DateUtil.getSQLDate(caseObject.getJudgementDate());
					
			}
			
			if(caseObject.getDraftdateconttoGP()!=null &&  caseObject.getDraftdateconttoGP()!=" " && !caseObject.getDraftdateconttoGP().equals("0") ){
				date4 =DateUtil.getSQLDate(caseObject.getDraftdateconttoGP()); 
						
						
				}
			
			if(caseObject.getHearingDate()!=null &&  caseObject.getHearingDate()!=" " && !caseObject.getHearingDate().equals("0") ){
				date5 =DateUtil.getSQLDate(caseObject.getHearingDate()); 
						
						
				}
			
			if(caseObject.getOrderDate()!=null &&  caseObject.getOrderDate()!="" && !caseObject.getOrderDate().equals("0") ){
				date6 =DateUtil.getSQLDate(caseObject.getOrderDate()); 
						
						
				}
		
	
		
		if (caseObject!=null) {
			if(caseObject.getCaseId()>0){
				if(caseObject.getIsChildCase()==1){
					childcase=true;
					
				}
			 rows = jdbcTemplate.update(sql,new Object[] {
					 caseObject.getCaseWpNumber(),caseObject.getCaseYear(),caseObject.getPetOthers(),caseObject.getResOthers(),date1,date4,date3,date2,caseObject.getCaseStageId(),caseObject.getCaseStatusId(),caseObject.getBriefPrayer(),caseObject.getRemarks(),childcase,caseObject.getParentcaseId(),date6,caseObject.getCaseTypeOrderId(), caseObject.getFileName(),caseObject.getFilePath(),date5,caseObject.getOracleUser(),  caseObject.getCaseId()});

			 if(rows>0){
				 
				
						
						List<Map<String, Object>> 	countcdh=	jdbcTemplate.queryForList(sql5, new Object[] {
								 caseObject.getCaseId() } );
						
						
						for (Map<String, Object> row : countcdh) {
							cdhcount = Integer.parseInt(row.get("cdh").toString());
						}
			            final Integer casecdh=cdhcount;
				 if(casecdh>0){
					 
					 rows1 = jdbcTemplate.update(sql4,new Object[] {
							 caseObject.getOracleUser(),caseObject.getCaseId() });
					 
				 }if(date5!=null){
				 rows2 = jdbcTemplate.update(sql1,new Object[] {
						 caseObject.getCaseId(),date5, caseObject.getOracleUser()});
				 }
				 
				 List<Map<String, Object>> 	countctos=	jdbcTemplate.queryForList(sql6, new Object[] {
						 caseObject.getCaseId() } );
				
				
				for (Map<String, Object> row : countctos) {
					ctoscount = Integer.parseInt(row.get("ctos").toString());
				}
	            final Integer casectos=ctoscount;
	            if(casectos>0){
	            	
	            	 rows3 = jdbcTemplate.update(sql3,new Object[] {
							 caseObject.getOracleUser(), caseObject.getCaseId()});
	            }
	            if(caseObject.getCaseTypeOrderId()!=null){
	            if(caseObject.getCaseTypeOrderId()>0 && date6!=null ){
				 rows4 = jdbcTemplate.update(sql2,new Object[] {
						 caseObject.getCaseTypeOrderId(),caseObject.getCaseId(),caseObject.getOracleUser(),date6,caseObject.getFileName(),caseObject.getFilePath()});

				 
			 }
	            }
		}
		
		}
			
		}
		try {
			jdbcTemplate.getDataSource().getConnection().close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rows;
	}
	
	@Override
	public List<Circle> getCircleList() throws LeagalUserException {
		// TODO Auto-generated method stub
		String sql = GET_CIRCLE_LIST;
		try {

			List<Circle> circleList = jdbcTemplate.query(sql,
					new RowMapper<Circle>() {

						public Circle mapRow(ResultSet rs, int rowNum)
								throws SQLException {

							Circle circle = new Circle();
							circle.setCircleId(rs.getInt(1));
							circle.setCircleName(rs.getString(2));
							circle.setUnitId(rs.getInt(3));
							return circle;
						}

					});
			jdbcTemplate.getDataSource().getConnection().close();
			return circleList;
		} catch (Exception exc) {
			log.error(exc.getMessage());
			return null;
		}
	}

	@Override
	public List<Division> getDivisionList() throws LeagalUserException {
		// TODO Auto-generated method stub
		String sql = GET_DIVISION_LIST;
		try {

			List<Division> divisionList = jdbcTemplate.query(sql,
					new RowMapper<Division>() {

						public Division mapRow(ResultSet rs, int rowNum)
								throws SQLException {

							Division division = new Division();
							division.setDivisionId(rs.getInt(1));
							division.setDivisionName(rs.getString(2));
							division.setCircleId(rs.getInt(3));
							return division;
						}

					});
			jdbcTemplate.getDataSource().getConnection().close();
			return divisionList;
		} catch (Exception exc) {
			log.error(exc.getMessage());
			return null;
		}
	}
	
	
	
	@Override
	public List<CaseTypeOrder> getTypeOrderList() throws LeagalUserException {
		// TODO Auto-generated method stub
		String sql = SELECT_TYPE_ORDERS;
		try {

			List<CaseTypeOrder> caseTypeOrderList = jdbcTemplate.query(sql,
					new RowMapper<CaseTypeOrder>() {

						public CaseTypeOrder mapRow(ResultSet rs, int rowNum)
								throws SQLException {

							CaseTypeOrder caseTypeOrder = new CaseTypeOrder();
							caseTypeOrder.setCaseTypeOrderId(rs.getInt(1));
							caseTypeOrder.setCaseTypeOrder(rs.getString(2));
							return caseTypeOrder;
						}

					});
			jdbcTemplate.getDataSource().getConnection().close();
			return caseTypeOrderList;
		} catch (Exception exc) {
			log.error(exc.getMessage());
			return null;
		}
	}
	
	
	@Override
	public List<Petitioner> getPetitionerbyCountList() throws LeagalUserException {
		String sql = SELECT_PET_BY_CASECOUNT;
		try {

			List<Petitioner> petitionerList = jdbcTemplate.query(sql,
					new RowMapper<Petitioner>() {

						public Petitioner mapRow(ResultSet rs, int rowNum)
								throws SQLException {

							Petitioner petitioner = new Petitioner();
							petitioner.setPetitionerId(rs.getInt(1));
							petitioner.setPetitionerName(rs.getString(2));
							return petitioner;
						}

					});
			jdbcTemplate.getDataSource().getConnection().close();
			return petitionerList;
		} catch (Exception exc) {
			log.error(exc.getMessage());
			return null;
		}
	}

	@Override
	public List<PetitionerAdvocate> getPetitionerAdvocatebyCountList() throws LeagalUserException {
		String sql = SELECT_PETADV_BY_CASECOUNT;
		try {

			List<PetitionerAdvocate> petitionerAdvocateList = jdbcTemplate.query(sql,
					new RowMapper<PetitionerAdvocate>() {

						public PetitionerAdvocate mapRow(ResultSet rs, int rowNum)
								throws SQLException {

							PetitionerAdvocate petitionerAdvocate = new PetitionerAdvocate();
							petitionerAdvocate.setPetitionerAdvId(rs.getInt(1));
							petitionerAdvocate.setPetitionerAdvName(rs.getString(2));
							return petitionerAdvocate;
						}

					});
			jdbcTemplate.getDataSource().getConnection().close();
			return petitionerAdvocateList;
		} catch (Exception exc) {
			log.error(exc.getMessage());
			return null;
		}
	}
	
	
	@Override
	public Boolean changePassword(User user) throws LeagalUserException {
		String sql = CHANGE_PASSWORD;
		String sql1 = CHANGE_PASSWORD_ADMIN;
		
		String sql2=CHANGE_PASSWORD_EMP;

		int j = 0;
		try {
			//String passwords = null;
			//passwords=user.getPassword();
			//System.out.println("passwords"+passwords);
			// Integer id= user.getUserId();
		//	 String  originalPassword1 = String.valueOf(user.getPassword());
			// System.out.println(id+"----"+originalPassword1);
			// String generatedSecuredPasswordHash1 = BCrypt.hashpw(originalPassword1, BCrypt.gensalt(12));
		       // System.out.println(id+"----"+generatedSecuredPasswordHash1);

		if(user!=null){
			
			if(user.getNewPassword()!=null){
				
				if(user.getNewPassword().length()>0){
					
					 if(!user.getUserName().contains("cc_")|| !user.getUserName().contains("CAO")  ) {
		
			j = jdbcTemplate3.update(sql, new Object[] { user.getPassword(),user.getOldPassword(), user.getUserName() });
			
					 }
					 
					 if(user.getUserName().contains("cc_")|| user.getUserName().contains("CAO")  ) {
							
							j = jdbcTemplate3.update(sql1, new Object[] { user.getPassword(),user.getOldPassword(), user.getUserName() });
							
						
				}
					 
					 //System.out.println(user.getUserName());
					 
					 if(user.getUserName().contains("user") ) {
						 
						// System.out.println("coming here+"+user.getPassword()+user.getOldPassword()+user.getUserName()+"--"+sql2);
							
							j = jdbcTemplate3.update(sql2, new Object[] { user.getPassword(),user.getOldPassword(), user.getUserName() });
							
									 }
					 
				}
			}
		}

			if (j > 0) {
				return true;
			} else {
				return false;
			}

		} catch (DataAccessException dae) {
			log.error(dae.getMessage());
			return false;

		} catch (Exception ex) {

			log.error(ex.getMessage());
			return false;

		}

	}
	
	@Override
	public Boolean insertfailedattempt(String userName,String ipAddress) throws LeagalUserException {
		// TODO Auto-generated method stub
		
		String sql = INSERT_FAILED_ACCESS_LOGS;
		
	Integer j=0;
		if (userName!=null) {
			 j = jdbcTemplate.update(sql,new Object[] { userName,ipAddress ,userName});
			//System.out.println("rowscoming here"+rows);
		}
		try {
			jdbcTemplate.getDataSource().getConnection().close();
		} catch (SQLException e) {
			log.error("Inside legaladminDAOImpl, insertfailedattempt method, error due to " + e.getMessage());
			e.printStackTrace();
		}
		if (j > 0) {
			return true;
		} else {
			return false;
		}
		
	}

	@Override
	public Boolean insertLoginAttempt(String userName,String ipAddress) throws LeagalUserException {
		// TODO Auto-generated method stub
		
		String sql = INSERT_ACCESS_LOG_ON_LOGIN;
		String updateSql=UPDATE_USER_ACCESS_ON_LOGOUT;
				
				//UPDATE_USER_ACCESS_ON_SESSIONTIMEOUT;
		
	Integer j=0,k;
		if (userName!=null) {
			
			String remarks="Logged out as session is expired/tried for another login attempt";
			
			k = jdbcTemplate.update(updateSql,new Object[] {remarks, userName });
			 j = jdbcTemplate.update(sql,new Object[] { userName ,ipAddress});
			//System.out.println("rowscoming here"+rows);
		}
		try {
			jdbcTemplate.getDataSource().getConnection().close();
		} catch (SQLException e) {
			log.error("Inside legaladminDAOImpl, insertLoginAttempt method, error due to " + e.getMessage());
			e.printStackTrace();
		}
		if (j > 0) {
			return true;
		} else {
			return false;
		}
		
	}
	
	@Override
	public Boolean getUserConcurrentLogin(String username) throws LeagalUserException {
				
				String sql = SELECT_USER_CONCURRENT_LOGIN;
				try {

					Integer isUpdate = jdbcTemplate.queryForObject(sql, new Object[] { username }, Integer.class);
				    //System.out.println("DAOIMPL"+isUpdate);

						if(isUpdate!=0) {
							return true;
						}else {
							return false;
						} 
				}
				catch(Exception e) {
					e.printStackTrace();
					log.error("Inside legaladminDAOImpl, getUserConcurrentLogin method, error due to " + e.getMessage());
						return false;
					}		
				
				}	
	
	@Override
	public Boolean updateUserLogout(User user) throws LeagalUserException {
		// TODO Auto-generated method stub
		
		//System.out.println(userName+"updateUserLogout");
		
		String sql = UPDATE_USER_ACCESS_ON_LOGOUT;
		
	Integer j=0;
	
	     String userName=user.getUserName();
	     
	     String remarks=user.getRemarks();
		if (userName!=null) {
			 j = jdbcTemplate.update(sql,new Object[] { remarks,userName });
			//System.out.println("rowscoming here"+rows);
		}
		try {
			jdbcTemplate.getDataSource().getConnection().close();
		} catch (SQLException e) {
			log.error("Inside legaladminDAOImpl, updateUserLogout method, error due to " + e.getMessage());
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (j > 0) {
			return true;
		} else {
			return false;
		}
		
	}
	@Override
	public Integer getFailedLoginCount(String uname) throws LeagalUserException {
		int i=0;
		String sql = GET_LOGIN_ATTEMPT_COUNT;
		if(uname!=null) {
			List<Map<String, Object>> r=jdbcTemplate.queryForList(sql,new Object[] {uname });
			for (Map<String, Object> row : r) {
				i = Integer.parseInt(row.get("attemptno").toString());
				//System.out.println(" attemptNo"+i);
			}
		//System.out.println(" attemptNo"+i);
		}
		try {
			jdbcTemplate.getDataSource().getConnection().close();
		}
		catch (Exception exc) {
			log.error("Inside legaladminDAOImpl, getFailedLoginCount, error due to " + exc.getMessage());
			return null;
		}
		return i;
	}
	
	@Override
	public List<User> logDetails(String username)	throws LeagalUserException {

		String sql = GET_LOGOUTDETAILS;
		try {


             //   System.out.println("SELECT_USER_EMP_DATA"+"--"+SELECT_USER_EMP_DATA);
			List<User> User = jdbcTemplate.query(sql, new Object[] {
					username}, new RowMapper<User>() {

				public User mapRow(ResultSet rs, int rowNum)
						throws SQLException {

					User users = new User();
					
					users.setLogouttime(rs.getDate(1));				
					
					
					return users;

				}

			});
			
			jdbcTemplate.getDataSource().getConnection().close();

			return User;
		} catch (Exception exc) {
			log.error("Inside legaladminDAOImpl, logoutdetails method, error due to " + exc.getMessage());
		//	log.error(exc.getMessage());
			return null;
		}

	}


}
