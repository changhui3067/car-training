<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />

<title>培聘网</title>
<link rel="stylesheet" href="<@url value="/assets/website/css/gkk.css"/>" type="text/css" media="screen" />
    <link rel="stylesheet" href="<@url value="/assets/website/css/style.css"/>" type="text/css" media="screen" />
</head>

<body>
<!-- 头部开始 -->	
<#include "/assets/website/common/header.html">
<!-- 头部结束 -->	

<!-- main开始 -->


<div class="content">
	<#if course?? && course.trainer??  && course.trainer.userCenter??>
	<div class="ny_pxshi">
    	<div class="ny_pxshi_l left">
        	<div class="pxshi_xx">
            	<div class="zhaopian left">
            		<#if course.trainer.userCenter??>
                	<img src="${course.trainer.userCenter.headLogo!}" />
                	</#if>
                </div>
                <div class="xinxi right">
                	<div class="mingzi">
                    	<div class="mingzi_l left">${course.courseName!}</div>
                    	<!--<div class="mingzi_r right">
                       	  <div class="pinglun left"><a href="#"><img src="http://obu3flkwk.bkt.clouddn.com/website/images/bm.jpg" /></a></div>
                       	  <div class="guanzhu right"><a href="#"><img src="http://obu3flkwk.bkt.clouddn.com/website/images/cg.jpg" /></a></div>
                        </div>-->
                        <div class="clear"></div>
                    </div>
                    
                    <div class="scxs2">
                    <em>课程类型：</em><span>销售</span><span>产品</span><span>非技术</span><span>技术</span><span>管理</span><span style=" background:none;">财务</span>
                    </div>
                    
                    <div class="shijian">
                  		<div class="shijian_l left"><em>价 格：</em><font color="#FF0000">${course.price!}元</font></div>
                        <div class="shijian_r  right"><em>时 长：</em><font color="#FF0000">${course.longTime!}小时</font></div>
                        <div class="clear"></div>

                    </div>
                    <div class="shijian">
                  		<div class="shijian_l left"><em>上课时间：</em>${course.schoolTime!}</div>
                        <div class="shijian_r  right"><em>上课地点：</em><#if course.region??>${course.region.fullname!}</#if></div>
                        <div class="clear"></div>

                    </div>
                </div>
                <div class="clear"></div>
            </div>
            <div class="kcsz">
            	<div class="pxshi_bt">
            	<h4>课程受众</h4>
                </div>
            	<div class="kcsz_box">
               	${course.audiences!}
                </div>
            </div>
            <div class="kcdg">
            	<div class="pxshi_bt">
            	<h4>课程目标</h4>
                </div>
                <div class="kcdg_box">
	                ${course.courseTarget!}
                </div>
            </div>
            
            <div class="gjmx">
            	<div class="pxshi_bt">
            	<h4>工具模型</h4>
                </div>
                <div class="gjmx_box">
                	 ${course.toolModel!}
                </div>
          </div>
            <div class="xueyuan_pj">
            	<div class="pxshi_bt">
            	<h4>学员课后评价</h4>
                </div>
                <div class="xueyuan_pj_box">
 <table width="100%" border="0" cellspacing="0" cellpadding="0">
 <tr>
   <td width="6%" height="50" align="left" valign="middle">打分：</td>
   <td width="94%" colspan="2" align="left" valign="middle"><table width="300" border="0" cellspacing="0" cellpadding="0">
     <tr>
       <td width="73"><font color="#cccccc">内容设计</font></td>
       <td width="227"><div>
		<a href="javascript:click(1)"><img src="http://obu3flkwk.bkt.clouddn.com/website/images/star.png" id="star1" onMouseOut="out(1)"/></a>
		<a href="javascript:click(2)"><img src="http://obu3flkwk.bkt.clouddn.com/website/images/star.png" id="star2" onMouseOut="out(2)" /></a>
		<a href="javascript:click(3)"><img src="http://obu3flkwk.bkt.clouddn.com/website/images/star.png" id="star3" onMouseOut="out(3)" /></a>
		<a href="javascript:click(4)"><img src="http://obu3flkwk.bkt.clouddn.com/website/images/star.png" id="star4" onMouseOut="out(4)"/></a>
		<a href="javascript:click(5)"><img src="http://obu3flkwk.bkt.clouddn.com/website/images/star.png" id="star5" onMouseOut="out(5)"/></a>
		<span id="message"></span>
	</div></td>
     </tr>
   </table></td>
   </tr>
