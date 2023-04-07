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

<script>
    function toEdits(){
        location.href="/employee/edit/${employee.id}";
    }
</script>

<section class="py-5 bg-purple">
    <div class="container text-center d-flex">
        <table class="table table-striped">
            <tbody>
            <tr>
                <td>Edit Employee</td>
                <td>
                    <button type="button" class="btn btn-sm btn-danger" onclick="toEdits()">Edit Employee Details</button>
                </td>
            </tr>
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
                <tr>
                    <td>Profile Image</td>
                    <td><img src="${employee.profileImage}" class="w-50"/></td>
                </tr>
            </tbody>
        </table>
    </div>
</section>

<jsp:include page="../include/footer.jsp" />