package in.ts.icad.leagal.controller;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

import javax.annotation.PostConstruct;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionBindingEvent;

import org.glassfish.hk2.api.SingleCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;

import in.ts.icad.leagal.dao.LeagalAdminDAO;
import in.ts.icad.leagal.exception.LeagalUserException;
import in.ts.icad.leagal.manager.LeagalAdminManager;
import in.ts.icad.leagal.manager.LeagalReportManager;
import in.ts.icad.leagal.manager.LeagalWebManager;
import in.ts.icad.leagal.model.CaseGenSub;
import in.ts.icad.leagal.model.CaseStages;
import in.ts.icad.leagal.model.CaseStatus;
import in.ts.icad.leagal.model.CaseType;
import in.ts.icad.leagal.model.CaseTypeOrder;
import in.ts.icad.leagal.model.Cases;
import in.ts.icad.leagal.model.CasesGeneral;
import in.ts.icad.leagal.model.CasesListWrapper;
import in.ts.icad.leagal.model.Circle;
import in.ts.icad.leagal.model.ContactPerson;
import in.ts.icad.leagal.model.Courts;
import in.ts.icad.leagal.model.District;
import in.ts.icad.leagal.model.Division;
import in.ts.icad.leagal.model.Employee;
import in.ts.icad.leagal.model.Mandal;
import in.ts.icad.leagal.model.Packages;
import in.ts.icad.leagal.model.Petitioner;
import in.ts.icad.leagal.model.PetitionerAdvocate;
import in.ts.icad.leagal.model.Project;
import in.ts.icad.leagal.model.Respondent;
import in.ts.icad.leagal.model.RespondentAdvocate;
import in.ts.icad.leagal.model.SessionModel;
import in.ts.icad.leagal.model.Subdivision;
import in.ts.icad.leagal.model.Unit;
import in.ts.icad.leagal.model.User;
import in.ts.icad.leagal.model.Village;
import in.ts.icad.leagal.util.AESEncryption;

import in.ts.icad.leagal.util.SingleUserLogin;
import in.ts.icad.leagal.validator.ChangePasswordValidator;

@Controller
@SessionAttributes({ "usersList", "userObj" ,"usersAddnlChargeList" })

public class LeagalAdminController {
	
	/* private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);*/

	@Autowired
	private LeagalAdminManager leagalAdminManager;

	@Autowired
	private LeagalWebManager leagalWebManager;
	
	
	

	@Autowired
	private LeagalReportManager leagalReportManager;
	
	
	
	
	/*@GetMapping("/my-endsession")
    public void myEndpoint(HttpServletRequest request, HttpServletResponse response) {
		checksessioninactiveService.processRequest(request, response);
    }
	*/
	

	@RequestMapping(value = "/web/caseinput")
	@ResponseBody
	public ModelAndView Caseinput(@ModelAttribute("cases") Cases caseinlist, SessionStatus status,
			HttpSession session) {

		ModelAndView mav = new ModelAndView();
		mav.setViewName("caseinput");
		String msg = null;
		String err = null;
		List<District> districts = new ArrayList<District>();
		List<Unit> unitList = new ArrayList<Unit>();
		List<Courts> courtList = new ArrayList<Courts>();
		List<CaseStages> caseStageList = new ArrayList<CaseStages>();
		List<Petitioner> petitionerList = new ArrayList<Petitioner>();
		List<PetitionerAdvocate> petitionerAdvList = new ArrayList<PetitionerAdvocate>();
		List<Respondent> responents = new ArrayList<Respondent>();
		List<RespondentAdvocate> responentsAdvList = new ArrayList<RespondentAdvocate>();
		List<CaseStatus> caseStatusList = new ArrayList<CaseStatus>();
		List<CasesGeneral> caseGenralList = new ArrayList<CasesGeneral>();
		try {
			districts = leagalAdminManager.getDistricts();
			unitList = leagalAdminManager.getUnitList();
			courtList = leagalReportManager.setCourts();
			caseGenralList = leagalAdminManager.getCaseGeneralList();
			caseStageList = leagalAdminManager.getCaseStagesList();
			petitionerList = leagalAdminManager.getPetitionerList();
			petitionerAdvList = leagalAdminManager.getPetitionerAdvocateList();
			responents = leagalAdminManager.getRespondentList();
			responentsAdvList = leagalAdminManager.getRespondentAdvocateList();
			caseStatusList = leagalAdminManager.getCaseStatusList();

			mav.addObject("districtList", districts);
			mav.addObject("unitList", unitList);
			mav.addObject("courtList", courtList);
			mav.addObject("caseGenList", caseGenralList);
			mav.addObject("caseStageList", caseStageList);
			mav.addObject("petList", petitionerList);
			mav.addObject("petAdvList", petitionerAdvList);
			mav.addObject("resList", responents);
			mav.addObject("resAdvList", responentsAdvList);
			mav.addObject("caseStatusList", caseStatusList);

		} catch (LeagalUserException e1) {
			// TODO Auto-generated catch block
			err = "caught in exception getting the list";

			mav.addObject("err", err);
			e1.printStackTrace();
		}

		User user = (User) session.getAttribute("userObj");

		if (caseinlist != null && caseinlist.getCaseWpNumber() != null) {

			// System.out.println("getCaseWpNumber()"+caseinlist.getCaseWpNumber());
			List<Integer> listpet = new ArrayList<Integer>();
			List<Integer> listpetAdv = new ArrayList<Integer>();
			List<Integer> listres = new ArrayList<Integer>();
			List<Integer> listresAdv = new ArrayList<Integer>();
			List<ContactPerson> contactPerson = new ArrayList<ContactPerson>();
			Integer returnval = 0;
			Integer val1 = 0;
			Integer returnval2 = 0;
			Integer returnval3 = 0;
			Integer returnval4 = 0;
			Integer returnval5 = 0;

			String msg1 = null;
			String msg2 = null;
			String msg3 = null;
			String msg4 = null;
			String msg5 = null;
			String msg6 = null;

			String err1 = null;
			String err2 = null;
			String err3 = null;
			String err4 = null;
			String err5 = null;
			String err6 = null;

			String err7 = null;

			// System.out.println(caseinlist);

			if (caseinlist != null && caseinlist.getCaseWpNumber() != null && caseinlist.getCaseGenId() > 0
					&& caseinlist.getCaseStageId() > 0 && caseinlist.getCaseYear() > 0
					&& caseinlist.getCaseStatusId() > 0 && caseinlist.getRespondentIdArray() != null
					&& caseinlist.getPetitionerIdArray() != null && caseinlist.getPetetionerAdvIdArray() != null
					&& caseinlist.getRespondentAdvIdArray() != null) {

				if (user != null) {

					if (user.getUserName() != null && user.getUserId() == null) {

						caseinlist.setOracleUser(user.getUserName());
					}

					if (user.getUserName() != null && user.getUserId() != null) {
						if (user.getUserId() > 0) {
							caseinlist.setPostgresUser(user.getUserId());
						}
					}

				}
				// caseinlist.setOracleUser("admin");

				try {

					returnval = leagalAdminManager.insertCases(caseinlist);

					// System.out.println("returnval"+returnval);

					// System.out.println("caseinlist"+caseinlist.getPetitionerIdArray());

					if (returnval > 0) {

						msg1 = "Case added Successfully";
						mav.addObject("msg1", msg1);
						String pet = caseinlist.getPetitionerIdArray();

						if (pet != null) {
							for (String s : pet.split(",")) {
								listpet.add(Integer.parseInt(s));
							}

							val1 = leagalAdminManager.insertPet(listpet, returnval);

						}

						if (val1 > 0) {

							msg2 = "Petitioner Added Successfully";
							mav.addObject("msg2", msg2);
							String petAdv = caseinlist.getPetetionerAdvIdArray();

							if (petAdv != null) {

								for (String s : petAdv.split(",")) {
									listpetAdv.add(Integer.parseInt(s));
								}

								returnval2 = leagalAdminManager.insertPetAdv(listpetAdv, returnval);

							}

							if (returnval2 > 0) {

								msg3 = "PetitionerAdvocate Added Successfully";
								mav.addObject("msg3", msg3);
								String res = caseinlist.getRespondentIdArray();

								if (res != null) {

									for (String s : res.split(",")) {
										listres.add(Integer.parseInt(s));
									}

									returnval3 = leagalAdminManager.insertRes(listres, returnval);
								}

								if (returnval3 > 0) {

									msg4 = "Respondent Added Successfully";
									mav.addObject("msg4", msg4);

									String resAdv = caseinlist.getRespondentAdvIdArray();

									if (resAdv != null) {

										for (String s : resAdv.split(",")) {
											listresAdv.add(Integer.parseInt(s));
										}

										returnval4 = leagalAdminManager.insertResAdv(listresAdv, returnval);
									}

									if (returnval4 > 0) {

										msg5 = "RespondentAdvocate Added Successfully";
										mav.addObject("msg5", msg5);
										// if((caseinlist.getContactPerson()!=null||caseinlist.getContactPerson()!="
										// " ||
										// !caseinlist.getContactPerson().equals("0"))&&
										// returnval>0 &&
										// (caseinlist.getPhoneNumber()!=null ||
										// caseinlist.getPhoneNumber()!=" " ||
										// !caseinlist.getContactPerson().equals("0"))
										// ){
										if (caseinlist.getContactPlist() != null && (caseinlist.getContactPlist().get(0)
												.getContactPname() != null
												|| caseinlist.getContactPlist().get(1).getContactPname() != null)) {
											if (caseinlist.getContactPlist().size() > 0) {
												contactPerson = caseinlist.getContactPlist();

												// System.out.println("contactPerson"+contactPerson);
												returnval5 = leagalAdminManager.insertCaseContact(contactPerson,
														returnval);
											}
										}

										if (returnval5 > 0) {

											msg6 = "ContactPerson Added Successfully";
											mav.addObject("msg6", msg6);

										} else {

											err6 = "Failure to add Contact Person";
											mav.addObject("err6", err6);

										}

									} else {

										err5 = "Failure to add Respondent Advocate";
										mav.addObject("err5", err5);

									}
								} else {

									err4 = "Failure to add Respondent";
									mav.addObject("err4", err4);

								}
							} else {

								err3 = "Failure to add Petitioner Advocate";
								mav.addObject("err3", err3);

							}

						} else {

							err2 = "Failure to add Petitioner ";
							mav.addObject("err2", err2);

						}
					} else {
						err1 = "Failure to add Case";
						mav.addObject("err1", err1);

					}
					// System.out.println("listpet"+listpet.get(0)+" i am
					// here"+listpet.get(1));

				} catch (LeagalUserException e) {
					// TODO Auto-generated catch block
					err = "caught in leagal user exception";
					mav.addObject("err", err);
					e.printStackTrace();
				} catch (SQLException | ParseException e) {
					// TODO Auto-generated catch block
					err7 = "caught in exception";
					mav.addObject("err7", err7);
					e.printStackTrace();
				}

				// System.out.println("returnval1"+returnval1);

			}

		}

		return mav;
	}

