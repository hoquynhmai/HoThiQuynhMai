<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 10/7/2020
  Time: 4:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css"
          integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p" crossorigin="anonymous"/>
    <link rel="stylesheet" href="library/bootstrap413/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="library/datatables/css/dataTables.bootstrap4.min.css"/>
</head>
<body>
<div class="container-fluid">>
    <div class="row  bg-dark">
        <div class="col-lg-6 text-left">
            <a href="/home?action=''" class="btn btn-danger"><i class="fas fa-home"></i></a>
            <a href="#" class="btn btn-success" data-toggle="modal" data-target="#addModal"><i class="fas fa-plus">&#xE147;</i>
                <span>Add New product</span></a>
        </div>
        <div class="col-lg-6 text-right">
            <form action="/home" method="post">
                <input type="hidden" name="action" value="search">
                <input type="search" name="nameProduct" placeholder="search product name">
                <input type="search" name="price" placeholder="search product price">
                <input type="submit" value="Search">
            </form>
        </div>
    </div>
    <div class="row">
        <div class="col-lg-12">
            <c:if test="${message!=null}">
                <h2 style="color: red"><c:out value="${message}"/></h2>
            </c:if>
            <table class="table table-bordered" id="tableProduct" style="width:100%">
                <thead>
                <tr>
                    <th style="text-align: center">STT</th>
                    <th>Product Name</th>
                    <th style="text-align: center">Price</th>
                    <th style="text-align: center">Quantity</th>
                    <th>Color</th>
                    <th>Description</th>
                    <th>Category</th>
                    <th>Action</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="product" items="${productList}">
                    <tr>
                        <td><c:out value='${product.productId}'/></td>
                        <td id="${product.productId}Name"><c:out value='${product.productName}'/></td>
                        <td id="${product.productId}Price"><c:out value='${product.price}'/></td>
                        <td id="${product.productId}Quantity"><c:out value='${product.quantity}'/></td>
                        <td id="${product.productId}Color"><c:out value='${product.color}'/></td>
                        <td id="${product.productId}Description"><c:out value='${product.description}'/></td>
                        <td id="${product.productId}Category">
                        <c:forEach var="category" items="${categoryList}">
                            <c:if test="${category.categoryId.equals(product.categoryId)}">
                                    <c:out value="${category.categoryName}"/>
                            </c:if>
                        </c:forEach>
                        </td>
                        <td>
                            <a href="#" id="${product.productId}edit" class="edit"
                               onclick="editRow('${product.productId}')">
                                <i class="fas fa-pen" style="color: red" data-toggle="tooltip" title="Edit">&#xE254;</i></a>
                            <a href="#" id="${product.productId}save" class="edit"
                               onclick="saveRow('${product.productId}')" style="display: none">
                                <i class="far fa-save" style="color: red" data-toggle="tooltip"
                                   title="Save">&#xE254;</i></a>
                            <a href="#" class="delete" data-toggle="modal" data-target="#deleteProduct"
                               onclick="setId('${product.productId}','${product.productName}')">
                                <i class="fas fa-trash-alt" style="color: red" data-toggle="tooltip" title="Delete">&#xE872;</i></a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
<form action="/home" method="post" id="deleteForm">
    <input type="hidden" name="action" value="delete">
    <input type="hidden" name="id" id="idProduct">
</form>
<div class="modal fade" id="deleteProduct" tabindex="-1" role="dialog" aria-labelledby="deleteModalLabel"
     aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="deleteModalLabel">DELETE</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <input type="text" id="modelName" size="50" disabled style="border: none;background: white">
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                <button type="button" class="btn btn-primary" onclick="submitDelete()">Delete</button>
            </div>
        </div>
    </div>
</div>

<div class="modal fade" id="addModal" tabindex="-1" role="dialog" aria-labelledby="addModalProduct"
     aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="addModalProduct">ADD PRODUCT</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <c:if test="${message!=null}">
                    <h2 style="color: red"><c:out value="${message}"/></h2>
                </c:if>
                <form action="/home" method="post" id="addProduct">
                    <input type="hidden" name="action" value="create">
                    <table>
                        <tr>
                            <td><label for="productName">Name product: </label></td>
                            <td><input type="text" name="productName" id="productName" value="<c:out value='${product.productName}'/>" required>
                            </td>
                        </tr>
                        <tr>
                            <td><label for="price">Price: </label></td>
                            <td><input type="text" name="price" id="price" value='<c:out value="${product.price}"/>' required>
                            </td>
                        </tr>
                        <tr>
                            <td><label for="quantity">Quantity: </label></td>
                            <td><input type="text" name="quantity" id="quantity" value='<c:out value="${product.quantity}"/>' required>
                            </td>
                        </tr>
                        <tr>
