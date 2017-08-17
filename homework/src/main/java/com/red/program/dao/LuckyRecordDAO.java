package com.red.program.dao;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.red.program.model.All_user;
import com.red.program.model.LuckyRecord;
import com.red.program.model.Wallet;

public class LuckyRecordDAO {
	/**
	 * 閫氳繃璐︽埛id娣诲姞绾㈠寘璁板綍
	 * 
	 * @param wid
	 *            璐︽埛id
	 * @param lucky_money
	 *            绾㈠寘閲戦
	 * @param round
	 *            绾㈠寘闆ㄨ疆娆�
	 * @param jdbcTemplate
	 * @return
	 */
	public static boolean CreateLuckyRecordByWid(int wid, int lucky_money, int round, JdbcTemplate jdbcTemplate) {
		try {
			int i = jdbcTemplate.update("insert into lucky_record values(null,?,?,?);",
					new Object[] { wid, lucky_money, round });
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
	 * 閫氳繃鐢ㄦ埛id娣诲姞绾㈠寘璁板綍
	 * 
	 * @param uid
	 *            鐢ㄦ埛id
	 * @param lucky_money
	 *            绾㈠寘閲戦
	 * @param round
	 *            绾㈠寘闆ㄨ疆娆�
	 * @param jdbcTemplate
	 * @return
	 */
	public static boolean CreateLuckyRecordByUid(int uid, int lucky_money, int round, JdbcTemplate jdbcTemplate) {
		try {
			Wallet wallet=WalletDAO.getWalletByUid(uid, jdbcTemplate);
			return LuckyRecordDAO.CreateLuckyRecordByWid(wallet.getWid(), lucky_money, round, jdbcTemplate);
		} catch (Exception e) {
			return false;
		}
	}
	
	/**
	 * 閫氳繃鐢ㄦ埛瀵硅薄娣诲姞绾㈠寘璁板綍
	 * 
	 * @param user
	 *            鐢ㄦ埛瀵硅薄
	 * @param lucky_money
	 *            绾㈠寘閲戦
	 * @param round
	 *            绾㈠寘闆ㄨ疆娆�
	 * @param jdbcTemplate
	 * @return
	 */
	public static boolean CreateLuckyRecordByUser(All_user user, int lucky_money, int round, JdbcTemplate jdbcTemplate) {
		try {
			return LuckyRecordDAO.CreateLuckyRecordByUid(user.getUid(), lucky_money, round, jdbcTemplate);
		} catch (Exception e) {
			return false;
		}
	}
	
	/**
	 * 閫氳繃璐︽埛瀵硅薄娣诲姞绾㈠寘璁板綍
	 * 
	 * @param wallet
	 *            璐︽埛瀵硅薄
	 * @param lucky_money
	 *            绾㈠寘閲戦
	 * @param round
	 *            绾㈠寘闆ㄨ疆娆�
	 * @param jdbcTemplate
	 * @return
	 */
	public static boolean CreateLuckyRecordByWallet(Wallet wallet, int lucky_money, int round, JdbcTemplate jdbcTemplate) {
		try {
			return LuckyRecordDAO.CreateLuckyRecordByWid(wallet.getWid(), lucky_money, round, jdbcTemplate);
		} catch (Exception e) {
			return false;
		}
	}        
	/**
	 * 鑾峰彇鍏ㄩ儴绾㈠寘鍒楄〃
	 * @param jdbcTemplate
	 * @return
	 */
	public static List<LuckyRecord> getAll(JdbcTemplate jdbcTemplate) {
		try {
			RowMapper<LuckyRecord> lucky_mapper = new BeanPropertyRowMapper<LuckyRecord>(LuckyRecord.class);
			List<LuckyRecord> lucky = jdbcTemplate.query("select * from lucky_record", lucky_mapper);
			return lucky;
		} catch (Exception e) {
			return null;
		}
	}
	/**
	 * 鑾峰彇鎸囧畾杞绾㈠寘璁板綍
	 * @param round
	 * @param jdbcTemplate
	 * @return  鎴愬姛鍚庤繑鍥炲垪琛紝澶辫触杩斿洖null
	 */
	public static List<LuckyRecord> getAllByRound(int round, JdbcTemplate jdbcTemplate) {
		try {
			RowMapper<LuckyRecord> lucky_mapper = new BeanPropertyRowMapper<LuckyRecord>(LuckyRecord.class);
			List<LuckyRecord> lucky = jdbcTemplate.query("select * from lucky_record where round=?", lucky_mapper, round);
			return lucky;
		} catch (Exception e) {
			return null;
		}
	}
	
	/**
	 * 鑾峰彇鎸囧畾璐︽埛绾㈠寘璁板綍
	 * @param wid
	 * @param jdbcTemplate
	 * @return  鎴愬姛鍚庤繑鍥炲垪琛紝澶辫触杩斿洖null
	 */
	public static List<LuckyRecord> getAllByWid(int wid, JdbcTemplate jdbcTemplate) {
		try {
			RowMapper<LuckyRecord> lucky_mapper = new BeanPropertyRowMapper<LuckyRecord>(LuckyRecord.class);
			List<LuckyRecord> lucky = jdbcTemplate.query("select * from lucky_record where wid=?", lucky_mapper, wid);
			return lucky;
		} catch (Exception e) {
			return null;
		}
	}
	
	/**
	 * 鑾峰彇鎸囧畾鐢ㄦ埛绾㈠寘璁板綍
	 * @param uid
	 * @param jdbcTemplate
	 * @return  鎴愬姛鍚庤繑鍥炲垪琛紝澶辫触杩斿洖null
	 */
	public static List<LuckyRecord> getAllByUid(int uid, JdbcTemplate jdbcTemplate) {
		try {
			Wallet wallet=WalletDAO.getWalletByUid(uid, jdbcTemplate);
			return LuckyRecordDAO.getAllByWid(wallet.getWid(), jdbcTemplate);
		} catch (Exception e) {
			return null;
		}
	}
	
	
	/**
	 * 鑾峰彇鎸囧畾it鍦ㄦ寚瀹氳疆娆¤幏寰楃殑绾㈠寘闆�
	 * @param itcode
	 * @param round
	 * @param jdbcTemplate
	 * @return
	 */
	public static List<LuckyRecord> getByit_round(String itcode,int round,JdbcTemplate jdbcTemplate) {
		try {
			Wallet wallet=WalletDAO.getWalletByItcode(itcode, jdbcTemplate);
			RowMapper<LuckyRecord> lucky_mapper = new BeanPropertyRowMapper<LuckyRecord>(LuckyRecord.class);
			List<LuckyRecord> lucky = jdbcTemplate.query("select * from lucky_record where wid=? and round=?", lucky_mapper,new Object[] {wallet.getWid(),round});
			return lucky;
		} catch (Exception e) {
			return null;
		}
	}
	
	/**
	 * 鑾峰彇鎸囧畾杞鏈�鏂皀鏉℃暟鎹�
	 * @param num
	 * @param round
	 * @param jdbcTemplate
	 * @return
	 */
	public static List<LuckyRecord> getLatestByRound(int num,int round,JdbcTemplate jdbcTemplate) {
		try {
			RowMapper<LuckyRecord> lucky_mapper = new BeanPropertyRowMapper<LuckyRecord>(LuckyRecord.class);
			List<LuckyRecord> lucky = jdbcTemplate.query("select * from lucky_record where  round=?  limit ? ", lucky_mapper,new Object[] {round,num});
			return lucky;
		} catch (Exception e) {
			return null;
		}
	}
	
	/**
	 * 鑾峰彇鏈�鏂皀鏉℃暟鎹�
	 * @param num
	 * @param jdbcTemplate
	 * @return
	 */
	public static List<LuckyRecord> getLatest(int num,JdbcTemplate jdbcTemplate) {
		try {
			RowMapper<LuckyRecord> lucky_mapper = new BeanPropertyRowMapper<LuckyRecord>(LuckyRecord.class);
			List<LuckyRecord> lucky = jdbcTemplate.query("select * from lucky_record  limit ? ", lucky_mapper,num);
			return lucky;
		} catch (Exception e) {
			return null;
		}
	}
	public static List<LuckyRecord> getRecordByItcode(String itcode,JdbcTemplate jdbcTemplate)
	{
		try
		{
			RowMapper<All_user> all_user_mapper = new BeanPropertyRowMapper<All_user>(All_user.class);
			RowMapper<Wallet> wallet_mapper = new BeanPropertyRowMapper<Wallet>(Wallet.class);
			RowMapper<LuckyRecord> lucky_mapper = new BeanPropertyRowMapper<LuckyRecord>(LuckyRecord.class);
			All_user user=jdbcTemplate.queryForObject("select * from all_user where itcode=?", all_user_mapper,itcode);
			int uid=user.getUid();
			Wallet wallet=jdbcTemplate.queryForObject("select * from wallet where uid=?", wallet_mapper, uid);
			int wid=wallet.getWid();
			List<LuckyRecord> lucky=jdbcTemplate.query("select * from lucky_record where wid=?", lucky_mapper,wid);
			return lucky;
		}
		catch(Exception e)
		{
			return null;
		}
	}
}
