package in.ts.icad.leagal.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.jsoup.Jsoup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

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
import in.ts.icad.leagal.model.ParaDocuments;
import in.ts.icad.leagal.model.Paras;
import in.ts.icad.leagal.model.ReplyData;
import in.ts.icad.leagal.model.Unit;
import in.ts.icad.leagal.model.User;
import in.ts.icad.leagal.util.EvaluateInfixExpression;
import in.ts.icad.leagal.util.PasswordGenerator;

@Controller
public class IRParasReportController {
	
	@Autowired
	private TaskAdminManager tam;
	
	@Autowired
	private IRParasAdminManager iram;
	
	@Autowired
	private IRParasReportManager irrm;
	
	
	@RequestMapping(value="/parasreport/parastatus")
	public ModelAndView parasAbstract(@ModelAttribute("irparas") Paras paraObj,SessionStatus status, HttpSession session){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("parastatus");
		
		List<Paras> paraListCount= new ArrayList<Paras>();
		
		
		Integer totalParasAll=0;
		Integer secAAll=0;
		Integer secBAll=0;
		Integer DroppedAll=0;
		Integer Balanceall=0;
		Integer replySentAll=0;
		Integer replyNaAll=0;
		Integer TrAll=0;
		
		
		try {
			
			User user = (User) session.getAttribute("userObj");
			
			if (user != null) {
				
			//	System.out.println("user"+user);
				paraObj.setUserId(user.getUserId());

				paraObj.setUserName(user.getUserName());
			
				paraObj.setUnitId(user.getUnitId());
			
				paraObj.setCircleId(user.getCircleId());
				
			
				
				
				
				paraObj.setDivisionId(user.getDivisionId());	
				
				
			
				paraObj.setSubdivisionId(user.getSubdivisionId());
				
				
			//	System.out.println("paraObj"+paraObj);
				

			}
			
			
					paraListCount=irrm.getParasAbstarctCount(paraObj);
					
					if(paraListCount!=null){
						
						if(paraListCount.size()>0){
					
					Integer len =paraListCount.size();
					
					for(int i=0; i<len ;i++){
						
						totalParasAll=totalParasAll+paraListCount.get(i).getTotalParas();
								secAAll=secAAll+paraListCount.get(i).getSecAParasCount();
								secBAll=secBAll+paraListCount.get(i).getSecBParasCount();
								DroppedAll=DroppedAll+paraListCount.get(i).getDroppedCount();
								Balanceall=Balanceall+paraListCount.get(i).getBalanceParas();
								replySentAll=replySentAll+paraListCount.get(i).getReplySent();
								replyNaAll=replyNaAll+paraListCount.get(i).getReplyNotSent();
								TrAll=TrAll+paraListCount.get(i).getTransfrred();
								
								
								
						
						
					}
					
						}
					
					}
			
				
		} catch (IRParasUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		mav.addObject("paraListCount",paraListCount);
		mav.addObject("totalParasAll",totalParasAll);
		
		mav.addObject("secAAll",secAAll);
		mav.addObject("secBAll",secBAll);
		mav.addObject("DroppedAll",DroppedAll);
		mav.addObject("Balanceall",Balanceall);
		mav.addObject("replySentAll",replySentAll);
		mav.addObject("replyNaAll",replyNaAll);
		mav.addObject("TrAll",TrAll);
			
		return mav;
		
	}
	
	
	@RequestMapping(value="/parasreport/parasDetail")
	public ModelAndView parasDetailTotal(@ModelAttribute("irparas") Paras paraObj,SessionStatus status, HttpSession session){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("paraDetailTotal");
		
		List<Paras> paraListTotal= new ArrayList<Paras>();
		
		List<Paras> paraListTotalByUnit= new ArrayList<Paras>();
		
		Boolean flag=true;
	
		Integer reportType=0;
		
		try {
			
			
		
			
		//System.out.println(paraObj.getUnitId());
		//System.out.println(paraObj.getCircleId());
		//System.out.println(paraObj.getDivisionId());
		//System.out.println(paraObj.getSubdivisionId());
		//System.out.println(paraObj.getParaStatusId());
		//System.out.println(paraObj.getSectionId());
		//System.out.println(paraObj.getTransferFlag());
			
			User user = (User) session.getAttribute("userObj");
			if(paraObj.getUnitId()==null){
				
				if(user.getUnitId()==4 || user.getUnitId()==9832){
					
					//System.out.println("coming here");
					if(paraObj.getSectionId()!=null && paraObj.getParaStatusId()!=null && paraObj.getTransferFlag()!=null){
					reportType=1;
				paraListTotal=irrm.getParasTotal(paraObj.getSectionId(),paraObj.getParaStatusId(),paraObj.getTransferFlag());
				}
				}
				
				mav.addObject("paraListTotal",paraListTotal);
			}

			
			if(paraObj.getUnitId()!=null){
				
				
					
				/*	if(paraObj.getUnitId()!=4  &&  paraObj.getUnitId() !=9832){*/
						
						reportType=2;
					paraListTotalByUnit=irrm.getParasByUnit(paraObj);
					/*}*/
					
					
					mav.addObject("paraListTotal",paraListTotalByUnit);
					
					mav.addObject("selectedunitId",paraObj.getUnitId());
					if(paraObj.getCircleId()!=null){
					mav.addObject("selectedcircleId",paraObj.getCircleId());
					}
					if(paraObj.getCircleId()==null){
						mav.addObject("selectedcircleId",0);
						}
					
					if(paraObj.getDivisionId()!=null){
					mav.addObject("selecteddivisionId",paraObj.getDivisionId());
					}
					if(paraObj.getDivisionId()==null){
						mav.addObject("selecteddivisionId",0);
						}
					
					if(paraObj.getSubdivisionId()!=null){
					mav.addObject("selectedsubdivisionId",paraObj.getSubdivisionId());
					}
					if(paraObj.getSubdivisionId()==null){
						mav.addObject("selectedsubdivisionId",0);
						}
					
					if(paraObj.getSectionId()!=null){
					mav.addObject("selectedsectionId",paraObj.getSectionId());
					}
					if(paraObj.getSectionId()==null){
						mav.addObject("selectedsectionId",0);
						}
					if(paraObj.getParaStatusId()!=null){
					mav.addObject("selectedParaStatusId",paraObj.getParaStatusId());
					}
					if(paraObj.getParaStatusId()==null){
						mav.addObject("selectedParaStatusId",0);
						}
					if(paraObj.getTransferFlag()!=null){
					mav.addObject("selectedTransferFlag",paraObj.getTransferFlag());
					}
					if(paraObj.getTransferFlag()==null){
						mav.addObject("selectedTransferFlag",false);
						}
					
					if(reportType==2){
					mav.addObject("selectedabstract",flag);
					}
					
					
					mav.addObject("reportType",reportType);
					
				}
				
				
			
			
			
			if(paraObj.getUnitId()==null ){
		
			mav.addObject("selectedunitId",paraObj.getUnitId());
			mav.addObject("selectedsectionId",paraObj.getSectionId());
			mav.addObject("selectedParaStatusId",paraObj.getParaStatusId());
			mav.addObject("selectedTransferFlag",paraObj.getTransferFlag());
			mav.addObject("selectedabstract",flag);
			mav.addObject("reportType",reportType);
		
			}
			
			
			
			
		} catch (IRParasUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
		return mav;
	}
	

	@RequestMapping(value="/parasreport/parasDetailReply")
	public ModelAndView parasDetailreply(@ModelAttribute("irparas") Paras paraObj,SessionStatus status, HttpSession session){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("parasDetailReplyAll");
		
		List<Unit> unitList = new ArrayList<Unit>();
		List<Circle> circleList = new ArrayList<Circle>();
		List<Division> divisionList = new ArrayList<Division>();
		
		List<Paras> paraListTotal= new ArrayList<Paras>();
		
		List<ReplyData> replyListTotal= new ArrayList<ReplyData>();
		
		List<ParaDocuments> paradocsList= new ArrayList<ParaDocuments>();
		
		
		
		
		try {
			
			unitList = tam.getunitpostList();
			circleList = tam.getcirclepostList();
			divisionList = tam.getdivisionpostList();
			
			
			
			if(paraObj.getUnitId()!=null){
			paraListTotal=irrm.getParasByOffice(paraObj.getUnitId(), paraObj.getCircleId(), paraObj.getDivisionId());
			
			if(paraObj.getCircleId()==null){
				
				paraObj.setCircleId(0);
				
			}
			
                if(paraObj.getDivisionId()==null){
				
				paraObj.setDivisionId(0);
				
			}
			
			if( paraObj.getCircleId()!=null &&  paraObj.getDivisionId()!=null){
			replyListTotal=irrm.getReplyAllbyOffice(paraObj);
			
			paradocsList=irrm.getDocsAllByOffice(paraObj);
			}
		
			
			
			mav.addObject("paraListTotal",paraListTotal);
			
			mav.addObject("replyListTotal",replyListTotal);
			mav.addObject("paradocsList",paradocsList);
		
			
			}
			mav.addObject("unitList", unitList);
			mav.addObject("circleList", circleList);
			mav.addObject("divisionList", divisionList);
			
			
		} catch (IRParasUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TaskUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
		return mav;
	}
	
	@RequestMapping(value="/parasreport/paraAbstractOffice")
	public ModelAndView parasAbstractOffice(@ModelAttribute("parareportdata") Paras paraObj,SessionStatus status, HttpSession session){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("paraabstarctOffice");
		
		List<Paras> paraListUnit= new ArrayList<Paras>();
		List<Paras> paraListCircle= new ArrayList<Paras>();
		List<Paras> paraListDivision= new ArrayList<Paras>();
		List<Paras> paraListSubDivision= new ArrayList<Paras>();
		List<Paras> paraListCircleTotal= new ArrayList<Paras>();
		List<Paras> paraListUnitTotal= new ArrayList<Paras>();
		
		
	
		List<Paras> paraListDivisionWithOutCir= new ArrayList<Paras>();
		
		Boolean flag=false;
		
		
		
		try {
			
			
		//	System.out.println("paraObj"+paraObj);
			
			String pwd =PasswordGenerator.getPassword(5);
			
		//	System.out.println("pwd"+pwd);
			
			
			if(paraObj.getUnitId()!=null && paraObj.getCircleId()!=null && paraObj.getDivisionId()!=null && paraObj.getSubdivisionId()!=null){
			
			//	System.out.println("pwd"+paraObj.getUnitId());
			//	System.out.println("pwd"+paraObj.getCircleId());
			//	System.out.println("pwd"+paraObj.getDivisionId());
			//	System.out.println("pwd"+paraObj.getSubdivisionId());
				
				if(paraObj.getUnitId()>0 && paraObj.getCircleId()==0 && paraObj.getDivisionId()==0 && paraObj.getSubdivisionId()==0){
			
			paraListUnit=irrm.getParasAbstarctCountByUnit(paraObj);
			
			
			paraListCircle=	irrm.getParasAbstarctCountByCircle(paraObj);
					
			paraListDivision=irrm.getParasAbstarctCountByDivision(paraObj)	;		
					
			paraListSubDivision	=irrm.getParasAbstarctCountBySubDiv(paraObj);
			paraListCircleTotal	=irrm.getParasAbstarctCountByCirTot(paraObj);
					
			paraListUnitTotal	=irrm.getParasAbstarctCountByUnitTot(paraObj)	;
					
			paraListDivisionWithOutCir=irrm.getCountWithoutCircleByDivision(paraObj);
				}
				
				if(paraObj.getUnitId()>0 && paraObj.getCircleId()>0 && paraObj.getDivisionId()==0 && paraObj.getSubdivisionId()==0){
					
				
					
					paraListCircle=	irrm.getParasAbstarctCountByCircle(paraObj);
							
					paraListDivision=irrm.getParasAbstarctCountByDivision(paraObj)	;		
							
					paraListSubDivision	=irrm.getParasAbstarctCountBySubDiv(paraObj);
					paraListCircleTotal	=irrm.getParasAbstarctCountByCirTot(paraObj);
							
			
							
					paraListDivisionWithOutCir=irrm.getCountWithoutCircleByDivision(paraObj);
						}
				
			
			}
			
				
			
					
		
			
						
					
			
				
		} catch (IRParasUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		mav.addObject("paraListUnit",paraListUnit);
		mav.addObject("paraListCircle",paraListCircle);
		mav.addObject("paraListDivision",paraListDivision);
		mav.addObject("paraListSubDivision",paraListSubDivision);
		mav.addObject("paraListCircleTotal",paraListCircleTotal);
		mav.addObject("paraListUnitTotal",paraListUnitTotal);
		
		mav.addObject("paraListDivisionWithOutCircle",paraListDivisionWithOutCir);
		
		
		mav.addObject("sunitId",paraObj.getUnitId());
		if(paraObj.getCircleId()!=null){
		mav.addObject("scircleId",paraObj.getCircleId());
		}
		if(paraObj.getCircleId()==null){
			mav.addObject("scircleId",0);
			}
		if(paraObj.getDivisionId()!=null){
			mav.addObject("sdivisionId",paraObj.getDivisionId());
			}
		if(paraObj.getDivisionId()==null){
			mav.addObject("sdivisionId",0);
			}
		if(paraObj.getSubdivisionId()!=null){
			mav.addObject("ssubdivisionId",paraObj.getSubdivisionId());
			
			}
		if(paraObj.getSubdivisionId()==null){
			mav.addObject("ssubdivisionId",0);
			
			}
	
	
		
		
		
	
		
		
		return mav;
		
	}
	
	
	
	@RequestMapping(value="/parasreport/parasAbstractDetail")
	public ModelAndView parasAbstractDetailTotal(@ModelAttribute("irparas") Paras paraObj,SessionStatus status, HttpSession session){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("paraDetailTotal");	
		
		List<Paras> paraListTotalByUnit= new ArrayList<Paras>();
		
		Boolean flag=false;
		try {
		             //paraListTotal=irrm.getParasAbstractTotal(paraObj.getSectionId(),paraObj.getParaStatusId());
			
			if(paraObj.getUnitId()!=null){
				
				if(paraObj.getUnitId()>0){
					
					// System.out.println("parasAbstractDetail"+paraObj.getUnitId());
					// System.out.println("parasAbstractDetail"+paraObj.getCircleId());
					// System.out.println("parasAbstractDetail"+paraObj.getDivisionId());
					// System.out.println("parasAbstractDetail"+paraObj.getSectionId());
					// System.out.println("parasAbstractDetail"+paraObj.getParaStatusId());
					// System.out.println("parasAbstractDetail"+paraObj.getUnitTotal());
					/// System.out.println("parasAbstractDetail"+paraObj.getCircleTotal());
					// System.out.println("parasAbstractDetail"+paraObj.getTransferFlag());
                     
					
					
					paraListTotalByUnit=irrm.getParasAbstractByUnit(paraObj);
					
					
					mav.addObject("paraListTotal",paraListTotalByUnit);
					
					mav.addObject("selectedunit",paraObj.getUnitId());
					mav.addObject("selectedabs",flag);
					if(paraObj.getCircleId()!=null){
					mav.addObject("selectedCircleId",paraObj.getCircleId());
					}
					if(paraObj.getCircleId()==null){
						mav.addObject("selectedCircleId",0);
						}
					if(paraObj.getDivisionId()!=null){
					mav.addObject("selectedDivisionId",paraObj.getDivisionId());
					}
					if(paraObj.getDivisionId()==null){
						mav.addObject("selectedDivisionId",0);
						}
					
					if(paraObj.getSubdivisionId()!=null){
						mav.addObject("selectedsubDivisionId",paraObj.getSubdivisionId());
						}
						if(paraObj.getSubdivisionId()==null){
							mav.addObject("selectedsubDivisionId",0);
							}
					if(paraObj.getSectionId()!=null){
					mav.addObject("selectedSectionId",paraObj.getSectionId());
					}
					if(paraObj.getSectionId()==null){
						mav.addObject("selectedSectionId",0);
						}
					if(paraObj.getParaStatusId()!=null){
				     mav.addObject("selectedParaStatusId",paraObj.getParaStatusId());
					}
					if(paraObj.getParaStatusId()==null){
					     mav.addObject("selectedParaStatusId",0);
						}
				     
				   
					if(paraObj.getTransferFlag()!=null){
				     mav.addObject("selectedTransferFlag",paraObj.getTransferFlag());
					}
					if(paraObj.getTransferFlag()==null){
					     mav.addObject("selectedTransferFlag",paraObj.getTransferFlag());
						}
				     if(paraObj.getCircleTotal()!=null){
				     mav.addObject("selectedcircleTotal",paraObj.getCircleTotal());
				     }
				     if(paraObj.getCircleTotal()==null){
					     mav.addObject("selectedcircleTotal",false);
					     }
				     if(paraObj.getUnitTotal()!=null){
				     mav.addObject("selectedunitTotal",paraObj.getUnitTotal());
				     }
				     if(paraObj.getUnitTotal()==null){
					     mav.addObject("selectedunitTotal",paraObj.getUnitTotal());
					     }
				     
				     
				//	System.out.println("selectedunit"+paraObj.getUnitId()+","+flag);
					
					
					
				}
				
				
			}
			
			
			
			
			
			
			
		} catch (IRParasUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
		return mav;
	}
	
	@RequestMapping(value="/parasreport/parasDetailByPara")
	public ModelAndView parasDetailbyparaId(@ModelAttribute("irparas") Paras paraObj,SessionStatus status, HttpSession session){
		ModelAndView mav = new ModelAndView();
		/*mav.setViewName("paraDetailTotal");*/
		
		Paras  parabyParaId = new Paras();
		
		List<Paras> paraListbyParaId= new ArrayList<Paras>();
		
		List<ReplyData> replyListbyParaId= new ArrayList<ReplyData>();
		
		
		try {
			//paraListTotal=irrm.getParasAbstractTotal(paraObj.getSectionId(),paraObj.getParaStatusId());
			
			if(paraObj.getParaId()!=null){
				
				if(paraObj.getParaId()>0){
					
					//System.out.println(paraObj.getUnitTotal());
					
					parabyParaId=iram.getParaforedit(paraObj.getParaId());
					
					
					mav.addObject("paraListTotal",parabyParaId);
					
					
				}
				
				
			}
			
			
			
			
			
			
			
		} catch (IRParasUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
		return mav;
	}
	
	
	@RequestMapping(value = "/parasreport/downloadPDF", method = RequestMethod.GET)
	public ModelAndView downloadPDF(Integer unitId, Integer circleId, Integer divisionId) {
		// create some sample data
		
		ModelAndView mav = new ModelAndView();
		List<Paras> listParas = new ArrayList<Paras>();
		
		List<Paras> listParas2 = new ArrayList<Paras>();
		
		
		
		
try {
	
	
			
			if(unitId!=null){
				listParas=irrm.getParasByOfficePdf(unitId,circleId, divisionId);
			/*int len=listParas.size();
				
				for (int i=0 ; i<len ; i++){
					
				String htmlString=listParas.get(i).getParasAction();
				
				  System.out.println("jsoup1"+htmlString);
				 org.jsoup.nodes.Document doc = Jsoup.parse(htmlString);
		          String title = doc.html();
		          
		      System.out.println("tata"+title);
		     // listParas.get(i).setParasAction(title);
					
				}*/
			
	
		
			
			}
			
			
			
			
		} catch (IRParasUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		mav.setViewName("pdfView");//check in views properties file under resources
		
		mav.addObject("Paras" ,listParas);
		




		// return a view which will be resolved by an excel view resolver
		return mav ;
				//new ModelAndView("pdfView", "Paras", listParas);
	}
	
	@RequestMapping(value="/parasreport/cagstatus")
	public ModelAndView CAGAbstract(@ModelAttribute("irparas") CAGParas paraObj,SessionStatus status, HttpSession session){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("cagstatus");
		
		List<CAGParas> paraListCount= new ArrayList<CAGParas>();
		
		List<ParaDocuments> paradocList= new ArrayList<ParaDocuments>();
		
		
		Integer totalParasAll=0;
		Integer secAAll=0;
		Integer secBAll=0;
		Integer DroppedAll=0;
		Integer Balanceall=0;

		Integer replyNaAll=0;
		Integer replyByCE=0;
		Integer replyByENCI=0;
		Integer replyBySEYAG=0;
		Integer replyBYSEYCONT=0;
		Integer discussPACCount=0;
		Integer inclPACCount=0;
		Integer TrAll=0;
		
		
		try {
			
			User user = (User) session.getAttribute("userObj");

			
				if (user != null) {
				
					
					if(user.getUnitId()!=9832 && user.getCircleId()!=21614){

					paraObj.setUnitId(user.getUnitId());
					
					}else {
						
					
						paraObj.setUnitId(user.getUnitId());	
						
					}

				}
			
			if(paraObj!=null){
				
				
				if(paraObj.getUnitId()!=null){
					
					if(paraObj.getUnitId()>0){
				
				paraListCount=irrm.getCAGParasAbstarctCount(paraObj);
				
				paradocList=iram.getCAGDocs(paraObj);
				
					}
				}
				
			}
					
					
					if(paraListCount!=null){
						
						if(paraListCount.size()>0){
					
					Integer len =paraListCount.size();
					
					for(int i=0; i<len ;i++){
						
						totalParasAll=totalParasAll+paraListCount.get(i).getTotalParas();
								
								DroppedAll=DroppedAll+paraListCount.get(i).getDroppedCount();
								Balanceall=Balanceall+paraListCount.get(i).getBalanceParas();
								
								replyNaAll=replyNaAll+paraListCount.get(i).getReplyNotSent();
								replyByCE=replyByCE+paraListCount.get(i).getReplybyce();
								replyByENCI=replyByENCI+paraListCount.get(i).getReplybyenci();
								replyBySEYAG=replyBySEYAG+paraListCount.get(i).getReplybysecyag();
								replyBYSEYCONT=replyBYSEYCONT+paraListCount.get(i).getReplybyseccont();
								discussPACCount=discussPACCount+paraListCount.get(i).getDicusspaccount();
								inclPACCount=inclPACCount+paraListCount.get(i).getPacinclcount();
								
						
					}
					
						}
					
					}
			
				
		} catch (IRParasUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		mav.addObject("paraListCount",paraListCount);
	   
		mav.addObject("totalParasAll",totalParasAll);
		
		
		mav.addObject("DroppedAll",DroppedAll);
		mav.addObject("Balanceall",Balanceall);	
		mav.addObject("replyNaAll",replyNaAll);
		mav.addObject("replyByCE",replyByCE);
		mav.addObject("replyByENCI",replyByENCI);	
		mav.addObject("replyBySEYAG",replyBySEYAG);
		mav.addObject("replyBYSEYCONT",replyBYSEYCONT);
		mav.addObject("discussPACCount",discussPACCount);
		mav.addObject("inclPACCount",inclPACCount);
		
		mav.addObject("paradocList",paradocList);
		
		

		
			
		return mav;
		
	}
	
	
	
	@RequestMapping(value="/parasreport/cagstatusbyUnit")
	public ModelAndView cagstatusbyUnit(@ModelAttribute("irparas") CAGParas paraObj,SessionStatus status, HttpSession session){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("cagstatusbyunit");
		
		List<CAGParas> paraListCount= new ArrayList<CAGParas>();
		List<Unit> unitList = new ArrayList<Unit>();
		
		
		Integer totalParasAll=0;
		Integer secAAll=0;
		Integer secBAll=0;
		Integer DroppedAll=0;
		Integer Balanceall=0;

		Integer replyNaAll=0;
		Integer replyByCE=0;
		Integer replyByENCI=0;
		Integer replyBySEYAG=0;
		Integer replyBYSEYCONT=0;
		Integer discussPACCount=0;
		Integer inclPACCount=0;
		Integer TrAll=0;
		
		
		try {
			
			unitList = tam.getprojListNew();
			
			User user = (User) session.getAttribute("userObj");
			
		
			
			if(paraObj.getSubParaUnitId()==null){

			
				if (user != null) {
				
					
					if(user.getUnitId()!=9832 && user.getCircleId()!=21614){

					paraObj.setUnitId(user.getUnitId());
					
					}else {
						
					
						paraObj.setUnitId(user.getUnitId());	
						
					}

				}
				
				mav.addObject("reportvar",1);
				
			}
			if(paraObj.getSubParaUnitId()!=null){
				
				paraObj.setUnitId(paraObj.getSubParaUnitId());
				
				mav.addObject("reportvar",2);
				
			}
			
			if(paraObj!=null){
				
				
				if(paraObj.getUnitId()!=null){
					
					if(paraObj.getUnitId()>0){
				
				paraListCount=irrm.getCAGParasAbstractUnit(paraObj);
				
					}
				}
				
			}
			
					
					
					if(paraListCount!=null){
						
						if(paraListCount.size()>0){
					
					Integer len =paraListCount.size();
					
					for(int i=0; i<len ;i++){
						if(!(paraListCount.get(i).getParaNumber().equals("NA") &&  paraListCount.get(i).getFinancialYear().equals("finyear"))){
						
						totalParasAll=totalParasAll+paraListCount.get(i).getTotalParas();
								
								DroppedAll=DroppedAll+paraListCount.get(i).getDroppedCount();
								Balanceall=Balanceall+paraListCount.get(i).getBalanceParas();
								
								replyNaAll=replyNaAll+paraListCount.get(i).getReplyNotSent();
								replyByCE=replyByCE+paraListCount.get(i).getReplybyce();
								replyByENCI=replyByENCI+paraListCount.get(i).getReplybyenci();
								replyBySEYAG=replyBySEYAG+paraListCount.get(i).getReplybysecyag();
								replyBYSEYCONT=replyBYSEYCONT+paraListCount.get(i).getReplybyseccont();
								discussPACCount=discussPACCount+paraListCount.get(i).getDicusspaccount();
								inclPACCount=inclPACCount+paraListCount.get(i).getPacinclcount();
								
						}
					}
					
						}
					
					}
			
				
		} catch (IRParasUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TaskUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		mav.addObject("paraListCount",paraListCount);
	   
		mav.addObject("totalParasAll",totalParasAll);
		
		mav.addObject("unitList", unitList);
		
		mav.addObject("DroppedAll",DroppedAll);
		mav.addObject("Balanceall",Balanceall);	
		mav.addObject("replyNaAll",replyNaAll);
		mav.addObject("replyByCE",replyByCE);
		mav.addObject("replyByENCI",replyByENCI);	
		mav.addObject("replyBySEYAG",replyBySEYAG);
		mav.addObject("replyBYSEYCONT",replyBYSEYCONT);
		mav.addObject("discussPACCount",discussPACCount);
		mav.addObject("inclPACCount",inclPACCount);

		
			
		return mav;
		
	}
	
	@RequestMapping(value="/parasreport/cagstatusyear")
	public ModelAndView cagstatusyear(@ModelAttribute("irparas") CAGParas paraObj,SessionStatus status, HttpSession session){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("cagstatusyear");
		
		List<CAGParas> paraListCount= new ArrayList<CAGParas>();

		List<CAGParas> selectCAGparaFYear = new ArrayList<CAGParas>();

		
		Integer totalParasAll=0;
		Integer secAAll=0;
		Integer secBAll=0;
		Integer DroppedAll=0;
		Integer Balanceall=0;

		Integer replyNaAll=0;
		Integer replyByCE=0;
		Integer replyByENCI=0;
		Integer replyBySEYAG=0;
		Integer replyBYSEYCONT=0;
		Integer discussPACCount=0;
		Integer inclPACCount=0;
		Integer TrAll=0;
		
		
		try {
			

			selectCAGparaFYear = irrm.getCAGparaFinYear();
			   if(selectCAGparaFYear!=null){
             mav.addObject("selectCAGparaFYear",selectCAGparaFYear);
            // System.out.println("selectCAGparaFYear "+selectCAGparaFYear);
			   }
			

			//System.out.println("paraObj"+paraObj.getFinancialYear());
			
			User user = (User) session.getAttribute("userObj");

			
				if (user != null) {
				
					
					if(user.getUnitId()!=9832 && user.getCircleId()!=21614){

					paraObj.setUnitId(user.getUnitId());
					
					}else {
						
					
						paraObj.setUnitId(user.getUnitId());	
						
					}

				}
			
			if(paraObj!=null && paraObj.getFinancialYear()!=null ){
				
				
				if(paraObj.getUnitId()!=null){
					
					if(paraObj.getUnitId()>0){
				
				paraListCount=irrm.getCAGParasAbstarctYearUnit(paraObj);
				
					}
				}
				
			}
					
					
					/*if(paraListCount!=null){
						
						if(paraListCount.size()>0){
					
					Integer len =paraListCount.size();
					
					for(int i=0; i<len ;i++){
						
						totalParasAll=totalParasAll+paraListCount.get(i).getTotalParas();
								
								DroppedAll=DroppedAll+paraListCount.get(i).getDroppedCount();
								Balanceall=Balanceall+paraListCount.get(i).getBalanceParas();
								
								replyNaAll=replyNaAll+paraListCount.get(i).getReplyNotSent();
								replyByCE=replyByCE+paraListCount.get(i).getReplybyce();
								replyByENCI=replyByENCI+paraListCount.get(i).getReplybyenci();
								replyBySEYAG=replyBySEYAG+paraListCount.get(i).getReplybysecyag();
								replyBYSEYCONT=replyBYSEYCONT+paraListCount.get(i).getReplybyseccont();
								discussPACCount=discussPACCount+paraListCount.get(i).getDicusspaccount();
								inclPACCount=inclPACCount+paraListCount.get(i).getPacinclcount();
								
						
					}
					
						}
					
					}*/
			
				
		} catch (IRParasUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		mav.addObject("paraListCount",paraListCount);
		/*mav.addObject("totalParasAll",totalParasAll);
		
		
		mav.addObject("DroppedAll",DroppedAll);
		mav.addObject("Balanceall",Balanceall);	
		mav.addObject("replyNaAll",replyNaAll);
		mav.addObject("replyByCE",replyByCE);
		mav.addObject("replyByENCI",replyByENCI);	
		mav.addObject("replyBySEYAG",replyBySEYAG);
		mav.addObject("replyBYSEYCONT",replyBYSEYCONT);
		mav.addObject("discussPACCount",discussPACCount);
		mav.addObject("inclPACCount",inclPACCount);
*/
		
			
		return mav;
		
	}
	
	
	
	@RequestMapping(value="/parasreport/cagParasAbstractOffice")
	public ModelAndView cagParasAbstractOffice(@ModelAttribute("irparas") CAGParas paraObj,SessionStatus status, HttpSession session){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("cagParasAbstractOffice");
		
		List<CAGParas> paraListUnit= new ArrayList<CAGParas>();
		List<CAGParas> paraListCircle= new ArrayList<CAGParas>();
		List<CAGParas> paraListDivision= new ArrayList<CAGParas>();
		List<CAGParas> paraListSubDivision= new ArrayList<CAGParas>();
		List<CAGParas> paraListCircleTotal= new ArrayList<CAGParas>();
		List<CAGParas> paraListUnitTotal= new ArrayList<CAGParas>();
		
		
	
		List<CAGParas> paraListDivisionWithOutCir= new ArrayList<CAGParas>();
		
		
		
		
		
		try {
			
			
			paraListUnit=irrm.getCAGParasAbstarctCountByUnit(paraObj.getUnitId());
			paraListCircle=	irrm.getCAGParasAbstarctCountByCircle(paraObj.getUnitId());
					
			paraListDivision=irrm.getCAGParasAbstarctCountByDivision(paraObj.getUnitId())	;		
					
			paraListSubDivision	=irrm.getCAGParasAbstarctCountBySubDiv(paraObj.getUnitId());
			paraListCircleTotal	=irrm.getCAGParasAbstarctCountByCirTot(paraObj.getUnitId());
					
			paraListUnitTotal	=irrm.getCAGParasAbstarctCountByUnitTot(paraObj.getUnitId())	;
					
			paraListDivisionWithOutCir=irrm.getCAGCountWithoutCircleByDivision(paraObj.getUnitId());
				
			
					
		
			
						
					
			
				
		} catch (IRParasUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		mav.addObject("paraListUnit",paraListUnit);
		mav.addObject("paraListCircle",paraListCircle);
		mav.addObject("paraListDivision",paraListDivision);
		mav.addObject("paraListSubDivision",paraListSubDivision);
		mav.addObject("paraListCircleTotal",paraListCircleTotal);
		mav.addObject("paraListUnitTotal",paraListUnitTotal);
		
		mav.addObject("paraListDivisionWithOutCircle",paraListDivisionWithOutCir);
		
		
		return mav;
		
	}
	
	@RequestMapping(value="/parasreport/cagparasDetail")
	public ModelAndView cagparasDetailTotal(@ModelAttribute("cagparas") CAGParasData paraObj,SessionStatus status, HttpSession session){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("cagparaDetailTotal");
		
		List<CAGParas> paraListTotal= new ArrayList<CAGParas>();
		
		List<CAGParasData> paraListTotalByUnit= new ArrayList<CAGParasData>();
		
		List<ReplyData>  replyList= new ArrayList<ReplyData>();
		
		
		List<ParaDocuments>  docsList= new ArrayList<ParaDocuments>();
		

		
		
		try {
			//paraListTotal=irrm.getCAGParasTotal(paraObj.getParaStatusId(),paraObj.getTransferFlag());
			
			User user = (User) session.getAttribute("userObj");

		

				if (user != null) {
					if(user.getUnitId()!=null){
						paraObj.setUserName(user.getUserName());
						
					
						paraObj.setCunitId(user.getUnitId());
						
						if(user.getCircleId()!=null){	
							
						paraObj.setCircleId(user.getCircleId());
						
						}
						
					}

				}
			
			
			if(paraObj.getCagGistId()!=null){
				
				if(paraObj.getCagGistId()>0){
					
					paraListTotalByUnit=irrm.getCAGParasByUnit(paraObj);
					
					replyList=irrm.getCAGReplybyGistId(paraObj);
					
					docsList=irrm.CAGgetDocsAll(paraObj);
					
					
					mav.addObject("paraListTotal",paraListTotalByUnit);
					
					mav.addObject("replyList",replyList);
					
					mav.addObject("docsList",docsList);
					
					
					
				}
				
				
			}
			
			
			if(paraObj.getCunitId()==null ){
			mav.addObject("paraListTotal",paraListTotal);
			}
			
			
			
			
		} catch (IRParasUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
		return mav;
	}
	
	
	@RequestMapping(value="/parasreport/cagparasYearDetail")
	public ModelAndView cagparasYearDetailTotal(@ModelAttribute("cagparas") CAGParasData paraObj,SessionStatus status, HttpSession session){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("cagparaDetailTotal");
		
		List<CAGParas> paraListTotal= new ArrayList<CAGParas>();
		
		List<CAGParasData> paraListTotalByUnit= new ArrayList<CAGParasData>();
		
		List<ReplyData>  replyList= new ArrayList<ReplyData>();
		
		
		List<ParaDocuments>  docsList= new ArrayList<ParaDocuments>();
		

		//System.out.println("paraObj"+paraObj.getCunitId());
		
		try {
			//paraListTotal=irrm.getCAGParasTotal(paraObj.getParaStatusId(),paraObj.getTransferFlag());
			
			User user = (User) session.getAttribute("userObj");

		

				if (user != null) {
					if(user.getUnitId()!=null){
						paraObj.setUserName(user.getUserName());
						
					
						
						
						}
						
					}

				
			
			
			if(paraObj.getCagGistId()!=null){
				
				if(paraObj.getCagGistId()>0){
					
					paraListTotalByUnit=irrm.getCAGParasByYearUnit(paraObj);
					
					replyList=irrm.getCAGReplybyGistId(paraObj);
					
					docsList=irrm.CAGgetDocsAll(paraObj);
					
					
					mav.addObject("paraListYearTotal",paraListTotalByUnit);
					
					mav.addObject("replyList",replyList);
					
					mav.addObject("docsList",docsList);
					
					
					
				}
				
				
			}
			
			
			if(paraObj.getCunitId()==null ){
			mav.addObject("paraListYearTotal",paraListTotal);
			}
			
			
			
			
		} catch (IRParasUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
		return mav;
	}
	
	
	
	@RequestMapping(value = "/parasreport/getSubparaListbygistid")	
	public ModelAndView getSubparaListbygistId(Integer cagGistId, SessionStatus status, HttpServletRequest request)
			throws LeagalUserException {
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("cagparadetail");
		
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
					
				
		mav.addObject("subparaList",subparaList);	
			
		
		// System.out.println("cagGistId"+cagGistId);
	
		

		return mav;

	}
	
	@RequestMapping(value="/parasreport/CAGAbstractDetail")
	public ModelAndView CAGAbstractDetailTotal(@ModelAttribute("irparas") CAGParas paraObj,SessionStatus status, HttpSession session){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("cagparaDetailTotal");
		
		
		
		List<CAGParas> paraListTotalByUnit= new ArrayList<CAGParas>();
		
		
		try {
			//paraListTotal=irrm.getParasAbstractTotal(paraObj.getSectionId(),paraObj.getParaStatusId());
			
			if(paraObj.getUnitId()!=null){
				
				if(paraObj.getUnitId()>0){
					
					//System.out.println(paraObj.getUnitTotal());
					
					paraListTotalByUnit=irrm.getCAGParasAbstractByUnit(paraObj.getUnitId(),paraObj.getCircleId(),paraObj.getDivisionId(),paraObj.getParaStatusId(),paraObj.getCircleTotal(),paraObj.getUnitTotal(),paraObj.getTransferFlag());
					
					
					mav.addObject("paraListTotal",paraListTotalByUnit);
					
					
				}
				
				
			}
			
			
			
			
			
			
			
		} catch (IRParasUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
		return mav;
	}
	
	@RequestMapping(value="/parasreport/cagparasDetailReply")
	public ModelAndView CAGparasDetailreply(@ModelAttribute("irparas") CAGParas paraObj,SessionStatus status, HttpSession session){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("cagparasDetailReplyAll");
		
		
	
		
		List<CAGParas> paraListTotal= new ArrayList<CAGParas>();
		
		List<CAGParasData> paraListDataTotal= new ArrayList<CAGParasData>();
		
		List<ReplyData> replyListTotal= new ArrayList<ReplyData>();
		
		List<ParaDocuments> paradocsList= new ArrayList<ParaDocuments>();
		
		
		Integer selectedcagGistId=0;
		
		
		try {
			
		
			if(paraObj.getCagGistId() !=null){
				
				selectedcagGistId=paraObj.getCagGistId();
				
			paraListTotal=irrm.getCAGParasByOffice(selectedcagGistId);
			
			paraListDataTotal=irrm.getCAGParastotalDetail();
			replyListTotal=irrm.getCAGReplyALL();
			
			//paradocsList=irrm.CAGgetDocsAll();
			
		
			
			
			mav.addObject("paraListTotal",paraListTotal);
			
			mav.addObject("paraListDataTotal",paraListDataTotal);
			
			
			
			mav.addObject("replyListTotal",replyListTotal);
			mav.addObject("paradocsList",paradocsList);
		
			
			}
			
			mav.addObject("selectedcagGistId", selectedcagGistId);
			
		
			
			
		} catch (IRParasUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
		return mav;
	}
	
	@RequestMapping(value = "/parasreport/downloadcagPDF", method = RequestMethod.GET)
	public ModelAndView downloadcagPDF(Integer  cagGistId ) {
		// create some sample data
		
		ModelAndView mav = new ModelAndView();
		CAGParas  listParas = new CAGParas();
		List<CAGParasData> paraDataTotal = new ArrayList<CAGParasData>();
		List<ReplyData> replyDataTotal = new ArrayList<ReplyData>();
		List<ParaDocuments> paradocsList = new ArrayList<ParaDocuments>();
		
		//List<Paras> listParas2 = new ArrayList<Paras>();
		
		
		
		
try {
	
	
			
			if(cagGistId!=0){
				listParas=irrm.getCAGGistByOfficePdfnew(cagGistId);
				
				paraDataTotal=irrm.getCAGParastotalDetail();
				replyDataTotal=irrm.getCAGReplyALL();
				
			//	paradocsList=irrm.CAGgetDocsAll();
			/*int len=listParas.size();
				
				for (int i=0 ; i<len ; i++){
					
				String htmlString=listParas.get(i).getParasAction();
				
				  System.out.println("jsoup1"+htmlString);
				 org.jsoup.nodes.Document doc = Jsoup.parse(htmlString);
		          String title = doc.html();
		          
		      System.out.println("tata"+title);
		     // listParas.get(i).setParasAction(title);
					
				}*/
			
	
		
			
			}
			
			
			
			
			
		} catch (IRParasUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		mav.setViewName("cagpdfView");//check in views properties file
		
		mav.addObject("cagparas" ,listParas);
		mav.addObject("paraDataTotal" ,paraDataTotal);
		mav.addObject("replyDataTotal" ,replyDataTotal);
		mav.addObject("paradocsList" ,paradocsList);
		




		// return a view which will be resolved by an excel view resolver
		return mav ;
				//new ModelAndView("pdfView", "Paras", listParas);
	}
	
	//production
		/*@RequestMapping(value = "/parasreport/infixexpression")
		public ModelAndView getCAGReplysbyparaId(String infix, SessionStatus status, HttpServletRequest request)
				throws LeagalUserException {
			
			ModelAndView mav = new ModelAndView();
			
			String output=null;
			
			mav.setViewName("infixexpression");
			
			if(infix!=null){
			
		output=	EvaluateInfixExpression.evaluate(infix);
			}
			
                System.out.println("infix"+infix);
                
               // output=infix;
                
                mav.addObject("output",output);

			return mav;

		}*/
	
	
	@RequestMapping(value = "/parasreport/downloadabstarctviewPDF", method = RequestMethod.GET)
	public ModelAndView downloadabstarctviewPDF(@ModelAttribute("irparas") Paras paraObj,SessionStatus status, HttpSession session) {
		// create some sample data
		
		ModelAndView mav = new ModelAndView();
		List<Paras> paraListTotal= new ArrayList<Paras>();
		List<Paras> paraListTotalByUnit= new ArrayList<Paras>();
		List<ReplyData> replyListTotal= new ArrayList<ReplyData>();
		try {
			replyListTotal=irrm.getReplysWithAllReplys();
			if(paraObj.getUnitId()!=null){
				if(paraObj.getUnitId()>0){
				//System.out.println("coming here");
					paraListTotalByUnit=irrm.getParasByUnitDOCPDF(paraObj);
					//System.out.println("coming here"+paraListTotalByUnit);
					//System.out.println("paraListTotalByUnit"+paraListTotalByUnit);
					mav.addObject("Paras",paraListTotalByUnit);
				}
				/*if(paraObj.getUnitId()!=null){
					if(paraObj.getUnitId()>0){
						//System.out.println(paraObj.getUnitTotal());
						paraListTotalByUnit=irrm.getParasAbstractByUnit(paraObj.getUnitId(),paraObj.getCircleId(),paraObj.getDivisionId(),paraObj.getSectionId(),paraObj.getParaStatusId(),paraObj.getCircleTotal(),paraObj.getUnitTotal(),paraObj.getTransferFlag());
						mav.addObject("paraListTotal",paraListTotalByUnit);
					}
				}
				*/
			}
			if(paraObj.getUnitId()==null ){
				//System.out.println("not coming here");
				
				paraListTotal=irrm.getParasTotalDOCPDF(paraObj.getSectionId(),paraObj.getParaStatusId(),paraObj.getTransferFlag());
			mav.addObject("Paras",paraListTotal);
			}
			mav.addObject("allreplys",replyListTotal);
			
		} catch (IRParasUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		mav.setViewName("pdfirparasAbstarctview");//check in views properties file under resources
		//mav.addObject("Paras" ,paraListTotal);
		// return a view which will be resolved by an excel view resolver
		return mav ;
				//new ModelAndView("pdfView", "Paras", listParas);
	}
	
	

	@RequestMapping(value = "/parasreport/downloadabstarctofficeviewPDF", method = RequestMethod.GET)
	public ModelAndView downloadabstarctofficeviewPDF(@ModelAttribute("irparas") Paras paraObj,SessionStatus status, HttpSession session) {
		// create some sample data
		
		ModelAndView mav = new ModelAndView();
		List<Paras> paraListTotalByUnit= new ArrayList<Paras>();
		List<ReplyData> replyListTotal=new ArrayList<ReplyData>();
		Boolean flag=false;
		try {
			//paraListTotal=irrm.getParasAbstractTotal(paraObj.getSectionId(),paraObj.getParaStatusId());
			
			if(paraObj.getUnitId()!=null){
				
				if(paraObj.getUnitId()>0){
					
				//	System.out.println("pdf"+paraObj.getUnitId());
				//	System.out.println("pdf"+paraObj.getCircleId());
				//	System.out.println("pdf"+paraObj.getDivisionId());
				//	System.out.println("pdf"+paraObj.getSubdivisionId());
				//	System.out.println("pdf"+paraObj.getParaStatusId());
				//	System.out.println("pdf"+paraObj.getSectionId());
				//	System.out.println("pdf"+paraObj.getTransferFlag());
					paraListTotalByUnit=irrm.getParasAbstractByUnitPDF(paraObj);
				//	mav.addObject("paraListTotal",paraListTotalByUnit);
				}
			replyListTotal=irrm.getReplysWithAllReplys();
			
			mav.addObject("allreplys",replyListTotal);
			}
			
			if(paraListTotalByUnit!=null){
				mav.addObject("Paras",paraListTotalByUnit);
				}
			
		} catch (IRParasUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		mav.setViewName("pdfirparasAbstarctview");//check in views properties file under resources
		
		//mav.addObject("Paras" ,paraListTotal);
		// return a view which will be resolved by an excel view resolver
		return mav ;
				//new ModelAndView("pdfView", "Paras", listParas);
	}
	
	
	@RequestMapping(value = "/parasreport/cagPDFpara", method = RequestMethod.POST)
	public ModelAndView cagPDFpara(Integer  cagGistId ) {
		// create some sample data
		
		ModelAndView mav = new ModelAndView();
		//CAGParas  listParas = new CAGParas();
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
					
				
	
		mav.setViewName("cagparapdfview");//check in views properties file
		
		mav.addObject("cagparas",subparaList);	
		
		
		




		// return a view which will be resolved by an excel view resolver
		return mav ;
				//new ModelAndView("pdfView", "Paras", listParas);
	}
	
	
	@RequestMapping(value = "/parasreport/cagPDFparareply", method = RequestMethod.POST)
	public ModelAndView cagPDFparaReply(Integer  cagGistId ,SessionStatus status, HttpServletRequest request,
			HttpSession session ) {
		// create some sample data
		
		ModelAndView mav = new ModelAndView();
		CAGParas  listParas = new CAGParas();
		List<CAGParasData> subparaList = new ArrayList<CAGParasData>();
		List<ReplyData> replyDataTotal = new ArrayList<ReplyData>();
		
		
		CAGParasData paraObj= new CAGParasData();
try {
	
	
	if (cagGistId != null) {
		if (cagGistId > 0) {
			
			User user = (User) session.getAttribute("userObj");

			if (user != null) {

				if ( user.getUserName() != null) {

					//paraObj.setUserId(user.getUserId());
					paraObj.setUserName(user.getUserName());
					paraObj.setCunitId(user.getUnitId());

				}

			}
			
			paraObj.setCagGistId(cagGistId);

			subparaList = iram.selectCAGSubParaList(cagGistId);
			replyDataTotal=irrm.getCAGReplybyGistId(paraObj);
		}

	}
			
			
			
		} catch (IRParasUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		mav.setViewName("cagparareplypdfview");//check in views properties file
		
		
		mav.addObject("paraDataTotal" ,subparaList);
		mav.addObject("replyDataTotal" ,replyDataTotal);
	
		




		// return a view which will be resolved by an excel view resolver
		return mav ;
				//new ModelAndView("pdfView", "Paras", listParas);
	}
	
	
	@RequestMapping(value = "/parasreport/cagPACPDFparareply", method = RequestMethod.POST)
	public ModelAndView cagPACPDFparaReply(CAGParasData  parasObj ,SessionStatus status, HttpServletRequest request,
			HttpSession session ) {
		// create some sample data
		
		ModelAndView mav = new ModelAndView();
		CAGParas  listParas = new CAGParas();
		List<CAGParasData> subparaList = new ArrayList<CAGParasData>();
		List<ReplyData> replyDataTotal = new ArrayList<ReplyData>();
		
		
		CAGParasData parObj= new CAGParasData();
try {
	
	
	if (parasObj.getCagGistId() != null) {
		if (parasObj.getCagGistId() > 0) {
			
			User user = (User) session.getAttribute("userObj");

			if (user != null) {

				if ( user.getUserName() != null) {

					//paraObj.setUserId(user.getUserId());
					parasObj.setUserName(user.getUserName());
					parasObj.setCunitId(user.getUnitId());

				}

			}
			
			parasObj.setCagGistId(parasObj.getCagGistId());

			subparaList = iram.selectPACCAGSubParaList(parasObj);
			replyDataTotal=irrm.getCAGReplybyGistId(parasObj);
		}

	}
			
			
	
		} catch (IRParasUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		mav.setViewName("cagparapacrecommondpdfview");//check in views properties file
		
		
		mav.addObject("paraDataTotal" ,subparaList);
		mav.addObject("replyDataTotal" ,replyDataTotal);
	
		




		// return a view which will be resolved by an excel view resolver
		return mav ;
				//new ModelAndView("pdfView", "Paras", listParas);
	}
	
	
	@RequestMapping(value = "/parasreport/cagPDFreplyAll", method = RequestMethod.POST)
	public ModelAndView cagPDFreplyAll(Integer cagGistId,Integer  cagParaId ,SessionStatus status, HttpServletRequest request,
			HttpSession session ) {
		// create some sample data
		
		ModelAndView mav = new ModelAndView();
		CAGParas  listParas = new CAGParas();
		List<CAGParasData> subparaList = new ArrayList<CAGParasData>();
		List<ReplyData> replyDataTotal = new ArrayList<ReplyData>();
		List<ReplyData> replyDatabypara = new ArrayList<ReplyData>();
		
		
		CAGParasData paraObj= new CAGParasData();
try {
	
	//System.out.println(cagGistId+"cagGistId");
	//System.out.println(cagParaId+"cagParaId");
	if (cagParaId != null && cagGistId!=null) {
		if (cagParaId > 0 && cagGistId>0) {
			
			User user = (User) session.getAttribute("userObj");

			if (user != null) {

				if ( user.getUserName() != null) {

					//paraObj.setUserId(user.getUserId());
					paraObj.setUserName(user.getUserName());
					paraObj.setCunitId(user.getUnitId());

				}

			}
			
			paraObj.setCagGistId(cagGistId);
			paraObj.setCagParaId(cagParaId);

			
			replyDataTotal=irrm.getCAGReplybyGistId(paraObj);
			
			
		//	System.out.println("cagParaId1"+cagParaId);
			
			if(replyDataTotal!=null){
				
				for(int i=0; i<replyDataTotal.size();i++){
					
					if(replyDataTotal.get(i).getCagParaId()==cagParaId){
						
						//System.out.println("cagParaId2"+cagParaId);
						
						replyDatabypara.add(replyDataTotal.get(i));
						
					}
					
				}
				
				
				
				
			}
		}

	}
			
			
			
		} catch (IRParasUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		mav.setViewName("cagparareplyallpdfview");//check in views properties file
		
	//	System.out.println("replyDatabypara"+replyDatabypara);
		
		mav.addObject("replyDatabypara",replyDatabypara);
		
		
	
	
		




		// return a view which will be resolved by an excel view resolver
		return mav ;
				//new ModelAndView("pdfView", "Paras", listParas);
	}
	
	
	@RequestMapping(value = "/parasreport/cagPDFparapac", method = RequestMethod.GET)
	public ModelAndView cagPDFparapac(Integer  cagGistId ) {
		// create some sample data
		
		ModelAndView mav = new ModelAndView();
		CAGParas  listParas = new CAGParas();
		List<CAGParasData> paraDataTotal = new ArrayList<CAGParasData>();
		List<ReplyData> replyDataTotal = new ArrayList<ReplyData>();
		List<ParaDocuments> paradocsList = new ArrayList<ParaDocuments>();
		
	
try {
	
	
			
			if(cagGistId!=0){
				listParas=irrm.getCAGGistByOfficePdfnew(cagGistId);
				
				paraDataTotal=irrm.getCAGParastotalDetail();
				replyDataTotal=irrm.getCAGReplyALL();
			
			}
			
			
			
			
			
		} catch (IRParasUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		mav.setViewName("cagpdfView");//check in views properties file
		
		mav.addObject("cagparas" ,listParas);
		mav.addObject("paraDataTotal" ,paraDataTotal);
		mav.addObject("replyDataTotal" ,replyDataTotal);
		mav.addObject("paradocsList" ,paradocsList);
		




		// return a view which will be resolved by an excel view resolver
		return mav ;
				//new ModelAndView("pdfView", "Paras", listParas);
	}
	
	private static final String FILE_DIRECTORY_IR = "/app/tomcat8/webapps/tsimis/uploadedFiles/IRParas/";
	  

    //private static final String RELATIVE_DIR  = "/uploadedFiles/FormDocs/";


	    @GetMapping("/parasreport/viewIRParas")
	    public void serveFile(@RequestParam String fileName, HttpServletResponse response ) throws IOException {
	    	
	    	 // System.out.println("Entered viewPhotos, File Name: "+ fileName);
	        //String absolutePath = servletContext.getRealPath(RELATIVE_DIR);
	       // Path filePath = Paths.get(absolutePath, fileName);
	       // System.out.println("Using absolute path: " + absolutePath);
	    	  Path filePath = Paths.get(FILE_DIRECTORY_IR, fileName);
	    	  File imageFile  = filePath.toFile();

	    	  if (!imageFile .exists() || !imageFile .isFile()) {
	                response.sendError(HttpServletResponse.SC_NOT_FOUND, "File not found");
	                return;
	            }
	    	  
	    	  // Determine content type dynamically
	    	    String lowerCaseName = fileName.toLowerCase();
	    	    String contentType = lowerCaseName.endsWith(".png") ? "image/png" :
	    	                         lowerCaseName.endsWith(".jpg") || lowerCaseName.endsWith(".jpeg") ? "image/jpeg" :
	    	                         "application/octet-stream"; // Fallback

	        
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
	    
	    private static final String FILE_DIRECTORY_CAG = "/app/tomcat8/webapps/tsimis/uploadedFiles/CAGParas/";
		  

	    //private static final String RELATIVE_DIR  = "/uploadedFiles/FormDocs/";


		    @GetMapping("/parasreport/viewCAGParas")
		    public void serveCAGFile(@RequestParam String fileName, HttpServletResponse response ) throws IOException {
		    	
		    	 // System.out.println("Entered viewPhotos, File Name: "+ fileName);
		        //String absolutePath = servletContext.getRealPath(RELATIVE_DIR);
		       // Path filePath = Paths.get(absolutePath, fileName);
		       // System.out.println("Using absolute path: " + absolutePath);
		    	  Path filePath = Paths.get(FILE_DIRECTORY_CAG, fileName);
		    	  File imageFile  = filePath.toFile();

		    	  if (!imageFile .exists() || !imageFile .isFile()) {
		                response.sendError(HttpServletResponse.SC_NOT_FOUND, "File not found");
		                return;
		            }
		    	  
		    	  // Determine content type dynamically
		    	    String lowerCaseName = fileName.toLowerCase();
		    	    String contentType = lowerCaseName.endsWith(".png") ? "image/png" :
		    	                         lowerCaseName.endsWith(".jpg") || lowerCaseName.endsWith(".jpeg") ? "image/jpeg" :
		    	                         "application/octet-stream"; // Fallback

		        
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
