<jsp:include page="../include/header.jsp" />

<section class="py-5 bg-purple">
    <div class="container text-center">
        <h1>Employee Search</h1>
    </div>
</section>

<section>
    <div class="container py-5 text-center bg-light-purple">
        <div class="row justify-content-center">
            <div class="col-7">
            <form>
                <div class="input-group mb-3">
                  <input type="text" class="form-control" name="search" placeholder="Employee First name" aria-label="Employee First Name" aria-describedby="search">
                  <button class="btn btn-outline-secondary" id="search">Search</button>
                </div>
            </form>
            </div>
        </div>
    </div>
</section>

<section class="py-5 bg-purple">
    <div class="container text-center">
    <table class="table">
      <thead>
        <tr>
          <th scope="col">#</th>
          <th scope="col">First Name</th>
          <th scope="col">Last Name</th>
          <th scope="col">Email</th>
          <th scope="col">Job Title</th>
        </tr>
      </thead>
      <tbody>
        <tr>
          <th scope="row">1</th>
          <td>Homer</td>
          <td>Simpson</td>
          <td>Nuclear Engineer</td>
          <td>Donuts247@Moe.com</td>
        </tr>
      </tbody>
    </table>
    </div>
</section>
<jsp:include page="../include/footer.jsp" />