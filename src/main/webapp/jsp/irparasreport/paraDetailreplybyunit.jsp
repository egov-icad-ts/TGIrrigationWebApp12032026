
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
var tableToExcel = (function() {
  var uri = 'data:application/vnd.ms-excel;base64,'
    , template = '<html xmlns:o="urn:schemas-microsoft-com:office:office"<head><!--[if gte mso 9]><xml><x:ExcelWorkbook><x:ExcelWorksheets><x:ExcelWorksheet><x:Name>{worksheet}</x:Name><x:WorksheetOptions><x:DisplayGridlines/></x:WorksheetOptions></x:ExcelWorksheet></x:ExcelWorksheets></x:ExcelWorkbook></xml><![endif]--></head><body><table>{table}</table></body></html>'
    , base64 = function(s) { return window.btoa(unescape(encodeURIComponent(s))) }
    , format = function(s, c) { return s.replace(/{(\w+)}/g, function(m, p) { return c[p]; }) }
  return function(table, name) {
    if (!table.nodeType) table = document.getElementById(table);
    var ctx = {worksheet:  'Worksheet', table: table.innerHTML};
    window.location.href = uri + base64(format(template, ctx));
  }
})()
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

	
	
	
	
	

	MergeCommonRows($("#table"), 1);
	MergeCommonRows($("#table"), 2);
	
	
	
	
	
	
	
	 


	 
	  
			
});


function MergeCommonRows(table, columnIndexToMerge) {
	
    previous = null;
    cellToExtend = null;
    table.find("td:nth-child(" + columnIndexToMerge + ")").each(
            function() {
                jthis = $(this);
                content = jthis.text();
                if (previous == content) {
                	
                    jthis.remove();
                    if (cellToExtend.attr("rowspan") == undefined) {
                        cellToExtend.attr("rowspan", 2);
                    } else {
                        currentrowspan = parseInt(cellToExtend
                                .attr("rowspan"));
                        cellToExtend.attr("rowspan",
                                currentrowspan + 1);
                    }
                } else {
                    previous = content;
                    cellToExtend = jthis;
                }
            });
};

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

<script type="text/javascript">


       
    </script>

<script>
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

	<form:form id="casesReport" method="post" modelAttribute="taskreport2">

		<input name=urlvalue type=hidden>
		<input name=unitId id="unitId" type=hidden>
		<input name=circleId id="circleId" type=hidden>
		<input name=divisionId id="divisionId" type=hidden>
		<input name=subdivisionId id="subdivisionId" type=hidden>
		



		<div class="panel panel-primary  col-md-12">
			<div class="panel-heading">
				<h3 class="panel-title">Paras Gist</h3>
			</div>

			




				<div class="row col-md-12  ">



					<form:form id="getParaCount" method="post" modelAttribute="irparas"
						data-parsley-validate-if-empty="">
						
						
						
			<!-- 	<div class="col-md-12">
							<div class="form-group">
        <label class="col-sm-4 control-label">Select Para Status </label>
        <div class="col-sm-8" id="statusdiv">
       
        
        <label class="radio-inline"> <input type="radio" name="paraStatusId" id="paraStatusId"  checked="checked"    value="1"  required >Dropped</label>
        <label class="radio-inline"> <input type="radio" name="paraStatusId" id="paraStatusId"     value="2"  required >Transferred</label>
        <label class="radio-inline"> <input type="radio" name="paraStatusId" id="paraStatusId"      value="3"  required >Terminated</label>
        <label class="radio-inline"> <input type="radio" name="paraStatusId" id="paraStatusId"     value="4"  required >Closed</label>
        
       
       
          
         
        </div>
    </div>
						</div>
						 -->
					
				<!-- 	<div class="col-md-12">
							<div class="form-group">
        <label class="col-sm-4 control-label">Select Section</label>
        <div class="col-sm-8" id="statusdiv">
       
        
        <label class="radio-inline"> <input type="radio" name="categoryId" id="categoryId"  checked="checked"    value="1"  required >Section A</label>
        <label class="radio-inline"> <input type="radio" name="categoryId" id="categoryId"     value="2"  required >Section B</label>
        <label class="radio-inline"> <input type="radio" name="categoryId" id="categoryId"      value="3"  required >CAG Report</label>
       
        
       
       
          
         
        </div>
    </div>
						</div>
					 -->



					






					
						<!-- 	<div class="col-md-12">
							<br></br>
								<input type="submit" class="btn btn-1 btn-primary center-block"
									id="getliftschemes" value="Get Paras" >
							</div> -->
						

					</form:form>






				

				



					<div
						class="w3layouts_vertical_tab resp-tab-content resp-tab-content-active  mainprint pagecontent"
						style="display: block">

