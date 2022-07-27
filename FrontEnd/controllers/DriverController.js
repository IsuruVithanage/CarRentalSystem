$("#btndriverreg").click(function () {
    saveDriver();


});




function genarateDriverID() {
    $.ajax({
        url: "http://localhost:8080/CarRentalSystem_war/driver/GenerateDriverID",
        method: "GET",
        success: function (resp) {
            console.log(resp.data);
            $("#driverID").text(resp.data);

        },
        error: function (ob) {
            alert(ob.responseJSON.message);
        }
    });


}

function saveDriver() {
    var userOb = {
        userID: $("#duserID").text(),
        userName: $("#duserName").val(),
        password: $("#dpassword").val(),
        role: "Driver"

    }
    var cusOb = {
        driverID: $("#driverID").text(),
        name: $("#driverName").val(),
        address: $("#driverAddress").val(),
        nic: $("#driverNic").val(),
        licenseNo: $("#driverlicen").val(),
        contact: $("#dContact").val(),
        availability: "Available",
        user: userOb
    }

    $.ajax({
        url: "http://localhost:8080/CarRentalSystem_war/driver",
        method: "POST",
        contentType: "application/json",
        data: JSON.stringify(cusOb),
        success: function (res) {
            console.log("Customer saved");
            swal("Success!", "You Are Successfully Registered!", "success");
        },
        error: function (ob) {
            alert(ob.responseJSON.message);
        }
    });
}