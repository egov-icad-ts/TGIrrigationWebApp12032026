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

 


<script>
$(document).ready(function(){

	//$('#reply_dialog').hide();
	


	 
	  
			
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

$(function() {
	
	
	
	
	
	
});
</script>


<script >

	
	
function getcompmonayacut(componentId,unitId)
{
	//alert("kalcoming"+componentId+"---"+unitId);
	
	document.forms[0].urlvalue.value="../comptsimis/delCompMonAyacut";
	
	   $("#componentId").val(componentId);
	   $("#unitId").val(unitId);
	 
		 document.forms[0].submit(); 
	
	
	
	}


	
	
	function deleteIrParas(paraId){
		
		
		// alert("klcoming here"+compPowerId);
		 $("#deleteFlag").val(true);
		  $("#paraId").val(paraId);
		  
		
		 
		 document.forms[0].urlvalue.value="../parastsimis/deleteirparas";
			
		
		 
		
			 document.forms[0].submit(); 
		
		
		
		
	}
	

	
	function deletereply(paraReplyId,paraId){
		
		
		$("#paravalue").val("rp");
		var c=$("#paravalue").val();
		//alert(c);
		
		$("#paraId").val(paraId);
		
		
		  $("#paraReplyId").val(paraReplyId);
		 
		 document.forms[0].urlvalue.value="../parastsimis/viewreplydocs";
			
		
		 
		
			 document.forms[0].submit(); 
		
		
	}
	
	
	
	function deletedocs(docId,paraId){
		
		
		$("#paravalue").val("dc");
		var c=$("#paravalue").val();
		//alert(c);
		
		$("#paraId").val(paraId);
		
		
		  $("#docId").val(docId);
		 
		 document.forms[0].urlvalue.value="../parastsimis/viewreplydocs";
			
		
		 
		
			 document.forms[0].submit(); 
		
		
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
	 

				
	
				
				

	
	
		
		
	
	
	
	
	<div class="panel panel-primary  col-md-12">
			<div class="panel-heading">
				<h3 class="panel-title">Edit/Delete IrParas</h3>
			</div>

			<!-- <div class='container'> -->



<form:form id="viewreplys" name="viewreplys" method="post"
				modelAttribute="viewreplys" >
				<input name=urlvalue id="urlvalue" type=hidden >
				
					<input name=paravalue id="paravalue" type=hidden >
				
				
				<input name=unitId     id="unitId" type=hidden   />
	  
				
				
				<input name=editFlag  id="editFlag" type=hidden value="false" >
				
				<input name=deleteFlag  id="deleteFlag" type=hidden value="false" >
				<input name=paraId  id="paraId" type=hidden >
				
				<input name=docId  id="docId" type=hidden >
				
				<input name=paraReplyId  id="paraReplyId" type=hidden >
				
				
				
					

		
		
	
		
		
								
										
									
									
	
	  <c:set var = "useradmin" scope = "session" value = "cc_admin"/>
	
	<c:if test="${replyListTotal!=null}">
	
		
							
  
	<div class="col-md-12">
		
	
									
									
									<div class="col-md-7">Reply</div>
									
									<div class="col-md-2">Remarks</div>
									<div class="col-md-1">Reply Date</div>
									<div class="col-md-2">Delete </div>
									
									</div>
									<c:forEach items="${replyListTotal}" var="y" varStatus="count">
								
									
									
									<div class="row show-grid"  style="border-style:dotted; border-color: gray">
									
									
									
									
									<div class="col-md-12">
									<div class="col-md-7"><c:out value="${y.replyAction}" escapeXml="false" ></c:out></div>
									<div class="col-md-2"><c:out value="${y.replyRemarks}"></c:out></div>
									<div class="col-md-1"><c:out value="${y.replyDate}"></c:out></div>
									
									<%-- <c:out value="${userObj.userName}"></c:out>
									
									
									<c:out value="${y.userName}"></c:out>
									
								
									
									<c:out value="${y.createUserName}"></c:out>
									 --%>
									 
									
									
									<c:if test="${(userObj.userName==y.userName) || (userObj.userName==y.createUserName) || (userObj.userName==useradmin) }"> 
									<div class="col-md-2" > 
											
							          <button type="button" class="btn btn-danger btn-sm" onclick='deletereply(<c:out value="${y.paraReplyId}"></c:out> , <c:out value="${y.paraId}"></c:out> )' >Delete</button>
							          </div>
							     </c:if>
									
									</div>
									
									</div>
									
									</c:forEach>
									
									</c:if>
	




<c:if test="${paradocsList!=null }">
<div class="col-md-12">
									
									
									<div class="col-md-6">Document Name</div>
									
									
									
									<div class="col-md-6">Delete</div>
								
									
									</div>
									
<c:forEach items="${paradocsList}" var="d" varStatus="doc">



<div class="row show-grid"  style="border-style:dotted; border-color: gray">
									
									
									<div class="col-md-12">
									
									<div class="col-md-6"><a href="../uploadedFiles/IRParas/${d.paraDocName }"  >  ${d.paraDocOriginalName }</a></div>
									<div class="col-md-6"> <button type="button" class="btn btn-danger btn-sm" onclick='deletedocs(<c:out value="${d.docId}"></c:out>,<c:out value="${d.paraId}"></c:out>)' >Delete</button></div>
									
									
									</div>
									
									
									
									</div> 
	


</c:forEach>


</c:if>								
									
									
									
									
									
									
									
		</form:form>				
									</div>
									
									
									
											
											
											
										    
											
											
						
				
	
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
