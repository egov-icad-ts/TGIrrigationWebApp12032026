
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

<!-- 
<style type="text/css">




.ui-dialog .ui-dialog-titlebar-close{
  height: 30px;
  width: 30px;
}

</style>
 -->






<script type="text/javascript">

$(document).ready(function(){
	
	
		 
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
	
	$('#reservoirId').multiselect({
		 
		 enableCaseInsensitiveFiltering: true
		 
	});
	





	
	
	
	
	
	
	 
	 
	 
	

	}); 

</script>
<script type="text/javascript">

function getProjects(unitId,hkey) {

	var unitId = unitId ;
		
		//$('#unitId').val();

	//  alert("procId"+procId);
	
	if(hkey==1){
	$('#projectId').multiselect('rebuild');
}
	
	if(hkey==2){
	$('#dipackprojectId').multiselect('rebuild');
	}

	$.ajax({
		url : "../web/getProjects?unitId=" + unitId,
		type : "GET",
		success : function(response) {
			
			if(hkey==1){
			var $select = $('#projectId');
			
			var selectedprojectId=$('#hiddenprojectId').val();
			}
			if(hkey==2){
				var $select = $('#dipackprojectId');
				}
			$select.find('option').remove();

			var obj = JSON.parse(response);

			if(hkey==1){
			$('#projectId')
					.append('<option value="0"> --select--</option>');
			}
			
			if(hkey==2){
			$('#dipackprojectId')
			.append('<option value="0"> --select--</option>');
			}

			
			$.each(obj, function(key, value) {
				
				if(hkey==1){
					
					if(selectedprojectId==value.projectId){

				$('#projectId').append(
						'<option value="'+value.projectId+'"selected="selected"> '
								+ value.projectName + '</option>');
					}
					
					if(selectedprojectId==null || selectedprojectId!=value.projectId){

						$('#projectId').append(
								'<option value="'+value.projectId+'"> '
										+ value.projectName + '</option>');
							}

				$('#projectId').multiselect('rebuild')
				}
				if(hkey==2){
				$('#dipackprojectId').append(
						'<option value="'+value.projectId+'"> '
								+ value.projectName + '</option>');

				$('#dipackprojectId').multiselect('rebuild')
				}

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

function getPackages(projectId) {

	var projectId =projectId ;
		
		//$('#projectId').val();

	//  alert("procId"+procId);
	$('#packageId').multiselect('rebuild');

	$.ajax({
		url : "../web/getPackages?projectId=" + projectId,
		type : "GET",
		success : function(response) {
			var $select = $('#packageId');
			$select.find('option').remove();
			
			var selectedpackageId=$('#hiddenpackageId').val();

			var obj = JSON.parse(response);

			$('#packageId')
					.append('<option value="0"> --select--</option>');

			$.each(obj, function(key, value) {
				
				if(selectedpackageId==value.pkgId){

				$('#packageId').append(
						'<option value="'+value.pkgId+'" selected="selected"> ' + value.pkgName
								+ '</option>');
				}
				if(selectedpackageId==null || selectedpackageId!=value.pkgId){
					$('#packageId').append(
							'<option value="'+value.pkgId+'"> ' + value.pkgName
									+ '</option>');
					
				}

				$('#packageId').multiselect('rebuild')

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

function getCircles(unitId,hkey) {
	//alert("kal");
	//var districtId=document.getElementById("districtId").value;
	var unitId = unitId ;
		//document.getElementById("unitId").value;
	//alert(mandalId);

	$
			.ajax({
				url : "../web/getCircles?unitId=" + unitId,
				type : "GET",
				success : function(response) {
                    if(hkey==1){
					var $select = $('#circleId');
					
					var selectedCircleId= $('#hiddencircleId').val();
					
					//alert("selectedCircleId"+selectedCircleId);
                    }
                    if(hkey==2){
                    	
                    	var $select = $('#dipackcircleId');
                    }
					$select.find('option').remove();

					var obj = JSON.parse(response);
					
					if(hkey==1){
					$('#circleId').append(
							'<option value="0"> --select--</option>');
					}
					if(hkey==2){
					$('#dipackcircleId').append(
					'<option value="0"> --select--</option>');
			}

					$.each(obj, function(key, value) {
						if(hkey==1){
							
	if(selectedCircleId==value.circleId){	
	  							
	  							/* $('#projectId').val(value.projectId);
	  							$('#projectName').val(value.projectName); */
	  						
	  					$('#circleId').append( '<option value="'+value.circleId+'" selected="selected"> '+value.circleName+'</option>' );
	  					
	  						}
	  						
	  					 if(selectedCircleId==null||selectedCircleId!=value.circleId){
	  							$('#circleId').append( '<option value="'+value.circleId+'"> '+value.circleName+'</option>' );	
	  						
	  						} 
							
						

						$('#circleId').multiselect('rebuild');
						
						}
						if(hkey==2){
							$('#dipackcircleId').append(
									'<option value="'+value.circleId+'" > '
											+ value.circleName + '</option>');

							$('#dipackcircleId').multiselect('rebuild');
							
							}
					});

				},
				error : function() {
					alert(error);
				}
			});
}

function getDivisions(circleId,hkey) {
	//alert("kal");
	//var districtId=document.getElementById("districtId").value;
	var circleId =circleId ;
		//document.getElementById("circleId").value;
	//alert(mandalId);

	$.ajax({
		url : "../web/getDivisions?circleId=" + circleId,
		type : "GET",
		success : function(response) {
			if(hkey==1){
			var $select = $('#divisionId');
			
			var selecteddivisionId= $('#hiddendivisionId').val();
			}
			if(hkey==2){
				var $select = $('#dipackdivisionId');
				}

			$select.find('option').remove();

			var obj = JSON.parse(response);
			
			if(hkey==1){
			$('#divisionId').append(
					'<option value="0"> --select--</option>');
			}
			if(hkey==2){
			$('#dipackdivisionId').append(
			'<option value="0"> --select--</option>');
			}

			$.each(obj, function(key, value) {
				if(hkey==1){
					if(selecteddivisionId==value.divisionId){
				$('#divisionId').append(
						'<option value="'+value.divisionId+'" selected="selected"> '
								+ value.divisionName + '</option>');
					}
					
					 if(selecteddivisionId==null||selecteddivisionId!=value.divisionId){
						 
							$('#divisionId').append(
									'<option value="'+value.divisionId+'"> '
											+ value.divisionName + '</option>');
						 
					 }

				$('#divisionId').multiselect('rebuild');
				}
				if(hkey==2){
					$('#dipackdivisionId').append(
							'<option value="'+value.divisionId+'" > '
									+ value.divisionName + '</option>');

					$('#dipackdivisionId').multiselect('rebuild');
					}
			});

		},
		error : function() {
			alert(error);
		}
	});
}



function getSubDivisions(divisionId,hkey) {
	//alert("kal");
	//var districtId=document.getElementById("districtId").value;
	var divisionId = divisionId ;
		
		//document.getElementById("divisionId").value;
	//alert(mandalId);

	$.ajax({
		url : "../web/getSubDivisions?divisionId=" + divisionId,
		type : "GET",
		success : function(response) {
			if(hkey==1){
			var $select = $('#subdivisionId');
			
			var selectedsubdivisionId= $('#hiddensubdivisionId').val();
			//alert("selectedsubdivisionId"+selectedsubdivisionId);
			}
			/* if(hkey==2){
				var $select = $('#subdivisionId');	
				
			} */
			$select.find('option').remove();

			var obj = JSON.parse(response);
			
		
			$('#subdivisionId').append(
					'<option value="0"> --select--</option>');
			

			$.each(obj, function(key, value) {

				if(selectedsubdivisionId==value.subdivisionId){
				$('#subdivisionId').append(
						'<option value="'+value.subdivisionId+'" selected="selected" > '
								+ value.subdivisionName + '</option>');
				}
				if(selectedsubdivisionId==null || selectedsubdivisionId!=value.subdivisionId){
					$('#subdivisionId').append(
							'<option value="'+value.subdivisionId+'" > '
									+ value.subdivisionName + '</option>');
					}

				$('#subdivisionId').multiselect('rebuild');
			});

		},
		error : function() {
			alert(error);
		}
	});
}

function getResList(resCode) {
	//alert("kal"+resCode);
	//var districtId=document.getElementById("districtId").value;
	
	//alert("petId"+petId);	
		//document.getElementById("divisionId").value;
	//alert(mandalId);

	$.ajax({
		url : "../invtsimis/reslistbyId?rescode="+resCode ,
		type : "GET",
		success : function(response) {
			
		//	alert("here"+response);

			var $select = $('#reservoirId');
            
			
		//	console.log(response);
			
			var obj = JSON.parse(response);
		  // alert(obj.petitionerId);

		//	
		

			//$.each(obj, function(key, value) {

				$('#reservoirId').append(
						'<option value="'+obj.resCode+'" > '
								+ obj.resName + '</option>');

				$('#reservoirId').multiselect('rebuild');
			//});

		},
		error : function() {
			alert(error);
		}
	});
}

function getresunitlistmapData(unitId){
	
	
	
	  $("#addunithead").remove(); 
	
	
	
	  $.ajax({	          
	      url: "../invtsimis/resunitlistbyId?unitId="+unitId,
	      method:"GET",
	      async: false,
	     
		 
	      success: function (response) {
	    	  
	    	//  alert(response);
	    	  
	    	//  console.log(response);
	   
	    	  $("#resdata").empty(); 
	    	  
	    	
	    	  
	    	  
	    	 
	     	 // console.log(response);
	     	  
	     	  var table1 = $("#res-data tbody");
	     	  
	     	 var table2 = $("#res-data thead");
	     	  
	     	
	     	  
	     	  if(response!=null){
	     	
	           var obj = JSON.parse(response);
	           
	        //   $("#deletealert").html("Note : Gist of the para Can not be Edited or Deleted Once the subpara is entered"); 
	           
	          
	         	console.log(obj);
	         	
	          table2.append( 
	         			
	         			'<tr id="addunithead"><th colspan="3"  style="text-align: center;color:maroon"><b>Unit Name</b> </th><th colspan="3"  style="text-align: center;color:maroon"><b>'+obj[0].unitName+'</b> </th></tr>'); 
	         	
	         	for(var m in obj ){
	         
	         	
	         	table1.append( 
	         			
	         			
	         			'<tr>'+    			
	         			
	         			
	         			'<td style="text-align: center;"><b>'+obj[m].circleName+'</b> </td>'+ 
	         			'<td style="text-align: center;"><b>'+obj[m].divisionName+'</b> </td>'+
	         			'<td style="text-align: center;"><b>'+obj[m].subdivisionName+'</b> </td>'+ 
	         			'<td style="text-align: center;"><b>'+obj[m].projectName+'</b></td>'+
	         			'<td style="text-align: center;"><b>'+obj[m].packName+'</b></td>'+
	         			'<td style="text-align: center;"><b>'+obj[m].resName+'</b></td>'+
	         			'<td style="text-align: center;"><b>'+obj[m].workinspectorno+'</b></td>'+
	         			'<td style="text-align: center;"><b>'+obj[m].luscurno+'</b></td>'+ 
	         			'<td style="text-align: center;"><b>'+obj[m].remarks+'</b></td>'+ 
	         			'</tr>');
	         	   
	         	  
	         	}
	          
	         	 // alert(response);
	         	
	         	
	     	  }
	                    
			  

	      },
	      
	      error : function(){
	    	 alert(error);
	    
	      }

	  
	  }); 	
	
}




function getResInfo(resCode){
	
	//alert("resCode"+resCode);
	
$.ajax({
    type: "GET", //rest Type
    dataType: 'json', //mispelled
    url: "../invReport/resinfobycode?resCode="+resCode,
    async: false,
    contentType: "application/json; charset=utf-8",
    success: function (obj) {
  	 // alert(obj);
	  
	//  console.log(obj);

	  $("#infodata").empty(); 
	
 	  
 	  var table1 = $("#info-data tbody");
 	  
 	 
 	  if(obj!=null){ 	
      // var obj = JSON.parse(msg);     
     //	console.log(obj);     	
     	table1.append(   			
     			'<tr><td  colspan="4"  style="text-align: center;font-size:20px;color:blue "><b>Salient features</b> </td></tr>'+
     			'<tr><td style="text-align: center;"><b>Reservoir Name</b> </td><td style="text-align: center;"><b>'+obj.resName+'</b> </td><td style="text-align: center;"><b>Reservoir Status</b> </td><td style="text-align: center;"><b>'+obj.resStatus+'</b> </td></tr>'+ 
     			
     			'<tr><td style="text-align: center;"><b>Water Spread Area</b> </td><td style="text-align: center;"><b>'+obj.waterSpreadArea+'</b> </td><td style="text-align: center;"><b>Hydro Power(M.W)</b> </td><td style="text-align: center;"><b>'+obj.hydroPower+'</b></td></tr>'+ 
     			'<tr><td style="text-align: center;"><b>Latitude</b> </td><td style="text-align: center;"><b>'+obj.resLatitude+'</b> </td><td style="text-align: center;"><b>Longitude</b> </td><td style="text-align: center;"><b>'+obj.resLongitude+'</b></td></tr>'+
     			'<tr><td style="text-align: center;"><b>Land Acquistion</b> </td><td style="text-align: center;"><b>'+obj.landAcquistion+'</b> </td><td style="text-align: center;"><b>Catchment Area</b> </td><td style="text-align: center;"><b>'+obj.catchmentArea+'</b></td></tr>'+
     			'<tr><td style="text-align: center;"><b>M.F.D(cumecs)</b> </td><td style="text-align: center;"><b>'+obj.maxfloodDischarge+'</b> </td></tr>'+
     			'<tr><td  colspan="4" style="text-align: center; font-size:11px; color:maroon"><b>Capacity(TMS)</b> </td></tr>'+
     		
     			'<tr><td style="text-align: center;"><b>MWL Capacity</b> </td><td style="text-align: center;"><b>'+obj.mwlCapacity+'</b></td><td style="text-align: center;"><b>FRL Capacity</b> </td><td style="text-align: center;"><b>'+obj.frlCapacity+'</b></td></tr>'+
     			
     			'<tr><td style="text-align: center;"><b>MDDL Capacity</b> </td><td style="text-align: center;"><b>'+obj.mddlCapacity+'</b></td><td style="text-align: center;"><b>Dead Storage Capacity</b> </td><td style="text-align: center;"><b>'+obj.deadstorageCapacity+'</b></td></tr>'+
     			'<tr><td  colspan="4" style="text-align: center; font-size:11px; color:maroon"><b>Level(+Mts.)</b> </td></tr>'+
     			'<tr><td style="text-align: center; "><b>TRL Level</b> </td><td style="text-align: center;"><b>'+obj.trlLevel+'</b></td><td style="text-align: center; "><b>FRL Level</b> </td><td style="text-align: center;"><b>'+obj.frlLevel+'</b></td></tr>'+
     			'<tr><td style="text-align: center; "><b>MWL Level</b> </td><td style="text-align: center;"><b>'+obj.mwlLevel+'</b></td><td style="text-align: center; "><b>MDDL Level</b> </td><td style="text-align: center;"><b>'+obj.mddlLevel+'</b></td></tr>'+
     			'<tr><td style="text-align: center; "><b>Dead Storage Level</b> </td><td style="text-align: center;"><b>'+obj.deadstorageLevel+'</b></td></tr>'+
     			'<tr><td  colspan="4" style="text-align: center; font-size:20px; color:blue"><b>Spill Way Details</b> </td></tr>'+
     			'<tr><td  colspan="4" style="text-align: center; font-size:11px; color:maroon"><b>Length(Mts.)</b> </td></tr>'+
     			'<tr><td style="text-align: center;"><b>Spill Way Length</b> </td><td style="text-align: center;"><b>'+obj.spillwayLength+'</b></td><td style="text-align: center;"><b>N.O.F. Length</b> </td><td style="text-align: center;"><b>'+obj.nonoverflowLength+'</b></td></tr>'+
     			
     			'<tr><td style="text-align: center;"><b>Maximum Height SpillWay</b> </td><td style="text-align: center;"><b>'+obj.maxhtSpillWay+'</b></td><td style="text-align: center;"><b>Top Width Dam</b> </td><td style="text-align: center;"><b>'+obj.topWidthDam+'</b></td></tr>'+
     			
     			'<tr><td style="text-align: center;"><b>Max Base Width Dam</b> </td><td style="text-align: center;"><b>'+obj.maxbaseWidthDam+'</b></td><td style="text-align: center;"><b>Clear Bridge Width</b> </td><td style="text-align: center;"><b>'+obj.clearBridgeWidth+'</b></td></tr>'+
     			
     			'<tr><td style="text-align: center;"><b>Stilling Basin Length/Apron</b> </td><td style="text-align: center;"><b>'+obj.stillingBasinLength+'</b></td></tr>'+
     			'<tr><td  colspan="4" style="text-align: center; font-size:11px; color:maroon"><b>Level(Mts.)</b> </td></tr>'+
     			
     			'<tr><td style="text-align: center;"><b>Average River Bed Level</b> </td><td style="text-align: center;"><b>'+obj.avgRiverbedLevel+'</b></td><td style="text-align: center;"><b>Spill Way Crest Level</b> </td><td style="text-align: center;"><b>'+obj.spillWayCrestLevel+'</b></td></tr>'+
     			
     			'<tr><td style="text-align: center;"><b>Bridge Top Level</b> </td><td style="text-align: center;"><b>'+obj.bridgeTopLevel+'</b></td><td style="text-align: center;"><b>Invert Level of Bucket</b> </td><td style="text-align: center;"><b>'+obj.invertLevel+'</b></td></tr>'+
     			
     			'<tr><td style="text-align: center;"><b>Stilling Basin Level/Apron </b> </td><td style="text-align: center;"><b>'+obj.stillingBasinLevel+'</b></td><td style="text-align: center;"><b>Deepest Foundation Level</b> </td><td style="text-align: center;"><b>'+obj.deepestfoundationLevel+'</b></td></tr>'+
     			'<tr><td  colspan="4" style="text-align: center;font-size:20px;color:blue "><b>Earth Dam / Concrete Dam Details</b> </td></tr>'+
     			'<tr><td style="text-align: center;"><b>Earth Dam Left Length</b> </td><td style="text-align: center;"><b>'+obj.earthdamLeftLength+'</b></td><td style="text-align: center;"><b>Earth Dam Right Length</b> </td><td style="text-align: center;"><b>'+obj.earthdamRightLength+'</b></td></tr>'+
     			
     			'<tr><td style="text-align: center;"><b>Maximum Height </b> </td><td style="text-align: center;"><b>'+obj.maxHeight+'</b></td><td style="text-align: center;"><b>Masonary Dam Length </b> </td><td style="text-align: center;"><b>'+obj.masonarydamLength+'</b></td></tr>'+
     			
     			'<tr><td style="text-align: center;"><b>Rock Fill Dam Length</b> </td><td style="text-align: center;"><b>'+obj.rockfilldamLength+'</b></td><td style="text-align: center;"><b>Concrete Dam Length</b> </td><td style="text-align: center;"><b>'+obj.concretedamLength+'</b></td></tr>'+
     			'<tr><td style="text-align: center;"><b>Zonal Section Length</b> </td><td style="text-align: center;"><b>'+obj.zonalSectionLength+'</b></td><td style="text-align: center;"><b>Homogeneous Section Length</b> </td><td style="text-align: center;"><b>'+obj.homogeneousSectionLength+'</b></td></tr>'+
     			'<tr><td  colspan="2" style="text-align: center;"><input type="button" class="btn btn-1 btn-primary center-block" 	id="editresinfo" value="Edit Reservoir Info" onclick="editresinfo(\'' + obj.resCode + '\')">  </td><td   colspan="2" style="text-align: center;"><input type="button" class="btn btn-1 btn-primary center-block" 	id="deleteresinfo" value="Delete Reservoir Info" onclick="deleteresinfo(\'' + obj.resCode + '\')"> </td></tr>'
     			
     			
     			
     				);
     	   
     	  
     	}
      
     	 // alert(response);
     	
     	
 	
	 



}
});

}

function editresinfo(input){
	
	  $('#viewresinfo-dailogue').dialog('close');
	var val=input;
	//alert("kal"+resCode);	
	 $.ajax({       
	    
		   type: "GET", //rest Type
		    dataType: 'json', //mispelled
		    url: "../invReport/resinfobycode?resCode="+val,
		    async: false,
		    contentType: "application/json; charset=utf-8",
		 
	      success: function (obj) {
	   
	    	  console.log(obj);
	    	
	    	 // var obj = JSON.parse(response);
	    	
	    	 
	    	
	    	
	    	  $('#resName').val(obj.resName);  
	    	 $('#waterSpreadArea').val(obj.waterSpreadArea);  
	    	 $('#resLatitude').val(obj.resLatitude);  
	    	 $('#resLongitude').val(obj.resLongitude);  
	    	 $('#resStatusId').val(obj.resStatusId);  
	    	 $('#hydroPower').val(obj.hydroPower); 
	    	 $('#landAcquistion').val(obj.landAcquistion); 
	    	 $('#catchmentArea').val(obj.catchmentArea); 
	    	 $('#maxfloodDischarge').val(obj.maxfloodDischarge); 
	    	 
	    	 $('#mwlCapacity').val(obj.mwlCapacity);  
	    	 $('#frlCapacity').val(obj.frlCapacity); 
	    	 
	    	 $('#frlcapacity').val(obj.frlcapacity); 
	    	 
	    	 $('#mddlCapacity').val(obj.mddlCapacity); 
	    	 $('#deadstorageCapacity').val(obj.deadstorageCapacity); 
	    	 $('#trlLevel').val(obj.trlLevel); 
	    	 $('#frlLevel').val(obj.frlLevel); 
	    	 $('#mwlLevel').val(obj.mwlLevel); 
	    	 $('#mddlLevel').val(obj.mddlLevel); 
	    	 $('#deadstorageLevel').val(obj.deadstorageLevel); 
	    
	    	 $('#spillwayLength').val(obj.spillwayLength); 
	    	 $('#nonoverflowLength').val(obj.nonoverflowLength); 
	    	 
	    	 $('#maxhtSpillWay').val(obj.maxhtSpillWay); 
	    	 $('#topWidthDam').val(obj.topWidthDam);
	    	 $('#maxbaseWidthDam').val(obj.maxbaseWidthDam);
	    	 $('#clearBridgeWidth').val(obj.clearBridgeWidth);
	    	 $('#stillingBasinLength').val(obj.stillingBasinLength); 
	    	 $('#deepestfoundationLevel').val(obj.deepestfoundationLevel); 
	    	 $('#avgRiverbedLevel').val(obj.avgRiverbedLevel); 
	    	 $('#spillWayCrestLevel').val(obj.spillWayCrestLevel); 
	    	 $('#bridgeTopLevel').val(obj.bridgeTopLevel); 
	    	 
	    	 $('#invertLevel').val(obj.invertLevel); 
	    	 $('#stillingBasinLevel').val(obj.stillingBasinLevel); 
	    	 $('#earthdamLeftLength').val(obj.earthdamLeftLength); 
	    	 $('#earthdamRightLength').val(obj.earthdamRightLength);
	    	 $('#maxHeight').val(obj.maxHeight);
	    	 $('#masonarydamLength').val(obj.masonarydamLength);
	    	 
	    	 $('#rockfilldamLength').val(obj.rockfilldamLength);
	    	 $('#concretedamLength').val(obj.concretedamLength);
	    	 $('#zonalSectionLength').val(obj.zonalSectionLength);
	    	 $('#homogeneousSectionLength').val(obj.homogeneousSectionLength);
	    	
	    	 $('#resCodeid').val(obj.resCode);
	 

	      },
	      error : function(){
	    	 alert(error);
	    //  $('#action_paraalert').dialog('open');
	      }
	  }); 	
	 
	  
	  $('#res_dialogue').dialog('option', 'title', 'Edit Reservoir info');
		
	
	  $('#addres').text('EditReservoirInfo');
	  $('#res_dialogue').dialog('open');

}


function deleteresinfo(input){
	
	//alert("coming here"+input)
	var val=input;
	//alert("kal"+resCode);	
	 $.ajax({       
	    
		   type: "POST", //rest Type
		    dataType: 'json', //mispelled
		    url: "../invtsimis/deleteResinfodata?resCode="+val,
		    async: false,
		    contentType: "application/json; charset=utf-8",
		 
	      success: function (obj) {
	   
	    	  console.log(obj);
	    	
	    	 // var obj = JSON.parse(response);
	    	  
		    	 if(obj>0){
				    	
			    	 $('#viewresinfo-dailogue').dialog('close'); 
			 
			  $('#action_alert').html('<p>Reservoir Info Deleted Successfully</p>');
			    }
			    if(obj==0){
			    	
			    	  $('#action_alert').html('<p>Failed to Update data</p>');
			    }
		    	 
	    	 
	    	 
	    	 

	      },
	      error : function(){
	    	 alert(error);
	    //  $('#action_paraalert').dialog('open');
	      }
	  }); 	
	 
	  
	 

}

function resunitmapByResCode(rescode){
	
	
	
	$('#cusunithead').remove();
	  $.ajax({	          
	      url: "../invtsimis/resUnitListByResCode?resCode="+rescode,
	      method:"GET",
	      async: false,
	      cashe:false,
	     
		 
	      success: function (response) {
	    	  
	    	//  alert(response);
	    	  
	    	//  console.log(response);
	   
	    	  $("#jurisdata").empty(); 
	    	  
	    	
	    	  
	    	  
	    	 
	     	 // console.log(response);
	     	  
	     	  var table1 = $("#resjuris-data tbody");
	     	  
	     	 var table2 = $("#resjuris-data thead");
	     	  
	     	
	     	  
	     	  if(response!=null){
	     	
	           var obj = JSON.parse(response);
	           
	        //   $("#deletealert").html("Note : Gist of the para Can not be Edited or Deleted Once the subpara is entered"); 
	           
	          
	         	console.log(obj);
	         	
	          table2.append( 
	         			
	         			'<tr id="cusunithead"><th colspan="3"  style="text-align: center;color:maroon"><b>Unit Name</b> </th><th colspan="3"  style="text-align: center;color:maroon"><b>'+obj[0].unitName+'</b> </th></tr>'); 
	         	
	         	for(var m in obj ){
	         
	         	
	         	table1.append( 
	         			
	         			
	         			'<tr>'+    			
	         			
	         			
	         			'<td style="text-align: center;"><b>'+obj[m].circleName+'</b> </td>'+ 
	         			'<td style="text-align: center;"><b>'+obj[m].divisionName+'</b> </td>'+
	         			'<td style="text-align: center;"><b>'+obj[m].subdivisionName+'</b> </td>'+ 
	         			'<td style="text-align: center;"><b>'+obj[m].projectName+'</b></td>'+
	         			'<td style="text-align: center;"><b>'+obj[m].packName+'</b></td>'+
	         			'<td style="text-align: center;"><b>'+obj[m].resName+'</b></td>'+
	         			'<td style="text-align: center;"><b>'+obj[m].workinspectorno+'</b></td>'+
	         			'<td style="text-align: center;"><b>'+obj[m].luscurno+'</b></td>'+ 
	         			'<td style="text-align: center;"><b>'+obj[m].remarks+'</b></td>'+ 
	         			 '<td style="text-align: center;"><b><button type="button" class="btn btn-primary "  onclick="editresunitmapdata('+obj[m].resunitmapid+')"  >Edit </button></b></td>'+
		         			'<td style="text-align: center;"><b><button type="button" class="btn btn-primary "  onclick="deleteresunitmapdata('+obj[m].resunitmapid+')"  >Delete </button></b></td>'+
		         			 
		         			
	         			/* '<td style="text-align: center;"><b><button type="button" class="btn btn-primary "  onclick="editresjuris('+obj[m].resunitmapid+')"  >Edit </button></b></td>'+
	         			'<td style="text-align: center;"><b><button type="button" class="btn btn-primary "  onclick="deleteresjuris('+obj[m].resunitmapid+')"  >Delete </button></b></td>'+
	         			 */
	         			
	         				/*  <input type="hidden" class=" form-control "  id="reservoirId" name="resrervoirId" readonly="readonly" required value="'+obj[m].resName+'" /> */
	         				// (k < 1 ? '<td style="text-align: center;"><b> <button type="button" class="btn btn-primary "  onclick="editparagist('+obj[m].cagGistId+')"  >Edit</button></b></td>':'<td>Sub Paras Exist</td>')+
	         				// (k < 1 ?'<td style="text-align: center;color: red; "><b><button type="button" id="addPara"  class="btn btn-danger"  onclick="deleteGist('+obj[m].cagGistId+',\''+obj[m].financialYear+'\')"  >Delete Gist Para</button></b></td>' :'<td>Sub Paras Exist</td>')+    
	         				
	         				'</tr>');
	         	   
	         	  
	         	}
	          
	         	 // alert(response);
	         	
	         	
	     	  }
	                    
			  

	      },
	      
	      error : function(){
	    	 alert(error);
	    
	      }

	  
	  }); 	
	
}
function editresunitmapdata(resunitMapId){
	
	

	//alert("coming here"+resunitMapId)
	//var val=input;
	//alert("kal"+resCode);	
	 $.ajax({       
	    
		   type: "GET", //rest Type
		    dataType: 'json', //mispelled
		    url: "../invtsimis/getResUnitmapId?resunitId="+resunitMapId,
		    async: false,
		    contentType: "application/json; charset=utf-8",
		 
	      success: function (obj) {
	   
	    	  console.log(obj);

	    	  //alert("obj"+obj.circleId);

	    	  $('#unitId').val(obj.unitId); 
	    		
	    	// $('#circleId').val(obj.circleId);
	    	 
	    	 $('#hiddencircleId').val(obj.circleId);
	    	 
	    	 
	    	
	    	// $('#divisionId').val(obj.divisionId); 
	    	 $('#hiddendivisionId').val(obj.divisionId);
	    	 $('#hiddensubdivisionId').val(obj.subdivisionId);
	    	// $('#subdivisionId').val(obj.subdivisionId); 
	    	 $('#hiddenprojectId').val(obj.projectId);
	    	 //$('#projectId').val(obj.projectId);  
	    	 $('#hiddenpackageId').val(obj.packageId);  
	    	 $('#hiddenreservoirId').val(obj.reservoirId);
	    	 $('#reservoirId').val(obj.reservoirId);
	    	 $('#workinspectorno').val(obj.workinspectorno); 
	    	 
	    	 $('#luscurno').val(obj.luscurno); 
	    	 
	    	 $('#resunitmapid').val(obj.resunitmapid); 
	    	// alert(obj.remarks);
	    	 $('#remarks').val(obj.remarks); 
	    	 
	    	
	    	 
	    
	    	 $("#unitId").multiselect("refresh");
	    	 
	    
	    	 
	    	 var myres= $("#reservoirId").val();
	    	
	    	//alert("myres"+myres);
	    	
	   	 $("#reservoirId").multiselect("refresh");
	    	
	    		
	 		var myunit= parseInt($("#unitId").val()); 
	 		var mycir= parseInt($("#hiddencircleId").val());
	 		var mydiv= parseInt($("#hiddendivisionId").val());
	 		var myproj=parseInt($("#hiddenprojectId").val());
	 		var mypack=parseInt($("#hiddenpackageId").val());
	 		//alert("mcircle"+mycir);
	 		
	 		//alert("mydiv"+mydiv);
	 		if(myunit!=null && myunit>0){
	 		//	alert("myunitcoming here"+myunit);
	 			getCircles(myunit,1);	
	 			getProjects(myunit,1);
	 			getresunitlistmapData(myunit);
	 			
	 			
	 			
	 			var m=mycir;
	 			if(m!=null && m>0){
	 				
	 				getDivisions(m,1);
	 				
	 					
	 				var n=mydiv;
	 				if(n!=null && n>0){
	 					
	 					getSubDivisions(n,1);
	 					
	 					
	 				}
	 				
	 				
	 				
	 			}
	 			
	 			var q=myproj;
	 			
if(q!=null && q>0){
	 				
	 				getPackages(q);
	 				
	 			
	 			}
 			
	 		}
	 		
	 		
	    	 
	    	 
	    	 
	    	 
	    	 
	    	 
	    	
	    	 
	    	 

	      },
	      error : function(){
	    	 alert(error);
	    //  $('#action_paraalert').dialog('open');
	      }
	  }); 	
	 
	 
	 
	 $('#viewresjuris-dailogue').dialog('close');
	 
	
		
	
	   $('#assignres-dialogue').dialog('option', 'title', 'Edit Assign Reservoir ');
	   
	   
		
	
	  $('#submtReservoir').text('EditAssignReservoir');
	  $('#assignres-dialogue').dialog('open');
	  
	 
 
	
	
	
}


function getResRegList(resCode,hkey) {
	//alert("kal"+resCode);
	//var districtId=document.getElementById("districtId").value;
	
	//alert("petId"+petId);	
		//document.getElementById("divisionId").value;
	//alert(mandalId);

	$.ajax({
		url : "../invtsimis/resRegList?resCode="+resCode ,
		type : "GET",
		success : function(response) {
			
		//	alert("here"+response);
		
		if(hkey==1){

			var $select = $('#regulatorCode');
			
			var selectedReggateId=$('#hiddenregCode').val();
			
			
		}
		if(hkey==2){
			
			var $select = $('#resRegulatorCode');
			
			var selectedRegId=$('#hiddenayacutregcode').val();
			
		}
			$select.find('option').remove();
            
			
		//	console.log(response);
			
			var obj = JSON.parse(response);
		  // alert(obj.petitionerId);

		//	
		

			$.each(obj, function(key, value) {
				if(hkey==1){
					
					if(selectedReggateId==value.regulatorCode){
				$('#regulatorCode').append(
						'<option value="'+value.regulatorCode+'" selected="selected" > '
								+ value.regulatorName + '</option>');}
					
					if(selectedReggateId==null || selectedReggateId!=value.regulatorCode){
						$('#regulatorCode').append(
								'<option value="'+value.regulatorCode+'" > '
										+ value.regulatorName + '</option>');}

				$('#regulatorCode').multiselect('rebuild');
				}
				
				if(hkey==2){
					
					if(selectedRegId==value.regulatorCode){
					$('#resRegulatorCode').append(
							'<option value="'+value.regulatorCode+'" selected="selected" > '
									+ value.regulatorName + '</option>');
					}
					if(selectedRegId==null || selectedRegId!=value.regulatorCode){
						$('#resRegulatorCode').append(
								'<option value="'+value.regulatorCode+'" > '
										+ value.regulatorName + '</option>');
						
					}

					$('#resRegulatorCode').multiselect('rebuild');
					}
				
			});

		},
		error : function() {
			alert(error);
		}
	});
}

function resGatemapByResCode(rescode){
	
	
	
	$('#cusgatehead').remove();
	  $.ajax({	          
	      url: "../invtsimis/resGateList?resCode="+rescode,
	      method:"GET",
	      async: false,
	      cashe:false,
	     
		 
	      success: function (response) {
	    	  
	    	//  alert(response);
	    	  
	    	//  console.log(response);
	   
	    	  $("#gatedata").empty(); 
	    	  
	    	
	    	  
	    	  
	    	 
	     	//  console.log(response);
	     	  
	     	  var table1 = $("#gate-data tbody");
	     	  
	     	 var table2 = $("#gate-data thead");
	     	  
	     	
	     	  
	     	  if(response!=null){
	     	
	           var obj = JSON.parse(response);
	           
	        //   $("#deletealert").html("Note : Gist of the para Can not be Edited or Deleted Once the subpara is entered"); 
	           
	          
	         //	console.log(obj);
	         	
	          table2.append( 
	         			
	         			'<tr id="cusgatehead"><th colspan="5"  style="text-align: center;color:maroon"><b>Reservoir Name</b> </th><th colspan="5"  style="text-align: center;color:maroon"><b>'+obj[0].resName+'</b> </th></tr>'); 
	         	
	         	for(var m in obj ){
	         
	         	
	         	table1.append( 
	         			
	         			
	         			'<tr>'+    			
	         			
	         			
	         			'<td style="text-align: center;"><b>'+obj[m].regulatorName+'</b> </td>'+ 
	         			'<td style="text-align: center;"><b>'+obj[m].gateNo+'</b> </td>'+
	         			'<td style="text-align: center;"><b>'+obj[m].gateType+'</b> </td>'+ 
	         			'<td style="text-align: center;"><b>'+obj[m].gateSize+'</b></td>'+
	         			'<td style="text-align: center;"><b>'+obj[m].gateDischarge+'</b></td>'+
	         			'<td style="text-align: center;"><b>'+obj[m].gateSillLevel+'</b></td>'+
	         			'<td style="text-align: center;"><b>'+obj[m].gateTopLevel+'</b></td>'+
	         			'<td style="text-align: center;"><b>'+obj[m].gateSystem+'</b></td>'+ 
	         			'<td style="text-align: center;"><b>'+obj[m].gateWeight+'</b></td>'+ 
	         			'<td style="text-align: center;"><b>'+obj[m].gateHoistMotor+'</b></td>'+ 
	         			
		         			
	         			/* '<td style="text-align: center;"><b><button type="button" class="btn btn-primary "  onclick="editresjuris('+obj[m].resunitmapid+')"  >Edit </button></b></td>'+
	         			'<td style="text-align: center;"><b><button type="button" class="btn btn-primary "  onclick="deleteresjuris('+obj[m].resunitmapid+')"  >Delete </button></b></td>'+
	         			 */
	         			
	         				/*  <input type="hidden" class=" form-control "  id="reservoirId" name="resrervoirId" readonly="readonly" required value="'+obj[m].resName+'" /> */
	         				// (k < 1 ? '<td style="text-align: center;"><b> <button type="button" class="btn btn-primary "  onclick="editparagist('+obj[m].cagGistId+')"  >Edit</button></b></td>':'<td>Sub Paras Exist</td>')+
	         				// (k < 1 ?'<td style="text-align: center;color: red; "><b><button type="button" id="addPara"  class="btn btn-danger"  onclick="deleteGist('+obj[m].cagGistId+',\''+obj[m].financialYear+'\')"  >Delete Gist Para</button></b></td>' :'<td>Sub Paras Exist</td>')+    
	         				
	         				'</tr>');
	         	   
	         	  
	         	}
	          
	         	 // alert(response);
	         	
	         	
	     	  }
	                    
			  

	      },
	      
	      error : function(){
	    	 alert(error);
	    
	      }

	  
	  }); 	
	
}

function resGateviewByResCode(rescode){
	
	
	
	$('#viewgatehead').remove();
	  $.ajax({	          
	      url: "../invtsimis/resGateList?resCode="+rescode,
	      method:"GET",
	      async: false,
	      cashe:false,
	     
		 
	      success: function (response) {
	    	  
	    	//  alert(response);
	    	  
	    	//  console.log(response);
	   
	    	  $("#viewgateinfo").empty(); 
	    	  
	    	
	    	  
	    	  
	    	 
	     	//  console.log(response);
	     	  
	     	  var table1 = $("#viewgateinfo-data tbody");
	     	  
	     	 var table2 = $("#viewgateinfo-data thead");
	     	  
	     	
	     	  
	     	  if(response!=null){
	     	
	           var obj = JSON.parse(response);
	           
	        //   $("#deletealert").html("Note : Gist of the para Can not be Edited or Deleted Once the subpara is entered"); 
	           
	          
	         //	console.log(obj);
	         	
	          table2.append( 
	         			
	         			'<tr id="viewgatehead"><th colspan="5"  style="text-align: center;color:maroon"><b>Reservoir Name</b> </th><th colspan="5"  style="text-align: center;color:maroon"><b>'+obj[0].resName+'</b> </th></tr>'); 
	         	
	         	for(var m in obj ){
	         
	         	
	         	table1.append( 
	         			
	         			
	         			'<tr>'+    			
	         			
	         			
	         			'<td style="text-align: center;"><b>'+obj[m].regulatorName+'</b> </td>'+ 
	         			'<td style="text-align: center;"><b>'+obj[m].gateNo+'</b> </td>'+
	         			'<td style="text-align: center;"><b>'+obj[m].gateType+'</b> </td>'+ 
	         			'<td style="text-align: center;"><b>'+obj[m].gateSize+'</b></td>'+
	         			'<td style="text-align: center;"><b>'+obj[m].gateDischarge+'</b></td>'+
	         			'<td style="text-align: center;"><b>'+obj[m].gateSillLevel+'</b></td>'+
	         			'<td style="text-align: center;"><b>'+obj[m].gateTopLevel+'</b></td>'+
	         			'<td style="text-align: center;"><b>'+obj[m].gateSystem+'</b></td>'+ 
	         			'<td style="text-align: center;"><b>'+obj[m].gateWeight+'</b></td>'+ 
	         			'<td style="text-align: center;"><b>'+obj[m].gateHoistMotor+'</b></td>'+ 
	         			
		         			
	         			 '<td style="text-align: center;"><b><button type="button" class="btn btn-primary "  onclick="editresgateinfo('+obj[m].reservoirGateId+')"  >Edit </button></b></td>'+
	         			'<td style="text-align: center;"><b><button type="button" class="btn btn-primary "  onclick="deleteresgateinfo('+obj[m].reservoirGateId+',\'' + obj[m].resCode + '\')"  >Delete </button></b></td>'+
	         			 
	         			
	         				/*  <input type="hidden" class=" form-control "  id="reservoirId" name="resrervoirId" readonly="readonly" required value="'+obj[m].resName+'" /> */
	         				// (k < 1 ? '<td style="text-align: center;"><b> <button type="button" class="btn btn-primary "  onclick="editparagist('+obj[m].cagGistId+')"  >Edit</button></b></td>':'<td>Sub Paras Exist</td>')+
	         				// (k < 1 ?'<td style="text-align: center;color: red; "><b><button type="button" id="addPara"  class="btn btn-danger"  onclick="deleteGist('+obj[m].cagGistId+',\''+obj[m].financialYear+'\')"  >Delete Gist Para</button></b></td>' :'<td>Sub Paras Exist</td>')+    
	         				
	         				'</tr>');
	         	   
	         	  
	         	}
	          
	         	 // alert(response);
	         	
	         	
	     	  }
	                    
			  

	      },
	      
	      error : function(){
	    	 alert(error);
	    
	      }

	  
	  }); 	
	
}

function getResRegAyacutByResCode(rescode){
	
	
	
	$('#cusregayacuthead').remove();
	  $.ajax({	          
	      url: "../invtsimis/resregayacutList?resCode="+rescode,
	      method:"GET",
	      async: false,
	      cashe:false,
	     
		 
	      success: function (response) {
	    	  
	    	//  alert(response);
	    	  
	    	//  console.log(response);
	   
	    	  $("#regayacutdata").empty(); 
	    	  
	    	
	    	  
	    	  
	    	 
	     	//  console.log(response);
	     	  
	     	  var table1 = $("#regayacut-data tbody");
	     	  
	     	 var table2 = $("#regayacut-data thead");
	     	  
	     	
	     	  
	     	  if(response!=null){
	     	
	           var obj = JSON.parse(response);
	           
	        //   $("#deletealert").html("Note : Gist of the para Can not be Edited or Deleted Once the subpara is entered"); 
	           
	          
	         //	console.log(obj);
	         	
	          table2.append( 
	         			
	         			'<tr id="cusregayacuthead"><th colspan="1"  style="text-align: center;color:maroon"><b>Reservoir Name</b> </th><th colspan="1"  style="text-align: center;color:maroon"><b>'+obj[0].resName+'</b> </th></tr>'); 
	         	
	         	for(var m in obj ){
	         
	         	
	         	table1.append( 
	         			
	         			
	         			'<tr>'+    			
	         			
	         			
	         			'<td style="text-align: center;"><b>'+obj[m].resRegulatorName+'</b> </td>'+ 
	         			'<td style="text-align: center;"><b>'+obj[m].ayacutContemplated+'</b> </td>'+
	         			
	         			
		         			
	         			/* '<td style="text-align: center;"><b><button type="button" class="btn btn-primary "  onclick="editresjuris('+obj[m].resunitmapid+')"  >Edit </button></b></td>'+
	         			'<td style="text-align: center;"><b><button type="button" class="btn btn-primary "  onclick="deleteresjuris('+obj[m].resunitmapid+')"  >Delete </button></b></td>'+
	         			 */
	         			
	         				/*  <input type="hidden" class=" form-control "  id="reservoirId" name="resrervoirId" readonly="readonly" required value="'+obj[m].resName+'" /> */
	         				// (k < 1 ? '<td style="text-align: center;"><b> <button type="button" class="btn btn-primary "  onclick="editparagist('+obj[m].cagGistId+')"  >Edit</button></b></td>':'<td>Sub Paras Exist</td>')+
	         				// (k < 1 ?'<td style="text-align: center;color: red; "><b><button type="button" id="addPara"  class="btn btn-danger"  onclick="deleteGist('+obj[m].cagGistId+',\''+obj[m].financialYear+'\')"  >Delete Gist Para</button></b></td>' :'<td>Sub Paras Exist</td>')+    
	         				
	         				'</tr>');
	         	   
	         	  
	         	}
	          
	         	 // alert(response);
	         	
	         	
	     	  }
	                    
			  

	      },
	      
	      error : function(){
	    	 alert(error);
	    
	      }

	  
	  }); 	
	
}

function getViewRegAyacutByResCode(rescode){
	
	
	
	$('#cusviewayacuthead').remove();
	  $.ajax({	          
	      url: "../invtsimis/resregayacutList?resCode="+rescode,
	      method:"GET",
	      async: false,
	      cashe:false,
	     
		 
	      success: function (response) {
	    	  
	    	//  alert(response);
	    	  
	    	//  console.log(response);
	   
	    	  $("#viewayacutinfo").empty(); 
	    	  
	    	
	    	  
	    	  
	    	 
	     	//  console.log(response);
	     	  
	     	  var table1 = $("#viewayacutinfo-data tbody");
	     	  
	     	 var table2 = $("#viewayacutinfo-data thead");
	     	  
	     	
	     	  
	     	  if(response!=null){
	     	
	           var obj = JSON.parse(response);
	           
	        //   $("#deletealert").html("Note : Gist of the para Can not be Edited or Deleted Once the subpara is entered"); 
	           
	          
	         //	console.log(obj);
	         	
	          table2.append( 
	         			
	         			'<tr id="cusviewayacuthead"><th colspan="2"  style="text-align: center;color:maroon"><b>Reservoir Name</b> </th><th colspan="2"  style="text-align: center;color:maroon"><b>'+obj[0].resName+'</b> </th></tr>'); 
	         	
	         	for(var m in obj ){
	         
	         	
	         	table1.append( 
	         			
	         			
	         			'<tr>'+    			
	         			
	         			
	         			'<td style="text-align: center;"><b>'+obj[m].resRegulatorName+'</b> </td>'+ 
	         			'<td style="text-align: center;"><b>'+obj[m].ayacutContemplated+'</b> </td>'+
	         			
	         			
		         			
	         			 '<td style="text-align: center;"><b><button type="button" class="btn btn-primary "  onclick="editayacutinfo('+obj[m].resAyacutId+')"  >Edit </button></b></td>'+
	         			'<td style="text-align: center;"><b><button type="button" class="btn btn-primary "  onclick="deleteayacutinfo('+obj[m].resAyacutId+',\''+obj[m].resCode+'\')"  >Delete </button></b></td>'+
	         			 
	         			
	         				/*  <input type="hidden" class=" form-control "  id="reservoirId" name="resrervoirId" readonly="readonly" required value="'+obj[m].resName+'" /> */
	         				// (k < 1 ? '<td style="text-align: center;"><b> <button type="button" class="btn btn-primary "  onclick="editparagist('+obj[m].cagGistId+')"  >Edit</button></b></td>':'<td>Sub Paras Exist</td>')+
	         				// (k < 1 ?'<td style="text-align: center;color: red; "><b><button type="button" id="addPara"  class="btn btn-danger"  onclick="deleteGist('+obj[m].cagGistId+',\''+obj[m].financialYear+'\')"  >Delete Gist Para</button></b></td>' :'<td>Sub Paras Exist</td>')+    
	         				
	         				'</tr>');
	         	   
	         	  
	         	}
	          
	         	 // alert(response);
	         	
	         	
	     	  }
	                    
			  

	      },
	      
	      error : function(){
	    	 alert(error);
	    
	      }

	  
	  }); 	
	
}

function editresgateinfo(reggateId){
	
	//alert("coming here"+reggateId)
	//var val=input;
	//alert("kal"+resCode);	
	 $.ajax({       
	    
		   type: "GET", //rest Type
		    dataType: 'json', //mispelled
		    url: "../invtsimis/getResGatebyId?reggateId="+reggateId,
		    async: false,
		    contentType: "application/json; charset=utf-8",
		 
	      success: function (obj) {
	   
	    	  console.log(obj);

	 

	    	  $('#gatereservoirId').val(obj.gatereservoirId); 
	    		
	    
	    	 $('#hiddenregCode').val(obj.regulatorCode);
	    	 
	    	 
	    	
	    	
	    	 $('#gateNo').val(obj.gateNo);
	    	 $('#gateTypeId').val(obj.gateTypeId);
	    	 $('#gateSize').val(obj.gateSize);
	    	 $('#gateDischarge').val(obj.gateDischarge);
	    	 $('#gateSillLevel').val(obj.gateSillLevel);
	    	 $('#gateTopLevel').val(obj.gateTopLevel);
	    	 $('#gateSystemId').val(obj.gateSystemId);
	    	 $('#gateWeight').val(obj.gateWeight);
	    	 $('#gateHoistMotor').val(obj.gateHoistMotor);
	    	 
	    	 $('#reservoirGateId').val(obj.reservoirGateId);
	    	 
	    	 
	    	
	    	 
	    
	    	 $("#gatereservoirId").multiselect("refresh");

	    	 $("#regulatorCode").multiselect("refresh");
	    	 
	    	 $("#gateTypeId").multiselect("refresh");
	    	 
	    	 $("#gateSystemId").multiselect("refresh");
	    	 
	    
	    	 
	    	 var myres= $("#gatereservoirId").val();
	    	
	    	//alert("myres"+myres);
	    	
	   	 
	    	
	    		
	 		
	 		//alert("mcircle"+mycir);
	 		
	 		//alert("mydiv"+mydiv);
	 		if(myres!=null ){
	 			
	 			getResRegList(myres,1);
	 			
	 			resGatemapByResCode(myres);
	 		
	 			//getresunitlistmapData(myres);
	 			
	 			
	 			
	 			
 			
	 		}
	 		
	 		
	    	 
	    	 
	    	 
	    	 
	    	 
	    	 
	    	
	    	 
	    	 

	      },
	      error : function(){
	    	 alert(error);
	    //  $('#action_paraalert').dialog('open');
	      }
	  }); 	
	 
	 
	 
     $('#viewgateinfo-dailogue').dialog('close');
	 
	
		
	
	   $('#gate-dailogue').dialog('option', 'title', 'Edit Gates Info ');
	   
	   
		
	
	  $('#addgatesinfo').text('EditGatesInfo');
	  $('#gate-dailogue').dialog('open');
	  
	 
	
	
}

function editayacutinfo(regayacutId){
	
	

	//alert("coming here"+regayacutId)
	//var val=input;
	//alert("kal"+resCode);	
	 $.ajax({       
	    
		   type: "GET", //rest Type
		    dataType: 'json', //mispelled
		    url: "../invtsimis/getResAyacutbyId?regayacutId="+regayacutId,
		    async: false,
		    contentType: "application/json; charset=utf-8",
		 
	      success: function (obj) {
	   
	    	  console.log(obj);

	 

	    	  $('#ayacutreservoirId').val(obj.ayacutreservoirId); 
	    		
	    
	    	 $('#hiddenayacutregcode').val(obj.resRegulatorCode);
	    	 
	    	 
	    	
	    	
	    	 $('#ayacutContemplated').val(obj.ayacutContemplated);
	    	 
	    	 $('#resAyacutId').val(obj.resAyacutId);
	    	 
	    	 
	    	
	    	 
	    
	    	 $("#ayacutreservoirId").multiselect("refresh");

	    	 $("#resRegulatorCode").multiselect("refresh");
	    	 
	    
	    	 
	    	 var myres= $("#ayacutreservoirId").val();
	    	
	    	//alert("myres"+myres);
	    	
	   	 $("#resRegulatorCode").multiselect("refresh");
	    	
	    		
	 		
	 		//alert("mcircle"+mycir);
	 		
	 		//alert("mydiv"+mydiv);
	 		if(myres!=null ){
	 			

	 			getResRegList(myres,2);
	 			
	 			getResRegAyacutByResCode(myres);
	 		
	 			//getresunitlistmapData(myres);
	 			
	 			
	 			
	 			
 			
	 		}
	 		
	 		
	    	 
	    	 
	    	 
	    	 
	    	 
	    	 
	    	
	    	 
	    	 

	      },
	      error : function(){
	    	 alert(error);
	    //  $('#action_paraalert').dialog('open');
	      }
	  }); 	
	 
	 
	 
      $('#viewayacutinfo-dailogue').dialog('close');
	 
	
		
	
	   $('#ayacut-dailogue').dialog('option', 'title', 'Edit Ayacut Info ');
	   
	   
		
	
	  $('#addayacutinfo').text('EditAyacutInfo');
	  $('#ayacut-dailogue').dialog('open');
	  
	 
 
	
	
	
}


function deleteresgateinfo(input,resCode){
	
	//alert("coming here"+input)
	var val=input;
	//alert("kal"+resCode);	
	 $.ajax({       
	    
		   type: "POST", //rest Type
		    dataType: 'json', //mispelled
		    url: "../invtsimis/deleteResGatebyId?reservoirGateId="+val,
		    async: false,
		    contentType: "application/json; charset=utf-8",
		 
	      success: function (obj) {
	   
	    	  console.log(obj);
	    	
	    	 // var obj = JSON.parse(response);
	    	  
		    	 if(obj>0){
		    		 
		    		 resGateviewByResCode(resCode)
				    	
			    // $('#viewgateinfo-dailogue').dialog('close'); 
			 
			  $('#action_alert').html('<p>Ayacut Info Deleted Successfully</p>');
			    }
			    if(obj==0){
			    	
			    	 $('#viewgateinfo-dailogue').dialog('close'); 
			    	
			    	  $('#action_alert').html('<p>Failed to Update data</p>');
			    }
		    	 
	    	 
	    	 
	    	 

	      },
	      error : function(){
	    	 alert(error);
	    //  $('#action_paraalert').dialog('open');
	      }
	  }); 	
	 
	  
	 

}



function deleteayacutinfo(input,resCode){
	
	//alert("coming here"+input)
	var val=input;
	//alert("kal"+resCode);	
	 $.ajax({       
	    
		   type: "POST", //rest Type
		    dataType: 'json', //mispelled
		    url: "../invtsimis/deleteResAyacutbyId?resAyacutId="+val,
		    async: false,
		    contentType: "application/json; charset=utf-8",
		 
	      success: function (obj) {
	   
	    	//  console.log(obj);
	    	
	    	 // var obj = JSON.parse(response);
	    	  
		    	 if(obj>0){
				    	
			    	// $('#viewayacutinfo-dailogue').dialog('close'); 
			 
			  $('#action_alert').html('<p>Ayacut Info Deleted Successfully</p>');
			    }
			    if(obj==0){
			    	
			    	  $('#action_alert').html('<p>Failed to Update data</p>');
			    }
		    	 
			    getViewRegAyacutByResCode(resCode);
	    	 
	    	 

	      },
	      error : function(){
	    	 alert(error);
	    //  $('#action_paraalert').dialog('open');
	      }
	  }); 	
	 
	  
	 

}
 
function autoRefresh() {
    window.location.reload();
}

	
</script>




<script>
	

	

	$(function() {
		
	
		 $('#addresjuris').click(function(){
				
			  $('#assignres-dialogue').dialog('option', 'title', 'Assign Reservoir');
			  $('#assignres-dialogue').dialog('open');
			  
			  $('#assinresid').trigger("reset"); 
			 });
		 
		 $('#addresinfo').click(function(){
				
			 $('#res_dialogue').dialog('option', 'title', 'Add Reservoir');
			  $('#res_dialogue').dialog('open');
			  
			  $('#reservoirformid').trigger("reset"); 
			 });
		
		
		
		 $('#pack_dialogue').dialog({
			  autoOpen:false,
			  width:400,
			  close: function() {
				  
				//  $("#pack_dialogue").empty();
				 
				  $(this).dialog("close");
				  }
			  
			 });
		 
		 $('#res_dialogue').dialog({
			  autoOpen:false,
			  width:1200,
			  close: function() {
				  
					//  $("#pack_dialogue").empty();
					 
					  $(this).dialog("close");
					  }
			 });
		 
		 $('#gate-dailogue').dialog({
			  autoOpen:false,
			  width:1200,
			  close: function() {
				  
					//  $("#pack_dialogue").empty();
					  autoRefresh(); 
					  $(this).dialog("close");
					  }
			 });
		 
		 $('#viewresinfo-dailogue').dialog({
			  autoOpen:false,
			  width:1200,
			  close: function() {
				  
					//  $("#pack_dialogue").empty();
					
					  $(this).dialog("close");
					  }
			 });
		 
		 $('#editresdata-dailogue').dialog({
			  autoOpen:false,
			  width:1200
			 });
		 
		 
		 $('#assignres-dialogue').dialog({
			  autoOpen:false,
			  width:1200,
			  close: function() {
				  
					//  $("#pack_dialogue").empty();
					  autoRefresh(); 
					  $(this).dialog("close");
					  }
			 });
		 
		 $('#viewresjuris-dailogue').dialog({
			  autoOpen:false,
			  width:1200,
			  close: function() {
				  
					//  $("#pack_dialogue").empty();
					
					  $(this).dialog("close");
					  }
			  
			 });
		 
		 $('#ayacut-dailogue').dialog({
			  autoOpen:false,
			  width:1200,
			  close: function() {
				  
					//  $("#pack_dialogue").empty();
					  autoRefresh(); 
					  $(this).dialog("close");
					  }
			 });
		 
		 $('#reg_dialogue').dialog({
			  autoOpen:false,
			  width:1200
			 });
		 
		 $('#viewgateinfo-dailogue').dialog({
			  autoOpen:false,
			  width:1200,
			  close: function() {
				  
					//  $("#pack_dialogue").empty();
					 
					  $(this).dialog("close");
					  }
			 });
		 
		 $('#viewayacutinfo-dailogue').dialog({
			  autoOpen:false,
			  width:1200,
			  close: function() {
				  
					//  $("#pack_dialogue").empty();
					
					  $(this).dialog("close");
					  }
			 });
		 
		
		 $('#viewayacut').click(function(){
			 
			
				
			  $('#viewayacutinfo-dailogue').dialog('option', 'title', 'View Ayacut Info');
			  $('#viewayacutinfo-dailogue').dialog('open');
			  
			
			 });
		 
		 $('#viewgates').click(function(){
			 
				
				
			  $('#viewgateinfo-dailogue').dialog('option', 'title', 'View Gates Info');
			  $('#viewgateinfo-dailogue').dialog('open');
			 });
		 
		 $('#addnewreg').click(function(){
			 
			
				
			  $('#reg_dialogue').dialog('option', 'title', 'Add Regulator');
			  $('#reg_dialogue').dialog('open');
			 });
		 
		 
		 
		 $('#viewresinfo').click(function(){
			 
			
				
			  $('#viewresinfo-dailogue').dialog('option', 'title', 'Edit');
			  $('#viewresinfo-dailogue').dialog('open');
			 });
		 
		 $('#editresjuris').click(function(){
			
			 
			  $('#viewresjuris-dailogue').dialog('option', 'title', 'Edit Reservoir Jurisdiction');
			  $('#viewresjuris-dailogue').dialog('open');
			 });
		 
		
		
		
		
		
		 $('#addnewpack').click(function(){
				
			  $('#pack_dialogue').dialog('option', 'title', 'Add Package');
			  $('#pack_dialogue').dialog('open');
			 });
		 
		 $('#assignres').click(function(){
				
			  $('#res_dialogue').dialog('option', 'title', 'Add Reservoir');
			  $('#res_dialogue').dialog('open');
			 });
		 
		 $('#addgates').click(function(){
			 $('#gateformid').trigger("reset"); 
			  $('#gate-dailogue').dialog('option', 'title', 'Add Gates');
			  $('#gate-dailogue').dialog('open');
			 });
		 
		 $('#addayacut').click(function(){
			 
			 $('#resayacutformid').trigger("reset"); 
			 
			 
				
			  $('#ayacut-dailogue').dialog('option', 'title', 'Add Ayacut');
			  $('#ayacut-dailogue').dialog('open');
			 });
		 
		 
		 
		  
		
		 
		 
		 
		 
		 $('#addreg').click(function(){
			 
				// alert("kal1");
				 
				 $('#action_alert').empty();
				 
			var regName= $('#regulatorName').val(); 
			var regId=$('#regulatorId').val(); 
			var regreservoirId=$('#regreservoirId').val(); 
			

			//alert(finyear+"kals"+actionTitle+"kala"+ paraNumber+"kalr"+cagGistId);

			  $.ajax({	          
			      url: "../invtsimis/addresReg",
			      method:"POST",
			      async: false,
			      data: {
			    	  regulatorName: regName,
			    	  regulatorId :regId,
			    	  regreservoirId :regreservoirId
			    	
			    	  
			      },
			     
				 
			      success: function (response) {
			   
			    	// alert("kal"+response);
			    	 
			    	 if(response>0){
					    	
				    	 $('#reg_dialogue').dialog('close'); 
				 
				  $('#action_alert').html('<p>Data Updated Successfully</p>');
				    }
				    if(response==0){
				    	
				    	  $('#action_alert').html('<p>Failed to Update data</p>');
				    }
			    	 
			    	 //  alert(finYear);
					    getResRegList(regreservoirId,1);
					    
					    
					  //  $('#action_alert').dialog('open'); 
					  
					   // getunitData(unitId,circleId,divisionId) ;
					  

			      },
			      
			      error : function(){
			    	 alert(error);
			    
			      }

			  
			  }); 	
	
	});
		 
		 
		 $('#addpack').click(function(){
			 
				// alert("kal1");
				 
				 $('#action_alert').empty();
				 
			var pkgName= $('#dipackpkgName').val(); 
			var unitId=$('#dipackunitId').val(); 
			var circleId=$('#dipackcircleId').val(); 
			var divisionId=$('#dipackdivisionId').val();
			var projectId=$('#dipackprojectId').val();

			//alert(finyear+"kals"+actionTitle+"kala"+ paraNumber+"kalr"+cagGistId);

			  $.ajax({	          
			      url: "../web/addPack",
			      method:"POST",
			      async: false,
			      data: {
			    	  pkgName: pkgName,
			    	  unitId :unitId,
			    	  circleId :circleId,
			    	  divisionId:divisionId,
			    	  projectId:projectId
			    	  
			      },
			     
				 
			      success: function (response) {
			   
			    	// alert("kal"+response);
			    	 
			    	 if(response>0){
					    	
				    	 $('#pack_dialogue').dialog('close'); 
				 
				  $('#action_alert').html('<p>Data Updated Successfully</p>');
				    }
				    if(response==0){
				    	
				    	  $('#action_alert').html('<p>Failed to Update data</p>');
				    }
			    	 
			    	 //  alert(finYear);
					    getPackages(projectId);
					    
					    
					  //  $('#action_alert').dialog('open'); 
					  
					   // getunitData(unitId,circleId,divisionId) ;
					  

			      },
			      
			      error : function(){
			    	 alert(error);
			    
			      }

			  
			  }); 	
	
	});
		 
		 
		 $('#addres').click(function(e){
			 
				// alert("kal1");
				
				 // alert("kal1");
				 var n= $('#addres').text() ;
				 
				 
				// alert("text"+n);
				 
				 $('#action_alert').empty();
				 
				 e.preventDefault(); //=== To Avoid Page Refresh and Fire the Event "Click"===
					 
				 if(n=='AddReservoir'){
				  if ( $('form[name=reservoirform]').parsley().isValid() ) {
					  
					//  alert("kal2");

			  $.ajax({	          
			      url: "../invtsimis/addReservoir",
			      method:"POST",
			      async: false,
			      data:$('form[name=reservoirform]').serialize(),
			     
				 
			      success: function (response) {
			   
			    	//alert("kal"+response);
			    	 
			    	 if(response!=null){
					    	
				    	 $('#res_dialogue').dialog('close'); 
				    	 
				    	 getResList(response);
				 
				  $('#action_alert').html('<p>Data Updated Successfully</p>');
				    }
				    if(response==null){
				    	
				    	  $('#action_alert').html('<p>Failed to Update data</p>');
				    }
			    	 
			    	 //  alert(finYear);
					  
					    
					    
					  //  $('#action_alert').dialog('open'); 
					  
					   // getunitData(unitId,circleId,divisionId) ;
					  

			      },
			      
			      error : function(){
			    	 alert(error);
			    
			      }

			  
			  }); 	
				 
				  }
				
				 }
				 
//			 alert("text"+n);
				 
				 if(n=='EditReservoirInfo'){
					  if ( $('form[name=reservoirform]').parsley().isValid() ) {
						  
						 // alert("kal2");

				  $.ajax({	          
				      url: "../invtsimis/editResinfodata",
				      method:"POST",
				      async: false,
				      data:$('form[name=reservoirform]').serialize(),
				     
					 
				      success: function (response) {
				   
				    	//alert("kal"+response);
				    	 
				    	 if(response!=null){
						    	
					    	 $('#res_dialogue').dialog('close'); 
					    	 
					    	  $('#viewresinfo-dailogue').dialog('open');
					    	  
					    	//  alert("kal34");
					    		 $('#inforeservoirId').val(response); 
					    	  
					    		// var resval=JSON.parse(response);
					    		// alert("resval"+resval);
					    	 
					    	 getResInfo(response);
					 
					  $('#action_alert').html('<p>Data Updated Successfully</p>');
					    }
					    if(response==null){
					    	
					    	  $('#action_alert').html('<p>Failed to Update data</p>');
					    }
				    	 
				    	 //  alert(finYear);
						  
						    
						    
						  //  $('#action_alert').dialog('open'); 
						  
						   // getunitData(unitId,circleId,divisionId) ;
						  

				      },
				      
				      error : function(){
				    	 alert(error);
				    
				      }

				  
				  }); 	
					 
					  }
					
					 }
				
	   

		
	});
		 
		 
		 
		 $('#submtReservoir').click(function(e){
			 
				// alert("kal1");
				
				 // alert("kal1");
				 
				   	 
			     	$('#unitinhead').remove(); 
			     	$('#addunithead').remove(); 
			     	
			     	 var m= $('#submtReservoir').text() ;	
				 
				 $('#action_alert').empty();
				 
				 e.preventDefault(); //=== To Avoid Page Refresh and Fire the Event "Click"===					 
					 if(m=="SubmitReservoir"){
						 
					
				  if ( $('form[name=assinresform]').parsley().isValid() ) {
					  
					// alert("kal2");

			  $.ajax({	          
			      url: "../invtsimis/submitReservoir",
			      method:"POST",
			      async: false,
			      data:$('form[name=assinresform]').serialize(),
			     
				 
			      success: function (response) {
			    	  
			    	//  alert(response);
			    	  
			    	 // console.log(response);
			   
			    	  $("#resdata").empty(); 
			    	  
			    	 
			    	  
			    	  
			    	  
			     	 // console.log(response);
			     	  
			     	  var table1 = $("#res-data tbody");
			     	  
			     	 var table3 = $("#res-data thead");
			   
			     	
			     
			     	  if(response!=null){
			     	
			           var obj = JSON.parse(response);
			           
			        //   $("#deletealert").html("Note : Gist of the para Can not be Edited or Deleted Once the subpara is entered"); 
			           
			          
			         	console.log(obj);
			         	
			         	 table3.append( 
				         			
				         			'<tr id="unitinhead"><th colspan="3" style="text-align: center; color:maroon"><b>Unit Name</b> </th><th  colspan="3"  style="text-align: center;color:maroon"><b>'+obj[0].unitName+'</b> </th></tr>'); 
			         	
			         	for(var m in obj ){
			         
			         	
			         	table1.append(       			
			         			'<tr>'+    			
			         			
			         			
			         			'<td style="text-align: center;"><b>'+obj[m].circleName+'</b> </td>'+ 
			         			'<td style="text-align: center;"><b>'+obj[m].divisionName+'</b> </td>'+
			         			'<td style="text-align: center;"><b>'+obj[m].subdivisionName+'</b> </td>'+ 
			         			'<td style="text-align: center;"><b>'+obj[m].projectName+'</b></td>'+
			         			'<td style="text-align: center;"><b>'+obj[m].packName+'</b></td>'+
			         			'<td style="text-align: center;"><b>'+obj[m].resName+'</b></td>'+
			         			
			         			'<td style="text-align: center;"><b>'+obj[m].workinspectorno+'</b></td>'+
			         			'<td style="text-align: center;"><b>'+obj[m].luscurno+'</b></td>'+
			         			
			         			'<td style="text-align: center;"><b>'+obj[m].remarks+'</b></td>'+
			         			
			         			
			         			
			         			
			         				'</tr>');
			         	   
			         	  
			         	}
			          
			         	 // alert(response);
			         	
			         	
			     	  }
			                    
					  

			      },
			      
			      error : function(){
			    	 alert(error);
			    
			      }

			  
			  }); 	
				 
				  }
				
					 }
				 
					 if(m=="EditAssignReservoir"){
						 
							
						  if ( $('form[name=assinresform]').parsley().isValid() ) {
							  
							// alert("kal2");

					  $.ajax({	          
					      url: "../invtsimis/editresunitmap",
					      method:"POST",
					      async: false,
					      data:$('form[name=assinresform]').serialize(),
					     
						 
					      success: function (response) {
					    	  
					    	//  alert(response);
					    	  
					    	 // console.log(response);
					   
					    	  $("#resdata").empty(); 
					    	  
					    	 
					    	  
					    	  
					    	  
					     	 // console.log(response);
					     	  
					     	  var table1 = $("#res-data tbody");
					     	  
					     	 var table3 = $("#res-data thead");
					   
					     	
					     
					     	  if(response!=null){
					     	
					           var obj = JSON.parse(response);
					           
					        //   $("#deletealert").html("Note : Gist of the para Can not be Edited or Deleted Once the subpara is entered"); 
					           
					          
					         	console.log(obj);
					         	
					         	 table3.append( 
						         			
						         			'<tr id="unitinhead"><th colspan="3" style="text-align: center; color:maroon"><b>Unit Name</b> </th><th  colspan="3"  style="text-align: center;color:maroon"><b>'+obj[0].unitName+'</b> </th></tr>'); 
					         	
					         	for(var m in obj ){
					         
					         	
					         	table1.append(       			
					         			'<tr>'+    			
					         			
					         			
					         			'<td style="text-align: center;"><b>'+obj[m].circleName+'</b> </td>'+ 
					         			'<td style="text-align: center;"><b>'+obj[m].divisionName+'</b> </td>'+
					         			'<td style="text-align: center;"><b>'+obj[m].subdivisionName+'</b> </td>'+ 
					         			'<td style="text-align: center;"><b>'+obj[m].projectName+'</b></td>'+
					         			'<td style="text-align: center;"><b>'+obj[m].packName+'</b></td>'+
					         			'<td style="text-align: center;"><b>'+obj[m].resName+'</b></td>'+
					         			
					         			'<td style="text-align: center;"><b>'+obj[m].workinspectorno+'</b></td>'+
					         			'<td style="text-align: center;"><b>'+obj[m].luscurno+'</b></td>'+
					         			
					         			'<td style="text-align: center;"><b>'+obj[m].remarks+'</b></td>'+
					         			
					         			
					         			
					         			
					         				'</tr>');
					         	   
					         	  
					         	}
					          
					         	 // alert(response);
					         	
					         	
					     	  }
					                    
							  

					      },
					      
					      error : function(){
					    	 alert(error);
					    
					      }

					  
					  }); 	
						 
						  }
						
							 }
				
	   

		
	});
		 
		 
		 $('#addgatesinfo').click(function(e){
			 
			// alert("kal1");
			
			 // alert("kal1");
			 var n= $('#addgatesinfo').text() ;
			 
			 
			// alert("text"+n);
			 
			 $('#action_alert').empty();
			 
			 e.preventDefault(); //=== To Avoid Page Refresh and Fire the Event "Click"===
				 
			 if(n=='AddGatesInfo'){
			  if ( $('form[name=gatesform]').parsley().isValid() ) {
				  
				//  alert("kal2");

		  $.ajax({	          
		      url: "../invtsimis/addgatesinfo",
		      method:"POST",
		      async: false,
		      data:$('form[name=gatesform]').serialize(),
		     
			 
		      success: function (response) {
		   
		    //	alert("kal"+response);
		    	 
		    	 if(response!=null){
				    	
			    	 //$('#gate-dailogue').dialog('close'); 
			    	 
			     resGatemapByResCode(response);
			 
			  $('#action_alert').html('<p>Data Updated Successfully</p>');
			    }
			    if(response==null){
			    	
			    	  $('#action_alert').html('<p>Failed to Update data</p>');
			    }
		    	 
		    	 //  alert(finYear);
				  
				    
				    
				  //  $('#action_alert').dialog('open'); 
				  
				   // getunitData(unitId,circleId,divisionId) ;
				  

		      },
		      
		      error : function(){
		    	 alert(error);
		    
		      }

		  
		  }); 	
			 
			  }
			
			 }
			 
			// alert("text"+n);
			 
			 if(n=='EditGatesInfo'){
				  if ( $('form[name=gatesform]').parsley().isValid() ) {
					  
					//  alert("kal2");

			  $.ajax({	          
			      url: "../invtsimis/updateResGatebyId",
			      method:"POST",
			      async: false,
			      data:$('form[name=gatesform]').serialize(),
			     
				 
			      success: function (response) {
			   
			    	//alert("kal"+response);
			    	 
			    	  if(response!=null){
					    	
					    	 //$('#gate-dailogue').dialog('close'); 
					    	 
					    
					 
					  $('#action_alert').html('<p>Data Updated Successfully</p>');
					    }
					   
				    if(response==null){
				    	
				    	  $('#action_alert').html('<p>Failed to Update data</p>');
				    }
			    	 
				    
				    resGatemapByResCode(response);
			    	 //  alert(finYear);
					  
					    
					    
					  //  $('#action_alert').dialog('open'); 
					  
					   // getunitData(unitId,circleId,divisionId) ;
					  

			      },
			      
			      error : function(){
			    	 alert(error);
			    
			      }

			  
			  }); 	
				 
				  }
				
				 }
			 
			
			
   

	
});
		 
$('#addayacutinfo').click(function(e){
			 
			// alert("kal1");
			
			 // alert("kal1");
			 var n= $('#addayacutinfo').text() ;
			 
			 
			// alert("text"+n);
			 
			 $('#action_alert').empty();
			 
			 e.preventDefault(); //=== To Avoid Page Refresh and Fire the Event "Click"===
				 
			 if(n=='AddAyacut'){
			  if ( $('form[name=ayacutform]').parsley().isValid() ) {
				  
				//  alert("kal2");

		  $.ajax({	          
		      url: "../invtsimis/addresAyacut",
		      method:"POST",
		      async: false,
		      data:$('form[name=ayacutform]').serialize(),
		     
			 
		      success: function (response) {
		   
		    	//alert("kal"+response);
		    	 
		    	 if(response!=null){
				    	
			    	// $('#ayacut-dailogue').dialog('close'); 
			    	 
			    
			 
			  $('#action_alert').html('<p>Data Updated Successfully</p>');
			    }
			    if(response==null){
			    	
			    	  $('#action_alert').html('<p>Failed to Update data</p>');
			    }
			    
				 getResRegAyacutByResCode(response);
		    	 
		    	 //  alert(finYear);
				  
				    
				    
				  //  $('#action_alert').dialog('open'); 
				  
				   // getunitData(unitId,circleId,divisionId) ;
				  

		      },
		      
		      error : function(){
		    	 alert(error);
		    
		      }

		  
		  }); 	
			 
			  }
			
			 }
			 
			// alert("text"+n);
			
			 if(n=='EditAyacutInfo'){
				  if ( $('form[name=ayacutform]').parsley().isValid() ) {
					  
					//  alert("kal2");

			  $.ajax({	          
			      url: "../invtsimis/updateResAyacutbyId",
			      method:"POST",
			      async: false,
			      data:$('form[name=ayacutform]').serialize(),
			     
				 
			      success: function (response) {
			   
			    	//alert("kal"+response);
			    	 
			    	 if(response!=null){
					    	
				    	// $('#ayacut-dailogue').dialog('close'); 
				    	 
				    
				 
				  $('#action_alert').html('<p>Data Updated Successfully</p>');
				    }
				    if(response==null){
				    	
				    	  $('#action_alert').html('<p>Failed to Update data</p>');
				    }
				    
					 getResRegAyacutByResCode(response);
			    	 
			    	 //  alert(finYear);
					  
					    
					    
					  //  $('#action_alert').dialog('open'); 
					  
					   // getunitData(unitId,circleId,divisionId) ;
					  

			      },
			      
			      error : function(){
			    	 alert(error);
			    
			      }

			  
			  }); 	
				 
				  }
				
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


	<div>
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

<!-- <div class="w3l-main" id="borderStyle"> -->


<div class="alert alert-primary" role="alert">
  Note:
   <br></br>
   Step1: First Add Reservoir inside  <strong>Add/View Jurisdiction</strong> then assign Reservoir to Division/SubDivision. <br></br>
  Step2: If any changes in Reservoir Info then update in <strong> View/Edit/Delete Reservoir info.</strong> <br></br>
  Step3: If any changes in Reservoir Jurisdiction then update in <strong>View/Edit/Delete Reservior Jurisdiction.</strong> <br></br>
   Step4: Add Head Regulator and Gates Information in  <strong>Add Head Regulator and Reservoir Gates.</strong> <br></br>
    Step5: If any changes in  Head Regulator and Gates Information then update in   <strong>Edit/Delete Head Regulator and Reservoir Gates.</strong> <br></br>
     Step6: Add Ayacut under Head Regulator of Reservoir in   <strong>Add Ayacut</strong> <br></br>
        Step7: If any changes in  Ayacut under Head Regulator of Reservoir information then update in   <strong>Edit/Delete Ayacut</strong> <br></br>
</div>



	<div class="panel panel-primary ">
		<div class="panel-heading">
			<h3 class="panel-title">Inventory Module: Add Reservoir</h3>
		</div>
			
		
		<div class='container'>
		
			<div id="action_alert" title="Action"></div>
		
		<div class="col-md-4">
		
	
	<div class="table-responsive ">
     <table class="table table-striped table-bordered" id="action-data">
     <thead id="actionhead">
     
    
      <tr style="color: blue; ">  
      
       
       
        <th style="text-align: center;"><b> View/Add/Edit/Delete </b></th>
 
      </tr>
      </thead>
      <tbody id="actiondata">
      
      
      
        <tr>
      <td style="text-align: center;"><input type="button" class="btn btn-1 btn-primary center-block" 	id="addresjuris" value="Add/View Reservoir Jurisdiction"> </td>
      
      </tr>
      
       <tr>
      <td style="text-align: center;"><input type="button" class="btn btn-1 btn-primary center-block" 	id="editresjuris" value="View/Edit/Delete Reservoir Jurisdiction"> </td>
      
      </tr>
      
      
       <tr>
      <td style="text-align: center;"><input type="button" class="btn btn-1 btn-primary center-block" 	id="viewresinfo" value="View/Edit/Delete Reservoir Info"> </td>
      
      </tr>
      
     
     
      
       <tr>
      <td style="text-align: center;"><input type="button" class="btn btn-1 btn-primary center-block" 	id="addgates" value="Add Head Reagulator and Reservoir gates"></td>
     
      
      
      </tr>
        <tr>
      <td style="text-align: center;"><input type="button" class="btn btn-1 btn-primary center-block" 	id="viewgates" value="Edit/Delete Head Reagulator and Reservoir gates"></td>
     
      
      
      </tr>
       <tr>
      <td style="text-align: center;"><b><input type="button" class="btn btn-1 btn-primary center-block" 	id="addayacut" value="Add Ayacut"></b> </td>
     
      
      
      </tr>
      
        <tr>
      <td style="text-align: center;"><b><input type="button" class="btn btn-1 btn-primary center-block" 	id="viewayacut" value="Edit/Delete Ayacut"></b> </td>
     
      
      
      </tr>
      
      
   
     </tbody>
     </table>
     
    </div>
    </div>
		
		
		<div class="col-md-8">
		<div id="assignres-dialogue">
		
		<div class="alert alert-primary" role="alert">
  Note: First Add Reservoir.It will appear in the Select Reservoir  and then Assign Reservoir to Jurisdiction.
</div>
		<form:form id="assinresid" method="post" modelAttribute="res"  name="assinresform"
			data-parsley-validate-if-empty="" enctype="multipart/form-data">
			




				<!-- 	<div > -->


				<div class="col-md-6">


					<br></br>


					<div class="col-md-6">
						<label class="label-controlPMS rowlebel ">Select Unit <font
							color=red>*</font>
						</label>
					</div>

					<div class="col-md-6">
						<select class="form-control" id="unitId" name="unitId"
							onchange="getProjects(this.value,1);getCircles(this.value,1);getresunitlistmapData(this.value)" required>
							<option value=" ">--select--</option>

							<c:forEach items="${unitList}" var="u">
								<option value="${u.unitId}">${u.unitName}</option>

							</c:forEach>



						</select>
					</div>




					<div class="col-md-6">
						<label class="label-control rowlebel ">Select Circle</label>
					</div>
					<div class="col-md-6">
					<input
						type="hidden" class="form-control" id="hiddencircleId"
						 placeholder=""  />
					
						<select class="form-control" id="circleId" name="circleId"
							onchange="getDivisions(this.value,1)">
							<option value="0">--select--</option>



						</select>

					</div>




					<div class="col-md-6">
						<label class="label-controlPMS rowlebel ">Select Division</label>
					</div>
					<div class="col-md-6">
					<input
						type="hidden" class="form-control" id="hiddendivisionId"
						 placeholder=""  />
						<select class="form-control" id="divisionId" name="divisionId"
							onchange="getSubDivisions(this.value,1)">
						</select>
					</div>





					<div class="col-md-6">
						<label class="label-control rowlebel ">Select SubDivision
						</label>
					</div>
					<div class="col-md-6">
					<input
						type="hidden" class="form-control" id="hiddensubdivisionId"
						 placeholder=""  />
						<select class="form-control" id="subdivisionId"
							name="subdivisionId">



						</select>

					</div>


					<div class="col-md-6">
						<label class="label-control rowlebel ">Select Project</label>
					</div>

					<div class="col-md-6">
					<input
						type="hidden" class="form-control" id="hiddenprojectId"
						 placeholder=""  />
						<select class="form-control" id="projectId" name="projectId"
							onchange="getPackages(this.value)">
						</select>
					</div>


					<div class="col-md-6">
						<label class="label-control rowlebel ">Select Package</label>
					</div>


					<div class="col-md-3">
					<input
						type="hidden" class="form-control" id="hiddenpackageId"
						 placeholder=""  />
						<select class="form-control" id="packageId" name="packageId">




						</select>


					</div>






					<div class="col-md-3">

						<input type="button" class="btn btn-1 btn-primary center-block"
							id="addnewpack" value="Add Package">

						<!-- onclick="addPack()" -->

					</div>


					<div class="col-md-6">
						<label class="label-control rowlebel ">Select Reservoir</label>
					</div>

					<div class="col-md-3">
					<input
						type="hidden" class="form-control" id="hiddenreservoirId"
						 placeholder=""  />
						<select class="form-control" id="reservoirId" name="reservoirId">
						
						<option value="">select</option>
						
						<c:forEach items="${resList}" var="u">
								<option value="${u.resCode}">${u.resName}</option>

							</c:forEach>
						</select>
					</div>
					<div class="col-md-3">

						<input type="button" class="btn btn-1 btn-primary center-block"
							id="assignres" value="Add Reservoir">

						<!-- onclick="addPack()" -->

					</div>








				</div>

				<div class="col-md-6">
					<br></br>

					
					
					<div class="col-md-6">
						<label class="label-control rowlebel ">Work Inspectors(No.)
							</label>
					</div>
					<div class="col-md-6">

						<input type="text" class="form-control" id="workinspectorno"
							name="workinspectorno" placeholder="workinspectorno" required />
					</div>
					
					<div class="col-md-6">
						<label class="label-control rowlebel ">Luscurs(No.)
							</label>
					</div>
					<div class="col-md-6">

						<input type="text" class="form-control" id="luscurno"
							name="luscurno" placeholder="luscurno" required />
					</div>






					<!-- <div class="col-md-6">
						<label class="label-controlPMS rowlebel ">Upload
							Files(Multiple)</label>
					</div>

					<div class="col-md-6">
						<input id="uploadFile" name="uploadFile" type="file"
							class="btn-info" value="Upload Documents" multiple="multiple">
					</div>
 -->







				</div>
				
				 <div class="col-md-12">
    <label class="label-control rowlebel ">Remarks*</label>
<textarea class="form-control"  id="remarks" name="remarks"  rows="5" cols="80" placeholder="Remarks"  ></textarea> 
    
   </div>

				<div class="col-sm-12">
					<div class="col-md-2 "></div>
					<div class="col-md-8 ">
						<label class="label-control rowlebel "></label>
						
						<input
						type="hidden" class="form-control" id="resunitmapid" name="resunitmapid"
						 placeholder=""  />
						
						 <button type="button" name="submtReservoir" id="submtReservoir" class="btn btn-1 btn-primary center-block" >SubmitReservoir</button>
						
					</div>
				</div>







				<!-- 	</div> -->
			
			<!-- row -->





		</form:form>
		
		
			<!-- data starts -->
	<div class="col-md-12">
	
	
    
	
	
	<div class="table-responsive ">
     <table class="table table-striped table-bordered" id="res-data">
     <thead id="reshead">
     
    
      <tr style="color: blue; ">  
      
       
        <th style="text-align: center;"><b>Circle Name</b></th>
       
        <th style="text-align: center;"><b>Division Name</b></th>
       
        <th style="text-align: center;"><b>Sub Division Name</b></th> 
        
        <th style="text-align: center;"><b>Project Name</b></th>     
         <th style="text-align: center;"><b>Package Name</b></th>     
       
       <th style="text-align: center;"><b>Reservoir Name</b></th>
       
         <th style="text-align: center;"><b>Work Inspector No.</b></th>
         
           <th style="text-align: center;"><b>Luscurs No.</b></th>
            <th style="text-align: center;"><b>Remarks</b></th>
           
             
      
   
       
      
    
      </tr>
      </thead>
      <tbody id="resdata">
   
     </tbody>
     </table>
     
    </div>
   
    </div>
    
    </div>
   
    
    
    <div id="res_dialogue">

<form:form id="reservoirformid" method="post" modelAttribute="addreservoir" name="reservoirform"
			data-parsley-validate-if-empty="" enctype="multipart/form-data">


<div class="col-md-12 invDiv" > 



<div class="col-md-12 invDivheading" >Salient features </div>
		<div class="col-md-3">
			<label class="label-control rowlebel ">Reservoir Name</label> <input
				type="text" class="form-control" id="resName" name="resName"
				placeholder="resName" required />
		</div>
		<div class="col-md-3">
			<label class="label-control rowlebel ">Water Spread Area(Acres)</label> <input
				type="text" class="form-control" id="waterSpreadArea" name="waterSpreadArea"
				placeholder="Water Spread Area"  />
		</div>
		
		<div class="col-md-3">
			<label class="label-control rowlebel ">Latitude</label> <input
				type="text" class="form-control" id="resLatitude" name="resLatitude"
				placeholder="degrees"  />
		</div>
		
		<div class="col-md-3">
			<label class="label-control rowlebel ">Longitude</label> <input
				type="text" class="form-control" id="resLongitude" name="resLongitude"
				placeholder="degrees"  />
		</div>
		
		<div class="col-md-3">
					<label class="label-control rowlebel ">Select Status</label> <select
						class="form-control" id="resStatusId" name="resStatusId" required>
                         <option value=" ">Select</option>
						<option value="1">Ongoing</option>
						<option value="2">Completed</option>
						



					</select>
				</div>
				
			
		<div class="col-md-3">
			<label class="label-control rowlebel ">Hydro Power(MW)</label> <input
				type="text" class="form-control" id="hydroPower"
				name="hydroPower" placeholder="hydroPower"  />
		</div>
		
			
		<div class="col-md-3">
			<label class="label-control rowlebel ">Land Acquisition(Acres)</label> <input
				type="text" class="form-control" id="landAcquistion"
				name="landAcquistion" placeholder="landAcquistion"  />
		</div>
		
		<div class="col-md-3">
			<label class="label-control rowlebel ">Catchment Area(Sq. Km)</label> <input
				type="text" class="form-control" id="catchmentArea"
				name="catchmentArea" placeholder="catchmentArea"  />
		</div>
		
			<div class="col-md-3">
			<label class="label-control rowlebel ">M.F.D(cumecs)</label> <input
				type="text" class="form-control" id="maxfloodDischarge"
				name="maxfloodDischarge" placeholder="maxfloodDischarge"  />
		</div>
		
		
		

		
		
		




<div class="col-md-12 invDivsubheading" > Capacity(TMC) </div>


		

		<div class="col-md-3">
			<label class="label-control rowlebel ">MWL</label> <input
				type="text" class="form-control" id="mwlCapacity" name="mwlCapacity"
				placeholder="MWL(TMC)" required />
		</div>

		<div class="col-md-3">
			<label class="label-control rowlebel ">FRL</label> <input
				type="text" class="form-control" id="frlCapacity" name="frlCapacity"
				placeholder="FRL(TMC)" required />
		</div>
		<div class="col-md-3">
			<label class="label-control rowlebel ">MDDL</label> <input
				type="text" class="form-control" id="mddlCapacity"
				name="mddlCapacity" placeholder="MDDL(TMC)" required />
		</div>
		
		
		<div class="col-md-3">
			<label class="label-control rowlebel ">Dead Storage </label> <input
				type="text" class="form-control" id="deadstorageCapacity" name="deadstorageCapacity"
				placeholder="deadstorageCapacity(TMC)"  />
		</div>
		

<div class="col-md-12 invDivsubheading" > Level(+Mt.) </div>

<div class="col-md-3">
			<label class="label-control rowlebel ">TRL</label> <input
				type="text" class="form-control" id="trlLevel" name="trlLevel"
				placeholder="TRL Level"  />
		</div>
		
			<div class="col-md-3">
			<label class="label-control rowlebel ">FRL  </label> <input
				type="text" class="form-control" id="frlLevel" name="frlLevel"
				placeholder="FRL Level"  />
		</div>


<div class="col-md-3">
			<label class="label-control rowlebel ">MWL  </label> <input
				type="text" class="form-control" id="mwlLevel" name="mwlLevel"
				placeholder="MWL Level"  />
		</div>
		
		<div class="col-md-3">
			<label class="label-control rowlebel ">MDDL </label> <input
				type="text" class="form-control" id="mddlLevel" name="mddlLevel"
				placeholder="MDDL Level"  />
		</div>

		
		<div class="col-md-3">
			<label class="label-control rowlebel ">Dead Storage Level </label> <input
				type="text" class="form-control" id="deadstorageLevel" name="deadstorageLevel"
				placeholder="deadstorage Level"  />
		</div>
		
	
		
	
		</div>
		
		<div class="col-md-12 invDiv" > 

<div class="col-md-12 invDivheading" > Spill Way/Weir Details </div>

<div class="col-md-12 invDivsubheading" > Spill Way Length (Mt.)</div>
		
		
		<div class="col-md-3">
			<label class="label-control rowlebel ">Spill Way Length</label> <input
				type="text" class="form-control" id="spillwayLength"
				name="spillwayLength" placeholder="spillwayLength"  />
		</div>
		
		<div class="col-md-3">
			<label class="label-control rowlebel ">N.O.F Length</label>
			<input type="text" class="form-control" id="nonoverflowLength"
				name="nonoverflowLength" placeholder="nonoverflowLength"  />
		</div>
		
		<div class="col-md-3">
			<label class="label-control rowlebel ">Maximum Height of Spill Way</label> <input
				type="text" class="form-control" id="maxhtSpillWay"
				name="maxhtSpillWay" placeholder="maxhtSpillWay"  />
		</div>
		
		<div class="col-md-3">
			<label class="label-control rowlebel ">Top Width Of Dam</label> <input
				type="text" class="form-control" id="topWidthDam"
				name="topWidthDam" placeholder="topwidtdam"  />
		</div>

		<div class="col-md-3">
			<label class="label-control rowlebel ">Max Base Width Dam</label> <input
				type="text" class="form-control" id="maxbaseWidthDam"
				name="maxbaseWidthDam" placeholder="maxbasewidthdam"  />
		</div>

		<div class="col-md-3">
			<label class="label-control rowlebel ">Clear Bridge Width</label>
			<input type="text" class="form-control" id="clearBridgeWidth"
				name="clearBridgeWidth" placeholder="clearBridgeWidth"
				 />
		</div>
		
		<div class="col-md-3">
			<label class="label-control rowlebel ">Stilling Basin Length/Apron(Mts.)</label>
			<input type="text" class="form-control" id="stillingBasinLength"
				name="stillingBasinLength" placeholder="stillingBasinLength"
				 />
		</div>
		
		
<div class="col-md-12 invDivsubheading" > Level (+Mt.)</div>
		<div class="col-md-3">
			<label class="label-control rowlebel ">Deepest Foundation(+)</label>
			<input type="text" class="form-control" id="deepestfoundationLevel"
				name="deepestfoundationLevel" placeholder="deepestfoundationLevel"
				 />
		</div>

		<div class="col-md-3">
			<label class="label-control rowlebel ">Average River Bed(+)</label> <input
				type="text" class="form-control" id="avgRiverbedLevel"
				name="avgRiverbedLevel" placeholder="avgRiverbedLevel"  />
		</div>
		
			<div class="col-md-3">
			<label class="label-control rowlebel ">Spill Way Crest(+)</label> <input
				type="text" class="form-control" id="spillWayCrestLevel"
				name="spillWayCrestLevel" placeholder="spillWayCrestLevel"  />
		</div>

		
		<div class="col-md-3">
			<label class="label-control rowlebel ">Bridge Top Level</label>
			<input type="text" class="form-control" id="bridgeTopLevel"
				name="bridgeTopLevel" placeholder="BridgeTopLevel"
				 />
		</div>

		
		<div class="col-md-3">
			<label class="label-control rowlebel ">Invert Level of Bucket(+)</label> <input
				type="text" class="form-control" id="invertLevel" name="invertLevel"
				placeholder="invertLevel"  />
		</div>
		
		<div class="col-md-3">
			<label class="label-control rowlebel ">Stilling Basin Level/Apron(+Mts.)</label>
			<input type="text" class="form-control" id="stillingBasinLevel"
				name="stillingBasinLevel" placeholder="stillingBasinLevel"
				 />
		</div>
		
		</div>

	
	<div class="col-md-12 invDiv" > 

<div class="col-md-12 invDivheading" > Earth Dam/Concrete Dam Details</div>
		<div class="col-md-3">
			<label class="label-control rowlebel ">Left Length(Mt.)</label> <input
				type="text" class="form-control" id="earthdamLeftLength"
				name="earthdamLeftLength" placeholder="EarthdamLeftLength"  />
		</div>
		<div class="col-md-3">
			<label class="label-control rowlebel ">Right Length(Mt.)</label> <input
				type="text" class="form-control" id="earthdamRightLength"
				name="earthdamRightLength" placeholder="EarthdamRightLength"
				 />
		</div>
		
		<div class="col-md-3">
			<label class="label-control rowlebel ">Max Height</label> <input
				type="text" class="form-control" id="maxHeight"
				name="maxHeight" placeholder="maxHeight"  />
		</div>
		

		

		<div class="col-md-3">
			<label class="label-control rowlebel ">Masonary Dam Length(Mts.)</label> <input
				type="text" class="form-control" id="masonarydamLength" name="masonarydamLength"
				placeholder="masonarydamLength"  />
		</div>
		<div class="col-md-3">
			<label class="label-control rowlebel ">Rock Fill Dam Length(Mts.)</label> <input
				type="text" class="form-control" id="rockfilldamLength" name="rockfilldamLength"
				placeholder="rockfilldamLength"  />
		</div>
		
		<div class="col-md-3">
			<label class="label-control rowlebel ">Concrete Dam Length(Mts.)</label> <input
				type="text" class="form-control" id="concretedamLength" name="concretedamLength"
				placeholder="concretedamLength"  />
		</div>
		
		<div class="col-md-3">
			<label class="label-control rowlebel ">Zonal Section Length (Mts.)</label> <input
				type="text" class="form-control" id="zonalSectionLength"
				name="zonalSectionLength" placeholder="maxHeight"  />
		</div>
		
		<div class="col-md-3">
			<label class="label-control rowlebel ">Homogeneous Section Length (Mts.)</label> <input
				type="text" class="form-control" id="homogeneousSectionLength"
				name="homogeneousSectionLength" placeholder="HomogeneousSectionLength"  />
		</div>



</div>





		<div class="row show-grid">

			<div class="col-md-12" style="text-align: center;">
				<label class="label-control rowlebel "></label>
				 
				<input 	type="hidden" class="form-control" id="resCodeid" 	name="resCode" placeholder="resCode"  />
				  <button type="button" name="addres" id="addres" class="btn btn-1 btn-primary center-block" >AddReservoir</button>
				
				
			</div>


		</div>

</form:form>

	</div>
	
	
	<div class="col-md-12" id="viewresinfo-dailogue">


			
			<div class="col-md-8" >
					<div class="col-md-6">
						<label class="label-control rowlebel ">Select Reservoir</label>
					</div>

					<div class="col-md-6">
						<select class="form-control" id="inforeservoirId" name="inforeservoirId" onchange="getResInfo(this.value)">
							<option value=" ">select</option>
						<c:forEach items="${resList}" var="u">
								<option value="${u.resCode}">${u.resName}</option>

							</c:forEach>
						</select>
					</div>
				
			</div>
			
			<div class="col-md-9">
	<div class="table-responsive ">
     <table class="table table-striped table-bordered" id="info-data">
     <thead id="infohead">
     
    
      <tr style="color: blue; ">  
      
       
      
   
       
      
    
      </tr>
      </thead>
      <tbody id="infodata">
   
     </tbody>
     </table>
     
    </div>
    </div>

		</div>
		
		<div class="col-md-12" id="viewresjuris-dailogue">


			
			<div class="col-md-8" >
					<div class="col-md-6">
						<label class="label-control rowlebel ">Select Reservoir</label>
					</div>

					<div class="col-md-6">
						<select class="form-control" id="jurisreservoirId" name="jurisreservoirId" onchange="resunitmapByResCode(this.value)">
							<option value=" ">select</option>
						<c:forEach items="${resList}" var="u">
								<option value="${u.resCode}">${u.resName}</option>

							</c:forEach>
						</select>
					</div>
				
			</div>
			
			<div class="col-md-12">
	<div class="table-responsive ">
     <table class="table table-striped table-bordered" id="resjuris-data">
     <thead id="jurishead">
     
    
      <tr style="color: blue; "> 
      
       <th style="text-align: center;"><b>Circle Name</b></th>
       
        <th style="text-align: center;"><b>Division Name</b></th>
       
        <th style="text-align: center;"><b>Sub Division Name</b></th> 
        
        <th style="text-align: center;"><b>Project Name</b></th>     
         <th style="text-align: center;"><b>Package Name</b></th>     
       
       <th style="text-align: center;"><b>Reservoir Name</b></th>
       
         <th style="text-align: center;"><b>Work Inspector No.</b></th>
         
           <th style="text-align: center;"><b>Luscurs No.</b></th>
            <th style="text-align: center;"><b>Remarks</b></th>
           
              <th style="text-align: center;"><b>Edit</b></th>
              
                 <th style="text-align: center;"><b>Delete</b></th>
       
      
       
      
   
       
      
    
      </tr>
      </thead>
      <tbody id="jurisdata">
   
     </tbody>
     </table>
     
    </div>
    </div>

		</div>
	
	
	<div class="col-md-12" id="gate-dailogue">
	
	<form:form id="gateformid" method="post" modelAttribute="reservoirgates" name="gatesform"
			data-parsley-validate-if-empty="" enctype="multipart/form-data">
	
	<div class="col-md-8" >
					<div class="col-md-6">
						<label class="label-control rowlebel ">Select Reservoir</label>
					</div>

					<div class="col-md-6">
						<select class="form-control" id="gatereservoirId" name="gatereservoirId"  onchange="getResRegList(this.value,1);resGatemapByResCode(this.value);" >
							<option value=" ">select</option>
						<c:forEach items="${resList}" var="u">
								<option value="${u.resCode}">${u.resName}</option>

							</c:forEach>
						</select>
					</div>
					
					<div class="col-md-6">
					<label class="label-control rowlebel ">Select Gate Regulator</label> 
					</div>
					<div class="col-md-3">
					<input
						type="hidden" class="form-control" id="hiddenregCode"
						name="hiddenregCode" />
					<select
						class="form-control" id="regulatorCode" name="regulatorCode">

					



					</select>
				</div>
				<div class="col-md-3">

						<input type="button" class="btn btn-1 btn-primary center-block"
							id="addnewreg" value="Add Regulator">

						<!-- onclick="addPack()" -->

					</div>
				
				
				
				
				<div class="col-md-6">
				<label class="label-control rowlebel ">No. of Gates</label> 
					</div>
				
					<div class="col-md-6">
					<input
						type="text" class="form-control" id="gateNo"
						name="gateNo" placeholder="noofgates" required />
				</div>
				
				<div class="col-md-6">
					<label class="label-control rowlebel ">GateType</label> 
					</div>
				
				<div class="col-md-6">
					 <select
						class="form-control" id="gateTypeId" name="gateTypeId">

						<option value="1">Radial Gates</option>
						<option value="2">Vertical Gates</option>




					</select>
				</div>
				
				<div class="col-md-6">
					<label class="label-control rowlebel ">GateSize/Vent Size(Mts.)</label>
					</div>
				
				<div class="col-md-6">
					 <input
						type="text" class="form-control" id="gateSize" name="gateSize"
						placeholder="ex: 13.716*13.410" required />
				</div>
				
				<div class="col-md-6">
				<label class="label-control rowlebel ">GateDischarge/Vent Discharge(cumecs)</label> 
					</div>
				
					<div class="col-md-6">
					<input
						type="text" class="form-control" id="gateDischarge"
						name="gateDischarge" placeholder="eachgateDischarge" required />
				</div>
				
				<div class="col-md-6">
				<label class="label-control rowlebel ">Gate Sill Level(+Mts.)</label> 
					</div>
				
					<div class="col-md-6">
					<input
						type="text" class="form-control" id="gateSillLevel"
						name="gateSillLevel" placeholder="gateSillLevel" required />
				</div>
				
				<div class="col-md-6">
				<label class="label-control rowlebel ">Gate Top Level(+Mts.)</label> 
					</div>
				
					<div class="col-md-6">
					<input
						type="text" class="form-control" id="gateTopLevel"
						name="gateTopLevel" placeholder="gateTopLevel" required />
				</div>
				
					<div class="col-md-6">
					<label class="label-control rowlebel ">Gate Operation System</label> 
					</div>
				
				<div class="col-md-6">
					 <select
						class="form-control" id="gateSystemId" name="gateSystemId">
						<option value="">Select</option>

						<option value="1">Hydraulic Hoist System</option>
						<option value="2">Rope Drum Hoist System</option>




					</select>
				</div>
				
				
				<div class="col-md-6">
				<label class="label-control rowlebel ">GateWeight(Kg.)</label> 
					</div>
				
					<div class="col-md-6">
					<input
						type="text" class="form-control" id="gateWeight"
						name="gateWeight" placeholder="gateWeight" required />
				</div>
				
					<div class="col-md-6">
				<label class="label-control rowlebel ">Gate Hoist Motor(HP.)</label> 
					</div>
				
					<div class="col-md-6">
					<input
						type="text" class="form-control" id="gateHoistMotor"
						name="gateHoistMotor" placeholder="gateHoistMotor" required />
				</div>
				
				
				<input
						type="hidden" class="form-control" id="reservoirGateId" name="reservoirGateId"
						 placeholder=""  />
				  <button type="button" name="addgatesinfo" id="addgatesinfo" class="btn btn-1 btn-primary center-block" >AddGatesInfo</button>
				
				
			</div>

</form:form>
			
<div class="col-md-12">
	
	
    
	
	
	<div class="table-responsive ">
     <table class="table table-striped table-bordered" id="gate-data">
     <thead id="gatehead">
     
    
      <tr style="color: blue; ">  
      
       
        <th style="text-align: center;"><b>Gate Regulator</b></th>
       
        <th style="text-align: center;"><b>No. of Gates</b></th>
       
        <th style="text-align: center;"><b>Gate Type</b></th> 
        
        <th style="text-align: center;"><b>Gate Size/ Vent Size</b></th>     
         <th style="text-align: center;"><b>Gate Discharge</b></th>     
       
       <th style="text-align: center;"><b>Gate Sill Level</b></th>
       
         <th style="text-align: center;"><b>Gate Top Level</b></th>
         
           <th style="text-align: center;"><b>Gate Operation System</b></th>
            <th style="text-align: center;"><b>Gate Weight</b></th>
             <th style="text-align: center;"><b>Gate Hoist Motor </b></th>
           
             
      
   
       
      
    
      </tr>
      </thead>
      <tbody id="gatedata">
   
     </tbody>
     </table>
     
    </div>
   
    </div>			
			</div>	<!-- gate dialogue ends -->
			
			<div class="col-md-12" id="viewgateinfo-dailogue"><!-- gateView-dialogue Starts -->


			
			<div class="col-md-8" >
					<div class="col-md-6">
						<label class="label-control rowlebel ">Select Reservoir</label>
					</div>

					<div class="col-md-6">
						<select class="form-control" id="viewgatereservoirId" name="viewgatereservoirId" onchange="resGateviewByResCode(this.value)">
							<option value=" ">select</option>
						<c:forEach items="${resList}" var="u">
								<option value="${u.resCode}">${u.resName}</option>

							</c:forEach>
						</select>
					</div>
				
			</div>
			
			<div class="col-md-12">
	<div class="table-responsive ">
     <table class="table table-striped table-bordered" id="viewgateinfo-data">
     <thead id="viewgateinfohead">
     
    
      <tr style="color: blue; "> 
      
       <th style="text-align: center;"><b>Gate Regulator</b></th>
       
        <th style="text-align: center;"><b>No. of Gates</b></th>
       
        <th style="text-align: center;"><b>Gate Type</b></th> 
        
        <th style="text-align: center;"><b>Gate Size/ Vent Size</b></th>     
         <th style="text-align: center;"><b>Gate Discharge</b></th>     
       
       <th style="text-align: center;"><b>Gate Sill Level</b></th>
       
         <th style="text-align: center;"><b>Gate Top Level</b></th>
         
           <th style="text-align: center;"><b>Gate Operation System</b></th>
            <th style="text-align: center;"><b>Gate Weight</b></th>
             <th style="text-align: center;"><b>Gate Hoist Motor </b></th>
           
              <th style="text-align: center;"><b>Edit</b></th>
              
                 <th style="text-align: center;"><b>Delete</b></th>
       
      
       
      
   
       
      
    
      </tr>
      </thead>
      <tbody id="viewgateinfo">
   
     </tbody>
     </table>
     
    </div>
    </div>

		</div>  <!-- gateView-dialogue ends -->
			
			
				<div class="col-md-12" id="ayacut-dailogue">
	<form:form id="resayacutformid" method="post" modelAttribute="resayacut" name="ayacutform"
			data-parsley-validate-if-empty="" enctype="multipart/form-data">
	<div class="col-md-8" >
					<div class="col-md-6">
						<label class="label-control rowlebel ">Select Reservoir</label>
					</div>

					<div class="col-md-6">
						<select class="form-control" id="ayacutreservoirId" name="ayacutreservoirId"  onchange="getResRegList(this.value,2);getResRegAyacutByResCode(this.value);">
							<option value=" ">select Reservoir</option>
						<c:forEach items="${resList}" var="u">
								<option value="${u.resCode}">${u.resName}</option>

							</c:forEach>
						</select>
					</div>
					
					<div class="col-md-6">
					<label class="label-control rowlebel ">Select Head Regulator</label> 
					</div>
					<div class="col-md-6">
					<input
						type="hidden" class="form-control" id="hiddenayacutregcode"
					 />
					<select
						class="form-control" id="resRegulatorCode" name="resRegulatorCode">

						
							
						
					



					</select>
				</div>
				
				<div class="col-md-6">
				<label class="label-control rowlebel ">Contemplated Ayacut(Acres)</label> 
					</div>
				
					<div class="col-md-6">
					<input
						type="text" class="form-control" id="ayacutContemplated"
						name="ayacutContemplated" placeholder="Ex: Contemplated Ayacut(Acres)" required />
				</div>
				<input
						type="hidden" class="form-control" id="resAyacutId" name="resAyacutId"
						 placeholder=""  />
				  <button type="button" name="addayacutinfo" id="addayacutinfo" class="btn btn-1 btn-primary center-block" >AddAyacut</button>
				
				
			</div>


			
</form:form>


<div class="col-md-12">
	<div class="table-responsive ">
     <table class="table table-striped table-bordered" id="regayacut-data">
     <thead id="regayacuthead">
     
    
      <tr style="color: blue; "> 
      
       <th style="text-align: center;"><b>Gate Regulator</b></th>
       
        <th style="text-align: center;"><b>Contemplated Ayacut(Acres)</b></th>
     
      </tr>
      </thead>
      <tbody id="regayacutdata">
   
     </tbody>
     </table>
     
    </div>
    </div>

			</div>	<!-- ayacut dialogue ends -->
			
			<div class="col-md-12" id="viewayacutinfo-dailogue"><!-- ayacutView-dialogue Starts -->


			
			<div class="col-md-8" >
					<div class="col-md-6">
						<label class="label-control rowlebel ">Select Reservoir</label>
					</div>

					<div class="col-md-6">
						<select class="form-control" id="viewayacutreservoirId" name="viewayacutreservoirId" onchange="getViewRegAyacutByResCode(this.value)">
							<option value=" ">select</option>
						<c:forEach items="${resList}" var="u">
								<option value="${u.resCode}">${u.resName}</option>

							</c:forEach>
						</select>
					</div>
				
			</div>
			
			<div class="col-md-12">
	<div class="table-responsive ">
     <table class="table table-striped table-bordered" id="viewayacutinfo-data">
     <thead id="viewayacutinfohead">
     
    
      <tr style="color: blue; "> 
      
       <th style="text-align: center;"><b>Gate Regulator</b></th>
       
        <th style="text-align: center;"><b>Ayacut Contemplated(Acres)</b></th>
       
       
              <th style="text-align: center;"><b>Edit</b></th>
              
                 <th style="text-align: center;"><b>Delete</b></th>
       
      
       
      
   
       
      
    
      </tr>
      </thead>
      <tbody id="viewayacutinfo">
   
     </tbody>
     </table>
     
    </div>
    </div>

		</div>  <!-- Viewayacutinfo-dialogue ends -->
			
		

		</div> <!-- col-md-8 div -->
		
		 </div>	<!-- container div -->
	

	</div>	<!-- panel div -->
	

	

    
	
	
	<!-- data ends -->



<!--  dilogue starts -->

	<div id="pack_dialogue">



		<div class="col-md-8">
			<label class="label-control rowlebel ">Package Name</label> <input
				type="text" class="form-control" id="dipackpkgName" name="pkgName"
				placeholder="pack Name" required />
		</div>



		<div class="col-md-8">
			<label class="label-controlPMS rowlebel ">Select Unit</label> <select
				class="form-control" id="dipackunitId" name="unitId"
				onchange="getProjects(this.value,2);getCircles(this.value,2)">
				<option value="0">--select --</option>
				<c:forEach items="${unitList}" var="u">
					<c:choose>
						<c:when test="${u.unitId==selectedUnit }">
							<option value="${u.unitId}" selected="selected">${u.unitName}</option>
						</c:when>
						<c:otherwise>
							<option value="${u.unitId}">${u.unitName}</option>
						</c:otherwise>
					</c:choose>
				</c:forEach>


			</select>
		</div>


		<div class="col-md-8">
			<label class="label-controlPMS rowlebel ">Select Project</label> <input
				type="hidden" class="form-control" id="dipackselectedProj"
				name="selectedProjId" value="${selectedProject}" required /> <select
				class="form-control" id="dipackprojectId" name="projectId">
			</select>
		</div>


		<div class="col-md-8">
			<label class="label-controlPMS rowlebel ">Select Circle</label> <select
				class="form-control" id="dipackcircleId" name="circleId"
				onchange="getDivisions(this.value,2)">



			</select>
		</div>


		<div class="col-md-8">
			<label class="label-controlPMS rowlebel ">Select Division</label> <select
				class="form-control" id="dipackdivisionId" name="divisionId"
				>



			</select>
			
			<!-- onchange="getSubDivisions(this.value,2)" -->
		</div>












		<div class="row show-grid">

			<div class="col-md-8">
				<label class="label-control rowlebel "></label><input
					style="text-align: center;" type="submit"
					class="btn btn-1 btn-primary center-block" id="addpack"
					value="Add Package">
			</div>


		</div>



	</div>
	
	
	<div id="reg_dialogue">


	<div class="col-md-6">
						<label class="label-control rowlebel ">Select Reservoir</label>
					</div>

					<div class="col-md-6">
						<select class="form-control" id="regreservoirId" name="regreservoirId" >
							<option value=" ">select</option>
						<c:forEach items="${resList}" var="u">
								<option value="${u.resCode}">${u.resName}</option>

							</c:forEach>
						</select>
					</div>
					
					<div class="col-md-6">
					<label class="label-control rowlebel ">Select Gates</label> 
					</div>
					<div class="col-md-6"><select
						class="form-control" id="regulatorId" name="regulatorId">

						<option value="1">Crest Gates/Reservoir Gates</option>
						<option value="2">Head Regulator</option>
						<option value="3">Chute Sluices/River Sluices</option>
						<option value="4">Diversion Tunnel</option>	
						<option value="5">Stop Clock Gates/Emergency Gates</option>			
						
					



					</select>
				</div>
				
				<div class="col-md-6">
				<label class="label-control rowlebel ">Name Of Head Regulator</label> 
					</div>
				
					<div class="col-md-6">
					<input
						type="text" class="form-control" id="regulatorName"
						name="regulatorName" placeholder="Ex: Left Canal Head Sluice" required />
				</div>
				

		

		<div class="row show-grid">

			<div class="col-md-8">
				<label class="label-control rowlebel "></label><input
					style="text-align: center;" type="submit"
					class="btn btn-1 btn-primary center-block" id="addreg"
					value="Add Regulators">
			</div>


		</div>



	</div>

	


	
	
	
	
	
	
	
	
			

	






<!-- </div> -->
<!-- //main-content -->
<script type="text/javascript" src="../js/parsley.js"></script>




