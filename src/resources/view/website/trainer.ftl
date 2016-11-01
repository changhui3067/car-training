<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<#escape x as x?html><html>
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
                    <span onclick="filterClicked(this)">销售</span>
                    <span onclick="filterClicked(this)">产品</span>
                    <span onclick="filterClicked(this)">非技术</span>
                    <span onclick="filterClicked(this)">技术</span>
                    <span onclick="filterClicked(this)">管理</span>
                    <span onclick="filterClicked(this)">财务</span>
                    <span onclick="filterClicked(this)">市场营销</span>
                    <span onclick="filterClicked(this)">客户关系</span>
                    <span onclick="filterClicked(this)">人事</span>
                    <span onclick="filterClicked(this)">生产</span>
                    <span onclick="filterClicked(this)">领导力</span>
                    <span onclick="filterClicked(this)">新能源</span>
                </div>
            </div>

            <div class="filterType">
                <div class="filterName">发布时间:</div>
                <div class="filterItemList">
                    <span>当日</span><span>三天</span><span>一周</span><span>两周</span><span>一个月</span>
                </div>
            </div>
            <div class="filterType">
                <div class="filterName">培训形式:</div>
                <div class="filterItemList">
                    <span>开发</span><span>培训</span><span>辅导</span><span>项目管理</span><span>经销商托管</span>
                </div>
            </div>
            <div class="filterType">
                <div class="filterName">工作性质:</div>
                <div class="filterItemList">
                    <span>全职</span><span>兼职</span>
                </div>
            </div>
            <div class="filterType">
                <div class="filterName">关键字:</div>
                <div class="filterItemList">
                    <input type="text" id="search_input"  placeholder="请输入关键字，如销售市场" validate-title="请输入关键字，如销售市场" />
                    <button onclick="searchBtnClick()">搜索</button>
                </div>
            </div>
        </div>
        
        <#if trainerList??>
       <#if businessCategoryEnum??>
    		<#list businessCategoryEnum?keys as key>
    			<div class="xiaoshou_box">
    				<h4><span><a href="#">更多>></a></span>${businessCategoryEnum.get(key)!}</h4>
    				
    				<div class="pxshi">
    					<ul>
    						<#list trainerList as t>
	    						<#if t?? && t.businessCategory??>
	    						  <#list t.businessCategory as b>
	    						  	<#if businessCategoryEnum.get(key) ? index_of(b) !=-1 >
	    						  		<#if t_index = 0>
    						   		<li style="border:2px solid #ff7d00; padding:0px;">
    						   		<#if t.userCenter??>
    						   			<div class="pxshi_pic"><a href="/website/trainerDetail?trainer.id=${t.id!}"><img src="${t.userCenter.headLogo!}" /></a></div>
    						   			<div class="pxshi_intro">
					                    	<div class="pxshi_name">
					                        	<div class="pxshi_xm left"><a href="#">${t.userCenter.name!}</a></div>
					                          <div class="pxshi_pl right"><a href="#"><#if t.autobotsCommentList??> ${t.autobotsCommentList.size!}<#else>0</#if>人</a><span>评论</span></div>
					                            
					                            <div class="clear"></div>
					                        </div>
					                          <div class="pxshi_zp"><a href="#">${t.currentPosition!}</a></div>
					                        <div class="pxshi_rz">
					                        	<span><a href="#"><img src="http://obu3flkwk.bkt.clouddn.com/website/images/hot.jpg" /></a></span>
					                            <span><a href="#"><img src="http://obu3flkwk.bkt.clouddn.com/website/images/zan.jpg" /></a></span>
					                            <span><a href="#"><img src="http://obu3flkwk.bkt.clouddn.com/website/images/zheng.jpg" /></a></span>
					                            <span><a href="#"><img src="http://obu3flkwk.bkt.clouddn.com/website/images/xin.jpg" /></a></span>
					                             <span><a href="#"><img src="http://obu3flkwk.bkt.clouddn.com/website/images/zishen.jpg" /></a></span> 
					                              <span><a href="#"><img src="http://obu3flkwk.bkt.clouddn.com/website/images/dav.jpg" /></a></span>  
					                        </div>
					                    </div>
				                    </#if>
    						   		</li>
    						   <#else>
    						   		<#if t_index gt 4>  
    						   			<#break>
    						   		</#if>
    						   		<li>
    						   			<#if t.userCenter??>
    						   			<div class="pxshi_pic"><a href="/website/trainerDetail?trainer.id=${t.id!}"><img src="${t.userCenter.headLogo!}" /></a></div>
    						   			<div class="pxshi_intro">
					                    	<div class="pxshi_name">
					                        	<div class="pxshi_xm left"><a href="#">${t.userCenter.name!}</a></div>
					                          <div class="pxshi_pl right"><a href="#">34人</a><span>评论</span></div>
					                            
					                            <div class="clear"></div>
					                        </div>
					                          <div class="pxshi_zp"><a href="#">${t.currentPosition!}</a></div>
					                        <div class="pxshi_rz">
					                        	<span><a href="#"><img src="http://obu3flkwk.bkt.clouddn.com/website/images/hot.jpg" /></a></span>
					                            <span><a href="#"><img src="http://obu3flkwk.bkt.clouddn.com/website/images/zan.jpg" /></a></span>
					                            <span><a href="#"><img src="http://obu3flkwk.bkt.clouddn.com/website/images/zheng.jpg" /></a></span>
					                            <span><a href="#"><img src="http://obu3flkwk.bkt.clouddn.com/website/images/xin.jpg" /></a></span>
					                             <span><a href="#"><img src="http://obu3flkwk.bkt.clouddn.com/website/images/zishen.jpg" /></a></span> 
					                              <span><a href="#"><img src="http://obu3flkwk.bkt.clouddn.com/website/images/dav.jpg" /></a></span>  
					                        </div>
					                    </div>
				                    </#if>
    						   		</li>
    						   </#if>
	    						  	</#if>
	    						  </#list>
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

<script src="/assets/website/js/jquery-3.1.1.min.js" type="text/javascript"></script>
<script src='/assets/website/js/bootstrap.min.js' type="text/javascript"></script>
<script type="text/javascript">

var filterList = [];

function filterClicked(ele) {
    if($(ele).hasClass('checked')){
        $(ele).removeClass('checked');
        filterList.splice(ele.innerHTML)
    } else {
        $(ele).addClass('checked');
        filterList.push(ele.innerHTML)
    }

    console.log('selected filter: ' + filterList.join())

}

function searchBtnClick() {
    var searchInput = $('#search_input').val();
    console.log('input string: ' + searchInput)
}
</script>
</body>
</html>
</#escape>