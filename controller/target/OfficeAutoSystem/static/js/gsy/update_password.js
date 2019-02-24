function checkP() {
    var pwd = document.getElementById("password").value;
    var pwd_msg = document.getElementById("password");
    if(pwd.length <= 6 || pwd.length >= 12) {
        $('input[id="password"]').val("").attr('placeholder', '密码长度应在6到12之间!')
    }
}