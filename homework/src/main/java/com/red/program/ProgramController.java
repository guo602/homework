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
	public String program_1(String page, Model model) {
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
		System.out.println("programs.size()1" + programs.size());
		model.addAttribute("totalPages", totalPages);
		model.addAttribute("size", programs.size());
		model.addAttribute("page", page);
		programs = programs.subList(beginIndex, endIndex);
		model.addAttribute("list", programs);
		return "program_insert";
	}

	/**
	 * program页面到search页面的跳转
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("program_2")
	public String program_2(String page, Model model) {
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
		model.addAttribute("size", programs.size());
		model.addAttribute("totalPages", totalPages);
		model.addAttribute("page", page);
		programs = programs.subList(beginIndex, endIndex);
		model.addAttribute("list", programs);

		return "program_search";
	}

	@RequestMapping("program_search")
	public String program_search(String program_id1, String program_name1, String department1, String page,
			Model model) {
		String result = new String();
		String sign = "some";
		System.out.println(program_name1);
		System.out.println(program_id1);
		System.out.println(department1);
		List<Program> programs = null;
		int id = 0;
		try {
			id = Integer.parseInt(program_id1);
		} catch (Exception e) {
			id = 0;
		}
		int dept = 0;
		try {
			dept = Integer.parseInt(department1);
		} catch (Exception e) {
			dept = 0;
		}

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
				programs = ProgramDAO.getAll(jdbcTemplate);
				sign = "ok";
			}
		} else {
			result = "查询失败";
			sign = "no";
			programs = ProgramDAO.getAll(jdbcTemplate);

		}
		System.out.println(result);

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
		System.out.println("programs.size()" + programs.size());
		model.addAttribute("size", programs.size());
		model.addAttribute("result", result);
		model.addAttribute("sign", sign);
		model.addAttribute("totalPages", totalPages);
		model.addAttribute("page", page);
		model.addAttribute("program_id1", program_id1);
		model.addAttribute("program_name1", program_name1);
		model.addAttribute("department1", department1);
		programs = programs.subList(beginIndex, endIndex);
		model.addAttribute("list", programs);
		return "program_search";
	}

	@RequestMapping("program_insert")
	public String program_insert(String performer, String program_name, String starttime, String department,
			String page, Model model) {
		String result = new String();
		String sign = "some";
		System.out.println(department);
		if (performer != null && program_name != null && starttime != null && department != null) {
			int dept = Integer.parseInt(department);
			if (ProgramDAO.Createprogram(program_name, performer, starttime, dept, jdbcTemplate)) {
				result = "插入成功";
				sign = "ok";
			} else {
				result = "插入失败";
				sign = "no";
			}
		}
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
		model.addAttribute("result1", result);
		model.addAttribute("sign1", sign);
		model.addAttribute("totalPages", totalPages);
		model.addAttribute("page", page);
		model.addAttribute("size", programs.size());
		programs = ProgramDAO.getProgramByPage(beginIndex, endIndex, jdbcTemplate);
		model.addAttribute("list", programs);
		return "program_insert";
	}
	
	
	@RequestMapping("program_3")
	public String addad(String page,Model model) {
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
		return "program_update";
	}
	
	
	@RequestMapping("program_edit")
	public String proedit(String update,String program_name1, String program_performer1, String program_time1, String department1,String page, Model model) {
		String result = new String();
		String sign = "some";
		System.out.println(update+program_name1+program_performer1+program_time1+department1);
		if (update!=null&&program_performer1 != null && program_name1 != null && program_time1 != null && department1 != null) {
			int dept = Integer.parseInt(department1);
			int up=Integer.parseInt(update);
			System.out.println(up);
			if (ProgramDAO.programUpdate(up,program_name1, program_performer1, program_time1, dept, jdbcTemplate)) {
				result = "修改成功";
				sign = "ok";
			} else {
				result = "修改失败";
				sign = "no";
			}
		}
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
		model.addAttribute("result", result);
		model.addAttribute("sign", sign);
		model.addAttribute("totalPages", totalPages);
		model.addAttribute("page", page);
		model.addAttribute("size", programs.size());
		programs = programs.subList(beginIndex, endIndex);
		model.addAttribute("list", programs);
		return "program_update";
	}
	
}