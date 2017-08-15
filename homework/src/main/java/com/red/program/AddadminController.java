package com.red.program;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.red.program.dao.AdminUserDAO;
import com.red.program.dao.AlluserDAO;

@Controller
public class AddadminController {
	@Autowired
	 JdbcTemplate jdbcTemplate;
	
	/**
	 * 响应管理员界面请求
	 * @param model
	 * @return
	 */
	@RequestMapping("newadmin")
	public String home(String itcode,String name,String password,Model model) {
		String result = null;
		System.out.println(password);
		//if(password=="maopao") {
			if(AlluserDAO.checkUserInfo(itcode, name, jdbcTemplate)) {
				if(!AdminUserDAO.checkAdminUserInfo(itcode, name, jdbcTemplate)) {
				    AdminUserDAO.createAdminUser(itcode, name, jdbcTemplate);
				    result="成功添加管理员" +name;
				}
				else {
					result="当前用户是管理员，不需要重复添加";
				}
			}
			else {
				result="添加用户不是公司员工，无法添加";
			}
//		}
//		else {
//			result="管理员确认密码错误";
//		}
		model.addAttribute("result",result);
		return "addadminbyadmin";
	}
}
