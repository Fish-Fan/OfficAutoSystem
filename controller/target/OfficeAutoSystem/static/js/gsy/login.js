function checkU() {
    var name = document.getElementById("username").value;
    var name_msg = document.getElementById("username");
    if (name == null || name == "") {
        name_msg.setAttribute('placeholder', "用户名不能为空");
    }
}
function checkP(){
    var pwd = document.getElementById("password").value;
    var pwd_msg = document.getElementById("password");
    if (pwd == null || pwd == "") {
        pwd_msg.setAttribute('placeholder', "密码不能为空");
    }
}