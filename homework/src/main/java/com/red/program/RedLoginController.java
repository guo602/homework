package com.red.program;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.red.program.dao.AlluserDAO;
import com.red.program.dao.DepartmentDAO;
import com.red.program.dao.ProgramDAO;
import com.red.program.dao.WalletDAO;
import com.red.program.model.Department;
import com.red.program.model.Each_program;
import com.red.program.model.Program;

@Controller
public class RedLoginController {

	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Autowired  
	  HttpServletRequest request;  
	
//	@RequestMapping(value = "validateuser", method = RequestMethod.GET)
//	public String validateRed(Model model) {
//		
//		try {
//			request.setCharacterEncoding("UTF-8");
//	
//			String itcode=request.getParameter("itcode");
//			String name=request.getParameter("name");
//			String verify=request.getParameter("verify");
//		    System.out.println("itcode");
//			
//			
//			if(AlluserDAO.checkUserInfo(itcode,name,jdbcTemplate) && verify.equals("1234") )
//				{WalletDAO.InitWalletByItcode(itcode, jdbcTemplate);
//				
//				return "room";
//				}
//			
//			
//			else	return "redValidateFail";
//			
//			
//			
//			
//			
//			
//		} catch (UnsupportedEncodingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			
//			return "redValidateFail";
//			
//		}
//
//	}
	
	

	@RequestMapping(value = "rlproblem", method = RequestMethod.GET)
	public String redlproblem(Model model) {
		
			return "redloginproblem";
			
	}
	
	@RequestMapping(value = "toUsersRoom", method = RequestMethod.GET)
	public String ToUsersRoom(Model model) {
		
		
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HttpSession session=request.getSession();
		if(session.getAttribute("itcode")!=null) {
			
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
		else {
		String itcode=request.getParameter("itcode");
		String name=request.getParameter("name");
		String verify=request.getParameter("verify");
	
		
		
		if(AlluserDAO.checkUserInfo(itcode,name,jdbcTemplate) && verify.equals(session.getAttribute("valicode") ) ) {
			WalletDAO.InitWalletByItcode( itcode,jdbcTemplate);
			
			session.setAttribute("itcode", itcode);
			
			
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
//			
//			
			
			
			
			
			
			return "users_room";
		}
		else return "redValidateFail";
			
	}
		}
	
	
	
	
}
