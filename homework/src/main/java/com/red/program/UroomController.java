package com.red.program;

import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.red.program.dao.AlluserDAO;
import com.red.program.dao.ChatHistoryDAO;
import com.red.program.dao.DepartmentDAO;
import com.red.program.dao.ProgramDAO;
import com.red.program.dao.TradeDAO;
import com.red.program.dao.WalletDAO;
import com.red.program.model.ChatHistory;
import com.red.program.model.Each_program;
import com.red.program.model.Program;

@Controller
public class UroomController {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Autowired  
	  HttpServletRequest request;  
	
	
	
	@RequestMapping("redtable")
	public String newtable(Model model) {
		return "redtable";
	}
	
	@RequestMapping("recharge")
	public String newbyadmin(Model model) {
		return "recharge";
	}
	
	@RequestMapping(value = "up_words", method = RequestMethod.GET)
	public String up_words(Model model) {
		
		try {
			request.setCharacterEncoding("UTF-8");
			HttpSession session=request.getSession();
			
			String words=request.getParameter("words");
			String itcode=(String)session.getAttribute("itcode");
		
			
			
			if( !words.equals("")) {
				
			ChatHistoryDAO.createHistory(AlluserDAO.getUserByItcode(itcode, jdbcTemplate).getUid(), words, jdbcTemplate);	
				
			}
			
			
			
			

			List<Program> pl=ProgramDAO.getAll(jdbcTemplate);
			List<Each_program> epl=new ArrayList<Each_program>();
			for (Program p:pl) {
				Each_program e =new Each_program(p.getPid(),
						p.getPro_name() , 
						p.getPerformer(),
						p.getStart_time(), 
						DepartmentDAO.getDepartmentByDid(p.getDept_id(),
								jdbcTemplate).getDeptname());
				epl.add(e);                            
			}
			model.addAttribute("pro", epl);
			
			
			
				return "users_room";
			
			
			
			
			
			
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			return "redloginproblem";
			
		}

	}

	
	@RequestMapping(value = "up_words_ajax", method = RequestMethod.GET)
	public String up_words_ajax(Model model,String word) {
		HttpSession session=request.getSession();
		String itcode=(String)session.getAttribute("itcode");
		
		if( !word.equals("")) {
			
		ChatHistoryDAO.createHistory(AlluserDAO.getUserByItcode(itcode, jdbcTemplate).getUid(), word, jdbcTemplate);	
			
		}
		System.out.println(word);
     return "n";
     

	}
	
	
	@RequestMapping(value = "rechargemoney", method = RequestMethod.GET)
	public String rechargemoney(Model model) {
		
		try {
			request.setCharacterEncoding("UTF-8");
			HttpSession session=request.getSession();
			
			//int amount=Integer.parseInt(request.getParameter("howmuch"));
			String itcode=(String)session.getAttribute("itcode");
		
		//	System.out.println(amount);
			System.out.println(itcode);
		//插入数据库
		//	TradeDAO.addMoneyToWallet(AlluserDAO.getUserByItcode(itcode, jdbcTemplate).getUsername(),amount,jdbcTemplate);
			
			
			//注入节目
			List<Program> pl=ProgramDAO.getAll(jdbcTemplate);
			List<Each_program> epl=new ArrayList<Each_program>();
			for (Program p:pl) {
				Each_program e =new Each_program(p.getPid(),
						p.getPro_name() , 
						p.getPerformer(),
						p.getStart_time(), 
						DepartmentDAO.getDepartmentByDid(p.getDept_id(),
								jdbcTemplate).getDeptname());
				epl.add(e);                            
			}
			//model.addAttribute("pro", epl);
			model.addAttribute("amount", request.getParameter("howmuch"));

			
			
				return "recharge";
			
			
			
			
			
			
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			return "redloginproblem";
			
		}

	}
	
