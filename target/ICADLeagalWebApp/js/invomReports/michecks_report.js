$(function() {
	//$("#tankreportmaintabs").tabs();
	//$("#itrpt").hide();
	
	//$("#form20subrpt").hide();
	
	$("#tabs").tabs();

	$("#tabs2").tabs();

	$("#verticaltii").tabs().addClass("ui-tabs-vertical ui-helper-clearfix");
	$("#verticaltii li").removeClass("ui-corner-top")
			.addClass("ui-corner-left");

	$("#verticalrh").tabs().addClass("ui-tabs-vertical ui-helper-clearfix");
	$("#verticalrh li").removeClass("ui-corner-top").addClass("ui-corner-left");

	var l_tot_a = 0;
	var l_tot_b = 0;
	var l_em_a = 0;
	var l_em_b = 0;
	var l_ob_a = 0;
	var l_ob_b = 0;
	var l_def_a = 0;
	var l_def_b = 0;
	var l_org_a = 0;
	var l_org_b = 0;

	var tot2a = parseInt($('.gramtot2a').val());
	var tot2b = parseInt($('.gramtot2b').val());
	var em2a = parseInt($('.gramem2a').val());
	var em2b = parseInt($('.gramem2b').val());
	var ob2a = parseInt($('.gramob2a').val());
	var ob2b = parseInt($('.gramob2b').val());
	var dif2a = parseInt($('.gramdef2a').val());
	var dif2b = parseInt($('.gramdef2b').val());
	var org2a = parseInt($('.gramorgwk2a').val());
	var org2b = parseInt($('.gramorgwk2b').val());
	$('.gramtot2a').each(function() {
		l_tot_a = l_tot_a + parseInt($(this).val());
	});
	$('.gramtot2b').each(function() {
		l_tot_b = l_tot_b + parseInt($(this).val());
	});

	$('.gramem2a').each(function() {
		l_em_a = l_em_a + parseInt($(this).val());
	});
	$('.gramem2b').each(function() {
		l_em_b = l_em_b + parseInt($(this).val());
	});

	$('.gramob2a').each(function() {
		l_ob_a = l_ob_a + parseInt($(this).val());
	});
	$('.gramob2b').each(function() {
		l_ob_b = l_ob_b + parseInt($(this).val());
	});
	$('.gramdef2a').each(function() {
		l_def_a = l_def_a + parseInt($(this).val());
	});

	$('.gramdef2b').each(function() {
		l_def_b = l_def_b + parseInt($(this).val());
	});
	$('.gramorgwk2a').each(function() {
		l_org_a = l_org_a + parseInt($(this).val());
	});

	$('.gramorgwk2b').each(function() {
		l_org_b = l_org_b + parseInt($(this).val());
	});

	//alert("l_tot_a"+l_tot_a+"l_tot_b"+l_tot_b+"l_em_a"+l_em_a+"l_em_b"+l_em_b+"l_ob_a"+l_ob_a+"l_def_a"+l_def_a+"l_def_b"+l_def_b+"l_org_a"+l_org_a+"l_org_b"+l_org_b);

	if ((tot2a > 0 || tot2a == 0) && (em2a > 0 || em2a == 0)
			&& (ob2a > 0 || ob2a == 0) && (dif2a > 0 || dif2a == 0)
			&& (org2a > 0 || org2a == 0)) {

		graphDisplay(l_tot_a, l_em_a, l_ob_a, l_def_a, l_org_a);
	}

	if ((tot2b > 0 || tot2b == 0) && (em2b > 0 || em2b == 0)
			&& (ob2b > 0 || ob2b == 0) && (dif2b > 0 || dif2b == 0)
			&& (org2b > 0 || org2b == 0)) {

		graphDisplay(l_tot_b, l_em_b, l_ob_b, l_def_b, l_org_b);
	}

	$('#districtId').multiselect({

		enableCaseInsensitiveFiltering : true

	});

	$('#mandalId').multiselect({

		enableCaseInsensitiveFiltering : true

	});

	$('#villageId').multiselect({

		enableCaseInsensitiveFiltering : true

	});

	$('#tankId').multiselect({

		enableCaseInsensitiveFiltering : true

	});

	$('#miyear').multiselect({

		enableCaseInsensitiveFiltering : true

	});
	$('#form20year').multiselect({

		enableCaseInsensitiveFiltering : true

	});

	$('#newmiTankFreqId').multiselect({

		enableCaseInsensitiveFiltering : true

	});

	$("#districtId").change(function() {
		var id = $(this).val();

		$('#districtId1').val(id);
		$('#districtId2').val(id);
		$('#districtId3').val(id);
		$('#districtId4').val(id);

	});
	/*$("#itrpt").click(function() {
		$("#form20subrpt").hide();
		$("#itrpt").show();

	});
	$("#form20subrpt").click(function() {
		$("#itrpt").hide();
		$("#form20subrpt").show();

	});
*/

	$("#mandalId").change(function() {
		var id = $(this).val();

		$('#mandalId1').val(id);
		$('#mandalId2').val(id);
		$('#mandalId3').val(id);
		$('#mandalId4').val(id);

	});

	$("#villageId").change(function() {
		var id = $(this).val();

		$('#villageId1').val(id);
		$('#villageId2').val(id);
		$('#villageId3').val(id);
		$('#villageId4').val(id);

	});
	
	 $('a[data-toggle="tab"]').on('show.bs.tab', function(e) {
	        localStorage.setItem('activeTab', $(e.target).attr('href'));
	    });
	    var activeTab = localStorage.getItem('activeTab');
	    if(activeTab){
	    	//alert(activeTab);
	        $('#tmsreportstab a[href="' + activeTab + '"]').click();
	    }

	$("#tankId").change(function() {
		var id = $(this).val();

		$('#tankId1').val(id);
		$('#tankId2').val(id);
		$('#tankId3').val(id);
		$('#tankId4').val(id);

	});

	$('#viewRemarks_dialogue').dialog({
		autoOpen : false,
		width : 1200,
		close : function() {

			$(this).dialog("close");
		}
	});
	
	
	$(".rview").hide();
	
	 
	$('#frm20_doc_dia').dialog({
		  autoOpen:false,
		  width:1200,
		  close: function() {
			  
			
				  $(this).dialog("close");
				  }
		 });
	
	

});

