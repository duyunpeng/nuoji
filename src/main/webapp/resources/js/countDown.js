/*
 djs_time˵��
 id:'��������ʱ���ݵı�ǩID'
 timeStamp:�ӷ�����������ʱ���
 fn:�ص�����
 colonTag:'����ʱ��ð�ű�ǩ���ɲ���'
 @author by mengxiaodi
 email:1104252528@qq.com
 */
var djs_time = {
    id: null,
    timerInterval: null,
    colonTag: null,
    newTimer: function (obj) {
        this.init.prototype = djs_time;
        return new this.init(obj);
    },
    //���0
    addZero: function (num) {
        if (num.toString().length === 1) {
            return "0" + num;
        } else {
            return num;
        }
    },
    //ˢ��ҳ�棬����ֵ
    fresh: function () {
        var timeStamp = this.timeStamp--;
        var __d = parseInt(timeStamp / 3600 / 24);
        var __h = this.addZero(parseInt((timeStamp / 3600) % 24) + __d * 24);
        var __m = this.addZero(parseInt((timeStamp / 60) % 60));
        var __s = this.addZero(parseInt(timeStamp % 60));
        var htmls = '';
        //__d+"�� "+__h+"Сʱ"+__m+"��"+__s+"��"
        if (this.colonTag) {
            this.eleWrap.innerHTML = __h + '<' + this.colonTag + '>:</' + this.colonTag + '>' + __m + '<' + this.colonTag + '>:</' + this.colonTag + '>' + __s;
        } else {
            this.eleWrap.innerHTML = __h + ':' + __m + ':' + __s;
        }
        if (timeStamp == 0) {
            this.eleWrap.innerHTML = "00:00:00";
            clearInterval(this.timerInterval);
            this.timerInterval = null;
            this.fn();
        }
    },
    showInterval: function () {
        var _this = this;
        this.timerInterval = window.setInterval(function () {
            _this.fresh();
        }, 1000);
    },
    init: function (obj) {
        this.eleWrap = document.getElementById(obj.id);
        this.timeStamp = obj.timeStamp;
        this.colonTag = obj.colonTag;
        this.showInterval();
        this.fn = obj.fn;
    }
}

