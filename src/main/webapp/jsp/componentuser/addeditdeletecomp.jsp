
<!--main code block-->
<!-- sec-section -->

<!-- create component start here -->
<%@include file="/jsp/header/taglib_includes.jsp"%>


<link rel="stylesheet" href="../css/bootstrap-multiselect.css"
	type="text/css">
<!-- <script type="text/javascript" src="../js/bootstrap.min.js"></script> -->
<script type="text/javascript" src="../js/bootstrap-multiselect.js"></script>

<link rel="stylesheet" media="screen" href="../css/jquery-ui.css">
<script type="text/javascript" src="../js/jquery-ui.js"></script>

<link rel="stylesheet" href="../css/foundation-icons.min.css">
<link rel="stylesheet" href="../css/cus.css">

<style type="text/css">
.fix_height {
	height: 82px;
}
</style>

<script>
	function getProjects() {

		var unitId = $('#unitId').val();

		//  alert("procId"+procId);
		$('#projectId').multiselect('rebuild');

		$.ajax({
			url : "../web/getProjects?unitId=" + unitId,
			type : "GET",
			success : function(response) {
				var $select = $('#projectId');
				$select.find('option').remove();

				var selectedProj = $('#selectedProjId').val();

				var obj = JSON.parse(response);

				$('#projectId')
						.append('<option value=" "> --select--</option>');

				$.each(obj,
						function(key, value) {

							if (selectedProj == value.projectId) {

								$('#projectId').append(
										'<option value="'+value.projectId+'" selected="selected"> '
												+ value.projectName
												+ '</option>');

							}

							if (selectedProj == null
									|| selectedProj != value.projectId) {
								$('#projectId').append(
										'<option value="'+value.projectId+'"> '
												+ value.projectName
												+ '</option>');

							}
							$('#projectId').multiselect('rebuild')

							/* 	$(this).removeAttr('selected').prop('selected', false);
							  
							  if($('li').hasClass('active')){
							  	if($('input').prop('checked', true)){
							  		
							  		 $('input').prop('checked', false);
							  		
							  	var spantext=	$("span.multiselect-selected-text").text();
							  	$("span.multiselect-selected-text").text('None Selected')
							  		
							  		
							  	}
							  	$('li').removeClass('active');
							     
							  } */

						});
			},
			error : function() {
				alert(error);
			}
		});
	}

	function getParents(projId) {

		var projectId = projId;
		//$('#projectId').val();

		//  alert("kal"+projectId);
		$("#componentId").multiselect('rebuild');

		//  alert("kal2");

		$.ajax({
			url : "../comptsimis/getparent?projectId=" + projectId,
			type : "GET",
			success : function(response) {
				//alert("res"+response)
				var $select = $('#componentId');
				$select.find('option').remove();

				var selectedCompId = $('#selectedCompId').val();

				var obj = JSON.parse(response);

				$('#componentId').append(
						'<option value="0"> --select--</option>');

				$.each(obj, function(key, value) {

					if (selectedCompId == value.componentId) {

						$('#componentId').append(
								'<option value="'+value.componentId+'" selected="selected"> '
										+ value.componentName + '</option>');

					}

					if (selectedCompId == null
							|| selectedCompId != value.componentId) {

						$('#componentId').append(
								'<option value="'+value.componentId+'"> '
										+ value.componentName + '</option>');

					}

					$('#componentId').multiselect('rebuild');

					/* 	$(this).removeAttr('selected').prop('selected', false);
					  
					  if($('li').hasClass('active')){
					  	if($('input').prop('checked', true)){
					  		
					  		 $('input').prop('checked', false);
					  		
					  	var spantext=	$("span.multiselect-selected-text").text();
					  	$("span.multiselect-selected-text").text('None Selected')
					  		
					  		
					  	}
					  	$('li').removeClass('active');
					     
					  } */

				});
			},
			error : function() {
				alert(error);
			}
		});
	}

	function getMandals() {

		//alert("kal");

		var districtId = document.getElementById("districtId").value;

		//alert(districtId);

		$
				.ajax({
					url : "../web/getMandals?districtId=" + districtId,
					type : "GET",
					success : function(response) {
						var $select = $('#mandalId');
						$select.find('option').remove();

						var selectedMandal = $('#hiddenMandalId').val();

						$('#mandalId').append(
								'<option value="0"> --select--</option>');
						var obj = JSON.parse(response);
						$.each(obj, function(key, value) {

							if (selectedMandal == value.mandalId) {
								$('#mandalId').append(
										'<option value="'+value.mandalId+'" selected="selected" > '
												+ value.mandalName
												+ '</option>');
							}

							if (selectedMandal == null
									|| selectedMandal != value.mandalId) {
								$('#mandalId').append(
										'<option value="'+value.mandalId+'"  > '
												+ value.mandalName
												+ '</option>');
							}

							$('#mandalId').multiselect('rebuild');
						});

					},
					error : function() {
						alert(error);
					}
				});
	}

	function getVillages(k) {
		//alert("kal");
		//var districtId=document.getElementById("districtId").value;
		var mandalId = k;
		//document.getElementById("mandalId").value;
		//alert(mandalId);

		$.ajax({
			url : "../web/getVillages?mandalId=" + mandalId,
			type : "GET",
			success : function(response) {

				var $select = $('#villageId');

				$select.find('option').remove();

				var selectedVillage = $('#hiddenVillageId').val();

				var obj = JSON.parse(response);
				$('#villageId')
						.append('<option value="0"> --select--</option>');

				$.each(obj, function(key, value) {

					if (selectedVillage == value.villageId) {

						$('#villageId').append(
								'<option value="'+value.villageId+'" selected=="selected"> '
										+ value.villageName + '</option>');
					}
					if (selectedVillage == null
							|| selectedVillage != value.villageId) {

						$('#villageId').append(
								'<option value="'+value.villageId+'" > '
										+ value.villageName + '</option>');
					}

					$('#villageId').multiselect('rebuild');
				});

			},
			error : function() {
				alert(error);
			}
		});
	}

	function getAddComponent() {

		document.forms[0].urlvalue.value = "../comptsimis/addcomp";

		document.forms[0].submit();

	}

	function getDeleteComponent() {

		document.forms[0].urlvalue.value = "../comptsimis/deleteComponent";

		document.forms[0].submit();

	}
