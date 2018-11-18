$("#btnLogin").click(function () {
    
    if ($("#email").val() == "") {
        $('#error').css("display", "");
        $('#error').html("O campo e-mail é obrigatório");
        return false;
    }

    if ($("#password").val() == "") {
        $('#error').css("display", "");
        $('#error').html("O campo senha é obrigatório");
        return false;
    }

    var email = $("#email").val();

    if (validaEmail(email)) {
        $('#error').css("display", "none");
    } else {
        $('#error').css("display", "");
        $('#error').html("Por favor, digite um e-mail válido");
        return false;
    }
});

function validaEmail(email) {
    var regex = /^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/i;
    return regex.test(email);
}

$('#email').focus(function () {
    $('#error').css("display", "none");
});

$('#password').focus(function () {
    $('#error').css("display", "none");
});


$("#lnkEsqueciSenha").click(function(){
    document.getElementById("overlay").style.display = "block";
    document.getElementById("divEsqueciSenha").style.display = "block";
    
});

$("#lnkEsqueciEmail").click(function(){
    document.getElementById("overlay").style.display = "block";
    document.getElementById("divEsqueciEmail").style.display = "block";
});