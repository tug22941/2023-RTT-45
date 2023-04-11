<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="../include/header.jsp" />

<section class="py-3">
    <div class="container text-center">
        <h2>Product Search</h2>
    </div>
</section>

<section class="py-5">
    <div class="container text-center">

        <h4 class="pb-4">${productsList.size()} Search Results </h4>

        <table class="table table-striped">
            <thead>
            <tr>
                <th scope="col">Product ID</th>
                <th scope="col">Name</th>
                <th scope="col">Description</th>
                <th scope="col">Price</th>
                <th scope="col">Product Type</th>
                <th scope="col">Image URL</th>
                <th scope="col">Quantity</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${productsList}" var="product">
                <tr>
                    <td>${product.id}</td>
                    <td><a href="/product/detail/${product.id}">${product.name}</a></td>
                    <td>${product.description}</td>
                    <td>${product.price}</td>
                    <td>${product.productType}</td>
                    <td>${product.imageUrl}</td>
                    <form action="/product/addToCart/${product.id}">
                    <td>
                        <select class="form-select" aria-label="Select Quantity" name="count" value = "${count}">
                            <option selected >0</option>
                            <option value="1">1</option>
                            <option value="2">2</option>
                            <option value="3">3</option>
                            <option value="4">4</option>
                        </select>
                    </td>
                    <td>
                        <input type="hidden" name="count" value="${count}"/>
                        <input type="hidden" name="orderId" value="${orderId}"/>
                        <input type="hidden" name="search" value="${search}"/>
                        <button class="btn btn-sm btn-warning" name="id">Add to Cart</button>
                    </td>
                    </form>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</section>

<jsp:include page="../include/footer.jsp" />