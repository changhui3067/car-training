<div class="panel panel-default">
  <!-- Default panel contents -->
    <div class="panel-heading">Panel heading</div>
    <div class="panel-body"></div>
    <#if jobList?? >
    <table class="table table-hover">
        <tr>
            <th>职位名称</th>
            <th>工作类型</th>
            <th>工作地点</th>
            <th>学历要求</th>
            <th>专业要求</th>
            <th>经验要求</th>
            <th>语言要求</th>
            <th>工作待遇</th>
            <th>发布日期</th>
            <th>申请纪录</th>
        </tr>
        <#list jobList as job>
        <tr>
            <td>${job.title}</td>
            <td>${job.type}</td>
            <td>${job.region.fullname}</td>
            <td>${job.educationRequirement}</td>
            <td>${job.majorRequirement}</td>
            <td>${job.workExperienceRequirement}</td>
            <td>${job.LanguageRequirement}</td>
            <td>${job.salary}</td>
            <td>${job.createDate}</td>
            <#if jobApplyMap?? && jobApplayMap.get(job)>
            <td>
                <#list jobApplayMap.get(job) as apply>
                  <#if apply?? && apply.trainer??>
                  <a href="/website/trainerDetail?trainerId=${apply.trainer.id}"><span>${apply.trainer.name}</span></a>
                  <#elseif apply?? && apply.autobot??>
                  <a href="/website/autobotDetail?autobotId=${apply.autobot.id}"><span>${apply.autobot.name}</span></a>
                  </#if>
                </#list>
            </td>
            </#if>
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
var url  = "/backend/applyJobHistory/delall";
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
             window.location.href = "/backend/applyJobHistory";
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

