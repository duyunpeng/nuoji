<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"/>
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
                <a href="[@spring.url '/synopsis'/]" class="no">基诺简介</a>
                <a href="[@spring.url '/rule'/]">游戏规则</a>
                <a href="[@spring.url '/download'/]">下载中心</a>
            </div>
            <div class="visit">访问人数：<span>${count!}</span></div>
        </div>
        <div class="introduction">
            <p>
                据西方一份古老的档案记载，基诺游戏起源于2000多年前的中国。一个名叫梁张（音译）的汉朝人为了拯救自己的城市发明了这种机会游戏。梁张的城市多年征战，因为城里的居民拒绝给战争提供任何财政支持，军队很快用尽了所有供给，城市陷入危机。梁张发明的数字游戏给军队带来收入和所有的必需品，城市因此得救了。在随后的一年里，这种游戏迅速传遍中国，并且为修建长城募集到充足的资金。
                在中国，这一游戏被称为“白鸽票”（White Pigeon
                Game），因人们用信鸽将中奖号码从大城市传递到农村而得名。作为中国最早的自选数字彩票，白鸽票起源于早期赌鸽。赛鸽时每只鸽子按中国启蒙读本《千字文》中的“天、地、玄、黄、宇、宙、洪、荒”等80个字顺序编号，然后把鸽子放飞，让人们猜测哪只赛鸽能够获胜。赌鸽时所猜字号若与比赛结果相同，则为赢家。随着时间的推移，白鸽票的玩法逐渐产生变化。彩票公司将《千字文》前面的80个字印在彩票上，让每个投注的彩民在票上各圈10个字，然后彩票公司开出底字20个，相当于中奖号码。彩民所圈的10个字中，若有5字以上相符，便是中奖。
                后来，随着中国移民到美国修建铁路，基诺彩票传入北美地区。尽管最初是非法经营，基诺在中国移民中仍然相当流行，在旧金山等城市基诺被称为“中国彩票”（Chinese
                Lottery）。但因为当时基诺仍使用中国汉字当作下注号码，它没能很快融入美国的主流文化。直到19世纪汉字被相应的数字代替时，基诺的历史才有了进一步的发展。
                1931年，美国内华达州立法机关将部分赌博合法化，但是这其中不包括彩票。为了使基诺能够继续发展，“中国彩票”被改名为“赛马基诺”（horse race
                keno），假装彩票上的数字是赛马的号码，而彩民是在赌哪匹马会赢。后来当政府通过一项法律开始对赛马的场外下注征税时，内华达州又将"赛马基诺"的名字改变为“基诺”(Keno)。

            </p>
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
