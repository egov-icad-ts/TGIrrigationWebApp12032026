

<!--main code block-->
<!-- sec-section -->

<!-- create component start here -->
<%@include file="/jsp/header/taglib_includes.jsp"%>
<meta http-equiv="content-type" content="text/html;charset=utf-8" />


<link rel="stylesheet" href="../css/bootstrap-multiselect.css"
	type="text/css">
	
	
<link rel="stylesheet" href="../css/style.css"
	type="text/css">
<!-- <script type="text/javascript" src="../js/bootstrap.min.js"></script> -->
<script type="text/javascript" src="../js/bootstrap-multiselect.js"></script>

<link rel="stylesheet" media="screen" href="../css/jquery-ui.css">
<script type="text/javascript" src="../js/jquery-ui.js"></script>
<script type="text/javascript" src="../js/ckeditor/ckeditor.js"></script>
<script type="text/javascript" src="../js/ckeditor/adapters/jquery.js"></script>
<style> 
</style>

<script type="text/javascript">
 

$(document).ready(function(){
	
	
	
	
	$("#commontab1").hide();
	$("#datediv1").hide();
	$("#pumpId1	").hide();
	
	$(".content").slice(0, 10).show();
	$(".content2").slice(0, 10).show();
	$(".content3").slice(0, 10).show();
	$(".content4").slice(0, 10).show();
	$(".content5").slice(0, 10).show();
	$(".content6").slice(0, 10).show();
	$(".content7").slice(0, 10).show();
	  $("#loadMore").on("click", function(e){
	    e.preventDefault();
	    $(".content:hidden").slice(0, 10).slideDown();
	    if($(".content:hidden").length == 0) {
	      $("#loadMore").text("No Content").addClass("noContent");
	    }
	  });
	  
	  $("#loadMore1").on("click", function(e){
		    e.preventDefault();
		    $(".content2:hidden").slice(0, 10).slideDown();
		    if($(".content2:hidden").length == 0) {
		      $("#loadMore1").text("No Content").addClass("noContent");
		    }
		  });
	  
	  $("#loadMore2").on("click", function(e){
		    e.preventDefault();
		    $(".content3:hidden").slice(0, 10).slideDown();
		    if($(".content3:hidden").length == 0) {
		      $("#loadMore2").text("No Content").addClass("noContent");
		    }
		  });
	  
	  $("#loadMore3").on("click", function(e){
		    e.preventDefault();
		    $(".content4:hidden").slice(0, 10).slideDown();
		    if($(".content4:hidden").length == 0) {
		      $("#loadMore3").text("No Content").addClass("noContent");
		    }
		  });
	  
	  $("#cloadMore1").on("click", function(e){
		    e.preventDefault();
		    $(".content5:hidden").slice(0, 10).slideDown();
		    if($(".content5:hidden").length == 0) {
		      $("#cloadMore1").text("No Content").addClass("noContent");
		    }
		  });
	  
	  $("#cloadMore2").on("click", function(e){
		    e.preventDefault();
		    $(".content6:hidden").slice(0, 10).slideDown();
		    if($(".content6:hidden").length == 0) {
		      $("#cloadMore2").text("No Content").addClass("noContent");
		    }
		  });
	  
	  $("#cloadMore3").on("click", function(e){
		    e.preventDefault();
		    $(".content7:hidden").slice(0, 10).slideDown();
		    if($(".content7:hidden").length == 0) {
		      $("#cloadMore3").text("No Content").addClass("noContent");
		    }
		  });
	$('#compId').hide();
	$('#compselect').hide();
		 
	$('#pumpHouseType').multiselect({
		 
		 enableCaseInsensitiveFiltering: true
		 
	});

	$('#pumphouseId').multiselect({
		 
		 enableCaseInsensitiveFiltering: true
		 
	});

	$('#pumpdataType').multiselect({
		 
		 enableCaseInsensitiveFiltering: true
		 
	});
	
	$('#componentId').multiselect({
		 
		 enableCaseInsensitiveFiltering: true
		 
	});
	

	
	/* $('#operateTime').multiselect({
		 
		 enableCaseInsensitiveFiltering: true
		 
	}); */
	
	
	 
	

	}); 
	
	
