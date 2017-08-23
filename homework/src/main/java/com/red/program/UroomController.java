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
import org.springframework.web.bind.annotation.ResponseBody;

import com.red.program.dao.AlluserDAO;
import com.red.program.dao.BonusDAO;
import com.red.program.dao.ChatHistoryDAO;
import com.red.program.dao.DepartmentDAO;
import com.red.program.dao.LuckyMoneyDAO;
import com.red.program.dao.LuckyRecordDAO;
import com.red.program.dao.ProgramDAO;
import com.red.program.dao.TradeDAO;
import com.red.program.dao.WalletDAO;
import com.red.program.model.ChatHistory;
import com.red.program.model.Department;
import com.red.program.model.Each_program;
import com.red.program.model.LuckyRecord;
import com.red.program.model.MaopaoShow;
import com.red.program.model.Pro_bonus;
import com.red.program.model.Program;
import com.red.program.model.Wallet;

import maopaoMethod.Mmp;

@Controller
public class UroomController {
 
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Autowired  
	  HttpServletRequest request;  
	
	public static final int ROWS=7;
	
	
	@RequestMapping("n")
	public String nn(Model model) {
		return "n";
	}
	
	
	
	@RequestMapping("tixian_ajax")
	public String tixian(Model model) {
		
		
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HttpSession session=request.getSession();
		String itcode=(String)session.getAttribute("itcode");
		
		Wallet w=WalletDAO.getWalletByItcode(itcode, jdbcTemplate);
		WalletDAO.ChangeAmountByWallet(w, -(w.getAmount()), jdbcTemplate);
		
		return "n";
	}
	
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
		if(word==null)return "n";
		if( !word.equals("")) {
			
			word.replace("甘道夫", "大眼帅哥");
	
			word=new String(word.replaceAll("fuck", "注意言辞,润东爸爸在看着你！"));
			word=new String(word.replaceAll("shit", "OMG"));
			word=new String(word.replaceAll("冒泡组", "坠吼的"));

			
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
		recharge = new String(recharge.replace(".",""));
		
		int amount=Integer.parseInt(recharge);
		
		System.out.println(amount);
		
		TradeDAO.addMoneyToWallet(AlluserDAO.getUserByItcode(itcode, jdbcTemplate).getUsername(),amount,jdbcTemplate);
		
		
		
		
		
		
		return "n";
	}
	
	
	/**
	 * 返回页面的充值
	 * @param model
	 * @param recharge
	 * @return
	 */
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
			
			if(amount_s.equals("")) {
				
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
				
			};
		
			
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
				
