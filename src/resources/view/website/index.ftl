<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<#escape x as x?html><html>
<head>
    <title>培聘网</title>
    <link rel="stylesheet" href="<@url value="/assets/website/css/style.css?v=1.1.0"/>" type="text/css" media="screen" />
    <link rel="stylesheet" href="<@url value="/assets/website/css/bootstrap.min.css?v=1.1.0"/>" type="text/css" media="screen" />
    <script src="<@url value="/assets/website/js/jquery-3.1.1.min.js?v=1.1.0"/>"></script>
    <script src="<@url value="/assets/website/js/bootstrap.min.js?v=1.1.0"/>"></script>
</head>

<body>
    <!-- 头部开始 -->   
    <#include "/assets/website/common/header.html">
    <!-- 头部结束 -->   
    <!-- banner开始 -->   
    <div class="banner">
        <#if '{}' == '${session}'|| Session["loginState"]!='Y' >
        <div class="content">
            <div class="login-box">
                <form action="" id="loginform" class="form-horizontal">
                <input type="hidden" name="targetUrl" value=${targetUrl!} />
                <div class="dot-line">会员登录</div>
                <div class="form-group">
                    <label  class="col-sm-3 control-label">账号：</label>
                    <div class="col-sm-9">
                        <input class="form-control text-size" type="email" id="username" name="username" data-nick="login_user" value="" placeholder="请输入邮箱/手机号" required validate-title="邮箱/手机号" />
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-3 control-label">密码：</label>
                    <div class="col-sm-9">
                        <input class="form-control text-size" type="password" name="password" id="password" data-nick="login_pwd" value=""   placeholder="请输入6-16位字母、数字" required validate-title="密码" /></div>
                    </div>
                <div class="errMsg"></div>
                <div id="checkeRadio">
                    <label class="radio-inline col-sm-5"> 
                        <input name="userType" id="userType" type="radio"  value="PERSONAL" checked/>个人
                    </label>
                    <label class="radio-inline col-sm-6">
                        <input type="radio" name="userType" id="userType" value="COMPANY" />企业
                    </label>
                </div>
                <div><img src="http://obu3flkwk.bkt.clouddn.com/website/images/dl_bg.jpg" onClick='javascript:login();' /></div>
            </div>
        </div>
    <#else>
</#if>
</div>
<!-- banner结束 -->
<!-- main开始 -->

<div class="main">
   <div class="content">
     <div class="pxshi_box">
         <h4><span><a href="#">更多>></a></span>推荐培训师</h4>
         <div class="pxshi">
             <div class="pxshi_l left">
               <#if trainer?? && trainer.userCenter??>
               <div class="pxshi_l_pic"><a href="/website/trainerDetail?trainer.id=${trainer.id!}"><img src="${trainer.userCenter.headLogo!}" /></a></div>
               <div class="pxshi_l_intro">
                 <div class="pxshi_name">
                     <div class="xm left">${trainer.userCenter.name!}</div>
                     <div class="pl left"><#if trainer.autobotsCommentList??> ${trainer.autobotsCommentList.size!}<#else>0</#if>人<span>评论</span></div>
                     <div class="dz right"><a href='#'>${trainer.starLevel!}</a></div>
                     <div class="clear"></div>
                 </div>
                 <div class="pxshi_zp">${trainer.currentPosition!} </div>
                 <div class="pxshi_rz">
                     <ul>
                            	<li><img src="http://obu3flkwk.bkt.clouddn.com/website/images/hot.jpg" /></li>
                                <li><img src="http://obu3flkwk.bkt.clouddn.com/website/images/zan.jpg" /></li>
                                <li><img src="http://obu3flkwk.bkt.clouddn.com/website/images/zheng.jpg" /></li>
                                <li><img src="http://obu3flkwk.bkt.clouddn.com/website/images/xin.jpg" /></li>
                                <li><img src="http://obu3flkwk.bkt.clouddn.com/website/images/zishen.jpg" /></li>
                                <li><img src="http://obu3flkwk.bkt.clouddn.com/website/images/dav.jpg" /></li>
                     </ul>
                 </div>
             </div>
             </#if>
         </div>
         <div class="pxshi_r right">
          <#if trainerList??>
          <ul>
           <#list trainerList as t>
           <li>
              <#if t?? && t.userCenter??>
              <div class="pxshi_pic2"><a href="/website/trainerDetail?trainer.id=${t.id!}"><img src="${t.userCenter.headLogo!}" /></a></div>
              <div class="pxshi_intro2">
                <div class="pxshi_name2">
                    <div class="xm2 left">${t.userCenter.name!}</div>
                    <div class="pl2 left"><#if t.autobotsCommentList??> ${t.autobotsCommentList.size!}<#else>0</#if>人<span>评论</span></div>
                    <div class="dz2 right">${t.starLevel!}</div>
                    <div class="clear"></div>
                </div>
                <div class="pxshi_zp2">${t.currentPosition!} </div>
                <div class="rz2">
                    <span><img src="http://obu3flkwk.bkt.clouddn.com/website/images/hot.jpg" /></span>
                    <span><img src="http://obu3flkwk.bkt.clouddn.com/website/images/zan.jpg" /></span>
                    <span><img src="http://obu3flkwk.bkt.clouddn.com/website/images/zheng.jpg" /></span>
                    <span><img src="http://obu3flkwk.bkt.clouddn.com/website/images/xin.jpg" /></span>
                    <span><img src="http://obu3flkwk.bkt.clouddn.com/website/images/zishen.jpg" /></span>
                    <span><img src="http://obu3flkwk.bkt.clouddn.com/website/images/dav.jpg" /></span>
                </div>
            </div>
            </#if>
        </li>

        </#list>
    </ul>
    </#if>