$(function() {
	
	
	 $('#param_dialogue').dialog({
		  autoOpen:false,
		  width:1200
		 });
	 

	 $('#common_dialogue').dialog({
		  autoOpen:false,
		  width:1200
		 });
	 
	 $('#addpumpsdata').click(function(){
			
		 $('#param_dialogue').dialog('option', 'title', 'Add Parameters to Pumps');
		  $('#param_dialogue').dialog('open');
		  
		  $('#param_dialogue').trigger("reset"); 
		 });
	 
	 $('#addcommon').click(function(){
			
		 $('#common_dialogue').dialog('option', 'title', 'Add Common Data Of PumpStation');
		  $('#common_dialogue').dialog('open');
		  
		  $('#common_dialogue').trigger("reset"); 
		 });
	
	
	 
	
$("#pumpdataType").change(function() {
	alert("kal");
	  var a = $(this).val()
	  
	  alert(a);
	
	if(a==2){
		$('#compId').show();
		$('#compselect').show();
		
	}
	if(a==1){
		$('#compId').hide();
		$('#compselect').hide();
		
	}
	 

	 // $(".content").load(link);
	});
	
/* 
$( "#tabs" ).tabs().addClass( "ui-tabs-vertical ui-helper-clearfix" );
$( "#tabs li" ).removeClass( "ui-corner-top" ).addClass( "ui-corner-left" );
 */
 $( "#tabs" ).tabs()
 
 
 $("#select_all1").change(function(){  //"select all" change 
	    $(".checkbox1").prop('checked', $(this).prop("checked")); //change all ".checkbox" checked status
	});
 $("#select_all2").change(function(){  //"select all" change 
	    $(".checkbox2").prop('checked', $(this).prop("checked")); //change all ".checkbox" checked status
	});
 $("#select_all3").change(function(){  //"select all" change 
	    $(".checkbox3").prop('checked', $(this).prop("checked")); //change all ".checkbox" checked status
	});
 
 $("#select_all4").change(function(){  //"select all" change 
	    $(".checkbox4").prop('checked', $(this).prop("checked")); //change all ".checkbox" checked status
	});
 
 $("#select_common1").change(function(){  //"select all" change 
	    $(".checkboxcommon1").prop('checked', $(this).prop("checked")); //change all ".checkbox" checked status
	});
 $("#select_common2").change(function(){  //"select all" change 
	    $(".checkboxcommon2").prop('checked', $(this).prop("checked")); //change all ".checkbox" checked status
	});
 $("#select_common3").change(function(){  //"select all" change 
	    $(".checkboxcommon3").prop('checked', $(this).prop("checked")); //change all ".checkbox" checked status
	});

 
 $('.checkbox1').change(function(){ 
		//uncheck "select all", if one of the listed checkbox item is unchecked
	    if(false == $(this).prop("checked")){ //if this item is unchecked
	        $("#select_all1").prop('checked', false); //change "select all" checked status to false
	    }
		//check "select all" if all checkbox items are checked
		if ($('.checkbox1:checked').length == $('.checkbox').length ){
			$("#select_all1").prop('checked', true);
		}
	});
 
 $('.checkbox2').change(function(){ 
		//uncheck "select all", if one of the listed checkbox item is unchecked
	    if(false == $(this).prop("checked")){ //if this item is unchecked
	        $("#select_all2").prop('checked', false); //change "select all" checked status to false
	    }
		//check "select all" if all checkbox items are checked
		if ($('.checkbox2:checked').length == $('.checkbox').length ){
			$("#select_all2").prop('checked', true);
		}
	});
 
 $('.checkbox3').change(function(){ 
		//uncheck "select all", if one of the listed checkbox item is unchecked
	    if(false == $(this).prop("checked")){ //if this item is unchecked
	        $("#select_all3").prop('checked', false); //change "select all" checked status to false
	    }
		//check "select all" if all checkbox items are checked
		if ($('.checkbox3:checked').length == $('.checkbox').length ){
			$("#select_all3").prop('checked', true);
		}
	});
 
 $('.checkbox4').change(function(){ 
		//uncheck "select all", if one of the listed checkbox item is unchecked
	    if(false == $(this).prop("checked")){ //if this item is unchecked
	        $("#select_all4").prop('checked', false); //change "select all" checked status to false
	    }
		//check "select all" if all checkbox items are checked
		if ($('.checkbox4:checked').length == $('.checkbox').length ){
			$("#select_all4").prop('checked', true);
		}
	});
 
 $('.checkboxcommon1').change(function(){ 
		//uncheck "select all", if one of the listed checkbox item is unchecked
	    if(false == $(this).prop("checked")){ //if this item is unchecked
	        $("#select_common1").prop('checked', false); //change "select all" checked status to false
	    }
		//check "select all" if all checkbox items are checked
		if ($('.checkboxcommon1:checked').length == $('.checkbox').length ){
			$("#select_common1").prop('checked', true);
		}
	});

 
 $('.checkboxcommon2').change(function(){ 
		//uncheck "select all", if one of the listed checkbox item is unchecked
	    if(false == $(this).prop("checked")){ //if this item is unchecked
	        $("#select_common2").prop('checked', false); //change "select all" checked status to false
	    }
		//check "select all" if all checkbox items are checked
		if ($('.checkboxcommon2:checked').length == $('.checkbox').length ){
			$("#select_common2").prop('checked', true);
		}
	});

 
 $('.checkboxcommon3').change(function(){ 
		//uncheck "select all", if one of the listed checkbox item is unchecked
	    if(false == $(this).prop("checked")){ //if this item is unchecked
	        $("#select_common3").prop('checked', false); //change "select all" checked status to false
	    }
		//check "select all" if all checkbox items are checked
		if ($('.checkboxcommon3:checked').length == $('.checkbox').length ){
			$("#select_common3").prop('checked', true);
		}
	});

 $('#pumpDatatypeId1').change(function(){ 
	 
	 var star1=parseInt($(this).val());
	
	 if(star1==1){
			
		 $("#commontab1").show();
			$("#datediv1").show();
			
		}
	
		
		if(star1==2){
			
			 $("#commontab1").show();
			$("#pumpId1	").show();
			
		}
	 
 });
 

				
	
});



