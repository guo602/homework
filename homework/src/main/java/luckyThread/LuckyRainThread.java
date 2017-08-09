package luckyThread;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.red.program.dao.LuckyDAO;
import com.red.program.dao.LuckyMoneyDAO;
import com.red.program.dao.WalletDAO;
import com.red.program.model.Wallet;

public class LuckyRainThread extends Thread {
	boolean flag = false;
	@Autowired
	JdbcTemplate jdbcTemplate;
	int round;

	public LuckyRainThread() {
		round = 0;
	}

	public LuckyRainThread(boolean flag, JdbcTemplate jdbcTemplate, int round) {
		this.flag = flag;
		this.round = round;
		this.jdbcTemplate = jdbcTemplate;
	}

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	public JdbcTemplate getTemplate() {
		return jdbcTemplate;
	}

	public void setTemplate(JdbcTemplate template) {
		this.jdbcTemplate = template;
	}

	public int getRound() {
		return round;
	}

	public void setRound(int round) {
		this.round = round;
	}

	/**
	 * 快跑！
	 */
	public void run() {
		System.out.println("雷公助我");
		System.out.println(LuckyMoneyDAO.getRoundByTotal(jdbcTemplate));
		List<Wallet> wallets = WalletDAO.getAllSorted(jdbcTemplate);
	
		if (wallets != null) {
			System.out.println("1");
			Random money = new Random();
			System.out.println("2");
			if (round < 5) {
				
				for (Wallet wallet : wallets) {
					int total = LuckyMoneyDAO.getTotalByRound(round, jdbcTemplate);
					int luckynum = 0;
					if (total > 5000) {
						luckynum = money.nextInt(4501) + 500;
					} else {
						luckynum = total;
					}
					int result = LuckyDAO.LuckyRain(wallet, luckynum, round, jdbcTemplate);
				}

			}
		} else {
			System.out.println("雨停了");
			return;
		}
	}
}
