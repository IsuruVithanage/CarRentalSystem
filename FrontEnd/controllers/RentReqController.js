$("#btnhserach").click(function () {
    gettingDateAndTime();
});

$("#btnBook").click(function () {
    addthevehicle();
    sendRentReq();
});

function genarateRentID() {
    $.ajax({
        url: "http://localhost:8080/CarRentalSystem_war/rentreq/GenerateRentReqID",
        method: "GET",
        success: function (resp) {
            $("#rentID").text(resp.data);
            var rentReq = new RentReq();
            rentReq.getrentID();

        },
        error: function (ob) {
            alert(ob.responseJSON.message);
        }
    });


}

function gettingDateAndTime() {
    reqOb.gettingDates($("#rentID").text(), $("#custAcID").text(), "Yes", $("#pickDate").val(), $("#pickTime").val(), $("#returnDate").val(), $("#returnTime").val());
    console.log(reqOb);
}

function addthevehicle() {
    reqOb.setVehicle($("#vId").text())
    console.log(reqOb);

}

function sendRentReq() {
    var cusOb = {
        custID: "C-001",
    }

    var driverOb = {
        driverID: "D-001",
    }

    var vehiclOb = {
        vehicleID: $("#vId").text(),
    }

    var rentOb = {
        rentID: reqOb.getrentID(),
        pickedDate: reqOb.getPickedDate(),
        pickedTime: reqOb.getPickedTime(),
        returnDate: reqOb.getReturnDate(),
        returnTime: reqOb.getReturnTime(),
        driverNeed: reqOb.getDriverNeed(),
        reqConfirm: "Pending",
        payment: "No",
        vehicle: vehiclOb,
        driver: null,
        customer: cusOb
    }

    $.ajax({
        url: "http://localhost:8080/CarRentalSystem_war/rentreq",
        method: "POST",
        contentType: "application/json",
        data: JSON.stringify(rentOb),
        success: function (res) {
            console.log(res.data);
            swal("Success!", "You Request has been sent!", "success");
        },
        error: function (ob) {
            alert(ob.responseJSON.message);
        }
    });

}