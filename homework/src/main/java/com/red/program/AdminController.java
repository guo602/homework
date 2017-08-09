package com.red.program;


import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import luckyThread.LuckyRainThread;

@Controller
public class AdminController {
	
	 JdbcTemplate jdbcTemplate;
	/**
	 * home界面跳转到管理员界面
	 * @param model
	 * @return
	 */
	@RequestMapping("admin")
	public String home(Model model) {
		return "admin";
	}
	/**
	 * 管理员确认密码,很想保留确认密码功能，跳转到开启红包雨界面
	 * @param model
	 * @return
	 */
	@RequestMapping("luckyrain")
	public String luckyrain(Model model) {
		return "luckyrain";
	}
	

}
