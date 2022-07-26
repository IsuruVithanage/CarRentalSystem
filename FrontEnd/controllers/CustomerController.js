$("#btnhreg").click(function () {
    saveCustomer();
});


function genarateCustID() {
    $.ajax({
        url: "http://localhost:8080/CarRentalSystem_war/customer/GenerateCustID",
        method: "GET",
        success: function (resp) {
            console.log(resp.data);
            $("#custID").text(resp.data);

        },
        error: function (ob) {
            alert(ob.responseJSON.message);
        }
    });


}

function saveCustomer() {
    var userOb = {
        userID: $("#userID").text(),
        userName: $("#ruserName").val(),
        password: $("#rpassword").val(),
        role: "Customer"

    }
    var cusOb = {
        custID: $("#custID").text(),
        name: $("#rcustName").val(),
        address: $("#rcustAddress").val(),
        email: $("#rcustEmail").val(),
        licenseNo: $("#rcustlicen").val(),
        nic: $("#rcuntNic").val(),
        contact: $("#rcustContact").val(),
        user: userOb
    }

    $.ajax({
        url: "http://localhost:8080/CarRentalSystem_war/customer",
        method: "POST",
        contentType: "application/json",
        data: JSON.stringify(cusOb),
        success: function (res) {
            console.log("Customer saved");
            swal("Success!", "You Are Successfully Registered!", "success");
            genarateCustID();
            genarateUserID();
        },
        error: function (ob) {
            alert(ob.responseJSON.message);
        }
    });
}

//Search Customer
function searchCustomer(custID) {

    $.ajax({
        url: "http://localhost:8080/CarRentalSystem_war/customer/" + custID,
        method: "GET",
        success: function (res) {
            return res.data;
        },
        error: function (ob) {
            alert(ob.responseJSON.message);
        }
    });

}

function loadReqDetails(id) {
    $.ajax({
        url: "http://localhost:8080/CarRentalSystem_war/reqdeny/" + id,
        method: "GET",
        success: function (res) {
            for (const req of res.data) {
                let row = `<tr><td class="nr">${req.rentID}</td><td>${req.message}</td></tr>`;
                $("#custreqtblbody").append(row);
            }
        },
        error: function (ob) {
            alert(ob.responseJSON.message);
        }
    });

}