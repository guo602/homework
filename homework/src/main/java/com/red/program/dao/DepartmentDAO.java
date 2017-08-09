package com.red.program.dao;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.red.program.model.Department;

public class DepartmentDAO {
	
	/**
	 * 通过部门编号did查找部门对象
	 * @param did	部门编号
	 * @param jdbcTemplate
	 * @return	成功返回department对象，失败返回null
	 */
	public static Department getDepartmentByDid(int did, JdbcTemplate jdbcTemplate) {
		try {
			RowMapper<Department> department_mapper = new BeanPropertyRowMapper<Department>(Department.class);
			Department department = jdbcTemplate.queryForObject("select * from department where did=?", department_mapper, did);
			return department;
		} catch (Exception e) {
			return null;
		}
	}
	
	/**
	 * 通过部门名称deptname查找部门对象
	 * @param deptname	部门名称
	 * @param jdbcTemplate
	 * @return	成功返回department对象，失败返回null
	 */
	public static Department getDepartmentByName(int deptname, JdbcTemplate jdbcTemplate) {
		try {
			RowMapper<Department> department_mapper = new BeanPropertyRowMapper<Department>(Department.class);
			Department department = jdbcTemplate.queryForObject("select * from department where deptname=?", department_mapper, deptname);
			return department;
		} catch (Exception e) {
			return null;
		}
	}
	
	/**
	 * 通过部门编号did查找打赏金额
	 * @param did	部门编号
	 * @param jdbcTemplate
	 * @return	成功返回department对象，失败返回null
	 */
	public static Department getBonusByDid(int did, JdbcTemplate jdbcTemplate) {
		try {
			RowMapper<Department> department_mapper = new BeanPropertyRowMapper<Department>(Department.class);
			Department department = jdbcTemplate.queryForObject("select * from department where did=?", department_mapper, did);
			return department;
		} catch (Exception e) {
			return null;
		}
	}
	
	/**
	 * 通过部门名称deptname查找打赏金额
	 * @param deptname	部门名称
	 * @param jdbcTemplate
	 * @return	成功返回department对象，失败返回null
	 */
	public static Department getBonusByName(int deptname, JdbcTemplate jdbcTemplate) {
		try {
			RowMapper<Department> department_mapper = new BeanPropertyRowMapper<Department>(Department.class);
			Department department = jdbcTemplate.queryForObject("select * from department where deptname=?", department_mapper, deptname);
			return department;
		} catch (Exception e) {
			return null;
		}
	}
	
	
}
