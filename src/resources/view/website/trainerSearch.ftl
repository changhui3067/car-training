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
     	<div class="searchBox">
        	<div class="filterType">
            	<div class="filterName">职位类型:</div>
                <div class="filterItemList">
                    <span>销售</span>
                    <span>产品</span>
                    <span>非技术</span>
                    <span>技术</span>
                    <span>管理</span>
                    <span>财务</span>
                    <span>市场营销</span>
                    <span>客户关系</span>
                    <span>人事</span>
                    <span>生产</span>
                    <span>领导力</span>
                    <span>新能源</span>
                </div>
                <div class="clear"></div>
            </div>
            
            <div class="filterType">
            	<div class="filterName">职位地址:</div>
                <div class="filterItemList">
                </div>
                <div class="clear"></div>
            </div>
            <div class="filterType">
            	<div class="filterName">发布时间:</div>
                <div class="filterItemList">
                    <span>当日</span><span>三天</span><span>一周</span><span>两周</span><span>一个月</span>
                </div>
                <div class="clear"></div>
            	
            </div>
            <div class="filterType">
            	<div class="filterName">培训形式:</div>
                <div class="filterItemList">
                    <span>开发</span><span>培训</span><span>辅导</span><span>项目管理</span><span>经销商托管</span>
                </div>
                <div class="clear"></div>
            </div>
            <div class="filterType">
            	<div class="filterName">工作性质:</div>
                <div class="filterItemList">
                    <span>全职</span><span>兼职</span>
                </div>
                <div class="clear"></div>
            </div>
            <div class="filterType">
           	  <div class="filterName">关键字</div>
                <div class="filterItemList">
                  <table width="590px" border="0" cellspacing="0" cellpadding="0">
                    <tr>
                      <td width="505px"><input style=" background:url(http://obu3flkwk.bkt.clouddn.com/website/images/ss_bg.jpg) no-repeat left 1px; height:35px;line-height:35px;   width:501px; border:none; padding-left:4px; " type="text" name="user_login"  placeholder="请输入关键字，如销售市场" validate-title="请输入关键字，如销售市场" /></td>
                      <td width="85px" height="35px"><input style="border:none;" type="image" src="http://obu3flkwk.bkt.clouddn.com/website/images/ss.jpg" /></td>
                    </tr>
                  </table>
                </div>
          </div>
        </div>
        <div class="pxgs">
        	<div class="pxgs_l left">
            	<div class="pxxq">
            	<#if jobsCompanyList??>
            	<ul>
            		<#list jobsCompanyList.result as t>
            		<#if t?? && t.company??>
                	<li>
                	<div class="qz"></div> <div class="pxxq_l left">
                   	  <div class="zw_name">${t.name!}</div>
                        <div class="dy_box">
                        	<span class="cn" style="padding-left:0px;"><a href="#">8-10万</a></span><span><a href="#">${t.workExprience!}年工作经验</a></span><span style="background:none;"><a href="#"><#if t.region??>${t.region.fullname}</#if></a></span>
                        </div>
                        <div class="fb_box">
                        	<span  style="padding-left:0px;"><a href="#">发布于：${t.publishDate!}</a></span><span style="background:none;"><a href="#">投递后：48小时反馈 </a></span>
                        </div>
                    </div>
                    <div class="pxxq_r right">
                   	  <div class="qy">
                        	<div class="qy_l left"><img src="${t.company.logo!}" /></div>
                          <div class="qy_r right">
                            	<div class="qy_name"><span><a href="#">已有25人担保</a></span><a href="#">${t.company.name!}</a></div>
                                <div class="jyfw"><a href="#">汽车销售、汽车维修、团队管理、售后服务</a></div>
                          </div>
                            <div class="clear"></div>
                        </div>
                        <div class="fl">
                        	<#if t.welfare??>
                        	<#list t.welfare as w>
                        	<span><a href="#">${w!}</a></span>
                            </#list>
                        	</#if>
                        </div>
                    </div>
                    <div class="clear"></div>
                 </li>
                 </#if>
            	</#list>
              </ul>
            	</#if>
            </div>
            	<div class="fypage" ><span>上五页</span><span class="">上一页</span><span>1</span><a href="#">2</a><a href="#">3</a><a href="#">4</a><a href="#">5</a><a href="#">下一页</a><a href="#">下五页</a>  跳转到 <select name="PageSelect" onchange=""><option value="" selected="selected">第01页</option><option value="">第02页</option><option value="">第03页</option><option value="">第04页</option><option value="">第05页</option><option value="">第06页</option><option value="index_7.html">第07页</option>
                
               
               </select></div>
            </div>
            <div class="pxgs_r right">
            	<div class="qy_logo">
                	<ul>
                    	<li><a href="#"><img src="http://obu3flkwk.bkt.clouddn.com/website/images/qy_logo_img.jpg" /></a></li>
                        <li><a href="#"><img src="http://obu3flkwk.bkt.clouddn.com/website/images/qy_logo_img.jpg" /></a></li>
                        <li><a href="#"><img src="http://obu3flkwk.bkt.clouddn.com/website/images/qy_logo_img.jpg" /></a></li>
                        <li><a href="#"><img src="http://obu3flkwk.bkt.clouddn.com/website/images/qy_logo_img.jpg" /></a></li>
                        <li><a href="#"><img src="http://obu3flkwk.bkt.clouddn.com/website/images/qy_logo_img.jpg" /></a></li>
                        <li><a href="#"><img src="http://obu3flkwk.bkt.clouddn.com/website/images/qy_logo_img.jpg" /></a></li>
                        <li><a href="#"><img src="http://obu3flkwk.bkt.clouddn.com/website/images/qy_logo_img.jpg" /></a></li>
                        <li><a href="#"><img src="http://obu3flkwk.bkt.clouddn.com/website/images/qy_logo_img.jpg" /></a></li>
                        <li><a href="#"><img src="http://obu3flkwk.bkt.clouddn.com/website/images/qy_logo_img.jpg" /></a></li>
                        <li><a href="#"><img src="http://obu3flkwk.bkt.clouddn.com/website/images/qy_logo_img.jpg" /></a></li>
                        <li><a href="#"><img src="http://obu3flkwk.bkt.clouddn.com/website/images/qy_logo_img.jpg" /></a></li>
                        <li><a href="#"><img src="http://obu3flkwk.bkt.clouddn.com/website/images/qy_logo_img.jpg" /></a></li>
                    </ul>
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
