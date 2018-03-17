<%@taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
</head>
<body>

<div class="container w">
    <div class="row centered">
        <div class="benefits">
            <div class="decorated-title-wrapper">
                <div class="decorated-title">
                   <a href="/user/show_goods/1"><h3>Каталог</h3></a>
                </div>
            </div>
        </div>
    </div>
</div>

<div class="container c">
    <div class="row centered">
        <div class="categories-menu">
            <div class="col-lg-3">
                <a href="/user/show_goods_atomizer">
                <img src="/resources/img/site/large_sigarette.jpg">
                <p class="menu-cat-p">ЭЛЕКТРОННЫЕ СИГАРЕТЫ</p>
                </a>
            </div>
        </div>
        <div class="categories-menu">
            <div class="col-lg-3">
                <a href="/user/show_goods_liquid">
                    <img src="/resources/img/site/large_liquds.jpg">
                    <p class="menu-cat-p">ЖИДКОСТИ</p>
                </a>
            </div>
        </div>
        <div class="categories-menu">
            <div class="col-lg-3">
                <a href="/user/show_goods_components">
                    <img src="/resources/img/site/large_accessorias.jpg">
                    <p class="menu-cat-p">КОМПЛЕКТУЮЩИЕ</p>
                </a>
            </div>
        </div>
        <div class="categories-menu">
            <div class="col-lg-3">
                <a href="/user/show_goods_accumulator">
                    <img src="/resources/img/site/large_bataries.jpg">
                    <p class="menu-cat-p">АККУМУЛЯТОРЫ</p>
                </a>
            </div>
        </div>
    </div>
</div>
</body>
</html>