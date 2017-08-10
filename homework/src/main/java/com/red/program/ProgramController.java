//package com.red.program;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import com.red.program.dao.LuckyRecordDAO;
//import com.red.program.dao.ProgramDAO;
//import com.red.program.model.LuckyRecord;
//
//@Controller
//public class ProgramController {//节目单管理
//	@Autowired
//	JdbcTemplate jdbcTemplate;
//	
//	/**
//	 * 
//	 * @param model
//	 * @return
//	 */
//	@RequestMapping("program_insert")
//	public String program_insert(Model model) {
//		return "program_insert";
//	}
//	
//	@RequestMapping("program_search")
//	public String program_search(Model model) {
//		return "program_search";
//	}
//	
//	
//	@RequestMapping("program_searchresult")
//	public String program_searchresult(String num, Model model) {
//		System.out.println("roundList" + num);
//		int r = Integer.parseInt(num);
//		List<LuckyRecord> programlist;
//		if (r == 0) {
//			int pid=r;
//			programlist = ProgramDAO.getProgramByPid(jdbcTemplate);
//		} else {
//			programlist = ProgramDAO.getAllByRound(r, jdbcTemplate);
//		}
//		model.addAttribute("list", programlist);
//		return "luckyresult";
//	}
//}