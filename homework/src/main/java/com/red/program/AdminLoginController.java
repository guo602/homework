package com.red.program;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.red.program.dao.AdminUserDAO;


@Controller
public class AdminLoginController {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	
}
