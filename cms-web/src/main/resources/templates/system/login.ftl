<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=yes">
    <title>易乎社区CMS后台管理系统</title>
    <link rel="shortcut icon" type="image/x-icon" href="adminlte/dist/img/ehulogo.png">
    <link rel="stylesheet" href="/adminlte/dist/css/login2.css">
    <script type="text/javascript" charset="utf-8" src="/adminlte/plugins/an_login/edge_includes/edge.6.0.0.min.js"></script>
    <style type="text/css">
        #Stage{
            background-color: rgb(57, 173, 205) !important;
        }
        #bg{
            height: 40%;
            position: absolute;
            width: 100%;
            bottom:0px;;
        }
        .login{
            background: none;
            color: 575757;;
        }
    </style>
</head>
<body style=" background-color: rgb(57, 173, 205) !important;">
<div id="Stage" class="EDGE-279555267">
</div>
<div id="bg" style="background: #78d2eb"></div>
<div class="cont" style="background-image:none;">
    <div class="demo">
        <div class="login">
            <div class="login__check">
                <img src="/adminlte/dist/img/ehulogo.png" alt="">
            </div>
            <form action="/postLogin" class="login__form" method="post">
                <div class="login__row">
                    <svg class="login__icon name svg-icon" viewBox="0 0 20 20">
                        <path d="M0,20 a10,8 0 0,1 20,0z M10,0 a4,4 0 0,1 0,8 a4,4 0 0,1 0,-8" />
                    </svg>
                    <!--账号-->
                    <input type="text" name="username" class="login__input name" placeholder="Username"/>
                </div>
                <div class="login__row">
                    <svg class="login__icon pass svg-icon" viewBox="0 0 20 20">
                        <path d="M0,20 20,20 20,8 0,8z M10,13 10,16z M4,8 a6,8 0 0,1 12,0" />
                    </svg>
                    <!--密码-->
                    <input type="password" name="password" class="login__input pass" placeholder="Password"/>
                </div>
                <button type="submit" class="login__submit">登 录</button>
            </form>
        </div>
    </div>
</div>

<script src="/adminlte/dist/js/pages/login2.js"></script>
<!-- jQuery 2.2.3 -->
<script src="/adminlte/plugins/jQuery/jquery-2.2.3.min.js"></script>

<script>
    $(document).ready(function () {
        var animating = false, submitPhase1 = 1100, submitPhase2 = 400, logoutPhase1 = 800, $login = $('.login'), $app = $('.app');
        function ripple(elem, e) {
            $('.ripple').remove();
            var elTop = elem.offset().top, elLeft = elem.offset().left, x = e.pageX - elLeft, y = e.pageY - elTop;
            var $ripple = $('<div class=\'ripple\'></div>');
            $ripple.css({
                top: y,
                left: x
            });
            elem.append($ripple);
        }
        ;
        $('.login__form,.reg__form').on('submit', function (e) {
            if (animating)
                return false;
            animating = true;
            var that = $(".login__submit");
            ripple($(that), e);
            $(that).addClass('processing');
            setTimeout(function () {
                animating = false;
                that.removeClass('processing');
//                alert("登录成功")
            }, submitPhase1);
            return true;
        });

        $(".login__signup a").on('click', function (e) {
            var that = $(".login__submit");
            that.addClass('processing success');
            setTimeout(function () {
                $app.show();
                $app.css('top');
                $app.addClass('active');
            }, submitPhase2 - 70);
            setTimeout(function () {
                $login.hide();
                $login.addClass('inactive');
                animating = false;
                that.removeClass('success processing');
            }, submitPhase2);
            return false;
        });

        $(document).on('click', '.app__logout', function (e) {
            if (animating)
                return;
            $('.ripple').remove();
            animating = true;
            var that = $(".login__submit");
            that.addClass('processing success');
            setTimeout(function () {
                $app.removeClass('active');
                $login.show();
                $login.css('top');
                $login.removeClass('inactive');
            }, submitPhase2 - 70);
            setTimeout(function () {
                $app.hide();
                animating = false;
                that.removeClass('success processing');
            }, submitPhase2);
        });
    });
</script>
</body>
</html>