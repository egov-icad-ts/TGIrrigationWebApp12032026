
<!--main code block-->
<!-- sec-section -->

<!-- create component start here -->
<%@include file="/jsp/header/taglib_includes.jsp"%>


<link rel="stylesheet" href="../css/bootstrap-multiselect.css" 	type="text/css">
<!-- <script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script> -->
<script type="text/javascript" src="../js/bootstrap-multiselect.js"></script>

<link rel="stylesheet" media="screen" href="../css/jquery-ui.css">
<script type="text/javascript" src="../js/jquery-ui.js"></script>
<script type="text/javascript" src="../js/ckeditor/ckeditor.js"></script>
 <script type="text/javascript" src="../js/ckeditor/adapters/jquery.js"></script>




<script type="text/javascript">


	
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
      
 /*      
 for(var f=1 ; f< 20 ;f++) {
    	  
    	  var option = "<option value=" + parseInt(f) + " > "+ parseInt(f) + "</option>"
          // alert(option);
           
           $('.paraSequence').append(option);
            
    	  
    	  
      } */
	
		 
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

function editcagparas(){
	
	alert("coming here");
	
	 $('#editFlag').val(true);
	 

	
	 	
	 	
	 	
	 	 
	 	 document.forms[0].urlvalue.value="../parastsimis/editcagparareply";
	 		
	 	
	 	 
	 	
	 		 document.forms[0].submit(); 
	 	
	 	
	
}

	
</script>




