
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
<script type="text/javascript" src="../js/jquery-ui-timepicker-addon.min.js"></script>
<script type="text/javascript" src="../js/ckeditor/ckeditor.js"></script>
<script type="text/javascript" src="../js/ckeditor/adapters/jquery.js"></script>

<script type="text/javascript">



//alert("kal1");
var rowCount = 0



function removeRow(removeNum) {
	jQuery('#rowCount' + removeNum).remove();
}
	
/* 	
function clicked(){
	
	$("#parasAction").attr('required', '');
	for ( instance in CKEDITOR.instances ){
		
		CKEDITOR.instances[instance].getData();
	//alert("ckeditor values : " + CKEDITOR.instances[instance].getData());
	

	}
	} */
	
	
	function insertcaggist(){
		
		
		
	
		if ($('form[id=parasinput]').parsley().isValid()) {
		
		var act1 = "../parastsimis/addCAGParaGist"
var newformId1 = "#parasinput" 

$(newformId1).attr("action", act1);

$(newformId1).submit();

	}else{
   	 
   	 $('form[id=parasinput]').parsley().validate();
   	 
    }
    
		
	}
	

function getcagGist(finYear){
//	alert("cmoing here"+finYear);
	//var districtId=document.getElementById("districtId").value;
	//var finYear=document.getElementById("financialYear").value;
	//alert(cagGistId);
	
	  $("#gistparahead").empty(); 
	  $("#gistparadata").empty(); 
  
   $('#action_alert').empty();
	  $.ajax({	          
      url: "../parastsimis/getParagistbyFinYear",
      type: "GET",
      async: false,
      data: {
    	  financialYear: finYear
      },
     
     
      success: function (response) {
    	  
    	//  $("#gistparadata").empty(); 
    	  
    	 // console.log(response);
    	  
    	//  var table1 = $("#gist-para tbody");
    	  
    	  if(response!=null){
    		  
    		  
    		  $('#gisttable table thead').append( '<tr style="font-size: 18px; color: blue; font-weight: bold;"><th>Financial Year</th>'+
	    	    		' <th>Para Number</th>'+
	    	    		'<th>Gist of Para</th>'+
	    	    	
	    	    		'  <th>Edit 	</th>'+
	    	    		
	    	    		'  <th>Delete </th>'+
	    	    		
	    	    		
	    	    		'</tr>'); 	  
    	
          var obj = JSON.parse(response);
          
          $("#deletealert").html("Note : Gist of the para Can not be Edited or Deleted Once the subpara is entered"); 
          
         
        	//console.log(obj);
        	
        	for(var m in obj ){
        	//	alert(obj[m].financialYear);
        	
        	//alert(obj[m].subparacount);
        	
        	var k=obj[m].subparacount;
        	
        	var createbyunit=obj[m].unitId;
        	
        	var userunitId=$('#userunitId').val();
        	var usercircleId=$('#usercircleId').val();
        	
        	//alert("userunitId"+userunitId);
        	//alert("createbyunit"+createbyunit);
        	
        	
        	 $("#gisttable table tbody").append('<tr> <td style="text-align: center;"><b>'+obj[m].financialYear+'</b></td>'+
        			  '<td style="text-align: center;"><b>'+obj[m].paraNumber+'</b></td>'+
        				'<td style="text-align: center;"><b>'+obj[m].actionTitle+'</b> <input type="hidden" class=" form-control "  id="cagGistId" name="cagGistId" readonly="readonly" required value="'+obj[m].cagGistId+'" /> </td>'+         				
        				
        				 (((k < 1)&&((userunitId==createbyunit))|| (userunitId==9832 && usercircleId ==21614) ) ? '<td style="text-align: center; color:blue; font-weight: bold;"><b> <button type="button" class="btn btn-primary "  onclick="editparagist('+obj[m].cagGistId+')"  >Edit</button></b></td>':'<td>Sub Paras Exist /Not Allowed</td>')+
        				 (((k < 1)&&((userunitId==createbyunit))|| (userunitId==9832 && usercircleId ==21614) ) ?'<td style="text-align: center;color: red; font-weight: bold;"><b><button type="button" id="addPara"  class="btn btn-danger"  onclick="deleteGist('+obj[m].cagGistId+',\''+obj[m].financialYear+'\')"  >Delete Gist Para</button></b></td>' :'<td>Sub Paras Exist /Not Allowed</td>')+    
        				
        				'</tr>');
        	   
        	  
        	}
         
        	 // alert(response);
        	
        	
    	  }
                   
      },
      error : function(){
    	  alert(error);
      }
  }); 	
}

