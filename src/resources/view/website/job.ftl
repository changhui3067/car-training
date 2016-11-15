<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />

<title>培聘网</title>
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
    <div class="ny">
     	<div class="searchBox">
        	<div class="filterType">
            	<div class="filterName">职位类型:</div>
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
            	<div class="filterName">职位地址:</div>
                <div class="zwdz_box">

                </div>
                <div class="clear"></div>
            </div>
            <div class="filterType">
            	<div class="filterName">发布时间:</div>
                <div class="filterItemList">
                    	<span onclick="filter3Clicked(this, 'publishDate')">三天内</span>
                        <span onclick="filter3Clicked(this, 'publishDate')">一周内</span>
                        <span onclick="filter3Clicked(this, 'publishDate')">两周内</span>
                        <span onclick="filter3Clicked(this, 'publishDate')">一个月以内</span>
                        <span onclick="filter3Clicked(this, 'publishDate')">一个月以上</span>
                </div>
            	
            </div>

            <div class="filterType">
                <div class="filterName">工作经验:</div>
                <div class="filterItemList">
                    <span onclick="filter2Clicked(this, 'workExperience')">5年内</span>
                    <span onclick="filter2Clicked(this, 'workExperience')">5-10年</span>
                    <span onclick="filter2Clicked(this, 'workExperience')">10-15年</span>
                    <span onclick="filter2Clicked(this, 'workExperience')">15-20年</span>
                    <span onclick="filter2Clicked(this, 'workExperience')">20年以上</span>
                </div>
            </div>
            
            <div class="filterType">
           	  <div class="filterName">关键字</div>
                <div class="filterItemList">
                    <input type="text" id="search_input"  placeholder="请输入关键字，如销售市场" validate-title="请输入关键字，如销售市场" />
                    <button onclick="searchBtnClick()">搜索</button>
                </div>
          </div>
        </div>

        <div id="searchResult">
            <#include "/resources/view/meta/result/jobSearchResult.ftl">
        </div>
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

function filter3Clicked(ele, category) {
    filters[category] = filters[category] ? filters[category] : "";
    if(!$(ele).hasClass('checked')){
        $(ele).addClass('checked').siblings('span').removeClass('checked');
    }

    switch(ele.innerHTML) {
        case '三天内':
            filters[category] = "0,3"; break;
        case '一周内':
            filters[category] = "0,7"; break;
        case '两周内':
            filters[category] = "0,14"; break;
        case '一个月以内':
            filters[category] = "0,30"; break;
        case '一个月以上':
            filters[category] = "0,100"; break;
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
    var url  = "/website/job/search";
    var data_ = {};
    for (var props in filters) {
        data_[props] = filters[props].join(',');
    }
    $.ajax({
        type: "GET",
        url: url,
        data: data_,
        error: function(request) {
            console.log("网络出错啦！");
            return false;
        },
        success: function (data) {
            $('#searchResult')[0].innerHTML = data;
        }
    });
}
</script>
</body>

</html>
