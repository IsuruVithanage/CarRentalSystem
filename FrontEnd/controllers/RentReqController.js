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
    var cost;
    if ($('#checkday').prop('checked')){
        cost=parseFloat($('#dcost').text());
        var pd=parseInt(reqOb.getPickedDate().split("-")[2]);
        var rd=parseInt(reqOb.getReturnDate().split("-")[2]);
        cost=cost*(rd-(pd-1));


    }else {
        cost=parseFloat($('#mcost').text());
        var pm=parseInt(reqOb.getPickedDate().split("-")[1]);
        var rm=parseInt(reqOb.getReturnDate().split("-")[1]);
        cost=cost*(rm-(pm-1));
    }

    var dneed;
    if ($('#dneed').prop('checked')){
        dneed="Yes"
    }else {
        dneed="No"
    }


    var cusOb = {
        custID: $("#custAcID").text(),
    }

    var vehiclOb = {
        vehicleID: $("#vId").text(),
    }

    addvehiUnavailable($("#vId").text());

    var rentOb = {
        rentID: reqOb.getrentID(),
        pickedDate: reqOb.getPickedDate(),
        pickedTime: reqOb.getPickedTime(),
        returnDate: reqOb.getReturnDate(),
        returnTime: reqOb.getReturnTime(),
        driverNeed: dneed,
        reqConfirm: "Pending",
        payment: "No",
        cost: cost,
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
            console.log(rentOb);
            swal("Success!", "You Request has been sent!", "success");
        },
        error: function (ob) {
            alert(ob.responseJSON.message);
        }
    });

}

function addvehiUnavailable(id) {
    $.ajax({
        url: "http://localhost:8080/CarRentalSystem_war/vehicle/unavailable/" + id,
        method: "PUT",
        contentType: "application/json", //You should state request's content type using MIME types
        success: function (res) {
            //swal("Success!", "You Request has been sent!", "success");
        },
        error: function (ob) {
            alert(ob.responseJSON.message);
        }
    });

}