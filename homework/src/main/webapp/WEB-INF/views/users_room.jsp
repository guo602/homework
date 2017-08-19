
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
					alert('充值成功');
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

				  	  });




	
											   $(function () { $('#myModal').modal('hide')});
											</script>
											<script>
											   // $(function () { $('#myModal').on('hide.bs.modal', function () {
											   //    alert('嘿，我听说您喜欢模态框...');})
											   // });
										



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
									<li><a href="tixian" class="walletop">提现</a></li>
								</ul>
							</div>


							<div id="beStronger" style="display: none;">


									<select name="howmuch" ID="formre"   style="width:89px;height:34px;">
										<option value="0.99">0.99￥</option>
										<option value="6.66">6.66￥</option>
										<option value="66.60">66.60￥</option>
										<option value="666.00">666.00￥</option>
										<option value="6666.66">6666.66￥</option>
									</select> <button class="btn btn-primary"
									data-toggle="modal" data-target="#myModal"><span class="glyphicon glyphicon-shopping-cart" style="color: rgb(256, 251, 256); font-size: 13px;"> </span> 支付方式</button>
                                     









                              </div>

                       </div>

									<div class="myBalance"  id="myBalance"  style="display: none;">
										<p>余额 ：        </p>
										<strong ID="balance" style="font-size: 50px"></strong>
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
					<form name="form1" action="up_words_ajax?word='document.getelementbyid(words)'">
						<input type="text"  name="words" id="words" placeholder="畅所欲言"  > 
						<button class="btn btn-large btn-primary" onclick="Editsubmit()" type="button">发送</button>


					</from>
					<br> 评论列表
					<div ID="talkdiv" position:relative style="{text-align:left;}">
		            </div>
                   </form>
				</div>

               <div>
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
														<div class="modal-body" style="{margin:25px;}">
															<h2 style="color:#27408B;">请选择支付方式</h2>
                                                                  <div style="display:flex; flex-direction:row;">
                                                                  <div>
                                                                    <div class="polaroid">
																	  <img src="img/wechat.jpg" alt="wechat" style="width:96%">
																	  <div class="container">
																	    <p>WeChat</p>
																	  </div>
																	</div>

																	 <div class="polaroid">
																	  <img src="img/zf.jpg" alt="wechat" style="width:96%">
																	  <div class="container">
																	    <p>支付宝</p>
																	  </div>
																	</div>

																</div>
																<div>
                                                                    <div class="polaroid">
																	  <img src="img/UP.jpg" alt="wechat" style="width:96%">
																	  <div class="container">
																	    <p>银联</p>
																	  </div>
																	</div>

																	 <div class="polaroid">
																	  <img src="img/NK.jpg" alt="wechat" style="width:96%">
																	  <div class="container">
																	    <p>建行学子卡</p>
																	  </div>
																	</div>

																</div>
																</div>

														</div>
														<div class="modal-footer">
															<button type="button" class="btn btn-default" data-dismiss="modal">
																等下
															</button>
															<button type="button" class="btn btn-primary">
																光速支付
															</button>
														</div>
													</div><!-- /.modal-content -->
												</div><!-- /.modal-dialog -->
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
