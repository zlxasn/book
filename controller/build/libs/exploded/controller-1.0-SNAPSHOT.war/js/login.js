function login(){
    var username = $("#username").val();
    var password = $("#password").val();
    if(username == null ||username == ''){
        $(".error-mess").show();
        $("#error-message").html( '请输入用户名！' );
    }else if(password == null || password == ''){
        $(".error-mess").show();
        $("#error-message").html( '请输入密码！' );
    }else{
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
}
