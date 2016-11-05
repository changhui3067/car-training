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

<!-- main开始 -->

<div class="stayTuned">
    <p class="text-center">
    <h1>敬请期待...</h1></p>
</div>



<#--<!-- banner开始 &ndash;&gt;	-->
<#--<div class="banner">-->
	<#--<div id="full-screen-slider">-->
	<#--<ul id="slides">-->
		<#--<li style="background:url('http://obu3flkwk.bkt.clouddn.com/website/images/banner3.jpg') no-repeat center top">-->
        <#---->
        <#--</li>		-->
		<#--<li style="background:url('http://obu3flkwk.bkt.clouddn.com/website/images/banner1.jpg') no-repeat center top">-->
        <#---->
        <#--</li>-->
        <#--<li style="background:url('http://obu3flkwk.bkt.clouddn.com/website/images/banner2.jpg') no-repeat center top">-->
        <#---->
        <#--</li>-->
	<#--</ul>-->
<#--</div>-->
<#--</div>-->
	<#--<!-- banner结束 &ndash;&gt;-->
<#--<!-- main开始 &ndash;&gt;-->


<#--<div class="content">-->
    <#--<div class="ny">-->
    	<#--<div class="sousuo_box" style="margin-top:30px;">-->
        	<#--<div class="pxly">-->
            	<#--<h4>培训领域:</h4>-->
                <#--<div class="pxly_box">-->
                	<#--<ul>-->
                    	<#--<li><a href="#">销售</a></li>-->
                        <#--<li><a href="#">产品</a></li>-->
                        <#--<li><a href="#">非技术</a></li>-->
                        <#--<li><a href="#">技术</a></li>-->
                        <#--<li><a href="#">管理</a></li>-->
                        <#--<li><a href="#">财务</a></li>-->
                        <#--<li><a href="#">市场营销</a></li>-->
                        <#--<li><a href="#">客户关系</a></li>-->
                        <#--<li><a href="#">人事</a></li>-->
                        <#--<li><a href="#">生产</a></li>-->
                        <#--<li><a href="#">领导力</a></li>-->
                        <#--<li><a href="#">新能源</a></li>-->
                    <#--</ul>-->
                <#--</div>-->
                <#--<div class="clear"></div>-->
            <#--</div>-->
            <#---->
            <#--<div class="zwdz">-->
            	<#--<h4>培训地点：</h4>-->
                <#--<div class="zwdz_box">-->
                	<#--<table width="250" border="0" cellspacing="0" cellpadding="0"><form id="form1" name="form1" method="post" action="">-->
  <#--<tr>-->
    <#--<td width="29">省</td>-->
    <#--<td width="90">-->
      <#--<select name="select" id="select">-->
        <#--<option value="上海市">上海市</option>-->
        <#--<option value="浙江省">浙江省</option>-->
      <#--</select>-->
    <#--</td>-->
    <#--<td width="37">市</td>-->
    <#--<td width="94"><select name="select2" id="select2">-->
      <#--<option value="上海市">上海市</option>-->
      <#--<option value="浙江省">浙江省</option>-->
    <#--</select></td>-->
  <#--</tr></form>-->
