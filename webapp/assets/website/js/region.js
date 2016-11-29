function selectCities(ele, isSearch) {
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
                var liString = '';
                if(isSearch) {
                    liString = '<li value="' + data.cities[i].id + '">' +
                        '<a href="#" onclick="selectCity(this);filter4Clicked(this, \''+'regionId'+'\');" value="'+data.cities[i].id+'">' +
                        data.cities[i].name + '</a></li>';
                } else {
                    liString = '<li value="' + data.cities[i].id + '">' +
                        '<a href="#" onclick="selectCity(this);" value="'+data.cities[i].id+'">' + data.cities[i].name + '</a></li>';
                }
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
    $("[name='regionId']").val(regionId);
}