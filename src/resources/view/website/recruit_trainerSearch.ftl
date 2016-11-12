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
            	<h4>职位类型:</h4>
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
            	<h4>职位地址:</h4>
                <div class="zwdz_box">
                	<table width="250" border="0" cellspacing="0" cellpadding="0">
                	<form id="form1" name="form1" method="post" action="">
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
            <!--<div class="pxsj">
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
            	<h4>培训形式:</h4>
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
            </div>
            <div class="gzxz">
            	<h4>工作性质:</h4>
                <div class="gzxz_box">
                	<ul>
                    	<li><a href="#">全职</a></li>
                        <li><a href="#">兼职</a></li>
                       
                        
                    </ul>
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
        <div class="pxxq_box">
            <div class="pxxq pxgs_list">
            <#if jobsCompanyList??>
                <ul>
                    <#list jobsCompanyList.result as t>
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
        <#--<div class="pxgs">-->
        	<#--<div class="pxgs_l left">-->
            	<#--<div class="pxxq">-->
            	<#--<#if jobsCompanyList?? && jobsCompanyList.result??>-->
            	<#--<ul>-->
            		<#--<#list jobsCompanyList.result as t>-->
            		<#--<#if t?? && t.company??>-->
                	<#--<li>-->
                	<#--<div class="qz"></div> <div class="pxxq_l left">-->
                   	  <#--<a href="/website/jobDetail?jobs.id=${t.id!}"><div class="zw_name">${t.name!}</div></a>-->
                        <#--<div class="dy_box">-->
                        	<#--<span class="cn" style="padding-left:0px;"><a href="#">${t.salary!}</a></span><span><a href="#">${t.workExprience!}年工作经验</a></span><span style="background:none;"><a href="#"><#if t.region??>${t.region.fullname}</#if></a></span>-->
                        <#--</div>-->
                        <#--<div class="fb_box">-->
                        	<#--<span  style="padding-left:0px;"><a href="#">发布于：${t.publishDate!?string("yyyy-MM-dd")}</a></span><span style="background:none;"><a href="#">投递后：48小时反馈 </a></span>-->
                        <#--</div>-->
                    <#--</div>-->
                    <#--<div class="pxxq_r right">-->
                   	  <#--<div class="qy">-->
                        	<#--<div class="qy_l left"><img src="${t.company.logo!}" style="width:100px;height:50px;"/></div>-->
                          <#--<div class="qy_r right">-->
                            	<#--<div class="qy_name"><span><a href="#">已有${t.company.bondsmanCount!}人担保</a></span><a href="/website/autoCompany?company.id=${t.company.id!}">${t.company.name!}</a></div>-->
                                <#--<div class="jyfw"><a href="#">${t.company.industry!}</a></div>-->
                          <#--</div>-->
                            <#--<div class="clear"></div>-->
                        <#--</div>-->
                        <#--<div class="fl">-->
                        	<#--<#if t.welfare??>-->
                        	<#--<#list t.welfare as w>-->
                        	<#--<span><a href="#">${w!}</a></span>-->
                            <#--</#list>-->
                        	<#--</#if>-->
                        <#--</div>-->
                    <#--</div>-->
                    <#--<div class="clear"></div>-->
                 <#--</li>-->
                 <#--</#if>-->
            	<#--</#list>-->
              <#--</ul>-->
            	<#--</#if>-->
            <#--</div>-->
            	<#--<#if jobsCompanyList?? && jobsCompanyList.result?? && jobsCompanyList.result?size gt 0>-->
            	<#--<div class="fypage" >-->
            	<#---->
            	<#--<#if pageNo gt 5>-->
            	<#--<a data-class="p5" href="javascript:void(0)" onclick="prevFivePage()"">上五页</a>-->
            	<#--<#else>-->
            	<#--<span data-class="p5">上五页</span>-->
            	<#--</#if>-->
            	<#--<#if pageNo gt 1>-->
            	<#--<a data-class="p1" href="/website/recruit/?companyType=COMPANY&pageNo=${pageNo-1}">上一页</a>-->
            	<#--<#else>-->
            	<#--<span data-class="p1" class="">上一页</span>-->
            	<#--</#if>-->
            	<#---->
            	<#--<div data-class="pag" style="padding:0px;margin:0px;display:inline;">-->
            	<#--<#if pageNo lt 6>-->
            	<#--<#list 1..5 as t>-->
            	<#--<#if t = pageNo>-->
            	<#--<span>${t!}</span>-->
            	<#--<#else>-->
            	<#--<a href="/website/recruit/?companyType=COMPANY&pageNo=${t!}">${t!}</a>-->
            	<#--</#if>-->
            	<#--<#if t = jobsCompanyList.totalPage>-->
            	<#--<#break>-->
            	<#--</#if>-->
            	<#--</#list>-->
            	<#---->
            	<#--<#elseif pageNo%5 gt 0>-->
            	<#--<#list (pageNo/5)?floor*5+1..(pageNo/5)?floor*5+5 as t>-->
            	<#--<#if t = pageNo>-->
            	<#--<span>${t!}</span>-->
            	<#--<#else>-->
            	<#--<a href="/website/recruit/?companyType=COMPANY&pageNo=${t!}">${t!}</a>-->
            	<#--</#if>-->
            	<#--<#if t = jobsCompanyList.totalPage>-->
            	<#--<#break>-->
            	<#--</#if>-->
            	<#--</#list>-->
            	<#---->
            	<#--<#elseif pageNo%5 = 0>-->
            	<#--<#list ((pageNo/5)?floor-1)*5+1..(pageNo/5)?floor*5 as t>-->
            	<#--<#if t = pageNo>-->
            	<#--<span>${t!}</span>-->
            	<#--<#else>-->
            	<#--<a href="/website/recruit/?companyType=COMPANY&pageNo=${t!}">${t!}</a>-->
            	<#--</#if>-->
            	<#--<#if t = jobsCompanyList.totalPage>-->
            	<#--<#break>-->
            	<#--</#if>-->
            	<#--</#list>-->
            	<#--</#if>-->
            	<#--</div>-->
            	<#---->
            	<#--<#if (jobsCompanyList.totalPage - pageNo) gt 0>-->
            	<#--<a data-class="n1" href="/website/recruit/?companyType=COMPANY&pageNo=${pageNo+1}">下一页</a>-->
            	<#--<#else>-->
            	<#--<span data-class="n1" class="">下一页</span>-->
            	<#--</#if>-->
            	<#--<#if (jobsCompanyList.totalPage - ((pageNo/5)?ceiling * 5)) gt 4>-->
            	<#--<a data-class="n5" href="javascript:void(0)" onclick="nextFivePage()">下五页</a>-->
            	<#--<#else>-->
            	<#--<span data-class="n5">下五页</span>-->
            	<#--</#if>-->
            	 <#---->
            	<#--跳转到 -->
            	<#--<select name="PageSelect" onchange="jumpPage()">-->
            	<#--<#list 1..jobsCompanyList.totalPage as t>-->
            	<#--<#if t = pageNo>-->
            	<#--<option selected="selected" value="${t!}">第${t!}页</option>-->
            	<#--<#else>-->
            	<#--<option value="${t!}">第${t!}页</option>-->
            	<#--</#if>-->
            	<#--</#list>-->
               <#--</select>-->
               <#--</div>-->
               <#--</#if>-->
            <#--</div>-->
            <#--<div class="pxgs_r right">-->
            	<#--<div class="qy_logo">-->
                	<#--<ul>-->
                		<#--<#list jobsCompanyList.result as t>-->
            			<#--<#if t?? && t.company?? && t ? size gt 0>-->
                    	<#--<li><a href="#"><img src="${t.company.logo!}" style="width:226px;height:76px;"/></a></li>-->
                		<#--</#if>-->
                		<#--</#list>-->
                    <#--</ul>-->
                <#--</div>-->
            <#--</div>-->
            <#--<div class="clear"></div>-->
        <#--</div>-->
    </div>
        
        
        
        
