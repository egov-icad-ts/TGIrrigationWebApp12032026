
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



//alert("kal1");
var rowCount = 0



function removeRow(removeNum) {
	jQuery('#rowCount' + removeNum).remove();
}
	
	
function clicked(){
	
	$("#parasAction").attr('required', '');
	for ( instance in CKEDITOR.instances ){
		
		CKEDITOR.instances[instance].getData();
	//alert("ckeditor values : " + CKEDITOR.instances[instance].getData());
	

	}
	}
</script>




<script type="text/javascript">

$(document).ready(function(){
	
	  $("#toffice").hide();
	/*   $("#pac").hide(); */
	  
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
	
	$('#financialYear').multiselect({
		 
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
	
	
	
	 
	 
	 
	

	}); 

</script>
<script type="text/javascript">

function getCircles(){
	//alert("kal");
	//var districtId=document.getElementById("districtId").value;
	
	$('#circleId').multiselect('rebuild');
	var unitId=document.getElementById("unitId").value;
	//alert(mandalId);

	  $.ajax({	          
      url: "../task/getCircles?unitId="+unitId,
      type: "GET",
      success: function (response) {
    //	alert(response);
    
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
    	 

      },
      error : function(){
    	  alert(error);
      }
  }); 	
}


function getDivisions(){
	//alert("kal");
	//var districtId=document.getElementById("districtId").value;
	var circleId=document.getElementById("circleId").value;
	//alert(mandalId);

	  $.ajax({	          
      url: "../web/getDivisions?circleId="+circleId,
      type: "GET",
      success: function (response) {
    	
    	
    	
    	  var $select = $('#divisionId');
    	 
		  $select.find('option').remove();
		  
		  var obj = JSON.parse(response);
		
		 
				
				  $('#divisionId').append( '<option value="0"> --select--</option>' );
				  
				$.each(obj, function(key, value) {
					
						$('#divisionId').append( '<option value="'+value.divisionId+'" > '+value.divisionName+'</option>' );
				
  	  				$('#divisionId').multiselect('rebuild');
				});
    	 

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



	
</script>




<script>
	

	

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
		 
		/*  $('#sectionId').change(function () {
				
	            if (this.value == '3') {
	            	
	            	 $("#pac").show();
	            	 $("#cag").hide();
	            }
	            if (this.value != '3') {
	            	
	            	 $("#pac").hide();
	            	 $("#cag").show();
	            	
	            }
	        });
		 */
		

   	  /*       var $selectstatus = $('#paraStatusId'); */
   	 
		
		
		 
		 /* $("#sectionId").change(function() {
			
			  var id = $(this).val();
			 // alert(id);
			  
			  
			  if(id=='3'){
				  
				 // alert("kal1");
				  
				  $selectstatus.find('option').remove();
				  $('#paraStatusId').append( '<option value=" "> --select--</option>' );
				  $('#paraStatusId').append( '<option value="2"> Reply not sent </option>' );
				  $('#paraStatusId').append( '<option value="3"> Dropped </option>' );
				  $('#paraStatusId').append( '<option value="4"> Reply sent to Government </option>' );
				  
				  $('#paraStatusId').multiselect('rebuild');
			     
				  
			  }
			  
             if(id!='3'){
            	 
            	 // alert("kal2");
				  
				  $selectstatus.find('option').remove();
				  
				  $('#paraStatusId').append( '<option value=" "> --select--</option>' );
				 
				  $('#paraStatusId').append( '<option value="1"> Reply sent to AG </option>' );
				  $('#paraStatusId').append( '<option value="2"> Reply not sent </option>' );
				  $('#paraStatusId').append( '<option value="3"> Dropped </option>' );
				  
				  $('#paraStatusId').multiselect('rebuild');
				  
			     
				  
			  }
			  
			});
		 
		 */
		 
		//    
		var m = $(this).find('.ckedit')
		m.ckeditor();

		//alert("coming here")
		$('.ckedit').ckeditor();
		clicked();
		
		

		/*  var count = 0;

		 $('#user_dialog').dialog({
		  autoOpen:false,
		  width:800
		 }); */

		/*  $('#add').click(function(){
		  $('#user_dialog').dialog('option', 'title', 'Add Para'); */
		  
         // rowctr = $('#para_data').rowCount();
            //  alert("ctr"+rowctr);
		/* 
			  $('#add').prop('disabled', true);   */
		  
		 
		  
		  
		  
		 /*  $('#actionTitle').val('');
		  $('#parasAction').val('');
		 /*  $('#remarks').val(''); */
		 
		 
		 /*  $('#error_title').text('');
		  $('#error_parasaction').text(''); */
		/*   $('#error_remarks').text(''); */
		  
		  
		/*   $('#actionTitle').css('border-color', '');
		  $('#parasAction').css('border-color', ''); */
		 /*  $('#remarks').css('border-color', ''); */
		  
		/*   $('#save').text('Save');
		  $('#user_dialog').dialog('open'); */
		  
		  
		  
		  
		/*  }); 

		 $('#save').click(function(){
		  var error_title = '';
		  var error_parasaction = ''; */
		 /*  var error_remarks = ''; */
		 
		  
		/*   var actionTitle = '';
		  var parasAction = ''; */
		/*   var remarks = ''; */
		  
		 
		 /*  if($('#actionTitle').val() == '')
		  {
			  error_title = 'actionTitle required ';
		   $('#error_title').text(error_title);
		   $('#actionTitle').css('border-color', '#cc0000');
		   actionTitle = '';
		  }
		  else
		  {
			  error_title = '';
		   $('#error_title').text(error_title);
		   $('#actionTitle').css('border-color', '');
		   actionTitle = $('#actionTitle').val();
		  } 
		  if($('#parasAction').val() == '')
		  {
			  error_parasaction = 'parasaction is required';
		   $('#error_parasaction').text(error_parasaction);
		   $('#parasAction').css('border-color', '#cc0000');
		   parasAction = '';
		  }
		  else
		  {
			  error_parasaction = '';
		   $('#error_parasaction').text(error_parasaction);
		   $('#parasAction').css('border-color', '');
		   parasAction = $('#parasAction').val(); */
		   
		  // alert("kal"+parasAction);
		/*   } */
		 /*  if($('#remarks').val() == '')
		  {
			  error_remarks = 'remarks is required';
		   $('#error_remarks').text(error_remarks);
		   $('#remarks').css('border-color', '#cc0000');
		   remarks = '';
		  }
		  else
		  {
			  error_remarks = '';
		   $('#error_remarks').text(error_remarks);
		   $('#remarks').css('border-color', '');
		   remarks = $('#remarks').val();
		   
		  // alert("rem"+remarks);
		  } */
		 
		 /*  if(error_title != '' || error_parasaction != '' )
		  {
		   return false;
		  }
		  else
		  {
			  
			 
		   if($('#save').text() == 'Save' )
		   { */
			  
			  // alert("savepara");
		   // output = '<tr id="hidden_row_'+count+'">';
		 /*    output += '<td>'+count+' </td>'; */
		   // output += '<td>'+actionTitle+' <input type="hidden" name="paraDataList['+count+'].actionTitle" id="actionTitle'+count+'" class="form-control actionTitle" value="'+actionTitle+'" /></td>';
		  //  output += '<td>'+parasAction+' <textarea style="display:none;" class="ckedit form-control "  name="paraDataList['+count+'].parasAction" id="parasAction'+count+'"  >'+parasAction+'</textarea> </td>';
		  /*   output += '<td>'+remarks+' <textarea style="display:none;" class="ckedit form-control "  name="paraDataList['+count+'].remarks" id="remarks'+count+'" class="remarks'+count+'"  >'+remarks+'</textarea> </td>'; */
		   
		    
		  //  output += '<td><button type="button" name="view_details" class="btn btn-warning btn-xs view_details" id="'+count+'">View</button></td>';
		  //  output += '<td><button type="button" name="remove_details" class="btn btn-danger btn-xs remove_details" id="'+count+'">Remove</button></td>';
		  //  output += '</tr>';
		   
		   // count = count + 1;
		 //   $('#para_data').append(output);
		//   }
		 //  else
		 //  {
			   
			  // alert("elsepara");
			   
		  //  var row_id = $('#hidden_row_id').val();
		 /*    output += '<td>'+row_id+' </td>'; */
		 //    output = '<td>'+actionTitle+' <input type="hidden" name="paraDataList['+row_id+'].actionTitle" id="actionTitle'+row_id+'"  class="form-control actionTitle" value="'+actionTitle+'" /></td>'; 
		 //   output += '<td>'+parasAction+'<textarea style="display:none;" class="ckedit form-control "  name="paraDataList['+row_id+'].parasAction" id="parasAction'+row_id+'" >'+parasAction+'</textarea> </td>';
		  /*   output += '<td>'+remarks+'<textarea style="display:none;" class="ckedit form-control "  name="paraDataList['+row_id+'].remarks" id="remarks'+row_id+'"  >'+remarks+'</textarea> </td>'; */
		   
		 //   output += '<td><button type="button" name="view_details" class="btn btn-warning btn-xs view_details" id="'+row_id+'">View</button></td>';
		 //   output += '<td><button type="button" name="remove_details" class="btn btn-danger btn-xs remove_details" id="'+row_id+'">Remove</button></td>';
		 //   $('#hidden_row_'+row_id+'').html(output);
		//   } 

		//   $('#user_dialog').dialog('close');
		//  }
		// });

		/*  $(document).on('click', '.view_details', function(){
		  var row_id = $(this).attr("id");
		//  alert("kal"+row_id);
		  var actionTitle = $('#actionTitle').val();
		  var parasAction = $('#parasAction').val();
		/*   var remarks = $('#remarks').val(); */
		 
		 
		/*   $('#actionTitle').val(actionTitle);
		  $('#parasAction').val(parasAction); */
		/*   $('#remarks').val(remarks); */
		 
		  //alert("1"+actionTitle);
		 // alert("2"+parasAction);
		 // alert("3"+remarks);
		  
		  
		/*   $('#save').text('Edit');
		  $('#hidden_row_id').val(row_id);
		  $('#user_dialog').dialog('option', 'title', 'Edit Para Data');
		  $('#user_dialog').dialog('open');
		 });
 */ 
		/*  $(document).on('click', '.remove_details', function(){
			 
			
		  var row_id = $(this).attr("id");
		 // alert("row_id"+row_id);
		  if(confirm("Are you sure you want to remove this Para data?"))
		  {
			  $('#add').prop('disabled', false);   
		   $('#hidden_row_'+row_id+'').remove();
		  }
		  else
		  {
		   return false;
		  }
		 });

		 $('#action_alert').dialog({
		  autoOpen:false
		 }); */

		 /* $('#user_form').on('submit', function(event){
		  event.preventDefault();
		  var count_data = 0;
		  $('.actionTitle').each(function(){
		   count_data = count_data + 1;
		  });
		  if(count_data > 0)
		  {
		   var form_data = $(this).serialize();
		   alert("form"+form_data); */
	/* 	   $.ajax({
		    url:"../comptsimis/getLiftCompInput",
		    method:"POST",
		    data:form_data,
		    success:function(data)
		    {
		     $('#para_data').find("tr:gt(0)").remove();
		     $('#action_alert').html('<p>Data Inserted Successfully</p>');
		     $('#action_alert').dialog('open');
		    }
		   }) */
		   
		   
		   /* document.forms.user_form.action = "../comptsimis/getLiftCompInput";
			document.forms.user_form.submit();
		  }
		  else
		  {
		   $('#action_alert').html('<p>Please Add atleast one data</p>');
		   $('#action_alert').dialog('open');
		  }
		 }); */
		
		
		
		 
		 
		 
		 var replycount = 0;

		 $('#reply_dialog').dialog({
		  autoOpen:false,
		  width:800
		 });

		 $('#reply').click(function(){
		  $('#reply_dialog').dialog('option', 'title', 'Add Reply Data');
		  
		
		  $('#replyDate').val('0'); 
		  $('#replyAction').val('');
		  $('#replyRemarks').val('');
		 
		 
		   $('#error_replyDate').text(''); 
		  $('#error_replyAction').text('');
		  $('#error_replyremarks').text('');
		 
		
		  
		   $('#replyDate').css('border-color', ''); 
		  $('#replyAction').css('border-color', '');
		  $('#replyRemarks').css('border-color', '');
		  
		
		  $('#savereply').text('Save');
		  $('#reply_dialog').dialog('open');
		 });

		 $('#savereply').click(function(){
		  var error_replylatest = ''; 
		  var error_replyAction = '';
		  var error_replyRemarks= '';
		 
		  
		   var replyDate = '0'; 
		  var replyAction = '';
		  var replyRemarks = '';
		 
		 
		   if($('#replyDate').val() == '0')
		  {
			  error_replyDate = 'reply Date is required';
		   $('#error_replyDate').text(error_replyDate);
		   $('#replyDate').css('border-color', '#cc0000');
		   replyDate = '0';
		  // alert("kal"+replylatest);
		  }
		  else
		  {
			  
			  var rlatest=$('#replyDate').val();
			 // alert("rlatest"+rlatest);
			  error_replyDate = '';
		   $('#error_replyDate').text(error_replyDate);
		   $('#replyDate').css('border-color', '');
		   replyDate = rlatest;
		  }  
		  if($('#replyAction').val() == '')
		  {
			  error_replyAction = 'replyAction is required';
		   $('#error_replyAction').text(error_replyAction);
		   $('#replyAction').css('border-color', '#cc0000');
		   replyAction = '';
		  }
		  else
		  {
			  error_replyAction = '';
		   $('#error_replyAction').text(error_replyAction);
		   $('#replyAction').css('border-color', '');
		   replyAction = $('#replyAction').val();
		  }
		   if($('#replyRemarks').val() == ' ')
		  {
			  error_replyRemarks = 'Remarks is required';
		   $('#error_replyRemarks').text(error_replyRemarks);
		   $('#replyRemarks').css('border-color', '#cc0000');
		   replyRemarks = '';
		  }
		  else
		  {
			  error_replyRemarks = ' ';
		   $('#error_replyRemarks').text(error_replyRemarks);
		   $('#replyRemarks').css('border-color', '');
		   replyRemarks = $('#replyRemarks').val();
		  } 
		 
		  if(error_replyAction != ''&& error_replyDate!='0' )
		  {
		   return false;
		  }
		  else
		  {
			  
			 
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
		    $('#reply_data').append(replyoutput);
		   }
		   else
		   {
			   
			   //alert("else trply");
		    var replyrow_id = $('#replyrow_id').val();
		  //  alert(replyAction);
		  //  alert(replyRemarks);
		  //  alert(replyDate);
		      
		   
		    
		    replyoutput = '<td>'+replyAction+' <textarea style="display:none"  name="replyDataList['+replyrow_id+'].replyAction" id="replyAction'+replyrow_id+'"  >'+replyAction+'</textarea></td>';
		   
		    replyoutput += '<td>'+replyRemarks+' <textarea style="display:none" name="replyDataList['+replyrow_id+'].replyRemarks" id="replyRemarks'+replyrow_id+'"  >'+replyRemarks+'</textarea></td>';
		   
		    replyoutput += '<td>'+replyDate+'  <input type="hidden" class="replynew" name="replyDataList['+replyrow_id+'].replyDate" id="replyDate'+replyrow_id+'"      value="'+replyDate+'"  required ></td>';
		 
		    replyoutput += '<td><button type="button" name="replyview_details" class="btn btn-warning btn-xs replyview_details" id="'+replyrow_id+'">View</button></td>';
		    replyoutput += '<td><button type="button" name="replyremove_details" class="btn btn-danger btn-xs replyremove_details" id="'+replyrow_id+'">Remove</button></td>';
		  
		  
		   
		    $('#replyrow_'+replyrow_id+'').html(replyoutput);
		   }

		  
		 /*   $('.replynew').each(function(){
				alert("kal");
				  if($(this).find('input[type="radio"]:checked').val()==true)
				    {
				       alert("checked");
				    }
				  if($(this).find('input[type="radio"]:checked').val()==false)
				    {
				       alert("not checked");
				    }    
				});	 */
		   
		   
		   $('#reply_dialog').dialog('close');
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
		     // alert("kal4"+replyDate);
		 //  $('input:radio[name=replylatest][value='+replylatest+']').attr('checked', true);
		
		  $('#replyAction'+replyrow_id+'').val(replyAction);
		  $('#replyRemarks'+replyrow_id+'').val(replyRemarks);
		  $('#replyDate'+replyrow_id+'').val(replyDate); 
		 
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

		/*  $('#user_form').on('submit', function(event){
		  event.preventDefault();
		  var count_data = 0;
		  $('.deviceName').each(function(){
		   count_data = count_data + 1;
		  });
		  if(count_data > 0)
		  {
		   var form_data = $(this).serialize();
		   alert("form"+form_data);
		   $.ajax({
		    url:"../comptsimis/getLiftCompInput",
		    method:"POST",
		    data:form_data,
		    success:function(data)
		    {
		     $('#user_data').find("tr:gt(0)").remove();
		     $('#action_alert').html('<p>Data Inserted Successfully</p>');
		     $('#action_alert').dialog('open');
		    }
		   }) 
		   
		   
		   document.forms.user_form.action = "../comptsimis/getLiftCompInput";
			document.forms.user_form.submit();
		  }
		  else
		  {
		   $('#action_alert').html('<p>Please Add atleast one data</p>');
		   $('#action_alert').dialog('open');
		  }
		 }); */

		
		
		
		

	   

		
	});

	
	
	  
	 
		 

	
	
	

</script>



	
						

<div class="col-md-9">
	


<div>






						<div class="panel panel-primary ">
							<div class="panel-heading">
								<h3 class="panel-title">Add Para & Reply 
								
							<c:if test="${userObj!=null}">	
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
			 
	</div></c:if> &emsp;&emsp;</h3>
							</div>
							<div class="panel-body">
							<c:if test="${msg!=null || err!=null }">


							<div >
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
							
				 <div class="alert alert-info col-md-12"  style="padding: 0px" id="action_replyalert" title="Action">

  </div>	
							<form:form id="parasinput" method="post" modelAttribute="irparas"
								data-parsley-validate-if-empty=""  enctype="multipart/form-data" >
					   &emsp;&emsp;   &emsp;&emsp;			
<div class="col-md-12 invDiv">								

<div class="col-md-6">
										

                                  


											<div class="col-md-6">
												<label class="label-controlPMS rowlebel ">Select Unit  <font color=red>*</font> 
													</label></div>
													
													<div class="col-md-6">
													<select class="form-control" id="unitId" name="unitId"  onchange="getCircles()" required>
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
												<select class="form-control" id="circleId" name="circleId" 
													 onchange="getDivisions()">
													<option value="0">--select--</option>
													


												</select>

											</div>
										
											


											<div class="col-md-6">
												<label class="label-controlPMS rowlebel ">Select Division</label>
												</div>
												<div class="col-md-6">
												<select class="form-control" id="divisionId" name="divisionId" onchange="getSubDivisions()">
	</select>
											</div>
											
											
											
											
                             
												<div class="col-md-6">
												<label class="label-control rowlebel ">Select SubDivision
													</label></div>
													<div class="col-md-6">
														<select class="form-control" id="subdivisionId" name="subdivisionId"  
													>
													


												</select>
													
											</div>
											
										
										<div class="col-md-6">
											<label class="label-control rowlebel ">Financial Year <font color=red>*</font> </label>
											</div>
											
											<div class="col-md-6">
											 <select class="form-control" id="financialYear" name="financialYear" required> 
											 <option value=" ">--select--</option>
											
											 </select></div> 
											 
											 
										    	<div class="col-md-6">
										    <label class="label-controlPMS rowlebel ">
										    Para Number  <font color=red>*</font>  </label>
										    </div>
										    <div class="col-md-6">
										    <select class="form-control" id="paraNumber" name="paraNumber"  required>
										     <option value=" ">--select--</option> 
										     <option value="I">I</option> 
										     <option value="II">II</option> 
										     <option value="III">III</option>
										      <option value="IV">IV</option>
										      <option value="V">V</option>
										      <option value="VI">VI</option>
										      <option value="VII">VII</option>
										      <option value="VIII">VIII</option>
										      <option value="IX">IX</option>
										      <option value="X">X</option>
										      <option value="XI">XI</option>
										      <option value="XII">XII</option>
										      </select> </div>
										      
										      
											 
											 
											  <div class="col-md-6">
											 <label class="label-control rowlebel ">File No.  </label>
											 </div>
											 
											 <div class="col-md-6">
											  <input type="text" class=" form-control"  id="fileNumber" name="fileNumber" placeholder="Ex:9-40/08-09(AG File)"  /> 
											  </div>
											  
											   <div class="col-md-6">
											 <label class="label-control rowlebel ">LAR No.  </label>
											 </div>
											 
											 <div class="col-md-6">
											  <input type="text" class=" form-control"  id="larNumber" name="larNumber" placeholder="Ex:183/08-09"  /> 
											  </div>
											 
											 
										
											 
											 
											  <div class="col-md-6">
										<label class="label-controlPMS rowlebel ">
										Select Section <font color=red>*</font> </label>
										</div>
										
										 <div class="col-md-6">
										<select class="form-control" id="sectionId" name="sectionId" required> 
										<option value=" ">--select--</option>  
										<option value="1">Section-A</option>
										<option value="2">Section-B</option>
										<!-- <option value="3">CAG Report</option> -->
										
										</select> </div>
										
										
										
										
										      
										      
										        <div class="col-md-6">
										<label class="label-controlPMS rowlebel ">
										Select Para Status  <font color=red>*</font>  </label>
										</div>
										<div class="col-md-6">
										<select class="paratrunit form-control" id="paraStatusId" name="paraStatusId"  required> 
										<option value=" ">--select--</option> 
										 <option value="1">Reply Sent to AG</option>
									    <option value="2">Reply Not Sent</option> 										
									
										<option value="3">Dropped</option> 
									   <!--   <option value="4">Reply Sent to Government</option>  -->
									     
										 </select>
									     </div>
								
										
											</div>
											
											 <div class="col-md-6">
										
									      
										
										
									
										
										<div class="col-md-6">
											 <label class="label-control rowlebel ">Date of Audit <font color=red>*</font> </label>
											 </div>
											 
											 <div class="col-md-3">
											 <label class="label-control rowlebel ">from</label>
											  <input type="text" class="datepick form-control datepicker"  id="auditDateFrom" name="auditDateFrom" placeholder="auditDateFrom"  readonly="readonly" value="0" required/> 
											  </div>
											  
											   <div class="col-md-3">
											   <label class="label-control rowlebel ">to</label>
											  <input type="text" class="datepick form-control datepicker"  id="auditDateTo" name="auditDateTo" placeholder="auditDateto"  readonly="readonly" value="0"  /> 
											  </div>
										
											
											 
											 
											 
											 
											
											
										
										  
										 




																						
										
													
											
											

											<!--  <div class="col-md-6" id="pac" >
										 <label class="label-controlPMS rowlebel ">Discussed in PAC <font color=red>*</font> </label>
										 </div> -->
						
						
										
									
										
											   <div class="col-md-6" id="cag" >
										 <label class="label-controlPMS rowlebel ">Printed in CAG Report <font color=red>*</font> </label>
										 </div>
									<!-- 	<div class="  col-md-6"> -->
						<!-- 	<div class="form-group"> -->
      
        <div class="col-md-6" id="statusdiv">
       
        
        <label class="radio-inline"> <input type="radio" name="printCAG" id="printCAG"  checked="checked"    value="false"  required >NO</label>
        <label class="radio-inline"> <input type="radio" name="printCAG" id="printCAG"     value="true"  required >Yes</label>
       
       
        
       
       
          
         
        </div>
        <div class="col-md-12">
           <div class="col-md-6" id="inclproposed" >
										 <label class="label-controlPMS rowlebel ">Inclusion of Proposals in CAG Report <font color=red>*</font> </label>
										 </div>
										 
										   
        <div class="col-md-6" id="inclproposeddiv">
       
        
        <label class="radio-inline"> <input type="radio" name="inclPropCAG" id="inclPropCAG"  checked="checked"    value="false"  required >NO</label>
        <label class="radio-inline"> <input type="radio" name="inclPropCAG" id="inclPropCAG"     value="true"  required >Yes</label>
       
       
        
       
       
          
         
        </div>
        
        </div>
        
   <!--  </div> -->
					<!-- 	</div> -->
						
						
						<!--  <div class="col-md-6"  >
										 <label class="label-controlPMS rowlebel ">Transferred to Other Office<font color=red>*</font> </label>
										 </div>
						 -->
					<!-- 	<div class=" col-md-6"> -->
						<!-- 	<div class="form-group"> -->
      
       <!--  <div class="col-md-6" >
       
        
        <label class="radio-inline"> <input type="radio" name="transferFlag" id="transferFlag"  checked="checked"    value="false"  required >NO</label>
        <label class="radio-inline"> <input type="radio" name="transferFlag" id="transferFlag"     value="true"  required >Yes</label>
       
       
        
       
       
          
         
        </div>
    </div> -->
					<!-- 	</div> -->
						
			<%-- 			<div class="col-md-12" id="toffice">
			
						<div class="col-md-6">
												<label class="label-controlPMS rowlebel ">Transferred
													Unit</label>
													
													</div>
													<div class="col-md-6">
													<select class="form-control" id="tunitId" name="tunitId"  onchange="gettCircles()">
											<option value="0">--select--</option>
												
												 <c:forEach items="${unitList}" var="u">
									              <option value="${u.unitId}">${u.unitName}</option>

								</c:forEach>
 
												
												
												</select>
											</div>
										

											
											
												<div class="col-md-6">
												<label class="label-control rowlebel ">Transferred Circle</label>
												</div>
												<div class="col-md-6">
												<select class="form-control" id="tcircleId" name="tcircleId"  onchange="gettDivisions()"
													>
													<option value="0">--select--</option>
													


												</select>

											</div>
										
											


											<div class="col-md-6">
												<label class="label-controlPMS rowlebel ">Transferred Division</label>
												</div>
												
												<div class="col-md-6">
												<select class="form-control" id="tdivisionId" name="tdivisionId" onchange="gettSubDivisions()"		>
	</select>
											</div>
											
											
												<div class="col-md-6">
												<label class="label-control rowlebel ">Transferred Sub Division
													</label>
													</div>
													
													<div class="col-md-6">
														<select class="form-control" id="tsubdivisionId" name="tsubdivisionId" 
													>
													


												</select>
													
											</div>				
						
						
						</div>
						 --%>
						
						
						
						
									
									
									
											   <div class="col-md-6"  >
										 <label class="label-controlPMS rowlebel ">Upload Files(Multiple)</label>
										 </div>
										 
										  <div class="col-md-6"  >
								<input id="uploadFile" name="uploadFile" type="file" 	class="btn-info" value="Upload Documents"  multiple="multiple"    data-parsley-max-file-size="1024"  data-parsley-fileextension='pdf'> 
							</div>
										
										
										
										
									
									
									

									</div>
									
									
			
								
									
									

	</div>			
	
								<div class="col-md-12" class="invDiv" >

	<div class="col-md-6"  >
											 <label class="label-controlPMS rowlebel ">Add Reply</label>
											 </div>
											 <div class="col-md-6" style="text-align: center;" >
											  <button type="button" name="reply" id="reply" class="btn btn-primary" >Add Reply</button>
											 </div>
											 </div>				
								

									


											 
											 			
								
								
	<div class="col-md-12">
	
	
&emsp;&emsp;
  <div class="table-responsive">
     <table class="table table-striped table-bordered" id="para_data">
     
      <tbody>
    
      
      <tr>
      
      <td style=" color: red;text-align: center;">
        <label class="label-control rowlebel" >Gist of Para*</label> 
      
      <textarea class="form-control "  id="paraDataList[0].actionTitle" name="paraDataList[0].actionTitle" rows="10" cols="80" placeholder="Para"    required> </textarea>
       </td>
        <td style="color: red;text-align: center;">
        	<label class="label-control rowlebel " >Para*</label> 
	<textarea class="ckedit form-control "  id="parasAction" name="paraDataList[0].parasAction" rows="10" cols="80" placeholder="Para" 
	data-parsley-errors-container="#purpose-errors" data-parsley-required-message="Please Enter Para Information!" data-parsley-group="block1"></textarea>
     
       </td>
      
        
      </tr>
        <tr> <td></td> <td style="margin-bottom: 20px;color: red; text-align: center;" id="purpose-errors"></td></tr>
      
      
      </tbody>
     </table>
    </div>
      </div>



      
      <div class="col-md-12">
<br></br>
  <div class="table-responsive">
     <table class="table table-striped table-bordered" id="reply_data">
      <tr style="color: blue; ">
    
      
       <th style="text-align: center;"><b>Reply</b></th>
       <th style="text-align: center;"><b>Remarks</b></th>
        <th style="text-align: center;"><b>Reply Date</b></th>
       <th style="text-align: center;"><b>Edit</b></th>
        <th style="text-align: center;"><b>Delete</b></th>
    
      </tr>
     </table>
    </div>
      </div>
   




								


									<div class="col-sm-12">
										<div class="col-md-2 "></div>
										<div class="col-md-8 ">
											<label class="label-control rowlebel "></label><input
												type="submit" class="btn btn-1 btn-primary center-block"
												id="submitparas" value="Submit IRParas">
										</div>
									</div>







							




							</form:form>
							</div>
							

						</div>


 </div> 
 

  
  </div>							
							 <div id="reply_dialog" title="Reply Data" class="col-md-12">
   <div class="form-group">
     <div class="col-md-6">
     <label class="label-controlPMS rowlebel "> Reply Date<font color=red>*</font> </label>
	</div>
	 <div class="col-md-6">
        <input type="text" name="replyDate" id="replyDate" class=" datepick form-control datepicker"  value="0"  readonly="readonly"   required />
       
       </div>
     				
										
    <span id="error_replyDate" class="text-danger"></span>
   </div> 
   <div class="form-group">
   	<label class="label-control rowlebel ">Reply*</label> 
	<textarea class="ckedit form-control "  id="replyAction" name="replyAction" rows="10" cols="80" placeholder="Reply"  ></textarea>
    <span id="error_replyAction" class="text-danger"></span>
   </div>
    <div class="form-group">
    <label class="label-control rowlebel ">Reply Remarks*</label>
<textarea class="form-control"  id="replyRemarks" name="replyRemarks"  rows="10" cols="80" placeholder="Reply Remarks"  ></textarea> 
    <span id="error_replyRemarks" class="text-danger"></span>
   </div>
  
   <div class="form-group" align="center">
    <input type="hidden" name="replyrow_id" id="replyrow_id" />
    <button type="button" name="savereply" id="savereply" class="btn btn-info">Save</button>
   </div>
  </div>


						



<!-- //main-content -->
<script type="text/javascript" src="../js/parsley.js"></script>



<script type="text/javascript" class="example">
	$(function() {
		$('#parasinput').parsley().on('field:validated', function() {
			var ok = $('.parsley-error').length === 0;

			

		})
			
	
		.on('submit', function(event) {
			// alert("coming here");
         // alert('kal');
			 event.preventDefault();
			// alert('hi');
		  var count_data = 0;
		  $('.actionTitle').each(function(eve){
		   count_data = count_data + 1;
		  });
		  if(count_data > 0)
		  {
			
		   var form_data = $(this).serialize();
		 //  alert("form"+form_data);
		 
		   
		  /*  document.forms.parasinput.action = "../parastsimis/addPara";
			document.forms.parasinput.submit(); */
		  }
		  else
		  {
			  event.preventDefault();
		   $('#action_alert').html('<p>Please Add atleast one data</p>');
		   $('#action_alert').dialog('open');
		 
		  }
		  return false;	
			// Don't submit form for this demo
		});
	});
	
	 window.Parsley.addValidator('maxFileSize', {
		  validateString: function(_value, maxSize, parsleyInstance) {
		   /*  if (!window.FormData) {
		      alert('formdata');
		      return true;
		    } */
		    var files = parsleyInstance.$element[0].files;
		    alert("files.length "+files.length );
		    var imageSizeArr = 0;
		    var totalfilesize=0;
		   var  mxfilesize= maxSize * 1024;
		    for (var i = 0; i < files.length; i++){
		        var imageSize = files[i].size;
		     
		        alert("imageSize"+imageSize);
		        alert("maxSize"+maxSize);
		      
		         totalfilesize=totalfilesize+imageSize;
		         
		         alert("mxfilesize"+mxfilesize);
			        
			        alert("totalfilesize"+totalfilesize);
		        
		        if (totalfilesize > mxfilesize ){
		        	alert("kal"+i);
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
		
	/* window.ParsleyValidator
	.addValidator('fileextension', function (value, requirement) {
		//alert(value);
	    var fileExtension1 = value.split('.');
	  
	    var len=fileExtension1.length ;
	 
	  var fileExtension2 =null;
	  if(len===2){
	    
		  fileExtension2 = fileExtension1.pop();
	  }
	  if(len!=2){
		  fileExtension2 = "notallowed";
		  
	  }
	    
	   // alert("fileExtensionhere"+fileExtension2);
	    
	    return fileExtension2 === requirement;
	}, 32)
	.addMessage('en', 'fileextension', 'The extension doesn\'t match the .pdf');  */
	


</script>