<%--                            <input type="text" name="color" id="color" value='<c:out value="${product.color()}"/>'>--%>
                            <td><label for="color">Color: </label></td>
                            <td>
                                <select name="color" id="color">
                                    <option value="Purple">Purple</option>
                                    <option value="White">White</option>
                                    <option value="Blue">Blue</option>
                                    <option value="Black">Black</option>
                                    <option value="Red">Red</option>
                                    <option value="Green">Green</option>
                                    <option value="Ceramic Black">Ceramic Black</option>
                                    <option value="Violet">Violet</option>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td><label for="Description">Description: </label></td>
                            <td><textarea type="text" name="description" id="Description" value='<c:out value="${product.description}"/>'></textarea>
                            </td>
                        </tr>
                        <tr>
                            <td><label for="category">category: </label></td>
                            <td>
                                <select name="category" id="category">
                                    <c:forEach var="category" items="${categoryList}">
                                        <c:choose>
                                            <c:when test="${category.categoryId.equals(product.categoryId)}">
                                                <option value="<c:out value='${category.categoryId}'/>" selected><c:out value="${category.categoryName}"/></option>
                                            </c:when>
                                            <c:otherwise>
                                                <option value="<c:out value='${category.categoryId}'/>"><c:out value="${category.categoryName}"/></option>
                                            </c:otherwise>
                                        </c:choose>
                                    </c:forEach>
                                </select>
                            </td>
                        </tr>
                    </table>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                <button type="button" class="btn btn-primary" onclick="submitAdd()">Create</button>
            </div>
        </div>
    </div>
</div>



<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
        integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"
        integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN"
        crossorigin="anonymous"></script>
<script src="library/datatables/js/jquery.dataTables.min.js"></script>
<script src="library/datatables/js/dataTables.bootstrap4.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"
        integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV"
        crossorigin="anonymous"></script>
<script>
    $(document).ready(function () {
        $('#tableProduct').dataTable({
            "dom": 'lrtip',
            "lengthChange": false,
            "pageLength": 5
        });
    });
</script>
<script>
    function setId(id, name) {
        document.getElementById("idProduct").value = id;
        document.getElementById("modelName").value = name;
    }

    function submitDelete() {
        document.getElementById("deleteForm").submit();
    }

    function editRow(idEdit) {
        document.getElementById(idEdit + "edit").style.display = "none";
        document.getElementById(idEdit + "save").style.display = "inline";
        <%--id="${product.productId}Name"--%>
        // .innerHTML="<input type='text' name='nameProduct' id=''>";
        let name = document.getElementById(idEdit + "Name");
        let price = document.getElementById(idEdit + "Price");
        let quantity = document.getElementById(idEdit + "Quantity");
        let color = document.getElementById(idEdit + "Color");
        let description = document.getElementById(idEdit + "Description");
        let category = document.getElementById(idEdit + "Category");

        let name_data = name.innerText;
        let price_data = price.innerText;
        let quantity_data = quantity.innerText;
        let color_data = color.innerText;
        let description_data = description.innerText;
        let category_data = category.innerText;

        name.innerHTML = "<input type='text' name='nameProduct' value='" + name_data + "' id='edit" + idEdit + "Name'>";
        price.innerHTML = "<input type='text' name='priceProduct' value='" + price_data + "' id='edit" + idEdit + "Price'>";
        quantity.innerHTML = "<input type='text' name='quantityProduct' value='" + quantity_data + "' id='edit" + idEdit + "Quantity'>";
        color.innerHTML = "<input type='text' name='colorProduct' value='" + color_data + "' id='edit" + idEdit + "Color'>";
        description.innerHTML = "<input type='text' name='descriptionProduct' value='" + description_data + "' id='edit" + idEdit + "Description'>";
        category.innerHTML = "<input type='text' name='categoryProduct' value='" + category_data + "' id='edit" + idEdit + "Category'>";
    }

    function saveRow(idEdit) {
        // let message=document.getElementById("message").innerText;
        // if (message==null) {


        let name_data = document.getElementById("edit" + idEdit + "Name").value;
        let price_data = document.getElementById("edit" + idEdit + "Price").value;
        let quantity_data = document.getElementById("edit" + idEdit + "Quantity").value;
        let color_data = document.getElementById("edit" + idEdit + "Color").value;
        let description_data = document.getElementById("edit"+idEdit + "Description").value;
        let category_data = document.getElementById("edit" + idEdit + "Category").value;


        let name = document.getElementById(idEdit + "Name");
        let price = document.getElementById(idEdit + "Price");
        let quantity = document.getElementById(idEdit + "Quantity");
        let color = document.getElementById(idEdit + "Color");
        let description = document.getElementById(idEdit + "Description");
        let category = document.getElementById(idEdit + "Category");

        name.innerHTML = name_data;
        price.innerHTML = price_data;
        quantity.innerHTML = quantity_data;
        color.innerHTML = color_data;
        description.innerHTML = description_data;
        category.innerHTML = category_data;

        document.getElementById(idEdit + "edit").style.display = "inline";
        document.getElementById(idEdit + "save").style.display = "none";
    }

    function submitAdd() {
        document.getElementById("addProduct").submit();
    }
</script>
</body>
</html>
