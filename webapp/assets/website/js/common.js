// JavaScript Document
//网站头部导航js切换
if(document.getElementById("nav")){
var nav = document.getElementById("nav");
var mynav = nav.getElementsByTagName("a");
var menucon = document.getElementById("menu_con").getElementsByTagName("div");

		for(var i = 0;i<mynav.length;i++){
			mynav[i]["index"] = i;
			mynav[i].onmouseover = function(){
				var thisindex = this["index"];
				for(var n = 0;n<menucon.length;n++){
					mynav[n].className="";
					this.className="cn";
					menucon[n].style.display="none";
					menucon[thisindex].style.display="block";
				}
				return false;
			}
		}
}
//尾部友情链接选项卡切换
function selectTag(showContent,selfObj){
	if(document.getElementById("tags1")){
		var tag = document.getElementById("tags1").getElementsByTagName("li");
		var taglength = tag.length;
		for(i=0; i<taglength; i++){
			tag[i].className = "";
		}
		selfObj.className = "cn";
		for(i=0; j=document.getElementById("item_con_"+i); i++){
			j.style.display = "none";
		}
		document.getElementById(showContent).style.display = "block";
	}
}

//政务公开列表页div左右对齐
if(document.getElementById("zwgk_lbox")&&document.getElementById("catList")){
    var zwgkLbox = document.getElementById("zwgk_lbox");
    var zwgkRbox = document.getElementById("catList");
    if (zwgkLbox.offsetHeight >= zwgkRbox.offsetHeight) {
        zwgkRbox.style.height = zwgkLbox.offsetHeight - 2 + "px";
    }
}
//新闻列表5条1线
if(document.getElementById("catList")){
	var Ptr=document.getElementById("catList").getElementsByTagName("li");
		for (i=1;i<Ptr.length+1;i++) {
		Ptr[i-1].className = (i%5>0)?"t1":"t2";
		}
	}
//新闻top10
if(document.getElementById("topnews")){
	var tops = document.getElementById("topnews").getElementsByTagName("span");
	for(i=0; i<tops.length; i++)
	{
		tops[i].innerHTML = i+1;
	}
}

//新闻列表页左右div对齐
if(document.getElementById("lbox")&&document.getElementById("catList")){

    var Lbox = document.getElementById("lbox");
    var Rbox = document.getElementById("catList");
    if (Lbox.offsetHeight >= Rbox.offsetHeight) {
		Rbox.style.height = Lbox.offsetHeight - 42 + "px";
    }
}

//复制标签生成的分页html到id为pageFY里面;先取得最后一个节点，判断节点的类型是否是1（1是node，3是text），如果不是node，则取最后一个节点的前一个节点
if(document.getElementById('pageFY')&&document.getElementById('ulListID')&&document.getElementById('ulListID').getElementsByTagName('div')){
	//var nn = document.getElementById('ulListID').lastChild;
	//if(nn.nodeType!=1)nn=nn.previousSibling;
	var nn = document.getElementById('ulListID').getElementsByTagName('div');
	for(n = 0; n<nn.length;n++)
	{
            if(nn[n].className.indexOf('JYCMS_pagebox')>=0){
                     		document.getElementById('pageFY').innerHTML = nn[n].innerHTML;
                     		var pageYFas = document.getElementById('pageFY').getElementsByTagName("a");
                     		for(k=0;k<pageYFas.length;k++)
                     		{
                     			if(pageYFas[k].innerHTML.indexOf('归档新闻')>=0)
                     			{
                     				pageYFas[k].style.display = 'none';
                     			}
                     		}
                     	}
	}
         	
}
//新闻页左右对齐
/*if(document.getElementById('newsleft')&&document.getElementById('newsright')){
	var newsl = document.getElementById("newsleft");
    var newsr = document.getElementById("newsright");
    if (newsl.offsetHeight <= newsr.offsetHeight) {
        newsl.style.height = newsr.offsetHeight - 2 + "px";
    }
}*/
//景点介绍图文列表左右对齐
if(document.getElementById('LjdIntro')&&document.getElementById('RjdIntro')){
	var jdLeft = document.getElementById("LjdIntro");
    var jdRight = document.getElementById("RjdIntro");
    if (jdLeft.offsetHeight <= jdRight.offsetHeight) {
        jdLeft.style.height = jdRight.offsetHeight - 42 + "px";
    }
}
//景点介绍列表左右对齐
if(document.getElementById('catList')&&document.getElementById('RjdIntro')){
	var jdLeft1 = document.getElementById("catList");
    var jdRight1 = document.getElementById("RjdIntro");
    if (jdLeft1.offsetHeight <= jdRight1.offsetHeight) {
        jdLeft1.style.height = jdRight1.offsetHeight - 42 + "px";
    }
}
//文化特色新闻页左右对齐
if(document.getElementById('whnewsLeft')&&document.getElementById('RjdIntro')){
	var whnewsLeft = document.getElementById("whnewsLeft");
    var whnewsRight = document.getElementById("RjdIntro");
    if (whnewsLeft.offsetHeight <= whnewsRight.offsetHeight) {
        whnewsLeft.style.height = whnewsRight.offsetHeight - 2 + "px";
    }
}
//宜居特色栏目下景点介绍页面左右对齐
if(document.getElementById('yjPicLeft')&&document.getElementById('yjPicRight')){
	var yjPicLeft = document.getElementById("yjPicLeft");
    var yjPicRight = document.getElementById("yjPicRight");
    if (yjPicLeft.offsetHeight <= yjPicRight.offsetHeight) {
        yjPicLeft.style.height = yjPicRight.offsetHeight - 12 + "px";
    }
}
//新闻页如果信息来源为空
if(document.getElementById('sourceid')){
	if(document.getElementById('sourceid').innerHTML=='')
		{
			document.getElementById('sourceid').innerHTML = '枫泾镇官方网站';
		}
	}
