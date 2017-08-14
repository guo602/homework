package com.red.program.dao;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.red.program.model.All_user;
import com.red.program.model.ChatHistory;
import com.red.program.model.Wallet;

public class AdminCommentDAO {
	/**
	 * 通过聊天记录编号hid删除言论（前端时只有管理员显示hid）
	 * @param hid	聊天记录编号id
	 * @param jdbcTemplate
	 * @return	成功返回1，失败返回0或-1
	 */
	public static int AdminDelete(int hid, JdbcTemplate jdbcTemplate) {
		try {
			int i = jdbcTemplate.update("delete from chat_history where hid=?",hid);
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
	 * 查找对应条件的聊天记录，指定用户工号，关键词，时间区间，需求条数
	 * @param itcode  用户工号
	 * @param keyword   关键词
	 * @param begtime  开始时间
	 * @param endtime  结束时间
	 * @param number     需求条数
	 * @param jdbcTemplate
	 * @return
	 */
	public static List<ChatHistory> getAll(String itcode,String keyword,String begtime, String endtime,int number,JdbcTemplate jdbcTemplate) {
		try {
			All_user user=AlluserDAO.getUserByItcode(itcode, jdbcTemplate);
			RowMapper<ChatHistory> chat_mapper = new BeanPropertyRowMapper<ChatHistory>(ChatHistory.class);
			String key="%"+keyword+"%";
			List<ChatHistory> chat = jdbcTemplate.query("select * from chat_history where word like ? and uid=? and historytime>? and historytime<? order by historytime desc limit ?  ", chat_mapper,new Object[] {key,user.getUid(),begtime,endtime,number});
		    return chat;
		} catch (Exception e) {
			return null;
		}
	}


	/**
	 * 查找对应条件的聊天记录，指定时间区间
	 * @param begtime  开始时间
	 * @param endtime  结束时间
	 * @param jdbcTemplat
	 * @return
	 */
	public static List<ChatHistory> getWithout(String begtime, String endtime,JdbcTemplate jdbcTemplate) {
		try {
			RowMapper<ChatHistory> chat_mapper = new BeanPropertyRowMapper<ChatHistory>(ChatHistory.class);
			List<ChatHistory> chat = jdbcTemplate.query("select * from chat_history where historytime>? and historytime<?", chat_mapper,new Object[] {begtime,endtime});
		    return chat;
		} catch (Exception e) {
			return null;
		}
	}
	/**
	 * 查找对应条件的聊天记录，指定关键词，时间区间，需求条数
	 * @param keyword   关键词
	 * @param begtime  开始时间
	 * @param endtime  结束时间
	 * @param number     需求条数
	 * @param jdbcTemplate
	 * @return
	 */
	public static List<ChatHistory> getWithoutIt(String keyword,String begtime, String endtime,int number,JdbcTemplate jdbcTemplate) {
		try {
			RowMapper<ChatHistory> chat_mapper = new BeanPropertyRowMapper<ChatHistory>(ChatHistory.class);
			String key="%"+keyword+"%";
			List<ChatHistory> chat = jdbcTemplate.query("select * from chat_history where word like ?  and historytime>? and historytime<? order by historytime desc limit ?  ", chat_mapper,new Object[] {key,begtime,endtime,number});
		    return chat;
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * 查找对应条件的聊天记录，指定用户工号，时间区间，需求条数
	 * @param itcode  用户工号
	 * @param begtime  开始时间
	 * @param endtime  结束时间
	 * @param number     需求条数
	 * @param jdbcTemplate
	 * @return
	 */
	public static List<ChatHistory> getWithoutKey(String itcode,String begtime, String endtime,int number,JdbcTemplate jdbcTemplate) {
		try {
			All_user user=AlluserDAO.getUserByItcode(itcode, jdbcTemplate);
			RowMapper<ChatHistory> chat_mapper = new BeanPropertyRowMapper<ChatHistory>(ChatHistory.class);
			List<ChatHistory> chat = jdbcTemplate.query("select * from chat_history where uid=? and historytime>? and historytime<? order by historytime desc limit ?  ", chat_mapper,new Object[] {user.getUid(),begtime,endtime,number});
		    return chat;
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * 查找对应条件的聊天记录，指定用户工号，关键词，时间区间
	 * @param itcode  用户工号
	 * @param keyword   关键词
	 * @param begtime  开始时间
	 * @param endtime  结束时间
	 * @param jdbcTemplate
	 * @return
	 */
	public static List<ChatHistory> getWithoutNumber(String itcode,String keyword,String begtime, String endtime,JdbcTemplate jdbcTemplate) {
		try {
			All_user user=AlluserDAO.getUserByItcode(itcode, jdbcTemplate);
			String key="%"+keyword+"%";
			RowMapper<ChatHistory> chat_mapper = new BeanPropertyRowMapper<ChatHistory>(ChatHistory.class);
			List<ChatHistory> chat = jdbcTemplate.query("select * from chat_history where word like ? and uid=? and historytime>? and historytime<?  ", chat_mapper,new Object[] {key,user.getUid(),begtime,endtime});
		    return chat;
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * 查找对应条件的聊天记录，指定用户工号，时间区间
	 * @param itcode  用户工号
	 * @param begtime  开始时间
	 * @param endtime  结束时间
	 * @param jdbcTemplate
	 * @return
	 */
	public static List<ChatHistory> getByIt(String itcode,String begtime, String endtime,JdbcTemplate jdbcTemplate) {
		try {
			All_user user=AlluserDAO.getUserByItcode(itcode, jdbcTemplate);
			RowMapper<ChatHistory> chat_mapper = new BeanPropertyRowMapper<ChatHistory>(ChatHistory.class);
			List<ChatHistory> chat = jdbcTemplate.query("select * from chat_history where uid=? and historytime>? and historytime<?  ", chat_mapper,new Object[] {user.getUid(),begtime,endtime});
		    return chat;
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * 查找对应条件的聊天记录，指定关键词，时间区间
	 * @param keyword   关键词
	 * @param begtime  开始时间
	 * @param endtime  结束时间
	 * @param jdbcTemplate
	 * @return
	 */
	public static List<ChatHistory> getByKey(String keyword,String begtime, String endtime,JdbcTemplate jdbcTemplate) {
		try {
			RowMapper<ChatHistory> chat_mapper = new BeanPropertyRowMapper<ChatHistory>(ChatHistory.class);
			String key="%"+keyword+"%";
			List<ChatHistory> chat = jdbcTemplate.query("select * from chat_history where word like ? and historytime>? and historytime<?  ", chat_mapper,new Object[] {key,begtime,endtime});
			return chat;
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * 查找对应条件的聊天记录，指定时间区间，需求条数
	 * @param begtime  开始时间
	 * @param endtime  结束时间
	 * @param number     需求条数
	 * @param jdbcTemplate
	 * @return
	 */
	public static List<ChatHistory> getByNumber(String begtime, String endtime,int number,JdbcTemplate jdbcTemplate) {
		try {
			RowMapper<ChatHistory> chat_mapper = new BeanPropertyRowMapper<ChatHistory>(ChatHistory.class);
			List<ChatHistory> chat = jdbcTemplate.query("select * from chat_history where historytime>? and historytime<?  order by historytime desc limit ?  ", chat_mapper,new Object[] {begtime,endtime,number});
		    return chat;
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * 查找最新记录
	 * @param begtime  开始时间
	 * @param endtime  结束时间
	 * @param number     需求条数
	 * @param jdbcTemplate
	 * @return
	 */
	public static List<ChatHistory> getLatest(JdbcTemplate jdbcTemplate) {
		try {
			RowMapper<ChatHistory> chat_mapper = new BeanPropertyRowMapper<ChatHistory>(ChatHistory.class);
			List<ChatHistory> chat = jdbcTemplate.query("select * from chat_history order by historytime desc limit 50  ", chat_mapper);
		    return chat;
		} catch (Exception e) {
			return null;
		}
	}
}
