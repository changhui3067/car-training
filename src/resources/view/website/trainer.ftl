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
                <div class="filterName">领域类型:</div>
                <div class="filterItemList">
                    <span onclick="filterClicked(this,'businessCategory')">销售</span>
                    <span onclick="filterClicked(this,'businessCategory')">产品</span>
                    <span onclick="filterClicked(this,'businessCategory')">技术</span>
                    <span onclick="filterClicked(this,'businessCategory')">管理</span>
                    <span onclick="filterClicked(this,'businessCategory')">财务</span>
                    <span onclick="filterClicked(this,'businessCategory')">市场营销</span>
                    <span onclick="filterClicked(this,'businessCategory')">客户关系</span>
                    <span onclick="filterClicked(this,'businessCategory')">人事</span>
                    <span onclick="filterClicked(this,'businessCategory')">生产</span>
                    <span onclick="filterClicked(this,'businessCategory')">领导力</span>
                    <span onclick="filterClicked(this,'businessCategory')">新能源</span>
                </div>
            </div>

            <div class="filterType">
                <div class="filterName">工作经验:</div>
                <div class="filterItemList">
                    <span onclick="filter2Clicked(this, 'workExperience')">5年内</span>
                    <span onclick="filter2Clicked(this, 'workExperience')">5-10年</span>
                    <span onclick="filter2Clicked(this, 'workExperience')">10-15年</span>
                    <span onclick="filter2Clicked(this, 'workExperience')" >15-20年</span>
                    <span onclick="filter2Clicked(this, 'workExperience')">20年以上</span>
                </div>
            </div>
            <div class="filterType">
                <div class="filterName">执行类型:</div>
                <div class="filterItemList">
                    <span onclick="filterClicked(this, 'excutionCategory')">开发</span>
                    <span onclick="filterClicked(this, 'excutionCategory')">培训</span>
                    <span onclick="filterClicked(this, 'excutionCategory')">辅导</span>
                    <span onclick="filterClicked(this, 'excutionCategory')">项目管理</span>
                    <span onclick="filterClicked(this, 'excutionCategory')">经销商托管</span>
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

var filters = {};

function filterClicked(ele, category) {
    filters[category] = filters[category] ? filters[category] : [];
    if($(ele).hasClass('checked')){
        $(ele).removeClass('checked');
        filters[category].splice($.inArray(ele.innerHTML), 1);
    } else {
        $(ele).addClass('checked');
        filters[category].push(ele.innerHTML)
    }

    sendAjax();
}

function filter2Clicked(ele, category) {
    filters[category] = filters[category] ? filters[category] : "";
    if(!$(ele).hasClass('checked')){
        $(ele).addClass('checked').siblings('span').removeClass('checked');
    }

    switch(ele.innerHTML) {
        case '5年内':
            filters[category] = "0,5"; break;
        case '5-10年':
            filters[category] = "5,10"; break;
        case '10-15年':
            filters[category] = "10,15"; break;
        case '15-20年':
            filters[category] = "15,20"; break;
        case '20年以上':
            filters[category] = "20,100"; break;
        default:
            break;
    }

    sendAjax();
}

function searchBtnClick() {
    filters['keyWord'] = $('#search_input').val();
    sendAjax();
}

function sendAjax() {
    console.log(filters);
    var url  = "website/trainer/search";
    $.ajax({
        type: "GET",
        url: url,
        data: filters,
        error: function(request) {
            console.log("网络出错啦！");
            return false;
        },
        success: function (data) {
            console.log(data);
        }
    });
}
</script>
</body>
</html>
</#escape>