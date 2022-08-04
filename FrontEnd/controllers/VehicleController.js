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
                const newDiv = $('<div class="container" style="margin: 0 1em 1em 0; border-radius: 10px;">\n' +
                    '                <div class="row">\n' +
                    '                    <div class="col-5">\n' +
                    '                        <img src='+argument.imgOne+' alt="" width="200" height="170"\n' +
                    '                             style="padding-top: 20px; padding-left: 10px">\n' +
                    '                    </div>\n' +
                    '                    <div class="col-7" style="position: relative">\n' +
                    '                        <h1 style="font-size: 30px; text-decoration: none; padding-top: 15px">'+argument.brand + " " + argument.type+'</h1>\n' +
                    '                        <h1 class="br" style="position: absolute; font-size: 20px; left: 195px; top: 23px">'+argument.vehicleID+'</h1>\n' +
                    '                        <p style="padding-top: 10px; padding-left: 20px; font-size: 20px;">'+argument.passengerNo + " Seats"+'</p>\n' +
                    '                        <p style="position: absolute; top: 70px; font-size: 20px; left: 170px">'+argument.fuelType+'</p>\n' +
                    '                        <p style="position: absolute; top: 110px; padding-left: 20px; font-size: 20px;">'+argument.transmisson+'</p>\n' +
                    '                        <p style="position: absolute; top: 110px; left: 170px; font-size: 20px; color: red">\n' +
                    '                            '+argument.availability+'</p>\n' +
                    '                    </div>\n' +
                    '                </div>\n' +
                    '            </div>');

                newDiv.click(function () {
                    displayVehiDetails($(this).find(".br").text());

                })

                $(".vehicleContainer").append(newDiv);
            }
        },
        error: function (ob) {
            alert(ob.responseJSON.message);
        }
    });
}

function displayVehiDetails(id) {
    console.log(id);
    $.ajax({
        url: "http://localhost:8080/CarRentalSystem_war/vehicle/" + id,
        method: "GET",
        success: function (resp) {
            $("#mcar").css("display", "block");
            $("#mb").css("display", "none");


            $("#vId").text(resp.data.vehicleID);
            $("#txtbrand").text(resp.data.brand);
            $("#txttrans").text(resp.data.transmisson);
            $("#txtcolor").text(resp.data.color);
            $("#txtexcost").text(resp.data.extraMilagePrice);
            $("#txtfmday").text(resp.data.dailyMilage);
            $("#txtfmmonth").text(resp.data.monthlyMilage);
            $("#txtm").text(resp.data.type);
            $("#txtfuel").text(resp.data.fuelType);
            $("#txtpassen").text(resp.data.passengerNo);
            $("#mcost").text(resp.data.monthlyRent);
            $("#dcost").text(resp.data.dailyRent);
            $("#carAvaila").text(resp.data.availability);


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