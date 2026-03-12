
$(document).ready(function(){
	
	//$("#nextPostId").('select>option:eq(1)').prop('selected', true);
	// $("#nextPostId").val($("#nextPostId option:first").val());
	
	
	 var d = new Date();
	  var e=new Date();
	
	 e= e.getFullYear() ;
	
   for (var i = 1; i >= 1; i--) {
	   
	  var dataval=parseInt(e);
	 //  alert("dataval"+dataval);
	   $('#year').val(dataval);
 	
       //var option = '<option value="'+dataval+'" selected="selected" >'+dataval+'</option>'
      // alert(option);
       
      
      // $('#year').multiselect('rebuild');
       e++;
      // j++;
       
   }
	
		 
	$('#districtId').multiselect({
		 
		 enableCaseInsensitiveFiltering: true
		 
	});

	$('#mandalId').multiselect({
		 
		 enableCaseInsensitiveFiltering: true
		 
	});

	$('#villageId').multiselect({
		 
		 enableCaseInsensitiveFiltering: true
		 
	});
	
	/*$('#tankId').multiselect({
		 
		 enableCaseInsensitiveFiltering: true
		 
	});*/
	
	$('#habitationId').multiselect({
		 
		 enableCaseInsensitiveFiltering: true
		 
	});
	
	/*$('#empId').multiselect({
		 
		 enableCaseInsensitiveFiltering: true
		 
	});*/
	
	$('#nextPostId').multiselect({
		 
		 enableCaseInsensitiveFiltering: true
		 
	});
	
	
	 
	
	
	
	
	$('#miTankFreqId').multiselect({
		 
		 enableCaseInsensitiveFiltering: true
		 
	});
	
	/*$('#year').multiselect({
		 
		 enableCaseInsensitiveFiltering: true
		 
	});*/
	
	$('#sluiceId').multiselect({
		 
		 enableCaseInsensitiveFiltering: true
		 
	});
	 $('#editsluice').hide();
	
	
	$('#weirId').multiselect({
		 
		 enableCaseInsensitiveFiltering: true
		 
	});

	
	 $('#editweirname').hide();
	$('#tankStatusId').multiselect({
		 
		 enableCaseInsensitiveFiltering: true
		 
	});
	
	$('#editUnitId').multiselect({
		 
		 enableCaseInsensitiveFiltering: true
		 
	});
	
	$('#editCircleId').multiselect({
		 
		 enableCaseInsensitiveFiltering: true
		 
	});
	
	$('#editDivisionId').multiselect({
		 
		 enableCaseInsensitiveFiltering: true
		 
	});
	
	$('#editSubDivisionId').multiselect({
		 
		 enableCaseInsensitiveFiltering: true
		 
	});
	
	$('#damageType').multiselect({
		 
		 enableCaseInsensitiveFiltering: true
		 
	});
	
	
	
	
	$('#editankStatus').hide();
	
	
	
	$('.editemb').hide();
	$('.deleteemb').hide();
	$('.editslu').hide();
	$('.deleteslu').hide();
	$('.editweir').hide();
	$('.deleteweir').hide();
	
	$('#repairdataupdate').hide();
	$('#inflowdataupdate').hide();
	$('#capacitydataupdate').hide();
	$('#feeddataupdate').hide();
	
	$('#editRepairdesc').hide();
	
	$('#deleteRepairdesc').hide();
	
	

	  $('#editRepairmain').hide();
	   $('#deleteRepairmain').hide();
	   
	   $('#addRepairmain').hide();
	   
	  $('.bunddate').hide();
	  $('.bundobs').hide();
	  $('.bundactreq').hide();
	  
	  $('.slupdate').hide();
	  $('.sluactreq').hide();
	  $('.sluop').hide();
	  
	  
	  $('.weirpagedate').hide();
	  $('.weiractreq').hide();
	  $('.weirpageobs').hide();
	  
	  
	  
	  
	  
	  //form20 vars start
	  
	/*  $('#flreg').hide();
	  $('#flrain').hide();
	  
	  $('#flbld').hide();
	  
	  for(var i=1 ; i<10; i++){
		  
		  var str="#flani"+i;
		  
		  $(str).hide();
	  }*/
	 
	//  $('#flwr').hide();
	///  $('#flsl').hide();
	//  $('#flret').hide();
	///  $('#flapr').hide();
	// $('#fltb').hide();
	//  $('#flcha').hide();
	 // $('#floth').hide();
	  
	 
	  
	  
	  
	  
	  //form20 vars end
	  
	  
	
	  
	  
	  
		
		
	   
	   
	   
	  
			  var id =  $("#nextPostId").val();
	//		  alert("nextPostId" +id);
			  if(id!=null){
			  if(parseInt(id)>0){
			  $("#nextPostId1").val(id);
			
			  $('#nextPostId2').val(id);
			  $('#nextPostId3').val(id);
			//  $('#empId4').val(id);
			  $('#nextPostId5').val(id);
			  $('#nextPostId6').val(id);
			  $('#nextPostId7').val(id);
			//  $('#nextPostId8').val(id);
			  $('#editnextPostId').val(id);
			  }
			  }
			  
			  
			  var nextempid =  $("#nextEmpId").val();
				//		  alert("nextempid" +nextempid);
						  if(nextempid!=null){
						  if(parseInt(nextempid)>0){
						  $("#nextEmpId1").val(nextempid);
						
						  $('#nextEmpId2').val(nextempid);
						  $('#nextEmpId3').val(nextempid);
						//  $('#empId4').val(nextempid);
						  $('#nextEmpId5').val(nextempid);
						  $('#nextEmpId6').val(nextempid);
						  $('#nextEmpId7').val(nextempid);
						 // $('#nextEmpId8').val(nextempid);
						  $('#editnextEmpId').val(nextempid);
						  }
						  }
			  
		

	

	}); 


function getMandals(b,hkey){
	
	//alert("kal"+b);

	
	var districtId=b
		//document.getElementById("districtId").value;
	
	//alert(districtId);
	
	if(hkey==1){
		$('#mandalId').multiselect('rebuild');
	}
		
		
		
		if(hkey==2){
			$('#editmandalId').multiselect('rebuild');
			}
		
		if(hkey==3){
			$('#infomandalId').multiselect('rebuild');
			}

	$.ajax({	          
	      url: "../web/getMandals?districtId="+districtId,
	      type: "GET",
	      success: function (response) {
	    	  
	    		
				if(hkey==1){
					  var $select = $('#mandalId');
					var selectedMandal=0;
					
					$('#mcode').val(0);
					  
				}
				if(hkey==2){
					  var $select = $('#editmandalId');
					  var selectedMandal=$('#selecteditMandalId').val();
					}
				
				if(hkey==3){
					  var $select = $('#infomandalId');
					  
					  var selectedMandal=$('#selectinfoMandalId').val();
					}
	    	
			  $select.find('option').remove();
			  
			
			//  alert("selected"+selectedMandal);
			  if(hkey==1){
			  $('#mandalId').append( '<option value=" "> --select--</option>' );
			  }
			  if(hkey==2){
				  $('#editmandalId').append( '<option value=" "> --select--</option>' );
				  }
			  if(hkey==3){
				  $('#infomandalId').append( '<option value=" "> --select--</option>' );
				  }
					var obj = JSON.parse(response);
					$.each(obj, function(key, value) {
						
						if(hkey==1){
						
						if(selectedMandal==value.mandalId){	
							//alert("coming1");
							$('#mandalId').append( '<option value="'+value.mandalId+'" selected="selected" > '+value.mandalName+'</option>' );
							$('#mcode').val(value.mandalCode);
						}
						if(selectedMandal==null||selectedMandal!=value.mandalId){
							//alert("coming2");
							$('#mandalId').append( '<option value="'+value.mandalId+'"  > '+value.mandalName+'</option>' );
							$('#mcode').val(value.mandalCode);
						
						}
						$('#mandalId').multiselect('rebuild');
						
						}	
						if(hkey==2){
							
							if(selectedMandal==value.mandalId){	
								//alert("coming1");
								$('#editmandalId').append( '<option value="'+value.mandalId+'" selected="selected" > '+value.mandalName+'</option>' );
							}
							if(selectedMandal==null||selectedMandal!=value.mandalId){
								//alert("coming2");
								$('#editmandalId').append( '<option value="'+value.mandalId+'"  > '+value.mandalName+'</option>' );
							
							}
							$('#editmandalId').multiselect('rebuild');
							
							}	
		  	  				
						if(hkey==3){
							
							if(selectedMandal==value.mandalId){	
								//alert("coming1");
								$('#infomandalId').append( '<option value="'+value.mandalId+'" selected="selected" > '+value.mandalName+'</option>' );
							}
							if(selectedMandal==null||selectedMandal!=value.mandalId){
								//alert("coming2");
								$('#infomandalId').append( '<option value="'+value.mandalId+'"  > '+value.mandalName+'</option>' );
							
							}
							$('#infomandalId').multiselect('rebuild');
							
							}	
		  	  				
	  	  				
					});

	      },
	      error : function(){
	    	  alert(error);
	      }
	  });	
	} 


