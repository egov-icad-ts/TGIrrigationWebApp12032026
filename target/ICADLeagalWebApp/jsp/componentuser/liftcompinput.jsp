 
 <%@include file="/jsp/header/taglib_includes.jsp"%>


<!-- <link rel="stylesheet" href="../css/bootstrap-multiselect.css" 	type="text/css"> -->

<!-- <script type="text/javascript" src="../js/bootstrap.min.js"></script> -->
<!-- <script type="text/javascript" src="../js/bootstrap-multiselect.js"></script>
 -->
<link rel="stylesheet" media="screen" href="../css/jquery-ui.css">
<!-- <script type="text/javascript" src="../js/jquery-ui.js"></script> -->
<!--   <link rel="stylesheet" href="../css/jquery-ui.css" > -->
       <!--  <link rel="stylesheet" href="bootstrap.min.css" /> -->
  <script src="../js/jquery-1.12.4.js"  type="text/javascript"></script>
   <script src="../js/jquery-ui.js" type="text/javascript"></script> 
   
   <script>

  
	$(document).ready(function() {
		
		/* $('#unitId').multiselect({
			 
			 enableCaseInsensitiveFiltering: true
			 
		});

		
		 
		$('#projectId').multiselect({
			 
			 enableCaseInsensitiveFiltering: true
			 
		});

		
		$('#componentId').multiselect({
			 
			 enableCaseInsensitiveFiltering: true
			 
		}); */
		 
		
		var count = 0;

		 $('#user_dialog').dialog({
		  autoOpen:false,
		  width:400
		 });

		 $('#add').click(function(){
		  $('#user_dialog').dialog('option', 'title', 'Add Data');
		  $('#deviceName').val('');
		  $('#connectedLoad').val('');
		  $('#actualLoad').val('');
		  $('#rpm').val('');
		  $('#deviceCategory').val('');
		  $('#make').val('');
		  $('#deviceType').val('');
		  $('#deviceCapacity').val('');
		  $('#deviceStatus').val('');
		 
		  $('#error_deviceName').text('');
		  $('#error_connectedLoad').text('');
		  $('#error_actualLoad').text('');
		  $('#error_rpm').text('');
		  $('#error_deviceCategory').text('');
		  $('#error_make').text('');
		  $('#error_deviceType').text('');
		  $('#error_deviceCapacity').text('');
		  $('#error_deviceStatus').text('');
		
		  
		  $('#deviceName').css('border-color', '');
		  $('#connectedLoad').css('border-color', '');
		  $('#actualLoad').css('border-color', '');
		  $('#rpm').css('border-color', '');
		  $('#deviceCategory').css('border-color', '');
		  $('#make').css('border-color', '');
		  $('#deviceType').css('border-color', '');
		  $('#deviceCapacity').css('border-color', '');
		  $('#deviceStatus').css('border-color', '');
		
		  $('#save').text('Save');
		  $('#user_dialog').dialog('open');
		 });

		 $('#save').click(function(){
		  var error_deviceName = '';
		  var error_connectedLoad = '';
		  var error_actualLoad = '';
		  var error_rpm = '';
		  var error_deviceCategory = '';
		  var error_make = '';
		  var error_deviceType = '';
		  var error_deviceCapacity = '';
		  var error_deviceStatus = '';
		
		  
		  var deviceName = '';
		  var connectedLoad = '';
		  var actualLoad = '';
		  var rpm = '';
		  var deviceCategory = '';
		  var make = '';
		  var deviceType = '';
		  var deviceCapacity = '';
		  var deviceStatus = '';
		  var deviceCategoryText='';
		  var makeText='';
		  var deviceTypeText='';
		  var deviceCapacityText='';
		  var deviceStatusText='';
		 
		  if($('#deviceName').val() == '')
		  {
			  error_deviceName = 'Pump/Motor Name is required';
		   $('#error_deviceName').text(error_deviceName);
		   $('#deviceName').css('border-color', '#cc0000');
		   deviceName = '';
		  }
		  else
		  {
			  error_deviceName = '';
		   $('#error_deviceName').text(error_deviceName);
		   $('#deviceName').css('border-color', '');
		   deviceName = $('#deviceName').val();
		  } 
		  if($('#connectedLoad').val() == '')
		  {
			  error_connectedLoad = 'Connected  Load is required';
		   $('#error_connectedLoad').text(error_connectedLoad);
		   $('#connectedLoad').css('border-color', '#cc0000');
		   connectedLoad = '';
		  }
		  else
		  {
			  error_connectedLoad = '';
		   $('#error_connectedLoad').text(error_connectedLoad);
		   $('#connectedLoad').css('border-color', '');
		   connectedLoad = $('#connectedLoad').val();
		  }
		  if($('#actualLoad').val() == '')
		  {
			  error_actualLoad = 'Actual Load is required';
		   $('#error_actualLoad').text(error_actualLoad);
		   $('#actualLoad').css('border-color', '#cc0000');
		   actualLoad = '';
		  }
		  else
		  {
			  error_actualLoad = '';
		   $('#error_actualLoad').text(error_actualLoad);
		   $('#actualLoad').css('border-color', '');
		   actualLoad = $('#actualLoad').val();
		  }
		  if($('#rpm').val() == '')
		  {
			  error_rpm = 'RPM is required';
		   $('#error_rpm').text(error_rpm);
		   $('#rpm').css('border-color', '#cc0000');
		   rpm = '';
		  }
		  else
		  {
			  error_rpm = '';
		   $('#error_rpm').text(error_rpm);
		   $('#rpm').css('border-color', '');
		   rpm = $('#rpm').val();
		  }
		  if($('#deviceCategory').val() == '')
		  {
			  error_deviceCategory = 'Device Category is required';
		   $('#error_deviceCategory').text(error_deviceCategory);
		   $('#deviceCategory').css('border-color', '#cc0000');
		   deviceCategory = '';
		   deviceCategoryText='';
		  }
		  else
		  {
			  error_deviceCategory = '';
		   $('#error_deviceCategory').text(error_deviceCategory);
		   $('#deviceCategory').css('border-color', '');
		   deviceCategory = $('#deviceCategory').val();
		   deviceCategoryText=$('#deviceCategory option:selected').text();
		  }
		  if($('#make').val() == '')
		  {
			  error_make = 'make is required';
		   $('#error_make').text(error_make);
		   $('#make').css('border-color', '#cc0000');
		   make = '';
		   makeText='';
		  }
		  else
		  {
			  error_make = '';
		   $('#error_make').text(error_make);
		   $('#make').css('border-color', '');
		   make = $('#make').val();
		   makeText=$('#make option:selected').text();
		  }
		  
		  if($('#deviceType').val() == '')
		  {
			  error_deviceType = 'Type is required';
		   $('#error_deviceType').text(error_deviceType);
		   $('#deviceType').css('border-color', '#cc0000');
		   deviceType = '';
		   deviceTypeText='';
		  }
		  else
		  {
			  error_deviceType = '';
		   $('#error_deviceType').text(error_deviceType);
		   $('#deviceType').css('border-color', '');
		   deviceType = $('#deviceType').val();
		   deviceTypeText=$('#deviceType option:selected').text()
		  }
		  
		  if($('#deviceCapacity').val() == '')
		  {
			  error_deviceCapacity = 'Capacity is required';
		   $('#error_deviceCapacity').text(error_deviceCapacity);
		   $('#deviceCapacity').css('border-color', '#cc0000');
		   deviceCapacity = '';
		   deviceCapacityText='';
		  }
		  else
		  {
			  error_deviceCapacity = '';
		   $('#error_deviceCapacity').text(error_deviceCapacity);
		   $('#deviceCapacity').css('border-color', '');
		   deviceCapacity = $('#deviceCapacity').val();
		   deviceCapacityText=$('#deviceCapacity option:selected').text();
		  }
		  
		  if($('#deviceStatus').val() == '')
		  {
			  error_deviceStatus = 'Status is required';
		   $('#error_deviceStatus').text(error_deviceStatus);
		   $('#deviceStatus').css('border-color', '#cc0000');
		   deviceStatus = '';
		   deviceStatusText='';
		  }
		  else
		  {
			  error_deviceStatus = '';
		   $('#error_deviceStatus').text(error_deviceStatus);
		   $('#deviceStatus').css('border-color', '');
		   deviceStatus = $('#deviceStatus').val();
		   deviceStatusText=$('#deviceStatus  option:selected').text();
		  }
		  if(error_deviceName != '' || error_connectedLoad != '' )
		  {
		   return false;
		  }
		  else
		  {
			  
			 
		   if($('#save').text() == 'Save')
		   {
			  
		    output = '<tr id="row_'+count+'">';
		    output += '<td>'+deviceName+' <input type="hidden" name="compInputList['+count+'].deviceName" id="deviceName'+count+'" class="deviceName" value="'+deviceName+'" /></td>';
		    output += '<td>'+connectedLoad+' <input type="hidden" name="compInputList['+count+'].connectedLoad" id="connectedLoad'+count+'" value="'+connectedLoad+'" /></td>';
		    output += '<td>'+actualLoad+' <input type="hidden" name="compInputList['+count+'].actualLoad" id="actualLoad'+count+'" class="actualLoad" value="'+actualLoad+'" /></td>';
		    output += '<td>'+rpm+' <input type="hidden" name="compInputList['+count+'].rpm" id="rpm'+count+'" value="'+rpm+'" /></td>';
		  
		    output += '<td>'+deviceCategoryText+' <input type="hidden" name="compInputList['+count+'].deviceCategory" id="deviceCategory'+count+'" class="pumpEndTime" value="'+deviceCategory+'" /></td>';
		    output += '<td>'+makeText+' <input type="hidden" name="compInputList['+count+'].make" id="make'+count+'" value="'+make+'" /></td>';
		    output += '<td>'+deviceTypeText+' <input type="hidden" name="compInputList['+count+'].deviceType" id="deviceType'+count+'" value="'+deviceType+'" /></td>';
		    output += '<td>'+deviceCapacityText+' <input type="hidden" name="compInputList['+count+'].deviceCapacity" id="deviceCapacity'+count+'" value="'+deviceCapacity+'" /></td>';
		    output += '<td>'+deviceStatusText+' <input type="hidden" name="compInputList['+count+'].deviceStatus" id="deviceStatus'+count+'" value="'+deviceStatus+'" /></td>';
		  
		    
		    
		    output += '<td><button type="button" name="view_details" class="btn btn-warning btn-xs view_details" id="'+count+'">View</button></td>';
		    output += '<td><button type="button" name="remove_details" class="btn btn-danger btn-xs remove_details" id="'+count+'">Remove</button></td>';
		    output += '</tr>';
		   
		    count = count + 1;
		    $('#user_data').append(output);
		   }
		   else
		   {
		    var row_id = $('#hidden_row_id').val();
		    output = '<td>'+deviceName+' <input type="hidden" name="compInputList['+row_id+'].deviceName" id="deviceName'+row_id+'" class="deviceName" value="'+deviceName+'" /></td>';
		    output += '<td>'+connectedLoad+' <input type="hidden" name="compInputList['+row_id+'].connectedLoad" id="connectedLoad'+row_id+'" value="'+connectedLoad+'" /></td>';
		    output += '<td>'+actualLoad+' <input type="hidden" name="compInputList['+row_id+'].actualLoad" id="actualLoad'+row_id+'" value="'+actualLoad+'" /></td>';
		    output += '<td>'+rpm+' <input type="hidden" name="compInputList['+row_id+'].rpm" id="rpm'+row_id+'" value="'+rpm+'" /></td>';
		    output += '<td>'+deviceCategoryText+' <input type="hidden" name="compInputList['+row_id+'].deviceCategory" id="deviceCategory'+row_id+'" value="'+deviceCategory+'" /></td>';
		    output += '<td>'+makeText+' <input type="hidden" name="compInputList['+row_id+'].make" id="make'+row_id+'" value="'+make+'" /></td>';
		    output += '<td>'+deviceTypeText+' <input type="hidden" name="compInputList['+row_id+'].deviceType" id="deviceType'+row_id+'" value="'+deviceType+'" /></td>';
		    output += '<td>'+deviceCapacityText+' <input type="hidden" name="compInputList['+row_id+'].deviceCapacity" id="deviceCapacity'+row_id+'" value="'+deviceCapacity+'" /></td>';
		    output += '<td>'+deviceStatusText+' <input type="hidden" name="compInputList['+row_id+'].deviceStatus" id="deviceStatus'+row_id+'" value="'+deviceStatus+'" /></td>';
		    output += '<td><button type="button" name="view_details" class="btn btn-warning btn-xs view_details" id="'+row_id+'">View</button></td>';
		    output += '<td><button type="button" name="remove_details" class="btn btn-danger btn-xs remove_details" id="'+row_id+'">Remove</button></td>';
		    $('#row_'+row_id+'').html(output);
		   }

		   $('#user_dialog').dialog('close');
		  }
		 });

		 $(document).on('click', '.view_details', function(){
		  var row_id = $(this).attr("id");
		  var deviceName = $('#deviceName'+row_id+'').val();
		  var connectedLoad = $('#connectedLoad'+row_id+'').val();
		  var actualLoad = $('#actualLoad'+row_id+'').val();
		  var rpm = $('#rpm'+row_id+'').val();
		  var deviceCategory = $('#deviceCategory'+row_id+'').val();
		  var make = $('#make'+row_id+'').val();
		  var deviceType = $('#deviceType'+row_id+'').val();
		  var deviceCapacity = $('#deviceCapacity'+row_id+'').val();
		  var deviceStatus = $('#deviceStatus'+row_id+'').val();
		 
		  $('#deviceName').val(deviceName);
		  $('#connectedLoad').val(connectedLoad);
		  $('#actualLoad').val(actualLoad);
		  $('#rpm').val(rpm);
		  $('#deviceCategory').val(deviceCategory);
		  $('#make').val(make);
		  $('#deviceType').val(deviceType);
		  $('#deviceCapacity').val(deviceCapacity);
		  $('#deviceStatus').val(deviceStatus);
		  $('#save').text('Edit');
		  $('#hidden_row_id').val(row_id);
		  $('#user_dialog').dialog('option', 'title', 'Edit Data');
		  $('#user_dialog').dialog('open');
		 });

		 $(document).on('click', '.remove_details', function(){
		  var row_id = $(this).attr("id");
		  if(confirm("Are you sure you want to remove this row data?"))
		  {
		   $('#row_'+row_id+'').remove();
		  }
		  else
		  {
		   return false;
		  }
		 });

		 $('#action_alert').dialog({
		  autoOpen:false
		 });

		 $('#user_form').on('submit', function(event){
		  event.preventDefault();
		  var count_data = 0;
		  $('.deviceName').each(function(){
		   count_data = count_data + 1;
		  });
		  if(count_data > 0)
		  {
		   var form_data = $(this).serialize();
		   alert("form"+form_data);
	/* 	   $.ajax({
		    url:"../comptsimis/getLiftCompInput",
		    method:"POST",
		    data:form_data,
		    success:function(data)
		    {
		     $('#user_data').find("tr:gt(0)").remove();
		     $('#action_alert').html('<p>Data Inserted Successfully</p>');
		     $('#action_alert').dialog('open');
		    }
		   }) */
		   
		   
		   document.forms.user_form.action = "../comptsimis/getLiftCompInput";
			document.forms.user_form.submit();
		  }
		  else
		  {
		   $('#action_alert').html('<p>Please Add atleast one data</p>');
		   $('#action_alert').dialog('open');
		  }
		 });

	});
	</script>
 
 <script>
