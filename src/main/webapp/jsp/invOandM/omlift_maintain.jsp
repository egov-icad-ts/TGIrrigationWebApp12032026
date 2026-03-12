

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

<style>
.ui-tabs-vertical { width: 45em; }
.ui-tabs-vertical .ui-tabs-nav { padding: .1em .1em .1em .1em; float: left; width: 8em; }
.ui-tabs-vertical .ui-tabs-nav li { clear: left; width: 100%; border-bottom-width: 1px !important; border-right-width: 0 !important; margin: 0 -1px .2em 0; }
.ui-tabs-vertical .ui-tabs-nav li a { display:block; }
.ui-tabs-vertical .ui-tabs-nav li.ui-tabs-active { padding-bottom: 0; padding-right: .1em; border-right-width: 1px; border-right-width: 1px; }
.ui-tabs-vertical .ui-tabs-panel { padding: 1em; float: right; width: 30em;}
</style>


<script type="text/javascript">

$(document).ready(function(){
	
	
		 
	$('#basinId').multiselect({
		 
		 enableCaseInsensitiveFiltering: true
		 
	});

	$('#pumpLinkId').multiselect({
		 
		 enableCaseInsensitiveFiltering: true
		 
	});

	$('#pumpStationId').multiselect({
		 
		 enableCaseInsensitiveFiltering: true
		 
	});
	
	$('#inspectHour1').multiselect({
		 
		 enableCaseInsensitiveFiltering: true
		 
	});
	
	
	
	/* $('#pumpId').multiselect({
		 
		 enableCaseInsensitiveFiltering: true
		 
	}); */
	
	





	
	
	
	
	
	
	 
	 
	 
	

	}); 
	
	
$(function() {
	
	$(".datepick").datepicker({
		changeYear : true,
		changeMonth : true,
		dateFormat : "dd/mm/yy",
	/*  onSelect: function(selected) {
	   $("#month").datepicker("option","minDate", selected)
	 } */
	});
	
	
$("#addresjuris").click(function() {
	  var link = $(this).attr('href');
	  
	  alert(link);
	
	  $('#whereFormWillLive').load(link);
	 

	 // $(".content").load(link);
	});
	
/* 
$( "#tabs" ).tabs().addClass( "ui-tabs-vertical ui-helper-clearfix" );
$( "#tabs li" ).removeClass( "ui-corner-top" ).addClass( "ui-corner-left" );
 */
 $( "#tabs" ).tabs()
 
 
 

 $("#frequencyId").change(function() {
	  var freq = $(this).val();
	  
	  alert(freq);
	  
	 

	
	});
	
});



</script>

<!-- <div id="content">
<div class="w3l-main" style="width:100%" id="borderStyle"> -->

<div class="col-md-9">
	


<div>


	<div class="panel panel-primary " >
		<div class="panel-heading">
			<h3 class="panel-title">O&M of Lift:Lift Maintenance</h3>
		</div>
			
		
		<div class="panel-body">	
	
	<div class="alert alert-info col-md-12" style="padding: 0px"
				id="action_alert"></div>	
		
		<div  class="col-md-12 invDiv">
		
	
<form:form id="mainformid" name="mainformname"
								modelAttribute="checkList" method="post"
								data-parsley-validate-if-empty="">	
		
		<div class="col-md-6">
						<label class="label-controlPMS rowlebel ">Select Basin: <font
							color=red>*</font>
						</label>
					</div>

					<div class="col-md-6">
						<select class="form-control" id="basinId" name="basinId"
							 required onchange="getPumpLinks(this.value)">
							 <option value=" ">--select--</option>
							<c:forEach items="${basinList}" var="u">
										<option value="${u.basinId}">${u.basinName}</option>

									</c:forEach>

						</select>
					</div>
					
						<div class="col-md-6">
						<label class="label-controlPMS rowlebel ">Select Pump Scheme:
						</label>
					</div>

					<div class="col-md-6">
						<select class="form-control" id="pumpLinkId" name="pumpLinkId"
							 required  onchange="getPumpStations(this.value)">
							

						</select>
					</div>
					
							<div class="col-md-6">
						<label class="label-controlPMS rowlebel ">Select Pump Station: <font
							color=red>*</font>
						</label>
					</div>

					<div class="col-md-6">
						<select class="form-control" id="pumpStationId" name="pumpStationId"
							 required>
							

						</select>
					</div>
					
					
					
						
					
		
		
