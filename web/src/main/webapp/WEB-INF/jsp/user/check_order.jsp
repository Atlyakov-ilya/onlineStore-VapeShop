<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Оформление заказа</title>
    <link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/style.css" rel="stylesheet">
</head>
<body>
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
                    <a class="navbar-brand" href="#">V<i class="fa icon fa-at" aria-hidden="true"></i>peSh<i
                            class="fa icon fa-circle" aria-hidden="true"></i>p</a>
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
        <div class="col-md-12">
            <div class="col-md-6">
                <h1 class="left">Оформление заказа</h1>

                <h3>Контактный телефон:</h3>
                <p>${user.phoneNumber}</p><br/>
                <h3> Адрес:</h3>
                <p>Город ${address.city},Улица ${address.street},
                    Дом ${address.house},Квартира ${address.flat}.
                <p></p><br/>
                <h3> ФИО получателя:</h3>
                <p> ${user.lastName} ${user.firstName} ${user.middleName}.</p><br/>
                <h3> Email:</h3>
                <p>${user.mail}</p>

                <form action="/user/profile" method="get">
                    <button class="btn btn-warning">Изменить данные</button>
                </form>

            </div>
            <h1 class="left">Список товаров</h1>
            <div class="col-md-6">
                <c:forEach var="basket" items="${basketList}">
                    <hr/>
                    <a href="show_one_item/${basket.goodsId}"><img
                            src="${pageContext.request.contextPath}/user/downloadGoodsFile/<c:out value="${basket.goodsId}"/>"
                            alt="photo" height="160" width="160"></a>
                    <p>Название: <c:out value="${basket.name}"/></p>
                    <p>Цена: <c:out value="${basket.price}"/></p>
                </c:forEach>
            </div>
            <div class="col-md-6 col-md-offset-6">
                <hr/>
                <p class="right">Сумма по товарам: ${allPrice} руб</p>
                <p class="right">Сумма по доставке: 0 руб</p>
                <hr/>
                <p>ИТОГО: ${allPrice} руб</p><br/>

                <form action="/user/addOrder/${allPrice}" method="get">
                    <button class="btn btn-warning">Подтвердить заказ</button>
                </form>
            </div>
        </div>
        <br/>
        <div id="footer">
            <div class="container-fluid">
                <div class="row centered">
                    <a target="blank" title="Vkontakte" href="http://vk.com/" class="social-menu-link"><i
                            class="fa fa-vk fa-lg"></i></a>
                    <a target="blank" title="Facebook" href="http://facebook.com/" class="social-menu-link"><i
                            class="fa fa-facebook fa-lg"></i></a>
                    <a target="blank" title="Instagram" href="http://instagram.com/" class="social-menu-link"><i
                            class="fa fa-instagram fa-lg"></i></a>
                    <a target="blank" title="YouTube" href="http://youtube.com/" class="social-menu-link"><i
                            class="fa fa-youtube fa-lg"></i></a>
                    <a target="blank" title="Twitter" href="http://twitter.com/" class="social-menu-link"><i
                            class="fa fa-twitter fa-lg"></i></a>
                    <a target="blank" title="Google+" href="https://plus.google.com/" class="social-menu-link"><i
                            class="fa fa-google-plus fa-lg"></i></a><br/>
                    <form action="/user/add_feed_back" method="get">
                        <button type="submit" class="btn btn-warning buttom">Обратная связь</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
