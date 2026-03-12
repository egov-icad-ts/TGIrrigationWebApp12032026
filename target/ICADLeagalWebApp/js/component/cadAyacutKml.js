




$(document).ready(function(){
	
	// $('.resinf').hide(); 
		
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




/*function openreservoir(count){
	
	//alert("count"+count)
	
	 $('.resinf').hide(); 
	var resdatanew="#resdata"+count;
	
	//alert("resdatanew"+resdatanew);
	
	 $(resdatanew).show(); 
	
	
}*/



function updatekmldatafn(formId){
	
	//alert("kal1");
	
	  var formId = formId		
		 
		 var customformid="#"+formId;

		
		$('#action_alert').empty();
		
		  var form = $(customformid).closest("form");
			 var formData = new FormData(form[0]);


		 var valid = "Are you sure you want to submit?";
		  if (confirm(valid)) { 
			  
			  
			//  alert("kal2");
				
				
					if ($('form[id='+formId+']').parsley()
							.isValid()) {	
						
						//alert("kal3");
				    $.ajax({	          
				url: "../comptsimis/updatekmlFiles" ,
				method:"POST",
				dataType: 'json',

				async: false,
				 data:  formData,
				    
		          contentType: false,
		          processData: false,
				success: function (response) {

					  
					  console.log(response);
					
					if(response>0){
					  
					  $(customformid).trigger("reset"); 
					  
					 

					  $('#action_alert').html('<p style="margin: 0px !important;">Data Inserted Successfully</p>');
					  $("html,body").animate({scrollTop:0}, 500);
					  
					  window.location.reload();
					  
					 // getActionStatusDetails( );
					  
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
						
		 
		 
			  return true;
			  
		  }
	       else{
	       	
	       	return false;
	         
	       }
}












function deletekmlfile(kmlId){
	
	//alert("mapId"+mapId);
	
	
	var cadkmlId = kmlId		
	 
	
	
	
	  $.ajax({	          
	      url: "../comptsimis/cad-kml-docs",
	      type: "POST",
	      data: {cadkmlId :  cadkmlId,
	    	 
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

$(function() {
	
	window.Parsley.addValidator('maxFileSize', {
		  validateString: function(_value, maxSize, parsleyInstance) {
		   /*  if (!window.FormData) {
		      alert('formdata');
		      return true;
		    } */
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
	.addMessage('en', 'fileextension', 'The file should be ,.kml,.KML');
	
});