package in.ts.icad.leagal.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import in.ts.icad.leagal.dao.TaskAdminDAO;
import in.ts.icad.leagal.exception.LeagalUserException;
import in.ts.icad.leagal.exception.TaskUserException;
import in.ts.icad.leagal.model.Cases;
import in.ts.icad.leagal.model.Circle;
import in.ts.icad.leagal.model.Designation;
import in.ts.icad.leagal.model.Division;
import in.ts.icad.leagal.model.Employee;
import in.ts.icad.leagal.model.Packages;
import in.ts.icad.leagal.model.Project;
import in.ts.icad.leagal.model.Subdivision;
import in.ts.icad.leagal.model.Task;
import in.ts.icad.leagal.model.TaskFiles;
import in.ts.icad.leagal.model.TaskPriority;
import in.ts.icad.leagal.model.TaskResponsibleEmp;
import in.ts.icad.leagal.model.TaskStatus;
import in.ts.icad.leagal.model.TaskType;
import in.ts.icad.leagal.model.Unit;
import in.ts.icad.leagal.model.User;
import in.ts.icad.leagal.util.DateUtil;

@Repository
public class TaskAdminDAOImpl implements TaskAdminDAO {
	

	private Logger log = LoggerFactory.getLogger(this.getClass());
	private final boolean IS_DEBUG_ENABLED = log.isDebugEnabled();

	private JdbcTemplate jdbcTemplate;
	
	
	@Resource(name = "dataSource3")
	public void setDataSource(DataSource dataSource3) {
		this.jdbcTemplate = new JdbcTemplate(dataSource3);
	}

	/*private JdbcTemplate jdbcHrmsTemplate;

	@Resource(name = "dataSource1")
	public void setDataSource1(DataSource dataSource) {
		this.jdbcHrmsTemplate = new JdbcTemplate(dataSource);
	}*/
	
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
	
	@Value("${UNIT_NAME}")
	private String UNIT_NAME;
	
	@Value("${CIRCLE_NAME}")
	private String CIRCLE_NAME;
	
	@Value("${DIVISION_NAME}")
	private String DIVISION_NAME;
	
	@Value("${SUBDIVISION_NAME}")
	private String SUBDIVISION_NAME;
	
	@Value("${GET_USER_DETAILS}")
	private String GET_USER_DETAILS;
	
	@Value("${GET_POST_USER}")
	private String GET_POST_USER;
	
	@Value("${SELECT_UNIT}")
	private String SELECT_UNIT;
	
	@Value("${GET_CIRCLE_LIST}")
	private String GET_CIRCLE_LIST;
	@Value("${GET_DIVISION_LIST}")
	private String GET_DIVISION_LIST;
	
	@Value("${SELECT_TASK_TYPE}")
	private String SELECT_TASK_TYPE;
	
	@Value("${SELECT_TASK_PRIORITY}")
	private String SELECT_TASK_PRIORITY;
	
	@Value("${SELECT_DESIGNATION}")
	private String SELECT_DESIGNATION;
	
	@Value("${SELECT_TASK_STATUS}")
	private String SELECT_TASK_STATUS;
	
	@Value("${SELECT_RESPONSIBLE_EMP}")
	private String SELECT_RESPONSIBLE_EMP;
	
	@Value("${INSERT_TASK_DATA}")
	private String INSERT_TASK_DATA;
	
	@Value("${INSERT_FILE_DATA}")
	private String INSERT_FILE_DATA;
	
	@Value("${SELECT_UNITPOST}")
	private String SELECT_UNITPOST;
	
	@Value("${SELECT_CIRCLEPOST}")
	private String SELECT_CIRCLEPOST;
	
	@Value("${SELECT_DIVISIONPOST}")
	private String SELECT_DIVISIONPOST;
	
	@Value("${SELECT_SUBDIVISIONPOST}")
	private String SELECT_SUBDIVISIONPOST;
	
	
	@Value("${SELECT_SE_LIST}")
	private String SELECT_SE_LIST;
	
	@Value("${SELECT_EE_LIST}")
	private String SELECT_EE_LIST;
	
	@Value("${SELECT_DEE_LIST}")
	private String SELECT_DEE_LIST;
	
	@Value("${SELECT_AEE_AE_LIST}")
	private String SELECT_AEE_AE_LIST;
	
	@Value("${SELECT_TASK_USERPOST}")
	private String SELECT_TASK_USERPOST;
	
	@Value("${SELECT_TASK}")
	private String SELECT_TASK;
	
	@Value("${DISPLAY_TASK_DATA}")
	private String DISPLAY_TASK_DATA;
	
	@Value("${DELETE_TASK}")
	private String DELETE_TASK;
	
	@Value("${DELETE_FILE_DATA}")
	private String DELETE_FILE_DATA;
	
	
	@Value("${UPDATE_TASK_DATA}")
	private String UPDATE_TASK_DATA;
	
	@Value("${SELECT_EMP}")
	private String SELECT_EMP;
	
	@Value("${SELECT_EMP_DATA}")
	private String SELECT_EMP_DATA;
	
	@Value("${UPDATE_EMP_MST}")
	private String UPDATE_EMP_MST;
	
	
	@Value("${UPDATE_EMP_MST}")
	private String UPDATE_TASK_USERS;
	
	
	
	
	@Value("${INSERT_TASK_BACKUP}")
	private String INSERT_TASK_BACKUP;
	
