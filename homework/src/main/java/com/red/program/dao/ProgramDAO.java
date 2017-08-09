package com.red.program.dao;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.red.program.model.Program;


public class ProgramDAO {
	
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
	
	
	public static Program getProgramBonus(int pid, JdbcTemplate jdbcTemplate) {
		try {
			RowMapper<Program> program_mapper = new BeanPropertyRowMapper<Program>(Program.class);
			Program program = jdbcTemplate.queryForObject("select bonus from program where pid=?", program_mapper, pid);
			return program;
		} catch (Exception e) {
			return null;
		}
	}
	
	
	
}
