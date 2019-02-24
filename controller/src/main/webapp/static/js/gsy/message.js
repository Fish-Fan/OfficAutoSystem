function checkP() {
    var phonenumber = document.getElementById("phoneNumber").value;
    if (!phonenumber.match(/^(((13[0-9]{1})|(15[0-9]{1})|(18[0-9]{1}))+\d{8})$/)) {
        $('input[id="phoneNumber"]').val("").attr('placeholder', '请输入正确的手机号')
    }
}
function checkE() {
    var email = document.getElementById("email").value;
    if (!email.match(/^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+((\.[a-zA-Z0-9_-]{2,3}){1,2})$/)) {
        $('input[id="email"]').val("").attr('placeholder', '请输入正确的邮箱')
    }
}
function checkO() {
    var offical_number = document.getElementById("officalNumber").value;
    if (!offical_number.match(/^(\(\d{3,4}\)|\d{3,4}-)?\d{7,8}$/)) {
        $('input[id="officalNumber"]').val("").attr('placeholder', '请输入正确的号码')
    }
}
function checkPo() {
    var postcode = document.getElementById("postcode").value;
    if (!postcode.match(/^[0-9][0-9]{5}$/)) {
        $('input[id="postcode"]').val("").attr('placeholder', '请输入正确的邮编')
    }
}
function checkOa() {
    var offical_address = document.getElementById("officalAddress").value;
    var offical_address_msg = document.getElementById("officalAddress");
    if (offical_address == null || offical_address == "") {
        offical_address_msg.setAttribute('placeholder', "内容不能为空");
    }
}
function checkD() {
    var desc = document.getElementById("desc").value;
    var desc_msg = document.getElementById("desc");
    if (desc == null || desc == "") {
        desc_msg.setAttribute('placeholder', "内容不能为空");
    }
}
function checkR() {
    var remark = document.getElementById("remark").value;
    var remark_msg = document.getElementById("remark");
    if (remark == null || remark == "") {
        remark_msg.setAttribute('placeholder', "内容不能为空");
    }
}