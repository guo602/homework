<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
 <meta name="viewport" content="width=device-width">
  <link rel="stylesheet" type="text/css" href="css/rlg.css">

  <script src="js/jquery-3.2.1.min.js" ></script>
  <meta http-equiv="refresh" content="2.8;url='redlogin'">
<title>MaoPao</title>
<style type="text/css">
	
body {
  font-family: 'Roboto', sans-serif;
  background-color: #FFD399;
}

.container {
  display: -webkit-box;
  display: -ms-flexbox;
  display: flex;
  -webkit-box-pack: center;
      -ms-flex-pack: center;
          justify-content: center;
  -webkit-box-align: center;
      -ms-flex-align: center;
          align-items: center;
  -webkit-box-orient: horizontal;
  -webkit-box-direction: normal;
      -ms-flex-direction: row;
          flex-direction: row;
  margin: 0 auto;
  width: 50%;
}

@-webkit-keyframes rotate {
  0% {
    -webkit-transform: rotateX(-37.5deg) rotateY(45deg);
            transform: rotateX(-37.5deg) rotateY(45deg);
  }
  50% {
    -webkit-transform: rotateX(-37.5deg) rotateY(405deg);
            transform: rotateX(-37.5deg) rotateY(405deg);
  }
  100% {
    -webkit-transform: rotateX(-37.5deg) rotateY(405deg);
            transform: rotateX(-37.5deg) rotateY(405deg);
  }
}

@keyframes rotate {
  0% {
    -webkit-transform: rotateX(-37.5deg) rotateY(45deg);
            transform: rotateX(-37.5deg) rotateY(45deg);
  }
  50% {
    -webkit-transform: rotateX(-37.5deg) rotateY(405deg);
            transform: rotateX(-37.5deg) rotateY(405deg);
  }
  100% {
    -webkit-transform: rotateX(-37.5deg) rotateY(405deg);
            transform: rotateX(-37.5deg) rotateY(405deg);
  }
}
.cube, .cube * {
  position: absolute;
  width: 151px;
  height: 151px;
}

.sides {
  -webkit-animation: rotate 3s ease infinite;
          animation: rotate 3s ease infinite;
  -webkit-animation-delay: .8s;
          animation-delay: .8s;
  -webkit-transform-style: preserve-3d;
          transform-style: preserve-3d;
  -webkit-transform: rotateX(-37.5deg) rotateY(45deg);
          transform: rotateX(-37.5deg) rotateY(45deg);
}

.cube .sides * {
  box-sizing: border-box;
  background-color: rgba(242, 119, 119, 0.5);
  border: 15px solid white;
}

