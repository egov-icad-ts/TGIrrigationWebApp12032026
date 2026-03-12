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

<div class="col-md-9">



<div>

	
		<div class="panel panel-primary ">
			<div class="panel-heading">
				<h3 class="panel-title">Database Access MisViews</h3>
			</div>

			<div class='container'>
			
		
			

				<div class="row col-md-12 toppad ">

					<form:form id="querypane" action="../invtsimis/misviews">
					<div class="row show-grid"  id="pack">
					<div class="col-md-2" >
					<label class="label-controlPMS rowlebel ">Enter Query </label>
					</div>
						<div class="col-md-8">
					
					<textarea rows="4" cols="50"  id="Query" name="Query" class="form-control"   placeholder="Query" required></textarea>
				</div>
				
				
						
						
					</div>
					
					<div class="row show-grid"  >
					
					<div class="col-md-4"></div>
					<div class="col-md-2">
							<input type="submit" class="btn btn-1 btn-primary center-block"
								id="submitquery" value="submit query">
						</div>
						
						<div class="col-md-3"></div>
					
					</div>
					</form:form>
					

<div class="bs-example" data-example-id="contextual-table" style="border: 1px solid #eee">
    <table class="table">
    
    <c:if test="${keys!=null}">
      <thead>
        <tr>
         <c:forEach items="${keys}" var="list" varStatus="count">
          <th><label class="label-controlPMS rowlebel "><c:out value="${list}"></c:out></label></th>
          </c:forEach>
         
        </tr>
      </thead>
      </c:if>
      <tbody>
      
      	<c:if test="${values!=null}">
      	<c:forEach var="val" items="${values}" varStatus="i">
        <tr class="active">
          <c:forEach items="${val}" var = "x" >
         
          <td><label class="label-controlPMS rowlebel "><c:out value="${x}"></c:out></label></td>
          </c:forEach>
        </tr>
        </c:forEach>
        </c:if>
       
      </tbody>
    </table>
  </div>

		


				<%-- 	<div class="row show-grid">
					
					<c:if test="${keys!=null}">
					 <c:forEach items="${keys}" var="list" varStatus="count">
					
					<div class="row show-grid">
					
						<label class="label-controlPMS rowlebel "><c:out value="${list}"></c:out></label>
						
					</div>
					</c:forEach> 
					
					</c:if>
					
						<c:if test="${values!=null}">
						<c:forEach var="val" items="${values}" varStatus="i">
						<div class="row show-grid">
						<c:forEach items="${val}" var = "x" >
						<label class="label-controlPMS rowlebel "><c:out value="${x}"></c:out></label>
						</c:forEach>
					</div>
						</c:forEach>
 		</c:if>

						
					</div> --%>

				</div>

				<!-- row -->

			</div>
			

		</div>
		<!-- panel -->

</div>


	

	</div>
	</div>

	<!-- page -->
	


<!-- container -->

<!-- create component ends here -->

