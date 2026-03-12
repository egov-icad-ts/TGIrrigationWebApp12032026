package in.ts.icad.leagal.util;



import java.io.UnsupportedEncodingException;





import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;




import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;



import in.ts.icad.leagal.exception.LeagalUserException;

public class TankRepairHistory {
	

	public static	JSONParser parse = new JSONParser();
	public static 	JSONObject jobj = null;
	public  static JSONObject jArray;
	
	String agencyName = null;
	
	public static JSONObject getTankRepairHistory(Long tankId) throws LeagalUserException {
		URL url = null;
		HttpURLConnection postConnection = null;
		BufferedReader in = null;

		String inputLine;
		StringBuffer response = new StringBuffer();
		//String urlParameters = null;
		//JSONObject obj = new JSONObject();
		try {
			url = new URL("https://missionkakatiya.cgg.gov.in/OTRestServices/service/missionkakatiya/repairData?tankId="+tankId+"&user=mkuser&password=mkuser123");
/*
			obj.put("tankId", tankId);
			obj.put("user", "mkuser");
			obj.put("password", "mkuser123");*/
			//urlParameters = obj.toString();
		
			postConnection = (HttpURLConnection) url.openConnection();
			postConnection.setRequestMethod("GET");
			//postConnection.setConnectTimeout(5000);
			postConnection.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
			postConnection.setRequestProperty("Accept", "application/json");
		//	postConnection.setRequestProperty("Authorization", accesstoken);
			postConnection.setDoOutput(true);
			postConnection.setDoInput(true);
			
			int responseCode = 0;
			responseCode = postConnection.getResponseCode();
			
			if (responseCode == 200) { // success
	
			
					in = new BufferedReader(new InputStreamReader(postConnection.getInputStream()));
					while ((inputLine = in.readLine()) != null) {
						response.append(inputLine);
					}
					in.close();
					jobj = (JSONObject) parse.parse(response.toString());
					
				//	System.out.println("jobj"+jobj);
				
			
				 jArray = (JSONObject) jobj.get("data");
				 
				// System.out.println("jArray"+jArray);
			
		
				
				
				
				
			} /*else 
				System.out.println("POST NOT WORKED");
			}*/
			
		} catch (ProtocolException e5){
			
			e5.printStackTrace();
			
		}catch (UnsupportedEncodingException e4) {
			// TODO Auto-generated catch block
		//	log.info(e.getStackTrace().toString());
			e4.printStackTrace();
		}
		catch (MalformedURLException e2) {
			//log.info(e2.getStackTrace().toString());
			e2.printStackTrace();
		}catch (IOException e3) {
			//log.info(e2.getStackTrace().toString());
			e3.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	     
	
		return jArray;
	
}
	
	

	
}
	 
	 
	 
	
	       

	











