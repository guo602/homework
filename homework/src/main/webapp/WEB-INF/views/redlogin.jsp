<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
 <meta name="viewport" content="width=device-width">
  <link rel="stylesheet" type="text/css" href="css/rlg.css">

  <script src="js/jquery-3.2.1.min.js" ></script>
<title>帅郭们的年会</title>
 <style type="text/css">
body{

background-size:100% 100%;
};


</style>

<script type="text/javascript">

   //var answer
   var path


    $(document).ready(function() {
       
         $("#myvalicode").click(function () {
                
                  //ajax action

                  changeValiCode();

                });


      });

   

    function changeValiCode(){
              $.ajax({
                      url : 'validatecode',
                      type : 'get',
                      dataType : 'html',
                   
                      error : function() {
                        alert('error');
                      },
                      success : function(data) {
                      
                        $("#myvalicode")[0].src; 

                        $("#myvalicode").attr('src',data);
                                              }
                    });

    }




   
</script>

</head>
<body>

<form  name="form1" action="toUsersRoom" method="get" >

<div class="redhead" position:relative >
	  
</div>

 <div class="main" position:relative>
          <br>

    <h1 class="title">为了红包与节目！</h1>  
    <p class="description" align="center">welcome</p>
    <div class="itcode">
      <label class="whitetext">工号</label>
      <input name="itcode"  placeholder="请输入你的工号">
      <span class="help1">别总习习哈哈</span>
    </div>
    <div class="name">
      <label class="whitetext">尊姓大名</label>
      <input name= "name"  placeholder="名字长，头发短">
    </div>
    <div class="verify">
      <label class="whitetext">验证码</label>
      <img  id="myvalicode" class="captcha" src="img/verify.png">
      <input name="verify" type="text" placeholder="请输入右侧验证码">
      <span class="help2">如验证码难以识别可点击验证码图片进行更换。</span>
    </div>
    <div><button id="sub" type="submit" >我来也！</button></div>
     <br>
  </div>
  <div class="questionb" position:absolute>
    有问题？
    <a id="question" href='rlproblem'> 点击这里</a>
  </div>
</body>
</form>
</html>
