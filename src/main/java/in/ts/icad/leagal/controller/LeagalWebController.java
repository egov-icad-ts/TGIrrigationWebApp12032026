package in.ts.icad.leagal.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;

import in.ts.icad.leagal.exception.TaskUserException;
import in.ts.icad.leagal.manager.TaskAdminManager;
import in.ts.icad.leagal.model.Unit;
import in.ts.icad.leagal.util.TempAESEncryptionbackup;

@Controller()
public class LeagalWebController {
	
	@Autowired
	private TaskAdminManager tam;
	
	BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

	
	
	@RequestMapping(value = "/web/home")
	@ResponseBody
	public ModelAndView Home(SessionStatus status, HttpSession session) {
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("home");
		
        String captcha=(String)session.getAttribute("CAPTCHA");
        
       
    	List<Unit> unitList = new ArrayList<Unit>();
    	try {
			unitList = tam.getUnitList();
		} catch (TaskUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 mav.addObject("unitList", unitList);
		 
		// System.out.println("home_sessionget_Id_"+session.getId());
		// System.out.println("captchainhome"+captcha);
		return mav;
	}
	
	
	@RequestMapping(value = "/web/disclaimer")
	
	public ModelAndView Disclaimer(SessionStatus status, HttpSession session) {
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("disclaimer");
		return mav;
	}
	
	@RequestMapping(value = "/web/terms")

	public ModelAndView terms(SessionStatus status, HttpSession session) {
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("terms");
		return mav;
	}
	
	@ResponseBody
	@RequestMapping(value="web/getencryptpassword", method = RequestMethod.POST)
	public String getencryptpassword(@RequestParam("password") String password, HttpServletResponse response) throws Exception {

	String pwd = password;
	//System.out.println("in pwd:  "+pwd);

	 
	byte[] salt = TempAESEncryptionbackup.getSalt();
	//System.out.println("salt "+salt);
	 String saltpassword = (pwd+salt);
	// System.out.println("saltpassword "+saltpassword);
	String encryptedPassword = TempAESEncryptionbackup.encrypt(saltpassword);
//	System.out.println("in encryptedPassword "+encryptedPassword);

	//logic
	return encryptedPassword;

	}
	
	
	
	
	
	
	
	
}