</form:form>
		
		
		</div>
	
		
		
		<div id="result" class="col-md-12">
	<div class="wrapper">
		
			<div id="tabs">
				<ul>
					<li><a href="#daily" onclick="getcheckfalse1()">Daily Maintenance</a></li>
					<li><a href="#weekly" onclick="getcheckfalse2()">Weekly Maintenance</a></li>
					<li><a href="#monthly" onclick="getcheckfalse3()">Monthly Maintenance</a></li>
					<li><a href="#yearly" onclick="getcheckfalse4()">Yearly Maintenance</a></li>
				</ul>
				<div id="daily">
				
						<form:form id="dailymaint" name="dailymaintname"  modelAttribute="pumpactivityList" method="post" 	data-parsley-validate-if-empty="">
						
						
						
                       <input name="pumpMaintActivityList[0].unitId" value="23"
									id="unitId1" type="hidden" />
								<input name="pumpMaintActivityList[0].circleId" value="0"
									id="circleId1" type="hidden" />
								<input name="pumpMaintActivityList[0].divisionId" value="0"
									id="divisionId1" type="hidden" />
								<input name="pumpMaintActivityList[0].subdivisionId" value="0"
									id="subdivisionId1" type="hidden" />
								<input name="pumpMaintActivityList[0].projectId" value="0"
									id="projectId1" type="hidden" />
								<input name="pumpMaintActivityList[0].basinId" value="0"
									id="basinId1" type="hidden" />
								<input name="pumpMaintActivityList[0].pumpLinkId" value="0"
									id="pumpLinkId1" type="hidden" />
								<input name="pumpMaintActivityList[0].pumpStationId" value="0"
									id="pumpStationId1" type="hidden" />
									
									<input name="pumpMaintActivityList[0].designationId" value="2"
									id="designationId1" type="hidden" />
									
									<input name="pumpMaintActivityList[0].dutyFrequencyId" value="1"
									id="dutyFrequencyId1" type="hidden" />
									
					
						<c:if test="${pmad!=null}">
						
						<div class="col-md-12 invDiv">
						
		
					
							            
		            <div class="col-md-3">
						<label class="label-controlPMS rowlebel ">Select Date: <font
							color=red>*</font>
						</label>
					</div>

					<div class="col-md-3">
					<input
				type="text" class=" datepick form-control datepicker" id="dailyinspectDate1" name="pumpMaintActivityList[0].inspectDate"
				  />
					</div>
					
					 <div class="col-md-3">
						<label class="label-controlPMS rowlebel ">Select Hour: <font
							color=red>*</font>
						</label>
					</div>

				<div class="col-md-3">
						<select class="form-control" id="inspectHour1" name="pumpMaintActivityList[0].inspectHour" >
							<option value=" ">--select--</option>
							<option value="1">1</option>
							<option value="2">2</option>
							<option value="3">3</option>
							<option value="4">4</option>
							<option value="5">5</option>
							<option value="6">6</option>							
							<option value="7">7</option>
							<option value="8">8</option>
							<option value="9">9</option>
							<option value="10">10</option>
							<option value="11">11</option>
							<option value="12">12</option>
							<option value="13">13</option>
							<option value="14">14</option>
							<option value="15">15</option>
							<option value="16">16</option>
							<option value="17">17</option>
							<option value="18">18</option>
							<option value="19">19</option>
							<option value="20">20</option>
							<option value="21">21</option>
							<option value="22">22</option>
							<option value="23">23</option>
							<option value="24">24</option>
							
							

						</select>
					</div>
		</div>

					   <c:forEach items="${pmad}" var="m" varStatus="mcount">
					  <div class="row col-md-12">
					  
					   <div class="col-md-1">
                     ${mcount.count}
                     </div> 
                     <div class="col-md-1">
                     <input class="cuscheck1  rescuscheck" name="pumpMaintActivityList[${mcount.count}].checkboxId" value="0" id="checkboxId${mcount.count}" type="checkbox" />
                     </div> 
					  <div class="col-md-4">
					  
					   <label class="label-control rowlebel invDiv " for="parameter1"> ${m.pmActivity}</label>
						</div> 
					<div class="col-md-6">	 
					<input  	type="hidden" class="form-control" id="pmActivityId${mcount.count}" name="pumpMaintActivityList[${mcount.count}].pmActivityId" value="${m.pmActivityId}"	placeholder="${m.pmActivityId}"  /> 
					<textarea class="form-control"  id="remarks${mcount.count}" name="pumpMaintActivityList[${mcount.count}].remarks"  rows="3" cols="50" placeholder="Observations"  ></textarea>
					</div>
						<br />
							<br />
					
					</div>
				</c:forEach>
				 	  </c:if>
						<br />
						 <button type="button" name="addres" id="dailybtn" class="btn btn-1 btn-primary center-block schedulebutton" >Submit</button>
					</form:form>
				</div>
				<div id="weekly">
				
					<form:form id="weeklymaint" name="weeklymaintname"  modelAttribute="pumpactivityList" method="post" 	data-parsley-validate-if-empty="">
					
					 <input name="pumpMaintActivityList[0].unitId" value="23"
									id="unitId2" type="hidden" />
								<input name="pumpMaintActivityList[0].circleId" value="0"
									id="circleId2" type="hidden" />
								<input name="pumpMaintActivityList[0].divisionId" value="0"
									id="divisionId2" type="hidden" />
								<input name="pumpMaintActivityList[0].subdivisionId" value="0"
									id="subdivisionId2" type="hidden" />
								<input name="pumpMaintActivityList[0].projectId" value="0"
									id="projectId2" type="hidden" />
								<input name="pumpMaintActivityList[0].basinId" value="0"
									id="basinId2" type="hidden" />
								<input name="pumpMaintActivityList[0].pumpLinkId" value="0"
									id="pumpLinkId2" type="hidden" />
								<input name="pumpMaintActivityList[0].pumpStationId" value="0"
									id="pumpStationId2" type="hidden" />
									
									<input name="pumpMaintActivityList[0].designationId" value="2"
									id="designationId2" type="hidden" />
									
									<input name="pumpMaintActivityList[0].dutyFrequencyId" value="2"
									id="dutyFrequencyId2" type="hidden" />
						<c:if test="${pmaw!=null}">
						
						

					   <c:forEach items="${pmaw}" var="m" varStatus="mcount">
						 <div class="row col-md-12">
					  
					   <div class="col-md-1">
                     ${mcount.count}
                     </div> 
                     <div class="col-md-1">
                     <input class="cuscheck2  rescuscheck" name="pumpMaintActivityList[${mcount.count}].checkboxId" value="0" id="checkboxId${mcount.count}" type="checkbox" />
                     </div> 
					  <div class="col-md-3">
					  
					   <label class="label-control rowlebel invDiv " for="parameter1"> ${m.pmActivity}</label>
						</div> 
						
						 

					<div class="col-md-3">
					<label class="label-controlPMS rowlebel ">Select Date: <font
							color=red>*</font>
						</label>
					<input
				type="text" class=" datepick form-control datepicker" id="weeklyinspectDate${mcount.count}" name="pumpMaintActivityList[${mcount.count}].inspectDate"
				placeholder="dateofoperation"  />
					</div>
					
					

				
					<div class="col-md-4">	 
					<input  	type="hidden" class="form-control" id="pmActivityId${mcount.count}" name="pumpMaintActivityList[${mcount.count}].pmActivityId" 	value="${m.pmActivityId}" /> 
					<textarea class="form-control"  id="remarks${mcount.count}" name="pumpMaintActivityList[${mcount.count}].remarks"  rows="3" cols="50" placeholder="Observations"  ></textarea>
					</div>
						<br />
							<br />
					
					</div>
				</c:forEach>
				 	  </c:if>
						<br />
						 <button type="button" name="addres" id="weeklybtn" class="btn btn-1 btn-primary center-block schedulebutton" >Submit</button>
					</form:form>
				</div>
				
				<div id="monthly">
				
				<form:form id="monthmaint" name="monthmaintname"  modelAttribute="pumpactivityList" method="post" 	data-parsley-validate-if-empty="">
				
				 <input name="pumpMaintActivityList[0].unitId" value="23"
									id="unitId3" type="hidden" />
								<input name="pumpMaintActivityList[0].circleId" value="0"
									id="circleId3" type="hidden" />
								<input name="pumpMaintActivityList[0].divisionId" value="0"
									id="divisionId3" type="hidden" />
								<input name="pumpMaintActivityList[0].subdivisionId" value="0"
									id="subdivisionId3" type="hidden" />
								<input name="pumpMaintActivityList[0].projectId" value="0"
									id="projectId3" type="hidden" />
								<input name="pumpMaintActivityList[0].basinId" value="0"
									id="basinId3" type="hidden" />
								<input name="pumpMaintActivityList[0].pumpLinkId" value="0"
									id="pumpLinkId3" type="hidden" />
								<input name="pumpMaintActivityList[0].pumpStationId" value="0"
									id="pumpStationId3" type="hidden" />
									
									<input name="pumpMaintActivityList[0].designationId" value="2"
									id="designationId3" type="hidden" />
									<input name="pumpMaintActivityList[0].dutyFrequencyId" value="3"
									id="dutyFrequencyId3" type="hidden" />
						<c:if test="${pmam!=null}">
						
						

					   <c:forEach items="${pmam}" var="m" varStatus="mcount">
								 <div class="row col-md-12">
					  
					   <div class="col-md-1">
                     ${mcount.count}
                     </div> 
                     <div class="col-md-1">
                     <input class="cuscheck3   rescuscheck" name="pumpMaintActivityList[${mcount.count}].checkboxId" value="0" id="checkboxId${mcount.count}" type="checkbox" />
                     </div> 
					  <div class="col-md-3">
					  
					   <label class="label-control rowlebel invDiv " for="parameter1"> ${m.pmActivity}</label>
						</div> 
						
						 

					<div class="col-md-3">
					<label class="label-controlPMS rowlebel ">Select Date: <font
							color=red>*</font>
						</label>
					<input
				type="text" class=" datepick form-control datepicker" id="moninspectDate${mcount.count}" name="pumpMaintActivityList[${mcount.count}].inspectDate"
				placeholder="dateofoperation"  />
					</div>
					
					

				
					<div class="col-md-4">	 
					<input  	type="hidden" class="form-control" id="pmActivityId${mcount.count}" name="pumpMaintActivityList[${mcount.count}].pmActivityId" 	value="${m.pmActivityId}"  /> 
					<textarea class="form-control"  id="remarks${mcount.count}" name="pumpMaintActivityList[${mcount.count}].remarks"  rows="3" cols="50" placeholder="Observations"  ></textarea>
					</div>
						<br />
							<br />
					
					</div>
				</c:forEach>
				 	  </c:if>	<br />
					
						 <br />
						 <button type="button" name="addres" id="monbtn" class="btn btn-1 btn-primary center-block schedulebutton" >Submit</button>
					</form:form>
				
				
				</div>
				
				<div id="yearly">
				
				<form:form id="yearlymaint" name="yearlymaintname"  modelAttribute="pumpactivityList" method="post" 	data-parsley-validate-if-empty="">
				
				<input name="pumpMaintActivityList[0].unitId" value="23"
									id="unitId4" type="hidden" />
								<input name="pumpMaintActivityList[0].circleId" value="0"
									id="circleId4" type="hidden" />
								<input name="pumpMaintActivityList[0].divisionId" value="0"
									id="divisionId4" type="hidden" />
								<input name="pumpMaintActivityList[0].subdivisionId" value="0"
									id="subdivisionId4" type="hidden" />
								<input name="pumpMaintActivityList[0].projectId" value="0"
									id="projectId4" type="hidden" />
								<input name="pumpMaintActivityList[0].basinId" value="0"
									id="basinId4" type="hidden" />
								<input name="pumpMaintActivityList[0].pumpLinkId" value="0"
									id="pumpLinkId4" type="hidden" />
								<input name="pumpMaintActivityList[0].pumpStationId" value="0"
									id="pumpStationId4" type="hidden" />
									
									<input name="pumpMaintActivityList[0].designationId" value="2"
									id="designationId4" type="hidden" />
									
									<input name="pumpMaintActivityList[0].dutyFrequencyId" value="6"
									id="dutyFrequencyId4" type="hidden" />
						<c:if test="${pmay!=null}">
						

						

					   <c:forEach items="${pmay}" var="m" varStatus="mcount">
							 <div class="row col-md-12">
					  
					   <div class="col-md-1">
                     ${mcount.count}
                     </div> 
                     <div class="col-md-1">
                     <input  class="cuscheck1  rescuscheck"  name="pumpMaintActivityList[${mcount.count}].checkboxId" value="0" id="checkboxId${mcount.count}" type="checkbox" />
                     </div> 
					  <div class="col-md-3">
					  
					   <label class="label-control rowlebel invDiv " for="parameter1"> ${m.pmActivity}</label>
						</div> 
						
						 

					<div class="col-md-3">
					<label class="label-controlPMS rowlebel ">Select Date: <font
							color=red>*</font>
						</label>
					<input
				type="text" class=" datepick form-control datepicker" id="yearlyinspectDate${mcount.count}" name="pumpMaintActivityList[${mcount.count}].inspectDate"
				placeholder="dateofoperation"  />
					</div>
					
					

				
					<div class="col-md-4">	 
					<input  	type="hidden" class="form-control" id="pmActivityId${mcount.count}" name="pumpMaintActivityList[${mcount.count}].pmActivityId" 	value="${m.pmActivityId}"  /> 
					<textarea class="form-control"  id="remarks${mcount.count}" name="pumpMaintActivityList[${mcount.count}].remarks"  rows="3" cols="50" placeholder="Observations"  ></textarea>
					</div>
						<br />
							<br />
					
					</div>				</c:forEach>
				 	  </c:if>	<br />
					
						 <br />
						 <button type="button" name="addres" id="yearlybtn" class="btn btn-1 btn-primary center-block schedulebutton" >Submit</button>
					</form:form>
				
				
				</div>
			</div>
		
	</div>
	

		</div> <!-- col-md-8 div -->
		
		 </div>	<!--panel body div -->
	

	</div>	<!-- panel div -->
	
	 </div>	<!--row div -->
	

	</div>	<!-- container div -->
	

	

    
	
	
	<!-- data ends -->



