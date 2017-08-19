
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


	
	<link href="https://cdn.bootcss.com/bootstrap/4.0.0-beta/css/bootstrap-grid.css" rel="stylesheet">
	
	<link href="css/bootstrap.min.css" rel="stylesheet" media="screen">

	<script src="js/jquery-3.2.1.min.js" ></script>
	<!--<script src="js/bootstrap.min.js"></script>-->
	<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">  
	<script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
	<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<link rel="stylesheet" type="text/css" href="css/users_room.css">
    <script type="text/javascript">
     	
     	var pagenum=1;
     	var current=1;
        
     </script>
	

<script>
		


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
			var e1 = document.getElementById('pro_name').value;
			document.getElementById('rewardamount').value = "";
			send_reward(e1, e2);

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
					alert('打赏成功');
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

			if(document.getElementById('paytell').innerText=="请输入密码")
				{document.getElementById('paytell').innerText="请选择支付方式";}
			else{document.getElementById('paytell').innerText="请输入密码";}
		}

	</script>
	
	<script type="text/javascript">
		    $(document).ready(function() {
		    	refresh_content(pagenum,current);
		    	show_balance();
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

					  			});


					  		$("#clickrecharge").click(function () {
					  			if($("#beStronger").is(":hidden")){
					  				$("#beStronger").slideDown(50);
					  			}else{
					  				$("#beStronger").slideUp();
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

                                 if(document.getElementById('paytell').innerText=="请输入密码")
					  			 paytellchange();

					  		});
                                



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



	</head>
	<body>

		

        <div class="alert alert-success alert-dismissable">
				<button type="button" class="close" data-dismiss="alert"
						aria-hidden="true">
					&times;
				</button>
				听闻集齐氯皇虹兰可向神龙许愿。
        </div>





			    <div class="walletdivcss" position:relative style="display:flex; flex-direction:row;">

				
					<div>

							<div class="dropdown">
								<button type="button" class="btn btn-large sdropdown-toggle"
								id="dropdownMenu1" data-toggle="dropdown">
								我的钱包 <span class="caret"></span></button>
							</div>



							<div id="walletchoice" style="display: none;">
								<ul class="nav nav-pills">
									<li id="clickrecharge" class="active"><a href="#" class="walletop">充值</a></li>
									<li><a href="redtable" class="walletop">抢红包</a></li>
									<li><a href="#" class="walletop" data-toggle="modal" data-target="#tixian">提现</a></li>
								</ul>
							</div>


							<div id="beStronger" style="display: none;">


									<select name="howmuch" ID="formre"   style="width:89px;height:34px;">
										<option value="0.99">0.99￥</option>
										<option value="6.66">6.66￥</option>
										<option value="66.60">66.60￥</option>
										<option value="666.00">666.00￥</option>
										<option value="6666.66">6666.66￥</option>
									</select> <button id ="shopping" class="btn btn-primary"
									data-toggle="modal" data-target="#myModal"><span class="glyphicon glyphicon-shopping-cart" style="color: rgb(256, 251, 256); font-size: 13px;"> </span> 支付方式</button>
                                     









                              </div>

                       </div>

									<div class="myBalance"  id="myBalance"  style="display: none;">
										<p>余额 ：        </p>
										<strong ID="balance" style="font-size: 48px"></strong>
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
							<div class="panel-body">






						<table  class="table table-striped" border=0>
							<tbody>
								<c:forEach items="${pro}" var="ep">

								<tr>
									<form name="${ep.getPro_name()}" action="rewards">
										<td>${ep.getPro_name()}</td>
										<td>${ep.getPerformer()}</td>
										<td>${ep.getDept()}</td> <input type="hidden" name="pro_name"
										ID="pro_name" value="${ep.getPro_name()}">
										<td><input type="button" value="我想打赏"></td>
									</tr>

									<tr>
										<td></td>
										<td><input name="rewardamount" ID="rewardamount"></td>

										<td><input type="button" value="立即打赏" onclick="submit()"></td>
										<td><input type="button" value="再看下"></td>
									</form>
								</tr>

							</c:forEach>
						  </tbody>
					    </table>
				


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
																	    <p>建行学子卡</p>
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
										
                                       </div> 



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
					 <img src="img/NK.jpg" alt="NKK" class="img-circle" style="width:40%" >
                       <div class="container">
						 <p>把钱装进带有椭圆加密的学子卡</p>
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
