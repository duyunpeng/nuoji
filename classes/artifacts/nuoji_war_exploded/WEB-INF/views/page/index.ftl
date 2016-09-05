<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"/>
    <title>全球基诺网</title>
    <link type="text/css" rel="stylesheet" href="[@spring.url '/resources/css/index.css'/]"/>

    <!-- 字体 -->
    <link href="[@spring.url '/resources/css/font-awesome.min.css'/]" rel="stylesheet">
</head>
<body>
<div class="header">
    <div class="conten clear">
        <a class="logo" href=""></a>
        <h1 class="title"></h1>
        <div class="time">
            访问人数：<span>${count!}</span>
        </div>
    </div>
</div>

<div class="content-box">
    <div class="roulette">
        <div class="title">
            <a href="[@spring.url '/'/]" class="lo_text"></a>
            <div class="nav">
                <a href="[@spring.url '/synopsis'/]">基诺简介</a>
                <a href="[@spring.url '/rule'/]">游戏规则</a>
                <a href="[@spring.url '/download'/]">下载中心</a>
            </div>
            <div class="visit">访问人数：<span>${count!}</span></div>
        </div>
        <div class="rou_cont">
            <div class="clear">
                <div class="item">
                    <img id="lotteryBtn1" class="img lotteryBtn" src="[@spring.url '/resources/img/zhizhen.png'/]"
                         alt=""/>
                </div>
                <div class="item">
                    <img id="lotteryBtn2" class="img lotteryBtn" src="[@spring.url '/resources/img/zhizhen.png'/]"
                         alt=""/>
                </div>
                <div class="item">
                    <img id="lotteryBtn3" class="img lotteryBtn" src="[@spring.url '/resources/img/zhizhen.png'/]"
                         alt=""/>
                </div>
            </div>
            <div class="count_down">
                开奖倒计时： <span id="online-info-1">00:00:00</span>
            </div>
        </div>

    </div>

    <div class="winning">
        <div class="title">
            <div class="number"><span>1254872</span>人中奖</div>
            <div class="people">
                <marquee>
                    <a>我为你☆☆☆&nbsp;&nbsp;江西时时彩三星复式</a><span>¥1,160.00</span>
                    <a>wzg☆☆☆&nbsp;&nbsp;江西时时彩三星单式</a><span>¥1,860.00</span>
                    <a>731☆☆☆&nbsp;&nbsp;江西时时彩三星组选六单式</a><span>¥1,160.00</span>
                    <a>123☆☆☆&nbsp;&nbsp;安徽快3二同号单选单式</a><span>¥1,140.00</span>
                    <a>中奖过☆☆☆&nbsp;&nbsp;江西时时彩三星复式</a><span>¥51,460.00</span>
                    <a>我为你☆☆☆&nbsp;&nbsp;江西时时彩四星单式</a><span>¥1,220.00</span>
                    <a>jxx☆☆☆&nbsp;&nbsp;安徽快3二同号单选单式</a><span>¥1,160.00</span>
                    <a>中奖过☆☆☆&nbsp;&nbsp;江西时时彩三星复式</a><span>¥2,440.00</span>
                    <a>我为你☆☆☆&nbsp;&nbsp;江西时时彩四星单式</a><span>¥1,220.00</span>
                    <a>jxx☆☆☆&nbsp;&nbsp;安徽快3二同号单选单式</a><span>¥1,160.00</span>
                    <a>好运来☆☆☆&nbsp;&nbsp;江西时时彩三星复式</a><span>¥2,440.00</span>
                    <a>197☆☆☆&nbsp;&nbsp;江西时时彩四星单式</a><span>¥1,220.00</span>
                    <a>jxx☆☆☆&nbsp;&nbsp;安徽快3二同号单选单式</a><span>¥1,220.00</span>
                    <a>中奖过☆☆☆&nbsp;&nbsp;江西时时彩三星复式</a><span>¥2,440.00</span>
                    <a>我为你☆☆☆&nbsp;&nbsp;江西时时彩四星单式</a><span>¥10,220.00</span>
                    <a>jxx☆☆☆&nbsp;&nbsp;安徽快3二同号单选单式</a><span>¥1,440.00</span>
                    <a>731☆☆☆&nbsp;&nbsp;江西时时彩三星复式</a><span>¥4,210.00</span>
                    <a>我为你☆☆☆&nbsp;&nbsp;江西时时彩四星单式</a><span>¥1,220.00</span>
                    <a>jxx☆☆☆&nbsp;&nbsp;安徽快3二同号单选单式</a><span>¥1,160.00</span>
                    <a>yy1☆☆☆&nbsp;&nbsp;江西时时彩三星复式</a><span>¥2,440.00</span>
                    <a>pl1☆☆☆&nbsp;&nbsp;江西时时彩四星单式</a><span>¥1,220.00</span>
                    <a>jxx☆☆☆&nbsp;&nbsp;安徽快3二同号单选单式</a><span>¥1,160.00</span>
                    <a>yy1☆☆☆ 江西时时彩三星单式</a> <span>¥1160.00</span>
                    <a>yy８☆☆☆ 重庆时时彩三星单式</a> <span>¥51460.00</span>
                </marquee>
            </div>
        </div>

        <div class="winning_record" id="historySearch">
            <table>
                <thead>
                <tr>
                    <th>序号</th>
                    <th>期号</th>
                    <th>开奖时间</th>
                    <th>开奖号码</th>
                </tr>
                </thead>
                <tbody>
                </tbody>
            </table>
            <!-- 分页信息 -->
            <div class="row">
                <div class="col-sm-4 text-center">
                    <small class="inline table-options paging-info">
                    </small>
                </div>
                <div class="col-sm-4 text-center sm-center">
                    <ul class="pagination pagination-sm no-margin pagination-custom no-m-left">
                    </ul>
                </div>
            </div>
        </div>
    </div>

    <!--列表-->
    <div class="propaganda_list clear">
    </div>
    <!--其他基诺/链接-->
    <div class="friendship_link">
        <div class="title">其他基诺</div>
        <div class="link">
            <div class="itme clear">
            </div>

        </div>
    </div>

