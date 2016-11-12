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
<#if autobot??>
	<div class="ny_pxshi">
    	<div class="ny_pxshi_l left">
        	<div class="people_detail_basic_info">
            	<div class="photoleft">
                	<img src="${autobot.personInfo.avatarUrl!}"/>
                </div>
                <div class="detail right">
               	    <div>
                    	<h1 class="left">${autobots.userCenter.name!}</h1>
                      <div class="iconbox right">
                          <span><i class="iconfont" title="评论">&#xe69b;</i>0</span>
                          <span><i class="iconfont" title="点赞">&#xe717;</i>${trainer.starLevel!}</span>
                      </div>
                      <div class="clear"></div>
                    </div>
                    <div>
                        <span class="paddingLeftNull">${autobots.currentPosition!}</span>
                        <span>大学本科</span>
                        <span>三年工作经验</span>
                        <span>${autobots.personInfo.regionId!}</span>
                    </div>
                    <div>
                        擅长领域：<span>售后</span><span>销售</span><span>客服</span>
                    </div>
                    <div>
                        汽车品牌:<span class="paddingLeftNull">${autobot.autoBrand!}</span>
                    </div>
                    <div>
                      联系方式: <span>1515000xxxxx</span><span>changhiu3067@sina.cn</span>
                  </div>
                </div>
                <div class="clear"></div>
            </div>
          <!-- <div class="people_other_info_box">
            	<div class="people_other_info_bar"><h4>培训经历</h4></div>
              <div class="people_other_info_list">
                ${autobots.trainingHistroy!}
              </div>
          </div> -->
          <div class="people_other_info_box">
            	<div class="people_other_info_bar"><h4>所获认证</h4></div>
              <div class="people_other_info_list">
            	   ${autobot.certRecords!}
            	</div>
          </div>
          <div class="people_other_info_box">
            	<div class="people_other_info_bar"><h4>工作经历</h4></div>
              <div class="people_other_info_list">
                  ${autobot.workingHistroy!}
              </div>
          </div>
          

      </div>
      <div class="ny_pxshi_r right">
            <div class="pyquan">
            </div>
        </div>
        <div class="clear"></div>
    </div>
</#if>
</div>
    
<!-- main结束 -->
<#include "/assets/website/common/footer.html">
</body>
</html>
