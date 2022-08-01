function getPendingAllReq() {
    $("#mreqConfirmtbl").empty();
    $.ajax({
        url: "http://localhost:8080/CarRentalSystem_war/rentreq/pendingreq/Pending",
        method: "GET",
        success: function (resp) {
            for (const req of resp.data) {


                let row = `<tr><td class="nr">${req.rentID}</td><td>${req.customer.custID}</td><td>${req.pickedDate}</td><td>${req.pickedTime}</td><td>${req.returnDate}</td><td>${req.returnTime}</td><td>${req.vehicle.vehicleID}</td><td>${req.driverNeed}</td><td><button class="tcbtn">Confirm</button></td><td><button class="tdbtn">Deny</button></td></tr>`;

                $("#mreqConfirmtbl").append(row);
            }

            $(".tcbtn").click(function () {
                confirmReq($(this).closest("tr").find(".nr").text());
                $(this).closest("tr").remove();
            });

            $(".tdbtn").click(function () {
                swal("Write something here:", {
                    content: "input",
                })
                    .then((value) => {
                        denyReqMessage($(this).closest("tr").find(".nr").text(), value);
                        denyReq($(this).closest("tr").find(".nr").text());
                    });

                $(this).closest("tr").remove();

            });

        },
        error: function (ob) {
            alert(ob.responseJSON.message);
        }
    });


}

function confirmReq(rentID) {
    $.ajax({
        url: "http://localhost:8080/CarRentalSystem_war/rentreq/" + "?id=" + rentID,
        method: "PUT",
        contentType: "application/json", //You should state request's content type using MIME types
        success: function (res) {
            swal("Success!", "You Request has been sent!", "success");
        },
        error: function (ob) {
            alert(ob.responseJSON.message);
        }
    });

}

function denyReq(rentID) {
    $.ajax({
        url: "http://localhost:8080/CarRentalSystem_war/rentreq/denyReq/" + rentID,
        method: "PUT",
        contentType: "application/json", //You should state request's content type using MIME types
        success: function (res) {
            swal("Success!", "You Request has been sent!", "success");
        },
        error: function (ob) {
            alert(ob.responseJSON.message);
        }
    });

}


function denyReqMessage(rentID, message) {
    var denyReqOb = {
        denyReqID: rentID,
        message: message
    }

    $.ajax({
        url: "http://localhost:8080/CarRentalSystem_war/reqdeny",
        method: "POST",
        contentType: "application/json",
        data: JSON.stringify(denyReqOb), //You should state request's content type using MIME types
        success: function (res) {
            swal("Success!", "You Request has been denied!", "success");
        },
        error: function (ob) {
            alert(ob.responseJSON.message);
        }
    });
}


function getConfirmedgAllReq() {
    $("#tblreqpay").empty();
    $.ajax({
        url: "http://localhost:8080/CarRentalSystem_war/rentreq/pendingreq/Confirmed",
        method: "GET",
        success: function (resp) {
            for (const req of resp.data) {
                let row = `<tr><td class="nr">${req.rentID}</td><td>${req.customer.custID}</td><td class="npd">${req.pickedDate}</td><td>${req.pickedTime}</td><td class="nrd">${req.returnDate}</td><td>${req.returnTime}</td><td class="nv">${req.vehicle.vehicleID}</td><td class="nc">${req.cost}</td><td><button class="tpbtn">Payment</button></td></tr>`;
                $("#tblreqpay").append(row);
            }

            $(".tpbtn").click(function () {
                $("#payRentID").text($(this).closest("tr").find(".nr").text());
                $("#txtpdate").val($(this).closest("tr").find(".npd").text());
                $("#txtrdate").val($(this).closest("tr").find(".nrd").text());
                $("#fullTotal").text($(this).closest("tr").find(".nc").text());
                calculateExtraMilage($(this).closest("tr").find(".nv").text())
                $("#mconfirmPay").css("display", "none");
                $("#mPayment").css("display", "block");
                $("#txtpdate").prop('disabled', true);
                $(this).closest("tr").remove();
            });

        },
        error: function (ob) {
            alert(ob.responseJSON.message);
        }
    });

}

function calculateExtraMilage(id) {
    $.ajax({
        url: "http://localhost:8080/CarRentalSystem_war/vehicle/" + id,
        method: "GET",
        success: function (resp) {
            if (resp.data.dailyRent===$("#mpay").text()){
                console.log("go");
            }else {
                console.log(resp.data.dailyRent);
            }


        },
        error: function (ob) {
            alert(ob.responseJSON.message);
        }
    });

}
