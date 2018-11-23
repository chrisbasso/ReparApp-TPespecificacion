<html>
<head>

    <title><g:message code='springSecurity.login.title'/></title>
    <style type="text/css" media="screen">
    /*Fonts*/
    @import 'https://fonts.googleapis.com/css?family=Open+Sans';
    @import 'https://fonts.googleapis.com/css?family=Galada';

    ::selection {
        background: #ffb7b7; /* WebKit/Blink Browsers */
    }
    ::-moz-selection {
        background: #ffb7b7; /* Gecko Browsers */
    }
    * {
        -moz-box-sizing: border-box;
        -webkit-box-sizing: border-box;
        box-sizing: border-box;
    }
    :focus {outline:none}
    /*Reset*/
    body, div, dl, dt, dd, ul, ol, li, h1, h2, h3, h4, h5, h6,
    pre, form, fieldset, input, textarea, p, blockquote, th, td {
        padding:0;
        margin:0;}
    body,input{
        font-family:'Open sans',sans-serif;

        color:#4c4c4c;
    }
    body{
        background-color:#292931;
        background:url(http://wallpapercrafter.com/uploads/posts/172-___car-and-automotive-repair-service-hd.jpg)  no-repeat center center fixed;
        -webkit-background-size: cover;
        -moz-background-size: cover;
        -o-background-size: cover;
        background-size: cover;
        font-size:31px;
    }
    form{
        margin: 20px 35px;
    }
    input{
        border:none;
        font-size:20px;

    }
    a{
        text-decoration: none;
        color: rgb(255, 255, 255);

    }
    a:hover{
        color: rgba(255, 152, 0, 0.79);
        text-decoration: underline;

    }
    input[type=text], input[type=password] {
        width: 237px;
        height: 40px;
        border:1px solid #cbc9c9;
        padding-left:5px;
        margin-left:17px;
        margin-bottom:12px;
        border-radius:0px 3px 3px 0px;
        -webkit-border-radius:0px 3px 3px 0px;
        -moz-border-radius:0px 3px 3px 0px;
    }
    input[type=submit]{
        width: 237px;
        height: 40px;
        margin-left:17px;
        margin-bottom:12px;
        border-radius:3px;
        background-color:#ae6a6a;
        color:#f8f8f8;
        border-radius:2px 2px 12px 12px;
        -webkit-border-radius:2px 2px 12px 12px;
        -moz-border-radius:2px 2px 12px 12px;

    }
    input[type=submit]:hover{
        background-color:#607d8b;
        color:#f8f8f8;
        cursor:pointer;

    }
    #icon{
        background-color:#F4F4F4;
        color:#625864;
        display:inline-block;
        font-size:14px;
        padding-top:10px;
        padding-bottom:7px;
        width:40px;
        margin-left: 15px;
        margin-bottom:20px;
        text-align:center;
        border-top:solid 1px #cbc9c9;
        border-bottom:solid 1px #cbc9c9;
        border-left:solid 1px #cbc9c9;
        border-radius:3px 0 0 3px;
        -webkit-border-radius:3px 0 0 3px;
        -moz-border-radius:3px 0 0 3px;
    }
    .wrapper{
        margin:100px auto;
        width: 343px;
        height: 280px;
        border-radius:5px;
        -moz-border-radius:5px;
        -webkit-border-radius:5px;
    }
    .wrapper h1{
        font-family: 'Galada', cursive;
        color:#f9911b;
        letter-spacing:8px;
        text-align:center;
        padding-top:5px;
        padding-bottom:5px;
    }
    .wrapper hr{
        opacity:0.2;

    }
    .crtacc{
        margin-left:75px;
    }
    </style>
</head>

<body>
<div class="wrapper animated bounce">
    <h1>Repar-App</h1>
    <hr>
        <form action="${postUrl ?: '/login/authenticate'}" method="POST" id="loginForm" autocomplete="off">

                <input type="text" placeholder="Usuario" name="${usernameParameter ?: 'username'}" id="username"/>
                <input type="password" placeholder="Contraseña" name="${passwordParameter ?: 'password'}" id="password"/>
                <input type="submit" id="submit" value="INGRESAR"/>

            <hr>

        </form>
    </div>


</div>

<script>
    (function() {
        document.forms['loginForm'].elements['${usernameParameter ?: 'username'}'].focus();
    })();
</script>
</body>
</html>