function getMandals(b, hkey) {

	//alert("kal"+b);

	var districtId = b
	//document.getElementById("districtId").value;

	//alert(districtId);
	$('#mcode').val(0);
	$
			.ajax({
				url : "../web/getMandals?districtId=" + districtId,
				type : "GET",
				success : function(response) {
					if (hkey == 1) {
						var $select = $('#mandalId1');
						$select.find('option').remove();
						$('#mandalId').append(
								'<option value=" "> --select--</option>');
					}

					// var selectedMandal=$('#selectedMandalId').val();
					//  alert("selected"+selectedMandal);

					var obj = JSON.parse(response);
					$.each(obj, function(key, value) {
						if (hkey == 1) {
							$('#mandalId').append(
									'<option value="' + value.mandalId
											+ '"  > ' + value.mandalName
											+ '</option>');
							$('#mcode').val(value.mandalCode);
						}

						if (hkey == 1) {

							$('#mandalId').multiselect('rebuild');
						}

					});

				},
				error : function() {
					alert(error);
				}
			});
}

function getVillages(mandal, hkey) {
	//alert("kal");
	//var districtId=document.getElementById("districtId").value;
	var mandalId = mandal;
	//document.getElementById("mandalId").value;
	//alert(mandalId);
	$('#vcode').val(0);
	$.ajax({
		url : "../web/getVillages?mandalId=" + mandalId,
		type : "GET",
		success : function(response) {

			if (hkey == 1) {
				var $select = $('#villageId');

				$select.find('option').remove();
				$('#villageId')
						.append('<option value="0"> --select--</option>');

			}

			var obj = JSON.parse(response);

			$.each(obj, function(key, value) {

				if (hkey == 1) {

					$('#villageId').append(
							'<option value="' + value.villageId + '" > '
									+ value.villageName + '</option>');
					$('#vcode').val(value.villageCode);

				}

				if (hkey == 1) {
					$('#villageId').multiselect('rebuild');
				}

			});

		},
		error : function() {
			alert(error);
		}
	});
}

function getHabitations(districtId, mcode, vcode, hkey) {
	//alert("kal");
	//var districtId=document.getElementById("districtId").value;
	var districtId = districtId;
	var mcode = parseInt(mcode);
	//alert(mcode);
	var vcode = parseInt(vcode);
	//alert(vcode);
	//document.getElementById("mandalId").value;
	//alert(mandalId);

	if (hkey == 1) {
		$('#habitationId').multiselect('rebuild');
	}

	if (hkey == 2) {
		$('#habitationId').multiselect('rebuild');
	}

	if (hkey == 3) {
		$('#habitationId').multiselect('rebuild');
	}

	$.ajax({
		url : "../invtsimis/getHabitations?dId=" + districtId + "&mId=" + mcode
				+ "&vId=" + vcode,
		type : "GET",
		success : function(response) {

			if (hkey == 1) {
				var $select = $('#habitationId');
				var selectedHabit = 0;

				$select.find('option').remove();

			}

			var obj = JSON.parse(response);

			if (hkey == 1) {
				$('#habitationId').append(
						'<option value="0"> --select--</option>');
			}

			$.each(obj, function(key, value) {

				if (hkey == 1) {

					if (selectedHabit == value.hId) {

						$('#habitationId').append(
								'<option value="' + value.hId
										+ '"  selected="selected" > '
										+ value.hname + '</option>');

					}
					if (selectedHabit == null || selectedHabit == 0
							|| selectedHabit != value.hId) {
						//alert("coming2");
						$('#habitationId').append(
								'<option value="' + value.hId + '"   > '
										+ value.hname + '</option>');

					}
					$('#habitationId').multiselect('rebuild');

				}

			});

		},
		error : function() {
			alert(error);
		}
	});
}
function getmkrepairdatafun(x) {
	var workId = x;
	
	var divid="#rdata"+x;
	
if(x>0){
	//alert(divid);
	 $(".rview").hide();
   $(divid).removeAttr("style");
   
}
	
	
	
	
}
function getTanks(districtId, mcode, vcode, hcode, hkey) {

	//alert("kal"+b);

	var districtId = districtId;
	var mcode = parseInt(mcode);
	var vcode = parseInt(vcode);
	var hcode = parseInt(hcode);
	//document.getElementById("districtId").value;

	//alert(districtId);

	$.ajax({
		url : "../invtsimis/getTanks?dId=" + districtId + "&mId=" + mcode
				+ "&vId=" + vcode + "&hId=" + hcode,
		type : "GET",
		success : function(response) {
			if (hkey == 1) {

				var $select = $('#tankId');
				$select.find('option').remove();
				$('#tankId').append('<option value=" "> --select--</option>');
			}

			// var selectedTank=$('#selectedtankId').val();
			//  alert("selected"+selectedMandal);

			var obj = JSON.parse(response);
			$.each(obj, function(key, value) {

				if (hkey == 1) {
					//alert("coming1");
					$('#tankId').append(
							'<option value="' + value.tankId + '"  > '
									+ value.tankName + '</option>');
				}

				if (hkey == 1) {
					$('#tankId').multiselect('rebuild');
				}

			});

		},
		error : function() {
			alert(error);
		}
	});
}

