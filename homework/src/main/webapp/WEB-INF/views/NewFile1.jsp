<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
	 <meta name="viewport" content="width=device-width">
	  <title></title>
  <link href="css/bootstrap.min.css" rel="stylesheet"> 
  <script src="js/jquery-3.2.1.min.js"></script>
  <script src="js/bootstrap.min.js"></script>
 
 
 
  <script type="application/javascript">
       
  	//var jq = jQuery.noConflict();
      $(document).ready(function () {
          $("p").click(function () {
              $(this).css("background-color", "red");
          });
          $("#hide").click(function () {
              $("p").hide(1000);
          });
          $("#show").click(function () {
              $("p").show(1000);
          });
          $("#div1").click(function () {
              $(this).fadeTo(1000,0.1);
          });
          $("#div2").click(function () {
              $("#div2").slideToggle();
          });
          $("#fade").click(function() {
              $("#div1").fadeTo(1000,0.8);
          });
          $("#slide").click(function () {
              $("#div2").slideToggle();
          });
          $("#animate").click(function () {
              $("#div2").animate({left:'300px',
                  height:'+=150px',
                  width:'+=150px'},3000);
          });
          $("#hide").click(function() {
        	  $.get("/admin?",function(data, status){
        		  
        	  });
          });
      });

  </script>
</head>
<body>

<div class="alert alert-warning">
  <a href="#" class="close" data-dismiss="alert">
    &times;
  </a>
  <strong>警告！</strong>您的网络连接有问题。
</div>


<div class="dropdown">
  <button type="button" class="btn dropdown-toggle" id="dropdownMenu1" data-toggle="dropdown">主题
    <span class="caret"></span>
  </button>
  <ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu1">
    <li role="presentation">
      <a role="menuitem" tabindex="-1" href="#">Java</a>
    </li>
    <li role="presentation">
      <a role="menuitem" tabindex="-1" href="#">数据挖掘</a>
    </li>
    <li role="presentation">
      <a role="menuitem" tabindex="-1" href="#">数据通信/网络</a>
    </li>
    <li role="presentation" class="divider"></li>
    <li role="presentation">
      <a role="menuitem" tabindex="-1" href="#">分离的链接</a>
    </li>
  </ul>
</div>


<h1><p>It Works!</p></h1>
<h1><p>It Works!</p></h1>
<input type="button" id="hide" value="hide">
<input type="button" id="show" value="show">
<div id="div1" style="width: 300px; height: 300px; background-color: red"></div>
<input type="button" value="fadeout" id="fade">
<div id="div2" style="width: 300px; height: 300px; background-color: blue; position: relative"></div>
<input type="button"  value="slide" id="slide">
<input id="animate"   value="animate" type="button">




</body>
</html>
