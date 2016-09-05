function picAdvertisement() {
    var _container = $(".propaganda_list");
    $.ajax({
        url: "/advert/list",
        contentType: "application/json",
        type: "post",
        dataType: "json",
        data: JSON.stringify({type: 'PICTURE'}),
        success: function (result) {
            _container.empty();
            $(result.data).each(function (index, data) {
                _container.append("<div class='itme'><a href='http://" + data["url"] + "'><img src=" + data["content"] + "/></a></div>");
            })
        }
    })
}

function textAdvertisement() {
    var _container = $(".friendship_link").find(".link").find(".itme");
    $.ajax({
        url: "/advert/list",
        contentType: "application/json",
        type: "post",
        dataType: "json",
        data: JSON.stringify({type: 'TEXT'}),
        success: function (result) {
            _container.empty();
            $(result.data).each(function (index, data) {
                _container.append("<a href='http://" + data["url"] + "'>" + data["content"] + "</a>");
            })
        }
    })
}