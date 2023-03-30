<jsp:include page="include/header.jsp" />
<link rel="stylesheet" href="/pub/css/signup.css" />
<script type="text/javascript" src="/pub/js/signup.js"></script>

<!-- Content Header-->
    <section class="py-3">
        <div class="container text-center">
            <h2>New Account</h2>
        </div>
    </section>

  <!-- Content -->
    <section class="py-2">
        <div class="container f-container">
            <form id="formId">
                <div class="row justify-content-center">
                  <div class="mb-3 col-md-6 col-sm-12 col-xl-5">
                    <label for="txtFirstName" class="form-label">First Name <small>Required</small></label>
                    <input type="text" class="form-control input reqInput" id="txtFirstName">
                    <small id="firstNameHelp" class="form-text text-danger field"></small>
                  </div>
                  <div class="mb-3 col-md-6 col-sm-12 col-xl-5">
                    <label for="txtLastName" class="form-label">Last Name <small>Required</small></label>
                    <input type="text" class="form-control input reqInput" id="txtLastName">
                    <small id="lastNameHelp" class="form-text text-danger field"></small>
                  </div>
                </div>

                <div class="row justify-content-center align-items-center">
                    <div class="mb-3 col-md-6 col-sm-12 col-xl-5">
                      <label for="txtemail" class="form-label">Email Address <small>Required</small></label>
                      <input type="email" class="form-control input reqInput" id="txtEmail" aria-describedby="emailHelp">
                      <small id="emailHelp" class="form-text text-danger field"></small>
                    </div>

                  <div class="mb-3 col-md-6 col-sm-12 col-xl-5">
                    <!-- empty column for styling-->
                  </div>

                </div>

                <div class="row justify-content-center">
                    <div class="mb-3 col-md-6 col-sm-12 col-xl-5">
                      <label for="txtPassword" class="form-label">Password <small>Required</small></label>
                      <input type="password" class="form-control input reqInput" id="txtPassword">
                      <small id="passwordHelp" class="form-text text-danger field"></small>
                    </div>
                    <div class="mb-3 col-md-6 col-sm-12 col-xl-5">
                      <label for="txtConfirmPassword" class="form-label">Confirm Password<small>Required</small></label>
                      <input type="password" class="form-control input-group input reqInput" id="txtConfirmPassword">
                      <small id="confirmPasswordHelp" class="form-text text-danger field"></small>
                    </div>
                </div>

                <div class="row justify-content-center">
                    <div class="mb-3 col-md-6 col-sm-12 col-xl-5">
                      <label for="txtPhoneNumber" class="form-label">Phone Number<small>Required</small></label>
                      <input type="text" class="form-control input reqInput" id="txtPhoneNumber">
                      <small id="phoneNumberHelp" class="form-text text-danger field"></small>
                    </div>
                    <div class="mb-3 col-md-6 col-sm-12 col-xl-5">
                        <label for="txtCompany" class="form-label">Company</label>
                        <input type="text" class="form-control input" id="txtCompany">
                        <small id="companyHelp" class="form-text text-danger field"></small>
                      </div>
                </div>

                <div class="row justify-content-center">
                    <div class="mb-3 col-md-6 col-sm-12 col-xl-5">
                        <label for="txtAddressLine1" class="form-label">Address Line 1<small>Required</small></label>
                        <input type="text" class="form-control input reqInput" id="txtAddressLine1">
                        <small id="addressLine1Help" class="form-text text-danger field"></small>
                      </div>
                    <div class="mb-3 col-md-6 col-sm-12 col-xl-5">
                      <label for="txtAddressLine2" class="form-label">Address Line 2</label>
                      <input type="text" class="form-control input" id="txtAddressLine2">
                      <small id="addressLine2Help" class="form-text text-danger field"></small>
                    </div>
                </div>

                <div class="row justify-content-center align-items-center">
                    <div class="mb-3 col-md-6 col-sm-12 col-xl-5">
                        <label for="ddlCountry" class="form-label">Country <small>Required</small></label>
                        <select id="ddlCountry" class="form-select form-control input reqInput">
                            <option selected></option>
                            <option value="USA">USA</option>
                            <option value="GHAN">Ghana</option>
                            <option value="BZ">Brazil</option>
                            <option value="NZ">New Zealand</option>
                        </select>
                        <small id="countryHelp" class="form-text text-danger field"></small>

                    </div>

                    <div class="mb-3 col-md-6 col-sm-12 col-xl-5">
                        <label for="txtState" class="form-label">State <small>Required</small></label>
                        <input type="text" class="form-control input reqInput" id="txtState">
                        <small id="stateHelp" class="form-text text-danger field"></small>
                    </div>
                </div>

                <div class="row justify-content-center">
                    <div class="mb-3 col-md-6 col-sm-12 col-xl-5">
                      <label for="txtCity" class="form-label">City <small>Required</small></label>
                      <input type="text" class="form-control input reqInput" id="txtCity">
                      <small id="cityHelp" class="form-text text-danger field"></small>
                    </div>
                    <div class="mb-3 col-md-6 col-sm-12 col-xl-5">
                      <label for="txtZipCode" class="form-label">Zip Code<small>Required</small></label>
                      <input type="text" class="form-control input reqInput" id="txtZipCode">
                      <small id="zipCodeHelp" class="form-text text-danger field"></small>
                    </div>
                  </div>

                  <div class="row justify-content-center align-items-center">
                    <div class="mb-3 col-md-6 col-sm-12 col-xl-5">
                      <div class="form-check">
                        <input class="form-check-input" type="radio" name="flexRadioDefault" id="flexRadioDefault1">
                        <label class="form-check-label" for="flexRadioDefault1">
                          Sign Up With Free Membership
                        </label>
                      </div>
                    </div>

                  <div class="mb-3 col-md-6 col-sm-12 col-xl-5">
                    <div class="form-check">
                      <input class="form-check-input" type="radio" name="flexRadioDefault" id="flexRadioDefault2" checked>
                      <label class="form-check-label" for="flexRadioDefault2">
                        Sign Up With Premium Membership
                      </label>
                    </div>
                  </div>

                </div>


                <div class="row justify-content-center">
                  <div class="col col-4 text-center">
                    <button type="button" class="btn btn-success w-75" id="btnSubmit">Create Account</button>
                  </div>
                </div>

              </form>
        </div>
    </section>

    This is my signup page
<jsp:include page="include/footer.jsp" />
