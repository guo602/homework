package com.red.program.dao;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.codec.binary.Base64;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.red.program.model.Admin_user;
import com.red.program.model.All_user;

public class AdminUserDAO {
	/**
	 * 密码加密
	 * @param str
	 * @return
	 * @throws NoSuchAlgorithmException
	 * @throws UnsupportedEncodingException
	 */
	public static String EncoderByMd5(String str) throws NoSuchAlgorithmException, UnsupportedEncodingException{
        //确定计算方法
        MessageDigest md5=MessageDigest.getInstance("MD5");
        Base64 base64en = new Base64();
        //加密后的字符串
        byte[] newstr=base64en.encode(md5.digest(str.getBytes("utf-8")));
        String pass = new String(newstr);
        return pass;
    }
	/**
	 * 创建admin用户
	 * @param itcode	用户工号
	 * @param username	用户名
	 * @param jdbcTemplate
	 * @return	插入成功返回1， 插入失败返回0，其他问题返回-1
	 */
	public static int createAdminUser(String itcode, String username, String password,JdbcTemplate jdbcTemplate) {
		try {
			String pass=EncoderByMd5(password);
			System.out.println(pass);
			int result = jdbcTemplate.update("insert into  admin_user values(null,?,?,?)",new Object[] { itcode, username,pass });
			return result;
		} catch (Exception e) {
			return -1;
		}
	}

	/**
	 * 通过管理员删除用户
	 * @param itcode	聊天记录编号id
	 * @param jdbcTemplate
	 * @return	成功返回1，失败返回0或-1
	 */
	public static int AdminDelete(String itcode, JdbcTemplate jdbcTemplate) {
		try {
			RowMapper<All_user> user_mapper = new BeanPropertyRowMapper<All_user>(All_user.class);
			All_user user = jdbcTemplate.queryForObject("select * from all_user where itcode=?",
					user_mapper, itcode);
			int i=jdbcTemplate.update("delete from all_user where uid=? ",user.getUid());
			if (i > 0) {
				return 1;
			} else {
				return 0;
			}
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
	 * 管理员登录检查是否是管理员
	 * @param itcode
	 * @param password
	 * @param jdbcTemplate
	 * @return
	 */
	public static boolean checkIsAdmin(String itcode, String password, JdbcTemplate jdbcTemplate) {
		RowMapper<Admin_user> admin_mapper = new BeanPropertyRowMapper<Admin_user>(Admin_user.class);
		try {
			String pass=EncoderByMd5(password);
			@SuppressWarnings("unused")
			Admin_user admin = jdbcTemplate.queryForObject("select * from admin_user where itcode=? and password=?",
					admin_mapper, new Object[] { itcode, pass });
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
