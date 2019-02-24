$(function () {
    var video = document.getElementById('video'),
        canvas = document.getElementById('canvas'),
        snap = document.getElementById('tack'),
        img = document.getElementById('img'),
        vendorUrl = window.URL || window.webkitURL;

    //媒体对象
    navigator.getMedia = navigator.getUserMedia ||
        navagator.webkitGetUserMedia ||
        navigator.mozGetUserMedia ||
        navigator.msGetUserMedia;
    navigator.getMedia({
        video: true, //使用摄像头对象
        audio: false  //不适用音频
    }, function (strem) {
        console.log(strem);
        video.src = vendorUrl.createObjectURL(strem);
        video.play();
    }, function (error) {
        //error.code
        console.log(error);
    });
    snap.addEventListener('click', function () {

        //绘制canvas图形
        canvas.getContext('2d').drawImage(video, 0, 0, 400, 300);

        //把canvas图像转为img图片
        img.src = canvas.toDataURL("image/png");

        $.post('/user/facesearch',{
            "img": imgdata.split(',')[1]
        },function (data) {
            var result = JSON.parse(data).result;
            if(result == 'match_fail') {
                toastr.error('没有检测到人脸', '签到失败');
            } else if(result == 'no_user') {
                toastr.warning('没有找到该用户', '签到失败');
            } else {
                toastr.success('签到成功', '签到成功');
                $('#voice').attr('src',result);
            }
        });

    })
});