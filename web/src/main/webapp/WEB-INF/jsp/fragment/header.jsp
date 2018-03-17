<%@taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
</head>
<body>
<!--Логотип-->
    <div class="container">
        <div class="row centered">
            <div class="col-lg-8 col-lg-offset-2"></div>
            <div class="logo">
                <a href="/user/main" title="На главную">
                    <img src="/resources/img/site/logotype.jpg" alt="logo">
                </a>
            </div>
        </div>
    </div>
<!--Категории-->
<nav>
    <div class="container w">
        <div class="row centered">
            <div class="main-menu-wrapper">
                <hr>
                <ul class="list-inline">
                    <li class="main-nav-li"><a href="/user/show_goods_atomizer">ЭЛЕКТРОННЫЕ СИГАРЕТЫ</a></li>
                    <li class="main-nav-li"><a href="/user/show_goods_liquid">ЖИДКОСТИ</a></li>
                    <li class="main-nav-li"><a href="/user/show_goods_components">КОМПЛЕКТУЮЩИЕ</a></li>
                    <li class="main-nav-li"><a href="/user/show_goods_accumulator">АККУМУЛЯТОРЫ</a></li>
                </ul>
                <hr>
            </div>
        </div>
    </div>
</nav>
</body>
</html>