package com.red.program;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.red.program.dao.AdminUserDAO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	@Autowired
	 JdbcTemplate jdbcTemplate;
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
//		Date date = new Date();
//		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
//		
//		String formattedDate = dateFormat.format(date);
//		
//		model.addAttribute("serverTime", formattedDate );
		
		return "maopaohome";
	}
	@RequestMapping(value = "chatlogin", method = RequestMethod.GET)
	public String gotoChatLogin() {
		return "chat/logins";
	}
	
	@RequestMapping(value = "maopaoAd", method = RequestMethod.GET)
	public String gotomph() {
		return "home";
	}
	

	@RequestMapping(value = "redlogin", method = RequestMethod.GET)
	public String redLogin() {
		return "redlogin";
	}
	@RequestMapping("adminlogin")
	public String addadmin123(String itcode,String name,String password,Model model) {
		String result = null;
		System.out.println("password"+password);
		//if(password=="maopao") {
				if(AdminUserDAO.checkIsAdmin(itcode, password, jdbcTemplate)) {
				     return "admin";
				}
				else {
					result="当前用户不是管理员或信息输入错误，请重新输入";
					model.addAttribute("result",result);
					return "home";
				}
			
	}
}
