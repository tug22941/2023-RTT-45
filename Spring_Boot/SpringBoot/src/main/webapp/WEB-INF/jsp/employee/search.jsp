<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
                    <input type="text" class="form-control" name="firstName" placeholder="Employee First Name"
                    aria-label="Employee First Name" value="${searchParamFirst}">
                </div>
                <div class="input-group mb-3">
                    <input type="text" class="form-control" name="lastName" placeholder="Employee Last Name"
                    aria-label="Employee Last Name" value="${searchParamLast}">
                </div>
                <button class="btn btn-outline-secondary" id="search">Search</button>
            </form>
            </div>
        </div>
    </div>
</section>

<section class="py-5 bg-purple">
    <div class="container text-center">

    <h4 class="pb-4">${employeesList.size()} Search Results </h4>

    <table class="table table-striped">
        <thead>
            <tr>
                <th scope="col">ID #</th>
                <th scope="col">First Name</th>
                <th scope="col">Last Name</th>
                <th scope="col">Email</th>
                <th scope="col">Job Title</th>
            </tr>
        </thead>
        <tbody>
        <c:forEach items="${employeesList}" var="emp">
            <tr>
                <td><a href="/employee/detail/${emp.id}">${emp.id}</a></td>
                <td>${emp.firstName}</td>
                <td>${emp.lastName}</td>
                <td>${emp.email}</td>
                <td>${emp.jobTitle}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    </div>
</section>

<jsp:include page="../include/footer.jsp" />