</div>
<div class="footer">
    <div class="conten">
        © 2016 渝ICP备10019385号
    </div>
</div>
<script src="[@spring.url '/resources/js/jquery.min.js'/]"></script>
<script type="text/javascript" src="[@spring.url '/resources/js/countDown.js'/]"></script>
<script type="text/javascript" src="[@spring.url '/resources/app/history/history.js'/]"></script>
<script type="text/javascript" src="[@spring.url '/resources/app/history/data.js'/]"></script>
<script type="text/javascript" src="[@spring.url '/resources/js/jQueryRotate.2.2.js'/]"></script>
<script type="text/javascript" src="[@spring.url '/resources/js/jquery.easing.min.js'/]"></script>
<script type="text/javascript" src="[@spring.url '/resources/js/common.js'/]"></script>
<script type="text/javascript">
    var _historySearch = new HistorySearch({
        url: "/history/list",
        id: "historySearch"
    })

    picAdvertisement();

    textAdvertisement();

    function initZhuan() {
        $(".rou_cont").find(".clear").empty();
        $(".rou_cont").find(".clear").append("<div class='item'><img id='lotteryBtn1' class='img lotteryBtn' src='/resources/img/zhizhen.png' alt=''/></div><div class='item'><img id='lotteryBtn2' class='img lotteryBtn' src='/resources/img/zhizhen.png' alt=''/></div><div class='item'><img id='lotteryBtn3' class='img lotteryBtn' src='/resources/img/zhizhen.png' alt=''/></div>");
    }
</script>
<script type="text/javascript">
    function sfn() {
        initZhuan();

        zhuan();

//        setTimeout(timeCount(), 2000);//两秒后执行
    }

    timeCount();

    function timeCount() {
        var date = new Date();
        var seconds = date.getSeconds();
        var minutes = date.getMinutes();
        minutes = (60 - minutes) % 5;

        if (minutes == 0) {
            seconds = 300 - (seconds + 2) + 2;
        } else {
            seconds = minutes * 60 + (60 - seconds);
            seconds = seconds - 60 + 2;
        }
        var t_1 = {
            id: 'online-info-1',
            timeStamp: seconds,
            fn: sfn,
            colonTag: 'span'
        }
        djs_time.newTimer(t_1);
    }

    //var t_2={id:'online-info-2',timeStamp:300,fn:sfn}
    //djs_time.newTimer(t_2);
