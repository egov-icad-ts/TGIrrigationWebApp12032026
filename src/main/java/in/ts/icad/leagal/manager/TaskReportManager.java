package in.ts.icad.leagal.manager;

import java.util.List;

import in.ts.icad.leagal.exception.TaskUserException;
import in.ts.icad.leagal.model.Task;
import in.ts.icad.leagal.model.TaskFiles;
import in.ts.icad.leagal.model.TaskType;

public interface TaskReportManager {
	
	
	List<Task> getAllTasks() throws TaskUserException;
	List<TaskFiles> getFilesTasks() throws TaskUserException;
	List<TaskType> getTaskTypes() throws TaskUserException;
	List<Task> getAllTasksbyunit(Integer unitId,Integer circleId,Integer divisionId, Integer subdivisionId) throws TaskUserException;
	List<Task> getAllTasksbyUnitbyType(Integer unitId,Integer circleId,Integer divisionId, Integer subdivisionId,Integer typeId) throws TaskUserException;

}
