package com.red.program;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RedLoginController {

	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Autowired  
	  HttpServletRequest request;  
	
	@RequestMapping(value = "validateuser", method = RequestMethod.GET)
	public String validateRed(Model model) {
		
		boolean validate=true;
		try {
			request.setCharacterEncoding("UTF-8");
			System.out.println(1);
			String itcode=request.getParameter("itcode");
			String name=request.getParameter("name");
			System.out.println(itcode);

			if(itcode.equals(""))validate=false;
			else if(name.equals(""))validate=false;
			  

			else;
			System.out.println(2);
			
			if(validate)
				
				
				return "room";
			
			
			
			else	return "redValidateFail";
			
			
			
			
			
			
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			return "redValidateFail";
			
		}

	}
	
	
}
