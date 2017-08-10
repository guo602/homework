<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
 <meta name="viewport" content="width=device-width">
  <link rel="stylesheet" type="text/css" href="css/rlg.css">
<title>帅郭们的年会</title>
 <style type="text/css">
body{
background-image: url(img/j2.jpg);
background-size:100% 100%;
};


</style>
</head>
<body>

<form  name="form1" action="validateuser" method="get" >

<div class="redhead" position:relative >
	  <br>
</div>

 <div class="main" position:relative>
          <br>

    <h1 class="title">为了红包与节目！</h1>  
    <p class="description" align="center">举身赴清池,清池亦可平</p>
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
      <img class="captcha" src="img/verify.png">
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