</div>
<div class="clear"></div>
</div>
</div>
<div class="pxsheng_box">
 <h4><span><a href="#">更多>></a></span>推荐培训生</h4>
 <div class="pxsheng">
     <#if autobotsList??>
     <ul>
         <#list autobotsList as t>
         <li>
             <#if t?? && t.userCenter??>
             <div class="pxsheng_pic"><a href="/website/autobotDetail?autobots.id=${t.id!}"><img src="${t.userCenter.headLogo!}" /></a></div>
             <div class="pxsheng_intro">
                 <div class="pxsheng_name">
                     <div class="pxsheng_xm left">${t.userCenter.name!}</div>
                     <!--<div class="pxsheng_pl right">34人<span>评论</span></div>-->

                     <div class="clear"></div>
                 </div>
                 <div class="pxsheng_zw">
                     <div class="pxsheng_zw_l left">${t.currentPosition!}</div>
                     <div class="pxsheng_zw_r  right">工作经验${t.autoYears!}年</div>
                     <div class="clear"></div>
                 </div>
                 <div class="pxsheng_rz">
                        	<span><img src="http://obu3flkwk.bkt.clouddn.com/website/images/hot2.jpg" /></span>
                            <span><img src="http://obu3flkwk.bkt.clouddn.com/website/images/yrz.jpg" /></span>
                            <span><img src="http://obu3flkwk.bkt.clouddn.com/website/images/dr.jpg" /></span>
                            <span><img src="http://obu3flkwk.bkt.clouddn.com/website/images/zs.jpg" /></span>

                 </div>
             </div>
             </#if>
         </li>
         </#list>
     </ul>
     </#if>
 </div>
</div>
<div class="pxxq_box">
 <h4><span><a href="#">更多>></a></span>培训需求</h4>
 <div class="pxxq">
     <#if jobsTrainerList??>
     <ul>
         <#list jobsTrainerList as t>
         <li>
             <#if t?? && t.company??>
             <div class="qz"></div> <div class="pxxq_l left">
             <a href="/website/jobDetail?jobs.id=${t.id!}"> <div class="zw_name">${t.name!}</div></a>
             <div class="dy_box">
                        	<span class="cn" style="padding-left:0px;">${t.salary!}</span><span>${t.workExprience!}年工作经验</span><span style="background:none;"><#if t.region??>${t.region.fullname!}</#if></span>
             </div>
             <div class="fb_box">
                        	<span  style="padding-left:0px;">发布于：${t.publishDate!?string("yyyy-MM-dd")}</span><span style="background:none;">投递后：48小时反馈</span>
             </div>
         </div>
         <div class="pxxq_r right">
          <div class="qy">
                          <a href="/website/autoCompany?company.id=${t.company.id!}">
                              <div class="qy_l left"><img src="${t.company.logo!}" style="width:100px;height:50px;"/></div>
                              <div class="qy_r right">
                                  <div class="qy_name">
                                      <span>已有${t.company.bondsmanCount}人担保</span>
                                      <span>${t.company.name!}</span>
                                  </div>
                                  <div class="jyfw">${t.company.industry!}</div>
                              </div>
                          </a>
                          <div class="clear"></div>
                      </div>
         <div class="fl">
            <#if t.welfare??>
            <#list t.welfare as w>
                        	<span>${w!}</span>
            </#list>
            </#if>
        </div>
    </div>
    <div class="clear"></div>

    </#if>