function gettankdetail(miInpsectMst1Id, formId) {

	$("#miInpsectMst1Idhidden").val(miInpsectMst1Id);

	var act = "../invReport/TankDetail";
	var formId = "#" + formId;
	$(formId).attr("action", act);
	$(formId).submit();

}

	
	
function gettankabstractdata(miTankFreqId, year, formId) {

	$('#year1').val(year);
	$('#miTankFreqId').val(miTankFreqId);

	var act1 = "../invReport/Tank-checks?year=" + year + "&miTankFreqId="
			+ miTankFreqId;
	var newformId1 = "#" + formId;

	$(newformId1).attr("action", act1);

	$(newformId1).submit();

	$(newformId3).submit();
	$(newformId4).submit();

	$(newformId5).submit();

}
function getform20tankabdata(year, formId,flag){
	
	//	alert(" "+year+" "+formId+ " " +flag);
	
	if(flag==false){
		$('#form20year').removeAttr('required'); 
	
		
	}
	
	
		
		
	if ($('form[id=tankform20main]').parsley().isValid()) {  
	//	alert(" "+year+" "+formId+ " " +flag);
		
		$('#formyear1').val(year);
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

		var act1 = "../invReport/tank-form20-ab";
		var newformId1 = "#" + formId;

		$(newformId1).attr("action", act1);

		$(newformId1).submit();
		
	}
else {
		
		$('form[id=tankform20main]').parsley().validate();
	}
	
	
}


///start of new functions on 03082021

function gettankchkabdata(miTankFreqId, year, formId,flag) {
	//alert(" "+miTankFreqId+" "+year+" "+formId, " " +flag);
	
	if(flag==false){
		
		$('#miyear').removeAttr('required'); 
		$('#newmiTankFreqId').removeAttr('required'); 
	}
	
	if ($('form[id=tanksreportmain]').parsley().isValid()) {  

/*	if (year != null
			&& (miTankFreqId == 9 || miTankFreqId == 10 || miTankFreqId == 11)) {*/

		$('#chkyear1').val(year);
		$('#chkmiTankFreqId1').val(miTankFreqId);

		var unit = $("#userUnitId").val();
		var circle = $("#userCircleId").val();
		var division = $("#userDivisionId").val();
		var subdivision = $("#userSubdivisionId").val();
		var designation = $("#userDesignationId").val();
		var post = $("#userPostId").val();
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
			if (((unit != 4 && unit != 9832 && (unit!=9830)) && unit > 0) && circle == 0
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

		if (unit == 4 || unit == 9832 || (unit==9830)) {
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
							(( designation==4 || designation == 2 || designation==8)))
			) {
					//		alert("3 designation"+designation);
				circle = 0;
				division = 0;
				designation = 10;
				newdesignation = 9;
				officeaccess = 3;
				//alert("altered designation"+designation);
			}
		}
		$('#userdrilldowndesgId').val(designation);
		$('#userCircleId').val(circle);
		$('#userDivisionId').val(division);
		$('#userOfficeAccess').val(officeaccess);

		//alert("tanks check abdata officeaccess" +officeaccess+"unit"+unit+"circle"+circle+"division"+division+"subdivision"+subdivision+"designation"+designation);

		var act1 = "../invtsimis/left-menu-home";
		var newformId1 = "#" + formId;

		$(newformId1).attr("action", act1);

		$(newformId1).submit();

	/*} else {

		return false;
	}*/
	}
	else {
		
		$('form[id=tanksreportmain]').parsley().validate();
	}

}

