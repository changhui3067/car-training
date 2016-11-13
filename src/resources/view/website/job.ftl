<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />

<title>培聘网</title>
    <link rel="stylesheet" href="<@url value="/assets/website/css/pxshi.css"/>" type="text/css" media="screen" />
<link rel="stylesheet" href="<@url value="/assets/website/css/style.css"/>" type="text/css" media="screen" />
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
            	<h4>职位类型:</h4>
                <div class="pxly_box">
                	<ul>
                    	<li><a href="/website/recruit/?companyType=COMPANY">销售</a></li>
                        <li><a href="/website/recruit/?companyType=COMPANY">售后</a></li>
                        <li><a href="/website/recruit/?companyType=COMPANY">客服</a></li>
                        <li><a href="/website/recruit/?companyType=COMPANY">市场</a></li>
                        <li><a href="/website/recruit/?companyType=COMPANY">管理</a></li>
                        <li><a href="/website/recruit/?companyType=COMPANY">内需</a></li>
                        <li><a href="/website/recruit/?companyType=COMPANY">生产研发</a></li>
                        <li><a href="/website/recruit/?companyType=COMPANY">行政</a></li>
                    </ul>
                </div>
                <div class="clear"></div>
            </div>
            
            <div class="zwdz">
            	<h4>职位地址:</h4>
                <div class="zwdz_box">
                	<table width="250" border="0" cellspacing="0" cellpadding="0"><form id="form1" name="form1" method="post" action="">
  <tr>
    <td width="29">省</td>
    <td width="90">
    <#if regionList??>
    <#list regionList as t>
    ${t.fullname!}
    </#list>
    </#if>
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
          <!--  <div class="pxsj">
            	<h4>发布时间:</h4>
                <div class="pxly_box">
                	<ul>
                    	<li><a href="#">当日</a></li>
                        <li><a href="#">三天</a></li>
                        <li><a href="#">一周</a></li>
                        <li><a href="#">两周</a></li>
                        <li><a href="#">一个月</a></li>
                        
                    </ul>
                </div>
                <div class="clear"></div>
            	
            </div>-->
            <div class="pxxs">
            	<h4>工作经验:</h4>
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
                      <td width="505px"><input style=" background:url(http://obu3flkwk.bkt.clouddn.com/website/images/ss_bg.jpg) no-repeat left 1px; height:35px; line-height:35px;   width:501px; border:none; padding-left:4px; " type="text" name="user_login"  placeholder="请输入关键字，如销售市场" validate-title="请输入关键字，如销售市场" /></td>
                      <td width="85px" height="35px"><input style="border:none;" type="image" src="http://obu3flkwk.bkt.clouddn.com/website/images/ss.jpg" /></td>
                    </tr>
                  </table>
                </div>
          </div>
        </div>
        <div class="pxgs">
        	<div class="pxgs_l left">
            	<div class="pxxq">
            	<#if jobList?? >
            	<ul>
            		<#list jobsStoreList.result as job>
            		<#if job.company??>
                	<li> 
                	<div class="pxxq_l left">
                   	  <a href="/website/jobDetail?jobs.id=${job.id!}"><div class="zw_name">${job.name!}</div></a>
                        <div class="dy_box">
                        	<span class="cn" style="padding-left:0px;"><a href="#">${job.salary!}</a></span><span><a href="#">${job.workExprience!}年工作经验</a></span><span style="background:none;"><a href="#"><#if job.region??>${job.region.fullname}</#if></a></span>
                        </div>
                        <div class="pingpai">
                        <em>当前汽车品牌：</em><span>宝马</span><span>宝马</span>
                        <div class="clear"></div>
                        </div>
                        <div class="fb_box">
                        	<span  style="padding-left:0px;"><a href="#">发布于：${job.publishDate!?string("yyyy-MM-dd")}</a></span><span style="background:none;"><a href="#">投递后：48小时反馈 </a></span>
                        </div>
                    </div>
                    <div class="pxxq_r right">
                   	  <div class="qy">
                        	<div class="qy_l left"><img src="${job.company.logo!}" style="width:100px;height:50px;"/></div>
                          <div class="qy_r right">
                            	<div class="qy_name"><span><a href="#">已有${job.company.bondsmanCount!}人担保</a></span><a href="/website/autoCompany?company.id=${job.company.id!}">${job.company.name!}</a></div>
                                <div class="jyfw"><a href="#">${job.company.industry!}</a></div>
                          </div>
                            <div class="clear"></div>
                        </div>
                        <div class="fl">
                        	<#if job.welfare??>
                        	<#list job.welfare as w>
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
            

            <div class="pxgs_r right">
            	<div class="qy_logo">
                	<ul>
                    	<#list jobList as t>
            			<#if t?? && t.company?? && t ? size gt 0>
                    	<li><a href="#"><img src="${t.company.logoUrl!}" style="width:226px;height:76px;"/></a></li>
                		</#if>
                		</#list>
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
