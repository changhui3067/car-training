<div class="panel panel-default">
    <!-- Default panel contents -->
    <div class="panel-heading"><h4>申请职位纪录</h4></div>
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
                <td><a href="/website/jobDetail?jobId=${apply.job.id}">
                    <#if apply.job.title??>${apply.job.title}<#else>无</#if></a>
                </td>
                <td><#if apply.job.type??><#if apply.job.type=='TRAINER'>培训师<#else>汽车人</#if><#else>无</#if></td>
                <td><#if apply.job.region?? && apply.job.region.fullname??>${apply.job.region.fullname}<#else>无</#if></td>
                <td><#if apply.job.createDate??>${apply.job.createDate?string("yyyy-MM-dd")}<#else>无</#if></td>
            </tr>
		</#list>
    </table>
</#if>
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
</script>
