$("#btnhlog").click(function () {
    logIn();


});


function logIn() {
    if ($('#checkCust').prop('checked')){
        checkUser();
        $("#ml").css("display", "none");
        $("#mh").css("display", "block");



    }else if ($('#checkAdmin').prop('checked')){
        loadAdminPage();
        $("#ml").css("display", "none");
        $("#mb").css("display", "none");
        $("#ma").css("display", "block");
    }

}

$('#checkCust').click(function () {
    $('#checkAdmin').prop('checked', false);

});

$('#checkAdmin').click(function () {
    $('#checkCust').prop('checked', false);

});

function checkUser() {
    var id=$("#userName").val();
    console.log(id);
    var password=$("#password").val();
    $.ajax({
        url: "http://localhost:8080/CarRentalSystem_war/user",
        method: "GET",
        success: function (resp) {
            for (const u of resp.data) {
                if (id===u.userID){
                    console.log(u.userID);
                    getCuts(u.userID);

                }

            }


        },
        error: function (ob) {
            alert(ob.responseJSON.message);
        }
    });

}

function getCuts(uid) {
    $.ajax({
        url: "http://localhost:8080/CarRentalSystem_war/customer/byUser/" + uid,
        method: "GET",
        success: function (resp) {
            for (const u of resp.data) {
                console.log(u.custID);
                $("#custAcID").text(u.custID);
            }
        },
        error: function (ob) {
            alert(ob.responseJSON.message);
        }
    });

}