/*function getconstiuencies(districtId,hkey){
	
	
	var districtId=districtId
	//document.getElementById("districtId").value;

//alert(districtId);

if(hkey==1){
	$('#constId').multiselect('rebuild');
}
	
	
	

$.ajax({	          
      url: "../invtsimis/constlist?districtId="+districtId,
      type: "GET",
      success: function (response) {
    	  
    		
			if(hkey==1){
				  var $select = $('#constId');
				var selectedconstId=0;
				  
			}
			
			
    	
		  $select.find('option').remove();
		  
		
		//  alert("selected"+selectedMandal);
		  if(hkey==1){
		  $('#constId').append( '<option value=" "> --select--</option>' );
		  }
		  
				var obj = JSON.parse(response);
				$.each(obj, function(key, value) {
					
					if(hkey==1){
					
					if(selectedconstId==value.constId){	
						//alert("coming1");
						$('#constId').append( '<option value="'+value.constId+'" selected="selected" > '+value.constName+'</option>' );
					}
					if(selectedconstId==null||selectedconstId!=value.constId){
						//alert("coming2");
						$('#constId').append( '<option value="'+value.constId+'"  > '+value.constName+'</option>' );
					
					}
					$('#constId').multiselect('rebuild');
					
					}	
					
  	  				
				});

      },
      error : function(){
    	  alert(error);
      }
  });	
	
	
}*/

	function getVillages(mandal,hkey){
		//alert("kal");
		//var districtId=document.getElementById("districtId").value;
		var mandalId=mandal;
			//document.getElementById("mandalId").value;
		//alert(mandalId);
		
		if(hkey==1){
			$('#villageId').multiselect('rebuild');
			
			$('#vcode').val(0);
		}
			
			
			
			if(hkey==2){
				$('#editvillageId').multiselect('rebuild');
				}
			
			if(hkey==3){
				$('#infovillageId').multiselect('rebuild');
				}

	
		  $.ajax({	          
	      url: "../web/getVillages?mandalId="+mandalId,
	      type: "GET",
	      success: function (response) {
	    	  
	    		if(hkey==1){
	    			  var $select = $('#villageId');
					var selectedVillage=0;
					
					  $select.find('option').remove();
					 
					  
				}
				if(hkey==2){
					  var $select = $('#editvillageId');
					  var selectedVillage=$('#selecteditVillageId').val();
					  $select.find('option').remove();
					}
				
				if(hkey==3){
					  var $select = $('#infovillageId');
					  
					  var selectedVillage=$('#selectinfoVillageId').val();
					  $select.find('option').remove();
					}
	    	
	    	
			 
					var obj = JSON.parse(response);
					
					 if(hkey==1){
						 $('#villageId').append( '<option value="0"> --select--</option>' );
						  }
						  if(hkey==2){
							  $('#editvillageId').append( '<option value=" "> --select--</option>' );
							  }
						  if(hkey==3){
							  $('#infovillageId').append( '<option value=" "> --select--</option>' );
							  }
					 
					  
					$.each(obj, function(key, value) {
						
						if(hkey==1){
							
							if(selectedVillage==value.villageId){	
								
								$('#villageId').append( '<option value="'+value.villageId+'"  selected="selected" > '+value.villageName+'</option>' );
								
								$('#vcode').val(value.villageCode);
								
							}
							if(selectedVillage==null||selectedVillage!=value.villageId){
								//alert("coming2");
								$('#villageId').append( '<option value="'+value.villageId+'"   > '+value.villageName+'</option>' );
								$('#vcode').val(value.villageCode);
							}
							$('#villageId').multiselect('rebuild');
							
							}	
						
if(hkey==2){
							
							if(selectedVillage==value.villageId){	
								
								$('#editvillageId').append( '<option value="'+value.villageId+'"  selected="selected" > '+value.villageName+'</option>' );
								
								
								
							}
							if(selectedVillage==null||selectedVillage!=value.villageId){
								//alert("coming2");
								$('#editvillageId').append( '<option value="'+value.villageId+'"   > '+value.villageName+'</option>' );
							
							}
							$('#editvillageId').multiselect('rebuild');
							
							}	
						

if(hkey==3){
	
	if(selectedVillage==value.villageId){	
		
		$('#infovillageId').append( '<option value="'+value.villageId+'"  selected="selected" > '+value.villageName+'</option>' );
		
		
		
	}
	if(selectedVillage==null||selectedVillage!=value.villageId){
		//alert("coming2");
		$('#infovillageId').append( '<option value="'+value.villageId+'"   > '+value.villageName+'</option>' );
	
	}
	$('#infovillageId').multiselect('rebuild');
	
	}	

	  	  				
					});
	    	 

	      },
	      error : function(){
	    	  alert(error);
	      }
	  }); 	
	}
	
	
	
	function getHabitations(districtId,mcode,vcode,hkey){
		//alert("kal");
		//var districtId=document.getElementById("districtId").value;
		var districtId=districtId;
		var mcode=parseInt(mcode);
		//alert(mcode);
		var vcode=parseInt(vcode);
		//alert(vcode);
			//document.getElementById("mandalId").value;
		//alert(mandalId);
		
		if(hkey==1){
			$('#habitationId').multiselect('rebuild');
		}
			
			
			
			if(hkey==2){
				$('#habitationId').multiselect('rebuild');
				}
			
			if(hkey==3){
				$('#habitationId').multiselect('rebuild');
				}

			
		  $.ajax({	          
	      url: "../invtsimis/getHabitations?dId="+districtId+"&mId="+mcode+"&vId="+vcode,
	      type: "GET",
	      success: function (response) {
	    	  
	    		if(hkey==1){
	    			  var $select = $('#habitationId');
					var selectedHabit=0;
					
					  $select.find('option').remove();
					  
				}
				
				   	
			 
					var obj = JSON.parse(response);
					
					 if(hkey==1){
						 $('#habitationId').append( '<option value="0"> --select--</option>' );
						  }
						 
					 
					  
					$.each(obj, function(key, value) {
						
						if(hkey==1){
							
							if(selectedHabit==value.hId){	
								
								$('#habitationId').append( '<option value="'+value.hId+'"  selected="selected" > '+value.hname+'</option>' );
								
								
								
							}
							if(selectedHabit==null||selectedHabit==0||selectedHabit!=value.hId){
								//alert("coming2");
								$('#habitationId').append( '<option value="'+value.hId+'"   > '+value.hname+'</option>' );
							
							}
							$('#habitationId').multiselect('rebuild');
							
							}	
						


	  	  				
					});
	    	 

	      },
	      error : function(){
	    	  alert(error);
	      }
	  }); 	
	}
	
	function getTanks(districtId,mcode,vcode,hcode,hkey){
		
		//alert("kal"+b);

		
		var districtId=districtId;
		var mcode=parseInt(mcode);
		var vcode=parseInt(vcode);
		var hcode=parseInt(hcode);
		
			//document.getElementById("districtId").value;
		
		//alert(districtId);
		
		if(hkey==1){
			$('#tankId').multiselect('rebuild');
		}
			
			
			
			if(hkey==2){
				$('#edittankId').multiselect('rebuild');
				}
			
			if(hkey==3){
				$('#infotankId').multiselect('rebuild');
				}

	

		$.ajax({	          
		      url: "../invtsimis/getTanks?dId="+districtId+"&mId="+mcode+"&vId="+vcode+"&hId="+hcode,
		      type: "GET",
		      success: function (response) {
		    	  
		    	  if(hkey==1){
	    			  var $select = $('#tankId');
	    			  var selectedTank=0;
					  
				}
		    	  if(hkey==2){
	    			  var $select = $('#edittankId');
					var selectedTank=  $('#selecteditTankId').val();
					  
				}
		    	  if(hkey==3){
	    			  var $select = $('#infotankId');
					var selectedTank= $('#selectinfoTankId').val();
					  
				}
		    	
				  $select.find('option').remove();
				  
			
				//  alert("selected"+selectedMandal);
				  
				  if(hkey==1){
					  $('#tankId').append( '<option value=" "> --select--</option>' );
						  }
				  
				  if(hkey==2){
					  $('#edittankId').append( '<option value=" "> --select--</option>' );
						  }
				  
				  if(hkey==3){
					  $('#infotankId').append( '<option value=" "> --select--</option>' );
						  }
				 
				 
				
						var obj = JSON.parse(response);
						$.each(obj, function(key, value) {
							  if(hkey==1){	
								  $('#constId').val(value.acCode);
								  $('#constName').val(value.constName);
								  
							if(selectedTank==value.tankId){	
								//alert("coming1");
								$('#tankId').append( '<option value="'+value.tankId+'" selected="selected" > '+value.tankName+'</option>' );
							}
							if(selectedTank==null||selectedTank!=value.tankId){
								//alert("coming2");
								$('#tankId').append( '<option value="'+value.tankId+'"  > '+value.tankName+'</option>' );
							
							}
							
			  					
		  	  				$('#tankId').multiselect('rebuild');
		  	  				
		  	  		/*	$('#grossCapacity').val(value.capacitytank);
		  	  		$('#geoTagId').val(value.geoTagId);*/
		  	  			
							  }
							  
							  if(hkey==2){	
									if(selectedTank==value.tankId){	
										//alert("coming1");
										$('#edittankId').append( '<option value="'+value.tankId+'" selected="selected" > '+value.tankName+'</option>' );
									}
									if(selectedTank==null||selectedTank!=value.tankId){
										//alert("coming2");
										$('#edittankId').append( '<option value="'+value.tankId+'"  > '+value.tankName+'</option>' );
									
									}
									
					  					
				  	  				$('#edittankId').multiselect('rebuild');
									  }
							  
							  if(hkey==3){	
									if(selectedTank==value.tankId){	
										//alert("coming1");
										$('#infotankId').append( '<option value="'+value.tankId+'" selected="selected" > '+value.tankName+'</option>' );
									}
									if(selectedTank==null||selectedTank!=value.tankId){
										//alert("coming2");
										$('#infotankId').append( '<option value="'+value.tankId+'"  > '+value.tankName+'</option>' );
									
									}
									
					  					
				  	  				$('#infotankId').multiselect('rebuild');
									  }
						});

		      },
		      error : function(){
		    	  alert(error);
		      }
		  });	
		} 
	
	
	/* function postmitankchecks(){
		
		
		
		
		
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
		
	} */
	
  // getcheckfalse
	
	/* $('.schedulecuscheck2').prop('checked', false);
	$('.schedulecuscheck3').prop('checked', false);
	$('.schedulecuscheck4').prop('checked', false);
	$('.schedulecuscheck5').prop('checked', false);
	$('.schedulecuscheck6').prop('checked', false); */
	
	function getcheckfalse4(){	
		
		$('.micheckbutton').hide();
		$('#action_alert').empty();
		$("#miTankFreqId").prop('required',false);
		$("#year").prop('required',false);
		$('#freqid').hide();
		$('#yearid').hide();
		$('#inflowdataupdate').show();
		$('#repairdataupdate').hide();
		$('#capacitydataupdate').hide();
		
		$('#feeddataupdate').hide();
		$("#tankStatusId").prop('required',false);
		$('#statusid').hide();
		
		
		
	}
	
	function getcheckfalse1(){	
		$('.micheckbutton').hide();
		$('#action_alert').empty();
		$("#miTankFreqId").prop('required',true);
		$("#year").prop('required',true);
		$('#freqid').show();
		$('#yearid').show();
		$("#tankStatusId").prop('required',true);
		$('#statusid').show();
		$("#nextEmpId").prop('required',true);
		$("#nextPostId").prop('required',true);
		
	}
	function getcheckfalse2(){	
		
		
		 
		 
		  
		$('.micheckbutton').hide();
		$('#action_alert').empty();
		$("#miTankFreqId").prop('required',true);
		$("#year").prop('required',true);
		$('#freqid').show();
		$('#yearid').show();
		$("#tankStatusId").prop('required',true);
		$('#statusid').show();
		$("#nextEmpId").prop('required',true);
		$("#nextPostId").prop('required',true);
		
		  
		
	}
	function getcheckfalse3(){	
		$('.micheckbutton').hide();
		$('#action_alert').empty();
		$("#miTankFreqId").prop('required',true);
		$("#year").prop('required',true);
		$('#freqid').show();
		$('#yearid').show();
		$("#tankStatusId").prop('required',true);
		$('#statusid').show();
		$("#nextEmpId").prop('required',true);
		$("#nextPostId").prop('required',true);
		//$('#capacitydataupdate').hide();
		
	}
	
	
	
	function getcheckfalse5(){	
		$('.micheckbutton').hide();
		$('#action_alert').empty();
		$("#miTankFreqId").prop('required',false);
		$("#year").prop('required',false);
		$('#freqid').hide();
		$('#yearid').hide();
		$("#tankStatusId").prop('required',false);
		$('#statusid').hide();
		
	
		$('#inflowdataupdate').hide();
		$('#repairdataupdate').show();
		$('#capacitydataupdate').hide();
		$('#feeddataupdate').hide();
		
		
	}
	
	function getcheckfalse6(){	
		$('.micheckbutton').hide();
		$('#action_alert').empty();
		$("#miTankFreqId").prop('required',false);
		$("#year").prop('required',false);
		$('#freqid').hide();
		$('#yearid').hide();
		$("#nextEmpId").prop('required',true);
		$("#nextPostId").prop('required',true);
		
		$('#capacitydataupdate').show();
		$('#inflowdataupdate').hide();
		$('#repairdataupdate').hide();
		$('#feeddataupdate').hide();
		$("#tankStatusId").prop('required',false);
		$('#statusid').hide();
		
	} 
	
	function getcheckfalse7(){	
		$('.micheckbutton').hide();
		$('#action_alert').empty();
		$("#miTankFreqId").prop('required',false);
		$("#year").prop('required',false);
		$('#freqid').hide();
		$('#yearid').hide();
		
		$('#capacitydataupdate').hide();
		$('#inflowdataupdate').hide();
		$('#repairdataupdate').hide();
		
		$('#feeddataupdate').show();
		$("#tankStatusId").prop('required',false);
		$('#statusid').hide();
		
		
		
	} 
	
	function openmicheckform(mst2Id,tabId,year,count,mst1Id){
		
	
		 $('#micheck_dialogue').dialog('option', 'title', 'Edit MI Tank Check Info');
		  $('#micheck_dialogue').dialog('open');
		  
		  $('#editcheckformid').trigger("reset");
		  
		  $.ajax({	          
				url: "../invtsimis/get-editdata-mst2" ,
				method:"POST",
				dataType: 'json',

				async: false,
				data: {
					  
					miInpsectMst2Id:mst2Id,
					  
					  tabId:tabId
				},


				success: function (obj) {

					  
				//	console.log(obj);
					//  alert("getedit"+obj);
					  if(obj!=null){
						  
					
					//  var obj = JSON.parse(response);
				    
				    	  for(i in obj){
				  
					var mapId ="#editmiInspectMapId";
			
					 var typeId="#editmiInspectTypeId";
					 var compId="#editmiCompId" ;
					  var inDate="#editinspectDate";
					 var actn="#editactionreqn";
					 var acty="#editactionreqy";
					  var reqIddiv ="#editmyactionreqid";
					 var reqid="#editactionrequireqId option";
					 var remarks= "#editremarks";
					 var checkName="#editmiInspectTypeName";
					 
					// alert(obj[i].miInspectTypeName);
					 
					  $(checkName).val(obj[i].miInspectTypeName); 
					  $(mapId).val(obj[i].miInspectMapId); 
					  $(typeId).val(obj[i].miInspectTypeId); 
					  $(inDate).val(obj[i].inspectDate); 
					  $(compId).val(obj[i].miCompId); 
					  
					  if(obj[i].actionreq==false){
						  
						  $(actn).prop('checked', true);
						 
						  
					  }
					  if(obj[i].actionreq==true){
						  
						  $(acty).prop('checked', true);
					  }
					  
					  $(reqid).each(function () {
						//  alert("iam here"+$(this).val()+"--"+obj[i].actionrequireqId)
			    	        if ($(this).val() == obj[i].actionrequireqId) {
			    	            $(this).attr("selected", "selected");
			    	         
			    	            return;
			    	        }
						});
					
					  					
					
					  $(remarks).val(obj[i].remarks); 
					  $('#edittabId').val(tabId); 
					  if(tabId==1||tabId==2||tabId==3){
					  $('#editmiInpsectMst1Id').val(mst1Id); 
					  $('#editmiInpsectMst2Id').val(mst2Id); 
					  
					  
					  }

					  
				    	  }
				    	
					  }
					  if(obj==0||obj==null){
						
						  $('#action_alert').html('<p style="margin: 0px !important;">Failed to get Data</p>');
						  }
					   
					//  gettankfeeddata(tankId) ; 
					

				},
				error : function(){
					 alert(error);

				}
				});
		  
		  
		  
		
	}
	
	//doller function
	
	$(function() {
		
		

		//form20 start 
		
		/*$('.frmchk').click(function(){
			  
			var fchk =  $(this).prop('id');
		
			if(fchk=="regchkid"){
			
			var regchk = $('#regchkid').prop('checked');
			
			if(regchk) {
				
				$('#flreg').show();
			}else{
				
				$('#flreg').hide()
			}
			}else if(fchk=="rainchkid"){
				
				var rainchk = $('#rainchkid').prop('checked');
			
				if(rainchk) {
					
					$('#flrain').show();
				}else{
					
					$('#flrain').hide()
				}
			}else if(fchk=="bldchkid"){
				
				var bldchk = $('#bldchkid').prop('checked');
			
				if(bldchk) {
					
					$('#flbld').show();
				}else{
					
					$('#flbld').hide()
				}
			}else if(fchk=="anichkid1"){
				
				var anchk = $('#anichkid1').prop('checked');
			
				if(anchk) {
					
					$('#flani1').show();
				}else{
					
					$('#flani1').hide()
				}
			}else if(fchk=="anichkid2"){
				
				var wrchk = $('#anichkid2').prop('checked');
				
			
				if(wrchk) {
					
					$('#flani2').show();
				}else{
					
					$('#flani2').hide()
				}
			}else if(fchk=="anichkid3"){
				
				var slchk = $('#anichkid3').prop('checked');
			
				if(slchk) {
					
					$('#flani3').show();
				}else{
					
					$('#flani3').hide()
				}
			}
            else if(fchk=="anichkid4"){
				
				var retchk = $('#anichkid4').prop('checked');
			
				if(retchk) {
					
					$('#flani4').show();
				}else{
					
					$('#flani4').hide()
				}
			}else if(fchk=="anichkid5"){
				
				var aprchk = $('#anichkid5').prop('checked');
			
				if(aprchk) {
					
					$('#flani5').show();
				}else{
					
					$('#flani5').hide()
				}
			}else if(fchk=="anichkid6"){
				
				var tkchk = $('#anichkid6').prop('checked');
			
				if(tkchk) {
					
					$('#flani6').show();
				}else{
					
					$('#flani6').hide()
				}
			}else if(fchk=="anichkid7"){
				
				var chchk = $('#anichkid7').prop('checked');
			
				if(chchk) {
					
					$('#flani7').show();
				}else{
					
					$('#flani7').hide()
				}
			}else if(fchk=="anichkid8"){
				
				var otchk = $('#anichkid8').prop('checked');
			
				if(otchk) {
					
					$('#flani8').show();
				}else{
					
					$('#flani8').hide()
				}
			}
			
			else{
				
				
			}
         	
		}); */
		


		
		/*$('.regacres').blur(function(){
			
			var regsum=0;
			
			 $( ".regacres" ).each(function() {
				
				 
				 var acresval=  parseFloat($(this).val());	   
				 
				 regsum=regsum+acresval;
				 
				// alert("inside"+regsum)
			
			
			 });
			 
			// alert("regsum"+regsum);
			 
			 var regtotid="#"+"regTotalAcres";
			 
			 $(regtotid).val(regsum);
		
		});
		
          $('.pcost').blur(function(){
        	  
        	  var approxid="#"+"approxRepPermanent";
        	  
        	  var approxtt="#"+"approxRepTotal";
			
			var psum=0;
			
			var appsum=0;
			
			 $( ".pcost" ).each(function() {
				
				 
				 var pval=  parseFloat($(this).val());	  
				 
			
				 
				 psum=psum+pval;
				 
			
				 
				// alert("inside"+regsum)
				 $(approxid).val(psum);
				
			
			
			 });
			 
			 
			 $( ".appval" ).each(function() {
 				
				 
				 var apval=  parseFloat($(this).val());	   
				 
				 appsum=appsum+apval;
				 
				// alert("inside"+regsum)
			
				 $(approxtt).val(appsum);	
			 });
			 
			// alert("regsum"+regsum);
		
			 
		
			
			 
			
		});*/
          
         /* $('.tcost').blur(function(){
  			
  			var tsum=0;
  			var appsum=0;
  			
  			 var approxid="#"+"approxRepTemp";
  			 var approxtt="#"+"approxRepTotal";
  			
  			 $( ".tcost" ).each(function() {
  				
  				 
  				 var tval=  parseFloat($(this).val());	   
  				 
  				tsum=tsum+tval;
  				
  				 $(approxid).val(tsum);
  				
  				 var apvat=  parseFloat($('#approxRepTemp').val())>0
  		        
  				
  				// alert("inside"+regsum)
  			
  			
  			 });*/
  			 
  			/* $( ".appval" ).each(function() {
	 				
					 
					 var apval=  parseFloat($(this).val());	   
					 
					 appsum=appsum+apval;
					 
					// alert("inside"+regsum)
				
					 $(approxtt).val(appsum);	
				 });
				 */
  			 
  			// alert("regsum"+regsum);
  			 
  			
  			 
  			
  		
  		//});
          
       
          
      
          
          

		//form30 end
		
		

		
		
		$('#faqSpopup').dialog({
			  autoOpen:false,
			  width:1200,
			  close: function() {
				  
				
					  $(this).dialog("close");
					  }
			 });
		
		
		/*$('#frm20_view_dia').dialog({
			  autoOpen:false,
			  width:1200,
			  close: function() {
				  
				
					  $(this).dialog("close");
					  }
			 });*/
		
		/*$('#frm20_doc_dia').dialog({
			  autoOpen:false,
			  width:1200,
			  close: function() {
				  
				
					  $(this).dialog("close");
					  }
			 });*/
		
		
		
		/*$('#frm20_doc_update').dialog({
			  autoOpen:false,
			  width:1200,
			  close: function() {
				  
				
					  $(this).dialog("close");
					  }
			 });*/
		
		
		
		
		
		
		
		
		$('#confirmdia').dialog({
		    
		    autoOpen:false,
		    width:600,
		    buttons: {
		        confirm: function () {
		            $.alert('Confirmed!');
		        },
		        cancel: function () {
		            $.alert('Canceled!');
		        }
		        
		    }
		});
		



		$('#helpId').click(function(){
				
			 $('#faqSpopup').dialog('option', 'title', 'Clarifications');
			  $('#faqSpopup').dialog('open');
			
			 });
		
		
		
		$('.table1').DataTable( {
	        dom: 'Bfrtip',
	        responsive: true,
	        "paging": false,
	        "ordering": false,
	        "autoWidth": true,
	        "lengthChange": false,
	        "pageLength": 20,
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
	                sheetName: 'Exported_Ayacut_data',
	                text:  'Download Data To Excel',
	                className: 'btn-primary ',
	                messageTop: 'Project Wise Mandal Ayacut Report',
	                exportOptions: {
	                    columns: ':visible'
	                }
	               
	                
	            },
	            
	            {
	                extend: 'pdfHtml5',
	                className: 'btn-primary ',
	                text:  'PDF View / Download',
	                orientation: 'landscape',
	                pageSize: 'A4',
	                download: 'open',
	                font:'10',
	                filename: 'Tanks Info',
	                exportOptions: {
						columns: ':visible'
						
					},
					 
	               
	                title: 'Tanks Info',
	                customize: function (doc) {
	                	doc.defaultStyle.fontfamily ='Arial';
	                	
	                	doc.defaultStyle.fontSize = 10;
	                	doc.defaultStyle.alignment = 'center';
	                	doc.styles.tableHeader.fontSize = 12;
	                	doc.pageMargins = [80, 80, 80,80];
	                	 doc['footer']=(function(page, pages) {
	                      	return {
	                      	columns: [
	                     
	                      	{
	                      	alignment: 'right',
	                      	text: [
	                      	{ text: page.toString(), italics: true },
	                      	' of ',
	                      	{ text: pages.toString(), italics: true }
	                      	]
	                      	}
	                      	],
	                      	margin: [5, 0]
	                      	}
	                      	});
	      				
	                	
	                	
	                	
	                }
					
	               
	            },
	            {
	                extend: 'print',
	                text: 'Print All',
	                className: 'btn-primary ',
	                exportOptions: {
	                    modifier: {
	                        selected: null
	                    },
	                    columns: ':visible'
	                }
	               
	                
	                
	            },
	            ,{
	                extend: 'print',
	                text: 'Print Selected',
	                className: 'btn-primary ',
	                exportOptions: {
	                    columns: ':visible'
	                }
	                
	                
	                
	            },
	            {
	                extend: 'colvis',
	                text: 'Exclude for Print/Export',
	                
	                columnText: function ( dt, idx, title ) {
	                	 return (idx+1)+': '+title;
	                }
	               
	                }
	        ],
	        select: true
	       
	    } );
		
		
		 $('#sluice_dialogue').dialog({
			  autoOpen:false,
			  width:1200,
			  close: function() {
				  
					//  $("#pack_dialogue").empty();
					 
					  $(this).dialog("close");
					  }
			 });
		 
		 
		 $('#weir_dialogue').dialog({
			  autoOpen:false,
			  width:1200,
			  close: function() {
				  
					//  $("#pack_dialogue").empty();
					 
					  $(this).dialog("close");
					  }
			 });
		 
		 $('#review_dialogue').dialog({
			  autoOpen:false,
			  width:1200,
			  close: function() {
				  
				
					  $(this).dialog("close");
					  }
			 });
		 
		 $('#mainform_dialogue').dialog({
			  autoOpen:false,
			  width:1200,
			  close: function() {
				  
				
					  $(this).dialog("close");
					  }
			 });
		 
		 $('#micheck_dialogue').dialog({
			  autoOpen:false,
			  width:1200,
			  close: function() {
				  
				
					  $(this).dialog("close");
					  }
			 });
		 
		 $('#viewRemarks_dialogue').dialog({
			  autoOpen:false,
			  width:1200,
			  close: function() {
				  
				
					  $(this).dialog("close");
					  }
			 });
		 
		 $('#miinfo_dialogue').dialog({
			  autoOpen:false,
			  width:1200,
			  close: function() {
				  
				
					  $(this).dialog("close");
					  }
			 });
		 
		 
		 $('#edittankstatus_dialogue').dialog({
			  autoOpen:false,
			  width:1200,
			  close: function() {
				  
				
					  $(this).dialog("close");
					  }
			 });
		 
		 $('#repairdesc_dialogue').dialog({
			  autoOpen:false,
			  width:1200,
			  close: function() {
				  
				
					  $(this).dialog("close");
					  }
			 });
		 
		 $('#gettanks_dialogue').dialog({
			  autoOpen:false,
			  width:1200,
			  close: function() {
				  
				
					  $(this).dialog("close");
					  }
			 });
		 
		 $('#getanicut_dialogue').dialog({
			  autoOpen:false,
			  width:1200,
			  close: function() {
				  
				
					  $(this).dialog("close");
					  }
			 });
		 
		 $('#getcheckdam_dialogue').dialog({
			  autoOpen:false,
			  width:1200,
			  close: function() {
				  
				
					  $(this).dialog("close");
					  }
			 });
		 
		 
		 $('#showtanksdata').click(function(){
				
			 $('#gettanks_dialogue').dialog('option', 'title', 'View Tanks Info');
			  $('#gettanks_dialogue').dialog('open');
			 
		      
			 });
		 
		 $('#anicutdata').click(function(){
				
			 $('#getanicut_dialogue').dialog('option', 'title', 'View Anicut Info');
			  $('#getanicut_dialogue').dialog('open');
			 
		      
			 });
		 
		 $('#showcheckdamdata').click(function(){
				
			 $('#getcheckdam_dialogue').dialog('option', 'title', 'View CheckDam Info');
			  $('#getcheckdam_dialogue').dialog('open');
			 
		      
			 });
		
		
		 
		
		 
		/* $('#sluiceId').change(function(){
				
				var x=$(this).val();
			//	alert("x"+x);
				
				if(x>0){
				
				$('#editsluice').show();
				} else{
					
					$('#editsluice').hide();
				} 
				
			}); 
		 $('#weirId').change(function(){
				 var x=$(this).val();
			//	alert("x"+x);
				
				if(x>0){
				
				$('#editweirname').show();
				} else{
					
					$('#editweirname').hide();
				} 
				
				
			});*/
		
		 
		 $('#addsluice').click(function(){
				
			 $('#sluice_dialogue').dialog('option', 'title', 'Add Sluice');
			  $('#sluice_dialogue').dialog('open');
			  $('#addsluiceformbutton').show();
			  $('#editsluiceformbutton').hide();
			  
			  $('#sluiceformid').trigger("reset"); 
			 });

		 $('#editsluice').click(function(){
				
			 $('#sluice_dialogue').dialog('option', 'title', 'Edit Sluice');
			  $('#sluice_dialogue').dialog('open');
			  $('#sluiceformid').trigger("reset"); 
			  $('#editsluiceformbutton').show();
			  $('#addsluiceformbutton').hide();
			  $('#action_alert').html(''); 
			 var sid= $('#sluiceId').val();
			//  alert(sid);
			  $.ajax({	          
			      url: "../invtsimis/sluicedata-byid?tankWeirSluiceId="+sid,
			      method:"POST",
				   dataType: 'json',				
			      async: false,
			      success: function (msg) {
			    	// console.log(msg);
			    	if(msg!=null) {
			    		var twsid=msg.tankWeirSluiceId;
			    	//	alert(twsid);
			    		var twsn=msg.tankWeirSluiceName;
			    		var twstid=msg.tankWeirSluiceTypeId;
			    //		alert(twsn);
			    //		alert(twstid);
			    		$('#editsntankWeirSluiceIdhide').val(twsid);
			    		  $('#sluiceName').val(twsn);
			    	}
			    	 
			    	if(msg==0 || msg==null) {
			     		$('#action_alert').html('<p style="margin: 0px !important;">Failed to get data</p>'); 
						  $("html,body").animate({scrollTop:0}, 500);
			    	}	

			      },
			      error : function(){
			    	  alert(error);
			      }
			  });
			
			 });
		 
		 $('#addweir').click(function(){
				
			 $('#weir_dialogue').dialog('option', 'title', 'Add Weir');
			  $('#weir_dialogue').dialog('open');
			  $('#editweirformbutton').hide();
			  $('#addweirformbutton').show();
			  $('#weirformid').trigger("reset"); 
			 });
		 
		 
		 
		 $('#editweirname').click(function(){
				
			 $('#weir_dialogue').dialog('option', 'title', 'Edit Weir Name');
			  $('#weir_dialogue').dialog('open');
			  $('#weirformid').trigger("reset"); 
			  $('#editweirformbutton').show();
			  $('#addweirformbutton').hide();
			  $('#action_alert').html(''); 
			 var wid= $('#weirId').val();
			//  alert(wid);
			    $.ajax({	          
			      url: "../invtsimis/sluicedata-byid?tankWeirSluiceId="+wid,
			      method:"POST",
				   dataType: 'json',				
			      async: false,
			      success: function (msg) {
			   // 	 console.log(msg);
			    	if(msg!=null) {
			    		var twsid=msg.tankWeirSluiceId;
			    		//alert(twsid);
			    		var twwn=msg.tankWeirSluiceName;
			    		var twstid=msg.tankWeirSluiceTypeId;
			    		//alert(twwn);
			    	//	alert(twstid);
			    		$('#editwntankWeirSluiceIdhide').val(twsid);
			    		  $('#weirName').val(twwn);
			    	}
			    	 
			    	if(msg==0 || msg==null) {
			     		$('#action_alert').html('<p style="margin: 0px !important;">Failed to get data</p>'); 
						  $("html,body").animate({scrollTop:0}, 500);
			    	}	

			      },
			      error : function(){
			    	  alert(error);
			      }
			  }); 
			
			 });
		 
		 
		 
		 $('#editRepairdesc').click(function(){
				
			 $('#repairdesc_dialogue').dialog('option', 'title', 'Edit Repair Description');
			  $('#repairdesc_dialogue').dialog('open');
			  
			  $('#editRepairmain').show();
			  $('#addRepairmain').hide();
			
			  $('#deleteRepairmain').hide();
			  
			  
			  
			  
			
			 });
		 
		 $('#deleteRepairdesc').click(function(){
				
			 $('#repairdesc_dialogue').dialog('option', 'title', 'Delete Repair Description');
			  $('#repairdesc_dialogue').dialog('open');
			  
			  $('#deleteRepairmain').show();
			  $('#editRepairmain').hide();
			  $('#addRepairmain').hide();
			  
			
			 });
		 
		 
		
		 
		 
		 
		 $('#addembRemarks').click(function(){
				
			 $('#review_dialogue').dialog('option', 'title', 'Add Remarks');
			  $('#review_dialogue').dialog('open');
			  
			  $('#reviewformid').trigger("reset"); 
			  
			  $('.reviewbutton').attr('id', 'embreview');
			
			
			  $("#editmst1reviewinfoid").hide();
			  $("#editmst1embreview").hide();
			  $("#embreview").show();
			  
			  
			 });
		 
		
		 
		 
		 $('#sluRemarks').click(function(){
				
			 $('#review_dialogue').dialog('option', 'title', 'Add Remarks');
			  $('#review_dialogue').dialog('open');
			  
			  $('#reviewformid').trigger("reset"); 
			  
			  $('.reviewbutton').attr('id', 'slureview');
			
			  $(".editreviewbutton").hide();  
			  $("#slureview").show();
			//  $("#editmst1reviewinfoid").hide();editreviewbutton
			 
			
			 });
		 
		 
		 $('#addweirRemarks').click(function(){
				
			 $('#review_dialogue').dialog('option', 'title', 'Add Remarks');
			  $('#review_dialogue').dialog('open');
			  
			  $('#reviewformid').trigger("reset"); 
			  
			  $('.reviewbutton').attr('id', 'weirreview');
			
			  $(".editreviewbutton").hide(); 
			  $('.reviewbutton').show();
			 // $("#editmst1reviewinfoid").hide();
			
			 });
		 
		 $('#editMainFormId').click(function(){
				
			 $('#mainform_dialogue').dialog('option', 'title', 'Edit MI Tank Info');
			  $('#mainform_dialogue').dialog('open');
			  
			  $('#editformid').trigger("reset"); 
			 });
		 
		 
		 $('#viewembRemarks').click(function(){
				
			 $('#viewRemarks_dialogue').dialog('option', 'title', 'View/Edit Remarks Info');
			  $('#viewRemarks_dialogue').dialog('open');
			  
			  $('#viewremarksid').trigger("reset"); 
			 });
		 
		 $('#viewsluRemarks').click(function(){
				
			 $('#viewRemarks_dialogue').dialog('option', 'title', 'View/Edit Remarks Info');
			  $('#viewRemarks_dialogue').dialog('open');
			  
			  $('#viewremarksid').trigger("reset"); 
			 });
		 
		 $('#viewweirRemarks').click(function(){
				
			 $('#viewRemarks_dialogue').dialog('option', 'title', 'View/Edit Remarks Info');
			  $('#viewRemarks_dialogue').dialog('open');
			  
			  $('#viewremarksid').trigger("reset"); 
			 });
		 
		 
		 $('#addRepairdesc').click(function(){
				
			 $('#repairdesc_dialogue').dialog('option', 'title', 'Add Repair Description');
			  $('#repairdesc_dialogue').dialog('open');
			  
			  $('#repairdesc').trigger("reset"); 
			  
			  $('#addRepairmain').show();
			  $('#editRepairmain').hide();
			  $('#deleteRepairmain').hide();
			  
			  
			 });
		 
		 
		  
		 
		 


		
		$('.micheckbutton').hide();
		 
		
		$('.mycustomcheck').click(function(){
			  
				var checkname =  $(this).prop('class');
				
			  var userdesignation=$('#designationId1').val();
	         	var cnamesplit = checkname.split(" ");
	         	var checkclass1 = cnamesplit[0];
	         	var checkclass2 = cnamesplit[1];
	         	
	         	
	         	
	         	// substrnumber = checknameid.substring(11, checknameid.length);
	         	 
	         
	         	
	         //	alert("userdesignation"+userdesignation);
	         	
	         	//  var subStrcheck = checkid.substring(12, checkid.length);
	         	
	         		                 	
	   
	         //	alert("check");
	         	
				
	if(checkclass1.length!=null){
					var checkid = $(this).prop('id');
					
					//alert("check"+checkid);
					var checkId=$(this).prop('id');
					 var idnum=checkId.substring(12, checkId.length);
				// alert("idnum"+idnum);
					 
					  var bunddatedisplay="#bunddate"+idnum;
					  var bundactreqdisplay="#bundactreq"+idnum;
					  var bundobsdisplay="#bundobs"+idnum;
					  
					  var sludatedisplay="#slupdate"+idnum;
					  var sluactreqdisplay="#sluactreq"+idnum;
					  var sluobsdisplay="#sluop"+idnum;
					  
					  var weirdatedisplay="#weirpagedate"+idnum;
					  var weiractreqdisplay="#weiractreq"+idnum;
					  var weirobsdisplay="#weirpageobs"+idnum;
					

					if ($('input:checkbox[id=' + checkid + ']').is(
							':checked') == true) {
						$(this).val(1);		
												  
						 $(bunddatedisplay).removeAttr("style");
						 $(bundactreqdisplay).removeAttr("style");
						 $(bundobsdisplay).removeAttr("style");
						 
						// alert("here"+sludatedisplay);
						 
						 $(sludatedisplay).removeAttr("style");
						 $(sluactreqdisplay).removeAttr("style");
						 $(sluobsdisplay).removeAttr("style");
						 
						// alert("here"+weirdatedisplay);
						 
						 $(weirdatedisplay).removeAttr("style");
						 $(weiractreqdisplay).removeAttr("style");
						 $(weirobsdisplay).removeAttr("style");
					}
					//class=mycustomcheck
					if ($('input:checkbox[id=' + checkid + ']').is(
							':checked') == false) {
						$(this).val(0);
						//alert("here"+bunddatedisplay);
						$(bunddatedisplay).hide();
						$(bundactreqdisplay).hide();
						$(bundobsdisplay).hide();
						
						 $(sludatedisplay).hide();
						 $(sluactreqdisplay).hide();
						 $(sluobsdisplay).hide();
						 
						 $(weirdatedisplay).hide();
						 $(weiractreqdisplay).hide();
						 $(weirobsdisplay).hide();

					}
					
	              var classname="."+checkclass1+":checked";
	              
	            //  alert("classname"+classname);
	              
	              
					//var numberNotChecked = $('input:checkbox[class=' + classname + ']:not(":checked")').length;
					var numberOfChecked = $(classname).length
						
						//$('input:checkbox:checked').length;

					//  alert( "un"+numberNotChecked);
				 //  alert("mat"+numberOfChecked);

				 // alert( "diff"+(numberOfChecked-numberNotChecked) );

					if ((numberOfChecked) >= 1 && (userdesignation==2 || userdesignation==8)) {
						$('.micheckbutton').show();
					} else {

						$('.micheckbutton').hide();
					}
					
	}	
			    
			  
		  });
		 
		
		
	$("#addresjuris").click(function() {
		  var link = $(this).attr('href');
		  
		//  alert(link);
		
		  $('#whereFormWillLive').load(link);
		 

		 // $(".content").load(link);
		});
		
	/* 
	$( "#tabs" ).tabs().addClass( "ui-tabs-vertical ui-helper-clearfix" );
	$( "#tabs li" ).removeClass( "ui-corner-top" ).addClass( "ui-corner-left" );
	
	var 
	 */
	
	var tabname="NA";
	 $( "#tabs" ).tabs({
		 

		 
			 
			 beforeActivate: function( event, ui )
			    {   
				 
					
				  var act = $("#tabs").tabs("option", "active");
				  
				 //alert("act"+act);
				  
				  if(act==0){
					 
					  tabname="SLUICE" ;
					  
				  }
				  if(act==1){
						 
					  tabname="WEIR" ;
					  
				  }
				  if(act==2){
						 
					  tabname="TANK CAPACITY" ;
					  
				  }
				  if(act==3){
						 
					  tabname="BUND" ;
					  
				  }
				  
				 
				 
				
				 

				
			        var valid = "Are you sure you want to move to "+tabname+"";
			        var userdesg=parseInt($("#designationId1").val());
			       // alert("userdesg"+userdesg);
			        if(userdesg==2 || userdesg==8){
			        if (confirm(valid)) {
			           
			        	 return true;  
			          
			        }
			        else{
			        	
			        	return false;
			          
			        }
			        }
				 
			    }
			 
	 
	 });
	 
	 
	 
	 $( "#tabs2" ).tabs({ });
 
	

		$("#verticaltii").tabs().addClass("ui-tabs-vertical ui-helper-clearfix");
		$("#verticaltii li").removeClass("ui-corner-top").addClass("ui-corner-left");
		
	
		
		

	  var cyear = (new Date).getFullYear();
	 // var lyear = (new Date).getFullYear()+1;
	 
	$(".datepick").datepicker({
			changeYear : false,
			changeMonth : true,
			 minDate: new Date(cyear, 0, 1),
		        maxDate: new Date(cyear, 11, 31),
		     
			
			 dateFormat: "dd/mm/yy"+" "+ getCurrentTime(),
			   
			
		/* 
		 dateFormat : "dd/mm/yy", onSelect: function(selected) {
		   $("#month").datepicker("option","minDate", selected)
		 } */
		});
	
	$('#damageTime').datetimepicker({
		
		  format: 'HH:mm'
    });
	 
	 

	 
	 $("#miCompIdParent").change(function() {
		  var id = $(this).val();
		  
		//  alert(id);
		
		  $('#compparentId').val(id);
		
		 

		 // $(".content").load(link);
		});
	 
	
	 
	 
	 $("#miTankFreqId").change(function() {
		  var id = $(this).val();

		  $('#mimiTankFreqId1').val(id);
		  $('#mimiTankFreqId2').val(id);
		  $('#mimiTankFreqId3').val(id);
		 /* $('#mimiTankFreqId4').val(0);*/
		  $('#mimiTankFreqId5').val(0);
		  $('#mimiTankFreqId6').val(0);
		  $('#mimiTankFreqId7').val(0);
		  $('#editmimiTankFreqId').val(id);
		
		});
	 
	 $("#nextPostId").change(function() {
		  var id = $(this).val();
		  
		
	//	  $("#nextPostId").muli(function() {
		//  alert("id" +id);
		//  $("#nextPostId option:eq(1)").prop("selected", true);
		//  alert("nextPostId: "+$("#nextPostId option:first-child").text());
		    $("#nextPostId1").val(id);
		
		  $('#nextPostId2').val(id);
		  $('#nextPostId3').val(id);
		  /*$('#empId4').val(id);*/
		  $('#nextPostId5').val(id);
		  $('#nextPostId6').val(id);
		  $('#nextPostId7').val(id);
		  $('#nextPostId7').val(id);
		  $('#nextPostId8').val(id);
		  $('#editnextPostId').val(id);
		  
		  var neid = $('#nextEmpId').val();
		  
		
			//  alert("neid" +neid);
			    $("#nextEmpId1").val(neid);
			  $('#nextEmpId2').val(neid);
			  $('#nextEmpId3').val(neid);
			  $('#nextEmpId5').val(neid);
			  $('#nextEmpId6').val(neid);
			  $('#nextEmpId7').val(neid);
			  $('#nextEmpId8').val(neid);
			  $('#editnextEmpId').val(neid);
		});
	 
	 $("#nextEmpId").change(function() {
		 var neid = $('#nextEmpId').val();
		 
		
			    $("#nextEmpId1").val(neid);
			
			  $('#nextEmpId2').val(neid);
			  $('#nextEmpId3').val(neid);
			  /*$('#empId4').val(neid);*/
			  $('#nextEmpId5').val(neid);
			  $('#nextEmpId6').val(neid);
			  $('#nextEmpId7').val(neid);
			  $('#nextEmpId8').val(neid);
			  $('#editnextEmpId').val(neid);
		});
	 
	 
	 var yearval=parseInt($("#year").val());
	 if(yearval!='Nan' && yearval!=null){
		 
		 if(yearval>0){
			 
			  $('#miyear1').val(yearval);
			  $('#miyear2').val(yearval);
			  $('#miyear3').val(yearval);
			 /* $('#miyear4').val(0);*/
			  $('#miyear5').val(0);
			  $('#miyear6').val(0);
			  $('#miyear7').val(0);
			  $('#editmiyear').val(yearval);
			 
			 
		 }
		 
		 
	 }
	/* $("#year").change(function() {
		  var id = $(this).val();

		  $('#miyear1').val(id);
		  $('#miyear2').val(id);
		  $('#miyear3').val(id);
		  $('#miyear4').val(0);
		  $('#miyear5').val(0);
		  $('#miyear6').val(0);
		  $('#miyear7').val(0);
		  $('#editmiyear').val(id);
		
		});*/
	 
	 $("#tankStatusId").change(function() {
		  var id = $(this).val();

		  $('#tankStatusId1').val(id);
		  $('#tankStatusId2').val(id);
		  $('#tankStatusId3').val(id);
		 /* $('#tankStatusId4').val(0);*/
		  $('#tankStatusId5').val(0);
		  $('#tankStatusId6').val(0);
		  $('#tankStatusId7').val(0);
		
		
		});
	 
	 $("#sluiceId").change(function() {
		  var id = $(this).val();

		  $('#tankWeirSluiceId2').val(id);
		  

			var x=$(this).val();
		//	alert("x"+x);
			
			if(x>0){
			
			$('#editsluice').show();
			} else{
				
				$('#editsluice').hide();
			} 
		
		
		});
	 
	 $("#weirId").change(function() {
		  var id = $(this).val();
		  

		  $('#tankWeirSluiceId3').val(id);
		  var x=$(this).val();
			//	alert("x"+x);
				
				if(x>0){
				
				$('#editweirname').show();
				} else{
					
					$('#editweirname').hide();
				} 
		 
		
		
		});
	 
	 
	 
	 
	 $(".myactionreq").hide();
	 
	 $('.myradio').change(function(){
		   var radioid= $( this ).prop('id');
		//   alert("radioid"+radioid);
		   var subStr ;
		   var listid ;
		   var trueval;
		   var falseval
		   if(radioid.length==11||radioid.length==12){
			   subStr= radioid.substring(10, radioid.length);
			   
			   listid="#myactionreqid"+subStr;
	          trueval="#actionreqy"+subStr+":checked";
			  falseval="#actionreqn"+subStr+":checked";
		   }
		   if(radioid.length==14||radioid.length==15){
		     subStr = radioid.substring(13, radioid.length);
		     listid="#myactionreqidslu"+subStr;
			    trueval="#actionreqsluy"+subStr+":checked";
			    falseval="#actionreqslun"+subStr+":checked";
		   }
		   if(radioid.length==16||radioid.length==17){
			     subStr = radioid.substring(15, radioid.length);
			     listid="#myactionreqidweir"+subStr;
				    trueval="#actionreqweirsy"+subStr+":checked";
				    falseval="#actionreqweirsn"+subStr+":checked";
			   }
		   
		 
		    
		    
		   
		   //alert("subStr"+subStr);
		  //alert("trueval"+trueval+"---"+falseval);
		 // alert("listid"+listid);
		   var value1 = $(trueval).val();
		   var value2 = $(falseval).val();
		//  alert("value1"+value1);
		//  alert("value2"+value2);
		 if(value1=="true"){
	      $(listid).show();
		 }
		 if(value2=="false"){ 
			 
			  $(listid).hide(); 
		 }
		  
		
	 });
	 
	 




	 
	$('.micheckbutton').click(function(e){
		 
		 var formname=this.form.name;
		 
		 var formid=this.form.id;
		 
		 var customformid="#"+formid;
		//	var getformname=$(formname).prop('form');
			var buttonid=$(this).prop('id');
			
			var tankId=$("#tankId").val();
			
	//		var m=$('#inspectDateinflows').val();
	//		alert("inspectDateinflows" + m);
		var nextemp=$("#nextEmpId").val();
		//alert("nextemp" + nextemp);
		
			 
			 $('#action_alert').empty();
			 
			 e.preventDefault(); //=== To Avoid Page Refresh and Fire the Event "Click"===
			 var validnew = "Are you sure you want to submit?"
			
				 if (confirm(validnew)) {
					 
				 
					if ($('form[name=mainformname]').parsley().isValid()) {  
						
					//	alert("kal2");
						
						 if((formname=="michecks1")||(formname=="michecks2")||(formname=="michecks3")){
						
						$(".mycustomcheck").each(function(){
							var thisval=$(this).val();
							 
							 
					           if (thisval==1) {
					              
					        	 //  console.log("checkId"+$(this).prop('id'))
					             
					               
					              // console.log("checkId"+checkId)
					              // alert(checkId); 
						        
					        //    $('#nextEmpId1').val(nextemp);
					        	   
					        	   if((formname=="michecks1")){
					        		   
					        		   var checkId=$(this).prop('id');
										 var idnum=checkId.substring(12, checkId.length);
								
								
						           var iddate="#inspectDate"+idnum;
						           var actreqy="#actionreqy"+idnum;
						           var actreqn="#actionreqn"+idnum;
						           var actlist="#actionrequireqId"+idnum;
						           
						           var isactChecked = $(actreqy).prop('checked');
						           
						          
						          // alert(isactChecked);
						           if(isactChecked==true){
						        	  // alert("coming");
						        	   $(actlist).attr('required','required'); 
						           }
						           
						           if(isactChecked==false){
						        	   //alert("coming");
						        	   $(actlist).removeAttr('required'); 
						           }
						           
						           $(iddate).attr('required','required');
						           $(actreqy).attr('required','required');
						           $(actreqn).attr('required','required');
					        	   }
					        	   
					        	   if((formname=="michecks2")){
					        		///   alert('coming here2');
					        		//   $('#nextEmpId2').val(nextemp);
					        		   var checkId=$(this).prop('id');
										 var idnum=checkId.substring(15, checkId.length);
							           var iddate="#inspectDateslu"+idnum;
							           var actreqy="#actionreqslun"+idnum;
							           var actreqn="#actionreqsluy"+idnum;
							           
							           var actlist2="#actionrequireqIdslu"+idnum;
							           
							           var isactChecked2 = $(actreqy).prop('checked');
							           
								          
								          // alert(isactChecked);
								           if(isactChecked2==true){
								        	  // alert("coming");
								        	   $(actlist2).attr('required','required'); 
								           }
								           
								           if(isactChecked2==false){
								        	   //alert("coming");
								        	   $(actlist2).removeAttr('required'); 
								           }
							           
							           $(iddate).attr('required','required');
							           $(actreqy).attr('required','required');
							           $(actreqy).attr('required','required');
						        	   }
					        	   
					        	   if((formname=="michecks3")){
					        		   //alert('coming here3');
					        	//	   $('#nextEmpId3').val(nextemp);
					        		   var checkId=$(this).prop('id');
										 var idnum=checkId.substring(16, checkId.length);
							           var iddate="#inspectDateweir"+idnum;
							           var actreqy="#actionreqweirsn"+idnum;
							           var actreqn="#actionreqweirsy"+idnum;
							           
                                         var actlist3="#actionrequireqIdweir"+idnum;
							           
							           var isactChecked3 = $(actreqy).prop('checked');
							           
								          
								          // alert(isactChecked);
								           if(isactChecked3==true){
								        	  // alert("coming");
								        	   $(actlist3).attr('required','required'); 
								           }
								           
								           if(isactChecked3==false){
								        	   //alert("coming");
								        	   $(actlist3).removeAttr('required'); 
								           }
							           
							           $(iddate).attr('required','required');
							           $(actreqy).attr('required','required');
							           $(actreqy).attr('required','required');
						        	   }
					           }
					           
					           
					
					           
					});
					}
							
							 
							
							 
							 
						
				if ($('form[name=' + formname + ']').parsley()
						.isValid()) {
					
			
				  
				// alert("kal3");

		   	 $.ajax({	          
		      url: "../invtsimis/addMichecks",
		      method:"POST",
		      async: false,
		      data: $('form[name='+formname+']').serialize(),   
			 
		      success: function (response) {
		   
		    	//alert("kal"+response);
		    	 
		    	 if(response>0){
		    		 
		    		// alert("i am in kal Data inserttedd Successfully");
		
			  $('#action_alert').html('<p style="margin: 0px !important;">Data inserted Successfully</p>');
				$("html,body").animate({scrollTop:$('#action_alert').offset().top-175}, 500);
			    }
			    if(response==0||response==null){
			    	
			    	  $('#action_alert').html('<p style="margin: 0px !important;">Failed to Update data</p>');
			    		$("html,body").animate({scrollTop:$('#action_alert').offset().top-175}, 500);
			    }
			    
			    $(customformid).trigger("reset"); 	
			    
			    if((formname=="michecks1")||(formname=="michecks2")||(formname=="michecks3")){
			    	
				    
		               // $("#d")[0].reset() 
				    var newyear=$("#year").val();	
			    	getmst2inspectdata(newyear);
				    }
			    
			    
			  /*  if(formname=="michecks4"){
			    	
			    
	               // $("#d")[0].reset() 
			    	
			    	getinoutdata(tankId);
			    }*/
	          if(formname=="michecks5"){
			    	
			
	               // $("#d")[0].reset() 
			    	
			    	getrepairdata(tankId);
			    }
	          
	          if(formname=="michecks6"){
			    	
			   
	             // $("#d")[0].reset() 
			    	
			    	getcapacitydata(tankId);
			    }
	          
	          if(formname=="michecks7"){
			    	
	   		   
	              // $("#d")[0].reset() 
	 		    	
	 		    	gettankfeeddata(tankId);
	 		    }
			   
			    
			    
			    
				 

		      },
		      
		      error : function(){
		    	 alert(error);
		    
		      }

		  
		  });   
		  

				
			
	             }else{
	            	 
	            	 $('form[name='+formname+']').parsley().validate();
	            	 
	             }
	             
	             
				}else {
					
					$('form[name=mainformname]').parsley().validate();
					//alert("kal4");
				}
					 return true;
				 } else{
				            return false;
				        }
	});
	
	$('#micheckinfoid').click(function(e){

  var year =   $('#editmiyear').val();  
  if ($('form[name=mainformname]').parsley().isValid()) {  
	  
	  if ($('form[name=editcheckform]').parsley().isValid()) {  
	  
	  
		$.ajax({	          
		      url: "../invtsimis/edit-Mtank-mst2",
		      method:"POST",
			   dataType: 'json',				
		      async: false,
		      data: $('form[name=editcheckform]').serialize(),   
		      success: function (msg) {
		    	  
		    	// console.log(msg);
		    	 
		    	if(msg>0) {
				  $('#editcheckformid').trigger("reset"); 
				  
				  $('#micheck_dialogue').dialog('close');

				  $('#action_alert').html('<p style="margin: 0px !important;" >Data Inserted Successfully</p>'); 
				  $("html,body").animate({scrollTop:$('#action_alert').offset().top-175}, 500);
				  
				  getmst2inspectdata(year);
		    	 
		    	}
		    	 
		    	if(msg==0 || msg==null) {
		    		
				 // $('#editcheckformid').trigger("reset"); 
				  
				  $('#micheck_dialogue').dialog('open');

				  $('#action_alert').html('<p style="margin: 0px !important;">Failed to update</p>'); 
				  $("html,body").animate({scrollTop:$('#action_alert').offset().top-175}, 500);
		    	 
		    	}	
		    	    
		    	
		    	 

		      },
		      error : function(){
		    	  alert(error);
		      }
		  });
		
		
	  }else {
			
			$('form[name=editcheckform]').parsley().validate();
			//alert("kal4");
		}
		
  }else {
		
		$('form[name=mainformname]').parsley().validate();
		//alert("kal4");
	}

		
	});
	
	/*$('#miinfooutflowid').click(function(e){

		 var tankId =   $('#selectinfoTankId').val();  
		  if ($('form[name=mainformname]').parsley().isValid()) {  
			  
			  
			  
			  $("#infinflow").attr('required','required');  
			  $("#infoutfow").attr('required','required');  
			  $("#infayacut").attr('required','required');  
			  $("#infinspectDateinflow").attr('required','required');  
			  
			  $("#editrepairCompId").removeAttr('required');  
			  $("#editrate").removeAttr('required');  
			  $("#editquantity").removeAttr('required');  
			  //$("#editamount").attr('data-parsley-excluded',true);			 
			  $("#editunitMeasureId").removeAttr('required');  
			  $("#editrepairdescId").removeAttr('required');  
			 
			  $("#editsurplusn").removeAttr('required');  	
			  $("#editsurplusy").removeAttr('required');  	 
			  $("#editavailableCapacity").removeAttr('required');  	
			  $("#editavailableCapacity").removeAttr('data-parsley-trigger');  	
			  $("#editavailableCapacity").removeAttr('data-parsley-error-message');  	
			  $("#editinspectDatecapacity").removeAttr('required');  
			  $("#editavailableCapacity").removeAttr('data-parsley-pattern');  	
			 
			
			  
			  if ($('form[name=editinfoform]').parsley().isValid()) {  
				$.ajax({	          
				      url: "../invtsimis/update-inoutflow",
				      method:"POST",
					   dataType: 'json',				
				      async: false,
				      data: $('form[name=editinfoform]').serialize(),   
				      success: function (msg) {
				    	  
				    	// console.log(msg);
				    	 
				    	if(msg>0) {
						  $('#editinfoformid').trigger("reset"); 
						  
						  $('#miinfo_dialogue').dialog('close');

						  $('#action_alert').html('<p style="margin: 0px !important;" >Data updated Successfully</p>'); 
						  $("html,body").animate({scrollTop:$('#action_alert').offset().top-175}, 500);
						  
						//  getinoutdata(tankId);
						
				    	 
				    	}
				    	 
				    	if(msg==0 || msg==null) {
				    		
						 // $('#editcheckformid').trigger("reset"); 
						  
						  $('#miinfo_dialogue').dialog('open');

						  $('#action_alert').html('<p style="margin: 0px !important;">Failed to update</p>'); 
						  $("html,body").animate({scrollTop:$('#action_alert').offset().top-175}, 500);
				    	 
				    	}	
				    	    
				    	
				    	 

				      },
				      error : function(){
				    	  alert(error);
				      }
				  });
				
				
			  }else {
					
					$('form[name=editinfoform]').parsley().validate();
					//alert("kal4");
				}
				
		  }else {
				
				$('form[name=mainformname]').parsley().validate();
				//alert("kal4");
			}

				
			});
	*/
	
	
	
	
	$('#mirepair').click(function(e){

		 var tankId =   $('#selectinfoTankId').val();  
		// alert("editrepairCompId"+$('#editrepairCompId').val());
		// alert("editunitMeasureId"+$('#editunitMeasureId').val());
		  if ($('form[name=mainformname]').parsley().isValid()) {  
			  
			  		  
			 
			  
			//  $('#editinfoform').parsley();
			  
			
			  
			  $("#editrepairCompId").attr('required','required');  
			  $("#editrate").attr('required','required');  
			  $("#editquantity").attr('required','required');  
			  //$("#editamount").attr('data-parsley-excluded',true);			 
			  $("#editunitMeasureId").attr('required','required');  
			  $("#editrepairdescId").attr('required','required');  
			 
			  $("#editsurplusn").removeAttr('required');  	
			  $("#editsurplusy").removeAttr('required');  	 
			  $("#editavailableCapacity").removeAttr('required');  	
			  $("#editinspectDatecapacity").removeAttr('required');  
			  $("#editavailableCapacity").removeAttr('data-parsley-pattern');  	
			  $("#editavailableCapacity").removeAttr('data-parsley-trigger');  	
			  $("#editavailableCapacity").removeAttr('data-parsley-error-message');  
			  
			  $("#infinflow").removeAttr('data-parsley-pattern');  	
			  $("#infinflow").removeAttr('data-parsley-trigger');  	
			  $("#infinflow").removeAttr('data-parsley-error-message');  	
			  
			  $("#infoutfow").removeAttr('data-parsley-pattern');  
			  $("#infoutfow").removeAttr('data-parsley-trigger');  
			  $("#infoutfow").removeAttr('data-parsley-error-message');  
			  
			  $("#infayacut").removeAttr('data-parsley-pattern');  
			  $("#infayacut").removeAttr('data-parsley-trigger');  
			  $("#infayacut").removeAttr('data-parsley-error-message');  
			  
			  $("#inftankLevel").removeAttr('data-parsley-pattern');  
			  $("#inftankLevel").removeAttr('data-parsley-trigger');  
			  $("#inftankLevel").removeAttr('data-parsley-error-message');  
			 
			  
			  
			
			  
			
			  
			  if ($('form[name=editinfoform]').parsley().isValid()) { 
				  
				$.ajax({	          
				      url: "../invtsimis/update-repairs",
				      method:"POST",
					   dataType: 'json',				
				      async: false,
				      data: $('form[name=editinfoform]').serialize(),   
				      success: function (msg) {
				    	  
				    	// console.log(msg);
				    	 
				    	if(msg>0) {
						  $('#editinfoformid').trigger("reset"); 
						  
						  $('#miinfo_dialogue').dialog('close');

						  $('#action_alert').html('<p style="margin: 0px !important;" >Data updated Successfully</p>'); 
						  $("html,body").animate({scrollTop:0}, 500);
						  
						  getrepairdata(tankId);
						
				    	 
				    	}
				    	 
				    	if(msg==0 || msg==null) {
				    		
						 // $('#editcheckformid').trigger("reset"); 
						  
						  $('#miinfo_dialogue').dialog('open');

						  $('#action_alert').html('<p style="margin: 0px !important;">Failed to update</p>'); 
						  $("html,body").animate({scrollTop:0}, 500);
				    	 
				    	}	
				    	    
				    	
				    	 

				      },
				      error : function(){
				    	  alert(error);
				      }
				  });
				
				
			  }else {
					
					$('form[name=editinfoform]').parsley().validate();
					//alert("kal4");
				}

				
		  }else {
				
				$('form[name=mainformname]').parsley().validate();
				//alert("kal4");
			}

				
			});
	
	
	$('#mifeed').click(function(e){

		 var tankId =   $('#selectinfoTankId').val();  
		// alert("editrepairCompId"+$('#editrepairCompId').val());
		// alert("editunitMeasureId"+$('#editunitMeasureId').val());
		  if ($('form[name=mainformname]').parsley().isValid()) {  
				$.ajax({	          
				      url: "../invtsimis/update-FeedDetails",
				      method:"POST",
					   dataType: 'json',				
				      async: false,
				      data: $('form[name=editinfoform]').serialize(),   
				      success: function (msg) {
				    	  
				    	// console.log(msg);
				    	 
				    	if(msg>0) {
						  $('#editinfoformid').trigger("reset"); 
						  
						  $('#miinfo_dialogue').dialog('close');

						  $('#action_alert').html('<p style="margin: 0px !important;" >Data updated Successfully</p>'); 
						  $("html,body").animate({scrollTop:0}, 500);
						  
						  gettankfeeddata(tankId);
						
				    	 
				    	}
				    	 
				    	if(msg==0 || msg==null) {
				    		
						 // $('#editcheckformid').trigger("reset"); 
						  
						  $('#miinfo_dialogue').dialog('open');

						  $('#action_alert').html('<p style="margin: 0px !important;">Failed to update</p>'); 
						  $("html,body").animate({scrollTop:0}, 500);
				    	 
				    	}	
				    	    
				    	
				    	 

				      },
				      error : function(){
				    	  alert(error);
				      }
				  });
				
		  }else {
				
				$('form[name=mainformname]').parsley().validate();
				//alert("kal4");
			}

				
			});
	
	
	
	$('#editamount').click(function(e){
	
		var rate=parseFloat($("#editrate").val());  
		var quant=parseFloat($("#editquantity").val());

		
		var amt;
		if(rate!='NaN' && quant!='NaN' ){
		
			
			amt=parseFloat((rate*quant)).toFixed(2);
			$('#editamount').val(amt);
		
		}
		if(rate==='NaN' || quant==='NaN' ){
			
			$('#editamount').val(0);
		}
		
		$("#editamount").val(amt);
		
	});
	
	$('#micapacity').click(function(e){

		 var tankId =   $('#selectinfoTankId').val();  
		// alert("editrepairCompId"+$('#editrepairCompId').val());
		// alert("editunitMeasureId"+$('#editunitMeasureId').val());
		  if ($('form[name=mainformname]').parsley().isValid()) {  
			  
			  
			 
			  
			
			  $("#editrepairCompId").removeAttr('required');  
			  $("#editrate").removeAttr('required');  
			  $("#editquantity").removeAttr('required');  
			  //$("#editamount").attr('data-parsley-excluded',true);			 
			  $("#editunitMeasureId").removeAttr('required');  
			  $("#editrepairdescId").removeAttr('required');  
			 
			  $("#editsurplusn").attr('required','required');  	
			  $("#editsurplusy").attr('required','required');  	 
			  $("#editavailableCapacity").attr('required','required');  	
			  $("#editinspectDatecapacity").attr('required','required');  	
			
			  $("#editavailableCapacity").attr('data-parsley-trigger','blur');  	
			  $("#editavailableCapacity").attr('data-parsley-error-message','You must enter capacity 5 digits ex:0.00012');  	
			
			  $("#editavailableCapacity").attr('data-parsley-pattern','^[0-9]*\.[0-9]{5}$');  
			  
			  $("#infinflow").attr('data-parsley-trigger','blur');  
			  $("#infinflow").attr('data-parsley-error-message','You must enter inflow 2 digits ex:0.34'); 
			  $("#infinflow").attr('data-parsley-pattern','^[0-9]*\.[0-9]{2}$'); 

			  $("#infoutfow").attr('data-parsley-trigger','blur');  
			  $("#infoutfow").attr('data-parsley-error-message','You must enter outflow 2 digits ex:0.34'); 
			  $("#infoutfow").attr('data-parsley-pattern','^[0-9]*\.[0-9]{2}$'); 
			  
			  $("#infayacut").attr('data-parsley-trigger','blur');  
			  $("#infayacut").attr('data-parsley-error-message','You must enter ayacut 2 digits ex:0.34'); 
			  $("#infayacut").attr('data-parsley-pattern','^[0-9]*\.[0-9]{2}$'); 
			  
			  
			  $("#inftankLevel").attr('data-parsley-trigger','blur');  
			  $("#inftankLevel").attr('data-parsley-error-message','You must enter tank level 2 digits ex:0.34'); 
			  $("#inftankLevel").attr('data-parsley-error-message','You must enter tank level 2 digits ex:0.34'); 
			  
			 
			  
			  
			  if ($('form[name=editinfoform]').parsley().isValid()) {  
				$.ajax({	          
				      url: "../invtsimis/update-capacity",
				      method:"POST",
					   dataType: 'json',				
				      async: false,
				      data: $('form[name=editinfoform]').serialize(),   
				      success: function (msg) {
				    	  
				    	// console.log(msg);
				    	 
				    	if(msg>0) {
						  $('#editinfoformid').trigger("reset"); 
						  
						  $('#miinfo_dialogue').dialog('close');

						  $('#action_alert').html('<p style="margin: 0px !important;" >Data updated Successfully</p>'); 
						  $("html,body").animate({scrollTop:0}, 500);
						  
						  getcapacitydata(tankId);
						
				    	 
				    	}
				    	 
				    	if(msg==0 || msg==null) {
				    		
						 // $('#editcheckformid').trigger("reset"); 
						  
						  $('#miinfo_dialogue').dialog('open');

						  $('#action_alert').html('<p style="margin: 0px !important;">Failed to update</p>'); 
						  $("html,body").animate({scrollTop:0}, 500);
				    	 
				    	}	
				    	    
				    	
				    	 

				      },
				      error : function(){
				    	  alert(error);
				      }
				  });
				
				
			  }else {
					
					$('form[name=editinfoform]').parsley().validate();
					//alert("kal4");
				}
				
		  }else {
				
				$('form[name=mainformname]').parsley().validate();
				//alert("kal4");
			}

				
			});
	
	

	$('#addsluiceformbutton').click(function(e){

		 var tankId =   $('#tankId').val();  
		 
		 $('#sluicetankId').val(tankId);  
		 
		// alert("editrepairCompId"+$('#editrepairCompId').val());
		// alert("editunitMeasureId"+$('#editunitMeasureId').val());
		 
		  if ($('form[name=mainformname]').parsley().isValid()) {  
		  if ($('form[name=sluiceform]').parsley().isValid()) {  
				$.ajax({	          
				      url: "../invtsimis/insert-weir-sluice",
				      method:"POST",
					   dataType: 'json',				
				      async: false,
				      data: $('form[name=sluiceform]').serialize(),   
				      success: function (msg) {
				    	  
				    	// console.log(msg);
				    	 
				    	if(msg>0) {
				    		
						  $('#sluiceformid').trigger("reset"); 
						  
						  $('#sluice_dialogue').dialog('close');

						  $('#action_alert').html('<p style="margin: 0px !important;" >Data added Successfully</p>'); 
						  $("html,body").animate({scrollTop:0}, 500);
						  
						  getsluicelist(tankId);
						
				    	 
				    	}
				    	 
				    	if(msg==0 || msg==null) {
				    		
						 // $('#editcheckformid').trigger("reset"); 
						  
						  $('#sluice_dialogue').dialog('open');

						  $('#action_alert').html('<p style="margin: 0px !important;">Failed to add</p>'); 
						  $("html,body").animate({scrollTop:0}, 500);
				    	 
				    	}	
				    	    
				    	
				    	 

				      },
				      error : function(){
				    	  alert(error);
				      }
				  });
				
		  }else {
				
				$('form[name=sluiceform]').parsley().validate();
				//alert("kal4");
			}
		  
		  }else {
				
				$('form[name=mainformname]').parsley().validate();
				//alert("kal4");
			}

				
			});
	
	$('#editsluiceformbutton').click(function(e){
		 var tankId =   $('#tankId').val();  
		 /*	 $('#sluicetankId').val(tankId);  */
		 
		  if ($('form[name=sluiceform]').parsley().isValid()) {  
				$.ajax({	          
				      url: "../invtsimis/update-sluicename-byid",
				      method:"POST",
					   dataType: 'json',				
				      async: false,
				      data: $('form[name=sluiceform]').serialize(),   
				      success: function (msg) {
				    	// console.log(msg);
				    	if(msg>0) {
				    		
						  $('#sluiceformid').trigger("reset"); 
						  
						  $('#sluice_dialogue').dialog('close');

						  $('#action_alert').html('<p style="margin: 0px !important;" >Data Updated Successfully</p>'); 
						  $("html,body").animate({scrollTop:0}, 500);
						  
						  getsluicelist(tankId);				    	 
				    	}
				    	 
				    	if(msg==0 || msg==null) {
				    		
						 // $('#editcheckformid').trigger("reset"); 
						  
						  $('#sluice_dialogue').dialog('open');

						  $('#action_alert').html('<p style="margin: 0px !important;">Failed to update</p>'); 
						  $("html,body").animate({scrollTop:0}, 500);
				    	 
				    	}	
				
				      },
				      error : function(){
				    	  alert(error);
				      }
				  });
				
		  }else {
				$('form[name=sluiceform]').parsley().validate();
				//alert("kal4");
			}
		  
		  
			});
	
	
	$('#addweirformbutton').click(function(e){

		 var tankId =   $('#tankId').val();  
		 
		 $('#weirtankId').val(tankId);  
		// var year = $('#year').val(); 
		
		 $('#action_alert').html('');
		// alert("editrepairCompId"+$('#editrepairCompId').val());
		// alert("editunitMeasureId"+$('#editunitMeasureId').val());
		// if ($('form[name=sluiceform]').parsley().isValid()) {  
		 
		  if ($('form[name=mainformname]').parsley().isValid()) {  
		  if ($('form[id=weirformid]').parsley().isValid()) {  
		//  if ($('form[name=weirform]').parsley().isValid()) {  		
				$.ajax({	          
				      url: "../invtsimis/insert-weir-sluice",
				      method:"POST",
					   dataType: 'json',				
				      async: false,
				      data: $('form[name=weirform]').serialize(),   
				      success: function (msg) {
				    	  
				    	// console.log(msg);
				    	 
				    	if(msg>0) {
				    		
						  $('#weirformid').trigger("reset"); 
						  
						  $('#weir_dialogue').dialog('close');

						  $('#action_alert').html('<p style="margin: 0px !important;" >Data added Successfully</p>'); 
						  $("html,body").animate({scrollTop:0}, 500);
						  
						  getweirlist(tankId);
						  
						  getmst2inspectdata(year)
				    	}
				    	 
				    	if(msg==0 || msg==null) {
				    		
						 // $('#editcheckformid').trigger("reset"); 
						  
						  $('#weir_dialogue').dialog('open');

						  $('#action_alert').html('<p style="margin: 0px !important;">Failed to add</p>'); 
						  $("html,body").animate({scrollTop:0}, 500);
				    	 
				    	}	
				      },
				      error : function(){
				    	  alert(error);
				      }
				  });
				
		  }else {
			
			  $('form[id=weirformid]').parsley().validate();
				//alert("kal4");
			}
		  }else {
				
				$('form[name=mainformname]').parsley().validate();
				//alert("kal4");
			}

				
			});
	
	
	$('#editweirformbutton').click(function(e){
		 var tankId =   $('#tankId').val();  
		 /*	 $('#sluicetankId').val(tankId);  */
		 
		  if ($('form[id=weirformid]').parsley().isValid()) {  
				$.ajax({	          
				      url: "../invtsimis/update-sluicename-byid",
				      method:"POST",
					   dataType: 'json',				
				      async: false,
				      data: $('form[name=weirform]').serialize(),   
				      success: function (msg) {
				    //	 console.log(msg);
				    	if(msg>0) {
				    		
						 

						  $('#action_alert').html('<p style="margin: 0px !important;" >Data Updated Successfully</p>'); 
						  $("html,body").animate({scrollTop:0}, 500);
						  $('#weirformid').trigger("reset"); 
						  
						  $('#weir_dialogue').dialog('close');
						 
						  getweirlist(tankId);
						 			    	 
				    	}
				    	 
				    	if(msg==0 || msg==null) {
				    		
						 // $('#editcheckformid').trigger("reset"); 
						  
						  $('#weir_dialogue').dialog('open');

						  $('#action_alert').html('<p style="margin: 0px !important;">Failed to update</p>'); 
						  $("html,body").animate({scrollTop:0}, 500);
				    	 
				    	}	
				
				      },
				      error : function(){
				    	  alert(error);
				      }
				  });
				
		  }else {
				$('form[name=weirform]').parsley().validate();
				//alert("kal4");
			}
		  
		  
			});
	
	
	
	$('#addRepairmain').click(function(e){

		 var tankId =   $('#tankId').val();  
		 
		 $('#repairdesctankId').val(tankId);  
		 
		  if ($('form[name=mainformname]').parsley().isValid()) {  
		 
		  if ($('form[name=repairdescform]').parsley().isValid()) {  
		 
		// alert("editrepairCompId"+$('#editrepairCompId').val());
		// alert("editunitMeasureId"+$('#editunitMeasureId').val());
		/* if ($('form[name=weirform]').parsley().isValid()) {  */
				$.ajax({	          
				      url: "../invtsimis/add-repairdesc",
				      method:"POST",
					   dataType: 'json',				
				      async: false,
				      data: $('form[name=repairdescform]').serialize(),   
				      success: function (msg) {
				    	  
				    	// console.log(msg);
				    	 
				    	if(msg>0) {
				    		
						  $('#repairdesc').trigger("reset"); 
						  
						  $('#repairdesc_dialogue').dialog('close');

						  $('#action_alert').html('<p style="margin: 0px !important;" >Data added Successfully</p>'); 
						  $("html,body").animate({scrollTop:0}, 500);
						  
						  getrepairdesclist(tankId);
						
				    	 
				    	}
				    	 
				    	if(msg==0 || msg==null) {
				    		
						 // $('#editcheckformid').trigger("reset"); 
						  
						  $('#repairdesc_dialogue').dialog('open');

						  $('#action_alert').html('<p style="margin: 0px !important;">Failed to add</p>'); 
						  $("html,body").animate({scrollTop:0}, 500);
				    	 
				    	}	
				    	    
				    	
				    	 

				      },
				      error : function(){
				    	  alert(error);
				      }
				  });
				
		  }
				
		 else {
				
				$('form[name=repairdescform]').parsley().validate();
				//alert("kal4");
			}
		  
		  } else {
					
					$('form[name=mainformname]').parsley().validate();
					//alert("kal4");
				}

				
			});
	
	
	$('#editRepairmain').click(function(e){

		 var tankId =   $('#tankId').val();  
		 
		 $('#repairdesctankId').val(tankId);  
		 
		  if ($('form[name=mainformname]').parsley().isValid()) {  
		 
		  if ($('form[name=repairdescform]').parsley().isValid()) {  
		 
		// alert("editrepairCompId"+$('#editrepairCompId').val());
		// alert("editunitMeasureId"+$('#editunitMeasureId').val());
		/* if ($('form[name=weirform]').parsley().isValid()) {  */
				$.ajax({	          
				      url: "../invtsimis/edit-repairdesc",
				      method:"POST",
					   dataType: 'json',				
				      async: false,
				      data: $('form[name=repairdescform]').serialize(),   
				      success: function (msg) {
				    	  
				    	// console.log(msg);
				    	 
				    	if(msg>0) {
				    		
						  $('#repairdesc').trigger("reset"); 
						  
						  $('#repairdesc_dialogue').dialog('close');

						  $('#action_alert').html('<p style="margin: 0px !important;" >Data added Successfully</p>'); 
						  $("html,body").animate({scrollTop:0}, 500);
						  
						  getrepairdesclist(tankId);
						  getrepairdata(tankId)
				    	 
				    	}
				    	 
				    	if(msg==0 || msg==null) {
				    		
						 // $('#editcheckformid').trigger("reset"); 
						  
						  $('#repairdesc_dialogue').dialog('open');

						  $('#action_alert').html('<p style="margin: 0px !important;">Failed to add</p>'); 
						  $("html,body").animate({scrollTop:0}, 500);
				    	 
				    	}	
				    	    
				    	
				    	 

				      },
				      error : function(){
				    	  alert(error);
				      }
				  });
				
		  }
				
		 else {
				
				$('form[name=repairdescform]').parsley().validate();
				//alert("kal4");
			}
		  
		  } else {
					
					$('form[name=mainformname]').parsley().validate();
					//alert("kal4");
				}

				
			});
	
	
	$('#deleteRepairmain').click(function(e){

		 var tankId =   $('#tankId').val();  
		 
		 $('#repairdesctankId').val(tankId);  
		 
		
				$.ajax({	          
				      url: "../invtsimis/delete-repairdesc",
				      method:"POST",
					   dataType: 'json',				
				      async: false,
				      data: $('form[name=repairdescform]').serialize(),   
				      success: function (msg) {
				    	  
				    	// console.log(msg);
				    	 
				    	if(msg>0) {
				    		
						  $('#repairdesc').trigger("reset"); 
						  
						  $('#repairdesc_dialogue').dialog('close');

						  $('#action_alert').html('<p style="margin: 0px !important;" >Deleted Successfully</p>'); 
						  $("html,body").animate({scrollTop:0}, 500);
						  
						  getrepairdesclist(tankId);
						  getrepairdata(tankId)
						
				    	 
				    	}
				    	 
				    	if(msg==0 || msg==null) {
				    		
						 // $('#editcheckformid').trigger("reset"); 
						  
						  $('#repairdesc_dialogue').dialog('open');

						  $('#action_alert').html('<p style="margin: 0px !important;">Failed to delete</p>'); 
						  $("html,body").animate({scrollTop:0}, 500);
				    	 
				    	}	
				    	    
				    	
				    	 

				      },
				      error : function(){
				    	  alert(error);
				      }
				  });
		
				
			});
	
	
	
	
	
	
	$("#amount").click(function (e){
		//alert(' iam here');
		var rate=parseFloat(($('#rate').val()));
		//alert("available"+available);
		var quantity=parseFloat($('#quantity').val());
	//	alert("gross"+gross);
		var amount;
		if(rate!='NaN' && quantity!='NaN' ){
		
			
			amount=(parseFloat(rate*quantity)).toFixed(2);
			$('#amount').val(amount);
		
		}
		if(rate==='NaN' || quantity==='NaN' ){
			
			$('#amount').val(0);
		}
		
	});

