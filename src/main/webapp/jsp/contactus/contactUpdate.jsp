<%@include file="/jsp/header/taglib_includes.jsp"%>
<!-- create component start here -->


<!-- <script type="text/javascript" src="../js/jquery.js"></script> -->
<script type="text/javascript" src="../js/bootstrap-multiselect.js"></script>
<script type="text/javascript" src="../js/ckeditor/ckeditor.js"></script>

<script>

function CKupdate(){
	 
	 
    for ( instance in CKEDITOR.instances )
        CKEDITOR.instances[instance].updateElement();
    
}

$(document).ready(function(){
      
	$('#statusID').attr('data-parsley-trigger','change');
	$('#statusID').attr('required','true');
	
	$('#resolutionId').attr('data-parsley-trigger','change');
	$('#resolutionId').attr('required','true');
	
}); 	


/* function loadcontactUpdate(){
	
	
		
		  $('#contactus').attr('action', "../pmsUser/updateContact");
          $("#contactus").submit();
          e.preventDefault();
		
	
	
	
} */



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
       <h2> <strong><c:out value="${msg}"></c:out></strong> </h2>
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
	
	
<div class="panel panel-primary">
			<div class="panel-heading">
				<h3 class="panel-title">CONTACT UPDATE</h3>
			</div>
			
			<div class='container'>
			
			<form:form id="contactus" method="post"
				modelAttribute="Contactus" enctype="multipart/form-data" data-parsley-validate=""
				>
		

