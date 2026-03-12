package in.ts.icad.leagal.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;

import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Singleton;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.google.gson.Gson;

import in.ts.icad.leagal.exception.ComponentUserException;
import in.ts.icad.leagal.exception.IRParasUserException;
import in.ts.icad.leagal.exception.LeagalUserException;
import in.ts.icad.leagal.manager.ComponentReportManager;
import in.ts.icad.leagal.manager.IRParasAdminManager;
import in.ts.icad.leagal.manager.IRParasReportManager;
import in.ts.icad.leagal.manager.LeagalAdminManager;
import in.ts.icad.leagal.manager.LeagalReportManager;
import in.ts.icad.leagal.manager.LeagalWebManager;
import in.ts.icad.leagal.model.CAGParas;
import in.ts.icad.leagal.model.CAGParasData;
import in.ts.icad.leagal.model.Cases;
import in.ts.icad.leagal.model.Component;
import in.ts.icad.leagal.model.Paras;
import in.ts.icad.leagal.model.ReplyData;
import in.ts.icad.leagal.model.abstractCounterData;
import in.ts.icad.leagal.model.mkRepairData;
import in.ts.icad.leagal.model.mkTankData;

@RestController
@EnableWebMvc
@Singleton
public class LeagalWebServiceController {
	
	@Autowired
	private LeagalAdminManager leagalAdminManager;
	
	@Autowired
	private  LeagalWebManager   leagalWebManager;
	
	@Autowired
	private  IRParasReportManager  irrm;
	
	@Autowired
	private  IRParasAdminManager  iram;
	
	
	@Autowired
	private  LeagalReportManager   leagalReportManager;
	
	@Autowired
	private  ComponentReportManager   crm;
	
	@RequestMapping( value="/webRest/La", method = RequestMethod.GET, produces="application/json" )
	public List<abstractCounterData>  getLaCases(Integer caseGenId) throws LeagalUserException  {
		Integer newcaseGenId=2;
		//System.out.println("caseGenId"+caseGenId);
		
	
		
		List<abstractCounterData> counterData = new ArrayList<abstractCounterData>();
		
		
		if(newcaseGenId!=null){
		if(newcaseGenId>0){
			
			counterData = leagalReportManager.getabstractcountGen(newcaseGenId);
			
			//System.out.println("counterData"+counterData);
			
		}
	 
	}
	
		return counterData; 
		  

}
	
	
	@RequestMapping( value="/compMapRest/compStatus", method = RequestMethod.GET, produces="application/json" )
	public List<Component>  getLiftStatusonMap(Integer projectId) throws ComponentUserException  {
		Integer newprojectId=0;
		
		if(projectId!=null){
			if(projectId>0){
			newprojectId=projectId;
			}
		//System.out.println("caseGenId"+caseGenId);
		}
	
		
		List<Component> compMapData = new ArrayList<Component>();
		
		
		if(newprojectId!=null){
		if(newprojectId>0){
			
			compMapData = crm.getCompGoogleMapStatusInfo(newprojectId);
			
			//System.out.println("compMapData"+compMapData);
			
		}
	 
	}
	
		return compMapData; 
		  

}
	
