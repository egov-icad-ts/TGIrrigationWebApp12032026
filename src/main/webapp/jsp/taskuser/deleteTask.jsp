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
})()  */
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

	
	 


	 
	  
			
});


/* function loadForm(){
	
	
	
	

	
		
	
		  $('#casesReport').attr('action', "../webReports/abstractCounterFiles");
          $("#casesReport").submit();
         
	
	
	
	
    
} */

/* function printDiv(divName) {
    var printContents = document.getElementById(divName).innerHTML;
    //var originalContents = document.body.innerHTML;

   // document.body.innerHTML = printContents;
    document.body.innerHTML = '<link href="./I and CAD  Court Cases Monitoring System_files/bootstrap.min.css" rel="stylesheet" type="text/css"  media="print"><link rel="stylesheet" href="./I and CAD Court Cases Monitoring System_files/custom.css" type="text/css"  media="print"><body>';
    document.body.innerHTML += printContents+'</body>';
  //  alert(document.body.innerHTML);
    //alert(printContents);
    window.print();
    window.close();
    

   // document.body.innerHTML = originalContents;
} */

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
	
	/* var b = $("#taskTypeId").val();
	
	$("#hiddentaskTypeId").val(b); */
	
	/* $(".mycircle").click(function() {
		 var $this = $(this);      
		
		var m =$("#hiddentaskTypeId").val();
		
	      $("#taskTypeId").val(m);
	      var page_url = $this.prop("href"); 
	      alert("page_url"+page_url);
	   
		   $this.prop("href", page_url+'&taskTypeId='+m);
		  
		}); */
	
	
	/* $(".myunit").click(function() {
		 var $this = $(this);      
		
		var m =$("#hiddentaskTypeId").val();
		
	      $("#taskTypeId").val(m);
	      var page_url = $this.prop("href"); 
	      alert("page_url"+page_url);
	   
		   $this.prop("href", page_url+'&taskTypeId='+m);
		  
		}); */
	
	
	
	/* $(".mydivision").click(function() {
		 var $this = $(this);   
		 
		
		var m =$("#hiddentaskTypeId").val();
		
	      $("#taskTypeId").val(m);
	      var page_url = $this.prop("href"); 
	      alert("page_url"+page_url);
	   
		   $this.prop("href", page_url+'&taskTypeId='+m);
		   
		});
	 */
	/* $(".mysubdivision").click(function() {
		
		
		event.preventDefault();
		
		 var $this = $(this);  
		 
		
		var m =$("#hiddentaskTypeId").val();
		
	      $("#taskTypeId").val(m);
	      var page_url = $this.prop("href"); 
	      alert("page_url"+page_url);
	      
	      window.location.replace(page_url+'&taskTypeId='+m);
	   
		 //  $this.prop("href", page_url+'&taskTypeId='+m);
		   
		  
		});
	 */
	
	
	
	
});
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
	
	
	function deleteTask(taskId){
		
		 $("#deleteFlag").val(true);
		 
		 document.forms[0].urlvalue.value="../task/deleteTask";
			
		
		   $("#taskId").val(taskId);
		
			 document.forms[0].submit(); 
		
		
		
		
	}
	
	function editTask(taskId){
		 $("#editFlag").val(true);
		
		 var features="width=500,height=300,menubar=no,status=no,location=no,toolbar=no,scrollbars=yes,top=100,left=50";
	 	  	var url="../task/editTask?taskId="+taskId;
	 	  	
	 		popup =window.open(url,"_blank",features);
		
		
		
	}
</script>

<c:if test="${userObj!=null}">
	<div class="row-fluid  ">

		<div class="span6 pull-right">
			<p class="rowBlue" > <c:out value="${userObj.employeeName}"></c:out></p>
		</div>
	</div>
	</c:if>	<c:if test="${msg!=null || err!=null }">


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
<div class="w3_agile_main_left">
		<!--start left block-->
	 
<form:form id="deleteTask" method="post"
				modelAttribute="deleteTask" >
				
				<input name=urlvalue type=hidden >
				<input name=unitId  id="unitId" type=hidden >
				<input name=circleId  id="circleId" type=hidden >
				<input name=divisionId  id="divisionId" type=hidden >
				<input name=subdivisionId  id="subdivisionId" type=hidden >
	
		
	<!-- 	<div class="col-md-3 w3layouts-second"> -->
		
		
		
	 
	<div class="col-md-12 "> 
		
		
		

 <div id="sidetree">
<div class="treeheader">&nbsp;</div>
<div id="sidetreecontrol"><a href="?#">Collapse All</a> | <a href="?#">Expand All</a></div>

<ul id="tree">


