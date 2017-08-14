package com.red.program;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.red.program.dao.AlluserDAO;
import com.red.program.dao.WalletDAO;

@Controller
public class WalletAdminController {
	@Autowired
	JdbcTemplate jdbcTemplate;

	@RequestMapping("newbyadmin")
	public String newbyadmin(Model model) {
		return "newwalletbyadmin";
	}

	@RequestMapping("lockbyadmin")
	public String lockbyadmin(Model model) {
		return "lockwalletbyadmin";
	}

	@RequestMapping("unlockbyadmin")
	public String unlockbyadmin(Model model) {
		return "unlockwalletbyadmin";
	}

	@RequestMapping("newwallet")
	public String newwallet(String itcode, String name, Model model) {
		String result;

		if (AlluserDAO.checkUserInfo(itcode, name, jdbcTemplate)) {
			result = "当前用户账户已激活成功";
		} else {
			if (WalletDAO.initWallet(itcode, jdbcTemplate)) {
				result = "当前账户已成功激活，可使用";
			} else {
				result = "当前账户激活失败，请重试";
			}
		}
		model.addAttribute("result", result);

		return "newwalletbyadmin";
	}

	@RequestMapping("lockwallet")
	public String lockwallet(String itcode, String name, Model model) {
		String result;
		if (AlluserDAO.checkUserInfo(itcode, name, jdbcTemplate)) {
			if (WalletDAO.isLock(itcode, jdbcTemplate)) {
				result = "当前账户已成功锁定，用户无法使用";
			} else {
				if (WalletDAO.lockUserByItcode(itcode, jdbcTemplate) == 1) {
					result = "当前账户已成功锁定，用户无法使用";
				} else {
					result = "当前账户锁定失败，请重试";
				}
			}

		} else {
			result = "当前用户账户不存在，请先激活账户";
		}
		model.addAttribute("result", result);

		return "lockwalletbyadmin";
	}

	@RequestMapping("unlockwallet")
	public String adminwallet(String itcode, String name, Model model) {
		String result;

		if (AlluserDAO.checkUserInfo(itcode, name, jdbcTemplate)) {
			if (!WalletDAO.isLock(itcode, jdbcTemplate)) {
				result = "当前账户解锁成功，用户可使用";
			} else {
				if (WalletDAO.unlockUserByItcode(itcode, jdbcTemplate) == 1) {
					result = "当前账户已成功解锁，用户可使用";
				} else {
					result = "当前账户解锁失败，请重试";
				}
			}

		} else {
			result = "当前用户账户不存在，请先激活账户";
		}
		model.addAttribute("result", result);

		return "unlockwalletbyadmin";
	}

}