	@RequestMapping(value = "/parasrest/parasDetailByPara",  method = RequestMethod.GET,produces="application/json")
	@ResponseBody
	public String getPara( Integer paraId) throws LeagalUserException {
		
		
//	System.out.println("nextcome"+paraId);	
	Paras  parabyParaId = new Paras();	
	try {
		parabyParaId=iram.getParaforreportbyParaId(paraId);
	} catch (IRParasUserException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return new Gson().toJson(parabyParaId);
	}
	
	@RequestMapping(value = "/parasrest/parastransferDetailByPara",  method = RequestMethod.GET,produces="application/json")
	@ResponseBody
	public String getTransferPara( Integer paraId) throws LeagalUserException {
		
		
//	System.out.println("nextcome"+paraId);	
	Paras  parabyParaId = new Paras();	
	try {
		parabyParaId=iram.getParatransferdreportbyParaId(paraId);
	} catch (IRParasUserException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return new Gson().toJson(parabyParaId);
	}

	@RequestMapping(value = "/parasrest/replyDetailByPara",  method = RequestMethod.GET,produces="application/json")
	@ResponseBody
	public String getReply( Integer paraId) throws LeagalUserException {
		
		List<ReplyData> replyListDB = new ArrayList<ReplyData>();
		
		ReplyData rdObj= new ReplyData();
		
		List<ReplyData> replyListTotal = new ArrayList<ReplyData>();	
	//System.out.println("nextcome"+paraId);	
	
	try {
		if(paraId!=null){
			
			if(paraId>0){
				
		replyListDB=irrm.getReplybyParaId(paraId);
		
			}
		}
		
       
		
	} catch (IRParasUserException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return new Gson().toJson(replyListDB);
		
	}
	
	@RequestMapping(value = "/parasrest/cagparasdetail",  method = RequestMethod.GET,produces="application/json")
	@ResponseBody
	public String getCAGPara( Integer cagParaId,Integer unitId) throws LeagalUserException {
		
		
	//System.out.println("nextcome"+cagGistId);	
	List<CAGParasData>  parabygistId = new ArrayList<CAGParasData>() ;	
	try {
		parabygistId=irrm.getCAGParasbyGistId(cagParaId,unitId);
	} catch (IRParasUserException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return new Gson().toJson(parabygistId);
	}
	
	//@RequestMapping(value = "omrest/repai-history",method = RequestMethod.GET)
	/*public void getrepairData(Long tankId) throws LeagalUserException {

		URL url = null;
		//String urlParameters = null;
		JSONObject obj = new JSONObject();
		try {
			url = new URL("https://missionkakatiya.cgg.gov.in/OTRestServices/service/missionkakatiya/repairData?tankId="+tankId+"&user=mkuser&password=mkuser123");

			obj.put("tankId", tankId);
			obj.put("user", "mkuser");
			obj.put("password", "mkuser123");
			//urlParameters = obj.toString();
		} catch (MalformedURLException e2) {
			//log.info(e2.getStackTrace().toString());
			e2.printStackTrace();
		}
		HttpURLConnection postConnection = null;
		try {
			postConnection = (HttpURLConnection) url.openConnection();
		} catch (IOException e2) {
			//log.info(e2.getStackTrace().toString());
			e2.printStackTrace();
		}
		try {
			postConnection.setRequestMethod("GET");
		} catch (ProtocolException e1) {
			//log.info(e1.getStackTrace().toString());
			e1.printStackTrace();
		}
	//	String accesstoken = null;
		try {
			accesstoken = IFMISUtils.accesstoken();
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		//postConnection.setConnectTimeout(5000);
		postConnection.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
		postConnection.setRequestProperty("Accept", "application/json");
	//	postConnection.setRequestProperty("Authorization", accesstoken);
		postConnection.setDoOutput(true);
		postConnection.setDoInput(true);

		try (OutputStream os = postConnection.getOutputStream()) {
			byte[] input = urlParameters.getBytes("utf-8");
			os.write(input, 0, input.length);
			os.close();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
		//	log.info(e.getStackTrace().toString());
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//log.info(e.getStackTrace().toString());
			e.printStackTrace();
		}

		int responseCode = 0;
		try {
			responseCode = postConnection.getResponseCode();
			System.out.println("responseCode"+responseCode);
		} catch (IOException e) {
			e.printStackTrace();
			//log.info(e.getStackTrace().toString());
		}

		
		if (responseCode == 200) { // success
			BufferedReader in = null;
			try {
				in = new BufferedReader(new InputStreamReader(postConnection.getInputStream()));
			} catch (IOException e) {
				//log.info(e.getStackTrace().toString());
				e.printStackTrace();
			}
			String inputLine;
			StringBuffer response = new StringBuffer();
			try {
				while ((inputLine = in.readLine()) != null) {
					response.append(inputLine);
				}
			} catch (IOException e) {
				//log.info(e.getStackTrace().toString());
				e.printStackTrace();
			}
			try {
				in.close();
			} catch (IOException e) {
				//log.info(e.getStackTrace().toString());
				e.printStackTrace();
			}
			// print result

			JSONParser parse = new JSONParser();
			JSONObject jobj = null;
			try {
				jobj = (JSONObject) parse.parse(response.toString());
			} catch (ParseException e) {
				//log.info(e.getStackTrace().toString());
				e.printStackTrace();
			}
			System.out.println(jobj + "agency object");
			JSONObject jArray = (JSONObject) jobj.get("data");
			System.out.println("jArray" +jArray);
			JSONArray repairdata = new JSONArray();
			JSONArray agmt_data = new JSONArray();
			JSONArray tender_data = new JSONArray();
			JSONArray admin_sanction_data = new JSONArray();
			JSONArray tank_data = new JSONArray();
			String agencyName = null;

			repairdata = (JSONArray) jArray.get("repairdata");
			System.out.println("repairdata" +repairdata);
			tank_data = (JSONArray) jArray.get("tank_data");
			agmt_data = (JSONArray) jArray.get("agmt_data");
			System.out.println("agmt_data" +agmt_data);
			tender_data = (JSONArray) jArray.get("tender_data");
			System.out.println("tender_data" +tender_data);
			admin_sanction_data = (JSONArray) jArray.get("admin_sanction_data");
			System.out.println("admin_sanction_data" +admin_sanction_data);
			
			System.out.println("tank_data" +tank_data);
			List<mkTankData> mktdl =new ArrayList<mkTankData>();
			if (tank_data != null && tank_data.size() > 0) {
				
				JSONObject jsonObject1 = (JSONObject) tank_data.get(0);
				mkTankData tdl = new mkTankData();
				System.out.println("mkrdl "+jsonObject1);
                tdl.setTank_code((String.valueOf(jsonObject1.get("tank_code").toString())));
                System.out.println("rdl.getUnit_name()"+ tdl.getTank_code());
				tdl.setTank_name(String.valueOf(jsonObject1.get("tank_name").toString()));
				tdl.setVname(String.valueOf(jsonObject1.get("vname").toString()));
				tdl.setTank_id(jsonObject1.get("tank_id").toString());
				tdl.setDname(jsonObject1.get("dname").toString());
				tdl.setMname(jsonObject1.get("mname").toString());
				tdl.setHname(jsonObject1.get("hname").toString());
				tdl.setGeo_id(jsonObject1.get("geo_id").toString());
				
				
				mktdl.add(tdl);
				System.out.println("mktdl "+mktdl);
			}
			List<mkRepairData> mkrdl = new ArrayList<mkRepairData>();
			if (repairdata != null && repairdata.size() > 0) {
				
					JSONObject jsonObject1 = (JSONObject) repairdata.get(0);
					mkRepairData rdl = new mkRepairData();
                    rdl.setUnit_name((jsonObject1.get("unit_name").toString()));
					rdl.setApproved_boq_id((jsonObject1.get("approved_boq_id").toString()));
					rdl.setBoq_sr_item_number((jsonObject1.get("boq_sr_item_number").toString()));
					rdl.setQuantity(jsonObject1.get("quantity").toString());
					rdl.setTypeofwork(jsonObject1.get("typeofwork").toString());
					rdl.setItemtypeid(jsonObject1.get("itemtypeid").toString());
					rdl.setItem_name(jsonObject1.get("item_name").toString());
					rdl.setWork_done_quantity(jsonObject1.get("work_done_quantity").toString());
					
					if(jsonObject1.get("unit_id").equals("")){
						rdl.setUnit_id(0);
					}else{
						rdl.setUnit_id(Integer.parseInt(jsonObject1.get("unit_id").toString()));
					}
					
					rdl.setRate_per_unit(jsonObject1.get("rate_per_unit").toString());
					rdl.setCustomized_description(jsonObject1.get("customized_description").toString());
					
					mkrdl.add(rdl);
					System.out.println("mkrdl "+mkrdl);
				}
			
			
		} else 
			System.out.println("POST NOT WORKED");
		}
	//	return agencyLists;
	}*/
	
	/*@POST
	@Path("https://missionkakatiya.cgg.gov.in/OTRestServices/service/missionkakatiya/repairData?tankId=63176&user=mkuser&password=mkuser123")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public void gethrmessage(mkTankData mktd) {
	    System.out.println(mktd.tank_name);
	    System.out.println(mktd.tank_code);
	    System.out.println(mktd.vname);
	}*/
	
	
	/*@CrossOrigin (origins = "https://missionkakatiya.cgg.gov.in/OTRestServices/service/missionkakatiya/repairData")
	@RequestMapping(value = "omrest/repai-history",  method = RequestMethod.GET,consumes="application/json")
	@ResponseBody
	public String getrepairData(Integer tankId) throws LeagalUserException {
		
		
	//System.out.println("nextcome"+cagGistId);	
	List<CAGParasData>  parabygistId = new ArrayList<CAGParasData>() ;	
	try {
	//	parabygistId=irrm.getCAGParasbyGistId(cagParaId,unitId);
	} catch (IRParasUserException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return new Gson().toJson(parabygistId);
	}*/
	
	
	/*@RequestMapping(value = "/parasrest/parasReplyByPara",  method = RequestMethod.GET,produces="application/json")
	@ResponseBody
	public String getCAGReplys( Integer cagParaId) throws LeagalUserException {
		
		
//	System.out.println("nextcome"+paraId);	
	List<ReplyData>  replybyGistId = new ArrayList<ReplyData>();
	try {
		//replybyGistId=irrm.getCAGReplybyGistId(cagParaId);
		
		
	} catch (IRParasUserException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return new Gson().toJson(replybyGistId);
	}*/
	
}
