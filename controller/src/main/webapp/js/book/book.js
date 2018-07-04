function getBookByCategroy() {
    
}
function getCategroy() {
    document.location.href = "/book/categroy.html";
}
$(function () {
    var data = $.param({
        rowIndex:0,
        pageSize:10,
        type:101
    });
    $.post('/book/bookListTest',data,function(data){
        if(data.code == 1){
            var html = "";
            for(var i = 0 ; i < data.data.length ; i++){
                html+=("<a href='"+data.data[i].bookUrl+"' target='_blank'>"+data.data[i].bookName+"</a><hr>")
            }
            $("#name").html(html);
        } else {
            $(".error-mess").show();
            $("#error-message").html( data.msg);
        }
    },'json');
});