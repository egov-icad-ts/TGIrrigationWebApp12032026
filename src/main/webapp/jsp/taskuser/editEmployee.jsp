	<!--main code block-->
	<!-- sec-section -->
	
	<!-- create component start here -->
<%@include file="/jsp/header/taglib_includes.jsp"%> 

<!-- <link rel="stylesheet" type="text/css" href="../css/print.css" /> -->

<link rel="stylesheet" href="../css/bootstrap-multiselect.css"
	type="text/css">
<script type="text/javascript" src="../js/bootstrap-multiselect.js"></script>
<script type="text/javascript" src="../js/jquery-ui.js"></script>
<link rel="stylesheet" media="screen" href="../css/jquery-ui.css">
 
 
 <link rel="stylesheet" href="../css/treeview/jquery.treeview.css" />
<!-- <link rel="stylesheet" href="../red-treeview.css" /> -->

<!-- <script src="../js/treeview/lib/jquery.js" type="text/javascript"></script> -->
<script src="../js/treeview/lib/jquery.cookie.js" type="text/javascript"></script>
<script src="../js/treeview/jquery.treeview.js" type="text/javascript"></script>
 
  <script type="text/javascript">
/* var tableToExcel = (function() {
  var uri = 'data:application/vnd.ms-excel;base64,'
    , template = '<html xmlns:o="urn:schemas-microsoft-com:office:office"<head><!--[if gte mso 9]><xml><x:ExcelWorkbook><x:ExcelWorksheets><x:ExcelWorksheet><x:Name>{worksheet}</x:Name><x:WorksheetOptions><x:DisplayGridlines/></x:WorksheetOptions></x:ExcelWorksheet></x:ExcelWorksheets></x:ExcelWorkbook></xml><![endif]--></head><body><table>{table}</table></body></html>'
    , base64 = function(s) { return window.btoa(unescape(encodeURIComponent(s))) }
    , format = function(s, c) { return s.replace(/{(\w+)}/g, function(m, p) { return c[p]; }) }
  return function(table, name) {
    if (!table.nodeType) table = document.getElementById(table);
    var ctx = {worksheet:  'Worksheet', table: table.innerHTML};
    window.location.href = uri + base64(format(template, ctx));
  }
})() */
</script>

 <script>
    window.onunload = refreshParent;
    function refreshParent() {
    	
       window.opener.location.reload(true);
        self.close();
    }
</script>

<script type="text/javascript">
		$(function() {
			$("#tree").treeview({
				collapsed: true,
				animated: "medium",
				control:"#sidetreecontrol",
				persist: "location"
			});
		})
		
	</script>

<script>
$(document).ready(function(){

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

	 


	 
	  
			
});




function printDiv(divName) {
    var toPrint = document.getElementById(divName);
    var popupWin = window.open('', '_blank', 'width=350,height=150,location=no,left=200px');
    popupWin.document.open();
    popupWin.document.write('<html><title>::Preview::</title><link rel="stylesheet" type="text/css" href="print.css" /></head><body onload="window.print()">')
    popupWin.document.write(toPrint.innerHTML);
    popupWin.document.write('</html>');
    popupWin.document.close();
}
/*--This JavaScript method for Print Preview command--*/
function PrintPreview(divName) {
    var toPrint = document.getElementById(divName);
    var popupWin = window.open('', '_blank', 'width=350,height=150,location=no,left=200px');
    popupWin.document.open();
    popupWin.document.write('<html><title>::Print Preview::</title><link rel="stylesheet" type="text/css" href="Print.css" media="screen"/></head><body">')
    popupWin.document.write(toPrint.innerHTML);
    popupWin.document.write('</html>');
    popupWin.document.close();
}
</script>
<script>
$(function() {
	
	$("input[name='taskTypeId']").change(function(){
        var radioValue = $("input[name='taskTypeId']:checked").val();
        if(radioValue){
          //  alert("Your are a  " + radioValue);
        	$("#hiddentaskTypeId").val(radioValue);
        /* 	var page_url = $(".myunit").prop("href"); 
        	alert("page_url"+page_url);
        	$(".myunit").prop("href", page_url+'&taskTypeId='+$("#hiddentaskTypeId").val()); */
        	
        	
            
        }
    });
	
	
	
	var a=parseInt($("#unitId").val()); 
	if(a>0){
		//alert("a"+a);
		getCircles(a);
		
		
		
	}
	
	/*  var b=parseInt($("#projectId").val()); 
	if(b>0){
		alert("b"+b);
		getPackages(b);
		
		
	} */
	 
	 
	 var c=parseInt($("#hiddencircleId").val()); 
	// alert(c+"c")
	if(c>0){
		
	//	alert("c"+c);
		getDivisions(c);
		
		
		
		
		
	}
	
	var d=parseInt($("#hiddendivisionId").val()); 
	if(d>0){
		
		getSubDivisions(d);
		
		
		
	}
	
	
	
	
});
</script>

