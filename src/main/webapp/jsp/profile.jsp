<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

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

       <button class="btn btn-primary me-md-2" type="button"><a href="${pageContext.request.contextPath}/shop?command=back_action_command" style="color:white;">Back Menu</a></button>

    </div>
    <nav style="--bs-breadcrumb-divider: '>';" aria-label="breadcrumb">
      <ol class="breadcrumb">
      <c:choose>
      <c:when test="${empty sessionScope.currentUser}">
      <a href="${pageContext.request.contextPath}/shop?command=show_error_command"></a>
           </c:when>
     <c:when test="${sessionScope.currentUser.getRole() eq 'ADMIN'}">
        <li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/shop?command=show_panel_command">All users</a></li>
        <li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/shop?command=show_accounts_command">All user profiles</a></li>
       <li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/shop?command=show_orders_command">All orders</a></li>
       <li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/shop?command=show_products_command">All products</a></li>
       <li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/shop?command=show_add_product_command">Add product</a></li>
        <li class="breadcrumb-item active" aria-current="page">Your Profile</li>
        <li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/shop?command=show_wallet_command">Your wallet</a></li>
      </c:when>
      <c:when test="${sessionScope.currentUser.getRole() eq 'USER'}">
      <li class="breadcrumb-item active" aria-current="page">Your Profile</li>
      <li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/shop?command=show_wallet_command">Your wallet</a></li>
      <li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/shop?command=show_orders_command">All orders</a></li>
       </c:when>
       </c:choose>
      </ol>
    </nav>
    <table class="table table-dark table-striped">
      <table class="table">
         <thead>
           <tr>
             <th scope="col">#</th>
             <th scope="col">Current</th>
             <th scope="col">Change</th>

           </tr>
         </thead>
         <tbody>
          <form class="form-horizontal" action="${pageContext.request.contextPath}/shop?command=change_account_command" accept-charset="UTF-8" method="post">

           <tr>
             <th scope="row">First Name</th>

             <td>${account.getFirstName()}</td>
             <td ><input type="information" id="firstName" name="firstName"></td>

           </tr>
           <tr>
             <th scope="row">LastName</th>
             <td>${account.getLastName()}</td>
             <td ><input type="information" id="lastName" name="lastName"></td>

           </tr>
           <tr>
             <th scope="row">Date of Birth</th>
             <td>${account.getDateOfBirth()}</td>
             <td ><input type="information" id="dateOfBirth" name="dateOfBirth"></td>

           </tr>
           <tr>
            <th scope="row">Mobile Phone</th>
            <td>${account.getTelephoneNumber()}</td>
             <td ><input type="information" id="phone" name="phone"></td>

          </tr>
          <tr>
            <th scope="row">Email</th>
            <td>${account.getEmail()}</td>
             <td ><input type="informationid=" id="email" name="email"></td>

          </tr>
          <tr>
            <th scope="row">City</th>
            <td>${account.getCity()}</td>
             <td ><input type="information" id="city" name="city"></td>

          </tr>
          <tr>
            <th scope="row">Street</th>
            <td>${account.getStreet()}</td>
             <td ><input type="information" id="street" name="street"></td>

          </tr>
          <tr>
            <th scope="row">Flat</th>
            <td>${account.getFlat()}</td>
             <td ><input type="information" id="flat" name="flat"></td>

          </tr>

          <tr>
         <td>
          <button submit="button" class="button" style="color:white;background-color: rebeccapurple;">Save changes</button>

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




</body>
</html>