</script>



<!-- <div class="w3l-main" id="borderStyle"> -->

<div class="col-md-9">
	


<div>
	

	
	<div class="panel panel-primary " >
		<div class="panel-heading">
			<h3 class="panel-title">O&M of Lift:Pumps Data During Operation</h3>
		</div>
		<div class="panel-body">	
	
	<div class="alert alert-info col-md-12" style="padding: 0px"
				id="action_alert"></div>	
		
		
		
		<div class="col-md-12 invDiv">
		<div class="col-md-6">
			<div class="col-md-6">
						<input type="button" class="btn btn-1 btn-primary center-block" 	id="addcommon" value="Add Common Parameters to Pumping station">
					</div>
				<br/><br/>
					<div class="col-md-6">
						
						<input type="button" class="btn btn-1 btn-primary center-block" 	id="addpumpsdata" value="Add Parameters to pumps ">
					</div>
					</div>
					<div class="col-md-6">
					<div class="col-md-6">
						<input type="button" class="btn btn-1 btn-primary center-block" 	id="editcommon" value="Edit Common Parameters to Pumping station">
					</div>
				<br/><br/>
					<div class="col-md-6">
						
						<input type="button" class="btn btn-1 btn-primary center-block" 	id="editpumpsdata" value="Edit Parameters to pumps ">
					</div>
					</div>
		</div>
		
		
		<div id="result" class="col-md-12 invDiv">
		
		
			<div class="col-md-6">
						<label class="label-controlPMS rowlebel ">Select Basin: <font
							color=red>*</font>
						</label>
					</div>

					<div class="col-md-6">
						<select class="form-control" id="basinId" name="basinId"
							 required>
							<option value=" ">--select--</option>
							<option value=" 1">Godavari Basin</option>
							<option value=" 2">Krishna Basin</option>
						

						</select>
					</div>
					
					
			<div class="col-md-6">
						<label class="label-controlPMS rowlebel ">Select Pumping Scheme: <font
							color=red>*</font>
						</label>
					</div>

					<div class="col-md-6">
						<select class="form-control" id="schemeId" name="schemeId"
							 required>
							<option value=" ">--select--</option>
							<option value=" 1">Pumping Scheme Link-1</option>
							<option value=" 2">Pumping Scheme Link-2</option>
						

						</select>
					</div>
					
						<div class="col-md-6">
						<label class="label-controlPMS rowlebel ">Select Pumping Station: <font
							color=red>*</font>
						</label>
					</div>

					<div class="col-md-6">
						<select class="form-control" id="pumphouseId1" name="pumphouseId1"
							 required>
							<option value=" ">--select--</option>
							<option value="1">Pumping Station1</option>
							<option value="2">Pumping Station2</option>
						

						</select>
					</div>
					
						<div class="col-md-6">
						<label class="label-controlPMS rowlebel ">Select Parameters of PumpStation: <font
							color=red>*</font>
						</label>
					</div>

					<div class="col-md-6">
						<select class="form-control" id="pumpDatatypeId1" name="pumpDatatypeId1"
							 required>
							<option value=" ">--select--</option>
							<option value="1">Common Parameters of pump Station </option>
							<option value="2">Pump Parameters Of Pump Station</option>
						

						</select>
					</div>
					
					<div class="col-md-6">
						<label class="label-controlPMS rowlebel ">Select Pumps: <font
							color=red>*</font>
						</label>
					</div>

					<div class="col-md-6">
						<select class="form-control" id="pumpId1" name="pumpId1"
							 required>
							<option value=" ">--select--</option>
							<option value=" 1">Pump1</option>
							<option value=" 2">Pump2</option>
						

						</select>
					</div>
					
					 
		           
				
					
					
						   
		
		

		
		
		</div>
		
		
		
		<div id="datediv1" class="col-md-12 invDiv">
		
		 <div class="col-md-3">
						<label class="label-controlPMS rowlebel ">Select Date: <font
							color=red>*</font>
						</label>
					</div>

					<div class="col-md-3">
					<input
				type="text" class="form-control" id="dateofoperation" name="dateofoperation"
				placeholder="dateofoperation"  />
					</div>
					
						
					 <div class="col-md-3">
						<label class="label-controlPMS rowlebel ">Select Hour: <font
							color=red>*</font>
						</label>
					</div>

				<div class="col-md-3">
						<select class="form-control" id="operateTime" name="operateTime"
							 required>
							<option value=" ">--select--</option>
							<option value=" ">1</option>
							<option value=" ">2</option>
							<option value=" ">3</option>
							<option value=" ">4</option>
							<option value=" ">5</option>
							<option value=" ">6</option>
							
							<option value=" ">7</option>
							<option value=" ">8</option>
							<option value=" ">9</option>
							<option value=" ">10</option>
							<option value=" ">11</option>
							<option value=" ">12</option>
							<option value=" ">13</option>
							<option value=" ">14</option>
							<option value=" ">15</option>
							<option value=" ">16</option>
							<option value=" ">17</option>
							<option value=" ">18</option>
							<option value=" ">19</option>
							<option value=" ">20</option>
							<option value=" ">21</option>
							<option value=" ">22</option>
							<option value=" ">23</option>
							<option value=" ">24</option>
							
							

						</select>
					</div>
					
					 <div class="col-md-3">
						<label class="label-controlPMS rowlebel ">Pump Start Time: <font
							color=red>*</font>
						</label>
					</div>

					<div class="col-md-3">
					<input
				type="text" class="form-control" id="pumpStartTime" name="pumpStartTime"
				placeholder="start time"  />
					</div>
					
					 <div class="col-md-3">
						<label class="label-controlPMS rowlebel ">Pump End Time: <font
							color=red>*</font>
						</label>
					</div>

					<div class="col-md-3">
					<input
				type="text" class="form-control" id="pumpEndTime" name="pumpEndTime"
				placeholder="end time"  />
					</div>
					
		
		
	
		</div>
		
		<div id="commontab1" class="col-md-12 invDiv">
	<div class="wrapper">
		
			<div id="tabs">
				<ul>
					<li><a href="#em1">E&M1</a></li>
					<li><a href="#em2">E&M2</a></li>
					<li><a href="#em3">E&M3</a></li>
					
				</ul>
				<div id="em1">
				
					<form method="post" action="LoginController">
					
						<c:if test="${pcdList1!=null}">
						
						

					   <c:forEach items="${pcdList1}" var="m" varStatus="mcount">
					  <div class="row col-md-12">
					  
					   <div class="col-md-2">
                     ${mcount.count}
                     </div> 
                     <div class="col-md-2">
                     <input name="${m.pumpCommonDataId}" value="" id="${m.pumpCommonDataId}" type="checkbox" />
                     </div> 
					  <div class="col-md-4">
					  
					   <label class="label-control rowlebel invDiv " for="parameter1"> <c:out value="${m.pumpCommonDataItem}"  escapeXml="false" ></c:out></label>
						</div> 
					<div class="col-md-4">	 
					<input  	type="hidden" class="form-control" id="${m.pumpCommonDataId}" name="${m.pumpCommonDataId}"  required /> 
					<textarea class="form-control"  id="remarks" name="remarks"  rows="3" cols="50" placeholder="Observations"  ></textarea>
					</div>
						<br />
							<br />
					
					</div>
				</c:forEach>
				 	  </c:if>
						<br />
						 <button type="button" name="addres" id="addres" class="btn btn-1 btn-primary center-block" >Submit</button>
					</form>
				</div>
				<div id="em2">
				
					<form method="post" action="LoginController">
						<c:if test="${pcdList2!=null}">
						
						

					   <c:forEach items="${pcdList2}" var="m" varStatus="mcount">
						 <div class="row col-md-12">
					  
					   <div class="col-md-2">
                     ${mcount.count}
                     </div> 
                     <div class="col-md-2">
                     <input name="${m.pumpCommonDataId}" value="" id="${m.pumpCommonDataId}" type="checkbox" />
                     </div> 
					  <div class="col-md-4">
					  
					   <label class="label-control rowlebel invDiv " for="parameter1">  <c:out value="${m.pumpCommonDataItem}"  escapeXml="false" ></c:out></label>
						</div> 
						
						 


				
					<div class="col-md-4">	 
					<input  	type="hidden" class="form-control" id="${m.pumpCommonDataId}" name="${m.pumpCommonDataId}" 	placeholder="${m.pumpCommonDataId}" required /> 
					<textarea class="form-control"  id="remarks" name="remarks"  rows="3" cols="50" placeholder="Observations"  ></textarea>
					</div>
						<br />
							<br />
					
					</div>
				</c:forEach>
				 	  </c:if>
						<br />
						 <button type="button" name="addres" id="addres" class="btn btn-1 btn-primary center-block" >Submit</button>
					</form>
				</div>
				
				<div id="em3">
				
				<form method="post" action="LoginController">
						<c:if test="${pcdList3!=null}">
						
						

					   <c:forEach items="${pcdList3}" var="m" varStatus="mcount">
								 <div class="row col-md-12">
					  
					   <div class="col-md-2">
                     ${mcount.count}
                     </div> 
                     <div class="col-md-2">
                     <input name="${m.pumpCommonDataId}" value="" id="${m.pumpCommonDataId}" type="checkbox" />
                     </div> 
					  <div class="col-md-4">
					  
					   <label class="label-control rowlebel invDiv " for="parameter1"> <c:out value="${m.pumpCommonDataItem}"  escapeXml="false" ></c:out></label>
						</div> 
						
						 

					

				
					<div class="col-md-4">	 
					<input  	type="hidden" class="form-control" id="${m.pumpCommonDataId}" name="${m.pumpCommonDataId}" 	required /> 
					<textarea class="form-control"  id="remarks" name="remarks"  rows="3" cols="50" placeholder="Observations"  ></textarea>
					</div>
						<br />
							<br />
					
					</div>
				</c:forEach>
				 	  </c:if>	<br />
					
						 <br />
						 <button type="button" name="addres" id="addres" class="btn btn-1 btn-primary center-block" >Submit</button>
					</form>
				
				
				</div>
				
				
			</div>
		
	</div>
	

		</div> <!-- col-md-8 div -->
		
		
		
	
	 </div>	<!-- panel body div -->	
		 </div>	<!-- panel div -->
	

	</div>	<!-- row div -->
	

	
 </div> <!-- //container-content -->
    
	
	
	
	<!-- data ends -->



