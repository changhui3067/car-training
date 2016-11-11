<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<#escape x as x?html><html>
<head>
    <title>培聘网</title>
    <link rel="stylesheet" href="<@url value="/assets/website/css/style.css?v=1.1.0"/>" type="text/css" media="screen" />
    <link rel="stylesheet" href="<@url value="/assets/website/css/bootstrap.min.css?v=1.1.0"/>" type="text/css" media="screen" />

</head>

<body>
    <!-- 头部开始 -->
    <#include "/assets/website/common/header.html">
    <!-- 头部结束 -->
    <!-- banner开始 -->
    <div class="banner">
        <#if '{}' == '${session}'|| !Session["loginVO"]?? >
        <div class="content">
            <div class="login-box">
                <form action="" id="loginform" class="form-horizontal">
                <input type="hidden" name="targetUrl" value=${targetUrl!} />
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
                <div id="checkeRadio">
                    <label class="radio-inline col-sm-5">
                        <input name="userType" id="userType" type="radio"  value="PERSON" checked/>个人
                    </label>
                    <label class="radio-inline col-sm-6">
                        <input type="radio" name="userType" id="userType" value="COMPANY" />企业
                    </label>
                </div>
                <div><button onClick='javascript:login();'>登&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;录</button></div>
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
         <div class="pxshi">
             <div class="pxshi_l left">
               <#if trainer?? >
               <div class="pxshi_l_pic"><a href="/website/trainerDetail?trainer.id=${trainer.id!}"><img src="${trainer.personInfo.avatarUrl!}" /></a></div>
               <div class="pxshi_l_intro">
                 <div class="pxshi_name">
                     <div class="xm left">${trainer.personInfo.name!}</div>
                     <div class="pl left"><i class="iconfont" title="评论">&#xe69b;</i><#if trainer.autobotsCommentList??> ${trainer.autobotsCommentList.size!}<#else>0</#if></div>
                     <div class="dz right"><i class="iconfont" title="点赞">&#xe717;</i>${trainer.starLevel!}</div>
                     <div class="clear"></div>
                 </div>
                 <div class="pxshi_zp">${trainer.currentPosition!} </div>
                 <div class="pxshi_rz">
                     <ul>
                         <li><i class="iconfont" title="留言多">&#xe756;</i></li>
                         <li><i class="iconfont" title="资料完整">&#xe69f;</i></li>
                         <li><i class="iconfont" title="身份信息可靠">&#xe70a;</i></li>
                         <li><i class="iconfont" title="培训经验超过10年">&#xe735;</i></li>
                         <li><i class="iconfont" title="行业经验超过20年">&#xe726;</i></li>
                     </ul>
                 </div>
             </div>
             </#if>
         </div>
         <div class="pxshi_r right">
          <#if trainerList??>
          <ul>
           <#list trainerList as t>
           <li class="oneBox">
              <#if t?? >
              <div class="picContainer"><a href="/website/trainerDetail?trainer.id=${t.id!}"><img src="${t.personInfo.avatarUrl!}" /></a></div>
              <div class="intro">
                <div>
                    <div class="name">${t.personInfo.name!}</div>
                    <div class="right">${t.starLevel!}</div>
                    <div class="right"><#if t.autobotsCommentList??> ${t.autobotsCommentList.size!}<#else>0</#if>人</div>
                    <div class="clear"></div>
                </div>
                <div>${t.currentPosition!} </div>
                <div>
              <ul>
                  <li><i class="iconfont" title="留言多">&#xe756;</i></li>
                  <li><i class="iconfont" title="资料完整">&#xe69f;</i></li>
                  <li><i class="iconfont" title="身份信息可靠">&#xe70a;</i></li>
                  <li><i class="iconfont" title="培训经验超过10年">&#xe735;</i></li>
                  <li><i class="iconfont" title="行业经验超过20年">&#xe726;</i></li>
                </ul>
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
 <h4><span><a href="/website/autobot">更多>></a></span>推荐培训生</h4>
 <div class="pxsheng">
     <#if autobotList??>
     <ul>
         <#list autobotList as t>
         <li class="oneBox">
             <#if t??>
             <div class="picContainer"><a href="/website/autobotDetail?autobots.id=${t.id!}"><img src="${t.personInfo.avatarUrl!}" /></a></div>
             <div class="intro">
                 <div>
                     <div class="name">${t.personInfo.name!}</div>
                     <div class="right">34人</div>
                     <div class="right">${t.autoYears!}年</div>
                     <div class="clear"></div>
                 </div>
                 <div>
                     <div>${t.currentPosition!}</div>
                     <div class="clear"></div>
                 </div>
                 <div>
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
 <h4><span><a href="/website/recruit/?companyType=COMPANY">更多>></a></span>培训需求</h4>
 <div class="pxxq">
     <#if jobsTrainerList??>
     <ul>
         <#list jobsTrainerList as t>
         <li class="zp_box">
             <#if t?? && t.company??>
             <div class="qz"></div>
                 <div class="pxxq_l left zp_box_l">
                    <a href="/website/jobDetail?jobs.id=${t.id!}"> <div class="zw_name">${t.name!}</div></a>
                    <div class="dy_box">
                        <span class="cn" style="padding-left:0px;">${t.salary!}</span>
                        <span>${t.workExprience!}年工作经验</span>
                        <span style="background:none;"><#if t.region??>${t.region.fullname!}</#if></span>
                    </div>
                    <div class="fb_box">
                        	<span  style="padding-left:0px;">发布于：${t.publishDate!?string("yyyy-MM-dd")}</span><span style="background:none;">投递后：48小时反馈</span>
                    </div>
                </div>
                <div class="pxxq_r right zp_box_r">
                    <div class="qy">
                          <a href="/website/autoCompany?company.id=${t.company.id!}">
                              <div class="qy_l left zp_box_r_l"><img src="${t.company.logo!}" /></div>
                              <div class="qy_r right zp_box_r_r">
                                  <div class="qy_name">
                                      <span>${t.company.name!}</span>
                                      <span>已有${t.company.bondsmanCount}人担保</span>
                                  </div>
                                  <div class="jyfw">${t.company.industry!}</div>
                                  <div class="fl">
                                      <#if t.welfare??>
                                          <#list t.welfare as w><span>${w!}</span></#list>
                                      </#if>
                                  </div>
                              </div>
                          </a>
                          <div class="clear"></div>
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
 <h4><span><a href="/website/recruit/?companyType=STORE">更多>></a></span>汽车人需求</h4>
 <div class="qcrxq">
     <#if jobsAutobotsList??>
     <ul>
         <#list jobsAutobotsList as t>
         <li class="zp_box">
             <#if t?? && t.company??>
             <div class="qcrxq_l left zp_box_l">
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

            <div class="qcrxq_r right zp_box_r">
                <div class="qcrxq_qy">
                    <a href="/website/autoCompany?company.id=${t.company.id!}">
                        <div class="qcrxq_qy_l left zp_box_r_l"><img src="${t.company.logo!}" /></div>
                        <div class="qcrxq_qy_r right zp_box_r_r">
                            <div class="qcrxq_qy_name">
                                <span>${t.company.name!}</span>
                                <span>已有${t.company.bondsmanCount}人担保</span>
                            </div>
                            <div class="qcrxq_jyfw">${t.company.industry!}</div>
                            <div class="qcrxq_fl">
                                <#if t.welfare??>
                                    <#list t.welfare as w><span>${w!}</span></#list>
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
<div class="art_box">
 <div class="yiti left">
     <h4>培训学院热点议题<span><a href="/website/topic">更多>></a></span></h4>
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
     <h4><span><a href="/website/courses">更多>></a></span>公开课</h4>
     <div class="gkk_box">
       <#if coursesList??>
       <ul>
          <#list coursesList as t>
          <li class="oneBox">
             <#if t?? && t.trainer ?? &&t.trainer.personInfo ?? >
             <div class="picContainer"><a href="/website/courseDetail?course.id=${t.id!}"><img src="${t.trainer.personInfo.headLogo!}" /></a></div>
             <div class="intro">
                 <div>
                     <div class="name"><a href="/website/courseDetail?course.id=${t.id!}">${t.courseName!}</a></div>
                     <div class="clear"></div>
                 </div>
                 <div class="">
                     <div class="left"><#if t.region??></#if>${t.region.fullname!}</div>
                     <div class="right">2016-6-18</div>
                     <div class="clear"></div>
                 </div>
                 <div class="">
                     <div class="left">${t.price!}元</div>
                     <div class="right">${t.willnum!}人</div>
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
    <script src="<@url value="/assets/website/js/jquery-3.1.1.min.js?v=1.1.0"/>"></script>
    <script src="<@url value="/assets/website/js/bootstrap.min.js?v=1.1.0"/>"></script>
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
        error: function(request) {
            errMsg.innerHTML = "网络出错啦!";
            return false;
        },
        success: function (data) {
            if (data == 'success') {
                setTimeout(function () {
                    window.location.href = "/website/index";
                }, 300);
            } else {
                errMsg.innerHTML = data.error;
            }

        }
    });
}
</script>
<!-- main结束 -->
<#include "/assets/website/common/footer.html">
</body>
</html></#escape>