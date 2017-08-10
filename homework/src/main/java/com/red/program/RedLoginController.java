package com.red.program;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.red.program.dao.AlluserDAO;

@Controller
public class RedLoginController {

	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Autowired  
	  HttpServletRequest request;  
	
	@RequestMapping(value = "validateuser", method = RequestMethod.GET)
	public String validateRed(Model model) {
		
		try {
			request.setCharacterEncoding("UTF-8");
	
			String itcode=request.getParameter("itcode");
			String name=request.getParameter("name");
			String verify=request.getParameter("verify");
		
			
			
			if(AlluserDAO.checkUserInfo(itcode,name,jdbcTemplate) && verify.equals("1234") )
				
				
				return "room";
			
			
			
			else	return "redValidateFail";
			
			
			
			
			
			
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			return "redValidateFail";
			
		}

	}
	
	

	@RequestMapping(value = "rlproblem", method = RequestMethod.GET)
	public String redlproblem(Model model) {
		
			return "redloginproblem";
			
	}
	
	
	
}
