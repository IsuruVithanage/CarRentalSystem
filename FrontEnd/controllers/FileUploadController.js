$("#btnUpload").click(function () {
    saveimgOne();
    saveimgTwo();
    saveimgThree();
    saveimgFive();
    saveimgFour();
    saveimg($("#vehicleID").text());

});

function saveimgOne() {
    var data = new FormData();
    let file = $("#file1")[0].files[0];
    let fileName = $("#file1")[0].files[0].name;
    data.append("myFile", file, fileName);

    $.ajax({
        url: "http://localhost:8080/CarRentalSystem_war/upload",
        method: 'post',
        async: true,
        contentType: false,
        processData: false,
        data: data,
        success: function (resp) {

        },
        error: function (err) {
            console.log(err);
        }
    });

}

function saveimgTwo() {
    var data = new FormData();
    let file = $("#file2")[0].files[0];
    let fileName = $("#file2")[0].files[0].name;
    data.append("myFile", file, fileName);

    $.ajax({
        url: "http://localhost:8080/CarRentalSystem_war/upload",
        method: 'post',
        async: true,
        contentType: false,
        processData: false,
        data: data,
        success: function (resp) {


        },
        error: function (err) {
            console.log(err);
        }
    });

}

function saveimgThree() {
    var data = new FormData();
    let file = $("#file3")[0].files[0];
    let fileName = $("#file3")[0].files[0].name;
    data.append("myFile", file, fileName);

    $.ajax({
        url: "http://localhost:8080/CarRentalSystem_war/upload",
        method: 'post',
        async: true,
        contentType: false,
        processData: false,
        data: data,
        success: function (resp) {


        },
        error: function (err) {
            console.log(err);
        }
    });

}

function saveimgFour() {
    var data = new FormData();
    let file = $("#file4")[0].files[0];
    let fileName = $("#file4")[0].files[0].name;
    data.append("myFile", file, fileName);

    $.ajax({
        url: "http://localhost:8080/CarRentalSystem_war/upload",
        method: 'post',
        async: true,
        contentType: false,
        processData: false,
        data: data,
        success: function (resp) {


        },
        error: function (err) {
            console.log(err);
        }
    });

}

function saveimgFive() {
    var data = new FormData();
    let file = $("#file5")[0].files[0];
    let fileName = $("#file5")[0].files[0].name;
    data.append("myFile", file, fileName);

    $.ajax({
        url: "http://localhost:8080/CarRentalSystem_war/upload",
        method: 'post',
        async: true,
        contentType: false,
        processData: false,
        data: data,
        success: function (resp) {


        },
        error: function (err) {
            console.log(err);
        }
    });

}


function saveimg(id) {
    $.ajax({
        url: "http://localhost:8080/CarRentalSystem_war/upload/" + id,
        method: "PUT",
        contentType: "application/json", //You should state request's content type using MIME types
        success: function (res) {
            swal("Success!", "You Request has been sent!", "success");
        },
        error: function (ob) {
            alert(ob.responseJSON.message);
        }
    });

}

function getvehi(id) {
    var baseurl="http://localhost:8080/CarRentalSystem_war/";
    $.ajax({
        url: "http://localhost:8080/CarRentalSystem_war/vehicle/" + id,
        method: "GET",
        success: function (resp) {
            $("#ml").css({
                "background": `url(${baseurl+resp.data.imgOne})`,
                "background-size": "cover",
            });


        },
        error: function (ob) {
            alert(ob.responseJSON.message);
        }
    });

}