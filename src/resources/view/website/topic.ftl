<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />

<title>培聘网</title>
<link rel="stylesheet" href="<@url value="/assets/website/css/zt.css"/>" type="text/css" media="screen" />
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
        	<div class="zt_l left">
            	<ul>
            	 <#if topicList?? && topicList.result??>
	            	 <#list topicList.result as t>
	            	 	<li>
                    	<div class="zt_pic left"><img src="${t.topicLogo!}" /></div>
                        <div class="zt_box right">
                       	    <a href="/website/topicDetail?topic.id=${t.id!}"><div class="zt_tit">${t.title!}</div></a>
                            <div class="zt_xx">
                           	<a href="#"><#if  t.content?length lt 201>${t.content!}<#else>${t.content?substring(0,200)!}...</#if></a>                   </div>	
                          <div class="zt_pl">
                            	<div class="zt_pl_l left"><a href="#">此问题有8人评论</a></div>
                                <div class="zt_pl_r right">
                                  <table width="100%" border="0" cellspacing="0" cellpadding="0">
                                    <tr>
                                      <td width="50%" align="right" valign="middle"><a href="#">评论</a></td>
                                      <td width="21%" align="right" valign="middle"></td>
                                      <td width="29%" align="right" valign="middle"><a href="#">赞(12)</a></td>
                                    </tr>
                                  </table>
                              </div>
                                <div class="clear"></div>
                            </div>
                        <div class="clear"></div>
                        </div>
                    </li>
	            	 </#list>
            	 </#if>
                </ul>
            	
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
            
            <div class="zt_r right">
            <div class="kstw">
            	<h4>我要发帖</h4>
                <div class="kstw_box">
                	<table width="95%" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td height="140" align="center" valign="middle"><textarea name="textarea" style=" border:1px solid #e6e5e5;width:240px; height:100px;" id="textarea"></textarea></td>
  </tr>
  <tr>
    <td height="60" align="center" valign="middle">
      <input type="image" name="imageField" id="imageField" src="http://obu3flkwk.bkt.clouddn.com/website/images/tj.jpg" />
  </td>
  </tr>
</table>

              </div>
            </div>
            <div class="wdwd">
            	<h4>精品专题</h4>
                <div class="wdwd_box">
                	<ul>
                		<#if topicHotList??>
			            	<#list topicHotList as t>
		                    	<li><a href="#">${t.title!}</a></li>
                    	 	</#list>
            	 		</#if>
                    </ul>
                </div>
            </div>
            
            </div>
            <div class="clear"></div>
        </div>
        
       
  </div>
</div>
    
	
<!--分页有关js-->
    <script>
    
		var pageNo = ${pageNo};
		<#if topicList??>
			var totalPage = ${topicList.totalPage};
		<#else>
			var totalPage = 0;
		</#if>
		var tarUrl = "/website/topic?";
		
    	function prevFivePage(){
    		var pag = '';
    		for(var i = Math.floor(pageNo/5) * 5 - 4; i<=Math.floor(pageNo/5)*5;i++){
				pag += '<a href="' + tarUrl + 'pageNo=' + i + '">' + i + '</a>';
    		}
    		pageNo = Math.floor(pageNo/5) * 5 - 4;
    		$("div.fypage").find("div[data-class=pag]").html(pag);
    		resetPreNex();
    	}
    	function nextFivePage(){
    		var pag = '';
    		for(var i = Math.ceil(pageNo/5) * 5 + 1; i<=Math.ceil(pageNo/5) * 5+5;i++){
				pag += '<a href="' + tarUrl + 'pageNo=' + i + '">' + i + '</a>';
    		}
    		pageNo = Math.ceil(pageNo/5) * 5 + 1;
    		$("div.fypage").find("div[data-class=pag]").html(pag);
    		resetPreNex();
    	}
    	function resetPreNex(){
    		if(pageNo <= 5){
    			$("[data-class=p5]").replaceWith('<span data-class="p5">上五页</span>');
    		}else{
    			$("[data-class=p5]").replaceWith('<a data-class="p5" href="javascript:void(0)" onclick="prevFivePage()"">上五页</a>');
    		}
    		if(totalPage > Math.ceil(pageNo/5) * 5 + 4){
    			$("[data-class=n5]").replaceWith('<a data-class="n5" href="javascript:void(0)" onclick="nextFivePage()"">下五页</a>');
    		}else{
    			$("[data-class=n5]").replaceWith('<span data-class="n5">下五页</span>');
    		}
    		
    	}
    	
    	function jumpPage(){
    		window.location.href = tarUrl + 'pageNo=' + $("select[name=PageSelect]").val();	
    	}
    	
    </script>


<!-- main结束 -->
<#include "/assets/website/common/footer.html">
</body>
</html>