<#--</table>-->

                <#--</div>-->
                <#--<div class="clear"></div>-->
            <#--</div>-->
            <#---->
            <#---->
            <#---->
            <#--<div class="sou">-->
           	  <#--<h4>关键字</h4>-->
                <#--<div class="sou_box">-->
                  <#--<table width="590px" border="0" cellspacing="0" cellpadding="0">-->
                    <#--<tr>-->
                      <#--<td width="505px"><input style=" background:url(http://obu3flkwk.bkt.clouddn.com/website/images/ss_bg.jpg) no-repeat left 1px; height:35px;line-height:35px;   width:501px; border:none; padding-left:4px; " type="text" name="user_login"  placeholder="请输入关键字，如销售市场" validate-title="请输入关键字，如销售市场" /></td>-->
                      <#--<td width="85px" height="35px"><input style="border:none;" type="image" src="http://obu3flkwk.bkt.clouddn.com/website/images/ss.jpg" /></td>-->
                    <#--</tr>-->
                  <#--</table>-->
                <#--</div>-->
          <#--</div>-->
        <#--</div>-->
        <#---->
        	<#--<#if coursesList?? && coursesList.result?? && coursesList.result?size gt 0>-->
        		<#--&lt;#&ndash;>定义行数</#&ndash;&gt;-->
        		<#--<#if coursesList.result?size % 5 gt 0>-->
        		<#--<#assign ronum = coursesList.result?size / 5 + 1>-->
        		<#--<#else>-->
        		<#--<#assign ronum = coursesList.result?size / 5>-->
        		<#--</#if>-->
        		<#---->
        		<#--<#list 1..ronum as i>-->
        			<#--<div class="gkk">-->
        				<#--<ul>-->
        				<#--<#list coursesList.result as t>-->
        					<#--<#if t_index gte 5 * (i-1) && t_index lt 5 * i>-->
        						<#--<#if t_index = 0>-->
        							<#--<li style="border:2px solid #ff7d00; padding:0px;">-->
        						<#--<#else>-->
        							<#--<li>-->
        						<#--</#if>-->
	        							<#--<div class="gkk_pic"><a href="/website/courseDetail?course.id=${t.id!}"><#if t.trainer?? && t.trainer.userCenter??><img src="${t.trainer.userCenter.headLogo}" /></#if></a></div>-->
	        							<#--<div class="gkk_intro">-->
					                    	<#--<div class="gkk_name">-->
					                        	<#--<div class="gkk_xm "><a href="#">${t.courseName!}</a></div>-->
					                        	<#---->
					                        <#--</div>-->
					                        <#--<div class="gkk_zw">-->
					                        	<#--<div class="gkk_zw_l left"><#if t.region??>${t.region.fullname!}</#if></div>-->
					                            <#--<div class="gkk_zw_r  right">${t.publishDate!?string("yyyy-MM-dd")}</div>-->
					                            <#--<div class="clear"></div>-->
					                        <#--</div>-->
					                        <#--<div class="gkk_zw">-->
					                        	<#--<div class="gkk_zw_l left"><font color="ff8100">${t.price!}元</font></div>-->
					                            <#--<div class="gkk_zw_r  right">报名数：<font color="ff8100">58人</font></div>-->
					                            <#--<div class="clear"></div>-->
					                        <#--</div>-->
					                    <#--</div>-->
        							<#--</li>-->
        					<#--</#if>-->
        				<#--</#list>-->
        				<#--</ul>-->
        			<#--</div>-->
    			<#--</#list>-->
        	<#--</#if>-->
        <#---->
        <#---->
			<#--<#if coursesList?? && coursesList.result?? && coursesList.result?size gt 0>-->
            	<#--<div class="fypage" >-->
            	<#---->
            	<#--<#if pageNo gt 5>-->
            	<#--<a data-class="p5" href="javascript:void(0)" onclick="prevFivePage()"">上五页</a>-->
            	<#--<#else>-->
            	<#--<span data-class="p5">上五页</span>-->
            	<#--</#if>-->
            	<#--<#if pageNo gt 1>-->
            	<#--<a data-class="p1" href="/website/courses?pageNo=${pageNo-1}">上一页</a>-->
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
            	<#--<a href="/website/courses?pageNo=${t!}">${t!}</a>-->
            	<#--</#if>-->
            	<#--<#if t = coursesList.totalPage>-->
            	<#--<#break>-->
            	<#--</#if>-->
            	<#--</#list>-->
            	<#---->
            	<#--<#elseif pageNo%5 gt 0>-->
            	<#--<#list (pageNo/5)?floor*5+1..(pageNo/5)?floor*5+5 as t>-->
            	<#--<#if t = pageNo>-->
            	<#--<span>${t!}</span>-->
            	<#--<#else>-->
            	<#--<a href="/website/courses?&pageNo=${t!}">${t!}</a>-->
            	<#--</#if>-->
            	<#--<#if t = coursesList.totalPage>-->
            	<#--<#break>-->
            	<#--</#if>-->
            	<#--</#list>-->
            	<#---->
            	<#--<#elseif pageNo%5 = 0>-->
            	<#--<#list ((pageNo/5)?floor-1)*5+1..(pageNo/5)?floor*5 as t>-->
            	<#--<#if t = pageNo>-->
            	<#--<span>${t!}</span>-->
            	<#--<#else>-->
            	<#--<a href="/website/courses?pageNo=${t!}">${t!}</a>-->
            	<#--</#if>-->
            	<#--<#if t = coursesList.totalPage>-->
            	<#--<#break>-->
            	<#--</#if>-->
            	<#--</#list>-->
            	<#--</#if>-->
            	<#--</div>-->
            	<#---->
            	<#--<#if (coursesList.totalPage - pageNo) gt 0>-->
            	<#--<a data-class="n1" href="/website/courses?pageNo=${pageNo+1}">下一页</a>-->
            	<#--<#else>-->
            	<#--<span data-class="n1" class="">下一页</span>-->
            	<#--</#if>-->
            	<#--<#if (coursesList.totalPage - ((pageNo/5)?ceiling * 5)) gt 4>-->
            	<#--<a data-class="n5" href="javascript:void(0)" onclick="nextFivePage()">下五页</a>-->
            	<#--<#else>-->
            	<#--<span data-class="n5">下五页</span>-->
            	<#--</#if>-->
            	 <#---->
            	<#--跳转到 -->
            	<#--<select name="PageSelect" onchange="jumpPage()">-->
            	<#--<#list 1..coursesList.totalPage as t>-->
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
        <#---->
        <#---->
        <#---->
        <#---->
