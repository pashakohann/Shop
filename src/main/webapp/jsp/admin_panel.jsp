<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!doctype html>
<html lang="ru">
  <head>
    <!-- Обязательные метатеги -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
     <link rel="stylesheet" href="../css/style.css">
     <link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Playfair+Display:ital@1&display=swap" rel="stylesheet">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Playfair+Display:ital@1&display=swap" rel="stylesheet">
    <title>Computer Shop</title>
  </head>
  <body>
    <div class="wrapper">
       <header>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
       <div class="container">


              <a class="navbar-brand" href="#"><img src="../img/log2.png" alt=""></a>
              <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
              </button>
              <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                  <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="${pageContext.request.contextPath}/shop?command=default">All products</a>
                  </li>
                  <li class="nav-item dropdown">
                     <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                      motherboard
                     </a>
                     <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                       <li><a class="dropdown-item" href="${pageContext.request.contextPath}/shop?command=find_products_category&category=1">All motherboard</a></li>
                       <li><a class="dropdown-item" href="${pageContext.request.contextPath}/shop?command=find_products_category_brand&category=1&brand=1">ASRock</a></li>
                       <li><a class="dropdown-item" href="${pageContext.request.contextPath}/shop?command=find_products_category_brand&category=1&brand=2">Gigabyte</a></li>
                       <li><a class="dropdown-item" href="${pageContext.request.contextPath}/shop?command=find_products_category_brand&category=1&brand=3">ASUS</a></li>
                       <li><a class="dropdown-item" href="${pageContext.request.contextPath}/shop?command=find_products_category_brand&category=1&brand=4">BIOSTAR</a></li>
                       <li><a class="dropdown-item" href="${pageContext.request.contextPath}/shop?command=find_products_category_brand&category=1&brand=5">MSI</a></li>
                     </ul>
                   </li>
                  <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                     ram
                    </a>
                    <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                      <li><a class="dropdown-item" href="${pageContext.request.contextPath}/shop?command=find_products_category&category=2">All ram</a></li>
                      <li><a class="dropdown-item" href="${pageContext.request.contextPath}/shop?command=find_products_category_brand&category=2&brand=6">Crucial</a></li>
                      <li><a class="dropdown-item" href="${pageContext.request.contextPath}/shop?command=find_products_category_brand&category=2&brand=7">Kingston</a></li>


                    </ul>
                  </li>
                  <li class="nav-item dropdown">
                     <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                       power-unit
                     </a>
                     <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                       <li><a class="dropdown-item" href="${pageContext.request.contextPath}/shop?command=find_products_category&category=3">Power-unit</a></li>
                       <li><a class="dropdown-item" href="${pageContext.request.contextPath}/shop?command=find_products_category_brand&category=3&brand=8">Chieftec</a></li>
                       <li><a class="dropdown-item" href="${pageContext.request.contextPath}/shop?command=find_products_category_brand&category=3&brand=9">AeroCool</a></li>

                     </ul>
                   </li>
                   <li class="nav-item dropdown">
                     <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                      hdd
                     </a>
                     <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                       <li><a class="dropdown-item" href="${pageContext.request.contextPath}/shop?command=find_products_category&category=4">All hdd</a></li>
                       <li><a class="dropdown-item" href="${pageContext.request.contextPath}/shop?command=find_products_category_brand&category=4&brand=10">WD</a></li>
                       <li><a class="dropdown-item" href="${pageContext.request.contextPath}/shop?command=find_products_category_brand&category=4&brand=11">Seagate</a></li>

                     </ul>
                   </li>
                   <li class="nav-item dropdown">
                     <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                       cpu
                     </a>
                     <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                       <li><a class="dropdown-item" href="${pageContext.request.contextPath}/shop?command=find_products_category&category=5">All cpu</a></li>
                       <li><a class="dropdown-item" href="${pageContext.request.contextPath}/shop?command=find_products_category_brand&category=5&brand=12">AMD</a></li>
                       <li><a class="dropdown-item" href="${pageContext.request.contextPath}/shop?command=find_products_category_brand&category=5&brand=13">Intel</a></li>

                     </ul>
                   </li>
                   <li class="nav-item dropdown">
                     <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                       cooler
                     </a>
                     <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                     <li><a class="dropdown-item" href="${pageContext.request.contextPath}/shop?command=find_products_category&category=7">All cooler</a></li>

                       <li><a class="dropdown-item" href="${pageContext.request.contextPath}/shop?command=find_products_category_brand&category=7&brand=15">DeepCool</a></li>


                     </ul>
                   </li>
                   <li class="nav-item dropdown">
                     <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                       gpu
                     </a>
                     <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                        <li><a class="dropdown-item" href="${pageContext.request.contextPath}/shop?command=find_products_category&category=8">All gpu</a></li>
                        <li><a class="dropdown-item" href="${pageContext.request.contextPath}/shop?command=find_products_category_brand&category=8&brand=2">Gigabyte</a></li>
                       <li><a class="dropdown-item" href="${pageContext.request.contextPath}/shop?command=find_products_category_brand&category=8&brand=3">ASUS</a></li>
                     </ul>
                   </li>
                   <li class="nav-item dropdown">
                     <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                       case
                     </a>
                     <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                        <li><a class="dropdown-item" href="${pageContext.request.contextPath}/shop?command=find_products_category&category=6">All case</a></li>
                        <li><a class="dropdown-item" href="${pageContext.request.contextPath}/shop?command=find_products_category_brand&category=6&brand=14">Zalman</a></li>
                        <li><a class="dropdown-item" href="${pageContext.request.contextPath}/shop?command=find_products_category_brand&category=6&brand=15">DeepCool</a></li>
                     </ul>
                   </li>
                </ul>
                <form class="d-flex">
                <button type="button" class="btn btn-primary position-relative">
                Basket
                <span class="position-absolute top-0 start-100 translate-middle badge rounded-pill bg-danger">
                  0
                  <span class="visually-hidden">непрочитанные сообщения</span>
                </span>
              </button>
              <button class="btn btn-outline-success" type="submit">Admin Panel</button>
                  <a href="${pageContext.request.contextPath}/shop?command=show_sign_in_page" class="btn btn-outline-success" type="submit">Sign out</a>
                </form>
              </div>
            </div>
         </div>
          </nav>
      </header>
       </div>
    </div>
    <div class="container">

