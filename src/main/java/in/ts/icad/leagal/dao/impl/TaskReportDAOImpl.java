package in.ts.icad.leagal.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;


import in.ts.icad.leagal.dao.TaskReportDAO;
import in.ts.icad.leagal.exception.LeagalUserException;
import in.ts.icad.leagal.exception.TaskUserException;
import in.ts.icad.leagal.model.Task;
import in.ts.icad.leagal.model.TaskFiles;
import in.ts.icad.leagal.model.TaskType;
import in.ts.icad.leagal.model.Unit;
import in.ts.icad.leagal.model.abstractCounterData;

@Repository
public class TaskReportDAOImpl  implements TaskReportDAO {
	
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
	
	@Value("${SELECT_TASK_ALL}")
	private String SELECT_TASK_ALL;
	@Value("${SELECT_FILE}")
	private String SELECT_FILE;
	
	@Value("${SELECT_TYPES}")
	private String SELECT_TYPES;
	
	@Value("${SELECT_TASK_ALL_UNIT}")
	private String SELECT_TASK_ALL_UNIT;
	
	@Value("${SELECT_TASK_TYPE_UNIT}")
	private String SELECT_TASK_TYPE_UNIT;
	
	
	
	
	
	
	
	
	@Override
	public List<Task> getAllTasks() throws TaskUserException {
		
		String sql = SELECT_TASK_ALL;
		//final String sql2=UNIT_NAME;
		
		
		try {
			
			
			
		

			List<Task> tallList = jdbcTemplate.query(sql , new RowMapper<Task>() {

				public Task mapRow(ResultSet rs, int rowNum)
						throws SQLException {

					Task tall = new Task();
					
					tall.setTaskId(rs.getInt(1));
					tall.setSubject(rs.getString(2));
					
					tall.setProjectId(rs.getInt(3));
					tall.setPackageId(rs.getInt(4));
					tall.setUnitId(rs.getInt(5));
					tall.setCircleId(rs.getInt(6));
					tall.setDivisionId(rs.getInt(7));
					tall.setSubdivisionId(rs.getInt(8));
					tall.setTaskTypeId(rs.getInt(9));
					tall.setPriorId(rs.getInt(10));
					tall.setStatusId(rs.getInt(11));
					tall.setEmployeeName(rs.getString(12));
					tall.setPhoneNum1(rs.getString(13));
					tall.setRemarks(rs.getString(14));
					tall.setAssignedDate(rs.getString(15));
					tall.setTargetDate(rs.getString(16));
					tall.setProjectName(rs.getString(17));
					tall.setPackageName(rs.getString(18));
					tall.setUnitName(rs.getString(19));
					tall.setCircleName(rs.getString(20));
					tall.setDivisionName(rs.getString(21));
					tall.setSubdivisionName(rs.getString(22));
					tall.setTaskTypeName(rs.getString(23));
					
					tall.setStatus(rs.getString(24));
					tall.setPriority(rs.getString(25));
					
				
					
				
                      
					
					
					
					
					
					
					
					return tall;

				}

			});
			jdbcTemplate.getDataSource().getConnection().close();
			return tallList;
		} catch (Exception exc) {
			log.error(exc.getMessage());
			return null;
		}

		
	}
	
	@Override
	public List<TaskFiles> getFilesTasks() throws TaskUserException {
		
		String sql = SELECT_FILE;
		//final String sql2=UNIT_NAME;
		
		
		try {
			
			
			
		

			List<TaskFiles> taskFilesList = jdbcTemplate.query(sql , new RowMapper<TaskFiles>() {

				public TaskFiles mapRow(ResultSet rs, int rowNum)
						throws SQLException {

					TaskFiles taskFiles = new TaskFiles();
					taskFiles.setFileDataId(rs.getInt(1));
					
					taskFiles.setTaskId(rs.getInt(2));
					taskFiles.setFileName(rs.getString(3));
					
					
					
					
					
					
					
					
					return taskFiles;

				}

			});
			jdbcTemplate.getDataSource().getConnection().close();
			return taskFilesList;
		} catch (Exception exc) {
			log.error(exc.getMessage());
			return null;
		}

		
	}
	
