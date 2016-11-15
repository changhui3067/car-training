function selectCities(ele) {
    var provinceId = $(ele).attr('value');
    var provinceName = ele.innerHTML;
    $('#province button').val(provinceId);
    $('#province button')[0].innerHTML = provinceName + '<span class="caret"></span>';

    var form_data = {};
    form_data.parentId = provinceId;
    $.ajax({
        type: "POST",
        url: "/backend/regions/getCities",
        data: form_data,
        error: function (request) {
            showErrMsg("网络出错啦！");
            return false;
        },
        success: function (data) {
            //$("#city").get(0).options.length = data.cities.length + 1;
            var parent = $("#city ul");
            parent.empty();
            for (var i = 0; i < data.cities.length; i++) {
                var liString = "<li value='" + data.cities[i].id + "'>" +
                    "<a href='#' onclick='selectCity(this)'>" + data.cities[i].name + "</a></li>";
                parent.append(liString);
                //$("#city ul").get(0).options[i + 1] = new Option(, );
            }
        }
    });
}

function selectCity(ele) {
    var regionId = $(ele).attr('value');
    var regionName = ele.innerHTML;
    $('#city button').val(regionId);
    $('#city button')[0].innerHTML = regionName + '<span class="caret"></span>';
}