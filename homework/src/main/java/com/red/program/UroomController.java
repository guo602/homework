package com.red.program;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UroomController {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@RequestMapping("recharge")
	public String newbyadmin(Model model) {
		return "recharge";
	}

	
	
}
