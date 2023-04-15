<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="../include/header.jsp" />

<section class="py-3" style="background-color:#AFCCFF">
    <div class="container text-center">
        <h2>Log In</h2>
    </div>
</section>

<c:if test="${param['error'] != null}">
    <section class="pt-5 bg-light-grey">
        <div class="container">
            <div class="row justify-content-center">
                <div class="col-sm-10 col-md-7 col-xl-5">
                    <div class="alert alert-danger" role="alert">
                        Invalid Username or Password
                    </div>
                </div>
            </div>
        </div>
    </section>
</c:if>

<section class="pt-5 pb-5">
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-sm-10 col-md-7 col-xl-5">
                <form method="POST" action="/login/loginpost">
                    <div class="mb-3">
                        <label class="form-label">Email</label>
                        <input type="text" name="username"  class="form-control">
                    </div>
                    <div class="mb-3">
                        <label class="form-label">Password</label>
                        <input type="text" name="password"  class="form-control">
                    </div>
                    <div class="mb-3 text-center">
                        <button type="submit" id="create_btn" class="btn btn-primary mt-3 me-2">Submit</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</section>

<jsp:include page="../include/footer.jsp" />