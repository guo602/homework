package com.red.program;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.red.program.dao.AdminCommentDAO;
import com.red.program.dao.ChatHistoryDAO;
import com.red.program.dao.LuckyRecordDAO;
import com.red.program.dao.ProgramDAO;
import com.red.program.dao.TradeDAO;
import com.red.program.model.ChatHistory;
import com.red.program.model.LuckyRecord;
import com.red.program.model.Program;
import com.red.program.model.Trade;

import luckyThread.LuckyRainThread;

@Controller
public class AdminController {
	@Autowired
	JdbcTemplate jdbcTemplate;

	/**
	 * home界面跳转到管理员界面
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("admin")
	public String home(Model model) {
		return "admin";
	}

	/**
	 * 跳转到激活用户账户界面
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("program")
	public String goprogram(String page, Model model) {
		List<Program> programs = ProgramDAO.getAll(jdbcTemplate);
		int pa;
		try {
			// 当前页数
			pa = Integer.valueOf(page);
		} catch (NumberFormatException e) {
			pa = 1;
		}
		// 用户总数
		int total = programs.size();
		// 每页用户数
		int programPerPage = 10;
		// 总页数
		int totalPages = total % programPerPage == 0 ? total / programPerPage : total / programPerPage + 1;
		// 本页起始用户序号
		int beginIndex = (pa - 1) * programPerPage;
		// 本页末尾用户序号的下一个
		int endIndex = beginIndex + programPerPage;
		if (endIndex > total)
			endIndex = total;

		model.addAttribute("totalPages", totalPages);

		model.addAttribute("page", page);
		programs = programs.subList(beginIndex, endIndex);
		model.addAttribute("list", programs);
		return "program";
	}

	/**
	 * 跳转到添加管理员界面
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("addadmin")
	public String goaddadmin(Model model) {
		return "adminmodify";
	}

	/**
	 * 跳转到激活用户账户界面
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("wallet")
	public String gowallet(Model model) {
		return "walletbyadmin";
	}

	/**
	 * 跳转到评论管理界面
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("comment")
	public String gocomment(String page,Model model) {
		List<ChatHistory> chat = ChatHistoryDAO.getAll(jdbcTemplate);
		int pa;
		try {
			// 当前页数
			pa = Integer.valueOf(page);
		} catch (NumberFormatException e) {
			pa = 1;
		}
		// 用户总数
		int total = chat.size();
		// 每页用户数
		int chatPerPage = 10;
		// 总页数
		int totalPages = total % chatPerPage == 0 ? total / chatPerPage : total / chatPerPage + 1;
		// 本页起始用户序号
		int beginIndex = (pa - 1) * chatPerPage;
		// 本页末尾用户序号的下一个
		int endIndex = beginIndex + chatPerPage;
		if (endIndex > total)
			endIndex = total;

		model.addAttribute("totalPages", totalPages);

		model.addAttribute("page", page);
		chat = chat.subList(beginIndex, endIndex);

		model.addAttribute("list", chat);
		return "commentbyadmin";
	}

	/**
	 * 管理员确认密码,很想保留确认密码功能，跳转到开启红包雨界面
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("luckyrain")
	public String luckyrain(Model model) {
		return "luckyrain";
	}

	/**
	 * 跳转到打赏开启界面
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("reward")
	public String goreward(String page,Model model) {
		List<Program> programlist = ProgramDAO.getAll(jdbcTemplate);
		int pa;
		try {
			// 当前页数
			pa = Integer.valueOf(page);
		} catch (NumberFormatException e) {
			pa = 1;
		}
		// 用户总数
		int total = programlist.size();
		// 每页用户数
		int PerPage = 10;
		// 总页数
		int totalPages = total % PerPage == 0 ? total / PerPage : total / PerPage + 1;
		// 本页起始用户序号
		int beginIndex = (pa - 1) * PerPage;
		// 本页末尾用户序号的下一个
		int endIndex = beginIndex + PerPage;
		if (endIndex > total)
			endIndex = total;

		model.addAttribute("totalPages", totalPages);

		model.addAttribute("page", page);
		programlist = programlist.subList(beginIndex, endIndex);
		model.addAttribute("list", programlist);
		return "openbonus";
	}

	/**
	 * 跳转到红包记录界面
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("luckyrecord")
	public String luckyrecord(String page, Model model) {
		List<LuckyRecord> luckylist = LuckyRecordDAO.getAll(jdbcTemplate);
		int pa;
		try {
			pa = Integer.valueOf(page);
		} catch (NumberFormatException e) {
			pa = 1;
		}
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
		luckylist = luckylist.subList(beginIndex, endIndex);
		model.addAttribute("list", luckylist);
		return "luckyresult";
	}

	/**
	 * 跳转到打赏记录界面
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("rewardrecord")
	public String gorewardresult(Model model) {
		return "rewardresult";
	}

	/**
	 * 跳转到充值记录界面
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("rechargerecord")
	public String gorechargeresult(Model model) {
		return "rechargeresult";
	}

	/**
	 * 跳转到充值/打赏记录界面
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("traderecord")
	public String gotrade(String page, Model model) {
		List<Trade> trades = TradeDAO.getAll(jdbcTemplate);
		int pa;
		try {
			pa = Integer.valueOf(page);
		} catch (NumberFormatException e) {
			pa = 1;
		}
		int total = trades.size();
		// 每页用户数
		int tradePerPage = 10;
		// 总页数
		int totalPages = total % tradePerPage == 0 ? total / tradePerPage : total / tradePerPage + 1;
		// 本页起始用户序号
		int beginIndex = (pa - 1) * tradePerPage;
		// 本页末尾用户序号的下一个
		int endIndex = beginIndex + tradePerPage;
		if (endIndex > total)
			endIndex = total;

		model.addAttribute("totalPages", totalPages);

		model.addAttribute("page", page);
		trades = trades.subList(beginIndex, endIndex);
		model.addAttribute("list", trades);
		return "traderecord";
	}

}
