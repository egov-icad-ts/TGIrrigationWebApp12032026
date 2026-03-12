function AddprojectSeasonCapacity(){
	
	
	//alert("i am kal");
	
	var editinfo=$('#editFlag').val();
	
	//alert("editinfo"+editinfo);
	
	if(editinfo=="false"){
		
		//alert("inside add");

		if ($('form[id=projSeaAyacutCap]').parsley().isValid()) {
			
			var finaldatatoSend=$('form[id=projSeaAyacutCap]').serialize();
			
			  $.ajax({	          
					      url: "../comptsimis/add-proj-season-cap",
					      method:"POST",
					      async: false,
					     
					      data:finaldatatoSend,
						 
					      success: function (response) {
					   
					    	//alert("kal"+response);
					    	 
					    	 if(response>0){
					    		 
					    		 
					    		  $('#addseainfo_dialogue').dialog('close');
						  $('#action_alert').html('<p style="margin: 0px !important;">Data added Successfully</p>');
							$("html,body").animate({scrollTop:$('#action_alert').offset().top-175}, 500);
							
							
						    $("#projSeaAyacutCap").trigger("reset");
						    
						  
						    
						    
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
				            	 
				            	 $('form[id=projSeaAyacutCap]').parsley().validate();
				            	 
				             }
		

	
	}
	if(editinfo=="true"){
		
	//	alert("coming to edit");
		
		UpdateSeaAyacutInfo();
		
	}
	
	
}

function ViewSeaAyacutInfo(projectId,projectname){
	
	 $('#viewseainfo_dialogue').dialog('option', 'title', 'View Info of '+projectname);
	  $('#viewseainfo_dialogue').dialog('open');
	
	$("#doc-thead1").empty();
	$("#doc-tbody1").empty();
	
	 $.ajax({	          
			url: "../comptsimis/view-proj-season-byproject" ,
			method:"GET",
			dataType: 'json',

			async: false,
			data: {
				  
				projectId:projectId,
				
				  
			},


			success: function (obj) {

				  
				// console.log(obj);
				    //	  var obj = JSON.parse(msg);
				
				    	  var j=1;
				    	  
				    	//alert("kalhere");
				    	    $('#v_sea_form table thead').append( '<tr style="font-size: 18px; color: gray; font-weight: bold;"><th>Sl.No</th>'+
				    	    		
				    	    		'<th>Season</th>'+
				    	    	
				    	    		/*'  <th>Latest</th>'+*/
				    	    		'  <th>Action Plan Year</th>'+
				    	    		
				    	    		' <th>Present water Level</th>'+
				    	    		
				    	    		'  <th>Present water Capacity</th>'+
				    	    		
				    	    		'  <th>Net Availability of water for  </th>'+
				    	    	
				    	    		'  <th>Water Utilized </th>'+
				    	    		'  <th>Water required </th>'+
				    	    		'  <th>No of Wettings </th>'+
				    	    		'  <th>Observation Date </th>'+
				    	    		'  <th>Remarks</th>'+
				    	    		
				    	    		
				    	    		
				    	    		
				    	    		'</tr>'); 	  
				    	    
				    	    for(i in obj){
				    	    	
				    	    	var s= obj[i].projectId ;
				    	    	
				    	    
				    	    	if(projectId==s){
				    	    	   $('#v_sea_form table tbody').append(  '<tr style="font-size: 16px">' +
				    	    			                                '<td style="text-align: center;">'+j+'</td>' +
				    	    			                               
				    	    			                                '<td><b>'+obj[i].seasonName+'</b></td>' +
				    	    			                             
				    	    			                                /*'<td><b>'+obj[i].latestRemarks+'</b></td>' +*/
				    	    			                                
				    	    			                                '<td><b>'+obj[i].actplanYear+'</b></td>' +
				    	    			                                '<td><b>'+obj[i].preWaterLevel+'</b></td>' +
				    	    			                                '<td><b>'+obj[i].preWaterCap+'</b></td>' +
				    	    			                                
				    	    			                                '<td><b>'+obj[i].BalWaterRequired+'</b></td>' +
				    	    			                                
				    	    			                                '<td><b>'+obj[i].waterUtil+'</b></td>' +
				    	    			                                
				    	    			                                '<td><b>'+obj[i].waterRequired+'</b></td>' +
				    	    			                                '<td><b>'+obj[i].noOfWettings+'</b></td>' +
				    	    			                                
				    	    			                                '<td><b>'+obj[i].ObsDate+'</b></td>' +
				    	    			                                
				    	    			                                '<td><b>'+obj[i].remarks+'</b></td>' +
				    	    			                              
				    	    	   '</tr>');
				    	    	   
				    	    	}
				    	    	   
				    	    	   j++;
				    	    	   
				    	    
				    	    }
				    
				    	  /*  $(".capacityremadd").hide();
					    	  $(".capacityedit").hide();
					    	  $(".capacitydelete").hide();*/
					    	 
					    	  
					    	  
				    	    
				    	
				  
			
				 
				 
			
				
			

			},
			error : function(){
				 alert(error);

			}
			}); 
	
	
	
	
}


function ViewEditSeaAyacutInfo(projectId,projectname){
	
	 $('#viewEditseainfo_dialogue').dialog('option', 'title', 'view/edit Info of '+projectname);
	  $('#viewEditseainfo_dialogue').dialog('open');
	
	$("#doc-edit-thead1").empty();
	$("#doc-edit-tbody1").empty();
	
	 $.ajax({	          
			url: "../comptsimis/view-proj-season-byproject" ,
			method:"GET",
			dataType: 'json',

			async: false,
			data: {
				  
				projectId:projectId,
				
				  
			},


			success: function (obj) {

				  
				// console.log(obj);
				    //	  var obj = JSON.parse(msg);
				
				    	  var j=1;
				    	  
				    	//alert("kalhere");
				    	    $('#v_edit_sea_form table thead').append( '<tr style="font-size: 18px; color: gray; font-weight: bold;"><th>Sl.No</th>'+
				    	    		
				    	    		'<th>Season</th>'+
				    	    	
				    	    		/*'  <th>Latest</th>'+*/
				    	    		'  <th>Action Plan Year</th>'+
				    	    		
				    	    		' <th>Present water Level</th>'+
				    	    		
				    	    		'  <th>Present water Capacity</th>'+
				    	    		
				    	    		'  <th>Net Availability of water for  </th>'+
				    	    	
				    	    		'  <th>Water Utilized </th>'+
				    	    		'  <th>Water required </th>'+
				    	    		'  <th>No of Wettings</th>'+
				    	    		'  <th>Observation Date </th>'+
				    	    		'  <th>Remarks</th>'+
				    	    		'  <th>Action</th>'+
				    	    		
				    	    		
				    	    		
				    	    		'</tr>'); 	  
				    	    
				    	    for(i in obj){
				    	    	
				    	    	var s= obj[i].projectId ;
				    	    	
				    	    
				    	    	if(projectId==s){
				    	    	   $('#v_edit_sea_form table tbody').append(  '<tr style="font-size: 16px">' +
				    	    			                                '<td style="text-align: center;">'+j+'</td>' +
				    	    			                               
				    	    			                                '<td><b>'+obj[i].seasonName+'</b></td>' +
				    	    			                             
				    	    			                                /*'<td><b>'+obj[i].latestRemarks+'</b></td>' +*/
				    	    			                                
				    	    			                                '<td><b>'+obj[i].actplanYear+'</b></td>' +
				    	    			                                '<td><b>'+obj[i].preWaterLevel+'</b></td>' +
				    	    			                                '<td><b>'+obj[i].preWaterCap+'</b></td>' +
				    	    			                                
				    	    			                                '<td><b>'+obj[i].BalWaterRequired+'</b></td>' +
				    	    			                                
				    	    			                                '<td><b>'+obj[i].waterUtil+'</b></td>' +
				    	    			                                
				    	    			                                '<td><b>'+obj[i].waterRequired+'</b></td>' +
				    	    			                                '<td><b>'+obj[i].noOfWettings+'</b></td>' +
				    	    			                                
				    	    			                                '<td><b>'+obj[i].ObsDate+'</b></td>' +
				    	    			                                
				    	    			                                '<td><b>'+obj[i].remarks+'</b></td>' +
				    	    			                                
				    	    			                                '<td><b><button type="button" name="showtanksname" id="showtanksdata"  class="btn btn-1 btn-primary center-block " onclick="EditSeaAyacutInfo('+obj[i].projectseasonId+')" >Edit </button></b></td>' +
				    	    			                              
				    	    	   '</tr>');
				    	    	   
				    	    	}
				    	    	   
				    	    	   j++;
				    	    	   
				    	    
				    	    }
				    
				    	  /*  $(".capacityremadd").hide();
					    	  $(".capacityedit").hide();
					    	  $(".capacitydelete").hide();*/
					    	 
					    	  
					    	  
				    	    
				    	
				  
			
				 
				 
			
				
			

			},
			error : function(){
				 alert(error);

			}
			}); 
	
	
	
	
}

function ViewDeleteSeaAyacutInfo(projectId,projectname){
	
	 $('#viewDeleteseainfo_dialogue').dialog('option', 'title', 'view/delete Info of '+projectname);
	  $('#viewDeleteseainfo_dialogue').dialog('open');
	
	$("#doc-delete-thead1").empty();
	$("#doc-delete-tbody1").empty();
	
	 $.ajax({	          
			url: "../comptsimis/view-proj-season-byproject" ,
			method:"GET",
			dataType: 'json',

			async: false,
			data: {
				  
				projectId:projectId,
				
				  
			},


			success: function (obj) {

				  
				// console.log(obj);
				    //	  var obj = JSON.parse(msg);
				
				    	  var j=1;
				    	  
				    	//alert("kalhere");
				    	    $('#v_delete_sea_form table thead').append( '<tr style="font-size: 18px; color: gray; font-weight: bold;"><th>Sl.No</th>'+
				    	    		
				    	    		'<th>Season</th>'+
				    	    	
				    	    		/*'  <th>Latest</th>'+*/
				    	    		'  <th>Action Plan Year</th>'+
				    	    		
				    	    		' <th>Present water Level</th>'+
				    	    		
				    	    		'  <th>Present water Capacity</th>'+
				    	    		
				    	    		'  <th>Net Availability of water for  </th>'+
				    	    	
				    	    		'  <th>Water Utilized </th>'+
				    	    		'  <th>Water required </th>'+
				    	    		'  <th>No of Wettings </th>'+
				    	    		'  <th>Observation Date </th>'+
				    	    		'  <th>Remarks</th>'+
				    	    		'  <th>Action</th>'+
				    	    		
				    	    		
				    	    		
				    	    		'</tr>'); 	  
				    	    
				    	    for(i in obj){
				    	    	
				    	    	var s= obj[i].projectId ;
				    	    	
				    	    
				    	    	if(projectId==s){
				    	    	   $('#v_delete_sea_form table tbody').append(  '<tr style="font-size: 16px">' +
				    	    			                                '<td style="text-align: center;">'+j+'</td>' +
				    	    			                               
				    	    			                                '<td><b>'+obj[i].seasonName+'</b></td>' +
				    	    			                             
				    	    			                                /*'<td><b>'+obj[i].latestRemarks+'</b></td>' +*/
				    	    			                                
				    	    			                                '<td><b>'+obj[i].actplanYear+'</b></td>' +
				    	    			                                '<td><b>'+obj[i].preWaterLevel+'</b></td>' +
				    	    			                                '<td><b>'+obj[i].preWaterCap+'</b></td>' +
				    	    			                                
				    	    			                                '<td><b>'+obj[i].BalWaterRequired+'</b></td>' +
				    	    			                                
				    	    			                                '<td><b>'+obj[i].waterUtil+'</b></td>' +
				    	    			                                
				    	    			                                '<td><b>'+obj[i].waterRequired+'</b></td>' +
				    	    			                                '<td><b>'+obj[i].noOfWettings+'</b></td>' +
				    	    			                                
				    	    			                                '<td><b>'+obj[i].ObsDate+'</b></td>' +
				    	    			                                
				    	    			                                '<td><b>'+obj[i].remarks+'</b></td>' +
				    	    			                                
				    	    			                                '<td><b><button type="button" name="showtanksname" id="showtanksdata"  class="btn btn-1 btn-danger center-block " onclick="DeleteSeaAyacutInfo('+obj[i].projectseasonId+')" >Delete </button></b></td>' +
				    	    			                              
				    	    	   '</tr>');
				    	    	   
				    	    	}
				    	    	   
				    	    	   j++;
				    	    	   
				    	    
				    	    }
				    
				    	  /*  $(".capacityremadd").hide();
					    	  $(".capacityedit").hide();
					    	  $(".capacitydelete").hide();*/
					    	 
					    	  
					    	  
				    	    
				    	
				  
			
				 
				 
			
				
			

			},
			error : function(){
				 alert(error);

			}
			}); 
	
	
	
	
}

function EditSeaAyacutInfo(projSeasonId){
	
	 $('#viewEditseainfo_dialogue').dialog('close');
	
	
	 $("#projSeaAyacutCap").trigger("reset");
	
	 $('#addseainfo_dialogue').dialog('option', 'title', 'Edit Capacity Kharif/Rabi ');
	  $('#addseainfo_dialogue').dialog('open');
	  
		$('#seasonId').removeAttr('disabled');
		
		$('.vana').show();
		$('.yasa').show();
		
		  $('#hiddenseasonId').attr('name', 'seasonId');
	  
	//  alert("projectId"+projectId);
	  
	//  $('#hiddenprojectSeasonId').val(projSeasonId);
	  
	/*  $('#preWaterLevel').removeClass("hideedit");	
		$('#preWaterCap').removeClass("hideedit");	
		$('#waterUtil').removeClass("hideedit");
		$('#BalWaterRequired').removeClass("hideedit");	
		
		$('#waterRequired').removeClass("hideedit");	*/
	
		 
		 $.ajax({	          
				url: "../comptsimis/get-proj-season-byseasonId" ,
				method:"GET",
				dataType: 'json',

				async: false,
				data: {
					  
					projectseasonId:projSeasonId,
					
					  
				},


				success: function (obj) {

					  
					if(obj!=null ){
						//	$('#tankFeedRemarks').hide();
							var seasonId=obj.seasonId;
							var actplanYear=obj.actplanYear;
							var preWaterLevel=obj.preWaterLevel;
							var preWaterCap=obj.preWaterCap;
							var waterUtil=obj.waterUtil;
							var BalWaterRequired=obj.BalWaterRequired
							var waterRequired=obj.waterRequired;
							var ObsDate=obj.ObsDate;
							var projectseasonId=obj.projectseasonId;
							var remarks=obj.remarks;
							var noOfWettings=obj.noOfWettings;
							
						
							$('#seasonId').val(seasonId);
							$('#actplanYear').val(actplanYear);
							$('#preWaterLevel').val(preWaterLevel);
							$('#preWaterCap').val(preWaterCap);
							$('#waterUtil').val(waterUtil);
							$('#BalWaterRequired').val(BalWaterRequired);
							$('#waterRequired').val(waterRequired);
							$('#noOfWettings').val(noOfWettings);
							$('#ObsDate').val(ObsDate);
							$('#hiddenprojectseasonId').val(projectseasonId);
							
							$('#remarks').val(remarks);
							
							$('#seasonId').attr('disabled', true);
							
							  $('#hiddenseasonId').val(seasonId);
							
							$('#editFlag').val(true);
							
							/*if(preWaterLevel==0){
								
								$('#preWaterLevel').addClass("hideedit");	
								
							}if(preWaterCap==0){
								
								$('#preWaterCap').addClass("hideedit");	
								
							}
                            if(waterUtil==0){
								
								$('#waterUtil').addClass("hideedit");	
								
							}           
                                  if(BalWaterRequired==0){
								
								$('#BalWaterRequired').addClass("hideedit");	
								
							} 
                                  
                                  if(waterRequired==0){
      								
      								$('#waterRequired').addClass("hideedit");	
      								
      							} 
							
                                  $('.hideedit').hide();*/
							
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


function UpdateSeaAyacutInfo(){
	
	//alert("UpdateSeaAyacutInfo"+UpdateSeaAyacutInfo);
	
	if ($('form[id=projSeaAyacutCap]').parsley().isValid()) {
	
	var finaldatatoSend=$('form[id=projSeaAyacutCap]').serialize();
	
		 
		 $.ajax({	          
				url: "../comptsimis/update-proj-season-byseasonId" ,
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
							 $('#action_alert').html('<p style="margin: 0px !important;">Failed to delete</p>');
							 $("html,body").animate({scrollTop:0}, 500);
						} 
					    	
			
				},
				error : function(){
					 alert(error);

				}
				}); 
	  }else{
     	 
     	 $('form[id=projSeaAyacutCap]').parsley().validate();
     	 
      }
	
}



function DeleteSeaAyacutInfo(projSeasonId){
	
	//alert("UpdateSeaAyacutInfo"+UpdateSeaAyacutInfo);
	

	
		 
		 $.ajax({	          
				url: "../comptsimis/delete-proj-season-byseasonId" ,
				method:"GET",
				dataType: 'json',

				async: false,
				   data:{
					   
						projectseasonId:projSeasonId,
				   },


				success: function (obj) {

					  
					if(obj!=null || obj>0 ){
						
						 $('#action_alert').html('<p style="margin: 0px !important;"> Data deleted successfully</p>');
						 $("html,body").animate({scrollTop:0}, 500);
						 $('#viewDeleteseainfo_dialogue').dialog('close');
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
