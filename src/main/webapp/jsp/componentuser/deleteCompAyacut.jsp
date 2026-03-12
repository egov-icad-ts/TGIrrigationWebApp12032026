	<!--main code block-->
	<!-- sec-section -->
	
	<!-- create component start here -->
<%@include file="/jsp/header/taglib_includes.jsp"%> 



<link rel="stylesheet" href="../css/bootstrap-multiselect.css"
	type="text/css">
<script type="text/javascript" src="../js/bootstrap-multiselect.js"></script>
<script type="text/javascript" src="../js/jquery-ui.js"></script>
<link rel="stylesheet" media="screen" href="../css/jquery-ui.css">
 
 
 <link rel="stylesheet" href="../css/treeview/jquery.treeview.css" />

<script src="../js/treeview/lib/jquery.cookie.js" type="text/javascript"></script>
<script src="../js/treeview/jquery.treeview.js" type="text/javascript"></script>
<link rel="stylesheet" href="../css/Html5DataTable/jquery.dataTables.min.css" />
	<link rel="stylesheet" href=" ../css/Html5DataTable/buttons.dataTables.min.css" /> 
 
 


<script type="text/javascript">
		$(function() {
			$("#tree").treeview({
				collapsed: true,
				animated: "medium",
				control:"#sidetreecontrol",
				persist: "location"
			});
		})
		
	</script>


<script type = "text/javascript">

$(document).ready(function(){
	
	$('#diunitId').multiselect({
		 
		 enableCaseInsensitiveFiltering: true
		 
	});

	$('#dicircleId').multiselect({
		 
		 enableCaseInsensitiveFiltering: true
		 
	});


	$('#didivisionId').multiselect({
		 
		 enableCaseInsensitiveFiltering: true
		 
	});
	
	$('#ayacutinfo_dialogue').dialog({
		 autoOpen:false,
		  width:600,
		  close: function() {
			  
			
				  $(this).dialog("close");
				  }
		 });
	
	$('#ayacutjuris_dialogue').dialog({
		 autoOpen:false,
		  width:600,
		  height:200,
		  close: function() {
			  
			
				  $(this).dialog("close");
				  }
		 });
	
	
	
	
	function getCompAyacutsame(){
		
		// alert("m"+m);
		 $("#deleteFlag").val(false);
		
		  
		 var m= $("#unitId").val();
		// alert("m"+m);
		
		  $("#unitId").val(m);
		 
		 document.forms[0].urlvalue.value="../comptsimis/deleteCompAyacut";
			
		
		 
		
			 document.forms[0].submit(); 
		
		
		
		
	} 


	 
	  
	
});


       
    </script>

    <script>
	
	function deleteCompAyacutData(k){
		
		//alert("k"+k);
		
		
		 $("#deleteFlag").val(true);
		  $("#projAyacutId").val(k);
		  
		// var m= $("#deleteFlag").val();
		// alert("m"+m);
		 
		 document.forms[0].urlvalue.value="../comptsimis/deleteCompAyacut";
			
		
		 
		
			 document.forms[0].submit(); 
		
		
	}
	
	function getCompAyacutData(unitval){
		 $("#deleteFlag").val(false);
		  $("#unitId").val(unitval);
		  
		 var m= $("#deleteFlag").val();
		// alert("m"+m);
		 
		 document.forms[0].urlvalue.value="../comptsimis/deleteCompAyacut";
			
		
		 
		
			 document.forms[0].submit(); 
		
		
		
		
	}
	function editCompAyacutData(n){
		
		 $("#editFlag").val(true);
			
		 var features="width=500,height=300,menubar=no,status=no,location=no,toolbar=no,scrollbars=yes,top=100,left=50";
	 	  	var url="../comptsimis/editCompAyacut?projAyacutId="+n+"&editFlag="+false;
	 	  	
	 		popup =window.open(url,"_blank",features);
		
		
	}
	
