
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


<script>
	$(document)
			.ready(
					function() {

						$('#distCourt').hide();

						$('#unitId').multiselect({

							enableCaseInsensitiveFiltering : true

						});

						$('#projectId').multiselect({

							enableCaseInsensitiveFiltering : true

						});

						$('#packageId').multiselect({

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

						$('#courtId').multiselect({

							enableCaseInsensitiveFiltering : true

						});

						$('#courtdistrictId').multiselect({

							enableCaseInsensitiveFiltering : true

						});

						$('#caseTypeId').multiselect({

							enableCaseInsensitiveFiltering : true

						});

						$('#caseGenId').multiselect({

							enableCaseInsensitiveFiltering : true

						});

						$('#caseGenSubId').multiselect({

							enableCaseInsensitiveFiltering : true

						});

						$('#circleId').multiselect({

							enableCaseInsensitiveFiltering : true

						});

						$('#divisionId').multiselect({

							enableCaseInsensitiveFiltering : true

						});

						$('#subdivisionId').multiselect({

							enableCaseInsensitiveFiltering : true

						});

						$('#caseStageId').multiselect({

							enableCaseInsensitiveFiltering : true

						});

						$('#caseStatusId').multiselect({

							enableCaseInsensitiveFiltering : true

						});

						$('#petitionerId').multiselect({

							enableClickableOptGroups : true,
							enableCaseInsensitiveFiltering : true,
							enableCollapsibleOptGroups : false,
							includeSelectAllOption : true,
							disableIfEmpty : true

						});
						$('#petitionerAdvId').multiselect({

							enableClickableOptGroups : true,
							enableCaseInsensitiveFiltering : true,
							enableCollapsibleOptGroups : false,
							includeSelectAllOption : true,
							disableIfEmpty : true

						});

						$('#respondentId').multiselect({

							enableClickableOptGroups : true,
							enableCaseInsensitiveFiltering : true,
							enableCollapsibleOptGroups : false,
							includeSelectAllOption : true,
							disableIfEmpty : true

						});

						$('#respondentAdvId').multiselect({

							enableClickableOptGroups : true,
							enableCaseInsensitiveFiltering : true,
							enableCollapsibleOptGroups : false,
							includeSelectAllOption : true,
							disableIfEmpty : true

						});

						var z = 1;
						$('#adgwefryewry')
								.click(
										function() {

											var unitId = $("#unitId").val();
											var unitName = $('#unitId').find(
													"option:selected").text();
											var projectId = $("#projectId")
													.val();
											var projectName = $('#projectId')
													.find("option:selected")
													.text();
											var packageId = $("#packageId")
													.val();
											var packageName = $('#packageId')
													.find("option:selected")
													.text();
											var circleId = $("#circleId").val();
											var circleName = $('#circleId')
													.find("option:selected")
													.text();
											var packageId = $("#packageId")
													.val();
											var packageName = $('#packageId')
													.find("option:selected")
													.text();
											var divisionId = $("#divisionId")
													.val();
											var divisionName = $('#divisionId')
													.find("option:selected")
													.text();
											var subdivisionId = $(
													"#subdivisionId").val();
											var subdivisionName = $(
													'#subdivisionId').find(
													"option:selected").text();
											/*  var districtId =$("#districtId").val();
											 var districtName =$('#districtId').find("option:selected").text();
											 var mandalId =$("#mandalId").val();
											 var mandalName =$('#mandalId').find("option:selected").text();
											 var villageId =$("#villageId").val();
											 var villageName =$('#villageId').find("option:selected").text(); */
											var courtId = $("#courtId").val();
											var courtName = $('#courtId').find(
													"option:selected").text();
											var courtdistrictId = $(
													"#courtdistrictId").val();
											var courtdistrictName = $(
													'#courtdistrictId').find(
													"option:selected").text();
											var caseTypeId = $("#caseTypeId")
													.val();
											var caseType = $('#caseTypeId')
													.find("option:selected")
													.text();
											var caseWpNumber = $(
													"#caseWpNumber").val();

											var caseYear = $("#caseYear").val();

											var filingDate = $("#filingDate")
													.val();

											var caseStageId = $("#caseStageId")
													.val();
											var caseStageName = $(
													'#caseStageId').find(
													"option:selected").text();
											var caseGenId = $("#caseGenId")
													.val();
											var caseGeneral = $('#caseGenId')
													.find("option:selected")
													.text();
											var caseGenSubId = $(
													"#caseGenSubId").val();
											var caseGenSubName = $(
													'#caseGenSubId').find(
													"option:selected").text();
											var petitionerIdArray = $(
													"#petitionerId").val();
											var petitionerName = $(
													'#petitionerId').find(
													"option:selected").text();
											var petetionerAdvIdArray = $(
													"#petitionerAdvId").val();
											var petitionerAdvName = $(
													'#petitionerAdvId').find(
													"option:selected").text();
											var respondentIdArray = $(
													"#respondentId").val();
											var respondentName = $(
													'#respondentId').find(
													"option:selected").text();
											var respondentAdvIdArray = $(
													"#respondentAdvId").val();
											var respondentAdvName = $(
													'#respondentAdvId').find(
													"option:selected").text();
											var briefPrayer = $("#briefPrayer")
													.val();

											var remarks = $("#remarks").val();

											var caseStatusId = $(
													"#caseStatusId").val();
											var caseStatus = $('#caseStatusId')
													.find("option:selected")
													.text();

											var phoneNumber = $("#phoneNumber")
													.val();

											var contactPerson = $(
													"#contactPerson").val();

											var f = 1;

											var m = $('#caserow').children().length;
											var j = m + 1;

											//alert(ee);
											//alert(prj);

											var divid = "caseview" + j;
											var divrowid = "#" + divid;
											$('#caserow').append(
													$('<div/>').attr("id",
															divid).addClass(
															"row gridList"));
											$(
													'<div class="col-md-1  " >'
															+ j
															+ '<input type="hidden" class="form-control" name="casesList['+m+'].unitId" readonly="readonly" id="casesList'+m+'" value="'+unitId+'" /><input type="hidden" class="form-control" name="casesList['+m+'].projectId" readonly="readonly" id="casesList'+m+'" value="'+projectId+'" /></div>')
													.fadeIn('slow').appendTo(
															divrowid);

											$(
													'<div class="col-md-1 " id="sno'+j+'"  > <input type="hidden" class="form-control" name="casesList['+m+'].packageId" readonly="readonly" id="casesList'+m+'" value="'+packageId+'" /><input type="hidden" class="form-control" name="casesList['+m+'].circleId" readonly="readonly" id="casesList'+m+'" value="'+circleId+'" /> <input type="hidden" class="form-control" name="casesList['+m+'].divisionId" readonly="readonly" id="casesList'+m+'" value="'+divisionId+'" /> <input type="hidden" class="form-control" name="casesList['+m+'].subdivisionId" readonly="readonly" id="casesList'+m+'" value="'+subdivisionId+'" /> <input type="hidden" class="form-control" name="casesList['+m+'].courtId" readonly="readonly" id="casesList'+m+'" value="'+courtId+'" /> '
															+ ' '
															+ divisionName
															+ '   /'
															+ circleName
															+ ' /'
															+ packageName
															+ '</div>').fadeIn(
													'slow').appendTo(divrowid)

											$(
													'<div class="col-md-1 " id="sno'+j+'"  > <input type="hidden" class="form-control" name="casesList['+m+'].courtdistrictId" readonly="readonly" id="casesList'+m+'" value="'+courtdistrictId+'" /> <input type="hidden" class="form-control" name="casesList['+m+'].caseTypeId" readonly="readonly" id="casesList'+m+'" value="'+caseTypeId+'" /> <input type="hidden" class="form-control" name="casesList['+m+'].caseWpNumber" readonly="readonly" id="casesList'+m+'" value="'+caseWpNumber+'" /> '
															+ courtName
															+ '  /'
															+ courtdistrictName
															+ '  /'
															+ caseType
															+ '/'
															+ caseWpNumber
															+ '/' + '</div>')
													.fadeIn('slow').appendTo(
															divrowid)

											$(
													'<div class="col-md-1 " id="sno'+j+'"  > <input type="hidden" class="form-control" name="casesList['+m+'].caseYear" readonly="readonly" id="casesList'+m+'" value="'+caseYear+'" /> <input type="hidden" class="form-control" name="casesList['+m+'].filingDate" readonly="readonly" id="casesList'+m+'" value="'+filingDate+'" />  '
															+ caseYear
															+ ' /'
															+ filingDate
															+ '</div>').fadeIn(
													'slow').appendTo(divrowid)

											$(
													'<div class="col-md-1 " id="sno'+j+'"  > <input type="hidden" class="form-control" name="casesList['+m+'].caseGenId" readonly="readonly" id="casesList'+m+'" value="'+caseGenId+'" /> <input type="hidden" class="form-control" name="casesList['+m+'].caseStageId" readonly="readonly" id="casesList'+m+'" value="'+caseStageId+'" />  <input type="hidden" class="form-control" name="casesList['+m+'].caseGenSubId" readonly="readonly" id="casesList'+m+'" value="'+caseGenSubId+'" />   '
															+ caseGeneral
															+ ' /'
															+ caseGenSubName
															+ ' /'
															+ caseStageName
															+ '</div>').fadeIn(
													'slow').appendTo(divrowid)

											$(
													'<div class="col-md-1 " id="sno'+j+'"  > <input type="hidden" class="form-control" name="casesList['+m+'].petitionerIdArray" readonly="readonly" id="casesList'+m+'" value="'+petitionerIdArray+'" />  '
															+ petitionerName
															+ ',' + '</div>')
													.fadeIn('slow').appendTo(
															divrowid)
											$(
													'<div class="col-md-1 " id="sno'+j+'"  > <input type="hidden" class="form-control" name="casesList['+m+'].petetionerAdvIdArray" readonly="readonly" id="casesList'+m+'" value="'+petetionerAdvIdArray+'" />  '
															+ petitionerAdvName
															+ '</div>').fadeIn(
													'slow').appendTo(divrowid)
											$(
													'<div class="col-md-1 " id="sno'+j+'"  > <input type="hidden" class="form-control" name="casesList['+m+'].respondentIdArray" readonly="readonly" id="casesList'+m+'" value="'+respondentIdArray+'" />  '
															+ respondentName
															+ ',' + '</div>')
													.fadeIn('slow').appendTo(
															divrowid)
											$(
													'<div class="col-md-1 " id="sno'+j+'"  > <input type="hidden" class="form-control" name="casesList['+m+'].respondentAdvIdArray" readonly="readonly" id="casesList'+m+'" value="'+respondentAdvIdArray+'" />  '
															+ respondentAdvName
															+ '</div>').fadeIn(
													'slow').appendTo(divrowid)
											$(
													'<div class="col-md-1 " id="sno'+j+'"  > <input type="hidden" class="form-control" name="casesList['+m+'].briefPrayer" readonly="readonly" id="casesList'+m+'" value="'+briefPrayer+'" /> <input type="hidden" class="form-control" name="casesList['+m+'].remarks" readonly="readonly" id="casesList'+m+'" value="'+remarks+'" /> <input type="hidden" class="form-control" name="casesList['+m+'].caseStatusId" readonly="readonly" id="casesList'+m+'" value="'+caseStatusId+'" />  '
															+ briefPrayer
															+ ' /'
															+ caseStatus
															+ '</div>').fadeIn(
													'slow').appendTo(divrowid)

											$(
													'<div class="col-md-1 " id="sno'+j+'"  > <input type="hidden" class="form-control" name="casesList['+m+'].contactPerson" readonly="readonly" id="casesList'+m+'" value="'+contactPerson+'" /> <input type="hidden" class="form-control" name="casesList['+m+'].phoneNumber" readonly="readonly" id="casesList'+m+'" value="'+phoneNumber+'" /> '
															+ remarks
															+ ' /'
															+ contactPerson
															+ ' /'
															+ phoneNumber
															+ '</div>').fadeIn(
													'slow').appendTo(divrowid)

											$(
													'<div class="col-md-1 " ><input type="button" class=" form-control cusbtn cus-btn-lg btn-danger" name="del" id="casesList'
															+ j
															+ '"  value="Delete" onclick="deleteRow(this) "  /></div>')
													.fadeIn('slow').appendTo(
															divrowid);

											/*  if(j>=1){$("#submitAssignWork").show();} */
											j = parseInt(j) + 1;

										});

					});

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

				var obj = JSON.parse(response);

				var resproj = $('#selectedProj').val();

				$('#projectId')
						.append('<option value="0"> --select--</option>');

				$.each(obj, function(key, value) {
					//alert(resproj)

					if (resproj == value.projectId) {
						$('#projectId').append(
								'<option value="'+value.projectId+'" selected="selected"> '
										+ value.projectName + '</option>');
					}
					if (resproj == null||resproj==0) {

						$('#projectId').append(
								'<option value="'+value.projectId+'"> '
										+ value.projectName + '</option>');

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

	function getPackages() {

		var projectId = $('#projectId').val();

		//  alert("procId"+procId);
		$('#packageId').multiselect('rebuild');

		$.ajax({
			url : "../web/getPackages?projectId=" + projectId,
			type : "GET",
			success : function(response) {
				var $select = $('#packageId');
				$select.find('option').remove();

				var obj = JSON.parse(response);

				$('#packageId')
						.append('<option value="0"> --select--</option>');

				$.each(obj, function(key, value) {

					$('#packageId').append(
							'<option value="'+value.pkgId+'"> ' + value.pkgName
									+ '</option>');

					$('#packageId').multiselect('rebuild')

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

						$('#mandalId').append(
								'<option value="0"> --select--</option>');
						var obj = JSON.parse(response);
						$.each(obj, function(key, value) {

							$('#mandalId').append(
									'<option value="'+value.mandalId+'"  > '
											+ value.mandalName + '</option>');

							$('#mandalId').multiselect('rebuild');
						});

					},
					error : function() {
						alert(error);
					}
				});
	}

	function getVillages() {
		//alert("kal");
		//var districtId=document.getElementById("districtId").value;
		var mandalId = document.getElementById("mandalId").value;
		//alert(mandalId);

		$.ajax({
			url : "../web/getVillages?mandalId=" + mandalId,
			type : "GET",
			success : function(response) {

				var $select = $('#villageId');

				$select.find('option').remove();

				var obj = JSON.parse(response);
				$('#villageId')
						.append('<option value="0"> --select--</option>');

				$.each(obj, function(key, value) {

					$('#villageId').append(
							'<option value="'+value.villageId+'" > '
									+ value.villageName + '</option>');

					$('#villageId').multiselect('rebuild');
				});

			},
			error : function() {
				alert(error);
			}
		});
	}

	function getCircles() {
		//alert("kal");
		//var districtId=document.getElementById("districtId").value;
		var unitId = document.getElementById("unitId").value;
		//alert(mandalId);

		$
				.ajax({
					url : "../web/getCircles?unitId=" + unitId,
					type : "GET",
					success : function(response) {

						var $select = $('#circleId');

						$select.find('option').remove();

						var obj = JSON.parse(response);
						$('#circleId').append(
								'<option value="0"> --select--</option>');

						$.each(obj, function(key, value) {

							$('#circleId').append(
									'<option value="'+value.circleId+'" > '
											+ value.circleName + '</option>');

							$('#circleId').multiselect('rebuild');
						});

					},
					error : function() {
						alert(error);
					}
				});
	}

	function getDivisions() {
		//alert("kal");
		//var districtId=document.getElementById("districtId").value;
		var circleId = document.getElementById("circleId").value;
		//alert(mandalId);

		$.ajax({
			url : "../web/getDivisions?circleId=" + circleId,
			type : "GET",
			success : function(response) {

				var $select = $('#divisionId');

				$select.find('option').remove();

				var obj = JSON.parse(response);
				$('#divisionId').append(
						'<option value="0"> --select--</option>');

				$.each(obj, function(key, value) {

					$('#divisionId').append(
							'<option value="'+value.divisionId+'" > '
									+ value.divisionName + '</option>');

					$('#divisionId').multiselect('rebuild');
				});

			},
			error : function() {
				alert(error);
			}
		});
	}

	function getSubDivisions() {
		//alert("kal");
		//var districtId=document.getElementById("districtId").value;
		var divisionId = document.getElementById("divisionId").value;
		//alert(mandalId);

		$.ajax({
			url : "../web/getSubDivisions?divisionId=" + divisionId,
			type : "GET",
			success : function(response) {

				var $select = $('#subdivisionId');

				$select.find('option').remove();

				var obj = JSON.parse(response);
				$('#subdivisionId').append(
						'<option value="0"> --select--</option>');

				$.each(obj, function(key, value) {

					$('#subdivisionId').append(
							'<option value="'+value.subdivisionId+'" > '
									+ value.subdivisionName + '</option>');

					$('#subdivisionId').multiselect('rebuild');
				});

			},
			error : function() {
				alert(error);
			}
		});
	}

	function getCaseTypes() {
		//alert("kal");
		//var districtId=document.getElementById("districtId").value;
		var courtId = document.getElementById("courtId").value;
		//alert(mandalId);

		$.ajax({
			url : "../web/getCaseTypes?courtId=" + courtId,
			type : "GET",
			success : function(response) {

				var $select = $('#caseTypeId');

				$select.find('option').remove();

				var obj = JSON.parse(response);
				$('#caseTypeId').append(
						'<option value="0"> --select--</option>');

				$.each(obj, function(key, value) {

					$('#caseTypeId').append(
							'<option value="'+value.caseTypeId+'" > '
									+ value.caseType + '</option>');

					$('#caseTypeId').multiselect('rebuild');
				});

			},
			error : function() {
				alert(error);
			}
		});
	}

	function getCaseGenSub() {
		//alert("kal");
		//var districtId=document.getElementById("districtId").value;
		var caseGenId = document.getElementById("caseGenId").value;
		//alert(mandalId);

		$.ajax({
			url : "../web/getCaseGenSub?caseGenId=" + caseGenId,
			type : "GET",
			success : function(response) {

				var $select = $('#caseGenSubId');

				$select.find('option').remove();

				var obj = JSON.parse(response);
				$('#caseGenSubId').append(
						'<option value="0"> --select--</option>');

				$.each(obj, function(key, value) {

					$('#caseGenSubId').append(
							'<option value="'+value.caseGenSubId+'" > '
									+ value.caseGenSubName + '</option>');

					$('#caseGenSubId').multiselect('rebuild');
				});

			},
			error : function() {
				alert(error);
			}
		});
	}

	/* function loadaddpackform(){
		
		alert("kal is here")
		
		  $('#pack').attr('action', "../web/addPack");
	      $("#pack").submit();
	     
		
		
	} */

	function callcourt() {

		var cid = $('#courtId').val();

		if (parseInt(cid) == 3) {

			$('#distCourt').show();
		} else {

			$('#distCourt').hide();

		}

	}

	$(function() {

		var m = parseInt($("#unitId").val());
		if (parseInt(m) > 0) {

			getProjects();
			getCircles()

		} else {
			getProjects();
			getCircles()

		}

	});

	
</script>
<script>
    window.onunload = refreshParent;
    function refreshParent() {
    	
       window.opener.location.reload(true);
        self.close();
    }
</script>


<div class="w3_agile_main_left">


	<div class="col-md-12 agile_banner_bottom_grids">
		<div style="display: block; width: 100%; margin-left: 10px; margin-right: 10px;">

			<div class="resp-tabs-container">
				<div
					class="w3layouts_vertical_tab resp-tab-content resp-tab-content-active"
					style="display: block">






					<c:if test="${userObj!=null}">
						<div class="row-fluid  ">

							<div class="span6 pull-right">
								<p class="rowBlue">
									<c:out value="${userObj.employeeName}"></c:out>
								</p>
							</div>
						</div>
					</c:if>



					<div class="page">



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




						<div class="panel panel-primary ">
							<div class="panel-heading">
								<h3 class="panel-title">Add Package</h3>
							</div>
							<form:form id="pack" method="post" modelAttribute="pack"
								data-parsley-validate-if-empty="">
								<div class='container'>




									<div class="row col-md-12 toppad ">



                                       <div class="col-md-12">  
                                         <div class="col-md-3"></div>
										<div class="col-md-6">

											<div class="col-md-6">

												<label class="label-control rowlebel ">Package Name</label>
											</div>
											<div class="col-md-6">
												<input type="text" class="form-control" id="pkgName"
													name="pkgName" placeholder="pack Name" required />
											</div>
											
											<div class="col-md-6">
												<label class="label-controlPMS rowlebel ">Select
													Unit</label> 
													</div>
													
													<div class="col-md-6"><select class="form-control" id="unitId" name="unitId"
													onchange="getProjects();getCircles()">
													<option value="0">--select --</option>
													<c:forEach items="${unitList}" var="u">
														<c:choose>
															<c:when test="${u.unitId==selectedUnit }">
																<option value="${u.unitId}" selected="selected">${u.unitName}</option>
															</c:when>
															<c:otherwise>
																<option value="${u.unitId}">${u.unitName}</option>
															</c:otherwise>
														</c:choose>
													</c:forEach>


												</select>
											</div>
											
											<div class="col-md-6">
												<label class="label-controlPMS rowlebel ">Select
													Project</label> 
													</div>
												<div class="col-md-6">	
													<input type="hidden" class="form-control"
													id="selectedProj" name="selectedProjId"
													value="${selectedProject}" required /> <select
													class="form-control" id="projectId" name="projectId">
												</select>
											</div>
											
											<div class="col-md-6">
												<label class="label-controlPMS rowlebel ">Select
													Circle</label> 
													</div>
												<div class="col-md-6">	<select class="form-control" id="circleId"
													name="circleId" onchange="getDivisions()">



												</select>
											</div>
											
												<div class="col-md-6">
												<label class="label-controlPMS rowlebel ">Select
													Division</label>
													</div>
													<div class="col-md-6"> <select class="form-control" id="divisionId"
													name="divisionId" onchange="getSubDivisions()">



												</select>
											</div>
											
											

										</div>
										 <div class="col-md-3"></div>
										</div>

										
									</div>












									<div class="row show-grid">
									<div class="col-md-4"></div>
										<div class="col-md-4">
											<label class="label-control rowlebel "></label><input
												type="submit" class="btn btn-1 btn-primary center-block"
												id="addpack" value="Add Package">
												</div>
											
										
										<div class="col-md-4"></div>
									</div>







								</div>
								<!-- row -->

							</form:form>


						</div>


					</div>



					<!-- page -->
				</div>




				<!-- create component ends here -->


			</div>





		</div>
	</div>
</div>

<script type="text/javascript" src="../js/parsley.js"></script>



<script type="text/javascript" class="example">
	$(function() {
		$('#pack').parsley().on('field:validated', function() {
			var ok = $('.parsley-error').length === 0;

			// alert('hi');

		})

		.on('form:submit', function() {
			// alert("coming here");

			document.forms.pack.action = "../web/addPack";
			document.forms.pack.submit();

			// Don't submit form for this demo
		});
	});
</script>




<!-- //main-content -->
