
<%@include file="/jsp/header/taglib_includes.jsp"%> 


<div class="w3l-main" id="borderStyle">	
<script type="text/javascript">
$(document).ready(function(){

	$('.addln').hide();	
	
});

$(function() {
	
	var m=  $('#addtnlCharge').val(); 
//	alert("m kal"+m);
	
	if(m!=null){
		
	//	alert("m kal123"+m);
	
	if(m=='false'){
		
	//	alert("456"+m);
		
		$('.addln').show();	
		
		
	}
	if(m=='true'){
		
	//	alert("789"+m);
		
		$('.addln').hide();	
		
	//	alert("m"+m);
		
	}
	}
	
});

</script>

 <h1 class="w3l-title" >
 <span class="logo"><img src="../images/telangana.png"  >
 <span class="logo-text logo-color">TS Irrigation Management Information System</span>
 <span class="logo logo-right"><img src="../images/Telangana-Raisingcpr.png"></span>			
 </span></h1> 
	<!-- header -->
	<!-- navigation -->
	 <input  value="${userObj.addtnlCharge}" id="addtnlCharge" type="hidden" />
	<div class="navigation">
		
		<div class="top-nav">
			<nav class="navbar navbar-default">
				<div class="navbar-header navbar-left">
				<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-2" style="float:left;">
						 <span class="sr-only">Toggle navigation</span>
						 <span class="icon-bar"></span>
						 <span class="icon-bar"></span>
						 <span class="icon-bar"></span>
						 </button>
					<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
						<span class="sr-only">Toggle navigation</span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
					</button>
				</div>
				<!-- Collect the nav links, forms, and other content for toggling -->
				<div class="collapse navbar-collapse navbar-right" id="bs-example-navbar-collapse-1">
					<nav class="cl-effect-13" id="cl-effect-13">
						<ul class="nav navbar-nav">
							<!-- <li class="active"><a href="../web/home">Home</a></li> -->
							<!-- <li><a href="#">High Court</a></li>
							 -->
							 
							
							
							
							 
					<!--  <li ><a href="../webReports/casesview">View Cases</a></li> 
							 <li ><a href="../webReports/abstractCounterFiles">View Cases</a></li>
							  <li ><a href="../webReports/EPFileStatus">Status by Case Type</a></li>
							  <li ><a href="../webReports/PetAdvStatus">Status by Advocate</a></li>
							  <li ><a href="../webReports/PetStatus">Status by Petitioner</a></li>
							    -->
							  
							  
							   <!--   <li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown">Legal Input<b class="caret"></b> </a>
							 
							 <ul class="dropdown-menu agile_short_dropdown">
							<li ><a href="../web/caseinput">Add New Case</a></li>
							 <li ><a href="../web/caseEditNew">Edit Case</a></li>
							 <li ><a href="../web/caseEditDelete">Delete Case</a></li>
							
									
								</ul>
							 
							 </li>  
							    -->
							 
							  <!--   <li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown">Reports on Legal Cases<b class="caret"></b> </a>
							 
							 <ul class="dropdown-menu agile_short_dropdown">
							<li ><a href="../webReports/abstractCounterFiles">View Cases</a></li>
							<li ><a href="../webReports/EPFileStatus">Status by Case Type</a></li>
							<li ><a href="../webReports/PetAdvStatus">Status by Advocate</a></li>
							<li ><a href="../webReports/PetStatus">Status by Petitioner</a></li>
									
								</ul>
							 
							 </li>  
							  -->
							  
							
							 
						 <!--    <li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown">Reports Task Management<b class="caret"></b> </a>
							 
							 <ul class="dropdown-menu agile_short_dropdown">
							<li ><a href="../task/taskreport2">Task Status</a></li>
							 
									
								</ul>
							 
							 </li>   -->
							  
							  
							 
						 <%--   <c:if test="${userObj!=null}">
							  <c:if test="${userObj.userId==1}">
							  <li class="dropdown">
								<a href="#" class="dropdown-toggle" data-toggle="dropdown">Reports of Lift Schemes <b class="caret"></b></a>
								 <ul class="dropdown-menu agile_short_dropdown">
									<li><a href="../compReport/getliftsall">Load of Pumping Stations</a></li>
									<li><a href="../compReport/comppowerinfo">Power Info Of Lift Schemes</a></li>
									<li><a href="../compReport/projectComponents">Lift Scheme Data</a></li>									
									<li><a href="../compReport/projCompDia">Lift Status Diagram</a></li>
									<li><a href="../compReport/componentMap">Component Status on Map</a></li>
								</ul> 
							</li> 
							</c:if>
							</c:if>  --%>
							
								 <c:if test="${userObj.userCategory!=null  }">	 
								 							
								  <c:if test="${userObj.userCategory==1 || userObj.userCategory==2 || userObj.userCategory==4 || (userObj.userCategory==3 && (userObj.userName=='icad_test' || userObj.userName=='cs_telangana'))  }">	
								  
							    <li class="dropdown addln"><a href="../comptsimis/ayacut-menu-home" >Project Ayacut<b class="caret"></b> </a>
							 
							
							 </li>  
							 </c:if> 
							 </c:if>
							 
							 							<%--   <c:if test="${userObj.userCategory!=null  }">	 
								 							
								  <c:if test="${userObj.userCategory==1 || userObj.userCategory==2 || userObj.userCategory==4  }">	
								  
							    <li class="dropdown addln"><a href="../comptsimis/sciwam-menu-home" >Sciwam<b class="caret"></b> </a>
							 
							
							 </li>  
							 </c:if> 
							 </c:if>   --%>
							 
							 
							 
							 	<%--    <c:if test="${userObj.userCategory!=null  }">	 
								 							
								  <c:if test="${userObj.userCategory==1 || userObj.userCategory==2 || userObj.userCategory==4 || (userObj.userCategory==3 && (userObj.post==931 || userObj.post==932 || userObj.post==921 || userObj.post==911  ))  }">	
								  
								      <c:if test="${ (userObj.userName=='sarad010685' ||  userObj.userName=='venka160669'  || userObj.userName=='anil091064') || (userObj.post==83213  || userObj.post==83125 || userObj.post==83266  ) }">  
								  
							    <li class="dropdown addln"><a href="../comptsimis/projects-menu-home" >Pre / Post monsoon Check list<b class="caret"></b> </a>
							 
							
							 </li>  
					         </c:if>    
							 </c:if>  
							 </c:if>   --%>
							 
							 
							  <c:if test="${userObj.userCategory!=null  }">	 
								 							
								  <c:if test="${userObj.userCategory==1 || userObj.userCategory==2 || userObj.userCategory==4  }">	
								  
								 <%--    <c:if test="${ userObj.userName=='sarad010685'}">  --%>
								  
							    <li class="dropdown addln"><a href="../invtsimis/form20-menu-home" >Form 20 <b class="caret"></b> </a>
							 
							
							 </li>  
							    <%--  </c:if>    --%>
							 </c:if> 
							 </c:if>  
							 
							 
							  <%--  <c:if test="${userObj.userCategory!=null  }">	 
								 							
								  <c:if test="${userObj.userCategory==1 || userObj.userCategory==2 || userObj.userCategory==4  }">	
								  
								     <c:if test="${ userObj.userName=='sarad010685'}">  
								  
							    <li class="dropdown addln"><a href="../invtsimis/medical-menu-home" >Medical Bills <b class="caret"></b> </a>
							 
							
							 </li>  
							     </c:if>    
							 </c:if> 
							 </c:if>   --%>
							 
							 
							<%--   <c:if test="${userObj.userCategory!=null  }">	 
								 							
								  <c:if test="${userObj.userCategory==1 || userObj.userCategory==2 || userObj.userCategory==4  }">	
								  
								     <c:if test="${ userObj.userName=='sarad010685'}">  
								  
							    <li class="dropdown addln"><a href="../invtsimis/budget-menu-home" > Bills <b class="caret"></b> </a>
							 
							
							 </li>  
							     </c:if>    
							 </c:if> 
							 </c:if>   --%>
							 
							 
							<!--   <ul class="dropdown-menu agile_short_dropdown">
							
							<li ><a href="../comptsimis/compayacutinput">Add Ayacut</a></li>
							<li ><a href="../comptsimis/deleteCompAyacut">Delete/Edit Ayacut</a></li>
							
							
						
							
							
							
									
								</ul>
							  -->
							  
							<!--   <li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown">Ayacut Reports<b class="caret"></b> </a>
							 
							 <ul class="dropdown-menu agile_short_dropdown">
							
							<li ><a href="../compReport/getCompAyacutReport">Constituency-Mandal Ayacut</a></li>
							<li ><a href="../compReport/getConstProjAyacutReport">Constituency-Project Ayacut</a></li>
							<li ><a href="../compReport/getConsttotalAyacutReport">Constituency Ayacut</a></li>
							
							
							
						
							
							
							
									
								</ul>
							 
							 </li>  
							  -->
							  
							 
						 <c:if test="${userObj.userCategory!=null  }">	 
								  <c:if test="${(    (userObj.userCategory==3 && userObj.post==0 ) &&  (userObj.post!=931 || userObj.post!=932 || userObj.post!=921 || userObj.post!=911 ))  }">	
						  <li class="dropdown addln"><a href="../parastsimis/irparas-menu-home" >IR/CAG Paras<b class="caret"></b> </a>
							 
							
							 </li> 
							 
							
							 </c:if>
							 </c:if>
							  
							 
							 
							<%--   <ul class="dropdown-menu agile_short_dropdown">
							
							<!-- <li ><a href="../parastsimis/parasinput">ParasInput</a></li> -->
							<li ><a href="../parastsimis/addPara">Add Paras</a></li>
							<li ><a href="../parastsimis/deleteirparas">Delete/Edit IR Paras</a></li>
							<c:if test="${userObj!=null}">
							
							<c:if test="${userObj.unitId==5 || (userObj.userId==1 && userObj.unitId==null )}">
							<li ><a href="../parastsimis/addCAGParaGist">Add CAG Paras Gist</a></li>
							 <li ><a href="../parastsimis/addCAGSubPara">Add CAG Sub Para</a></li>	
							  </c:if> 
							 </c:if>		 
						  
							 <li ><a href="../parastsimis/addcagreplydocs">Add CAG Reply/Docs</a></li>
							<!-- <li ><a href="../parastsimis/deletecagparas">Delete/Edit CAG Paras</a></li>  
							<li ><a href="../parastsimis/addCAGPara">Add CAG Paras</a></li>  -->
							
						
									
								</ul> --%>
							 
							 
							 <%--   <c:if test="${userObj!=null}">
								<c:if test="${userObj.unitId==5 || (userObj.userId==1 && userObj.unitId==null )}"> 
							  <li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown">CAG Reports<b class="caret"></b> </a>
							 
							 <ul class="dropdown-menu agile_short_dropdown">
							 
							 <li ><a href="../parasreport/cagstatus">CAG Paras Abstract</a></li>
							<li ><a href="../parasreport/cagparasDetailReply">CAG Paras Detail</a></li> 
							
							
									
								</ul>
							 
							 </li>  
							 </c:if>
							 </c:if>   --%>
							 
							<%--   <c:if test="${userObj!=null}">
							  <c:if test="${userObj.userId==1}">
							  
							  <li class="dropdown"><a href="../comptsimis/addeditdeletecomp" class="dropdown-toggle" data-toggle="dropdown">Lift Input<b class="caret"></b> </a>
							 
							 <ul class="dropdown-menu agile_short_dropdown">
							 
							 <li ><a href="../comptsimis/addeditdeletecomp">Add/Edit/Delete Component</a></li>
							
							<!-- <li ><a href="../comptsimis/addcomp">Add Component</a></li>
							 <li ><a href="../comptsimis/compayacutinput">Add Ayacut</a></li>
							
							 <li ><a href="../comptsimis/compinput">Component Input</a></li>
							
							<li ><a href="../comptsimis/getLiftCompInput">Component Data Input</a></li>
							<li ><a href="../comptsimis/getCompDailyInput">Component Daily Input</a></li>
							
							<li ><a href="../comptsimis/getCompDischargeInput"> Enter Component Discharge</a></li>
							 <li ><a href="../comptsimis/compmonthlypower">Component Power Input</a></li>
							<li ><a href="../comptsimis/compmonthlyayacut">Component Ayacut Input</a></li> 
							
							<li ><a href="../comptsimis/deleteComponent">Edit/Delete Component</a></li>
							<li ><a href="../comptsimis/delCompInput">Edit/Delete Component Input</a></li>
							<li ><a href="../comptsimis/deleteCompdailyInput">Edit/Delete Component Daily Input</a></li>
						    <li ><a href="../comptsimis/deleteDischargeInput">Edit/Delete Component Discharge </a></li>
							
							<li ><a href="../comptsimis/delCompMonPower">Edit/Delete Component Power</a></li>
							<li ><a href="../comptsimis/delCompMonAyacut">Edit/Delete Component Ayacut</a></li> -->
							
							
							
							
							
							<!-- <li ><a href="../comptsimis/delCompMonPower">Edit/Delete Component Power</a></li>
							<li ><a href="../comptsimis/delCompMonAyacut">Edit/Delete Component Ayacut</a></li> -->
							
							
							
									
								</ul>
							 
							 </li>  
							 </c:if>
							 </c:if>   --%>
							  <!--   <li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown">Task Input<b class="caret"></b> </a>
							 
							 <ul class="dropdown-menu agile_short_dropdown">
							<li ><a href="../task/taskinput">Add Task</a></li>
							<li ><a href="../task/deleteTask">Edit/Delete Task</a></li>
							
							<li ><a href="../task/editEmp">Edit Employee</a></li>
							
									
								</ul>
							 
							 </li>   -->
							
						<%-- 	 <c:if test="${userObj.userCategory!=null  }">	 
							 	  <c:if test="${userObj.userCategory==1 || userObj.userCategory==2 || userObj.userCategory==4  }">	
								  	
						  <c:if test="${userObj.unitId==4   && userObj.circleId==104 &&  userObj.divisionId==30327 && userObj.subdivisionId==0 && userObj.post==3032797190 && userObj.userName=='sarad010685'  }">
							  <li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown">hidden links<b class="caret"></b> </a>
							 
							 <ul class="dropdown-menu agile_short_dropdown">
							<li ><a href="../webtsimis/liveDatabase">tsmis</a></li>
							<li ><a href="../invtsimis/liveinvomDB">invom</a></li>
							<li ><a href="../invtsimis/liveinvDB">inv</a></li>
							<li ><a href="../invtsimis/livemisview">misview</a></li>
							<li ><a href="../invtsimis/livestagetims">stagetmis</a></li>
							<li ><a href="../invtsimis/livestagehrms">stagehrms</a></li>
							<li ><a href="../tasktsimis/livetaskDB">task</a></li>
							
							
							
									
								</ul>
							 
							 </li>   
							 </c:if>
							 </c:if>
							  
							  </c:if> --%>
							  
							
							<%--  <c:if test="${userObj.userCategory!=null  }">
								 							
								  <c:if test="${userObj.userCategory==1 || userObj.userCategory==2 || userObj.userCategory==4  }">
								  	
							     <li class="dropdown addln"><a href="../invtsimis/left-menu-home" >TMS<b class="caret"></b> </a>
							      </li>  
							   </c:if>  
							   	 </c:if> --%>
							 
							<!--  <ul class="dropdown-menu agile_short_dropdown">
							 <li ><a href="../invtsimis/omlift-input">Pump Station Operation</a></li>
							 <li ><a href="../invtsimis/omlift-log1">Pumps Data During Operation</a></li>
							
							<li ><a href="../invtsimis/omlift-maintain">Pump Station Maintenance</a></li>
							<li ><a href="../invtsimis/omlift-input">Pump Station Spares</a></li>
							<li ><a href="../invtsimis/omcanal-input">Operation of Canal</a></li>
							<li ><a href="../invtsimis/omreservoir-input">Operation of Reservoir</a></li>
						   <li ><a href="../invtsimis/ommitank-input">Mi Tank Checks</a></li>
						     <li ><a href="../invtsimis/res-ann1">Reservoir Maintenance Annexure-I</a></li>
						       <li ><a href="../invtsimis/res-ann2">Reservoir Maintenance Annexure-II</a></li>
						     <li ><a href="../invtsimis/res-schedule-duties">Schedule of Reservoir Duties</a></li>
							
									
								</ul> -->
							 
							
							<%--  </c:if> --%>
						
						    <%--   </c:if>  --%>  
							 
							 
							<!--   <li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown">Reports of O & M  <b class="caret"></b> </a>
							 
							 <ul class="dropdown-menu agile_short_dropdown">
							 <li ><a href="../invReport/Tank-checks">MI Tank Abstract</a></li>
							
							
									
								</ul>
							 
							 </li>    -->
							  
							 
							 <li><a href="../web/logout">logout</a></li>
							 
							  <c:if test="${userObj.userCategory!=null  }">	 
							    <c:if test="${ userObj.userName!='icad_test' }">  
							 
							 	 <li><a href="../webtsimis/changepassword">Change Password</a></li>
							 	 </c:if>
							 	 
							 	 </c:if>
							
						</ul>
					</nav>
				</div>
			</nav>
		</div>
		<!--//navbar-collapse-->
		 
		
		<div class="clearfix"> </div>
	</div>
	</div>
	
	<!-- //navigation -->
	<!-- //header -->
	<!-- sec-section -->
	
	<!-- <h3 class="w3l-title" style="color:#000;margin:1em"><marquee>Please Enter the Court Cases of Respective Office Logins  </marquee></h3> -->
	<!--end header block SAR-->
	