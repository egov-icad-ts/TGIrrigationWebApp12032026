
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
	  
	  var d = new Date();
	  var e=new Date();
	 e= e.getFullYear() - 39;
	  var j=00;
	  
	  var selectedFinancialYear=$('#hiddenFinancialYear').val();  
		
		   
      for (var i = 40; i >= 0; i--) {
    	 // alert(i); 
    	 var ye=parseInt(d.getFullYear() - i) +"-"+e ;
    	 
    	
    	 
    	 if(selectedFinancialYear==ye){
          var option = "<option value=" + parseInt(d.getFullYear() - i) +"-"+e+ "    selected >" + parseInt(d.getFullYear() - i) +"-"+e+ "</option>"
         // alert(option);
    	 }
    	 if(selectedFinancialYear!=ye){
    		 var option = "<option value=" + parseInt(d.getFullYear() - i) +"-"+e+ "     >" + parseInt(d.getFullYear() - i) +"-"+e+ "</option>" 
    		 
    	 }
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
<script>
    window.onunload = refreshParent;
    function refreshParent() {
    	 self.close();
       window.opener.location.reload(true);
       
    }
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
		  
		 
		  var selectedCircle=$('#hiddenCircleId').val();
		  
		  var obj = JSON.parse(response);
		 // alert("kal2");
		 
		
		  $('#circleId').append( '<option value="0"> --select--</option>' );
				
				 
				  
				$.each(obj, function(key, value) {
					
					if(selectedCircle==value.circleId){
					
						$('#circleId').append( '<option value="'+value.circleId+'" selected="selected"> '+value.circleName+'</option>' );
						
				}
				
				if(selectedCircle==null||selectedCircle!=value.circleId){
					
					$('#circleId').append( '<option value="'+value.circleId+'" > '+value.circleName+'</option>' );
					
				}
				
						$('#circleId').multiselect('rebuild');
				});
    	 

      },
      error : function(){
    	  alert(error);
      }
  }); 	
}


function getDivisions(circleId){
	//alert("kal");
	//var districtId=document.getElementById("districtId").value;
	var circleId=circleId
		
		//document.getElementById("circleId").value;
	//alert(mandalId);

	  $.ajax({	          
      url: "../web/getDivisions?circleId="+circleId,
      type: "GET",
      success: function (response) {
    	
    	
    	
    	  var $select = $('#divisionId');
    	 
		  $select.find('option').remove();
		  
		  var selectedDivision=$('#hiddenDivisionId').val();
		  
		  var obj = JSON.parse(response);
		
		 
				
				  $('#divisionId').append( '<option value="0"> --select--</option>' );
				  
				$.each(obj, function(key, value) {
					
					if(selectedDivision==value.divisionId){
					
						$('#divisionId').append( '<option value="'+value.divisionId+'" selected="selected"> '+value.divisionName+'</option>' );
						
					}
					if(selectedDivision==null || selectedDivision!=value.divisionId){
						
						$('#divisionId').append( '<option value="'+value.divisionId+'" > '+value.divisionName+'</option>' );
						
					}
				
  	  				$('#divisionId').multiselect('rebuild');
				});
    	 

      },
      error : function(){
    	  alert(error);
      }
  }); 	
}


