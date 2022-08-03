var xValues = ["January", "February", "March", "April", "June", "July", "August","September","October","November","December"];
var a=0;
getIncome("08");
var yValues = [50000, 60000, 30000, 70000, 95000, 47000, a, 11, 14, 14, 15];

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


function getIncome(month) {
    $.ajax({
        url: "http://localhost:8080/CarRentalSystem_war/payment",
        method: "GET",
        success: function (resp) {
            var d = new Date();
            var output = d.getFullYear() + '-' + month + '-';
            var tot=0;
            for (const respElement of resp.data) {
                var str=respElement.date;
                console.log(str.indexOf(output));
                if (str.indexOf(output) >= 0){
                    tot=tot+parseFloat(respElement.price);
                }

            }
            //console.log(tot);
            a=tot;

        },
        error: function (ob) {
            alert(ob.responseJSON.message);
        }
    });

}