<#--</div>-->
    <#---->
	<#--<!--分页有关js&ndash;&gt;-->
    <#--<script>-->
    <#---->
		<#--var pageNo = ${pageNo};-->
		<#--<#if coursesList??>-->
			<#--var totalPage = ${coursesList.totalPage};-->
		<#--<#else>-->
			<#--var totalPage = 0;-->
		<#--</#if>-->
		<#--var tarUrl = "/website/courses?";-->
		<#---->
    	<#--function prevFivePage(){-->
    		<#--var pag = '';-->
    		<#--for(var i = Math.floor(pageNo/5) * 5 - 4; i<=Math.floor(pageNo/5)*5;i++){-->
				<#--pag += '<a href="' + tarUrl + 'pageNo=' + i + '">' + i + '</a>';-->
    		<#--}-->
    		<#--pageNo = Math.floor(pageNo/5) * 5 - 4;-->
    		<#--$("div.fypage").find("div[data-class=pag]").html(pag);-->
    		<#--resetPreNex();-->
    	<#--}-->
    	<#--function nextFivePage(){-->
    		<#--var pag = '';-->
    		<#--for(var i = Math.ceil(pageNo/5) * 5 + 1; i<=Math.ceil(pageNo/5) * 5+5;i++){-->
				<#--pag += '<a href="' + tarUrl + 'pageNo=' + i + '">' + i + '</a>';-->
    		<#--}-->
    		<#--pageNo = Math.ceil(pageNo/5) * 5 + 1;-->
    		<#--$("div.fypage").find("div[data-class=pag]").html(pag);-->
    		<#--resetPreNex();-->
    	<#--}-->
    	<#--function resetPreNex(){-->
    		<#--if(pageNo <= 5){-->
    			<#--$("[data-class=p5]").replaceWith('<span data-class="p5">上五页</span>');-->
    		<#--}else{-->
    			<#--$("[data-class=p5]").replaceWith('<a data-class="p5" href="javascript:void(0)" onclick="prevFivePage()"">上五页</a>');-->
    		<#--}-->
    		<#--if(totalPage > Math.ceil(pageNo/5) * 5 + 4){-->
    			<#--$("[data-class=n5]").replaceWith('<a data-class="n5" href="javascript:void(0)" onclick="nextFivePage()"">下五页</a>');-->
    		<#--}else{-->
    			<#--$("[data-class=n5]").replaceWith('<span data-class="n5">下五页</span>');-->
    		<#--}-->
    		<#---->
    	<#--}-->
    	<#---->
    	<#--function jumpPage(){-->
    		<#--window.location.href = tarUrl + 'pageNo=' + $("select[name=PageSelect]").val();	-->
    	<#--}-->
    	<#---->
    <#--</script>-->

<!-- main结束 -->
<#include "/assets/website/common/footer.html">
</body>
</html>
