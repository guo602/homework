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
import com.red.program.dao.WalletDAO;
import com.red.program.model.Program;
import com.red.program.model.Trade;
import com.red.program.model.Wallet;

@Controller
public class RewardController {
	@Autowired
	JdbcTemplate jdbcTemplate;

	@RequestMapping("openbonus")
	public String openbonus(String pid, String page, Model model) {
		String result = new String();
		if (pid != null) {
			int p = Integer.parseInt(pid);
			System.out.println("pid" + pid);
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
				System.out.println("pid"+pid);
				Program pro = ProgramDAO.getProgramByPid(p, jdbcTemplate);
				System.out.println("pro"+pro.getPro_name());
				String name = pro.getPro_name();
				System.out.println(isopen);
				if (isopen == 1) {
					result = "节目" + name + "已开启打赏功能";
				} else {
					if (isopen == 0) {
						boolean isok = BonusDAO.CreateBonus(p, jdbcTemplate);
						if (isok == true) {
							result = "成功开启节目" + name + "打赏功能";
						} else {
							result = "节目" + name + "打赏功能开启失败，请重试";
						}
					} else {
						result = "节目" + name + "打赏功能开启失败，请重试";
					}
				}
			}
		}
		List<Program> list = ProgramDAO.getAll(jdbcTemplate);
		int pa;
		try {
			// 当前页数
			pa = Integer.valueOf(page);
		} catch (NumberFormatException e) {
			pa = 1;
		}
		// 用户总数
		int total = list.size();
		// 每页用户数
		int listPerPage = 10;
		// 总页数
		int totalPages = total % listPerPage == 0 ? total / listPerPage : total / listPerPage + 1;
		// 本页起始用户序号
		int beginIndex = (pa - 1) * listPerPage;
		// 本页末尾用户序号的下一个
		int endIndex = beginIndex + listPerPage;
		if (endIndex > total)
			endIndex = total;

		model.addAttribute("totalPages", totalPages);
		model.addAttribute("page", page);
		list = list.subList(beginIndex, endIndex);
		model.addAttribute("list", list);
		model.addAttribute("result", result);

		return "openbonus";
	}

	@RequestMapping("rewardresult")
	public String rewardresult(String itcode, String minvol, String maxvol, String beghour, String begmin,
			String endhour, String endmin, String page, Model model) {
		String result = new String();
		List<Trade> trades = null;
		String begtime = "2017-08-08 " + beghour + ":" + begmin + ":00";
		String endtime = "2017-08-08 " + endhour + ":" + endmin + ":00";
		int min = Integer.parseInt(minvol);
		int max = Integer.parseInt(maxvol);
		Wallet wallet=WalletDAO.getWalletByItcode(itcode, jdbcTemplate);
		System.out.println(wallet.getWid());
		System.out.println(begtime);
		System.out.println(begtime);
		System.out.println(min);
		System.out.println(max);
		if (itcode != "") {
			trades = TradeDAO.getRewardByIt_Time_Volumn(itcode, begtime, endtime, min, max, jdbcTemplate);
		} else {
			trades = TradeDAO.getRewardByTime_Volumn(begtime, endtime, min, max, jdbcTemplate);
		}
		String sign;
		if (trades != null) {
			if (trades.size() != 0) {
				result = "查询成功";
				sign = "ok";
			} else {
				trades=TradeDAO.getAllReward(jdbcTemplate);
				result = "当前条件下无记录";
				sign = "ok";
			}
		} else {
			result = "查询失败";
			sign = "no";
			trades=TradeDAO.getAllReward(jdbcTemplate);
		}
		int pa;
		try {
			// 当前页数
			pa = Integer.valueOf(page);
		} catch (NumberFormatException e) {
			pa = 1;
		}
		// 用户总数
		int total = trades.size();
		// 每页用户数
		int tradesPerPage = 10;
		// 总页数
		int totalPages = total % tradesPerPage == 0 ? total / tradesPerPage : total / tradesPerPage + 1;
		// 本页起始用户序号
		int beginIndex = (pa - 1) * tradesPerPage;
		// 本页末尾用户序号的下一个
		int endIndex = beginIndex + tradesPerPage;
		if (endIndex > total)
			endIndex = total;
		model.addAttribute("totalPages", totalPages);
		model.addAttribute("page", page);
		trades = trades.subList(beginIndex, endIndex);
		model.addAttribute("list", trades);
		model.addAttribute("result1", result);
		model.addAttribute("sign1", sign);
		return "rewardresult";
	}

	@RequestMapping("rechargeresult")
	public String rechargeresult(String itcode, String minvol, String maxvol, String beghour, String begmin,
			String endhour, String endmin, String page, Model model) {
		String result = new String();
		String sign = null;
		List<Trade> trades = null;
		if (itcode != null) {
			String begtime = "2017-08-08 " + beghour + ":" + begmin + ":00";
			String endtime = "2017-08-08 " + endhour + ":" + endmin + ":00";
			int min = Integer.parseInt(minvol);
			int max = Integer.parseInt(maxvol);
			if (itcode != "") {
				trades = TradeDAO.getRechargeByIt_Time_Volumn(itcode, begtime, endtime, min, max, jdbcTemplate);
			} else {
				trades = TradeDAO.getRechargeByTime_Volumn(begtime, endtime, min, max, jdbcTemplate);
			}
			
			if (trades != null) {
				if (trades.size() != 0) {
					result = "查询成功";
					sign = "ok";
				} else {
					result = "当前条件下无记录";
					sign = "ok";
				}
			} else {
				result = "查询失败";
				sign = "no";
			}
		} else {
			trades = TradeDAO.getAllReward(jdbcTemplate);
		}
		int pa;
		try {
			// 当前页数
			pa = Integer.valueOf(page);
		} catch (NumberFormatException e) {
			pa = 1;
		}
		// 用户总数
		int total = trades.size();
		// 每页用户数
		int tradesPerPage = 10;
		// 总页数
		int totalPages = total % tradesPerPage == 0 ? total / tradesPerPage : total / tradesPerPage + 1;
		// 本页起始用户序号
		int beginIndex = (pa - 1) * tradesPerPage;
		// 本页末尾用户序号的下一个
		int endIndex = beginIndex + tradesPerPage;
		if (endIndex > total)
			endIndex = total;
		model.addAttribute("totalPages", totalPages);
		model.addAttribute("page", page);
		trades = trades.subList(beginIndex, endIndex);
		model.addAttribute("list", trades);
		model.addAttribute("result", result);
		model.addAttribute("sign", sign);
		return "rechargeresult";
	}
}