	@RequestMapping(value = "/web/getProjects")
	@ResponseBody
	public String getProjects(Integer unitId, SessionStatus status, HttpServletRequest request)
			throws LeagalUserException {

		List<Project> projectList = leagalAdminManager.getProjectList(unitId);

		return new Gson().toJson(projectList);

	}

	@RequestMapping(value = "/web/getPetList")
	@ResponseBody
	public String getPetList(Integer petitionerId, SessionStatus status, HttpServletRequest request)
			throws LeagalUserException {

		Petitioner petitionerList = leagalAdminManager.getPetitionerbyId(petitionerId);

		return new Gson().toJson(petitionerList);

	}

	@RequestMapping(value = "/web/getPetAdvList")
	@ResponseBody
	public String getPetAdvList(Integer petitionerAdvId, SessionStatus status, HttpServletRequest request)
			throws LeagalUserException {

		PetitionerAdvocate petitionerList = leagalAdminManager.getPetitionerAdvListbyId(petitionerAdvId);

		return new Gson().toJson(petitionerList);

	}

	@RequestMapping(value = "/web/getResList")
	@ResponseBody
	public String getResList(Integer resId, SessionStatus status, HttpServletRequest request)
			throws LeagalUserException {

		Respondent resList = leagalAdminManager.getRespondentListById(resId);

		return new Gson().toJson(resList);

	}

	@RequestMapping(value = "/web/getResAdvList")
	@ResponseBody
	public String getResAdvList(Integer resAdvId, SessionStatus status, HttpServletRequest request)
			throws LeagalUserException {

		RespondentAdvocate resadvList = leagalAdminManager.getRespondentAdvocateListById(resAdvId);

		return new Gson().toJson(resadvList);

	}

	@RequestMapping(value = "/web/getCaseTypeOrders")
	@ResponseBody
	public String getCaseTypeOrders(Integer caseStageId, HttpSession session, HttpServletRequest req)
			throws LeagalUserException {

		List<CaseTypeOrder> CaseTypeOrderList = new ArrayList<CaseTypeOrder>();

		if (caseStageId != null) {
			if (caseStageId > 0 && caseStageId == 13) {
				CaseTypeOrderList = leagalAdminManager.getTypeOrderList();
			}
		}
		return new Gson().toJson(CaseTypeOrderList);

	}

	@RequestMapping(value = "/web/getPackages")
	@ResponseBody
	public String getPackages(Integer projectId, SessionStatus status, HttpServletRequest request)
			throws LeagalUserException {

		List<Packages> packagesList = leagalAdminManager.getPackageList(projectId);

		return new Gson().toJson(packagesList);

	}

	@RequestMapping(value = "/web/getMandals")
	@ResponseBody
	public String getMandals(Integer districtId, HttpSession session, HttpServletRequest req)
			throws LeagalUserException {

		List<Mandal> mandals = leagalAdminManager.getMandals(districtId);

		return new Gson().toJson(mandals);

	}

	/**
	 * Ajax call to populate villages for a particular district,mandal.
	 * 
	 * @param session
	 * @param req
	 * @return
	 * @throws PMSUserException
	 */
	@RequestMapping(value = "/web/getVillages")
	@ResponseBody
	public String getVillages(Integer dcode,Integer mcode, HttpSession session, HttpServletRequest req)
			throws LeagalUserException {
 
		List<Village> vills = leagalAdminManager.getVillages(dcode,mcode);

		return new Gson().toJson(vills);

	}

	@RequestMapping(value = "/web/getCircles")
	@ResponseBody
	public String getCircles(Integer unitId, HttpSession session, HttpServletRequest req) throws LeagalUserException {

		List<Circle> circles = leagalAdminManager.getCircleList(unitId);

		return new Gson().toJson(circles);

	}

	@RequestMapping(value = "/web/getDivisions")
	@ResponseBody
	public String getDivisions(Integer circleId, HttpSession session, HttpServletRequest req)
			throws LeagalUserException {

		List<Division> divisions = leagalAdminManager.getDivisionList(circleId);

		return new Gson().toJson(divisions);

	}

	@RequestMapping(value = "/web/getSubDivisions")
	@ResponseBody
	public String getSubDivisions(Integer divisionId, HttpSession session, HttpServletRequest req)
			throws LeagalUserException {

		List<Subdivision> subdivisions = leagalAdminManager.getSubDivisionList(divisionId);

		return new Gson().toJson(subdivisions);

	}

