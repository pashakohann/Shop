<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>


<fmt:setLocale value = "${not empty sessionScope.language ? sessionScope.language : 'en'}"/>
<fmt:setBundle basename = "locale" var="loc"/>

<fmt:message bundle="${loc}" key = "copyRight" var="copyRight" />
<fmt:message bundle="${loc}" key = "computerShop" var="computerShop" />
<fmt:message bundle="${loc}" key = "russian" var="russian" />
<fmt:message bundle="${loc}" key = "english" var="english" />
<fmt:message bundle="${loc}" key = "backToMenu" var="backToMenu" />
<fmt:message bundle="${loc}" key = "allUsers" var="allUsers" />
<fmt:message bundle="${loc}" key = "allUserProfiles" var="allUserProfiles" />
<fmt:message bundle="${loc}" key = "allOrders" var="allOrders" />
<fmt:message bundle="${loc}" key = "allProductss" var="allProductss" />
<fmt:message bundle="${loc}" key = "addProduct" var="addProduct" />
<fmt:message bundle="${loc}" key = "yourProfile" var="yourProfile" />
<fmt:message bundle="${loc}" key = "yourWallet" var="yourWallet" />
<fmt:message bundle="${loc}" key = "backToMenu" var="backToMenu" />
<fmt:message bundle="${loc}" key = "action" var="action" />
<fmt:message bundle="${loc}" key = "login" var="login" />
<fmt:message bundle="${loc}" key = "lookProfile" var="lookProfile" />
<fmt:message bundle="${loc}" key = "delete" var="delete" />
<fmt:message bundle="${loc}" key = "firstName" var="firstName" />
<fmt:message bundle="${loc}" key = "lastName" var="lastName" />
<fmt:message bundle="${loc}" key = "email" var="email" />
<fmt:message bundle="${loc}" key = "dateOfBirth" var="dateOfBirth" />
<fmt:message bundle="${loc}" key = "city" var="city" />
<fmt:message bundle="${loc}" key = "street" var="street" />
<fmt:message bundle="${loc}" key = "flat" var="flat" />
<fmt:message bundle="${loc}" key = "amount" var="amount" />
<fmt:message bundle="${loc}" key = "telephoneNumber" var="telephoneNumber" />
<fmt:message bundle="${loc}" key = "saveChanges" var="saveChanges" />
<fmt:message bundle="${loc}" key = "current" var="current" />
<fmt:message bundle="${loc}" key = "change" var="change" />
<fmt:message bundle="${loc}" key = "name" var="name" />
<fmt:message bundle="${loc}" key = "category" var="category" />
<fmt:message bundle="${loc}" key = "brand" var="brand" />
<fmt:message bundle="${loc}" key = "photoLink" var="photoLink" />
<fmt:message bundle="${loc}" key = "cost" var="cost" />
<!DOCTYPE html>

<head>
   <meta charset="UTF-8">
   <meta http-equiv="X-UA-Compatible" content="IE=edge">
   <meta name="viewport" content="width=device-width, initial-scale=1.0">
   <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
   <link rel="stylesheet" href="css/style_basket.css">
   <title>Document</title>

