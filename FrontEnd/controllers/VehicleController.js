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