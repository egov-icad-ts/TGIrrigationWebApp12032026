

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
	
	/* $('#pumpId').multiselect({
		 
		 enableCaseInsensitiveFiltering: true
		 
	}); */
	
	
	
	

	}); 
	
	
$(function() {
	
	
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


				
	
});



</script>

<div class="col-md-9">
	


<div>

	

	
	<div class="panel panel-primary " >
		<div class="panel-heading">
			<h3 class="panel-title">O&M of Lift:Pumstation Operation Instructions</h3>
		</div>
			
		
<div class="panel-body">	
	
	<div class="alert alert-info col-md-12" style="padding: 0px"
				id="action_alert"></div>
		

		<div  class=" col-md-12 invDiv">
		
		
		
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
						<label class="label-controlPMS rowlebel ">Select Pump Scheme: <font
							color=red>*</font>
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
					
					
						<div class="col-md-6">
						<label class="label-controlPMS rowlebel ">Select Pump: <font
							color=red>*</font>
						</label>
					</div>

					<div class="col-md-6">
						<select class="form-control" id="pumpId" name="pumpId"
							 required>
							<option value=" ">--select--</option>
							<option value=" ">Pump1</option>
							<option value=" ">pump2</option>
							
							

						</select>
					</div>
					
				
						<div class="col-md-6">
						<label class="label-controlPMS rowlebel ">Is Pump Running Condition: <font
							color=red>*</font>
						</label>
					</div>	
					
		           <div class="col-md-6">
					
        <label class="radio-inline"> <input type="radio" name="checkradio1" id="checkradio1"  checked="checked"    value="true"  required >Yes</label>
        <label class="radio-inline"> <input type="radio" name="checkradio1" id="checkradio1"     value="false"  required >No</label>
       
          
    </div> 
		           

				
					

		
		
		</div>
	
		
		
		<div id="result" class="col-md-12">
	<div class="wrapper">
		
			<div id="tabs">
				<ul>
				<c:if test="${potList1!=null}">
				  <c:forEach items="${potList1}" var="m" varStatus="mcount">
					<li><a href="#tab${mcount.count}">${m.pumpOperationType}</a></li>
					</c:forEach>
					</c:if>
					
					
				</ul>
				
				  <c:forEach items="${potList1}" var="n" varStatus="ncount">
				<div id="tab${ncount.count}">
				
				
				
				<c:if test="${n.pumpOperationTypeId==6}">
						
						<div class="alert alert-info" role="alert">
             In case of pumping stations,  there is  normal stop only. No emergency stop as both are almost same. 
                    </div>
						
						</c:if>
						
							
				
						
				
					<form method="post" action="LoginController">
					
					
						<c:if test="${pumpoperationinst!=null}">
						  <c:forEach items="${pumpoperationinst}" var="k" varStatus="kcount">
					<c:if test="${n.pumpOperationTypeId==k.pumpInstructType}">
					
					 <div class="row">
						 <div class="col-md-2">
                    ${k.pumpInstructSeq}
                     </div> 
                     <div class="col-md-2">
                     <input name="${k.pumpInstructId}" value="" id="${k.pumpInstructId}" type="checkbox" />
                     </div> 
					  <div class="col-md-4">
					  
					  <label class="label-control rowlebel  invDiv" for="parameter1"> ${k.pumpInstruction}</label> 
						</div> 
					 
				 	<div class="col-md-4">	 
					<input  	type="hidden" class="form-control" id="${k.pumpInstructId}" name="${k.pumpInstructId}" 	placeholder="${m.pumpInstructId}" required /> 
					
					<textarea class="form-control"  id="remarks" name="remarks"  rows="3" cols="50" placeholder="Observations"  ></textarea>
					</div>
					</div>
						
				
						<br />
						</c:if>
					</c:forEach>
						
						
				<c:if test="${potList2!=null}">
				
				  <c:forEach items="${potList2}" var="h" varStatus="hcount">
				  
				 
						
				  
				  	<c:if test="${h.pumpOPerationParentId==n.pumpOperationTypeId }">	
				   <div class="col-md-12" style="color:maroon; "><h3><b><c:out value="${h.pumpOperationType}"></c:out></b></h3></div>
				  <br></br>
				   <br></br>
				  	 <c:forEach items="${pumpoperationinst}" var="k" varStatus="kcount">
						<c:if test="${h.pumpOperationTypeId==k.pumpInstructType}">	
							
						 <div class="row">
						   <div class="col-md-2">
                    ${k.pumpInstructSeq}
                     </div> 
                     <div class="col-md-2">
                     <input name="${k.pumpInstructId}" value="" id="${k.pumpInstructId}" type="checkbox" />
                     </div> 
					  <div class="col-md-4 invDiv">
					  
					  <label class="label-control rowlebel " for="parameter1"> ${k.pumpInstruction}</label> 
						</div> 
					 
				 	<div class="col-md-4">	 
					<input  	type="hidden" class="form-control" id="${k.pumpInstructId}" name="${k.pumpInstructId}" 	placeholder="${m.pumpInstructId}" required /> 
					
					<textarea class="form-control"  id="remarks" name="remarks"  rows="3" cols="50" placeholder="Observations"  ></textarea>
					</div>
					</div>
					</c:if>
					</c:forEach>
					</c:if>
					
					<%-- <c:if test="${h.pumpOperationTypeId==h.pumpOPerationParentId}">	
				  
						<c:if test="${h.pumpOperationTypeId==k.pumpInstructType}">	
						<label class="label-control rowlebel " for="parameter1">${k.pumpInstructSeq} ${k.pumpInstruction}</label> <br /> 		
					
				<input  	type="text" class="form-control" id="parameter1" name="parameter1" 	placeholder="parameter1" required /> 
					</c:if>
					</c:if> --%>
				
				</c:forEach>
				
				</c:if>
				
						
						
						</c:if>
						 <button type="button" name="addres" id="addres" class="btn btn-1 btn-primary center-block" >Submit</button>
					</form>
				</div>
				</c:forEach>
				
				
			</div>
		
	</div>
	

		</div> <!-- col-md-8 div -->
	
		
		 </div>	<!-- panel body div -->
	

	</div>	<!-- panel div -->
	
		

	






</div>
</div>

<!-- //container-content -->

    
	
	
	<!-- data ends -->



<!--  dilogue starts -->

	
<script type="text/javascript" src="../js/parsley.js"></script>


<script type="text/javascript" >

function getPumpLinks(basinId) {

	var basinId =basinId ;
		
		//$('#projectId').val();

	// alert("basinId"+basinId);
	$('#pumpLinkId').multiselect('rebuild');

	$.ajax({
		url : "../invtsimis/getPumpLinks?basinId="+basinId,
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
		url : "../invtsimis/getPumpLinks?pumpLinkId=" + pumpLinkId,
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
