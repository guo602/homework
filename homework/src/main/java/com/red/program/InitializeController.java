package com.red.program;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import jdbcInitialize.InitializeDAO;

@Controller
public class InitializeController {
@Autowired
JdbcTemplate jdbcTemplate;
@RequestMapping("initial")
public String initialize()
{
	InitializeDAO.Initial(jdbcTemplate);
	return "home";
}
}
