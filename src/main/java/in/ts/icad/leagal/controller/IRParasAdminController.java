package in.ts.icad.leagal.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.regex.Pattern;

import javax.mail.Session;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.xml.bind.ParseConversionEvent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;

import in.ts.icad.leagal.exception.IRParasUserException;
import in.ts.icad.leagal.exception.LeagalUserException;
import in.ts.icad.leagal.exception.TaskUserException;
import in.ts.icad.leagal.manager.IRParasAdminManager;
import in.ts.icad.leagal.manager.IRParasReportManager;
import in.ts.icad.leagal.manager.TaskAdminManager;
import in.ts.icad.leagal.model.CAGParas;
import in.ts.icad.leagal.model.CAGParasData;
import in.ts.icad.leagal.model.Circle;
import in.ts.icad.leagal.model.Division;
import in.ts.icad.leagal.model.MiTankInspect;
import in.ts.icad.leagal.model.ParaDocuments;
import in.ts.icad.leagal.model.Paras;
import in.ts.icad.leagal.model.Project;
import in.ts.icad.leagal.model.ReplyData;
import in.ts.icad.leagal.model.TaskFiles;
import in.ts.icad.leagal.model.Unit;
import in.ts.icad.leagal.model.User;
import in.ts.icad.leagal.model.officeDataSend;
import in.ts.icad.leagal.util.EmailConfig;

@Controller
public class IRParasAdminController {

	@Autowired
	private TaskAdminManager tam;

	@Autowired
	private IRParasAdminManager iram;

	@Autowired
	private IRParasReportManager irrm;
	
	@Autowired
	private ServletContext servletContext;

	@RequestMapping(value = "/parastsimis/resultofliveDB")
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
			count = iram.generalqueryforresult(Query);
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
		mav.setViewName("updateirparasDB");

