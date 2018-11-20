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

    var email = $("#email").val();
    var senha = $("#password").val();

    firebase.auth().createUserWithEmailAndPassword(email, senha).then(userData => { 
        //Sucesso - tratar sucesso aqui 
    }) 
    .catch(error => { 
        // Erro - tratar erros aqui

         // Handle Errors here.
         var errorCode = error.code;
         var errorMessage = error.message;
         // [START_EXCLUDE]
         if (errorCode === 'auth/wrong-password') {
             $('#error').css("display", "");
             $('#error').html("Senha Incorreta");
         } 

         if (errorCode === 'auth/user-not-found') {
             $('#error').css("display", "");
             $('#error').html("Usuário não cadastrado no sistema");
         }
     })

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


$('#txtEmail').focus(function () {
    $('#erroCadastrar').css("display", "none");
});

$('#senha').focus(function () {
    $('#erroCadastrar').css("display", "none");
});

$('#confirmacaoSenha').focus(function () {
    $('#erroCadastrar').css("display", "none");
});



$("#lnkEsqueciSenha").click(function () {
    document.getElementById("overlay").style.display = "block";
    document.getElementById("divEsqueciSenha").style.display = "block";

});

$("#lnkEsqueciEmail").click(function () {
    document.getElementById("overlay").style.display = "block";
    document.getElementById("divEsqueciEmail").style.display = "block";
});


$("#btnCadastrar").click(function () {

    if ($("#txtEmail").val() == "") {
        $('#erroCadastrar').css("display", "");
        $('#erroCadastrar').html("O campo e-mail é obrigatório");
        return false;
    }

    var email = $("#txtEmail").val();

    if (validaEmail(email)) {
        $('#erroCadastrar').css("display", "none");
    } else {
        $('#erroCadastrar').css("display", "");
        $('#erroCadastrar').html("Por favor, digite um e-mail válido");
        return false;
    }

    if ($("#senha").val() == "") {
        $('#erroCadastrar').css("display", "");
        $('#erroCadastrar').html("O campo senha é obrigatório");
        return false;
    } else {
        if ($('#senha').val().length < 6) {
            $('#erroCadastrar').css("display", "");
            $('#erroCadastrar').html("O campo senha deve ser pelo menos 6 caracteres");
            return false;
        }
    }

    if ($("#confirmacaoSenha").val() == "") {
        $('#erroCadastrar').css("display", "");
        $('#erroCadastrar').html("O campo confirmacao de senha é obrigatório");
        return false;
    }

    if ($("#senha").val() != $("#confirmacaoSenha").val()) {
        $('#erroCadastrar').css("display", "");
        $('#erroCadastrar').html("As senhas são diferentes");
        return false;
    }

    var email = $("#txtEmail").val();
    var senha = $("#senha").val();

    firebase.auth().createUserWithEmailAndPassword(email, senha).then(userData => {
        // success - do stuff with userData
    }).catch(error => {
        // do stuff with error
        // Handle Errors here.

        var errorCode = error.code;
        var errorMessage = error.message;
        // [START_EXCLUDE]
        if (errorCode == 'auth/weak-password') {
            alert('The password is too weak.');
        } else {
            alert(errorMessage);
        }
    })
});





















