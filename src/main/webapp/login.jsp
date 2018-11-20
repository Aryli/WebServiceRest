<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Entrar/Cadastro - Escravometro</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" type="text/css" media="screen" href="css/main.css" />
    <!-- Compiled and minified CSS -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">

    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU"
        crossorigin="anonymous">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
        crossorigin="anonymous">

</head>

<body>
    <header id="mainHeader">
        <div class="container" id="mainLogo">
            <div class="row">
                <div class="col-md-4 col-xs-8">
                    <a href="index.jsp">
                        <img class="img-fluid" src="images/logo.png" />
                    </a>
                </div>
                <div id="navegationBasic" class="d-none d-sm-block">
                    <a href="about.jsp">Sobre o Escravometro</a>
                </div>
            </div>
        </div>
    </header>

    <div id="userLoginRegister" class="container-fluid">
        <div class="container">
            <div class="row">
                <div class="col-md-6" id="register">
                    <h1 class="title">Não tem cadastro? Siga as instruções e comece</h1>
                    <p class="description">ligula nostra egestas pretium, maecenas vel curabitur sodales bibendum
                        laoreet adipiscing placerat semper</p>

                    <hr>

                    <form action="">
                        <div class="input-field col s12">
                            <input type="text" id="txtEmail" name="email">
                            <label for="txtEmail">Digite o seu email</label>
                        </div>

                        <div class="input-field col s12">
                            <input type="password" id="senha">
                            <label for="senha">Digite a sua senha</label>
                        </div>

                        <div class="input-field col s12">
                                <input type="password" id="confirmacaoSenha">
                                <label for="confirmacaoSenha">Digite a confirmacao da sua senha</label>
                            </div>

                        <div class="divSubmit input-field col s12">
                            <div id="erroCadastrar" style="display: none" class="error"></div>
                            <button type="submit" id="btnCadastrar"> Cadastrar</button>
                        </div>

                    </form>
                </div>
                <div class="col-md-6" id="login">
                    <div class="headerLogin">
                        <h1 class="title">Bem vindo de volta</h1>
                        <p class="description">ligula nostra egestas pretium, maecenas vel curabitur sodales bibendum
                            laoreet adipiscing placerat
                            semper
                        </p>
                        <hr>
                    </div>


                    <form action="">
                        <div class="input-field col s12">
                            <input type="text" id="email" name="email">
                            <label for="email">Digite o seu email</label>
                            <a href="#" id="lnkEsqueciEmail">Esqueci meu email</a>
                        </div>

                        <div class="input-field col s12">
                            <input type="password" id="password">
                            <label for="password">Digite a sua senha</label>
                            <a href="#" id="lnkEsqueciSenha">Esqueci minha senha</a>
                        </div>

                        <div class="divSubmit input-field col s12">
                            <div id="error" style="display: none"></div>
                            <button type="submit" id="btnLogin"> Entrar</button>
                        </div>
                    </form>

                    <div class="redesSociais">
                        <div class="headerSociais">
                            <h1 class="title">Conectar com redes socias</h1>
                            <p class="description">Use suas redes socias para se conectar</p>
                        </div>
                        <div class="col-xs-12 col-sm-12 col-md-12 mt-2">
                            <ul class="list-unstyled list-inline social text-center">
                                <li class="list-inline-item">
                                    <a href="#" target="">
                                        <i class="fab fa-facebook-square" style="font-size: 60px;"></i>
                                    </a>
                                </li>

                                <li class="list-inline-item">
                                    <a href="#" target="">
                                        <i class="fab fa-google-plus-square" style="font-size: 60px;"></i>
                                    </a>
                                </li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row">

            </div>
        </div>
    </div>

    <div id="overlay">
        <div id="divEsqueciSenha" class="col-md-6 col-xs-4">
            <div class="header">
                <span id="fechar">x</span>
                <h1 class="title">Esqueci minha Senha</h1>
            </div>
        </div>
        <div id="divEsqueciEmail" class="col-md-6 col-xs-4">
            <div class="header">
                <span id="fechar" X></span>
                <h1 class="title">Esqueci meu E-mail</h1>
            </div>
        </div>
    </div>

    <footer id="footer">
        <div class="container-fluid">
            <div class="col-xs-12 col-sm-12 col-md-12 mt-2 mt-sm-5">
                <ul class="list-unstyled list-inline social text-center">
                    <li class="list-inline-item">
                        <a href="https://www.facebook.com/gabriela.vieira.52643" target="_blank">
                            <i class="fab fa-facebook-f"></i>
                        </a>
                    </li>
                    <li class="list-inline-item">
                        <a href="https://pt.stackoverflow.com/users/126877/gabriela-vieira" target="_blank">
                            <i class="fab fa-stack-overflow"></i>
                        </a>
                    </li>
                    <li class="list-inline-item">
                        <a href="https://github.com/aryli" target="_blank">
                            <i class="fab fa-github"></i>
                        </a>
                    </li>
                    <li class="list-inline-item">
                        <a href="https://linkedin.com/in/gabriela-vieira-a828aa168" target="_blank">
                            <i class="fab fa-linkedin-in"></i>
                        </a>
                    </li>
                </ul>
            </div>
        </div>
    </footer>

    <script src="https://www.gstatic.com/firebasejs/5.5.8/firebase.js"></script>
    <script>
        // Initialize Firebase
        var config = {
            apiKey: "AIzaSyBD8tRg-UUE9TZYxlKqzI1rd_8Z5duYMnI",
            authDomain: "apsanhembi.firebaseapp.com",
            databaseURL: "https://apsanhembi.firebaseio.com",
            projectId: "apsanhembi",
            storageBucket: "apsanhembi.appspot.com",
            messagingSenderId: "910769094357"
        };
        firebase.initializeApp(config);
    </script>

    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
        crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
        crossorigin="anonymous"></script>
    <!-- Compiled and minified JavaScript -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
    <script src="script/login.js"></script>
</body>

</html>