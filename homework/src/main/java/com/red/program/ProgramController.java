package com.red.program;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProgramController {//节目单管理
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	/**
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("program_insert")
	public String program_insert(Model model) {
		return "program_insert";
	}
	
	@RequestMapping("program_search")
	public String program_search(Model model) {
		return "program_search";
	}
	
}