$('#quantity').click(function(e){
	
	//alert(' iam here');
	var quantity=parseFloat(($('#quantity').val()));
	//alert("available"+available);
	var rate=parseFloat($('#rate').val());
//	alert("gross"+gross);
	var amount;
	if(rate!='NaN' && quantity!='NaN' ){
	
		
		amount=(parseFloat(rate*quantity)).toFixed(2);
		$('#amount').val(amount);
	
	}
	if(rate==='NaN' || quantity==='NaN' ){
		
		$('#amount').val(0);
	}
	
});



	
	$(document).on("change keyup blur", "#availableCapacity", function() {
	
	//alert(' iam here');
	var available=parseFloat(($(this).val()));
	//alert("available"+available);
	var gross=parseFloat($('#grossCapacity').val());
//	alert("gross"+gross);
	var percentageCap;

	if(available>0 && gross>0){
		
		percentageCap=(parseFloat(available/gross)*100).toFixed(2);
		$('#percentageCapacity').val(percentageCap);
	}
	
	
});




$(document).on("change keyup blur", "#editavailableCapacity", function() {
	
	var available=parseFloat(($("#editavailableCapacity").val()));
	//alert("available"+available);
	var gross=parseFloat($('#grossCapacity').val());
	
		if(available>0 && gross>0){
			
			percentageCap=(parseFloat(available/gross)*100).toFixed(2);
			$('#editcapacitypercent').val(percentageCap);
			
		}
		
    
});






		
	});
	
	function getmst2inspectdata(year){
		
		// $('#action_alert').html('');
		
		 $( ".editemb" ).each(function() {
			 if($(".editemb").hasClass('eact1')){	                    
    				var embid=$(this).prop('id');			    				
    				//alert("sluid"+sluid);
    				
    				var newembid="#"+embid;		    				
            
    				  $(newembid).removeClass('eact1');	    				 
					   
					   $(newembid).removeAttr('style') ;			    					   
    					 //  alert("newsluid"+newsluid);
    					   $(newembid).css("display", "none");
    					   
    	}
			});
		 
		 $( ".deleteemb" ).each(function() {
			 if($(".deleteemb").hasClass('dact2')){                    
    				var delemb=$(this).prop('id');			    				
    				//alert("sluid"+sluid);
    				
    				var newdelemb="#"+delemb;		    				
            
    				  $(newdelemb).removeClass('dact2');	    				 
					   
					   $(newdelemb).removeAttr('style') ;			    					   
    					 //  alert("newsluid"+newsluid);
    					   $(newdelemb).css("display", "none");
    					   
    	}
			});
		 
		
	 
		 
		 $( ".editslu" ).each(function() {
			 if($(".editslu").hasClass('eact1')){	                    
    				var editslid=$(this).prop('id');			    				
    				//alert("sluid"+sluid);
    				
    				var newslid="#"+editslid;		    				
            
    				  $(newslid).removeClass('eact1');	    				 
					   
					   $(newslid).removeAttr('style') ;			    					   
    					 //  alert("newsluid"+newsluid);
    					   $(newslid).css("display", "none");
    					   
    	}
			});
		 
		 $( ".deleteslu" ).each(function() {
			 if($(".deleteslu").hasClass('dact2')){                    
    				var delslu=$(this).prop('id');			    				
    				//alert("sluid"+sluid);
    				
    				var newdelslu="#"+delslu;		    				
            
    				  $(newdelslu).removeClass('dact2');	    				 
					   
					   $(newdelslu).removeAttr('style') ;			    					   
    					 //  alert("newsluid"+newsluid);
    					   $(newdelslu).css("display", "none");
    					   
    	}
			});
		 
		 
			
		

	

		 
		 $( ".editweir" ).each(function() {
			 if($(".editweir").hasClass('eact1')){	                    
    				var wid=$(this).prop('id');			    				
    				//alert("sluid"+sluid);
    				
    				var newwid="#"+wid;		    				
            
    				  $(newwid).removeClass('eact1');	    				 
					   
					   $(newwid).removeAttr('style') ;			    					   
    					 //  alert("newsluid"+newsluid);
    					   $(newwid).css("display", "none");
    					   
    	}
			});
		 
		 $( ".deleteweir" ).each(function() {
			 if($(".deleteweir").hasClass('dact2')){                    
    				var delweir=$(this).prop('id');			    				
    				//alert("sluid"+sluid);
    				
    				var newdelweir="#"+delweir;		    				
            
    				  $(newdelweir).removeClass('dact2');	    				 
					   
					   $(newdelweir).removeAttr('style') ;			    					   
    					 //  alert("newsluid"+newsluid);
    					   $(newdelweir).css("display", "none");
    					   
    	}
			});
		 
		
	
		 
	
	
		
		if(year>0){
		
		var freq= $('#miTankFreqId').val();
		
		var tankId=$('#tankId').val();
		
		var postId=$('#postId1').val();
		
		//alert(year+tankId+freq);
		
		$.ajax({	          
		      url: "../invtsimis/getmst2bymstyearfreq?year="+year+"&tankId="+tankId+"&miTankFreqId="+freq,
		      type: "GET",
		      contentType: "application/json; charset=utf-8",
		      success: function (msg) {
		    	  
		    //	 console.log(msg);
		    	//	alert('kalhere1') 
		    	 
		    	 if(msg===null||msg===0 || msg==='[]'){
			    		
			    		//alert('coming here in year mst2 inspect msg null')
		    		  
		    		  $('#action_alert').html(''); 
		    		  
		    		  $('.mycustomcheck').prop('disabled', false);	
		    		  $('.mycustomcheck').prop('checked', false);
			    		
		    		
			    		 $('.mycustomcheck').val(0);
			    		 
			    		 getsluicelist(tankId);
			    		 getweirlist(tankId);
			    		 
			    		 $('.datepick').val(0);		    		
			    		  $('.bundreqn').prop('checked', true);
			    		  $('.bundreqy').prop('checked', false);	
			    		  $('.sluradion').prop('checked', true);
			    		  $('.sluradioy').prop('checked', false);	
			    		  
			    		  $('.weirradion').prop('checked', true);
			    		  $('.weirradioy').prop('checked', false);	
			    		  $('.myradio').attr('disabled', false);
			    		  
			    		  
			    		  $( ".bundreqn" ).each(function() {
				    	       var isChecked = $('.bundreqn').prop('checked');
					    		 			    	
					    		  if(isChecked) {
					    			  
					    			  $('.actionreqselect').val(0);  
					    			
					    			  $('.myactionreq').removeAttr('style'); 
					    			  $('.myactionreq').hide(); 
					    			}
			 					
				    	       });
			    		  
			    		  $( ".sluradion" ).each(function() {
				    	       var isChecked = $('.sluradion').prop('checked');
					    		 			    	
					    		  if(isChecked) {
					    			  
					    			  $('.sllist').val(0);  
					    			
					    			  $('.slureq').removeAttr('style'); 
					    			  $('.slureq').hide(); 
					    			}
			 					
				    	       });
			    		  
			    		  $( ".weirradion" ).each(function() {
				    	       var isChecked = $('.weirradion').prop('checked');
					    		 			    	
					    		  if(isChecked) {
					    			  
					    			  $('.sllist').val(0);  
					    			
					    			  $('.weirreq').removeAttr('style'); 
					    			  $('.weirreq').hide(); 
					    			}
			 					
				    	       });
				    		 
			    		  
			    		 $('.actionreqselect').val(0);
			    		 
			    		  $('.actionreqselect').attr('disabled', false);
			    		  
			    		  
			    		  $('.sllist').attr('disabled', false);
			    		  $('.wrlist').attr('disabled', false);
			    		 
			    		 $('.datepick').removeAttr('disabled');
			    		 
			    		 $('.myrem').removeAttr('readonly');
			    		 $('.myrem').val('');
			    		 $('.editemb').hide();
			    		 $('.deleteemb').hide();
			    		 
			    		 $('#tankStatusId').val(0);
			    		  $("#tankStatusId").multiselect('rebuild');
			    		 $('#editankStatus').hide();
			    		 $('#viewhead1').empty();
			    		 $('#viewbody1').empty();
			    		 $('#embmst1Id').val(0);
			    		 $('#slumst1Id').val(0);
			    		 $('#weirmst1Id').val(0);
			    	
 		
			    	}
		    	 
		    	 
		    	
		    	if(msg!=null){  
		    		
		    	
		    		//  alert("msg"+msg);
			    	  
			    	 
		    		
		    		//alert('kalhere')
		    		  var obj = JSON.parse(msg);
		    		
		    		if(obj!=null){
		    			
		    			
		    			//alert('coming to  inspect obj not null')
			    		  
			    		//  $('#action_alert').html(''); 
			    		  
			    		  $('.mycustomcheck').prop('disabled', false);	
			    		  $('.mycustomcheck').prop('checked', false);
				    		
			    		
				    		 $('.mycustomcheck').val(0);
				    		 
				    		 getsluicelist(tankId);
				    		 getweirlist(tankId);
				    		 
				    	//	 $('.datepick').val(0);		
				    		 $('.datepick').val('');		 
				    		  $('.bundreqn').prop('checked', true);
				    		  $('.bundreqy').prop('checked', false);	
				    		  $('.sluradion').prop('checked', true);
				    		  $('.sluradioy').prop('checked', false);	
				    		  
				    		  $('.weirradion').prop('checked', true);
				    		  $('.weirradioy').prop('checked', false);	
				    		  $('.myradio').attr('disabled', false);
				    		  
				    		  
				    		  $( ".bundreqn" ).each(function() {
					    	       var isChecked = $('.bundreqn').prop('checked');
						    		 			    	
						    		  if(isChecked) {
						    			  
						    			  $('.actionreqselect').val(0);  
						    			
						    			  $('.myactionreq').removeAttr('style'); 
						    			  $('.myactionreq').hide(); 
						    			}
				 					
					    	       });
				    		  
				    		  $( ".sluradion" ).each(function() {
					    	       var isChecked = $('.sluradion').prop('checked');
						    		 			    	
						    		  if(isChecked) {
						    			  
						    			  $('.sllist').val(0);  
						    			
						    			  $('.slureq').removeAttr('style'); 
						    			  $('.slureq').hide(); 
						    			}
				 					
					    	       });
				    		  
				    		  $( ".weirradion" ).each(function() {
					    	       var isChecked = $('.weirradion').prop('checked');
						    		 			    	
						    		  if(isChecked) {
						    			  
						    			  $('.sllist').val(0);  
						    			
						    			  $('.weirreq').removeAttr('style'); 
						    			  $('.weirreq').hide(); 
						    			}
				 					
					    	       });
					    		 
				    		  
				    		 $('.actionreqselect').val(0);
				    		 
				    		  $('.actionreqselect').attr('disabled', false);
				    		  
				    		  
				    		  $('.sllist').attr('disabled', false);
				    		  $('.wrlist').attr('disabled', false);
				    		 
				    		 $('.datepick').removeAttr('disabled');
				    		 
				    		 $('.myrem').removeAttr('readonly');
				    		 $('.myrem').val('');
				    		 $('.editemb').hide();
				    		 $('.deleteemb').hide();
				    		 
				    		 $('#tankStatusId').val(0);
				    		  $("#tankStatusId").multiselect('rebuild');
				    		 $('#editankStatus').hide();
				    		 $('#viewhead1').empty();
				    		 $('#viewbody1').empty();
				    		 $('#embmst1Id').val(0);
				    		 $('#slumst1Id').val(0);
				    		 $('#weirmst1Id').val(0);
		    		  
		    		 
		    		  
		    		
		    		var tankstatusId="#tankStatusId"
			    		$(tankstatusId).val(obj[0].tankStatusId);
			    
			    		$('#editankStatus').show();
			    		$(tankstatusId).each(function () {
			    			 if ($(this).val() == obj[0].tankStatusId) {
					    	        //	alert("equal"+actionrequirereq+"*"+obj[i].actionrequireqId+"--"+$(this).val());
					    	            $(this).attr("selected", "selected");
					    	            
					    	            var id = $(this).val();

					    	  		  $('#tankStatusId1').val(id);
					    	  		  $('#tankStatusId2').val(id);
					    	  		  $('#tankStatusId3').val(id);
					    	            
					    	        } 
					    	        if ($(this).val() != obj[0].tankStatusId) {
					    	        	
					    	        	 $(this).removeAttr("selected");
					    	        	
					    	        }
			    	});
			    		
			    		$(tankstatusId).multiselect('rebuild');
			    		
			    		 $('#editcriticalMst1Id').val(obj[0].miInpsectMst1Id);
			    		 
			    		var editUnitId="#editUnitId" ;
			    	    var editCircleId="#editCircleId" ;		    				 
			    	   var editDivisionId="#editDivisionId";			    					 
			    	    var  editSubDivisionId="#editSubDivisionId";
			    	    
			    	    $(editUnitId).val(obj[0].unitId);
			    	    $(editCircleId).val(obj[0].circleId);
			    	    $(editDivisionId).val(obj[0].divisionId);
			    	    $(editSubDivisionId).val(obj[0].subdivisionId);
			    	    
			    	  $(editUnitId).each(function () {
			    			 if ($(this).val() == obj[0].unitId) {
					    	        //	alert("equal"+actionrequirereq+"*"+obj[i].actionrequireqId+"--"+$(this).val());
					    	            $(this).attr("selected", "selected");
					    	        } 
					    	       
					    	        if ($(this).val() != obj[0].unitId) {
					    	        	
					    	        	 $(this).removeAttr("selected");
					    	        }
					    	        
					    	        if($(this).val()>0){
					    	        	getCircles($(this).val(),1);
					    	        }
			    	});
			    		$(editUnitId).multiselect('rebuild');
			    	    
			    	   $(editCircleId).each(function () {
			    			 if ($(this).val() == obj[0].circleId) {
					    	        //	alert("equal"+actionrequirereq+"*"+obj[i].actionrequireqId+"--"+$(this).val());
					    	            $(this).attr("selected", "selected");
					    	        } 
					    	       
					    	        if ($(this).val() != obj[0].circleId) {
					    	        	
					    	        	 $(this).removeAttr("selected");
					    	        }
					    	        
					    	        if($(this).val()>0){
					    	        	
				    	            	getDivisions($(this).val(),1);
					    	        }
			    	});
			    	    $(editCircleId).multiselect('rebuild');
			    	    
			    	    $(editDivisionId).each(function () {
			    			 if ($(this).val() == obj[0].divisionId) {
					    	        //	alert("equal"+actionrequirereq+"*"+obj[i].actionrequireqId+"--"+$(this).val());
					    	            $(this).attr("selected", "selected");
					    	        } 
					    	       
					    	        if ($(this).val() != obj[0].divisionId) {
					    	        	
					    	        	 $(this).removeAttr("selected");
					    	        }
					    	        
					    	        if($(this).val()>0){
					    	        	
					    	        	getSubDivisions($(this).val(),1);
					    	        }
			    	});
			    	    $(editDivisionId).multiselect('rebuild');
			    	    
			    	   $(editSubDivisionId).each(function () {
			    			 if ($(this).val() == obj[0].subdivisionId) {
					    	        //	alert("equal"+actionrequirereq+"*"+obj[i].actionrequireqId+"--"+$(this).val());
					    	            $(this).attr("selected", "selected");
					    	  
					    	            
					    	        } 
					    	       
					    	        if ($(this).val() != obj[0].subdivisionId) {
					    	        	
					    	        	 $(this).removeAttr("selected");
					    	        
					    	        	
					    	        }
			    	});
			    	    
			    	    $(editSubDivisionId).multiselect('rebuild');
			    	    
			    		 var oldweirid=0;
			    		 var newweirid=0;
			    		 var oldcount=0;
			    		 
			    		 var oldsluiceid=0;
			    		 var newsluiceid=0;
			    		 var oldsluicecount=0;
			    		 
			    		 
		    		
		    	  for(i in obj){
		    		  
		    		  var dbmapvalue=obj[i].miInspectMapId;
		    		  
		    		 // alert("dbmapvalue"+dbmapvalue) ||(dbmapvalue==45)||( dbmapvalue==46);
		    		if((dbmapvalue<=24)) {
		    		  for(var j=1 ; j<=24 ;j++){
		    			  var mapid="#miInspectMapId"+j ;
		    			  
		    		  var mapvalue=$(mapid).val();
		    		//  alert("mapvalue"+mapvalue);
		    		 
		    		
		    		  var getid=$(mapid).attr('id');
			    		
			    		//alert("getid"+getid);
			    		
			    		//alert("getinsidej"+j);
			    		var checkid="#micheckboxId"+j;
			    		var inspectdateid="#inspectDate"+j;
			    		//alert("checkid"+checkid);
			    		var actionreqidy="#actionreqy"+j;
			    		var actionreqidn="#actionreqn"+j;
			    		var remarks="#remarks"+j;
			    		var editbuttonactive="#editemb"+j;
			    		var deletebuttonactive="#deleteemb"+j;
			    		
			    		var mst2Id="#miInpsectMst2Id"+j;  
			    		 var bunddatedisplay="#bunddate"+j;
			    		  var bundactreqdisplay="#bundactreq"+j;
						  var bundobsdisplay="#bundobs"+j;
						  
						
						  
						
		    		
		    			  
		    		if( dbmapvalue==mapvalue ){
		    			
		    			//alert('cmong here'+bunddatedisplay)
			    		
		    			 $(bunddatedisplay).removeAttr("style");
		    			$(bundactreqdisplay).removeAttr("style");
						$(bundobsdisplay).removeAttr("style");
						
						
						 
						
			    		$(checkid).prop('checked', true);
			    		$(checkid).attr('disabled',true); 
			    		$(inspectdateid).val(obj[i].inspectDate);
			    		$(inspectdateid).attr('disabled',true); 
			    		var actionreqval=obj[i].actionreq;
			    		var actionrequirereq1="#myactionreqid"+j;
			    		if(actionreqval==true){
			    			//alert("actionreqval"+actionreqval);
			    			$(actionreqidy).prop('checked', true);	
			    			
			    			$(actionrequirereq1).show();
			    			$(actionreqidy).attr('disabled', true);	
			    			$(actionreqidn).attr('disabled', true);	
			    			
			    		}
			    		if(actionreqval==false) {
			    			//alert("actionreqval"+actionreqval);
			    			$(actionreqidn).prop('checked', true);
			    			$(actionrequirereq1).hide();
			    			$(actionreqidy).attr('disabled', true);	
			    			$(actionreqidn).attr('disabled', true);	
			    			
			    			
			    		}
			    		$('#miInpsectMst1Id1').val(obj[i].miInpsectMst1Id);
			    		$(mst2Id).val(obj[i].miInpsectMst2Id);
			    		
			    		$(remarks).val(obj[i].remarks);
			    		$(remarks).attr('readonly',true); 
			    		
			    	
			    		 $(editbuttonactive).addClass("eact1");
			    		 $(deletebuttonactive).addClass("dact2");
			    		var actionrequirereq="#actionrequireqId"+j+" option";
			    		//alert("actionrequirereq"+actionrequirereq);
			    		
			    		var newactreqlist="#actionrequireqId"+j ;
			    		$(actionrequirereq).each(function () {
			    	        if ($(this).val() == obj[i].actionrequireqId) {
			    	        //	alert("equal"+actionrequirereq+"*"+obj[i].actionrequireqId+"--"+$(this).val());
			    	           // $(this).attr("selected", "selected");
			    	        	$(newactreqlist).val(obj[i].actionrequireqId);
			    	        	$(newactreqlist).attr('disabled', true);	
			    	            
			    	        } 
			    	       
			    	        if ($(this).val() != obj[i].actionrequireqId) {
			    	        	//alert("not equal"+actionrequirereq+"*"+obj[i].actionrequireqId+"--"+$(this).val());
			    	        	 $(this).removeAttr("selected");
			    	        	 //$(this).prop("disabled",false);
			    	        	
			    	        	
			    	        }
			    	       
			    	});
			    		
			    		 $(actionrequirereq1).prop('disabled', true);	
			    		
			    		
		    		}
		    			
		    			
		    		  }
		    		  
		    	  }
		    		
		    		
		    		
		    		
		    		if(dbmapvalue>24 && dbmapvalue<=34 ) {
			    		  for(var j=1 ; j<=10 ;j++){
			    			  var mapid="#miInspectMapIdslu"+j ;
			    			  
			    		  var mapvalue=$(mapid).val();
			    		 // alert("mapvalue"+mapvalue);
			    		  
			    		  
			    		 
				    		  newsluiceid=obj[i].tankWeirSluiceId; 
				    		  
				    		 // alert("newsluiceid"+newsluiceid);
				    		 
				    		 if(oldsluiceid!=newsluiceid){
				    			 
				    			 oldsluiceid=obj[i].tankWeirSluiceId;
				    			 oldsluicecount++
				    			 
				    			// alert("tankWeirSluiceName"+obj[i].tankWeirSluiceName);
				    			 
				    		 }
				    		// alert("oldsluicecount"+oldsluicecount); 
			    		if(oldsluicecount==1){	  
			    		if( dbmapvalue==mapvalue ){
			    			
			    			  getmiinspectmst2bysluicewier(obj[i].tankWeirSluiceId,2) 	
			    			  
			    			   var sludatedisplay="#slupdateslu"+j;
						  var sluactreqdisplay="#sluactreqslu"+j;
						  var sluobsdisplay="#sluopslu"+j;
						  
						  $(sludatedisplay).removeAttr("style");
							 $(sluactreqdisplay).removeAttr("style");
							 $(sluobsdisplay).removeAttr("style");
						  
			    			  
			    			
			    			//  alert(i+"i")
			    			var slid=obj[i].tankWeirSluiceId;
			    			
			    		//	alert("slid"+slid);

			    			
				    		
			    			
			    		

				    		var sluice="#sluiceId option";
				    		
				    		$("#slsluiceId").val(slid);
				    		
				    
				    		  getsluicelist(obj[i].tankId);
				    		
				    	/*	$(sluice).each(function () {
				    			
				    			 $("#slsluiceId").val(obj[i].tankWeirSluiceId);
				    			 $("#sluiceId").val(obj[i].tankWeirSluiceId);
				    	        $('#sluiceId').multiselect('refresh');
				    	});*/
				    		
				    		
				    		
				    		
			    		/*}*/
			    		
			    		}
			    		}
			    			
			    			
			    		  }
			    		  
			    	  }
		    		
		    		 
		    		
		    		if(dbmapvalue>=35 && dbmapvalue<=44 ) {
		    			
			    		  for(var j=1 ; j<=10 ;j++){
			    			  
			    			  
			    			  var mapid="#miInspectMapIdweir"+j ;
			    			  
			    		  var mapvalue=$(mapid).val();
			    		 // alert("mapvalue"+mapvalue);
			    		 
			    		
				    		 
				    		 newweirid=obj[i].tankWeirSluiceId;
				    		 
				    		// alert("newweirid"+obj[i].tankWeirSluiceId);
				    		 
				    		 if(newweirid!=oldweirid){
				    			 
				    			 oldweirid= obj[i].tankWeirSluiceId;
				    			 oldcount++;
				    			 
				    			// alert("tankWeirSluiceName"+obj[i].tankWeirSluiceName);
				    			 
				    		 }
				    		// alert("oldcount"+oldcount); 
			    		if( oldcount ==1 ){
			    			  
			    		if( dbmapvalue==mapvalue ){
			    			
			    			 getmiinspectmst2bysluicewier(obj[i].tankWeirSluiceId,3)
			    			 
			    			  var weirdatedisplay="#weirpagedateweir"+j;
						  var weiractreqdisplay="#weiractreqweir"+j;
						  var weirobsdisplay="#weirpageobsweir"+j;
						  
						  
							 $(weirdatedisplay).removeAttr("style");
							 $(weiractreqdisplay).removeAttr("style");
							 $(weirobsdisplay).removeAttr("style");
	  
			    			
                               var weirid=obj[i].tankWeirSluiceId;
			    			
			    			//alert("weirid"+weirid);
			    			
			    		
			    			
			    				
				    		
				    		var weir="#weirId option";
				    		
				    		//alert(obj[i].tankWeirSluiceId);
				    		
				    		$("#wiweirId").val(weirid);
				    		 getweirlist(obj[i].tankId)
				    		
				    		/*$(weir).each(function () {
				    			
				    			alert("kal");
				    			
				    		  $("#wiweirId").val(obj[i].tankWeirSluiceId);
				    	      	$("#weirId").val(obj[i].tankWeirSluiceId);
				    	        $('#weirId').multiselect('refresh');
				    	});
				    		*/
				    		
				    		
				    		
				    		
				    		
				    		
			    		}
			    		}
			    			
			    			
			    		  }
			    		  
			    	  }
		    		
		    		
		    	  }
		    	  
		    	
		    		  if(obj[0].miInpsectMst1Id!=null){
		    			  if(obj[0].miInpsectMst1Id>0){
		    		  
		    		  getMiCheckRemarks(obj[0].miInpsectMst1Id);
		    			  }
		    		  
		    	  }
		    	  
		    	
		    	}//end of obj if not null
		    	
		    	
		    	
		    	
		    	
		    	  
		    	  
		    	} // end of if msg is not null

		      },
		      error : function(){
		    	  alert(error);
		      }
		  });
		
		}else{
			
			$('#action_alert').html('<p style="margin: 0px !important;" >please select Year and Monsoon for Bund , Sluice and Weir Checks</p>'); 
			
		}
		
		
	}
	
