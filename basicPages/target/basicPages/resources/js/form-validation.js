/**
 * 
 */
$(function() {
  // Initialize form validation on the registration form.
  // It has the name attribute "registration"
  $("#userReg").validate({
    // Specify validation rules
    rules: {
     
      name: "required",
      dob: "required",
      password:'required',
      confirmPassword:'required',
      userType:'required',
      email: {
        required: true,
        email: true
      },   
      password : {
          minlength : 8,
          maxlength :12
      },
      cpassword : {
          minlength : 8,
          maxlength :12,
          equalTo : "#password"
      }
    },
   
    messages: {
      name: "Please enter your name",
      dob: "Please enter your date of birth",
     userType:"Please select one role",
      email: "Please enter a valid email address",
      password:"Please enter a password",
      confirmPassword:"please verify above password"
    },
  
    submitHandler: function(form) {
      form.submit();
    }
  });
});