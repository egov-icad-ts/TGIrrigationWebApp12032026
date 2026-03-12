function gettCircles(){
	//alert("kal");
	//var districtId=document.getElementById("districtId").value;
	
	$('#tcircleId').multiselect('rebuild');
	var unitId=document.getElementById("tunitId").value;
	//alert(mandalId);

	  $.ajax({	          
      url: "../task/getCircles?unitId="+unitId,
      type: "GET",
      success: function (response) {
    //	alert(response);
    
    	  var $select = $('#tcircleId');
    	 
		  $select.find('option').remove();
		 // alert("kal1");
		  
		  var obj = JSON.parse(response);
		 // alert("kal2");
		 
		
		  $('#tcircleId').append( '<option value="0"> --select--</option>' );
				
				 
				  
				$.each(obj, function(key, value) {
					
						$('#tcircleId').append( '<option value="'+value.circleId+'" > '+value.circleName+'</option>' );
				
						$('#tcircleId').multiselect('rebuild');
				});
    	 

      },
      error : function(){
    	  alert(error);
      }
  }); 	
}


function gettDivisions(){
	//alert("kal");
	//var districtId=document.getElementById("districtId").value;
	var circleId=document.getElementById("tcircleId").value;
	//alert(mandalId);

	  $.ajax({	          
      url: "../web/getDivisions?circleId="+circleId,
      type: "GET",
      success: function (response) {
    	
    	
    	
    	  var $select = $('#tdivisionId');
    	 
		  $select.find('option').remove();
		  
		  var obj = JSON.parse(response);
		
		 
				
				  $('#tdivisionId').append( '<option value="0"> --select--</option>' );
				  
				$.each(obj, function(key, value) {
					
						$('#tdivisionId').append( '<option value="'+value.divisionId+'" > '+value.divisionName+'</option>' );
				
  	  				$('#tdivisionId').multiselect('rebuild');
				});
    	 

      },
      error : function(){
    	  alert(error);
      }
  }); 	
}


function gettSubDivisions(){
	//alert("kal");
	//var districtId=document.getElementById("districtId").value;
	var divisionId=document.getElementById("tdivisionId").value;
	//alert(mandalId);

	  $.ajax({	          
      url: "../web/getSubDivisions?divisionId="+divisionId,
      type: "GET",
      success: function (response) {
    	
    	
    	
    	  var $select = $('#tsubdivisionId');
    	 
		  $select.find('option').remove();
		  
		 
		
		 
				var obj = JSON.parse(response);
				  $('#tsubdivisionId').append( '<option value="0"> --select--</option>' );
				  
				$.each(obj, function(key, value) {
					
						$('#tsubdivisionId').append( '<option value="'+value.subdivisionId+'" > '+value.subdivisionName+'</option>' );
				
  	  				$('#tsubdivisionId').multiselect('rebuild');
				});
    	 

      },
      error : function(){
    	  alert(error);
      }
  }); 	
}






var rowCount = 0



function removeRow(removeNum) {
	jQuery('#rowCount' + removeNum).remove();
}
	
	
function clicked(){
	
	$("#parasAction").attr('required', '');
	$("#editparasAction").attr('required', '');
	 $('#replyAction').attr('required', '');
	 
	for ( instance in CKEDITOR.instances ){
		
		CKEDITOR.instances[instance].getData();
	//alert("ckeditor values : " + CKEDITOR.instances[instance].getData());
	

	}
	}


$(document).ready(function(){
	
	
	 $('#viewsubParaid3').hide();
	
	
	 
	  var d = new Date();
	  var e=new Date();
	 e= e.getFullYear() - 39;
	  var j=00;
    for (var i = 40; i >= 0; i--) {
  	 // alert(i);
        var option = "<option value=" + parseInt(d.getFullYear() - i) +"-"+e+ ">" + parseInt(d.getFullYear() - i) +"-"+e+ "</option>"
       // alert(option);
        
        $('[id*=financialYear]').append(option);
        e++;
       // j++;
    }
    
    var paraval=parseInt($('#paraId2').val());
    if(paraval==0){
    	$('#act-alert').html('<p style="margin: 0px !important; color:red">Please select para!.</p>');
    	$("#paraStatusId2 option").attr('disabled','disabled');
    	$('#paraStatusId2').multiselect('rebuild');
    	
    }else {
    	$('#act-alert').empty();
    	$("#paraStatusId2 option").removeAttr('disabled'); //enable
    	$('#paraStatusId2').multiselect('rebuild');
    }
    
    var paraval2=parseInt($('#paraId3').val());
    var subvar2=parseInt($('#subParaId3').val());
    
    if((paraval2==0 && subvar2==0)||  (paraval2!=0 || subvar2==0)){
    	$('#act-alertrep').empty();
    	if((paraval2==0 && subvar2==0)){
    	$('#act-alertrep').html('<p style="margin: 0px !important; color:red">Please Select para!  and Sub Para!.</p>');
    	$("#reply").attr('disabled','disabled');
    	}
    	
    	if((paraval2!=0 &&  subvar2==0)){
        	$('#act-alertrep').html('<p style="margin: 0px !important; color:red">Please Select  Sub Para!.</p>');
        	$("#reply").attr('disabled','disabled');
        	}
    
    	
    	
    	
    	
    }else {
    	$('#act-alertrep').empty();
    	$("#reply").removeAttr('disabled'); //enable
    	
    }
    
    var paraval3=parseInt($('#paraId4').val());
    var subvar3=parseInt($('#subParaId4').val());
    
    if((paraval3==0 && subvar3==0)||  (paraval3!=0 || subvar3==0)){
    	$('#act-alertdoc').empty();
    	if((paraval2==0 && subvar2==0)){
    	$('#act-alertdoc').html('<p style="margin: 0px !important; color:red">Please Select para!  and Sub Para!.</p>');
    	}
    	
    	if((paraval2!=0 &&  subvar2==0)){
        	$('#act-alertdoc').html('<p style="margin: 0px !important; color:red">Please Select  Sub Para!.</p>');
        	}
    	$("#para4").attr('disabled','disabled');
    	
    	
    }else {
    	$('#act-alertdoc').empty();
    	$("#para4").removeAttr('disabled'); //enable
    	
    }
    
    var paraval4=parseInt($('#paraId5').val());
   
    
    if(paraval4==0){
    	$('#act-alerttr').empty();
    	
        	$('#act-alerttr').html('<p style="margin: 0px !important; color:red">Please Select  Para!.</p>');
        	
    	$("#para5").attr('disabled','disabled');
    	
    	
    }else {
    	$('#act-alertdoc').empty();
    	$("#para5").removeAttr('disabled'); //enable
    	
    }
    
   
    
    
    
    $('#caounitId').multiselect({
		 
		 enableCaseInsensitiveFiltering: true
		 
	});

	$('#caocircleId').multiselect({
		 
		 enableCaseInsensitiveFiltering: true
		 
	});

	$('#caodivisionId').multiselect({
		 
		 enableCaseInsensitiveFiltering: true
		 
	});
	
	
	$('#caoyear').multiselect({
		 
		 enableCaseInsensitiveFiltering: true
		 
	});
	
	
     
    
    $('#year2').multiselect({
		 
		 enableCaseInsensitiveFiltering: true
		 
	});
    
    $('#year4').multiselect({
		 
		 enableCaseInsensitiveFiltering: true
		 
	});
    
    $('#year3').multiselect({
		 
		 enableCaseInsensitiveFiltering: true
		 
	});
    
    $('#year5').multiselect({
		 
		 enableCaseInsensitiveFiltering: true
		 
	});
    
    
    $('#tunitId').multiselect({
		 
		 enableCaseInsensitiveFiltering: true
		 
	});
    
    $('#tcircleId').multiselect({
		 
		 enableCaseInsensitiveFiltering: true
		 
	});
    
    $('#tdivisionId').multiselect({
		 
		 enableCaseInsensitiveFiltering: true
		 
	});
    
    $('#tsubdivisionId').multiselect({
		 
		 enableCaseInsensitiveFiltering: true
		 
	});
	
	
	$('#financialYear').multiselect({
		 
		 enableCaseInsensitiveFiltering: true
		 
	});
	
	$('#paraStatusId2').multiselect({
		 
		 enableCaseInsensitiveFiltering: true
		 
	});

	
	


	$('#sectionId').multiselect({
		 
		 enableCaseInsensitiveFiltering: true
		 
	});
	
	$('#categoryId').multiselect({
		 
		 enableCaseInsensitiveFiltering: true
		 
	});
	
	$('#paraNumber').multiselect({
		 
		 enableCaseInsensitiveFiltering: true
		 
	});
	
	$('#paraStatusId').multiselect({
		 
		 enableCaseInsensitiveFiltering: true
		 
	});
	
	$('#subcategory').multiselect({
		 
		 enableCaseInsensitiveFiltering: true
		 
	});
	
	
	
	
	
	
	

	}); 