function getmiinspectmst2bysluicewier(sluiceweirid,hkey){
		
		var sluiceid=sluiceweirid;
         var freq= $('#miTankFreqId').val();
		
		var tankId=$('#tankId').val();
		
		var postId=$('#postId1').val();
		var year=$('#year').val();
		
		  
		  if(hkey==2){
				
				
				
			//  $('#action_alert').html(''); 
	 		  
	 		  $('.schedulecuscheck2').prop('disabled', false);	
	 		  $('.schedulecuscheck2').prop('checked', false);
		    		
	 		
		    		 $('.schedulecuscheck2').val(0);
		    		 $('.sludate').val(0);		    		
		    		  $('.sluradion').prop('checked', true);	
		    		  $('.sluradioy').prop('checked', false);	
		    		  $('.sluradioy').attr('disabled', false);	
		    		  $('.sluradion').attr('disabled', false);	
		    		  
		    		  
						//alert("coming here");
						
						  $(".slupdate").hide();
						 $(".sluactreq").hide();
						 $(".sluop").hide();
		    		
			    		
		    		  var sllist= $('.sllist').val();
		    		   $( ".sluradion" ).each(function() { 
		    		  var isChecked = $('.sluradion').prop('checked');
		    		  
		    		 // alert("isCheckedslu"+isChecked);
		    	
		    		  if(isChecked) {
		    			  
		    			 // alert('kal slu');
		    			
		    			  $('.slureq').removeAttr('style'); 
		    			  $('.slureq').hide(); 
		    			}
		    		  
		    		   });
		    		 $('.sllist').val(0);
		    		 
		    		 $('.sllist').removeAttr('style') ;		
		    		 
		    		  $('.sllist').attr('disabled', false);
 					
					 //$('.sllist').hide();
		    	
		    		 
		    		 $('.sludate').removeAttr('disabled');
		    		 
		    		 $('.sluobs').removeAttr('readonly');
		    		 $('.sluobs').val('');
		    		
		    		 $('#viewhead1').empty();
		    		 $('#viewbody1').empty();
		    		
		    		 $('#slumst1Id').val(0);
		    		
		    		 
		    		 
		    		 
		    		 
		    		 $( ".editslu" ).each(function() {
		    			 if($(".editslu").hasClass('eact1')){	                    
			    				var sluid=$(this).prop('id');			    				
			    			
			    				
			    				var newsluid="#"+sluid;		    				
	                    
			    				  $(newsluid).removeClass('eact1');	    				 
		    					   
		    					   $(newsluid).removeAttr('style') ;			    					   
			    					 //  alert("newsluid"+newsluid);
			    					   $(newsluid).css("display", "none");
			    					   
			    	}
		    			});
		    		 
		    		 $( ".deleteslu" ).each(function() {
		    			 if($(".deleteslu").hasClass('dact2')){                    
			    				var delslu=$(this).prop('id');			    				
			    				
			    				
			    				var newdelslu="#"+delslu;		    				
	                    
			    				  $(newdelslu).removeClass('dact2');	    				 
		    					   
		    					   $(newdelslu).removeAttr('style') ;			    					   
			    					
			    					   $(newdelslu).css("display", "none");
			    					   
			    	}
		    			});
		    		 
		    		
		    		 
		    		
                     	  
                    	
		    				   
		    				
	    			
		    		 
		    		 //$("#editslu").removeClass("eact1");
					// $("#deleteslu").removeClass("dact2");
					// $("#editslu").hide();
					// $("#deleteslu").hide();
		    	
			
			
		}
		
		if(hkey==3){
			
			//  $('#action_alert').html(''); 
	 		  
	 		  $('.schedulecuscheck3').prop('disabled', false);	
	 		  $('.schedulecuscheck3').prop('checked', false);
		    		
	 		
		    		 $('.schedulecuscheck3').val(0);
		    		 $('.weirdate').val(0);		    		
		    		  $('.weirradion').prop('checked', true);	
		    		  $('.weirradioy').prop('checked', false);	
		    		  $('.weirradioy').attr('disabled', false);	
		    		  $('.weirradion').attr('disabled', false);	
		    		  
		    		//  alert("coming weir");
		    		  
		    		  $(".weirpagedate").hide();
						 $(".weiractreq").hide();
						 $(".weirpageobs").hide();
			    		 
		    		  
		    		
		    		  var wrlist= $('.wrlist').val();
		    	
		    		 
		    		  
		    		 $('.wrlist').val(0);
		    		 $('.wrlist').removeAttr('style') ;	
		    		 
		    		
		    	       $('.wrlist').attr('disabled', false);
		    	   
		    	       $( ".weirradion" ).each(function() {
		    	       var isChecked = $('.weirradion').prop('checked');
			    		  
			    		 // alert("isCheckedweir"+isChecked);
		    	       
		    	      
			    	
			    		  if(isChecked) {
			    			  
		    	       
		    	     
			    			 //alert("kalweir") ;
			    			 
			    			  $('.weirreq').removeAttr('style'); 
			    			  $('.weirreq').hide(); 
			    			}
	 					
		    	       });
		    		 
		    	
		    		 
		    		 $('.weirdate').removeAttr('disabled');
		    		 
		    		 $('.weirobs').removeAttr('readonly');
		    		 $('.weirobs').val('');
		    		
		    		 $('#viewhead1').empty();
		    		 $('#viewbody1').empty();
		    		
		    		 $('#weirmst1Id').val(0);
		    		 
		    		 
		    		 $( ".editweir" ).each(function() {
		    			 if($(".editweir").hasClass('eact1')){	                    
			    				var weirid=$(this).prop('id');			    				
			    				
			    				
			    				var newweirid="#"+weirid;		    				
	                    
			    				  $(newweirid).removeClass('eact1');	    				 
		    					   
		    					   $(newweirid).removeAttr('style') ;			    					   
			    					
		    					   
			    					   $(newweirid).css("display", "none");
			    					   
			    	}
		    			});
		    		 
		    		 $( ".deleteweir" ).each(function() {
		    			 if($(".deleteweir").hasClass('dact2')){                    
			    				var delweir=$(this).prop('id');			    				
			    				//alert("sluid"+sluid);
			    				
			    				var newdelweir="#"+delweir;		    				
	                    
			    				  $(newdelweir).removeClass('dact2');	    				 
		    					   
		    					   $(newdelweir).removeAttr('style') ;			    					   
			    					 //  alert("newsluid"+newsluid);
			    					   $(newdelweir).css("display", "none");
			    					   
			    	}
		    			});
		    		 
		    		 
		    		    	
			
		}

		
		
		if(sluiceid>0){
			
	
		
			$.ajax({	          
			      url: "../invtsimis/getmst2bysluiceid?year="+year+"&tankId="+tankId+"&miTankFreqId="+freq+"&tankWeirSluiceId="+sluiceid,
			      type: "GET",
			      contentType: "application/json; charset=utf-8",
			      success: function (msg) {
			    	  
			    	
			    		if(msg!=null){  
				    		
					    	  
					    	  var obj = JSON.parse(msg);		
					    	  for(i in obj){
					    		  
					    		  var dbmapvalue=obj[i].miInspectMapId;
					    		  
			
					    		
					    		if(dbmapvalue>24 && dbmapvalue<=34 ) {
					    			
					    			
					    			
					    			
					    			
						    		  for(var j=1 ; j<=10 ;j++){
						    			  var mapid="#miInspectMapIdslu"+j ;
						    			  
						    		  var mapvalue=$(mapid).val();
						    		//  alert("mapvalue"+mapvalue);
						    		  
						    		 
						    		  
						    			
							    		  
						    		
						    			  
						    		if( dbmapvalue==mapvalue ){
						    			
						    			var getid=$(mapid).attr('id');
							    		
							    		//alert("getid"+getid);
							    		
							    		//alert("getinsidej"+j);
							    		var checkid="#micheckboxIdslu"+j;
							    		
							    		var inspectdateid="#inspectDateslu"+j;
							    		//alert("checkid"+checkid);
							    		var actionreqidy="#actionreqsluy"+j;
							    		var actionreqidn="#actionreqslun"+j;
							    		var remarks="#remarksslu"+j;
							    		var editbuttonactive="#editslu"+j;
							    		var deletebuttonactive="#deleteslu"+j;
							    		var mst2Id="#miInpsectMst2Idslu"+j;
							    		
							    		 var sludatedisplay="#slupdateslu"+j;
										  var sluactreqdisplay="#sluactreqslu"+j;
										  var sluobsdisplay="#sluopslu"+j;
                                     
							    		
                                     
										  $(sludatedisplay).removeAttr("style");
											 $(sluactreqdisplay).removeAttr("style");
											 $(sluobsdisplay).removeAttr("style");
								    		 
								    		 
							    		$(checkid).prop('checked', true);
							    		$(checkid).attr('disabled',true); 
							    		$(inspectdateid).val(obj[i].inspectDate);
							    		$(inspectdateid).attr('disabled',true); 
							    		
							    		
							    		var actionreqval=obj[i].actionreq;
							    		var actionrequirereq1="#myactionreqidslu"+j;
							    		if(actionreqval==true){
							    			//alert("actionreqval"+actionreqval);
							    			$(actionreqidy).prop('checked', true);	
							    			
							    			$(actionrequirereq1).show();
							    			$(actionreqidy).attr('disabled', true);	
							    			$(actionreqidn).attr('disabled', true);	
							    			
							    		}
							    		if(actionreqval==false) {
							    			//alert("actionreqval"+actionreqval);
							    			$(actionreqidn).prop('checked', true);
							    			$(actionrequirereq1).hide();
							    			$(actionreqidy).attr('disabled', true);	
							    			$(actionreqidn).attr('disabled', true);	
							    			
							    		}
							    		$('#miInpsectMst1Id2').val(obj[i].miInpsectMst1Id);
							    		$(mst2Id).val(obj[i].miInpsectMst2Id);
							    		$(remarks).val(obj[i].remarks);
							    		$(remarks).attr('readonly',true); 
							    		 $(editbuttonactive).addClass("eact1");
							    		 $(deletebuttonactive).addClass("dact2");
							    		
							    		var actionrequirereq="#actionrequireqIdslu"+j+"  option";
							    		
							    		var newactreqlist="#actionrequireqIdslu"+j ;
							    		//alert("actionrequirereq"+actionrequirereq);
							    		
							    		$(actionrequirereq).each(function () {
							    			 if ($(this).val() == obj[i].actionrequireqId) {
									    	        //	alert("equal"+actionrequirereq+"*"+obj[i].actionrequireqId+"--"+$(this).val());
									    	            //$(this).attr("selected", "selected");
							    					$(newactreqlist).val(obj[i].actionrequireqId);
							    					$(newactreqlist).attr('disabled', true);	
									    	         
									    	            
									    	        } 
									    	       
									    	        if ($(this).val() != obj[i].actionrequireqId) {
									    	        	//alert("not equal"+actionrequirereq+"*"+obj[i].actionrequireqId+"--"+$(this).val());
									    	        	 $(this).removeAttr("selected");
									    	        	 //$(this).prop("disabled",false);
									    	        	
									    	        	
									    	        }
							    	});
							    		 $(actionrequirereq1).prop('disabled', true);	
							    		
							    		var sluice="#sluiceId option";
							    		
							    		$(sluice).each(function () {
							    			
							    			//$("#selectedtankWeirSluiceId").val(obj[i].tankWeirSluiceId);
							    			
							    	      	$("#sluiceId").val(obj[i].tankWeirSluiceId);
							    	        $('#sluiceId').multiselect('refresh');
							    	});
							    		
							    		var vslid=parseInt($('#sluiceId').val());
							   		// alert(vslid);
							   		 if(vslid!=null && vslid>0 ){
							   		//	 alert("dollar: "+vslid);
							   		   $('#editsluice').show();

							   		 }else {
							   		    $('#editsluice').hide();
							   		 }
							    		
							    		
						    		}
						    			
						    			
						    		  }
						    		  
						    	  }
					    		
					    		if(dbmapvalue>=35 && dbmapvalue<=44 ) {
					    			
					    			
					    			
					    			
						    		  for(var j=1 ; j<=10 ;j++){
						    			 // alert("j"+j);
						    			  var mapid="#miInspectMapIdweir"+j ;
						    			  
						    		  var mapvalue=$(mapid).val();
						    		 // alert("mapvalue"+mapvalue);
						    		 
						    		
							    		  
						    		
						    			  
						    		if( dbmapvalue==mapvalue ){
						    			
						    			var getid=$(mapid).attr('id');
							    		
							    		//alert("getid"+getid+"---j"+j);
							    		
							    		//alert("getinsidej"+j);
							    		var checkid="#micheckboxIdweir"+j;
							    		var inspectdateid="#inspectDateweir"+j;
							    		//alert("checkid"+checkid);
							    		var actionreqidy="#actionreqweirsy"+j;
							    		var actionreqidn="#actionreqweirsn"+j;
							    		var remarks="#remarksweir"+j;
							    		var editbuttonactive="#editweir"+j;
							    		var deletebuttonactive="#deleteweir"+j;
							    		var mst2Id="#miInpsectMst2Idweir"+j;
							    		
							    		 var weirdatedisplay="#weirpagedateweir"+j;
										  var weiractreqdisplay="#weiractreqweir"+j;
										  var weirobsdisplay="#weirpageobsweir"+j;
										  
										  
										  $(weirdatedisplay).removeAttr("style");
											 $(weiractreqdisplay).removeAttr("style");
											 $(weirobsdisplay).removeAttr("style");
								    		 
							    		
							    		

										// alert("checkid"+checkid);

							    		$(checkid).prop('checked', true);
							    		$(checkid).attr('disabled',true); 
							    		//alert(obj[i].inspectDate);
							    		$(inspectdateid).val(obj[i].inspectDate);
							    		$(inspectdateid).attr('disabled',true); 
							    		var actionreqval=obj[i].actionreq;
							    		var actionrequirereq1="#myactionreqidweir"+j;
							    		if(actionreqval==true){
							    			//alert("actionreqval"+actionreqval);
			                                $(actionreqidy).prop('checked', true);	
							    			
							    			$(actionrequirereq1).show();
							    			$(actionreqidy).attr('disabled', true);	
							    			$(actionreqidn).attr('disabled', true);	
							    			
							    			
							    		}
							    		if(actionreqval==false) {
							    			//alert("actionreqval"+actionreqval);
							    			$(actionreqidn).prop('checked', true);
							    			$(actionrequirereq1).hide();
							    			$(actionreqidy).attr('disabled', true);	
							    			$(actionreqidn).attr('disabled', true);	
							    			
							    			
							    		}
							    		$('#miInpsectMst1Id3').val(obj[i].miInpsectMst1Id);
							    		$(mst2Id).val(obj[i].miInpsectMst2Id);
							    		$(remarks).val(obj[i].remarks);
							    		$(remarks).attr('readonly',true); 
							    		
							    		 $(editbuttonactive).addClass("eact1");
							    		 $(deletebuttonactive).addClass("dact2");
							    		 
							    		var actionrequirereq="#actionrequireqIdweir"+j+" option";
							    		
							    		var newactreqlist="#actionrequireqIdweir"+j ;
							    		//alert("actionrequirereq"+actionrequirereq);
							    		$(actionrequirereq).each(function () {
							    			 if ($(this).val() == obj[i].actionrequireqId) {
									    	        	//alert("equal"+actionrequirereq+"*"+obj[i].actionrequireqId+"--"+$(this).val());
									    	        	
									    	        	
									    	        	
									    	        	$(newactreqlist).val(obj[i].actionrequireqId);
									    	        	$(newactreqlist).attr('disabled', true);
									    	        	
									    	          //  $(actionrequirereq).attr("selected", "selected");
									    	         
									    	            
									    	        } 
									    	       
									    	        if ($(this).val() != obj[i].actionrequireqId) {
									    	        	//alert("not equal"+actionrequirereq+"*"+obj[i].actionrequireqId+"--"+$(this).val());
									    	        	 $(this).removeAttr("selected");
									    	        	 //$(this).prop("disabled",false);
									    	        	
									    	        	
									    	        }
							    	});
							    		
							    		 $(actionrequirereq1).prop('disabled', true);		
							    		
							    		var weir="#weirId option";
							    		
							    		
							    		$(weir).each(function () {
							    			
							    			//$("#selectedtankWeirSluiceId").val(obj[i].tankWeirSluiceId);
							    			
							    	      	$("#weirId").val(obj[i].tankWeirSluiceId);
							    	        $('#weirId').multiselect('refresh');
							    	});
							    		
							    		var wlid=parseInt($('#weirId').val());
							   		// alert(wlid);
							   		 
							   			
							   		 if(wlid!=null && wlid>0 ){
							   		//	 alert("dollar: "+wlid);
							   		   $('#editweirname').show();

							   		 }
							   		 else {
							   		    $('#editweirname').hide();
							   		 }    
							    		
							    		
						    		}
						    			
						    			
						    		  }
						    		  
						    	  }
					    		
					    		
					    	  }
					    	  
					    	  if(obj!=null){
					    		  if(obj[0].miInpsectMst1Id!=null){
					    			  if(obj[0].miInpsectMst1Id>0){
					    		  
					    		  getMiCheckRemarks(obj[0].miInpsectMst1Id);
					    			  }
					    		  }
					    	  }
		    		 
					    	  
			    		}
			    		
			    		
	    		 
			      },
			      error : function(){
			    	  alert(error);
			      }
			  });
	    	}
		
		
		
	}
	
	function getCurrentTime() {
	    var CurrentTime = "";
	    try {
	        var CurrentDate = new Date();
	        var CurrentHours = CurrentDate.getHours();
	        var CurrentMinutes = CurrentDate.getMinutes();
	        var  CurrentSeconds= CurrentDate.getSeconds();
	        var CurrentAmPm = "A'M'";
	        if (CurrentMinutes < 10) { CurrentMinutes = "0" + CurrentMinutes; }

	       /* if (CurrentHours == 12) {
	            CurrentHours = 12;
	            CurrentAmPm = " P'M'";
	        }
	        else if (CurrentHours == 0) {
	            CurrentHours = 12;
	            CurrentAmPm = " A'M'";
	        }
	        else if (CurrentHours > 12) {
	            CurrentHours = CurrentHours - 12;
	            CurrentAmPm = " P'M'";
	        }
	        else {
	            CurrentAmPm = " A'M'";
	        }*/
	        CurrentTime = "" + CurrentHours + ":" + CurrentMinutes +":" + CurrentSeconds +  "";
	    }
	    catch (ex) {
	    }
	    return CurrentTime;
	}
	
	
	//show edit button based on remarks
	function getMiCheckRemarks(mstId){
		
	var miinspectId=mstId;	
if(mstId!=null){
	$("#embmst1Id").val(miinspectId);
	  $("#slumst1Id").val(miinspectId);
	  $("#weirmst1Id").val(miinspectId);
}else{
	
	$("#embmst1Id").val(0);
	  $("#slumst1Id").val(0);
	  $("#weirmst1Id").val(0);
	
}
	
	
	var postId=$("#postId1").val();
	//var nextPostId=$("#nextPostId1").val();
	
	var userdesignation=$("#designationId1").val();
	

	//alert(miinspectId+"-----"+postId);
	
	$.ajax({	          
	      url: "../invtsimis/getMiTankMst1Remarks?mst1Id="+miinspectId+'&postId='+postId,
	      type: "GET",
	      contentType: "application/json; charset=utf-8",
	      success: function (msg) {
	    	  
	    	// console.log(msg);
	    	 
	    	// alert(msg);
	    	  
	    	  var obj = JSON.parse(msg);
	    	  
	    	  for(i in obj){
	  
	    		  if(postId= obj[i].postId){
	    			// alert("i am "+obj[i].nextPostId);
	    			//30012021var editclassname=  $("#editemb9").prop('class'); 
	    			//alert('editclassname'+editclassname);
	    			  if( ( userdesignation==2) || ( userdesignation==8) ){
	    			$(".eact1").attr("style", "display:block !important");
	    			$(".dact2").attr("style", "display:block !important");
	    			 
	    			  }
	    		  }
	    	    
	    	
	    	  }
	    	  
	    	

	      },
	      error : function(){
	    	  alert(error);
	      }
	  });
		
		
		
		
		
	}
	
	




	/*function getrepairdata(tankId){
		
		
		
		//alert(year+tankId+freq);
		$("#thead5").empty();
		$("#tbody5").empty();
		
		
		$.ajax({	          
		      url: "../invtsimis/getmirepairs?tankId="+tankId,
		      type: "GET",
		      contentType: "application/json; charset=utf-8",
		      success: function (msg) {
		    	  
		    	//console.log("repairdata"+msg);
		    	  if(msg!=null){
		    	  var obj = JSON.parse(msg);
		    	  
		    	  var j=1;
		    	  
		    	
		    	    $('#repairsdata table thead').append(  '<tr style="font-size: 18px">'+
		    	    		'<th style="color: blue">District</th><th style="color: red">'+obj[0].districtName+'</th>'+
		    	    		'<th style="color: blue">Mandal</th><th style="color: red">'+obj[0].mandalName+' </th>'+
		    	    		'<th style="color: blue">Village</th><th style="color: red">'+obj[0].villageName+'</th>'+
		    	    		'<th style="color: blue">Tank Name</th><th style="color: red">'+obj[0].tankName+'</th></tr>'+
		    	    		'<tr style="font-size: 18px; color: gray; font-weight: bold;"><th>Sl.No</th>'+
		    	    		' <th>ComponentName </th>'+
		    	    		'<th>Rate</th>'+
		    	    		'<th>Quantity</th>	'+
		    	    		' <th>Amount</th>'+
		    	    		'<th>Units</th>'+
		    	    		' <th>StartDate-EndDate</th>'+
		    	    		' <th>Scheme Taken</th>'+
		    	    		' <th>Description of Repair</th>'+
		    	    		'<th colspan="2">Action</th></tr>'); 	  
		    	    
		    	    for(i in obj){
		    	    	
		    	    	   $('#repairsdata table tbody').append(  '<tr style="font-size: 16px">' +
		    	    			                                '<td style="text-align: center;">'+j+'</td>' +
		    	    			                                '<td><b>'+obj[i].miCompName+'</b></td>' +
		    	    			                                '<td><b>'+obj[i].rate+'</b></td>' +
		    	    			                                '<td><b>'+obj[i].quantity+'</b></td>' +
		    	    			                                '<td><b>'+obj[i].amount+'</b></td>' +
		    	    			                                '<td><b>'+obj[i].unitMeasureName+'</b></td>' +	    	    			                               
		    	    			                                '<td><b>'+obj[i].repairStartDate+'-'+obj[i].repairEndDate+'</b></td>'+
		    	    			                                '<td><b>'+obj[i].schemeTaken+'</b></td>' +
		    	    			                                '<td><b>'+obj[i].repairDescription+'</b><input  value="'+obj[i].ommirepairId+'" name="mitankRepairsId" id="dbrepairId'+j+'" class="dbrepairId" type="hidden" /> </td>' +
		    	    			                                
		    	    			                                '<td colspan="2"><button type="button" name="remarksinout" id="addrepairreview'+j+'" class=" btn btn-1 btn-primary center-block repairremadd  "  onclick="addrepairReviewinfo('+obj[i].ommirepairId+','+obj[i].tankId+')"   >Add Remarks</button>'+
		    	    			                                '<button type="button" name="viewremarksrepair" id="viewrepairinfo'+j+'" class=" btn btn-1 btn-primary center-block repairremview "  onclick="viewrepairReview('+obj[i].ommirepairId+','+obj[i].tankId+')"   >View Remarks</button>'+
		    	    			                                '<button type="button" name="editrepair" id="editrepair'+j+'" class="btn btn-1 btn-primary center-block repairedit" onclick="editrepairdata('+obj[i].ommirepairId+',5)"  >Edit</button>'+
		    	    			                                '<button type="button" name="deleterepair" id="deleterepair'+j+'" class="btn btn-1 btn-primary center-block repairdelete " onclick="deleterepairdata('+obj[i].ommirepairId+',5,'+obj[i].tankId+')"  >Delete</button>  </td></tr>');
		    	    	   
		    	    	   
		    	    	  
		    	    	   
		    	    	   j++;
		    	    }
		    	    
		    	    $(".repairremadd").hide();
			    	  $(".repairedit").hide();
			    	  $(".repairdelete").hide();
			    	  
			    	  
			    	  
			    	  
		    	    
		    	    gettankrepairRemarks(tankId)
		    	
		    	  } 
		    	    
		    	
		    	

		      },
		      error : function(){
		    	  alert(error);
		      }
		  });
		
		
	}*/
	
