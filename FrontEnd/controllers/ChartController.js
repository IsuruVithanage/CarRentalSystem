


function getIncome() {
    $.ajax({
        url: "http://localhost:8080/CarRentalSystem_war/payment",
        method: "GET",
        success: function (resp) {
            var d = new Date();
            var ma = d.getFullYear() + '-' + "08" + '-';
            var ms = d.getFullYear() + '-' + "09" + '-';
            var mo = d.getFullYear() + '-' + "10" + '-';
            var mn = d.getFullYear() + '-' + "11" + '-';
            var md = d.getFullYear() + '-' + "12" + '-';
            var totA=0;
            var totS=0;
            var totO=0;
            var totN=0;
            var totD=0;
            for (const respElement of resp.data) {
                var str=respElement.date;
                if (str.indexOf(ma) >= 0){
                    totA=totA+parseFloat(respElement.price);
                }
                if (str.indexOf(ms) >= 0){
                    totS=totS+parseFloat(respElement.price);
                }
                if (str.indexOf(mo) >= 0){
                    totO=totO+parseFloat(respElement.price);
                }
                if (str.indexOf(mn) >= 0){
                    totN=totN+parseFloat(respElement.price);
                }
                if (str.indexOf(md) >= 0){
                    totD=totD+parseFloat(respElement.price);
                }

            }
            var xValues = ["January", "February", "March", "April", "June", "July", "August","September","October","November","December"];
            var yValues = [50000, 60000, 30000, 70000, 95000, 47000, totA, totS, totO, totN, totD];

            new Chart("myChart", {
                type: "line",
                data: {
                    labels: xValues,
                    datasets: [{
                        fill: false,
                        lineTension: 0,
                        backgroundColor: "rgb(255,140,0)",
                        borderColor: "rgba(0,0,255,0.1)",
                        data: yValues
                    }]
                },
                options: {
                    legend: {display: false},
                    scales: {
                        yAxes: [{ticks: {min: 8000, max: 150000}}],
                    }
                }
            });

        },
        error: function (ob) {
            alert(ob.responseJSON.message);
        }
    });

}