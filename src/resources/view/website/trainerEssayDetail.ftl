<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />

<title>培聘网</title>
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
    	<#if trainerEssay??>
        	<div class="zt_l left">
            	<div class="wenti">
                    <div class="wt_box center">
                    	<center><h4>${trainerEssay.title!}</h4></center> 
                    	发布日期：${trainerEssay.publishDate!?string("yyyy-MM-dd")}&nbsp;&nbsp; &nbsp;作者：${trainerEssay.trainer.userCenter.name!}<br/><br/>
                    	
                    	${trainerEssay.content!}
                    </div>
                </div>
                </div>
            </#if>
            
            <div class="clear"></div>
        </div>
  </div>
</div>
    
	

<!-- main结束 -->
<#include "/assets/website/common/footer.html">
</body>
</html>