//首页公告公示滚动
function addEventSimple(obj,evt,fn){
	if(obj.addEventListener){
		obj.addEventListener(evt,fn,false);
	}else if(obj.attachEvent){
		obj.attachEvent('on'+evt,fn);
	}
}
if(document.getElementById('GGnews')){
addEventSimple(window,'load',initScrolling);
}
var scrollingBox;
var scrollingInterval;
var reachedBottom=false;
var bottom;

function initScrolling(){
	scrollingBox = document.getElementById('GGnews');
	scrollingBox.style.overflow = "hidden";
	scrollingInterval = setInterval("scrolling()",50);
	scrollingBox.onmouseover = over;
	scrollingBox.onmouseout = out; 
}

function scrolling(){
	var origin = scrollingBox.scrollTop++;
	if(origin == scrollingBox.scrollTop){
		if(!reachedBottom){
			scrollingBox.innerHTML+=scrollingBox.innerHTML;
			reachedBottom=true;
			bottom=origin;
		}else{
			scrollingBox.scrollTop=bottom;
		}
	}
}

function over(){
	clearInterval(scrollingInterval);
}
function out(){
	scrollingInterval = setInterval("scrolling()",50);
}

if(document.getElementById('GGnews1')){
//index.html->rigt div position ->6 pictures scroll
var scrollingBox1;
var scrollingInterval1;
var reachedBottom1=false;
var bottom1;

function initScrolling1(){
	scrollingBox1 = document.getElementById('GGnews1');
	scrollingBox1.style.overflow = "hidden";
	scrollingInterval1 = setInterval("scrolling1()",50);
	scrollingBox1.onmouseover = over1;
	scrollingBox1.onmouseout = out1; 
}

function scrolling1(){
	var origin1 = scrollingBox1.scrollTop++;
	if(origin1 == scrollingBox1.scrollTop){
		if(!reachedBottom1){
			scrollingBox1.innerHTML+=scrollingBox1.innerHTML;
			reachedBottom1=true;
			bottom1=origin1;
		}else{
			scrollingBox1.scrollTop=bottom1;
		}
	}
}

function over1(){
	clearInterval(scrollingInterval1);
}
function out1(){
	scrollingInterval1 = setInterval("scrolling1()",50);
}
initScrolling1();
}
//网上办事-服务设施 为当前栏目添加class='cn'
if(document.getElementById('currentLM')){
	var currentContent = document.getElementById('currentLM').innerHTML;
	var servicesA = document.getElementById('serviceFacility').getElementsByTagName('a');
	for(k=0;k<servicesA.length;k++)
	{
		if(servicesA[k].innerHTML.indexOf(currentContent)>=0){
			servicesA[k].parentNode.className = "cn";
			break;
		}
	}
	for(j=0;j<servicesA.length;j++)
	{if(servicesA[j].getAttribute("target"))
		{servicesA[j].target = "_self";}
		}
	
}
//新闻页没有父名称
if(document.getElementById('parentName')){
	if(document.getElementById('parentName').innerHTML==''){
		document.getElementById('parentName').innerHTML='中国·枫泾';
		}
}
//去单篇栏目链接跳新页面
if(document.getElementById("kingnav")){
					var JIYUN = document.getElementById("kingnav").getElementsByTagName("a");
					var JIYUNlength = JIYUN.length;
					for(i=0; i<JIYUNlength; i++)
						{
							if(JIYUN[i].getAttribute("target"))
							{JIYUN[i].target = "_self";}
						}
}
// 导航枫泾首页文字下方公告向上滚动
if(document.getElementById("jsfoot01")){
	var scrollup = new ScrollText("jsfoot01");
	scrollup.LineHeight = 31;        //单排文字滚动的高度
	scrollup.Amount = 1;            //注意:子模块(LineHeight)一定要能整除Amount.
	scrollup.Delay = 20;           //延时
	scrollup.Start();             //文字自动滚动
	scrollup.Direction = "down"; //文字向下滚动
}