<tr>
   <td height="50" align="left" valign="middle">&nbsp;</td>
   <td colspan="2" align="left" valign="middle"><table width="300" border="0" cellspacing="0" cellpadding="0">
     <tr>
       <td width="73"><font color="#cccccc">上课气氛</font></td>
       <td width="227"><div>
		<a href="javascript:click1(11)"><img src="http://obu3flkwk.bkt.clouddn.com/website/images/star.png" id="star11"  onMouseOut="out1(11)"/></a>
		<a href="javascript:click1(12)"><img src="http://obu3flkwk.bkt.clouddn.com/website/images/star.png" id="star12"  onMouseOut="out1(12)" /></a>
		<a href="javascript:click1(13)"><img src="http://obu3flkwk.bkt.clouddn.com/website/images/star.png" id="star13"  onMouseOut="out1(13)" /></a>
		<a href="javascript:click1(14)"><img src="http://obu3flkwk.bkt.clouddn.com/website/images/star.png" id="star14"  onMouseOut="out1(14)"/></a>
		<a href="javascript:click1(15)"><img src="http://obu3flkwk.bkt.clouddn.com/website/images/star.png" id="star15"  onMouseOut="out1(15)"/></a>
		<span id="message1"></span>
	</div></td>
     </tr>
   </table></td>
   </tr>
 <tr>
   <td height="50" align="left" valign="middle">&nbsp;</td>
   <td colspan="2" align="left" valign="middle"><table width="300" border="0" cellspacing="0" cellpadding="0">
     <tr>
       <td width="73"><font color="#cccccc">上课气氛</font></td>
       <td width="227"><div>
		<a href="javascript:click2(21)"><img src="http://obu3flkwk.bkt.clouddn.com/website/images/star.png" id="star21" onMouseOut="out2(21)"/></a>
		<a href="javascript:click2(22)"><img src="http://obu3flkwk.bkt.clouddn.com/website/images/star.png" id="star22" onMouseOut="out2(22)" /></a>
		<a href="javascript:click2(23)"><img src="http://obu3flkwk.bkt.clouddn.com/website/images/star.png" id="star23" onMouseOut="out2(23)" /></a>
		<a href="javascript:click2(24)"><img src="http://obu3flkwk.bkt.clouddn.com/website/images/star.png" id="star24" onMouseOut="out2(24)"/></a>
		<a href="javascript:click2(25)"><img src="http://obu3flkwk.bkt.clouddn.com/website/images/star.png" id="star25" onMouseOut="out2(25)"/></a>
		<span id="message2"></span>
	</div></td>
     </tr>
   </table></td>
   </tr>
  <tr>
    <td colspan="3" align="center" valign="middle"><table width="90%" border="0" align="left" cellpadding="0" cellspacing="0">
      <tr>
        <td width="7%">评语：</td>
        <td width="93%" align="left" valign="middle"><textarea name="textarea" id="textarea" style="width:500px; height:100px;"></textarea></td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td height="75" colspan="3" align="center" valign="bottom"><input type="image" name="tj" id="tj" src="http://obu3flkwk.bkt.clouddn.com/website/images/tj.jpg" /></td>
  </tr>
</table>

              </div>
          </div>
        </div>
        <div class="ny_pxshi_r right">
        	<div class="pxshi_lx">
            	<h4>联系方式</h4>
                <div class="lx_box">
                	<div class="xingming">${course.trainer.userCenter.name!}(培训师本人)</div>
                    电话：${course.trainer.userCenter.mobile!}<br />
                    邮箱：${course.trainer.userCenter.email!}<br />
