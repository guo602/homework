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

background-size:100% 150%;
}

.bg {
  animation: slide 3s ease-in-out infinite alternate;
  background-image: linear-gradient(-60deg, #080302 50%, #e1380e 50%);
  bottom: 0;
  left: -50%;
  opacity: .5;
  position: fixed;
  right: -50%;
  top: 0;
  z-index: -1;
}

.bg2 {
  animation-direction: alternate-reverse;
  animation-duration: 4s;
}

.bg3 {
  animation-duration: 5s;
}

.content {
  background-color: rgba(255, 255, 255, .8);
  border-radius: .25em;
  box-shadow: 0 0 .25em rgba(0, 0, 0, .25);
  box-sizing: border-box;
  left: 50%;
  padding: 10vmin;
  position: fixed;
  text-align: center;
  top: 50%;
  transform: translate(-50%, -50%);
}

h1 {
  font-family: monospace;
}

@keyframes slide {
  0% {
    transform: translateX(-25%);
  }
  100% {
    transform: translateX(25%);
  }
}

</style>

<script type="text/javascript">

   //var answer
   var path


    $(document).ready(function() {
          changeValiCode();
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
  <!--  test -->
    <div class="bg"></div>
    <div class="bg bg2"></div>
    <div class="bg bg3"></div>
    <!-- test -->
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
      <label class="whitetext">验证码</label><br>
      <img  id="myvalicode" class="captcha" src="img/verify.png">
      <input name="verify" type="text" placeholder="请输入上方验证码的字母拼音">
      <span class="help2">如验证码难以识别可点击验证码以更换。</span>
    </div>
    <div><button id="sub" type="submit" >我来也！</button></div>
     <br>
  </div>
  <div class="questionb" position:absolute>
    听说你很叼？
    <a id="question" href="maopaoAd"  target="_blank"> 吾乃管理员</a>
  </div>
</body>
</form>
</html>
