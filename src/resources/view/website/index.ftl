<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<#escape x as x?html>
<html xmlns="http://www.w3.org/1999/html" xmlns="http://www.w3.org/1999/html">
<head>
    <title>培聘网</title>
    <link rel="stylesheet" href="/assets/website/css/bootstrap.min.css" type="text/css" />
    <link rel="stylesheet" href="/assets/website/css/style.css" type="text/css" />
    <link rel="stylesheet" href="/assets/website/css/iconfont.css" type="text/css" media="screen" />
</head>

<body>
    <!-- 头部开始 -->
    <#include "/assets/website/common/header.html">
    <!-- 头部结束 -->
    <!-- banner开始 -->
    <input name="currLocation" type="hidden" value="0"/>
    <div class="banner">
        <#if '{}' == '${session}'|| !Session["loginVO"]?? >
        <div class="content">
            <div class="login-box">
                <form id="loginform" action="javascript:login()" class="form-horizontal">
                <div class="dot-line">会员登录</div>
                <div class="form-group">
                    <label  class="col-sm-3 control-label">账号：</label>
                    <div class="col-sm-9">
                        <input class="form-control text-size" id="username" name="username" data-nick="login_user" value="" placeholder="请输入手机号" required validate-title="手机号" />
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-3 control-label">密码：</label>
                    <div class="col-sm-9">
                        <input class="form-control text-size" type="password" name="password" id="password" data-nick="login_pwd" value=""   placeholder="请输入密码" required validate-title="密码" /></div>
                    </div>
                <div>
                    <div class="errMsg col-sm-8"></div>
                    <div class="forgetPswd col-sm-4"><a href='<@url value='/backend/forgetPswd'/>'>忘记密码?</a></div>
                </div>
                <div><button>登&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;录</button></div>
                </form>
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
         <h4><span><a href="/website/trainer">更多>></a></span>推荐培训师</h4>
         <div class="pxshi_r">
          <#if trainerList??>
          <ul>
           <#list trainerList as a_trainer>
           <li class="oneBox">
              <#if a_trainer?? >
              <div class="picContainer"><a href="/website/trainerDetail?trainerId=${a_trainer.id!}"><img src="${a_trainer.personInfo.avatarUrl!}" /></a></div>
              <div class="intro">
                <div>
                    <div class="name">${a_trainer.personInfo.name!}</div>
                    <div class="pl right"><i class="iconfont" title="评论">&#xe69b;</i>${commentNumberMap.get(a_trainer)}</div>
                     <#if isLikeMap?? &&isLikeMap.size() gt 0 && isLikeMap.get(a_trainer)>
                     <div id=${a_trainer.loginUser.id!} class="right praise" value="<#if Session?exists && '{}' != '${session}' && Session["loginVO"]??>true<#else>false</#if>" onClick="like('.pxshi_r .oneBox .intro',this.id)"><i class="iconfont icon-icon02" title="点赞"></i><span>${likeNumberMap.get(a_trainer)!}</span></div>
                     <#else>
                     <div id=${a_trainer.loginUser.id!} class="right praise" value="<#if Session?exists && '{}' != '${session}' && Session["loginVO"]??>true<#else>false</#if>" onClick="like('.pxshi_r .oneBox .intro',this.id)"><i class="iconfont icon-good" title="点赞"></i><span>${likeNumberMap.get(a_trainer)!}</span></div>
                     </#if>
                    <div class="clear"></div>
                </div>
                <div>${a_trainer.currentPosition!} </div>
            </div>
            </#if>
        </li>
        </#list>
    </ul>
    </#if>