<!--  dilogue starts -->

	
	
	

	
	
	
	
	
	
	
	
			

	






<!-- </div>
</div> -->
<!-- //main-content -->
<script type="text/javascript" src="../js/parsley.js"></script>
<script type="text/javascript" >
function getcheckfalse1(){	
		$('.cuscheck2').prop('checked', false);
		$('.cuscheck3').prop('checked', false);
		$('.cuscheck4').prop('checked', false);
		
		$('.schedulebutton').hide();
		$('#action_alert').empty();
		
	}

	function getcheckfalse2(){	
		$('.cuscheck1').prop('checked', false);
		$('.cuscheck3').prop('checked', false);
		$('.cuscheck4').prop('checked', false);
$('.schedulebutton').hide();
		$('#action_alert').empty();
		
	}


	function getcheckfalse3(){	
		$('.cuscheck2').prop('checked', false);
		$('.cuscheck1').prop('checked', false);
		$('.cuscheck4').prop('checked', false);
		
$('.schedulebutton').hide();
		$('#action_alert').empty();		
	}

	function getcheckfalse4(){	
		$('.cuscheck2').prop('checked', false);
		$('.cuscheck3').prop('checked', false);
		$('.cuscheck1').prop('checked', false);
		
$('.schedulebutton').hide();
		$('#action_alert').empty();				
	}
	

