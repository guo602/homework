package com.red.program;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.red.program.dao.AlluserDAO;
import com.red.program.dao.LuckyRecordDAO;
import com.red.program.dao.ProgramDAO;
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
		model.addAttribute("result", "第"+round+"红包雨成功开启");
		return "luckyrain";
	}

	@RequestMapping("luckyresult")
	public String luckyresult(String round, String itcode, String number, String page, Model model) {
		int r = Integer.parseInt(round);
		int n = Integer.parseInt(number);
		System.out.println("round"+round);
		System.out.println("itcode"+itcode);
		System.out.println("number"+number);
		List<LuckyRecord> luckylist;
		int fenye=0;
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
					fenye=1;
				} else {
					System.out.println("error4");
					luckylist = LuckyRecordDAO.getAllByRound(r, jdbcTemplate);
					fenye=0;
				}
			}
			else {
				if(r==0) {
					System.out.println("error5");
					luckylist = LuckyRecordDAO.getLatest(n, jdbcTemplate);
					fenye=0;
				}
				else {
					System.out.println("error6");
					luckylist = LuckyRecordDAO.getLatestByRound(n, r, jdbcTemplate);
					fenye=0;
				}
			}
		}
		String result;
		String sign;
		if(luckylist!=null) {
			if(luckylist.size()!=0) {
			    result="查询成功";
			    sign="ok";
			}
			else {
				result="当前条件下无记录";
				sign="ok";
			}
		}
		else {
			result="查询失败";
			sign="no";
		}
		int pa;
		try {
			// 当前页数
			pa = Integer.valueOf(page);
		} catch (NumberFormatException e) {
			pa = 1;
		}
		// 用户总数
		int total = luckylist.size();
		// 每页用户数
		int luckyPerPage = 10;
		// 总页数
		int totalPages = total % luckyPerPage == 0 ? total / luckyPerPage : total / luckyPerPage + 1;
		// 本页起始用户序号
		int beginIndex = (pa - 1) * luckyPerPage;
		// 本页末尾用户序号的下一个
		int endIndex = beginIndex + luckyPerPage;
		if (endIndex > total)
			endIndex = total;
		model.addAttribute("totalPages", totalPages);
		model.addAttribute("page", page);
		if (fenye == 1) {
			luckylist=luckylist.subList(beginIndex, endIndex);
		}
		model.addAttribute("list", luckylist);
		model.addAttribute("result", result);
		model.addAttribute("sign", sign);
		return "luckyresult";
	}
}
