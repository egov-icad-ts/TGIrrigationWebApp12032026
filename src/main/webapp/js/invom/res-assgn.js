$(document).ready(function() {
	
	
		
	

	});

$(function() {
	
	

	 $('.resinf').hide(); 
	
	 $('#nrld_dialogue').dialog({
		  autoOpen:false,
		  width:800,
		  close: function() {
			  
			
				  $(this).dialog("close");
				  }
		 });
	 
	 $('#resaccess_dialogue').dialog({
		  autoOpen:false,
		  width:800,
		  close: function() {
			  
			
				  $(this).dialog("close");
				  }
		 });
	 
	 $('.nrldpid').click(function(){
			
	
	      
		 });
	 
	

});

function openreservoir(count){
	
	//alert("count"+count)
	
	 $('.resinf').hide(); 
	var resdatanew="#resdata"+count;
	
	//alert("resdatanew"+resdatanew);
	
	 $(resdatanew).show(); 
	
	
}


function addnrldinformation(resId,projectId){
	
	 $('#nrld_dialogue').dialog('option', 'title', 'update PID');
	  $('#nrld_dialogue').dialog('open');
	  
	  $('#nrldstatusid').trigger("reset"); 
	  
	  $('#resprojectId').val(projectId); 
	  
	  $('#resnrldId').val(resId); 
	  
	  
	  
	 
	
	
}

function addempformation (resId,projectId,resName){
	
	 $('#resaccess_dialogue').dialog('option', 'title', 'update PID'+resName);
	  $('#resaccess_dialogue').dialog('open');
	  
	  $('#resaccessstatusid').trigger("reset"); 
	  
	  $('#accprojectId').val(projectId); 
	  
	  $('#accresId').val(resId); 
	
}


function updatenrldStatusdata(formId){
	
	//alert("formId"+formId);
	
	var formId = formId		
	 
	 var customformid="#"+formId;

	
	$('#action_alert').empty();


	
	
		if ($('form[id='+formId+']').parsley()
				.isValid()) {		 
	    $.ajax({	          
	url: "../invtsimis/updateNrldCode" ,
	method:"POST",
	dataType: 'json',

	async: false,
	data: $('form[id=' + formId+ ']').serialize() ,


	success: function (response) {

		  
		//  console.log(response);
		
		if(response>0){
		  
		  $('#resatsform').trigger("reset"); 
		  
		 

		  $('#action_alert').html('<p style="margin: 0px !important;">Data Inserted Successfully</p>');
		  $("html,body").animate({scrollTop:0}, 500);
		  
		  window.location.reload();
		  
		 // getActionStatusDetails( );
		  
		}
		
		if(response==-1){
			
			

			  $('#action_alert').html('<p style="margin: 0px !important;">Please add Inspection Details and Dam Health Details including Recommendation</p>');
			  $("html,body").animate({scrollTop:0}, 500);
			
			
		}
		
		if(response==-2){
			
			

			  $('#action_alert').html('<p style="margin: 0px !important;">Already data added (If any change please edit data)</p>');
			  $("html,body").animate({scrollTop:0}, 500);
			
			
		}
		
		
		
		if(response==0 || response==null){
			
			

			  $('#action_alert').html('<p style="margin: 0px !important;">Failed to Insert</p>');
			  $("html,body").animate({scrollTop:0}, 500);
			
			
		}
		   
		//  gettankfeeddata(tankId) ; 
		

	},
	error : function(){
		 alert(error);

	}
	}); 	
		 }else {
				
				$('form[id='+formId+']').parsley().validate();
				//alert("kal4");
				
		} 
			

}


function updateaccessStatusdata(formId){
	
	//alert("formId"+formId);
	
	var formId = formId		
	 
	 var customformid="#"+formId;

	
	$('#action_alert').empty();


	
	
		if ($('form[id='+formId+']').parsley()
				.isValid()) {		 
	    $.ajax({	          
	url: "../invtsimis/insertrespostaccess" ,
	method:"POST",
	dataType: 'json',

	async: false,
	data: $('form[id=' + formId+ ']').serialize() ,


	success: function (response) {

		  
		//  console.log(response);
		
		if(response>0){
		  
		  $('#resatsform').trigger("reset"); 
		  
		 

		  $('#action_alert').html('<p style="margin: 0px !important;">Data Inserted Successfully</p>');
		  $("html,body").animate({scrollTop:0}, 500);
		  
		  window.location.reload();
		  
		 // getActionStatusDetails( );
		  
		}
		
		if(response==-1){
			
			

			  $('#action_alert').html('<p style="margin: 0px !important;">Please add Inspection Details and Dam Health Details including Recommendation</p>');
			  $("html,body").animate({scrollTop:0}, 500);
			
			
		}
		
		if(response==-2){
			
			

			  $('#action_alert').html('<p style="margin: 0px !important;">Already data added (If any change please edit data)</p>');
			  $("html,body").animate({scrollTop:0}, 500);
			
			
		}
		
		
		
		if(response==0 || response==null){
			
			

			  $('#action_alert').html('<p style="margin: 0px !important;">Failed to Insert</p>');
			  $("html,body").animate({scrollTop:0}, 500);
			
			
		}
		   
		//  gettankfeeddata(tankId) ; 
		

	},
	error : function(){
		 alert(error);

	}
	}); 	
		 }else {
				
				$('form[id='+formId+']').parsley().validate();
				//alert("kal4");
				
		} 
			

}




