package com.cisco.portal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.cisco.models.JsonResponse;
import com.cisco.models.Register;
import com.cisco.models.UserJson;

@Controller
@RequestMapping("/")
public class HelloController {
	@RequestMapping("/hello")
	private String sayHello() {
		return "index";
	}
	
	@RequestMapping("/")
	private String goHome() {
		return "angular_app";
	}
	
	@RequestMapping(value = "/admin**", method = RequestMethod.GET)
	private @ResponseBody JsonResponse adminPage() {
		/*Register register = new Register();
		register.setFirstName("test");
		register.setLastName("last");
		register.setEmail("test@gmail.com");
		UserJson user = new UserJson();
		user.setRegister(register);
		return user;*/
		
		JsonResponse jsonResponse = new JsonResponse();
		jsonResponse.setStatus("200");
		jsonResponse.setAdditionalProperty("user", "isadmin");
		return jsonResponse ;
	}

	/*@RequestMapping(value = "/dba**", method = RequestMethod.GET)
	public ModelAndView dbaPage() {

		ModelAndView model = new ModelAndView();
		model.addObject("title", "Spring Security Hello World");
		model.addObject("message", "This is protected page - Database Page!");
		model.setViewName("admin");

		return model;

	}*/
	
/*	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
	    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    if (auth != null){    
	        new SecurityContextLogoutHandler().logout(request, response, auth);
	    }
	    return "redirect:/login?logout";//You can redirect wherever you want, but generally it's a good practice to show login screen again.
	}*/
}