</div>
<div class="clear"></div>
</div>
<div class="pxsheng_box">
 <h4><span><a href="/website/autobot">更多>></a></span>推荐汽车人</h4>
 <div class="pxsheng">
     <#if autobotList??>
     <ul>
         <#list autobotList as a_autobot>
         <li class="oneBox">
             <#if a_autobot??>
             <div class="picContainer">
                 <a href="/website/autobotDetail?autobotId=${a_autobot.id!}">
                     <img src="${a_autobot.personInfo.avatarUrl!}" />
                 </a>
             </div>
             <div class="intro">
                 <div>
                 <div class="name">${a_autobot.personInfo.name!}</div>
                 <div class="right"><i class="iconfont" title="评论">
                     &#xe69b;</i>${commentNumberMap.get(a_autobot)}</div>
                 <#if isLikeMap?? &&isLikeMap.size() gt 0 && isLikeMap.get(a_autobot)>
                     <div id=${a_autobot.loginUser.id!} class="right praise
                     " value="<#if Session?exists && '{}' != '${session}' && Session["loginVO"]??>true<#else>false</#if>" onClick="like('.pxsheng .oneBox .intro',this.id)"><i
                         class="iconfont icon-icon02" title="点赞"></i><span>${likeNumberMap.get(a_autobot)!}</span></div>
                 <#else>
                     <div id=${a_autobot.loginUser.id!} class="right praise
                     " value="<#if Session?exists && '{}' != '${session}' && Session["loginVO"]??>true<#else>false</#if>" onClick="like('.pxsheng .oneBox .intro',this.id)"><i
                         class="iconfont icon-good" title="点赞"></i><span>${likeNumberMap.get(a_autobot)!}</span></div>
                 </#if>
                 <div class="clear"></div>
                 </div>
                 <div>
                     <div>${a_autobot.currentPosition!}</div>
                     <div class="clear"></div>
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
<div class="pxxq_box">
 <h4><span><a href="/website/job?jobType=TRAINER">更多>></a></span>培训师招聘</h4>
 <div class="pxxq">
     <#if trainerJobList??>
     <ul>
         <#list trainerJobList as trainerJob>
         <li class="zp_box">
             <#if trainerJob??>
             <div class="qz"></div>
                 <div class="left zp_box_l">
                    <a href="/website/jobDetail?jobId=${trainerJob.id!}"> <div class="zw_name">${trainerJob.title!}</div></a>
                    <div class="dy_box">
                        <#--<span class="cn jobSalary ellipsis" style="padding-left:0px;" title="${trainerJob.salary!}元">${trainerJob.salary!}元</span>-->
                        <span>${trainerJob.workExperienceRequirement!}年经验</span>
                        <span style="background:none;" class="jobRegion ellipsis" title="<#if trainerJob.region??>${trainerJob.region.fullname!}</#if>"><#if trainerJob.region??>${trainerJob.region.fullname!}</#if></span>
                    </div>
                    <div class="fb_box">
                        	<span  style="padding-left:0px;">发布于：<#if trainerJob.createDate??>${trainerJob.createDate?string("yyyy-MM-dd")} </#if></span>
                            <span style="background:none;">投递后：48小时反馈</span>
                    </div>
                </div>
                 <div class="right zp_box_r">
                     <#if trainerJob.company??>
                     <div class="qy">
                         <a href="/website/companyDetail?companyId=${trainerJob.company.id!}">
                             <div class="qy_l left zp_box_r_l"><img src="${trainerJob.company.logoUrl!}"/></div>
                             <div class="qy_r right zp_box_r_r">
                                 <div class="qy_name">
                                     <span class="ellipsis">${trainerJob.company.name!}</span></br>
                                     <span>${guaranteeNumberMap.get(trainerJob.company)!}人担保</span>
                                 </div>
                                 <div class="jyfw">${trainerJob.company.industry!}</div>
                                 <div class="fl" title="${trainerJob.company.welfare!}">
                                     <#if trainerJob.company.welfare??>
                                         <#list trainerJob.company.welfare?split(",") as w><span>${w!}</span></#list>
                                     </#if>
                                 </div>
                             </div>
                         </a>
                         <div class="clear"></div>
                     </div>
                     </#if>
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
 <h4><span><a href="/website/job?jobType=AUTOBOT">更多>></a></span>汽车人招聘</h4>
 <div class="qcrxq">
     <#if autobotJobList??>
     <ul>
         <#list autobotJobList as t>
         <li class="zp_box">
             <#if t?? && t.company??>
             <div class="qcrxq_l left zp_box_l">
                 <a href="/website/jobDetail?jobId=${t.id!}"><div class="qcrxq_zw_name">${t.title!}</div></a>
                <div class="qcrxq_dy_box">
                    <#--<span class="cn" style="padding-left:0px;" class="jobSalary ellipsis" title="${t.salary!}元">${t.salary!}元</span>-->
                    <span>${t.workExprience!}年经验</span>
                    <span style="background:none;" class="jobRegion ellipsis" title="<#if t.region??>${t.region.fullname!}</#if>"><#if t.region??>${t.region.fullname!}</#if></span>
                </div>
                 <#--<div class="pingpai">-->
                     <#--<em>当前汽车品牌：</em><span><#if t.company.autoBrand??>${t.company.autoBrand!}</#if></span>-->
                     <#--<div class="clear"></div>-->
                 <#--</div>-->

                 <div class="qcrxq_fb_box">
                     <span style="padding-left:0px;">发布于：<#if t.createDate??>${t.createDate?string("yyyy-MM-dd")} </#if></span>
                     <span style="background:none;">投递后：48小时反馈 </span>
                </div>
             </div>

            <div class="qcrxq_r right zp_box_r">
                <div class="qcrxq_qy">
                    <a href="/website/companyDetail?companyId=${t.company.id!}">
                        <div class="qcrxq_qy_l left zp_box_r_l"><img src="${t.company.logoUrl!}" /></div>
                        <div class="qcrxq_qy_r right zp_box_r_r">
                            <div class="qcrxq_qy_name">
                                <span class="ellipsis">${t.company.name!}</span></br>
                                <span>${guaranteeNumberMap.get(t.company)!}人担保</span>
                            </div>
                            <div class="qcrxq_jyfw">${t.company.industry!}</div>
                            <div class="qcrxq_fl" title="${t.company.welfare!}">
                                <#if t.company.welfare??>
                                    <#list t.company.welfare?split(",") as w><span>${w!}</span></#list>
                                </#if>
                            </div>
                        </div>
                        <div class="clear"></div>
                    </a>
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
<#--<div class="art_box">-->
 <#--<div class="yiti left">-->
     <#--<h4>培训学院热点议题<span><a href="/website/topic">更多>></a></span></h4>-->
     <#--<div class="yiti_box">-->
         <#--<#if topicList??>-->
         <#--<ul>-->
             <#--<#list topicList as t>-->
             <#--<li>-->
                 <#--<#if t??>-->
                 <#--<span><a href="#">${t.publishDate?string("yyyy-MM-dd")}</a></span><a href="/website/topicDetail?topic.id=${t.id!}">${t.title!}</a>-->
                 <#--</#if>-->
             <#--</li>-->
             <#--</#list>-->
         <#--</ul>-->
         <#--</#if>-->
     <#--</div>-->
 <#--</div>-->

 <#--<div class="gkk right">-->
     <#--<h4><span><a href="/website/courses">更多>></a></span>公开课</h4>-->
     <#--<div class="gkk_box">-->
       <#--<#if coursesList??>-->
       <#--<ul>-->
          <#--<#list coursesList as t>-->
          <#--<li class="oneBox">-->
             <#--<#if t?? && t.trainer ?? &&t.trainer.personInfo ?? >-->
             <#--<div class="picContainer"><a href="/website/courseDetail?course.id=${t.id!}"><img src="${t.trainer.personInfo.headLogo!}" /></a></div>-->
             <#--<div class="intro">-->
                 <#--<div>-->
                     <#--<div class="name"><a href="/website/courseDetail?course.id=${t.id!}">${t.courseName!}</a></div>-->
                     <#--<div class="clear"></div>-->
                 <#--</div>-->
                 <#--<div class="">-->
                     <#--<div class="left"><#if t.region??></#if>${t.region.fullname!}</div>-->
                     <#--<div class="right">2016-6-18</div>-->
                     <#--<div class="clear"></div>-->
                 <#--</div>-->
                 <#--<div class="">-->
                     <#--<div class="left">${t.price!}元</div>-->
                     <#--<div class="right">${t.willnum!}人</div>-->
                     <#--<div class="clear"></div>-->
                 <#--</div>-->
             <#--</div>-->
             <#--</#if>-->
         <#--</li>-->
         <#--</#list>-->
     <#--</ul>-->
     <#--</#if>-->
 <#--</div>-->
