<div class="pxshi_gl_l left">
    
    <#if Session["loginVO"].userType=='TRAINER'>
        <h4>培训师管理中心</h4>
    <#elseif Session["loginVO"].userType=='AUTOBOT'>
        <h4>汽车人管理中心</h4>
    <#elseif Session["loginVO"].userType=='COMPANY'>
        <h4>培训公司管理中心</h4>
    <#elseif Session["loginVO"].userType=='STORE'>
        <h4>汽车公司管理中心</h4>
    </#if>
<div class="lanmu">
<ul id="menuTab">
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
        "complete": "/website/completeInfo",
        "peopleRecord": "/website/applyJobHistory",
        "companyRecord": "/backend/publishJobHistory",
        "password": "/backend/modifyPassword"
    };
    navigate("complete");
    function navigate(id) {
        var url = oUrl[id];
        $.ajax({
            type : "GET",
            data : {},
            url : url,
            error: function(request) {
                Util.msgToast({
                    message: '请求失败',
                    mode: Util.MSGTYPE.ERROR
                });
                return false;
            },
            success : function(result){
                $(".pxshi_gl_r")[0].innerHTML = result;
                changeClass(id);
                addCropperTrigger("#avatar_btn", "/backend/saveInfo/setAvatar", "#avatar_show");
                addCropperTrigger("#logo_btn", "/backend/saveInfo/setLogo", "#logo_show");
                addCropperTrigger("#photo_btn", "/backend/saveInfo/setPhoto", "#photo_show");
                
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
    $(document).ready(
        function(){
            addCropperTrigger("#avatar_btn", "/backend/saveInfo/setAvatar", "#avatar_show");
            addCropperTrigger("#logo_btn", "/backend/saveInfo/setLogo", "#logo_show");
            addCropperTrigger("#photo_btn", "/backend/saveInfo/setPhoto", "#photo_show");
        }
    );
</script>