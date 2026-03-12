package in.ts.icad.leagal.controller;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.dom4j.CDATA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;

import in.ts.icad.leagal.exception.ComponentUserException;
import in.ts.icad.leagal.exception.InventoryUserException;
import in.ts.icad.leagal.exception.LeagalUserException;
import in.ts.icad.leagal.exception.TaskUserException;
import in.ts.icad.leagal.manager.ComponentAdminManager;
import in.ts.icad.leagal.manager.ComponentReportManager;
import in.ts.icad.leagal.manager.InventoryAdminManager;
import in.ts.icad.leagal.manager.LeagalAdminManager;
import in.ts.icad.leagal.manager.TaskAdminManager;
import in.ts.icad.leagal.model.CadAyacutKmlDocs;
import in.ts.icad.leagal.model.Circle;
import in.ts.icad.leagal.model.CompInfo;
import in.ts.icad.leagal.model.Component;
import in.ts.icad.leagal.model.ComponentAyacut;
import in.ts.icad.leagal.model.ComponentPower;
import in.ts.icad.leagal.model.Constituency;
import in.ts.icad.leagal.model.District;
import in.ts.icad.leagal.model.Division;
import in.ts.icad.leagal.model.MiTankFormDocs;
import in.ts.icad.leagal.model.MiTankformData;
import in.ts.icad.leagal.model.Packages;
import in.ts.icad.leagal.model.PowerBill;
import in.ts.icad.leagal.model.Project;
import in.ts.icad.leagal.model.Pumpmotor;
import in.ts.icad.leagal.model.ReservoirInspect;
import in.ts.icad.leagal.model.ReservoirSalient;
import in.ts.icad.leagal.model.Subdivision;
import in.ts.icad.leagal.model.Task;
import in.ts.icad.leagal.model.TaskFiles;
import in.ts.icad.leagal.model.TaskType;
import in.ts.icad.leagal.model.Unit;
import in.ts.icad.leagal.model.User;

@Controller
public class ComponentAdminController {
	
	@Autowired
	private InventoryAdminManager invam;

	@Autowired
	private ComponentAdminManager cam;

	@Autowired
	private TaskAdminManager tam;

	@Autowired
	private LeagalAdminManager lam;

	@Autowired
	private ComponentReportManager crm;
	
	@Autowired
	private ServletContext servletContext;


	@RequestMapping(value = "/comptsimis/compinput")
	public ModelAndView ComponentInput(@ModelAttribute("Compin") Component compObject, SessionStatus status,
			HttpSession session) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("componentinput");
		List<Project> prList = new ArrayList<Project>();
		List<Project> newprList = new ArrayList<Project>();
		List<Pumpmotor> motormake = new ArrayList<Pumpmotor>();
		List<Pumpmotor> motortype = new ArrayList<Pumpmotor>();
		List<Pumpmotor> pumpmake = new ArrayList<Pumpmotor>();
		List<Pumpmotor> pumptype = new ArrayList<Pumpmotor>();

		List<Component> pumpli = new ArrayList<Component>();
		List<Component> motorli = new ArrayList<Component>();

		Component compMotorObj = new Component();
		Component compPumpObj = new Component();

		Integer result1 = 0;
		Integer result2 = 0;
		Integer result3 = 0;
		Integer result4 = 0;

		String err = null;
		String msg = null;
		try {

			
			prList = tam.getprojListbypostgres();

			motormake = cam.getMotorMakeList();
			motortype = cam.getMotorTypeList();
			pumpmake = cam.getPumpMakeList();
			pumptype = cam.getPumpTypeList();

			// System.out.println("pumpmake"+pumpmake.get(1).getPumpmakename()+"---"+pumpmake.get(1).getPumpmakeId());
			mav.addObject("motormake", motormake);
			mav.addObject("motortype", motortype);
			mav.addObject("pumpmake", pumpmake);
			mav.addObject("pumptype", pumptype);

			if (prList != null)
				if (prList.size() > 0) {
					Integer len = prList.size();
					for (int i = 0; i < len; i++) {

						if (prList.get(i).getUnitId() == 23) {

							Project proj = new Project();
							proj.setProjectId(prList.get(i).getProjectId());
							proj.setProjectName(prList.get(i).getProjectName());
							newprList.add(proj);

						}
					}
				}
			mav.addObject("newprList", newprList);

			if (compObject != null) {
				// System.out.println("compObjectid"+compObject.getComponentId());
				if (compObject.getComponentId() != null) {

					// System.out.println("compObject"+compObject);
					// System.out.println("compObjectpumpList"+compObject.getPumpList().size());
					// System.out.println("compObjectmotorlist"+compObject.getMotorList().size());
					// compObject.setFinancialyear("2017-18");
					compObject.setUserId(1);

					if (compObject.getMotorList() != null) {
						if (compObject.getMotorList().size() > 0) {

							for (int i = 101; i < compObject.getMotorList().size(); i++) {
								// System.out.println(i+"---"+compObject.getMotorList().get(i).getMotorNumber());
								motorli.add(compObject.getMotorList().get(i));
							}
							compMotorObj.setMotorList(motorli);
							compMotorObj.setUserId(1);
							compMotorObj.setComponentId(compObject.getComponentId());
							compMotorObj.setProjectId(compObject.getProjectId());
							compMotorObj.setCompPackId(compObject.getCompPackId());
							compMotorObj.setStageId(compObject.getStageId());
							compMotorObj.setPhaseId(compObject.getPhaseId());

							result1 = cam.insertComponentsMotorinfo(compMotorObj);

						}
					}

					if (compObject.getPumpList() != null) {
						if (compObject.getPumpList().size() > 0) {

							for (int i = 1; i < compObject.getPumpList().size(); i++) {
								// System.out.println(i+"---"+compObject.getPumpList().get(i).getPumpNumber());

								pumpli.add(compObject.getPumpList().get(i));

							}
							compPumpObj.setPumpList(pumpli);
							compPumpObj.setUserId(1);
							compPumpObj.setComponentId(compObject.getComponentId());
							compPumpObj.setProjectId(compObject.getProjectId());
							compPumpObj.setCompPackId(compObject.getCompPackId());
							compPumpObj.setStageId(compObject.getStageId());
							compPumpObj.setPhaseId(compObject.getPhaseId());

							result2 = cam.insertComponentsPumpinfo(compPumpObj);

						}
					}

					if (compObject.getAnnualpowerconsumption() != null || compObject.getAyacutacres() != null) {

						result3 = cam.insertComponentsPowerAyacutData(compObject);
					}

				}

				if (result1 > 0 || result2 > 0 || result3 > 0) {

					if (result1 > 0) {
						msg = "Successfully added data";

						mav.addObject("msg", msg);

					}
					if (result2 > 0) {
						msg = "Successfully added data";
						mav.addObject("msg", msg);
					}
					if (result3 > 0) {
						msg = "Successfully added data";
						mav.addObject("msg", msg);
					}
					if (result1 == 0) {
						err = "Failed to add data";
						mav.addObject("err", err);

					}

				}
			}

		} catch (TaskUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ComponentUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mav;

	}

	@RequestMapping(value = "/comptsimis/addcomp")
	public ModelAndView AddComponent(@ModelAttribute("compObj") Component compObject, SessionStatus status,
			HttpSession session) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("addcomponent");
		List<Unit> unitList = new ArrayList<Unit>();
		List<District> districts = new ArrayList<District>();
		Integer result = 0;
		String err = null;
		String msg = null;

		Integer packageId = 0;
		Integer selectpackId = 0;

		Component compfromparent = new Component();
		Integer parentComponentLength = 0;
		try {
			unitList = tam.getUnitList();
			districts = lam.getDistricts();
			// System.out.println("comp"+compObject);
			// System.out.println("comptp"+compObject.getTotalpower());
			if (compObject != null && compObject.getComponentName() != null && compObject.getStatusId() != null) {
				if (compObject.getComponentName().length() > 0) {
					if (compObject.getStatusId() > 0) {

						if (compObject.getDischrgecusecs() > 0.0) {

							compObject.setComponentCategoryId(2);
							compObject.setComponentDirection(1);

							if (compObject.getPackageId() != null) {

								if (compObject.getPackageId() > 0 && compObject.getPackageId() != 1) {

									selectpackId = compObject.getPackageId();

								}

							}

							// insertPackdata

							if (compObject.getPackageName() != null) {
								if (compObject.getPackageName().length() > 1) {
									// System.out.println("now"+compAyacutObj.getPackageName().length());

									packageId = cam.insertPackages(compObject.getProjectId(),
											compObject.getPackageName(), compObject.getUnitId());

									if (packageId != null) {
										if (packageId > 0) {

											compObject.setPackageId(packageId);
										}
									}
								}
							}

							compObject.setLevelId(1);
							if (compObject.getParentComponentId() > 0 && compObject.getParentComponentId() != -1) {

								compfromparent = cam.getParentComponentLength(compObject.getParentComponentId());

								if (compfromparent != null) {
									if (compfromparent.getToKm() > 0) {
										// System.out.println("67");
										compObject.setComponentLevelId(1);
										compObject.setFromKm(compfromparent.getToKm());
										Double len = compfromparent.getToKm() + compObject.getComponentLength();
										compObject.setToKm(len);
										compObject.setOfftakeChainage(compfromparent.getToKm());
									}
								}
							}
							if (compObject.getParentComponentId() != 0 && compObject.getParentComponentId() == -1) {
								// System.out.println("7");
								compObject.setComponentLevelId(1);
								compObject.setFromKm(0.0);
								compObject.setToKm(compObject.getComponentLength());
								compObject.setOfftakeChainage(0.0);
							}

							if (compObject.getLiftDynamicsign() == 1) {

								String liftdeliverylevel = "+" + compObject.getDeliveryLevel();
								compObject.setDeliverylevelsign(liftdeliverylevel);
							}
							if (compObject.getLiftDynamicsign() == 2) {

								String liftdeliverylevel = "-" + compObject.getDeliveryLevel();
								compObject.setDeliverylevelsign(liftdeliverylevel);

							}

							if (compObject.getLiftStaticsign() == 1) {

								String liftMDDL = "+" + compObject.getMddl();
								compObject.setMddlsign(liftMDDL);
							}
							if (compObject.getLiftStaticsign() == 2) {

								String liftMDDL = "-" + compObject.getMddl();
								compObject.setMddlsign(liftMDDL);

							}

							compObject.setPmlength(compObject.getComponentLength());
							compObject.setUserId(1);

							result = cam.insertComponents(compObject);

						}

						if (result > 0) {

							mav.addObject("msg", "Successfully Added Component");

						}

						if (result == 0) {

							mav.addObject("err", "Failed to add Component");

						}
					}
				}

			}
			mav.addObject("unitList", unitList);
			mav.addObject("districtList", districts);
		} catch (TaskUserException | LeagalUserException | ComponentUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return mav;

	}
	