</script>




<script>
	$(document).ready(function() {

		$('#projectId').multiselect({

			enableCaseInsensitiveFiltering : true

		});
		$('#districtId').multiselect({

			enableCaseInsensitiveFiltering : true

		});
		$('#mandalId').multiselect({

			enableCaseInsensitiveFiltering : true

		});
		$('#villageId').multiselect({

			enableCaseInsensitiveFiltering : true

		});

		$('#componentId').multiselect({

			enableCaseInsensitiveFiltering : true

		});

	});

	$(function() {

		$("#presentAyacutmonth").datepicker({
			changeYear : true,
			changeMonth : true,
			dateFormat : "dd/mm/yy",
		/*  onSelect: function(selected) {
		   $("#month").datepicker("option","minDate", selected)
		 } */
		});

		$("#presentAyacutCreated").keyup(function() {

			var a = $("#presentAyacutCreated").val();

			var b = $("#previousAyacutCreated").val();

			var c = parseFloat(a) + parseFloat(b)

			$("#totalayacutCreated").val(c);

		});

		$("#presentAyacutContemplated").keyup(function() {

			var a = $("#presentAyacutContemplated").val();

			var b = $("#previousAyacutContemplated").val();

			var c = parseFloat(a) + parseFloat(b);

			$("#totalayacutContemplated").val(c);

		});

	});
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




