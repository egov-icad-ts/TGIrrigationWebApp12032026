
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
      
     
      
      for(var f=1 ; f< 20 ;f++) {
    	  
    	  var option = "<option value=" + parseInt(f) + " > "+ parseInt(f) + "</option>"
          // alert(option);
           
           $('.paraSequence').append(option);
            
    	  
    	  
      }
	
		 
	$('#unitId').multiselect({
		 
		 enableCaseInsensitiveFiltering: true
		 
	});
	
	$('#subParaUnitList').multiselect({
		 
		enableClickableOptGroups : true,
		enableCaseInsensitiveFiltering : true,
		enableCollapsibleOptGroups : false,
		includeSelectAllOption : true,
		disableIfEmpty : true
		 
	});
	
	

	
	
	$('#financialYear').multiselect({
		 
		 enableCaseInsensitiveFiltering: true
		 
	});

	



	
	$('#paraStatusId').multiselect({
		 
		 enableCaseInsensitiveFiltering: true
		 
	});
	
	
	

	
	
	 
	 
	 
	

	}); 

</script>




<script>
	

	

	$(function() {
		
		
	
	/* 	
		$(".datepick").datepicker({
			changeYear : true,
			changeMonth : true,
			dateFormat : "dd/mm/yy",
		/*  onSelect: function(selected) {
		   $("#month").datepicker("option","minDate", selected)
		 } */
	//	});
		
		
		
		
		// */
		
		
		/* $.fn.rowCount = function() {
		    return $('tr', $(this).find('tbody')).length;
		};
		 */
		
		/*  $('input:radio[name=transferFlag]').change(function () {
			
	            if (this.value == 'true') {
	            	
	            	 $("#toffice").show();
	            }
	            if (this.value == 'false') {
	            	
	            	$("#toffice").hide();
	            }
	        }); */
		 
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
   	 
		
		
		 
		 
		  
		var m = $(this).find('.ckedit')
		m.ckeditor();

		//alert("coming here")
		$('.ckedit').ckeditor();
		clicked();
		
		 var paracount = 0;

		 $('#para_dialog').dialog({
		  autoOpen:false,
		  width:800
		 });

		 $('#para').click(function(){
		  $('#para_dialog').dialog('option', 'title', 'Add Para Data');
		  
		 var subPara= $('#paraNumber').val();
			
		
		  $('#paraSequence').val(' '); 
		  $('#subParaNumber').val(subPara); 
		  $('#subParaUnitList').val(' '); 
		  $('#paraStatusId').val(' '); 
		  
		  
		  
		 // var respondentIdArray = $("#respondentId").val();
		 // var respondentName = $('#respondentId').find("option:selected").text();
		  
		  $('#paraTitle').val('');
		  
		  $('#parasAction').val('');
		  
		  $('#discussPac').val('false');
		
		 
		 
		   $('#error_paraSequence').text(''); 
		   $('#error_subParaNumber').text(''); 
		   $('#error_subParaUnitList').val(' '); 
		   
		   $('#error_paraTitle').text(''); 
		  $('#error_parasAction').text('');
		  $('#error_paraStatusId').text('');
		  $('#error_discussPac').text('');
		  
		 
		 
		
		  
		   $('#paraSequence').css('border-color', '');
		   $('#subParaNumber').css('border-color', '');
		   $('#subParaUnitList').css('border-color', '');
		   
		   $('#paraTitle').css('border-color', '');
		  $('#parasAction').css('border-color', '');
		  $('#paraStatusId').css('border-color', '');
		  
		  $('#discussPac').css('border-color', '');
		  
		  
		
		  
		
		  $('#savepara').text('Save');
		  $('#para_dialog').dialog('open');
		 });

		 $('#savepara').click(function(){
		  var error_paraSequence = ''; 
		  var error_parasAction = '';
		  var error_paraTitle = '';
		  var error_subParaNumber = '';
		  var error_subParaUnitValue = '';
		  var error_subParaUnitList='';
		  var error_paraStatusId='';
		  
		  var error_discussPac='';
		  
		  
		  
		 
		 
		  
		   var paraSequence = ' '; 
		  var parasAction = '';
		  var paraTitle = '';
		  var subParaNumber='';
		  var subParaUnitValue='';
		  var subParaUnitList='';
		  var paraStatusId='';
		  var paraStatusText='';
		  var discussPac='';
		
		//  alert("subParaUnitList"+subParaUnitList);
		 
		 
		   if($('#paraSequence').val() == ' ')
		  {
			  error_paraSequence = 'para sequence is required';
		   $('#error_paraSequence').text(error_paraSequence);
		   $('#paraSequence').css('border-color', '#cc0000');
		   paraSequence = ' ';
		  // alert("kal"+replylatest);
		  }
		  else
		  {
			  
			  var latestparaSequence=$('#paraSequence').val();
			 // alert("rlatest"+rlatest);
			  error_paraSequence = '';
		   $('#error_paraSequence').text(error_paraSequence);
		   $('#paraSequence').css('border-color', '');
		   paraSequence = latestparaSequence;
		  }  
		   
		   if($('#subParaNumber').val() == ' ')
			  {
				  error_subParaNumber = 'Sub para Number is required';
			   $('#error_subParaNumber').text(error_subParaNumber);
			   $('#subParaNumber').css('border-color', '#cc0000');
			   subParaNumber = ' ';
			  // alert("kal"+replylatest);
			  }
			  else
			  {
				  
				  var latestsubParaNumber=$('#subParaNumber').val();
				 // alert("rlatest"+rlatest);
				  error_subParaNumber = '';
			   $('#error_subParaNumber').text(error_subParaNumber);
			   $('#subParaNumber').css('border-color', '');
			   subParaNumber = latestsubParaNumber;
			  }  
		   
		   if($('#subParaUnitList').val() == ' ')
			  {
				  error_subParaUnitList = 'Sub para unit List is required';
			   $('#error_subParaUnitList').text(error_subParaUnitList);
			   $('#subParaUnitList').css('border-color', '#cc0000');
			   subParaUnitList = ' ';
			   var x=$('#subParaUnitList').val();
			 // alert("kal"+x);
			  }
			  else
			  {
				  
				  var latestsubParaUnitList=$('#subParaUnitList').val();
				  var newunittext=$('#subParaUnitList').find("option:selected").text();
				  
				// alert("rlatest"+newunittext);
				// alert("rlatest2"+latestsubParaUnitList);
				  error_subParaUnitList = '';
			   $('#error_subParaUnitList').text(error_subParaUnitList);
			   $('#subParaUnitList').css('border-color', '');
			   subParaUnitList = newunittext;
			   subParaUnitValue=latestsubParaUnitList;
			 //  alert("kal1"+latestsubParaUnitList);
			//   alert("kal2"+newunittext);
			  }  
		   
		   
		   
		  if($('#parasAction').val() == '')
		  {
			  error_parasAction = 'parasAction is required';
		   $('#error_parasAction').text(error_parasAction);
		   $('#parasAction').css('border-color', '#cc0000');
		   parasAction = '';
		  }
		  else
		  {
			  error_parasAction = '';
		   $('#error_parasAction').text(error_parasAction);
		   $('#parasAction').css('border-color', '');
		   parasAction = $('#parasAction').val();
		  }
		  
		  if($('#paraTitle').val() == '')
		  {
			  error_paraTitle = 'paraTitle is required';
		   $('#error_paraTitle').text(error_paraTitle);
		   $('#paraTitle').css('border-color', '#cc0000');
		   paraTitle = '';
		  }
		  else
		  {
			  error_paraTitle = '';
		   $('#error_paraTitle').text(error_parasAction);
		   $('#paraTitle').css('border-color', '');
		   paraTitle = $('#paraTitle').val();
		  }
		  
		  if($('#paraStatusId').val() == '')
		  {
			  error_paraStatusId = 'paraStatus is required';
		   $('#error_paraStatusId').text(error_paraStatusId);
		   $('#paraStatusId').css('border-color', '#cc0000');
		   paraTitle = '';
		  }
		  else
		  {
			  error_paraStatusId = '';
			  var newparaStatusText=$('#paraStatusId').find("option:selected").text();
		   $('#error_paraStatusId').text(error_paraStatusId);
		   $('#paraStatusId').css('border-color', '');
		   paraStatusId = $('#paraStatusId').val();
		   paraStatusText=newparaStatusText;
		  }
		  
		  alert("kal0");
		  if($('#discussPac').val() == '')
			 
		  {
			  alert("kal1");
			  error_discussPac = 'discussPac is required';
		   $('#error_discussPac').text(error_discussPac);
		   $('#discussPac').css('border-color', '#cc0000');
		   discussPac = '';
		  }
		  else
		  {
			  alert("kal2");
			  error_discussPac = '';
			  var newparaStatusText=$("input[name='discussPac']:checked").val();
			  alert("newparaStatusText"+newparaStatusText);
		   $('#error_discussPac').text(error_discussPac);
		   $('#discussPac').css('border-color', '');
		   discussPac = newparaStatusText;
		   alert(discussPac);
		   
		  }
		  
		  
		 
		  if(error_parasAction != ''&& error_paraSequence!=' ' && error_subParaNumber!='' && error_subParaUnitList!='' && error_paraStatusId!='' && error_discussPac!='' )
		  {
		   return false;
		  }
		  else
		  {
			  
			 
		   if($('#savepara').text() == 'Save')
		   {
			
		    paraoutput = '<tr id="pararow_'+paracount+'">';
		    
		    paraoutput += '<td>'+paraSequence+'   <input type="hidden" class="replynew" name="paraDataList['+paracount+'].paraSequence" id="paraSequence'+paracount+'"      value="'+paraSequence+'"  required ></td>';
		    paraoutput += '<td>'+subParaNumber+'   <input type="hidden" class="replynew" name="paraDataList['+paracount+'].subParaNumber" id="subParaNumber'+paracount+'"      value="'+subParaNumber+'"  required ></td>';
		    paraoutput += '<td>'+subParaUnitList+'   <input type="hidden" class="replynew" name="paraDataList['+paracount+'].subParaUnitList" id="subParaUnitList'+paracount+'"      value="'+subParaUnitValue+'"  required ></td>';
		    paraoutput += '<td>'+paraTitle+'  <input type="hidden" class="replynew" name="paraDataList['+paracount+'].paraTitle" id="paraTitle'+paracount+'"      value="'+paraTitle+'"  required ></td>'; 
		    paraoutput += '<td>'+parasAction+' <textarea style="display:none;" name="paraDataList['+paracount+'].parasAction" id="parasAction'+paracount+'"  >'+parasAction+'</textarea></td>';
		    paraoutput += '<td>'+paraStatusText+'  <input type="hidden" class="replynew" name="paraDataList['+paracount+'].paraStatusId" id="paraStatusId'+paracount+'"      value="'+paraStatusId+'"  required ></td>';
		    paraoutput += '<td>'+discussPac+'  <input type="hidden" class="replynew" name="paraDataList['+paracount+'].discussPac" id="discussPac'+paracount+'"      value="'+discussPac+'"  required ></td>';
		   
		   
		   
		    
		    paraoutput += '<td><button type="button" name="paraview_details" class="btn btn-warning btn-xs paraview_details" id="'+paracount+'">View</button></td>';
		    paraoutput += '<td><button type="button" name="pararemove_details" class="btn btn-danger btn-xs pararemove_details" id="'+paracount+'">Remove</button></td>';
		    paraoutput += '</tr>';
		   
		    paracount = paracount + 1;
		    $('#para_data').append(paraoutput);
		   }
		   else
		   {
			   
			   //alert("else trply");
		    var pararow_id = $('#pararow_id').val();
		  //  alert(replyAction);
		  //  alert(replyRemarks);
		  //  alert(replyDate);
		      
		    paraoutput = '<td>'+paraSequence+'  <input type="hidden" class="replynew" name="paraDataList['+pararow_id+'].paraSequence" id="paraSequence'+pararow_id+'"      value="'+paraSequence+'"  required ></td>';
		    paraoutput += '<td>'+subParaNumber+'  <input type="hidden" class="replynew" name="paraDataList['+pararow_id+'].subParaNumber" id="subParaNumber'+pararow_id+'"      value="'+subParaNumber+'"  required ></td>';
		    paraoutput += '<td>'+subParaUnitList+'   <input type="hidden" class="replynew" name="paraDataList['+pararow_id+'].subParaUnitList" id="subParaUnitList'+pararow_id+'"      value="'+subParaUnitValue+'"  required ></td>';
		    paraoutput += '<td>'+paraTitle+'  <input type="hidden" class="replynew" name="paraDataList['+pararow_id+'].paraTitle" id="paraTitle'+pararow_id+'"      value="'+paraTitle+'"  required ></td>';
		    
		    paraoutput += '<td>'+parasAction+' <textarea style="display:none"  name="paraDataList['+pararow_id+'].parasAction" id="parasAction'+pararow_id+'"  >'+parasAction+'</textarea></td>';
		    paraoutput += '<td>'+paraStatusText+'  <input type="hidden" class="replynew" name="paraDataList['+pararow_id+'].paraStatusId" id="paraStatusId'+pararow_id+'"      value="'+paraStatusId+'"  required ></td>';
		    paraoutput += '<td>'+discussPac+'  <input type="hidden" class="replynew" name="paraDataList['+pararow_id+'].discussPac" id="discussPac'+pararow_id+'"      value="'+discussPac+'"  required ></td>';
		   
		    
		    
		   
		   
		 
		    paraoutput += '<td><button type="button" name="paraview_details" class="btn btn-warning btn-xs paraview_details" id="'+pararow_id+'">View</button></td>';
		    paraoutput += '<td><button type="button" name="pararemove_details" class="btn btn-danger btn-xs pararemove_details" id="'+pararow_id+'">Remove</button></td>';
		  
		  
		   
		    $('#pararow_'+pararow_id+'').html(paraoutput);
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
		   
		   
		   $('#para_dialog').dialog('close');
		  }
		 });

		 $(document).on('click', '.paraview_details', function(){
		  var pararow_id = $(this).attr("id");
		  //alert("kal2here"+replyrow_id);
		
		 
		  // alert("replylatest"+replylatest);
		   var paraSequence = $('#paraSequence'+pararow_id+'').val();
		   var subParaNumber = $('#subParaNumber'+pararow_id+'').val();
		   var subParaUnitList = $('#subParaUnitList'+pararow_id+'').val();
		   var paraStatusId = $('#paraStatusId'+pararow_id+'').val();
		   var discussPac = $('#discussPac'+pararow_id+'').val();
		   
		   
		   
		   
		   
		   
		   var paraTitle = $('#paraTitle'+pararow_id+'').val();
		  var parasAction = $('#parasAction'+pararow_id+'').val();
		  
		 
		     // alert("kal2"+replyAction);
		    //  alert("kal3"+replyRemarks);
		     // alert("kal4"+replyDate);
		 //  $('input:radio[name=replylatest][value='+replylatest+']').attr('checked', true);
		
		 $('#paraSequence'+pararow_id+'').val(paraSequence); 
		 $('#subParaNumber'+pararow_id+'').val(subParaNumber); 
		 
		 $('#subParaUnitList'+pararow_id+'').val(subParaUnitList); 
		 
		 
		 $('#paraTitle'+pararow_id+'').val(paraTitle);
		  $('#parasAction'+pararow_id+'').val(parasAction);
		  $('#paraStatusId'+pararow_id+'').val(paraStatusId);
		  $('#discussPac'+pararow_id+'').val(discussPac);
		  
		  
		  
		 
		  $('#savepara').text('Edit');
		  $('#pararow_id').val(pararow_id);
		  $('#para_dialog').dialog('option', 'title', 'Edit Para Data');
		  $('#para_dialog').dialog('open');
		 });

		 $(document).on('click', '.pararemove_details', function(){
		  var pararow_id = $(this).attr("id");
		  if(confirm("Are you sure you want to remove this row data?"))
		  {
			
		   $('#pararow_'+pararow_id+'').remove();
		  }
		  else
		  {
		   return false;
		  }
		 });

		 $('#action_paraalert').dialog({
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

<div class="w3l-main" id="borderStyle">






						<div class="panel panel-primary ">
							<div class="panel-heading">
								<h3 class="panel-title">Add CAG Para </h3>
							</div>
							<form:form id="parasinput" method="post" modelAttribute="cagparas"
								data-parsley-validate-if-empty=""  enctype="multipart/form-data" >
								<div class='container'>


<div class="col-md-6">

										<div class="col-md-6">
											<label class="label-control rowlebel ">Financial Year <font color=red>*</font> </label>
											</div>
											
											<div class="col-md-6">
											 <select class="form-control" id="financialYear" name="financialYear" required> 
											 <option value=" ">--select--</option>
											
											 </select></div> 
											 
											 
										    	
											</div>
											
											<div class="col-md-6">
											<div class="col-md-6">
										    <label class="label-controlPMS rowlebel ">
										    Para Number  <font color=red>*</font>  </label>
										    </div>
										    <div class="col-md-6">
										    <input type="text" class=" form-control "  id="paraNumber" name="paraNumber" placeholder="EX:3.1"  required data-parsley-pattern="^[0-9]*\.[0-9]{1}$" />  </div>
										      </div>
										   
										
										
											<div class="col-md-12"  >
		<div class="col-md-3"  >
 <label class="label-controlPMS rowlebel ">Gist Of Para<font color=red>*</font> </label>
 </div>
 <div class="col-md-9"  >
        <textarea  name="actionTitle" id="actionTitle" class="  form-control "  rows="2" cols="80"   required > </textarea>
        </div>
											 </div>		
											 
											 <div class="col-md-12"  >
	<br></br>
	<div class="col-md-6"  >
											 <label class="label-controlPMS rowlebel ">Add CAG Para</label>
											 </div>
											 <div class="col-md-6" style="text-align: center;" >
											  <button type="button" name="para" id="para" class="btn btn-primary" >Add Para</button>
											 </div>
											 </div>		
											 
											 
											   <div class="col-md-12">
<br></br>
  <div class="table-responsive">
     <table class="table table-striped table-bordered" id="para_data">
      <tr style="color: blue; ">
    
       <th style="text-align: center;"><b>Sequence</b></th>
      
       <th style="text-align: center;"><b>Sub Para Number</b></th>
         <th style="text-align: center;"><b>Sub Para unit List</b></th>
       <th style="text-align: center;"><b>Title</b></th>
       <th style="text-align: center;"><b>Para</b></th>
       <th style="text-align: center;"><b>Status</b></th>
         <th style="text-align: center;"><b>Discuss PAC</b></th>
      
    
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
												id="submitparas" value="Submit CAG Paras">
										</div>
									</div>
											 			
											
										
	
									</div>
									
								
									
	
								
								

									

	
											 
											 			
								




      
    



								


									




	</form:form>

							<!-- 	</div> -->
								</div>
								<!-- row -->





						

						</div>

							
  
  							
							 <div id="para_dialog" title="Para Data" class="col-md-12">
							 
							 <div class="row form-group">
    
		<div class="col-md-3">
	  <label class="label-controlPMS rowlebel ">Para Sequence<font color=red>*</font> </label>
	  
	  <select class="form-control paraSequence " id="paraSequence" name="paraSequence" required >
	  <option value="0">--select--</option>
	   </select>
       
       
      
										
    <span id="error_paraSequence" class="text-danger"></span>
    </div>
    
    <div class="col-md-3">
     <label class="label-controlPMS rowlebel ">Sub Para Number<font color=red>*</font> </label>
	  <input type="text" class=" form-control "  id="subParaNumber" name="subParaNumber" placeholder="EX:3.1.1"  required data-parsley-pattern="^[0-9]*\.[0-9]{1}$" /> 
	 
       
      
										
    <span id="error_subParaNumber" class="text-danger"></span>
    </div>
    
    <div class="col-md-3">
										<label class="label-controlPMS rowlebel ">
										Select Para Status  <font color=red>*</font>  </label>
										<select class="paratrunit form-control" id="paraStatusId" name="paraStatusId"  required> 
										<option value=" ">--select--</option> 
										<!--  <option value="1">Reply Sent to AG</option> -->
										<option value="4">Reply Sent to Government</option> 
									    <option value="2">Reply Not Sent</option> 										
									
										<option value="3">Dropped</option> 
									   <!--   <option value="4">Reply Sent to Government</option>  -->
									     
										 </select>
										 
										  <span id="error_paraStatusId" class="text-danger"></span>
									     </div>
									     
									     
	<div class=" col-md-3">
	<label class="label-controlPMS rowlebel ">Sub Para Unit   <font color=red>*</font> </label>
													
													
													<select class="form-control" id="subParaUnitList" name="subParaUnitList"  multiple="multiple"  required>
												
												
												 <c:forEach items="${unitList}" var="u">
									              <option value="${u.unitId}">${u.unitName}</option>

								</c:forEach>
 
												
												
												</select>
												
												 <span id="error_subParaUnitList" class="text-danger"></span>
												
												</div>
									     
   </div> 
   
   
   
     <div class=" row form-group">
    
        <div class="col-md-12">
        <label class="label-controlPMS rowlebel ">Discussed in PAC <font color=red>*</font> </label>
          <div class="form-group">
        <label class="radio-inline"> <input type="radio" name="discussPac" id="discussPac"  checked="checked"    value="false"  required >NO</label>
        <label class="radio-inline"> <input type="radio" name="discussPac" id="discussPac"     value="true"  required >Yes</label>
       </div>
     <span id="error_discussPac" class="text-danger"></span>
        </div>
        
        
		
   </div>
   <div class="form-group">

	  <label class="label-controlPMS rowlebel ">Para Title<font color=red>*</font> </label>
        <input type="text" name="paraTitle" id="paraTitle" class="  form-control "  value="0"     required />
       
      
     				
										
    <span id="error_paraTitle" class="text-danger"></span>
   </div> 
							 
							  
    <div class="form-group">
   	<label class="label-control rowlebel ">Para*</label> 
	<textarea class="ckedit form-control "  id="parasAction" name="parasAction" rows="10" cols="80" placeholder="Para"  ></textarea>
    <span id="error_parasAction" class="text-danger"></span>
   </div>
   
 
   <div class="form-group" align="center">
    <input type="hidden" name="pararow_id" id="pararow_id" />
    <button type="button" name="savepara" id="savepara" class="btn btn-info">Save</button>
   </div>
  </div>
  <div id="action_paraalert" title="Action">

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
</script>

