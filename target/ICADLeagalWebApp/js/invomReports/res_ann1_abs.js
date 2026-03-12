


$(document).ready(function(){
	
	// $('.eeinf').hide(); 
	// $('.cateeinf').hide();
	 
	 $('.tablech').hide(); 
	 $('.tablech1').hide(); 
	 
	
	// $('.eeinfcircle').hide(); 		
			
	      
	 });
	
	

/*function getresunitlist (unitId){
	
	 $('.eeinf').hide(); 
	
	//alert("unitId"+unitId);
	
	var clsname=".list"+unitId;
	
	//alert(clsname);
	
	$(clsname).show();
	
	
}
*/

/*function getcatresunitlist (unitId){
	
	// $('.cateeinf').hide(); 
	 $('.tablech').hide(); 
	  
	 
	
	//alert("unitId"+unitId);
	
	///var clsname=".catlist"+unitId;
	
	var idname="#tablechild"+unitId;
	
	alert(idname);
	
	//$(clsname).show();
	
	$(idname).show();
	
	
}*/

















function getresabstractdata(year,dutyFrequencyId,formId,flag)
{
	
//alert(cagGistId);
	/*document.forms[0].urlvalue.value="../invReport/res-ann1-abstract";
	
	   $("#year").val(year);
	   
	   $("#dutyFrequencyId").val(dutyFrequencyId);
	   
	
	var act = "../invReport/res-ann1-abstract";
	var formId = "#" + formId;
	$(formId).attr("action", act);
	$(formId).submit();*/
	
	
	
	/*if(flag==true){
		$('#year').removeAttr('required'); 
		
		$('#dutyFrequencyId').removeAttr('required'); 
		
	}*/
		
		if ($('form[id='+formId+']').parsley().isValid()) {  
	
		

	
	
		
		
	
	//	alert(" "+year+" "+formId+ " " +flag);
		
	
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
		
		//alert("kal")
		
		if (((unit != 4) || (unit != 9832) || (unit!=9830) || (unit!=9)) && (post != 1106177746 || post!=931 || post!=932 || post!=921 || post!=911 ) ) {
			if ((((unit != 4 && unit != 9832 && unit!=9830 && unit!=9) && unit > 0) && circle == 0
					&& division == 0 && subdivision == 0) && (post != 1106177746)) {
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
		
		 if (unit == 4 || unit == 9832 || unit==9830 || (unit==9 && ( post == 83125 ||  post == 83213 || post==83266   || post==931 || post==932 || post==921 || post==911)) ) {
			if ((( unit == 4 && circle == 0 && division == 0 && subdivision == 0 && designation == 10)
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
							
					|| ((unit == 9) && ( post == 83125 || post == 83213 || post==83266 || post == 931 ||  post == 932 ||  post == 921 || post == 911))
					
					
					
			) ) {
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

		var act1 = "../invReport/res-ann1-abstract";
		var newformId1 = "#" + formId;

		$(newformId1).attr("action", act1);

		$(newformId1).submit();
		
	}
else {
		
		$('form[id='+formId+']').parsley().validate();
	}
	
	
	}
	



function getresann1details(year,dutyFrequencyId, designation, unit, circle,	division, subdivision, post,conditionofDamId,formId) {

	/*unitId,year,conditionofDamId, formId*/
/*	$("#conditionofDamId").val(conditionofDamId);
	$("#unitId").val(unitId);
	$("#year1").val(year);
	var act = "../invReport/res-ann1-Detail";
	var formId = "#" + formId;
	$(formId).attr("action", act);
	$(formId).submit();
*/
	
	var unit = unit
	var circle = circle
	var division = division
	var subdivision = subdivision
	var userdesignation = $("#userDesignationId").val();
	var designation = designation;
	var post = post;
	
	if(formId='res2'){
	$('#frmtempDesignationId').val(designation);
	$('#frmtempUnitId').val(unit);
	$('#frmtempCircleId').val(circle);
	$('#frmtempDivisionId').val(division);
	$('#frmtempSubDivisionId').val(subdivision);
	$('#year1').val(year);
	
	$('#dutyFrequencyId1').val(dutyFrequencyId);
	
	$('#conditionofDamId').val(conditionofDamId);

	

	$('#frmtempPostId').val(post);
	
	var desg = $('#frmtempDesignationId').val();
	
	}else if (formId='res22'){
		
		$('#frmtempDesignationId2').val(designation);
		$('#frmtempUnitId2').val(unit);
		$('#frmtempCircleId2').val(circle);
		$('#frmtempDivisionId2').val(division);
		$('#frmtempSubDivisionId2').val(subdivision);
		$('#year2').val(year);
		
		$('#dutyFrequencyId2').val(dutyFrequencyId);
		
		$('#conditionofDamId2').val(conditionofDamId);

		

		$('#frmtempPostId2').val(post);
		
		var desg = $('#frmtempDesignationId2').val();
		
		
	}
//	alert("fdr desg"+desg);
	
	//alert("tankform20report1");

	var act = "../invReport/res-ann1-Detail";
	var formId = "#" + formId;
	$(formId).attr("action", act);
	$(formId).submit();
	;
}



function getrescategorydetails(year,dutyFrequencyId, designation, unit, circle,	division, subdivision, post,category,formId) {

	/*unitId,year,conditionofDamId, formId*/
/*	$("#conditionofDamId").val(conditionofDamId);
	$("#unitId").val(unitId);
	$("#year1").val(year);
	var act = "../invReport/res-ann1-Detail";
	var formId = "#" + formId;
	$(formId).attr("action", act);
	$(formId).submit();
*/
	
	var unit = unit
	var circle = circle
	var division = division
	var subdivision = subdivision
	var userdesignation = $("#userDesignationId").val();
	var designation = designation;
	var post = post;
	
	if(formId='res2'){
	$('#frmtempDesignationId').val(designation);
	$('#frmtempUnitId').val(unit);
	$('#frmtempCircleId').val(circle);
	$('#frmtempDivisionId').val(division);
	$('#frmtempSubDivisionId').val(subdivision);
	$('#year1').val(year);
	
	$('#dutyFrequencyId1').val(dutyFrequencyId);
	
	$('#deficiencyCategory').val(category);

	

	$('#frmtempPostId').val(post);
	
	var desg = $('#frmtempDesignationId').val();
	
	}else if (formId='res22'){
		
		$('#frmtempDesignationId2').val(designation);
		$('#frmtempUnitId2').val(unit);
		$('#frmtempCircleId2').val(circle);
		$('#frmtempDivisionId2').val(division);
		$('#frmtempSubDivisionId2').val(subdivision);
		$('#year2').val(year);
		
		$('#dutyFrequencyId2').val(dutyFrequencyId);
		
		$('#deficiencyCategory2').val(category);

		

		$('#frmtempPostId2').val(post);
		
		var desg = $('#frmtempDesignationId2').val();
		
		
	}
//	alert("fdr desg"+desg);
	
	//alert("tankform20report1");

	var act = "../invReport/res-category-Detail";
	var formId = "#" + formId;
	$(formId).attr("action", act);
	$(formId).submit();
	;
}



function getresann1totalres(year,dutyFrequencyId, designation, unit, circle,	division, subdivision, post,conditionofDamId,formId) {


    
	/*unitId,year,conditionofDamId, formId*/
/*	$("#conditionofDamId").val(conditionofDamId);
	$("#unitId").val(unitId);
	$("#year1").val(year);
	var act = "../invReport/res-ann1-Detail";
	var formId = "#" + formId;
	$(formId).attr("action", act);
	$(formId).submit();
*/
	
	var unit = unit
	var circle = circle
	var division = division
	var subdivision = subdivision
	var userdesignation = $("#userDesignationId").val();
	var designation = designation;
	var post = post;
	
	if(formId='res2'){
	
	$('#frmtempDesignationId').val(designation);
	$('#frmtempUnitId').val(unit);
	$('#frmtempCircleId').val(circle);
	$('#frmtempDivisionId').val(division);
	$('#frmtempSubDivisionId').val(subdivision);
	$('#year1').val(year);
	
	$('#dutyFrequencyId1').val(dutyFrequencyId);
	
	$('#conditionofDamId').val(conditionofDamId);

	

	$('#frmtempPostId').val(post);
	
	var desg = $('#frmtempDesignationId').val();
	
	}else if (formId='res22'){
		
		
		$('#frmtempDesignationId2').val(designation);
		$('#frmtempUnitId2').val(unit);
		$('#frmtempCircleId2').val(circle);
		$('#frmtempDivisionId2').val(division);
		$('#frmtempSubDivisionId2').val(subdivision);
		$('#year2').val(year);
		
		$('#dutyFrequencyId2').val(dutyFrequencyId);
		
		$('#conditionofDamI2').val(conditionofDamId);

		

		$('#frmtempPostId2').val(post);
		
		var desg = $('#frmtempDesignationId2').val();
		
		
	}
//	alert("fdr desg"+desg);
	
	//alert("tankform20report1");
	
	
	

	// For some browsers, `attr` is undefined; for others,
	// `attr` is false.  Check for both.
	
	//alert("attr"+attr);
	
	/*var attrnew = $(formIdtarget).attr('target');
	
    alert(attrnew+"attrnew");
	if (typeof attrnew == 'undefined' || attrnew == false) {
	   
		 $(formIdtarget).attr('target', '_blank');
	}
	*/
	

	var act = "../invReport/res-ann1-Total-res";
	var formId = "#" + formId;
	$(formId).attr("action", act);
	$(formId).submit();
	;
}


function getresALLann1totalres(year,dutyFrequencyId, designation, unit, circle,	division, subdivision, post,conditionofDamId,formId) {



	
	var unit = unit
	var circle = circle
	var division = division
	var subdivision = subdivision
	var userdesignation = $("#userDesignationId").val();
	var designation = designation;
	var post = post;
	
	if(formId='res2'){
	
	$('#frmtempDesignationId').val(designation);
	$('#frmtempUnitId').val(unit);
	$('#frmtempCircleId').val(circle);
	$('#frmtempDivisionId').val(division);
	$('#frmtempSubDivisionId').val(subdivision);
	$('#year1').val(year);
	
	$('#dutyFrequencyId1').val(dutyFrequencyId);
	
	$('#conditionofDamId').val(conditionofDamId);

	

	$('#frmtempPostId').val(post);
	
	var desg = $('#frmtempDesignationId').val();
	
	}else if (formId='res22'){
		
		
		$('#frmtempDesignationId2').val(designation);
		$('#frmtempUnitId2').val(unit);
		$('#frmtempCircleId2').val(circle);
		$('#frmtempDivisionId2').val(division);
		$('#frmtempSubDivisionId2').val(subdivision);
		$('#year2').val(year);
		
		$('#dutyFrequencyId2').val(dutyFrequencyId);
		
		$('#conditionofDamI2').val(conditionofDamId);

		

		$('#frmtempPostId2').val(post);
		
		var desg = $('#frmtempDesignationId2').val();
		
		
	}


	var act = "../invReport/res-All-ann1-Total-res";
	var formId = "#" + formId;
	$(formId).attr("action", act);
	$(formId).submit();
	;
}

$(document).ready(function() {

	$('#dutyFrequencyId').multiselect({

		enableCaseInsensitiveFiltering : true

	});
	
	$('#year').multiselect({

		enableCaseInsensitiveFiltering : true

	});

});







$(function() {
	
	
	 
	

    /* table.on("user-select", function (e, dt, type, cell, originalEvent) {
         if ($(cell.node()).hasClass("details-control")) {
             e.preventDefault();
         }
     });*/
	
	$("#abs1").tabs();
	
	
	$('a[data-toggle="tab"]').on('show.bs.tab', function(e) {
	        localStorage.setItem('activeTab', $(e.target).attr('href'));
	    });
	    var activeTab = localStorage.getItem('activeTab');
	    if(activeTab){
	    	//alert(activeTab);
	        $('#tmsreportstab a[href="' + activeTab + '"]').click();
	    }

	
	var totalres=$("#totalres").val();
	var restotalsubmitted=$("#restotalsubmitted").val();
	var resunsatisfactory=$("#resunsatisfactory").val();
	var respoor=$("#respoor").val();
	var resfair=$("#resfair").val();
	var ressatisfactory=$("#ressatisfactory").val();

	
	/*am4core.useTheme(am4themes_animated);
	// Themes end

	var chart = am4core.createFromConfig({

	  "data": [{
	    "name": "Total Reservoirs",
	    "value": totalres,
	    "percentage":"100%"
	  }, {
	    "name": "Total Submitted",
	    "value": restotalsubmitted,
	    "percentage": restotalsubmitted/totalres+"%"
	  }, {
	    "name": "Unsatisfactory",
	    "value": resunsatisfactory,
	    "percentage": resunsatisfactory/totalres+"%"
	  }, {
	    "name": "Poor",
	    "value": respoor,
	    "percentage":respoor/totalres+"%"
	  }, {
	    "name": "Fair",
	    "value": resfair,
	    "percentage":resfair/totalres+"%"
	  }, {
	    "name": "Satisfactory",
	    "value": ressatisfactory,
	    "percentage":ressatisfactory/totalres+"%"
	  }],

	  "hiddenState": {
	    "properties": {
	      "opacity": 0
	    }
	  },
	  
	
	  "series": [{
	    "type": "FunnelSeries",
	    "alignLabels": true,
	    "calculatePercent":false,
	   
	    "dataFields": {
	      "value": "value",
	      "category": "name"
	    },
	    "colors": {
	      "step": 2
	    }
	  }],

	  "labelsContainer": {
	    "paddingLeft": 15,
	    "width": 200
	  },

	  "legend": {
	    "position": "left",
	    "valign": "bottom",
	    "marginTop": 5,
	    "marginRight": 5,
	    "marginBottom": 20,
	    "marginLeft": 5
	  }

	}, "chartdiv", "SlicedChart");
	
	  var series = chart.series.push(new am4charts.FunnelSeries());
	  series.colors.step = 2;
	  series.dataFields.value = "value";
	  series.dataFields.category = "name";
	  series.alignLabels = true;

	  series.labelsContainer.paddingLeft = 15;
	  series.labelsContainer.width = 200;
	  series.labels.template.text = "{category}: {percentage}";
	  
	 
	  
	  chart.legend.itemContainers.template.tooltipText = "{category}: {percentage}";
	  chart.legend.labels.template.truncate = false;
	  chart.legend.labels.template.wrap = true;

	 // var legend = chart.legend = new am4charts.Legend();
	  var legend = new am4charts.Legend();
	    legend.borderAlpha = 0.2;
	    legend.horizontalGap = 10;
	    legend.spacing = 30;
	    legend.position = "left";
	    legend.useGraphSettings = false;
	    legend.valueWidth = 100;
	    legend.labelWidth = 200;
	    legend.valueAlign = "left";
	    legend.equalWidths = true;
	    legend.markerLabelGap = 3;                   
*/
	

});