<!--QQ：${course.trainer.userCenter.QQ!}<br />
微信：${course.trainer.userCenter.weixin!}<br />
<br />-->
                </div>
            </div>
            <div class="pxshi_pj">
            	<h4>学员评价</h4>
                <div class="pj_box">
                <#if course.trainer.autobotsCommentList??>
                	<ul>
                		<#list course.trainer.autobotsCommentList as t>
                		<#if t?? && t.content>
                    	<li><a href="#"><#if  t.content?length lt 19>${t.content!}<#else>${t.content?substring(18)!}...</#if></a></li>
                    	</#if>
                        </#list>
                    </ul>
                </#if> 
                </div>
            </div>
        </div>
        <div class="clear"></div>
    </div>
    </#if>
</div>
    
<!-- main结束 -->
<#include "/assets/website/common/footer.html">
</body>
<script type="text/javascript">
var check = 0;//该变量是记录当前选择的评分
var time = 0;//该变量是统计用户评价的次数，这个是我的业务要求统计的（改变评分不超过三次），可以忽略

/*over()是鼠标移过事件的处理方法*/

/*out 方法是鼠标移除事件的处理方法，当鼠标移出时，恢复到我的打分情况*/
function out(){
	if(check == 1){//打分是1，设置第一颗星星亮，其他星星暗，其他情况以此类推
		$("#star1").attr("src","http://obu3flkwk.bkt.clouddn.com/website/images/star_red.png");
		$("#star2").attr("src","http://obu3flkwk.bkt.clouddn.com/website/images/star.png");
		$("#star3").attr("src","http://obu3flkwk.bkt.clouddn.com/website/images/star.png");
		$("#star4").attr("src","http://obu3flkwk.bkt.clouddn.com/website/images/star.png");
		$("#star5").attr("src","http://obu3flkwk.bkt.clouddn.com/website/images/star.png");
		$("#message").html("1分");
	}else if(check == 2){
		$("#star1").attr("src","http://obu3flkwk.bkt.clouddn.com/website/images/star_red.png");
		$("#star2").attr("src","http://obu3flkwk.bkt.clouddn.com/website/images/star_red.png");
		$("#star3").attr("src","http://obu3flkwk.bkt.clouddn.com/website/images/star.png");
		$("#star4").attr("src","http://obu3flkwk.bkt.clouddn.com/website/images/star.png");
		$("#star5").attr("src","http://obu3flkwk.bkt.clouddn.com/website/images/star.png");
		$("#message").html("2分");
	}else if(check == 3){
		$("#star1").attr("src","http://obu3flkwk.bkt.clouddn.com/website/images/star_red.png");
		$("#star2").attr("src","http://obu3flkwk.bkt.clouddn.com/website/images/star_red.png");
		$("#star3").attr("src","http://obu3flkwk.bkt.clouddn.com/website/images/star_red.png");
		$("#star4").attr("src","http://obu3flkwk.bkt.clouddn.com/website/images/star.png");
		$("#star5").attr("src","http://obu3flkwk.bkt.clouddn.com/website/images/star.png");
		$("#message").html("3分");
	}else if(check == 4){
		$("#star1").attr("src","http://obu3flkwk.bkt.clouddn.com/website/images/star_red.png");
		$("#star2").attr("src","http://obu3flkwk.bkt.clouddn.com/website/images/star_red.png");
		$("#star3").attr("src","http://obu3flkwk.bkt.clouddn.com/website/images/star_red.png");
		$("#star4").attr("src","http://obu3flkwk.bkt.clouddn.com/website/images/star_red.png");
		$("#star5").attr("src","http://obu3flkwk.bkt.clouddn.com/website/images/star.png");
		$("#message").html("4分");
	}else if(check == 5){
		$("#star1").attr("src","http://obu3flkwk.bkt.clouddn.com/website/images/star_red.png");
		$("#star2").attr("src","http://obu3flkwk.bkt.clouddn.com/website/images/star_red.png");
		$("#star3").attr("src","http://obu3flkwk.bkt.clouddn.com/website/images/star_red.png");
		$("#star4").attr("src","http://obu3flkwk.bkt.clouddn.com/website/images/star_red.png");
		$("#star5").attr("src","http://obu3flkwk.bkt.clouddn.com/website/images/star_red.png");
		$("#message").html("5分");
	}else if(check == 0){
		$("#star1").attr("src","http://obu3flkwk.bkt.clouddn.com/website/images/star.png");
		$("#star2").attr("src","http://obu3flkwk.bkt.clouddn.com/website/images/star.png");
		$("#star3").attr("src","http://obu3flkwk.bkt.clouddn.com/website/images/star.png");
		$("#star4").attr("src","http://obu3flkwk.bkt.clouddn.com/website/images/star.png");
		$("#star5").attr("src","http://obu3flkwk.bkt.clouddn.com/website/images/star.png");
		$("#message").html("");
	}
}
function out1(){
	if(check == 11){//打分是1，设置第一颗星星亮，其他星星暗，其他情况以此类推
		$("#star11").attr("src","http://obu3flkwk.bkt.clouddn.com/website/images/star_red.png");
		$("#star12").attr("src","http://obu3flkwk.bkt.clouddn.com/website/images/star.png");
		$("#star13").attr("src","http://obu3flkwk.bkt.clouddn.com/website/images/star.png");
		$("#star14").attr("src","http://obu3flkwk.bkt.clouddn.com/website/images/star.png");
		$("#star15").attr("src","http://obu3flkwk.bkt.clouddn.com/website/images/star.png");
		$("#message1").html("1分");
	}else if(check == 12){
		$("#star11").attr("src","http://obu3flkwk.bkt.clouddn.com/website/images/star_red.png");
		$("#star12").attr("src","http://obu3flkwk.bkt.clouddn.com/website/images/star_red.png");
		$("#star13").attr("src","http://obu3flkwk.bkt.clouddn.com/website/images/star.png");
		$("#star14").attr("src","http://obu3flkwk.bkt.clouddn.com/website/images/star.png");
		$("#star15").attr("src","http://obu3flkwk.bkt.clouddn.com/website/images/star.png");
		$("#message1").html("2分");
	}else if(check == 13){
		$("#star11").attr("src","http://obu3flkwk.bkt.clouddn.com/website/images/star_red.png");
		$("#star12").attr("src","http://obu3flkwk.bkt.clouddn.com/website/images/star_red.png");
		$("#star13").attr("src","http://obu3flkwk.bkt.clouddn.com/website/images/star_red.png");
		$("#star14").attr("src","http://obu3flkwk.bkt.clouddn.com/website/images/star.png");
		$("#star15").attr("src","http://obu3flkwk.bkt.clouddn.com/website/images/star.png");
		$("#message1").html("3分");
	}else if(check == 14){
		$("#star11").attr("src","http://obu3flkwk.bkt.clouddn.com/website/images/star_red.png");
		$("#star12").attr("src","http://obu3flkwk.bkt.clouddn.com/website/images/star_red.png");
		$("#star13").attr("src","http://obu3flkwk.bkt.clouddn.com/website/images/star_red.png");
		$("#star14").attr("src","http://obu3flkwk.bkt.clouddn.com/website/images/star_red.png");
		$("#star15").attr("src","http://obu3flkwk.bkt.clouddn.com/website/images/star.png");
		$("#message1").html("4分");
	}else if(check == 15){
		$("#star11").attr("src","http://obu3flkwk.bkt.clouddn.com/website/images/star_red.png");
		$("#star12").attr("src","http://obu3flkwk.bkt.clouddn.com/website/images/star_red.png");
		$("#star13").attr("src","http://obu3flkwk.bkt.clouddn.com/website/images/star_red.png");
		$("#star14").attr("src","http://obu3flkwk.bkt.clouddn.com/website/images/star_red.png");
		$("#star15").attr("src","http://obu3flkwk.bkt.clouddn.com/website/images/star_red.png");
		$("#message1").html("5分");
	}else if(check == 0){
		$("#star11").attr("src","http://obu3flkwk.bkt.clouddn.com/website/images/star.png");
		$("#star12").attr("src","http://obu3flkwk.bkt.clouddn.com/website/images/star.png");
		$("#star13").attr("src","http://obu3flkwk.bkt.clouddn.com/website/images/star.png");
		$("#star14").attr("src","http://obu3flkwk.bkt.clouddn.com/website/images/star.png");
		$("#star15").attr("src","http://obu3flkwk.bkt.clouddn.com/website/images/star.png");
		$("#message1").html("");
	}
}
function out2(){
	if(check == 21){//打分是1，设置第一颗星星亮，其他星星暗，其他情况以此类推
		$("#star21").attr("src","http://obu3flkwk.bkt.clouddn.com/website/images/star_red.png");
		$("#star22").attr("src","http://obu3flkwk.bkt.clouddn.com/website/images/star.png");
		$("#star23").attr("src","http://obu3flkwk.bkt.clouddn.com/website/images/star.png");
		$("#star24").attr("src","http://obu3flkwk.bkt.clouddn.com/website/images/star.png");
		$("#star25").attr("src","http://obu3flkwk.bkt.clouddn.com/website/images/star.png");
		$("#message2").html("1分");
	}else if(check == 22){
		$("#star21").attr("src","http://obu3flkwk.bkt.clouddn.com/website/images/star_red.png");
		$("#star22").attr("src","http://obu3flkwk.bkt.clouddn.com/website/images/star_red.png");
		$("#star23").attr("src","http://obu3flkwk.bkt.clouddn.com/website/images/star.png");
		$("#star24").attr("src","http://obu3flkwk.bkt.clouddn.com/website/images/star.png");
		$("#star25").attr("src","http://obu3flkwk.bkt.clouddn.com/website/images/star.png");
		$("#message2").html("2分");
	}else if(check == 23){
		$("#star21").attr("src","http://obu3flkwk.bkt.clouddn.com/website/images/star_red.png");
		$("#star22").attr("src","http://obu3flkwk.bkt.clouddn.com/website/images/star_red.png");
		$("#star23").attr("src","http://obu3flkwk.bkt.clouddn.com/website/images/star_red.png");
		$("#star24").attr("src","http://obu3flkwk.bkt.clouddn.com/website/images/star.png");
		$("#star25").attr("src","http://obu3flkwk.bkt.clouddn.com/website/images/star.png");
		$("#message2").html("3分");
	}else if(check == 24){
		$("#star21").attr("src","http://obu3flkwk.bkt.clouddn.com/website/images/star_red.png");
		$("#star22").attr("src","http://obu3flkwk.bkt.clouddn.com/website/images/star_red.png");
		$("#star23").attr("src","http://obu3flkwk.bkt.clouddn.com/website/images/star_red.png");
		$("#star24").attr("src","http://obu3flkwk.bkt.clouddn.com/website/images/star_red.png");
		$("#star25").attr("src","http://obu3flkwk.bkt.clouddn.com/website/images/star.png");
		$("#message2").html("4分");
	}else if(check == 25){
		$("#star21").attr("src","http://obu3flkwk.bkt.clouddn.com/website/images/star_red.png");
		$("#star22").attr("src","http://obu3flkwk.bkt.clouddn.com/website/images/star_red.png");
		$("#star23").attr("src","http://obu3flkwk.bkt.clouddn.com/website/images/star_red.png");
		$("#star24").attr("src","http://obu3flkwk.bkt.clouddn.com/website/images/star_red.png");
		$("#star25").attr("src","http://obu3flkwk.bkt.clouddn.com/website/images/star_red.png");
		$("#message2").html("5分");
	}else if(check == 0){
		$("#star21").attr("src","http://obu3flkwk.bkt.clouddn.com/website/images/star.png");
		$("#star22").attr("src","http://obu3flkwk.bkt.clouddn.com/website/images/star.png");
		$("#star23").attr("src","http://obu3flkwk.bkt.clouddn.com/website/images/star.png");
		$("#star24").attr("src","http://obu3flkwk.bkt.clouddn.com/website/images/star.png");
		$("#star25").attr("src","http://obu3flkwk.bkt.clouddn.com/website/images/star.png");
		$("#message2").html("");
	}
}
/*click()点击事件处理，记录打分*/
function click(param){
	time++;//记录打分次数
	check = param;//记录当前打分
	out();//设置星星数
}

function click1(param){
	time++;//记录打分次数
	check = param;//记录当前打分
	out1();//设置星星数
}
function click2(param){
	time++;//记录打分次数
	check = param;//记录当前打分
	out2();//设置星星数
}
</script>
</html>
