package jdbcInitialize;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import com.red.program.model.ChatHistory;
import com.red.program.model.Program;

public class InitializeDAO
{
	public static void Initial(JdbcTemplate jdbcTemplate)
	{
		
		jdbcTemplate.update("delete from admin_user");
		jdbcTemplate.update("delete from all_user");
		jdbcTemplate.update("delete from chat_history");
		jdbcTemplate.update("delete from chat_info");
		jdbcTemplate.update("delete from department");
		jdbcTemplate.update("delete from lucky_money");
		jdbcTemplate.update("delete from lucky_record");
		jdbcTemplate.update("delete from pro_bonus");
		jdbcTemplate.update("delete from program");
		jdbcTemplate.update("delete from redpacket");
		jdbcTemplate.update("delete from trade");
		jdbcTemplate.update("delete from wallet");
		jdbcTemplate.update("delete from user_words_state");
		jdbcTemplate.update("delete from history_state");
		
		
		jdbcTemplate.update("insert into admin_user  values(null,'00001','路人甲','4QrcOUm6Wau+VuBX8g+IPg==')");
		jdbcTemplate.update("insert into all_user  values(null,'12121','Bill')");
		jdbcTemplate.update("insert into all_user  values(null,'2333','zheng')");
		jdbcTemplate.update("insert into all_user  values(null,'6666','chen')");
		jdbcTemplate.update("insert into all_user  values(null,'0209','g')");
		jdbcTemplate.update("insert into all_user  values(null,'00002','a')");
		jdbcTemplate.update("insert into all_user  values(null,'00003','b')");
		jdbcTemplate.update("insert into all_user  values(null,'00004','c')");
		jdbcTemplate.update("insert into all_user  values(null,'00005','d')");
		jdbcTemplate.update("insert into all_user  values(null,'00006','e')");
		jdbcTemplate.update("insert into all_user  values(null,'00007','f')");
		jdbcTemplate.update("insert into all_user  values(null,'00008','h')");
		jdbcTemplate.update("insert into all_user  values(null,'00009','i')");
		jdbcTemplate.update("insert into all_user  values(null,'00010','j')");
		jdbcTemplate.update("insert into department values(1,'天气播报部',0)");
		jdbcTemplate.update("insert into department values(2,'市场部',0)");
		jdbcTemplate.update("insert into department values(3,'技术部',0)");
		jdbcTemplate.update("insert into department values(4,'人力资源部',0)");
		jdbcTemplate.update("insert into department values(5,'公关部',0)");
		jdbcTemplate.update("insert into program values(null,'炮哥','风云进行时','2017-08-08 19:00:00',1)");
		jdbcTemplate.update("insert into program values(null,'角哥','祈雨','2017-08-08 19:10:00',1)");
		jdbcTemplate.update("insert into program values(null,'市场小组','保卫黄河','2017-08-08 19:20:00',2)");
		jdbcTemplate.update("insert into program values(null,'Tomcat','口吐莲花','2017-08-08 19:30:00',2)");
		jdbcTemplate.update("insert into program values(null,'老蒋','谈笑风生','2017-08-08 19:40:00',2)");
		jdbcTemplate.update("insert into program values(null,'甘道夫','乌鸦坐飞机','2017-08-08 19:50:00',3)");
		jdbcTemplate.update("insert into program values(null,'世博','护理润东','2017-08-08 20:00:00',3)");
		jdbcTemplate.update("insert into program values(null,'小雪','Jar of love','2017-08-08 20:10:00',4)");
		jdbcTemplate.update("insert into program values(null,'小雪','小幸运','2017-08-08 20:20:00',4)");
		jdbcTemplate.update("insert into program values(null,'老于','相声','2017-08-08 20:30:00',5)");
		jdbcTemplate.update("insert into program values(null,'老马','逗你玩','2017-08-08 20:40:00',5)");
		jdbcTemplate.update("insert into program values(null,'小李','大石碎胸口','2017-08-08 20:50:00',5)");
		jdbcTemplate.update("insert into redpacket values(100,20000,0,10);");

		jdbcTemplate.update("insert into redpacket values(200,20000,0,10);");

		jdbcTemplate.update("insert into redpacket values(300,20000,0,10);");
        
		RowMapper<Program> program_mapper = new BeanPropertyRowMapper<Program>(Program.class);
		List<Program> program = jdbcTemplate.query("select * from program",program_mapper);
		program.get(0).getPid();
		jdbcTemplate.update("insert into pro_bonus values(?,0)",program.get(0).getPid());
		jdbcTemplate.update("insert into pro_bonus values(?,0);",program.get(1).getPid());
		jdbcTemplate.update("insert into pro_bonus values(?,0);",program.get(2).getPid());
		jdbcTemplate.update("insert into pro_bonus values(?,0);",program.get(3).getPid());
		jdbcTemplate.update("insert into pro_bonus values(?,0);",program.get(4).getPid());
		jdbcTemplate.update("insert into pro_bonus values(?,0);",program.get(5).getPid());
		jdbcTemplate.update("insert into pro_bonus values(?,0);",program.get(6).getPid());
		jdbcTemplate.update("insert into pro_bonus values(?,0);",program.get(7).getPid());
		jdbcTemplate.update("insert into pro_bonus values(?,0);",program.get(8).getPid());
		jdbcTemplate.update("insert into pro_bonus values(?,0);",program.get(9).getPid());
		jdbcTemplate.update("insert into pro_bonus values(?,0);",program.get(10).getPid());
		jdbcTemplate.update("insert into pro_bonus values(?,0);",program.get(11).getPid());

		jdbcTemplate.update("insert into lucky_money values(null,1,8000)");
		jdbcTemplate.update("insert into lucky_money values(null,2,8000)");
		jdbcTemplate.update("insert into lucky_money values(null,3,8000)");
		jdbcTemplate.update("insert into lucky_money values(null,4,8000)");
		jdbcTemplate.update("insert into lucky_money values(null,5,8000)");

	}
}