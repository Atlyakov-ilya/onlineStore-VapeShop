<%@taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
</head>
<body>

<div id="footer">
    <div class="container-fluid">
        <div class="row centered">
            <a target="blank" title="Vkontakte" href="http://vk.com/" class="social-menu-link"><i class="fa fa-vk fa-lg"></i></a>
            <a target="blank" title="Facebook" href="http://facebook.com/" class="social-menu-link"><i class="fa fa-facebook fa-lg"></i></a>
            <a target="blank" title="Instagram" href="http://instagram.com/" class="social-menu-link"><i class="fa fa-instagram fa-lg"></i></a>
            <a target="blank" title="YouTube" href="http://youtube.com/" class="social-menu-link"><i class="fa fa-youtube fa-lg"></i></a>
            <a target="blank" title="Twitter" href="http://twitter.com/" class="social-menu-link"><i class="fa fa-twitter fa-lg"></i></a>
            <a target="blank" title="Google+" href="https://plus.google.com/" class="social-menu-link"><i class="fa fa-google-plus fa-lg"></i></a><br/>
            <form action="/user/add_feed_back" method="get">
                <button  type="submit" class="btn btn-warning buttom">Обратная связь</button>
            </form>
        </div>
    </div>
</div>

</body>
</html>