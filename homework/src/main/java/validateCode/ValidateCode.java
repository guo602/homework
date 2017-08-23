package validateCode;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ValidateCode {
	
	public static List<String> ValicodePathAnswer(){
		
		System.out.println("in ValicodePathAnswer");
		File file = new File("g_pic");
		file.mkdir();
		
		
		
		
		System.out.println("="+file.getAbsolutePath());  
		
		
		
		          
		          String path=file.getAbsolutePath();
		         path=new String( path.replaceAll("g_pic", "src\\\\main\\\\webapp\\\\img\\\\gp\\\\valicode"));
		          
		         System.out.println(path);
		         
		          File gpic =new File(path);
		          gpic.mkdir();
		          
		          
		      
		      	 File fa[] = gpic.listFiles();
		          for (int i = 0; i < fa.length; i++) {
		              File fs = fa[i];
		              if (fs.isDirectory()) {
		                  System.out.println(fs.getName() + " [目录]");
		              } else {
		                  System.out.println(fs.getName());
		              }
		          }
		          
    		      Random r= new Random();
   		          int id=r.nextInt(fa.length);
   		          
   		          if(fa.length==0)		System.out.println("str null");

		          
		        
		          
		          
//		          
//		          System.out.println(fa[id].getName());
		          
		          String answer=fa[id].getName().replaceAll(".jpg", "");
		          String filepath="img/gp/valicode/"+answer+".jpg";
		          
		    
		          
		          
		          List<String> sl=new ArrayList<String>();
		          
		          sl.add(filepath);
		          
		          sl.add(answer);

		          
		         return sl; 
		          
		         
		
		
	}
	
	
	public  static void main(String args[]) {
	      
		  System.out.println("maintest");
		  
		  List<String> sl=ValicodePathAnswer();
		  
		  System.out.println(sl.get(0));
          System.out.println(sl.get(1));
		
		
	}  

}
