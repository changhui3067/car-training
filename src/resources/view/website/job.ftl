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
    <div class="ny">
     	<div class="searchBox">
        	<div class="filterType">
            	<div class="filterName">职位类型:</div>
                <div class="filterItemList">
                    <#if jobType=="TRAINER">
                        <span onclick="filterClicked(this,'businessCategory')">销售</span>
                        <span onclick="filterClicked(this,'businessCategory')">产品</span>
                        <span onclick="filterClicked(this,'businessCategory')">技术</span>
                        <span onclick="filterClicked(this,'businessCategory')">管理</span>
                        <span onclick="filterClicked(this,'businessCategory')">财务</span>
                        <span onclick="filterClicked(this,'businessCategory')">人事</span>
                        <span onclick="filterClicked(this,'businessCategory')">生产</span>
                        <span onclick="filterClicked(this,'businessCategory')">非技术</span>
                        <span onclick="filterClicked(this,'businessCategory')">领导力</span>
                        <span onclick="filterClicked(this,'businessCategory')">新能源</span>
                        <span onclick="filterClicked(this,'businessCategory')">市场营销</span>
                        <span onclick="filterClicked(this,'businessCategory')">客户关系</span>
                        <span onclick="filterClicked(this,'businessCategory')">其他</span>
                    <#elseif jobType=="AUTOBOT">
                        <span onclick="filterClicked(this,'businessCategory')">内训</span>
                        <span onclick="filterClicked(this,'businessCategory')">销售市场</span>
                        <span onclick="filterClicked(this,'businessCategory')">售后客服</span>
                        <span onclick="filterClicked(this,'businessCategory')">高级管理</span>
                        <span onclick="filterClicked(this,'businessCategory')">人事财务</span>
                        <span onclick="filterClicked(this,'businessCategory')">生产研发</span>
                    </#if>
                </div>
                <div class="clear"></div>
            </div>
            
            <div class="filterType">
            	<div class="filterName">职位地址:</div>
                <div class="filterItemList">
                    <div class="dropdown" id="province">
                        <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
                            请选择省<span class="caret"></span>
                        </button>
                        <ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
                            <#list provinces as t>
                            <li ><a href='#' onclick="selectCities(this, true)" value="${t.id!}">${t.name!}</a></li>
                            </#list>
                        </ul>
                    </div>
                    <div class="dropdown" name="uregionId" id="city">
                        <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu2" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
                            请选择市<span class="caret"></span>
                        </button>
                        <ul class="dropdown-menu" aria-labelledby="dropdownMenu2">
                            <#if cities??><#list cities as city>
                            <li><a href='#' onclick="selectCity(this);filter4Clicked(this, 'regionId');" value="${city.id!}">${city.name!}</a></li>
                            </#list></#if>
                        </ul>
                    </div>
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
            	<div class="clear"></div>
            </div>

            <div class="filterType">
                <div class="filterName">工作经验:</div>
                <div class="filterItemList">
                    <#if jobType=="AUTOBOT">
                        <span onclick="filter2Clicked(this, 'workExperience')">应届毕业生</span>
                    </#if>
                    <span onclick="filter2Clicked(this, 'workExperience')">5年内</span>
                    <span onclick="filter2Clicked(this, 'workExperience')">5-10年</span>
                    <span onclick="filter2Clicked(this, 'workExperience')">10-15年</span>
                    <span onclick="filter2Clicked(this, 'workExperience')">15-20年</span>
                    <span onclick="filter2Clicked(this, 'workExperience')">20年以上</span>
                </div>
                <div class="clear"></div>
            </div>
            
            <div class="filterType">
           	    <div class="filterName">关键字</div>
                <div class="filterItemList">
                    <input type="text" id="search_input"  placeholder="请输入关键字，如销售市场" validate-title="请输入关键字，如销售市场" />
                    <button onclick="searchBtnClick()">搜索</button>
                </div>
                <div class="clear"></div>
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
<script src="/assets/website/js/region.js" type="text/javascript"></script>
<<<<<<< 817c34cde30849343e91ce96fd41ab8f90e1ca95
<script type="text/javascript" src="/assets/website/js/Util.js"></script>
=======
<script src="https://cdnjs.cloudflare.com/ajax/libs/vue/2.0.5/vue.js" type="text/javascript"></script>
>>>>>>> job search with pagination

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

function filter4Clicked(ele, category) {

    filters[category] = filters[category] ? filters[category] : "";
    filters[category] = $('#city button').val();
    sendAjax();
}

function searchBtnClick() {
    filters['keyWord'] = $('#search_input').val();
    sendAjax();
}

function sendAjax(n) {
    console.log(filters);
    var url  = "/website/job/search";
    var data_ = {};
    data_['jobType'] = "${jobType}";
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
            if(!!data){
                list.jobList = data.jobList;
                list.pageCount = data.pageCount;
                list.pageNo = data.pageNo;
            }
          
        }
    });
}

var resultVO = ${resultJson};
var list = new Vue({
    el: '#jobList',
    data: {
        jobList: resultVO.jobList,
        pageCount: resultVO.pageCount,
        pageNo: resultVO.pageNo
    },
    methods: {
        getPage: function (n) {
            sendAjax(n);
        },
        specialJump: function (action) {
            if (!this[action] || !this[action]) {
                return;
            }
            switch (action) {
                case 'fst':
                    sendAjax(1);
                    break;
                case 'pre':
                    sendAjax(this.pageNo - 1);
                    break;
                case 'nex':
                    sendAjax(this.pageNo + 1);
                    break;
                case 'Lst':
                    sendAjax(this.pageCount);
                default:
                    return;
            }
        }
    },
    computed: {
        fst: function () {
            return this.pageNo != 1;
        },
        pre: function () {
            return this.pageNo > 1;
        },
        nex: function () {
            return this.pageNo < this.pageCount;
        },
        Lst: function () {
            return this.pageNo != this.pageCount;
        },
        pages: function () {
            var totalPage = this.pageCount;
            var pageNo = this.pageNo;
            var pages = [];
            if (totalPage >= 5) {
                if (pageNo < 3) {
                    pages = Array.apply(null, Array(5)).map(function (_, i) {
                        var page = {};
                        page.no = i + 1;
                        page.current = page.no == pageNo;
                        return page;
                    });
                } else if (totalPage - pageNo < 3) {
                    pages = Array.apply(null, Array(5)).map(function (_, i) {
                        var page = {};
                        page.no = totalPage - 4 + i;
                        page.current = page.no == pageNo;
                        return page;
                    });
                } else {
                    pages = Array.apply(null, Array(5)).map(function (_, i) {
                        var page = {};
                        page.no = pageNo - 2 + i;
                        page.current = page.no == pageNo;
                        return page;
                    });
                }
            } else {
                pages = Array.apply(null, Array(totalPage)).map(function (_, i) {
                    var page = {};
                    page.no = i + 1;
                    page.current = page.no == pageNo;
                    return page;
                });
            }
            return pages;
        }
    }
});
$(document).ready(function () {
    $("#jobList").removeClass("hidden");
});

</script>
</body>

</html>
