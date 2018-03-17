<%@taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<head>
</head>
<body>
<!--Верхняя навигация -->
<div class="container">
    <div class="row">
        <div class="navbar navbar-inverse">
            <div class="container">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#responsive-menu">
                        <span class="sr-only">Открыть навигацию</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="#">V<i class="fa icon fa-at" aria-hidden="true"></i>peSh<i class="fa icon fa-circle" aria-hidden="true"></i>p</a>
                </div>
                <div class="collapse navbar-collapse" id="responsive-menu">
                    <ul class="nav navbar-nav">
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">Каталог<b class="caret"></b></a>
                            <ul class="dropdown-menu">
                                <li class="dropdown-item"><a href="#">ЭЛЕКТРОННЫЕ СИГАРЕТЫ</a></li>
                                <li class="dropdown-item"><a href="#">ЖИДКОСТИ</a></li>
                                <li class="dropdown-item"><a href="#">КОМПЛЕКТУЮЩИЕ</a></li>
                                <li class="dropdown-item"><a href="#">АККУМУЛЯТОРЫ</a></li>
                            </ul>
                        </li>
                        <li><a href="#">Доставка и оплата</a></li>
                        <li><a href="#">Контакты</a></li>
                    </ul>
                    <form class="navbar-form navbar-left" role="search">
                        <i class="fa icon fa-search fa-lg" aria-hidden="true"></i>
                        <div class="form-group">
                            <input type="text" class="form-control" placeholder="Найти">
                        </div>
                        <button type="submit" class="btn btn-default">Поиск</button>
                    </form>

                    <ul class="nav navbar-nav navbar-right">
                        <li><i class="fa icon fa-sign-in fa-lg" aria-hidden="true"></i></li>
                        <li><a href="/logout">Выход</a></li>
                    </ul>

                    <ul class="nav navbar-nav navbar-right">
                        <li><a href="/user/basket">Корзина</a></li>
                    </ul>

                    <ul class="nav navbar-nav navbar-right">
                        <li><i class="fa icon fa-user fa-lg" aria-hidden="true"></i></li>
                        <li><a href="/user/profile">Профиль</a></li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>