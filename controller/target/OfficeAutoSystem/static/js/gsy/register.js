function checkU() {
    var name = document.getElementById("username").value;
    var name_msg = document.getElementById("username");
    if (name == null || name == "") {
        name_msg.setAttribute('placeholder', "用户名不能为空");
    }
}
function checkP() {
    var pwd = document.getElementById("password").value;
    var pwd_msg = document.getElementById("password");
    if(pwd.length <= 6 || pwd.length >= 12) {
        $('input[id="password"]').val("").attr('placeholder', '密码长度应在6到12之间!')
    }
}
function checkE() {
    var email = document.getElementById("email").value;
    if (!email.match(/^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+((\.[a-zA-Z0-9_-]{2,3}){1,2})$/)) {
        $('input[id="email"]').val("").attr('placeholder', '请输入正确的邮箱')
    }
}
function checkPn() {
    var phonenumber = document.getElementById("phoneNumber").value;

    if (!phonenumber.match(/^(((13[0-9]{1})|(15[0-9]{1})|(18[0-9]{1}))+\d{8})$/)) {
        $('input[id="phoneNumber"]').val("").attr('placeholder', '请输入正确的手机号')
    }
}