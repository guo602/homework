package com.red.program;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.red.program.dao.AdminCommentDAO;
import com.red.program.dao.ChatHistoryDAO;
import com.red.program.dao.ChatInfoDAO;
import com.red.program.model.ChatHistory;

/**
 * 管理员评论管理区
 * 
 * @author lenovo
 *
 */
@Controller
public class CommentController {
	@Autowired
	JdbcTemplate jdbcTemplate;

	/**
	 * 查找指定历史记录列表
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("findlist")
	public String findlist(String itcode, String keyword, String beghour, String begmin, String endhour, String endmin,
			String number,String page, Model model) {
		String result = new String();
		List<ChatHistory> chat;
		int num = Integer.parseInt(number);
		String begtime = "2017-08-08 " + beghour + ":" + begmin + ":00";
		String endtime = "2017-08-08 " + endhour + ":" + endmin + ":00";
		System.out.println("itcode" + itcode);
		System.out.println("keyword" + keyword);
		System.out.println("begtime" + begtime);
		System.out.println("endtime" + endtime);
		System.out.println("number" + number);

		if (itcode != "") {
			if (keyword != "") {
				if (num != 0) {
					System.out.println("error1");
					chat = AdminCommentDAO.getAll(itcode, keyword, begtime, endtime, num, jdbcTemplate);
				} else {
					System.out.println("error2");
					chat = AdminCommentDAO.getWithoutNumber(itcode, keyword, begtime, endtime, jdbcTemplate);
				}
			} else {
				if (num != 0) {
					System.out.println("error3");
					chat = AdminCommentDAO.getWithoutKey(itcode, begtime, endtime, num, jdbcTemplate);
				} else {
					System.out.println("error4");
					chat = AdminCommentDAO.getByIt(itcode, begtime, endtime, jdbcTemplate);
				}
			}
		} else {
			if (keyword != "") {
				if (num != 0) {
					System.out.println("error5");
					chat = AdminCommentDAO.getWithoutIt(keyword, begtime, endtime, num, jdbcTemplate);
				} else {
					System.out.println("error6");
					chat = AdminCommentDAO.getByKey(keyword, begtime, endtime, jdbcTemplate);
				}
			} else {
				if (num != 0) {
					System.out.println("error7");
					chat = AdminCommentDAO.getByNumber(begtime, endtime, num, jdbcTemplate);
				} else {
					System.out.println("error8");
					chat = AdminCommentDAO.getWithout(begtime, endtime, jdbcTemplate);
				}
			}
		}
		if (chat != null) {
			if (chat.size() != 0) {
				result = "查询成功";
			} else {
				result = "当前条件下无记录";
				chat=ChatHistoryDAO.getAll(jdbcTemplate);
			}
		} else {
			result = "查询失败";
			chat=ChatHistoryDAO.getAll(jdbcTemplate);
		}
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

		model.addAttribute("result", result);
		model.addAttribute("list", chat);
		return "commentbyadmin";
	}

	/**
	 * 禁言指定用户
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("lock_delete")
	public String lockuser(String lock[], String delete[],String page, Model model) {
		int lnum = 0;
		int dnum = 0;
		String result = new String();
		if (lock != null) {
			lnum = lock.length;
		}
		if (delete != null) {
			dnum = delete.length;
		}
		//System.out.println("delete" + delete[0] + dnum + lnum);
		String jlock = "";
		String jdelete = "";
		if (lnum == 0 && dnum == 0) {
			result = "未选择需要禁言的用户或需要删除的历史记录";
		} else {
			int k = 0;
			if (lnum != 0) {
				for (int i = 0; i < lnum; i++) {
					System.out.println("delete1");
					k = ChatInfoDAO.lockUserById(Integer.parseInt(lock[i]), jdbcTemplate);
					System.out.println("delete2");
					if (k == -1) {
						jlock = lock[i] + "号,";
					}
				}
			}
			if (dnum != 0) {
				for (int i = 0; i < dnum; i++) {
					System.out.println("delete3");
					k = AdminCommentDAO.AdminDelete(Integer.parseInt(delete[i]), jdbcTemplate);
					System.out.println("delete4");
					if (k == -1) {
						jdelete = delete[i] + "号,";
					}
				}
			}
		}
		if (jlock == "" && jdelete == "") {
			result = "成功删除历史记录或禁言用户";
			model.addAttribute("result1", result);
		} else {
			model.addAttribute("result1", jlock + "禁言失败；" + jdelete + "删除失败");
		}
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
}