</script>

<script type="text/javascript">
	$(function() {
		
		

		$('.schedulebutton').hide();

		$('.rescuscheck')
				.click(
						function() {
					
	                 	var checkname =  $(this).prop('class');
	                 	
	                 	var cnamesplit = checkname.split(" ");
	                 	var checkclass1 = cnamesplit[0];
	                 	var checkclass2 = cnamesplit[1];
	                 	
	                 //	alert("i am here"+checkclass1);
	                 	
	                 	//  var subStrcheck = checkid.substring(12, checkid.length);
	                 	
	                 		                 	
	           
	
	                 	
						
  if(checkclass1.length!=null){
							var checkid = $(this).prop('id');
							
							//alert("check"+checkid);

							if ($('input:checkbox[id=' + checkid + ']').is(
									':checked') == true) {
								$(this).val(1);

							}
							//class=mycustomcheck
							if ($('input:checkbox[id=' + checkid + ']').is(
									':checked') == false) {
								$(this).val(0);

							}
							//   alert( "uncome"); 
                          var classname="."+checkclass1+":checked";
                          
                        //  alert("classname"+classname);
                          
                          
							//var numberNotChecked = $('input:checkbox[class=' + classname + ']:not(":checked")').length;
							var numberOfChecked = $(classname).length
								
								//$('input:checkbox:checked').length;

							//  alert( "un"+numberNotChecked);
						 //  alert("mat"+numberOfChecked);

						 // alert( "diff"+(numberOfChecked-numberNotChecked) );

							if ((numberOfChecked) >= 1) {
								$('.schedulebutton').show();
							} else {

								$('.schedulebutton').hide();
							}
							
  }				
							
 
						});
		

		
		/* 
		 $( "#tabs" ).tabs().addClass( "ui-tabs-vertical ui-helper-clearfix" );
		 $( "#tabs li" ).removeClass( "ui-corner-top" ).addClass( "ui-corner-left" );
		 */

		$("#unitId").change(function() {
			var id = $(this).val();

			
			for(var i=1 ;i <=4 ;i++){
				
		    $('#unitId'+i).val(id);	
			}
			
			

		});

		$("#circleId").change(function() {
			var id = $(this).val();
			for(var i=1 ;i <=4 ;i++){
				
				$('#circleId'+i).val(id);
				}
				
			

		});

		$("#divisionId").change(function() {
			var id = $(this).val();
			
         for(var i=1 ;i <=4 ;i++){
				
	$('#divisionId'+i).val(id);
				}

			

		});

		$("#subdivisionId").change(function() {
			var id = $(this).val();
			
			for(var i=1 ;i <=4 ;i++){
				
				$('#subdivisionId'+i).val(id);
							}

			

		});

		$("#projectId").change(function() {
			var id = $(this).val();
			
for(var i=1 ;i <=4 ;i++){
				
				$('#projectId'+i).val(id);
							}

			

		});

		$("#basinId").change(function() {
			var id = $(this).val();
			
			
			
			
for(var i=1 ;i <=4 ;i++){
				
				$('#basinId'+i).val(id);
							}

			
		});



		$("#pumpLinkId").change(function() {
			
			
			var id = $(this).val();
			
for(var i=1 ;i <=4 ;i++){
				
	$('#pumpLinkId'+i).val(id);
							}

			

			

		});
		
$("#pumpStationId").change(function() {
			
			
			var id = $(this).val();
			
for(var i=1 ;i <=4 ;i++){
				
	$('#pumpStationId'+i).val(id);
							}
	

		});

		$('.schedulebutton')
				.click(
						function(e) {

							var formname = this.form.name;
							//	var getformname=$(formname).prop('form');
							var buttonid = $(this).prop('id');

						//	alert("buttonid" + buttonid);

						//	alert("formname" + formname);

							alert("kal1");

							// alert("kal1");
							// var n= $('#addayacutinfo').text() ;

							// alert("text"+n);

							$('#action_alert').empty();

							e.preventDefault(); //=== To Avoid Page Refresh and Fire the Event "Click"===

							//alert("kal1");

							// var fname="form[name="+""+formname+"]";

							//alert("fname"+fname);
							/* 	if(buttonid=='addmichecks1'){ */
								if ($('form[name=mainformname]').parsley().isValid()) {  
									
									alert("kal2");
							if ($('form[name=' + formname + ']').parsley()
									.isValid()) {

								/*  
								   if($('.mycustomcheck').val()!=null){
								   	
								   	  if($('.mycustomcheck').val()==1){ */

								alert("kal3");

								$
										.ajax({
											url : "../invtsimis/pump-maintain-activity",
											method : "POST",
											async : false,
											data : $(
													'form[name=' + formname
															+ ']').serialize(),

											success : function(response) {

												//alert("kal"+response);

												if (response != 0) {

													// $('#ayacut-dailogue').dialog('close'); 

													$('#action_alert')
															.html(
																	'<p style="margin: 0px !important;">Data Updated Successfully</p>');
												}
												if (response == 0) {

													$('#action_alert')
															.html(
																	'<p style="margin: 0px !important;">Failed to Update data</p>');
												}

												//getResRegAyacutByResCode(response);

												//  alert(finYear);

												//  $('#action_alert').dialog('open'); 

												// getunitData(unitId,circleId,divisionId) ;

											},

											error : function() {
												alert(error);

											}

										});

								/* 	  }
								  } */
								/*  }  */

							}
							}else {
								
								$('form[name=mainformname]').parsley().validate();
								alert("kal4");
							}

						});

	});