$(function() {
	
	$("#auditDateFrom").datepicker({
		changeYear : true,
		changeMonth : true,
		dateFormat : "dd/mm/yy",
	/*  onSelect: function(selected) {
	   $("#month").datepicker("option","minDate", selected)
	 } */
	});
	
	$("#auditDateTo").datepicker({
		changeYear : true,
		changeMonth : true,
		dateFormat : "dd/mm/yy",
	/*  onSelect: function(selected) {
	   $("#month").datepicker("option","minDate", selected)
	 } */
	});
	
	$(".datepick").datepicker({
		changeYear : true,
		changeMonth : true,
		dateFormat : "dd/mm/yy",
	/*  onSelect: function(selected) {
	   $("#month").datepicker("option","minDate", selected)
	 } */
	});
	
	$.fn.rowCount = function() {
	    return $('tr', $(this).find('tbody')).length;
	};
	
	
	 $('input:radio[name=transferFlag]').change(function () {
		
            if (this.value == 'true') {
            	
            	 $("#toffice").show();
            }
            if (this.value == 'false') {
            	
            	$("#toffice").hide();
            }
        });
	 
	
	 var m = $(this).find('.ckedit')
		m.ckeditor();

		//alert("coming here")
		$('.ckedit').ckeditor();
		clicked();

$( "#verticalmon" ).tabs().addClass( "ui-tabs-vertical ui-helper-clearfix" );
$( "#verticalmon li" ).removeClass( "ui-corner-top" ).addClass( "ui-corner-left" );
 
 $( "#tabs" ).tabs() ;
 

 


 $("#frequencyId").change(function() {
	  var freq = $(this).val();
	  
	  //alert(freq);
	
	});
 
/* $("#financialYear").change(function() {
	  var id = $(this).val();
	  alert(id+"id");
	 ("#finy").value=id;
			 
	 

	
	});*/
 
 

 
 $('#getgist_dialogue').dialog({
	  autoOpen:false,
	  width:1200,
	  close: function() {
		  
		
			  $(this).dialog("close");
			  }
	 });
 
 
 
 
 $('#add-sub-para').dialog({
	  autoOpen:false,
	  width:1200,
	  close: function() {
		  
		
			  $(this).dialog("close");
			  }
	 });
 
 
 $('#add-reply-para').dialog({
	  autoOpen:false,
	  width:1200,
	  close: function() {
  	 
		
			  $(this).dialog("close");
			  }
	 });
 
 
 $('#getsubpara_dialogue').dialog({
	  autoOpen:false,
	  width:1200,
	  close: function() {
		  
		
			  $(this).dialog("close");
			  }
	 });
 
 
 

 
 
 $('#view-sub-para-3-dialogue').dialog({
	  autoOpen:false,
	  width:1200,
	  close: function() {
		  
		
			  $(this).dialog("close");
			  }
	 });
 
 
 $('#view-sub-para-4-dialogue').dialog({
	  autoOpen:false,
	  width:1200,
	  close: function() {
		  
		
			  $(this).dialog("close");
			  }
	 });
 
 $('#edit-para-dialogue').dialog({
	  autoOpen:false,
	  width:1200,
	  close: function() {
		  
		
			  $(this).dialog("close");
			  }
	 });

 

 
 
 $('#viewgist_dialogue').dialog({
	  autoOpen:false,
	  width:1200,
	  close: function() {
		  
		
			  $(this).dialog("close");
			  }
	 });
 
 
 $('#edit-sub-para-dialogue').dialog({
	  autoOpen:false,
	  width:1200,
	  close: function() {
		  
		
			  $(this).dialog("close");
			  }
	 });

 
 
 
 
 $('#subdia1').click(function(){
	 $('#add-sub-para').dialog('option', 'title', 'Sub Para Info');
	  $('#add-sub-para').dialog('open');
	  
	
	 });
 
 $('#subreply2').click(function(){
	 $('#add-reply-para').dialog('option', 'title', 'Reply Info');
	  $('#add-reply-para').dialog('open');
	  
	
	 });
 
 $('#viewsubParaid3').click(function(){
	 $('#view-sub-para-3-dialogue').dialog('option', 'title', 'View Sub Para Info');
	  $('#view-sub-para-3-dialogue').dialog('open');
	 });

 $('#docsubParaid4').click(function(){
	 $('#view-sub-para-4-dialogue').dialog('option', 'title', 'View Sub Para Info');
	  $('#view-sub-para-4-dialogue').dialog('open');
	 });

 
 
 
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



$('#showgistid').click(function(){
		
	 $('#getgist_dialogue').dialog('option', 'title', 'View Gist Info');
	  $('#getgist_dialogue').dialog('open');
	  
	 
		//3ndtab
		$("#viewsubparagistinfohead").empty();
		$("#viewsubparagistinfobody").empty();
		
		  $('#para-gist-num-did').empty();
		  $('#para-inf').empty();
		  
		  $('#paraId3').val(0);
		  
		//4ndtab
			$("#doc-gist-info-head").empty();
			$("#doc-gist-info-body").empty();
			
			  $('#doc-gist-num-did').empty();
			  $('#doc-inf').empty();
			  
			  $('#paraId4').val(0);
			  
  //5th tab
			  
			  $("#t-gist-info-head").empty();
				$("#t-gist-info-body").empty();
				
				  $('#t-gist-num-did').empty();
				  $('#t-inf').empty();
				  
				  $('#paraId5').val(0);
	 
 
	 
     
	 });


$('#subparagistinfo').click(function(){
	
	

		
	 $('#getgist_dialogue').dialog('option', 'title', 'View Gist Info');
	  $('#getgist_dialogue').dialog('open');
	  //2nd tab
	  $("#viewgistinfohead").empty();
		$("#viewgistinfobody").empty();
		
		  $('#paranumdid').empty();
		  $('#viewparainf').empty();
		  
		  $('#paraId2').val(0);
		  
		//4ndtab
			$("#doc-gist-info-head").empty();
			$("#doc-gist-info-body").empty();
			
			  $('#doc-gist-num-did').empty();
			  $('#doc-inf').empty();
			  
			  $('#paraId4').val(0);
			  
  //5th tab
			  
			  $("#t-gist-info-head").empty();
				$("#t-gist-info-body").empty();
				
				  $('#t-gist-num-did').empty();
				  $('#t-inf').empty();
				  
				  $('#paraId5').val(0);
	 
	 
     
	 });


$('#docgistinfo').click(function(){
	//2nd tab
	 $('#getgist_dialogue').dialog('option', 'title', 'View Gist Info');
	  $('#getgist_dialogue').dialog('open');
	  
	  $("#viewgistinfohead").empty();
		$("#viewgistinfobody").empty();
		
		  $('#paranumdid').empty();
		  $('#viewparainf').empty();
		  
		  $('#paraId2').val(0);
		 ///3 tab
		  
		  $("#viewsubparagistinfohead").empty();
			$("#viewsubparagistinfobody").empty();
			
			  $('#para-gist-num-did').empty();
			  $('#para-inf').empty();
			  
			  $('#paraId3').val(0);
			  
			  //5th tab
			  
			  $("#t-gist-info-head").empty();
				$("#t-gist-info-body").empty();
				
				  $('#t-gist-num-did').empty();
				  $('#t-inf').empty();
				  
				  $('#paraId5').val(0);
			  
			  
	 
    
	 });


$('#tparainfo').click(function(){
	
	$('#getgist_dialogue').dialog('option', 'title', 'View Gist Info');
	  $('#getgist_dialogue').dialog('open');
	  
	  $("#viewgistinfohead").empty();
		$("#viewgistinfobody").empty();
		
		  $('#paranumdid').empty();
		  $('#viewparainf').empty();
		  
		  $('#paraId2').val(0);
	  
	  
	//3ndtab
		$("#viewsubparagistinfohead").empty();
		$("#viewsubparagistinfobody").empty();
		
		  $('#para-gist-num-did').empty();
		  $('#para-inf').empty();
		  
		  $('#paraId3').val(0);
		  
		//4ndtab
			$("#doc-gist-info-head").empty();
			$("#doc-gist-info-body").empty();
			
			  $('#doc-gist-num-did').empty();
			  $('#doc-inf').empty();
			  
			  $('#paraId4').val(0);
	  
	
	 });


$('#getsubparainfo').click(function(){
	
	 $('#getsubpara_dialogue').dialog('option', 'title', 'View Sub Para Info');
	  $('#getsubpara_dialogue').dialog('open');
	  
	
	 });

$('#docsubparainfo').click(function(){
	
	 $('#getsubpara_dialogue').dialog('option', 'title', 'View Sub Para Info');
	  $('#getsubpara_dialogue').dialog('open');
	  
	
	 });










var replycount = $('#reply-data-body tr').length;
//alert("replycount"+replycount);

$('#reply_dialog').dialog({
 autoOpen:false,
 width:800
});

$('#reply').click(function(){
 $('#reply_dialog').dialog('option', 'title', 'Add Reply Data');
 $("#replyinputform").trigger("reset");
 $('#editFlag').val(false);
 if($('#replyDate').val() != '')
 {
	  $('#replyDate').val('0') ;
  
 }

 if($('#replyAction').val() != '')
 {
	// alert("hi"); 
	 $('#replyAction').val('') ;
	 var t=$('#replyAction').val();
//	 alert("replyAction"+t);
 }
 
 
  if($('#replyRemarks').val() != ' ')
 {
	  $('#replyRemarks').val('') ;
 
 }
 
 replycount=$('#reply-data-body tr').length;
 
// alert("second reply"+replycount);
 var t=$('#replyAction').val();
// alert("replyAction"+t);
 

 $('#savereply').text('Save');
 $('#reply_dialog').dialog('open');
});

$('#savereply').click(function(){
	
	 replycount=$('#reply-data-body tr').length;
	// alert("new data"+replycount);
	 var editflag=$('#editFlag').val();
	 
	// alert("editflagfirst"+editflag);
	
	if(editflag=='false'){
		
		 
		
		
		var replyDate='0'; 
		 var replyAction='' ;
		 var replyRemarks='' ;
		 //alert("outside parsely valid");
		
		if ($('form[id=replyinputform]').parsley().isValid()) {
		//	alert("parsely valid");
			  replyDate=$('#replyDate').val();
				
			  replyAction = $('#replyAction').val();
			  replyRemarks = $('#replyRemarks').val();
			 
		
	 
  if($('#savereply').text() == 'Save')
  {
	// alert("hererply");
	  
	
   replyoutput = '<tr id="replyrow_'+replycount+'">';
   
    /* '<label class="radio-inline"> <input type="radio" name="replyDataList['+replycount+'].replylatest" id="replylatest'+replycount+'"     value="true"  required >Yes</label>' */
   replyoutput += '<td>'+replyAction+' <textarea style="display:none;" name="replyDataList['+replycount+'].replyAction" id="replyAction'+replycount+'"  >'+replyAction+'</textarea></td>';
   replyoutput += '<td>'+replyRemarks+' <textarea style="display:none;" name="replyDataList['+replycount+'].replyRemarks" id="replyRemarks'+replycount+'" class="replyRemarks"  >'+replyRemarks+'</textarea></td>';
   replyoutput += '<td>'+replyDate+'   <input type="hidden" class="replynew" name="replyDataList['+replycount+'].replyDate" id="replyDate'+replycount+'"      value="'+replyDate+'"  required ></td>';
   
   replyoutput += '<td><button type="button" name="replyview_details" class="btn btn-warning btn-xs replyview_details" id="'+replycount+'">View</button></td>';
   replyoutput += '<td><button type="button" name="replyremove_details" class="btn btn-danger btn-xs replyremove_details" id="'+replycount+'">Remove</button></td>';
   replyoutput += '</tr>';
  
   replycount = replycount + 1;
   $('#reply-data-body').append(replyoutput);
   
	
  }
  else
  {
	   
	 
   var replyrow_id = $('#replyrow_id').val();
  
     
  
   
   replyoutput = '<td>'+replyAction+' <textarea style="display:none"  name="replyDataList['+replyrow_id+'].replyAction" id="replyAction'+replyrow_id+'"  >'+replyAction+'</textarea></td>';
  
   replyoutput += '<td>'+replyRemarks+' <textarea style="display:none" name="replyDataList['+replyrow_id+'].replyRemarks" id="replyRemarks'+replyrow_id+'"  >'+replyRemarks+'</textarea></td>';
  
   replyoutput += '<td>'+replyDate+'  <input type="hidden" class="replynew" name="replyDataList['+replyrow_id+'].replyDate" id="replyDate'+replyrow_id+'"      value="'+replyDate+'"  required ></td>';

   replyoutput += '<td><button type="button" name="replyview_details" class="btn btn-warning btn-xs replyview_details" id="'+replyrow_id+'">View</button></td>';
  
   replyoutput += '<td><button type="button" name="replyremove_details" class="btn btn-danger btn-xs replyremove_details" id="'+replyrow_id+'">Remove</button></td>';
 
 
  
   $('#replyrow_'+replyrow_id+'').html(replyoutput);
  }


  
  $('#reply_dialog').dialog('close');
		}else{
       	 
       	 $('form[id=replyinputform]').parsley().validate();
       	 
        }
 
	}
	
	if(editflag=='true'){
		
		
		var paraReplyId=$("#editparaReplyId").val();
		var subParaId=$("#editsubParaId").val();
		
	//	alert("editflag2"+editflag);
		

		if ($('form[id=replyinputform]').parsley().isValid()) {
			
			var finaldatatoSend=$('form[id=replyinputform]').serialize();
			
			  $.ajax({	          
					      url: "../parastsimis/edit-reply-para-data",
					      method:"POST",
					      async: false,
					     
					      data:finaldatatoSend,
						 
					      success: function (response) {
					   
					    	//alert("kal"+response);
					    	 
					    	 if(response>0){
					    		 $('#editFlag').val(false);
					    		 
					    		  $('#reply_dialog').dialog('close');
						  $('#action_alert').html('<p style="margin: 0px !important;">Data Updated Successfully</p>');
							$("html,body").animate({scrollTop:$('#action_alert').offset().top-175}, 500);
							
							
						    $("#replyinputform").trigger("reset");
						    
						    $("#add-reply-para-body").empty();
							$("#add-reply-para-head").empty();
							  $('#add-reply-para table thead').empty();
							  $('#add-reply-para table tbody').empty();
						    
						    getReplyBySubParaId(subParaId,1);
						    
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
				            	 
				            	 $('form[id=replyinputform]').parsley().validate();
				            	 
				             }
		
	
	}
});

$(document).on('click', '.replyview_details', function(){
 var replyrow_id = $(this).attr("id");
 //alert("kal2here"+replyrow_id);


 // alert("replylatest"+replylatest);
 var replyAction = $('#replyAction'+replyrow_id+'').val();
 var replyRemarks = $('#replyRemarks'+replyrow_id+'').val();
 var replyDate = $('#replyDate'+replyrow_id+'').val();
    // alert("kal2"+replyAction);
   //  alert("kal3"+replyRemarks);
   //  alert("kal4"+replyDate);
//  $('input:radio[name=replylatest][value='+replylatest+']').attr('checked', true);

 $('#replyAction'+replyrow_id+'').val(replyAction);
 $('#replyRemarks'+replyrow_id+'').val(replyRemarks);
 $('#replyDate'+replyrow_id+'').val(replyDate); 
 

 $('#replyAction').val(replyAction);
 $('#replyRemarks').val(replyRemarks);
 $('#replyDate').val(replyDate); 

 $('#savereply').text('Edit');
 $('#replyrow_id').val(replyrow_id);
 $('#reply_dialog').dialog('option', 'title', 'Edit Reply Data');
 $('#reply_dialog').dialog('open');
});

$(document).on('click', '.replyremove_details', function(){
 var replyrow_id = $(this).attr("id");
 if(confirm("Are you sure you want to remove this row data?"))
 {
	
  $('#replyrow_'+replyrow_id+'').remove();
 }
 else
 {
  return false;
 }
});

$('#action_replyalert').dialog({
 autoOpen:false
});






$('.parasbutton').click(function(e){
//	alert("in paras button i.e submit replies");
	 var formname=this.form.name;
	 
	 var formid=this.form.id;
	 
	 var finaldatatoSend;
	 
	 var customformid="#"+formid;
	//	var getformname=$(formname).prop('form');
		var buttonid=$(this).prop('id');
		
		var finYear;
		var newfinYear;
		
		var ngistId;
		var subParaId;
		
	if(formname=="parasform1"){
		
		finYear=$('#financialYear').val();
		
		//newfinYear="'"+finYear+"'";
		
	}
	
	if(formname=="parasform2"){
		
		ngistId=$('#paraId2').val();
		
	}
	
	
		
		
		
		//	alert("kal2"+formname+"--"+formid+"--"+"buttonid"+buttonid);
			
			
			
 $('#action_alert').empty();
			 
			 e.preventDefault(); //=== To Avoid Page Refresh and Fire the Event "Click"===
			 
			 if(formname=="parasform1"|| formname=="parasform2" ||  formname=="parasform3" ||  formname=="parasform5"){	
			 
			 if ($('form[name=' + formname + ']').parsley().isValid()) {
				 
				// alert("kal5");
				  
				 if(formname=="parasform1"){
					 
					 finaldatatoSend=$('form[name='+formname+']').serialize();
					 
					 
				
				 }
				 
				 if(formname=="parasform2"){
					 
				
					 finaldatatoSend=$('form[name='+formname+']').serialize(); 
					
			
					 
				 }
				 if(formname=="parasform3"){
				 $.fn.serializeObject = function() {
						var o = {};
						var a = $('form[name='+formname+']').serializeArray();
						$.each(a, function() {
							if (o[this.name]) {
								if (!o[this.name].push) {
									o[this.name] = [o[this.name]];
								}
								o[this.name].push(this.value || '');
							} else {
								o[this.name] = this.value || '';
							}
						});
						return o;
					};

					/*console.log(JSON.stringify({
					                        button: 1,
					                        viewModel: $('form[name='+formname+']').serializeObject(),
					                        ChooseRight: 2,
					                        WildCardProdType: 3

					                    }));*/
					
					   var formData = $('form[name='+formname+']').serializeObject(); 
				//	    console.log("formData"+formData);
					   
					  // console.log("formDataunit"+formData.unitId);
					  // console.log("formDataunit"+formData.subParaId);
					
					 var  dataToSend = JSON.stringify(formData);
				//	 console.log("dataToSend"+dataToSend);
					 
					// console.log("dataToSend replyDataList"+dataToSend.replyDataList);
					 finaldatatoSend =JSON.parse(dataToSend);
					 // console.log("finaldatatoSend"+finaldatatoSend);
					 
					 subParaId=$('#subParaId3').val();
					 
				
				 }
				 
				 if(formname=="parasform5"){
					 
					// alert("parasform5");
					 
					 if(confirm("Are you sure you want to Transfer Para including all Sub Paras ,Replys and Documents to Other Office Selected.  ?")){
					 
					 var trflag1=$("#transferFlag5").val(); 
					 
					// alert("trflag1"+trflag1);
					 
					 $('#transferFlag5').val(true);
					 
					 var trflag=$('#transferFlag5').val(); 
					 
					// alert("trflag"+trflag);
					 
					 
					 
					 finaldatatoSend=$('form[name='+formname+']').serialize();
					 
					  }else{
						  
						  return false;
						  
					  }
					 
					 
				 }
				 
				
				

		   	 $.ajax({	          
		      url: "../parastsimis/add-para-info",
		      method:"POST",
		      async: false,
		     
		      data:finaldatatoSend,
			 
		      success: function (response) {
		   
		    	//alert("kal"+response);
		    	  
		    	  
		    	 
		    	 if(response>0){
		
			 
				
				  if(formname=="parasform1"){
					  
					 
				    	
					  $('#action_alert').html('<p style="margin: 0px !important;">Data Inserted Successfully</p>');
						$("html,body").animate({scrollTop:$('#action_alert').offset().top-175}, 500);
					
						
							
						  getGistinAddGistByYear(finYear,1);
					    $(customformid).trigger("reset");
					    
					  
					    setTimeout(function () { location.reload(true); }, 2000);
					   
					    }
				    
				    if(formname=="parasform2"){
				    	
				    	 $('#action_alert').html('<p style="margin: 0px !important;">Data Inserted Successfully</p>');
							$("html,body").animate({scrollTop:$('#action_alert').offset().top-175}, 500);
				    	
							
							
				    	 getSubParaDataByParaId(ngistId,4);
				    	 
				    	 $(customformid).trigger("reset");
				    	 
				    	 
				    }
				    
				    if(formname=="parasform3"){
				    	
				    	 $('#action_alert').html('<p style="margin: 0px !important;">Data Inserted Successfully</p>');
							$("html,body").animate({scrollTop:$('#action_alert').offset().top-175}, 500);
				    	 
							
							$("#add-reply-para-body").empty();
							$("#add-reply-para-head").empty();
							  $('#add-reply-para table thead').empty();
							  $('#add-reply-para table tbody').empty();
							
							getReplyBySubParaId(subParaId,1);
				    	  
				    	  
				    	  
							$("#reply-data-body").empty();
						
				    	 
				    	 $(customformid).trigger("reset");
				    }
				    
				    if(formname=="parasform5"){
				    	
				    	 $('#action_alert').html('<p style="margin: 0px !important;">Data Transferred Successfully</p>');
							$("html,body").animate({scrollTop:$('#action_alert').offset().top-175}, 500);
				    	
				    	
							
							  
							  setTimeout(function () { location.reload(true); }, 500);
							  $("#tabs").tabs('select',5);
							  
							getReplyBySubParaId(subParaId,1);
				    	  
				    	  
							 
				    	  
				    	 // $("#reply_data").empty();
				    	 
				    	 $(customformid).trigger("reset");
				    	 
				    }
				    
				   
				    
				    
				
				 
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
	            	 
	            	 $('form[name='+formname+']').parsley().validate();
	            	 
	             }
				 
			 }
			 
			 if(formname=="parasform4"){
					
				 var fileInput = document.getElementById("uploadFile");
				 if (!fileInput.value) {
					   // console.log("No files selected.")
					    return;
					  }
				 
				 var form = document.getElementById(formid);
				  var formdata = new FormData(form); 
				  
				  for (i = 0; i < fileInput.files.length; i++) {
				        //Appending each file to FormData object
					  
					  console.log(fileInput.files[i].name);
				        formdata.append(fileInput.files[i].name, fileInput.files[i]);
				    }
				  
				  var paraId = parseInt($('#paraId4').val());
				  var subParaId =parseInt($('#subParaId4').val());
				  var paratabId =parseInt($('#paratabId4').val());
				  
				 // console.log(formdata);
				  
				  finaldatatoSend=formdata;
				  
				  if ($('form[name=' + formname + ']').parsley().isValid()) {
					  
					
				  
						 var xhr = new XMLHttpRequest();
						  xhr.open('POST', "../parastsimis/add-doc-info?paraId="+paraId+" &subParaId="+subParaId+" &paratabId="+paratabId);
						  xhr.send(formdata);
						  
						  xhr.onreadystatechange = function () {
						        if (xhr.readyState == 4 && xhr.status == 200) {
						        	
						           var response= xhr.responseText;
						            if(response>0){
						        		
						  			  $('#action_alert').html('<p style="margin: 0px !important;">Data inserted Successfully</p>');
						  				$("html,body").animate({scrollTop:$('#action_alert').offset().top-175}, 500);
						  				
						  			
						  			getDocsBySubParaId(subParaId,1);
						  			
						  			    }
						  			    if(response==0||response==null){
						  			    	
						  			    	  $('#action_alert').html('<p style="margin: 0px !important;">Failed to Transfer data</p>');
						  			    		$("html,body").animate({scrollTop:$('#action_alert').offset().top-175}, 500);
						  			    }
						        }
						    }
						  
					  
							
						  
				  
			 }else{
            	 
            	 $('form[name='+formname+']').parsley().validate();
            	 
             }
			 }
			 
	             
	     
			 
			
				
				

});



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
.addMessage('en', 'fileextension', 'The file should be .pdf,.jpg,.png');



	
});



function getGistinAddGistByYear(finyear,hkey){
	
	if(hkey==1){
	//alert(year+tankId+freq);
	$("#add-para-gist-head").empty();
	$("#add-para-gist-body").empty();
	
	
	}
	
	var financialYear=finyear; 
	
	var unit=$("#unitId1").val();
	var circle=$("#circleId1").val();
	var division=$("#divisionId1").val();

	//alert("financialYear"+financialYear);
	
	
		
		$.ajax({	          
	      url: "../parastsimis/get-gist-by-year",
	      method:"POST",
			dataType: 'json',

			async: false,
			data: {
				  
				
				financialYear:financialYear,
				unitId:unit,
				circleId:circle,
				divisionId:division,
				
							
				
			},
	      success: function (obj) {
	    	// alert("obj" +obj);
	    	// console.log(obj);
	    	 if(obj!=null){ 
	    	//  var obj = JSON.parse(msg);
	    	  
	    	  var j=1;
	    	  
	    	  
	    	  


	    	 if(hkey==1){
	    	
	    	    $('#add-para-gist table thead').append(  
	    	    		'<tr style="font-size: 18px; color: gray; font-weight: bold;"><th>Sl.No</th>'+
	    	    	
	    	    		'<th>Para Number</th>'+
	    	    		'<th>Para Gist</th>'+
	    	    		'<th>Para Status</th>'+
	    	    		
	    	    		'<th>Action</th>'+
	    	    		
	    	    		'</tr>'); 	
	    	 }
	    	 
	    	 
	    	
	    	    
	    	    for(i in obj){
	    	    	
	    	    	var acttiontitle=obj[i].actionTitle;
	    	    	var acttionnew="'"+acttiontitle+"'" ;
	    	    	var action2=acttionnew.replace(/\r?\n|\r/g, " ")
	    	    	
	    	    	var parnu= obj[i].paraNumber;
	    	    	var paranumnew="'"+parnu+"'" ;
	    	    	
	    	    	var parastatusid=obj[i].paraStatusId;
	    	    	var secid=obj[i].sectionId;
	    	    	
	    	    	var fy=obj[i].financialYear;
	    	    	var fynew="'"+fy+"'";
	    	    	
	    	    	if(hkey==1){
	    	    	//alert("acttiontitle-------"+acttionnew);
	     	    	   $('#add-para-gist table tbody').append(  '<tr style="font-size: 16px">' +
	    	    			                                '<td style="text-align: center;">'+j+'</td>' +
	    	    			                                
	    	    			                                '<td><b>'+obj[i].paraNumber+'</b></td>'+
	    	    			                                    '<td style="color:black;"><b>'+obj[i].actionTitle+'</b></td>'+
	    	    			                                    
	    	    			                             ( (parastatusid==1)?     '<td style="color:black;"><b>Reply Sent to AG</b></td>':'')+
	    	    			                             ( (parastatusid==2)?     '<td style="color:black;"><b>Reply Not Sent</b></td>':'')+
	    	    			                             ( (parastatusid==3)?     '<td style="color:black;"><b>Dropped</b></td>':'')+
	    	    			                             
	    	    			                          
	    	    			                                    
	    	    			                                    '<td>&emsp;<button type="button" name="shgistinfo" id="shgistinfo'+j+'" class="btn btn-1 btn-primary center-block " onclick="showgistparainfo('+obj[i].paraId+')"  >View Gist Info</button> &emsp;&emsp; '+
	    	    			                                    '<button type="button" name="edgistinf" id="edgistinf'+j+'" class="btn btn-1 btn-primary center-block " onclick="openeditformgist('+obj[i].paraId+')"  >Edit Para Gist</button> &emsp;&emsp;'+
	    	    			                                    '<button type="button" name="dgistinf" id="getparagistinfo'+j+'" class="btn btn-1 btn-primary center-block "  onclick="opendeleteformgist('+obj[i].paraId+')" >Delete Para </button> &emsp;</td>'+
	    	    			                                   
	    	    			                                    
	    	    			                                
	    	    			                                    
	    	    			                                '</tr>');
	     	    	   
	     	    	   
	    	    	}
	    	    	
	    	    	
	    	    	
	    	    	   j++;
	    	    }
	   	    
	    	 }
	      },
	      error : function(){
	    	  alert(error);
	      }
	  })
	  
	/*if(hkey==1){
		
		var idnew="add-para-gist-tid" ;
		
		//alert("idnew"+idnew);

	  gettableexport(idnew);
	  
	}*/
	
	
	
}




function getParaGistByYearoffice(unit,circle,division,finyear,hkey){
	
	$("#viewgistinfohead").empty();
	$("#viewgistinfobody").empty();
	
	$("#viewsubparagistinfohead").empty();
	$("#viewsubparagistinfobody").empty();
	
	$("#doc-gist-info-head").empty();
	$("#doc-gist-info-body").empty();
	
	$("#t-gist-info-head").empty();
	$("#t-gist-info-body").empty();
	
	$("#add-reply-para-body").empty();
	$("#add-reply-para-head").empty();
	  $('#add-reply-para table thead').empty();
	  $('#add-reply-para table tbody').empty();
	
	$('#act-alert').empty();
	
	$("#paraStatusId2 option").removeAttr('disabled'); //enable
	$('#paraStatusId2').multiselect('rebuild');
	
	
	$('#act-alerttr').empty();
	$("#para5").removeAttr('disabled'); //enable
	

	//alert(year+tankId+freq);
	//alert("hkey"+hkey);
	
	if(hkey==1){
		
		
	
	 $('#paranumdid').empty();
	  $('#viewparainf').empty();
	  
	  $('#paraId2').val(0);
	  
	}
	
	
	if(hkey==2){
		
	
		
		
		 $('#para-gist-num-did').empty();
		  $('#para-inf').empty();
		  
		  $('#paraId3').val(0);
		  
		}
	
	
	
	
	if(hkey==3){
		
		
		
		
		 $('#doc-gist-num-did').empty();
		  $('#doc-inf').empty();
		  
		  $('#paraId4').val(0);
		  
		}
	
	if(hkey==4){
		
		 $('#t-gist-num-did').empty();
		  $('#t-inf').empty();
		  
		  $('#paraId5').val(0);
		  
		}
	
	
	var financialYear=finyear; 

	//alert("financialYear",financialYear);
	$.ajax({	          
	      url: "../parastsimis/get-gist-by-year",
	      method:"POST",
			dataType: 'json',

			async: false,
			data: {
				  
				
				financialYear:financialYear,
				unitId:unit,
				circleId:circle,
				divisionId:division,
				
							
				
			},
	      success: function (obj) {
	    	// alert("obj" +obj);
	    	// console.log(obj);
	    	 if(obj!=null){ 
	    	//  var obj = JSON.parse(msg);
	    	  
	    	  var j=1;
	    	  
	    	  
	    	  

                       if(hkey==1){
	    	 
	    	
	    	    $('#viewgistinfo table thead').append(  
	    	    		'<tr style="font-size: 18px; color: gray; font-weight: bold;"><th>Sl.No</th>'+
	    	    	
	    	    		'<th>Para Number</th>'+
	    	    		'<th>Para Gist</th>'+
	    	    		'<th>Select Para</th>'+
	    	    		
	    	    		'</tr>'); 	  
	    	    
	    	    for(i in obj){
	    	    	
	    	    	var acttiontitle=obj[i].actionTitle;
	    	    	var acttionnew="'"+acttiontitle+"'" ;
	    	    	var action2=acttionnew.replace(/\r?\n|\r/g, " ")
	    	    	//alert("action2"+action2)
	    	    	
	    	    	var parnu= obj[i].paraNumber;
	    	    	var paranumnew="'"+parnu+"'" ;
	    	    	
	    	    	
	    	    //	alert(hkey)
	    	    	//alert("acttiontitle-------"+acttionnew);
	     	    	   $('#viewgistinfo table tbody').append(  '<tr style="font-size: 16px">' +
	    	    			                                '<td style="text-align: center;">'+j+'</td>' +
	    	    			                                
	    	    			                                '<td><b>'+obj[i].paraNumber+'</b></td>'+
	    	    			                                    '<td style="color:black;"><b>'+obj[i].actionTitle+'</b></td>'+
	    	    			                                    
	    	    			                                 '<td><button type="button" name="paragistinfo" id="getparagistinfo'+j+'" class="btn btn-1 btn-primary center-block " onclick="showpragistdata('+paranumnew+','+action2+','+obj[i].paraId+','+hkey+')" >Select Para Gist</button></td>'+
	    	    			                                   
	    	    			                                
	    	    			                                
	    	    			                                    
	    	    			                                '</tr>');
	    	    	   j++;
	    	    }
	    	    
                       }//end of hkey1
                       
                       
                       if(hkey==2){
              	    	 
               	    	
           	    	    $('#viewsubparagistinfo table thead').append(  
           	    	    		'<tr style="font-size: 18px; color: gray; font-weight: bold;"><th>Sl.No</th>'+
           	    	    	
           	    	    		'<th>Para Number</th>'+
           	    	    		'<th>Para Gist</th>'+
           	    	    		'<th>Select Para</th>'+
           	    	    		
           	    	    		'</tr>'); 	  
           	    	    
           	    	    for(i in obj){
           	    	    	
           	    	    	var acttiontitle=obj[i].actionTitle;
           	    	    	var acttionnew="'"+acttiontitle+"'" ;
           	    	 	var action2=acttionnew.replace(/\r?\n|\r/g, " ")
           	    	    	
           	    	    	var parnu= obj[i].paraNumber;
           	    	    	var paranumnew="'"+parnu+"'" ;
           	    	    	
           	    	    	
           	    	    //	alert(hkey)
           	    	    	//alert("acttiontitle-------"+acttionnew);
           	     	    	   $('#viewsubparagistinfo table tbody').append(  '<tr style="font-size: 16px">' +
           	    	    			                                '<td style="text-align: center;">'+j+'</td>' +
           	    	    			                                
           	    	    			                                '<td><b>'+obj[i].paraNumber+'</b></td>'+
           	    	    			                                    '<td style="color:black;"><b>'+obj[i].actionTitle+'</b></td>'+
           	    	    			                                    
           	    	    			                                 
           	    	    			                                   
           	    	    			                                '<td><button type="button" name="subparagistinfo" id="getsubparagistinfo'+j+'" class="btn btn-1 btn-primary center-block " onclick="showpragistdata('+paranumnew+','+action2+','+obj[i].paraId+','+hkey+'),getSubParaDataByParaId('+obj[i].paraId+',1)" >Select Para</button></td>'+  
           	    	    			                                
           	    	    			                                    
           	    	    			                                '</tr>');
           	    	    	   j++;
           	    	    }
           	    	    
                                  }//end of hkey2
                       
                       if(hkey==3){
                	    	 
                  	    	
              	    	    $('#doc-gist-info table thead').append(  
              	    	    		'<tr style="font-size: 18px; color: gray; font-weight: bold;"><th>Sl.No</th>'+
              	    	    	
              	    	    		'<th>Para Number</th>'+
              	    	    		'<th>Para Gist</th>'+
              	    	    		'<th>Select Para</th>'+
              	    	    		
              	    	    		'</tr>'); 	  
              	    	    
              	    	    for(i in obj){
              	    	    	
              	    	    	var acttiontitle=obj[i].actionTitle;
              	    	    	var acttionnew="'"+acttiontitle+"'" ;
              	    	    	var action2=acttionnew.replace(/\r?\n|\r/g, " ")
              	    	    	
              	    	    	
              	    	    	var parnu= obj[i].paraNumber;
              	    	    	var paranumnew="'"+parnu+"'" ;
              	    	    	
              	    	    	
              	    	    //	alert(hkey)
              	    	    	//alert("acttiontitle-------"+acttionnew);
              	     	    	   $('#doc-gist-info table tbody').append(  '<tr style="font-size: 16px">' +
              	    	    			                                '<td style="text-align: center;">'+j+'</td>' +
              	    	    			                                
              	    	    			                                '<td><b>'+obj[i].paraNumber+'</b></td>'+
              	    	    			                                    '<td style="color:black;"><b>'+obj[i].actionTitle+'</b></td>'+
              	    	    			                                    
              	    	    			                                 
              	    	    			                                   
              	    	    			                                '<td><button type="button" name="dparagistinfo" id="dsubparagistinfo'+j+'" class="btn btn-1 btn-primary center-block " onclick="showpragistdata('+paranumnew+','+action2+','+obj[i].paraId+','+hkey+'),getSubParaDataByParaId('+obj[i].paraId+',2)" >Select Para Gist</button></td>'+  
              	    	    			                                
              	    	    			                                    
              	    	    			                                '</tr>');
              	    	    	   j++;
              	    	    }
              	    	    
                                     }//end of hkey3
                       
                       if(hkey==4){
              	    	 
                 	    	
             	    	    $('#t-gist-info table thead').append(  
             	    	    		'<tr style="font-size: 18px; color: gray; font-weight: bold;"><th>Sl.No</th>'+
             	    	    	
             	    	    		'<th>Para Number</th>'+
             	    	    		'<th>Para Gist</th>'+
             	    	    		'<th>Select Para</th>'+
             	    	    		
             	    	    		'</tr>'); 	  
             	    	    
             	    	    for(i in obj){
             	    	    	
             	    	    	var acttiontitle=obj[i].actionTitle;
             	    	    	var acttionnew="'"+acttiontitle+"'" ;
             	    	    	var action2=acttionnew.replace(/\r?\n|\r/g, " ")
             	    	    	
             	    	    	
             	    	    	var parnu= obj[i].paraNumber;
             	    	    	var paranumnew="'"+parnu+"'" ;
             	    	    	
             	    	    	
             	    	    //	alert(hkey)
             	    	    	//alert("acttiontitle-------"+acttionnew);
             	     	    	   $('#t-gist-info table tbody').append(  '<tr style="font-size: 16px">' +
             	    	    			                                '<td style="text-align: center;">'+j+'</td>' +
             	    	    			                                
             	    	    			                                '<td><b>'+obj[i].paraNumber+'</b></td>'+
             	    	    			                                    '<td style="color:black;"><b>'+obj[i].actionTitle+'</b></td>'+
             	    	    			                                    
             	    	    			                                 
             	    	    			                                   
             	    	    			                                '<td><button type="button" name="tparagistinfo" id="tsubparagistinfo'+j+'" class="btn btn-1 btn-primary center-block " onclick="showpragistdata('+paranumnew+','+action2+','+obj[i].paraId+','+hkey+'),getSubParaDataByParaId('+obj[i].paraId+',3)" >Select Para</button></td>'+  
             	    	    			                                
             	    	    			                                    
             	    	    			                                '</tr>');
             	    	    	   j++;
             	    	    }
             	    	    
                                    }//end of hkey4
	   	    
	    	 }
	      },
	      error : function(){
	    	  alert(error);
	      }
	  });
	
	
	
}





function getSubParaDataByParaId(paraId,hkey){
	
	$("#sub-para-inf-head").empty();
	$("#sub-para-inf-body").empty();
	
	$("#doc-para-inf-head").empty();	
	$("#doc-para-inf-body").empty();
	
	$('#add-sub-para-head').empty();
	  $('#add-sub-para-body').empty();
	
	
	  $('#act-alertrep').empty();
	  
		$('#act-alertrep').html('<p style="margin: 0px !important; color:red">Please Select  Sub Para!.</p>');
	

	//alert(year+tankId+freq);
	//alert("hkey"+hkey+"paraId"+paraId);
	
	if(hkey==1){
		
		
	
	 $('#subcat').empty();
	  $('#subParadata').empty();
	  
	  $('#subParaId3').val(0);
	  
	  
	  
	}
	
	if(hkey==2){
		
		
		
		 $('#doccat').empty();
		  $('#docsubdata').empty();
		  
		  $('#subParaId4').val(0);
		  
		}
	
	if(hkey==4){
		
		
		
		 $('#add-sub-para-head').empty();
		  $('#add-sub-para-body').empty();
		  
			
		 
		  
		}
		
	
	
	
	
	
	var paraId=paraId; 

	//alert("financialYear",financialYear);
	$.ajax({	          
	      url: "../parastsimis/get-subpara-data-paraid",
	      method:"POST",
			dataType: 'json',

			async: false,
			data: {
				  
				
				paraId:paraId,
				
							
				
			},
	      success: function (obj) {
	    	// alert("obj" +obj);
	    	// console.log(obj);
	    	 if(obj!=null){ 
	    	//  var obj = JSON.parse(msg);
	    	  
	    	  var j=1;
	    	  
	    	  
	    	  

                       if(hkey==1){
	    	 
	    	
	    	    $('#sub-para-inf table thead').append(  
	    	    		'<tr style="font-size: 18px; color: gray; font-weight: bold;"><th>Sl.No</th>'+
	    	    	
	    	    		'<th>Sub Category</th>'+
	    	    		'<th>Para</th>'+
	    	    		'<th>Select Para</th>'+
	    	    		
	    	    		'</tr>'); 	  
	    	    
	    	    for(i in obj){
	    	    	
	    	    	var parasAction=obj[i].parasAction;
	    	    	
	    	    	// var newhtml =String.raw'+parasAction+';
	    	    	var parasActionnew=parasAction;
	    	    //	console.log(parasActionnew);
	    	    	
	    	    	var subcategory= obj[i].subcategory;
	    	    	var subcategorynew="'"+subcategory+"'" ;
	    	    	
	    	    	//alert("parasActionnew"+parasActionnew);
	    	    	
	    	    	//var strng=JSON.stringify(parasAction);
	    	    	//alert("strng"+strng);
	    	    	
	    	    	//var strngnew="'"+strng+"'";
	    	    	
	    	    	
	    	    //	alert(hkey)
	    	    	//alert("acttiontitle-------"+acttionnew);
	     	    	   $('#sub-para-inf table tbody').append(  '<tr style="font-size: 16px">' +
	    	    			                                '<td style="text-align: center;">'+j+'</td>' +
	    	    			                                
	    	    			                                '<td><b>'+obj[i].subcategory+'</b></td>'+
	    	    			                                    '<td style="color:black;"><b>'+obj[i].parasAction+'</b></td>'+
	    	    			                                    
	    	    			                                 '<td><button type="button" name="subparainfo" id="sgetparainfo'+j+'" class="btn btn-1 btn-primary center-block " onclick="showSubpdata('+subcategorynew+','+obj[i].subParaId+','+hkey+'),getReplyBySubParaId('+obj[i].subParaId+',1)" >Select Para</button></td>'+
	    	    			                                   
	    	    			                                
	    	    			                                
	    	    			                                    
	    	    			                                '</tr>');
	    	    	   j++;
	    	    }
	    	    
                       }//end of hkey1
                       
                       
                       
                       if(hkey==2){
              	    	 
               	    	
           	    	    $('#doc-para-inf table thead').append(  
           	    	    		'<tr style="font-size: 18px; color: gray; font-weight: bold;"><th>Sl.No</th>'+
           	    	    	
           	    	    		'<th>Sub Category</th>'+
           	    	    		'<th>Para</th>'+
           	    	    		'<th>Select Para</th>'+
           	    	    		
           	    	    		'</tr>'); 	  
           	    	    
           	    	    for(i in obj){
           	    	    	
           	    	    	var parasAction=obj[i].parasAction;
           	    	    	
           	    	    	// var newhtml =String.raw'+parasAction+';
           	    	    	var parasActionnew=parasAction;
           	    	    	
           	    	    	var subcategory= obj[i].subcategory;
           	    	    	var subcategorynew="'"+subcategory+"'" ;
           	    	    	
           	    	    	//alert("parasActionnew"+parasActionnew);
           	    	    	
           	    	    	//var strng=JSON.stringify(parasAction);
           	    	    	//alert("strng"+strng);
           	    	    	
           	    	    	//var strngnew="'"+strng+"'";
           	    	    	
           	    	    	
           	    	    //	alert(hkey)
           	    	    	//alert("acttiontitle-------"+acttionnew);
           	     	    	   $('#doc-para-inf table tbody').append(  '<tr style="font-size: 16px">' +
           	    	    			                                '<td style="text-align: center;">'+j+'</td>' +
           	    	    			                                
           	    	    			                                '<td><b>'+obj[i].subcategory+'</b></td>'+
           	    	    			                                    '<td style="color:black;"><b>'+obj[i].parasAction+'</b></td>'+
           	    	    			                                    
           	    	    			                                 '<td><button type="button" name="subparainfo" id="sgetparainfo'+j+'" class="btn btn-1 btn-primary center-block " onclick="showSubpdata('+subcategorynew+','+obj[i].subParaId+','+hkey+'),getDocsBySubParaId('+obj[i].subParaId+',1)" >Select Para</button></td>'+
           	    	    			                                   
           	    	    			                                
           	    	    			                                
           	    	    			                                    
           	    	    			                                '</tr>');
           	     	    	   
           	     	    	   
           	    	    	   j++;
           	    	    }
           	    	    
                                  }//end of hkey2
                       
                       
                       
                       if(hkey==4){
                    	   

                    	
                  	    	
              	    	    $('#add-sub-para table thead').append(  
              	    	    		'<tr style="font-size: 18px; color: gray; font-weight: bold;"><th>Sl.No</th>'+
              	    	    	
              	    	    		'<th>Sub Category</th>'+
              	    	    		'<th>Para</th>'+
              	    	    		'<th>Para Status</th>'+
              	    	    		'<th>Action</th>'+
              	    	    		
              	    	    		'</tr>'); 	  
              	    	    
              	    	    for(i in obj){
              	    	    	
              	    	    	var parasAction=obj[i].parasAction;
              	    	    	
              	    	    	// var newhtml =String.raw'+parasAction+';
              	    	    	var parasActionnew=parasAction;
              	    	    	
              	    	    	var subcategory= obj[i].subcategory;
              	    	    	var subcategorynew="'"+subcategory+"'" ;
              	    	    	
              	    	    	
              	    	    	var stat =obj[i].paraStatusId;
              	    	    
              	    	    	
              	    	 
              	     	    	   $('#add-sub-para table tbody').append(  '<tr style="font-size: 16px">' +
              	    	    			                                '<td style="text-align: center;">'+j+'</td>' +
              	    	    			                                
              	    	    			                                '<td><b>'+obj[i].subcategory+'</b></td>'+
              	    	    			                                    '<td style="color:black;"><b>'+obj[i].parasAction+'</b></td>'+
              	    	    			                                ( (stat==1)? '<td style="color:black;"><b>Reply sent to AG</b></td>':'')+
              	    	    			                              ( (stat==2)? '<td style="color:black;"><b>Reply not sent</b></td>':'')+
              	    	    			                            ( (stat==3)? '<td style="color:black;"><b>Dropped</b></td>':'')+
              	    	    			                                    
              	    	    			                                 '<td><button type="button" name="esubparabygist" id="esubparabygist'+j+'" class="btn btn-1 btn-primary center-block " onclick="openeditSubdata('+obj[i].subParaId+')" >Edit Para</button> &emsp;&emsp;'+
              	    	    			                                 
              	    	    			                                 '<button type="button" name="dsubparabygist" id="esubparabygist'+j+'" class="btn btn-1 btn-primary center-block " onclick="opendeletesubdata('+paraId+','+obj[i].subParaId+')" >Delete Para</button></td>'+
              	    	    			                                   
              	    	    			                                
              	    	    			                                
              	    	    			                                    
              	    	    			                                '</tr>');
              	     	    	   
              	     	    	   
              	    	    	   j++;
              	    	    }
              	    	    
                                     }//end of hkey1
                       
                      
	   	    
	    	 }
	      },
	      error : function(){
	    	  alert(error);
	      }
	  });
	
	/*if(hkey==4){
		
	
		
		var id="add-sub-para-tid"
	//alert(id+"id");
	
	gettableexport(id);
		
	}*/
	//;
}


function getReplyBySubParaId(SubParaId,hkey){
	
	//alert(" iam in getReplyBySubParaId ");
	
	$("#add-reply-para-body").empty();
	$("#add-reply-para-head").empty();
	  $('#add-reply-para table thead').empty();
	  $('#add-reply-para table tbody').empty();
	
		
	var SubParaId=SubParaId; 

	//alert("SubParaId"+SubParaId);
	$.ajax({	          
	      url: "../parastsimis/get-reply-data-edit",
	      method:"POST",
			dataType: 'json',

			async: false,
			data: {
				  
				
				subParaId:SubParaId,
				
							
				
			},
	      success: function (obj) {
	    	//alert("obj" +obj);
	     console.log(obj);
	    	 if(obj!=null){ 
	    	//  var obj = JSON.parse(msg);
	    	  
	    	  var j=1;
	    	                           
                       
                       if(hkey==1){
                	    	 
                  	    	
              	    	    $('#add-reply-para table thead').append(  
              	    	    		'<tr style="font-size: 18px; color: gray; font-weight: bold;"><th>Sl.No</th>'+
              	    	    	
              	    	    		'<th>Reply</th>'+
              	    	    		'<th>Remarks</th>'+
              	    	    		'<th>Reply Date</th>'+
              	    	    		'<th>Action</th>'+
              	    	    		
              	    	    		'</tr>'); 	  
              	    	    
              	    	    for(i in obj){
              	    	    	
              	    	    	
              	    	 
              	     	    	   $('#add-reply-para table tbody').append(  '<tr style="font-size: 16px">' +
              	    	    			                                '<td style="text-align: center;">'+j+'</td>' +
              	    	    			                                
              	    	    			                                '<td><b>'+obj[i].replyAction+'</b></td>'+
              	    	    			                                    '<td style="color:black;"><b>'+obj[i].replyRemarks+'</b></td>'+
              	    	    			                                  '<td style="color:black;"><b>'+obj[i].replyDate+'</b></td>'+
              	    	    			                             
              	    	    			                                 '<td><button type="button" name="ereplyparabygist" id="ereplyparabygist'+j+'" class="btn btn-1 btn-primary center-block " onclick="openeditReplydata('+obj[i].paraReplyId+')" >Edit Reply</button> &emsp;&emsp;'+
              	    	    			                                 
              	    	    			                                 '<button type="button" name="dreplyparabygist" id="dreplyparabygist'+j+'" class="btn btn-1 btn-primary center-block " onclick="opendeleteReplydata('+obj[i].subParaId+','+obj[i].paraReplyId+')" >Delete Reply</button></td>'+
              	    	    			                                   
              	    	    			                                
              	    	    			                                    
              	    	    			                                '</tr>');
              	     	    	   
              	     	    	   
              	    	    	   j++;
              	    	    }
              	    	    
                                     }//end of hkey1
                       
                      
	   	    
	    	 }
	      },
	      error : function(){
	    	  alert(error);
	      }
	  });
	
	
/*if(hkey==1){
		
		var idnew="add-reply-para-tid" ;
		
		//alert("idnew"+idnew);

	  gettableexport(idnew);
	  
	}
	*/
}



function getDocsBySubParaId(SubParaId,hkey){
	
	$("#add-doc-list-body").empty();
	$("#add-doc-list-head").empty();
	
		
	var SubParaId=SubParaId; 

//	alert("SubParaId"+SubParaId);
	$.ajax({	          
	      url: "../parastsimis/get-docs-data-delete",
	      method:"POST",
			dataType: 'json',

			async: false,
			data: {
				  
				
				subParaId:SubParaId,
				
							
				
			},
	      success: function (obj) {
	    	//alert("obj" +obj);
	     console.log(obj);
	    	 if(obj!=null){ 
	    	//  var obj = JSON.parse(msg);
	    	  
	    	  var j=1;
	    	                           
                       
                       if(hkey==1){
                	    	 
                  	    	
              	    	    $('#add-doc-list table thead').append(  
              	    	    		'<tr style="font-size: 18px; color: gray; font-weight: bold;"><th>Sl.No</th>'+
              	    	    	
              	    	    		'<th>Document Original Name</th>'+
              	    	    		
              	    	    		'<th>Action</th>'+
              	    	    		
              	    	    		'</tr>'); 	  
              	    	    
              	    	    for(i in obj){
              	    	    	
              	    	    	
              	    	 
              	     	    	   $('#add-doc-list table tbody').append(  '<tr style="font-size: 16px">' +
              	    	    			                                '<td style="text-align: center;">'+j+'</td>' +
              	    	    			                                
              	    	    			                                '<td><b>'+obj[i].paraDocOriginalName+'</b></td>'+
              	    	    			                                  
              	    	    			                             
              	    	    			                                 '<td> <button type="button" name="ddocparabygist" id="ddocparabygist'+j+'" class="btn btn-1 btn-primary center-block " onclick="opendeletedocdata('+obj[i].subParaId+','+obj[i].docId+')" >Delete Document</button></td> &emsp;'+
              	    	    			                                 
              	    	    			                                '</tr>');
              	     	    	   
              	     	    	   
              	    	    	   j++;
              	    	    }
              	    	    
                                     }//end of hkey1
                       
                      
	   	    
	    	 }
	      },
	      error : function(){
	    	  alert(error);
	      }
	  });
	
	
/*if(hkey==1){
		
		var idnew="add-doc-list-tid" ;
		
		//alert("idnew"+idnew);

	  gettableexport(idnew);
	  
	}*/
	
	
}



function showpragistdata(paranuminfo,pgistdata,pgistid,hkey){
	
	//alert("kal here"+pgistdata+pgistid+"---"+hkey);
	if(hkey==1){
	  $('#getgist_dialogue').dialog('close');
	
	  $('#paranumdid').empty();
	  $('#viewparainf').empty();
	  
	  $('#paraId2').val(pgistid);
	  
	  $('#paranumdid').append('<b>'+paranuminfo+'</b>');
	 $('#viewparainf').append('<b>'+pgistdata+'</b>');
	 
	 
	
	 
	 getSubParaDataByParaId(pgistid,4);
	 
	 
	 
	}
	
	if(hkey==2){
		  $('#getgist_dialogue').dialog('close');
		
		  $('#para-gist-num-did').empty();
		  $('#para-inf').empty();
		  
		  $('#paraId3').val(pgistid);
		  
		  $('#para-gist-num-did').append('<b>'+paranuminfo+'</b>');
		 $('#para-inf').append('<b>'+pgistdata+'</b>');
		}
	
	if(hkey==3){
		  $('#getgist_dialogue').dialog('close');
		
		  $('#doc-gist-num-did').empty();
		  $('#doc-inf').empty();
		  
		  $('#paraId4').val(pgistid);
		  
		  $('#doc-gist-num-did').append('<b>'+paranuminfo+'</b>');
		 $('#doc-inf').append('<b>'+pgistdata+'</b>');
		}
	
	if(hkey==4){
		  $('#getgist_dialogue').dialog('close');
		
		  $('#t-gist-num-did').empty();
		  $('#t-inf').empty();
		  
		  $('#paraId5').val(pgistid);
		  
		  $('#t-gist-num-did').append('<b>'+paranuminfo+'</b>');
		 $('#t-inf').append('<b>'+pgistdata+'</b>');
		}
	
	
	
	
}

function showSubpdata(subcat,subparaid,hkey){
	
	
	//alert("kal"+subcat+"--"+subparaid+"--"+hkey);
	
	if(hkey==1){
		  $('#getsubpara_dialogue').dialog('close');		
		  $('#subcat').empty();
		  $('#subParadata').empty();		  
		  $('#subParaId3').val(subparaid);
		  $('#viewsubParaid3').show();
		  
		  $('#act-alertrep').empty();
		  	$("#reply").removeAttr('disabled'); //enable
		  
	}
	
	if(hkey==2){
		  $('#getsubpara_dialogue').dialog('close');
		
		  $('#doccat').empty();
		  $('#docsubdata').empty();
		  
		   
		  $('#subParaId4').val(subparaid);
		  
		  $('#docsubParaid4').show();
		  
		  
			$('#act-alertdoc').empty();
	    	$("#para4").removeAttr('disabled'); //enable
		
		}
	
		  		  
		  $.ajax({	          
		      url: "../parastsimis/get-edit-sub-para",
		      method:"GET",
				dataType: 'json',

				async: false,
				data: {		  
					
					subParaId:subparaid,
					
								
					
				},
		      success: function (obj) {
		    	///alert("kal1" +obj);
		    	// console.log(obj);
		    	 if(obj!=null){ 
		    		 
		    		 if(hkey==1){
		    		 
		    		  $('#subcat').append('<b>'+obj[0].subcategory+'</b>');
		    		 $('#subParadata').append('<b>'+obj[0].parasAction+'</b>');
		    		 }
		    		 
		    		 if(hkey==2){
		    			 
		    			  $('#doccat').append('<b>'+obj[0].subcategory+'</b>');
		    			 $('#docsubdata').append('<b>'+obj[0].parasAction+'</b>');
		    			 
		    		 }
		    		 
		    		  
		    	 }        
	                      
		   	    
		    	 
		      },
		      error : function(){
		    	  alert(error);
		      }
		  });
		
	
	
}

function getalertempty(){
	
	 $('#action_alert').empty();	
}

function showgistparainfo(paraId){
	
	//alert("paraId"+paraId);
	 $('#viewgist_dialogue').dialog('option', 'title', 'View Para Gist Info');
	  $('#viewgist_dialogue').dialog('open');
	  
	  $("#view-gist-inf-head").empty();
		$("#view-gist-inf-body").empty();
		
		
	
		
		
		
		$.ajax({	          
		      url: "../parastsimis/get-para-gist-paraid",
		      method:"POST",
				dataType: 'json',

				async: false,
				data: {
					  
					
					paraId:paraId,
					
								
					
				},
		      success: function (obj) {
		    //	alert("kal1" +obj);
		    	// console.log(obj);
		    	
		      
		    	var sect= obj.sectionId;
		    	  
		    
	    	    		$('#view-gist-inf table tbody').append(  
                                '<tr style="font-size: 16px"><td>Financial Year</td><td><b>'+obj.financialYear+'</b></td></tr>'+
                                '<tr style="font-size: 16px"><td>Para Number</td><td><b>'+obj.paraNumber+'</b></td></tr>'+
                                '<tr style="font-size: 16px"><td>File Number</td><td><b>'+obj.fileNumber+'</b></td></tr>'+
                                '<tr style="font-size: 16px"><td>LAR Number</td><td><b>'+obj.larNumber+'</b></td></tr>'+
                                
                                ((sect==1)?'<tr style="font-size: 16px"><td>Section</td><td style="color:black;">'+obj.sectionA+'</td></tr>':'<tr><td></td></tr>')+
                                ((sect==2)?'<tr style="font-size: 16px"><td>Section</td><td style="color:black;">'+obj.sectionB+'</td></tr>':'<tr><td></td></tr>')+
                                
                                '<tr style="font-size: 16px"><td>Date of Audit From</td><td><b>'+obj.auditDateFrom+'</b></td></tr>'+
                                '<tr style="font-size: 16px"><td>Date of Audit To</td><td><b>'+obj.auditDateTo+'</b></td></tr>'
                                
                              
                                
                              //  '<td>Date of Audit To</td><td style="color:black;">'+printCagStatus+'</td>'+
                              
                               
	                                );
		    	       
		    	  
	                       
		   	    
		    	 
		      },
		      error : function(){
		    	  alert(error);
		      }
		  });
	  
	
	  
	
}

function openeditformgist(paraId){
	
	//alert("edit"+paraId);
	
	 $('#edit-para-dialogue').dialog('option', 'title', 'Edit Para Gist');
	  $('#edit-para-dialogue').dialog('open');
	  
	   $("#editParainputform").trigger("reset");
	  
	  
	  
	  $.ajax({	          
	      url: "../parastsimis/get-para-gist-paraid",
	      method:"GET",
			dataType: 'json',

			async: false,
			data: {		  
				
				paraId:paraId,
				
							
				
			},
	      success: function (obj) {
	    	//alert("kal1" +obj);
	    	// console.log(obj);
	    	 if(obj!=null){ 
	    		 
	    		 $("#editparaId1").val(obj.paraId);
	    
	    		 $("#editfinancialYear1").val(obj.financialYear);
	    		  $("#editparaNumber1").val(obj.paraNumber);
	    		    $("#editfileNumber").val(obj.fileNumber);
	    		      $("#editlarNumber").val(obj.larNumber);
	    		       $("#editsectionId").val(obj.sectionId);
	    		        $("#editparaStatusId").val(obj.paraStatusId);
	    		         $("#editauditDateFrom").val(obj.auditDateFrom);
	    		          $("#editauditDateTo").val(obj.auditDateTo);
	    		          
	    		          
	    		          
	    		          if(obj.printCagStatus=='NO'){
	    		           $("#editprintCAGn").prop('checked', true); 
	    		          }
	    		          if(obj.printCagStatus=='Yes'){
	    		        	  $("#editprintCAGy").prop('checked', true); 
		    		          }
	    		           
	    		             $("#editactionTitle").val(obj.actionTitle);
	    		             
	    		             if(obj.inclPropCAG=='false'){
	  	    		           $("#editinclPropCAGn").prop('checked', true); 
	  	    		          }
	    		             
	    		             if(obj.inclPropCAG=='true'){
		  	    		           $("#editinclPropCAGy").prop('checked', true); 
		  	    		          }
	    		             
	    		  	
	    	       
	    	 }        
                       
	   	    
	    	 
	      },
	      error : function(){
	    	  alert(error);
	      }
	  });
	
	
}

function submitgisteditdata(){
	

	
	var finyear=$("#editfinancialYear1").val();
	
//	alert("submitedit"+finyear);
	

	if ($('form[name=editParagist]').parsley().isValid()) {
		
		var finaldatatoSend=$('form[name=editParagist]').serialize();
		
		  $.ajax({	          
				      url: "../parastsimis/edit-para-gist",
				      method:"POST",
				      async: false,
				     
				      data:finaldatatoSend,
					 
				      success: function (response) {
				   
				    	//alert("kal"+response);
				    	 
				    	 if(response>0){
				    		 
				    		 
				    		  $('#edit-para-dialogue').dialog('close');
					  $('#action_alert').html('<p style="margin: 0px !important;">Data Updated Successfully</p>');
						$("html,body").animate({scrollTop:$('#action_alert').offset().top-175}, 500);
						
						
					    $("#editParainputform").trigger("reset");
					    
					    getGistinAddGistByYear(finyear,1);
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
			            	 
			            	 $('form[name=editParagist]').parsley().validate();
			            	 
			             }
	
	
}

function opendeleteformgist(paraId){
	
	
	//alert("opendeleteformgist"+paraId);
	
	
		  
	

	
	
var finyear=$("#financialYear").val();
	
	//alert("submitdelet"+finyear);
	
	

	

	
	 if(confirm("Are you sure you want to delete. This will delete all sub paras , Replys and documents ?"))
	 {
		
	 
	
		
		  $.ajax({	          
				      url: "../parastsimis/delete-ir-paras",
				      method:"POST",
				      async: false,
				     
				      data:{
				    	  
				    	  paraId:paraId
				      },
					 
				      success: function (response) {
				   
				    	//alert("kal"+response);
				    	 
				    	 if(response>0){
				    		 
				    		 
				    		  
					  $('#action_alert').html('<p style="margin: 0px !important;">Data Deleted Successfully</p>');
						$("html,body").animate({scrollTop:$('#action_alert').offset().top-175}, 500);
						
						
					   
					    
					    getGistinAddGistByYear(finyear,1);
					    }
					    if(response==0||response==null){
					    	
					    	  $('#action_alert').html('<p style="margin: 0px !important;">Failed to Delete data</p>');
					    		$("html,body").animate({scrollTop:$('#action_alert').offset().top-175}, 500);
					    }
					    
					
					    
					   
							
					
		  },
				      
				      error : function(){
				    	 alert(error);
				    
				      }

				  
				  });   
				  
	 }
	 else
	 {
	  return false;
	 }
						
					
			             
	
}


function openeditSubdata(subparaId){
	
	 $('#edit-sub-para-dialogue').dialog('option', 'title', 'Edit Para Info');
	  $('#edit-sub-para-dialogue').dialog('open');
	  
	   $("#editsubparadi").trigger("reset");
	   
	   var subParaId=subparaId;
	   
	   
	   $.ajax({	          
		      url: "../parastsimis/get-edit-sub-para",
		      method:"GET",
				dataType: 'json',

				async: false,
				data: {		  
					
					subParaId:subParaId,
					
								
					
				},
		      success: function (obj) {
		    	///alert("kal1" +obj);
		    	// console.log(obj);
		    	 if(obj!=null){ 
		    		 
		    		 $("#editsubParaId2").val(obj[0].subParaId);
		    		 $("#editsubcategory").val(obj[0].subcategory);
		    		  $("#editparaStatusId2").val(obj[0].paraStatusId);
		    		    $("#editparasAction").val(obj[0].parasAction);
		    		    $("#editparaId2").val(obj[0].paraId);
		    		    $("#editparareasonsDelay").val(obj[0].parareasonsDelay);
		    		 
		    		       
		    	       
		    	 }        
	                       
		   	    
		    	 
		      },
		      error : function(){
		    	  alert(error);
		      }
		  });
	  

	
}


function submitSubParaeditdata(){
	

	
	var subparaId=$("#editsubParaId2").val();
	
	var paraId=$("#editparaId2").val();
	
	//alert("submiteditsub para"+subparaId);
	

	if ($('form[name=editsubparaform]').parsley().isValid()) {
		
		var finaldatatoSend=$('form[name=editsubparaform]').serialize();
		
		  $.ajax({	          
				      url: "../parastsimis/edit-sub-para-data",
				      method:"POST",
				      async: false,
				     
				      data:finaldatatoSend,
					 
				      success: function (response) {
				   
				    	//alert("kal"+response);
				    	 
				    	 if(response>0){
				    		 
				    		 
				    		  $('#edit-sub-para-dialogue').dialog('close');
					  $('#action_alert').html('<p style="margin: 0px !important;">Data Updated Successfully</p>');
						$("html,body").animate({scrollTop:$('#action_alert').offset().top-175}, 500);
						
						
						getSubParaDataByParaId(paraId,4);
						
					    $("#editsubparadi").trigger("reset");
					    
					    
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
			            	 
			            	 $('form[name=editsubparaform]').parsley().validate();
			            	 
			             }
	
	
}

function opendeletesubdata(ParaId,subParaId){
	
	//alert("opendelete"+subParaId);
	

	
	//alert("submitdelet"+finyear);
	
	
var paraId=ParaId;

//alert("paraId"+paraId);
	

	
	 if(confirm("Are you sure you want to delete. This will delete all sub para  , related Replys and Documents ?"))
	 {
		
	 
	
		
		  $.ajax({	          
				      url: "../parastsimis/delete-sub-paras",
				      method:"POST",
				      async: false,
				     
				      data:{
				    	  
				    	  subParaId:subParaId
				      },
					 
				      success: function (response) {
				   
				    	//alert("kal"+response);
				    	 
				    	 if(response>0){
				    		 
				    		 
				    		  
					  $('#action_alert').html('<p style="margin: 0px !important;">Data Deleted Successfully</p>');
						$("html,body").animate({scrollTop:$('#action_alert').offset().top-175}, 500);
						
						
					   
					    
						getSubParaDataByParaId(paraId,4);
					    }
					    if(response==0||response==null){
					    	
					    	  $('#action_alert').html('<p style="margin: 0px !important;">Failed to Delete data</p>');
					    		$("html,body").animate({scrollTop:$('#action_alert').offset().top-175}, 500);
					    }
					    
					
					    
					   
							
					
		  },
				      
				      error : function(){
				    	 alert(error);
				    
				      }

				  
				  });   
				  
	 }
	 else
	 {
	  return false;
	 }
			
	
	
}

function  openeditReplydata (paraReplyId){
	
	
	 $('#reply_dialog').dialog('option', 'title', 'Edit Reply Info');
	  $('#reply_dialog').dialog('open');
	  
	   $("#replyinputform").trigger("reset");
	   
	   
	   
	   var paraReplyId=paraReplyId;
	   
	   
	   $.ajax({	          
		      url: "../parastsimis/get-reply-data-replyid",
		      method:"POST",
				dataType: 'json',

				async: false,
				data: {		  
					
					paraReplyId:paraReplyId,
					
								
					
				},
		      success: function (obj) {
		    	///alert("kal1" +obj);
		    	// console.log(obj);
		    	 if(obj!=null){ 
		    		 
		    		 
		    		 
		    		 
		    		 
		    		 $("#editFlag").val(true);
		    		 $("#editparaReplyId").val(obj[0].paraReplyId);
		    		 $("#editsubParaId").val(obj[0].subParaId);
		    		 $("#replyDate").val(obj[0].replyDate);
		    		 $("#replyAction").val(obj[0].replyAction);
		    		  $("#replyRemarks").val(obj[0].replyRemarks);
		    		    
		    		 
		    		       
		    	       
		    	 }        
	                       
		   	    
		    	 
		      },
		      error : function(){
		    	  alert(error);
		      }
		  });
	  
	
	
}

function opendeleteReplydata(subParaId,paraReplyId){
	
//	alert("opendelete"+subParaId);	
//	alert("paraReplyId"+paraReplyId);		
	
	if(confirm("Are you sure you want to delete. This will delete respective Reply  ?"))
	 {
		
	 
	
		
		  $.ajax({	          
				      url: "../parastsimis/delete-reply-data",
				      method:"POST",
				      async: false,
				     
				      data:{
				    	  
				    	  paraReplyId:paraReplyId
				      },
					 
				      success: function (response) {
				   
				    	//alert("kal"+response);
				    	 
				    	 if(response>0){
				    		 
				    		 
				    		  
					  $('#action_alert').html('<p style="margin: 0px !important;">Data Deleted Successfully</p>');
						$("html,body").animate({scrollTop:$('#action_alert').offset().top-175}, 500);
						
						
					   
						 getReplyBySubParaId(subParaId,1);
						
					    }
					    if(response==0||response==null){
					    	
					    	  $('#action_alert').html('<p style="margin: 0px !important;">Failed to Delete data</p>');
					    		$("html,body").animate({scrollTop:$('#action_alert').offset().top-175}, 500);
					    }
					    
					
					    
					   
							
					
		  },
				      
				      error : function(){
				    	 alert(error);
				    
				      }

				  
				  });   
				  
	 }
	 else
	 {
	  return false;
	 }
	
}

function opendeletedocdata(subParaId,docId){
	
	//alert("opendelete"+subParaId);	
	//alert("docId"+docId);		
	
	if(confirm("Are you sure you want to delete. This will delete respective Document ?"))
	 {
		
	 
	 
		
		  $.ajax({	          
				      url: "../parastsimis/delete-doc-by-docid",
				      method:"POST",
				      async: false,
				     
				      data:{
				    	  
				    	  docId:docId
				      },
					 
				      success: function (response) {
				   
				    	//alert("kal"+response);
				    	 
				    	 if(response>0){
				    		 
				    		 
				    		  
					  $('#action_alert').html('<p style="margin: 0px !important;">Data Deleted Successfully</p>');
						$("html,body").animate({scrollTop:$('#action_alert').offset().top-175}, 500);
						
						
					   
						 getDocsBySubParaId(subParaId,1);
						
					    }
					    if(response==0||response==null){
					    	
					    	  $('#action_alert').html('<p style="margin: 0px !important;">Failed to Delete data</p>');
					    		$("html,body").animate({scrollTop:$('#action_alert').offset().top-175}, 500);
					    }
					    
					
					    
					   
							
					
		  },
				      
				      error : function(){
				    	 alert(error);
				    
				      }

				  
				  });   
				  
	 }
	 else
	 {
	  return false;
	 }
	
	
	
	
	
	
}

function newexportaction(e, dt, button, config) {
    var self = this;
    var oldStart = dt.settings()[0]._iDisplayStart;
    dt.one('preXhr', function (e, s, data) {
        // Just this once, load all data from the server...
        data.start = 0;
        data.length = 2147483647;
        dt.one('preDraw', function (e, settings) {
            // Call the original action function
            if (button[0].className.indexOf('buttons-copy') >= 0) {
                $.fn.dataTable.ext.buttons.copyHtml5.action.call(self, e, dt, button, config);
            } else if (button[0].className.indexOf('buttons-excel') >= 0) {
                $.fn.dataTable.ext.buttons.excelHtml5.available(dt, config) ?
                    $.fn.dataTable.ext.buttons.excelHtml5.action.call(self, e, dt, button, config) :
                    $.fn.dataTable.ext.buttons.excelFlash.action.call(self, e, dt, button, config);
            } else if (button[0].className.indexOf('buttons-csv') >= 0) {
                $.fn.dataTable.ext.buttons.csvHtml5.available(dt, config) ?
                    $.fn.dataTable.ext.buttons.csvHtml5.action.call(self, e, dt, button, config) :
                    $.fn.dataTable.ext.buttons.csvFlash.action.call(self, e, dt, button, config);
            } else if (button[0].className.indexOf('buttons-pdf') >= 0) {
                $.fn.dataTable.ext.buttons.pdfHtml5.available(dt, config) ?
                    $.fn.dataTable.ext.buttons.pdfHtml5.action.call(self, e, dt, button, config) :
                    $.fn.dataTable.ext.buttons.pdfFlash.action.call(self, e, dt, button, config);
            } else if (button[0].className.indexOf('buttons-print') >= 0) {
                $.fn.dataTable.ext.buttons.print.action(e, dt, button, config);
            }
            dt.one('preXhr', function (e, s, data) {
                // DataTables thinks the first item displayed is index 0, but we're not drawing that.
                // Set the property to what it was before exporting.
                settings._iDisplayStart = oldStart;
                data.start = oldStart;
            });
            // Reload the grid with the original page. Otherwise, API functions like table.cell(this) don't work properly.
            setTimeout(dt.ajax.reload, 0);
            // Prevent rendering of the full data to the DOM
            return false;
        });
    });
    // Requery the server with the new one-time export settings
    dt.ajax.reload();
}



function gettableexport(iddata){
	
	var idnew="#"+iddata ;
	
	 $(idnew).DataTable( {
		  retrieve: true,
	        dom: 'Bfrtip',
	        responsive: true,
	        "paging": false,
	        "ordering": false,
	        "autoWidth": true,
	        "lengthChange": false,
	        "pageLength": 20,
	        "autoheight": true,
	        buttons: [
	             {
	                extend: 'copyHtml5',
	                text:  'Copy Data',
	               
	            },
	            {
	                extend: 'excelHtml5',
	                autoFilter: true,
	                sheetName: 'Exported_Paras_data',
	                text:  'Save To Excel',
	                className: 'btn-primary ',
	                messageTop: 'Para input Info',
	               
	            },
	            
	            {
	                extend: 'pdfHtml5',
	                className: 'btn-primary ',
	                text:  'PDF View / Download',
	                orientation: 'landscape',
	                pageSize: 'A4',
	                download: 'open',
	                font:'10',
	                filename: 'Para Input Info',
	                title: 'Para Input Info',
	               
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
	            }
	            
	        ],
	        select: true
	       
	    } );
	   

	
}

function getCircles(){
	//alert("kal");
	//var districtId=document.getElementById("districtId").value;
	
	$('#caocircleId').multiselect('rebuild');
	var unitId=document.getElementById("caounitId").value;
	//alert(mandalId);

	  $.ajax({	          
      url: "../task/getCircles?unitId="+unitId,
      type: "GET",
      success: function (response) {
    //	alert(response);
    
    	  var $select = $('#caocircleId');
    	 
		  $select.find('option').remove();
		 // alert("kal1");
		  
		  var obj = JSON.parse(response);
		 // alert("kal2");
		 
		
		  $('#caocircleId').append( '<option value="0"> --select--</option>' );
				
				 
				  
				$.each(obj, function(key, value) {
					
						$('#caocircleId').append( '<option value="'+value.circleId+'" > '+value.circleName+'</option>' );
				
						$('#caocircleId').multiselect('rebuild');
				});
    	 

      },
      error : function(){
    	  alert(error);
      }
  }); 	
}


function getDivisions(){
	//alert("kal");
	//var districtId=document.getElementById("districtId").value;
	var circleId=document.getElementById("caocircleId").value;
	//alert(mandalId);

	  $.ajax({	          
      url: "../web/getDivisions?circleId="+circleId,
      type: "GET",
      success: function (response) {
    	
    	
    	
    	  var $select = $('#caodivisionId');
    	 
		  $select.find('option').remove();
		  
		  var obj = JSON.parse(response);
		
		 
				
				  $('#caodivisionId').append( '<option value="0"> --select--</option>' );
				  
				$.each(obj, function(key, value) {
					
						$('#caodivisionId').append( '<option value="'+value.divisionId+'" > '+value.divisionName+'</option>' );
				
  	  				$('#caodivisionId').multiselect('rebuild');
				});
    	 

      },
      error : function(){
    	  alert(error);
      }
  }); 	
}

function getcaofinYeardata(caounitId,caocircleId,caodivisionId){
	
	var unit=caounitId;
	var circle=caocircleId;
	var division=caodivisionId;
	
	

	//alert(unit+"--"+circle+"--"+division);

	  $.ajax({	          
      url: "../parastsimis/get-cao-fin-year",
      type:"GET",
      async: false,
		data: {
			  
			
			unitId:unit,
			circleId:circle,
			divisionId:division,
			
						
			
		},
      success: function (response) {
    	
    	
    	
    	  var $select = $('#caoyear');
    	 
		  $select.find('option').remove();
		  
		  var obj = JSON.parse(response);
		
		 
				
				  $('#caoyear').append( '<option value="0"> --select--</option>' );
				  
				$.each(obj, function(key, value) {
					
						$('#caoyear').append( '<option value="'+value.financialYear+'" > '+value.financialYear+'</option>' );
				
  	  				$('#caoyear').multiselect('rebuild');
				});
    	 

      },
      error : function(){
    	  alert(error);
      }
  }); 
	
	
	
}
