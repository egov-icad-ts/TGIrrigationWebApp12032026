package in.ts.icad.leagal.manager.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import in.ts.icad.leagal.dao.LeagalReportDAO;
import in.ts.icad.leagal.dao.TaskReportDAO;
import in.ts.icad.leagal.exception.TaskUserException;
import in.ts.icad.leagal.manager.TaskReportManager;
import in.ts.icad.leagal.model.Task;
import in.ts.icad.leagal.model.TaskFiles;
import in.ts.icad.leagal.model.TaskType;

@Component
public class TaskReportManagerImpl implements TaskReportManager {
	

	@Autowired
	private TaskReportDAO taskReportDAO;

	@Override
	public List<Task> getAllTasks() throws TaskUserException {
		// TODO Auto-generated method stub
		return taskReportDAO.getAllTasks();
	}

	@Override
	public List<TaskFiles> getFilesTasks() throws TaskUserException {
		// TODO Auto-generated method stub
		return taskReportDAO.getFilesTasks();
	}

	@Override
	public List<TaskType> getTaskTypes() throws TaskUserException {
		// TODO Auto-generated method stub
		return taskReportDAO.getTaskTypes();
	}

	@Override
	public List<Task> getAllTasksbyunit(Integer unitId, Integer circleId, Integer divisionId, Integer subdivisionId)
			throws TaskUserException {
		// TODO Auto-generated method stub
		return taskReportDAO.getAllTasksbyunit(unitId, circleId, divisionId, subdivisionId);
	}

	@Override
	public List<Task> getAllTasksbyUnitbyType(Integer unitId, Integer circleId, Integer divisionId,
			Integer subdivisionId, Integer typeId) throws TaskUserException {
		// TODO Auto-generated method stub
		return taskReportDAO.getAllTasksbyUnitbyType(unitId, circleId, divisionId, subdivisionId, typeId);
	}

}
