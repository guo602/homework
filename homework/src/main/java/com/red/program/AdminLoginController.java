package com.red.program;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.red.program.dao.AdminUserDAO;
import com.red.program.dao.AlluserDAO;

public class AdminLoginController {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	@RequestMapping("admin_login")
	public String addadmin(String itcode,String password,Model model) {
		String result = null;

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
}
