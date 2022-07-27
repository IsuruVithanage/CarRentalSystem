$("#btnadminreg").click(function () {
    saveAdmin();
});




function genarateAdminID() {
    $.ajax({
        url: "http://localhost:8080/CarRentalSystem_war/admin/GenerateAdminID",
        method: "GET",
        success: function (resp) {
            console.log(resp.data);
            $("#adminID").text(resp.data);

        },
        error: function (ob) {
            alert(ob.responseJSON.message);
        }
    });


}

function saveAdmin() {
    var auserOb = {
        userID: $("#auserID").text(),
        userName: $("#auserName").val(),
        password: $("#apassword").val(),
        role: "Admin"

    }
    console.log($("#auserID").text());
    var adminOb = {
        adminID: $("#adminID").text(),
        name: $("#adminName").val(),
        email: $("#aemail").val(),
        contact: $("#adminContact").val(),
        user: auserOb
    }
    console.log(adminOb);

    $.ajax({
        url: "http://localhost:8080/CarRentalSystem_war/admin",
        method: "POST",
        contentType: "application/json",
        data: JSON.stringify(adminOb),
        success: function (res) {
            console.log("Admin saved");
            swal("Success!", "You Are Successfully Registered!", "success");
        },
        error: function (ob) {
            alert(ob.responseJSON.message);
        }
    });
}