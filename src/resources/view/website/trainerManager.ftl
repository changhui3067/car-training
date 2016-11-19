<div class="pxshi_gl_l left">
<h4>培训师管理中心</h4>
<div class="lanmu">
<ul id="menuTab">
	<!-- <li id="information" onclick='navigate(this.id)'>个人资料</li> -->
	<li id="complete" onclick='navigate(this.id)'>完善资料</li>

    <#if Session["loginVO"].userType=='TRAINER' || Session["loginVO"].userType=='AUTOBOT'>
        <li id="peopleRecord" onclick='navigate(this.id)'>申请记录</li>
    <#elseif Session["loginVO"].userType=='COMPANY' || Session["loginVO"].userType=='STORE'>
        <li id="companyRecord" onclick='navigate(this.id)'>招聘记录</li>
    </#if>

    <li id="password" onclick='navigate(this.id)'>修改密码</li>
</ul>
</div>
</div>
<div class="pxshi_gl_r right">
</div>
</div>
<script type="text/javascript">
    var oUrl = {
        // "information": "/website/trainerDetail",
        "complete": "/backend/completeInfo",
        "peopleRecord": "/backend/applyJobHistory",
        "companyRecord": "/backend/publishJobHistory",
        // "publish": "/backend/publishArticle",
        // "article": "/backend/articleManage",
        "password": "/backend/modifyPassword"
    };
    navigate("complete");
    function navigate(id) {
        var url = oUrl[id];
        $.ajax({
            type : "GET",
            data : {},
            url : url,
            success : function(result){
                $(".pxshi_gl_r")[0].innerHTML = result;
                changeClass(id);
            }
        });
        changeClass(id);
        
    }
    function changeClass(id) {
        var childs = $(".lanmu li"),i;
        for(i in childs){
            if(childs[i].id === id){
                $("#" + id).addClass("cn");
            }else{
                $("#" + childs[i].id).removeClass("cn");
            }
        }
    }
</script>