<script>
	

	

	$(function() {
		
		
		
	
		
		
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
		
		 
		 var cm =$('input:radio[name=transferFlag]:checked').val();
		// alert("cm"+cm);
		 
	            if (cm == 'true') {
	            	 $("#toffice").show();
	            }
	            if (cm == 'false') {
	            	$("#toffice").hide();
	            }
	       
		
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
								<h3 class="panel-title">Edit CAG Para & Reply</h3>
							</div>
							<form:form id="parasinput" method="post" modelAttribute="editcagparareplybypara"
								data-parsley-validate-if-empty=""  enctype="multipart/form-data" >
								<div class='container'>

                           
                            
                               
                            
				
			
			
				
				<input name=editFlag id="editFlag" type=hidden  value="false" >
				
				
			
                                
									<div class="row col-md-12 toppad ">



											
				
									
									

								
								

									
					
	
								
								
	<c:if test="${cagParasData!=null}">
	  <c:set var="f" value="0" scope="page" />
	<c:forEach items="${cagParasData}" var="t" varStatus="count">
	 <input type="hidden" name="paraDataList[${f }].cagParaId" id="paraDataList[${f }].cagParaId" class="form-control actionTitle" value="${t.cagParaId} " />
<div class="col-md-12" style="border: solid;border-color: gray;">	
 <div class="col-md-6">
<br></br>
  <div class="table-responsive">
     <table class="table table-striped table-bordered" id="para_data">
     
      <tbody>
      
      <tr>
       <td>
        <label class="label-control rowlebel " style="color: red">Para Sequence*</label> 
      
        <select class="form-control  " id="paraDataList[${f }].paraSequence" name="paraDataList[${f }].paraSequence" required >
        
	 <option value=" ">--select--</option> 
										 
										     <option value="1" ${t.paraSequence == '1' ? 'selected' : ''} >1</option> 
										       
										     <option value="2"  ${t.paraSequence == '2' ? 'selected' : ''}>2</option> 
										     <option value="3"  ${t.paraSequence== '3' ? 'selected' : ''} >3</option>
										      <option value="4"  ${t.paraSequence == '4' ? 'selected' : ''}>4</option>
										      <option value="5"  ${t.paraSequence == '5' ? 'selected' : ''}>5</option>
										      <option value="6"  ${t.paraSequence == '6' ? 'selected' : ''}>6</option>
										        <option value="7"  ${t.paraSequence == '7' ? 'selected' : ''}>7</option>
										          <option value="8"  ${t.paraSequence == '8' ? 'selected' : ''}>8</option>
										            <option value="9"  ${t.paraSequence == '9' ? 'selected' : ''}>9</option>
										              <option value="10"  ${t.paraSequence == '10' ? 'selected' : ''}>10</option>
										                <option value="11"  ${t.paraSequence == '11' ? 'selected' : ''}>11</option>
										                  <option value="12"  ${t.paraSequence == '12' ? 'selected' : ''}>12</option>
										                    <option value="13"  ${t.paraSequence == '13' ? 'selected' : ''}>13</option>
										                      <option value="14"  ${t.paraSequence == '14' ? 'selected' : ''}>14</option>
										                        <option value="15"  ${t.paraSequence == '15' ? 'selected' : ''}>15</option>
										                          <option value="16"  ${t.paraSequence == '16' ? 'selected' : ''}>16</option>
										                            <option value="17"  ${t.paraSequence == '17' ? 'selected' : ''}>17</option>
										                              <option value="18"  ${t.paraSequence == '18' ? 'selected' : ''}>18</option>
										                                <option value="19"  ${t.paraSequence == '19' ? 'selected' : ''}>19</option>
	   <%--  <option value="<c:out value="${t.paraSequence}" ></c:out>" selected="selected" ><c:out value="${t.paraSequence}" ></c:out></option> --%>
	   </select>
       
       </td>
         </tr>
            <tr>
      <td>
        <label class="label-control rowlebel " style="color: red">Gist of Para*</label> 
      
      <textarea class="form-control "  id="paraDataList[${f }].paraTitle" name="paraDataList[${f}].paraTitle" rows="2" cols="80" placeholder="Para"    required> <c:out value="${t.paraTitle}" ></c:out></textarea>
       </td>
       </tr>
         <tr>
        <td>
        	<label class="label-control rowlebel " style="color: red">Para*</label> 
	<textarea class="ckedit form-control "  id="paraDataList[${f}].parasAction" name="paraDataList[${f}].parasAction" rows="5" cols="80" placeholder="Para"    required
	data-parsley-errors-container="#purpose-errors" data-parsley-required-message="Please Enter Para Information!" data-parsley-group="block1"> <c:out value="${t.parasAction}" escapeXml="false"></c:out></textarea>
     
       </td>
      
        
      </tr>
          <tr> <td></td> <td style="margin-bottom: 20px;color: red; text-align: center;" id="purpose-errors"></td></tr>
       <c:set var="f" value="${f + 1}" scope="page"/>
      
      </tbody>
     </table>
    </div>
      </div> 
      
       <div class="col-md-6">
       <br></br>
       <div class="table-responsive">
     <table class="table table-striped table-bordered" id="reply_data">
     
     
   
      <tbody>
      
      <c:if test="${replyListDB!=null}">
      <c:set var="d" value="0" scope="page" />
      <c:forEach items="${replyListDB }" var="r"  varStatus="count">
      <c:if test="${t.cagParaId==r.cagParaId }">
       <input type="hidden" name="replyDataList[${d}].paraReplyId" id="replyDataList[${d}].paraReplyId" class="form-control actionTitle" value="${r.paraReplyId} " />
      <tr> 
       <td>
        <label class="label-controlPMS rowlebel " style="color: blue">Para seq: <c:out value="${r.paraseq}" ></c:out>Reply Date  <font color=red>*</font> </label>
	
        <input type="text" name="replyDataList[${d}].replyDate" id="replyDataList[${d}].replyDate" class="datepick form-control datepicker"   value="<c:out value="${r.replyDate}" ></c:out>"    readonly="readonly"  required />
       
       
       </td>
       
       
      
      </tr>

<tr>
      <td>
      <label class="label-control rowlebel " style="color: blue">Reply*</label> 
	<textarea class="ckedit form-control "  id="replyDataList[${d}].replyAction" name="replyDataList[${d}].replyAction" rows="5" cols="80" placeholder="reply"    required> <c:out value="${r.replyAction}" escapeXml="false"></c:out></textarea>
      </td>
      </tr>
        <tr>
      <td>
        <label class="label-control rowlebel " style="color: blue">Remarks</label> 
      
      <textarea class="form-control "  id="replyDataList[${d}].replyRemarks" name="replyDataList[${d}].replyRemarks" rows="2" cols="80" placeholder="remarks"    > <c:out value="${r.replyRemarks}" ></c:out></textarea>
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
     </div>
      </c:forEach>
      </c:if>
      
    
								


									<div class="col-sm-12">
										<div class="col-md-2 "></div>
										<div class="col-md-8 ">
											<label class="label-control rowlebel "></label><input
												type="submit" class="btn btn-1 btn-primary center-block"
												id="submitparas" value="Submit CAG Paras" onclick="editcagparas()">
										</div>
									</div>







								</div>
								
							
								</div>
								<!-- row -->





							</form:form>

						</div>

														
							
  
  
  
  						

						


</div>
<!-- //main-content -->
<script type="text/javascript" src="../js/parsley.js"></script>

