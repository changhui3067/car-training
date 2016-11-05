<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<#escape x as x?html><html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />

<title>培聘网</title>
    <link rel="stylesheet" href="<@url value="/assets/website/css/style.css"/>" type="text/css" media="screen" />
    <link rel="stylesheet" href="<@url value="/assets/website/css/pxshi.css"/>" type="text/css" media="screen" />
    <link rel="stylesheet" href="<@url value="/assets/website/css/iconfont.css"/>" type="text/css" media="screen" />
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
                    <span onclick="filterClicked(this)">销售</span>
                    <span onclick="filterClicked(this)">产品</span>
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
                <div class="filterName">工作经验:</div>
                <div class="filterItemList">
                    <span onclick="filter2Clicked(this)">5年内</span>
                    <span onclick="filter2Clicked(this)">5-10年</span>
                    <span onclick="filter2Clicked(this)">10-15年</span>
                    <span onclick="filter2Clicked(this)" >15-20年</span>
                    <span onclick="filterClicked(this)">20年以上</span>
                </div>
            </div>
            <div class="filterType">
                <div class="filterName">执行类型:</div>
                <div class="filterItemList">
                    <span onclick="filterClicked(this)">开发</span>
                    <span onclick="filterClicked(this)">培训</span>
                    <span onclick="filterClicked(this)">辅导</span>
                    <span onclick="filterClicked(this)">项目管理</span>
                    <span onclick="filterClicked(this)">经销商托管</span>
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

        <div class="pxshilist">
            <#if trainerList??>
                <ul>
                    <#list trainerList as t>
                        <li class="oneBox">
                            <#if t?? && t.userCenter??>
                                <div class="picContainer"><a href="/website/trainerDetail?trainer.id=${t.id!}"><img src="${t.userCenter.headLogo!}" /></a></div>
                                <div class="intro">
                                    <div>
                                        <div class="name">${t.userCenter.name!}</div>
                                        <div class="right"><i class="iconfont" title="点赞">&#xe717;</i>${t.starLevel!}</div>
                                        <div class="right"><i class="iconfont" title="评论">&#xe69b;</i><#if t.autobotsCommentList??> ${t.autobotsCommentList.size!}<#else>0</#if></div>
                                        <div class="clear"></div>
                                    </div>
                                    <div>${t.currentPosition!} </div>
                                    <div>
                                        <span><i class="iconfont" title="留言多">&#xe756;</i></span>
                                        <span><i class="iconfont" title="资料完整">&#xe69f;</i></span>
                                        <span><i class="iconfont" title="身份信息可靠">&#xe70a;</i></span>
                                        <span><i class="iconfont" title="培训经验超过10年">&#xe735;</i></span>
                                        <span><i class="iconfont" title="行业经验超过20年">&#xe726;</i></span>
                                    </div>
                                </div>
                            </#if>
                        </li>

                    </#list>
                </ul>
            </#if>
        </div>

    <#-- 分页 -->
        <div class="page">
            <#if topicList?? && topicList.result?? && topicList.result?size gt 0>
                <div class="fypage" >

                    <#if pageNo gt 5>
                        <a data-class="p5" href="javascript:void(0)" onclick="prevFivePage()"">上五页</a>
                    <#else>
                        <span data-class="p5">上五页</span>
                    </#if>
                    <#if pageNo gt 1>
                        <a data-class="p1" href="/website/topic?pageNo=${pageNo-1}">上一页</a>
                    <#else>
                        <span data-class="p1" class="">上一页</span>
                    </#if>

                    <div data-class="pag" style="padding:0px;margin:0px;display:inline;">
                        <#if pageNo lt 6>
                            <#list 1..5 as t>
                                <#if t = pageNo>
                                    <span>${t!}</span>
                                <#else>
                                    <a href="/website/topic?pageNo=${t!}">${t!}</a>
                                </#if>
                                <#if t = topicList.totalPage>
                                    <#break>
                                </#if>
                            </#list>

                        <#elseif pageNo%5 gt 0>
                            <#list (pageNo/5)?floor*5+1..(pageNo/5)?floor*5+5 as t>
                                <#if t = pageNo>
                                    <span>${t!}</span>
                                <#else>
                                    <a href="/website/topic?&pageNo=${t!}">${t!}</a>
                                </#if>
                                <#if t = topicList.totalPage>
                                    <#break>
                                </#if>
                            </#list>

                        <#elseif pageNo%5 = 0>
                            <#list ((pageNo/5)?floor-1)*5+1..(pageNo/5)?floor*5 as t>
                                <#if t = pageNo>
                                    <span>${t!}</span>
                                <#else>
                                    <a href="/website/topic?pageNo=${t!}">${t!}</a>
                                </#if>
                                <#if t = topicList.totalPage>
                                    <#break>
                                </#if>
                            </#list>
                        </#if>
                    </div>

                    <#if (topicList.totalPage - pageNo) gt 0>
                        <a data-class="n1" href="/website/topic?pageNo=${pageNo+1}">下一页</a>
                    <#else>
                        <span data-class="n1" class="">下一页</span>
                    </#if>
                    <#if (topicList.totalPage - ((pageNo/5)?ceiling * 5)) gt 4>
                        <a data-class="n5" href="javascript:void(0)" onclick="nextFivePage()">下五页</a>
                    <#else>
                        <span data-class="n5">下五页</span>
                    </#if>

                    跳转到
                    <select name="PageSelect" onchange="jumpPage()">
                        <#list 1..topicList.totalPage as t>
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


<#--        <#if trainerList??>
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
      </#if>-->
        
    </div>
</div>
    
<!-- main结束 -->
<#include "/assets/website/common/footer.html">

<script src="/assets/website/js/jquery-3.1.1.min.js" type="text/javascript"></script>
<script src='/assets/website/js/bootstrap.min.js' type="text/javascript"></script>
<script type="text/javascript">

var filterList = [];
var filterDateRange = "";

function filterClicked(ele) {
    if($(ele).hasClass('checked')){
        $(ele).removeClass('checked');
        filterList.splice($.inArray(ele.innerHTML), 1);
    } else {
        $(ele).addClass('checked');
        filterList.push(ele.innerHTML)
    }

    console.log('selected filter: ' + filterList.join() + ','+ filterDateRange);
}

function filter2Clicked(ele) {
    if(!$(ele).hasClass('checked')){
        $(ele).addClass('checked').siblings('span').removeClass('checked');
        filterDateRange = ele.innerHTML;
    }

    console.log('selected filter: ' + filterList.join() + ','+ filterDateRange);
}

function searchBtnClick() {
    var searchInput = $('#search_input').val();
    console.log('input string: ' + searchInput);
    console.log('selected filter: ' + filterList.join() + ','+ filterDateRange);
}
</script>
</body>
</html>
</#escape>