function ViewMandalInfo(ProjectAyacutId){
		
		var  pid=ProjectAyacutId;
		
		var divpid="#"+pid+"info";
		
		
		  $('.ainfo').hide();
		
		 $('#ayacutinfo_dialogue').dialog('option', 'title', 'Ayacut Info');
		  $('#ayacutinfo_dialogue').dialog('open');
		  
		  
		  
		  $(divpid).show();
		
		
	}
	
function editJurisdictionData(ProjectAyacutId,unitId,unitName,circleId,divisionId){
	
	 $('#ayacutjuris_dialogue').dialog('option', 'title', 'Edit Jurisdiction');
	  $('#ayacutjuris_dialogue').dialog('open');
	  
	  
	  $("#ayacutjuris").trigger("reset");
	  
	  
	  $('#selectedUnitId').val(unitId);
	  $('#selectedCircleId').val(circleId);
	  $('#selectedDivisionId').val(divisionId);
	
	  $('#hiddenprojAyacutId').val(ProjectAyacutId);
	  
	  $('#hiddenUnitName').text(unitName);
	  
	  getCircles();
	  getDivisions()
	
}


function getCircles(){
	//alert("kal");
	//var districtId=document.getElementById("districtId").value;

	$('#dicircleId').val(0);
	$('#dicircleId').multiselect('rebuild');
	
	var unitId=document.getElementById("selectedUnitId").value;
	//alert(mandalId);

	  $.ajax({	          
      url: "../task/getCircles?unitId="+unitId,
      type: "GET",
      success: function (response) {
   // 	alert(response);
    if(response!=0){
    	  var $select = $('#dicircleId');
    	  var selectedCircleId= $('#selectedCircleId').val();
    	 
		  $select.find('option').remove();
		 // alert("kal1");
		  
		  var obj = JSON.parse(response);
		 // alert("kal2");
		 
		
		  $('#dicircleId').append( '<option value=" "> --select--</option>' );
				
				 
				  
				$.each(obj, function(key, value) {
					
					if(selectedCircleId==value.circleId){	
							
						
						
					$('#dicircleId').append( '<option value="'+value.circleId+'" selected="selected"> '+value.circleName+'</option>' );
					
						}
						
					 if(selectedCircleId==null||selectedCircleId!=value.circleId){
							$('#dicircleId').append( '<option value="'+value.circleId+'"> '+value.circleName+'</option>' );	
						
						} 
					
					
						//$('#dicircleId').append( '<option value="'+value.circleId+'" > '+value.circleName+'</option>' );
				
						$('#dicircleId').multiselect('rebuild');
						
						  var dicircle= parseInt($("#dicircleId").val()); 
						//	alert("dicircle"+dicircle);
							var c=dicircle;
							if(c!=null && c>0){
							//	alert(c+"c");
								getDivisions();
								
							
							}
						  
				});
    }if(response==0||response!=null){
    	$('#dicircleId').multiselect('rebuild');
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
	$('#didivisionId').val(0);
	$('#didivisionId').multiselect('rebuild');
	var circleId=document.getElementById("dicircleId").value;
	//alert(mandalId);

	  $.ajax({	          
      url: "../web/getDivisions?circleId="+circleId,
      type: "GET",
      success: function (response) {
    	
    	  if(response!=0){	
    	
    	  var $select = $('#didivisionId');
    	  var selecteddivisionId= $('#selectedDivisionId').val();
    	 
		  $select.find('option').remove();
		  
		  var obj = JSON.parse(response);
		
		 
				
				  $('#didivisionId').append( '<option value=" "> --select--</option>' );
				  
				$.each(obj, function(key, value) {
					
					if(selecteddivisionId==value.divisionId){
						$('#didivisionId').append(
								'<option value="'+value.divisionId+'" selected="selected"> '
										+ value.divisionName + '</option>');
							}
							
							 if(selecteddivisionId==null||selecteddivisionId!=value.divisionId){
								 
									$('#didivisionId').append(
											'<option value="'+value.divisionId+'"> '
													+ value.divisionName + '</option>');
								 
							 }

					
						//$('#didivisionId').append( '<option value="'+value.divisionId+'" > '+value.divisionName+'</option>' );
				
  	  				$('#didivisionId').multiselect('rebuild');
				});
    	  }if(response==0||response!=null){
  	    	$('#didivisionId').multiselect('rebuild');
  	    }

      },
      error : function(){
    	  alert(error);
      }
  }); 	
}


function  updateJusrisdiction(){
	
	
	//alert("i am kal");
	
	

		if ($('form[id=ayacutjuris]').parsley().isValid()) {
			
			var finaldatatoSend=$('form[id=ayacutjuris]').serialize();
			
			  $.ajax({	          
					      url: "../comptsimis/update-jurisdiction",
					      method:"POST",
					      async: false,
					     
					      data:finaldatatoSend,
						 
					      success: function (response) {
					   
					    	//alert("kal"+response);
					    	 
					    	 if(response>0){
					    		 
					    		 
					    		  $('#ayacutjuris_dialogue').dialog('close');
						  $('#action_alert').html('<p style="margin: 0px !important;">Data added Successfully</p>');
							$("html,body").animate({scrollTop:$('#action_alert').offset().top-175}, 500);
							
							
						    $("#ayacutjuris").trigger("reset");
						    
						  
						    refreshPage();
						    
						   
						    
						    }
					    	 
					    	
						    if(response==0||response==null){
						    	
						    	  $('#action_alert').html('<p style="margin: 0px !important;">Failed to Update data</p>');
						    		$("html,body").animate({scrollTop:$('#action_alert').offset().top-175}, 500);
						    }
						    
						
						    
						   
								
						
			  },
					      
					      error : function(){
					    	 alert(error);
					    
					      }

					  
					  });   
					  

						
				             }else{
				            	 
				            	 $('form[id=ayacutjuris]').parsley().validate();
				            	 
				             }
		

	
	
	
	
}

function refreshPage() {
	 //alert("i am realoding")
    location.reload(true);
}


	
	
	
	$(function() {
	
	
	 $('#faqSpopup').dialog({
		  autoOpen:false,
		  width:1200,
		  close: function() {
			  
			
				  $(this).dialog("close");
				  }
		 });
	 
	 
	 
	 $('#helpId').click(function(){
			
		 $('#faqSpopup').dialog('option', 'title', 'Clarifications');
		  $('#faqSpopup').dialog('open');
		
		 });
	 
	
	 
	 
	
	
	}); 
	
	
</script>



		

<div class="col-md-9">
	


<div>

	
	
	
	<div class="panel panel-primary ">
			<div class="panel-heading">
				<h3 class="panel-title">Edit/Delete Ayacut Input<c:if test="${userObj!=null}">	
				<div class="span6 pull-right">
				
				Welcome to    
						
						 <c:if test="${userObj.employeeName!=null  }">	
						   
			Er. <c:out value="${userObj.employeeName}"></c:out>	
			 
			 </c:if>
			 
			 <c:if test="${userObj.designationName!=null  }">	
						   
			, <c:out value="${userObj.designationName}"></c:out>	
			 
			 </c:if>
			 </div>
			 <br></br>
			 <div class="span6 pull-right">
			
						  <c:if test="${userObj.unitId!=0 && userObj.circleId==0 && userObj.divisionId==0 && userObj.subdivisionId==0 }">	
						   <c:if test="${userObj.unitId>0  }">	
			 <c:out value="${userObj.unitName}"></c:out>	
			 </c:if>
			 </c:if>	
			 
			   <c:if test="${userObj.unitId!=0 && userObj.circleId!=0 && userObj.divisionId==0 && userObj.subdivisionId==0 }">	
						   <c:if test="${userObj.unitId>0 &&  userObj.circleId>0  }">	
			 <c:out value="${userObj.circleName}"></c:out>	
			 </c:if>
			 </c:if>	
			 
			   <c:if test="${userObj.unitId!=0 && userObj.circleId!=0 && userObj.divisionId!=0 && userObj.subdivisionId==0  }">	
						   <c:if test="${userObj.unitId>0  &&  userObj.circleId>0  &&  userObj.divisionId>0 }">	
			 <c:out value="${userObj.divisionName}"></c:out>	
			 </c:if>
			 </c:if>	
			 
			   <c:if test="${userObj.unitId!=0 && userObj.circleId!=0 && userObj.divisionId!=0 && userObj.subdivisionId!=0 }">	
						   <c:if test="${userObj.unitId>0 &&  userObj.circleId>0  &&  userObj.divisionId>0 &&  userObj.subdivisionId>0  }">	
			 <c:out value="${userObj.subdivisionName}"></c:out>	
			 </c:if>
			 </c:if>
			 
			   <c:if test="${userObj.unitId==null && userObj.circleId==null && userObj.divisionId==null && userObj.subdivisionId==null }">	
						   
			 <c:out value="${userObj.userName}"></c:out>	
			 
			 </c:if>
			 
	</div></c:if> &emsp;&emsp;</h3></div>	
	
	
							<div class="panel-body">

						


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
		
	
	<div class="row show-grid ">
<div class="alert alert-info" role="alert">
				<strong style="color:#CA3F22"> Note1: Please use Exclude for View/Export button  for better view of data</strong>
				<br>
				<strong style="color:#CA3F22"> Note1: Edit/Delete actions are available in CE/DCE logins of Respective CE Office only.</strong>
				

			</div>
			</div>
			
			<div class="row show-grid ">
<div class="alert alert-info" role="alert" id="action_alert">
				
				

			</div>
			</div>
				
		
		
		<div class="row show-grid ">
				<div class="col-md-4">
				</div>
					<div class="col-md-4">
				</div>
				
			<div class="col-md-4" >
									
									<label class="label-controlPMS rowlebel "><b><a id="helpId" href="#">Click Here For Clarifications</a></b>
										
									</label> 
					 
					
											
									 </div>
							
			</div>
	 
<form:form id="ayacutdelete" method="post"
				modelAttribute="compayacutinput" >
				
			 <input name=urlvalue type=hidden >
				<input name=unitId  id="unitId" type=hidden  value="${unitId}">
				
				<input name=projAyacutId  id="projAyacutId" type=hidden > 
				<input name=eidtFlag  id="editFlag" type=hidden value="false" >
				<input name=deleteFlag  id="deleteFlag" type=hidden value="false" > 

		
		
		

 <%-- <div id="sidetree">
<div class="treeheader">&nbsp;</div>
<div id="sidetreecontrol"><a href="?#">Collapse All</a> | <a href="?#">Expand All</a></div>

<ul id="tree">


<c:forEach items="${unitList}" var="u">		
					
	<li>	
	
	
		<c:if test="${userObj.unitId==u.unitId}">
	<a class="myunit"  href="javascript:void(0);"  onclick="getCompAyacutData(<c:out value="${u.unitId}"></c:out>)" ><strong><c:out value="${u.unitName}"></c:out></strong></a>
	  <input name=unitName     id="unitName" type=hidden  value="<c:out value="${u.unitName}"></c:out>" />
	 </c:if>
	 
  
	
	
	</li>
	
	
	</c:forEach>  
	
		
		
	</ul>
	
	
</div>  --%>
<%-- 19052022	<div class="row show-grid ">
	 &emsp;&emsp;
	
<c:forEach items="${unitList}" var="u">	


	<c:if test="${userObj.unitId==u.unitId}">
	<strong>Click on Your CE Office To get Data: </strong> &emsp; <u><a class="myunit"  href="javascript:void(0);"  onclick="getCompAyacutData(<c:out value="${u.unitId}"></c:out>)" ><strong><c:out value="${u.unitName}"></c:out></strong></a></u>
	  <input name=unitName     id="unitName" type=hidden  value="<c:out value="${u.unitName}"></c:out>" />
	 </c:if>
	 
	</c:forEach>  
	</div> --%>
	<br>
 &emsp;&emsp;&emsp;&emsp;

	 <div class="show-grid gridList "  	style="display: block">
		              <div class="table-responsive" id="printarea">  	
						
		
						<table class="display table-bordered " id="countertable">
							<thead >
							
								<tr>
									<th >Sl.No</th>
									
									
									<!-- <th rowspan="1"> Constituency</th> -->
								<!-- 	<th  > District </th> -->
									<th > Mandal(Village) &emsp;&emsp;  <span style="color: red">Click on mandal name to get details </span></th>
									<!-- <th rowspan="1"> Village </th> -->
									
									 <th  >Project Name</th>
									<!--   <th  >Ayacut Year</th> -->
									  <th  >Division</th>
								    <th  >New Ayacut Proposed (Contemplated)</th>
									<th  >Ayacut Created</th>
									<th  >Irrigated Ayacut </th>
									<!--  <th  >Stabilized Ayacut</th> -->
									
								<!-- 	<th rowspan="1" >Package</th> -->
									
								<!-- 	<th >Project </th> -->
								<!-- 	<th  >Package </th> -->
								<!-- 	<th  >Unit</th> -->
								  <th  >Edit Jurisdiction &emsp;&emsp;  <span style="color: red">Click on mandal name to view jurisdiction </span></th> 
								  <th  >Edit</th> 
								 
									<th  >Delete</th>
									
									
									
									  	<th  >Remarks</th>
									
									
									
								</tr>
								
	
							</thead>

							
							<tbody>
								
								<c:if test="${projAyacutList!=null}">
								<%-- <c:if test="${totalconstList!=null}"> --%>
							
									<c:forEach items="${projAyacutList}" var="t" varStatus="count">
									
									
										<tr>
											
											<td style="text-align: center;" ><c:out  value="${count.count}"></c:out></td>											
											<%-- <td ><c:out value="${t.constName}"></c:out> </td> --%>
											<%-- <td ><c:out value="${t.districtName}"></c:out> </td> --%>						
											<td><button type="button" name="showmandalname" id="khfman"  class="btn btn-1 btn-info center-block "  onclick="ViewMandalInfo(${t.projAyacutId})"  > <c:out value="${t.mandalName}"></c:out> (<c:out value="${t.villageName}"></c:out>) </button></td>
											<%-- <td ><c:out value="${t.mandalName}"></c:out>(<c:out value="${t.villageName}"></c:out>)</td> --%>
										<!-- 	<td > </td> -->
											<td style="color:blue" ><b><c:out value="${t.projectName}"></c:out></b> </td>
										<%-- 23022024	<td style="color:blue" ><b><c:out value="${t.ayacutYear}"></c:out></b> </td> --%>
											<td style="color:maroon" ><b><c:out value="${t.divisionName}"></c:out></b> </td>
											
											<td ><c:out value="${t.contemplatedAyacut}"></c:out> </td>
											<td ><c:out value="${t.ayacutCreated}"></c:out> </td>
											 <td ><c:out value="${t.irriagtedAyacut}"></c:out> </td> 
										<%-- <td ><c:out value="${t.stableAyacut}"></c:out> </td> --%>
										<%-- 	<td style="color: blue" ><c:out value="${t.projectName}"></c:out> </td> --%>
											
										   <%--   <td ><c:out value="${t.packageName}"></c:out> </td>  --%>
											
											
										<%-- 	<td ><b><c:out value="${t.unitName}"></c:out></b></td> --%>
											
								
								
							      <c:choose>									
										 <c:when test = "${userObj.unitId!=0 && userObj.circleId==0 && userObj.divisionId==0 && userObj.subdivisionId==0 }">
										 
										  <c:choose>			
										  <c:when test="${userObj.unitId>0 && (userObj.designationId==5 || userObj.designationId==7 || userObj.designationId==9 || userObj.designationId==10 ) }">
										 
										 <td><button type="button" class="btn btn-info btn-sm" onclick="editJurisdictionData(<c:out value="${t.projAyacutId}"></c:out>,<c:out value="${t.unitId}"></c:out>,'${t.unitName}',${t.circleId},${t.divisionId} )"><span class="glyphicon glyphicon-plus"></span></button></td>
										 
										 
										  <td > <button type="button" class="btn btn-primary btn-sm" onclick='editCompAyacutData(<c:out value="${t.projAyacutId}"></c:out>)'><span class="glyphicon glyphicon-plus"></span></button> </td>
										
										
										<td><button type="button" class="btn btn-danger btn-sm" onclick='deleteCompAyacutData(<c:out value="${t.projAyacutId}"></c:out> )'><span class="glyphicon glyphicon-remove"></span></button></td> 
										<%--  <c:choose>  --%>
										<%--  <c:when test="${userObj.unitId==4 && (userObj.designationId==2 ) }"> --%>
										  
										  <%-- </c:when> --%>
										  <%--  <c:otherwise>
										  <td></td>
										  </c:otherwise>
										 </c:choose>  --%>
										 </c:when>
										   <c:otherwise>
										   <td></td>
										   <td></td>
										    <td></td>
										   
										   </c:otherwise>
										 </c:choose>
										 </c:when>
										 
										   <c:otherwise>
										   <td></td>
										   <td></td>
										    <td></td>
										   
										   </c:otherwise>
										
										</c:choose>
										
										<td ><c:out value="${t.remarks}"></c:out> </td>
											
							</tr>
						
							
							
							
						
							</c:forEach>
						
								
							
							</c:if>
							
								
								
								</tbody>
							

						</table>
						
						</div>
						</div>
						
		
			
					
</form:form>	


</div>
</div>
</div>



		
	
		

</div>

<div id="ayacutinfo_dialogue" >
  
  <form:form id="ayacutinfo" method="post" modelAttribute="caggist"
		name="cagform" data-parsley-validate-if-empty=""
		enctype="multipart/form-data">
		
		<c:if test="${projAyacutList!=null }">
					<c:forEach items="${projAyacutList}" var="d" varStatus="count">	
					
	<div class="col-md-12 invDiv ainfo" id="${d.projAyacutId}info">	
	
	<div class="col-md-6" style="color: blue">
											 <label class="label-control rowlebel ">Constituency</label>
											 </div>				      
		<div class="col-md-6">
											 <label class="label-control rowlebel ">${d.constName}</label>
											 </div>
	
	
	<div class="col-md-6" style="color: blue"> 
											 <label class="label-control rowlebel ">District Name</label>
											 </div>	
	    <div class="col-md-6">
											 <label class="label-control rowlebel ">${d.districtName}</label>
											 </div>
											 
		<div class="col-md-6" style="color: blue">
											 <label class="label-control rowlebel ">Mandal Name</label>
											 </div>	
		<div class="col-md-6">
											 <label class="label-control rowlebel ">${d.mandalName}</label>
											 </div>
	    <div class="col-md-6" style="color: blue">
											 <label class="label-control rowlebel ">Village Name</label>
											 </div>	
											 
	     
		<div class="col-md-6">
											 <label class="label-control rowlebel ">${d.villageName}</label>
											 </div>
		<div class="col-md-6" style="color: blue">
											 <label class="label-control rowlebel ">Unit Name</label>
											 </div>				      
		<div class="col-md-6">
											 <label class="label-control rowlebel ">${d.unitName}</label>
											 </div>
											 
				<div class="col-md-6" style="color: blue">
											 <label class="label-control rowlebel ">Circle Name</label>
											 </div>				      
		<div class="col-md-6">
											 <label class="label-control rowlebel ">${d.circleName}</label>
											 </div>
				<div class="col-md-6" style="color: blue">
											 <label class="label-control rowlebel ">Division Name</label>
											 </div>				      
		<div class="col-md-6">
											 <label class="label-control rowlebel ">${d.divisionName}</label>
											 </div>
											 
		<div class="col-md-6" style="color: blue">
											 <label class="label-control rowlebel ">Project Name</label>
											 </div>				      
		<div class="col-md-6">
											 <label class="label-control rowlebel ">${d.projectName}</label>
											 </div>
		    <div class="col-md-6" style="color: blue">
											 <label class="label-control rowlebel ">Package Name</label>
											 </div>	
		<div class="col-md-6">
											 <label class="label-control rowlebel ">${d.packageName}</label>
											 </div>


	
	</div>										 
											 
											 
										  
			</c:forEach>
			</c:if>						
										
										
										
											 
										
</form:form>
  </div>
  
  
  
  <div id="ayacutjuris_dialogue" >
  
  <form:form id="ayacutjuris" method="post" modelAttribute="caggist"
		name="ayacutjurisform" data-parsley-validate-if-empty=""
		enctype="multipart/form-data">
		
		 <input type="hidden" class="form-control"  id="selectedUnitId" name="unitId"  value="0" />
		 <input type="hidden" class="form-control"  id="selectedCircleId"   value="0" />
		  <input type="hidden" class="form-control"  id="selectedDivisionId"   value="0" />
    
         <input type="hidden" class="form-control"  id="hiddenprojAyacutId" name="projAyacutId"  value="0" />
	
	<div class="col-md-12  " id="jurisinfo">	
	
<%-- 	 <div class="col-md-6">
										<label class="label-controlPMS rowlebel ">
										Select Unit <font color=red>*</font> </label>
										</div>
										
										 <div class="col-md-6">
										<select class="form-control" id="diunitId" name="unitId"  onchange="getCircles(),getDivisions()" required> 
										<option value=" ">--select--</option>  
										 <c:forEach items="${unitList}" var="u">
									              <option value="${u.unitId}">${u.unitName}</option>

								</c:forEach>
										
										
										</select> </div>
										
										
 --%>	
 
 <div class="col-md-6">
										<label class="label-controlPMS rowlebel ">
									   Unit Name <font color=red>*</font> </label>
										</div>
										
										 <div class="col-md-6" id="hiddenUnitName">
										
										</div>									<div class="col-md-6">
										<label class="label-controlPMS rowlebel ">
										Select circle <font color=red>*</font> </label>
										</div>
										
										 <div class="col-md-6">
										<select class="form-control" id="dicircleId" name="circleId"  required  onchange="getDivisions()"> 
										
										
										</select> </div>
										<div class="col-md-6">
										<label class="label-controlPMS rowlebel ">
										Select division  <font color=red>*</font></label>
										</div>
										
										 <div class="col-md-6">
										<select class="form-control" id="didivisionId" name="divisionId"   required > 
										
										<!-- <option value="3">CAG Report</option> -->
										
										</select> 
										
										<br>
										<br>
										
										</div>
										
										
										
										<div class="col-md-12" >
											  
					<div class="col-md-4" ></div>
					<div class="col-md-4" >
					<button type="button" name="showtanksname" id="addtankfeedinf" 
																	class="btn btn-1 btn-primary center-block  "   onclick="updateJusrisdiction()" >Submit</button>
					
					 
					 
					 </div>
					 <div class="col-md-4" ></div>
					 
					 <br>	
											  
	




		   
	</div>	


	
	</div>										 
											 
											 
	
										
											 
										
</form:form>
  </div>

<div id="faqSpopup" class="ayucutFaq container">
    


    <div class="panel-group" id="accordion">
        <div class="faqHeader">General Clarifications for Edit/Delete</div>
        <div class="panel panel-default">
            <div class="panel-heading">
                <h4 class="panel-title">
                    <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion" href="#collapseOne"><b>Click On the CE Office</b></a>
                </h4>
            </div>
            <div id="collapseOne" class="panel-collapse collapse in">
                <div class="panel-body">
                    Please click on the CE Office Name to see individual records entered.
                </div>
            </div>
        </div>
        <div class="panel panel-default">
            <div class="panel-heading">
                <h4 class="panel-title">
                    <a class="accordion-toggle collapsed" data-toggle="collapse" data-parent="#accordion" href="#collapseTen"><b>Search</b></a>
                </h4>
            </div>
            <div id="collapseTen" class="panel-collapse collapse in">
                <div class="panel-body">
                  Any of the column data in the table can be entered to see related information in the table and can be exported to Excel Sheet.
                </div>
            </div>
        </div>
        <div class="panel panel-default">
            <div class="panel-heading">
                <h4 class="panel-title">
                    <a class="accordion-toggle collapsed" data-toggle="collapse" data-parent="#accordion" href="#collapseEleven"><b>Save to Excel</b></a>
                </h4>
            </div>
            <div id="collapseEleven" class="panel-collapse collapse in">
                <div class="panel-body">
              Download data using save to Excel.
                    
                </div>
            </div>
        </div>

        <div class="panel panel-default">
            <div class="panel-heading">
                <h4 class="panel-title">
                    <a class="accordion-toggle collapsed" data-toggle="collapse" data-parent="#accordion" href="#collapse1"><b>Copy</b></a>
                </h4>
            </div>
            <div id="collapse1" class="panel-collapse collapse in">
                <div class="panel-body">
                  Data can be copied to Excel or any word document.
                </div>
            </div>
        </div>
        
        <div class="panel panel-default">
            <div class="panel-heading">
                <h4 class="panel-title">
                    <a class="accordion-toggle collapsed" data-toggle="collapse" data-parent="#accordion" href="#collapse2"><b>Edit</b></a>
                </h4>
            </div>
            <div id="collapse2" class="panel-collapse collapse in">
                <div class="panel-body">
               If any modifications in the data entered can be changed by clicking on the edit Button.<br>
               If the data is not available for Ayacut columns. please enter 0.00.
                </div>
            </div>
        </div>
        
        <div class="panel panel-default">
            <div class="panel-heading">
                <h4 class="panel-title">
                    <a class="accordion-toggle collapsed" data-toggle="collapse" data-parent="#accordion" href="#collapse3"><b>Delete</b></a>
                </h4>
            </div>
            <div id="collapse3" class="panel-collapse collapse in">
                <div class="panel-body">
                 Please delete respective record carefully . Also please use search or save to excel option for Deleting the respective record.
                </div>
            </div>
        </div>
        
      
        
      
        
            
        </div>
    </div>
 <script type="text/javascript" src="../js/parsley.js"></script>

<script src="../js/Html5DataTable/jquery.dataTables.min.js" type="text/javascript"></script>	
	<script src=" ../js/Html5DataTable/dataTables.buttons.min.js" type="text/javascript"></script>	
	<script src=" ../js/Html5DataTable/jszip.min.js" type="text/javascript"></script>	
	<script src="../js/Html5DataTable/pdfmake.min.js" type="text/javascript"></script>	
	<script src=" ../js/Html5DataTable/vfs_fonts.js" type="text/javascript"></script>	
	<script src="../js/Html5DataTable/buttons.html5.min.js" type="text/javascript"></script>
	<script src="../js/Html5DataTable/buttons.print.min.js" type="text/javascript"></script>
	<script src="../js/Html5DataTable/dataTables.select.min.js" type="text/javascript"></script>	
		<script src="../js/Html5DataTable/buttons.colVis.min.js" type="text/javascript"></script>
	
	
	<script type="text/javascript">			
							
    $('#countertable').DataTable( {
        dom: 'Bfrtip',
        responsive: true,
        "paging": false,
        "ordering": false,
        "autoWidth": true,
        "lengthChange": false,
        "pageLength": 20,
        "scrollY": 400,
        "scrollX": true,
        
        buttons: [
                  {
                      extend: 'copyHtml5',
                      text:  'Copy Data',
                      exportOptions: {
                          columns: [ 0, ':visible' ]
                      }
                  },
            {
                extend: 'excelHtml5',
                autoFilter: true,
                sheetName: 'Exported_Paras_data',
                text:  'Save To Excel',
                className: 'btn-primary ',
                messageTop: 'Ayacut Details',
                exportOptions: {
                    columns: ':visible'
                }
               
                
            },
            {
                extend: 'colvis',
                text: 'Exclude for better View',
               
                columnText: function ( dt, idx, title ) {
                    return title;
                }
               
                }
            
        ]
       
    } );
    
    
    var table= $('#countertable ');
    
    $('#countertable tbody').on( 'click', 'tr', function () {
        if ( $(this).hasClass('selected') ) {
            $(this).removeClass('selected');
        }
        else {
        	$('#countertable table tr.selected').removeClass('selected');
            $(this).addClass('selected');
        }
    } );
    
    </script>	