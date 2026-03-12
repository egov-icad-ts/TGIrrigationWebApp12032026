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
<script type="text/javascript" src="../js/ckeditor/ckeditor.js"></script>
 <script type="text/javascript" src="../js/ckeditor/adapters/jquery.js"></script>
 

<script type="text/javascript">

function clicked(){
	for ( instance in CKEDITOR.instances ){
		
		CKEDITOR.instances[instance].getData();
	//alert("ckeditor values : " + CKEDITOR.instances[instance].getData());
	}
	}
</script>

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
	
	$("#replyDate").datepicker({
		changeYear : true,
		changeMonth : true,
		dateFormat : "dd/mm/yy",
	/*  onSelect: function(selected) {
	   $("#month").datepicker("option","minDate", selected)
	 } */
	});
	
	$('.ckedit').ckeditor();
	clicked();
	
	/*  $('#reply_dialog').dialog({
		  autoOpen:false,
		  width:600
		  
	 }); 


	 $('#add').click(function(){
		// alert("kal");
	  $('#reply_dialog').dialog('option', 'title', 'Add reply');
	  $('#reply_dialog').dialog('open');
	  
	 });
	 */
	
	
});
</script>


<script >

function changeEditFlag(){
	
	$("#editFlag").val(edit);
	
}

	
	
	
	
/* 	function addnewreply(paraId,rpval){
		//alert(rpval);
		
		$("#paravalue").val(rpval);
		var c=$("#paravalue").val();
		//alert(c);
		var edit=true;
		$("#paraId").val(paraId);
		
		var a= $("#replyAction").val();
		
		//alert(a);
		
		
		
		var m=$("#editFlag").val();
	//	alert(m);
		
		
		
		 document.forms[0].urlvalue.value="../parastsimis/viewreplydocs";
			
		
		 /* document.forms.viewreplys.action="../parastsimis/viewreplydocs";
		 document.forms.viewreplys.submit();  */
			// document.forms[0].submit(); 
		
		
//	} */
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
				<h3 class="panel-title">Add New reply</h3>
			</div>

			<!-- <div class='container'> -->



<form:form id="addnewreply" name="addnewreply" method="post"
				modelAttribute="addnewreply"   data-parsley-validate-if-empty="" >
				<input name=urlvalue id="urlvalue" type=hidden >
				
					<input name=paravalue id="paravalue" type=hidden >
				
				
				<input name=unitId     id="unitId" type=hidden   />
	  
				
				
				<input name=editFlag  id="editFlag" type=hidden value="false" >
				
				<input name=deleteFlag  id="deleteFlag" type=hidden value="false" >
				<input name=paraId  id="paraId" type=hidden value="${paraIdValue}" >
				
				<input name=docId  id="docId" type=hidden >
				
				<input name=paraReplyId  id="paraReplyId" type=hidden >
				
				
				
					

		
		
	
		
		
								
										
									
									
	
	
	
	
							 <div  class="col-md-12">
  
    
     <div class="col-md-6">
     <label class="label-controlPMS rowlebel ">Reply Date <font color=red>*</font> </label>
     </div>
	  <div class="col-md-6">
 <input type="text" name="replyDate" id="replyDate"   value="0"   class=" form-control datepicker"  readonly="readonly"  required />
 </div>
       
     				
										
   
  
  <div class="col-md-12">
   	<label class="label-control rowlebel ">Reply<font color=red>*</font></label> 
	<textarea class="ckedit form-control "  id="replyAction" name="replyAction" rows="10" cols="80" placeholder="Reply"   data-parsley-validate-if-empty="" ></textarea>
  </div>
 
   <div class="col-md-12">
    <label class="label-control rowlebel ">Reply Remarks </label>
<textarea class="form-control"  id="replyRemarks" name="replyRemarks"  rows="10" cols="80" placeholder="Reply Remarks"  ></textarea> 
    <span id="error_replyRemarks" class="text-danger"></span>
  </div>
  

    <div class="col-md-12" style="text-align: center;">
    <button type="submit" name="savereply" id="savereply" onclick="changeEditFlag()" class="btn btn-info">Save</button>
    </div>
   
  </div>			
  
  
	
									
	



						
									
									
									
									
									
									
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

    
    
    <script type="text/javascript" class="example">
$(function () {
	 $('#addnewreply').parsley().on('field:validated', function() {
		    var ok = $('.parsley-error').length === 0;
		
		   // alert('hi');
		    
		  })
		  
		  .on('form:submit', function() {
			 // alert("coming here");
			 
			
			 
			  document.forms.addnewreply.action="../parastsimis/addnewreply";
				 document.forms.addnewreply.submit(); 
			
			
				
			  
			  
			    // Don't submit form for this demo
			  });
});

</script>
	  
	 

<!-- //main-content -->
