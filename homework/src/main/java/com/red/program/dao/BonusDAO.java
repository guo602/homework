package com.red.program.dao;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.red.program.model.Bonus;
import com.red.program.model.Pro_bonus;
import com.red.program.model.Program;

public class BonusDAO {
	/**
	 * 通过节目编号查询节目赏金
	 * @param pid
	 * @param jdbcTemplate
	 * @return
	 */
	public static Bonus getProgramBonus(int pid, JdbcTemplate jdbcTemplate) {
		try {
			RowMapper<Bonus> bonus_mapper = new BeanPropertyRowMapper<Bonus>(Bonus.class);
			Bonus bonus = jdbcTemplate.queryForObject("select bonus from pro_bonus where pid=?", bonus_mapper, pid);
			return bonus;
		} catch (Exception e) {
			return null;
		}
	}
	
	/**
	 * 插入指定节目，开启打赏
	 * @param pid
	 * @param bonus
	 * @param jdbcTemplate
	 * @return
	 */
	public static boolean CreateBonus(int pid,JdbcTemplate jdbcTemplate) {
		try {
			int i = jdbcTemplate.update("insert into pro_bonus values(?,0);",pid);
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
	 * 更改节目获得的打赏金额
	 * @param pid
	 * @param bonus
	 * @param jdbcTemplate
	 * @return
	 */
	public static boolean AddBonus(int pid,int bonus ,JdbcTemplate jdbcTemplate) {
		try {
			int i = jdbcTemplate.update("update pro_bonus set bonus=bonus+? where pid=?",new Object[] {bonus,pid});
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
	 * 查看当前ID对应的节目是否开启打赏
	 * @param pid
	 * @param jdbcTemplate
	 * @return  开启返回1，不开启返回0，失败返回-1
	 */
	public static int Isopen(int pid,JdbcTemplate jdbcTemplate) {
		try {
			int i = jdbcTemplate.queryForInt("select count(*) from pro_bonus where pid=?",pid);
			return i;
		} catch (Exception e) {
			return -1;
		}
	}
	
	public static List<Pro_bonus> ListBonusByOrder(JdbcTemplate jdbcTemplate) {
		try {
			
			RowMapper<Pro_bonus> b_mapper = new BeanPropertyRowMapper<Pro_bonus>(Pro_bonus.class);
			List<Pro_bonus>  bonus = jdbcTemplate.query("select * from pro_bonus order by bonus desc",
					b_mapper);
			
			System.out.println("bonusDAO");
		    return bonus;
		
		
		
		} catch (Exception e) {
			return null;
		}
	}


}









