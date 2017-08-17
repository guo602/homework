package com.red.program;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.red.program.dao.ProgramDAO;
import com.red.program.model.Program;

import luckyThread.LuckyRainThread;

@Controller
public class AdminController {
	@Autowired
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
	 * 跳转到激活用户账户界面
	 * @param model
	 * @return
	 */
	@RequestMapping("program")
	public String goprogram(Model model) {
		
		List<Program> programs=ProgramDAO.getAll(jdbcTemplate);
		model.addAttribute("list", programs);
		return "program";
	}
	
	/**
	 * 跳转到添加管理员界面
	 * @param model
	 * @return
	 */
	@RequestMapping("addadmin")
	public String goaddadmin(Model model) {
		return "adminmodify";
	}
	
	/**
	 * 跳转到激活用户账户界面
	 * @param model
	 * @return
	 */
	@RequestMapping("wallet")
	public String gowallet(Model model) {
		return "walletbyadmin";
	}
   
	/**
	 * 跳转到评论管理界面
	 * @param model
	 * @return
	 */
	@RequestMapping("comment")
	public String gocomment(Model model) {
		return "commentbyadmin";
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
	
	/**
	 * 跳转到打赏开启界面
	 * @param model
	 * @return
	 */
	@RequestMapping("reward")
	public String goreward(Model model) {
		List<Program> programlist = ProgramDAO.getAll(jdbcTemplate);
		System.out.println();
		model.addAttribute("list", programlist);
		return "openbonus";
	}
	
	/**
	 * 跳转到红包记录界面
	 * @param model
	 * @return
	 */
	@RequestMapping("luckyrecord")
	public String luckyrrecord( Model model) {
		return "luckyresult";
	}

	/**
	 * 跳转到打赏记录界面
	 * @param model
	 * @return
	 */
	@RequestMapping("rewardrecord")
	public String gorewardresult(Model model) {
		return "rewardresult";
	}
	
	/**
	 * 跳转到充值记录界面
	 * @param model
	 * @return
	 */
	@RequestMapping("rechargerecord")
	public String gorechargeresult(Model model) {
		return "rechargeresult";
	}

}
