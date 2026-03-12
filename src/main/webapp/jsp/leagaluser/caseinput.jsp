
<!--main code block-->
<!-- sec-section -->

<!-- caseinput start here -->
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

						$('#distCourtla').hide();
						$('#distCourtopt').hide();

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

					

					});

	function getProjects(unitId,hkey) {

		var unitId = unitId ;
			
			//$('#unitId').val();
	
		//  alert("procId"+procId);
		
		if(hkey==1){
		$('#projectId').multiselect('rebuild');
	}
		
		if(hkey==2){
		$('#dipackprojectId').multiselect('rebuild');
		}

		$.ajax({
			url : "../web/getProjects?unitId=" + unitId,
			type : "GET",
			success : function(response) {
				var $select = $('#projectId');
				$select.find('option').remove();

				var obj = JSON.parse(response);

				if(hkey==1){
				$('#projectId')
						.append('<option value="0"> --select--</option>');
				}
				
				if(hkey==2){
				$('#dipackprojectId')
				.append('<option value="0"> --select--</option>');
				}

				
				$.each(obj, function(key, value) {
					
					if(hkey==1){

					$('#projectId').append(
							'<option value="'+value.projectId+'"> '
									+ value.projectName + '</option>');

					$('#projectId').multiselect('rebuild')
					}
					if(hkey==2){
					$('#dipackprojectId').append(
							'<option value="'+value.projectId+'"> '
									+ value.projectName + '</option>');

					$('#dipackprojectId').multiselect('rebuild')
					}

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

	function getPackages(projectId) {

		var projectId =projectId ;
			
			//$('#projectId').val();

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

	function getMandals(districtId,hkey) {

		//alert("kal");

		var districtId = districtId ;
			//document.getElementById("dipetdistrictId").value;

		//alert(districtId);
		
		if(hkey==1){
			$('#dipetmandalId').multiselect('rebuild');
		}
			
			if(hkey==2){
			$('#resmandalId').multiselect('rebuild');
			}

		$
				.ajax({
					url : "../web/getMandals?districtId=" + districtId,
					type : "GET",
					success : function(response) {
						
						if(hkey==1){
							
							var $select = $('#dipetmandalId');
							$select.find('option').remove();
							$('#dipetmandalId').append(
							'<option value="0"> --select--</option>');
							}
							
							if(hkey==2){
								var $select = $('#resmandalId');
								$select.find('option').remove();
								$('#resmandalId').append(
								'<option value="0"> --select--</option>');
							}

						
						

					
						var obj = JSON.parse(response);
						$.each(obj, function(key, value) {
							if(hkey==1){
							$('#dipetmandalId').append(
									'<option value="'+value.mandalId+'"  > '
											+ value.mandalName + '</option>');

							$('#dipetmandalId').multiselect('rebuild');
							}
							
							if(hkey==2){
								$('#resmandalId').append(
										'<option value="'+value.mandalId+'"  > '
												+ value.mandalName + '</option>');

								$('#resmandalId').multiselect('rebuild');
								}
						});

					},
					error : function() {
						alert(error);
					}
				});
	}

	function getVillages(mandalId,hkey) {
		//alert("kal");
		//var districtId=document.getElementById("districtId").value;
		var mandalId =mandalId;
			//document.getElementById("mandalId").value;
		//alert(mandalId);
		
		if(hkey==1){
			$('#dipetvillageId').multiselect('rebuild');
		}
			
			if(hkey==2){
			$('#resvillageId').multiselect('rebuild');
			}


		$.ajax({
			url : "../web/getVillages?mandalId=" + mandalId,
			type : "GET",
			success : function(response) {
				
				
				if(hkey==1){
					var $select = $('#dipetvillageId');

					$select.find('option').remove();

					var obj = JSON.parse(response);
					$('#dipetvillageId')
							.append('<option value="0"> --select--</option>');
				}
					
					if(hkey==2){
						var $select = $('#resvillageId');

						$select.find('option').remove();

						var obj = JSON.parse(response);
						$('#resvillageId')
								.append('<option value="0"> --select--</option>');
					}

				

				$.each(obj, function(key, value) {
					if(hkey==1){
					$('#dipetvillageId').append(
							'<option value="'+value.villageId+'" > '
									+ value.villageName + '</option>');

					$('#dipetvillageId').multiselect('rebuild');
					}
					
					if(hkey==2){
						$('#resvillageId').append(
								'<option value="'+value.villageId+'" > '
										+ value.villageName + '</option>');

						$('#resvillageId').multiselect('rebuild');
						}
				});

			},
			error : function() {
				alert(error);
			}
		});
	}

	function getCircles(unitId,hkey) {
		//alert("kal");
		//var districtId=document.getElementById("districtId").value;
		var unitId = unitId ;
			//document.getElementById("unitId").value;
		//alert(mandalId);
		
		if(hkey==1){
			$('#circleId').multiselect('rebuild');
		}
			
			if(hkey==2){
			$('#dipackcircleId').multiselect('rebuild');
			}
			
			if(hkey==3){
				$('#rescircleId').multiselect('rebuild');
				}


		$
				.ajax({
					url : "../web/getCircles?unitId=" + unitId,
					type : "GET",
					success : function(response) {
						
						if(hkey==1){
							var $select = $('#circleId');
							$select.find('option').remove();
							$('#circleId').append(
									'<option value="0"> --select--</option>');
							}
							if(hkey==2){
								var $select = $('#dipackcircleId');
								$select.find('option').remove();
							$('#dipackcircleId').append(
							'<option value="0"> --select--</option>');
					}
							if(hkey==3){
								var $select = $('#rescircleId');
								$select.find('option').remove();
							$('#rescircleId').append(
							'<option value="0"> --select--</option>');
					}

					

					

						var obj = JSON.parse(response);
						
						

						$.each(obj, function(key, value) {
							if(hkey==1){
							$('#circleId').append(
									'<option value="'+value.circleId+'" > '
											+ value.circleName + '</option>');

							$('#circleId').multiselect('rebuild');
							
							}
							if(hkey==2){
								$('#dipackcircleId').append(
										'<option value="'+value.circleId+'" > '
												+ value.circleName + '</option>');

								$('#dipackcircleId').multiselect('rebuild');
								
								}
							
							if(hkey==3){
								$('#rescircleId').append(
										'<option value="'+value.circleId+'" > '
												+ value.circleName + '</option>');

								$('#rescircleId').multiselect('rebuild');
								
								}
						});

					},
					error : function() {
						alert(error);
					}
				});
	}

	function getDivisions(circleId,hkey) {
		//alert("kal");
		//var districtId=document.getElementById("districtId").value;
		var circleId =circleId ;
			//document.getElementById("circleId").value;
		//alert(mandalId);
		

		if(hkey==1){
			$('#divisionId').multiselect('rebuild');
		}
			
			if(hkey==2){
			$('#dipackdivisionId').multiselect('rebuild');
			}
			
			if(hkey==3){
				$('#resdivisionId').multiselect('rebuild');
				}


		$.ajax({
			url : "../web/getDivisions?circleId=" + circleId,
			type : "GET",
			success : function(response) {
				if(hkey==1){
				var $select = $('#divisionId');
				$select.find('option').remove();
				$('#divisionId').append(
				'<option value="0"> --select--</option>');
				}
				if(hkey==2){
					var $select = $('#dipackdivisionId');
					$select.find('option').remove();
					$('#dipackdivisionId').append(
					'<option value="0"> --select--</option>');
					}
				
				if(hkey==2){
					var $select = $('#resdivisionId');
					$select.find('option').remove();
					$('#resdivisionId').append(
					'<option value="0"> --select--</option>');
					}


				

				var obj = JSON.parse(response);
				
				

				$.each(obj, function(key, value) {
					if(hkey==1){
					$('#divisionId').append(
							'<option value="'+value.divisionId+'" > '
									+ value.divisionName + '</option>');

					$('#divisionId').multiselect('rebuild');
					}
					if(hkey==2){
						$('#dipackdivisionId').append(
								'<option value="'+value.divisionId+'" > '
										+ value.divisionName + '</option>');

						$('#dipackdivisionId').multiselect('rebuild');
						}
					
					if(hkey==3){
						$('#resdivisionId').append(
								'<option value="'+value.divisionId+'" > '
										+ value.divisionName + '</option>');

						$('#resdivisionId').multiselect('rebuild');
						}
				});

			},
			error : function() {
				alert(error);
			}
		});
	}

	function getSubDivisions(divisionId,hkey) {
		//alert("kal");
		//var districtId=document.getElementById("districtId").value;
		var divisionId = divisionId ;
			
			//document.getElementById("divisionId").value;
		//alert(mandalId);
		
		if(hkey==1){
			$('#subdivisionId').multiselect('rebuild');
		}
			
			if(hkey==2){
			$('#dipacksubdivisionId').multiselect('rebuild');
			}
			
			if(hkey==2){
				$('#ressubdivisionId').multiselect('rebuild');
				}
				
			

		$.ajax({
			url : "../web/getSubDivisions?divisionId=" + divisionId,
			type : "GET",
			success : function(response) {

				
				if(hkey==1){
				var $select = $('#subdivisionId');

				$select.find('option').remove();

				
				$('#subdivisionId').append(
						'<option value="0"> --select--</option>');
				
				}
				
				if(hkey==2){
					var $select = $('#dipacksubdivisionId');

					$select.find('option').remove();

					
					$('#dipacksubdivisionId').append(
							'<option value="0"> --select--</option>');
					
					}
				
				if(hkey==3){
					var $select = $('#ressubdivisionId');

					$select.find('option').remove();

					
					$('#ressubdivisionId').append(
							'<option value="0"> --select--</option>');
					
					}
				var obj = JSON.parse(response);

				$.each(obj, function(key, value) {
					if(hkey==1){
					$('#subdivisionId').append(
							'<option value="'+value.subdivisionId+'" > '
									+ value.subdivisionName + '</option>');

					$('#subdivisionId').multiselect('rebuild');
					}
					
					if(hkey==2){
						$('#dipacksubdivisionId').append(
								'<option value="'+value.subdivisionId+'" > '
										+ value.subdivisionName + '</option>');

						$('#dipacksubdivisionId').multiselect('rebuild');
						}
					
					if(hkey==3){
						$('#ressubdivisionId').append(
								'<option value="'+value.subdivisionId+'" > '
										+ value.subdivisionName + '</option>');

						$('#ressubdivisionId').multiselect('rebuild');
						}
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
	
	function getPetList(petId) {
		//alert("kal");
		//var districtId=document.getElementById("districtId").value;
		
		//alert("petId"+petId);	
			//document.getElementById("divisionId").value;
		//alert(mandalId);

		$.ajax({
			url : "../web/getPetList?petitionerId="+petId ,
			type : "GET",
			success : function(response) {

				var $select = $('#petitionerId');

				
			//	console.log(response);
				
				var obj = JSON.parse(response);
			  // alert(obj.petitionerId);

			//	
			

				//$.each(obj, function(key, value) {

					$('#petitionerId').append(
							'<option value="'+obj.petitionerId+'" > '
									+ obj.petitionerName + '</option>');

					$('#petitionerId').multiselect('rebuild');
				//});

			},
			error : function() {
				alert(error);
			}
		});
	}
	
	
	function getPetAdvList(petAdvId) {
		//alert("kal");
		//var districtId=document.getElementById("districtId").value;
		
		//alert("petId"+petId);	
			//document.getElementById("divisionId").value;
		//alert(mandalId);

		$.ajax({
			url : "../web/getPetAdvList?petitionerAdvId="+petAdvId ,
			type : "GET",
			success : function(response) {
				
				//alert(response);

				var $select = $('#petitionerAdvId');

				
				console.log(response);
				
				var obj = JSON.parse(response);
			  // alert(obj.petitionerId);

			//	
			

				//$.each(obj, function(key, value) {

					$('#petitionerAdvId').append(
							'<option value="'+obj.petitionerAdvId+'" > '
									+ obj.petitionerAdvName + '</option>');

					$('#petitionerAdvId').multiselect('rebuild');
				//});

			},
			error : function() {
				alert(error);
			}
		});
	}
	
	function getResList(resId) {
		//alert("kal");
		//var districtId=document.getElementById("districtId").value;
		
		//alert("petId"+petId);	
			//document.getElementById("divisionId").value;
		//alert(mandalId);

		$.ajax({
			url : "../web/getResList?resId="+resId ,
			type : "GET",
			success : function(response) {
				
				//alert(response);

				var $select = $('#respondentId');

				
				console.log(response);
				
				var obj = JSON.parse(response);
			  // alert(obj.petitionerId);

			//	
			

				//$.each(obj, function(key, value) {

					$('#respondentId').append(
							'<option value="'+obj.respondentId+'" > '
									+ obj.respondentName + '</option>');

					$('#respondentId').multiselect('rebuild');
				//});

			},
			error : function() {
				alert(error);
			}
		});
	}

	
	function getResAdvList(resAdvId) {
		//alert("kal");
		//var districtId=document.getElementById("districtId").value;
		
		//alert("petId"+petId);	
			//document.getElementById("divisionId").value;
		//alert(mandalId);

		$.ajax({
			url : "../web/getResAdvList?resAdvId="+resAdvId ,
			type : "GET",
			success : function(response) {
				
				//alert(response);

				var $select = $('#respondentAdvId');

				
				console.log(response);
				
				var obj = JSON.parse(response);
			  // alert(obj.petitionerId);

			//	
			

				//$.each(obj, function(key, value) {

					$('#respondentAdvId').append(
							'<option value="'+obj.respondentAdvId+'" > '
									+ obj.respondentAdvName + '</option>');

					$('#respondentAdvId').multiselect('rebuild');
				//});

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

	/* function loadcaseinputform(){
		
		alert("kal is here")
		
		  $('#caseinput1').attr('action', "../web/caseinput");
	      $("#caseinput1").submit();
	     
		
		
	} */

	function callcourt() {

		var cid = $('#courtId').val();

		if (parseInt(cid) == 3) {

			$('#distCourtla').show();
			$('#distCourtopt').show();
		} else {

			$('#distCourtla').hide();
			$('#distCourtopt').hide();

		}

	}

	/* function addPet() {
		var features = "width=500,height=300,menubar=no,status=no,location=no,toolbar=no,scrollbars=yes,top=100,left=50";
		var url = "../web/addPet";

		popup = window.open(url, "_blank", features);
	}
 */
	/* function addPetAdv() {
		var features = "width=500,height=300,menubar=no,status=no,location=no,toolbar=no,scrollbars=yes,top=100,left=50";
		var url = "../web/addPetAdv";

		popup = window.open(url, "_blank", features);
	}
 */
	/*  function addRes() {
		var features = "width=500,height=300,menubar=no,status=no,location=no,toolbar=no,scrollbars=yes,top=100,left=50";
		var url = "../web/addRes";

		popup = window.open(url, "_blank", features);
	} 

	function addResAdv() {
		var features = "width=500,height=300,menubar=no,status=no,location=no,toolbar=no,scrollbars=yes,top=100,left=50";
		var url = "../web/addResAdv";

		popup = window.open(url, "_blank", features);
	} */

	/* function addPack() {
		var unit = $('#unitId').val();
		var proj = $('#projectId').val();
		if(unit==null || unit==''){
			alert("unit"+unit);
			unit=0;
		}
		if(proj==null||proj==' '){
			alert("proj"+proj);
			proj=0;
		}
		var features = "width=500,height=300,menubar=no,status=no,location=no,toolbar=no,scrollbars=yes,top=100,left=50";
		var url = "../web/addPack?unitId=" + unit + "&projectId=" + proj;

		popup = window.open(url, "_blank", features);
	}
 */
	function addCaseType() {
		var features = "width=500,height=300,menubar=no,status=no,location=no,toolbar=no,scrollbars=yes,top=100,left=50";
		var url = "../web/addCaseType";

		popup = window.open(url, "_blank", features);
	}

	function addCaseGen() {
		var features = "width=500,height=300,menubar=no,status=no,location=no,toolbar=no,scrollbars=yes,top=100,left=50";
		var url = "../web/addCaseGen";

		popup = window.open(url, "_blank", features);
	}

	function addCaseGenSub() {
		var features = "width=500,height=300,menubar=no,status=no,location=no,toolbar=no,scrollbars=yes,top=100,left=50";
		var url = "../web/addCaseGenSub";

		popup = window.open(url, "_blank", features);
	}

	$(function() {

		$("#filingDate").datepicker({
			changeYear : true,
			changeMonth : true,
			dateFormat : "dd/mm/yy",
		/*  onSelect: function(selected) {
		   $("#month").datepicker("option","minDate", selected)
		 } */
		});

		$("#counterDate").datepicker({
			changeYear : true,
			changeMonth : true,
			dateFormat : "dd/mm/yy",
		/*  onSelect: function(selected) {
		   $("#month").datepicker("option","minDate", selected)
		 } */
		});

		$("#judgementDate").datepicker({
			changeYear : true,
			changeMonth : true,
			dateFormat : "dd/mm/yy",
		/*  onSelect: function(selected) {
		   $("#month").datepicker("option","minDate", selected)
		 } */
		});

		$("#draftdateconttoGP").datepicker({
			changeYear : true,
			changeMonth : true,
			dateFormat : "dd/mm/yy",
		/*  onSelect: function(selected) {
		   $("#month").datepicker("option","minDate", selected)
		 } */
		});
		
		 $('#pack_dialogue').dialog({
			  autoOpen:false,
			  width:400
			 });
		 
		 $('#pet_dialogue').dialog({
			  autoOpen:false,
			  width:500
			 });
		 
		 
		 $('#petadv_dialogue').dialog({
			  autoOpen:false,
			  width:500
			 });
		 
		 $('#res_dialogue').dialog({
			  autoOpen:false,
			  width:500
			 });
		 
		 $('#resadv_dialogue').dialog({
			  autoOpen:false,
			  width:500
			 });
		 
		 
		 
		 
		 
		 
		 
		 $('#addnewpack').click(function(){
		
		  $('#pack_dialogue').dialog('option', 'title', 'Add Package');
		  $('#pack_dialogue').dialog('open');
		 });
		 
		 $('#addpack').click(function(){
			 
				// alert("kal1");
				 
				 $('#action_alert').empty();
				 
			var pkgName= $('#dipackpkgName').val(); 
			var unitId=$('#dipackunitId').val(); 
			var circleId=$('#dipackcircleId').val(); 
			var divisionId=$('#dipackdivisionId').val();
			var projectId=$('#dipackprojectId').val();
			
			//alert(finyear+"kals"+actionTitle+"kala"+ paraNumber+"kalr"+cagGistId);
			
			  $.ajax({	          
			      url: "../web/addPack",
			      method:"POST",
			      async: false,
			      data: {
			    	  pkgName: pkgName,
			    	  unitId :unitId,
			    	  circleId :circleId,
			    	  divisionId:divisionId,
			    	  projectId:projectId
			    	  
			      },
			     
				 
			      success: function (response) {
			   
			    	// alert("kal"+response);
			    	 
			    	 if(response>0){
					    	
				    	 $('#pack_dialogue').dialog('close'); 
		    	 
		    	  $('#action_alert').html('<p>Data Updated Successfully</p>');
				    }
				    if(response==0){
				    	
				    	  $('#action_alert').html('<p>Failed to Update data</p>');
				    }
			    	 
			    	 //  alert(finYear);
					    getPackages(projectId);
					    
					    
					  //  $('#action_alert').dialog('open'); 
					  
					   // getunitData(unitId,circleId,divisionId) ;
					  

			      },
			      
			      error : function(){
			    	 alert(error);
			    
			      }
			
			  
			  }); 	
				 
				 
				 
			 });
		 
		 $('#addpetetioner').click(function(){
				
			  $('#pet_dialogue').dialog('option', 'title', 'Add Petitioner');
			  $('#pet_dialogue').dialog('open');
			 });
		 
		 
		 
		 
		 $('#addpet').click(function(){
			 
				// alert("kal1");
				 
				 $('#action_alert').empty();
				 
			var petitionerName= $('#petitionerName').val(); 
			var petitionerAddress=$('#petitionerAddress').val(); 
			var districtId=$('#dipetdistrictId').val(); 
			var mandalId=$('#dipetmandalId').val();
			var villageId=$('#dipetvillageId').val();
			
			//alert(finyear+"kals"+actionTitle+"kala"+ paraNumber+"kalr"+cagGistId);
			
			  $.ajax({	          
			      url: "../web/addPet",
			      method:"POST",
			      async: false,
			      data: {
			    	  petitionerName: petitionerName,
			    	  petitionerAddress :petitionerAddress,
			    	  districtId :districtId,
			    	  mandalId:mandalId,
			    	  villageId:villageId
			    	  
			      },
			     
				 
			      success: function (response) {
			   
			    	// alert("kal"+response);
			    	 
			    	 var idval=parseInt(response);
			    	 
			    	 if(idval>0){
					    	
				    	 $('#pet_dialogue').dialog('close'); 
				    	 
				    	 getPetList(idval);
		    	 
		    	  $('#action_alert').html('<p>Data Updated Successfully</p>');
				    }
				    if(response==0){
				    	
				    	  $('#action_alert').html('<p>Failed to Update data</p>');
				    }
			    	 
			    	 //  alert(finYear);
					  
					    
					    
					  //  $('#action_alert').dialog('open'); 
					  
					   // getunitData(unitId,circleId,divisionId) ;
					  

			      },
			      
			      error : function(){
			    	 alert(error);
			    
			      }
			
			  
			  }); 	
				 
				 
				 
			 });
		 
		 $('#addpetetionerAdvId').click(function(){
				
			  $('#petadv_dialogue').dialog('option', 'title', 'Add Petitioner Advocate Details');
			  $('#petadv_dialogue').dialog('open');
			 });
		 
		 $('#addrespondentId').click(function(){
				
			  $('#res_dialogue').dialog('option', 'title', 'Add Respondent Details');
			  $('#res_dialogue').dialog('open');
			 });
		 
		 
		 $('#addrespondentAdvId').click(function(){
				
			  $('#resadv_dialogue').dialog('option', 'title', 'Add Respondent Advocate Details');
			  $('#resadv_dialogue').dialog('open');
			 });
		 
		 
		 
		 
		 
		 
		 
		 $('#addpetAdv').click(function(){
			 
				// alert("kal1");
				 
				 $('#action_alert').empty();
				 
			var petitionerAdvName= $('#petitionerAdvName').val(); 
			var petitionerAdvAddress=$('#petitionerAdvAddress').val(); 
			
			
			
			
			  $.ajax({	          
			      url: "../web/addPetAdv",
			      method:"POST",
			      async: false,
			      data: {
			    	  petitionerAdvName: petitionerAdvName,
			    	  petitionerAdvAddress :petitionerAdvAddress
			    	  
			    	  
			      },
			     
				 
			      success: function (response) {
			   
			    	// alert("kal"+response);
			    	 
			    	 var idval=parseInt(response);
			    	 
			    	 if(idval>0){
					    	
				    	 $('#petadv_dialogue').dialog('close'); 
				    	 
				    	 getPetAdvList(idval);
		    	 
		    	  $('#action_alert').html('<p>Data Updated Successfully</p>');
				    }
				    if(response==0){
				    	
				    	  $('#action_alert').html('<p>Failed to Update data</p>');
				    }
			    	 
			    	 //  alert(finYear);
					  
					    
					    
					  //  $('#action_alert').dialog('open'); 
					  
					   // getunitData(unitId,circleId,divisionId) ;
					  

			      },
			      
			      error : function(){
			    	 alert(error);
			    
			      }
			
			  
			  }); 	
				 
				 
				 
			 });
		 
		 
		 
		 $('#addres').click(function(e){
			 
				// alert("kal1");
				 
				 $('#action_alert').empty();
				 
				 e.preventDefault(); //=== To Avoid Page Refresh and Fire the Event "Click"===
		
			
			  if ( $('form[name=respondentform]').parsley().isValid() ) {
			
			
			  $.ajax({	          
			      url: "../web/addRes",
			      method:"POST",
			      async: false,
			      data:$('form[name=respondentform]').serialize(),
			     
				 
			      success: function (response) {
			   
			    	// alert("kal"+response);
			    	 
			    	 var idval=parseInt(response);
			    	 
			    	 if(idval>0){
					    	
				    	 $('#res_dialogue').dialog('close'); 
				    	 
				    	getResList(idval);
		    	 
		    	  $('#action_alert').html('<p>Data Updated Successfully</p>');
				    }
				    if(response==0){
				    	
				    	  $('#action_alert').html('<p>Failed to Update data</p>');
				    }
			    	 
			    	 //  alert(finYear);
					  
					    
					    
					  //  $('#action_alert').dialog('open'); 
					  
					   // getunitData(unitId,circleId,divisionId) ;
					  

			      },
			      
			      error : function(){
			    	 alert(error);
			    
			      }
			
			  
			  }); 	
			  
			  }
				 
				 
				 
			 });
		 
		 $('#addresadv').click(function(e){
			 
				// alert("kal1");
				 
				 $('#action_alert').empty();
				 
				 e.preventDefault(); //=== To Avoid Page Refresh and Fire the Event "Click"===
		
			
			  if ( $('form[name=respondentadvform]').parsley().isValid() ) {
			
			
			  $.ajax({	          
			      url: "../web/addResAdv",
			      method:"POST",
			      async: false,
			      data:$('form[name=respondentadvform]').serialize(),
			     
				 
			      success: function (response) {
			   
			    	//alert("kal"+response);
			    	 
			    	 var idval=parseInt(response);
			    	 
			    	 if(idval>0){
					    	
				    	 $('#resadv_dialogue').dialog('close'); 
				    	 
				    	getResAdvList(idval);
		    	 
		    	  $('#action_alert').html('<p>Data Updated Successfully</p>');
				    }
				    if(response==0){
				    	
				    	  $('#action_alert').html('<p>Failed to Update data</p>');
				    }
			    	 
			    	 //  alert(finYear);
					  
					    
					    
					  //  $('#action_alert').dialog('open'); 
					  
					   // getunitData(unitId,circleId,divisionId) ;
					  

			      },
			      
			      error : function(){
			    	 alert(error);
			    
			      }
			
			  
			  }); 	
			  
			  }
				 
				 
				 
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
	<div id="action_alert" title="Action">

  </div>
  






<c:if test="${msg1!=null || err1!=null }">


	<div class="row show-grid">
		<c:if test="${msg1!=null}">
			<div class="alert alert-success" role="alert">
				<strong></strong>
				<c:out value="${msg1}"></c:out>
				/
				<c:out value="${msg2}"></c:out>
				/
				<c:out value="${msg3}"></c:out>
				/
				<c:out value="${msg4}"></c:out>
				/
				<c:out value="${msg5}"></c:out>
				/
				<c:out value="${msg6}"></c:out>
			</div>

		</c:if>

		<c:if test="${err1!=null}">
			<div class="alert alert-danger" role="alert">
				<strong></strong>
				<c:out value="${err1}"></c:out>
				/
				<c:out value="${err2}"></c:out>
				/
				<c:out value="${err3}"></c:out>
				/
				<c:out value="${err4}"></c:out>
				/
				<c:out value="${err5}"></c:out>
				/
				<c:out value="${err6}"></c:out>
				/
				<c:out value="${err7}"></c:out>
			</div>

		</c:if>

	</div>
</c:if>






<div class="w3l-main" id="borderStyle">











	<div class="panel panel-primary ">
		<div class="panel-heading">
			<h3 class="panel-title">Case Input</h3>
		</div>
		<form:form id="caseinput1" method="post" modelAttribute="cases"
			data-parsley-validate-if-empty="">






			<div class="col-md-12">
				<div class="col-md-6">
				
					<div class="row">
					<div class="col-md-3">
						<label class="label-controlPMS rowlebel ">Select Unit *</label>
					</div>
					<div class="col-md-3"></div>
					<div class="col-md-6">
						<select class="form-control" id="unitId" name="unitId"
							onchange="getProjects(this.value,1);getCircles(this.value,1)" required>
							<option value="0">--select --</option>
							<c:forEach items="${unitList}" var="u">
								<option value="${u.unitId}">${u.unitName}</option>

							</c:forEach>


						</select>
					</div>
					
					
					</div>
					
						<div class="row">
					<div class="col-md-3">
						<label class="label-controlPMS rowlebel ">Select Project</label>
					</div>
					<div class="col-md-3"></div>
					
					<div class="col-md-6">
						<select class="form-control" id="projectId" name="projectId"
							onchange="getPackages(this.value)">
						</select>
					</div>
					
					
					</div>
<div class="row">
					<div class="col-md-3">
						<label class="label-controlPMS rowlebel ">Select Package</label>
					</div>
					<div class="col-md-3">

						<input
							type="button" class="btn btn-1 btn-primary center-block"
							id="addnewpack" value="Add Package" >
							
							<!-- onclick="addPack()" -->

					</div>
					<div class="col-md-6">
						<select class="form-control" id="packageId" name="packageId">




						</select>


					</div>
					
					
					</div>

	<div class="row">
					<div class="col-md-3">
						<label class="label-controlPMS rowlebel ">Select Circle</label>
					</div>
					<div class="col-md-3"></div>
					<div class="col-md-6">
						<select class="form-control" id="circleId" name="circleId"
							onchange="getDivisions(this.value,1)">


						</select>
		</div>	
				
		
		</div>
		
		<div class="row">

					<div class="col-md-3">
						<label class="label-controlPMS rowlebel ">Select Division</label>
					</div>
					<div class="col-md-3"></div>
					<div class="col-md-6">
						<select class="form-control" id="divisionId" name="divisionId"
							onchange="getSubDivisions(this.value,1)">

						</select>
					</div>
					</div>
	<div class="row">
					<div class="col-md-6">
						<label class="label-controlPMS rowlebel ">Select
							SubDivision</label>
					</div>
						<div class="col-md-3"></div>
					<div class="col-md-6">
						<select class="form-control" id="subdivisionId"
							name="subdivisionId">
							<option value="0">--select--</option>



						</select>
					</div>
					</div>
					
					<div class="row">
					<div class="col-md-3">

						<label class="label-control rowlebel ">Select Petitioner*</label>
					</div>
					<div class="col-md-3 ">
					<input
							type="button" class="btn btn-1 btn-primary center-block"
							id="addpetetioner" value="Add Petitioner" >
					</div>
<!-- onclick="addPet()" -->

					<div class="col-md-3">
						<select class="form-control" id="petitionerId"
							name="petitionerIdArray" multiple="multiple" required>

							 <c:forEach items="${petList}" var="p">
								<option value="${p.petitionerId}">${p.petitionerName}</option>

							</c:forEach> 


						</select>

					</div>
					
						<div class="col-md-3 ">
					<label class="label-control rowlebel ">Others Petitioner</label>
						<input type="text" class="form-control" id="petOthers" value="0"
							name="petOthers" data-parsley-trigger="keyup"
							data-parsley-type="number">
					</div>
					
					</div>
					

	<div class="row">
					<div class="col-md-3">

						<label class="label-control rowlebel ">Select Petitioner
							Advocate* </label>
					</div>
					<div class="col-md-3 ">
					<input
							type="button" class="btn btn-1 btn-primary center-block"
							id="addpetetionerAdvId" value="Add Petitioner Advocate"
							>
					</div>
					<div class="col-md-3">
						<select class="form-control" id="petitionerAdvId"
							name="petetionerAdvIdArray" multiple="multiple" required>

							<c:forEach items="${petAdvList}" var="p">
								<option value="${p.petitionerAdvId}">${p.petitionerAdvName}</option>

							</c:forEach>



						</select>

					</div>
				
						
				
						
				
					</div>
					
						
<div class="row">
					<div class="col-md-3">

						<label class="label-control rowlebel ">Select Respondent*</label>
					</div>
					
					<div class="col-md-3 ">
						<input
							type="button" class="btn btn-1 btn-primary center-block"
							id="addrespondentId" value="Add Respondent" >
					</div>
					<div class="col-md-3">
						<select class="form-control" id="respondentId"
							name="respondentIdArray" multiple="multiple" required>

							<c:forEach items="${resList}" var="p">
								<option value="${p.respondentId}">${p.respondentName}</option>

							</c:forEach>



						</select>

					</div>
					
					<div class="col-md-3">
						<label class="label-control rowlebel ">Others Respondent</label>
					
						<input type="text" class="form-control" id="resOthers" value="0"
							name="resOthers" data-parsley-trigger="keyup"
							data-parsley-type="number">
					</div>
					




					
					
					</div>
					
					<div class="row">

					<div class="col-md-3">

						<label class="label-control rowlebel ">Select Respondent
							Advocate* </label>
					</div>
					<div class="col-md-3">
						<input
							type="button" class="btn btn-1 btn-primary center-block"
							id="addrespondentAdvId" value="Add Respondent Advocate"
							>
					</div>
					<div class="col-md-6">
						<select class="form-control" id="respondentAdvId"
							name="respondentAdvIdArray" multiple="multiple" required>

							<c:forEach items="${resAdvList}" var="p">
								<option value="${p.respondentAdvId}">${p.respondentAdvName}</option>

							</c:forEach>

						</select>

					</div>
					
					</div>

					

						<div class="row">
					<div class="col-md-3">
						<label class="label-control rowlebel ">Select Court*</label>
					</div>
					<div class="col-md-3"></div>	
					<div class="col-md-3">
						<select class="form-control" id="courtId" name="courtId"
							onchange="getCaseTypes();callcourt()" required>
							<option value="0">--select--</option>
							<c:forEach items="${courtList}" var="u">
								<option value="${u.courtId}">${u.courtName}</option>

							</c:forEach>

						</select>


					</div>
					
					<!-- <div class="col-md-3" id="distCourtla">
					
					</div> -->
					<div class="col-md-3" id="distCourtopt">
						<label class="label-control rowlebel ">District Court</label>
						<select class="form-control" id="courtdistrictId"
							name="courtdistrictId">

							<c:forEach items="${districtList}" var="p">
								<option value="${p.districtId}">${p.districtName}</option>

							</c:forEach>


						</select>
					</div>
					</div>

	
					
					
<div class="row">
					<div class="col-md-3">
						<label class="label-control rowlebel ">Select Case Type*</label>
					</div>
					<div class="col-md-3">

					<!-- 	<input
							type="button" class="btn btn-1 btn-primary center-block"
							id="addCaseTypeId" value="Add Case Type" onclick="addCaseType()"> -->

					</div>
					<div class="col-md-3">
						<select class="form-control" id="caseTypeId" name="caseTypeId"
							required>


						</select>



					</div>
					
					</div>
					
<div class="row">
					<div class="col-md-3">
						<label class="label-controlPMS rowlebel ">Select Case
							Category*</label>
					</div>
					<div class="col-md-3">
				<!-- 		<input
							type="button" class="btn btn-1 btn-primary center-block"
							id="addCaseGenId" value="Add Case Category"
							onclick="addCaseGen()"> -->
					</div>
					<div class="col-md-6">
						<select class="form-control" id="caseGenId" name="caseGenId"
							onchange="getCaseGenSub()" required>

							<option value="0">--select--</option>
							<c:forEach items="${caseGenList}" var="p">
								<option value="${p.caseGenId}">${p.caseGeneral}</option>

							</c:forEach>


						</select>
					</div>
					
					</div>

				<div class="row">	

					<div class="col-md-3">
						<label class="label-controlPMS rowlebel ">Select Case Sub
							Category*</label>
					</div>
						<div class="col-md-3">
					<!-- 	<input
							type="button" class="btn btn-1 btn-primary center-block"
							id="addCasesGenSub" value="Add Case Sub Category"
							onclick="addCaseGenSub()"> -->
					</div>
					<div class="col-md-6">
						<select class="form-control" id="caseGenSubId" name="caseGenSubId"
							required>



						</select>
					</div>
					
					</div>

				
				
				<div class="row">		
					<div class="col-md-3">
						<label class="label-control rowlebel ">Select Stages *</label>
					</div>
					<div class="col-md-3"></div>
					<div class="col-md-6">
						<select class="form-control" id="caseStageId" name="caseStageId"
							required>

							<c:forEach items="${caseStageList}" var="p">
								<option value="${p.caseStageId}">${p.caseStageName}</option>

							</c:forEach>


						</select>

					</div>
					</div>
					
					


					




				</div>
				<div class="col-md-6">
				
					<div class="row">	

					<div class="col-md-3">
						<label class="label-control rowlebel ">Select Status *</label>
					</div>
					<div class="col-md-3"></div>
					<div class="col-md-6">
						<select class="form-control" id="caseStatusId" name="caseStatusId"
							required>

							<c:forEach items="${caseStatusList}" var="p">
								<option value="${p.caseStatusId}">${p.caseStatus}</option>

							</c:forEach>

						</select>
					</div>
					
					</div>


					<div class="row">	
					<div class="col-md-3">

						<label class="label-control rowlebel ">Case Number*</label>
					</div>
					<div class="col-md-3"></div>
					<div class="col-md-6">
						<input type="text" class="form-control" id="caseWpNumber"
							name="caseWpNumber" placeholder="2324" required />
					</div>
</div>
<div class="row">
					<div class="col-md-3">

						<label class="label-control rowlebel ">Case Year*</label>
					</div>
					<div class="col-md-3"></div>
					<div class="col-md-6">
						<input type="text" class="form-control" id="caseYear"
							name="caseYear" required data-parsley-trigger="keyup"
							data-parsley-type="number" />


					</div>
					</div>
					
					<div class="row">
					<div class="col-md-6">

						<label class="label-control rowlebel ">Date of Filing</label>
					</div>
					<div class="col-md-3"></div>
					<div class="col-md-6">
						<input type="text" class="form-control datepicker" id="filingDate"
							name="filingDate" readonly="readonly" required value="0" />

					</div>
					
					</div>
					
					<div class="row">

					<div class="col-md-3">

						<label class="label-control rowlebel ">Draft Counter to
							G.P</label>
					</div>
					
					<div class="col-md-3"></div>
					<div class="col-md-6">
						<input type="text" class="form-control datepicker"
							id="draftdateconttoGP" name="draftdateconttoGP"
							readonly="readonly" value="0" />

					</div>
					
					</div>
				<div class="row">
					<div class="col-md-3">

						<label class="label-control rowlebel ">Date of Counter
							Filed</label>
					</div>
					<div class="col-md-3"></div>
					<div class="col-md-6">
						<input type="text" class="form-control  datepicker"
							id="counterDate" name="counterDate" readonly="readonly" value="0" />

					</div>
					
					</div>
					
					<div class="row">
					<div class="col-md-3">

						<label class="label-control rowlebel ">Date of Judgement</label>
					</div>
						<div class="col-md-3"></div>
					<div class="col-md-6">
						<input type="text" class="form-control  datepicker "
							id="judgementDate" name="judgementDate" readonly="readonly"
							value="0" />

					</div>
					</div>
					<div class="row">
						<div class="col-md-3">
						<label class="label-control rowlebel ">Contact Person1</label>
					</div>
					<div class="col-md-3"></div>
					<div class="col-md-6">
						<input type="text" class="form-control" id="cntactPname1" value=""
							placeholder="" name="contactPlist[0].cntactPname">
					</div>
					</div>
                 <div class="row">
					<div class="col-md-3">
						<label class="label-control rowlebel ">Contact Address1</label>
					</div>
					
					<div class="col-md-3"></div>
					<div class="col-md-6">
						<input type="text" class="form-control" id="contactAddress1"
							value="" name="contactPlist[0].contactAddress">
					</div>
					</div>
                 <div class="row">
					<div class="col-md-3">
						<label class="label-control rowlebel ">Phone Number1</label>
					</div>
					<div class="col-md-3"></div>
					<div class="col-md-6">
						<input type="text" class="form-control" id="contactPhone1"
							value="" name="contactPlist[0].contactPhone1"
							data-parsley-trigger="keyup" data-parsley-type="number"
							data-parsley-minlength="10" data-parsley-maxlength="10">
					</div>
					
					</div>
					 <div class="row">
					<div class="col-md-3">
						<label class="label-control rowlebel ">Phone Number2</label>
					</div>
					<div class="col-md-3"></div>
					<div class="col-md-6">
						<input type="text" class="form-control" id="contactPhone2"
							value="" name="contactPlist[0].contactPhone2"
							data-parsley-trigger="keyup" data-parsley-type="number"
							data-parsley-minlength="10" data-parsley-maxlength="10">
					</div>
					</div>
					
					 <div class="row">
					<div class="col-md-3">
						<label class="label-control rowlebel ">Contact Person2</label>
					</div>
					<div class="col-md-3"></div>
					<div class="col-md-6">
						<input type="text" class="form-control" id="cntactPname1" value=""
							placeholder="" name="contactPlist[1].cntactPname">
					</div>
					</div>
 <div class="row">
					<div class="col-md-3">
						<label class="label-control rowlebel ">Contact Address2</label>
					</div>
					<div class="col-md-3"></div>
					<div class="col-md-6">
						<input type="text" class="form-control" id="contactAddress1"
							value="" name="contactPlist[1].contactAddress">
					</div>
					
					</div>
 <div class="row">
					<div class="col-md-3">
						<label class="label-control rowlebel ">Phone Number1</label>
					</div>
					<div class="col-md-3"></div>
					<div class="col-md-6">
						<input type="text" class="form-control" id="contactPhone1"
							value="" name="contactPlist[1].contactPhone1"
							data-parsley-trigger="keyup" data-parsley-type="number"
							data-parsley-minlength="10" data-parsley-maxlength="10">
					</div>
					
					</div>
					
					 <div class="row">
					<div class="col-md-3">
						<label class="label-control rowlebel ">Phone Number2</label>
					</div>
					<div class="col-md-3"></div>
					<div class="col-md-6">
						<input type="text" class="form-control" id="contactPhone2"
							value="" name="contactPlist[1].contactPhone2"
							data-parsley-trigger="keyup" data-parsley-type="number"
							data-parsley-minlength="10" data-parsley-maxlength="10">
					</div>
					
					</div>
					 <div class="row">
						<div class="form-group">
						<div class="col-md-6">
							<label class="label-control rowlebel ">Is Child Case[case
								transfered from Other Courts]</label>
								</div>
							<div class="col-md-6">
								<label class="radio-inline"> <input type="radio"
									name="isChildCase" id="isChildCase" value="1"> Yes
								</label> <label class="radio-inline"> <input type="radio"
									name="isChildCase" id="isChildCase" value="2" checked>
									NO
								</label>

							</div>
						</div>
					</div>
				
					





				</div>
				<div class="col-md-12">
					<div class="col-md-6">
						<label class="label-control rowlebel ">Case Brief Prayer*</label>
						<textarea class="form-control" id="briefPrayer" name="briefPrayer"
							required></textarea>
					</div>


					<div class="col-md-6 ">
						<label class="label-control rowlebel ">Remarks</label>
						<textarea class="form-control" id="remarks" name="remarks"></textarea>
					</div>
					</div>
			</div>

			
		


			<div class="row show-grid">
			<div class="col-md-12">
			<br></br>
			<div class="col-md-5 "></div>
				<div class="col-md-2 ">
					<label class="label-control rowlebel "></label><input type="submit"
						class="btn btn-1 btn-primary center-block" id="addCases"
						value="Add Case" onclick="loadcaseinputform()">
				</div>
				<div class="col-md-5 "></div>
				</div>
			</div>













		</form:form>

	</div>






	<!-- caseinput ends here -->













</div>
<!-- //main-content -->


<div id="pack_dialogue" >
  	

											
											<div class="col-md-8">
											<label class="label-control rowlebel ">Package Name</label>
												<input type="text" class="form-control" id="dipackpkgName"
													name="pkgName" placeholder="pack Name" required />
											</div>
											
										
													
													<div class="col-md-8">
														<label class="label-controlPMS rowlebel ">Select
													Unit</label> <select class="form-control" id="dipackunitId" name="unitId"
													onchange="getProjects(this.value,2);getCircles(this.value,2)">
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
											
											
												<div class="col-md-8">	
													<label class="label-controlPMS rowlebel ">Select
													Project</label> 
													<input type="hidden" class="form-control"
													id="dipackselectedProj" name="selectedProjId"
													value="${selectedProject}" required /> <select
													class="form-control" id="dipackprojectId" name="projectId">
												</select>
											</div>
											
										
												<div class="col-md-8">
												<label class="label-controlPMS rowlebel ">Select
													Circle</label> 	<select class="form-control" id="dipackcircleId"
													name="circleId" onchange="getDivisions(this.value,2)">



												</select>
											</div>
											
												
													<div class="col-md-8">
													<label class="label-controlPMS rowlebel ">Select
													Division</label> <select class="form-control" id="dipackdivisionId"
													name="divisionId" onchange="getSubDivisions(this.value,2)">



												</select>
											</div>
											
											










									<div class="row show-grid">
									
										<div class="col-md-8" >
											<label class="label-control rowlebel "></label><input style="text-align: center;"
												type="submit" class="btn btn-1 btn-primary center-block"
												id="addpack" value="Add Package">
												</div>
											
									
									</div>

											 

  </div>
  
  
  	<div id="pet_dialogue">
					
						
						<div class="col-md-8">
                         
							
							<div class="col-md-8">
							<label class="label-control rowlebel ">Petitioner Name</label> 
							<input
								type="text" class="form-control" 
								id="petitionerName" name="petitionerName" placeholder="Name"  required />
								</div>
								
							<div class="col-md-8">
								<label class="label-control rowlebel ">Petitioner Address</label> 
								<input
								type="text" class="form-control" 
								id="petitionerAddress" name="petitionerAddress" placeholder="address"  />
						</div>
						

						 
							<div class="col-md-8">
							
							<label class="label-controlPMS rowlebel ">Select District</label>
							<select class="form-control" id="dipetdistrictId" name="districtId"
								onchange="getMandals(this.value,1)">

								 <option value="0">--select--</option>
								<c:forEach items="${districtList}" var="p">
									<option value="${p.districtId}">${p.districtName}</option>

								</c:forEach>
 

							</select>
						</div>


						
							<div class="col-md-8">
							<label class="label-controlPMS rowlebel ">Select Mandal</label> 
							<select
								class="form-control" id="dipetmandalId" name="mandalId"
								onchange="getVillages(this.value,1)">



							</select>
						</div>

						
							<div class="col-md-8">
							<label class="label-control rowlebel ">Select Village</label> <select
								class="form-control" id="dipetvillageId"   name="villageId">

							</select>




						</div> 
				
								
								</div>
								
								
									<div class="row show-grid col-md-8">
                     
							<label class="label-control rowlebel "></label><input style="text-align: center;"
								type="submit" class="btn btn-1 btn-primary center-block"
								id="addpet" value="Add Petitioner " >
						</div>
						
						
					
  
						</div>
						
						
						 
						<div id="petadv_dialogue">
						
                         <div class="col-md-8">
                        <div class="col-md-8">
								<label class="label-control rowlebel ">Petitioner Advocate Name</label> 
								<input
								type="text" class="form-control" 
								id="petitionerAdvName" name="petitionerAdvName" placeholder="Name"  required />
								</div>
								
							<div class="col-md-8">
							<label class="label-control rowlebel ">Petitioner Advocate Address</label>
							 <input
								type="text" class="form-control" 
								id="petitionerAdvAddress" name="petitionerAdvAddress" placeholder="address"  />
						</div>
								</div>
									<div class="row show-grid">
                       <div class="col-md-8">
                       <label class="label-control rowlebel "></label>
						<input style="text-align: center;"
								type="submit" class="btn btn-1 btn-primary center-block"
								id="addpetAdv" value="Add Petitioner Advocate" >
						</div>
						
						
						</div>

						</div>
						
							 
						<div id="res_dialogue">
						
						<form:form id="respondentformid" method="post" modelAttribute="addRespondent" name="respondentform"
			data-parsley-validate-if-empty="" enctype="multipart/form-data">
						
                         <div class="col-md-8">
                        <div class="col-md-8">
								<label class="label-control rowlebel ">Respondent Name</label> 
								<input
								type="text" class="form-control" 
								id="respondentName" name="respondentName" placeholder="Name"  required />
								</div>
								
								   <div class="col-md-8">
								<label class="label-control rowlebel ">Respondent Address</label> 
								<input
								type="text" class="form-control" 
								id="respondentAddress" name="respondentAddress" placeholder="respondentAddress"  required />
								</div>
								
						<div class="col-md-8">
							
							<label class="label-controlPMS rowlebel ">Select District</label>
							<select class="form-control" id="resdistrictId" name="districtId"
								onchange="getMandals(this.value,2)">

								 <option value="0">--select--</option>
								<c:forEach items="${districtList}" var="p">
									<option value="${p.districtId}">${p.districtName}</option>

								</c:forEach>
 

							</select>
						</div>


						
							<div class="col-md-8">
							<label class="label-controlPMS rowlebel ">Select Mandal</label> 
							<select
								class="form-control" id="resmandalId" name="mandalId"
								onchange="getVillages(this.value,2)">



							</select>
						</div>

						
							<div class="col-md-8">
							<label class="label-control rowlebel ">Select Village</label> <select
								class="form-control" id="resvillageId"   name="villageId">

							</select>




						</div> 
						
							<div class="col-md-8">
														<label class="label-controlPMS rowlebel ">Select
													Unit</label> <select class="form-control" id="resunitId" name="unitId"
													onchange="getCircles(this.value,3)">
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
											
											
										
										
												<div class="col-md-8">
												<label class="label-controlPMS rowlebel ">Select
													Circle</label> 	<select class="form-control" id="rescircleId"
													name="circleId" onchange="getDivisions(this.value,3)">



												</select>
											</div>
											
												
													<div class="col-md-8">
													<label class="label-controlPMS rowlebel ">Select
													Division</label> <select class="form-control" id="resdivisionId"
													name="divisionId" onchange="getSubDivisions(this.value,3)">



												</select>
											</div>
											
												
					<div class="col-md-8">
					<label class="label-controlPMS rowlebel ">Select
							SubDivision</label>
						<select class="form-control" id="ressubdivisionId"
							name="subdivisionId">
							<option value="0">--select--</option>



						</select>
					</div>
											
								</div>
									<div class="row show-grid">
                       <div class="col-md-8">
                       <label class="label-control rowlebel "></label>
						<input style="text-align: center;"
								type="button" class="btn btn-1 btn-primary center-block"
								id="addres" value="Add Respondent" >
						</div>
						
						
						</div>
</form:form>
						</div>
						
		
			 
						<div id="resadv_dialogue">
						
						<form:form id="respondentadvformid" method="post" modelAttribute="addRespondentadv" name="respondentadvform"
			data-parsley-validate-if-empty="" enctype="multipart/form-data">
						
                         <div class="col-md-8">
                        <div class="col-md-8">
								<label class="label-control rowlebel ">Respondent Advocate Name</label> 
								<input
								type="text" class="form-control" 
								id="respondentAdvName" name="respondentAdvName" placeholder="Name"  required />
								</div>
								
								   <div class="col-md-8">
								<label class="label-control rowlebel ">Respondent Advocate Address</label> 
								<input
								type="text" class="form-control" 
								id="respondentAddress" name="respondentAddress" placeholder="respondentAddress"  required />
								</div>
								
								 <div class="col-md-8">
								<label class="label-control rowlebel ">Respondent Advocate Code</label> 
								<input
								type="text" class="form-control" 
								id="resAdvCode" name="resAdvCode" placeholder="resAdvCode"   />
								</div>
									
								</div>
									<div class="row show-grid">
                       <div class="col-md-8">
                       <label class="label-control rowlebel "></label>
						<input style="text-align: center;"
								type="button" class="btn btn-1 btn-primary center-block"
								id="addresadv" value="Add Respondent Advocate" >
						</div>
						
						
						</div>
</form:form>
						</div>
										
						
						

						


					

						



					
			
					


					
				
					
				


						
						
				


					
			
					

					
				
					
				

<script type="text/javascript" src="../js/parsley.js"></script>



<script type="text/javascript" class="example">
$(function () {
	 $('#caseinput1').parsley().on('field:validated', function() {
		    var ok = $('.parsley-error').length === 0;
		
		   // alert('hi');
		    
		  })
		  
		  .on('form:submit', function() {
			 // alert("coming here");
			  
			 
				
			  document.forms.caseinput1.action="../web/caseinput";
				 document.forms.caseinput1.submit(); 
				
			
				
			  
			  
			    // Don't submit form for this demo
			  });
});
</script>