</script>

<script type="text/javascript" >

function getPumpLinks(basinId) {

	var basinId =basinId ;
		
		//$('#projectId').val();

	//  alert("procId"+procId);
	$('#pumpLinkId').multiselect('rebuild');

	$.ajax({
		url : "../invtsimis/getPumpLinks?basinId=" + basinId,
		type : "GET",
		success : function(response) {
			var $select = $('#pumpLinkId');
			$select.find('option').remove();
			
		//	var selectedpackageId=$('#hiddenpackageId').val();

			var obj = JSON.parse(response);

			$('#pumpLinkId')
					.append('<option value="0"> --select--</option>');

			$.each(obj, function(key, value) {
				
			//	if(selectedpackageId==value.pkgId){

				/* $('#pumpLinkId').append(
						'<option value="'+value.pumpLinkId+'" selected="selected"> ' + value.pkgName
								+ '</option>'); */
			//	}
				//if(selectedpackageId==null || selectedpackageId!=value.pkgId){
					$('#pumpLinkId').append(
							'<option value="'+value.pumpLinkId+'"> ' + value.pumpLink
									+ '</option>');
					
			//	}

				$('#pumpLinkId').multiselect('rebuild')

				/* 	$(this).removeAttr('selected').prop('selected', false);
				  
				  if($('li').hasClass('active')){
				  	if($('input').prop('checked', true)){
				  		
				  		 $('input').prop('checked', false);
				  		
				  	var spantext=	$("span.multiselect-selected-text").text();
				  	$("span.multiselect-selected-text").text('None Selected')
				  		
				  		
				  	}
				  	$('li').removeClass('active');
				     
				  } */

			});
		},
		error : function() {
			alert(error);
		}
	});
}

