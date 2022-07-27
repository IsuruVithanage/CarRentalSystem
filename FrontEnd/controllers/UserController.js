function genarateUserID() {
    $.ajax({
        url: "http://localhost:8080/CarRentalSystem_war/user/GenerateUserID",
        method: "GET",
        success: function (resp) {
            console.log(resp.data);
            $("#userID").text(resp.data);
            $("#auserID").text(resp.data);
            $("#duserID").text(resp.data);

        },
        error: function (ob) {
            alert(ob.responseJSON.message);
        }
    });


}