<!--  dilogue starts -->


<div id="common_dialogue">


	<div class="col-md-6">
						<label class="label-controlPMS rowlebel ">Select Basin: <font
							color=red>*</font>
						</label>
					</div>

					<div class="col-md-6">
						<select class="form-control" id="basinId" name="basinId"
							 required>
							<option value=" ">--select--</option>
							<option value=" 1">Godavari Basin</option>
							<option value=" 2">Krishna Basin</option>
						

						</select>
					</div>
					
					
			<div class="col-md-6">
						<label class="label-controlPMS rowlebel ">Select Pumping Scheme: <font
							color=red>*</font>
						</label>
					</div>

					<div class="col-md-6">
						<select class="form-control" id="schemeId" name="schemeId"
							 required>
							<option value=" ">--select--</option>
							<option value=" 1">Pumping Scheme Link-1</option>
							<option value=" 2">Pumping Scheme Link-2</option>
						

						</select>
					</div>
					
						<div class="col-md-6">
						<label class="label-controlPMS rowlebel ">Select Pumping Station: <font
							color=red>*</font>
						</label>
					</div>
						<div class="col-md-6">
						<select class="form-control" id="pumphouseId" name="pumphouseId"
							 required>
							<option value=" ">--select--</option>
							<option value=" 1">Pumping Station1</option>
							<option value=" 2">Pumping Station1</option>
						

						</select>
					</div>
					
					  <br/> <br/> 
					
											<div class="col-md-12">
											
											
