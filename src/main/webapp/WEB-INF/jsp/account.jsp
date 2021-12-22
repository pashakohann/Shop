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
<fmt:message bundle="${loc}" key = "backToUsers" var="backToUsers" />
<fmt:message bundle="${loc}" key = "backToOrders" var="backToOrders" />
<fmt:message bundle="${loc}" key = "firstName" var="firstName" />
<fmt:message bundle="${loc}" key = "lastName" var="lastName" />
<fmt:message bundle="${loc}" key = "email" var="email" />
<fmt:message bundle="${loc}" key = "dateOfBirth" var="dateOfBirth" />
<fmt:message bundle="${loc}" key = "city" var="city" />
<fmt:message bundle="${loc}" key = "street" var="street" />
<fmt:message bundle="${loc}" key = "flat" var="flat" />
<fmt:message bundle="${loc}" key = "amount" var="amount" />
<fmt:message bundle="${loc}" key = "telephoneNumber" var="telephoneNumber" />
<fmt:message bundle="${loc}" key = "deleteProhibited" var="deleteProhibited" />
<fmt:message bundle="${loc}" key = "profile" var="profile" />
<!DOCTYPE html>
<head>
   <meta charset="UTF-8">
   <meta http-equiv="X-UA-Compatible" content="IE=edge">
   <meta name="viewport" content="width=device-width, initial-scale=1.0">
   <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
   <link rel="stylesheet" href="css/style_basket.css">
   <title>All users</title>

</head>
<body >
 <div class="container">

   <div class="d-grid gap-2 d-md-flex justify-content-md-end">

      <button class="btn btn-primary me-md-2" type="button"><a href="${pageContext.request.contextPath}/shop?command=back_action_command" style="color:white;">${backToMenu}</a></button>

    </div>
    <nav style="--bs-breadcrumb-divider: '>';" aria-label="breadcrumb">
      <ol class="breadcrumb">

        <li class="breadcrumb-item active" aria-current="page">${profile}</li>
        <li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/shop?command=show_panel_command">${backToUsers}</a></li>
         <li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/shop?command=show_orders_command">${backToOrders}</a></li>

      </ol>
    </nav>
   </header>
   <table class="table table-dark table-striped" >
      <table class="table">
         <thead>
           <tr>

           <th scope="col">ID</th>
                         <th scope="col">${firstName}</th>
                                     <th scope="col">${lastName}</th>
                                     <th scope="col">${dateOfBirth}</th>
                                     <th scope="col">${telephoneNumber}</th>
                                     <th scope="col">${email}</th>
                                     <th scope="col">${city}</th>
                                     <th scope="col">${street}</th>
                                     <th scope="col">${flat}</th>
                                     <th scope="col">${amount}</th>
                                     <th scope="col">${action}</th>

           </tr>
         </thead>
         <tbody>

   <tr>
               <th scope="row">${accountView.getId()}</th>
               <td>${accountView.getFirstName()}</td>
               <td>${accountView.getLastName()}</td>
               <td>${accountView.getDateOfBirth()}</td>
               <td>${accountView.getTelephoneNumber()}</td>
               <td>${accountView.getEmail()}</td>
               <td>${accountView.getCity()}</td>
               <td>${accountView.getStreet()}</td>
               <td>${accountView.getFlat()}</td>
               <td>${accountView.getAmount()}</td>
                 <td><button class="button" type="button" style="color:white;background-color: red;" >${deleteProhibited}</td>
             </tr>

         </tbody>
       </table>
    </table>
 </div>

<!-- Дополнительный JavaScript; выберите один из двух! -->

    <!-- Вариант 1: Bootstrap в связке с Popper -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>

    <!-- Вариант 2: Bootstrap JS отдельно от Popper
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js" integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js" integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13" crossorigin="anonymous"></script>
    -->

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