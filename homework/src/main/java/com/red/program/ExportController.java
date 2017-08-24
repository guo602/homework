package com.red.program;


import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.red.program.dao.LuckyRecordDAO;
import com.red.program.dao.TradeDAO;
import com.red.program.model.LuckyRecord;
import com.red.program.model.Trade;


import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;


@Controller
public class ExportController {
	@Autowired
	JdbcTemplate jdbcTemplate;
	@RequestMapping("exportreward")
	@ResponseBody
	public void exportreward(Model model, HttpServletResponse response){

		SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
		response.setHeader("content-disposition", "attachment;filename=reward"+date.format(new Date()).toString()+".xlsx"); 

		try {
               WritableWorkbook wwb = null;
               
               wwb = Workbook.createWorkbook(response.getOutputStream());

               // 创建工作表
               WritableSheet ws = wwb.createSheet("Test Shee 1", 0);
               
               //查询数据库中所有的数据
               List<Trade> list= TradeDAO.getAllReward(jdbcTemplate);
               //要插入到的Excel表格的行号，默认从0开始
               Label labelTId= new Label(0, 0, "编号(tid)");//表示第
               Label labelWid= new Label(1, 0, "账户(wid)");
               Label labelVolumn= new Label(2, 0, "金额(volumn)");
               Label labelTime= new Label(3, 0, "时间(tradetime)");
               Label labelMemo= new Label(4, 0, "备注(memo)");
               
               ws.addCell(labelTId);
               ws.addCell(labelWid);
               ws.addCell(labelVolumn);
               ws.addCell(labelTime);
               ws.addCell(labelMemo);
               for (int i = 0; i < list.size(); i++) {
                   
                   Label labelPId_i= new Label(0, i+1, list.get(i).getTid()+"");
                   Label labelWid_i= new Label(1, i+1, list.get(i).getWid()+"");
                   Label labelVol_i= new Label(2, i+1, list.get(i).getVolumn()+"");
                   Label labelTime_i= new Label(3, i+1, list.get(i).getTradetime());
                   Label labelMemo_i= new Label(4, i+1, list.get(i).getMemo());
                   ws.addCell(labelPId_i);
                   ws.addCell(labelWid_i);
                   ws.addCell(labelVol_i);
                   ws.addCell(labelTime_i);
                   ws.addCell(labelMemo_i);
               }
             
              //写进文档
               wwb.write();
              // 关闭Excel工作簿对象
               wwb.close();

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
         
        } 
	}
	@RequestMapping("exportrecharge")
	@ResponseBody
	public void exportrecharge(Model model, HttpServletResponse response){

		SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
		response.setHeader("content-disposition", "attachment;filename=recharge"+date.format(new Date()).toString()+".xlsx"); 

		try {
               WritableWorkbook wwb = null;
               
               wwb = Workbook.createWorkbook(response.getOutputStream());

               // 创建工作表
               WritableSheet ws = wwb.createSheet("Test Shee 1", 0);
               
               //查询数据库中所有的数据
               List<Trade> list= TradeDAO.getAllRecharge(jdbcTemplate);
               //要插入到的Excel表格的行号，默认从0开始
               Label labelTId= new Label(0, 0, "编号(tid)");//表示第
               Label labelWid= new Label(1, 0, "账户(wid)");
               Label labelVolumn= new Label(2, 0, "金额(volumn)");
               Label labelTime= new Label(3, 0, "时间(tradetime)");
               Label labelMemo= new Label(4, 0, "备注(memo)");
               
               ws.addCell(labelTId);
               ws.addCell(labelWid);
               ws.addCell(labelVolumn);
               ws.addCell(labelTime);
               ws.addCell(labelMemo);
               for (int i = 0; i < list.size(); i++) {
                   
                   Label labelPId_i= new Label(0, i+1, list.get(i).getTid()+"");
                   Label labelWid_i= new Label(1, i+1, list.get(i).getWid()+"");
                   Label labelVol_i= new Label(2, i+1, list.get(i).getVolumn()+"");
                   Label labelTime_i= new Label(3, i+1, list.get(i).getTradetime());
                   Label labelMemo_i= new Label(4, i+1, list.get(i).getMemo());
                   ws.addCell(labelPId_i);
                   ws.addCell(labelWid_i);
                   ws.addCell(labelVol_i);
                   ws.addCell(labelTime_i);
                   ws.addCell(labelMemo_i);
               }
             
              //写进文档
               wwb.write();
              // 关闭Excel工作簿对象
               wwb.close();

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
         
        } 
	}

	@RequestMapping("exportlucky")
	@ResponseBody
	public void exportlucky(Model model, HttpServletResponse response){
		 SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
		response.setHeader("content-disposition", "attachment;filename=lucky"+date.format(new Date()).toString()+".xlsx"); 

		try {
               WritableWorkbook wwb = null;

               
               wwb = Workbook.createWorkbook(response.getOutputStream());

               // 创建工作表
               WritableSheet ws = wwb.createSheet("Test Shee 1", 0);
               
               //查询数据库中所有的数据
               List<LuckyRecord> list= LuckyRecordDAO.getAll(jdbcTemplate);
               //要插入到的Excel表格的行号，默认从0开始
               Label labelRId= new Label(0, 0, "编号(rid)");//表示第
               Label labelWid= new Label(1, 0, "账户(wid)");
               Label labelMoney= new Label(2, 0, "金额(money)");
               Label labelTimes= new Label(3, 0, "轮次(times)");
              
               ws.addCell(labelRId);
               ws.addCell(labelWid);
               ws.addCell(labelMoney);
               ws.addCell(labelTimes);
 
               for (int i = 0; i < list.size(); i++) {
                   
                   Label labelRId_i= new Label(0, i+1, list.get(i).getRid()+"");
                   Label labelWid_i= new Label(1, i+1, list.get(i).getWid()+"");
                   Label labelMon_i= new Label(2, i+1, list.get(i).getLucky_money()+"");
                   Label labelTimes_i= new Label(3, i+1, list.get(i).getRound()+"");
                   ws.addCell(labelRId_i);
                   ws.addCell(labelWid_i);
                   ws.addCell(labelMon_i);
                   ws.addCell(labelTimes_i);
               }
             
              //写进文档
               wwb.write();
              // 关闭Excel工作簿对象
               wwb.close();
//              result="导出成功，保存路径"+fileName;
//              sign="yes";
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();

        } 


	}
}