	@Override
	public List<TaskType> getTaskTypes() throws TaskUserException {
		
		String sql = SELECT_TYPES;
		//final String sql2=UNIT_NAME;
		
		
		try {
			
			
			
		

			List<TaskType> taskTypeList = jdbcTemplate.query(sql , new RowMapper<TaskType>() {

				public TaskType mapRow(ResultSet rs, int rowNum)
						throws SQLException {

					TaskType taskType = new TaskType();
				
					
					taskType.setTaskTypeId(rs.getInt(1));
					taskType.setTaskTypeName(rs.getString(2));
					
					
					
					
					
					
					
					
					return taskType;

				}

			});
			jdbcTemplate.getDataSource().getConnection().close();
			return taskTypeList;
		} catch (Exception exc) {
			log.error(exc.getMessage());
			return null;
		}

		
	}
	
	
	
	@Override
	public List<Task> getAllTasksbyunit(Integer unitId,Integer circleId,Integer divisionId, Integer subdivisionId) throws TaskUserException {
		
		String sql=null;
		//System.out.println("unitId"+unitId+"divisionId"+divisionId+"subdivisionId"+subdivisionId+"circleId"+circleId);
		if((unitId!=0  )&&(circleId==0)&&(divisionId==0 )&& (subdivisionId==0)){
			if(unitId>0){
				
	       sql = SELECT_TASK_ALL_UNIT+" and ttd.unit_id="+unitId+" order by  priority_id desc";
			}
		}
		if((unitId!=0)&&(circleId!=0 ) && (divisionId==0 )&& (subdivisionId==0 )){
			if(unitId>0 && circleId>0 ){
		 sql =SELECT_TASK_ALL_UNIT+" and ttd.unit_id="+unitId+" and ttd.circle_id= "+circleId+" order by  priority_id desc";
				 //SELECT_TASK_ALL_CIRCLE;
			}
		}
		
		
		if(unitId!=0&& (circleId!=0 )&&(divisionId!=0 )&&(subdivisionId==0  )){
			if(unitId>0 && circleId>0 && divisionId>0 ){
		 sql = SELECT_TASK_ALL_UNIT+" and ttd.unit_id="+unitId+" and ttd.circle_id= "+circleId+" and ttd.division_id="+divisionId+" order by  priority_id desc";
				 //SELECT_TASK_ALL_DIVISION;
			}
		}
		if(unitId!=0&&(circleId!=0 )&&(divisionId!=0 )&&(subdivisionId!=0 )){
			if(unitId>0 && circleId>0 && divisionId>0 && subdivisionId>0 ){
				
		sql = SELECT_TASK_ALL_UNIT+" and ttd.unit_id="+unitId+" and ttd.circle_id= "+circleId+" and ttd.division_id="+divisionId+" and ttd.subdivision_id="+subdivisionId+" order by  priority_id desc";
			}
		}
		//final String sql2=UNIT_NAME;
		
		
		try {
			
			
			
		

			List<Task> tallList = jdbcTemplate.query(sql ,new RowMapper<Task>() {

				public Task mapRow(ResultSet rs, int rowNum)
						throws SQLException {

					Task tall = new Task();
					
					tall.setTaskId(rs.getInt(1));
					tall.setSubject(rs.getString(2));
					
					tall.setProjectId(rs.getInt(3));
					tall.setPackageId(rs.getInt(4));
					tall.setUnitId(rs.getInt(5));
					tall.setCircleId(rs.getInt(6));
					tall.setDivisionId(rs.getInt(7));
					tall.setSubdivisionId(rs.getInt(8));
					tall.setTaskTypeId(rs.getInt(9));
					tall.setPriorId(rs.getInt(10));
					tall.setStatusId(rs.getInt(11));
					tall.setEmployeeName(rs.getString(12));
					tall.setPhoneNum1(rs.getString(13));
					tall.setRemarks(rs.getString(14));
					tall.setAssignedDate(rs.getString(15));
					tall.setTargetDate(rs.getString(16));
					tall.setProjectName(rs.getString(17));
					tall.setPackageName(rs.getString(18));
					tall.setUnitName(rs.getString(19));
					tall.setCircleName(rs.getString(20));
					tall.setDivisionName(rs.getString(21));
					tall.setSubdivisionName(rs.getString(22));
					tall.setTaskTypeName(rs.getString(23));
					
					tall.setStatus(rs.getString(24));
					tall.setPriority(rs.getString(25));
                      
					
					
					
					
					
					
					
					return tall;

				}

			});
			jdbcTemplate.getDataSource().getConnection().close();
			return tallList;
		} catch (Exception exc) {
			log.error(exc.getMessage());
			return null;
		}

		
	}
	
	
	@Override
	public List<Task> getAllTasksbyUnitbyType(Integer unitId,Integer circleId,Integer divisionId, Integer subdivisionId,Integer typeId) throws TaskUserException {
		
		String sql=null;
		if(unitId!=null&&circleId==null&&divisionId==null&&subdivisionId==null){
			if(unitId>0){
				
	       sql = SELECT_TASK_TYPE_UNIT+" and ttd.unit_id="+unitId+" order by  priority_id desc";
			}
		}
		if(unitId!=null&&circleId!=null&&divisionId==null&&subdivisionId==null){
			if(unitId>0 && circleId>0 ){
		 sql =SELECT_TASK_TYPE_UNIT+" and ttd.unit_id="+unitId+" and ttd.circle_id= "+circleId+" order by  priority_id desc";
				 //SELECT_TASK_ALL_CIRCLE;
			}
		}
		if(unitId!=null&&circleId!=null&&divisionId!=null&&subdivisionId==null){
			if(unitId>0 && circleId>0 && divisionId>0 ){
		 sql = SELECT_TASK_TYPE_UNIT+" and ttd.unit_id="+unitId+" and ttd.circle_id= "+circleId+" and ttd.division_id="+divisionId+" order by  priority_id desc";
				 //SELECT_TASK_ALL_DIVISION;
			}
		}
		if(unitId!=null&&circleId!=null&&divisionId!=null&&subdivisionId!=null){
			if(unitId>0 && circleId>0 && divisionId>0 && subdivisionId>0 ){
		sql = SELECT_TASK_TYPE_UNIT+" and ttd.unit_id="+unitId+" and ttd.circle_id= "+circleId+" and ttd.division_id="+divisionId+" and ttd.subdivision_id="+subdivisionId+" order by  priority_id desc";
			}
		}
		//final String sql2=UNIT_NAME;
		
		
		try {
			
			
			
		

			List<Task> tallList = jdbcTemplate.query(sql ,new Object[] { typeId },new RowMapper<Task>() {

				public Task mapRow(ResultSet rs, int rowNum)
						throws SQLException {

					Task tall = new Task();
					
					tall.setTaskId(rs.getInt(1));
					tall.setSubject(rs.getString(2));
					
					tall.setProjectId(rs.getInt(3));
					tall.setPackageId(rs.getInt(4));
					tall.setUnitId(rs.getInt(5));
					tall.setCircleId(rs.getInt(6));
					tall.setDivisionId(rs.getInt(7));
					tall.setSubdivisionId(rs.getInt(8));
					tall.setTaskTypeId(rs.getInt(9));
					tall.setPriorId(rs.getInt(10));
					tall.setStatusId(rs.getInt(11));
					tall.setResponsibleEmpId(rs.getInt(12));
					tall.setRemarks(rs.getString(13));
					tall.setAssignedDate(rs.getString(14));
					tall.setTargetDate(rs.getString(15));
					tall.setProjectName(rs.getString(16));
					tall.setPackageName(rs.getString(17));
					tall.setUnitName(rs.getString(18));
					tall.setCircleName(rs.getString(19));
					tall.setDivisionName(rs.getString(20));
					tall.setSubdivisionName(rs.getString(21));
					tall.setTaskTypeName(rs.getString(22));
					
					tall.setStatus(rs.getString(23));
					tall.setPriority(rs.getString(24));
					tall.setDesignationName(rs.getString(25));
					tall.setEmployeeName(rs.getString(26));
					tall.setPhoneNum1(rs.getString(27));
					tall.setEmailId(rs.getString(28));
					
                      
					
					
					
					
					
					
					
					return tall;

				}

			});
			jdbcTemplate.getDataSource().getConnection().close();
			return tallList;
		} catch (Exception exc) {
			log.error(exc.getMessage());
			return null;
		}

		
	}
	
	
	
	
	
	

}