</script>
<script type="text/javascript">
    var rotateFunc = function (lotteryBun, awards, angle, index, result, lotteryNo) { //awards:奖项，angle:奖项对应的角度
        $(lotteryBun.get(index)).stopRotate();
        $(lotteryBun.get(index)).rotate({
            angle: 0,
            duration: 5000,
            animateTo: angle + 1440, //angle是图片上各奖项对应的角度，1440是我要让指针旋转4圈。所以最后的结束的角度就是这样子^^
            callback: function () {
                if (index == 2) {
                    timeCount();
                    var _historySearch = new HistorySearch({
                        url: "/history/list",
                        id: "historySearch"
                    })
                } else {
                    index = parseInt(index) + parseInt(1);
                    var data = lotteryNo[index];
                    if (data == 1) {
                        rotateFunc(lotteryBun, 1, 18, index++, result, lotteryNo)
                    }
                    if (data == 2) {
                        rotateFunc(lotteryBun, 2, 56, index++, result, lotteryNo)
                    }
                    if (data == 3) {
                        rotateFunc(lotteryBun, 3, 92, index++, result, lotteryNo)
                    }
                    if (data == 4) {
                        rotateFunc(lotteryBun, 4, 128, index++, result, lotteryNo)
                    }
                    if (data == 5) {
                        rotateFunc(lotteryBun, 5, 164, index++, result, lotteryNo)
                    }
                    if (data == 6) {
                        rotateFunc(lotteryBun, 6, 200, index++, result, lotteryNo)
                    }
                    if (data == 7) {
                        rotateFunc(lotteryBun, 7, 236, index++, result, lotteryNo)
                    }
                    if (data == 8) {
                        rotateFunc(lotteryBun, 8, 272, index++, result, lotteryNo)
                    }
                    if (data == 9) {
                        rotateFunc(lotteryBun, 9, 308, index++, result, lotteryNo)
                    }
                    if (data == 0) {
                        rotateFunc(lotteryBun, 0, 344, index++, result, lotteryNo)
                    }
                }
            }
        });
    };

    function zhuan() {
        $.ajax({
            url: "/history/new_history",
            success: function (result) {
                var lotteryNo = result['lotteryNo'].split(',');
                var data = lotteryNo[0];
                var dom = $(".lotteryBtn");
                if (data == 1) {
                    rotateFunc(dom, 1, 18, 0, result, lotteryNo)
                }
                if (data == 2) {
                    rotateFunc(dom, 2, 56, 0, result, lotteryNo)
                }
                if (data == 3) {
                    rotateFunc(dom, 3, 92, 0, result, lotteryNo)
                }
                if (data == 4) {
                    rotateFunc(dom, 4, 128, 0, result, lotteryNo)
                }
                if (data == 5) {
                    rotateFunc(dom, 5, 164, 0, result, lotteryNo)
                }
                if (data == 6) {
                    rotateFunc(dom, 6, 200, 0, result, lotteryNo)
                }
                if (data == 7) {
                    rotateFunc(dom, 7, 236, 0, result, lotteryNo)
                }
                if (data == 8) {
                    rotateFunc(dom, 8, 272, 0, result, lotteryNo)
                }
                if (data == 9) {
                    rotateFunc(dom, 9, 308, 0, result, lotteryNo)
                }
                if (data == 0) {
                    rotateFunc(dom, 0, 344, 0, result, lotteryNo)
                }
            }
        })

    }
</script>
<script type="text/javascript">
    // 定义获取和更新时间的函数
    function showTime() {
        var curTime = new Date();
        $("#time_date").html(curTime.toLocaleString());
        setTimeout("showTime()", 1000);
    }
    // 页面加载完成后执行上面的自定义函数
    $(function () {
        showTime()
    })
</script>
</body>
</html>
