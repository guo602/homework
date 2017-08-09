package com.red.program.dao;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.red.program.model.LuckyMoney;

/**
 * 系统红包余额相关操作
 * @author zheng
 *
 */
public class LuckyMoneyDAO {
	/**
	 * 通过轮次获取相应轮次的可发放余额
	 * @param round   相应轮次
	 * @param jdbcTemplate
	 * @return  成功  返回余额  失败  返回-1
	 */
	public static int getTotalByRound(int round ,JdbcTemplate jdbcTemplate) {
		try {
			RowMapper<LuckyMoney> lucky_mapper = new BeanPropertyRowMapper<LuckyMoney>(LuckyMoney.class);
			LuckyMoney lucky=jdbcTemplate.queryForObject("select * from lucky_money where round=?",lucky_mapper,round);
			return lucky.getTotal();
		}catch(Exception e) {
			return -1;
		}
	}
	
	
	/**
	 * 每次发放红包后更改系统余额
	 * @param round
	 * @param volumn
	 * @param jdbcTemplate
	 * @return
	 */
	public static boolean Changetotal(int round,int volumn,JdbcTemplate jdbcTemplate) {
		try {
			int i=jdbcTemplate.update("update lucky_money set total = total - ? where round=?",new Object[] {volumn,round});
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
	 * 获取当前应该开启的轮次
	 * @param jdbcTemplate
	 * @return
	 */
	public static int getRoundByTotal(JdbcTemplate jdbcTemplate) {
		try {
			int i=jdbcTemplate.queryForInt("select min(round) from lucky_money where total>0");
			if(i>0) {
				return i;
			}
			else {
				return -1;
			}
			
		}catch(Exception e) {
			return -1;
		}
	}

}