function gettankSONewAbstract(miTankFreqId, year, designation, unit, circle,
		division, subdivision, post, officeaccess) {

	//alert("coming gettankSOAbstract");

	var chktempOfficeAccess = $('#chktempOfficeAccess').val();

	$("#tankabdata2").hide();
	$("#tankabstractdata").hide();

	$("#tanksoabdata").show();
	$("#soabthead3").empty();
	$("#soabtbody3").empty();

	//alert("gettankSOAbstract():  unit"+unit+"circle"+circle+"division"+division+"subdivision"+subdivision+"designation"+designation+"post"+post);

	$("#thead1").empty();
	$("#tbody1").empty();

	$("#thead2").empty();
	$("#tbody2").empty();

	var tabidnew = "soabthead3";

	var unit = unit;
	var circle = circle;
	var division = division;
	var subdivision = subdivision;
	var newdesignation = 0;
	var userdesignation = $("#userDesignationId").val();
	var listdesig = 0;

	var post = post;
	var officeaccessn = officeaccess;

	if (officeaccess == 1) {
		if (designation == 5) {
			newdesignation = 4;

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

		if (designation == 5) {
			newdesignation = 4;

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

		if (designation == 5) {
			newdesignation = 4;

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

	$('#chktempDesignationId').val(newdesignation);
	$('#chktempUnitId').val(unit);
	$('#chktempCircleId').val(circle);
	$('#chktempDivisionId').val(division);
	$('#chktempSubdivisionId').val(subdivision);
	$('#chkyear2').val(year);
	$('#chkmiTankFreqId2').val(miTankFreqId);

	$('#chktempPostId').val(post);

	$('#sonewbackdesgId').val(designation);
	$('#chktempOfficeAccess').val(officeaccess);

	var desg = $('#chktempDesignationId').val();

	//alert("desg"+desg);

	var act1 = "../invtsimis/left-menu-home";
	var newformId1 = "#tankschkreport1";

	/*  var act2="../invReport/Tank-checks?year="+year+"&tankId="+tankId;
	  var newformId2="#"+formId1;
	 */
	/* var act3="../invReport/Tank-checks?year="+year+"&tankId="+tankId;
	 var newformId3="#"+formId2;
	 
	 var act4="../invReport/Tank-checks?year="+year+"&tankId="+tankId;
	 var newformId4="#"+formId3;
	 
	 var act5="../invReport/Tank-checks?year="+year+"&abstracttype=2";
	 var newformId5="#"+formId;
	 */

	$(newformId1).attr("action", act1);
	// $(newformId2).attr("action", act2);
	/* $(newformId3).attr("action", act3);
	 $(newformId4).attr("action", act4);*/
	// $(newformId5).attr("action", act5);

	$(newformId1).submit();

}

function gettankNewCountInfo(miTankFreqId, year, tankStatusId, designation,
		unit, circle, division, subdivision, post) {

	//alert("gettankCountInfo designation "+designation);

	//	alert("gettankCntInf "+year+" "+tankStatusId +" "+ miTankFreqId);

	var unit = unit;
	var circle = circle;
	var division = division;
	var subdivision = subdivision;
	var designation = designation;
	var post = post;

	$('#chktempDesignationId').val(designation);
	$('#chktempUnitId').val(unit);
	$('#chktempCircleId').val(circle);
	$('#chktempDivisionId').val(division);
	$('#chktempSubdivisionId').val(subdivision);
	$('#chkyear2').val(year);
	$('#chkmiTankFreqId2').val(miTankFreqId);

	$('#chktempPostId').val(post);
	$('#chktemptankStatusId').val(tankStatusId);

	var desg = $('#chktempDesignationId').val();

	var act1 = "../invtsimis/left-menu-home";
	var newformId1 = "#tankschkreport1";

	$(newformId1).attr("action", act1);

	$(newformId1).submit();

}

//end of new functions on 03082021
var popup;



function gettankinfoNewData(tankname,tankId, miid, year) {
	
	
	

	var features = "width=500,height=300,menubar=no,status=no,location=no,toolbar=no,scrollbars=yes,top=100,left=50";
	var url = "../invReport/tank-chk-data?tankId=" + tankId
			+ "&miInpsectMst1Id=" + miid + "&year=" + year;

	popup = window.open(url, "_blank", features);
	popup.moveTo(0, 0);
	  popup.resizeTo(screen.width, screen.height);

}





function gettankCapSONewabstract(freqId, year, designation, unit, circle,
		division, subdivision, post, officeaccess) {

//	alert("gettankCapSONewabstract "+year+"designation"+designation+"unit"+unit+"circle"+circle+"division"+ division+ "subdivision"+subdivision+"post"+post);

	var unit = unit;
	var circle = circle;
	var division = division;
	var subdivision = subdivision;
	var userdesignation = $("#userDesignationId").val();
//	alert("userdesignation"+userdesignation);
	var designation = designation;

	var post = post;
	var officeaccessn = officeaccess;

	if (officeaccess == 1 && officeaccess != 2) {
		if (designation == 5) {
			newdesignation = 4;

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

		}

		if (designation == 5) {
			newdesignation = 4;

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

		}

		if (designation == 5) {
			newdesignation = 4;

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

	$('#captempDesignationId').val(newdesignation);
	$('#captempUnitId').val(unit);
	$('#captempCircleId').val(circle);
	$('#captempDivisionId').val(division);
	$('#captempSubdivisionId').val(subdivision);
	$('#capyear').val(year);
	$('#capmiTankFreqId').val(freqId);

	$('#captempPostId').val(post);

	$('#socapnewbackdesgId').val(designation);
	$('#captempOfficeAccess').val(officeaccess);

	var desg = $('#captempDesignationId').val();

	var act1 = "../invtsimis/left-menu-home";
	var newformId1 = "#tankschkreport2";

	$(newformId1).attr("action", act1);

	$(newformId1).submit();

}

function gettankForm20abstract( year, designation, unit, circle,
		division, subdivision, post, officeaccess) {

	//alert("gettankForm20abstract "+year+"designation"+designation+"unit"+unit+"circle"+circle+"division"+ division+ "subdivision"+subdivision+"post"+post+"OA"+officeaccess);

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
	

	$('#frmtempPostId').val(post);

	$('#frmbackdesgId').val(designation);
	$('#frmtempOfficeAccess').val(officeaccess);

	var desg = $('#frmtempDesignationId').val();
//	alert("listdesig"+listdesig);
	
	$('#frmtemplistDesignationId').val(listdesig);
	

	var act1 = "../invReport/tank-form20-ab";
	var newformId1 = "#tankform20report";

	$(newformId1).attr("action", act1);

	$(newformId1).submit();

}

function getcapNewdetailsbyoffice(freqId, year, designation, unit, circle,
		division, subdivision, post) {

	var unit = unit
	var circle = circle
	var division = division
	var subdivision = subdivision
	var userdesignation = $("#userDesignationId").val();
	var designation = designation;
	var post = post;

	//	alert("getcapNewdetailsbyoffice unit"+unit+"circle"+circle+"division"+division+"subdivision"+subdivision+"designation"+designation+"post"+post);

	$('#captempDesignationId').val(designation);
	$('#captempUnitId').val(unit);
	$('#captempCircleId').val(circle);
	$('#captempDivisionId').val(division);
	$('#captempSubdivisionId').val(subdivision);
	$('#capyear').val(year);

	$('#captemptankStatusId').val(0);

	$('#capmiTankFreqId').val(freqId);

	$('#captempPostId').val(post);

	var desg = $('#captempDesignationId').val();
	//alert("desg"+desg);

	var act1 = "../invtsimis/left-menu-home";
	var newformId1 = "#tankschkreport2";

	$(newformId1).attr("action", act1);
	// $(newformId2).attr("action", act2);
	/* $(newformId3).attr("action", act3);
	 $(newformId4).attr("action", act4);*/
	// $(newformId5).attr("action", act5);

	$(newformId1).submit();

}

function getForm20tanks( year, designation, unit, circle,	division, subdivision, post) {

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
	$('#frmyear').val(year);

	

	$('#frmtempPostId').val(post);
	;

	var desg = $('#frmtempDesignationId').val();
//	alert("fdr desg"+desg);

	var act1 = "../invReport/tank-form20-ab-detail";
	var newformId1 = "#tankform20report";

	$(newformId1).attr("action", act1);
	// $(newformId2).attr("action", act2);
	/* $(newformId3).attr("action", act3);
	 $(newformId4).attr("action", act4);*/
	// $(newformId5).attr("action", act5);

	$(newformId1).submit();

}
function getForm20DetailReport(formDataId, formId) {
	
	
	$("#form20DataId").val(formDataId);
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

function getForm20ImagesReport(formDataId, formId) {
	
	
	$("#form20DataId").val(formDataId);
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

function gettableexport(iddata) {

	//alert("cominghere gettableexport");
	//var idnew="#"+iddata ;

	//  $(idnew).empty();

	$(iddata).DataTable({

		dom : 'Bfrtip',
		responsive : true,
		retrieve : true,
		"paging" : false,
		"ordering" : false,
		"autoWidth" : true,
		"lengthChange" : false,
		"pageLength" : 20,
		"columnDefs" : [ {
			"visible" : false

		} ],

		buttons : [ {
			extend : 'copyHtml5',
			text : 'Copy Data',
			exportOptions : {
				columns : [ 0, ':visible' ]
			}
		}, {
			extend : 'excelHtml5',
			autoFilter : true,
			sheetName : 'Exported_Tanks_Info',
			text : 'Download Data To Excel',
			className : 'btn-primary ',
			messageTop : 'Tanks Info',
			exportOptions : {
				columns : ':visible'
			}

		},

		{
			extend : 'pdfHtml5',
			className : 'btn-primary ',
			text : 'PDF View / Download',
			orientation : 'landscape',
			pageSize : 'A4',
			download : 'open',
			font : '10',
			filename : 'Ayacut Report',
			exportOptions : {
				columns : ':visible'

			},

			title : 'Tanks Info',
			customize : function(doc) {
				doc.defaultStyle.fontfamily = 'Arial';

				doc.defaultStyle.fontSize = 10;
				doc.defaultStyle.alignment = 'center';
				doc.styles.tableHeader.fontSize = 12;
				doc.pageMargins = [ 80, 80, 80, 80 ];

				doc['footer'] = (function(page, pages) {
					return {
						columns : [

						{
							alignment : 'right',
							text : [ {
								text : page.toString(),
								italics : true
							}, ' of ', {
								text : pages.toString(),
								italics : true
							} ]
						} ],
						margin : [ 5, 0 ]
					}
				});

			}

		}, {
			extend : 'print',
			text : 'Print All',
			className : 'btn-primary ',
			exportOptions : {
				modifier : {
					selected : null
				},
				columns : ':visible'
			}

		}, , {
			extend : 'print',
			text : 'Print Selected',
			className : 'btn-primary ',
			exportOptions : {
				columns : ':visible'
			}

		}, {
			extend : 'colvis',
			text : 'Exclude for Print/Export',

			columnText : function(dt, idx, title) {
				return title;
			}

		} ],
		select : true

	});

}

function gettableexport2(iddata) {

	$(iddata).DataTable({

		destroy : true,

		dom : 'Bfrtip',
		responsive : true,
		"paging" : false,
		"ordering" : false,
		"autoWidth" : true,
		"lengthChange" : false,
		"pageLength" : 20,
		"columnDefs" : [ {
			"visible" : false

		} ],

		buttons : [ {
			extend : 'copyHtml5',
			text : 'Copy Data',
			exportOptions : {
				columns : [ 0, ':visible' ]
			}
		}, {
			extend : 'excelHtml5',
			autoFilter : true,
			sheetName : 'Exported_Tanks_Info',
			text : 'Download Data To Excel',
			className : 'btn-primary ',
			messageTop : 'Tanks Info',
			exportOptions : {
				columns : ':visible'
			}

		},

		{
			extend : 'pdfHtml5',
			className : 'btn-primary ',
			text : 'PDF View / Download',
			orientation : 'landscape',
			pageSize : 'A4',
			download : 'open',
			font : '10',
			filename : 'Ayacut Report',
			exportOptions : {
				columns : ':visible'

			},

			title : 'Tanks Info',
			customize : function(doc) {
				doc.defaultStyle.fontfamily = 'Arial';

				doc.defaultStyle.fontSize = 10;
				doc.defaultStyle.alignment = 'center';
				doc.styles.tableHeader.fontSize = 12;
				doc.pageMargins = [ 80, 80, 80, 80 ];

				doc['footer'] = (function(page, pages) {
					return {
						columns : [

						{
							alignment : 'right',
							text : [ {
								text : page.toString(),
								italics : true
							}, ' of ', {
								text : pages.toString(),
								italics : true
							} ]
						} ],
						margin : [ 5, 0 ]
					}
				});

			}

		}, {
			extend : 'print',
			text : 'Print All',
			className : 'btn-primary ',
			exportOptions : {
				modifier : {
					selected : null
				},
				columns : ':visible'
			}

		}, , {
			extend : 'print',
			text : 'Print Selected',
			className : 'btn-primary ',
			exportOptions : {
				columns : ':visible'
			}

		}, {
			extend : 'colvis',
			text : 'Exclude for Print/Export',

			columnText : function(dt, idx, title) {
				return title;
			}

		} ],
		select : true

	});

}

function gettablemultipleheader(iddata) {

	//	alert("cominghere mutiple header");

	var idnew = popup.document.getElementById(iddata);

	$(idnew).DataTable({

		retrieve : true,
		dom : 'Bfrtip',
		responsive : true,
		"paging" : false,
		"ordering" : false,
		"autoWidth" : true,
		"lengthChange" : false,
		"pageLength" : 20,
		"columnDefs" : [ {
			"visible" : false

		} ],
		buttons : [ {
			extend : 'copyHtml5',
			text : 'Copy Data',
			exportOptions : {
				columns : [ 0, ':visible' ]
			}
		}, {
			extend : 'excelHtml5',
			autoFilter : true,
			sheetName : 'Exported_Tanks_Info',
			text : 'Download Data To Excel',
			className : 'btn-primary ',
			messageTop : 'Tanks Info',
			exportOptions : {
				columns : ':visible'
			},
			customize : function(xlsx) {
				var sheet = xlsx.xl.worksheets['sheet1.xml'];

				// jQuery selector to add a border
				$('row c[r*="10"]', sheet).attr('s', '25');

			}

		},

		{
			extend : 'pdfHtml5',
			className : 'btn-primary ',
			text : 'PDF View / Download',
			orientation : 'landscape',
			pageSize : 'A4',
			download : 'open',
			font : '10',
			filename : 'Ayacut Report',
			exportOptions : {
				columns : ':visible'

			},

			title : 'Tanks Info',
			customize : function(doc) {
				doc.defaultStyle.fontfamily = 'Arial';

				doc.defaultStyle.fontSize = 10;
				doc.defaultStyle.alignment = 'center';
				doc.styles.tableHeader.fontSize = 12;
				doc.pageMargins = [ 80, 80, 80, 80 ];

				//alert(doc.content[1].table.headerRows);
				doc.content[1].table.headerRows = 4;

				//alert(doc.content[1].table.headerRows);

				var firstHeaderRow = [];
				var secondHeaderRow = [];
				var thirdHeaderRow = [];
				var fourthHeaderRow = [];
				$(idnew).find("thead>tr:first-child>th").each(

				function(index, element) {
					// alert(index);
					// alert("kal"+ $(this).text());
					var colSpan = element.getAttribute("colSpan");
					//   alert("colSpan"+colSpan);
					firstHeaderRow.push({
						text : element.innerHTML,
						style : "tableHeader",
						colSpan : colSpan
					});

				});

				$(idnew).find("thead>tr:nth-child(2)>th").each(

				function(index, element) {
					// alert(index);
					// alert("kalnew"+ $(this).text());
					var colSpan = element.getAttribute("colSpan");
					// alert("colSpan"+colSpan);
					secondHeaderRow.push({
						text : element.innerHTML,
						style : "tableHeader",
						colSpan : colSpan
					});

				});

				$(idnew).find("thead>tr:nth-child(3)>th").each(

				function(index, element) {
					// alert(index);
					// alert("kalnew"+ $(this).text());
					var colSpan = element.getAttribute("colSpan");
					// alert("colSpan"+colSpan);
					thirdHeaderRow.push({
						text : element.innerHTML,
						style : "tableHeader",
						colSpan : colSpan
					});

				});

				$(idnew).find("thead>tr:nth-child(4)>th").each(

				function(index, element) {
					// alert(index);
					// alert("kalnew"+ $(this).text());
					var colSpan = element.getAttribute("colSpan");
					// alert("colSpan"+colSpan);
					fourthHeaderRow.push({
						text : element.innerHTML,
						style : "tableHeader",
						colSpan : colSpan
					});

				});

				doc['footer'] = (function(page, pages) {
					return {
						columns : [

						{
							alignment : 'right',
							text : [ {
								text : page.toString(),
								italics : true
							}, ' of ', {
								text : pages.toString(),
								italics : true
							} ]
						} ],
						margin : [ 5, 0 ]
					}
				});

				var objLayout = {};
				objLayout['hLineWidth'] = function(i) {
					return .5;
				};
				objLayout['vLineWidth'] = function(i) {
					return .5;
				};
				objLayout['hLineColor'] = function(i) {
					return '#aaa';
				};
				objLayout['vLineColor'] = function(i) {
					return '#aaa';
				};
				objLayout['paddingLeft'] = function(i) {
					return 4;
				};
				objLayout['paddingRight'] = function(i) {
					return 4;
				};

				doc.content[1].table.body.unshift(fourthHeaderRow);
				doc.content[1].table.body.unshift(thirdHeaderRow);

				doc.content[1].table.body.unshift(secondHeaderRow);

				doc.content[1].table.body.unshift(firstHeaderRow);

				doc.content[1].layout = objLayout;

				doc.styles.tableHeader.fillColor = "#5882FA";
				doc.styles.tableFooter.fillColor = "#5882FA";

			}

		}, {
			extend : 'print',
			text : 'Print All',
			className : 'btn-primary ',
			exportOptions : {
				modifier : {
					selected : null
				},
				columns : ':visible'
			}

		}, , {
			extend : 'print',
			text : 'Print Selected',
			className : 'btn-primary ',
			exportOptions : {
				columns : ':visible'
			}

		}, {
			extend : 'colvis',
			text : 'Exclude for Print/Export',

			columnText : function(dt, idx, title) {
				return title;
			}

		} ],
		select : true

	});

}

function graphDisplay(totalCount, emergencyCount, observeCount, defferedCount,
		originalworkCount) {

	am4core.ready(function() {

		// Themes begin
		am4core.useTheme(am4themes_animated);
		// Themes end

		// Create chart instance
		var chart = am4core.create("chartdiv", am4charts.XYChart3D);
		chart.paddingBottom = 30;
		chart.angle = 35;

		// Add data
		chart.data = [ {
			"Tanks Status" : "Tanks Inspected",
			"Tanks NO" : totalCount
		}, {
			"Tanks Status" : "Tanks in Emergency ",
			"Tanks NO" : emergencyCount
		}, {
			"Tanks Status" : "Tanks in Obervation",
			"Tanks NO" : observeCount
		}, {
			"Tanks Status" : "Tanks in Maintenance",
			"Tanks NO" : defferedCount
		}, {
			"Tanks Status" : "Tanks in Original work",
			"Tanks NO" : originalworkCount
		} ];

		// Create axes
		var categoryAxis = chart.xAxes.push(new am4charts.CategoryAxis());
		categoryAxis.dataFields.category = "Tanks Status";
		categoryAxis.renderer.grid.template.location = 0;
		categoryAxis.renderer.minGridDistance = 20;
		categoryAxis.renderer.inside = true;
		categoryAxis.renderer.grid.template.disabled = true;
		categoryAxis.tooltip.label.rotation = 270;
		categoryAxis.tooltip.label.horizontalCenter = "right";
		categoryAxis.tooltip.label.verticalCenter = "middle";

		let
		labelTemplate = categoryAxis.renderer.labels.template;
		labelTemplate.rotation = -90;
		labelTemplate.horizontalCenter = "left";
		labelTemplate.verticalCenter = "left";
		labelTemplate.dy = 10; // moves it a bit down;
		labelTemplate.inside = false; // this is done to avoid settings which are not suitable when label is rotated

		var valueAxis = chart.yAxes.push(new am4charts.ValueAxis());
		valueAxis.renderer.grid.template.disabled = true;

		// Create series
		var series = chart.series.push(new am4charts.ConeSeries());
		series.dataFields.valueY = "Tanks NO";
		series.dataFields.categoryX = "Tanks Status";
		series.name = "Tanks NO";
		series.tooltipText = "{categoryX}: [bold]{valueY}[/]";

		var bullet = series.bullets.push(new am4charts.LabelBullet())
		bullet.interactionsEnabled = false
		bullet.dy = -3;
		bullet.label.text = '{valueY}'
		bullet.label.fill = am4core.color('#ffffff')

		var columnTemplate = series.columns.template;
		columnTemplate.adapter.add("fill", function(fill, target) {
			if (target.dataItem.index == 0) {

				return am4core.color("#008000");

			} else if (target.dataItem.index == 1) {

				return am4core.color("#ff0000");
			} else if (target.dataItem.index == 2) {

				return am4core.color("#6495ED");
			} else if (target.dataItem.index == 3) {

				return am4core.color("#008080");
			} else if (target.dataItem.index == 4) {

				return am4core.color("#FF00FF");
			} else {
				return chart.colors.getIndex(target.dataItem.index);
			}
		})

		columnTemplate.adapter.add("stroke", function(stroke, target) {
			return chart.colors.getIndex(target.dataItem.index);
		})
		
		chart.cursor = new am4charts.XYCursor();
		chart.cursor.lineX.strokeOpacity = 0;
		chart.cursor.lineY.strokeOpacity = 0;
		
		chart.exporting.menu = new am4core.ExportMenu();
		chart.exporting.menu.align = "right";
		chart.exporting.menu.verticalAlign = "top";
		
		//
		
		var title = chart.titles.create();
		title.text = "Tanks Status";
		title.disabled = true;
		chart.exporting.events.on("exportstarted", function(ev) {
			  title.disabled = false;
			  title.parent.invalidate();
			});

			// Disable title when export finishes
		/*	chart.exporting.events.on("exportfinished", function(ev) {
			  title.disabled = true;
			});
*/
			// Add title to validated sprites
			chart.exporting.validateSprites.push(title);
			chart.exporting.validateSprites.push(title.parent);
		/*chart.exporting=[{
			"exporting": {
			    "menu": {
			      // No need to specify `type`, since
			      // there's only one type of `ExportMenu`
			    }
			  }
		}]*/
		chart.exporting.menu.items = [{
			
			"label": "Exp",
			"titles": [{
			    "text": "Speed",
			    "fontSize": 25,
			    "marginBottom": 30
			  }],
			 // "icon": "../images/download_image.png",
		    "menu": [
		      {
		    	
		        "label": "Image",
		        "menu": [
		          { "type": "png", "label": "PNG" },
		          { "type": "jpg", "label": "JPG" },
		         
		          { "type": "pdf", "label": "PDF" }
		        ]
		      }, {
		        "label": "Data",
		        "menu": [
		         
		         
		          { "type": "xlsx", "label": "XLSX" },
		         
		          { "type": "pdfdata", "label": "PDF" }
		        ]
		      }, {
		        "label": "Print", "type": "print"
		      }
		    ]
			
			}];
		
		
		
		var options = chart.exporting.getFormatOptions("pdf");
		options.addURL = false;
		options.pivot = true;
		chart.exporting.setFormatOptions("pdf", options);
		
		var options2 = chart.exporting.getFormatOptions("pdfdata");
		options2.addURL = false;
		options2.pivot=true;
		chart.exporting.setFormatOptions("pdfdata", options2);
		
		var options3 = chart.exporting.getFormatOptions("xlsx");		
		options3.pivot=true;
		chart.exporting.setFormatOptions("xlsx", options3);
		
		chart.exporting.adapter.add("pdfmakeDocument", function(pdf, target) {

			  // Add title to the beginning
			
			  pdf.doc.content.unshift({

					alignment: 'justify',
				  
			    text: "Tanks Inspection Abstract",
			    margin: [90, 30],
			    style: {
			      fontSize: 25,
			      bold: true,
			    }
			  
			 
			  });

			  return pdf;
			});
		
		chart.exporting.filePrefix = "Tanks_Inspection_Abstract";
	
		
		
		
		
		

	}); // end am4core.ready()
	
	//chart.exporting.menu.items[0].icon = "../images/download_image.png";
	
	
	

}


function viewfrmphtfn(formdataId){
	
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
		    	    		
		    	    		
		    	    		
		    	    		'</tr>'); 	 
				 
				
						var obj = JSON.parse(response);
						$.each(obj, function(key, value) {
							
							
							  $('#docfrm20 table tbody').append(  '<tr style="font-size: 16px ; color:blue">' +
		                                '<td style="text-align: center;">'+j+'</td>' +
		                                
		                                '<td><b>'+value.formDocOriginalName+'</b></td>' +
		                               
		                                '<td style="color:blue"><b><a target="_blank" href="../uploadedFiles/FormDocs/'+value.formDocName+'" ><u>Download File<u></a></b></td>' +
		                                                    
		                               
		                                '</tr>');
						
							   j++;
							  
							 
						});

		      },
		      error : function(){
		    	  alert(error);
		      }
		  });	
		
	
}