<%-- <c:if test="${compCapList!=null}"> --%>

						<div class="row show-grid gridList  col-md-12" id="printarea">

							<table class="table-responsive table-bordered " id="table">
								<thead style="background: #D3D3D3 none repeat scroll 0 0;">
									
									<tr>
										<th rowspan="1">Sl.No</th>
										<th rowspan="1">Name of Office</th>
										<th rowspan="1" >Year</th>										
										<th rowspan="1" >File No</th>
										<th rowspan="1" >LAR No.</th>
										<th rowspan="1"  colspan="2">Para Number</th>	
															
										
										<th rowspan="1">Gist Of The Para</th>
										<!-- <th rowspan="1" >Para</th> -->
										<th rowspan="1">Para Status</th>
										<th rowspan="1">Print in CAG</th>									
										<!-- <th rowspan="1" colspan="2">AuditDate</th> -->
										
										
										
										


									</tr>
									
									<tr>
									<th rowspan="1"></th>
									<th rowspan="1"></th>
									<th rowspan="1"></th>
									<th rowspan="1"></th>
									<th rowspan="1"></th>
									<th rowspan="1" >SectionA</th>
										<th rowspan="1" >SectionB</th>	
										<th rowspan="1"></th>
										<th rowspan="1"></th><th rowspan="1"></th>
									
									</tr>
									

									

								</thead>


								<tbody>
									
										<c:forEach items="${paraListTotal}" var="t" varStatus="count">
											<tr>

												<td style="text-align: center;"><c:out
														value="${count.count}"></c:out></td>
													
												<td><b><c:out value="${t.divisionName}"></c:out></b></td>
												<td><c:out value="${t.financialYear}"></c:out></td>
												<td><c:out value="${t.fileNumber}"></c:out></td>
												<td><c:out value="${t.larNumber}"></c:out></td>
											
											
												<td><c:out value="${t.paraNumsectionA}"></c:out></td>
																						
												
											
												
												
											
												
												
												<td><c:out value="${t.paraNumsectionB}"></c:out></td>
																							
												
												
												
											
												
												<td><c:out value="${t.actionTitle}"></c:out></td>

												
											<%-- 	<td width="20%"><c:out value="${t.parasAction}"  escapeXml="false" ></c:out></td> --%>
												<td><c:out value="${t.paraStatus}"></c:out></td>
												<td><c:out value="${t.printCagStatus}"></c:out></td>
												
												
												
										</tr>
										
										
										
										<%-- <tr>	<td><c:out value="${t.auditDateFrom}"></c:out></td>
												<td><c:out value="${t.auditDateTo}"></c:out></td></tr> --%>

										</c:forEach>
									


								
									
									
								</tbody>


							</table>
								
							


						</div>
					<%-- 	</c:if> --%>
					

					</div>



				</div>
			
		</div>





		<div class="row show-grid">
			<div class="clearfix"></div>
			<div class="clearfix"></div>
			<div class="col-md-4"></div>
			<div class="col-md-2">
				<input type="button" class="btn btn-1 btn-primary center-block"
					id="getCasesId" value="Excel Export"
					onclick="tableToExcel('table', 'countertable')">
			</div>

			<div class="col-md-2">
				<input type="button" value="Print Preview"
					class="btn btn-1 btn-primary center-block"
					onclick="PrintPreview('printarea')" />
			</div>
			<div class="col-md-2">
				<input type="button" class="btn btn-1 btn-primary center-block"
					id="getCasesId" value="Print" onclick="printDiv('printarea')">
			</div>


		</div>

	</form:form>
</div>
<!-- //main-content -->



















<script type="text/javascript" src="../js/parsley.js"></script>



   <script type="text/javascript" class="example">
$(function () {
	 $('#getParaCount').parsley().on('field:validated', function() {
		    var ok = $('.parsley-error').length === 0;
		
		   // alert('hi');
		    
		  })
		  
		  .on('form:submit', function() {
			 // alert("coming here");
			 
			
			 
			  document.forms.getParaCount.action="../parasreport/parastatus";
				 document.forms.getParaCount.submit(); 
			
			
				
			  
			  
			    // Don't submit form for this demo
			  });
});

</script>
	  


<!-- //main-content -->
