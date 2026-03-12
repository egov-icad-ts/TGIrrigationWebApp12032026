package in.ts.icad.leagal.manager.impl;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import in.ts.icad.leagal.dao.LeagalAdminDAO;
import in.ts.icad.leagal.dao.TaskAdminDAO;
import in.ts.icad.leagal.exception.TaskUserException;
import in.ts.icad.leagal.manager.TaskAdminManager;
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

@Component
public class TaskAdminManagerImpl implements TaskAdminManager {
	
	@Autowired
	private TaskAdminDAO taskAdminDAO;

	@Override
	public List<Unit> getUnitList() throws TaskUserException {
		// TODO Auto-generated method stub
		return taskAdminDAO.getUnitList();
	}

	@Override
	public List<Circle> getCircleList(Integer unitId) throws TaskUserException {
		// TODO Auto-generated method stub
		return taskAdminDAO.getCircleList(unitId);
	}

	@Override
	public List<Division> getDivisionList(Integer circleId) throws TaskUserException {
		// TODO Auto-generated method stub
		return taskAdminDAO.getDivisionList(circleId);
	}

	@Override
	public List<Subdivision> getSubDivisionList(Integer divisionId) throws TaskUserException {
		// TODO Auto-generated method stub
		return taskAdminDAO.getSubDivisionList(divisionId);
	}

	@Override
	public List<Project> getProjectList(Integer unitId) throws TaskUserException {
		// TODO Auto-generated method stub
		return taskAdminDAO.getProjectList(unitId);
	}

	@Override
	public List<Packages> getPackageList(Integer projectId) throws TaskUserException {
		// TODO Auto-generated method stub
		return taskAdminDAO.getPackageList(projectId);
	}

	/*@Override
	public List<User> getUserDetails(String userName, String password) throws TaskUserException {
		// TODO Auto-generated method stub
		return taskAdminDAO.getUserDetails(userName, password);
	}

	@Override
	public User getUserPostDetails(String userName, String password) throws TaskUserException {
		// TODO Auto-generated method stub
		return taskAdminDAO.getUserPostDetails(userName, password);
	}*/

	@Override
	public List<TaskType> getTaskTypeList() throws TaskUserException {
		// TODO Auto-generated method stub
		return taskAdminDAO.getTaskTypeList();
	}

	@Override
	public List<TaskPriority> getTaskPriorityList() throws TaskUserException {
		// TODO Auto-generated method stub
		return taskAdminDAO.getTaskPriorityList();
	}

	@Override
	public List<TaskStatus> getTaskStatusList() throws TaskUserException {
		// TODO Auto-generated method stub
		return taskAdminDAO.getTaskStatusList();
	}

	@Override
	public List<Designation> getDesignationList() throws TaskUserException {
		// TODO Auto-generated method stub
		return taskAdminDAO.getDesignationList();
	}

	@Override
	public List<TaskResponsibleEmp> getTaskResponsibleList() throws TaskUserException {
		// TODO Auto-generated method stub
		return taskAdminDAO.getTaskResponsibleList();
	}

	@Override
	public Integer insertTasks(Task taskObject) throws TaskUserException, SQLException, ParseException {
		// TODO Auto-generated method stub
		return taskAdminDAO.insertTasks(taskObject);
	}

	@Override
	public List<Subdivision> getsubdivisionpostList() throws TaskUserException {
		// TODO Auto-generated method stub
		return taskAdminDAO.getsubdivisionpostList();
	}

	@Override
	public List<Division> getdivisionpostList() throws TaskUserException {
		// TODO Auto-generated method stub
		return taskAdminDAO.getdivisionpostList();
	}

	@Override
	public List<Circle> getcirclepostList() throws TaskUserException {
		// TODO Auto-generated method stub
		return taskAdminDAO.getcirclepostList();
	}

	@Override
	public List<Unit> getunitpostList() throws TaskUserException {
		// TODO Auto-generated method stub
		return taskAdminDAO.getunitpostList();
	}

	@Override
	public List<TaskResponsibleEmp> getAEEList(Integer subdivisionId) throws TaskUserException {
		// TODO Auto-generated method stub
		return taskAdminDAO.getAEEList(subdivisionId);
	}

	@Override
	public List<TaskResponsibleEmp> getDEEList(Integer subdivisionId) throws TaskUserException {
		// TODO Auto-generated method stub
		return taskAdminDAO.getDEEList(subdivisionId);
	}

	@Override
	public List<TaskResponsibleEmp> getEEList(Integer divisionId) throws TaskUserException {
		// TODO Auto-generated method stub
		return taskAdminDAO.getEEList(divisionId);
	}

	@Override
	public List<TaskResponsibleEmp> getSEList(Integer circleId) throws TaskUserException {
		// TODO Auto-generated method stub
		return taskAdminDAO.getSEList(circleId);
	}

	@Override
	public List<Task> getTaskList() throws TaskUserException {
		// TODO Auto-generated method stub
		return taskAdminDAO.getTaskList();
	}

	@Override
	public Task getTaskObject(Integer taskId) throws TaskUserException {
		// TODO Auto-generated method stub
		return taskAdminDAO.getTaskObject(taskId);
	}

	@Override
	public Integer deleteTask(Integer taskId) throws TaskUserException {
		// TODO Auto-generated method stub
		return taskAdminDAO.deleteTask(taskId);
	}

	@Override
	public Integer updateTask(Task taskObject) throws TaskUserException,ParseException  {
		// TODO Auto-generated method stub
		return taskAdminDAO.updateTask(taskObject);
	}

	@Override
	public List<Employee> getAllEmp(Integer unitId, Integer circleId, Integer divisionId, Integer subdivisionId)
			throws TaskUserException {
		// TODO Auto-generated method stub
		return taskAdminDAO.getAllEmp(unitId, circleId, divisionId, subdivisionId);
	}

	@Override
	public Employee getEmployeeObject(Integer empId) throws TaskUserException {
		// TODO Auto-generated method stub
		return taskAdminDAO.getEmployeeObject(empId);
	}

	@Override
	public Integer updateemp(Employee empObject) throws TaskUserException, ParseException {
		// TODO Auto-generated method stub
		return taskAdminDAO.updateemp(empObject);
	}

	@Override
	public List<Map<String, Object>> generalqueryforresult(String query) {
		// TODO Auto-generated method stub
		return taskAdminDAO.generalqueryforresult(query);
	}

	@Override
	public List<Project> getprojListbypostgres() throws TaskUserException {
		// TODO Auto-generated method stub
		return taskAdminDAO.getprojListbypostgres();
	}
	
	@Override
	public List<Unit> getprojListNew() throws TaskUserException {
		// TODO Auto-generated method stub
		return taskAdminDAO.getprojListNew();
	}

	
	
}
