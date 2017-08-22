package com.red.program;



import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import validateCode.ValidateCode;

@Controller
public class CodeController {
	@ResponseBody
	@RequestMapping(value = "validatecode", method = RequestMethod.GET)
	public String path() {
		System.out.println("in validatecode Controller");
		
		String path="";
		
		List<String> sl=ValidateCode.ValicodePathAnswer();
		if(sl==null)System.out.println("str null");
		
		System.out.println(sl.get(0));
		path=sl.get(0);
		System.out.println("return "+path);
		return path;
	}
}
