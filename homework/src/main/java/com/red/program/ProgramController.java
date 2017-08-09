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
	 * home界面跳转到管理员界面
	 * @param model
	 * @return
	 */
	@RequestMapping("program")
	public String home(Model model) {
		return "admin";
	}
}