<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<#escape x as x?html><html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />

<title>培聘网</title>
<link rel="stylesheet" href="<@url value='/assets/website/css/pxshi.css'/>"  type="text/css" media="screen" />
    <link rel="stylesheet" href="<@url value="/assets/website/css/style.css"/>" type="text/css" media="screen" />
<link rel="stylesheet" type="text/css" href="<@url value='/assets/website/css/lrtk.css'/>" >
<script src="<@url value='/assets/website/js/jquery1.42.min.js'/>" type="text/javascript"></script>
<script src="<@url value='/assets/website/js/jquery.superslide.2.1.1.js'/>" type="text/javascript"></script>
</head>

<body>
<!-- 头部开始 -->	
<#include "/assets/website/common/header.html">
<!-- 头部结束 -->		

<!-- main开始 -->

<div class="zhaopin_qy">
    <div class="content" >
    
    	<#if company??>
    
    	<div class="qy_top" >
        	<div class="zpqy_logo left"><img src="http://obu3flkwk.bkt.clouddn.com/website/images/zpqy_logo.jpg" /></div>
            <div class="zpqy_xx right">
            	
                <div class="zpqy_xx_box">
               	  <div class="zpqy_xx_l left">${company.name!}</div>
                    <div class="zpqy_xx_r right"><span ><a href="#"><!--<img src="http://obu3flkwk.bkt.clouddn.com/website/images/db.jpg" />--></a></span><span >已有${bondsmanCount!}人担保</span></div>
                  <div class="clear"></div>
                </div>
                <div class="fl_dy">
                	<ul>
                    	<#if company.welfare??>
                        	<#list company.welfare as w>
                    			<li>${w!}</li>
                            </#list>
                    	</#if>
                    </ul>
                </div>
            </div>
            <div class="clear"></div>
        </div>
        <div class="zp_qiye">
        	<div class="zp_qiye_l left">
            	<div class="gongsi_jj">
            	<div class="qiche_bt">
            	<h4>公司简介</h4>
                </div>
            	<div class="gongsi_jj_box">
               　
	                 ${company.intro!}
           	</div>
            </div>
            	<div class="qiye_zp">
            	<div class="qiche_bt">
            	<h4><span>共<#if jobsCompanyList??>${jobsCompanyList.totalResults!}<#else>0</#if>个职位</span>招聘职位</h4>
                </div>
            	
               <div class="qiye_zp_box">
                    <#if jobsCompanyList?? && jobsCompanyList.result??>
            			<ul>
            		<#list jobsCompanyList.result as t>
            		<#if t?? && t.company??>
                       <li>
                        <div class="zpgw_l left">
                   	  <div class="zw_name"><a href="/website/jobDetail?jobs.id=${t.id!}" >${t.name!}</a></div>
                        <div class="dy_box">
                        	<span class="cn" style="padding-left:0px;"><a href="#">${t.salary!}</a></span><span><a href="#">${t.workExprience!}年工作经验</a></span><span style="background:none;"><a href="#"><#if t.region??>${t.region.fullname}</#if></a></span>
                        </div>
                        
                        <div class="fb_box">
                        	<span  style="padding-left:0px;"><a href="#">发布于：${t.publishDate!?string("yyyy-MM-dd")}</a></span><span style="background:none;"><a href="#">投递后：48小时反馈 </a></span>
                        </div>
                    </div>
                  	    <div class="zpgw_r right">
                   	  	<img src="http://obu3flkwk.bkt.clouddn.com/website/images/ljyp.jpg" / onclick="alert('暂未开放')">
                        
                    </div>
                    <div class="clear"></div>
                      </li>		
                         </#if>
              			</#list>
              			</ul>
            			</#if>
                    </div>
          
			<#if jobsCompanyList?? && jobsCompanyList.result?? && jobsCompanyList.result?size gt 0>
            	<div class="fypage" >
            	
            	<#if pageNo gt 5>
            	<a data-class="p5" href="javascript:void(0)" onclick="prevFivePage()"">上五页</a>
            	<#else>
            	<span data-class="p5">上五页</span>
            	</#if>
            	<#if pageNo gt 1>
            	<a data-class="p1" href="/website/autoCompany?pageNo=${pageNo-1}">上一页</a>
            	<#else>
            	<span data-class="p1" class="">上一页</span>
            	</#if>
            	
            	<div data-class="pag" style="padding:0px;margin:0px;display:inline;">
            	<#if pageNo lt 6>
            	<#list 1..5 as t>
            	<#if t = pageNo>
            	<span>${t!}</span>
            	<#else>
            	<a href="/website/autoCompany?pageNo=${t!}">${t!}</a>
            	</#if>
            	<#if t = jobsCompanyList.totalPage>
            	<#break>
            	</#if>
            	</#list>
            	
            	<#elseif pageNo%5 gt 0>
            	<#list (pageNo/5)?floor*5+1..(pageNo/5)?floor*5+5 as t>
            	<#if t = pageNo>
            	<span>${t!}</span>
            	<#else>
            	<a href="/website/autoCompany?pageNo=${t!}">${t!}</a>
            	</#if>
            	<#if t = jobsCompanyList.totalPage>
            	<#break>
            	</#if>
            	</#list>
            	
            	<#elseif pageNo%5 = 0>
            	<#list ((pageNo/5)?floor-1)*5+1..(pageNo/5)?floor*5 as t>
            	<#if t = pageNo>
            	<span>${t!}</span>
            	<#else>
            	<a href="/website/autoCompany?pageNo=${t!}">${t!}</a>
            	</#if>
            	<#if t = jobsCompanyList.totalPage>
            	<#break>
            	</#if>
            	</#list>
            	</#if>
            	</div>
            	
            	<#if (jobsCompanyList.totalPage - pageNo) gt 0>
            	<a data-class="n1" href="/website/autoCompany?pageNo=${pageNo+1}">下一页</a>
            	<#else>
            	<span data-class="n1" class="">下一页</span>
            	</#if>
            	<#if (jobsCompanyList.totalPage - ((pageNo/5)?ceiling * 5)) gt 4>
            	<a data-class="n5" href="javascript:void(0)" onclick="nextFivePage()">下五页</a>
            	<#else>
            	<span data-class="n5">下五页</span>
            	</#if>
            	 
            	跳转到 
            	<select name="PageSelect" onchange="jumpPage()">
            	<#list 1..jobsCompanyList.totalPage as t>
            	<#if t = pageNo>
            	<option selected="selected" value="${t!}">第${t!}页</option>
            	<#else>
            	<option value="${t!}">第${t!}页</option>
            	</#if>
            	</#list>
               </select>
               </div>
               </#if>

            </div>
            </div>
            <div class="zp_qiye_r right">
            <div class="zwfb_qy">
            	<h4>基本信息</h4>
            	<div class="qyjj">
               	  <h5>${company.name!}</h5>
                    <div class="xz"><em style="font-style:normal;  font-size:12px; height:30px; line-height:30px; color:#000; font-weight:700;">经营范围：</em>汽车销售/以及原厂配件/售后服务</div>
                    <div class="xz"><em style="font-style:normal;  font-size:12px; height:30px; line-height:30px; color:#000; font-weight:700;">公司规模：</em>${company.scale!}</div>
                    <div class="dz"><em style="font-style:normal;  font-size:12px; height:30px; line-height:30px; color:#000; font-weight:700;">公司地址：</em><#if company.region??>${company.region.fullname!}</#if></div>
                    
                    <div class="jj_img">
                    	<!-- 代码 开始 -->
						<div class="www51buycom">
    <ul class="51buypic">
        <li><a href="#" target="_blank"><img src="${company.environmentURL1!}" /></a></li>
       <li><a href="#" target="_blank"><img src="${company.environmentURL2!}" /></a></li>
    </ul>
   
    <div class="num">
    	<ul></ul>
    </div>
</div>
						<script>
/*鼠标移过，左右按钮显示*/
$(".www51buycom").hover(function(){
	$(this).find(".prev,.next").fadeTo("show",0.1);
},function(){
	$(this).find(".prev,.next").hide();
})
/*鼠标移过某个按钮 高亮显示*/
$(".prev,.next").hover(function(){
	$(this).fadeTo("show",0.7);
},function(){
	$(this).fadeTo("show",0.1);
})
$(".www51buycom").slide({ titCell:".num ul" , mainCell:".51buypic" , effect:"fold", autoPlay:true, delayTime:700 , autoPage:true });
</script>
						<!-- 代码 结束 -->
                    </div>
                </div>
            </div>
				
            </div>
            <div class="clear"></div>
        </div>
        
        </#if>
       
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
		var tarUrl = "/website/autoCompany?";
		
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
</html></#escape>
