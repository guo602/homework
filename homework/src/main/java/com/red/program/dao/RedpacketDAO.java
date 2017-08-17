package com.red.program.dao;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.red.program.model.ChatHistory;
import com.red.program.model.LuckyMoney;
import com.red.program.model.Redpacket;

public class RedpacketDAO {
	
	
	public static boolean StillHave(JdbcTemplate jdbcTemplate) {
		try {
			RowMapper<Redpacket> lucky_mapper = new BeanPropertyRowMapper<Redpacket>(Redpacket.class);
			List<Redpacket> rp = jdbcTemplate.query("select * from redpacket where isopen=1", lucky_mapper );
			if(rp!=null)return true;
			else return false;
			
		}catch(Exception e) {
			return false;
		}
	}
	

	public static void Close(JdbcTemplate jdbcTemplate) {
		try {
			RowMapper<Redpacket> lucky_mapper = new BeanPropertyRowMapper<Redpacket>(Redpacket.class);
			
			
			jdbcTemplate.update("update redpacket set isopen=0 where amount=0;");
			
			
		}catch(Exception e) {
			System.out.println("rpg error");
			return ;
		}
	}
	

}
