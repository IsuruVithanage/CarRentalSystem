/*function loadAllReq() {
    $("#mreqConfirmtbl").empty();
    for (var i of customerDB) {
        /!*create a html row*!/
        let row = `<tr><td>${i.getCustID()}</td><td>${i.getCustName()}</td><td>${i.getCustAddress()}</td><td>${i.getCustSalary()}</td></tr>`;
        /!*select the table body and append the row *!/
        $("#custTableBody").append(row);
    }
}*/


function getPendingAllReq() {
    $("#mreqConfirmtbl").empty();
    $.ajax({
        url: "http://localhost:8080/CarRentalSystem_war/rentreq/pendingreq/Pending",
        method: "GET",
        success: function (resp) {

            for (const req of resp.data) {
                let row = `<tr><td>${req.rentID}</td><td>${req.pickedDate}</td><td>${req.pickedTime}</td><td>${req.returnDate}</td><td>${req.returnTime}</td><td>${req.vehicle.vehicleID}</td><td>${req.driverNeed}</td><td><button class="tcbtn">Confirm</button></td><td><button class="tdbtn">Deny</button></td></tr>`;
                $("#mreqConfirmtbl").append(row);
            }
        },
        error: function (ob) {
            alert(ob.responseJSON.message);
        }
    });



}