function getProjects(){
	
	 
    var   unitId=$('#unitId').val();
      
  //  alert("procId"+procId);
	//$('#projectId').multiselect('rebuild');


	$.ajax({	          
	      url: "../web/getProjects?unitId="+unitId,
	      type: "GET",
	      success: function (response) {
	    	  var $select = $('#projectId');
	  				$select.find('option').remove();
	  				
	  				var selectedProj=$('#selectedProjId').val();
	  					
	  					var obj = JSON.parse(response);
	  					
	  				$('#projectId').append( '<option value=" "> --select--</option>' );
	  					
	  					$.each(obj, function(key, value) {
	  						
	  						if(selectedProj==value.projectId){	
	  						
	  					$('#projectId').append( '<option value="'+value.projectId+'" selected="selected"> '+value.projectName+'</option>' );
	  					
	  						}
	  						
	  						if(selectedProj==null||selectedProj!=value.projectId){
	  							$('#projectId').append( '<option value="'+value.projectId+'"> '+value.projectName+'</option>' );	
	  						
	  						}
	  			//	$('#projectId').multiselect('rebuild')
	  				
	  				
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
	      error : function(){
	    	  alert(error);
	      }
	  });	
	} 

function getParents(projId){
	
	 
    var   projectId=projId;
    	//$('#projectId').val();
      
  //  alert("kal"+projectId);
//	$("#componentId").multiselect('rebuild');
	
	//  alert("kal2");

	$.ajax({	          
	      url: "../comptsimis/getparent?projectId="+projectId,
	      type: "GET",
	      success: function (response) {
	    	  //alert("res"+response)
	    	  var $select = $('#componentId');
	  				$select.find('option').remove();
	  				
	  				var selectedCompId=$('#selectedCompId').val();
	  					
	  					var obj = JSON.parse(response);
	  					
	  				$('#componentId').append( '<option value="0"> --select--</option>' );
	  					
	  					$.each(obj, function(key, value) {
	  						
	  						if(selectedCompId==value.componentId){	
	  						
	  						
	  					$('#componentId').append( '<option value="'+value.componentId+'" selected="selected"> '+value.componentName+'</option>' );
	  					
}
	  						
	  						if(selectedCompId==null||selectedCompId!=value.componentId){
	  						
	  							$('#componentId').append( '<option value="'+value.componentId+'"> '+value.componentName+'</option>' );
	  							
	  						}
	  					
	  				//$('#componentId').multiselect('rebuild');
	  				
	  				
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
	      error : function(){
	    	  alert(error);
	      }
	  });	
	} 
	
</script>




<script>

	$(function() {
		
		
		$("#powerConsumeMonth").datepicker({
			changeYear : true,
			changeMonth : true,
			dateFormat : "dd/mm/yy",
		/*  onSelect: function(selected) {
		   $("#month").datepicker("option","minDate", selected)
		 } */
		});
		
		$("#dueDate").datepicker({
			changeYear : true,
			changeMonth : true,
			dateFormat : "dd/mm/yy",
		/*  onSelect: function(selected) {
		   $("#month").datepicker("option","minDate", selected)
		 } */
		});
		
		$("#disconnectionDate").datepicker({
			changeYear : true,
			changeMonth : true,
			dateFormat : "dd/mm/yy",
		/*  onSelect: function(selected) {
		   $("#month").datepicker("option","minDate", selected)
		 } */
		});
		
		
		
		
		$("#presentunit").keyup(function(){
			   
           var a =   parseFloat($("#presentunit").val());
			 
			 var b =   parseFloat($("#previousunit").val());
			 
			 //alert("a"+a);
			 //alert("b"+b);
			 
			 var c=parseFloat(a-b);
			 
			
			 
			 $("#totalUnitsConsumed").val(c);
			   
			   
		   });
		
		
		$("#fixedCharges").keyup(function(){
			 var d =   parseFloat($("#fixedCharges").val());
			 var e =   parseFloat($("#billCost").val());
			 var f =   parseFloat($("#penalityCharges").val());
			 
			
			 var i=parseFloat(d+e+f)
			
			
			 $("#netBillCost").val(i);
			
		   });
		
		$("#billCost").keyup(function(){
			 var d =   parseFloat($("#fixedCharges").val());
			 var e =   parseFloat($("#billCost").val());
			 var f =   parseFloat($("#penalityCharges").val());
			
			
			 var i=parseFloat(d+e+f)
			
			
			 $("#netBillCost").val(i);
			
		   });
		
		$("#penalityCharges").keyup(function(){
			 var d =   parseFloat($("#fixedCharges").val());
			 var e =   parseFloat($("#billCost").val());
			 var f =   parseFloat($("#penalityCharges").val());
			
			
			 var i=parseFloat(d+e+f)
			
			
			 $("#netBillCost").val(i);
			
		   });
		
		$("#additionalDeposit").keyup(function(){
			 var d =   parseFloat($("#fixedCharges").val());
			 var e =   parseFloat($("#billCost").val());
			 var f =   parseFloat($("#penalityCharges").val());
			
			
			 var i=parseFloat(d+e+f)
			
			
			 $("#netBillCost").val(i);
			
		   });

		
		

	});
	
	
	 
</script>
<c:if test="${userObj!=null}">
						<div class="row-fluid  ">

							<div class="span6 pull-right">
								<p class="rowBlue">
									<c:out value="${userObj.employeeName}"></c:out>
								</p>
							</div>
						</div>
					</c:if>
						<c:if test="${msg!=null || err!=null }">


							<div class="row show-grid">
								<c:if test="${msg!=null}">
									<div class="alert alert-success" role="alert">
										<strong></strong>
										<c:out value="${msg}"></c:out>
										
									</div>

								</c:if>

								<c:if test="${err!=null}">
									<div class="alert alert-danger" role="alert">
										<strong></strong>
										<c:out value="${err}"></c:out>
										
										
										
									</div>

								</c:if>

							</div>
						</c:if>

					


<div class="w3l-main" id="borderStyle">


	<!-- <div class="col-md-12 agile_banner_bottom_grids">
		<div
			style="display: block; width: 100%; margin-left: 10px; margin-right: 10px;">

			<div class="resp-tabs-container">
				<div
					class="w3layouts_vertical_tab resp-tab-content resp-tab-content-active"
					style="display: block">

 -->




					


				



				
                   
				

						<div class="panel panel-primary ">
							<div class="panel-heading">
								<h3 class="panel-title">Component Data Input</h3>
							</div>
							
							
   			<form:form id="user_form" method="post" modelAttribute="componentlist" >
								
	<div class='container'>



									<div class="row col-md-12  ">


                                  

                                       <div class="col-sm-12">
                                       
                                       
                                       
											<div class="col-md-2">
												<label class="label-controlPMS rowlebel ">Select
													Unit</label> 
													</div>
													
													<div class="col-md-2">
													
													
													<select class="form-control" id="unitId"
													name="unitId" onchange="getProjects()">
													
													 <c:forEach items="${unitList}" var="u">
									              <option value="${u.unitId}">${u.unitName}</option>

								</c:forEach>
 
												</select>
											</div>
                                       
										


											<div class="col-md-2">
												<label class="label-controlPMS rowlebel ">Select
													Project</label> 
													</div>
													
													<div class="col-md-2">
													
													
													<select class="form-control" id="projectId"
													name="projectId" onchange="getParents(this.value)">
													
													 <c:forEach items="${newprList}" var="u">
									              <option value="${u.projectId}">${u.projectName}</option>

								</c:forEach>
 
												</select>
											</div>






											<div class="col-md-2" >
												<label class="label-control rowlebel ">Select
													Component*</label> 
													
													</div>
													<div class="col-md-2">
													
													<select class="form-control" id="componentId"
													name="componentId" 
													required>
													<option value="0">--select--</option>


												</select>




											</div>

											
											
											
										
												
											
											
										
													
													
											
													
													
										
										
											</div>
											



										
















										<div class="col-md-12">

 <br></br>
											<div class="col-md-2">
												<label class="label-control rowlebel ">Remarks</label>
												</div>
												<div class="col-md-6">
												<textarea class="form-control" id="remarks" name="remarks"></textarea>
												</div>
											
											<div class="col-md-2">
											<label class="label-control rowlebel "></label>
											</div>
											<div class="col-md-2">
											
											  <button type="button" name="add" id="add" class="btn btn-primary" >Add</button>
											</div>

										</div>

</div>

 <div align="right" style="margin-bottom:5px;">
  
   </div>
   <br />
									


<div class="col-md-12">
<br></br>
  <div class="table-responsive">
     <table class="table table-striped table-bordered" id="user_data">
      <tr>
       <th> Name</th>
       <th>Connected Load</th>
       <th>Actual Load</th>
       <th>RPM</th>
       <th>Device Category</th>
       <th>Make</th>
       <th>Device Type</th>
       <th>Device Capacity</th>
       <th>Device Status</th>
      
      </tr>
     </table>
    </div>
      </div>
      
      <div class="col-sm-12">
										<div class="col-md-2 "></div>
										<div class="col-md-8 ">
											<label class="label-control rowlebel "></label><input
												type="submit" class="btn btn-1 btn-primary center-block"
												id="insert" value="Submit">
										</div>
									</div>
      
   <!--  <div class="row showgrid"align="center">
     <input type="submit" name="insert" id="insert" class="btn btn-primary" value="Submit" />
    </div>
   -->



									
									<!-- row -->







								
								
								</div>
							</form:form>
							 <br />
							</div>
							<!-- </div> -->
							</div>
							
							
							 <div id="user_dialog" title="Add Data">
   <div class="form-group">
    <label>Enter Pump/Motor Name</label>
    <input type="text" name="deviceName" id="deviceName" class="form-control" />
    <span id="error_deviceName" class="text-danger"></span>
   </div>
   <div class="form-group">
    <label>Connected Load</label>
    <input type="text" name="connectedLoad" id="connectedLoad" class="form-control" />
    <span id="error_connectedLoad" class="text-danger"></span>
   </div>
    <div class="form-group">
    <label> Actual Load</label>
    <input type="text" name="actualLoad" id="actualLoad" class="form-control" />
    <span id="error_actualLoad" class="text-danger"></span>
   </div>
    <div class="form-group">
    <label>RPM</label>
    <input type="text" name="rpm" id="rpm" class="form-control" />
    <span id="error_rpm" class="text-danger"></span>
   </div>
    <div class="form-group">
    <label>Category</label>
    <select class="form-control" id="deviceCategory" name="deviceCategory" required> <option value="0">--select--</option> <option value="P">Pump</option> <option value="M">Motor</option> </select>
    
    <span id="error_deviceCategory" class="text-danger"></span>
   </div>
    <div class="form-group">
    <label>Select Make</label>
    <select class="form-control" id="make" name="make"   required> <option value="0">--select--</option> <c:forEach items="${motormake}" var="p"> <option value="${p.motormakeId}">${p.motormakeName}</option> </c:forEach> </select>
   
    <span id="error_make" class="text-danger"></span>
   </div>
     <div class="form-group">
    <label>Select Type</label>
    <select class="form-control" id="deviceType" name="deviceType"  required> <option value="0">--select--</option> <c:forEach items="${motortype}" var="p"> <option value="${p.motortypeId}">${p.motortypeName}</option> </c:forEach> </select>
    
    <span id="error_deviceType" class="text-danger"></span>
   </div>
     <div class="form-group">
    <label>Select Capacity</label>
    <select class="form-control" id="deviceCapacity" name="deviceCapacity"  required> <option value="0">--select--</option> <option value="1">Small</option> <option value="2">Medium</option> <option value="3">Major</option> </select>
   
    <span id="error_deviceCapacity" class="text-danger"></span>
   </div>
     <div class="form-group">
    <label>Select Status</label>
    <select class="form-control" id="deviceStatus" name="deviceStatus" required> <option value="0">--select--</option> <option value="1">Service</option> <option value="2">Execution</option> </select>
   
    <span id="error_deviceStatus" class="text-danger"></span>
   </div>
   <div class="form-group" align="center">
    <input type="hidden" name="row_id" id="hidden_row_id" />
    <button type="button" name="save" id="save" class="btn btn-info">Save</button>
   </div>
  </div>
  <div id="action_alert" title="Action">

  </div>

						
					





				




<!-- <!-- //main-content -->
<!-- <script type="text/javascript" src="../js/parsley.js"></script>
 -->


<!-- <script type="text/javascript" class="example">
	$(function() {
		$('#compmonthly').parsley().on('field:validated', function() {
			var ok = $('.parsley-error').length === 0;

			// alert('hi');

		})

		.on('form:submit', function() {
			// alert("coming here");

			document.forms.compmonthly.action = "../comptsimis/compmonthlypower";
			document.forms.compmonthly.submit();

			// Don't submit form for this demo
		});
	});
</script> -->



 