<c:set var="myListSize" value="${products.size()}"/>
       <div class="row">
        <c:forEach var="element" items="${products}" varStatus="stat">

            <c:choose>

                <c:when test="${ stat.count % 3 == 0 && stat.count < myListSize }">

                      <div class="col-sm">
                        <div class="card" style="width: 18rem;">
                          <img class="card-img-top" src=${element.getPhotoLink()} alt="Card image cap">
                          <div class="card-body">
                            <h5 class="card-title">${element.getId()}</h5>
                            <p class="card-text">${element.getName()}</p>

                            <a href="${pageContext.request.contextPath}/shop?command=show_sign_in_page" class="btn btn-primary">add to basket</a>
                            <span class="price">${element.getCost()} BLR</span>
                          </div>
                        </div>
                      </div>
                       </div>
                      <div class="row">

                </c:when>

                <c:when test="${stat.count % 1 == 0  && stat.count < myListSize}">
                    <div class="col-sm">
                          <div class="card" style="width: 18rem;">
                            <img class="card-img-top" src=${element.getPhotoLink()} alt="Card image cap">
                            <div class="card-body">
                              <h5 class="card-title">${element.getId()}</h5>
                              <p class="card-text">${element.getName()}</p>

                              <a href="${pageContext.request.contextPath}/shop?command=show_sign_in_page" class="btn btn-primary">add to basket</a>
                              <span class="price">${element.getCost()} BLR</span>
                            </div>
                          </div>
                        </div>
                </c:when>

                <c:otherwise>
                      <div class="col-sm">
                            <div class="card" style="width: 18rem;">
                              <img class="card-img-top" src="${element.getPhotoLink()}" alt="Card image cap">
                              <div class="card-body">
                                <h5 class="card-title">${element.getId()}</h5>
                                  <p class="card-text">${element.getName()}</p>
                                 <a href="${pageContext.request.contextPath}/shop?command=show_sign_in_page" class="btn btn-primary">add to basket</a>
                                 <span class="price">${element.getCost()} BLR</span>
                              </div>
                            </div>
                          </div>

                        </div>
                </c:otherwise>

            </c:choose>

        </c:forEach>

    </div>


    <!-- Дополнительный JavaScript; выберите один из двух! -->

    <!-- Вариант 1: Bootstrap в связке с Popper -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>

    <!-- Вариант 2: Bootstrap JS отдельно от Popper
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js" integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js" integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13" crossorigin="anonymous"></script>
    -->
  </body>
</html>