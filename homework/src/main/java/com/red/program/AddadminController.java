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
		return "adminmodify";
	}
	
	@RequestMapping("adduser")
	public String addus(Model model) {
		return "adminmodify";
	}
	
	@RequestMapping("deleteby")
	public String delete(Model model) {
		return "adminmodify";
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
		return "adminmodify";
	}
	
	/**
	 * 响应管理员界面请求，添加用户
	 * @param model
	 * @return
	 */
	@RequestMapping("adduserbyadmin")
	public String adduser(String itcode1,String name1,Model model) {
		String result = null;
		
		//System.out.println(password);
		//if(password=="maopao") {
			if(!AlluserDAO.checkUserInfo(itcode1, name1, jdbcTemplate)) {
				    AlluserDAO.createUser(itcode1, name1, jdbcTemplate);
				    result="成功添加用户" +name1;
			}
			else {
				result="当前用户已存在";
			}
//		}
//		else {
//			result="管理员确认密码错误";
//		}
		model.addAttribute("result1",result);
		return "adminmodify";
	}
	
	/**
	 * 响应管理员界面请求，添加用户
	 * @param model
	 * @return
	 */
	@RequestMapping("deletebyadmin")
	public String deleteuser(String itcode2,String name2,Model model) {
		String result = null;
		System.out.println("itcode2"+itcode2);
		System.out.println("name2"+name2);
		//if(password=="maopao") {
			if(AlluserDAO.checkUserInfo(itcode2, name2, jdbcTemplate)) {
				    if(AdminUserDAO.AdminDelete(itcode2, jdbcTemplate)==1) {
				    result="成功删除用户" +name2;
				    }
				    else {
				    	result="删除用户" +name2+"失败";
				    }
			}
			else {
				result="当前用户不存在，无法删除";
			}
//		}
//		else {
//			result="管理员确认密码错误";
//		}
		model.addAttribute("result2",result);
		return "adminmodify";
	}
}
