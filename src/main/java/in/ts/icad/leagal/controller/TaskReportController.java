package in.ts.icad.leagal.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.codehaus.stax2.ri.typed.ValueEncoderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.annotation.JsonFormat.Value;

import in.ts.icad.leagal.exception.TaskUserException;
import in.ts.icad.leagal.manager.TaskAdminManager;
import in.ts.icad.leagal.manager.TaskReportManager;
import in.ts.icad.leagal.model.Circle;
import in.ts.icad.leagal.model.Division;
import in.ts.icad.leagal.model.Subdivision;
import in.ts.icad.leagal.model.Task;
import in.ts.icad.leagal.model.TaskFiles;
import in.ts.icad.leagal.model.TaskType;
import in.ts.icad.leagal.model.Unit;

@Controller
public class TaskReportController {

	@Autowired
	private TaskAdminManager taskAdminManager;

	@Autowired
	private TaskReportManager taskReportManager;

	@RequestMapping(value = "/task/taskreport2")
	@ResponseBody
	public ModelAndView taskreport2(@ModelAttribute("taskreport2") Task taskreport, SessionStatus status,
			HttpSession session) {

		ModelAndView mav = new ModelAndView();
		mav.setViewName("taskreport2");

		List<Unit> unitList = new ArrayList<Unit>();
		List<Circle> circleList = new ArrayList<Circle>();
		List<Division> divisionList = new ArrayList<Division>();
		List<Subdivision> subdivisionList = new ArrayList<Subdivision>();

		List<Task> taskAllList = new ArrayList<Task>();
		List<TaskFiles> taskFilesList = new ArrayList<TaskFiles>();

		List<TaskType> taskTypeList = new ArrayList<TaskType>();

		Integer unitId = 0;
		Integer circleId = 0;
		Integer divisionId = 0;
		Integer subdivisionId = 0;
		Integer typeId = 0;

		if (taskreport != null) {

			unitId = taskreport.getUnitId();
			circleId = taskreport.getCircleId();
			divisionId = taskreport.getDivisionId();
			subdivisionId = taskreport.getSubdivisionId();
			typeId = taskreport.getTaskTypeId();

		}

		try {
			unitList = taskAdminManager.getunitpostList();
			circleList = taskAdminManager.getcirclepostList();
			divisionList = taskAdminManager.getdivisionpostList();
			subdivisionList = taskAdminManager.getsubdivisionpostList();

			taskFilesList = taskReportManager.getFilesTasks();
			taskTypeList = taskReportManager.getTaskTypes();

			// System.out.println("unitIdfirst"+unitId);
			// System.out.println("circleId"+circleId);
			// System.out.println("divisionId"+divisionId);
			// System.out.println("subdivisionId"+subdivisionId);

			// System.out.println("typeId"+typeId);

			if (unitId == null && (typeId == null || typeId == -1)) {

				// System.out.println("not coming here");
				taskAllList = taskReportManager.getAllTasks();
				typeId = -1;

			}

			// System.out.println("unitnames"+unitId+""+circleId+""+divisionId+""+subdivisionId);
			if (unitId != null && (typeId == null || typeId == -1)) {

				if (unitId > 0) {

					if (circleId == null || circleId.equals(null)) {
						circleId = 0;
					}
					if (divisionId == null || divisionId.equals(null)) {
						divisionId = 0;
					}
					if (subdivisionId == null || subdivisionId.equals(null)) {
						subdivisionId = 0;
					}
					// System.out.println("coming here");
					// System.out.println("unitnames2"+unitId+""+circleId+""+divisionId+""+subdivisionId);
					taskAllList = taskReportManager.getAllTasksbyunit(unitId, circleId, divisionId, subdivisionId);
					typeId = -1;
				}

			}

			if (unitId != null && typeId != null) {

				if (unitId > 0 && typeId > 0) {

					if (circleId == null || circleId.equals(null)) {
						circleId = 0;
					}
					if (divisionId == null || divisionId.equals(null)) {
						divisionId = 0;
					}
					if (subdivisionId == null || subdivisionId.equals(null)) {
						subdivisionId = 0;
					}

					// System.out.println("coming here");

					taskAllList = taskReportManager.getAllTasksbyUnitbyType(unitId, circleId, divisionId, subdivisionId,
							typeId);
				}

			}

			// System.out.println("unitId"+unitId);
			// System.out.println("circleId"+circleId);
			// System.out.println("divisionId"+divisionId);
			// System.out.println("subdivisionId"+subdivisionId);

		} catch (TaskUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String displaytype = null;
		String displayunit = null;
		String displayvalue = null;

		for (int i = 0; i < taskTypeList.size(); i++) {

			if (typeId == taskTypeList.get(i).getTaskTypeId()) {

				displaytype = taskTypeList.get(i).getTaskTypeName();

			}

		}
		if (typeId != null) {
			if (typeId == -1) {
				displaytype = "All";
			}
			;
		}

	//	System.out.println("u there" + unitId + circleId + divisionId + subdivisionId);
		if (unitId == null && circleId == null && divisionId == null && subdivisionId == null) {

			displayvalue = "All";

			displayunit = "Unit/ Circle/ Division/ Subdivision";

		}

		if (unitId != null) {

			if (circleId == null || circleId.equals(null)) {
				circleId = 0;
			}
			if (divisionId == null || divisionId.equals(null)) {
				divisionId = 0;
			}
			if (subdivisionId == null || subdivisionId.equals(null)) {
				subdivisionId = 0;
			}

			if (unitId > 0) {

				for (int i = 0; i < unitList.size(); i++) {

					if (unitId == unitList.get(i).getUnitId()) {

						displayvalue = unitList.get(i).getUnitName();
					}

				}

				displayunit = "Unit";

			}

			if (unitId > 0 && circleId > 0) {

				if (divisionId == null || divisionId.equals(null)) {
					divisionId = 0;
				}
				if (subdivisionId == null || subdivisionId.equals(null)) {
					subdivisionId = 0;
				}

				for (int i = 0; i < circleList.size(); i++) {

					if (circleId == circleList.get(i).getCircleId()) {

						displayvalue = circleList.get(i).getCircleName();
					}

				}

				displayunit = "Circle";

			}

			if (unitId > 0 && circleId > 0 && divisionId > 0) {

				if (subdivisionId == null || subdivisionId.equals(null)) {
					subdivisionId = 0;
				}

				for (int i = 0; i < divisionList.size(); i++) {

					if (divisionId == divisionList.get(i).getDivisionId()) {

						displayvalue = divisionList.get(i).getDivisionName();
					}

				}

				displayunit = "Division";

			}

			if (unitId > 0 && circleId > 0 && divisionId > 0 && subdivisionId > 0) {

				for (int i = 0; i < subdivisionList.size(); i++) {

					if (subdivisionId == subdivisionList.get(i).getSubdivisionId()) {

						displayvalue = subdivisionList.get(i).getSubdivisionName();
					}

				}

				displayunit = "Subdivision";

			}

		}

		mav.addObject("unitList", unitList);
		mav.addObject("circleList", circleList);
		mav.addObject("divisionList", divisionList);
		mav.addObject("subdivisionList", subdivisionList);
		mav.addObject("taskAllList", taskAllList);
		mav.addObject("taskFilesList", taskFilesList);
		mav.addObject("taskTypeList", taskTypeList);
		mav.addObject("selectedTask", typeId);
		mav.addObject("displaytype", displaytype);
		mav.addObject("displayvalue", displayvalue);
		mav.addObject("displayunit", displayunit);

		return mav;
	}

}
