var droppacketstimer;
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


/*jshint esversion:6*/
var can = document.createElement("canvas");
document.body.appendChild(can);
var ctx = can.getContext('2d');
function resize(){
  can.width = window.innerWidth;
  can.height = window.innerHeight;
}
const max_radius = 3;
const min_radius = 1;
const drag = 50;
window.onresize = function(){
  resize();
};
function cfill(){
  ctx.fillStyle = "#000";
  ctx.fillRect(0,0,can.width,can.height);
  ctx.fill();
}
var mouse = {
  x:-1000,
  y:-1000
};
can.onmousemove = function(e){
  mouse.x = e.clientX;
  mouse.y = e.clientY;
};
can.ontouchmove = function(e){
  mouse.x = e.touches[0].clientX;
  mouse.y = e.touches[0].clientY;
};
resize();
cfill();

function distance(x,y,x1,y1){
  return Math.sqrt( ( x1-x ) * ( x1-x ) + ( y1-y ) * ( y1-y ) );
}

class Particle{
  constructor(pos,target,vel,color,radius){
    this.pos = pos;
    this.target = target;
    this.vel = vel; 
    this.color = color;
    this.radius = radius;
    var arr = [-1,1];
    this.direction = arr[~~(Math.random()*2)]*Math.random()/10;
  }
  set(type,value){
    this[type] = value;
  }
  update(){
    this.radius += this.direction;
    this.vel.x = (this.pos.x - this.target.x)/drag;
    this.vel.y = (this.pos.y - this.target.y)/drag;
    if(distance(this.pos.x,this.pos.y,mouse.x,mouse.y) < 50){
      this.vel.x += this.vel.x - (this.pos.x - mouse.x)/15;
      this.vel.y += this.vel.y - (this.pos.y - mouse.y)/15;
    }
    if(this.radius >= max_radius){
      this.direction *= -1;
    }
    if(this.radius <= 1){
      this.direction *= -1;
    }
    this.pos.x -= this.vel.x;
    this.pos.y -= this.vel.y;
  }
  draw(){
    ctx.beginPath();
    ctx.fillStyle = this.color;
    ctx.arc(this.pos.x,this.pos.y,this.radius,0,Math.PI*2);
    ctx.fill();
  }
}
var particles = [];
var colors = ["#bf1337","#f3f1f3","#084c8d","#f2d108","#efd282"];
var bool = true;
var current = 0,i;
function changeText(text){
  var current = 0,temp,radius,color;
  cfill();
  ctx.fillStyle = "#fff";
  ctx.font = "120px Times";
  ctx.fillText(text,can.width*0.5-ctx.measureText(text).width*0.5,can.height*0.5+60);
  var data = ctx.getImageData(0,0,can.width,can.height).data;
  cfill();
  for(i = 0;i < data.length;i += 8){
    temp = {x:(i/4)%can.width,y:~~((i/4)/can.width)};
    if(data[i] !== 0 && ~~(Math.random()*5) == 1/*(temp.x % (max_radius+1) === 0 && temp.y % (max_radius+1) === 0)*/){
      if(data[i+4] !== 255 || data[i-4] !== 255 || data[i+can.width*4] !== 255 || data[i-can.width*4] !== 255){
        if(current < particles.length){
          particles[current].set("target",temp);
        }else{
          radius = max_radius-Math.random()*min_radius;
          temp = {x:Math.random()*can.width,y:Math.random()*can.height};
          if(bool){
          	temp = {x:(i/4)%can.width,y:~~((i/4)/can.width)};
          }
          color = colors[~~(Math.random()*colors.length)];
          var p = new Particle(
            temp,
            {x:(i/4)%can.width,y:~~((i/4)/can.width)},{x:0,y:0},
            color,
            radius);
          particles.push(p);
        }
        ++current;
      }
    }
  }
  bool = false;
  particles.splice(current,particles.length-current);
}
function draw(){
  cfill();
 for(i = 0;i < particles.length;++i){
   particles[i].update();
   particles[i].draw();
 } 
}
changeText("www.jq22.com");
setInterval(draw,1);