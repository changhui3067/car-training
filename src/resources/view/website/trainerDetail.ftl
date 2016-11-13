<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd"> 
<html>    
<head>    
<title>培聘网</title>
<link rel="stylesheet" href="/assets/website/css/bootstrap.min.css" type="text/css"/>
<link rel="stylesheet" href="/assets/website/css/style.css" type="text/css"/>  
<link rel="stylesheet" href="/assets/website/css/pxshi.css" type="text/css"/>
<link rel="stylesheet" href="/assets/website/css/iconfont.css" type="text/css"/>
</head>   
     
 <body>    
 <!-- 头部开始 -->     
 <#include "/assets/website/common/header.html">   
 <!-- 头部结束 -->     
     
<!-- main开始 -->   
<div class="content">

<#if trainer??>
  <div class="ny_pxshi">
      <div class="ny_pxshi_l left">
          <div class="people_detail_basic_info">
              <div class="photo left">
                  <img src="${trainer.personInfo.avatarUrl!}"/>
              </div>
              <div class="detail left">
                  <div>
                      <h1 class="left">${trainer.personInfo.name!}</h1>
                      <div class="iconbox right">
                          <span><i class="iconfont" title="评论">&#xe69b;</i>0</span>
                          <#--<span><i class="iconfont" title="点赞">&#xe717;</i>${trainer.starLevel!}</span>-->
                      </div>
                      <div class="clear"></div>
                  </div>
                  <div>
                      <span class="paddingLeftNull">${trainer.currentPosition!}</span>
                      <span>8年</span>
                      <span>${trainer.education!}</span>
                      <#--<span class="noBorder">${trainer.userCenter.region.fullname!}</span>-->
                  </div>
                  <div>
                      擅长形式: <span>${trainer.businessCategory}</span>
                  </div>
                  <div>
                      培训领域: <span>开发</span><span>项目管理</span><span>经销商托管</span>
                  </div>
                  <div>
                      联系方式: <span>1515000xxxxx</span><span>changhiu3067@sina.cn</span>
                  </div>
                </div>
                <div class="clear"></div>
          </div>
            <!-- <div class="pxshi_jj">
              <div class="pxshi_bt">
              <h4><span><a href="#">更多>></a></span>培训师简介</h4>
                </div>
              <div class="pxshi_jj_box">
                       　　${trainer.introduction!}
                </div>
            </div> -->
          <div class="people_other_info_box">
                <div class="people_other_info_bar"><h4>培训课程</h4></div>
                <div class="people_other_info_list">
                  <#if coursesList??>
                  <ul>
                    <#list coursesList as c>
                        <li>
                            <a href="/website/courseDetail?course.id=${c.id!}" target="_blank">
                                <span class="info_name">${c.courseName!}（${c.longTime!}天</span>
                                <span class="info_date">${c.publishDate!?string("yyyy-MM-dd")}</span>
                            </a>
                        </li>
                    </#list>
                    </ul>
                    </#if>
                </div>
          </div>

          <div class="people_other_info_box">
                <div class="people_other_info_bar"><h4>视频链接</h4></div>
                <div class="people_other_info_video">
                    <a href="${trainer.videoUrl1!}"><iframe height=240 width=250 src='${trainer.vedioURL1!}' frameborder=0 'allowfullscreen'></iframe></a>
                    
                    <a href="${trainer.videoUrl2!}"><iframe height=240 width=250 src='${trainer.vedioURL2!}' frameborder=0 'allowfullscreen'></iframe></a>
                </div>
          </div>

            <!-- <div class="pxshi_wz">
              <div class="pxshi_bt">
              <h4><span><a href="#">更多>></a></span>原创文章</h4>
                </div>
                <div class="pxshi_wz_box">
                <#--<#if trainerEssayList??>-->
                  <#--<ul>-->
                  <#--<#list trainerEssayList as te>-->
                      <#--<li><span><a href="#">${te.publishDate!?string("yyyy-MM-dd")}</a></span><a href="/website/trainerEssayDetail?trainerEssay.id=${te.id!}" target="_blank">${te.title!}</a></li>-->
                    <#--</#list>-->
                    <#--</ul>-->
                    <#--</#if>-->
                </div>
            </div> -->
            <div class="people_other_info_box">
                <div class="people_other_info_bar"><h4>学员评论</h4></div>
                <div class="add_comment_box">
                    <textarea id="add_comment"></textarea>
                    <button class="commonClickButton" onclick="addcomment()">提交</button>
                </div>
            </div>
        </div>
        <div class="ny_pxshi_r right">
           <!-- <div class="pxshi_lx"> -->
              <!-- <h4>联系方式</h4> -->
                <!-- <div class="lx_box"> -->
                  <!-- <div class="xingming">${trainer.personInfo.name!}(培训师本人)</div> -->
                      <!-- <#if Session?? && Session["loginVO"]??> -->
                          <!-- 电话：${trainer.personInfo.mobile!}<br /> -->
                          <!-- 邮箱：${trainer.personInfo.email!}<br /> -->
                      <!-- <#else>
                          请联系培训网  400-820-6666
                      </#if>
                </div>
          </div> --> 
          <div class="people_comments">
              <h4>学员评价</h4>
              <div class="people_comments_list">
                  <#if commentList??>
                  <ul>
                    <#list commentList as c>
                    <#if c?? && c.content??>
                      <li>
                          <div class="comments">
                              <div class="comments_desc">${c.content}</div>
                              <div class="comments_date">2016-10-12</div>
                          </div>
                      </li>
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
<!-- main结束 -->    
<#include "/assets/website/common/footer.html"> 

<script src="<@url value="/assets/website/js/jquery1.42.min.js?v=1.1.0"/>"></script> 
<script>
function dianz(tid){
var form_data={};
var tid = tid;

if(tid==''||tid==null){
  alert('该培训师已不存在');
  return false;
}

form_data.tid = tid;

$.ajax({
   type: "POST",
     url: "/website/trainerDetail/dianzan",
     data: form_data,
     error: function(request) {
         showErrMsg("网络出错啦！");
         return false;
     },
     success: function (data) {
			 setTimeout(function(){
		 		if(jid==''||jid==null){
     	 			window.location.href = "/website/trainerDetail?trainer.id=tid";
     	 			}
     	 		},300);
     	 		window.location.reload();
     }
});
}
function addcomment(tid){ 
var form_data={};
var tid = tid;
var content = $("#content").val();

if(tid==''||tid==null){
  alert('该培训师已不存在');
  return false;
}
if(content==''||content==null){
  alert('请填写评论内容');
  return false;
}

form_data.content = content;
form_data.tid = tid;

$.ajax({
   type: "POST",
     url: "/website/trainerDetail/commentTrainer",
     data: form_data,
     error: function(request) {
         showErrMsg("网络出错啦！");
         return false;
     },
     success: function (data) {
			 showErrMsg("添加评论成功！");
			 setTimeout(function(){
		 		if(jid==''||jid==null){
     	 			window.location.href = "/website/trainerDetail?trainer.id=tid";
     	 			}
     	 		},300);

     }
});
}
function showErrMsg(errMsg){
  alert(errMsg);
} 
</script>
  
</body>   
</html>