<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />

    <title>培聘网</title>
    <link rel="stylesheet" href="/assets/website/css/bootstrap.min.css" type="text/css"/>
    <link rel="stylesheet" href="/assets/website/css/style.css" type="text/css"/>
    <link rel="stylesheet" href="/assets/website/css/pxshi.css" type="text/css"/>
    <link rel="stylesheet" href="/assets/website/css/iconfont.css" type="text/css"/>
</head>

<body>
<!-- 头部开始 -->	
<#include "/assets/website/common/header.html">
<!-- 头部结束 -->		

<!-- main开始 -->
<div class="content">
    <div class="ny autobotSearchColor">
     	<div class="searchBox">
        	<div class="filterType">
            	<div class="filterName">领域类型:</div>
                <div class="filterItemList">
                    <span onclick="filterClicked(this,'businessCategory')">内训</span>
                    <span onclick="filterClicked(this,'businessCategory')">销售市场</span>
                    <span onclick="filterClicked(this,'businessCategory')">售后客服</span>
                    <span onclick="filterClicked(this,'businessCategory')">高级管理</span>
                    <span onclick="filterClicked(this,'businessCategory')">人事财务</span>
                    <span onclick="filterClicked(this,'businessCategory')">生产研发</span>
                </div>
                <div class="clear"></div>
            </div>

            <div class="filterType">
                <div class="filterName">工作经验:</div>
                <div class="filterItemList">
                    <span onclick="filter2Clicked(this, 'autoYears')">应界毕业生</span>
                    <span onclick="filter2Clicked(this, 'autoYears')">5年内</span>
                    <span onclick="filter2Clicked(this, 'autoYears')">5-10年</span>
                    <span onclick="filter2Clicked(this, 'autoYears')">10-15年</span>
                    <span onclick="filter2Clicked(this, 'autoYears')" >15-20年</span>
                    <span onclick="filter2Clicked(this, 'autoYears')">20年以上</span>
                </div>
                <div class="clear"></div>
            </div>

            <div class="filterType">
                <div class="filterName">关键字:</div>
                <div class="filterItemList">
                    <input type="text" id="search_input"  placeholder="请输入关键字，如销售市场" validate-title="请输入关键字，如销售市场" />
                    <button onclick="searchBtnClick()">搜索</button>
                </div>
                <div class="clear"></div>
            </div>
        </div>

        <div id="searchResult" style="color:#3d9ccc">
            <!-- search result start -->
		<#include "/resources/view/meta/result/peopleSearchResult.ftl">
            <!-- search result end -->
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

<script src="/assets/website/js/jquery-3.1.1.min.js" type="text/javascript"></script>
<script src='/assets/website/js/bootstrap.min.js' type="text/javascript"></script>
<script type="text/javascript" src="/assets/website/js/Util.js"></script>
<script src="//cdn.bootcss.com/vue/2.1.3/vue.js"></script>
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
        filters['keyword'] = $('#search_input').val();
        sendAjax();
    }

    function sendAjax(n) {
        console.log(filters);
        var url  = "/website/autobot/search";
        var data_ = {};
        for (var props in filters) {
            if(typeof filters[props] === 'string') {
                data_[props] = filters[props]
            } else {
                data_[props] = filters[props].join(',');
            }
        }
        data_.pn = !!n ? n : 1;
        $.ajax({
            type: "GET",
            url: url,
            data: data_,
            error: function(request) {
                Util.msgToast({
                    message: '请求失败',
                    mode: Util.MSGTYPE.ERROR
                });
                return false;
            },
            success: function (data) {
                if (!!data.pageNo) {
                    list.resultVO = data;
                }
            }
        });
    }
var resultJson = ${resultJson!};
</script>
<script type="text/javascript" src="/assets/website/js/peopleSearch.js"></script>

</body>
</html>
