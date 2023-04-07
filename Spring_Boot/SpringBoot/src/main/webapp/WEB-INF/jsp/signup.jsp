<jsp:include page="include/header.jsp" />

<section class="py-3">
    <div class="container text-center">
        <h2>Create New User</h2>
    </div>
</section>


<section class="pt-5 pb-5">
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-sm-10 col-md-7 col-xl-5">
                <form method="POST" action="/signup">
                    <div class="mb-3">
                        <label for="exampleInputEmail1"class="form-label">* Email address</label>
                        <input type="text" placeholder="Email address" name="email"  class="form-control" id="exampleInputEmail1"
                               aria-describedby="emailHelp">
                        <div id="emailHelp" class="form-text">We'll never share your email with anyone else.</div>
                    </div>
                    <div class="mb-3">
                        <label for="name" class="form-label">Full Name</label>
                        <input type="text" class="form-control" name="fullName" id="name" aria-describedby="nameHelp">
                        <div id="nameHelp" class="form-text">Let us know who you are</div>
                    </div>
                    <div class="mb-3">
                        <label for="password" class="form-label">Password</label>
                        <input type="password" class="form-control" name="password" id="password" aria-describedby="passwordHelp">
                        <div id="passwordHelp" class="form-text">Minimum 8 characaters with uppercase, lowercase,
                            and a number</div>
                    </div>
                    <div class="mb-3">
                        <label for="confirmPassword" class="form-label">Confirm Password</label>
                        <input type="password" class="form-control" name="confirmPassword" id="confirmPassword"
                               aria-describedby="confirmPasswordHelp">
                        <div id="confirmPasswordHelp" class="form-text">Re-enter your password.</div>
                    </div>


                    <button type="submit" id="create_btn" class="btn btn-primary mt-3 me-2">Create Account</button>
                </form>
            </div>
        </div>
    </div>
</section>


<jsp:include page="include/footer.jsp" />

