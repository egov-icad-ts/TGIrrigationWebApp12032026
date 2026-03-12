function AddSeasonAyacutRequired(){
	
	
	//alert("i am kal");
	
	var editinfo=$('#editFlag').val();
	
	//alert("editinfo"+editinfo);
	
	if(editinfo=="false"){
		
	//	alert("inside add");


		if ($('form[id=projSeaAyacutform]').parsley().isValid()) {
			
			var finaldatatoSend=$('form[id=projSeaAyacutform]').serialize();
			
			  $.ajax({	          
					      url: "../comptsimis/add-proj-season-ayacut",
					      method:"POST",
					      async: false,
					     
					      data:finaldatatoSend,
						 
					      success: function (response) {
					   
					    	//alert("kal"+response);
					    	 
					    	 if(response>0){
					    		 
					    		 
					    		  $('#addseainfo_dialogue').dialog('close');
						  $('#action_alert').html('<p style="margin: 0px !important;">Data added Successfully</p>');
							$("html,body").animate({scrollTop:$('#action_alert').offset().top-175}, 500);
							
							
						    $("#projSeaAyacutform").trigger("reset");
						    
						  
						    
						    
						    }
					    	 
					    	 if(response==-2){
					    		 
					    		  $('#addseainfo_dialogue').dialog('close');
							    	
						    	  $('#action_alert').html('<p style="margin: 0px !important;">Data already exist. Please edit/delete.</p>');
						    		$("html,body").animate({scrollTop:$('#action_alert').offset().top-175}, 500);
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
				            	 
				            	 $('form[id=projSeaAyacutform]').parsley().validate();
				            	 
				             }
		

	
	}
	
if(editinfo=="true"){
		
		//alert("coming to edit");
		
		UpdateSeaAyacutInfo();
		
	}
	
	
}

function ViewSeaAyacutInfo(projectAyacutId,projectseasonId,seasonId,actplanyear){
	
	var seasonId=seasonId;
	var actplanyear=actplanyear;
	var seasonName;
	
	if(seasonId==1){
		
		seasonName=" Vana kalam / Kharif";
		
	}
	
	if(seasonId==2){
		
		seasonName=" Yasangi / Rabi";
	}
	
	 $('#viewseadata_dialogue').dialog('option', 'title', 'View Info');
	  $('#viewseadata_dialogue').dialog('open');
	  
	  $("#v_SeaAyacut").trigger("reset");
	
	$("#doc-thead1").empty();
	$("#doc-tbody1").empty();
	
	 $.ajax({	          
			url: "../comptsimis/view-proj-sea-ayacut-bypayacut" ,
			method:"GET",
			dataType: 'json',

			async: false,
			data: {
				  
				projAyacutId:projectAyacutId,
				projectseasonId:projectseasonId,
				
				  
			},


			success: function (obj) {

				  
				// console.log(obj);
				    //	  var obj = JSON.parse(msg);
				
				    	  var j=1;
				    	  
				    	//alert("kalhere");
				    	    $('#v_sea_form_ayacut table thead').append( '<tr style="font-size: 18px; color: gray; font-weight: bold;"><th>Sl.No</th>'+
				    	    		
				    	    		'<th>Season</th>'+
				    	    	
				    	    		/*'  <th>Latest</th>'+*/
				    	    		'  <th>Action Plan Year</th>'+
				    	    		
				    	    		' <th>crop</th>'+
				    	    		
				    	    		'  <th>Irrigated Ayacut</th>'+
				    	    		
				    	    		'  <th>proposed ayacut</th>'+
				    	    		
				    	    		'  <th>Crop Names</th>'+
				    	    	
				    	    		'  <th>Observation Date</th>'+
				    	    		'  <th>Remarks</th>'+
				    	    	
				    	    		
				    	    		
				    	    		
				    	    		'</tr>'); 	  
				    	    
				    	    for(i in obj){
				    	    	
				    	    	var s= obj[i].seasonId ;
				    	    	
				    	    
				    	    	if(seasonId==s){
				    	    	   $('#v_sea_form_ayacut table tbody').append(  '<tr style="font-size: 16px">' +
				    	    			                                '<td style="text-align: center;">'+j+'</td>' +
				    	    			                               
				    	    			                                '<td><b>'+seasonName+'</b></td>' +
				    	    			                             
				    	    			                                '<td><b>'+actplanyear+'</b></td>' +
				    	    			                                '<td><b>'+obj[i].cropName+'</b></td>' +
				    	    			                                '<td><b>'+obj[i].irriagtedAyacut+'</b></td>' +
				    	    			                                
				    	    			                                '<td><b>'+obj[i].proposedAyacut+'</b></td>' +
				    	    			                                '<td><b>'+obj[i].cropNames+'</b></td>' +
				    	    			                                '<td><b>'+obj[i].ObsDate+'</b></td>' +
				    	    			                                
				    	    			                                '<td><b>'+obj[i].remarks+'</b></td>' +
				    	    			                              
				    	    	   '</tr>');
				    	    	   
				    	    	}
				    	    	   
				    	    	   j++;
				    	    	   
				    	    
				    	    }
				    
				    	 
		
			},
			error : function(){
				 alert(error);

			}
			}); 
	
	
	
	
}


function ViewEditSeaAyacutInfo(projectAyacutId,projectseasonId,seasonId,actplanyear){
	var seasonId=seasonId;
	var actplanyear=actplanyear;
	var seasonName;
	
	if(seasonId==1){
		
		seasonName=" Vana kalam / Kharif";
		
	}
	
	if(seasonId==2){
		
		seasonName=" Yasangi / Rabi";
	}
	
	 $('#viewEditseadata_dialogue').dialog('option', 'title', 'view/edit Info');
	  $('#viewEditseadata_dialogue').dialog('open');
	  
	  $("#v_editSeaAyacut").trigger("reset");
	
	$("#doc-edit-thead1").empty();
	$("#doc-edit-tbody1").empty();
	
	 $.ajax({	          
			url: "../comptsimis/view-proj-sea-ayacut-bypayacut" ,
			method:"GET",
			dataType: 'json',

			async: false,
			data: {
				  
				projAyacutId:projectAyacutId,
				projectseasonId:projectseasonId,
				
				  
			},


			success: function (obj) {

				  
				// console.log(obj);
			    //	  var obj = JSON.parse(msg);
			
			    	  var j=1;
			    	  
			    	//alert("kalhere");
			    	    $('#v_edit_sea_form_ayacut table thead').append( '<tr style="font-size: 18px; color: gray; font-weight: bold;"><th>Sl.No</th>'+
			    	    		
			    	    		'<th>Season</th>'+
			    	    	
			    	    		/*'  <th>Latest</th>'+*/
			    	    		'  <th>Action Plan Year</th>'+
			    	    		
			    	    		' <th>crop</th>'+
			    	    		
			    	    		'  <th>Irrigated Ayacut</th>'+
			    	    		
			    	    		'  <th>proposed ayacut</th>'+
			    	    		'  <th>Crop Names</th>'+
			    	    	
			    	    		'  <th>Observation Date</th>'+
			    	    		'  <th>Remarks</th>'+
			    	    		'  <th>Action</th>'+
			    	    	
			    	    		
			    	    		
			    	    		
			    	    		'</tr>'); 	  
			    	    
			    	    for(i in obj){
			    	    	
			    	    	var s= obj[i].seasonId ;
			    	    	
			    	    
			    	    	if(seasonId==s){
			    	    	   $('#v_edit_sea_form_ayacut table tbody').append(  '<tr style="font-size: 16px">' +
			    	    			                                '<td style="text-align: center;">'+j+'</td>' +
			    	    			                               
			    	    			                                '<td><b>'+seasonName+'</b></td>' +
			    	    			                             
			    	    			                                '<td><b>'+actplanyear+'</b></td>' +
			    	    			                                '<td><b>'+obj[i].cropName+'</b></td>' +
			    	    			                                '<td><b>'+obj[i].irriagtedAyacut+'</b></td>' +
			    	    			                                
			    	    			                                '<td><b>'+obj[i].proposedAyacut+'</b></td>' +
			    	    			                                '<td><b>'+obj[i].cropNames+'</b></td>' +
			    	    			                                '<td><b>'+obj[i].ObsDate+'</b></td>' +
			    	    			                                
			    	    			                                '<td><b>'+obj[i].remarks+'</b></td>' +
			    	    			                                '<td><b><b><button type="button" name="showtanksname" id="showtanksdata"  class="btn btn-1 btn-primary center-block " onclick="EditSeaAyacutInfo('+obj[i].projSeasonAyacutId+')" >Edit </button></b></b></td>' +
			    	    			                              
			    	    	   '</tr>');
			    	    	   
			    	    	}
			    	    	   
			    	    	   j++;
			    	    	   
			    	    
			    	    }
			    
				 
			
				
			

			},
			error : function(){
				 alert(error);

			}
			}); 
	
	
	
	
}

function ViewDeleteSeaAyacutInfo(projectAyacutId,projectseasonId,seasonId,actplanyear){
	var seasonId=seasonId;
	var actplanyear=actplanyear;
	var seasonName;
	
	if(seasonId==1){
		
		seasonName=" Vana kalam / Kharif";
		
	}
	
	if(seasonId==2){
		
		seasonName=" Yasangi / Rabi";
	}
	 $('#viewDeleteseadata_dialogue').dialog('option', 'title', 'view/delete');
	  $('#viewDeleteseadata_dialogue').dialog('open');
	  
	  $("#v_deleteSeaAyacut").trigger("reset");
	
	$("#doc-delete-thead1").empty();
	$("#doc-delete-tbody1").empty();
	
	 $.ajax({	          
			url: "../comptsimis/view-proj-sea-ayacut-bypayacut" ,
			method:"GET",
			dataType: 'json',

			async: false,
			data: {
				  
				  
				projAyacutId:projectAyacutId,
				projectseasonId:projectseasonId,
				
				  
			},


			success: function (obj) {

				  
				  var j=1;
		    	  
			    	//alert("kalhere");
			    	    $('#v_delete_sea_form_ayacut table thead').append( '<tr style="font-size: 18px; color: gray; font-weight: bold;"><th>Sl.No</th>'+
			    	    		
			    	    		'<th>Season</th>'+
			    	    	
			    	    		/*'  <th>Latest</th>'+*/
			    	    		'  <th>Action Plan Year</th>'+
			    	    		
			    	    		' <th>crop</th>'+
			    	    		
			    	    		'  <th>Irrigated Ayacut</th>'+
			    	    		
			    	    		'  <th>proposed ayacut</th>'+
			    	    		'  <th>Crop Names</th>'+
			    	    	
			    	    		'  <th>Observation Date</th>'+
			    	    		'  <th>Remarks</th>'+
			    	    		'  <th>Action</th>'+
			    	    	
			    	    		
			    	    		
			    	    		
			    	    		'</tr>'); 	  
			    	    
			    	    for(i in obj){
			    	    	
			    	    	var s= obj[i].seasonId ;
			    	    	
			    	    
			    	    	if(seasonId==s){
			    	    	   $('#v_delete_sea_form_ayacut table tbody').append(  '<tr style="font-size: 16px">' +
			    	    			                                '<td style="text-align: center;">'+j+'</td>' +
			    	    			                               
			    	    			                                '<td><b>'+seasonName+'</b></td>' +
			    	    			                             
			    	    			                                '<td><b>'+actplanyear+'</b></td>' +
			    	    			                                '<td><b>'+obj[i].cropName+'</b></td>' +
			    	    			                                '<td><b>'+obj[i].irriagtedAyacut+'</b></td>' +
			    	    			                                
			    	    			                                '<td><b>'+obj[i].proposedAyacut+'</b></td>' +
			    	    			                                '<td><b>'+obj[i].cropNames+'</b></td>' +
			    	    			                                '<td><b>'+obj[i].ObsDate+'</b></td>' +
			    	    			                                
			    	    			                                '<td><b>'+obj[i].remarks+'</b></td>' +
			    	    			                                '<td><b><b><button type="button" name="showtanksname" id="showtanksdata"  class="btn btn-1 btn-danger center-block " onclick="DeleteSeaAyacutInfo('+obj[i].projSeasonAyacutId+')" >Delete </button></b></b></td>' +
			    	    			                              
			    	    	   '</tr>');
			    	    	   
			    	    	}
			    	    	   
			    	    	   j++;
			    	    	   
			    	    
			    	    }
			    
				 
			
				
			
				
			

			},
			error : function(){
				 alert(error);

			}
			}); 
	
	
	
	
}

function EditSeaAyacutInfo(projSeasonAyacutId){
	
	 $('#viewEditseadata_dialogue').dialog('close');
	
	
	 $("#projSeaAyacutform").trigger("reset");
	
	 $('#addseainfo_dialogue').dialog('option', 'title', 'Edit Ayacut Kharif/Rabi Info ');
	  $('#addseainfo_dialogue').dialog('open');
	  
		$('#cropId').removeAttr('disabled');
		
		
		
		  $('#hiddencropId').attr('name', 'cropId');
	  
	
	
		 
		 $.ajax({	          
				url: "../comptsimis/get-proj-crop-byayacutId" ,
				method:"GET",
				dataType: 'json',

				async: false,
				data: {
					  
					projSeasonAyacutId:projSeasonAyacutId,
					
					  
				},


				success: function (obj) {

					  
					if(obj!=null ){
						//	$('#tankFeedRemarks').hide();
							var projSeasonAyacutId=obj.projSeasonAyacutId;
							var cropId=obj.cropId;
							var irriagtedAyacut=obj.irriagtedAyacut;
							var proposedAyacut=obj.proposedAyacut;
						   var projectseasonId=obj.projectseasonId;
						   var cropNames=obj.cropNames;
							var ObsDate=obj.ObsDate;
						
							var remarks=obj.remarks;
							
							
							$('#hiddenprojSeasonAyacutId').val(projSeasonAyacutId);
							$('#cropId').val(cropId);
							$('#irriagtedAyacut').val(irriagtedAyacut);
							$('#proposedAyacut').val(proposedAyacut);
							$('#cropNames').val(cropNames);
						
							$('#ObsDate').val(ObsDate);
							
	                       $('#remarks').val(remarks);
							
							$('#cropId').attr('disabled', true);
							$('#hiddenprojectSeasonId').val(projectseasonId);
							
							  $('#hiddencropId').attr('name', 'cropId');
							
							  $('#hiddencropId').val(cropId);
							
							$('#editFlag').val(true);
							
							
							
						}
						
						if(obj==0 || obj==null){
							 $('#action_alert').html('<p style="margin: 0px !important;">Failed to get data</p>');
							 $("html,body").animate({scrollTop:0}, 500);
						} 
					    	
					  
				
					 
					 
				
					
				

				},
				error : function(){
					 alert(error);

				}
				}); 
	
}

////not started yet  need changes

function UpdateSeaAyacutInfo(){
	
	//alert("UpdateSeaAyacutInfo");
	
	if ($('form[id=projSeaAyacutform]').parsley().isValid()) {
	
	var finaldatatoSend=$('form[id=projSeaAyacutform]').serialize();
	
		 
		 $.ajax({	          
				url: "../comptsimis/update-proj-crop-byayacutId" ,
				method:"GET",
				dataType: 'json',

				async: false,
				   data:finaldatatoSend,


				success: function (obj) {

					  
					if(obj!=null || obj>0 ){
						
						 $('#action_alert').html('<p style="margin: 0px !important;">Updated Data Successfully</p>');
						 $("html,body").animate({scrollTop:0}, 500);
						 
						 
						 $('#addseainfo_dialogue').dialog('close');
						}
						
						if(obj==0 || obj==null){
							 $('#action_alert').html('<p style="margin: 0px !important;">Failed to Update data</p>');
							 $("html,body").animate({scrollTop:0}, 500);
						} 
					    	
			
				},
				error : function(){
					 alert(error);

				}
				}); 
		 
	}else{
    	 
    	 $('form[id=projSeaAyacutform]').parsley().validate();
    	 
     }
	
}



function DeleteSeaAyacutInfo(projSeasonAyacutId){
	
	//alert("UpdateSeaAyacutInfo"+UpdateSeaAyacutInfo);
	

	
		 
		 $.ajax({	          
				url: "../comptsimis/delete-proj-crop-byayacutId" ,
				method:"GET",
				dataType: 'json',

				async: false,
				   data:{
					   
					   projSeasonAyacutId:projSeasonAyacutId,
				   },


				success: function (obj) {

					  
					if(obj!=null || obj>0 ){
						
						 $('#action_alert').html('<p style="margin: 0px !important;"> Data  deleted successfully</p>');
						 $("html,body").animate({scrollTop:0}, 500);
						 $('#viewDeleteseadata_dialogue').dialog('close');
						}
						
						if(obj==0 || obj==null){
							 $('#action_alert').html('<p style="margin: 0px !important;">Failed to delete</p>');
							 $("html,body").animate({scrollTop:0}, 500);
						} 
					    	
					  
				
					 
					 
				
					
				

				},
				error : function(){
					 alert(error);

				}
				}); 
	
}

