package com.red.program.dao;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.red.program.model.All_user;
import com.red.program.model.Trade;
import com.red.program.model.Wallet;


public class TradeDAO {
	/**
	 * 通过交易id查找trade对象
	 * 
	 * @param tid
	 *            交易记录id
	 * @param jdbcTemplate
	 * @return 成功：返回Trade对象 失败：null
	 */
	public static Trade getTradeByTid(int tid, JdbcTemplate jdbcTemplate) {
		try {
			RowMapper<Trade> trade_mapper = new BeanPropertyRowMapper<Trade>(Trade.class);
			Trade trade = jdbcTemplate.queryForObject("select * from trade where tid=?", trade_mapper, tid);
			return trade;
		} catch (Exception e) {
			return null;
		}
	}
	
	/**
	 * 获取所有的交易记录
	 * @param jdbcTemplate
	 * @return
	 */
	public static List<Trade> getAll(JdbcTemplate jdbcTemplate){
		try {
			RowMapper<Trade> trade_mapper = new BeanPropertyRowMapper<Trade>(Trade.class);
			List<Trade> trades = jdbcTemplate.query("select * from trade", trade_mapper);
			return trades;
		} catch (Exception e) {
			return null;
		}
	}
	
	/**
	 * 获取所有的充值记录
	 * @param jdbcTemplate
	 * @return
	 */
	public static List<Trade> getAllRecharge(JdbcTemplate jdbcTemplate){
		try {
			RowMapper<Trade> trade_mapper = new BeanPropertyRowMapper<Trade>(Trade.class);
			List<Trade> trades = jdbcTemplate.query("select * from trade where property=0", trade_mapper);
			return trades;
		} catch (Exception e) {
			return null;
		}
	}
	
