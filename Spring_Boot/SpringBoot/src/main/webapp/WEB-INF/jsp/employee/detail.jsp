<jsp:include page="../include/header.jsp" />

<style>
a{
  color:black;
  text-decoration:none;
}
</style>

<section py-5 bg-dark-grey>
    <div class="container text-center">
        <h1>Employee Detail</h1>
    </div>
</section>

<section class="py-5 bg-purple">
    <div class="container text-center">
        <table class="table table-striped">
            <tbody>
                <tr>
                    <td>ID #</td>
                    <td>${employee.id}</td>
                </tr>
                <tr>
                    <td>First Name</td>
                    <td><a href="/employee/search?firstName=${employee.firstName}">${employee.firstName}</a></td>
                </tr>
                <tr>
                    <td>LastName</td>
                    <td><a href="/employee/search?lastName=${employee.lastName}">${employee.lastName}</a></td>
                </tr>
                <tr>
                    <td>Extension</td>
                    <td>${employee.extension}</td>
                </tr>
                <tr>
                    <td>Email</td>
                    <td>${employee.email}</td>
                </tr>
                <tr>
                    <td>Job Title</td>
                    <td>${employee.jobTitle}</td>
                </tr>
                <tr>
                    <td>Vacation Hours</td>
                    <td>${employee.vacationHours}</td>
                </tr>
            </tbody>
        </table>
    </div>
</section>

<jsp:include page="../include/footer.jsp" />