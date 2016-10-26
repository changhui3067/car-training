<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />

<title>培聘网</title>
<link rel="stylesheet" href="<@url value="/assets/website/css/zt.css"/>" type="text/css" media="screen" />
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


<div class="zhuanti">
    <div class="content" >
    	<div class="zt">
    	<#if topic??>
        	<div class="zt_l left">
            	<div class="wenti">
                	<div class="tubiao left"><img src="${topic.topicLogo!}" /></div> 
                    <div class="wt_box right">
                    	<h4><span>30人关注该问题</span><span><img src="http://obu3flkwk.bkt.clouddn.com/website/images/gz2.jpg" /></span>${topic.title!}</h4>${topic.content!}
                    </div>
                </div>
                <div class="pl_kuang">
                  <table width="95%" border="0" align="center" cellpadding="0" cellspacing="0">
                    <tr>
                      <td height="140" align="center" valign="middle"><textarea name="textarea2" style="width:780px; height:100px; border:1px solid #e6e5e5;" id="textarea2"></textarea></td>
                    </tr>
                    <tr>
                      <td height="60" align="center" valign="middle"><input type="image" name="imageField2" id="imageField2" src="http://obu3flkwk.bkt.clouddn.com/website/images/tj.jpg" /></td>
                    </tr>
                  </table>
                
                
                </div>
                <div class="pl_shu">21人评论</div>
                
                <#if topicCommentList??>
                <#list topicCommentList as t>
                <#if t?? && t.trainer?? && t.trainer.userCenter??>
            	<div class="pl_list">
                	<div class="pingl">
                	<div class="pingl_pic left"><img src="http://obu3flkwk.bkt.clouddn.com/website/images/zttx2.jpg" /></div>
                    <div class="pingl_ren right">
                    	<div class="pingl_ren_m">${t.trainer.userCenter.name!}</div>
                        <div class="pingl_ren_zw">${t.trainer.currentPosition!}</div>
                    </div>
                </div>
                	<div class="pingl_xx">${t.content!}</div>
                	<div class="zt_pl2">
                            	<div class="zt_pl2_l left"><a href="#">${t.createDate!}</a></div>
                                <div class="zt_pl2_r right">
                                  <table width="100%" border="0" cellspacing="0" cellpadding="0">
                                    <tr>
                                       <td width="30%" align="right" valign="middle"><img src="http://obu3flkwk.bkt.clouddn.com/website/images/pl_icon.jpg" /></td>
                                      <td width="20%" align="right" valign="middle"><a href="#">评论</a></td>
                                     
                                      <td width="21%" align="right" valign="middle"><img src="http://obu3flkwk.bkt.clouddn.com/website/images/z.jpg" /></td>
                                      <td width="29%" align="right" valign="middle"><a href="#">赞(12)</a></td>
                                    </tr>
                                  </table>
                              </div>
                                <div class="clear"></div>
              </div>
                </div>
                </#if>
                </#list>
                </#if>
                
                
                <div class="fypage" ><span>上五页</span><span class="">上一页</span><span>1</span><a href="#">2</a><a href="#">3</a><a href="#">4</a><a href="#">5</a><a href="#">下一页</a><a href="#">下五页</a>  跳转到 <select name="PageSelect" onchange=""><option value="" selected="selected">第01页</option><option value="">第02页</option><option value="">第03页</option><option value="">第04页</option><option value="">第05页</option><option value="">第06页</option><option value="index_7.html">第07页</option>
                
               
               </select></div>
            </div>
            </#if>
            
            <div class="zt_r right">
            <div class="kstw">
            	<h4>我要发帖</h4>
                <div class="kstw_box">
                	<table width="95%" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td height="140" align="center" valign="middle"><textarea name="textarea" style=" border:1px solid #e6e5e5;width:240px; height:100px;" id="textarea"></textarea></td>
  </tr>
  <tr>
    <td height="60" align="center" valign="middle">
      <input type="image" name="imageField" id="imageField" src="http://obu3flkwk.bkt.clouddn.com/website/images/tj.jpg" />
  </td>
  </tr>
</table>

              </div>
            </div>
            <div class="wdwd">
            	<h4>我的帖子</h4>
            	<#if topicList??>
                <div class="wdwd_box">
                	<ul>
        		    	<#list topicList as t>
        		    	<#if t??> 
                        <li><a href="#">${t.title!}</a></li>
                        </#if>
		                </#list>
                    </ul>
                </div>
                </#if>
            </div>
            
            </div>
            <div class="clear"></div>
        </div>
        
       
  </div>
</div>
    
	

<!-- main结束 -->
<#include "/assets/website/common/footer.html">
</body>
</html>