/*function gettankrepairRemarks(tankId){
		
		
		
		//alert(year+tankId+freq);
		
	
		var postId=$("#postId5").val();
		var userdesignation=$("#designationId5").val();
		
		//alert("postId"+postId);
		
		
		
		$.ajax({	          
		      url: "../invtsimis/getMiTankRepairRemarks?tankId="+tankId+"&nextPostId="+postId,
		      type: "GET",
		      contentType: "application/json; charset=utf-8",
		      success: function (msg) {
		    	  
		    	// console.log("remarksdata"+msg);
		    	// alert(msg)
		    	  
		    	  var obj = JSON.parse(msg);
		    	  
		    	  var j=1;
		   		
		    	    for(i in obj){
		    	    	
		    	    	var rdbnextpostId=obj[i].nextPostId;
		    	    	  var dbrid=obj[i].mitankRepairsId;
		    	    	
                       $('.dbrepairId').each(function() {
		    	    			   
		    	    			   var repairval=$(this).val(); 
		    	    			   
		    	    			 //  alert("repairval"+repairval+'=='+dbrid);
		    	    			   
		    	    			   if(repairval==dbrid){
		    	    				   
		    	    				
				    	    		   var repid=$(this).prop('id'); 
				    	    		  var rep= repid.substring(10, repid.length);
				    	    		  var redit="#editrepair"+rep;
				    	    		  var rremarks="#addrepairreview"+rep;
				    	    		  var rdelete="#deleterepair"+rep;
				    	    		//  var rviewrem="#viewrepairinfo"+rep;
				    	    		
				    	    			if(((postId==rdbnextpostId) &&  (( userdesignation==4) || ( userdesignation==5)|| ( userdesignation==6) ||( userdesignation==7) || ( userdesignation==9) || ( userdesignation==10)))){  
				    	    		  $(redit).show();
				    	    		   $(rremarks).show();   
				    	    		  // $(rviewrem).show();
				    	    			}
				    	    			 if((postId==rdbnextpostId) && ((userdesignation==5)|| ( userdesignation==6) ||( userdesignation==7) || ( userdesignation==9) || ( userdesignation==10))){
					    	    			
					    	    			$(rdelete).show();
					    	    			 $(redit).show();
						    	    		   $(rremarks).show();   
					    	    		}	
			    				   
		    	    			   }
		    	    			});
		    	    		   
		    	    
		    	    	 j++;
		    	    }
		    	    
		    	  
		    	    
		
		      },
		      error : function(){
		    	  alert(error);
		      }
		  });
		
		
	}*/

/*function editrepairdata(repairid,tabId){
	
	 $('#miinfo_dialogue').dialog('option', 'title', 'Edit Repairs');
	  $('#miinfo_dialogue').dialog('open');
	  
	  $('#editinfoformid').trigger("reset"); 
	  
	//  alert("i ama inflow"+inflowid+tabId);
	  
	  $.ajax({	          
			url: "../invtsimis/get-edit-repairdata" ,
			method:"GET",
			dataType: 'json',

			async: false,
			data: {
				  
				mitankRepairsId:repairid,
				  
				  tabId:tabId
			},


			success: function (obj) {

				  
				// console.log("repairs"+obj);
				 //alert("geteditrepairs"+obj);
				  if(obj!=null){
						 var tab="#infotabId";
						 
						 var selectedrepaiid="#selectedrepairId";
							var tankId ="#selectinfoTankId";
							
							 var rcompId="#editrepairCompId";
							 var rrate="#editrate" ;
							  var rquantity="#editquantity";
							 var ramount="#editamount";
							 var runitmeasureId="#editunitMeasureId";
							 var rdescId="#editrepairdescId";
							 var hiddendescId="#selectededitrepdescId";
							// var rdate="#editinspectDaterepair";
							// var rschemetaken="#editschemeTaken";
							// var rrepairdesc="#editrepairDescription";
							// var rremarks="#editremarksrepair";
							
						
						   
				
				//  var obj = JSON.parse(response);
			    
			    	  for(i in obj){
			  
			
				  $(tankId).val(obj[i].tankId); 
				  $(rcompId).val(obj[i].miCompId); 
				  $(rrate).val(obj[i].rate); 
				  $(rquantity).val(obj[i].quantity); 
				  $(ramount).val(obj[i].amount); 
				  $(runitmeasureId).val(obj[i].unitMeasureId); 
				  $(rdescId).val(obj[i].repairdescId); 
				  $(hiddendescId).val(obj[i].repairdescId); 
				  
				  getrepairdesclist(obj[i].tankId)
				  
				  //$(rdate).val(obj[i].inspectDate); 
				 // $(rschemetaken).val(obj[i].schemeTaken); 
				//  $(rrepairdesc).val(obj[i].repairDescription); 
				//  $(rremarks).val(obj[i].remarks); 
				
				  
				 
			    	  }
			    	  
			    	  $(selectedrepaiid).val(repairid); 
					  $(tab).val(tabId); 
				 
				  }
				  if(obj==0||obj==null){
					
					  $('#action_alert').html('<p style="margin: 0px !important;">Failed to get Data</p>');
					  $("html,body").animate({scrollTop:0}, 500);
					  }
				   
				//  gettankfeeddata(tankId) ; 
				

			},
			error : function(){
				 alert(error);

			}
			});
	
}*/

	function getcapacitydata(tankId){
		
		
		
		//alert(year+tankId+freq);
		$("#thead6").empty();
		$("#tbody6").empty();
		
		
		
		$.ajax({	          
		      url: "../invtsimis/getMiCapacity?tankId="+tankId,
		      type: "GET",
		      contentType: "application/json; charset=utf-8",
		      success: function (msg) {
		    	  
		    	// console.log(msg);
		    	 if(msg!=null){ 
		    	  var obj = JSON.parse(msg);
		    	  
		    	  var j=1;
		    	  
		    	
		    	    $('#capacitydata table thead').append(  '<tr style="font-size: 18px">'+
		    	    		'<th style="color: blue">District</th><th style="color: red">'+obj[0].districtName+'</th>'+
		    	    		'<th style="color: blue">Mandal</th><th style="color: red">'+obj[0].mandalName+' </th>'+
		    	    		'<th style="color: blue">Village</th><th style="color: red">'+obj[0].villageName+'</th>'+
		    	    		'<th style="color: blue">Tank Name</th><th style="color: red">'+obj[0].tankName+'</th>'+
		    	    		'<th></th>'+
		    	    		'<th></th></tr>'+
		    	    		'<tr style="font-size: 18px; color: gray; font-weight: bold;"><th>Sl.No</th>'+
		    	    		' <th>Gross Capacity </th>'+
		    	    		'<th>Available Capacity</th>'+
		    	    		'<th>Tank Level</th>'+
		    	    		'<th>Inflow</th>'+
		    	    		'<th>Outflow</th>'+
		    	    		'<th>Ayacut</th>'+
		    	    	
		    	    		'  <th>Surplus</th>'+
		    	    		' <th>Inspect Date</th>'+
		    	    		'<th >Action</th></tr>'); 	  
		    	    
		    	    for(i in obj){
		    	    	
		    	    	   $('#capacitydata table tbody').append(  '<tr style="font-size: 16px">' +
		    	    			                                '<td style="text-align: center;">'+j+'</td>' +
		    	    			                                '<td><b>'+obj[i].grossCapacity+'</b></td>' +
		    	    			                                '<td><b>'+obj[i].availableCapacity+'</b></td>' +
		    	    			                                '<td><b>'+obj[i].tankLevel+'</b></td>' +
		    	    			                                '<td><b>'+obj[i].inflow+'</b></td>' +
		    	    			                                '<td><b>'+obj[i].outfow+'</b></td>' +
		    	    			                                '<td><b>'+obj[i].ayacut+'</b></td>' +
		    	    			                             
		    	    			                                
		    	    			                                '<td><b>'+obj[i].surplus+'</b></td>' +
		    	    			                                '<td><b>'+obj[i].inspectDate+'</b><input  value="'+obj[i].ommicapacityId+'" name="mitankCapacityId" id="dbcapacityId'+j+'" class="dbcapacityId" type="hidden" /> </td>' +
		    	    			                                	    	    			                               
		    	    			                                '<td  > <button type="button" name="remarksinout" id="addcapreview'+j+'" class=" btn btn-1 btn-primary center-block capacityremadd  "  onclick="addcapacityReviewinfo('+obj[i].ommicapacityId+','+obj[i].tankId+')"   >Add Remarks</button> &emsp; &emsp; '+
		    	    			                                '<button type="button" name="viewcapacityinfo" id="viewcapacityinfo'+j+'" class=" btn btn-1 btn-primary center-block capacityremview "  onclick="viewcapacityReview('+obj[i].ommicapacityId+','+obj[i].tankId+')"   >View Remarks</button> &emsp; &emsp; '+
		    	    			                                '<button type="button" name="editcapacity" id="editcapacity'+j+'" class="btn btn-1 btn-primary center-block capacityedit" onclick="editcapacitydata('+obj[i].ommicapacityId+',5)"  >Edit</button> &emsp; &emsp;'+
		    	    			                                '<button type="button" name="deletecapacity" id="deletecapacity'+j+'" class="btn btn-1 btn-primary center-block capacitydelete " onclick="deletecapacitydata('+obj[i].ommicapacityId+',5,'+obj[i].tankId+')"  >Delete</button> </td> &emsp; &emsp;'+
		    	    			                                '</tr>');
		    	    	   
		    	    	   
		    	    	  
		    	    	   
		    	    	   j++;
		    	    }
		    	    
		    	
			    	  $(".capacityedit").hide();
			    	  $(".capacitydelete").hide();
			    	  $(".capacityremadd").hide();
			    	  
			    	
  	    			  
			    	  
			    	 
			    	  
			    	  
		    	    gettankcapacityRemarks(tankId);
		    	 }
		      },
		      error : function(){
		    	  alert(error);
		      }
		  });
		
		
		
	
     //  var idnew="table6" ;
		
		//alert("idnew"+idnew);

	//  gettableexport(idnew);
		
		
	}
	
	
function gettankcapacityRemarks(tankId){
		
		
		
	//	alert("tankId"+tankId);
	
	//  $('#capacitydata table tbody tr').find('td:last-child').remove();
	  	//  $('#capacitydata table tbody tr').find('td:last-child').remove();
		
		//$("#actionType").empty();
		var postId=$("#postId6").val();
		var userdesignation=$("#designationId6").val();
		
		//alert("userempId"+userempId);
		
		
		
		$.ajax({	          
		      url: "../invtsimis/getMiTankCapacityRemarks?tankId="+tankId+"&postId="+postId,
		      type: "GET",
		      contentType: "application/json; charset=utf-8",
		      success: function (msg) {
		    	  
		    	// console.log(msg);
		    	 // alert(msg);
		    	 
		    	 
		    	 if(msg===null||msg===0 || msg==='[]'){
		    		 
		    		  if( (( userdesignation==4) || ( userdesignation==5) || ( userdesignation==7) || ( userdesignation==9) || ( userdesignation==10) )){
	    	    			
	    				 // alert("not coming here")
	    				  $(".capacityremadd").removeAttr("style");
	    				
	    				  
	    	    		}	
   	    		   
	    		   
	    		 
		    		  
		    	  }
		    	 
		    	 if(msg!=null){
		    	  
		    	  var obj = JSON.parse(msg);
		    	  
		    	  var j=1;
		    	  
		    	  
		    	  
		    
		    		
		    	    for(i in obj){
		    	    
		    	    	var cdbpostId=obj[i].postId;
		    	    	  var dbcid=obj[i].mitankCapacityId;
		    	    	  
		    	    	//  alert("dbcid"+dbcid);
		    	    	
		    	   	   $('.dbcapacityId').each(function() {
		    	    			   
		    	    			   var capacityval=$(this).val(); 
		    	    			   
		    	    			  // alert("capacityval"+capacityval+'=='+dbcid);
		    	    			   
		    	    			   if(capacityval==dbcid){
		    	    				   
		    	    				
				    	    		   var capid=$(this).prop('id'); 
				    	    		  var cap= capid.substring(12, capid.length);
				    	    		  var cedit="#editcapacity"+cap;
				    	    		  var cremarks="#addcapreview"+cap;
				    	    		  var cdelete="#deletecapacity"+cap;
				    	    		  var cadd="#addcapreview"+cap;
		   		    	    		 // alert("cap"+cadd)
				    	    		
				    	    		//  var cviewrem="#viewcapacityinfo"+cap;
				    	    		
				    	    			if(((postId==cdbpostId) &&  (( userdesignation==2) || ( userdesignation==8)))){  
				    	    		  $(cedit).show();
				    	    		 
				    	    			$(cdelete).show();
				    	    		  // $(cviewrem).show();
				    	    			}
				    	    			 
				    	    			  
				    	    			  if(( userdesignation==4) || ( userdesignation==5)|| ( userdesignation==6) || ( userdesignation==7)|| ( userdesignation==9) ){
				    	    			  
				    	    				  $(".capacityremadd").removeAttr("style");
				    	    		   
				    	    			  }
				    	    			  
				    	    			  if((postId==cdbpostId) && (( userdesignation==4) || ( userdesignation==5)|| ( userdesignation==6) || ( userdesignation==7)|| ( userdesignation==9) )){
				       	    				  
				       	    				
				    	    	    			/*$(cdelete).show();
				    	    	    			 $(cedit).show();*/
				    	    	    			 $(cadd).show();
				    	    	    			 
				    	    	    			 
				    		    	    		  
				    	    	    		}	
				    	    			  
				    	    			 
				    	    			 
		    	    			   }
		    	    		
                     
		    	   	});
		    	    	 
		    	    	 j++;
		    	    }
		    	    
		    		
		    	 } 
		    	
		    	    
		
		      },
		      error : function(){
		    	  alert(error);
		      }
		  });
		
		
	}

function editcapacitydata(capacityId,tabId){
	
	 $('#miinfo_dialogue').dialog('option', 'title', 'Edit Capacity');
	  $('#miinfo_dialogue').dialog('open');
	  
	  $('#editinfoformid').trigger("reset"); 
	  

	  
	
	  
	  $.ajax({	          
			url: "../invtsimis/get-edit-capacitydata",
			method:"GET",
			dataType: 'json',

			async: false,
			data: {
				  
				mitankCapacityId:capacityId,
				  
				  tabId:tabId
			},


			success: function (obj) {

				  
				// console.log("repairs"+obj);
				 //alert("geteditrepairs"+obj);
				  if(obj!=null){
						 var tab="#infotabId";
						 
						 var selectedcapacityid="#selectedcapacityId";
							var tankId ="#selectinfoTankId";
							
							 var ccapacity="#editavailableCapacity";
							 var csurplusn="#editsurplusn" ;
							  var csurplusy="#editsurplusy";
							 var capacitydate="#editinspectDatecapacity";
							 var inflow="#infinflow";
							 var outflow="#infoutfow";
							 var tanklevel="#inftankLevel";
							 var ayacut="#infayacut";
							// var capacityremarks="#editremarkscapacity";
							
							
							
						
						   
				
				//  var obj = JSON.parse(response);
			    
			    	  for(i in obj){
			  
			
				  $(tankId).val(obj[i].tankId); 
				  $(ccapacity).val(obj[i].availableCapacity); 
				  
				  $(inflow).val(obj[i].inflow); 
				  $(outflow).val(obj[i].outfow); 
				  $(tanklevel).val(obj[i].tankLevel); 
				  $(ayacut).val(obj[i].ayacut); 
				  
				  if(obj[i].surplus==true){
					  
					  $(csurplusy).prop('checked', true);  
					  
				  }
           if(obj[i].surplus==false){
					  
					  $(csurplusn).prop('checked', true);
					  
				  }
				  
				 
				 
				  $(capacitydate).val(obj[i].inspectDate); 
				//  $(capacityremarks).val(obj[i].remarks); 
				 
				
				  
				 
			    	  }
			    	  
			    	  $(selectedcapacityid).val(capacityId); 
					  $(tab).val(tabId); 
					  
					  var availablecap=parseFloat(($("#editavailableCapacity").val()));
						//alert("availablecap"+availablecap);
						var grosscap=parseFloat($('#grossCapacity').val());
						
						//alert("grosscap"+grosscap);
						
							if(availablecap>0 && availablecap>0){
								
								percentageCap=(parseFloat(availablecap/grosscap)*100).toFixed(2);
							//	alert("percentageCap"+percentageCap);
								$('#editcapacitypercent').val(percentageCap);
								
							}
				 
				  }
				  if(obj==0||obj==null){
					
					  $('#action_alert').html('<p style="margin: 0px !important;">Failed to get Data</p>');
					  $("html,body").animate({scrollTop:0}, 500);
					  }
				   
			
				

			},
			error : function(){
				 alert(error);

			}
			});
	
}

	/*function gettankfeeddata(tankId){
		
		
		
		//alert(year+tankId+freq);
		$("#thead7").empty();
		$("#tbody7").empty();
		var userempId=$("#userempId7").val();
		var userdesignation=$("#designationId7").val();
		
		//alert("userempId"+userempId);
		
		
		
		$.ajax({	          
		      url: "../invtsimis/getMiTankFeedData?tankId="+tankId,
		      type: "GET",
		      contentType: "application/json; charset=utf-8",
		      success: function (msg) {
		    	  
		    	// console.log(msg);
		    	  if(msg!=null){
		    	  var obj = JSON.parse(msg);
		    	  
		    	  var j=1;
		    	  
		    	
		    	    $('#tankfeeddata table thead').append(  '<tr style="font-size: 18px">'+
		    	    		'<th style="color: blue">District</th><th style="color: red">'+obj[0].districtName+'</th>'+
		    	    		'<th style="color: blue">Mandal</th><th style="color: red">'+obj[0].mandalName+' </th>'+
		    	    		'<th style="color: blue">Village</th><th style="color: red">'+obj[0].villageName+'</th>'+
		    	    		'<th style="color: blue" colspan="2">Tank Name</th><th style="color: red"  colspan="2">'+obj[0].tankName+'</th></tr>'+
		    	    		'<tr style="font-size: 18px; color: gray; font-weight: bold;"><th>Sl.No</th>'+
		    	    		' <th>canFeed </th>'+
		    	    		'<th>chainLinkName</th>'+
		    	    	
		    	    		'  <th>Source Type</th>'+
		    	    		' <th>Source Component Type</th>'+
		    	    		' <th>Source Component</th>'+
		    	    		' <th>Inspect Date</th>'+
		    	    		' <th>OT Location(Km)</th>'+
		    	    		'<th>Source Details </th>'+
		    	    		'<th colspan="2" > Action </th></tr>'); 	  
		    	    
		    	    for(i in obj){
		    	    	
		    	    	   $('#tankfeeddata table tbody').append(  '<tr style="font-size: 16px">' +
		    	    			                                '<td style="text-align: center;">'+j+'</td>' +
		    	    			                                '<td><b>'+obj[i].canFeed+'</b></td>' +
		    	    			                                '<td><b>'+obj[i].chainLinkName+'</b></td>' +
		    	    			                             
		    	    			                                '<td><b>'+obj[i].sourceTypeName+'</b></td>' +
		    	    			                                '<td><b>'+obj[i].sourceCompTypeName+'</b></td>' +
		    	    			                                '<td><b>'+obj[i].sourceCompName+'</b></td>' +
		    	    			                                '<td><b>'+obj[i].inspectDate+'</b></td>' +
		    	    			                                '<td><b>'+obj[i].otLocationKm+'</b></td>' +	
		    	    			                                '<td><b>'+obj[i].sourceDetails+'</b><input  value="'+obj[i].mitankFeedDetailsId+'" name="mitankFeedDetailsId" id="dbfeedId'+j+'" class="dbfeedId" type="hidden" /> </td>' +	
		    	    			                                '<td colspan="2" ><button type="button" name="addfeedreview" id="addfeedreview'+j+'" class=" btn btn-1 btn-primary center-block feedremadd  "  onclick="addReviewinfo('+obj[i].mitankFeedDetailsId+','+obj[i].tankId+')"   >Add Remarks</button>'+
		    	    			                                '<button type="button" name="viewfeedinfo" id="viewfeedinfo'+j+'" class=" btn btn-1 btn-primary center-block feedremview "  onclick="viewfeedReview('+obj[i].mitankFeedDetailsId+','+obj[i].tankId+')"   >View Remarks</button>'+
		    	    			                                '<button type="button" name="editfeed" id="editfeed'+j+'" class="btn btn-1 btn-primary center-block feededit" onclick="editfeeddata('+obj[i].mitankFeedDetailsId+',5)"  >Edit</button>'+
		    	    			                                '<button type="button" name="deletefeed" id="deletefeed'+j+'" class="btn btn-1 btn-primary center-block feeddelete " onclick="deletefeeddata('+obj[i].mitankFeedDetailsId+',5,'+obj[i].tankId+')"  >Delete</button> </td>' +	  
		    	    			     
		    	    			                                '</tr>');
		    	    	   
		    	    	 
		    	    	   
		    	    	   j++;
		    	    }
		    	    
		    	    $(".feedremadd").hide();
	   		    	  $(".feededit").hide();
	   		    	  $(".feeddelete").hide();
	   		    	 
	   		    	  
	   		    	
		    	    
		    	    gettankfeedRemarks(tankId)
		    	    
		    	  }
		      },
		      error : function(){
		    	  alert(error);
		      }
		  });
		
		
	}*/

	/*function gettankfeedRemarks(tankId){
		
		
		
		//alert(year+tankId+freq);
		
		
		//$("#actionType").empty();
		var userempId=$("#userempId7").val();
		var userdesignation=$("#designationId7").val();
		
//alert("userempId"+userempId);

//alert("userdesignation"+userdesignation);
		
		
		
		$.ajax({	          
		      url: "../invtsimis/getMiTankFeedRemarks?tankId="+tankId+"&empId="+userempId,
		      type: "GET",
		      contentType: "application/json; charset=utf-8",
		      success: function (msg) {
		    	  
		    //	 console.log(msg);
		    	  
		    	  var obj = JSON.parse(msg);
		    	  
		    	  var j=1;
		    	  
		    	
		    		
		    	    for(i in obj){
		    	    
		    	    	var fdbempId=obj[i].empId;
		    	    	  var dbfid=obj[i].mitankFeedDetailsId;
		    	    	
                   $('.dbfeedId').each(function() {
		    	    			   
		    	    			   var feedval=$(this).val(); 
		    	    			   
		    	    			 // alert("feedval"+feedval+'=='+dbfid);
		    	    			   
		    	    			   if(feedval==dbfid){
		    	    				   
		    	    				
				    	    		   var feedid=$(this).prop('id'); 
				    	    		  var feed= feedid.substring(8, feedid.length);
				    	    		  
				    	    		//  alert(feed+"feed");
				    	    		  var fedit="#editfeed"+feed;
				    	    		  var fremarks="#addfeedreview"+feed;
				    	    		  var fdelete="#deletefeed"+feed;
				    	    		 // var fviewrem="#viewfeedinfo"+feed;
				    	    		
				    	    			if(((userempId==fdbempId) &&  (( userdesignation==4) || ( userdesignation==5)|| ( userdesignation==6) ||( userdesignation==7) || ( userdesignation==9) || ( userdesignation==10)))){  
				    	    		  $(fedit).show();
				    	    		   $(fremarks).show();   
				    	    		  // $(fviewrem).show();
				    	    			}
				    	    		   if((userempId==fdbempId) && ((userdesignation==5)|| ( userdesignation==6) ||( userdesignation==7) || ( userdesignation==9) || ( userdesignation==10))){
					    	    			
					    	    			$(fdelete).show();
					    	    			  $(fedit).show();
						    	    		   $(fremarks).show();   
					    	    		}	
				    	    		   
				    	    		  
				    	    		   
		    	    				   
		    	    			   }
		    	    			});
		    	    		   
		    	    	 
		    	    	 j++;
		    	    }
		    	    
		    	
		    	    
		
		      },
		      error : function(){
		    	  alert(error);
		      }
		  });
		
		
	}*/
	
	/*function editfeeddata(feedId,tabId){
		
		 $('#miinfo_dialogue').dialog('option', 'title', 'Edit Feed Details');
		  $('#miinfo_dialogue').dialog('open');
		  
		  $('#editinfoformid').trigger("reset"); 
		  
		//  alert("i ama inflow"+inflowid+tabId);
		  
		  $.ajax({	          
				url: "../invtsimis/get-edit-feeddata",
				method:"GET",
				dataType: 'json',

				async: false,
				data: {
					  
					mitankFeedDetailsId:feedId,
					  
					  tabId:tabId
				},


				success: function (obj) {

					  
					//console.log("feed"+obj);
					//alert("getfeed"+obj);
					  if(obj!=null){
							 var tab="#infotabId";
					 var selectedfeedId="#selectedfeedId";
								var tankId ="#selectinfoTankId";
								
								 var chainlinkId="#editchainLinkId";
								 var fcanfeedn="#editcanFeedn" ;
								  var fcanfeedy="#editcanFeedy";
								 var fsourceTypeId="#editsourceTypeId";
								 var fsourcecompTypeId="#editsourceCompTypeId";
								 var finspectdate="#editinspectDatefeeding";
								 var fsourceDetails="#editsourceDetails";
								 var fcompId="#editsourceCompId";
								 var flocationkm="#editotLocationKm";
								
								
								
							
							   
					
					//  var obj = JSON.parse(response);
				    
				    	  for(i in obj){
				  
				    		  $(chainlinkId).val(obj[i].chainLinkId); 
				    		  $(tankId).val(obj[i].tankId); 
				    		  
				    		  if(obj[i].canFeed==false){
				    		  $(fcanfeedn).prop('checked',true); 
				    		  }
				    		  if(obj[i].canFeed==true){
				    		  $(fcanfeedy).prop('checked',true); 
				    		  }
				    		  $(fsourceTypeId).val(obj[i].sourceTypeId); 
				    		  $(fsourcecompTypeId).val(obj[i].sourceCompTypeId); 
				    		  $(finspectdate).val(obj[i].inspectDate); 
				    		  $(fsourceDetails).val(obj[i].sourceDetails); 
				    		  $(fcompId).val(obj[i].sourceCompId); 
				    		  $(flocationkm).val(obj[i].otLocationKm); 
				
					
					  
					 
				    	  }
				    	  
				    	  $(selectedfeedId).val(feedId); 
						  $(tab).val(tabId); 
					 
					  }
					  if(obj==0||obj==null){
						
						  $('#action_alert').html('<p style="margin: 0px !important;">Failed to get Data</p>');
						  }
					   
				
					

				},
				error : function(){
					 alert(error);

				}
				});
		
	}*/

	function addReviewinfo(reviewId,tankId){
		
		 $('#reviewformid').trigger("reset"); 
		 $('#review_dialogue').dialog('option', 'title', 'Add Remarks');
		  $('#review_dialogue').dialog('open');
		 
		  $('#tankfeeddetailId').val(reviewId);
		  $('#tankfeedtankId').val(tankId);
		
		  $("#editmst1reviewinfoid").hide();
		
		
	}
	
	function addcapacityReviewinfo(capacityId,tankId){
		
		 $('#reviewformid').trigger("reset"); 
		 $('#review_dialogue').dialog('option', 'title', 'Add Remarks');
		  $('#review_dialogue').dialog('open');
		  $('#tankcapacityId').val(capacityId);
		  $('#tankcapacitytankId').val(tankId);
		
		  $("#editmst1reviewinfoid").hide();
		 
		  $('.reviewbutton').attr('id','capreview');
		
	
		
	}
	
	function addrepairReviewinfo(repairId,tankId){
		
		 $('#reviewformid').trigger("reset"); 
		 $('#review_dialogue').dialog('option', 'title', 'Add Remarks');
		  $('#review_dialogue').dialog('open');
		  $('#tankrepairId').val(repairId);
		  $('#tankrepairtankId').val(tankId);
		  $('.reviewbutton').attr('id','repreview');
	
		  $("#editmst1reviewinfoid").hide();
		 
		
	}
	
	/*function addinoutReviewinfo(inoutid,tankId){
		
		 $('#reviewformid').trigger("reset"); 
		 $('#review_dialogue').dialog('option', 'title', 'Add Remarks');
		  $('#').dialog('open');
		  $('#tankinoutId').val(inoutid);
		  $('#tankinouttankId').val(tankId);
	
		  $("#editmst1reviewinfoid").hide();
		
		
	}*/

	function feedreview(){
		
		
			  
			  var unitId=$('#miunitId7').val();
			  var circleId=$('#micircleId7').val();
			  var divisionId=$('#midivisionId7').val();
			  var subdivisionId=$('#misubdivisionId7').val();
			  var tankId=$('#tankfeedtankId').val();
			  var designationId=$('#designationId7').val();
			  var remarks=$('#tankFeedRemarks').val();
			  var projectId=$('#projectId7').val();
			  var levelId=$('#levelId7').val();
			  var reviewId=$('#tankfeeddetailId').val();
			  var empId=$('#empId7').val();
			  
			 // alert("i am here")
				
			if(tankId!=null && tankId>0 && reviewId!=null && reviewId>0){	
				
			//	alert("kal coming here"+unitId+circleId+levelId+reviewId);
				if ($('form[name=mainformname]').parsley().isValid()) {  
					
				///alert("kal2");
			if ($('form[name=reviewform]').parsley()
					.isValid()) {		 
		        $.ajax({	          
		url: "../invtsimis/submitTankFeedRemarks" ,
		method:"POST",
		dataType: 'json',

		async: false,
		data: {
			  
			mitankFeedDetailsId:reviewId,
			   unitId:unitId,
			  circleId :circleId,
			 
			  divisionId:divisionId,
			 subdivisionId:subdivisionId,
			   tankId : tankId,
			  levelId : levelId,
			  designationId : designationId,
			  remarks : remarks,
			  empId : empId,
			  projectId : projectId  
		},


		success: function (response) {

			  
			//  console.log(response);
			 if(response>0){
			  $('#reviewformid').trigger("reset"); 
			  
			  $('#review_dialogue').dialog('close');
		
			  $('#action_alert').html('<p style="margin: 0px !important;">Data Inserted Successfully</p>');
			  $("html,body").animate({scrollTop:0}, 500);
			   
			  gettankfeeddata(tankId) ; 
			 }
			 
			 if(response==0 || response==null ){
				 
				
				  $('#review_dialogue').dialog('open');
			
				  $('#action_alert').html('<p style="margin: 0px !important;">Failed to Insert</p>');
				  $("html,body").animate({scrollTop:0}, 500);
			 
			 }
			

		},
		error : function(){
			 alert(error);
		
		}
		}); 	
			 }
	        
	        
				}else {
					
					$('form[name=mainformname]').parsley().validate();
					//alert("kal4");
				}
			
			}else {
			 
				return false
			}
			
		
		
	}
	
	
	function capacityreview(){
		
		var getid=$('.reviewbutton').prop('id');
		
		if(getid=='capreview'){
		  
		  var unitId=$('#miunitId6').val();
		  var circleId=$('#micircleId6').val();
		  var divisionId=$('#midivisionId6').val();
		  var subdivisionId=$('#misubdivisionId6').val();
		  var tankId=$('#tankcapacitytankId').val();
		  var designationId=$('#designationId6').val();
		  var remarks=$('#tankFeedRemarks').val();
		  var projectId=$('#projectId6').val();
		  var levelId=$('#levelId6').val();
		  var reviewId=$('#tankcapacityId').val();
		  var empId=$('#userempId6').val();
		  var postId=$('#postId6').val();
		  var nextPostId=$('#nextPostId6').val();
		  var nextEmpId=$('#nextEmpId6').val();
		  
		 // alert("i am here")
			
		if(tankId!=null && tankId>0 && reviewId!=null && reviewId>0){	
			
			//alert("kal coming here"+unitId+circleId+levelId+reviewId);
			if ($('form[name=mainformname]').parsley().isValid()) {  
				
			///alert("kal2");
		if ($('form[name=reviewform]').parsley()
				.isValid()) {		 
	        $.ajax({	          
	url: "../invtsimis/submitTankCapacityRemarks" ,
	method:"POST",
	dataType: 'json',

	async: false,
	data: {
		  
		mitankCapacityId:reviewId,
		   unitId:unitId,
		  circleId :circleId,
		 
		  divisionId:divisionId,
		 subdivisionId:subdivisionId,
		   tankId : tankId,
		  levelId : levelId,
		  designationId : designationId,
		  remarks : remarks,
		  empId : empId,
		  postId:postId,
		  nextPostId:nextPostId,
		  nextEmpId:nextEmpId
		 
	},


	success: function (response) {

		  
		//  console.log(response);
		 if(response>0){ 
		  $('#reviewformid').trigger("reset"); 
		  
		  $('#review_dialogue').dialog('close');
	
		  $('#action_alert').html('<p style="margin: 0px !important;">Data Inserted Successfully</p>');
		  $("html,body").animate({scrollTop:0}, 500);
		   
		  getcapacitydata(tankId) ; 
		 }
		 if(response==0 || response==null){
			 
			 $('#review_dialogue').dialog('open');
				
			  $('#action_alert').html('<p style="margin: 0px !important;">Failed to  Insert</p>');
			  $("html,body").animate({scrollTop:0}, 500);
			 
		 }
		 
		 

	},
	error : function(){
		 alert(error);
	
	}
	}); 	
		 }
      
      
			}else {
				
				$('form[name=mainformname]').parsley().validate();
				//alert("kal4");
			}
		
		}else {
		 
			return false
		}
		
		}
	
}
	
	function repairreview(){
		
var getid=$('.reviewbutton').prop('id');
		
		if(getid=='repreview'){
		  
		  var unitId=$('#miunitId5').val();
		  var circleId=$('#micircleId5').val();
		  var divisionId=$('#midivisionId5').val();
		  var subdivisionId=$('#misubdivisionId5').val();
		  var tankId=$('#tankrepairtankId').val();
		  var designationId=$('#designationId5').val();
		  var remarks=$('#tankFeedRemarks').val();
		  var projectId=$('#projectId5').val();
		  var levelId=$('#levelId5').val();
		  var reviewId=$('#tankrepairId').val();
		  var empId=$('#userempId5').val();
		  var postId=$('#postId5').val();
		  var nextPostId=$('#nextPostId5').val();
		  
	//	 alert("i am here")
		 
		 //	alert("kal coming here"+unitId+circleId+levelId+reviewId);
			
		if(tankId!=null && tankId>0 && reviewId!=null && reviewId>0){	
			
			//alert("kal coming here"+unitId+circleId+levelId+reviewId);
			if ($('form[name=mainformname]').parsley().isValid()) {  
				
			///alert("kal2");
		if ($('form[name=reviewform]').parsley()
				.isValid()) {		 
	        $.ajax({	          
	url: "../invtsimis/submitTankRepairRemarks" ,
	method:"POST",
	dataType: 'json',

	async: false,
	data: {
		  
		mitankRepairsId:reviewId,
		   unitId:unitId,
		  circleId :circleId,
		 
		  divisionId:divisionId,
		 subdivisionId:subdivisionId,
		   tankId : tankId,
		  levelId : levelId,
		  designationId : designationId,
		  remarks : remarks,
		  empId : empId,
		  postId : postId,
		  nextPostId:nextPostId
	},


	success: function (response) {

		  
	//	  console.log(response);
		
		  if(response>0){
		  $('#reviewformid').trigger("reset"); 
		  
		  $('#review_dialogue').dialog('close');
	
		  $('#action_alert').html('<p style="margin: 0px !important;">Data Inserted Successfully</p>');
		  $("html,body").animate({scrollTop:0}, 500);
		  
		  getrepairdata(tankId);
		  
		  }
		  if(response==0 || response==null){
			  
			  $('#review_dialogue').dialog('open');
				
			  $('#action_alert').html('<p style="margin: 0px !important;">Failed to Insert</p>');
			  $("html,body").animate({scrollTop:0}, 500);
			  
		  }
		   
		 // gettankfeeddata(tankId) ; 
		

	},
	error : function(){
		 alert(error);
	
	}
	}); 	
		 }
    
    
			}else {
				
				$('form[name=mainformname]').parsley().validate();
				//alert("kal4");
			}
		
		}else {
		 
			return false
		}
		
		}
	
}

	
	
	

	/*function inoutreview(){
			
	
	  
	  var unitId=$('#miunitId4').val();
	  var circleId=$('#micircleId4').val();
	  var divisionId=$('#midivisionId54').val();
	  var subdivisionId=$('#misubdivisionId4').val();
	  var tankId=$('#tankinouttankId').val();
	  var designationId=$('#designationId4').val();
	  var remarks=$('#tankFeedRemarks').val();
	  var projectId=$('#projectId4').val();
	  var levelId=$('#levelId4').val();
	  var reviewId=$('#tankinoutId').val();
	  var empId=$('#empId4').val();
	  
	//  alert("i am here")
		
	if(tankId!=null && tankId>0 && reviewId!=null && reviewId>0){	
		
		//alert("kal coming here"+unitId+circleId+levelId+reviewId);
		if ($('form[name=mainformname]').parsley().isValid()) {  
			
		///alert("kal2");
	if ($('form[name=reviewform]').parsley()
			.isValid()) {		 
      $.ajax({	          
url: "../invtsimis/submitTankInOutRemarks" ,
method:"POST",
dataType: 'json',

async: false,
data: {
	  
	mitankInoutFlowId:reviewId,
	   unitId:unitId,
	  circleId :circleId,
	 
	  divisionId:divisionId,
	 subdivisionId:subdivisionId,
	   tankId : tankId,
	  levelId : levelId,
	  designationId : designationId,
	  remarks : remarks,
	  empId : empId,
	  projectId : projectId
	 
	  
},


success: function (response) {

	  
	//  console.log(response);
	  if(response>0){
	  $('#reviewformid').trigger("reset"); 
	  
	  $('#review_dialogue').dialog('close');

	  $('#action_alert').html('<p style="margin: 0px !important;">Data Inserted Successfully</p>');
	  $("html,body").animate({scrollTop:0}, 500);
	  }
	  if(response==0 || response==null){
		  
		  $('#review_dialogue').dialog('open');

		  $('#action_alert').html('<p style="margin: 0px !important;">Failed to Insert</p>');
		  $("html,body").animate({scrollTop:0}, 500);
		  
	  }
	  
	  
	   
	//  gettankfeeddata(tankId) ; 
	

},
error : function(){
	 alert(error);

}
}); 	
	 }


		}else {
			
			$('form[name=mainformname]').parsley().validate();
			//alert("kal4");
		}
	
	}else {
	 
		return false
	}
	}*/
	

	function insertCheckreviewsemb(){
		
		//alert("coming here");
		
		var getid=$('.reviewbutton').prop('id');
		  
		//alert("getid"+getid);
		
		if(getid=='embreview'){
			
			//alert("i am here kal");
			
		  var unitId=$('#miunitId1').val();
		  var circleId=$('#micircleId1').val();
		  var divisionId=$('#midivisionId1').val();
		  var subdivisionId=$('#misubdivisionId1').val();
		  var tankId=$('#mitankId1').val();
		  var designationId=$('#designationId1').val();
		  var remarks=$('#tankFeedRemarks').val();
		  var projectId=$('#projectId1').val();
		  var levelId=$('#levelId1').val();
		  var reviewId=$('#miInpsectMst1Id1').val();
		  var empId=$('#userempId1').val();
		  var tab1=$('#tabId1').val();
		  var postId=$('#postId1').val();
		  var nextPostId=$('#nextPostId1').val();
		  var tankWeirSluiceId=0;
		  var nextEmpId=$('#nextEmpId1').val();
		  
		 // alert("nextEmpId"+nextEmpId);
		
		//  alert("tab1"+tab1);
		//  alert("nextPostId"+nextPostId);
		
			
		if(tankId!=null && tankId>0 && reviewId!=null && reviewId>0 && tab1==1){	
			
		//	alert("kal coming here"+unitId+circleId+levelId+reviewId);
			if ($('form[name=mainformname]').parsley().isValid()) {  
				
		//alert("kal2 insert remarksmst1");
		if ($('form[name=reviewform]').parsley()
				.isValid()) {		 
	    $.ajax({	          
	url: "../invtsimis/insertMst1Remarks" ,
	method:"POST",
	dataType: 'json',

	async: false,
	data: {
		  
		miInpsectMst1Id:reviewId,
		   unitId:unitId,
		  circleId :circleId,
		 
		  divisionId:divisionId,
		 subdivisionId:subdivisionId,
		   tankId : tankId,
		  levelId : levelId,
		  designationId : designationId,
		  embRemarks : remarks,
		  empId : empId,
		  projectId : projectId,
		  tabId:tab1,
		  tankWeirSluiceId:tankWeirSluiceId,
		  postId:postId,
		  nextPostId:nextPostId,
		  nextEmpId:nextEmpId
	},


	success: function (response) {

		  
		//  console.log(response);
		
		if(response>0){
		  
		  $('#reviewformid').trigger("reset"); 
		  
		  $('#review_dialogue').dialog('close');

		  $('#action_alert').html('<p style="margin: 0px !important;">Data Inserted Successfully</p>');
		  $("html,body").animate({scrollTop:0}, 500);
		  
		}if(response==0 || response==null){
			
			  $('#review_dialogue').dialog('open');

			  $('#action_alert').html('<p style="margin: 0px !important;">Failed to Insert</p>');
			  $("html,body").animate({scrollTop:0}, 500);
			
			
		}
		   
		//  gettankfeeddata(tankId) ; 
		

	},
	error : function(){
		 alert(error);

	}
	}); 	
		 }


			}else {
				
				$('form[name=mainformname]').parsley().validate();
				//alert("kal4");
			}
		
		}else {
		 
			return false
		}

		}

	}

	function insertCheckreviewslu(){
		
		var getid=$('.reviewbutton').prop('id');
		
		//alert("getid"+getid);
		 
		if(getid=='slureview'){
			
			//alert(" i am in slure kal")
		
			  var unitId=$('#miunitId2').val();
			  var circleId=$('#micircleId2').val();
			  var divisionId=$('#midivisionId2').val();
			  var subdivisionId=$('#misubdivisionId2').val();
			  var tankId=$('#mitankId2').val();
			  var designationId=$('#designationId2').val();
			  var remarks=$('#tankFeedRemarks').val();
			  var projectId=$('#projectId2').val();
			  var levelId=$('#levelId2').val();
			  var reviewId=$('#miInpsectMst1Id2').val();
			  var empId=$('#userempId2').val();
			  var tab2=$('#tabId2').val();
			  var tankWeirSluiceId=$('#sluiceId').val();
			  var postId=$('#postId2').val();
			  var nextPostId=$('#nextPostId2').val();
			  var nextEmpId=$('#nextEmpId2').val();
			  
			 // alert("nextEmpId2"+nextEmpId);
				//alert("tab2"+tab2);
			if(tankId!=null && tankId>0 && reviewId!=null && reviewId>0 && tab2==2){	
				
			//	alert("kal coming here"+unitId+circleId+levelId+reviewId);
				if ($('form[name=mainformname]').parsley().isValid()) {  
			//alert("kal2 insert remarksmst1");
			if ($('form[name=reviewform]').parsley()
					.isValid()) {		 
		      $.ajax({	          
		url: "../invtsimis/insertMst1Remarks" ,
		method:"POST",
		dataType: 'json',

		async: false,
		data: {
			  
			miInpsectMst1Id:reviewId,
			   unitId:unitId,
			  circleId :circleId,
			 
			  divisionId:divisionId,
			 subdivisionId:subdivisionId,
			   tankId : tankId,
			  levelId : levelId,
			  designationId : designationId,
			  sluRemarks : remarks,
			  empId : empId,
			  projectId : projectId,
			  tabId:tab2,
			  tankWeirSluiceId:tankWeirSluiceId,
			  postId:postId,
		      nextPostId:nextPostId,
		      nextEmpId:nextEmpId
			  
		},


		success: function (response) {

			  
			//  console.log(response);
			
			if(response>0){
			  
			  $('#reviewformid').trigger("reset"); 
			  
			  $('#review_dialogue').dialog('close');

			  $('#action_alert').html('<p style="margin: 0px !important;">Data Inserted Successfully</p>');
			  $("html,body").animate({scrollTop:0}, 500);
			  
			}
			
			if(response==0 || response==null){
				
				 $('#review_dialogue').dialog('open');

				  $('#action_alert').html('<p style="margin: 0px !important;">Failed to Insert</p>');
				  $("html,body").animate({scrollTop:0}, 500);
				
				
			}
			   
			//  gettankfeeddata(tankId) ; 
			

		},
		error : function(){
			 alert(error);

		}
		}); 	
			 }


				}else {
					
					$('form[name=mainformname]').parsley().validate();
					//alert("kal4");
				}
			
			}else {
			 
				return false
			}
		
		}

	}
	function insertCheckreviewsweir(){
	
		var getid=$('.reviewbutton').prop('id');
		//alert("i am weir review")
		
		if(getid=='weirreview'){
			
			//alert("i am weir review");
			
			  var unitId=$('#miunitId3').val();
			  var circleId=$('#micircleId3').val();
			  var divisionId=$('#midivisionId3').val();
			  var subdivisionId=$('#misubdivisionId3').val();
			  var tankId=$('#mitankId3').val();
			  var designationId=$('#designationId3').val();
			  var remarks=$('#tankFeedRemarks').val();
			  var projectId=$('#projectId13').val();
			  var levelId=$('#levelId3').val();
			  var reviewId=$('#miInpsectMst1Id3').val();
			  var empId=$('#userempId3').val();
			  var tab3=$('#tabId3').val();
			  var tankWeirSluiceId=$('#weirId').val();
			  var postId=$('#postId3').val();
			  var nextPostId=$('#nextPostId3').val();
                var nextEmpId=$('#nextEmpId3').val();
			  
			 // alert("nextEmpId3"+nextEmpId);
			  
	//		alert("tab3"+tab3);
				
			if(tankId!=null && tankId>0 && reviewId!=null && reviewId>0 &&  tab3==3){	
				
			//	alert("kal coming here"+unitId+circleId+levelId+reviewId);
				if ($('form[name=mainformname]').parsley().isValid()) {  
					
			//alert("kal2 insert remarksmst1");
			if ($('form[name=reviewform]').parsley()
					.isValid()) {		 
		      $.ajax({	          
		url: "../invtsimis/insertMst1Remarks" ,
		method:"POST",
		dataType: 'json',

		async: false,
		data: {
			  
			miInpsectMst1Id:reviewId,
			   unitId:unitId,
			  circleId :circleId,
			 
			  divisionId:divisionId,
			 subdivisionId:subdivisionId,
			   tankId : tankId,
			  levelId : levelId,
			  designationId : designationId,
			  weirRemarks : remarks,
			  empId : empId,
			  projectId : projectId,
			  tabId:tab3,			  
			  tankWeirSluiceId:tankWeirSluiceId,
			  postId:postId,
		      nextPostId:nextPostId,
		      nextEmpId:nextEmpId
		},


		success: function (response) {

			  
			//  console.log(response);
			
			if(response>0){
			  
			  $('#reviewformid').trigger("reset"); 
			  
			  $('#review_dialogue').dialog('close');

			  $('#action_alert').html('<p style="margin: 0px !important;">Data Inserted Successfully</p>');
			  $("html,body").animate({scrollTop:0}, 500);
			  
			}
			
			if(response==0 || response==null){
				
				 $('#review_dialogue').dialog('open');

				  $('#action_alert').html('<p style="margin: 0px !important;">Failed to Insert</p>');
				  $("html,body").animate({scrollTop:0}, 500);
				
				
			}
			   
			//  gettankfeeddata(tankId) ; 
			

		},
		error : function(){
			 alert(error);

		}
		}); 	
			 }


				}else {
					
					$('form[name=mainformname]').parsley().validate();
					//alert("kal4");
				}
			
			}else {
			 
				return false
			}
		
		}

	}
	
