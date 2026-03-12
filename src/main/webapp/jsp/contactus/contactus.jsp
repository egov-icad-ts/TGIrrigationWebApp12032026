<%@include file="/jsp/header/taglib_includes.jsp"%>
<!-- create component start here -->



<!-- <script type="text/javascript" src="../js/jquery.js"></script> -->
<script type="text/javascript" src="../js/bootstrap-multiselect.js"></script>
<script type="text/javascript" src="../js/ckeditor/ckeditor.js"></script>

<script>
$(document).ready(function(){
      
	$('#queryId').attr('data-parsley-trigger','change');
	$('#queryId').attr('required','true');
	
}); 	

function CKupdate(){
	 
	 
    for ( instance in CKEDITOR.instances )
        CKEDITOR.instances[instance].updateElement();
    
}

/* function loadcontact(){
	
	
		
		  $('#contactus').attr('action', "../pmsUser/querySubmit");
          $("#contactus").submit();
          e.preventDefault();
		
	
	
	
}
 */


</script>

<div class='container'>
	
	<div class="row-fluid">

		<div class="span6 pull-right">
			<c:out value="${userObj.employeeName}"></c:out>
		</div>
	</div>

	<div class="page">
	
	<c:if test="${msg!=null || err!=null }">
	
	<div class="row show-grid">
	<c:if test="${msg!=null}">
	 <div class="alert alert-success" role="alert">
        <h2><strong><c:out value="${msg}"></c:out></strong></h2>
      </div>
      
      </c:if>		
     
      <c:if test="${err!=null}">
	  
	    <div class="alert alert-danger" role="alert">
        <strong>Error!</strong> <c:out value="${err}"></c:out>
      </div>
       <c:set></c:set>
      </c:if>
   
	</div>
	</c:if>
	
	<div class="row show-grid">
<div class="col-md-3 "></div>
				
				<div class="col-md-6 ">
					<h2><a href="../pmsUser/contactQuery">Click to know your Query Status</a></h2>
				</div>
				<div class="col-md-3 "></div>
			</div>
<div class="panel panel-primary">
			<div class="panel-heading">
				<h3 class="panel-title">Contact Us</h3>
			</div>
			
			<div class='container'>
			
			<form:form id="contactus" name="contactus" method="post"
				modelAttribute="Contactus" enctype="multipart/form-data" data-parsley-validate=""
				>
		

<div class="col-md-1"></div>

		<div class="row col-md-10 toppad ">
		
		<div class="row show-grid">

				<div class="col-md-3">
				
					<label class="label-controlPMS rowlebel ">Name*</label>
					
				</div>
				<div class="col-md-9">
					<input type="text" class="form-control" id="name"
						placeholder="Name" name="name" readonly="readonly" value="<c:out value="${userObj.employeeName}"></c:out>">
				</div>
			</div>
			
			<div class="row show-grid">

				<div class="col-md-3">
				
					<label class="label-controlPMS rowlebel ">Designation*</label>
					
				</div>
				<div class="col-md-9">
					<input type="text" class="form-control" id="designation"
						placeholder="Designation" name="designation" readonly="readonly"  value="<c:out value="${userObj.designationName}"></c:out>">
						
						<input type="hidden" class="form-control" id="designationId"
						placeholder="DesignationId" name="designationId" readonly="readonly"  value="<c:out value="${userObj.designationId}"></c:out>">
				</div>
			</div>
			<div class="row show-grid">
			
			<div class="col-md-3">
			
			<label class="label-controlPMS rowlebel ">Query Type*</label>
			</div>
				
				<div class="col-md-9">
				
				
					<select  class="form-control" id="queryId"   name="queryId" 
         >
						<option value=0>Select</option>
						<c:forEach items="${queryList}" var="qt">
							<option value="${qt.queryId}">${qt.queryType}</option>
						</c:forEach>
						
						
						
						
					</select>
				</div>
				</div>
				
					<div class="row show-grid">

				<div class="col-md-3">
				
					<label class="label-controlPMS rowlebel ">Subject*</label>
					
				</div>
				<div class="col-md-9">
					<input type="text" class="form-control" id="subject" required
						placeholder="Subject" name="subject">
				</div>
			</div>
			
			
			<div class="row show-grid">

				<div class="col-md-3">
				
					<label class="label-controlPMS rowlebel ">Description*</label>
					
				</div>
				<div class="col-md-9">
					<textarea  class="form-control"  data-parsley-required="true" id="description"
						placeholder="Description" name="description"   rows="5" cols="80"></textarea>
						<script type="text/javascript">
				        //CKEDITOR.replace( 'description' );
				        CKEDITOR.replace('description',	{
							toolbar : 'MyToolbar'
 
							
						});
				        
				        
						</script>
				</div>
			</div>
			
			<div class="row show-grid">

				<div class="col-md-3">
				
					<label class="label-controlPMS rowlebel ">Email*</label>
					
				</div>
				<div class="col-md-9">
					<input type="text" class="form-control" id="email" data-parsley-trigger="change" required  data-parsley-type="email"
						placeholder="Email" name="email">
				</div>
			</div>
			
			
			
			<div class="row show-grid">

				<div class="col-md-3">
				
					<label class="label-controlPMS rowlebel ">ContactNo*</label>
					
				</div>
				<div class="col-md-9">
					<input type="text" class="form-control" id="contactNo" required  data-parsley-trigger="keyup" data-parsley-type="number" data-parsley-minlength="10" data-parsley-maxlength="10" data-parsley-minlength-message="You need to enter at least a 10 digit mobile number" data-parsley-validation-threshold="10"	placeholder="ContactNo" name="contactNo">
				</div>
			</div>
			
			<div class="row show-grid">

				<div class="col-md-3">
				
					<label class="label-controlPMS rowlebel ">Upload a File</label>
					
				</div>
				<div class="col-md-9">
								<input id="fileUpload" name="fileUpload" type="file" 
									class="btn-info" value="Browse" >
							</div>

			</div>
			
			
			
		
			
			
			
			<div class="row show-grid">
				<div class="col-md-12">
					<input type="submit" class="btn btn-1 btn-primary center-block"
						id="submitQuery" value="Submit Query" >
				</div>
			</div>
		</div>
		<!-- row -->
		
		<div class="col-md-1"></div>
		
		</form:form>
		
		
		</div>
		
		
		</div> 
		<!-- panel -->



	</div>
	<!-- page -->
</div>
<!-- container -->

<script type="text/javascript" src="../js/parsley.js"></script>
<link href="../css/parsley.css" rel="stylesheet">

    
    
   <script type="text/javascript">
   
  
$(function () {
	
	
	
	      
	
	
  $('#contactus').parsley().on('field:validated', function() {
	  
    var ok = $('.parsley-error').length === 0;
    
   
    
    var qu=$('#queryId').val();
    
   // alert("qu"+qu);
    
    if (qu== '0') {

    	$( '#queryId' ).removeClass( "parsley-success" ).addClass( "parsley-error" );
  
    } else {
    	$('#queryId').removeAttr('required');
    	$( '#queryId' ).removeClass( "parsley-error" ).addClass( "parsley-success" );
      
    }

    
  
  })
  .on('form:submit', function() {
	 
	  document.forms.contactus.action="../pmsUser/querySubmit";
		 document.forms.contactus.submit(); 
      
	
  });
});
</script>
