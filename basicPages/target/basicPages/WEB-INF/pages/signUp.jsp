<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html lang="en">
<head>

<link rel="stylesheet" href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.7.2/themes/base/jquery-ui.css"/>
<link rel="stylesheet" href="<c:url value="/resources/css/bootstrap-theme.min.css"/>">
<link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.min.css"/>">

<!-- <link href = "https://code.jquery.com/ui/1.10.4/themes/ui-lightness/jquery-ui.css" rel = "stylesheet"> -->

 <title>Sign Up Form</title>
 <meta http-equiv="Content-Type" content="text/html charset=UTF-8" />
<script src='https://www.google.com/recaptcha/api.js'></script>
</head>
<body>
 
<div class="jumbotron page-header">
<h2>Welcome to Teqni home</h2>
</div>
<div class="has-error">
<c:if test="${ not empty message}">
${message}
</c:if>
</div>
<form class="form-horizontal" name="userReg"  id="userReg">
 <div class="form-group">
 <label class="col-sm-2 control-label">Company Name</label>
 <div class="col-sm-4">
 <input  name="companyName" type="text"   class="form-control" id="companyName" placeholder="Name" />
 </div>
</div>
<br>
 <div class="form-group">
 <label class="col-sm-2 control-label">Registration number</label>
 <div class="col-sm-4">
 <input  name="RegNumber" type="number" required="required"  class="form-control" id="regNumber" placeholder="Registration number" />
 </div>
</div>
<br>
 <div class="form-group">
 <label class="col-sm-2 control-label">Address line 1</label>
 <div class="col-sm-4">
 <input  name="line1" type="text" required="required"  class="form-control" id="line1" placeholder="line1" />
 </div>
</div>
<br>
 <div class="form-group">
 <label class="col-sm-2 control-label">Address line 2</label>
 <div class="col-sm-4">
 <input  name="line2" type="text"   class="form-control" id="line2" placeholder="line2" />
 </div>
</div>
<br>
 <div class="form-group">
 <label class="col-sm-2 control-label">Zip code</label>
 <div class="col-sm-4">
 <input  name="zipCode" type="number" required="required"  class="form-control" id="zipCode" placeholder="zip code" />
 </div>
</div>
<br>
 <div class="form-group">
 <label class="col-sm-2 control-label">State</label>
 <div class="col-sm-4">
 <input  name="state" type="text" required="required"  class="form-control" id="state" placeholder="State" />
 </div>
</div>
<br>
 <div class="form-group">
 <label class="col-sm-2 control-label">Country</label>
 <div class="col-sm-4">
 <input  name="country" type="text" required="required"  class="form-control" id="country" placeholder="country" />
 </div>
</div>
      <br>         
 <div class="form-group">
<label class="col-sm-2 control-label">Email</label>
<div class="col-sm-4">
<input name="email" type="email" class="form-control" id="email" placeholder="Email" />
</div>
 </div>
<br>
<div class="form-group">
<label class="col-sm-2 control-label">Date of Birth(dd-mm-yyyy)</label>
<div class="col-sm-4">
<input name="dob"  type="text" class="form-control" id="dob" placeholder="Date of birth" />
</div>
</div>

<br>
<div class="form-group">
<label class="col-sm-2 control-label">Password</label>
<div class="col-sm-4">
<input name="password" id="password" maxlength="12" pattern="((?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{8,12})" required="required" type="password" class="form-control" id="password" placeholder="password" />
</div>
</div>
<br>
<div class="form-group">
<label class="col-sm-2 control-label">Confirm Password</label>
<div class="col-sm-4">
<input name="confirmPassword" id="cpassword"  maxlength="12" required="required" type="password" class="form-control" id="cpassword" placeholder="confirm password" />
<span id='message'></span>
</div>
</div>
<br>
<div class="form-group">
<label class="col-sm-2 control-label">User type</label>
<div class="col-sm-4">
<select class="form-control" id="type" name="type" >
<option selected="selected">--select--</option>
 <option  value="user" >CEO</option>
 <option value="admin">HR</option>
 
</select>
</div>
</div>
<br>
<div class="form-group">
<!-- <script type="text/javascript"
src="http://api.recaptcha.net/challenge?k=6LcTHA8UAAAAAA7sDRAEKqshiAyxbYW4oHyw-r2b"></script>
<noscript>
&lt;iframe src="http://api.recaptcha.net/noscript?k=6LcTHA8UAAAAAA7sDRAEKqshiAyxbYW4oHyw-r2b;"
    height="300" width="500" frameborder="0"&gt;&lt;/iframe&gt;&lt;br&gt;
&lt;textarea name="recaptcha_challenge_field" rows="3" cols="40"&gt;
&lt;/textarea&gt;
&lt;input type="hidden" name="recaptcha_response_field" 
    value="manual_challenge"&gt;
</noscript> -->
<div class="g-recaptcha"
			data-sitekey="6LcTHA8UAAAAAA7sDRAEKqshiAyxbYW4oHyw-r2b"></div>
</div>
<br>

<div class="col-md-6 center-block">

<input type="button" onclick="companyRegistration()" class="btn-lg btn-primary center-block" value="save">
</div>
 </form>
</body>
 <script type = "text/javascript" src = "https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
<script src ="https://code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
<script src='<c:url value="/resources/js/bootstrap.min.js"/>'></script> 
<script src="https://cdn.jsdelivr.net/jquery.validation/1.15.1/jquery.validate.min.js"></script>
<script src="<c:url value="/resources/js/form-validation.js"/>"></script>
<script src="<c:url value="/resources/js/passwordValidation.js"/>"></script>
<script type="text/javascript">
home='<%=request.getContextPath()%>';
function companyRegistration(){
	var add = {}
	add["type"] = $("#type").val();
	add["companyName"] = $("#companyName").val();
	add["regNumber"] = $("#regNumber").val();
	add["dob"] = $("#dob").val();
	add["email"] = $("#email").val();
	add["password"] = $("#password").val();
	add["confirmPassword"] = $("#cpassword").val();
	add["line1"] = $("#line1").val();
	add["line2"] = $("#line2").val();
	add["state"] = $("#state").val();
	add["country"] = $("#country").val();
	add["zipCode"] = $("#zipCode").val();
	add["enabled"]=false;
	console.log("search: ", add);
console.log("stringify data:",JSON.stringify(add));
	$.ajax({
		type : "POST",
	/* 	 headers: { 
		        'Accept': 'application/json',
		        'Content-Type': 'application/json' 
		    }, */
	     contentType: "application/json;charset=UTF-8",
		url : home+"/addCompany",
		data : JSON.stringify(add),
		dataType : 'json',
		timeout : 100000,
		success : function(data) {
			console.log("SUCCESS: ", data);
			alert(data)
			
		},
		error : function(e) {
			console.log("ERROR: ", e);
			alert(e);
			
		},done : function(e) {
			console.log("DONE");
		}
});
}
</script>
</html>