///delete functions
	//deletebundchecks09092020
	function deleteembMst2(mst2Id,tabId,year,count){
		
		 $.ajax({	          
				url: "../invtsimis/delete-Mtank2" ,
				method:"POST",
				dataType: 'json',

				async: false,
				data: {
					  
					miInpsectMst2Id:mst2Id,
					tabId:tabId
					  
				},


				success: function (response) {

					  
					//  console.log(response);
					  
					if(response>0){

					  $('#action_alert').html('<p style="margin: 0px !important;">Data Deleted Successfully</p>');
					  $("html,body").animate({scrollTop:0}, 500);
					  if(tabId==1){
						var checkid="#micheckboxId"+count;
						var inspectdateid="#inspectDate"+count;
			    		//alert("checkid"+checkid);
			    		var actionreqidy="#actionreqy"+count;
			    		var actionreqidn="#actionreqn"+count;
			    		var remarks="#remarks"+count;
			    		var editbuttonactive="#editemb"+count;
			    		var deletebuttonactive="#deleteemb"+count;
			    		var actionrequirereq="#actionrequireqId"+count+"  option";
			    		
			    		var mst2Id="#miInpsectMst2Id"+count;
			    		var actionrequirereq1="#myactionreqid"+count;
					  }
					  if(tabId==2){
	                      var checkid="#micheckboxIdslu"+count;
				    		
				    		var inspectdateid="#inspectDateslu"+count;
				    		//alert("checkid"+checkid);
				    		var actionreqidy="#actionreqsluy"+count;
				    		var actionreqidn="#actionreqslun"+count;
				    		var remarks="#remarksslu"+count;
				    		var editbuttonactive="#editslu"+count;
				    		var deletebuttonactive="#deleteslu"+count;
				    		var mst2Id="#miInpsectMst2Idslu"+count;
				    		
				    		var actionrequirereq="#actionrequireqIdslu"+count+"  option";
				    		
				    		var actionrequirereq1="#myactionreqidslu"+count;
						  }
					  
					  if(tabId==3){
						  var checkid="#micheckboxIdweir"+count;
				    		var inspectdateid="#inspectDateweir"+count;
				    		//alert("checkid"+checkid);
				    		var actionreqidy="#actionreqweiry"+count;
				    		var actionreqidn="#actionreqweirn"+count;
				    		var remarks="#remarksweir"+count;
				    		var editbuttonactive="#editweir"+count;
				    		var deletebuttonactive="#deleteweir"+count;
				    		var mst2Id="#miInpsectMst2Idweir"+count;
				    		var actionrequirereq="#actionrequireqIdweir"+count+"  option";
				    		
				    		var actionrequirereq1="#myactionreqidweir"+count;
						  }
						  
						  
					  
					  
					  
					  
					  
						 $(checkid).addClass("embdmt2");
						 $('.embdmt2').prop('checked', false);
				          $('.embdmt2').attr('disabled',false); 
						// $(inspectdateid).val(0);
				          
				          $(inspectdateid).val('');
						 $(inspectdateid).attr('disabled',false); 
						 $(actionreqidy).val(true);
						 $(actionreqidn).val(false);
						 $(actionreqidy).attr('disabled', false);	
			    			$(actionreqidn).attr('disabled', false);	
			    			$(actionreqidn).prop('checked', true);
			    			 $(actionreqidy).attr('checked', false);	
						 $(remarks).val('');
						 $(remarks).attr('readonly',false); 
						// $(editbuttonactive).removeClass("eact1");
						// $(deletebuttonactive).removeClass("dact2");
						// $(editbuttonactive).hide();
						// $(deletebuttonactive).hide();
						 
						 if($(editbuttonactive).hasClass('eact1')){	                    
			    				//var editid=$(this).prop('id');			    				
			    				//alert("sluid"+sluid);
			    				
			    			//	var neweditid="#"+editid;		    				
	                    
			    				  $(editbuttonactive).removeClass('eact1');	    				 
		    					   
		    					   $(editbuttonactive).removeAttr('style') ;			    					   
			    					 //  alert("newsluid"+newsluid);
			    					   $(editbuttonactive).css("display", "none");
			    					   
			    	}
						 
						 if($(deletebuttonactive).hasClass('dact2')){                    
			    			//	var deleditid=$(this).prop('id');			    				
			    				//alert("sluid"+sluid);
			    				
			    			//	var newdeleditid="#"+deleditid;		    				
	                    
			    				  $(deletebuttonactive).removeClass('dact2');	    				 
		    					   
		    					   $(deletebuttonactive).removeAttr('style') ;			    					   
			    					 //  alert("newsluid"+newsluid);
			    					   $(deletebuttonactive).css("display", "none");
			    					   
			    	}
						 
						 $(mst2Id).val(0);
						 
						 $(actionrequirereq).each(function () {
				    	    
				    	            $(this).removeAttr("selected");
				    	            $(this).attr('disabled', false);	
				    	            return;
				    	       
							}); 
						 
						 $(actionrequirereq1).hide();
					   
					  getmst2inspectdata(year);
					}
					
					if(response==0 || response==null){
						
						 $('#action_alert').html('<p style="margin: 0px !important;">Failed to Delete Data</p>');
						   	
					}
					

				},
				error : function(){
					 alert(error);

				}
				}); 

	
		
	}
	
	
	
	
	/*function deleteinflowoutflow(inflowid,tabId,tankId){
		
		 $.ajax({	          
				url: "../invtsimis/delete-Mtank-Inoutflow" ,
				method:"POST",
				dataType: 'json',

				async: false,
				data: {
					  
					mitankInoutFlowId:inflowid,
					tabId:tabId
					  
				},


				success: function (response) {

					  
					//  console.log(response);
					  
					if(response>0){

					  $('#action_alert').html('<p style="margin: 0px !important;">Data Deleted Successfully</p>');
					  $("html,body").animate({scrollTop:0}, 500);
					  
					
					  
				
					 
					  getinoutdata(tankId)
					}
					
					if(response==0 || response==null){
						
						 
						
						 $('#action_alert').html('<p style="margin: 0px !important;">Failed to Delete Data</p>');
						 $("html,body").animate({scrollTop:0}, 500);
						   	
					}
					

				},
				error : function(){
					 alert(error);

				}
				}); 

	
		
	}*/
	
	function deleterepairdata(repairid,tabId,tankId){
		
		 $.ajax({	          
				url: "../invtsimis/delete-Mtank-Repairs" ,
				method:"POST",
				dataType: 'json',

				async: false,
				data: {
					  
					mitankRepairsId:repairid,
					tabId:tabId
					  
				},


				success: function (response) {

					  
					//  console.log(response);
					  
					if(response>0){

					  $('#action_alert').html('<p style="margin: 0px !important;">Data Deleted Successfully</p>');
					  $("html,body").animate({scrollTop:0}, 500);
					  
					
					  
				
					 
					  getrepairdata(tankId)
					}
					
					if(response==0 || response==null){
						
						
						
						 $('#action_alert').html('<p style="margin: 0px !important;">Failed to Delete Data</p>');
						 $("html,body").animate({scrollTop:0}, 500);
						   	
					}
					

				},
				error : function(){
					 alert(error);

				}
				}); 

	
		
	}
	
	
	function deletecapacitydata(capacityId,tabId,tankId){
		
		 $.ajax({	          
				url: "../invtsimis/delete-Mtank-Capacity" ,
				method:"POST",
				dataType: 'json',

				async: false,
				data: {
					  
					mitankCapacityId:capacityId,
					tabId:tabId
					  
				},


				success: function (response) {

					  
					//  console.log(response);
					  
					if(response>0){

					  $('#action_alert').html('<p style="margin: 0px !important;">Data Deleted Successfully</p>');
					  $("html,body").animate({scrollTop:0}, 500);
					  
					
					  
				
					 
					  getcapacitydata(tankId)
					}
					
					if(response==0 || response==null){
						
						
						
						 $('#action_alert').html('<p style="margin: 0px !important;">Failed to Delete Data</p>');
						   	
						 $("html,body").animate({scrollTop:0}, 500);
					}
					

				},
				error : function(){
					 alert(error);

				}
				}); 

	
		
	}
	
	function deletefeeddata(feedId,tabId,tankId){
		
		 $.ajax({	          
				url: "../invtsimis/delete-Mtank-Feed" ,
				method:"POST",
				dataType: 'json',

				async: false,
				data: {
					  
					mitankFeedDetailsId:feedId,
					tabId:tabId
					  
				},


				success: function (response) {

					  
					//  console.log(response);
					  
					if(response>0){

					  $('#action_alert').html('<p style="margin: 0px !important;">Data Deleted Successfully</p>');
					  $("html,body").animate({scrollTop:0}, 500);
					  
					
					  
				
					 
					  gettankfeeddata(tankId);
					}
					
					if(response==0 || response==null){
						
						
						
						 $('#action_alert').html('<p style="margin: 0px !important;">Failed to Delete Data</p>');
						 $("html,body").animate({scrollTop:0}, 500);
						   	
					}
					

				},
				error : function(){
					 alert(error);

				}
				}); 

	
		
	}
	
	function viewmst1Remarks(mst1Id,tabId){
		
		$("#viewhead1").empty();
		$("#viewbody1").empty();
		
		var tabinfo=1;
		
		var postId=$("#postId1").val();
		//alert("kal");
		
		 $.ajax({	          
				url: "../invtsimis/get-mst1-remarks" ,
				method:"GET",
				dataType: 'json',

				async: false,
				data: {
					miInpsectMst1Id:mst1Id,
					tabId:tabId
				},

				success: function (obj) {
					// console.log(obj);
					    //	  var obj = JSON.parse(msg);
					
					    	  var j=1;
					    	  
					    	//alert("kalhere");
					    	    $('#viewmst1data table thead').append( '<tr style="font-size: 18px; color: gray; font-weight: bold;"><th>Sl.No</th>'+
					    	    		
					    	    		'<th>Remarks</th>'+
					    	    		'  <th>Remarks for</th>'+
					    	    	
					    	    		/*'  <th>Latest</th>'+*/
					    	    		'  <th>Date</th>'+
					    	    		
					    	    		' <th>Submitted By </th>'+
					    	    		
					    	    		'  <th>Submitted To</th>'+
					    	    		
					    	    		
					    	    		
					    	    		'<th colspan="2">Action</th></tr>'); 	  
					    	    
					    	    for(i in obj){
					    	    	
					    	    	var k=obj[i].tabId;
					    	    	var s= obj[i].postId ;
					    	    	
					    	    	   $('#viewmst1data table tbody').append(  '<tr style="font-size: 16px">' +
					    	    			                                '<td style="text-align: center;">'+j+'</td>' +
					    	    			                               
					    	    			                                '<td><b>'+obj[i].remarks+'</b></td>' +
					    	    			                                
						    	    			                             (k==1? '<td><b>Bund Remarks</b></td>': '')+
						    	    			                             (k==2? '<td><b>Sluice Remarks</b></td>': '')+
						    	    			                             (k==3? '<td><b>Weir Remarks</b></td>': '')+
						    	    			                               
					    	    			                               /* '<td><b>'+obj[i].latestRemarks+'</b></td>' +*/
					    	    			                                
					    	    			                                '<td><b>'+obj[i].remarksDate+'</b></td>' +
					    	    			                                
					    	    			                                '<td><b>'+obj[i].remarksSubmittedBy+'</b></td>' +
					    	    			                                
					    	    			                                '<td><b>'+obj[i].submittedToEmpName+'</b></td>' +
					    	    			                            
					    	    			                                	    	    			                               
					    	    			                             (s==postId?   '<td colspan="2" ><button type="button" name="editmst1remarks" id="editmst1remarks'+j+'" class="btn btn-1 btn-primary center-block mst1reedit" onclick="editmst1remarksfn('+obj[i].miInpsectMst1IdReviewId+','+obj[i].miInpsectMst1Id+','+obj[i].tabId+')"  >Edit</button> &emsp; &emsp; '+
					    	    			                                '<button type="button" name="deletemst1remarksname" id="deletemst1remarks'+j+'" class="btn btn-1 btn-primary center-block mst1redelete " onclick="deletemst1remarks('+obj[i].miInpsectMst1IdReviewId+','+obj[i].miInpsectMst1Id+','+obj[i].tabId+')"  >Delete</button> </td>':'')+
					    	    			                                '</tr>');
					    	    	   
					    	    	   
					    	    	  
					    	    	   
					    	    	   //$('.mst1reedit').hide();
					    	    	  // $('.mst1redelete').hide();
					    	    	   /*
					    	    	   if(obj[i].submittedBy==userempId){
					    	    		   alert("submittedBy"+obj[i].submittedBy);
					    	    		   alert("userempId"+userempId);
					    	    		   
					    	    		   $('.mst1reedit').hide();
					    	    		   $(".mst1redelete").addClass("dreview");
						    	    	   $('.dreview').show(); 
					    	    	   }*//*else {
					    	    		   
					    	    		   if($('.mst1redelete').hasClass('dreview')){
					    	    			   $('.mst1redelete').removeClass('dreview')
					    	    			}

					    	    	   }*/
					    	    	   
					    	    	   
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
	
	function getsluicelist(tankId){
		
		//alert("kal"+b);

		
		var newtankId=tankId
			//document.getElementById("districtId").value;
		
		//alert(districtId);
		
		
			
			
				$('#sluiceId').multiselect('rebuild');
				

	

		$.ajax({	          
		      url: "../invtsimis/sluice-list?tankId="+tankId,
		      type: "GET",
		      success: function (response) {
		    	  
		    	
		    	
	    			  var $select = $('#sluiceId');
					var selectedtankWeirSluiceId= $('#slsluiceId').val();
					  
				
		    	
				  $select.find('option').remove();
				  
			
				//  alert("selected"+selectedMandal);
				 
					  $('#sluiceId').append( '<option value=" "> --select--</option>' );
						  
				 
				 
				
						var obj = JSON.parse(response);
						$.each(obj, function(key, value) {
							
							if(selectedtankWeirSluiceId==value.tankWeirSluiceId){	
								//alert("coming1");
								$('#sluiceId').append( '<option value="'+value.tankWeirSluiceId+'" selected="selected" > '+value.tankWeirSluiceName+'</option>' );
							}
							if(selectedtankWeirSluiceId==null||selectedtankWeirSluiceId!=value.tankWeirSluiceId){
								//alert("coming2");
								$('#sluiceId').append( '<option value="'+value.tankWeirSluiceId+'"  > '+value.tankWeirSluiceName+'</option>' );
							
							}
							
			  					
		  	  				$('#sluiceId').multiselect('rebuild');
							  
							  
							 
							  
							 
						});

		      },
		      error : function(){
		    	  alert(error);
		      }
		  });	
		} 
	
function getweirlist(tankId){
		
		//alert("kal"+b);

		
		var newtankId=tankId
			//document.getElementById("districtId").value;
		
		//alert(districtId);
		
		
			
			
				$('#weirId').multiselect('rebuild');
				

	

		$.ajax({	          
		      url: "../invtsimis/weir-list?tankId="+tankId,
		      type: "GET",
		      success: function (response) {
		    	  
		    	
		    	
	    			  var $select = $('#weirId');
					var selectedtankWeirSluiceId= $('#wiweirId').val();
					  
				
		    	
				  $select.find('option').remove();
				  
			
				//  alert("selected"+selectedMandal);
				 
					  $('#weirId').append( '<option value=" "> --select--</option>' );
						  
				 
				 
				
						var obj = JSON.parse(response);
						$.each(obj, function(key, value) {
							
							if(selectedtankWeirSluiceId==value.tankWeirSluiceId){	
								//alert("coming1");
								$('#weirId').append( '<option value="'+value.tankWeirSluiceId+'" selected="selected" > '+value.tankWeirSluiceName+'</option>' );
							}
							if(selectedtankWeirSluiceId==null||selectedtankWeirSluiceId!=value.tankWeirSluiceId){
								//alert("coming2");
								$('#weirId').append( '<option value="'+value.tankWeirSluiceId+'"  > '+value.tankWeirSluiceName+'</option>' );
							
							}
							
			  					
		  	  				$('#weirId').multiselect('rebuild');
							  
							  
							 
							  
							 
						});

		      },
		      error : function(){
		    	  alert(error);
		      }
		  });	
		} 


function getrepairdesclist(tankId){
	
	//alert("kal"+b);

	
	var newtankId=tankId
		//document.getElementById("districtId").value;
	
	//alert(districtId);
	
	
		
		
			$('#repairdescId').multiselect('rebuild');
	
	$('#editrepairdescId').multiselect('rebuild');
			



	$.ajax({	          
	      url: "../invtsimis/repairdesc-list?tankId="+tankId,
	      type: "GET",
	      success: function (response) {
	    	  
	    	
	    	
    			  var $select = $('#repairdescId');
    			  var $selectedit = $('#editrepairdescId');
				var selectedrepairdescId= $('#selectedrepairdescId').val();
				
				var hiddeneditdescId= $('#selectededitrepdescId').val();
				  
			
	    	
			  $select.find('option').remove();
			  $selectedit.find('option').remove();
			  
		
			//  alert("selected"+selectedMandal);
			 
				  $('#repairdescId').append( '<option value=" "> --select--</option>' );
				  $('#editrepairdescId').append( '<option value=" "> --select--</option>' );
					  
			 
			 
			
					var obj = JSON.parse(response);
					$.each(obj, function(key, value) {
						
						if(selectedrepairdescId==value.repairdescId){	
							//alert("coming1");
							$('#repairdescId').append( '<option value="'+value.repairdescId+'" selected="selected" > '+value.repairdescdata+'</option>' );
						}
						if(selectedrepairdescId==null||selectedrepairdescId!=value.repairdescId){
							//alert("coming2");
							$('#repairdescId').append( '<option value="'+value.repairdescId+'"  > '+value.repairdescdata+'</option>' );
						
						}
						
		  					
	  	  				$('#repairdescId').multiselect('rebuild');
						  
	  	  			if(hiddeneditdescId==value.repairdescId){	
						//alert("coming1");
						$('#editrepairdescId').append( '<option value="'+value.repairdescId+'" selected="selected" > '+value.repairdescdata+'</option>' );
					}
					if(hiddeneditdescId==null||hiddeneditdescId!=value.repairdescId){
						//alert("coming2");
						$('#editrepairdescId').append( '<option value="'+value.repairdescId+'"  > '+value.repairdescdata+'</option>' );
					
					}
							$('#editrepairdescId').multiselect('rebuild');
						  
						 
					});

	      },
	      error : function(){
	    	  alert(error);
	      }
	  });	
	} 


function gettankgeotaglist(tankId){
	
	//alert("kal"+b);

	
	var newtankId=tankId
		//document.getElementById("districtId").value;
	
	//alert(districtId);
	
	
	



	$.ajax({	          
	      url: "../invtsimis/tanks-capacitylist?tankId="+tankId,
	      type: "GET",
	      success: function (response) {
	    	  
	    
	    	
	    	var obj = JSON.parse(response);
	    	
	    	
	    	var geoId=obj[0].geoTagId;
	    	
	    	var capacity=obj[0].capacitytank;
	    var grossAyacut=obj[0].grossAyacut;
	    
	    		$('#grossCapacity').val(capacity);
	    		$('#geoTagId').val(geoId);
	    		$('#gayacut').val(grossAyacut);
	    		
	    		
	    	  
	    	  

	      },
	      error : function(){
	    	  alert(error);
	      }
	  });	
	} 

function editcrticalstatus(tstatusId){


	
	 $('#edittankstatus_dialogue').dialog('option', 'title', 'Edit Tank Status');
	  $('#edittankstatus_dialogue').dialog('open');
	  
	  $('#editstatusid').trigger("reset"); 
	  
	  
	  $('#edittankStatusId').val(tstatusId); 
	  
	
	

}

function submitcriticalstatus(){
	
	  var mst1Id= $('#editcriticalMst1Id').val(); 
//	  alert("mst1Id" +mst1Id);
	  
	  var tstatusId= $('#edittankStatusId').val(); 
//	  alert("tstatusId" +tstatusId); 
	/*  var unitId= $('#editUnitId').val(); 
	//  alert("unitId" +unitId);
	  var circleId= $('#editCircleId').val(); 
	//  alert("circleId" +circleId);
	  var divisionId= $('#editDivisionId').val(); 
	//  alert("divisionId" +divisionId);
	  var subdivisionId= $('#editSubDivisionId').val(); 
	//  alert("subdivisionId" +subdivisionId);
*/	  
	  $("#tankStatusId").multiselect('rebuild');
		
	  $.ajax({	          
			url: "../invtsimis/update-critical-status",
			method:"POST",
			dataType: 'json',

			async: false,
			data: {
				miInpsectMst1Id:mst1Id,
				  
				tankStatusId:tstatusId,
				/*unitId:unitId,
				circleId:circleId,
				divisionId:divisionId,
				subdivisionId:subdivisionId*/
				
			},
			success: function (obj) {
		  
		//		alert("submitcriticalstatus obj "+obj);
			//	console.log(obj);
				  if(obj!=null){
					  
					  $('#edittankstatus_dialogue').dialog('close');
					  
					  $('#action_alert').html('<p style="margin: 0px !important;">Status Updated</p>');
					  
					  var idnew=parseInt(obj);
				  
					  $("#tankStatusId").each(function () {
					 
						  $(this).val(idnew);
					    	            $(this).attr("selected", "selected");
					    	  		  $('#tankStatusId1').val(idnew);
					    	  		  $('#tankStatusId2').val(idnew);
					    	  		  $('#tankStatusId3').val(idnew);
			    	});
					  
					  $("#tankStatusId").multiselect('rebuild');
			 	 
				  }
				  if(obj==0||obj==null){
					  $('#edittankstatus_dialogue').dialog('open');
					  $('#action_alert').html('<p style="margin: 0px !important;">Failed to Update Status</p>');
					  }
			
			},
			error : function(){
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
					var $select = $('#editCircleId');
					
					var selectedCircleId= $('#hiddencircleId').val();
					
					//alert("selectedCircleId"+selectedCircleId);
                    }
                    if(hkey==2){
                    	
                    	var $select = $('#dipackcircleId');
                    }
					$select.find('option').remove();

					var obj = JSON.parse(response);
					
					if(hkey==1){
					$('#editCircleId').append(
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
	  						
	  					$('#editCircleId').append( '<option value="'+value.circleId+'" selected="selected"> '+value.circleName+'</option>' );
	  					
	  						}
	  						
	  					 if(selectedCircleId==null||selectedCircleId!=value.circleId){
	  							$('#editCircleId').append( '<option value="'+value.circleId+'"> '+value.circleName+'</option>' );	
	  						
	  						} 
							
						

						$('#editCircleId').multiselect('rebuild');
						
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
			var $select = $('#editDivisionId');
			
			var selecteddivisionId= $('#hiddendivisionId').val();
			}
			if(hkey==2){
				var $select = $('#dipackdivisionId');
				}

			$select.find('option').remove();

			var obj = JSON.parse(response);
			
			if(hkey==1){
			$('#editDivisionId').append(
					'<option value="0"> --select--</option>');
			}
			if(hkey==2){
			$('#dipackdivisionId').append(
			'<option value="0"> --select--</option>');
			}

			$.each(obj, function(key, value) {
				if(hkey==1){
					if(selecteddivisionId==value.divisionId){
				$('#editDivisionId').append(
						'<option value="'+value.divisionId+'" selected="selected"> '
								+ value.divisionName + '</option>');
					}
					
					 if(selecteddivisionId==null||selecteddivisionId!=value.divisionId){
						 
							$('#editDivisionId').append(
									'<option value="'+value.divisionId+'"> '
											+ value.divisionName + '</option>');
						 
					 }

				$('#editDivisionId').multiselect('rebuild');
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
			var $select = $('#editSubDivisionId');
			
			var selectedsubdivisionId= $('#hiddensubdivisionId').val();
			//alert("selectedsubdivisionId"+selectedsubdivisionId);
			}
			/* if(hkey==2){
				var $select = $('#subdivisionId');	
				
			} */
			$select.find('option').remove();

			var obj = JSON.parse(response);
			
		
			$('#editSubDivisionId').append(
					'<option value="0"> --select--</option>');
			

			$.each(obj, function(key, value) {

				if(selectedsubdivisionId==value.subdivisionId){
				$('#editSubDivisionId').append(
						'<option value="'+value.subdivisionId+'" selected="selected" > '
								+ value.subdivisionName + '</option>');
				}
				if(selectedsubdivisionId==null || selectedsubdivisionId!=value.subdivisionId){
					$('#editSubDivisionId').append(
							'<option value="'+value.subdivisionId+'" > '
									+ value.subdivisionName + '</option>');
					}

				$('#editSubDivisionId').multiselect('rebuild');
			});

		},
		error : function() {
			alert(error);
		}
	});
}

function getdescdata(repairdescId){
	
	var repairdescId=repairdescId
	//document.getElementById("districtId").value;
	  $('#repairdesc').trigger("reset"); 

	//alert("repairdescId"+repairdescId);
	
	if(repairdescId!=null){
$.ajax({	          
      url: "../invtsimis/repairdata-byid?repairdescId="+repairdescId,
      type: "GET",
      success: function (response) {
    	  
    	//  console.log(response);
    	//  alert(response)
    	  
    	if(response!=null){
    		
    		$('#editRepairdesc').show();
    		
    		$('#deleteRepairdesc').show();
    		
				var obj = JSON.parse(response);
				$.each(obj, function(key, value) {
					
					//alert(value.repairDescription);
					
					$('#repairStartDate').val(value.repairStartDate);
					$('#repairEndDate').val(value.repairEndDate);
					$('#schemeTaken').val(value.schemeTaken);
					$('#repairDescription').val(value.repairDescription);
					$('#updaterepairdescId').val(value.repairdescId);
					
					
					 
				});
				
    	}
    	
    	if(response==null){
    		
	        $('#editRepairdesc').hide();
    		
    		$('#deleteRepairdesc').hide();
    		
    	}

      },
      error : function(){
    	  alert(error);
      }
  });	
	 }
	if(repairdescId==null || repairdescId==" "){
		
		 $('#editRepairdesc').hide();
 		
 		$('#deleteRepairdesc').hide();
	}
	
}

function viewrepairReview(repairId,tankId){
	
	 $('#viewRemarks_dialogue').dialog('option', 'title', 'View/Edit Remarks Info');
	  $('#viewRemarks_dialogue').dialog('open');
	  
	  $('#viewremarksid').trigger("reset"); 
	
	viewRepairsRemarks(repairId);
}






function viewRepairsRemarks(repairId){
	
	$("#viewhead1").empty();
	$("#viewbody1").empty();
	
	
	
	var postId=$("#postId5").val();
	
	//alert("kal");
	
	 $.ajax({	          
			url: "../invtsimis/get-repair-remarks" ,
			method:"GET",
			dataType: 'json',

			async: false,
			data: {
				  
				mitankRepairsId:repairId,
				  
			},


			success: function (obj) {

				// console.log(obj);
				  
				    //	  var obj = JSON.parse(msg);
				
				    	  var j=1;
				    	  
				    	//alert("kalhere");
				    	    $('#viewmst1data table thead').append( '<tr style="font-size: 18px; color: gray; font-weight: bold;"><th>Sl.No</th>'+
				    	    		
				    	    		'<th>Remarks</th>'+
				    	    	
				    	    		/*'  <th>Latest</th>'+*/
				    	    		'  <th>RemarksDate</th>'+
				    	    		
				    	    		' <th>Submitted By </th>'+
				    	    		
				    	    		'  <th>Submitted To</th>'+
				    	    		
				    	    		'<th colspan="2">Action</th></tr>'); 	  
				    	    
				    	    for(i in obj){
				    	    	
				    	    	var s= obj[i].postId ;
				    	    	
				    	    	   $('#viewmst1data table tbody').append(  '<tr style="font-size: 16px">' +
				    	    			                                '<td style="text-align: center;">'+j+'</td>' +
				    	    			                                
				    	    			                                '<td><b>'+obj[i].remarks+'</b></td>' +
				    	    			                             
				    	    			                              /*  '<td><b>'+obj[i].latestRemarks+'</b></td>' +*/
				    	    			                                '<td><b>'+obj[i].repairRemarksDate+'</b></td>' +
				    	    			                                
				    	    			                                '<td><b>'+obj[i].remarksSubmittedBy+'</b></td>' +
				    	    			                                
				    	    			                                '<td><b>'+obj[i].submittedToEmpName+'</b></td>' +
				    	    			                              
				    	    			                                	    	    			                               
				    	    			                                (s==postId?   '<td colspan="2" ><button type="button" name="editmst1remarks" id="editrepairremarks'+j+'" class="btn btn-1 btn-primary center-block repairmarksedit"   >Edit</button>'+
				    	    			                                '<button type="button" name="deletereremarks" id="deleterepairremarks'+j+'" class="btn btn-1 btn-primary center-block repairmarksdelete" onclick="deleterepairremarks('+obj[i].mitankRepairsReviewId+','+obj[i].mitankRepairsId+',5)" >Delete</button> </td>':'')+
				    	    			                                '</tr>');
				    	    	   
				    	    	   $('.repairmarksedit').hide();
				    	    	  
				    	    	   
				    	    	 /*  if(obj[i].submittedBy==userempId){
				    	    		   
				    	    		   $('.repairmarksedit').hide();
					    	    	   $('.repairmarksdelete').show(); 
				    	    	   }
				    	    	   */
				    	    	   
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


function viewcapacityReview(capacityId,tankId){
	
	 $('#viewRemarks_dialogue').dialog('option', 'title', 'View/Edit Remarks Info');
	  $('#viewRemarks_dialogue').dialog('open');
	  
	  $('#viewremarksid').trigger("reset"); 
	
	  viewCapacityRemarks(capacityId);
}

/*
function viewinoutReviewinfo(inoutId,tankId){
	
	 $('#viewRemarks_dialogue').dialog('option', 'title', 'View/Edit Remarks Info');
	  $('#viewRemarks_dialogue').dialog('open');
	  
	  $('#viewremarksid').trigger("reset"); 
	
	  viewInoutRemarks(inoutId);
	
	
}
*/



function viewCapacityRemarks(capacityId){
	
	$("#viewhead1").empty();
	$("#viewbody1").empty();
	
	var postId=$("#postId6").val();
	
	//alert("kal");
	
	 $.ajax({	          
			url: "../invtsimis/get-capacity-remarks" ,
			method:"GET",
			dataType: 'json',

			async: false,
			data: {
				  
				mitankCapacityId:capacityId,
				
				  
			},


			success: function (obj) {

				  
				// console.log(obj);
				    //	  var obj = JSON.parse(msg);
				
				    	  var j=1;
				    	  
				    	//alert("kalhere");
				    	    $('#viewmst1data table thead').append( '<tr style="font-size: 18px; color: gray; font-weight: bold;"><th>Sl.No</th>'+
				    	    		
				    	    		'<th>Remarks</th>'+
				    	    	
				    	    		/*'  <th>Latest</th>'+*/
				    	    		'  <th>Date</th>'+
				    	    		
				    	    		' <th>Submitted By </th>'+
				    	    		
				    	    		'  <th>Submitted To</th>'+
				    	    		
				    	    		
				    	    		
				    	    		'<th colspan="2">Action</th></tr>'); 	  
				    	    
				    	    for(i in obj){
				    	    	
				    	    	var s= obj[i].postId ;
				    	    	
				    	    
				    	    	
				    	    	   $('#viewmst1data table tbody').append(  '<tr style="font-size: 16px">' +
				    	    			                                '<td style="text-align: center;">'+j+'</td>' +
				    	    			                               
				    	    			                                '<td><b>'+obj[i].remarks+'</b></td>' +
				    	    			                             
				    	    			                                /*'<td><b>'+obj[i].latestRemarks+'</b></td>' +*/
				    	    			                                '<td><b>'+obj[i].capacityRemarksDate+'</b></td>' +
				    	    			                                
				    	    			                                '<td><b>'+obj[i].remarksSubmittedBy+'</b></td>' +
				    	    			                                
				    	    			                                '<td><b>'+obj[i].submittedToEmpName+'</b></td>' +
				    	    			                              
				    	    			                               /* <button type="button" name="editmst1remarks" id="editcapacityremarks'+j+'" class="btn btn-1 btn-primary center-block capacityreedit"   >Edit</button> 	*/    	    			                               
				    	    			                                (s==postId? '<td colspan="2" > <button type="button" name="editmst1remarks" id="editcapacityremarks'+j+'" class="btn btn-1 btn-primary center-block capacityreedit"  onclick="editcapacityremarksfn('+obj[i].mitankCapacityReviewId+','+obj[i].mitankCapacityId+',6)"  >Edit</button>    &emsp;  &emsp; '+
				    	    			                                '<button type="button" name="deletecapacityremarks" id="deletecapacityremarks'+j+'" class="btn btn-1 btn-primary center-block capacityredelete" onclick="deletecapremarks('+obj[i].mitankCapacityReviewId+','+obj[i].mitankCapacityId+',6)" >Delete</button> </td>':'')+
				    	    			                                '</tr>');
				    	    	   
				    	    	   
				    	    	 // $('.capacityreedit').hide();
				    	    	  // $('.capacityredelete').hide();
				    	    	   
				    	    	  /* if(obj[i].submittedBy==userempId){
				    	    		   
				    	    		   $('.capacityreedit').hide();
					    	    	   $('.capacityredelete').show(); 
				    	    	   }*/
				    	    	   
				    	    	  
				    	    	   
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

/*function viewInoutRemarks(inoutId){
	
	$("#viewhead1").empty();
	$("#viewbody1").empty();
	
	
	
	//alert("kal");
	
	 $.ajax({	          
			url: "../invtsimis/get-inout-remarks" ,
			method:"GET",
			dataType: 'json',

			async: false,
			data: {
				  
				mitankInoutFlowId:inoutId,
				
				  
			},


			success: function (obj) {

				  
				// console.log(obj);
				  
			

				
				  
				
				    //	  var obj = JSON.parse(msg);
				
				    	  var j=1;
				    	  
				    	//alert("kalhere");
				    	    $('#viewmst1data table thead').append( '<tr style="font-size: 18px; color: gray; font-weight: bold;"><th>Sl.No</th>'+
				    	    		' <th>Designation </th>'+
				    	    		'<th>Remarks</th>'+
				    	    	
				    	    		'  <th>Latest</th>'+
				    	    		
				    	    		'  <th>Submitted To</th>'+
				    	    		
				    	    		
				    	    		
				    	    		'<th colspan="2">Action</th></tr>'); 	  
				    	    
				    	    for(i in obj){
				    	    	
				    	    
				    	    	
				    	    	   $('#viewmst1data table tbody').append(  '<tr style="font-size: 16px">' +
				    	    			                                '<td style="text-align: center;">'+j+'</td>' +
				    	    			                                '<td><b>'+obj[i].designation+'</b></td>' +
				    	    			                                '<td><b>'+obj[i].remarks+'</b></td>' +
				    	    			                             
				    	    			                                '<td><b>'+obj[i].latestRemarks+'</b></td>' +
				    	    			                                
				    	    			                                '<td><b>'+obj[i].submittedToEmpName+'</b></td>' +
				    	    			                              
				    	    			                                	    	    			                               
				    	    			                                '<td colspan="2" ><button type="button" name="editmst1remarks" id="editinoutremarks'+j+'" class="btn btn-1 btn-primary center-block mst1edit"   >Edit</button>'+
				    	    			                                '<button type="button" name="deletemst1remarks" id="deleteinoutremarks'+j+'" class="btn btn-1 btn-primary center-block mst1delete "  >Delete</button> </td>'+
				    	    			                                '</tr>');
				    	    	   
				    	    	   
				    	    	  
				    	    	   
				    	    	   j++;
				    	    	   
				    	    
				    	    }
				    
				    	    $(".capacityremadd").hide();
					    	  $(".capacityedit").hide();
					    	  $(".capacitydelete").hide();
					    	 
					    	  
					    	  
				    	    
				    	
				  
			
				 
				 
			
				
			

			},
			error : function(){
				 alert(error);

			}
			}); 
	
	
	
	
}
*/	


function deletemst1remarks(mst1reviewId,mst1Id,tabId){
	//alert//("mst1reviewId"+mst1reviewId);
	
	 $.ajax({	          
			url: "../invtsimis/delete-Mtank1-Remarks",
			method:"POST",
			dataType: 'json',

			async: false,
			data: {
				miInpsectMst1IdReviewId:mst1reviewId,
				tabId:tabId
			},

			success: function (response) {
				//  console.log(response);
				  
				if(response>0){

				  $('#action_alert').html('<p style="margin: 0px !important;">Data Deleted Successfully</p>');
				  $("html,body").animate({scrollTop:0}, 500);
				  viewmst1Remarks(mst1Id,tabId);
				}
				
				if(response==0 || response==null){
					
					 $('#action_alert').html('<p style="margin: 0px !important;">Failed to Delete Data</p>');
					   	
					 $("html,body").animate({scrollTop:0}, 500);
				}
			},
			error : function(){
				 alert(error);

			}
			}); 
}

function editmst1remarksfn(mst1reviewId,mst1Id,tabId){
	
//	alert("mst1reviewId"+mst1reviewId+"mst1Id"+mst1Id+"tabId"+tabId);
	
	 $('#review_dialogue').dialog('option', 'title', 'Edit Remarks');
	  $('#review_dialogue').dialog('open');	  
	  $('#reviewformid').trigger("reset"); 
	  $('.reviewbutton').hide();
	   $('.editreviewbutton').show();
	  
	  $('#action_alert').html('');
	 
	  
	  if(tabId==1){	  
	  $('.editreviewbutton').attr('id', 'editmst1embreview');
	  $('#embreview').hide();
	  $('.editreviewbutton').show();
	//   var  getid= $('.reviewbutton').prop('id');
	//  alert(getid);
	 //  $('#reviewinfoid').hide();
	   
	  }
	  if(tabId==2){		  
		  $('.editreviewbutton').attr('id', 'editmst1slureview');
		  $('#slureview').hide();
		  $('.editreviewbutton').show();
		  }
	  if(tabId==3){		  
		  $('.editreviewbutton').attr('id', 'editmst1weirreview');
		//  $('#weirreview').hide();
		  $('.editreviewbutton').show();
		  }
	  
	  $.ajax({	          
			url: "../invtsimis/getmst1remarks-byreviewid",
			method:"POST",
			dataType: 'json',

			async: false,
			data: {
				miInpsectMst1IdReviewId:mst1reviewId,
				
			},

			success: function (msg) {
			//	 console.log(msg);
				  
				if(msg!=null ){
				//	$('#tankFeedRemarks').hide();
					var mst1rem=msg.remarks;
					var i=msg.tabId;
					var p=msg.miInpsectMst1Id;
					var q=msg.miInpsectMst1IdReviewId;
				//	alert(mst1rem);
					$('#editmiInpsectMst1IdReviewIdhide').val(q);
					$('#editremarksmst1Id').val(p);
					$('#editremarksmst1tabID').val(i);
					$('#tankFeedRemarks').val(mst1rem);
					
				}
				
				if(msg==0 || msg==null){
					 $('#action_alert').html('<p style="margin: 0px !important;">Failed to get inspection remarks</p>');
					 $("html,body").animate({scrollTop:0}, 500);
				}
			},
			error : function(){
				 alert(error);

			}
			
			}); 
	 
}
function updatemst1editedremarks()
{
	var  tabId=$('#editremarksmst1tabID').val();
	
	if(tabId==1||tabId==2||tabId==3){
	var mst1reviewid=$('#editmiInpsectMst1IdReviewIdhide').val();
	var rem = $('#tankFeedRemarks').val();
	var mst1Id=$('#editremarksmst1Id').val();

	 $('#action_alert').html('');
	// alert("mst1reviewId"+mst1reviewid+"mst1Id"+mst1Id+"tabId"+tabId+"rem"+rem);
	 
	 if ($('form[id=reviewformid]').parsley().isValid()) {  	
	$.ajax({	          
		url: "../invtsimis/update-Mst1remarks-byreviewid" ,
		method:"POST",
		dataType: 'json',

		async: false,
		data: {
			miInpsectMst1IdReviewId:mst1reviewid,
			remarks:rem,
		},

		success: function (response) {
		//	 console.log(response);
			if(response>0){
				
			  $('#action_alert').html('<p style="margin: 0px !important;">Remarks edited successfully</p>');
			  $("html,body").animate({scrollTop:0}, 500);
			  $('#reviewformid').trigger("reset"); 
			  $('#review_dialogue').dialog('close');
			  
			  viewmst1Remarks(mst1Id,tabId);
			}
			
			if(response==0 || response==null){
				 $('#review_dialogue').trigger("open"); 
				 $('#action_alert').html('<p style="margin: 0px !important;">Failed to edit remarks</p>');
				 $("html,body").animate({scrollTop:0}, 500);
			}
		},
		error : function(){
			 alert(error);

		}
		}); 
}else {
	//$('#tankFeedRemarks').removeAttr('required');
	$('form[id=reviewformid]').parsley().validate();
	//$('#tankFeedRemarks').attr('required', false);
	
}
	 
	}
	
	if(tabId==6){
		var mstcapacityreviewid=$('#editmiCapcityReviewIdhide').val();
		var rem2 = $('#tankFeedRemarks').val();
		var mstcapcityId=$('#editremarksCapacityIdhide').val();

		 $('#action_alert').html('');
		//alert("mstcapacityreviewid"+mstcapacityreviewid+"tabId"+tabId+"rem2"+rem2);
		 
		 if ($('form[id=reviewformid]').parsley().isValid()) {  	
		$.ajax({	          
			url: "../invtsimis/update-MstCapacityremarks-byreviewid" ,
			method:"POST",
			dataType: 'json',

			async: false,
			data: {
				mitankCapacityReviewId:mstcapacityreviewid,
				remarks:rem2,
			},

			success: function (response) {
			//	 console.log(response);
				if(response>0){
					
				  $('#action_alert').html('<p style="margin: 0px !important;">Remarks edited successfully</p>');
				  $("html,body").animate({scrollTop:0}, 500);
				  $('#reviewformid').trigger("reset"); 
				  $('#review_dialogue').dialog('close');
				  
				  
				  viewCapacityRemarks(mstcapcityId);
				 // viewmst1Remarks(mst1Id,tabId);
				}
				
				if(response==0 || response==null){
					 $('#review_dialogue').trigger("open"); 
					 $('#action_alert').html('<p style="margin: 0px !important;">Failed to edit remarks</p>');
					 $("html,body").animate({scrollTop:0}, 500);
				}
			},
			error : function(){
				 alert(error);

			}
			}); 
	}else {
		//$('#tankFeedRemarks').removeAttr('required');
		$('form[id=reviewformid]').parsley().validate();
		//$('#tankFeedRemarks').attr('required', false);
		
	}
		 
		}


}

function deleterepairremarks(repairreviewId,repairId,tabId){
	
//	alert("kal coming here"+repairreviewId);
	 $.ajax({	          
			url: "../invtsimis/delete-Mtank-Repairs-Remarks" ,
			method:"POST",
			dataType: 'json',

			async: false,
			data: {
				  
				mitankRepairsReviewId:repairreviewId,
				tabId:tabId
				  
			},


			success: function (response) {

				  
				//  console.log(response);
				  
				if(response>0){

				  $('#action_alert').html('<p style="margin: 0px !important;">Data Deleted Successfully</p>');
				  $("html,body").animate({scrollTop:0}, 500);
				  
				
				  
				  viewRepairsRemarks(repairId);
				 
				  
				}
				
				if(response==0 || response==null){
					
					
					
					 $('#action_alert').html('<p style="margin: 0px !important;">Failed to Delete Data</p>');
					   	
					 $("html,body").animate({scrollTop:0}, 500);
				}
				

			},
			error : function(){
				 alert(error);

			}
			}); 


	
}


/*function deletecapacityremarks(capacityReviewId,capacityId,tabId){
	
	 $.ajax({	          
			url: "../invtsimis/delete-Mtank-Capacity-Remarks" ,
			method:"POST",
			dataType: 'json',

			async: false,
			data: {
				  
				mitankCapacityReviewId:capacityReviewId,
				tabId:tabId
				  
			},


			success: function (response) {

				  
				//  console.log(response);
				  
				if(response>0){

				  $('#action_alert').html('<p style="margin: 0px !important;">Data Deleted Successfully</p>');
				  $("html,body").animate({scrollTop:0}, 500);
				  
				
				  
				  viewCapacityRemarks(capacityId);
				 
				  
				}
				
				if(response==0 || response==null){
					
					
					
					 $('#action_alert').html('<p style="margin: 0px !important;">Failed to Delete Data</p>');
					   	
					 $("html,body").animate({scrollTop:0}, 500);
				}
				

			},
			error : function(){
				 alert(error);

			}
			}); 


	
}*/

function showtankdata (tankName,tankId,tankCode,districtId,mcode,vcode,acode,hcode,manName,villName,formId){
	

	
	$('#tankId').val(tankId);
	
	// $('#tankdata').html('<p style="margin: 0px !important; font-weight:bold; color:blue">'+tankCode+'-'+tankName+'</p>');
	// $('#mandata').html('<p style="margin: 0px !important; font-weight:bold; color:blue">'+manName+'</p>');
	// $('#villdata').html('<p style="margin: 0px !important; font-weight:bold; color:blue">'+villName+'</p>');
	 var tanknewname=tankCode+"-"+tankName ; 
	 $('#mandata').val(manName);
	 $('#villdata').val(villName);
	 $('#tankdata').val(tanknewname);
	 
	  var districtId = districtId
	  
	  if(parseInt(districtId)>0){

	  $('#midistrictId1').val(districtId);
	  $('#midistrictId2').val(districtId);
	  $('#midistrictId3').val(districtId);
	 /* $('#midistrictId4').val(id);*/
	  $('#midistrictId5').val(districtId);
	  $('#midistrictId6').val(districtId);
	  $('#midistrictId7').val(districtId);
	  $('#editmidistrictId').val(districtId);
	  }
	 
	 
	  var mcode = mcode
	  if(parseInt(mcode)>0){
	  $('#mimandalId1').val(mcode);
	  $('#mimandalId2').val(mcode);
	  $('#mimandalId3').val(mcode);
	/*  $('#mimandalId4').val(id);*/
	  $('#mimandalId5').val(mcode);
	  $('#mimandalId6').val(mcode);
	  $('#mimandalId7').val(mcode);
	  $('#editmimandalId').val(mcode);
	  }
	 
	  var vcode = vcode;
	  if(parseInt(vcode)>0){
	  $('#mivillageId1').val(vcode);
	  $('#mivillageId2').val(vcode);
	  $('#mivillageId3').val(vcode);
	/*  $('#mivillageId4').val(id);*/
	  $('#mivillageId5').val(vcode);
	  $('#mivillageId6').val(vcode);
	  $('#editmivillageId').val(vcode);
	  }
	  
	 // acode
	  
	  var tankId = tankId;
	
	  if(tankId>0){

	  $('#mitankId1').val(tankId);
	  $('#mitankId2').val(tankId);
	  $('#mitankId3').val(tankId);
	  
	 /* $('#mitankId4').val(id);*/
	  $('#mitankId5').val(tankId);
	  $('#mitankId6').val(tankId);
	  $('#mitankId7').val(tankId);
	  $('#mitankId8').val(tankId);
	  $('#editmitankId').val(tankId);
	  
	  }
	 
	  var acode = acode;
		
	  if(parseInt(acode)>0){

		  $('#constId1').val(acode);
		  $('#constId2').val(acode);
		  $('#constId3').val(acode);
		/*  $('#constId4').val(constId);*/
		  $('#constId5').val(acode);
		  $('#constId6').val(acode);
		  $('#constId7').val(acode);
		  $('#editconstId').val(acode);
		
		  }
	
	// alert("i am here");
	
	 $('#gettanks').trigger("reset"); 
	 
	// alert("iam at  end "+formId);s
	 if(formId==1){
	 $('#gettanks_dialogue').dialog('close'); 
	 }
	 
	 if(formId==2){
		 $('#getanicut_dialogue').dialog('close'); 
		 }
	 
	 if(formId==3){
		 $('#getcheckdam_dialogue').dialog('close'); 
		 }
	
}

function deletecapremarks(capacityReviewId,capacityId,tabId){
	
//	alert("HI");
//	alert("capacityReviewId "+capacityReviewId+"capacityId "+capacityId+"tabId "+tabId);
	
	 $.ajax({	          
			url: "../invtsimis/delete-Mtank-Capacity-Remarks" ,
			method:"POST",
			dataType: 'json',

			async: false,
			data: {
				  
				mitankCapacityReviewId:capacityReviewId,
				tabId:tabId
				  
			},


			success: function (response) {

				  
				//  console.log(response);
				  
				if(response>0){

				  $('#action_alert').html('<p style="margin: 0px !important;">Data Deleted Successfully</p>');
				  $("html,body").animate({scrollTop:0}, 500);
				  
				
				  
				  viewCapacityRemarks(capacityId);
				 
				  
				}
				
				if(response==0 || response==null){
					
					
					
					 $('#action_alert').html('<p style="margin: 0px !important;">Failed to Delete Data</p>');
					   	
					 $("html,body").animate({scrollTop:0}, 500);
				}
				

			},
			error : function(){
				 alert(error);

			}
			}); 


	
}


function editcapacityremarksfn(capreviewId,tcapacityId,tabId){
	
//	alert("mst1reviewId"+mst1reviewId+"mst1Id"+mst1Id+"tabId"+tabId);
	
	 $('#review_dialogue').dialog('option', 'title', 'Edit Remarks');
	  $('#review_dialogue').dialog('open');	  
	  $('#reviewformid').trigger("reset"); 
	  $('.reviewbutton').hide();
	   $('.editreviewbutton').show();
	  
	  $('#action_alert').html('');
	 
	  
	  if(tabId==1){	  
		  
		  $('.editreviewbutton').attr('id', 'editmst1embreview');
		  $('#embreview').hide();
		  $('#slureview').hide();
		  $('#weirreview').hide();
		  $('.editreviewbutton').show();
	  }
	  
	/*  if(tabId==1){	  
	  $('.editreviewbutton').attr('id', 'editmst1embreview');
	  $('#embreview').hide();
	  $('.editreviewbutton').show();

	  }
	  if(tabId==2){		  
		  $('.editreviewbutton').attr('id', 'editmst1slureview');
		  $('#slureview').hide();
		  $('.editreviewbutton').show();
		  }
	  if(tabId==3){		  
		  $('.editreviewbutton').attr('id', 'editmst1weirreview');
		//  $('#weirreview').hide();
		  $('.editreviewbutton').show();
		  }*/
	  
	  $.ajax({	          
			url: "../invtsimis/getCapacityremarks-byreviewid",
			method:"POST",
			dataType: 'json',

			async: false,
			data: {
				mitankCapacityReviewId:capreviewId,
				
			},

			success: function (msg) {
			//	 console.log(msg);
				  
				if(msg!=null ){
				//	$('#tankFeedRemarks').hide();
					var mst1rem=msg.remarks;
					var i=msg.tabId;
					var p=msg.mitankCapacityId;
					var q=msg.mitankCapacityReviewId;
				//	alert(mst1rem);
					$('#editmiCapcityReviewIdhide').val(q);
					$('#editremarksCapacityIdhide').val(p);
					$('#editremarksmst1tabID').val(i);
					$('#tankFeedRemarks').val(mst1rem);
					
				}
				
				if(msg==0 || msg==null){
					 $('#action_alert').html('<p style="margin: 0px !important;">Failed to get inspection remarks</p>');
					 $("html,body").animate({scrollTop:0}, 500);
				}
			},
			error : function(){
				 alert(error);

			}
			
			}); 
	 
}


//form 20 functions start

/*function addformdata(frmname){
	//alert("frmname"+frmname);
	
	var subbutton=	$("#addmichecks8").text();
	
	  var valid = "Are you sure you want to submit form 20?";
	  
	  if(subbutton=='Submit'){ 
		  
		  if (confirm(valid)) {
		  
		  

	 var customformid="#"+frmname;
	 
	// alert("customformid"+customformid);
		
			var tankId=$("#tankId").val();
			
	//		var m=$('#inspectDateinflows').val();
	//		alert("inspectDateinflows" + m);
		var nextemp=$("#nextEmpId").val();
		
		 $('#action_alert').empty();
		 
		// $('form[name='+frmname+']').serialize(),
		 
		 var form = $("#michecks8").closest("form");
		 var formData = new FormData(form[0]);
		 
		// console.log("formData"+formData);
		 
		  if ( $('form[name='+frmname+']').parsley().isValid() ) {
	
		  // var formData = new FormData(document.getElementsByName(frmname));  enctype: 'multipart/form-data',
	 	 $.ajax({	          
		      url: "../invtsimis/addFormData",
		      method:"POST",
		      async: false,
		      data:  formData,
		    
              contentType: false,
              processData: false,
		      
		       
		     
			 
		      success: function (response) {
		   
		    	//alert("kal"+response);
		    	 
		    	 if(response>0){
		    		 
		    	//	alert("i am in kal Data inserttedd Successfully");
		
			  $('#action_alert').html('<p style="margin: 0px !important;">Data inserted Successfully</p>');
				$("html,body").animate({scrollTop:$('#action_alert').offset().top-175}, 500);
				
				  $('#flreg').hide();
				  $('#flrain').hide();
				  
				  $('#flbld').hide();
				  
				  for(var i=1 ; i<10; i++){
					  
					  var str="#flani"+i;
					  
					  $(str).hide();
				  }
				 
				  getfrmsentlist(tankId)
				  
				 
			    }
				
				if(response==0||response==null){
			    	
			    	  $('#action_alert').html('<p style="margin: 0px !important;">Failed to Update data</p>');
			    		$("html,body").animate({scrollTop:$('#action_alert').offset().top-175}, 500);
			    }
				
				 $(customformid).trigger("reset"); 	
				
  },
		      
		      error : function(){
		    	 alert(error);
		    
		      }

		  
		  });   
	 	 
	  
		  
	  }else{
		  
		 
				
				$('form[name='+frmname+']').parsley().validate();
				//alert("kal4");
			
	  }
			return true;
		  
		  }
	       else{
	       	
	       	return false;
	         
	       }
		  
	  }
	
}*/

/*function getfrmsentlist(tankId){
	
	
		//alert("kal"+tankId);
	$("#addmichecks8").text( 'Submit');
	$(".updatepht").show();
	$("#regLeftChnnAcres").val('0.00');
	$("#regRightChnnAcres").val('0.00');
	$("#regOthAcres").val('0.00');
	$("#rainRGStation").val("");
	$("#rainQty").val('0.00');
	$("#rainDate").val(0);
		
	
	//var xdate=$("#regLeftChnnAcres").val();
	//alert("regLeftChnnAcres"+xdate)
	
	$("#quartName").val("");
	$("#quartType").val("");
	$("#bldgTypeName").val("");
	$("#bldgDescDamage").val("");
	$("#approxRepTemp").val('0.00');
	
	$("#approxRepPermanent").val('0.00');
	
	$("#frmBookValue").val('0.00');
	$("#effAyacutAcres").val('0.00');
	$("#effAyacutValue").val('0.00');
	$("#actionStdCrops").val("");
	$("#damageBreaches").val("");
	$("#usefulRemarks").val("");
	$("#tsfcFormDate").val(0);
	
	$("#damageDate").val(0);
	$("#damageTime").val("0.00");
	$("#damageCause").val("");
	$("#frmProposed").val("");
	$("#writeOffValue").val('0.00');
	$("#writeOffAction").val("");				
	$("#regchkid").prop('checked', false);
	$("#rainchkid").prop('checked', false);
	$("#bldchkid").prop('checked', false);
	$("#bldchkid").prop('checked', false);
	
	$("#bldchkid").prop('checked', false);
	
	for(var i=0; i<9 ; i++){
		var anchk="#anichkid"+i ;
		$(anchk).prop('checked', false);
		
		}
	
	chkshowdata();
	
	 for(var h=1; h<9; h++){
		 
			// alert(t+"t");
		 
		 m=h-1;
		 
		 var irrchfrom="#irrChFrm"+m;
		 var irrchto="#irrChTo"+m;
		 var irrl="#irrL"+m;
		 var irrb="#irrB"+m;
		 var irrd="#irrD"+m;
		 var irrpcost="#irrPermcost"+m;
		 var irrtcost="#irrTempcost"+m;
		 
		// alert("m"+m);
		 
		// $(irrsrcname).val(obj[i].irrSrcName);
		 $(irrchfrom).val('0.00');
		 $(irrchto).val('0.00');
		 $(irrl).val('0.00');
		 $(irrb).val('0.00');
		 $(irrd).val('0.00');
		 $(irrpcost).val('0.00');
		 $(irrtcost).val('0.00');
			 
		
		 }

		
		$("#thead8").empty();
		$("#tbody8").empty();
	
	

		$.ajax({	          
		      url: "../invtsimis/frm-list?tankId="+tankId,
		      type: "GET",
		      success: function (response) {
		    	  
		    	
		    	
		    	  var j=1;
		    	  
		    	  $('#frm20data table thead').append( '<tr style="font-size: 18px; color: gray; font-weight: bold;"><th>Sl.No</th>'+
		    	    		
		    	    		'<th>Form20Sent Date</th>'+
		    	    	
		    	    		'  <th>Latest</th>'+
		    	    		'  <th>View Form 20</th>'+
		    	    		
		    	    		' <th>Edit Form 20 </th>'+
		    	    		
		    	    		' <th>Update Photos </th>'+
		    	    		
		    	    		'  <th>Delete form 20</th>'+
		    	    		
		    	    		'  <th>View/Delete Photos</th>'+
		    	    		
		    	    		
		    	    		
		    	    		'</tr>'); 	 
				 
				
						var obj = JSON.parse(response);
						$.each(obj, function(key, value) {
							
						
							var finaldate=value.createDate;
							
							 var submittedDate = moment(finaldate, "DD/MM/YYYY").add(7, 'days').format('DD/MM/YYYY');
							 
							 var date = submittedDate.substring(0, 2);
							 var month = submittedDate.substring(3, 5);
							 var year = submittedDate.substring(6, 10);
							 var dateToCompare = new Date(year, month-1 , date);
							var currentdate= new Date();
							var latestdate=currentdate;
								
								//moment(currentdate, "DD/MM/YYYY").format("DD/MM/YYYY")
							//alert("latestdate"+latestdate);
							
							//and userdesignation is 2 or 4 or 8
							// in case of 4 then show ok to proceed button 
							//click on ok insert in apprv table 
							// get the STATUS from apprv table THEN SHOW EDIT BUTTON 
							
							  $('#frm20data table tbody').append(  '<tr style="font-size: 16px">' +
		                                '<td style="text-align: center;">'+j+'</td>' +
		                               
		                                '<td><b>'+value.tsfcFormDate+'</b></td>' +
		                             
		                                '<td><b>'+obj[i].latestRemarks+'</b></td>' +
		                                '<td><b><button type="button" name="viewfrmdata" id="viewfrmdata'+j+'" class="btn btn-1 btn-primary center-block frmview"  onclick="viewfrmdatafn('+value.formDataId+')"  >View Form 20</button> </b></td>' +
		                                
		                                (dateToCompare>latestdate?'<td><b><button type="button" name="editfrmdata" id="editfrmdata'+j+'" class="btn btn-1 btn-primary center-block frmedit"  onclick="editfrmdatafn('+value.formDataId+')"  >Edit Form 20</button> </b></td>': '<td></td') +
		                                (dateToCompare>latestdate? '<td><b><button type="button" name="editphotosdata" id="editphotosdata'+j+'" class="btn btn-1 btn-primary center-block frmphtedit"  onclick="editphotosdatafn('+value.formDataId+')"  >Update Photos</button> </b></td>': '<td></td') +
		                                
		                                (dateToCompare>latestdate? '<td><b><button type="button" name="deletefrmdata" id="deletefrmdata'+j+'" class="btn btn-1 btn-primary center-block frmdelete"  onclick="deletefrmdatafn('+value.formDataId+','+value.tankId+')"  >Delete Form20</button> </b></td>': '<td></td') +
		                                (dateToCompare>latestdate? '<td><b><button type="button" name="deletefrmpht" id="deletefrmpht'+j+'" class="btn btn-1 btn-primary center-block frmphtdelete"  onclick="deletefrmphtfn('+value.formDataId+')"  >View/Delete Photos</button> </b></td>': '<td></td') +
		                              
		                                 			                               
		                               
		                                '</tr>');
						
							
							
							  
							   j++;
							  
							 
						});

		      },
		      error : function(){
		    	  alert(error);
		      }
		  });	
		
	
}*/


/*function viewfrmdatafn(formdataId){
	
	
	//alert("kal"+formdataId);
	
	$("#view-thead9").empty();
	$("#view-tbody9").empty();

	
	 $('#frm20_view_dia').dialog('option', 'title', 'View Form 20 Info');
	  $('#frm20_view_dia').dialog('open');

	



	$.ajax({	          
	      url: "../invtsimis/get-frm-data?formDataId="+formdataId,
	      type: "GET",
	      async:false,
	     
		    contentType: "application/json; charset=utf-8",
	      success: function (response) {
	    	// alert(response);
	    	  
	    	//  console.log(response);
	    	
	    	
	    	  var j=1;
	    	  
	    	 
			 
			
				var obj = JSON.parse(response);
				
						
						  $('#viewfrm20 table tbody').append(  
	                              
	                               
								  '<tr><td><b>Damage Type</b></td><td><b>'+obj[0].damageTypeName+'</b></td></tr>' +
	                                '<tr><td><b>Date of Damage </b></td><td><b>'+obj[0].damageDate+'</b></td></tr>' +
	                                '<tr><td><b>Damage Time</b></td><td><b>'+obj[0].damageTime+'</b></td></tr>' +
	                                '<tr><td><b>Cause of Damage</b></td><td><b>'+obj[0].damageCause+'</b></td></tr>' +
	                                '<tr><td><b>Proposed Replace or Reconstruction </b></td><td><b>'+obj[0].frmProposed+'</b></td></tr>' +
	                                '<tr><td><b>If it is not proposed to replace or reconstruct the damaged portion of the property that the amount to be written off. The capital value of the property?(The amount should be estimated in the absense of the recorded book value)  </b></td><td><b>'+obj[0].writeOffValue+'</b></td></tr>' +
	                                '<tr><td><b>Action being taken to effect write off. </b></td><td><b>'+obj[0].writeOffAction+'</b></td></tr>' +
	                                '<tr><td style="color:blue"><b>Registered Ayacut</b></td><td  style="color:blue"><b>under left side Channel: '+obj[0].regLeftChnnAcres+' Acres</b></td><td  style="color:blue"><b>Under right side Channel: '+obj[0].regRightChnnAcres+' Acres</b></td><td  style="color:blue"><b>Other Ayacut:'+obj[0].regOthAcres+' Acres</b></td></tr>' +
'<tr ><td style="color:blue"><b>If due to rain fall</b></td><td  style="color:blue"><b>Name of nearest Rain Gauge Station.: '+obj[0].rainRGStation+'</b></td><td  style="color:blue"><b>Quantity of Rain fall : '+obj[0].rainQty+' </b></td><td  style="color:blue"><b>Date :'+obj[0].rainDate+' </b></td></tr>' +
	                                
'<tr ><td style="color:blue"><b>Incase of buldings, if the damages are due to cyclone or fire accidents</b></td><td  style="color:blue"><b>a) Name of Quarter : '+obj[0].quartName+'</b></td><td  style="color:blue"><b>b) Quarter Type  : '+obj[0].quartType+' </b></td><td  style="color:blue"><b>c) Residential or Non Residential :'+obj[0].bldgTypeName+' </b></td><td  style="color:blue"><b>d) Description of damage  :'+obj[0].bldgDescDamage+' </b></td></tr>'+
'<tr ><td ><b>Approximate estimate for Repairs or Reconstruction</b></td><td  ><b> Temporary Measure : '+obj[0].approxRepTemp+'</b></td><td  ><b>Permanent Repairs  : '+obj[0].approxRepPermanent+' </b></td></tr>'+
'<tr><td><b>Book value </b></td><td><b>'+obj[0].frmBookValue+'</b></td></tr>' +
'<tr><td><b>Ayacut effected </b></td><td><b>acres </b></td><td><b>'+obj[0].effAyacutAcres+' Acres</b></td> <td><b>value  </b></td><td><b>'+obj[0].effAyacutValue+'  </b></td></tr>' +
'<tr><td><b>Whether action is being taken to protect the standing crops: Proposed for Temporary restoration </b></td><td><b>'+obj[0].actionStdCrops+'</b></td></tr>' +
'<tr><td><b>Indicate Whether the damages due to breaches. Scours washed off and silted up </b></td><td><b>'+obj[0].damageBreaches+'</b></td></tr>' +
'<tr><td><b>Any useful information/Remarks </b></td><td><b>'+obj[0].usefulRemarks+'</b></td></tr>' +
'<tr><td><b>Any useful information/Remarks </b></td><td><b>'+obj[0].usefulRemarks+'</b></td></tr>' +
'<tr><td><b>TSFC Form 20 sent date to Accountant General </b></td><td><b>'+obj[0].tsfcFormDate+'</b></td></tr>' 
						 
						  
						  );   

	          	   j++;
			
	      },
	      error : function(){
	    	  alert(error);
	      }
	  });	
	
	//alert("completed");
	
	$.ajax({	          
	      url: "../invtsimis/get-frm-datail?formDataId="+formdataId,
	      type: "GET",
	      async:false,
	     
		    contentType: "application/json; charset=utf-8",
	      success: function (response) {
	    	// alert(response);
	    	  
	    	//  console.log(response);
	    	
	    	
	    	  var j=1;
	    	  
	    	 
			 
			
					var obj = JSON.parse(response);
				
					 for(i in obj){	
						// alert("kal here"+i);
						  $('#viewfrm20 table tbody').append( 
								  '<tr >'+
								  '<td style="color:blue"><b>'+j+')  '+obj[i].irrSrcName+'</b></td>'+
	                                
	                              
								  '<td><b> Chainage (from)  : '+obj[i].irrChFrm+'</b></td>'+
								  '<td><b> Chainage(to)  : '+obj[i].irrChTo+' </b></td>'+
								  '<td><b>Measurement L.B. or Depth (to) :'+obj[i].irrL+'-'+obj[i].irrB+'-'+obj[i].irrD+' </b></td>'+
								  '<td><b>Permanent Measure(Rs)  :'+obj[i].irrPermcost+' </b></td>'+
								  '<td><b>Temporary Measure(Rs)  :'+obj[i].irrTempcost+' </b></td>'+
								 
								
								  '</tr>'                     
	                                         
						  );   

	          	   j++;
	          	   
					 }
			
	      },
	      error : function(){
	    	  alert(error);
	      }
	  });	
	

}*/


/*function editfrmdatafn(formdataId){
	
	$("#formDataId").val(0);
	$("#regLeftChnnAcres").val('0.00');
	$("#regRightChnnAcres").val('0.00');
	$("#regOthAcres").val('0.00');
	
	$("#rainRGStation").val("");
	$("#rainQty").val('0.00');
	$("#rainDate").val(0);
	
	$("#quartName").val("");
	$("#quartType").val("");
	$("#bldgTypeName").val("");
	$("#bldgDescDamage").val("");
	$("#approxRepTemp").val('0.00');
	
	$("#approxRepPermanent").val('0.00');
	
	$("#frmBookValue").val('0.00');
	$("#effAyacutAcres").val('0.00');
	$("#effAyacutValue").val('0.00');
	$("#actionStdCrops").val("");
	$("#damageBreaches").val("");
	$("#usefulRemarks").val("");
	$("#tsfcFormDate").val(0);
	
	$("#damageDate").val(0);
	$("#damageTime").val("0.00");
	$("#damageCause").val("");
	$("#frmProposed").val("	");
	$("#writeOffValue").val('0.00');
	$("#writeOffAction").val("");				
	$("#regchkid").prop('checked', false);
	$("#rainchkid").prop('checked', false);
	$("#bldchkid").prop('checked', false);
	$("#bldchkid").prop('checked', false);
	
	$("#bldchkid").prop('checked', false);
	
	$("#damageType").val(0);
	$('#damageType').multiselect('rebuild');
	
	for(var i=0; i<9 ; i++){
		var anchk="#anichkid"+i ;
		$(anchk).prop('checked', false);
		
		}
	
	chkshowdata();
	
	$("#addmichecks8").text( 'Submit');
	$(".updatepht").show();
	

	$.ajax({	          
	      url: "../invtsimis/get-frm-data?formDataId="+formdataId,
	      type: "GET",
	      async:false,
	     
		    contentType: "application/json; charset=utf-8",
	      success: function (response) {
	    	
	    	  var j=1;
	    	  
				var obj = JSON.parse(response);
				
				$("#formDataId").val(obj[0].formDataId);
				$("#damageDate").val(obj[0].damageDate);
				$("#damageTime").val(obj[0].damageTime);
				$("#damageCause").val(obj[0].damageCause);
				$("#frmProposed").val(obj[0].frmProposed);
				if(obj[0].writeOffValue>0){
				$("#writeOffValue").val(obj[0].writeOffValue);
				}else{
					
					$("#writeOffValue").val('0.00');
				}
				$("#writeOffAction").val(obj[0].writeOffAction);				
				$("#regchkid").prop('checked', true);
				$("#rainchkid").prop('checked', true);
				$("#bldchkid").prop('checked', true);
				$("#bldchkid").prop('checked', true);
				
				$("#bldchkid").prop('checked', true);
				
				$("#damageType").val(obj[0].damageType);
				
				$('#damageType').multiselect('rebuild');
				
				
				for(var i=0; i<9 ; i++){
				var anchk="#anichkid"+i ;
				$(anchk).prop('checked', true);
				
				}
			
				chkshowdata();
				
			
				
				if(obj[0].regLeftChnnAcres>0){
				
				$("#regLeftChnnAcres").val(obj[0].regLeftChnnAcres);
				}else{
					
					$("#regLeftChnnAcres").val('0.00');
					
				}
				if(obj[0].regRightChnnAcres>0){
				$("#regRightChnnAcres").val(obj[0].regRightChnnAcres);
				}else{
					
					$("#regRightChnnAcres").val('0.00');
					
				}
				if(obj[0].regOthAcres>0){
				$("#regOthAcres").val(obj[0].regOthAcres);
                }else{
					
					$("#regOthAcres").val('0.00');
					
				}
				$("#rainRGStation").val(obj[0].rainRGStation);
				if(obj[0].rainQty>0){
				$("#rainQty").val(obj[0].rainQty);
                     }else{
					
					$("#rainQty").val('0.00');
					
				}
				$("#rainDate").val(obj[0].rainDate);
				
				
				$("#quartName").val(obj[0].quartName);
				$("#quartType").val(obj[0].quartType);
				$("#bldgTypeName").val(obj[0].bldgTypeName);
				$("#bldgDescDamage").val(obj[0].bldgDescDamage);
				if(obj[0].approxRepTemp>0){
				$("#approxRepTemp").val(obj[0].approxRepTemp);
				}else{
					$("#approxRepTemp").val('0.00');
					
				}
				if(obj[0].approxRepPermanent>0){
				$("#approxRepPermanent").val(obj[0].approxRepPermanent);
				}else {
					$("#approxRepPermanent").val('0.00');
					
				}
				if(obj[0].approxRepPermanent>0){
				$("#frmBookValue").val(obj[0].frmBookValue);
				}else{
					$("#frmBookValue").val('0.00');
					
				}
				if(obj[0].effAyacutAcres>0){
				$("#effAyacutAcres").val(obj[0].effAyacutAcres);
				}else {
					$("#effAyacutAcres").val('0.00');
					
				}
				if(obj[0].effAyacutValue>0){
				$("#effAyacutValue").val(obj[0].effAyacutValue);
				}else{
					$("#effAyacutValue").val('0.00');
					
				}
				$("#actionStdCrops").val(obj[0].actionStdCrops);
				$("#damageBreaches").val(obj[0].damageBreaches);
				$("#usefulRemarks").val(obj[0].usefulRemarks);
				$("#tsfcFormDate").val(obj[0].tsfcFormDate);
				
			
	      },
	      error : function(){
	    	  alert(error);
	      }
	  });	
	
	//alert("completed");
	
	
	 for(var h=1; h<9; h++){
		 
			// alert(t+"t");
		 
		 m=h-1;
		 
		 var irrchfrom="#irrChFrm"+m;
		 var irrchto="#irrChTo"+m;
		 var irrl="#irrL"+m;
		 var irrb="#irrB"+m;
		 var irrd="#irrD"+m;
		 var irrpcost="#irrPermcost"+m;
		 var irrtcost="#irrTempcost"+m;
		 var frmdetailId="#formDetailId"+m;
		 
		// alert("m"+m);
		 
		// $(irrsrcname).val(obj[i].irrSrcName);
		 $(irrchfrom).val('0.00');
		 $(irrchto).val('0.00');
		 $(irrl).val('0.00');
		 $(irrb).val('0.00');
		 $(irrd).val('0.00');
		 $(irrpcost).val('0.00');
		 $(irrtcost).val('0.00');
		 $(frmdetailId).val(0);
			 
		
		 }
		 
		// var irrsrcname="#irrSrcName"+m;
		
	
	$.ajax({	          
	      url: "../invtsimis/get-frm-datail?formDataId="+formdataId,
	      type: "GET",
	      async:false,
	     
		    contentType: "application/json; charset=utf-8",
	      success: function (response) {
	    	// alert(response);
	    	  
	    	//  console.log(response);
	    	
	    	
	    	  var j=1;
	    	  
	    	 
			 
			
					var obj = JSON.parse(response);
					
					var k=1;
				
					 for(i in obj){	
						 
						
						 
						 for(var t=1; t<9; t++){
							 
							// alert(t+"t");
						 
						 if(obj[i].irrSrcId==t){
							 
						 m=t-1;
						 }
						 
						 }
						 
						// var irrsrcname="#irrSrcName"+m;
						 var irrchfrom="#irrChFrm"+m;
						 var irrchto="#irrChTo"+m;
						 var irrl="#irrL"+m;
						 var irrb="#irrB"+m;
						 var irrd="#irrD"+m;
						 var irrpcost="#irrPermcost"+m;
						 var irrtcost="#irrTempcost"+m;
						 
						 var frmdetailId="#formDetailId"+m;
						 
						// alert("m"+m);
						 
						// $(irrsrcname).val(obj[i].irrSrcName);
						 if(obj[i].irrChFrm>0){
						 $(irrchfrom).val(obj[i].irrChFrm);
						 }else{
							 
							 $(irrchfrom).val('0.00');
						 }
						 if(obj[i].irrChTo>0){
						 $(irrchto).val(obj[i].irrChTo);
						 }else{
							 
							 $(irrchto).val('0.00');
						 }
						 if(obj[i].irrL>0){
						 $(irrl).val(obj[i].irrL);
						 }else {
							 $(irrl).val('0.00');
							 
						 }
						 if(obj[i].irrB>0){
						 $(irrb).val(obj[i].irrB);
						 }else{
							 
							 $(irrb).val('0.00');
						 }
						 if(obj[i].irrD>0){
						 $(irrd).val(obj[i].irrD);
						 }else{
							 $(irrd).val('0.00');
							 
						 }
						 if(obj[i].irrPermcost>0){
						 $(irrpcost).val(obj[i].irrPermcost);
						 }else{
							 $(irrpcost).val('0.00');
							 
						 }
						 if(obj[i].irrTempcost>0){
						 $(irrtcost).val(obj[i].irrTempcost);
						 }else{
							 $(irrtcost).val('0.00');
							 
						 }
						 
						// alert("alert"+obj[i].formDetailId);
						 if(obj[i].formDetailId>0){
						 $(frmdetailId).val(obj[i].formDetailId);
						 }else{
							 
							 $(frmdetailId).val(0);
							 
						 }
						 
					
						
	          	   j++;
	          	   
					 }
			
	      },
	      error : function(){
	    	  alert(error);
	      }
	  });	
	
	$("#addmichecks8").text( 'Edit');
	$(".updatepht").hide();

}*/

/*function chkshowdata(){
	
	var regchk = $('#regchkid').prop('checked');
	
	if(regchk) {
		
		$('#flreg').show();
	}else{
		
		$('#flreg').hide()
	}
	
		
	var rainchk = $('#rainchkid').prop('checked');
	
		if(rainchk) {
			
			$('#flrain').show();
		}else{
			
			$('#flrain').hide()
		}

		
		var bldchk = $('#bldchkid').prop('checked');
	
		if(bldchk) {
			
			$('#flbld').show();
		}else{
			
			$('#flbld').hide()
		}
	
		
		var anchk = $('#anichkid1').prop('checked');
	
		if(anchk) {
			
			$('#flani1').show();
		}else{
			
			$('#flani1').hide()
		}
	
		
		var wrchk = $('#anichkid2').prop('checked');
		
	
		if(wrchk) {
			
			$('#flani2').show();
		}else{
			
			$('#flani2').hide()
		}
	
		
		var slchk = $('#anichkid3').prop('checked');
	
		if(slchk) {
			
			$('#flani3').show();
		}else{
			
			$('#flani3').hide()
		}
	
		
		var retchk = $('#anichkid4').prop('checked');
	
		if(retchk) {
			
			$('#flani4').show();
		}else{
			
			$('#flani4').hide()
		}
	
		
		var aprchk = $('#anichkid5').prop('checked');
	
		if(aprchk) {
			
			$('#flani5').show();
		}else{
			
			$('#flani5').hide()
		}
	
		
		var tkchk = $('#anichkid6').prop('checked');
	
		if(tkchk) {
			
			$('#flani6').show();
		}else{
			
			$('#flani6').hide()
		}

		var chchk = $('#anichkid7').prop('checked');
	
		if(chchk) {
			
			$('#flani7').show();
		}else{
			
			$('#flani7').hide()
		}
	
		
		var otchk = $('#anichkid8').prop('checked');
	
		if(otchk) {
			
			$('#flani8').show();
		}else{
			
			$('#flani8').hide()
		}
}*/


/*function editformdata(frmname){
	//alert("frmname"+frmname);
	
  var subbutton=	$("#addmichecks8").text();
  
  if(subbutton=='Edit'){
	  
	  var valid = "Are you sure you want to update form 20?";
	  
	  if (confirm(valid)) {

	 var customformid="#"+frmname;
	 
	// alert("i am in edit");
	 
	 var m =$('#damageType').val();
	 
	// alert("damageType"+m);
	 
	 $('#formPhotosnew').removeAttr( "required" )
		
			var tankId=$("#tankId").val();
			
	//		var m=$('#inspectDateinflows').val();
	//		alert("inspectDateinflows" + m);
		var nextemp=$("#nextEmpId").val();
		
		 $('#action_alert').empty();
		 
		// $('form[name='+frmname+']').serialize(),
		 
		 var form = $("#michecks8").closest("form");
		 var formData = new FormData(form[0]);
		 
		// console.log("formData"+formData);
		 if ( $('form[id=michecks8]').parsley().isValid() ) {	
		  // var formData = new FormData(document.getElementsByName(frmname));  enctype: 'multipart/form-data',
	 	 $.ajax({	          
		      url: "../invtsimis/editFormData",
		      method:"POST",
		      async: false,
		      data:  formData,
		    
              contentType: false,
              processData: false,
		      
		       
		     
			 
		      success: function (response) {
		   
		    	//alert("kal"+response);
		    	 
		    	 if(response>0){
		    		 
		    	//	alert("i am in kal Data inserttedd Successfully");
		
			  $('#action_alert').html('<p style="margin: 0px !important;">Data Updated Successfully</p>');
				$("html,body").animate({scrollTop:$('#action_alert').offset().top-175}, 500);
				
				  $('#flreg').hide();
				  $('#flrain').hide();
				  
				  $('#flbld').hide();
				  
				  for(var i=1 ; i<10; i++){
					  
					  var str="#flani"+i;
					  
					  $(str).hide();
				  }
				  
				  $("#damageType").val(0);
				  $('#damageType').multiselect('rebuild');
				 
			    }
				
				if(response==0||response==null){
			    	
			    	  $('#action_alert').html('<p style="margin: 0px !important;">Failed to Update data</p>');
			    		$("html,body").animate({scrollTop:$('#action_alert').offset().top-175}, 500);
			    }
				
				 $(customformid).trigger("reset"); 	
				
  },
		      
		      error : function(){
		    	 alert(error);
		    
		      }

		  
		  });   
	 	 
		 }else{
			  
			 
				
				$('form[id=michecks8]').parsley().validate();
				//alert("kal4");
			
	  }
		 return true;
	  }
      else{
      	
      	return false;
        
      }
	 	 
  }
  

	
}*/

/*function editphotosdatafn(formdataId){
	
	 
	
	 $('#frm20_doc_update').dialog('option', 'title', 'Update Photos');
	  $('#frm20_doc_update').dialog('open');
	  
	  
	  $('#action_alert').empty();
		 
		 $("#editformdataId").val(formdataId);
	  
	

	
	
}*/


/*function updatephotosdatafn(formname){
	
//	alert("form name "+fromname);
	  $('#action_alert').empty();
	
  var customformid="#editdoc9";
	  
	  var form = $("#editdoc9").closest("form");
		 var formData = new FormData(form[0]);
		 var valid = "Are you sure you want to submit?";
		  if (confirm(valid)) { 
		 
		  if ( $('form[name='+formname+']').parsley().isValid() ) {	
			
	  $.ajax({	          
	      url: "../invtsimis/updatephotos",
	      method:"POST",
	      async: false,
	      data:  formData,
	    
          contentType: false,
          processData: false,
	      success: function (response) {
	    	  
	    	  if(response>0){
		    		 
			    	//	alert("i am in kal Data inserttedd Successfully");
			
				  $('#action_alert').html('<p style="margin: 0px !important;">Photos updated Successfully</p>');
				  $('#frm20_doc_update').dialog('close'); 
					$("html,body").animate({scrollTop:$('#action_alert').offset().top-175}, 500);
					
					
					 
				    }
					
					if(response==0||response==null){
				    	
				    	  $('#action_alert').html('<p style="margin: 0px !important;">Failed to Update data</p>');
				    		$("html,body").animate({scrollTop:$('#action_alert').offset().top-175}, 500);
				    }
					
					 $(customformid).trigger("reset"); 	
					
	      },
	      error : function(){
	    	  alert(error);
	      }
	  });
	  
		  }else{
			  
				 
				
				$('form[name='+formname+']').parsley().validate();
				//alert("kal4");
			
	  }
			  return true;
			  
		  }
	       else{
	       	
	       	return false;
	         
	       }
}*/


/*function deletefrmphtfn(formdataId){
	
	
	 $('#frm20_doc_dia').dialog('option', 'title', 'View/ Delete Photos');
	  $('#frm20_doc_dia').dialog('open');
	  
	  
	  $('#action_alert').empty();
	  
	  
		$("#doc-thead10").empty();
		$("#doc-tbody10").empty();
	
	

		$.ajax({	          
		      url: "../invtsimis/get-frm-docs?formDataId="+formdataId,
		      type: "GET",
		      success: function (response) {
		    	  
		    	
		    	
		    	  var j=1;
		    	  
		    	  $('#docfrm20 table thead').append( '<tr style="font-size: 18px; color: gray; font-weight: bold;"><th>Sl.No</th>'+
		    	    		
		    	    		'<th>File Name</th>'+
		    	    	
		    	    		'  <th>Latest</th>'+
		    	    		'  <th>Download File</th>'+
		    	    		
		    	    		' <th>Delete </th>'+
		    	    		
		    	    		
		    	    		'</tr>'); 	 
				 
				
						var obj = JSON.parse(response);
						$.each(obj, function(key, value) {
							
							
							  $('#docfrm20 table tbody').append(  '<tr style="font-size: 16px">' +
		                                '<td style="text-align: center;">'+j+'</td>' +
		                                
		                                '<td><b>'+value.formDocOriginalName+'</b></td>' +
		                               
		                                '<td style="color:blue"><b><a target="_blank" href="../uploadedFiles/FormDocs/'+value.formDocName+'" ><u>Download File<u></a></b></td>' +
		                                
		                               
		                             
		                                '<td><b>'+obj[i].latestRemarks+'</b></td>' +
		                                '<td><b><button type="button" name="deletedoc" id="deletedoc'+j+'" class="btn btn-1 btn-primary center-block docview"  onclick="deletedocfn('+value.formdocId+','+formdataId+')"  >Delete File</button> </b></td>' +
		                               	                               
		                               
		                                '</tr>');
						
							   j++;
							  
							 
						});

		      },
		      error : function(){
		    	  alert(error);
		      }
		  });	
		
	
}*/

/*function deletedocfn(formdocId,formdataId){
	
	 $('#action_alert').empty();
	 var valid = "Are you sure you want to delete document?";
	 if (confirm(valid)) {
	 $.ajax({	          
	      url: "../invtsimis/del-frm-docs?formdocId="+formdocId,
	      method:"POST",
	      async: false,    
        
	      success: function (response) {
	    	  
	    	  if(response>0){
		    		 
			    	//	alert("i am in kal Data inserttedd Successfully");
	    		  
	    		  deletefrmphtfn(formdataId);
			
				  $('#action_alert').html('<p style="margin: 0px !important;">Photos Deleted Successfully</p>');
				
					$("html,body").animate({scrollTop:$('#action_alert').offset().top-175}, 500);
					
					
					 
				    }
					
					if(response==0||response==null){
				    	
				    	  $('#action_alert').html('<p style="margin: 0px !important;">Failed to Delete Photo</p>');
				    		$("html,body").animate({scrollTop:$('#action_alert').offset().top-175}, 500);
				    }
					
					 $(customformid).trigger("reset"); 	
					
	      },
	      error : function(){
	    	  alert(error);
	      }
	  });	
	 
	 return true;  
	
	 }
     else{
     	
     	return false;
       
     }
	
}*/


/*function deletefrmdatafn(formdataId,tankId){
	
	 $('#action_alert').empty();
	 
	 var valid = "Are you sure you want to delete form 20?";
	   if (confirm(valid)) {
	 $.ajax({	          
	      url: "../invtsimis/del-frm-data?formDataId="+formdataId,
	      method:"POST",
	      async: false,    
       
	      success: function (response) {
	    	  
	    	  if(response>0){
		    		 
			    	//	alert("i am in kal Data inserttedd Successfully");
			
				  $('#action_alert').html('<p style="margin: 0px !important;">Form 20 Deleted Successfully</p>');
				
					$("html,body").animate({scrollTop:$('#action_alert').offset().top-175}, 500);
					
					getfrmsentlist(tankId)
					 
				    }
					
					if(response==0||response==null){
				    	
				    	  $('#action_alert').html('<p style="margin: 0px !important;">Failed to Delete Form 20</p>');
				    		$("html,body").animate({scrollTop:$('#action_alert').offset().top-175}, 500);
				    }
					
					 $(customformid).trigger("reset"); 	
					
	      },
	      error : function(){
	    	  alert(error);
	      }
	  });	
	
	 return true;  
     
       }
       else{
       	
       	return false;
         
       }
	
}*/

/*$(function() {
window.Parsley.addValidator('maxFileSize', {
	  validateString: function(_value, maxSize, parsleyInstance) {
	     if (!window.FormData) {
	      alert('formdata');
	      return true;
	    } 
	    var files = parsleyInstance.$element[0].files;
	    //alert("files.length "+files.length );
	    var imageSizeArr = 0;
	    var totalfilesize=0;
	   var  mxfilesize= maxSize * 1024;
	    for (var i = 0; i < files.length; i++){
	        var imageSize = files[i].size;
	     
	      //  alert("imageSize"+imageSize);
	      //  alert("maxSize"+maxSize);
	      
	         totalfilesize=totalfilesize+imageSize;
	         
	       //  alert("mxfilesize"+mxfilesize);
		        
		       // alert("totalfilesize"+totalfilesize);
	        
	        if (totalfilesize > mxfilesize ){
	        	//alert("kal"+i);
	        	imageSizeArr = 1;
	        }
	    }
	    return  totalfilesize <= maxSize * 1024;
	  },
	  requirementType: 'integer',
	  messages: {
	    en: 'Total files should not be larger than %s Kb',
	   
	  }
	});


window.ParsleyValidator
.addValidator('fileextension', function (value, requirement) {
		var tagslistarr = requirement.split(',');
  var fileExtension = value.split('.').pop();
				var arr=[];
				$.each(tagslistarr,function(i,val){
					 arr.push(val);
				});
  if(jQuery.inArray(fileExtension, arr)!='-1') {
    console.log("is in array");
    return true;
  } else {
    console.log("is NOT in array");
    return false;
  }
}, 32)
.addMessage('en', 'fileextension', 'The file should be ,.jpeg,.jpg,.png');



	
});*/

//form 20 functions end