	@Value("${SELECT_EDIT_NUMBER}")
	private String SELECT_EDIT_NUMBER;
	
	@Value("${UPDATE_TASKBACK_LATEST}")
	private String UPDATE_TASKBACK_LATEST;
	
	@Value("${SELECT_PROJPOST}")
	private String SELECT_PROJPOST;

	@Value("${SELECT_AYACUT_PROJECT}")
	private String SELECT_AYACUT_PROJECT;
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
/*	@Override
	public List<User> getUserDetails(String userName, String password)
			throws TaskUserException {

		String sql = GET_USER_DETAILS;
		try {


                //System.out.println("GET_USER_DETAILS"+"--"+userName+"--"+password);
			List<User> User = jdbcHrmsTemplate.query(sql, new Object[] {
					userName, password }, new RowMapper<User>() {

				public User mapRow(ResultSet rs, int rowNum)
						throws SQLException {

					User users = new User();
					users.setUserName(rs.getString(1));
					users.setUserDesc(rs.getString(2));
					users.setRoleId(rs.getInt(3));
					
					users.setCircleId(rs.getInt(5));
					users.setCircleName(rs.getString(6));
					users.setUnitId(rs.getInt(7));
					users.setUnitName(rs.getString(8));
					users.setDivisionId(rs.getInt(9));
					users.setDivisionName(rs.getString(10));
					users.setSubdivisionId(11);
					users.setSubdivisionName(rs.getString(12));
					
					

					
					
					
					
					
					return users;

				}

			});

			return User;
		} catch (Exception exc) {
			log.error(exc.getMessage());
			return null;
		}

	}
	
	
	
	
	
	@Override
	public User getUserPostDetails(String userName, String password)
			throws TaskUserException {
		
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

							return postgresUsers;
						}
					});
			return postUsers;
		} catch (Exception exc) {
			log.error(exc.getMessage());
			return null;
		}
	}
	
	*/
	