<div class="col-md-1"></div>
<c:if test="${contactList!=null}">
 <c:forEach var="land" items="${contactList}" varStatus="count" >

		<div class="row col-md-10 toppad ">
		
		<div class="row show-grid">

				<div class="col-md-3">
				
					<label class="label-controlPMS rowlebel ">Name*</label>
					
				</div>
				<div class="col-md-9">
					<input type="text" class="form-control" id="name"
						placeholder="Name" name="name"   value="<c:out value="${land.name}"></c:out>" readonly="readonly">
						
						<input type="hidden" class="form-control" id="randomNumber"
						placeholder="RandomNumber" name="randomNumber"   value="<c:out value="${land.randomNumber}"></c:out>" readonly="readonly">
				</div>
			</div>
			
			<div class="row show-grid">

				<div class="col-md-3">
				
					<label class="label-controlPMS rowlebel ">Designation*</label>
					
				</div>
				<div class="col-md-9">
					<input type="text" class="form-control" id="designation"
						placeholder="Designation" name="designation" value=" <c:out value="${land.designation}"></c:out>" readonly="readonly" >
				</div>
			</div>
			<div class="row show-grid">
			
			<div class="col-md-3">
			
			<label class="label-controlPMS rowlebel ">Query Type*</label>
			</div>
				
				<div class="col-md-9">
					<label class="label-controlPMS  "><c:out value="${land.contactType}"></c:out></label>
				</div>
				</div>
				
					<div class="row show-grid">

				<div class="col-md-3">
				
					<label class="label-controlPMS rowlebel ">Description*</label>
					
				</div>
				<div class="col-md-9">
					<label class="label-controlPMS  "><c:out value="${land.description}"  escapeXml="false" ></c:out>
					</label>
				</div>
			</div>
			
			<div class="row show-grid">

				<div class="col-md-3">
				
					<label class="label-controlPMS rowlebel ">Email*</label>
					
				</div>
				<div class="col-md-9">
					<input type="text" class="form-control" id="email"
						placeholder="Email" name="email" value="<c:out value="${land.email}"></c:out>"  readonly="readonly">
				</div>
			</div>
			
			
			<div class="row show-grid">

				<div class="col-md-3">
				
					<label class="label-controlPMS rowlebel ">Subject*</label>
					
				</div>
				<div class="col-md-9">
					<input type="text" class="form-control" id="subject"
						placeholder="Subject" name="subject" value="<c:out value="${land.subject}"></c:out>" readonly="readonly" >
				</div>
			</div>
			
			
			<div class="row show-grid">

				<div class="col-md-3">
				
					<label class="label-controlPMS rowlebel ">ContactNo*</label>
					
				</div>
				<div class="col-md-9">
					<input type="text" class="form-control" id="contactNo"
						placeholder="contactNo" name="contactNo" value="<c:out value="${land.contactNo}"></c:out>" readonly="readonly" >
				</div>
			</div>
			
			
			<div class="row show-grid">

				<div class="col-md-3">
				
					<label class="label-controlPMS rowlebel ">Attachment*</label>
					
				</div>
				<div class="col-md-9">
					<input type="text" class="form-control" id="fileName"
						placeholder="fileName" name="fileName" value="<c:out value="${land.fileName}"></c:out>" readonly="readonly" >
				</div>
			</div>
			
			
			<div class="row show-grid">

				<div class="col-md-3">
				
					<label class="label-controlPMS rowlebel ">Select  Status*</label>
					
				</div>
				<div class="col-md-9">
				
					<select class="form-control" id="statusID" name="statusID"  >
						<option value=0>--Select --</option>
						<c:forEach items="${contactStatusList}" var="prj">
							<option value="${prj.statusID}">${prj.status}</option>
						</c:forEach>
					</select>
				</div>
			
			</div>
			
			<div class="row show-grid">

				<div class="col-md-3">
				
					<label class="label-controlPMS rowlebel ">Select Resolution*</label>
					
				</div>
				<div class="col-md-9">
				
					<select class="form-control" id="resolutionId" name="resolutionId"  >
						<option value=0>--Select --</option>
						<c:forEach items="${resolutionList}" var="prj">
							<option value="${prj.resolutionId}">${prj.resolution}</option>
						</c:forEach>
					</select>
				</div>
			
			</div>
			
			
			
			
			
			<div class="row show-grid">

				<div class="col-md-3">
				
					<label class="label-controlPMS rowlebel ">Remarks*</label>
					
				</div>
				<div class="col-md-9">
					<textarea  class="form-control" id="remarks"  data-parsley-required="true"
						placeholder="remarks" name="remarks"  rows="5" cols="80"></textarea>
						<script type="text/javascript">
				        //CKEDITOR.replace( 'description' );
				        CKEDITOR.replace('remarks',	{
							toolbar : 'MyToolbar'
 
							
						});
				        
				        
						</script>
				</div>
			</div>
			
			
			
			
			
		
			
			
		
			
			
			
			<div class="row show-grid">
				<div class="col-md-12">
					<input type="submit" class="btn btn-1 btn-primary center-block"
						id="updateQuery" value="Upadate Query" >
				</div>
			</div>
		</div>
		<!-- row -->
		</c:forEach>
		</c:if>
		
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
    
    var qu=$('#statusID').val();
    
    // alert("qu"+qu);
     
     if (qu== '0') {

     	$( '#statusID' ).removeClass( "parsley-success" ).addClass( "parsley-error" );
   
     } else {
     	$('#statusID').removeAttr('required');
     	$( '#statusID' ).removeClass( "parsley-error" ).addClass( "parsley-success" );
       
     }
    
     
     var qu1=$('#resolutionId').val();
     
     // alert("qu"+qu);
      
      if (qu1== '0') {

      	$( '#resolutionId' ).removeClass( "parsley-success" ).addClass( "parsley-error" );
    
      } else {
      	$('#resolutionId').removeAttr('required');
      	$( '#resolutionId' ).removeClass( "parsley-error" ).addClass( "parsley-success" );
        
      }
     
     
     
     
  

    
  
  })
  .on('form:submit', function() {
	  
	  document.forms.contactus.action="../pmsUser/updateContact";
		 document.forms.contactus.submit(); 
   
	 
	  
      
	
  });
});
</script>
