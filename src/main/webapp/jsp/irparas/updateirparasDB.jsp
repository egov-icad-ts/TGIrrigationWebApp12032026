<!-- create component start here -->
<%@include file="/jsp/header/taglib_includes.jsp"%>
<script type="text/javascript" src="../js/jquery.min.js"></script>
<script type="text/javascript" src="../js/bootstrap.min.js"></script>
<link rel="stylesheet" href="../css/bootstrap-multiselect.css"
	type="text/css">
	<link href="../css/parsley.css" rel="stylesheet">
<script type="text/javascript" src="../js/bootstrap-multiselect.js"></script>
<script type="text/javascript" src="../js/parsley.js"></script>
 <link rel="stylesheet" href="../css/Html5DataTable/jquery.dataTables.min.css" />
	<link rel="stylesheet" href=" ../css/Html5DataTable/buttons.dataTables.min.css" />

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
				<h3 class="panel-title">Database Access</h3>
			</div>

			<div class='container'>
			
		
			

				<div class="row col-md-12 toppad ">

					<form:form id="querypane" action="../parastsimis/resultofliveDB">
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
					

<div class="show-grid gridList "  	style="display: block">
		
		
		
		              <div class="table-responsive" id="printarea">
  <table class="display table-bordered " id="table1">
    
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

	<!-- page -->
	


<!-- container -->

<!-- create component ends here -->

<script src="../js/Html5DataTable/jquery.dataTables.min.js" type="text/javascript"></script>	
	<script src=" ../js/Html5DataTable/dataTables.buttons.min.js" type="text/javascript"></script>	
	<script src=" ../js/Html5DataTable/jszip.min.js" type="text/javascript"></script>	
	<script src="../js/Html5DataTable/pdfmake.min.js" type="text/javascript"></script>	
	<script src=" ../js/Html5DataTable/vfs_fonts.js" type="text/javascript"></script>	
	<script src="../js/Html5DataTable/buttons.html5.min.js" type="text/javascript"></script>
	<script src="../js/Html5DataTable/buttons.print.min.js" type="text/javascript"></script>
	<script src="../js/Html5DataTable/dataTables.select.min.js" type="text/javascript"></script>
	<script src="../js/Html5DataTable/buttons.colVis.min.js" type="text/javascript"></script>	
	
	
	<script type="text/javascript">	
	
	//var colcount = $('#table1 thead tr th').length;
	//alert("colcount"+colcount);
				
   $('#table1').DataTable( {
        dom: 'Bfrtip',
        responsive: true,
        "paging": false,
        "ordering": false,
        "autoWidth": true,
        "lengthChange": false,
        "pageLength": 20,
        "autoheight": true,
        buttons: [
             {
                extend: 'copyHtml5',
                text:  'Copy Data',
                exportOptions: {
                    columns: [ 0, ':visible' ]
                }
            },
            {
                extend: 'excelHtml5',
                autoFilter: true,
                sheetName: 'Exported_Ayacut_data',
                text:  'Download Data To Excel',
                className: 'btn-primary ',
                messageTop: 'Constituency-Village Ayacut Report',
                	 exportOptions: {
                         columns: ':visible'
                     }
               
                
            },
            
           
            {
                extend: 'print',
                text: 'Print All',
                className: 'btn-primary ',
                exportOptions: {
                    modifier: {
                        selected: null
                    },
                    columns: ':visible'
                }
               
                
                
            },
            ,{
                extend: 'print',
                text: 'Print Selected',
                className: 'btn-primary ',
                exportOptions: {
                    columns: ':visible'
                }
                
                
                
            },
            
            {
                extend: 'colvis',
                text: 'Exclude for Print/Export',
               
                columnText: function ( dt, idx, title ) {
                    return (idx+1)+': '+title;
                }
               
                }
                
            
        ],
        select: true
       
    } );
   
  
  

    
    </script>	