<c:forEach items="${unitData}" var="u">								
	<li>
	
	<c:if test="${userObj.circleId==0 && userObj.divisionId==0 && userObj.subdivisionId==0 }">
	<a class="myunit"  href="../task/deleteTask?unitId=<c:out value="${u.unitId}"></c:out>" ><strong><c:out value="${u.unitName}"></c:out></strong></a>
	</c:if>
	<ul>
	<c:forEach items="${circleData}" var="c">
	<c:if test="${u.unitId==c.unitId}">
	<%-- ../task/taskreport2?unitId=<c:out value="${u.unitId}"></c:out>&circleId=<c:out value="${c.circleId}"></c:out> --%>
		<li>
		<c:if test="${ userObj.divisionId==0 && userObj.subdivisionId==0 }">
		<a class="mycircle" href="../task/deleteTask?unitId=<c:out value="${u.unitId}"></c:out>&circleId=<c:out value="${c.circleId}"></c:out> " ><c:out value="${c.circleName}"></c:out></a>
		</c:if>
			<ul>
			<c:forEach items="${divisionData}" var="d">
			<c:if test="${c.circleId==d.circleId}">
			<%-- ../task/taskreport2?unitId=<c:out value="${u.unitId}"></c:out>&circleId=<c:out value="${c.circleId}"></c:out>&divisionId=<c:out value="${d.divisionId}"></c:out> --%>
			<li>
			<c:if test="${ userObj.subdivisionId==0 }">
			<a class="mydivision" href="../task/deleteTask?unitId=<c:out value="${u.unitId}"></c:out>&circleId=<c:out value="${c.circleId}"></c:out>&divisionId=<c:out value="${d.divisionId}"></c:out>" ><c:out value="${d.divisionName}"></c:out></a>
			</c:if>
			<ul>
			<c:forEach items="${subdivisionData}" var="s">
			<c:if test="${d.divisionId==s.divisionId}">
			<%-- ../task/taskreport2?unitId=<c:out value="${u.unitId}"></c:out>&circleId=<c:out value="${c.circleId}"></c:out>&divisionId=<c:out value="${d.divisionId}"></c:out>&subdivisionId=<c:out value="${s.subdivisionId}"></c:out> --%>
			<li>
			
			<a  class="mysubdivision" href="../task/deleteTask?unitId=<c:out value="${u.unitId}"></c:out>&circleId=<c:out value="${c.circleId}"></c:out>&divisionId=<c:out value="${d.divisionId}"></c:out>&subdivisionId=<c:out value="${s.subdivisionId}"></c:out>"><c:out value="${s.subdivisionName}" ></c:out></a>
			
			</li>
			
			</c:if>
			</c:forEach>
			</ul>
			
			
			
			</li>
			</c:if>
			
			</c:forEach>
		</ul>
		
		
		</li>
		</c:if>
		</c:forEach>
		
		


	</ul>
	</li>
	
	</c:forEach>  
	
		
		
		
	</ul>
	
</div> 

