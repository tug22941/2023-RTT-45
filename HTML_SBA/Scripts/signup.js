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
let zipcode = docuemnt.getElementById("txtZipCode");

function IsBlank(element){
    if(element.value == ""){return true;}
    else{return false;}
}