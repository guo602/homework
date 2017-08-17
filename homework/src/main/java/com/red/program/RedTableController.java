package com.red.program;

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
	public String checkopen(Model model) {
		
		model.addAttribute("isopen", "1");
		
		return "n";
	}
	
	
}
