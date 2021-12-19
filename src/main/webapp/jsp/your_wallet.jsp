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
       <li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/shop?command=show_profile_command">Your Profile</a></li>
        <li class="breadcrumb-item active" aria-current="page">Your Wallet</li>
      </c:when>
      <c:when test="${sessionScope.currentUser.getRole() eq 'USER'}">
        <li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/shop?command=show_profile_command">Your Profile</a></li>
        <li class="breadcrumb-item active" aria-current="page">Your Wallet</li>
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
             <th scope="col">Top up</th>

           </tr>
         </thead>
         <tbody>
          <form class="form-horizontal" action="${pageContext.request.contextPath}/shop?command=top_up_command" method="post">

          <tr>
            <th scope="row">Amount</th>
            <td>${account.getAmount()}</td>
            <td ><input type="information" id="amount" name="amount"></td>

          </tr>

          <tr>
         <td>
          <button submit="button" class="button">Top up</button>

        </td>
      </tr>
         </tbody>
       </table>
    </table>
 </div>
   </header>




</body>
</html>