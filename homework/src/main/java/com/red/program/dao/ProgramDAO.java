package com.red.program.dao;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.ui.Model;

import com.red.program.model.All_user;
import com.red.program.model.Program;
import com.red.program.model.Wallet;


public class ProgramDAO {
	/**
	 * 获取指定页数的数据
	 * @param page  页数
	 * @param pernum  指定条数
	 * @param jdbcTemplate
	 * @return
	 */
	public static List<Program> getProgramByPage(int begindex, int endindex,JdbcTemplate jdbcTemplate) {
		try {
			RowMapper<Program> program_mapper = new BeanPropertyRowMapper<Program>(Program.class);
			List<Program> program = jdbcTemplate.query("select * from program limit ?, ?", program_mapper, new Object[] {begindex,endindex});
			return program;
		} catch (Exception e) {
			return null;
		}
	}
	
	/**
	 * 通过节目编号pid查找节目对象
	 * @param pid	节目编号pid
	 * @param jdbcTemplate
	 * @return	成功返回program对象，失败返回null
	 */
	public static Program getProgramByPid(int pid, JdbcTemplate jdbcTemplate) {
		try {
			RowMapper<Program> program_mapper = new BeanPropertyRowMapper<Program>(Program.class);
			Program program = jdbcTemplate.queryForObject("select * from program where pid=?", program_mapper, pid);
			return program;
		} catch (Exception e) {
			return null;
		}
	}
	
	/**
	 * 通过节目名称pro_name查找节目对象，不存在重名节目
	 * @param pro_name
	 * @param jdbcTemplate
	 * @return	成功返回program对象，失败返回null
	 */
	public static Program getProgramByName(String pro_name, JdbcTemplate jdbcTemplate) {
		try {
			RowMapper<Program> program_mapper = new BeanPropertyRowMapper<Program>(Program.class);
			Program program = jdbcTemplate.queryForObject("select * from program where pro_name=?", program_mapper, pro_name);
			return program;
		} catch (Exception e) {
			return null;
		}
	}
	
	/**
	 * 通过表演者proformer查找节目对象（目前由于数据库未能完成不变浓烟你这姓名的精确分割，先认为每个节目按照所有表演者查询，只能得到单一结果）
	 * @param proformer	节目表演者名称
	 * @param jdbcTemplate
	 * @return	成功返回program对象，失败返回null
	 */
	public static Program getProgramByPerfomer(String performer, JdbcTemplate jdbcTemplate) {
		try {
			RowMapper<Program> program_mapper = new BeanPropertyRowMapper<Program>(Program.class);
			Program program = jdbcTemplate.queryForObject("select * from program where performer=?", program_mapper, performer);
			return program;
		} catch (Exception e) {
			return null;
		}
	}
	
	/**
	 * 通过节目开始时间start_time查找节目对象（目前是输入精确时间来查询）
	 * @param start_time	节目开始时间，格式是2017-01-01 23:22:33
	 * @param jdbcTemplate
	 * @return	成功返回program对象，失败返回null
	 */
	public static Program getProgramByTime(String start_time, JdbcTemplate jdbcTemplate) {
		try {
			RowMapper<Program> program_mapper = new BeanPropertyRowMapper<Program>(Program.class);
			Program program = jdbcTemplate.queryForObject("select * from program where start_time=?", program_mapper, start_time);
			return program;
		} catch (Exception e) {
			return null;
		}
	}
	
	/**
	 * 通过节目选送部门的编号dep_id查找节目对象（一个部门可能有多个节目）
	 * @param dept_id	节目选送部门编号
	 * @param jdbcTemplate
	 * @return	成功返回program对象，失败返回null
	 */
	public static List<Program> getProgramByWid(int dept_id, JdbcTemplate jdbcTemplate) {
		try {
			RowMapper<Program> program_mapper = new BeanPropertyRowMapper<Program>(Program.class);
			List<Program> program = jdbcTemplate.query("select * from program where dept_id=?", program_mapper, dept_id);
			return program;
		} catch (Exception e) {
			return null;
		}
	}
	
	/**
	 * 插入节目单
	 * @param name
	 * @param performer
	 * @param time
	 * @param dept
	 * @param jdbcTemplate
	 * @return
	 */
	public static boolean Createprogram(String name,String performer,String time,int dept,JdbcTemplate jdbcTemplate) {
		try {
			int i = jdbcTemplate.update("insert into program values(null,?,?,?,?);",
					new Object[] { name, performer, time,dept });
			if (i > 0) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			return false;
		}

	}
	
