[@override name="title"]Advert管理 - Advert修改[/@override]
[@override name="topResources"]
    [@super /]

[/@override]

[@override name="breadcrumb"]
<ul class="breadcrumb">
    <li><a href="/">首页</a></li>
    <li><a href="/advert/pagination">Advert管理</a></li>
    <li>AppKey修改</li>
</ul>
[/@override]

[@override name="headerText"]
Advert 修改
[/@override]

[@override name="subContent"]
    [@mc.showAlert /]
<div class="row">
    <div class="col-lg-8">
        <form class="form-horizontal" action="/advert/edit" method="post" data-parsley-validate>

            <input type="hidden" name="id" value="${advert.id!command.id}"/>
            <input type="hidden" name="version" value="${advert.version!command.version}"/>


            [@spring.bind "command.url"/]
            <div class="form-group">
                <label for="url" class="col-md-3 control-label">广告跳转路径*</label>
                <div class="col-md-9">
                    <input class="form-control" id="url" name="url"
                           value="${advert.url!command.url}" placeholder="广告跳转路径"
                           data-parsley-required="true" data-parsley-required-messages="广告跳转路径不能为空"
                           data-parsley-trigger="change"/>
                    [@spring.showErrors "url" "parsley-required"/]
                </div>
            </div>

            [@spring.bind "command.content"/]
            <div class="form-group">
                <label for="content" class="col-md-3 control-label">内容*</label>
                <div class="col-md-9">
                    <input class="form-control" id="content" name="content"
                           value="${advert.content!command.content}" placeholder="输入内容"
                           data-parsley-required="true" data-parsley-required-messages="内容不能为空"
                           data-parsley-trigger="change"/>
                    [@spring.showErrors "content" "parsley-required"/]
                </div>
            </div>

            [@spring.bind "command.type"/]
            <div class="form-group">
                <label for="type" class="col-md-3 control-label">广告类型*</label>
                <div class="col-md-9">
                    <select id="select" class="form-control" name="type"
                            data-parsley-required="true" data-parsley-required-messages="请选择广告类型"
                            data-parsley-trigger="change">
                        [#assign type = (command.type!)?default("") /]
                        <option value="">请选择</option>
                        <option value="PICTURE" [@mc.selected type "PICTURE"/]>图片广告</option>
                        <option value="TEXT" [@mc.selected type "TEXT"/]>文字广告</option>
                    </select>
                    [@spring.showErrors "type"/]
                </div>
            </div>

            <div class="form-group hidden" id="pic">
                <label for="content" class="col-md-3 control-label">上传幻灯片图片*</label>
                <div class="col-md-9">
                    <a class="btn btn-md  btn-success img-upload">点击添加图片</a>
                    <section class="overflow-auto nice-scrollbar">
                        <ul class="img-box">
                        </ul>
                    </section>
                </div>
            </div>

            <div class="text-center m-top-md">
                <button type="reset" class="btn btn-default">重置</button>
                <button type="submit" class="btn btn-success">修改</button>
            </div>
        </form>
    </div>
    <div class="col-lg-3">
        <ul class="blog-sidebar-list font-18">修改注意事项
            <li>*位必填项</li>
        </ul>
    </div>
</div>
[/@override]

[@override name="bottomResources"]
    [@super /]
[#--文件上传进度--]
<div class="file_upload_load"></div>
<script type="application/javascript" src="[@spring.url '/resources/js/layer/layer.js'/]"></script>
<script src="[@spring.url '/resources/js/upload/webuploader.js'/]"></script>
<script type="text/javascript">
    // 初始化Web Uploader
    uploader = WebUploader.create({
        // 自动上传。
        auto: true,
        // 文件接收服务端。
        server: '/upload/img_upload',
        // 选择文件的按钮。可选。
        // 内部根据当前运行是创建，可能是input元素，也可能是flash.
        pick: '.img-upload',
        // 只允许选择文件，可选。
        accept: {
            title: 'Images',
            extensions: 'gif,jpg,jpeg,bmp,png',
            mimeTypes: 'image/*'
        }
    });
    // 当有文件添加进来的时候
    uploader.on('fileQueued', function (file) {
        uploader.makeThumb(file, function (error, src) {
            if (error) {
                return;
            }
//                alert(src);
        });
    });
    uploader.on('uploadProgress', function (file, percentage) {
        $('html').addClass('.file_upload_mask');
        $('.file_upload_load').show();
    });

    uploader.on('uploadSuccess', function (file, result) {
        $('html').removeClass('.file_upload_mask');
        $('.file_upload_load').hide();
        layer.msg("上传成功！", {icon: 1});
        var url = result.files[0].url;
        var $ul = $(".img-box");
        $ul.empty();
        $ul.append('<li><img src=' + url + '/><input id="url" type="hidden" value=' + url + '  name="pic"/><div><a href="#" class="btn btn-danger del-img">删除</a></div></li>');
        $("#content").val(url);
    });


    uploader.on('uploadError', function (handler) {
        $('html').removeClass('.file_upload_mask');
        $('.file_upload_load').hide();
        layer.msg("上传失败！");
    });

    $(".img-box").on("click", "a", function () {
        $(this).parent().parent().remove();
    })

    $("#select").on('change', function () {
        var sel_val = $('#select').val();
        if (sel_val == "PICTURE") {
            // $("#content").addClass("hidden");
            $("#pic").removeClass("hidden");
        }
        if (sel_val == "TEXT") {
            $("#pic").addClass("hidden");
            //  $("#content").removeClass("hidden");
        }
    })

</script>
[/@override]
[@extends name="/decorator.ftl"/]