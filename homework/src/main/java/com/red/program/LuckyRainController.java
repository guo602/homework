package com.red.program;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import luckyThread.LuckyRainThread;
/**
 * 红包雨相关控制流程
 * @author lenovo
 *
 */

@Controller
public class LuckyRainController {
	JdbcTemplate jdbcTemplate;
	
	int round=0;

	
	@RequestMapping("lucky_on")
	public String lucky_on(Model model) {
	    round++;
		LuckyRainThread t=new LuckyRainThread();
		t.setTemplate(jdbcTemplate);
		t.setRound(round);
		t.start();
		return "rainning";
	}
	
	@RequestMapping("luckyreult")
	public String luckyresult(String round,Model model) {
	    
		return "luckyresult";
	}
}
