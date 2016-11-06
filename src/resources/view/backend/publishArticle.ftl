<form action=""  id="form1">
    <input type="hidden" name="trainer.id" id="trainer.id" value="<#if trainer??>${trainer.id!}</#if>"/>
   	  <div class="pxshijl">
           	  <h5>发布文章</h5>
                <div class="pxshijl_box">
               	 <table width="800" border="0" align="center" cellpadding="0" cellspacing="0">
		  <tr>
		    <td width="79" height="40" align="right" valign="middle"><font color="#ff0000">*</font> 标题：</td>
		    <td width="721"><input type="text" name="trainerEssay.title" id="trainerEssay.title" style="width:500px;"/></td>
		  </tr>
		
		  <tr>
		    <td height="150" align="right" valign="top"><font color="#ff0000">*</font> 文章内容：</td>
		    <td align="left" valign="top"><textarea style="width:500px;" name="trainerEssay.content" id="trainerEssay.content" cols="45" rows="8"></textarea></td>
		  </tr>
		</table>
        </div>
      </div>
      
      <div class="tj">
            <table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td height="60" align="center" valign="middle"><img onclick="submitdata()"  src="http://obu3flkwk.bkt.clouddn.com/backend/images/fb.jpg" /></td>
              </tr>
        </table>
      </div>
  	</div>  
</form>
<script>
function submitdata(){
	var form_data = {};
	var url  = "/backend/publishArticle/save";

	var tid = $("[name='trainer.id']").val();
	var title = $("[name='trainerEssay.title']").val();
	var content = $("[name='trainerEssay.content']").val();
	
	if(title == undefined || content == undefined){
		alert("带*的为必填字段 ");
		return false;
	}
	if(title == "" || content == ""){
		alert("带*的为必填字段 ");
		return false;
	}
	form_data.id = tid;
	form_data.title = title;
	form_data.content = content;
	
	$.ajax({
			 type: "POST",
		     url: url,
		     data: form_data,
		     error: function(request) {
	             showErrMsg("网络出错啦！");
	             return false;
	         },
		     success: function (data) {
		    	 if(data.code==200){
					 showErrMsg("添加成功！");
					 window.location.href = "/backend/articleManage";
		    	 }else if(data.code==400){
		    	 	 showErrMsg(data.msg);
		    	 	 return false;
		    	 }else{
		    	 	 return false;
		    	 }
		     }
		});
}
function showErrMsg(errMsg){
    	alert(errMsg);
 }
</script>
