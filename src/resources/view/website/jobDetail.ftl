<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />

<title>培聘网</title>
    <link rel="stylesheet" href="<@url value="/assets/website/css/pxshi.css"/>" type="text/css" media="screen" />
<link rel="stylesheet" href="<@url value="/assets/website/css/style.css"/>" type="text/css" media="screen" />

<link rel="stylesheet" type="text/css" href="<@url value="/assets/website/css/lrtk.css"/>" />
<script src="<@url value="/assets/website/js/jquery1.42.min.js?v=1.1.0"/>"></script>
<script src="<@url value="/assets/website/js/jquery.superslide.2.1.1.js?v=1.1.0"/>" type="text/javascript"></script>
</head>

<body>
<!-- 头部开始 -->	
<#include "/assets/website/common/header.html">
<!-- 头部结束 -->	

<!-- main开始 -->


<div class="content">
	<#if jobs?? && jobs.company??>
    <div class="ny_zhaopin">
    	<div class="zhaopin_l left">
        	<div class="zp_qy">
            	<div class="zwmc">${jobs.name!}</div>
                <div class="qymc"><span>${jobs.company.autoBrand!}</span><span>当前汽车品牌：</span></div>
            </div>
            <div class="zhaopin_box">
            	<div class="xzdy">
                	<div class="zwdy"><span><img style="border:none;"  name="yp" id="yp" src="http://obu3flkwk.bkt.clouddn.com/website/images/yp_an.jpg" onclick="applyJob('${jobs.id!}')" /></span></div>
               	 	<!--<div class="shoucang">收藏</div>-->
                	<div class="gzdd">
                	<div class="didian left"><#if jobs.region??>${jobs.region.fullname!}</#if></div>
                    <div class="didian left">${jobs.salary!} （元/月）</div>
                    <div class="fb_sj right">${jobs.publishDate!?string("yyyy-MM-dd")}</div>
                    <div class="clear"></div>
                </div>
                	<div class="zwyq">
                	<ul>
                    	<li>${jobs.education!}</li><li><#if jobs.workExprience=0 > 应界毕业生 <#else> ${jobs.workExprience!}年以上经验</#if></li><li>${jobs.languages!?replace(",","+")?replace("[","")?replace("]","")}</li>
                    	<li style="background:none;"></li>
                    </ul>
                    <div class="clear"></div>
                </div>
                	<div class="fldy">
                	<ul>
                		<#if jobs.welfare??>
                        	<#list jobs.welfare as w>
                        	<li>${w!}</li>
                            </#list>
                        </#if>
                    </ul>
                    <div class="clear"></div>
                </div>
                </div>
                <div class="gwms">
                	<h4>岗位描述：</h4>
                    <div class="gwms_box">
                    	${jobs.jobDescription!}
                    </div>
                </div>

                <div class="rzyq">
                	<h4>其他信息：</h4>
                    <div class="rzyq_box">
                    	<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td width="8%">所属部门：</td>
    <td width="42%">${jobs.department!}</td>
    <td width="8%">专业要求：</td>
    <td width="42%">${jobs.major!}</td>
  </tr>
</table>

                  </div>
                </div>
                <div class="qy_intro">
                	<h4>企业简介：</h4>
                    <div class="qy_intro_box">
                    	${jobs.company.intro!}
                    </div>
                </div>
            </div>
        </div>
        <div class="zhaopin_r right">
        	<div class="zwfb_qy">
            	<h4>职位发布企业</h4>
                <div class="qy_box">
                	<div class="qylogo">
                    	<div class="qylogo_l left"><img src="${jobs.company.logo!}" style="width:100px;height:50px;"/></div>
                      <div class="qylogo_r right">
                       	<div class="danbao">已有${jobs.company.bondsmanCount!}人担保</div>
                            <div class="wydb"><a href="#">
                              <input style="border:none;" type="image" name="db" id="db" src="http://obu3flkwk.bkt.clouddn.com/website/images/danbao.jpg" onclick="bondsto('${jobs.company.id!}','${jobs.id!}')" />
                            </a></div>
                      </div>
                        <div class="clear"></div>
                    </div>
                </div>
                <div class="qyjj">
                	<h5>${jobs.company.name!}</h5>
                    <div class="xz"><em style="font-style:normal;  font-size:12px; height:30px; line-height:30px; color:#000; font-weight:700;">经营范围：</em>${jobs.company.industry!}</div>
                    <div class="dz"><em style="font-style:normal;  font-size:12px; height:30px; line-height:30px; color:#000; font-weight:700;">公司地址：</em>${jobs.company.address!}</div>
                    <div class="jj"><em style="font-style:normal;  font-size:12px; height:30px; line-height:30px; color:#000; font-weight:700;">公司简介：</em>${jobs.company.intro!}</div>
                    <div class="jj_img">
                    	<!-- 代码 开始 -->
						<div class="www51buycom">
    <ul class="51buypic">
        <li><a href="#" target="_blank"><img src="${jobs.company.environmentURL1!}" style="width:260px;height:170px;"/></a></li>
       <li><a href="#" target="_blank"><img src="${jobs.company.environmentURL2!}" style="width:260px;height:170px;"/></a></li>
        
    </ul>
   
    <div class="num">
    	<ul></ul>
    </div>
