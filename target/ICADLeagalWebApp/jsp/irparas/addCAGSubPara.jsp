
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
	$("#diparasAction").attr('required', '');
	
	for ( instance in CKEDITOR.instances ){
		
		CKEDITOR.instances[instance].getData();
	//alert("ckeditor values : " + CKEDITOR.instances[instance].getData());
	

	}
	}
	
	
function insertcagsubpara(){
	
	
	
	
	if ($('form[id=parasinput]').parsley().isValid()) {
	
	var act1 = "../parastsimis/addCAGSubPara"
var newformId1 = "#parasinput" 

$(newformId1).attr("action", act1);

$(newformId1).submit();

}else{
	 
	 $('form[id=parasinput]').parsley().validate();
	 
}

	
}
	
	
function getCAGParaGist(newcagGistId){
	//alert("kal");
	//var districtId=document.getElementById("districtId").value;
	//var newcagGistId=document.getElementById("financialYear").value;
	
	
	//alert(cagGistId);

	  $.ajax({	          
      url: "../parastsimis/getlistofgist",
      type: "GET",
      async: false,
      data: {
    	  cagGistId: newcagGistId
      },
     
      success: function (response) {
    	
    	
		  var obj = JSON.parse(response);
		
		 // console.log(obj);
		 
		 if(obj!=null){
		  
		  $('#actionTitle').val(obj.actionTitle);   
		  $('#cagGistId').val(obj.cagGistId);
		  $('#dicagGistId').val(obj.cagGistId);
		  $('#diactionTitle').val(obj.actionTitle);   
		 }
		  
    
      },
      error : function(){
    	  alert(error);
      }
  }); 	
}

