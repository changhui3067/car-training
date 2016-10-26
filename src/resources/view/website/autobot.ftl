<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />

<title>培聘网</title>
    <link rel="stylesheet" href="<@url value="/assets/website/css/style.css"/>" type="text/css" media="screen" />
<link rel="stylesheet" href="<@url value="/assets/website/css/pxshi.css"/>" type="text/css" media="screen" />
</head>

<body>
<!-- 头部开始 -->	
<#include "/assets/website/common/header.html">
<!-- 头部结束 -->		

<!-- main开始 -->


<div class="content">
    <div class="ny">
     	<div class="sousuo_box">
        	<div class="pxly">
            	<h4>岗位类型:</h4>
                <div class="pxly_box">
                	<ul>
                    	<li><a href="#">销售市场</a></li>
                        <li><a href="#">售后客服</a></li>
                        <li><a href="#">高级管理</a></li>
                        <li><a href="#">人事财务</a></li>
                        <li><a href="#">内训</a></li>
                        <li><a href="#">生产研发</a></li>
                    </ul>
                </div>
                <div class="clear"></div>
            </div>
            <!--<div class="scxs">
            	<h4>擅长形式:</h4>
                <div class="pxly_box">
                	<ul>
                    	<li><a href="#">开发</a></li>
                        <li><a href="#">培训</a></li>
                        <li><a href="#">辅导</a></li>
                        <li><a href="#">项目管理</a></li>
                        <li><a href="#">经销商托管</a></li>
                        
                    </ul>
                </div>
                <div class="clear"></div>
            </div>-->
            <div class="pxsj">
            	<h4>培训时间:</h4>
                <div class="pxly_box">
                	<ul>
                		<li><a href="#">应界毕业生</a></li>
                    	<li><a href="#">5年内</a></li>
                        <li><a href="#">5-10年</a></li>
                        <li><a href="#">10-15年</a></li>
                        <li><a href="#">15-20年</a></li>
                        <li><a href="#">20年以上</a></li>
                        
                    </ul>
                </div>
                <div class="clear"></div>
            	
            </div>
            <div class="sou">
           	  <h4>关键字</h4>
                <div class="sou_box">
                  <table width="590px" border="0" cellspacing="0" cellpadding="0">
                    <tr>
                      <td width="505px"><input style=" background:url(http://obu3flkwk.bkt.clouddn.com/website/images/ss_bg.jpg) no-repeat left 1px; height:35px; line-height:35px;  width:501px; border:none; padding-left:4px; " type="text" name="user_login"  placeholder="请输入关键字，如销售市场" validate-title="请输入关键字，如销售市场" /></td>
                      <td width="85px" height="35px"  ><input style="border:none; " type="image" src="http://obu3flkwk.bkt.clouddn.com/website/images/ss.jpg" /></td>
                    </tr>
                  </table>
                </div>
          </div>
        </div>
    	
    	
    	<#if autobotsList??>
	       	<#if positionTypeEnum??>
	    		<#list positionTypeEnum?keys as key>
			    	<div class="xiaoshou_box">
			        	<h4><span><a href="#">更多>></a></span>${positionTypeEnum.get(key)!}</h4>
			        	<div class="pxshi">
			            	<ul>
			            		<#list autobotsList as t>
						  			<#if t.positionType?? && positionTypeEnum.get(key) = t.positionType>
						  				<#if t_index = 0>
						                	<li style="border:2px solid #3689b3; padding:0px;">
						                    <div class="pxshi_pic"><a href="/website/AutbotDetail?autobots.id=${t.id!}"><img src="${t.userCenter.headLogo!}" /></a></div>
						                    <div class="pxshi_intro">
						                    	<div class="pxshi_name">
						                        	<div class="pxshi_xm left"><a href="#">${t.userCenter.name!}</a></div>
						                          <div class="pxshi_pl right"><a href="#">34人</a><span>评论</span></div>
						                            
						                            <div class="clear"></div>
						                        </div>
						                          <div class="pxsheng_zw">
						                        	<div class="pxsheng_zw_l left">${t.currentPosition!}</div>
						                            <div class="pxsheng_zw_r  right">工作经验7年</div>
						                            <div class="clear"></div>
						                        </div>
						                        <div class="pxshi_rz">
						                        	<span><a href="#"><img src="http://obu3flkwk.bkt.clouddn.com/website/images/hot2.jpg" /></a></span>
						                            <span><a href="#"><img src="http://obu3flkwk.bkt.clouddn.com/website/images/yrz.jpg" /></a></span>
						                            <span><a href="#"><img src="http://obu3flkwk.bkt.clouddn.com/website/images/dr.jpg" /></a></span>
						                            <span><a href="#"><img src="http://obu3flkwk.bkt.clouddn.com/website/images/zs.jpg" /></a></span>
						                             
						                        </div>
						                    </div>
						                  	</li>
					                  	<#else>
					                  		<#if t_index gt 4>  
		    						   			<#break>
		    						   		</#if>
						                    <li>
						                    <div class="pxshi_pic"><a href="/website/autobotDetail?autobots.id=${t.id!}"><img src="${t.userCenter.headLogo!}" /></a></div>
						                    <div class="pxshi_intro">
						                    	<div class="pxshi_name">
						                        	<div class="pxshi_xm left"><a href="#">${t.userCenter.name!}</a></div>
						                          <div class="pxshi_pl right"><a href="#">34人</a><span>评论</span></div>
						                            
						                            <div class="clear"></div>
						                        </div>
						                          <div class="pxsheng_zw">
						                        	<div class="pxsheng_zw_l left">${t.currentPosition!}</div>
						                            <div class="pxsheng_zw_r  right">工作经验7年</div>
						                            <div class="clear"></div>
						                        </div>
						                        <div class="pxshi_rz">
						                        	<span><a href="#"><img src="http://obu3flkwk.bkt.clouddn.com/website/images/hot2.jpg" /></a></span>
						                            <span><a href="#"><img src="http://obu3flkwk.bkt.clouddn.com/website/images/yrz.jpg" /></a></span>
						                            <span><a href="#"><img src="http://obu3flkwk.bkt.clouddn.com/website/images/dr.jpg" /></a></span>
						                            <span><a href="#"><img src="http://obu3flkwk.bkt.clouddn.com/website/images/zs.jpg" /></a></span>
						                             
						                        </div>
						                    </div>
						                  </li>
					                  </#if>
	                  			</#if>
    						</#list>
			                </ul>
			            </div>
			      </div>
      
      			</#list>
			</#if>
		</#if>
    	
    	
    </div>
        
</div>
    
	

<!-- main结束 -->
<#include "/assets/website/common/footer.html">
</body>
</html>
