
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset="UTF-8">
	<title>帅郭们滴room</title>

	<meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <script src="js/jquery-3.2.1.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <link href="css/bootstrap-grid.scss" rel="stylesheet">
	

   
	
	<link rel="stylesheet" type="text/css" href="css/users_room.css">


<!-- 	    <script src="js/redrain.js" ></script> -->

    <script type="text/javascript">
     	
     	var pagenum=1;
     	var current=1;
     	var isopen;
        var pro_name;
        // var ubalance;
        var reward_money_amount;
        var dept_name;
        var isRainning=0;
        var droppacketstimer;
     </script>
	
<script>
    	

function stoprain(){

  clearInterval(droppacketstimer);

}
function rain(){

  droppacketstimer=setInterval(function(){
      dropmoney()
    }, 177);
	
	setTimeout(stoprain,1000*4);
}

function disappear(){
$(this).remove();
 
}

function dropmoney(){
  var win_width = $(window).width();
  for(var i = 0;i<17;i++){
    var j = parseInt(Math.random()*win_width);
    var j0 = parseInt(Math.random()*(win_width/2) - (win_width/4));
    var n = parseInt(Math.random()*1000+(-1000));
     var s0 = parseInt(Math.random()*$(window).height()/2);
     var sX = parseInt((Math.random()-0.5)*$(window).height()*0.9);
    var h = parseInt(Math.random()*50+40);
    $('body').prepend('<div class="redmoney"><img   src="img/red/redgif/time1.gif"></div>');
    $('body').children('div').eq(0).css({'left':j,'top':n});
    $('body').children('div').children('img').eq(0).css({'width':h+'%','height':'auto'});
    if(1){
      $('body').children('div').eq(0).animate({'left':j+j0,'top':s0+sX,'width':'15%'},3000+parseInt(Math.random()*3000),function(){$(this).remove();});
  
    } else {
      
    }
  }
}
     </script>