<#--</div>-->
<#--<div class="clear"></div>-->
<#--</div>-->
</div>

</div>
<!-- main结束 -->
<#include "/assets/website/common/footer.html">
<script src="/assets/website/js/jquery-3.1.1.min.js"></script>
<script src="/assets/website/js/bootstrap.min.js"></script>
<script src="/assets/website/js/Util.js"></script>
<script>
function login(){


    var phoneReg = /^1[3|4|5|7|8][0-9]{9}$/, //手机验证规则
        form_data={},
        errMsg = $(".errMsg")[0];
    form_data["username"] = $("#loginform #username").val(),
    form_data["password"] = $("#loginform #password").val(),
    form_data["personOrCompany"] = $('input:radio[name="userType"]:checked').val();
    if(form_data.username == "" || form_data.username == null){
        errMsg.innerHTML = "请输入用户名";
        return false;
    }else if(!phoneReg.test(form_data.username)){
        errMsg.innerHTML = "手机格式不正确";
        return false;
    }
    if(form_data.password == "" || form_data.password == null){
        errMsg.innerHTML = "请输入密码";
        return false;
    }
    $.ajax({
        type: "POST",
        url: "/backend/UserCenter/login",
        data: form_data,
        error: function() {
            Util.msgToast({
                message: '请求失败',
                mode: Util.MSGTYPE.ERROR
            });
            return false;
        },
        success: function (data) {
            if (data == 'success') {
                window.location = "/website/index";
            } else {
                errMsg.innerHTML = data.error;
            }
        }
    });
}
</script>
</body>
</html></#escape>