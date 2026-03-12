<%@include file="/jsp/header/taglib_includes.jsp"%>
 <script type="text/javascript" src="../js/responsiveslides.min.js" ></script>
 <link rel="stylesheet" href="../css/bootstrap-multiselect.css"
	type="text/css">
<!-- <script type="text/javascript" src="../js/bootstrap.min.js"></script> -->
<script type="text/javascript" src="../js/bootstrap-multiselect.js"></script>

<link rel="stylesheet" media="screen" href="../css/jquery-ui.css">
<script type="text/javascript" src="../js/jquery-ui.js"></script>
<script type="text/javascript" src="../js/crypto.js"></script>
<script type="text/javascript" src="../js/crypto1.js"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/css/all.min.css">

<script>
  $(function() {
    $(".rslides").responsiveSlides();
   
  });
  
  function myFunction() {
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
			//document.getElementById("userName").focus();
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
<header class="topheader">
	<div class="header-inner">

		<section class="left-header">
			<div class=" left-header-top pull-left ">
				<div class="share-links pull-left">
					<nav>
						<ul>
							<li><span class="glyphicon glyphicon-print"></span><a
								href="javaScript:CallPrint('mainprint');">Print</a></li>
							<li><span class="glyphicon glyphicon-envelope"></span><a
								href="javaScript:mailThisUrl();">Email</a></li>
							<li><span class="glyphicon glyphicon-bookmark"></span><a
								href="#" id="bookmark">Bookmark</a></li>
						</ul>
					</nav>
				</div>
			</div>
			<div class="size-wrapper pull-left">


				<ul>
					<li class="la">TextSize</li>
					<li><a
						href="javascript:decreaseFontSize(&quot;pagecontent&quot;);"
						title='Decrease the font size'>A<sup>-</sup></a></li>
					<li><a href="javascript:keepitsame(&quot;pagecontent&quot;);"
						title='deafult font size'>A</a></li>
					<li class="last"><a
						href="javascript:increaseFontSize(&quot;pagecontent&quot;);"
						title='Increase the font size'>A<sup>+</sup></a></li>
				</ul>

			</div>
			<div class="theme-wrapper pull-left">
				<ul id="theme">
					<li class="la">SelectTheme</li>
					<li class="theme-blue"><a href="javascript:void(0);"
						rel="theme-blue">Blue</a></li>
					<li class="theme-green"><a href="javascript:void(0);"
						rel="theme-green">Green</a></li>
					<li class="theme-brown"><a href="javascript:void(0);"
						rel="theme-brown">Brown</a></li>
					<li class="theme-grey"><a href="javascript:void(0);"
						rel="theme-grey">Grey</a></li>
				</ul>
			</div>
		</section>

	</div>
</header>


<div class="w3l-main " id="borderStyle">
	<h1 class="w3l-title">
		<span class="logo"><img src="../images/telangana.png">
			<span class="logo-text logo-color">TS Irrigation Management Information
				System</span></span>

	</h1>




	<!-- header -->
	<!-- navigation -->
	<div class="navigation">
		<div class="top-nav">

			<nav class="navbar navbar-default  ">
				<div class="navbar-header navbar-left">
					<button type="button" class="navbar-toggle collapsed"
						data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
						<span class="sr-only">Toggle navigation</span> <span
							class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
				</div>
				<!-- Collect the nav links, forms, and other content for toggling -->
				<div class="collapse navbar-collapse navbar-right"
					id="bs-example-navbar-collapse-1">
					<nav class="cl-effect-13" id="cl-effect-13">
						<ul class="nav navbar-nav">
							<li class="active"><a href="../web/home">Home</a></li>
							<!--  -->
							<!--   <li ><a href="../webReports/abstractCounterFiles">View Cases</a></li>
							<li ><a href="../webReports/EPFileStatus">Status by Case Type</a></li>
							<li ><a href="../webReports/PetAdvStatus">Status by Advocate</a></li>
							<li ><a href="../webReports/PetStatus">Status by Petitioner</a></li>   -->



							<!-- <li ><a href="../webReports/casesview"></a></li> -->


						<!-- 	<li class="dropdown"><a href="#" class="dropdown-toggle"
								data-toggle="dropdown">Reports on Legal Cases<b
									class="caret"></b>
							</a>

								<ul class="dropdown-menu agile_short_dropdown">
									<li><a href="../webReports/abstractCounterFiles">View
											Cases</a></li>
									<li><a href="../webReports/EPFileStatus">Status by
											Case Type</a></li>
									<li><a href="../webReports/PetAdvStatus">Status by
											Advocate</a></li>
									<li><a href="../webReports/PetStatus">Status by
											Petitioner</a></li>

								</ul></li> -->


						<!-- 	<li class="dropdown"><a href="#" class="dropdown-toggle"
								data-toggle="dropdown">Inventory Reports<b class="caret"></b>
							</a>

								<ul class="dropdown-menu agile_short_dropdown">
									<li>
									<a href="../invReport/resAbstract">Reservoirs
											Abstract</a></li>


								</ul></li>
 -->

						<!-- 	<li class="dropdown">
							<a href="#" class="dropdown-toggle"
								data-toggle="dropdown">Ayacut Reports<b class="caret"></b>
							</a>

								<ul class="dropdown-menu agile_short_dropdown">

									<li><a href="../compReport/getCompAyacutReport">Constituency-Mandal
											Ayacut</a></li>
									<li><a href="../compReport/getConstProjAyacutReport">Constituency-Project
											Ayacut</a></li>
										<li ><a href="../compReport/getVillageAyacutReport">Constituency-Village Ayacut</a></li>
									<li><a href="../compReport/getVillageByConstAyacut">Village
											Ayacut-Constituency</a></li>
									<li><a href="../compReport/getUnitProjMandalAyacut">Mandal
											Ayacut-Project</a></li>

										<li ><a href="../compReport/getconstTotalprojAyacut	">ConstTotalByProject</a></li>	



									<li><a href="../compReport/getConsttotalAyacutReport">Constituency
											Ayacut</a></li>
									<li><a href="../compReport/getProjectAyacutReport">Project
											Ayacut</a></li>



								</ul></li>
 -->
					<!-- 		<li class="dropdown">
							<a href="#" class="dropdown-toggle"
								data-toggle="dropdown">IR Paras Reports<b class="caret"></b>
							</a>

								<ul class="dropdown-menu agile_short_dropdown">

									<li><a href="../parasreport/parastatus">Paras
											Abstract</a></li>
										<li ><a href="../parasreport/paraAbstractOffice">Paras Abstract Office</a></li>
									<li><a href="../parasreport/parasDetailReply">All
											Paras Detail</a></li>
									 <li ><a href="../parasreport/cagstatus">CAG Paras Abstract</a></li>
							<li ><a href="../parasreport/cagparasDetailReply">CAG Paras Detail</a></li> 










								</ul></li> -->



							<!-- <li><a href="#">Supreme Court </a></li> -->
							 <!--  <li class="dropdown">
								<a href="#" class="dropdown-toggle" data-toggle="dropdown">Reports of Lift Schemes <b class="caret"></b></a>
								 <ul class="dropdown-menu agile_short_dropdown">
									<li><a href="../compReport/getliftsall">Load of Pumping Stations</a></li>
									<li><a href="../compReport/comppowerinfo">Power Info Of Lift Schemes</a></li>
									<li><a href="../compReport/projectComponents">Lift Scheme Data</a></li>									
									<li><a href="../compReport/projCompDia">Lift Status Diagram</a></li>
									<li><a href="../compReport/componentMap">Component Status on Map</a></li>
								</ul> 
							</li>  -->
							 


							<!--   <li class="dropdown">
								<a href="#" class="dropdown-toggle" data-toggle="dropdown">Reports Task Management<b class="caret"></b></a>
								<ul class="dropdown-menu agile_short_dropdown">
									<li ><a href="../task/taskreport2">Task Status</a></li>
									
								</ul>
							</li>    -->
							<!-- <li><a href="#">Contact Us</a></li> -->
							<!--  <li><a href="../parasreport/infixexpression">infixexpression Us</a></li> -->


						</ul>
					</nav>
				</div>
			</nav>
		</div>
		<!--//navbar-collapse-->


		<div class="clearfix"></div>
	</div>
	<!-- //navigation -->
	<!-- //header -->
	<!-- sec-section -->


	<!--end header block SAR-->

	<div class="show-grid">
		 <div class="col-md-12">
			<!-- <h4 style="color: red; margin: 1em; font-weight: bold;">* Login
				is not Required to View Reports</h4> -->
		</div> 
		<c:if test="${msg!=null }">

			<div class="col-md-12">

				<div class="alert alert-danger" role="alert">
					<strong>Error!</strong>
					<c:out value="${msg}"></c:out>
				</div>


			</div>
		</c:if>

	</div>
	
		<div class=" show-grid">
		 <div class="col-md-12">
			 <h4 style="color: blue; margin: 1em; font-weight: bold;">Logins: 1.&emsp; Ayacut/TMS / Form20: &emsp; Use HRMS logins.<br>
			                                                         &emsp;&emsp;&emsp;&emsp;2.&emsp;IR Paras:&emsp; 
			                                                         <a style="color: red" href="../web/home" id="gotohome"><strong><U>1.Home</U></strong></a> &emsp;&emsp;
			                                                         <a style="color: red" href="javascript:void(0)" id="forgotlogin"><strong><U>2.Email request</U></strong></a> &emsp;&emsp;
				</h4> 
		</div> 
		
	</div>
	


	<div class=" mainprint  pagecontent">
		<!--start left block-->
		<div class="row">
			<div class="col-md-4 col-lg-3">
				<div class="w3l_main_grid1_w3ls_grid" id="borderStyle2">
				<!-- 	<h3></h3> -->
					<div>
						<form:form id="userLogin" class="p15" method="post"  autocomplete="off"
							modelAttribute="user" data-parsley-validate-if-empty="">
							<div class="row">
								<div class="col-md-12 ">


									<div class="form-group">
										<div class="row">
											<div class="col-md-6">
												<label class="label-control rowlebel  " for="userName">User
													Name</label> <i class="fa fa-user" aria-hidden="true"></i>
											</div>
											<div class="col-md-6">


												<input type="text" name="userName" id="userName"
													class="form-control" placeholder="User Name" required>


											</div>
										</div>
									</div>

								</div>
								<div class="col-md-12 ">
									<div class="form-group">
										<div class="row">
											<div class="col-md-6">
												<label class="label-control rowlebel  " for="Password">Password
												</label>  <span class="p-viewer2"> <i class="fa fa-key" aria-hidden="true"></i></span>

											</div>

											<div class="col-md-6">
											
											


												<input type="password" name="Password" id="password"
													class="form-control" placeholder="Password" required autocomplete=off >
													<!-- <i class="far fa-eye" id="togglePassword" style="margin-left: 120px; margin-bottom:-10px;margin-top:-500px; cursor: pointer;"></i> -->
                                                   
                                                   <br/>  
						                       <input type="checkbox" onclick="myFunction()">   Show Password 

											</div>

										</div>
									</div>
								</div>

								<div class="col-md-12 ">
									<div class="form-group">
										<div class="row">
											<div class="col-md-6">

												<img id="captcha_id" name="imgCaptcha" src="../captcha.jpg">
												
												<!--  <div class="col-sm-2" id="captcha_id" style="background-color: #34ebdf ;font-size: 20px;text-align: center; width: 80%;"></div>  -->

											</div>

											<div class="col-md-6">
												 <a href="javascript:void(0)" title="change captcha text"
													onclick="document.getElementById('captcha_id').src = '../captcha.jpg?' + Math.random();  return false">
													<img src="../images/refresh.png" />
												</a> 
												
													<!-- <img src="../images/refresh.png"  onclick="refreshCapctha()"/> -->
											</div>
										</div>

									</div>
								</div>




								<div class="col-md-12 ">
									<div class="form-group">
										
											<div class="col-md-12 ">
												<label class="label-control" for="captcha">Enter
													above Image text </label> 
													</div>
													
													<div class="col-md-12 ">
													<div class="col-md-3"></div>
												<div class="col-md-6">	<input type="text" name="captcha"
													id="captchaHidden" class="form-control" required>  
													
													 </div> 
													
													  <input type="hidden" id="captchan">
													
													<div class="col-md-3"></div>
													
													</div>
													
													
											

										
									</div>
								</div>
								
							<!-- <div class="col-md-12">		
								<div class="col-md-6">
										<label class="label-controlPMS rowlebel ">
										Select Module <font color=red>*</font> </label>
										</div>
										
										 <div class="col-md-6">
										<select class="form-control" id="moduleId" name="moduleId"   required> 
										<option value=" ">--select--</option>  
										 
								      <option value="1">Project Ayacut</option>
								      <option value="2">O&M</option>
								       <option value="3">IR Paras</option>

								
										
										
										</select> </div>
										</div> -->
										
										&emsp;&emsp;&emsp;&emsp;

								<!-- 	
						<div id="displaypw">
						
						</div> -->

								<!-- 	<script>
        var url = "../js/jquery-ui.js";
        $.getScript(url);
    </script> -->

								<div class="col-md-12 ">
									<div class="form-group">
									
										
											<div class="col-md-3 "></div>

                                          <div class="col-md-6 ">
												<input type="submit" value="Login" class="form-control"
													onclick="encryptpwd()">
													</div>
													
													<div class="col-md-3 "></div>
											
										
									</div>
								</div>


							 



					 <!--    <div class="col-md-12">


									<a href="javascript:void(0)" id="forgotlogin"><strong>To Know Office Login UserName/Password
											</strong></a>

								</div>     -->
							</div>



						</form:form>
					</div>
				</div>

				<!-- 9th-section -->

			</div>

			<!--end left block SAR-->
			<!--start main block SAR-->
			
			
			
			
			<div class="col-lg-5 col-md-4 usermargintop " >
			
			<div class="w3l_main_grid1_w3ls_grid" id="borderStyle2">


                
  <div>

					<!-- <h3>For any issues in website <a id="newsend" href="javascript:void(0)" style="color:#FFFFFF">send</a> <a id="myemail" href="javascript:void(0)" style="color:#FFFFFF">Email</a> to:
						icadcc.tg@gmail.com</h3> -->
<div class="col-md-12">

<div class="containerNew">

<ul style="padding-top:25px; font-size:18px; color:blue; font-weight: bold;"  >

 
 <li ><font>*</font>Ayacut/TMS /Form20: Use HRMS logins  <a href="#"></a></li>
<li ><font>*</font>IR Paras: Click on the link. Details will be sent to respective office Email.  <a href="#"></a></li>


</ul>


</div>
<!-- <div id="multilines">
<div class="containerNew">
<ul class="newsticker" style="height: 234px; overflow: hidden; color: blue; font-weight: bold;">

 
 <li style="margin-top: 0px;"><font>*</font>Ayacut/TMS: Use HRMS logins  <a href="#"></a></li>
<li style="margin-top: 0px;"><font>*</font>IR Paras: Click on the link. Details will be sent to respective office Email.  <a href="#"></a></li>


</ul>
</div>
 
</div> -->
</div>
</div>
				</div>

				

			</div>
			<div class="col-md-4 banner-top usermargintop">
			
			<div class="slider">
					<div class="callbacks_container">
						<ul class="rslides callbacks callbacks1">
							<li>
								<div class="w3layouts-banner-top">
									<div class="agileits-banner-info">

										<p>TS Irrigation Management Information System</p>


									</div>
								</div>
							</li>
							
							<li>
								<div class="w3layouts-banner-top1">
									<div class="agileits-banner-info">

										<p>TS Irrigation Management Information System</p>


									</div>
								</div>
							</li>


						</ul>
					</div>

				</div>
			


				

				<!-- 9th-section -->

			</div>
			<!-- climate-icons -->
			<div class="col-md-12 ">
				 
					<div class="resp-tabs-container">
						 
				<!-- 		<div style="display: block;text-align:center" class="resp-tab-content">

							<div class="banner-right-agileits">
								 
								<h4>For Technical Issues Please Contact. Sarada.E (AEE)(9703020719) , Sowjanya.S (AEE)(9949671016).  Email:icadcc.tg@gmail.com</h4>


							</div>
						</div> -->
						
						 <div style="display: block;text-align:center" class="resp-tab-content">

							<div class="banner-right-agileits">
								<div class="col-md-12">
								<!-- <div class="col-md-3"  style="display: block;text-align:center" ><h4><a target="_blank" href="https://irrigation.telangana.gov.in" ><img src="../images/weblinks/irrlogo.png" id="irrStyle2"></a></h4></div>
								<div class="col-md-3" style="display: block;text-align:center" ><h4><a target="_blank" href="https://irrigationhrmstg.cgg.gov.in/Login.do" ><img src="../images/weblinks/hrmslogo.png" id="irrStyle2"></a></h4></div> 
								
								<div class="col-md-3" style="display: block;text-align:center" ><h4><a target="_blank"  href="http://missionkakatiya.cgg.gov.in/" ><img src="../images/weblinks/mklogo.png" id="irrStyle2"></a></h4></div>  
								<div class="col-md-3" style="display: block;text-align:center" ><h4><a target="_blank"  href="https://irrigationpms.cgg.gov.in/pmsUser/home" ><img src="../images/weblinks/pmslogo.png" id="irrStyle2"></a></h4></div>   -->
								
								<div class="col-md-3">
								<a target="_blank" href="https://irrigation.telangana.gov.in" ><input type="button" id="iritid" class="btn btn-1 btn-primary center-block" value="Irrigation Telangana"></a></div>
								<div class="col-md-3">
								<a target="_blank" href="https://irrigationhrmstg.cgg.gov.in/Login.do" ><input type="button" id="hrid" class="btn btn-1 btn-primary center-block" value="Hrms"></a></div>
								<div class="col-md-3">
								<a target="_blank" href="http://missionkakatiya.cgg.gov.in/" ><input type="button" id="mkid" class="btn btn-1 btn-primary center-block" value="Mission Kakatiya"></a></div>
								<div class="col-md-3">
								<a target="_blank" href="https://irrigationpms.cgg.gov.in/pmsUser/home" ><input type="button" id="pmid" class="btn btn-1 btn-primary center-block" value="Pms"></a></div>
								
                                     </div>

							</div>
							
						</div>



						 
					</div>
				 			</div>
			<!-- calendar -->
			<div class="clearfix"></div>
			<!-- //calendar -->




			<!--end main block SAR-->

		</div>
	</div>
	<!-- //main-content -->
</div>




<!--start footer block SAR-->


<div id="forgot-login-dialogue" >

<form:form id="fogotlogindata" method="post" modelAttribute="fogotlogindata">
			
				
	<div class="col-md-12 ">
										
										
										<div class="alert alert-info " style="padding: 0px" >
										Note: Open this form after clicking on home to get office list.
			</div>	
				</div>			
			

 <div class="col-md-12 invDiv">
				
				 <div class="col-md-6">
										<label class="label-controlPMS rowlebel ">
										Select Unit <font color=red>*</font> </label>
										</div>
										
										 <div class="col-md-6">
										<select class="form-control" id="unitId" name="unitId"  onchange="getCircles(),getDivisions(),getemailofoffice()" required> 
										<option value=" ">--select--</option>  
										 <c:forEach items="${unitList}" var="u">
									              <option value="${u.unitId}">${u.unitName}</option>

								</c:forEach>
										
										
										</select> </div>
										
										<div class="col-md-6">
										<label class="label-controlPMS rowlebel ">
										Select circle  </label>
										</div>
										
										 <div class="col-md-6">
										<select class="form-control" id="circleId" name="circleId"   onchange="getDivisions(),getemailofoffice()"> 
										
										
										</select> </div>
										
										<div class="col-md-6">
										<label class="label-controlPMS rowlebel ">
										Select division </label>
										</div>
										
										 <div class="col-md-6">
										<select class="form-control" id="divisionId" name="divisionId" onchange="getemailofoffice()"> 
										
										<!-- <option value="3">CAG Report</option> -->
										
										</select> </div>
										
										
										&emsp;&emsp;
										
										
										</div>
										
										<div class="col-md-12 invDiv">
										
										<div class="col-md-4">
											<!--  <button type="button" name="tpara" id="tparainfo" class="btn btn-primary"  >Send Username/password Info to Office Email</button> -->
										</div>
										 <div class="col-md-4">
											  <input type="text" class=" form-control"  id="latestemailId" name="latestemailId" placeholder="Enter latest office Email Id"   /> 
											  </div>
											  
											  <div class="col-md-4">
											 <button type="button" name="tpara" id="tparainfo" class="btn btn-primary"  onclick="sendemailtooffice(unitId.value,circleId.value,divisionId.value,latestemailId.value)"> Send Office Username/password Info</button>
											 
											 
										</div>
										
										</div>
										
										&emsp;&emsp;
										
										
										<div class="col-md-12 invDiv">
										
										
										<div class="alert alert-info col-md-12" style="padding: 0px"										
										
				id="action_alert">
				Your Office Login UserName and Password will be sent to Your respective Office email Id.
				If you can not see any email after selecting your office, kindly Update your Email id by sending an email to icadcc.tg@gmail.com along with your office details.</div>	
				</div>
				
				</form:form>
				
				</div>








<script type="text/javascript" src="../js/parsley.js"></script>
<link rel="stylesheet" media="screen" href="../css/parsley.css">
<link id="theme-style" type="text/css" rel="stylesheet" />

<script type="text/javascript" src="../js/jQuery.style.switcher.js"></script>
<script type="text/javascript" src="../js/krmr.js"></script>
<script type="text/javascript" src="../js/krmrfont.js"></script>
<script type="text/javascript" src="../js/cookie.js"></script>
<script type="text/javascript" src="../js/jquery-ui.js"></script>
<link rel="stylesheet" media="screen" href="../css/jquery-ui.css">






<script type="text/javascript" class="example">

$(document).ready(function(){
	
	/* document.getElementById("captcha").value="";
	//document.getElementById("userName").focus();
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
		document.getElementById("captcha_id").innerHTML=randomstring; */


$('#unitId').multiselect({
	 
	 enableCaseInsensitiveFiltering: true
	 
});

$('#circleId').multiselect({
	 
	 enableCaseInsensitiveFiltering: true
	 
});


$('#divisionId').multiselect({
	 
	 enableCaseInsensitiveFiltering: true
	 
});

$('#moduleId').multiselect({
	 
	 enableCaseInsensitiveFiltering: true
	 
});




$("#latestemailId").prop('readonly',true);



});
    
    
 function encryptpwd(){

	//alert(" in function");
	var encryptPassword;
	var password=$("[name=Password]").val();
	
	$.ajax({
	   type : "POST",
	
	 url : "../web/getencryptpassword",
	   data : "password="+password,
	   async: false,
	   success: function(response){
	 // alert("data received is"+response);
	   encryptPassword=response;
	   }
	});
//	alert("enpw........"+encryptPassword);
	$("#password").val(encryptPassword);

	//document.getElementsByName("Password").value=encryptPassword;
	//alert("variable...."+document.getElementsByName("password")[0].value);
	} 
 
 
 function getCircles(){
		//alert("kal");
		//var districtId=document.getElementById("districtId").value;
	
		$('#circleId').val(0);
		$('#circleId').multiselect('rebuild');
		
		var unitId=document.getElementById("unitId").value;
		//alert(mandalId);

		  $.ajax({	          
	      url: "../task/getCircles?unitId="+unitId,
	      type: "GET",
	      success: function (response) {
	   // 	alert(response);
	    if(response!=0){
	    	  var $select = $('#circleId');
	    	 
			  $select.find('option').remove();
			 // alert("kal1");
			  
			  var obj = JSON.parse(response);
			 // alert("kal2");
			 
			
			  $('#circleId').append( '<option value="0"> --select--</option>' );
					
					 
					  
					$.each(obj, function(key, value) {
						
							$('#circleId').append( '<option value="'+value.circleId+'" > '+value.circleName+'</option>' );
					
							$('#circleId').multiselect('rebuild');
					});
	    }if(response==0||response!=null){
	    	$('#circleId').multiselect('rebuild');
	    }

	      },
	      error : function(){
	    	  alert(error);
	      }
	  }); 	
	}


	function getDivisions(){
		//alert("kal");
		//var districtId=document.getElementById("districtId").value;
		$('#divisionId').val(0);
		$('#divisionId').multiselect('rebuild');
		var circleId=document.getElementById("circleId").value;
		//alert(mandalId);

		  $.ajax({	          
	      url: "../web/getDivisions?circleId="+circleId,
	      type: "GET",
	      success: function (response) {
	    	
	    	  if(response!=0){	
	    	
	    	  var $select = $('#divisionId');
	    	 
			  $select.find('option').remove();
			  
			  var obj = JSON.parse(response);
			
			 
					
					  $('#divisionId').append( '<option value="0"> --select--</option>' );
					  
					$.each(obj, function(key, value) {
						
							$('#divisionId').append( '<option value="'+value.divisionId+'" > '+value.divisionName+'</option>' );
					
	  	  				$('#divisionId').multiselect('rebuild');
					});
	    	  }if(response==0||response!=null){
	  	    	$('#divisionId').multiselect('rebuild');
	  	    }

	      },
	      error : function(){
	    	  alert(error);
	      }
	  }); 	
	}
	
	
	function sendemailtooffice(unitId,circleId,divisionId,emailId){
		
		//alert("kal1");
		var unitId=unitId;
		var circleId=circleId;
		var divisionId=divisionId;
		var emailId=emailId;
		
			  $.ajax({	          
					      url: "../web/send-mail",
					      method:"POST",
					      async: false,
					     
					      data:{
					    	  
					    	  unitId:unitId,
					    	  circleId:circleId,
					    	  divisionId:divisionId,
					    	  latestemailId:emailId
					      },
						 
					      success: function (response) {
					   

					   

				//	    	alert("kal"+response);

					    	 
					    	 if(response>0){
					    		  
						  $('#action_alert').html('<p style="margin: 0px !important;">Mail has been sent to &emsp;'+emailId+'. Please check for Office Username and Password. </p>');
							$("html,body").animate({scrollTop:$('#action_alert').offset().top-175}, 1000);
						    }
					    	 
					    	 if(response==-1){
								  $('#action_alert').html('<p style="margin: 0px !important;">Please check your mail &emsp;'+emailId+'.</p>');
									$("html,body").animate({scrollTop:$('#action_alert').offset().top-175}, 1000);
								    }
						    if(response==0||response==null){
						    	
						    	  $('#action_alert').html('<p style="margin: 0px !important;">Failed to Send mail to &emsp; '+emailId+'</p>');
						    		$("html,body").animate({scrollTop:$('#action_alert').offset().top-175}, 1000);
						    }
						    
							
						
			  },
					      
					      error : function(){
					    	 alert(error);
					    
					      }

					  
					  });   
		 
	}
	
function getemailofoffice(){
		
	
		var unitId=$("#unitId").val();
		var circleId=$("#circleId").val();
		var divisionId=$("#divisionId").val();
		var emailId=null;
		
		//alert("unitId"+unitId+"circleId"+circleId+"divisionId"+divisionId);
		//alert("check IRParas Admin controller for web/get-mail");
		 $.ajax({	          
		      url: "../web/get-mail",
		      method:"GET",
		      async: false,
		     
		      data:{
		    	  unitId:unitId,
		    	  circleId:circleId,
		    	  divisionId:divisionId,
		    	  
		      },
			 
		      success: function (response) {
		    	  var obj = JSON.parse(response); 
		    	  if(obj!=null){
		    	  $("#latestemailId").val(obj);
		    	  }
		    	  if(obj==null){
		    		  $('#action_alert').html('<p style="margin: 0px !important;">please update your office mail id by sending an email to icadcc.tg@gmail.com along with office details.</p>');
			    		$("html,body").animate({scrollTop:$('#action_alert').offset().top-175}, 1000);
			    	  }
		  
			
 },
		      
		      error : function(){
		    	 alert(error);
		    
		      }

		  
		  });   
		 
	
}
	 
	
$(function () {
	
	
	
	
	
	$('#forgot-login-dialogue').dialog({
		  autoOpen:false,
		  width:1200,
		 
		  close: function() {
			  
			
				  $(this).dialog("close");
				  }
		 });
	
	$('#forgotlogin').click(function(){
		 $('#forgot-login-dialogue').dialog('option', 'title', 'To know Office Login UserName/Password');
		  $('#forgot-login-dialogue').dialog('open');
		 });
	
	
	$('#newsend').click(function(){
		$("#latestemailId").prop('readonly',true);
		
		 });
	$('#myemail').click(function(){
		$("#latestemailId").prop('readonly',false);
		
	 });
	
	
	 
	 $('#userLogin').parsley().on('field:validated', function() {
		    var ok = $('.parsley-error').length === 0;
		
		   // alert('hi');
		    
		  })
		  
		  .on('form:submit', function() {
			  
			  //alert("coming here");
			  
			  
			  
			  var user=$("#userName").val();
			  
			  var pwd=$("#password").val();
			  var keyBase64 = "o9szYIOq1rRMiouNhNvaq96lqUvCekxR";
				var key = CryptoJS.enc.Base64.parse(keyBase64);
				var encrpPwd= CryptoJS.enc.Utf8.parse(pwd);
				var encrptedPwd = CryptoJS.AES.encrypt(encrpPwd, key, {
					mode : CryptoJS.mode.ECB,
					padding : CryptoJS.pad.Pkcs7
				});
				$("#password").val(encrptedPwd);
				
				
				//var txtinput=document.getElementById("captcha").value;
				  // var str1 = document.getElementById("captchaHidden").value;
				    		 /*   if(txtinput==""){
				    			   message="Security code should not be empty";
				    			   alert(message);
				    			   return false;
				    			 
				    				
				    		   }  */
				    		  /*  if(str1!==txtinput){
		    		    			message="Security Code did not match";
		    		    			alert(message);
		    		    			document.getElementById("captchaenter").value="";
		    		    			return false;
				    		   }  */
				
				
				
					 document.forms.userLogin.action="../webtsimis/login";
					 document.forms.userLogin.submit(); 
				
			  
			  
			    // Don't submit form for this demo
			  });
	 
	
	 
});
</script>


  <script type="text/javascript" src="../js/newsTicker.js" ></script>
  <script>
            var multilines = $('#multilines .newsticker').newsTicker({
                row_height: 78,
                speed: 800,
                prevButton: $('#multilines .prev-button'),
                nextButton: $('#multilines .next-button'),
                stopButton: $('#multilines .stop-button'),
                startButton: $('#multilines .start-button'),
            });

            var oneliner = $('#oneliner .newsticker').newsTicker({
                row_height: 44,
                max_rows: 1,
                time: 5000,
                nextButton: $('#oneliner .header')
            });

            // Pause newsTicker on .header hover
            $('#oneliner .header').hover(function() {
                oneliner.newsTicker('pause');
            }, function() {
                oneliner.newsTicker('unpause');
            });
            
            
           /*  const togglePassword = document.querySelector('#togglePassword');
            const password = document.querySelector('#password');

            togglePassword.addEventListener('click', function (e) {
              // toggle the type attribute
              const type = password.getAttribute('type') === 'password' ? 'text' : 'password';
              password.setAttribute('type', type);
              // toggle the eye slash icon
              this.classList.toggle('fa-eye-slash');
          }); */
        </script>