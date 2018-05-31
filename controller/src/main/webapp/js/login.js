function login(){
    var username = $("#username").val();
    if(username == null || username == ""){
        alert("请输入用户名");
        return;
    }
    var password = $("#password").val();
    if(password == null || password == ""){
        alert("请输入密码");
        return;
    }
    var data = $.param({
        userName:username,
        passWord:password
    });
    $.post('/user/login',data,function(data){
        if(data.code == 1){
            document.location.href = "/book/index.html";
        } else {
            $.messager.alert('警告', '用户名或密码错误！', 'warning');
        }
    },'json');
}
