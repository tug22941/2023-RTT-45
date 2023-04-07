
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
    if(checkEmpty)

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
