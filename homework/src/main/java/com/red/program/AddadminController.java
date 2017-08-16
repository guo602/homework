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
	
	@RequestMapping("newadminby")
	public String addad(Model model) {
		return "addadminbyadmin";
	}
	
	@RequestMapping("adduser")
	public String addus(Model model) {
		return "adduserbyadmin";
	}
	
	@RequestMapping("deleteby")
	public String delete(Model model) {
		return "deletebyadmin";
	}
	/**
	 * 响应管理员界面请求，添加管理员
	 * @param model
	 * @return
	 */
	@RequestMapping("newadmin")
	public String addadmin(String itcode,String name,Model model) {
		String result = null;
		System.out.println("为啥界面不显示");
		
		//System.out.println(password);
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
	
	/**
	 * 响应管理员界面请求，添加用户
	 * @param model
	 * @return
	 */
	@RequestMapping("adduserbyadmin")
	public String adduser(String itcode,String name,Model model) {
		String result = null;
		
		//System.out.println(password);
		//if(password=="maopao") {
			if(!AlluserDAO.checkUserInfo(itcode, name, jdbcTemplate)) {
				    AlluserDAO.createUser(itcode, name, jdbcTemplate);
				    result="成功添加用户" +name;
			}
			else {
				result="当前用户已存在";
			}
//		}
//		else {
//			result="管理员确认密码错误";
//		}
		model.addAttribute("result",result);
		return "adduserbyadmin";
	}
	
	/**
	 * 响应管理员界面请求，添加用户
	 * @param model
	 * @return
	 */
	@RequestMapping("deletebyadmin")
	public String deleteuser(String itcode,String name,Model model) {
		String result = null;
		
		//System.out.println(password);
		//if(password=="maopao") {
			if(AlluserDAO.checkUserInfo(itcode, name, jdbcTemplate)) {
				    if(AdminUserDAO.AdminDelete(itcode, jdbcTemplate)==1) {
				    result="成功删除用户" +name;
				    }
				    else {
				    	result="删除用户" +name+"失败";
				    }
			}
			else {
				result="当前用户不存在，无法删除";
			}
//		}
//		else {
//			result="管理员确认密码错误";
//		}
		model.addAttribute("result",result);
		return "deletebyadmin";
	}
}
