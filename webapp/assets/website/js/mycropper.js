var html =
    '<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">' +
    '    <div class="modal-dialog" role="document">' +
    '    <div class="modal-content">' +
    '    <div class="modal-header">' +
    '    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>' +
    '<h4 class="modal-title" id="myModalLabel">上传图片</h4>' +
    '    </div>' +
    '    <div class="modal-body">' +
    '    <input type="file" id="file_input_cropper" inputmode="" accept=".jpeg,.jpg,.png,.bmp"' +
    'onchange="selectImage(this)">' +
    '    <input type="hidden" id="input_url">' +
    '    <div>' +
    '    <img id="cropperimg" src="/assets/website/images/blank.jpg">' +
    '    </div>' +
    '    </div>' +
    '    <div class="modal-footer">' +
    '    <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>' +
    '    <button type="button" id="save_btn" class="btn btn-primary" onclick="cropper_save()">保存</button>' +
    '    </div>' +
    '    </div>' +
    '    </div>' +
    '    </div>';
$("html").append(html);
var BLANK_IMG_URL = "/assets/website/images/blank.jpg";

function updateCrop(url) {
    if (!!window.cropper && !!url) { // reset url
        cropper.replace(url);
        $("#save_btn").removeClass("disabled");
    } else if (!!window.cropper) { //second open reset url
        cropper.replace(BLANK_IMG_URL);
    } else {//first open need init
        var image = document.getElementById('cropperimg');
        image.src = BLANK_IMG_URL;
        window.cropper = new Cropper(image, {
            aspectRatio: 1,
            toggleDragModeOnDblclick: false,
            zoomable: false,
            movable: false,
            minCropBoxWidth: 100,
            minCropBoxHeight: 100,
            dragMode: 'none',
            checkCrossOrigin: true,
            autoCrop: true
        });
    }
}

function cropper_save() {
    window.cropper_url = cropper.getCroppedCanvas().toDataURL();
    window.after_cropper();
    window.after_cropper = function () {
    };
    $('#myModal').modal('hide');
}

function selectImage(file) {
    if (file.files && file.files[0]) {
        var reader = new FileReader();
        reader.onload = function (evt) {
            updateCrop(evt.target.result);
        };
        reader.readAsDataURL(file.files[0]);
    }
}
$("#myModal").on("shown.bs.modal", function () {
    updateCrop();
    $("#file_input_cropper").val("");
    $("#save_btn").addClass("disabled");
});
window.after_cropper = function () {
};


function addCropperTrigger(jQueryObject, callbackObject) {
    jQueryObject.on("click", function () {
        $('#myModal').modal('show');
        $("#file_input_cropper").val("");
        $("#save_btn").addClass("disabled");
        if (!!callbackObject) {
            window.after_cropper = callbackObject;
        } else {
            window.after_cropper = function () {
            };
        }
    });
}

function addCropperTrigger(element_query, post_url, img_query) {
    $(element_query+","+img_query).on("click", function () {
            $('#myModal').modal('show');
            $("#file_input_cropper").val("");
            $("#save_btn").addClass("disabled");
            window.after_cropper = function () {
                var url = window.cropper_url;
                $.ajax({
                    url: post_url,
                    type: "POST",
                    data: {"imgData": url},
                    error: function () {
                        Util.msgToast({
                            message: '网络出错！',
                            mode: Util.MSGTYPE.ERROR
                        });
                    },
                    success: function (data) {
                        if (!!data.url) {
                            $(img_query).attr("src", data.url);
                            Util.msgToast({
                                message: '保存成功！',
                                mode: Util.MSGTYPE.SUCCESS
                            });
                        } else {
                            Util.msgToast({
                                message: '保存失败！',
                                mode: Util.MSGTYPE.ERROR
                            });
                        }
                    }
                });
            };
        }
    );
}






