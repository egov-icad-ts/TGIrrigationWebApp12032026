
<!--main code block-->
<!-- sec-section -->

<!-- create component start here -->
<%@include file="/jsp/header/taglib_includes.jsp"%>

<title>IR Paras AG Paras Information</title>


<link rel="stylesheet" href="../css/bootstrap-multiselect.css"
	type="text/css">
<script type="text/javascript" src="../js/bootstrap-multiselect.js"></script>
<script type="text/javascript" src="../js/jquery-ui.js"></script>
<link rel="stylesheet" media="screen" href="../css/jquery-ui.css">










<script type="text/javascript">
<!--


function gettaskcircleList(unitId,circleId)
{
	
	var m =$("#hiddentaskTypeId").val();
	document.forms[0].urlvalue.value="../task/taskreport2";
	
	   $("#unitId").val(unitId);
	   $("#circleId").val(circleId);
	   $("#taskTypeId").val(m);
	
		 document.forms[0].submit(); 
	
	
	
	}

//-->
</script>


<div class="w3l-main" id="borderStyle">

	<form:form id="express" method="post" modelAttribute="infix">

		


		<div class="panel panel-primary" style="padding:10px">
			<div class="panel-heading">
				<h3 class="panel-title">infix</h3>
			</div>

			

                <label>EXpression</label>

                  <input type="text" class=" form-control "  id="infix" name="infix" placeholder="express"  />
                  
                  <div class="col-sm-12">
										<div class="col-md-2 "></div>
										<div class="col-md-8 ">
											<label class="label-control rowlebel "></label><input
												type="submit" class="btn btn-1 btn-primary center-block"
												id="submitparas" value="Submit Infix">
										</div>
									</div>
                  
			


                       <div>${output}</div>





					

					</div>
				



			
		





		<div class="row show-grid">
			<div class="clearfix"></div>
			<div class="clearfix"></div>
			<div class="col-md-4"></div>
			<!-- <div class="col-md-2">
				<input type="button" class="btn btn-1 btn-primary center-block"
					id="getparaId" value="Excel Export"
					onclick="tableToExcel('table', 'countertable')">
			</div>

			<div class="col-md-2">
				<input type="button" value="Print Preview"
					class="btn btn-1 btn-primary center-block"
					onclick="PrintPreview('printarea')" />
			</div>
			<div class="col-md-2">
				<input type="button" class="btn btn-1 btn-primary center-block"
					id="getparaprintId" value="Print" onclick="printDiv('printarea')">
			</div> -->
			
			


		</div>

	</form:form>
</div>
<!-- //main-content -->


 