				return "balanceNotEnough";
				
			}
			
			else   {
			
			
				WalletDAO.awardToProgram(AlluserDAO.getUserByItcode(itcode, jdbcTemplate).getUsername(), amount, pro_name, jdbcTemplate);   
				
				
				
				
		//插入数据库;
				
			
		 return "OK";
			}
			
			
			
			
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			return "redloginproblem";
			
		}

	}
	
	@SuppressWarnings("null")
	@RequestMapping(value = "gethistory", method = RequestMethod.GET)
	public String gethistory( Model model,int pagenum,int current) {
	
		List<ChatHistory> his=ChatHistoryDAO.getAll(jdbcTemplate);
		if(his.isEmpty())return "silence";
	//	System.out.println("request get");
		else {
			int amount=his.size();
	//	System.out.println(amount);
		int new_pagenum=amount/ROWS;
		if(amount%ROWS==0);
		else new_pagenum+=1;
		
		if(new_pagenum>12)new_pagenum=12;
		
	//	System.out.println(new_pagenum);
		
		List<ChatHistory> hisre=new ArrayList<ChatHistory>();
		for(int i=current*ROWS-ROWS;(i<current*ROWS&&i<his.size());i++)
		{hisre.add(his.get(i));
	//	System.out.println(hisre.get(i).getWord());
		}
	//	List<Integer> pn=null;
	//	for(int i=0;i<new_pagenum;++i)pn.add(i+1);
		model.addAttribute("history", hisre);
	//	model.addAttribute("num", pn);
	//	System.out.println("addAttribute sussecc!");

		
		return "reviewlist";}
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
		
		String balanceS=Mmp.moneyToString(balance);
		
		model.addAttribute("balance", balanceS);
		
		return "balanceshow";
	}
	
	
	@RequestMapping(value = "tohbyjl_ajax", method = RequestMethod.GET)
	public String gethbyjl_ajax( Model model) {
	
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
		
		List<MaopaoShow> mpslist=new ArrayList<MaopaoShow>();
		
		int index=1;
		for(LuckyRecord l:lucky) {
			
			if(l.getRound()>99)continue;
			else {
				MaopaoShow mps=new MaopaoShow();
				mps.setIndex(index);
				String round="第"+l.getRound()+"波";
				
				mps.setRound(round);
				mps.setRed_amount(new String(Mmp.moneyToString(l.getLucky_money())+"元"));
				mpslist.add(mps);
				index++;
		}
		}
		
		if(index==1) {return "notfound";}
		
		else model.addAttribute("maopaoshow",mpslist);
		//System.out.println(lucky.get(0).getLucky_money());
	
		return "hbyjl";
	}	
	
	
	@RequestMapping(value = "toqhbjl_ajax", method = RequestMethod.GET)
	public String getqhbjl_ajax( Model model) {
	
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("req:get_redlist_ajax round 100");
		HttpSession session=request.getSession();
		String itcode=(String)session.getAttribute("itcode");
		List<LuckyRecord> lucky=LuckyRecordDAO.getRecordByItcode(itcode, jdbcTemplate);
		
		List<MaopaoShow> mpslist=new ArrayList<MaopaoShow>();
		
		int index=1;
		for(LuckyRecord l:lucky) {
			
			if(l.getRound()<99)continue;
			else {
				MaopaoShow mps=new MaopaoShow();
				mps.setIndex(index);
				String round="第"+l.getRound()/100+"波";
				
				mps.setRound(round);
				mps.setRed_amount(new String(Mmp.moneyToString(l.getLucky_money())+"元"));
				mpslist.add(mps);
				index++;
		}
		}
		
		if(index==1) {return "notfound";}
		
		else model.addAttribute("maopaoshow",mpslist);
		//System.out.println(lucky.get(0).getLucky_money());
	
		return "hbyjl";
	}
	
	@RequestMapping(value = "jmpm_ajax_ajax", method = RequestMethod.GET)
	public String jmpm_ajax ( Model model) {
	
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("req:get_jmpm_ajax round 100");
		HttpSession session=request.getSession();
		String itcode=(String)session.getAttribute("itcode");
		
		List<Pro_bonus> bl=BonusDAO.ListBonusByOrder(jdbcTemplate) ;
		if(bl==null)return "notfound";
		List<MaopaoShow> mpslist=new ArrayList<MaopaoShow>();
		
		int index=1;
		for(Pro_bonus b:bl) {
			    System.out.println(b.getBonus());
				MaopaoShow mps=new MaopaoShow();
				mps.setIndex(index);
				String round="排名第"+index+".";
				
				mps.setRound(round);
				mps.setRed_amount(new String(Mmp.moneyToString(b.getBonus())+"元"));
				mps.setPro_name(ProgramDAO.getProgramByPid(b.getPid(), jdbcTemplate).getPro_name());
				mps.setAct_name(ProgramDAO.getProgramByPid(b.getPid(), jdbcTemplate).getPerformer());
				mps.setDept_name(DepartmentDAO.getDepartmentByDid(ProgramDAO.getProgramByPid(b.getPid(), jdbcTemplate).getDept_id(), jdbcTemplate).getDeptname());
				
				mpslist.add(mps);
				
				index++;
		
		}
		
	
		 model.addAttribute("program",mpslist);
		//System.out.println(lucky.get(0).getLucky_money());
	
		return "pro_rank";
	}
	
	@RequestMapping(value = "bmjm_ajax_ajax", method = RequestMethod.GET)
	public String bmjm_ajax ( Model model,String dept_name) {
	
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("req:get_jmpm_ajax round 100");
		HttpSession session=request.getSession();
		String itcode=(String)session.getAttribute("itcode");
		
		System.out.println("bmjm_ajax access suc");
		System.out.println(dept_name);
		
		List<Pro_bonus> bl=BonusDAO.ListBonusByOrder(jdbcTemplate) ;
		if(bl==null)return "notfound";
		List<MaopaoShow> mpslist=new ArrayList<MaopaoShow>();
		
		int index=1;
		for(Pro_bonus b:bl) {
				
					System.out.println(b.getBonus());
				MaopaoShow mps=new MaopaoShow();
				mps.setIndex(index);
				String round="全司第"+index+".";
				index++;
				
				mps.setRound(round);
				mps.setRed_amount(new String(Mmp.moneyToString(b.getBonus())+"元"));
				mps.setPro_name(ProgramDAO.getProgramByPid(b.getPid(), jdbcTemplate).getPro_name());
				mps.setAct_name(ProgramDAO.getProgramByPid(b.getPid(), jdbcTemplate).getPerformer());
				mps.setDept_name(DepartmentDAO.getDepartmentByDid(ProgramDAO.getProgramByPid(b.getPid(), jdbcTemplate).getDept_id(), jdbcTemplate).getDeptname());
				if(!DepartmentDAO.getDepartmentByDid(ProgramDAO.getProgramByPid(b.getPid(), jdbcTemplate).getDept_id(), jdbcTemplate).getDeptname().equals(dept_name))	
				    continue;
				mpslist.add(mps);
				
				
		}
		if(mpslist.isEmpty())return "notfound";
	
		 model.addAttribute("program",mpslist);
		//System.out.println(lucky.get(0).getLucky_money());
	
		return "pro_rank";
	}
	
	@RequestMapping(value = "bmpm_ajax_ajax", method = RequestMethod.GET)
	public String bmpm_ajax_ajax ( Model model ) {
		
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();return "notfound";
		}
		 
	 
		System.out.println(" 部门排名 access suc");
		 
		
		List<Department> dl=DepartmentDAO.getDepartmentOrderByBonus( jdbcTemplate) ;
		if(dl==null)return "notfound";
		List<MaopaoShow> mpslist=new ArrayList<MaopaoShow>();
		
		int index=1;
		for(Department d:dl) {
				
					System.out.println(d.getBonus());
				MaopaoShow mps=new MaopaoShow();
				mps.setIndex(index);
				
				String round="";
				if(index==1)round="最强神话";
				else if(index==2)round="天下第二";
				else if(index==3)round="探花";
				else round="Number."+index;
				
				mps.setRound(round);
				index++;
				mps.setRed_amount(new String(Mmp.moneyToString(d.getBonus())+"元"));
		 
				 
				mps.setDept_name(d.getDeptname());
				 
			 
				mpslist.add(mps);
				
				
		}
		if(mpslist.isEmpty())return "notfound";
	
		 model.addAttribute("my_dept_list",mpslist);
		System.out.println(mpslist.get(0).getDept_name());
		
		for(MaopaoShow ep:mpslist) {
			System.out.println(ep.getRound());
			System.out.println(ep.getDept_name());
			System.out.println(ep.getRed_amount());
		}
			
	
		return "dept_rank";
	}
	
	@ResponseBody
	@RequestMapping(value = "rain_listener_ajax", method = RequestMethod.GET)
	public String RainListener( Model model ) {
		
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();return "0";
		}
	 
		System.out.println(" rain_listener access suc");
		
		 String result=LuckyMoneyDAO.getRainningRoundByTotal(jdbcTemplate)+"";

		 return result;
		 
	
	
	}
	
	
}
