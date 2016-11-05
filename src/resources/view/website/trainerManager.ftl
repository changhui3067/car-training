<div class="pxshi_gl_l left">
<h4>培训师管理中心</h4>
<div class="lanmu">
<ul id="menuTab">
	<li id="information" onclick='navigate(this.id)'>个人资料</li>
	<li id="complete" onclick='navigate(this.id)'>完善资料</li>
    <li id="record" onclick='navigate(this.id)'>申请记录</li>
    <li id="publish" onclick='navigate(this.id)'>发布文章</li>
    <li id="article" onclick='navigate(this.id)'>我的文章</li>
    <li id="password" onclick='navigate(this.id)'>修改密码</li>
    <li id="logout" onclick='navigate(this.id)'>安全退出</li>
</ul>
</div>
</div>
<div class="pxshi_gl_r right">
</div>
</div>
<script type="text/javascript">
    var oUrl = {
        "information": "",
        "complete": "/backend/complete",
        "record": "/backend/record",
        "publish": "",
        "article": "",
        "password": "",
        "logout": ""
    };
    navigate("record");
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