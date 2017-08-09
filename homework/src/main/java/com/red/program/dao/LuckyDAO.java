package com.red.program.dao;

import org.springframework.jdbc.core.JdbcTemplate;

import com.red.program.model.Wallet;

public class LuckyDAO {
	/**
	 * 对指定账户充值volumn数值，相当于发红包,红包雨 更改数据库系统红包总余额 更改用户红包金额 更改用户获取红包雨次数 添加红包记录
	 * 
	 * @param wallet
	 *            用户账户
	 * @param volumn
	 *            红包数额
	 * @param round
	 *            指定轮次
	 * @param jdbcTemplate
	 * @return
	 */
	public static int LuckyRain(Wallet wallet, int volumn, int round, JdbcTemplate jdbcTemplate) {
		try {
			boolean result = false;
			while (result != true) {
				result = LuckyMoneyDAO.Changetotal(round, volumn, jdbcTemplate);
			}
			result = false;
			while (result != true) {
				result = WalletDAO.ChangeAmountByWallet(wallet, volumn, jdbcTemplate);
			}
			result = false;
			while (result != true) {
				result = WalletDAO.ChangeRainTimesByWallet(wallet, jdbcTemplate);
			}
			result = false;
			while (result != true) {
				result = LuckyRecordDAO.CreateLuckyRecordByWallet(wallet, volumn, round, jdbcTemplate);
			}
			return 1;
		} catch (Exception e) {
			return 0;
		}
	}

}
