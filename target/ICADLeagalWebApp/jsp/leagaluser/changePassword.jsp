

<!--main code block-->
<!-- sec-section -->

<!-- create component start here -->
<%@include file="/jsp/header/taglib_includes.jsp"%>


<link rel="stylesheet" href="../css/bootstrap-multiselect.css"
	type="text/css">
<!-- <script type="text/javascript" src="../js/bootstrap.min.js"></script> -->
<script type="text/javascript" src="../js/bootstrap-multiselect.js"></script>

<link rel="stylesheet" media="screen" href="../css/jquery-ui.css">
<script type="text/javascript" src="../js/jquery-ui.js"></script>
<script type="text/javascript" src="../js/ckeditor/ckeditor.js"></script>
<script type="text/javascript" src="../js/ckeditor/adapters/jquery.js"></script>
<script type="text/javascript" src="../js/crypto.js"></script>
<script type="text/javascript" src="../js/crypto1.js"></script>




<script type="text/javascript">

$(document).ready(function(){
	
	/* document.getElementById("captcha").value="";
	//Generates the captcha function
		var chars = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXTZ";
		var string_length = 5;
		var randomstring = '';
		for (var i=0; i<string_length; i++) {
			var rnum = Math.floor(Math.random() * chars.length);
			randomstring += chars.substring(rnum,rnum+1);
		}
//alert(randomstring);
		document.getElementById("captchaHidden").value=randomstring;
		document.getElementById("captcha_id").innerHTML=randomstring;
		//${"#captcha_id"}.val(randomstring); */

	}); 
	
	
$(function() {
	
	

	
});

function myFunction1() {
    var x = document.getElementById("pswd");
    alert("x"+x);
    if (x.type === "password") {
      x.type = "text";
    } else {
      x.type = "password";
    }
  }

function myFunction2() {
    var x = document.getElementById("newPassword");
    if (x.type === "password") {
      x.type = "text";
    } else {
      x.type = "password";
    }
  }
function myFunction3() {
    var x = document.getElementById("password");
    if (x.type === "password") {
      x.type = "text";
    } else {
      x.type = "password";
    }
  }
  
/* function refreshCapctha(){
	  document.getElementById("captcha_id").value="";
	 	document.getElementById("captcha").value="";			
			//Generates the captcha function
				var chars = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXTZ";
				var string_length = 5;
				var randomstring = '';
				for (var i=0; i<string_length; i++) {
					var rnum = Math.floor(Math.random() * chars.length);
					randomstring += chars.substring(rnum,rnum+1);
				}
				//alert(randomstring);
				document.getElementById("captchaHidden").value=randomstring;
				document.getElementById("captcha_id").innerHTML=randomstring;
	 } */



</script>

