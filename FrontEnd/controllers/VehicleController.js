$("#btnVehiclereg").click(function () {
    saveVehicle();


});


function genarateVehicleID() {
    $.ajax({
        url: "http://localhost:8080/CarRentalSystem_war/vehicle/GenerateVehicleID",
        method: "GET",
        success: function (resp) {
            console.log(resp.data);
            $("#vehicleID").text(resp.data);

        },
        error: function (ob) {
            alert(ob.responseJSON.message);
        }
    });


}

function getAllVehicle() {
    $.ajax({
        url: "http://localhost:8080/CarRentalSystem_war/vehicle",
        method: "GET",
        success: function (resp) {
            for (const argument of resp.data) {
                const newDiv = $('<div class="container" style=" border-radius: 10px;">\n' +
                    '                <div class="row">\n' +
                    '                    <div class="col-5">\n' +
                    '                        <img src="assets/images/c1.png" alt="" width="200" height="170"\n' +
                    '                             style="padding-top: 20px; padding-left: 10px">\n' +
                    '                    </div>\n' +
                    '                    <div class="col-7" style="position: relative">\n' +
                    '                        <h1 style="font-size: 30px; text-decoration: none; padding-top: 15px">'+argument.brand + " " + argument.type+'</h1>\n' +
                    '                        <p style="padding-top: 10px; padding-left: 20px; font-size: 20px;">'+argument.passengerNo + " Seats"+'</p>\n' +
                    '                        <p style="position: absolute; top: 70px; font-size: 20px; left: 170px">'+argument.fuelType+'</p>\n' +
                    '                        <p style="position: absolute; top: 110px; padding-left: 20px; font-size: 20px;">'+argument.transmisson+'</p>\n' +
                    '                        <p style="position: absolute; top: 110px; left: 170px; font-size: 20px; color: red">\n' +
                    '                            '+argument.availability+'</p>\n' +
                    '                    </div>\n' +
                    '                </div>\n' +
                    '            </div>');

                $(".vehicleContainer").append(newDiv);
            }
        },
        error: function (ob) {
            alert(ob.responseJSON.message);
        }
    });
}


function saveVehicle() {
    var vehicleOb = {
        vehicleID: $("#vehicleID").text(),
        brand: $("#brand").val(),
        type: $('#vtype').find(":selected").text(),
        passengerNo: $("#passengerNo").val(),
        transmisson: $('#trans').find(":selected").text(),
        fuelType: $('#futype').find(":selected").text(),
        color: $("#color").val(),
        regNumber: $("#regNo").val(),
        extraMilage: $("#extramile").val(),
        dailyRent: $("#dailyrent").val(),
        monthlyRent: $("#monthlyRent").val(),
        extraMilagePrice: $("#FreeMilage").val(),
        availability: "Available"
    }

    $.ajax({
        url: "http://localhost:8080/CarRentalSystem_war/vehicle",
        method: "POST",
        contentType: "application/json",
        data: JSON.stringify(vehicleOb),
        success: function (res) {
            console.log("Customer saved");
            swal("Success!", "You Are Successfully Registered!", "success");
        },
        error: function (ob) {
            alert(ob.responseJSON.message);
        }
    });
}