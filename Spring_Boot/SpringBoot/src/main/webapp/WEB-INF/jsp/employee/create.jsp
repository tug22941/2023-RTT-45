<jsp:include page="../include/header.jsp" />

<section class="py-5 bg-purple">
    <div class="container text-center">
        <h1>Create New Employee</h1>
    </div>
</section>

<section>
    <div class="container py-5 bg-light-purple">
        <div class="row justify-content-center">
            <div class="col-10">
           <form>
             <div class="mb-3">
                <label for="firstName" class="form-label">First Name</label>
                <input type="text" class="form-control" id="firstName" aria-describedby="firstName">
             </div>
              <div class="mb-3">
                 <label for="lastName" class="form-label">Last Name</label>
                 <input type="text" class="form-control" id="lastName" aria-describedby="lastName">
              </div>
                <div class="mb-3">
                 <label for="extension" class="form-label">Extension</label>
                 <input type="text" class="form-control" id="extension" aria-describedby="extension">
               </div>
               <div class="mb-3">
                 <label for="email" class="form-label">Email address</label>
                 <input type="email" class="form-control" id="email" aria-describedby="email">
               </div>
            <div class="mb-3">
              <label for="jobTitle" class="form-label">Job Title</label>
              <input type="text" class="form-control" id="jobTitle" aria-describedby="jobTitle">
            </div>
           <div class="mb-3">
             <label for="vacationHours" class="form-label">Vacation Hours</label>
             <input type="text" class="form-control" id="vacationHours" aria-describedby="vacationHours">
           </div>
             <button type="submit" class="btn btn-primary">Submit</button>
           </form>
            </div>
        </div>
    </div>
</section>

<jsp:include page="../include/footer.jsp" />