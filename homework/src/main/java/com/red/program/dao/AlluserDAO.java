package com.red.program.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.red.program.model.All_user;



public class AlluserDAO {
	/**
	 * 创建用户
	 * 
	 * @param itcode
	 *            用户工号
	 * @param username
	 *            用户名
	 * @param jdbcTemplate
	 * @return result==1,插入成功 result==0,插入失败 result==-1,其他问题
	 */
	public static int createUser(String itcode, String username, JdbcTemplate jdbcTemplate) {
		try {
			int result = jdbcTemplate.update("insert into all_user values(null,?,?);",
					new Object[] { itcode, username });
			return result;
		} catch (Exception e) {
			return -1;
		}
	}

	/**
	 * 检查用户名和工号是否匹配，且存在于数据库中
	 * 
	 * @param itcode
	 *            工号
	 * @param username
	 *            用户名
	 * @return 如果查询结果可以，证明有结果，返回true 如果不能转换，证明没有查询结果，返回false
	 */
	public static boolean checkUserInfo(String itcode, String username, JdbcTemplate jdbcTemplate) {
		RowMapper<All_user> user_mapper = new BeanPropertyRowMapper<All_user>(All_user.class);
		try {
			@SuppressWarnings("unused")
			All_user user = jdbcTemplate.queryForObject("select * from all_user where itcode=? and username=?",
					user_mapper, new Object[] { itcode, username });
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	/**
	 * 通过用户id查找
	 * 
	 * @param uid
	 * @param jdbcTemplate
	 * @return 返回当前id用户的all_user，如果失败返回null
	 */
	public static All_user getUserByUid(int uid, JdbcTemplate jdbcTemplate) {
		try {
			RowMapper<All_user> user_mapper = new BeanPropertyRowMapper<All_user>(All_user.class);
			All_user user = jdbcTemplate.queryForObject("select * from all_user where uid=?", user_mapper, uid);
			return user;
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * 通过用户工号查找
	 * 
	 * @param itcode
	 * @param jdbcTemplate
	 * @return 返回当前工号用户的all_user
	 */
	public static All_user getUserByItcode(String itcode, JdbcTemplate jdbcTemplate) {
		try {
			RowMapper<All_user> user_mapper = new BeanPropertyRowMapper<All_user>(All_user.class);
			All_user user = jdbcTemplate.queryForObject("select * from all_user where itcode=?", user_mapper, itcode);
			return getUserByUid(user.getUid(), jdbcTemplate);
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * 显示所有用户
	 * 
	 * @param jdbcTemplate
	 * @return 返回all_user的列表
	 */
	public static List<All_user> getAllUsers(JdbcTemplate jdbcTemplate) {
		try {

			RowMapper<All_user> user_mapper = new BeanPropertyRowMapper<All_user>(All_user.class);
			List<All_user> users = new ArrayList<All_user>();
			users = jdbcTemplate.query("select * from all_user", user_mapper);
			return users;
		} catch (Exception e) {
			return null;
		}
	}
//
//	/**
//	 * 通过用户id对用户上锁，实施禁言
//	 * 
//	 * @param uid  用户id
//	 * @param jdbcTemplate
//	 * @return result==1,上锁成功 result==0,上锁失败  result==-1,其他问题
//	 */
//	public static int lockUserById(int uid, JdbcTemplate jdbcTemplate) {
//		try {
//
//			int result = jdbcTemplate.update("update all_user set islock=1 where uid=?", uid);
//			return result;
//		} catch (Exception e) {
//			return -1;
//		}
//	}
//
//	/**
//	 * 通过用户工号对用户上锁，实施禁言
//	 * @param itcode  用户工号
//	 * @param jdbcTemplate
//	 * @return result==1,上锁成功 result==0,上锁失败  result==-1,其他问题
//	 */
//	public static int lockUserByItcode(String itcode, JdbcTemplate jdbcTemplate) {
//		try {
//			int result = jdbcTemplate.update("update all_user set islock=1 where itcode=?", itcode);
//			return result;
//		} catch (Exception e) {
//			return -1;
//		}
//	}
//	/**
//	 * 通过用户id解锁用户禁言
//	 * @param uid  用户id
//	 * @param jdbcTemplate
//	 * @return result==1,解锁成功  result==0,解锁失败 result==-1,其他问题
//	 */
//	public static int unlockUserByID(int uid, JdbcTemplate jdbcTemplate) {
//		try {
//			int result = jdbcTemplate.update("update all_user set islock=0 where uid=?", uid);
//			return result;
//		} catch (Exception e) {
//			return -1;
//		}
//	}
//	/**
//	 * 通过用户工号解锁用户禁言
//	 * @param itcode  用户工号
//	 * @param jdbcTemplate
//	 * @return
//	 */
//	public static int unlockUserByItcode(int itcode, JdbcTemplate jdbcTemplate) {
//		try {
//			int result = jdbcTemplate.update("update all_user set islock=0 where itcode=?", itcode);
//			return result;
//		} catch (Exception e) {
//			return -1;
//		}
//	}
//	/**
//	 * 通过id判断当前用户是否禁言
//	 * @param uid  用户id
//	 * @param jdbcTemplate
//	 * @return true  禁言   false  允许发言
//	 */
//	public static boolean isLock(int uid, JdbcTemplate jdbcTemplate) {
//		try {
//			int result = jdbcTemplate.update("select islock from all_user where uid=? ", uid);
//			if(result==1){
//			    return true;
//			}
//			else {
//				return false;
//			}
//		} catch (Exception e) {
//			return false;
//		}
//	}

}