<div class="w3_agile_main_left">


	<div class="panel panel-primary ">
		<div class="panel-heading">
			<h3 class="panel-title">Add/Edit/Delete Component</h3>
		</div>

		<form:form id="compinput" method="post" class="stepform"
			data-parsley-validate-if-empty="">
			<input name=urlvalue type=hidden>
			<div class="col-md-12">



				<div class="row">
					<div class="small-12 columns" style="text-align: center;">
						<h2 class="subheader">
							<b>Component</b>
						</h2>
					</div>
				</div>
				<br>
				<div class="row" data-equalizer>
					<div class="small-12 medium-12 large-12 columns callout">
						<div class="small-12 medium-6 large-4 columns end">
						<div class="callout fix_height" data-equalizer-watch
									style="box-shadow: 1px 2px 1px rgba(0, 0, 0, 0.3)"> 
									 <div class="dark-grey"> 
							<a class="btn icon-btn btn-success" href="../comptsimis/addcomp">
								 
									
										<span class="glyphicon btn-glyphicon glyphicon-plus img-circle text-success"></span>&nbsp;
									 	<h5 class="base" style="display: inline;"> 
											<b>Add Component</b>
										</h5>
									
							</a>
							 </div> 
								</div>

						</div>
						<div class="small-12 medium-6 large-4 columns end">
						<div
									class="callout fix_height" data-equalizer-watch
									style="box-shadow: 1px 4px 1px rgba(0, 0, 0, 0.3)">
									<div class="dark-grey">
							<a class="btn icon-btn btn-primary" href="../comptsimis/deleteComponent">
							
										<span class="glyphicon btn-glyphicon  glyphicon-edit img-circle text-primary"></span>&nbsp;
										<h5 class="base" style="display: inline;">
											<b>Delete/Edit Component</b>
										</h5>
									</a>
									</div>
								</div>
						</div>
						<div class="small-12 medium-6 large-4 columns end">
						<div
									class="callout fix_height" data-equalizer-watch
									style="box-shadow: 1px 4px 1px rgba(0, 0, 0, 0.3)">
									<div class="dark-grey">
							<a  class="btn icon-btn btn-success"  href="../comptsimis/getLiftCompInput">
							
										<span class="glyphicon btn-glyphicon glyphicon-plus img-circle text-success"></span>&nbsp;
										<h5 class="base" style="display: inline;">
											<b>Add Component Data</b>
										</h5>
									</a>
									</div>
								</div>
						</div>
						<div class="small-12 medium-6 large-4 columns end">
						<div
									class="callout fix_height" data-equalizer-watch
									style="box-shadow: 1px 4px 1px rgba(0, 0, 0, 0.3)">
									<div class="dark-grey">
							<a  class="btn icon-btn btn-primary" href="../comptsimis/delCompInput">
							
										<span class="glyphicon btn-glyphicon  glyphicon-edit img-circle text-primary"></span>&nbsp;
										<h5 class="base" style="display: inline;">
											<b>Delete/Edit Component Data</b>
										</h5>
									</a>
									</div>
								</div>
						</div>
						<div class="small-12 medium-6 large-4 columns end">
						<div
									class="callout fix_height" data-equalizer-watch
									style="box-shadow: 1px 4px 1px rgba(0, 0, 0, 0.3)">
									<div class="dark-grey">
							<a class="btn icon-btn btn-success"  href="../comptsimis/getCompDailyInput">
							
										<span class="glyphicon btn-glyphicon glyphicon-plus img-circle text-success"></span>&nbsp;
										<h5 class="base" style="display: inline;">
											<b>Component Daily Input</b>
										</h5>
									</a>
									</div>
								</div>
						</div>
						
						<div class="small-12 medium-6 large-4 columns end">
						<div
									class="callout fix_height" data-equalizer-watch
									style="box-shadow: 1px 4px 1px rgba(0, 0, 0, 0.3)">
									<div class="dark-grey">
							<a  class="btn icon-btn btn-primary" href="../comptsimis/deleteCompdailyInput">
							
									
										<span class="glyphicon btn-glyphicon  glyphicon-edit img-circle text-primary"></span>&nbsp;
										<h5 class="base" style="display: inline;">
											<b>Edit/Delete Daily Input</b>
										</h5>
									</a>
									</div>
								</div>
						</div>
						<div class="small-12 medium-6 large-4 columns end">
						<div
									class="callout fix_height" data-equalizer-watch
									style="box-shadow: 1px 4px 1px rgba(0, 0, 0, 0.3)">
									<div class="dark-grey">
							<a class="btn icon-btn btn-success"  href="../comptsimis/getCompDischargeInput">
							
										<span class="glyphicon btn-glyphicon glyphicon-plus img-circle text-success"></span>&nbsp;
										<h5 class="base" style="display: inline;">
											<b>Add Component Discharge</b>
										</h5>
									</a>
									</div>
								</div>
						</div>
						<div class="small-12 medium-6 large-4 columns end">
						<div
									class="callout fix_height" data-equalizer-watch
									style="box-shadow: 1px 4px 1px rgba(0, 0, 0, 0.3)">
									<div class="dark-grey">
							<a  class="btn icon-btn btn-primary" href="../comptsimis/deleteDischargeInput">
							
										<span class="glyphicon btn-glyphicon  glyphicon-edit img-circle text-primary"></span>&nbsp;
										<h5 class="base" style="display: inline;">
											<b>Edit/Delete  Discharge</b>
										</h5>
									</a>
									</div>
								</div>
						</div>
						
						<div class="small-12 medium-6 large-4 columns end">
						<div class="callout fix_height"
									data-equalizer-watch
									style="box-shadow: 1px 4px 1px rgba(0, 0, 0, 0.3)">
									<div class="dark-grey">
							<a  class="btn icon-btn btn-success" href="../comptsimis/ComponentPowerBill">
										<span class="glyphicon btn-glyphicon glyphicon-plus img-circle text-success"></span>&nbsp;
										<h5 class="base" style="display: inline;">
											<b>Component Power Bill</b>
										</h5>
									</a>
									</div>
								</div>
						</div>
						 <div class="small-12 medium-6 large-4 columns end">
						 
						 <div class="callout fix_height" data-equalizer-watch
									style="box-shadow: 1px 4px 1px rgba(0, 0, 0, 0.3)">
									<div class="dark-grey">
							<a  class="btn icon-btn btn-primary" href="../comptsimis/deleteCompPowerBill">
							
										<span class="glyphicon btn-glyphicon  glyphicon-edit img-circle text-primary"></span>&nbsp;
										<h5 class="base" style="display: inline;">
											<b>Delete/Edit Power Bill</b>
										</h5>
									</a></div>
								</div>
						</div> 
						
						<div class="small-12 medium-6 large-4 columns end">
						<div class="callout fix_height"
									data-equalizer-watch
									style="box-shadow: 1px 4px 1px rgba(0, 0, 0, 0.3)">
									<div class="dark-grey">
							<a  class="btn icon-btn btn-success" href="../comptsimis/compmonthlyayacut">
										<span class="glyphicon btn-glyphicon glyphicon-plus img-circle text-success"></span>&nbsp;
										<h5 class="base" style="display: inline;">
											<b>Component Ayacut</b>
										</h5>
									</a>
									</div>
								</div>
						</div>
						 <div class="small-12 medium-6 large-4 columns end">
						 
						 <div class="callout fix_height" data-equalizer-watch
									style="box-shadow: 1px 4px 1px rgba(0, 0, 0, 0.3)">
									<div class="dark-grey">
							<a  class="btn icon-btn btn-primary" href="../comptsimis/delCompMonAyacut">
							
										<span class="glyphicon btn-glyphicon  glyphicon-edit img-circle text-primary"></span>&nbsp;
										<h5 class="base" style="display: inline;">
											<b>Delete/Edit Ayacut</b>
										</h5>
									</a></div>
								</div>
						</div> 
						
						<!-- <div class="small-12 medium-6 large-4 columns end">
							<a href="../comptsimis/delCompMonAyacut"><div class="callout fix_height"
									data-equalizer-watch
									style="box-shadow: 1px 4px 1px rgba(0, 0, 0, 0.3)">
									<div class="dark-grey">
										<i class="fi-record" style="font-size: 26; display: inline"></i>&nbsp;
										<h5 class="base" style="display: inline;">
											<b>Delete/Edit Ayacut</b>
										</h5>
									</div>
								</div></a>
						</div> -->
					</div>
				</div>







			</div>

			<div class="row show-grid"></div>
		</form:form>

	</div>







</div>

<!-- //main-content -->
<script type="text/javascript" src="../js/parsley.js"></script>




