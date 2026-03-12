
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







<script type="text/javascript">



//alert("kal1");
var rowCount = 0

function addParas(frm) {
	//alert("kal2");
	
	
	rowCount++;
	
	var recRow = '<div class="row show-grid" style="border: 2px solid MediumSeaGreen;" id="rowCount'+rowCount+'"><div class="col-md-2"><label class="label-control rowlebel ">S.No</label></div><div class="col-md-2"><strong>'+rowCount+'</strong></div>'
	
	+ '<div class="col-md-12"><label class="label-control rowlebel ">Reply Title*</label> <input type="text" class="form-control"  id="paraList['+rowCount+'].replyTitle" name="paraList['+rowCount+'].replyTitle" placeholder="Title"  required/> '
	+ '<label class="label-controlPMS rowlebel ">Reply*</label><textarea class=" ckedit form-control "  id="paraList['+rowCount+'].reply" name="paraList['+rowCount+'].reply" rows="10" cols="80" placeholder="Reply"  required></textarea></div>'
	
	+ '<div class="col-md-12"><label class="label-control rowlebel "></label><input type="button" class="btn btn-1 btn-danger center-block"	id="deletePara" value="Delete Para" onclick="removeRow('+ rowCount + ')" ></div></div>';
	
	
	
jQuery('#addedIrparas').append(recRow);

var elem = $(this).find('.ckedit')
elem.ckeditor();

//alert("coming here")
$('.ckedit').ckeditor();
clicked();
//alert("kalnow");
$(".datepick").datepicker({
	changeYear : true,
	changeMonth : true,
	dateFormat : "dd/mm/yy",
/*  onSelect: function(selected) {
   $("#month").datepicker("option","minDate", selected)
 } */
});



	
}

function removeRow(removeNum) {
	jQuery('#rowCount' + removeNum).remove();
}
	
	
function clicked(){
	for ( instance in CKEDITOR.instances ){
		
		CKEDITOR.instances[instance].getData();
	//alert("ckeditor values : " + CKEDITOR.instances[instance].getData());
	}
	}
</script>




<script type="text/javascript">

$(document).ready(function(){
	
	 $("#toffice").hide();
		 
	$('#unitId').multiselect({
		 
		 enableCaseInsensitiveFiltering: true
		 
	});

	$('#circleId').multiselect({
		 
		 enableCaseInsensitiveFiltering: true
		 
	});

	$('#divisionId').multiselect({
		 
		 enableCaseInsensitiveFiltering: true
		 
	});
	
	$('#subdivisionId').multiselect({
		 
		 enableCaseInsensitiveFiltering: true
		 
	});
	
	$('#financialYear').multiselect({
		 
		 enableCaseInsensitiveFiltering: true
		 
	});

	



	$('#categoryId').multiselect({
		 
		 enableCaseInsensitiveFiltering: true
		 
	});
	
	$('#categorySequence').multiselect({
		 
		 enableCaseInsensitiveFiltering: true
		 
	});
	
	$('#categoryseqNumber').multiselect({
		 
		 enableCaseInsensitiveFiltering: true
		 
	});
	
	$('#paraStatusId').multiselect({
		 
		 enableCaseInsensitiveFiltering: true
		 
	});
	
	$('#statusId').multiselect({
		 
		 enableCaseInsensitiveFiltering: true
		 
	});
	
	
	
	

	}); 



