/*$(document).ready(function(){
    $(document).getElementById.("formToSend").submit(function () {
        doAjaxPost();
    });
});*/
function doAjaxPost() {

    var ratValue = $("#ratValue").val();
    var json = {"ratValue" : ratValue};
    $.ajax({
        headers: {
            Accept : "text/plain; charset=utf-8",
            "Content-Type": "text/plain; charset=utf-8"
        },
        type: "POST",
        url:"action",
        data: JSON.stringify(json),//"ratValue="+ratValue.serialize(),
        cache: false,
        dataType: 'json',
        //contentType: 'application/json',
        //mimeType: 'application/json',

        /*success: function (rating) {
            alert('Success');
            var respContent = "";
            respContent += "<span class='success'>Rating was created: [";
            respContent += rating.ratValue + "]</span>";
            $('#returnResult').html(respContent);
            //alert('Success');
        },*/
        success: function (response) {
            alert('Success');
            $('#returnResult').html(response);
        },
        error:function(data,status,er) {
            alert("error: "+data+" status: "+status+" er:"+er);
        }

    });
}
