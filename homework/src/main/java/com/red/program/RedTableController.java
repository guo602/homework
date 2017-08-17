package com.red.program;

import java.io.UnsupportedEncodingException;
import java.lang.annotation.Repeatable;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.red.program.dao.TradeDAO;
import com.red.program.model.Trade;


@Controller
public class RedTableController {
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Autowired  
	  HttpServletRequest request;  
	
	@RequestMapping(value ="check_open_ajax", method = RequestMethod.GET)
	@ResponseBody
	public String checkopen(Model model) {
		
		
		return "1";
	}
	

	@RequestMapping(value ="get_red_ajax", method = RequestMethod.GET)
	public String cget_red_ajaxn(Model model) {
		
		//model.addAttribute("isopen", "1");
		
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("i get this");
		
		
		
		
		
		
		
		model.addAttribute("msg", "1");
		
		return "getmsg";
	}
	
	@RequestMapping(value ="get_redlist_ajax", method = RequestMethod.GET)
	public String get_redlist_ajax(Model model) {
		
	
		
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("req:get_redlist_ajax");
		
		
		
		
		
		
		
		model.addAttribute("msg", "1");
		
		return "redlist";
	}
	
	
}