	@RequestMapping(value = "/web/getCaseTypes")
	@ResponseBody
	public String getCaseTypes(Integer courtId, HttpSession session, HttpServletRequest req)
			throws LeagalUserException {

		List<CaseType> caseTypeList = leagalAdminManager.getCaseTypeList(courtId);

		return new Gson().toJson(caseTypeList);

	}

	@RequestMapping(value = "/web/getCaseGenSub")
	@ResponseBody
	public String getCaseGenSub(Integer caseGenId, HttpSession session, HttpServletRequest req)
			throws LeagalUserException {

		List<CaseGenSub> caseGenSubList = leagalAdminManager.getCaseGenSubList(caseGenId);

		return new Gson().toJson(caseGenSubList);

	}

	@RequestMapping(value = "/getCircleDetails")
	@ResponseBody
	public String getCircleDetails(@RequestParam("projectId") Integer projectId, HttpSession session,
			HttpServletRequest request) throws LeagalUserException {
		ModelAndView mav = new ModelAndView();

		List<Project> projects = null;

		List<Circle> circle = new ArrayList<Circle>();

		List<Circle> circle1 = new ArrayList<Circle>();

		/*
		 * projects=leagalAdminManager.getUnits(projectId);
		 */

		for (int i = 0; i < projects.size(); i++) {
			/*
			 * circle1=leagalAdminManager.getProjectCirclesforPCK(projects.get(i
			 * ).getUnitId());
			 */
			circle.addAll(i, circle1);
		}

		mav.setViewName("getLandAcquisitionDetails");
		Map<Integer, String> circleMap = new HashMap<Integer, String>();
		for (Circle d : circle) {
			circleMap.put(d.getCircleId(), d.getCircleName());
		}
		// return new Gson().toJson(circleMap);
		return null;

	}

	@RequestMapping(value = "/web/casesinputsubmit")
	@ResponseBody
	public ModelAndView casesinputsubmit(@ModelAttribute("cases") Cases caseinlist, SessionStatus status,
			HttpSession session) throws LeagalUserException, SQLException, ParseException {

		ModelAndView mav = new ModelAndView();
		mav.setViewName("caseinput");
		// System.out.println("i am coming here");

		List<Integer> listpet = new ArrayList<Integer>();
		List<Integer> listpetAdv = new ArrayList<Integer>();
		List<Integer> listres = new ArrayList<Integer>();
		List<Integer> listresAdv = new ArrayList<Integer>();

		List<ContactPerson> contactPerson = new ArrayList<ContactPerson>();
		Integer returnval = 0;
		Integer val1 = 0;
		Integer returnval2 = 0;
		Integer returnval3 = 0;
		Integer returnval4 = 0;
		Integer returnval5 = 0;

		// System.out.println(caseinlist);

		if (caseinlist != null && caseinlist.getCaseWpNumber() != null && caseinlist.getCaseTypeId() > 0
				&& caseinlist.getCaseGenId() > 0 && caseinlist.getCaseStageId() > 0 && caseinlist.getCaseYear() > 0
				&& caseinlist.getCaseStatusId() > 0 && caseinlist.getRespondentIdArray() != null
				&& caseinlist.getPetitionerIdArray() != null && caseinlist.getPetetionerAdvIdArray() != null
				&& caseinlist.getRespondentAdvIdArray() != null) {

			returnval = leagalAdminManager.insertCases(caseinlist);

			// System.out.println("returnval"+returnval);

			// System.out.println("caseinlist"+caseinlist.getPetitionerIdArray());

			if (returnval > 0) {

				String pet = caseinlist.getPetitionerIdArray();

				if (pet != null) {
					for (String s : pet.split(",")) {
						listpet.add(Integer.parseInt(s));
					}

					val1 = leagalAdminManager.insertPet(listpet, returnval);

				}
				String petAdv = caseinlist.getPetetionerAdvIdArray();

				if (petAdv != null) {

					for (String s : petAdv.split(",")) {
						listpetAdv.add(Integer.parseInt(s));
					}

					returnval2 = leagalAdminManager.insertPetAdv(listpetAdv, returnval);

				}
				String res = caseinlist.getRespondentIdArray();

				if (res != null) {

					for (String s : res.split(",")) {
						listres.add(Integer.parseInt(s));
					}

					returnval3 = leagalAdminManager.insertRes(listres, returnval);
				}
				String resAdv = caseinlist.getRespondentAdvIdArray();

				if (resAdv != null) {

					for (String s : resAdv.split(",")) {
						listresAdv.add(Integer.parseInt(s));
					}

					returnval4 = leagalAdminManager.insertResAdv(listresAdv, returnval);
				}

				if (caseinlist.getContactPerson() != null && returnval > 0) {
					// returnval5=leagalAdminManager.insertCaseContact(caseinlist,
					// returnval);
				}

			}
			// System.out.println("listpet"+listpet.get(0)+" i am
			// here"+listpet.get(1));

			// System.out.println("returnval1"+returnval1);

		}

		return mav;
	}

