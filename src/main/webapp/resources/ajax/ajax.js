$(document).ready(function(){
    $(document).getElementById.("formToSend").submit(function () {
        doAjaxPost();
    });
});
function doAjaxPost() {

    var ratValue = $('#ratValue').val();
    //var json = {"ratValue" : ratValue};
    $.ajax({
        type: "POST",
        url:'action',
        data: "ratValue="+ratValue,
        //dataType: 'json',
        //contentType: 'application/json',
        //mimeType: 'application/json',
        //headers: {
        //    'Accept': 'application/json',
        //    'Content-Type': 'application/json'
        //},
        success: function (response) {
            $('#returnResult').html(response);
            alert('Success');
        },
        error:function(data,status,er) {
            alert("error: "+data+" status: "+status+" er:"+er);
        }

    });
}
