[@override name="title"]开奖管理 - 开奖修改[/@override]
[@override name="topResources"]
    [@super /]

[/@override]

[@override name="breadcrumb"]
<ul class="breadcrumb">
    <li><a href="/">首页</a></li>
    <li><a href="/role/pagination">开奖管理</a></li>
    <li>开奖修改</li>
</ul>
[/@override]

[@override name="headerText"]
开奖 修改
[/@override]

[@override name="subContent"]
    [@mc.showAlert /]
<div class="row">
    <div class="col-lg-8">
        <form class="form-horizontal" action="/history/edit" method="post" data-parsley-validate>

            <input type="hidden" name="id" value="${history.id!command.id}"/>
            <input type="hidden" name="version" value="${history.version!command.version}"/>

            [@spring.bind "command.lotteryNo"/]
            <div class="form-group">
                <label for="name" class="col-md-3 control-label">开奖名称*</label>
                <div class="col-md-9">
                    <input class="form-control" id="lotteryNo" name="lotteryNo"
                           value="${history.lotteryNo!command.lotteryNo}" placeholder="输入开奖号码"
                           data-parsley-required="true" data-parsley-required-messages="开奖号码不能为空"
                           data-parsley-trigger="change"/>
                    [@spring.showErrors "lotteryNo" "parsley-required"/]
                </div>
            </div>
            <div class="text-center m-top-md">
                <button type="reset" class="btn btn-default">重置</button>
                <button type="submit" class="btn btn-success">修改</button>
            </div>
        </form>
    </div>
    <div class="col-lg-3">
        <ul class="blog-sidebar-list font-18">创建注意事项
            <li>*位必填项</li>
        </ul>
    </div>
</div>

[/@override]
[@extends name="/decorator.ftl"/]