	@RequestMapping(value = "/webtsimis/login")
	@ResponseBody
	public ModelAndView Login(@ModelAttribute("user") User user, SessionStatus status, HttpSession session,
			ModelMap model, HttpServletRequest request, HttpServletResponse response) {

		ModelAndView mav = new ModelAndView();
		// System.out.println("i am coming here login");
		// System.out.println("user i am in login "+user.getCaptcha());
		// System.out.println("user"+user.getPassword());
		String userName = null;
		String password = null;
		String newUserName = null;
		String decryptpwd = null;
		String msg = null;
		List<User> usersList = new ArrayList<User>();
		User userObject = new User();
		String captcha = (String) session.getAttribute("CAPTCHA");
	  //  System.out.println("captcha in cotroller "+captcha);
	   // System.out.println("Controller in Session "+session.getId());

		Boolean captOutput = false;
		Boolean addtnlCharge = false;
		Boolean outputvalidata=false;
		
		 String ipaddress=(request.getRemoteAddr());

		try {
			
			//System.out.println("user  "+user +"  "+captcha);
			
			if(user==null){
				mav.addObject("msg", "Invalid User");
				mav.setViewName("home");
			}

			if (user.getCaptcha() == null || captcha == null) {
				mav.addObject("msg", "Please Enter the Captcha Text");
				mav.setViewName("home");
			}

			if ((user.getCaptcha() != null && captcha != null)) {
				if ((user.getCaptcha() != null && !user.getCaptcha().equals(captcha))) {
					// System.out.println("coming here");
					mav.addObject("msg", "Captcha does not match");
					user.setCaptcha("");
					mav.setViewName("home");
					captOutput = false;

				}

				if (user.getCaptcha().equals(captcha)) {

					captOutput = true;

				}

			}

			if (captOutput == true) {
				
				if(user!=null){
				if (user != null && user.getUserName() != null) {

					if (user.getPassword() != null) {

						String encrytedPassword = user.getPassword();
		//17012024				String decryptedPassword = AESEncryption.decrypt(encrytedPassword);
						 //System.out.println("encrytedPassword "+encrytedPassword);
						
						String decryptedPassword = AESEncryption.decryptInputText(encrytedPassword);

		//17012024				String finalPassword = (decryptedPassword.substring(0, decryptedPassword.length() - 11));

						// System.out.println("depw "+finalPassword);

			//17012024			decryptpwd = finalPassword;
						
						//System.out.println("decryptedPassword "+decryptedPassword);
						
						 decryptpwd=decryptedPassword;

					}

					if ((user.getUserName() != null && user.getPassword() != null)) {
						userName = user.getUserName().trim();
						password = decryptpwd;

						newUserName = userName;
					}

					if (userName.length() > 0 && password.length() > 0) {
						// SingleUserLogin sul= new SingleUserLogin();

						HttpSession oldSession = request.getSession(false);
						// System.out.println("oldSession " +oldSession);

						// sul.setUsername(user.getUserName());

						// HttpSessionBindingEvent event = null ;
						if (oldSession != null) {
							// System.out.println(oldSession);

							// System.out.println(sul.hashCode());

							oldSession.invalidate();

							mav.addObject("msg", "Invalid User Name/Password (please enter password.)");
							
							mav.setViewName("home");

							// sul.valueBound(event);
						}
						
						// generate a new session
						HttpSession newSession = request.getSession(true);
						
						if(newSession!=null){

						// session.setAttribute("userName", userName);

						// setting session to expiry in 5 mins
						newSession.setMaxInactiveInterval(20 * 60);

						// userObject=leagalAdminManager.getUserPostDetails(userName,
						// password);

						/*
						 * if(captcha==null || (captcha!=null &&
						 * !captcha.equals(user.getCaptcha()))){
						 * user.setCaptcha(""); mav.addObject("msg",
						 * "Captcha does not match");
						 * 
						 * }
						 */

						/*
						 * commented on 23022021
						 * if(!newUserName.contains("cc_")||
						 * !newUserName.contains("CAO") ){
						 * 
						 * //System.out.println("user"+userName.toUpperCase()+
						 * password);
						 * 
						 * 
						 * usersList =
						 * leagalAdminManager.getUserDetails(userName,
						 * password);
						 * 
						 * 
						 * 
						 * // login if(usersList!=null ){ if (usersList.size() >
						 * 0) {
						 * 
						 * if (usersList.size() == 1) {
						 * 
						 * 
						 * //System.out.println("usersList"+usersList+"--"+
						 * usersList.size()); //User users = new User();
						 * userObject = usersList.get(0);
						 * mav.setViewName("login");
						 * model.addAttribute("userObj", userObject);
						 * newSession.setAttribute("loggedInUser",
						 * userObject.getUserName());
						 * 
						 * } else {
						 * 
						 * mav.setViewName("home");
						 * 
						 * }
						 * 
						 * 
						 * 
						 * } else { user.setCaptcha(""); msg =
						 * "Invalid user Name/Password";
						 * mav.addObject("msg",msg); mav.setViewName("home"); }
						 * 
						 * }else{ user.setCaptcha(""); msg =
						 * " user data  is null"; mav.addObject("msg",msg);
						 * mav.setViewName("home");
						 * 
						 * } } }
						 */

						/*
						 * if(newUserName.startsWith("cc_")||
						 * newUserName.startsWith("CAO") ){
						 * 
						 * 
						 * 
						 * userObject=leagalAdminManager.getUserPostDetails(
						 * newUserName, password);
						 * 
						 * }
						 */
						//outputvalidata=leagalAdminManager.getUservalidity(newUserName,password);
					/*	if(outputvalidata=true){*/
						
						if (newUserName != null && password != null) {

							// System.out.println("newUserName"+newUserName+"password"+password);

							usersList = leagalAdminManager.getEmpDetails(newUserName, password);
							
							if(newUserName.equals("icad_test")){
								
								usersList.get(0).setDesignationId(10);
							}

							  //System.out.println("usersList"+usersList);
							if (usersList != null) {
								
								Integer attemptNo=0;
								
								 attemptNo=	leagalAdminManager.getFailedLoginCount(newUserName);
								 
								 
								 if (usersList.size() == 0) {
										//failed attempts
										//System.out.println("usersList.size() zero "+usersList.size());
										//System.out.println("attemptNo controller "+attemptNo);
										leagalAdminManager.insertfailedattempt(newUserName,ipaddress);
										if(attemptNo>=5)
										{
											mav.addObject("msg","your account is locked for the day, due to 5 invalid attempts");
											mav.setViewName("home");
										}else{
										mav.setViewName("home");
										msg = "Invalid user Name/Password";
										mav.addObject("msg", msg);}
										
									}
								
								if (usersList.size() > 0) {

									if (usersList.size() == 1) {
										usersList.get(0).setAddtnlCharge(addtnlCharge);
										
										//userObject.setAddtnlCharge(addtnlCharge);

										// System.out.println("usersList"+usersList+"--"+usersList.size());
										// User users = new User();
										userObject = usersList.get(0);
									//	System.out.println("userObject size 1 "+userObject);
										/*
										 * mav.setViewName("login");
										 * model.addAttribute("userObj",
										 * userObject); newSession.setAttribute(
										 * "loggedInUser",
										 * userObject.getUserName());
										 */
									}
									if (usersList.size() > 1) {
										addtnlCharge =true;
									//	System.out.println("usersList"+usersList+"--"+usersList.size());
									//	System.out.println("addtnlCharge"+addtnlCharge);
										
									//	System.out.println(" userObject for size >1 "+userObject);
										//System.out.println("userObject size 2 "+userObject);
										userObject=usersList.get(0);
									//	userObject.setUserName( usersList.get(0).getUserName());
										userObject.setAddtnlCharge(addtnlCharge);
										/*
									 * mav.setViewName("login");
										 * model.addAttribute("userObj",
										 * userObject); newSession.setAttribute(
										 * "loggedInUser",
										 * userObject.getUserName());
										 */
										model.addAttribute("userObj",userObject);
										
										model.addAttribute("usersAddnlChargeList", usersList);
										mav.addObject("usersAddChargeList",usersList);
									 //  System.out.println("usersAddChargeList "+usersList); 
										
									}
									/*
										 * else {
										 * 
										 * mav.setViewName("home");
										 * 
										 * }
										 */

								} /*
									 * else { user.setCaptcha(""); msg =
									 * "Invalid user Name/Password";
									 * mav.addObject("msg",msg);
									 * mav.setViewName("home"); }
									 * 
									 * }else{ user.setCaptcha(""); msg =
									 * " user data  is null";
									 * mav.addObject("msg",msg);
									 * mav.setViewName("home");
									 * 
									 * }
									 */
								
								if (userObject != null || ( userObject != null && addtnlCharge==true )) {
									
									if(userObject.getUserName()!=null){
							//		System.out.println(" addlCharge true"+userObject);
					//17012024				mav.setViewName("login");
									model.addAttribute("userObj", userObject);
					//17012024				newSession.setAttribute("loggedInUser", userObject.getUserName());
									
									Boolean Loguser=	leagalAdminManager.getUserConcurrentLogin(userObject.getUserName());
									if(Loguser==false && attemptNo<5){
									leagalAdminManager.insertLoginAttempt(userObject.getUserName(),ipaddress);
									newSession.setAttribute("loggedInUser", userObject.getUserName());
									
									//added on02022024
									
									
									
									
									
									mav.setViewName("login");
									}else if(Loguser==true){
										mav.addObject("msg","concurrent login:You are not allowed to log in from two different systems/browsers at same time");
										mav.setViewName("home");
									}if(attemptNo>=5)
									{
										mav.addObject("msg","your account is locked for the day, due to 5 invalid attempts");
										mav.setViewName("home");
									}
									}

								}
								
								if (userObject == null && addtnlCharge==false  && userObject.getUserName()!=null  ) {
								//	System.out.println(" addlCharge false"+userObject);
									user.setCaptcha("");
									mav.setViewName("home");
									msg = "Invalid user Name/Password";
									mav.addObject("msg", msg);

								}
								
							}

						}
						
						
						
						List<User> logList = new ArrayList<User>();
						logList=leagalAdminManager.logDetails(userName);
						if(logList!=null && logList.size()>0){
							java.sql.Date  LogoutTime=logList.get(0).getLogouttime();
							//System.out.println("LOGOUT TIME IS"+LogoutTime);
							userObject.setLogouttime(LogoutTime);
							}
						
						/*}else {
							
							user.setCaptcha("");

							mav.setViewName("home");
							msg = "Invalid user Name/Password";
							mav.addObject("msg", msg);
							
						}*/
					}

				}

			}
		}
				
			}
			
		}catch (LeagalUserException le) {
			// TODO Auto-generated catch block
			le.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return mav;
	}
	
	@RequestMapping(value = "/webtsimis/addnllogin")	
	public ModelAndView addnlLogin(User uob , SessionStatus status, HttpSession session,
			ModelMap model, HttpServletRequest request) { 
		User userObject = new User();
		List<User> addchList = (List<User>) session.getAttribute("usersAddnlChargeList");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("login");
			
			if(uob!=null) {
				if(uob.getPost()!=0l && uob.getDesignationId()!=0) {
			if(addchList!=null) {
			for(int i=0; i<addchList.size();i++) {
			
				
		if( (addchList.get(i).getPost().equals(uob.getPost() ) )  &&  (addchList.get(i).getDesignationId().equals(uob.getDesignationId() ))  ) {
				
			addchList.get(i).setAddtnlCharge(false);
				userObject=	addchList.get(i);
				
			//	System.out.println("userObject addnl  123 "+userObject);	
				
				if(userObject!=null) {
				model.addAttribute("userObj",userObject);
				}
				
				
			}
			
			}
			}
				}
		}


		return mav;

	}

	@RequestMapping(value = "/webtsimis/cc-proj-inf")
	public ModelAndView editData() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("updateDataBase");
		return mav;

	}

