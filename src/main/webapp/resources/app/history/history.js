(function () {
    window.HistorySearch = function (config) {
        var defaultConfig = {
            id: "",  //容器ID
            url: "",            //数据获取地址
            pageSize: 10,        //分页大小
        };
        this.config = $.extend(defaultConfig, config || {});
        this.searchCommand = {page: 1, pageSize: 10};//查询条件
        this.searchPaginationDate = {};//每次加载的数据
        this.modal = $("#" + this.config.id);//弹窗容器
        this._table = this.modal.find("table");//table
        this.init();
    }

    window.HistorySearch.prototype = {
        init: function () {
            this._search();
        },
        //数据请求
        _search: function () {
            var _this = this;
            $.ajax({
                url: _this.config.url,
                contentType: "application/json",
                type: "post",
                dataType: "json",
                data: JSON.stringify(_this.searchCommand),
                success: function (pagination) {
                    _this.searchPaginationDate = pagination;
                    _this._showData();
                }
            })
        },
        _showData: function () {
            var _tbody = this._table.find('tbody');
            _tbody.empty();
            var dom = ''
            $(this.searchPaginationDate.data).each(function (index, data) {
                dom += "<tr>";
                var number = data['lotteryNo'].split(',');
                dom += "<td>" + (index + 1) + "</td><td>" + data['historyNo'] + "</td><td>" + data['lotteryDate'] + "</td>";
                dom += "<td><div class='kj_qiu1'>";
                dom += "<span>" + number[0] + "</span><span>" + number[1] + "</span><span>" + number[2] + "</span><span class='bule'>" + (parseFloat(number[0]) + parseFloat(number[1]) + parseFloat(number[2])) + "</span>";
                dom += "</div></td>";
                dom += "</tr>";
            })
            _tbody.append(dom);
            this._showPage();
        },
        _showPage: function () {
            var count = this.searchPaginationDate.count;
            var pageSize = this.searchPaginationDate.pageSize;
            var page = this.searchPaginationDate.page;
            var totalPage = Math.ceil(count / pageSize);
            var sb = new StringBuilder();
            sb.append("总计").append(count).append("条数据，每页显示").append(pageSize).append("条，总共").append(totalPage).append("页");
            $('.paging-info').text(sb.toString());
            sb.clear();

            if (count > 0) {
                if (page - 1 <= 0) {
                    sb.append("<li class=\"disabled\"><a href=\"#\"><i class=\"fa fa-angle-double-left\"></i></a></li>");
                } else {
                    sb.append("<li><a href=\"" + (page - 1) + "\"><i class=\"fa fa-angle-double-left\"></i></a></li>");
                }

                var index = 1;
                while (index <= totalPage) {
                    if (count < 11) {
                        if (page == index) {
                            sb.append("<li class=\"active\"><a href=\"" + index + "\">" + index + "</a></li>");
                        } else {
                            sb.append("<li><a href=\"" + index + "\">" + index + "</a></li>");
                        }
                    } else {
                        if (index > (page - 5) && index < (page + 4)) {
                            if (page == index) {
                                sb.append("<li class=\"active\"><a href=\"" + index + "\">" + index + "</a></li>");
                            } else {
                                sb.append("<li><a href=\"" + index + "\">" + index + "</a></li>");
                            }
                        }
                    }
                    index++;
                }

                if (page == totalPage) {
                    sb.append("<li class=\"disabled\"><a href=\"#\"><i class=\"fa fa-angle-double-right\"></i></a></li>");
                } else {
                    sb.append("<li><a href=\"" + (page + 1) + "\"><i class=\"fa fa-angle-double-right\"></i></a></li>");
                }
            }

            $(".pagination").empty().append(sb.toString());
            var _this = this;
            $(".pagination").find("li[class!='disabled']").on("click", function () {
                _this.searchCommand["page"] = $(this).find("a").attr("href");
                _this._search();
                return false;
            });
        }
    }
})();