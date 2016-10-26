<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />

<title>培聘网</title>
    <link rel="stylesheet" href="<@url value="/assets/website/css/style.css"/>" type="text/css" media="screen" />
    <link rel="stylesheet" href="<@url value="/assets/website/css/gkk.css"/>" type="text/css" media="screen" />
<link rel="stylesheet" type="text/css" href="<@url value="/assets/website/css/jquery.jslides.css"/>" media="screen" />
<script src="<@url value="/assets/website/js/jquery-1.8.0.min.js?v=1.1.0"/>"></script>
<script type="text/javascript" src="<@url value="/assets/website/js/jquery.jslides.js"/>"></script>
</head>

<body>
<!-- 头部开始 -->	
<#include "/assets/website/common/header.html">
<!-- 头部结束 -->	
<!-- banner开始 -->	
<div class="banner">
	<div id="full-screen-slider">
	<ul id="slides">
		<li style="background:url('http://obu3flkwk.bkt.clouddn.com/website/images/banner3.jpg') no-repeat center top">
        
        </li>		
		<li style="background:url('http://obu3flkwk.bkt.clouddn.com/website/images/banner1.jpg') no-repeat center top">
        
        </li>
        <li style="background:url('http://obu3flkwk.bkt.clouddn.com/website/images/banner2.jpg') no-repeat center top">
        
        </li>
	</ul>
</div>
</div>
	<!-- banner结束 -->
<!-- main开始 -->


<div class="content">
    <div class="ny">
    	<div class="sousuo_box" style="margin-top:30px;">
        	<div class="pxly">
            	<h4>培训领域:</h4>
                <div class="pxly_box">
                	<ul>
                    	<li><a href="#">销售</a></li>
                        <li><a href="#">产品</a></li>
                        <li><a href="#">非技术</a></li>
                        <li><a href="#">技术</a></li>
                        <li><a href="#">管理</a></li>
                        <li><a href="#">财务</a></li>
                        <li><a href="#">市场营销</a></li>
                        <li><a href="#">客户关系</a></li>
                        <li><a href="#">人事</a></li>
                        <li><a href="#">生产</a></li>
                        <li><a href="#">领导力</a></li>
                        <li><a href="#">新能源</a></li>
                    </ul>
                </div>
                <div class="clear"></div>
            </div>
            
            <div class="zwdz">
            	<h4>培训地点：</h4>
                <div class="zwdz_box">
                	<table width="250" border="0" cellspacing="0" cellpadding="0"><form id="form1" name="form1" method="post" action="">
  <tr>
    <td width="29">省</td>
    <td width="90">
      <select name="select" id="select">
        <option value="上海市">上海市</option>
        <option value="浙江省">浙江省</option>
      </select>
    </td>
    <td width="37">市</td>
    <td width="94"><select name="select2" id="select2">
      <option value="上海市">上海市</option>
      <option value="浙江省">浙江省</option>
    </select></td>
  </tr></form>
</table>

                </div>
                <div class="clear"></div>
            </div>
            
            
            
            <div class="sou">
           	  <h4>关键字</h4>
                <div class="sou_box">
                  <table width="590px" border="0" cellspacing="0" cellpadding="0">
                    <tr>
                      <td width="505px"><input style=" background:url(http://obu3flkwk.bkt.clouddn.com/website/images/ss_bg.jpg) no-repeat left 1px; height:35px;line-height:35px;   width:501px; border:none; padding-left:4px; " type="text" name="user_login"  placeholder="请输入关键字，如销售市场" validate-title="请输入关键字，如销售市场" /></td>
                      <td width="85px" height="35px"><input style="border:none;" type="image" src="http://obu3flkwk.bkt.clouddn.com/website/images/ss.jpg" /></td>
                    </tr>
                  </table>
                </div>
          </div>
        </div>
        
        	<#if coursesList?? && coursesList?size gt 0>
        		<#list coursesList as t>
        			<#if t_index = 0 || t_index % 5 = 1>
        			<div class="gkk">
        				<ul>
    				</#if>
        					<#list 1..5 as i>
        						<#if t_index = 0>
        							<li style="border:2px solid #ff7d00; padding:0px;">
								<#else>
									<li>
        						</#if>
        							
        							<div class="gkk_pic"><a href="#"><#if t.trainer?? && t.trainer.userCenter??><img src="${t.trainer.userCenter.headLogo}" /></#if></a></div>
        							<div class="gkk_intro">
				                    	<div class="gkk_name">
				                        	<div class="gkk_xm "><a href="#">${t.courseName!}</a></div>
				                        	
				                        </div>
				                        <div class="gkk_zw">
				                        	<div class="gkk_zw_l left"><#if t.region??>${t.region.fullname!}</#if></div>
				                            <div class="gkk_zw_r  right">${t.publishDate}</div>
				                            <div class="clear"></div>
				                        </div>
				                        <div class="gkk_zw">
				                        	<div class="gkk_zw_l left"><font color="ff8100">${price!}元</font></div>
				                            <div class="gkk_zw_r  right">报名数：<font color="ff8100">58人</font></div>
				                            <div class="clear"></div>
				                        </div>
				                    </div>
        							</li>
        					</#list>
					<#if t_index = 0 || t_index % 5 = 1>
        				</ul>
        			</div>
        			</#if>
    			</#list>
        	</#if>
        
        <div class="fypage" ><span>上五页</span><span class="">上一页</span><span>1</span><a href="#">2</a><a href="#">3</a><a href="#">4</a><a href="#">5</a><a href="#">下一页</a><a href="#">下五页</a>  跳转到 <select name="PageSelect" onchange=""><option value="" selected="selected">第01页</option><option value="">第02页</option><option value="">第03页</option><option value="">第04页</option><option value="">第05页</option><option value="">第06页</option><option value="index_7.html">第07页</option>
                
               
               </select></div>
    </div>
        
        
        
        
</div>
    
	

<!-- main结束 -->
<#include "/assets/website/common/footer.html">
</body>
</html>
