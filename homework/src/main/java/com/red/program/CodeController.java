package com.red.program;



import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import validateCode.ValidateCode;

@Controller
public class CodeController {
	@Autowired  
	HttpServletRequest request;  
	
	
	@ResponseBody
	@RequestMapping(value = "validatecode", method = RequestMethod.GET)
	public String path() {
		System.out.println("in validatecode Controller");
		HttpSession session=request.getSession();
		String path="";
		
		List<String> sl=ValidateCode.ValicodePathAnswer();
		if(sl==null)System.out.println("str null");
		
		System.out.println(sl.get(0));
		path=sl.get(0);
		System.out.println("return "+path);
		
		
		
		session.setAttribute("valicode",sl.get(1));
		System.out.println("this is session vali anwser :"+session.getAttribute("valicode"));
		return path;
	}
}
