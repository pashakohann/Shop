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

      <button class="btn btn-primary me-md-2" type="button" ><a href="${pageContext.request.contextPath}/shop?command=back_action_command" style="color:white;">Back Menu</a> </button>

    </div>
    <nav style="--bs-breadcrumb-divider: '>';" aria-label="breadcrumb">
      <ol class="breadcrumb">

        <li class="breadcrumb-item active" aria-current="page">Your basket</li>


      </ol>
    </nav>
    <table class="table table-dark table-striped">
      <table class="table">
         <thead>
           <tr>
             <th scope="col">#</th>
             <th scope="col">Product</th>
             <th scope="col">price</th>

             <th scope="col">Execute</th>
           </tr>
         </thead>
         <tbody>
             <c:forEach var="element" items="${basketList}">

           <tr>
             <th scope="row">Order</th>
             <td>${element.getName()}</td>
             <td >${element.getCost()}</td>
               <td><button class="button" type="button">Cancel</td>
           </tr>
          </c:forEach>
         </tbody>
       </table>
    </table>
 </div>
   </header>

</body>
</html>