<script>
    	
		function on_search_dept_jm(){
    			dept_name= document.getElementById('select_dept').value;
    			bmjm_ajax();

    	}
     

		function reward_check(){
			
				jmpm_ajax();
				var rewardInput=document.getElementById("reward_input").value;
				var re = new RegExp(/^[0-9]*\.[0-9]{2}$/);
				if (rewardInput=="")
					{
                         var randomText = Math.random()*8;
                         if(randomText>1)
						document.getElementById("reward_input_checkMsg").innerText="猜不出您心里的那个数字";
					else document.getElementById("reward_input_checkMsg").innerText="你这个样子是不行的"
				}

				else if(!re.test(rewardInput)){document.getElementById("reward_input_checkMsg").innerText="钱之格式应形如 0.01 ,78.90";}
                else reward_true();
			// if()reward_true();
			// else ;
		}
		function reward_true(){
			document.getElementById("reward_input_checkMsg").innerText="";
			alert('O Yes baby 打赏！强！消费！就是这种感觉');
			$('#dsmtk').modal('hide');

			send_reward(document.getElementById("reward_input").value, pro_name);

			//ajax

			//重sort节目
			jmpm_ajax();
			
			bmpm_ajax();
			bmjm_ajax();

		}
        function changepro_name(e){
        		pro_name=e;
        		// alert(pro_name);
        		// var tblArr=document.getElementById("dstitle").innerText;
        		document.getElementById("dstitle").innerText=e;
        		document.getElementById("reward_input").value="";
        		document.getElementById("reward_input_checkMsg").innerText="";

        }
        function rob_dis_app(){

        	
                    check_open();

        			if($("#rob").is(":hidden")){ $("#rob").slideDown();
					  			}else{
					  				$("#rob").slideUp();
					  			}
					 if($("#beStronger").is(":hidden")){ 
					  			}else{
					  				$("#beStronger").slideUp();
					  			}
					  		}
        
		function walletopchange(obj) {

			var div = document.getElementById("walletchoice");

			if (obj.value == "隐藏") {
				div.style.display = "none";
				obj.value = "显示";
			} else {
				div.style.display = "block";
				obj.value = "隐藏";
			}

		}

		function Editsubmit() {

			var e = document.getElementById('words').value;
			document.getElementById('words').value = "";
			get_edit(e);

		}

		function rechargesubmit() {

			var e = document.getElementById('formre').value;

			get_recharge(e);

		}
		function rewardsubmit() {

			var e1 = document.getElementById('rewardamount').value;
			var e1 = pro_name;
			document.getElementById('rewardamount').value = "";
			send_reward(e1, pro_name);

		}

		function send_reward(e1, e2) {

			$.ajax({
				url : 'reward_ajax',
				type : 'get',
				dataType : 'html',
				data : {
					"reward" : e1,
					"pro_name" : e2
				},
				error : function() {
					alert('error');
				},
				success : function(data) {
					if(data==1){alert('打赏成功');jmpm_ajax();bmjm_ajax();}
					else alert('可惜余额不足，空欢喜');
				}
			});

		}

		function get_recharge(e) {

			$.ajax({
				url : 'recharge_ajax',
				type : 'get',
				dataType : 'html',
				data : {
					"recharge" : e
				},
				error : function() {
					alert('error');
				},
				success : function(data) {
					alert('成功充值'+e+'元，再会！');
				}
			});

		}

		function get_edit(e) {

			$.ajax({
				url : 'up_words_ajax',
				type : 'get',
				dataType : 'html',
				data : {
					"word" : e
				},
				error : function() {
					alert('error');
				},
				success : function(data) {

				}
			});

		}

		function show_balance() {

			$.ajax({
				url : 'getbalance',
				type : 'get',
				dataType : 'html',

				error : function() {
					alert('error');
				},
				success : function(data) {
					$("#balance").html(data);
					// ubalance=data;
				}
			});
			setTimeout(show_balance, 2048);

		}


		function tixianajax() {

			$.ajax({
				url : 'tixian_ajax',
				type : 'get',
				dataType : 'html',

				error : function() {
					alert('error');
				},
				success : function(data) {
					alert('tixian success');
				}
			});
			

		}

		function hbyjl_ajax(){
			$.ajax({
				url : 'tohbyjl_ajax',
				type : 'get',
				dataType : 'html',

				error : function() {
					alert('error');
				},
				success : function(data) {
					$("#getlist").html(data);
				}
			});

		}

		function qhbjl_ajax(){
			$.ajax({
				url : 'toqhbjl_ajax',
				type : 'get',
				dataType : 'html',

				error : function() {
					alert('error');
				},
				success : function(data) {
					$("#getqlist").html(data);
				}
			});

		}

		function refresh_content() {
			$.ajax({
				url : 'gethistory',
				type : 'get',
				dataType : 'html',
                data:{
					  "pagenum":pagenum,
     	            "current":current
                      
				},
				error : function() {
					alert('error');
				},
				success : function(data) {
					$("#talkdiv").html(data);
				}
			});
			setTimeout(refresh_content, 3000);
		}

		function paytellchange(){
            var charge_a=document.getElementById('formre').value;
            var charge_b="待支付"+charge_a+"元，请输入密码";
			if(document.getElementById('paytell').innerText=="请选择支付方式")
				{document.getElementById('paytell').innerText=charge_b;}
			else{document.getElementById('paytell').innerText="请选择支付方式";}
		}

</script>
	
<script type="text/javascript">
	    $(document).ready(function() {
	    	refresh_content(pagenum,current);
	    	show_balance();
	    	check_open();
	    	rain_listener_ajax();

	    });
