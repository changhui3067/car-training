<link rel="stylesheet" href="<@url value="/assets/website/css/pxshi.css"/>" type="text/css" media="screen" />
<link rel="stylesheet" type="text/css" href="<@url value="/assets/website/css/lrtk.css"/>">
<#if trainer??>
  <div class="ny_pxshi">
      <div class="ny_pxshi_l left">
          <div class="pxshi_xx">
              <div class="zhaopian left">
                  <img src="${trainer.personInfo.avatarUrl!}" style="width:181px;height:153px;"/>
                </div>
                <div class="xinxi right">
                  <div class="mingzi">
                      <div class="mingzi_l left">${trainer.personInfo.name!}</div>
                        <div class="mingzi_m left"><span><a href="#"><img src="http://obu3flkwk.bkt.clouddn.com/website/images/hot.jpg" /></a></span>
                            <span><a href="#"><img src="http://obu3flkwk.bkt.clouddn.com/website/images/zan.jpg" /></a></span>
                            <span><a href="#"><img src="http://obu3flkwk.bkt.clouddn.com/website/images/zheng.jpg" /></a></span>
                            <span><a href="#"><img src="http://obu3flkwk.bkt.clouddn.com/website/images/xin.jpg" /></a></span>
                            <span><a href="#"><img src="http://obu3flkwk.bkt.clouddn.com/website/images/zishen.jpg" /></a></span>
                              <span><a href="#"><img src="http://obu3flkwk.bkt.clouddn.com/website/images/dav.jpg" /></a></span></div>
                        <div class="mingzi_r right">
                          <div class="pinglun left">0 人<span>评论</span></div>
                            <a href="#" onclick="dianz('${trainer.id!}')" ><div class="dianzan left" id="dainz">${trainer.starLevel!}</div></a>
                        </div>
                        <div class="clear"></div>
                    </div>
                    <div class="ziping">${trainer.currentPosition!}</div>
                    <div class="scxs2">
                    <em>擅长形式：</em><span>${trainer.businessCategory!?replace(",","      ")?replace("[","")?replace("]","")}</span>
                    </div>
                    <div class="lingyu">
                    <em>培训领域：</em><span>开发</span><span>项目管理</span><span style=" background:none;">经销商托管</span>
                    <div class="clear"></div>
                    </div>
                    <div class="shijian">
                      <div class="shijian_l left"><em>汽车行业时间（不含培训）：</em><#if trainer.autoYears?? && trainer.autoYears=0 > 应界毕业生 <#else>${trainer.autoYears!}年以上</#if></div>
                        <#--<div class="shijian_r  right"><em>常住地：</em>${trainer.personInfo.region.fullname!}</div>-->
                        <div class="clear"></div>

                    </div>
                    <div class="shijian">
                        <div class="shijian_r  right"><em>学 历：</em>${trainer.education!}</div>
                        <div class="clear"></div>

                    </div>
                </div>
                <div class="clear"></div>
            </div>
            <div class="pxshi_jj">
              <div class="pxshi_bt">
              <h4><span><a href="#">更多>></a></span>培训师简介</h4>
                </div>
              <div class="pxshi_jj_box">
                       　　${trainer.personInfo.intro!}
                </div>
            </div>
            <div class="pxshi_kc">
              <div class="pxshi_bt">
              <h4><span><a href="#">更多>></a></span>培训课程</h4>
                </div>
                <div class="pxshi_kc_box">
                  <#if coursesList??>
                  <ul>
                    <#list coursesList as c>
                        <li><span><a href="#">${c.publishDate!?string("yyyy-MM-dd")}</a></span><a href="/website/courseDetail?course.id=${c.id!}" target="_blank">${c.courseName!}（${c.longTime!}天）</a></li>
                        </#list>
                    </ul>
                    </#if>
                </div>
            </div>
            <div class="pxshi_sp">
              <div class="pxshi_bt">
              <h4><span><a href="#">更多>></a></span>视频链接</h4>
                </div>
                <div class="pxshi_sp_box">
                  <ul>
                      <li>
                      <a href="${trainer.videoUrl1!}">
                      <iframe height=240 width=250 src='${trainer.videoUrl1!}' frameborder=0 'allowfullscreen'></iframe></a></li>
                        <li><a href="${trainer.videoUrl!}"><embed src='http://player.youku.com/player.php/Type/Folder/Fid//Ob//sid/XMTgxMzQyNDM4MA==/v.swf' quality='high' width='480' height='400' align='middle' allowScriptAccess='always' allowFullScreen='true' mode='transparent' type='application/x-shockwave-flash'></embed>
                        <iframe height=240 width=250 src='${trainer.videoUrl2!}' frameborder=0 'allowfullscreen'></iframe></a></li>
                    </ul>
                </div>
          </div>
            <div class="pxshi_wz">
              <div class="pxshi_bt">
              <h4><span><a href="#">更多>></a></span>原创文章</h4>
                </div>
                <div class="pxshi_wz_box">
                <#if trainerEssayList??>
                  <ul>
                  <#list trainerEssayList as te>
                      <li><span><a href="#">${te.publishDate!?string("yyyy-MM-dd")}</a></span><a href="/website/trainerEssayDetail?trainerEssay.id=${te.id!}" target="_blank">${te.title!}</a></li>
                    </#list>
                    </ul>
                    </#if>
                </div>
          </div>
            <div class="pxshi_xypl">
              <div class="pxshi_bt">
              <h4>学员评论</h4>
                </div>
                <div class="pxshi_xypl_box">
                <table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td align="center" valign="middle">
      <textarea style="width:800px; height:100px;" name="content" id="content" cols="45" rows="5"></textarea></td>
  </tr>
  <tr>
    <td height="75" align="center" valign="bottom"><img onclick="addcomment('${trainer.id!}')" src="http://obu3flkwk.bkt.clouddn.com/website/images/tj.jpg" /></td>
  </tr>
</table>
              </div>
          </div>
        </div>
        <div class="ny_pxshi_r right">
          <div class="pxshi_lx">
              <h4>联系方式</h4>
                <div class="lx_box">
                  <div class="xingming">${trainer.personInfo.name!}(培训师本人)</div>
       <#if Session?? && Session["loginVO"]??>
                   电话：${trainer.personInfo.mobile!}<br />
                   邮箱：${trainer.personInfo.email!}<br />
<#else>
请联系培训网  400-820-6666
</#if>
                </div>
            </div>
            <div class="pxshi_pj">
              <h4>学员评价</h4>
                <div class="pj_box">
                  <#if trainer.autobotsCommentList??>
                  <ul>
                    <#list trainer.autobotsCommentList as c>
                    <#if c?? && c.content??>
                      <li><a href="#"><#if  c.content?length lt 19>${c.content!}<#else>${c.content?substring(18)!}...</#if></a></li>
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
