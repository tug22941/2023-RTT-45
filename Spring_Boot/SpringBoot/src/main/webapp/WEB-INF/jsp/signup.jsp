<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="include/header.jsp" />

<section class="py-3">
    <div class="container text-center">
    <!-- If form.id is empty : make header Create Employee"-->
    <c:if test="${empty form.id}">
        <h1>SingUp New User</h1>
    </c:if>
    <!-- If form.id is not empty : make header Edit Employee"-->
    <c:if test="${not empty form.id}">
        <h1>Edit User: ${form.fullName}</h1>
    </c:if>
    </div>
</section>

<section class="pt-5 pb-5">
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-sm-10 col-md-7 col-xl-5">
                <form method="POST" action="/user/signupSubmit">

                    <c:if test="${success}" >
                        <div class="alert alert-success" role="alert">
                            Form Submitted
                        </div>
                    </c:if>

                    <div class="mb-3">
                        <label for="exampleInputEmail1"class="form-label">* Email address</label>
                        <input type="text" placeholder="Email address" name="email"  class="form-control" id="exampleInputEmail1"
                               aria-describedby="emailHelp">
                        <c:if test="${bindingResult.hasFieldErrors('email')}">
                            <c:forEach items="${bindingResult.getFieldErrors('email')}" var="error">
                                <div style="color:red;">${error.getDefaultMessage()}</div>
                            </c:forEach>
                        </c:if>
                    </div>
                    <div class="mb-3">
                        <label for="name" class="form-label">Full Name</label>
                        <input type="text" class="form-control" name="fullName" id="name" aria-describedby="nameHelp">
                        <c:if test="${bindingResult.hasFieldErrors('fullName')}">
                            <c:forEach items="${bindingResult.getFieldErrors('fullName')}" var="error">
                                <div style="color:red;">${error.getDefaultMessage()}</div>
                            </c:forEach>
                        </c:if>
                    </div>
                    <div class="mb-3">
                        <label for="password" class="form-label">Password</label>
                        <input type="password" class="form-control" name="password" id="password" aria-describedby="passwordHelp">
                        <c:if test="${bindingResult.hasFieldErrors('password')}">
                            <c:forEach items="${bindingResult.getFieldErrors('password')}" var="error">
                                <div style="color:red;">${error.getDefaultMessage()}</div>
                            </c:forEach>
                        </c:if>
                    </div>
                    <div class="mb-3">
                        <label for="confirmPassword" class="form-label">Confirm Password</label>
                        <input type="password" class="form-control" name="confirmPassword" id="confirmPassword"
                               aria-describedby="confirmPasswordHelp">
                        <c:if test="${bindingResult.hasFieldErrors('confirmPassword')}">
                            <c:forEach items="${bindingResult.getFieldErrors('confirmPassword')}" var="error">
                                <div style="color:red;">${error.getDefaultMessage()}</div>
                            </c:forEach>
                        </c:if>                    </div>

                    <c:if test="${empty form.id}">
                        <button type="submit" id="create_btn" class="btn btn-primary mt-3 me-2">Create Account</button>
                    </c:if>
                    <c:if test="${not empty form.id}">
                        <button type="submit" id="create_btn" class="btn btn-primary mt-3 me-2">Edit Account</button>
                    </c:if>
                </form>
            </div>
        </div>
    </div>
</section>


<jsp:include page="include/footer.jsp" />

