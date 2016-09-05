[@override name="title"]Advert管理 - Advert查看[/@override]
[@override name="topResources"]
    [@super /]

[/@override]

[@override name="breadcrumb"]
<ul class="breadcrumb">
    <li><a href="/">首页</a></li>
    <li><a href="/advert/pagination">Advert管理</a></li>
    <li>Advert查看</li>
</ul>
[/@override]

[@override name="headerText"]
Advert 查看
[/@override]

[@override name="subContent"]
    [@mc.showAlert /]
<div class="row">
    <div class="col-lg-12">
        <ul class="contract-show">
            <li>
                <span class="col-md-3">广告类型</span>
                <div class="col-md-8 contract-box">${advert.type.getName()!}</div>
            </li>
            <li>
                <span class="col-md-3">内容</span>
                <div class="col-md-8 contract-box">${advert.content!}</div>
            </li>
            <li>
                <span class="col-md-3">广告跳转路径</span>
                <div class="col-md-8 contract-box">${advert.url!}</div>
            </li>
            <div>
                <div class="col-sm-offset-6 col-sm-12">
                    <a href="[@spring.url '/advert/create' /]" class="btn btn-success">再创建一个</a>
                    <a href="[@spring.url '/advert/pagination' /]" class="btn btn-default">返回列表</a>
                </div>
            </div>
        </ul>
    </div>
</div>
[/@override]

[@override name="bottomResources"]
    [@super /]

[/@override]
[@extends name="/decorator.ftl"/]