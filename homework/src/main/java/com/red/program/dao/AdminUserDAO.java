package com.red.program.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.red.program.model.Admin_user;

public class AdminUserDAO {
	
	/**
	 * 创建admin用户
	 * @param itcode	用户工号
	 * @param username	用户名
	 * @param jdbcTemplate
	 * @return	插入成功返回1， 插入失败返回0，其他问题返回-1
	 */
	public static int createAdminUser(String itcode, String username, JdbcTemplate jdbcTemplate) {
		try {
			int result = jdbcTemplate.update("insert into admin_user values(null,?,?)",new Object[] { itcode, username });
			return result;
		} catch (Exception e) {
			return -1;
		}
	}

	/**
	 * 检查用户名和工号是否匹配，且存在于数据库中
	 * @param itcode 工号
	 * @param username 用户名
	 * @return 如果查询结果可以，证明有结果，返回true. 如果不能转换，证明没有查询结果，返回false
	 */
	public static boolean checkAdminUserInfo(String itcode, String username, JdbcTemplate jdbcTemplate) {
		RowMapper<Admin_user> admin_mapper = new BeanPropertyRowMapper<Admin_user>(Admin_user.class);
		try {
			@SuppressWarnings("unused")
			Admin_user admin = jdbcTemplate.queryForObject("select * from admin_user where itcode=? and username=?",
					admin_mapper, new Object[] { itcode, username });
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	/**
	 * 通过管理员id查找管理员账户
	 * @param aid	管理员id
	 * @param jdbcTemplate
	 * @return 成功返回返回当前管理员账户，失败返回null
	 */
	public static Admin_user getAdminByAid(int aid, JdbcTemplate jdbcTemplate) {
		try {
			RowMapper<Admin_user> admin_mapper = new BeanPropertyRowMapper<Admin_user>(Admin_user.class);
			Admin_user admin = jdbcTemplate.queryForObject("select * from admin_user where aid=?", admin_mapper, aid);
			return admin;
		} catch (Exception e) {
			return null;
		}
	}
	
	/**
	 * 通过管理员工号itcode查找管理员账户
	 * @param itcode	管理员工号
	 * @param jdbcTemplate
	 * @return 成功返回返回当前管理员账户，失败返回null
	 */
	public static Admin_user getAdminByItcode(String itcode, JdbcTemplate jdbcTemplate) {
		try {
			RowMapper<Admin_user> admin_mapper = new BeanPropertyRowMapper<Admin_user>(Admin_user.class);
			Admin_user admin = jdbcTemplate.queryForObject("select * from admin_user where itcode=?", admin_mapper, itcode);
			return admin;
		} catch (Exception e) {
			return null;
		}
	}
	
	/**
	 * 显示所有管理员
	 * @param jdbcTemplate
	 * @return 返回Admin_user的列表
	 */
	public static List<Admin_user> getAllAdmins(JdbcTemplate jdbcTemplate) {
		try {
			RowMapper<Admin_user> admin_mapper = new BeanPropertyRowMapper<Admin_user>(Admin_user.class);
			List<Admin_user> admin = new ArrayList<Admin_user>();
			admin = jdbcTemplate.query("select * from admin_user", admin_mapper);
			return admin;
		} catch (Exception e) {
			return null;
		}
	}
	
}