<div class="col-md-4">
      
    
  <div class="flex">
     
  
  
						
						<table id="example" class="display" >
   <thead>
      <tr class="content5">
          <th><input name="select_all" value="1" id="select_common1" type="checkbox" />Select All</th>
           <th>Item</th>
      
      </tr>
   
   </thead>
   
   <tbody>
   	<c:if test="${pcdList1!=null}">
   <c:forEach items="${pcdList1}" var="m" varStatus="mcount">
      <tr class="content5">
    <th > <input name="${m.pumpCommonDataId}" value="1" id="${m.pumpCommonDataId}" type="checkbox"  class="checkboxcommon1" /> </th>
   <th><label class="label-control rowlebel " for="parameter1"> <c:out value="${m.pumpCommonDataItem}"  escapeXml="false" ></c:out></label> </th>
   <th> <input  	type="hidden" class="form-control" id="${m.pumpCommonDataId}" name="${m.pumpCommonDataId}" 	 /> </th>
	
   </tr>
  
   	</c:forEach>
   	  </c:if>
   	

   </tbody>
 

</table>`
  <a href="#" id="cloadMore1">Load More</a>

 
  </div>
  

</div>


<!-- second column-->

 <div class="col-md-4">
       
  <div class="flex">
     
  
  
						
						<table id="example" class="display" >
   <thead>
      <tr class="content6">
          <th><input name="select_all" value="1" id="select_common2" type="checkbox" />Select All</th>
           <th>Item</th>
      
      </tr>
   
   </thead>
   
   <tbody>
   	<c:if test="${pcdList2!=null}">
   <c:forEach items="${pcdList2}" var="m" varStatus="mcount">
      <tr class="content6">
    <th > <input name="${m.pumpCommonDataId}" value="1" id="${m.pumpCommonDataId}" type="checkbox"  class="checkboxcommon2" /> </th>
   <th><label class="label-control rowlebel " for="parameter1"> <c:out value="${m.pumpCommonDataItem}"  escapeXml="false" ></c:out></label> </th>
   <th> <input  	type="hidden" class="form-control" id="${m.pumpCommonDataId}" name="${m.pumpCommonDataId}" 	 /> </th>
	
   </tr>
  
   	</c:forEach>
   	  </c:if>
   	

   </tbody>
 

</table>`
  <a href="#" id="cloadMore2">Load More1</a>

 
  </div>

