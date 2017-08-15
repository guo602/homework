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
	 * 通过账户id添加红包记录
	 * 
	 * @param wid
	 *            账户id
	 * @param lucky_money
	 *            红包金额
	 * @param round
	 *            红包雨轮次
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
	 * 通过用户id添加红包记录
	 * 
	 * @param uid
	 *            用户id
	 * @param lucky_money
	 *            红包金额
	 * @param round
	 *            红包雨轮次
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
	 * 通过用户对象添加红包记录
	 * 
	 * @param user
	 *            用户对象
	 * @param lucky_money
	 *            红包金额
	 * @param round
	 *            红包雨轮次
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
	 * 通过账户对象添加红包记录
	 * 
	 * @param wallet
	 *            账户对象
	 * @param lucky_money
	 *            红包金额
	 * @param round
	 *            红包雨轮次
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
	 * 获取全部红包列表
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
	 * 获取指定轮次红包记录
	 * @param round
	 * @param jdbcTemplate
	 * @return  成功后返回列表，失败返回null
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
	 * 获取指定账户红包记录
	 * @param wid
	 * @param jdbcTemplate
	 * @return  成功后返回列表，失败返回null
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
	 * 获取指定用户红包记录
	 * @param uid
	 * @param jdbcTemplate
	 * @return  成功后返回列表，失败返回null
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
	 * 获取指定it在指定轮次获得的红包雨
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
	 * 获取指定轮次最新n条数据
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
	 * 获取最新n条数据
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
}
