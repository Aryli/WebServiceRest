<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
	<title>Local</title>

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
        crossorigin="anonymous">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU"
        crossorigin="anonymous">
    <link rel="stylesheet" href="css/mainDashboard.css">
    <link rel='stylesheet prefetch' href='https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css'>
    <link rel='stylesheet prefetch' href='https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/css/bootstrap.min.css'>
    <link rel='stylesheet prefetch' href='https://cdnjs.cloudflare.com/ajax/libs/animate.css/3.5.2/animate.min.css'>
    <style class="cp-pen-styles">@import url("https://fonts.googleapis.com/css?family=Open+Sans:300,400,400i,600,700&subset=latin-ext");</style>
</head>
	

<body class="sidebar-is-reduced">
    <header class="l-header">
        <div class="l-header__inner clearfix">
            <div class="c-header-icon js-hamburger">
                <div class="hamburger-toggle"><span class="bar-top"></span><span class="bar-mid"></span><span class="bar-bot"></span></div>
            </div>
            <div class="c-header-icon has-dropdown"><span class="c-badge c-badge--header-icon animated shake">12</span><i
                    class="fa fa-bell"></i>
                <div class="c-dropdown c-dropdown--notifications">
                    <div class="c-dropdown__header"></div>
                    <div class="c-dropdown__content"></div>
                </div>
            </div>
            <div class="c-search">
                <input class="c-search__input u-input" placeholder="Search..." type="text" />
            </div>
            <div class="header-icons-group">
                <div class="c-header-icon logout"><i class="fa fa-power-off"></i></div>
            </div>
        </div>
    </header>
    <div class="l-sidebar">
        <div class="logo">
            <div class="logo__txt"><img src="images/logo.png" alt=""></div>
        </div>
        <div class="l-sidebar__content">
            <nav class="c-menu js-menu">
                <ul class="u-list">
                    <li class="c-menu__item is-active" data-toggle="tooltip" title="Meus Locais">
                        <div class="c-menu__item__inner"><i class="fa fa-file-text-o"></i>
                            <div class="c-menu-item__title">
                                <a href="meus-locais.html"><span>Meus Locais</span></a> </div>
                        </div>
                    </li>
                    <li class="c-menu__item has-submenu" data-toggle="tooltip" title="History">
                        <div class="c-menu__item__inner"><i class="fa fa-history"></i>
                            <div class="c-menu-item__title"><span>History</span></div>
                        </div>
                    </li>
                    <li class="c-menu__item has-submenu" data-toggle="tooltip" title="Accounts">
                        <div class="c-menu__item__inner"><i class="fa fa-address-book-o"></i>
                            <div class="c-menu-item__title"><span>Accounts</span></div>
                        </div>
                    </li>
                    <li class="c-menu__item has-submenu" data-toggle="tooltip" title="Settings">
                        <div class="c-menu__item__inner"><i class="fa fa-cogs"></i>
                            <div class="c-menu-item__title"><span>Settings</span></div>
                        </div>
                    </li>
                </ul>
            </nav>
        </div>
    </div>

    <div class="l-main">
        <div class="container">
        <div class="header">
                <div class="title">Local</div>
            </div>
			<form class="form" id="alterar">
				<input class="form-control" name="titulo">
				<input class="form-control" name="latitude">
				<input class="form-control" name="longitude">		
				<button class="btn btn-primary">Salvar alterações</button>
			</form>
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
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
        crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
        crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
        crossorigin="anonymous"></script>
    <!-- Compiled and minified JavaScript -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0-rc.2/js/materialize.min.js"></script>
    <script src='https://cdnjs.cloudflare.com/ajax/libs/jquery/3.1.1/jquery.min.js'></script>
    <script src='https://use.fontawesome.com/2188c74ac9.js'></script>
    <script src='https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/js/bootstrap.min.js'></script>
    <script src="script/main.js"></script>
    <script src="script/meus-locais.js" type="text/javascript"></script>
</body></html>