	@RequestMapping(value = "recharge_ajax", method = RequestMethod.GET)
	public String recharge_ajax(Model model,String recharge) {
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HttpSession session=request.getSession();
		String itcode=(String)session.getAttribute("itcode");
		System.out.println(recharge);

		
		int amount=Integer.parseInt(recharge);
		
		System.out.println(amount);
		
		TradeDAO.addMoneyToWallet(AlluserDAO.getUserByItcode(itcode, jdbcTemplate).getUsername(),amount,jdbcTemplate);
		
		
		
		
		
		
		return "n";
	}
	@RequestMapping(value = "recharge2", method = RequestMethod.GET)
	public String recharge2(Model model,String recharge) {
		
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HttpSession session=request.getSession();
		String itcode=(String)session.getAttribute("itcode");
		String amount_s=request.getParameter("amount");
		amount_s = new String(amount_s.replace(".",""));
		int amount=0;
		if(amount_s.equals("099"))amount=99;
		else amount=Integer.parseInt(amount_s);
		TradeDAO.addMoneyToWallet(AlluserDAO.getUserByItcode(itcode, jdbcTemplate).getUsername(),amount,jdbcTemplate);
		
		return "rechargesuccess";
	}
		
	
	@RequestMapping(value = "rewards", method = RequestMethod.GET)
	public String rewards(Model model) {
		
		try {
			request.setCharacterEncoding("UTF-8");
			HttpSession session=request.getSession();
			String itcode=(String)session.getAttribute("itcode");
			
			String pro_name=request.getParameter("pro_name");
			String amount_s=request.getParameter("rewardamount");
		
			
			System.out.println(amount_s);
			
			
			amount_s = new String(amount_s.replace(".",""));
			
			System.out.println(amount_s);
			System.out.println(pro_name);
			System.out.println(AlluserDAO.getUserByItcode(itcode, jdbcTemplate).getUsername());
			
			int amount=Integer.parseInt(amount_s);
			
			if(amount> WalletDAO.getWalletByItcode(itcode,jdbcTemplate).getAmount()) {
				
				return "redloginproblem";
				
			}
			
			else   {
			
			
				WalletDAO.awardToProgram(AlluserDAO.getUserByItcode(itcode, jdbcTemplate).getUsername(), amount, pro_name, jdbcTemplate);   
			
				
				
				
		//插入数据库;
				
			
			
			//注入节目
			List<Program> pl=ProgramDAO.getAll(jdbcTemplate);
			List<Each_program> epl=new ArrayList<Each_program>();
			for (Program p:pl) {
				Each_program e =new Each_program(p.getPid(),
						p.getPro_name() , 
						p.getPerformer(),
						p.getStart_time(), 
						DepartmentDAO.getDepartmentByDid(p.getDept_id(),
								jdbcTemplate).getDeptname());
				epl.add(e);                            
			}
			model.addAttribute("pro", epl);
			
			
			
				return "users_room";
			
			}
			
			
			
			
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			return "redloginproblem";
			
		}

	}
	
	
	
	@RequestMapping(value = "reward_ajax", method = RequestMethod.GET)
	public String reward_ajax(Model model,String reward,String pro_name) {
		
		try {
			request.setCharacterEncoding("UTF-8");
			HttpSession session=request.getSession();
			String itcode=(String)session.getAttribute("itcode");
			

			
			
			System.out.println(reward);
			
			
			reward = new String(reward.replace(".",""));
			
			System.out.println(reward);
			System.out.println(pro_name);
			System.out.println(AlluserDAO.getUserByItcode(itcode, jdbcTemplate).getUsername());
			
			int amount=Integer.parseInt(reward);
			
			if(amount> WalletDAO.getWalletByItcode(itcode,jdbcTemplate).getAmount()) {
				
				return "redloginproblem";
				
			}
			
			else   {
			
			
				WalletDAO.awardToProgram(AlluserDAO.getUserByItcode(itcode, jdbcTemplate).getUsername(), amount, pro_name, jdbcTemplate);   
			
				
				
				
		//插入数据库;
				
			
		 return "n";
			}
			
			
			
			
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			return "redloginproblem";
			
		}

	}
	
	@RequestMapping(value = "gethistory", method = RequestMethod.GET)
	public String gethistory( Model model) {
	
		List<ChatHistory> his=ChatHistoryDAO.getAll(jdbcTemplate);
		
	//	System.out.println("request get");
		
		model.addAttribute("history", his);
		
		return "reviewlist";
	}
	
	@RequestMapping(value = "getbalance", method = RequestMethod.GET)
	public String getbalan( Model model) {
	
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HttpSession session=request.getSession();
		String itcode=(String)session.getAttribute("itcode");
		
	//	System.out.println("request get");
		
		int balance=WalletDAO.getWalletByItcode(itcode, jdbcTemplate).getAmount();
		
		model.addAttribute("balance", balance);
		
		return "balanceshow";
	}
	
	
}
