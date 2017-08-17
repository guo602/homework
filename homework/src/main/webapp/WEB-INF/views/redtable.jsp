<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
<title>红包乃民之根本</title>
   <script src="js/jquery-3.2.1.min.js">
   </script>

    <script>
             var isopen;
             
    
     function set_page(){
     	    
     	    if(isopen="1"){

     	    	document.getElementById("h3titile").value="让红包来得更猛烈些吧";
                document.getElementById("getred").disabled=false;
     	    }
    		else{

    			document.getElementById("h3titile").value="不是没红包，时候还未到";
                document.getElementById("getred").disabled=true;
    }

     }
     function check_open(){

           $.ajax({   
	        	url:'check_open_ajax',   
	        	type:'get',   
	        	error:function(){   
	        		alert('error');   
	        	},   
	        	success:function(data){   
	           		 isopen="${isopen}";
	     		} 
	     	   });
        }

      function get_red(){}



        $(document).ready(function(){
    	check_open();
        

    	set_page();
                           });


    </script>
</head>

	<h3 id="h3titile">不是没红包，时候还未到</h3>
	
	<input type="button" value="查看我的红包记录">
	
	<br>
	
	<img src="img/red/redgif/timg7.gif"  alt="red" />
	
	
	
	<br>
	
	<input type="button" id="getred" value="抢红包">

</html>