function getSubParaList(subcagGistId){
	
	// $('#action_alert').empty(); 
	    
	//alert("cmoing here");
	//var districtId=document.getElementById("districtId").value;
	//var subcagGistId=document.getElementById("financialYear").value;
	//alert(cagGistId);

	  $.ajax({	          
      url: "../parastsimis/getSubparaListbygistid",
      type: "GET",
      async: false,
      data: {
    	  cagGistId: subcagGistId
      },
     
     
      success: function (response) {
    	  
    	//  alert(response);
    	  
    	 
    	  
    	  var table2 = $("#gistSubPara  tbody");
    	  
    	 // console.log(response);
    	
          var obj = JSON.parse(response);
         
          table2.empty();
        
          
      	$.each(obj, function(key, value) {
      		
      		//var n=value.paraStatusId
      	//	alert("n"+n);
      	
      		 var $row = $('<tr />');
      		 
      		 var createunitid=value.cunitId;
      		var userunitId=$('#userunitId').val();
        	var usercircleId=$('#usercircleId').val();
      	
        	
        	//alert("createunitid"+createunitid);
        	//alert("userunitId"+userunitId);
      		 $row.append('<td style="text-align: center;"><b>'+value.paraSequence+'</b></td>'+
      				 
      				 '<td style="text-align: center;"><b>'+value.subParaNumber+'</b></td>'+
        	  
        				'<td style="text-align: center;"><b>'+value.unitName+'</b></td>'+
        				'<td style="text-align: center;" ><b>'+value.paraTitle+'</b></td>'+
        				'<td style="text-align: center;" ><b>'+value.parasAction+'</b></td>'+
        				
        				'<td style="text-align: center;" ><b>'+value.discussPac+'</b></td>'+
        				'<td style="text-align: center;" ><b>'+value.pacincluded+'</b></td>'+
        				(((userunitId==createunitid)|| (userunitId==9832 && usercircleId ==21614) ) ? 	'<td style="text-align: center;"><b> <button type="button" class="btn btn-primary "  onclick="editsubpara('+value.cagParaId+')"  >Edit '+value.subParaNumber+'</button></b></td>' :'<td><td>')+
        				(((userunitId==createunitid)|| (userunitId==9832 && usercircleId ==21614) ) ?'<td style="text-align: center;color: red; "><b><button type="button" id="addPara"  class="btn btn-danger"  onclick="deleteSubPara('+value.cagGistId+','+value.cagParaId+')"  >Delete '+value.subParaNumber+'</button></td>':'<td><td>'));
      		
      		 $(table2).append($row);
      	
      		
      		
        	
      	});
         
      
                   
      },
      error : function(){
    	  alert(error);
      }
  }); 	
}
function deleteSubPara(cagGistId, cagParaId){
	
	 $('#action_alert').empty(); 
	 var valid = "Are you sure you want to delete Sub para?";
	  if (confirm(valid)) {  
		
	  $.ajax({	          
	      url: "../parastsimis/deletesubpara?cagParaId="+ cagParaId ,
	      method:"POST",
		 
	      success: function (response) {
	   
	    	 // alert("kal"+response);
	    	 
	    	 //  alert(finYear);
			    getCAGParaGist(cagGistId);
			    getSubParaList(cagGistId)
			    
			    if(response>0){
	    	 
	    	  $('#action_alert').html('<p>Data Deleted Successfully</p>');
			  //  $('#action_alert').dialog('open'); 
			    }
			    
			    if(response==0){
			    	 
			    	  $('#action_alert').html('<p>Failed to Delete</p>');
					  //  $('#action_alert').dialog('open'); 
					    }
			   // getunitData(unitId,circleId,divisionId) ;
			  

	      },
	      error : function(){
	    	 alert(error);
	      $('#action_paraalert').dialog('open');
	      }
	
	  
	  }); 
	  
	  }
      else{
      	
      	return false;
        
      }
	  
	
}
function editsubpara(cagParaId){
	
	//alert(cagParaId);
	$.ajax({	          
	      url: "../parastsimis/getSubparaListbyparaid",
	      type: "GET",
	      async: false,
	      data: {
	    	  cagParaId: cagParaId
	      },
	     
	      success: function (response) {
	    	
	    	
	    	//alert(response);
	    
			
			  
			  var obj = JSON.parse(response);
			
			// console.log(obj);
			  
			 
			/*  $('#difinancialYear').val(obj.cagGistId);
			 
			 var k=$('#difinancialYear').val();
			 
			 var gistid=parseInt(k);
			 
			 if(k>0){
				 alert("kal")
				 getCAGParaGist(gistid) ;
				 
			 } */
			  $('#diparaSequence').val(obj.paraSequence); 
			 // $('#diparaStatusId').val(obj.paraStatusId);
			  
			//  $('#disubParaUnitList').val(obj.subParaUnitList);
			  var rd=obj.discussPac;
			  //alert(rd);
			  var m=JSON.parse(rd);
			  
			  if(m==true){
			  $(".pac").attr('checked', true);
			  }
			 
			//  $('#didiscussPac').val(m);
			  $('#diparaTitle').val(obj.paraTitle);
			  $('#diparasAction').val(obj.parasAction);
			  $('#disubParaNumber').val(obj.subParaNumber);
			  
			  $('#dicagParaId').val(obj.cagParaId);
			  $('#dicagGistId').val(obj.cagGistId);
			  
			 	
			  var unitlist = obj.subParaUnitList;
			  var temp = new Array();
			  // this will return an array with strings "1", "2", etc.
			  temp = unitlist.split(",");
			//  console.log(temp);
			  for (a in temp ) {
				    temp[a] = parseInt(temp[a], 10); // will return an array containing integers, and not strings.
				}	
			 // console.log(temp);
			  
			  $("#disubParaUnitList").val(temp);
			  
			  $("#disubParaUnitList").multiselect("refresh");
			  
 $("#hiddensubParaUnitList").val(temp);
			  
			  $("#hiddensubParaUnitList").multiselect("refresh");
			  
			  
			  
			  
				
					
	  	  				
			
	    	 

	      },
	      error : function(){
	    	  alert(error);
	      }
	  }); 	
	  $('#subpara_dialogue').dialog('option', 'title', 'Edit Sub Para');
	
	
	 
	 
	
	  
	  
	
	  $('#subedit').text('Edit');
	  $('#subpara_dialogue').dialog('open');
	
	
	
	
}

		
</script>




<script type="text/javascript">

