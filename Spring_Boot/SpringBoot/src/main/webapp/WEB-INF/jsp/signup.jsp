<jsp:include page="include/header.jsp" />

    <section class="py-3">
        <div class="container text-center">
            <h2>Create New User</h2>
        </div>
    </section>


    <section class="py-5">
        <div class="container f-container">
            <form id="formId">
                <div class="row justify-content-center">
                  <div class="mb-3 col-md-6 col-sm-12 col-xl-5">
                    <label for="firstName" class="form-label">First Name</label>
                    <input type="text" class="form-control" id="firstName">
                  </div>
                  <div class="mb-3 col-md-6 col-sm-12 col-xl-5">
                    <label for="lastName" class="form-label">Last Name</label>
                    <input type="text" class="form-control" id="lastName">
                  </div>
                </div>

                <div class="row justify-content-center align-items-center">
                  <div class="mb-3 col-8 col-xl-6">
                    <label for="email" class="form-label">Email address</label>
                    <input type="email" class="form-control" id="emailInput" aria-describedby="emailHelp">
                    <div id="emailHelp" class="form-text"></div>
                  </div>

                  <div class="col-4 mb-3">
                    <label for="country" class="form-label">Country</label>
                    <select id="country" class="form-select" aria-label="Select Country">
                      <option selected>Country</option>
                      <option value="USA">USA</option>
                      <option value="GHAN">Ghana</option>
                      <option value="BZ">Brazil</option>
                      <option value="NZ">New Zealand</option>
                    </select>
                  </div>
                </div>

                <div class="row justify-content-center">
                  <div class="mb-3 col-md-6 col-sm-12 col-xl-5">
                    <label for="password" class="form-label">Password</label>
                    <input type="password" class="form-control" id="password">
                    <div id="password_help" class="form-text"></div>
                  </div>
                  <div class="mb-3 col-md-6 col-sm-12 col-xl-5">
                    <label for="confirmPassword" class="form-label">Confirm Password</label>
                    <input type="password" class="form-control" id="confirmPassword">
                    <div id="confirm_password_help" class="form-text"></div>

                  </div>
                </div>

                <div class="row justify-content-start">
                  <div class="col-2 mb-3 offset-xl-1">
                    <div class="form-check">
                      <input class="form-check-input" type="radio" name="flexRadioDefault" id="male" checked>
                      <label class="form-check-label" for="maleRadio">
                        Male
                      </label>
                    </div>
                  </div>
                  <div class="col-2 mb-3">
                    <div class="form-check">
                      <input class="form-check-input" type="radio" name="flexRadioDefault" id="female">
                      <label class="form-check-label" for="femaleRadio">
                        Female
                      </label>
                    </div>
                  </div>

                </div>

                <div class="row justify-content-start align-items-center">
                  <p class="col-6 col-md-4 col-lg-3 col-xxl-2 offset-xl-1">Favorite Color: </p>
                  <div class="mb-3 form-check col-2 col-lg-2 me-lg-4">
                    <input type="checkbox" class="form-check-input" id="redCheck">
                    <label class="form-check-label" for="redCheck">Red</label>
                  </div>
                  <div class="mb-3 form-check col-2 col-lg-2 me-lg-4">
                    <input type="checkbox" class="form-check-input" id="blueCheck">
                    <label class="form-check-label" for="blueCheck">Blue</label>
                  </div>
                  <div class="mb-3 form-check col-2 col-lg-2">
                    <input type="checkbox" class="form-check-input" id="greenCheck">
                    <label class="form-check-label" for="greenCheck">Green</label>
                  </div>
                </div>

                <div class="row justify-content-center">
                  <div class="col col-4">
                    <button type="button" class="btn btn-success" onclick="formSubmit()" >Submit</button>
                  </div>
                  <div class="col col-4">
                    <button type="button" class="btn btn-danger" onclick="cancelClick()">Cancel</button>
                  </div>
                </div>

              </form>
        </div>
    </section>

    <script
      src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
      integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
      crossorigin="anonymous"
    ></script>
    <script
      src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"
      integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
      crossorigin="anonymous"
    ></script>
    <script
      src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"
      integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
      crossorigin="anonymous"
    ></script>
    <script>

        // console.log(email);
        // if(email.value == ""){
        //     alert("Email is required!");
        //     email.classList.add("is-invalid");
        //     email.value = "Enter your email";
        //     email.style.cssText = "color:red";
        // }

        let firstName = document.getElementById("firstName");
        let lastName = document.getElementById("lastName");
        let email = document.getElementById("emailInput");
        let country = document.getElementById("country");
        let password = document.getElementById("password");
        let passwordHelp = document.getElementById("password_help");
        let confirm_password = document.getElementById("confirmPassword");
        let confirm_passwordHelp = document.getElementById("confirm_password_help");


        function formSubmit(){

            if(password.value != confirm_password.value){
                passwordHelp.textContent = "Passwords must match";
                passwordHelp.style.cssText = "color:red";
                confirm_passwordHelp.textContent = "Passwords must match";
                confirm_passwordHelp.style.cssText = "color:red";
            }
            else if(password.length <8){
                alert("Passwords must be at least 8 characters long!")
            }
            if(checkEmpty!!)

            checkCountry(country);
        }

        function checkEmpty(element){
            if(element.value == ""){
                element.classList.add("is-invalid");
                element.value = `Enter valid input`;
                element.style.cssText = "color:red";
                alert("Required Input field can not be blank!")
                return false;
            }else{return true;}
        }
        function checkCountry(country){
            if( country.value == "Country"){
                alert("Country must be selected!")
                country.style.cssText = "color:red";
                country.style.cssText = "color:red";
            }
        }

        function passWordMatch(){}

        function cancelClick(){
            //alert("Canceled Clicked!");

            let items = document.querySelectorAll(".is-invalid");
            for(i in items){
                console.log(i);
                i.classList.remove("is-invalid");
            }
        }

    </script>

<jsp:include page="include/footer.jsp" />

