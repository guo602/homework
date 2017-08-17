package com.red.program;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.red.program.dao.ProgramDAO;
import com.red.program.dao.TradeDAO;
import com.red.program.model.Program;
import com.red.program.model.Trade;

@Controller
public class ProgramController {// 节目单管理
	@Autowired
	JdbcTemplate jdbcTemplate;

	/**
	 * program页面到insert页面的跳转
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("program_1")
	public String program_1(Model model) {
		List<Program> programs=ProgramDAO.getAll(jdbcTemplate);
		model.addAttribute("list", programs);
		return "program";
	}

	/**
	 * program页面到search页面的跳转
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("program_2")
	public String program_2(Model model) {
		List<Program> programs=ProgramDAO.getAll(jdbcTemplate);
		model.addAttribute("list", programs);
		return "program";
	}

	@RequestMapping("program_search")
	public String program_search(String program_id1, String program_name1, String department1, Model model) {
		String result = new String();
		String sign="some";
		System.out.println(program_name1);
		System.out.println(program_id1);
		System.out.println(department1);
		List<Program> programs = null;
		int id=0;
		if(program_id1!="") {
		    id = Integer.parseInt(program_id1);
		}
		else {
			id=0;
		}
		int dept = Integer.parseInt(department1);
		if (id != 0) {
			if (program_name1 != "") {
				if (dept != 0) {
					System.out.println("error1");
					programs = ProgramDAO.getAllPrograms(id, program_name1, dept, jdbcTemplate);
				} else {// department is empty
					System.out.println("error2");
					programs = ProgramDAO.getWithoutDepartment(id, program_name1, jdbcTemplate);
				}
			} else {// program_name is empty
				if (dept != 0) {
					System.out.println("error3");
					programs = ProgramDAO.getWithoutName(id, dept, jdbcTemplate);
				} else {// department is empty
					System.out.println("error4");
					programs = ProgramDAO.getByPidOnly(id, jdbcTemplate);
					System.out.println("error4.1");

				}
			}
		} else {// program_id is empty
			if (program_name1 != "") {
				if (dept != 0) {
					System.out.println("error5");
					programs = ProgramDAO.getWithoutId(program_name1, dept, jdbcTemplate);
				} else {// department is empty
					System.out.println("error6");
					programs = ProgramDAO.getByNameOnly(program_name1, jdbcTemplate);
				}
			} else {// program_name is empty
				if (dept != 0) {
					System.out.println("error7");
					programs = ProgramDAO.getByDepartmentOnly(dept, jdbcTemplate);
				} else {// department is empty
					System.out.println("error8");
					// programs = ProgramDAO.getAllProgramsBy(program_id, program_name, department,
					// jdbcTemplate);
				}
			}
		}

		if (programs != null) {
			if (programs.size() != 0) {
				result = "查询成功";
				sign = "ok";
			} else {
				result = "当前条件下无记录";
				programs=ProgramDAO.getAll(jdbcTemplate);
				sign = "ok";
			}
		} else {
			result = "查询失败";
			sign = "no";
			programs=ProgramDAO.getAll(jdbcTemplate);
			
		}
		System.out.println(result);
		model.addAttribute("list", programs);
		model.addAttribute("result", result);
		
		model.addAttribute("sign", sign);
		return "program";
	}

	@RequestMapping("program_insert")
	public String program_insert(String performer, String program_name, String starttime, String department,
			Model model) {
		String result = new String();
		String sign = "some";
		int dept = Integer.parseInt(department);
		System.out.println(program_name);
		System.out.println(performer);
		System.out.println(starttime);
		System.out.println(dept);
		if (ProgramDAO.Createprogram(program_name, performer, starttime, dept, jdbcTemplate)) {
			result = "插入成功";
			sign = "ok";
		} else {
			result = "插入失败";
			sign = "no";
		}

		System.out.println(result);

		model.addAttribute("result", result);
		model.addAttribute("sign1", sign);
		List<Program> programs=ProgramDAO.getAll(jdbcTemplate);
		model.addAttribute("list", programs);
		return "program";
	}
}