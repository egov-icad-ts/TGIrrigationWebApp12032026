package in.ts.icad.leagal.manager;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;
import java.util.Map;

import in.ts.icad.leagal.exception.TaskUserException;
import in.ts.icad.leagal.model.Circle;
import in.ts.icad.leagal.model.Designation;
import in.ts.icad.leagal.model.Division;
import in.ts.icad.leagal.model.Employee;
import in.ts.icad.leagal.model.Packages;
import in.ts.icad.leagal.model.Project;
import in.ts.icad.leagal.model.Subdivision;
import in.ts.icad.leagal.model.Task;
import in.ts.icad.leagal.model.TaskPriority;
import in.ts.icad.leagal.model.TaskResponsibleEmp;
import in.ts.icad.leagal.model.TaskStatus;
import in.ts.icad.leagal.model.TaskType;
import in.ts.icad.leagal.model.Unit;
import in.ts.icad.leagal.model.User;

public interface TaskAdminManager {
	
	
	List<Unit> getUnitList() throws TaskUserException;
	List<Circle> getCircleList(Integer unitId) throws TaskUserException;
	List<Division> getDivisionList(Integer circleId) throws TaskUserException;
	List<Subdivision> getSubDivisionList(Integer divisionId) throws TaskUserException ;
	 List<Project>  getprojListbypostgres() throws TaskUserException ;
	
	
	
	

	
	List<Project> getProjectList(Integer unitId) throws TaskUserException;
	List<Packages> getPackageList(Integer projectId) throws TaskUserException;
	
/*	List<User> getUserDetails(String userName, String password)  throws TaskUserException;
	User getUserPostDetails(String userName, String password)throws TaskUserException;
	*/
	List<TaskType> getTaskTypeList() throws TaskUserException;
	List<TaskPriority> getTaskPriorityList() throws TaskUserException;
	List<TaskStatus> getTaskStatusList() throws TaskUserException;
	List<Designation> getDesignationList() throws TaskUserException;
	List<TaskResponsibleEmp> getTaskResponsibleList() throws TaskUserException;
	Integer insertTasks(Task taskObject) throws TaskUserException, SQLException, ParseException;
	
	List<Subdivision> getsubdivisionpostList() throws TaskUserException;
	 List<Division> getdivisionpostList() throws TaskUserException;
	 List<Circle> getcirclepostList() throws TaskUserException;
	 List<Unit> getunitpostList() throws TaskUserException;
	 
	 List<TaskResponsibleEmp> getAEEList(Integer subdivisionId) throws TaskUserException;
	 List<TaskResponsibleEmp> getDEEList(Integer subdivisionId) throws TaskUserException;
	 List<TaskResponsibleEmp> getEEList(Integer divisionId) throws TaskUserException;
	 List<TaskResponsibleEmp> getSEList(Integer circleId) throws TaskUserException;
	 List<Task> getTaskList() throws TaskUserException;
		Task getTaskObject(Integer taskId) throws TaskUserException;
		Integer deleteTask(final Integer taskId) throws TaskUserException;
		Integer updateTask(Task taskObject) throws TaskUserException , ParseException ;
		List<Employee> getAllEmp(Integer unitId,Integer circleId,Integer divisionId, Integer subdivisionId) throws TaskUserException;
		Employee getEmployeeObject(Integer empId) throws TaskUserException;
		Integer updateemp(final Employee empObject) throws TaskUserException, ParseException;
		public List<Map<String, Object>> generalqueryforresult(String query);
		public List<Unit> getprojListNew() throws TaskUserException;	

}
