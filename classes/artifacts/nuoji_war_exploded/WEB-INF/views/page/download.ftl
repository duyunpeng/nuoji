<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <title></title>
    <link type="text/css" rel="stylesheet" href="[@spring.url '/resources/css/index.css?time=4'/]"/>
</head>
<body>
<div class="header">
    <div class="conten clear">
        <a class="logo" href=""></a>
        <h1 class="title"></h1>
        <div class="time">
            <div id="time_date"></div>
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
                <a href="[@spring.url '/download'/]" class="no">下载中心</a>
            </div>
            <div class="visit">访问人数：<span>${count!}</span></div>
        </div>
        <div class="introduction clear">
            <div class="edition">
                <div>当前版本号：1.1.10</div>
                <div>更新日期：2016.08.04</div>
                <div>软件大小 : 22.2M</div>
            </div>
            <div class="download">
                <button class="android">安卓版下载</button>
                <button class="ios">ios版下载</button>
                <img src="[@spring.url '/resources/img/erweima.png'/]" width="200" alt="" />
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
<script type="text/javascript" src="[@spring.url '/resources/app/history/history.js?time=1'/]"></script>
<script type="text/javascript" src="[@spring.url '/resources/app/history/data.js?time=2'/]"></script>
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

    picAdvertisement();

    textAdvertisement();
</script>
</body>
</html>
