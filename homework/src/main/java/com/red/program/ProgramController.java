package com.red.program;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


import com.red.program.dao.ProgramDAO;
import com.red.program.model.Program;

@Controller
public class ProgramController {//节目单管理
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	/**
	 * program页面到insert页面的跳转
	 * @param model
	 * @return
	 */
	@RequestMapping("program_1")
	public String program_1(Model model) {
		return "program_insert";
	}
	
	/**
	 * program页面到search页面的跳转
	 * @param model
	 * @return
	 */
	@RequestMapping("program_2")
	public String program_2(Model model) {
		return "program_search";
	}
	
	
	@RequestMapping("program_insert")
	public String program_insert(Model model) {
		
		return "program_insert";
	}
	
	
//	@RequestMapping("program_search")
//	public String program_searchresult(String num, Model model) {
//		int r = Integer.parseInt(num);
//		if (r == 1) {
//			Program programlist;
//			programlist = ProgramDAO.getProgramByPid(r, jdbcTemplate);
//		} 
//		if (r == 2) {
//			Program programlist;
//			programlist = ProgramDAO.getProgramByName(r, jdbcTemplate);
//		}
//		if (r == 3) {
//			Program programlist;
//			programlist = ProgramDAO.getProgramByPerfomer(r, jdbcTemplate);
//		}
//		if (r == 4) {
//			Program programlist;
//			programlist = ProgramDAO.getProgramByTime(r, jdbcTemplate);
//		}
//		if (r == 5) {
//			List<Program> programlist;
//			programlist = ProgramDAO.getProgramByWid(r, jdbcTemplate);
//		}
//		model.addAttribute("list", programlist);
//		return "program_search";
//	}
}