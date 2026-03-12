
package in.ts.icad.leagal.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.regex.Pattern;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;

import in.ts.icad.leagal.exception.InventoryUserException;
import in.ts.icad.leagal.exception.LeagalUserException;
import in.ts.icad.leagal.exception.TaskUserException;
import in.ts.icad.leagal.manager.InventoryAdminManager;
import in.ts.icad.leagal.manager.InventoryReportManager;
import in.ts.icad.leagal.manager.LeagalAdminManager;
import in.ts.icad.leagal.manager.TaskAdminManager;
import in.ts.icad.leagal.model.Canal;
import in.ts.icad.leagal.model.Constituency;
import in.ts.icad.leagal.model.DamInspectDocs;
import in.ts.icad.leagal.model.District;
import in.ts.icad.leagal.model.EmpApprove;
import in.ts.icad.leagal.model.Employee;
import in.ts.icad.leagal.model.EmployeeDiversion;
import in.ts.icad.leagal.model.Habitations;
import in.ts.icad.leagal.model.MiTankFormDocs;
import in.ts.icad.leagal.model.MiTankInspect;
import in.ts.icad.leagal.model.MiTankformData;
import in.ts.icad.leagal.model.MitankChecks;
import in.ts.icad.leagal.model.MitankComps;
import in.ts.icad.leagal.model.MstOutputWithFlag;
import in.ts.icad.leagal.model.Paras;
import in.ts.icad.leagal.model.Project;
import in.ts.icad.leagal.model.PumpCommonData;
import in.ts.icad.leagal.model.PumpMaintainActivities;
import in.ts.icad.leagal.model.PumpOperationInstructions;
import in.ts.icad.leagal.model.PumpOperationType;
import in.ts.icad.leagal.model.PumpPumpsData;
import in.ts.icad.leagal.model.PumpStations;
import in.ts.icad.leagal.model.ReplyData;
import in.ts.icad.leagal.model.ReservoirAyacut;
import in.ts.icad.leagal.model.ReservoirGates;
import in.ts.icad.leagal.model.ReservoirInspect;
import in.ts.icad.leagal.model.ReservoirMaintenanceCategory;
import in.ts.icad.leagal.model.ReservoirMaintenanceChecks;
import in.ts.icad.leagal.model.ReservoirSalient;
import in.ts.icad.leagal.model.ReservoirUnitData;
import in.ts.icad.leagal.model.ScheduleDuty;
import in.ts.icad.leagal.model.Subdivision;
import in.ts.icad.leagal.model.TankFeedDetails;
import in.ts.icad.leagal.model.Tanks;
import in.ts.icad.leagal.model.Unit;
import in.ts.icad.leagal.model.User;
import in.ts.icad.leagal.util.ResizeImage;

@Controller
public class InventoryAdminController {

	@Autowired
	private LeagalAdminManager lam;

	@Autowired
	private InventoryAdminManager invam;
	
	@Autowired
	private InventoryReportManager irm;
	
	@Autowired
	private TaskAdminManager tam;
	
	@Autowired
	private ServletContext servletContext;

	
	@RequestMapping(value = "/invtsimis/resultofliveDB")
	public ModelAndView generalqueryforresult(@RequestParam("Query") String Query, SessionStatus status,
			HttpSession session) {

		// System.out.println("Query "+Query);

		ModelAndView mav = new ModelAndView();
		List<Map<String, Object>> count = null;
		String message = null;
		Map<String, Object> map = new HashMap<String, Object>();
		Set<String> keys = null;
		List<String> keyslist = new ArrayList<String>();
		Set<String> values = null;
		List<List<Object>> valueslist = new ArrayList<List<Object>>();

		Object[] keysarray = null;
		try {
			count = invam.generalqueryforresult(Query);
			if (count.size() >= 1) {
				for (int i = 0; i < count.size(); i++) {
					List<Object> vlist = new ArrayList<Object>();
					map.putAll(count.get(i));
					if (i == 0) {
						keys = map.keySet();
						keysarray = keys.toArray();
					} else {

					}
					for (int j = 0; j < keysarray.length; j++) {
						vlist.add((Object) count.get(i).get(keysarray[j].toString()));
					}
					valueslist.add(vlist);

				}
				mav.addObject("keys", keys);
				mav.addObject("values", valueslist);
			} else {
				map.putAll(count.get(0));
				String delete = "DELETE";
				String updated = "UPDATE";
				String inserted = "INSERT";
				String altered = "ALTER";
				if (Query.toLowerCase().contains(delete.toLowerCase())) {
					message = map.keySet() + "rows Deleted Successfully";
				} else if (Query.toLowerCase().contains(updated.toLowerCase())) {
					message = map.keySet() + "rows Updated Successfully";
				} else if (Query.toLowerCase().contains(inserted.toLowerCase())) {
					message = map.keySet() + "rows inserted Successfully";
				} else if (Query.toLowerCase().contains(altered.toLowerCase())) {
					message = map.keySet() + "rows altered Successfully";

				}

				else {
					message = "Successfully updated";
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			message = "Couldn't Execute the Query, Please Try Again";
		}
		mav.setViewName("updateinvDB");

		mav.addObject("resultset", count);
		mav.addObject("message", message);
		return mav;

	}
	
	
	@RequestMapping(value = "/invtsimis/resultofIrrinvliveDB")
	public ModelAndView generalqueryforresultirrinv(@RequestParam("Query") String Query, SessionStatus status,
			HttpSession session) {

		// System.out.println("Query "+Query);

		ModelAndView mav = new ModelAndView();
		List<Map<String, Object>> count = null;
		String message = null;
		Map<String, Object> map = new HashMap<String, Object>();
		Set<String> keys = null;
		List<String> keyslist = new ArrayList<String>();
		Set<String> values = null;
		List<List<Object>> valueslist = new ArrayList<List<Object>>();

		Object[] keysarray = null;
		try {
			count = invam.generalqueryforresultirrinv(Query);
			if (count.size() >= 1) {
				for (int i = 0; i < count.size(); i++) {
					List<Object> vlist = new ArrayList<Object>();
					map.putAll(count.get(i));
					if (i == 0) {
						keys = map.keySet();
						keysarray = keys.toArray();
					} else {

					}
					for (int j = 0; j < keysarray.length; j++) {
						vlist.add((Object) count.get(i).get(keysarray[j].toString()));
					}
					valueslist.add(vlist);

				}
				mav.addObject("keys", keys);
				mav.addObject("values", valueslist);
			} else {
				map.putAll(count.get(0));
				String delete = "DELETE";
				String updated = "UPDATE";
				String inserted = "INSERT";
				String altered = "ALTER";
				if (Query.toLowerCase().contains(delete.toLowerCase())) {
					message = map.keySet() + "rows Deleted Successfully";
				} else if (Query.toLowerCase().contains(updated.toLowerCase())) {
					message = map.keySet() + "rows Updated Successfully";
				} else if (Query.toLowerCase().contains(inserted.toLowerCase())) {
					message = map.keySet() + "rows inserted Successfully";
				} else if (Query.toLowerCase().contains(altered.toLowerCase())) {
					message = map.keySet() + "rows altered Successfully";

				}

				else {
					message = "Successfully updated";
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			message = "Couldn't Execute the Query, Please Try Again";
		}
		mav.setViewName("viewIrrigationInv");

		mav.addObject("resultset", count);
		mav.addObject("message", message);
		return mav;

	}
	
	
	

	@RequestMapping(value = "/invtsimis/liveinvDB")
	public ModelAndView editData() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("updateinvDB");
		return mav;

	}
	
	
	@RequestMapping(value = "/invtsimis/liveViewIrrinvDB")
	public ModelAndView viewInvData() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("viewIrrigationInv");
		return mav;

	}
	
	
	@RequestMapping(value = "/invtsimis/resultofpmsstageliveDB")
	public ModelAndView generalqueryforresultpmstage(@RequestParam("Query") String Query, SessionStatus status,
			HttpSession session) {

		// System.out.println("Query "+Query);

		ModelAndView mav = new ModelAndView();
		List<Map<String, Object>> count = null;
		String message = null;
		Map<String, Object> map = new HashMap<String, Object>();
		Set<String> keys = null;
		List<String> keyslist = new ArrayList<String>();
		Set<String> values = null;
		List<List<Object>> valueslist = new ArrayList<List<Object>>();

		Object[] keysarray = null;
		try {
			count = invam.generalqueryforresultpmsstage(Query);
			if (count.size() >= 1) {;
				for (int i = 0; i < count.size(); i++) {
					List<Object> vlist = new ArrayList<Object>();
					map.putAll(count.get(i));
					if (i == 0) {
						keys = map.keySet();
						keysarray = keys.toArray();
					} else {

					}
					for (int j = 0; j < keysarray.length; j++) {
						vlist.add((Object) count.get(i).get(keysarray[j].toString()));
					}
					valueslist.add(vlist);

				}
				mav.addObject("keys", keys);
				mav.addObject("values", valueslist);
			} else {
				map.putAll(count.get(0));
				String delete = "DELETE";
				String updated = "UPDATE";
				String inserted = "INSERT";
				String altered = "ALTER";
				if (Query.toLowerCase().contains(delete.toLowerCase())) {
					message = map.keySet() + "rows Deleted Successfully";
				} else if (Query.toLowerCase().contains(updated.toLowerCase())) {
					message = map.keySet() + "rows Updated Successfully";
				} else if (Query.toLowerCase().contains(inserted.toLowerCase())) {
					message = map.keySet() + "rows inserted Successfully";
				} else if (Query.toLowerCase().contains(altered.toLowerCase())) {
					message = map.keySet() + "rows altered Successfully";

				}

				else {
					message = "Successfully updated";
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			message = "Couldn't Execute the Query, Please Try Again";
		}
		mav.setViewName("updateStagePmsDB");

		mav.addObject("resultset", count);
		mav.addObject("message", message);
		return mav;

	}
	
	@RequestMapping(value = "/invtsimis/ViewStagePmsDB")
	public ModelAndView viewStagePmsData() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("updateStagePmsDB");
		return mav;

	}


	@RequestMapping(value = "/invtsimis/resultofinvomliveDB")
	public ModelAndView generalqueryforinvomresult(@RequestParam("Query") String Query, SessionStatus status,
			HttpSession session) {

		// System.out.println("Query "+Query);

		ModelAndView mav = new ModelAndView();
		List<Map<String, Object>> count = null;
		String message = null;
		Map<String, Object> map = new HashMap<String, Object>();
		Set<String> keys = null;
		List<String> keyslist = new ArrayList<String>();
		Set<String> values = null;
		List<List<Object>> valueslist = new ArrayList<List<Object>>();

		Object[] keysarray = null;
		try {
			count = invam.generalqueryforinvomresult(Query);
			if (count.size() >= 1) {
				for (int i = 0; i < count.size(); i++) {
					List<Object> vlist = new ArrayList<Object>();
					map.putAll(count.get(i));
					if (i == 0) {
						keys = map.keySet();
						keysarray = keys.toArray();
					} else {

					}
					for (int j = 0; j < keysarray.length; j++) {
						vlist.add((Object) count.get(i).get(keysarray[j].toString()));
					}
					valueslist.add(vlist);

				}
				mav.addObject("keys", keys);
				mav.addObject("values", valueslist);
			} else {
				map.putAll(count.get(0));
				String delete = "DELETE";
				String updated = "UPDATE";
				String inserted = "INSERT";
				String altered = "ALTER";
				if (Query.toLowerCase().contains(delete.toLowerCase())) {
					message = map.keySet() + "rows Deleted Successfully";
				} else if (Query.toLowerCase().contains(updated.toLowerCase())) {
					message = map.keySet() + "rows Updated Successfully";
				} else if (Query.toLowerCase().contains(inserted.toLowerCase())) {
					message = map.keySet() + "rows inserted Successfully";
				} else if (Query.toLowerCase().contains(altered.toLowerCase())) {
					message = map.keySet() + "rows altered Successfully";

				}

				else {
					message = "Successfully updated";
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			message = "Couldn't Execute the Query, Please Try Again";
		}
		mav.setViewName("updateinvomDB");

		mav.addObject("resultset", count);
		mav.addObject("message", message);
		return mav;

	}

	@RequestMapping(value = "/invtsimis/liveinvomDB")
	public ModelAndView editinvomData() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("updateinvomDB");
		return mav;

	}

	
	
	
	@RequestMapping(value = "/invtsimis/misviews")
	public ModelAndView generalqueryformisviews(@RequestParam("Query") String Query, SessionStatus status,
			HttpSession session) {

		// System.out.println("Query "+Query);

		ModelAndView mav = new ModelAndView();
		List<Map<String, Object>> count = null;
		String message = null;
		Map<String, Object> map = new HashMap<String, Object>();
		Set<String> keys = null;
		List<String> keyslist = new ArrayList<String>();
		Set<String> values = null;
		List<List<Object>> valueslist = new ArrayList<List<Object>>();

		Object[] keysarray = null;
		try {
			count = invam.generalqueryformisviews(Query);
			if (count.size() >= 1) {
				for (int i = 0; i < count.size(); i++) {
					List<Object> vlist = new ArrayList<Object>();
					map.putAll(count.get(i));
					if (i == 0) {
						keys = map.keySet();
						keysarray = keys.toArray();
					} else {

					}
					for (int j = 0; j < keysarray.length; j++) {
						vlist.add((Object) count.get(i).get(keysarray[j].toString()));
					}
					valueslist.add(vlist);

				}
				mav.addObject("keys", keys);
				mav.addObject("values", valueslist);
			} else {
				map.putAll(count.get(0));
				String delete = "DELETE";
				String updated = "UPDATE";
				String inserted = "INSERT";
				String altered = "ALTER";
				if (Query.toLowerCase().contains(delete.toLowerCase())) {
					message = map.keySet() + "rows Deleted Successfully";
				} else if (Query.toLowerCase().contains(updated.toLowerCase())) {
					message = map.keySet() + "rows Updated Successfully";
				} else if (Query.toLowerCase().contains(inserted.toLowerCase())) {
					message = map.keySet() + "rows inserted Successfully";
				} else if (Query.toLowerCase().contains(altered.toLowerCase())) {
					message = map.keySet() + "rows altered Successfully";

				}

				else {
					message = "Successfully updated";
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			message = "Couldn't Execute the Query, Please Try Again";
		}
		mav.setViewName("updatemisview");

		mav.addObject("resultset", count);
		mav.addObject("message", message);
		return mav;

	}

	@RequestMapping(value = "/invtsimis/livemisview")
	public ModelAndView misview() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("updatemisview");
		return mav;

	}
	
	
	@RequestMapping(value = "/invtsimis/livetanksview")
	public ModelAndView editlivetanksView() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("updatetanksviewDB");
		return mav;

	}
	
	
	@RequestMapping(value = "/invtsimis/tanksviewdata")
	public ModelAndView generalqueryformviewdata(@RequestParam("Query") String Query, SessionStatus status,
			HttpSession session) {

		// System.out.println("Query "+Query);

		ModelAndView mav = new ModelAndView();
		List<Map<String, Object>> count = null;
		String message = null;
		Map<String, Object> map = new HashMap<String, Object>();
		Set<String> keys = null;
		List<String> keyslist = new ArrayList<String>();
		Set<String> values = null;
		List<List<Object>> valueslist = new ArrayList<List<Object>>();

		Object[] keysarray = null;
		try {
			count = invam.generalqueryformtanksview(Query);
			if (count.size() >= 1) {
				for (int i = 0; i < count.size(); i++) {
					List<Object> vlist = new ArrayList<Object>();
					map.putAll(count.get(i));
					if (i == 0) {
						keys = map.keySet();
						keysarray = keys.toArray();
					} else {

					}
					for (int j = 0; j < keysarray.length; j++) {
						vlist.add((Object) count.get(i).get(keysarray[j].toString()));
					}
					valueslist.add(vlist);

				}
				mav.addObject("keys", keys);
				mav.addObject("values", valueslist);
			} else {
				map.putAll(count.get(0));
				String delete = "DELETE";
				String updated = "UPDATE";
				String inserted = "INSERT";
				String altered = "ALTER";
				if (Query.toLowerCase().contains(delete.toLowerCase())) {
					message = map.keySet() + "rows Deleted Successfully";
				} else if (Query.toLowerCase().contains(updated.toLowerCase())) {
					message = map.keySet() + "rows Updated Successfully";
				} else if (Query.toLowerCase().contains(inserted.toLowerCase())) {
					message = map.keySet() + "rows inserted Successfully";
				} else if (Query.toLowerCase().contains(altered.toLowerCase())) {
					message = map.keySet() + "rows altered Successfully";

				}

				else {
					message = "Successfully updated";
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			message = "Couldn't Execute the Query, Please Try Again";
		}
		mav.setViewName("updatemisview");

		mav.addObject("resultset", count);
		mav.addObject("message", message);
		return mav;

	}
	



	
	
	@RequestMapping(value = "/invtsimis/stagetims")
	public ModelAndView generalqueryforstagetims(@RequestParam("Query") String Query, SessionStatus status,
			HttpSession session) {

		// System.out.println("Query "+Query);

		ModelAndView mav = new ModelAndView();
		List<Map<String, Object>> count = null;
		String message = null;
		Map<String, Object> map = new HashMap<String, Object>();
		Set<String> keys = null;
		List<String> keyslist = new ArrayList<String>();
		Set<String> values = null;
		List<List<Object>> valueslist = new ArrayList<List<Object>>();

		Object[] keysarray = null;
		try {
			count = invam.generalqueryforstagetims(Query);
			if (count.size() >= 1) {
				for (int i = 0; i < count.size(); i++) {
					List<Object> vlist = new ArrayList<Object>();
					map.putAll(count.get(i));
					if (i == 0) {
						keys = map.keySet();
						keysarray = keys.toArray();
					} else {

					}
					for (int j = 0; j < keysarray.length; j++) {
						vlist.add((Object) count.get(i).get(keysarray[j].toString()));
					}
					valueslist.add(vlist);

				}
				mav.addObject("keys", keys);
				mav.addObject("values", valueslist);
			} else {
				map.putAll(count.get(0));
				String delete = "DELETE";
				String updated = "UPDATE";
				String inserted = "INSERT";
				String altered = "ALTER";
				if (Query.toLowerCase().contains(delete.toLowerCase())) {
					message = map.keySet() + "rows Deleted Successfully";
				} else if (Query.toLowerCase().contains(updated.toLowerCase())) {
					message = map.keySet() + "rows Updated Successfully";
				} else if (Query.toLowerCase().contains(inserted.toLowerCase())) {
					message = map.keySet() + "rows inserted Successfully";
				} else if (Query.toLowerCase().contains(altered.toLowerCase())) {
					message = map.keySet() + "rows altered Successfully";

				}

				else {
					message = "Successfully updated";
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			message = "Couldn't Execute the Query, Please Try Again";
		}
		mav.setViewName("updatestagetims");

		mav.addObject("resultset", count);
		mav.addObject("message", message);
		return mav;

	}

	@RequestMapping(value = "/invtsimis/livestagetims")
	public ModelAndView stagetims() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("updatestagetims");
		return mav;

	}
	
	
	@RequestMapping(value = "/invtsimis/livestagehrms")
	public ModelAndView stagehrms() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("updatestagehrms");
		return mav;

	}
	
	
	@RequestMapping(value = "/invtsimis/stagehrms")
	public ModelAndView generalqueryforstagehrms(@RequestParam("Query") String Query, SessionStatus status,
			HttpSession session) {

		// System.out.println("Query "+Query);

		ModelAndView mav = new ModelAndView();
		List<Map<String, Object>> count = null;
		String message = null;
		Map<String, Object> map = new HashMap<String, Object>();
		Set<String> keys = null;
		List<String> keyslist = new ArrayList<String>();
		Set<String> values = null;
		List<List<Object>> valueslist = new ArrayList<List<Object>>();

		Object[] keysarray = null;
		try {
			count = invam.generalqueryforstagehrms(Query);
			if (count.size() >= 1) {
				for (int i = 0; i < count.size(); i++) {
					List<Object> vlist = new ArrayList<Object>();
					map.putAll(count.get(i));
					if (i == 0) {
						keys = map.keySet();
						keysarray = keys.toArray();
					} else {

					}
					for (int j = 0; j < keysarray.length; j++) {
						vlist.add((Object) count.get(i).get(keysarray[j].toString()));
					}
					valueslist.add(vlist);

				}
				mav.addObject("keys", keys);
				mav.addObject("values", valueslist);
			} else {
				map.putAll(count.get(0));
				String delete = "DELETE";
				String updated = "UPDATE";
				String inserted = "INSERT";
				String altered = "ALTER";
				if (Query.toLowerCase().contains(delete.toLowerCase())) {
					message = map.keySet() + "rows Deleted Successfully";
				} else if (Query.toLowerCase().contains(updated.toLowerCase())) {
					message = map.keySet() + "rows Updated Successfully";
				} else if (Query.toLowerCase().contains(inserted.toLowerCase())) {
					message = map.keySet() + "rows inserted Successfully";
				} else if (Query.toLowerCase().contains(altered.toLowerCase())) {
					message = map.keySet() + "rows altered Successfully";

				}

				else {
					message = "Successfully updated";
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			message = "Couldn't Execute the Query, Please Try Again";
		}
		mav.setViewName("updatestagehrms");

		mav.addObject("resultset", count);
		mav.addObject("message", message);
		return mav;

	}
	

	@RequestMapping(value = "/invtsimis/form20-menu-home")
	public ModelAndView projectsMenuHome() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("form20-menu-home");
		return mav;

	}
	
	
	
	

	@RequestMapping(value = "/invtsimis/left-menu-home")
	public ModelAndView leftMenuHome(@ModelAttribute("tankstatus") MiTankInspect miobj, HttpServletRequest request, HttpSession session,
			SessionStatus status) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("left-menu-home");
		//System.out.println("miobj"+miobj);
		List<MiTankInspect> miunitAbstract= new ArrayList<MiTankInspect>();
		List<MiTankInspect> miTankUnitdetail= new ArrayList<MiTankInspect>();
		List<MiTankInspect> mCapacityAbstract= new ArrayList<MiTankInspect>();
		List<MiTankInspect> selectTankYear= new ArrayList<MiTankInspect>();
		List<MiTankformData> selectFormYear = new ArrayList<MiTankformData>();
		Integer dbdesg=0;
		
		try {
			
			
				selectFormYear = irm.getForm20SelectYear();
				if(selectFormYear!=null){
	            mav.addObject("selectFormYear",selectFormYear);
	           // System.out.println("inac selectFormYear "+selectFormYear);
				}
			
				selectTankYear = irm.getmiTankSelectYear();
				if(selectTankYear!=null){
            mav.addObject("selectTankYear",selectTankYear);
           // System.out.println("inac selectTankYear "+selectTankYear);
			}
		if(miobj.getYear()!=null && miobj.getMiTankFreqId()!=null && miobj.getTankStatusId()==null ){
			if(miobj.getYear()>0  ){	
				if(miobj.getCircleId()==null){
					miobj.setCircleId(0);
				}
	                if(miobj.getDivisionId()==null){
					miobj.setDivisionId(0);
				}
	                if(miobj.getSubdivisionId()==null){
						miobj.setSubdivisionId(0);                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                         
					}
				/*System.out.println(miobj.getUnitId());
				System.out.println(miobj.getCircleId());
				System.out.println(miobj.getDivisionId());
			    System.out.println(miobj.getSubdivisionId());
				System.out.println(miobj.getDesignationId());
				System.out.println(miobj.getPostId());
				System.out.println(miobj.getTankStatusId());
				System.out.println("offaccess "+miobj.getOffAccess());
				
				System.out.println("userdesg "+miobj.getUserDesignationId());
				System.out.println("userunit "+miobj.getUserUnitId());
				System.out.println("usercircle "+miobj.getUserCircleId());
				System.out.println("userdivision "+miobj.getUserDivisionId());
				System.out.println("userSubdivision "+miobj.getUserSubdivisionId());
				System.out.println("backdesg "+miobj.getBackdesignationId());*/
	                
	                
				
					miunitAbstract = irm.getMiTankUnitAbstract(miobj);
					mCapacityAbstract = irm.getMiTankCapAyacutAbstract(miobj);
					
						if(miunitAbstract!=null || mCapacityAbstract!=null){
							mav.addObject("miunitAbstract",miunitAbstract);
							
							mav.addObject("contdesgId",miobj.getDesignationId());
							mav.addObject("contunitId",miobj.getUnitId());
							mav.addObject("contcircleId",miobj.getCircleId());
							mav.addObject("contdivisionId",miobj.getDivisionId());
							mav.addObject("contsubdivisionId",miobj.getSubdivisionId());
							mav.addObject("contfreqId",miobj.getMiTankFreqId());
							mav.addObject("contyear",miobj.getYear());
							mav.addObject("contpost",miobj.getPostId());
							mav.addObject("contOffAccess",miobj.getOffAccess());
							//capacity data
                                  mav.addObject("mCapacityAbstract",mCapacityAbstract);
							
							mav.addObject("capdesgId",miobj.getDesignationId());
							
						//	System.out.println("capdesgId"+miobj.getDesignationId());
							mav.addObject("capunitId",miobj.getUnitId());
							mav.addObject("capcircleId",miobj.getCircleId());
							mav.addObject("capdivisionId",miobj.getDivisionId());
							mav.addObject("capsubdivisionId",miobj.getSubdivisionId());
							mav.addObject("capfreqId",miobj.getMiTankFreqId());
							mav.addObject("capyear",miobj.getYear());
							mav.addObject("cappost",miobj.getPostId());
							mav.addObject("capOffAccess",miobj.getOffAccess());
							
							/*System.out.println("contdesgId" +miobj.getDesignationId());
							System.out.println("capunitId"+miobj.getUnitId());
							System.out.println("capcircleId"+miobj.getCircleId());
							System.out.println("capdivisionId"+miobj.getDivisionId());
						    System.out.println("capsubdivisionId"+miobj.getSubdivisionId());
						    System.out.println("capfreqId"+miobj.getMiTankFreqId());
						    System.out.println("capyear"+miobj.getYear());
							System.out.println("cappost"+miobj.getPostId());
							System.out.println("capOffAccess"+miobj.getOffAccess());*/
			
							if(miobj.getOffAccess()>=1 && miobj.getUserUnitId()!=null  && miobj.getUserDesignationId()!=null && miobj.getBackdesignationId()!=null ){
								
					//			System.out.println("after list"+miobj.getOffAccess());
						//	System.out.println("miobj.getDesignationId()"+miobj.getDesignationId());
					//			System.out.println("miobj.getUserDesignationId()"+miobj.getUserDesignationId());
								
								mav.addObject("socontbackdesgId",miobj.getBackdesignationId());
						//		System.out.println("miobj.getBackdesignationId()"+miobj.getBackdesignationId());
             if(miobj.getOffAccess()==1){
	if(miobj.getBackdesignationId()==5){
		if(miobj.getUserDesignationId()>=miobj.getBackdesignationId()){
			
	//		System.out.println("coming here5 office 1");
									
									mav.addObject("backdesgId",7);
									mav.addObject("backoffAccess",miobj.getOffAccess());
									mav.addObject("backunitId", miobj.getUnitId());
									mav.addObject("backcircleId",miobj.getCircleId());
									mav.addObject("backdivisionId",miobj.getDivisionId());
									mav.addObject("backsubdivisionId",0);
									mav.addObject("backpost",miobj.getPostId());
									mav.addObject("backmifreq",miobj.getMiTankFreqId());
									mav.addObject("backmiyear",miobj.getYear());
		                        }					
	                           }
	
	if(miobj.getBackdesignationId()==7){
		
		if(miobj.getUserDesignationId()>=miobj.getBackdesignationId()){
			
		//	System.out.println("coming here7 office 1");
		
		mav.addObject("backdesgId",9);
		mav.addObject("backoffAccess",miobj.getOffAccess());
		mav.addObject("backunitId", miobj.getUnitId());
		mav.addObject("backcircleId",miobj.getCircleId());
		mav.addObject("backdivisionId",0);
		mav.addObject("backsubdivisionId",miobj.getSubdivisionId());
		mav.addObject("backpost",miobj.getPostId());
		mav.addObject("backmifreq",miobj.getMiTankFreqId());
		mav.addObject("backmiyear",miobj.getYear());

		}	  
	}
	
if(miobj.getBackdesignationId()==9){
		
		if(miobj.getUserDesignationId()>=miobj.getBackdesignationId()){
			
		//	System.out.println("coming here9 office 1");
		
		mav.addObject("backdesgId",10);
		mav.addObject("backoffAccess",miobj.getOffAccess());
		mav.addObject("backunitId", miobj.getUnitId());
		mav.addObject("backcircleId",0);
		mav.addObject("backdivisionId",miobj.getDivisionId());
		mav.addObject("backsubdivisionId",miobj.getSubdivisionId());
		mav.addObject("backpost",miobj.getPostId());
		mav.addObject("backmifreq",miobj.getMiTankFreqId());
		mav.addObject("backmiyear",miobj.getYear());

		}	  
	}

if(miobj.getBackdesignationId()==10){
	
	if(miobj.getUserDesignationId()>=miobj.getBackdesignationId()){
		
	//	System.out.println("coming here10 office 1");
	
	mav.addObject("backoffAccess",miobj.getOffAccess());
	mav.addObject("backmifreq",miobj.getMiTankFreqId());
	mav.addObject("backmiyear",miobj.getYear());

	}	  
}
								}
								
								if(miobj.getOffAccess()==2){
									
									miobj.setUserDesignationId(9);
									
									if(miobj.getBackdesignationId()==5){
										
									//	System.out.println("cming here office acees 2 designation 5");
										
										if(miobj.getUserDesignationId()>=miobj.getBackdesignationId()){
											
											mav.addObject("backdesgId",7);
											mav.addObject("backoffAccess",miobj.getOffAccess());
											mav.addObject("backunitId", miobj.getUnitId());
											mav.addObject("backcircleId",miobj.getCircleId());
											mav.addObject("backdivisionId",miobj.getDivisionId());
											mav.addObject("backsubdivisionId",0);
											mav.addObject("backpost",miobj.getPostId());
											mav.addObject("backmifreq",miobj.getMiTankFreqId());
											mav.addObject("backmiyear",miobj.getYear());
										
										
										}
									}
									
									if(miobj.getBackdesignationId()==7){
										
									//	System.out.println("cming here office acees 2 designation 7");
										
										if(miobj.getUserDesignationId()>=miobj.getBackdesignationId()){
										
										mav.addObject("backdesgId",9);
										mav.addObject("backoffAccess",miobj.getOffAccess());
										mav.addObject("backunitId", miobj.getUnitId());
										mav.addObject("backcircleId",miobj.getCircleId());
										mav.addObject("backdivisionId",0);
										mav.addObject("backsubdivisionId",miobj.getSubdivisionId());
										mav.addObject("backpost",miobj.getPostId());
										mav.addObject("backmifreq",miobj.getMiTankFreqId());
										mav.addObject("backmiyear",miobj.getYear());
								 
										}
									}
                                    if(miobj.getBackdesignationId()==9){
                                    	
                                    //	System.out.println("cming here office acees 2 designation 9");
										
										if(miobj.getUserDesignationId()>=miobj.getBackdesignationId()){
										
										mav.addObject("backdesgId",10);
										mav.addObject("backoffAccess",miobj.getOffAccess());
										mav.addObject("backunitId", miobj.getUnitId());
										mav.addObject("backcircleId",0);
										mav.addObject("backdivisionId",miobj.getDivisionId());
										mav.addObject("backsubdivisionId",miobj.getSubdivisionId());
										mav.addObject("backpost",miobj.getPostId());
										mav.addObject("backmifreq",miobj.getMiTankFreqId());
										mav.addObject("backmiyear",miobj.getYear());
										}
									}
                                    
                                    if(miobj.getBackdesignationId()==10){
                                    	
                                    //	System.out.println("cming here office acees 2 designation 10");
										
										if(miobj.getUserDesignationId()>=miobj.getBackdesignationId()){
										mav.addObject("backoffAccess",miobj.getOffAccess());
										mav.addObject("backmifreq",miobj.getMiTankFreqId());
										mav.addObject("backmiyear",miobj.getYear());
								 
										}
									}
								}
								
								
								if(miobj.getOffAccess()==3){
									
									miobj.setUserDesignationId(10);
									
									if(miobj.getBackdesignationId()==5){
										
									//	System.out.println("cming here office acees 3 designation 5");
										
										if(miobj.getUserDesignationId()>=miobj.getBackdesignationId()){
										
										mav.addObject("backdesgId",7);
										mav.addObject("backoffAccess",miobj.getOffAccess());
										mav.addObject("backunitId", miobj.getUnitId());
										mav.addObject("backcircleId",miobj.getCircleId());
										mav.addObject("backdivisionId",miobj.getDivisionId());
										mav.addObject("backsubdivisionId",0);
										mav.addObject("backpost",miobj.getPostId());
										mav.addObject("backmifreq",miobj.getMiTankFreqId());
										mav.addObject("backmiyear",miobj.getYear());
										}
									
									}
								
                                     if(miobj.getBackdesignationId()==7){
                                    	 
                                    	//	System.out.println("cming here office acees 3 designation 7");
                                    	 
                                    	 if(miobj.getUserDesignationId()>=miobj.getBackdesignationId()){
									
									mav.addObject("backdesgId",9);
									mav.addObject("backoffAccess",miobj.getOffAccess());
									mav.addObject("backunitId", miobj.getUnitId());
									mav.addObject("backcircleId",miobj.getCircleId());
									mav.addObject("backdivisionId",0);
									mav.addObject("backsubdivisionId",miobj.getSubdivisionId());
									mav.addObject("backpost",miobj.getPostId());
									mav.addObject("backmifreq",miobj.getMiTankFreqId());
									mav.addObject("backmiyear",miobj.getYear());
                                    	 }
								}
                                      if(miobj.getBackdesignationId()==9){
                                    	  
                                    		//System.out.println("cming here office acees 3 designation 9");
                                    	 
                                    	 if(miobj.getUserDesignationId()>=miobj.getBackdesignationId()){
									
									mav.addObject("backdesgId",10);
									mav.addObject("backoffAccess",miobj.getOffAccess());
									mav.addObject("backunitId", miobj.getUnitId());
									mav.addObject("backcircleId",0);
									mav.addObject("backdivisionId",miobj.getDivisionId());
									mav.addObject("backsubdivisionId",miobj.getSubdivisionId());
									mav.addObject("backpost",miobj.getPostId());
									mav.addObject("backmifreq",miobj.getMiTankFreqId());
									mav.addObject("backmiyear",miobj.getYear());
                                    	 }
								
								}
                                      
                                      if(miobj.getBackdesignationId()==10){
                                    	  
                                    	//	System.out.println("cming here office acees 3 designation 10");
                                     	 
                                     	 if(miobj.getUserDesignationId()>=miobj.getBackdesignationId()){
 									
                                     		mav.addObject("backdesgId",10);
 									mav.addObject("backoffAccess",miobj.getOffAccess());
 								mav.addObject("backunitId", miobj.getUserUnitId());
 									
 									mav.addObject("backmifreq",miobj.getMiTankFreqId());
 									mav.addObject("backmiyear",miobj.getYear());
 									
                                     	 }
 								
 								}
                                     
								}
                                     
							} // office access not null
								
						}//mi tank inspect list not null
						
						}
						}
		
		if(miobj.getUnitId()!=null &&  miobj.getTankStatusId()!=null && miobj.getMiTankFreqId()!=null && miobj.getYear()!=null  && miobj.getReportType()==1 ){
			
			/*System.out.println("2nd list loop");
		System.out.println(miobj.getUnitId());
		System.out.println(miobj.getCircleId());
		System.out.println(miobj.getDivisionId());
			System.out.println(miobj.getSubdivisionId());
		System.out.println(miobj.getDesignationId());
		System.out.println(miobj.getPostId());
		System.out.println(miobj.getTankStatusId());
			System.out.println(miobj.getMiTankFreqId());
			System.out.println(miobj.getYear());*/
		
				miTankUnitdetail=   irm.getMiTankUnitAbstractDetail(miobj);
			
			/*System.out.println("miTankUnitdetail"+miTankUnitdetail);*/
			
			mav.addObject("miTankUnitdetail",miTankUnitdetail);
			
			mav.addObject("detailfreqId",miobj.getMiTankFreqId());
			mav.addObject("detailYear",miobj.getYear());
			
		}
		
		List<MiTankInspect> miTankcapayacutdetail= new ArrayList<MiTankInspect>();
	
		
		if(miobj.getUnitId()!=null &&  miobj.getTankStatusId()!=null && miobj.getMiTankFreqId()!=null && miobj.getYear()!=null &&  miobj.getReportType()==2 ){
			
			miTankcapayacutdetail=   irm.getMiTankCapAayacutDetail(miobj);
			
//			System.out.println("miTankcapayacutdetail "+miTankcapayacutdetail);
			
			//mav.addObject("miTankcapayacutdetail",miTankcapayacutdetail);
			
			//miTankAbstract2 = invam.getReservoirScheduleofDuties();
			
			//System.out.println("miTankAbstract2"+miTankAbstract2);
			
			mav.addObject("miTankcapayacutdetail",miTankcapayacutdetail);
			mav.addObject("capYear",miobj.getYear());
			mav.addObject("capFreqId",miobj.getMiTankFreqId());
			
			}
		} catch (InventoryUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
						
		return mav;

	}

	@RequestMapping(value = "/invtsimis/assignReservoir")
	public ModelAndView assignreservoir(SessionStatus status, HttpSession session) {
		ModelAndView mav = new ModelAndView();

		mav.setViewName("addReservoir");

		List<Unit> unitList = new ArrayList<Unit>();

		List<ReservoirSalient> resList = new ArrayList<ReservoirSalient>();

		try {
			unitList = lam.getUnitList();

			User user = (User) session.getAttribute("userObj");

			resList = invam.getResList();

		} catch (LeagalUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InventoryUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		mav.addObject("unitList", unitList);
		mav.addObject("resList", resList);

		return mav;

	}

	@RequestMapping(value = "/invtsimis/addReservoir")
	@ResponseBody
	public String addReservoir(ReservoirSalient ressalObj, HttpServletRequest request, HttpSession session,
			SessionStatus status) {
		ModelAndView mav = new ModelAndView();

		mav.setViewName("addReservoir");

		List<Unit> unitList = new ArrayList<Unit>();

		String output = null;

		try {
			unitList = lam.getUnitList();

			User user = (User) session.getAttribute("userObj");

			// System.out.println(ressalObj);

			if (user != null) {

				if (user.getUserId() != null && user.getUserName() != null) {

					ressalObj.setUserId(user.getUserId());
					ressalObj.setUserName(user.getUserName());

				}

				if (ressalObj != null) {
					if (ressalObj.getResName() != null && ressalObj.getResStatusId() > 0) {
						output = invam.inserReservoir(ressalObj);
					}
				}

			}

		} catch (LeagalUserException | InventoryUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		mav.addObject("unitList", unitList);
		return new Gson().toJson(output);

	}

	@RequestMapping(value = "/invtsimis/reslistbyId")
	@ResponseBody
	public String reslistbyId(String rescode, HttpServletRequest request, HttpSession session, SessionStatus status) {
		ModelAndView mav = new ModelAndView();

		mav.setViewName("addReservoir");

		// System.out.println("cont"+rescode);

		ReservoirSalient resListbyId = new ReservoirSalient();

		try {
			resListbyId = invam.getResListBYCode(rescode);

			// System.out.println("resListbyId"+resListbyId);

		} catch (InventoryUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new Gson().toJson(resListbyId);

	}

	@RequestMapping(value = "/invtsimis/submitReservoir")
	@ResponseBody
	public String submitReservoir(ReservoirUnitData resUnitData, HttpServletRequest request, HttpSession session,
			SessionStatus status) {
		ModelAndView mav = new ModelAndView();

		mav.setViewName("addReservoir");

		// System.out.println("resUnitData"+resUnitData);

		User user = (User) session.getAttribute("userObj");

		List<ReservoirUnitData> resunitlistbyId = new ArrayList<ReservoirUnitData>();

		Integer output = 0;

		try {

			if (user != null) {

				if (user.getUserId() != null && user.getUserName() != null) {

					resUnitData.setUserId(user.getUserId());
					resUnitData.setUserName(user.getUserName());

				}

				if (resUnitData != null) {

					if (resUnitData.getUnitId() != null && resUnitData.getProjectId() != null
							&& resUnitData.getReservoirId() != null) {
						if (resUnitData.getUnitId() > 0 && resUnitData.getProjectId() > 0) {
							output = invam.inserResUnitMap(resUnitData);

						}
					}
				}

				if (output >= 0) {

					if (resUnitData != null) {
						if (resUnitData.getUnitId() != null) {

							if (resUnitData.getUnitId() > 0) {

								// System.out.println("coming
								// here"+resUnitData.getUnitId());
								resunitlistbyId = invam.getResUnitMapListById(resUnitData.getUnitId());
							}

							// System.out.println("resunitlistbyId"+resunitlistbyId);

						}

					}

				}

				// System.out.println("output"+output);
			}

		} catch (InventoryUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new Gson().toJson(resunitlistbyId);

	}

	@RequestMapping(value = "/invtsimis/resunitlistbyId")
	@ResponseBody
	public String resunitlistbyId(Integer unitId, HttpServletRequest request, HttpSession session,
			SessionStatus status) {
		ModelAndView mav = new ModelAndView();

		mav.setViewName("addReservoir");

		// System.out.println("cont"+rescode);

		List<ReservoirUnitData> resunitlistbyId = new ArrayList<ReservoirUnitData>();

		try {

			if (unitId != null) {
				resunitlistbyId = invam.getResUnitMapListById(unitId);
			}

			// System.out.println("resListbyId"+resListbyId);

		} catch (InventoryUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new Gson().toJson(resunitlistbyId);

	}

	@RequestMapping(value = "/invtsimis/editResinfodata")
	@ResponseBody
	public String editResinfodata(ReservoirSalient raslObj, HttpServletRequest request, HttpSession session,
			SessionStatus status) {
		ModelAndView mav = new ModelAndView();

		Integer output = 0;

		String resCode = null;

		try {

			// System.out.println("i am in edit"+raslObj);
			User user = (User) session.getAttribute("userObj");

			if (user != null) {

				if (user.getUserId() != null && user.getUserName() != null) {

					raslObj.setUserId(user.getUserId());
					raslObj.setUserName(user.getUserName());

				}

				if (raslObj != null) {

					output = invam.editReservoirInfo(raslObj);

				}
			}

			// System.out.println("resListbyId"+resListbyId);
			if (output > 0) {

				resCode = raslObj.getResCode();

			}

		} catch (InventoryUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new Gson().toJson(resCode);

	}

	@RequestMapping(value = "/invtsimis/deleteResinfodata")
	@ResponseBody
	public String deleteResinfodata(ReservoirSalient raslObj, HttpServletRequest request, HttpSession session,
			SessionStatus status) {
		ModelAndView mav = new ModelAndView();

		Integer output = 0;

		try {

			User user = (User) session.getAttribute("userObj");

			if (user != null) {

				if (user.getUserId() != null && user.getUserName() != null) {

					raslObj.setUserId(user.getUserId());
					raslObj.setUserName(user.getUserName());

				}

				if (raslObj != null) {

					output = invam.deleteReservoirInfo(raslObj);

				}
			}

			// System.out.println("resListbyId"+resListbyId);

		} catch (InventoryUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new Gson().toJson(output);

	}

	@RequestMapping(value = "/invtsimis/getResUnitmapId")
	@ResponseBody
	public String getResUnitmapId(Integer resunitId, HttpServletRequest request, HttpSession session,
			SessionStatus status) {
		ModelAndView mav = new ModelAndView();

		Integer output = 0;

		String resCode = null;

		ReservoirUnitData resUnitmap = new ReservoirUnitData();

		try {

			if (resunitId != null) {

				resUnitmap = invam.getResUnitMapListByMapId(resunitId);

			}

			// System.out.println("resUnitmap"+resUnitmap);

		} catch (InventoryUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new Gson().toJson(resUnitmap);

	}

	@RequestMapping(value = "/invtsimis/editresunitmap")
	@ResponseBody
	public String editresunitmap(ReservoirUnitData raslObj, HttpServletRequest request, HttpSession session,
			SessionStatus status) {
		ModelAndView mav = new ModelAndView();

		Integer output = 0;

		List<ReservoirUnitData> resunitlistbyId = new ArrayList<ReservoirUnitData>();

		try {

			User user = (User) session.getAttribute("userObj");

			if (user != null) {

				if (user.getUserId() != null && user.getUserName() != null) {

					raslObj.setUserId(user.getUserId());
					raslObj.setUserName(user.getUserName());

				}

				if (raslObj != null) {

					output = invam.UpdateResUnitMapById(raslObj);

				}
			}

			// System.out.println("output"+output);

			if (output >= 0) {

				if (raslObj != null) {
					if (raslObj.getUnitId() != null) {

						if (raslObj.getUnitId() > 0) {

							// System.out.println("coming
							// here"+resUnitData.getUnitId());
							resunitlistbyId = invam.getResUnitMapListById(raslObj.getUnitId());
						}

						// System.out.println("resunitlistbyId"+resunitlistbyId);

					}

				}

			}

		} catch (InventoryUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new Gson().toJson(resunitlistbyId);

	}

	@RequestMapping(value = "/invtsimis/deleteresunitmap")
	@ResponseBody
	public String deleteresunitmap(ReservoirUnitData raslObj, HttpServletRequest request, HttpSession session,
			SessionStatus status) {
		ModelAndView mav = new ModelAndView();

		Integer output = 0;

		try {

			User user = (User) session.getAttribute("userObj");

			if (user != null) {

				if (user.getUserId() != null && user.getUserName() != null) {

					raslObj.setUserId(user.getUserId());
					raslObj.setUserName(user.getUserName());

				}

				if (raslObj != null) {

					output = invam.DeleteResUnitMapById(raslObj);

				}
			}

			// System.out.println("resListbyId"+resListbyId);

		} catch (InventoryUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new Gson().toJson(output);

	}

	@RequestMapping(value = "/invtsimis/resUnitListByResCode")
	@ResponseBody
	public String resUnitListByResCode(String resCode, HttpServletRequest request, HttpSession session,
			SessionStatus status) {
		ModelAndView mav = new ModelAndView();

		List<ReservoirUnitData> resunitlistbycode = new ArrayList<ReservoirUnitData>();

		try {

			if (resCode != null) {
				resunitlistbycode = invam.getResUnitMapListByResCode(resCode);
			}

			// System.out.println("resListbyId"+resListbyId);

		} catch (InventoryUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new Gson().toJson(resunitlistbycode);

	}

	@RequestMapping(value = "/invtsimis/addgatesinfo")
	@ResponseBody
	public String addgatesinfo(ReservoirGates raslObj, HttpServletRequest request, HttpSession session,
			SessionStatus status) {
		ModelAndView mav = new ModelAndView();

		String resCode = null;

		Integer gateId = 0;
		// System.out.println("gates"+raslObj);

		try {

			User user = (User) session.getAttribute("userObj");

			if (user != null) {

				if (user.getUserId() != null && user.getUserName() != null) {

					raslObj.setUserId(user.getUserId());
					raslObj.setUserName(user.getUserName());

				}

				if (raslObj != null) {

					gateId = invam.insertResGates(raslObj);

				}
			}
			if (gateId != null) {

				if (gateId > 0) {

					resCode = raslObj.getGatereservoirId();

				}
			}

			// System.out.println("resListbyId"+resListbyId);

		} catch (InventoryUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new Gson().toJson(resCode);

	}

	@RequestMapping(value = "/invtsimis/resRegList")
	@ResponseBody
	public String resRegList(String resCode, HttpServletRequest request, HttpSession session, SessionStatus status) {

		List<ReservoirGates> regList = new ArrayList<ReservoirGates>();

		try {

			if (resCode != null) {
				regList = invam.getResRegList(resCode);
			}

			// System.out.println("resListbyId"+resListbyId);

		} catch (InventoryUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new Gson().toJson(regList);

	}

	@RequestMapping(value = "/invtsimis/addresAyacut")
	@ResponseBody
	public String addresAyacut(ReservoirAyacut raslObj, HttpServletRequest request, HttpSession session,
			SessionStatus status) {

		Integer output = 0;

		// System.out.println("ayacut"+raslObj);

		String resCode = null;

		try {

			User user = (User) session.getAttribute("userObj");

			if (user != null) {

				if (user.getUserId() != null && user.getUserName() != null) {

					raslObj.setUserId(user.getUserId());
					raslObj.setUserName(user.getUserName());

				}

				if (raslObj != null) {

					output = invam.insertInvAyacutByResReg(raslObj);

				}
			}

			if (output > 0) {

				resCode = raslObj.getAyacutreservoirId();

				// System.out.println("resCode"+resCode);

			}

			// System.out.println("resListbyId"+resListbyId);

		} catch (InventoryUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new Gson().toJson(resCode);

	}

	@RequestMapping(value = "/invtsimis/addresReg")
	@ResponseBody
	public String addresReg(ReservoirGates raslObj, HttpServletRequest request, HttpSession session,
			SessionStatus status) {
		ModelAndView mav = new ModelAndView();

		Integer output = 0;

		String rgCode = null;
		// System.out.println("gates"+raslObj);

		try {

			User user = (User) session.getAttribute("userObj");

			if (user != null) {

				if (user.getUserId() != null && user.getUserName() != null) {

					raslObj.setUserId(user.getUserId());
					raslObj.setUserName(user.getUserName());

				}

				if (raslObj != null) {

					output = invam.insertResRegulator(raslObj);

				}
			}

			// System.out.println("output"+output);

		} catch (InventoryUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new Gson().toJson(output);

	}

	@RequestMapping(value = "/invtsimis/resRegbyRegCode")
	@ResponseBody
	public String resRegbyRegCode(String regCode, HttpServletRequest request, HttpSession session,
			SessionStatus status) {

		ReservoirGates regObj = new ReservoirGates();

		try {

			if (regCode != null) {
				regObj = invam.getResRegByRegCode(regCode);
			}

			// System.out.println("resListbyId"+resListbyId);

		} catch (InventoryUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new Gson().toJson(regObj);

	}

	@RequestMapping(value = "/invtsimis/resGateList")
	@ResponseBody
	public String resGateList(String resCode, HttpServletRequest request, HttpSession session, SessionStatus status) {

		List<ReservoirGates> gateList = new ArrayList<ReservoirGates>();

		try {

			if (resCode != null) {
				gateList = invam.getResGateList(resCode);
			}

			// System.out.println("resListbyId"+resListbyId);

		} catch (InventoryUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new Gson().toJson(gateList);

	}

	@RequestMapping(value = "/invtsimis/resregayacutList")
	@ResponseBody
	public String resregayacutList(String resCode, HttpServletRequest request, HttpSession session,
			SessionStatus status) {

		List<ReservoirAyacut> regayacutList = new ArrayList<ReservoirAyacut>();

		try {

			if (resCode != null) {
				regayacutList = invam.getResRegAyacutList(resCode);
			}

			// System.out.println("resListbyId"+resListbyId);

		} catch (InventoryUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new Gson().toJson(regayacutList);

	}

	@RequestMapping(value = "/invtsimis/getResAyacutbyId")
	@ResponseBody
	public String getResAyacutbyId(Integer regayacutId, HttpServletRequest request, HttpSession session,
			SessionStatus status) {

		ReservoirAyacut regObj = new ReservoirAyacut();

		try {

			if (regayacutId != null) {

				if (regayacutId > 0) {
					regObj = invam.getResAyacutById(regayacutId);
				}
			}

			// System.out.println("resListbyId"+resListbyId);

		} catch (InventoryUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new Gson().toJson(regObj);

	}

	@RequestMapping(value = "/invtsimis/getResGatebyId")
	@ResponseBody
	public String getResGatebyId(Integer reggateId, HttpServletRequest request, HttpSession session,
			SessionStatus status) {

		ReservoirGates regObj = new ReservoirGates();

		try {

			if (reggateId != null) {

				if (reggateId > 0) {
					regObj = invam.getResGateByGateId(reggateId);
				}
			}

			// System.out.println("resListbyId"+resListbyId);

		} catch (InventoryUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new Gson().toJson(regObj);

	}

	@RequestMapping(value = "/invtsimis/updateResGatebyId")
	@ResponseBody
	public String updateResGatebyId(ReservoirGates resGateObj, HttpServletRequest request, HttpSession session,
			SessionStatus status) {

		String rescode = null;

		Integer output = 0;

		List<ReservoirGates> resgateList = new ArrayList<ReservoirGates>();

		try {

			User user = (User) session.getAttribute("userObj");

			if (user != null) {

				if (user.getUserId() != null && user.getUserName() != null) {

					resGateObj.setUserId(user.getUserId());
					resGateObj.setUserName(user.getUserName());

				}

				if (resGateObj != null) {

					if (resGateObj.getReservoirGateId() != null) {

						output = invam.UpdateResGateById(resGateObj);
					}

				}
			}

			// System.out.println("output"+output);

			if (output >= 0) {

				if (resGateObj != null) {
					if (resGateObj.getGatereservoirId() != null) {

						// System.out.println("coming
						// here"+resUnitData.getUnitId());
						// resgateList=invam.getResGateList(resGateObj.getGatereservoirId());

						rescode = resGateObj.getGatereservoirId();

						// System.out.println("resunitlistbyId"+resunitlistbyId);

					}

				}

			}

		} catch (InventoryUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new Gson().toJson(rescode);

	}

	@RequestMapping(value = "/invtsimis/deleteResGatebyId")
	@ResponseBody
	public String deleteResGatebyId(ReservoirGates resGateObj, HttpServletRequest request, HttpSession session,
			SessionStatus status) {

		Integer output = 0;

		try {

			User user = (User) session.getAttribute("userObj");

			if (user != null) {

				if (user.getUserId() != null && user.getUserName() != null) {

					resGateObj.setUserId(user.getUserId());
					resGateObj.setUserName(user.getUserName());

				}

				if (resGateObj != null) {

					if (resGateObj.getReservoirGateId() != null) {

						output = invam.DeleteResGateById(resGateObj);
					}

				}
			}

			// System.out.println("resListbyId"+resListbyId);

		} catch (InventoryUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new Gson().toJson(output);
	}

	@RequestMapping(value = "/invtsimis/updateResAyacutbyId")
	@ResponseBody
	public String updateResAyacutbyId(ReservoirAyacut resayacutObj, HttpServletRequest request, HttpSession session,
			SessionStatus status) {

		// System.out.println("ayacutupdate"+resayacutObj);

		Integer output = 0;

		String resCode = null;

		List<ReservoirAyacut> resayacutById = new ArrayList<ReservoirAyacut>();

		try {

			User user = (User) session.getAttribute("userObj");

			if (user != null) {

				if (user.getUserId() != null && user.getUserName() != null) {

					resayacutObj.setUserId(user.getUserId());
					resayacutObj.setUserName(user.getUserName());

				}

				if (resayacutObj != null) {

					if (resayacutObj.getResAyacutId() != null) {

						output = invam.UpdateResAyacutById(resayacutObj);
					}

				}
			}

			// System.out.println("output"+output);

			if (output >= 0) {

				if (resayacutObj != null) {
					if (resayacutObj.getAyacutreservoirId() != null) {

						resCode = resayacutObj.getAyacutreservoirId();

					}

				}

			}

		} catch (InventoryUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new Gson().toJson(resCode);

	}

	@RequestMapping(value = "/invtsimis/deleteResAyacutbyId")
	@ResponseBody
	public String deleteResAyacutbyId(ReservoirAyacut resayacutObj, HttpServletRequest request, HttpSession session,
			SessionStatus status) {

		Integer output = 0;

		try {

			User user = (User) session.getAttribute("userObj");

			if (user != null) {

				if (user.getUserId() != null && user.getUserName() != null) {

					resayacutObj.setUserId(user.getUserId());
					resayacutObj.setUserName(user.getUserName());

				}

				if (resayacutObj != null) {

					if (resayacutObj.getResAyacutId() != null) {
						output = invam.DeleteResAyacutById(resayacutObj);
					}

				}
			}

			// System.out.println("resListbyId"+resListbyId);

		} catch (InventoryUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new Gson().toJson(output);

	}

	@RequestMapping(value = "/invtsimis/omlift-input")
	public ModelAndView omliftinput() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("omlift-input");
		List<PumpOperationType> potList = new ArrayList<PumpOperationType>();

		List<PumpOperationType> potList1 = new ArrayList<PumpOperationType>();

		List<PumpOperationType> potList2 = new ArrayList<PumpOperationType>();

		List<PumpOperationInstructions> pumpoperationinst = new ArrayList<PumpOperationInstructions>();

		// List<PumpOperationType> potList3 =new ArrayList<PumpOperationType>();

		try {
			potList = invam.getPumpOperationTypes();

			pumpoperationinst = invam.getPumpOperationInstructions();

			for (int i = 0; i < potList.size(); i++) {

				if (potList.get(i).getPumpOPerationParentId() == 0) {

					potList1.add(potList.get(i));
				}

				if (potList.get(i).getPumpOPerationParentId() > 0) {

					potList2.add(potList.get(i));
				}

			}
		} catch (InventoryUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// System.out.println("potList1"+potList1);
		// System.out.println("potList2"+potList2);
		mav.addObject("potList", potList);
		mav.addObject("potList1", potList1);
		mav.addObject("potList2", potList2);

		mav.addObject("pumpoperationinst", pumpoperationinst);

		return mav;

	}

	@RequestMapping(value = "/invtsimis/omcanal-input")
	public ModelAndView omcanalinput() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("omcanal-input");
		return mav;

	}

	@RequestMapping(value = "/invtsimis/omreservoir-input")
	public ModelAndView omreservoirinput() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("omreservoir-input");
		return mav;

	}

	@RequestMapping(value = "/invtsimis/ommitank-input")
	public ModelAndView ommitankinput(@ModelAttribute("micheckList") MiTankInspect mitankObj,
			HttpServletRequest request, HttpSession session) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("mitank-checks");

		List<MitankChecks> micheks = new ArrayList<MitankChecks>();
		List<MitankComps> micomps = new ArrayList<MitankComps>();
		List<MitankComps> micompsparent = new ArrayList<MitankComps>();
		List<MitankComps> micompschild = new ArrayList<MitankComps>();

		

		List<MitankChecks> micheks1 = new ArrayList<MitankChecks>();
		List<MitankChecks> micheks2 = new ArrayList<MitankChecks>();
		List<MitankChecks> micheks3 = new ArrayList<MitankChecks>();
		

		List<EmpApprove> getempapprove = new ArrayList<EmpApprove>();
	
		
		List<Tanks> tankjurisList = new ArrayList<Tanks>();
		
		List<Tanks> tanksList = new ArrayList<Tanks>();
		List<Tanks> anicutList = new ArrayList<Tanks>();
		List<Tanks> checkDamList = new ArrayList<Tanks>();
		
		List<MiTankformData> frmsrcList= new ArrayList<MiTankformData>();

		
		
		List<Unit> unitList = new ArrayList<Unit>();
		
		List<District> tankDistrict = new ArrayList<District>();
		
		User user = (User) session.getAttribute("userObj");
		
		

		try {
			micheks = invam.getMitankChecks();
			micomps = invam.getMiTankComps();
			
			frmsrcList=invam.getFrmIrrSrcList();
			
			//unitList=        lam.getUnitList();
			
		//	 System.out.println("tankjurlist");
			if (user != null) {
				if(user.getUnitId()!=null){
			if(user.getUnitId()>0){
				// System.out.println("tankjurlistmain");
				tankjurisList= invam.getTankSectionMap(user);
				
				if(tankjurisList!=null){
					
					if(tankjurisList.size()>0){
					
					for(int i=0; i<tankjurisList.size(); i++){
						
						if(tankjurisList.get(i).getSourceId()==2){
							
							anicutList.add(tankjurisList.get(i));
							
						}
						
                          if(tankjurisList.get(i).getSourceId()==5){
							
                        	  checkDamList.add(tankjurisList.get(i));
							
						}
                          
                          if((tankjurisList.get(i).getSourceId()==0)||
                        		  (tankjurisList.get(i).getSourceId()==1) ||
                              	(tankjurisList.get(i).getSourceId()==3)|| 
                              	(tankjurisList.get(i).getSourceId()==4) ||
                              	(tankjurisList.get(i).getSourceId()==6) ||
                              	(tankjurisList.get(i).getSourceId()==7) ||
                              	(tankjurisList.get(i).getSourceId()==8) || 
                              	(tankjurisList.get(i).getSourceId()==9) ||
                              	(tankjurisList.get(i).getSourceId()==10)||
                              	(tankjurisList.get(i).getSourceId()==11)){
  							
                        	  tanksList.add(tankjurisList.get(i));
							
						}
						
						
					}
					}
				}
			}
				}
			}
		
			// System.out.println("empapprove");
			if (user != null) {
				
				EmpApprove empObj= new EmpApprove();
				
				
				empObj.setDesignationId(user.getDesignationId());	
				if(user.getUnitId()!=null){
				empObj.setUnitId(user.getUnitId());
				}
				if(user.getCircleId()!=null){
				empObj.setCircleId(user.getCircleId());
				}
				if(user.getDivisionId()!=null){
				empObj.setDivisionId(user.getDivisionId());
				}
				if(user.getSubdivisionId()!=null){
				empObj.setSubdivisionId(user.getSubdivisionId());
				}
				if(user.getSectionId()!=null){
				empObj.setSectionId(user.getSectionId());
				}
				if(empObj!=null){
				getempapprove = invam.getEmployeeApprove(empObj);
				}
				
	

				mav.addObject("getempapprove", getempapprove);
				
				
					
	
		
			}
			
			
	/*		if(tankjurisList!=null){

  Integer olddistrict=0;
  Integer newdistrict=0;
  
  
		  for (int i=0; i<tankjurisList.size(); i++){
			  
			  if(olddistrict!=tankjurisList.get(i).getNewDistrictId()){
				  
				  newdistrict=tankjurisList.get(i).getNewDistrictId();
		  
			  
			  for (int j=0 ; j< districts.size(); j++){
				  
				 
			  if(newdistrict==districts.get(j).getDistrictId()){
				  
				  System.out.println("distid"+districts.get(j).getDistrictId());
				  
				  tankDistrict.add(districts.get(j));
				  
				
			  }
			  
			
			  
				  }
			  
			  
			  }
			  
			  olddistrict=tankjurisList.get(i).getNewDistrictId();
		  }
			
			}*/
			// System.out.println("micomps");
			for (int i = 0; i < micomps.size(); i++) {
				if (micomps.get(i).getMiparentId() == 0) {

					micompsparent.add(micomps.get(i));

				}

				if (micomps.get(i).getMiparentId() > 0) {

					micompschild.add(micomps.get(i));

				}

			}

			// System.out.println("michecks");
			for (int i = 0; i < micheks.size(); i++) {

				if (micheks.get(i).getMiCompId() == 2 || micheks.get(i).getMiCompId() == 3
						|| micheks.get(i).getMiCompId() == 4) {

					micheks1.add(micheks.get(i));
				}

				if (micheks.get(i).getMiCompId() == 5) {

					micheks2.add(micheks.get(i));
				}

				if (micheks.get(i).getMiCompId() == 7) {

					micheks3.add(micheks.get(i));
				}

			}

			mav.addObject("districtList", tankDistrict);
			
			mav.addObject("tankjurisList", tankjurisList);
			
			mav.addObject("anicutList", anicutList);
			mav.addObject("tanksList", tanksList);
			mav.addObject("checkDamList", checkDamList);
			
			//System.out.println("frmsrcList"+frmsrcList.size());

			// System.out.println("micompsparent");
			// System.out.println("micompschild"+micompschild);

		} catch (InventoryUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

		mav.addObject("micompsparent", micompsparent);
		mav.addObject("micompschild", micompschild);
		mav.addObject("michecks", micheks);
		mav.addObject("michecks1", micheks1);
		mav.addObject("michecks2", micheks2);
		mav.addObject("michecks3", micheks3);
		
		mav.addObject("frmsrcList",frmsrcList);

		mav.addObject("userObj", user);
		
		//mav.addObject("unitList",unitList);

		return mav;

	}

	@RequestMapping(value = "/invtsimis/omlift-log1")
	public ModelAndView omliftlog1() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("omlift-log1");

		List<PumpCommonData> pcdListTotal = new ArrayList<PumpCommonData>();
		List<PumpCommonData> pcdList1 = new ArrayList<PumpCommonData>();
		List<PumpCommonData> pcdList2 = new ArrayList<PumpCommonData>();
		List<PumpCommonData> pcdList3 = new ArrayList<PumpCommonData>();
		List<PumpPumpsData> ppdListTotal = new ArrayList<PumpPumpsData>();
		List<PumpPumpsData> ppdList1 = new ArrayList<PumpPumpsData>();
		List<PumpPumpsData> ppdList2 = new ArrayList<PumpPumpsData>();
		List<PumpPumpsData> ppdList3 = new ArrayList<PumpPumpsData>();
		List<PumpPumpsData> ppdList4 = new ArrayList<PumpPumpsData>();

		try {
			pcdListTotal = invam.getPumpsCommonList();
			ppdListTotal = invam.getPumpsdataList();

			if (pcdListTotal != null) {
				if (pcdListTotal.size() > 0) {

					for (int j = 0; j < pcdListTotal.size(); j++) {

						if (pcdListTotal.get(j).getPumpCommonDataItemType() == 1) {

							pcdList1.add(pcdListTotal.get(j));
						}
						if (pcdListTotal.get(j).getPumpCommonDataItemType() == 2) {

							pcdList2.add(pcdListTotal.get(j));
						}
						if (pcdListTotal.get(j).getPumpCommonDataItemType() == 3) {

							pcdList3.add(pcdListTotal.get(j));
						}

					}
				}

			}

			if (ppdListTotal != null) {
				if (ppdListTotal.size() > 0) {

					for (int i = 0; i < ppdListTotal.size(); i++) {

						if (ppdListTotal.get(i).getPumpDataItemType() == 1) {

							ppdList1.add(ppdListTotal.get(i));
						}
						if (ppdListTotal.get(i).getPumpDataItemType() == 2) {

							ppdList2.add(ppdListTotal.get(i));
						}
						if (ppdListTotal.get(i).getPumpDataItemType() == 3) {

							ppdList3.add(ppdListTotal.get(i));
						}
						if (ppdListTotal.get(i).getPumpDataItemType() == 4) {

							ppdList4.add(ppdListTotal.get(i));
						}

					}
				}

			}

			mav.addObject("pcdList", pcdListTotal);
			mav.addObject("ppdList", ppdListTotal);

			mav.addObject("ppdList1", ppdList1);
			mav.addObject("ppdList2", ppdList2);
			mav.addObject("ppdList3", ppdList3);
			mav.addObject("ppdList4", ppdList4);

			mav.addObject("pcdList1", pcdList1);
			mav.addObject("pcdList2", pcdList2);
			mav.addObject("pcdList3", pcdList3);

		} catch (InventoryUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return mav;

	}

	@RequestMapping(value = "/invtsimis/omlift-maintain")
	public ModelAndView omliftmaintain() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("omlift-maintain");

		List<PumpMaintainActivities> pmActivity = new ArrayList<PumpMaintainActivities>();
		List<PumpMaintainActivities> pmActivityDaily = new ArrayList<PumpMaintainActivities>();
		List<PumpMaintainActivities> pmActivityWeekly = new ArrayList<PumpMaintainActivities>();
		List<PumpMaintainActivities> pmActivityMonthly = new ArrayList<PumpMaintainActivities>();
		List<PumpMaintainActivities> pmActivityYearly = new ArrayList<PumpMaintainActivities>();

		List<PumpStations> basinList = new ArrayList<PumpStations>();

		try {
			pmActivity = invam.getPumpMaintainActivities();

			basinList = invam.getBasinData();

			if (pmActivity != null) {
				if (pmActivity.size() > 0) {

					for (int i = 0; i < pmActivity.size(); i++) {

						if (pmActivity.get(i).getActivityFreqId() == 1) {
							pmActivityDaily.add(pmActivity.get(i));

						}
						if (pmActivity.get(i).getActivityFreqId() == 2) {
							pmActivityWeekly.add(pmActivity.get(i));

						}
						if (pmActivity.get(i).getActivityFreqId() == 3) {
							pmActivityMonthly.add(pmActivity.get(i));

						}
						if (pmActivity.get(i).getActivityFreqId() == 6) {
							pmActivityYearly.add(pmActivity.get(i));

						}

					}
				}
			}

		} catch (InventoryUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		mav.addObject("pmad", pmActivityDaily);
		mav.addObject("pmaw", pmActivityWeekly);
		mav.addObject("pmam", pmActivityMonthly);
		mav.addObject("pmay", pmActivityYearly);

		mav.addObject("basinList", basinList);

		return mav;

	}

	@RequestMapping(value = "/invtsimis/getPumpLinks")
	@ResponseBody
	public String getPumpLinks(Integer basinId, HttpServletRequest request, HttpSession session, SessionStatus status) {

		List<PumpStations> pumpLinks = new ArrayList<PumpStations>();

		List<PumpStations> pumpLinksList = new ArrayList<PumpStations>();

		try {
			pumpLinks = invam.getPumpLinks();
			// System.out.println("basinId"+basinId);

			if (basinId != null) {

				// System.out.println("basinId"+basinId);

				if (basinId > 0) {

					// System.out.println("basinId"+basinId);
					if (pumpLinks != null) {

						for (int i = 0; i < pumpLinks.size(); i++) {

							if (pumpLinks.get(i).getBasinId() == basinId) {

								pumpLinksList.add(pumpLinks.get(i));
							}

						}

					}
				}
			}

			// System.out.println("resListbyId"+resListbyId);

		} catch (InventoryUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new Gson().toJson(pumpLinksList);

	}

	@RequestMapping(value = "/invtsimis/getPumpStation")
	@ResponseBody
	public String getPumpStation(Integer pumpLinkId, HttpServletRequest request, HttpSession session,
			SessionStatus status) {

		List<PumpStations> pumpStation = new ArrayList<PumpStations>();

		// List<PumpStations> pumpStationList= new ArrayList<PumpStations>();

		try {

			if (pumpLinkId != null) {
				if (pumpLinkId > 0) {
					pumpStation = invam.getPumpStations(pumpLinkId);
				}

			}

			// System.out.println("resListbyId"+resListbyId);

		} catch (InventoryUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new Gson().toJson(pumpStation);

	}

	@RequestMapping(value = "/invtsimis/res-schedule-duties")
	public ModelAndView resscheduleduties() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("res-schedule-duties");

		List<ScheduleDuty> scheduleDutyList = new ArrayList<ScheduleDuty>();
		List<ScheduleDuty> scheduleDutyDailyAee = new ArrayList<ScheduleDuty>();

		List<ScheduleDuty> scheduleDutyWeeklyAee = new ArrayList<ScheduleDuty>();

		List<ScheduleDuty> scheduleDutyWeeklychildAee = new ArrayList<ScheduleDuty>();
		List<ScheduleDuty> scheduleDutyDailyAe = new ArrayList<ScheduleDuty>();
		List<ScheduleDuty> scheduleDutyWeeklyAe = new ArrayList<ScheduleDuty>();
		List<ScheduleDuty> scheduleDutyMonDee = new ArrayList<ScheduleDuty>();
		List<ScheduleDuty> scheduleDutyQuarterDee = new ArrayList<ScheduleDuty>();
		List<ScheduleDuty> scheduleDutyHalfYearDee = new ArrayList<ScheduleDuty>();
		List<ScheduleDuty> scheduleDutyAnnualDee = new ArrayList<ScheduleDuty>();
		List<ScheduleDuty> scheduleDutyFiveYearDee = new ArrayList<ScheduleDuty>();
		List<ScheduleDuty> scheduleDutyMonthlyEE = new ArrayList<ScheduleDuty>();
		List<ScheduleDuty> scheduleDutyQuarterlyEE = new ArrayList<ScheduleDuty>();
		List<ScheduleDuty> scheduleDutyMonSoonEE = new ArrayList<ScheduleDuty>();
		List<ScheduleDuty> scheduleDutyFiveYearSE = new ArrayList<ScheduleDuty>();

		List<Unit> unitList = new ArrayList<Unit>();

		try {
			scheduleDutyList = invam.getReservoirScheduleofDuties();
			unitList = lam.getUnitList();

			for (int i = 0; i < scheduleDutyList.size(); i++) {

				if (scheduleDutyList.get(i).getDesignationId() == 2
						&& scheduleDutyList.get(i).getDutyFrequencyId() == 1) {

					scheduleDutyDailyAee.add(scheduleDutyList.get(i));

				}

				if (scheduleDutyList.get(i).getDesignationId() == 2
						&& scheduleDutyList.get(i).getDutyFrequencyId() == 2) {

					scheduleDutyWeeklyAee.add(scheduleDutyList.get(i));

					if (scheduleDutyList.get(i).getParentDutyId() > 0
							&& scheduleDutyList.get(i).getParentHasChild() == false) {

						scheduleDutyWeeklychildAee.add(scheduleDutyList.get(i));
					}

				}

				if (scheduleDutyList.get(i).getDesignationId() == 8
						&& scheduleDutyList.get(i).getDutyFrequencyId() == 1) {

					scheduleDutyDailyAe.add(scheduleDutyList.get(i));

				}

				if (scheduleDutyList.get(i).getDesignationId() == 8
						&& scheduleDutyList.get(i).getDutyFrequencyId() == 2) {

					scheduleDutyWeeklyAe.add(scheduleDutyList.get(i));

				}

				if (scheduleDutyList.get(i).getDesignationId() == 4
						&& scheduleDutyList.get(i).getDutyFrequencyId() == 3) {

					scheduleDutyMonDee.add(scheduleDutyList.get(i));

				}

				if (scheduleDutyList.get(i).getDesignationId() == 4
						&& scheduleDutyList.get(i).getDutyFrequencyId() == 4) {

					scheduleDutyQuarterDee.add(scheduleDutyList.get(i));

				}

				if (scheduleDutyList.get(i).getDesignationId() == 4
						&& scheduleDutyList.get(i).getDutyFrequencyId() == 5) {

					scheduleDutyHalfYearDee.add(scheduleDutyList.get(i));

				}

				if (scheduleDutyList.get(i).getDesignationId() == 4
						&& scheduleDutyList.get(i).getDutyFrequencyId() == 6) {

					scheduleDutyAnnualDee.add(scheduleDutyList.get(i));

				}

				if (scheduleDutyList.get(i).getDesignationId() == 4
						&& scheduleDutyList.get(i).getDutyFrequencyId() == 7) {

					scheduleDutyFiveYearDee.add(scheduleDutyList.get(i));

				}

				if (scheduleDutyList.get(i).getDesignationId() == 5
						&& scheduleDutyList.get(i).getDutyFrequencyId() == 3) {

					scheduleDutyMonthlyEE.add(scheduleDutyList.get(i));

				}
				if (scheduleDutyList.get(i).getDesignationId() == 5
						&& scheduleDutyList.get(i).getDutyFrequencyId() == 4) {

					scheduleDutyQuarterlyEE.add(scheduleDutyList.get(i));

				}

				if (scheduleDutyList.get(i).getDesignationId() == 5
						&& scheduleDutyList.get(i).getDutyFrequencyId() == 8) {

					scheduleDutyMonSoonEE.add(scheduleDutyList.get(i));

				}

				if (scheduleDutyList.get(i).getDesignationId() == 7
						&& scheduleDutyList.get(i).getDutyFrequencyId() == 7) {

					scheduleDutyFiveYearSE.add(scheduleDutyList.get(i));

				}

			}

			mav.addObject("scheduleDutyDailyAee", scheduleDutyDailyAee);
			mav.addObject("scheduleDutyWeeklyAee", scheduleDutyWeeklyAee);
			mav.addObject("scheduleDutyDailyAe", scheduleDutyDailyAe);
			mav.addObject("scheduleDutyWeeklyAe", scheduleDutyWeeklyAe);
			mav.addObject("scheduleDutyMonDee", scheduleDutyMonDee);
			mav.addObject("scheduleDutyQuarterDee", scheduleDutyQuarterDee);
			mav.addObject("scheduleDutyHalfYearDee", scheduleDutyHalfYearDee);
			mav.addObject("scheduleDutyAnnualDee", scheduleDutyAnnualDee);
			mav.addObject("scheduleDutyFiveYearDee", scheduleDutyFiveYearDee);

			mav.addObject("scheduleDutyMonthlyEE", scheduleDutyMonthlyEE);
			mav.addObject("scheduleDutyQuarterlyEE", scheduleDutyQuarterlyEE);
			mav.addObject("scheduleDutyFiveYearSE", scheduleDutyFiveYearSE);

			mav.addObject("scheduleDutyMonSoonEE", scheduleDutyMonSoonEE);
			mav.addObject("unitList", unitList);

		} catch (InventoryUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (LeagalUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mav;

	}

	@RequestMapping(value = "/invtsimis/addMichecks")
	@ResponseBody
	public String addMichecks(@ModelAttribute("micheckList") MiTankInspect mitankObj, HttpServletRequest request,
			HttpSession session, SessionStatus status) {
		ModelAndView mav = new ModelAndView();

//		 System.out.println("mitankObjcomehere"+mitankObj);

		mav.setViewName("mitank-checks");

		List<MiTankInspect> MiTankdaoimplObj = new ArrayList<MiTankInspect>();

		List<MiTankInspect> oldmiinspectlist = new ArrayList<MiTankInspect>();

		Integer output = 0;

		Integer mst1output = 0;
		
		Integer repairId=0;
		Integer capacityId=0;
		Integer inoutId=0;
		Integer feedId=0;

		MstOutputWithFlag mstouputcont = new MstOutputWithFlag();

		try {
			// unitList = lam.getUnitList();

			User user = (User) session.getAttribute("userObj");

			if (mitankObj.getMiTankInspectList() != null) {
		//		 System.out.println("mitankObj"+mitankObj.getMiTankInspectList().size());
		//		 System.out.println("mitankObj.getMiTankInspectList()"+mitankObj.getMiTankInspectList().size());
				if (user != null) {

					if (user.getEmpId() != null || user.getUserName() != null) {

						// System.out.println("user.getUserId()"+user.getUserEmpId()+"user.getUserName()"+user.getUserName());
						mitankObj.getMiTankInspectList().get(0).setEmpId(user.getEmpId());

						mitankObj.getMiTankInspectList().get(0).setUserName(user.getUserName());

					}

					if (user.getUserId() != null) {
						mitankObj.getMiTankInspectList().get(0).setUserId(user.getUserId());

					} else {
						mitankObj.getMiTankInspectList().get(0).setUserId(0);

					}

					if (mitankObj.getMiTankInspectList().size() > 0) {

						if (mitankObj.getMiTankInspectList().get(0).getTabId()==1
								|| mitankObj.getMiTankInspectList().get(0).getTabId()==2
								|| mitankObj.getMiTankInspectList().get(0).getTabId()==3) {

							int len = mitankObj.getMiTankInspectList().size();

							if (mitankObj.getMiTankInspectList() != null) {

								for (int i = 1; i < len; i++) {
									if (mitankObj.getMiTankInspectList().get(i).getMicheckboxId() != null) {
										if (mitankObj.getMiTankInspectList().get(i).getMicheckboxId() == 1) {
											// System.out.println("mitankObj.getMiTankInspectList().get(i).getMicheckboxId()"+"..."+i+"..."+mitankObj.getMiTankInspectList().get(i).getMicheckboxId());

											if (mitankObj.getMiTankInspectList().get(0).getTankId() != null && mitankObj
													.getMiTankInspectList().get(0).getMiTankFreqId() != null) {

												MiTankInspect mi = new MiTankInspect(); // System.out.println("coming
																						// here");

												mi.setNewDistrictId(
														mitankObj.getMiTankInspectList().get(0).getNewDistrictId());
												mi.setMandalId(mitankObj.getMiTankInspectList().get(0).getMandalId());
												mi.setVillageId(mitankObj.getMiTankInspectList().get(0).getVillageId());
												
												
													mi.setMiTankFreqId(mitankObj.getMiTankInspectList().get(0).getMiTankFreqId());
													
												
												
												mi.setYear(mitankObj.getMiTankInspectList().get(0).getYear());
												mi.setTankId(mitankObj.getMiTankInspectList().get(0).getTankId());

												mi.setUnitId(mitankObj.getMiTankInspectList().get(0).getUnitId());
												mi.setCircleId(mitankObj.getMiTankInspectList().get(0).getCircleId());
												mi.setDivisionId(
														mitankObj.getMiTankInspectList().get(0).getDivisionId());
												mi.setSubdivisionId(
														mitankObj.getMiTankInspectList().get(0).getSubdivisionId());
												mi.setSectionId(mitankObj.getMiTankInspectList().get(0).getSectionId());
												mi.setProjectId(mitankObj.getMiTankInspectList().get(0).getProjectId());
												mi.setConstId(mitankObj.getMiTankInspectList().get(0).getConstId());
												mi.setUserId(mitankObj.getMiTankInspectList().get(0).getUserId());
												mi.setUserName(mitankObj.getMiTankInspectList().get(0).getUserName());
												

												mi.setActionreq(mitankObj.getMiTankInspectList().get(i).getActionreq());
												if(mitankObj.getMiTankInspectList().get(i).getActionrequireqId()!=null){
												mi.setActionrequireqId(
														mitankObj.getMiTankInspectList().get(i).getActionrequireqId());
												}
												if(mitankObj.getMiTankInspectList().get(i).getActionrequireqId()==null){
													mi.setActionrequireqId(	0);
													}
												if(mitankObj.getMiTankInspectList().get(i).getInspectDate()==null){
													
													mi.setInspectDate("0");
												}
												
												if(mitankObj.getMiTankInspectList().get(i).getInspectDate()!=null){
													
													mi.setInspectDate(
															mitankObj.getMiTankInspectList().get(i).getInspectDate());
													
												}
												
												mi.setMicheckboxId(
														mitankObj.getMiTankInspectList().get(i).getMicheckboxId());
												mi.setMiCompId(mitankObj.getMiTankInspectList().get(i).getMiCompId());
												mi.setMiInspectMapId(
														mitankObj.getMiTankInspectList().get(i).getMiInspectMapId());
												mi.setMiInspectTypeId(
														mitankObj.getMiTankInspectList().get(i).getMiInspectTypeId());
												mi.setRemarks(mitankObj.getMiTankInspectList().get(i).getRemarks());
												mi.setYear(mitankObj.getMiTankInspectList().get(0).getYear());
												mi.setTankWeirSluiceId(
														mitankObj.getMiTankInspectList().get(0).getTankWeirSluiceId());
												mi.setDesignationId(
														mitankObj.getMiTankInspectList().get(0).getDesignationId());
												//System.out.println("tabid"+mitankObj.getMiTankInspectList().get(0).getTabId());
												if (mitankObj.getMiTankInspectList().get(0).getTabId()==1){
													//System.out.println("getEmbRemarks"+mitankObj.getMiTankInspectList().get(0).getEmbRemarks());
												mi.setEmbRemarks(mitankObj.getMiTankInspectList().get(0).getEmbRemarks());
												}
												if (mitankObj.getMiTankInspectList().get(0).getTabId()==2){
													//System.out.println("getSluRemarks"+mitankObj.getMiTankInspectList().get(0).getSluRemarks());
												mi.setSluRemarks(mitankObj.getMiTankInspectList().get(0).getSluRemarks());
												}
												if (mitankObj.getMiTankInspectList().get(0).getTabId()==3){
													
													//System.out.println("getWeirRemarks"+mitankObj.getMiTankInspectList().get(0).getWeirRemarks());
												mi.setWeirRemarks(mitankObj.getMiTankInspectList().get(0).getWeirRemarks());
												}
												mi.setEmpId(mitankObj.getMiTankInspectList().get(0).getEmpId());
												mi.setPostId(mitankObj.getMiTankInspectList().get(0).getPostId());
												mi.setNextPostId(mitankObj.getMiTankInspectList().get(0).getNextPostId());
												mi.setNextEmpId(mitankObj.getMiTankInspectList().get(0).getNextEmpId());
											//	System.out.println("nextEmpId"+mitankObj.getMiTankInspectList().get(0).getNextEmpId());
												mi.setTankStatusId(mitankObj.getMiTankInspectList().get(0).getTankStatusId());
												mi.setTabId(mitankObj.getMiTankInspectList().get(0).getTabId());
												MiTankdaoimplObj.add(mi);

												// System.out.println(mi);
											}

										}
									}
								}
							}

							// System.out.println("MiTankdaoimplObj"+MiTankdaoimplObj.size());

							if (MiTankdaoimplObj != null) {

								if (MiTankdaoimplObj.size() > 0) {

									mstouputcont = invam.insertMiinspectMst1(MiTankdaoimplObj);

									// System.out.println("mst1output"+mst1output);;
									if (mstouputcont != null) {

										if (mstouputcont.getMstNewId() != null) {

											MiTankdaoimplObj.get(0).setMiInpsectMst1Id(mstouputcont.getMstNewId());
										}
										if (mstouputcont.getMstOldId() != null) {

											if (mstouputcont.getMstOldId() > 0) {

												MiTankdaoimplObj.get(0).setMiInpsectMst1Id(mstouputcont.getMstOldId());

												oldmiinspectlist = invam
														.getMimst2IdByMst1Id(mstouputcont.getMstOldId());

												MiTankdaoimplObj.remove(oldmiinspectlist);

												// System.out.println(MiTankdaoimplObj+"sizecoming"+MiTankdaoimplObj.size());
											}
										}
										
										if (MiTankdaoimplObj.get(0).getMiInpsectMst1Id()!=null) {

											//mstouputcont.getMstOldId() > 0 || mstouputcont.getMstNewId() > 0 System.out.println("cnt1"+MiTankdaoimplObj.get(0).getMiInpsectMst1Id());;
											
											
											if (MiTankdaoimplObj.get(0).getMiInpsectMst1Id() > 0) {
												// System.out.println("cnt2"+MiTankdaoimplObj.get(0).getMiInpsectMst1Id());

												output = invam.insertMiinspectMst2(MiTankdaoimplObj);

											}
											
	                                        if (MiTankdaoimplObj.get(0).getMiInpsectMst1Id() > 0) {
	                                        	
	                                        	mitankObj.getMiTankInspectList().get(0).setMiInpsectMst1Id(MiTankdaoimplObj.get(0).getMiInpsectMst1Id());
												
												invam.insertMiTankMst1Remarks(mitankObj.getMiTankInspectList().get(0));
											}

										}

									}

	

								}

							}
						}
						// start of tab4
						/*if (mitankObj.getMiTankInspectList().get(0).getTabId()==4) {

							// int len=mitankObj.getMiTankInspectList().size();

							// System.out.println("coming here");

							if (mitankObj.getMiTankInspectList() != null) {

								if (mitankObj.getMiTankInspectList().get(0).getTankId() != null) {

									MiTankInspect mi = new MiTankInspect();

									mi.setNewDistrictId(mitankObj.getMiTankInspectList().get(0).getNewDistrictId());
									mi.setMandalId(mitankObj.getMiTankInspectList().get(0).getMandalId());
									mi.setVillageId(mitankObj.getMiTankInspectList().get(0).getVillageId());
									mi.setMiTankFreqId(mitankObj.getMiTankInspectList().get(0).getMiTankFreqId());
									mi.setYear(mitankObj.getMiTankInspectList().get(0).getYear());
									mi.setTankId(mitankObj.getMiTankInspectList().get(0).getTankId());

									mi.setUnitId(mitankObj.getMiTankInspectList().get(0).getUnitId());
									mi.setCircleId(mitankObj.getMiTankInspectList().get(0).getCircleId());
									mi.setDivisionId(mitankObj.getMiTankInspectList().get(0).getDivisionId());
									mi.setSubdivisionId(mitankObj.getMiTankInspectList().get(0).getSubdivisionId());
									mi.setProjectId(mitankObj.getMiTankInspectList().get(0).getProjectId());
									mi.setConstId(mitankObj.getMiTankInspectList().get(0).getConstId());
									mi.setUserId(mitankObj.getMiTankInspectList().get(0).getUserId());
									mi.setUserName(mitankObj.getMiTankInspectList().get(0).getUserName());

									mi.setInspectDate(mitankObj.getMiTankInspectList().get(0).getInspectDate());
									mi.setInflow(mitankObj.getMiTankInspectList().get(0).getInflow());
									mi.setOutfow(mitankObj.getMiTankInspectList().get(0).getOutfow());
									mi.setAyacut(mitankObj.getMiTankInspectList().get(0).getAyacut());

									mi.setRemarks(mitankObj.getMiTankInspectList().get(0).getRemarks());

									mi.setDesignationId(mitankObj.getMiTankInspectList().get(0).getDesignationId());
									mi.setLevelId(mitankObj.getMiTankInspectList().get(0).getLevelId());
									
									MiTankdaoimplObj.add(mi);

									// System.out.println(mi);
								}

							}

							// System.out.println("MiTankdaoimplObj"+MiTankdaoimplObj.size());

							if (MiTankdaoimplObj != null) {

								if (MiTankdaoimplObj.size() > 0) {

									inoutId = invam.insertMiinspectInOut(MiTankdaoimplObj);
									
	                               if (inoutId != null) {

										
										if (inoutId > 0 ) {

											// System.out.println("cnt1"+MiTankdaoimplObj.get(0).getMiInpsectMst1Id());;
											
											mitankObj.getMiTankInspectList().get(0).setMitankInoutFlowId(inoutId);
										
	                                        if (mitankObj.getMiTankInspectList().get(0).getMitankInoutFlowId() > 0) {
	                                        	
	                                        	//
												
												output=invam.insertMiTankInOutFlowRemarks(mitankObj.getMiTankInspectList().get(0));
											}

										}

										

									}


								}

							}
						} // end of tab4
*/							// start of tab5
						if (mitankObj.getMiTankInspectList().get(0).getTabId()==5) {

							// int len=mitankObj.getMiTankInspectList().size();

							// System.out.println("coming here tab5");

							if (mitankObj.getMiTankInspectList() != null) {

								if (mitankObj.getMiTankInspectList().get(0).getTankId() != null) {

									MiTankInspect mi = new MiTankInspect();

									mi.setNewDistrictId(mitankObj.getMiTankInspectList().get(0).getNewDistrictId());
									mi.setMandalId(mitankObj.getMiTankInspectList().get(0).getMandalId());
									mi.setVillageId(mitankObj.getMiTankInspectList().get(0).getVillageId());
									mi.setMiTankFreqId(mitankObj.getMiTankInspectList().get(0).getMiTankFreqId());
									mi.setYear(mitankObj.getMiTankInspectList().get(0).getYear());
									mi.setTankId(mitankObj.getMiTankInspectList().get(0).getTankId());

									mi.setUnitId(mitankObj.getMiTankInspectList().get(0).getUnitId());
									mi.setCircleId(mitankObj.getMiTankInspectList().get(0).getCircleId());
									mi.setDivisionId(mitankObj.getMiTankInspectList().get(0).getDivisionId());
									mi.setSubdivisionId(mitankObj.getMiTankInspectList().get(0).getSubdivisionId());
									mi.setSectionId(mitankObj.getMiTankInspectList().get(0).getSectionId());
									mi.setProjectId(mitankObj.getMiTankInspectList().get(0).getProjectId());
									mi.setConstId(mitankObj.getMiTankInspectList().get(0).getConstId());
									mi.setUserId(mitankObj.getMiTankInspectList().get(0).getUserId());
									mi.setUserName(mitankObj.getMiTankInspectList().get(0).getUserName());

								//	mi.setInspectDate(mitankObj.getMiTankInspectList().get(0).getInspectDate());
									mi.setMiCompId(mitankObj.getMiTankInspectList().get(0).getMiCompId());
									mi.setRate(mitankObj.getMiTankInspectList().get(0).getRate());
									mi.setQuantity(mitankObj.getMiTankInspectList().get(0).getQuantity());
									mi.setUnitMeasureId(mitankObj.getMiTankInspectList().get(0).getUnitMeasureId());
								//	mi.setSchemeTaken(mitankObj.getMiTankInspectList().get(0).getSchemeTaken());

								//	mi.setRepairDescription(mitankObj.getMiTankInspectList().get(0).getRepairDescription());
									
									mi.setRepairdescId(mitankObj.getMiTankInspectList().get(0).getRepairdescId());

									mi.setRemarks(mitankObj.getMiTankInspectList().get(0).getRemarks());
									
									mi.setEmpId(mitankObj.getMiTankInspectList().get(0).getEmpId());
									mi.setPostId(mitankObj.getMiTankInspectList().get(0).getPostId());
									mi.setNextPostId(mitankObj.getMiTankInspectList().get(0).getNextPostId());
									mi.setNextEmpId(mitankObj.getMiTankInspectList().get(0).getNextEmpId());

									mi.setDesignationId(mitankObj.getMiTankInspectList().get(0).getDesignationId());
									mi.setLevelId(mitankObj.getMiTankInspectList().get(0).getLevelId());
									mi.setAmount(mitankObj.getMiTankInspectList().get(0).getAmount());
									MiTankdaoimplObj.add(mi);

									// System.out.println(mi);
								}

							}

							// System.out.println("MiTankdaoimplObj"+MiTankdaoimplObj.size());

							if (MiTankdaoimplObj != null) {

								if (MiTankdaoimplObj.size() > 0) {

									repairId = invam.insertMiinspectRepairs(MiTankdaoimplObj);
									
									
									if (repairId != null) {

										
										if (repairId > 0 ) {

											// System.out.println("cnt1"+MiTankdaoimplObj.get(0).getMiInpsectMst1Id());;
											
											mitankObj.getMiTankInspectList().get(0).setMitankRepairsId(repairId);
										
	                                        if (mitankObj.getMiTankInspectList().get(0).getMitankRepairsId() > 0) {
	                                        	
	                                        	//
												
												output=invam.insertMiTankRepairsRemarks(mitankObj.getMiTankInspectList().get(0));
											}

										}

										

									}

								}

							}
						} // end of tab5

						// start of tab6
						if (mitankObj.getMiTankInspectList().get(0).getTabId()==6) {

							// int len=mitankObj.getMiTankInspectList().size();

							// System.out.println("coming here tab6");

							if (mitankObj.getMiTankInspectList() != null) {

								if (mitankObj.getMiTankInspectList().get(0).getTankId() != null) {

									MiTankInspect mi = new MiTankInspect();

									mi.setNewDistrictId(mitankObj.getMiTankInspectList().get(0).getNewDistrictId());
									mi.setMandalId(mitankObj.getMiTankInspectList().get(0).getMandalId());
									mi.setVillageId(mitankObj.getMiTankInspectList().get(0).getVillageId());
									mi.setMiTankFreqId(mitankObj.getMiTankInspectList().get(0).getMiTankFreqId());
									mi.setYear(mitankObj.getMiTankInspectList().get(0).getYear());
									mi.setTankId(mitankObj.getMiTankInspectList().get(0).getTankId());

									mi.setUnitId(mitankObj.getMiTankInspectList().get(0).getUnitId());
									mi.setCircleId(mitankObj.getMiTankInspectList().get(0).getCircleId());
									mi.setDivisionId(mitankObj.getMiTankInspectList().get(0).getDivisionId());
									mi.setSubdivisionId(mitankObj.getMiTankInspectList().get(0).getSubdivisionId());
									mi.setSectionId(mitankObj.getMiTankInspectList().get(0).getSectionId());
									mi.setProjectId(mitankObj.getMiTankInspectList().get(0).getProjectId());
									mi.setConstId(mitankObj.getMiTankInspectList().get(0).getConstId());
									mi.setUserId(mitankObj.getMiTankInspectList().get(0).getUserId());
									mi.setUserName(mitankObj.getMiTankInspectList().get(0).getUserName());
									
									if(mitankObj.getMiTankInspectList().get(0).getInspectDate()==null){
										
										mi.setInspectDate("0");
									}
									
									if(mitankObj.getMiTankInspectList().get(0).getInspectDate()!=null){
										
										mi.setInspectDate(mitankObj.getMiTankInspectList().get(0).getInspectDate());
										
									}

								//	mi.setInspectDate(mitankObj.getMiTankInspectList().get(0).getInspectDate());
									mi.setGrossCapacity(mitankObj.getMiTankInspectList().get(0).getGrossCapacity());
									mi.setAvailableCapacity(
											mitankObj.getMiTankInspectList().get(0).getAvailableCapacity());
									mi.setSurplus(mitankObj.getMiTankInspectList().get(0).getSurplus());

									mi.setRemarks(mitankObj.getMiTankInspectList().get(0).getRemarks());

									mi.setDesignationId(mitankObj.getMiTankInspectList().get(0).getDesignationId());
									
									mi.setLevelId(mitankObj.getMiTankInspectList().get(0).getLevelId());
									
								
								
									
									
									mi.setInflow(mitankObj.getMiTankInspectList().get(0).getInflow());
									mi.setOutfow(mitankObj.getMiTankInspectList().get(0).getOutfow());
									mi.setAyacut(mitankObj.getMiTankInspectList().get(0).getAyacut());
									
									
									
	                                 if(mitankObj.getMiTankInspectList().get(0).getTankLevel()!=null){
										
									//	System.out.println("tank level not null");
										mi.setTankLevel(mitankObj.getMiTankInspectList().get(0).getTankLevel());
									
										
										
									}else {
										
									//	System.out.println("tank level not null");
										mi.setTankLevel(0.0);
										
									}
									
									mi.setEmpId(mitankObj.getMiTankInspectList().get(0).getEmpId());
									mi.setPostId(mitankObj.getMiTankInspectList().get(0).getPostId());
									mi.setNextPostId(mitankObj.getMiTankInspectList().get(0).getNextPostId());
									mi.setNextEmpId(mitankObj.getMiTankInspectList().get(0).getNextEmpId());
									
									
									MiTankdaoimplObj.add(mi);

									// System.out.println(mi);
								}

							}

							// System.out.println("MiTankdaoimplObj"+MiTankdaoimplObj.size());

							if (MiTankdaoimplObj != null) {

								if (MiTankdaoimplObj.size() > 0) {

									capacityId = invam.insertMiinspectCapacity(MiTankdaoimplObj);
									

									
									
									if (capacityId != null) {

										
										if (capacityId > 0 ) {

											// System.out.println("cnt1"+MiTankdaoimplObj.get(0).getMiInpsectMst1Id());;
											
											mitankObj.getMiTankInspectList().get(0).setMitankCapacityId(capacityId);
										
	                                        if (mitankObj.getMiTankInspectList().get(0).getMitankCapacityId() > 0) {
	                                        	
	                                        	//
												
												output=invam.insertMiTankCapacityRemarks(mitankObj.getMiTankInspectList().get(0));
											}

										}

										

									}

								}

							}
						} // end of tab6

						// start of tab7
						if (mitankObj.getMiTankInspectList().get(0).getTabId()==7) {

							int len = mitankObj.getMiTankInspectList().size();

						//	System.out.println("coming here tab7");

							if (mitankObj.getMiTankInspectList() != null) {

								if (mitankObj.getMiTankInspectList().get(0).getTankId() != null) {

									MiTankInspect mi = new MiTankInspect();

									mi.setNewDistrictId(mitankObj.getMiTankInspectList().get(0).getNewDistrictId());
									mi.setMandalId(mitankObj.getMiTankInspectList().get(0).getMandalId());
									mi.setVillageId(mitankObj.getMiTankInspectList().get(0).getVillageId());

									mi.setTankId(mitankObj.getMiTankInspectList().get(0).getTankId());

									mi.setUnitId(mitankObj.getMiTankInspectList().get(0).getUnitId());
									mi.setCircleId(mitankObj.getMiTankInspectList().get(0).getCircleId());
									mi.setDivisionId(mitankObj.getMiTankInspectList().get(0).getDivisionId());
									mi.setSubdivisionId(mitankObj.getMiTankInspectList().get(0).getSubdivisionId());
									mi.setSectionId(mitankObj.getMiTankInspectList().get(0).getSectionId());
									mi.setProjectId(mitankObj.getMiTankInspectList().get(0).getProjectId());
									mi.setConstId(mitankObj.getMiTankInspectList().get(0).getConstId());
									mi.setUserId(mitankObj.getMiTankInspectList().get(0).getUserId());
									mi.setUserName(mitankObj.getMiTankInspectList().get(0).getUserName());

									mi.setInspectDate(mitankObj.getMiTankInspectList().get(0).getInspectDate());

									mi.setDesignationId(mitankObj.getMiTankInspectList().get(0).getDesignationId());
									mi.setLevelId(mitankObj.getMiTankInspectList().get(0).getLevelId());

									mi.setCanFeed(mitankObj.getMiTankInspectList().get(0).getCanFeed());
									mi.setChainLinkId(mitankObj.getMiTankInspectList().get(0).getChainLinkId());
									mi.setSourceTypeId(mitankObj.getMiTankInspectList().get(0).getSourceTypeId());
									mi.setSourceCompTypeId(
											mitankObj.getMiTankInspectList().get(0).getSourceCompTypeId());
									mi.setSourceCompId(mitankObj.getMiTankInspectList().get(0).getSourceCompId());
									mi.setSourceDetails(mitankObj.getMiTankInspectList().get(0).getSourceDetails());
									mi.setOtLocationKm(mitankObj.getMiTankInspectList().get(0).getOtLocationKm());

									mi.setEmpId(mitankObj.getMiTankInspectList().get(0).getEmpId());
									
									mi.setPostId(mitankObj.getMiTankInspectList().get(0).getPostId());
									mi.setNextPostId(mitankObj.getMiTankInspectList().get(0).getNextPostId());
									mi.setNextEmpId(mitankObj.getMiTankInspectList().get(0).getNextEmpId());

									MiTankdaoimplObj.add(mi);

									// System.out.println(mi);
								}

							}

							// System.out.println("MiTankdaoimplObj"+MiTankdaoimplObj.size());

							if (MiTankdaoimplObj != null) {

								if (MiTankdaoimplObj.size() > 0) {

									feedId = invam.insertMiTankFeedDetails(MiTankdaoimplObj);
									
									
                               if (feedId != null) {

										
										if (feedId > 0 ) {

											// System.out.println("cnt1"+MiTankdaoimplObj.get(0).getMiInpsectMst1Id());;
											
											mitankObj.getMiTankInspectList().get(0).setMitankFeedDetailsId(feedId);
										
	                                        if (mitankObj.getMiTankInspectList().get(0).getMitankFeedDetailsId() > 0) {
	                                        	
	                                        	//
												
												output=invam.insertMiTankFeedRemarks(mitankObj.getMiTankInspectList().get(0));
											}

										}

										

									}

								}

							}
						} // end of tab7

					}

				}

			}

		} catch (InventoryUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// mav.addObject("unitList", unitList);

		return new Gson().toJson(output);

	}
	
	//private static final String RELATIVE_DIR = "/uploadedFiles/FormDocs/";
	
	private static final String FILE_DIRECTORY = "/app/tomcat8/webapps/tsimis/uploadedFiles/FormDocs/";
	private static final String RELATIVE_DIR = "/uploadedFiles/FormDocs/";
	
	
	@RequestMapping(value = "/invtsimis/addFormData")
	@ResponseBody
	public String addFormData(@ModelAttribute("miTankformDataList") MiTankformData miFormObj, HttpServletRequest request,
			HttpSession session, SessionStatus status) {
		ModelAndView mav = new ModelAndView();
		
		Integer output=0;
		
		String[] saveFileName = null;

		List<String> fileNameList = new ArrayList<String>();
		
		
		List<MiTankformData> MiformdaoimplObj = new ArrayList<MiTankformData>();
		MstOutputWithFlag mstouputcont = new MstOutputWithFlag();
		
		List<MiTankFormDocs> frmdocList = new ArrayList<MiTankFormDocs>();
		
		Boolean captOutput = false;
		
		
		
		try {
			
			User user = (User) session.getAttribute("userObj");
			String captcha = (String) session.getAttribute("CAPTCHA");
			
			//System.out.println("miFormObj.getMiTankformDataList().get(0).getCaptcha()"+miFormObj.getMiTankformDataList().get(0).getCaptcha());
			//System.out.println("captcha"+captcha);
			//System.out.println("captOutput1"+captOutput);
			
			
			if (miFormObj.getMiTankformDataList().get(0).getCaptcha() == null || miFormObj.getMiTankformDataList().get(0).getCaptcha() == null) {
				output=-3 ;
			}else if ((miFormObj.getMiTankformDataList().get(0).getCaptcha() != null && captcha != null)){
				
				if ((miFormObj.getMiTankformDataList().get(0).getCaptcha() != null && !miFormObj.getMiTankformDataList().get(0).getCaptcha().equals(captcha))) {
					// System.out.println("coming here"+canalObj.getCaptcha());
				
					miFormObj.getMiTankformDataList().get(0).setCaptcha("");
				
					captOutput = false;
					output=-2;

				}else if (miFormObj.getMiTankformDataList().get(0).getCaptcha().equals(captcha)) {

					captOutput = true;

				}
				
				
				
			}
			
		//	System.out.println("captOutput2"+captOutput);
			//System.out.println("output"+output);
			
			
			
			if (captOutput == true) {
			if (miFormObj.getMiTankformDataList() != null) {
			
				
				if (user != null) {

					if (user.getEmpId() != null || user.getUserName() != null) {

						// System.out.println("user.getUserId()"+user.getUserEmpId()+"user.getUserName()"+user.getUserName());
						miFormObj.getMiTankformDataList().get(0).setEmpId(Long.parseLong(user.getEmpId().toString()));

						miFormObj.getMiTankformDataList().get(0).setUserName(user.getUserName());

					}
					
					
					if (miFormObj.getMiTankformDataList().size() > 0) {

						if (miFormObj.getMiTankformDataList().get(0).getTabId()==1 ) {

							int len = miFormObj.getMiTankformDataList().size();

							if (miFormObj.getMiTankformDataList() != null) {

								for (int i = 0; i < len-1 ; i++) {
									
									
									

											if (miFormObj.getMiTankformDataList().get(0).getTankId() != null && miFormObj.getMiTankformDataList().get(0).getResId()!=null  && miFormObj.getMiTankformDataList().get(0).getCanId()!=null && miFormObj.getMiTankformDataList().get(0).getCatId()!=null ) {

												MiTankformData mi = new MiTankformData();
												
												if(miFormObj.getMiTankformDataList().get(0).getDesignationId()==2|| miFormObj.getMiTankformDataList().get(0).getDesignationId()==8){
													
													mi.setApprv_status(0);
													
													
												}else if (miFormObj.getMiTankformDataList().get(0).getDesignationId()==4){
													
													
													mi.setApprv_status(1);
													
												}else if (miFormObj.getMiTankformDataList().get(0).getDesignationId()==5){
													
													mi.setApprv_status(2);
													
												}else if (miFormObj.getMiTankformDataList().get(0).getDesignationId()==7){
													
													mi.setApprv_status(3);
													
												}else if (miFormObj.getMiTankformDataList().get(0).getDesignationId()==9){
													
													mi.setApprv_status(4);
													
												}else {
													
													mi.setApprv_status(0);
												}
											
											 
												mi.setTankId(miFormObj.getMiTankformDataList().get(0).getTankId());
												
												mi.setProjectId(miFormObj.getMiTankformDataList().get(0).getProjectId());
												
												mi.setResId(miFormObj.getMiTankformDataList().get(0).getResId());
												mi.setCanId(miFormObj.getMiTankformDataList().get(0).getCanId());
												mi.setCatId(miFormObj.getMiTankformDataList().get(0).getCatId());
												mi.setTabId(miFormObj.getMiTankformDataList().get(0).getTabId());
												mi.setUnitId(miFormObj.getMiTankformDataList().get(0).getUnitId());
												mi.setCircleId(miFormObj.getMiTankformDataList().get(0).getCircleId());
												mi.setDivisionId(miFormObj.getMiTankformDataList().get(0).getDivisionId());
												mi.setSubDivisionId(miFormObj.getMiTankformDataList().get(0).getSubDivisionId());
												mi.setSectionId(miFormObj.getMiTankformDataList().get(0).getSectionId());
												mi.setDesignationId(miFormObj.getMiTankformDataList().get(0).getDesignationId());
												mi.setSectionId(miFormObj.getMiTankformDataList().get(0).getSectionId());
												
												mi.setUserName(miFormObj.getMiTankformDataList().get(0).getUserName());
												
												mi.setPostId(miFormObj.getMiTankformDataList().get(0).getPostId());
												mi.setNextPostId(miFormObj.getMiTankformDataList().get(0).getNextPostId());
												
												
												mi.setEmpId(miFormObj.getMiTankformDataList().get(0).getEmpId());
												
												mi.setNextEmpId(miFormObj.getMiTankformDataList().get(0).getNextEmpId());
												
												mi.setDamageType(miFormObj.getMiTankformDataList().get(0).getDamageType());
												
												//mi.setIrrStrDmaPort(miFormObj.getMiTankformDataList().get(0).getIrrStrDmaPort());
												
												mi.setDamageCause(miFormObj.getMiTankformDataList().get(0).getDamageCause());

												mi.setDamageDate(miFormObj.getMiTankformDataList().get(0).getDamageDate());
												mi.setDamageTime(miFormObj.getMiTankformDataList().get(0).getDamageTime());
												mi.setFrmProposed(miFormObj.getMiTankformDataList().get(0).getFrmProposed());
												mi.setWriteOffValue(miFormObj.getMiTankformDataList().get(0).getWriteOffValue());
												mi.setWriteOffAction(miFormObj.getMiTankformDataList().get(0).getWriteOffAction());
												mi.setRegLeftChnnAcres(miFormObj.getMiTankformDataList().get(0).getRegLeftChnnAcres());
												mi.setRegRightChnnAcres(miFormObj.getMiTankformDataList().get(0).getRegRightChnnAcres());
												mi.setRegOthAcres(miFormObj.getMiTankformDataList().get(0).getRegOthAcres());
												mi.setRainRGStation(miFormObj.getMiTankformDataList().get(0).getRainRGStation());
												mi.setRainQty(miFormObj.getMiTankformDataList().get(0).getRainQty());
												mi.setRainDate(miFormObj.getMiTankformDataList().get(0).getRainDate());
												mi.setQuartName(miFormObj.getMiTankformDataList().get(0).getQuartName());
												mi.setQuartType(miFormObj.getMiTankformDataList().get(0).getQuartType());
												mi.setBldgTypeName(miFormObj.getMiTankformDataList().get(0).getBldgTypeName());
												
												mi.setCanalLocId(miFormObj.getMiTankformDataList().get(0).getCanalLocId());
												
												//list of details
												
                                        
												mi.setIrrSrcId(miFormObj.getMiTankformDataList().get(i).getIrrSrcId());
												
												mi.setIrrChFrm(miFormObj.getMiTankformDataList().get(i).getIrrChFrm());
												mi.setIrrChTo(miFormObj.getMiTankformDataList().get(i).getIrrChTo());
												mi.setIrrL(miFormObj.getMiTankformDataList().get(i).getIrrL());
												mi.setIrrB(miFormObj.getMiTankformDataList().get(i).getIrrB());
												mi.setIrrD(miFormObj.getMiTankformDataList().get(i).getIrrD());
												mi.setIrrPermcost(miFormObj.getMiTankformDataList().get(i).getIrrPermcost());
												mi.setIrrTempcost(miFormObj.getMiTankformDataList().get(i).getIrrTempcost());
											
												
												
												mi.setApproxRepPermanent(miFormObj.getMiTankformDataList().get(0).getApproxRepPermanent());
												
												mi.setApproxRepTemp(miFormObj.getMiTankformDataList().get(0).getApproxRepTemp());
												
												mi.setFrmBookValue(miFormObj.getMiTankformDataList().get(0).getFrmBookValue());
												mi.setEffAyacutAcres(miFormObj.getMiTankformDataList().get(0).getEffAyacutAcres());
												mi.setEffAyacutValue(miFormObj.getMiTankformDataList().get(0).getEffAyacutValue());
												mi.setActionStdCrops(miFormObj.getMiTankformDataList().get(0).getActionStdCrops());
												mi.setDamageBreaches(miFormObj.getMiTankformDataList().get(0).getDamageBreaches());
												mi.setUsefulRemarks(miFormObj.getMiTankformDataList().get(0).getUsefulRemarks());
												
												mi.setTsfcFormDate(miFormObj.getMiTankformDataList().get(0).getTsfcFormDate());
												
											//	System.out.println("i"+i);
											//	System.out.println("miFormObj.getMiTankformDataList().get(i).getIrrPermcost()"+miFormObj.getMiTankformDataList().get(i).getIrrPermcost());
											//	System.out.println("miFormObj.getMiTankformDataList().get(i).getIrrTempcost()"+miFormObj.getMiTankformDataList().get(i).getIrrTempcost());
											
												 if(miFormObj.getMiTankformDataList().get(i).getIrrPermcost()>0.0 ||  miFormObj.getMiTankformDataList().get(i).getIrrTempcost()>0.0){
												MiformdaoimplObj.add(mi);
												
												
												 }
												

												// System.out.println(mi);
											}

										}
								
								
								// System.out.println("size list"+MiformdaoimplObj.size());
									}
							
							        //start form insert
							       
							if (MiformdaoimplObj != null) {

								if (MiformdaoimplObj.size() > 0) {

									
										mstouputcont = invam.insertForm20Data(MiformdaoimplObj);
										
										output=mstouputcont.getFormdataId();
										
										
										if (mstouputcont.getFormdataId() != null) {
											if(mstouputcont.getFormdataId()>0){

												MiformdaoimplObj.get(0).setFormDataId(mstouputcont.getFormdataId());
												
												miFormObj.setFormDataId(mstouputcont.getFormdataId());
											}
										}
										if (mstouputcont.getOldformdataId() != null) {

											if (mstouputcont.getOldformdataId() > 0) {
												
												//System.out.println("mstouputcont.getOldformdataId()"+mstouputcont.getOldformdataId());
												
												//miFormObj.setFormDataId(mstouputcont.getOldformdataId());

												//MiformdaoimplObj.get(0).setFormDataId(mstouputcont.getOldformdataId());
												
												miFormObj.setFormDataId(0);
												MiformdaoimplObj.get(0).setFormDataId(0);

											
											}
										}
										
										
										
										if(MiformdaoimplObj.get(0).getFormDataId()!=null){
											
										
											if(MiformdaoimplObj.get(0).getFormDataId()>0){
					                              	
												
												invam.insertForm20Detail(MiformdaoimplObj);
												
												invam.insertForm20approv(MiformdaoimplObj);
											}
											}
										
								}
							}
							        //end 
							
							       //start of photos
							
							//System.out.println("coming here photos");

							if(miFormObj.getFormDataId()!=null){
								
								
								if(miFormObj.getFormDataId()>0){
									
								//	System.out.println("phtosmiFormObj.getFormDataId()"+miFormObj.getFormDataId());
									
									//System.out.println("coming here"+miFormObj.getMiTankformDataList().get(0).getUploadPhotos());	
									
							if(miFormObj.getMiTankformDataList().get(0).getUploadPhotos()!=null){
								
								
								
								if(miFormObj.getMiTankformDataList().get(0).getUploadPhotos().size()>0){
									
									//System.out.println("coming here"+miFormObj.getMiTankformDataList().get(0).getUploadPhotos().size());
									miFormObj.setFormDataId(MiformdaoimplObj.get(0).getFormDataId());
									
									List<MultipartFile> files = miFormObj.getMiTankformDataList().get(0).getUploadPhotos();
									List<String> fileNames = new ArrayList<String>();
									
									List<MiTankFormDocs> fileList = new ArrayList<MiTankFormDocs>();
									String filetitile = null;
									String filetitilenew = null;
									
									if (null != files && files.size() >= 1) {
										
										for (MultipartFile multipartFile : files) {

											String fileName = multipartFile.getOriginalFilename();
											String FileType = (files).get(0).getContentType();
											fileNames.add(fileName);
											// Handle file content -
											// multipartFile.getInputStream()

										}
										
										//System.out.println("2nd file size"+fileNames.size());
										
										for (int i = 0; i < fileNames.size(); i++) {
											filetitile = fileNames.get(i);

											// System.out.println("filetitile"+filetitile);

											if (!filetitile.isEmpty()) {
												Integer maxId = invam.getCountOfform20Docs() + 1;
												// System.out.println("maxId"+maxId);
												 
												 Integer  doccnt=maxId;

												String[] temps = filetitile.split(Pattern.quote("."));

												Integer dataIdNum = MiformdaoimplObj.get(0).getFormDataId();
												
												doccnt=doccnt+i;
												
												// System.out.println("doccnt"+doccnt);

												String docName = temps[0];
												String SaveName = dataIdNum.toString() + doccnt.toString() + docName + "."
														+ temps[temps.length - 1];

											
												fileNameList.add(SaveName);

												// System.out.println("saveFileName"+fileNameList.get(i));

												/*
												 * if (i==0){
												 * filetitilenew=filetitile; }
												 * 
												 * if(i>0){
												 * 
												 * filetitilenew=filetitile+"@"+
												 * filetitilenew;
												 * 
												 * }
												 */
												// System.out.println("filetitilenew"+filetitilenew);

											}
										}
										
										   String absolutePath = servletContext.getRealPath(RELATIVE_DIR);
										
										//String rootPath = System.getProperty("catalina.base");
										
										//live
										   
										   if (absolutePath == null) {
											    // fallback if getRealPath returns null (some servlet containers do this)
											    absolutePath = new File(".").getCanonicalPath() + RELATIVE_DIR;
											}

										
										  File dir = new File(absolutePath);
										
										//File dir = new File(File.separator + "Uploads" + File.separator + "tsimis" + File.separator + "uploadedFiles"
											//	+ File.separator + "FormDocs");
										
										
									//	File dir = new File(rootPath + File.separator + "webapps" + File.separator + "tsimis" + File.separator + "uploadedFiles"
											//	+ File.separator + "FormDocs");
										
										/*File dir = new File(rootPath + File.separator + "webapps" + File.separator
												+ "PMSWebApp"+File.separator + "tsimis" + File.separator + "uploadedFiles"
												+ File.separator + "FormDocs");*/
										//local
										/*File dir = new File(rootPath + File.separator + "webapps" + File.separator
												+ "ICADLeagalWebApp"+File.separator + "uploadedFiles"
												+ File.separator + "FormDocs");*/
										
										if (!dir.exists())
											dir.mkdirs();
										
										for (int i = 0; i < files.size(); i++) {

											// File serverFile = new
											// File(dir.getAbsolutePath()+
											// File.separator +
											// files.get(i).getOriginalFilename());
											if (!fileNameList.isEmpty()) {

												if (fileNameList.size() > 0) {

													String frmDocName = fileNameList.get(i);
													MiTankFormDocs tf = new MiTankFormDocs();

													tf.setFormDocName(frmDocName);
													tf.setFormDocOriginalName(files.get(i).getOriginalFilename());
													tf.setFormDocLocation(
															dir.getAbsolutePath() + File.separator + frmDocName);

													// System.out.println("serverFile"+frmDocName);
													fileList.add(tf);

												   //   String targetPath=dir.getAbsolutePath()+ File.separator + frmDocName ;
														
												      
												     // int scaledWidth = 1024;
											        //    int scaledHeight = 768;
											         //   MultipartFile newFile=files.get(i);
											         //   ResizeImage.resize(newFile, targetPath, scaledWidth, scaledHeight);
												      files.get(i).transferTo( new File(dir.getAbsolutePath() + File.separator + frmDocName));
													

												}

											}
										}
										
										if (fileList.size() > 0) {
											
										//	System.out.println("fileList"+fileList);
											miFormObj.setPhotosList(fileList);
											

										}
										
										 invam.insertFormDocuments(miFormObj);
										
										//System.out.println("output"+output);

									
									}
									
									
								}
								
							}
							
								}
							}
							
							      //end of photos
								}
							}
							
						}
						
			}
			

			
		
		
		
		
			}
			
		
		} catch (InventoryUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return new Gson().toJson(output);
	}
	
	
	
	
	
	@RequestMapping(value = "/invtsimis/editFormData")
	@ResponseBody
	public String editFormData(@ModelAttribute("miTankformDataList") MiTankformData miFormObj, HttpServletRequest request,
			HttpSession session, SessionStatus status) {
		ModelAndView mav = new ModelAndView();
		
		Integer output=0;
		
		String[] saveFileName = null;

		List<String> fileNameList = new ArrayList<String>();
		
		
		List<MiTankformData> MiformdaoimplObjedit = new ArrayList<MiTankformData>();
		
		List<MiTankformData> MiformdaoimplObjdelete = new ArrayList<MiTankformData>();
		List<MiTankformData> MiformdaoimplObjinsert = new ArrayList<MiTankformData>();
		MstOutputWithFlag mstouputcont = new MstOutputWithFlag();
		
		List<MiTankFormDocs> frmdocList = new ArrayList<MiTankFormDocs>();
		
		Boolean captOutput = false;
		
		try {
			
			User user = (User) session.getAttribute("userObj");
			String captcha = (String) session.getAttribute("CAPTCHA");
			
			if (miFormObj.getMiTankformDataList().get(0).getCaptcha() == null || miFormObj.getMiTankformDataList().get(0).getCaptcha() == null) {
				output=-3 ;
			}else if ((miFormObj.getMiTankformDataList().get(0).getCaptcha() != null && captcha != null)){
				
				if ((miFormObj.getMiTankformDataList().get(0).getCaptcha() != null && !miFormObj.getMiTankformDataList().get(0).getCaptcha().equals(captcha))) {
					// System.out.println("coming here"+canalObj.getCaptcha());
				
					miFormObj.getMiTankformDataList().get(0).setCaptcha("");
				
					captOutput = false;
					output=-2;

				}else if (miFormObj.getMiTankformDataList().get(0).getCaptcha().equals(captcha)) {

					captOutput = true;

				}
				
				
				
			}
			
			if (captOutput == true) {

			if (miFormObj.getMiTankformDataList() != null) {
			
				
				if (user != null) {

					if (user.getEmpId() != null || user.getUserName() != null) {

						// System.out.println("user.getUserId()"+user.getUserEmpId()+"user.getUserName()"+user.getUserName());
						miFormObj.getMiTankformDataList().get(0).setEmpId(Long.parseLong(user.getEmpId().toString()));

						miFormObj.getMiTankformDataList().get(0).setUserName(user.getUserName());

					}
					
					
					if (miFormObj.getMiTankformDataList().size() > 0) {

						if (miFormObj.getMiTankformDataList().get(0).getTabId()==1 ) {

							int len = miFormObj.getMiTankformDataList().size();

							if (miFormObj.getMiTankformDataList() != null) {

								for (int i = 0; i < len-1 ; i++) {
									
									
									

											if (miFormObj.getMiTankformDataList().get(0).getTankId() != null &&  miFormObj.getMiTankformDataList().get(0).getResId()!=null && miFormObj.getMiTankformDataList().get(0).getCanId()!=null &&  miFormObj.getMiTankformDataList().get(0).getCatId()!=null  ) {

												MiTankformData mi = new MiTankformData();
											
												mi.setProjectId(miFormObj.getMiTankformDataList().get(0).getProjectId());
												mi.setResId(miFormObj.getMiTankformDataList().get(0).getResId());
												mi.setCanId(miFormObj.getMiTankformDataList().get(0).getCanId());
												mi.setCatId(miFormObj.getMiTankformDataList().get(0).getCatId());
												
												mi.setCanalLocId(miFormObj.getMiTankformDataList().get(0).getCanalLocId());
												//mi.setIrrStrDmaPort(miFormObj.getMiTankformDataList().get(0).getIrrStrDmaPort());
												mi.setTankId(miFormObj.getMiTankformDataList().get(0).getTankId());
												mi.setTabId(miFormObj.getMiTankformDataList().get(0).getTabId());
												
												mi.setDamageType(miFormObj.getMiTankformDataList().get(0).getDamageType());
												
												mi.setDamageCause(miFormObj.getMiTankformDataList().get(0).getDamageCause());
												
												mi.setDamageDate(miFormObj.getMiTankformDataList().get(0).getDamageDate());
												mi.setDamageTime(miFormObj.getMiTankformDataList().get(0).getDamageTime());
												mi.setFrmProposed(miFormObj.getMiTankformDataList().get(0).getFrmProposed());
												mi.setWriteOffValue(miFormObj.getMiTankformDataList().get(0).getWriteOffValue());
												mi.setWriteOffAction(miFormObj.getMiTankformDataList().get(0).getWriteOffAction());
												mi.setRegLeftChnnAcres(miFormObj.getMiTankformDataList().get(0).getRegLeftChnnAcres());
												mi.setRegRightChnnAcres(miFormObj.getMiTankformDataList().get(0).getRegRightChnnAcres());
												mi.setRegOthAcres(miFormObj.getMiTankformDataList().get(0).getRegOthAcres());
												mi.setRainRGStation(miFormObj.getMiTankformDataList().get(0).getRainRGStation());
												mi.setRainQty(miFormObj.getMiTankformDataList().get(0).getRainQty());
												mi.setRainDate(miFormObj.getMiTankformDataList().get(0).getRainDate());
												mi.setQuartName(miFormObj.getMiTankformDataList().get(0).getQuartName());
												mi.setQuartType(miFormObj.getMiTankformDataList().get(0).getQuartType());
												mi.setBldgTypeName(miFormObj.getMiTankformDataList().get(0).getBldgTypeName());
												mi.setFormDataId(miFormObj.getMiTankformDataList().get(0).getFormDataId());
												
												mi.setUserName(miFormObj.getMiTankformDataList().get(0).getUserName());
												
												mi.setBldgDescDamage(miFormObj.getMiTankformDataList().get(0).getBldgDescDamage());
												
												//list of details
												
                                        
												mi.setIrrSrcId(miFormObj.getMiTankformDataList().get(i).getIrrSrcId());
												
												mi.setIrrChFrm(miFormObj.getMiTankformDataList().get(i).getIrrChFrm());
												mi.setIrrChTo(miFormObj.getMiTankformDataList().get(i).getIrrChTo());
												mi.setIrrL(miFormObj.getMiTankformDataList().get(i).getIrrL());
												mi.setIrrB(miFormObj.getMiTankformDataList().get(i).getIrrB());
												mi.setIrrD(miFormObj.getMiTankformDataList().get(i).getIrrD());
												mi.setIrrPermcost(miFormObj.getMiTankformDataList().get(i).getIrrPermcost());
												mi.setIrrTempcost(miFormObj.getMiTankformDataList().get(i).getIrrTempcost());
												
											     mi.setFormDetailId(miFormObj.getMiTankformDataList().get(i).getFormDetailId());
											
												//System.out.println("miFormObj.getMiTankformDataList().get(i).getFormDetailId()"+miFormObj.getMiTankformDataList().get(i).getFormDetailId());
												
												mi.setApproxRepPermanent(miFormObj.getMiTankformDataList().get(0).getApproxRepPermanent());
												
												mi.setApproxRepTemp(miFormObj.getMiTankformDataList().get(0).getApproxRepTemp());
												
												mi.setFrmBookValue(miFormObj.getMiTankformDataList().get(0).getFrmBookValue());
												mi.setEffAyacutAcres(miFormObj.getMiTankformDataList().get(0).getEffAyacutAcres());
												mi.setEffAyacutValue(miFormObj.getMiTankformDataList().get(0).getEffAyacutValue());
												mi.setActionStdCrops(miFormObj.getMiTankformDataList().get(0).getActionStdCrops());
												mi.setDamageBreaches(miFormObj.getMiTankformDataList().get(0).getDamageBreaches());
												mi.setUsefulRemarks(miFormObj.getMiTankformDataList().get(0).getUsefulRemarks());
												
												mi.setTsfcFormDate(miFormObj.getMiTankformDataList().get(0).getTsfcFormDate());
												
											//	System.out.println("i"+i);
											//	System.out.println("miFormObj.getMiTankformDataList().get(i).getIrrPermcost()"+miFormObj.getMiTankformDataList().get(i).getIrrPermcost());
											//	System.out.println("miFormObj.getMiTankformDataList().get(i).getIrrTempcost()"+miFormObj.getMiTankformDataList().get(i).getIrrTempcost());
											
												
												if(miFormObj.getMiTankformDataList().get(i).getIrrPermcost()!=null || miFormObj.getMiTankformDataList().get(i).getIrrTempcost()!=null ){
												 if((miFormObj.getMiTankformDataList().get(i).getIrrPermcost()>0.0 ||  miFormObj.getMiTankformDataList().get(i).getIrrTempcost()>0.0) ){
													
													 if(miFormObj.getMiTankformDataList().get(i).getFormDetailId()==0){
														 
														// System.out.println("i am in insert"+mi);
													 MiformdaoimplObjinsert.add(mi);
													 }
												
												
												 }
												}
											
												if(miFormObj.getMiTankformDataList().get(i).getIrrPermcost()!=null && miFormObj.getMiTankformDataList().get(i).getIrrTempcost()!=null && miFormObj.getMiTankformDataList().get(0).getFormDataId()!=null ){
													if(miFormObj.getMiTankformDataList().get(0).getFormDataId()>0 && miFormObj.getMiTankformDataList().get(i).getFormDetailId()>0)
													 if((miFormObj.getMiTankformDataList().get(i).getIrrPermcost()==0.0 &&  miFormObj.getMiTankformDataList().get(i).getIrrTempcost()==0.0) ){
														
														
															 
															// System.out.println("i am in insert"+mi);
															 MiformdaoimplObjdelete.add(mi);
														
													
													
													 }
													}
												 
												
												
												 if(miFormObj.getMiTankformDataList().get(0).getFormDataId()!=null){
												 
													 
													 if(miFormObj.getMiTankformDataList().get(0).getFormDataId()>0 && miFormObj.getMiTankformDataList().get(i).getFormDetailId()>0){
														 
														// System.out.println("i am in edit data"+miFormObj.getMiTankformDataList().get(0).getFormDataId());
														 
														// System.out.println("i am in edit detail"+miFormObj.getMiTankformDataList().get(i).getFormDetailId());
														 
														// System.out.println("i am in edit"+mi);
													 
													 MiformdaoimplObjedit.add(mi);
													 
													 }
												
												
												 
												 }
												

												
											}

										}
								
								
								// System.out.println("size list"+MiformdaoimplObj.size());
									}
							
							        //start form insert
							       
							if (MiformdaoimplObjedit != null) {

								if (MiformdaoimplObjedit.size() > 0) {

									
										output = invam.updateForm20Data(MiformdaoimplObjedit);
										
									
										if(MiformdaoimplObjedit.get(0).getFormDataId()!=null && MiformdaoimplObjedit.get(0).getFormDetailId()!=null ){
											
											if(MiformdaoimplObjedit.get(0).getFormDataId()>0 && MiformdaoimplObjedit.get(0).getFormDetailId()>0 ){
					                              	
											//	System.out.println("i am kal"+MiformdaoimplObjedit);
												
											//	System.out.println("i am kal"+MiformdaoimplObjedit.get(0).getFormDetailId());
												
											invam.updateForm20Detail(MiformdaoimplObjedit);
											
											}
											}
										
								}
							}
							
							if (MiformdaoimplObjinsert != null) {

								if (MiformdaoimplObjinsert.size() > 0) {

								
									
										if(MiformdaoimplObjinsert.get(0).getFormDataId()!=null  ){
											
											if(MiformdaoimplObjinsert.get(0).getFormDataId()>0  ){
					                              	
											invam.insertForm20Detail(MiformdaoimplObjinsert);
											}
											}
										
								}
							}
							
							if (MiformdaoimplObjdelete != null) {

								if (MiformdaoimplObjdelete.size() > 0) {

								
									
										if(MiformdaoimplObjdelete.get(0).getFormDataId()!=null  ){
											
											if(MiformdaoimplObjdelete.get(0).getFormDetailId()>0  ){
					                              	
											invam.deleteFormdetailsbydetailId(MiformdaoimplObjdelete);
											}
											}
										
								}
							}
							        //end 
							
							      
								}
							}
							
						}
						
			}
			

			
		
		
		
		
			}
			
		
		} catch (InventoryUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		
		return new Gson().toJson(output);
	}
	
	
	@RequestMapping(value = "/invtsimis/updatephotos")
	@ResponseBody
	public String  updatephotos(@ModelAttribute("miTankformDataList") MiTankformData miFormObj, HttpServletRequest request,
			HttpSession session, SessionStatus status) {
		ModelAndView mav = new ModelAndView();
		
	Integer output=0;
		
		String[] saveFileName = null;

		List<String> fileNameList = new ArrayList<String>();
		
		
		List<MiTankformData> MiformdaoimplObj = new ArrayList<MiTankformData>();

		
		List<MiTankFormDocs> frmdocList = new ArrayList<MiTankFormDocs>();
		Boolean captOutput = false;
		//Integer updatedrows=0;
	 //start of photos
	
	//System.out.println("coming here photos");
	
//System.out.println("phtosmiFormObj.getFormDataId()"+miFormObj.getMiTankformDataList().get(0).getFormDataId());
//	
//	System.out.println("coming here"+miFormObj.getMiTankformDataList().get(0).getUploadPhotos());	
	
	//System.out.println("phtosmiFormObj.getFormDataId()"+miFormObj.getMiTankformDataList().get(0).getFormDataId());
	
	//System.out.println("coming here"+miFormObj.getMiTankformDataList().get(0).getUploadPhotos());	
	
	
try{
	
	User user = (User) session.getAttribute("userObj");
	String captcha = (String) session.getAttribute("CAPTCHA3");
	
	if (miFormObj.getMiTankformDataList().get(0).getCaptcha() == null || miFormObj.getMiTankformDataList().get(0) == null) {
		output=-3 ;
	}else if ((miFormObj.getMiTankformDataList().get(0).getCaptcha() != null && captcha != null)){
		
		if ((miFormObj.getMiTankformDataList().get(0).getCaptcha() != null && !miFormObj.getMiTankformDataList().get(0).getCaptcha().equals(captcha))) {
			// System.out.println("coming here"+canalObj.getCaptcha());
		
			miFormObj.getMiTankformDataList().get(0).setCaptcha("");
		
			captOutput = false;
			output=-2;

		}else if (miFormObj.getMiTankformDataList().get(0).getCaptcha().equals(captcha)) {

			captOutput = true;

		}
		
		
		
	}
	if (captOutput == true) {	
	if (miFormObj.getMiTankformDataList() != null) {
		if (user != null) {
			
			if (user.getEmpId() != null || user.getUserName() != null) {
				
				// System.out.println("user.getUserId()"+user.getUserEmpId()+"user.getUserName()"+user.getUserName());
				miFormObj.getMiTankformDataList().get(0).setEmpId(Long.parseLong(user.getEmpId().toString()));

				miFormObj.getMiTankformDataList().get(0).setUserName(user.getUserName());

			}
		
			
	if(miFormObj.getMiTankformDataList().get(0).getFormDataId()!=null){
		
		
		if(miFormObj.getMiTankformDataList().get(0).getFormDataId()>0){
			
			miFormObj.setFormDataId(miFormObj.getMiTankformDataList().get(0).getFormDataId());
			
			
			
	if(miFormObj.getMiTankformDataList().get(0).getUploadPhotos()!=null){
		
		
		
		if(miFormObj.getMiTankformDataList().get(0).getUploadPhotos().size()>0){
			
			//System.out.println("coming here"+miFormObj.getMiTankformDataList().get(0).getUploadPhotos().size());
		
			
			List<MultipartFile> files = miFormObj.getMiTankformDataList().get(0).getUploadPhotos();
			List<String> fileNames = new ArrayList<String>();
			
			List<MiTankFormDocs> fileList = new ArrayList<MiTankFormDocs>();
			String filetitile = null;
			String filetitilenew = null;
			
			
			
			if (null != files && files.size() >= 1) {
				
				for (MultipartFile multipartFile : files) {

					String fileName = multipartFile.getOriginalFilename();
					String FileType = (files).get(0).getContentType();
					fileNames.add(fileName);
					// Handle file content -
					// multipartFile.getInputStream()

				}
				
				//System.out.println("2nd file size"+fileNames.size());
				
				for (int i = 0; i < fileNames.size(); i++) {
					filetitile = fileNames.get(i);

					// System.out.println("filetitile"+filetitile);

					if (!filetitile.isEmpty()) {
						Integer maxId;
					
							maxId = invam.getCountOfform20Docs() + 1;
						
						// System.out.println("maxId"+maxId);
						 
						 Integer  doccnt=maxId;

						String[] temps = filetitile.split(Pattern.quote("."));

						Integer dataIdNum = miFormObj.getMiTankformDataList().get(0).getFormDataId();
						
						doccnt=doccnt+i;
						
						// System.out.println("doccnt"+doccnt);

						String docName = temps[0];
						String SaveName = dataIdNum.toString() + doccnt.toString() + docName + "."
								+ temps[temps.length - 1];

					
						fileNameList.add(SaveName);

						// System.out.println("saveFileName"+fileNameList.get(i));

						/*
						 * if (i==0){
						 * filetitilenew=filetitile; }
						 * 
						 * if(i>0){
						 * 
						 * filetitilenew=filetitile+"@"+
						 * filetitilenew;
						 * 
						 * }
						 */
						// System.out.println("filetitilenew"+filetitilenew);

					}
				}
				
				 String absolutePath = servletContext.getRealPath(RELATIVE_DIR);
				
				//String rootPath = System.getProperty("catalina.base");
				
				//live
				
				//File dir = new File( File.separator + "Uploads" +File.separator + "tsimis" + File.separator + "uploadedFiles"
					//	+ File.separator + "FormDocs");
				
				 File dir = new File(absolutePath);
				 
				//File dir = new File(rootPath + File.separator + "webapps" +File.separator + "tsimis" + File.separator + "uploadedFiles"
						//+ File.separator + "FormDocs");
				/*File dir = new File(rootPath + File.separator + "webapps" + File.separator
						+ "PMSWebApp"+File.separator + "tsimis" + File.separator + "uploadedFiles"
						+ File.separator + "FormDocs");*/
				//local
				/*File dir = new File(rootPath + File.separator + "webapps" + File.separator
						+ "ICADLeagalWebApp"+File.separator + "uploadedFiles"
						+ File.separator + "FormDocs");*/
				
				if (!dir.exists())
					dir.mkdirs();
				
				for (int i = 0; i < files.size(); i++) {

					// File serverFile = new
					// File(dir.getAbsolutePath()+
					// File.separator +
					// files.get(i).getOriginalFilename());
					if (!fileNameList.isEmpty()) {

						if (fileNameList.size() > 0) {

							String frmDocName = fileNameList.get(i);
							MiTankFormDocs tf = new MiTankFormDocs();

							tf.setFormDocName(frmDocName);
							tf.setFormDocOriginalName(files.get(i).getOriginalFilename());
							tf.setFormDocLocation(
									dir.getAbsolutePath() + File.separator + frmDocName);

							// System.out.println("serverFile"+frmDocName);
							fileList.add(tf);

						   //   String targetPath=dir.getAbsolutePath()+ File.separator + frmDocName ;
								
						      
						     // int scaledWidth = 1024;
					        //    int scaledHeight = 768;
					         //   MultipartFile newFile=files.get(i);
					         //   ResizeImage.resize(newFile, targetPath, scaledWidth, scaledHeight);
						      files.get(i).transferTo( new File(dir.getAbsolutePath() + File.separator + frmDocName));
							

						}

					}
				}
				
				if (fileList.size() > 0) {
					
				//	System.out.println("fileList"+fileList);
					miFormObj.setPhotosList(fileList);
					

				}
				
				output = invam.insertFormDocuments(miFormObj);
				
				//System.out.println("output"+output);

				
			}
			
		}
	}
				
			
			
		
	}
	}
	
	}
	}
	
	}	
		
	

		}catch (InventoryUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
			
		
	      //end of photos
	
	return new Gson().toJson(output);
			}

	

	@RequestMapping(value = "/invtsimis/getTanks")
	@ResponseBody
	public String getTanks(Habitations habitObj, HttpServletRequest request, HttpSession session, SessionStatus status) {

		List<Tanks> tankList = new ArrayList<Tanks>();

		try {
			

			if (habitObj != null) {

				if (habitObj.getdId()!=null && habitObj.getmId()!=null && habitObj.getvId()!=null && habitObj.gethId()!=null) {
					tankList = invam.getTanks(habitObj);
				}
			}

			// System.out.println("resListbyId"+resListbyId);

		} catch (InventoryUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new Gson().toJson(tankList);

	}

	@RequestMapping(value = "/invtsimis/res-ann1")
	public ModelAndView resann1(HttpServletRequest request, HttpSession session, SessionStatus status) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("res-ann1");
		List<Unit> unitList = new ArrayList<Unit>();

		List<ReservoirMaintenanceChecks> rescheckann1 = new ArrayList<ReservoirMaintenanceChecks>();
		/*List<ReservoirMaintenanceChecks> rescheckann1a = new ArrayList<ReservoirMaintenanceChecks>();
		List<ReservoirMaintenanceChecks> rescheckann1b = new ArrayList<ReservoirMaintenanceChecks>();
		List<ReservoirMaintenanceChecks> rescheckann1c = new ArrayList<ReservoirMaintenanceChecks>();
		List<ReservoirMaintenanceChecks> rescheckann1d = new ArrayList<ReservoirMaintenanceChecks>();*/
       
		List<EmpApprove> getempapprove = new ArrayList<EmpApprove>();
		
		List<ReservoirMaintenanceCategory> rescatList = new ArrayList<ReservoirMaintenanceCategory>();
		/*List<ReservoirMaintenanceChecks> rescheckann2 = new ArrayList<ReservoirMaintenanceChecks>();
		List<ReservoirMaintenanceChecks> rescheckann2a = new ArrayList<ReservoirMaintenanceChecks>();
		List<ReservoirMaintenanceChecks> rescheckann2b = new ArrayList<ReservoirMaintenanceChecks>();
		List<ReservoirMaintenanceChecks> rescheckann2c = new ArrayList<ReservoirMaintenanceChecks>();
		List<ReservoirMaintenanceChecks> rescheckann2d = new ArrayList<ReservoirMaintenanceChecks>();
		List<ReservoirMaintenanceChecks> rescheckann2e = new ArrayList<ReservoirMaintenanceChecks>();
		
		List<ReservoirMaintenanceChecks> rescheckann2f = new ArrayList<ReservoirMaintenanceChecks>();
		List<ReservoirMaintenanceChecks> rescheckann2g = new ArrayList<ReservoirMaintenanceChecks>();
		List<ReservoirMaintenanceChecks> rescheckann2h = new ArrayList<ReservoirMaintenanceChecks>();
		List<ReservoirMaintenanceChecks> rescheckann2i = new ArrayList<ReservoirMaintenanceChecks>();
		List<ReservoirMaintenanceChecks> rescheckann2k = new ArrayList<ReservoirMaintenanceChecks>();
		List<ReservoirMaintenanceChecks> rescheckann2l = new ArrayList<ReservoirMaintenanceChecks>();*/
		
		List<ReservoirMaintenanceChecks> rescheckann2all = new ArrayList<ReservoirMaintenanceChecks>();
		
		List<ReservoirMaintenanceChecks> rescheckann1all = new ArrayList<ReservoirMaintenanceChecks>();
		
		
		
		
		
	List<Tanks> tankjurisList = new ArrayList<Tanks>();
	List<Tanks> nrldtankjurisList = new ArrayList<Tanks>();
		
		List<Tanks> tanksList = new ArrayList<Tanks>();
		List<Tanks> anicutList = new ArrayList<Tanks>();
		List<Tanks> checkDamList = new ArrayList<Tanks>();
		
		List<Project> projectList = new ArrayList<Project>();
		
		List<ReservoirSalient>  reservoirList = new ArrayList<ReservoirSalient>();
		
		List<ReservoirSalient>  nrldreservoirList = new ArrayList<ReservoirSalient>();
		
		  
		
		try {
			rescheckann1 = invam.getResCheckAnn1();
			unitList = lam.getUnitList();
			rescatList = invam.getResCatAnn2();
			

			User user = (User) session.getAttribute("userObj");
			
			
if (user != null) {
				
				EmpApprove empObj= new EmpApprove();
				
				
				empObj.setDesignationId(user.getDesignationId());	
				if(user.getUnitId()!=null){
				empObj.setUnitId(user.getUnitId());
				}
				if(user.getCircleId()!=null){
				empObj.setCircleId(user.getCircleId());
				}
				if(user.getDivisionId()!=null){
				empObj.setDivisionId(user.getDivisionId());
				}
				if(user.getSubdivisionId()!=null){
				empObj.setSubdivisionId(user.getSubdivisionId());
				}
				if(user.getSectionId()!=null){
				empObj.setSectionId(user.getSectionId());
				}
				if(empObj!=null){
				getempapprove = invam.getEmployeeApprove(empObj);
				}
				
	

				mav.addObject("getempapprove", getempapprove);
				
				if(user.getUnitId()!=null){
					
					if(user.getUnitId()>0){
					
						nrldtankjurisList= invam.getTankSectionMapNrld(user);
						
	             mav.addObject("tankjurisList", nrldtankjurisList);
						
						//System.out.println("nrldtankjurisList 2"+nrldtankjurisList);
						
						//mav.addObject("anicutList", anicutList);
						mav.addObject("tanksList", nrldtankjurisList);
					
					//System.out.println("tankjurisList"+tankjurisList);
					
					/*if(tankjurisList!=null){
						
						if(tankjurisList.size()>0){
							
							
							for(int i=0; i<tankjurisList.size(); i++){
								
								if(tankjurisList.get(i).getIsNrld()==true){
									
									//System.out.println("tankjurisList1"+tankjurisList.get(i).getNrldCode());
									
									nrldtankjurisList.add(tankjurisList.get(i));
									
								}
							
							}
							
							
							
							
						
						
						
					
						
						mav.addObject("tankjurisList", nrldtankjurisList);
						
						//System.out.println("nrldtankjurisList 2"+nrldtankjurisList);
						
						//mav.addObject("anicutList", anicutList);
						mav.addObject("tanksList", nrldtankjurisList);
						//mav.addObject("checkDamList", checkDamList);
						}
					}*/
						
						 projectList = invam.getNrldProjectList(user);
							
						 nrldreservoirList = invam.getNrldResList(user);
						 
						// System.out.println("nrldreservoirList"+nrldreservoirList);
						 
							mav.addObject("projectList", projectList);
							
							mav.addObject("reservoirList", nrldreservoirList);
						
					}
				
				
					
					 
				
				
				/*if(reservoirList!=null){
					
					if(reservoirList.size()>0){
						
						for(int i=0; i<reservoirList.size() ; i++){
							
							if(reservoirList.get(i).getIsNrld()==true){
								
								//System.out.println(reservoirList.get(i).getNrldCode());
							
							nrldreservoirList.add(reservoirList.get(i));
							}
							
						}
					
					
					}
				}
				*/
				//System.out.println("projectList"+projectList);
				
			
				
				
				
				
				}
				
				
					
	
		
			}
			if (rescheckann1 != null) {
				if (rescheckann1.size() > 0) {

					for (int i = 0; i < rescheckann1.size(); i++) {
						
						
						if (rescheckann1.get(i).getResCategoryId() >=1 && rescheckann1.get(i).getResCategoryId()<=4 ) {
							rescheckann1all.add(rescheckann1.get(i));

						}

						/*if (rescheckann1.get(i).getResCategoryId() == 1) {
							rescheckann1a.add(rescheckann1.get(i));

						}

						if (rescheckann1.get(i).getResCategoryId() == 2) {
							rescheckann1b.add(rescheckann1.get(i));
						}

						if (rescheckann1.get(i).getResCategoryId() == 3) {
							rescheckann1c.add(rescheckann1.get(i));
						}

						if (rescheckann1.get(i).getResCategoryId() == 4) {
							rescheckann1d.add(rescheckann1.get(i));
						}*/

					}
				}
			}
			
			if (rescheckann1 != null && rescatList != null) {

				if (rescheckann1.size() > 0 && rescatList.size() > 0) {
					for (int j = 0; j < rescatList.size(); j++) {
						for (int i = 0; i < rescheckann1.size(); i++) {
							
							
							if (rescatList.get(j).getResCatParentId() >=5 &&  rescatList.get(j).getResCatParentId()<=15) {

								if (rescatList.get(j).getResCategoryId() == rescheckann1.get(i)
										.getResCategoryId()) {

									rescheckann2all.add(rescheckann1.get(i));

								}
							}

							/*if (rescatList.get(j).getResCatParentId() == 5) {

								if (rescatList.get(j).getResCategoryId() == rescheckann1.get(i)
										.getResCategoryId()) {

									rescheckann2a.add(rescheckann1.get(i));

								}
							}
							
							if (rescatList.get(j).getResCatParentId() == 6) {

								if (rescatList.get(j).getResCategoryId() == rescheckann1.get(i)
										.getResCategoryId()) {

									rescheckann2b.add(rescheckann1.get(i));

								}
							}
							
							if (rescatList.get(j).getResCatParentId() == 7) {

								if (rescatList.get(j).getResCategoryId() == rescheckann1.get(i)
										.getResCategoryId()) {

									rescheckann2c.add(rescheckann1.get(i));

								}
							}
							
							if (rescatList.get(j).getResCatParentId() == 8) {

								if (rescatList.get(j).getResCategoryId() == rescheckann1.get(i)
										.getResCategoryId()) {

									rescheckann2d.add(rescheckann1.get(i));

								}
							}
							
							if (rescatList.get(j).getResCatParentId() == 9) {

								if (rescatList.get(j).getResCategoryId() == rescheckann1.get(i)
										.getResCategoryId()) {

									rescheckann2e.add(rescheckann1.get(i));

								}
							}
							
							if (rescatList.get(j).getResCatParentId() == 10) {

								if (rescatList.get(j).getResCategoryId() == rescheckann1.get(i)
										.getResCategoryId()) {

									rescheckann2f.add(rescheckann1.get(i));

								}
							}
							
							if (rescatList.get(j).getResCatParentId() == 11) {

								if (rescatList.get(j).getResCategoryId() == rescheckann1.get(i)
										.getResCategoryId()) {

									rescheckann2g.add(rescheckann1.get(i));

								}
							}
							
							if (rescatList.get(j).getResCatParentId() == 12) {

								if (rescatList.get(j).getResCategoryId() == rescheckann1.get(i)
										.getResCategoryId()) {

									rescheckann2h.add(rescheckann1.get(i));

								}
							}
							
							if (rescatList.get(j).getResCatParentId() == 13) {

								if (rescatList.get(j).getResCategoryId() == rescheckann1.get(i)
										.getResCategoryId()) {

									rescheckann2i.add(rescheckann1.get(i));

								}
							}
							
							if (rescatList.get(j).getResCatParentId() == 14) {

								if (rescatList.get(j).getResCategoryId() == rescheckann1.get(i)
										.getResCategoryId()) {

									rescheckann2k.add(rescheckann1.get(i));

								}
							}
							
							if (rescatList.get(j).getResCatParentId() == 15) {

								if (rescatList.get(j).getResCategoryId() == rescheckann1.get(i)
										.getResCategoryId()) {

									rescheckann2l.add(rescheckann1.get(i));

								}
							}*/
							
							
						

							/*if (rescatList.get(j).getResCatParentId() == 6
									|| rescatList.get(j).getResCatParentId() == 19
									|| rescatList.get(j).getResCatParentId() == 23
									) {

								if (rescatList.get(j).getResCategoryId() == rescheckann1.get(i)
										.getResCategoryId()) {

									rescheckann2b.add(rescheckann1.get(i));

								}
							}*/

							/*if (rescatList.get(j).getResCategoryId() == 7) {

								if (rescatList.get(j).getResCategoryId() == rescheckann1.get(i)
										.getResCategoryId()) {

									rescheckann2c.add(rescheckann1.get(i));

								}
							}*/

							/*if (rescatList.get(j).getResCategoryId() == 8) {

								if (rescatList.get(j).getResCategoryId() == rescheckann1.get(i)
										.getResCategoryId()) {

									rescheckann2d.add(rescheckann1.get(i));

								}
							}*/

						}

					}

				}
			}
			
			

		} catch (InventoryUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (LeagalUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		/*mav.addObject("ann1resa", rescheckann1a);
		mav.addObject("ann1resb", rescheckann1b);
		mav.addObject("ann1resc", rescheckann1c);
		mav.addObject("ann1resd", rescheckann1d);*/

		mav.addObject("unitList", unitList);
		
		//System.out.println("rescatList"+rescatList);
		
		mav.addObject("rescatList", rescatList);
		mav.addObject("rescheckann2", rescheckann1);
		
		/*mav.addObject("rescheckann2a", rescheckann2a);
		mav.addObject("rescheckann2b", rescheckann2b);
		mav.addObject("rescheckann2c", rescheckann2c);
		mav.addObject("rescheckann2d", rescheckann2d);
		mav.addObject("rescheckann2e", rescheckann2e);
		mav.addObject("rescheckann2f", rescheckann2f);
		mav.addObject("rescheckann2g", rescheckann2g);
		mav.addObject("rescheckann2h", rescheckann2h);
		mav.addObject("rescheckann2i", rescheckann2i);
		mav.addObject("rescheckann2k", rescheckann2k);
		mav.addObject("rescheckann2l", rescheckann2l);*/
		
		mav.addObject("rescheckann2all", rescheckann2all);
		
		mav.addObject("rescheckann1all", rescheckann1all);
		
		
		
		
		
		return mav;

	}

	@RequestMapping(value = "/invtsimis/res-ann2")
	public ModelAndView resann2(HttpServletRequest request, HttpSession session, SessionStatus status) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("res-ann2");
		List<Unit> unitList = new ArrayList<Unit>();
		List<ReservoirMaintenanceCategory> rescatList = new ArrayList<ReservoirMaintenanceCategory>();
		List<ReservoirMaintenanceChecks> rescheckann2 = new ArrayList<ReservoirMaintenanceChecks>();
		List<ReservoirMaintenanceChecks> rescheckann2a = new ArrayList<ReservoirMaintenanceChecks>();
		List<ReservoirMaintenanceChecks> rescheckann2b = new ArrayList<ReservoirMaintenanceChecks>();
		List<ReservoirMaintenanceChecks> rescheckann2c = new ArrayList<ReservoirMaintenanceChecks>();
		List<ReservoirMaintenanceChecks> rescheckann2d = new ArrayList<ReservoirMaintenanceChecks>();
		List<ReservoirMaintenanceChecks> rescheckann2e = new ArrayList<ReservoirMaintenanceChecks>();
		List<EmpApprove> getempapprove = new ArrayList<EmpApprove>();

		try {
			rescatList = invam.getResCatAnn2();

			rescheckann2 = invam.getResCheckAnn1();

			unitList = lam.getUnitList();

			User user = (User) session.getAttribute("userObj");

			if (user != null) {

			//	getempapprove = invam.getEmployeeApprove(user);

				mav.addObject("getempapprove", getempapprove);

				if (rescheckann2 != null && rescatList != null) {

					if (rescheckann2.size() > 0 && rescatList.size() > 0) {
						for (int j = 0; j < rescatList.size(); j++) {
							for (int i = 0; i < rescheckann2.size(); i++) {

								if (rescatList.get(j).getResCatParentId() == 5) {

									if (rescatList.get(j).getResCategoryId() == rescheckann2.get(i)
											.getResCategoryId()) {

										rescheckann2a.add(rescheckann2.get(i));

									}
								}

								if (rescatList.get(j).getResCatParentId() == 6
										|| rescatList.get(j).getResCatParentId() == 19) {

									if (rescatList.get(j).getResCategoryId() == rescheckann2.get(i)
											.getResCategoryId()) {

										rescheckann2b.add(rescheckann2.get(i));

									}
								}

								if (rescatList.get(j).getResCategoryId() == 7) {

									if (rescatList.get(j).getResCategoryId() == rescheckann2.get(i)
											.getResCategoryId()) {

										rescheckann2c.add(rescheckann2.get(i));

									}
								}

								if (rescatList.get(j).getResCategoryId() == 8) {

									if (rescatList.get(j).getResCategoryId() == rescheckann2.get(i)
											.getResCategoryId()) {

										rescheckann2d.add(rescheckann2.get(i));

									}
								}

							}

						}

					}
				}

			}

			// System.out.println("rescatList"+rescatList);

		} catch (InventoryUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (LeagalUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// System.out.println("rescheckann2c"+rescheckann2c);
		mav.addObject("rescatList", rescatList);
		mav.addObject("rescheckann2", rescheckann2);
		mav.addObject("unitList", unitList);
		mav.addObject("rescheckann2a", rescheckann2a);
		mav.addObject("rescheckann2b", rescheckann2b);
		mav.addObject("rescheckann2c", rescheckann2c);
		mav.addObject("rescheckann2d", rescheckann2d);

		return mav;

	}

	@RequestMapping(value = "/invtsimis/addReschecksAnn1")
	@ResponseBody
	public String addReschecksAnn1(@ModelAttribute("rescheckList") ReservoirInspect resObjann1,
			HttpServletRequest request, HttpSession session, SessionStatus status) {
		ModelAndView mav = new ModelAndView();

		// System.out.println("rescomehere");

		List<ReservoirInspect> resAnna1daoimplObj = new ArrayList<ReservoirInspect>();
		List<ReservoirInspect> oldresinspectlist = new ArrayList<ReservoirInspect>();
		MstOutputWithFlag mstOutputWithFlag = new MstOutputWithFlag();

		Integer output = null;

		Integer output2 = 0;

		try {
			// unitList = lam.getUnitList();

			User user = (User) session.getAttribute("userObj");

			// System.out.println("mitankObj"+mitankObj.getMiTankInspectList().size());
			// System.out.println("resObjann1"+resObjann1.getReservoirInspectList());
			if (user != null) {

				if (user.getUserId() != null || user.getUserName() != null) {

					String Str = user.getUserName();

					

					resObjann1.getReservoirInspectList().get(0).setUserName(user.getUserName());
				}

				if (resObjann1.getReservoirInspectList().size() > 0) {

					if (resObjann1.getReservoirInspectList().get(0).getTabId()==1
							|| resObjann1.getReservoirInspectList().get(0).getTabId()==2
							|| resObjann1.getReservoirInspectList().get(0).getTabId()==3
							|| resObjann1.getReservoirInspectList().get(0).getTabId()==4) {

						int len = resObjann1.getReservoirInspectList().size();

						if (resObjann1.getReservoirInspectList() != null) {

							for (int i = 1; i < len; i++) {
								if (resObjann1.getReservoirInspectList().get(i).getResCheckboxId() != null) {
									if (resObjann1.getReservoirInspectList().get(i).getResCheckboxId() == 1) {

										if (resObjann1.getReservoirInspectList().get(0).getResCode() != null) {

											ReservoirInspect res = new ReservoirInspect();

											res.setUnitId(resObjann1.getReservoirInspectList().get(0).getUnitId());
											res.setCircleId(resObjann1.getReservoirInspectList().get(0).getCircleId());
											res.setDivisionId(
													resObjann1.getReservoirInspectList().get(0).getDivisionId());
											res.setSubdivisionId(
													resObjann1.getReservoirInspectList().get(0).getSubdivisionId());
											res.setProjectId(
													resObjann1.getReservoirInspectList().get(0).getProjectId());

											res.setUserId(resObjann1.getReservoirInspectList().get(0).getUserId());
											res.setUserName(resObjann1.getReservoirInspectList().get(0).getUserName());
											res.setDesignationId(
													resObjann1.getReservoirInspectList().get(0).getDesignationId());

											if (resObjann1.getReservoirInspectList().get(0).getDesignationId() == 2
													|| resObjann1.getReservoirInspectList().get(0)
															.getDesignationId() == 8) {

												res.setApprovStatusId(1);
											}

											res.setInspectDate(
													resObjann1.getReservoirInspectList().get(0).getInspectDate());
											res.setResCheckboxId(
													resObjann1.getReservoirInspectList().get(i).getResCheckboxId());
											res.setResCheckId(
													resObjann1.getReservoirInspectList().get(i).getResCheckId());
											res.setResCatId(resObjann1.getReservoirInspectList().get(i).getResCatId());

											res.setResCode(resObjann1.getReservoirInspectList().get(0).getResCode());

											res.setYear(resObjann1.getReservoirInspectList().get(0).getYear());
											res.setRemarks(resObjann1.getReservoirInspectList().get(i).getRemarks());

											res.setDutyFrequencyId(
													resObjann1.getReservoirInspectList().get(0).getDutyFrequencyId());
											
											res.setSectionId(resObjann1.getReservoirInspectList().get(0).getSectionId());
										/*	res.setResStatusId(resObjann1.getReservoirInspectList().get(0).getResStatusId());*/
											res.setPostId(resObjann1.getReservoirInspectList().get(0).getPostId());
											res.setNextPostId(resObjann1.getReservoirInspectList().get(0).getNextPostId());
											res.setNextEmpId(resObjann1.getReservoirInspectList().get(0).getNextEmpId());
											res.setEmpId(resObjann1.getReservoirInspectList().get(0).getEmpId());
											res.setTabId(resObjann1.getReservoirInspectList().get(0).getTabId());
											
											res.setGenRemarks(resObjann1.getReservoirInspectList().get(0).getGenRemarks());
											
											res.setOmRemarks(resObjann1.getReservoirInspectList().get(0).getOmRemarks());
											res.setCmRemarks(resObjann1.getReservoirInspectList().get(0).getCmRemarks());
											res.setErRemarks(resObjann1.getReservoirInspectList().get(0).getErRemarks());
											res.setReservoirId(resObjann1.getReservoirInspectList().get(0).getReservoirId());
											

											resAnna1daoimplObj.add(res);

											// System.out.println(res);
										}

									}
								}
							}
						}

						// System.out.println("MiTankdaoimplObj"+MiTankdaoimplObj.size());

						if (resAnna1daoimplObj != null) {

							if (resAnna1daoimplObj.size() > 0) {

								if (resAnna1daoimplObj.get(0).getReservoirId() != null) {

									mstOutputWithFlag = invam.insertResAnn1Mst1(resAnna1daoimplObj);

									if (mstOutputWithFlag != null) {

										if (mstOutputWithFlag.getMstNewId() != null) {

											resAnna1daoimplObj.get(0)
													.setResInspectMst1Id(mstOutputWithFlag.getMstNewId());
										}
										if (mstOutputWithFlag.getMstOldId() != null) {

											resAnna1daoimplObj.get(0)
													.setResInspectMst1Id(mstOutputWithFlag.getMstOldId());
										}

										if (mstOutputWithFlag.getMstOldId() != null) {

											if (mstOutputWithFlag.getMstOldId() > 0) {
												// System.out.println(mstOutputWithFlag.getMstOldId()+"here1");

												// System.out.println(resAnn2daoimplObj.get(0).getResInspectMst1Id()+"here2");

												oldresinspectlist = invam
														.getResAnn1mst2IdByMst1Id(mstOutputWithFlag.getMstOldId());

												if (oldresinspectlist != null) {

													if (oldresinspectlist.size() > 0) {

														if (oldresinspectlist.size() < resAnna1daoimplObj.size()) {

															for (int i = 0; i < resAnna1daoimplObj.size(); i++) {

																for (int j = 0; j < oldresinspectlist.size(); j++) {

																	if ((resAnna1daoimplObj.get(i).getResCatId().equals(
																			oldresinspectlist.get(j).getResCatId()))) {
																		if ((resAnna1daoimplObj.get(i).getResCheckId()
																				.equals(oldresinspectlist.get(j)
																						.getResCheckId()))) {

																			resAnna1daoimplObj.remove(i);

																		}
																	}
																}
															}
														}

														if (oldresinspectlist.size() > resAnna1daoimplObj.size()) {

															// System.out.println(oldresinspectlist.size()+"here3");
															for (int i = 0; i < oldresinspectlist.size(); i++) {
																// System.out.println(i+"i");
																for (int j = 0; j < resAnna1daoimplObj.size(); j++) {
																	// System.out.println(j+"j"+resAnn2daoimplObj.get(j).getResCheckId());
																	// System.out.println(i+"i"+oldresinspectlist.get(i).getResCheckId());

																	if ((resAnna1daoimplObj.get(j).getResCatId().equals(
																			oldresinspectlist.get(i).getResCatId()))) {

																		// System.out.println(oldresinspectlist.get(i).getResCatId()+"cmoing
																		// here");
																		if ((oldresinspectlist.get(i).getResCheckId()
																				.equals(resAnna1daoimplObj.get(j)
																						.getResCheckId()))) {

																			resAnna1daoimplObj.remove(j);

																		}
																	}
																}
															}
														}

													}

												}

												// System.out.println(resAnn2daoimplObj+"sizecoming"+resAnn2daoimplObj.size());
											}
										}

									}

									if (mstOutputWithFlag.getMstOldId() != null
											|| mstOutputWithFlag.getMstNewId() != null) {

										if (resAnna1daoimplObj != null) {
											if (resAnna1daoimplObj.size() > 0) {

												if (mstOutputWithFlag.getMstNewId() != null) {

													resAnna1daoimplObj.get(0)
															.setResInspectMst1Id(mstOutputWithFlag.getMstNewId());
												}
												if (mstOutputWithFlag.getMstOldId() != null) {

													resAnna1daoimplObj.get(0)
															.setResInspectMst1Id(mstOutputWithFlag.getMstOldId());
												}
												// System.out.println("cnt1"+resAnn2daoimplObj.get(0).getResInspectMst1Id());;
												if (resAnna1daoimplObj.get(0).getResInspectMst1Id() != null) {
													// System.out.println("cnt2"+resAnn2daoimplObj.get(0).getResInspectMst1Id());

													output = invam.insertresAnn1inspectMst2(resAnna1daoimplObj);

												}
												
												if (resAnna1daoimplObj.get(0).getResInspectMst1Id() > 0) {
		                                        	
													resObjann1.getReservoirInspectList().get(0).setResInspectMst1Id(resAnna1daoimplObj.get(0).getResInspectMst1Id());
													
													invam.insertResAnn1Mst1Remarks(resObjann1.getReservoirInspectList().get(0));
												}
											}
										}

									}

								}

							}

						}
					}

				}

				// System.out.println("MiTankdaoimplObj"+MiTankdaoimplObj.size());

			}
		} catch (InventoryUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// mav.addObject("unitList", unitList);
		return new Gson().toJson(output);

	}
	
	
	
	
	@RequestMapping(value = "/invtsimis/addnrldchecksAnn1")
	@ResponseBody
	public String addnrldchecksAnn1(@ModelAttribute("rescheckObject") ReservoirInspect resObjann1,
			HttpServletRequest request, HttpSession session, SessionStatus status) {
		
		
		//ModelAndView mav = new ModelAndView();

		/// System.out.println("rescomehere"+resObjann1);

		//List<ReservoirInspect> resAnna1daoimplObj = new ArrayList<ReservoirInspect>();
		List<ReservoirInspect> oldresinspectlist = new ArrayList<ReservoirInspect>();
		MstOutputWithFlag mstOutputWithFlag = new MstOutputWithFlag();
		
		ReservoirInspect res = new ReservoirInspect();

		Integer output = 0;

		//Integer output2 = 0;

		try {
			// unitList = lam.getUnitList();

			User user = (User) session.getAttribute("userObj");

			// System.out.println("mitankObj"+mitankObj.getMiTankInspectList().size());
			// System.out.println("resObjann1"+resObjann1.getReservoirInspectList());
			if (user != null) {

				if (user.getUserId() != null || user.getUserName() != null) {

					//String Str = user.getUserName();

					

					resObjann1.setUserName(user.getUserName());
					resObjann1.setUnitId(user.getUnitId());
					resObjann1.setCircleId(user.getCircleId());
					resObjann1.setDivisionId(user.getDivisionId());
					resObjann1.setSubdivisionId(user.getSubdivisionId());
					resObjann1.setDesignationId(user.getDesignationId());
					resObjann1.setSectionId(user.getSectionId());
					resObjann1.setEmpId(user.getEmpId());
				}

				if (resObjann1!=null)
						{

					if (resObjann1.getTabId()>0) {

					
											res.setUnitId(resObjann1.getUnitId());
											res.setCircleId(resObjann1.getCircleId());
											res.setDivisionId(
													resObjann1.getDivisionId());
											res.setSubdivisionId(
													resObjann1.getSubdivisionId());
											res.setProjectId(
													resObjann1.getProjectId());

										
											res.setUserName(resObjann1.getUserName());
											res.setDesignationId(
													resObjann1.getDesignationId());

											if (resObjann1.getDesignationId() == 2
													|| resObjann1.getDesignationId() == 8) {

												res.setApprovStatusId(1);
											}

											
											res.setResCheckId(
													resObjann1.getResCheckId());
											res.setResCatId(resObjann1.getResCatId());

										

											res.setYear(resObjann1.getYear());
											res.setRemarks(resObjann1.getRemarks());

											res.setDutyFrequencyId(
													resObjann1.getDutyFrequencyId());
											
											res.setSectionId(resObjann1.getSectionId());
									
											res.setPostId(resObjann1.getPostId());
											res.setNextPostId(resObjann1.getNextPostId());
											res.setNextEmpId(resObjann1.getNextEmpId());
											res.setEmpId(resObjann1.getEmpId());
											res.setTabId(resObjann1.getTabId());
											
										
											res.setReservoirId(resObjann1.getReservoirId());
											
											res.setTankId(resObjann1.getTankId());
											
											res.setAnnexureId(resObjann1.getAnnexureId());
											
											if(resObjann1.getIrrChFrm()!=null && resObjann1.getIrrChFrm()!=null){
											res.setIrrChFrm(resObjann1.getIrrChFrm());
											res.setIrrChTo(resObjann1.getIrrChTo());
											}else {
												res.setIrrChFrm(0.01);
												res.setIrrChTo(0.01);
												
											}
											
											res.setResCheckAddFlag(true);
											
											res.setConditionofDamId(resObjann1.getConditionofDamId());
											
										if(	resObjann1.getInstalledcount()!=null){
											
											res.setInstalledcount(resObjann1.getInstalledcount());
										} else {
											res.setInstalledcount(0);
											
										}
										
                                           if(	resObjann1.getLocation()!=null){
											
											res.setLocation(resObjann1.getLocation());
										} else {
											res.setLocation("NA");
											
										}
                                           
                                           if(	resObjann1.getInstallmonth()!=null){
   											
   											res.setInstallmonth(resObjann1.getInstallmonth());
   										} else {
   											res.setInstallmonth("NA");
   											
   										}
                                           
                                           if(	resObjann1.getWorkingcondition()!=null){
      											
      											res.setWorkingcondition(resObjann1.getWorkingcondition());
      										} else {
      											res.setWorkingcondition(false);
      											
      										}
                                           
                                           if(	resObjann1.getDatelastCalibrated()!=null){
     											
     											res.setDatelastCalibrated(resObjann1.getDatelastCalibrated());
     										} else {
     											res.setDatelastCalibrated("NA");
     											
     										}
                                           
                                           if(	resObjann1.getDatenextCalibrated()!=null){
    											
    											res.setDatenextCalibrated(resObjann1.getDatenextCalibrated());
    										} else {
    											res.setDatenextCalibrated("NA");
    											
    										}
                                           
                                           if(	resObjann1.getObsmaintained()!=null){
   											
   											res.setObsmaintained(resObjann1.getObsmaintained());
   										} else {
   											res.setObsmaintained(false);
   											
   										}
                                           
                                           if(	resObjann1.getAgencyresponsible()!=null){
      											
      											res.setAgencyresponsible(resObjann1.getAgencyresponsible());
      										} else {
      											res.setAgencyresponsible(false);
      											
      										}
                                           
                                          // System.out.println("resObjann1.getAnalysisofdata()"+resObjann1.getAnalysisofdata());
                                           
                                           if(	resObjann1.getAnalysisofdata()!=null){
     											
     											res.setAnalysisofdata(resObjann1.getAnalysisofdata());
     										} else {
     											res.setAnalysisofdata(false);
     											
     										}
                                           
                                           if(	resObjann1.getDatasenttoDSO()!=null){
    											
    											res.setDatasenttoDSO(resObjann1.getDatasenttoDSO());
    										} else {
    											res.setDatasenttoDSO(false);
    											
    										}
                                           
                                           if(	resObjann1.getDatasenttoDSO()!=null){
   											
   											res.setDatasenttoDSO(resObjann1.getDatasenttoDSO());
   										} else {
   											res.setDatasenttoDSO(false);
   											
   										}
                                           
                                        //   System.out.println("resObjann1.getDamcheckResponseId()"+resObjann1.getDamcheckResponseId());
                                           
                                           if(	resObjann1.getDamcheckResponseId()!=null){
      											
      											res.setDamcheckResponseId(resObjann1.getDamcheckResponseId());
      										} else {
      											res.setDamcheckResponseId(0);
      											
      										}
                                           
                                           if(	resObjann1.getConditionofCheckId()!=null){
     											
     											res.setConditionofCheckId(resObjann1.getConditionofCheckId());
     										} else {
     											res.setConditionofCheckId(0);
     											
     										}
                                           
                                           if(	resObjann1.getResCheckName()!=null){
    											
    											res.setResCheckName(resObjann1.getResCheckName());
    										} else {
    											res.setResCheckName("NA");
    											
    										}

											

						// System.out.println("resadd"+res);

						if (res != null) {

						/*	if (resAnna1daoimplObj.size() >0) {*/
								
								// System.out.println("resAnna1daoimplObj"+resAnna1daoimplObj.get(0).getReservoirId());

								if (res.getReservoirId() != null && res.getTankId()!=null) {
									
								

									mstOutputWithFlag = invam.insertNrldAnnMst1(res);

									if (mstOutputWithFlag != null) {

										if (mstOutputWithFlag.getMstNewId() != null) {

											res
													.setResInspectMst1Id(mstOutputWithFlag.getMstNewId());
										}
										if (mstOutputWithFlag.getMstOldId() != null) {

											res
													.setResInspectMst1Id(mstOutputWithFlag.getMstOldId());
										}

										if (mstOutputWithFlag.getMstOldId() != null) {

											if (mstOutputWithFlag.getMstOldId() > 0) {
												// System.out.println(mstOutputWithFlag.getMstOldId()+"here1");

												// System.out.println(resAnn2daoimplObj.get(0).getResInspectMst1Id()+"here2");
												
												
												//System.out.println("kal2");
												oldresinspectlist = invam.getNrldAnnmst2IdByMst1Id(mstOutputWithFlag.getMstOldId());
												
												//System.out.println("kal3" +oldresinspectlist );

												if (oldresinspectlist != null) {

													if (oldresinspectlist.size() > 0) {

													/*	if (oldresinspectlist.size() < resAnna1daoimplObj.size()) {*/

														/*	for (int i = 0; i < resAnna1daoimplObj.size(); i++) {*/

																for (int j = 0; j < oldresinspectlist.size(); j++) {

																	if ((res.getResCatId().equals(
																			oldresinspectlist.get(j).getResCatId()))) {
																		if ((res.getResCheckId()
																				.equals(oldresinspectlist.get(j)
																						.getResCheckId()))) {

																			res.setResCheckAddFlag(false);
																			output=-3;

																		}
																	}
																}
															/*}*/
														/*}*/

													/*	if (oldresinspectlist.size() > resAnna1daoimplObj.size()) {

															// System.out.println(oldresinspectlist.size()+"here3");
															for (int i = 0; i < oldresinspectlist.size(); i++) {
																// System.out.println(i+"i");
																for (int j = 0; j < resAnna1daoimplObj.size(); j++) {
																	// System.out.println(j+"j"+resAnn2daoimplObj.get(j).getResCheckId());
																	// System.out.println(i+"i"+oldresinspectlist.get(i).getResCheckId());

																	if ((resAnna1daoimplObj.get(j).getResCatId().equals(
																			oldresinspectlist.get(i).getResCatId()))) {

																		// System.out.println(oldresinspectlist.get(i).getResCatId()+"cmoing
																		// here");
																		if ((oldresinspectlist.get(i).getResCheckId()
																				.equals(resAnna1daoimplObj.get(j)
																						.getResCheckId()))) {

																			resAnna1daoimplObj.remove(j);

																		}
																	}
																}
															}
														}*/

													}

												}

												// System.out.println(resAnn2daoimplObj+"sizecoming"+resAnn2daoimplObj.size());
											}
										}

									}

									if ((mstOutputWithFlag.getMstOldId() != null
											|| mstOutputWithFlag.getMstNewId() != null) &&  (res.getResCheckAddFlag()==true) ) {

										if (res != null) {
											/*if (resAnna1daoimplObj.size() > 0) {*/

												if (mstOutputWithFlag.getMstNewId() != null) {

													res
															.setResInspectMst1Id(mstOutputWithFlag.getMstNewId());
												}
												if (mstOutputWithFlag.getMstOldId() != null) {

													res
															.setResInspectMst1Id(mstOutputWithFlag.getMstOldId());
												}
												// System.out.println("cnt1"+resAnn2daoimplObj.get(0).getResInspectMst1Id());;
												if (res.getResInspectMst1Id() != null) {
													// System.out.println("cnt2"+resAnn2daoimplObj.get(0).getResInspectMst1Id());

													output = invam.insertNrldAnninspectMst2(res);

												}
												
											/*	if (resAnna1daoimplObj.get(0).getResInspectMst1Id() > 0) {
		                                        	
													resObjann1.getReservoirInspectList().get(0).setResInspectMst1Id(resAnna1daoimplObj.get(0).getResInspectMst1Id());
													
													invam.insertResAnn1Mst1Remarks(resObjann1.getReservoirInspectList().get(0));
												}*/
											/*}*/
										}

									}

								}

						/*	}*/

						}
					}

				}

				// System.out.println("MiTankdaoimplObj"+MiTankdaoimplObj.size());

			}
		} catch (InventoryUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// mav.addObject("unitList", unitList);
		return new Gson().toJson(output);

	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	@RequestMapping(value = "/invtsimis/getResList")
	@ResponseBody
	public String getInvomResList(Integer projectId, SessionStatus status, HttpSession session) {
		ModelAndView mav = new ModelAndView();

		List<ReservoirSalient> resList = new ArrayList<ReservoirSalient>();

		try {

			if (projectId != null) {

				if (projectId > 0) {
					resList = invam.getInvomResList(projectId);
				}
			}

		} catch (InventoryUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new Gson().toJson(resList);
	}

	@RequestMapping(value = "/invtsimis/addReschecksAnn2")
	@ResponseBody
	public String addReschecksAnn2(@ModelAttribute("resann2checkList") ReservoirInspect resObjann2,
			HttpServletRequest request, HttpSession session, SessionStatus status) {
		ModelAndView mav = new ModelAndView();

		// System.out.println("rescomehere");

		List<ReservoirInspect> resAnn2daoimplObj = new ArrayList<ReservoirInspect>();

		List<ReservoirInspect> oldresinspectlist = new ArrayList<ReservoirInspect>();
		MstOutputWithFlag mstOutputWithFlag = new MstOutputWithFlag();

		Integer output = null;

		Integer integer = 0;

		try {
			// unitList = lam.getUnitList();

			User user = (User) session.getAttribute("userObj");

			// System.out.println("mitankObj"+mitankObj.getMiTankInspectList().size());
			// System.out.println("resObjann1"+resObjann1.getReservoirInspectList());
			if (user != null) {

				if (user.getUserId() != null || user.getUserName() != null) {

					String Str = user.getUserName();

					if (user.getUserId() == null) {
						resObjann2.getReservoirInspectList().get(0)
								.setUserId(Integer.parseInt(Str.substring(4, Str.length())));
						resObjann2.getReservoirInspectList().get(0).setUserEmpId(user.getUserEmpId());
					}
					if (user.getUserId() != null) {
						resObjann2.getReservoirInspectList().get(0).setUserId(user.getUserId());

					}

					resObjann2.getReservoirInspectList().get(0).setUserName(user.getUserName());
				}

				if (resObjann2.getReservoirInspectList().size() > 0) {

					if (resObjann2.getReservoirInspectList().get(0).getTabId()==1
							|| resObjann2.getReservoirInspectList().get(0).getTabId()==2
							|| resObjann2.getReservoirInspectList().get(0).getTabId()==3
							|| resObjann2.getReservoirInspectList().get(0).getTabId()==4) {

						int len = resObjann2.getReservoirInspectList().size();

						if (resObjann2.getReservoirInspectList() != null) {

							for (int i = 1; i < len; i++) {
								if (resObjann2.getReservoirInspectList().get(i).getResCheckboxId() != null) {
									if (resObjann2.getReservoirInspectList().get(i).getResCheckboxId() == 1) {

										if (resObjann2.getReservoirInspectList().get(0).getResCode() != null) {

											ReservoirInspect res = new ReservoirInspect();

											res.setUnitId(resObjann2.getReservoirInspectList().get(0).getUnitId());
											res.setCircleId(resObjann2.getReservoirInspectList().get(0).getCircleId());
											res.setDivisionId(
													resObjann2.getReservoirInspectList().get(0).getDivisionId());
											res.setSubdivisionId(
													resObjann2.getReservoirInspectList().get(0).getSubdivisionId());
											res.setProjectId(
													resObjann2.getReservoirInspectList().get(0).getProjectId());

											res.setUserId(resObjann2.getReservoirInspectList().get(0).getUserId());
											res.setUserName(resObjann2.getReservoirInspectList().get(0).getUserName());
											res.setDesignationId(
													resObjann2.getReservoirInspectList().get(0).getDesignationId());

											if (resObjann2.getReservoirInspectList().get(0).getDesignationId() == 2
													|| resObjann2.getReservoirInspectList().get(0)
															.getDesignationId() == 8) {

												res.setApprovStatusId(1);
											}

											res.setInspectDate(
													resObjann2.getReservoirInspectList().get(i).getInspectDate());
											res.setResCheckboxId(
													resObjann2.getReservoirInspectList().get(i).getResCheckboxId());
											res.setResCheckId(
													resObjann2.getReservoirInspectList().get(i).getResCheckId());
											res.setResCatId(resObjann2.getReservoirInspectList().get(i).getResCatId());

											res.setResCode(resObjann2.getReservoirInspectList().get(0).getResCode());

											res.setYear(resObjann2.getReservoirInspectList().get(0).getYear());
											res.setRemarks(resObjann2.getReservoirInspectList().get(i).getRemarks());

											res.setDutyFrequencyId(
													resObjann2.getReservoirInspectList().get(0).getDutyFrequencyId());

											resAnn2daoimplObj.add(res);

											// System.out.println(res);
										}

									}
								}
							}
						}

						// System.out.println("MiTankdaoimplObj"+MiTankdaoimplObj.size());

						if (resAnn2daoimplObj != null) {

							if (resAnn2daoimplObj.size() > 0) {

								if (resAnn2daoimplObj.get(0).getResCode() != null) {

									mstOutputWithFlag = invam.insertResAnn2Mst1(resAnn2daoimplObj);

									if (mstOutputWithFlag != null) {

										if (mstOutputWithFlag.getMstNewId() != null) {

											resAnn2daoimplObj.get(0)
													.setResInspectMst1Id(mstOutputWithFlag.getMstNewId());
										}
										if (mstOutputWithFlag.getMstOldId() != null) {

											resAnn2daoimplObj.get(0)
													.setResInspectMst1Id(mstOutputWithFlag.getMstOldId());
										}

										if (mstOutputWithFlag.getMstOldId() != null) {

											if (mstOutputWithFlag.getMstOldId() > 0) {
												// System.out.println(mstOutputWithFlag.getMstOldId()+"here1");

												// System.out.println(resAnn2daoimplObj.get(0).getResInspectMst1Id()+"here2");

												oldresinspectlist = invam
														.getResAnn2mst2IdByMst1Id(mstOutputWithFlag.getMstOldId());

												if (oldresinspectlist != null) {

													if (oldresinspectlist.size() > 0) {

														if (oldresinspectlist.size() < resAnn2daoimplObj.size()) {

															for (int i = 0; i < resAnn2daoimplObj.size(); i++) {

																for (int j = 0; j < oldresinspectlist.size(); j++) {

																	if ((resAnn2daoimplObj.get(i).getResCatId().equals(
																			oldresinspectlist.get(j).getResCatId()))) {
																		if ((resAnn2daoimplObj.get(i).getResCheckId()
																				.equals(oldresinspectlist.get(j)
																						.getResCheckId()))) {

																			resAnn2daoimplObj.remove(i);

																		}
																	}
																}
															}
														}

														if (oldresinspectlist.size() > resAnn2daoimplObj.size()) {

															// System.out.println(oldresinspectlist.size()+"here3");
															for (int i = 0; i < oldresinspectlist.size(); i++) {
																// System.out.println(i+"i");
																for (int j = 0; j < resAnn2daoimplObj.size(); j++) {
																	// System.out.println(j+"j"+resAnn2daoimplObj.get(j).getResCheckId());
																	// System.out.println(i+"i"+oldresinspectlist.get(i).getResCheckId());

																	if ((resAnn2daoimplObj.get(j).getResCatId().equals(
																			oldresinspectlist.get(i).getResCatId()))) {

																		// System.out.println(oldresinspectlist.get(i).getResCatId()+"cmoing
																		// here");
																		if ((oldresinspectlist.get(i).getResCheckId()
																				.equals(resAnn2daoimplObj.get(j)
																						.getResCheckId()))) {

																			resAnn2daoimplObj.remove(j);

																		}
																	}
																}
															}
														}

													}

												}

												// System.out.println(resAnn2daoimplObj+"sizecoming"+resAnn2daoimplObj.size());
											}
										}

									}

									if (mstOutputWithFlag.getMstOldId() != null
											|| mstOutputWithFlag.getMstNewId() != null) {

										if (resAnn2daoimplObj != null) {
											if (resAnn2daoimplObj.size() > 0) {

												if (mstOutputWithFlag.getMstNewId() != null) {

													resAnn2daoimplObj.get(0)
															.setResInspectMst1Id(mstOutputWithFlag.getMstNewId());
												}
												if (mstOutputWithFlag.getMstOldId() != null) {

													resAnn2daoimplObj.get(0)
															.setResInspectMst1Id(mstOutputWithFlag.getMstOldId());
												}
												// System.out.println("cnt1"+resAnn2daoimplObj.get(0).getResInspectMst1Id());;
												if (resAnn2daoimplObj.get(0).getResInspectMst1Id() != null) {
													// System.out.println("cnt2"+resAnn2daoimplObj.get(0).getResInspectMst1Id());

													output = invam.insertresAnn2inspectMst2(resAnn2daoimplObj);

												}
											}
										}

									}

								}

							}

						}
					}

					if (resObjann2.getReservoirInspectList().get(0).getTabId()==5) {

						if (resObjann2.getReservoirInspectList() != null) {

							if (resObjann2.getReservoirInspectList().get(0).getResCheckboxId() != null) {
								if (resObjann2.getReservoirInspectList().get(0).getResCheckboxId() == 1) {

									if (resObjann2.getReservoirInspectList().get(0).getResCode() != null) {

										ReservoirInspect res = new ReservoirInspect();

										res.setUnitId(resObjann2.getReservoirInspectList().get(0).getUnitId());
										res.setCircleId(resObjann2.getReservoirInspectList().get(0).getCircleId());
										res.setDivisionId(resObjann2.getReservoirInspectList().get(0).getDivisionId());
										res.setSubdivisionId(
												resObjann2.getReservoirInspectList().get(0).getSubdivisionId());
										res.setProjectId(resObjann2.getReservoirInspectList().get(0).getProjectId());

										res.setUserId(resObjann2.getReservoirInspectList().get(0).getUserId());
										res.setUserName(resObjann2.getReservoirInspectList().get(0).getUserName());
										res.setDesignationId(
												resObjann2.getReservoirInspectList().get(0).getDesignationId());

										if (resObjann2.getReservoirInspectList().get(0).getDesignationId() == 2
												|| resObjann2.getReservoirInspectList().get(0)
														.getDesignationId() == 8) {

											res.setApprovStatusId(1);
										}

										res.setInspectDate(
												resObjann2.getReservoirInspectList().get(0).getInspectDate());
										res.setResCheckboxId(
												resObjann2.getReservoirInspectList().get(0).getResCheckboxId());

										res.setResCode(resObjann2.getReservoirInspectList().get(0).getResCode());

										res.setYear(resObjann2.getReservoirInspectList().get(0).getYear());
										res.setRemarks(resObjann2.getReservoirInspectList().get(0).getRemarks());
										res.setLevelId(resObjann2.getReservoirInspectList().get(0).getLevelId());

										res.setResCategoryId(
												resObjann2.getReservoirInspectList().get(0).getResCategoryId());
										res.setRoleId(1);

										resAnn2daoimplObj.add(res);

										// System.out.println(res);
									}

								}
							}

						}
						if (resAnn2daoimplObj != null) {

							output = invam.insertResHealth(resAnn2daoimplObj);
						}

					}

					if (resObjann2.getReservoirInspectList().get(0).getTabId()==6) {

						if (resObjann2.getReservoirInspectList() != null) {

							if (resObjann2.getReservoirInspectList().get(0).getResCheckboxId() != null) {
								if (resObjann2.getReservoirInspectList().get(0).getResCheckboxId() == 1) {

									if (resObjann2.getReservoirInspectList().get(0).getResCode() != null) {

										ReservoirInspect res = new ReservoirInspect();

										res.setUnitId(resObjann2.getReservoirInspectList().get(0).getUnitId());
										res.setCircleId(resObjann2.getReservoirInspectList().get(0).getCircleId());
										res.setDivisionId(resObjann2.getReservoirInspectList().get(0).getDivisionId());
										res.setSubdivisionId(
												resObjann2.getReservoirInspectList().get(0).getSubdivisionId());
										res.setProjectId(resObjann2.getReservoirInspectList().get(0).getProjectId());

										res.setUserId(resObjann2.getReservoirInspectList().get(0).getUserId());
										res.setUserName(resObjann2.getReservoirInspectList().get(0).getUserName());
										res.setDesignationId(
												resObjann2.getReservoirInspectList().get(0).getDesignationId());

										if (resObjann2.getReservoirInspectList().get(0).getDesignationId() == 2
												|| resObjann2.getReservoirInspectList().get(0)
														.getDesignationId() == 8) {

											res.setApprovStatusId(1);
										}

										res.setInspectDate(
												resObjann2.getReservoirInspectList().get(0).getInspectDate());
										res.setResCheckboxId(
												resObjann2.getReservoirInspectList().get(0).getResCheckboxId());

										res.setResCode(resObjann2.getReservoirInspectList().get(0).getResCode());

										res.setYear(resObjann2.getReservoirInspectList().get(0).getYear());
										res.setRecomendbysdso(
												resObjann2.getReservoirInspectList().get(0).getRecomendbysdso());
										res.setLevelId(resObjann2.getReservoirInspectList().get(0).getLevelId());
										res.setResDamHealthId(
												resObjann2.getReservoirInspectList().get(0).getResDamHealthId());
										// res.setResCategoryId(resObjann2.getReservoirInspectList().get(0).getResCategoryId());
										res.setRoleId(1);

										resAnn2daoimplObj.add(res);

										// System.out.println(res);
									}

								}
							}

						}
						if (resAnn2daoimplObj != null) {
							output = invam.insertResRecommend(resAnn2daoimplObj);
						}

					}

					if (resObjann2.getReservoirInspectList().get(0).getTabId()==7) {

						if (resObjann2.getReservoirInspectList() != null) {

							if (resObjann2.getReservoirInspectList().get(0).getResCheckboxId() != null) {
								if (resObjann2.getReservoirInspectList().get(0).getResCheckboxId() == 1) {

									if (resObjann2.getReservoirInspectList().get(0).getResCode() != null) {

										ReservoirInspect res = new ReservoirInspect();

										res.setUnitId(resObjann2.getReservoirInspectList().get(0).getUnitId());
										res.setCircleId(resObjann2.getReservoirInspectList().get(0).getCircleId());
										res.setDivisionId(resObjann2.getReservoirInspectList().get(0).getDivisionId());
										res.setSubdivisionId(
												resObjann2.getReservoirInspectList().get(0).getSubdivisionId());
										res.setProjectId(resObjann2.getReservoirInspectList().get(0).getProjectId());

										res.setUserId(resObjann2.getReservoirInspectList().get(0).getUserId());
										res.setUserName(resObjann2.getReservoirInspectList().get(0).getUserName());
										res.setDesignationId(
												resObjann2.getReservoirInspectList().get(0).getDesignationId());

										if (resObjann2.getReservoirInspectList().get(0).getDesignationId() == 2
												|| resObjann2.getReservoirInspectList().get(0)
														.getDesignationId() == 8) {

											res.setApprovStatusId(1);
										}

										res.setInspectDate(
												resObjann2.getReservoirInspectList().get(0).getInspectDate());
										res.setResCheckboxId(
												resObjann2.getReservoirInspectList().get(0).getResCheckboxId());

										res.setResCode(resObjann2.getReservoirInspectList().get(0).getResCode());

										res.setYear(resObjann2.getReservoirInspectList().get(0).getYear());
										res.setRemarks(resObjann2.getReservoirInspectList().get(0).getRemarks());
										res.setLevelId(resObjann2.getReservoirInspectList().get(0).getLevelId());
										res.setResDamHealthId(
												resObjann2.getReservoirInspectList().get(0).getResDamHealthId());
										res.setResRecommendId(
												resObjann2.getReservoirInspectList().get(0).getResRecommendId());
										res.setActionTakeninit(
												resObjann2.getReservoirInspectList().get(0).getActionTakeninit());
										res.setActionTakencomplete(
												resObjann2.getReservoirInspectList().get(0).getActionTakencomplete());

										// res.setResCategoryId(resObjann2.getReservoirInspectList().get(0).getResCategoryId());

										resAnn2daoimplObj.add(res);

										// System.out.println(res);
									}

								}
							}

						}
						if (resAnn2daoimplObj != null) {
							output = invam.insertResActiontaken(resAnn2daoimplObj);
						}

					}

				}

			}
		} catch (InventoryUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// mav.addObject("unitList", unitList);
		return new Gson().toJson(output);

	}

	@RequestMapping(value = "/invtsimis/addResdamdutyinspect")
	@ResponseBody
	public String addResdamdutyinpspect(@ModelAttribute("schedulecheckList") ScheduleDuty resscheduleObj,
			HttpServletRequest request, HttpSession session, SessionStatus status) {
		ModelAndView mav = new ModelAndView();

		// System.out.println("rescomehere");

		List<ScheduleDuty> resScheduledaoimplObj = new ArrayList<ScheduleDuty>();

		Integer output = null;

		Integer output2 = 0;

		try {
			// unitList = lam.getUnitList();

			User user = (User) session.getAttribute("userObj");

			// System.out.println("mitankObj"+mitankObj.getMiTankInspectList().size());
			// System.out.println("resObjann1"+resObjann1.getReservoirInspectList());
			if (user != null) {

				if (user.getUserId() != null && user.getUserName() != null) {

					// System.out.println("user.getUserId()"+user.getUserId()+"user.getUserName()"+user.getUserName());
					resscheduleObj.getResScheduleDutyList().get(0).setUserId(user.getUserId());

					resscheduleObj.getResScheduleDutyList().get(0).setUserName(user.getUserName());
				}

				if (resscheduleObj.getResScheduleDutyList().size() > 0) {

					int len = resscheduleObj.getResScheduleDutyList().size();

					if (resscheduleObj.getResScheduleDutyList() != null) {

						for (int i = 1; i < len; i++) {
							if (resscheduleObj.getResScheduleDutyList().get(i).getScheduleCheckboxId() != null) {
								if (resscheduleObj.getResScheduleDutyList().get(i).getScheduleCheckboxId() == 1) {

									if (resscheduleObj.getResScheduleDutyList().get(0).getResCode() != null) {

										ScheduleDuty sd = new ScheduleDuty();

										sd.setUnitId(resscheduleObj.getResScheduleDutyList().get(0).getUnitId());
										sd.setCircleId(resscheduleObj.getResScheduleDutyList().get(0).getCircleId());
										sd.setDivisionId(
												resscheduleObj.getResScheduleDutyList().get(0).getDivisionId());
										sd.setSubdivisionId(
												resscheduleObj.getResScheduleDutyList().get(0).getSubdivisionId());
										sd.setProjectId(resscheduleObj.getResScheduleDutyList().get(0).getProjectId());
										sd.setResCode(resscheduleObj.getResScheduleDutyList().get(0).getResCode());
										sd.setUserId(resscheduleObj.getResScheduleDutyList().get(0).getUserId());
										sd.setUserName(resscheduleObj.getResScheduleDutyList().get(0).getUserName());
										sd.setDesignationId(
												resscheduleObj.getResScheduleDutyList().get(0).getDesignationId());
										sd.setDutyFrequencyId(
												resscheduleObj.getResScheduleDutyList().get(0).getDutyFrequencyId());

										if (resscheduleObj.getResScheduleDutyList().get(0).getDesignationId() == 2
												|| resscheduleObj.getResScheduleDutyList().get(0)
														.getDesignationId() == 8) {

											sd.setApproveStatusId(1);
											if (resscheduleObj.getResScheduleDutyList().get(0)
													.getDutyFrequencyId() == 1) {
												sd.setInspectDate(resscheduleObj.getResScheduleDutyList().get(0)
														.getInspectDate());
											}
											if (resscheduleObj.getResScheduleDutyList().get(0)
													.getDutyFrequencyId() == 2) {
												sd.setInspectDate(resscheduleObj.getResScheduleDutyList().get(i)
														.getInspectDate());
											}
										}

										if (resscheduleObj.getResScheduleDutyList().get(0).getDesignationId() == 4) {

											sd.setApproveStatusId(2);
											sd.setInspectDate(
													resscheduleObj.getResScheduleDutyList().get(i).getInspectDate());
										}

										if (resscheduleObj.getResScheduleDutyList().get(0).getDesignationId() == 5) {

											sd.setApproveStatusId(3);
											sd.setInspectDate(
													resscheduleObj.getResScheduleDutyList().get(i).getInspectDate());
										}

										if (resscheduleObj.getResScheduleDutyList().get(0).getDesignationId() == 7) {

											sd.setApproveStatusId(4);
											sd.setInspectDate(
													resscheduleObj.getResScheduleDutyList().get(i).getInspectDate());
										}

										sd.setScheduleCheckboxId(
												resscheduleObj.getResScheduleDutyList().get(i).getScheduleCheckboxId());
										sd.setDutyId(resscheduleObj.getResScheduleDutyList().get(i).getDutyId());
										sd.setParentDutyId(
												resscheduleObj.getResScheduleDutyList().get(i).getParentDutyId());

										sd.setRemarks(resscheduleObj.getResScheduleDutyList().get(i).getRemarks());
										sd.setActionId(resscheduleObj.getResScheduleDutyList().get(i).getActionId());
										sd.setActionReqId(
												resscheduleObj.getResScheduleDutyList().get(i).getActionReqId());
										sd.setDutyDesignationMapId(resscheduleObj.getResScheduleDutyList().get(i)
												.getDutyDesignationMapId());

										resScheduledaoimplObj.add(sd);

										// System.out.println(res);
									}

								}
							}
						}
					}
				}

				// System.out.println("MiTankdaoimplObj"+MiTankdaoimplObj.size());

				if (resScheduledaoimplObj != null) {

					if (resScheduledaoimplObj.size() > 0) {

						if (resScheduledaoimplObj.get(0).getResCode() != null) {

							output = invam.insertResDamDutyinspect(resScheduledaoimplObj);

							// System.out.println(output);

						}

					}

				}

			}
		} catch (InventoryUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// mav.addObject("unitList", unitList);
		return new Gson().toJson(output);

	}

	@RequestMapping(value = "/invtsimis/pump-maintain-activity")
	@ResponseBody
	public String pumpmaintainactivity(@ModelAttribute("pumpactivityList") PumpMaintainActivities pumpObj,
			HttpServletRequest request, HttpSession session, SessionStatus status) {
		ModelAndView mav = new ModelAndView();

		// System.out.println("rescomehere");

		List<PumpMaintainActivities> pumpdaoimpl = new ArrayList<PumpMaintainActivities>();

		Integer output = 0;

		try {
			// unitList = lam.getUnitList();

			User user = (User) session.getAttribute("userObj");

			// System.out.println("mitankObj"+mitankObj.getMiTankInspectList().size());
			// System.out.println("resObjann1"+resObjann1.getReservoirInspectList());
			if (user != null) {

				if (user.getUserId() != null && user.getUserName() != null) {

					// System.out.println("user.getUserId()"+user.getUserId()+"user.getUserName()"+user.getUserName());
					pumpObj.getPumpMaintActivityList().get(0).setUserId(user.getUserId());

					pumpObj.getPumpMaintActivityList().get(0).setUserName(user.getUserName());
				}

				if (pumpObj.getPumpMaintActivityList().size() > 0) {

					int len = pumpObj.getPumpMaintActivityList().size();

					if (pumpObj.getPumpMaintActivityList() != null) {

						for (int i = 1; i < len; i++) {
							if (pumpObj.getPumpMaintActivityList().get(i).getCheckboxId() != null) {
								if (pumpObj.getPumpMaintActivityList().get(i).getCheckboxId() == 1) {

									if (pumpObj.getPumpMaintActivityList().get(0).getPumpStationId() != null) {

										PumpMaintainActivities sd = new PumpMaintainActivities();

										sd.setUnitId(pumpObj.getPumpMaintActivityList().get(0).getUnitId());
										sd.setCircleId(pumpObj.getPumpMaintActivityList().get(0).getCircleId());
										sd.setDivisionId(pumpObj.getPumpMaintActivityList().get(0).getDivisionId());
										sd.setSubdivisionId(
												pumpObj.getPumpMaintActivityList().get(0).getSubdivisionId());
										sd.setProjectId(pumpObj.getPumpMaintActivityList().get(0).getProjectId());

										sd.setUserId(pumpObj.getPumpMaintActivityList().get(0).getUserId());
										sd.setUserName(pumpObj.getPumpMaintActivityList().get(0).getUserName());
										sd.setDesignationId(
												pumpObj.getPumpMaintActivityList().get(0).getDesignationId());
										sd.setDutyFrequencyId(
												pumpObj.getPumpMaintActivityList().get(0).getDutyFrequencyId());
										if (pumpObj.getPumpMaintActivityList().get(0).getInspectHour() != null) {
											sd.setInspectHour(
													pumpObj.getPumpMaintActivityList().get(0).getInspectHour());
										}
										if (pumpObj.getPumpMaintActivityList().get(0).getInspectHour() == null) {
											// System.out.println("coming
											// here");
											sd.setInspectHour(0);
										}
										if (pumpObj.getPumpMaintActivityList().get(0).getDesignationId() == 2
												|| pumpObj.getPumpMaintActivityList().get(0).getDesignationId() == 8) {

											sd.setApproveStatusId(1);
											if (pumpObj.getPumpMaintActivityList().get(0).getDutyFrequencyId() == 1) {
												sd.setInspectDate(
														pumpObj.getPumpMaintActivityList().get(0).getInspectDate());

											}
											if (pumpObj.getPumpMaintActivityList().get(0).getDutyFrequencyId() > 1) {
												sd.setInspectDate(
														pumpObj.getPumpMaintActivityList().get(i).getInspectDate());

											}
										}

										if (pumpObj.getPumpMaintActivityList().get(0).getDesignationId() == 4) {

											sd.setApproveStatusId(2);
											sd.setInspectDate(
													pumpObj.getPumpMaintActivityList().get(i).getInspectDate());
										}

										if (pumpObj.getPumpMaintActivityList().get(0).getDesignationId() == 5) {

											sd.setApproveStatusId(3);
											sd.setInspectDate(
													pumpObj.getPumpMaintActivityList().get(i).getInspectDate());
										}

										if (pumpObj.getPumpMaintActivityList().get(0).getDesignationId() == 7) {

											sd.setApproveStatusId(4);
											sd.setInspectDate(
													pumpObj.getPumpMaintActivityList().get(i).getInspectDate());
										}

										sd.setBasinId(pumpObj.getPumpMaintActivityList().get(0).getBasinId());
										sd.setPumpLinkId(pumpObj.getPumpMaintActivityList().get(0).getPumpLinkId());
										sd.setPumpStationId(
												pumpObj.getPumpMaintActivityList().get(0).getPumpStationId());

										sd.setCheckboxId(pumpObj.getPumpMaintActivityList().get(i).getCheckboxId());
										sd.setDutyFrequencyId(
												pumpObj.getPumpMaintActivityList().get(0).getDutyFrequencyId());
										sd.setPmActivityId(pumpObj.getPumpMaintActivityList().get(i).getPmActivityId());

										sd.setRemarks(pumpObj.getPumpMaintActivityList().get(i).getRemarks());

										pumpdaoimpl.add(sd);

										// System.out.println(sd);
									}

								}
							}
						}
					}
				}

				// System.out.println("MiTankdaoimplObj"+pumpdaoimpl.size());

				if (pumpdaoimpl != null) {

					if (pumpdaoimpl.size() > 0) {

						if (pumpdaoimpl.get(0).getPumpStationId() != null) {

							output = invam.insertpumpMainActivityInspect(pumpdaoimpl);

							// System.out.println(output);

						}

					}

				}

			}
		} catch (InventoryUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// mav.addObject("unitList", unitList);
		return new Gson().toJson(output);

	}

	@RequestMapping(value = "/invtsimis/canal-maintenance")
	public ModelAndView canalmaintenance(HttpServletRequest request, HttpSession session, SessionStatus status) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("canal-maintenance");
		/*
		 * List<Unit> unitList = new ArrayList<Unit>();
		 * 
		 * List<ReservoirMaintenanceChecks> rescheckann1 = new
		 * ArrayList<ReservoirMaintenanceChecks>();
		 * List<ReservoirMaintenanceChecks> rescheckann1a = new
		 * ArrayList<ReservoirMaintenanceChecks>();
		 * List<ReservoirMaintenanceChecks> rescheckann1b = new
		 * ArrayList<ReservoirMaintenanceChecks>();
		 * List<ReservoirMaintenanceChecks> rescheckann1c = new
		 * ArrayList<ReservoirMaintenanceChecks>();
		 * List<ReservoirMaintenanceChecks> rescheckann1d = new
		 * ArrayList<ReservoirMaintenanceChecks>();
		 * 
		 * 
		 * try { rescheckann1=invam.getResCheckAnn1(); unitList
		 * =lam.getUnitList();
		 * 
		 * User user = (User) session.getAttribute("userObj"); if (rescheckann1
		 * != null) { if (rescheckann1.size() > 0) {
		 * 
		 * for (int i = 0; i < rescheckann1.size(); i++) {
		 * 
		 * if (rescheckann1.get(i).getResCategoryId()== 1) {
		 * rescheckann1a.add(rescheckann1.get(i));
		 * 
		 * }
		 * 
		 * if (rescheckann1.get(i).getResCategoryId()== 2) {
		 * rescheckann1b.add(rescheckann1.get(i)); }
		 * 
		 * if (rescheckann1.get(i).getResCategoryId()== 3) {
		 * rescheckann1c.add(rescheckann1.get(i)); }
		 * 
		 * if (rescheckann1.get(i).getResCategoryId()== 4) {
		 * rescheckann1d.add(rescheckann1.get(i)); }
		 * 
		 * } } }
		 * 
		 * 
		 * } catch (InventoryUserException e) { // TODO Auto-generated catch
		 * block e.printStackTrace(); } catch (LeagalUserException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); }
		 * 
		 * mav.addObject("ann1resa", rescheckann1a); mav.addObject("ann1resb",
		 * rescheckann1b); mav.addObject("ann1resc", rescheckann1c);
		 * mav.addObject("ann1resd", rescheckann1d);
		 * 
		 * mav.addObject("unitList", unitList);
		 */
		return mav;

	}

	@RequestMapping(value = "/invtsimis/getmst2bymstyearfreq")
	@ResponseBody
	public String getmst2bymstyearfreq(Integer year, Integer miTankFreqId, Long tankId, HttpServletRequest request,
			HttpSession session, SessionStatus status) {

		List<MiTankInspect> miTankInspect = new ArrayList<MiTankInspect>();

		// List<PumpStations> pumpStationList= new ArrayList<PumpStations>();

		try {

			if (year != null && miTankFreqId != null && tankId > 0) {

				if (tankId > 0 && miTankFreqId > 0 && year > 0) {
					miTankInspect = invam.getMimst2IdByYearFreq(year, tankId, miTankFreqId);
				}

			}

			// System.out.println("resListbyId"+resListbyId);

		} catch (InventoryUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new Gson().toJson(miTankInspect);

	}
	
	
	
	
	@RequestMapping(value = "/invtsimis/getmst2bysluiceid")
	@ResponseBody
	public String getmst2bysluiceid(MiTankInspect miinspectobj, HttpServletRequest request,
			HttpSession session, SessionStatus status) {

		List<MiTankInspect> miTankInspect = new ArrayList<MiTankInspect>();
		
		List<MiTankInspect> sluiceinspectlist = new ArrayList<MiTankInspect>();

		// List<PumpStations> pumpStationList= new ArrayList<PumpStations>();

		try {
			
			if(miinspectobj!=null){

			if (miinspectobj.getYear() != null && miinspectobj.getMiTankFreqId() != null && miinspectobj.getTankId() > 0) {

				if (miinspectobj.getTankId() > 0 && miinspectobj.getMiTankFreqId() > 0 && miinspectobj.getYear() > 0) {
					miTankInspect = invam.getMimst2IdByYearFreq(miinspectobj.getYear(), miinspectobj.getTankId(), miinspectobj.getMiTankFreqId());
					
					if(miTankInspect!=null){
						for(int i=0;i<miTankInspect.size();i++){
							
							//System.out.println("miinspectobj.getTankWeirSluiceId()"+miinspectobj.getTankWeirSluiceId()+"---"+miTankInspect.get(i).getTankWeirSluiceId());
							//&& (miinspectobj.getTankWeirSluiceId()>0)
							if((miinspectobj.getTankWeirSluiceId().equals(miTankInspect.get(i).getTankWeirSluiceId()))  && (miinspectobj.getTankWeirSluiceId()>0) ){
								
							//	System.out.println("i am inside"+miinspectobj.getTankWeirSluiceId());
								
								sluiceinspectlist.add(miTankInspect.get(i));
								
							//	System.out.println("sluiceinspectlist"+sluiceinspectlist);
								
							}
							
							
						}
						
						
					}
					
					
				}

			}
			}

			// System.out.println("resListbyId"+resListbyId);

		} catch (InventoryUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new Gson().toJson(sluiceinspectlist);

	}

	/*@RequestMapping(value = "/invtsimis/miinoutresults")
	@ResponseBody
	public String getmst2bymstyearfreq(Long tankId, HttpServletRequest request, HttpSession session,
			SessionStatus status) {

		List<MiTankInspect> miTankInspect = new ArrayList<MiTankInspect>();

		// List<PumpStations> pumpStationList= new ArrayList<PumpStations>();

		try {

			if (tankId != null) {

				if (tankId > 0) {
					miTankInspect = invam.selectMiInoutBytankId(tankId);
				}

			}

			// System.out.println("resListbyId"+resListbyId);

		} catch (InventoryUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new Gson().toJson(miTankInspect);

	}*/

	@RequestMapping(value = "/invtsimis/getmirepairs")
	@ResponseBody
	public String getMiRepairs(Long tankId, HttpServletRequest request, HttpSession session, SessionStatus status) {

		List<MiTankInspect> miTankInspect = new ArrayList<MiTankInspect>();

		// List<PumpStations> pumpStationList= new ArrayList<PumpStations>();

		try {

			if (tankId != null) {

				if (tankId > 0) {
					miTankInspect = invam.getMiRepairs(tankId);
				}

			}

			// System.out.println("resListbyId"+resListbyId);

		} catch (InventoryUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new Gson().toJson(miTankInspect);

	}

	@RequestMapping(value = "/invtsimis/getMiCapacity")
	@ResponseBody
	public String getMiCapacity(Long tankId, HttpServletRequest request, HttpSession session, SessionStatus status) {

		List<MiTankInspect> miTankInspect = new ArrayList<MiTankInspect>();

		// List<PumpStations> pumpStationList= new ArrayList<PumpStations>();

		try {

			if (tankId != null) {

				if (tankId > 0) {
					miTankInspect = invam.getMiCapacity(tankId);
				}

			}

			// System.out.println("resListbyId"+resListbyId);

		} catch (InventoryUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new Gson().toJson(miTankInspect);

	}

	@RequestMapping(value = "/invtsimis/mapbox-view")
	public ModelAndView mapboxView() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("mapbox-view");
		return mav;

	}

	@RequestMapping(value = "/invtsimis/getann2inspectdata")
	@ResponseBody
	public String getann2inspectdata(Integer year, Integer freq_oper, String resCode, HttpServletRequest request,
			HttpSession session, SessionStatus status) {

		List<ReservoirInspect> resInspect = new ArrayList<ReservoirInspect>();

		// List<PumpStations> pumpStationList= new ArrayList<PumpStations>();

		try {

			if (year != null && freq_oper != null && resCode != null) {

				if (year > 0 && freq_oper > 0) {
					resInspect = invam.getResAnn2mst2InspectData(year, resCode, freq_oper);
				}

			}

			// System.out.println("resListbyId"+resListbyId);

		} catch (InventoryUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new Gson().toJson(resInspect);

	}

	@RequestMapping(value = "/invtsimis/getreshealthdata")
	@ResponseBody
	public String getreshealthdata(String resCode, HttpServletRequest request, HttpSession session,
			SessionStatus status) {

		List<ReservoirInspect> resInspect = new ArrayList<ReservoirInspect>();

		// List<PumpStations> pumpStationList= new ArrayList<PumpStations>();

		try {

			if (resCode != null) {

				resInspect = invam.getResAnn2health(resCode);

			}

			// System.out.println("resListbyId"+resListbyId);

		} catch (InventoryUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new Gson().toJson(resInspect);

	}

	@RequestMapping(value = "/invtsimis/getresrecommenddata")
	@ResponseBody
	public String getresrecommenddata(String resCode, HttpServletRequest request, HttpSession session,
			SessionStatus status) {

		List<ReservoirInspect> resInspect = new ArrayList<ReservoirInspect>();

		// List<PumpStations> pumpStationList= new ArrayList<PumpStations>();

		try {

			if (resCode != null) {

				resInspect = invam.getResAnn2Recommendations(resCode);

			}

			// System.out.println("resListbyId"+resListbyId);

		} catch (InventoryUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new Gson().toJson(resInspect);

	}

	@RequestMapping(value = "/invtsimis/getreslatestrecommend")
	@ResponseBody
	public String getreslatestrecommend(String resCode, HttpServletRequest request, HttpSession session,
			SessionStatus status) {

		List<ReservoirInspect> resInspect = new ArrayList<ReservoirInspect>();

		// List<PumpStations> pumpStationList= new ArrayList<PumpStations>();

		try {

			if (resCode != null) {

				resInspect = invam.getResAnn2latestRecommend(resCode);

			}

			// System.out.println("resListbyId"+resListbyId);

		} catch (InventoryUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new Gson().toJson(resInspect);

	}

	@RequestMapping(value = "/invtsimis/getresactiontakendata")
	@ResponseBody
	public String getresactiontakendata(String resCode, HttpServletRequest request, HttpSession session,
			SessionStatus status) {

		List<ReservoirInspect> resInspect = new ArrayList<ReservoirInspect>();

		// List<PumpStations> pumpStationList= new ArrayList<PumpStations>();

		try {

			if (resCode != null) {

				resInspect = invam.getResAnn2ActionTakenData(resCode);

			}

			// System.out.println("resListbyId"+resListbyId);

		} catch (InventoryUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new Gson().toJson(resInspect);

	}

	@RequestMapping(value = "/invtsimis/getreslatesthealth")
	@ResponseBody
	public String getreslatesthealth(String resCode, HttpServletRequest request, HttpSession session,
			SessionStatus status) {

		List<ReservoirInspect> resInspect = new ArrayList<ReservoirInspect>();

		// List<PumpStations> pumpStationList= new ArrayList<PumpStations>();

		try {

			if (resCode != null) {

				resInspect = invam.getResAnn2latesthealth(resCode);

			}

			// System.out.println("resListbyId"+resListbyId);

		} catch (InventoryUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new Gson().toJson(resInspect);

	}

	@RequestMapping(value = "/invtsimis/getann1inspectdata")
	@ResponseBody
	public String getann1inspectdata(Integer year, Integer freq_oper, Integer reservoirId, HttpServletRequest request,
			HttpSession session, SessionStatus status) {

		List<ReservoirInspect> resInspect = new ArrayList<ReservoirInspect>();

		// List<PumpStations> pumpStationList= new ArrayList<PumpStations>();

		try {

			if (year != null && freq_oper != null && reservoirId != null) {

				if (year > 0 && freq_oper > 0) {
					resInspect = invam.getResAnn1mst2InspectData(year, reservoirId, freq_oper);
				}

			}

			// System.out.println("resListbyId"+resListbyId);

		} catch (InventoryUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new Gson().toJson(resInspect);

	}

	@RequestMapping(value = "/invtsimis/getMiTankFeedData")
	@ResponseBody
	public String getMiTankFeedData(Long tankId, HttpServletRequest request, HttpSession session,
			SessionStatus status) {

		List<MiTankInspect> miTankInspect = new ArrayList<MiTankInspect>();

		// List<PumpStations> pumpStationList= new ArrayList<PumpStations>();

		try {

			if (tankId != null) {

				if (tankId > 0) {
					miTankInspect = invam.getMiTankFeedData(tankId);
				}

			}

			// System.out.println("resListbyId"+resListbyId);

		} catch (InventoryUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new Gson().toJson(miTankInspect);

	}
	
	@RequestMapping(value = "/invtsimis/getMiTankFeedRemarks")
	@ResponseBody
	public String getMiTankFeedRemarks(Long tankId,Integer empId, HttpServletRequest request, HttpSession session,
			SessionStatus status) {

		List<MiTankInspect> miTankInspect = new ArrayList<MiTankInspect>();

		// List<PumpStations> pumpStationList= new ArrayList<PumpStations>();

		try {

			if (tankId != null && empId!=null) {

				if (tankId > 0 && empId>0) {
					miTankInspect = invam.getMiTankFeedRemarks(tankId , empId);
				}

			}

			// System.out.println("resListbyId"+resListbyId);

		} catch (InventoryUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new Gson().toJson(miTankInspect);

	}

	@RequestMapping(value = "/invtsimis/submitTankFeedRemarks")
	@ResponseBody
	public String submitTankFeedRemarks(MiTankInspect mitankObj,
			HttpServletRequest request, HttpSession session, SessionStatus status) {

		//List<MiTankInspect> miTankInspect = new ArrayList<MiTankInspect>();

		//List<MiTankInspect> MiTankdaoimplObj = new ArrayList<MiTankInspect>();

		Integer output = 0;

		// List<PumpStations> pumpStationList= new ArrayList<PumpStations>();

		try {

			User user = (User) session.getAttribute("userObj");

			if (mitankObj != null) {
				//System.out.println("mitankObj"+mitankObj);
			 
				if (user != null) {

					if (user.getUserEmpId() != null || user.getUserName() != null) {

						// System.out.println("user.getUserId()"+user.getUserEmpId()+"user.getUserName()"+user.getUserName());
						mitankObj.setUserEmpId(user.getUserEmpId());

						mitankObj.setUserName(user.getUserName());

					}

					if (user.getUserId() != null) {
						mitankObj.setUserId(user.getUserId());

					} else {
						mitankObj.setUserId(0);

					}

					if (mitankObj.getMitankFeedDetailsId() > 0) {

					


				

								output = invam.insertMiTankFeedRemarks(mitankObj);
								//System.out.println("output"+output);

						
					}
				}
			}

		} catch (InventoryUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new Gson().toJson(output);

	}
	
	
	@RequestMapping(value = "/invtsimis/getMiTankCapacityRemarks")
	@ResponseBody
	public String getMiTankCapacityRemarks(Long tankId,Long postId, HttpServletRequest request, HttpSession session,
			SessionStatus status) {

		List<MiTankInspect> miTankInspect = new ArrayList<MiTankInspect>();

		// List<PumpStations> pumpStationList= new ArrayList<PumpStations>();

		try {

			if (tankId != null && postId!=null) {

				if (tankId > 0 && postId>0) {
					miTankInspect = invam.getMiTankCapacityRemarks(tankId , postId);
				}

			}

			// System.out.println("resListbyId"+resListbyId);

		} catch (InventoryUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new Gson().toJson(miTankInspect);

	}

	@RequestMapping(value = "/invtsimis/submitTankCapacityRemarks")
	@ResponseBody
	public String submitTankCapacityRemarks(MiTankInspect mitankObj,
			HttpServletRequest request, HttpSession session, SessionStatus status) {

		//List<MiTankInspect> miTankInspect = new ArrayList<MiTankInspect>();

		//List<MiTankInspect> MiTankdaoimplObj = new ArrayList<MiTankInspect>();

		Integer output = 0;

		// List<PumpStations> pumpStationList= new ArrayList<PumpStations>();

		try {

			User user = (User) session.getAttribute("userObj");

			if (mitankObj != null) {
				//System.out.println("mitankObj"+mitankObj);
			 
				if (user != null) {

					if ( user.getUserName() != null) {

						// System.out.println("user.getUserId()"+user.getUserEmpId()+"user.getUserName()"+user.getUserName());
						

						mitankObj.setUserName(user.getUserName());

					}

					if (user.getUserId() != null) {
						mitankObj.setUserId(user.getUserId());

					} else {
						mitankObj.setUserId(0);

					}

					if (mitankObj.getMitankCapacityId() > 0) {

					


				

								output = invam.insertMiTankCapacityRemarks(mitankObj);
								//System.out.println("output"+output);

						
					}
				}
			}

		} catch (InventoryUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new Gson().toJson(output);

	}
	
	@RequestMapping(value = "/invtsimis/getMiTankRepairRemarks")
	@ResponseBody
	public String getMiTankRepairRemarks(Long tankId,Long  nextPostId, HttpServletRequest request, HttpSession session,
			SessionStatus status) {

		List<MiTankInspect> miTankInspect = new ArrayList<MiTankInspect>();

		// List<PumpStations> pumpStationList= new ArrayList<PumpStations>();

		try {

			if (tankId != null && nextPostId!=null) {

				if (tankId > 0 && nextPostId>0) {
					miTankInspect = invam.getMiTankRepairsRemarks(tankId , nextPostId);
				}

			}

			// System.out.println("resListbyId"+resListbyId);

		} catch (InventoryUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new Gson().toJson(miTankInspect);

	}

	@RequestMapping(value = "/invtsimis/submitTankRepairRemarks")
	@ResponseBody
	public String submitTankRepairRemarks(MiTankInspect mitankObj,
			HttpServletRequest request, HttpSession session, SessionStatus status) {

		//List<MiTankInspect> miTankInspect = new ArrayList<MiTankInspect>();

		//List<MiTankInspect> MiTankdaoimplObj = new ArrayList<MiTankInspect>();

		Integer output = 0;

		// List<PumpStations> pumpStationList= new ArrayList<PumpStations>();

		try {

			User user = (User) session.getAttribute("userObj");

			if (mitankObj != null) {
				//System.out.println("mitankObj"+mitankObj);
			 
				if (user != null) {

					if ( user.getUserName() != null) {

						// System.out.println("user.getUserId()"+user.getUserEmpId()+"user.getUserName()"+user.getUserName());
						

						mitankObj.setUserName(user.getUserName());

					}

					if (user.getUserId() != null) {
						mitankObj.setUserId(user.getUserId());

					} else {
						mitankObj.setUserId(0);

					}

					if (mitankObj.getMitankRepairsId() > 0) {

					


				

								output = invam.insertMiTankRepairsRemarks(mitankObj);
								//System.out.println("output"+output);

						
					}
				}
			}

		} catch (InventoryUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new Gson().toJson(output);

	}
	
	
	/*@RequestMapping(value = "/invtsimis/getMiTankInOutRemarks")
	@ResponseBody
	public String getMiTankInOutRemarks(Long tankId,Integer empId, HttpServletRequest request, HttpSession session,
			SessionStatus status) {

		List<MiTankInspect> miTankInspect = new ArrayList<MiTankInspect>();

		// List<PumpStations> pumpStationList= new ArrayList<PumpStations>();

		try {

			if (tankId != null && empId!=null) {

				if (tankId > 0 && empId>0) {
					miTankInspect = invam.getMiTankInoutFlowRemarks(tankId , empId);
				}

			}

			// System.out.println("resListbyId"+resListbyId);

		} catch (InventoryUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new Gson().toJson(miTankInspect);

	}*/

	/*@RequestMapping(value = "/invtsimis/submitTankInOutRemarks")
	@ResponseBody
	public String submitTankInOutRemarks(MiTankInspect mitankObj,
			HttpServletRequest request, HttpSession session, SessionStatus status) {

		//List<MiTankInspect> miTankInspect = new ArrayList<MiTankInspect>();

		//List<MiTankInspect> MiTankdaoimplObj = new ArrayList<MiTankInspect>();

		Integer output = 0;

		// List<PumpStations> pumpStationList= new ArrayList<PumpStations>();

		try {

			User user = (User) session.getAttribute("userObj");

			if (mitankObj != null) {
				//System.out.println("mitankObj"+mitankObj);
			 
				if (user != null) {

					if (user.getUserEmpId() != null || user.getUserName() != null) {

						// System.out.println("user.getUserId()"+user.getUserEmpId()+"user.getUserName()"+user.getUserName());
						mitankObj.setUserEmpId(user.getUserEmpId());

						mitankObj.setUserName(user.getUserName());

					}

					if (user.getUserId() != null) {
						mitankObj.setUserId(user.getUserId());

					} else {
						mitankObj.setUserId(0);

					}

					if (mitankObj.getMitankInoutFlowId() > 0) {

					


				

								output = invam.insertMiTankInOutFlowRemarks(mitankObj);
								//System.out.println("output"+output);

						
					}
				}
			}

		} catch (InventoryUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new Gson().toJson(output);

	}
	*/
	
	@RequestMapping(value = "/invtsimis/getMiTankMst1Remarks")
	@ResponseBody
	public String getMiTankMst1Remarks(Integer mst1Id,Long postId, HttpServletRequest request, HttpSession session,
			SessionStatus status) {

		List<MiTankInspect> miTankInspect = new ArrayList<MiTankInspect>();

		// List<PumpStations> pumpStationList= new ArrayList<PumpStations>();
		
		 //System.out.println("kalPostId"+postId);
		 //System.out.println("mst1Id"+mst1Id);
		

		try {

			if (mst1Id != null && postId!=null ) {

				if (mst1Id > 0 && postId>0 ) {
					miTankInspect = invam.getMiTankMst1Remarks(mst1Id ,postId);
				}

			}

		

		} catch (InventoryUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new Gson().toJson(miTankInspect);

	}
	
	
	
	
	
	
	@RequestMapping(value = "/invtsimis/frm-list")
	@ResponseBody
	public String getfrmlist(MiTankformData miobj, HttpServletRequest request, HttpSession session,
			SessionStatus status) {

		List<MiTankformData> frmlistdata = new ArrayList<MiTankformData>();

		// List<PumpStations> pumpStationList= new ArrayList<PumpStations>();
		
		 //System.out.println("kalPostId"+postId);
		 //System.out.println("mst1Id"+mst1Id);
		

		try {

			if (miobj.getTankId() != null && miobj.getResId()!=null && miobj.getCanId()!=null ) {

				if (miobj.getTankId() >=0  &&  miobj.getResId()>=0 && miobj.getCanId()>=0) {
					frmlistdata = invam.getFrmSentList(miobj);
				}

			}

		

		} catch (InventoryUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new Gson().toJson(frmlistdata);

	}
	
	@RequestMapping(value = "/invtsimis/get-frm-data")
	@ResponseBody
	public String getfrmdata(Integer formDataId, HttpServletRequest request, HttpSession session,
			SessionStatus status) {

		List<MiTankformData> getFrmData = new ArrayList<MiTankformData>();

		// List<PumpStations> pumpStationList= new ArrayList<PumpStations>();
		
		 //System.out.println("kalPostId"+postId);
		// System.out.println("formdataId"+formDataId);
		

		try {

			if (formDataId != null  ) {

				if (formDataId >0  ) {
					getFrmData = invam.getFrmDataList(formDataId);
				}

			}

		
		} catch (InventoryUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new Gson().toJson(getFrmData);

	}
	
	
	@RequestMapping(value = "/invtsimis/get-frm-datail")
	@ResponseBody
	public String getfrmdatail(Integer formDataId, HttpServletRequest request, HttpSession session,
			SessionStatus status) {

		List<MiTankformData> getFrmDatail = new ArrayList<MiTankformData>();

		// List<PumpStations> pumpStationList= new ArrayList<PumpStations>();
		
		 //System.out.println("kalPostId"+postId);
		 //System.out.println("mst1Id"+mst1Id);
		

		try {

			if (formDataId != null  ) {

				if (formDataId >0  ) {
					getFrmDatail = invam.getFrmDetailList(formDataId);
				}

			}

		
		} catch (InventoryUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new Gson().toJson(getFrmDatail);

	}
	
	//@ResponseBody
	
	
	
	
	
	
	
	
		@RequestMapping(value = "/invtsimis/get-frm-docs")
	    @ResponseBody
		public String getfrmdocs(MiTankFormDocs formDataObj, HttpServletRequest request, HttpSession session,
				SessionStatus status) {
			
			//ModelAndView mav= new ModelAndView();

			List<MiTankFormDocs> getFrmDocs = new ArrayList<MiTankFormDocs>();

			// List<PumpStations> pumpStationList= new ArrayList<PumpStations>();
			
			 //System.out.println("kalPostId"+postId);
			 //System.out.println("mst1Id"+mst1Id);
			
			//mav.setViewName("form20-viewphoto");
			

			try {

				if (formDataObj != null  ) {
					
					if (formDataObj.getFormDataId() !=null ) {

					if (formDataObj.getFormDataId() >0  ) {
						getFrmDocs = invam.getFrmDocsList(formDataObj.getFormDataId());
					}
					}

				}

			
			} catch (InventoryUserException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		//	mav.addObject("form20docList",getFrmDocs);
			

			return new Gson().toJson(getFrmDocs);
					
					

		}
	
	
	@RequestMapping(value = "/invtsimis/del-frm-data")
	@ResponseBody
	public String deletefrmdata(Integer formDataId, HttpServletRequest request, HttpSession session,
			SessionStatus status) {

		MiTankformData frmData = new MiTankformData();
		List<MiTankFormDocs> frmDocs = new ArrayList<MiTankFormDocs>();

		// List<PumpStations> pumpStationList= new ArrayList<PumpStations>();
		
		 //System.out.println("kalPostId"+postId);
		 //System.out.println("mst1Id"+mst1Id);
		
		Integer output=0;
		Integer dataoutput=0;
		Integer detailoutput=0;
		Integer docoutput=0;
		User user = (User) session.getAttribute("userObj");

		try {
			
			if (user != null) {
				
				if (user.getEmpId() != null || user.getUserName() != null) {
					
				

					frmData.setUserName(user.getUserName());
				}

			if (formDataId != null  ) {

				if (formDataId >0  ) {
					
					frmData.setFormDataId(formDataId);
					dataoutput = invam.deleteFormData(frmData);
					
					if(dataoutput!=null){
						
						if(dataoutput>0){
							
							detailoutput=invam.deleteFormDetail(frmData);
							
							if(detailoutput!=null){
								
								if(detailoutput>0){
									
									docoutput=invam.deleteFormdocs(frmData);
									
								}
								
								
							}
							
						}
						
						
					}
				};

			}

			}
		} catch (InventoryUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new Gson().toJson(dataoutput);

	}
	
	
	@RequestMapping(value = "/invtsimis/del-frm-docs")
	@ResponseBody
	public String deletefrmdocs(Integer formdocId, HttpServletRequest request, HttpSession session,
			SessionStatus status) {

	
		MiTankFormDocs frmDocs = new MiTankFormDocs();

		// List<PumpStations> pumpStationList= new ArrayList<PumpStations>();
		
		 //System.out.println("kalPostId"+postId);
		 //System.out.println("mst1Id"+mst1Id);
		
	
		Integer dataoutput=0;
	
		User user = (User) session.getAttribute("userObj");

		try {
			
			if (user != null) {
				
				if (user.getEmpId() != null || user.getUserName() != null) {
					
				

					frmDocs.setUserName(user.getUserName());
				}

			if (formdocId != null  ) {

				if (formdocId >0  ) {
					
					frmDocs.setFormdocId(formdocId);
					
					//System.out.println("formdocId"+formdocId);
					dataoutput = invam.deleteFormdocsbydocId(frmDocs);
					
					
				};

			}

			}
		} catch (InventoryUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new Gson().toJson(dataoutput);

	}
	
	
	
	
	@RequestMapping(value = "/invtsimis/insertMst1Remarks")
	@ResponseBody
	public String insertMiTankMst1Remarks(MiTankInspect miobj, HttpServletRequest request, HttpSession session,
			SessionStatus status) {

		List<MiTankInspect> miTankInspect = new ArrayList<MiTankInspect>();

		// List<PumpStations> pumpStationList= new ArrayList<PumpStations>();
		Integer output=0;

		try {

			if (miobj!=null ) {
				
				User user = (User) session.getAttribute("userObj");

				if (miobj != null) {
					//System.out.println("mitankObj"+mitankObj);
				 
					if (user != null) {

						if ( user.getUserName() != null) {

							// System.out.println("user.getUserId()"+user.getUserEmpId()+"user.getUserName()"+user.getUserName());
							//miobj.setUserEmpId(user.getUserEmpId());

							miobj.setUserName(user.getUserName());

						}

						if (user.getUserId() != null) {
							miobj.setUserId(user.getUserId());

						} else {
							miobj.setUserId(0);

						}
                  
			//	 System.out.println("resListbyId"+miobj.getMiInpsectMst1Id()+"--"+miobj.getEmpId()+"--"+ miobj.getTabId());
						
				if (miobj.getMiInpsectMst1Id() > 0 && miobj.getEmpId()>0 && miobj.getTabId()>0) {
				//	System.out.println("tab id"+ miobj.getTabId());
					output = invam.insertMiTankMst1Remarks(miobj);
				}

			}
				}
			}

			// System.out.println("resListbyId"+resListbyId);

		} catch (InventoryUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new Gson().toJson(output);

	}
	
	
	@RequestMapping(value = "/invtsimis/delete-Mtank1")
	@ResponseBody
	public String deleteMiTankMst1(MiTankInspect miobj, HttpServletRequest request, HttpSession session,
			SessionStatus status) {

		List<MiTankInspect> miTankInspect = new ArrayList<MiTankInspect>();

		// List<PumpStations> pumpStationList= new ArrayList<PumpStations>();
		Integer output=0;

		try {

			if (miobj!=null ) {
				
				User user = (User) session.getAttribute("userObj");

				if (miobj != null) {
					//System.out.println("mitankObj"+mitankObj);
				 
					if (user != null) {

						if (user.getUserEmpId() != null || user.getUserName() != null) {

							// System.out.println("user.getUserId()"+user.getUserEmpId()+"user.getUserName()"+user.getUserName());
							miobj.setUserEmpId(user.getUserEmpId());

							miobj.setUserName(user.getUserName());

						}

						if (user.getUserId() != null) {
							miobj.setUserId(user.getUserId());

						} else {
							miobj.setUserId(0);

						}

				if (miobj.getMiInpsectMst1Id() > 0 &&  miobj.getTabId()>0) {
					output = invam.deleteMiTankMst1(miobj);
				}

			}
				}
			}

			// System.out.println("resListbyId"+resListbyId);

		} catch (InventoryUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new Gson().toJson(output);

	}
	
	@RequestMapping(value = "/invtsimis/delete-Mtank1-Remarks")
	@ResponseBody
	public String deleteMiTankMst1Remarks(MiTankInspect miobj, HttpServletRequest request, HttpSession session,
			SessionStatus status) {

		List<MiTankInspect> miTankInspect = new ArrayList<MiTankInspect>();

		// List<PumpStations> pumpStationList= new ArrayList<PumpStations>();
		Integer output=0;

		try {

			if (miobj!=null ) {
				
				User user = (User) session.getAttribute("userObj");

				if (miobj != null) {
					//System.out.println("mitankObj"+mitankObj);
				 
					if (user != null) {

						if (user.getUserEmpId() != null || user.getUserName() != null) {

							// System.out.println("user.getUserId()"+user.getUserEmpId()+"user.getUserName()"+user.getUserName());
							miobj.setUserEmpId(user.getUserEmpId());

							miobj.setUserName(user.getUserName());

						}

						if (user.getUserId() != null) {
							miobj.setUserId(user.getUserId());

						} else {
							miobj.setUserId(0);

						}

				if (miobj.getMiInpsectMst1IdReviewId() > 0 &&  miobj.getTabId()>0) {
					output = invam.deleteMiTankMst1Remarks(miobj);
				}

			}
				}
			}

			// System.out.println("resListbyId"+resListbyId);

		} catch (InventoryUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new Gson().toJson(output);

	}
	
	@RequestMapping(value = "/invtsimis/delete-Mtank2")
	@ResponseBody
	public String deleteMiTankMst2(MiTankInspect miobj, HttpServletRequest request, HttpSession session,
			SessionStatus status) {

		List<MiTankInspect> miTankInspect = new ArrayList<MiTankInspect>();

		// List<PumpStations> pumpStationList= new ArrayList<PumpStations>();
		Integer output=0;

		try {

			if (miobj!=null ) {
				
				User user = (User) session.getAttribute("userObj");

				if (miobj != null) {
					//System.out.println("mitankObj"+mitankObj);
				 
					if (user != null) {

						if (user.getUserEmpId() != null || user.getUserName() != null) {

							// System.out.println("user.getUserId()"+user.getUserEmpId()+"user.getUserName()"+user.getUserName());
							miobj.setUserEmpId(user.getUserEmpId());

							miobj.setUserName(user.getUserName());

						}

						if (user.getUserId() != null) {
							miobj.setUserId(user.getUserId());

						} else {
							miobj.setUserId(0);

						}

				if (miobj.getMiInpsectMst2Id() > 0 &&  miobj.getTabId()>0) {
					output = invam.deleteMiTankMst2(miobj);
				}

			}
				}
			}

			// System.out.println("resListbyId"+resListbyId);

		} catch (InventoryUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new Gson().toJson(output);

	}
	
	@RequestMapping(value = "/invtsimis/delete-Mtank-Feed")
	@ResponseBody
	public String deleteMitankFeedDetails(MiTankInspect miobj, HttpServletRequest request, HttpSession session,
			SessionStatus status) {

		List<MiTankInspect> miTankInspect = new ArrayList<MiTankInspect>();

		// List<PumpStations> pumpStationList= new ArrayList<PumpStations>();
		Integer output=0;

		try {

			if (miobj!=null ) {
				
				User user = (User) session.getAttribute("userObj");

				if (miobj != null) {
					//System.out.println("mitankObj"+mitankObj);
				 
					if (user != null) {

						if (user.getUserEmpId() != null || user.getUserName() != null) {

							// System.out.println("user.getUserId()"+user.getUserEmpId()+"user.getUserName()"+user.getUserName());
							miobj.setUserEmpId(user.getUserEmpId());

							miobj.setUserName(user.getUserName());

						}

						if (user.getUserId() != null) {
							miobj.setUserId(user.getUserId());

						} else {
							miobj.setUserId(0);

						}

				if (miobj.getMitankFeedDetailsId()>0 &&  miobj.getTabId()>0) {
					output = invam.deleteMitankFeedDetails(miobj);
				}

			}
				}
			}

			// System.out.println("resListbyId"+resListbyId);

		} catch (InventoryUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new Gson().toJson(output);

	}
	
	@RequestMapping(value = "/invtsimis/delete-Mtank-Feed-Remarks")
	@ResponseBody
	public String deleteMitankFeedRemarks(MiTankInspect miobj, HttpServletRequest request, HttpSession session,
			SessionStatus status) {

		List<MiTankInspect> miTankInspect = new ArrayList<MiTankInspect>();

		// List<PumpStations> pumpStationList= new ArrayList<PumpStations>();
		Integer output=0;

		try {

			if (miobj!=null ) {
				
				User user = (User) session.getAttribute("userObj");

				if (miobj != null) {
					//System.out.println("mitankObj"+mitankObj);
				 
					if (user != null) {

						if (user.getUserEmpId() != null || user.getUserName() != null) {

							// System.out.println("user.getUserId()"+user.getUserEmpId()+"user.getUserName()"+user.getUserName());
							miobj.setUserEmpId(user.getUserEmpId());

							miobj.setUserName(user.getUserName());

						}

						if (user.getUserId() != null) {
							miobj.setUserId(user.getUserId());

						} else {
							miobj.setUserId(0);

						}

				if (miobj.getMitankFeedReviewId()>0 &&  miobj.getTabId()>0) {
					output = invam.deleteMitankFeedRemarks(miobj);
				}

			}
				}
			}

			// System.out.println("resListbyId"+resListbyId);

		} catch (InventoryUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new Gson().toJson(output);

	}
	
	@RequestMapping(value = "/invtsimis/delete-Mtank-Capacity")
	@ResponseBody
	public String deleteMitankCapacity(MiTankInspect miobj, HttpServletRequest request, HttpSession session,
			SessionStatus status) {

		List<MiTankInspect> miTankInspect = new ArrayList<MiTankInspect>();

		// List<PumpStations> pumpStationList= new ArrayList<PumpStations>();
		Integer output=0;

		try {

			if (miobj!=null ) {
				
				User user = (User) session.getAttribute("userObj");

				if (miobj != null) {
					//System.out.println("mitankObj"+mitankObj);
				 
					if (user != null) {

						if (user.getUserEmpId() != null || user.getUserName() != null) {

							// System.out.println("user.getUserId()"+user.getUserEmpId()+"user.getUserName()"+user.getUserName());
							miobj.setUserEmpId(user.getUserEmpId());

							miobj.setUserName(user.getUserName());

						}

						if (user.getUserId() != null) {
							miobj.setUserId(user.getUserId());

						} else {
							miobj.setUserId(0);

						}

				if (miobj.getMitankCapacityId()>0 &&  miobj.getTabId()>0) {
					output = invam.deleteMitankCapacity(miobj);
				}

			}
				}
			}

			// System.out.println("resListbyId"+resListbyId);

		} catch (InventoryUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new Gson().toJson(output);

	}
	
	@RequestMapping(value = "/invtsimis/delete-Mtank-Capacity-Remarks")
	@ResponseBody
	public String deleteMitankCapacityRemarks(MiTankInspect miobj, HttpServletRequest request, HttpSession session,
			SessionStatus status) {

		List<MiTankInspect> miTankInspect = new ArrayList<MiTankInspect>();

		// List<PumpStations> pumpStationList= new ArrayList<PumpStations>();
		Integer output=0;

		try {

			if (miobj!=null ) {
				
				User user = (User) session.getAttribute("userObj");

				if (miobj != null) {
					//System.out.println("mitankObj"+mitankObj);
				 
					if (user != null) {

						if (user.getUserEmpId() != null || user.getUserName() != null) {

							// System.out.println("user.getUserId()"+user.getUserEmpId()+"user.getUserName()"+user.getUserName());
							miobj.setUserEmpId(user.getUserEmpId());

							miobj.setUserName(user.getUserName());

						}

						if (user.getUserId() != null) {
							miobj.setUserId(user.getUserId());

						} else {
							miobj.setUserId(0);

						}

				if (miobj.getMitankCapacityReviewId()>0 &&  miobj.getTabId()>0) {
					output = invam.deleteMitankCapacityRemarks(miobj);
				}

			}
				}
			}

			// System.out.println("resListbyId"+resListbyId);

		} catch (InventoryUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new Gson().toJson(output);

	}
	
	/*@RequestMapping(value = "/invtsimis/delete-Mtank-Inoutflow")
	@ResponseBody
	public String deleteMitankInoutFlow(MiTankInspect miobj, HttpServletRequest request, HttpSession session,
			SessionStatus status) {

		List<MiTankInspect> miTankInspect = new ArrayList<MiTankInspect>();

		// List<PumpStations> pumpStationList= new ArrayList<PumpStations>();
		Integer output=0;

		try {

			if (miobj!=null ) {
				
				User user = (User) session.getAttribute("userObj");

				if (miobj != null) {
					//System.out.println("mitankObj"+mitankObj);
				 
					if (user != null) {

						if (user.getUserEmpId() != null || user.getUserName() != null) {

							// System.out.println("user.getUserId()"+user.getUserEmpId()+"user.getUserName()"+user.getUserName());
							miobj.setUserEmpId(user.getUserEmpId());

							miobj.setUserName(user.getUserName());

						}

						if (user.getUserId() != null) {
							miobj.setUserId(user.getUserId());

						} else {
							miobj.setUserId(0);

						}

				if (miobj.getMitankInoutFlowId()>0 &&  miobj.getTabId()>0) {
					output = invam.deleteMitankInoutFlow(miobj);
				}

			}
				}
			}

			// System.out.println("resListbyId"+resListbyId);

		} catch (InventoryUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new Gson().toJson(output);

	}*/
	
	/*@RequestMapping(value = "/invtsimis/delete-Mtank-Inoutflow-Remarks")
	@ResponseBody
	public String deleteMitankInoutFlowRemarks(MiTankInspect miobj, HttpServletRequest request, HttpSession session,
			SessionStatus status) {

		List<MiTankInspect> miTankInspect = new ArrayList<MiTankInspect>();

		// List<PumpStations> pumpStationList= new ArrayList<PumpStations>();
		Integer output=0;

		try {

			if (miobj!=null ) {
				
				User user = (User) session.getAttribute("userObj");

				if (miobj != null) {
					//System.out.println("mitankObj"+mitankObj);
				 
					if (user != null) {

						if (user.getUserEmpId() != null || user.getUserName() != null) {

							// System.out.println("user.getUserId()"+user.getUserEmpId()+"user.getUserName()"+user.getUserName());
							miobj.setUserEmpId(user.getUserEmpId());

							miobj.setUserName(user.getUserName());

						}

						if (user.getUserId() != null) {
							miobj.setUserId(user.getUserId());

						} else {
							miobj.setUserId(0);

						}

				if (miobj.getMitankInoutFlowReviewId()>0 &&  miobj.getTabId()>0) {
					output = invam.deleteMitankInoutFlowRemarks(miobj);
				}

			}
				}
			}

			// System.out.println("resListbyId"+resListbyId);

		} catch (InventoryUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new Gson().toJson(output);

	}*/
	
	@RequestMapping(value = "/invtsimis/delete-Mtank-Repairs")
	@ResponseBody
	public String deleteMitankRepairs(MiTankInspect miobj, HttpServletRequest request, HttpSession session,
			SessionStatus status) {

		List<MiTankInspect> miTankInspect = new ArrayList<MiTankInspect>();

		// List<PumpStations> pumpStationList= new ArrayList<PumpStations>();
		Integer output=0;

		try {

			if (miobj!=null ) {
				
				User user = (User) session.getAttribute("userObj");

				if (miobj != null) {
					//System.out.println("mitankObj"+mitankObj);
				 
					if (user != null) {

						if (user.getUserEmpId() != null || user.getUserName() != null) {

							// System.out.println("user.getUserId()"+user.getUserEmpId()+"user.getUserName()"+user.getUserName());
							miobj.setUserEmpId(user.getUserEmpId());

							miobj.setUserName(user.getUserName());

						}

						if (user.getUserId() != null) {
							miobj.setUserId(user.getUserId());

						} else {
							miobj.setUserId(0);

						}

				if (miobj.getMitankRepairsId()>0 &&  miobj.getTabId()>0) {
					output = invam.deleteMitankRepairs(miobj);
				}

			}
				}
			}

			// System.out.println("resListbyId"+resListbyId);

		} catch (InventoryUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new Gson().toJson(output);

	}
	
	@RequestMapping(value = "/invtsimis/delete-Mtank-Repairs-Remarks")
	@ResponseBody
	public String deleteMitankRepairsRemarks(MiTankInspect miobj, HttpServletRequest request, HttpSession session,
			SessionStatus status) {

		List<MiTankInspect> miTankInspect = new ArrayList<MiTankInspect>();

		// List<PumpStations> pumpStationList= new ArrayList<PumpStations>();
		Integer output=0;

		try {

			if (miobj!=null ) {
				
				User user = (User) session.getAttribute("userObj");

				if (miobj != null) {
					//System.out.println("mitankObj"+mitankObj);
				 
					if (user != null) {

						if (user.getUserEmpId() != null || user.getUserName() != null) {

							// System.out.println("user.getUserId()"+user.getUserEmpId()+"user.getUserName()"+user.getUserName());
							miobj.setUserEmpId(user.getUserEmpId());

							miobj.setUserName(user.getUserName());

						}

						if (user.getUserId() != null) {
							miobj.setUserId(user.getUserId());

						} else {
							miobj.setUserId(0);

						}

				if (miobj.getMitankRepairsReviewId()>0 &&  miobj.getTabId()>0) {
					output = invam.deleteMitankRepairsRemarks(miobj);
				}

			}
				}
			}

			// System.out.println("resListbyId"+resListbyId);

		} catch (InventoryUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new Gson().toJson(output);

	}
	
	@RequestMapping(value = "/invtsimis/edit-Mtank-mst2")
	@ResponseBody
	public String editMiTankMst2(@ModelAttribute("editmichecks") MiTankInspect miobj, HttpServletRequest request, HttpSession session,
			SessionStatus status) {

		List<MiTankInspect> miTankInspect = new ArrayList<MiTankInspect>();

		// List<PumpStations> pumpStationList= new ArrayList<PumpStations>();
		Integer output=0;

		try {

			if (miobj!=null ) {
				
				User user = (User) session.getAttribute("userObj");

				if (miobj != null) {
					//System.out.println("mitankObj"+mitankObj);
				 
					if (user != null) {

						if (user.getUserEmpId() != null || user.getUserName() != null) {

							// System.out.println("user.getUserId()"+user.getUserEmpId()+"user.getUserName()"+user.getUserName());
							miobj.setUserEmpId(user.getUserEmpId());

							miobj.setUserName(user.getUserName());

						}

						if (user.getUserId() != null) {
							miobj.setUserId(user.getUserId());

						} else {
							miobj.setUserId(0);

						}
//System.out.println("miobj"+miobj);
//System.out.println("miobj"+miobj.getMiInpsectMst2Id()+"---"+miobj.getTabId());

if(miobj.getMiInpsectMst2Id()!=null &&  miobj.getTabId()!=null){
				if (miobj.getMiInpsectMst2Id()>0 &&  miobj.getTabId()>0) {
					
					//System.out.println("comeindise");
					output = invam.editMitankMst2(miobj);
				}
}

			}
				}
			}

			// System.out.println("resListbyId"+resListbyId);

		} catch (InventoryUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new Gson().toJson(output);

	}
	
	@RequestMapping(value = "/invtsimis/get-editdata-mst2")
	@ResponseBody
	public String getEditDataMst2(MiTankInspect miobj, HttpServletRequest request, HttpSession session,
			SessionStatus status) {

		List<MiTankInspect> miTankInspect = new ArrayList<MiTankInspect>();

		// List<PumpStations> pumpStationList= new ArrayList<PumpStations>();
		Integer output=0;

		try {

		if(miobj.getMiInpsectMst2Id()!=null){
				if (miobj.getMiInpsectMst2Id()>0 &&  miobj.getTabId()>0) {
					miTankInspect = invam.getEditMiTankMst2Checks(miobj.getMiInpsectMst2Id());
				}
		}
			
			// System.out.println("resListbyId"+resListbyId);

		} catch (InventoryUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new Gson().toJson(miTankInspect);

	}
	
	/*@RequestMapping(value = "/invtsimis/get-editin-outflow")
	@ResponseBody
	public String getEditDatainoutflow(MiTankInspect miobj, HttpServletRequest request, HttpSession session,
			SessionStatus status) {

		List<MiTankInspect> miTankInspect = new ArrayList<MiTankInspect>();

		// List<PumpStations> pumpStationList= new ArrayList<PumpStations>();
		Integer output=0;

		try {

		if(miobj.getMitankInoutFlowId()!=null){
				if (miobj.getMitankInoutFlowId()>0 &&  miobj.getTabId()>0) {
					miTankInspect = invam.getEditInoutflowTank(miobj.getMitankInoutFlowId());
				}
		}
			
			// System.out.println("resListbyId"+resListbyId);

		} catch (InventoryUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new Gson().toJson(miTankInspect);

	}*/
	
	/*@RequestMapping(value = "/invtsimis/update-inoutflow")
	@ResponseBody
	public String updateInoutflowTank(@ModelAttribute("editinoutflow") MiTankInspect miobj, HttpServletRequest request, HttpSession session,
			SessionStatus status) {

		List<MiTankInspect> miTankInspect = new ArrayList<MiTankInspect>();

		// List<PumpStations> pumpStationList= new ArrayList<PumpStations>();
		Integer output=0;

		try {

			if (miobj!=null ) {
				
				User user = (User) session.getAttribute("userObj");

				if (miobj != null) {
					//System.out.println("mitankObj"+mitankObj);
				 
					if (user != null) {

						if (user.getUserEmpId() != null || user.getUserName() != null) {

							// System.out.println("user.getUserId()"+user.getUserEmpId()+"user.getUserName()"+user.getUserName());
							miobj.setUserEmpId(user.getUserEmpId());

							miobj.setUserName(user.getUserName());

						}

						if (user.getUserId() != null) {
							miobj.setUserId(user.getUserId());

						} else {
							miobj.setUserId(0);

						}
//System.out.println("miobj"+miobj);
//System.out.println("miobj"+miobj.getMitankInoutFlowId()+"---"+miobj.getTabId());

if(miobj.getMitankInoutFlowId()!=null &&  miobj.getTabId()!=null){
				if (miobj.getMitankInoutFlowId()>0 &&  miobj.getTabId()>0) {
					
					System.out.println("comeindise");
					output = invam.UpdateInoutflowTank(miobj);
				}
}

			}
				}
			}

			// System.out.println("resListbyId"+resListbyId);

		} catch (InventoryUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new Gson().toJson(output);

	}*/
	
	@RequestMapping(value = "/invtsimis/get-edit-repairdata")
	@ResponseBody
	public String getEditDataRepair(MiTankInspect miobj, HttpServletRequest request, HttpSession session,
			SessionStatus status) {

		List<MiTankInspect> miTankInspect = new ArrayList<MiTankInspect>();

		// List<PumpStations> pumpStationList= new ArrayList<PumpStations>();
		Integer output=0;

		try {

		if(miobj.getMitankRepairsId()!=null){
				if (miobj.getMitankRepairsId()>0 &&  miobj.getTabId()>0) {
					miTankInspect = invam.getEditMiRepairs(miobj.getMitankRepairsId());
				}
		}
			
			// System.out.println("resListbyId"+resListbyId);

		} catch (InventoryUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new Gson().toJson(miTankInspect);

	}
	
	@RequestMapping(value = "/invtsimis/update-repairs")
	@ResponseBody
	public String updateRepairsTank(@ModelAttribute("editinoutflow") MiTankInspect miobj, HttpServletRequest request, HttpSession session,
			SessionStatus status) {

		List<MiTankInspect> miTankInspect = new ArrayList<MiTankInspect>();

		// List<PumpStations> pumpStationList= new ArrayList<PumpStations>();
		Integer output=0;

		try {

			if (miobj!=null ) {
				
				User user = (User) session.getAttribute("userObj");

				if (miobj != null) {
					//System.out.println("mitankObj"+mitankObj);
				 
					if (user != null) {

						if (user.getUserEmpId() != null || user.getUserName() != null) {

							// System.out.println("user.getUserId()"+user.getUserEmpId()+"user.getUserName()"+user.getUserName());
							miobj.setUserEmpId(user.getUserEmpId());

							miobj.setUserName(user.getUserName());

						}

						if (user.getUserId() != null) {
							miobj.setUserId(user.getUserId());

						} else {
							miobj.setUserId(0);

						}
//System.out.println("miobj"+miobj);
//System.out.println("miobj"+miobj.getMitankRepairsId()+"---"+miobj.getTabId());

if(miobj.getMitankRepairsId()!=null &&  miobj.getTabId()!=null){
				if (miobj.getMitankRepairsId()>0 &&  miobj.getTabId()>0) {
					
					//System.out.println("comeindise");
					output = invam.UpdateRepairsTank(miobj);
				}
}

			}
				}
			}

			// System.out.println("resListbyId"+resListbyId);

		} catch (InventoryUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new Gson().toJson(output);

	}
	
	@RequestMapping(value = "/invtsimis/get-edit-capacitydata")
	@ResponseBody
	public String getEditDataCapacity(MiTankInspect miobj, HttpServletRequest request, HttpSession session,
			SessionStatus status) {

		List<MiTankInspect> miTankInspect = new ArrayList<MiTankInspect>();

		// List<PumpStations> pumpStationList= new ArrayList<PumpStations>();
		Integer output=0;

		try {

		if(miobj.getMitankCapacityId()!=null){
				if (miobj.getMitankCapacityId()>0 &&  miobj.getTabId()>0) {
					miTankInspect = invam.getEditMiCapacity(miobj.getMitankCapacityId());
				}
		}
			
			// System.out.println("resListbyId"+resListbyId);

		} catch (InventoryUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new Gson().toJson(miTankInspect);

	}
	
	@RequestMapping(value = "/invtsimis/update-capacity")
	@ResponseBody
	public String updateCapacityTank(@ModelAttribute("editinoutflow") MiTankInspect miobj, HttpServletRequest request, HttpSession session,
			SessionStatus status) {

		List<MiTankInspect> miTankInspect = new ArrayList<MiTankInspect>();

		// List<PumpStations> pumpStationList= new ArrayList<PumpStations>();
		Integer output=0;

		try {

			if (miobj!=null ) {
				
				User user = (User) session.getAttribute("userObj");

				if (miobj != null) {
					//System.out.println("mitankObj"+mitankObj);
				 
					if (user != null) {

						if (user.getUserEmpId() != null || user.getUserName() != null) {

							// System.out.println("user.getUserId()"+user.getUserEmpId()+"user.getUserName()"+user.getUserName());
							miobj.setUserEmpId(user.getUserEmpId());

							miobj.setUserName(user.getUserName());

						}

						if (user.getUserId() != null) {
							miobj.setUserId(user.getUserId());

						} else {
							miobj.setUserId(0);

						}
//System.out.println("miobj"+miobj);
//System.out.println("miobj"+miobj.getMitankCapacityId()+"---"+miobj.getRemarks());

if(miobj.getMitankCapacityId()!=null &&  miobj.getTabId()!=null){
				if (miobj.getMitankCapacityId()>0 &&  miobj.getTabId()>0) {
					
				//	System.out.println("comeindise");
					output = invam.UpdateCapacityTank(miobj);
				}
}

			}
				}
			}

			// System.out.println("resListbyId"+resListbyId);

		} catch (InventoryUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new Gson().toJson(output);

	}
	
	
	@RequestMapping(value = "/invtsimis/get-edit-feeddata")
	@ResponseBody
	public String getEditDataFeed(MiTankInspect miobj, HttpServletRequest request, HttpSession session,
			SessionStatus status) {

		List<MiTankInspect> miTankInspect = new ArrayList<MiTankInspect>();

		// List<PumpStations> pumpStationList= new ArrayList<PumpStations>();
		Integer output=0;

		try {

		if(miobj.getMitankFeedDetailsId()!=null){
				if (miobj.getMitankFeedDetailsId()>0 &&  miobj.getTabId()>0) {
					miTankInspect = invam.getEditMiFeed(miobj.getMitankFeedDetailsId());
				}
		}
			
			// System.out.println("resListbyId"+resListbyId);

		} catch (InventoryUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new Gson().toJson(miTankInspect);

	}
	
	@RequestMapping(value = "/invtsimis/update-FeedDetails")
	@ResponseBody
	public String updateFeedDetailsTank(@ModelAttribute("editinoutflow") MiTankInspect miobj, HttpServletRequest request, HttpSession session,
			SessionStatus status) {

		List<MiTankInspect> miTankInspect = new ArrayList<MiTankInspect>();

		// List<PumpStations> pumpStationList= new ArrayList<PumpStations>();
		Integer output=0;

		try {

			if (miobj!=null ) {
				
				User user = (User) session.getAttribute("userObj");

				if (miobj != null) {
					//System.out.println("mitankObj"+mitankObj);
				 
					if (user != null) {

						if (user.getUserEmpId() != null || user.getUserName() != null) {

							// System.out.println("user.getUserId()"+user.getUserEmpId()+"user.getUserName()"+user.getUserName());
							miobj.setUserEmpId(user.getUserEmpId());

							miobj.setUserName(user.getUserName());

						}

						if (user.getUserId() != null) {
							miobj.setUserId(user.getUserId());

						} else {
							miobj.setUserId(0);

						}
//System.out.println("miobj"+miobj);
//System.out.println("miobj"+miobj.getMitankCapacityId()+"---"+miobj.getRemarks());

if(miobj.getMitankFeedDetailsId()!=null &&  miobj.getTabId()!=null){
				if (miobj.getMitankFeedDetailsId()>0 &&  miobj.getTabId()>0) {
					
				//	System.out.println("comeindise");
					output = invam.UpdateFeedTank(miobj);
				}
}

			}
				}
			}

			// System.out.println("resListbyId"+resListbyId);

		} catch (InventoryUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new Gson().toJson(output);

	}
	
	@RequestMapping(value = "/invtsimis/get-mst1-remarks")
	@ResponseBody
	public String getMst1Remarks(MiTankInspect miobj, HttpServletRequest request, HttpSession session,
			SessionStatus status) {

		List<MiTankInspect> miTankInspect = new ArrayList<MiTankInspect>();

		List<MiTankInspect> tabwiseremarks = new ArrayList<MiTankInspect>();
		// List<PumpStations> pumpStationList= new ArrayList<PumpStations>();
		Integer output=0;

		try {
	//		 System.out.println("miobj"+miobj);
		if(miobj.getMiInpsectMst1Id()!=null){
				if (miobj.getMiInpsectMst1Id()>0 ) {
					miTankInspect = invam.viewMst1Remarks(miobj.getMiInpsectMst1Id());
				}
				
				if(miobj.getTabId()!=null){
					
					if(miTankInspect!=null){
				//		 System.out.println("miTankInspect.size()"+miTankInspect.size());
						for(int i=0; i<miTankInspect.size(); i++){
							
							if(miTankInspect.get(i).getTabId()==miobj.getTabId()){
								// System.out.println("miobj.getTabId()"+miobj.getTabId());
							tabwiseremarks.add(miTankInspect.get(i));
							}
						}
					}
				}
		}
			
			// System.out.println("resListbyId"+miTankInspect);

		} catch (InventoryUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new Gson().toJson(tabwiseremarks);

	}
	
	@RequestMapping(value = "/invtsimis/insert-weir-sluice")
	@ResponseBody
	public String insertTankWeirSluice(MiTankInspect miobj, HttpServletRequest request, HttpSession session,
			SessionStatus status) {

		//List<MiTankInspect> miTankInspect = new ArrayList<MiTankInspect>();

		// List<PumpStations> pumpStationList= new ArrayList<PumpStations>();
		Integer output=0;

		try {

		if(miobj.getTankId()!=null){
				if (miobj.getTankId()>0 ) {
					output = invam.insertTankWeirSluice(miobj);
				}
		}
			
			// System.out.println("resListbyId"+resListbyId);

		} catch (InventoryUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new Gson().toJson(output);

	}
	
	@RequestMapping(value = "/invtsimis/weir-list")
	@ResponseBody
	public String getTankWeirList(Long tankId,Integer tankWeirSluiceTypeId, HttpServletRequest request, HttpSession session,
			SessionStatus status) {

		List<MiTankInspect> miTankInspect = new ArrayList<MiTankInspect>();
		
	
		
		List<MiTankInspect> weirList = new ArrayList<MiTankInspect>();
		
	
		// List<PumpStations> pumpStationList= new ArrayList<PumpStations>();
		Integer output=0;

		try {

		if(tankId!=null){
				if (tankId>0 ) {
					miTankInspect = invam.getTankWeirSluicelist(tankId);
					
					if(miTankInspect!=null){
						for(int i=0;i<miTankInspect.size();i++){
							
							
                         if(miTankInspect.get(i).getTankWeirSluiceTypeId()==2){
								
                        	 weirList.add(miTankInspect.get(i));
								
							}
							
							
							
						}
						
					}
				}
		}
			
			// System.out.println("resListbyId"+resListbyId);

		} catch (InventoryUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new Gson().toJson(weirList);

	}
	
	@RequestMapping(value = "/invtsimis/sluice-list")
	@ResponseBody
	public String getTankSluiceList(Long tankId,Integer tankWeirSluiceTypeId, HttpServletRequest request, HttpSession session,
			SessionStatus status) {

		List<MiTankInspect> miTankInspect = new ArrayList<MiTankInspect>();
		
	
		
		List<MiTankInspect> sluiceList = new ArrayList<MiTankInspect>();
		
	
		// List<PumpStations> pumpStationList= new ArrayList<PumpStations>();
		Integer output=0;

		try {

		if(tankId!=null){
				if (tankId>0 ) {
					miTankInspect = invam.getTankWeirSluicelist(tankId);
					
					if(miTankInspect!=null){
						for(int i=0;i<miTankInspect.size();i++){
							
							
                         if(miTankInspect.get(i).getTankWeirSluiceTypeId()==1){
								
                        	 sluiceList.add(miTankInspect.get(i));
								
							}
							
							
							
						}
						
					}
				}
		}
			
			// System.out.println("resListbyId"+resListbyId);

		} catch (InventoryUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new Gson().toJson(sluiceList);

	}
	
	@RequestMapping(value = "/invtsimis/tanks-capacitylist")
	@ResponseBody
	public String getTankCapacityList(Long tankId, HttpServletRequest request, HttpSession session,
			SessionStatus status) {

		List<Tanks> miTank = new ArrayList<Tanks>();
	
		// List<PumpStations> pumpStationList= new ArrayList<PumpStations>();
		Integer output=0;

		try {

		if(tankId!=null){
				if (tankId>0 ) {
					miTank = invam.getTanksCapacityBYTankId(tankId);
						
					}
				}
			
			// System.out.println("resListbyId"+resListbyId);

		} catch (InventoryUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new Gson().toJson(miTank);

	}
	
	@RequestMapping(value = "/invtsimis/update-critical-status")
	@ResponseBody
	public String updateTankCriticalStatus(@ModelAttribute("tankstatus") MiTankInspect miobj, HttpServletRequest request, HttpSession session,
			SessionStatus status) {

		List<MiTankInspect> miTankInspect = new ArrayList<MiTankInspect>();

		// List<PumpStations> pumpStationList= new ArrayList<PumpStations>();
		Integer output=0;

		try {

			if (miobj!=null ) {
				
				User user = (User) session.getAttribute("userObj");

				if (miobj != null) {
		//			System.out.println("update-critical-status miobj"+miobj);
				 
					if (user != null) {

						if (user.getUserEmpId() != null || user.getUserName() != null) {

							// System.out.println("user.getUserId()"+user.getUserEmpId()+"user.getUserName()"+user.getUserName());
							miobj.setUserEmpId(user.getUserEmpId());

							miobj.setUserName(user.getUserName());

						}

						if (user.getUserId() != null) {
							miobj.setUserId(user.getUserId());

						} else {
							miobj.setUserId(0);

						}
//System.out.println("miobj"+miobj);
//System.out.println("miobj"+miobj.getMitankCapacityId()+"---"+miobj.getRemarks());

if(miobj.getMiInpsectMst1Id()!=null ){
				if (miobj.getMiInpsectMst1Id()>0 ) {
					
		//			System.out.println("(miobj.getMiInpsectMst1Id()"+miobj.getMiInpsectMst1Id());
					output = invam.updateTankCrticalStatus(miobj);
				}
}
			}
				}
			}

//			 System.out.println("IAC updateTankCrticalStatus output"+output);

		} catch (InventoryUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new Gson().toJson(output);

	}
	
	@RequestMapping(value = "/invtsimis/add-repairdesc")
	@ResponseBody
	public String addTankRepairDesc(@ModelAttribute("repairdesc") MiTankInspect miobj, HttpServletRequest request, HttpSession session,
			SessionStatus status) {

		List<MiTankInspect> miTankInspect = new ArrayList<MiTankInspect>();

		// List<PumpStations> pumpStationList= new ArrayList<PumpStations>();
		Integer output=0;

		try {

			if (miobj!=null ) {
				
				User user = (User) session.getAttribute("userObj");

				if (miobj != null) {
					//System.out.println("mitankObj"+mitankObj);
				 
					if (user != null) {

						if (user.getUserEmpId() != null || user.getUserName() != null) {

							// System.out.println("user.getUserId()"+user.getUserEmpId()+"user.getUserName()"+user.getUserName());
							miobj.setUserEmpId(user.getUserEmpId());

							miobj.setUserName(user.getUserName());

						}

						if (user.getUserId() != null) {
							miobj.setUserId(user.getUserId());

						} else {
							miobj.setUserId(0);

						}
//System.out.println("miobj"+miobj);
						
						//System.out.println("miobj"+miobj.getRepairStartDate()+"---"+miobj.getRepairEndDate()+"miobj.getRE");

if(miobj.getTankId()!=null ){
				if (miobj.getTankId()>0 ) {
					
				//	System.out.println("comeindise");
					output = invam.insertTankRepairsDescription(miobj);
				}
}

			}
				}
			}

			// System.out.println("resListbyId"+resListbyId);

		} catch (InventoryUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new Gson().toJson(output);

	}
	
	@RequestMapping(value = "/invtsimis/repairdesc-list")
	@ResponseBody
	public String getTankRepairdesclist(Long tankId, HttpServletRequest request, HttpSession session,
			SessionStatus status) {

		List<MiTankInspect> miTankInspect = new ArrayList<MiTankInspect>();
		
	
		
		List<MiTankInspect> repairdescList = new ArrayList<MiTankInspect>();
		
	
		// List<PumpStations> pumpStationList= new ArrayList<PumpStations>();
		Integer output=0;

		try {

		if(tankId!=null){
				if (tankId>0 ) {
					repairdescList = invam.getTankRepairdescList(tankId);
					
				
				}
		}
			
			// System.out.println("resListbyId"+resListbyId);

		} catch (InventoryUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new Gson().toJson(repairdescList);

	}
	@RequestMapping(value = "/invtsimis/sluicedata-byid")
	@ResponseBody
	public String getTankSuiceNamebyId(Integer tankWeirSluiceId, HttpServletRequest request, HttpSession session,
			SessionStatus status) {
		// System.out.println("tankWeirSluiceId"+tankWeirSluiceId);
		MiTankInspect miTankInspect = new MiTankInspect();
		MiTankInspect Sluicedata = new MiTankInspect();
		Integer output=0;
		try {
		if(tankWeirSluiceId!=null){
				if (tankWeirSluiceId>0 ) {
					Sluicedata = invam.getTankSuiceNamebyId(tankWeirSluiceId);
				//	System.out.println("Sluicedata1: "+Sluicedata);
				}
		}
			// System.out.println("Sluicedata2: "+Sluicedata);

		} catch (InventoryUserException e) {
						e.printStackTrace();
		}
		return new Gson().toJson(Sluicedata);
	}
	
	
	@RequestMapping(value = "/invtsimis/update-sluicename-byid")
	@ResponseBody
	public String updateSluiceNameById(MiTankInspect miobj, HttpServletRequest request, HttpSession session,
			SessionStatus status) {

		List<MiTankInspect> miTankInspect = new ArrayList<MiTankInspect>();
		Integer output=0;
		try {
			if (miobj!=null ) {
				User user = (User) session.getAttribute("userObj");
				if (miobj != null) {
					if (user != null) {

						/*if (user.getUserEmpId() != null || user.getUserName() != null) {
							miobj.setUserEmpId(user.getUserEmpId());
							miobj.setUserName(user.getUserName());
						}

						if (user.getUserId() != null) {
							miobj.setUserId(user.getUserId());
						} else {
							miobj.setUserId(0);
						}*/

if(miobj.getTankWeirSluiceId()!=null ){
				if (miobj.getTankWeirSluiceId()>0 ) {
					// System.out.println("IAC updateSluiceNameById miobj.getTankWeirSluiceId(): "+miobj.getTankWeirSluiceId());
					output = invam.updateSluicenamebyid(miobj);
				}
}
			}
				}
			}

//		 System.out.println("IAC updateSluiceNameById output"+output);

		} catch (InventoryUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new Gson().toJson(output);

	}
	
	
	@RequestMapping(value = "/invtsimis/getmst1remarks-byreviewid")
	@ResponseBody
	public String getMst1remarksbyreviewId(Integer miInpsectMst1IdReviewId, HttpServletRequest request, HttpSession session,
			SessionStatus status) {
	//	System.out.println("miInpsectMst1IdReviewId"+miInpsectMst1IdReviewId);
		MiTankInspect miTankInspect = new MiTankInspect();
		MiTankInspect remarksData = new MiTankInspect();
		Integer output=0;
		try {
		if(miInpsectMst1IdReviewId!=null){
				if (miInpsectMst1IdReviewId>0 ) {
					remarksData = invam.getMst1remarksbyreviewId(miInpsectMst1IdReviewId);
				}
		}
			// System.out.println("remarksData"+remarksData);

		} catch (InventoryUserException e) {
						e.printStackTrace();
		}
		return new Gson().toJson(remarksData);
	}
	
	@RequestMapping(value = "/invtsimis/getCapacityremarks-byreviewid")
	@ResponseBody
	public String getCapacityremarksbyreviewid(Integer mitankCapacityReviewId, HttpServletRequest request, HttpSession session,
			SessionStatus status) {
	//	System.out.println("miInpsectMst1IdReviewId"+miInpsectMst1IdReviewId);
		MiTankInspect miTankInspect = new MiTankInspect();
		MiTankInspect remarksData = new MiTankInspect();
		Integer output=0;
		try {
		if(mitankCapacityReviewId!=null){
				if (mitankCapacityReviewId>0 ) {
					remarksData = invam.getCapacityremarksbyreviewId(mitankCapacityReviewId);
				}
		}
			// System.out.println("remarksData"+remarksData);

		} catch (InventoryUserException e) {
						e.printStackTrace();
		}
		return new Gson().toJson(remarksData);
	}
	
	@RequestMapping(value = "/invtsimis/update-Mst1remarks-byreviewid")
	@ResponseBody
	public String updateMst1RemarksByreviewId(MiTankInspect miobj, HttpServletRequest request, HttpSession session,
			SessionStatus status) {

		List<MiTankInspect> miTankInspect = new ArrayList<MiTankInspect>();
		Integer output=0;
		try {
			if (miobj!=null ) {
				User user = (User) session.getAttribute("userObj");
				if (miobj != null) {
					if (user != null) {

						if (user.getUserEmpId() != null || user.getUserName() != null) {
							miobj.setUserEmpId(user.getUserEmpId());
							miobj.setUserName(user.getUserName());
						}
	// System.out.println("IAC update-Mst1remarks-byreviewid UN"+miobj.getUserName());
						if (user.getUserId() != null) {
							miobj.setUserId(user.getUserId());
						} else {
							miobj.setUserId(0);
						}
					//	 System.out.println("IAC update-Mst1remarks-byreviewid mst1id"+miobj.getMiInpsectMst1IdReviewId());
if(miobj.getMiInpsectMst1IdReviewId()!=null ){
				if (miobj.getMiInpsectMst1IdReviewId()>0 ) {
					output = invam.updateMst1remarksByreviewid(miobj);
				}
}
			}
				}
			}

		//	 System.out.println("IAC update-Mst1remarks-byreviewid output"+output);

		} catch (InventoryUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new Gson().toJson(output);

	}
	
	
	@RequestMapping(value = "/invtsimis/update-MstCapacityremarks-byreviewid")
	@ResponseBody
	public String updateMstCapacityRemarksByreviewId(MiTankInspect miobj, HttpServletRequest request, HttpSession session,
			SessionStatus status) {

		List<MiTankInspect> miTankInspect = new ArrayList<MiTankInspect>();
		Integer output=0;
		try {
			if (miobj!=null ) {
				User user = (User) session.getAttribute("userObj");
				if (miobj != null) {
					if (user != null) {

						if (user.getUserEmpId() != null || user.getUserName() != null) {
							miobj.setUserEmpId(user.getUserEmpId());
							miobj.setUserName(user.getUserName());
						}
	// System.out.println("IAC update-Mst1remarks-byreviewid UN"+miobj.getUserName());
						// System.out.println("IAC update-Mst1remarks-byreviewid UN"+user.getUserName()+miobj.getMitankCapacityReviewId());
						if (user.getUserId() != null) {
							miobj.setUserId(user.getUserId());
						} else {
							miobj.setUserId(0);
						}
					//	 System.out.println("IAC update-Mst1remarks-byreviewid mst1id"+miobj.getMiInpsectMst1IdReviewId());
if(miobj.getMitankCapacityReviewId()!=null ){
				if (miobj.getMitankCapacityReviewId()>0 ) {
					output = invam.updateMstCapacityremarksByreviewid(miobj);
				}
}
			}
				}
			}

		//	 System.out.println("IAC update-Mst1remarks-byreviewid output"+output);

		} catch (InventoryUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new Gson().toJson(output);

	}
	
	@RequestMapping(value = "/invtsimis/repairdata-byid")
	@ResponseBody
	public String getTankRepairdatabyId(Integer repairdescId, HttpServletRequest request, HttpSession session,
			SessionStatus status) {

		List<MiTankInspect> miTankInspect = new ArrayList<MiTankInspect>();
		
		List<MiTankInspect> repairdata = new ArrayList<MiTankInspect>();
	
		// List<PumpStations> pumpStationList= new ArrayList<PumpStations>();
		Integer output=0;
		try {
		if(repairdescId!=null){
				if (repairdescId>0 ) {
					repairdata = invam.getTankRepairdatabyId(repairdescId);
				}
		}
			// System.out.println("resListbyId"+resListbyId);

		} catch (InventoryUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new Gson().toJson(repairdata);
	}
	
	
	@RequestMapping(value = "/invtsimis/edit-repairdesc")
	@ResponseBody
	public String updateRepairDesc(@ModelAttribute("repairdesc") MiTankInspect miobj, HttpServletRequest request, HttpSession session,
			SessionStatus status) {

		List<MiTankInspect> miTankInspect = new ArrayList<MiTankInspect>();

		// List<PumpStations> pumpStationList= new ArrayList<PumpStations>();
		Integer output=0;

		try {

			if (miobj!=null ) {
				
				User user = (User) session.getAttribute("userObj");

				if (miobj != null) {
			//		System.out.println("mitankObj"+miobj);
				 
					if (user != null) {

						if (user.getUserEmpId() != null || user.getUserName() != null) {

							// System.out.println("user.getUserId()"+user.getUserEmpId()+"user.getUserName()"+user.getUserName());
							miobj.setUserEmpId(user.getUserEmpId());

							miobj.setUserName(user.getUserName());

						}

						if (user.getUserId() != null) {
							miobj.setUserId(user.getUserId());

						} else {
							miobj.setUserId(0);

						}
//System.out.println("miobj"+miobj);
//System.out.println("miobj"+miobj.getMitankCapacityId()+"---"+miobj.getRemarks());

if(miobj.getRepairdescId()!=null ){
				if (miobj.getRepairdescId()>0 ) {
					
			//		System.out.println("getRepairdescId"+miobj.getRepairdescId());
					output = invam.editTankRepairsDescription(miobj);
				}
}

			}
				}
			}

			// System.out.println("resListbyId"+resListbyId);

		} catch (InventoryUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new Gson().toJson(output);

	}
	
	@RequestMapping(value = "/invtsimis/delete-repairdesc")
	@ResponseBody
	public String deleteRepairDesc(@ModelAttribute("repairdesc") MiTankInspect miobj, HttpServletRequest request, HttpSession session,
			SessionStatus status) {

		List<MiTankInspect> miTankInspect = new ArrayList<MiTankInspect>();

		// List<PumpStations> pumpStationList= new ArrayList<PumpStations>();
		Integer output=0;

		try {

			if (miobj!=null ) {
				
				User user = (User) session.getAttribute("userObj");

				if (miobj != null) {
					//System.out.println("mitankObj"+mitankObj);
				 
					if (user != null) {

						if (user.getUserEmpId() != null || user.getUserName() != null) {

							// System.out.println("user.getUserId()"+user.getUserEmpId()+"user.getUserName()"+user.getUserName());
							miobj.setUserEmpId(user.getUserEmpId());

							miobj.setUserName(user.getUserName());

						}

						if (user.getUserId() != null) {
							miobj.setUserId(user.getUserId());

						} else {
							miobj.setUserId(0);

						}
//System.out.println("miobj"+miobj);
//System.out.println("miobj"+miobj.getMitankCapacityId()+"---"+miobj.getRemarks());

if(miobj.getRepairdescId()!=null ){
				if (miobj.getRepairdescId()>0 ) {
					
				//	System.out.println("comeindise");
					output = invam.deleteTankRepairsDescription(miobj);
				}
}

			}
				}
			}

			// System.out.println("resListbyId"+resListbyId);

		} catch (InventoryUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new Gson().toJson(output);

	}
	
	
	@RequestMapping(value = "/invtsimis/constlist")
	@ResponseBody
	public String getConstList(Integer districtId, HttpServletRequest request, HttpSession session,
			SessionStatus status) {

		List<Constituency> constList = new ArrayList<Constituency>();
		
	
		
		
	
		// List<PumpStations> pumpStationList= new ArrayList<PumpStations>();
		Integer output=0;

	//	System.out.println("i am here");
		try {

		if(districtId!=null){
				if (districtId>0 ) {
					
				//	System.out.println("i am here2"+districtId);
					constList = invam.getConstByDistId(districtId);
					
					
						
					}
				}
		
			
			// System.out.println("resListbyId"+resListbyId);

		} catch (InventoryUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new Gson().toJson(constList);

	}
	
	
	@RequestMapping(value = "/invtsimis/get-repair-remarks")
	@ResponseBody
	public String getRepairRemarks(MiTankInspect miobj, HttpServletRequest request, HttpSession session,
			SessionStatus status) {

		List<MiTankInspect> miTankInspect = new ArrayList<MiTankInspect>();

		// List<PumpStations> pumpStationList= new ArrayList<PumpStations>();
		Integer output=0;

		try {

		if(miobj.getMitankRepairsId()!=null){
				if (miobj.getMitankRepairsId()>0 ) {
					miTankInspect = invam.viewRepairRemarks(miobj.getMitankRepairsId());
				}
		}
			
			// System.out.println("resListbyId"+resListbyId);

		} catch (InventoryUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new Gson().toJson(miTankInspect);

	}
	
	
	@RequestMapping(value = "/invtsimis/get-capacity-remarks")
	@ResponseBody
	public String getCapacityRemarks(MiTankInspect miobj, HttpServletRequest request, HttpSession session,
			SessionStatus status) {

		List<MiTankInspect> miTankInspect = new ArrayList<MiTankInspect>();

		// List<PumpStations> pumpStationList= new ArrayList<PumpStations>();
		Integer output=0;

		try {

		if(miobj.getMitankCapacityId()!=null){
				if (miobj.getMitankCapacityId()>0 ) {
					miTankInspect = invam.viewCapacityRemarks(miobj.getMitankCapacityId());
				}
		}
			
			// System.out.println("resListbyId"+resListbyId);

		} catch (InventoryUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new Gson().toJson(miTankInspect);

	}
	
	/*@RequestMapping(value = "/invtsimis/get-inout-remarks")
	@ResponseBody
	public String getInoutRemarks(MiTankInspect miobj, HttpServletRequest request, HttpSession session,
			SessionStatus status) {

		List<MiTankInspect> miTankInspect = new ArrayList<MiTankInspect>();

		// List<PumpStations> pumpStationList= new ArrayList<PumpStations>();
		Integer output=0;

		try {

		if(miobj.getMitankInoutFlowId()!=null){
				if (miobj.getMitankInoutFlowId()>0 ) {
					miTankInspect = invam.viewInflowRemarks(miobj.getMitankInoutFlowId());
				}
		}
			
			// System.out.println("resListbyId"+resListbyId);

		} catch (InventoryUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new Gson().toJson(miTankInspect);

	}
	*/
	
	
	@RequestMapping(value = "/invtsimis/getHabitations")
	@ResponseBody
	public String getHabitaions(Habitations habitObj, HttpServletRequest request, HttpSession session, SessionStatus status) {
		ModelAndView mav = new ModelAndView();

	
		List<Habitations> habitationList = new ArrayList<Habitations>();

		try {
			if(habitObj!=null){
			habitationList = invam.getHabitations(habitObj.getdId(), habitObj.getmId(), habitObj.getvId());
			
			}

			// System.out.println("resListbyId"+resListbyId);

		} catch (InventoryUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new Gson().toJson(habitationList);

	}
	
	
	@RequestMapping(value = "/invtsimis/getsourcetanksinfo")
	@ResponseBody
	public String getSourcetanksinfo( HttpServletRequest request, HttpSession session, SessionStatus status) {
		ModelAndView mav = new ModelAndView();

	
		List<Tanks> newmktanks= new ArrayList<Tanks>();

		try {
		
				newmktanks = invam.sourceMkTanksInfo();
			
			

			// System.out.println("resListbyId"+resListbyId);

		} catch (InventoryUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new Gson().toJson(newmktanks);

	}
	
	
	
	@RequestMapping(value = "/invtsimis/getsourceEmpdiversion")
	@ResponseBody
	public String gethrmsUserlistinfo( HttpServletRequest request, HttpSession session, SessionStatus status) {
		ModelAndView mav = new ModelAndView();

	
		List<EmployeeDiversion> userList= new ArrayList<EmployeeDiversion>();

		try {
		
			userList = invam.sourceHrmsEmpDiversion();
			
			

			// System.out.println("resListbyId"+resListbyId);

		} catch (InventoryUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new Gson().toJson(userList);

	}
	
	
	@RequestMapping(value = "/invtsimis/getsourceEmpaddlcharge")
	@ResponseBody
	public String gethrmsUserAddlinfo( HttpServletRequest request, HttpSession session, SessionStatus status) {
		ModelAndView mav = new ModelAndView();

	
		List<Employee> userList= new ArrayList<Employee>();

		try {
		
			userList = invam.sourceHrmsAdditionalCharge();
			
			

			// System.out.println("resListbyId"+resListbyId);

		} catch (InventoryUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new Gson().toJson(userList);

	}
	
	
	@RequestMapping(value = "/invtsimis/getsourcesubdivisions")
	@ResponseBody
	public String gethrmssubdivinfo( HttpServletRequest request, HttpSession session, SessionStatus status) {
		ModelAndView mav = new ModelAndView();

	
		List<Subdivision> userList= new ArrayList<Subdivision>();

		try {
		
			userList = invam.sourceHrmsSubDivisionMst();
			
			

			// System.out.println("resListbyId"+resListbyId);

		} catch (InventoryUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new Gson().toJson(userList);

	}
	
	

	//start of tank-feed
	
	@RequestMapping(value = "/invtsimis/tank-feed-add")
	public ModelAndView tankfeedadd(@ModelAttribute("mitankfeedinfo") MiTankInspect mitankObj,
			HttpServletRequest request, HttpSession session) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("tank-feed");
		
		List<Tanks> tankjurisList = new ArrayList<Tanks>();
		List<Tanks> tanksList = new ArrayList<Tanks>();
		List<Tanks> anicutList = new ArrayList<Tanks>();
		List<Tanks> checkDamList = new ArrayList<Tanks>();
		
		try {
		
		User user = (User) session.getAttribute("userObj");	
	if (user != null) {
		if(user.getUnitId()!=null){
	if(user.getUnitId()>0){
		// System.out.println("tankjurlistmain");
		
			tankjurisList= invam.getTankSectionMap(user);
		
		
		if(tankjurisList!=null){
			
			if(tankjurisList.size()>0){
			
			for(int i=0; i<tankjurisList.size(); i++){
				
				if(tankjurisList.get(i).getSourceId()==2){
					
					anicutList.add(tankjurisList.get(i));
					
				}
				
                  if(tankjurisList.get(i).getSourceId()==5){
					
                	  checkDamList.add(tankjurisList.get(i));
					
				}
                  
                  if((tankjurisList.get(i).getSourceId()==0)||
                	(tankjurisList.get(i).getSourceId()==1) ||
                	(tankjurisList.get(i).getSourceId()==3)|| 
                	(tankjurisList.get(i).getSourceId()==4) ||
                	(tankjurisList.get(i).getSourceId()==6) ||
                	(tankjurisList.get(i).getSourceId()==7) ||
                	(tankjurisList.get(i).getSourceId()==8) || 
                	(tankjurisList.get(i).getSourceId()==9)){
						
                	  tanksList.add(tankjurisList.get(i));
					
				}
				
				
			}
			}
		}
	}
		}
	}
	
		} catch (InventoryUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		mav.addObject("tankjurisList", tankjurisList);
	
	mav.addObject("anicutList", anicutList);
	mav.addObject("tanksList", tanksList);
	mav.addObject("checkDamList", checkDamList);
	
		return mav;

	}
	
	
	
	@RequestMapping(value = "/invtsimis/tank-fed-get")
	public ModelAndView tankfedget(@ModelAttribute("tankfeedinfo") TankFeedDetails mitankObj,
			HttpServletRequest request, HttpSession session) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("tank-fed-get");
		
		List<TankFeedDetails> unitdata = new ArrayList<TankFeedDetails>();
		List<TankFeedDetails> circledata = new ArrayList<TankFeedDetails>();
		List<TankFeedDetails> divisiondata = new ArrayList<TankFeedDetails>();
		List<TankFeedDetails> subdivisiondata = new ArrayList<TankFeedDetails>();
		
		Integer totalcnt=0;
		Integer canfeedcnt=0;
		Integer cannotfeedcnt=0;
		
		try {
		
		User user = (User) session.getAttribute("userObj");	
	if (user != null) {
		if(user.getUnitId()!=null){
	if(user.getUnitId()>0){
		// System.out.println("tankjurlistmain");
		         unitdata=invam.getTankFedUnitMap(user);
				circledata=invam.getTankFedCircleMap(user);
				divisiondata=invam.getTankFedDivisionMap(user);
				subdivisiondata=invam.getTankFedSubdivisionMap(user);
		
				
				if(unitdata!=null){
					for(int i=0; i<unitdata.size() ;i++){
					totalcnt=totalcnt+unitdata.get(i).getTankdataCount();
					canfeedcnt=canfeedcnt+unitdata.get(i).getFeedtankCount();
					cannotfeedcnt=cannotfeedcnt+unitdata.get(i).getCannotfeedtankCount();
					}
					
					mav.addObject("totalcnt",totalcnt);
					mav.addObject("canfeedcnt",canfeedcnt);
					mav.addObject("cannotfeedcnt",cannotfeedcnt);
					
				}
		
			
	}
		}
	}
	
		} catch (InventoryUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		mav.addObject("unitdata",unitdata);
		mav.addObject("circledata",circledata);
		mav.addObject("divisiondata",divisiondata);
		mav.addObject("subdivisiondata",subdivisiondata);
		
		
		return mav;

	}
	
	
	@RequestMapping(value = "/invtsimis/tank-fed-unitmap")
	@ResponseBody
	public String tankfedunitmap(@ModelAttribute("tankfeedinfo") TankFeedDetails mitankObj,
			HttpServletRequest request, HttpSession session) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("tank-fed-get");
		
		List<TankFeedDetails> unitdata = new ArrayList<TankFeedDetails>();
		List<TankFeedDetails> circledata = new ArrayList<TankFeedDetails>();
		List<TankFeedDetails> divisiondata = new ArrayList<TankFeedDetails>();
		List<TankFeedDetails> subdivisiondata = new ArrayList<TankFeedDetails>();
		
		Integer totalcnt=0;
		Integer canfeedcnt=0;
		Integer cannotfeedcnt=0;
		
		try {
		
		User user = (User) session.getAttribute("userObj");	
	if (user != null) {
		if(user.getUnitId()!=null){
	if(user.getUnitId()>0){
		// System.out.println("tankjurlistmain");
		         unitdata=invam.getTankFedUnitMap(user);
				circledata=invam.getTankFedCircleMap(user);
				divisiondata=invam.getTankFedDivisionMap(user);
				subdivisiondata=invam.getTankFedSubdivisionMap(user);
		
				
				if(unitdata!=null){
					for(int i=0; i<unitdata.size() ;i++){
					totalcnt=totalcnt+unitdata.get(i).getTankdataCount();
					canfeedcnt=canfeedcnt+unitdata.get(i).getFeedtankCount();
					cannotfeedcnt=cannotfeedcnt+unitdata.get(i).getCannotfeedtankCount();
					}
					
					mav.addObject("totalcnt",totalcnt);
					mav.addObject("canfeedcnt",canfeedcnt);
					mav.addObject("cannotfeedcnt",cannotfeedcnt);
					
				}
		
			
	}
		}
	}
	
		} catch (InventoryUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		mav.addObject("unitdata",unitdata);
		mav.addObject("circledata",circledata);
		mav.addObject("divisiondata",divisiondata);
		mav.addObject("subdivisiondata",subdivisiondata);
		
		
		return new Gson().toJson(unitdata);

	}
	
	
	
	@RequestMapping(value = "/invtsimis/form20inputform")
	public ModelAndView form20inputform(@ModelAttribute("micheckList") MiTankInspect mitankObj,
			HttpServletRequest request, HttpSession session) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("form20-input");

		List<MitankChecks> micheks = new ArrayList<MitankChecks>();
		List<MitankComps> micomps = new ArrayList<MitankComps>();
		List<MitankComps> micompsparent = new ArrayList<MitankComps>();
		List<MitankComps> micompschild = new ArrayList<MitankComps>();

		

		List<MitankChecks> micheks1 = new ArrayList<MitankChecks>();
		List<MitankChecks> micheks2 = new ArrayList<MitankChecks>();
		List<MitankChecks> micheks3 = new ArrayList<MitankChecks>();
		

		List<EmpApprove> getempapprove = new ArrayList<EmpApprove>();
	
		
		List<Tanks> tankjurisList = new ArrayList<Tanks>();
		
		List<Tanks> tanksList = new ArrayList<Tanks>();
		List<Tanks> anicutList = new ArrayList<Tanks>();
		List<Tanks> checkDamList = new ArrayList<Tanks>();
		
		List<MiTankformData> frmsrcList= new ArrayList<MiTankformData>();

		
		
		List<Unit> unitList = new ArrayList<Unit>();
		
		List<District> tankDistrict = new ArrayList<District>();
		
		User user = (User) session.getAttribute("userObj");
		
		List<District> districts = new ArrayList<District>();
		
		

		try {
			
			
			frmsrcList=invam.getFrmIrrSrcList();
			
			districts = lam.getDistricts();
			
			mav.addObject("districtsList",districts);
			
			//unitList=        lam.getUnitList();
			
		//	 System.out.println("tankjurlist");
			if (user != null) {
				if(user.getUnitId()!=null){
			if(user.getUnitId()>0){
				// System.out.println("tankjurlistmain");
				tankjurisList= invam.getTankSectionMap(user);
				
				//System.out.println("tankjurisList"+tankjurisList);
				
				if(tankjurisList!=null){
					
					if(tankjurisList.size()>0){
					
					for(int i=0; i<tankjurisList.size(); i++){
						
						if(tankjurisList.get(i).getSourceId()==2){
							
							anicutList.add(tankjurisList.get(i));
							
						}
						
                          if(tankjurisList.get(i).getSourceId()==5){
							
                        	  checkDamList.add(tankjurisList.get(i));
							
						}
                          
                          if((tankjurisList.get(i).getSourceId()==0)||
                        	(tankjurisList.get(i).getSourceId()==1) ||
                        	(tankjurisList.get(i).getSourceId()==3)|| 
                        	(tankjurisList.get(i).getSourceId()==4) ||
                        	(tankjurisList.get(i).getSourceId()==6) ||
                        	(tankjurisList.get(i).getSourceId()==7) ||
                        	(tankjurisList.get(i).getSourceId()==8) || 
                        	(tankjurisList.get(i).getSourceId()==9) ||
                        	(tankjurisList.get(i).getSourceId()==10)||
                        	(tankjurisList.get(i).getSourceId()==11)){
  							
                        	  tanksList.add(tankjurisList.get(i));
							
						}
						
						
					}
					}
				}
			}
				}
				
				//System.out.println("user.getUnitId()"+user.getUnitId());
				
              List<Project> projectList = lam.getProjectList(user.getUnitId());
				
				List<ReservoirSalient>  reservoirList = invam.getInvomResList(user.getUnitId());
				
			
				
				
				//System.out.println("reservoirList"+reservoirList);
				
				mav.addObject("projectList", projectList);
				
				mav.addObject("reservoirList", reservoirList);
				
				
				
				
			}
		
			// System.out.println("empapprove");
			if (user != null) {
				
				EmpApprove empObj= new EmpApprove();
				
				
				empObj.setDesignationId(user.getDesignationId());	
				if(user.getUnitId()!=null){
				empObj.setUnitId(user.getUnitId());
				}
				if(user.getCircleId()!=null){
				empObj.setCircleId(user.getCircleId());
				}
				if(user.getDivisionId()!=null){
				empObj.setDivisionId(user.getDivisionId());
				}
				if(user.getSubdivisionId()!=null){
				empObj.setSubdivisionId(user.getSubdivisionId());
				}
				if(user.getSectionId()!=null){
				empObj.setSectionId(user.getSectionId());
				}
				if(empObj!=null){
				getempapprove = invam.getEmployeeApprove(empObj);
				}
				
	

				mav.addObject("getempapprove", getempapprove);
				
				
					
	
		
			}
			
			
	
			

			// System.out.println("michecks"+tanksList);
			

			mav.addObject("districtList", tankDistrict);
			
			mav.addObject("tankjurisList", tankjurisList);
			
			mav.addObject("anicutList", anicutList);
			mav.addObject("tanksList", tanksList);
			mav.addObject("checkDamList", checkDamList);
			
			
			//System.out.println("frmsrcList"+frmsrcList.size());

			// System.out.println("micompsparent");
			// System.out.println("micompschild"+micompschild);

		} catch (InventoryUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (LeagalUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

		
		mav.addObject("frmsrcList",frmsrcList);

		mav.addObject("userObj", user);
		
		//mav.addObject("unitList",unitList);

		return mav;

	}
	
	
	
	@RequestMapping(value = "/invtsimis/get-emp-approve")
	@ResponseBody
	public String getempapprove(@ModelAttribute("micheckList") MiTankInspect miObj,
			HttpServletRequest request, HttpSession session) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("form20-input");
		List<EmpApprove> getempapprove = new ArrayList<EmpApprove>();
		
		List<EmpApprove> getempapprovenew = new ArrayList<EmpApprove>();
		
		
		
		try {
		
		User user = (User) session.getAttribute("userObj");	
		if (user != null) {
			
			EmpApprove empObj= new EmpApprove();
			
			
			empObj.setDesignationId(user.getDesignationId());	
			if(user.getUnitId()!=null){
			empObj.setUnitId(user.getUnitId());
			}
			if(user.getCircleId()!=null){
			empObj.setCircleId(user.getCircleId());
			}
			if(user.getDivisionId()!=null){
			empObj.setDivisionId(user.getDivisionId());
			}
			if(user.getSubdivisionId()!=null){
			empObj.setSubdivisionId(user.getSubdivisionId());
			}
			if(user.getSectionId()!=null){
			empObj.setSectionId(user.getSectionId());
			}
			if(empObj!=null){
			getempapprove = invam.getEmployeeApprove(empObj);
			
			if(getempapprove!=null && miObj.getSelectedEmpId()!=null){
				
				//System.out.println("miObj.getSelectedEmpId()"+miObj.getSelectedEmpId());
				
				for(int i=0 ;i<getempapprove.size() ; i++){
					
					if(miObj.getSelectedEmpId().equals(getempapprove.get(i).getEmpId())){
						
						getempapprovenew.add(getempapprove.get(i));
						
					}
					
					
					
				}
				
			}
			
			
			}
			

			
			//System.out.println("getempapprovenew"+getempapprovenew);

			//mav.addObject("getempapprovenew", getempapprovenew);
			
			
				

	
		}
	
		} catch (InventoryUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return new Gson().toJson(getempapprovenew);

	}
	
	
	@RequestMapping(value = "/invtsimis/add-canals")
	@ResponseBody
	public String addcanals(@ModelAttribute("addcanalsdata") Canal canalObj,
			HttpServletRequest request, HttpSession session) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("form20-input");
		
		Integer canalId=0;
		
		Integer updatedrows=0;
	
		Boolean captOutput = false;
		
		try {
		
		User user = (User) session.getAttribute("userObj");	
		String captcha = (String) session.getAttribute("CAPTCHA2");
		//System.out.println("captcha"+captcha);
		
		if (canalObj.getCaptcha() == null || canalObj == null) {
			updatedrows=-3 ;
		}else if ((canalObj.getCaptcha() != null && captcha != null)){
			
			if ((canalObj.getCaptcha() != null && !canalObj.getCaptcha().equals(captcha))) {
				// System.out.println("coming here"+canalObj.getCaptcha());
			
				canalObj.setCaptcha("");
			
				captOutput = false;
				updatedrows=-2;

			}else if (canalObj.getCaptcha().equals(captcha)) {

				captOutput = true;

			}
			
			
			
		}
		if (captOutput == true) {	
	if (user != null) {
		if(user.getUnitId()!=null){
	if(user.getUnitId()>0){
		
		canalObj.setCreatedByUser(user.getUserName());
		canalObj.setUnitId(user.getUnitId());
		canalObj.setCircleId(user.getCircleId());
		canalObj.setDivisionId(user.getDivisionId());
		canalObj.setSubdivisionId(user.getSubdivisionId());
		
		canalObj.setSectionId(user.getSectionId());
		canalObj.setPostId(user.getPost());
		
				
				if(canalObj!=null){
					
					if(canalObj.getCanalName()!=null && canalObj.getProjectId()!=null ){
						
						if(canalObj.getCanalName().length()>0 && canalObj.getProjectId()>0 ){
							
							canalId=invam.insertform20Canals(canalObj);
							
							
							if(canalId>0){
								
							//	System.out.println("canalId"+canalId);
								
								canalObj.setCanalId(canalId);
								
					
								
								
								//System.out.println("canalObj.getUnitId()"+canalObj.getUnitId());
								
								//System.out.println("canalObj.getProjectId()"+canalObj.getProjectId());
								
								//System.out.println("canalObj.getcanalId"+canalObj.getCanalId());
								
									
									if(canalObj.getCanalId()!=null && canalObj.getProjectId()!=null && canalObj.getUnitId()!=null   ){
										
										if(canalObj.getCanalId()>0 && canalObj.getProjectId()>0 && canalObj.getUnitId()>0 ){
											
											//System.out.println("canalObj.getUnitId()"+canalObj.getUnitId());
											
											updatedrows=invam.insertform20CanalsunitMap(canalObj);
											
											
											//System.out.println("updatedrows"+updatedrows);
											
											
										}
										
										
									}
									
									
								
						
							}
							
							if(canalId==-4){
								
								updatedrows=-4;
								
							}
							
						}
						
						
					}
					
					
				}
		
			
	}
		}
	}
		}
	
		} catch (InventoryUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return new Gson().toJson(updatedrows);

	}
	
	
	@RequestMapping(value = "/invtsimis/add-canalloc")
	@ResponseBody
	public String addcanalloc(@ModelAttribute("addcanalsdata") Canal canalObj,
			HttpServletRequest request, HttpSession session) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("form20-input");
		
		Integer canallocId=0;
		
		Integer updatedrows=0;
		
		Boolean captOutput = false;
	
		
		try {
		
		User user = (User) session.getAttribute("userObj");	
		String captcha = (String) session.getAttribute("CAPTCHA3");
		
		if (canalObj.getCaptcha() == null || canalObj == null) {
			updatedrows=-3 ;
		}else if ((canalObj.getCaptcha() != null && captcha != null)){
			
			if ((canalObj.getCaptcha() != null && !canalObj.getCaptcha().equals(captcha))) {
				// System.out.println("coming here"+canalObj.getCaptcha());
			
				canalObj.setCaptcha("");
			
				captOutput = false;
				updatedrows=-2;

			}else if (canalObj.getCaptcha().equals(captcha)) {

				captOutput = true;

			}
			
			
			
		}
		
		if (captOutput == true) {	
	if (user != null) {
		if(user.getUnitId()!=null){
	if(user.getUnitId()>0){
		
		canalObj.setCreatedByUser(user.getUserName());
		canalObj.setUnitId(user.getUnitId());
		canalObj.setCircleId(user.getCircleId());
		canalObj.setDivisionId(user.getDivisionId());
		canalObj.setSubdivisionId(user.getSubdivisionId());
		
		canalObj.setSectionId(user.getSectionId());
		canalObj.setPostId(user.getPost());
		
				//System.out.println("canalObj.getCanalId()"+canalObj.getCanalId());
				if(canalObj!=null){
					
					if(canalObj.getCanalId()!=null  && canalObj.getDistrictId()!=null && canalObj.getMandalId()!=null && canalObj.getChainageFromkm()!=null && canalObj.getChainageTokm()!=null){
						
						if(canalObj.getCanalId()>0 &&  canalObj.getDistrictId()>0 && canalObj.getMandalId()>0 && canalObj.getChainageFromkm()>0.0 && canalObj.getChainageTokm()>0.0 ){
							
							updatedrows=invam.insertform20CanalsLocation(canalObj);
							
							
							
							
						}
						
						
					}
					
					
				}
		
			
	}
		}
	}
		}
	
		} catch (InventoryUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return new Gson().toJson(updatedrows);

	}
	
	
	@RequestMapping(value = "/invtsimis/get-canal-data")
	@ResponseBody
	public String getcanaldata(@ModelAttribute("getcanalsdata") Canal canalObj,
			HttpServletRequest request, HttpSession session) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("form20-input");
		
		List<Canal> canalList = new ArrayList<Canal>();
		
		
		try {
		
		User user = (User) session.getAttribute("userObj");	
	if (user != null) {
		if(user.getUnitId()!=null){
	if(user.getUnitId()>0){
		
		
				
				if(canalObj!=null){
					
					if( canalObj.getProjectId()!=null ){
						
						if( canalObj.getProjectId()>0 ){
							
							canalList=invam.getCanalsByProjectId(canalObj);
							
							
							
							
						}
						
						
					}
					
					
				}
		
			
	}
		}
	}
	
		} catch (InventoryUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return new Gson().toJson(canalList);

	}
	
	
	@RequestMapping(value = "/invtsimis/get-canalsedit")
	@ResponseBody
	public String getcanalsedit(@ModelAttribute("getcanalsloc") Canal canalObj,
			HttpServletRequest request, HttpSession session) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("form20-input");
		
		List<Canal> canalList = new ArrayList<Canal>();
		
		
		try {
		
		User user = (User) session.getAttribute("userObj");	
	if (user != null) {
		if(user.getUnitId()!=null){
	if(user.getUnitId()>0){
		
		
				
				if(canalObj!=null){
					
					if( canalObj.getProjectId()!=null ){
						
						if( canalObj.getProjectId()>0 ){
							
							canalList=invam.getCanalsByProjectedit(canalObj);
				
						}
						
						
					}
					
					
				}
		
			
	}
		}
	}
	
		} catch (InventoryUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return new Gson().toJson(canalList);

	}
	
	
	
	@RequestMapping(value = "/invtsimis/get-canalsnotinloc")
	@ResponseBody
	public String getcanalsnoinloc(@ModelAttribute("getcanalsloc") Canal canalObj,
			HttpServletRequest request, HttpSession session) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("form20-input");
		
		List<Canal> canalList = new ArrayList<Canal>();
		
		
		try {
		
		User user = (User) session.getAttribute("userObj");	
	if (user != null) {
		if(user.getUnitId()!=null){
	if(user.getUnitId()>0){
		
		
				
				if(canalObj!=null){
					
					if( canalObj.getProjectId()!=null ){
						
						if( canalObj.getProjectId()>0 ){
							
							canalList=invam.getCanalsNotInLoc(canalObj);
				
						}
						
						
					}
					
					
				}
		
			
	}
		}
	}
	
		} catch (InventoryUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return new Gson().toJson(canalList);

	}
	
	
	@RequestMapping(value = "/invtsimis/get-canalseditbycanalid")
	@ResponseBody
	public String getcanalseditbycanalId(@ModelAttribute("getcanalsloc") Canal canalObj,
			HttpServletRequest request, HttpSession session) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("form20-input");
		
		List<Canal> canalList = new ArrayList<Canal>();
		
		
		try {
		
		User user = (User) session.getAttribute("userObj");	
	if (user != null) {
		if(user.getUnitId()!=null){
	if(user.getUnitId()>0){
		
		
				
				if(canalObj!=null){
					
					if( canalObj.getCanalId()!=null ){
						
						if( canalObj.getCanalId()>0 ){
							
							canalList=invam.getCanalsByCanalIdedit(canalObj);
				
						}
						
						
					}
					
					
				}
		
			
	}
		}
	}
	
		} catch (InventoryUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return new Gson().toJson(canalList);

	}
	
	
	
	
	@RequestMapping(value = "/invtsimis/get-canal-location")
	@ResponseBody
	public String getcanallocation(@ModelAttribute("getcanalsloc") Canal canalObj,
			HttpServletRequest request, HttpSession session) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("form20-input");
		
		List<Canal> canalList = new ArrayList<Canal>();
		
		
		try {
		
		User user = (User) session.getAttribute("userObj");	
	if (user != null) {
		if(user.getUnitId()!=null){
	if(user.getUnitId()>0){
		
		
				
				if(canalObj!=null){
					
					if( canalObj.getCanalId()!=null && canalObj.getCanalLocId()!=null ){
						
						if( canalObj.getCanalId()>0  && canalObj.getCanalId()>0){
							
							canalList=invam.getform20CanLocByCanalId(canalObj);
							
							
							
							
						}
						
						
					}
					
					
				}
		
			
	}
		}
	}
	
		} catch (InventoryUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return new Gson().toJson(canalList);

	}
	
	
	
	@RequestMapping(value = "/invtsimis/get-canalslocationbylocid")
	@ResponseBody
	public String getcanalslocationbylocid(@ModelAttribute("getcanalsloc") Canal canalObj,
			HttpServletRequest request, HttpSession session) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("form20-input");
		
		List<Canal> canalList = new ArrayList<Canal>();
		
		
		try {
		
		User user = (User) session.getAttribute("userObj");	
	if (user != null) {
		if(user.getUnitId()!=null){
	if(user.getUnitId()>0){
		
		
				
				if(canalObj!=null){
					
					if( canalObj.getCanalLocId()!=null ){
						
						if( canalObj.getCanalLocId()>0 ){
							
							canalList=invam.getCanalLocationByCanallocId(canalObj);
							
							
							
							
						}
						
						
					}
					
					
				}
		
			
	}
		}
	}
	
		} catch (InventoryUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return new Gson().toJson(canalList);

	}
	
	
	@RequestMapping(value = "/invtsimis/update_canals")
	@ResponseBody
	public String updatecanals(@ModelAttribute("addcanalsdata") Canal canalObj,
			HttpServletRequest request, HttpSession session) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("form20-input");
		
		Integer canalId=0;
		
		Integer updatedrows=0;
		Boolean captOutput = false;
	
		
		try {
		
		User user = (User) session.getAttribute("userObj");	
		
		String captcha = (String) session.getAttribute("CAPTCHA2");
		if (canalObj.getCaptcha() == null || canalObj == null) {
			updatedrows=-3 ;
		}else if ((canalObj.getCaptcha() != null && captcha != null)){
			
			if ((canalObj.getCaptcha() != null && !canalObj.getCaptcha().equals(captcha))) {
				// System.out.println("coming here"+canalObj.getCaptcha());
			
				canalObj.setCaptcha("");
			
				captOutput = false;
				updatedrows=-2;

			}else if (canalObj.getCaptcha().equals(captcha)) {

				captOutput = true;

			}
			
			
			
		}
		
		if (captOutput == true) {
	if (user != null) {
		if(user.getUnitId()!=null){
	if(user.getUnitId()>0){
		
		canalObj.setCreatedByUser(user.getUserName());
		canalObj.setUnitId(user.getUnitId());
		canalObj.setCircleId(user.getCircleId());
		canalObj.setDivisionId(user.getDivisionId());
		canalObj.setSubdivisionId(user.getSubdivisionId());
		
		canalObj.setSectionId(user.getSectionId());
		canalObj.setPostId(user.getPost());
		
				
				if(canalObj!=null){
					
					if(canalObj.getCanalId()!=null  &&   canalObj.getCanalName()!=null && canalObj.getProjectId()!=null ){
						
						if(canalObj.getCanalId()>0 &&  canalObj.getCanalName().length()>0 && canalObj.getProjectId()>0 ){
							
							updatedrows=invam.updateform20Canals(canalObj);
							
							
							
							
						}
						
						
					}
					
					
				}
		
			
	}
		}
	}
		}
		} catch (InventoryUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return new Gson().toJson(updatedrows);

	}
	
	@RequestMapping(value = "/invtsimis/update_canal_location")
	@ResponseBody
	public String updatecanallocation(@ModelAttribute("addcanalsdata") Canal canalObj,
			HttpServletRequest request, HttpSession session) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("form20-input");
		
		Integer canalId=0;
		
		Integer updatedrows=0;
		Boolean captOutput = false;
		
		try {
		
		User user = (User) session.getAttribute("userObj");	
		String captcha = (String) session.getAttribute("CAPTCHA3");
		if (canalObj.getCaptcha() == null || canalObj == null) {
			updatedrows=-3 ;
		}else if ((canalObj.getCaptcha() != null && captcha != null)){
			
			if ((canalObj.getCaptcha() != null && !canalObj.getCaptcha().equals(captcha))) {
				// System.out.println("coming here"+canalObj.getCaptcha());
			
				canalObj.setCaptcha("");
			
				captOutput = false;
				updatedrows=-2;

			}else if (canalObj.getCaptcha().equals(captcha)) {

				captOutput = true;

			}
			
			
			
		}
		if (captOutput == true) {	
	if (user != null) {
		if(user.getUnitId()!=null){
	if(user.getUnitId()>0){
		
		canalObj.setCreatedByUser(user.getUserName());
		canalObj.setUnitId(user.getUnitId());
		canalObj.setCircleId(user.getCircleId());
		canalObj.setDivisionId(user.getDivisionId());
		canalObj.setSubdivisionId(user.getSubdivisionId());
		
		canalObj.setSectionId(user.getSectionId());
		canalObj.setPostId(user.getPost());
		
				
				if(canalObj!=null){
					
					//System.out.println("canalObj.getCanalLocId()"+canalObj.getCanalLocId());
				//	System.out.println("canalObj.getDistrictId()"+canalObj.getDistrictId());
					//System.out.println("canalObj.getMandalId()"+canalObj.getMandalId());
				
					if(canalObj.getCanalLocId()!=null   && canalObj.getDistrictId()!=null && canalObj.getMandalId()!=null){
						
						if(canalObj.getCanalLocId()>0 &&    canalObj.getDistrictId()>0 && canalObj.getMandalId()>0){
							
							updatedrows=invam.updateform20CanalsLocation(canalObj);
							
							
							
							
						}
						
						
					}
					
					
				}
		
			
	}
		}
	}
		}
		} catch (InventoryUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return new Gson().toJson(updatedrows);

	}
	
	
	
	@RequestMapping(value = "/invtsimis/get-res-location")
	@ResponseBody
	public String getreslocation(@ModelAttribute("addreslocdata") ReservoirSalient  resObj,
			HttpServletRequest request, HttpSession session) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("form20-input");
		
		List<ReservoirSalient> resList = new ArrayList<ReservoirSalient>();
		
		
		try {
		
		User user = (User) session.getAttribute("userObj");	
	if (user != null) {
		if(user.getUnitId()!=null){
	if(user.getUnitId()>0){
		
		
				
				if(resObj!=null){
					
					if( resObj.getReservoirId()!=null ){
						
						if( resObj.getReservoirId()>0 ){
							
							resList=invam.getform20ResLocByResId(resObj);
							
							
							
							
						}
						
						
					}
					
					
				}
				
				//System.out.println("resList"+resList.size()+resList);
				
				/*if(resList.size()==0){
					
					//System.out.println("resList"+resList.size()+resList);
					
					ReservoirSalient resnodata= new ReservoirSalient();
					
					resnodata.setResStatusId(-1);
					
					resList.add(resnodata);
					
				}*/
		
			
	}
		}
	}
	
		} catch (InventoryUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return new Gson().toJson(resList);

	}
	
	
	@RequestMapping(value = "/invtsimis/update_res_location")
	@ResponseBody
	public String updatereslocation(@ModelAttribute("addreslocdata") ReservoirSalient resObj,
			HttpServletRequest request, HttpSession session) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("form20-input");
		
	
		
		Integer updatedrows=0;
		Boolean captOutput = false;
	
		
		try {
			
			String captcha = (String) session.getAttribute("CAPTCHA2");
			
			if (resObj.getCaptcha() == null || resObj == null) {
				updatedrows=-3 ;
			}else if ((resObj.getCaptcha() != null && resObj != null)){
				
				if ((resObj.getCaptcha() != null && !resObj.getCaptcha().equals(captcha))) {
					// System.out.println("coming here"+canalObj.getCaptcha());
				
					resObj.setCaptcha("");
				
					captOutput = false;
					updatedrows=-2;

				}else if (resObj.getCaptcha().equals(captcha)) {

					captOutput = true;

				}
				
				
				
			}
		
		User user = (User) session.getAttribute("userObj");	
		
		if (captOutput == true) {	
	if (user != null) {
		if(user.getUnitId()!=null){
	if(user.getUnitId()>0){
		
		resObj.setUserName(user.getUserName());
		resObj.setUnitId(user.getUnitId());
		resObj.setCircleId(user.getCircleId());
		resObj.setDivisionId(user.getDivisionId());
		resObj.setSubdivisionId(user.getSubdivisionId());
		
		resObj.setSectionId(user.getSectionId());
		resObj.setPostId(user.getPost());
		
				
				if(resObj!=null){
					
					if(resObj.getReservoirId()!=null   && resObj.getProjectId()!=null && resObj.getDistrictId()!=null && resObj.getMandalId()!=null){
						
						if(resObj.getReservoirId()>0  && resObj.getProjectId()>0 && resObj.getDistrictId()>0 && resObj.getMandalId()>0){
							
							updatedrows=invam.updateform20ReservoirLocation(resObj);
							
							
							
							
						}
						
						
					}
					
					
				}
		
			
	}
		}
	}
		}
		} catch (InventoryUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return new Gson().toJson(updatedrows);

	}
	
	
	
	@RequestMapping(value = "/invtsimis/get_res_list_projid")
	@ResponseBody
	public String getresListbyprojId(@ModelAttribute("addreslocdata") ReservoirSalient resObj,
			HttpServletRequest request, HttpSession session) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("form20-input");
		
	
		
		Integer updatedrows=0;
		
		List<ReservoirSalient> resprojlist= new ArrayList<ReservoirSalient>();
	
		
		try {
		
		User user = (User) session.getAttribute("userObj");	
	if (user != null && resObj.getProjectId()!=null) {
		if(user.getUnitId()!=null){
			
			// System.out.println("user.getUnitId()"+user.getUnitId());
			 
			// System.out.println("resObj.getProjectId()"+resObj.getProjectId());
				
				List<ReservoirSalient>  reservoirList = invam.getInvomResList(user.getUnitId());
				
				//System.out.println("reservoirList"+reservoirList);
				
				
				if(reservoirList!=null){
					
					for(int i=0 ; i<reservoirList.size() ; i++){
						
					//	System.out.println("projid"+reservoirList.get(i).getProjectId());
						
						if(reservoirList.get(i).getProjectId()==resObj.getProjectId()){	
							
							
					resprojlist.add(reservoirList.get(i));
					
						}
					}
				}
				
				
				
				
			
				
	
		}
	}
	
		} catch (InventoryUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return new Gson().toJson(resprojlist);

	}
	
	
	@RequestMapping(value = "/invtsimis/get-districts")
	@ResponseBody
	public String getdistricts( HttpServletRequest request, HttpSession session) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("form20-input");
		
	
		
		Integer updatedrows=0;
		
		List<District> districts= new ArrayList<District>();
	
		
		try {
		
		User user = (User) session.getAttribute("userObj");	
	if (user != null ) {
		if(user.getUnitId()!=null){
			
		
				
			districts = lam.getDistricts();
			
			
				
			
				
	
		}
	}
	
		} catch (LeagalUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return new Gson().toJson(districts);

	}
	
	
	
	@RequestMapping(value = "/invtsimis/get-project-code")
	@ResponseBody
	public String getprojectCode(Integer projectId, HttpServletRequest request, HttpSession session) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("form20-input");
		
	
		
		
		
		List<Project> projects= new ArrayList<Project>();
		try {
		
		User user = (User) session.getAttribute("userObj");	
	if (user != null ) {
		if(user.getUnitId()!=null){
			
		
				
		
				projects = invam.getProjectCodesList(projectId);
			
			
				
			
				
	
		}
	}
		
		} catch (InventoryUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return new Gson().toJson(projects);

	}
	
	
	
	@RequestMapping(value = "/invtsimis/AddAnnRemarks")
	@ResponseBody
	public String AddAnnRemarks(ReservoirInspect resobj, HttpServletRequest request, HttpSession session,
			SessionStatus status) {

		List<ReservoirInspect> resInspect = new ArrayList<ReservoirInspect>();

		// List<PumpStations> pumpStationList= new ArrayList<PumpStations>();
		Integer output=0;
		Boolean captOutput = false;

		try {

			if (resobj!=null ) {
				
				User user = (User) session.getAttribute("userObj");
				String captcha = (String) session.getAttribute("CAPTCHA2");
				
				if (resobj.getCaptcha() == null || resobj.getResInspectMst1Id() == null) {
					output=-3 ;
				}else if ((resobj.getCaptcha() != null && captcha != null)){
					
					if ((resobj.getCaptcha() != null && !resobj.getCaptcha().equals(captcha))) {
						// System.out.println("coming here"+damObj.getCaptcha());
					
						resobj.setCaptcha("");
					
						captOutput = false;
						output=-2;

					}else if (resobj.getCaptcha().equals(captcha)) {

						captOutput = true;

					}
					
					
					
				}
				if (captOutput == true) {	
				if (resobj != null) {
				//	System.out.println("resobj"+resobj);
				 
					if (user != null) {

						if ( user.getUserName() != null) {

							// System.out.println("user.getUserId()"+user.getUserEmpId()+"user.getUserName()"+user.getUserName());
							//miobj.setUserEmpId(user.getUserEmpId());

							
							resobj.setUserName(user.getUserName());
							resobj.setUnitId(user.getUnitId());
							resobj.setCircleId(user.getCircleId());
							resobj.setDivisionId(user.getDivisionId());
							resobj.setSubdivisionId(user.getSubdivisionId());
							resobj.setDesignationId(user.getDesignationId());
							resobj.setSectionId(user.getSectionId());
							resobj.setEmpId(user.getEmpId());
							
							if(user.getDesignationId()==2 || user.getDesignationId()==8){
								resobj.setLevelId(0);
								
							} else if (user.getDesignationId()==4){
								
								resobj.setLevelId(1);
							}else if (user.getDesignationId()==5|| user.getDesignationId()==6){
								
								resobj.setLevelId(2);
							}
							else if (user.getDesignationId()==7){
								
								resobj.setLevelId(3);
							}else if (user.getDesignationId()==9){
								
								resobj.setLevelId(4);
							}
                              else if (user.getDesignationId()==10){
								
								resobj.setLevelId(5);
							}else{
								
							}

						}

						
		
						
				if (resobj.getResInspectMst1Id() > 0 && resobj.getUserName()!=null && resobj.getTabId()>0 && resobj.getRemarks()!=null) {
			//	System.out.println("get remarks"+ resobj.getRemarks());
					if(resobj.getRemarks().length()>0){
					output = invam.AddAnnRemarks(resobj);
					}
				}else{
					output=-1;
					
				}

			}
				}
				}
			}

			// System.out.println("resListbyId"+resListbyId);

		} catch (InventoryUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new Gson().toJson(output);

	}
	
	
	@RequestMapping(value = "/invtsimis/AddNrldInspectionInfo")
	@ResponseBody
	public String AddNrldInspectionInfo(ReservoirInspect resobj, HttpServletRequest request, HttpSession session,
			SessionStatus status) {

		List<ReservoirInspect> resInspect = new ArrayList<ReservoirInspect>();
		
		MstOutputWithFlag  mstOutputWithFlag= new MstOutputWithFlag(); 
		
		ReservoirInspect res= new ReservoirInspect();

		// List<PumpStations> pumpStationList= new ArrayList<PumpStations>();
		Integer output=0;
		
		
		
		
		
		Boolean captOutput = false;

		try {

			if (resobj!=null ) {
				
				User user = (User) session.getAttribute("userObj");
				String captcha = (String) session.getAttribute("CAPTCHA");
				
				if (resobj.getCaptcha() == null || resobj.getTabId() == null) {
					output=-3 ;
				}else if ((resobj.getCaptcha() != null && captcha != null)){
					
					if ((resobj.getCaptcha() != null && !resobj.getCaptcha().equals(captcha))) {
						// System.out.println("coming here"+damObj.getCaptcha());
					
						resobj.setCaptcha("");
					
						captOutput = false;
						output=-2;

					}else if (resobj.getCaptcha().equals(captcha)) {

						captOutput = true;

					}
					
					
					
				}
				if (captOutput == true) {	
				if (resobj != null) {
				//	System.out.println("resobj"+resobj);
				 
					if (user != null) {
						
						

						if ( user.getUserName() != null) {

							// System.out.println("user.getUserId()"+user.getUserEmpId()+"user.getUserName()"+user.getUserName());
							//miobj.setUserEmpId(user.getUserEmpId());

							
							resobj.setUserName(user.getUserName());
							resobj.setUnitId(user.getUnitId());
							resobj.setCircleId(user.getCircleId());
							resobj.setDivisionId(user.getDivisionId());
							resobj.setSubdivisionId(user.getSubdivisionId());
							resobj.setDesignationId(user.getDesignationId());
							resobj.setSectionId(user.getSectionId());
							resobj.setEmpId(user.getEmpId());
							resobj.setPostId(user.getPost());
							
							if(user.getDesignationId()==2 || user.getDesignationId()==8){
								resobj.setLevelId(0);
								
							} else if (user.getDesignationId()==4){
								
								resobj.setLevelId(1);
							}else if (user.getDesignationId()==5|| user.getDesignationId()==6){
								
								resobj.setLevelId(2);
							}
							else if (user.getDesignationId()==7){
								
								resobj.setLevelId(3);
							}else if (user.getDesignationId()==9){
								
								resobj.setLevelId(4);
							}
                              else if (user.getDesignationId()==10){
								
								resobj.setLevelId(5);
							}else{
								
							}

						}
						
						
						if (resobj.getTabId()>0) {

							
							res.setUnitId(resobj.getUnitId());
							res.setCircleId(resobj.getCircleId());
							res.setDivisionId(
									resobj.getDivisionId());
							res.setSubdivisionId(
									resobj.getSubdivisionId());
							res.setProjectId(
									resobj.getProjectId());

						
							res.setUserName(resobj.getUserName());
							res.setDesignationId(
									resobj.getDesignationId());

							if (resobj.getDesignationId() == 2
									|| resobj.getDesignationId() == 8) {

								res.setApprovStatusId(1);
							}

							
							res.setResCheckId(
									resobj.getResCheckId());
							res.setResCatId(resobj.getResCatId());

						

							res.setYear(resobj.getYear());
							res.setRemarks(resobj.getRemarks());

							res.setDutyFrequencyId(
									resobj.getDutyFrequencyId());
							
							res.setSectionId(resobj.getSectionId());
					
							res.setPostId(resobj.getPostId());
							res.setNextPostId(resobj.getNextPostId());
							res.setNextEmpId(resobj.getNextEmpId());
							res.setEmpId(resobj.getEmpId());
							res.setTabId(resobj.getTabId());
							
						
							res.setReservoirId(resobj.getReservoirId());
							
							res.setAnnexureId(resobj.getAnnexureId());
							
							res.setTankId(resobj.getTankId());
							
						
							
							res.setResCheckAddFlag(true);
							
							res.setConditionofDamId(resobj.getConditionofDamId());
							
							res.setInspectdesignationId(resobj.getInspectdesignationId());
							

		

		if (res != null) {

		

				if (res.getReservoirId() != null) {
					
				

					mstOutputWithFlag = invam.insertNrldAnnMst1(res);

					if (mstOutputWithFlag != null) {
						
						//System.out.println("mstOutputWithFlag.getMstNewId()"+mstOutputWithFlag.getMstNewId());
						//System.out.println("mstOutputWithFlag.getMstOldId()"+mstOutputWithFlag.getMstOldId());

						if (mstOutputWithFlag.getMstNewId() != null) {

							resobj
									.setResInspectMst1Id(mstOutputWithFlag.getMstNewId());
						}
						if (mstOutputWithFlag.getMstOldId() != null) {

							resobj
									.setResInspectMst1Id(mstOutputWithFlag.getMstOldId());
						}

						
					}

					if ((mstOutputWithFlag.getMstOldId() != null
							|| mstOutputWithFlag.getMstNewId() != null) &&  (res.getResCheckAddFlag()==true) ) {

						if (resobj != null) {
							

								
							if (resobj.getResInspectMst1Id() > 0 && resobj.getUserName()!=null && resobj.getTabId()>0 && resobj.getFieldOfficerData()!=null) {
								//	System.out.println("get remarks"+ resobj.getRemarks());
									
										output = invam.AddNrldInspectionInfo(resobj);
										
									}
								
							
						}

					}

				}

		/*	}*/

		}
	}

						
		
						
				

			}
				}
				}
			}

			// System.out.println("resListbyId"+resListbyId);

		} catch (InventoryUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new Gson().toJson(output);

	}
	
	
	
	@RequestMapping(value = "/invtsimis/AddNrldRecommendationInfo")
	@ResponseBody
	public String AddNrldRecommendationInfo(ReservoirInspect resobj, HttpServletRequest request, HttpSession session,
			SessionStatus status) {

		List<ReservoirInspect> resInspect = new ArrayList<ReservoirInspect>();

		// List<PumpStations> pumpStationList= new ArrayList<PumpStations>();
		Integer output=0;

		try {

			if (resobj!=null ) {
				
				User user = (User) session.getAttribute("userObj");

				if (resobj != null) {
					//System.out.println("resobj"+resobj);
				 
					if (user != null) {

						if ( user.getUserName() != null) {

							// System.out.println("user.getUserId()"+user.getUserEmpId()+"user.getUserName()"+user.getUserName());
							//miobj.setUserEmpId(user.getUserEmpId());

							
							resobj.setUserName(user.getUserName());
							resobj.setUnitId(user.getUnitId());
							resobj.setCircleId(user.getCircleId());
							resobj.setDivisionId(user.getDivisionId());
							resobj.setSubdivisionId(user.getSubdivisionId());
							resobj.setDesignationId(user.getDesignationId());
							resobj.setSectionId(user.getSectionId());
							resobj.setEmpId(user.getEmpId());
							resobj.setPostId(user.getPost());
							
							if(user.getDesignationId()==2 || user.getDesignationId()==8){
								resobj.setLevelId(0);
								
							} else if (user.getDesignationId()==4){
								
								resobj.setLevelId(1);
							}else if (user.getDesignationId()==5|| user.getDesignationId()==6){
								
								resobj.setLevelId(2);
							}
							else if (user.getDesignationId()==7){
								
								resobj.setLevelId(3);
							}else if (user.getDesignationId()==9){
								
								resobj.setLevelId(4);
							}
                              else if (user.getDesignationId()==10){
								
								resobj.setLevelId(5);
							}else{
								
							}

						}

						
		//System.out.println("resobj.getInspectOfficeInfoId()"+resobj.getInspectOfficeInfoId());
						
				if (resobj.getResInspectMst1Id() > 0 && resobj.getUserName()!=null && resobj.getResInspectMst2Id()>=0  && resobj.getRemarks()!=null && resobj.getInspectOfficeInfoId()!=null) {
				//System.out.println("get remarks"+ resobj.getRemarks());
				
					output = invam.AddNrldRecommendationInfo(resobj);
					
				}

			}
				}
			}

			// System.out.println("resListbyId"+resListbyId);

		} catch (InventoryUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new Gson().toJson(output);

	}
	
	
	@RequestMapping(value = "/invtsimis/getresmst2mst1byyearfreq")
	@ResponseBody
	public String getresmst2mst1byyearfreq(ReservoirInspect resobj, HttpServletRequest request,
			HttpSession session, SessionStatus status) {

		List<ReservoirInspect> resInspectinf = new ArrayList<ReservoirInspect>();

		// List<PumpStations> pumpStationList= new ArrayList<PumpStations>();
		
		//System.out.println(resobj.getConditionofDamId()+"condition");

		try {

			if (resobj.getYear() != null && resobj.getDutyFrequencyId() != null && resobj.getReservoirId() !=null  && resobj.getTankId()!=null) {

				if ((resobj.getReservoirId() >0 &&  resobj.getDutyFrequencyId() > 0 && resobj.getYear() > 0  && resobj.getTankId()==0) ||  (resobj.getReservoirId() == 0 &&  resobj.getDutyFrequencyId() > 0 && resobj.getYear() > 0  &&  resobj.getTankId() > 0)) {
					
					
					//System.out.println("resobj.getReservoirId()"+resobj.getReservoirId());
					
					//System.out.println("resobj.gettankId()"+resobj.getTankId());
					resInspectinf = invam.getResmst2andmst1ByYearFreq(resobj);
				}

			}

			// System.out.println("resListbyId"+resListbyId);

		} catch (InventoryUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new Gson().toJson(resInspectinf);

	}
	
	
	@RequestMapping(value = "/invtsimis/getprevmst2mst1byyearfreq")
	@ResponseBody
	public String getprevmst2mst1byyearfreq(ReservoirInspect resobj, HttpServletRequest request,
			HttpSession session, SessionStatus status) {

		List<ReservoirInspect> resInspectinf = new ArrayList<ReservoirInspect>();
		
		List<ReservoirInspect> resInspectmst1inf = new ArrayList<ReservoirInspect>();
		
		List<ReservoirInspect> resInspectmst2inf = new ArrayList<ReservoirInspect>();

		// List<PumpStations> pumpStationList= new ArrayList<PumpStations>();
		
		MstOutputWithFlag mstOutputWithFlag = new MstOutputWithFlag();
		
		//System.out.println(resobj.getConditionofDamId()+"condition");
		
		Integer output=0;
		
		Integer output1=0;
		
		Integer outpu2=0;
		
		Integer output3=0;
		
		Integer output4=0;
		
		Integer output5=0;

		try {
			
			User user = (User) session.getAttribute("userObj");
			
			if ( user.getUserName() != null) {

				// System.out.println("user.getUserId()"+user.getUserEmpId()+"user.getUserName()"+user.getUserName());
				//miobj.setUserEmpId(user.getUserEmpId());

				
				resobj.setUserName(user.getUserName());
				resobj.setUnitId(user.getUnitId());
				resobj.setCircleId(user.getCircleId());
				resobj.setDivisionId(user.getDivisionId());
				resobj.setSubdivisionId(user.getSubdivisionId());
				resobj.setDesignationId(user.getDesignationId());
				resobj.setSectionId(user.getSectionId());
				resobj.setEmpId(user.getEmpId());
				resobj.setPostId(user.getPost());
				
				if(user.getDesignationId()==2 || user.getDesignationId()==8){
					resobj.setLevelId(0);
					
				} else if (user.getDesignationId()==4){
					
					resobj.setLevelId(1);
				}else if (user.getDesignationId()==5|| user.getDesignationId()==6){
					
					resobj.setLevelId(2);
				}
				else if (user.getDesignationId()==7){
					
					resobj.setLevelId(3);
				}else if (user.getDesignationId()==9){
					
					resobj.setLevelId(4);
				}
                  else if (user.getDesignationId()==10){
					
					resobj.setLevelId(5);
				}else{
					
				}

			}

			if (resobj.getYear() != null && resobj.getDutyFrequencyId() != null && resobj.getReservoirId() !=null  && resobj.getTankId()!=null && resobj.getPrevYear()!=null && resobj.getPrevFreq()!=null) {

				if ((resobj.getReservoirId() >0 &&  resobj.getDutyFrequencyId() > 0 && resobj.getYear() > 0  && resobj.getTankId()==0 && resobj.getPrevYear()>0 && resobj.getPrevFreq()>0 ) ||  (resobj.getReservoirId() == 0 &&  resobj.getDutyFrequencyId() > 0 && resobj.getYear() > 0  &&  resobj.getTankId() > 0 && resobj.getPrevYear()>0 && resobj.getPrevFreq()>0 )) {
					
					
					if (resobj.getReservoirId() != null && resobj.getTankId()!=null) {
						
						

						mstOutputWithFlag = invam.inserprevtNrldAnnMst1(resobj);

					
						
					}
					
					if (mstOutputWithFlag != null) {

						if (mstOutputWithFlag.getMstNewId() != null) {

							resobj
									.setResInspectMst1Id(mstOutputWithFlag.getMstNewId());
						}
						if (mstOutputWithFlag.getMstOldId() != null) {

							resobj
									.setResInspectMst1Id(mstOutputWithFlag.getMstOldId());
						}

						
						resInspectmst1inf=    invam.getPrevAnnMst1IdByNewMst1Id(resobj.getResInspectMst1Id());

					
					
					
					if (resInspectmst1inf != null  ) {

						if (resobj != null) {
							/*if (resAnna1daoimplObj.size() > 0) {*/

								if (resInspectmst1inf.get(0).getResInspectMst1Id() != null) {

									resobj
											.setResInspectMst1Id(resInspectmst1inf.get(0).getResInspectMst1Id());
								}
								if (resInspectmst1inf.get(0).getPrevResInspectMst1Id() != null) {

									resobj
											.setPrevResInspectMst1Id(resInspectmst1inf.get(0).getPrevResInspectMst1Id());
								}
								// System.out.println("cnt1"+resAnn2daoimplObj.get(0).getResInspectMst1Id());;
								if (resobj.getResInspectMst1Id() != null && resobj.getPrevResInspectMst1Id()!=null ) {
									// System.out.println("cnt2"+resAnn2daoimplObj.get(0).getResInspectMst1Id());

									output = invam.insertPrevNrldAnninspectMst2(resobj);
									
									
									
									output1 =  invam.AddPrevNrldInspectionInfo(resobj);
									
									outpu2=invam.AddPrevDamHealthStatusInfo(resobj);
									
									output3=invam.AddPrevAnnRemarks(resobj);
									
									output4=invam.insertPrevDamDocuments(resobj);
									
								

								}
								
								
							
						}

					}
					
				  // 
					
					}
					
				}

			}

			// System.out.println("resListbyId"+resListbyId);

		} catch (InventoryUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new Gson().toJson(output);

	}
	
	
	
	
	@RequestMapping(value = "/invtsimis/getprevrecommendmst1Id")
	@ResponseBody
	public String getprevrecommendmst1Id(ReservoirInspect resobj, HttpServletRequest request,
			HttpSession session, SessionStatus status) {

		List<ReservoirInspect> resInspectinf = new ArrayList<ReservoirInspect>();
		
		List<ReservoirInspect> resInspectmst1inf = new ArrayList<ReservoirInspect>();
		
		List<ReservoirInspect> resInspectmst2inf = new ArrayList<ReservoirInspect>();

		// List<PumpStations> pumpStationList= new ArrayList<PumpStations>();
		
		MstOutputWithFlag mstOutputWithFlag = new MstOutputWithFlag();
		
		//System.out.println(resobj.getConditionofDamId()+"condition");
		
		Integer output=0;
		
		Integer output1=0;
		
		Integer outpu2=0;
		
		Integer output3=0;
		
		Integer output4=0;
		
		Integer output5=0;

		try {
			
			User user = (User) session.getAttribute("userObj");
			
			if ( user.getUserName() != null) {

				// System.out.println("user.getUserId()"+user.getUserEmpId()+"user.getUserName()"+user.getUserName());
				//miobj.setUserEmpId(user.getUserEmpId());

				
				resobj.setUserName(user.getUserName());
				resobj.setUnitId(user.getUnitId());
				resobj.setCircleId(user.getCircleId());
				resobj.setDivisionId(user.getDivisionId());
				resobj.setSubdivisionId(user.getSubdivisionId());
				resobj.setDesignationId(user.getDesignationId());
				resobj.setSectionId(user.getSectionId());
				resobj.setEmpId(user.getEmpId());
				resobj.setPostId(user.getPost());
				
				if(user.getDesignationId()==2 || user.getDesignationId()==8){
					resobj.setLevelId(0);
					
				} else if (user.getDesignationId()==4){
					
					resobj.setLevelId(1);
				}else if (user.getDesignationId()==5|| user.getDesignationId()==6){
					
					resobj.setLevelId(2);
				}
				else if (user.getDesignationId()==7){
					
					resobj.setLevelId(3);
				}else if (user.getDesignationId()==9){
					
					resobj.setLevelId(4);
				}
                  else if (user.getDesignationId()==10){
					
					resobj.setLevelId(5);
				}else{
					
				}

			}

			if (resobj.getYear() != null && resobj.getDutyFrequencyId() != null && resobj.getReservoirId() !=null  && resobj.getTankId()!=null && resobj.getPrevYear()!=null && resobj.getPrevFreq()!=null) {

				if ((resobj.getReservoirId() >0 &&  resobj.getDutyFrequencyId() > 0 && resobj.getYear() > 0  && resobj.getTankId()==0 && resobj.getPrevYear()>0 && resobj.getPrevFreq()>0 ) ||  (resobj.getReservoirId() == 0 &&  resobj.getDutyFrequencyId() > 0 && resobj.getYear() > 0  &&  resobj.getTankId() > 0 && resobj.getPrevYear()>0 && resobj.getPrevFreq()>0 )) {
					
					
					resInspectmst1inf=invam.getAnnMst1IdByYearandMonsoonMst1Id(resobj);
					
				

					
					if (resInspectmst1inf != null  ) {

						if (resobj != null) {
							/*if (resAnna1daoimplObj.size() > 0) {*/

								if (resInspectmst1inf.get(0).getResInspectMst1Id() != null) {

									resobj
											.setResInspectMst1Id(resInspectmst1inf.get(0).getResInspectMst1Id());
								}
								if (resInspectmst1inf.get(0).getPrevResInspectMst1Id() != null) {

									resobj
											.setPrevResInspectMst1Id(resInspectmst1inf.get(0).getPrevResInspectMst1Id());
								}
								// System.out.println("cnt1"+resAnn2daoimplObj.get(0).getResInspectMst1Id());;
								if (resobj.getResInspectMst1Id() != null && resobj.getPrevResInspectMst1Id()!=null ) {
							
									
									output5=invam.AddPrevNrldRecommendationInfo(resobj);

								}
								
								
							
						}

					}
					
				  // 
					
					
					
				}

			}

			// System.out.println("resListbyId"+resListbyId);

		} catch (InventoryUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new Gson().toJson(output5);

	}
	
	
	
	@RequestMapping(value = "/invtsimis/getresInspectInfo")
	@ResponseBody
	public String getresInspectInfo(ReservoirInspect resobj, HttpServletRequest request,
			HttpSession session, SessionStatus status) {

		List<ReservoirInspect> resInspectinf = new ArrayList<ReservoirInspect>();

		// List<PumpStations> pumpStationList= new ArrayList<PumpStations>();

		try {
                    
			
			//System.out.println("resobj.getReservoirId()"+resobj.getReservoirId());
			//System.out.println("resobj.getYear()"+resobj.getYear());
			//System.out.println("resobj.getTankId()"+resobj.getTankId());
			//System.out.println("	resobj.getDutyFrequencyId()"+	resobj.getDutyFrequencyId());
		
			if (resobj.getReservoirId()!=null && resobj.getYear() !=null && resobj.getTankId() !=null && resobj.getDutyFrequencyId()!=null) {

				if ((resobj.getReservoirId()>0 &&  resobj.getYear()>0 && resobj.getTankId()==0 && resobj.getDutyFrequencyId()>0 ) || 
						(resobj.getReservoirId()==0 &&  resobj.getYear()>0 && resobj.getTankId()>0 && resobj.getDutyFrequencyId()>0 )) {
					resInspectinf = invam.getResInspectInfo(resobj);
				}

			}

			// System.out.println("resListbyId"+resListbyId);

		} catch (InventoryUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new Gson().toJson(resInspectinf);

	}
	
	
	@RequestMapping(value = "/invtsimis/getresInspectInfobyInspectInfo")
	@ResponseBody
	public String getresInspectInfobyInspectInfo(ReservoirInspect resobj, HttpServletRequest request,
			HttpSession session, SessionStatus status) {

		List<ReservoirInspect> resInspectinf = new ArrayList<ReservoirInspect>();

		// List<PumpStations> pumpStationList= new ArrayList<PumpStations>();

		try {

			if (resobj.getResinspectInfoId()!=null) {

				if (resobj.getResinspectInfoId()>0 ) {
					resInspectinf = invam.getResInspectInfobyInspectOfficeInfoId(resobj);
				}

			}

			// System.out.println("resListbyId"+resListbyId);

		} catch (InventoryUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new Gson().toJson(resInspectinf);

	}
	
	
	@RequestMapping(value = "/invtsimis/AddDamHealthStatusInfo")
	@ResponseBody
	public String AddDamHealthStatusInfo(ReservoirInspect resobj, HttpServletRequest request, HttpSession session,
			SessionStatus status) {

		List<ReservoirInspect> resInspect = new ArrayList<ReservoirInspect>();

		// List<PumpStations> pumpStationList= new ArrayList<PumpStations>();
		Integer output=0;
		
		MstOutputWithFlag mstOutputWithFlag = new MstOutputWithFlag();

		try {
			
			//System.out.println("1");

			if (resobj!=null ) {
				
				User user = (User) session.getAttribute("userObj");

				if (resobj != null) {
					//System.out.println("resobj"+resobj);
				 
					if (user != null) {

						if ( user.getUserName() != null) {

							// System.out.println("user.getUserId()"+user.getUserEmpId()+"user.getUserName()"+user.getUserName());
							//miobj.setUserEmpId(user.getUserEmpId());

							
							resobj.setUserName(user.getUserName());
							resobj.setUnitId(user.getUnitId());
							resobj.setCircleId(user.getCircleId());
							resobj.setDivisionId(user.getDivisionId());
							resobj.setSubdivisionId(user.getSubdivisionId());
							resobj.setDesignationId(user.getDesignationId());
							resobj.setSectionId(user.getSectionId());
							resobj.setEmpId(user.getEmpId());
							resobj.setPostId(user.getPost());
							
							if(user.getDesignationId()==2 || user.getDesignationId()==8){
								resobj.setLevelId(0);
								
							} else if (user.getDesignationId()==4){
								
								resobj.setLevelId(1);
							}else if (user.getDesignationId()==5|| user.getDesignationId()==6){
								
								resobj.setLevelId(2);
							}
							else if (user.getDesignationId()==7){
								
								resobj.setLevelId(3);
							}else if (user.getDesignationId()==9){
								
								resobj.setLevelId(4);
							}
                              else if (user.getDesignationId()==10){
								
								resobj.setLevelId(5);
							}else{
								
							}

						}
						
							if(resobj.getResInspectMst1Id()!=null){
							//System.out.println("get remarks"+ resobj.getResInspectMst1Id());
							if (resobj.getResInspectMst1Id() > 0 && resobj.getUserName()!=null   && resobj.getInspectOfficeInfoId()!=null  && resobj.getRemarks()!=null) {
								//System.out.println("get remarks"+ resobj.getRemarks());
								
								//System.out.println("get remarks"+ resobj.getResInspectMst1Id());
								
									output = invam.AddDamHealthStatusInfo(resobj);
									
									//System.out.println("7");
									
								}else{
									
									output=-1;
								}
							
							}else {
								output=-1;
								
							}
		
						
				

			}
				}
			}

			// System.out.println("resListbyId"+resListbyId);

		} catch (InventoryUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new Gson().toJson(output);

	}
	
	
	@RequestMapping(value = "/invtsimis/getresHealthDetails")
	@ResponseBody
	public String getresHealthDetails(ReservoirInspect resobj, HttpServletRequest request,
			HttpSession session, SessionStatus status) {

		List<ReservoirInspect> resInspectinf = new ArrayList<ReservoirInspect>();

		// List<PumpStations> pumpStationList= new ArrayList<PumpStations>();

		try {

			if (resobj.getReservoirId()!=null && resobj.getYear() !=null && resobj.getTankId()!=null && resobj.getDutyFrequencyId()!=null ) {

				if ((resobj.getReservoirId()>0 &&  resobj.getYear()>0 && resobj.getDutyFrequencyId()>0 && resobj.getTankId()==0  ) || 
						(resobj.getReservoirId()==0 &&  resobj.getYear()>0 && resobj.getDutyFrequencyId()>0 && resobj.getTankId()>0 )) {
					resInspectinf = invam.getDamHealthDetailsBYmst1Id(resobj);
				}

			}

			// System.out.println("resListbyId"+resListbyId);

		} catch (InventoryUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new Gson().toJson(resInspectinf);

	}
	
	
	
	@RequestMapping(value = "/invtsimis/get-resHealthDetails-byhealthid")
	@ResponseBody
	public String getResHealthDetailsByhealthid(ReservoirInspect resobj, HttpServletRequest request,
			HttpSession session, SessionStatus status) {

		List<ReservoirInspect> resInspectinf = new ArrayList<ReservoirInspect>();

		// List<PumpStations> pumpStationList= new ArrayList<PumpStations>();

		try {

			if (resobj.getResDamHealthId()!=null  ) {

				if ((resobj.getResDamHealthId()>0  )) {
					resInspectinf = invam.getDamHealthDetailsBYHealthId(resobj);
				}

			}

			// System.out.println("resListbyId"+resListbyId);

		} catch (InventoryUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new Gson().toJson(resInspectinf);

	}
	
	
	
	@RequestMapping(value = "/invtsimis/getresHealthDataByInspectDate")
	@ResponseBody
	public String getresHealthDataByInspectDate(ReservoirInspect resobj, HttpServletRequest request,
			HttpSession session, SessionStatus status) {

		List<ReservoirInspect> resInspectinf = new ArrayList<ReservoirInspect>();

		// List<PumpStations> pumpStationList= new ArrayList<PumpStations>();

		try {

			if (resobj.getResinspectInfoId()!=null) {

				if (resobj.getResinspectInfoId()>0) {
					resInspectinf = invam.getDamHealthDetailsBYInspectInfo(resobj);
				}

			}

			// System.out.println("resListbyId"+resListbyId);

		} catch (InventoryUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new Gson().toJson(resInspectinf);

	}
	
	
	@RequestMapping(value = "/invtsimis/getresHealthRecommendations")
	@ResponseBody
	public String getresHealthRecommendations(ReservoirInspect resobj, HttpServletRequest request,
			HttpSession session, SessionStatus status) {

		List<ReservoirInspect> resInspectinf = new ArrayList<ReservoirInspect>();

		// List<PumpStations> pumpStationList= new ArrayList<PumpStations>();

		try {
			
			//System.out.println("resobj.getInspectOfficeInfoId()"+resobj.getInspectOfficeInfoId()+"resobj.getResInspectMst1Id()"+resobj.getResInspectMst1Id()+"resobj.getResInspectMst2Id()"+resobj.getResInspectMst2Id());

			if (resobj.getInspectOfficeInfoId()!=null) {

				if (resobj.getInspectOfficeInfoId()>0 && resobj.getResInspectMst1Id()>0 && resobj.getResInspectMst2Id()==0) {
					resInspectinf = invam.getResAnnRecomndbyhealthInspectInfo(resobj);
				}

			}

			// System.out.println("resListbyId"+resListbyId);

		} catch (InventoryUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new Gson().toJson(resInspectinf);

	}
	
	
	@RequestMapping(value = "/invtsimis/AddActiontakenStatusInfo")
	@ResponseBody
	public String AddActiontakenStatusInfo(ReservoirInspect resobj, HttpServletRequest request, HttpSession session,
			SessionStatus status) {

		List<ReservoirInspect> resInspect = new ArrayList<ReservoirInspect>();

		// List<PumpStations> pumpStationList= new ArrayList<PumpStations>();
		Integer output=0;
		
		MstOutputWithFlag mstOutputWithFlag = new MstOutputWithFlag();

		try {
			
			//System.out.println("1");

			if (resobj!=null ) {
				
				User user = (User) session.getAttribute("userObj");

				if (resobj != null) {
					//System.out.println("resobj"+resobj);
				 
					if (user != null) {

						if ( user.getUserName() != null) {

							// System.out.println("user.getUserId()"+user.getUserEmpId()+"user.getUserName()"+user.getUserName());
							//miobj.setUserEmpId(user.getUserEmpId());

							
							resobj.setUserName(user.getUserName());
							resobj.setUnitId(user.getUnitId());
							resobj.setCircleId(user.getCircleId());
							resobj.setDivisionId(user.getDivisionId());
							resobj.setSubdivisionId(user.getSubdivisionId());
							resobj.setDesignationId(user.getDesignationId());
							resobj.setSectionId(user.getSectionId());
							resobj.setEmpId(user.getEmpId());
							resobj.setPostId(user.getPost());
							
							if(user.getDesignationId()==2 || user.getDesignationId()==8){
								resobj.setLevelId(0);
								
							} else if (user.getDesignationId()==4){
								
								resobj.setLevelId(1);
							}else if (user.getDesignationId()==5|| user.getDesignationId()==6){
								
								resobj.setLevelId(2);
							}
							else if (user.getDesignationId()==7){
								
								resobj.setLevelId(3);
							}else if (user.getDesignationId()==9){
								
								resobj.setLevelId(4);
							}
                              else if (user.getDesignationId()==10){
								
								resobj.setLevelId(5);
							}else{
								
							}

						}
					
					
						if(resobj.getResInspectMst1Id() != null){
							
						
						
							
							
							
							//System.out.println("get remarks"+ resobj.getResInspectMst1Id());
							if (resobj.getResInspectMst1Id() > 0 && resobj.getUserName()!=null   && resobj.getInspectOfficeInfoId()!=null  && resobj.getResDamHealthId()!=null && resobj.getRemarks()!=null) {
								//System.out.println("get remarks"+ resobj.getRemarks());
								
								//System.out.println("get remarks"+ resobj.getResInspectMst1Id());
								
									output = invam.AddActionTakenStatusInfo(resobj);
									
									//System.out.println("7");
									
								}else {
									
									output=-1 ;
								}
							
						}
		
						
				

			}
				}
			}

			// System.out.println("resListbyId"+resListbyId);

		} catch (InventoryUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new Gson().toJson(output);

	}
	
	
	@RequestMapping(value = "/invtsimis/getActionTakenDetails")
	@ResponseBody
	public String getActionTakenDetails(ReservoirInspect resobj, HttpServletRequest request,
			HttpSession session, SessionStatus status) {

		List<ReservoirInspect> resInspectinf = new ArrayList<ReservoirInspect>();

		// List<PumpStations> pumpStationList= new ArrayList<PumpStations>();

		try {

			if (resobj.getReservoirId()!=null && resobj.getYear() !=null && resobj.getDutyFrequencyId()!=null && resobj.getTankId()!=null) {

				if ((resobj.getReservoirId()>0 &&  resobj.getYear()>0  && resobj.getDutyFrequencyId()>0 && resobj.getTankId()==0) ||
						(resobj.getReservoirId()==0 &&  resobj.getYear()>0  && resobj.getDutyFrequencyId()>0 && resobj.getTankId()>0)) {
					resInspectinf = invam.getActionTakenDetailsBYmst1Id(resobj);
				}

			}

			// System.out.println("resListbyId"+resListbyId);

		} catch (InventoryUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new Gson().toJson(resInspectinf);

	}
	
	
	@RequestMapping(value = "/invtsimis/getActionTakenActionId")
	@ResponseBody
	public String getActionTakenActionId(ReservoirInspect resobj, HttpServletRequest request,
			HttpSession session, SessionStatus status) {

		List<ReservoirInspect> resInspectinf = new ArrayList<ReservoirInspect>();

		// List<PumpStations> pumpStationList= new ArrayList<PumpStations>();

		try {

			if (resobj.getResDamActionId()!=null) {

				if ((resobj.getResDamActionId()>0 )) {
					resInspectinf = invam.getActionTakenDetailsBYActionId(resobj);
				}

			}

			// System.out.println("resListbyId"+resListbyId);

		} catch (InventoryUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new Gson().toJson(resInspectinf);

	}
	
	
	@RequestMapping(value = "/invtsimis/daminspectphotos")
	@ResponseBody
	public String  daminspectphotos(@ModelAttribute("resinspect") ReservoirInspect damObj, HttpServletRequest request,
			HttpSession session, SessionStatus status) {
		ModelAndView mav = new ModelAndView();
		
	Integer output=0;
		
		String[] saveFileName = null;

		List<String> fileNameList = new ArrayList<String>();
		
		
		List<DamInspectDocs> damdaoimplObj = new ArrayList<DamInspectDocs>();

		
		List<DamInspectDocs> damdocList = new ArrayList<DamInspectDocs>();
		Boolean captOutput = false;
		// System.out.println("coming here1"+damObj.getCaptcha());
	
try{
	
	User user = (User) session.getAttribute("userObj");
	String captcha = (String) session.getAttribute("CAPTCHA3");
	
	// System.out.println("coming herecaptcha"+captcha);
	
	if (damObj.getCaptcha() == null || damObj.getUploadPhotos() == null) {
		output=-3 ;
	}else if ((damObj.getCaptcha() != null && captcha != null)){
		
		if ((damObj.getCaptcha() != null && !damObj.getCaptcha().equals(captcha))) {
			// System.out.println("coming here"+damObj.getCaptcha());
		
			damObj.setCaptcha("");
		
			captOutput = false;
			output=-2;

		}else if (damObj.getCaptcha().equals(captcha)) {

			captOutput = true;

		}
		
		
		
	}
	if (captOutput == true) {	
	if (damObj != null) {
		if (user != null) {
			
			if (user.getEmpId() != null || user.getUserName() != null) {
				
				
				damObj.setUserName(user.getUserName());
				damObj.setUnitId(user.getUnitId());
				damObj.setCircleId(user.getCircleId());
				damObj.setDivisionId(user.getDivisionId());
				damObj.setSubdivisionId(user.getSubdivisionId());
				damObj.setDesignationId(user.getDesignationId());
				damObj.setSectionId(user.getSectionId());
				damObj.setEmpId(user.getEmpId());
				damObj.setPostId(user.getPost());
							
				if(user.getDesignationId()==2 || user.getDesignationId()==8){
					           damObj.setLevelId(0);
								
							} else if (user.getDesignationId()==4){
								
								damObj.setLevelId(1);
							}else if (user.getDesignationId()==5|| user.getDesignationId()==6){
								
								damObj.setLevelId(2);
							}
							else if (user.getDesignationId()==7){
								
								damObj.setLevelId(3);
							}else if (user.getDesignationId()==9){
								
								damObj.setLevelId(4);
							}
                              else if (user.getDesignationId()==10){
								
                            	  damObj.setLevelId(5);
							}else{
								
							}

						}
					

			
		
			
	
		
		
	
		
		if(damObj.getResInspectMst1Id()!=null && damObj.getInspectOfficeInfoId()!=null){	
			
			if(damObj.getResInspectMst1Id() >0  && damObj.getInspectOfficeInfoId()>0){	
	if(damObj.getUploadPhotos()!=null){
		
		
		
		if(damObj.getUploadPhotos().size()>0){
			
			//System.out.println("coming here"+damObj.getUploadPhotos().size());
		
			
			List<MultipartFile> files = damObj.getUploadPhotos();
			List<String> fileNames = new ArrayList<String>();
			
			List<DamInspectDocs> fileList = new ArrayList<DamInspectDocs>();
			String filetitile = null;
			String filetitilenew = null;
			
			
			
			if (null != files && files.size() >= 1) {
				
				for (MultipartFile multipartFile : files) {

					String fileName = multipartFile.getOriginalFilename();
					String FileType = (files).get(0).getContentType();
					fileNames.add(fileName);
					// Handle file content -
					// multipartFile.getInputStream()

				}
				
				//System.out.println("2nd file size"+fileNames.size());
				
				for (int i = 0; i < fileNames.size(); i++) {
					filetitile = fileNames.get(i);

					// System.out.println("filetitile"+filetitile);

					if (!filetitile.isEmpty()) {
						Integer maxId;
					
							maxId = invam.getCountOfDamInpsectDocs() + 1;
						
						// System.out.println("maxId"+maxId);
						 
						 Integer  doccnt=maxId;

						String[] temps = filetitile.split(Pattern.quote("."));

						Integer dataIdNum = damObj.getResInspectMst1Id();
						
						doccnt=doccnt+i;
						
					

						String docName = temps[0];
						String SaveName = dataIdNum.toString() + doccnt.toString() + docName + "."
								+ temps[temps.length - 1];

					
						fileNameList.add(SaveName);

						

					}
				}
				
				String rootPath = System.getProperty("catalina.base");
				
				//live
				
				File dir = new File( File.separator + "Uploads" +File.separator + "tsimis" + File.separator + "uploadedFiles"
						+ File.separator + "DamInspectDocs");
				//File dir = new File(rootPath + File.separator + "webapps" +File.separator + "tsimis" + File.separator + "uploadedFiles"
					//	+ File.separator + "DamInspectDocs");
				
				/*File dir = new File(rootPath + File.separator + "webapps" + File.separator
						+ "PMSWebApp"+File.separator + "tsimis" + File.separator + "uploadedFiles"
						+ File.separator + "DamInspectDocs");*/
				//local
				/*File dir = new File(rootPath + File.separator + "webapps" + File.separator
						+ "ICADLeagalWebApp"+File.separator + "uploadedFiles"
						+ File.separator + "DamInspectDocs");*/
				
				if (!dir.exists())
					dir.mkdirs();
				
				for (int i = 0; i < files.size(); i++) {

					// File serverFile = new
					// File(dir.getAbsolutePath()+
					// File.separator +
					// files.get(i).getOriginalFilename());
					if (!fileNameList.isEmpty()) {

						if (fileNameList.size() > 0) {

							String DamDocName = fileNameList.get(i);
							DamInspectDocs tf = new DamInspectDocs();

							tf.setDamDocName(DamDocName);
							tf.setDamDocOriginalName(files.get(i).getOriginalFilename());
							tf.setDamDocLocation(
									dir.getAbsolutePath() + File.separator + DamDocName);

							// System.out.println("serverFile"+frmDocName);
							fileList.add(tf);

						   //   String targetPath=dir.getAbsolutePath()+ File.separator + frmDocName ;
								
						      
						     // int scaledWidth = 1024;
					        //    int scaledHeight = 768;
					         //   MultipartFile newFile=files.get(i);
					         //   ResizeImage.resize(newFile, targetPath, scaledWidth, scaledHeight);
						      files.get(i).transferTo( new File(dir.getAbsolutePath() + File.separator + DamDocName));
							

						}

					}
				}
				
				if (fileList.size() > 0) {
					
				//	System.out.println("fileList"+fileList);
					damObj.setDaminspectphotoList(fileList);
					
					
					

				}
				
				output = invam.insertDamDocuments(damObj);
				
				//System.out.println("output"+output);

				
			}
			
		}
	}
				
			
		}	else {
			
			output=-4;
			
		}	
		

		}
	
	}
	}
	
	}	
		
	

		}catch (InventoryUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
			
		
	      //end of photos
	
	return new Gson().toJson(output);
			}

	
	@RequestMapping(value = "/invtsimis/getDamRemarksDetails")
	@ResponseBody
	public String getDamRemarksDetails(ReservoirInspect resobj, HttpServletRequest request,
			HttpSession session, SessionStatus status) {

		List<ReservoirInspect> resInspectinf = new ArrayList<ReservoirInspect>();

		// List<PumpStations> pumpStationList= new ArrayList<PumpStations>();

		try {

			if (resobj.getReservoirId()!=null && resobj.getYear() !=null && resobj.getDutyFrequencyId()!=null && resobj.getTankId()!=null) {

				if ((resobj.getReservoirId()>0 &&  resobj.getYear()>0 &&  resobj.getDutyFrequencyId()>0  && resobj.getTankId()==0) ||
						(resobj.getReservoirId()==0 &&  resobj.getYear()>0 &&  resobj.getDutyFrequencyId()>0  && resobj.getTankId()>0)) {
					resInspectinf = invam.getResDamInspectRemarksByReservoirId(resobj);
				}

			}

			// System.out.println("resListbyId"+resListbyId);

		} catch (InventoryUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new Gson().toJson(resInspectinf);

	}
	
	@RequestMapping(value = "/invtsimis/getDamInspectPhotosDetails")
	@ResponseBody
	public String getDamInspectPhotosDetails(ReservoirInspect resobj, HttpServletRequest request,
			HttpSession session, SessionStatus status) {

		List<DamInspectDocs> resInspectinf = new ArrayList<DamInspectDocs>();

		// List<PumpStations> pumpStationList= new ArrayList<PumpStations>();

		try {

			if (resobj.getReservoirId()!=null && resobj.getYear() !=null && resobj.getDutyFrequencyId()!=null && resobj.getTankId()!=null ) {

				if ((resobj.getReservoirId()>0 &&  resobj.getYear()>0 &&  resobj.getDutyFrequencyId()>0 && resobj.getTankId()==0 )||
						(resobj.getReservoirId()==0 &&  resobj.getYear()>0 &&  resobj.getDutyFrequencyId()>0 && resobj.getTankId()>0)) {
					resInspectinf = invam.getDamInspectPhotosByReservoirId(resobj);
				}

			}

			// System.out.println("resListbyId"+resListbyId);

		} catch (InventoryUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new Gson().toJson(resInspectinf);

	}
	
	
	@RequestMapping(value = "/invtsimis/getResDaminfoDetails")
	@ResponseBody
	public String getResDaminfoDetails(ReservoirInspect resobj, HttpServletRequest request,
			HttpSession session, SessionStatus status) {

		List<ReservoirSalient> resInspectinf = new ArrayList<ReservoirSalient>();

		// List<PumpStations> pumpStationList= new ArrayList<PumpStations>();

		try {

			if (resobj.getReservoirId()!=null ) {

				if (resobj.getReservoirId()>0 ) {
					resInspectinf = invam.getresDamInfo(resobj);
				}

			}

			// System.out.println("resListbyId"+resListbyId);

		} catch (InventoryUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new Gson().toJson(resInspectinf);

	}
	
	@RequestMapping(value = "/invtsimis/getDamControlLvlDetails")
	@ResponseBody
	public String getDamControlLvlDetails(ReservoirInspect resobj, HttpServletRequest request,
			HttpSession session, SessionStatus status) {

		List<ReservoirSalient> resInspectinf = new ArrayList<ReservoirSalient>();

		// List<PumpStations> pumpStationList= new ArrayList<PumpStations>();

		try {

			if (resobj.getReservoirId()!=null ) {

				if (resobj.getReservoirId()>0 ) {
					resInspectinf = invam.getresImpControlLevelInfo(resobj);
				}

			}

			// System.out.println("resListbyId"+resListbyId);

		} catch (InventoryUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new Gson().toJson(resInspectinf);

	}
	
	
	
	@RequestMapping(value = "/invtsimis/getResDamSalientDetails")
	@ResponseBody
	public String getResDamSalientDetails(ReservoirInspect resobj, HttpServletRequest request,
			HttpSession session, SessionStatus status) {

		List<ReservoirSalient> ressalinf = new ArrayList<ReservoirSalient>();

		// List<PumpStations> pumpStationList= new ArrayList<PumpStations>();

		try {

			if (resobj.getReservoirId()!=null ) {

				if (resobj.getReservoirId()>0 ) {
					ressalinf = invam.getresDamSalientInfo(resobj);
				}

			}

			// System.out.println("resListbyId"+resListbyId);

		} catch (InventoryUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new Gson().toJson(ressalinf);

	}
	
	
	
	@RequestMapping(value = "/invtsimis/getTankDamSalientDetails")
	@ResponseBody
	public String getTankDamSalientDetails(MiTankInspect tankobj, HttpServletRequest request,
			HttpSession session, SessionStatus status) {

		List<Tanks> tanksalinf = new ArrayList<Tanks>();

		// List<PumpStations> pumpStationList= new ArrayList<PumpStations>();

		try {

			if (tankobj.getTankId()!=null ) {

				if (tankobj.getTankId()>0 ) {
					tanksalinf = invam.getTankDamSalientInfo(tankobj);
				}

			}

			// System.out.println("resListbyId"+resListbyId);

		} catch (InventoryUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new Gson().toJson(tanksalinf);

	}
	
	@RequestMapping(value = "/invtsimis/getDaminfoContLvlDetails")
	@ResponseBody
	public String getDaminfoContLvlDetails(ReservoirInspect resobj, HttpServletRequest request,
			HttpSession session, SessionStatus status) {

		List<ReservoirSalient> resInspectinf = new ArrayList<ReservoirSalient>();

		// List<PumpStations> pumpStationList= new ArrayList<PumpStations>();

		try {

			if (resobj.getReservoirId()!=null ) {

				if (resobj.getReservoirId()>0 ) {
					resInspectinf = invam.getresDaminfoandControlLevelInfo(resobj);
				}

			}

			// System.out.println("resListbyId"+resListbyId);

		} catch (InventoryUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new Gson().toJson(resInspectinf);

	}
   
	
	@RequestMapping(value = "/invtsimis/getTankDamInfo")
	@ResponseBody
	public String getTankDamInfo(MiTankInspect tankObj, HttpServletRequest request,
			HttpSession session, SessionStatus status) {

		List<Tanks> tanksInspectinf = new ArrayList<Tanks>();

		// List<PumpStations> pumpStationList= new ArrayList<PumpStations>();

		try {

			if (tankObj.getTankId()!=null ) {

				if (tankObj.getTankId()>0 ) {
					tanksInspectinf = invam.getTanksDaminfo(tankObj);
				}

			}

			// System.out.println("resListbyId"+resListbyId);

		} catch (InventoryUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new Gson().toJson(tanksInspectinf);

	}
	
	
	@RequestMapping(value = "/invtsimis/getTankImpControlInfo")
	@ResponseBody
	public String getTankImpControlInfo(MiTankInspect tankObj, HttpServletRequest request,
			HttpSession session, SessionStatus status) {

		List<Tanks> tanksInspectinf = new ArrayList<Tanks>();

		// List<PumpStations> pumpStationList= new ArrayList<PumpStations>();

		try {

			if (tankObj.getTankId()!=null ) {

				if (tankObj.getTankId()>0 ) {
					tanksInspectinf = invam.getTanksImpControlinfo(tankObj);
				}

			}

			// System.out.println("resListbyId"+resListbyId);

		} catch (InventoryUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new Gson().toJson(tanksInspectinf);

	}
	
	
	@RequestMapping(value = "/invtsimis/editTankImpControlInfo")
	@ResponseBody
	public String editTankImpControlInfo(Tanks tankObj, HttpServletRequest request,
			HttpSession session, SessionStatus status) {

		Integer output=0;

		// List<PumpStations> pumpStationList= new ArrayList<PumpStations>();

		try {

			if (tankObj.getTankId()!=null ) {

				if (tankObj.getTankId()>0 ) {
					output = invam.updateTankImpControlInfo(tankObj);
				}

			}

			// System.out.println("resListbyId"+resListbyId);

		} catch (InventoryUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new Gson().toJson(output);

	}
	
	@RequestMapping(value = "/invtsimis/editTankDemoInfo")
	@ResponseBody
	public String editTankDemoInfo(Tanks tankObj, HttpServletRequest request,
			HttpSession session, SessionStatus status) {

	Integer output=0;
	
	Boolean captOutput = false;

		// List<PumpStations> pumpStationList= new ArrayList<PumpStations>();

		try {
			
			User user = (User) session.getAttribute("userObj");
			String captcha = (String) session.getAttribute("CAPTCHA3");
			
			if (tankObj.getCaptcha() == null || tankObj.getTankId() == null) {
				output=-3 ;
			}else if ((tankObj.getCaptcha() != null && captcha != null)){
				
				if ((tankObj.getCaptcha() != null && !tankObj.getCaptcha().equals(captcha))) {
					// System.out.println("coming here"+damObj.getCaptcha());
				
					tankObj.setCaptcha("");
				
					captOutput = false;
					output=-2;

				}else if (tankObj.getCaptcha().equals(captcha)) {

					captOutput = true;

				}
				
				
				
			}
			
			if (captOutput == true) {	
				if (tankObj != null) {
					if (user != null) {
						

			if (tankObj.getTankId()!=null ) {
				
				if ( tankObj.getUserName() != null) {
					
					// System.out.println("user.getUserId()"+user.getUserEmpId()+"user.getUserName()"+user.getUserName());
					

					tankObj.setUserName(user.getUserName());

				}
			

				if (tankObj.getTankId()>0 ) {
					output = invam.updateTankDemoInfo(tankObj);
				}

			}
					}
				}
			}

			// System.out.println("resListbyId"+resListbyId);

		} catch (InventoryUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new Gson().toJson(output);

	}
	
	
	@RequestMapping(value = "/invtsimis/editResDemoInfo")
	@ResponseBody
	public String editResDemoInfo(ReservoirSalient resObj, HttpServletRequest request,
			HttpSession session, SessionStatus status) {

	Integer output=0;

		// List<PumpStations> pumpStationList= new ArrayList<PumpStations>();

		try {

			if (resObj.getReservoirId()!=null ) {

				if (resObj.getReservoirId()>0 ) {
					output = invam.updateResDemoInfo(resObj);
				}

			}

			// System.out.println("resListbyId"+resListbyId);

		} catch (InventoryUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new Gson().toJson(output);

	}
	
	@RequestMapping(value = "/invtsimis/editResImpControlInfo")
	@ResponseBody
	public String editResImpControlInfo(ReservoirSalient resObj, HttpServletRequest request,
			HttpSession session, SessionStatus status) {

		Integer output=0;
		Boolean captOutput = false;

		// List<PumpStations> pumpStationList= new ArrayList<PumpStations>();

		try {
			
			User user = (User) session.getAttribute("userObj");
			String captcha = (String) session.getAttribute("CAPTCHA3");
			
			if (resObj.getCaptcha() == null || resObj.getReservoirId() == null) {
				output=-3 ;
			}else if ((resObj.getCaptcha() != null && captcha != null)){
				
				if ((resObj.getCaptcha() != null && !resObj.getCaptcha().equals(captcha))) {
					// System.out.println("coming here"+damObj.getCaptcha());
				
					resObj.setCaptcha("");
				
					captOutput = false;
					output=-2;

				}else if (resObj.getCaptcha().equals(captcha)) {

					captOutput = true;

				}
				
				
				
			}
			
			if (captOutput == true) {	
				if (resObj != null) {
					
					if (user != null) {
						
if ( user.getUserName() != null) {
							
							// System.out.println("user.getUserId()"+user.getUserEmpId()+"user.getUserName()"+user.getUserName());
	//resObj.setEmpId(user.getEmpId());

	resObj.setUserName(user.getUserName());

						}

			if (resObj.getReservoirId()!=null ) {

				if (resObj.getReservoirId()>0 ) {
					output = invam.updateResImpControlInfo(resObj);
				}

			}
					}
				}
			}
			// System.out.println("resListbyId"+resListbyId);

		} catch (InventoryUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new Gson().toJson(output);

	}
	
	
	
	
	
	
	@RequestMapping(value = "/invtsimis/editResSalientInfo9")
	@ResponseBody
	public String editResSalientInfo9(ReservoirSalient resObj, HttpServletRequest request,
			HttpSession session, SessionStatus status) {

		Integer output=0;
		Boolean captOutput = false;

		// List<PumpStations> pumpStationList= new ArrayList<PumpStations>();

		try {
			
			User user = (User) session.getAttribute("userObj");
			String captcha = (String) session.getAttribute("CAPTCHA3");
			
			if (resObj.getCaptcha() == null || resObj.getReservoirId() == null) {
				output=-3 ;
			}else if ((resObj.getCaptcha() != null && captcha != null)){
				
				if ((resObj.getCaptcha() != null && !resObj.getCaptcha().equals(captcha))) {
					// System.out.println("coming here"+damObj.getCaptcha());
				
					resObj.setCaptcha("");
				
					captOutput = false;
					output=-2;

				}else if (resObj.getCaptcha().equals(captcha)) {

					captOutput = true;

				}
				
				
				
			}
			
			if (captOutput == true) {	
				if (resObj != null) {
					
					if (user != null) {
						
if ( user.getUserName() != null) {
							
							// System.out.println("user.getUserId()"+user.getUserEmpId()+"user.getUserName()"+user.getUserName());
	//resObj.setEmpId(user.getEmpId());

	resObj.setUserName(user.getUserName());

						}

			if (resObj.getReservoirId()!=null ) {

				if (resObj.getReservoirId()>0 ) {
					output = invam.updateResSalientInfo9(resObj);
				}

			}
					}
				}
			}
			// System.out.println("resListbyId"+resListbyId);

		} catch (InventoryUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new Gson().toJson(output);

	}
	
	
	
	@RequestMapping(value = "/invtsimis/editTankSalientInfo9")
	@ResponseBody
	public String editTankSalientInfo9(Tanks tankObj, HttpServletRequest request,
			HttpSession session, SessionStatus status) {

		Integer output=0;
		Boolean captOutput = false;

		// List<PumpStations> pumpStationList= new ArrayList<PumpStations>();

		try {
			
			User user = (User) session.getAttribute("userObj");
			String captcha = (String) session.getAttribute("CAPTCHA3");
			
			if (tankObj.getCaptcha() == null || tankObj.getTankId() == null) {
				output=-3 ;
			}else if ((tankObj.getCaptcha() != null && captcha != null)){
				
				if ((tankObj.getCaptcha() != null && !tankObj.getCaptcha().equals(captcha))) {
					// System.out.println("coming here"+damObj.getCaptcha());
				
					tankObj.setCaptcha("");
				
					captOutput = false;
					output=-2;

				}else if (tankObj.getCaptcha().equals(captcha)) {

					captOutput = true;

				}
				
				
				
			}
			
			if (captOutput == true) {	
				if (tankObj != null) {
					
					if (user != null) {
						
if ( user.getUserName() != null) {
							
							// System.out.println("user.getUserId()"+user.getUserEmpId()+"user.getUserName()"+user.getUserName());
	//resObj.setEmpId(user.getEmpId());

	tankObj.setUserName(user.getUserName());

						}

			if (tankObj.getTankId()!=null ) {

				if (tankObj.getTankId()>0 ) {
					output = invam.updateTankSalientInfo9(tankObj);
				}

			}
					}
				}
			}
			// System.out.println("resListbyId"+resListbyId);

		} catch (InventoryUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new Gson().toJson(output);

	}
	
	
	@RequestMapping(value = "/invtsimis/editResSalientInfo8")
	@ResponseBody
	public String editResSalientInfo8(ReservoirSalient resObj, HttpServletRequest request,
			HttpSession session, SessionStatus status) {

		Integer output=0;
		Boolean captOutput = false;

		// List<PumpStations> pumpStationList= new ArrayList<PumpStations>();

		try {
			
			User user = (User) session.getAttribute("userObj");
			String captcha = (String) session.getAttribute("CAPTCHA3");
			
			if (resObj.getCaptcha() == null || resObj.getReservoirId() == null) {
				output=-3 ;
			}else if ((resObj.getCaptcha() != null && captcha != null)){
				
				if ((resObj.getCaptcha() != null && !resObj.getCaptcha().equals(captcha))) {
					// System.out.println("coming here"+damObj.getCaptcha());
				
					resObj.setCaptcha("");
				
					captOutput = false;
					output=-2;

				}else if (resObj.getCaptcha().equals(captcha)) {

					captOutput = true;

				}
				
				
				
			}
			
			if (captOutput == true) {	
				if (resObj != null) {
					
					if (user != null) {
						
if ( user.getUserName() != null) {
							
							// System.out.println("user.getUserId()"+user.getUserEmpId()+"user.getUserName()"+user.getUserName());
	//resObj.setEmpId(user.getEmpId());

	resObj.setUserName(user.getUserName());

						}

			if (resObj.getReservoirId()!=null ) {

				if (resObj.getReservoirId()>0 ) {
					output = invam.updateResSalientInfo8(resObj);
				}

			}
					}
				}
			}
			// System.out.println("resListbyId"+resListbyId);

		} catch (InventoryUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new Gson().toJson(output);

	}
	
	@RequestMapping(value = "/invtsimis/editTankSalientInfo8")
	@ResponseBody
	public String editTankSalientInfo8(Tanks tankObj, HttpServletRequest request,
			HttpSession session, SessionStatus status) {

		Integer output=0;
		Boolean captOutput = false;

		// List<PumpStations> pumpStationList= new ArrayList<PumpStations>();

		try {
			
			User user = (User) session.getAttribute("userObj");
			String captcha = (String) session.getAttribute("CAPTCHA3");
			
			if (tankObj.getCaptcha() == null || tankObj.getTankId() == null) {
				output=-3 ;
			}else if ((tankObj.getCaptcha() != null && captcha != null)){
				
				if ((tankObj.getCaptcha() != null && !tankObj.getCaptcha().equals(captcha))) {
					// System.out.println("coming here"+damObj.getCaptcha());
				
					tankObj.setCaptcha("");
				
					captOutput = false;
					output=-2;

				}else if (tankObj.getCaptcha().equals(captcha)) {

					captOutput = true;

				}
				
				
				
			}
			
			if (captOutput == true) {	
				if (tankObj != null) {
					
					if (user != null) {
						
if ( user.getUserName() != null) {
							
							// System.out.println("user.getUserId()"+user.getUserEmpId()+"user.getUserName()"+user.getUserName());
	//resObj.setEmpId(user.getEmpId());

	tankObj.setUserName(user.getUserName());

						}

			if (tankObj.getTankId()!=null ) {

				if (tankObj.getTankId()>0 ) {
					output = invam.updateTankSalientInfo8(tankObj);
				}

			}
					}
				}
			}
			// System.out.println("resListbyId"+resListbyId);

		} catch (InventoryUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new Gson().toJson(output);

	}
	
	
	
	@RequestMapping(value = "/invtsimis/editResSalientInfo7")
	@ResponseBody
	public String editResSalientInfo7(ReservoirSalient resObj, HttpServletRequest request,
			HttpSession session, SessionStatus status) {

		Integer output=0;
		Boolean captOutput = false;

		// List<PumpStations> pumpStationList= new ArrayList<PumpStations>();

		try {
			
			User user = (User) session.getAttribute("userObj");
			String captcha = (String) session.getAttribute("CAPTCHA3");
			
			if (resObj.getCaptcha() == null || resObj.getReservoirId() == null) {
				output=-3 ;
			}else if ((resObj.getCaptcha() != null && captcha != null)){
				
				if ((resObj.getCaptcha() != null && !resObj.getCaptcha().equals(captcha))) {
					// System.out.println("coming here"+damObj.getCaptcha());
				
					resObj.setCaptcha("");
				
					captOutput = false;
					output=-2;

				}else if (resObj.getCaptcha().equals(captcha)) {

					captOutput = true;

				}
				
				
				
			}
			
			if (captOutput == true) {	
				if (resObj != null) {
					
					if (user != null) {
						
if ( user.getUserName() != null) {
							
							// System.out.println("user.getUserId()"+user.getUserEmpId()+"user.getUserName()"+user.getUserName());
	//resObj.setEmpId(user.getEmpId());

	resObj.setUserName(user.getUserName());

						}

			if (resObj.getReservoirId()!=null ) {

				if (resObj.getReservoirId()>0 ) {
					output = invam.updateResSalientInfo7(resObj);
				}

			}
					}
				}
			}
			// System.out.println("resListbyId"+resListbyId);

		} catch (InventoryUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new Gson().toJson(output);

	}
	
	
	@RequestMapping(value = "/invtsimis/editTankSalientInfo7")
	@ResponseBody
	public String editTankSalientInfo7(Tanks tankObj, HttpServletRequest request,
			HttpSession session, SessionStatus status) {

		Integer output=0;
		Boolean captOutput = false;

		// List<PumpStations> pumpStationList= new ArrayList<PumpStations>();

		try {
			
			User user = (User) session.getAttribute("userObj");
			String captcha = (String) session.getAttribute("CAPTCHA3");
			
			if (tankObj.getCaptcha() == null || tankObj.getTankId() == null) {
				output=-3 ;
			}else if ((tankObj.getCaptcha() != null && captcha != null)){
				
				if ((tankObj.getCaptcha() != null && !tankObj.getCaptcha().equals(captcha))) {
					// System.out.println("coming here"+damObj.getCaptcha());
				
					tankObj.setCaptcha("");
				
					captOutput = false;
					output=-2;

				}else if (tankObj.getCaptcha().equals(captcha)) {

					captOutput = true;

				}
				
				
				
			}
			
			if (captOutput == true) {	
				if (tankObj != null) {
					
					if (user != null) {
						
if ( user.getUserName() != null) {
							
							// System.out.println("user.getUserId()"+user.getUserEmpId()+"user.getUserName()"+user.getUserName());
	//resObj.setEmpId(user.getEmpId());

	tankObj.setUserName(user.getUserName());

						}

			if (tankObj.getTankId()!=null ) {

				if (tankObj.getTankId()>0 ) {
					output = invam.updateTankSalientInfo7(tankObj);
				}

			}
					}
				}
			}
			// System.out.println("resListbyId"+resListbyId);

		} catch (InventoryUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new Gson().toJson(output);

	}
	
	
	
	
	
	@RequestMapping(value = "/invtsimis/editResSalientInfo5")
	@ResponseBody
	public String editResSalientInfo5(ReservoirSalient resObj, HttpServletRequest request,
			HttpSession session, SessionStatus status) {

		Integer output=0;
		Boolean captOutput = false;

		// List<PumpStations> pumpStationList= new ArrayList<PumpStations>();

		try {
			
			User user = (User) session.getAttribute("userObj");
			String captcha = (String) session.getAttribute("CAPTCHA3");
			
			if (resObj.getCaptcha() == null || resObj.getReservoirId() == null) {
				output=-3 ;
			}else if ((resObj.getCaptcha() != null && captcha != null)){
				
				if ((resObj.getCaptcha() != null && !resObj.getCaptcha().equals(captcha))) {
					// System.out.println("coming here"+damObj.getCaptcha());
				
					resObj.setCaptcha("");
				
					captOutput = false;
					output=-2;

				}else if (resObj.getCaptcha().equals(captcha)) {

					captOutput = true;

				}
				
				
				
			}
			
			if (captOutput == true) {	
				if (resObj != null) {
					
					if (user != null) {
						
if ( user.getUserName() != null) {
							
							// System.out.println("user.getUserId()"+user.getUserEmpId()+"user.getUserName()"+user.getUserName());
	//resObj.setEmpId(user.getEmpId());

	resObj.setUserName(user.getUserName());

						}

			if (resObj.getReservoirId()!=null ) {

				if (resObj.getReservoirId()>0 ) {
					output = invam.updateResSalientInfo5(resObj);
				}

			}
					}
				}
			}
			// System.out.println("resListbyId"+resListbyId);

		} catch (InventoryUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new Gson().toJson(output);

	}
	
	@RequestMapping(value = "/invtsimis/editTankSalientInfo5")
	@ResponseBody
	public String editTankSalientInfo5(Tanks tankObj, HttpServletRequest request,
			HttpSession session, SessionStatus status) {

		Integer output=0;
		Boolean captOutput = false;

		// List<PumpStations> pumpStationList= new ArrayList<PumpStations>();

		try {
			
			User user = (User) session.getAttribute("userObj");
			String captcha = (String) session.getAttribute("CAPTCHA3");
			
			if (tankObj.getCaptcha() == null || tankObj.getTankId() == null) {
				output=-3 ;
			}else if ((tankObj.getCaptcha() != null && captcha != null)){
				
				if ((tankObj.getCaptcha() != null && !tankObj.getCaptcha().equals(captcha))) {
					// System.out.println("coming here"+damObj.getCaptcha());
				
					tankObj.setCaptcha("");
				
					captOutput = false;
					output=-2;

				}else if (tankObj.getCaptcha().equals(captcha)) {

					captOutput = true;

				}
				
				
				
			}
			
			if (captOutput == true) {	
				if (tankObj != null) {
					
					if (user != null) {
						
if ( user.getUserName() != null) {
							
							// System.out.println("user.getUserId()"+user.getUserEmpId()+"user.getUserName()"+user.getUserName());
	//resObj.setEmpId(user.getEmpId());

	tankObj.setUserName(user.getUserName());

						}

			if (tankObj.getTankId()!=null ) {

				if (tankObj.getTankId()>0 ) {
					output = invam.updateTankSalientInfo5(tankObj);
				}

			}
					}
				}
			}
			// System.out.println("resListbyId"+resListbyId);

		} catch (InventoryUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new Gson().toJson(output);

	}
	
	
	
	@RequestMapping(value = "/invtsimis/editResSalientInfo4")
	@ResponseBody
	public String editResSalientInfo4(ReservoirSalient resObj, HttpServletRequest request,
			HttpSession session, SessionStatus status) {

		Integer output=0;
		Boolean captOutput = false;

		// List<PumpStations> pumpStationList= new ArrayList<PumpStations>();

		try {
			
			User user = (User) session.getAttribute("userObj");
			String captcha = (String) session.getAttribute("CAPTCHA3");
			
			if (resObj.getCaptcha() == null || resObj.getReservoirId() == null) {
				output=-3 ;
			}else if ((resObj.getCaptcha() != null && captcha != null)){
				
				if ((resObj.getCaptcha() != null && !resObj.getCaptcha().equals(captcha))) {
					// System.out.println("coming here"+damObj.getCaptcha());
				
					resObj.setCaptcha("");
				
					captOutput = false;
					output=-2;

				}else if (resObj.getCaptcha().equals(captcha)) {

					captOutput = true;

				}
				
				
				
			}
			
			if (captOutput == true) {	
				if (resObj != null) {
					
					if (user != null) {
						
if ( user.getUserName() != null) {
							
							// System.out.println("user.getUserId()"+user.getUserEmpId()+"user.getUserName()"+user.getUserName());
	//resObj.setEmpId(user.getEmpId());

	resObj.setUserName(user.getUserName());

						}

			if (resObj.getReservoirId()!=null ) {

				if (resObj.getReservoirId()>0 ) {
					output = invam.updateResSalientInfo4(resObj);
				}

			}
					}
				}
			}
			// System.out.println("resListbyId"+resListbyId);

		} catch (InventoryUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new Gson().toJson(output);

	}
	
	
	@RequestMapping(value = "/invtsimis/editTankSalientInfo4")
	@ResponseBody
	public String editTankSalientInfo4(Tanks tankObj, HttpServletRequest request,
			HttpSession session, SessionStatus status) {

		Integer output=0;
		Boolean captOutput = false;

		// List<PumpStations> pumpStationList= new ArrayList<PumpStations>();

		try {
			
			User user = (User) session.getAttribute("userObj");
			String captcha = (String) session.getAttribute("CAPTCHA3");
			
			if (tankObj.getCaptcha() == null || tankObj.getTankId() == null) {
				output=-3 ;
			}else if ((tankObj.getCaptcha() != null && captcha != null)){
				
				if ((tankObj.getCaptcha() != null && !tankObj.getCaptcha().equals(captcha))) {
					// System.out.println("coming here"+damObj.getCaptcha());
				
					tankObj.setCaptcha("");
				
					captOutput = false;
					output=-2;

				}else if (tankObj.getCaptcha().equals(captcha)) {

					captOutput = true;

				}
				
				
				
			}
			
			if (captOutput == true) {	
				if (tankObj != null) {
					
					if (user != null) {
						
if ( user.getUserName() != null) {
							
							// System.out.println("user.getUserId()"+user.getUserEmpId()+"user.getUserName()"+user.getUserName());
	//resObj.setEmpId(user.getEmpId());

	tankObj.setUserName(user.getUserName());

						}

			if (tankObj.getTankId()!=null ) {

				if (tankObj.getTankId()>0 ) {
					output = invam.updateTankSalientInfo4(tankObj);
				}

			}
					}
				}
			}
			// System.out.println("resListbyId"+resListbyId);

		} catch (InventoryUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new Gson().toJson(output);

	}
	
	@RequestMapping(value = "/invtsimis/editResSalientInfo3")
	@ResponseBody
	public String editResSalientInfo3(ReservoirSalient resObj, HttpServletRequest request,
			HttpSession session, SessionStatus status) {

		Integer output=0;
		Boolean captOutput = false;

		// List<PumpStations> pumpStationList= new ArrayList<PumpStations>();

		try {
			
			User user = (User) session.getAttribute("userObj");
			String captcha = (String) session.getAttribute("CAPTCHA3");
			
			if (resObj.getCaptcha() == null || resObj.getReservoirId() == null) {
				output=-3 ;
			}else if ((resObj.getCaptcha() != null && captcha != null)){
				
				if ((resObj.getCaptcha() != null && !resObj.getCaptcha().equals(captcha))) {
					// System.out.println("coming here"+damObj.getCaptcha());
				
					resObj.setCaptcha("");
				
					captOutput = false;
					output=-2;

				}else if (resObj.getCaptcha().equals(captcha)) {

					captOutput = true;

				}
				
				
				
			}
			
			if (captOutput == true) {	
				if (resObj != null) {
					
					if (user != null) {
						
if ( user.getUserName() != null) {
							
							// System.out.println("user.getUserId()"+user.getUserEmpId()+"user.getUserName()"+user.getUserName());
	//resObj.setEmpId(user.getEmpId());

	resObj.setUserName(user.getUserName());

						}

			if (resObj.getReservoirId()!=null ) {

				if (resObj.getReservoirId()>0 ) {
					output = invam.updateResSalientInfo3(resObj);
				}

			}
					}
				}
			}
			// System.out.println("resListbyId"+resListbyId);

		} catch (InventoryUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new Gson().toJson(output);

	}
	
	@RequestMapping(value = "/invtsimis/editTankSalientInfo3")
	@ResponseBody
	public String editTankSalientInfo3(Tanks tankObj, HttpServletRequest request,
			HttpSession session, SessionStatus status) {

		Integer output=0;
		Boolean captOutput = false;

		// List<PumpStations> pumpStationList= new ArrayList<PumpStations>();

		try {
			
			User user = (User) session.getAttribute("userObj");
			String captcha = (String) session.getAttribute("CAPTCHA3");
			
			if (tankObj.getCaptcha() == null || tankObj.getTankId() == null) {
				output=-3 ;
			}else if ((tankObj.getCaptcha() != null && captcha != null)){
				
				if ((tankObj.getCaptcha() != null && !tankObj.getCaptcha().equals(captcha))) {
					// System.out.println("coming here"+damObj.getCaptcha());
				
					tankObj.setCaptcha("");
				
					captOutput = false;
					output=-2;

				}else if (tankObj.getCaptcha().equals(captcha)) {

					captOutput = true;

				}
				
				
				
			}
			
			if (captOutput == true) {	
				if (tankObj != null) {
					
					if (user != null) {
						
if ( user.getUserName() != null) {
							
							// System.out.println("user.getUserId()"+user.getUserEmpId()+"user.getUserName()"+user.getUserName());
	//resObj.setEmpId(user.getEmpId());

	tankObj.setUserName(user.getUserName());

						}

			if (tankObj.getTankId()!=null ) {

				if (tankObj.getTankId()>0 ) {
					output = invam.updateTankSalientInfo3(tankObj);
				}

			}
					}
				}
			}
			// System.out.println("resListbyId"+resListbyId);

		} catch (InventoryUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new Gson().toJson(output);

	}
	
	
	@RequestMapping(value = "/invtsimis/editResSalientInfo2")
	@ResponseBody
	public String editResSalientInfo2(ReservoirSalient resObj, HttpServletRequest request,
			HttpSession session, SessionStatus status) {

		Integer output=0;
		Boolean captOutput = false;

		// List<PumpStations> pumpStationList= new ArrayList<PumpStations>();

		try {
			
			User user = (User) session.getAttribute("userObj");
			String captcha = (String) session.getAttribute("CAPTCHA3");
			
			if (resObj.getCaptcha() == null || resObj.getReservoirId() == null) {
				output=-3 ;
			}else if ((resObj.getCaptcha() != null && captcha != null)){
				
				if ((resObj.getCaptcha() != null && !resObj.getCaptcha().equals(captcha))) {
					// System.out.println("coming here"+damObj.getCaptcha());
				
					resObj.setCaptcha("");
				
					captOutput = false;
					output=-2;

				}else if (resObj.getCaptcha().equals(captcha)) {

					captOutput = true;

				}
				
				
				
			}
			
			if (captOutput == true) {	
				if (resObj != null) {
					
					if (user != null) {
						
if ( user.getUserName() != null) {
							
							// System.out.println("user.getUserId()"+user.getUserEmpId()+"user.getUserName()"+user.getUserName());
	//resObj.setEmpId(user.getEmpId());

	resObj.setUserName(user.getUserName());

						}

			if (resObj.getReservoirId()!=null ) {

				if (resObj.getReservoirId()>0 ) {
					output = invam.updateResSalientInfo2(resObj);
				}

			}
					}
				}
			}
			// System.out.println("resListbyId"+resListbyId);

		} catch (InventoryUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new Gson().toJson(output);

	}
	
	@RequestMapping(value = "/invtsimis/editTankSalientInfo2")
	@ResponseBody
	public String editTankSalientInfo2(Tanks tankObj, HttpServletRequest request,
			HttpSession session, SessionStatus status) {

		Integer output=0;
		Boolean captOutput = false;

		// List<PumpStations> pumpStationList= new ArrayList<PumpStations>();

		try {
			
			User user = (User) session.getAttribute("userObj");
			String captcha = (String) session.getAttribute("CAPTCHA3");
			
			if (tankObj.getCaptcha() == null || tankObj.getTankId() == null) {
				output=-3 ;
			}else if ((tankObj.getCaptcha() != null && captcha != null)){
				
				if ((tankObj.getCaptcha() != null && !tankObj.getCaptcha().equals(captcha))) {
					// System.out.println("coming here"+damObj.getCaptcha());
				
					tankObj.setCaptcha("");
				
					captOutput = false;
					output=-2;

				}else if (tankObj.getCaptcha().equals(captcha)) {

					captOutput = true;

				}
				
				
				
			}
			
			if (captOutput == true) {	
				if (tankObj != null) {
					
					if (user != null) {
						
if ( user.getUserName() != null) {
							
							// System.out.println("user.getUserId()"+user.getUserEmpId()+"user.getUserName()"+user.getUserName());
	//resObj.setEmpId(user.getEmpId());

	tankObj.setUserName(user.getUserName());

						}

			if (tankObj.getTankId()!=null ) {

				if (tankObj.getTankId()>0 ) {
					output = invam.updateTankSalientInfo2(tankObj);
				}

			}
					}
				}
			}
			// System.out.println("resListbyId"+resListbyId);

		} catch (InventoryUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new Gson().toJson(output);

	}
	
	
	@RequestMapping(value = "/invtsimis/editResSalientInfo1")
	@ResponseBody
	public String editResSalientInfo1(ReservoirSalient resObj, HttpServletRequest request,
			HttpSession session, SessionStatus status) {

		Integer output=0;
		Boolean captOutput = false;

		// List<PumpStations> pumpStationList= new ArrayList<PumpStations>();

		try {
			
			User user = (User) session.getAttribute("userObj");
			String captcha = (String) session.getAttribute("CAPTCHA3");
			
			if (resObj.getCaptcha() == null || resObj.getReservoirId() == null) {
				output=-3 ;
			}else if ((resObj.getCaptcha() != null && captcha != null)){
				
				if ((resObj.getCaptcha() != null && !resObj.getCaptcha().equals(captcha))) {
					// System.out.println("coming here"+damObj.getCaptcha());
				
					resObj.setCaptcha("");
				
					captOutput = false;
					output=-2;

				}else if (resObj.getCaptcha().equals(captcha)) {

					captOutput = true;

				}
				
				
				
			}
			
			if (captOutput == true) {	
				if (resObj != null) {
					
					if (user != null) {
						
if ( user.getUserName() != null) {
							
							// System.out.println("user.getUserId()"+user.getUserEmpId()+"user.getUserName()"+user.getUserName());
	//resObj.setEmpId(user.getEmpId());

	resObj.setUserName(user.getUserName());

						}

			if (resObj.getReservoirId()!=null ) {

				if (resObj.getReservoirId()>0 ) {
					output = invam.updateResSalientInfo1(resObj);
				}

			}
					}
				}
			}
			// System.out.println("resListbyId"+resListbyId);

		} catch (InventoryUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new Gson().toJson(output);

	}
	
	
	@RequestMapping(value = "/invtsimis/editTankSalientInfo1")
	@ResponseBody
	public String editTankSalientInfo1(Tanks tankObj, HttpServletRequest request,
			HttpSession session, SessionStatus status) {

		Integer output=0;
		Boolean captOutput = false;

		// List<PumpStations> pumpStationList= new ArrayList<PumpStations>();

		try {
			
			User user = (User) session.getAttribute("userObj");
			String captcha = (String) session.getAttribute("CAPTCHA3");
			
			if (tankObj.getCaptcha() == null || tankObj.getTankId() == null) {
				output=-3 ;
			}else if ((tankObj.getCaptcha() != null && captcha != null)){
				
				if ((tankObj.getCaptcha() != null && !tankObj.getCaptcha().equals(captcha))) {
					// System.out.println("coming here"+damObj.getCaptcha());
				
					tankObj.setCaptcha("");
				
					captOutput = false;
					output=-2;

				}else if (tankObj.getCaptcha().equals(captcha)) {

					captOutput = true;

				}
				
				
				
			}
			
			if (captOutput == true) {	
				if (tankObj != null) {
					
					if (user != null) {
						
if ( user.getUserName() != null) {
							
							// System.out.println("user.getUserId()"+user.getUserEmpId()+"user.getUserName()"+user.getUserName());
	//resObj.setEmpId(user.getEmpId());

	tankObj.setUserName(user.getUserName());

						}

			if (tankObj.getTankId()!=null ) {

				if (tankObj.getTankId()>0 ) {
					output = invam.updateTankSalientInfo1(tankObj);
				}

			}
					}
				}
			}
			// System.out.println("resListbyId"+resListbyId);

		} catch (InventoryUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new Gson().toJson(output);

	}
	
	
	@RequestMapping(value = "/invtsimis/update-dam-status")
	@ResponseBody
	public String updatedamStatus(@ModelAttribute("damstatus") ReservoirInspect resobj, HttpServletRequest request, HttpSession session,
			SessionStatus status) {

		List<ReservoirInspect> resInspect = new ArrayList<ReservoirInspect>();

		// List<PumpStations> pumpStationList= new ArrayList<PumpStations>();
		Integer output=0;

		try {

			if (resobj!=null ) {
				
				User user = (User) session.getAttribute("userObj");

				if (resobj != null) {
		//			System.out.println("update-critical-status miobj"+miobj);
				 
					if (user != null) {

						if (user.getUserEmpId() != null || user.getUserName() != null) {

							// System.out.println("user.getUserId()"+user.getUserEmpId()+"user.getUserName()"+user.getUserName());
							resobj.setUserEmpId(user.getUserEmpId());

							resobj.setUserName(user.getUserName());

						}

						if (user.getUserId() != null) {
							resobj.setUserId(user.getUserId());

						} else {
							resobj.setUserId(0);

						}
//System.out.println("miobj"+miobj);
//System.out.println("miobj"+miobj.getMitankCapacityId()+"---"+miobj.getRemarks());

if(resobj.getResInspectMst1Id()!=null && resobj.getConditionofDamId()!=null){
				if (resobj.getResInspectMst1Id()>0 ) {
					
		//			System.out.println("(miobj.getMiInpsectMst1Id()"+miobj.getMiInpsectMst1Id());
					output = invam.updateDamConditionStatus(resobj);
				}
}
			}
				}
			}

//			 System.out.println("IAC updateTankCrticalStatus output"+output);

		} catch (InventoryUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new Gson().toJson(output);

	}
	
	
	@RequestMapping(value = "/invtsimis/delete-reviewid")
	@ResponseBody
	public String deleteremarksreviewid(ReservoirInspect resobj, HttpServletRequest request,
			HttpSession session, SessionStatus status) {

	Integer output=0;

		// List<PumpStations> pumpStationList= new ArrayList<PumpStations>();

		try {

			if (resobj.getResRemarksMst1ReviewId()!=null ) {

				if (resobj.getResRemarksMst1ReviewId()>0 ) {
					output = invam.deleteAnnRemarksReviewId(resobj);
				}

			}

			// System.out.println("resListbyId"+resListbyId);

		} catch (InventoryUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new Gson().toJson(output);

	}
	
	
	@RequestMapping(value = "/invtsimis/delete-annmst")
	@ResponseBody
	public String deleteRemarksReviewId(ReservoirInspect resobj, HttpServletRequest request,
			HttpSession session, SessionStatus status) {

	Integer output=0;

		// List<PumpStations> pumpStationList= new ArrayList<PumpStations>();

		try {

			if (resobj.getResInspectMst2Id()!=null ) {

				if (resobj.getResInspectMst2Id()>0 ) {
					output = invam.deleteAnnMst2byMst2Id(resobj);
				}

			}

			// System.out.println("resListbyId"+resListbyId);

		} catch (InventoryUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new Gson().toJson(output);

	}
	
	
	@RequestMapping(value = "/invtsimis/delete_recommend_recid")
	@ResponseBody
	public String deleteRecommendrecid(ReservoirInspect resobj, HttpServletRequest request,
			HttpSession session, SessionStatus status) {

	Integer output=0;

		// List<PumpStations> pumpStationList= new ArrayList<PumpStations>();

		try {

			if (resobj.getResRecommendId()!=null ) {

				if (resobj.getResRecommendId()>0 ) {
					output = invam.deleteAnnRecommendationbyRecommendId(resobj);
				}

			}

			// System.out.println("resListbyId"+resListbyId);

		} catch (InventoryUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new Gson().toJson(output);

	}
	
	@RequestMapping(value = "/invtsimis/delete_res_ann_docs")
	@ResponseBody
	public String deleteResAnnDocs(DamInspectDocs resdocobj, HttpServletRequest request,
			HttpSession session, SessionStatus status) {

	Integer output=0;

		// List<PumpStations> pumpStationList= new ArrayList<PumpStations>();

		try {

			if (resdocobj.getDamdocId()!=null ) {

				if (resdocobj.getDamdocId()>0 ) {
					output = invam.deleteResAnnDocs(resdocobj);
				}

			}

			// System.out.println("resListbyId"+resListbyId);

		} catch (InventoryUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new Gson().toJson(output);

	}
	
	
	@RequestMapping(value = "/invtsimis/delete_res_health_details")
	@ResponseBody
	public String deleteResHealthDetails(ReservoirInspect resdocobj, HttpServletRequest request,
			HttpSession session, SessionStatus status) {

	Integer output=0;

		// List<PumpStations> pumpStationList= new ArrayList<PumpStations>();

		try {

			if (resdocobj.getResDamHealthId()!=null ) {

				if (resdocobj.getResDamHealthId()>0 ) {
					output = invam.deleteResHealthDetails(resdocobj);
				}

			}

			// System.out.println("resListbyId"+resListbyId);

		} catch (InventoryUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new Gson().toJson(output);

	}
	
	@RequestMapping(value = "/invtsimis/delete-res-inspection-details")
	@ResponseBody
	public String deleteResInspectionDetails(ReservoirInspect resobj, HttpServletRequest request,
			HttpSession session, SessionStatus status) {

	Integer output=0;

		// List<PumpStations> pumpStationList= new ArrayList<PumpStations>();
	User user = (User) session.getAttribute("userObj");	
		try {
			
			if (user != null) {
				
				if(user.getUnitId()!=null){
					if(user.getUnitId()>0){
						resobj.setUserName(user.getUserName());
						resobj.setUnitId(user.getUnitId());
						resobj.setCircleId(user.getCircleId());
						resobj.setDivisionId(user.getDivisionId());
						resobj.setSubdivisionId(user.getSubdivisionId());
						
						resobj.setSectionId(user.getSectionId());
						resobj.setPostId(user.getPost());
					}
				}
			}

			if (resobj.getResinspectInfoId()!=null ) {

				if (resobj.getResinspectInfoId()>0 ) {
					
					//System.out.println("resobj.getResinspectInfoId()"+resobj.getResinspectInfoId());
					output = invam.deleteResInspectInfoDetails(resobj);
				}

			}

			// System.out.println("resListbyId"+resListbyId);

		} catch (InventoryUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new Gson().toJson(output);

	}
	
	
	@RequestMapping(value = "/invtsimis/delete_res_act_details")
	@ResponseBody
	public String deleteResActionTakenDetails(ReservoirInspect resobj, HttpServletRequest request,
			HttpSession session, SessionStatus status) {

	Integer output=0;

		// List<PumpStations> pumpStationList= new ArrayList<PumpStations>();

		try {

			if (resobj.getResDamActionId()!=null ) {

				if (resobj.getResDamActionId()>0 ) {
					output = invam.deleteResActionTakeninfo(resobj);
				}

			}

			// System.out.println("resListbyId"+resListbyId);

		} catch (InventoryUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new Gson().toJson(output);

	}
	
	
	@RequestMapping(value = "/invtsimis/update-inspectinfo")
	@ResponseBody
	public String updateInspectinfo(ReservoirInspect resobj, HttpServletRequest request,
			HttpSession session, SessionStatus status) {

	Integer output=0;
	
	Boolean captOutput = false;

		// List<PumpStations> pumpStationList= new ArrayList<PumpStations>();

		try {
			
			User user = (User) session.getAttribute("userObj");
			String captcha = (String) session.getAttribute("CAPTCHA");
			
			if (resobj.getCaptcha() == null || resobj.getResinspectInfoId() == null) {
				output=-3 ;
			}else if ((resobj.getCaptcha() != null && captcha != null)){
				
				if ((resobj.getCaptcha() != null && !resobj.getCaptcha().equals(captcha))) {
					// System.out.println("coming here"+damObj.getCaptcha());
				
					resobj.setCaptcha("");
				
					captOutput = false;
					output=-2;

				}else if (resobj.getCaptcha().equals(captcha)) {

					captOutput = true;

				}
				
				
				
			}
			
			
			if (captOutput == true) {	
				if (resobj != null) {
					if (user != null) {
						
						if (user.getEmpId() != null || user.getUserName() != null) {
							
							// System.out.println("user.getUserId()"+user.getUserEmpId()+"user.getUserName()"+user.getUserName());
							resobj.setEmpId(user.getEmpId());

							resobj.setUserName(user.getUserName());

						}
					

			if (resobj.getResinspectInfoId()!=null ) {

				if (resobj.getResinspectInfoId()>0 ) {
					
					// System.out.println("resobj.getResinspectInfoId()"+resobj.getResinspectInfoId());
					output = invam.UpdateNrldInspectionInfo(resobj);
				}

			}
         
					}
				}
			}
			// System.out.println("resListbyId"+resListbyId);

		} catch (InventoryUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new Gson().toJson(output);

	}
	
	
	@RequestMapping(value = "/invtsimis/update-inspectmst2info")
	@ResponseBody
	public String updateInspectmst2info(ReservoirInspect resobj, HttpServletRequest request,
			HttpSession session, SessionStatus status) {

	Integer output=0;
	
	

		// List<PumpStations> pumpStationList= new ArrayList<PumpStations>();

		try {
			
			User user = (User) session.getAttribute("userObj");
			
			
			
				if (resobj != null) {
					if (user != null) {
						
						if (user.getEmpId() != null || user.getUserName() != null) {
							
							// System.out.println("user.getUserId()"+user.getUserEmpId()+"user.getUserName()"+user.getUserName());
							resobj.setEmpId(user.getEmpId());

							resobj.setUserName(user.getUserName());

						}
				//System.out.println("resobj.getDamcheckResponseId()"+resobj.getDamcheckResponseId());	
				//System.out.println("resobj.getConditionofCheckId()"+resobj.getConditionofCheckId());

			if (resobj.getResInspectMst2Id()!=null ) {

				if (resobj.getResInspectMst2Id()>0 ) {
					
					// System.out.println("resobj.getResinspectInfoId()"+resobj.getResinspectInfoId());
					output = invam.UpdateNrldAnnmst2Info(resobj);
				}

			}
         
					}
				}
			
			// System.out.println("resListbyId"+resListbyId);

		} catch (InventoryUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new Gson().toJson(output);

	}
	
	
	@RequestMapping(value = "/invtsimis/get-damremarks-review")
	@ResponseBody
	public String getDamremarksReview(ReservoirInspect resobj, HttpServletRequest request, HttpSession session) {
		ModelAndView mav = new ModelAndView();
		
	
		
		
		
		List<ReservoirInspect> resInspect= new ArrayList<ReservoirInspect>();
		try {
		
		User user = (User) session.getAttribute("userObj");	
	if (user != null ) {
		if(user.getUnitId()!=null){
			
		
			if(resobj.getResRemarksMst1ReviewId()!=null){	
		
			resInspect = invam.getResDamInspectRemarksByReviewId(resobj);
			}
			
			
				
			
				
	
		}
	}
		
		} catch (InventoryUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return new Gson().toJson(resInspect);

	}
	
	
	@RequestMapping(value = "/invtsimis/update-DamRemarksinfo")
	@ResponseBody
	public String updateDamRemarksinfo(ReservoirInspect resobj, HttpServletRequest request,
			HttpSession session, SessionStatus status) {

	Integer output=0;
	
	Boolean captOutput = false;

		// List<PumpStations> pumpStationList= new ArrayList<PumpStations>();

		try {
			
			User user = (User) session.getAttribute("userObj");
			String captcha = (String) session.getAttribute("CAPTCHA2");
			
			//System.out.println("coming here"+resobj.getCaptcha());
			
			//System.out.println("captcha"+captcha);
			
			if (resobj.getCaptcha() == null || resobj.getResRemarksMst1ReviewId() == null) {
				output=-3 ;
			}else if ((resobj.getCaptcha() != null && captcha != null)){
				
				if ((resobj.getCaptcha() != null && !resobj.getCaptcha().equals(captcha))) {
					// System.out.println("coming here"+damObj.getCaptcha());
				
					resobj.setCaptcha("");
				
					captOutput = false;
					output=-2;

				}else if (resobj.getCaptcha().equals(captcha)) {

					captOutput = true;

				}
				
				
				
			}
			
			
			if (captOutput == true) {	
				if (resobj != null) {
					if (user != null) {
						
						if (user.getEmpId() != null || user.getUserName() != null) {
							
							// System.out.println("user.getUserId()"+user.getUserEmpId()+"user.getUserName()"+user.getUserName());
							resobj.setEmpId(user.getEmpId());

							resobj.setUserName(user.getUserName());

						}
					

			if (resobj.getResRemarksMst1ReviewId()!=null ) {

				if (resobj.getResRemarksMst1ReviewId()>0 ) {
					
					// System.out.println("resobj.getResinspectInfoId()"+resobj.getResinspectInfoId());
					output = invam.UpdateNrldDamRemarksinfo(resobj);
				}

			}
         
					}
				}
			}
			// System.out.println("resListbyId"+resListbyId);

		} catch (InventoryUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new Gson().toJson(output);

	}
	
	
	@RequestMapping(value = "/invtsimis/get-damremarksbyresyeartank")
	@ResponseBody
	public String getDamremarksbyresyeartank(ReservoirInspect resobj, HttpServletRequest request, HttpSession session) {
		ModelAndView mav = new ModelAndView();
		
	
		//System.out.println("resobj.getDutyFrequencyId()"+resobj.getDutyFrequencyId());
		
		//System.out.println("resobj.getYear()"+resobj.getYear());
		
		
		
		
		
		List<ReservoirInspect> resInspect= new ArrayList<ReservoirInspect>();
		try {
		
		User user = (User) session.getAttribute("userObj");	
		
		//System.out.println("user.getUnitId()"+user.getUnitId());
	if (user != null ) {
		if(user.getUnitId()!=null){
			
			//System.out.println("resobj.getReservoirId()"+resobj.getReservoirId());
			
			//System.out.println("resobj.getTankId()"+resobj.getTankId());
			
		
			if(resobj.getDutyFrequencyId()!=null && resobj.getYear()!=null && resobj.getReservoirId()!=null && resobj.getTankId()!=null){
				
				if((resobj.getDutyFrequencyId()>0 && resobj.getYear()>0 && resobj.getReservoirId()>0 && resobj.getTankId()==0)||
						(resobj.getDutyFrequencyId()>0 && resobj.getYear()>0 && resobj.getReservoirId()==0 && resobj.getTankId()>0)	){
		
					
					//System.out.println("resobj.getReservoirId()123"+resobj.getReservoirId());
					
					//System.out.println("resobj.getTankId()123"+resobj.getTankId());
			resInspect = invam.getResAnnRecomndbytankresyear(resobj);
			
				}
			}
			
			
				
			
				
	
		}
	}
		
		} catch (InventoryUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return new Gson().toJson(resInspect);

	}
	
	
	
	@RequestMapping(value = "/invtsimis/get-damremarksbyrecId")
	@ResponseBody
	public String getDamremarksbyrecId(ReservoirInspect resobj, HttpServletRequest request, HttpSession session) {
		ModelAndView mav = new ModelAndView();
		
	
		//System.out.println("resobj.getDutyFrequencyId()"+resobj.getDutyFrequencyId());
		
		//System.out.println("resobj.getYear()"+resobj.getYear());
		
		
		
		
		
		List<ReservoirInspect> resInspect= new ArrayList<ReservoirInspect>();
		try {
		
		User user = (User) session.getAttribute("userObj");	
		
		//System.out.println("user.getUnitId()"+user.getUnitId());
	if (user != null ) {
		if(user.getUnitId()!=null){
			
			//System.out.println("resobj.getReservoirId()"+resobj.getReservoirId());
			
			//System.out.println("resobj.getTankId()"+resobj.getTankId());
			
		
			if(resobj.getResannRecommendId()!=null){
				
				if(resobj.getResannRecommendId()>0	){
		
					
					//System.out.println("resobj.getReservoirId()123"+resobj.getReservoirId());
					
					//System.out.println("resobj.getTankId()123"+resobj.getTankId());
			resInspect = invam.getResAnnRecomndbyRecId(resobj);
			
				}
			}
			
			
				
			
				
	
		}
	}
		
		} catch (InventoryUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return new Gson().toJson(resInspect);

	}
	
	
	@RequestMapping(value = "/invtsimis/update-damremarksbyrecId")
	@ResponseBody
	public String updateDamremarksbyrecId(ReservoirInspect resobj, HttpServletRequest request, HttpSession session) {
		ModelAndView mav = new ModelAndView();
		
	
		//System.out.println("resobj.getDutyFrequencyId()"+resobj.getDutyFrequencyId());
		
		//System.out.println("resobj.getYear()"+resobj.getYear());
		
		
		Integer output=0;
		
		
		List<ReservoirInspect> resInspect= new ArrayList<ReservoirInspect>();
		try {
		
		User user = (User) session.getAttribute("userObj");	
		
		//System.out.println("user.getUnitId()"+user.getUnitId());
	if (user != null ) {
		if(user.getUnitId()!=null){
			
			//System.out.println("resobj.getReservoirId()"+resobj.getReservoirId());
			
			//System.out.println("resobj.getResannRecommendId()"+resobj.getResannRecommendId());
			//System.out.println("resobj.getInspectOfficeInfoId()"+resobj.getInspectOfficeInfoId());
			
		
			if(resobj.getResannRecommendId()!=null && resobj.getInspectOfficeInfoId()!=null){
				 
				if(resobj.getResannRecommendId()>0	){
		
					
					//System.out.println("resobj.getReservoirId()123"+resobj.getReservoirId());
					
					//System.out.println("resobj.getTankId()123"+resobj.getTankId());
					output = invam.UpdateNrldAnnRecommendationsinfo(resobj);
			
				}
			}
			
			
				
			
				
	
		}
	}
		
		} catch (InventoryUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return new Gson().toJson(output);

	}
	
	
	@RequestMapping(value = "/invtsimis/delete-damremarksbyrecId")
	@ResponseBody
	public String deleteDamremarksbyrecId(ReservoirInspect resobj, HttpServletRequest request, HttpSession session) {
		ModelAndView mav = new ModelAndView();
		
	
		//System.out.println("resobj.getDutyFrequencyId()"+resobj.getDutyFrequencyId());
		
		//System.out.println("resobj.getYear()"+resobj.getYear());
		
		
		Integer output=0;
		
		
		List<ReservoirInspect> resInspect= new ArrayList<ReservoirInspect>();
		try {
		
		User user = (User) session.getAttribute("userObj");	
		
		//System.out.println("user.getUnitId()"+user.getUnitId());
	if (user != null ) {
		if(user.getUnitId()!=null){
			
			//System.out.println("resobj.getReservoirId()"+resobj.getReservoirId());
			
			//System.out.println("resobj.getTankId()"+resobj.getTankId());
			
		
			if(resobj.getResannRecommendId()!=null ){
				 
				if(resobj.getResannRecommendId()>0	){
		
					
					//System.out.println("resobj.getResannRecommendId()"+resobj.getResannRecommendId());
					
					//System.out.println("resobj.getTankId()123"+resobj.getTankId());
					output = invam.deleteNrldAnnRecommendationsinfo(resobj);
			
				}
			}
			
			
				
			
				
	
		}
	}
		
		} catch (InventoryUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return new Gson().toJson(output);

	}
	
	
	@RequestMapping(value = "/invtsimis/update-damHealthByHealthId")
	@ResponseBody
	public String updatedamHealthByHealthId(ReservoirInspect resobj, HttpServletRequest request, HttpSession session) {
		ModelAndView mav = new ModelAndView();
		
	
		//System.out.println("resobj.getDutyFrequencyId()"+resobj.getDutyFrequencyId());
		
		//System.out.println("resobj.getYear()"+resobj.getYear());
		
		
		Integer output=0;
		
		
		List<ReservoirInspect> resInspect= new ArrayList<ReservoirInspect>();
		try {
		
		User user = (User) session.getAttribute("userObj");	
		
		//System.out.println("user.getUnitId()"+user.getUnitId());
	if (user != null ) {
		if(user.getUnitId()!=null){
			
			//System.out.println("resobj.getReservoirId()"+resobj.getReservoirId());
			
			//System.out.println("resobj.getTankId()"+resobj.getTankId());
			
		
			if(resobj.getResDamHealthId()!=null && resobj.getInspectOfficeInfoId()!=null ){
				 
				if(resobj.getResDamHealthId()>0 && resobj.getInspectOfficeInfoId()>0	){
		
					
					//System.out.println("resobj.getResDamHealthId()"+resobj.getResDamHealthId());
					
					//System.out.println("resobj.getTankId()123"+resobj.getTankId());
					output = invam.UpdateNrldAnnHealthinfo(resobj);
			
				}
			}
			
			
				
			
				
	
		}
	}
		
		} catch (InventoryUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return new Gson().toJson(output);

	}
	
	@RequestMapping(value = "/invtsimis/updateActionTakenActionId")
	@ResponseBody
	public String updateActionTakenActionId(ReservoirInspect resObj, HttpServletRequest request,
			HttpSession session, SessionStatus status) {

	Integer output=0;
	
	Boolean captOutput = false;

		// List<PumpStations> pumpStationList= new ArrayList<PumpStations>();

		try {
			
			User user = (User) session.getAttribute("userObj");
			
			
			
			
			
			if(resObj!=null){

				if (resObj.getResDamActionId()!=null ) {
					if(resObj.getResDamActionId()>0){
					output = invam.updateActionTakenDetailsActionId(resObj);
					}
				}

			}

			// System.out.println("resListbyId"+resListbyId);

		} catch (InventoryUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new Gson().toJson(output);

	}
	
	@RequestMapping(value = "/invtsimis/res-assn")
	public ModelAndView resAssignpostinfo( HttpServletRequest request,
			HttpSession session, SessionStatus status) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("res-assn");
		
		List<Project> projectList = new ArrayList<Project>();
		List<ReservoirSalient>  reservoirList = new ArrayList<ReservoirSalient>();
			List<ReservoirSalient>  nrldreservoirList = new ArrayList<ReservoirSalient>();
			
			List<Unit> unitList = new ArrayList<Unit>();
			
			
			
			User user = (User) session.getAttribute("userObj");
			 try {
				 projectList = lam.getProjectListadmin(user.getUnitId());
			       reservoirList = invam.getInvomResListAdmin(user.getUnitId());
			       
			       unitList = tam.getUnitList();
				 
				 mav.addObject("projectList",projectList);
				 mav.addObject("reservoirList",reservoirList);
				 
				 mav.addObject("unitList",unitList);
				 
			} catch (InventoryUserException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (LeagalUserException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (TaskUserException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
		
		return mav;

	}
	
	
	@RequestMapping(value = "/invtsimis/updateNrldCode")
	@ResponseBody
	public String updateNrldCode(ReservoirInspect resObj, HttpServletRequest request,
			HttpSession session, SessionStatus status) {

	Integer output=0;
	
	Boolean captOutput = false;

		// List<PumpStations> pumpStationList= new ArrayList<PumpStations>();

		try {
			
			User user = (User) session.getAttribute("userObj");
			
			ReservoirSalient	resinf= new ReservoirSalient()	;		
			
			
			if(resObj!=null){

				if (resObj.getReservoirId()!=null  && resObj.getNrldCode()!=null ) {
					
					resinf.setReservoirId(resObj.getReservoirId()); 
					
					resinf.setNrldCode(resObj.getNrldCode());;
					
					
					if(resObj.getReservoirId()>0){
					output = invam.UpdateResNrldCode(resinf);
					}
				}

			}

			// System.out.println("resListbyId"+resListbyId);

		} catch (InventoryUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new Gson().toJson(output);

	}
	
	
	
	@RequestMapping(value = "/invtsimis/get-respostemp")
	@ResponseBody
	public String getResPostEmp(ReservoirInspect resobj, HttpServletRequest request, HttpSession session) {
		ModelAndView mav = new ModelAndView();
		
	
		//System.out.println("resobj.getDutyFrequencyId()"+resobj.getDutyFrequencyId());
		
		//System.out.println("resobj.getYear()"+resobj.getYear());
		
		
		
		
		
		List<ReservoirInspect> resInspect= new ArrayList<ReservoirInspect>();
		try {
		
		User user = (User) session.getAttribute("userObj");	
		
		//System.out.println("user.getUnitId()"+user.getUnitId());
	if (user != null ) {
		if(user.getUnitId()!=null){
			
			//System.out.println("resobj.getReservoirId()"+resobj.getReservoirId());
			
			//System.out.println("resobj.getTankId()"+resobj.getTankId());
			
		
			if(resobj.getReservoirId()!=null){
				
				if(resobj.getReservoirId()>0	){
		
					
					//System.out.println("resobj.getReservoirId()123"+resobj.getReservoirId());
					
					//System.out.println("resobj.getTankId()123"+resobj.getTankId());
			resInspect = invam.getResPostEmpId(resobj);
			
				}
			}
			
			
				
			
				
	
		}
	}
		
		} catch (InventoryUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return new Gson().toJson(resInspect);

	}
	
	
	
	@RequestMapping(value = "/invtsimis/insertrespostaccess")
	@ResponseBody
	public String insertrespostaccess(ReservoirInspect resObj, HttpServletRequest request,
			HttpSession session, SessionStatus status) {

	Integer output=0;
	
	Boolean captOutput = false;

		// List<PumpStations> pumpStationList= new ArrayList<PumpStations>();

		try {
			
			User user = (User) session.getAttribute("userObj");
			
		
		
			
			
			if(resObj!=null){

				if (resObj.getReservoirId()!=null  && resObj.getPostId()!=null && resObj.getProjectId()!=null ) {
					
				
					if(resObj.getReservoirId()>0){
					output = invam.insertRespostaccess(resObj);
					}
				}

			}

			// System.out.println("resListbyId"+resListbyId);

		} catch (InventoryUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new Gson().toJson(output);

	}
	
	
	
	
	@RequestMapping(value = "/invtsimis/deleterespostaccess")
	@ResponseBody
	public String deleterespostaccess(ReservoirInspect resObj, HttpServletRequest request,
			HttpSession session, SessionStatus status) {

	Integer output=0;
	
	Boolean captOutput = false;

		// List<PumpStations> pumpStationList= new ArrayList<PumpStations>();

		try {
			
			User user = (User) session.getAttribute("userObj");
			
		
			
			
			if(resObj!=null){

				if (resObj.getResUnitProjMapId()!=null) {
					
				
					if(resObj.getResUnitProjMapId()>0){
					output = invam.deleteRespostaccess(resObj);
					}
				}

			}

			// System.out.println("resListbyId"+resListbyId);

		} catch (InventoryUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new Gson().toJson(output);

	}
	
	
	
	@RequestMapping(value = "/invtsimis/getempinfobyoffice")
	@ResponseBody
	public String getempinfobyoffice(ReservoirInspect resobj, HttpServletRequest request, HttpSession session) {
		ModelAndView mav = new ModelAndView();
		
	
		//System.out.println("resobj.getDutyFrequencyId()"+resobj.getDutyFrequencyId());
		
		//System.out.println("resobj.getYear()"+resobj.getYear());
		
		
		
		
		
		List<Employee> empinfo= new ArrayList<Employee>();
		try {
		
		User user = (User) session.getAttribute("userObj");	
		
		//System.out.println("user.getUnitId()"+user.getUnitId());
	if (user != null ) {
		if(user.getUnitId()!=null){
			
			//System.out.println("resobj.getReservoirId()"+resobj.getReservoirId());
			
			//System.out.println("resobj.getTankId()"+resobj.getTankId());
			
		
			if(resobj.getUnitId()!=null){
				
				if(resobj.getUnitId()>0	){
		
					
					//System.out.println("resobj.getReservoirId()123"+resobj.getReservoirId());
					
					//System.out.println("resobj.getTankId()123"+resobj.getTankId());
					empinfo = invam.getempdatabyoffice(resobj);
			
				}
			}
			
			
				
			
				
	
		}
	}
		
		} catch (InventoryUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return new Gson().toJson(empinfo);

	}
	
	
	
	//start of Medical Bills
	

	@RequestMapping(value = "/invtsimis/medical-menu-home")
	public ModelAndView medicalMenuHome() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("medical-menu-Home");
		return mav;

	}
	
	
	@RequestMapping(value = "/invtsimis/medicalinputform")
	public ModelAndView medicalBillsinputform(@ModelAttribute("micheckList") MiTankInspect mitankObj,
			HttpServletRequest request, HttpSession session) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("medical-bill-input");

		

		return mav;

	}
	
	
	
	
	
	
	/*@RequestMapping(value = "/invtsimis/medical-emp-inf")
	public ModelAndView medicalempinf(@ModelAttribute("micheckList") MiTankInspect mitankObj,
			HttpServletRequest request, HttpSession session) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("medical-emp-inf");

		

		return mav;

	}
	*/
	
	
	@RequestMapping(value = "/invtsimis/medical-forward-form")
	public ModelAndView medicalinforwardform() {
		ModelAndView mav = new ModelAndView();
		
		System.out.println("medical-forward-form");
		mav.setViewName("medical-forward-form");
		System.out.println("medical-forward-form");

		

		return mav;

	}
	
	
	
	@RequestMapping(value = "/invtsimis/medical-auth-check-form")
	public ModelAndView medicalrulesform( ) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("medical-auth-check-form");

		

		return mav;

	}
	
	
	
	@RequestMapping(value = "/invtsimis/budget-menu-home")
	public ModelAndView budgetMenuHome() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("budget-menu-Home");
		return mav;

	}
	
	
	@RequestMapping(value = "/invtsimis/budget-query-input")
	public ModelAndView budgetqueryinput() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("budget-query-input");
		return mav;

	}
	
	@RequestMapping(value = "/invtsimis/budget-bill-input")
	public ModelAndView budgetbillinput() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("budget-bill-input");
		return mav;

	}
	
	// private static final String FILE_DIRECTORY = "E:/Uploads/tsimis/uploadedFiles/FormDocs/";
	  

	 //private static final String RELATIVE_DIR = "/uploadedFiles/FormDocs/";


		    @GetMapping("/invtsimis/viewphotos")
		    public void serveFile(@RequestParam String fileName, HttpServletResponse response ) throws IOException {
		    	
		    	  System.out.println("Entered viewPhotos, File Name: "+ fileName);
		    	  
		    	  
		    	  //String absolutePath = servletContext.getRealPath(RELATIVE_DIR);
		    	  Path filePath = Paths.get(FILE_DIRECTORY, fileName);
		    	 // Path filePath = Paths.get(absolutePath, fileName);
		    	  File imageFile  = filePath.toFile();

		    	  if (!imageFile .exists() || !imageFile .isFile()) {
		                response.sendError(HttpServletResponse.SC_NOT_FOUND, "File not found");
		                return;
		            }
		    	  
		    	  // Determine content type dynamically
		    	    String lowerCaseName = fileName.toLowerCase();
		    	    String contentType;
		    	    if (lowerCaseName.endsWith(".png")) {
		    	        contentType = "image/png";
		    	    } else if (lowerCaseName.endsWith(".jpg") || lowerCaseName.endsWith(".jpeg")) {
		    	        contentType = "image/jpeg";
		    	    } else if (lowerCaseName.endsWith(".pdf")) {
		    	        contentType = "application/pdf";
		    	    } else {
		    	        contentType = "application/octet-stream"; // default fallback
		    	    }


		        
		    	    response.setContentType(contentType);
		    	    response.setContentLengthLong(imageFile.length());
		    	    response.setHeader("Content-Disposition", "inline; filename=\"" + imageFile.getName() + "\"");


		            try (InputStream inputStream = new FileInputStream(imageFile);
		                    OutputStream outputStream = response.getOutputStream()) {

		                   byte[] buffer = new byte[8192]; // 8KB buffer for efficient reading
		                   int bytesRead;
		                   while ((bytesRead = inputStream.read(buffer)) != -1) {
		                       outputStream.write(buffer, 0, bytesRead);
		                   }
		                   outputStream.flush();

		               } catch (IOException e) {
		                   System.err.println("Error serving imageFile: " + e.getMessage());
		                   e.printStackTrace();

		                   try {
		                       response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error processing image file");
		                   } catch (IOException ioException) {
		                       System.err.println("Error sending 500 response: " + ioException.getMessage());
		                   }
		               }
		    }
		   
		    private static final String FILE_DIRECTORYDAM = "/app/tomcat8/webapps/tsimis/uploadedFiles/DamInspectDocs/";
		    
		    @GetMapping("/invtsimis/viewDamphotos")
		    public void serveDamFile(@RequestParam String fileName, HttpServletResponse response ) throws IOException {
		    	
		    	  System.out.println("Entered viewPhotos, File Name: "+ fileName);
		    	  Path filePath = Paths.get(FILE_DIRECTORYDAM, fileName);
		    	  File imageFile  = filePath.toFile();

		    	  if (!imageFile .exists() || !imageFile .isFile()) {
		                response.sendError(HttpServletResponse.SC_NOT_FOUND, "File not found");
		                return;
		            }
		    	  
		    	  // Determine content type dynamically
		    	    String lowerCaseName = fileName.toLowerCase();
		    	    String contentType;
		    	    if (lowerCaseName.endsWith(".png")) {
		    	        contentType = "image/png";
		    	    } else if (lowerCaseName.endsWith(".jpg") || lowerCaseName.endsWith(".jpeg")) {
		    	        contentType = "image/jpeg";
		    	    } else if (lowerCaseName.endsWith(".pdf")) {
		    	        contentType = "application/pdf";
		    	    } else {
		    	        contentType = "application/octet-stream"; // default fallback
		    	    }


		        
		    	    response.setContentType(contentType);
		    	    response.setContentLengthLong(imageFile.length());
		    	    response.setHeader("Content-Disposition", "inline; filename=\"" + imageFile.getName() + "\"");


		            try (InputStream inputStream = new FileInputStream(imageFile);
		                    OutputStream outputStream = response.getOutputStream()) {

		                   byte[] buffer = new byte[8192]; // 8KB buffer for efficient reading
		                   int bytesRead;
		                   while ((bytesRead = inputStream.read(buffer)) != -1) {
		                       outputStream.write(buffer, 0, bytesRead);
		                   }
		                   outputStream.flush();

		               } catch (IOException e) {
		                   System.err.println("Error serving imageFile: " + e.getMessage());
		                   e.printStackTrace();

		                   try {
		                       response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error processing image file");
		                   } catch (IOException ioException) {
		                       System.err.println("Error sending 500 response: " + ioException.getMessage());
		                   }
		               }
		    }
	
	
	
}
