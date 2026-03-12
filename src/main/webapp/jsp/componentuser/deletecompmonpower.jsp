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

	
	
function getcompmonpower(projectId)
{
	//alert("kalcoming"+projectId);
	
	document.forms[0].urlvalue.value="../comptsimis/delCompMonPower";
	
	   $("#projectId").val(projectId);
	 
		 document.forms[0].submit(); 
	
	
	
	}


function getcompmonpowerinfo(compId,unitId){
	
	document.forms[0].urlvalue.value="../comptsimis/delCompMonPower";
	
	   $("#componentId").val(compId);
	   $("#unitId").val(unitId);
	 
		 document.forms[0].submit(); 
	
	
}

	
	
	function deletePowerData(compPowerId){
		
		
		// alert("klcoming here"+compPowerId);
		 $("#deleteFlag").val(true);
		  $("#componentPowerId").val(compPowerId);
		 
		 document.forms[0].urlvalue.value="../comptsimis/delCompMonPower";
			
		
		 
		
			 document.forms[0].submit(); 
		
		
		
		
	}
	
	function editPowerData(componentPowerId){
		 $("#editFlag").val(true);
		
		 var features="width=500,height=300,menubar=no,status=no,location=no,toolbar=no,scrollbars=yes,top=100,left=50";
	 	  	var url="../comptsimis/editCompMonPower?componentPowerId="+componentPowerId+"&editFlag="+false;
	 	  	
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
	 
<form:form id="deleteCompMonPower" method="post"
				modelAttribute="delCompMonPower" >
				<input name=urlvalue type=hidden >
				<input name=unitId  id="unitId" type=hidden >
				<input name=circleId  id="circleId" type=hidden >
				<input name=divisionId  id="divisionId" type=hidden >
				<input name=subdivisionId  id="subdivisionId" type=hidden >
				
				<input name=editFlag  id="editFlag" type=hidden value="false" >
				
				<input name=deleteFlag  id="deleteFlag" type=hidden value="false" >
				<input name=componentPowerId  id="componentPowerId" type=hidden >
				
				
	
				
				
		
	<!-- 	<div class="col-md-3 w3layouts-second"> -->
		
		
		
	 
	<div class="col-md-12 "> 
		
		
		

 <div id="sidetree">
<div class="treeheader">&nbsp;</div>
<div id="sidetreecontrol"><a href="?#">Collapse All</a> | <a href="?#">Expand All</a></div>

<ul id="tree">


<c:forEach items="${unitData}" var="u">								
	<li>
	
	
	<a class="myunit"  href="../comptsimis/delCompMonPower?unitId=<c:out value="${u.unitId}"></c:out>" ><strong><c:out value="${u.unitName}"></c:out></strong></a>
	  <input name=unitName     id="unitName" type=hidden  value="<c:out value="${u.unitName}"></c:out>" />
	  
	
	
	<ul>
	<c:forEach items="${prList}" var="c">
	<c:if test="${u.unitId==c.unitId}">
	  <input name=projectId    id="projectId"  type=hidden  value="<c:out value="${c.projectId}"></c:out>" />
	
		<li><a class="mycircle"  onclick="getcompmonpower(<c:out value="${c.projectId}"></c:out>)"  href="javascript:void(0);"><c:out value="${c.projectName}"></c:out></a>
		
		
		
			<ul>
	<c:forEach items="${compsList}" var="d">
	 <c:if test="${c.projectId==d.projectId}"> 
	  <input name=componentId    id="componentId"  type=hidden  value="<c:out value="${d.componentId}"></c:out>" />
	
		<li><a class="mycomps"  onclick="getcompmonpowerinfo(<c:out value="${d.componentId}"></c:out>,<c:out value="${u.unitId}"></c:out>)"  href="javascript:void(0);"><c:out value="${d.componentName}"></c:out></a>
		
		
		
		
		
		
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
	
	
		
		
	
	
	
	
	<div class="panel panel-primary  col-md-12">
			<div class="panel-heading">
				<h3 class="panel-title">Edit/Delete Component Power</h3>
			</div>

			<!-- <div class='container'> -->




				<div class="row col-md-12 toppad ">

				
				<div class="col-md-12">
		<div class="col-md-10">
		</div>
		<div class="col-md-2">
				<a href="../comptsimis/delCompMonPower">	<input type="button" class="btn btn-1 btn-primary center-block"
						id="getcomps" value="Back"   >
						</a>
				</div>
				</div>
				
					
					
					
		</div>		
					
						
	<!-- <div class="w3layouts_vertical_tab resp-tab-content resp-tab-content-active  col-md-8" style="display:block"> -->
		
		
		<c:if test="${cppower!=null}">
		
		
			
		<div class="col-md-12">	
		
		<div class="col-md-2" style="color:blue">Unit:</div>
					<div class="col-md-2" style="color:red">
					
					<c:out value="${cppower[0].unitName}"></c:out>
					</div>
					<div class="col-md-2" style="color:blue">Project:</div>
					<div class="col-md-2" style="color:red">
				
				<c:out value="${cppower[0].projectName}"></c:out>
				</div>
				<div class="col-md-2" style="color:blue">Component:</div>
				<div class="col-md-2" style="color:red">
				<c:out value="${cppower[0].componentName}"></c:out> 
				</div>
					
			
		</div>
		
		
		
		
		
		<div class="col-md-12">
						
									<div class="col-md-1">Sl.No</div>
									
									<div class="col-md-1">Units Consumed</div>
									
									
								
									<div class="col-md-1">(A) Fixed Chagrges </div>
									<div class="col-md-1">(B) Present Bill Cost</div>
									<div class="col-md-1">(C) Penality Charges</div>
									
								
									<div class="col-md-1">(A+B+C) Net Bill Amount</div>
									<div class="col-md-2">Bill Date / Due Date / Disconnection Date</div>
									
									
									<div class="col-md-1">Additional Deposit</div>
									<div class="col-md-2">Edit/Delete</div>
									
									
									
						</div>			
								
								<div class="col-md-12"  style="color: blue">
									<c:forEach items="${cppower}" var="t" varStatus="count">
									 
									 
										
										
											
											<div class="col-md-1"><c:out	value="${count.count}"></c:out></div>											
										
											<div class="col-md-1"> <c:out value="${t.presentunit}"></c:out></div>
											
											
											<div class="col-md-1"><c:out value="${t.fixedCharges}"></c:out> </div>
											<div class="col-md-1"><c:out value="${t.billCost}"></c:out> </div>
											<div class="col-md-1"><c:out value="${t.penalityCharges}"></c:out> </div>
										
											<div class="col-md-1"><c:out value="${t.netBillCost}"></c:out> </div>
											
											<div class="col-md-2"><c:out value="${t.powerConsumeMonth}"></c:out>  / <c:out value="${t.dueDate}"></c:out> / 	<c:out value="${t.disconnectionDate}"></c:out> </div>				
											
										
											
											<div class="col-md-1"><c:out value="${t.additionalDeposit}"></c:out> </div>
											
											<div class="col-md-2">  <button type="button" class="btn btn-primary btn-sm" onclick='editPowerData(<c:out value="${t.componentPowerId}"></c:out>)' ><span class="glyphicon glyphicon-plus"></span></button>
											
							          <button type="button" class="btn btn-danger btn-sm"  onclick='deletePowerData(<c:out value="${t.componentPowerId}"></c:out> )' ><span class="glyphicon glyphicon-remove"></span></button></div>
											 
											
											
										    
											
											
						
							</c:forEach>
							</div>
									
								
								
							
					</c:if>
				
	
</div>

	

		
	<div class="row show-grid">
		<!-- <div class="col-md-12">
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
					
					</div>	 -->
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