function deleteGist(gistId,finYear){
	//alert(finYear);
	
	//alert(gistId+"kal"+finYear);
	
	 $('#action_alert').empty(); 
	    
	  var valid = "Are you sure you want to delete gist?";
	  
	  if (confirm(valid)) {
		  
	  $.ajax({	          
	      url: "../parastsimis/deleteCagGist?cagGistId="+ gistId ,
	      method:"POST",
		 
	      success: function (response) {
	   
	    	 // alert("kal"+response);
	    	 
	    	 //  alert(finYear);
			    getcagGist(finYear);
	    	 
	    	  $('#action_alert').html('<p style="margin: 0px !important;">Data Deleted Successfully</p>');
			  //  $('#action_alert').dialog('open'); 
			  
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

function editparagist(gistId){
	
	  $('#gist_dialogue').dialog('option', 'title', 'Edit Gist Data');
		
		
		
	  $('#edit').text('Edit');
	  $('#gist_dialogue').dialog('open');
	
	
	$.ajax({	          
	      url: "../parastsimis/getlistofgist",
	      type: "GET",
	      async: false,
	      data: {
	    	  cagGistId: gistId
	      },
	     
	      success: function (response) {
	    	
	    	
	    	
	    
			
			  
			  var obj = JSON.parse(response);
			
			 // console.log(obj);
			  
			  $('#actionTitle').val();   
			//  $('#dicagGistId').val(obj.cagGistId);   
	          
			 
			  $('#diFinYear').val(obj.financialYear); 
			  $('#diparaNumber').val(obj.paraNumber);
			  
			  $('#dicagGistId').val(obj.cagGistId);
			  
			  
			  
			  var textdata=obj.parasAction ;
			  $('#diactionTitle').val(textdata);
			 	
					
					
						
						
					
	  	  				
			
	    	 

	      },
	      error : function(){
	    	  alert(error);
	      }
	  }); 	
	
	
	
}
		   
</script>



<script type="text/javascript">

$(document).ready(function(){
	
	 $('#action_alert').empty();
	
	
	  var d = new Date();
	  var e=new Date();
	 e= e.getFullYear() - 39;
	  var j=00;
      for (var i = 40; i >= 0; i--) {
    	 // alert(i);
          var option = "<option value=" + parseInt(d.getFullYear() - i) +"-"+e+ ">" + parseInt(d.getFullYear() - i) +"-"+e+ "</option>"
         // alert(option);
          
          $('[id*=financialYear]').append(option);
          $('[id*=diFinYear]').append(option);
          e++;
         // j++;
      }
      
     
      
     
	
	$('#financialYear').multiselect({
		 
		 enableCaseInsensitiveFiltering: true
		 
	});

	



	
	
	 
	 
	 
	

	}); 

</script>




<script>
	

	

	$(function() {
		
		 $('#gist_dialogue').dialog({
			 autoOpen:false,
			  width:1200,
			  close: function() {
				  
				
					  $(this).dialog("close");
					  }
			 });

		 $('#edit').click(function(){
			 
			// alert("kal1");
			
			// $('#gist_dialogue').dialog('option', 'title', 'Edit Cag Gist');
			//  $('#gist_dialogue').dialog('open');
			 
			 $('#action_alert').empty();
			 
			 if ($('form[id=gistformid]').parsley().isValid()) {
			 
		var finyear= $('#diFinYear').val(); 
		var actionTitle=$('#diactionTitle').val(); 
		var paraNumber=$('#diparaNumber').val(); 
		var cagGistId=$('#dicagGistId').val();
		
		//alert(finyear+"kals"+actionTitle+"kala"+ paraNumber+"kalr"+cagGistId);
		
		  $.ajax({	          
		      url: "../parastsimis/editcaggist",
		      method:"POST",
		      async: false,
		      data: {
		    	  financialYear: finyear,
		    	  actionTitle :actionTitle,
		    	  paraNumber :paraNumber,
		    	  cagGistId:cagGistId
		    	  
		      },
		     
			 
		      success: function (response) {
		   
		    	 // alert("kal"+response);
		    	 
		    	 //  alert(finYear);
				    getcagGist(finyear);
				    
				    if(response>0){
				    	
				    	 $('#gist_dialogue').dialog('close'); 
		    	 
		    	  $('#action_alert').html('<p style="margin: 0px !important;">Data Updated Successfully</p>');
				    }
				    if(response==0){
				    	
				    	  $('#action_alert').html('<p style="margin: 0px !important;">Failed to Update data</p>');
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
			   	 
			   	 $('form[id=gistformid]').parsley().validate();
			   	 
			    }
			 
			 
			 
		 });
		 
		 
	

	});	
	
	

</script>



<div class="col-md-9">

<div>
						<div class="panel panel-primary ">
							<div class="panel-heading">
								<h3 class="panel-title">Add CAG Para Gist <c:if test="${userObj!=null}">	
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
<div class="alert alert-info" role="alert" id="action_alert">
				
				

			</div>
			</div>
									
						
						
				
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
						
							
							
				
							
							<form:form id="parasinput" method="post" modelAttribute="cagparasgist"
								data-parsley-validate-if-empty=""  enctype="multipart/form-data" >
								
                               <input type="hidden" class=" form-control "  id="userunitId"   value="${userObj.unitId}" />
                               <input type="hidden" class=" form-control "  id="usercircleId"   value="${userObj.circleId}" />
                               
                             
<div class="col-md-6">

										<div class="col-md-6">
											<label class="label-control rowlebel ">Financial Year <font color=red>*</font> </label>
											</div>
											
											<div class="col-md-6">
											 <select class="form-control" id="financialYear" name="financialYear" required onchange="getcagGist(this.value)"> 
											 <option value=" ">--select--</option>
											
											 </select></div> 
											 
											 
										    	
											</div>
											
											<div class="col-md-6">
											<div class="col-md-6">
										    <label class="label-control rowlebel ">
										    Para Number  <font color=red>*</font>  </label>
										    </div>
										    <div class="col-md-6">
										    <input type="text" class=" form-control "  id="paraNumber" name="paraNumber" placeholder="EX:3.1"  required  />  
										    <!-- data-parsley-pattern="^[0-9]*\.[0-9]{1}$" --></div>
										      </div>
										   
										
										
											<div class="col-md-12"  >
		<div class="col-md-3"  >
 <label class="label-control rowlebel ">Gist Of Para<font color=red>*</font> </label>
 </div>
 <div class="col-md-9"  >
        <textarea  name="actionTitle" id="actionTitle" class="  form-control "  rows="2" cols="80"   required > </textarea>
        </div>
											 </div>		
											 
											 <div class="col-md-12"  >
	<br></br>
	
											 
   
			<div class="col-sm-12">
										<div class="col-md-2 "></div>
										<div class="col-md-8 ">
											<label class="label-control rowlebel "></label><input
												type="submit" class="btn btn-1 btn-primary center-block"
												id="submitparas" value="Submit CAG Para Gist" onclick="insertcaggist()">
										</div>
									</div>
											 			
											
										
	
									</div>
									

	</form:form>
	

&emsp;&emsp;

<div  id="gisttable">
	<div class="col-md-12 show-grid gridList mainprint pagecontent" 	style="display: block">
	<div class="table-responsive" id="printarea">
     <table class="display  table-bordered" id="gist-para">
     <thead id="gistparahead">
    
      </thead>
      <tbody id="gistparadata">
   
     </tbody>
     </table>
     
    </div>
    </div>
    </div>
    
    	</div>
							
					</div>
					
					</div>
					</div>
					
    

  
  <div id="gist_dialogue" >
  
  <form:form id="gistformid" method="post" modelAttribute="caggist"
		name="cagform" data-parsley-validate-if-empty=""
		enctype="multipart/form-data">
		
								      
		
									
											<div class="col-md-6">
											<label class="label-control  ">Financial Year <font color=red>*</font> </label>
											 <select class="form-control" id="diFinYear" name="financialYear" required onchange="getcagGist(this.value)"> 
											 <option value=" ">--select--</option>
											
											 </select></div> 
											 
											
											
										  
										   
										    <div class="col-md-6">
										      <label class="label-control  ">
										    Para Number  <font color=red>*</font>  </label>
										    <input type="text" class=" form-control "  id="diparaNumber" name="paraNumber" placeholder="EX:3.1"  required  /> 
										      <input type="hidden" class=" form-control "  id="dicagGistId" name="cagGistId" readonly="readonly" required  />
										      
										     <!--  data-parsley-pattern="^[0-9]*\.[0-9]{1}$" -->
										     </div>
										    
										   
										
										
											<div class="col-md-12"  >
		
 
  <label class="label-control rowlebel ">Gist Of Para<font color=red>*</font> </label>
        <textarea  name="actionTitle" id="diactionTitle" class="  form-control "  rows="2" cols="80"   required > </textarea>
       
											 </div>		
											 
											 <div class="col-md-12" style="text-align: center;"  >
											 
											  <button type="button" name="edit" id="edit" class="btn btn-info" >Edit</button>
											  
											  </div>
											 
</form:form>
  </div>

						
							

							
  
  							
							

						



<!-- //main-content -->
<script type="text/javascript" src="../js/parsley.js"></script>



