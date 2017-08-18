<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head> 
	<title>帅郭们滴room</title>
    <script src="js/jquery-3.2.1.min.js">
   </script>
    <script>
        function Editsubmit(){
                
                var e= document.getElementById('words').value;
                document.getElementById('words').value="";
               get_edit(e);

        }

        function rechargesubmit(){
                
               var e= document.getElementById('formre').value;
                
               get_recharge(e);

        }
        function rewardsubmit(){
                
               var e1= document.getElementById('rewardamount').value;
               var e1= document.getElementById('pro_name').value;
                document.getElementById('rewardamount').value="";
               send_reward(e1,e2);

        }
        
        
         function send_reward(e1,e2){

           $.ajax({   
	        	url:'reward_ajax',   
	        	type:'get',   
	         	dataType:'html',   
	            data: {"reward":e1,"pro_name":e2},  
	        	error:function(){   
	        		alert('error');   
	        	},   
	        	success:function(data){   
	           		 alert('打赏成功');
	     		} 
	     	   });
	     	

        }

        function get_recharge(e){

           $.ajax({   
	        	url:'recharge_ajax',   
	        	type:'get',   
	         	dataType:'html',   
	            data: {"recharge":e},  
	        	error:function(){   
	        		alert('error');   
	        	},   
	        	success:function(data){   
	           		 alert('充值成功');
	     		} 
	     	   });
	     	

        }

        function get_edit(e){

           $.ajax({   
	        	url:'up_words_ajax',   
	        	type:'get',   
	         	dataType:'html',   
	            data: {"word":e},  
	        	error:function(){   
	        		alert('error');   
	        	},   
	        	success:function(data){   
	           		
	     		} 
	     	   });
	     	

        }



        function show_balance(){

           $.ajax({   
	        	url:'getbalance',   
	        	type:'get',   
	         	dataType:'html',   
	     
	        	error:function(){   
	        		alert('error');   
	        	},   
	        	success:function(data){   
	           		$("#balance").html(data);   
	     		} 
	     	   });
	     	setTimeout(show_balance,2048);

        }

        function refresh_content()  {
	        $.ajax({   
	        	url:'gethistory',   
	        	type:'get',   
	         	  
	     
	        	error:function(){   
	        		alert('error');   
	        	},   
	        	success:function(data){   
	           		$("#talkdiv").html(data);   
	     		} 
	     	});
	     	setTimeout(refresh_content,3000);
    }

    $(document).ready(function(){
    	refresh_content();
    	show_balance();
    });

/*

         $(document).ready(function(){
	   $("button").click(function(){
		$.ajax({url:"url",success:function(result){
			$("#div1").html(result);
		}});
	       });
           });
         */
      </script>

</head>
<body>
  <div>
  	充值  抢红包    <input  type="button" value="抢红包" onclick="window.open('redtable')">     
            <input type="button" name="sub" id="sub" value="想充值" onclick="window.open('recharge')" >
             <br>

             <form name="formre"  action="rechargemoney" >
			
		
		          	<select name="howmuch"  ID="formre"> 
                      <option value="0.99">0.99￥</option>
                      <option value="6.66">6.66￥</option> 
                      <option value="66.60">66.60￥</option> 
                      <option value="666.00">666.00￥</option> 
                      <option value="6666.66">6666.66￥</option> 
                    </select>    
			 
			 
			<input type="button" name="recsub" id="recsub" value="充值就现在" onclick="submit()">
		</form>

		<br>  <strong ID="balance"></strong>   <input  type="button" value="提现" >  

  </div>
  <div>
  	节目单
  	<br>
          <table  border=1>
          <tbody>
          <c:forEach items="${pro}" var="ep">
                                
                <tr>
<form name="${ep.getPro_name()}" action="rewards">
					<td>${ep.getPro_name()}</td>
					<td>${ep.getPerformer()}</td>
					<td>${ep.getDept()}</td>
					
					
					<td><input type="hidden" name="pro_name" ID="pro_name" value="${ep.getPro_name()}"></td>
					<td><input  type="button" value="我想打赏" ></td>
						<td><input name="rewardamount"  ID="rewardamount"></td>
							
					<td><input  type="button" value="立即打赏" onclick="submit()"></td>
					<td><input  type="button" value="再看下" ></td>
						</form>
					</tr>

          </c:forEach>
          </tbody>
     </table>
  </div>

  <div>
  	 评论
        <div ID="talkdiv">
        
        </div>


  </div>

  <div>
  	吐槽

		<form name="form1" action="up_words_ajax?word='document.getelementbyid(words)'" >
			
		
			<input type="text" name="words" id="words"  >  
			 
			 
			<input type="button" name="sub" id="sub" value="发送" onclick="Editsubmit()">
		</from>
	


  </div>





</body>
</html>
