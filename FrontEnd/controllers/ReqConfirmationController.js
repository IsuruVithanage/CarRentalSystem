

function getPendingAllReq() {
    $("#mreqConfirmtbl").empty();
    $.ajax({
        url: "http://localhost:8080/CarRentalSystem_war/rentreq/pendingreq/Pending",
        method: "GET",
        success: function (resp) {
            for (const req of resp.data) {
                $(".tcbtn").click(function () {
                    confirmReq(req.rentID);
                    $(this).remove();
                });

                $(".tdbtn").click(function () {
                    denyReq(req.rentID);
                    let rowIndex = this.parentElement.rowIndex;
                    $("#mreqConfirmtbl").deleteRow(rowIndex);

                });

                let row = `<tr><td>${req.rentID}</td><td>${req.customer.custID}</td><td>${req.pickedDate}</td><td>${req.pickedTime}</td><td>${req.returnDate}</td><td>${req.returnTime}</td><td>${req.vehicle.vehicleID}</td><td>${req.driverNeed}</td><td><button class="tcbtn">Confirm</button></td><td><button class="tdbtn">Deny</button></td></tr>`;
                $("#mreqConfirmtbl").append(row);
            }
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

