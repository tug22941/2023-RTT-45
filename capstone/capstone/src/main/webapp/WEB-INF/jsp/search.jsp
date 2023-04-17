<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="include/header.jsp"/>

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
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${productsList}" var="product">

                <script>
                    function toDetails() {
                        location.href = "/product/detail/${product.id}";
                    }
                </script>

                <tr>
                    <td>${product.id}</td>
                    <td>${product.name}</td>
                    <td>${product.description}</td>
                    <td>${product.price}</td>
                    <td>${product.productType}</td>
                    <td>${product.imageUrl}</td>
                    <td><a href="/product/detail/${product.id}">Product Details</a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</section>

<jsp:include page="include/footer.jsp"/>