	/**
	 * 获取所有的打赏记录
	 * @param jdbcTemplate
	 * @return
	 */
	public static List<Trade> getAllReward(JdbcTemplate jdbcTemplate){
		try {
			RowMapper<Trade> trade_mapper = new BeanPropertyRowMapper<Trade>(Trade.class);
			List<Trade> trades = jdbcTemplate.query("select * from trade where property=1", trade_mapper);
			return trades;
		} catch (Exception e) {
			return null;
		}
	}
	/**
	 * 查找账户账户id的交易记录
	 * 
	 * @param wid
	 *            账户id
	 * @param jdbcTemplate
	 * @return 成功：账户id 交易记录列表 失败：null
	 */
	public static List<Trade> getTradeByWid(int wid, JdbcTemplate jdbcTemplate) {
		try {
			RowMapper<Trade> trade_mapper = new BeanPropertyRowMapper<Trade>(Trade.class);
			List<Trade> trade = jdbcTemplate.query("select * from trade where wid=?", trade_mapper, wid);
			return trade;
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * 查找账户id的充值记录
	 * 
	 * @param wid
	 *            账户id
	 * @param jdbcTemplate
	 * @return 成功：账户id 充值记录列表 失败：null
	 */
	public static List<Trade> getRechargeByWid(int wid, JdbcTemplate jdbcTemplate) {
		try {
			RowMapper<Trade> trade_mapper = new BeanPropertyRowMapper<Trade>(Trade.class);
			List<Trade> trade = jdbcTemplate.query("select * from trade where wid=? and property=0", trade_mapper, wid);
			return trade;
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * 查找账户id的打赏记录
	 * 
	 * @param wid
	 *            账户id
	 * @param jdbcTemplate
	 * @return 成功：账户id 打赏记录列表 失败：null
	 */
	public static List<Trade> getRewardByWid(int wid, JdbcTemplate jdbcTemplate) {
		try {
			RowMapper<Trade> trade_mapper = new BeanPropertyRowMapper<Trade>(Trade.class);
			List<Trade> trade = jdbcTemplate.query("select * from trade where wid=? and property=1", trade_mapper, wid);
			return trade;
		} catch (Exception e) {
			return null;
		}
	}


	

	/**
	 * 通过用户id查询充值记录
	 * 
	 * @param wid
	 *            账户id
	 * @param jdbcTemplate
	 * @return 成功：用户id的 充值记录列表 失败：null
	 */
	public static List<Trade> getTradesByUid(int uid, JdbcTemplate jdbcTemplate) {
		try {
			Wallet wallet = WalletDAO.getWalletByUid(uid, jdbcTemplate);
			List<Trade> trade = TradeDAO.getTradeByWid(wallet.getWid(), jdbcTemplate);
			return trade;
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * 通过用户id查询充值记录
	 * 
	 * @param wid
	 *            账户id
	 * @param jdbcTemplate
	 * @return 成功：用户id的 充值记录列表 失败：null
	 */
	public static List<Trade> getRechargeByUid(int uid, JdbcTemplate jdbcTemplate) {
		try {
			Wallet wallet = WalletDAO.getWalletByUid(uid, jdbcTemplate);
			List<Trade> trade = TradeDAO.getRechargeByWid(wallet.getWid(), jdbcTemplate);
			return trade;
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * 通过用户id查询打赏记录
	 * 
	 * @param wid
	 *            账户id
	 * @param jdbcTemplate
	 * @return 成功：用户id的 打赏记录列表 失败：null
	 */
	public static List<Trade> getRewardByUid(int uid, JdbcTemplate jdbcTemplate) {
		try {
			Wallet wallet = WalletDAO.getWalletByUid(uid, jdbcTemplate);
			List<Trade> trade = TradeDAO.getRewardByWid(wallet.getWid(), jdbcTemplate);
			return trade;
		} catch (Exception e) {
			return null;
		}
	}
	/**
	 * 通过用户工号it查询交易记录
	 * 
	 * @param itcode
	 *            用户工号
	 * @param jdbcTemplate
	 * @return 成功：用户id的 交易记录列表 失败：null
	 */
	public static List<Trade> getTradesByItcode(String itcode, JdbcTemplate jdbcTemplate) {

		try {
			All_user user = AlluserDAO.getUserByItcode(itcode, jdbcTemplate);
			List<Trade> trade = TradeDAO.getTradesByUid(user.getUid(), jdbcTemplate);
			return trade;
		} catch (Exception e) {
			return null;
		}
	}
	/**
	 * 通过用户工号it查询充值记录
	 * 
	 * @param itcode
	 *            用户工号
	 * @param jdbcTemplate
	 * @return 成功：用户id的 充值记录列表 失败：null
	 */
	public static List<Trade> getRechargeByItcode(String itcode, JdbcTemplate jdbcTemplate) {

		try {
			All_user user = AlluserDAO.getUserByItcode(itcode, jdbcTemplate);
			List<Trade> trade = TradeDAO.getRechargeByUid(user.getUid(), jdbcTemplate);
			return trade;
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * 通过用户工号it查询充值记录
	 * 
	 * @param itcode
	 *            用户工号
	 * @param jdbcTemplate
	 * @return 成功：用户id的 打赏记录列表 失败：null
	 */
	public static List<Trade> getRewardByItcode(String itcode, JdbcTemplate jdbcTemplate) {

		try {
			All_user user = AlluserDAO.getUserByItcode(itcode, jdbcTemplate);
			List<Trade> trade = TradeDAO.getRewardByUid(user.getUid(), jdbcTemplate);
			return trade;
		} catch (Exception e) {
			return null;
		}
	}
	
	/**
	 * 通过用户对象查询充值记录
	 * 
	 * @param user
	 *            用户对象
	 * @param jdbcTemplate
	 * @return 成功：用户的 充值记录列表 失败：null
	 */
	public static List<Trade> getTradesByUser(All_user user, JdbcTemplate jdbcTemplate) {
		try {
			List<Trade> trade = TradeDAO.getTradesByUid(user.getUid(), jdbcTemplate);
			return trade;
		} catch (Exception e) {
			return null;
		}
	}

	
	/**
	 * 查找充值数额在{volumn1，volumn2}的交易记录
	 * 
	 * @param volumn1
	 *            充值下限
	 * @param volumn2
	 *            充值上限
	 * @param jdbcTemplate
	 * @return 成功：充值数额在{volumn1，volumn2}充值记录列表 失败：null
	 */
	public static List<Trade> getTradeByVolumnSection(int volumn1, int volumn2, JdbcTemplate jdbcTemplate) {
		try {
			RowMapper<Trade> trade_mapper = new BeanPropertyRowMapper<Trade>(Trade.class);
			List<Trade> trade = jdbcTemplate.query("select * from trade where volumn>=? and volumn<=? ",
					trade_mapper, new Object[] { volumn1, volumn2 });
			return trade;
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * 查找账户wid充值数额在{volumn1，volumn2}的交易记录
	 * 
	 * @param wid
	 *            员工账户
	 * @param volumn1
	 *            充值下限
	 * @param volumn2
	 *            充值上限
	 * @param jdbcTemplate
	 * @return 成功：账户wid充值数额在{volumn1，volumn2}充值记录列表 失败：null
	 */
	public static List<Trade> getTradeByWid_VolumnSection(int wid, int volumn1, int volumn2,
			JdbcTemplate jdbcTemplate) {
		try {
			RowMapper<Trade> trade_mapper = new BeanPropertyRowMapper<Trade>(Trade.class);
			List<Trade> trade = jdbcTemplate.query("select * from trade where wid=? and volumn>=? and volumn<=? ",
					trade_mapper, new Object[] { wid, volumn1, volumn2 });
			return trade;
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * 查找充值时间在{time1，time2}的交易记录
	 * 
	 * @param time1
	 *            时间下限
	 * @param time2
	 *            时间上限
	 * @param jdbcTemplate
	 * @return 成功：充值时间在{time1，time2}充值记录列表 失败：null
	 */
	public static List<Trade> getTradeByTradetimeSection(String time1, String time2, JdbcTemplate jdbcTemplate) {
		try {
			RowMapper<Trade> trade_mapper = new BeanPropertyRowMapper<Trade>(Trade.class);
			List<Trade> trade = jdbcTemplate.query("select * from trade where tradetime>=? and tradetime<=? ", trade_mapper,
					new Object[] { time1, time2 });
			return trade;
		} catch (Exception e) {
			return null;
		}
	}
	/**
	 * 查找充值时间在{time1，time2},金额在{minv,maxv}的充值记录
	 * 
	 * @param time1
	 *            时间下限
	 * @param time2
	 *            时间上限
	 * @param min
	 *            金额下限
	 * @param max
	 *            金额上限          
	 * @param jdbcTemplate
	 * @return 成功：充值时间在{time1，time2}充值记录列表 失败：null
	 */
	public static List<Trade> getRechargeByTime_Volumn(String time1, String time2, int min,int max,JdbcTemplate jdbcTemplate) {
		try {
			RowMapper<Trade> trade_mapper = new BeanPropertyRowMapper<Trade>(Trade.class);
			List<Trade> trade = jdbcTemplate.query("select * from trade where tradetime>=? and tradetime<=? and volumn>=? and volumn <=? and property=0", trade_mapper,
					new Object[] { time1, time2,min,max });
			return trade;
		} catch (Exception e) {
			return null;
		}
	}
    
	/**
	 * 查找充值时间在{time1，time2},金额在指定区间的充值记录
	 * @param itcode  用户工号
	 * @param time1
	 *            时间下限
	 * @param time2
	 *            时间上限
	 * @param min
	 *            金额下限
	 * @param max
	 *            金额上限          
	 * @param jdbcTemplate
	 * @return 成功：充值时间在{time1，time2}充值记录列表 失败：null
	 */
	public static List<Trade> getRechargeByIt_Time_Volumn(String itcode,String time1, String time2, int min,int max,JdbcTemplate jdbcTemplate) {
		try {
			Wallet wallet=WalletDAO.getWalletByItcode(itcode, jdbcTemplate);
			RowMapper<Trade> trade_mapper = new BeanPropertyRowMapper<Trade>(Trade.class);
			List<Trade> trade = jdbcTemplate.query("select * from trade where wid=? and tradetime>=? and tradetime<=? and volumn>=? and volumn <=? and property=0 ", trade_mapper,
					new Object[] { wallet.getWid(),time1, time2,min,max });
			return trade;
		} catch (Exception e) {
			return null;
		}
	}
	/**
	 * 查找打赏时间在{time1，time2},金额在{minv,maxv}的打赏记录
	 * 
	 * @param time1
	 *            时间下限
	 * @param time2
	 *            时间上限
	 * @param min
	 *            金额下限
	 * @param max
	 *            金额上限          
	 * @param jdbcTemplate
	 * @return 成功：打赏时间在{time1，time2}打赏记录列表 失败：null
	 */
	public static List<Trade> getRewardByTime_Volumn(String time1, String time2, int min,int max,JdbcTemplate jdbcTemplate) {
		try {
			RowMapper<Trade> trade_mapper = new BeanPropertyRowMapper<Trade>(Trade.class);
			List<Trade> trade = jdbcTemplate.query("select * from trade where tradetime>=? and tradetime<=? and volumn>=? and volumn <=? and property=1", trade_mapper,
					new Object[] { time1, time2,min,max });
			return trade;
		} catch (Exception e) {
			return null;
		}
	}
    
	/**
	 * 查找充值时间在{time1，time2},金额在指定区间的打赏记录
	 * @param itcode  用户工号
	 * @param time1
	 *            时间下限
	 * @param time2
	 *            时间上限
	 * @param min
	 *            金额下限
	 * @param max
	 *            金额上限          
	 * @param jdbcTemplate
	 * @return 成功：打赏时间在{time1，time2}打赏记录列表 失败：null
	 */
	public static List<Trade> getRewardByIt_Time_Volumn(String itcode,String time1, String time2, int min,int max,JdbcTemplate jdbcTemplate) {
		try {
			Wallet wallet=WalletDAO.getWalletByItcode(itcode, jdbcTemplate);
			System.out.println(wallet.getWid());
			System.out.println(time1);
			System.out.println(time2);
			System.out.println(min);
			System.out.println(max);
			RowMapper<Trade> trade_mapper = new BeanPropertyRowMapper<Trade>(Trade.class);
			List<Trade> trade = jdbcTemplate.query("select * from trade where wid=? and tradetime>=? and tradetime<=? and volumn>=? and volumn <=? and property=1 ", trade_mapper,
					new Object[] { wallet.getWid(),time1, time2,min,max });
			return trade;
		} catch (Exception e) {
			return null;
		}
	}
	/**
	 * 查找账户wid充值时间在{time1，time2}的交易记录
	 * 
	 * @param wid
	 *            账户id
	 * @param time1
	 *            时间下限
	 * @param time2
	 *            时间上限
	 * @param jdbcTemplate
	 * @return 成功：账户wid充值时间在{time1，time2}充值记录列表 失败：null
	 */
	public static List<Trade> getTradeByTradetimeSection(int wid, String time1, String time2,
			JdbcTemplate jdbcTemplate) {
		try {
			RowMapper<Trade> trade_mapper = new BeanPropertyRowMapper<Trade>(Trade.class);
			List<Trade> trade = jdbcTemplate.query("select * from trade where wid=? and tradetime>=? and tradetime<=? ",
					trade_mapper, new Object[] { wid, time1, time2 });
			return trade;
		} catch (Exception e) {
			return null;
		}
	}
    
	
	/**
	 * 用户打赏时判断余额是否足够
	 * 
	 * @param wid
	 *            账户id
	 * @param volumn
	 *            打赏金额
	 * @param jdbcTemplate
	 * @return true 金额足够，可以打赏 false 金额不足，无法打赏
	 */
	private static boolean preTrade(int wid, int volumn, JdbcTemplate jdbcTemplate) {
		try {
			Wallet wallet = WalletDAO.getWalletByWid(wid, jdbcTemplate);
			if (wallet.getAmount() >= volumn) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			return false;
		}
	}
    
	/**
	 * 通过账户id插入打赏记录,0为充值，1为打赏
	 * @param wid  账户id
	 * @param volumn  打赏金额
	 * @param memo    备注
	 * @param jdbcTemplate
	 * @return    充值成功，返回true，否则返回false
	 */
	public static boolean createRewardByWid(int wid, int volumn, String memo, JdbcTemplate jdbcTemplate) {
		try {
			if (preTrade(wid, volumn, jdbcTemplate)) {
				Date date = new Date();
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式
				String formattedDate = dateFormat.format(date);
				int i = jdbcTemplate.update("insert into trade values(null, ?,?,?,'1',?);",
						                     new Object[] { wid, volumn, formattedDate,memo });
				if(i>0) {
				   return true;
				}
				else {
					return false;
				}
			} else {
				return false;
			}
		} catch (Exception e) {
			return false;
		}
	}
	
	/**
	 * 通过用户id插入打赏记录
	 * @param uid  用户id
	 * @param volumn  打赏金额
	 * @param memo    备注
	 * @param jdbcTemplate  
	 * @return  充值成功，返回true，否则 返回false
	 */
	public static boolean createRewardByUid(int uid, int volumn, String memo, JdbcTemplate jdbcTemplate) {
		try {
			Wallet wallet=WalletDAO.getWalletByUid(uid, jdbcTemplate);
			return TradeDAO.createRewardByWid(wallet.getWid(), volumn, memo, jdbcTemplate);
		} catch (Exception e) {
			return false;
		}
	}
	
	 /**
	  * 通过用户工号插入打赏记录
	  * @param itcode  用户工号
	  * @param volumn  打赏金额
	  * @param memo    备注
	  * @param jdbcTemplate
	  * @return   充值成功，返回true，否则 返回false
	  */
	public static boolean createRewardByItcode(String itcode, int volumn, String memo, JdbcTemplate jdbcTemplate) {
		try {
			All_user user =AlluserDAO.getUserByItcode(itcode, jdbcTemplate);
			return TradeDAO.createRewardByUid(user.getUid(), volumn, memo, jdbcTemplate);
		} catch (Exception e) {
			return false;
		}
	}

	 /**
	  * 通过用户对象插入打赏记录
	  * @param user  用户对象
	  * @param volumn  打赏金额
	  * @param memo    备注
	  * @param jdbcTemplate
	  * @return   充值成功，返回true，否则 返回false
	  */
	public static boolean createRewardByUser(All_user user, int volumn, String memo, JdbcTemplate jdbcTemplate) {
		try {
			return TradeDAO.createRewardByUid(user.getUid(), volumn, memo, jdbcTemplate);
		} catch (Exception e) {
			return false;
		}
	}
	
	/**
	 * 通过账户id插入充值记录,0为充值，1为打赏
	 * @param wid  账户id
	 * @param volumn  充值,金额
	 * @param memo    备注
	 * @param jdbcTemplate
	 * @return    充值成功，返回true，否则返回false
	 */
	public static boolean createRechargeByWid(int wid, int volumn, String memo, JdbcTemplate jdbcTemplate) {
		try {
				Date date = new Date();
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式
				String formattedDate = dateFormat.format(date);
				int i = jdbcTemplate.update("insert into trade values(null, ?,?,?,'0',?);",
						                     new Object[] { wid, volumn, formattedDate,memo });
				if(i>0) {
				   return true;
				}
				else {
					return false;
				}
		} catch (Exception e) {
			return false;
		}
	}
	
	/**
	 * 通过用户id插入充值记录
	 * @param uid  用户id
	 * @param volumn  充值金额
	 * @param memo    备注
	 * @param jdbcTemplate  
	 * @return  充值成功，返回true，否则 返回false
	 */
	public static boolean createRechargeByUid(int uid, int volumn, String memo, JdbcTemplate jdbcTemplate) {
		try {
			Wallet wallet=WalletDAO.getWalletByUid(uid, jdbcTemplate);
			return TradeDAO.createRechargeByWid(wallet.getWid(), volumn, memo, jdbcTemplate);
		} catch (Exception e) {
			return false;
		}
	}
	
	 /**
	  * 通过用户工号插入充值记录
	  * @param itcode  用户工号
	  * @param volumn  充值金额
	  * @param memo    备注
	  * @param jdbcTemplate
	  * @return   充值成功，返回true，否则 返回false
	  */
	public static boolean createRechargeByItcode(String itcode, int volumn, String memo, JdbcTemplate jdbcTemplate) {
		try {
			All_user user =AlluserDAO.getUserByItcode(itcode, jdbcTemplate);
			return TradeDAO.createRechargeByUid(user.getUid(), volumn, memo, jdbcTemplate);
		} catch (Exception e) {
			return false;
		}
	}

	 /**
	  * 通过用户对象插入充值记录
	  * @param user  用户对象
	  * @param volumn  充值金额
	  * @param memo    备注
	  * @param jdbcTemplate
	  * @return   充值成功，返回true，否则 返回false
	  */
	public static boolean createRechargeByUser(All_user user, int volumn, String memo, JdbcTemplate jdbcTemplate) {
		try {
			return TradeDAO.createRewardByUid(user.getUid(), volumn, memo, jdbcTemplate);
		} catch (Exception e) {
			return false;
		}
	}
}
