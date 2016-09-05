[@override name="title"]开奖管理 - 开奖查看[/@override]
[@override name="topResources"]
    [@super /]

[/@override]

[@override name="breadcrumb"]
<ul class="breadcrumb">
    <li><a href="/">首页</a></li>
    <li><a href="/account/pagination">开奖管理</a></li>
    <li>开奖查看</li>
</ul>
[/@override]

[@override name="headerText"]
开奖 查看
[/@override]

[@override name="subContent"]
    [@mc.showAlert /]
<div class="row">
    <div class="col-lg-12">
        <ul class="contract-show">
            <li>
                <span class="col-md-3">开奖期号</span>
                <div class="col-md-8 contract-box">${history.historyNo!}</div>
            </li>
            <li>
                <span class="col-md-3">开奖号码</span>
                <div class="col-md-8 contract-box">${history.lotteryNo!}</div>
            </li>
            <li>
                <span class="col-md-3">开奖日期</span>
                <div class="col-md-8 contract-box">${history.lotteryDate!}</div>
            </li>

            <li>
                <span class="col-md-3">开奖状态</span>
                <div class="col-md-8 contract-box">${(history.isOpen.getName())!}</div>
            </li>
            <div>
                <div class="col-sm-offset-6 col-sm-12">
                    <a href="[@spring.url '/history/pagination' /]" class="btn btn-default">返回列表</a>
                </div>
            </div>
        </ul>
    </div>
</div>
[/@override]

[@override name="bottomResources"]
    [@super /]
<script type="text/javascript">
    var data_list = $(".data-list");
    data_list.slimScroll({
        height: '600px'
    });
</script>
[/@override]
[@extends name="/decorator.ftl"/]