		mav.addObject("resultset", count);
		mav.addObject("message", message);
		return mav;

	}

	@RequestMapping(value = "/parastsimis/liveirparasDB")
	public ModelAndView editData() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("updateirparasDB");
		return mav;

	}
	
	@RequestMapping(value = "/parastsimis/irparas-menu-home")
	public ModelAndView leftMenuHome() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("irparas-menu-home");
		return mav;

	}

	@RequestMapping(value = "/parastsimis/parasinput")
	public ModelAndView irparasinput(@ModelAttribute("irparas") Paras paraObj, SessionStatus status,
			HttpSession session) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("parasinput");
		return mav;

	}
	
	
	private static final String RELATIVE_DIR = "/uploadedFiles/IRParas/";

	@RequestMapping(value = "/parastsimis/addPara")
	public ModelAndView AddPara(@ModelAttribute("irparas") Paras paraObj, SessionStatus status, HttpSession session) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("addPara");
		List<Unit> unitList = new ArrayList<Unit>();

		Integer paraOutput = 0;
		Integer replyoutput = 0;
		Integer paraDocOutput = 0;
		Integer paraTroutput = 0;

		String[] saveFileName = null;

		List<String> fileNameList = new ArrayList<String>();
		
		Integer subparaoutput=0;

		try {
			unitList = tam.getUnitList();

			// System.out.println("addPara"+unitList);

			User user = (User) session.getAttribute("userObj");

			if (paraObj != null && paraObj.getUnitId() != null && paraObj.getParaStatusId() != null) {

				if (user != null) {
					paraObj.setUserId(user.getUserId());

					paraObj.setUserName(user.getUserName());

				}

				// System.out.println("paraOutputsize"+paraOutput+paraObj.getParaDataList().size());
				if (paraObj.getParaDataList() != null) {
					if (paraObj.getParaDataList().size() > 0) {
						// insert parasa when status is not in trasfer
						//if (paraObj.getTransferFlag() == false) {
							paraOutput = iram.insertParas(paraObj);

						//}
						// insert paras in transfer mode
						/*if (paraObj.getTransferFlag() == true) {
							paraTroutput = iram.insertParasTransfer(paraObj);

							if (paraTroutput != null) {

								if (paraTroutput > 0) {

									paraObj.setUnitId(paraObj.getTunitId());
									paraObj.setCircleId(paraObj.getTcircleId());
									paraObj.setDivisionId(paraObj.getTdivisionId());
									paraObj.setSubdivisionId(paraObj.getTsubdivisionId());
									paraObj.setTunitId(0);
									paraObj.setTcircleId(0);
									paraObj.setTdivisionId(0);
									paraObj.setTsubdivisionId(0);

									if (paraObj.getUnitId() != null) {

										if (paraObj.getUnitId() > 0 && paraObj.getTunitId() == 0) {

											paraOutput = iram.insertParas(paraObj);

										}
									}
								}
							}

						}*/

					}
				}

				// System.out.println("paraOutput"+paraOutput);

				if (paraOutput != null) {

					if (paraOutput > 0) {

						paraObj.setParaId(paraOutput);
						
						
						if (paraObj != null) {
							if (paraObj.getParaId() > 0) {

								// System.out.println("cominghere"+replyoutput);
								subparaoutput = iram.insertParaMasterSub(paraObj);

							}
						}
                        
						if(subparaoutput>0){
							
							paraObj.setSubParaId(subparaoutput);
						}
						

						if (paraObj.getReplyDataList() != null) {
							if (paraObj.getReplyDataList().size() > 0) {

								// System.out.println("cominghere"+replyoutput);
								replyoutput = iram.insertParasReply(paraObj);

							}
						}

						// System.out.println("paraObj.getUploadFile()"+paraObj.getUploadFile().size());

						if (paraObj.getUploadFile() != null) {

							if (paraObj.getUploadFile().size() >= 1) {

								List<MultipartFile> files = paraObj.getUploadFile();

								List<String> fileNames = new ArrayList<String>();

								List<ParaDocuments> fileList = new ArrayList<ParaDocuments>();

								String filetitile = null;
								String filetitilenew = null;
								// System.out.println("filesize"+files.size()+"--"+files);
								if (null != files && files.size() >= 1) {
									for (MultipartFile multipartFile : files) {

										String fileName = multipartFile.getOriginalFilename();
										// String FileType = (
										// files).get(0).getContentType();
										fileNames.add(fileName);
										// Handle file content -
										// multipartFile.getInputStream()

									}

									// System.out.println("2nd file
									// size"+fileNames.size());

									for (int i = 0; i < fileNames.size(); i++) {
										filetitile = fileNames.get(i);

										// System.out.println("filetitile"+filetitile);

										if (!filetitile.isEmpty()) {
											Integer maxId = iram.getCountOfParaDocs() + 1;
											// System.out.println("maxId"+maxId);

											String[] temps = filetitile.split(Pattern.quote("."));

											Integer paraNum = paraObj.getParaId();

											String docName = temps[0];
											String SaveName = paraNum.toString() + maxId.toString() + docName + "."
													+ temps[temps.length - 1];

											maxId++;
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

									// System.out.println("filetitilenew"+filetitilenew);
								//	String rootPath = System.getProperty("catalina.base");
									// local
									// File dir = new File(rootPath +
									// File.separator + "webapps" +
									// File.separator + "ICADLeagalWebApp" +
									// File.separator +
									// "uploadedFiles"+File.separator+"IRParas");
									// server
									 
									 if (absolutePath == null) {
										    // fallback if getRealPath returns null (some servlet containers do this)
										    absolutePath = new File(".").getCanonicalPath() + RELATIVE_DIR;
										}

									//02122025
									//File dir = new File( File.separator + "Uploads" +File.separator + "tsimis" + File.separator + "uploadedFiles"
											//+ File.separator + "IRParas");
									 
									  File dir = new File(absolutePath);
									
									//File dir = new File(rootPath + File.separator + "webapps" +File.separator + "tsimis" + File.separator + "uploadedFiles"
										//	+ File.separator + "IRParas");

									/*File dir = new File(rootPath + File.separator + "webapps" + File.separator
											+ "ICadWebApp" + File.separator + "knr" + File.separator + "uploadedFiles"
											+ File.separator + "IRParas");*/
									if (!dir.exists())
										dir.mkdirs();

									paraObj.setFileLocation(dir.getAbsolutePath());

									for (int i = 0; i < files.size(); i++) {

										// File serverFile = new
										// File(dir.getAbsolutePath()+
										// File.separator +
										// files.get(i).getOriginalFilename());
										if (!fileNameList.isEmpty()) {

											if (fileNameList.size() > 0) {

												String paraDocName = fileNameList.get(i);
												ParaDocuments tf = new ParaDocuments();

												tf.setParaDocName(paraDocName);
												tf.setParaDocOriginalName(files.get(i).getOriginalFilename());
												tf.setParaDocLocation(
														dir.getAbsolutePath() + File.separator + paraDocName);

												// System.out.println("serverFile"+paraDocName);
												fileList.add(tf);

												files.get(i).transferTo(
														new File(dir.getAbsolutePath() + File.separator + paraDocName));

											}

										}
									}

									if (fileList.size() > 0) {
										paraObj.setParadocList(fileList);
										;

									}

									paraDocOutput = iram.insertParasDocuments(paraObj);

								}

							}
						}

					}

					if (paraOutput > 0) {

						mav.addObject("msg", "Successfully updated");

					} else {

						mav.addObject("err", "Failed to add Para");

					}

				}
			}

		} catch (TaskUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IRParasUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		mav.addObject("unitList", unitList);

		return mav;

	}

	@RequestMapping(value = "/parastsimis/deleteirparas")
	public ModelAndView deleteirparas(@ModelAttribute("deleteparas") Paras paraObj, SessionStatus status,
			HttpSession session) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("deleteirparas");

		List<Unit> unitList = new ArrayList<Unit>();
		List<Circle> circleList = new ArrayList<Circle>();
		List<Division> divisionList = new ArrayList<Division>();
		List<Paras> paraListTotalByUnit = new ArrayList<Paras>();
		List<ReplyData> replyListDB = new ArrayList<ReplyData>();
		List<ReplyData> replyListTotal = new ArrayList<ReplyData>();

	

		List<ParaDocuments> paradocsList = new ArrayList<ParaDocuments>();

		Integer output = 0;
		User	user = (User) session.getAttribute("userObj");
		
		// System.out.println(user);
		try {
			unitList = tam.getunitpostList();
			circleList = tam.getcirclepostList();
			divisionList = tam.getdivisionpostList();

		
			replyListDB = irrm.getReplyAll();
			if ( user.getUserName() != null) {
				if (replyListDB != null) {

					int len = replyListDB.size();

					if (len > 0) {

						for (int i = 0; i < len; i++) {

							ReplyData rd = new ReplyData();

							String str = replyListDB.get(i).getReplyAction();
							str.replaceAll("\\s+", " ");

							str.replaceAll("<p style=text-align:justify> </p>]+", " ");

							rd.setParaId(replyListDB.get(i).getParaId());
							rd.setParaReplyId(replyListDB.get(i).getParaReplyId());
							rd.setReplyAction(str);
							rd.setReplyRemarks(replyListDB.get(i).getReplyRemarks());

							replyListTotal.add(rd);

						}
					}
				}

				paradocsList = irrm.getDocsAll();

				if (paraObj.getUnitId() != null && paraObj.getDeleteFlag() == false) {

					if (paraObj.getUnitId() > 0) {

						// System.out.println(paraObj.getUnitTotal());
						// System.out.println(paraObj.getCircleId());
						//System.out.println(paraObj.getCircleId());

						paraListTotalByUnit = iram.getParasAbstractByUnit(paraObj.getUnitId(), paraObj.getCircleId(),
								paraObj.getDivisionId());

						// System.out.println("paraListTotalByUnit"+paraListTotalByUnit);

					}

				}

				if (paraObj.getParaId() != null && paraObj.getDeleteFlag() == true) {

					output = iram.deleteParasReplyDocs(paraObj.getParaId(), user.getUserId(), user.getUserName());

					if (output > 0) {

						mav.addObject("msg", "Successfully deleted para");

					}

					if (output == 0) {

						mav.addObject("err", "Failed to delete para");

					}

				}

			}

		} catch (TaskUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IRParasUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		 //System.out.println("paraListTotalByUnit"+paraListTotalByUnit);
		mav.addObject("unitList", unitList);
		mav.addObject("circleList", circleList);
		mav.addObject("divisionList", divisionList);

		mav.addObject("parasList", paraListTotalByUnit);

		mav.addObject("replyListTotal", replyListTotal);

		mav.addObject("paradocsList", paradocsList);
		mav.addObject("user", user);

		return mav;

	}

	@RequestMapping(value = "/parastsimis/editirparas")
	public ModelAndView editIrparas(@ModelAttribute("irparas") Paras paraObj, SessionStatus status,
			HttpSession session) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("editparas");
		List<Unit> unitList = new ArrayList<Unit>();
		Integer paraOutput = 0;
		Integer paraTroutput = 0;

		Integer replyoutput = 0;
		Integer paraDocOutput = 0;

		List<ParaDocuments> doclist = new ArrayList<ParaDocuments>();
		List<ParaDocuments> doclist2 = new ArrayList<ParaDocuments>();

		List<String> fileNameList = new ArrayList<String>();

		List<ReplyData> replyList = new ArrayList<ReplyData>();
		List<ReplyData> replyList2 = new ArrayList<ReplyData>();

		Paras paraDBObj = new Paras();
		
		Paras paraDBObj2 = new Paras();
		
		List<Paras> paraDBSUbObj = new ArrayList<Paras>();
		List<Paras> paraDBSUbObj2 = new ArrayList<Paras>();
		
		Integer paraSubOutput=0;
		
		Integer subparaoutput=0;
		try {
			unitList = tam.getUnitList();

			if (paraObj.getParaId() != null && paraObj.getEditFlag() == false) {

				if (paraObj.getParaId() > 0) {

					paraDBObj = iram.getParaforedit(paraObj.getParaId());
					
					paraDBSUbObj=iram.getSubParaforedit(paraObj.getParaId());

					// System.out.println("sectionId"+paraDBObj.getSectionId());

					mav.addObject("paraDBObj", paraDBObj);

					doclist = irrm.getDocsByParaId(paraObj.getParaId());

					mav.addObject("doclist", doclist);

					replyList = irrm.getReplybyParaId(paraObj.getParaId());

					mav.addObject("replyList", replyList);

				}
			}

			// System.out.println("editPara"+paraObj.getEditFlag());

			User user = (User) session.getAttribute("userObj");

			if (paraObj != null && paraObj.getUnitId() != null && paraObj.getParaStatusId() != null
					&& paraObj.getParaId() != null && paraObj.getEditFlag() == true) {

				if (user != null) {
					paraObj.setUserId(user.getUserId());

					paraObj.setUserName(user.getUserName());

				}

				// System.out.println("paraOutputsize"+paraOutput+paraObj.getParaDataList().size());
				if (paraObj.getParaDataList() != null) {
					if (paraObj.getParaDataList().size() > 0 && paraObj.getParaId() > 0) {
						// insert parasa when status is not in trasfer
						if (paraObj.getTransferFlag() == false) {

							paraOutput = iram.editParas(paraObj);

							if (paraOutput > 0) {

								mav.addObject("msg", "Successfully updated para");

							}

							if (paraOutput == 0) {

								mav.addObject("err", "Failed to update Para");

							}
							
							
							
							if(paraDBSUbObj!=null){
								
								for(int i=0; i<paraDBSUbObj.size();i++){
								
								if(paraDBSUbObj.get(i).getParaId()==paraObj.getParaId()){
									
									paraObj.setSubParaId(paraDBSUbObj.get(i).getSubParaId());                                                                                                                                       
							
							paraSubOutput = iram.editSubParas(paraObj);
							
								}
								
								}
							
							}

						
						// insert paras in transfer mode
						
							
				// System.out.println("paraOutput"+paraOutput);

				if (paraObj.getReplyDataList() != null) {
					if (paraObj.getReplyDataList().size() > 0) {

						// System.out.println("paraOutput"+paraObj.getReplyDataList().size()+"--"+paraObj.getReplyDataList().get(0).getParaReplyId());
						replyoutput = iram.editmultipleParasReply(paraObj);

						if (replyoutput > 0) {
							mav.addObject("msg", "Successfully updated Replys");

						}

						if (replyoutput == 0) {

							mav.addObject("err", "Failed to update replys");

						}

					}
				}

				if (paraObj.getUploadFile() != null) {

					// System.out.println("filesize"+paraObj.getUploadFile().size());

					if (paraObj.getUploadFile().size() >= 1) {

						List<MultipartFile> files = paraObj.getUploadFile();

						List<String> fileNames = new ArrayList<String>();

						List<ParaDocuments> fileList = new ArrayList<ParaDocuments>();

						String filetitile = null;
						String filetitilenew = null;

						if (null != files && files.size() >= 1) {
							for (MultipartFile multipartFile : files) {

								String fileName = multipartFile.getOriginalFilename();
								// String FileType = (
								// files).get(0).getContentType();
								fileNames.add(fileName);
								// Handle file content -
								// multipartFile.getInputStream()

							}

							// System.out.println("2nd file
							// size"+fileNames.size());

							for (int i = 0; i < fileNames.size(); i++) {
								filetitile = fileNames.get(i);
								if (!filetitile.isEmpty()) {
									Integer maxId = iram.getCountOfParaDocs() + 1;

									Integer paraNum = paraObj.getParaId();

									String[] temps = filetitile.split(Pattern.quote("."));
									String docName = temps[0];
									String SaveName = paraNum.toString() + maxId.toString() + docName + "."
											+ temps[temps.length - 1];

									maxId++;
									fileNameList.add(SaveName);

									// System.out.println("saveFileName"+SaveName);

									/*
									 * if (i==0){ filetitilenew=filetitile; }
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
							  
							  if (absolutePath == null) {
								    // fallback if getRealPath returns null (some servlet containers do this)
								    absolutePath = new File(".").getCanonicalPath() + RELATIVE_DIR;
								}


							// System.out.println("filetitilenew"+filetitilenew);
							//String rootPath = System.getProperty("catalina.base");
							// local
							// File dir = new File(rootPath + File.separator +
							// "webapps" + File.separator + "ICADLeagalWebApp" +
							// File.separator +
							// "uploadedFiles"+File.separator+"IRParas");

							// server
							
							//File dir = new File(rootPath + File.separator + "Uploads" + File.separator +  "tsimis" + File.separator + "uploadedFiles" + File.separator
									//+ "IRParas");
							//File dir = new File(rootPath + File.separator + "webapps" + File.separator +  "tsimis" + File.separator + "uploadedFiles" + File.separator
									//+ "IRParas");
							
							/*File dir = new File(rootPath + File.separator + "webapps" + File.separator + "ICadWebApp"
									+ File.separator + "knr" + File.separator + "uploadedFiles" + File.separator
									+ "IRParas");*/
							  
							  File dir = new File(absolutePath);
								

							if (!dir.exists())
								dir.mkdirs();

							paraObj.setFileLocation(dir.getAbsolutePath());

							for (int i = 0; i < files.size(); i++) {

								// File serverFile = new
								// File(dir.getAbsolutePath()+ File.separator +
								// files.get(i).getOriginalFilename());

								if (!fileNameList.isEmpty()) {
									ParaDocuments tf = new ParaDocuments();

									String paraDocName = fileNameList.get(i);

									tf.setParaDocName(paraDocName);
									tf.setParaDocOriginalName(files.get(i).getOriginalFilename());
									tf.setParaDocLocation(dir.getAbsolutePath() + File.separator + paraDocName);
									paraObj.setUserId(user.getUserId());

									paraObj.setUserName(user.getUserName());

									// System.out.println("serverFile"+paraDocName);

									fileList.add(tf);

									files.get(i)
											.transferTo(new File(dir.getAbsolutePath() + File.separator + paraDocName));
								}
							}

							if (fileList.size() > 0) {
								paraObj.setParadocList(fileList);
								;

							}

							paraDocOutput = iram.insertParasDocuments(paraObj);

							if (paraDocOutput > 0) {
								mav.addObject("msg", "Successfully updated Documents");

							}

							if (paraDocOutput == 0) {

								mav.addObject("err", "Failed to update Documents");

							}

						}

					}

				}

			}
						
						
						
						if (paraObj.getTransferFlag() == true) {
							
							//System.out.println("coming here"+paraObj.getTransferFlag());
							
							paraDBObj2 = iram.getParaforedit(paraObj.getParaId());
							
							paraDBSUbObj2=iram.getSubParaforedit(paraObj.getParaId());

							// System.out.println("sectionId"+paraDBObj.getSectionId());

						

							doclist2 = irrm.getDocsByParaId(paraObj.getParaId());

							

							replyList2 = irrm.getReplybyParaId(paraObj.getParaId());

						
							

							paraTroutput = iram.editParasTransfer(paraObj);

							if (paraTroutput != null) {

								if (paraTroutput > 0) {

									paraObj.setUnitId(paraObj.getTunitId());
									paraObj.setCircleId(paraObj.getTcircleId());
									paraObj.setDivisionId(paraObj.getTdivisionId());
									paraObj.setSubdivisionId(paraObj.getTsubdivisionId());
									paraObj.setTunitId(0);
									paraObj.setTcircleId(0);
									paraObj.setTdivisionId(0);
									paraObj.setTsubdivisionId(0);

									if (paraObj.getUnitId() != null) {

										if (paraObj.getUnitId() > 0 && paraObj.getTunitId() == 0) {

											//paraOutput = iram.editParas(paraObj);
											
											//start 21032021 to transfer data
											
											
											if (paraObj.getParaDataList() != null) {
												if (paraObj.getParaDataList().size() > 0) {
													// insert parasa when status is not in trasfer
													
														paraOutput = iram.insertParas(paraObj);
														
														//paraTroutput = iram.insertParasTransfer(paraObj);

														//System.out.println("paraOutput"+paraOutput+"paraObj"+paraObj);


												}
											}

										

											if (paraOutput != null) {

												if (paraOutput > 0) {

													paraObj.setParaId(paraOutput);
													
													
													if (paraObj != null) {
														if (paraObj.getParaId() > 0) {

															// System.out.println("paraObj.getParaId"+paraObj.getParaId());
															subparaoutput = iram.insertParaMasterSub(paraObj);

														}
													}
							                        
													if(subparaoutput>0){
														
														 
														
														paraObj.setSubParaId(subparaoutput);
														
														//System.out.println("paraObj.getSUbParaId"+paraObj.getSubParaId());
													}
													

												
													if(replyList2!=null){
														//remove oaraId from reply subparadid list
														
														//System.out.println("replyList2"+replyList2);
														paraObj.setReplyDataList(replyList2);
														
														//System.out.println("paraObj.replydatalist"+paraObj.getReplyDataList());
														
														replyoutput = iram.insertParasReply(paraObj);	
														
														
													}
															// System.out.println("cominghere"+replyoutput);
																													
														if(doclist2!=null)	{	
															
															//remove paraId and subparadid from doclist
															
														//	System.out.println("doclist2"+doclist2);
															
															paraObj.setParadocList(doclist2);
															
														//	System.out.println("paraObj.getdoclist2"+paraObj.getParadocList());
													
																paraDocOutput = iram.insertParasDocuments(paraObj);
																
														}

															

														}
													}

												}

												if (paraOutput > 0) {

													mav.addObject("msg", "Successfully transfred");

												} else {

													mav.addObject("err", "Failed to Transfer Para");

												}

											}
											
											//end transfer data and insert 

											
										}
									}

						
					}
						
					}
				}
			}
			mav.addObject("unitList", unitList);

		} catch (IRParasUserException e) {
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

	@RequestMapping(value = "/parastsimis/viewreplydocs")
	public ModelAndView Viewreplydocs(@ModelAttribute("viewreplys") Paras paraObj, SessionStatus status,
			HttpSession session) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("viewdeletereply");

		// System.out.println(paraObj.getParaReplyId());
		List<ReplyData> replyListDB = new ArrayList<ReplyData>();
		List<ReplyData> replyListTotal = new ArrayList<ReplyData>();

		List<ParaDocuments> paradocsList = new ArrayList<ParaDocuments>();
		List<ParaDocuments> paradocsListDB = new ArrayList<ParaDocuments>();

		Integer output = 0;

		Integer deletereply = 0;

		Integer deletedoc = 0;
		Integer insertreply = 0;

		try {

			User user = (User) session.getAttribute("userObj");

			if (user != null) {
				paraObj.setUserId(user.getUserId());

				paraObj.setUserName(user.getUserName());

			}

			if (paraObj.getParaReplyId() != null && paraObj.getUserId() != null && paraObj.getUserName() != null) {

				deletereply = iram.deleteParasReplyById(paraObj.getParaReplyId(), paraObj.getUserId(),
						paraObj.getUserName());

				if (paraObj.getParaId() != null) {

					replyListDB = irrm.getReplybyParaId(paraObj.getParaId());
				}

				/*
				 * int len=replyListDB.size();
				 * 
				 * for(int i=0;i<len;i++){
				 * 
				 * 
				 * 
				 * if(paraObj.getParaId()==replyListDB.get(i).getParaId()){
				 * 
				 * ReplyData rd= new ReplyData();
				 * 
				 * rd.setParaReplyId(replyListDB.get(i).getParaReplyId());
				 * rd.setReplyAction(replyListDB.get(i).getReplyAction());
				 * rd.setReplyRemarks(replyListDB.get(i).getReplyRemarks());
				 * rd.setReplyDate(replyListDB.get(i).getReplyDate());
				 * rd.setParaId(replyListDB.get(i).getParaId());
				 * 
				 * replyListTotal.add(rd);
				 * 
				 * 
				 * }
				 * 
				 * 
				 * 
				 * }
				 */

				mav.addObject("replyListTotal", replyListDB);

				if (deletereply > 0) {

					mav.addObject("msg", "Successfully deleted reply");

				}
				if (deletereply == 0) {

					mav.addObject("err", "Failed to delete");

				}

			}

			if (paraObj.getDocId() != null) {

				deletedoc = iram.deleteParasDocsById(paraObj.getDocId(), paraObj.getUserId(), paraObj.getUserName());
				paradocsListDB = irrm.getDocsByParaId(paraObj.getParaId());
				/*
				 * int len2=paradocsListDB.size();
				 * 
				 * for(int j=0;j<len2;j++){
				 * 
				 * 
				 * 
				 * if(paraObj.getParaId()==paradocsListDB.get(j).getParaId()){
				 * 
				 * ParaDocuments pd= new ParaDocuments();
				 * 
				 * pd.setDocId(paradocsListDB.get(j).getDocId());
				 * pd.setParaDocName(paradocsListDB.get(j).getParaDocName());
				 * pd.setParaId(paradocsListDB.get(j).getParaId());
				 * 
				 * paradocsList.add(pd);
				 * 
				 * 
				 * }
				 * 
				 * 
				 * 
				 * }
				 */

				mav.addObject("paradocsList", paradocsListDB);
				if (deletedoc > 0) {

					mav.addObject("msg", "Successfully deleted document");

				}
				if (deletedoc == 0) {

					mav.addObject("err", "Failed to Delete");

				}

			}

			if (paraObj.getParaReplyId() == null && paraObj.getParaId() != null && paraObj.getParavalue() != null) {

				if (paraObj.getParaId() > 0 && paraObj.getParavalue().equals("rp")) {

					replyListDB = irrm.getReplybyParaId(paraObj.getParaId());
					// System.out.println("hsgdha"+paraObj.getUrlvalue());

					mav.addObject("replyListTotal", replyListDB);

				}
			}
			if (paraObj.getDocId() == null && paraObj.getParaId() != null && paraObj.getParavalue() != null) {
				if (paraObj.getParaId() > 0 && paraObj.getParavalue().equals("dc")) {
					paradocsListDB = irrm.getDocsByParaId(paraObj.getParaId());
					/*
					 * int len2=paradocsListDB.size();
					 * 
					 * for(int j=0;j<len2;j++){
					 * 
					 * 
					 * 
					 * if(paraObj.getParaId()==paradocsListDB.get(j).getParaId()
					 * ){
					 * 
					 * ParaDocuments pd= new ParaDocuments();
					 * 
					 * pd.setDocId(paradocsListDB.get(j).getDocId());
					 * pd.setParaDocName(paradocsListDB.get(j).getParaDocName())
					 * ; pd.setParaId(paradocsListDB.get(j).getParaId());
					 * 
					 * paradocsList.add(pd);
					 * 
					 * 
					 * }
					 * 
					 * 
					 * 
					 * }
					 */
					mav.addObject("paradocsList", paradocsListDB);

				}

			}

		} catch (IRParasUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return mav;

	}

	@RequestMapping(value = "/parastsimis/addnewreply")
	public ModelAndView addnewreply(@ModelAttribute("addnewreply") ReplyData repObj, SessionStatus status,
			HttpSession session) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("addnewreply");

		Integer output = 0;
		try {

			User user = (User) session.getAttribute("userObj");

			// System.out.println("rep"+repObj.getParaId());
			mav.addObject("paraIdValue", repObj.getParaId());
			if (repObj.getParaId() != null && repObj.getReplyAction() != null && user != null) {

				if (user.getUserId() != null && user.getUserName() != null)
					repObj.setUserId(user.getUserId());
				repObj.setUserName(user.getUserName());
				;

				output = iram.editParasReply(repObj);

				if (output > 0) {

					mav.addObject("msg", "Successfully added reply");

				}

				if (output == 0) {

					mav.addObject("err", "Failed to add reply");

				}

			}

		} catch (IRParasUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return mav;

	}

	@RequestMapping(value = "/parastsimis/deletecagparas")
	public ModelAndView deletecagparas(@ModelAttribute("deletecagparas") CAGParas paraObj, SessionStatus status,
			HttpSession session) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("deletecagparas");

		List<Unit> unitList = new ArrayList<Unit>();
		List<Circle> circleList = new ArrayList<Circle>();
		List<Division> divisionList = new ArrayList<Division>();
		List<CAGParas> paraListTotalByUnit = new ArrayList<CAGParas>();

		CAGParas paraListGistbyGistId = new CAGParas();
		List<ReplyData> replyListDB = new ArrayList<ReplyData>();
		List<CAGParasData> cagParasData = new ArrayList<CAGParasData>();

		List<CAGParasData> parasData = new ArrayList<CAGParasData>();

		User user = new User();

		List<ParaDocuments> paradocsList = new ArrayList<ParaDocuments>();

		Integer output = 0;
		try {
			unitList = tam.getunitpostList();
			circleList = tam.getcirclepostList();
			divisionList = tam.getdivisionpostList();

			user = (User) session.getAttribute("userObj");

			/*
			 * System.out.println("coming here");
			 * 
			 * System.out.println("coming here1" +paraObj.getUnitId());
			 * System.out.println("coming here2" +paraObj.getCircleId());
			 * System.out.println("coming here3" +paraObj.getDivisionId());
			 * System.out.println("coming here4" +paraObj.getSubdivisionId());
			 * System.out.println("coming here5" +paraObj.getCagGistId());
			 */
			if (paraObj.getUnitId() != null && paraObj.getDeleteFlag() == false) {

				if (paraObj.getUnitId() > 0) {

					// System.out.println(paraObj.getUnitTotal());
					// System.out.println(paraObj.getCircleId());
					// System.out.println(paraObj.getCircleId());

					paraListTotalByUnit = iram.getCAGGistByUnit(paraObj.getUnitId());

					// parasData=iram.getCAGParaAll();

					// System.out.println("paraListTotalByUnit"+paraListTotalByUnit);

				}

			}

			/*
			 * if(paraObj.getParaId()!=null && paraObj.getDeleteFlag()==true){
			 * 
			 * output=iram.deleteParasReplyDocs(paraObj.getParaId(),user.
			 * getUserId(),user.getUserName());
			 * 
			 * if(output>0){
			 * 
			 * mav.addObject("msg", "Successfully deleted para");
			 * 
			 * }
			 * 
			 * if(output==0){
			 * 
			 * mav.addObject("err", "Failed to delete para");
			 * 
			 * }
			 * 
			 * 
			 * 
			 * }
			 */

		} catch (TaskUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IRParasUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		mav.addObject("unitList", unitList);
		mav.addObject("circleList", circleList);
		mav.addObject("divisionList", divisionList);

		mav.addObject("parasList", paraListTotalByUnit);

		mav.addObject("parasData", parasData);
		mav.addObject("user", user);

		return mav;

	}

	@RequestMapping(value = "/parastsimis/addCAGPara")
	public ModelAndView AddCAGPara(@ModelAttribute("cagparas") CAGParas paraObj, SessionStatus status,
			HttpSession session) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("addcagPara");
		List<Unit> unitList = new ArrayList<Unit>();

		//System.out.println("paraObj.getFinancialYear()" + paraObj.getFinancialYear());

		Integer paraOutput = 0;
		Integer mastoutput = 0;
		Integer paraDocOutput = 0;
		Integer paraTroutput = 0;

		String[] saveFileName = null;

		List<String> fileNameList = new ArrayList<String>();

		List<CAGParasData> paraDataList = new ArrayList<CAGParasData>();

		try {
			unitList = tam.getUnitList();

			// System.out.println("addPara"+unitList);

			User user = (User) session.getAttribute("userObj");

			if (paraObj != null && paraObj.getFinancialYear() != null) {

				if (user != null) {
					paraObj.setUserId(user.getUserId());

					paraObj.setUserName(user.getUserName());

				}

			//	System.out.println("paraOutputsize" + paraOutput + paraObj.getParaDataList().size());
				if (paraObj.getParaDataList() != null) {
					if (paraObj.getParaDataList().size() > 0) {

					//	System.out.println("paraObj.getFinancialYear()" + paraObj.getFinancialYear());

						// insert parasa when status is not in trasfer

						paraOutput = iram.insertCAGParas(paraObj);

						

					}
				}

				// System.out.println("paraOutput"+paraOutput);

				if (paraOutput != null) {

					if (paraOutput > 0) {

						paraObj.setCagGistId(paraOutput);

						if (paraObj.getParaDataList() != null) {
							if (paraObj.getParaDataList().size() > 0) {

								// iterate the data list to send data to
								// multiple units add data to new list and set
								// the list in paraobj

								int len = paraObj.getParaDataList().size();

								for (int j = 0; j < len; j++) {

									// System.out.println("j"+paraObj.getParaDataList().size());
									// System.out.println("unitVal1"+paraObj.getParaDataList().get(j));
									String unitnames = paraObj.getParaDataList().get(j).getSubParaUnitList();
									// System.out.println("unitVal2"+unitnames);
									List<String> unitnamesList = Arrays.asList(unitnames.split("\\s*,\\s*"));
									// String[] unitnamesList
									// =unitnames.split(",");

									for (int i = 0; i < unitnamesList.size(); i++) {
										CAGParasData unitwiseParaData = new CAGParasData();

										// System.out.println("unitVal"+unitnamesList.get(i).toString());
										unitwiseParaData
												.setSubParaUnitId(Integer.parseInt(unitnamesList.get(i).toString()));
										unitwiseParaData
												.setParaSequence(paraObj.getParaDataList().get(j).getParaSequence());
										unitwiseParaData
												.setParasAction(paraObj.getParaDataList().get(j).getParasAction());
										unitwiseParaData
												.setSubParaNumber(paraObj.getParaDataList().get(j).getSubParaNumber());
										unitwiseParaData.setParaTitle(paraObj.getParaDataList().get(j).getParaTitle());
										unitwiseParaData
												.setParaStatusId(paraObj.getParaDataList().get(j).getParaStatusId());
										unitwiseParaData
												.setDiscussPac(paraObj.getParaDataList().get(j).getParaStatus());

										// System.out.println("unitVal"+unitwiseParaData);
										paraDataList.add(unitwiseParaData);
									}

								}

								paraObj.setParaDataList(paraDataList);

								// System.out.println("cominghere"+replyoutput);
								// mastoutput=iram.insertCAGParasMaster(paraObj);

							}
						}

					}

				}

				if (mastoutput > 0) {

					mav.addObject("msg", "Successfully added CAG para");

				} else {

					mav.addObject("err", "Failed to add CAG Para");

				}

			}

		} catch (TaskUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IRParasUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		mav.addObject("unitList", unitList);

		return mav;

	}
 //production
	@RequestMapping(value = "/parastsimis/addcagreplydocs")
	public ModelAndView addcagreplydocs(@ModelAttribute("cagreplydocs") CAGParas paraObj, SessionStatus status,
			HttpSession session) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("addcagreplydocs");

		List<Unit> unitList = new ArrayList<Unit>();

		List<CAGParasData> parasData = new ArrayList<CAGParasData>();
		List<ReplyData> replyData = new ArrayList<ReplyData>();
		List<CAGParas> selectCAGparaFYear = new ArrayList<CAGParas>();

		Integer selectedunitId = 0;
		Integer selectedcircleId=0;

		User user = new User();

		try {
			unitList = tam.getunitpostList();

			user = (User) session.getAttribute("userObj");
			
			selectCAGparaFYear = irrm.getCAGparaFinYear();
			   if(selectCAGparaFYear!=null){
          mav.addObject("selectCAGparaFYear",selectCAGparaFYear);
         // System.out.println("selectCAGparaFYear "+selectCAGparaFYear);
			   }
			

			if (user != null) {

				if (user.getUserName() != null) {
					//System.out.println("paraObj.getUnitId()"+paraObj.getUnitId());

					if (paraObj.getUnitId() != null &&  paraObj.getFinancialYear()!=null) {

						if (paraObj.getUnitId() > 0) {

							selectedunitId = paraObj.getUnitId();
							selectedcircleId=paraObj.getCircleId();
							
							if((((paraObj.getUnitId()!=9832) && paraObj.getCircleId()!=21614  ) || (paraObj.getUnitId()!=4) ) && (paraObj.getFinancialYear()!=null)){

							parasData = iram.getCAGParaAllbyunitId(paraObj);
							
							}
							
							if(((selectedunitId==9832) && (selectedcircleId==21614))|| ( selectedunitId==4)){
								parasData = iram.getCAGParaEnci(paraObj);
								
							}
							//System.out.println("parasData"+parasData);
							
							replyData =irrm.getCAGReplybyfy(paraObj);
							
						}

					}

				}

			}

		} catch (TaskUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IRParasUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		mav.addObject("unitList", unitList);

		

		mav.addObject("parasData", parasData);
		
		mav.addObject("replyData",replyData);

	
		mav.addObject("selectedunitId", selectedunitId);

		mav.addObject("userObj", user);

		return mav;

	}

	/*@RequestMapping(value = "/parastsimis/addnewpara")
	@ResponseBody
	public String addnewpara(Integer cagGistId, Integer paraSequence, String parasAction, String paraTitle,
			SessionStatus status, HttpSession session) {
	

		CAGParas paraObj = new CAGParas();

		
		Integer output = 0;
		try {

			User user = (User) session.getAttribute("userObj");

			// System.out.println("repgist id"+cagGistId);

			if (cagGistId != null && parasAction != null && user != null) {

				if (user.getUserId() != null && user.getUserName() != null)

					paraObj.setParaTitle(paraTitle);

				paraObj.setParasAction(parasAction);

				paraObj.setParaSequence(paraSequence);

				paraObj.setUserId(user.getUserId());
				paraObj.setUserName(user.getUserName());
				paraObj.setCagGistId(cagGistId);

				output = iram.insertnewCAGPara(paraObj);

				// System.out.println("rep"+output);

			}
		} catch (IRParasUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new Gson().toJson(output.toString());

	}*/
 //production
	@RequestMapping(value = "/parastsimis/addcagreply")
	@ResponseBody
	public String addcagreply(ReplyData replyObj, SessionStatus status, HttpSession session) {

		Integer output = 0;
		try {

			User user = (User) session.getAttribute("userObj");

			if (replyObj != null && user != null) {

				if ( user.getUserName() != null) {
					//replyObj.setUserId(user.getUserId());
					replyObj.setUserName(user.getUserName());
					
					if(user.getUnitId()!=null ){
						replyObj.setSubParaUnitId(user.getUnitId());
						}
						
				}

				output = iram.addCAGParasReply(replyObj);
				// System.out.println("output"+output);

			}

		} catch (IRParasUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new Gson().toJson(output.toString());

	}
	
	private static final String RELATIVE_DIR_CAG = "/uploadedFiles/CAGParas/";
    //production
	@RequestMapping(value = "/parastsimis/addcagdocs")
	@ResponseBody
	public String addcagdocs(CAGParas paraObj, MultipartHttpServletRequest request,
			SessionStatus status, HttpSession session) {

		Integer paraDocOutput = 0;

		List<String> fileNameList = new ArrayList<String>();
		List<MultipartFile> uploadFile = request.getFiles("uploadFile");
		try {

			User user = (User) session.getAttribute("userObj");

			// System.out.println("uploadFile"+uploadFile);
			// System.out.println("cagGistId"+paraObj.getCagGistId());
			//System.out.println("cagParaId"+paraObj.getCagParaId());
			// System.out.println("size"+uploadFile.size());
			
			if (paraObj != null && uploadFile.size() > 0) {

				paraObj.setCagGistId(paraObj.getCagGistId());
				paraObj.setCagParaId(paraObj.getCagParaId());
				paraObj.setUploadFile(uploadFile);

				if (user != null) {
					//paraObj.setUserId(user.getUserId());
					
					

					paraObj.setUserName(user.getUserName());
					
					if(user.getUnitId()!=null ){
					paraObj.setUnitId(user.getUnitId());
					}
					
				}

				if (paraObj.getUploadFile() != null) {

					if (paraObj.getUploadFile().size() >= 1) {

						List<MultipartFile> files = paraObj.getUploadFile();

						List<String> fileNames = new ArrayList<String>();

						List<ParaDocuments> fileList = new ArrayList<ParaDocuments>();

						String filetitile = null;
						String filetitilenew = null;
						// System.out.println("filesize"+files.size()+"--"+files);
						if (null != files && files.size() >= 1) {
							for (MultipartFile multipartFile : files) {

								String fileName = multipartFile.getOriginalFilename();
								String FileType = (files).get(0).getContentType();
								fileNames.add(fileName);
								// Handle file content -
								// multipartFile.getInputStream()

							}

							// System.out.println("2nd file
							// size"+fileNames.size());

							for (int i = 0; i < fileNames.size(); i++) {
								filetitile = fileNames.get(i);

								// System.out.println("filetitile"+filetitile);

								if (!filetitile.isEmpty()) {
									Integer maxId = iram.getCountOfCAGParaDocs() + 1;
									// System.out.println("maxId"+maxId);

									String[] temps = filetitile.split(Pattern.quote("."));

									Integer paraNum = paraObj.getCagParaId();

									String docName = temps[0];
									String SaveName = paraNum.toString() + maxId.toString() + docName + "."
											+ temps[temps.length - 1];

									maxId++;
									fileNameList.add(SaveName);

									// System.out.println("saveFileName"+fileNameList.get(i));

									/*
									 * if (i==0){ filetitilenew=filetitile; }
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
							
							  String absolutePath = servletContext.getRealPath(RELATIVE_DIR_CAG);
							  
							  if (absolutePath == null) {
								    // fallback if getRealPath returns null (some servlet containers do this)
								    absolutePath = new File(".").getCanonicalPath() + RELATIVE_DIR_CAG;
								}


							// System.out.println("filetitilenew"+filetitilenew);
							//String rootPath = System.getProperty("catalina.base");
							
							//for local
							/*File dir = new File(
									rootPath + File.separator + "webapps" + File.separator + "ICADLeagalWebApp"
											+ File.separator + "uploadedFiles" + File.separator + "CAGParas");*/
							//for server
							//File dir = new File( File.separator + "Uploads" + File.separator + "tsimis" + File.separator + "uploadedFiles"
									//+ File.separator + "CAGParas");
							  
							  File dir = new File(absolutePath);
							
							//File dir = new File(rootPath + File.separator + "webapps" + File.separator + "tsimis" + File.separator + "uploadedFiles"
								//	+ File.separator + "CAGParas");

							if (!dir.exists())
								dir.mkdirs();

							paraObj.setFileLocation(dir.getAbsolutePath());

							for (int i = 0; i < files.size(); i++) {

								// File serverFile = new
								// File(dir.getAbsolutePath()+ File.separator +
								// files.get(i).getOriginalFilename());
								if (!fileNameList.isEmpty()) {
									// System.out.println("serverFile"+serverFile);

									if (fileNameList.size() > 0) {

										String paraDocName = fileNameList.get(i);
										ParaDocuments tf = new ParaDocuments();

										tf.setParaDocName(paraDocName);
										tf.setParaDocOriginalName(files.get(i).getOriginalFilename());
										tf.setParaDocLocation(dir.getAbsolutePath() + File.separator + paraDocName);

										fileList.add(tf);

										files.get(i).transferTo(
												new File(dir.getAbsolutePath() + File.separator + paraDocName));

									}

								}
							}

							if (fileList.size() > 0) {
								paraObj.setParadocList(fileList);
								;

							}

							paraDocOutput = iram.insertCAGParasDocuments(paraObj);

						}

					}
				}

			}
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IRParasUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new Gson().toJson(paraDocOutput);

	}
//production
	@RequestMapping(value = "/parastsimis/getcagReplys")
	@ResponseBody
	public String getCAGReplysbyparaId(Integer cagParaId, SessionStatus status, HttpServletRequest request)
			throws LeagalUserException {

		List<ReplyData> replyList = new ArrayList<ReplyData>();
		try {
			replyList = iram.getCAGReplybyParaId(cagParaId);
		} catch (IRParasUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new Gson().toJson(replyList);

	}
//production
	@RequestMapping(value = "/parastsimis/getcagDocs")
	@ResponseBody
	public String getCAGDocsbyparaId(Integer cagParaId, SessionStatus status, HttpServletRequest request)
			throws LeagalUserException {

		List<ParaDocuments> docList = new ArrayList<ParaDocuments>();
		try {
			docList = iram.getCAGDocsByParaId(cagParaId);
		} catch (IRParasUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new Gson().toJson(docList);

	}
    //production
	@RequestMapping(value = "/parastsimis/deleteCagGist")
	@ResponseBody
	public String deleteCAGGist(Integer cagGistId, SessionStatus status, HttpServletRequest request,
			HttpSession session) throws LeagalUserException {

		User user = (User) session.getAttribute("userObj");
		Integer userId = 0;
		String userName = null;

		Integer deletedrows = 0;
		if (user != null) {

			if ( user.getUserName() != null) {

				//userId = user.getUserId();
				userName = user.getUserName();

			}

		}

		try {
			deletedrows = iram.deleteCAGGistParasReplyDocs(cagGistId,  userName);
		} catch (IRParasUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new Gson().toJson(deletedrows);

	}
    //production
	@RequestMapping(value = "/parastsimis/deletesubpara")
	@ResponseBody
	public String deletesubpara(Integer cagParaId, SessionStatus status, HttpServletRequest request,
			HttpSession session) throws LeagalUserException {

		User user = (User) session.getAttribute("userObj");
		Integer userId = 0;
		String userName = null;

		Integer deletedrows = 0;
		if (user != null) {

			if (user.getUserId() != null && user.getUserName() != null) {

				userId = user.getUserId();
				userName = user.getUserName();

			}

		}

		try {
			deletedrows = iram.deleteCAGParasReplyByParaId(cagParaId,  userName);
		} catch (IRParasUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new Gson().toJson(deletedrows);

	}
//production
	@RequestMapping(value = "/parastsimis/deleteCagReply")
	@ResponseBody
	public String deleteCAGReply(Integer cagReplyId, SessionStatus status, HttpServletRequest request,
			HttpSession session) throws LeagalUserException {
		
	//System.out.println("cagReplyId"+cagReplyId);

		User user = (User) session.getAttribute("userObj");
		Integer userId = 0;
		String userName = null;

		Integer deletedrows = 0;
		if (user != null) {

			if ( user.getUserName() != null) {

				//userId = user.getUserId();
				userName = user.getUserName();

			}

		}

		try {
			deletedrows = iram.deleteCAGReplyByReplyId(cagReplyId,  userName);
		} catch (IRParasUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new Gson().toJson(deletedrows);

	}
   //production
	@RequestMapping(value = "/parastsimis/deleteCagDocs")
	@ResponseBody
	public String deleteCAGDocs(Integer cagDocId, SessionStatus status, HttpServletRequest request, HttpSession session)
			throws LeagalUserException {

		//System.out.println("cagDocId"+cagDocId);
		User user = (User) session.getAttribute("userObj");
		Integer userId = 0;
		String userName = null;

		Integer deletedrows = 0;
		if (user != null) {

			if ( user.getUserName() != null) {

				//userId = user.getUserId();
				userName = user.getUserName();

			}

		}

		try {
			deletedrows = iram.deleteCAGDocsByDocId(cagDocId,  userName);
		} catch (IRParasUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new Gson().toJson(deletedrows);

	}

	/*@RequestMapping(value = "/parastsimis/editcagparas")
	public ModelAndView editcagparas(@ModelAttribute("editcagparareply") CAGParas paraObj, SessionStatus status,
			HttpSession session) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("editcagparas");
		List<Unit> unitList = new ArrayList<Unit>();

		// System.out.println("coming here"+paraObj.getCagGistId());

		Integer cagparasOutput = 0;
		Integer cagmasteroutput = 0;
		Integer cagreplyoutput = 0;
		Integer TrcagparasOutput = 0;
		Integer newcagGistId = 0;

		List<ReplyData> replyListDB = new ArrayList<ReplyData>();
		List<CAGParasData> cagParasData = new ArrayList<CAGParasData>();

		Integer cagGistId = 0;

		// System.out.println("i am ahere 1");

		CAGParas paraDBObj = new CAGParas();
		try {
			unitList = tam.getUnitList();
			User user = (User) session.getAttribute("userObj");
			if (user != null) {

				if (user.getUserId() > 0) {

					// System.out.println("i am ahere 2");
					paraObj.setUserId(user.getUserId());

					paraObj.setUserName(user.getUserName());

				}
				if (paraObj.getCagGistId() != null) {

					if (paraObj.getCagGistId() > 0) {
						// System.out.println("i am ahere 3");

						cagGistId = paraObj.getCagGistId();

					}

				}

				if (cagGistId > 0 && paraObj.getEditFlag() == false) {

					// System.out.println("i am ahere 4");

					paraDBObj = iram.getCAGGistByGistId(cagGistId);

					// replyListDB=irrm.getCAGReplybyGistId(cagGistId);

					// cagParasData=irrm.getCAGParasbyGistId(cagGistId);

					// System.out.println("paraDBObj"+paraDBObj);
					// System.out.println("replyListDB"+replyListDB);
					// System.out.println("cagParasData"+cagParasData);

					mav.addObject("paraDBObj", paraDBObj);
					mav.addObject("replyListDB", replyListDB);
					mav.addObject("cagParasData", cagParasData);

				}
				// System.out.println("i am here "+paraObj.getTransferFlag());

				if (cagGistId > 0 && paraObj.getParaStatusId() != null && paraObj.getEditFlag() == true) {

					paraObj.setSectionId(3);

					if (paraObj.getTransferFlag() == false) {

						// System.out.println("notransfert");

						// cagparasOutput= iram.editcagGistParas(paraObj);

					}

					if (paraObj.getTransferFlag() == true) {

						// System.out.println("transfert"+paraObj.getTunitId());

						// transfer the para
						TrcagparasOutput = iram.editCAGParasTransfer(paraObj);

						// System.out.println("TrcagparasOutput"+TrcagparasOutput);

						if (TrcagparasOutput != null) {

							paraObj.setUnitId(paraObj.getTunitId());
							paraObj.setCircleId(paraObj.getTcircleId());
							paraObj.setDivisionId(paraObj.getTdivisionId());
							paraObj.setSubdivisionId(paraObj.getTsubdivisionId());
							paraObj.setTunitId(0);
							paraObj.setTcircleId(0);
							paraObj.setTdivisionId(0);
							paraObj.setTsubdivisionId(0);

							if (paraObj.getUnitId() != null) {

								if (paraObj.getUnitId() > 0 && paraObj.getTunitId() == 0) {

									// update transfred
									newcagGistId = iram.insertCAGParas(paraObj);

									if (newcagGistId != null) {

										if (newcagGistId > 0) {

											cagparasOutput = iram.UpdateTrCAGGistIdByGistId(paraObj.getCagGistId(),
													newcagGistId, paraObj.getUserId(), paraObj.getUserName());
										}

									}

									if (cagparasOutput > 0) {

										mav.addObject("msg", "Successfully updated t para");

									}

									if (cagparasOutput == 0) {

										mav.addObject("err", "Failed to update t Para");

									}

								}
							}

						}

					}

					// start of cag master
					if (paraObj.getParaDataList() != null) {

						if (paraObj.getParaDataList().size() > 0) {

							if (paraObj.getParaDataList().get(0).getCagParaId() > 0) {

								// cagmasteroutput=iram.editmultipleCagParas(paraObj);
								// call list of cag matser

							}

						}

					}

					// start of cag replys

					if (paraObj.getReplyDataList() != null) {

						if (paraObj.getReplyDataList().size() > 0) {

							if (paraObj.getReplyDataList().get(0).getParaReplyId() > 0) {

								// call reply update
								//cagreplyoutput = iram.editmultipleCagParasReply(paraObj);

							}

						}

					}

					// if needed call docs table

					if (cagparasOutput > 0) {
						mav.addObject("msg", "Successfully updated");

					}

					if (cagparasOutput == 0) {

						mav.addObject("err", "Failed to update");

					}

				}

			}

			
			 * if(paraObj.getUploadFile()!=null){
			 * 
			 * //System.out.println("filesize"+paraObj.getUploadFile().size());
			 * 
			 * if(paraObj.getUploadFile().size()>=1){
			 * 
			 * List<MultipartFile> files = paraObj.getUploadFile();
			 * 
			 * List<String> fileNames = new ArrayList<String>();
			 * 
			 * List<ParaDocuments> fileList=new ArrayList<ParaDocuments>();
			 * 
			 * String filetitile=null; String filetitilenew=null;
			 * 
			 * if(null != files && files.size() >=1) { for (MultipartFile
			 * multipartFile : files) {
			 * 
			 * String fileName = multipartFile.getOriginalFilename(); //String
			 * FileType = ( files).get(0).getContentType();
			 * fileNames.add(fileName); //Handle file content -
			 * multipartFile.getInputStream()
			 * 
			 * }
			 * 
			 * 
			 * 
			 * //System.out.println("2nd file size"+fileNames.size());
			 * 
			 * 
			 * 
			 * for(int i=0; i<fileNames.size();i++){
			 * filetitile=fileNames.get(i); if(!filetitile.isEmpty()){ Integer
			 * maxId = iram.getCountOfParaDocs()+1;
			 * 
			 * Integer paraNum=paraObj.getParaId();
			 * 
			 * String[] temps = filetitile.split(Pattern.quote(".")); String
			 * docName= temps[0]; String SaveName
			 * =paraNum.toString()+maxId.toString()+docName+ "." +
			 * temps[temps.length - 1];
			 * 
			 * maxId++; fileNameList.add(SaveName);
			 * 
			 * //System.out.println("saveFileName"+SaveName);
			 * 
			 * if (i==0){ filetitilenew=filetitile; }
			 * 
			 * if(i>0){
			 * 
			 * filetitilenew=filetitile+"@"+filetitilenew;
			 * 
			 * }
			 * 
			 * // System.out.println("filetitilenew"+filetitilenew);
			 * 
			 * } }
			 * 
			 * // System.out.println("filetitilenew"+filetitilenew); String
			 * rootPath = System.getProperty("catalina.base"); File dir = new
			 * File(rootPath + File.separator + "webapps" + File.separator +
			 * "ICADLeagalWebApp" + File.separator +
			 * "uploadedFiles"+File.separator+"IRParas");
			 * 
			 * if (!dir.exists()) dir.mkdirs();
			 * 
			 * 
			 * paraObj.setFileLocation(dir.getAbsolutePath());
			 * 
			 * 
			 * 
			 * 
			 * 
			 * for(int i=0; i<files.size(); i++){
			 * 
			 * //File serverFile = new File(dir.getAbsolutePath()+
			 * File.separator + files.get(i).getOriginalFilename());
			 * 
			 * // System.out.println("serverFile"+serverFile);
			 * 
			 * if(!fileNameList.isEmpty()){ ParaDocuments tf =new
			 * ParaDocuments();
			 * 
			 * String paraDocName=fileNameList.get(i);
			 * 
			 * tf.setParaDocName(paraDocName);
			 * tf.setParaDocOriginalName(files.get(i).getOriginalFilename());
			 * tf.setParaDocLocation(dir.getAbsolutePath()+ File.separator +
			 * paraDocName); paraObj.setUserId(user.getUserId());
			 * 
			 * paraObj.setUserName(user.getUserName());
			 * 
			 * 
			 * 
			 * fileList.add(tf);
			 * 
			 * files.get(i).transferTo( new File(dir.getAbsolutePath() +
			 * File.separator + paraDocName)); } }
			 * 
			 * 
			 * if(fileList.size()>0){ paraObj.setParadocList(fileList);;
			 * 
			 * 
			 * }
			 * 
			 * 
			 * paraDocOutput=iram.insertParasDocuments(paraObj);
			 * 
			 * if(paraDocOutput>0){ mav.addObject("msg",
			 * "Successfully updated Documents");
			 * 
			 * }
			 * 
			 * if(paraDocOutput==0){
			 * 
			 * mav.addObject("err","Failed to update Documents");
			 * 
			 * }
			 * 
			 * 
			 * }
			 * 
			 * 
			 * 
			 * 
			 * 
			 * }
			 * 
			 * 
			 * 
			 * }
			 

			// }

			mav.addObject("unitList", unitList);

		} catch (IRParasUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TaskUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mav;

	}*/

	@RequestMapping(value = "/parastsimis/editcagparareply")
	public ModelAndView editcagparasreplybyparaId(@ModelAttribute("editcagparareplybypara") CAGParas paraObj,
			SessionStatus status, HttpSession session) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("editcagparareply");
		List<Unit> unitList = new ArrayList<Unit>();

		// System.out.println("coming here para id"+paraObj.getCagParaId());

		Integer cagparasOutput = 0;
		Integer cagmasteroutput = 0;
		Integer cagreplyoutput = 0;
		Integer TrcagparasOutput = 0;
		Integer newcagGistId = 0;

		List<ReplyData> replyListDB = new ArrayList<ReplyData>();
		List<CAGParasData> cagParasData = new ArrayList<CAGParasData>();

		Integer cagParaId = 0;

		// System.out.println("i am ahere 1");

		CAGParas paraDBObj = new CAGParas();
		try {
			unitList = tam.getUnitList();
			User user = (User) session.getAttribute("userObj");
			if (user != null) {

				if (user.getUserId() > 0) {

					// System.out.println("i am ahere 2");
					paraObj.setUserId(user.getUserId());

					paraObj.setUserName(user.getUserName());

				}
				if (paraObj.getCagParaId() != null) {

					if (paraObj.getCagParaId() > 0) {
						// System.out.println("i am ahere 3");

						cagParaId = paraObj.getCagParaId();

					}

				}

				if (cagParaId > 0 && paraObj.getEditFlag() == false) {

					// System.out.println("i am ahere 4");

				//	replyListDB = iram.getCAGReplybyParaId(cagParaId,paraObj.getUnitId());

					cagParasData = irrm.getCAGParasbyParaId(cagParaId);

					// System.out.println("paraDBObj"+paraDBObj);
					// System.out.println("replyListDB"+replyListDB);
					// System.out.println("cagParasData"+cagParasData);

					mav.addObject("replyListDB", replyListDB);
					mav.addObject("cagParasData", cagParasData);

				}
				// System.out.println("i am here "+paraObj.getTransferFlag());

				if (cagParaId > 0 && paraObj.getEditFlag() == true) {

					// start of cag master
					if (paraObj.getParaDataList() != null) {

						if (paraObj.getParaDataList().size() > 0) {

							if (paraObj.getParaDataList().get(0).getCagParaId() > 0) {

								// cagmasteroutput=iram.editmultipleCagParas(paraObj);
								// call list of cag matser

							}

						}

					}

					// start of cag replys

					if (paraObj.getReplyDataList() != null) {

						if (paraObj.getReplyDataList().size() > 0) {

							if (paraObj.getReplyDataList().get(0).getParaReplyId() > 0) {

								// call reply update
							//	cagreplyoutput = iram.editmultipleCagParasReply(paraObj);

							}

						}

					}

					// if needed call docs table

					if (cagparasOutput > 0) {
						mav.addObject("msg", "Successfully updated");

					}

					if (cagparasOutput == 0) {

						mav.addObject("err", "Failed to update");

					}

				}

			}

			mav.addObject("unitList", unitList);

		} catch (IRParasUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TaskUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mav;

	}
    //for production
	@RequestMapping(value = "/parastsimis/addCAGParaGist")
	public ModelAndView AddCAGParaGist(@ModelAttribute("cagparasgist") CAGParas paraObj, SessionStatus status,
			HttpSession session) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("addCAGParaGist");
		List<Unit> unitList = new ArrayList<Unit>();

		// System.out.println("coming here
		// paraObj.getFinancialYear()"+paraObj.getFinancialYear());

		Integer paraOutput = 0;
		Integer mastoutput = 0;

		List<CAGParasData> paraDataList = new ArrayList<CAGParasData>();

		try {

			User user = (User) session.getAttribute("userObj");

			if (paraObj != null && paraObj.getFinancialYear() != null) {

				if (user != null) {
					//paraObj.setUserId(user.getUserId());

					paraObj.setUserName(user.getUserName());
					
					
					paraObj.setUnitId(user.getUnitId());
					

				}

				paraOutput = iram.insertCAGParas(paraObj);

				if (paraOutput > 0) {

					mav.addObject("msg", "Successfully added CAG Gist of Para");

				} else {

					mav.addObject("err", "Failed to add CAG Gist of praPara");

				}
				/*if (paraOutput == -1) {

					mav.addObject("err", "Gist of Para is already added please delete or Edit");

				}
*/
			}

		} catch (IRParasUserException e) {

			e.printStackTrace();

		}

		mav.addObject("unitList", unitList);

		return mav;

	}

	//production
	@RequestMapping(value = "/parastsimis/addCAGSubPara")
	public ModelAndView AddCAGSubPara(@ModelAttribute("cagsubparas") CAGParasData paraObj, SessionStatus status,
			HttpSession session) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("addCAGSubPara");
		List<Unit> unitList = new ArrayList<Unit>();

		List<CAGParas> finList = new ArrayList<CAGParas>();

		// List<CAGParas> insertunitList=new ArrayList<CAGParas>();

		List<CAGParasData> subparaList = new ArrayList<CAGParasData>();

		Integer mastoutput = 0;

		Integer unitOutput = 0;

		List<CAGParasData> paraDataList = new ArrayList<CAGParasData>();

		try {

			finList = iram.getCAGFinancialYear();
			unitList = tam.getUnitList();

			// selected Financial year List

			// Selected Gist List Ajax

			// insert gist id along with sub para returning para Id
			// insert unit para id gist id in another table

			User user = (User) session.getAttribute("userObj");
			
			if (user != null) {
				//paraObj.setUserId(user.getUserId());

				paraObj.setUserName(user.getUserName());
				
				if(user.getUnitId()!=null ){
				paraObj.setCunitId(user.getUnitId());
				
                   };
				

			}

			if (paraObj.getCagGistId() != null) {
				if (paraObj.getCagGistId() > 0) {

					subparaList = iram.selectCAGSubParaList(paraObj.getCagGistId());

				}

			}

			// System.out.println("coming here"+paraObj.getParaStatusId());

			if (paraObj != null  && paraObj.getSubParaNumber() != null) {

		//	 System.out.println("paraObj.getParaStatusId()"+paraObj.getParaStatusId());

				
			//	 System.out.println("paraObj"+paraObj);

				mastoutput = iram.insertCAGParasMaster(paraObj);

				if (mastoutput != null) {

					if (mastoutput > 0) {

						// System.out.println("mastoutput"+mastoutput);
						
						paraObj.setCagParaId(mastoutput);
						paraObj.setParaStatusId(20);

						String unitnames = paraObj.getSubParaUnitList();

						List<String> unitnamesList = Arrays.asList(unitnames.split("\\s*,\\s*"));
						// String[] unitnamesList =unitnames.split(",");

						for (int i = 0; i < unitnamesList.size(); i++) {
							CAGParasData unitwiseParaData = new CAGParasData();

							// System.out.println("unitVal"+unitnamesList.get(i).toString());
							unitwiseParaData.setSubParaUnitId(Integer.parseInt(unitnamesList.get(i).toString()));
							unitwiseParaData.setCagGistId(paraObj.getCagGistId());
							unitwiseParaData.setCagParaId(mastoutput);
							unitwiseParaData.setUserId(paraObj.getUserId());
							unitwiseParaData.setUserName(paraObj.getUserName());
							//unitwiseParaData.setParaStatusId(2);
							unitwiseParaData.setCunitId(paraObj.getCunitId());

							// System.out.println("unitVal"+unitwiseParaData);
							paraDataList.add(unitwiseParaData);
						}

					}

					

					unitOutput = iram.insertcagparaunitmap(paraDataList);
					
					if(unitOutput!=null){
						if(unitOutput>0){
							
							// System.out.println("paraObj"+paraObj);
					
					                iram.insertcagStatus(paraObj);
						}
					                
					}
					
					// System.out.println("mastoutput"+mastoutput);
					// System.out.println("unitOutput"+unitOutput);

					if (unitOutput > 0) {

						if (mastoutput > 0) {

							mav.addObject("msg", "Successfully added CAG Sub Para");

						} else {

							mav.addObject("err", "Failed to add CAG Sub Para");

						}
					}
				}
			}

		} catch (IRParasUserException e) {

			e.printStackTrace();

		} catch (TaskUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		mav.addObject("unitList", unitList);
		mav.addObject("finList", finList);
		mav.addObject("subparaList", subparaList);

		return mav;

	}
  //production
	@RequestMapping(value = "/parastsimis/getlistofgist")
	@ResponseBody
	public String getlistofgist(Integer cagGistId, SessionStatus status, HttpServletRequest request)
			throws LeagalUserException {

		// System.out.println("cagGistId"+cagGistId);
		CAGParas cagObj = new CAGParas();
		try {

			cagObj = iram.getCAGParaGist(cagGistId);

			// System.out.println("cagList"+cagList);
		} catch (IRParasUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new Gson().toJson(cagObj);

	}
//production
	@RequestMapping(value = "/parastsimis/getSubparaListbygistid")
	@ResponseBody
	public String getSubparaListbygistId(Integer cagGistId, SessionStatus status, HttpServletRequest request)
			throws LeagalUserException {

		// System.out.println("cagGistId"+cagGistId);
		List<CAGParasData> subparaList = new ArrayList<CAGParasData>();
		try {

			if (cagGistId != null) {
				if (cagGistId > 0) {

					subparaList = iram.selectCAGSubParaList(cagGistId);

				}

			}
			 //System.out.println("subparaList"+subparaList);
		} catch (IRParasUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new Gson().toJson(subparaList);

	}
    // production
	@RequestMapping(value = "/parastsimis/getParagistbyFinYear")
	@ResponseBody
	public String getParagistbyFinYear(String financialYear, SessionStatus status, HttpServletRequest request)
			throws LeagalUserException {

		// System.out.println("cagGistId"+cagGistId);
		List<CAGParas> cagObj = new ArrayList<CAGParas>();
		try {

			cagObj = iram.getCAGParaGistbyFinYear(financialYear);

			// System.out.println("cagList"+cagList);
		} catch (IRParasUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new Gson().toJson(cagObj);

	}
//production
	@RequestMapping(value = "/parastsimis/editcaggist")
	@ResponseBody
	public String editCAGGist(String financialYear, String actionTitle, String paraNumber, Integer cagGistId,
			SessionStatus status, HttpServletRequest request, HttpSession session) {

		User user = (User) session.getAttribute("userObj");
		Integer userId = 0;
		String userName = null;

		Integer updatedrows = 0;
		if (user != null) {

			if (user.getUserId() != null && user.getUserName() != null) {

				userId = user.getUserId();
				userName = user.getUserName();

			}

		}

		try {

			if (cagGistId > 0) {

				updatedrows = iram.editcagGistParas(cagGistId, financialYear, paraNumber, actionTitle, 
						userName);

			}
		} catch (IRParasUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new Gson().toJson(updatedrows);

	}
//production
	@RequestMapping(value = "/parastsimis/getSubparaListbyparaid")
	@ResponseBody
	public String getSubparaListbyparaId(Integer cagParaId, SessionStatus status, HttpServletRequest request)
			throws LeagalUserException {

		// System.out.println("cagGistId"+cagGistId);
		CAGParasData subparaList = new CAGParasData();
		try {

			if (cagParaId != null) {
				if (cagParaId > 0) {

					subparaList = iram.selectSubParaListbyPara(cagParaId);

				}

			}
			// System.out.println("cagList"+subparaList);
		} catch (IRParasUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new Gson().toJson(subparaList);

	}
 //production
	@RequestMapping(value = "/parastsimis/editsubpara")
	@ResponseBody
	public String editsubpara(CAGParasData paraObj, SessionStatus status, HttpServletRequest request,
			HttpSession session) throws LeagalUserException {

		// System.out.println("cagGistId"+cagGistId);
		CAGParasData subparaList = new CAGParasData();
		List<CAGParasData> paraDataList = new ArrayList<CAGParasData>();
		List<CAGParasData> unitMapAddList = new ArrayList<CAGParasData>();
		List<CAGParasData> unitMapDeleteList = new ArrayList<CAGParasData>();

		List<Integer> unitdeleteList = new ArrayList<Integer>();
		List<Integer> unitAddList = new ArrayList<Integer>();
		//System.out.println("coming in ajax");

		//System.out.println("coming in ajaxfrom database" + paraObj.getParaUnitIdList());
		//System.out.println("coming in ajax from jsp" + paraObj.getSubParaUnitList());

		Integer output1 = 0;
		Integer unitaddOutput = 0;
		Integer unitdeleteOutput = 0;
		try {
			User user = (User) session.getAttribute("userObj");

			if (user != null) {

				if ( user.getUserName() != null) {

					//paraObj.setUserId(user.getUserId());
					paraObj.setUserName(user.getUserName());
					paraObj.setCunitId(user.getUnitId());

				}

			}
			if (paraObj != null) {
				if (paraObj.getCagParaId() != null) {
					if (paraObj.getCagParaId() > 0) {

						String unitNames = paraObj.getSubParaUnitList();

						String unitsfromdb = paraObj.getParaUnitIdList();

						List<String> unitnamesList = Arrays.asList(unitNames.split("\\s*,\\s*"));

						List<String> fromdbunitList = Arrays.asList(unitsfromdb.split("\\s*,\\s*"));
						//String[] unitnamesListew =unitnames.split(",");

						List<Integer> unitList = iram.getUnitListUnitMap(paraObj.getCagParaId());

						if (fromdbunitList != null && unitnamesList != null) {

							for (int j = 0; j < fromdbunitList.size(); j++) {

								if (!unitnamesList.contains(fromdbunitList.get(j).toString())) {

									/*
									 * if(Integer.parseInt(unitnamesList.get(i).
									 * toString())!=Integer.parseInt(
									 * fromdbunitList.get(j).toString())){
									 */
									if (!unitdeleteList.contains(fromdbunitList.get(j).toString())) {
									// System.out.println("db"+fromdbunitList.get(j).toString());
										unitdeleteList.add(Integer.parseInt(fromdbunitList.get(j).toString()));
									}
									/* } */
								}

							}

							for (int i = 0; i < unitnamesList.size(); i++) {

								/* for(int j=0; j<fromdbunitList.size();j++){ */

								if (!fromdbunitList.contains(unitnamesList.get(i).toString())) {

									/*
									 * if(Integer.parseInt(unitnamesList.get(i).
									 * toString())!=Integer.parseInt(
									 * fromdbunitList.get(j).toString())){
									 */

									if (!unitAddList.contains(Integer.parseInt(unitnamesList.get(i)))) {
									// System.out.println("jsp"+unitnamesList.get(i).toString());
										unitAddList.add(Integer.parseInt(unitnamesList.get(i).toString()));
									}

									/* } */
								}

								/* } */

							}

							// System.out.println("unitAddList"+unitAddList);

							// System.out.println("unitDeleteList
							// "+unitdeleteList);

							if (unitAddList != null) {

								for (int k = 0; k < unitAddList.size(); k++) {

									CAGParasData unitwiseParaData1 = new CAGParasData();

									// System.out.println("unitVal"+unitnamesList.get(k).toString());
									unitwiseParaData1.setSubParaUnitId(Integer.parseInt(unitAddList.get(k).toString()));
									unitwiseParaData1.setCagGistId(paraObj.getCagGistId());
									unitwiseParaData1.setCagParaId(paraObj.getCagParaId());
									unitwiseParaData1.setUserId(paraObj.getUserId());
									unitwiseParaData1.setUserName(paraObj.getUserName());
									unitwiseParaData1.setPacincluded(paraObj.getPacincluded());
									unitwiseParaData1.setCunitId(paraObj.getCunitId());
									
									unitwiseParaData1.setParaStatusId(20);

									unitMapAddList.add(unitwiseParaData1);
								}

							}

							if (unitdeleteList != null) {

								for (int m = 0; m < unitdeleteList.size(); m++) {

									CAGParasData unitwiseParaData2 = new CAGParasData();

									// System.out.println("unitVal"+unitnamesList.get(i).toString());
									unitwiseParaData2
											.setSubParaUnitId(Integer.parseInt(unitdeleteList.get(m).toString()));

									unitwiseParaData2.setCagParaId(paraObj.getCagParaId());
									unitwiseParaData2.setUserId(paraObj.getUserId());
									unitwiseParaData2.setUserName(paraObj.getUserName());
									unitwiseParaData2.setParaStatusId(20);
									unitwiseParaData2.setCunitId(paraObj.getCunitId());

									unitMapDeleteList.add(unitwiseParaData2);
								}

							}

						}

						// System.out.println("unitMapAddList"+unitMapAddList);
					// System.out.println("unitMapdeleteList"+unitMapDeleteList);

						if (unitMapAddList != null) {
							if (unitMapAddList.size() > 0) {
								unitaddOutput = iram.insertcagparaunitmap(unitMapAddList);
							}
						}
						if (unitMapDeleteList != null) {
							if (unitMapDeleteList.size() > 0) {
								unitdeleteOutput = iram.deleteunitmapbyunit(unitMapDeleteList);
							}
						}

						output1 = iram.editcagsubParas(paraObj);

					}

				}

			}

			// System.out.println("cagList"+subparaList);
		} catch (IRParasUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new Gson().toJson(output1);

	}
	//production
	@RequestMapping(value = "/parastsimis/getcagreplybyreplyId")
	@ResponseBody
	public String GetcagreplybyreplyId(Integer cagReplyId, SessionStatus status, HttpServletRequest request)
			throws LeagalUserException {

		// System.out.println("cagGistId"+cagGistId);
		ReplyData repObj = new ReplyData();
		try {

			repObj = iram.getCAGReplybyreplyid(cagReplyId);

			// System.out.println("cagList"+cagList);
		} catch (IRParasUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new Gson().toJson(repObj);

	}
	//production
	@RequestMapping(value = "/parastsimis/editcagreply")
	@ResponseBody
	public String editcagreply(ReplyData replyObj, HttpServletRequest request,HttpSession session)
			throws LeagalUserException {

		// System.out.println("cagGistId"+cagGistId);
		Integer output=0;
		try {
			
			if(replyObj!=null && replyObj.getParaReplyId()!=null){
				
				User user = (User) session.getAttribute("userObj");

				if (user != null) {

					if ( user.getUserName() != null) {

						//replyObj.setUserId(user.getUserId());
						replyObj.setUserName(user.getUserName());

					}

				}

			 output = iram.editCagParasReply(replyObj);
			}
			// System.out.println("cagList"+cagList);
		} catch (IRParasUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new Gson().toJson(output);

	}
	
	
	@RequestMapping(value = "/parastsimis/add-para-data")
	public ModelAndView addParadata(@ModelAttribute("irparas") Paras paraObj, SessionStatus status,
			HttpSession session) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("add-para-data");
		
		
		List<Paras> finYearData = new ArrayList<Paras>();
		
		User user = (User) session.getAttribute("userObj");
		
		List<Unit> unitList = new ArrayList<Unit>();
		
		
		
		try {
			
			

			if(user!=null){
				
				unitList = tam.getUnitList();
				
				
				paraObj.setUnitId(user.getUnitId());
				paraObj.setCircleId(user.getCircleId());
				paraObj.setDivisionId(user.getDivisionId());
				paraObj.setSubdivisionId(user.getSubdivisionId());
				
			}
			finYearData=iram.getParaYearByOffice(paraObj);
			
			//System.out.println("finYearData"+finYearData);
		} catch (IRParasUserException | TaskUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		mav.addObject("finYearData",finYearData);
		
		mav.addObject("unitList", unitList);
		return mav;

	}
	
	@RequestMapping(value = "/parastsimis/get-cao-fin-year")
	@ResponseBody
	public String getCaoFinYearbyOffice(Paras paraObj, HttpServletRequest request,HttpSession session)
			throws LeagalUserException {

		// System.out.println("cagGistId"+cagGistId);
		Integer output=0;
		
		List<Paras> caofinyear = new ArrayList<Paras>();
		try {
			
			if(paraObj!=null && paraObj.getUnitId()!=null){
				
				User user = (User) session.getAttribute("userObj");

				if (user != null) {

					if (user.getUserName() != null) {

						paraObj.setUserId(user.getUserId());
						paraObj.setUserName(user.getUserName());

					}
					
				if(paraObj.getCircleId()==null){
					paraObj.setCircleId(0);
				}
				
				if(paraObj.getDivisionId()==null){
					paraObj.setDivisionId(0);
				}
					
					paraObj.setSubdivisionId(0);

				}

				caofinyear =iram.getParaYearByOffice(paraObj);
			}
			// System.out.println("cagList"+cagList);
		} catch (IRParasUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new Gson().toJson(caofinyear);

	}
	
	@RequestMapping(value = "/parastsimis/get-gist-by-year")
	@ResponseBody
	public String getparaGistByYear(Paras paraObj, HttpServletRequest request,HttpSession session)
			throws LeagalUserException {

		 
		Integer output=0;
		
		List<Paras> paragist = new ArrayList<Paras>();
		try {
			
			if(paraObj!=null && paraObj.getFinancialYear()!=null){
				
				User user = (User) session.getAttribute("userObj");

				if (user != null) {

					if (user.getUserName() != null) {

						paraObj.setUserId(user.getUserId());
						paraObj.setUserName(user.getUserName());

					}
					
					
				
					paraObj.setSubdivisionId(0);

				}
				
				//System.out.println("paraObj"+paraObj);
                if(paraObj.getUnitId()!=null){
                	if(paraObj.getCircleId()==null){
                		paraObj.setCircleId(0);
                	}
                	if(paraObj.getDivisionId()==null){
                		paraObj.setDivisionId(0);
                	}
				paragist = iram.getParagistByYearByOffice(paraObj);
}
			}
			// System.out.println("cagList"+cagList);
		} catch (IRParasUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new Gson().toJson(paragist);

	}
	
	
	@RequestMapping(value = "/parastsimis/get-subpara-data-paraid")
	@ResponseBody
	public String getsubparadataparaid(Paras paraObj, HttpServletRequest request,HttpSession session)
			throws LeagalUserException {

		// System.out.println("cagGistId"+cagGistId);
		Integer output=0;
		
		List<Paras> paragist = new ArrayList<Paras>();
		try {
			
			if(paraObj!=null && paraObj.getParaId()!=null){
				
				User user = (User) session.getAttribute("userObj");

				if (user != null) {

					if (user.getUserName() != null) {

						paraObj.setUserId(user.getUserId());
						paraObj.setUserName(user.getUserName());

					}
					
					/*paraObj.setUnitId(user.getUnitId());
					paraObj.setCircleId(user.getCircleId());
					paraObj.setDivisionId(user.getDivisionId());
					paraObj.setSubdivisionId(user.getSubdivisionId());
*/
				}

				paragist = iram.getSubParadataByParaId(paraObj);
			}
			// System.out.println("cagList"+cagList);
		} catch (IRParasUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new Gson().toJson(paragist);

	}
	
	
	
	@RequestMapping(value = "/parastsimis/add-para-info")
	@ResponseBody
	public String AddParInfo( Paras paraObj, HttpServletRequest request,
			HttpSession session, SessionStatus status) {
		ModelAndView mav = new ModelAndView();

		// System.out.println("irparascomehere");

		mav.setViewName("add-para-data");
		Integer paraOutput = 0;
		Integer replyoutput = 0;
		Integer paraDocOutput = 0;
		Integer paraTroutput = 0;
		
		Integer newparaOutput=0;
		
		User user = (User) session.getAttribute("userObj");
		try {
		if(paraObj!=null){
			
			if (user != null) {
				paraObj.setUserId(user.getUserId());

				paraObj.setUserName(user.getUserName());

			}
			//System.out.println("paraObjnew"+paraObj);	
			
			
			if(paraObj.getParatabId()!=null){
				
				//tab1start 
				
				if(paraObj.getParatabId()==1){		
			if ( paraObj.getUnitId() != null && paraObj.getParaStatusId() != null) {				
				
				if(paraObj.getActionTitle()!=null){
			
					paraOutput = iram.insertParasDataInfo(paraObj);
				
				}			
			}
			}
				//end tab1
				
				if(paraObj.getParatabId()==2){		
					if ( paraObj.getParaId()!=null && paraObj.getParasAction() != null) {				
						
						if(paraObj.getParaId()>0){
							//System.out.println("paraObj.getParatabId()"+paraObj.getParatabId());
					
							paraOutput = iram.insertParaMasterSub(paraObj);
						}
						
									
					}
					}//end tab2
				
				
				if(paraObj.getParatabId()==3){		
					if ( paraObj.getParaId()!=null && paraObj.getSubParaId() != null) {		
						
						// System.out.println("cominghere"+paraObj.getParaId()+"--"+paraObj.getSubParaId());
						
						if ( paraObj.getParaId()>0 && paraObj.getSubParaId() >0) {	
						if (paraObj.getReplyDataList() != null) {
							if (paraObj.getReplyDataList().size() > 0) {

								// System.out.println("cominghere"+replyoutput);
								paraOutput = iram.insertParasReply(paraObj);

							}
						}
						}
						
									
					}
					} //end tab3
				
				
				
				
				List<Paras> paraDBSUbObj2 = new ArrayList<Paras>();
				List<ParaDocuments> doclist2 = new ArrayList<ParaDocuments>();
				List<ReplyData> replyList2 = new ArrayList<ReplyData>();
				List<ReplyData> oldreplyList2 = new ArrayList<ReplyData>();
				List<ParaDocuments> olddoclist2 = new ArrayList<ParaDocuments>();
				Paras paraDBObj2 = new Paras();
				Integer subparaoutput=0;
				
				if(paraObj.getParatabId()==5){
					
					
					if (paraObj.getTransferFlag() == true) {
						
						//System.out.println("coming here"+paraObj.getTransferFlag());
						
						if((paraObj.getParaId()!=0||paraObj.getParaId()!=null) )
						
						paraDBObj2 = iram.getParaforedit(paraObj.getParaId());
						
						//paraDBSUbObj2=iram.getSubParaforedit(paraObj.getParaId());
						
						//iram.getSubParabysubparaId(paraObj.getSubParaId());

						// System.out.println("sectionId"+paraDBObj.getSectionId());
						
						paraDBSUbObj2=iram.getSubParaforedit(paraObj.getParaId());

					
                        //get sub para id data 
						doclist2 = irrm.getDocsByParaId(paraObj.getParaId());

						
                       //get by sub paraId
						replyList2 = irrm.getReplybyParaId(paraObj.getParaId());

					
					

						paraTroutput = iram.editParasTransfer(paraObj);

						if (paraTroutput != null) {
							
							//System.out.println("paraTroutput"+paraTroutput);

							if (paraTroutput > 0) {

								paraObj.setUnitId(paraObj.getTunitId());
								if(paraObj.getTcircleId()!=null){
								paraObj.setCircleId(paraObj.getTcircleId());
								}
								if(paraObj.getTcircleId()==null){
									paraObj.setCircleId(0);
									}
								if(paraObj.getTdivisionId()!=null){
								paraObj.setDivisionId(paraObj.getTdivisionId());
								}
								if(paraObj.getTdivisionId()==null){
									paraObj.setDivisionId(0);
									}
								paraObj.setSubdivisionId(0);
								paraObj.setTunitId(0);
								paraObj.setTcircleId(0);
								paraObj.setTdivisionId(0);
								paraObj.setTsubdivisionId(0);

								if (paraObj.getUnitId() != null) {
									
									//System.out.println("paraObj.getUnitId()"+paraObj.getUnitId());

									if (paraObj.getUnitId() > 0 && paraObj.getTunitId() == 0) {
										
									//	System.out.println(" and paraObj.getTunitId()"+paraObj.getTunitId());

										//paraOutput = iram.editParas(paraObj);
										
										//start 21032021 to transfer data
										
										
										if (paraObj != null) {
											if (paraObj.getParaId()> 0) {
												
												paraObj.setFinancialYear(paraDBObj2.getFinancialYear());  
												paraObj.setParaNumber(paraDBObj2.getParaNumber());
												paraObj.setFileNumber(paraDBObj2.getFileNumber());
												paraObj.setLarNumber(paraDBObj2.getLarNumber());
												paraObj.setSectionId(paraDBObj2.getSectionId());
												paraObj.setParaStatusId(paraDBObj2.getParaStatusId());										
												
												paraObj.setAuditDateFrom(paraDBObj2.getAuditDateFrom());
												paraObj.setAuditDateTo(paraDBObj2.getAuditDateTo());
												paraObj.setPrintCAG(paraDBObj2.getPrintCAG());
												paraObj.setInclPropCAG(paraDBObj2.getInclPropCAG());
												paraObj.setActionTitle(paraDBObj2.getActionTitle());
												paraObj.setOldParaId(paraDBObj2.getParaId());
												
												
												
												//System.out.println("paraObj insert"+paraObj);
												// insert parasa when status is not in trasfer
												
													newparaOutput = iram.insertParasDataInfo(paraObj);
													
													

									//	System.out.println("newparaOutput"+newparaOutput+"newparaOutput"+newparaOutput);


											}
										}

									

										if (newparaOutput != null) {

											if (newparaOutput > 0) {

												paraObj.setParaId(newparaOutput);
												
												
												if (paraObj != null) {
													if (paraObj.getParaId() > 0) {
														
														/*paraObj.setParasAction(paraDBSUbObj2.get);
														paraObj.setParaStatusId(paraStatusId);
														paraObj.setSubcategory(subcategory);*/
														
														for(int i=0; i<paraDBSUbObj2.size(); i++){
															
															Integer oldSubParaId=paraDBSUbObj2.get(i).getSubParaId();
															
															paraObj.setParasAction(paraDBSUbObj2.get(i).getParasAction());
															paraObj.setSubcategory(paraDBSUbObj2.get(i).getSubcategory());
															paraObj.setParaStatusId(paraDBSUbObj2.get(i).getParaStatusId());
															paraObj.setParareasonsDelay(paraDBSUbObj2.get(i).getParareasonsDelay());
															paraObj.setOldSubParaId(oldSubParaId);
															

														
														subparaoutput = iram.insertParaMasterSub(paraObj);
														
														
														if(subparaoutput>0){
															
															 
															
															//paraObj.setSubParaId(subparaoutput);
															
															
															if(replyList2!=null){
																
																for(int j=0 ; j<replyList2.size() ; j++){
																	
																
																	if(oldSubParaId.equals(replyList2.get(j).getSubParaId())){
																		
																	//	System.out.println("oldSubParaId"+oldSubParaId );
																	//	System.out.println("subparaoutput"+subparaoutput );
																		
																	//	System.out.println("replyList2.get(j).getSubParaId()"+replyList2.get(j).getSubParaId());
																		  ReplyData rrd= new ReplyData();
																		  
																		  rrd.setReplyAction(replyList2.get(j).getReplyAction());
																		  rrd.setReplyRemarks(replyList2.get(j).getReplyRemarks());
																		  rrd.setReplyDate(replyList2.get(j).getReplyDate());
																		  rrd.setSubParaId(subparaoutput);
																		  rrd.setParaReplyId(replyList2.get(j).getParaReplyId());
																		//oldreplyList2.add(replyList2.get(j));
																		  oldreplyList2.add(rrd);
																		  
																	//	  System.out.println("oldreplyList2"+oldreplyList2);
																	
																		//replyList2.remove(j);
																		
																	}
																	
																
															
																
														
															
																
																}
																
													
																
																
															}
															
															
															if(doclist2!=null)	{	
																
																
                                                                 for(int k=0 ; k<doclist2.size() ; k++){
                                                                	 
                                                                	// System.out.println("doctspoldSubParaId"+oldSubParaId);
                                                                	
                                                                	// System.out.println("doctspoldSubParaId"+doclist2.get(k).getSubParaId());
																	
																	if(oldSubParaId.equals(doclist2.get(k).getSubParaId())){
																		
																		// System.out.println("doctspoldSubParaId"+oldSubParaId);
																		 ParaDocuments doc= new ParaDocuments();
																		  
																		 doc.setDocId(doclist2.get(k).getDocId());
																		 doc.setParaDocLocation(doclist2.get(k).getParaDocLocation());
																		 doc.setParaDocOriginalName(doclist2.get(k).getParaDocOriginalName());
																		 doc.setParaDocName(doclist2.get(k).getParaDocName());
																		 doc.setSubParaId(subparaoutput);
																		 
																		//oldreplyList2.add(replyList2.get(j));
																		  olddoclist2.add(doc);
																		  
																		
																		
																		
																	//	olddoclist2.add(doclist2.get(k));
																		//doclist2.remove(k);
																	}
																	
																
																
																
																}
                                                                 
                                                             	
																
																//remove paraId and subparadid from doclist
																
															//	System.out.println("doclist2"+doclist2);
																
																
																
																
														
																
																	
															}

															
															//System.out.println("paraObj.getSUbParaId"+paraObj.getSubParaId());
														}
														
														}
														
														if(oldreplyList2!=null){
															paraObj.setReplyDataList(oldreplyList2);
															
															}
															
															//System.out.println("paraObj.replydatalist"+paraObj.getReplyDataList());
															
															if(paraObj.getReplyDataList()!=null){
																replyoutput = iram.insertParasReply(paraObj);	
															}
															if(olddoclist2!=null){
															paraObj.setParadocList(olddoclist2);
															}
															//System.out.println("paraObj.getdoclist2"+paraObj.getParadocList());
															
															if(paraObj.getParadocList()!=null){
																paraDocOutput = iram.insertParasDocuments(paraObj);
															}
															
															

													}
												}
						                        
												
												

											
												
														// System.out.println("cominghere"+replyoutput);
																												
													
														

													}
												}

											}

											
										}
										
										//end transfer data and insert 

										
									}
								}
                        if(newparaOutput>0||subparaoutput>0||replyoutput>0||paraDocOutput>0){
                        	
                        	if(newparaOutput>0){
                        	paraOutput=1;
                        	}
                        	if(subparaoutput>0){
                            	paraOutput=1;
                            	}
                        	if(replyoutput>0){
                            	paraOutput=1;
                            	}
                        	if(paraDocOutput>0){
                            	paraOutput=1;
                            	}
                        	
                        	
                        }
					
				}
				}
					
						
			}
		
			
			
		}
		
		} catch (IRParasUserException e ) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return new Gson().toJson(paraOutput);
		
	}
	
	
	@RequestMapping(value = "/parastsimis/add-doc-info")
	@ResponseBody
	public String AdddocInfo( Paras paraObj,  MultipartHttpServletRequest request,
			HttpSession session, SessionStatus status) {
	
	List<String> fileNameList = new ArrayList<String>();
	List<MultipartFile> uploadFile = request.getFiles("uploadFile");
	Integer paraOutput=0;
	User user = (User) session.getAttribute("userObj");
	try {
		
		if(paraObj!=null){
			
			if (user != null) {
				paraObj.setUserId(user.getUserId());

				paraObj.setUserName(user.getUserName());

			}
	if(paraObj.getParatabId()==4){		
		if ( paraObj.getParaId()!=null && paraObj.getSubParaId() != null) {		
			
			
			if ( paraObj.getParaId()>0 && paraObj.getSubParaId() >0) {		
		//	 System.out.println("cominghere"+paraObj.getParaId()+"--"+paraObj.getSubParaId());
			
			
			if (paraObj.getUploadFile() != null ) {
				if (paraObj.getUploadFile().size() >= 1){

					// System.out.println("cominghere");
					//paraOutput = iram.insertParasReply(paraObj);
					 
					 
					 List<MultipartFile> files = paraObj.getUploadFile();

						List<String> fileNames = new ArrayList<String>();

						List<ParaDocuments> fileList = new ArrayList<ParaDocuments>();

						String filetitile = null;
						String filetitilenew = null;
						// System.out.println("filesize"+files.size()+"--"+files);
						if (null != files && files.size() >= 1) {
							for (MultipartFile multipartFile : files) {

								String fileName = multipartFile.getOriginalFilename();
								// String FileType = (
								// files).get(0).getContentType();
								fileNames.add(fileName);
								// Handle file content -
								// multipartFile.getInputStream()

							}

							// System.out.println("2nd file
							// size"+fileNames.size());

							for (int i = 0; i < fileNames.size(); i++) {
								filetitile = fileNames.get(i);

								// System.out.println("filetitile"+filetitile);

								if (!filetitile.isEmpty()) {
									Integer maxId = iram.getCountOfParaDocs() + 1;
									// System.out.println("maxId"+maxId);

									String[] temps = filetitile.split(Pattern.quote("."));

									Integer paraNum = paraObj.getParaId();

									String docName = temps[0];
									String SaveName = paraNum.toString() + maxId.toString() + docName + "."
											+ temps[temps.length - 1];

									maxId++;
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
 
							// System.out.println("filetitilenew"+filetitilenew);
							//String rootPath = System.getProperty("catalina.base");
							// local
							// File dir = new File(rootPath +
							// File.separator + "webapps" +
							// File.separator + "ICADLeagalWebApp" +
							// File.separator +
							// "uploadedFiles"+File.separator+"IRParas");
							// server
							 
							  if (absolutePath == null) {
								    // fallback if getRealPath returns null (some servlet containers do this)
								    absolutePath = new File(".").getCanonicalPath() + RELATIVE_DIR;
								}

							
							//File dir = new File(File.separator + "Uploads" + File.separator + "tsimis" + File.separator + "uploadedFiles"
									//+ File.separator + "IRParas");
							  
							  File dir = new File(absolutePath);

							//File dir = new File(rootPath + File.separator + "webapps" + File.separator + "tsimis" + File.separator + "uploadedFiles"
								//	+ File.separator + "IRParas");
							if (!dir.exists())
								dir.mkdirs();

							paraObj.setFileLocation(dir.getAbsolutePath());

							for (int i = 0; i < files.size(); i++) {

								// File serverFile = new
								// File(dir.getAbsolutePath()+
								// File.separator +
								// files.get(i).getOriginalFilename());
								if (!fileNameList.isEmpty()) {

									if (fileNameList.size() > 0) {

										String paraDocName = fileNameList.get(i);
										ParaDocuments tf = new ParaDocuments();

										tf.setParaDocName(paraDocName);
										tf.setParaDocOriginalName(files.get(i).getOriginalFilename());
										tf.setParaDocLocation(
												dir.getAbsolutePath() + File.separator + paraDocName);

										// System.out.println("serverFile"+paraDocName);
										fileList.add(tf);

									
											files.get(i).transferTo(
													new File(dir.getAbsolutePath() + File.separator + paraDocName));
										

									}

								}
							}

							if (fileList.size() > 0) {
								paraObj.setParadocList(fileList);
								;

							}

							paraOutput = iram.insertParasDocuments(paraObj);

						}

				}
			

				}
			}
			
		}				
	} //end of tab4
		}
		
	} catch (IllegalStateException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IRParasUserException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return new Gson().toJson(paraOutput);

	}
	
	@RequestMapping(value = "/parastsimis/get-para-gist-paraid")
	@ResponseBody
	public String getParaGistByParaIdparaid(Paras paraObj, HttpServletRequest request,HttpSession session)
			throws LeagalUserException {

		// System.out.println("cagGistId"+cagGistId);
		Integer output=0;
		
		List<Paras> paragist = new ArrayList<Paras>();
		
		Paras paraDBObj2 = new Paras();
		try {
			
			if(paraObj!=null && paraObj.getParaId()!=null){
				
				User user = (User) session.getAttribute("userObj");

				if (user != null) {

					if (user.getUserName() != null) {

						paraObj.setUserId(user.getUserId());
						paraObj.setUserName(user.getUserName());

					}
					
					/*paraObj.setUnitId(user.getUnitId());
					paraObj.setCircleId(user.getCircleId());
					paraObj.setDivisionId(user.getDivisionId());
					paraObj.setSubdivisionId(user.getSubdivisionId());
*/
				}

				paraDBObj2 = iram.getParaforedit(paraObj.getParaId());
				
				//paragist.add(paraDBObj2);
			}
			// System.out.println("cagList"+cagList);
		} catch (IRParasUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new Gson().toJson(paraDBObj2);

	}
	
	
	@RequestMapping(value = "/parastsimis/edit-para-gist")
	@ResponseBody
	public String editPparagist(Paras paraObj, HttpServletRequest request,HttpSession session)
			throws LeagalUserException {

	//	System.out.println("paraObj"+paraObj);
		Integer output=0;
		
		//List<Paras> paragist = new ArrayList<Paras>();
		
		//Paras paraDBObj2 = new Paras();
		try {
			
			if(paraObj!=null && paraObj.getParaId()!=null){
				
				User user = (User) session.getAttribute("userObj");

				if (user != null) {

					if (user.getUserName() != null) {

						paraObj.setUserId(user.getUserId());
						paraObj.setUserName(user.getUserName());

					}
					
				
				}
				
			//	System.out.println("output"+output);

				output = iram.editParas(paraObj);
				
			//	System.out.println("output"+output);
				
				//paragist.add(paraDBObj2);
			}
			// System.out.println("cagList"+cagList);
		} catch (IRParasUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new Gson().toJson(output);

	}
	
	
	@RequestMapping(value = "/parastsimis/delete-ir-paras")
	@ResponseBody
	public String deleteirGistparas(@ModelAttribute("deleteparas") Paras paraObj, SessionStatus status,
			HttpSession session) {
		
		Integer output = 0;
		User	user = (User) session.getAttribute("userObj");
		
		// System.out.println(user);
		try {
			
				if (paraObj.getParaId() != null ) {

					output = iram.deleteParasReplyDocs(paraObj.getParaId(), user.getUserId(), user.getUserName());

					

					}

		}  catch (IRParasUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	

		return new Gson().toJson(output);

	}
	
	
	
	@RequestMapping(value = "/parastsimis/get-edit-sub-para")
	@ResponseBody
	public String geteditSubPara(@ModelAttribute("subparas") Paras paraObj, SessionStatus status,
			HttpSession session) {
		
		Integer output = 0;
		
		List<Paras> subParaList = new ArrayList<Paras>();
		
		
		// System.out.println(user);
		try {
			
if( paraObj.getSubParaId()!=null){
				
				User user = (User) session.getAttribute("userObj");

				if (user != null) {

					if (user.getUserName() != null) {

						paraObj.setUserId(user.getUserId());
						paraObj.setUserName(user.getUserName());

					}
					
				
				}
				
			//	System.out.println("output"+output);

				
				if (paraObj.getSubParaId() != null ) {

					subParaList = iram.getSubParabysubparaId(paraObj.getSubParaId());

					

					}

				
			//	System.out.println("output"+output);
				
				//paragist.add(paraDBObj2);
			}

		

		}  catch (IRParasUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	

		return new Gson().toJson(subParaList);

	}
	
	
	
	
	@RequestMapping(value = "/parastsimis/edit-sub-para-data")
	@ResponseBody
	public String editSubParaData(Paras paraObj, HttpServletRequest request,HttpSession session)
			throws IRParasUserException {

		System.out.println("paraObj"+paraObj);
		Integer output=0;
		
		//List<Paras> paragist = new ArrayList<Paras>();
		
		//Paras paraDBObj2 = new Paras();
		try {
			
			if(paraObj!=null && paraObj.getParaId()!=null){
				
				User user = (User) session.getAttribute("userObj");

				if (user != null) {

					if (user.getUserName() != null) {

						paraObj.setUserId(user.getUserId());
						paraObj.setUserName(user.getUserName());

					}
					
				
				}
				
			//	System.out.println("output"+output);

			
					
				
						
						                                                                                                                                    
				
				output = iram.editSubParas(paraObj);
				
					}
					
					
				
				
				
			//	System.out.println("output"+output);
				
				//paragist.add(paraDBObj2);
			
			// System.out.println("cagList"+cagList);
		} catch (IRParasUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new Gson().toJson(output);

	}
	
	
	@RequestMapping(value = "/parastsimis/delete-sub-paras")
	@ResponseBody
	public String deleteSubParas(@ModelAttribute("deleteparas") Paras paraObj, SessionStatus status,
			HttpSession session) {
		
		Integer output = 0;
		
		
		 System.out.println(paraObj);
		try {
			
			if (paraObj.getSubParaId() != null ) {

		
			User user = (User) session.getAttribute("userObj");

			if (user != null) {

				if (user.getUserName() != null) {

					paraObj.setUserId(user.getUserId());
					paraObj.setUserName(user.getUserName());

				}
				
			
			}
			
			
					output = iram.deleteSubParaReplyDocs(paraObj);

					
					}

				

			

		}  catch (IRParasUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	

		return new Gson().toJson(output);

	}
	
	
	
	
	
	
	@RequestMapping(value = "/parastsimis/get-reply-data-edit")
	@ResponseBody
	public String getReplySubData(@ModelAttribute("subparas") Paras paraObj, SessionStatus status,
			HttpSession session) {
		
		Integer output = 0;
		
		List<ReplyData> replyList = new ArrayList<ReplyData>();
		
		
		// System.out.println(user);
		try {
			
if( paraObj.getSubParaId()!=null){
				
				User user = (User) session.getAttribute("userObj");

				if (user != null) {

					if (user.getUserName() != null) {

						paraObj.setUserId(user.getUserId());
						paraObj.setUserName(user.getUserName());

					}
					
				
				}
				
			//	System.out.println("output"+output);

				
				if (paraObj.getSubParaId() != null ) {

					replyList = iram.getReplybySubParaId(paraObj.getSubParaId());					

					}

				
			
			}

		

		}  catch (IRParasUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		return new Gson().toJson(replyList);

	}
	
	@RequestMapping(value = "/parastsimis/get-reply-data-replyid")
	@ResponseBody
	public String getReplyDataReplyId(@ModelAttribute("subparas") Paras paraObj, SessionStatus status,
			HttpSession session) {
		
		Integer output = 0;
		
		List<ReplyData> replyList = new ArrayList<ReplyData>();
		
		
		// System.out.println(user);
		try {
			
if( paraObj.getParaReplyId()!=null){
				
				User user = (User) session.getAttribute("userObj");

				if (user != null) {

					if (user.getUserName() != null) {

						paraObj.setUserId(user.getUserId());
						paraObj.setUserName(user.getUserName());

					}
					
				
				}
				
			//	System.out.println("output"+output);

		
					replyList = iram.getReplybyparaReplyId(paraObj.getParaReplyId())	;	

					

				
			
			}

		

		}  catch (IRParasUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		return new Gson().toJson(replyList);

	}
	
	
	@RequestMapping(value = "/parastsimis/edit-reply-para-data")
	@ResponseBody
	public String editReplyParaData(ReplyData repObj, HttpServletRequest request,HttpSession session)
			throws IRParasUserException {

	//	System.out.println("repObj"+repObj);
		Integer output=0;
		
		//List<Paras> paragist = new ArrayList<Paras>();
		
		//Paras paraDBObj2 = new Paras();
		try {
			
			if(repObj!=null && repObj.getParaReplyId()!=null){
				
				User user = (User) session.getAttribute("userObj");

				if (user != null) {

					if (user.getUserName() != null) {

						repObj.setUserId(user.getUserId());
						repObj.setUserName(user.getUserName());

					}
					
				
				}
				
			//	System.out.println("output"+output);

			
					
				
						
						                                                                                                                                    
				
				output = iram.editParasReplyByReplyId(repObj);
				
					}
					
					
				
				
				
			//	System.out.println("output"+output);
				
				//paragist.add(paraDBObj2);
			
			// System.out.println("cagList"+cagList);
		} catch (IRParasUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new Gson().toJson(output);

	}
	
	
	@RequestMapping(value = "/parastsimis/delete-reply-data")
	@ResponseBody
	public String deleteReplysbyReplyId(@ModelAttribute("deleteparas") ReplyData repObj, SessionStatus status,
			HttpSession session) {
		
		Integer output = 0;
		
		
		// System.out.println(user);
		try {
			
				if (repObj.getParaReplyId() != null ) {
					
					User user = (User) session.getAttribute("userObj");

					if (user != null) {

						if (user.getUserName() != null) {

							repObj.setUserId(user.getUserId());
							repObj.setUserName(user.getUserName());

						}
						
					
					}

					output =  iram.deleteParasReplyById(repObj.getParaReplyId(), repObj.getUserId(),repObj.getUserName());

					

					}

		}  catch (IRParasUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	

		return new Gson().toJson(output);

	}
	
	@RequestMapping(value = "/parastsimis/get-docs-data-delete")
	@ResponseBody
	public String getParaDocumentsBySubParaId(@ModelAttribute("subparas") Paras paraObj, SessionStatus status,
			HttpSession session) {
		
		Integer output = 0;
		
		List<ParaDocuments> docList = new ArrayList<ParaDocuments>();
		
		
		// System.out.println(user);
		try {
			
if( paraObj.getSubParaId()!=null){
				
				User user = (User) session.getAttribute("userObj");

				if (user != null) {

					if (user.getUserName() != null) {

						paraObj.setUserId(user.getUserId());
						paraObj.setUserName(user.getUserName());

					}
					
				
				}
				
			//	System.out.println("output"+output);

				
				if (paraObj.getSubParaId() != null ) {

					docList = iram.getDocsBySubParaId(paraObj.getSubParaId())	;			

					}

				
			
			}

		

		}  catch (IRParasUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		return new Gson().toJson(docList);

	}
	
	@RequestMapping(value = "/parastsimis/delete-doc-by-docid")
	@ResponseBody
	public String deleteDocsbydocId(@ModelAttribute("deleteparas") ParaDocuments docObj, SessionStatus status,
			HttpSession session) {
		
		Integer output = 0;
		
		// System.out.println(user);
		try {
			
				if (docObj.getDocId() != null ) {
					
					User user = (User) session.getAttribute("userObj");

					if (user != null) {

						if (user.getUserName() != null) {

							docObj.setUserId(user.getUserId());
							docObj.setUserName(user.getUserName());

						}
						
					
					}

					output =  iram.deleteParasDocsById(docObj.getDocId(), docObj.getUserId(), docObj.getUserName());

					}

		}  catch (IRParasUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	

		return new Gson().toJson(output);

	}
	
@RequestMapping(value = "/web/send-mail")
	@ResponseBody
	public String sendanEmail( officeDataSend  dataObj
			, SessionStatus status,
			HttpSession sessionnew) {
		
		Integer output=0;
//	   System.out.println("dataObj.getLatestemailId()"+dataObj.getLatestemailId());
		
		List<officeDataSend> offList = new ArrayList<officeDataSend>();
		
		String userName=null;
		String pwd=null;
		String datatoSend=null;
			
			try {
				if(dataObj!=null){
				offList=irrm.getOfficeUserNamePwd(dataObj);
				if(offList!=null){
			    	
			    	if(offList.size()>0){
			    		
			    		for (int i=0; i< offList.size();i++){
			    		userName=	offList.get(i).getUserName();
			    		pwd=  offList.get(i).getPwd();
			    //		System.out.println("in loop userName "+userName+"pwd "+pwd);	
			    		}
			    	}
			    //	System.out.println("userName "+userName+"pwd "+pwd);	
			    	 if(userName!=null && pwd!=null){
			    		    datatoSend ="User Name:"+"	"+userName+"       "+"Password:"+"	"+pwd+"   "+"Thank you." ;
			    		    output=1;
			    		    
			    		    EmailConfig emailUtility = new EmailConfig();
			    			emailUtility.sendMail(dataObj.getLatestemailId(), "Office Login Details", datatoSend );
			    		    }
			    		    
			    		    if(userName==null || pwd==null){
			    		    	
			    		    	 output=-1;
			    		    }
			    }
				}
			} catch (IRParasUserException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	  
		return new Gson().toJson(output);

		}

@RequestMapping(value = "/web/get-mail")
@ResponseBody
public String getanEmail( officeDataSend  dataObj
		, SessionStatus status,
		HttpSession sessionnew) {
	
	Integer output=0;
  // System.out.println("getanEmail");
	
	List<officeDataSend> offList = new ArrayList<officeDataSend>();
	
	String unitId=null;
	String circleId=null;
	String divisionId=null;
	
	String email=null;
//	String pwd=null;
//	String datatoSend=null;
		
		try {
			if(dataObj!=null){
	//			System.out.println("dataObj"+dataObj);
			offList=irrm.getOfficeEmailId(dataObj);
		//	System.out.println("offList"+offList);
			if(offList!=null){
		    	
		    	if(offList.size()>0){
		    		for (int i=0; i< offList.size();i++){
		    			email=	offList.get(i).getLatestemailId();
		   		//	System.out.println("offList.get(i).getLatestemailId()"+offList.get(i).getLatestemailId());
		    			    			
		    		}
		    	}
			}	
		    	
		    }
			
			//System.out.println("email"+email);
		} catch (IRParasUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
  
	return new Gson().toJson(email);

	}


@RequestMapping(value = "/parastsimis/add-status")
@ResponseBody
public String insertaddstatus(@ModelAttribute("cagparasdata") CAGParasData paraObj, SessionStatus status,
		HttpSession session) {
	
	Integer output = 0;
	
	
	
	
	 //System.out.println(paraObj.getCagGistId());
	// System.out.println(paraObj.getCagParaId());
	 
	// System.out.println(paraObj.getParaStatusId());
	try {
		
if( paraObj.getCagGistId()!=null){
			
			User user = (User) session.getAttribute("userObj");

			if (user != null) {

				if (user.getUserName() != null) {

					
					paraObj.setUserName(user.getUserName());
					
					paraObj.setCunitId(user.getUnitId());
					
					

				}
				
			
			}
			
		//	System.out.println("output"+output);

			
			if (paraObj.getCagParaId() != null ) {

				output=iram.insertcagStatus(paraObj);

				

				}

			
		//	System.out.println("output"+output);
			
			//paragist.add(paraDBObj2);
		}

	

	}  catch (IRParasUserException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	


	return new Gson().toJson(output);

}

}
