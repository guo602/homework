package com.red.program;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.red.program.dao.BonusDAO;
import com.red.program.dao.ProgramDAO;
import com.red.program.dao.TradeDAO;
import com.red.program.model.LuckyRecord;
import com.red.program.model.Program;
import com.red.program.model.Trade;

@Controller
public class RewardController {
	@Autowired
	JdbcTemplate jdbcTemplate;

	

	@RequestMapping("openbonus")
	public String openbonus(String pid, Model model) {
		String result = new String();
		int p = Integer.parseInt(pid);
		if (p == 0) {
			List<Program> programs = ProgramDAO.getAll(jdbcTemplate);
			int sign = 1;
			for (Program pro : programs) {
				int open = BonusDAO.Isopen(pro.getPid(), jdbcTemplate);
				if (open == 1) {
					continue;
				} else {
					if (open == 0) {
						boolean ok = BonusDAO.CreateBonus(pro.getPid(), jdbcTemplate);
						if (ok == false) {
							sign = 0;
							break;
						}
					} else {
						sign = 0;
						break;
					}
				}
			}
			if (sign == 1) {
				result = "成功开启所有节目打赏功能";
			} else {
				result = "打赏功能开启失败，请重试";
			}
		} else {
			int isopen = BonusDAO.Isopen(p, jdbcTemplate);

			System.out.println(isopen);
			if (isopen == 1) {
				result = "节目已开启打赏功能";
			} else {
				if (isopen == 0) {
					boolean isok = BonusDAO.CreateBonus(p, jdbcTemplate);
					if (isok == true) {
						result = "成功开启打赏功能";
					} else {
						result = "打赏功能开启失败，请重试";
					}
				} else {
					result = "打赏功能开启失败，请重试";
				}
			}
		}
		List<Program> luckylist = ProgramDAO.getAll(jdbcTemplate);
		model.addAttribute("list", luckylist);
		model.addAttribute("result", result);

		return "openbonus";
	}


	@RequestMapping("rewardresult")
	public String rewardresult(String all, Model model) {
		String result = new String();
		List<Trade> trades = null ;
		int a = Integer.parseInt(all);
		if (a == 0) {
			trades = TradeDAO.getAllReward(jdbcTemplate);
			if (trades != null) {
				result = "查询打赏记录成功";
			} else {
				result = "查询打赏记录失败或打赏记录为空";
			}
		}
		else {
			trades = TradeDAO.getAll(jdbcTemplate);
			if (trades != null) {
				result = "哪里失败";
			} else {
				result = "交易记录为空";
			}
		}
		
		model.addAttribute("list", trades);
		model.addAttribute("result", result);
		return "rewardresult";
	}
	
	@RequestMapping("rechargerecord")
	public String gorechargeresult(Model model) {
		return "rechargeresult";
	}

	@RequestMapping("rechargeresult")
	public String rechargeresult(String all, Model model) {
		String result = new String();
		List<Trade> trades = null ;
		int a = Integer.parseInt(all);
		if (a == 1) {
			trades = TradeDAO.getAllRecharge(jdbcTemplate);
			if (trades != null) {
				result = "查询充值记录成功";
			} else {
				result = "查询充值记录失败或充值记录为空";
			}
		}
		else {
			trades = TradeDAO.getAll(jdbcTemplate);
			if (trades != null) {
				result = "哪里失败";
			} else {
				result = "交易记录为空";
			}
		}
		
		model.addAttribute("list", trades);
		model.addAttribute("result", result);
		return "rechargeresult";
	}
}
