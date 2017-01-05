/**
 * this validation contains whether password is has one capital latter 
 * one small latter and special character and length is between 8-12
 */
$('#cpassword,#password').on('keyup',function(){
	var confirm=$('#cpassword').val();
	var password=$('#password').val();
	
		if(confirm===password){
			$("#message").html('Matching').css('color','green');
		}else
			$("#message").html('Not Matching').css('color','red');
	
})