</div>
						<script>
/*鼠标移过，左右按钮显示*/
$(".www51buycom").hover(function(){
	$(this).find(".prev,.next").fadeTo("show",0.1);
},function(){
	$(this).find(".prev,.next").hide();
})
/*鼠标移过某个按钮 高亮显示*/
$(".prev,.next").hover(function(){
	$(this).fadeTo("show",0.7);
},function(){
	$(this).fadeTo("show",0.1);
})
$(".www51buycom").slide({ titCell:".num ul" , mainCell:".51buypic" , effect:"fold", autoPlay:true, delayTime:700 , autoPage:true });
</script>
						<!-- 代码 结束 -->
                    </div>
                </div>
            </div>
            <div class="dbr">
            	<h4>担保人列表</h4>
            <#if bondsmanList??>
                <div class="dbr_box">
                	<ul>
                   	  <#list bondsmanList as b>
                   	  <#if b??>
                      	<li>
                        	<div class="dbr_l left"><a href="#"><img src="${b.headLogo!}" style="width:58;height:63px;"/></a></div>
                          <div class="dbr_r right">
                            	<div class="dbr_name"><a href="#">${b.name!}</a></div>
                          </div>
                            <div class="clear"></div>
                        </li>
                        </#if>
                        </#list>
                    </ul>
                </div>
                </#if>
            </div>
        </div>
        <div class="clear"></div>
    </div>
    </#if>
</div>
<script>

function applyJob(jid){
if(confirm("确定要申请该职位吗?")){
var form_data={};
var jid = jid;

if(jid==''||jid==null){
	alert('您申请的职位已不存在');
	return false;
}

form_data.jid = jid;

$.ajax({
	 type: "POST",
     url: "/website/jobDetail/apply",
     data: form_data,
     error: function(request) {
         showErrMsg("网络出错啦！");
         return false;
     },
     success: function (data) {
			 showErrMsg("恭喜您,您已申请成功了！");
		 	setTimeout(function(){
		 		if(jid==''||jid==null){
     	 			window.location.href = "/website/jobDetail?jobs.id=jid";
     	 			}
     	 		},300);

     }
});
}else{
	return false;
}
}
    
function bondsto(cid,jid){ 
if(confirm("确定要为该公司担保吗?")){
var form_data={};
var cid = cid;
var jid = jid;
if(cid==''||cid==null){
	alert('该公司已不存在');
	return false;
}

form_data.cid = cid;

$.ajax({
	 type: "POST",
     url: "/website/jobDetail/bondsman",
     data: form_data,
     error: function(request) {
         showErrMsg("网络出错啦！");
         return false;
     },
     success: function (data) {
			 showErrMsg("恭喜您,您已成为该公司的担保人！");
			 setTimeout(function(){
		 		if(jid==''||jid==null){
     	 			window.location.href = "/website/jobDetail?jobs.id=jid";
     	 			}
     	 		},300);

     }
});
}else{
	return false;
}
}
function showErrMsg(errMsg){
	alert(errMsg);
}
</script>
<!-- main结束 -->
<#include "/assets/website/common/footer.html">
</body>
</html>
