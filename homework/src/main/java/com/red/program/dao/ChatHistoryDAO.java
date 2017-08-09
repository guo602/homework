package com.red.program.dao;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.red.program.model.All_user;
import com.red.program.model.ChatHistory;

public class ChatHistoryDAO {
	/**
	 * 通过用户id查找指定id的评论记录
	 * 
	 * @param uid
	 *            用户id
	 * @param jdbcTemplate
	 * @return 返回对应用户历史记录列表
	 */
	public static List<ChatHistory> getChatListByUid(int uid, JdbcTemplate jdbcTemplate) {
		try {
			RowMapper<ChatHistory> chat_mapper = new BeanPropertyRowMapper<ChatHistory>(ChatHistory.class);
			List<ChatHistory> chat = jdbcTemplate.query("select * from chat_history where uid=?", chat_mapper, uid);
			return chat;
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * 通过用户工号查找指定id的评论记录
	 * 
	 * @param itcode
	 *            用户工号
	 * @param jdbcTemplate
	 * @return 返回对应用户历史记录列表
	 */
	public static List<ChatHistory> getChatListByItcode(String itcode, JdbcTemplate jdbcTemplate) {
		try {
			All_user user = AlluserDAO.getUserByItcode(itcode, jdbcTemplate);
			return ChatHistoryDAO.getChatListByUid(user.getUid(), jdbcTemplate);
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * 查找指定时间的评论记录
	 * 
	 * @param time1
	 *            开始时间
	 * @param time2
	 *            结束时间
	 * @param jdbcTemplate
	 * @return 返回指定用户历史记录列表
	 */
	public static List<ChatHistory> getChatListByTime(String time1, String time2, JdbcTemplate jdbcTemplate) {
		try {
			RowMapper<ChatHistory> chat_mapper = new BeanPropertyRowMapper<ChatHistory>(ChatHistory.class);
			List<ChatHistory> chat = jdbcTemplate.query(
					"select * from chat_history where historytime>time1 and historytime<time2", chat_mapper,
					new Object[] { time1, time2 });
			return chat;
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * 通过用户id查找指定用户指定时间的评论记录
	 * 
	 * @param uid
	 *            用户id
	 * @param time1
	 *            开始时间
	 * @param time2
	 *            结束时间
	 * @param jdbcTemplate
	 * @return 返回指定用户历史记录列表
	 */
	public static List<ChatHistory> getChatListByUserTime(int uid, String time1, String time2,
			JdbcTemplate jdbcTemplate) {
		try {
			RowMapper<ChatHistory> chat_mapper = new BeanPropertyRowMapper<ChatHistory>(ChatHistory.class);
			List<ChatHistory> chat = jdbcTemplate.query(
					"select * from chat_history where uid=? and historytime>? and historytime<?", chat_mapper,
					new Object[] { uid, time1, time2 });
			return chat;
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * 通过用户工号查找指定用户指定时间的评论记录
	 * 
	 * @param itcode
	 * @param time1
	 *            开始时间
	 * @param time2
	 *            结束时间
	 * @param jdbcTemplate
	 * @return 返回指定用户历史记录列表
	 */
	public static List<ChatHistory> getChatListByItcodeTime(String itcode, String time1, String time2,
			JdbcTemplate jdbcTemplate) {
		try {
			All_user user = AlluserDAO.getUserByItcode(itcode, jdbcTemplate);
			return ChatHistoryDAO.getChatListByUid(user.getUid(), jdbcTemplate);
		} catch (Exception e) {
			return null;
		}
	}

	
	/**
	 * 显示最新二十条记录（弹幕）（目前实现的是返回所有记录）
	 * @param jdbcTemplate
	 * @return	成功返回所有聊天记录，失败返回null
	 */
	public static List<ChatHistory> getAll(JdbcTemplate jdbcTemplate){
		try {
			RowMapper<ChatHistory> chat_mapper = new BeanPropertyRowMapper<ChatHistory>(ChatHistory.class);
			 List<ChatHistory> list=jdbcTemplate.query("select * from chat_history", chat_mapper);
			 return list;
		}
		catch(Exception e) {
			return null;
		}
	}
	
	/**
	 * 插入聊天记录（插入hid自动生成null，时间当时获取，word是刚传入的string，uid是session获取）
	 * @param uid	用户id
	 * @param word	用户发言内容
	 * @param jdbcTemplate
	 * @return	成功返回1，失败返回0，其他问题返回-1
	 */
	public static int createHistory(String uid, String word, JdbcTemplate jdbcTemplate) {
		try {
			Date date = new Date();
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String formattedDate = formatter.format(date);

			int i = jdbcTemplate.update("insert into chat_history values(null, ?,?,?)",new Object[] { uid, word, formattedDate });
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
	 * 通过聊天记录编号hid删除言论（前端时只有管理员显示hid）
	 * @param hid	聊天记录编号id
	 * @param jdbcTemplate
	 * @return	成功返回true，失败返回true
	 */
	public static boolean AdminDelete(int hid, JdbcTemplate jdbcTemplate) {
		try {
			int i = jdbcTemplate.update("delete from chat_history where hid=?",hid);
			if (i > 0) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			return false;
		}
	}

}
