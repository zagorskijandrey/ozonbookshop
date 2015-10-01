$.noConflict();
function doAjaxPost() {

    var ratValue = $("#ratValue").val();
    $.ajax({
        method: "POST",
        url:"action",
        data:"ratValue="+ratValue.serialize(),
        cache: false,
        dataType: 'json',
        contentType: 'application/json; charset=utf-8',
        success: function (response) {
            alert('Success');
            $('#returnResult').html(response);
        },
        error:function(data,status,er) {
            alert("error: "+data+" status: "+status+" er:"+er);
        }
    });
    return false;
}