</script>
	




 <script type="application/javascript">

     //        $('body').off('.data-api');
     //        $('body').off('.alert.data-api');
     //        $(".btn.danger").button("toggle").addClass("fat");
     //        $("#myModal").modal()                       // initialized with defaults
     //    $("#myModal").modal({ keyboard: false ;})   // initialized with no keyboard
     //  $("#myModal").modal('show') ;               // initializes and invokes show immediately
			  	  // var jq = jQuery.noConflict();
			  	  // var bootstrapButton = $.fn.button.noConflict() // return $.fn.button to previously assigned value
     //                  $.fn.bootstrapBtn = bootstrapButton            // give $().bootstrapBtn the bootstrap functionality
     //               $('#myModal').on('show', function (e) {
     // if (!data) return e.preventDefault() // stops modal from being shown
     //           });


			  	  $(document).ready(function () {


				  		$("#dropdownMenu1").click(function () {


				  			if($("#walletchoice").is(":hidden")){
				  				$("#walletchoice").slideDown();
				  			}else{
				  				$("#walletchoice").slideUp();
				  			}

				  			if($("#myBalance").is(":hidden")){
				  				$("#myBalance").slideDown();
				  			}else{
				  				$("#myBalance").slideUp();
				  			}

				  			if($("#beStronger").is(":hidden")){}
				  				else{
				  					$("#beStronger").slideUp();
				  				}

				  			if($("#rob").is(":hidden")){
				  			}else{
				  				$("#rob").slideUp();
				  			}

				  			});


				  		$("#clickrecharge").click(function () {
				  			if($("#beStronger").is(":hidden")){
				  				$("#beStronger").slideDown(50);
				  			}else{
				  				$("#beStronger").slideUp();
				  			}


    			            if($("#rob").is(":hidden")){
				  			}else{
				  				$("#rob").slideUp();
				  			}
				  		});

                          
                         
				  		$(".g_cbtn").click(function () {


				  			if($("#td1").is(":hidden")){
				  				$("#td1").slideDown();
				  			}else{
				  				$("#td1").slideUp();
				  			}

				  			if($("#talkdiv").is(":hidden")){
				  				$("#talkdiv").slideDown();
				  			}else{
				  				$("#talkdiv").slideUp();
				  			}

				  			

				  			});


				  		$("#paypic1").click(function () {
				  			  if($("#afterclickpic").is(":hidden")){
				  				$("#paypic2d").slideUp();
				  				$("#paypic3d").slideUp();
				  				$("#paypic4d").slideUp();
				  				 if($("#afterclickpic").is(":hidden")); $("#afterclickpic").slideDown();
				  				}
				  			   else{
				  			 	$("#paypic2d").slideDown();
				  				$("#paypic3d").slideDown();
				  				$("#paypic4d").slideDown();
				  				if($("#afterclickpic").is(":hidden"));
				  				else $("#afterclickpic").slideUp();}
				  			paytellchange();
				  		});


				  		$("#paypic2").click(function () {
				  		  if($("#afterclickpic").is(":hidden")){
				  				$("#paypic3d").slideUp();
				  				$("#paypic1d").slideUp();
				  				$("#paypic4d").slideUp();
				  				 $("#afterclickpic").slideDown();
				  				}

				  			  
				  			   else{$("#paypic3d").slideDown();
				  				$("#paypic1d").slideDown();
				  				$("#paypic4d").slideDown();
				  				 $("#afterclickpic").slideUp();}
				  			paytellchange();
				  		});


				  		$("#paypic3").click(function () {
				  			  if($("#afterclickpic").is(":hidden")){
				  				$("#paypic2d").slideUp();
				  				$("#paypic1d").slideUp();
				  				$("#paypic4d").slideUp();
				  				 $("#afterclickpic").slideDown();
				  				}

				  			  
				  			   else{$("#paypic2d").slideDown();
				  				$("#paypic1d").slideDown();
				  				$("#paypic4d").slideDown();
				  				 $("#afterclickpic").slideUp();}
				  			paytellchange();
				  		});


				  		$("#paypic4").click(function () {
				  			  if($("#afterclickpic").is(":hidden")){
				  				$("#paypic2d").slideUp();
				  				$("#paypic1d").slideUp();
				  				$("#paypic3d").slideUp();
				  				 $("#afterclickpic").slideDown();
				  				}

				  			  
				  			   else{$("#paypic2d").slideDown();
				  				$("#paypic1d").slideDown();
				  				$("#paypic3d").slideDown();
				  				 $("#afterclickpic").slideUp();}
				  			paytellchange();
				  		});


                        $("#shopping").click(function () {
				  			
				  				$("#fourpic").slideDown(1);
				  				$("#paypic1").slideDown(1);
				  				$("#paypic2").slideDown(1);
				  				$("#paypic3").slideDown(1);
				  				$("#paypic4").slideDown(1);
				  			
				  			$("#afterclickpic").slideUp(1);

				  			{$("#paypic3d").slideDown();
				  				$("#paypic1d").slideDown();
				  				$("#paypic4d").slideDown();
				  					$("#paypic2d").slideDown();}

                             if(document.getElementById('paytell').innerText!="请选择支付方式")
				  			 paytellchange();

				  		});


				  		//记录显示
				  		    $("#hbyj").click(function () {
				  			
				  				//ajax action

				  				hbyjl_ajax();

				  			});
				  		    $("#qhbj").click(function () {
				  			
				  				//ajax action

				  				qhbjl_ajax();

				  			});

				  			$("#bmpm").click(function () {
				  			
				  				//ajax action

				  				
				  				

				  				bmpm_ajax();

				  			});

				  			$("#jmpm").click(function () {
				  			
				  				//ajax action

				  				
				  				jmpm_ajax();

				  			});

				  			$("#searchDept").click(function () {
				  				dept_name=$("#select_dept").val();
				  				bmjm_ajax();


				  			});

				  			// querySelectorAll("#dsbtn").click(function () {
				  			
				  			// 	//ajax action
      //                           alert(this.val());


				  			// });



				  			

                            



			  	  });





										   $(function () { $('#myModal').modal('hide')});
										</script>
										<script>
										   // $(function () { $('#myModal').on('hide.bs.modal', function () {
										   //    alert('嘿，我听说您喜欢模态框...');})
										   // });
									



 </script>
     
     