</div>
    
    <!--分页有关js-->
    <script>
    
		var pageNo = ${pageNo};
		<#if jobsCompanyList??>
			var totalPage = ${jobsCompanyList.totalPage};
		<#else>
			var totalPage = 0;
		</#if>
		var tarUrl = "/website/recruit/?companyType=COMPANY&";
		
    	function prevFivePage(){
    		var pag = '';
    		for(var i = Math.floor(pageNo/5) * 5 - 4; i<=Math.floor(pageNo/5)*5;i++){
				pag += '<a href="' + tarUrl + 'pageNo=' + i + '">' + i + '</a>';
    		}
    		pageNo = Math.floor(pageNo/5) * 5 - 4;
    		$("div.fypage").find("div[data-class=pag]").html(pag);
    		resetPreNex();
    	}
    	function nextFivePage(){
    		var pag = '';
    		for(var i = Math.ceil(pageNo/5) * 5 + 1; i<=Math.ceil(pageNo/5) * 5+5;i++){
				pag += '<a href="' + tarUrl + 'pageNo=' + i + '">' + i + '</a>';
    		}
    		pageNo = Math.ceil(pageNo/5) * 5 + 1;
    		$("div.fypage").find("div[data-class=pag]").html(pag);
    		resetPreNex();
    	}
    	function resetPreNex(){
    		if(pageNo <= 5){
    			$("[data-class=p5]").replaceWith('<span data-class="p5">上五页</span>');
    		}else{
    			$("[data-class=p5]").replaceWith('<a data-class="p5" href="javascript:void(0)" onclick="prevFivePage()"">上五页</a>');
    		}
    		if(totalPage > Math.ceil(pageNo/5) * 5 + 4){
    			$("[data-class=n5]").replaceWith('<a data-class="n5" href="javascript:void(0)" onclick="nextFivePage()"">下五页</a>');
    		}else{
    			$("[data-class=n5]").replaceWith('<span data-class="n5">下五页</span>');
    		}
    		
    	}
    	
    	function jumpPage(){
    		window.location.href = tarUrl + 'pageNo=' + $("select[name=PageSelect]").val();	
    	}
    	
    </script>
    
<!-- main结束 -->
<#include "/assets/website/common/footer.html">
</body>
</html>