</div>
	<!--  </div>  -->
	
	
	
		
			
			<!-- 9th-section -->
	
	
		
		
	
	
	
	
	<div class="panel panel-primary  col-md-12">
			<div class="panel-heading">
				<h3 class="panel-title">Task Status</h3>
			</div>

			<!-- <div class='container'> -->




				<div class="row col-md-12 toppad ">

				
				<div class="col-md-12">
		<div class="col-md-10">
		</div>
		<div class="col-md-2">
				<a href="../task/deleteTask">	<input type="button" class="btn btn-1 btn-primary center-block"
						id="gettasks" value="Back"   >
						</a>
				</div>
				</div>
				
					<div class="row show-grid">

					
						<div class="col-md-10">
							<div class="form-group">
        <label class="col-sm-2 control-label">Select Task Type</label>
        <div class="col-sm-10">
       
        <c:choose>
        <c:when test="${selectedTask==-1}">
          <label class="radio-inline"> <input type="radio" name="taskTypeId" id="taskTypeId" checked="checked" value="-1" > All Tasks </label>
           </c:when>
           <c:otherwise>
           <label class="radio-inline"> <input type="radio" name="taskTypeId" id="taskTypeId"  value="-1" > All Tasks </label>
           </c:otherwise>
            </c:choose>
            
             <input type="hidden" name="hiddentaskTypeId" id="hiddentaskTypeId"  value="<c:out value="${selectedTask}"></c:out>" >
            
        <c:forEach items="${taskTypeList}" var="tt" varStatus="count">
         <c:choose>
            <c:when test="${selectedTask==tt.taskTypeId}">
        
        <label class="radio-inline"> <input type="radio" name="taskTypeId" id="taskTypeId"  checked="checked"    value="${tt.taskTypeId}" > <c:out value="${tt.taskTypeName}"></c:out> </label>
       
        </c:when>
               <c:otherwise>
               
                <label class="radio-inline"> <input type="radio" name="taskTypeId" id="taskTypeId"   value="${tt.taskTypeId}" > <c:out value="${tt.taskTypeName}"></c:out> </label>
               
           </c:otherwise>
           </c:choose>
        
        
           
            </c:forEach>
            
                
               
               
           
         
            
           
        </div>
    </div>
						</div>
						</div>
					
					
		</div>		
					
						
	<!-- <div class="w3layouts_vertical_tab resp-tab-content resp-tab-content-active  col-md-8" style="display:block"> -->
		
		
		<c:if test="${taskAllList!=null}">
		<!--  <div class="row show-grid gridList  col-md-12" id="printarea"  > -->
		 
		
						<table class="table-responsive table-bordered " id="table">
							<thead style="background: #85C1E9 none repeat scroll 0 0;">
							<tr style="color: red; font-weight: bold; background: #ffffff;"><td></td><td><c:out value="${displayunit}"></c:out></td><td><c:out value="${displayvalue}"></c:out></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td> Task Type:</td><td><c:out value="${displaytype}"></c:out> </td> </tr>
								<tr>
									<th rowspan="1">Sl.No</th>
									<th rowspan="1" >Issue/Subject</th>
									<th rowspan="1"> Project/Package</th>
									<th rowspan="1" > AEE/ DEE/ EE/ SE </th>
									<th rowspan="1" >Phone Number </th>
								
									<th rowspan="1" >Assigned Date </th>
									<th rowspan="1" >Target Date </th>
									<th rowspan="1" >Priority/Status</th>
								
									<th rowspan="1" >Remarks </th>
									<th rowspan="1" >Files Uploaded</th>
									<th rowspan="1" >Edit</th>
									<th rowspan="1" >Delete</th>
									
									
								</tr>

								
							
								

							</thead>

							
							<tbody>
								
									<c:forEach items="${taskAllList}" var="t" varStatus="count">
									 <input name=editFlag  id="editFlag" type=hidden  value="false" />
									 <input name=deleteFlag     id="deleteFlag" type=hidden  value="false" />
									 <input name=taskId     id="taskId" type=hidden  value="<c:out value="${t.taskId}"></c:out>" />
										
										<tr>
											
											<td style="text-align: center;"><c:out	value="${count.count}"></c:out></td>											
											<td><c:out value="${t.subject}"></c:out> </td>
											<td><c:out value="${t.projectName}"></c:out>/<c:out value="${t.packageName}"></c:out> </td>
											<td><c:out value="${t.employeeName}"></c:out> </td>
											<td><c:out value="${t.phoneNum1}"></c:out> </td>
											
											<td><c:out value="${t.assignedDate}"></c:out> </td>
											<td><c:out value="${t.targetDate}"></c:out> </td>
											<td><c:out value="${t.priority}"></c:out>/<c:out value="${t.status}"></c:out>  </td>
											
											<td><c:out value="${t.remarks}"></c:out> </td>							
											
											<c:if test="${taskFilesList!=null}">
											
											<td><table>
											<c:set var="c" value="1" scope="page" />
											<c:forEach items="${taskFilesList}" var="f" varStatus="fcount">
											<c:if test="${t.taskId==f.taskId}">
											
											<tr>
											<td  style="color: green; font-weight: bold;">
											<c:out 	value="${c}"></c:out>) <br></br>
											
											
											
											</td >
											<td  style="color: green; font-weight: bold;" ><a target="_blank" href="../uploadedFiles/TaskManagement/<c:out value="${f.fileName}"></c:out>" >
											<c:out value="${f.fileName}"></c:out></a>
											<c:set var="c" value="${c + 1}" scope="page"/>
											
											</td> 											
											
												
											</tr>
											
											</c:if></c:forEach>
											</table></td>
											
											</c:if>
											
											 
											<td> <input type="button" class="btn btn-1 btn-primary center-block"  id="getEditButtonId" value="Edit Task"  onclick='editTask(<c:out value="${t.taskId}"></c:out>)' /></td>	
							                <td> <input type="button" class="btn btn-1 btn-danger center-block" id="getDeleteButtonId" value="Delete Task"  onclick='deleteTask(<c:out value="${t.taskId}"></c:out> )' /></td>
											
										    
											
											
							</tr>
							</c:forEach>
									
								
								
								</tbody>
							

						</table>
						
				
					<!-- </div> -->
					</c:if>
				
		<!-- </div> -->

					


<!-- </div> -->
</div>

	

		
	<div class="row show-grid">
		<div class="col-md-12">
				<br></br>
					<div class="col-md-3"></div>
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
					<div class="col-md-3"></div>
					
					</div>	
					</div>
		
</form:form>
	</div> 	
</div>
<!-- //main-content -->







	




		
		
	
	 
	
	 
	 
	 <script type="text/javascript" src="../js/parsley.js"></script>

    
    
 <!--    <script type="text/javascript" class="example">
$(function () {
	 $('#casesReport').parsley().on('field:validated', function() {
		    var ok = $('.parsley-error').length === 0;
		
		   // alert('hi');
		    
		  })
		  
		  .on('form:submit', function() {
			 // alert("coming here");
			 
			
			 
			  document.forms.casesReport.action="../webReports/abstractCounterFiles";
				 document.forms.casesReport.submit(); 
			
			
				
			  
			  
			    // Don't submit form for this demo
			  });
});

</script>
	  -->
	 

<!-- //main-content -->