<script type="text/javascript">
	
	function checkpw(){

		if($('#paypw').val()!=""){rechargesubmit();
		$('#myModal').modal('hide');}

		else alert('输入不能为空，帅郭');
	}
</script>


   <!-- 抢红包的API -->
<script type="text/javascript">
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
                document.getElementById("pandagif").style.display= "block";
                document.getElementById("getred").value="红包拿来";
                document.getElementById("getred").style.display= "block";
     	    }
    		else{
    			document.getElementById("h3titile").innerText="不是没红包，时候还未到";
    			document.getElementById("pandagif").style.display = "none" ;
                document.getElementById("getred").disabled=true;
                document.getElementById("getred").style.display = "none" ;
            }
    			
    		document.getElementById("getmsg").value="";
    
    					}
	
     // function get_redlist(){

     //     $.ajax({   
	    //     	url:'get_redlist_ajax',   
	    //     	type:'get', 
	    //     	dataType:'html',     
	    //     	error:function(){   
	    //     		alert('error');   
	    //     	},   
	    //     	success:function(data){   
	    //        		 $("#getlist").html(data); 
	    //  		} 
	    //  	   });

     // }
    function rain_listener_ajax(){
    			$.ajax({   
	        	url:'rain_listener_ajax',   
	        	type:'get',
	        	dataType:'html',      
	        	error:function(){   
	        		alert('error');   
	        	},   
	        	success:function(data){   
	           		if(isRainning!=data){
	           				rain();
	           		}

	           		isRainning=data;

	     		} 
	     	   });

    			setTimeout(rain_listener_ajax,1000);

    }

     function bmpm_ajax(){

     		$.ajax({   
	        	url:'bmpm_ajax_ajax',   
	        	type:'get',
	        	dataType:'html',      
	        	error:function(){   
	        		alert('error');   
	        	},   
	        	success:function(data){   
	           		$("#bmpm_l").html(data); 
	     		} 
	     	   });
     }

      function jmpm_ajax(){

     	 $.ajax({   
	        	url:'jmpm_ajax_ajax',   
	        	type:'get',
	        	dataType:'html',      
	        	error:function(){   
	        		alert('error');   
	        	},   
	        	success:function(data){   
	           		$("#jmpm_l").html(data); 
	     		} 
	     	   });
     }

     function bmjm_ajax(){

     	 $.ajax({   
	        	url:'bmjm_ajax_ajax',   
	        	type:'get',
	        	dataType:'html', 
	        	data : {
					"dept_name" :dept_name 
				},     
	        	error:function(){   
	        		alert('error');   
	        	},   
	        	success:function(data){   
	           		$("#bmjm_l").html(data); 
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

           $("#getmsg").html("");
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
    </script>




	</head>
	<body>
			<!-- 	test -->
		<div class="bg"></div>
		<div class="bg bg2"></div>
		<div class="bg bg3"></div>
		<!-- test -->


        <div class="alert alert-success alert-dismissable">
				<button type="button" class="close" data-dismiss="alert"
						aria-hidden="true">
					&times;
				</button>
				听闻集齐氯皇虹兰可向神龙许愿。
        </div>



               

			    <div class="walletdivcss" position:relative style="display:flex; flex-direction:column;">
                   <div style="display:flex; flex-direction:row;">
				
					<div>

							<div class="dropdown">
								<button type="button" class="btn btn-large sdropdown-toggle"
								id="dropdownMenu1" data-toggle="dropdown">
								我的钱包 <span class="caret"></span></button>
							</div>



							<div id="walletchoice" style="display: none;">
								<ul class="nav nav-pills">
									<li id="clickrecharge" class="active"><a href="#" class="walletop">充值</a></li>
									<li><a href="javascript:rob_dis_app();" class="walletop">抢红包</a></li>
									<li><a href="#" class="walletop" data-toggle="modal" data-target="#tixian">提现</a></li>
								</ul>
							</div>


							<div id="beStronger" style="display: none;">


									<select name="howmuch" ID="formre"   style="width:87px;height:24px;">
										<option value="0.99">0.99￥</option>
										<option value="6.66">6.66￥</option>
										<option value="66.60">66.60￥</option>
										<option value="666.00">666.00￥</option>
										<option value="6666.66">6666.66￥</option>
									</select> <button id ="shopping" class="btn btn-primary btn-xs"
									data-toggle="modal" data-target="#myModal"><span class="glyphicon glyphicon-shopping-cart" style="color: rgb(256, 251, 256); font-size: 13px;"> </span> 支付方式</button>
                                     









                              </div>

                       </div>

									<div class="myBalance"  id="myBalance"  style="display: none;">
										<p>余额 ：        </p>
										<strong ID="balance" style="color:#B8860B ;font-size: 31px;"></strong>
									</div>
							</div>
                            
							<div id="rob" style="display: none;">
									  <ul id="myTab" class="nav nav-tabs">
										<li class="active">
											<a href="#robhome" data-toggle="tab" onclick="check_open()">
												 抢
											</a>
										</li>
										
										<li class="dropdown">
											<a href="#" id="myTabDrop1" class="dropdown-toggle" 
											   data-toggle="dropdown">我的记录 
												<b class="caret"></b>
											</a>
											<ul class="dropdown-menu" role="menu" aria-labelledby="myTabDrop1">
												<li><a id="hbyj" href="#hbyjl" tabindex="-1" data-toggle="tab">红包雨记录</a></li>
												<li><a id="qhbj" href="#qhbjl" tabindex="-1" data-toggle="tab">抢红包记录</a></li>
											<!-- 	<li><a id="dsj" href="#dsjl" tabindex="-1" data-toggle="tab">打赏记录</a></li> -->

											</ul>
										</li>
										<li><a href="#jinzhu" data-toggle="tab">活动金主</a></li>
										<li><a href="#adarea" data-toggle="tab">广告招租</a></li>
									</ul>
										<div id="myTabContent" class="tab-content">
											<div class="tab-pane fade in active" id="robhome" style="text-align:center">
												   <h3 id="h3titile">雷谋</h3>
															
															
															<img id="pandagif" src="img/red/redgif/panda.gif"  alt="panda" class="img-circle"   style="width:272px;height: 272px;"/>
															
															
															
															
															
															<br>
															<div style="display:flex;flex-direction:row;">
															<div style="width:100px"></div>
															<button class="btn btn-danger" id="getred"  onclick="click_on_get()">抢红包</button>
															</div>
															<br>
														    <p id="getmsg" style="font-size:6px; color:red;"></p>


											</div>
											<div class="tab-pane fade" id="jinzhu" style="text-align:center">
												<div style="display:flex; flex-direction:row;">
													

													    <div class="jinzhupic">
							 								<img src="img/gp/yhj.jpg" alt="z"  style="width:120px;height:120px;" >
		                      								<div class="g_jzn">
																	    银行家
															</div>
														</div>

														<div class="jinzhupic">
													 

															<img src="img/gp/gan.jpg" alt="gan"    style="width:120px;height: 120px;" >
															<div class="g_jzn">
																	    阿甘
															</div>
														</div>
												</div>
											</div>

											<div class="tab-pane fade" id="adarea" style="text-align:center">
												

													    <div class="jinzhupic" style="margin :29px 29px 29px 29px;">
							 								<img src="img/gp/1.jpg" alt="1"  style="width:120px;height:120px;" >
		                      								<div class="g_jzn" >
																	    真诚交商 广告招租
															</div>
														</div>

														
												
											</div>

											<div class="tab-pane fade" id="hbyjl" style="text-align:center">
												
												<p>红包雨</p>
												
												<img src="img/red/redgif/timg7.gif"  alt="red" class="img-circle" style="width:72px;height: 72px;"/>
												<div id="getlist">
												</div>
											</div>
											<div class="tab-pane fade" id="qhbjl" style="text-align:center">
												
												<p>抢劫！
												</p>
												
												<img src="img/red/redgif/timg7.gif"  alt="red" class="img-circle" style="width:72px;height: 72px;"/>
												<div id="getqlist">
												</div>
											</div>

											<div class="tab-pane fade" id="dsjl" style="text-align:center">
												
												<p>赏你的
												</p>
												
												<img src="img/red/redgif/timg7.gif"  alt="red" class="img-circle" style="width:72px;height: 72px;"/>
												<div id="getlist">
												</div>
											</div>
										</div>

							</div>
                    </div>
               

				<div class="programdivcss" position:relative>
						


					<div class="panel panel-warning">
							<div class="panel-heading">
								<h4 class="panel-title">
									<a data-toggle="collapse" data-parent="#accordion" 
									   href="#collapseOne">
										节目单
									</a>
								</h4>
							</div>
							<div id="collapseOne" class="panel-collapse collapse ">
										<div class="panel-body" style="padding:1px">

													<div class="panel-group" id="accordion2">
																
																<div class="panel panel-success">
																	<div class="panel-heading">
																		
																				<button id="jmpm" class="btn btn-success btn-xs" data-toggle="collapse" data-parent="#accordion2" 
																			   href="#collapseTwo">节目排名</button>
																		
																	</div>
																	<div id="collapseTwo" class="panel-collapse collapse">
																		<div id="jmpm_l" class="panel-body">
																			
																		</div>
																	</div>
																</div>
																<div class="panel panel-info">
																	<div class="panel-heading">
																		
																			
																				
																				<button id="bmpm" class="btn btn-primary btn-xs" data-toggle="collapse" data-parent="#accordion2" 
																	    		href="#collapseThree">
																				部门排名</button>
																			
																			



																	</div>
																	<div id="collapseThree" class="panel-collapse collapse">
																		<div id="bmpm_l" class="panel-body">
																			
																		</div>
																	</div>
																</div>
																<div class="panel panel-warning">
																	<div class="panel-heading">
																		
																				<button class="btn btn-warning btn-xs" data-toggle="collapse" data-parent="#accordion2" 
																			    		href="#collapseFour">

																				部门节目</button>
																			
																	</div>
																	<div id="collapseFour" class="panel-collapse collapse">
																		<div class="panel-body">
																			<select name="select_dept" ID="select_dept"   style="width:107px;height:27px;">
																		<option value="技术部">机车技术部</option>
																		<option value="天气播报部">天气播报部</option>
																		<option value="市场部">炫酷市场部</option>
																		<option value="人力资源部">人力资源部</option>
																		<option value="公关部">最美公关部</option>
																	

									
												</select> <button id ="searchDept" class="btn  btn-xs" 

									><span class="glyphicon  glyphicon-search" style="color: rgb(6, 1, 2); font-size: 13px;"> </span> 搜索</button>

									<div id="bmjm_l"></div>
																		</div>
																	</div>
																</div>
													</div>

														<div style="display:flex;flex-direction:row;">
															<div style="width: 203px"></div><div>Oui, je vais y répondre.</div>
														</div>


									
							


										</div>
							</div>
					</div>




				</div>










				<div class="talkdivcss" position:relative>
                   <div class="kuang">
                   <button class=" g_cbtn  btn-xs" onclick="tdchange()"><span class="glyphicon glyphicon-comment" style="color: rgb(255, 255, 255); font-size: 12px;"></span></button>
						
						<div id="td1" style="display: none;">
							<input type="text"  name="words" id="words" placeholder="畅所欲言"  > 
							<button class="btn btn-large btn-primary" onclick="Editsubmit()" type="button">发送</button>
                        </div>
                                    
						<br> 
<!-- 						<p style="font-size:6px; color:#000;">GO</p>
 -->						<div ID="talkdiv" style="display: none;" position:relative style="{text-align:left;}">
			            </div>
	                  
				   </div>

               </div>





										                                       <!-- 按钮触发模态框 -->
											<!-- <button class="btn btn-primary " data-toggle="modal" data-target="#myModal">
												选择支付方式
											</button> -->
											<!-- 模态框（Modal） -->
				<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×
								</button>
								<h4 class="modal-title" id="myModalLabel">
									"我想给世界买瓶可口可乐"
								</h4>
							</div>
							<div class="modal-body" style="{margin:25px;}" >
								<h3 id="paytell" style="color:#27408B;">请输入密码</h3>
                                      <div style="display:flex; flex-direction:row;" id="fourpic">
                                      <div>
                                        <div class="polaroid" id="paypic1d">
										  <img src="img/wechat.jpg" alt="wechat" style="width:96%" id="paypic1">
										  <div class="container">
										    <p>WeChat</p>
										  </div>
										</div>

										 <div class="polaroid" id="paypic2d">
										  <img src="img/zf.jpg" alt="zf" style="width:96%" id="paypic2">
										  <div class="container">
										    <p>支付宝</p>
										  </div>
										</div>

									</div>
									<div>
                                        <div class="polaroid" id="paypic3d">
										  <img src="img/UP.jpg" alt="UP" style="width:96%" id="paypic3">
										  <div class="container">
										    <p>银联</p>
										  </div>
										</div>

										 <div class="polaroid" id="paypic4d">
										  <img src="img/NK.jpg" alt="NK" style="width:96%" id="paypic4">
										  <div class="container">
										    <p>交行学子卡</p>
										  </div>
										</div>

									</div>

									</div>
                                 <div id="afterclickpic" style="display: none;">
                                    
									<input id="paypw" type="password" ><button class="btn btn-primary"  style=" margin:0.5em 1em;" onclick="checkpw()">OK</button>

									<div class="polaroid">
										  <img src="img/passing.jpg" alt="boy" style="width:96%" >
										  <div class="container">
										    <p> Make Difference</p>
										  </div>
										</div>
								</div>

							</div>
							<div class="modal-footer">
								<button id="closeMTK" type="button" class="btn btn-default" data-dismiss="modal">
									再看看
								</button>
								
							</div>
						</div><!-- /.modal-content -->
					</div><!-- /.modal-dialog -->
				</div><!-- /.modal -->
			
                



                                      <!-- 询问提现模态框 -->

                                      <!-- 模态框（Modal） -->
<div class="modal fade" id="tixian" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog modal-sm">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
					&times;
				</button>
				<h4 class="modal-title" id="myModalLabel">
					全部提现？
				</h4>
			</div>
			<div class="modal-body">
				
				<div class="polaroid" >
					 <img src="img/NK.jpg" alt="NKK" class="img-circle" style="width:99%" >
                       <div class="container">
						 <p>至我的的学子卡</p>
					</div>
					</div>
			</div>
			<div class="modal-footer" style="text-align:center">
				<button id="tixiantrue" type="button" class="btn btn-success" data-dismiss="modal" onclick="tixianajax()">确定
				</button>
				<button type="button" class="btn btn-default" data-dismiss="modal">取消
				</button>
				
				
			</div>
		</div><!-- /.modal-content -->
	</div><!-- /.modal -->
</div>


	<!-- 打赏模态框 -->

                                      <!-- 模态框（Modal） -->
<div class="modal fade" id="dsmtk" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog modal-sm">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
					&times;
				</button>
				<h5 class="modal-title" id="dsModalLabel">
					打赏<b id="dstitle"></b>多少元呢？
				</h5>
			</div>
			<div class="modal-body">
				
				<input id="reward_input" placeholder="多多益善">

				<p id="reward_input_checkMsg" style="color:#B8860B;font-size: 13px; "></p>
			</div>
			<div class="modal-footer" >
				<button id="dsmtktrue" type="button" class="btn btn-success btn-xs"  onclick="reward_check()">确定
				</button>
				<button type="button" class="btn btn-default btn-xs" data-dismiss="modal">取消
				</button>
				
				
			</div>
		</div><!-- /.modal-content -->
	</div><!-- /.modal -->
</div>

<!-- Button to trigger modal -->
<!-- <a href="#myModal" role="button" class="btn" data-toggle="modal"><span class="glyphicon glyphicon-shopping-cart" style="color: rgb(256, 251, 256); font-size: 13px;"> </span> 支付方式</a> -->
 
<!-- Modal --><!-- 
<div id="myModal" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-header">
    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
    <h3 id="myModalLabel">Modal header</h3>
  </div>
  <div class="modal-body">
    <p>One fine body…</p>
  </div>
  <div class="modal-footer">
    <button class="btn" data-dismiss="modal" aria-hidden="true">Close</button>
    <button class="btn btn-primary">Save changes</button>
  </div>
</div> -->



		</body>
		</html>
