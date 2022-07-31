function genaratePaymentID() {
    $.ajax({
        url: "http://localhost:8080/CarRentalSystem_war/payment/GeneratePaymentID",
        method: "GET",
        success: function (resp) {
            console.log(resp.data);
            $("#payID").text(resp.data);

        },
        error: function (ob) {
            alert(ob.responseJSON.message);
        }
    });


}