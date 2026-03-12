<!-- create component start here -->
<%@include file="/jsp/header/taglib_includes.jsp"%>
<script type="text/javascript" src="../js/jquery.min.js"></script>
<script type="text/javascript" src="../js/bootstrap.min.js"></script>
<link rel="stylesheet" href="../css/bootstrap-multiselect.css"
	type="text/css">
	<link href="../css/parsley.css" rel="stylesheet">
<script type="text/javascript" src="../js/bootstrap-multiselect.js"></script>
<script type="text/javascript" src="../js/parsley.js"></script>

<!-- <link rel="stylesheet" href="../css/bootstrap.min.css" type="text/css" /> -->
 
<script>
	$(document).ready(function() {
					

					});



</script>




	<c:if test="${userObj!=null}">
	<div class="row-fluid  ">

		<div class="span6 pull-right">
			<p class="rowBlue" > <c:out value="${userObj.employeeName}"></c:out></p>
		</div>
	</div>
	</c:if>
	
	<div class="page">
	
	<c:if test="${msg!=null || err!=null }">
	
	<div class="row show-grid">
	<c:if test="${msg!=null}">
	 <div class="alert alert-success" role="alert">
        <strong>Well done!</strong> <c:out value="${msg}"></c:out>
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
	
		<h4><c:out value="${message}"></c:out></h4>
<div class="w3_agile_main_left">
		<div class="panel panel-primary ">
			<div class="panel-heading">
				<h3 class="panel-title">Error Page</h3>
			</div>

			<div class='container'>
			
			

				<!-- row -->

			</div>
			

		</div>
		<!-- panel -->

</div>


	

	</div>

	<!-- page -->
	


<!-- container -->

<!-- create component ends here -->