function getRespostEmp( count,reservoirId ) {
	
	var  reshead ="#viewemphead"+count
	
	var  resbody ="#viewempbody"+count
	
	var resdiv="#viewemp"+count+" table thead"
	
	var resdivbody="#viewemp"+count+" table tbody"
	
	
	$(reshead).empty();
	$(resbody).empty();
	


	$.ajax({
		url : "../invtsimis/get-respostemp",
		type : "POST",
		data: {
			reservoirId: reservoirId,
			},
		success : function(response) {
			
		
			
			 var j=1;
			
			var obj = JSON.parse(response);
			
			 $(resdiv).append( '<tr style="font-size: 18px; color: gray; font-weight: bold;"><th>Sl.No</th>'+
	    	    		
	    	    		'<th>Unit Name</th>'+
	    	    		'  <th>Circle Name</th>'+
	    	    	
	    	    
	    	    		'  <th>Division Name</th>'+
	    	    		
	    	    		'  <th>Sub division Name</th>'+
	    	    		
	    	    		' <th>Post Name</th>'+
	    	    		
	    	    		' <th>Employee Name</th>'+
	    	    		
	    	    		' <th>Remove Access</th>'+
	    	    		
	    	    	
	    	    		'</tr>'); 	  

			

			 for(i in obj){
	    	    	
	    	    
	    	    
	    	    	
	    	    	   $(resdivbody).append(  '<tr style="font-size: 16px">' +
	    	    			                                '<td style="text-align: center;">'+j+'</td>' +
	    	    			                               
	    	    			                                '<td><b>'+obj[i].unitName+'</b></td>' +
	    	    			                                '<td><b>'+obj[i].circleName+'</b></td>' +
	    	    			                                '<td><b>'+obj[i].divisionName+'</b></td>' +
	    	    			                                '<td><b>'+obj[i].subdivisionName+'</b></td>' +
	    	    			                                '<td><b>'+obj[i].postName+'</b></td>' +
	    	    			                                '<td><b>'+obj[i].empName+'</b></td>' +
	    	    			                                '<td><b><b><button type="button" name="resempinf" id="editempacces'+j+'" class="btn btn-1 btn-primary center-block mst1resaccess" onclick="editaccess('+obj[i].resUnitProjMapId+')"  >Remove Access </button></b></td>' +
	    	    			                                
		    	    			                      
	    	    	                                     '</tr>');
	    	    	   
	    	    	   
	    	    	  
	    	    	   
	    	    	
	    	    	 
	    	    	  
	    	    	   j++;   
	    	    
	    	    }
			 
			 

		},
		error : function() {
			alert(error);
		}
	});
}

function editaccess(mapId){
	
	//alert("mapId"+mapId);
	
	
	var resUnitProjMapId = mapId		
	 
	
	
	
	  $.ajax({	          
	      url: "../invtsimis/deleterespostaccess",
	      type: "GET",
	      data: {resUnitProjMapId :  resUnitProjMapId,
	    	 
			},


	success: function (response) {

		  
		//  console.log(response);
		
		if(response>0){
		  
		
		  
		 

		  $('#action_alert').html('<p style="margin: 0px !important;">Data deleted Successfully</p>');
		  $("html,body").animate({scrollTop:0}, 500);
		  
		  window.location.reload();
		  
		 // getActionStatusDetails( );
		  
		}
		
		
		
		
		
		if(response==0 || response==null){
			
			

			  $('#action_alert').html('<p style="margin: 0px !important;">Failed to delete</p>');
			  $("html,body").animate({scrollTop:0}, 500);
			
			
		}
		   
		//  gettankfeeddata(tankId) ; 
		

	},
	error : function(){
		 alert(error);

	}
	}); 	
		
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

function getSubDivisions(){
	//alert("kal");
	//var districtId=document.getElementById("districtId").value;
	var divisionId=document.getElementById("divisionId").value;
	//alert(mandalId);

	  $.ajax({	          
      url: "../web/getSubDivisions?divisionId="+divisionId,
      type: "GET",
      success: function (response) {
    	
    	
    	
    	  var $select = $('#subdivisionId');
    	 
		  $select.find('option').remove();
		  
		 
		
		 
				var obj = JSON.parse(response);
				  $('#subdivisionId').append( '<option value="0"> --select--</option>' );
				  
				$.each(obj, function(key, value) {
					
						$('#subdivisionId').append( '<option value="'+value.subdivisionId+'" > '+value.subdivisionName+'</option>' );
				
  	  				$('#subdivisionId').multiselect('rebuild');
				});
    	 

      },
      error : function(){
    	  alert(error);
      }
  }); 	
}



function getemployees(){
	//alert("kal");
	//var districtId=document.getElementById("districtId").value;
	var unitId=document.getElementById("unitId").value;
	var circleId=document.getElementById("circleId").value;
	var divisionId=document.getElementById("divisionId").value;
	var subdivisionId=document.getElementById("subdivisionId").value;
	//alert(mandalId);

	  $.ajax({	          
      url: "../invtsimis/getempinfobyoffice",
      type: "GET",
      data: {unitId :  unitId,
    	  circleId:circleId,
    	  divisionId:divisionId,
    	  subdivisionId:subdivisionId
		},
      success: function (response) {
    	
    	
    	
    	  var $select = $('#postId');
    	 
		  $select.find('option').remove();
		  
		 
		
		 
				var obj = JSON.parse(response);
				  $('#postId').append( '<option value="0"> --select--</option>' );
				  
				$.each(obj, function(key, value) {
					
						$('#postId').append( '<option value="'+value.postId+'" > '+value.employeeName+'</option>' );
				
  	  				$('#postId').multiselect('rebuild');
				});
    	 

      },
      error : function(){
    	  alert(error);
      }
  }); 	
}