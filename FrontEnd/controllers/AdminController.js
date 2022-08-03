$("#btnadminreg").click(function () {
    saveAdmin();
});


function setUserCount(){
    $.ajax({
        url: "http://localhost:8080/CarRentalSystem_war/user/userCount",
        method: "GET",
        success: function (resp) {
            var cont=resp.data;
            if (cont<10){
                cont="00"+cont;
            }else if (cont<100){
                cont="0"+cont;
            }
            $("#userCount").text(cont);

        },
        error: function (ob) {
            alert(ob.responseJSON.message);
        }
    });
}

function setDriverCount(){
    $.ajax({
        url: "http://localhost:8080/CarRentalSystem_war/driver/driverCount",
        method: "GET",
        success: function (resp) {
            var cont=resp.data;
            if (cont<10){
                cont="00"+cont;
            }else if (cont<100){
                cont="0"+cont;
            }
            $("#drivercount").text(cont);

        },
        error: function (ob) {
            alert(ob.responseJSON.message);
        }
    });
}

function setVhicleCount(){
    $.ajax({
        url: "http://localhost:8080/CarRentalSystem_war/vehicle/select/Available",
        method: "GET",
        success: function (resp) {
            var cont=resp.data.length;
            if (cont<10){
                cont="00"+cont;
            }else if (cont<100){
                cont="0"+cont;
            }
            $("#vehiCount").text(cont);

        },
        error: function (ob) {
            alert(ob.responseJSON.message);
        }
    });
}

function setReqCount(){
    $.ajax({
        url: "http://localhost:8080/CarRentalSystem_war/rentreq/pendingreq/Pending",
        method: "GET",
        success: function (resp) {
            var cont=resp.data.length;
            if (cont<10){
                cont="00"+cont;
            }else if (cont<100){
                cont="0"+cont;
            }
            $("#totBooking").text(cont);

        },
        error: function (ob) {
            alert(ob.responseJSON.message);
        }
    });
}

function setPaymentReqCount(){
    $.ajax({
        url: "http://localhost:8080/CarRentalSystem_war/rentreq/payreq",
        method: "GET",
        success: function (resp) {
            var cont=resp.data.length;
            if (cont<10){
                cont="00"+cont;
            }else if (cont<100){
                cont="0"+cont;
            }
            $("#paymentReq").text(cont);

        },
        error: function (ob) {
            alert(ob.responseJSON.message);
        }
    });
}

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