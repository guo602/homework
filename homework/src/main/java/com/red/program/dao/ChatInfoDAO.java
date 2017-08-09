package com.red.program.dao;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.red.program.model.All_user;
import com.red.program.model.ChatInfo;

public class ChatInfoDAO {
	
	/**
	 * 通过用户id查询对话信息
	 * @param uid	用户id
	 * @param jdbcTemplate
	 * @return	成功返回chatinfo对象，失败返回null
	 */
	public static ChatInfo getChatInfoByPid(int uid, JdbcTemplate jdbcTemplate) {
		try {
			RowMapper<ChatInfo> chatInfo_mapper = new BeanPropertyRowMapper<ChatInfo>(ChatInfo.class);
			ChatInfo chatinfo = jdbcTemplate.queryForObject("select * from chat_info where uid=?", chatInfo_mapper, uid);
			return chatinfo;
		} catch (Exception e) {
			return null;
		}
	}
	
	/**
	 * 通过用户昵称查询对话信息
	 * @param nickname	用户昵称
	 * @param jdbcTemplate
	 * @return	成功返回chatinfo对象，失败返回null
	 */
	public static ChatInfo getChatInfoByName(int nickname, JdbcTemplate jdbcTemplate) {
		try {
			RowMapper<ChatInfo> chatInfo_mapper = new BeanPropertyRowMapper<ChatInfo>(ChatInfo.class);
			ChatInfo chatinfo = jdbcTemplate.queryForObject("select * from chat_info where nickname=?", chatInfo_mapper, nickname);
			return chatinfo;
		} catch (Exception e) {
			return null;
		}
	}
	
	/**
	 * 通过用户id更改用户昵称
	 * @param uid	用户id
	 * @param nickname	用户昵称
	 * @param jdbcTemplate
	 * @return	修改成功返回1， 修改失败返回0，其他问题返回-1
	 */
	public static int updateName(int uid, String nickname,JdbcTemplate jdbcTemplate) {
		try {
			int result = jdbcTemplate.update("update chat_info set nickname=? where uid=?", new Object[] {nickname,uid});
			return result;
		} catch (Exception e) {
			return -1;
		}
	}
	
	/**
	 * 通过用户id完成头像上传
	 * @param uid	用户id
	 * @param bytes	上传的图片以二进制方式传递
	 * @param jdbcTemplate	
	 * @return	成功返回1，失败返回-1
	 */
	public static int updateImage(int uid, byte[] bytes,JdbcTemplate jdbcTemplate) {
		try {
			int result = jdbcTemplate.update("update chat_info set image=? where uid=?", new Object[] {bytes,uid});
			return result;
		} catch (Exception e) {
			return -1;
		}
	}
	
	/**
	 * 通过用户id对聊天用户实施禁言
	 * @param uid  用户id
	 * @param jdbcTemplate
	 * @return 成功返回1，失败返回0，其他问题返回-1
	 */
	public static int lockUserById(int uid, JdbcTemplate jdbcTemplate) {
		try {

			int result = jdbcTemplate.update("update chat_info set islock=1 where uid=?", uid);
			return result;
		} catch (Exception e) {
			return -1;
		}
	}

	/**
	 * 通过用户工号对聊天用户实施禁言
	 * @param itcode  用户工号
	 * @param jdbcTemplate
	 * @return result==1,上锁成功 result==0,上锁失败  result==-1,其他问题
	 */
	public static int lockUserByItcode(String itcode, JdbcTemplate jdbcTemplate) {
		try {
			All_user user=AlluserDAO.getUserByItcode(itcode, jdbcTemplate);
			int result = jdbcTemplate.update("update chat_info set islock=1 where uid=?", user.getUid());
			return result;
		} catch (Exception e) {
			return -1;
		}
	}
	/**
	 * 通过用户id解锁用户禁言
	 * @param uid  用户id
	 * @param jdbcTemplate
	 * @return result==1,解锁成功  result==0,解锁失败 result==-1,其他问题
	 */
	public static int unlockUserByID(int uid, JdbcTemplate jdbcTemplate) {
		try {
			int result = jdbcTemplate.update("update chat_info set islock=0 where uid=?", uid);
			return result;
		} catch (Exception e) {
			return -1;
		}
	}
	/**
	 * 通过用户工号解锁用户禁言
	 * @param itcode  用户工号
	 * @param jdbcTemplate
	 * @return	成功返回1，失败返回0，其他问题返回-1
	 */
	public static int unlockUserByItcode(String itcode, JdbcTemplate jdbcTemplate) {
		try {
			All_user user=AlluserDAO.getUserByItcode(itcode, jdbcTemplate);
			int result = jdbcTemplate.update("update chat_info set islock=0 where uid=?", user.getUid());
			return result;
		} catch (Exception e) {
			return -1;
		}
	}
	/**
	 * 通过id判断当前用户是否禁言
	 * @param uid  用户id
	 * @param jdbcTemplate
	 * @return true  禁言   ，false  允许发言
	 */
	public static boolean isLock(int uid, JdbcTemplate jdbcTemplate) {
		try {
			int result = jdbcTemplate.update("select islock from chat_info where uid=? ", uid);
			if(result==1){
			    return true;
			}
			else {
				return false;
			}
		} catch (Exception e) {
			return false;
		}
	}
	
	
	
	
}