.cube .sides .top {
  -webkit-animation: top-animation 3s ease infinite;
          animation: top-animation 3s ease infinite;
  -webkit-animation-delay: 0ms;
          animation-delay: 0ms;
  -webkit-transform: rotateX(90deg) translateZ(150px);
          transform: rotateX(90deg) translateZ(150px);
  -webkit-animation-fill-mode: forwards;
          animation-fill-mode: forwards;
  -webkit-transform-origin: 50% 50%;
          transform-origin: 50% 50%;
}
@-webkit-keyframes top-animation {
  0% {
    opacity: 1;
    -webkit-transform: rotateX(90deg) translateZ(150px);
            transform: rotateX(90deg) translateZ(150px);
  }
  20% {
    opacity: 1;
    -webkit-transform: rotateX(90deg) translateZ(75px);
            transform: rotateX(90deg) translateZ(75px);
  }
  70% {
    opacity: 1;
    -webkit-transform: rotateX(90deg) translateZ(75px);
            transform: rotateX(90deg) translateZ(75px);
  }
  90% {
    opacity: 1;
    -webkit-transform: rotateX(90deg) translateZ(150px);
            transform: rotateX(90deg) translateZ(150px);
  }
  100% {
    opacity: 1;
    -webkit-transform: rotateX(90deg) translateZ(150px);
            transform: rotateX(90deg) translateZ(150px);
  }
}
@keyframes top-animation {
  0% {
    opacity: 1;
    -webkit-transform: rotateX(90deg) translateZ(150px);
            transform: rotateX(90deg) translateZ(150px);
  }
  20% {
    opacity: 1;
    -webkit-transform: rotateX(90deg) translateZ(75px);
            transform: rotateX(90deg) translateZ(75px);
  }
  70% {
    opacity: 1;
    -webkit-transform: rotateX(90deg) translateZ(75px);
            transform: rotateX(90deg) translateZ(75px);
  }
  90% {
    opacity: 1;
    -webkit-transform: rotateX(90deg) translateZ(150px);
            transform: rotateX(90deg) translateZ(150px);
  }
  100% {
    opacity: 1;
    -webkit-transform: rotateX(90deg) translateZ(150px);
            transform: rotateX(90deg) translateZ(150px);
  }
}
.cube .sides .bottom {
  -webkit-animation: bottom-animation 3s ease infinite;
          animation: bottom-animation 3s ease infinite;
  -webkit-animation-delay: 0ms;
          animation-delay: 0ms;
  -webkit-transform: rotateX(-90deg) translateZ(150px);
          transform: rotateX(-90deg) translateZ(150px);
  -webkit-animation-fill-mode: forwards;
          animation-fill-mode: forwards;
  -webkit-transform-origin: 50% 50%;
          transform-origin: 50% 50%;
}
@-webkit-keyframes bottom-animation {
  0% {
    opacity: 1;
    -webkit-transform: rotateX(-90deg) translateZ(150px);
            transform: rotateX(-90deg) translateZ(150px);
  }
  20% {
    opacity: 1;
    -webkit-transform: rotateX(-90deg) translateZ(75px);
            transform: rotateX(-90deg) translateZ(75px);
  }
  70% {
    opacity: 1;
    -webkit-transform: rotateX(-90deg) translateZ(75px);
            transform: rotateX(-90deg) translateZ(75px);
  }
  90% {
    opacity: 1;
    -webkit-transform: rotateX(-90deg) translateZ(150px);
            transform: rotateX(-90deg) translateZ(150px);
  }
  100% {
    opacity: 1;
    -webkit-transform: rotateX(-90deg) translateZ(150px);
            transform: rotateX(-90deg) translateZ(150px);
  }
}
@keyframes bottom-animation {
  0% {
    opacity: 1;
    -webkit-transform: rotateX(-90deg) translateZ(150px);
            transform: rotateX(-90deg) translateZ(150px);
  }
  20% {
    opacity: 1;
    -webkit-transform: rotateX(-90deg) translateZ(75px);
            transform: rotateX(-90deg) translateZ(75px);
  }
  70% {
    opacity: 1;
    -webkit-transform: rotateX(-90deg) translateZ(75px);
            transform: rotateX(-90deg) translateZ(75px);
  }
  90% {
    opacity: 1;
    -webkit-transform: rotateX(-90deg) translateZ(150px);
            transform: rotateX(-90deg) translateZ(150px);
  }
  100% {
    opacity: 1;
    -webkit-transform: rotateX(-90deg) translateZ(150px);
            transform: rotateX(-90deg) translateZ(150px);
  }
}
.cube .sides .front {
  -webkit-animation: front-animation 3s ease infinite;
          animation: front-animation 3s ease infinite;
  -webkit-animation-delay: 100ms;
          animation-delay: 100ms;
  -webkit-transform: rotateY(0deg) translateZ(150px);
          transform: rotateY(0deg) translateZ(150px);
  -webkit-animation-fill-mode: forwards;
          animation-fill-mode: forwards;
  -webkit-transform-origin: 50% 50%;
          transform-origin: 50% 50%;
}
@-webkit-keyframes front-animation {
  0% {
    opacity: 1;
    -webkit-transform: rotateY(0deg) translateZ(150px);
            transform: rotateY(0deg) translateZ(150px);
  }
  20% {
    opacity: 1;
    -webkit-transform: rotateY(0deg) translateZ(75px);
            transform: rotateY(0deg) translateZ(75px);
  }
  70% {
    opacity: 1;
    -webkit-transform: rotateY(0deg) translateZ(75px);
            transform: rotateY(0deg) translateZ(75px);
  }
  90% {
    opacity: 1;
    -webkit-transform: rotateY(0deg) translateZ(150px);
            transform: rotateY(0deg) translateZ(150px);
  }
  100% {
    opacity: 1;
    -webkit-transform: rotateY(0deg) translateZ(150px);
            transform: rotateY(0deg) translateZ(150px);
  }
}
@keyframes front-animation {
  0% {
    opacity: 1;
    -webkit-transform: rotateY(0deg) translateZ(150px);
            transform: rotateY(0deg) translateZ(150px);
  }
  20% {
    opacity: 1;
    -webkit-transform: rotateY(0deg) translateZ(75px);
            transform: rotateY(0deg) translateZ(75px);
  }
  70% {
    opacity: 1;
    -webkit-transform: rotateY(0deg) translateZ(75px);
            transform: rotateY(0deg) translateZ(75px);
  }
  90% {
    opacity: 1;
    -webkit-transform: rotateY(0deg) translateZ(150px);
            transform: rotateY(0deg) translateZ(150px);
  }
  100% {
    opacity: 1;
    -webkit-transform: rotateY(0deg) translateZ(150px);
            transform: rotateY(0deg) translateZ(150px);
  }
}
.cube .sides .back {
  -webkit-animation: back-animation 3s ease infinite;
          animation: back-animation 3s ease infinite;
  -webkit-animation-delay: 100ms;
          animation-delay: 100ms;
  -webkit-transform: rotateY(-180deg) translateZ(150px);
          transform: rotateY(-180deg) translateZ(150px);
  -webkit-animation-fill-mode: forwards;
          animation-fill-mode: forwards;
  -webkit-transform-origin: 50% 50%;
          transform-origin: 50% 50%;
}
@-webkit-keyframes back-animation {
  0% {
    opacity: 1;
    -webkit-transform: rotateY(-180deg) translateZ(150px);
            transform: rotateY(-180deg) translateZ(150px);
  }
  20% {
    opacity: 1;
    -webkit-transform: rotateY(-180deg) translateZ(75px);
            transform: rotateY(-180deg) translateZ(75px);
  }
  70% {
    opacity: 1;
    -webkit-transform: rotateY(-180deg) translateZ(75px);
            transform: rotateY(-180deg) translateZ(75px);
  }
  90% {
    opacity: 1;
    -webkit-transform: rotateY(-180deg) translateZ(150px);
            transform: rotateY(-180deg) translateZ(150px);
  }
  100% {
    opacity: 1;
    -webkit-transform: rotateY(-180deg) translateZ(150px);
            transform: rotateY(-180deg) translateZ(150px);
  }
}
@keyframes back-animation {
  0% {
    opacity: 1;
    -webkit-transform: rotateY(-180deg) translateZ(150px);
            transform: rotateY(-180deg) translateZ(150px);
  }
  20% {
    opacity: 1;
    -webkit-transform: rotateY(-180deg) translateZ(75px);
            transform: rotateY(-180deg) translateZ(75px);
  }
  70% {
    opacity: 1;
    -webkit-transform: rotateY(-180deg) translateZ(75px);
            transform: rotateY(-180deg) translateZ(75px);
  }
  90% {
    opacity: 1;
    -webkit-transform: rotateY(-180deg) translateZ(150px);
            transform: rotateY(-180deg) translateZ(150px);
  }
  100% {
    opacity: 1;
    -webkit-transform: rotateY(-180deg) translateZ(150px);
            transform: rotateY(-180deg) translateZ(150px);
  }
}
.cube .sides .left {
  -webkit-animation: left-animation 3s ease infinite;
          animation: left-animation 3s ease infinite;
  -webkit-animation-delay: 100ms;
          animation-delay: 100ms;
  -webkit-transform: rotateY(-90deg) translateZ(150px);
          transform: rotateY(-90deg) translateZ(150px);
  -webkit-animation-fill-mode: forwards;
          animation-fill-mode: forwards;
  -webkit-transform-origin: 50% 50%;
          transform-origin: 50% 50%;
}
@-webkit-keyframes left-animation {
  0% {
    opacity: 1;
    -webkit-transform: rotateY(-90deg) translateZ(150px);
            transform: rotateY(-90deg) translateZ(150px);
  }
  20% {
    opacity: 1;
    -webkit-transform: rotateY(-90deg) translateZ(75px);
            transform: rotateY(-90deg) translateZ(75px);
  }
  70% {
    opacity: 1;
    -webkit-transform: rotateY(-90deg) translateZ(75px);
            transform: rotateY(-90deg) translateZ(75px);
  }
  90% {
    opacity: 1;
    -webkit-transform: rotateY(-90deg) translateZ(150px);
            transform: rotateY(-90deg) translateZ(150px);
  }
  100% {
    opacity: 1;
    -webkit-transform: rotateY(-90deg) translateZ(150px);
            transform: rotateY(-90deg) translateZ(150px);
  }
}
@keyframes left-animation {
  0% {
    opacity: 1;
    -webkit-transform: rotateY(-90deg) translateZ(150px);
            transform: rotateY(-90deg) translateZ(150px);
  }
  20% {
    opacity: 1;
    -webkit-transform: rotateY(-90deg) translateZ(75px);
            transform: rotateY(-90deg) translateZ(75px);
  }
  70% {
    opacity: 1;
    -webkit-transform: rotateY(-90deg) translateZ(75px);
            transform: rotateY(-90deg) translateZ(75px);
  }
  90% {
    opacity: 1;
    -webkit-transform: rotateY(-90deg) translateZ(150px);
            transform: rotateY(-90deg) translateZ(150px);
  }
  100% {
    opacity: 1;
    -webkit-transform: rotateY(-90deg) translateZ(150px);
            transform: rotateY(-90deg) translateZ(150px);
  }
}
.cube .sides .right {
  -webkit-animation: right-animation 3s ease infinite;
          animation: right-animation 3s ease infinite;
  -webkit-animation-delay: 100ms;
          animation-delay: 100ms;
  -webkit-transform: rotateY(90deg) translateZ(150px);
          transform: rotateY(90deg) translateZ(150px);
  -webkit-animation-fill-mode: forwards;
          animation-fill-mode: forwards;
  -webkit-transform-origin: 50% 50%;
          transform-origin: 50% 50%;
}
@-webkit-keyframes right-animation {
  0% {
    opacity: 1;
    -webkit-transform: rotateY(90deg) translateZ(150px);
            transform: rotateY(90deg) translateZ(150px);
  }
  20% {
    opacity: 1;
    -webkit-transform: rotateY(90deg) translateZ(75px);
            transform: rotateY(90deg) translateZ(75px);
  }
  70% {
    opacity: 1;
    -webkit-transform: rotateY(90deg) translateZ(75px);
            transform: rotateY(90deg) translateZ(75px);
  }
  90% {
    opacity: 1;
    -webkit-transform: rotateY(90deg) translateZ(150px);
            transform: rotateY(90deg) translateZ(150px);
  }
  100% {
    opacity: 1;
    -webkit-transform: rotateY(90deg) translateZ(150px);
            transform: rotateY(90deg) translateZ(150px);
  }
}
@keyframes right-animation {
  0% {
    opacity: 1;
    -webkit-transform: rotateY(90deg) translateZ(150px);
            transform: rotateY(90deg) translateZ(150px);
  }
  20% {
    opacity: 1;
    -webkit-transform: rotateY(90deg) translateZ(75px);
            transform: rotateY(90deg) translateZ(75px);
  }
  70% {
    opacity: 1;
    -webkit-transform: rotateY(90deg) translateZ(75px);
            transform: rotateY(90deg) translateZ(75px);
  }
  90% {
    opacity: 1;
    -webkit-transform: rotateY(90deg) translateZ(150px);
            transform: rotateY(90deg) translateZ(150px);
  }
  100% {
    opacity: 1;
    -webkit-transform: rotateY(90deg) translateZ(150px);
            transform: rotateY(90deg) translateZ(150px);
  }
}
.text {
  margin-top: 450px;
  color: #f27777;
  font-size: 2.5rem;
  width: 100%;
  font-weight: 600;
  text-align: center;
}


</style>

<script type="text/javascript">




   
</script>

</head>
<body>


<div class="container">
  <div class="cube">
    <div class="sides">
      <div class="top"></div>
      <div class="right"></div>
      <div class="bottom"></div>
      <div class="left"></div>
      <div class="front"></div>
      <div class="back"></div>
    </div>
  </div>
  


<br><br><br>
    <div class="text" >MaoPao 2017</div>

</div>



</body>
</form>
</html>
