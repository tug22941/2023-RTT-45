<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="../include/header.jsp"/>

<script>
    function toEdits() {
        location.href = "/product/edit/${product.id}";
    }
</script>

<style>
    a {
        color: black;
        text-decoration: none;
    }
</style>

<section py-5 bg-dark-grey>
    <div class="container text-center">
        <h1>Product Details</h1>
    </div>
</section>

<c:if test="${cartUpdated}">
    <section class="bg-light-grey text-center">
        <div class="container">
            <div class="row justify-content-center">
                <div class="col-sm-10 col-md-7 col-xl-5">
                    <div class="alert alert-success" role="alert">
                        Your Order Has Been Updated
                    </div>
                </div>
            </div>
        </div>
    </section>
</c:if>

<section class="py-5 bg-purple">
    <div class="container text-center d-flex">
        <table class="table table-striped">
            <tbody>
            <sec:authorize access="hasAnyAuthority('ADMIN')">
            <tr>
                <td>Edit Product</td>
                <td>
                    <button type="button" class="btn btn-sm btn-danger" onclick="toEdits()">Edit Product Details</button>
                </td>
            </tr>
            </sec:authorize>
            <tr>
                <td>ID #</td>
                <td>${product.id}</td>
            </tr>
            <tr>
                <td>Name</td>
                <td>${product.name}</td>
            </tr>
            <tr>
                <td>Description</td>
                <td>${product.description}</td>
            </tr>
            <tr>
                <td>price</td>
                <td>${product.price}</td>
            </tr>
            <tr>
                <td>type</td>
                <td>${product.productType}</td>
            </tr>
            <tr>
                <td>Image</td>
                <td><img src="${product.imageUrl}" class="w-50"/></td>
            </tr>
            <form action="/order/addToCart/${product.id}">
            <tr>
                <td>Quantity</td>
                <td>
                    <select class="form-select text-center" aria-label="Select Quantity" name="quantity" value="${quantity}">
                        <option value="0" selected >No Quantity Selected</option>
                        <option value="1" <c:if test="${quantity eq 1}">selected</c:if>>1</option>
                        <option value="2" <c:if test="${quantity eq 2}">selected</c:if>>2</option>
                        <option value="3" <c:if test="${quantity eq 3}">selected</c:if>>3</option>
                        <option value="4" <c:if test="${quantity eq 4}">selected</c:if>>4</option>
                    </select>
                    <c:if test="${bindingResult.hasFieldErrors('quantity')}">
                        <c:forEach items="${bindingResult.getFieldErrors('quantity')}" var="error">
                            <div style="color:red;">${error.getDefaultMessage()}</div>
                        </c:forEach>
                    </c:if>
                </td>
                <td>
                    <input type="hidden" name="quantity" value="${quantity}"/>
                    <input type="hidden" name="orderId" value="${orderId}"/>
                    <button class="btn btn-sm btn-warning" name="id">Add to Cart</button>
                </td>
            </tr>
            </form>
            </tbody>
        </table>
    </div>
</section>

<jsp:include page="../include/footer.jsp"/>