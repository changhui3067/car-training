<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />

<title>培聘网</title>
<link rel="stylesheet" href="<@url value="/assets/website/css/pxshi.css"/>" type="text/css" media="screen" />
    <link rel="stylesheet" href="<@url value="/assets/website/css/style.css"/>" type="text/css" media="screen" />

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
    	
        	<div class="pxshi_xx">
            	<div class="zhaopian left">
                	<img src="${autobot.personInfo.avatarUrl!}" style="width:181px;height:153px;"/>
                </div>
                <div class="xinxi right">
               	  <div class="mingzi">
                    	<div class="mingzi_l left">${autobot.personInfo.name!}</div>
                        <div class="mingzi_m left">
                       		
                            <span><a href="#"><img src="http://obu3flkwk.bkt.clouddn.com/website/images/hot2.jpg" /></a></span>
                            <span><a href="#"><img src="http://obu3flkwk.bkt.clouddn.com/website/images/yrz.jpg" /></a></span>
                            <span><a href="#"><img src="http://obu3flkwk.bkt.clouddn.com/website/images/dr.jpg" /></a></span>
                            <span><a href="#"><img src="http://obu3flkwk.bkt.clouddn.com/website/images/zs.jpg" /></a></span></div>
                    <div class="mingzi_r right">
                        	<!--<input style="border:none;" type="image" name="gz" id="gz" src="http://obu3flkwk.bkt.clouddn.com/website/images/glz.jpg" />-->
                    </div>
                        <div class="clear"></div>
                    </div>
                	
                    <div class="qcr_jbxx">
                    	<div class="jiben left">
                        	<span>${autobot.currentPosition!}</span><span>大学本科</span><span>三年工作经验</span><span style=" background:none;">${autobot.personInfo.regionId!}</span>
                        </div>
                        <div class="ckcs right">简历查看数：35次</div>
                        <div class="clear"></div>
                        
                        
                    </div>
                    <div class="qcr_jbxx">
                    	<div class="jiben left">
                        	擅长领域/行业：<span>售后</span><span>销售</span><span style=" background:none;">客服</span>
                        	
                        </div>
                        <div class="jiben left"><span style=" border:none;">汽车品牌:</span>${autobot.autoBrand!}</div>
                        <div class="clear"></div>
                        
                        
                    </div>
                    
                </div>
                <div class="clear"></div>
            </div>
          <div class="jiben_xx">
            	<div class="pxshi_bt">
            	<h4>基本信息</h4>
                </div>
            	<div class="jiben_xx_box">
               　
                 <table width="100%" border="0" cellspacing="0" cellpadding="0">
                   <tr>
                     <td width="20%" align="right" valign="middle">出生年份：</td>
                     <td width="30%">${autobot.personInfo.brithday!}</td>
                     <td width="20%" align="right">婚姻状况：</td>
                     <td width="30%">${autobot.personInfo.marriageStatus!}</td>
                   </tr>
                  
                   <tr>
                     <td align="right" valign="middle">国籍：</td>
                     <td>中国</td>
                     <td align="right">状态：</td>
                     <td>${autobot.currentWorkStatus!}</td>
                   </tr>
                 </table>
           	</div>
            </div>
          <div class="pxjingli">
            	<div class="pxshi_bt">
            	<h4>培训经历</h4>
                </div>
                <div class="pxjingli_box">
            	<#--${autobot.trainingHistroy!}-->
               </div>
            </div>
          <div class="shrz">
            	<div class="pxshi_bt">
            	<h4>所获认证</h4>
                </div>
                <div class="shrz_box">
            	${autobot.certRecords!}
            	</div>
          </div>
          
          <div class="gzjl">
            	<div class="pxshi_bt">
            	<h4>工作经历</h4>
                </div>
                ${autobot.workingHistroy!}
                </div>
          </div>
          <!--<div class="zwpj">
            	<div class="pxshi_bt">
            	<h4>自我评价</h4>
                </div>
                <div class="zwpj_box">
                	<table width="90%" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>W
    <td>本人性格开朗、稳重、有活力，待人热情、真诚; 工作认真负责，积极主动，能吃苦耐劳，敢于创新，敢于迎接挑战，敢于承担责任; 善富有工作激情，乐业敬业，强调团队合作精神且工作认真负责; 较强的组织能力和极佳的团队合作精神，深得领导及同事的欢迎; 同时也培养了自己工作的能力与增长了处事的经验，也增强了自己的信心。</td>
  </tr>
  
</table>

                </div>
          </div>-->
           <div class="ny_pxshi_r right">
        	<div class="pxshi_lx">
            	<h4>联系方式</h4>
                <div class="lx_box">
                <div class="xingming">${autobot.personInfo.name!}(汽车人本人)</div>
      <#if Session["loginState"]=='Y'>
                   电话：${autobot.personInfo.mobile!}<br />
                   邮箱：${autobot.personInfo.email!}<br />
                   <#else>
请联系培训网  400-820-6666
      </#if>
                </div>
            </div>
           <!--<div class="pxshi_dp">
            	<div class="pxshi_bt">
            	<h4>培训师点评</h4>
                </div>
                <div class="pxshi_dp_box">
                <table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td align="center" valign="middle">
      <textarea style="width:230px; height:100px;" name="textarea" id="textarea" cols="45" rows="5"></textarea></td>
  </tr>
  <tr>
    <td height="75" align="center" valign="bottom"><input type="image" name="tj" id="tj" src="http://obu3flkwk.bkt.clouddn.com/website/images/tj.jpg" /></td>
  </tr>
</table>

              </div>
          </div>
        </div>
        <div class="ny_pxshi_r right">
       	  <div class="pxshi_gz">
       	  	<#if listTrainer??>
            	<h4>关注培训师</h4>
                <div class="guanzhu">
                	<ul>
                		<#list listTrainer as t>
                		<#if t??>
                    	<li><a href="#">${t.personInfo.name!} ${t.currentPosition!} </a><img src="${t.personInfo.avatarUrl!}" /></span></li>
                    	</#if>
                        </#list>
                    </ul>
                </div>
            </#if>
        	</div>-->
            <div class="pyquan">
            <#if autobotList??>
            	<h4>朋友圈</h4>
                <div class="pyquan_box">
                	<ul>
                   	  <#list autobotList as t>
                   	  <#if t?? >
                      <li>
                        	<div class="dbr_l left"><a href="#"><img src="${t.personInfo.avatarUrl!}" /></a></div>
                          <div class="dbr_r right">
                            	<div class="dbr_name"><a href="#">${t.personInfo.name!}</a></div>
                                <div class="dbr_gs"><a href="#">${t.currentPosition!}</a></div>
                          </div>
                            <div class="clear"></div>
                	  </li>
                      </#if>
                      </#list>
                    </ul>
                </div>
                </#if>
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