<title>JavaScript Password Strength Validation Example</title>
        <script>
            function validatePassword(password) {
                
                // Do not show anything when the length of password is zero.
                if (password.length === 0) {
                    document.getElementById("msg1").innerHTML = "";
                    return;
                }
                // Create an array and push all possible values that you want in password
                var matchedCase = new Array();
                matchedCase.push("[$@$!%*#?&]"); // Special Charector
                matchedCase.push("[A-Z]");      // Uppercase Alpabates
                matchedCase.push("[0-9]");      // Numbers
                matchedCase.push("[a-z]");     // Lowercase Alphabates        
                
                // Check the conditions
                var ctr = 0;
                for (var i = 0; i < matchedCase.length; i++) {
                    if (new RegExp(matchedCase[i]).test(password)) {
                        ctr++;
                    }
                }
                
              //Validate for length of Password.
                if (ctr > 2 && password.length > 8) {
                	ctr++;
                }
              
                // Display it
                var color = "";
            var strength = "";
            switch (ctr) {
                case 0:
                case 1:
                    strength = "Weak";
                    color = "red";
                    break;
                case 2:
                    strength = "Good";
                    color = "orange";
                    break;
                case 3:
                case 4:
                    strength = "Strong";
                    color = "blue";
                    break;
                case 5:
                    strength = "Very Strong";
                    color = "green";
                    break;
            }
                document.getElementById("msg1").innerHTML = strength;
                document.getElementById("msg1").style.color = color;
            }
        </script>






	<div class="panel panel-primary " >
		<div class="panel-heading">
			<h3 class="panel-title" style="" align="center">Change Password Service is not applicable for HRMS users</h3>
		</div>
			
		
		<div class="alert alert-info" role="alert">
	
		<c:if test="${msg!=null}">
			
            ${msg}
                   
				</c:if>
				<c:if test="${err!=null}">
			
            ${err}
                   
				</c:if>
				</div>
		<div id="result" class="container">

	<form:form method="post" id="changepwdId" modelAttribute="changepwd" data-parsley-validate-if-empty=""
						>
						
						
						<div class="col-md-12">
						<div class="col-md-4">
						<label class="label-controlPMS rowlebel ">Old Password <font
							color=red>*</font>
						</label>
					</div>
					
					<div class="col-md-4">
						  <input class="form-control" type="password" name="oldPassword" id="pswd" required   data-parsley-required-message="Please enter old Password"  />
						  <input type="hidden" name="userName" 	value="${userObj.userName}"  />
					</div>
					<div class="col-md-4"><input type="checkbox" onclick="myFunction1()">   Show Password</div>
					
					</div>
						
                    	<div class="col-md-12">
                       
							<div class="col-md-4">
						<label class="label-controlPMS rowlebel ">New Password<font
							color=red>*</font>
						</label>
					</div>		
								
							<div class="col-md-4">
						<input class="form-control" type="password" name="newPassword" required
									id="newPassword"  data-parsley-required-message="Please enter newpassword"  onkeyup="validatePassword(this.value);" onchange="check1(this)" /><span id="msg1"></span>
					</div>	
					<div class="col-md-4"> <input type="checkbox" onclick="myFunction2()"> Show Password</div>	
						</div>		
									<div class="col-md-12">
									<div class="col-md-4">
						<label class="label-controlPMS rowlebel ">Confirm pasword<font
							color=red>*</font>
						</label>
					</div>	
					
				
					
							
							<div class="col-md-4">
						<input class="form-control"  type="password" name="password" id="password" required  data-parsley-equalto="#newPassword"  data-parsley-required-message="Please enter a coorect password"/>
					</div>	
					<div class="col-md-4"><input type="checkbox" onclick="myFunction3()">   Show Password</div>
					</div>
				
				
					<div class="col-md-12 ">
									<div class="form-group">
										<div class="row">
										<div class="col-md-3"></div>
											<div class="col-md-3">

												<img id="captcha_id" name="imgCaptcha" src="../captcha.jpg">
												
												<!--  <div class="col-sm-2" id="captcha_id" style="background-color: #34ebdf ;font-size: 20px;text-align: center; width: 80%;"></div>  -->

											</div>

											<div class="col-md-3">
												 <a href="javascript:void(0)" title="change captcha text"
													onclick="document.getElementById('captcha_id').src = '../captcha.jpg?' + Math.random();  return false">
													<img src="../images/refresh.png" />
												</a> 
												
													<!-- <img src="../images/refresh.png"  onclick="refreshCapctha()"/> -->
											</div>
											<div class="col-md-3"></div>
										</div>

									</div>
								</div>
								
								<div class="col-md-12 ">
									<div class="form-group">
										
										
													
													<div class="col-md-12 ">
													
													<div class="col-md-3"></div>
													<div class="col-md-3"><label class="label-control" for="captcha">Enter
													above Image text </label> </div>
												<div class="col-md-3">	<input type="text" name="captcha"
													id="captchaHidden" class="form-control" required>  
													
													 </div> 
													
													  <input type="hidden" id="captchan">
													
													<div class="col-md-3"></div>
													
													</div>
													
													
											

										
									</div>
								</div>
								
								 <div class="row col-md-12" >		
	<br></br>
				
					<div class="col-md-6" >	</div>					
					    <div class="col-md-2"><input	style="text-align: center;" type="submit"	class="btn btn-1 btn-primary center-block"	value="Submit" ></div>								
				   <div class="col-md-4" >	</div>		
	</div>		
					
					
						
						
								
										
										
										
						
					
						

					</form:form>
					
					<div class="col-md-12" style="color:blue;">
								
								
								<h4 >Strong Password must contain the following:</h4><br /> 
								
									1. A lowercase letter<br /> 
									2. A capital (uppercase) letter<br />
									3. A number<br /> 
									4. Minimum 8 characters<br /> 
								
								<br />

							</div>
					
						</div>
		
		
		</div>
		




		
	<!-- container div -->
	

<!-- panel div -->
	

	


	
	

	
	
	
	
	
	
	
	
			

	







<!-- //main-content -->
<script type="text/javascript" src="../js/parsley.js"></script>

<script type="text/javascript" class="example">
$(function () {
	 $('#changepwdId').parsley().on('field:validated', function() {
		    var ok = $('.parsley-error').length === 0;
		
		   // alert('hi');
		    
		  })
		  
		  .on('form:submit', function() {
			 // alert("coming here");
			  var oldpwd=$("#pswd").val();
				var newpwd = $("#newPassword").val();
				var pwd = $("#password").val();
				
				alert("oldpwd"+oldpwd);
				
				alert("newpwd"+newpwd);
				
				var keyBase64 = "o9szYIOq1rRMiouNhNvaq96lqUvCekxR";
				var key = CryptoJS.enc.Base64.parse(keyBase64);
				var encrpOldp = CryptoJS.enc.Utf8.parse(oldpwd);
				var oldp = CryptoJS.AES.encrypt(encrpOldp, key, {
					mode : CryptoJS.mode.ECB,
					padding : CryptoJS.pad.Pkcs7
				});
				var encrpNewpwd = CryptoJS.enc.Utf8.parse(newpwd);
				var pnew = CryptoJS.AES.encrypt(encrpNewpwd, key, {
					mode : CryptoJS.mode.ECB,
					padding : CryptoJS.pad.Pkcs7
				});
				var encrpPwd = CryptoJS.enc.Utf8.parse(pwd);
				var p = CryptoJS.AES.encrypt(encrpPwd, key, {
					mode : CryptoJS.mode.ECB,
					padding : CryptoJS.pad.Pkcs7
				});
				
				 $("#pswd").val(oldp);
				 $("#newPassword").val(pnew);
				 $("#password").val(p);
				 
				 
				/*  var txtinput=document.getElementById("captcha").value;
				   var str1 = document.getElementById("captchaHidden").value;
				    		   if(txtinput==""){
				    			   message="Security code should not be empty";
				    			   alert(message);
				    			   return false;
				    			
				    		   } 
				    		   if(str1!==txtinput){
		    		    			message="Security Code did not match";
		    		    			alert(message);
		    		    			document.getElementById("captchaenter").value="";
		    		    			return false;
				    		   }  */
			 
				
			  document.forms.changepwdId.action="../webtsimis/submitPassword";
				 document.forms.changepwdId.submit(); 
				
			
				
			  
			  
			    // Don't submit form for this demo
			  });
});
</script>