	@RequestMapping(value = "/comptsimis/ayacut-menu-home")
	public ModelAndView leftMenuHome() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("ayacut-menu-home");
		return mav;

	}


	@RequestMapping(value = "/comptsimis/editComp")
	public ModelAndView EditComponent(@ModelAttribute("editcomp") Component editcomp, SessionStatus status,
			HttpSession session) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("editComponent");
		Integer editrows = 0;

		Component compfromparent = new Component();
		Integer parentComponentLength = 0;

		Component editcompObj = new Component();
		List<Unit> unitList = new ArrayList<Unit>();
		List<District> districts = new ArrayList<District>();
		Integer result = 0;
		Integer selcteddistId = 0;

		Integer packageId = 0;

		try {

			// System.out.println("compEditflag"+editcomp.getEditFlag());
			if (editcomp.getComponentId() != null && editcomp.getEditFlag() != null) {
				if (editcomp.getComponentId() > 0 && editcomp.getEditFlag() == false) {

					// System.out.println("compId"+editcomp.getComponentId());
					unitList = tam.getUnitList();
					districts = lam.getDistricts();
					editcompObj = cam.editcompinfo(editcomp.getComponentId());

					if (editcompObj != null) {
						if (editcompObj.getUnitId() != null) {
							Integer selctedUnitId = editcompObj.getUnitId();

							// System.out.println("selctedUnitId"+selctedUnitId);
							mav.addObject("selctedUnitId", selctedUnitId);
						}
						if (editcompObj.getProjectId() != null) {
							Integer selectedProj = editcompObj.getProjectId();
							mav.addObject("selectedProj", selectedProj);
						}
						if (editcompObj.getPackageId() != null) {
							Integer selctedPack = editcompObj.getPackageId();
							mav.addObject("selctedPack", selctedPack);
						}

						if (editcompObj.getComponentDirection() != null) {

							Integer selctedCompDirection = editcompObj.getComponentDirection();
							mav.addObject("selctedCompDirection", selctedCompDirection);
						}
						if (editcompObj.getParentComponentId() != null) {

							Integer selctedParentCompId = editcompObj.getParentComponentId();
							mav.addObject("selctedParentCompId", selctedParentCompId);
						}
						if (editcompObj.getComponentCategoryId() != null) {

							Integer selctedCateId = editcompObj.getComponentCategoryId();
							// System.out.println("selctedCateId"+selctedCateId);
							mav.addObject("selctedCateId", selctedCateId);
						}
						if (editcompObj.getMddlsign() != null) {

							if (editcompObj.getMddlsign().length() > 1) {
								Integer len = editcompObj.getMddlsign().length();
								String submddl = editcompObj.getMddlsign();
								String mdlsign = submddl.substring(0, 1);
								Double mddl = Double.parseDouble(submddl.substring(1, len));
								if (mdlsign.equals("+")) {
									editcompObj.setLiftStaticsign(1.0);
									editcompObj.setMddl(mddl);
									mav.addObject("selctedmdlsign", editcompObj.getLiftStaticsign());

								}

								if (mdlsign.equals("-")) {
									editcompObj.setLiftStaticsign(2.0);
									editcompObj.setMddl(mddl);
									mav.addObject("selctedmdlsign", editcompObj.getLiftStaticsign());

								}

							}

						}

						if (editcompObj.getDeliverylevelsign() != null) {

							if (editcompObj.getDeliverylevelsign().length() > 1) {
								Integer len = editcompObj.getDeliverylevelsign().length();
								String subdelivery = editcompObj.getDeliverylevelsign();
								String deliverysign = subdelivery.substring(0, 1);
								Double Deliverylevel = Double.parseDouble(subdelivery.substring(1, len));
								if (deliverysign.equals("+")) {
									editcompObj.setLiftDynamicsign(1.0);
									editcompObj.setDeliveryLevel(Deliverylevel);
									mav.addObject("selcteddelsign", editcompObj.getLiftDynamicsign());

								}

								if (deliverysign.equals("-")) {
									editcompObj.setLiftDynamicsign(2.0);
									editcompObj.setDeliveryLevel(Deliverylevel);
									mav.addObject("selcteddelsign", editcompObj.getLiftDynamicsign());

								}

							}

						}
						if (editcompObj.getStatusId() != null) {
							if (editcompObj.getStatusId() > 0) {

								Integer statusId = editcompObj.getStatusId();
								mav.addObject("selectedstatus", statusId);

							}
						}

					}

					mav.addObject("unitList", unitList);
					mav.addObject("districts", districts);
					mav.addObject("editcompObj", editcompObj);
					mav.addObject("selcteddistId", selcteddistId);

				}

			}

			// System.out.println("coming
			// here"+editcomp.getEditFlag()+"----"+editcomp.getCompPackId());

			if (editcomp.getComponentId() != null && editcomp.getEditFlag() != null
					&& editcomp.getCompPackId() != null) {

				if (editcomp.getComponentId() > 0 && editcomp.getEditFlag() == true || editcomp.getCompPackId() > 0) {

					// System.out.println("coming here");

					if (editcomp.getPackageName() != null) {
						if (editcomp.getPackageName().length() > 1) {
							// System.out.println("now"+compAyacutObj.getPackageName().length());

							packageId = cam.insertPackages(editcomp.getProjectId(), editcomp.getPackageName(),
									editcomp.getUnitId());

							if (packageId != null) {
								if (packageId > 0) {

									editcomp.setPackageId(packageId);
								}
							}
						}
					}

					if (editcomp.getComponentCategoryId() == 2) {

						editcomp.setLevelId(1);
						if (editcomp.getParentComponentId() > 0 && editcomp.getParentComponentId() != -1) {

							compfromparent = cam.getParentComponentLength(editcomp.getParentComponentId());

							if (editcomp != null) {
								if (compfromparent.getToKm() > 0) {
									editcomp.setComponentLevelId(1);
									editcomp.setFromKm(compfromparent.getToKm());
									Double len = compfromparent.getToKm() + editcomp.getComponentLength();
									editcomp.setToKm(len);
									editcomp.setOfftakeChainage(compfromparent.getToKm());
								}
							}
						}
						if (editcomp.getParentComponentId() != 0 && editcomp.getParentComponentId() == -1) {
							editcomp.setComponentLevelId(1);
							editcomp.setFromKm(0.0);
							editcomp.setToKm(editcomp.getComponentLength());
							editcomp.setOfftakeChainage(0.0);
						}

						if (editcomp.getLiftDynamicsign() == 1) {
							String liftdeliverylevel = "+" + editcomp.getDeliveryLevel();
							editcomp.setDeliverylevelsign(liftdeliverylevel);
						}
						if (editcomp.getLiftDynamicsign() == 2) {
							String liftdeliverylevel = "-" + editcomp.getDeliveryLevel();
							editcomp.setDeliverylevelsign(liftdeliverylevel);

						}

						if (editcomp.getLiftStaticsign() == 1) {
							String liftMDDL = "+" + editcomp.getMddl();
							editcomp.setMddlsign(liftMDDL);
						}
						if (editcomp.getLiftStaticsign() == 2) {
							String liftMDDL = "-" + editcomp.getMddl();
							editcomp.setMddlsign(liftMDDL);

						}

						editcomp.setPmlength(editcomp.getComponentLength());
						editcomp.setUserId(1);

						editrows = cam.updateComponents(editcomp);

					}
					if (editrows > 0) {
						mav.addObject("msg", "updated Component Successfully");

					}

					if (editrows == 0) {

						mav.addObject("err", "Failed to  Update Component");

					}

				}

			}

		} catch (ComponentUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TaskUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (LeagalUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mav;

	}

	@RequestMapping(value = "/comptsimis/getparent")
	@ResponseBody
	public String getCompParent(Integer projectId, HttpSession session, HttpServletRequest req) {

		// System.out.println("projectId"+projectId);

		List<Component> comps = new ArrayList<Component>();
		try {
			comps = cam.getParentComponent(projectId);
			// System.out.println("comps"+comps);
		} catch (ComponentUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new Gson().toJson(comps);

	}

	@RequestMapping(value = "/comptsimis/compmonthlypower")
	public ModelAndView CompmonthlyPower(@ModelAttribute("comppower") ComponentPower cpObj, SessionStatus status,
			HttpSession session) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("compmonthlypower");

		
		
		
		List<Unit> unitList = new ArrayList<Unit>();
		List<Project> prList = new ArrayList<Project>();
		List<Project> newprList = new ArrayList<Project>();

		Integer result = 0;

		try {
			
			
			
			unitList = tam.getUnitList();
			
			mav.addObject("unitList",unitList);
			if (cpObj != null && cpObj.getPresentunit() != null) {
				cpObj.setUserId(1);

				if (cpObj.getNetBillCost() > 0) {
					
					if(cpObj.getTotalAmount()!=null&& cpObj.getPaidAmount()!=null){
					
					Double pendingAmount=cpObj.getTotalAmount()-cpObj.getPaidAmount();
					
					cpObj.setPendingAmount(pendingAmount);
					
					}

					result = cam.insertComponentMonthlyPowerConsumed(cpObj);

					if (result > 0) {

						mav.addObject("msg", "Successfully added power consumed");

					} else {

						mav.addObject("err", "Failed to  add power consumed");

					}

				}
			}
			
			mav.addObject("selectedUnitId", cpObj.getUnitId());
			mav.addObject("selectedProjId", cpObj.getProjectId());
			mav.addObject("selectedCompId", cpObj.getComponentId());

		} catch (TaskUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ComponentUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mav;

	}

	@RequestMapping(value = "/comptsimis/getCompPackage")
	@ResponseBody
	public String getCompPack(Integer componentId, HttpSession session, HttpServletRequest req) {

		// System.out.println("componentId"+componentId);

		List<Packages> packs = new ArrayList<Packages>();
		try {
			packs = cam.getCompPackage(componentId);
			// System.out.println("packs"+packs);
		} catch (ComponentUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new Gson().toJson(packs);

	}

	@RequestMapping(value = "/comptsimis/getParentComp")
	@ResponseBody
	public String getComponentParent(Integer componentId, HttpSession session, HttpServletRequest req) {

		// System.out.println("componentId"+componentId);

		List<Component> comps = new ArrayList<Component>();
		try {
			comps = cam.getCompParent(componentId);
			System.out.println("comps" + comps);
		} catch (ComponentUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new Gson().toJson(comps);

	}

	@RequestMapping(value = "/comptsimis/compmonthlyayacut")
	public ModelAndView CompmonthlyAyacut(@ModelAttribute("compayacut") ComponentAyacut cpObj, SessionStatus status,
			HttpSession session) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("compmonthlyayacut");

		List<Unit> unitList = new ArrayList<Unit>();
		List<District> districts = new ArrayList<District>();
		List<Project> newprList = new ArrayList<Project>();
		List<Project> prList = new ArrayList<Project>();
		List<Constituency> cons = new ArrayList<Constituency>();

		List<District> olddistricts = new ArrayList<District>();

		// values to the next page
		Integer selectedProjectId = 0;
		Integer selectedUnitId = 0;
		Integer selectedcompId = null;
		Integer selectedDistrictId = 0;
		Integer selectedMandalId = 0;
		Integer selectedConstId = 0;
		Integer selectpackId = 0;
		Integer constdistMapId = 0;
		Integer selectedolddistId = 0;
		Integer  result=0;
		// System.out.println("coming here iam in method"+cpObj);

		try {
			
			
			olddistricts = crm.getOldDistricts();
			mav.addObject("distList", olddistricts);
			unitList = tam.getUnitList();
			districts = lam.getDistricts();
			
			User user = (User) session.getAttribute("userObj");
			
			if (user != null) {
				if (user.getUserId() != null) {
					if (user.getUserId() > 0) {
						cpObj.setUserId(user.getUserId());
						cpObj.setUserName(user.getUserName());

					}

				}

			}
			mav.addObject("newprList", newprList);
			
			
			if (cpObj != null) {
				if (cpObj.getProjectId() != null && cpObj.getPresentAyacutCreated() != null) {
					if (cpObj.getProjectId() > 0 && cpObj.getPresentAyacutCreated() > 0) {

						// assign values to the next page
						//System.out.println("cpObj.getConstId()"+cpObj.getConstId());
						selectedProjectId = cpObj.getProjectId();
						selectedUnitId = cpObj.getUnitId();
						selectedcompId=cpObj.getComponentId();
						selectedDistrictId = cpObj.getDistrictId();
						selectedMandalId = cpObj.getMandalId();
						selectedConstId = cpObj.getConstId();
						selectedolddistId = cpObj.getOldDistrictId();
					
					//System.out.println("selectedConstId"+selectedConstId);

						result = cam.insertComponentMonthlyAyacutCreated(cpObj);

					}

					if (result > 0) {
						mav.addObject("msg", "Successfully updated Ayacut Data");

					} else {
						mav.addObject("err", "Failed to add Data");

					}
				}
			}

			
			
			mav.addObject("selectedProjectId", selectedProjectId);
			mav.addObject("selectedUnitId", selectedUnitId);
			mav.addObject("selectedcompId", selectedcompId);
			mav.addObject("selectedDistrictId", selectedDistrictId);
			mav.addObject("selectedConstId", selectedConstId);
			mav.addObject("selectedMandalId", selectedMandalId);
			mav.addObject("selectpackId", selectpackId);
			mav.addObject("selectedolddistId", selectedolddistId);
			
		

			
			mav.addObject("unitList", unitList);
			mav.addObject("districtList", districts);
			
			

		} catch (TaskUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ComponentUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (LeagalUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mav;

	}

	@RequestMapping(value = "/comptsimis/deleteComponent")
	@ResponseBody
	public ModelAndView deleteComponent(@ModelAttribute("deleteComp") Component deletecomp, SessionStatus status,
			HttpSession session) {

		ModelAndView mav = new ModelAndView();
		mav.setViewName("deleteComponent");

		List<Unit> unitList = new ArrayList<Unit>();
		List<Circle> circleList = new ArrayList<Circle>();
		List<Division> divisionList = new ArrayList<Division>();
		List<Subdivision> subdivisionList = new ArrayList<Subdivision>();

		List<Component> delcompList = new ArrayList<Component>();

		User user = (User) session.getAttribute("userObj");

		List<Unit> unitData = new ArrayList<Unit>();
		// List<Circle> circleData = new ArrayList<Circle>();
		// List<Division> divisionData = new ArrayList<Division>();
		// List<Subdivision> subdivisionData = new ArrayList<Subdivision>();
		List<Project> prList = new ArrayList<Project>();

		Integer unitId = 0;
		// Integer circleId=0;
		// Integer divisionId=0;
		// Integer subdivisionId=0;
		Integer delrows = 0;

		if (user != null) {

			try {
				unitList = tam.getunitpostList();
				prList = tam.getprojListbypostgres();

				if (user.getUnitId() != null) {
					if (user.getUnitId() > 0) {
						for (int i = 0; i < unitList.size(); i++) {
							if (user.getUnitId() == unitList.get(i).getUnitId()) {

								Unit u = new Unit();

								u.setUnitId(unitList.get(i).getUnitId());
								u.setUnitName(unitList.get(i).getUnitName());

								unitData.add(u);

							}

						}

						mav.addObject("unitData", unitData);
					}

				}

				if (user.getUnitId() == null) {

					mav.addObject("unitData", unitList);

				}

				// System.out.println("unit name"+deletecomp.getUnitName());

				mav.addObject("prList", prList);

				unitId = user.getUnitId();
				// circleId=user.getCircleId();

				// divisionId=user.getDivisionId();
				// subdivisionId=user.getSubdivisionId();

				if (deletecomp != null) {

					if (deletecomp.getComponentId() != null && deletecomp.getDeleteFlag() != null) {

						if (deletecomp.getComponentId() > 0 && deletecomp.getDeleteFlag() == true) {

							delrows = cam.deleteComponent(deletecomp.getComponentId());

							if (delrows > 0) {
								mav.addObject("msg", "Deleted Component Successfully");

							}

							if (delrows == 0) {

								mav.addObject("err", "Failed to  Delete Component");

							}

						}

					}

					if (deletecomp.getProjectId() != null) {
						if (deletecomp.getProjectId() > 0) {

							// System.out.println("coming
							// here"+deletecomp.getDeleteFlag());

							delcompList = cam.getCompdatfordeleteInfo(deletecomp.getProjectId());

							mav.addObject("delcompList", delcompList);

						}
					}

				}

			} catch (TaskUserException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ComponentUserException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		return mav;

	}

	@RequestMapping(value = "/comptsimis/livecomponentDB")
	public ModelAndView editData() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("updatecomponentDB");
		return mav;

	}
	
	@RequestMapping(value = "/comptsimis/addeditdeletecomp")
	public ModelAndView addeditdeletecomp() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("addeditdeletecomp");
		return mav;

	}
	
	
	

	@RequestMapping(value = "/comptsimis/resultofliveDB")
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
			count = cam.generalqueryforresult(Query);
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
		mav.setViewName("updatecomponentDB");

		mav.addObject("resultset", count);
		mav.addObject("message", message);
		return mav;

	}

	@RequestMapping(value = "/comptsimis/delCompMonPower")
	public ModelAndView deleteCompMonPower(@ModelAttribute("delCompMonPower") ComponentPower cpObj,
			SessionStatus status, HttpSession session) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("deletecompmonpower");
		List<Unit> unitList = new ArrayList<Unit>();
		List<Project> prList = new ArrayList<Project>();
		List<Component> compsList = new ArrayList<Component>();

		List<ComponentPower> cppower = new ArrayList<ComponentPower>();

		Integer delresult = 0;

		try {
			unitList = tam.getunitpostList();
			prList = tam.getprojListbypostgres();
			compsList = cam.getComponentList();
			mav.addObject("compsList", compsList);
			mav.addObject("unitData", unitList);
			mav.addObject("prList", prList);
			if (cpObj.getUnitId() != null && cpObj.getComponentId()!=null) {
				if (cpObj.getComponentId() > 0) {
					cppower = cam.getComponentMonthlyPower(cpObj.getComponentId());

					mav.addObject("cppower", cppower);
				}
			}

			// System.out.println(cpObj.getComponentPowerId()+"---"+cpObj.getDeleteFlag());
			if (cpObj.getComponentPowerId() != null && cpObj.getDeleteFlag() != null) {

				if (cpObj.getComponentPowerId() > 0 && cpObj.getDeleteFlag() == true) {

					delresult = cam.deleteCompMonPower(cpObj.getComponentPowerId());

					if (delresult > 0) {

						mav.addObject("msg", "Successfully Deleted");

					}
					if (delresult == 0) {

						mav.addObject("err", "Failed to  Delete");

					}

				}
			}

		} catch (TaskUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ComponentUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mav;

	}

	@RequestMapping(value = "/comptsimis/editCompMonPower")
	public ModelAndView EditCompMonPower(@ModelAttribute("comppowermon") ComponentPower editcomppower,
			SessionStatus status, HttpSession session) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("editcompmonpower");

		ComponentPower editcompPowerObj = new ComponentPower();
		/*
		 * List<Unit> unitList = new ArrayList<Unit>(); List<District> districts
		 * = new ArrayList<District>(); Integer result=0; Integer
		 * selcteddistId=0;
		 */

		List<Project> prList = new ArrayList<Project>();
		List<Project> newprList = new ArrayList<Project>();

		Integer editrows = 0;

		try {

			// System.out.println("compEditflag"+editcomppower.getEditFlag());
			if (editcomppower.getComponentPowerId() != null && editcomppower.getEditFlag() != null) {
				if (editcomppower.getComponentPowerId() > 0 && editcomppower.getEditFlag() == false) {

					prList = tam.getprojListbypostgres();

					if (prList != null)
						if (prList.size() > 0) {
							Integer len = prList.size();
							for (int i = 0; i < len; i++) {

								if (prList.get(i).getUnitId() == 23) {

									Project proj = new Project();
									proj.setProjectId(prList.get(i).getProjectId());
									proj.setProjectName(prList.get(i).getProjectName());
									newprList.add(proj);

								}
							}
						}
					mav.addObject("newprList", newprList);

					editcompPowerObj = cam.editcompPowerinfo(editcomppower.getComponentPowerId());
					if (editcompPowerObj != null) {
						if (editcompPowerObj.getProjectId() != null) {
							if (editcompPowerObj.getProjectId() > 0) {

								Integer projId = editcompPowerObj.getProjectId();

								mav.addObject("selectedprojId", projId);

							}

						}

						if (editcompPowerObj.getComponentId() != null) {

							if (editcompPowerObj.getComponentId() > 0) {

								Integer compId = editcompPowerObj.getComponentId();

								// System.out.println("compId"+compId);

								mav.addObject("selectedcompId", compId);

							}

						}

					}
					mav.addObject("editcompPowerObj", editcompPowerObj);
					// System.out.println("compEditflag"+editcompPowerObj.getPowerConsumeMonth()+editcompPowerObj.getDueDate()+editcompPowerObj.getDisconnectionDate());
				}
			}

			// System.out.println("editflag"+editcomppower.getEditFlag());
			if (editcomppower.getComponentPowerId() != null && editcomppower.getEditFlag() != null) {
				if (editcomppower.getComponentPowerId() > 0 && editcomppower.getEditFlag() == true) {

					editrows = cam.updateComponentMonPower(editcomppower);

					if (editrows > 0) {

						mav.addObject("msg", "Successfully updated Component Power Data");
					}

					if (editrows == 0) {

						mav.addObject("err", "Failed to update Component Power Data");
					}

				}
			}

		} catch (ComponentUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TaskUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return mav;

	}

	@RequestMapping(value = "/comptsimis/delCompMonAyacut")
	public ModelAndView deleteCompMonAyacut(@ModelAttribute("delCompMonAyacut") ComponentAyacut cpObj,
			SessionStatus status, HttpSession session) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("deletecompmonayacut");
		List<Unit> unitList = new ArrayList<Unit>();
		List<Project> prList = new ArrayList<Project>();
		List<Component> compsList = new ArrayList<Component>();

		List<ComponentAyacut> cpayacut = new ArrayList<ComponentAyacut>();

		Integer delresult = 0;

		try {
			unitList = tam.getunitpostList();
			prList = tam.getprojListbypostgres();
			mav.addObject("unitData", unitList);
			mav.addObject("prList", prList);
			compsList = cam.getComponentList();

		
			mav.addObject("compsList", compsList);
			if (cpObj.getComponentId()!= null && cpObj.getDeleteFlag() != null) {
				if (cpObj.getComponentId() > 0 && cpObj.getDeleteFlag() == false) {

					cpayacut = cam.getComponentMonthlyAyacut(cpObj.getComponentId());

					mav.addObject("cpayacut", cpayacut);
				}
			}

			if (cpObj.getCompMonAyacutId() != null && cpObj.getDeleteFlag() != null) {

				if (cpObj.getCompMonAyacutId() > 0 && cpObj.getDeleteFlag() == true) {

					delresult = cam.deleteCompMonAyacut(cpObj.getCompMonAyacutId());

					if (delresult > 0) {

						mav.addObject("msg", "Successfully Deleted");

					}
					if (delresult == 0) {

						mav.addObject("err", "Failed to  Delete");

					}

				}
			}

		} catch (TaskUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ComponentUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mav;

	}

	@RequestMapping(value = "/comptsimis/editCompMonAyacut")
	public ModelAndView EditCompMonPower(@ModelAttribute("compayacutmon") ComponentAyacut editcompayacut,
			SessionStatus status, HttpSession session) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("editcompmonayacut");

	
		
		List<Unit> unitList = new ArrayList<Unit>();
		List<District> districts = new ArrayList<District>();
		List<District> olddistricts = new ArrayList<District>();
		List<Project> newprList = new ArrayList<Project>();
		

		Integer compMonAyacutId = 0;

		ComponentAyacut editcompAyacutObj = new ComponentAyacut();

		Integer editrows = 0;

		Integer selectedProjectId = 0;
		Integer selectedUnitId = 0;
		String selectedPackName = null;
		Integer selectedDistrictId = 0;
		Integer selectedMandalId = 0;
		Integer selectedConstId = 0;
		Integer selectpackId = 0;
		Integer selectvillage = 0;
		Double selectAyacutAcres = 0.0;
		Double selectStableAcres = 0.0;
		String selectremarks = null;
		
		Integer constrows = 0;
		String unitName = null;
		String projectName = null;
		Integer constdistMapId = 0;
		Integer selectedolddistId = 0;
		Integer selectedcompId=0;

		try {

			unitList = tam.getUnitList();
			districts = lam.getDistricts();
			// prList=tam.getprojListbypostgres();
			olddistricts = crm.getOldDistricts();
			
			if (editcompayacut.getCompMonAyacutId() != null && editcompayacut.getEditFlag() != null) {

				if (editcompayacut.getCompMonAyacutId() > 0 && editcompayacut.getEditFlag() == false) {

				compMonAyacutId = editcompayacut.getCompMonAyacutId();

				editcompAyacutObj = cam.editcompAyacutinfo(compMonAyacutId);

					if (editcompayacut != null) {
						selectedProjectId = editcompAyacutObj.getProjectId();
						selectedUnitId = editcompAyacutObj.getUnitId();
						selectedDistrictId = editcompAyacutObj.getDistrictId();
						selectedMandalId = editcompAyacutObj.getMandalId();
						selectedConstId = editcompAyacutObj.getConstId();
						selectedcompId=editcompAyacutObj.getComponentId();
						selectvillage = editcompAyacutObj.getVillageId();
						selectAyacutAcres = editcompAyacutObj.getPresentAyacutCreated();
						selectStableAcres = editcompAyacutObj.getStableAyacut();
						selectremarks = editcompAyacutObj.getRemarks();
						
						
						selectedolddistId = editcompAyacutObj.getOldDistrictId();

					}
				}
			}

			if (editcompayacut.getCompMonAyacutId() != null && editcompayacut.getEditFlag() != null
					&& editcompayacut.getPresentAyacutCreated() != null) {
				if (editcompayacut.getCompMonAyacutId() > 0 && editcompayacut.getEditFlag() == true) {

					if (editcompayacut != null) {

						if (editcompayacut.getPresentAyacutCreated() > 0) {

							// assign values to the next page

							// insertPackdata

							

							// insertConstituencydata

							editrows = cam.updateComponentMonAyacut(editcompayacut);
							if (editrows > 0) {

								mav.addObject("msg", "Successfully updated Ayacut Data");
							}

							if (editrows == 0) {

								mav.addObject("err", "Failed to update Ayacut Data");
							}

						}

					}
				}

			}

		} catch (ComponentUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TaskUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (LeagalUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		mav.addObject("selectedProjectId", selectedProjectId);
		mav.addObject("selectedUnitId", selectedUnitId);
		
		mav.addObject("selectedDistrictId", selectedDistrictId);
		mav.addObject("selectedConstId", selectedConstId);
		mav.addObject("selectedMandalId", selectedMandalId);
		mav.addObject("selectpackId", selectpackId);
		mav.addObject("selectvillage", selectvillage);
		mav.addObject("selectAyacutAcres", selectAyacutAcres);
		mav.addObject("selectStableAcres", selectStableAcres);
		mav.addObject("selectremarks", selectremarks);
		mav.addObject("compMonAyacutId", compMonAyacutId);
	
		mav.addObject("selectedcompId", selectedcompId);
		mav.addObject("selectedolddistId", selectedolddistId);

		mav.addObject("distList", olddistricts);
		mav.addObject("unitList", unitList);
		mav.addObject("districtList", districts);
		mav.addObject("editcompAyacutObj", editcompAyacutObj);
		return mav;

	}

	@RequestMapping(value = "/comptsimis/delCompInput")
	public ModelAndView deleteCompInput(@ModelAttribute("delCompinput") Component cpObj, SessionStatus status,
			HttpSession session) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("deleteCompinput");
		List<Unit> unitList = new ArrayList<Unit>();
		List<Project> prList = new ArrayList<Project>();
		List<Component> compsList = new ArrayList<Component>();

		List<Component> cp = new ArrayList<Component>();
		List<Component> cpmotor = new ArrayList<Component>();
		List<Component> cppump = new ArrayList<Component>();

		Integer delresult = 0;
		Integer delresult1 = 0;

		try {
			unitList = tam.getunitpostList();
			prList = tam.getprojListbypostgres();

			mav.addObject("prList", prList);
			mav.addObject("unitData", unitList);

			compsList = cam.getComponentList();

			mav.addObject("compsList", compsList);

		//	System.out.println("delCompInput" + cpObj.getProjectId() + "---" + cpObj.getComponentId());
			if (cpObj.getProjectId() != null && cpObj.getDeleteFlag() != null && cpObj.getComponentId() != null) {
				if (cpObj.getProjectId() > 0 && cpObj.getDeleteFlag() == false && cpObj.getComponentId() > 0) {

					// cp=cam.getComponentPowerAyacut(cpObj.getProjectId());
					// cpmotor=cam.getComponentMotorInput(cpObj.getProjectId());
					cppump = cam.getComponentPumpInput(cpObj.getComponentId());

					mav.addObject("cplist", cppump);

					// mav.addObject("cpmotor",cpmotor);

					// mav.addObject("cppump",cppump);
				}
			}

			/*
			 * if(cpObj.getComponentPowerAyacutId()!=null &&
			 * cpObj.getDeleteFlag()!=null ){
			 * 
			 * if(cpObj.getComponentPowerAyacutId()>0 &&
			 * cpObj.getDeleteFlag()==true){
			 * 
			 * delresult=cam.deleteCompInput(cpObj.getComponentPowerAyacutId());
			 * 
			 * if(delresult>0){
			 * 
			 * 
			 * mav.addObject("msg", "Successfully Deleted");
			 * 
			 * } if(delresult==0){
			 * 
			 * 
			 * mav.addObject("err", "Failed to  Delete");
			 * 
			 * }
			 * 
			 * } }
			 */
			// System.out.println("cpObj.getCompInfoId()"+cpObj.getCompInfoId()+"---"+cpObj.getDeleteFlag());

			if (cpObj.getCompInfoId() != null && cpObj.getDeleteFlag() != null) {

				if (cpObj.getCompInfoId() > 0 && cpObj.getDeleteFlag() == true) {

					// System.out.println("coming
					// here"+cpObj.getCompInfoId()+"---"+cpObj.getDeleteFlag());

					delresult1 = cam.deleteCompmotorinfo(cpObj.getCompInfoId());

					if (delresult1 > 0) {

						mav.addObject("msg", "Successfully Deleted");

					}
					if (delresult1 == 0) {

						mav.addObject("err", "Failed to  Delete");

					}

				}
			}

		} catch (TaskUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ComponentUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mav;

	}

	@RequestMapping(value = "/comptsimis/editCompInput")
	public ModelAndView EditCompInput(@ModelAttribute("compinput") Component editcominput, SessionStatus status,
			HttpSession session) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("editCompinput");

		Component editcompMotorinfo = new Component();
		Component editcomppowerayacut = new Component();

		List<Project> prList = new ArrayList<Project>();
		List<Project> newprList = new ArrayList<Project>();
		List<Pumpmotor> motormake = new ArrayList<Pumpmotor>();
		List<Pumpmotor> motortype = new ArrayList<Pumpmotor>();
		List<Pumpmotor> pumpmake = new ArrayList<Pumpmotor>();
		List<Pumpmotor> pumptype = new ArrayList<Pumpmotor>();

		List<Component> pumpCapacity = new ArrayList<Component>();
		List<Component> stageList = new ArrayList<Component>();
		List<Component> phaseList = new ArrayList<Component>();
		List<Component> pumpli = new ArrayList<Component>();
		List<Component> motorli = new ArrayList<Component>();

		Component compMotorObj = new Component();
		Component compPumpObj = new Component();

		Integer editrows = 0;
		Integer result1 = 0;
		Integer result2 = 0;

		try {

			if (editcominput.getCompInfoId() != null && editcominput.getEditFlag() != null) {
				if (editcominput.getCompInfoId() > 0 && editcominput.getEditFlag() == false) {

					mav.setViewName("editCompMotorInfo");
					motormake = cam.getMotorMakeList();
					motortype = cam.getMotorTypeList();
					pumpmake = cam.getPumpMakeList();
					pumptype = cam.getPumpTypeList();
					pumpCapacity = cam.getPumPCapacityList();

					editcompMotorinfo = cam.editcompMotorinfo(editcominput.getCompInfoId());

					if (editcompMotorinfo != null) {

						if (editcompMotorinfo.getMake() != null) {
							if (editcompMotorinfo.getComponentId() > 0) {

								Integer selectMotormakeId = editcompMotorinfo.getMake();

								mav.addObject("selectMotormakeId", selectMotormakeId);

							}

						}

						if (editcompMotorinfo.getDeviceType() != null) {

							if (editcompMotorinfo.getDeviceType() > 0) {

								Integer slectedMotorTypeId = editcompMotorinfo.getDeviceType();

								mav.addObject("slectedMotorTypeId", slectedMotorTypeId);

							}

						}

						if (editcompMotorinfo.getDeviceCapacity() != null) {

							if (editcompMotorinfo.getDeviceCapacity() > 0) {

								Integer slectedMotorCapacityId = editcompMotorinfo.getDeviceCapacity();

								mav.addObject("slectedMotorCapacityId", slectedMotorCapacityId);

							}

						}

						if (editcompMotorinfo.getStatusId() != null) {

							if (editcompMotorinfo.getStatusId() > 0) {

								Integer selctedStatusId = editcompMotorinfo.getStatusId();

								mav.addObject("selctedStatusId", selctedStatusId);

							}

						}

						if (editcompMotorinfo.getDeviceCategory() != null) {

							String selectdeviceCategory = editcompMotorinfo.getDeviceCategory();

							// System.out.println("pump"+selectdeviceCategory);

							mav.addObject("selectdeviceCategory", selectdeviceCategory);

						}

					}

					mav.addObject("editcompMotorinfo", editcompMotorinfo);
					mav.addObject("motormake", motormake);
					mav.addObject("motortype", motortype);
					mav.addObject("pumpmake", pumpmake);
					mav.addObject("pumptype", pumptype);
					mav.addObject("pumpCapacity", pumpCapacity);

				}
			}

			if (editcominput.getCompInfoId() != null && editcominput.getEditFlag() != null) {
				if (editcominput.getCompInfoId() > 0 && editcominput.getEditFlag() == true) {

					// System.out.println("coming here in edit"
					// +editcominput.getDeviceCapacity()+editcominput.getDeviceType());
					mav.setViewName("editCompMotorInfo");
					editcominput.setUserId(1);

					editrows = cam.updateComponentInfo(editcominput);

					if (editrows > 0) {

						mav.addObject("msg", "Successfully updated Component pump/motor input");
					}

					if (editrows == 0) {

						mav.addObject("err", "Failed to update Component pump/motor input");
					}

				}
			}

		} catch (ComponentUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return mav;

	}

	@RequestMapping(value = "/comptsimis/compayacutinput")
	public ModelAndView compAyacutinput(@ModelAttribute("compayacutinput") ComponentAyacut compAyacutObj,
			SessionStatus status, HttpSession session, HttpServletRequest req, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("compayacutinput");

		List<Unit> unitList = new ArrayList<Unit>();
		List<District> districts = new ArrayList<District>();
		List<Project> newprList = new ArrayList<Project>();
		List<Project> prList = new ArrayList<Project>();
		List<Constituency> cons = new ArrayList<Constituency>();

		List<District> olddistricts = new ArrayList<District>();

		Integer packageId = 0;
		Integer constituencyId = 0;
		Integer updateMandalCons = 0;
		Integer updateVillageCons = 0;
		Integer result = 0;
		Integer constrows = 0;
		// values to the next page
		Integer selectedProjectId = 0;
		Integer selectedUnitId = 0;
		String selectedPackName = null;
		Integer selectedDistrictId = 0;
		Integer selectedMandalId = 0;
		Integer selectedConstId = 0;
		Integer selectpackId = 0;
		Integer constdistMapId = 0;
		Integer selectedolddistId = 0;
		
		Integer selectedAyacutYear=0;

		try {

			olddistricts = crm.getOldDistricts();
			mav.addObject("distList", olddistricts);
			unitList = tam.getUnitList();
			districts = lam.getDistricts();
			// prList=tam.getprojListbypostgres();
			/* cons = cam.getConstList(); */

			User user = (User) session.getAttribute("userObj");
			/*
			 * if(user!=null){
			 * //System.out.println("user.getUnitId()"+user.getUnitId());
			 * if(user.getUnitId()!=null){ if(user.getUnitId()>0){
			 * if(prList!=null) if(prList.size()>0){ Integer len=prList.size();
			 * for(int i=0; i<len ;i++){
			 * 
			 * if( prList.get(i).getUnitId()==user.getUnitId()){
			 * 
			 * Project proj= new Project(); proj.setProjectId(
			 * prList.get(i).getProjectId()); proj.setProjectName(
			 * prList.get(i).getProjectName()); newprList.add(proj);
			 * 
			 * 
			 * 
			 * } } } } } }
			 */

			
			
			if (user != null) {
				
						compAyacutObj.setUserId(user.getUserId());
						compAyacutObj.setUserName(user.getUserName());

					

				}

			
			mav.addObject("newprList", newprList);

			if (compAyacutObj != null) {
				if (compAyacutObj.getProjectId() != null && compAyacutObj.getContemplatedAyacut() != null & compAyacutObj.getIrriagtedAyacut()!=null && compAyacutObj.getAyacutCreated()!=null && compAyacutObj.getStableAyacut()!=null) {
					if (compAyacutObj.getProjectId() > 0 ) {

						if(compAyacutObj.getStableAyacut()==null){
							
							compAyacutObj.setStableAyacut(0.00);
							
						}
						
                      if(compAyacutObj.getContemplatedAyacut()==null){
							
							compAyacutObj.setContemplatedAyacut(0.00);
							
						}
						if(compAyacutObj.getAyacutCreated()==null){
							
							compAyacutObj.setAyacutCreated(0.00);
						}
						
						 if(compAyacutObj.getIrriagtedAyacut()==null){
								
								compAyacutObj.setIrriagtedAyacut(0.00);
								
							}
						 
						/* if(compAyacutObj.getAyacutYear()==null){
								
								compAyacutObj.setAyacutYear(0);
								
							}*/
						 
						
						
						
						// assign values to the next page

						selectedProjectId = compAyacutObj.getProjectId();
						selectedUnitId = compAyacutObj.getUnitId();
						selectedPackName = compAyacutObj.getPackageName();
						selectedDistrictId = compAyacutObj.getDistrictId();
						selectedMandalId = compAyacutObj.getMandalId();
						selectedConstId = compAyacutObj.getConstId();
						
						//selectedAyacutYear=compAyacutObj.getAyacutYear();
					//	selectedolddistId = compAyacutObj.getOldDistrictId();
						if (compAyacutObj.getPackageId() != null) {

							if (compAyacutObj.getPackageId() > 0 && compAyacutObj.getPackageId() != 1) {

								selectpackId = compAyacutObj.getPackageId();

							}

						}
						
						compAyacutObj.setOldProjAyacutId(0);
						compAyacutObj.setJursFlag(false);

						// insertPackdata

						/*if (compAyacutObj.getPackageName() != null) {
							if (compAyacutObj.getPackageName().length() > 1) {
								// System.out.println("now"+compAyacutObj.getPackageName().length());

								packageId = cam.insertPackages(compAyacutObj.getProjectId(),
										compAyacutObj.getPackageName(), compAyacutObj.getCircleId());

								if (packageId != null) {
									if (packageId > 0) {

										compAyacutObj.setPackageId(packageId);
									}
								}
							}
						}*/

						// insertConstituencydata

						/*if (compAyacutObj.getConstId() != null) {

							constdistMapId = cam.insertConstituency(compAyacutObj);

						}*/
						/*if (constdistMapId != null) {

							// compAyacutObj.setConstId(constituencyId);

							if (constdistMapId > 0) {

								compAyacutObj.setConstdistMapId(constdistMapId);
							}

						}*/

						// insert projectYacute Data
						result = cam.insertprojAyacut(compAyacutObj);

					}

					if (result > 0) {
						mav.addObject("msg", "Successfully updated Ayacut Data");

					} else {
						mav.addObject("err", "Failed to add Data");

					}
				}
			}

		} catch (TaskUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (LeagalUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ComponentUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		mav.addObject("selectedProjectId", selectedProjectId);
		mav.addObject("selectedUnitId", selectedUnitId);
		mav.addObject("selectedPackName", selectedPackName);
		mav.addObject("selectedDistrictId", selectedDistrictId);
		mav.addObject("selectedConstId", selectedConstId);
		mav.addObject("selectedMandalId", selectedMandalId);
		mav.addObject("selectpackId", selectpackId);
		
//		mav.addObject("selectedAyacutYear", selectedAyacutYear);
		
		
		//mav.addObject("selectedolddistId", selectedolddistId);

		/* mav.addObject("constlist",cons); */
		mav.addObject("unitList", unitList);
		mav.addObject("districtList", districts);
		// System.out.println("session.getMaxInactiveInterval()"+session.getMaxInactiveInterval());

		// System.out.println("coming here 1"+status.isComplete());

		/*
		 * if(status.isComplete()){
		 * 
		 * //mav.setViewName("home"); session.invalidate();
		 * status.setComplete();
		 * 
		 * System.out.println("coming here 2"+status.isComplete()); return new
		 * ModelAndView("leagal/home");
		 * 
		 * 
		 * 
		 * }
		 */

		// System.out.println("coming here 3"+status.isComplete());
		return mav;

	}
	
	
	
	

	@RequestMapping(value = "/comptsimis/getCompType")
	@ResponseBody
	public String getCompType(Integer componentCategoryId, HttpSession session, HttpServletRequest req) {

		// System.out.println("projectId"+projectId);

		List<Component> comps = new ArrayList<Component>();
		try {
			comps = cam.getCompTypeList(componentCategoryId);
			// System.out.println("comps"+comps);
		} catch (ComponentUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new Gson().toJson(comps);

	}

	/*
	 * @RequestMapping(value = "/comptsimis/getConstituency")
	 * 
	 * @ResponseBody public String getConstituency(Integer
	 * districtId,HttpSession session, HttpServletRequest req) {
	 * 
	 * //System.out.println("projectId"+projectId);
	 * 
	 * List<Constituency> cons=new ArrayList<Constituency>(); try { cons =
	 * cam.getConstList(districtId); //System.out.println("comps"+comps); }
	 * catch (ComponentUserException e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); }
	 * 
	 * return new Gson().toJson(cons);
	 * 
	 * }
	 */

	@RequestMapping(value = "/comptsimis/getProjPacks")
	@ResponseBody
	public String getProjPacks(Integer projectId, HttpSession session, HttpServletRequest req) {

		// System.out.println("projectId"+projectId);

		List<Packages> packs = new ArrayList<Packages>();
		try {
			packs = cam.getProjPacks(projectId);
			// System.out.println("comps"+comps);
		} catch (ComponentUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new Gson().toJson(packs);

	}

	@RequestMapping(value = "/comptsimis/deleteCompAyacut")
	public ModelAndView deleteCompAyacut(@ModelAttribute("compayacutinput") ComponentAyacut deleteObj,
			HttpSession session, HttpServletRequest req, Model map) {
		ModelAndView mav = new ModelAndView();

		mav.setViewName("deleteCompAyacut");

		List<Unit> unitList = new ArrayList<Unit>();

		List<ComponentAyacut> projAyacutList = new ArrayList<ComponentAyacut>();

		Integer output = 0;
		Integer unitId = 0;

		try {
			unitList = tam.getUnitList();

			User user = (User) session.getAttribute("userObj");
			
			String userName=null;
			
			if(user!=null){
				
				userName=user.getUserName();
				
				deleteObj.setUnitId(user.getUnitId());
				
			}
			
		//	System.out.println("deleteObj.getUnitId()"+deleteObj.getUnitId());
		//	System.out.println("deleteObj.getDeleteFlag()"+deleteObj.getDeleteFlag());
			
			//19052022 sarada && deleteObj.getDeleteFlag() != null
			// && deleteObj.getDeleteFlag() == false

			if (deleteObj.getUnitId() != null ) {

				if (deleteObj.getUnitId() > 0) {

					//unitId = deleteObj.getUnitId();

					projAyacutList = cam.getProjectAyacutInfo(deleteObj.getUnitId());
				}

			}

			// System.out.println("coming"+deleteObj.getProjAyacutId()+deleteObj.getDeleteFlag());

			if (deleteObj.getProjAyacutId() != null && deleteObj.getDeleteFlag() != null) {

				if (deleteObj.getProjAyacutId() > 0 && deleteObj.getDeleteFlag() == true) {

					// System.out.println("getProjAyacutId"+deleteObj.getProjAyacutId());

					output = cam.deleteProjectAyacut(deleteObj.getProjAyacutId(),userName);

					if (output > 0) {

						mav.addObject("msg", "Successfully Deleted");

					} else {

						mav.addObject("err", "Failed to Delete");

					}

				}
			}

			// System.out.println("unitId"+unitId);

			/*
			 * if(unitId!=null){
			 * 
			 * if(unitId>0){
			 * 
			 * projAyacutList=cam.getProjectAyacutInfo(deleteObj.getUnitId());
			 * 
			 * }
			 * 
			 * }
			 */

			mav.addObject("projAyacutList", projAyacutList);
			mav.addObject("unitList", unitList);
		} catch (TaskUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ComponentUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return mav;
	}

	@RequestMapping(value = "/comptsimis/editCompAyacut")
	public ModelAndView editCompAyacut(@ModelAttribute("editcompayacutinput") ComponentAyacut editcompObj,
			HttpSession session, HttpServletRequest req) {

		ModelAndView mav = new ModelAndView();

		mav.setViewName("editCompAyacut");

		List<Unit> unitList = new ArrayList<Unit>();
		List<District> districts = new ArrayList<District>();
		// List<Project> newprList = new ArrayList<Project>();
		// List<Project> prList = new ArrayList<Project>();
		/* List<Constituency> cons=new ArrayList<Constituency>(); */

		List<District> olddistricts = new ArrayList<District>();

		Integer projayacutId = 0;

		ComponentAyacut projAyacutObj = new ComponentAyacut();

		Integer editrows = 0;

		Integer selectedProjectId = 0;
		Integer selectedUnitId = 0;
		String selectedPackName = null;
		Integer selectedDistrictId = 0;
		Integer selectedMandalId = 0;
		Integer selectedConstId = 0;
		Integer selectpackId = 0;
		Integer selectvillage = 0;
		Double selectAyacutAcres = 0.0;
		Double selectStableAcres = 0.00;
		String selectremarks = null;
		Integer packageId = 0;
		Integer constrows = 0;
		String unitName = null;
		String projectName = null;
		Integer constdistMapId = 0;
		Integer selectedolddistId = 0;
		Double selectIrriAyacutAcres=0.00;
		Double selectAyacutCreatedAcres=0.00;
		String selectAyacutContemplatedAcres=null;
	/*	Integer selectedAyacutYear=0;*/

		try {
			unitList = tam.getUnitList();
			districts = lam.getDistricts();
			// prList=tam.getprojListbypostgres();
			olddistricts = crm.getOldDistricts();
			
			User user = (User) session.getAttribute("userObj");

			if (editcompObj.getProjAyacutId() != null && editcompObj.getEditFlag() != null) {

				if (editcompObj.getProjAyacutId() > 0 && editcompObj.getEditFlag() == false) {

					projayacutId = editcompObj.getProjAyacutId();

					projAyacutObj = cam.geteditProjectAyacutInfo(projayacutId);

					if (projAyacutObj != null) {
						selectedProjectId = projAyacutObj.getProjectId();
						selectedUnitId = projAyacutObj.getUnitId();
						selectedDistrictId = projAyacutObj.getDistrictId();
						selectedMandalId = projAyacutObj.getMandalId();
						selectedConstId = projAyacutObj.getConstId();
						selectpackId = projAyacutObj.getPackageId();
						selectvillage = projAyacutObj.getVillageId();
						selectAyacutCreatedAcres = projAyacutObj.getAyacutCreated();
						selectStableAcres = projAyacutObj.getStableAyacut();
						selectremarks = projAyacutObj.getRemarks();
						unitName = projAyacutObj.getUnitName();
						projectName = projAyacutObj.getProjectName();
						constdistMapId = projAyacutObj.getConstdistMapId();
						selectedolddistId = projAyacutObj.getOldDistrictId();
						selectIrriAyacutAcres=projAyacutObj.getIrriagtedAyacut();
						/*selectedAyacutYear=projAyacutObj.getAyacutYear();*/
						
						//System.out.println("contemplated"+projAyacutObj.getContemplatedAyacut());
						
						
						 BigDecimal comtemplatedAyacut = new BigDecimal(projAyacutObj.getContemplatedAyacut()).setScale(2, RoundingMode.HALF_UP);
					    //  System.out.println("BigDecimal: " + salary3);
					    //  double salary4 = salary3.doubleValue();
					      
					   //   System.out.println("BigDecimal2: " + salary4);
						
						 
						  
						
						  
						 
							selectAyacutContemplatedAcres=comtemplatedAyacut.toString();;
					
						
						
								//projAyacutObj.getContemplatedAyacut();

					}
				}
			}

			if (editcompObj.getProjAyacutId() != null && editcompObj.getEditFlag() != null
					&& editcompObj.getContemplatedAyacut() != null) {
				if (editcompObj.getProjAyacutId() > 0 && editcompObj.getEditFlag() == true) {

					if (editcompObj != null) {

						if(editcompObj.getContemplatedAyacut()==null){
							
							editcompObj.setContemplatedAyacut(0.00);;
						}
							
							if(editcompObj.getStableAyacut()==null){
								
								editcompObj.setStableAyacut(0.00);
							}
                        if(editcompObj.getAyacutCreated()==null){
								
								editcompObj.setAyacutCreated(0.00);
							}
                        
                     /*   if(editcompObj.getAyacutYear()==null){
                        	
                        	editcompObj.setAyacutYear(0);
                        }*/
                        
                        
if(editcompObj.getIrriagtedAyacut()==null){
	
	editcompObj.setIrriagtedAyacut(0.00);
}
							
							if(user!=null){
								
								editcompObj.setUserId(user.getUserId());
								editcompObj.setUserName(user.getUserName());
								
								
							}
							
							

							// assign values to the next page

							// insertPackdata

						/*	if (editcompObj.getPackageName() != null) {
								if (editcompObj.getPackageName().length() > 1) {
									// System.out.println("now"+compAyacutObj.getPackageName().length());

									packageId = cam.insertPackages(editcompObj.getProjectId(),
											editcompObj.getPackageName(), editcompObj.getUnitId());

									if (packageId != null) {
										if (packageId > 0) {

											editcompObj.setPackageId(packageId);
										}
									}
								}
							}*/

							// insertConstituencydata

							/*if (editcompObj.getConstId() != null) {

								constrows = cam.updateConstituency(editcompObj);

							}*/

							// insert projectYacute Data
							editrows = cam.editprojAyacut(editcompObj);

							if (editrows > 0) {

								mav.addObject("msg", "Successfully updated Ayacut Data");
							}

							if (editrows == 0) {

								mav.addObject("err", "Failed to update Ayacut Data");
							}

						
					}
				}

			}

		} catch (TaskUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (LeagalUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ComponentUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		mav.addObject("selectedProjectId", selectedProjectId);
		mav.addObject("selectedUnitId", selectedUnitId);
		mav.addObject("selectedPackName", selectedPackName);
		mav.addObject("selectedDistrictId", selectedDistrictId);
		mav.addObject("selectedConstId", selectedConstId);
		mav.addObject("selectedMandalId", selectedMandalId);
		mav.addObject("selectpackId", selectpackId);
		mav.addObject("selectvillage", selectvillage);
		mav.addObject("selectAyacutCreatedAcres", selectAyacutCreatedAcres);
		mav.addObject("selectStableAcres", selectStableAcres);
		mav.addObject("selectAyacutContemplatedAcres", selectAyacutContemplatedAcres);
		mav.addObject("selectremarks", selectremarks);
		mav.addObject("projAyacutId", projayacutId);
		mav.addObject("unitName", unitName);
		mav.addObject("projectName", projectName);
		
	/*	mav.addObject("selectedAyacutYear", selectedAyacutYear);*/

		mav.addObject("constdistMapId", constdistMapId);
		mav.addObject("selectedolddistId", selectedolddistId);
		mav.addObject("selectIrriAyacutAcres", selectIrriAyacutAcres);

		mav.addObject("distList", olddistricts);
		mav.addObject("unitList", unitList);
		mav.addObject("districtList", districts);
		mav.addObject("projAyacutObj", projAyacutObj);

		return mav;
	}

	@RequestMapping(value = "/comptsimis/getConstolddistList")
	@ResponseBody
	public String getConstList(Integer districtId,Integer mcode, HttpSession session, HttpServletRequest req) {

		// System.out.println("projectId"+projectId);

		List<Constituency> cons = new ArrayList<Constituency>();
		try {

			if (districtId != null) {
				if (districtId > 0) {
					cons = cam.getConstListbyoldDist(districtId,mcode);
				}
			}
			// System.out.println("comps"+comps);
		} catch (ComponentUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new Gson().toJson(cons);

	}

	@RequestMapping(value = "/comptsimis/getLiftCompInput")
	public ModelAndView getLiftCompInput(@ModelAttribute("componentlist") Component ComponentObj, HttpSession session,
			HttpServletRequest req) {

		ModelAndView mav = new ModelAndView();
		mav.setViewName("liftcompinput");

		List<Pumpmotor> motormake = new ArrayList<Pumpmotor>();
		List<Pumpmotor> motortype = new ArrayList<Pumpmotor>();
		List<Pumpmotor> pumpmake = new ArrayList<Pumpmotor>();
		List<Pumpmotor> pumptype = new ArrayList<Pumpmotor>();
		List<Unit> unitList = new ArrayList<Unit>();
		Integer output = 0;

		try {

			// System.out.println("coming here");

			unitList = tam.getunitpostList();
			motormake = cam.getMotorMakeList();

			motortype = cam.getMotorTypeList();
			pumpmake = cam.getPumpMakeList();
			pumptype = cam.getPumpTypeList();

			if (ComponentObj.getCompInputList() != null) {

				// System.out.println("size"+ComponentObj.getCompInputList().size());
				// System.out.println(" not coming here");

				if (ComponentObj.getCompInputList().size() > 0) {

					// int len2=ComponentObj.getCompInputList().size();

					output = cam.insertComponentsinfo(ComponentObj);

					if (output > 0) {

						mav.addObject("msg", "Successful");

					} else {

						mav.addObject("err", "Faild to add data");

					}

				}
			}

		} catch (ComponentUserException | TaskUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// System.out.println("pumpmake"+pumpmake.get(1).getPumpmakename()+"---"+pumpmake.get(1).getPumpmakeId());
		mav.addObject("unitList", unitList);
		mav.addObject("motormake", motormake);
		mav.addObject("motortype", motortype);
		mav.addObject("pumpmake", pumpmake);
		mav.addObject("pumptype", pumptype);

		return mav;

	}

	@RequestMapping(value = "/comptsimis/getCompDailyInput")
	public ModelAndView getCompDailyInput(@ModelAttribute("compInfo") CompInfo compInfoObj, HttpSession session,
			HttpServletRequest req) {

		List<CompInfo> newCompinfo = new ArrayList<CompInfo>();
		ModelAndView mav = new ModelAndView();
		mav.setViewName("compLiftDailyInput");
		List<Unit> unitList = new ArrayList<Unit>();

		Integer count = 0;

		Integer output = 0;
		try {
			unitList = tam.getunitpostList();

			if (compInfoObj != null) {

				//System.out.println("compInfoObj" + compInfoObj.getComponentId());

				if (compInfoObj.getComponentId() != null) {

					if (compInfoObj.getComponentId() > 0) {

						Integer componentId = compInfoObj.getComponentId();
						newCompinfo = cam.getCompPumpsInfo(componentId);

					}

				}

			}

			if (compInfoObj.getCompInfoList() != null) {

				if (compInfoObj.getCompInfoList().size() > 0) {

					CompInfo compInfo1 = new CompInfo();

					List<CompInfo> compList = new ArrayList<CompInfo>();

					int len = compInfoObj.getCompInfoList().size();

					for (int m = 0; m < len; m++) {

						//System.out.println("print1" + m);

						if (compInfoObj.getCompInfoList().get(m).getPumpDischarge() == null
								|| compInfoObj.getCompInfoList().get(m).getPumpDischarge() == 0) {

							compInfoObj.getCompInfoList().remove(m);

							//System.out.println("print" + m);

							m--;
							len--;
							// len--;
						}

					}

					int newlen = compInfoObj.getCompInfoList().size();

					for (int k = 0; k < newlen; k++) {

						if (compInfoObj.getCompInfoList().get(k).getPumpDischarge() != null
								&& compInfoObj.getCompInfoList().get(k).getPumpDischarge() > 0.0) {

							CompInfo compInfo2 = new CompInfo();

							compInfo2.setCompInfoId(compInfoObj.getCompInfoList().get(k).getCompInfoId());
							compInfo2.setPumpName(compInfoObj.getCompInfoList().get(k).getPumpName());
							compInfo2.setPumpDischarge(compInfoObj.getCompInfoList().get(k).getPumpDischarge());
							compInfo2.setPumpStartDate(compInfoObj.getCompInfoList().get(k).getPumpStartDate());
							compInfo2.setPumpStartTime(compInfoObj.getCompInfoList().get(k).getPumpStartTime());
							compInfo2.setPumpEndTime(compInfoObj.getCompInfoList().get(k).getPumpEndTime());
							compInfo2.setPumpEnergy(compInfoObj.getCompInfoList().get(k).getPumpEnergy());
							compInfo2.setRemarks(compInfoObj.getCompInfoList().get(k).getRemarks());
							compInfo2.setUnitId(compInfoObj.getUnitId());
							compInfo2.setProjectId(compInfoObj.getProjectId());
							compInfo2.setComponentId(compInfoObj.getComponentId());
							compInfo2.setUserId(1);
							compInfo2.setUserName("admin");

							compList.add(compInfo2);
						}

					}

					compInfo1.setCompInfoList(compList);

					// for (int n=0; n< compInfo1.getCompInfoList().size();n++){

					// Double
					// hiddentest=compInfo1.getCompInfoList().get(n).getPumpDischarge();

					// System.out.println("i am here11 "+hiddentest);
					// System.out.println("i am here2
					// "+compInfo1.getCompInfoList().get(n).getComponentId());
					// System.out.println("i am here
					// 3"+compInfo1.getCompInfoList().get(n).getCompInfoId());

					// }

					if (compInfo1.getCompInfoList() != null) {

						if (compInfo1.getCompInfoList().size() > 0) {
							output = cam.insertComponentsDailyinfo(compInfo1);

							if (output > 0) {

								mav.addObject("msg", "Successful");

							}
							if (output == 0) {

								mav.addObject("err", "Failed to add Data");

							}

						}
					}

				}
			}

		} catch (TaskUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ComponentUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		mav.addObject("unitList", unitList);
		mav.addObject("newCompinfo", newCompinfo);
		mav.addObject("selectedUnitId", compInfoObj.getUnitId());
		mav.addObject("selectedProjId", compInfoObj.getProjectId());
		mav.addObject("selectedCompId", compInfoObj.getComponentId());

		return mav;

	}

	@RequestMapping(value = "/comptsimis/deleteCompdailyInput")
	public ModelAndView deleteCompDailyInput(@ModelAttribute("deleteCompdailyInput") CompInfo deleteObj,
			HttpSession session, HttpServletRequest req, Model map) {
		ModelAndView mav = new ModelAndView();

		mav.setViewName("deleteCompdailyInput");

		List<Unit> unitList = new ArrayList<Unit>();
		List<Project> prList = new ArrayList<Project>();
		List<Component> compsList = new ArrayList<Component>();

		List<CompInfo> compInfList = new ArrayList<CompInfo>();

		Integer output = 0;
		Integer unitId = 0;

		try {
			unitList = tam.getUnitList();

			prList = tam.getprojListbypostgres();

			compsList = cam.getComponentList();

			mav.addObject("prList", prList);
			mav.addObject("compsList", compsList);

			User user = (User) session.getAttribute("userObj");

			if (deleteObj.getUnitId() != null && deleteObj.getDeleteFlag() != null && deleteObj.getComponentId() != null
					&& deleteObj.getComponentDate() != null) {

				if (deleteObj.getUnitId() > 0 && deleteObj.getDeleteFlag() == false && deleteObj.getComponentId() > 0) {

					// System.out.println("coming"+deleteObj.getUnitId()+deleteObj.getComponentId()+deleteObj.getDeleteFlag());

					unitId = deleteObj.getUnitId();

					compInfList = cam.getCompdailyInfo(deleteObj.getComponentId(), deleteObj.getComponentDate());
				}

			}

			// System.out.println("coming"+deleteObj.getProjAyacutId()+deleteObj.getDeleteFlag());

			if (deleteObj.getComponentId() != null && deleteObj.getDeleteFlag() != null
					&& deleteObj.getCompInputId() != null) {

				if (deleteObj.getComponentId() > 0 && deleteObj.getDeleteFlag() == true
						&& deleteObj.getCompInputId() > 0) {

					output = cam.deleteCompDailyInput(deleteObj.getCompInputId());

					if (output > 0) {

						mav.addObject("msg", "Successfully Deleted");

					} else {

						mav.addObject("err", "Failed to Delete");

					}

				}
			}

			// System.out.println("unitId"+unitId);

			/*
			 * if(unitId!=null){
			 * 
			 * if(unitId>0){
			 * 
			 * projAyacutList=cam.getProjectAyacutInfo(deleteObj.getUnitId());
			 * 
			 * }
			 * 
			 * }
			 */

			mav.addObject("compInfList", compInfList);
			mav.addObject("unitList", unitList);
		} catch (TaskUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ComponentUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return mav;
	}

	@RequestMapping(value = "/comptsimis/editCompDailyInput")
	public ModelAndView EditCompInput(@ModelAttribute("editcompdailyinput") CompInfo editcomdailyObj,
			SessionStatus status, HttpSession session) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("editDailyInput");

		List<Project> prList = new ArrayList<Project>();
		List<Project> newprList = new ArrayList<Project>();

		CompInfo compinfObj = new CompInfo();
		
		User user = (User) session.getAttribute("userObj");

		Integer editrows = 0;

		try {
			
			if(user!=null && user.getUserId()!=null){

			if (editcomdailyObj.getCompInputId() != null && editcomdailyObj.getEditFlag() != null) {
				if (editcomdailyObj.getCompInputId() > 0 && editcomdailyObj.getEditFlag() == false) {
					
					//System.out.println("coming here in edit"+editcomdailyObj.getCompInputId());

					compinfObj = cam.getEditdailyInfo(editcomdailyObj.getCompInputId());
					
					//System.out.println("coming here in edit"+compinfObj.getCompInfoId());

				}

			}

			mav.addObject("compinfObj", compinfObj);

			if (editcomdailyObj.getCompInputId() != null && editcomdailyObj.getEditFlag() != null) {
				if (editcomdailyObj.getCompInputId() > 0 && editcomdailyObj.getEditFlag() == true) {

					// System.out.println("coming here in edit"
					// +editcominput.getDeviceCapacity()+editcominput.getDeviceType());

					editcomdailyObj.setUserId(user.getUserId());
					editcomdailyObj.setUserName(user.getUserName());

					 editrows=cam.editCompDailyInput(editcomdailyObj);

					if (editrows > 0) {

						mav.addObject("msg", "Successfully updated Component pump/motor input");
					}

					if (editrows == 0) {

						mav.addObject("err", "Failed to update Component pump/motor input");
					}

				}
			}

			}
		} catch (ComponentUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return mav;

	}

	
	@RequestMapping(value = "/comptsimis/getCompDischargeInput")
	public ModelAndView getCompDischargeInput(@ModelAttribute("compInfo") CompInfo compInfoObj, HttpSession session,
			HttpServletRequest req) {

		List<CompInfo> newCompinfo = new ArrayList<CompInfo>();
		ModelAndView mav = new ModelAndView();
		mav.setViewName("DischargeInput");
		List<Unit> unitList = new ArrayList<Unit>();

		Integer count = 0;

		Integer output = 0;
		try {
			unitList = tam.getunitpostList();
			
			User user = (User) session.getAttribute("userObj");
			
			if(user!=null&& user.getUserId()!=null){

			if (compInfoObj != null) {

				//System.out.println("compInfoObj" + compInfoObj.getComponentId());

				if (compInfoObj.getComponentId() != null) {

					if (compInfoObj.getComponentId() > 0) {
                           
						compInfoObj.setUserId(user.getUserId());
						compInfoObj.setUserName(user.getUserName());
						
						if(compInfoObj.getSeasonMonthName()!=null){
							
						String monthYear=	compInfoObj.getSeasonMonthName()	;
						
						Integer month=Integer.parseInt(monthYear.substring(0, 2));
						Integer year=Integer.parseInt(monthYear.substring(3,7));
						
						
						compInfoObj.setSeasonMonth(month);	
						compInfoObj.setSeasonYear(year);
							
						}
						output= cam.insertCompDischarge(compInfoObj);
						
						if (output > 0) {

							mav.addObject("msg", "Successful");

						}
						if (output == 0) {

							mav.addObject("err", "Failed to add Data");

						}

					}

				}

			}

			}
				
			

		} catch (TaskUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ComponentUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		mav.addObject("unitList", unitList);
		
		mav.addObject("selectedUnitId", compInfoObj.getUnitId());
		mav.addObject("selectedProjId", compInfoObj.getProjectId());
		mav.addObject("selectedCompId", compInfoObj.getComponentId());

		return mav;

	}

	
	@RequestMapping(value = "/comptsimis/deleteDischargeInput")
	public ModelAndView deleteDischargeInput(@ModelAttribute("deleteDischargeInput") CompInfo deleteObj,
			HttpSession session, HttpServletRequest req, Model map) {
		ModelAndView mav = new ModelAndView();

		mav.setViewName("deleteDischargeInput");

		List<Unit> unitList = new ArrayList<Unit>();
		
		List<Project> prList = new ArrayList<Project>();
		List<Component> compsList = new ArrayList<Component>();

		List<CompInfo> compInfList = new ArrayList<CompInfo>();
		
		List<CompInfo> compInfList2 = new ArrayList<CompInfo>();

		Integer output = 0;
		Integer unitId = 0;

		try {
			unitList = tam.getUnitList();

			prList = tam.getprojListbypostgres();

			compsList = cam.getComponentList();

			mav.addObject("prList", prList);
			mav.addObject("compsList", compsList);

			User user = (User) session.getAttribute("userObj");

			if (deleteObj.getUnitId() != null && deleteObj.getDeleteFlag() != null && deleteObj.getComponentId() != null ) {

				if (deleteObj.getUnitId() > 0 && deleteObj.getDeleteFlag() == false && deleteObj.getComponentId() > 0) {

					//System.out.println("coming"+deleteObj.getUnitId()+deleteObj.getComponentId()+deleteObj.getDeleteFlag());

					//unitId = deleteObj.getUnitId();

					compInfList = cam.getCompDischargeList(deleteObj.getComponentId());
					
					if(compInfList!=null){
						int len=compInfList.size();
						
						
						
						//System.out.println("coming here"+len);
						
						for(int i=0;i<len;i++){
							CompInfo compNew2= new CompInfo();
							
							compNew2.setCompDischargeId(compInfList.get(i).getCompDischargeId());
							compNew2.setUnitId(compInfList.get(i).getUnitId());
							compNew2.setProjectId(compInfList.get(i).getProjectId());
							compNew2.setComponentId(compInfList.get(i).getComponentId());
							compNew2.setSeasonId(compInfList.get(i).getSeasonId());
							if(compInfList.get(i).getSeasonId()==1){
								
							compNew2.setSeasonName("Kharif");
							
							}
							else if(compInfList.get(i).getSeasonId()==2){
								
								compNew2.setSeasonName("Rabi");
								
								
							}
							compNew2.setSeasonYear(compInfList.get(i).getSeasonYear());
							compNew2.setSeasonMonth(compInfList.get(i).getSeasonMonth());
							
							compNew2.setPumpDischarge(compInfList.get(i).getPumpDischarge());
							compNew2.setAyacut(compInfList.get(i).getAyacut());
							compNew2.setRemarks(compInfList.get(i).getRemarks());
							compNew2.setProjectName(compInfList.get(i).getProjectName());
							compNew2.setUnitName(compInfList.get(i).getUnitName());
							compNew2.setComponentName(compInfList.get(i).getComponentName());
							
if(compInfList.get(i).getSeasonMonth()==1){
								
	compNew2.setSeasonMonthName("January");
							}else if(compInfList.get(i).getSeasonMonth()==2){
								compNew2.setSeasonMonthName("February");
								
							}
							else if(compInfList.get(i).getSeasonMonth()==3){
								compNew2.setSeasonMonthName("March");
								
							}
							else if(compInfList.get(i).getSeasonMonth()==4){
								compNew2.setSeasonMonthName("April");
								
							}
							else if(compInfList.get(i).getSeasonMonth()==5){
								compNew2.setSeasonMonthName("May");
								
							}
							else if(compInfList.get(i).getSeasonMonth()==6){
								compNew2.setSeasonMonthName("June");
								
							}
							else if(compInfList.get(i).getSeasonMonth()==7){
								compNew2.setSeasonMonthName("July");
								
							}
							else if(compInfList.get(i).getSeasonMonth()==8){
								compNew2.setSeasonMonthName("August");
								
							}
							else if(compInfList.get(i).getSeasonMonth()==9){
								compNew2.setSeasonMonthName("Sepetember");
								
							}
							else if(compInfList.get(i).getSeasonMonth()==10){
								compNew2.setSeasonMonthName("October");
								
							}
							else if(compInfList.get(i).getSeasonMonth()==11){
								compNew2.setSeasonMonthName("November");
								
							}
							else if(compInfList.get(i).getSeasonMonth()==12){
								compNew2.setSeasonMonthName("December");
								
							}
							
                           compInfList2.add(compNew2);
						}
						
						
						
						
					}
				}

			}

			// System.out.println("coming"+deleteObj.getProjAyacutId()+deleteObj.getDeleteFlag());

			if (deleteObj.getComponentId() != null && deleteObj.getDeleteFlag() != null
					&& deleteObj.getCompDischargeId() != null) {

				if (deleteObj.getComponentId() > 0 && deleteObj.getDeleteFlag() == true
						&& deleteObj.getCompDischargeId() > 0) {
					
					
					//System.out.println("coming"+deleteObj.getCompDischargeId()+deleteObj.getDeleteFlag());

					output = cam.deleteCompDischarge(deleteObj.getCompDischargeId());

					if (output > 0) {

						mav.addObject("msg", "Successfully Deleted");

					} else {

						mav.addObject("err", "Failed to Delete");

					}

				}
			}

			

			mav.addObject("compInfList", compInfList2);
			mav.addObject("unitList", unitList);
		} catch (TaskUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ComponentUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return mav;
	}
	
	
	
	
	
	@RequestMapping(value = "/comptsimis/editCompDischargeInput")
	public ModelAndView EditCompDischarge(@ModelAttribute("editCompDischargeInput") CompInfo editcomdailyObj,
			SessionStatus status, HttpSession session) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("editDischargeInput");

		List<Project> prList = new ArrayList<Project>();
		List<Project> newprList = new ArrayList<Project>();
		List<Unit> unitList = new ArrayList<Unit>();

		CompInfo compinfObj = new CompInfo();
		
		User user = (User) session.getAttribute("userObj");

		Integer editrows = 0;

		try {
			
		
			unitList = tam.getUnitList();
			if(user!=null && user.getUserId()!=null){

			if (editcomdailyObj.getCompDischargeId()!= null && editcomdailyObj.getEditFlag() != null) {
				if (editcomdailyObj.getCompDischargeId() > 0 && editcomdailyObj.getEditFlag() == false) {
					
					//System.out.println("coming here in edit"+editcomdailyObj.getCompDischargeId());

					compinfObj = cam.getEditCompDischarge(editcomdailyObj.getCompDischargeId());
					
					//System.out.println("coming here in edit"+compinfObj.getCompInfoId());

				}

			}

			mav.addObject("compinfObj", compinfObj);

			if (editcomdailyObj.getCompDischargeId() != null && editcomdailyObj.getEditFlag() != null) {
				if (editcomdailyObj.getCompDischargeId() > 0 && editcomdailyObj.getEditFlag() == true) {

					// System.out.println("coming here in edit");
					// +editcominput.getDeviceCapacity()+editcominput.getDeviceType());

					editcomdailyObj.setUserId(user.getUserId());
					editcomdailyObj.setUserName(user.getUserName());
					
					if(editcomdailyObj.getSeasonMonthName()!=null){
						
						String monthYear =editcomdailyObj.getSeasonMonthName();
						
						Integer month =Integer.parseInt(monthYear.substring(0,2));
						
						Integer year=Integer.parseInt(monthYear.substring(3,7));
						
						//System.out.println("coming here in edit"+month+"/"+year);
						
						
						if(month!=null){
							
							editcomdailyObj.setSeasonMonth(month);
							
						}if(year!=null){
							
							
							editcomdailyObj.setSeasonYear(year);
							
							
						}
						
						
						
					}

					 editrows=cam.updateCompDischarge(editcomdailyObj);

					if (editrows > 0) {

						mav.addObject("msg", "Successfully updated Component Discharge");
					}

					if (editrows == 0) {

						mav.addObject("err", "Failed to update Component Discharge");
					}

				}
			}

			}
			
			mav.addObject("unitList",unitList);
		} catch (ComponentUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TaskUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return mav;

	}
	
	
	@RequestMapping(value = "/comptsimis/ComponentPowerBill")
	public ModelAndView AddComponentPowerBill(@ModelAttribute("comppowerbill") PowerBill  powerObj, SessionStatus status, HttpSession session) {
		
	
		ModelAndView mav = new ModelAndView();
		mav.setViewName("componentPowerBill");
		
		
		List<Unit> unitList = new ArrayList<Unit>();
		List<Project> prList = new ArrayList<Project>();
		List<Project> newprList = new ArrayList<Project>();

		Integer result = 0;
		Integer docId=0;
		String docName=null;
		String docExt=null;

		try {
			
		
			
			
			unitList = tam.getUnitList();
			
			
			mav.addObject("unitList",unitList);
			if (powerObj != null ) {
				if(powerObj.getTotalAmount() != null){
					powerObj.setUserId(1);
					powerObj.setUserName("admin");
                  
				docId=cam.getDocNumber();
				if (powerObj.getTotalAmount() > 0) {
					
				
					
					if(powerObj.getTotalAmount()!=null&& powerObj.getPaidAmount()!=null){
					
					Double pendingAmount=powerObj.getTotalAmount()-powerObj.getPaidAmount();
					
					powerObj.setPendingAmount(pendingAmount);
					
					}
					
			    if(powerObj.getUploadBill()!=null){
			    	
			    MultipartFile filedata=powerObj.getUploadBill();
			    
			    if(filedata!=null){
			    	
			    	String fileName=filedata.getOriginalFilename();
			    	
			    	
			    	
			    	powerObj.setDocumentName(fileName);
			    	
			    	if(fileName.length()>0){
			    		docExt= fileName.substring(fileName.length()-4);
			    		
			    		docName=	"powerBill"+docId+docExt;
			    		
			    		
			    		
			    	}
			    	
			    	 String rootPath = System.getProperty("catalina.base");
					 File dir = new File(rootPath + File.separator + "webapps"
								+ File.separator + "ICADLeagalWebApp" + File.separator
								+ "uploadedFiles"+File.separator+"ComponentsPowerBill");
					 
					 if (!dir.exists())
							dir.mkdirs();
					 
					 
					 powerObj.setDocumentPath(dir.getAbsolutePath()+ File.separator
								+ docName);
					 
						
					 powerObj.setDocumentNumer(docName);
					 
					 
					 filedata.transferTo(new File(dir.getAbsolutePath()
								+ File.separator + docName));
			    	
			    }
			    	
			    	
			    	
			    }

					result = cam.insertPowerBill(powerObj);

					if (result > 0) {

						mav.addObject("msg", "Successfully added power consumed");

					} else {

						mav.addObject("err", "Failed to  add power consumed");

					}

				}
			}
			}
			
			mav.addObject("selectedUnitId", powerObj.getUnitId());
			mav.addObject("selectedProjId", powerObj.getProjectId());
			mav.addObject("selectedCompId", powerObj.getComponentId());

		} catch (TaskUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ComponentUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mav;
		
	}
	
	
	@RequestMapping(value = "/comptsimis/deleteCompPowerBill")
	public ModelAndView deleteCompPowerBill(@ModelAttribute("deleteCompPowerBill") PowerBill cpObj,
			SessionStatus status, HttpSession session) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("deleteCompPowerBill");
		List<Unit> unitList = new ArrayList<Unit>();
		List<Project> prList = new ArrayList<Project>();
		List<Component> compsList = new ArrayList<Component>();

		List<PowerBill> cppower = new ArrayList<PowerBill>();

		Integer delresult = 0;

		try {
			unitList = tam.getunitpostList();
			prList = tam.getprojListbypostgres();
			compsList = cam.getComponentList();
			mav.addObject("compsList", compsList);
			mav.addObject("unitData", unitList);
			mav.addObject("prList", prList);
			if (cpObj.getUnitId() != null && cpObj.getComponentId()!=null) {
				if (cpObj.getComponentId() > 0) {
					cppower = cam.getComponentPowerInfo(cpObj.getComponentId());

					mav.addObject("cppower", cppower);
				}
			}

			// System.out.println(cpObj.getComponentPowerId()+"---"+cpObj.getDeleteFlag());
			if (cpObj.getCompPowerBillId() != null && cpObj.getDeleteFlag() != null) {

				if (cpObj.getCompPowerBillId() > 0 && cpObj.getDeleteFlag() == true) {

					delresult = cam.deleteCompPowerBill(cpObj.getCompPowerBillId());

					if (delresult > 0) {

						mav.addObject("msg", "Successfully Deleted");

					}
					if (delresult == 0) {

						mav.addObject("err", "Failed to  Delete");

					}

				}
			}

		} catch (TaskUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ComponentUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mav;

	}

	@RequestMapping(value = "/comptsimis/editCompPowerBill")
	public ModelAndView EditCompPowerBill(@ModelAttribute("editCompPowerBill") PowerBill editcomppower,
			SessionStatus status, HttpSession session) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("editCompPowerBill");

		PowerBill editcompPowerObj = new PowerBill();
		/*
		 * List<Unit> unitList = new ArrayList<Unit>(); List<District> districts
		 * = new ArrayList<District>(); Integer result=0; Integer
		 * selcteddistId=0;
		 */

		List<Project> prList = new ArrayList<Project>();
		List<Project> newprList = new ArrayList<Project>();
		List<Unit> unitList = new ArrayList<Unit>();

		Integer editrows = 0;
		
		Integer docId=0;
		String docExt=null;
		String docName=null;
		try {
			
			unitList = tam.getunitpostList();
			
			mav.addObject("unitList", unitList);
		// System.out.println("compEditflag"+editcomppower.getEditFlag());
		if (editcomppower.getCompPowerBillId() != null && editcomppower.getEditFlag() != null) {
			if (editcomppower.getCompPowerBillId() > 0 && editcomppower.getEditFlag() == false) {

			

		
				

			
				editcompPowerObj = cam.getComponentPowerEditInfo(editcomppower.getCompPowerBillId());
				
			}
				
			
		}
		
		mav.addObject("editcompPowerObj",editcompPowerObj);

		// System.out.println("editflag"+editcomppower.getEditFlag());
		if (editcomppower.getCompPowerBillId() != null && editcomppower.getEditFlag() != null) {
			if (editcomppower.getCompPowerBillId() > 0 && editcomppower.getEditFlag() == true) {

			
				
				
				if (editcomppower != null ) {
					if(editcomppower.getTotalAmount() != null){
						editcomppower.setUserId(1);
						editcomppower.setUserName("admin");
	                  
					docId=cam.getDocNumber();
					if (editcomppower.getTotalAmount() > 0) {
						
					
						
						if(editcomppower.getTotalAmount()!=null&& editcomppower.getPaidAmount()!=null){
						
						Double pendingAmount=editcomppower.getTotalAmount()-editcomppower.getPaidAmount();
						
						editcomppower.setPendingAmount(pendingAmount);
						
						}
						
				    if(editcomppower.getUploadBill()!=null){
				    	
				    MultipartFile filedata=editcomppower.getUploadBill();
				    
				    if(filedata!=null){
				    	
				    	String fileName=filedata.getOriginalFilename();
				    	
				    	
				    	
				    	editcomppower.setDocumentName(fileName);
				    	
				    	if(fileName.length()>0){
				    		docExt= fileName.substring(fileName.length()-4);
				    		
				    		docName=	"powerBill"+docId+docExt;
				    		
				    		
				    		
				    	}
				    	
				    	 String rootPath = System.getProperty("catalina.base");
						 File dir = new File(rootPath + File.separator + "webapps"
									+ File.separator + "ICADLeagalWebApp" + File.separator
									+ "uploadedFiles"+File.separator+"ComponentsPowerBill");
						 
						 if (!dir.exists())
								dir.mkdirs();
						 
						 
						 editcomppower.setDocumentPath(dir.getAbsolutePath()+ File.separator
									+ docName);
						 
							
						 editcomppower.setDocumentNumer(docName);
						 
						 
						 filedata.transferTo(new File(dir.getAbsolutePath()
									+ File.separator + docName));
				    	
				    }
				    	
				    	
				    	
				    }

						

					}
					
					editrows = cam.updatePowerBill(editcomppower);
					
					if (editrows > 0) {

						mav.addObject("msg", "Successfully updated Component Power Data");
					}

					if (editrows == 0) {

						mav.addObject("err", "Failed to update Component Power Data");
					}
				}
				}
				
				
				
				
				

			}
		}
		
		} catch (ComponentUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TaskUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		return mav;

	}
	
	@RequestMapping(value = "/comptsimis/addProjAyacutSeasonal")
	public ModelAndView AddProjAyacutSeasonal(@ModelAttribute("addSeasonalprojayacut") ComponentAyacut ayacutObj,
			SessionStatus status, HttpSession session) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("add-shivam-data");
		
		List<ComponentAyacut> ayacutList = new ArrayList<ComponentAyacut>();
		
		User user = (User) session.getAttribute("userObj");

		 String vanadate=null;
		  String yasangidate=null;
		  
		  Integer f=0;
		  String k=null;
		  Integer d=0;
		  Integer c=0;
		  String m=null;
		
		try{
			ayacutList=cam.getprojactmondata(user);
			List<ComponentAyacut> compCapList = new ArrayList<ComponentAyacut>();
			
	if (user!=null){
		
		ComponentAyacut compObj= new ComponentAyacut();
				
				compObj.setUserName(user.getUserName());
				compObj.setUnitId(user.getUnitId());
				compObj.setCircleId(user.getCircleId());
				
				compObj.setDivisionId(user.getDivisionId());
				compObj.setSubdivisionId(user.getSubdivisionId());
				
				
				Integer month=Calendar.getInstance().get(Calendar.MONTH);
				Integer year=Calendar.getInstance().get(Calendar.YEAR);
				Integer i=1;
			//month=10;
				  
				  if(month>9 && month<=12){
					  
						//System.out.println("month 9 and 12");
					  f=(year + i) ;
					  k=f.toString() ;
					  k=k.substring(2,4);		
					vanadate= year +"-"+ k;
					  }
				  
				  if((month>=0 && month<=9)){
					  
					//  System.out.println("month 0 and 9");
						 // alert("in 0 to 4");
						  f= year ;
						  k=f.toString() ;
						  k=k.substring(2,4);		
						  vanadate= (year-1) +"-"+ k;
						  }
				  if(month>=0 && month<=12){
					  
					 // System.out.println("month 0 and 12");
					  d= year;
					  c=year+i ;
					 m=c.toString();
					  m=m.substring(2,4);		
					  yasangidate= year +"-"+ m;
					  
					  } 
				
					
					if(month>=5 && month<=9){
						
						
						
						String actYear=yasangidate ;
						String actYear2=vanadate;
						
						
						
						     compObj.setKhrifactplanYear(actYear);
						     
						     compObj.setRabiactplanYear(actYear2);
					}
					
                  if((month>9 && month<=12) || (month>0 && month<=4) ){
						
						String actYear=yasangidate ;
						
						String actYear2=vanadate;
						
						compObj.setKhrifactplanYear(actYear);
						     
						compObj.setRabiactplanYear(actYear2);
					}
					
					
		
			
			
			
				
			
				compCapList=cam.getProjSeasonCapInfo(compObj);
				
			}
			
			

			
			mav.addObject("ayacutList",ayacutList);
			mav.addObject("compCapList",compCapList);
		}catch (ComponentUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return mav;

	}
	
	@RequestMapping(value = "/comptsimis/addProjcapacitySeasonal")
	public ModelAndView AddCapacityAyacutSeasonal(@ModelAttribute("addcapacityprojayacut") ComponentAyacut ayacutObj,
			SessionStatus status, HttpSession session) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("add-shivam-abstract");
		
		List<Project> projectList = new ArrayList<Project>();
		
		User user = (User) session.getAttribute("userObj");
		try{
			
			projectList= lam.getProjectList(user.getUnitId());
			
			mav.addObject("projectList",projectList);
			
		
		} catch (LeagalUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return mav;

		
	}
	@RequestMapping(value = "/comptsimis/sciwam-menu-home")
	public ModelAndView sciwamMenuHome() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("sciwam-menu-home");
		return mav;

	}
	
	
	@RequestMapping(value = "/comptsimis/projects-menu-home")
	public ModelAndView projectsMenuHome() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("projects-menu-home");
		return mav;

	}
	
	
	
	@RequestMapping(value = "/comptsimis/add-proj-season-cap")
	@ResponseBody
	public String addProjSeasonCap(ComponentAyacut compObj , HttpServletRequest request,
			HttpSession session, SessionStatus status) {
		
		//System.out.println("i am in kal"+compObj);

		//List<ReservoirInspect> resInspect = new ArrayList<ReservoirInspect>();

		Integer projSeasonCapId=0;
		// List<PumpStations> pumpStationList= new ArrayList<PumpStations>();
		
		User user = (User) session.getAttribute("userObj");

		try {
			
			if (user!=null){
				
				compObj.setUserName(user.getUserName());
				compObj.setUnitId(user.getUnitId());
				compObj.setCircleId(user.getCircleId());
				
				compObj.setDivisionId(user.getDivisionId());
				compObj.setSubdivisionId(user.getSubdivisionId());
				
			}

			if (compObj.getProjectId() != null && compObj.getSeasonId() != null && compObj.getActplanYear() != null) {

				if (compObj.getProjectId() > 0 && compObj.getSeasonId() > 0) {
					projSeasonCapId = cam.insertProjectSeasonCapacity(compObj);
				}

			}

			// System.out.println("resListbyId"+resListbyId);

		
		} catch (ComponentUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new Gson().toJson(projSeasonCapId);

	}
	
	
	@RequestMapping(value = "/comptsimis/add-proj-season-ayacut")
	@ResponseBody
	public String addProjSeasonAyacut(ComponentAyacut compObj , HttpServletRequest request,
			HttpSession session, SessionStatus status) {
		
		//System.out.println("i am in kal"+compObj);

		//List<ReservoirInspect> resInspect = new ArrayList<ReservoirInspect>();

		Integer projSeasonAyacutId=0;
		// List<PumpStations> pumpStationList= new ArrayList<PumpStations>();
		
		User user = (User) session.getAttribute("userObj");
		
		
		try {
			
			if (user!=null){
				
				compObj.setUserName(user.getUserName());
				compObj.setUnitId(user.getUnitId());
				compObj.setCircleId(user.getCircleId());
				
				compObj.setDivisionId(user.getDivisionId());
				compObj.setSubdivisionId(user.getSubdivisionId());
				
				
				
			}

			if (compObj.getProjectId() != null && compObj.getSeasonId() != null && compObj.getCropId()!=null && compObj.getProjectseasonId()!=null ) {

				if (compObj.getProjectId() > 0 && compObj.getSeasonId() > 0) {
					projSeasonAyacutId = cam.insertProjectSeasonAyacut(compObj);
				}

			}

			// System.out.println("resListbyId"+resListbyId);

		
		} catch (ComponentUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new Gson().toJson(projSeasonAyacutId);

	}
	
	
	
	
	@RequestMapping(value = "/comptsimis/view-proj-season-byproject")
	@ResponseBody
	public String viewProjSasonBproject(ComponentAyacut compObj , HttpServletRequest request,
			HttpSession session, SessionStatus status) {
		
		//System.out.println("i am in kal"+compObj);

		//List<ReservoirInspect> resInspect = new ArrayList<ReservoirInspect>();
		List<ComponentAyacut> compCapList = new ArrayList<ComponentAyacut>();
		
		Integer projSeasonAyacutId=0;
		// List<PumpStations> pumpStationList= new ArrayList<PumpStations>();
		
		User user = (User) session.getAttribute("userObj");

		 String vanadate=null;
		  String yasangidate=null;
		  
		  Integer f=0;
		  String k=null;
		  Integer d=0;
		  Integer c=0;
		  String m=null;
		
		
		try {
			
			if (user!=null){
				
				compObj.setUserName(user.getUserName());
				compObj.setUnitId(user.getUnitId());
				compObj.setCircleId(user.getCircleId());
				
				compObj.setDivisionId(user.getDivisionId());
				compObj.setSubdivisionId(user.getSubdivisionId());
				
				
				if(compObj!=null){
					
					Calendar cal = Calendar.getInstance();
					//System.out.println("i am in time"+new SimpleDateFormat("MMM").format(cal.getTime()));
					//Calendar.getInstance().get(Calendar.MONTH);
					
					//System.out.println("MONTH"+Calendar.getInstance().get(Calendar.MONTH));
					//System.out.println("Year"+Calendar.getInstance().get(Calendar.YEAR));
					
					Integer month=Calendar.getInstance().get(Calendar.MONTH);
					Integer year=Calendar.getInstance().get(Calendar.YEAR);
					Integer i=1;
				//month=10;
					  
					  if(month>9 && month<=12){
						  
							//System.out.println("month 9 and 12");
						  f=(year + i) ;
						  k=f.toString() ;
						  k=k.substring(2,4);		
						vanadate= year +"-"+ k;
						  }
					  
					  if((month>=0 && month<=9)){
						  
						//  System.out.println("month 0 and 9");
							 // alert("in 0 to 4");
							  f= year ;
							  k=f.toString() ;
							  k=k.substring(2,4);		
							  vanadate= (year-1) +"-"+ k;
							  }
					  if(month>=0 && month<=12){
						  
						 // System.out.println("month 0 and 12");
						  d= year;
						  c=year+i ;
						 m=c.toString();
						  m=m.substring(2,4);		
						  yasangidate= year +"-"+ m;
						  
						  } 
					
						
						if(month>=5 && month<=9){
							
							
							
							String actYear=yasangidate ;
							String actYear2=vanadate;
							
							
							
							     compObj.setKhrifactplanYear(actYear);
							     
							     compObj.setRabiactplanYear(actYear2);
						}
						
                      if((month>9 && month<=12) || (month>0 && month<=4) ){
							
							String actYear=yasangidate ;
							
							String actYear2=vanadate;
							
							compObj.setKhrifactplanYear(actYear);
							     
							compObj.setRabiactplanYear(actYear2);
						}
						
						
			
				
				
				}
				
				
				
				
				if(compObj.getProjectId()!=null){
				
				compCapList=cam.getProjSeasonCapInfo(compObj);
				}
				
			}

		
			// System.out.println("resListbyId"+resListbyId);

		
		} catch (ComponentUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new Gson().toJson(compCapList);

	}
	
	
	@RequestMapping(value = "/comptsimis/get-proj-season-byseasonId")
	@ResponseBody
	public String getProjSeasonBySeasonId(ComponentAyacut compObj , HttpServletRequest request,
			HttpSession session, SessionStatus status) {
		
		//System.out.println("i am in kal"+compObj);

		//List<ReservoirInspect> resInspect = new ArrayList<ReservoirInspect>();
		ComponentAyacut compCapList = new ComponentAyacut();
		
		Integer projSeasonAyacutId=0;
		// List<PumpStations> pumpStationList= new ArrayList<PumpStations>();
		
		User user = (User) session.getAttribute("userObj");
		
		
		try {
			
			if (user!=null){
				
				compObj.setUserName(user.getUserName());
				compObj.setUnitId(user.getUnitId());
				compObj.setCircleId(user.getCircleId());
				
				compObj.setDivisionId(user.getDivisionId());
				compObj.setSubdivisionId(user.getSubdivisionId());
				
				if(compObj.getProjectseasonId()!=null){
				
				compCapList=cam.getProjectSeasonCapEdit(compObj);
				
				}
				
			}

		
			// System.out.println("resListbyId"+resListbyId);

		
		} catch (ComponentUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new Gson().toJson(compCapList);

	}
	
	@RequestMapping(value = "/comptsimis/update-proj-season-byseasonId")
	@ResponseBody
	public String updateProjSeasonByseasonId(ComponentAyacut compObj , HttpServletRequest request,
			HttpSession session, SessionStatus status) {
		
		//System.out.println("i am in kal"+compObj);

		//List<ReservoirInspect> resInspect = new ArrayList<ReservoirInspect>();
		
		
		Integer updatedrows=0;
		
		Integer projSeasonAyacutId=0;
		// List<PumpStations> pumpStationList= new ArrayList<PumpStations>();
		
		User user = (User) session.getAttribute("userObj");
		
		
		try {
			
			if (user!=null){
				
				compObj.setUserName(user.getUserName());
				compObj.setUnitId(user.getUnitId());
				compObj.setCircleId(user.getCircleId());
				
				compObj.setDivisionId(user.getDivisionId());
				compObj.setSubdivisionId(user.getSubdivisionId());
				
				if(compObj.getProjectseasonId()!=null){
				
					updatedrows=cam.UpdateProjSeasonCapacity(compObj) ;
				
				}
				
			}

		
			// System.out.println("resListbyId"+resListbyId);

		
		} catch (ComponentUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new Gson().toJson(updatedrows);

	}
	
	@RequestMapping(value = "/comptsimis/delete-proj-season-byseasonId")
	@ResponseBody
	public String deleteProjSeasonByseasonId(ComponentAyacut compObj , HttpServletRequest request,
			HttpSession session, SessionStatus status) {
		
		//System.out.println("i am in kal"+compObj);

		//List<ReservoirInspect> resInspect = new ArrayList<ReservoirInspect>();
		
		
		Integer updatedrows=0;
		
		Integer projSeasonAyacutId=0;
		// List<PumpStations> pumpStationList= new ArrayList<PumpStations>();
		
		User user = (User) session.getAttribute("userObj");
		
		
		try {
			
			if (user!=null){
				
				compObj.setUserName(user.getUserName());
				compObj.setUnitId(user.getUnitId());
				compObj.setCircleId(user.getCircleId());
				
				compObj.setDivisionId(user.getDivisionId());
				compObj.setSubdivisionId(user.getSubdivisionId());
				
				if(compObj.getProjectseasonId()!=null){
				
					updatedrows=cam.DeleteProjectSeasonCapacity(compObj);
				
				}
				
			}

		
			// System.out.println("resListbyId"+resListbyId);

		
		} catch (ComponentUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new Gson().toJson(updatedrows);

	}
	
	@RequestMapping(value = "/comptsimis/view-proj-sea-ayacut-bypayacut")
	@ResponseBody
	public String viewProjSeaAyacutBypayacut(ComponentAyacut compObj , HttpServletRequest request,
			HttpSession session, SessionStatus status) {
		
		//System.out.println("i am in kal"+compObj);

		//List<ReservoirInspect> resInspect = new ArrayList<ReservoirInspect>();
		List<ComponentAyacut> compCapList = new ArrayList<ComponentAyacut>();
		
		Integer projSeasonAyacutId=0;
		// List<PumpStations> pumpStationList= new ArrayList<PumpStations>();
		
		User user = (User) session.getAttribute("userObj");
		
		
		try {
			
			if (user!=null){
				
				compObj.setUserName(user.getUserName());
				compObj.setUnitId(user.getUnitId());
				compObj.setCircleId(user.getCircleId());
				
				compObj.setDivisionId(user.getDivisionId());
				compObj.setSubdivisionId(user.getSubdivisionId());
				
				if(compObj.getProjAyacutId()!=null && compObj.getProjectseasonId()!=null){
				
				compCapList=cam.getProjSeasonAyacutInfo(compObj);
				}
				
			}

		
			// System.out.println("resListbyId"+resListbyId);

		
		} catch (ComponentUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new Gson().toJson(compCapList);

	}
	
	
	
	@RequestMapping(value = "/comptsimis/get-proj-crop-byayacutId")
	@ResponseBody
	public String getProjCropByAyacutId(ComponentAyacut compObj , HttpServletRequest request,
			HttpSession session, SessionStatus status) {
		
		//System.out.println("i am in kal"+compObj);

		//List<ReservoirInspect> resInspect = new ArrayList<ReservoirInspect>();
		ComponentAyacut compCapList = new ComponentAyacut();
		
		Integer projSeasonAyacutId=0;
		// List<PumpStations> pumpStationList= new ArrayList<PumpStations>();
		
		User user = (User) session.getAttribute("userObj");
		
		
		try {
			
			if (user!=null){
				
				compObj.setUserName(user.getUserName());
				compObj.setUnitId(user.getUnitId());
				compObj.setCircleId(user.getCircleId());
				
				compObj.setDivisionId(user.getDivisionId());
				compObj.setSubdivisionId(user.getSubdivisionId());
				
				if(compObj.getProjSeasonAyacutId()!=null){
				
				compCapList=cam.getProjectSeasonAyacutEdit(compObj);
				
				}
				
			}

		
			// System.out.println("resListbyId"+resListbyId);

		
		} catch (ComponentUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new Gson().toJson(compCapList);

	}
	
	@RequestMapping(value = "/comptsimis/update-proj-crop-byayacutId")
	@ResponseBody
	public String updateProjCropByAyacutId(ComponentAyacut compObj , HttpServletRequest request,
			HttpSession session, SessionStatus status) {
		
		//System.out.println("i am in kal"+compObj);

		//List<ReservoirInspect> resInspect = new ArrayList<ReservoirInspect>();
		
		
		Integer updatedrows=0;
		
		Integer projSeasonAyacutId=0;
		// List<PumpStations> pumpStationList= new ArrayList<PumpStations>();
		
		User user = (User) session.getAttribute("userObj");
		
		
		try {
			
			if (user!=null){
				
				compObj.setUserName(user.getUserName());
				compObj.setUnitId(user.getUnitId());
				compObj.setCircleId(user.getCircleId());
				
				compObj.setDivisionId(user.getDivisionId());
				compObj.setSubdivisionId(user.getSubdivisionId());
				
				if(compObj.getProjSeasonAyacutId()!=null){
					//System.out.println("compObj.getProjSeasonAyacutId()"+compObj.getProjSeasonAyacutId());
				
					updatedrows=cam.UpdateProjectSeasonAyacut(compObj);
				
				}
				
			}

		
			// System.out.println("resListbyId"+resListbyId);

		
		} catch (ComponentUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new Gson().toJson(updatedrows);

	}
	
	@RequestMapping(value = "/comptsimis/delete-proj-crop-byayacutId")
	@ResponseBody
	public String deleteProjCropByAyacutId(ComponentAyacut compObj , HttpServletRequest request,
			HttpSession session, SessionStatus status) {
		
		//System.out.println("i am in kal"+compObj);

		//List<ReservoirInspect> resInspect = new ArrayList<ReservoirInspect>();
		
		
		Integer updatedrows=0;
		
		Integer projSeasonAyacutId=0;
		// List<PumpStations> pumpStationList= new ArrayList<PumpStations>();
		
		User user = (User) session.getAttribute("userObj");
		
		
		try {
			
			if (user!=null){
				
				compObj.setUserName(user.getUserName());
				compObj.setUnitId(user.getUnitId());
				compObj.setCircleId(user.getCircleId());
				
				compObj.setDivisionId(user.getDivisionId());
				compObj.setSubdivisionId(user.getSubdivisionId());
				
				if(compObj.getProjSeasonAyacutId()!=null){
					
					//System.out.println("compObj.getProjSeasonAyacutId()"+compObj.getProjSeasonAyacutId());
				
					updatedrows=cam.DeleteProjectSeasonAyacut(compObj);
				
				}
				
			}

		
			// System.out.println("resListbyId"+resListbyId);

		
		} catch (ComponentUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new Gson().toJson(updatedrows);

	}
	
	@RequestMapping(value = "/comptsimis/update-jurisdiction")
	@ResponseBody
	public String updateJurisdictionAyacut(ComponentAyacut compObj , HttpServletRequest request,
			HttpSession session, SessionStatus status) {
		
		//System.out.println("i am in kal"+compObj);

		//List<ReservoirInspect> resInspect = new ArrayList<ReservoirInspect>();
		
		ComponentAyacut projAyacutObj= new ComponentAyacut();
		
		Integer updatedrows=0;
		
		Integer deleteOutput=0;
		
		Integer projSeasonAyacutId=0;
		// List<PumpStations> pumpStationList= new ArrayList<PumpStations>();
		
		User user = (User) session.getAttribute("userObj");
		
		
		try {
			
			if (user!=null){
				
				compObj.setUserName(user.getUserName());
				
				
				
				//System.out.println("compObj.getProjAyacutId()"+compObj.getProjAyacutId());
				//System.out.println("compObj.getUnitId()"+compObj.getUnitId());
				//System.out.println("compObj.getCircleId("+compObj.getCircleId());
				//System.out.println("compObj.getDivisionId("+compObj.getDivisionId());
				
				//step1
				//get ayacut data based on ayacutid
				if(compObj.getProjAyacutId()!=null){
				projAyacutObj = cam.geteditProjectAyacutInfo(compObj.getProjAyacutId());
				
				}
				//if data not null then delete record
				if(projAyacutObj!=null){
				
					
					
					deleteOutput = cam.deleteProjectAyacut(compObj.getProjAyacutId(),compObj.getUserName());
					
					//System.out.println("deleteOutput"+deleteOutput);
				}
				
				
				//if record deleted then insert new record with changed unitId
				
				if(deleteOutput!=null){
					
					if(deleteOutput>0){
						
						projAyacutObj.setUserName(compObj.getUserName());
						projAyacutObj.setCircleId(compObj.getCircleId());
						projAyacutObj.setDivisionId(compObj.getDivisionId());
						projAyacutObj.setSubdivisionId(0);
						projAyacutObj.setEditFlag(true);
						
						projAyacutObj.setOldProjAyacutId(compObj.getProjAyacutId());
						
						projAyacutObj.setJursFlag(true);
						
						
						
						
						updatedrows = cam.insertprojAyacut(projAyacutObj);
						
						//System.out.println("updatedrows"+updatedrows);
						
					}
					
					
				}
				
				
				
			}

		
			// System.out.println("resListbyId"+resListbyId);

		
		} catch (ComponentUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new Gson().toJson(updatedrows);

	}
	
	
	@RequestMapping(value = "/comptsimis/cadkmlinput")
	public ModelAndView cadkmlinput(@ModelAttribute("compayacutinput") ComponentAyacut compAyacutObj,
			SessionStatus status, HttpSession session, HttpServletRequest req, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("cad-kml-input");

		List<Project> projectList = new ArrayList<Project>();
		List<ReservoirSalient>  reservoirList = new ArrayList<ReservoirSalient>();
			List<ReservoirSalient>  nrldreservoirList = new ArrayList<ReservoirSalient>();
			
			List<Unit> unitList = new ArrayList<Unit>();
			
			List<CadAyacutKmlDocs> cadkmlList = new ArrayList<CadAyacutKmlDocs>();
			
			
			
			User user = (User) session.getAttribute("userObj");
			
			
			 try {
				 
				 if(user!=null){
				 projectList = lam.getProjectListadmin(user.getUnitId());
			       reservoirList = invam.getInvomResListAdmin(user.getUnitId());
			       
			       unitList = tam.getUnitList();
			       
			     
			       
			       compAyacutObj.setUnitId(user.getUnitId());
			       
			      // System.out.println("compAyacutObj"+compAyacutObj.getUnitId());
			       
			       cadkmlList=cam.getCadAyacutkmlbyUnitInfo(compAyacutObj);
			       
			       //System.out.println("cadkmlList"+cadkmlList);
			       
			       
			       mav.addObject("cadkmlList",cadkmlList);
				 
				 mav.addObject("projectList",projectList);
				 mav.addObject("reservoirList",reservoirList);
				 
				 mav.addObject("unitList",unitList);
				 }

		} catch (TaskUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (LeagalUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InventoryUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ComponentUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	
		//mav.addObject("selectedolddistId", selectedolddistId);

		// System.out.println("session.getMaxInactiveInterval()"+session.getMaxInactiveInterval());

		// System.out.println("coming here 1"+status.isComplete());

		/*
		 * if(status.isComplete()){
		 * 
		 * //mav.setViewName("home"); session.invalidate();
		 * status.setComplete();
		 * 
		 * System.out.println("coming here 2"+status.isComplete()); return new
		 * ModelAndView("leagal/home");
		 * 
		 * 
		 * 
		 * }
		 */

		// System.out.println("coming here 3"+status.isComplete());
		return mav;

	}
	
	private static final String RELATIVE_DIR = "/uploadedFiles/Ayacutkmls/";

	
	
	@RequestMapping(value = "/comptsimis/updatekmlFiles")
	@ResponseBody
	public String  updatephotos(@ModelAttribute("compkmlayacut") ComponentAyacut compObj, HttpServletRequest request,
			HttpSession session, SessionStatus status) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("cad-kml-input");
		
		//System.out.println("compObj"+compObj);
		
	Integer output=0;
		
		String[] saveFileName = null;

		List<String> fileNameList = new ArrayList<String>();
		
		
		List<MiTankformData> MiformdaoimplObj = new ArrayList<MiTankformData>();

		
		ComponentAyacut compnewObj= new ComponentAyacut();
		
		List<CadAyacutKmlDocs> docList = new ArrayList<CadAyacutKmlDocs>();
		Boolean captOutput = false;
		
	
try{
	
	User user = (User) session.getAttribute("userObj");		
		

	if (compObj!= null) {
		if (user != null) {
			
			if (user.getUserName() != null) {
				
				// System.out.println("user.getUserId()"+user.getUserEmpId()+"user.getUserName()"+user.getUserName());
			

				compObj.setUserName(user.getUserName());
				compObj.setUnitId(user.getUnitId());
				compObj.setCircleId(user.getCircleId());
				compObj.setDivisionId(user.getDivisionId());
				compObj.setSubdivisionId(user.getSubdivisionId());
				compObj.setPostId(user.getPost());

			}
		
			//System.out.println("compObj2"+compObj);
			
	if(compObj.getProjectId()!=null){
		
		
		if(compObj.getProjectId()>0){
			
			//System.out.println("compObj3"+compObj);
			
	if(compObj.getCadkmldocs().get(0).getKmlfiles()!=null){
		
		
		if(compObj.getCadkmldocs().get(0).getKmlfiles().size()>0){
			
			
			//System.out.println("compObj4"+compObj.getCadkmldocs().get(0).getKmlfiles());
			
			//System.out.println("coming here"+miFormObj.getMiTankformDataList().get(0).getUploadPhotos().size());
		
			
			List<MultipartFile> files = compObj.getCadkmldocs().get(0).getKmlfiles();
			List<String> fileNames = new ArrayList<String>();
			
			List<CadAyacutKmlDocs> fileList = new ArrayList<CadAyacutKmlDocs>();
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
					
							maxId = cam.getCountOfCadAyacutKmlDocs() + 1;
						
						// System.out.println("maxId"+maxId);
						 
						 Integer  doccnt=maxId;

						String[] temps = filetitile.split(Pattern.quote("."));

						String dataIdNum = compObj.getProjectName();
						
						doccnt=doccnt+i;
						
						// System.out.println("doccnt"+doccnt);

						String docName = temps[0];
						String SaveName = dataIdNum + doccnt.toString() + docName + "."
								+ temps[temps.length - 1];

					
						fileNameList.add(SaveName);

						

					}
				}
				
			      String absolutePath = servletContext.getRealPath(RELATIVE_DIR);
			        System.out.println("Saving files to: " + absolutePath);
				
				String rootPath = System.getProperty("catalina.base");
				
				//live
				
				//File dir = new File(File.separator + "Uploads" + File.separator + "tsimis" + File.separator + "uploadedFiles"
				//+ File.separator + "AyacutKmls");
				
				  File dir = new File(absolutePath);
				
				//File dir = new File(rootPath + File.separator + "webapps" + File.separator + "tsimis" + File.separator + "uploadedFiles"
						//+ File.separator + "AyacutKmls");
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

							String kmlDocName = fileNameList.get(i);
							CadAyacutKmlDocs tf = new CadAyacutKmlDocs();

							tf.setDocName(kmlDocName);
							tf.setDocOriginalName(files.get(i).getOriginalFilename());
							tf.setDocLocation(
									dir.getAbsolutePath() + File.separator + kmlDocName);

							// System.out.println("serverFile"+frmDocName);
							fileList.add(tf);

						   //   String targetPath=dir.getAbsolutePath()+ File.separator + frmDocName ;
								
						      
						     // int scaledWidth = 1024;
					        //    int scaledHeight = 768;
					         //   MultipartFile newFile=files.get(i);
					         //   ResizeImage.resize(newFile, targetPath, scaledWidth, scaledHeight);
						      files.get(i).transferTo( new File(dir.getAbsolutePath() + File.separator + kmlDocName));
							

						}

					}
				}
				
				if (fileList.size() > 0) {
					
				//	System.out.println("fileList"+fileList);
					compObj.setCadkmldocs(fileList);
					

				}
				
				output = cam.insertCadAyacutKmlDocuments(compObj);
				
				//System.out.println("output"+output);

				
			}
			
		}
	}
				
			
			
		
	}
	}
	
	}
	}
	


		}catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ComponentUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
			
		
	      //end of photos
	
return new Gson().toJson(output);
			}

	@RequestMapping(value = "/comptsimis/cad-kml-docs")
	@ResponseBody
	public String deletekmldocs(CadAyacutKmlDocs cadobj, HttpServletRequest request, HttpSession session,
			SessionStatus status) {

	
		CadAyacutKmlDocs caddocs = new CadAyacutKmlDocs();

		// List<PumpStations> pumpStationList= new ArrayList<PumpStations>();
		
		 //System.out.println("kalPostId"+postId);
		 //System.out.println("mst1Id"+mst1Id);
		
	
		Integer dataoutput=0;
	
		User user = (User) session.getAttribute("userObj");

		try {
			
			if (user != null) {
				
				if ( user.getUserName() != null) {
					
				

					cadobj.setUserName(user.getUserName());
				}

			if (cadobj.getCadkmlId() != null  ) {

				if (cadobj.getCadkmlId() >0  ) {
					
					
					
					//System.out.println("formdocId"+formdocId);
					dataoutput = cam.deleteCADKMLbyId(cadobj);
					
					
				};

			}

			}
		}  catch (ComponentUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new Gson().toJson(dataoutput);

	}
	
	

}
