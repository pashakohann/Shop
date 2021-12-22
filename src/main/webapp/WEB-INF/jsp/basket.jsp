<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>


<fmt:setLocale value = "${not empty sessionScope.language ? sessionScope.language : 'en'}"/>
<fmt:setBundle basename = "locale" var="loc"/>

<fmt:message bundle="${loc}" key = "copyRight" var="copyRight" />
<fmt:message bundle="${loc}" key = "computerShop" var="computerShop" />
<fmt:message bundle="${loc}" key = "russian" var="russian" />
<fmt:message bundle="${loc}" key = "english" var="english" />
<fmt:message bundle="${loc}" key = "yourBasket" var="yourBasket" />
<fmt:message bundle="${loc}" key = "order" var="order" />
<fmt:message bundle="${loc}" key = "product" var="product" />
<fmt:message bundle="${loc}" key = "price" var="price" />
<fmt:message bundle="${loc}" key = "orderP" var="orderP" />
<fmt:message bundle="${loc}" key = "cleanBasket" var="cleanBasket" />
<fmt:message bundle="${loc}" key = "backToMenu" var="backToMenu" />
<fmt:message bundle="${loc}" key = "execute" var="execute" />
<fmt:message bundle="${loc}" key = "cancel" var="cancel" />
<fmt:message bundle="${loc}" key = "goToProfile" var="goToProfile" />


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
    <c:choose>

       <c:when test="${not empty error}">
             <button class="btn btn-primary me-md-2" type="button" ><a href="${pageContext.request.contextPath}/shop?command=show_profile_command" style="color:white;">${goToProfile}</a> </button>
       </c:when>
        </c:choose>
      <button class="btn btn-primary me-md-2" type="button" ><a href="${pageContext.request.contextPath}/shop?command=order_products_command" style="color:white;">${order}</a> </button>
      <button class="btn btn-primary me-md-2" type="button" ><a href="${pageContext.request.contextPath}/shop?command=clear_basket_command" style="color:white;">${cleanBasket}</a> </button>
      <button class="btn btn-primary me-md-2" type="button" ><a href="${pageContext.request.contextPath}/shop?command=back_action_command" style="color:white;">${backToMenu}</a> </button>


    </div>
    <nav style="--bs-breadcrumb-divider: '>';" aria-label="breadcrumb">
      <ol class="breadcrumb">

        <li class="breadcrumb-item active" aria-current="page">${yourBasket}</li>

      </ol>
    </nav>
    <table class="table table-dark table-striped">
      <table class="table">
         <thead>
           <tr>
             <th scope="col">#</th>
             <th scope="col">${product}</th>
             <th scope="col">${price}</th>

             <th scope="col">${execute}</th>
              <c:choose>
               <c:when test="${not empty error}">
               <p style="color: red;">${error}</p>
               </c:when>

                <c:when test="${not empty message}">
                       <p style="color: red;">${message}</p>
                </c:when>
                 </c:choose>
           </tr>
         </thead>
         <tbody>
             <c:forEach var="element" items="${basketList}">

           <tr>
             <th scope="row">${order}</th>
             <td>${element.getName()}</td>
             <td >${element.getCost()}</td>
               <td><button class="button" type="button"><a href="${pageContext.request.contextPath}/shop?command=delete_product_basket_command&productId=${element.getId()}"  style="color:white;background-color: rebeccapurple;">${cancel}</a></td>
           </tr>
          </c:forEach>
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