	@RequestMapping(value = "/webtsimis/resultofccinf")
	public ModelAndView generalqueryforresult(@RequestParam("Query") String Query, SessionStatus status,
			HttpSession session) {

		// System.out.println("Query"+Query);

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
			count = leagalAdminManager.generalqueryforresult(Query);
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
		mav.setViewName("updateDataBase");

		mav.addObject("resultset", count);
		mav.addObject("message", message);
		return mav;

	}

	@RequestMapping(value = "/web/logout")
	public ModelAndView logout(SessionStatus status, HttpSession session, HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		User user = (User) session.getAttribute("userObj");
		
		//System.out.println("i am in logout "+session.getMaxInactiveInterval());
		
		//System.out.println("i am in logout 2"+session.getCreationTime());
		
		try {
		
		 if(user!=null){
				if(user.getUserName()!=null){
					
					user.setRemarks("Logged Out by the User Successfully");
			
					leagalAdminManager.updateUserLogout(user);
				
				}}
		 
		 if(user==null)
			{
				//System.out.println("user is null"+request.getSession());
			}
		session = request.getSession(false);

		if (session != null) {

			request.getSession().removeAttribute("user");
			session.invalidate();
		}

		mav.setViewName("home");
		} catch (LeagalUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mav;
	}

	@RequestMapping(value = "/webtsimis/changepassword")
	public ModelAndView changePassword() {
		ModelAndView mav = new ModelAndView();
		// System.out.println("coming here");
		mav.setViewName("changepassword");

		return mav;
	}

	@RequestMapping(value = "/webtsimis/submitPassword")
	public ModelAndView submitPassword(@ModelAttribute("changepwd") User user, HttpSession session,
			BindingResult result) {
		ModelAndView mav = new ModelAndView();
		ChangePasswordValidator validator = new ChangePasswordValidator();
		Boolean b = false;
		validator.validate(user, result);
		User userloggedin = (User) session.getAttribute("userObj");
		
		   String oldpassword=null;
	        String newPassword=null;
	        String password=null;
		// System.out.println("user"+user);

		// System.out.println("userloggedin"+userloggedin);

		// System.out.println("userloggedin.getPassword()"+userloggedin.getPassword());
	        try {    
	        
	        	
	        	if(user!=null){
				oldpassword=AESEncryption.decryptInputText(user.getOldPassword());
			
			 newPassword=AESEncryption.decryptInputText(user.getNewPassword());
			 password=AESEncryption.decryptInputText(user.getPassword());
			 
			 user.setOldPassword(oldpassword);
			 user.setNewPassword(newPassword);
			 user.setPassword(password);
			 
	        	}
		if (result.hasErrors()) {
			mav.addObject("err", "Enter all Fields");
			mav.setViewName("changepassword");
		} else if (!user.getOldPassword().equals(userloggedin.getPassword())) {
			mav.addObject("err", "Incorrect Password");
			mav.setViewName("changepassword");
		} else if (!user.getNewPassword().equals(user.getPassword())) {
			mav.addObject("err", "New Password and Confirm Password Should be same");
			mav.setViewName("changepassword");
		} else if (user.getNewPassword().equals(user.getOldPassword())) {
			mav.addObject("err", "New Password and Old Password Should not be same");
			mav.setViewName("changepassword");
		}

		else {

			if (user != null) {
				if (user.getNewPassword() != null) {
					if (user.getNewPassword().length() > 0) {
						try {
							
							//System.out.println("user.getNewPassword() "+user.getNewPassword());
							b = leagalAdminManager.changePassword(user);
						} catch (LeagalUserException e) {
							mav.setViewName("changepassword");

							mav.addObject("err", "caught in exception" + e.getErrMsg());/// TODO
																						/// Auto-generated
																						/// catch
																						/// block
							e.printStackTrace();
						}
					}
				}
			}

			if (!b) {
				mav.addObject("err", "Failed to change password");
				mav.setViewName("changepassword");
			} else {
				mav.addObject("msg", "Password Changed Successfuly");
				mav.setViewName("changepassword");

			}
		}
		
	}catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
		return mav;
	}

	@RequestMapping(value = "/web/addPet")
	@ResponseBody
	public String AddPet(@ModelAttribute("petitioner") Petitioner pet, SessionStatus status, HttpSession session) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("addPetitioner");
		String msg = null;
		String err = null;
		try {
			List<District> districts = leagalAdminManager.getDistricts();
			mav.addObject("districtList", districts);
		} catch (LeagalUserException e1) {
			err = "exception in district list" + e1.getErrMsg();

			mav.addObject("err", err);
			e1.printStackTrace();
		}
		Integer output = 0;

		if (pet != null && pet.getPetitionerName() != null) {

			// System.out.println("pet"+pet.getPetitionerName()+"--"+pet.getPetitionerAddress());

			try {

				if (pet.getPetitionerName().length() > 0) {
					output = leagalAdminManager.insertpetitionermst(pet);
				}

			} catch (LeagalUserException e) {

				/*
				 * err="caught in exception"+e.getErrMsg();
				 * 
				 * mav.addObject("err",err);
				 */
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return new Gson().toJson(output);

	}

	@RequestMapping(value = "/web/addPetAdv")
	@ResponseBody
	public String AddPetAdv(@ModelAttribute("petitionerAdv") PetitionerAdvocate petAdv, SessionStatus status,
			HttpSession session) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("addPetAdv");
		String msg = null;
		String err = null;

		Integer output = 0;

		if (petAdv != null && petAdv.getPetitionerAdvName() != null) {

			// System.out.println("pet"+pet.getPetitionerName()+"--"+pet.getPetitionerAddress());

			try {

				if (petAdv.getPetitionerAdvName().length() > 0) {
					output = leagalAdminManager.insertpetitionerAdvmst(petAdv);
				}

			} catch (LeagalUserException e) {

				/*
				 * err="caught in exception"+e.getErrMsg();
				 * 
				 * mav.addObject("err",err);
				 */
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return new Gson().toJson(output);

	}

	@RequestMapping(value = "/web/addRes")
	@ResponseBody
	public String AddRes(@ModelAttribute("respondent") Respondent res, SessionStatus status, HttpSession session) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("addRespondent");
		String msg = null;
		String err = null;
		try {
			List<District> districts = leagalAdminManager.getDistricts();
			List<Unit> unitList = leagalAdminManager.getUnitList();
			mav.addObject("districtList", districts);
			mav.addObject("unitList", unitList);
		} catch (LeagalUserException e1) {
			err = "exception in district list" + e1.getErrMsg();

			mav.addObject("err", err);
			e1.printStackTrace();
		}
		Integer output = 0;

		if (res != null && res.getRespondentName() != null) {

			// System.out.println("pet"+pet.getPetitionerName()+"--"+pet.getPetitionerAddress());

			try {

				if (res.getRespondentName().length() > 0) {
					output = leagalAdminManager.insertrespondentmst(res);
				}

			} catch (LeagalUserException e) {

				err = "caught in exception" + e.getErrMsg();

				mav.addObject("err", err);
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return new Gson().toJson(output);

	}

	@RequestMapping(value = "/web/addResAdv")
	@ResponseBody
	public String AddResAdv(@ModelAttribute("respondentAdv") RespondentAdvocate resAdv, SessionStatus status,
			HttpSession session) {
		// ModelAndView mav = new ModelAndView();
		// mav.setViewName("addRespondentAdv");
		String msg = null;
		String err = null;

		Integer output = 0;

		if (resAdv != null && resAdv.getRespondentAdvName() != null) {

			// System.out.println("pet"+pet.getPetitionerName()+"--"+pet.getPetitionerAddress());

			try {

				if (resAdv.getRespondentAdvName().length() > 0) {
					output = leagalAdminManager.inrespondentAdvmst(resAdv);
				}

				// System.out.println("adv"+output);
			} catch (LeagalUserException e) {

				err = "caught in exception" + e.getErrMsg();

				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return new Gson().toJson(output);

	}

	@RequestMapping(value = "/web/addPack")
	@ResponseBody
	public String AddPack(@ModelAttribute("pack") Packages pack, SessionStatus status, HttpSession session) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("addPackage");

		String msg = null;
		String err = null;

		Integer output = 0;

		if (pack != null && pack.getPkgName() != null) {

			User user = (User) session.getAttribute("userObj");

			// System.out.println("pet"+pet.getPetitionerName()+"--"+pet.getPetitionerAddress());

			if (user != null) {
				pack.setUserId(user.getUserId());
				pack.setUserName(user.getUserName());

			}

			try {

				if (pack.getPkgName().length() > 0) {
					output = leagalAdminManager.insertPackmst(pack);
				}

			} catch (LeagalUserException e) {

				// err="caught in exception"+e.getErrMsg();
				//
				// mav.addObject("err",err);
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return new Gson().toJson(output);

	}

	@RequestMapping(value = "/web/caseEditDelete")
	public ModelAndView CaseEditDelete(@ModelAttribute("casesedit") Cases casedit, SessionStatus status,
			HttpSession session) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("caseEditDelete");
		List<Cases> caseidList = new ArrayList<Cases>();
		List<Cases> caseData = new ArrayList<Cases>();

		Integer caseId = 0;
		String msg = null;
		String err = null;
		Integer output = 0;

		try {
			caseidList = leagalAdminManager.getCasesList();
			mav.addObject("caseidList", caseidList);
		} catch (LeagalUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// System.out.println("casedit.getCase"+casedit.getCaseDelete());
		try {
			if (casedit != null && casedit.getCaseId() != null && casedit.getCaseDelete() == false) {
				caseId = casedit.getCaseId();
				if (caseId > 0) {
					caseData = leagalAdminManager.getcasesbycaseid(caseId);
					mav.addObject("caseData", caseData);
					mav.addObject("selectedcaseId", caseId);

				}

			}

			if (casedit != null && casedit.getCaseId() != null && casedit.getCaseDelete() == true) {
				caseId = casedit.getCaseId();
				if (caseId > 0) {

					output = leagalAdminManager.deleteAllforcase(casedit.getCaseId());

					if (output > 0) {
						casedit.setCaseDelete(false);
						msg = "Deleted Successfully";
						mav.addObject("msg", msg);
					} else {
						casedit.setCaseDelete(false);
						err = "Failed to delete ";
						mav.addObject("err", err);

					}
				}
			}
		} catch (LeagalUserException e) {
			casedit.setCaseDelete(false);
			// TODO Auto-generated catch block
			err = "caught in exception caseeditdelete";
			mav.addObject("err", err);
			e.printStackTrace();
		}

		return mav;

	}

	@RequestMapping(value = "/web/addCaseGen")
	public ModelAndView AddCaseGen(@ModelAttribute("casegen") CasesGeneral casegen, SessionStatus status,
			HttpSession session) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("addCaseGen");
		String msg = null;
		String err = null;

		Integer output = 0;

		if (casegen != null && casegen.getCaseGeneral() != null) {

			// System.out.println("pet"+pet.getPetitionerName()+"--"+pet.getPetitionerAddress());

			try {

				if (casegen.getCaseGeneral().length() > 0) {
					output = leagalAdminManager.insertcasegenmst(casegen);
				}
				if (output > 0) {

					msg = "case general added Successfully";

					mav.addObject("msg", msg);

				}

			} catch (LeagalUserException e) {

				err = "caught in exception" + e.getErrMsg();

				mav.addObject("err", err);
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return mav;

	}

	@RequestMapping(value = "/web/addCaseGenSub")
	public ModelAndView AddCaseGenSub(@ModelAttribute("casegensub") CaseGenSub casegensub, SessionStatus status,
			HttpSession session) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("addCaseSubGen");
		String msg = null;
		String err = null;

		Integer output = 0;

		List<CasesGeneral> caseGenralList = new ArrayList<CasesGeneral>();
		try {
			caseGenralList = leagalAdminManager.getCaseGeneralList();
			mav.addObject("caseGenList", caseGenralList);
		} catch (LeagalUserException e1) {
			err = "caught in getting the list from db";
			mav.addObject("err", err);
			mav.setViewName("addCaseSubGen");

			e1.printStackTrace();
		}

		if (casegensub != null && casegensub.getCaseGenSubName() != null) {

			// System.out.println("pet"+pet.getPetitionerName()+"--"+pet.getPetitionerAddress());

			try {

				if (casegensub.getCaseGenSubName().length() > 0) {
					output = leagalAdminManager.insertcasegensubmst(casegensub);
				}
				if (output > 0) {

					msg = "case general sub added Successfully";

					mav.addObject("msg", msg);

				}

			} catch (LeagalUserException e) {

				err = "caught in exception" + e.getErrMsg();

				mav.addObject("err", err);
				mav.setViewName("addCaseSubGen");
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return mav;

	}

	@RequestMapping(value = "/web/addCaseType")
	public ModelAndView AddCaseType(@ModelAttribute("casetype") CaseType casetype, SessionStatus status,
			HttpSession session) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("addCaseType");
		String msg = null;
		String err = null;

		Integer output = 0;

		List<Courts> courtList = new ArrayList<Courts>();

		try {
			courtList = leagalReportManager.setCourts();
			mav.addObject("courtList", courtList);
		} catch (LeagalUserException e1) {
			// TODO Auto-generated catch block
			err = "Error in getting court list";
			mav.addObject("err", err);
			mav.setViewName("addCaseType");
			e1.printStackTrace();
		}

		if (casetype != null && casetype.getCaseType() != null) {

			// System.out.println("pet"+pet.getPetitionerName()+"--"+pet.getPetitionerAddress());

			try {

				if (casetype.getCaseType().length() > 0) {
					output = leagalAdminManager.insertcasetypemst(casetype);
				}
				if (output > 0) {

					msg = "case type added Successfully";

					mav.addObject("msg", msg);

				}

			} catch (LeagalUserException e) {

				err = "caught in exception" + e.getErrMsg();

				mav.addObject("err", err);
				mav.setViewName("addCaseType");
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return mav;

	}

	/*
	 * @RequestMapping(value = "/web/caseedit")
	 * 
	 * @ResponseBody public ModelAndView Caseedit(@ModelAttribute("casesedit")
	 * Cases caseinlist,SessionStatus status, HttpSession session) {
	 * 
	 * ModelAndView mav = new ModelAndView(); mav.setViewName("caseedit");
	 * String msg=null; String err=null; //
	 * System.out.println("caseinlistedit"+caseinlist); List<District> districts
	 * = new ArrayList<District>(); List<Unit> unitList = new ArrayList<Unit>();
	 * List<Courts> courtList = new ArrayList<Courts>(); List<CaseStages>
	 * caseStageList = new ArrayList<CaseStages>(); List<Petitioner>
	 * petitionerList = new ArrayList<Petitioner>(); List<PetitionerAdvocate>
	 * petitionerAdvList = new ArrayList<PetitionerAdvocate>(); List<Respondent>
	 * responents = new ArrayList<Respondent>(); List<RespondentAdvocate>
	 * responentsAdvList = new ArrayList<RespondentAdvocate>(); List<CaseStatus>
	 * caseStatusList = new ArrayList<CaseStatus>(); List<CasesGeneral>
	 * caseGenralList = new ArrayList<CasesGeneral>(); try {
	 * 
	 * if(caseinlist!=null&& caseinlist.getCaseWpNumber()!=null ){
	 * 
	 * if(caseinlist.getCaseId()>0){ districts =
	 * leagalAdminManager.getDistricts();
	 * unitList=leagalAdminManager.getUnitList();
	 * courtList=leagalReportManager.setCourts();
	 * caseStageList=leagalAdminManager.getCaseStagesList();
	 * petitionerList=leagalAdminManager.getPetitionerList();
	 * petitionerAdvList=leagalAdminManager.getPetitionerAdvocateList();
	 * responents=leagalAdminManager.getRespondentList();
	 * responentsAdvList=leagalAdminManager.getRespondentAdvocateList();
	 * caseStatusList=leagalAdminManager.getCaseStatusList();
	 * caseGenralList=leagalAdminManager.getCaseGeneralList();
	 * 
	 * mav.addObject("districtList",districts);
	 * 
	 * mav.addObject("caseinlist",caseinlist);
	 * 
	 * mav.addObject("selecteddistrictId", caseinlist.getCourtdistrictId());
	 * 
	 * mav.addObject("unitList",unitList); mav.addObject("selectedunitId",
	 * caseinlist.getUnitId());
	 * 
	 * mav.addObject("courtList",courtList); mav.addObject("selectedcourtId",
	 * caseinlist.getCourtId()); mav.addObject("caseStageList",caseStageList);
	 * mav.addObject("selectedstageId", caseinlist.getCaseStageId());
	 * mav.addObject("petList",petitionerList); mav.addObject("selectedpetId",
	 * caseinlist.getPetitionerIdArray());
	 * mav.addObject("petAdvList",petitionerAdvList);
	 * mav.addObject("selectedpetadvId", caseinlist.getPetetionerAdvIdArray());
	 * mav.addObject("resList",responents); mav.addObject("selectedresId",
	 * caseinlist.getRespondentIdArray());
	 * mav.addObject("resAdvList",responentsAdvList);
	 * mav.addObject("selectedresadvId", caseinlist.getRespondentAdvIdArray());
	 * mav.addObject("caseStatusList",caseStatusList);
	 * mav.addObject("selectedstatusId", caseinlist.getCaseStatusId());
	 * mav.addObject("caseGenList",caseGenralList);
	 * mav.addObject("selectedccasegenId", caseinlist.getCaseGenId());
	 * mav.addObject("selectedprojectId", caseinlist.getProjectId());
	 * mav.addObject("selectedpackageId", caseinlist.getPackageId());
	 * mav.addObject("selectedcircleId", caseinlist.getCircleId());
	 * mav.addObject("selecteddivisionId", caseinlist.getDivisionId());
	 * mav.addObject("selectedsubdivisionId", caseinlist.getSubdivisionId());
	 * mav.addObject("selectedcasegensubId", caseinlist.getCaseGenSubId());
	 * mav.addObject("selectedcasetypeId", caseinlist.getCaseTypeId());
	 * 
	 * mav.addObject("caseWpNumber",caseinlist.getCaseWpNumber());
	 * mav.addObject("caseYear",caseinlist.getCaseYear());
	 * mav.addObject("briefPrayer",caseinlist.getBriefPrayer());
	 * mav.addObject("remarks",caseinlist.getRemarks());
	 * mav.addObject("petOthers",caseinlist.getPetOthers());
	 * mav.addObject("resOthers",caseinlist.getResOthers()); } }
	 * 
	 * } catch (LeagalUserException e1) { // TODO Auto-generated catch block
	 * err="caught in exception getting the list";
	 * 
	 * mav.addObject("err",err); e1.printStackTrace(); } return mav;
	 * 
	 * }
	 * 
	 * @RequestMapping(value = "/web/caseeditsubmit")
	 * 
	 * @ResponseBody public ModelAndView
	 * Caseeditsubmit(@ModelAttribute("caseseditsubmit") Cases
	 * caseinlist,SessionStatus status, HttpSession session) {
	 * 
	 * ModelAndView mav = new ModelAndView(); mav.setViewName("caseedit");
	 * String msg=null; String err=null;
	 * 
	 * 
	 * if(caseinlist!=null&&caseinlist.getCaseWpNumber()!=null ){
	 * 
	 * //System.out.println("getCaseWpNumber()"+caseinlist.getCaseWpNumber());
	 * List<Integer> listpet = new ArrayList<Integer>(); List<Integer>
	 * listpetAdv = new ArrayList<Integer>(); List<Integer> listres = new
	 * ArrayList<Integer>(); List<Integer> listresAdv = new
	 * ArrayList<Integer>(); List<ContactPerson> contactPerson = new
	 * ArrayList<ContactPerson>(); Integer returnval=0; Integer val1=0; Integer
	 * returnval2=0; Integer returnval3=0; Integer returnval4=0; Integer
	 * returnval5=0;
	 * 
	 * String msg1=null; String msg2=null; String msg3=null; String msg4=null;
	 * String msg5=null; String msg6=null;
	 * 
	 * 
	 * 
	 * 
	 * String err1=null; String err2=null; String err3=null; String err4=null;
	 * String err5=null; String err6=null;
	 * 
	 * String err7 =null;
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * //System.out.println(caseinlist);
	 * 
	 * if(caseinlist!=null && caseinlist.getCaseWpNumber()!=null &&
	 * caseinlist.getCaseGenId()>0 && caseinlist.getCaseStageId()>0 &&
	 * caseinlist.getCaseYear()>0 && caseinlist.getCaseStatusId()>0 &&
	 * caseinlist.getRespondentIdArray()!=null &&
	 * caseinlist.getPetitionerIdArray()!=null &&
	 * caseinlist.getPetetionerAdvIdArray()!=null &&
	 * caseinlist.getRespondentAdvIdArray()!=null ){
	 * 
	 * caseinlist.setOracleUser("admin");
	 * 
	 * caseinlist.setPostgresUser(1);
	 * 
	 * String pet= caseinlist.getPetitionerIdArray();
	 * 
	 * 
	 * if(pet!=null){ for (String s : pet.split(",")){
	 * listpet.add(Integer.parseInt(s));
	 * 
	 * 
	 * } caseinlist.setPetIdlist(listpet);
	 * 
	 * } String petAdv= caseinlist.getPetetionerAdvIdArray();
	 * 
	 * if(petAdv!=null){
	 * 
	 * for (String s : petAdv.split(",")){ listpetAdv.add(Integer.parseInt(s));
	 * } caseinlist.setPetAdvIdlist(listpetAdv); }
	 * 
	 * String res= caseinlist.getRespondentIdArray();
	 * 
	 * if(res!=null){
	 * 
	 * for (String s : res.split(",")){ listres.add(Integer.parseInt(s)); }
	 * caseinlist.setResIdlist(listres); } String resAdv=
	 * caseinlist.getRespondentAdvIdArray();
	 * 
	 * if(resAdv!=null){
	 * 
	 * for (String s : resAdv.split(",")){ listresAdv.add(Integer.parseInt(s));
	 * }
	 * 
	 * caseinlist.setResAdvIdlist(listresAdv); } //
	 * returnval=leagalAdminManager.editAllforcase(caseinlist);
	 * 
	 * 
	 * // System.out.println("returnval1"+returnval1);
	 * 
	 * 
	 * 
	 * }
	 * 
	 * 
	 * 
	 * 
	 * }
	 * 
	 * return mav; }
	 */

	@RequestMapping(value = "/web/caseEditNew")
	public ModelAndView CaseEditNew(@ModelAttribute("caseeditnew") Cases casedit, SessionStatus status,
			HttpSession session) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("caseedit");
		List<Cases> caseidList = new ArrayList<Cases>();
		List<Cases> caseData = new ArrayList<Cases>();

		Integer caseId = 0;
		String msg = null;
		String err = null;
		Integer output = 0;
		Integer filesize = 0;
		List<CaseStages> caseStageList = new ArrayList<CaseStages>();
		List<CaseStatus> caseStatusList = new ArrayList<CaseStatus>();
		List<Unit> unitList = new ArrayList<Unit>();
		List<Courts> courtList = new ArrayList<Courts>();
		List<CasesGeneral> caseGenralList = new ArrayList<CasesGeneral>();
		try {
			caseidList = leagalAdminManager.getCasesList();
			mav.addObject("caseidList", caseidList);
		} catch (LeagalUserException e) {
			// TODO Auto-generated catch block
			mav.setViewName("caseedit");
			err = "caught in exception caseedit";
			mav.addObject("err", err);
			e.printStackTrace();
		}

		// System.out.println("caseditnew.getCase"+casedit.getCaseEdit());
		try {

			User user = (User) session.getAttribute("userObj");

			if (casedit != null && casedit.getCaseId() != null && casedit.getCaseEdit() == false) {
				caseId = casedit.getCaseId();
				if (caseId > 0) {
					caseData = leagalAdminManager.getcasesbycaseid(caseId);

					mav.addObject("caseData", caseData);
					caseStageList = leagalAdminManager.getCaseStagesList();
					// System.out.println("caseditnew.casedata"+caseData);
					mav.addObject("caseStageList", caseStageList);
					caseStatusList = leagalAdminManager.getCaseStatusList();
					unitList = leagalAdminManager.getUnitList();
					courtList = leagalReportManager.setCourts();
					caseGenralList = leagalAdminManager.getCaseGeneralList();

					mav.addObject("unitList", unitList);
					mav.addObject("courtList", courtList);
					mav.addObject("caseGenList", caseGenralList);
					mav.addObject("selectedunitId", caseData.get(0).getUnitId());
					mav.addObject("selectedcourtId", caseData.get(0).getCourtId());
					mav.addObject("selectedcaseGenId", caseData.get(0).getCaseGenId());
					mav.addObject("selectedcaseTypeId", caseData.get(0).getCaseTypeId());
					mav.addObject("selectedprojectId", caseData.get(0).getProjectId());
					mav.addObject("selectedpackageId", caseData.get(0).getPackageId());
					mav.addObject("selectedcaseGenSubId", caseData.get(0).getCaseGenSubId());
					mav.addObject("selectedcircleId", caseData.get(0).getCircleId());
					mav.addObject("selecteddivisionId", caseData.get(0).getDivisionId());

					mav.addObject("selectedcaseId", caseId);

					mav.addObject("caseStatusList", caseStatusList);
					mav.addObject("selectedstageId", caseData.get(0).getCaseStageId());
					mav.addObject("selectedstatusId", caseData.get(0).getCaseStatusId());
					mav.addObject("selectedcaseTypeOrder", caseData.get(0).getCaseTypeOrderId());

				}

			}

			// System.out.println("casedit.getCaseId()"+casedit.getCaseId()+"casedit.getCaseEdit()"+casedit.getCaseEdit());
			if (casedit != null && casedit.getCaseId() != null && casedit.getCaseEdit() == true) {

				caseId = casedit.getCaseId();
				if (caseId > 0) {

					if (user != null) {

						if (user.getUserName() != null) {

							casedit.setOracleUser(user.getUserName());
						}

						// System.out.println("user"+casedit.getOracleUser());

					}

					MultipartFile files = casedit.getOrderFile();
					if (null != files && files.getSize() > 0) {
						double bytes = files.getSize();
						double kb = bytes / 1024;
						String FileType = files.getContentType();
						if (kb < 1024) {

							String fileName = files.getOriginalFilename();

							String[] temps = fileName.split(Pattern.quote("."));

							// System.out.println("filelen"+temps.length);
							if (temps.length == 2) {

								String fileext = temps[temps.length - 1];
								// System.out.println("FileType"+temps[temps.length
								// - 1]);
								if (fileext.toLowerCase().equals("pdf")) {

									String rootPath = System.getProperty("catalina.base");
									File dir = new File(
											rootPath + File.separator + "webapps" + File.separator + "ICADLeagalWebApp"
													+ File.separator + "uploadedFiles" + File.separator + "legalfiles");

									casedit.setFilePath(dir.getAbsolutePath() + +casedit.getCaseId() + fileName);
									casedit.setFileName(fileName);
									if (!dir.exists())
										dir.mkdirs();

									try {
										files.transferTo(new File(dir.getAbsolutePath() + File.separator
												+ casedit.getCaseId() + fileName));

									} catch (IllegalStateException e) {
										mav.setViewName("caseedit");
										err = "caught in exception caseedit";
										mav.addObject("err", err);
										e.printStackTrace();
									} catch (IOException e) {
										mav.setViewName("caseedit");
										err = "caught in exception caseedit";
										mav.addObject("err", err);
										e.printStackTrace();
									}

									// casedit.setOracleUser("admin");
									// casedit.setPostgresUser(1);
									output = leagalAdminManager.editAllforcase(casedit);

									if (output > 0) {
										casedit.setCaseDelete(false);
										msg = "Edit Successfully";
										mav.addObject("msg", msg);
									} else {
										casedit.setCaseDelete(false);
										err = "Failed to delete ";
										mav.addObject("err", err);

									}

								}

								if (!fileext.toLowerCase().equals("pdf")) {

									err = "File extention does not match!";
									mav.addObject("err", err);
								}
							}

							if (temps.length != 2) {
								err = "Filename extention does not match!";
								mav.addObject("err", err);
							}

						}

						if (kb > 1024) {

							err = "File size exceeded";
							mav.addObject("err", err);
						}

					}

				}
			}
		} catch (LeagalUserException | ParseException e) {
			casedit.setCaseDelete(false);
			// TODO Auto-generated catch block
			mav.setViewName("caseedit");
			err = "caught in exception caseedit";
			mav.addObject("err", err);
			e.printStackTrace();
		}

		return mav;

	}

}
