<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
<title>红包乃民之根本</title>
   <script src="js/jquery-3.2.1.min.js">
   </script>

    <script>
             var isopen;
    
    function clickon_redlist(){

             get_redlist();              

    }

    function click_on_get(){
            var randomNum = Math.random()*5*1000;
            setTimeout(get_red(),randomNum);

    }
     function set_page(){
     	    
     	    if(isopen==1){

     	    	document.getElementById("h3titile").innerText="让红包来得更猛烈些吧";
                document.getElementById("getred").disabled=false;
     	    }
    		else{

    			document.getElementById("h3titile").innerText="不是没红包，时候还未到";
                document.getElementById("getred").disabled=true;
    }
    }

     

     function get_redlist(){

         $.ajax({   
	        	url:'get_redlist_ajax',   
	        	type:'get', 
	        	dataType:'html',     
	        	error:function(){   
	        		alert('error');   
	        	},   
	        	success:function(data){   
	           		 $("#getlist").html(data); 
	     		} 
	     	   });

     }
     function check_open(){

           $.ajax({   
	        	url:'check_open_ajax',   
	        	type:'get',
	        	dataType:'html',      
	        	error:function(){   
	        		alert('error');   
	        	},   
	        	success:function(data){   
	           		 isopen=data;
	           		// alert(isopen);
	           		 set_page();
	     		} 
	     	   });
        }

      function get_red(){

      	 $.ajax({   
	        	url:'get_red_ajax',   
	        	type:'get', 
	        	dataType:'html',     
	        	error:function(){   
	        		alert('error');   
	        	},   
	        	success:function(data){   
	           		 $("#getmsg").html(data); 
	     		} 
	     	   });
      }



        $(document).ready(function(){
    	check_open();
    	
                           });


    </script>
</head>

	<h3 id="h3titile">雷谋</h3>
	
	<input type="button" value="查看我的红包记录" onclick="clickon_redlist()">
	
	<br>
	
	<img src="img/red/redgif/timg7.gif"  alt="red" />
	
	
	
	<br>
	
	<input type="button" id="getred" value="抢红包" onclick="click_on_get()">
    <p id="getmsg"></p>


</html>