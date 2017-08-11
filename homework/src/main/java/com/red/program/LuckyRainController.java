package com.red.program;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.red.program.dao.LuckyRecordDAO;
import com.red.program.model.LuckyRecord;

import luckyThread.LuckyRainThread;

/**
 * 红包雨相关控制流程
 * 
 * @author lenovo
 *
 */

@Controller
public class LuckyRainController {
	@Autowired
	JdbcTemplate jdbcTemplate;

	//int round = 0;
	
	@RequestMapping("lucky_on")
	public String lucky_on(String round,Model model) {
		int r = Integer.parseInt(round);
		LuckyRainThread t = new LuckyRainThread();
		t.setTemplate(jdbcTemplate);
		t.setRound(r);
		t.start();
		return "rainning";
	}

	@RequestMapping("luckyrecord")
	public String luckyrrecord( Model model) {
		return "luckyresult";
	}

	@RequestMapping("luckyresult")
	public String luckyresult(String round, Model model) {
		System.out.println("roundList" + round);
		int r = Integer.parseInt(round);
		List<LuckyRecord> luckylist;
		if (r == 0) {
			luckylist = LuckyRecordDAO.getAll(jdbcTemplate);
		} else {
			luckylist = LuckyRecordDAO.getAllByRound(r, jdbcTemplate);
		}
		model.addAttribute("list", luckylist);
		return "luckyresult";
	}
}
