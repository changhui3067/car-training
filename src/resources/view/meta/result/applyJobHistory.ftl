<div class="panel panel-default">
    <!-- Default panel contents -->
    <div class="panel-heading">Panel heading</div>
<#if applyList?? >
    <table class="table table-hover">
        <tr>
            <th>职位名称</th>
            <th>工作类型</th>
            <th>工作地点</th>
            <th>发布日期</th>
        </tr>
		<#list applyList as apply>
            <tr>
                <td><#if apply.job.title??>${apply.job.title}<#else>无</#if></td>
                <td><#if apply.job.type??>${apply.job.type}<#else>无</#if></td>
                <td><#if apply.job.region.fullname??>${apply.job.region.fullname}<#else>无</#if></td>
                <td><#if apply.job.createDate??>${apply.job.createDate?string("yyyy-MM-dd")}<#else>无</#if></td>
            </tr>
		</#list>
    </table>
</#if>
</div>



            <#--分页逻辑 - 暂时不做-->
			<#--<#if deliveryResumeList?? && deliveryResumeList.result?? && deliveryResumeList.result?size gt 0>-->
            	<#--<div class="fypage" >-->
            	<#---->
            	<#--<#if pageNo gt 5>-->
            	<#--<a data-class="p5" href="javascript:void(0)" onclick="prevFivePage()">上五页</a>-->
            	<#--<#else>-->
            	<#--<span data-class="p5">上五页</span>-->
            	<#--</#if>-->
            	<#--<#if pageNo gt 1>-->
            	<#--<a data-class="p1" href="/backend/applyJobHistory?pageNo=${pageNo-1}">上一页</a>-->
            	<#--<#else>-->
            	<#--<span data-class="p1" class="">上一页</span>-->
            	<#--</#if>-->
            	<#---->
            	<#--<div data-class="pag" style="padding:0px;margin:0px;display:inline;">-->
            	<#--<#if pageNo lt 6>-->
            	<#--<#list 1..5 as t>-->
            	<#--<#if t = pageNo>-->
            	<#--<span>${t!}</span>-->
            	<#--<#else>-->
            	<#--<a href="/backend/applyJobHistory?pageNo=${t!}">${t!}</a>-->
            	<#--</#if>-->
            	<#--<#if t = deliveryResumeList.totalPage>-->
            	<#--<#break>-->
            	<#--</#if>-->
            	<#--</#list>-->
            	<#---->
            	<#--<#elseif pageNo%5 gt 0>-->
            	<#--<#list (pageNo/5)?floor*5+1..(pageNo/5)?floor*5+5 as t>-->
            	<#--<#if t = pageNo>-->
            	<#--<span>${t!}</span>-->
            	<#--<#else>-->
            	<#--<a href="/backend/applyJobHistory?&pageNo=${t!}">${t!}</a>-->
            	<#--</#if>-->
            	<#--<#if t = deliveryResumeList.totalPage>-->
            	<#--<#break>-->
            	<#--</#if>-->
            	<#--</#list>-->
            	<#---->
            	<#--<#elseif pageNo%5 = 0>-->
            	<#--<#list ((pageNo/5)?floor-1)*5+1..(pageNo/5)?floor*5 as t>-->
            	<#--<#if t = pageNo>-->
            	<#--<span>${t!}</span>-->
            	<#--<#else>-->
            	<#--<a href="/backend/applyJobHistory?pageNo=${t!}">${t!}</a>-->
            	<#--</#if>-->
            	<#--<#if t = deliveryResumeList.totalPage>-->
            	<#--<#break>-->
            	<#--</#if>-->
            	<#--</#list>-->
            	<#--</#if>-->
            	<#--</div>-->
            	<#---->
            	<#--<#if (deliveryResumeList.totalPage - pageNo) gt 0>-->
            	<#--<a data-class="n1" href="/backend/applyJobHistory?pageNo=${pageNo+1}">下一页</a>-->
            	<#--<#else>-->
            	<#--<span data-class="n1" class="">下一页</span>-->
            	<#--</#if>-->
            	<#--<#if (deliveryResumeList.totalPage - ((pageNo/5)?ceiling * 5)) gt 4>-->
            	<#--<a data-class="n5" href="javascript:void(0)" onclick="nextFivePage()">下五页</a>-->
            	<#--<#else>-->
            	<#--<span data-class="n5">下五页</span>-->
            	<#--</#if>-->
            	 <#---->
            	<#--跳转到 -->
            	<#--<select name="PageSelect" onchange="jumpPage()">-->
            	<#--<#list 1..deliveryResumeList.totalPage as t>-->
            	<#--<#if t = pageNo>-->
            	<#--<option selected="selected" value="${t!}">第${t!}页</option>-->
            	<#--<#else>-->
            	<#--<option value="${t!}">第${t!}页</option>-->
            	<#--</#if>-->
            	<#--</#list>-->
               <#--</select>-->
               <#--</div>-->
               <#--</#if>    	  -->