<script type = "text/javascript">
       

function getCircles(unitId){
	
	
	//alert("kal");
	//var districtId=document.getElementById("districtId").value;
	var unitId=unitId;
	//alert(mandalId);

	  $.ajax({	          
      url: "../task/getCircles?unitId="+unitId,
      type: "GET",
      success: function (response) {
    	
    	
    	
    	  var $select = $('#circleId');
    	 
		  $select.find('option').remove();
		  
		  var n =$('#hiddencircleId').val();
		  
		 // alert("n"+n);

			var t=0;
			if(n!=null){
				if(n>0){
					t=parseInt(n);
				}
				
			}
		  
		 
		
		 
				var obj = JSON.parse(response);
				  $('#circleId').append( '<option value="0"> --select--</option>' );
				  
				$.each(obj, function(key, value) {
					
					
					if(n>0){
					if(value.circleId==t){
						
						
						$('#circleId').append( '<option value="'+value.circleId+'" selected="selected" > '+value.circleName+'</option>' );
						
					}
					
					if(value.circleId!=t){
						
						$('#circleId').append( '<option value="'+value.circleId+'" disabled="disabled" > '+value.circleName+'</option>' );
					}
					}
					if( n==0){
						
						$('#circleId').append( '<option value="'+value.circleId+'"  > '+value.circleName+'</option>' );
						
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
	
	$("#hidediv").show();
	//alert("kal");
	//var districtId=document.getElementById("districtId").value;
	var circleId=circleId;
		//document.getElementById("circleId").value;
	//alert(mandalId);

	  $.ajax({	          
      url: "../task/getDivisions?circleId="+circleId,
      type: "GET",
      success: function (response) {
    	
    	
    	
    	  var $select = $('#divisionId');
    	 
		  $select.find('option').remove();
var k =$('#hiddendivisionId').val();
		  
		//  alert("k"+k);

			var t=0;
			if(k!=null){
				if(k>0){
					t=parseInt(k);
				}
				
			}
		  
		  
		 
		
		 
				var obj = JSON.parse(response);
				  $('#divisionId').append( '<option value="0"> --select--</option>' );
				  
				$.each(obj, function(key, value) {
					
					if( k>0){
						if(value.divisionId==t){
					
						$('#divisionId').append( '<option value="'+value.divisionId+'" selected="selected" > '+value.divisionName+'</option>' );
				      
						}
						
						if(value.divisionId!=t){
							$('#divisionId').append( '<option value="'+value.divisionId+'"  > '+value.divisionName+'</option>' );
						}
					}
					if( k==0){
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
	$('#hidesubdiv').show();
	
	
	
	//var districtId=document.getElementById("districtId").value;
	var divisionId=divisionId;
	//alert(mandalId);

	  $.ajax({	          
      url: "../task/getSubDivisions?divisionId="+divisionId,
      type: "GET",
      success: function (response) {
    	
    	
    	
    	  var $select = $('#subdivisionId');
    	 
		  $select.find('option').remove();
		  
var l =$('#hiddensubdivisionId').val();
		  
		  //alert("l"+l);

			var t=0;
			if(l!=null){
				if(l>0){
					t=parseInt(l);
				}
				
			}
		
		 
				var obj = JSON.parse(response);
				  $('#subdivisionId').append( '<option value="0"> --select--</option>' );
				  
				$.each(obj, function(key, value) {
					
					if(l>0){
						if(value.subdivisionId==t){
					
						$('#subdivisionId').append( '<option value="'+value.subdivisionId+'"  selected="selected"> '+value.subdivisionName+'</option>' );
				
}
						
						if(value.k!=t){
							
							$('#subdivisionId').append( '<option value="'+value.subdivisionId+'"  > '+value.subdivisionName+'</option>' );
							
							
							
						}
					}
					if( l==0){
						
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


    </script>

<script >
function gettaskunitList(unitId)
{
	
	var m =$("#hiddentaskTypeId").val();
	//alert("minscript"+m);
	
	$("#unitId").val(unitId);
$("#taskTypeId").val(m);

   var page_url="../task/taskreport2?unitId="+unitId+"& taskTypeId="+m;
     window.location.assign(page_url);

     
     $("#myunit").attr('href',page_url);

	/*  document.forms[0].urlvalue.value="../task/taskreport2";
	
	   $("#unitId").val(unitId);
	   $("#taskTypeId").val(m);
	  
	
		 document.forms[0].submit(); 
		 return false;
		  */
		
		 
		   /*   document.forms.casesReport.action="../task/taskreport2?unitId="+unitId+"& taskTypeId="+m; */
		 /* document.forms.casesReport.submit();  */
	
	
	
	
	}
function gettaskcircleList(unitId,circleId)
{
	
	var m =$("#hiddentaskTypeId").val();
	document.forms[0].urlvalue.value="../task/taskreport2";
	
	   $("#unitId").val(unitId);
	   $("#circleId").val(circleId);
	   $("#taskTypeId").val(m);
	
		 document.forms[0].submit(); 
	
	
	
	}
function gettaskdivisionList(unitId,circleId,divisionId)
{
	
	var m =$("#hiddentaskTypeId").val();
	document.forms[0].urlvalue.value="../task/taskreport2";
	
	   $("#unitId").val(unitId);
	   $("#circleId").val(circleId);
	   $("#divisionId").val(divisionId);
	   $("#taskTypeId").val(m);
	
		 document.forms[0].submit(); 
	
	
	
	
	}
function gettasksubdivisionList(unitId,circleId,divisionId,subdivisionId)
{
	
	var m =$("#hiddentaskTypeId").val();
	document.forms[0].urlvalue.value="../task/taskreport2";
	
	   $("#unitId").val(unitId);
	   $("#circleId").val(circleId);
	   $("#divisionId").val(divisionId);
	   $("#subdivisionId").val(subdivisionId);
	   $("#taskTypeId").val(m);
	
		 document.forms[0].submit(); 
	
	
	
	}
	
	
	function deleteEmp(empId){
		
		 $("#deleteFlag").val(true);
		 
		 document.forms[0].urlvalue.value="../task/deleteEmp";
			
		
		   $("#empId").val(empId);
		
			 document.forms[0].submit(); 
		
		
		
		
	}
	
	function editEmp(empId){
		 $("#editFlag").val(true);
		
		 var features="width=500,height=300,menubar=no,status=no,location=no,toolbar=no,scrollbars=yes,top=100,left=50";
	 	  	var url="../task/editEmpData?empId="+empId;
	 	  	
	 		popup =window.open(url,"_blank",features);
		
		
		
	}
</script>

<c:if test="${userObj!=null}">
	<div class="row-fluid  ">

		<div class="span6 pull-right">
			<p class="rowBlue" > <c:out value="${userObj.employeeName}"></c:out></p>
		</div>
	</div>
	</c:if>	
	<c:if test="${msg!=null || err!=null }">


			<div class="row show-grid">
				<c:if test="${msg!=null}">
					<div class="alert alert-success" role="alert">
						<strong></strong>
						<c:out value="${msg}"></c:out>
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
	 
<form:form id="editEmp" method="post"
				modelAttribute="editEmp" >
				
				
				
			

		
		
	
	
	<div class="panel panel-primary ">
			<div class="panel-heading">
			 
			
				<h3 class="panel-title"> Edit Employee=====>
				
				
				
				<c:if test="${userObj!=null}">	
						
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
			 
			   <c:if test="${userObj.unitId!=0 && userObj.circleId!=0 && userObj.divisionId!=0 && userObj.subdivisionId==0 }">	
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
	</c:if></h3>
				
				
			</div>

			<!-- <div class='container'>
 -->



				<div class="row col-md-12 toppad ">

				
				<div class="col-md-12">
		<div class="col-md-10">
		</div>
		<div class="col-md-2">
				<a href="../task/editEmp">	<input type="button" class="btn btn-1 btn-primary center-block"
						id="gettasks" value="Back"   >
						</a>
				</div>
				</div>
				
				
					<div class="col-md-12">
					
					<div class="col-md-6">
					<div class="col-md-6">
							<label class="label-controlPMS rowlebel ">Select Unit *</label>
							</div>
							<div class="col-md-6">
							
							<select class="form-control" id="unitId"  name="unitId" onchange="getCircles(this.value)" required >
							<option value="0">--select --</option>
						   <c:forEach items="${unitList}" var="u">
						
						  <c:choose>
						  
								 <c:when test="${u.unitId==selectedunit}">
									<option value="${u.unitId}" selected="selected">${u.unitName}</option>
									</c:when>
									
									<c:otherwise>
									<option value="${u.unitId}" >${u.unitName}</option>
									</c:otherwise>
									</c:choose>
									
									
									

								</c:forEach>  
 
						  
						  
						 
 

							</select>
							</div>
							
							<div class="col-md-6">	
						<label class="label-controlPMS rowlebel ">Select Circle *</label>
						</div>
						<div class="col-md-6">	
							<input name=hiddencircleId  id="hiddencircleId" type=hidden >
							<select class="form-control" id="circleId"  name="circleId" onchange="getDivisions(this.value)" required >
							<option value="0">--select --</option>
						

							</select>
							
						</div>
						</div>
							
						

					<div class="col-md-6">
						<div class="col-md-6">
							<label class="label-controlPMS rowlebel ">Select Division</label>
							</div>
							<div class="col-md-6">
							<input name=hiddendivisionId  id="hiddendivisionId" type=hidden >
							
							<select class="form-control" id="divisionId"  name="divisionId"  onchange="getSubDivisions(this.value)" >				
                               <option value="0">--select --</option>

							</select>
							
							
						</div>
						
						<div class="col-md-6">
							<label class="label-controlPMS rowlebel ">Select Subdivision</label>
							</div>
							<div class="col-md-6">
							<input name=hiddensubdivisionId  id="hiddensubdivisionId" type=hidden >
							<select class="form-control" id="subdivisionId"  name="subdivisionId"  >
							<option value="0">--select --</option>
							


							</select>
							
							
						</div>
						</div>
						</div>
						<div class="col-md-12" >
						<br></br>
						
						
						<input type="submit" class="btn btn-1 btn-primary center-block"
							id="getempId" value="Get Employees"   >
						</div>
						
							
						
						
				
				
						
	 <div class="w3layouts_vertical_tab resp-tab-content resp-tab-content-active  col-md-12" style="display:block">
		
		
		<c:if test="${empList!=null}">
		<!--  <div class="row show-grid gridList  col-md-12" id="printarea"  > -->
		 
		
						<table class="table-responsive table-bordered " id="table">
							<thead style="background: #85C1E9 none repeat scroll 0 0;">
							<%-- <tr style="color: red; font-weight: bold; background: #ffffff;"><td></td><td><c:out value="${displayunit}"></c:out></td><td><c:out value="${displayvalue}"></c:out></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td> Task Type:</td><td><c:out value="${displaytype}"></c:out> </td> </tr> --%>
								<tr>
									<th rowspan="1">Sl.No</th>
									<th rowspan="1" >Employee Name</th>
									<th rowspan="1"> Designation</th>
									<th rowspan="1" >Phone Number </th>
									<th rowspan="1" > Unit</th>
									<th rowspan="1" >Circle </th>
								
									<th rowspan="1" >Division</th>
									<th rowspan="1" >Sub Division</th>
									<th rowspan="1" >Edit </th>
									<th rowspan="1" >Delete</th>
									
									
									
								</tr>

								
							
								

							</thead>

							
							<tbody>
								
									<c:forEach items="${empList}" var="t" varStatus="count">
										<tr>
											
											<td style="text-align: center;"><c:out
													value="${count.count}"></c:out></td>											
											<td><c:out value="${t.employeeName}"></c:out> </td>
											<td><c:out value="${t.designationName}"></c:out> </td>
											<td><c:out value="${t.phoneNum1}"></c:out> </td>
											<td><c:out value="${t.unitName}"></c:out> </td>
											<td><c:out value="${t.circleName}"></c:out> </td>
											
											<td><c:out value="${t.divisionName}"></c:out> </td>
											<td><c:out value="${t.subdivisionName}"></c:out> </td>
											
											
										
											
											<td> 
										<input type="button" class="btn btn-1 btn-primary center-block"
							id="getCasesId" value="Edit Employee"  onclick="editEmp(<c:out value="${t.empId}"></c:out>)" >
							<input name=editFlag  id="editFlag" type=hidden  value="false" /></td>	
											
										<td> <input type="button"  class="btn btn-1 btn-danger  center-block"  onclick='deleteTask()'	id="getCasesId"   value="Delete Employee"   /></td>	
											
											
							</tr>
							</c:forEach>
									
								
								
								</tbody>
							

						</table>
						
				
				<!-- 	</div> -->
					</c:if>
				
		  </div> 

					

</div>
<!-- </div> -->
</div>

	

		
	
		<div class="row show-grid">
					<div class="clearfix"> </div>
					<div class="clearfix"> </div>
					<div class="col-md-4"></div>
					<div class="col-md-2">
						<input type="submit" class="btn btn-1 btn-primary center-block"
							id="getCasesId" value="Excel Export" onclick="tableToExcel('table', 'countertable')" >
					</div>
					
					<div class="col-md-2">
					 <input type="button" value="Print Preview" class="btn btn-1 btn-primary center-block" onclick="PrintPreview('printarea')"/>
					 </div>
					<div class="col-md-2">
						<input type="button" class="btn btn-1 btn-primary center-block"
							id="getCasesId" value="Print"  onclick="printDiv('printarea')" >
					</div>
					
					
					</div>	
		
</form:form>	
</div>
<!-- //main-content -->







	




		
		
	
	 
	
	 
	 
	 <script type="text/javascript" src="../js/parsley.js"></script>

    
    
    <script type="text/javascript" class="example">
$(function () {
	 $('#editEmp').parsley().on('field:validated', function() {
		    var ok = $('.parsley-error').length === 0;
		
		   // alert('hi');
		    
		  })
		  
		  .on('form:submit', function() {
			 // alert("coming here");
			 
			
			 
			  document.forms.editEmp.action="../task/editEmp";
				 document.forms.editEmp.submit(); 
			
			
				
			  
			  
			    // Don't submit form for this demo
			  });
});

</script>
	 
	 

<!-- //main-content -->
