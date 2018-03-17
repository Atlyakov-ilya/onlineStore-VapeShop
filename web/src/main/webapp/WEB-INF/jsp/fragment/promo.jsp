<%@taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
</head>
<body>
<!--Слайдер -->
<div class="container">
    <div class="row centered">
        <div id="carousel" class="carousel slide centered">
            <!--Слайды -->
            <div class="carousel-inner">
                <div class="item active">
                    <img src="/resources/img/site/slider3.jpg" alt=""/>
                    <div class="carousel-caption">
                        <h3>Первый слайд</h3>
                        <p>Описание первого слайда</p>
                    </div>
                </div>
                <div class="item">
                    <img src="/resources/img/site/slider4.jpg" alt=""/>
                    <div class="carousel-caption">
                        <h3>Второй слайд</h3>
                        <p>Описание второго слайда</p>
                    </div>
                </div>
            </div>
            <!--Стрелки переключения слайдов -->
            <a href="#carousel" class="left carousel-control" data-slide="prev">
                <span class="glyphicon glyphicon-chevron-left"></span>
            </a>
            <a href="#carousel" class="right carousel-control" data-slide="next">
                <span class="glyphicon glyphicon-chevron-right"></span>
            </a>
        </div>
    </div>
</div>
<!--/Слайдер -->

<!--Рекламный блок -->
<div class="container w">
    <div class="row centered">

        <div class="benefits">
            <div class="decorated-title-wrapper">
                <div class="decorated-title">
                    <h3>Преимущество компании</h3>
                </div>
            </div>
        </div>

        <br>
        <div class="col-lg-3">
            <img src="/resources/img/site/benefit1.png" title="БЫСТРАЯ ДОСТАВКА" alt="БЫСТРАЯ ДОСТАВКА">
            <h3>БЫСТРАЯ ДОСТАВКА</h3>
        </div>
        <div class="col-lg-3">
            <img src="/resources/img/site/benefit2.png" title="ГАРАНТИЯ КАЧЕСТВА" alt="ГАРАНТИЯ КАЧЕСТВА">
            <h3>ГАРАНТИЯ КАЧЕСТВА</h3>
        </div>
        <div class="col-lg-3">
            <img src="/resources/img/site/benefit3.png" title="СЕРВИСНЫЙ ЦЕНТР" alt="СЕРВИСНЫЙ ЦЕНТР">
            <h3>СЕРВИСНЫЙ ЦЕНТР</h3>
        </div>
        <div class="col-lg-3">
            <img src="/resources/img/site/benefit4.png" title="СИСТЕМА СКИДОК" alt="СИСТЕМА СКИДОК">
            <h3>СИСТЕМА СКИДОК</h3>
        </div>
    </div>
</div>
<!--Рекламный блок -->
</body>
</html>