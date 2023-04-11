<jsp:include page="../include/header.jsp" />

<style>
    a{
        color:black;
        text-decoration:none;
    }
</style>

<section py-5 bg-dark-grey>
    <div class="container text-center">
        <h1>User Detail</h1>
    </div>
</section>

<script>
    function toEdits(){
        location.href="/user/edit/${product.id}";
    }
</script>

<section class="py-5 bg-purple">
    <div class="container text-center d-flex">
        <table class="table table-striped">
            <tbody>
            <tr>
                <td>Edit Product</td>
                <td>
                    <button type="button" class="btn btn-sm btn-danger" onclick="toEdits()">Edit User Details</button>
                </td>
            </tr>
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
                <td>${prodcut.price}</td>
            </tr>
            <tr>
                <td>type</td>
                <td>${product.productType}</td>
            </tr>
            <tr>
                <td>Image</td>
                <td><img src="${product.imageUrl}" class="w-50"/></td>
            </tr>
            </tbody>
        </table>
    </div>
</section>

<jsp:include page="../include/footer.jsp" />