package org.pkb.springlogin.controller;
 
import java.io.IOException;
import java.security.Principal;

import javax.servlet.http.HttpServletRequest;

import org.pkb.springlogin.manager.EmailHandler;
import org.pkb.springlogin.manager.SignUpHandler;
import org.pkb.springlogin.model.CompanyRegVO;
import org.pkb.springlogin.model.Verify;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import net.tanesha.recaptcha.ReCaptchaImpl;


 
@Controller
public class MainController {
	@Autowired
	SignUpHandler signupHandler;
	@Autowired
	EmailHandler emailHandler;
	private static final Logger logger =LoggerFactory.getLogger(MainController.class);
   @RequestMapping(value = { "/", "/welcome" }, method = RequestMethod.GET)
   public String welcomePage(Model model) {
       model.addAttribute("title", "Welcome");
       model.addAttribute("message", "Hello friend!");
       return "welcomePage";
   }
 
   @RequestMapping(value = "/admin", method = RequestMethod.GET)
   public String adminPage(Model model) {
       return "adminPage";
   }
 
   @RequestMapping(value="/addCompany",method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE)
   public@ResponseBody String userLogin(@RequestBody CompanyRegVO user,HttpServletRequest req){
   	logger.debug("signUp user:"+user);
   	 // get reCAPTCHA request param
 	String gRecaptchaResponse = req.getParameter("g-recaptcha-response");
 	boolean isVerified=	Verify.verifyGcaptchResponse(gRecaptchaResponse);
 	ObjectMapper mapper=new ObjectMapper();
 	String jsonString="";   	
 	System.out.println("signUp user:"+user);
 	Integer id=null;
 	try{
 		if(isVerified){
 			id = signupHandler.process(user);
 			if(id!=null){
 		   		logger.debug("ID in controller:"+id);
 		   		
 		   		emailHandler.sendVerificationMail(id,user.getEmail());
 		   		System.out.println("user create successfully");	
 		   		
 		   	}
 			jsonString=mapper.writeValueAsString("User creaated successfully");

 		}
 		 else
 		jsonString=	mapper.writeValueAsString("please verify that you are not a robot");
	} catch (JsonGenerationException e) {
		
		e.printStackTrace();
	} catch (JsonMappingException e) {
		
		e.printStackTrace();
	} catch (IOException e) {
				e.printStackTrace();
	} catch (Exception e) {
		try {
			jsonString=mapper.writeValueAsString(e.getMessage());
		} catch (JsonProcessingException e1) {
			
		}
		return jsonString;
	}
   	

	return "success";
   	
   }


@RequestMapping(value="/verifyUser",method=RequestMethod.GET)
   public String verifyUser(@RequestParam("verify")String verificationValue,Model model){
	   signupHandler.verifyUser(verificationValue);
	   return "successVerification";
   }
   @RequestMapping(value="/signUp")
   public String register(Model model){
   	CompanyRegVO user=new CompanyRegVO();
   	model.addAttribute("userForm", user);
   	return "signUp";
   }
   @RequestMapping(value = "/login", method = RequestMethod.GET)
   public String loginPage(Model model ) {
      
       return "loginPage";
   }
 
   @RequestMapping(value = "/logoutSuccessful", method = RequestMethod.GET)
   public String logoutSuccessfulPage(Model model) {
       model.addAttribute("title", "Logout");
       return "logoutSuccessfulPage";
   }
 
   @RequestMapping(value = "/userInfo", method = RequestMethod.GET)
   public String userInfo(Model model, Principal principal) {
 
       // After user login successfully.
       String userName = principal.getName();
 
       System.out.println("User Name: "+ userName);
 
       return "userInfoPage";
   }
 
   @RequestMapping(value = "/403", method = RequestMethod.GET)
   public String accessDenied(Model model, Principal principal) {
        
       if (principal != null) {
           model.addAttribute("message", "Hi " + principal.getName()
                   + "<br> You do not have permission to access this page!");
       } else {
           model.addAttribute("msg",
                   "You do not have permission to access this page!");
       }
       return "403Page";
   }
}