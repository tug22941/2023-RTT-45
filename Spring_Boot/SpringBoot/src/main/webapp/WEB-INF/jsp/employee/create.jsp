<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../include/header.jsp" />

<section class="py-5 bg-purple">
    <div class="container text-center">
        <!-- If form.id is empty : make header Create Employee"-->
        <c:if test="${empty form.id}">
            <h1>Create Employee</h1>
        </c:if>
        <!-- If form.id is not empty : make header Edit Employee"-->
        <c:if test="${not empty form.id}">
            <h1>Edit Employee</h1>
        </c:if>
    </div>
</section>

<section>
    <div class="container py-5 bg-light-purple">
        <div class="row justify-content-center">
            <div class="col-10">
           <form action="/employee/createSubmit">
               <input type="hidden" name="id" value="${form.id}"/>
             <div class="mb-3">
                <label for="firstName" class="form-label">First Name</label>
                <input type="text" class="form-control" id="firstName" name="firstName"  value="${form.firstName}"  aria-describedby="firstName">
             </div>
              <div class="mb-3">
                 <label for="lastName" class="form-label">Last Name</label>
                 <input type="text" class="form-control" id="lastName" name="lastName" value="${form.lastName}" aria-describedby="lastName">
              </div>
                <div class="mb-3">
                   <label for="office" class="form-label">Office</label>
                   <select id="office" name="officeId" class="form-select">
                       <c:forEach items="${offices}" var="office">
                            <option value="${office.id}"
                                    <c:if test="${office.id eq form.officeId}">
                                        selected
                                    </c:if>
                            >${office.city}</option>
                       </c:forEach>
                   </select>
                </div>
                <div class="mb-3">
                 <label for="extension" class="form-label">Extension</label>
                 <input type="text" class="form-control" id="extension"  name="extension" value="${form.extension}"  aria-describedby="extension">
               </div>
               <div class="mb-3">
                 <label for="email" class="form-label">Email address</label>
                 <input type="email" class="form-control" id="email" name="email"  value="${form.email}" placeholder="example@site.com" aria-describedby="email">
               </div>
            <div class="mb-3">
              <label for="jobTitle" class="form-label">Job Title</label>
              <input type="text" class="form-control" id="jobTitle" name="jobTitle" value="${form.jobTitle}" aria-describedby="jobTitle">
            </div>
           <div class="mb-3">
             <label for="vacationHours" class="form-label">Vacation Hours</label>
             <input type="number" class="form-control" id="vacationHours" name="vacationHours" value="${form.vacationHours}" aria-describedby="vacationHours">
           </div>
             <button type="submit" class="btn btn-primary">Submit</button>
           </form>
            </div>
        </div>
    </div>
</section>

<jsp:include page="../include/footer.jsp" />