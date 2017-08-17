package redPacketGet;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.red.program.dao.RedpacketDAO;

import maopaoMethod.Mmp;

public class RedPacketGet {
	@Autowired
	JdbcTemplate jdbcTemplate;
	boolean flag = false;
	int round;
	
	public  RedPacketGet() {}
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	public int getRound() {
		return round;
	}

	public void setRound(int round) {
		this.round = round;
	}

	public boolean StillHave() {
		if(RedpacketDAO.StillHave(jdbcTemplate))return true;
		else return false;
		
		
	}
	
	public String robRed(String itcode ) {
		
		int money;
		int fenshu=RedpacketDAO.GetNumber(jdbcTemplate);
		if(fenshu==1) {money=RedpacketDAO.GetOpenTotal(jdbcTemplate);}
		else {
		int max=2*RedpacketDAO.GetOpenTotal(jdbcTemplate)/fenshu;
		
		Random r=new Random();
		
		 money=r.nextInt(max);
		if(money==0)money=1;
		}
		RedpacketDAO.ReduceAmount(  itcode,money, jdbcTemplate);
		
		
		
		
		return Mmp.moneyToString(money);
		
	}

}
