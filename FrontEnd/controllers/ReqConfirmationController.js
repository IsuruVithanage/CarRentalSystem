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
                let row = `<tr><td class="nr">${req.rentID}</td><td>${req.customer.custID}</td><td>${req.pickedDate}</td><td>${req.pickedTime}</td><td>${req.returnDate}</td><td>${req.returnTime}</td><td>${req.vehicle.vehicleID}</td><td>${req.driverNeed}</td><td><button class="tcbtn">Payment</button></td></tr>`;
                $("#tblreqpay").append(row);
            }

        },
        error: function (ob) {
            alert(ob.responseJSON.message);
        }
    });

}
