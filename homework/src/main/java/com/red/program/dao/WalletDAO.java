package com.red.program.dao;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.red.program.model.All_user;
import com.red.program.model.Redpacket;
import com.red.program.model.Trade;
import com.red.program.model.Wallet;



public class WalletDAO {
	/**
	 * 查找uid用户的账户
	 * 
	 * @param uid
	 * @param jdbcTemplate
	 * @return  成功 返回账户对象  失败，返回空
	 */
	public static Wallet getWalletByUid(int uid, JdbcTemplate jdbcTemplate) {
		try {
			RowMapper<Wallet> wallet_mapper = new BeanPropertyRowMapper<Wallet>(Wallet.class);
			Wallet wallet = jdbcTemplate.queryForObject("select * from wallet where uid=?", wallet_mapper, uid);
			return wallet;
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * 通过账户id查找用户的账户
	 * 
	 * @param wid
	 * @param jdbcTemplate
	 * @return  成功 返回账户对象  失败，返回空
	 */
	public static Wallet getWalletByWid(int wid, JdbcTemplate jdbcTemplate) {
		try {
			RowMapper<Wallet> wallet_mapper = new BeanPropertyRowMapper<Wallet>(Wallet.class);
			Wallet wallet = jdbcTemplate.queryForObject("select * from wallet where wid=?", wallet_mapper, wid);
			return wallet;
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * 通过用户工号查找用户的账户
	 * 
	 * @param itcode
	 *            用户工号
	 * @param jdbcTemplate
	 * @return  成功 返回账户对象  失败，返回空
	 */
	public static Wallet getWalletByItcode(String itcode, JdbcTemplate jdbcTemplate) {
		try {
			All_user user = AlluserDAO.getUserByItcode(itcode, jdbcTemplate);
			return WalletDAO.getWalletByUid(user.getUid(), jdbcTemplate);
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * 通过用户对象查找用户的账户
	 * 
	 * @param user
	 * @param jdbcTemplate
	 * @return  成功 返回账户对象  失败，返回空
	 */
	public static Wallet getWalletByUser(All_user user, JdbcTemplate jdbcTemplate) {
		try {
			return WalletDAO.getWalletByUid(user.getUid(), jdbcTemplate);
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * 通过用户id激活化账户
	 * 
	 * @param uid
	 *            用户id
	 * @param jdbcTemplate
	 * @return  激活成功 返回true 失败 返回false
	 */
	public static boolean initWallet(int uid, JdbcTemplate jdbcTemplate) {
		try {
			int i = jdbcTemplate.update("insert into wallet values(null,?,0,0,0)", uid);
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
	 * 通过用户工号激活账户
	 * 
	 * @param itcode
	 *            用户工号
	 * @param jdbcTemplate
	 * @return  激活成功 返回true 失败 返回false
	 */
	public static boolean initWallet(String itcode, JdbcTemplate jdbcTemplate) {
		try {
			All_user user = AlluserDAO.getUserByItcode(itcode, jdbcTemplate);
			return WalletDAO.initWallet(user.getUid(), jdbcTemplate);
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * 获取所有用户账户信息
	 * 
	 * @param jdbcTemplate
	 * @return 成功 返回账户列表 失败，返回空
	 */
	public static List<Wallet> getAllWallets(JdbcTemplate jdbcTemplate) {
		try {
			RowMapper<Wallet> wallet_mapper = new BeanPropertyRowMapper<Wallet>(Wallet.class);
			List<Wallet> wallet = jdbcTemplate.query("select * from wallet ", wallet_mapper);
			return wallet;
		} catch (Exception e) {
			return null;
		}
	}
	
	/**
	 * 获取按Raintimes排序的所有用户账户信息
	 * 
	 * @param jdbcTemplate
	 * @return 成功 返回账户列表 失败，返回空
	 */
	public static List<Wallet> getAllSorted(JdbcTemplate jdbcTemplate) {
		try {
			RowMapper<Wallet> wallet_mapper = new BeanPropertyRowMapper<Wallet>(Wallet.class);
			List<Wallet> wallet = jdbcTemplate.query("select * from wallet order by raintimes", wallet_mapper);
			return wallet;
		} catch (Exception e) {
			return null;
		}
	}
	
	
	
	/**
	 * 通过账户id更新账户id红包雨的次数
	 * @param wid  账户id
	 * @param jdbcTemplate
	 * @return 成功  返回true 失败 返回false
	 */
	public static boolean ChangeRainTimesByWid(int wid,JdbcTemplate jdbcTemplate) {
		try {
			int i=jdbcTemplate.update("update wallet set raintimes = raintimes+1 where wid=?",wid);
			if(i>0) {
				return true;
			}
			else {
				return false;
			}
			
		}catch(Exception e) {
			return false;
		}
	}
	
	/**
	 * 通过账户对象更新账户id红包雨的次数
	 * @param wallet 账户对象
	 * @param jdbcTemplate
	 * @return 成功  返回true 失败 返回false
	 */
	public static boolean ChangeRainTimesByWallet(Wallet wallet,JdbcTemplate jdbcTemplate) {
		try {
			return WalletDAO.ChangeRainTimesByWid(wallet.getWid(), jdbcTemplate);
		}catch(Exception e) {
			return false;
		}
	}
	
	/**
	 * 通过账户id更新账户余额
	 * @param wid 账户id
	 * @param volumn  金额
	 * @param jdbcTemplate
	 * @return  成功  返回true 失败 返回false
	 */
	public static boolean ChangeAmountByWid(int wid,int volumn,JdbcTemplate jdbcTemplate) {
		try {
			int i=jdbcTemplate.update("update wallet set amount=amount+? where wid=?",new Object[] {volumn,wid});
			if(i>0) {
				return true;
			}
			else {
				return false;
			}
			
		}catch(Exception e) {
			return false;
		}
	}
	
	/**
	 * 通过交易记录更新账户余额
	 * @param trade 交易记录
	 * @param jdbcTemplate
	 * @return  成功  返回true 失败 返回false
	 */
	public static boolean ChangeAmountByTrade(Trade trade,JdbcTemplate jdbcTemplate) {
		try {
			int i=jdbcTemplate.update("update wallet set amount=amount+? where wid=?",new Object[] {trade.getVolumn(),trade.getWid()});
			if(i>0) {
				return true;
			}
			else {
				return false;
			}
			
		}catch(Exception e) {
			return false;
		}
	}
	
	/**
	 * 通过账户更新账户余额
	 * @param wallet  账户对象
	 * @param volumn  金额
	 * @param jdbcTemplate
	 * @return  成功  返回true 失败 返回false
	 */
	public static boolean ChangeAmountByWallet(Wallet wallet,int volumn,JdbcTemplate jdbcTemplate) {
		try {
			int i=jdbcTemplate.update("update wallet set amount=amount+? where wid=?",new Object[] {volumn,wallet.getWid()});
			if(i>0) {
				return true;
			}
			else {
				return false;
			}
			
		}catch(Exception e) {
			return false;
		}
	}
	
	/**
	 * 通过用户工号对账户上锁
	 * @param itcode  用户工号
	 * @param jdbcTemplate
	 * @return result==1,上锁成功 result==0,上锁失败  result==-1,其他问题
	 */
	public static int lockUserByItcode(String itcode, JdbcTemplate jdbcTemplate) {
		try {
			All_user user=AlluserDAO.getUserByItcode(itcode, jdbcTemplate);
			int result = jdbcTemplate.update("update wallet set islock=1 where uid=?", user.getUid());
			return result;
		} catch (Exception e) {
			return -1;
		}
	}
	
	/**
	 * 通过用户工号解锁用户禁言
	 * @param itcode  用户工号
	 * @param jdbcTemplate
	 * @return
	 */
	public static int unlockUserByItcode(String itcode, JdbcTemplate jdbcTemplate) {
		try {
			All_user user=AlluserDAO.getUserByItcode(itcode, jdbcTemplate);
			int result = jdbcTemplate.update("update wallet set islock=0 where uid=?", user.getUid());
			return result;
		} catch (Exception e) {
			return -1;
		}
	}
	/**
	 * 通过工号判断当前用户是否禁言
	 * @param itcode  用户工号
	 * @param jdbcTemplate
	 * @return true  禁言   false  允许发言
	 */
	public static boolean isLock(String itcode, JdbcTemplate jdbcTemplate) {
		try {
			All_user user=AlluserDAO.getUserByItcode(itcode, jdbcTemplate);
			int result = jdbcTemplate.update("select islock from wallet where uid=? ", user.getUid());
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
	public static boolean awardToProgram(String username,int amount, String pro_name,JdbcTemplate jdbcTemplate)
	{
		try 
		{
			Date date = new Date();
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String formattedDate = formatter.format(date);
			RowMapper<All_user> all_user_mapper = new BeanPropertyRowMapper<All_user>(All_user.class);
			All_user user=jdbcTemplate.queryForObject("select * from all_user where username=?;", all_user_mapper,username);
			int uid=user.getUid();
			RowMapper<Wallet> wallet_mapper = new BeanPropertyRowMapper<Wallet>(Wallet.class);
			Wallet wallet=jdbcTemplate.queryForObject("select * from wallet where uid=?;",wallet_mapper,uid);
			int wid=wallet.getWid();
			jdbcTemplate.update("update wallet set amount=amount-? where uid=?;",new Object[] {amount,uid});
		    int id=ProgramDAO.getProgramByName(pro_name, jdbcTemplate).getPid();
			
			jdbcTemplate.update("insert into trade values(null,?,?,?,1,'打赏');",new Object[] {wid,amount,date});

			System.out.println(id);
			System.out.println(amount);
			
			BonusDAO.AddBonus(id, amount, jdbcTemplate);
			DepartmentDAO.addBonus(amount, DepartmentDAO.getDepartmentByDid(ProgramDAO.getProgramByName(pro_name, jdbcTemplate).getDept_id(), jdbcTemplate).getDeptname(), jdbcTemplate);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}
		public static boolean InitWalletByItcode(String itcode,JdbcTemplate jdbcTemplate) {
			RowMapper<All_user> all_user_mapper = new BeanPropertyRowMapper<All_user>(All_user.class);
			RowMapper<Wallet> wallet_mapper = new BeanPropertyRowMapper<Wallet>(Wallet.class);
			All_user user=jdbcTemplate.queryForObject("select * from all_user where itcode=?;", all_user_mapper,itcode);
			
			System.out.println("init acc");
			try {
				   Wallet w = jdbcTemplate.queryForObject("select * from wallet where uid=?  ", wallet_mapper,user.getUid());
					 } catch (EmptyResultDataAccessException e) {
				            // e.printStackTrace(); // 可以选择打印信息
				         initWallet(itcode,jdbcTemplate) ;
						 return true;
				        }
			
			return true;
		}
	

}
