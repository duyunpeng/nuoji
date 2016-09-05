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
                <a href="[@spring.url '/rule'/]" class="no">游戏规则</a>
                <a href="[@spring.url '/download'/]">下载中心</a>
            </div>
            <div class="visit">访问人数：<span>${count!}</span></div>
        </div>
        <div class="introduction">
            <p>
                一，KENO 游戏的来历
                 据记载，基诺（Keno）游戏起源于2000多年前的中国，并由中国移民于19世纪晚期带入美国。在旧金山等城市基诺（Keno）被称为“中国彩票”
                （Chinese Lottery）。但因为当时基诺仍使用中国汉字当作下注号码，它没能很快融入美国的主流文化。直到19世纪汉字被相应的数字代替时，基诺（Keno）的历史才有了进一步的发展。现在世界上很多国家和地区发行的KENO游戏，已经成为一种流行的大众数字游戏，普通的官方玩法通常从01-80个数字中任选1-10
                个数字组成一注，开奖时，随机摇出20个数字作为开奖号码，根据选中号码的个数获得不同等级的奖金，通常选中数字越多，奖金越高。</p>
            <p>
                二，国内官方规则
                 采用组合式玩法，投注者从1至80个号码中任意选择1至10
                个号码进行投注，每一组1个至10个号码的组合称为一注彩票。开奖时从1至80的号码中摇出20个号码。 </p>
            <p>1、投注方法为单式投注，每注金额人民币2元。投注者可在北京福彩中心设置的快乐8投注站投注。按期销售，每5分钟销售一期。销售期号按每期开奖顺序编排。 投注者可以选择当期投注或多期投注。
                当期投注指只购买当期彩票，多期投注指购买从当期起最多连续
                12期的彩票。投注者可选择机选号码投注或者自选号码投注，机选号码投注即由投注机随机产生投注号码进行投注，自选号码投注即将投注者选定的号码输入投注机进行投注。采取有纸化投注，投注号码经投注机打印为兑奖凭证，交投注者保存，此兑奖凭证即为快乐8彩票。
                投注单正面印有投注机可识别的数字阵列，做为待选的投注号码，背面印有投注说明。</p>
            <p>2、按当期销售额的50%、15%和35%分别计提返奖奖金、发行费和公益金。
                有10种玩法。其中“选十”玩法采用浮动奖金设奖，其它玩法采用固定奖金设奖，按所设奖金等级兑奖。
                设置奖池。</p>
            奖池资金由当期计提奖金与实际中出奖金的差额、单注奖金按元整后的余额，以及弃奖奖金组成。当期实际中出奖金小于当期计提奖金时，余额进入奖池；当期实际中出奖金超过当期计提奖金时，差额由奖池资金补足。当奖池资金总额不足时，用发行费垫支。
            <p>3、“选十中十”
                奖等单独设置奖池，奖池资金由上期“选十中十”奖等未中出奖金、超出单注封顶限额部分的奖金、当期快乐8总销售额的0.2%
                、当期“选十”玩法总奖金减去当期固定奖总奖金后的余额组成。、
                 如果当期“选十中十”奖等没有投注者中出，则当期“选十中十”奖金滚入“选
                十中十”奖池。当期“选十中十”奖等做如下特别规定：若当期“选十中十”奖池资金不足20万元，则按当期“选十中十”奖等的中奖注数均分20万元奖金，不足部分由快乐8奖池资金补足，奖池资金不足时，由发行费垫支。如果“选十中十”奖池资金超过20万元，则按当期“选十中十”奖等的中奖注数均分“选十中十”奖池
                资金</p>
            <p>4、“选十中十”
                奖等单注奖金设置封顶限额，单注最高奖金不得超过500万元，超
                过部分进入下期“选十中十”奖池。
                 “选九”玩法设置总奖金封顶限额。若当期“选九中九”奖等的中奖总金额超过500万元，则兑付奖金按500万元计算，按当期“选九中九”奖等的中奖注数均分最高500万元奖金，单注奖金以元为单位取整。超过500万元奖金的部分和单注奖金按元取整后的余额进入奖池。
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
