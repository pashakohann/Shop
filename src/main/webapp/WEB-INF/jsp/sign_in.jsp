<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" />
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">

<fmt:setLocale value = "${not empty sessionScope.language ? sessionScope.language : 'en'}"/>
<fmt:setBundle basename = "locale" var="loc"/>

<fmt:message bundle="${loc}" key = "signIn" var="signIn" />
<fmt:message bundle="${loc}" key = "user" var="user" />
<fmt:message bundle="${loc}" key = "password" var="password" />
<fmt:message bundle="${loc}" key = "login" var="login" />
<fmt:message bundle="${loc}" key = "goToSignUp" var="goToSignUp" />
<fmt:message bundle="${loc}" key = "mainMenu" var="mainMenu" />
<fmt:message bundle="${loc}" key = "validationUser" var="validationUser" />
<fmt:message bundle="${loc}" key = "validationPassword" var="validationPassword" />


<style>
.form-container{
 background: #ecf0f3;
 font-family: 'Nunito', sans-serif;
 padding: 40px;
 border-radius: 20px;
 box-shadow: 14px 14px 20px #cbced1, -14px -14px 20px white;
}

.form-container .form-icon{
 color: #179b52;
 font-size: 55px;
 text-align: center;
 line-height: 100px;
 width: 100px;
 height:100px;
 margin: 0 auto 15px;
 border-radius: 50px;
 box-shadow: 7px 7px 10px #cbced1, -7px -7px 10px #fff;
}

.form-container .title{
 color: #179b52;
 font-size: 25px;
 font-weight: 700;
 text-transform: uppercase;
 letter-spacing: 1px;
 text-align: center;
 margin: 0 0 20px;
}

.form-container .form-horizontal .form-group{ margin: 0 0 25px 0; }

.form-container .form-horizontal .form-group label{
 font-size: 15px;
 font-weight: 600;
 text-transform: uppercase;
}

.form-container .form-horizontal .form-control{
 color: #333;
 background: #ecf0f3;
 font-size: 15px;
 height: 50px;
 padding: 20px;
 letter-spacing: 1px;
 border: none;
 border-radius: 50px;
 box-shadow: inset 6px 6px 6px #cbced1, inset -6px -6px 6px #fff;
 display: inline-block;
 transition: all 0.3s ease 0s;
}

.form-container .form-horizontal .form-control:focus{
 box-shadow: inset 6px 6px 6px #cbced1, inset -6px -6px 6px #fff;
 outline: none;
}

.form-container .form-horizontal .form-control::placeholder{
 color: #808080;
 font-size: 14px;
}

.form-container .form-horizontal .btn{
 color: #000;
 background-color: #208f4b;
 font-size: 15px;
 font-weight: bold;
 text-transform: uppercase;
 width: 100%;
 padding: 12px 15px 11px;
 border-radius: 20px;
 box-shadow: 6px 6px 6px #cbced1, -6px -6px 6px #fff;
 border: none;
 transition: all 0.5s ease 0s;
}

.form-container .form-horizontal .btn:hover,
.form-container .form-horizontal .btn:focus{
 color: #fff;
 letter-spacing: 3px;
 box-shadow: none;
 outline: none;
}
.btn-defaultt{
margin-top: 20px;
}
</style>

<div class="container-fluid">

 <div class="col-md-4 offset-md-4">
 <div class="form-container">
 <div class="form-icon"><i class="fa fa-user"></i></div>
 <h3 class="title">${signIn}</h3>
 <form  class="form-horizontal" action="${pageContext.request.contextPath}/shop?command=authorization_command" method="post">
 <div class="form-group">
 <label>${user}</label>
 <input class="form-control" type="login" name="login" id="login" placeholder="${user}"  title="${validationUser}">
  <p class="help-block"> ${validationUser}</p>
 </div>
 <div class="form-group">
 <label>${password}</label>
 <input class="form-control" type="password" name="password" id="password" placeholder="${password}"   title="${validationPassword}">
 <p class="help-block"> ${validationPassword}</p>
 </div>
  <c:choose>
  <c:when test="${not empty error}">
  <p style="color: red;">${error}</p>
  </c:when>

   <c:when test="${not empty message}">
          <p style="color: red;">${message}</p>
   </c:when>
    </c:choose>
 <button submit="button" class="btn btn-default">${login}</button>
 <a href="${pageContext.request.contextPath}/shop?command=show_sign_up_page" class="btn btn-defaultt"> ${goToSignUp}</a>
 <a href="${pageContext.request.contextPath}/shop?command=default" class="btn btn-defaultt">${mainMenu}</a>

 </form>
 </div>
 </div>

</div>