function getcompParent(){
	
	 
    var   componentId=$('#componentId').val();
      
   // alert("kal"+projectId);
	$('#parentComponentId').multiselect('rebuild');
	
	//  alert("kal2");

	$.ajax({	          
	     // url: "../comptsimis/getParentComp?componentId="+componentId,
	      type: "GET",
	      success: function (response) {
	    	//  alert("res"+response)
	    	  var $select = $('#parentComponentId');
	  				$select.find('option').remove();
	  				
	  			
	  					
	  					var obj = JSON.parse(response);
	  					
	  				$('#parentComponentId').append( '<option value="0"> --select--</option>' );
	  					
	  					$.each(obj, function(key, value) {
	  						
	  						
	  					if(value.componentId==-1){
	  					$('#parentComponentId').append( '<option value="'+value.componentId+'"> No parent </option>' );
	  					}
	  					if(value.componentId!=-1){
	  						
	  						$('#parentComponentId').append( '<option value="'+value.componentId+'" selected="selected">'+value.componentName+'</option>' );	
	  						
	  					}
	  					
	  				$('#parentComponentId').multiselect('rebuild')
	  				
	  				
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


function getcompPackage(){
	
	 
    var   componentId=$('#componentId').val();
      
   // alert("kal"+projectId);
	$('#compPackId').multiselect('rebuild');
	
	 // alert("kal2");

	$.ajax({	          
	     // url: "../comptsimis/getCompPackage?componentId="+componentId,
	      type: "GET",
	      success: function (response) {
	    	//  alert("res"+response)
	    	  var $select = $('#compPackId');
	  				$select.find('option').remove();
	  				
	  			
	  					
	  					var obj = JSON.parse(response);
	  					
	  				$('#compPackId').append( '<option value="0"> --select--</option>' );
	  					
	  					$.each(obj, function(key, value) {
	  						
	  						if(value.pkgId){
	  						
	  					$('#compPackId').append( '<option value="'+value.pkgId+'" selected="selected"> '+value.pkgName+'</option>' );
	  						}
	  					
	  				$('#compPackId').multiselect('rebuild')
	  				
	  				
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
function getParents(){
	
	 
    var   projectId=$('#projectId').val();
      
  //  alert("kal"+projectId);
	$("#componentId").multiselect('rebuild');
	
	//  alert("kal2");

	$.ajax({	          
	      //url: "../comptsimis/getparent?projectId="+projectId,
	      type: "GET",
	      success: function (response) {
	    	  //alert("res"+response)
	    	  var $select = $('#componentId');
	  				$select.find('option').remove();
	  				
	  			
	  					
	  					var obj = JSON.parse(response);
	  					
	  				$('#componentId').append( '<option value="0"> --select--</option>' );
	  					
	  					$.each(obj, function(key, value) {
	  						
	  						
	  						
	  					$('#componentId').append( '<option value="'+value.componentId+'"> '+value.componentName+'</option>' );
	  					
	  				$('#componentId').multiselect('rebuild')
	  				
	  				
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
		
		var m = $(this).find('.ckedit')
		m.ckeditor();

		//alert("coming here")
		$('.ckedit').ckeditor();
		clicked();
		
		 $("#paraStatusId").change(function(){
			alert("kalres");

		var myunittr= parseInt($(this).val()); 
		alert(myunittr);
		if(myunittr==2){
			
			 $("#toffice").show();
			
		}else{
			$("#toffice").hide();
			
		}
		
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
										<c:out value="${msg	}"></c:out>
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

<div class="w3_agile_main_left">






						<div class="panel panel-primary ">
							<div class="panel-heading">
								<h3 class="panel-title">Paras Input</h3>
							</div>
							<form:form id="parasinput" method="post" modelAttribute="irparas"
								data-parsley-validate-if-empty="">
								<div class='container'>




									<div class="row col-md-12 toppad ">



										<div class="row show-grid">




											<div class="col-md-3">
												<label class="label-controlPMS rowlebel ">Select
													Unit</label>
													<select class="form-control" id="unitId" name="unitId" >
												<%-- <option value="0">--select--</option>
												onchange="getCircles()"
												 <c:forEach items="${newprList}" var="u">
									              <option value="${u.projectId}">${u.projectName}</option>

								</c:forEach>
  --%>
												
												
												</select>
											</div>
										

											
											
												<div class="col-md-3">
												<label class="label-control rowlebel ">Select Circle*</label>
												<select class="form-control" id="circleId" name="circleId" 
													required>
													<option value="0">--select--</option>
													<!-- onchange="getDivisions()" -->


												</select>

											</div>
										
											


											<div class="col-md-3">
												<label class="label-controlPMS rowlebel ">Select Division</label>
												<select class="form-control" id="divisionId" name="divisionId">
	</select>
											</div>
											
											
												<div class="col-md-3">
												<label class="label-control rowlebel ">Select SubDivision
													*</label>
														<select class="form-control" id="subdivisionId" name="subdivisionId"
													required>
													


												</select>
													
											</div>
											
											

											
										
										</div>
										
										<div class="row show-grid">
										<div class="col-md-3">
											<label class="label-control rowlebel ">Financial Year*</label>
											 <select class="form-control" id="financialYear" name="financialYear" required> 
											 <option value="2008-09">2008-09</option>  
											 <option value="2009-10">2009-10</option>
											 <option value="2010-11">2010-11</option>
											 <option value="2011-12">2011-12</option>
											 </select></div> 
											
											  <div class="col-md-3">
										<label class="label-controlPMS rowlebel ">
										Select Section*</label>
										<select class="form-control" id="categoryId" name="categoryId" required> 
										<option value="0">--select--</option>  
										<option value="1">Section-A</option>
										<option value="2">Section-B</option>
										<option value="3">CAG Report</option>
										</select> </div>
										
										
										<div class="col-md-3">
										<label class="label-controlPMS rowlebel ">
										Select Category</label><select class="form-control" id="categorySequence" name="categorySequence"  required>
										 <option value="0">--select--</option> 
										 <option value="A">A</option> 
										 <option value="B">B</option>
										  <option value="C">C</option> 
										  <option value="D">D</option>
										  <option value="E">E</option>
										  <option value="F">F</option>
										  <option value="G">G</option>
										   <option value="H">H</option>
										   <option value="I">I</option>
										   <option value="J">J</option></select>
										    </div>
										    	<div class="col-md-3">
										    <label class="label-controlPMS rowlebel ">
										    Select CategorySequence </label>
										    <select class="form-control" id="categoryseqNumber" name="categoryseqNumber"  required>
										     <option value="0">--select--</option> 
										     <option value="I">I</option> 
										     <option value="II">II</option> 
										     <option value="III">III</option>
										      <option value="IV">IV</option>
										      <option value="V">V</option>
										      <option value="VI">VI</option>
										      <option value="VII">VII</option>
										      <option value="VIII">VIII</option>
										      <option value="IX">IX</option>
										      <option value="X">X</option>
										      <option value="XI">XI</option>
										      <option value="XII">XII</option>
										      </select> </div>
											  
											
										</div>
										<div class="row show-grid">
									
										  <div class="col-md-3">
										<label class="label-controlPMS rowlebel ">
										Select Para Status </label>
										<select class="paratrunit form-control" id="paraStatusId" name="paraStatusId"  required> 
										<option value="0">--select--</option> 
										<option value="1">Dropped</option> 
										<option value="2">Transferred </option>
										<option value="3">Terminated</option>
										<option value="4">Closed</option> </select> </div>
										
										<div class="col-md-3">
										<label class="label-controlPMS rowlebel ">
										Select Status </label>
										<select class="form-control" id="statusId" name="statusId"  required> 
										<option value="0">--select--</option> 
										<option value="1">Reply Sent to AG</option> 
										<option value="2">Transferred </option>
										<option value="3">Reply Not Sent</option></select> 
										</div>
										 <div class="col-md-3">
											 <label class="label-control rowlebel ">Select Month*</label>
											  <input type="text" class="datepick form-control datepicker"  id="paraMonth" name="paraMonth" placeholder="MonthPara"  required/> 
											  </div>
										</div>
										  
										  <div class="row show-grid" id="toffice">




											<div class="col-md-3">
												<label class="label-controlPMS rowlebel ">Transferred
													Unit</label>
													<select class="form-control" id="tunitId" name="tunitId" >
												<%-- <option value="0">--select--</option>
												onchange="getCircles()"
												 <c:forEach items="${newprList}" var="u">
									              <option value="${u.projectId}">${u.projectName}</option>

								</c:forEach>
  --%>
												
												
												</select>
											</div>
										

											
											
												<div class="col-md-3">
												<label class="label-control rowlebel ">Transferred Circle*</label>
												<select class="form-control" id="tcircleId" name="tcircleId" 
													required>
													<option value="0">--select--</option>
													<!-- onchange="getDivisions()" -->


												</select>

											</div>
										
											


											<div class="col-md-3">
												<label class="label-controlPMS rowlebel ">Transferred Division</label>
												<select class="form-control" id="tdivisionId" name="tdivisionId">
	</select>
											</div>
											
											
												<div class="col-md-3">
												<label class="label-control rowlebel ">Transferred Sub Division
													*</label>
														<select class="form-control" id="tsubdivisionId" name="tsubdivisionId"
													required>
													


												</select>
													
											</div>
											
											

											
										
										</div>
										  <div class="row show-grid">
										    
											  <div class="col-md-12">
											  <label class="label-control rowlebel ">Para Title*</label> 
											  <input type="text" class="form-control"  id="actionTitle" name="actionTitle" placeholder="Title"  required/>
										
										</div>
										 <div class="col-md-12">
										<label class="label-control rowlebel ">Gist Of Para*</label> 
										<textarea class="ckedit form-control "  id="parasAction" name="parasAction" rows="10" cols="80" placeholder="Para"  required></textarea>
										</div>
										
										
										      
										      <div class="col-md-8">
										      <label class="label-control rowlebel ">Para Remarks*</label>
										       <textarea class="form-control"  id="remarks" name="remarks"  rows="5" cols="80"placeholder="Remarks"  required></textarea> 
										       </div>
										       
										       <div class="col-md-4">
											<label class="label-control rowlebel "></label><input
												type="button" class="btn btn-1 btn-primary center-block"
												id="addpara" value="Add Replys"
												onclick="addParas(this.form)">
										</div>
										
										 <div class="col-md-6"  >
										 <label class="label-controlPMS rowlebel ">Upload Files</label>
								<input id="" name="orderFile" type="file"
									class="btn-info" value="Upload Documents"  multiple="multiple">
							</div>

									</div>
									
									
									

									</div>
									
									

								
								

									<div class="col-md-12">

										<div id="addedIrparas"></div>
									</div>

									








								


									<div class="col-sm-12">
										<div class="col-md-2 "></div>
										<div class="col-md-8 ">
											<label class="label-control rowlebel "></label><input
												type="submit" class="btn btn-1 btn-primary center-block"
												id="submitparas" value="Submit IRParas">
										</div>
									</div>







								</div>
								<!-- row -->





							</form:form>

						</div>
						


						


</div>
<!-- //main-content -->
<script type="text/javascript" src="../js/parsley.js"></script>



<script type="text/javascript" class="example">
	$(function() {
		$('#parasinput').parsley().on('field:validated', function() {
			var ok = $('.parsley-error').length === 0;

			// alert('hi');

		})

		.on('form:submit', function() {
			// alert("coming here");

			document.forms.parasinput.action = "../parastsimis/parasinput";
			document.forms.parasinput.submit();

			// Don't submit form for this demo
		});
	});
</script>