function getPumpStations(pumpLinkId) {

	var pumpLinkId =pumpLinkId ;
		
		//$('#projectId').val();

	//  alert("procId"+procId);
	$('#pumpStationId').multiselect('rebuild');

	$.ajax({
		url : "../invtsimis/getPumpStation?pumpLinkId=" + pumpLinkId,
		type : "GET",
		success : function(response) {
			var $select = $('#pumpStationId');
			$select.find('option').remove();
			
		//	var selectedpackageId=$('#hiddenpackageId').val();

			var obj = JSON.parse(response);

			$('#pumpStationId')
					.append('<option value="0"> --select--</option>');

			$.each(obj, function(key, value) {
				
			//	if(selectedpackageId==value.pkgId){

				/* $('#pumpLinkId').append(
						'<option value="'+value.pumpLinkId+'" selected="selected"> ' + value.pkgName
								+ '</option>'); */
			//	}
				//if(selectedpackageId==null || selectedpackageId!=value.pkgId){
					$('#pumpStationId').append(
							'<option value="'+value.pumpStationId+'"> ' + value.pumpStation
									+ '</option>');
					
			//	}

				$('#pumpStationId').multiselect('rebuild')

				/* 	$(this).removeAttr('selected').prop('selected', false);
				  
				  if($('li').hasClass('active')){
				  	if($('input').prop('checked', true)){
				  		
				  		 $('input').prop('checked', false);
				  		
				  	var spantext=	$("span.multiselect-selected-text").text();
				  	$("span.multiselect-selected-text").text('None Selected')
				  		
				  		
				  	}
				  	$('li').removeClass('active');
				     
				  } */

			});
		},
		error : function() {
			alert(error);
		}
	});
}

</script>


