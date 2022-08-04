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

            $(".mtbtn").click(function () {
                setVehicleAvailable($(this).closest("tr").find(".nv").text())
                $(this).closest("tr").remove();
            });

        },
        error: function (ob) {
            alert(ob.responseJSON.message);
        }
    });

}

