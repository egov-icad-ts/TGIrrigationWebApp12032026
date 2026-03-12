$(function() {
	
	  var cyear = (new Date).getFullYear();
		 // var lyear = (new Date).getFullYear()+1;
		 
		$(".datepick").datepicker({
				changeYear : true,
				changeMonth : true,
				dateFormat : "dd/mm/yy"
			     
				
			//	 dateFormat: "dd/mm/yyyy"
				   
				
			/* 
			 dateFormat : "dd/mm/yy", onSelect: function(selected) {
			   $("#month").datepicker("option","minDate", selected)
			 } */
			});
		
	$("#tankreportmaintabs").tabs();
	//$("#itrpt").hide();
	
	//$("#form20subrpt").hide();
	
	$("#abs1").tabs();
	
	

	$("#tabs2").tabs();

	$("#verticaltii").tabs().addClass("ui-tabs-vertical ui-helper-clearfix");
	$("#verticaltii li").removeClass("ui-corner-top")
			.addClass("ui-corner-left");

	$("#verticalrh").tabs().addClass("ui-tabs-vertical ui-helper-clearfix");
	$("#verticalrh li").removeClass("ui-corner-top").addClass("ui-corner-left");

	

	

	$('#miyear').multiselect({

		enableCaseInsensitiveFiltering : true

	});
	$('#form20year').multiselect({

		enableCaseInsensitiveFiltering : true

	});

	
	

	
	
	$('a[data-toggle="tab"]').on('show.bs.tab', function(e) {
	        localStorage.setItem('activeTab', $(e.target).attr('href'));
	    });
	    var activeTab = localStorage.getItem('activeTab');
	    if(activeTab){
	    	//alert(activeTab);
	        $('#tmsreportstab a[href="' + activeTab + '"]').click();
	    }

	

	
	
	$(".rview").hide();
	
	 
	$('#frm20_doc_dia').dialog({
		  autoOpen:false,
		  width:1200,
		  close: function() {
			  
			
				  $(this).dialog("close");
				  }
		 });
	
	$('#doc-frm-table-10').DataTable( {
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
                messageTop: 'Project Wise Mandal Ayacut Report',
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
	
	
	

});











	
	

function getform20tankabdata(year,fromdate,todate, formId,flag){
	
//alert(" "+year+" "+formId+ " " +flag);
//alert("fromdate "+fromdate);
//alert(" todate "+todate);
	
	if(flag==false){
		$('#form20year').removeAttr('required'); 
	
		
	}
	
	
		
		
	if ($('form[id=tankform20main]').parsley().isValid()) {  
	//	alert(" "+year+" "+formId+ " " +flag);
		
		$('#formyear1').val(year);
		$('#frmFromDate1').val(fromdate);
		$('#frmToDate1').val(todate);
		
		
		var unit = $("#uformUnitId").val();
		var circle = $("#uformCircleId").val();
		var division = $("#uformDivisionId").val();
		var subdivision = $("#uformSubdivisionId").val();
		var designation = $("#uformDesignationId").val();
		var post = $("#uformPostId").val();
		var officeaccess = 1;
		var newdesignation=0;
		
		var officeaccess = 1;
		if (designation == 5) {
			newdesignation = 4;

		}

		if (designation == 7) {
			newdesignation = 5;

		}

		if (designation == 9) {
			newdesignation = 7;

		}

		if (designation == 10) {
			newdesignation = 9;

		}
		
		
		if ((unit != 4) || (unit != 9832) || (unit!=9830)) {
			if (((unit != 4 && unit != 9832 && unit!=9830) && unit > 0) && circle == 0
					&& division == 0 && subdivision == 0) {
				if ((designation == 2) || (designation == 4)
						|| (designation == 5) || (designation == 7)) {

						//	alert("2 designation"+designation);
					designation = 9;
					newdesignation = 7;
					officeaccess = 2;
					//	alert("altered designation"+designation);
				}
			}
		}
		
		 if (unit == 4 || unit == 9832 || unit==9830) {
			if ((unit == 4 && circle == 0 && division == 0 && subdivision == 0 && designation == 10)
					|| (unit == 4 && circle == 104 && division == 30327
							&& subdivision == 0 && (designation == 5
							|| designation == 4 || post == 3032797194 || post == 3032797190))
					|| (unit == 9832 && circle == 0 && division == 0 && subdivision == 0)
					|| (unit == 9832 && circle == 21606 && division == 0 && subdivision == 0)
					|| ((unit == 9830 && circle == 0 && division == 0 && subdivision == 0) && ((designation == 10
							|| designation == 5 || designation==4 || designation == 2 || designation==8)) )
					
					|| ((unit == 9830 && circle == 21609 && division == 0 && subdivision == 0) && ((designation == 7
							|| designation == 5 || designation==4 || designation == 2 || designation==8)))
					|| ((unit == 9830 && circle == 21609 && division == 31099 && subdivision == 0) && 
							(( designation == 5 || designation==4 || designation == 2 || designation==8)))
							
					|| ((unit == 9830 && circle == 21609 && division == 31099 && subdivision == 12173) && 
							((  designation==4 || designation == 2 || designation==8)))
			) {
						//	alert("3 designation"+designation);
				circle = 0;
				division = 0;
				designation = 10;
				newdesignation = 9;
				officeaccess = 3;
				//alert("altered designation"+designation);
			}
		}
		
		// alert("officeaccess" +officeaccess);
		
		$('#uformdrilldesgId').val(designation);
		$('#uformlistdesgId').val(newdesignation);
		//alert("newdesignation" +newdesignation);
	//	alert("uformdrilldesgId" +designation);
		
		
		$('#uformCircleId').val(circle);
	//	alert("circle" +circle);
		
		$('#uformDivisionId').val(division);
		$('#uformSubdivisionId').val(subdivision);
		
	//	alert("division" +division);
		$('#uformOfficeAccess').val(officeaccess);
	//	alert("officeaccess" +officeaccess);

	//	alert("tanks uform abdata officeaccess" +officeaccess+"unit"+unit+"circle"+circle+"division"+division+"subdivision"+subdivision+"designation"+designation);

		var act1 = "../invReport/tank-fdr-ab";
		var newformId1 = "#" + formId;

		$(newformId1).attr("action", act1);

		$(newformId1).submit();
		
	}
else {
		
		$('form[id=tankform20main]').parsley().validate();
	}
	
	
}


///start of new functions on 03082021










function gettankForm20abstract( year, designation, unit, circle,
		division, subdivision, post, officeaccess,formId,fromdate,todate) {

//alert("gettankForm20abstract "+formId+"designation"+designation+"unit"+unit+"circle"+circle+"division"+ division);

	var unit = unit;
	var circle = circle;
	var division = division;
	var subdivision = subdivision;
	var userdesignation = $("#uformDesignationId").val();
	//alert("userdesignation"+userdesignation);
	var designation = designation;

	var post = post;
	var officeaccessn = officeaccess;

	if (officeaccess == 1 && officeaccess != 2) {
		if (designation == 5) {
			newdesignation = 4;
		//	alert("newdesignation"+newdesignation);
			listdesig = 0;

		}
		if (designation == 7) {
			newdesignation = 5;
			listdesig = 4;

		}
		if (designation == 9) {
			newdesignation = 7;
			listdesig = 5;

		}
		if (designation == 10) {
			newdesignation = 9;
			listdesig = 7;

		}

	}

	if (officeaccess == 2) {
		userdesignation = 9;
		if (designation == 4) {
			newdesignation = 2;
			listdesig = 0;

		}

		if (designation == 5) {
			newdesignation = 4;
			listdesig = 0;

		}
		if (designation == 7) {
			newdesignation = 5;
			listdesig = 4;

		}
		if (designation == 9) {
			newdesignation = 7;
			listdesig = 5;

		}
		if (designation == 10) {
			newdesignation = 9;
			listdesig = 7;

		}

	}

	if (officeaccess == 3) {
		userdesignation = 10;
		if (designation == 4) {
			newdesignation = 2;
			listdesig = 0;
		}

		if (designation == 5) {
			newdesignation = 4;
		//	alert("newdesignation"+newdesignation);
			listdesig = 0;
		}
		if (designation == 7) {
			newdesignation = 5;
			listdesig = 4;

		}
		if (designation == 9) {
			newdesignation = 7;
			listdesig = 5;

		}
		if (designation == 10) {
			newdesignation = 9;
			listdesig = 7;

		}

	}
	
	
	
	$('#frmtempDesignationId').val(newdesignation);
//	alert("newdesignation"+newdesignation);
	$('#frmtempUnitId').val(unit);
	$('#frmtempCircleId').val(circle);
	$('#frmtempDivisionId').val(division);
	$('#frmtempSubDivisionId').val(subdivision);
	$('#frmyear').val(year);
	$('#frmdate').val(fromdate);
	$('#frmtodate').val(todate);
	

	$('#frmtempPostId').val(post);

	$('#frmbackdesgId').val(designation);
	$('#frmtempOfficeAccess').val(officeaccess);

	//var desg = $('#frmtempDesignationId').val();
//	alert("listdesig"+listdesig);
	
	$('#frmtemplistDesignationId').val(listdesig);
	
	//start of 2
	
	$('#frmtempDesignationId2').val(newdesignation);
//	alert("newdesignation"+newdesignation);
	$('#frmtempUnitId2').val(unit);
	$('#frmtempCircleId2').val(circle);
	$('#frmtempDivisionId2').val(division);
	$('#frmtempSubDivisionId2').val(subdivision);
	$('#frmyear2').val(year);
	$('#frmdate2').val(fromdate);
	$('#frmtodate2').val(todate);
	

	$('#frmtempPostId2').val(post);

	$('#frmbackdesgId2').val(designation);
	$('#frmtempOfficeAccess2').val(officeaccess);

	//var desg = $('#frmtempDesignationId2').val();
//	alert("listdesig"+listdesig);
	
	$('#frmtemplistDesignationId2').val(listdesig);
	
	// start of 3
	
	$('#frmtempDesignationId3').val(newdesignation);
//	alert("newdesignation"+newdesignation);
	$('#frmtempUnitId3').val(unit);
	$('#frmtempCircleId3').val(circle);
	$('#frmtempDivisionId3').val(division);
	$('#frmtempSubDivisionId3').val(subdivision);
	$('#frmyear3').val(year);
	$('#frmdate3').val(fromdate);
	$('#frmtodate3').val(todate);
	

	$('#frmtempPostId3').val(post);

	$('#frmbackdesgId3').val(designation);
	$('#frmtempOfficeAccess3').val(officeaccess);

	//var desg = $('#frmtempDesignationId3').val();
//	alert("listdesig"+listdesig);
	
	$('#frmtemplistDesignationId3').val(listdesig);
	
	

	var act1 = "../invReport/tank-form20-ab";
	
	var newformId1 = "#"+formId;
	//var newformId1 = "#tankform20report";

	$(newformId1).attr("action", act1);

	$(newformId1).submit();

}



function getForm20tanks( year, designation, unit, circle,	division, subdivision, post,catId, frmyear, frmdate,frmtodate) {
	
	//alert(catId+"catId");

	var unit = unit
	var circle = circle
	var division = division
	var subdivision = subdivision
	var userdesignation = $("#userDesignationId").val();
	var designation = designation;
	var post = post;

	//	alert("getcapNewdetailsbyoffice unit"+unit+"circle"+circle+"division"+division+"subdivision"+subdivision+"designation"+designation+"post"+post);

	$('#frmtempDesignationId').val(designation);
	$('#frmtempUnitId').val(unit);
	$('#frmtempCircleId').val(circle);
	$('#frmtempDivisionId').val(division);
	$('#frmtempSubDivisionId').val(subdivision);
	$('#frmyear').val(frmyear);
	
	$('#frmdate').val(frmdate);
	$('#frmtodate').val(frmtodate);
	
	
	
	
	$('#frmcatId').val(catId);

	

	$('#frmtempPostId').val(post);
	;

	var desg = $('#frmtempDesignationId').val();
//	alert("fdr desg"+desg);
	
	//alert("tankform20report1");

	var act1 = "../invReport/tank-fdr-ab-detail";
	var newformId1 = "#tankform20report1";

	$(newformId1).attr("action", act1);
	// $(newformId2).attr("action", act2);
	/* $(newformId3).attr("action", act3);
	 $(newformId4).attr("action", act4);*/
	// $(newformId5).attr("action", act5);

	$(newformId1).submit();

}



function getForm20reservoirs( year, designation, unit, circle,	division, subdivision, post,catId) {
	
	//alert(catId+"catId");

	var unit = unit
	var circle = circle
	var division = division
	var subdivision = subdivision
	var userdesignation = $("#userDesignationId").val();
	var designation = designation;
	var post = post;

	//	alert("getcapNewdetailsbyoffice unit"+unit+"circle"+circle+"division"+division+"subdivision"+subdivision+"designation"+designation+"post"+post);

	$('#frmtempDesignationId2').val(designation);
	$('#frmtempUnitId2').val(unit);
	$('#frmtempCircleId2').val(circle);
	$('#frmtempDivisionId2').val(division);
	$('#frmtempSubDivisionId2').val(subdivision);
	$('#frmyear2').val(year);
	$('#frmcatId2').val(catId);

	

	$('#frmtempPostId2').val(post);
	;

	var desg = $('#frmtempDesignationId2').val();
//	alert("fdr desg"+desg);

	var act1 = "../invReport/tank-form20-ab-detail";
	var newformId1 = "#tankform20report2";

	$(newformId1).attr("action", act1);
	// $(newformId2).attr("action", act2);
	/* $(newformId3).attr("action", act3);
	 $(newformId4).attr("action", act4);*/
	// $(newformId5).attr("action", act5);

	$(newformId1).submit();

}


function getForm20canals( year, designation, unit, circle,	division, subdivision, post,catId) {
	
	//alert(catId+"catId");

	var unit = unit
	var circle = circle
	var division = division
	var subdivision = subdivision
	var userdesignation = $("#userDesignationId").val();
	var designation = designation;
	var post = post;

	//	alert("getcapNewdetailsbyoffice unit"+unit+"circle"+circle+"division"+division+"subdivision"+subdivision+"designation"+designation+"post"+post);

	$('#frmtempDesignationId3').val(designation);
	$('#frmtempUnitId3').val(unit);
	$('#frmtempCircleId3').val(circle);
	$('#frmtempDivisionId3').val(division);
	$('#frmtempSubDivisionId3').val(subdivision);
	$('#frmyear3').val(year);
	$('#frmcatId3').val(catId);

	

	$('#frmtempPostId3').val(post);
	;

	var desg = $('#frmtempDesignationId3').val();
//	alert("fdr desg"+desg);

	var act1 = "../invReport/tank-form20-ab-detail";
	var newformId1 = "#tankform20report3";

	$(newformId1).attr("action", act1);
	// $(newformId2).attr("action", act2);
	/* $(newformId3).attr("action", act3);
	 $(newformId4).attr("action", act4);*/
	// $(newformId5).attr("action", act5);

	$(newformId1).submit();

}




function getForm20DetailReport(formDataId,catId, formId) {
	
var formIdtarget="#"+formId;
	 $(formIdtarget).attr('target', '_blank');
	 //alert("formIdtarget"+formIdtarget)
	
	if(catId==1){
	$("#form20DataId").val(formDataId);
	$("#frmcatId").val(catId);
	}
	if(catId==2){
		$("#form20DataId2").val(formDataId);
		$("#frmcatId2").val(catId);
		}
	if(catId==3){
		$("#form20DataId3").val(formDataId);
		$("#frmcatId3").val(catId);
		}
	
	
	//alert("cominghere getForm20DetailReport"+formDataId);
	var act = "../form20report/downloadform20PDF";
	var formId = "#" + formId;
	$(formId).attr("action", act);
	$(formId).submit();
	/*var features = "width=500,height=300,menubar=no,status=no,location=no,toolbar=no,scrollbars=yes,top=100,left=50";
	var url = "../form20report/downloadform20PDF?formDataId=" + formDataId
	popup = window.open(url, "_blank", features);
	popup.moveTo(0, 0);
	  popup.resizeTo(screen.width, screen.height);*/
}

function getForm20ImagesReport(formDataId,catId, formId) {
	
	var formIdtarget="#"+formId;
	
	var attr = $(formIdtarget).attr('target');

	// For some browsers, `attr` is undefined; for others,
	// `attr` is false.  Check for both.
	
	//alert("attr"+attr);
	if (typeof attr == 'undefined' || attr == false) {
	   
		 $(formIdtarget).attr('target', '_blank');
	}
	
	
	if(catId==1){
		$("#form20DataId").val(formDataId);
		$("#frmcatId").val(catId);
		}
		if(catId==2){
			$("#form20DataId2").val(formDataId);
			$("#frmcatId2").val(catId);
			}
		if(catId==3){
			$("#form20DataId3").val(formDataId);
			$("#frmcatId3").val(catId);
			}
	
	
	//$("#form20DataId").val(formDataId);
	//alert("cominghere getForm20DetailReport"+formDataId);
	var act = "../form20report/form20PDFDownloaddata";
	var formId = "#" + formId;
	$(formId).attr("action", act);
	$(formId).submit();
	/*var features = "width=500,height=300,menubar=no,status=no,location=no,toolbar=no,scrollbars=yes,top=100,left=50";
	var url = "../form20report/downloadform20PDF?formDataId=" + formDataId
	popup = window.open(url, "_blank", features);
	popup.moveTo(0, 0);
	  popup.resizeTo(screen.width, screen.height);*/
}








function viewfrmphtfn(formdataId,tankname,formId){
	
	//alert("formdataId"+formdataId)
	
	
	
	
	 $('#frm20_doc_dia').dialog('option', 'title', 'View Photos');
	  $('#frm20_doc_dia').dialog('open');
	  
	  
	  $('#action_alert').empty();
	  
	  
		$("#doc-thead10").empty();
		$("#doc-tbody10").empty();
	
	

		$.ajax({	          
		      url: "../invtsimis/get-frm-docs?formDataId="+formdataId,
		      type: "GET",
		      success: function (response) {
		    	  
		    	
		    	
		    	  var j=1;
		    	  
		    	  $('#docfrm20 table thead').append( '<tr style="font-size: 18px; color: gray; font-weight: bold;"><th>Sl.No</th>'+
		    	    		
		    	    		'<th>File Name</th>'+
		    	    	
		    	    		/*'  <th>Latest</th>'+*/
		    	    		'  <th>Download File</th>'+
		    	    		'  <th>View File</th>'+
		    	    		
		    	    		
		    	    		
		    	    		'</tr>'); 
		    	  
		    	  $('#docfrm20 table thead').append( '<tr style="font-size: 18px; color: gray; font-weight: bold;"><td></td>'+
		    	    		
		    	    		'<td>'+tankname+'</td>'+
		    	    	
		    	    		/*'  <th>Latest</th>'+*/
		    	    		'  <td></td>'+
		    	    		'  <td></td>'+
		    	    		
		    	    		
		    	    		
		    	    		'</tr>'); 
				 
				
						var obj = JSON.parse(response);
						$.each(obj, function(key, value) {
							
							
							  $('#docfrm20 table tbody').append(  '<tr style="font-size: 16px ; color:blue">' +
		                                '<td style="text-align: center;">'+j+'</td>' +
		                                
		                                '<td><b>'+value.formDocOriginalName+'</b></td>' +
		                               
		                                '<td style="color:blue"><b><a target="_blank" href="../uploadedFiles/FormDocs/'+value.formDocName+'" ><u>Download File<u></a></b></td>' +
		                                '<td style="color:blue"><b><img src="../uploadedFiles/FormDocs/'+value.formDocName+'" alt="'+value.formDocOriginalName+'" class="img-responsive img-thumbnail"/></td>' +                   
		                                
		                                '</tr>');
						
							   j++;
							  
							 
						});

		      },
		      error : function(){
		    	  alert(error);
		      }
		  });	
		
	
}





function viewfrmphtfnserver(formdataId,tankname,formId){
	
	//alert("formdataId"+formdataId)
	
	//alert("formId"+formId);
	
	
var formIdtarget="#"+formId;
	
	var attr = $(formIdtarget).attr('target');

	// For some browsers, `attr` is undefined; for others,
	// `attr` is false.  Check for both.
	
	//alert("attr"+attr);
	if (typeof attr == 'undefined' || attr == false) {
	   
		 $(formIdtarget).attr('target', '_blank');
	}
	
	
	
	  
	//  $('#action_alert').empty();
	  
	  
	
		
		if(formId=="tankform20report1"){
		
$("#form20DataId").val(formdataId);
$("#sourceName").val(tankname);

		}
		if(formId=="tankform20report2"){
			
			$("#form20DataId2").val(formdataId);
			$("#sourceNam2").val(tankname);

					}
		
		if(formId=="tankform20report3"){
			
			$("#form20DataId3").val(formdataId);
			$("#sourceName3").val(tankname);

					}
		
		
		
		var act1 = "../invReport/get-frm-photos"
var newformId1 = "#"+formId ;

$(newformId1).attr("action", act1);

$(newformId1).submit();
	
	

		
		
	
}



	