</head>
<body>
 <div class="container">

   <div class="d-grid gap-2 d-md-flex justify-content-md-end">

       <button class="btn btn-primary me-md-2" type="button"><a href="${pageContext.request.contextPath}/shop?command=back_action_command" style="color:white;">${backToMenu}</a></button>

    </div>
    <nav style="--bs-breadcrumb-divider: '>';" aria-label="breadcrumb">
      <ol class="breadcrumb">
      <c:choose>
      <c:when test="${empty sessionScope.currentUser}">
      <a href="${pageContext.request.contextPath}/shop?command=show_error_command"></a>
           </c:when>
     <c:when test="${sessionScope.currentUser.getRole() eq 'ADMIN'}">
        <li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/shop?command=show_panel_command">${allUsers}</a></li>
        <li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/shop?command=show_accounts_command">${allUserProfiles}</a></li>
       <li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/shop?command=show_orders_command">${allOrders}</a></li>
       <li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/shop?command=show_products_command">${allProductss}</a></li>
       <li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/shop?command=show_add_product_command">${addProduct}</a></li>
        <li class="breadcrumb-item active" aria-current="page">${yourProfile}</li>
        <li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/shop?command=show_wallet_command">${yourWallet}</a></li>
      </c:when>
      <c:when test="${sessionScope.currentUser.getRole() eq 'USER'}">
      <li class="breadcrumb-item active" aria-current="page">${yourProfile}</li>
      <li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/shop?command=show_wallet_command">${yourWallet}</a></li>
      <li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/shop?command=show_orders_command">${allOrders}</a></li>
       </c:when>
       </c:choose>
      </ol>
    </nav>
    <table class="table table-dark table-striped">
      <table class="table">
         <thead>
           <tr>
             <th scope="col">#</th>
             <th scope="col">${current}</th>
             <th scope="col">${change}</th>

           </tr>
         </thead>
         <tbody>
          <form class="form-horizontal" action="${pageContext.request.contextPath}/shop?command=change_account_command" accept-charset="UTF-8" method="post">

           <tr>
             <th scope="row">${firstName}</th>

             <td>${account.getFirstName()}</td>
             <td ><input type="information" id="firstName" name="firstName"></td>

           </tr>
           <tr>
             <th scope="row">${lastName}</th>
             <td>${account.getLastName()}</td>
             <td ><input type="information" id="lastName" name="lastName"></td>

           </tr>
           <tr>
             <th scope="row">${dateOfBirth}</th>
             <td>${account.getDateOfBirth()}</td>
             <td ><input type="information" id="dateOfBirth" name="dateOfBirth"></td>

           </tr>
           <tr>
            <th scope="row">${telephoneNumber}</th>
            <td>${account.getTelephoneNumber()}</td>
             <td ><input type="information" id="phone" name="phone"></td>

          </tr>
          <tr>
            <th scope="row">${email}</th>
            <td>${account.getEmail()}</td>
             <td ><input type="informationid=" id="email" name="email"></td>

          </tr>
          <tr>
            <th scope="row">${city}</th>
            <td>${account.getCity()}</td>
             <td ><input type="information" id="city" name="city"></td>

          </tr>
          <tr>
            <th scope="row">${street}</th>
            <td>${account.getStreet()}</td>
             <td ><input type="information" id="street" name="street"></td>

          </tr>
          <tr>
            <th scope="row">${flat}</th>
            <td>${account.getFlat()}</td>
             <td ><input type="information" id="flat" name="flat"></td>

          </tr>

          <tr>
         <td>
          <button submit="button" class="button" style="color:white;background-color: rebeccapurple;">${saveChanges}</button>

        </td>
      </tr>
        <c:choose>
        <c:when test="${not empty error}">
        <p style="color: red;">${error}</p>
        </c:when>

         <c:when test="${not empty message}">
                <p style="color: red;">${message}</p>
         </c:when>
          </c:choose>
         </tbody>
       </table>
    </table>
 </div>
   </header>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
<footer class="page-footer font-small blue pt-4" style="position: fixed;left: 0; bottom: 0;padding: 15px;background: #c4c2c7; color: #fff;  width: 100%; height: 5%;">

   <div class="container-fluid text-center text-md-left">

     <div class="row">

       <div class="col-md-6 mt-md-0 mt-3">


         <h5 class="text-uppercase" style="padding-bottom: 12px;">${computerShop}</h5>

       </div>

       <hr class="clearfix w-100 d-md-none pb-3">

       <div class="dropdown">
         <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton1" data-bs-toggle="dropdown" aria-expanded="false" style="margin-left: 1300px; margin-top:-110px; height: 45px; width: 65px;">
          <img src="/img/img_language.jpg" style="width: 45px; height: 45px; padding-top: 1px; padding-bottom: 17px; padding-right: 6px; " alt="">
         </button>
         <ul class="dropdown-menu" aria-labelledby="dropdownMenuButton1">
                     <li><a class="dropdown-item" href="${pageContext.request.contextPath}/shop?command=language_command&language=en">${english}</a></li>
                     <li><a class="dropdown-item" href="${pageContext.request.contextPath}/shop?command=language_command&language=ru">${russian}</a></li>


         </ul>
       </div>

     </div>

   </div>

   <div class="footer-copyright text-center py-3 " style="margin-top:-105px;">© 2021 ${copyRight}:
     <a href="https://github.com/pashakohann/Shop"><img src="/img/png-github-logo.png" alt=""  style="height: 40px; width: 70px; "></a>
   </div>
 </footer>
</body>
</html>