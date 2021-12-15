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

      <button class="btn btn-primary me-md-2" type="button">Main menu</button>

    </div>
    <nav style="--bs-breadcrumb-divider: '>';" aria-label="breadcrumb">
      <ol class="breadcrumb">

        <li class="breadcrumb-item active" aria-current="page">Personal Information</li>
        <li class="breadcrumb-item"><a href="#">Orders</a></li>
      </ol>
    </nav>
    <table class="table table-dark table-striped">
      <table class="table">
         <thead>
           <tr>
             <th scope="col">#</th>
             <th scope="col">Current</th>
             <th scope="col">Change</th>
             <th scope="col">Execute</th>
           </tr>
         </thead>
         <tbody>
           <tr>
             <th scope="row">First Name</th>

             <td>Unknown</td>
             <td ><input type="information"></td>
             <td><button class="button" type="button">Apply</td>
           </tr>
           <tr>
             <th scope="row">Last Name</th>
             <td>Unknown</td>
             <td ><input type="information"></td>
             <td><button class="button" type="button">Apply</td>
           </tr>
           <tr>
             <th scope="row">Date Of Birth</th>
             <td>Unknown</td>
             <td ><input type="information"></td>
             <td><button class="button" type="button">Apply</td>
           </tr>
           <tr>
            <th scope="row">Mobile phone</th>
            <td>Unknown</td>
             <td ><input type="information"></td>
             <td><button class="button" type="button">Apply</td>
          </tr>
          <tr>
            <th scope="row">Email</th>
            <td>Unknown</td>
             <td ><input type="information"></td>
             <td><button class="button" type="button">Apply</td>
          </tr>
          <tr>
            <th scope="row">City</th>
            <td>Unknown</td>
             <td ><input type="information"></td>
             <td><button class="button" type="button">Apply</td>
          </tr>
          <tr>
            <th scope="row">Street</th>
            <td>Unknown</td>
             <td ><input type="information"></td>
             <td><button class="button" type="button">Apply</td>
          </tr>
          <tr>
            <th scope="row">Flat</th>
            <td>Unknown</td>
             <td ><input type="information"></td>
             <td><button class="button" type="button">Apply</td>
          </tr>
          <tr>
            <th scope="row">Amout</th>
            <td>Unknown</td>
            <td ><input type="information"></td>
            <td><button class="button" type="button">Apply</td>
          </tr>

         </tbody>
       </table>
    </table>
 </div>
   </header>




</body>
</html>