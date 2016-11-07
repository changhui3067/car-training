<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />

<title>培聘网</title>
<link rel="stylesheet" href="<@url value='/assets/website/backend/css/style.css'/>" type="text/css" media="screen" />
<script src="<@url value="/assets/website/js/jquery-1.8.0.min.js?v=1.1.0"/>"></script>
</head>

<body>
<#include "/assets/website/common/header.html">
<!-- main开始 -->
<div class="main">
	<div class="content">
    <div class="dq_box">
    <div class="dqwz left">当前位置 : <a href="#">首 页</a> > <a href="#">培训师管理中心</a> > <a href="#">我的文章</a></div>
	<div class="wdcf right"><span color="#FF66001"><#if Session?exists && Session["userDetails"].wealthStartDate??> ${Session["userDetails"].wealthStartDate!?string("dd/MM/yyyy")}—${Session["userDetails"].wealthEndDate!?string("dd/MM/yyyy")}</#if></span>我的财富：<font color="#FF66001"><#if Session?exists && Session["userDetails"]??> ${Session["userDetails"].wealth!}</#if></font></div>    <div class="clear"></div>
    </div>
    <div class="pxshi_gl">
    	<div class="pxshi_gl_l left">
    	
      <#include "/assets/website/backend/common/menu.html">
      
        <div class="pxshi_gl_r right">
        <#if trainerEssayList?? && trainerEssayList.result??>
         <table bgcolor="#dedede" border="0" cellpadding="4" cellspacing="1" align="center" width="860">
                    <tbody>
                      <tr>
                        <td width="40" height="50" align="center" valign="middle" bgcolor="#f0faff"><strong>选择</strong></td>
                        <td width="30" align="center" valign="middle" bgcolor="#f0faff"> <strong>序号</strong></td>
                        <td align="center" valign="middle" bgcolor="#f0faff"><strong>文章标题</strong></td>
                        <td width="60" align="center" valign="middle" bgcolor="#f0faff"><strong>发布时间</strong></td>
                        <td width="70" align="center" valign="middle" bgcolor="#f0faff"> <strong> 操作 </strong></td>
                      </tr>
                      
                      <#if trainerEssayList.result?size gt 0>
                      <#list trainerEssayList.result as t>
                      <#if t?? && t.title??>
                      <tr>
                        <td  height="40" align="center" valign="middle" bgcolor="#ffffff"><input type="checkBox" name="chk_list" id="chk_list" value="${t.id!}"/></td>
                        <td  align="center" valign="middle" bgcolor="#ffffff" class="sq">${t_index + 1}</td>
                        <td align="center" valign="middle" bgcolor="#ffffff"class="sq"><a href="#">${t.title!} </a></td>
                        <td  align="center" valign="middle" bgcolor="#ffffff">${t.publishDate!?string("yyyy-MM-dd")}</td>
                        <td align="center" valign="middle" bgcolor="#ffffff"  class="caozuo"><a href="/website/trainerEssayDetail?trainerEssay.id=${t.id!}" target="_blank">查看</a>&nbsp;&nbsp;  <a href="/backend/articleManage/essayDelete?trainerEssay.id=${t.id!}" onclick="javascript:if(confirm('确认要删除该记录吗?')==false) return false;">删除</a></td>
                      </tr>
                     </#if>
                      </#list>
                      </#if>

                        <td  height="40" align="center" valign="middle" bgcolor="#ffffff"><input type="checkBox" name="chk_all" id="chk_all" /></td>
                        <td colspan="4"  align="left" valign="middle" bgcolor="#ffffff" class="sq"><table width="200" border="0" cellspacing="0" cellpadding="0">
                          <tr>
                            <td width="80" align="center" valign="middle" class="quanxuan"><img onclick="deleteAll()" src="http://obu3flkwk.bkt.clouddn.com/backend/images/sc.jpg" /></td>
                            <td width="163"></td>
                          </tr>
                        </table></td>
                      </tr>
                    </tbody>
                  </table>
          </#if>
        

		<#if trainerEssayList?? && trainerEssayList.result?? && trainerEssayList.result?size gt 0>
            	<div class="fypage" >
            	
            	<#if pageNo gt 5>
            	<a data-class="p5" href="javascript:void(0)" onclick="prevFivePage()"">上五页</a>
            	<#else>
            	<span data-class="p5">上五页</span>
            	</#if>
            	<#if pageNo gt 1>
            	<a data-class="p1" href="/backend/artticleManage?pageNo=${pageNo-1}">上一页</a>
            	<#else>
            	<span data-class="p1" class="">上一页</span>
            	</#if>
            	
            	<div data-class="pag" style="padding:0px;margin:0px;display:inline;">
            	<#if pageNo lt 6>
            	<#list 1..5 as t>
            	<#if t = pageNo>
            	<span>${t!}</span>
            	<#else>
            	<a href="/backend/artticleManage?pageNo=${t!}">${t!}</a>
            	</#if>
            	<#if t = trainerEssayList.totalPage>
            	<#break>
            	</#if>
            	</#list>
            	
            	<#elseif pageNo%5 gt 0>
            	<#list (pageNo/5)?floor*5+1..(pageNo/5)?floor*5+5 as t>
            	<#if t = pageNo>
            	<span>${t!}</span>
            	<#else>
            	<a href="/backend/artticleManage?&pageNo=${t!}">${t!}</a>
            	</#if>
            	<#if t = trainerEssayList.totalPage>
            	<#break>
            	</#if>
            	</#list>
            	
            	<#elseif pageNo%5 = 0>
            	<#list ((pageNo/5)?floor-1)*5+1..(pageNo/5)?floor*5 as t>
            	<#if t = pageNo>
            	<span>${t!}</span>
            	<#else>
            	<a href="/backend/artticleManage?pageNo=${t!}">${t!}</a>
            	</#if>
            	<#if t = trainerEssayList.totalPage>
            	<#break>
            	</#if>
            	</#list>
            	</#if>
            	</div>
            	
            	<#if (trainerEssayList.totalPage - pageNo) gt 0>
            	<a data-class="n1" href="/backend/artticleManage?pageNo=${pageNo+1}">下一页</a>
            	<#else>
            	<span data-class="n1" class="">下一页</span>
            	</#if>
            	<#if (trainerEssayList.totalPage - ((pageNo/5)?ceiling * 5)) gt 4>
            	<a data-class="n5" href="javascript:void(0)" onclick="nextFivePage()">下五页</a>
            	<#else>
            	<span data-class="n5">下五页</span>
            	</#if>
            	 
            	跳转到 
            	<select name="PageSelect" onchange="jumpPage()">
            	<#list 1..trainerEssayList.totalPage as t>
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
        <div class="clear"></div>
    
    </div>
    </div>
