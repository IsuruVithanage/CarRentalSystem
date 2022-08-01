$("#btnPay").click(function () {
    savePayment();
});


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



function savePayment() {
    var rID=$("#payRentID").text();
    $.ajax({
        url: "http://localhost:8080/CarRentalSystem_war/rentreq/" + rID,
        method: "GET",
        success: function (res) {
            var custID=res.data.customer.custID;
            var driverID=res.data.driver.driverID;
            var vehicelID=res.data.vehicle.vehicleID;

            var cusOb = {
                custID: custID
            }

            var drivOb = {
                driverID: driverID
            }

            var vehiOb = {
                vehicleID: vehicelID
            }

            var rentOb = {
                rentID: rID,
                vehicle: vehiOb,
                driver: drivOb,
                customer: cusOb
            }

            var payOb = {
                paymentID: $("#payID").text(),
                date: $("#txtrdate").val(),
                milage: $("#totalMilage").val(),
                price: $("#dpay").text(),
                damagecost: $("#damagecost").val(),
                fullamount: $("#fullTotal").val(),
                rentReq: rentOb
            }

            $.ajax({
                url: "http://localhost:8080/CarRentalSystem_war/payment",
                method: "POST",
                contentType: "application/json",
                data: JSON.stringify(payOb),
                success: function (res) {
                    console.log("Customer saved");
                    swal("Success!", "You Are Successfully Registered!", "success");
                },
                error: function (ob) {
                    alert(ob.responseJSON.message);
                }
            });

        },
        error: function (ob) {
            alert(ob.responseJSON.message);
        }
    });


}