$(document).ready(function(){
	
	  $("#toffice").hide();
	  $("#dipacr").hide();
	  
	  $("#pacr").hide();
	  

	
	
	$('.rd1').click(function(){
		
		 var pac=  $('#discussPacy').prop('checked');
		 
		  if(pac==true) {
			
			
				  $("#pacr").show();
			}else {
				
				 $("#pacr").hide();
			}
		
		
		 });
	
	
	$('.pac').click(function(){
		
		var dipac=  $('#didiscussPacy').prop('checked');
		 

		
		
		//alert("dipac"+dipac);
		  if(dipac==true) {
			
			  $("#dipacr").show();
		}else {
			
			 $("#dipacr").hide();
		}
		
		
		
		 });
	 
	

	
	
	
	 
	
		
	  
	  
	  
	/*   $("#pac").hide(); */
	  
	  /* var d = new Date();
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
      
      */
      
      for(var f=1 ; f< 32 ;f++) {
    	  
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

	



	
/* 	$('#paraStatusId').multiselect({
		 
		 enableCaseInsensitiveFiltering: true
		 
	});
	 */
	

	$('#hiddensubParaUnitList').multiselect({
		 
		enableClickableOptGroups : true,
		enableCaseInsensitiveFiltering : true,
		enableCollapsibleOptGroups : false,
		includeSelectAllOption : true,
		disableIfEmpty : true
		
		 
		 
	});
	
	
	$('#hiddensubParaUnitList').next().hide();
	
	
	$('#gistSubPara').dialog({
		  autoOpen:false,
		  width:1200,
		  close: function() {
			  
			
				  $(this).dialog("close");
				  }
		 });



	$('#subdia1').click(function(){
			
		 $('#gistSubPara').dialog('option', 'title', 'CAG Sub Para Info');
		  $('#gistSubPara').dialog('open');
		
		 });
	 

	
	}); 

</script>




<script>
	

	

	$(function() {
		
		
		//$('#hiddensubParaUnitList').hide();
		 
	
		 
		 
		  
		var m = $(this).find('.ckedit')
		m.ckeditor();

		//alert("coming here")
		$('.ckedit').ckeditor();
		clicked();
		
		 $('#subpara_dialogue').dialog({
			  autoOpen:false,
			  width:1200
			 });
		
		 $('#subedit').click(function(){
			 
				// alert("kal1edit");
				 
				 $('#action_alert').empty();
				 
				 if ($('form[id=subparaid]').parsley().isValid()) {	
				 
			var paraSequence= $('#diparaSequence').val(); 
			var subParaNumber=$('#disubParaNumber').val(); 
			//var paraStatusId=$('#diparaStatusId').val(); 
			var subParaUnitList=$('#disubParaUnitList').val();
			var discussPac=$("input[class='pac']:checked").val();
			var paraTitle=$('#diparaTitle').val();
			var parasAction=$('#diparasAction').val();
			var cagParaId=$('#dicagParaId').val();
		    var cagGistId=$('#dicagGistId').val();
		    
		    var hiddenids=$('#hiddensubParaUnitList').val();
		    var paraUnitIdList=hiddenids.toString();
		    
		    var paraincl=$("input[id='didpacincl']:checked").val();
			
			var str=subParaUnitList.toString();
			
			//alert("discussPac"+discussPac);
		//	console.log("here"+str);
			//console.log("here"+discussPac);
		//	console.log("herehidden"+paraUnitIdList);
			//alert(finyear+"kals"+actionTitle+"kala"+ paraNumber+"kalr"+cagGistId);
				 //alert("kal1edit2");
				// alert("paraStatusId"+paraStatusId);
			  $.ajax({	          
			      url: "../parastsimis/editsubpara",
			      method:"POST",
			      async: false,
			      data: {
			    	  paraSequence: paraSequence,
			    	  subParaNumber :subParaNumber,
			    	//  paraStatusId :paraStatusId,
			    	  subParaUnitList:str,
			    	  discussPac:discussPac,
			    	  paraTitle: paraTitle,
			    	  parasAction: parasAction,
			    	  cagParaId:cagParaId,
			    	  cagGistId: cagGistId ,
			    	  paraUnitIdList:paraUnitIdList,
			    	  pacincluded:paraincl
			      },
			     
				 
			      success: function (response) {
			   
			    	 // alert("kal"+response);
			    	 
			    	 //  alert(finYear);
					   getSubParaList(cagGistId);
					    
					    if(response>0){
					    	
					    	 $('#subpara_dialogue').dialog('close'); 
			    	 
			    	  $('#action_alert').html('<p>Data Updated Successfully</p>');
					    }
					    if(response==0){
					    	
					    	  $('#action_alert').html('<p>Failed to Update data</p>');
					    }
					  //  $('#action_alert').dialog('open'); 
					  
					   // getunitData(unitId,circleId,divisionId) ;
					  

			      },
			      error : function(){
			    	 alert(error);
			      $('#action_alert').dialog('open');
			      }
			
			  
			  }); 	
				 
				 }else{
				   	 
				   	 $('form[id=subparaid]').parsley().validate();
				   	 
				    }
				 
			 });
		

		
		
	});

	/* var  str=null;
	function deselectedvalues(value){
		
		$('#disubParaUnitList').change(function() {
			  alert('The option with value ' + $(this).val() + ' and text ' + $(this).text() + ' was selected.');
			});
		
	}  */
	  
	 
		 

	
	
	

</script>



	
				
<div class="col-md-9">
	


<div>




						<div class="panel panel-primary ">
							<div class="panel-heading">
								<h3 class="panel-title">Add CAG Para/Sub Para <c:if test="${userObj!=null}">	
				<div class="span6 pull-right">
				
				Welcome to    
						
						
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
								
								
								<div class="row show-grid ">
<div class="alert alert-info" role="alert">
				<strong style="color:#CA3F22"> Note1: Please check the Sub Para in the below list after Selecting Year , if already Sub para is added do not add the SubPara. </strong>
				<br>
				<strong style="color:#CA3F22"> Note2: Please use 0 in the Sub Para Number, if the sub para doesn't have title </strong>
				

			</div>
			</div>
							
								
								<!-- 	<div id="action_alert" title="Action">

  </div> -->
	
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
							<form:form id="parasinput" method="post" modelAttribute="cagsubparas"
								data-parsley-validate-if-empty=""  enctype="multipart/form-data" >
								
								<input type="hidden" class=" form-control "  id="userunitId"   value="${userObj.unitId}" />
                               <input type="hidden" class=" form-control "  id="usercircleId"   value="${userObj.circleId}" />
								
								
								
<div class="col-md-12 invDiv">                                    
											
											<div class="col-md-4">
											<label class="label-control rowlebel ">Financial Year <font color=red>*</font> </label>
											 <select class="form-control" id="financialYear" name="financialYear" required onchange="getCAGParaGist(this.value),getSubParaList(this.value)"> 
											 <option value=" ">--select--</option>
											  <c:forEach items="${finList}" var="u">
									              <option value="${u.cagGistId}">${u.financialYear}</option>

								</c:forEach>
 
											 
											
											 </select></div> 
											 
											 		<div class="col-md-4">
	  <label class="label-control rowlebel ">Para / Sub Para Sequence<font color=red>*</font> </label>
	  
	  <select class="form-control paraSequence " id="paraSequence" name="paraSequence" required >
	  <option value="0">--select--</option>
	   </select>
       
       
      
										
    <span id="error_paraSequence" class="text-danger"></span>
    </div>
    
    
    
    <div class="col-md-4">
     <label class="label-control rowlebel ">Para / Sub Para Number<font color=red>*</font> </label>
	  <input type="text" class=" form-control "  id="subParaNumber" name="subParaNumber" placeholder="EX:3.1.1"  required  /> 
	 
       
      
										
    <span id="error_subParaNumber" class="text-danger"></span>
    </div>
											 
											 
										    	
											
											
											
										      
										      </div>
										   
										
									
											
											 
											<div class="col-md-12 invDiv">
												
    

<!--     
    <div class="col-md-4">
										<label class="label-control rowlebel ">
										Select Para Status  <font color=red>*</font>  </label>
										<select class="paratrunit form-control" id="paraStatusId" name="paraStatusId"  required> 
										<option value=" ">--select--</option> 
										 <option value="1">Reply Sent to AG</option>
										<option value="4">Reply Sent to Government</option> 
										
									    <option value="5">Reply Sent</option>  
									    <option value="2">Reply Not Sent</option> 										
									
										<option value="3">Dropped</option> 
									   
									     
										 </select>
										 
										  <span id="error_paraStatusId" class="text-danger"></span>
									     </div> -->
									     
									     

												
												 <div class="col-md-6" id="dispac">
        <label class="label-control rowlebel ">Discussed in PAC <font color=red>*</font> </label>
         <!--  <div class="form-group"> -->
        <label class="radio-inline"> <input class="rd1" type="radio" name="discussPac" id="discussPacn"  checked="checked"    value="false"  required >NO</label>
        <label class="radio-inline"> <input class="rd1" type="radio" name="discussPac" id="discussPacy"     value="true"  required >Yes</label>
      <!--  </div> -->
     <span id="error_discussPac" class="text-danger"></span>
        </div>
        
         <div class="col-md-6" id="pacr">
        <label class="label-control rowlebel ">PAC Recommendations <font color=red>*</font> </label>
        <!--   <div class="form-group"> -->
        <label class="radio-inline"> <input class="pacincl" type="radio" name="pacincluded" id="pacincln"  checked="checked"   value="false"  required >NO</label>
        <label class="radio-inline"> <input class="pacincl" type="radio" name="pacincluded" id="pacincly"     value="true"  required >Yes</label>
     <!--   </div> -->
     <span id="error_discussPac" class="text-danger"></span>
        </div>
      
        	<div class=" col-md-12">
        	  <br>
	<label class="label-control rowlebel ">Pertains to Unit   <font color=red>*</font> </label>
													
													
													<select class="form-control" id="subParaUnitList" name="subParaUnitList"  multiple="multiple"  required>
												
												
												 <c:forEach items="${unitList}" var="u">
									              <option value="${u.unitId}">${u.unitName}</option>

								</c:forEach>
 
												
												
												</select>
												
												 <span id="error_subParaUnitList" class="text-danger"></span>
												
												</div>
									     
   </div> 
   

											
										    <div class="col-md-12">
										     <label class="label-control ">
										     Gist of  Para / Sub Para  <font color=red>*</font>  </label>
										      <textarea  class=" form-control "  id="actionTitle" name="actionTitle" readonly="readonly" required rows="1" cols="80"></textarea>
										       <input type="hidden" class=" form-control "  id="cagGistId" name="cagGistId" readonly="readonly" required  />  
										    
										  
										    </div>
										     
   
   
   
    
   <div class="col-md-12">

	  <label class="label-control rowlebel ">Para / Sub Para Title<font color=red>*</font> </label>
        <input type="text" name="paraTitle" id="paraTitle" class="  form-control "     required />
       
      
     				
										
    <span id="error_paraTitle" class="text-danger"></span>
   </div> 
							 
							  
    <div class="col-md-12">
   	<label class="label-control rowlebel ">Para / Sub Para*</label> 
	<textarea class="ckedit form-control "  id="parasAction" name="parasAction" rows="10" cols="80" placeholder="Para"  ></textarea>
    <span id="error_parasAction" class="text-danger"></span>
   </div>
   
 
   <div class="col-md-12">
										<div class="col-md-2 "></div>
										<div class="col-md-8 ">
											<label class="label-control rowlebel "></label><input
												type="submit" class="btn btn-1 btn-primary center-block"
												id="submitparas" value="Submit Para /Sub Para" onclick="insertcagsubpara()">
										</div>
									</div>
											 			
								
				

	</form:form>
	
	

	
	
		
&emsp;&emsp;

 &emsp;&emsp;
					 
					 <div class="col-md-12">
										<div class="col-md-2 "></div>
										<div class="col-md-8 ">
											<button type="button" name="subdia" id="subdia1"
									class="btn btn-1 btn-primary center-block diaviewsubpara">View/Edit/Delete Submitted Sub Para Info</button>
										</div>
									</div>

<div id="gistSubPara">
<div class="col-md-12 show-grid gridList mainprint pagecontent"  style="display: block">
  <div class="table-responsive" id="printarea">
     <table class=" display table-bordered" id="sub-para" style="width: 100%">
     <thead>
      <tr style="color: blue; ">
    
    
      <th style="text-align: center;"><b>Para/Sub Para Sequence</b></th>
       <th style="text-align: center;"><b>Para / Sub Para Number</b></th>
         <th style="text-align: center;"><b>Pertains to Unit</b></th>
       <th style="text-align: center;"><b>Para/ Sub Para Title</b></th>
       <th style="text-align: center;"><b>Para / Sub Para</b></th>
      
         <th style="text-align: center;"><b>Discussed in PAC</b></th>
          <th style="text-align: center;"><b>PAC Recommendations</b></th>
      
    
       <th style="text-align: center;"><b>Edit</b></th>
        <th style="text-align: center;"><b>Delete</b></th>
    
      </tr>
      </thead>
      <tbody id="subparadata">
   
     </tbody>
     </table>
     
    </div>
    </div>
    </div>
    
 
   
			

								</div>
						



						

						</div>
						</div>
						</div>
						
						<div id="subpara_dialogue">
						
						  <form:form id="subparaid" method="post" modelAttribute="caggist"
		name="cagform" data-parsley-validate-if-empty=""  enctype="multipart/form-data">


<!-- <div class="col-md-6">     -->                                 <!-- onchange="getCAGParaGist()" -->

										<%--  <div class="col-md-6">
											<label class="label-control rowlebel ">Financial Year <font color=red>*</font> </label>
											</div>
											
											<div class="col-md-6">
											
											<input type="hidden" class=" form-control "  id="difinancialYear" name="financialYear" readonly="readonly" required  onchange="getCAGParaGist(),getSubParaList(this.value)" />
											 <select class="form-control" id="difinancialYear" name="financialYear" required > 
											 <option value=" ">--select--</option>
											  <c:forEach items="${finList}" var="u">
									              <option value="${u.cagGistId}">${u.financialYear}</option>

								</c:forEach>
 
											 
											
											 </select>
											 </div> 
											  
											 
										    	
											</div>
											
										<div class="col-md-6">
											
										    <div class="col-md-6">
										     <label class="label-controlPMS rowlebel ">
										     Gist of  Para  <font color=red>*</font>  </label>
										      <textarea style="width: 543px; height: 37px; " class=" form-control "  id="diactionTitle" name="actionTitle" readonly="readonly" required rows="1" cols="80"></textarea>
										       <input type="hidden" class=" form-control "  id="dicagGistId" name="cagGistId" readonly="readonly" required  />  
										    
										  
										    </div>
										      </div>
										   
										 --%>
									
											
											 
											<div class="row col-md-12">
											
    
		<div class="col-md-3">
	  <label class="label-control rowlebel ">Para Sequence<font color=red>*</font> </label>
	  
	  <select class="form-control paraSequence " id="diparaSequence" name="paraSequence" required >
	  <option value="0">--select--</option>
	   </select>
       
       
      
										
    <span id="error_paraSequence" class="text-danger"></span>
    </div>
    
    <div class="col-md-3">
     <label class="label-controlPMS rowlebel ">Para/Sub Para Number<font color=red>*</font> </label>
	  <input type="text" class=" form-control "  id="disubParaNumber" name="subParaNumber" placeholder="EX:3.1.1"  required  /> 
	 <input type="hidden" class=" form-control "  id="dicagGistId" name="cagGistId" readonly="readonly" required  />
	  <input type="hidden" class=" form-control "  id="dicagParaId" name="cagParaId" readonly="readonly" required  />
       
      
										
    <span id="error_subParaNumber" class="text-danger"></span>
    </div>
    
<!--     <div class="col-md-3">
										<label class="label-control rowlebel ">
										Select Para Status  <font color=red>*</font>  </label>
										<select class="paratrunit form-control" id="diparaStatusId" name="paraStatusId"  required> 
										<option value=" ">--select--</option> 
										 <option value="1">Reply Sent to AG</option>
										<option value="4">Reply Sent to Government</option> 
										<option value="5">Reply Sent</option> 
									    <option value="2">Reply Not Sent</option> 										
									
										<option value="3">Dropped</option> 
									     <option value="4">Reply Sent to Government</option> 
									     
										 </select>
										 
										  <span id="error_paraStatusId" class="text-danger"></span>
									     </div> -->
									     
									     

												
												 <div class="col-md-3" id="didisspac">
        <label class="label-control rowlebel ">Discussed in PAC <font color=red>*</font> </label>
          <div class="form-group">
        <label class="radio-inline"> <input class="pac" type="radio" name="discussPac" id="didiscussPacn"  checked="checked"   value="false"  required >NO</label>
        <label class="radio-inline"> <input class="pac" type="radio" name="discussPac" id="didiscussPacy"     value="true"  required >Yes</label>
       </div>
     <span id="error_discussPac" class="text-danger"></span>
        </div>
        
        
         <div class="col-md-3" id="dipacr">
        <label class="label-control rowlebel ">PAC Recommendations <font color=red>*</font> </label>
          <div class="form-group">
        <label class="radio-inline"> <input class="pacincl" type="radio" name="pacincluded" id="didpacincl"  checked="checked"   value="false"  required >NO</label>
        <label class="radio-inline"> <input class="pacincl" type="radio" name="pacincluded" id="didpacincl"     value="true"  required >Yes</label>
       </div>
     <span id="error_discussPac" class="text-danger"></span>
        </div>
        
        	<div class=" col-md-12">
        	<br>
	<label class="label-control rowlebel ">Pertains to Unit   <font color=red>*</font> </label>
													
													
													<select class="form-control" id="disubParaUnitList" name="subParaUnitList"  multiple="multiple"  required >
												
												
												 <c:forEach items="${unitList}" var="u">
									              <option value="${u.unitId}">${u.unitName}</option>

								</c:forEach>
 
												
												
												</select>
												
												
												
												
												
												
												 <span id="error_subParaUnitList" class="text-danger"></span>
												
												</div>
									     
   </div> 
   
   
   
   
   
  
   <div class="col-md-12">
   <br>

	  <label class="label-controlPMS rowlebel ">Para / Sub Para Title<font color=red>*</font> </label>
        <input type="text" name="paraTitle" id="diparaTitle" class="  form-control "     required />
       
      
     				
										
    <span id="error_paraTitle" class="text-danger"></span>
   </div> 
							 
							  
    <div class="col-md-12">
    
      <br>
       
  
   	<label class="label-control rowlebel ">Para/Sub Para<font color=red>*</font></label> 
	<textarea class="ckedit form-control "  id="diparasAction" name="parasAction" rows="10" cols="80" placeholder="Para"  required
	data-parsley-errors-container="#purpose-errors" data-parsley-required-message="Please Enter Para Information!" data-parsley-group="block1" ></textarea>
    <span id="error_parasAction" class="text-danger"></span>
   </div>
   
 
   <div class="col-md-12">
										<div class="col-md-2 "></div>
										<div class="col-md-8 ">
											<label class="label-control rowlebel "></label><input
												type="button" class="btn btn-1 btn-primary center-block"
												id="subedit" value="Edit">
										</div>
									</div>
											 			
											 
									<select  class="form-control" id="hiddensubParaUnitList" name="hiddensubParaUnitList[]"  multiple="multiple" >
												
												
												 <c:forEach items="${unitList}" var="u">
									              <option value="${u.unitId}">${u.unitName}</option>

								</c:forEach>
 
												
												
												</select>
														
								</form:form>		
	
									</div>
									

							
  <div id="JQResult"></div>
  
  
  							
						
  

						



<!-- //main-content -->
<script type="text/javascript" src="../js/parsley.js"></script>



<script type="text/javascript" class="example">
	/* $(function() {
		$('#parasinput').parsley().on('field:validated', function() {
			var ok = $('.parsley-error').length === 0;

			

		})
			
	
		.on('submit', function(event) {
			// alert("coming here");
         // alert('kal');
			 event.preventDefault();
			 alert('hi');
		  var count_data = 0;
		  $('.actionTitle').each(function(eve){
		   count_data = count_data + 1;
		  });
		  if(count_data > 0)
		  {
			
		   var form_data = $(this).serialize();
		 //  alert("form"+form_data);
		 
		   
		 /*    document.forms.parasinput.action = "../parastsimis/addPara";
			document.forms.parasinput.submit(); */
		/*   }
		  else
		  {
			  event.preventDefault();
		   $('#action_alert').html('<p>Please Add atleast one data</p>');
		   $('#action_alert').dialog('open');
		 
		  }
		  return false;	
			// Don't submit form for this demo
		});
	}); */
</script>

