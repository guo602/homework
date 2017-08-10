package com.red.program;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.red.program.dao.BonusDAO;
import com.red.program.dao.ProgramDAO;
import com.red.program.model.LuckyRecord;
import com.red.program.model.Program;

@Controller
public class RewardController {
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@RequestMapping("reward")
	public String goreward(Model model) {
		List<Program> luckylist=ProgramDAO.getAll(jdbcTemplate);
		model.addAttribute("list", luckylist);
		return "openbonus";
	}
	
	@RequestMapping("openbonus")
	public String openbonus(String pid, Model model) {
		int p = Integer.parseInt(pid);
		int isopen=BonusDAO.Isopen(p, jdbcTemplate);
		String result=new String();
		if(isopen==1) {
			result="had";
		}
		else {
			if(isopen==0) {
			    boolean isok=BonusDAO.CreateBonus(p, jdbcTemplate);
			    if(isok==true) {
			    	result="ok";
			    }
			    else {
			    	result="inserterror";
			    }
			}
			else {
				result="finderror";
			}
		}
		model.addAttribute("result", result);
		return "openbonus";
	}
}
