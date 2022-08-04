function completeMaintain() {
    $("#tblmainvehi").empty();
    $.ajax({
        url: "http://localhost:8080/CarRentalSystem_war/vehicle/select/Maintaining",
        method: "GET",
        success: function (resp) {
            for (const req of resp.data) {
                let row = `<tr><td class="nv">${req.vehicleID}</td><td>${req.brand}</td><td>${req.type}</td><td>${req.transmisson}</td><td>${req.fuelType}</td><td>${req.regNumber}</td><td><button class="mtbtn">Complete</button></td></tr>`;
                $("#tblmainvehi").append(row);
            }

            /*$(".tpbtn").click(function () {
                $("#payRentID").text($(this).closest("tr").find(".nr").text());
                $("#txtpdate").val($(this).closest("tr").find(".npd").text());
                $("#txtrdate").val($(this).closest("tr").find(".nrd").text());
                $("#fullTotal").text($(this).closest("tr").find(".nc").text());

                nr=$(this).closest("tr").find(".nv").text();
                nc=parseFloat($(this).closest("tr").find(".nc").text());

                $("#mconfirmPay").css("display", "none");
                $("#mPayment").css("display", "block");
                $("#txtpdate").prop('disabled', true);
                $("#txtrdate").prop('disabled', true);
                $(this).closest("tr").remove();
            });*/

        },
        error: function (ob) {
            alert(ob.responseJSON.message);
        }
    });

}