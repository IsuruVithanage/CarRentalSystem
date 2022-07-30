function loadAllReq() {
    $("#mreqConfirmtbl").empty();
    for (var i of customerDB) {
        /*create a html row*/
        let row = `<tr><td>${i.getCustID()}</td><td>${i.getCustName()}</td><td>${i.getCustAddress()}</td><td>${i.getCustSalary()}</td></tr>`;
        /*select the table body and append the row */
        $("#custTableBody").append(row);
    }
}


function getPendingAllReq() {


}