//倒计时
var countdown=60;
function settime(obj) {
    if (countdown == 0) {
        obj.removeAttribute("disabled");
        obj.value="免费获取验证码";
        countdown = 60;
        return;
    } else {
        obj.setAttribute("disabled", true);
        obj.value="重新发送(" + countdown + ")";
        countdown--;
    }
    setTimeout(function() {
        settime(obj)},1000)
}


//点赞   author: Xiu
function like(prix, id) {
    var dom = $(prix + " #" + id),
        number = new Number(dom[0].childNodes[1].innerHTML),
        data = {};
    data["targetUserId"] = dom[0].getAttribute("value");
    if (dom.hasClass("unLike")) {
        dom.removeClass("unLike");
        dom.addClass("like");
        dom[0].childNodes[1].innerHTML = number + 1;
        $.ajax({
            type: "POST",
            url: "/backend/Like/like",
            data: data,
            error: function() {
                return false;
            },
            success: function (data) {
                return true;
            }
        });
    } else {
        dom.addClass("unLike");
        dom.removeClass("like");
        dom[0].childNodes[1].innerHTML = number - 1;
        $.ajax({
            type: "POST",
            url: "/backend/Like/unLike",
            data: data,
            error: function() {
                return false;
            },
            success: function (data) {
                return true;
            }
        });
    }
}

//点赞
function guarantee(id) {
    var dom = $("#" + id),
        data = {};
    data["companyId"] = dom[0].getAttribute("value");
    if (dom.hasClass("guarantee")) {
        dom.removeClass("guarantee");
        $.ajax({
            type: "POST",
            url: "/backend/Guarantee/unGuarantee",
            data: data,
            error: function() {
                return false;
            },
            success: function (result) {
                $(".companyGuaranteeList")[0].innerHTML = result;
                return true;
            }
        });
    } else {
        dom.addClass("guarantee");
        $.ajax({
            type: "POST",
            url: "/backend/Guarantee/guarantee",
            data: data,
            error: function() {
                return false;
            },
            success: function (result) {
                $(".companyGuaranteeList")[0].innerHTML = result;
                return true;
            }
        });
    }
}

//评论
function addComment (id) {
    var data = {},
        number = new Number($("#commentNumber")[0].innerHTML);
    $("#commentNumber")[0].innerHTML = number + 1;
    data["content"] = $("#add_comment").val(),
    data["targetId"] = id;
    if (data.content) {
        $.ajax({
            type: "POST",
            url: "/backend/Comment/addComment",
            data: data,
            error: function() {
                return false;
            },
            success: function (result) {
                scrollTo(0,0);
                $("#add_comment").val('')
                $(".people_comments_list")[0].innerHTML = result;
                return true;
            }
        });
    }
}

function addNewJob(e) {
    e.preventDefault();
    $("input[name='businessCategory']").val($('#inputType').val());
    $("input[name='educationRequirement']").val($('#inputEducationRequired').val());

    var form_data = $("#newJobForm").serialize();
    console.log(form_data);
    var url = "/backend/publishJobHistory/add"

    $.ajax({
        type: "POST",
        url: url,
        data: form_data,
        cache: false,
        error: function (request) {
            alert("网络出错啦！");
            return false;
        },
        success: function (data) {
            $('#manageCenterContent').innerHTML = data;
            //window.location.href = "/backend/autobotCompleteResume";
        }
    });
};

function modifyPassword(){
    var form_data={},
        errMsg = $(".errMsg")[0];
    form_data["oldPassword"] = $("#oldpasswd").val(),
    form_data["password"] = $("#newpasswd").val();
    var confirmPsd = $("#confirmPsd").val();
    if(!form_data.oldPassword){
        errMsg.innerHTML = '请输入原始密码';
        return false;
    }
    if(!form_data.password){
        errMsg.innerHTML = '请输入新密码';
        return false;
    }
    if(!confirmPsd){
        errMsg.innerHTML = '请输入确认密码';
        return false;
    }
    if(form_data.password !== confirmPsd){
        errMsg.innerHTML = '请确认新密码';
        return false;
    }
    
    $.ajax({
         type: "POST",
         url: "/backend/userCenter/resetPassword",
         data: form_data,
         error: function(request) {
             errMsg.innerHTML = "网络出错啦！";
             return false;
         },
         success: function (data) {
             errMsg.innerHTML = "密码修改成功!";
         }
    });
}