</div>
<!-- third column -->

 <div class="col-md-4 ">
       
  <div class="flex">
     
  
  
						
						<table id="example" class="display" >
   <thead>
      <tr class="content7">
          <th><input name="select_all" value="1" id="select_common3" type="checkbox" />Select All</th>
           <th>Item</th>
      
      </tr>
   
   </thead>
   
   <tbody>
   	<c:if test="${pcdList3!=null}">
   <c:forEach items="${pcdList3}" var="m" varStatus="mcount">
      <tr class="content7">
    <th > <input name="${m.pumpCommonDataId}" value="1" id="${m.pumpCommonDataId}" type="checkbox"  class="checkboxcommon3" /> </th>
   <th><label class="label-control rowlebel " for="parameter1"> <c:out value="${m.pumpCommonDataItem}"  escapeXml="false" ></c:out></label> </th>
   <th> <input  	type="hidden" class="form-control" id="${m.pumpCommonDataId}" name="${m.pumpCommonDataId}" 	 /> </th>
	
   </tr>
  
   	</c:forEach>
   	  </c:if>
   	

   </tbody>
 

</table>`
  <a href="#" id="cloadMore3">Load More2</a>

 
  </div>








</div>


</div>
  

		

		<div class="row show-grid">

			<div class="col-md-12">
				<label class="label-control rowlebel "></label><input
					style="text-align: center;" type="submit"
					class="btn btn-1 btn-primary center-block" id="addreg"
					value="Add Common Parameters">
			</div>


		</div>



	</div>

	
<!-- //dialogue starts-content -->

<div id="param_dialogue">


	<div class="col-md-6">
						<label class="label-controlPMS rowlebel ">Select Basin: <font
							color=red>*</font>
						</label>
					</div>

					<div class="col-md-6">
						<select class="form-control" id="basinId" name="basinId"
							 required>
							<option value=" ">--select--</option>
							<option value=" 1">Godavari Basin</option>
							<option value=" 2">Krishna Basin</option>
						

						</select>
					</div>
					
					
			<div class="col-md-6">
						<label class="label-controlPMS rowlebel ">Select Pumping Scheme: <font
							color=red>*</font>
						</label>
					</div>

					<div class="col-md-6">
						<select class="form-control" id="schemeId" name="schemeId"
							 required>
							<option value=" ">--select--</option>
							<option value=" 1">Pumping Scheme Link-1</option>
							<option value=" 2">Pumping Scheme Link-2</option>
						

						</select>
					</div>
					
						<div class="col-md-6">
						<label class="label-controlPMS rowlebel ">Select Pumping Station: <font
							color=red>*</font>
						</label>
					</div>
						<div class="col-md-6">
						<select class="form-control" id="pumphouseId" name="pumphouseId"
							 required>
							<option value=" ">--select--</option>
							<option value=" 1">Pumping Station1</option>
							<option value=" 2">Pumping Station1</option>
						

						</select>
					</div>
					
					<div class="col-md-6">
						<label class="label-controlPMS rowlebel ">Select Pumps: <font
							color=red>*</font>
						</label>
					</div>

					<div class="col-md-6">
						<select class="form-control" id="pumpId" name="pumpId"
							 required>
							<option value=" ">--select--</option>
							<option value=" 1">Pump1</option>
							<option value=" 2">Pump2</option>
						

						</select>
					</div>
					
						<div class="col-md-12">
<div class="col-md-3">
       
  <div class="flex">
     
  
  
						
						<table id="example" class="display" >
   <thead>
      <tr class="content">
          <th><input name="select_all" value="1" id="select_all1" type="checkbox" />Select All</th>
           <th>Item</th>
      
      </tr>
   
   </thead>
   
   <tbody>
   	<c:if test="${ppdList1!=null}">
   <c:forEach items="${ppdList1}" var="m" varStatus="mcount">
      <tr class="content">
    <th > <input name="${m.pumpdataId}" value="1" id="${m.pumpdataId}" type="checkbox"  class="checkbox1" /> </th>
   <th><label class="label-control rowlebel " for="parameter1"> <c:out value="${m.pumpDataItem}"  escapeXml="false" ></c:out></label> </th>
   <th> <input  	type="hidden" class="form-control" id="${m.pumpdataId}" name="${m.pumpdataId}" 	 /> </th>
	
   </tr>
  
   	</c:forEach>
   	  </c:if>
   	

   </tbody>
 

</table>`
  <a href="#" id="loadMore">Load More</a>

 
  </div>
  

