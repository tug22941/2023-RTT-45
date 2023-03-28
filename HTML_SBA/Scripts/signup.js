let firstName = document.getElementById("txtFirstName");
let lastName = document.getElementById("txtLastName");
let email = document.getElementById("txtEmail");
let password = document.getElementById("txtPassowrd");
let confirmPassword = document.getElementById("txtConfirmPassword");
let phone = document.getElementById("txtPhoneNumber");
let company = document.getElementById("txtCompany");
let address1 = document.getElementById("txtAddressLine1");
let address2 = document.getElementById("txtAddressLine2");
let country = document.getElementById("ddlCountry");
let state = document.getElementById("txtState");
let city = document.getElementById("txtCity");
let zipcode = document.getElementById("txtZipCode");
let submit = document.getElementById("btnSubmit");

submit.addEventListener("click", function(){

    const emailRE = new RegExp(/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/);
    const validEmail = email.value.match(emailRE);
    if(validEmail){
        console.log("Valid Email");
    }else{ console.log("Invalid Email");}

});

// functions
function submitForm(){

}

function IsBlank(element){
    if(element.value == ""){return true;}
    else{return false;}
}
