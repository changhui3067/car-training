<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />

<title>培聘网</title>
<link rel="stylesheet" href="<@url value='/assets/website/backend/css/style.css'/>" type="text/css" media="screen" />
<script src="<@url value="/assets/website/js/jquery-1.8.0.min.js?v=1.1.0"/>"></script>
</head>

<body>
<#include "/assets/website/common/header.html">
	
<!-- main开始 -->
<div class="main">
	<div class="content">
    <div class="dq_box">
    <div class="dqwz left">当前位置 : <a href="#">首 页</a> > <a href="#">企业管理中心</a> > <a href="#">我的专题</a></div>
    <div class="wdcf right"><span color="#FF66001"><#if Session?exists && Session["userDetails"].wealthStartDate??> ${Session["userDetails"].wealthStartDate!?string("dd/MM/yyyy")}—${Session["userDetails"].wealthEndDate!?string("dd/MM/yyyy")}</#if></span>我的财富：<font color="#FF66001"><#if Session?exists && Session["userDetails"]??> ${Session["userDetails"].wealth!}</#if></font></div><div class="clear"></div>
    </div>
    <div class="pxshi_gl">
    	<div class="pxshi_gl_l left">
        
          <#include "/assets/website/backend/common/menu.ftl">
          <div class="tjzt"><a href="#"><img src="http://obu3flkwk.bkt.clouddn.com/backend/images/tjzt.jpg" /></a></div>
        <div class="pxshi_gl_r right">
       	  <table bgcolor="#dedede" border="0" cellpadding="4" cellspacing="1" align="center" width="860">
                    <tbody>
                      <tr>
                        <td width="50" height="50" align="center" valign="middle" bgcolor="#f0faff"><strong>选择</strong></td>
                        <td width="50" align="center" valign="middle" bgcolor="#f0faff"> <strong>序号</strong></td>
                        <td width="557" align="center" valign="middle" bgcolor="#f0faff"><strong>标 题</strong></td>
                        <td width="87" align="center" valign="middle" bgcolor="#f0faff"><strong>发布时间</strong></td>
                        <td width="70" align="center" valign="middle" bgcolor="#f0faff"> <strong> 操作 </strong></td>
                      </tr>
                      <tr>
                        <td  height="40" align="center" valign="middle" bgcolor="#ffffff"><input type="checkbox" name="checkbox" id="checkbox" /></td>
                        <td  align="center" valign="middle" bgcolor="#ffffff" class="sq">1</td>
                        <td align="center" valign="middle" bgcolor="#ffffff"class="sq"><a href="#">我是刚从部队自主择业到地方的，你说的困之路你如何看待行政类工作？ </a></td>
                        <td  align="center" valign="middle" bgcolor="#ffffff">2016-06-22</td>
                        <td align="center" valign="middle" bgcolor="#ffffff"  class="caozuo"><a href="#">查看</a>&nbsp;&nbsp;  <a href="#">删除</a></td>
                      </tr>
                      <tr>
                        <td  height="40" align="center" valign="middle" bgcolor="#ffffff"><input type="checkbox" name="checkbox" id="checkbox" /></td>
                        <td  align="center" valign="middle" bgcolor="#ffffff" class="sq">2</td>
                        <td align="center" valign="middle" bgcolor="#ffffff"class="sq"><a href="#">我是刚从部队自主择业到地方的，你说的困之路你如何看待行政类工作？ </a></td>
                        <td  align="center" valign="middle" bgcolor="#ffffff">2016-06-22</td>
                        <td align="center" valign="middle" bgcolor="#ffffff"  class="caozuo"><a href="#">查看</a>&nbsp;&nbsp;  <a href="#">删除</a></td>
                      </tr>
                       <tr>
                        <td  height="40" align="center" valign="middle" bgcolor="#ffffff"><input type="checkbox" name="checkbox" id="checkbox" /></td>
                        <td  align="center" valign="middle" bgcolor="#ffffff" class="sq">3</td>
                        <td align="center" valign="middle" bgcolor="#ffffff"class="sq"><a href="#">我是刚从部队自主择业到地方的，你说的困之路你如何看待行政类工作？ </a></td>
                        <td  align="center" valign="middle" bgcolor="#ffffff">2016-06-22</td>
                        <td align="center" valign="middle" bgcolor="#ffffff"  class="caozuo"><a href="#">查看</a>&nbsp;&nbsp;  <a href="#">删除</a></td>
                      </tr>
                       <tr>
                        <td  height="40" align="center" valign="middle" bgcolor="#ffffff"><input type="checkbox" name="checkbox" id="checkbox" /></td>
                        <td  align="center" valign="middle" bgcolor="#ffffff" class="sq">4</td>
                        <td align="center" valign="middle" bgcolor="#ffffff"class="sq"><a href="#">我是刚从部队自主择业到地方的，你说的困之路你如何看待行政类工作？ </a></td>
                        <td  align="center" valign="middle" bgcolor="#ffffff">2016-06-22</td>
                        <td align="center" valign="middle" bgcolor="#ffffff"  class="caozuo"><a href="#">查看</a>&nbsp;&nbsp;  <a href="#">删除</a></td>
                      </tr>
                       <tr>
                        <td  height="40" align="center" valign="middle" bgcolor="#ffffff"><input type="checkbox" name="checkbox" id="checkbox" /></td>
                        <td  align="center" valign="middle" bgcolor="#ffffff" class="sq">5</td>
                        <td align="center" valign="middle" bgcolor="#ffffff"class="sq"><a href="#">我是刚从部队自主择业到地方的，你说的困之路你如何看待行政类工作？ </a></td>
                        <td  align="center" valign="middle" bgcolor="#ffffff">2016-06-22</td>
                        <td align="center" valign="middle" bgcolor="#ffffff"  class="caozuo"><a href="#">查看</a>&nbsp;&nbsp;  <a href="#">删除</a></td>
                      </tr>
                       <tr>
                        <td  height="40" align="center" valign="middle" bgcolor="#ffffff"><input type="checkbox" name="checkbox" id="checkbox" /></td>
                        <td  align="center" valign="middle" bgcolor="#ffffff" class="sq">6</td>
                        <td align="center" valign="middle" bgcolor="#ffffff"class="sq"><a href="#">我是刚从部队自主择业到地方的，你说的困之路你如何看待行政类工作？ </a></td>
                        <td  align="center" valign="middle" bgcolor="#ffffff">2016-06-22</td>
                        <td align="center" valign="middle" bgcolor="#ffffff"  class="caozuo"><a href="#">查看</a>&nbsp;&nbsp;  <a href="#">删除</a></td>
                      </tr>
                       <tr>
                        <td  height="40" align="center" valign="middle" bgcolor="#ffffff"><input type="checkbox" name="checkbox" id="checkbox" /></td>
                        <td  align="center" valign="middle" bgcolor="#ffffff" class="sq">7</td>
                        <td align="center" valign="middle" bgcolor="#ffffff"class="sq"><a href="#">我是刚从部队自主择业到地方的，你说的困之路你如何看待行政类工作？ </a></td>
                        <td  align="center" valign="middle" bgcolor="#ffffff">2016-06-22</td>
                        <td align="center" valign="middle" bgcolor="#ffffff"  class="caozuo"><a href="#">查看</a>&nbsp;&nbsp;  <a href="#">删除</a></td>
                      </tr>
                       <tr>
                        <td  height="40" align="center" valign="middle" bgcolor="#ffffff"><input type="checkbox" name="checkbox" id="checkbox" /></td>
                        <td  align="center" valign="middle" bgcolor="#ffffff" class="sq">8</td>
                        <td align="center" valign="middle" bgcolor="#ffffff"class="sq"><a href="#">我是刚从部队自主择业到地方的，你说的困之路你如何看待行政类工作？ </a></td>
                        <td  align="center" valign="middle" bgcolor="#ffffff">2016-06-22</td>
                        <td align="center" valign="middle" bgcolor="#ffffff"  class="caozuo"><a href="#">查看</a>&nbsp;&nbsp;  <a href="#">删除</a></td>
                      </tr>
                       <tr>
                        <td  height="40" align="center" valign="middle" bgcolor="#ffffff"><input type="checkbox" name="checkbox" id="checkbox" /></td>
                        <td  align="center" valign="middle" bgcolor="#ffffff" class="sq">9</td>
                        <td align="center" valign="middle" bgcolor="#ffffff"class="sq"><a href="#">我是刚从部队自主择业到地方的，你说的困之路你如何看待行政类工作？ </a></td>
                        <td  align="center" valign="middle" bgcolor="#ffffff">2016-06-22</td>
                        <td align="center" valign="middle" bgcolor="#ffffff"  class="caozuo"><a href="#">查看</a>&nbsp;&nbsp;  <a href="#">删除</a></td>
                      </tr>
                       <tr>
                        <td  height="40" align="center" valign="middle" bgcolor="#ffffff"><input type="checkbox" name="checkbox" id="checkbox" /></td>
                        <td  align="center" valign="middle" bgcolor="#ffffff" class="sq">10</td>
                        <td align="center" valign="middle" bgcolor="#ffffff"class="sq"><a href="#">我是刚从部队自主择业到地方的，你说的困之路你如何看待行政类工作？ </a></td>
                        <td  align="center" valign="middle" bgcolor="#ffffff">2016-06-22</td>
                        <td align="center" valign="middle" bgcolor="#ffffff"  class="caozuo"><a href="#">查看</a>&nbsp;&nbsp;  <a href="#">删除</a></td>
                      </tr>
                      <tr>
                        <td  height="40" align="center" valign="middle" bgcolor="#ffffff"><input type="checkbox" name="checkbox" id="checkbox" /></td>
                        <td colspan="4"  align="left" valign="middle" bgcolor="#ffffff" class="sq"><table width="200" border="0" cellspacing="0" cellpadding="0">
                          <tr>
                            <td width="80" align="center" valign="middle" class="quanxuan"><a href="#">全 选</a></td>
                            <td width="163"><input type="image" name="imageField" id="imageField" src="http://obu3flkwk.bkt.clouddn.com/backend/images/sc.jpg" /></td>
                          </tr>
                        </table></td>
                      </tr>
                    </tbody>
                  </table>
         <div class="fypage" ><span>上五页</span><span class="">上一页</span><span>1</span><a href="#">2</a><a href="#">3</a><a href="#">4</a><a href="#">5</a><a href="#">下一页</a><a href="#">下五页</a>  跳转到 <select name="PageSelect" onchange=""><option value="" selected="selected">第01页</option><option value="">第02页</option><option value="">第03页</option><option value="">第04页</option><option value="">第05页</option><option value="">第06页</option><option value="index_7.html">第07页</option>
                
               
          </select></div> 
         
          
          
      </div>
        <div class="clear"></div>
    
    </div>
    </div>
</div>

<!-- main结束 -->
<#include "/assets/website/backend/common/footer.html">

</body>
</html>
