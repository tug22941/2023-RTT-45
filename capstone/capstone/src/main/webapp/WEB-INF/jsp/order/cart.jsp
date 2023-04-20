<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="../include/header.jsp" />

<section class="py-5">
    <div class="container text-center">

        <h4 class="pb-4">Cart List: ${orderProducts.size()} Items</h4>

        <table class="table table-striped">
            <thead>
            <tr>-
                <th scope="col">Name</th>
                <th scope="col">Image URL</th>
                <th scope="col">Price</th>
                <th scope="col">Quantity</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${orderProducts}" var="product">
                  <tr>
                  <td>${product.name}</td>
                  <td><image class="w-25" src="${product.image_url}"></image></td>
                  <td>${product.price}</td>
                  <td>${product.quantity}</td>
                  <td>
                      <a href="/order/deleteFromCart/${product.order_products_id}" class="btn btn-danger"  role="button" >Delete</a>
                  </td>
              </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</section>

<jsp:include page="../include/footer.jsp" />