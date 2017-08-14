package com.red.program;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.red.program.dao.AlluserDAO;
import com.red.program.dao.LuckyRecordDAO;
import com.red.program.model.All_user;
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

	// int round = 0;

	@RequestMapping("lucky_on")
	public String lucky_on(String round, Model model) {
		int r = Integer.parseInt(round);
		LuckyRainThread t = new LuckyRainThread();
		t.setTemplate(jdbcTemplate);
		t.setRound(r);
		t.start();
		return "rainning";
	}

	@RequestMapping("luckyresult")
	public String luckyresult(String round, String itcode, String number, Model model) {

		int r = Integer.parseInt(round);
		int n = Integer.parseInt(number);
		System.out.println("round"+round);
		System.out.println("itcode"+itcode);
		System.out.println("number"+number);
		List<LuckyRecord> luckylist;
		if (itcode != "") {
			All_user user = AlluserDAO.getUserByItcode(itcode, jdbcTemplate);
			if (r == 0) {
				System.out.println("error1");
				luckylist = LuckyRecordDAO.getAllByUid(user.getUid(), jdbcTemplate);
			} else {
				System.out.println("error2");
				luckylist = LuckyRecordDAO.getByit_round(itcode, r, jdbcTemplate);
			}
		} else {
			if (n == 0) {
				if (r == 0) {
					System.out.println("error3");
					luckylist = LuckyRecordDAO.getAll(jdbcTemplate);
				} else {
					System.out.println("error4");
					luckylist = LuckyRecordDAO.getAllByRound(r, jdbcTemplate);
				}
			}
			else {
				if(r==0) {
					System.out.println("error5");
					luckylist = LuckyRecordDAO.getLatest(n, jdbcTemplate);
				}
				else {
					System.out.println("error6");
					luckylist = LuckyRecordDAO.getLatestByRound(n, r, jdbcTemplate);
				}
			}
		}
		String result;
		if(luckylist!=null) {
			if(luckylist.size()!=0) {
			    result="查询成功";
			}
			else {
				result="当前条件下无记录";
			}
		}
		else {
			result="查询失败";
		}
		model.addAttribute("list", luckylist);
		model.addAttribute("result", result);
		return "luckyresult";
	}
}
