$(document).ready(function() {
		 var d = new Date();
		  var e=new Date();
		
		 e= e.getFullYear() ;
		 
		// alert("e"+e);
		
	   for (var i = 1; i >= 1; i--) {
		   
		  var dataval=parseInt(e);
		// alert("dataval"+dataval);
		   $('#year').val(dataval);
	 	
	    
	       e++;
	      // j++;
	       
	   }
	   
	   var yeardata= $('#year').val();
	   
	   if(yeardata){
		   
		   
		   
	   }
	   
	   $(".resmainobsinf").hide();
	   $(".resannvieweditdata").hide();
	   

	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
		/*$("#verticalearth").tabs().addClass("ui-tabs-vertical ui-helper-clearfix");
		$("#verticalearth li").removeClass("ui-corner-top").addClass("ui-corner-left");
		
		$("#verticalmason").tabs().addClass("ui-tabs-vertical ui-helper-clearfix");
		$("#verticalmason li").removeClass("ui-corner-top").addClass("ui-corner-left");
		
		$("#verticalc").tabs().addClass("ui-tabs-vertical ui-helper-clearfix");
		$("#verticalc li").removeClass("ui-corner-top").addClass("ui-corner-left");
		
		$("#verticald").tabs().addClass("ui-tabs-vertical ui-helper-clearfix");
		$("#verticald li").removeClass("ui-corner-top").addClass("ui-corner-left");
		
		$("#verticale").tabs().addClass("ui-tabs-vertical ui-helper-clearfix");
		$("#verticale li").removeClass("ui-corner-top").addClass("ui-corner-left");
		
		$("#verticalf").tabs().addClass("ui-tabs-vertical ui-helper-clearfix");
		$("#verticalf li").removeClass("ui-corner-top").addClass("ui-corner-left");
		
		$("#verticalg").tabs().addClass("ui-tabs-vertical ui-helper-clearfix");
		$("#verticalg li").removeClass("ui-corner-top").addClass("ui-corner-left");
		
		$("#verticalh").tabs().addClass("ui-tabs-vertical ui-helper-clearfix");
		$("#verticalh li").removeClass("ui-corner-top").addClass("ui-corner-left");
		
		$("#verticali").tabs().addClass("ui-tabs-vertical ui-helper-clearfix");
		$("#verticali li").removeClass("ui-corner-top").addClass("ui-corner-left");
		
		$("#verticalk").tabs().addClass("ui-tabs-vertical ui-helper-clearfix");
		$("#verticalk li").removeClass("ui-corner-top").addClass("ui-corner-left");
		
		$("#verticall").tabs().addClass("ui-tabs-vertical ui-helper-clearfix");
		$("#verticall li").removeClass("ui-corner-top").addClass("ui-corner-left");*/
		
		
		
	  
	  

		
		
		$('#dutyFrequencyId').multiselect({

			enableCaseInsensitiveFiltering : true

		});
		
		$('#resStatusId').multiselect({

			enableCaseInsensitiveFiltering : true

		});
		
		$('#nextPostId').multiselect({

			enableCaseInsensitiveFiltering : true

		});
		
		
		$('#resdistrictId').multiselect({
			 
			 enableCaseInsensitiveFiltering: true
			 
		});
		$('#resmandalId').multiselect({
			 
			 enableCaseInsensitiveFiltering: true
			 
		});
		$('#resvillageId').multiselect({
			 
			 enableCaseInsensitiveFiltering: true
			 
		});
		
		$('#conditionofDamId').multiselect({
			 
			 enableCaseInsensitiveFiltering: true
			 
		});
		
		$('#rec2inspectOfficeInfoId').multiselect({
			 
			 enableCaseInsensitiveFiltering: true
			 
		});
		
		$('#inspectphtInfoId').multiselect({
			 
			 enableCaseInsensitiveFiltering: true
			 
		});
		
		
		
		
		$("#editDamStatus12").hide();
		
		
		
		
		 var id =  $("#nextPostId").val();
			//		  alert("nextPostId" +id);
					  if(id!=null){
					  if(parseInt(id)>0){
					  $(".mainnextPostId").val(id);
					
					  }
					  }
					  
					  
					  var nextempid =  $("#nextEmpId").val();
						//		  alert("nextempid" +nextempid);
								  if(nextempid!=null){
								  if(parseInt(nextempid)>0){
								  $(".mainnextEmpId").val(nextempid);
								
								  }
								  }
		
		
								  
								  $("#pmsresinfo").hide();
								  $("#mkinfo").hide();
								  
								  
								  
								 // $("#result").hide();
								  
								  

	});



	$(function() {
		
		
		 $('#gettanks_dialogue').dialog({
			  autoOpen:false,
			  width:1200,
			  close: function() {
				  
				
					  $(this).dialog("close");
					  }
			 });
		 
		
		 
		 $('#showtanksdata').click(function(){
				
			 $('#gettanks_dialogue').dialog('option', 'title', 'View Tanks Info');
			  $('#gettanks_dialogue').dialog('open');
			 
		      
			 });
		 
		
	
		
		$('#addresloc_dialogue').dialog({
			  autoOpen:false,
			  width:800,
			  close: function() {
				  
				
					  $(this).dialog("close");
					  }
			 });
		
		$('#addhealthremarks_dialogue').dialog({
			  autoOpen:false,
			  width:800,
			  close: function() {
				  
				
					  $(this).dialog("close");
					  }
			 });
		
		
		 $('#editdamtatus_dialogue').dialog({
			  autoOpen:false,
			  width:1200,
			  close: function() {
				  
				
					  $(this).dialog("close");
					  }
			 });
		
		
		
		 
		$('#reccheck_doc_update').dialog({
			  autoOpen:false,
			  width:1200,
			  close: function() {
				  
				
					  $(this).dialog("close");
					  }
			 });
		
		
		$('.addphotoinf').click(function(){
			
			 $('#reccheck_doc_update').dialog('option', 'title', 'upload photos');
			  $('#reccheck_doc_update').dialog('open');
			 
		      
			 });
		
		
		$('#rescheck_doc_dia').dialog({
			  autoOpen:false,
			  width:1200,
			  close: function() {
				  
				
					  $(this).dialog("close");
					  }
			 });
		
		$('.viewphtinf').click(function(){
			
			 $('#rescheck_doc_dia').dialog('option', 'title', 'upload photos');
			  $('#rescheck_doc_dia').dialog('open');
			 
		      
			 });
		
		
		

		
		$('#addrecommend_dialogue').dialog({
			  autoOpen:false,
			  width:1200,
			  close: function() {
				  
				
					  $(this).dialog("close");
					  }
			 });
		
		
		$('#res_basic_info').dialog({
			  autoOpen:false,
			  width:1200,
			  close: function() {
				  
				
					  $(this).dialog("close");
					  }
			 });
		
		
		
		
		$('#shaddresbaiscinf').click(function(){
			
			 $('#res_basic_info').dialog('option', 'title', 'view Reservoir info');
			  $('#res_basic_info').dialog('open');
			  
			  $('#adddambasicinf').trigger("reset"); 
			  
			  $('#adddamcontrolinf').trigger("reset"); 
			 
		      
			 });
		
		$('#shaddtankinf').click(function(){
			
			 $('#res_basic_info').dialog('option', 'title', 'view Tank info');
			  $('#res_basic_info').dialog('open');
			  
 $('#adddambasicinf').trigger("reset"); 
			  
			  $('#adddamcontrolinf').trigger("reset"); 
			 
		      
			 });
		
		
		
		
		
		
		
		 var cyear = (new Date).getFullYear();

		$(".datepick").datepicker({
			changeYear : false,
			changeMonth : true,
			 minDate: new Date(cyear, 0, 1),
		        maxDate: new Date(cyear, 11, 31),
		     
			
			 dateFormat: "dd/mm/yy"+" "+ getCurrentTime(),
			   
			
	
		});

		$("#addresjuris").click(function() {
			var link = $(this).attr('href');

			//alert(link);

			$('#whereFormWillLive').load(link);

			// $(".content").load(link);
		});

		$("#resprepost").tabs()
		
		$("#recbasicupdate").tabs()
		
		
	//	$("#1ann").tabs();
		//$("#2ann").tabs()
		
		$("#1ann").tabs().addClass("ui-tabs-vertical ui-helper-clearfix");
		$("#1ann li").removeClass("ui-corner-top").addClass("ui-corner-left");
		
			$("#2ann").tabs().addClass("ui-tabs-vertical ui-helper-clearfix");
		$("#2ann li").removeClass("ui-corner-top").addClass("ui-corner-left");
		
		
		
		for (var i=5 ; i<=15 ; i++){
			
			var newtab="#verticalearth"+i;
			
			//alert("newtab"+newtab)
			
			$(newtab).tabs().addClass("ui-tabs-vertical ui-helper-clearfix");
			$(newtab).removeClass("ui-corner-top").addClass("ui-corner-left");
			
		}
	
		  $("#dutyFrequencyId").change(function() {
		  var id = $(this).val();

		  $('.maindutyFrequencyId').val(id);
		
		
		});
		
		  $("#conditionofDamId").change(function() {
			  var id = $(this).val();

			  $('.mainconditionofDamId').val(id);
			
			
			});
	
		
		
		

		$("#frequencyId").change(function() {
			var freq = $(this).val();

			alert(freq);

		});
		
		 $('#getprojects_dialogue').dialog({
			  autoOpen:false,
			  width:800,
			  close: function() {
				  
				
					  $(this).dialog("close");
					  }
			 });
		 
		 
		 
		 $('#showprojectsdisplaydata').click(function(){
			 
			 alert("open projects");
				
			 $('#getprojects_dialogue').dialog('option', 'title', 'Projects');
			 
			 alert("open projects2");
			  $('#getprojects_dialogue').dialog('open');
			  
			  alert("open projects3");
			  
			 
			 
		      
			 });
		 
		 
		 
		/* $('#shaddinspectinf').click(function(){
				
			 $('#addinspect_dialogue').dialog('option', 'title', 'Add Inspection Details');
			  $('#addinspect_dialogue').dialog('open');
			 
		      
			 });*/
		 
		/* $('#inspectDate').click(function(){
		 
		 var inspectDatenew =  $("#inspectDate").val();
		  
		  if(inspectDatenew!=null && inspectDatenew!=0){
			  
			  alert("kal here time");
			  
			  $("#inspectDate1").val(inspectDatenew);
				
			  $('#inspectDate2').val(inspectDatenew);
			  $('#inspectDate3').val(inspectDatenew);
			//  $('#empId4').val(id);
			  $('#inspectDate4').val(inspectDatenew);
			  
			  
		  }
		 });*/
		  alert("open viewresdataid"); 
		 
		 $('#viewresdatainf').DataTable( {
			    dom: 'Bfrtip',
			    responsive: true,
			    "paging": false,
			    "ordering": false,
			    "autoWidth": true,
			    "lengthChange": false,
			    "pageLength": 20,
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
			            messageTop: 'Projects and Reservoirs',
			            exportOptions: {
			                columns: ':visible'
			            }
			           
			            
			        },
			        
			        {
			            extend: 'pdfHtml5',
			            className: 'btn-primary ',
			            text:  'PDF View / Download',
			            orientation: 'landscape',
			            pageSize: 'A4',
			            download: 'open',
			            font:'10',
			            filename: 'Projects Info',
			            exportOptions: {
							columns: ':visible'
							
						},
						 
			           
			            title: 'Projects Info',
			            customize: function (doc) {
			            	doc.defaultStyle.fontfamily ='Arial';
			            	
			            	doc.defaultStyle.fontSize = 10;
			            	doc.defaultStyle.alignment = 'center';
			            	doc.styles.tableHeader.fontSize = 12;
			            	doc.pageMargins = [80, 80, 80,80];
			            	 doc['footer']=(function(page, pages) {
			                  	return {
			                  	columns: [
			                 
			                  	{
			                  	alignment: 'right',
			                  	text: [
			                  	{ text: page.toString(), italics: true },
			                  	' of ',
			                  	{ text: pages.toString(), italics: true }
			                  	]
			                  	}
			                  	],
			                  	margin: [5, 0]
			                  	}
			                  	});
			  				
			            	
			            	
			            	
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
		  alert("open tanktable");  
	
		 $('.tanktable').DataTable( {
		        dom: 'Bfrtip',
		        responsive: true,
		        "paging": false,
		        "ordering": false,
		        "autoWidth": true,
		        "lengthChange": false,
		        "pageLength": 20,
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
		                sheetName: 'Exported_Tanks_Info',
		                text:  'Download Data To Excel',
		                className: 'btn-primary ',
		                messageTop: 'Tanks Info',
		                exportOptions: {
		                    columns: ':visible'
		                }
		               
		                
		            },
		            
		            {
		                extend: 'pdfHtml5',
		                className: 'btn-primary ',
		                text:  'PDF View / Download',
		                orientation: 'landscape',
		                pageSize: 'A4',
		                download: 'open',
		                font:'10',
		                filename: 'Tanks Info',
		                exportOptions: {
							columns: ':visible'
							
						},
						 
		               
		                title: 'Tanks Info',
		                customize: function (doc) {
		                	doc.defaultStyle.fontfamily ='Arial';
		                	
		                	doc.defaultStyle.fontSize = 10;
		                	doc.defaultStyle.alignment = 'center';
		                	doc.styles.tableHeader.fontSize = 12;
		                	doc.pageMargins = [80, 80, 80,80];
		                	 doc['footer']=(function(page, pages) {
		                      	return {
		                      	columns: [
		                     
		                      	{
		                      	alignment: 'right',
		                      	text: [
		                      	{ text: page.toString(), italics: true },
		                      	' of ',
		                      	{ text: pages.toString(), italics: true }
		                      	]
		                      	}
		                      	],
		                      	margin: [5, 0]
		                      	}
		                      	});
		      				
		                	
		                	
		                	
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
			
		 alert("open shaddresinf");  

			$('#shaddresinf').click(function(){
				
				 $('#addresloc_dialogue').dialog('option', 'title', 'Add Reservoir location');
				  $('#addresloc_dialogue').dialog('open');
				  
				  
				  
				  $('#addresloc').trigger("reset"); 
				  
				  var resName= $('#reservoirName').val();
				  
				  var resIddia=  $('#resId').val();
				  
				  var projectId=  $('#resmainprojectId').val();
				  
				  $('#resdianew').val(resName); 
				  
				  $('#reservoirId').val(resIddia); 
				  
				  $('#resProjectId').val(projectId); 
				  
				  
				  
				  document.getElementById('resnrldcaptcha_id').src = '../captcha2.jpg?' + Math.random();  
				 
			     
				 });
			
			
			 var yearval=parseInt($("#year").val());
			 if(yearval!='Nan' && yearval!=null){
				 
				 if(yearval>0){
					 
					  $('.mainyear').val(yearval);
					 
				 }
				 
				 
			 }
			 

			 var dutyfreq=parseInt($("#dutyFrequencyId").val());
			 if(dutyfreq!='Nan' && dutyfreq!=null){
				 
				 if(dutyfreq>0){
					 
					  $('.maindutyFrequencyId').val(yearval);
					 
				 }
				 
				 
			 }

	});
	
	function getCurrentTime() {
	    var CurrentTime = "";
	    try {
	        var CurrentDate = new Date();
	        var CurrentHours = CurrentDate.getHours();
	        var CurrentMinutes = CurrentDate.getMinutes();
	        var  CurrentSeconds= CurrentDate.getSeconds();
	        var CurrentAmPm = "A'M'";
	        if (CurrentMinutes < 10) { CurrentMinutes = "0" + CurrentMinutes; }

	     
	        CurrentTime = "" + CurrentHours + ":" + CurrentMinutes +":" + CurrentSeconds +  "";
	    }
	    catch (ex) {
	    }
	    return CurrentTime;
	}
	
	
	

function getProjects(unitId, hkey) {

	var unitId = unitId;

	//$('#unitId').val();

	//  alert("procId"+procId);

	if (hkey == 1) {
		$('#projectId').multiselect('rebuild');
	}

	if (hkey == 2) {
		$('#dipackprojectId').multiselect('rebuild');
	}

	$.ajax({
		url : "../web/getProjects?unitId=" + unitId,
		type : "GET",
		success : function(response) {

			if (hkey == 1) {
				var $select = $('#projectId');

				var selectedprojectId = $('#hiddenprojectId').val();
			}
			if (hkey == 2) {
				var $select = $('#dipackprojectId');
			}
			$select.find('option').remove();

			var obj = JSON.parse(response);

			if (hkey == 1) {
				$('#projectId').append(
						'<option value="0"> --select--</option>');
			}

			if (hkey == 2) {
				$('#dipackprojectId').append(
						'<option value="0"> --select--</option>');
			}

			$.each(obj, function(key, value) {

				if (hkey == 1) {

					if (selectedprojectId == value.projectId) {

						$('#projectId').append(
								'<option value="'+value.projectId+'"selected="selected"> '
										+ value.projectName + '</option>');
					}

					if (selectedprojectId == null
							|| selectedprojectId != value.projectId) {

						$('#projectId').append(
								'<option value="'+value.projectId+'"> '
										+ value.projectName + '</option>');
					}

					$('#projectId').multiselect('rebuild')
				}
				if (hkey == 2) {
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

	var projectId = projectId;

	//$('#projectId').val();

	//  alert("procId"+procId);
	$('#packageId').multiselect('rebuild');

	$.ajax({
		url : "../web/getPackages?projectId=" + projectId,
		type : "GET",
		success : function(response) {
			var $select = $('#packageId');
			$select.find('option').remove();

			var selectedpackageId = $('#hiddenpackageId').val();

			var obj = JSON.parse(response);

			$('#packageId')
					.append('<option value="0"> --select--</option>');

			$.each(obj, function(key, value) {

				if (selectedpackageId == value.pkgId) {

					$('#packageId').append(
							'<option value="'+value.pkgId+'" selected="selected"> '
									+ value.pkgName + '</option>');
				}
				if (selectedpackageId == null
						|| selectedpackageId != value.pkgId) {
					$('#packageId').append(
							'<option value="'+value.pkgId+'"> '
									+ value.pkgName + '</option>');

				}

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

function getCircles(unitId, hkey) {
	//alert("kal");
	//var districtId=document.getElementById("districtId").value;
	var unitId = unitId;
	//document.getElementById("unitId").value;
	//alert(mandalId);

	$.ajax({
		url : "../web/getCircles?unitId=" + unitId,
		type : "GET",
		success : function(response) {
			if (hkey == 1) {
				var $select = $('#circleId');

				var selectedCircleId = $('#hiddencircleId').val();

				//alert("selectedCircleId"+selectedCircleId);
			}
			if (hkey == 2) {

				var $select = $('#dipackcircleId');
			}
			$select.find('option').remove();

			var obj = JSON.parse(response);

			if (hkey == 1) {
				$('#circleId').append(
						'<option value="0"> --select--</option>');
			}
			if (hkey == 2) {
				$('#dipackcircleId').append(
						'<option value="0"> --select--</option>');
			}

			$.each(obj, function(key, value) {
				if (hkey == 1) {

					if (selectedCircleId == value.circleId) {

						/* $('#projectId').val(value.projectId);
						$('#projectName').val(value.projectName); */

						$('#circleId').append(
								'<option value="'+value.circleId+'" selected="selected"> '
										+ value.circleName + '</option>');

					}

					if (selectedCircleId == null
							|| selectedCircleId != value.circleId) {
						$('#circleId').append(
								'<option value="'+value.circleId+'"> '
										+ value.circleName + '</option>');

					}

					$('#circleId').multiselect('rebuild');

				}
				if (hkey == 2) {
					$('#dipackcircleId').append(
							'<option value="'+value.circleId+'" > '
									+ value.circleName + '</option>');

					$('#dipackcircleId').multiselect('rebuild');

				}
			});

		},
		error : function() {
			alert(error);
		}
	});
}

function getDivisions(circleId, hkey) {
	//alert("kal");
	//var districtId=document.getElementById("districtId").value;
	var circleId = circleId;
	//document.getElementById("circleId").value;
	//alert(mandalId);

	$
			.ajax({
				url : "../web/getDivisions?circleId=" + circleId,
				type : "GET",
				success : function(response) {
					if (hkey == 1) {
						var $select = $('#divisionId');

						var selecteddivisionId = $('#hiddendivisionId')
								.val();
					}
					if (hkey == 2) {
						var $select = $('#dipackdivisionId');
					}

					$select.find('option').remove();

					var obj = JSON.parse(response);

					if (hkey == 1) {
						$('#divisionId').append(
								'<option value="0"> --select--</option>');
					}
					if (hkey == 2) {
						$('#dipackdivisionId').append(
								'<option value="0"> --select--</option>');
					}

					$
							.each(
									obj,
									function(key, value) {
										if (hkey == 1) {
											if (selecteddivisionId == value.divisionId) {
												$('#divisionId')
														.append(
																'<option value="'+value.divisionId+'" selected="selected"> '
																		+ value.divisionName
																		+ '</option>');
											}

											if (selecteddivisionId == null
													|| selecteddivisionId != value.divisionId) {

												$('#divisionId')
														.append(
																'<option value="'+value.divisionId+'"> '
																		+ value.divisionName
																		+ '</option>');

											}

											$('#divisionId').multiselect(
													'rebuild');
										}
										if (hkey == 2) {
											$('#dipackdivisionId')
													.append(
															'<option value="'+value.divisionId+'" > '
																	+ value.divisionName
																	+ '</option>');

											$('#dipackdivisionId')
													.multiselect('rebuild');
										}
									});

				},
				error : function() {
					alert(error);
				}
			});
}

function getSubDivisions(divisionId, hkey) {
	//alert("kal");
	//var districtId=document.getElementById("districtId").value;
	var divisionId = divisionId;

	//document.getElementById("divisionId").value;
	//alert(mandalId);

	$
			.ajax({
				url : "../web/getSubDivisions?divisionId=" + divisionId,
				type : "GET",
				success : function(response) {
					if (hkey == 1) {
						var $select = $('#subdivisionId');

						var selectedsubdivisionId = $(
								'#hiddensubdivisionId').val();
						//alert("selectedsubdivisionId"+selectedsubdivisionId);
					}
					/* if(hkey==2){
						var $select = $('#subdivisionId');	
						
					} */
					$select.find('option').remove();

					var obj = JSON.parse(response);

					$('#subdivisionId').append(
							'<option value="0"> --select--</option>');

					$
							.each(
									obj,
									function(key, value) {

										if (selectedsubdivisionId == value.subdivisionId) {
											$('#subdivisionId')
													.append(
															'<option value="'+value.subdivisionId+'" selected="selected" > '
																	+ value.subdivisionName
																	+ '</option>');
										}
										if (selectedsubdivisionId == null
												|| selectedsubdivisionId != value.subdivisionId) {
											$('#subdivisionId')
													.append(
															'<option value="'+value.subdivisionId+'" > '
																	+ value.subdivisionName
																	+ '</option>');
										}

										$('#subdivisionId').multiselect(
												'rebuild');
									});

				},
				error : function() {
					alert(error);
				}
			});
}

function getReservoirs(projectId, hkey) {
	//alert("kal");
	//var districtId=document.getElementById("districtId").value;
	//var projectId = projectId ;

	//document.getElementById("divisionId").value;
	//alert(mandalId);
///changed projectId to unitId
	$.ajax({
		url : "../invtsimis/getResList?projectId=" + projectId,
		type : "GET",
		success : function(response) {
			if (hkey == 1) {
				var $select = $('#reservoirId');

				$select.find('option').remove();

				//alert("selectedsubdivisionId"+selectedsubdivisionId);
			}

			/* 	var selectedreservoirId=null ; */// $('#hiddenrservoirId').val();
			/* if(hkey==2){
				var $select = $('#subdivisionId');	
				
			} */
			//alert(response);
			var obj = JSON.parse(response);

			$('#reservoirId').append(
					'<option value="0"> --select--</option>');

			$.each(obj, function(key, value) {

				$('#reservoirId').append(
						'<option value="'+value.resCode+'" > '
								+ value.resName + '</option>');

				/* if(selectedreservoirId==value.reservoirId){
				$('#reservoirId').append(
						'<option value="'+value.resCode+'" selected="selected" > '
								+ value.resName + '</option>');
				}
				if(selectedreservoirId==null || selectedreservoirId!=value.reservoirId){
				
					} */

				$('#reservoirId').multiselect('rebuild');
			});

		},
		error : function() {
			alert(error);
		}
	});
}



function gettankgeotaglist(tankId){
	
	//alert("kal"+b);

	
	var newtankId=tankId
		//document.getElementById("districtId").value;
	
	//alert(districtId);
	
	
	



	$.ajax({	          
	      url: "../invtsimis/tanks-capacitylist?tankId="+tankId,
	      type: "GET",
	      success: function (response) {
	    	  
	    
	    	
	    	var obj = JSON.parse(response);
	    	
	    	
	    	var geoId=obj[0].geoTagId;
	    	
	    	var capacity=obj[0].capacitytank;
	    var grossAyacut=obj[0].grossAyacut;
	    
	    		$('#grossCapacity').val(capacity);
	    		$('#geoTagId').val(geoId);
	    		$('#gayacut').val(grossAyacut);
	    		
	    		
	    	  
	    	  

	      },
	      error : function(){
	    	  alert(error);
	      }
	  });	
	} 


function showprojectsdata(projectName,projectId,reservoirId,reservoirName,unitId,formId,nrld){
	
	
	alert("i am in showprojectsdata")
	 $('#projectName').val(projectName);
	 $('#reservoirName').val(reservoirName);
	 $('#resmainprojectId').val(projectId);
	 $('#resId').val(reservoirId);
	 $('#respic').val(nrld);
	 
	 
	 

	 getDistricts(1);
	 
	 
	 
	 if(reservoirId>0){
		 
		 $('.mainprojId').val(projectId);
		 $('.mainresId').val(reservoirId);
		 
			
				  $('#pmsresinfo').show();
				  
				  $('#mkinfo').hide();
					
					
				 $('#getprojects_dialogue').dialog('close');
				
				
				
				 
				 getResList(reservoirId);
				 
			
				 
				 $('#resdianew').val(reservoirName);
				 
				
				 
			 }else {
				 
				 $('#pmsresinfo').hide();
				 
			 }
	 
	
	 
	 $('#getprojects').trigger("reset"); 
	 
	
	 
	
	
}


function showtankdata (tankName,tankId,tankCode,districtId,mcode,vcode,acode,hcode,manName,villName,formId,nrldcode){
	
	
	var projectId=0;
	// $('#tanksflitems').show();
	 
	 
	

	
	$('#tankId').val(tankId);
	
	// $('#tankdata').html('<p style="margin: 0px !important; font-weight:bold; color:blue">'+tankCode+'-'+tankName+'</p>');
	// $('#mandata').html('<p style="margin: 0px !important; font-weight:bold; color:blue">'+manName+'</p>');
	// $('#villdata').html('<p style="margin: 0px !important; font-weight:bold; color:blue">'+villName+'</p>');
	 var tanknewname=tankCode+"-"+tankName ; 
	 $('#mandata').val(manName);
	 $('#villdata').val(villName);
	 $('#tankdata').val(tanknewname);
	 
	 $('#tankpic').val(nrldcode);
	 
	
	  
	 
	 
	
	
	  
	  var tankId = tankId;
	
	  if(tankId>0){
		  
		 
		  
		  
		
		
			 $('#resId').val(0);
			 
			 $('#resmainprojectId').val(0);
			 
			 $('#resMainDistrictId').val(0);
			 
			 
			 

	 
	  $('.maintankId').val(tankId);
	  
	  $('.mainresId').val(0);
	  
	
	  
	
	  
	  $('.mainprojId').val(0);
	  
	
	
	  
	  }
	 
	
	
	 $('#gettanks').trigger("reset"); 
	 
	// alert("iam at  end "+formId);s
	 if(formId==1){
	 $('#gettanks_dialogue').dialog('close'); 
	 
	
	 
	 }
	 
	 if(formId==2){
		 $('#getanicut_dialogue').dialog('close'); 
		 
		
		 }
	 
	 if(formId==3){
		 $('#getcheckdam_dialogue').dialog('close'); 
		 
		
		 }
	 
	 if(formId==1|| formId==2|| formId==3){
		 
		 $('#mkinfo').show();
		 $('#pmsresinfo').hide();
		
		 
		
	 }else{
		 
		 $('#mkinfo').hide();
		 
		
	 }
	 
	 
	
}



function updateReservoirLocation(){
	
	//alert("UpdateSeaAyacutInfo");
	
	var resId= $('#reservoirId').val();
	
	if ($('form[id=addresloc]').parsley().isValid()) {
	
	var finaldatatoSend=$('form[id=addresloc]').serialize();
	
		 
		 $.ajax({	          
				url: "../invtsimis/update_res_location" ,
				method:"GET",
				dataType: 'json',

				async: false,
				   data:finaldatatoSend,


				success: function (obj) {

					  
					if(obj>0 ){
						
						 $('#action_alert').html('<p style="margin: 0px !important;">Updated Data Successfully</p>');
						 $("html,body").animate({scrollTop:0}, 500);
						 
						  $('#addresloc').trigger("reset"); 
						 $('#addresloc_dialogue').dialog('close');
						 
						 
						 $('#districtNameres').val('');
						 $('#mandalNameres').val('');
						 $('#villageNameres').val('');
						 
						 getResList(resId);
						 
						// document.getElementById('rescaptcha_id').src = '../captcha2.jpg?' + Math.random(); 
						
						 
						}
						
						if(obj==0 || obj==null){
							 $('#action_alert').html('<p style="margin: 0px !important;">Failed to Update data</p>');
							 $("html,body").animate({scrollTop:0}, 500);
						} 
						
						
						 if(obj==-3){
					    		
					    		$('#action_alert').html('<p style="margin: 0px !important;">Please Enter the Captcha Text </p>'); 
					    		
					    	}
					    	
	                   if(obj==-2){
					    		
					    		$('#action_alert').html('<p style="margin: 0px !important;">Captcha does not match </p>'); 
					    		 $("html,body").animate({scrollTop:0}, 500);
					    		
					    	}
					    	
			
				},
				error : function(){
					 alert(error);

				}
				}); 
		 
	}else{
    	 
    	 $('form[id=addresloc]').parsley().validate();
    	 
     }
	
}





function getDistricts(hkey){
	
	//alert("kal"+b);



	$.ajax({	          
	      url: "../invtsimis/get-districts",
	      type: "GET",
	      success: function (response) {
	    	  
	    	 // console.log(response);
	    	  
	    	  if(response!=null){
	    	  
	    	  if(hkey==1){
	    	  var $select = $('#resdistrictId');
			  $select.find('option').remove();
			  
			  var resselectedDistrict=$('#resselectedDistrictId').val();
			  
			  
			  
			 // var resselectedDistrict=$('#resselectedDistrictId').val();
		 // alert("selected district"+resselectedDistrict);
			  
			 // alert("resselectedMandal"+resselectedMandal);
			 
			  $('#resdistrictId').append( '<option value=" "> --select--</option>' );
			  
	    	  }
	    	  
	    	
	    	  //alert("response"+response);
					var obj = JSON.parse(response);
					//  alert("obj"+obj);
					$.each(obj, function(key, value) {
						
						
						
						 if(hkey==1){
							 
							// (parseInt(resselectedDistrict)==parseInt(value.districtId)) &&
							
								
								if( (parseInt(resselectedDistrict)==parseInt(value.districtId))){	
									//alert(value.mandalCode+"coming1"+resselectedMandal);
									$('#resdistrictId').append( '<option value="'+parseInt(value.districtId)+'" selected="selected" > '+value.districtName+'</option>' );
								}
								if(resselectedDistrict==null||resselectedDistrict!=parseInt(value.districtId)){
								//	alert("coming2");
									$('#resdistrictId').append( '<option value="'+parseInt(value.districtId)+'"  > '+value.districtName+'</option>' );
								
								}
								
				  					
			  	  				$('#resdistrictId').multiselect('rebuild');
			  	  				
								  }
						
						
					});
					
					 // alert(response+"response1");
					
	    	  } 

	      },
	      error : function(request){
	    	  alert(error);
	      }
	  });	
	} 


function getMandals(b,hkey){
	
	//alert("kal"+b);
	
	var districtId=0;
if(hkey==1){
	
	 districtId=b;
	
}


		//document.getElementById("districtId").value;
	
	//alert("districtId"+districtId);

	$.ajax({	          
	      url: "../web/getMandals?districtId="+districtId,
	      type: "GET",
	      success: function (response) {
	    	  
	    	//  console.log(response);
	    	  
	    	  if(response!=null){
	    	  
	    	  if(hkey==1){
	    	  var $select = $('#resmandalId');
			  $select.find('option').remove();
			  
			  var resselectedMandal=$('#resselectedMandalId').val();
			  
			  
			  
			//  var resselectedDistrict=$('#resselectedDistrictId').val();
		 // alert("selected district"+resselectedDistrict);
			  
			 // alert("resselectedMandal"+resselectedMandal);
			 
			  $('#resmandalId').append( '<option value=" "> --select--</option>' );
			  
	    	  }
	    	  
	    	
	    	  
	    	  //alert("response"+response);
					var obj = JSON.parse(response);
					//  alert("obj"+obj);
					$.each(obj, function(key, value) {
						
						
						
						 if(hkey==1){
							 
							// (parseInt(resselectedDistrict)==parseInt(value.districtId)) &&
							
								
								if( (parseInt(resselectedMandal)==parseInt(value.mandalCode))){	
									//alert(value.mandalCode+"coming1"+resselectedMandal);
									$('#resmandalId').append( '<option value="'+parseInt(value.mandalCode)+'" selected="selected" > '+value.mandalName+'</option>' );
								}
								if(resselectedMandal==null||resselectedMandal!=parseInt(value.mandalCode)){
								//	alert("coming2");
									$('#resmandalId').append( '<option value="'+parseInt(value.mandalCode)+'"  > '+value.mandalName+'</option>' );
								
								}
								
				  					
			  	  				$('#resmandalId').multiselect('rebuild');
			  	  				
								  }
						
						
					});
					
					 // alert(response+"response1");
					
	    	  } 

	      },
	      error : function(request){
	    	  alert(error);
	      }
	  });	
	} 

	function getVillages(dcode,mcode,hkey){
		//alert("kal");
		//var districtId=document.getElementById("districtId").value;
		//var mandalId=mandal;
			//document.getElementById("mandalId").value;
		//alert(mandalId);
		
		var mcode=parseInt(mcode);
	
		  $.ajax({	          
	      url: "../web/getVillages?dcode="+dcode+"&mcode="+mcode,
	      type: "GET",
	      success: function (response) {
	    	
	    	
	    	if(hkey==1){
	    	  var $select = $('#resvillageId');
	    	 
			  $select.find('option').remove();
			  
			 
			  var canselectedVillage=$('#resselectedVillageId').val();
			 
					var obj = JSON.parse(response);
					  $('#resvillageId').append( '<option value="0"> --select--</option>' );
	    	}
	    	
					  
					$.each(obj, function(key, value) {
						
						if(hkey==1){
							
							if(canselectedVillage==parseInt(value.villageCode)){	
								$('#resvillageId').append( '<option value="'+parseInt(value.villageCode)+'" selected="selected" > '+value.villageName+'</option>' );
							
							}
							
							if(canselectedVillage==null||canselectedVillage!=parseInt(value.villageCode)){
								//alert("coming2");
								$('#resvillageId').append( '<option value="'+parseInt(value.villageCode)+'" > '+value.villageName+'</option>' );
							
							}
						
							$('#resvillageId').append( '<option value="'+parseInt(value.villageCode)+'" > '+value.villageName+'</option>' );
					
	  	  				$('#resvillageId').multiselect('rebuild');
	  	  				
						}
						
					});
	    	 

	      },
	      error : function(){
	    	  alert(error);
	      }
	  }); 	
	}
	
	function getresgenchecklist(countnum,buttonid){
		
		//alert("buttonid"+buttonid);
		
		$(".resmainobsinf").hide();
		 $(".resannvieweditdata").hide();
		
		
		
		var checkListView1= "#resmainobs"+countnum
		var checkListDataView2="#annvieweditinf"+countnum
		
		$(checkListView1).show();
		
		var buttonId="#"+buttonid;
		
		var result=$(buttonId).hasClass("shviewinf");
		
		
		if (result==true) {
			
		//	alert("i am in if"+result);
			 $(checkListDataView2).show();
			}else{
				
				 $(checkListDataView2).hide();
				 
				// alert("i am in else");
				
			}
		
		
		
		
	
			
			
			
		
		
		
		
         
       	
    		         
		
	}
	
	//start of nrld functions 
	
	
	function getDistricts(hkey){
		
		//alert("kal"+b);



		$.ajax({	          
		      url: "../invtsimis/get-districts",
		      type: "GET",
		      success: function (response) {
		    	  
		    	 // console.log(response);
		    	  
		    	  if(response!=null){
		    	  
		    	  if(hkey==1){
		    	  var $select = $('#resdistrictId');
				  $select.find('option').remove();
				  
				  var resselectedDistrict=$('#resselectedDistrictId').val();
				  
				  
			
				 
				  $('#resdistrictId').append( '<option value=" "> --select--</option>' );
				  
		    	  }
		    	  
		    
		    	  
		    	
						var obj = JSON.parse(response);
					
						$.each(obj, function(key, value) {
							
							
							
							 if(hkey==1){
								 
								
								
									
									if( (parseInt(resselectedDistrict)==parseInt(value.districtId))){	
									
										$('#resdistrictId').append( '<option value="'+parseInt(value.districtId)+'" selected="selected" > '+value.districtName+'</option>' );
									}
									if(resselectedDistrict==null||resselectedDistrict!=parseInt(value.districtId)){
									
										$('#resdistrictId').append( '<option value="'+parseInt(value.districtId)+'"  > '+value.districtName+'</option>' );
									
									}
									
					  					
				  	  				$('#resdistrictId').multiselect('rebuild');
				  	  				
									  }
							
							
						});
						
						 // alert(response+"response1");
						
		    	  } 

		      },
		      error : function(request){
		    	  alert(error);
		      }
		  });	
		} 


	function getMandals(b,hkey){
		
	
		
		var districtId=0;
	if(hkey==1){
		
		 districtId=b;
		
	}

	

		$.ajax({	          
		      url: "../web/getMandals?districtId="+districtId,
		      type: "GET",
		      success: function (response) {
		    	  
		    	//  console.log(response);
		    	  
		    	  if(response!=null){
		    	  
		    	  if(hkey==1){
		    	  var $select = $('#resmandalId');
				  $select.find('option').remove();
				  
				  var resselectedMandal=$('#resselectedMandalId').val();
				  
				  
				  
				//  var resselectedDistrict=$('#resselectedDistrictId').val();
			 // alert("selected district"+resselectedDistrict);
				  
				 // alert("resselectedMandal"+resselectedMandal);
				 
				  $('#resmandalId').append( '<option value=" "> --select--</option>' );
				  
		    	  }
		    	  
		    
		    	
						var obj = JSON.parse(response);
						//  alert("obj"+obj);
						$.each(obj, function(key, value) {
							
							
							
							 if(hkey==1){
								 
								// (parseInt(resselectedDistrict)==parseInt(value.districtId)) &&
								
									
									if( (parseInt(resselectedMandal)==parseInt(value.mandalCode))){	
										//alert(value.mandalCode+"coming1"+resselectedMandal);
										$('#resmandalId').append( '<option value="'+parseInt(value.mandalCode)+'" selected="selected" > '+value.mandalName+'</option>' );
									}
									if(resselectedMandal==null||resselectedMandal!=parseInt(value.mandalCode)){
									//	alert("coming2");
										$('#resmandalId').append( '<option value="'+parseInt(value.mandalCode)+'"  > '+value.mandalName+'</option>' );
									
									}
									
					  					
				  	  				$('#resmandalId').multiselect('rebuild');
				  	  				
									  }
							
							
						});
						
						 // alert(response+"response1");
						
		    	  } 

		      },
		      error : function(request){
		    	  alert(error);
		      }
		  });	
		} 

		function getVillages(dcode,mcode,hkey){
			//alert("kal");
			//var districtId=document.getElementById("districtId").value;
			//var mandalId=mandal;
				//document.getElementById("mandalId").value;
			//alert(mandalId);
			
			var mcode=parseInt(mcode);
		
			  $.ajax({	          
		      url: "../web/getVillages?dcode="+dcode+"&mcode="+mcode,
		      type: "GET",
		      success: function (response) {
		    	
		    	
		    	if(hkey==1){
		    	  var $select = $('#resvillageId');
		    	 
				  $select.find('option').remove();
				  
				 
				  var resselectedVillageId=$('#resselectedVillageId').val();
				 
						var obj = JSON.parse(response);
						  $('#resvillageId').append( '<option value="0"> --select--</option>' );
		    	}
		    	
						$.each(obj, function(key, value) {
							
							if(hkey==1){
								
								if(resselectedVillageId==parseInt(value.villageCode)){	
									$('#resvillageId').append( '<option value="'+parseInt(value.villageCode)+'" selected="selected" > '+value.villageName+'</option>' );
								
								}
								
								if(resselectedVillageId==null||resselectedVillageId!=parseInt(value.villageCode)){
									//alert("coming2");
									$('#resvillageId').append( '<option value="'+parseInt(value.villageCode)+'" > '+value.villageName+'</option>' );
								
								}
							
								
						
		  	  				$('#resvillageId').multiselect('rebuild');
		  	  				
							}
							
								
						
		  	  			
							
						});
		    	 

		      },
		      error : function(){
		    	  alert(error);
		      }
		  }); 	
		}
		
		function updateReservoirLocation(){
			
			//alert("UpdateSeaAyacutInfo");
			
			var resId= $('#reservoirId').val();
			
			if ($('form[id=addresloc]').parsley().isValid()) {
			
			var finaldatatoSend=$('form[id=addresloc]').serialize();
			
				 
				 $.ajax({	          
						url: "../invtsimis/update_res_location" ,
						method:"GET",
						dataType: 'json',

						async: false,
						   data:finaldatatoSend,


						success: function (obj) {

							  
							if(obj>0 ){
								
								 $('#action_alert').html('<p style="margin: 0px !important;">Updated Data Successfully</p>');
								 $("html,body").animate({scrollTop:0}, 500);
								 
								  $('#addresloc').trigger("reset"); 
								 $('#addresloc_dialogue').dialog('close');
								 
								 
								 $('#districtNameres').val('');
								 $('#mandalNameres').val('');
								 $('#villageNameres').val('');
								 
								 getResList(resId);
								 
								// document.getElementById('rescaptcha_id').src = '../captcha2.jpg?' + Math.random(); 
								
								 
								}
								
								if(obj==0 || obj==null){
									 $('#action_alert').html('<p style="margin: 0px !important;">Failed to Update data</p>');
									 $("html,body").animate({scrollTop:0}, 500);
								} 
								
								
								 if(obj==-3){
							    		
							    		$('#action_alert').html('<p style="margin: 0px !important;">Please Enter the Captcha Text </p>'); 
							    		
							    	}
							    	
			                   if(obj==-2){
							    		
							    		$('#action_alert').html('<p style="margin: 0px !important;">Captcha does not match </p>'); 
							    		 $("html,body").animate({scrollTop:0}, 500);
							    		
							    	}
							    	
					
						},
						error : function(){
							 alert(error);

						}
						}); 
				 
			}else{
		    	 
		    	 $('form[id=addresloc]').parsley().validate();
		    	 
		     }
			
		}
		
		function getResList(resId){
			
			// var projectId =   $('#projectId').val();  
					 
					
					//alert("projectId"+projectId);
					
							$.ajax({	          
							      url: "../invtsimis/get-res-location",
							      method:"POST",
								   dataType: 'json',				
							      async: false,
							      data: {reservoirId:resId},
							      success: function (msg) {
							    	  
							    
							    	 var msglen=msg.length;
							    	 
							    	// var resstatus=msg[0].resStatusId;
							    	 
							    	// alert("msglen"+msglen);
							    	
								    	
								if( msglen>0){	
									
									
		//alert("i am inside");
												
									$('#resmaindistrictName').val(msg[0].districtName); 
							    	$('#resmainmandalName').val(msg[0].mandalName);  
							    	
							    	if(msg[0].villageId>0){
							    	$('#resmainvillageName').val(msg[0].villageName);
							    	}
							    	
							    	if(msg[0].villageId==0){
								    	$('#resmainvillageName').val(msg[0].remarksVillage);
								    	}
							    	
							    	
							    	
							  		 var districtId=msg[0].districtId;
							  		 
							  		 var mandalId=msg[0].mandalId;
							  		 
							  		 var villageId=msg[0].villageId;
							  		 
							  		 var remarksVillage=msg[0].remarksVillage;
							  		 
							  		 var projectId=msg[0].projectId;
							  		 
							  		var nrldCode=msg[0].nrldCode;
							  		 
							  		
							  		 
							  		//alert("projectId"+projectId);
							  		 
							  
							  			  
							  		
							  		//$('#resProjectId').val(projectId);
							  		
							  	
							  		if(parseInt(districtId)>0){
							  			
							  			// $('#frm20').show();
								  		$('#resdistrictId').val(districtId);
								  		
								  		$('#resdistrictId').multiselect('rebuild');
								  		
								  		$('#resselectedDistrictId').val(districtId);
								  		
								  		
								  		
								  		
								  		$('#resselectedMandalId').val(mandalId);
								  		$('#resselectedVillageId').val(villageId);
								  		
								  		$('#resMainDistrictId').val(villageId);
								  		
								  		$('#respic').val(nrldCode);
								  		
								  		
								  		
								  		
								  		getMandals(parseInt(districtId),1);
								  		
								  		getVillages(parseInt(districtId),mandalId,1)
								  		
								  		
								  		}
							  		
							  		//alert("remarksVillage"+remarksVillage);
							  		
							  		$('#resreamarksVillageName').val(remarksVillage);
							  	
										
							    	
							    	
							    	
							    	
								}	
								
								if(msglen==0 ){	  
									
									//alert("i am elsside");
									
									$('#resmaindistrictName').val(''); 
							    	$('#resmainmandalName').val('');  
							    	
							    
							    	$('#resmainvillageName').val('');
							    	
							    	$('#resMainDistrictId').val(0);
							    	
							    
							    	$('#resdistrictId').val(0);
							  		$('#resdistrictId').multiselect('rebuild');
							  		
							  		$('#resselectedDistrictId').val(0);
							  		
							  		
							  		$('#resmandalId').each(function () {
							    	    
					    	            $(this).removeAttr("selected");
					    	          
					    	            return;
					    	       
								}); 
							  		
							  		$('#resmandalId').val(0);
							  		
							  		$('#resmandalId').multiselect('rebuild');
							  		
			                          $('#resvillageId').each(function () {
							    	    
					    	            $(this).removeAttr("selected");
					    	          
					    	            return;
					    	       
								}); 
			                          $('#resvillageId').val(0);
							  		
							  		$('#resvillageId').multiselect('rebuild');
							  		
							    
							    	  $('#addresloc').trigger("reset"); 
							    	
								}	 

							      },
							      error : function(){
							    	  alert(error);
							      }
							  });
							
					
					  
					
					
					
				}
	
	function addnrldchecksann1(formId){
	
		
		var formId = formId		
		 
		 var customformid="#"+formId;
	
		
		   var newyear=$("#year").val();
		
		$('#action_alert').empty();

	
		
			
			
			
		if ($('form[name=mainformname]').parsley().isValid()) {  	
				
				alert("kal2");
		if ($('form[id=' + formId + ']').parsley().isValid()) {

			alert("kal3");

		

			$
					.ajax({
						url : "../invtsimis/addnrldchecksAnn1",
						method : "POST",
						async : false,
						data : $(
								'form[id=' + formId
										+ ']').serialize(),

						success : function(response) {
							
							//var len=response.length;

							//alert("kal"+len);
						

							if (response >0) {

								// $('#ayacut-dailogue').dialog('close'); 

								 $('#action_alert').html('<p style="margin: 0px !important;">Data inserted Successfully</p>');
									$("html,body").animate({scrollTop:$('#action_alert').offset().top-175}, 500);
									
									 $(customformid).trigger("reset"); 	
									 
									 getresmst2mst1byfreqyear();
									 
									 
							}
							
							
						
							if (response == 0 ||response ==null ) {
								
								//alert("kal2"+response);

								 $('#action_alert').html('<p style="margin: 0px !important;">Failed to Update data</p>');
						    		$("html,body").animate({scrollTop:$('#action_alert').offset().top-175}, 500);
							}
                           if (response == -3 ) {
								
							//	alert("ka3"+response);

								 $('#action_alert').html('<p style="margin: 0px !important;">Already submitted</p>');
						    		$("html,body").animate({scrollTop:$('#action_alert').offset().top-175}, 500);
							}
							
							
							
							
							
							 // alert("kal");
						
							 
							 // alert("kal");
							 
							/*  if((formname=='resform1name')||(formname=='resform2name')||(formname=='resform3name')||(formname=='resform4name')){
							    	
								    
					               // $("#d")[0].reset() 
							// alert("i am in form 1");
							    
							 
							    getann1inspectdata(newyear);
							 
							// alert("after in form 1");
							    }*/

							//getResRegAyacutByResCode(response);

							//  alert(finYear);

							//  $('#action_alert').dialog('open'); 

							// getunitData(unitId,circleId,divisionId) ;

						},

						error : function() {
							alert(error);

						}

					});

			
		}else {
			
			$('form[id=' + formId + ']').parsley().validate();
			//alert("kal4");
		}
		
		}else {
			
			$('form[name=mainformname]').parsley().validate();
			//alert("kal4");
		}

	
		
		
	}
	
function AddRemarksInfo(formId){
		
	
	var formId = formId		
	 
	 var customformid="#"+formId;

	
	$('#action_alert').empty();


			if ($('form[name=mainformname]').parsley().isValid()) {  
				
		//alert("kal2 insert remarksmst1");
		if ($('form[id='+formId+']').parsley()
				.isValid()) {		 
	    $.ajax({	          
	url: "../invtsimis/AddAnnRemarks" ,
	method:"POST",
	dataType: 'json',

	async: false,
	data: $('form[id=' + formId+ ']').serialize() ,


	success: function (response) {

		  
		//  console.log(response);
		
		if(response>0){
		  
		  $('#reviewformremann1').trigger("reset"); 
		  
		 

		  $('#action_alert').html('<p style="margin: 0px !important;">Data Inserted Successfully</p>');
		  $("html,body").animate({scrollTop:0}, 500);
		  
		  getDamRemarksinfo();
		  
		}
		
		if(response==-1){
			  
			  $('#reviewformremann1').trigger("reset"); 
			  
			 

			  $('#action_alert').html('<p style="margin: 0px !important;">please add Inspection Details</p>');
			  $("html,body").animate({scrollTop:0}, 500);
			  
			}
		
		
		if(response==0 || response==null){
			
			

			  $('#action_alert').html('<p style="margin: 0px !important;">Failed to Insert</p>');
			  $("html,body").animate({scrollTop:0}, 500);
			
			
		}
		   
		//  gettankfeeddata(tankId) ; 
		

	},
	error : function(){
		 alert(error);

	}
	}); 	
		 }else {
				
				$('form[id='+formId+']').parsley().validate();
				//alert("kal4");
				
		} 
			

		}else {
		 
			$('form[name=mainformname]').parsley().validate();
		}

	}


function AddInspectionInfo(formId){
		
	
	var formId = formId		
	 
	 var customformid="#"+formId;

	
	$('#action_alert').empty();


			if ($('form[name=mainformname]').parsley().isValid()) {  
				
		//alert("kal2 insert inspection info");
		if ($('form[id='+formId+']').parsley()
				.isValid()) {		 
	    $.ajax({	          
	url: "../invtsimis/AddNrldInspectionInfo" ,
	method:"POST",
	dataType: 'json',

	async: false,
	data: $('form[id=' + formId+ ']').serialize() ,


	success: function (response) {

		  
		//  console.log(response);
		
		if(response>0){
		  
		  $('#addinspect').trigger("reset"); 
		  
		 

		  $('#action_alert').html('<p style="margin: 0px !important;">Data Inserted Successfully</p>');
		  $("html,body").animate({scrollTop:0}, 500);
		  
		  getResInspectioninfo();
		  
		}if(response==0 || response==null){
			
			

			  $('#action_alert').html('<p style="margin: 0px !important;">Failed to Insert</p>');
			  $("html,body").animate({scrollTop:0}, 500);
			
			
		}
		   
		//  gettankfeeddata(tankId) ; 
		

	},
	error : function(){
		 alert(error);

	}
	}); 	
		 }else {
				
				$('form[id='+formId+']').parsley().validate();
				//alert("kal4");
				
		} 
			

		}else {
		 
			$('form[name=mainformname]').parsley().validate();
		}

	}





function AddRecommendationInfo(formId){
		
	
	var formId = formId		
	 
	 var customformid="#"+formId;

	
	$('#action_alert').empty();


		
		//alert("kal2 recommendatiion info");
		if ($('form[id='+formId+']').parsley()
				.isValid()) {		 
	    $.ajax({	          
	url: "../invtsimis/AddNrldRecommendationInfo" ,
	method:"POST",
	dataType: 'json',

	async: false,
	data: $('form[id=' + formId+ ']').serialize() ,


	success: function (response) {

		  
		//  console.log(response);
		
		if(response>0){
		  
		  $('#addrecpmmend').trigger("reset"); 
		  
		 

		  $('#action_alert').html('<p style="margin: 0px !important;">Data Inserted Successfully</p>');
		  $("html,body").animate({scrollTop:0}, 500);
		  
		}if(response==0 || response==null){
			
			

			  $('#action_alert').html('<p style="margin: 0px !important;">Failed to Insert</p>');
			  $("html,body").animate({scrollTop:0}, 500);
			
			
		}
		   
		//  gettankfeeddata(tankId) ; 
		

	},
	error : function(){
		 alert(error);

	}
	}); 	
		 }else {
				
				$('form[id='+formId+']').parsley().validate();
				//alert("kal4");
				
		} 
			

		

	}






function getresmst2mst1byfreqyear(){
	
	$(".annbuttoninf").removeClass('shviewinf');
	
	// $('#action_alert').html('');
	
	/* $( ".editemb" ).each(function() {
		 if($(".editemb").hasClass('eact1')){	                    
				var embid=$(this).prop('id');			    				
				//alert("sluid"+sluid);
				
				var newembid="#"+embid;		    				
        
				  $(newembid).removeClass('eact1');	    				 
				   
				   $(newembid).removeAttr('style') ;			    					   
					 //  alert("newsluid"+newsluid);
					   $(newembid).css("display", "none");
					   
	}
		});*/
	 
	/* $( ".deleteemb" ).each(function() {
		 if($(".deleteemb").hasClass('dact2')){                    
				var delemb=$(this).prop('id');			    				
				//alert("sluid"+sluid);
				
				var newdelemb="#"+delemb;		    				
        
				  $(newdelemb).removeClass('dact2');	    				 
				   
				   $(newdelemb).removeAttr('style') ;			    					   
					 //  alert("newsluid"+newsluid);
					   $(newdelemb).css("display", "none");
					   
	}
		});
	 
	*/
 
	//alert("i am here")

	
	var year= $('#year').val();
	
	var reservoirId=$('#resId').val();
	
	
	
	var tankId=$('#tankId').val();
	
	//alert("tankId"+tankId);
	
	var dutyFrequencyId=$('#dutyFrequencyId').val();
	var conditionofDamId=$('#conditionofDamId').val();
	
	//alert(conditionofDamId);
	
	if(year>0){
	
	$.ajax({	          
	      url: "../invtsimis/getresmst2mst1byyearfreq",
	      type: "GET",
	      data:{
	    	  year:year,
	    	  reservoirId:reservoirId,
	    	  dutyFrequencyId:dutyFrequencyId,
	    	 
	    	  tankId:tankId
	      },
	      contentType: "application/json; charset=utf-8",
	      success: function (msg) {
	    	  
	    	 console.log(msg);
	    		//alert('kalhere1') 
	    	 
	    	 if(msg===null||msg===0 || msg==='[]'){
		    		
		    		//alert('coming here in year mst2 inspect msg null')
	    		  
	    		  $('#action_alert').html(''); 
	    		  
	    		
		    		  
		    		
	    	 } 
		    	
	    	 
	    	
	    	if(msg!=null){  
	    		
	    	
	    		 // alert("msg"+msg);
		    	  
		    	 
	    		
	    		//alert('kalhere')
	    		  var obj = JSON.parse(msg);
	    		
	    		if(obj!=null){
	    			
	    			
	    		
			  
			    		
			    		
	    		  
	    		 
	    		  
	    		
	    		
		    	
		    	    
		    	 
		    		 
	    		
	    	  for(i in obj){
	    		  
	    		  var dbcheckid=obj[i].resCheckId;
	    		  
	    		  var dbcatid=obj[i].resCategoryId;
	    		  
	    		  
	    		  var dbremarks=obj[i].remarks;
	    		  var dbchfrom=obj[i].irrChFrm;
	    		  var dbchto=obj[i].irrChTo;
	    		  
	    		  var buttonid="#"+"annobs"+dbcheckid
	    		  
	    		  
	    		  var dbmst1=obj[i].resInspectMst1Id;
	    		  var dbmst2=obj[i].resInspectMst2Id;
	    		  
	    		  var dbresCheckName=obj[i].resCheckName;
	    		  
	    		  var dbinstalledcount=obj[i].installedcount;
	    		  
	    		  var dblocation=obj[i].location;
	    		  
	    		  var dbinstallmonth=obj[i].installmonth;
	    		  
	    		  var dbworkingcondition=obj[i].workingcondition;
	    		  
	    		  var dbdatelastCalibrated=obj[i].datelastCalibrated ;
	    		  
	    		  var dbdatenextCalibrated=obj[i].datenextCalibrated ;
	    		  
	    		  var dbobsmaintained=obj[i].obsmaintained;
	    		  
	    		  var dbanalysisofdata=obj[i].analysisofdata;
	    		  
	    		  
	    		  
	    		  var dbagencyresponsible=obj[i].agencyresponsible;
	    		  
	    		  var dbdatasenttoDSO=obj[i].datasenttoDSO;
	    		  
	    		  var dbdamcheckResponseId=obj[i].damcheckResponseId;
	    		  
	    		  var dbconditionofCheckId=obj[i].conditionofCheckId;
	    		  
	    		  var dbconditionofDamId=obj[0].conditionofDamId;
	    		  
	    		 // alert("dbconditionofDamId"+dbconditionofDamId);
	    		  
	    		  
	    		  var conditionofDamId="#conditionofDamId"
			    		$(conditionofDamId).val(dbconditionofDamId);
	    		  
	    			$(conditionofDamId).multiselect('rebuild');
	    		  
	    		  
	    			
	    			$("#editDamStatus12").show(); 
	    		  
	    		 // alert("dbcheckid"+dbcheckid);
	    		  
	    		  var viewremarks="#"+"remarks"+dbcheckid ;
	    		  
	    		  var viewchfrom="#"+"irrChFrm"+dbcheckid ;
	    		  
	    		  var viewchto="#"+"irrChTo"+dbcheckid ;
	    		  
	    		  
	    		  var hiddenann2mst1Id="#"+"ann2mst1Id"+dbcheckid
	    		  var hiddenann2mst2Id="#"+"ann2mst2Id"+dbcheckid
	    		  
	    		  var hiddenhealthmst1Id="#healthmst1Id";
	    		  var hiddenhealthmst2Id="#healthmst2Id";
	    		  
	    		  var hiddenatsmst1Id="#atsnewmst1Id";
	    		  var hiddenatsmst2Id="#atsnewmst2Id";
	    		  
	    		  var viewresCheckName="#"+"resCheckName"+dbcheckid ;
	    		  
	    		  var viewinstalledcount="#"+"installedcount"+dbcheckid ;
	    		  
	    		  var viewlocation="#"+"location"+dbcheckid ;
	    		  
	    		  var viewinstallmonth="#"+"installmonth"+dbcheckid ;
	    		  
	    		  var viewworkingconditionn="#"+"workingconditionn"+dbcheckid ;
	    		  var viewworkingconditiony="#"+"workingconditiony"+dbcheckid ;
	    		  
	    		  var viewdatelastCalibrated="#"+"datelastCalibrated"+dbcheckid ;
	    		  
	    		  var viewdatenextCalibrated="#"+"datenextCalibrated"+dbcheckid ;
	    		  
	    		  var viewobsmaintainedn="#"+"obsmaintainedn"+dbcheckid ;
	    		  var viewobsmaintainedy="#"+"obsmaintainedy"+dbcheckid ;
	    		  
	    		  var viewagencyresponsiblen="#"+"agencyresponsiblen"+dbcheckid ;
	    		  var viewagencyresponsibley="#"+"agencyresponsibley"+dbcheckid ;
	    		  
	    		  var viewanalysisofdatan="#"+"analysisofdatan"+dbcheckid ;
	    		  var viewanalysisofdatay="#"+"analysisofdatay"+dbcheckid ;
	    		  
	    		  var viewdatasenttoDSOn="#"+"datasenttoDSOn"+dbcheckid ;
	    		  var viewdatasenttoDSOy="#"+"datasenttoDSOy"+dbcheckid ;
	    		  
	    		  var viewdamcheckResponseIdn="#"+"damcheckResponseIdn"+dbcheckid ;
	    		  var viewdamcheckResponseIdy="#"+"damcheckResponseIdy"+dbcheckid ;
	    		  
	    		  var viewdamcheckResponseIdna="#"+"damcheckResponseIdna"+dbcheckid ;
	    		  
	    		  var viewconditionofCheckId="#"+"conditionofCheckId"+dbcheckid ;
	    		  
	    		  
	    		  
	    		
	    		  
	    		  
	    		  
	    		  
	    		  
	    		 $(".mainresInspectMst1Id").val(dbmst1); 
	    		  
	    		  $(hiddenann2mst1Id).val(dbmst1); 
	    		  $(hiddenann2mst2Id).val(dbmst2); 
	    		  
	    		  $(hiddenhealthmst1Id).val(dbmst1); 
	    		  $(hiddenhealthmst2Id).val(0); 
	    		  
	    		  
	    		  $(hiddenatsmst1Id).val(dbmst1); 
	    		  $(hiddenatsmst2Id).val(0); 
	    		  
	    		  
	    		  
	    		  
	    		  
	    		  		
	    		  
	    		  $(buttonid).css('background-color', 'green');
	    		  
	    		  $(buttonid).addClass("shviewinf");
	    		  
	    		  $(viewremarks).val(dbremarks); 
	    		  
	    		  $(viewremarks).attr("readonly" , true); 
	    		  
	    		  
                    $(viewchfrom).val(dbchfrom); 
	    		  
	    		  $(viewchfrom).attr("readonly" , true); 
	    		  

                  $(viewchto).val(dbchto); 
	    		  
	    		  $(viewchto).attr("readonly" , true); 
	    		  
                     $(viewchto).val(dbchto); 
                     
                   $(viewresCheckName).val(dbresCheckName); 	    		  
	    		  $(viewresCheckName).attr("readonly" , true); 
	    		  
	    		  $(viewinstalledcount).val(dbinstalledcount); 	    		  
	    		  $(viewinstalledcount).attr("readonly" , true); 
	    		  
	    		  $(viewlocation).val(dblocation); 	    		  
	    		  $(viewlocation).attr("readonly" , true); 
	    		  
	    		  $(viewinstallmonth).val(dbinstallmonth); 	    		  
	    		  $(viewinstallmonth).attr("readonly" , true); 
	    		  
	    		  if(dbworkingcondition==false){
	    			  
	    		  $(viewworkingconditionn).prop("checked" , true); 
	    		  $(viewworkingconditionn).attr('disabled', true);
	    		  }
	    		  if(dbworkingcondition==true){
	    			  
		    		  $(viewworkingconditiony).prop("checked" , true); 
		    		  $(viewworkingconditiony).attr('disabled', true);
		    		  }
	    		  
	    		  $(viewdatelastCalibrated).val(dbdatelastCalibrated); 	    		  
	    		  $(viewdatelastCalibrated).attr("readonly" , true); 
	    		  
	    		  $(viewdatenextCalibrated).val(dbdatenextCalibrated); 	    		  
	    		  $(viewdatenextCalibrated).attr("readonly" , true); 
	    		  
	    		  $(viewdatenextCalibrated).val(dbdatenextCalibrated); 	    		  
	    		  $(viewdatenextCalibrated).attr("readonly" , true); 
	    		  
	    		  if(dbagencyresponsible==false){
	    				  
	    		  $(viewagencyresponsiblen).prop("checked" , true); 
	    		  $(viewagencyresponsiblen).attr('disabled', true);
	    		  }
	    		  if(dbagencyresponsible==true){
    				  
		    		  $(viewagencyresponsibley).prop("checked" , true); 
		    		  $(viewagencyresponsibley).attr('disabled', true);
		    		  }
	    		  
	    		  if(dbanalysisofdata==false){
	    		
	    		  $(viewanalysisofdatan).prop("checked" , true); 
	    		  $(viewanalysisofdatan).attr('disabled', true);
	    		  
	    		  }
	    		  if(dbanalysisofdata==true){
	  	    		
		    		  $(viewanalysisofdatay).prop("checked" , true); 
		    		  $(viewanalysisofdatay).attr('disabled', true);
		    		}
	    		  if(dbdatasenttoDSO==false){
	    		 		  
	    		  $(viewdatasenttoDSOn).prop("checked" , true); 
	    		  $(viewdatasenttoDSOn).attr('disabled', true);	
	    		  }
	    		  if(dbdatasenttoDSO==true){
    		 		  
		    		  $(viewdatasenttoDSOy).prop("checked" , true); 
		    		  $(viewdatasenttoDSOy).attr('disabled', true);	
		    		  }
	    		
	    		  if(dbobsmaintained==false){
    		 		  
		    		  $(viewobsmaintainedn).prop("checked" , true); 
		    		  $(viewobsmaintainedn).attr('disabled', true);	
		    		  }
		    		  if(dbobsmaintained==true){
	    		 		  
			    		  $(viewobsmaintainedy).prop("checked" , true); 
			    		  $(viewobsmaintainedy).attr('disabled', true);	
			    		  
			    		  }
	    		  
	    		  
	    		  
	    		
	    		  
	    		  if(dbdamcheckResponseId==1){
	    			  
	    			  $(viewdamcheckResponseIdn).prop("checked" , true);   
                         $(viewdamcheckResponseIdy).prop("checked" , false);  	    			  
	    			  $(viewdamcheckResponseIdna).prop("checked" , false);
	    			  $(viewdamcheckResponseIdn).prop("disabled" , true);   
	    			  
	    		  }else if(dbdamcheckResponseId==2){
	    			  
	    			  $(viewdamcheckResponseIdn).prop("checked" , false);   
                      $(viewdamcheckResponseIdy).prop("checked" , true);   
	    			  
	    			  $(viewdamcheckResponseIdna).prop("checked" , false); 
	    			  $(viewdamcheckResponseIdy).prop("disabled" , true);   
	    			 
	    		  }else if (dbdamcheckResponseId==3){
	    			  $(viewdamcheckResponseIdn).prop("checked" , false);   
                      $(viewdamcheckResponseIdy).prop("checked" , false);   
	    			  
	    			  $(viewdamcheckResponseIdna).prop("checked" , true); 
	    			  
	    			  $(viewdamcheckResponseIdna).prop("disabled" , true); 
	    			  
	    		  }
	    		  
	    		  
	    
			    
	    		  
	    		  $(viewconditionofCheckId).each(function () {
		    			 if ($(this).val() == dbconditionofCheckId) {
				    	        //	alert("equal"+actionrequirereq+"*"+obj[i].actionrequireqId+"--"+$(this).val());
				    	            $(this).attr("selected", "selected");
				    	            
				    	            var id = $(this).val();

				    	  		  $(viewconditionofCheckId).val(id);
				    	  		$(viewconditionofCheckId).attr('disabled', true);	
				    	  		 
				    	            
				    	        } 
				    	        if ($(this).val() != dbconditionofCheckId) {
				    	        	
				    	        	 $(this).removeAttr("selected");
				    	        	
				    	        }
		    	});
	    		  
	    		  
	    		  
	    		  
	    		 // getresgenchecklist(dbcheckid,2);
	    	  
	    	
	    	}//end of obj if not null
	    	
	    	
	    	
	    	
	    	
	    	  
	    	  
	    	} // end of if msg is not null
	    		
	    	}

	      },
	      error : function(){
	    	  alert(error);
	      }
	  });
	
	}else{
		
		$('#action_alert').html('<p style="margin: 0px !important;" >please select  Monsoon </p>'); 
		
	}
	
	
}

function addrecmmn (checkId,hkey){

		
		 $('#addrecommend_dialogue').dialog('option', 'title', 'Recommendations');
		  $('#addrecommend_dialogue').dialog('open');
	  
		  $('#addrecpmmend').trigger("reset"); 		  
		  
		if(( hkey==1 || hkey==2 ) ){
		  var fmst1Id="#ann2mst1Id"+checkId;
		  
		  var fmst2Id="#ann2mst2Id"+checkId;
		  
		  var dmst1Id=$(fmst1Id).val(); 
		  var dmst2Id=$(fmst2Id).val(); 
		  
		  $("#rec2resInspectMst1Id").val(dmst1Id); 
		  $("#rec2resInspectMst2Id").val(dmst2Id); 
		  
		}
		
	  
		
}


function addhealthrecmmn (healthId,hkey,officeId,officeName){
	//alert("addhealthrecmmn");

	
	 $('#addhealthremarks_dialogue').dialog('option', 'title', 'Remedial measures suggested');
	  $('#addhealthremarks_dialogue').dialog('open');
 
	  $('#addrecpmmendhealth').trigger("reset"); 		  
	  
	//  alert("officeName"+officeName);
	if( ( hkey==3)&& officeId>0){
		
		//alert("inspectOfiiceId2"+officeId);
		  var fmst1Id="#healthmst1Id";
		  
		  var fmst2Id="#healthmst2Id";
		  
		  var dmst1Id=$(fmst1Id).val(); 
		  var dmst2Id=$(fmst2Id).val(); 
		  
		
		  
		  
		  $("#healthresInspectMst1Id").val(dmst1Id); 
		  $("#healthresInspectMst2Id").val(dmst2Id); 
		  $("#healthresDamHealthId").val(healthId); 
		  
		  $("#healthOfficeInfoId").val(officeId); 
		  
		  
		  
		  $("#inspectInfo").val(officeName); 
		  
		
		  
		  
		  
		  
		}
	  
	  
	  
	  
	 
     
	
}


function getResInspectioninfo( ) {
	//alert("kal");
	//var districtId=document.getElementById("districtId").value;
	//var projectId = projectId ;

	//document.getElementById("divisionId").value;
	//alert(mandalId);
///changed projectId to unitId
	//$('#rec2inspectOfficeInfoId').multiselect('rebuild');
	//$('#healthinspectOfficeInfoId').multiselect('rebuild');	
	
var year= $('#year').val();
var tankId= $('#tankId').val();
var dutyFrequencyId= $('#dutyFrequencyId').val();
	
	var reservoirId=$('#resId').val();
	$.ajax({
		url : "../invtsimis/getresInspectInfo",
		type : "POST",
		data: {year :  year,
			reservoirId: reservoirId,
			tankId: tankId,
			dutyFrequencyId:dutyFrequencyId},
		success : function(response) {
			
				var $select = $('#rec2inspectOfficeInfoId');
				
				var $select1 = $('#healthinspectOfficeInfoId');
				
				var $select2 = $('#resatc71inspectDate');
				
				var $select3 = $('#reminspectOfficeInfoId');
				
				var $select4 = $('#inspectphtInfoId');
				
				
				
				
			
				
				
				

				$select.find('option').remove();
				$select1.find('option').remove();
				$select2.find('option').remove();
				
				$select3.find('option').remove();
				
				$select4.find('option').remove();

			
			var obj = JSON.parse(response);

			$('#rec2inspectOfficeInfoId').append(
					'<option value=" "> --select--</option>');
			
			$('#healthinspectOfficeInfoId').append(
			'<option value=" "> --select--</option>');
			
			$('#resatc71inspectDate').append(
			'<option value=" "> --select--</option>');
			
			$('#reminspectOfficeInfoId').append(
			'<option value=" "> --select--</option>');
			
			$('#inspectphtInfoId').append(
			'<option value=" "> --select--</option>');

			$.each(obj, function(key, value) {

				$('#rec2inspectOfficeInfoId').append(
						'<option value="'+value.resinspectInfoId+'" > '
								+ value.inspectOfficeName +' ('+value.inspectDate+') '+ '</option>');
              /*  if(value.resinspectInfoId==selectedhealthinspectofficeId){
				$('#healthinspectOfficeInfoId').append(
						'<option value="'+value.resinspectInfoId+'" selected="selected" > '
								+ value.inspectOfficeName +' ('+value.inspectDate+') '+ '</option>');
                }  if((value.resinspectInfoId!=selectedhealthinspectofficeId)||  (selectedhealthinspectofficeId==null)){
                */	
                	$('#healthinspectOfficeInfoId').append(
    						'<option value="'+value.resinspectInfoId+'"  > '
    								+ value.inspectOfficeName +' ('+value.inspectDate+') '+ '</option>');
                	
              /*  }*/
				$('#resatc71inspectDate').append(
						'<option value="'+value.resinspectInfoId+'" > '
								+ value.inspectOfficeName +' ('+value.inspectDate+') '+ '</option>');
				
				
				$('#reminspectOfficeInfoId').append(
						'<option value="'+value.resinspectInfoId+'" > '
								+ value.inspectOfficeName +' ('+value.inspectDate+') '+ '</option>');
				
				
				$('#inspectphtInfoId').append(
						'<option value="'+value.resinspectInfoId+'" > '
								+ value.inspectOfficeName +' ('+value.inspectDate+') '+ '</option>');
				
				
				/* if(selectedreservoirId==value.reservoirId){
				$('#reservoirId').append(
						'<option value="'+value.resCode+'" selected="selected" > '
								+ value.resName + '</option>');
				}
				if(selectedreservoirId==null || selectedreservoirId!=value.reservoirId){
				
					} */

				$('#rec2inspectOfficeInfoId').multiselect('rebuild');
				$('#healthinspectOfficeInfoId').multiselect('rebuild');				
				$('#resatc71inspectDate').multiselect('rebuild');
				
				$('#reminspectOfficeInfoId').multiselect('rebuild');
				
				$('#inspectphtInfoId').multiselect('rebuild');
				
				
			});

		},
		error : function() {
			alert(error);
		}
	});
}



function getResInspectionbyinspectinfoId(id ) {
	//alert("kal");
	
	

	$.ajax({
		url : "../invtsimis/getresInspectInfobyInspectInfo",
		type : "POST",
		data: {inspectOfficeInfoId :  id,
			},
		success : function(response) {
			
				
				
				
				
				

			

			
			var obj = JSON.parse(response);
			
			var resInspectMst1Id=obj[0].resInspectMst1Id;
			
			//alert("resInspectMst1Id"+resInspectMst1Id);
			
			$('.mainresInspectMst1Id').val(obj[0].resInspectMst1Id);

			

			/*$.each(obj, function(key, value) {

			
				
				
			});*/

		},
		error : function() {
			alert(error);
		}
	});
}




function getHealthRecommendationinfoId(id , mst1Id , mst2Id ) {
//	alert("kal");
	
	

	$.ajax({
		url : "../invtsimis/getresHealthRecommendations",
		type : "POST",
		data: {inspectOfficeInfoId :  id,
			resInspectMst1Id:mst1Id,
			resInspectMst2Id:mst2Id
			},
		success : function(response) {
			
		
			var obj = JSON.parse(response);
			
			var remarks=obj[0].remarks;
			var healthId=obj[0].resDamHealthId;
			var recommendId=obj[0].resannRecommendId;
			
			$('#resrecommendats').val(remarks);
			$('#atcresDamHealthId').val(healthId);
			$('#atcresRecommendId').val(recommendId);
			
			
			

			/*$.each(obj, function(key, value) {

			
				
				
			});*/

		},
		error : function() {
			alert(error);
		}
	});
}

function addresdamhealth(formId){
	
	
	
	
	var formId = formId		
	 
	 var customformid="#"+formId;

	
	$('#action_alert').empty();


		
		//alert("kal2 recommendatiion info");
		if ($('form[id='+formId+']').parsley()
				.isValid()) {		 
	    $.ajax({	          
	url: "../invtsimis/AddDamHealthStatusInfo" ,
	method:"POST",
	dataType: 'json',

	async: false,
	data: $('form[id=' + formId+ ']').serialize() ,


	success: function (response) {

		  
		//  console.log(response);
		
		if(response>0){
		  
		  $('#reshealthform5').trigger("reset"); 
		  
		 

		  $('#action_alert').html('<p style="margin: 0px !important;">Data Inserted Successfully</p>');
		  $("html,body").animate({scrollTop:0}, 500);
		  
		  getResDamHealthDetails();
		  
		}if(response==-1){
			
			

			  $('#action_alert').html('<p style="margin: 0px !important;">Please add Inspection details</p>');
			  $("html,body").animate({scrollTop:0}, 500);
			
			
		}if(response==-2){
			
			

			  $('#action_alert').html('<p style="margin: 0px !important;">Already data added (If any change please edit data.)</p>');
			  $("html,body").animate({scrollTop:0}, 500);
			
			
		}if(response==0 || response==null){
			
			

			  $('#action_alert').html('<p style="margin: 0px !important;">Failed to Insert</p>');
			  $("html,body").animate({scrollTop:0}, 500);
			
			
		}
		   
		//  gettankfeeddata(tankId) ; 
		

	},
	error : function(){
		 alert(error);

	}
	}); 	
		 }else {
				
				$('form[id='+formId+']').parsley().validate();
				//alert("kal4");
				
		} 
			

		
	
	
	
}


function getResDamHealthDetails( ) {
	
	
	$("#reshealthhead5").empty();
	$("#reshealthbody5").empty();
	
var year= $('#year').val();
	
	var reservoirId=$('#resId').val();
	
var tankId= $('#tankId').val();
	
	var dutyFrequencyId=$('#dutyFrequencyId').val();
	

	$.ajax({
		url : "../invtsimis/getresHealthDetails",
		type : "POST",
		data: {year :  year,
			reservoirId: reservoirId,
			tankId:tankId,
			dutyFrequencyId:dutyFrequencyId},
		success : function(response) {
			
			//alert("obj"+obj)
			
			//alert(obj[0].deficiencyCategoryName);
			
			 var j=1;
			
			var obj = JSON.parse(response);
			
			 $('#reshealth table thead').append( '<tr style="font-size: 18px; color: gray; font-weight: bold;"><th>Sl.No</th>'+
	    	    		
	    	    		'<th>Category</th>'+
	    	    		'  <th>Observations/Significant Deficiencies Noticed</th>'+
	    	    	
	    	    		/*'  <th>Latest</th>'+*/
	    	    		'  <th>Inspection info</th>'+
	    	    		
	    	    		'  <th>Edit / Delete </th>'+
	    	    		
	    	    		' <th>Remedial Measures Suggested </th>'+
	    	    		
	    	    	
	    	    		'</tr>'); 	  

			

			 for(i in obj){
	    	    	
	    	    	//var k=obj[i].tabId;
	    	    	var s= obj[i].postId ;
	    	    	
	    	    	//alert(obj[i].deficiencyCategoryName);
	    	    	
	    	    	var officeName="'"+obj[i].inspectOfficeName+"'" ;;
	    	    	
	    	    	   $('#reshealth table tbody').append(  '<tr style="font-size: 16px">' +
	    	    			                                '<td style="text-align: center;">'+j+'</td>' +
	    	    			                               
	    	    			                                '<td><b>'+obj[i].deficiencyCategoryName+'</b></td>' +
	    	    			                                
		    	    			                            
	    	    			                         
	    	    			                                
	    	    			                                '<td><b>'+obj[i].remarks+'</b></td>' +
	    	    			                                
	    	    			                                '<td><b>'+obj[i].inspectOfficeName+'</b></td>' +
	    	    			                                
	    	    			                                '<td><b><button type="button" name="editmst1remarks" id="editmst1remarks'+j+'" class="btn btn-1 btn-primary center-block mst1reedit" onclick=""  >Edit </button></b>'+
	    	    			                                '<br>'+
	    	    			                                '<b><button type="button" name="editmst1remarks" id="editmst1remarks'+j+'" class="btn btn-1 btn-primary center-block mst1reedit" onclick=""  >Delete </button>'+
	    	    			                                '</td>' +
	    	    			                                
	    	    			                               
	    	    			                            
	    	    			                                	    	    			                               
	    	    			                             /*(s==postId? */  '<td > <br>'+
	    	    			                                '<button type="button" name="editmst1remarks" id="editmst1remarks'+j+'" class="btn btn-1 btn-primary center-block mst1reedit" onclick="addhealthrecmmn('+obj[i].resDamHealthId+',3,'+obj[i].inspectOfficeInfoId+','+officeName+')"  >Add  Recommendations</button> &emsp; &emsp; '+
	    	    			                                '<button type="button" name="deletemst1remarksname" id="deletemst1remarks'+j+'" class="btn btn-1 btn-primary center-block mst1redelete " onclick=""  >View/ Edit Recommendations</button>&emsp;&emsp; '+
	    	    			                                '<button type="button" name="deletemst1remarksname" id="deletemst1remarks'+j+'" class="btn btn-1 btn-primary center-block mst1redelete " onclick=""  >Delete Recommendations</button></td>'+
	    	    			                                '<br>'+
	    	    	                                     '</tr>');
	    	    	   
	    	    	   
	    	    	  
	    	    	   
	    	    	
	    	    	  /* (k==1? '<td><b>Bund Remarks</b></td>': '')+
                       (k==2? '<td><b>Sluice Remarks</b></td>': '')+
                       (k==3? '<td><b>Weir Remarks</b></td>': '')+
                         */
	    	    	   
	    	    	  
	    	    	   j++;   
	    	    
	    	    }
			 
			 

		},
		error : function() {
			alert(error);
		}
	});
}


function getResDamHealthDetailsByInspectInfo(resinspectInfoId ) {
	
	var resinspectInfoId=resinspectInfoId;
	
	if(resinspectInfoId>0){
	

	$.ajax({
		url : "../invtsimis/getresHealthDataByInspectDate",
		type : "POST",
		data: {resinspectInfoId :  resinspectInfoId
			},
		success : function(response) {
			
			//alert("response"+response);
			
			//alert(obj[0].deficiencyCategoryName);
			
			 var j=1;
			
			var obj = JSON.parse(response);
			
			
          var category=obj[0].deficiencyCategoryName;
			var observations=obj[0].remarks;
			
			var atsmst1Id=obj[0].resInspectMst1Id;
			
			 var category=obj[0].deficiencyCategoryName;
			 
			 $('#atchealthcategory').val(category);
				
				$('#atchealthremarks').val(observations);
				
				
				$('#atsmst1Id').val(atsmst1Id);
			
				
				

			 

		},
		error : function() {
			alert(error);
		}
	});
	}else{
		
		
		return false;
	}
}
	
function  addactionStatusInfo(formId){
	
	
	
	
	var formId = formId		
	 
	 var customformid="#"+formId;

	
	$('#action_alert').empty();


		
		//alert("kal2 recommendatiion info");
		if ($('form[id='+formId+']').parsley()
				.isValid()) {		 
	    $.ajax({	          
	url: "../invtsimis/AddActiontakenStatusInfo" ,
	method:"POST",
	dataType: 'json',

	async: false,
	data: $('form[id=' + formId+ ']').serialize() ,


	success: function (response) {

		  
		//  console.log(response);
		
		if(response>0){
		  
		  $('#resatsform').trigger("reset"); 
		  
		 

		  $('#action_alert').html('<p style="margin: 0px !important;">Data Inserted Successfully</p>');
		  $("html,body").animate({scrollTop:0}, 500);
		  
		  getActionStatusDetails( );
		  
		}
		
		if(response==-1){
			
			

			  $('#action_alert').html('<p style="margin: 0px !important;">Please add Inspection Details and Dam Health Details including Recommendation</p>');
			  $("html,body").animate({scrollTop:0}, 500);
			
			
		}
		
		if(response==-2){
			
			

			  $('#action_alert').html('<p style="margin: 0px !important;">Already data added (If any change please edit data)</p>');
			  $("html,body").animate({scrollTop:0}, 500);
			
			
		}
		
		
		
		if(response==0 || response==null){
			
			

			  $('#action_alert').html('<p style="margin: 0px !important;">Failed to Insert</p>');
			  $("html,body").animate({scrollTop:0}, 500);
			
			
		}
		   
		//  gettankfeeddata(tankId) ; 
		

	},
	error : function(){
		 alert(error);

	}
	}); 	
		 }else {
				
				$('form[id='+formId+']').parsley().validate();
				//alert("kal4");
				
		} 
			

		
	
	
	
}


function getActionStatusDetails( ) {
	
	
	$("#resatshead7").empty();
	$("#resatsbody7").empty();
	
var year= $('#year').val();
	
	var reservoirId=$('#resId').val();
	
var tankId= $('#tankId').val();
	
	var dutyFrequencyId=$('#dutyFrequencyId').val();
	$.ajax({
		url : "../invtsimis/getActionTakenDetails",
		type : "POST",
		data: {year :  year,
			reservoirId: reservoirId,
			tankId:tankId,
			dutyFrequencyId:dutyFrequencyId},
		success : function(response) {
			
			//alert("obj"+obj)
			
			//alert(obj[0].deficiencyCategoryName);
			
			 var j=1;
			
			var obj = JSON.parse(response);
			
			 $('#acttaken table thead').append( '<tr style="font-size: 18px; color: gray; font-weight: bold;"><th>Sl.No</th>'+
	    	    		
	    	    		'<th>Inspect Info</th>'+
	    	    		'  <th>Action Initiated</th>'+
	    	    	
	    	    		/*'  <th>Latest</th>'+*/
	    	    		'  <th>Action Completed</th>'+
	    	    		
	    	    		
	    	    		
	    	    		' <th>Remarks for pending </th>'+
	    	    		
	    	    		' <th>Edit / Delete </th>'+
	    	    		
	    	    	
	    	    		'</tr>'); 	  

			

			 for(i in obj){
	    	    	
	    	    	//var k=obj[i].tabId;
	    	    	var s= obj[i].postId ;
	    	    	
	    	    	//alert(obj[i].deficiencyCategoryName);
	    	    	
	    	    	var officeName="'"+obj[i].inspectOfficeName+"'" ;
	    	    	
	    	    	   $('#acttaken table tbody').append(  '<tr style="font-size: 16px">' +
	    	    			                                '<td style="text-align: center;">'+j+'</td>' +
	    	    			                               
	    	    			                                '<td><b>'+obj[i].inspectOfficeName+'</b></td>' +
	    	    			                                
		    	    			                            
	    	    			                         
	    	    			                                
	    	    			                                '<td><b>'+obj[i].actionTakeninit+'</b></td>' +
	    	    			                                
	    	    			                                '<td><b>'+obj[i].actionTakencomplete+'</b></td>' +
	    	    			                                
	    	    			                                '<td><b>'+obj[i].remarks+'</b></td>' +
	    	    			                                
	    	    			                                '<td><b><button type="button" name="editmst1remarks" id="editmst1remarks'+j+'" class="btn btn-1 btn-primary center-block mst1reedit" onclick=""  >Edit </button></b>'+
	    	    			                                '<br>'+
	    	    			                                '<b><button type="button" name="editmst1remarks" id="editmst1remarks'+j+'" class="btn btn-1 btn-primary center-block mst1reedit" onclick=""  >Delete </button>'+
	    	    			                                '</td>' +
	    	    			                                
	    	    			                               
	    	    			                            
	    	    			                                	    	    			                               
	    	    			                           
	    	    			                              
	    	    	                                     '</tr>');
	    	    	   
	    	    	   
	    	    	  
	    	    	   
	    	    	
	    	    	  /* (k==1? '<td><b>Bund Remarks</b></td>': '')+
                       (k==2? '<td><b>Sluice Remarks</b></td>': '')+
                       (k==3? '<td><b>Weir Remarks</b></td>': '')+
                         */
	    	    	   
	    	    	  
	    	    	   j++;   
	    	    
	    	    }
			 
			 

		},
		error : function() {
			alert(error);
		}
	});
}


function getDamInspectioninfo( ) {
	
	$("#resinspecthead1").empty();
	$("#resinspectbody1").empty();
	
	var postId=$(".mainpostId").val();
	var year= $('#year').val();
	var tankId= $('#tankId').val();
	var dutyFrequencyId= $('#dutyFrequencyId').val();
		
		var reservoirId=$('#resId').val();
	$.ajax({
		url : "../invtsimis/getresInspectInfo",
		type : "POST",
		data: {year :  year,
			reservoirId: reservoirId,
			tankId:tankId,
			dutyFrequencyId:dutyFrequencyId},
		success : function(response) {
			
			
			 var j=1;
				
				

				
			var obj = JSON.parse(response);

			$('#inspectdata table thead').append( '<tr style="font-size: 18px; color: gray; font-weight: bold;"><th>Sl.No</th>'+
    	    		
    	    		'<th>Inspect Office</th>'+
    	    		'  <th>Name and Designation of Inspect office</th>'+
    	    	
    	    		/*'  <th>Latest</th>'+*/
    	    		'  <th>Name and Designation of field office </th>'+
    	    		
    	    		
    	    		
    	    		' <th>Inspect Date </th>'+
    	    		
    	    		' <th>Reservoir water level </th>'+
    	    		' <th>Type of Inspection  </th>'+
    	    		' <th>Storage Capacity  </th>'+
    	    		
    	    		' <th>Weather Conditions  </th>'+
    	    		
    	    		' <th>Edit / Delete </th>'+
    	    		
    	    	
    	    		'</tr>'); 	  

		

		 for(i in obj){
    	    	
    	    	//var k=obj[i].tabId;
    	    	var s= obj[i].postId ;
    	    	
    	    	var inspectinf=obj[i].resinspectInfoId;
    	    	
    	    	alert("inspectinf"+inspectinf);
    	    	
    	    	//alert(obj[i].deficiencyCategoryName);
    	    	
    	    	var officeName="'"+obj[i].inspectOfficeName+"'" ;
    	    	
    	    	   $('#inspectdata table tbody').append(  '<tr style="font-size: 16px">' +
    	    			                                '<td style="text-align: center;">'+j+'</td>' +
    	    			                               
    	    			                                '<td><b>'+obj[i].inspectOfficeName+'</b></td>' +
    	    			                                
	    	    			                            
    	    			                         
    	    			                                
    	    			                                '<td><b>'+obj[i].inspectOfficerData+'</b></td>' +
    	    			                                
    	    			                                '<td><b>'+obj[i].fieldOfficerData+'</b></td>' +
    	    			                                
    	    			                                '<td><b>'+obj[i].inspectDate+'</b></td>' +
    	    			                                
    	    			                                '<td><b>'+obj[i].presentWaterlevel+'</b></td>' +
    	    			                                
    	    			                          
    	    			                                
    	    			                                '<td><b>'+obj[i].typeofinspection+'</b></td>' +
    	    			                                
    	    			                                '<td><b>'+obj[i].storageCapacity+'</b></td>' +
    	    			                                
    	    			                                '<td><b>'+obj[i].weathercondition+'</b></td>' +
    	    			                                
    	    			                                (s==postId?'<td><b><button type="button" name="editmst1remarks" id="editmst1remarks'+j+'" class="btn btn-1 btn-primary center-block mst1reedit" onclick=""  >Edit </button></b>'+
    	    			                                '<br>'+
    	    			                                '<b><button type="button" name="delinspectinfname" id="delinspectinf'+j+'" class="btn btn-1 btn-primary center-block mst1reedit" onclick="deleteResInspectionDetails('+obj[i].resinspectInfoId+')"  >Delete </button>'+
    	    			                                '</td>' :'<td></td>')+
    	    			                                
    	    			                               
    	    			                            
    	    			                                	    	    			                               
    	    			                           
    	    			                              
    	    	                                     '</tr>');
    	    	   
    	    	   
    	    	  
    	    	   
    	    	
    	    	  /* (k==1? '<td><b>Bund Remarks</b></td>': '')+
                   (k==2? '<td><b>Sluice Remarks</b></td>': '')+
                   (k==3? '<td><b>Weir Remarks</b></td>': '')+
                     */
    	    	   
    	    	  
    	    	   j++;   
    	    
    	    }
				
				
			

		},
		error : function() {
			alert(error);
		}
	});
}



function addphotosdatafn(formId){
	//alert("formId"+formId);
//	alert("form name "+fromname);
	  $('#action_alert').empty();
	
  var customformid="#"+formId;
	  
	  var form = $(customformid).closest("form");
		 var formData = new FormData(form[0]);
		 var valid = "Are you sure you want to submit?";
		  if (confirm(valid)) { 
		 
			/*  if ( $('form[id='+formId+']').parsley().isValid()) {		*/
			
	  $.ajax({	          
	      url: "../invtsimis/daminspectphotos",
	      method:"POST",
	      async: false,
	      data:  formData,
	    
          contentType: false,
          processData: false,
	      success: function (response) {
	    	  
	    	  if(response>0){
		    		 
			    	//	alert("i am in kal Data inserttedd Successfully");
			
				  $('#action_alert').html('<p style="margin: 0px !important;">Photos updated Successfully</p>');
				
					$("html,body").animate({scrollTop:$('#action_alert').offset().top-175}, 500);
					
					 $(customformid).trigger("reset"); 	
					 
					 getDamInspectPhotosinfo();
					 
				    }
					
					if(response==0||response==null){
				    	
				    	  $('#action_alert').html('<p style="margin: 0px !important;">Failed to Update data</p>');
				    		$("html,body").animate({scrollTop:$('#action_alert').offset().top-175}, 500);
				    }
					
					 if(response==-3){
				    		
				    		$('#action_alert').html('<p style="margin: 0px !important;">Please Enter the Captcha Text </p>'); 
				    		$("html,body").animate({scrollTop:$('#action_alert').offset().top-175}, 500);
				    	}
					 
					 if(response==-4){
				    		
				    		$('#action_alert').html('<p style="margin: 0px !important;">Please Enter Inspection Details </p>'); 
				    		$("html,body").animate({scrollTop:$('#action_alert').offset().top-175}, 500);
				    	}
				    	
                if(response==-2){
				    		
				    		$('#action_alert').html('<p style="margin: 0px !important;">Captcha does not match </p>'); 
				    		$("html,body").animate({scrollTop:$('#action_alert').offset().top-175}, 500);
				    	}
					
					
					
	      },
	      error : function(){
	    	  alert(error);
	      }
	  });
	  
		 /* }else{
			  
				 
				
				$('form[id='+formId+']').parsley().validate();
				//alert("kal4");
			
	  }*/
			  return true;
			  
		  }
	       else{
	       	
	       	return false;
	         
	       }
}


function getDamRemarksinfo( ) {
	
	$("#resrmkshead4").empty();
	$("#resrmksbody4").empty();
	
	
var year= $('#year').val();
	
	var reservoirId=$('#resId').val();
	
var tankId= $('#tankId').val();
	
	var dutyFrequencyId=$('#dutyFrequencyId').val();
	

	
	var damCondition=$('#conditionofDamId').val();
	$.ajax({
		url : "../invtsimis/getDamRemarksDetails",
		type : "POST",
		data: {year :  year,
			reservoirId: reservoirId,
			tankId:tankId,
			
			dutyFrequencyId:dutyFrequencyId },
		success : function(response) {
			
			
			 var j=1;
				
				

				
			var obj = JSON.parse(response);

			$('#rmks table thead').append( '<tr style="font-size: 18px; color: gray; font-weight: bold;"><th>Sl.No</th>'+
    	    		
    	    		'<th>Inspect Office</th>'+
    	    		'  <th>Included in the Document</th>'+
    	    		'  <th>Latest</th>'+
    	    		'  <th>remarks</th>'+
    	    	
    	    		
    	    		
    	    		' <th>Edit / Delete </th>'+
    	    		
    	    	
    	    		'</tr>'); 	  

		

		 for(i in obj){
    	    	
    	    	//var k=obj[i].tabId;
    	    	var s= obj[i].postId ;
    	    	
    	    	//alert(obj[i].deficiencyCategoryName);
    	    	
    	    	var officeName="'"+obj[i].inspectOfficeName+"'" ;
    	    	
    	    	var incldoc=obj[i].remarksinclindoc;
    	    	
    	    	   $('#rmks table tbody').append(  '<tr style="font-size: 16px">' +
    	    			                                '<td style="text-align: center;">'+j+'</td>' +
    	    			                               
    	    			                                '<td><b>'+obj[i].inspectOfficeName+'</b></td>' +
    	    			                                
	    	    			                            
    	    			                         
    	    			                                
    	    			                   (  ( incldoc==true  )  ?      '<td><b> Yes </b></td>' : '<td><b> No </b></td>') +
    	    			                                
    	    			                                '<td><b>'+obj[i].isLatest+'</b></td>' +
    	    			                                
    	    			                                '<td><b>'+obj[i].remarks+'</b></td>' +
    	    			                                
    	    			                                
    	    			                                '<td> <br>'+
    	    	                                       '<b><button type="button" name="editmst1remarks" id="editmst1remarks'+j+'" class="btn btn-1 btn-primary center-block mst1reedit" onclick=""  >Edit Remarks</button></b>'+
    	    			                                '<br>'+
    	    			                                '<b><button type="button" name="editmst1remarks" id="editmst1remarks'+j+'" class="btn btn-1 btn-primary center-block mst1reedit" onclick=""  >Delete Remarks</button>'+
    	    			                                ' <br></td>' +
    	    			                                
    	    			                               
    	    			                            
    	    			                                	    	    			                               
    	    			                           
    	    			                              
    	    	                                     '</tr>');
    	    	   
    	    	   
    	    	  
    	    	   
    	    	
    	    	  /* (k==1? '<td><b>Bund Remarks</b></td>': '')+
                   (k==2? '<td><b>Sluice Remarks</b></td>': '')+
                   (k==3? '<td><b>Weir Remarks</b></td>': '')+
                     */
    	    	   
    	    	  
    	    	   j++;   
    	    
    	    }
				
				
			

		},
		error : function() {
			alert(error);
		}
	});
}


function getDamInspectPhotosinfo( ) {
	
	$("#resinspecthead5").empty();
	$("#resinspectbody5").empty();
	
	
var year= $('#year').val();
	
	var reservoirId=$('#resId').val();
	
var tankId= $('#tankId').val();
	
	var dutyFrequencyId=$('#dutyFrequencyId').val();
	

	
	var damCondition=$('#conditionofDamId').val();
	$.ajax({
		url : "../invtsimis/getDamInspectPhotosDetails",
		type : "POST",
		data: {year :  year,
			reservoirId: reservoirId,
			tankId:tankId,
			dutyFrequencyId:dutyFrequencyId },
		success : function(response) {
			
			
			 var j=1;
				
				

				
			var obj = JSON.parse(response);

			$('#inspectphtup table thead').append( '<tr style="font-size: 18px; color: gray; font-weight: bold;"><th>Sl.No</th>'+
    	    		
    	    		'<th>Inspect Office</th>'+
    	    		'  <th>Document Title</th>'+
    	    	
    	    		'  <th>Download</th>'+
    	    	
    	    		' <th> Delete </th>'+
    	    		
    	    	
    	    		'</tr>'); 	  

		

		 for(i in obj){
    	    	
    	    	//var k=obj[i].tabId;
    	    	//var s= obj[i].postId ;
    	    	
    	    	//alert(obj[i].deficiencyCategoryName);
    	    	
    	    	var officeName="'"+obj[i].inspectOfficeName+"'" ;
    	    	
    	    	
    	    	
    	    	   $('#inspectphtup table tbody').append(  '<tr style="font-size: 16px">' +
    	    			                                '<td style="text-align: center;">'+j+'</td>' +
    	    			                               
    	    			                                '<td><b>'+obj[i].inspectOfficeName+'</b></td>' +
    	    			                                
	    	    			                           
    	    			                                '<td><b>'+obj[i].docTitle+'</b></td>' +
    	    			                                
    	    			                                '<td style="color:blue"><b><a target="_blank" href="../uploadedFiles/DamInspectDocs/'+obj[i].damDocName+'" ><u>'+obj[i].damDocOriginalName+'<u></a></b></td>' +
    	    			                                
    	    			                              
    	    			                                
    	    			                                
    	    			                                '<td> <br>'+
    	    	                                      
    	    			                                '<b><button type="button" name="editmst1remarks" id="editmst1remarks'+j+'" class="btn btn-1 btn-primary center-block mst1reedit" onclick=""  >Delete </button>'+
    	    			                                ' <br></td>' +
    	    			                                
    	    			                               
    	    			                            
    	    			                                	    	    			                               
    	    			                           
    	    			                              
    	    	                                     '</tr>');
    	    	   
    	    	   
    	    	  
    	    	   
    	    	
    	    	  /* (k==1? '<td><b>Bund Remarks</b></td>': '')+
                   (k==2? '<td><b>Sluice Remarks</b></td>': '')+
                   (k==3? '<td><b>Weir Remarks</b></td>': '')+
                     */
    	    	   
    	    	  
    	    	   j++;   
    	    
    	    }
				
				
			

		},
		error : function() {
			alert(error);
		}
	});
}

$(function() {
	window.Parsley.addValidator('maxFileSize', {
		  validateString: function(_value, maxSize, parsleyInstance) {
		   /*  if (!window.FormData) {
		      alert('formdata');
		      return true;
		    } */
		    var files = parsleyInstance.$element[0].files;
		    //alert("files.length "+files.length );
		    var imageSizeArr = 0;
		    var totalfilesize=0;
		   var  mxfilesize= maxSize * 1024;
		    for (var i = 0; i < files.length; i++){
		        var imageSize = files[i].size;
		     
		      //  alert("imageSize"+imageSize);
		      //  alert("maxSize"+maxSize);
		      
		         totalfilesize=totalfilesize+imageSize;
		         
		       //  alert("mxfilesize"+mxfilesize);
			        
			       // alert("totalfilesize"+totalfilesize);
		        
		        if (totalfilesize > mxfilesize ){
		        	//alert("kal"+i);
		        	imageSizeArr = 1;
		        }
		    }
		    return  totalfilesize <= maxSize * 1024;
		  },
		  requirementType: 'integer',
		  messages: {
		    en: 'Total files should not be larger than %s Kb',
		   
		  }
		});


	window.ParsleyValidator
	.addValidator('fileextension', function (value, requirement) {
			var tagslistarr = requirement.split(',');
	  var fileExtension = value.split('.').pop();
					var arr=[];
					$.each(tagslistarr,function(i,val){
						 arr.push(val);
					});
	  if(jQuery.inArray(fileExtension, arr)!='-1') {
	    console.log("is in array");
	    return true;
	  } else {
	    console.log("is NOT in array");
	    return false;
	  }
	}, 32)
	.addMessage('en', 'fileextension', 'The file should be ,.jpeg,.jpg,.png');


		
	});


function resDamInfo(reservoirId ) {
	
	 $("#adddambasicinf").trigger("reset"); 	
	

	var reservoirId=reservoirId;
	$.ajax({
		url : "../invtsimis/getResDaminfoDetails",
		type : "POST",
		data: {
			reservoirId: reservoirId},
		success : function(response) {
		
			var obj = JSON.parse(response);

		  var typeOfDam=obj[0].typeOfDam;
		  
		  var ownerOfDam=obj[0].ownerOfDam;
		  
		  var damOperator=obj[0].damOperator;
		  
		  var commisionDate=obj[0].commisionDate;
		  
		  var hazardClass=obj[0].hazardClass;
		  
		  var reservoirId=obj[0].reservoirId
		  
		  
		  
		  $('#typeOfDam').val(typeOfDam);
		  $('#ownerOfDam').val(ownerOfDam);
		  $('#damOperator').val(damOperator);
		  $('#commisionDate').val(commisionDate);
		  $('#hazardClass').val(hazardClass);
		  
		  $('#dminfreservoirIddata').val(reservoirId);
		  
		  
		  $('#typeOfDam').prop("readonly", true); 
		  
		  $('#ownerOfDam').prop("readonly", true); 
		  
		  $('#damOperator').prop("readonly", true); 
		  
		  $('#commisionDate').prop("readonly", true);
		  
		  $('#hazardClass').prop("readonly", true);
		
		

		

		
				
				
			

		},
		error : function() {
			alert(error);
		}
	});
}

function resDamImpContLvlInfo(reservoirId ) {
	
	 $("#adddamcontrolinf").trigger("reset"); 	
	

	var reservoirId=reservoirId;
	$.ajax({
		url : "../invtsimis/getDamControlLvlDetails",
		type : "POST",
		data: {
			reservoirId: reservoirId},
		success : function(response) {
			
		
				
			var obj = JSON.parse(response);

		  var frlLevel=obj[0].frlLevel;
		  

		  var trlLevel=obj[0].trlLevel;
		  
		  var mwlLevel=obj[0].mwlLevel;
		  
		  var spillWayCrestLevel=obj[0].spillWayCrestLevel;
		  
		  var mddlLevel=obj[0].mddlLevel;
		  
		  var lowestRiverBed=obj[0].lowestRiverBed;
		  
		  var deepestfoundationLevel=obj[0].deepestfoundationLevel;
		  
		  var grossStorageatFrl=obj[0].grossStorageatFrl;
		  
		
		  
		  var reservoirId=obj[0].reservoirId
		  
		  $('#frlLevel').val(frlLevel);
		  $('#trlLevel').val(trlLevel);
		  $('#mwlLevel').val(mwlLevel);
		  $('#spillWayCrestLevel').val(spillWayCrestLevel);
		  $('#mddlLevel').val(mddlLevel);
		  $('#lowestRiverBed').val(lowestRiverBed);
		  $('#deepestfoundationLevel').val(deepestfoundationLevel);
		  $('#grossStorageatFrl').val(grossStorageatFrl);
		  
		  $('#dmctrlreservoirIddata').val(reservoirId);
  
		  $('#frlLevel').prop("readonly", true); 
		  
		  $('#trlLevel').prop("readonly", true); 
		  
		  $('#mwlLevel').prop("readonly", true);
		  
		  $('#spillWayCrestLevel').prop("readonly", true);
		  
		  $('#mddlLevel').prop("readonly", true);
		  
		  $('#lowestRiverBed').prop("readonly", true);
		  
		  $('#deepestfoundationLevel').prop("readonly", true);
		  
		  $('#grossStorageatFrl').prop("readonly", true);

		  
				
				
			

		},
		error : function() {
			alert(error);
		}
	});
}


function TankDamInfo(tankId ) {
	
	 $("#adddambasicinf").trigger("reset"); 
	 alert("TankDamInfo"+tankId)

	var tankId=tankId;
	$.ajax({
		url : "../invtsimis/getTankDamInfo",
		type : "POST",
		data: {
			tankId: tankId},
		success : function(response) {
		
			var obj = JSON.parse(response);

		  var typeOfDam=obj[0].typeOfDam;
		  
		  var ownerOfDam=obj[0].ownerOfDam;
		  
		  var damOperator=obj[0].damOperator;
		  
		  var commisionDate=obj[0].commisionDate;
		  
		  var hazardClass=obj[0].hazardClass;
		  
		  
		  
		  $('#typeOfDam').val(typeOfDam);
		  $('#ownerOfDam').val(ownerOfDam);
		  $('#damOperator').val(damOperator);
		  $('#commisionDate').val(commisionDate);
		  $('#hazardClass').val(hazardClass);
		  $('#dminftankdata').val(tankId);
		
		 
		  $('#typeOfDam').prop("readonly", true); 
		  
		  $('#ownerOfDam').prop("readonly", true); 
		  
		  $('#damOperator').prop("readonly", true); 
		  
		  $('#commisionDate').prop("readonly", true); 
		  
		  $('#hazardClass').prop("readonly", true);
		

		
				
				
			

		},
		error : function() {
			alert(error);
		}
	});
}

function TankImpContLvlInfo(tankId ) {
	
	 $("#adddamcontrolinf").trigger("reset"); 
	
	
	

	var tankId=tankId;
	$.ajax({
		url : "../invtsimis/getTankImpControlInfo",
		type : "POST",
		data: {
			tankId: tankId},
		success : function(response) {
			
		
				
			var obj = JSON.parse(response);

		  var frlLevel=obj[0].frlLevel;
		  

		  var trlLevel=obj[0].trlLevel;
		  
		  var mwlLevel=obj[0].mwlLevel;
		  
		  var spillWayCrestLevel=obj[0].spillWayCrestLevel;
		  
		  var mddlLevel=obj[0].mddlLevel;
		  
		  var lowestRiverBed=obj[0].lowestRiverBed;
		  
		  var deepestfoundationLevel=obj[0].deepestfoundationLevel;
		  
		  var grossStorageatFrl=obj[0].preworkCapacity;
		  
		
		  
		  $('#frlLevel').val(frlLevel);
		  $('#trlLevel').val(trlLevel);
		  $('#mwlLevel').val(mwlLevel);
		  $('#spillWayCrestLevel').val(spillWayCrestLevel);
		  $('#mddlLevel').val(mddlLevel);
		  $('#lowestRiverBed').val(lowestRiverBed);
		  $('#deepestfoundationLevel').val(deepestfoundationLevel);
		  
		  $('#grossStorageatFrl').val(grossStorageatFrl);
		  
		  $('#dmctrltankdata').val(tankId);
		  
		  $('#frlLevel').prop("readonly", true);
		  
		  $('#trlLevel').prop("readonly", true);
		  
		  $('#mwlLevel').prop("readonly", true);
		  
		  $('#spillWayCrestLevel').prop("readonly", true);
		  
		  $('#mddlLevel').prop("readonly", true);
		  
		  $('#lowestRiverBed').prop("readonly", true);
		  
		  $("#grossStorageatFrl").prop("readonly", true); 
		  
		  $('#deepestfoundationLevel').prop("readonly", true);

	
		},
		error : function() {
			alert(error);
		}
	});
}


function updatetankdaminfo(formId){
	
	
	
	var tankId= $("#dminftankdata").val(); 
	
	
	var formId = formId		
	 
	 var customformid="#"+formId;

	
	$('#action_alert').empty();


		
		//alert("kal2 recommendatiion info");
		if ($('form[id='+formId+']').parsley()
				.isValid()) {		 
	    $.ajax({	          
	url: "../invtsimis/editTankDemoInfo" ,
	method:"POST",
	dataType: 'json',

	async: false,
	data: $('form[id=' + formId+ ']').serialize() ,


	success: function (response) {

		  
		//  console.log(response);
		
		if(response>0){
		  
		  $(customformid).trigger("reset"); 
		  
		 

		  $('#action_alert').html('<p style="margin: 0px !important;">Data updated Successfully</p>');
		  $("html,body").animate({scrollTop:0}, 500);
		  
		  
		  TankDamInfo(tankId );
		 // getResDamHealthDetails();
		  
		}if(response==-1){
			
			

			  $('#action_alert').html('<p style="margin: 0px !important;">please select Tank</p>');
			  $("html,body").animate({scrollTop:0}, 500);
			
			
		}if(response==0 || response==null){
			
			

			  $('#action_alert').html('<p style="margin: 0px !important;">Failed to Update</p>');
			  $("html,body").animate({scrollTop:0}, 500);
			
			
		}
		   
		
		

	},
	error : function(){
		 alert(error);

	}
	}); 	
		 }else {
				
				$('form[id='+formId+']').parsley().validate();
				//alert("kal4");
				
		} 
			

		
	
	
	
}


function updatetankImpControlinfo(formId){
	
	
	var tankId= $("#dmctrltankdata").val(); 
	
	var formId = formId		
	 
	 var customformid="#"+formId;

	
	$('#action_alert').empty();


		
		//alert("kal2 recommendatiion info");
		if ($('form[id='+formId+']').parsley()
				.isValid()) {		 
	    $.ajax({	          
	url: "../invtsimis/editTankImpControlInfo" ,
	method:"POST",
	dataType: 'json',

	async: false,
	data: $('form[id=' + formId+ ']').serialize() ,


	success: function (response) {

		  
		//  console.log(response);
		
		if(response>0){
		  
		  $(customformid).trigger("reset"); 
		  
		 

		  $('#action_alert').html('<p style="margin: 0px !important;">Data updated Successfully</p>');
		  $("html,body").animate({scrollTop:0}, 500);
		  
		  
		  TankImpContLvlInfo(tankId );
		 // getResDamHealthDetails();
		  
		}if(response==-1){
			
			

			  $('#action_alert').html('<p style="margin: 0px !important;">please select Tank</p>');
			  $("html,body").animate({scrollTop:0}, 500);
			
			
		}if(response==0 || response==null){
			
			

			  $('#action_alert').html('<p style="margin: 0px !important;">Failed to Update</p>');
			  $("html,body").animate({scrollTop:0}, 500);
			
			
		}
		   
		
		

	},
	error : function(){
		 alert(error);

	}
	}); 	
		 }else {
				
				$('form[id='+formId+']').parsley().validate();
				//alert("kal4");
				
		} 
			

		
	
	
	
}


function updateResdaminfo(formId){
	
	
	
	var reservoirId= $("#dminfreservoirIddata").val(); 
	
	
	var formId = formId		
	 
	 var customformid="#"+formId;

	
	$('#action_alert').empty();


		
		//alert("kal2 recommendatiion info");
		if ($('form[id='+formId+']').parsley()
				.isValid()) {		 
	    $.ajax({	          
	url: "../invtsimis/editResDemoInfo" ,
	method:"POST",
	dataType: 'json',

	async: false,
	data: $('form[id=' + formId+ ']').serialize() ,


	success: function (response) {

		  
		//  console.log(response);
		
		if(response>0){
		  
		  $(customformid).trigger("reset"); 
		  
		 

		  $('#action_alert').html('<p style="margin: 0px !important;">Data updated Successfully</p>');
		  $("html,body").animate({scrollTop:0}, 500);
		  
		  
		  resDamInfo(reservoirId );
		 // getResDamHealthDetails();
		  
		}if(response==-1){
			
			

			  $('#action_alert').html('<p style="margin: 0px !important;">please select Tank</p>');
			  $("html,body").animate({scrollTop:0}, 500);
			
			
		}if(response==0 || response==null){
			
			

			  $('#action_alert').html('<p style="margin: 0px !important;">Failed to Update</p>');
			  $("html,body").animate({scrollTop:0}, 500);
			
			
		}
		   
		
		

	},
	error : function(){
		 alert(error);

	}
	}); 	
		 }else {
				
				$('form[id='+formId+']').parsley().validate();
				//alert("kal4");
				
		} 
			

		
	
	
	
}


function updateResImpControlinfo(formId){
	
	
	var reservoirId= $("#dmctrlreservoirIddata").val(); 
	
	var formId = formId		
	 
	 var customformid="#"+formId;

	
	$('#action_alert').empty();


		
		//alert("kal2 recommendatiion info");
		if ($('form[id='+formId+']').parsley()
				.isValid()) {		 
	    $.ajax({	          
	url: "../invtsimis/editResImpControlInfo" ,
	method:"POST",
	dataType: 'json',

	async: false,
	data: $('form[id=' + formId+ ']').serialize() ,


	success: function (response) {

		  
		//  console.log(response);
		
		if(response>0){
		  
		  $(customformid).trigger("reset"); 
		  
		 

		  $('#action_alert').html('<p style="margin: 0px !important;">Data updated Successfully</p>');
		  $("html,body").animate({scrollTop:0}, 500);
		  
		  
		  resDamImpContLvlInfo(reservoirId );
		 // getResDamHealthDetails();
		  
		}if(response==-1){
			
			

			  $('#action_alert').html('<p style="margin: 0px !important;">please select Tank</p>');
			  $("html,body").animate({scrollTop:0}, 500);
			
			
		}if(response==0 || response==null){
			
			

			  $('#action_alert').html('<p style="margin: 0px !important;">Failed to Update</p>');
			  $("html,body").animate({scrollTop:0}, 500);
			
			
		}
		   
		
		

	},
	error : function(){
		 alert(error);

	}
	}); 	
		 }else {
				
				$('form[id='+formId+']').parsley().validate();
				//alert("kal4");
				
		} 
			

		
	
	
	
}


function editinfo(tankId, reservoirId,formid, hkey ,flag){
	
	//alert(tankId+"tankId");
	
	//alert(reservoirId+"reservoirId");
	
	//alert(formid+"formid");
	
	//alert(hkey+"hkey");
	
	//alert(flag+"flag");
	
	var flaginf= flag
	
	//alert(flaginf+"flaginft");
	
	
	
if( flaginf=="false" && tankId>0 && reservoirId==0 && hkey==1  ){
	
	//alert("i am 1");
		
	$('#typeOfDam').prop("readonly", false); 
	  $('#ownerOfDam').prop("readonly", false); 
	  $('#damOperator').prop("readonly", false); 
	  $('#commisionDate').prop("readonly", false); 
	  $('#hazardClass').prop("readonly", false); 
	  
	  $("#daminfeditFlag").attr('value', true);
	  
	  $("#dminftankdata").val(tankId);
	  
	  
	  
	  $("#daminfupdate").attr('value', 'Submit');
		
	}
	
   if(tankId>0 && reservoirId==0 && hkey==2 && flaginf=="false"){
	   
		//alert("i am 2");
		
	   $('#frlLevel').prop("readonly", false); 
		  $('#trlLevel').prop("readonly", false); 
		  $('#mwlLevel').prop("readonly", false); 
		  $('#spillWayCrestLevel').prop("readonly", false); 
		  $('#mddlLevel').prop("readonly", false); 
		  $('#lowestRiverBed').prop("readonly", false); 
		  $('#deepestfoundationLevel').prop("readonly", false); 
		  
		  $("#damctrleditFlag").attr('value', true);
		  
		  $("#grossStorageatFrl").prop("readonly", false); 
		  
		  $("#dmctrltankdata").val(tankId);
		  
		  $("#damcontrolinf").text( 'Submit');
		  
	}
   
   if(tankId>0 && reservoirId==0 && hkey==1 && flaginf=="true" ){
	   
		//alert("i am 3");
		
		
	   updatetankdaminfo(formid);
	   
	   $("#daminfeditFlag").attr('value', false);
		  
		  $("#daminfupdate").attr('value', 'Edit');
		
	   
	
			
		}
		
	   if(tankId>0 && reservoirId==0 && hkey==2 && flaginf=="true"){
		   
		   //alert("i am 4");
		   
		  
			
		   updatetankImpControlinfo(formid);
		   
		   $("#damctrleditFlag").attr('value', false);
			  
			  $("#damcontrolinf").text( 'Edit');
			  
		   
			
			  
		}
	   
	   if( flaginf=="false" && tankId==0 && reservoirId>0 && hkey==1  ){
			
			//alert("i am 5");
				
			$('#typeOfDam').prop("readonly", false); 
			  $('#ownerOfDam').prop("readonly", false); 
			  $('#damOperator').prop("readonly", false); 
			  $('#commisionDate').prop("readonly", false); 
			  $('#hazardClass').prop("readonly", false); 
			  
			  $("#daminfeditFlag").attr('value', true);
			  
			  $("#dminfreservoirIddata").val(reservoirId);
			  
			  
			  
			  $("#daminfupdate").attr('value', 'Submit');
				
			}
			
		   if(tankId==0 && reservoirId>0 && hkey==2 && flaginf=="false"){
			   
			//	alert("i am 6");
				
			   $('#frlLevel').prop("readonly", false); 
				  $('#trlLevel').prop("readonly", false); 
				  $('#mwlLevel').prop("readonly", false); 
				  $('#spillWayCrestLevel').prop("readonly", false); 
				  $('#mddlLevel').prop("readonly", false); 
				  $('#lowestRiverBed').prop("readonly", false); 
				  $('#deepestfoundationLevel').prop("readonly", false); 
				  
				  $("#damctrleditFlag").attr('value', true);
				  
				  $("#grossStorageatFrl").prop("readonly", false); 
				  
				  $("#dmctrlreservoirIddata").val(reservoirId);
				  
				  $("#damcontrolinf").text( 'Submit');
				  
			}
	   
	    if(tankId==0 && reservoirId>0 && hkey==1 && flaginf=="true"){
		
	    	  // alert("i am 7");
	    	updateResdaminfo(formid);
	    	
	    	 $("#daminfeditFlag").attr('value', false);
			  
			  $("#daminfupdate").attr('value', 'Edit');
		
	}
	
 if(tankId==0 && reservoirId>0 && hkey==2 && flaginf=="true"){
	 
	// alert("i am 8");
		
	 updateResImpControlinfo(formid);
	 
	   $("#damctrleditFlag").attr('value', false);
		  
		  $("#damcontrolinf").text( 'Edit');
		
	}
	
	
	
	
}


function editdamstatus(tstatusId){


	
	 $('#editdamtatus_dialogue').dialog('option', 'title', 'Edit Dam Status');
	  $('#editdamtatus_dialogue').dialog('open');
	  
	  $('#editdamstatusid').trigger("reset"); 
	  
	  
	  $('#editdamStatusId').val(tstatusId); 
	  
	
	

}



function submitcriticalstatus(){
	
	  var mst1Id= $('#editcriticalMst1Id').val(); 
	  alert("mst1Id" +mst1Id);
	  
	  var tstatusId= $('#editdamStatusId').val(); 
	  alert("tstatusId" +tstatusId); 
	/*  var unitId= $('#editUnitId').val(); 
	//  alert("unitId" +unitId);
	  var circleId= $('#editCircleId').val(); 
	//  alert("circleId" +circleId);
	  var divisionId= $('#editDivisionId').val(); 
	//  alert("divisionId" +divisionId);
	  var subdivisionId= $('#editSubDivisionId').val(); 
	//  alert("subdivisionId" +subdivisionId);
*/	  
	  $("#conditionofDamId").multiselect('rebuild');
		
	  $.ajax({	          
			url: "../invtsimis/update-dam-status",
			method:"POST",
			dataType: 'json',

			async: false,
			data: {
				resInspectMst1Id:mst1Id,
				  
				conditionofDamId:tstatusId,
				/*unitId:unitId,
				circleId:circleId,
				divisionId:divisionId,
				subdivisionId:subdivisionId*/
				
			},
			success: function (obj) {
		  
		//		alert("submitcriticalstatus obj "+obj);
			//	console.log(obj);
				  if(obj!=null){
					  
					  $('#editdamtatus_dialogue').dialog('close');
					  
					  $('#action_alert').html('<p style="margin: 0px !important;">Status Updated</p>');
					  
					  var idnew=parseInt(obj);
				  
					  $("#conditionofDamId").each(function () {
					 
						  $(this).val(idnew);
					    	            $(this).attr("selected", "selected");
					    	  		/*  $('#tankStatusId1').val(idnew);
					    	  		  $('#tankStatusId2').val(idnew);
					    	  		  $('#tankStatusId3').val(idnew);*/
					    	            
					    	            $('.mainresInspectMst1Id').val(idnew);
			    	});
					  
					  $("#conditionofDamId").multiselect('rebuild');
			 	 
				  }
				  if(obj==0||obj==null){
					  $('#editdamtatus_dialogue').dialog('open');
					  $('#action_alert').html('<p style="margin: 0px !important;">Failed to Update Status</p>');
					  }
			
			},
			error : function(){
				 alert(error);

			}
			});
	
}

function deleteRmarksReview(reviewId){
	
//	alert("HI");
//	alert("capacityReviewId "+capacityReviewId+"capacityId "+capacityId+"tabId "+tabId);
	
	 $.ajax({	          
			url: ".. /invtsimis/delete-reviewid" ,
			method:"POST",
			dataType: 'json',

			async: false,
			data: {
				  
				resRemarksMst1ReviewId:reviewId,
				
				  
			},


			success: function (response) {

				  
				//  console.log(response);
				  
				if(response>0){

				  $('#action_alert').html('<p style="margin: 0px !important;">Data Deleted Successfully</p>');
				  $("html,body").animate({scrollTop:0}, 500);
				  
				
				  
				  getDamRemarksinfo();
				 
				  
				}
				
				if(response==0 || response==null){
					
					
					
					 $('#action_alert').html('<p style="margin: 0px !important;">Failed to Delete Data</p>');
					   	
					 $("html,body").animate({scrollTop:0}, 500);
				}
				

			},
			error : function(){
				 alert(error);

			}
			}); 


	
}


function deleteAnnmst2(resInspectMst2Id,rescheckId){
	
//	alert("HI");
//	alert("capacityReviewId "+capacityReviewId+"capacityId "+capacityId+"tabId "+tabId);
	
	 $.ajax({	          
			url: ".. /invtsimis/delete-annmst" ,
			method:"POST",
			dataType: 'json',

			async: false,
			data: {
				  
				resInspectMst2Id:resInspectMst2Id,
				
				  
			},


			success: function (response) {

				  
				//  console.log(response);
				  
				if(response>0){

				  $('#action_alert').html('<p style="margin: 0px !important;">Data Deleted Successfully</p>');
				  $("html,body").animate({scrollTop:0}, 500);
				  
				
				  
				  getresmst2mst1byfreqyear();
				 
				  
				}
				
				if(response==0 || response==null){
					
					
					
					 $('#action_alert').html('<p style="margin: 0px !important;">Failed to Delete Data</p>');
					   	
					 $("html,body").animate({scrollTop:0}, 500);
				}
				

			},
			error : function(){
				 alert(error);

			}
			}); 


	
}


function deleteAnnRecommendationsbyRecId(resRecommendId){
	
//	alert("HI");
//	alert("capacityReviewId "+capacityReviewId+"capacityId "+capacityId+"tabId "+tabId);
	
	 $.ajax({	          
			url: ".. /invtsimis/delete_recommend_recid" ,
			method:"POST",
			dataType: 'json',

			async: false,
			data: {
				  
				resRecommendId:resRecommendId,
				
				  
			},


			success: function (response) {

				  
				//  console.log(response);
				  
				if(response>0){

				  $('#action_alert').html('<p style="margin: 0px !important;">Data Deleted Successfully</p>');
				  $("html,body").animate({scrollTop:0}, 500);
				  
				
				  
				//  getresmst2mst1byfreqyear();
				 
				  
				}
				
				if(response==0 || response==null){
					
					
					
					 $('#action_alert').html('<p style="margin: 0px !important;">Failed to Delete Data</p>');
					   	
					 $("html,body").animate({scrollTop:0}, 500);
				}
				

			},
			error : function(){
				 alert(error);

			}
			}); 


	
}


function deleteAnnInspectDocs(damdocId){
	
//	alert("HI");
//	alert("capacityReviewId "+capacityReviewId+"capacityId "+capacityId+"tabId "+tabId);
	
	 $.ajax({	          
			url: "../invtsimis/delete_res_ann_docs" ,
			method:"POST",
			dataType: 'json',

			async: false,
			data: {
				  
				damdocId:damdocId,
				
				  
			},


			success: function (response) {

				  
				//  console.log(response);
				  
				if(response>0){

				  $('#action_alert').html('<p style="margin: 0px !important;">Data Deleted Successfully</p>');
				  $("html,body").animate({scrollTop:0}, 500);
				  
				  getDamInspectPhotosinfo();
				  
				//  getresmst2mst1byfreqyear();
				 
				  
				}
				
				if(response==0 || response==null){
					
					
					
					 $('#action_alert').html('<p style="margin: 0px !important;">Failed to Delete Data</p>');
					   	
					 $("html,body").animate({scrollTop:0}, 500);
				}
				

			},
			error : function(){
				 alert(error);

			}
			}); 


	
}


function deleteResHealthDetails(resDamHealthId){
	
//	alert("HI");
//	alert("capacityReviewId "+capacityReviewId+"capacityId "+capacityId+"tabId "+tabId);
	
	 $.ajax({	          
			url: "../invtsimis/delete_res_health_details" ,
			method:"POST",
			dataType: 'json',

			async: false,
			data: {
				  
				resDamHealthId:resDamHealthId,
				
				  
			},


			success: function (response) {

				  
				//  console.log(response);
				  
				if(response>0){

				  $('#action_alert').html('<p style="margin: 0px !important;">Data Deleted Successfully</p>');
				  $("html,body").animate({scrollTop:0}, 500);
				  
				  getResDamHealthDetails()
				  
				//  getresmst2mst1byfreqyear();
				 
				  
				}
				
				if(response==0 || response==null){
					
					
					
					 $('#action_alert').html('<p style="margin: 0px !important;">Failed to Delete Data</p>');
					   	
					 $("html,body").animate({scrollTop:0}, 500);
				}
				

			},
			error : function(){
				 alert(error);

			}
			}); 


	
}


function deleteResInspectionDetails(resinspectInfoId){
	
//	alert("HI");
//	alert("capacityReviewId "+capacityReviewId+"capacityId "+capacityId+"tabId "+tabId);
	
	 $.ajax({	          
			url: "../invtsimis/delete_res_inspection_details" ,
			method:"POST",
			dataType: 'json',

			async: false,
			data: {
				  
				resinspectInfoId:resinspectInfoId,
				
				  
			},


			success: function (response) {

				  
				//  console.log(response);
				  
				if(response>0){

				  $('#action_alert').html('<p style="margin: 0px !important;">Data Deleted Successfully</p>');
				  $("html,body").animate({scrollTop:0}, 500);
				  
				  getDamInspectioninfo( )
				  
				//  getresmst2mst1byfreqyear();
				 
				  
				}
				
				if(response==0 || response==null){
					
					
					
					 $('#action_alert').html('<p style="margin: 0px !important;">Failed to Delete Data</p>');
					   	
					 $("html,body").animate({scrollTop:0}, 500);
				}
				

			},
			error : function(){
				 alert(error);

			}
			}); 


	
}


function deleteResActionTakenDetails(resDamActionId){
	
//	alert("HI");
//	alert("capacityReviewId "+capacityReviewId+"capacityId "+capacityId+"tabId "+tabId);
	
	 $.ajax({	          
			url: ".. /invtsimis/delete_res_act_details" ,
			method:"POST",
			dataType: 'json',

			async: false,
			data: {
				  
				resDamActionId:resDamActionId,
				
				  
			},


			success: function (response) {

				  
				//  console.log(response);
				  
				if(response>0){

				  $('#action_alert').html('<p style="margin: 0px !important;">Data Deleted Successfully</p>');
				  $("html,body").animate({scrollTop:0}, 500);
				  
				  getActionStatusDetails( )
				  
				//  getresmst2mst1byfreqyear();
				 
				  
				}
				
				if(response==0 || response==null){
					
					
					
					 $('#action_alert').html('<p style="margin: 0px !important;">Failed to Delete Data</p>');
					   	
					 $("html,body").animate({scrollTop:0}, 500);
				}
				

			},
			error : function(){
				 alert(error);

			}
			}); 


	
}



	//end of nrld functions