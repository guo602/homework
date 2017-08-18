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
		System.out.println("pid"+pid);
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
            Program pro=ProgramDAO.getProgramByPid(p, jdbcTemplate);
            String name=pro.getPro_name();
			System.out.println(isopen);
			if (isopen == 1) {
				result = "节目"+name+"已开启打赏功能";
			} else {
				if (isopen == 0) {
					boolean isok = BonusDAO.CreateBonus(p, jdbcTemplate);
					if (isok == true) {
						result = "成功开启节目"+name+"打赏功能";
					} else {
						result = "节目"+name+"打赏功能开启失败，请重试";
					}
				} else {
					result = "节目"+name+"打赏功能开启失败，请重试";
				}
			}
		}
		List<Program> luckylist = ProgramDAO.getAll(jdbcTemplate);
		model.addAttribute("list", luckylist);
		model.addAttribute("result", result);

		return "openbonus";
	}


	@RequestMapping("rewardresult")
	public String rewardresult(String itcode,String minvol,String maxvol,String beghour,String begmin,String endhour,String endmin, Model model) {
		String result = new String();
		List<Trade> trades = null ;
		String begtime="2017-08-08 "+beghour+":"+begmin+":00";
		String endtime="2017-08-08 "+endhour+":"+endmin+":00";
		int min = Integer.parseInt(minvol);
		int max = Integer.parseInt(maxvol);
		if (itcode!= "") {
			trades = TradeDAO.getRewardByIt_Time_Volumn(itcode, begtime, endtime, min, max, jdbcTemplate);
		}
		else {
			trades =TradeDAO.getRewardByTime_Volumn(begtime, endtime, min, max, jdbcTemplate);	
		}
		if(trades!=null) {
			if(trades.size()!=0) {
			    result="查询成功";
			}
			else {
				result="当前条件下无记录";
			}
		}
		else {
			result="查询失败";
		}
		model.addAttribute("list", trades);
		model.addAttribute("result", result);
		return "rewardresult";
	}
	

	@RequestMapping("rechargeresult")
	public String rechargeresult(String itcode,String minvol,String maxvol,String beghour,String begmin,String endhour,String endmin, Model model) {
		String result = new String();
		List<Trade> trades = null ;
		String begtime="2017-08-08 "+beghour+":"+begmin+":00";
		String endtime="2017-08-08 "+endhour+":"+endmin+":00";
		int min = Integer.parseInt(minvol);
		int max = Integer.parseInt(maxvol);
		if (itcode!= "") {
			trades = TradeDAO.getRechargeByIt_Time_Volumn(itcode, begtime,endtime, min, max, jdbcTemplate);
		}
		else {
			trades =TradeDAO.getRechargeByTime_Volumn(begtime, endtime, min, max, jdbcTemplate);	
		}
		if(trades!=null) {
			if(trades.size()!=0) {
			    result="查询成功";
			}
			else {
				result="当前条件下无记录";
			}
		}
		else {
			result="查询失败";
		}
		model.addAttribute("list", trades);
		model.addAttribute("result", result);
		return "rechargeresult";
	}
}
