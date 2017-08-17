package com.red.program.dao;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.red.program.model.ChatHistory;
import com.red.program.model.LuckyMoney;
import com.red.program.model.Redpacket;
import com.red.program.model.Wallet;

public class RedpacketDAO {
	public static void ReduceAmount(String itcode,int x,JdbcTemplate jdbcTemplate) {
		
		RowMapper<Redpacket> lucky_mapper = new BeanPropertyRowMapper<Redpacket>(Redpacket.class);

		Redpacket rpthis = jdbcTemplate.queryForObject("select * from redpacket where amount!=0 and isopen=1 order by times", lucky_mapper );
		if(rpthis==null) {System.out.println("ReduceAmount no money left or no open");return;}
		//更新红包库的total和红报数
		jdbcTemplate.update("update redpacket set amount=amount-? where times=?;",new Object[] {x,rpthis.getTimes()});
		jdbcTemplate.update("update redpacket set numbers=numbers-1 where times=?;",rpthis.getTimes());
		
		//更新钱包账户
		
		WalletDAO.ChangeAmountByWallet(WalletDAO.getWalletByItcode(itcode, jdbcTemplate),  x,  jdbcTemplate);
		
		//更新红包领取记录
		LuckyRecordDAO.CreateLuckyRecordByWallet(WalletDAO.getWalletByItcode(itcode, jdbcTemplate), x, rpthis.getTimes(), jdbcTemplate);

	}
	
	public static int GetOpenTotal(JdbcTemplate jdbcTemplate) {
		int x=8000;
		RowMapper<Redpacket> lucky_mapper = new BeanPropertyRowMapper<Redpacket>(Redpacket.class);

		x=jdbcTemplate.queryForObject("select * from redpacket where amount!=0 and isopen=1 order by times", lucky_mapper ).getAmount();
		
		return x;
	}
	
	
	
	public static int GetNumber(JdbcTemplate jdbcTemplate) {
		int x=8000;
		RowMapper<Redpacket> lucky_mapper = new BeanPropertyRowMapper<Redpacket>(Redpacket.class);

		x=jdbcTemplate.queryForObject("select * from redpacket where amount!=0 and isopen=1 order by times", lucky_mapper ).getNumbers();
		
		return x;
	}
	
	public static boolean OpenByAdmin(JdbcTemplate jdbcTemplate) {
		RowMapper<Redpacket> lucky_mapper = new BeanPropertyRowMapper<Redpacket>(Redpacket.class);
		List<Redpacket> rp = jdbcTemplate.query("select * from redpacket where amount!=0 order by times", lucky_mapper );
		if(rp==null)return false;
		else {
			Redpacket rp1=rp.get(0);
			
			
			jdbcTemplate.update("update redpacket set isopen=1 where times=?;",rp1.getTimes());
			
		return true;
		}
	}
	
	public static boolean CloseByAdmin(JdbcTemplate jdbcTemplate) {
		
		 Close( jdbcTemplate);
		 
			RowMapper<Redpacket> lucky_mapper = new BeanPropertyRowMapper<Redpacket>(Redpacket.class);

		Redpacket rpthis = jdbcTemplate.queryForObject("select * from redpacket where amount!=0 and isOpen=1 order by times", lucky_mapper );
		
		
		if(rpthis!=null)      //钱没发完
		 {    
				List<Redpacket> havebalance = jdbcTemplate.query("select * from redpacket where amount!=0 order by times", lucky_mapper );
                if(havebalance.size()==1) 
                //这是最后一次红包
                {
                	//do nothing
                	
                }
                
                 else //把余额加到下一次抢红包中
                {
                	
                	Redpacket rpnext = havebalance.get(1);
                	jdbcTemplate.update("update redpacket set amount=amount+? where times=?;",new Object[] {rpthis.getAmount(),rpnext.getTimes()});
        			jdbcTemplate.update("update redpacket set amount=0 where times=?;",rpthis.getTimes());

                	Close( jdbcTemplate);
                }
			 
		 }
		 else;
		return true;
		
	
	}

	public static boolean HasOpen(JdbcTemplate jdbcTemplate) {

		RowMapper<Redpacket> lucky_mapper = new BeanPropertyRowMapper<Redpacket>(Redpacket.class);

	Redpacket rpthis = jdbcTemplate.queryForObject("select * from redpacket where amount!=0 and isOpen=1 order by times", lucky_mapper );
	
	
		
		if(rpthis != null)return true;
		else return false;
		
	} 
	
	
	public static boolean StillHave(JdbcTemplate jdbcTemplate) {
		try {
			
			System.out.println("RedpDAO StillHave");
			System.out.println("try");

			RowMapper<Redpacket> lucky_mapper = new BeanPropertyRowMapper<Redpacket>(Redpacket.class);
			
			System.out.println("try");
			List<Redpacket> rp = jdbcTemplate.query("select * from redpacket where isOpen=1", lucky_mapper );
			System.out.println(rp.isEmpty());

			System.out.println(rp.get(0).getAmount());
			if(rp!=null)return true;
			else return false;
			
		}catch(Exception e) {
			
			System.out.println("RedpDAO StillHave error");
			return false;
		}
	}
	
  /**
   * 关闭正在开启但余额为0的红包发放包
   * @param jdbcTemplate
   */
	public static void Close(JdbcTemplate jdbcTemplate) {
		try {
			RowMapper<Redpacket> lucky_mapper = new BeanPropertyRowMapper<Redpacket>(Redpacket.class);
			
			
			jdbcTemplate.update("update redpacket set isOpen=0 where amount=0;");
			
			
		}catch(Exception e) {
			System.out.println("rpg error");
			return ;
		}
	}
	

}