</div>


<!-- second column-->

 <div class="col-md-3">
       
  <div class="flex">
     
  
  
						
						<table id="example" class="display" >
   <thead>
      <tr class="content2">
          <th><input name="select_all" value="1" id="select_all2" type="checkbox" />Select All</th>
           <th>Item</th>
      
      </tr>
   
   </thead>
   
   <tbody>
   	<c:if test="${ppdList2!=null}">
   <c:forEach items="${ppdList2}" var="m" varStatus="mcount">
      <tr class="content2">
    <th > <input name="${m.pumpdataId}" value="1" id="${m.pumpdataId}" type="checkbox"  class="checkbox2" /> </th>
   <th><label class="label-control rowlebel " for="parameter1"> <c:out value="${m.pumpDataItem}"  escapeXml="false" ></c:out></label> </th>
   <th> <input  	type="hidden" class="form-control" id="${m.pumpdataId}" name="${m.pumpdataId}" 	 /> </th>
	
   </tr>
  
   	</c:forEach>
   	  </c:if>
   	

   </tbody>
 

</table>`
  <a href="#" id="loadMore1">Load More1</a>

 
  </div>

</div>
<!-- third column -->

 <div class="col-md-3">
       
  <div class="flex">
     
  
  
						
						<table id="example" class="display" >
   <thead>
      <tr class="content3">
          <th><input name="select_all" value="1" id="select_all3" type="checkbox" />Select All</th>
           <th>Item</th>
      
      </tr>
   
   </thead>
   
   <tbody>
   	<c:if test="${ppdList3!=null}">
   <c:forEach items="${ppdList3}" var="m" varStatus="mcount">
      <tr class="content3">
    <th > <input name="${m.pumpdataId}" value="1" id="${m.pumpdataId}" type="checkbox"  class="checkbox3" /> </th>
   <th><label class="label-control rowlebel " for="parameter1"> <c:out value="${m.pumpDataItem}"  escapeXml="false" ></c:out></label> </th>
   <th> <input  	type="hidden" class="form-control" id="${m.pumpdataId}" name="${m.pumpdataId}" 	 /> </th>
	
   </tr>
  
   	</c:forEach>
   	  </c:if>
   	

   </tbody>
 

</table>`
  <a href="#" id="loadMore2">Load More2</a>

 
  </div>








