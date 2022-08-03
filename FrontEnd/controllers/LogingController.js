$("#btnhlog").click(function () {
    logIn();


});


function logIn() {
    if ($('#checkCust').prop('checked')){
        $("#ml").css("display", "none");
        $("#mh").css("display", "block");
    }else if ($('#checkAdmin').prop('checked')){
        $("#ml").css("display", "none");
        $("#ma").css("display", "block");
    }

}