</div>

<!-- main结束 -->
<script>
$("#chk_all").click(function(){
	if($("#chk_all").attr("checked")){
     	$("input[name='chk_list']").attr("checked",true);
     }else{
     	$("input[name='chk_list']").attr("checked",false);
     }
});

function deleteAll(){
if(confirm('确认删除选择记录吗')){
var ids = '';
$("input:checkbox[name='chk_list']:checked").each(function(index, element) {
                         ids += $(this).val() + ",";
});
if(ids==''||ids==null){
	showErrMsg('请选择记录');
	return false;
}
form_data={};
form_data.ids = ids;
var url  = "/backend/articleManage/delall";
$.ajax({
		 type: "POST",
	     url: url,
	     data: form_data,
	     error: function(request) {
            showErrMsg("网络出错啦！");
            return false;
         },
	     success: function (data) {
             showErrMsg("删除成功！");
             window.location.href = "/backend/articleManage";
	     }
	});
}else{
	return false;
}
}
function showErrMsg(errMsg){
    	alert(errMsg);
}
</script>
<!--分页有关js-->
    <script>
    
		var pageNo = ${pageNo};
		<#if trainerEssayList??>
			var totalPage = ${trainerEssayList.totalPage};
		<#else>
			var totalPage = 0;
		</#if>
		var tarUrl = "/backend/artticleManage?";
		
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

<#include "/assets/website/backend/common/footer.html">

</body>
</html>
