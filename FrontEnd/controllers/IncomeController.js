function getDailyPayment() {
    $.ajax({
        url: "http://localhost:8080/CarRentalSystem_war/payment",
        method: "GET",
        success: function (resp) {
            var d = new Date();
            var month = d.getMonth()+1;
            var day = d.getDate();
            var output = d.getFullYear() + '-' +
                (month<10 ? '0' : '') + month + '-' +
                (day<10 ? '0' : '') + day;
            var tot=0;
            for (const respElement of resp.data) {
                if (respElement.date===output){
                    tot=tot+parseFloat(respElement.price);
                }

            }
            $("#txtdaily").text(tot);

        },
        error: function (ob) {
            alert(ob.responseJSON.message);
        }
    });

}

function getMonthlyPayment() {
    $.ajax({
        url: "http://localhost:8080/CarRentalSystem_war/payment",
        method: "GET",
        success: function (resp) {
            var d = new Date();
            var month = d.getMonth()+1;
            var output = d.getFullYear() + '-' +
                (month<10 ? '0' : '') + month + '-';
            var tot=0;
            for (const respElement of resp.data) {
                var str=respElement.date;
                console.log(str.indexOf(output));
                if (str.indexOf(output) >= 0){
                    tot=tot+parseFloat(respElement.price);
                }

            }
            $("#txtmonthly").text(tot);

        },
        error: function (ob) {
            alert(ob.responseJSON.message);
        }
    });

}

function getYearlyPayment() {
    $.ajax({
        url: "http://localhost:8080/CarRentalSystem_war/payment",
        method: "GET",
        success: function (resp) {
            var d = new Date();
            var output = d.getFullYear() + '-' ;
            var tot=0;
            for (const respElement of resp.data) {
                var str=respElement.date;
                console.log(str.indexOf(output));
                if (str.indexOf(output) >= 0){
                    tot=tot+parseFloat(respElement.price);
                }

            }
            $("#txtYear").text(tot);

        },
        error: function (ob) {
            alert(ob.responseJSON.message);
        }
    });

}