function getSubDivisions(divisionId){
	//alert("kal");
	//var districtId=document.getElementById("districtId").value;
	var divisionId=divisionId;
		
		//document.getElementById("divisionId").value;
	//alert(mandalId);

	  $.ajax({	          
      url: "../web/getSubDivisions?divisionId="+divisionId,
      type: "GET",
      success: function (response) {
    	
    	
    	
    	  var $select = $('#subdivisionId');
    	 
		  $select.find('option').remove();
		  
		 
		  var selectedSubDivision=$('#hiddenSubdivisionId').val();
		 
				var obj = JSON.parse(response);
				  $('#subdivisionId').append( '<option value="0"> --select--</option>' );
				  
				$.each(obj, function(key, value) {
					
					if(selectedSubDivision==value.subdivisionId){
					
						$('#subdivisionId').append( '<option value="'+value.subdivisionId+'" selected="selected"> '+value.subdivisionName+'</option>' );
					}
					
					if(selectedSubDivision==null || selectedSubDivision!=value.subdivisionId){
						
						$('#subdivisionId').append( '<option value="'+value.subdivisionId+'" > '+value.subdivisionName+'</option>' );
					}
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


function gettDivisions(tcircleId){
	//alert("kal");
	//var districtId=document.getElementById("districtId").value;
	var circleId=tcircleId
		//document.getElementById("tcircleId").value;
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


function gettSubDivisions(tdivisionId){
	//alert("kal");
	//var districtId=document.getElementById("districtId").value;
	var divisionId=tdivisionId;
		//document.getElementById("tdivisionId").value;
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
		
		
		 $('input:radio[name=transferFlag]').change(function () {
				
	            if (this.value == 'true') {
	            	
	            	//alert("coming");
	            	
	            	 $("#toffice").show();
	            }
	            if (this.value == 'false') {
	            	
	            	//alert("coming false");
	            	
	            var selunit=	$("#tunitId option:selected").text()
	          //  alert(selunit);
	          
	             $("#tunitId option:selected").removeAttr('selected')
	               $("#tunitId option:selected").text('0')
	                 $("#tunitId option[text='']").remove()
	                   var selunit=	$("#tunitId option:selected").text()
	           // alert(selunit);
	            	$("#tcircleId").val(0);
	            	$("#tdivisionId").val(0);
	            	$("#tsubdivisionId").val(0);
	            	
	            	$("#toffice").hide();
	            }
	        });
		
		 
		 var cm =$('input:radio[name=transferFlag]:checked').val();
		// alert("cm"+cm);
		 
	            if (cm == 'true') {
	            	 $("#toffice").show();
	            }
	            if (cm == 'false') {
	            	$("#toffice").hide();
	            }
	       
		
		
		var myunit= parseInt($("#unitId").val()); 
		if(myunit!=null && myunit>0){
			//alert(myunit+"myunit");
			getCircles();	
			
			
			var mycir= parseInt($("#hiddenCircleId").val()); 
			//alert("m"+myproj);
			var m=mycir;
			if(m!=null && m>0){
				//alert(myproj+"myproj");
				getDivisions(m);
				
				var mydiv= parseInt($("#hiddenDivisionId").val()); 	
				var n=mydiv;
				if(n!=null && n>0){
					
					getSubDivisions(n);
					
					
				}
				
				
				
			}
			
			
				
				
			
		}
		
		var trunit= parseInt($("#tunitId").val()); 
		if(trunit!=null && trunit>0){
			//alert(myunit+"myunit");
			gettCircles();	
			
			
			var trcir= parseInt($("#hiddenTrCircleId").val()); 
			//alert("m"+myproj);
			var ab=trcir;
			if(ab!=null && ab>0){
				//alert(myproj+"myproj");
				gettDivisions(m);
				
				var trdiv= parseInt($("#hiddenTrDivisionId").val()); 	
				var mn=trdiv;
				if(mn!=null && mn>0){
					
					gettSubDivisions(mn);
					
					
				}
				
				
				
			}
			
			
				
				
			
		}
		
		
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
		
		
		/*  
		 $("#paraStatusId").change(function(){
				//alert("kalres");

			var myunittr= parseInt($(this).val()); 
			//alert(myunittr);
			if(myunittr==3){
				
				 $("#toffice").show();
				
			}else{
				$("#toffice").hide();
				
			}
			
			});  
		 */
		 
		//    
		var m = $(this).find('.ckedit')
		m.ckeditor();

		//alert("coming here")
		$('.ckedit').ckeditor();
		clicked();
		
		

		 var count = 0;

		 $('#user_dialog').dialog({
		  autoOpen:false,
		  width:400
		 });

		 $('#add').click(function(){
		  $('#user_dialog').dialog('option', 'title', 'Add Para');
		  
         // rowctr = $('#para_data').rowCount();
            //  alert("ctr"+rowctr);
		
			  $('#add').prop('disabled', true);  
		  
		 
		  
		  
		  
		  $('#actionTitle').val('');
		  $('#parasAction').val('');
		 /*  $('#remarks').val(''); */
		 
		 
		  $('#error_title').text('');
		  $('#error_parasaction').text('');
		/*   $('#error_remarks').text(''); */
		  
		  
		  $('#actionTitle').css('border-color', '');
		  $('#parasAction').css('border-color', '');
		 /*  $('#remarks').css('border-color', ''); */
		  
		  $('#save').text('Save');
		  $('#user_dialog').dialog('open');
		  
		  
		  
		  
		 });

		 $('#save').click(function(){
		  var error_title = '';
		  var error_parasaction = '';
		 /*  var error_remarks = ''; */
		 
		  
		  var actionTitle = '';
		  var parasAction = '';
		/*   var remarks = ''; */
		  
		 
		  if($('#actionTitle').val() == '')
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
		   parasAction = $('#parasAction').val();
		   
		  // alert("kal"+parasAction);
		  }
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
		 
		  if(error_title != '' || error_parasaction != '' )
		  {
		   return false;
		  }
		  else
		  {
			  
			 
		   if($('#save').text() == 'Save' )
		   {
			  
			  // alert("savepara");
		    output = '<tr id="hidden_row_'+count+'">';
		 /*    output += '<td>'+count+' </td>'; */
		    output += '<td>'+actionTitle+' <input type="hidden" name="paraDataList['+count+'].actionTitle" id="actionTitle'+count+'" class="form-control actionTitle" value="'+actionTitle+'" /></td>';
		    output += '<td>'+parasAction+' <textarea style="display:none;" class="ckedit form-control "  name="paraDataList['+count+'].parasAction" id="parasAction'+count+'"  >'+parasAction+'</textarea> </td>';
		  /*   output += '<td>'+remarks+' <textarea style="display:none;" class="ckedit form-control "  name="paraDataList['+count+'].remarks" id="remarks'+count+'" class="remarks'+count+'"  >'+remarks+'</textarea> </td>'; */
		   
		    
		    output += '<td><button type="button" name="view_details" class="btn btn-warning btn-xs view_details" id="'+count+'">View</button></td>';
		    output += '<td><button type="button" name="remove_details" class="btn btn-danger btn-xs remove_details" id="'+count+'">Remove</button></td>';
		    output += '</tr>';
		   
		   // count = count + 1;
		    $('#para_data').append(output);
		   }
		   else
		   {
			   
			  // alert("elsepara");
			   
		    var row_id = $('#hidden_row_id').val();
		 /*    output += '<td>'+row_id+' </td>'; */
		     output = '<td>'+actionTitle+' <input type="hidden" name="paraDataList['+row_id+'].actionTitle" id="actionTitle'+row_id+'"  class="form-control actionTitle" value="'+actionTitle+'" /></td>'; 
		    output += '<td>'+parasAction+'<textarea style="display:none;" class="ckedit form-control "  name="paraDataList['+row_id+'].parasAction" id="parasAction'+row_id+'" >'+parasAction+'</textarea> </td>';
		  /*   output += '<td>'+remarks+'<textarea style="display:none;" class="ckedit form-control "  name="paraDataList['+row_id+'].remarks" id="remarks'+row_id+'"  >'+remarks+'</textarea> </td>'; */
		   
		    output += '<td><button type="button" name="view_details" class="btn btn-warning btn-xs view_details" id="'+row_id+'">View</button></td>';
		    output += '<td><button type="button" name="remove_details" class="btn btn-danger btn-xs remove_details" id="'+row_id+'">Remove</button></td>';
		    $('#hidden_row_'+row_id+'').html(output);
		   } 

		   $('#user_dialog').dialog('close');
		  }
		 });

		 $(document).on('click', '.view_details', function(){
		  var row_id = $(this).attr("id");
		//  alert("kal"+row_id);
		  var actionTitle = $('#actionTitle').val();
		  var parasAction = $('#parasAction').val();
		/*   var remarks = $('#remarks').val(); */
		 
		 
		  $('#actionTitle').val(actionTitle);
		  $('#parasAction').val(parasAction);
		/*   $('#remarks').val(remarks); */
		 
		  //alert("1"+actionTitle);
		 // alert("2"+parasAction);
		 // alert("3"+remarks);
		  
		  
		  $('#save').text('Edit');
		  $('#hidden_row_id').val(row_id);
		  $('#user_dialog').dialog('option', 'title', 'Edit Para Data');
		  $('#user_dialog').dialog('open');
		 });

		 $(document).on('click', '.remove_details', function(){
			 
			
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
		 });

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
		  width:400
		 });

		 $('#reply').click(function(){
		  $('#reply_dialog').dialog('option', 'title', 'Add reply Data');
		  
		
		  $('#replylatest').val('No'); 
		  $('#replyAction').val('');
		  $('#replyRemarks').val('');
		 
		 
		   $('#error_replylatest').text(''); 
		  $('#error_replyAction').text('');
		  $('#error_replyremarks').text('');
		 
		
		  
		   $('#replylatest').css('border-color', ''); 
		  $('#replyAction').css('border-color', '');
		  $('#replyRemarks').css('border-color', '');
		  
		
		  $('#savereply').text('Save');
		  $('#reply_dialog').dialog('open');
		 });

		 $('#savereply').click(function(){
		  var error_replylatest = ''; 
		  var error_replyAction = '';
		  var error_replyRemarks= '';
		 
		  
		   var replylatest = 'No'; 
		  var replyAction = '';
		  var replyRemarks = '';
		 
		  var cd=$('input:radio[name=replylatest]:checked').val();
		 // alert("cd"+cd);
		 
		   if($('input:radio[name=replylatest]:checked').val() == '')
		  {
			  error_replylatest = 'reply is required';
		   $('#error_replylatest').text(error_replylatest);
		   $('#replylatest').css('border-color', '#cc0000');
		   replylatest = 'No';
		   alert("kal"+replylatest);
		  }
		  else
		  {
			  
			  var rlatest=$('input:radio[name="replylatest"]:checked').val();
			  alert("rlatest"+rlatest);
			  error_replylatest = '';
		   $('#error_replylatest').text(error_replylatest);
		   $('#replylatest').css('border-color', '');
		   replylatest = rlatest;
		  }  
		  if($('#replyAction').val() == '')
		  {
			  error_replyAction = 'replyAction is required';
		   $('#error_connectedLoad').text(error_replyAction);
		   $('#replyAction').css('border-color', '#cc0000');
		   replyAction = '';
		  }
		  else
		  {
			  error_replyAction = '';
		   $('#error_connectedLoad').text(error_replyAction);
		   $('#replyAction').css('border-color', '');
		   replyAction = $('#replyAction').val();
		  }
		  if($('#replyRemarks').val() == '')
		  {
			  error_replyRemarks = 'Remarks is required';
		   $('#error_replyRemarks').text(error_replyRemarks);
		   $('#replyRemarks').css('border-color', '#cc0000');
		   replyRemarks = '';
		  }
		  else
		  {
			  error_replyRemarks = '';
		   $('#error_replyRemarks').text(error_replyRemarks);
		   $('#replyRemarks').css('border-color', '');
		   replyRemarks = $('#replyRemarks').val();
		  }
		 
		  if(error_replyAction != '' )
		  {
		   return false;
		  }
		  else
		  {
			  
			 
		   if($('#savereply').text() == 'Save')
		   {
			  //alert("trply");
		    replyoutput = '<tr id="replyrow_'+replycount+'">';
		     replyoutput += '<td>'+replylatest+'   <input type="hidden" name="replyDataList['+replycount+'].replylatest" id="replylatest'+replycount+'"      value="'+replylatest+'"  required ></td>'; 
		     /* '<label class="radio-inline"> <input type="radio" name="replyDataList['+replycount+'].replylatest" id="replylatest'+replycount+'"     value="true"  required >Yes</label>' */
		    replyoutput += '<td>'+replyAction+' <textarea style="display:none;" name="replyDataList['+replycount+'].replyAction" id="replyAction'+replycount+'"  >'+replyAction+'</textarea></td>';
		    replyoutput += '<td>'+replyRemarks+' <textarea style="display:none;" name="replyDataList['+replycount+'].replyRemarks" id="replyRemarks'+replycount+'" class="replyRemarks"  >'+replyRemarks+'</textarea></td>';
		   
		    
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
		     replyoutput = '<td>'+replylatest+'  <input type="hidden" name="replyDataList['+replyrow_id+'].replylatest" id="replylatest'+replyrow_id+'"      value="'+replylatest+'"  required ></td>';  
		     
		     /* <label class="radio-inline"> <input type="radio" name="replyDataList['+replyrow_id+'].replylatest" id="replylatest'+replyrow_id+'"     value="true"  required >Yes</label> */
		    replyoutput += '<td>'+replyAction+' <textarea style="display:none;" name="replyDataList['+replyrow_id+'].replyAction" id="replyAction'+replyrow_id+'"  >'+replyAction+'</textarea></td>';
		    replyoutput += '<td>'+replyRemarks+' <textarea style="display:none;" name="replyDataList['+replyrow_id+'].replyRemarks" id="replyRemarks'+replyrow_id+'"  >'+replyRemarks+'</textarea></td>';
		    
		   
		    replyoutput += '<td><button type="button" name="replyview_details" class="btn btn-warning btn-xs replyview_details" id="'+replyrow_id+'">View</button></td>';
		    replyoutput += '<td><button type="button" name="replyremove_details" class="btn btn-danger btn-xs replyremove_details" id="'+replyrow_id+'">Remove</button></td>';
		    $('#replyrow_'+replyrow_id+'').html(replyoutput);
		   }

		   $('#reply_dialog').dialog('close');
		  }
		 });

		 $(document).on('click', '.replyview_details', function(){
		  var replyrow_id = $(this).attr("id");
		  alert("kal2here"+replyrow_id);
		
		   var replylatest = $('#replylatest'+replyrow_id+'').val();
		   alert("replylatest"+replylatest);
		  var replyAction = $('#replyAction'+replyrow_id+'').val();
		  var replyRemarks = $('#replyRemarks'+replyrow_id+'').val();
		      alert("kal2"+replylatest);
		   $('input:radio[name=replylatest][value='+replylatest+']').attr('checked', true);
		 // $('#replylatest').val(replylatest); 
		  $('#replyAction').val(replyAction);
		  $('#replyRemarks').val(replyRemarks);
		 
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


							<div class="row show-grid">
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

<div class="w3_agile_main_left">






						<div class="panel panel-primary ">
							<div class="panel-heading">
								<h3 class="panel-title">Edit Para & Reply</h3>
							</div>
							<form:form id="parasinput" method="post" modelAttribute="irparas"
								data-parsley-validate-if-empty=""  enctype="multipart/form-data" >
								<div class='container'>

                           
                               <c:if test="${paraDBObj!=null}">
                               
                            
				
			
			
				
				<input name=editFlag id="editFlag" type=hidden  value="false" >
				
				<input name=paraId id="paraId" type=hidden  value="${paraDBObj.paraId }" >
				<input name=hiddenCircleId id="hiddenCircleId" type=hidden  value="${paraDBObj.circleId }" >
				<input name=hiddenDivisionId id="hiddenDivisionId" type=hidden  value="${paraDBObj.divisionId }" >
				<input name=hiddenSubdivisionId id="hiddenSubdivisionId" type=hidden  value="${paraDBObj.subdivisionId }" >
				
				<input name=hiddenFinancialYear id="hiddenFinancialYear" type=hidden  value="${paraDBObj.financialYear }" >
				
				<input name=hiddenTrCircleId id="hiddenTrCircleId" type=hidden  value="${paraDBObj.tcircleId }" >
				<input name=hiddenTrDivisionId id="hiddenTrDivisionId" type=hidden  value="${paraDBObj.tdivisionId }" >
				<input name=hiddenTrSubdivisionId id="hiddenTrSubdivisionId" type=hidden  value="${paraDBObj.tsubdivisionId }" >
				
				
				
				
				
			
				

                                
									<div class="row col-md-12 toppad ">


<div class="col-md-6">
										

                                      <br></br>


											<div class="col-md-6">
												<label class="label-controlPMS rowlebel ">Select Unit  <font color=red>*</font> 
													</label></div>
													
													<div class="col-md-6">
													<select class="form-control" id="unitId" name="unitId"  onchange="getCircles()" required>
												 <option value=" ">--select--</option>
												
												 <c:forEach items="${unitList}" var="u">
												 <c:choose>
												 <c:when test="${u.unitId==paraDBObj.unitId}">
									              <option value="${u.unitId}" selected="selected">${u.unitName}</option>
									              </c:when>
									              <c:otherwise>
									               <option value="${u.unitId}">${u.unitName}</option>
									              </c:otherwise>
									              </c:choose>

								</c:forEach>
 
												
												
												</select>
											</div>
										

											
											
												<div class="col-md-6">
												<label class="label-control rowlebel ">Select Circle</label>
												</div>
												<div class="col-md-6">
												<select class="form-control" id="circleId" name="circleId" 
													 onchange="getDivisions(this.value)">
													<option value="0">--select--</option>
													


												</select>

											</div>
										
											


											<div class="col-md-6">
												<label class="label-controlPMS rowlebel ">Select Division</label>
												</div>
												<div class="col-md-6">
												<select class="form-control" id="divisionId" name="divisionId" onchange="getSubDivisions(this.value)">
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
										 
										     <option value="I" ${paraDBObj.paraNumber == 'I' ? 'selected' : ''} >I</option> 
										       
										     <option value="II"  ${paraDBObj.paraNumber == 'II' ? 'selected' : ''}>II</option> 
										     <option value="III"  ${paraDBObj.paraNumber== 'III' ? 'selected' : ''} >III</option>
										      <option value="IV"  ${paraDBObj.paraNumber == 'IV' ? 'selected' : ''}>IV</option>
										      <option value="V"  ${paraDBObj.paraNumber == 'V' ? 'selected' : ''}>V</option>
										      <option value="VI"  ${paraDBObj.paraNumber == 'VI' ? 'selected' : ''}>VI</option>
										      <option value="VII"  ${paraDBObj.paraNumber == 'VII' ? 'selected' : ''}>VII</option>
										      <option value="VIII"  ${paraDBObj.paraNumber == 'VIII' ? 'selected' : ''}>VIII</option>
										      <option value="IX"  ${paraDBObj.paraNumber == 'IX' ? 'selected' : ''}>IX</option>
										      <option value="X"  ${paraDBObj.paraNumber == 'X' ? 'selected' : ''}>X</option>
										      <option value="XI"  ${paraDBObj.paraNumber == 'XI' ? 'selected' : ''}>XI</option>
										      <option value="XII" ${paraDBObj.paraNumber == 'XII' ? 'selected' : ''}>XII</option>
										      
										      </select> </div>
										      
										      
											 
											 
											  <div class="col-md-6">
											 <label class="label-control rowlebel ">File No.  </label>
											 </div>
											 
											 <div class="col-md-6">
											  <input type="text" class=" form-control"  id="fileNumber" name="fileNumber" placeholder="Ex:9-40/08-09(AG File)" value="${paraDBObj.fileNumber}"  /> 
											  </div>
											  
											   <div class="col-md-6">
											 <label class="label-control rowlebel ">LAR No.  </label>
											 </div>
											 
											 <div class="col-md-6">
											  <input type="text" class=" form-control"  id="larNumber" name="larNumber" placeholder="Ex:183/08-09" value="${paraDBObj.larNumber}"  /> 
											  </div>
											 
											 
										
											 
											 
											  <div class="col-md-6">
										<label class="label-controlPMS rowlebel ">
										Select Section <font color=red>*</font> </label>
										</div>
										
										
										
										 <div class="col-md-6">
										<select class="form-control" id="sectionId" name="sectionId" required> 
										<option value=" ">--select--</option>  
										<option value="1" ${paraDBObj.sectionId == '1' ? 'selected' : ''}>Section-A</option>
										<option value="2" ${paraDBObj.sectionId == '2' ? 'selected' : ''}>Section-B</option>
										
										</select> </div>
										
										
										
										
										      
										      
										        <div class="col-md-6">
										<label class="label-controlPMS rowlebel ">
										Select Para Status  <font color=red>*</font>  </label>
										</div>
										<div class="col-md-6">
										<select class="paratrunit form-control" id="paraStatusId" name="paraStatusId"  required> 
										<option value=" ">--select--</option> 
										<option value="1" ${paraDBObj.paraStatusId == '1' ? 'selected' : ''}>Reply Sent to AG</option>
									    <option value="2" ${paraDBObj.paraStatusId == '2' ? 'selected' : ''}>Reply Not Sent</option> 										
										<option value="3" ${paraDBObj.paraStatusId == '3' ? 'selected' : ''}>Dropped </option>
										
										 </select>
									     </div>
								
										
											</div>
											
											 <div class="col-md-6">
										  <br></br>
									      
										
										
										<!-- <div class="col-md-6">
										<label class="label-controlPMS rowlebel ">
										Select Status </label>
										</div>
										
										<div class="col-md-6">
										<select class="form-control" id="statusId" name="statusId"  required> 
										<option value="0">--select--</option> 
										<option value="1">Reply Sent to AG</option> 
										<option value="2">Transferred </option>
										<option value="3">Reply Not Sent</option></select> 
										</div> -->
										
										
										<div class="col-md-6">
											 <label class="label-control rowlebel ">Date of Audit <font color=red>*</font> </label>
											 </div>
											 
											 <div class="col-md-3">
											 <label class="label-control rowlebel ">from</label>
											  <input type="text" class=" form-control datepicker"  id="auditDateFrom" name="auditDateFrom" placeholder="auditDateFrom"  readonly="readonly" value="${paraDBObj.auditDateFrom}" required/> 
											  </div>
											  
											   <div class="col-md-3">
											   <label class="label-control rowlebel ">to</label>
											  <input type="text" class=" form-control datepicker"  id="auditDateTo" name="auditDateTo" placeholder="auditDateto"  readonly="readonly" value="${paraDBObj.auditDateTo}"  /> 
											  </div>
										
											
											 
											 
											 
											 
											
											 
											<!--   <div class="row show-grid" id="toffice">	 -->					
										
										  
										 




																						
											<br></br>
													
											
											

											
										
										<!-- </div> -->
										
											   <div class="col-md-6"  >
										 <label class="label-controlPMS rowlebel ">Printed in CAG Report <font color=red>*</font> </label>
										 </div>
										<div class="col-md-6">
							<div class="form-group">
      
        <div class="col-sm-8" id="statusdiv">
       
        <c:choose>
        <c:when test="${paraDBObj.printCagStatus=='NO' }">
        <label class="radio-inline"> <input type="radio" name="printCAG" id="printCAG"  checked="checked"    value="NO"  required >NO</label>
         <label class="radio-inline"> <input type="radio" name="printCAG" id="printCAG"      value="Yes"  required >Yes</label>
        </c:when>
        <c:otherwise>
        <label class="radio-inline"> <input type="radio" name="printCAG" id="printCAG"     value="NO"  required >NO</label>
        <label class="radio-inline"> <input type="radio" name="printCAG" id="printCAG"     checked="checked"  value="Yes"  required >Yes</label>
        </c:otherwise>
       </c:choose>
       
        
       
       
          
         
        </div>
    </div>
						</div>
						
						 <div class="col-md-6"  >
										 <label class="label-controlPMS rowlebel ">Transferred to Other Office <font color=red>*</font> </label>
										 </div>
						
						<div class="col-md-6">
							<div class="form-group">
      
        <div class="col-sm-8" >
       
          <c:choose>
        <c:when test="${paraDBObj.transferFlag==false }">
        <label class="radio-inline"> <input type="radio" name="transferFlag" id="transferFlag"  checked="checked"    value="false"  required >NO</label>
        <label class="radio-inline"> <input type="radio" name="transferFlag" id="transferFlag"     value="true"  required >Yes</label>
       </c:when>
       <c:otherwise>
        <label class="radio-inline"> <input type="radio" name="transferFlag" id="transferFlag"    value="false"  required >NO</label>
        <label class="radio-inline"> <input type="radio" name="transferFlag" id="transferFlag"   checked="checked"    value="true"  required >Yes</label>
       
       </c:otherwise>
       </c:choose>
       
        
       
       
          
         
        </div>
    </div>
						</div>
						
						<div class="col-md-12" id="toffice">
						<br></br>
						<div class="col-md-6">
												<label class="label-controlPMS rowlebel ">Transferred
													Unit</label>
													
													</div>
													<div class="col-md-6">
													<select class="form-control" id="tunitId" name="tunitId"  onchange="gettCircles()">
											<option value="0">--select--</option>
												
												 <c:forEach items="${unitList}" var="u">
												 <c:choose>
												 <c:when test="${u.unitId==paraDBObj.tunitId}">
									              <option value="${u.unitId}" selected="selected">${u.unitName}</option>
									              </c:when>
									              <c:otherwise>
									               <option value="${u.unitId}">${u.unitName}</option>
									              </c:otherwise>
									              </c:choose>

								</c:forEach>
 
												
												
												</select>
											</div>
										

											
											
												<div class="col-md-6">
												<label class="label-control rowlebel ">Transferred Circle</label>
												</div>
												<div class="col-md-6">
												<select class="form-control" id="tcircleId" name="tcircleId"  onchange="gettDivisions(this.value)"
													>
													<option value="0">--select--</option>
													<!-- onchange="getDivisions()" -->


												</select>

											</div>
										
											


											<div class="col-md-6">
												<label class="label-controlPMS rowlebel ">Transferred Division</label>
												</div>
												
												<div class="col-md-6">
												<select class="form-control" id="tdivisionId" name="tdivisionId" onchange="gettSubDivisions(this.value)"		>
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
						
						
				
									
									
											   <div class="col-md-6"  >
											     <br></br>
										 <label class="label-controlPMS rowlebel ">Upload Files(Multiple)</label>
										 </div>
										 
										  <div class="col-md-6"  >
										    <br></br>
								<input id="uploadFile" name="uploadFile" type="file"
									class="btn-info" value="Upload Documents"  multiple="multiple">
							</div>
										
											
											
											
											 
											
										
									
									
									

									</div>
									
								
									
									

								
								

									

								
								
								
	
	
<div class="col-md-12">
<br></br>
  <div class="table-responsive">
     <table class="table table-striped table-bordered" id="para_data">
     
      <tbody>
      
      <tr>
      
      <td>
        <label class="label-control rowlebel " style="color: red">Gist of Para*</label> 
      
      <textarea class="form-control "  id="paraDataList[0].actionTitle" name="paraDataList[0].actionTitle" rows="10" cols="80" placeholder="Para"    required> <c:out value="${paraDBObj.actionTitle}" ></c:out></textarea>
       </td>
        <td>
        	<label class="label-control rowlebel " style="color: red">Para*</label> 
	<textarea class="ckedit form-control "  id="parasAction" name="paraDataList[0].parasAction" rows="10" cols="80" placeholder="Para"    required
	data-parsley-errors-container="#purpose-errors" data-parsley-required-message="Please Enter Para Information!" data-parsley-group="block1"> <c:out value="${paraDBObj.parasAction}" escapeXml="false"></c:out></textarea>
     
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
     
     
   
      <tbody>
      
      <c:if test="${replyList!=null}">
      <c:set var="d" value="0" scope="page" />
      <c:forEach items="${replyList }" var="r"  varStatus="count">
      <c:if test="${paraDBObj.paraId==r.paraId }">
       <input type="hidden" name="replyDataList[${d}].paraReplyId" id="replyDataList[${d}].paraReplyId" class="form-control actionTitle" value="${r.paraReplyId} " />
      <tr>
      <td>
      <label class="label-control rowlebel " style="color: blue">Reply*</label> 
	<textarea class="ckedit form-control "  id="replyDataList[${d}].replyAction" name="replyDataList[${d}].replyAction" rows="10" cols="80" placeholder="reply"    required> <c:out value="${r.replyAction}" escapeXml="false"></c:out></textarea>
      </td>
      
      <td>
        <label class="label-control rowlebel " style="color: blue">Remarks</label> 
      
      <textarea class="form-control "  id="replyDataList[${d}].replyRemarks" name="replyDataList[${d}].replyRemarks" rows="10" cols="80" placeholder="remarks"    > <c:out value="${r.replyRemarks}" ></c:out></textarea>
       </td>
       
       <td>
        <label class="label-controlPMS rowlebel " style="color: blue">Reply Date <font color=red>*</font> </label>
	
        <input type="text" name="replyDataList[${d}].replyDate" id="replyDataList[${d}].replyDate" class="datepick form-control datepicker"   value="<c:out value="${r.replyDate}" ></c:out>"    readonly="readonly"  required />
       
       
       </td>
       
       
      
      </tr>
      <c:set var="d" value="${d + 1}" scope="page"/>
      </c:if>
      
      
      </c:forEach>
      </c:if>      
      </tbody>
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







								</div>
								
								</c:if>
								</div>
								<!-- row -->





							</form:form>

						</div>

														
							
  
  
  
  						

						


</div>
<!-- //main-content -->
<script type="text/javascript" src="../js/parsley.js"></script>



<script type="text/javascript" class="example">
	$(function() {
		
		
		$('#parasinput').parsley().on('field:validated', function() {
			var ok = $('.parsley-error').length === 0;

			$("#editFlag").val(true);
		

		})
			
	
		.on('submit', function(event) {
			
		
		   
		    document.forms.parasinput.action = "../parastsimis/editirparas";
			document.forms.parasinput.submit(); 
		  
		});
	});
</script>

