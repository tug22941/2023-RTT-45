<jsp:include page="../include/header.jsp" />

<link rel="stylesheet" href="/pub/css/signin.css" />
<script type="text/javascript" src="/pub/js/signin.js"></script>

<section>
    <div class="row align-items-center fill">
        <form class="form-signin" method="POST" action="/login/loginpost">
            <h1 class="h3 mb-3 font-weight-normal text-center">Please sign in</h1>
            <label for="inputEmail" class="sr-only">Email address</label>
            <input
                    type="text"
                    id="inputEmail"
                    class="form-control"
                    placeholder="Email address"
                    name="username"
                    required
                    autofocus
            />
            <label for="inputPassword" class="sr-only">Password</label>
            <input
                    type="text"
                    id="inputPassword"
                    class="form-control"
                    placeholder="Password"
                    name="password"
                    required
            />
            <div class="checkbox mb-3 text-center">
                <label>
                    <input type="checkbox" value="remember-me" /> Remember me
                </label>
            </div>
            <button class="btn btn-lg btn-primary btn-block" type="submit">
                Sign in
            </button>
            <p class="mt-5 mb-3 text-muted text-center">&copy; 2023 - 2024</p>
        </form>
    </div>
</section>



<jsp:include page="../include/footer.jsp" />