	/**
	 * 获取所有的节目列表
	 * @param jdbcTemplate
	 * @return
	 */
	public static  List<Program> getAll(JdbcTemplate jdbcTemplate){
		try {
			RowMapper<Program> pro_mapper = new BeanPropertyRowMapper<Program>(Program.class);
			List<Program> program = jdbcTemplate.query("select * from program ", pro_mapper);
			return program;
		} catch (Exception e) {
			return null;
		}
	}
	
	/**
	 * 
	 * @param program_id
	 * @param program_name
	 * @param department
	 * @param jdbcTemplate
	 * @return
	 */
	public static List<Program> getAllPrograms(int program_id, String program_name,int department, JdbcTemplate jdbcTemplate) {
		try {
			Program pro=ProgramDAO.getProgramByPid(program_id, jdbcTemplate);
			RowMapper<Program> programs_mapper = new BeanPropertyRowMapper<Program>(Program.class);
			List<Program> programs = jdbcTemplate.query("select * from program where pid=? and pro_name=? and dept_id=?",
					programs_mapper,new Object[] {program_id,program_name,department});
		    return programs;
		} catch (Exception e) {
			return null;
		}
	}
	
	public static List<Program> getWithoutDepartment(int program_id, String program_name, JdbcTemplate jdbcTemplate) {
		try {
			Program pro=ProgramDAO.getProgramByPid(program_id, jdbcTemplate);
			RowMapper<Program> programs_mapper = new BeanPropertyRowMapper<Program>(Program.class);
			List<Program> programs = jdbcTemplate.query("select * from program where pid=? and pro_name=?",
					programs_mapper,new Object[] {program_id,program_name});
		    return programs;
		} catch (Exception e) {
			return null;
		}
	}
	
	public static List<Program> getWithoutName(int program_id, int department, JdbcTemplate jdbcTemplate) {
		try {
			Program pro=ProgramDAO.getProgramByPid(program_id, jdbcTemplate);
			RowMapper<Program> programs_mapper = new BeanPropertyRowMapper<Program>(Program.class);
			List<Program> programs = jdbcTemplate.query("select * from program where pid=? and dept_id=?",
					programs_mapper,new Object[] {program_id,department});
		    return programs;
		} catch (Exception e) {
			return null;
		}
	}
	
	public static List<Program> getWithoutId( String program_name,int department, JdbcTemplate jdbcTemplate) {
		try {
			Program pro=ProgramDAO.getProgramByName(program_name, jdbcTemplate);
			RowMapper<Program> programs_mapper = new BeanPropertyRowMapper<Program>(Program.class);
			List<Program> programs = jdbcTemplate.query("select * from program where pro_name=? and dept_id=?",
					programs_mapper,new Object[] {program_name,department});
		    return programs;
		} catch (Exception e) {
			return null;
		}
	}
	
	public static List<Program> getByPidOnly(int program_id,JdbcTemplate jdbcTemplate) {
		try {
			Program pro=ProgramDAO.getProgramByPid(program_id, jdbcTemplate);
			RowMapper<Program> programs_mapper = new BeanPropertyRowMapper<Program>(Program.class);
			List<Program> programs = jdbcTemplate.query("select * from program where pid=?",
					programs_mapper,new Object[] {program_id});
		    return programs;
		} catch (Exception e) {
			return null;
		}
	}
	
	public static List<Program> getByNameOnly(String program_name,JdbcTemplate jdbcTemplate) {
		try {
			Program pro=ProgramDAO.getProgramByName(program_name, jdbcTemplate);
			RowMapper<Program> programs_mapper = new BeanPropertyRowMapper<Program>(Program.class);
			List<Program> programs = jdbcTemplate.query("select * from program where pro_name=?",
					programs_mapper,new Object[] {program_name});
		    return programs;
		} catch (Exception e) {
			return null;
		}
	}
	
	public static List<Program> getByDepartmentOnly(int department, JdbcTemplate jdbcTemplate) {
		try {
			//Program pro=ProgramDAO.getProgramByWid(department, jdbcTemplate);
			RowMapper<Program> programs_mapper = new BeanPropertyRowMapper<Program>(Program.class);
			List<Program> programs = jdbcTemplate.query("select * from program where dept_id=?",
					programs_mapper,new Object[] {department});
		    return programs;
		} catch (Exception e) {
			return null;
		}
	}
	
}