<!-- main结束 -->
<script>
$("#chk_all").click(function(){
	if($("#chk_all").attr("checked")){
     	$("input[name='chk_list']").attr("checked",true);
     }else{
     	$("input[name='chk_list']").attr("checked",false);
     }
});

//function deleteAll(){
//if(confirm('确认删除选择记录吗')){
//var ids = '';
//$("input:checkbox[name='chk_list']:checked").each(function(index, element) {
//                         ids += $(this).val() + ",";
//});
//if(ids==''||ids==null){
//	showErrMsg('请选择记录');
//	return false;
//}
//form_data={};
//form_data.ids = ids;
//var url  = "/backend/applyJobHistory/delall";
//$.ajax({
//		 type: "POST",
//	     url: url,
//	     data: form_data,
//	     error: function(request) {
//            showErrMsg("网络出错啦！");
//            return false;
//         },
//	     success: function (data) {
//             showErrMsg("删除成功！");
//             window.location.href = "/backend/applyJobHistory";
//	     }
//	});
//}else{
//	return false;
//}
//}
function showErrMsg(errMsg){
    	alert(errMsg);
}
</script>
<#--<!--分页有关js&ndash;&gt;-->
<#--<script>-->

	<#--var pageNo = ${pageNo};-->
	<#--<#if deliveryResumeList??>-->
		<#--var totalPage = ${deliveryResumeList.totalPage};-->
	<#--<#else>-->
		<#--var totalPage = 0;-->
	<#--</#if>-->
	<#--var tarUrl = "/backend/applyJobHistory?";-->
	<#---->
	<#--function prevFivePage(){-->
		<#--var pag = '';-->
		<#--for(var i = Math.floor(pageNo/5) * 5 - 4; i<=Math.floor(pageNo/5)*5;i++){-->
			<#--pag += '<a href="' + tarUrl + 'pageNo=' + i + '">' + i + '</a>';-->
		<#--}-->
		<#--pageNo = Math.floor(pageNo/5) * 5 - 4;-->
		<#--$("div.fypage").find("div[data-class=pag]").html(pag);-->
		<#--resetPreNex();-->
	<#--}-->
	<#--function nextFivePage(){-->
		<#--var pag = '';-->
		<#--for(var i = Math.ceil(pageNo/5) * 5 + 1; i<=Math.ceil(pageNo/5) * 5+5;i++){-->
			<#--pag += '<a href="' + tarUrl + 'pageNo=' + i + '">' + i + '</a>';-->
		<#--}-->
		<#--pageNo = Math.ceil(pageNo/5) * 5 + 1;-->
		<#--$("div.fypage").find("div[data-class=pag]").html(pag);-->
		<#--resetPreNex();-->
	<#--}-->
	<#--function resetPreNex(){-->
		<#--if(pageNo <= 5){-->
			<#--$("[data-class=p5]").replaceWith('<span data-class="p5">上五页</span>');-->
		<#--}else{-->
			<#--$("[data-class=p5]").replaceWith('<a data-class="p5" href="javascript:void(0)" onclick="prevFivePage()"">上五页</a>');-->
		<#--}-->
		<#--if(totalPage > Math.ceil(pageNo/5) * 5 + 4){-->
			<#--$("[data-class=n5]").replaceWith('<a data-class="n5" href="javascript:void(0)" onclick="nextFivePage()"">下五页</a>');-->
		<#--}else{-->
			<#--$("[data-class=n5]").replaceWith('<span data-class="n5">下五页</span>');-->
		<#--}-->
		<#---->
	<#--}-->
	<#---->
	<#--function jumpPage(){-->
		<#--window.location.href = tarUrl + 'pageNo=' + $("select[name=PageSelect]").val();	-->
	<#--}-->
	<#---->
<#--</script>-->
