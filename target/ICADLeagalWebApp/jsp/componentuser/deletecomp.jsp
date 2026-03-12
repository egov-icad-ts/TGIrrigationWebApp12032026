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
	
	
function getcomps(projectId){
	
	// alert("kal"+projectId);
	
	 document.forms[0].urlvalue.value="../comptsimis/deleteComponent";
		
	 $("#deleteFlag").val(false);
	   $("#projectId").val(projectId);
	 
	
		 document.forms[0].submit(); 
	
	
	
	
}

	
	
	function deleteComp(componentId){
		
		 $("#deleteFlag").val(true);
		 var m=$("#deleteFlag").val();
		 
		 alert("m"+m );
		 
		 document.forms[0].urlvalue.value="../comptsimis/deleteComponent";
			
		
		   $("#componentId").val(componentId);
		
			 document.forms[0].submit(); 
		
		
		
		
	}
	
	function editComp(componentId){
		 //$("#editFlag").val(false);
		
		 var features="width=500,height=300,menubar=no,status=no,location=no,toolbar=no,resizable=1,scrollbars=yes,top=100,left=50";
	 	  	var url="../comptsimis/editComp?componentId="+componentId+"&editFlag="+false;
	 	  	
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
	 
<form:form id="deleteComp" method="post"
				modelAttribute="deleteComp" >
				
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
	
	
	<a class="myunit"  href="../comptsimis/deleteComponent?unitId=<c:out value="${u.unitId}"></c:out>" ><strong><c:out value="${u.unitName}"></c:out></strong></a>
	  <input name=unitName     id="unitName" type=hidden  value="<c:out value="${u.unitName}"></c:out>" />
	   <input name=editFlag  id="editFlag" type=hidden  value="false" />
									 <input name=deleteFlag     id="deleteFlag" type=hidden  value="false" />
	
	
	<ul>
	<c:forEach items="${prList}" var="c">
	<c:if test="${u.unitId==c.unitId}">
	  <input name=projectId     id="projectId" type=hidden  value="<c:out value="${c.projectId}"></c:out>" />
	
		<li><a class="mycircle"  onclick="getcomps(<c:out value="${c.projectId}"></c:out>)"  href="javascript:void(0);"><c:out value="${c.projectName}"></c:out></a>
			<ul>
	<!-- href="../compReport/componentMap?projectId= " -->
		</ul>
		
		
		</li>
		</c:if>
		</c:forEach>
		
		


	</ul>
	
	<%-- <ul>
	<c:forEach items="${circleData}" var="c">
	<c:if test="${u.unitId==c.unitId}">
	
		<li>
		<c:if test="${ userObj.divisionId==0 && userObj.subdivisionId==0 }">
		<a class="mycircle" href="../comptsimis/deleteComponent?unitId=<c:out value="${u.unitId}"></c:out>&circleId=<c:out value="${c.circleId}"></c:out> " ><c:out value="${c.circleName}"></c:out></a>
		</c:if>
		
		
		
		 <ul>
			<c:forEach items="${divisionData}" var="d">
			<c:if test="${c.circleId==d.circleId}">
			../task/taskreport2?unitId=<c:out value="${u.unitId}"></c:out>&circleId=<c:out value="${c.circleId}"></c:out>&divisionId=<c:out value="${d.divisionId}"></c:out>
			<li>
			<c:if test="${ userObj.subdivisionId==0 }">
			<a class="mydivision" href="../comptsimis/deleteComponent?unitId=<c:out value="${u.unitId}"></c:out>&circleId=<c:out value="${c.circleId}"></c:out>&divisionId=<c:out value="${d.divisionId}"></c:out>" ><c:out value="${d.divisionName}"></c:out></a>
			</c:if>
			<ul>
			<c:forEach items="${subdivisionData}" var="s">
			<c:if test="${d.divisionId==s.divisionId}">
			../task/taskreport2?unitId=<c:out value="${u.unitId}"></c:out>&circleId=<c:out value="${c.circleId}"></c:out>&divisionId=<c:out value="${d.divisionId}"></c:out>&subdivisionId=<c:out value="${s.subdivisionId}"></c:out>
			<li>
			
			<a  class="mysubdivision" href="../comptsimis/deleteComponent?unitId=<c:out value="${u.unitId}"></c:out>&circleId=<c:out value="${c.circleId}"></c:out>&divisionId=<c:out value="${d.divisionId}"></c:out>&subdivisionId=<c:out value="${s.subdivisionId}"></c:out>"><c:out value="${s.subdivisionName}" ></c:out></a>
			
			</li>
			
			</c:if>
			</c:forEach>
			</ul>
			
			
			
			</li>
			</c:if>
			
			</c:forEach>
		</ul> --%>
		
		
	<%-- 	</li>
		</c:if>
		</c:forEach>
		
		 --%>


<!-- 	</ul>  -->
	</li>
	
	</c:forEach>  
	
		
		
		
	</ul>
	
</div> 

</div>
	<!--  </div>  -->
	
	
	
		
			
			<!-- 9th-section -->
	
	
		
		
	
	
	
	
	<div class="panel panel-primary  col-md-12">
			<div class="panel-heading">
				<h3 class="panel-title">Delete/Edit Component</h3>
			</div>

			<!-- <div class='container'> -->




				<div class="row col-md-12 toppad ">

				
				<div class="col-md-12">
		<div class="col-md-10">
		</div>
		<div class="col-md-2">
				<a href="../comptsimis/deleteComponent">	<input type="button" class="btn btn-1 btn-primary center-block"
						id="gettasks" value="Back"   >
						</a>
				</div>
				</div>
				
				<%-- 	<div class="row show-grid">

					
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
					 --%>
					
		</div>		
					
						
	<!-- <div class="w3layouts_vertical_tab resp-tab-content resp-tab-content-active  col-md-8" style="display:block"> -->
		
		
		<c:if test="${delcompList!=null}">
		<!--  <div class="row show-grid gridList  col-md-12" id="printarea"  > -->
		 
		<div class="col-md-12"  style="color: blue">
						Component Details are Shown below</div>
							
								
									<c:forEach items="${delcompList}" var="t" varStatus="count">
									
									 <input name=componentId     id="componentId" type=hidden  value="<c:out value="${t.componentId}"></c:out>" /> 
									<div class="row show-grid" >	
									<div class="col-md-12" >
									<div class="col-md-6">Sl.No</div><div class="col-md-6" style="color: blue"><c:out	value="${count.count}"></c:out></div></div>										
									<div class="col-md-12" >	<div class="col-md-6">Unit Name</div><div class="col-md-6" style="color: blue"><c:out value="${t.unitName}"></c:out></div></div>	
									<div class="col-md-12" >	<div class="col-md-6"> Project/Package</div><div class="col-md-6" style="color: blue"><c:out value="${t.projectName}"></c:out>/<c:out value="${t.packageName}"></c:out> </div></div>	
											
									<div class="col-md-12" >	<div class="col-md-6">ComponentName</div><div class="col-md-6" style="color: blue"><c:out value="${t.componentName}"></c:out> </div>	</div>	
											
									<div class="col-md-12" >	<div class="col-md-6">From Location-To Location</div><div class="col-md-6" style="color: blue"><c:out value="${t.fromlocation}"></c:out>-<c:out value="${t.tolocation}"></c:out>  </div></div>		
									<div class="col-md-12" >	<div class="col-md-6">From Km-To Km</div><div class="col-md-6" style="color: blue"><c:out value="${t.fromKm}"></c:out>-<c:out value="${t.toKm}"></c:out>  </div></div>		
											
									<div class="col-md-12" >	<div class="col-md-6">Discharge in cusecs</div><div class="col-md-6" style="color: blue"><c:out value="${t.dischrgecusecs}"></c:out> </div>	</div>	
									<div class="col-md-12" >	<div class="col-md-6">Component Length</div><div class="col-md-6" style="color: blue"><c:out value="${t.pmlength}"></c:out> </div></div>		
									<div class="col-md-12" >	<div class="col-md-6">Component Direction</div><div class="col-md-6" style="color: blue"><c:if test="${t.componentDirection==1}">Left</c:if><c:if test="${t.componentDirection==2}">Right</c:if></div></div>		
									<div class="col-md-12" >	<div class="col-md-6">Parent Component</div><div class="col-md-6" style="color: blue"><c:out value="${t.parentComponent}"></c:out> </div>	</div>	
									<div class="col-md-12" >	<div class="col-md-6">Component Category</div><div class="col-md-6" style="color: blue"><c:out value="${t.componentCategory}"></c:out> </div>	</div>	
									<div class="col-md-12" >	<div class="col-md-6">Pipe Diameter(m)</div><div class="col-md-6" style="color: blue"><c:out value="${t.pipediameter}"></c:out> </div>	</div>	
									<div class="col-md-12" >	<div class="col-md-6">No of Pipe Rows</div><div class="col-md-6" style="color: blue"><c:out value="${t.noofpiperows}"></c:out> </div>	</div>	
									<div class="col-md-12" >	<div class="col-md-6">Static Head (Meters)</div><div class="col-md-6" style="color: blue"><c:out value="${t.staticlift}"></c:out> </div>	</div>	
									<div class="col-md-12" >	<div class="col-md-6">Dynamic Head (Meters)</div><div class="col-md-6" style="color: blue"><c:out value="${t.dynamiclift}"></c:out> </div>	</div>	
									<div class="col-md-12" >	<div class="col-md-6">Total Lift (Meters)</div><div class="col-md-6" style="color: blue"><c:out value="${t.dynamiclift}"></c:out> </div>	</div>	
									<div class="col-md-12" >	<div class="col-md-6">Total Lift period (Days)</div><div class="col-md-6" style="color: blue"><c:out value="${t.liftperiod}"></c:out> </div>	</div>	
									<div class="col-md-12" >	<div class="col-md-6">Total Lift (TMC)</div><div class="col-md-6" style="color: blue"><c:out value="${t.lifttmc}"></c:out> </div>	</div>	
									<div class="col-md-12" >	<div class="col-md-6">Total Power of each motor/pump(MW)</div><div class="col-md-6" style="color: blue"><c:out value="${t.eachmotorPower}"></c:out> </div></div>	
									<div class="col-md-12" >	<div class="col-md-6">Total Power(MW)</div><div class="col-md-6" style="color: blue"><c:out value="${t.totalpowerwithAux}"></c:out> </div>	</div>	
									<div class="col-md-12" >	<div class="col-md-6">Auxilary power(MW)</div><div class="col-md-6" style="color: blue"><c:out value="${t.auxPower}"></c:out> </div></div>	
									<div class="col-md-12" >	<div class="col-md-6">Sub Station Capacity(Volts)</div><div class="col-md-6" style="color: blue"><c:out value="${t.substationCapacity}"></c:out> </div></div>	
									<div class="col-md-12" >	<div class="col-md-6">MDDL(mts)</div><div class="col-md-6" style="color: blue"><c:out value="${t.mddlsign}"></c:out> </div></div>	
									<div class="col-md-12" >	<div class="col-md-6">Delivery Level(M)</div><div class="col-md-6" style="color: blue"><c:out value="${t.deliverylevelsign}"></c:out></div></div>	
									<div class="col-md-12" >	<div class="col-md-6">Status</div><div class="col-md-6" style="color: blue"><c:out value="${t.status}"></c:out> </div>	</div>	
									<div class="col-md-12" >	<div class="col-md-6">Remarks</div><div class="col-md-6" style="color: blue"><c:out value="${t.remarks}"></c:out> </div>	</div>							
										
									<div class="col-md-12" >	<div class="col-md-6">Edit</div><div class="col-md-2"> <input type="button" class="btn btn-1 btn-primary center-block"  id="getEditButtonId" value="Edit Component"  onclick='editComp(<c:out value="${t.componentId}"></c:out>)' /></div><div class="col-md-4"></div>	</div>	
							         <div class="col-md-12" >    <div class="col-md-6">Delete</div><div class="col-md-2"> <input type="button" class="btn btn-1 btn-danger center-block" id="getDeleteButtonId" value="Delete Component"  onclick='deleteComp(<c:out value="${t.componentId}"></c:out> )' /><div class="col-md-4"></div></div>	
											
										    
									</div>
									</div>
											
							
							</c:forEach> 
									
								
								
							
				
					<!-- </div> -->
					</c:if>
				
		<!-- </div> -->

					


<!-- </div> -->
</div>

	

		
	<div class="row show-grid">
		<div class="col-md-12">
				<br></br>
					<div class="col-md-4"></div>
					<div class="col-md-4">
						<input type="submit" class="btn btn-1 btn-primary center-block"
							id="getCasesId" value="Excel Export" onclick="tableToExcel('table', 'countertable')" >
					</div>
			
					<div class="col-md-4"></div>
					
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