</div>

<!-- FOURTH column -->

 <div class="col-md-3">
       
  <div class="flex">
     
  
  
						
						<table id="example" class="display" >
   <thead>
      <tr class="content4">
          <th><input name="select_all" value="1" id="select_all4" type="checkbox" />Select All</th>
           <th>Item</th>
      
      </tr>
   
   </thead>
   
   <tbody>
   	<c:if test="${ppdList4!=null}">
   <c:forEach items="${ppdList4}" var="m" varStatus="mcount">
      <tr class="content4">
    <th > <input name="${m.pumpdataId}" value="1" id="${m.pumpdataId}" type="checkbox"  class="checkbox4" /> </th>
   <th><label class="label-control rowlebel " for="parameter1"> <c:out value="${m.pumpDataItem}"  escapeXml="false" ></c:out></label> </th>
   <th> <input  	type="hidden" class="form-control" id="${m.pumpdataId}" name="${m.pumpdataId}" 	 /> </th>
	
   </tr>
  
   	</c:forEach>
   	  </c:if>
   	

   </tbody>
 

</table>`
  <a href="#" id="loadMore3">Load More3</a>

 
  </div>








</div>
</div>
  
   

				 
				 
	

		<div class="row show-grid">

			<div class="col-md-12">
				<label class="label-control rowlebel "></label><input
					style="text-align: center;" type="submit"
					class="btn btn-1 btn-primary center-block" id="addreg"
					value="Add Parameters to pumps">
			</div>


		</div>



	</div>

	

	
	
	

	
	
	
	
	
	
	
	
			

	




<script type="text/javascript" src="../js/parsley.js"></script>