</li>
</#list>
</ul>
</#if>
</div>
</div>
<div class="qcrxq_box">
 <h4><span><a href="#">更多>></a></span>汽车人需求</h4>
 <div class="qcrxq">
     <#if jobsAutobotsList??>
     <ul>
         <#list jobsAutobotsList as t>
         <li>
             <#if t?? && t.company??>
             <div class="qcrxq_l left">
                        	 <a href="/website/jobDetail?jobs.id=${t.id!}"><div class="qcrxq_zw_name">${t.name!}</div></a>
              <div class="qcrxq_dy_box">
                                 <span class="cn" style="padding-left:0px;">${t.salary!}</span>
                                 <span>${t.workExprience!}年工作经验</span>
                                 <span style="background:none;">上海-嘉定区</span>
                             </div>
                            <div class="pingpai">
                                <em>当前汽车品牌：</em><span>宝马</span><span>宝马</span>
                                <div class="clear"></div>
                            </div>

                            <div class="qcrxq_fb_box">
                                <span  style="padding-left:0px;">发布于：${t.publishDate!?string("yyyy-MM-dd")}</span>
                                <span style="background:none;">投递后：48小时反馈 </span>
         </div>
     </div>

     <div class="qcrxq_r right">
      <div class="qcrxq_qy">
                          <a href="/website/autoCompany?company.id=${t.company.id!}">
                              <div class="qcrxq_qy_l left"><img src="${t.company.logo!}" style="width:100px;height:50px;"/></div>
                              <div class="qcrxq_qy_r right">
                            	<div class="qcrxq_qy_name">
                                    <span>已有${t.company.bondsmanCount}人担保</span>
                                    <span>${t.company.name!}</span></div>
                                <div class="qcrxq_jyfw">${t.company.industry!}</div>
         </div>
         <div class="clear"></div>
     </div>
     <div class="qcrxq_fl">
         <#if t.welfare??>
         <#list t.welfare as w>
                        	<span>${w!}</span>
         </#list>
         </#if>
     </div>
 </div>
 <div class="clear"></div>
 </#if>
</li>
</#list>
</ul>
</#if>
</div>
</div>
<div class="art_box">
 <!--<div class="ycwz left">
     <h4><span><a href="#">更多>></a></span>原创文章</h4>
     <div class="ycwz_box">
         <#if trainerEssayList??>
         <ul>
             <#list trainerEssayList as t>
             <li>
                 <#if t??>
                 <span><a href="#">${t.publishDate!?string("yyyy-MM-dd")}</a></span><a href="/website/trainerEssayDetail?trainerEssay.id=${t.id!}">${t.title!}</a>
                 </#if>
             </li>
             </#list>
         </ul>
         </#if>
     </div>
 </div>-->
 <div class="yiti left">
     <h4><span><a href="#">更多>></a></span>培训学院热点议题</h4>
     <div class="yiti_box">
         <#if topicList??>
         <ul>
             <#list topicList as t>
             <li>
                 <#if t??>
                 <span><a href="#">${t.publishDate?string("yyyy-MM-dd")}</a></span><a href="/website/topicDetail?topic.id=${t.id!}">${t.title!}</a>
                 </#if>
             </li>
             </#list>
         </ul>
         </#if>
     </div>
 </div>

 <div class="gkk right">
     <h4><span><a href="#">更多>></a></span>公开课</h4>
     <div class="gkk_box">
       <#if coursesList??>
       <ul>
          <#list coursesList as t>
          <li>
             <#if t?? && t.trainer ?? &&t.trainer.userCenter ?? >
             <div class="sy_gkk_pic"><a href="/website/courseDetail?course.id=${t.id!}"><img src="${t.trainer.userCenter.headLogo!}" /></a></div>
             <div class="sy_gkk_intro">
                 <div class="sy_gkk_name">
                     <div class="sy_gkk_xm"><a href="/website/courseDetail?course.id=${t.id!}">${t.courseName!}</a></div>

                     <div class="clear"></div>
                 </div>
                 <div class="sy_gkk_zw">
                     <div class="sy_gkk_zw_l left"><#if t.region??></#if>${t.region.fullname!}</div>
                     <div class="sy_gkk_zw_r  right">2016-6-18</div>
                     <div class="clear"></div>
                 </div>
                 <div class="sy_gkk_zw">
                     <div class="sy_gkk_zw_l left"><font color="ff8100">${t.price!}元</font></div>
                     <div class="sy_gkk_zw_r  right">报名数：<font color="ff8100">${t.willnum!}人</font></div>
                     <div class="clear"></div>
                 </div>
             </div>
             </#if>
         </li>
         </#list>
     </ul>
     </#if>
 </div>
</div>
<div class="clear"></div>
</div>
</div>

</div>  
<script>
function login(){
    var form_data={},
        errMsg = $(".errMsg")[0];
    form_data["username"] = $("#loginform #username").val(),
    form_data["password"] = $("#loginform #password").val(),
    form_data["userType"] = $('input:radio[name="userType"]:checked').val();
    if(form_data.username == "" || form_data.username == null){
        errMsg.innerHTML = "请输入用户名"
        return false;
    }
    if(form_data.password == "" || form_data.password == null){
        errMsg.innerHTML = "请输入密码";
        return false;
    }
    $.ajax({
        type: "POST",
        url: "/website/index/login",
        data: form_data,
        error: function(request) {
            errMsg.innerHTML = "网络出错啦!";
            return false;
        },
        success: function (data) {
            if(data.code==200){
                if(data.target == "" || data.target == null){
                    setTimeout(function(){
                        window.location.href = "/website/index";
                    },300);
                }else{
                    setTimeout(function(){
                        window.location.href = data.target;
                    },300);
                }
            }else if(data.code==400){
                    errMsg.innerHTML = data.msg;
                    return false;
            }else{
                    errMsg.innerHTML = "未知错误";
                    return false;
            }
        }
    });
}
</script>
<!-- main结束 -->
<#include "/assets/website/common/footer.html">
</body>
</html></#escape>