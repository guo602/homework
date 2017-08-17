package com.red.program;

import java.io.UnsupportedEncodingException;
import java.lang.annotation.Repeatable;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.red.program.dao.LuckyRecordDAO;
import com.red.program.dao.RedpacketDAO;
import com.red.program.dao.TradeDAO;
import com.red.program.model.LuckyRecord;
import com.red.program.model.Trade;

import redPacketGet.RedPacketGet;


@Controller
public class RedTableController {
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Autowired  
	  HttpServletRequest request;  
	
	@RequestMapping(value ="check_open_ajax", method = RequestMethod.GET)
	@ResponseBody
	public String checkopen(Model model) {
		System.out.println("in check open");

		if(RedpacketDAO.HasOpen(jdbcTemplate))
		return "1";
		else return "0";
	}
	

	@RequestMapping(value ="get_red_ajax", method = RequestMethod.GET)
	public String cget_red_ajaxn(Model model) {
		
		//model.addAttribute("isopen", "1");
		
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		HttpSession session=request.getSession();
		String itcode=(String)session.getAttribute("itcode");
		
		System.out.println("i get this");
		RedPacketGet rpg=new RedPacketGet();
		String rednumber="0";
		rpg.setJdbcTemplate(jdbcTemplate);
		if(rpg.StillHave()) {rednumber=rpg.robRed(itcode);}
		else {return "no_red_left";}
		
		
		
		model.addAttribute("msg", rednumber);
		
		return "getmsg";
	}
	@RequestMapping(value ="get_redlist_ajax", method = RequestMethod.GET)
	public String get_redlist_ajax(Model model) {
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("req:get_redlist_ajax");
		HttpSession session=request.getSession();
		String itcode=(String)session.getAttribute("itcode");
		List<LuckyRecord> lucky=LuckyRecordDAO.getRecordByItcode(itcode, jdbcTemplate);
		model.addAttribute("lucky_record",lucky);
		//System.out.println(lucky.get(0).getLucky_money());
		return "redlist";
	}
	
	
	@RequestMapping(value ="admin_rob_red_open", method = RequestMethod.GET)
	public String Admin_robred_open(Model model) {
		
		RedpacketDAO.OpenByAdmin(jdbcTemplate);
		
		return "luckyrain";
		
		
	}
	
	
	@RequestMapping(value ="admin_rob_red_close", method = RequestMethod.GET)
	public String Admin_robred_close(Model model) {
		RedpacketDAO.CloseByAdmin(jdbcTemplate);

		return "luckyrain";
	}
	
	
	
	
}