	@Override
	public List<Unit> getUnitList() throws TaskUserException {
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
	public List<Circle> getCircleList(Integer unitId) throws TaskUserException {
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
	public List<Division> getDivisionList(Integer circleId) throws TaskUserException {
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
	public List<Subdivision> getSubDivisionList(Integer divisionId) throws TaskUserException {
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
	public List<Project> getProjectList(Integer unitId) throws TaskUserException {
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
	public List<Packages> getPackageList(Integer projectId) throws TaskUserException {
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
	
	@Override
	public List<TaskType> getTaskTypeList() throws TaskUserException {
		String sql = SELECT_TASK_TYPE;
		try {

			List<TaskType> taskTypelist = jdbcTemplate.query(sql,new Object[] { },
					new RowMapper<TaskType>() {

						public TaskType mapRow(ResultSet rs, int rowNum)
								throws SQLException {

							TaskType tt = new TaskType();
							tt.setTaskTypeId(rs.getInt(1));
							tt.setTaskTypeName(rs.getString(2));
							return tt;
						}

					});
			jdbcTemplate.getDataSource().getConnection().close();
			return taskTypelist;
		} catch (Exception exc) {
			log.error(exc.getMessage());
			return null;
		}
	}
	
	@Override
	public List<TaskPriority> getTaskPriorityList() throws TaskUserException {
		String sql = SELECT_TASK_PRIORITY;
		try {

			List<TaskPriority> taskPriorityList = jdbcTemplate.query(sql,new Object[] {  },
					new RowMapper<TaskPriority>() {

						public TaskPriority mapRow(ResultSet rs, int rowNum)
								throws SQLException {

							TaskPriority tp = new TaskPriority();
							tp.setPriorId(rs.getInt(1));
							tp.setPriorName(rs.getString(2));
							return tp;
						}

					});
			jdbcTemplate.getDataSource().getConnection().close();
			return taskPriorityList;
		} catch (Exception exc) {
			log.error(exc.getMessage());
			return null;
		}
	}
	
	@Override
	public List<Designation> getDesignationList() throws TaskUserException {
		String sql = SELECT_DESIGNATION;
		try {

			List<Designation> designationList = jdbcTemplate.query(sql,new Object[] { },
					new RowMapper<Designation>() {

						public Designation mapRow(ResultSet rs, int rowNum)
								throws SQLException {

							Designation designation = new Designation();
							designation.setDesignationId(rs.getInt(1));
							designation.setDesignationName(rs.getString(2));
							return designation;
						}

					});
			jdbcTemplate.getDataSource().getConnection().close();
			return designationList;
		} catch (Exception exc) {
			log.error(exc.getMessage());
			return null;
		}
	}
	
	@Override
	public List<TaskStatus> getTaskStatusList() throws TaskUserException {
		String sql = SELECT_TASK_STATUS;
		try {

			List<TaskStatus> taskStatusList = jdbcTemplate.query(sql,new Object[] { },
					new RowMapper<TaskStatus>() {

						public TaskStatus mapRow(ResultSet rs, int rowNum)
								throws SQLException {

							TaskStatus taskStatus = new TaskStatus();
							taskStatus.setStatusId(rs.getInt(1));;
							taskStatus.setStatusName(rs.getString(2));
							return taskStatus;
						}

					});
			jdbcTemplate.getDataSource().getConnection().close();
			return taskStatusList;
		} catch (Exception exc) {
			log.error(exc.getMessage());
			return null;
		}
	}
	
	
	@Override
	public List<TaskResponsibleEmp> getTaskResponsibleList() throws TaskUserException {
		String sql = SELECT_RESPONSIBLE_EMP;
		try {

			List<TaskResponsibleEmp> treList = jdbcTemplate.query(sql,new Object[] { },
					new RowMapper<TaskResponsibleEmp>() {

						public TaskResponsibleEmp mapRow(ResultSet rs, int rowNum)
								throws SQLException {

							TaskResponsibleEmp tre = new TaskResponsibleEmp();
							tre.setResponsibleEmpId(rs.getInt(1));;
							tre.setResponsibleEmpName(rs.getString(2));
							tre.setDesignationId(rs.getInt(3));
							tre.setUnitId(rs.getInt(4));
							tre.setCircleId(rs.getInt(5));
							tre.setDivisionId(rs.getInt(6));
							tre.setSubdivisionId(rs.getInt(7));
							return tre;
						}

					});
			jdbcTemplate.getDataSource().getConnection().close();
			return treList;
		} catch (Exception exc) {
			log.error(exc.getMessage());
			return null;
		}
	}
	
	@Override
	public Integer insertTasks(final Task taskObject) throws TaskUserException, SQLException, ParseException {
		// TODO Auto-generated method stub
		
		String sql = INSERT_TASK_DATA;
		
		String sql1 = INSERT_FILE_DATA;
		
		
		
		Date date1=null;
		Date date2=null;
		
	   Integer taskId=0;
		int[] j = null;
		
		Integer filerows=0;
		
		
		if (taskObject!=null) {
			
			
			jdbcTemplate.getDataSource().getConnection().setAutoCommit(false);
			
          
			
				
				
			if(taskObject.getAssignedDate()!=null && taskObject.getAssignedDate()!="" && !taskObject.getAssignedDate().equals('0') ){
			
				//System.out.println("caseObject.getFilingDate()"+caseObject.getFilingDate());
				date1 = DateUtil.getSQLDate(taskObject.getAssignedDate());
					
			}
			
			if(taskObject.getTargetDate()!=null && taskObject.getTargetDate()!="" && !taskObject.getTargetDate().equals("0")  ){
			 date2 =  DateUtil.getSQLDate(taskObject.getTargetDate());
					 
			}
			Integer unit=0;
			Integer circle=0;
			Integer division=0;
			Integer subdivision=0;
			Integer resseemp=0;
			Integer reseeemp=0;
			Integer resdeeemp=0;
			Integer resaeeemp=0;
			
			//System.out.println("taskObject.getUnitId()"+taskObject.getUnitId());

			if(taskObject.getUnitId()>0){
				
				unit=taskObject.getUnitId();
				//System.out.println("taskObject.getOfficeType()"+taskObject.getOfficeType());
				//System.out.println(taskObject.getResponsibleSEEmpId()+"--"+taskObject.getResponsibleEEEmpId()+" "+taskObject.getResponsibleDEEEmpId()+" "+taskObject.getResponsibleAEEEmpId());
				
				
					
				if(taskObject.getOfficeType()==2|| taskObject.getOfficeType()==3){
					
					resseemp=taskObject.getResponsibleSEEmpId();
					reseeemp=taskObject.getResponsibleEEEmpId();
					resdeeemp=taskObject.getResponsibleDEEEmpId();
					resaeeemp=taskObject.getResponsibleAEEEmpId();
					
					
				}
				
				if(taskObject.getCircleId()>0){
					unit=taskObject.getUnitId();
					circle=taskObject.getCircleId();
					division=taskObject.getDivisionId();
					subdivision=taskObject.getSubdivisionId();
					
					if(taskObject.getOfficeType()==1){
					resseemp=taskObject.getHiddenresSEId();
					reseeemp=taskObject.getHiddenresEEId();
					resdeeemp=taskObject.getHiddenresDEEId();
					resaeeemp=taskObject.getResponsibleAEEId();
					}
					
					if(taskObject.getOfficeType()==2|| taskObject.getOfficeType()==3){
						
						resseemp=taskObject.getResponsibleSEEmpId();
						reseeemp=taskObject.getResponsibleEEEmpId();
						resdeeemp=taskObject.getResponsibleDEEEmpId();
						resaeeemp=taskObject.getResponsibleAEEEmpId();
						
						
					}
					
					
					
					
					
					if(taskObject.getDivisionId()>0){
						unit=taskObject.getUnitId();
						circle=taskObject.getCircleId();
						division=taskObject.getDivisionId();
						subdivision=taskObject.getSubdivisionId();
						
						if(taskObject.getOfficeType()==1){
						resseemp=taskObject.getHiddenresSEId();
						reseeemp=taskObject.getHiddenresEEId();
						resdeeemp=taskObject.getHiddenresDEEId();
						resaeeemp=taskObject.getResponsibleAEEId();
						}
						
						
						if(taskObject.getSubdivisionId()>0){
							unit=taskObject.getUnitId();
							circle=taskObject.getCircleId();
							division=taskObject.getDivisionId();
							subdivision=taskObject.getSubdivisionId();
							if(taskObject.getOfficeType()==1){
							resseemp=taskObject.getHiddenresSEId();
							reseeemp=taskObject.getHiddenresEEId();
							resdeeemp=taskObject.getHiddenresDEEId();
							resaeeemp=taskObject.getResponsibleAEEId();
							}
							
							
						}	
						
					}
				}	
					
						
						
							
							
							
						}
						
						
						
						
						
					
				
			
			
			
				
			
			List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql,
					taskObject.getSubject(),taskObject.getProjectId(),taskObject.getPackageId(),unit,circle,division,subdivision,taskObject.getTaskTypeId(),taskObject.getPriorId(),taskObject.getStatusId(),taskObject.getUserpost(),taskObject.getAllfilenames(),taskObject.getFilelocation(),date1,date2,resseemp,reseeemp,resdeeemp,resaeeemp,taskObject.getUnitRemarks(),taskObject.getCircleRemarks(),taskObject.getDivisionRemarks(),taskObject.getSubdivisionRemarks(),taskObject.getAeeRemarks(),taskObject.getOfficeType());


			for (Map<String, Object> row : rows) {
				taskId = Integer.parseInt(row.get("task_id").toString());
			}

			final Integer id = taskId;
			
		//	System.out.println("id"+id);
			
			if(id>0){
				
			
			
                 if(taskObject.getFiledataList()!=null){
                	// System.out.println(taskObject.getFiledataList().size());
         			//System.out.println(taskObject.getFiledataList().get(0).getFileName());
				if (taskObject.getFiledataList().size() > 0) {
					if(taskObject.getFiledataList().get(0).getFileName()!=null || taskObject.getFiledataList().get(0).getFileName()!=" " ){
					j = jdbcTemplate.batchUpdate(sql1,
							new BatchPreparedStatementSetter() {
								@Override
								public void setValues(PreparedStatement ps, int i)
										throws SQLException {

									TaskFiles sd = taskObject.getFiledataList().get(i);

								
										ps.setString(1,  taskObject.getFiledataList().get(i).getFileName());
										ps.setString(2, taskObject.getFiledataList().get(i).getFileLocation());
										ps.setInt(3, id);
										ps.setString(4, taskObject.getFiledataList().get(i).getUserId());
										

									
								}

								@Override
								public int getBatchSize() {
									return taskObject.getFiledataList().size();
								}
							});
					
					}
				}
			}
		        if(j!=null){   
				if (j.length > 0) {
					filerows=j.length;
					
					//System.out.println("rows"+rows);
					return filerows;
				}
		        }
			
					

						
		}
		
		jdbcTemplate.getDataSource().getConnection().setAutoCommit(true);
		
		}
		jdbcTemplate.getDataSource().getConnection().close();
		return taskId;
	}


	
	@Override
	public List<Unit> getunitpostList() throws TaskUserException {
		// TODO Auto-generated method stub
		String sql = SELECT_UNITPOST;
		try {

			List<Unit> unitpostList = jdbcTemplate.query(sql,
					new RowMapper<Unit>() {

						public Unit mapRow(ResultSet rs, int rowNum)
								throws SQLException {

							Unit unitBean = new Unit();
							unitBean.setUnitId(rs.getInt(1));
							unitBean.setUnitName(rs.getString(2));
							return unitBean;
						}

					});
			jdbcTemplate.getDataSource().getConnection().close();
			return unitpostList;
		} catch (Exception exc) {
			log.error(exc.getMessage());
			return null;
		}
	}
	@Override
	public List<Circle> getcirclepostList() throws TaskUserException {
		// TODO Auto-generated method stub
		String sql = SELECT_CIRCLEPOST;
		try {

			List<Circle> circlePostList = jdbcTemplate.query(sql,
					new RowMapper<Circle>() {

						public Circle mapRow(ResultSet rs, int rowNum)
								throws SQLException {

							Circle circleBean = new Circle();
							circleBean.setCircleId(rs.getInt(1));
							circleBean.setCircleName(rs.getString(2));
							circleBean.setUnitId(rs.getInt(3));
							return circleBean;
						}

					});
			jdbcTemplate.getDataSource().getConnection().close();
			return circlePostList;
		} catch (Exception exc) {
			log.error(exc.getMessage());
			return null;
		}
	}
	@Override
	public List<Division> getdivisionpostList() throws TaskUserException {
		// TODO Auto-generated method stub
		String sql = SELECT_DIVISIONPOST;
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
	public List<Subdivision> getsubdivisionpostList() throws TaskUserException {
		// TODO Auto-generated method stub
		String sql = SELECT_SUBDIVISIONPOST;
		try {

			List<Subdivision> sdList = jdbcTemplate.query(sql,
					new RowMapper<Subdivision>() {

						public Subdivision mapRow(ResultSet rs, int rowNum)
								throws SQLException {

							Subdivision sd = new Subdivision();
							sd.setSubdivisionId(rs.getInt(1));
							sd.setSubdivisionName(rs.getString(2));
							sd.setDivisionId(rs.getInt(3));
							return sd;
						}

					});
			jdbcTemplate.getDataSource().getConnection().close();
			return sdList;
		} catch (Exception exc) {
			log.error(exc.getMessage());
			return null;
		}
	}
	
	@Override
	public List<Project>  getprojListbypostgres() throws TaskUserException {
		// TODO Auto-generated method stub
		String sql = SELECT_PROJPOST;
		try {

			List<Project> sdList = jdbcTemplate.query(sql,
					new RowMapper<Project>() {

						public Project mapRow(ResultSet rs, int rowNum)
								throws SQLException {

							Project sd = new Project();
							sd.setProjectId(rs.getInt(1));
							sd.setProjectName(rs.getString(2));
							sd.setUnitId(rs.getInt(3));
							return sd;
						}

					});
			jdbcTemplate.getDataSource().getConnection().close();
			return sdList;
		} catch (Exception exc) {
			log.error(exc.getMessage());
			return null;
		}
	}
	@Override
	public List<Unit>  getprojListNew() throws TaskUserException {
		// TODO Auto-generated method stub
		String sql = SELECT_AYACUT_PROJECT;
		try {

			List<Unit> sdList = jdbcTemplate.query(sql,
					new RowMapper<Unit>() {

						public Unit mapRow(ResultSet rs, int rowNum)
								throws SQLException {

							Unit sd = new Unit();
					//		sd.setProjectId(rs.getInt(1));
					//		sd.setProjectName(rs.getString(2));
							sd.setUnitId(rs.getInt(1));
							sd.setUnitName(rs.getString(2));
							return sd;
						}

					});
			jdbcTemplate.getDataSource().getConnection().close();
			return sdList;
		} catch (Exception exc) {
			log.error(exc.getMessage());
			return null;
		}
	}
	

	
	

	
	@Override
	public List<TaskResponsibleEmp> getSEList(Integer circleId) throws TaskUserException {
		// TODO Auto-generated method stub
		String sql = SELECT_SE_LIST;
		try {

			List<TaskResponsibleEmp> resseList = jdbcTemplate.query(sql,new Object[] { circleId },
					new RowMapper<TaskResponsibleEmp>() {

						public TaskResponsibleEmp mapRow(ResultSet rs, int rowNum)
								throws SQLException {

							TaskResponsibleEmp resse = new TaskResponsibleEmp();
							resse.setResponsibleEmpId(rs.getInt(1));
							resse.setResponsibleEmpName(rs.getString(2));
							return resse;
						}

					});
			jdbcTemplate.getDataSource().getConnection().close();
			return resseList;
		} catch (Exception exc) {
			log.error(exc.getMessage());
			return null;
		}
	}

	@Override
	public List<TaskResponsibleEmp> getEEList(Integer divisionId) throws TaskUserException {
		// TODO Auto-generated method stub
		String sql = SELECT_EE_LIST;
		try {

			List<TaskResponsibleEmp> reseeList = jdbcTemplate.query(sql,new Object[] { divisionId },
					new RowMapper<TaskResponsibleEmp>() {

						public TaskResponsibleEmp mapRow(ResultSet rs, int rowNum)
								throws SQLException {


							TaskResponsibleEmp resee = new TaskResponsibleEmp();
							resee.setResponsibleEmpId(rs.getInt(1));
							resee.setResponsibleEmpName(rs.getString(2));
							return resee;
						}

					});
			jdbcTemplate.getDataSource().getConnection().close();
			return reseeList;
		} catch (Exception exc) {
			log.error(exc.getMessage());
			return null;
		}
	}

	@Override
	public List<TaskResponsibleEmp> getDEEList(Integer subdivisionId) throws TaskUserException {
		// TODO Auto-generated method stub
		String sql = SELECT_DEE_LIST;
		try {

			List<TaskResponsibleEmp> resdeeList = jdbcTemplate.query(sql,new Object[] { subdivisionId },
					new RowMapper<TaskResponsibleEmp>() {

						public TaskResponsibleEmp mapRow(ResultSet rs, int rowNum)
								throws SQLException {

							TaskResponsibleEmp resdee = new TaskResponsibleEmp();
							resdee.setResponsibleEmpId(rs.getInt(1));
							resdee.setResponsibleEmpName(rs.getString(2));
							return resdee;
						}

					});
			jdbcTemplate.getDataSource().getConnection().close();
			return resdeeList;
		} catch (Exception exc) {
			log.error(exc.getMessage());
			return null;
		}
	}

	
	@Override
	public List<TaskResponsibleEmp> getAEEList(Integer subdivisionId) throws TaskUserException {
		// TODO Auto-generated method stub
		String sql = SELECT_AEE_AE_LIST;
		try {

			List<TaskResponsibleEmp> resaeeList = jdbcTemplate.query(sql,new Object[] { subdivisionId },
					new RowMapper<TaskResponsibleEmp>() {

						public TaskResponsibleEmp mapRow(ResultSet rs, int rowNum)
								throws SQLException {

							TaskResponsibleEmp resaee = new TaskResponsibleEmp();
							resaee.setResponsibleEmpId(rs.getInt(1));
							resaee.setResponsibleEmpName(rs.getString(2));
							return resaee;

						}

					});
			jdbcTemplate.getDataSource().getConnection().close();
			return resaeeList;
		} catch (Exception exc) {
			log.error(exc.getMessage());
			return null;
		}
	}


	
	@Override
	public List<Task> getTaskList() throws TaskUserException {
		String sql = SELECT_TASK;
		try {

			List<Task> taskList = jdbcTemplate.query(sql,
					new RowMapper<Task>() {

						public Task mapRow(ResultSet rs, int rowNum)
								throws SQLException {

							Task task = new Task();
							task.setTaskId(rs.getInt(1));
							task.setSubject(rs.getString(2));
							task.setUnitId(rs.getInt(3));
							task.setCircleId(rs.getInt(4));
							task.setDivisionId(rs.getInt(5));
							task.setSubdivisionId(rs.getInt(6));
							return task;
						}

					});
			jdbcTemplate.getDataSource().getConnection().close();
			return taskList;
		} catch (Exception exc) {
			log.error(exc.getMessage());
			return null;
		}
	}
	
	
	@Override
	public Task getTaskObject(Integer taskId) throws TaskUserException {
		String sql = DISPLAY_TASK_DATA;
		try {

			Task taskObject = (Task) jdbcTemplate.queryForObject(
					sql, new Object[] { taskId },
					new RowMapper<Object>() {
						public Object mapRow(ResultSet rs, int rowNum)
								throws SQLException {
							Task task = new Task();
							task.setTaskId(rs.getInt(1));
							task.setSubject(rs.getString(2));
							task.setProjectId(rs.getInt(3));
							task.setPackageId(rs.getInt(4));
							task.setUnitId(rs.getInt(5));
							task.setCircleId(rs.getInt(6));
							task.setDivisionId(rs.getInt(7));
							task.setSubdivisionId(rs.getInt(8));
							task.setTaskTypeId(rs.getInt(9));
							task.setPriorId(rs.getInt(10));
							task.setStatusId(rs.getInt(11));
							task.setUnitRemarks(rs.getString(12));
							task.setAssignedDate(rs.getString(13));
							task.setTargetDate(rs.getString(14));
							task.setResponsibleSEId(rs.getInt(15));
							task.setResponsibleEEId(rs.getInt(16));
							task.setResponsibleDEEId(rs.getInt(17));
							task.setResponsibleAEEId(rs.getInt(18));
							task.setCircleRemarks(rs.getString(19));
							task.setDivisionRemarks(rs.getString(20));
							task.setSubdivisionRemarks(rs.getString(21));
							task.setOfficeType(rs.getInt(22));
							return task;
						}
					});
			jdbcTemplate.getDataSource().getConnection().close();
			return taskObject;
		} catch (Exception exc) {
			log.error(exc.getMessage());
			return null;
		}
	}
	
	
	@Override
	public Integer deleteTask(final Integer taskId) throws TaskUserException{
		
		Integer rows=0;
		Integer rows1=0;
		
		
		String sql = DELETE_TASK;
		String sql1 = DELETE_FILE_DATA;
		
	
		int[] j = null;

		try {
			jdbcTemplate.getDataSource().getConnection().setAutoCommit(false);
		

		if (taskId!=null) {
			if(taskId>0){
			 rows = jdbcTemplate.update(sql,new Object[] {
					 taskId });
			 if(rows>0){
			 rows1 = jdbcTemplate.update(sql1,new Object[] {
					 taskId });
			 
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
	public Integer updateTask(final Task taskObject) throws TaskUserException, ParseException{
		
		Integer rows=0;
		Integer rows1=0;
		Integer rows2=0;
		Integer rows3=0;
		
		
		String sql = UPDATE_TASK_DATA;
		String sql1= INSERT_FILE_DATA;
		String sql2=INSERT_TASK_BACKUP;
		
	    String sql4=SELECT_EDIT_NUMBER;
	    String sql5=UPDATE_TASKBACK_LATEST;
		
		
		Date date1=null;
		Date date2=null;
	
		int[] j = null;
		Integer editNum=0;

		try {
			
			
			
			jdbcTemplate.getDataSource().getConnection().setAutoCommit(false);
		

		if (taskObject!=null) {
			if(taskObject.getTaskId()>0){
				
				
				List<Map<String, Object>> 	ct=	jdbcTemplate.queryForList(sql4, new Object[] {
						taskObject.getTaskId() } );
				
				
				for (Map<String, Object> row : ct) {
					editNum = Integer.parseInt(row.get("edit_number").toString());
				}
				
				Integer editno=editNum+1;
				
				//System.out.println("editno"+editno);
				if(taskObject.getAssignedDate()!=null && taskObject.getAssignedDate()!="" && !taskObject.getAssignedDate().equals('0') ){
					
					//System.out.println("caseObject.getFilingDate()"+caseObject.getFilingDate());
					date1 = DateUtil.getSQLDate(taskObject.getAssignedDate());
						
				}
				
				if(taskObject.getTargetDate()!=null && taskObject.getTargetDate()!="" && !taskObject.getTargetDate().equals("0")  ){
				 date2 =  DateUtil.getSQLDate(taskObject.getTargetDate());
						 
				}
				Integer unit=0;
				Integer circle=0;
				Integer division=0;
				Integer subdivision=0;
				Integer resseemp=0;
				Integer reseeemp=0;
				Integer resdeeemp=0;
				Integer resaeeemp=0;
				
			//	System.out.println("taskObject.getUnitId()"+taskObject.getUnitId());
				
				if(taskObject.getUnitId()>0){
					
					unit=taskObject.getUnitId();
					
					//System.out.println("taskObject.getOfficeType()"+taskObject.getOfficeType());
					//System.out.println(taskObject.getResponsibleSEEmpId()+"--"+taskObject.getResponsibleEEEmpId()+" "+taskObject.getResponsibleDEEEmpId()+" "+taskObject.getResponsibleAEEEmpId());
					
					if(taskObject.getOfficeType()==2|| taskObject.getOfficeType()==3){
						
						resseemp=taskObject.getResponsibleSEEmpId();
						reseeemp=taskObject.getResponsibleEEEmpId();
						resdeeemp=taskObject.getResponsibleDEEEmpId();
						resaeeemp=taskObject.getResponsibleAEEEmpId();
						
						
					}
					
					if(taskObject.getCircleId()>0){
						unit=taskObject.getUnitId();
						circle=taskObject.getCircleId();
						division=taskObject.getDivisionId();
						subdivision=taskObject.getSubdivisionId();
						if(taskObject.getOfficeType()==1){
						resseemp=taskObject.getHiddenresSEId();
						reseeemp=taskObject.getHiddenresEEId();
						resdeeemp=taskObject.getHiddenresDEEId();
						resaeeemp=taskObject.getResponsibleAEEId();
						}
						
						
                 if(taskObject.getOfficeType()==2|| taskObject.getOfficeType()==3){
							
							resseemp=taskObject.getResponsibleSEEmpId();
							reseeemp=taskObject.getResponsibleEEEmpId();
							resdeeemp=taskObject.getResponsibleDEEEmpId();
							resaeeemp=taskObject.getResponsibleAEEEmpId();
							
							
						}
						
						
						if(taskObject.getDivisionId()>0){
							unit=taskObject.getUnitId();
							circle=taskObject.getCircleId();
							division=taskObject.getDivisionId();
							subdivision=taskObject.getSubdivisionId();
							if(taskObject.getOfficeType()==1){
							resseemp=taskObject.getHiddenresSEId();
							reseeemp=taskObject.getHiddenresEEId();
							resdeeemp=taskObject.getHiddenresDEEId();
							resaeeemp=taskObject.getResponsibleAEEId();
							}
							
							if(taskObject.getSubdivisionId()>0){
								unit=taskObject.getUnitId();
								circle=taskObject.getCircleId();
								division=taskObject.getDivisionId();
								subdivision=taskObject.getSubdivisionId();
								if(taskObject.getOfficeType()==1){
								resseemp=taskObject.getHiddenresSEId();
								reseeemp=taskObject.getHiddenresEEId();
								resdeeemp=taskObject.getHiddenresDEEId();
								resaeeemp=taskObject.getResponsibleAEEId();
								}
								
							}	
							
						}
					}	
						
						}
			 rows3=jdbcTemplate.update(sql5,new Object[]{taskObject.getTaskId()});
				
		     rows2 = jdbcTemplate.update(sql2,new Object[]{taskObject.getTaskId()});		
				
			 rows = jdbcTemplate.update(sql,new Object[] {taskObject.getSubject(),taskObject.getProjectId(),taskObject.getPackageId(),taskObject.getUnitId(),taskObject.getCircleId(),taskObject.getDivisionId(), taskObject.getSubdivisionId(),taskObject.getTaskTypeId(),taskObject.getPriorId(),taskObject.getStatusId(),taskObject.getUnitRemarks(), editno,taskObject.getAllfilenames(),taskObject.getFilelocation(), date1,date2,
					 resseemp,reseeemp,resdeeemp,resaeeemp,taskObject.getCircleRemarks(),taskObject.getDivisionRemarks(),taskObject.getSubdivisionRemarks(),taskObject.getAeeRemarks(),taskObject.getUserpost(),taskObject.getOfficeType(),taskObject.getTaskId() });
			
			}
		}
		
		
	//	System.out.println("id"+id);
		
		if(rows>0){
			
		   //System.out.println("filename"+taskObject.getFiledataList().get(0).getFileName());

			if (taskObject.getFiledataList().size() > 0) {
				if(taskObject.getFiledataList().get(0).getFileName()!=null || taskObject.getFiledataList().get(0).getFileName()!="	"){
				j = jdbcTemplate.batchUpdate(sql1,
						new BatchPreparedStatementSetter() {
							@Override
							public void setValues(PreparedStatement ps, int i)
									throws SQLException {

								TaskFiles sd = taskObject.getFiledataList().get(i);

							
									ps.setString(1,  taskObject.getFiledataList().get(i).getFileName());
									ps.setString(2, taskObject.getFiledataList().get(i).getFileLocation());
									ps.setInt(3, taskObject.getTaskId());
									ps.setString(4, taskObject.getFiledataList().get(i).getUserId());
									

								
							}

							@Override
							public int getBatchSize() {
								return taskObject.getFiledataList().size();
							}
						});
				
				}
			}
			
	           
			if (j.length > 0) {
                rows1=j.length;
				
				//System.out.println("rows"+rows);
				return rows1;
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
	public List<Employee> getAllEmp(Integer unitId,Integer circleId,Integer divisionId, Integer subdivisionId) throws TaskUserException {
		
		String sql=null;
		//System.out.println("unitId"+unitId+"divisionId"+divisionId+"subdivisionId"+subdivisionId+"circleId"+circleId);
		if((unitId!=0  )&&(circleId==0)&&(divisionId==0 )&& (subdivisionId==0)){
			if(unitId>0){
				
	       sql = SELECT_EMP+" and tem.unit_id="+unitId+" order by  emp";
			}
		}
		if((unitId!=0)&&(circleId!=0 ) && (divisionId==0 )&& (subdivisionId==0 )){
			if(unitId>0 && circleId>0 ){
		 sql =SELECT_EMP+" and tem.unit_id="+unitId+" and tem.circle_id= "+circleId+" order by  emp";
				 //SELECT_TASK_ALL_CIRCLE;
			}
		}
		
		
		if(unitId!=0&& (circleId!=0 )&&(divisionId!=0 )&&(subdivisionId==0  )){
			if(unitId>0 && circleId>0 && divisionId>0 ){
		 sql = SELECT_EMP+" and tem.unit_id="+unitId+" and tem.circle_id= "+circleId+" and tem.division_id="+divisionId+" order by  emp";
				 //SELECT_TASK_ALL_DIVISION;
			}
		}
		if(unitId!=0&&(circleId!=0 )&&(divisionId!=0 )&&(subdivisionId!=0 )){
			if(unitId>0 && circleId>0 && divisionId>0 && subdivisionId>0 ){
				
		sql = SELECT_EMP+" and tem.unit_id="+unitId+" and tem.circle_id= "+circleId+" and tem.division_id="+divisionId+" and tem.subdivision_id="+subdivisionId+" order by  emp";
			}
		}
		//final String sql2=UNIT_NAME;
		
		
		try {
			
			
			
		

			List<Employee> empList = jdbcTemplate.query(sql ,new RowMapper<Employee>() {

				public Employee mapRow(ResultSet rs, int rowNum)
						throws SQLException {

					Employee emp = new Employee();
					
					emp.setEmpId(rs.getInt(1));
					emp.setEmployeeName(rs.getString(2)); 
					emp.setUnitId(rs.getInt(3));
					emp.setCircleId(rs.getInt(4));
					emp.setDivisionId(rs.getInt(5));
					emp.setSubdivisionId(rs.getInt(6));
					emp.setPhoneNum1(rs.getString(7));
					emp.setDesignationId(rs.getInt(8));
					emp.setHrmsId(rs.getLong(9));
					emp.setPostId(rs.getLong(10));
					emp.setDesignationName(rs.getString(11));
					emp.setUnitName(rs.getString(12));
					emp.setCircleName(rs.getString(13));
					emp.setDivisionName(rs.getString(14));
					emp.setSubdivisionName(rs.getString(15));
					
					return emp;

				}

			});
			jdbcTemplate.getDataSource().getConnection().close();
			return empList;
		} catch (Exception exc) {
			log.error(exc.getMessage());
			return null;
		}

		
	}
	
	
	@Override
	public Employee getEmployeeObject(Integer empId) throws TaskUserException {
		String sql = SELECT_EMP_DATA;
		try {

			Employee empObject = (Employee) jdbcTemplate.queryForObject(
					sql, new Object[] { empId },
					new RowMapper<Object>() {
						public Object mapRow(ResultSet rs, int rowNum)
								throws SQLException {
							Employee empdata = new Employee();
							empdata.setEmpId(rs.getInt(1));
							empdata.setFirstName(rs.getString(2));
							empdata.setLastName(rs.getString(3));
							empdata.setUnitId(rs.getInt(4));
							empdata.setCircleId(rs.getInt(5));
							empdata.setDivisionId(rs.getInt(6));
							empdata.setSubdivisionId(rs.getInt(7));
							empdata.setPhoneNum1(rs.getString(8));
							empdata.setDesignationId(rs.getInt(9));
							
							return empdata;
						}
					});
			jdbcTemplate.getDataSource().getConnection().close();
			return empObject;
		} catch (Exception exc) {
			log.error(exc.getMessage());
			return null;
		}
	}
	
	
	@Override
	public Integer updateemp(final Employee empObject) throws TaskUserException, ParseException{
		
		Integer rows=0;
		Integer rows1=0;
		
		
		String sql = UPDATE_EMP_MST;
		String sql1= UPDATE_TASK_USERS;
		
		Date date1=null;
		Date date2=null;
	
		int[] j = null;

		try {
			jdbcTemplate.getDataSource().getConnection().setAutoCommit(false);
		

		if (empObject!=null) {
			if(empObject.getEmpId()>0){
				
				if(empObject.getFirstName()!=null && empObject.getLastName()!="" && !empObject.getPhoneNum1().equals('0') ){
					
					
						
				
				//System.out.println("empObject"+empObject);
				
			 rows = jdbcTemplate.update(sql,new Object[] {empObject.getFirstName(),empObject.getLastName(), empObject.getUnitId(),empObject.getCircleId(), empObject.getDivisionId(),empObject.getSubdivisionId(),empObject.getPhoneNum1(),empObject.getDesignationId(),empObject.getUserId(),empObject.getEmpId()});
			
			}
		}
		
		
	//	System.out.println("id"+id);
		
		   
			
				

					
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
		try {
			jdbcTemplate.getDataSource().getConnection().close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
		
		
	}
	
	
	
	
}
