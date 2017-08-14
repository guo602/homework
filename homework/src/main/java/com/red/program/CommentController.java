package com.red.program;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.red.program.dao.AdminCommentDAO;
import com.red.program.dao.ChatInfoDAO;
import com.red.program.model.ChatHistory;

/**
 * 管理员评论管理区
 * 
 * @author lenovo
 *
 */
@Controller
public class CommentController {
	@Autowired
	JdbcTemplate jdbcTemplate;

	/**
	 * 查找指定历史记录列表
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("findlist")
	public String findlist(String itcode, String keyword,
			               String beghour, String begmin, 
			               String endhour, String endmin,
			               String number, Model model) {
		String result=new String();
		List<ChatHistory> chat;
		int num=Integer.parseInt(number);
		String begtime="2017-08-08 "+beghour+":"+begmin+":00";
		String endtime="2017-08-08 "+endhour+":"+endmin+":00";
		System.out.println("itcode"+itcode);
		System.out.println("keyword"+keyword);
		System.out.println("begtime"+begtime);
		System.out.println("endtime"+endtime);
		System.out.println("number"+number);
	
		if(itcode!="") {
			if(keyword!="") {
				if(num!=0) {
					System.out.println("error1");
				    chat=AdminCommentDAO.getAll(itcode, keyword, begtime, endtime, num, jdbcTemplate);
				}
				else {
					System.out.println("error2");
					chat=AdminCommentDAO.getWithoutNumber(itcode, keyword, begtime, endtime, jdbcTemplate);
				}
			}
			else {
				if(num!=0) {
					System.out.println("error3");
					chat=AdminCommentDAO.getWithoutKey(itcode, begtime, endtime, num, jdbcTemplate);
				}
				else {
					System.out.println("error4");
					chat=AdminCommentDAO.getByIt(itcode, begtime, endtime, jdbcTemplate);
				}
			}
		}
		else {
			if(keyword!="") {
				if(num!=0) {
					System.out.println("error5");
				    chat=AdminCommentDAO.getWithoutIt(keyword, begtime, endtime, num, jdbcTemplate);
				}
				else {
					System.out.println("error6");
					chat=AdminCommentDAO.getByKey(keyword, begtime, endtime,jdbcTemplate);
				}
			}
			else {
				if(num!=0) {
					System.out.println("error7");
					chat=AdminCommentDAO.getByNumber(begtime, endtime, num, jdbcTemplate);
				}
				else {
					System.out.println("error8");
					chat=AdminCommentDAO.getWithout(begtime, endtime, jdbcTemplate);
				}
			}
		}
		if(chat!=null) {
			if(chat.size()!=0) {
			    result="查询成功";
			}
			else {
				result="当前条件下无记录";
			}
		}
		else {
			result="查询失败";
		}
		model.addAttribute("result", result);
		model.addAttribute("list", chat);
		return "commentbyadmin";
	}

	/**
	 * 禁言指定用户
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("lock_delete")
	public String lockuser(String lock[],String delete[],Model model) {
		List<ChatHistory> chat;
        chat=AdminCommentDAO.getLatest(jdbcTemplate);
        String result=new String();
	    int lnum=lock.length;
	    int dnum=delete.length;
	    String jlock="";
	    String jdelete="";
	    if(lnum==0&&dnum==0) {
	    	result="未选择需要禁言的用户或需要删除的历史记录";
	    }
	    else {
	    	int k=0;
	    	if(lnum!=0) {
	    		for(int i=0;i<lnum;i++) {
	    			k=ChatInfoDAO.lockUserById(Integer.parseInt(lock[i]), jdbcTemplate);
	    			if(k==-1) {
	    				jlock=lock[i]+"号,";
	    			}
	    		}
	    	}
	    	if(dnum!=0) {
	    		for(int i=0;i<dnum;i++) {
	    			k=AdminCommentDAO.AdminDelete(Integer.parseInt(delete[i]), jdbcTemplate);
	    			if(k==-1) {
	    				jdelete=delete[i]+"号,";
	    			}
	    		}
	    	}	
	    }
	    if(jlock==""&&jdelete=="") {
	    	result="成功删除历史记录或禁言用户";
	    	model.addAttribute("result1", result);
	    }
	    else {
	    	model.addAttribute("result1", jlock+"禁言失败；"+jdelete+"删除失败");
	    }
		model.addAttribute("list", chat);
		return "commentbyadmin";
	}
}
