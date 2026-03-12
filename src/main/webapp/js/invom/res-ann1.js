$(document).ready(function() {
	
	
	$('#year').multiselect({
		 
		 enableCaseInsensitiveFiltering: true
		 
	});
	
	/*$('#yearsd').multiselect({
		 
		 enableCaseInsensitiveFiltering: true
		 
	});*/
		 var d = new Date();
		  var e=new Date();
		
		  e= e.getFullYear() - 2;
		  var j=00;
	    for (var i = 1; i >= 0; i--) {
	  	  
	    	
	    	//alert(i);
	        var option = "<option value=" + parseInt(d.getFullYear()-i) + ">" + parseInt(d.getFullYear()-i) + "</option>"
	      //  alert(option);
	        
	        $('[id*=year]').append(option);
	      //  $('[id*=yearsd]').append(option);
	        e++;
	       // j++;
	      
	        $('#year').multiselect('rebuild');
	       // $('#yearsd').multiselect('rebuild');
	    }
	    
	      
	   
	   var yeardata= $('#year').val();
	   
	
	   
	   $(".resmainobsinf").hide();
	   $(".resannvieweditdata").hide();
	   
	   $("#previnfodata").hide();
	   
	  $("#prevrecommenddata").hide();
	   

	 
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
		$("#verticalearth").tabs().addClass("ui-tabs-vertical ui-helper-clearfix");
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
		$("#verticall li").removeClass("ui-corner-top").addClass("ui-corner-left");
		
		
		
	  
	  

		
		
		$('#dutyFrequencyId').multiselect({

			enableCaseInsensitiveFiltering : true

		});
		
		/*$('#dutyFrequencyIdsd').multiselect({

			enableCaseInsensitiveFiltering : true

		});*/
	/*	$('#unitIdsd').multiselect({

			enableCaseInsensitiveFiltering : true

		});
		*/
		
		$('#resStatusId').multiselect({

			enableCaseInsensitiveFiltering : true

		});
		
		
	/*	$('#conditionofDamIdsd').multiselect({

			enableCaseInsensitiveFiltering : true

		});*/
		
		/*$('#categorysd').multiselect({

			enableCaseInsensitiveFiltering : true

		});*/
		
		
		
	$('#nextPostId').multiselect({

			enableCaseInsensitiveFiltering : true,
			  
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
		
		$("#resprepost").hide();
		
		
		
		
		
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
		 
		 
		 
		 $('#getrecommendation_dialogue').dialog({
			  autoOpen:false,
			  width:1200,
			  close: function() {
				  
				
					  $(this).dialog("close");
					  }
			 });
		 
		/* $('#getanicut_dialogue').dialog({
			  autoOpen:false,
			  width:1200,
			  close: function() {
				  
				
					  $(this).dialog("close");
					  }
			 });*/
		 
		/* $('#getcheckdam_dialogue').dialog({
			  autoOpen:false,
			  width:1200,
			  close: function() {
				  
				
					  $(this).dialog("close");
					  }
			 });*/
		 
		 $('#showtanksdata').click(function(){
				
			 $('#gettanks_dialogue').dialog('option', 'title', 'View Tanks Info');
			  $('#gettanks_dialogue').dialog('open');
			 
		      
			 });
		 
		/* $('#anicutdata').click(function(){
				
			 $('#getanicut_dialogue').dialog('option', 'title', 'View Anicut Info');
			  $('#getanicut_dialogue').dialog('open');
			 
		      
			 });*/
		 
		/* $('#showcheckdamdata').click(function(){
				
			 $('#getcheckdam_dialogue').dialog('option', 'title', 'View CheckDam Info');
			  $('#getcheckdam_dialogue').dialog('open');
			 
		      
			 });*/
		
		
		$('#addresloc_dialogue').dialog({
			  autoOpen:false,
			  width:800,
			  close: function() {
				  
				
					  $(this).dialog("close");
					  }
			 });
		
		$('#res_salient_info').dialog({
			  autoOpen:false,
			  width:1200,
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
		
		
		
		/*$('#addinspect_dialogue').dialog({
			  autoOpen:false,
			  width:800,
			  close: function() {
				  
				
					  $(this).dialog("close");
					  }
			 });*/
		
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
		
		
		$('#hazardinfo_dialogue').dialog({
			  autoOpen:false,
			  width:800,
			  close: function() {
				  
				
					  $(this).dialog("close");
					  }
			 });
		
		
		$('#conditioninfo_dialogue').dialog({
			  autoOpen:false,
			  width:800,
			  close: function() {
				  
				
					  $(this).dialog("close");
					  }
			 });
		
		
		$('#refcondres').click(function(){
			
			 $('#conditioninfo_dialogue').dialog('option', 'title', 'View Condition of Dam');
			  $('#conditioninfo_dialogue').dialog('open');
			  
			  $('#conditioninfo').trigger("reset"); 
			  
			 
			 
		      
			 });
		
		$('#refdemores').click(function(){
			
			 $('#hazardinfo_dialogue').dialog('option', 'title', 'View hazard classification');
			  $('#hazardinfo_dialogue').dialog('open');
			  
			  $('#hazardinfo').trigger("reset"); 
			  
			 
			 
		      
			 });
		
		
		
		
		$('#shaddresbaiscinf').click(function(){
			
			 $('#res_basic_info').dialog('option', 'title', 'View Reservoir info');
			  $('#res_basic_info').dialog('open');
			  
			  $('#adddambasicinf').trigger("reset"); 
			  
			  $('#adddamcontrolinf').trigger("reset"); 
			  $('#latlong').show();
		      
			 });
		
		$('#shaddtankinf').click(function(){
			
			 $('#res_basic_info').dialog('option', 'title', 'View Tank info');
			  $('#res_basic_info').dialog('open');
			  
 $('#adddambasicinf').trigger("reset"); 
			  
			  $('#adddamcontrolinf').trigger("reset"); 
			 
			  $('#latlong').hide();
			  
			 });
		
		
		
		
		
		
		
		 var cyear = (new Date).getFullYear();

		$(".datepick").datepicker({
			changeYear : false,
			changeMonth : true,
			 minDate: new Date(cyear, 0, 1),
		        maxDate: new Date(cyear, 11, 31),
		     
			
			 dateFormat: "dd/mm/yy"+" "+ getCurrentTime(),
			   
			
		/* 
		 dateFormat : "dd/mm/yy", onSelect: function(selected) {
		   $("#month").datepicker("option","minDate", selected)
		 } */
		});
		
		$(".datepickinspect").datepicker({
			changeYear : true,
			changeMonth : true,
			 minDate: new Date(cyear-1, 7, 1),
		        maxDate: new Date(cyear, 11, 31),
		     
			
			 dateFormat: "dd/mm/yy"+" "+ getCurrentTime(),
			   
			
		/* 
		 dateFormat : "dd/mm/yy", onSelect: function(selected) {
		   $("#month").datepicker("option","minDate", selected)
		 } */
		});
		
		
		$(".datepicknew").datepicker({
			changeYear : true,
			changeMonth : true,
			
		     
			
			 dateFormat: "dd/mm/yy"+" "+ getCurrentTime(),
			   
			
		/* 
		 dateFormat : "dd/mm/yy", onSelect: function(selected) {
		   $("#month").datepicker("option","minDate", selected)
		 } */
		});

		$("#addresjuris").click(function() {
			var link = $(this).attr('href');

			//alert(link);

			$('#whereFormWillLive').load(link);

			// $(".content").load(link);
		});

		$("#resprepost").tabs()
		
	/*	$("#recbasicupdate").tabs()*/
		
		
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
		  
		  if(id==9){
			  $('#typeofinspection1').val("Pre monsoon");
			  }
			  
			  if(id==10){
				  $('#typeofinspection1').val("Post monsoon");
				  }
			  
			  
			 
		
		
		});
		
		  $("#conditionofDamId").change(function() {
			  var id = $(this).val();

			  $('.mainconditionofDamId').val(id);
			
			
			});
	
		
		
		

		$("#frequencyId").change(function() {
			var freq = $(this).val();

			//alert(freq);

		});
		
		$("#year").change(function() {
			var yeardata = $(this).val();
			
			 $('.mainyear').val(yeardata);

			//alert(freq);

		});
		
		
		$(".damresp").change(function() {
			
			
			var respdata = $(this).val();
			var formid = $(this).closest("form").attr('id');
			var respid=$(this).prop('id')
			var resnum=0;
			
		
			var reslen=parseInt(respid.length);
			
		if(respdata==1 || respdata==2){
			resnum=respid.substring(19,reslen);
		}else if (respdata==3){
			
			resnum=respid.substring(20,reslen);
		}
		
	//alert("resnum"+resnum);
		
		var remks="#remarks"+resnum;
		var irrchfrm="#irrChFrm"+resnum;
		var irrChTo="#irrChTo"+resnum
		var conditionofCheckId="#conditionofCheckId"+resnum;
		
		var divobs="#obsres"+resnum;
		var chfrmres="#chfrmres"+resnum;
		var chtores="#chtores"+resnum;
		var condres="#condres"+resnum;
		
		
		if(respdata==1||respdata==2){
		$(divobs).show();
		$(chfrmres).show();
		$(chtores).show();
		$(condres).show();
		$(conditionofCheckId).prop('required',true);
		}else if(respdata==3){			
			
			$(remks).val(' ');
			$(irrchfrm).val(0.01);
			$(irrChTo).val(0.01);
			$(conditionofCheckId).val(0);
			
			
			$(divobs).hide();
			$(chfrmres).hide();
			$(chtores).hide();
			$(condres).hide();
			$(conditionofCheckId).removeAttr('required');
			
		}
			
			

		});
		
		
		
		
		 $('#getprojects_dialogue').dialog({
			  autoOpen:false,
			  width:800,
			  close: function() {
				  
				
					  $(this).dialog("close");
					  }
			 });
		 
		 
		 
		 $('#showprojectsdisplaydata').click(function(){
				
			 $('#getprojects_dialogue').dialog('option', 'title', 'Projects');
			  $('#getprojects_dialogue').dialog('open');
			 
		      
			 });
		 
		 
		 
		 $('#shaddinspectinf').click(function(){
				
			 $('#addinspect_dialogue').dialog('option', 'title', 'Add Inspection Details');
			  $('#addinspect_dialogue').dialog('open');
			 
		      
			 });
		 
		 $('#inspectDate').click(function(){
		 
		 var inspectDatenew =  $("#inspectDate").val();
		  
		  if(inspectDatenew!=null && inspectDatenew!=0){
			  
			//  alert("kal here time");
			  
			  $("#inspectDate1").val(inspectDatenew);
				
			  $('#inspectDate2').val(inspectDatenew);
			  $('#inspectDate3').val(inspectDatenew);
			//  $('#empId4').val(id);
			  $('#inspectDate4').val(inspectDatenew);
			  
			  
		  }
		 });
		 
		 
		
			


			$('#shaddresinflocn').click(function(){
				
				  //alert("kal");
				
				 $('#addresloc_dialogue').dialog('option', 'title', 'Add Reservoir location');
				  $('#addresloc_dialogue').dialog('open');
				  
				  
				  
				  $('#addresloc').trigger("reset"); 
				  
				//  alert("kal2");
				  
				  var resName= $('#reservoirName').val();
				  
				 // alert("kal2"+resName);
				  
				  var resIddia=  $('#resId').val();
				  
				 // alert("kal23"+resIddia);
				  
				  var projectId=  $('#resmainprojectId').val();
				  
				//  alert("kal234"+projectId);
				  
				  $('#resdianew').val(resName); 
				  
				  $('#reservoirId').val(resIddia); 
				  
				  $('#resProjectId').val(projectId); 
				  
				  
				  
				  document.getElementById('resnrldcaptcha_id').src = '../captcha2.jpg?' + Math.random();  
				 
			     
				 });


	
	
	$('#shaddressalienticon').click(function(){
		
		  //alert("kal");
		
		 $('#res_salient_info').dialog('option', 'title', 'Add Reservoir Salient features');
		  $('#res_salient_info').dialog('open');
		  
		  
		  
		  $('#addsalientinf9').trigger("reset"); 
		  $('#addsalientinf8').trigger("reset"); 
		  $('#addsalientinf7').trigger("reset"); 
		  $('#addsalientinf5').trigger("reset"); 
		  $('#addsalientinf4').trigger("reset"); 
		  $('#addsalientinf3').trigger("reset"); 
		  $('#addsalientinf2').trigger("reset"); 
		  $('#addsalientinf1').trigger("reset"); 
		  
		//  alert("kal2");
		  
		  var resName= $('#reservoirName').val();
		  
		 // alert("kal2"+resName);
		  
		  var resIddia=  $('#resId').val();
		  
		 // alert("kal23"+resIddia);
		  
		  var projectId=  $('#resmainprojectId').val();
		  
		//  alert("kal234"+projectId);
		  
		//  $('#resdianew').val(resName); 
		  
		//  $('#reservoirId').val(resIddia); 
		  
		//  $('#resProjectId').val(projectId); 
		  
		  
		//  
		 // document.getElementById('resnrldcaptcha_id').src = '../captcha2.jpg?' + Math.random();  
		 
	     
		 });
	
	
	$('#shaddtanksalienticon').click(function(){
		
		  //alert("kal");
		
		 $('#res_salient_info').dialog('option', 'title', 'Add Tank Salient features');
		  $('#res_salient_info').dialog('open');
		  
		  
		  
		  $('#addsalientinf9').trigger("reset"); 
		  $('#addsalientinf8').trigger("reset"); 
		  $('#addsalientinf7').trigger("reset"); 
		  $('#addsalientinf5').trigger("reset"); 
		  $('#addsalientinf4').trigger("reset"); 
		  $('#addsalientinf3').trigger("reset"); 
		  $('#addsalientinf2').trigger("reset"); 
		  $('#addsalientinf1').trigger("reset"); 
		  
		//  alert("kal2");
		  
		  var resName= $('#reservoirName').val();
		  
		 // alert("kal2"+resName);
		  
		  var resIddia=  $('#resId').val();
		  
		 // alert("kal23"+resIddia);
		  
		  var projectId=  $('#resmainprojectId').val();
		  
		//  alert("kal234"+projectId);
		  
		//  $('#resdianew').val(resName); 
		  
		//  $('#reservoirId').val(resIddia); 
		  
		//  $('#resProjectId').val(projectId); 
		  
		  
		//  
		 // document.getElementById('resnrldcaptcha_id').src = '../captcha2.jpg?' + Math.random();  
		 
	     
		 });

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

	       /* if (CurrentHours == 12) {
	            CurrentHours = 12;
	            CurrentAmPm = " P'M'";
	        }
	        else if (CurrentHours == 0) {
	            CurrentHours = 12;
	            CurrentAmPm = " A'M'";
	        }
	        else if (CurrentHours > 12) {
	            CurrentHours = CurrentHours - 12;
	            CurrentAmPm = " P'M'";
	        }
	        else {
	            CurrentAmPm = " A'M'";
	        }*/
	        CurrentTime = "" + CurrentHours + ":" + CurrentMinutes +":" + CurrentSeconds +  "";
	    }
	    catch (ex) {
	    }
	    return CurrentTime;
	}
	
	
	
	
$(function() {
		
		
		

		$('.rescheckbutton').hide();

		$('.rescustomcheck1')
				.click(
						function() {
							
							//if ($('form[name=mainformname]').parsley().isValid()) { 
					 		
					 		//if($('input[name="unitId"]').parsley().validate()){
					 			
							var checkid = $(this).prop('id');

							if ($('input:checkbox[id=' + checkid + ']').is(
									':checked') == true) {
								$(this).val(1);

							}
							//class=mycustomcheck
							if ($('input:checkbox[id=' + checkid + ']').is(
									':checked') == false) {
								$(this).val(0);

							}
							//   alert( "uncome"); 

							var numberNotChecked = $('input:checkbox[class=rescustomcheck1]:not(":checked")').length;
							var numberOfChecked = $('input:checkbox[class=rescustomcheck1]:checked').length;

							//   alert( "un"+numberNotChecked);
							//   alert("mat"+numberOfChecked);

							//  alert( "diff"+(numberOfChecked-numberNotChecked) );

							if ((numberOfChecked) >= 1) {
								$('.rescheckbutton').show();
							} else {

								$('.rescheckbutton').hide();
							}
					 		//}

						});
		$('.rescustomcheck2')
				.click(
						function() {

							var checkid = $(this).prop('id');

							if ($('input:checkbox[id=' + checkid + ']').is(
									':checked') == true) {
								$(this).val(1);

							}
							//class=mycustomcheck
							if ($('input:checkbox[id=' + checkid + ']').is(
									':checked') == false) {
								$(this).val(0);

							}
							//   alert( "uncome"); 

							var numberNotChecked = $('input:checkbox[class=rescustomcheck2]:not(":checked")').length;
							var numberOfChecked = $('input:checkbox[class=rescustomcheck2]:checked').length;

							//   alert( "un"+numberNotChecked);
							//   alert("mat"+numberOfChecked);

							//   alert( "diff"+(numberOfChecked-numberNotChecked) );

							if ((numberOfChecked) >= 1) {
								$('.rescheckbutton').show();
							} else {

								$('.rescheckbutton').hide();
							}

						});

		$('.rescustomcheck3')
				.click(
						function() {

							var checkid = $(this).prop('id');

							if ($('input:checkbox[id=' + checkid + ']').is(
									':checked') == true) {
								$(this).val(1);

							}
							//class=mycustomcheck
							if ($('input:checkbox[id=' + checkid + ']').is(
									':checked') == false) {
								$(this).val(0);

							}
							//   alert( "uncome"); 

							var numberNotChecked = $('input:checkbox[class=rescustomcheck3]:not(":checked")').length;
							var numberOfChecked = $('input:checkbox[class=rescustomcheck3]:checked').length;

							//   alert( "un"+numberNotChecked);
							//   alert("mat"+numberOfChecked);

							//   alert( "diff"+(numberOfChecked-numberNotChecked) );

							if ((numberOfChecked) >= 1) {
								$('.rescheckbutton').show();
							} else {

								$('.rescheckbutton').hide();
							}

						});

		$('.rescustomcheck4')
				.click(
						function() {

							var checkid = $(this).prop('id');

							if ($('input:checkbox[id=' + checkid + ']').is(
									':checked') == true) {
								$(this).val(1);

							}
							//class=mycustomcheck
							if ($('input:checkbox[id=' + checkid + ']').is(
									':checked') == false) {
								$(this).val(0);

							}
							//   alert( "uncome"); 

							var numberNotChecked = $('input:checkbox[class=rescustomcheck4]:not(":checked")').length;
							var numberOfChecked = $('input:checkbox[class=rescustomcheck4]:checked').length;

							//  alert( "un"+numberNotChecked);
							//  alert("mat"+numberOfChecked);

							//   alert( "diff"+(numberOfChecked-numberNotChecked) );

							if ((numberOfChecked) >= 1) {
								$('.rescheckbutton').show();
							} else {

								$('.rescheckbutton').hide();
							}

						});

		
		
			
		
		
		
		

		

		/*$('.rescheckbutton')
				.click(
						function(e) {

							var formname = this.form.name;
							//	var getformname=$(formname).prop('form');
							
							 var formid=this.form.id;
							 
							 var customformid="#"+formid;
							var buttonid = $(this).prop('id');
							
							   var newyear=$("#year").val();
							  // alert("newyear"+newyear);

							//alert("buttonid" + buttonid);

							//alert("formname" + formname);

							//alert("kal1");

							// alert("kal1");
							// var n= $('#addayacutinfo').text() ;

							// alert("text"+n);

							$('#action_alert').empty();

							e.preventDefault(); //=== To Avoid Page Refresh and Fire the Event "Click"===

							//alert("kal1");

							
								
								
								
							if ($('form[name=mainformname]').parsley().isValid()) {  	
									
									//alert("kal2");
							if ($('form[name=' + formname + ']').parsley().isValid()) {

								//alert("kal3");

							

								$
										.ajax({
											url : "../invtsimis/addReschecksAnn1",
											method : "POST",
											async : false,
											data : $(
													'form[name=' + formname
															+ ']').serialize(),

											success : function(response) {

												//alert("kal"+response);

												if (response != 0) {

													// $('#ayacut-dailogue').dialog('close'); 

													 $('#action_alert').html('<p style="margin: 0px !important;">Data inserted Successfully</p>');
														$("html,body").animate({scrollTop:$('#action_alert').offset().top-175}, 500);
												}
												if (response == 0 ||response==null) {

													 $('#action_alert').html('<p style="margin: 0px !important;">Failed to Update data</p>');
											    		$("html,body").animate({scrollTop:$('#action_alert').offset().top-175}, 500);
												}
												
												 // alert("kal");
												 $(customformid).trigger("reset"); 	
												 
												 // alert("kal");
												 
												  if((formname=='resform1name')||(formname=='resform2name')||(formname=='resform3name')||(formname=='resform4name')){
												    	
													    
										               // $("#d")[0].reset() 
												// alert("i am in form 1");
												    
												 
												    getann1inspectdata(newyear);
												 
												// alert("after in form 1");
												    }

												//getResRegAyacutByResCode(response);

												//  alert(finYear);

												//  $('#action_alert').dialog('open'); 

												// getunitData(unitId,circleId,divisionId) ;

											},

											error : function() {
												alert(error);

											}

										});

								
							}
							
							}else {
								
								$('form[name=mainformname]').parsley().validate();
								//alert("kal4");
							}

						});  */
		
		
		/* var yearval=parseInt($("#year").val());
		 if(yearval!='Nan' && yearval!=null){
			 
			 if(yearval>0){
				 
				  $('.mainyear').val(yearval);
				 
			 }
			 
			 
		 }
		 */

		/* var dutyfreq=parseInt($("#dutyFrequencyId").val());
		 if(dutyfreq!=null && dutyfreq!="NaN"){
			 
			 alert("dutyfreq"+dutyfreq);
			 
			 if(dutyfreq>0){
				 
				  $('.maindutyFrequencyId').val(dutyfreq);
				  
				
				 
			 }
			 
			 
		 }*/
		 
		 
		 

	});

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

/*function getann1inspectdata(year){
	
	var freq= $('#dutyFrequencyId').val();
	
	var resCode=$('#reservoirId').val();
	
	//alert(year+resCode+freq);
	
	$.ajax({	          
	      url: "../invtsimis/getann1inspectdata?year="+year+"&reservoirId="+resCode+"&freq_oper="+freq,
	      type: "GET",
	      asunc:false,
	      contentType: "application/json; charset=utf-8",
	      success: function (msg) {
	    	  
	    	 // console.log(msg);
	    	  
	    	  var obj = JSON.parse(msg);
	    	  
	    	  for(i in obj){
	    		  
	    		  var dbmapvalue=obj[i].resCheckId;
	    		  var dbcatId=obj[i].resCatId;
	    		  
	    		
	    		  
	    		  if(dbcatId==1){
	    		if(dbmapvalue>=24 && dbmapvalue<=47) {
	    		  for(var j=1 ; j<=24 ;j++){
	    			  var mapid="#aresCheckId"+j ;
	    			  
	    		  var mapvalue=$(mapid).val();
	    		// alert("mapvalue"+mapvalue);
	    		 
	    		
		    		  
	    		
	    			  
	    		if( dbmapvalue==mapvalue ){
	    			
	    			//  alert("dbmapvalue"+dbmapvalue);
	    			
	    			var getid=$(mapid).attr('id');
		    		
		    		//alert("getid"+getid);
		    		
		    		//alert("getinsidej"+j);
		    		var checkid="#aresCheckId"+j;
		    		var catid="#aresCatId"+j;
		    		var checkboxid="#aresCheckboxId"+j
		    		var remarks="#aremarks"+j;

		    		$(checkboxid).prop('checked', true);
		    		$(checkboxid).attr('disabled',true); 
		    		
		    		
		    		$(remarks).val(obj[i].remarks);
		    		$(remarks).attr('readonly',true); 
		    	
		    	
		    		
		    		
	    		}
	    			
	    			
	    		  }
	    		  
	    	  }
	    	  }
	    	  if(dbcatId==2){
	    		if(dbmapvalue>=48 && dbmapvalue<=59 )  {
		    		  for(var j=1 ; j<=12 ;j++){
		    			  var mapid="#bresCheckId"+j ;
		    			  
		    		  var mapvalue=$(mapid).val();
		    		 // alert("mapvalue"+mapvalue);
		    		 
		    		
			    		  
		    		
		    			  
		    		  if( dbmapvalue==mapvalue ){
			    			
			    			var getid=$(mapid).attr('id');
				    		
				    		//alert("getid"+getid);
				    		
				    		//alert("getinsidej"+j);
				    		var checkid="#bresCheckId"+j;
				    		var catid="#bresCatId"+j;
				    		var checkboxid="#bresCheckboxId"+j
				    		var remarks="#bremarks"+j;

				    		$(checkboxid).prop('checked', true);
				    		$(checkboxid).attr('disabled',true); 
				    		
				    		
				    		$(remarks).val(obj[i].remarks);
				    		$(remarks).attr('readonly',true); 
				    	
				    	
				    		
				    		
			    		}
		    		  
		    	  }
	    		}
	    		}
	    	  if(dbcatId==3){
	    		if(dbmapvalue>=72 && dbmapvalue<=85 ) {
		    		  for(var j=1 ; j<=14 ;j++){
		    			  var mapid="#cresCheckId"+j ;
		    			  
		    		  var mapvalue=$(mapid).val();
		    		 // alert("mapvalue"+mapvalue);
		    		 
		    		
			    		  
		    		
		    			  
		    		  if( dbmapvalue==mapvalue ){
			    			
			    			var getid=$(mapid).attr('id');
				    		
				    		//alert("getid"+getid);
				    		
				    		//alert("getinsidej"+j);
				    		var checkid="#cresCheckId"+j;
				    		var catid="#cresCatId"+j;
				    		var checkboxid="#cresCheckboxId"+j
				    		var remarks="#cremarks"+j;

				    		$(checkboxid).prop('checked', true);
				    		$(checkboxid).attr('disabled',true); 
				    		
				    		
				    		$(remarks).val(obj[i].remarks);
				    		$(remarks).attr('readonly',true); 
				    	
				    	
				    		
				    		
			    		}
		    		  
		    			
		    		  }
		    		  
		    	  }
	    	  }
	    	  if(dbcatId==4){
	    		if(dbmapvalue>=86 && dbmapvalue<=97 ) {
		    		
	    			  for(var j=1 ; j<=12 ;j++){
		    			  var mapid="#dresCheckId"+j ;
		    			  
		    		  var mapvalue=$(mapid).val();
		    		
		    		 
		    		
			    		  
		    		
		    			  
		    		  if( dbmapvalue==mapvalue ){
			    			
			    			var getid=$(mapid).attr('id');
				    		
				    		//alert("getid"+getid);
				    		
				    		//alert("getinsidej"+j);
				    		var checkid="#dresCheckId"+j;
				    		var catid="#dresCatId"+j;
				    		var checkboxid="#dresCheckboxId"+j
				    		var remarks="#dremarks"+j;

				    		$(checkboxid).prop('checked', true);
				    		$(checkboxid).attr('disabled',true); 
				    		
				    		
				    		$(remarks).val(obj[i].remarks);
				    		$(remarks).attr('readonly',true); 
				    	
				    	
				    		
				    		
			    		}
		    		  
		    			
		    		  }
		    		  
		    	  }
	    	  }
	    	  
	    	  }

	      },
	      error : function(){
	    	  alert(error);
	      }
	  });
	
	
}*/

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
	    
	    var latitude=obj[0].latitude;
	    
	    var longitude=obj[0].longitude;
	    
	    		$('#grossCapacity').val(capacity);
	    		$('#geoTagId').val(geoId);
	    		$('#gayacut').val(grossAyacut);
	    		
	    		$('#tanklatitude').val(latitude);
	    		
	    		$('#tanklongitude').val(longitude);
	    		
	    		
	    	  
	    	  

	      },
	      error : function(){
	    	  alert(error);
	      }
	  });	
	} 


function showprojectsdata(projectName,projectId,reservoirId,reservoirName,unitId,formId,nrld){
	
	
	
	 $('#projectName').val(projectName);
	 $('#reservoirName').val(reservoirName);
	 $('#resmainprojectId').val(projectId);
	 $('#resId').val(reservoirId);
	 $('#respic').val(nrld);
	 
	 
	 

	 getDistricts(1);
	 
	 
	 
	 if(reservoirId>0){
		 
		 $('#resprepost').show();
		 
		 $('.mainprojId').val(projectId);
		 $('.mainresId').val(reservoirId);
	
		 
		 $('.maintankId').val(0);
		 $('#tankId').val(0);
		 
			
				  $('#pmsresinfo').show();
				  
				  $('#mkinfo').hide();
					
					
				 $('#getprojects_dialogue').dialog('close');
				
				
				
				 
				 getResList(reservoirId);
				 
			
				 
				 $('#resdianew').val(reservoirName);
				 
				
				 
			 }else {
				 
				 $('#pmsresinfo').hide();
				 
				 $('.resprepost').hide();
				 
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
		  
		 
		  
		  
		  $('#resprepost').show();
		
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
		 $('.resprepost').hide();
		 
		
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
		
		var newbutid="#"+buttonid;	
		
		/* $( ".annbuttoninf" ).each(function() {
			
			 if($(".annbuttoninf").hasClass('shviewinf')){	                    
					var colorid=$(this).prop('id');				
				
					
					var newcolorid="#"+colorid;	        
					
					  
					  $(newcolorid).css('background-color', 'rgb(0, 128, 0)');
					   
					
			 }	
			 
			 if($(".annbuttoninf").hasClass('shrecinf')){	                    
					var colorid=$(this).prop('id');			    				
				
					
					var newcolorid="#"+colorid;	        
					
					  
					  $(newcolorid).css('background-color', 'rgb(255, 0, 0)');
					   
					
			 }	
			 if($(".annbuttoninf").hasClass('btnhoverclr')){	                    
					var colorid=$(this).prop('id');			    				
				
					
					var newcolorid="#"+colorid;		    				
	        
					  $(newcolorid).removeClass('btnhoverclr');	    
					  
					  $(newcolorid).css('background-color', '#ADD8E6');
					   
					
			 }	
			 
			
		
			});
		
	    */
		
		/* $(newbutid).css('background-color', '#0CAFFF');
		 
		 $(newbutid).addClass("btnhoverclr");*/
		

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
	
	function addnrldchecksann1(formId,flag,rescheckId){
	
		
		var formId = formId		
		 
		 var customformid="#"+formId;
	
		
		   var newyear=$("#year").val();
		
		$('#action_alert').empty();
		
		var year= $('#year').val();
		var tankId= $('#tankId').val();
		var dutyFrequencyId= $('#dutyFrequencyId').val();
			
			var reservoirId=$('#resId').val();
			
			var projId=$('#resmainprojectId').val();
				
				var conditionofDamId=$('#conditionofDamId').val();
				
			   var nextPostId=$('#nextPostId').val();
			   
			   var nextEmpId=$('#nextEmpId').val();
			
			$('.mainresId').val(reservoirId);
			$('.maintankId').val(tankId);
			$('.mainyear').val(year);
			$('.mainprojId').val(projId);
			$('.maindutyFrequencyId').val(dutyFrequencyId);
			
			$('.mainconditionofDamId').val(conditionofDamId);
			
			$('.mainnextPostId').val(nextPostId);
			
			$('.mainnextEmpId').val(nextEmpId);
			
			
			
			
			
			
		
	//alert("flag"+flag);
		
		if(flag=='false'){	
			
			
		if ($('form[name=mainformname]').parsley().isValid()) {  	
				
				//alert("kal2");
		if ($('form[id=' + formId + ']').parsley().isValid()) {

			//alert("kal3");

		

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
									 
									 getresmst2mst1byfreqyear(1);
									 
									 
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
		if(flag=='true'){	
			
			updatenrldannchecks(formId,rescheckId,flag);
		}
		
	}
	
	function anneditobservations(rescheckId){
		
		
		var viewremarks="#"+"remarks"+rescheckId ;
		  
		  var viewchfrom="#"+"irrChFrm"+rescheckId ;
		  
		  var viewchto="#"+"irrChTo"+rescheckId ;
		  

		  var viewresCheckName="#"+"resCheckName"+rescheckId ;
		  
		  var viewinstalledcount="#"+"installedcount"+rescheckId ;
		  
		  var viewlocation="#"+"location"+rescheckId ;
		  
		  var viewinstallmonth="#"+"installmonth"+rescheckId ;
		  
		  var viewworkingconditionn="#"+"workingconditionn"+rescheckId ;
		  var viewworkingconditiony="#"+"workingconditiony"+rescheckId ;
		  
		  var viewdatelastCalibrated="#"+"datelastCalibrated"+rescheckId ;
		  
		  var viewdatenextCalibrated="#"+"datenextCalibrated"+rescheckId ;
		  
		  var viewobsmaintainedn="#"+"obsmaintainedn"+rescheckId ;
		  var viewobsmaintainedy="#"+"obsmaintainedy"+rescheckId ;
		  
		  var viewagencyresponsiblen="#"+"agencyresponsiblen"+rescheckId ;
		  var viewagencyresponsibley="#"+"agencyresponsibley"+rescheckId ;
		  
		  var viewanalysisofdatan="#"+"analysisofdatan"+rescheckId ;
		  var viewanalysisofdatay="#"+"analysisofdatay"+rescheckId ;
		  
		  var viewdatasenttoDSOn="#"+"datasenttoDSOn"+rescheckId ;
		  var viewdatasenttoDSOy="#"+"datasenttoDSOy"+rescheckId ;
		  
		  var viewdamcheckResponseIdn="#"+"damcheckResponseIdn"+rescheckId ;
		  var viewdamcheckResponseIdy="#"+"damcheckResponseIdy"+rescheckId ;
		  
		  var viewdamcheckResponseIdna="#"+"damcheckResponseIdna"+rescheckId ;
		  
		  var viewconditionofCheckId="#"+"conditionofCheckId"+rescheckId+" option";
		  
		  var dataconditionofCheckId="#"+"conditionofCheckId"+rescheckId ;
		
		var resann1editFlag="#"+"resann1editFlag"+rescheckId;
		
		var resann2editFlag="#"+"resann2editFlag"+rescheckId;
		
	//	alert("resann1editFlag"+resann1editFlag);
		
		 $(resann1editFlag).val(true);	
		 
		 $(resann2editFlag).val(true);	
		
			 
			 $(viewinstalledcount).attr("readonly", false);	
			 
			 $(viewlocation).attr("readonly", false);
			
			 
			 $(viewchfrom).attr("readonly", false);
		
			 
			 $(viewchto).attr("readonly", false);
			
			 
			
				 
			
			  $(viewworkingconditionn).attr('disabled', false);
			  
			  $(viewworkingconditiony).attr('disabled', false);
			  
			  $(viewobsmaintainedn).attr('disabled', false);
			  $(viewobsmaintainedy).attr('disabled', false);
			  
			  $(viewagencyresponsiblen).attr('disabled', false);
			  $(viewagencyresponsibley).attr('disabled', false);
			  
			  $(viewagencyresponsiblen).attr('disabled', false);
			  $(viewagencyresponsibley).attr('disabled', false);
			  
			  $(viewanalysisofdatan).attr('disabled', false);
			  
			  $(viewanalysisofdatay).attr('disabled', false);
			  
			  $(viewdatasenttoDSOn).attr('disabled', false);
			  
			  $(viewdatasenttoDSOy).attr('disabled', false);
			  
			  $(viewdamcheckResponseIdn).attr('disabled', false);
			  
			  $(viewdamcheckResponseIdy).attr('disabled', false);
			  
			  
			  $(viewdamcheckResponseIdna).attr('disabled', false);
			
			  
			  
			  $(viewremarks).attr("readonly", false);
			  
			  
				  
				
				
				 
				  $(dataconditionofCheckId).attr("disabled", false); 
				
		         var rescheckbutton="#"+"rescheckbutton"+rescheckId;
		         
		         $(rescheckbutton).text("Edit"); 
		
	}
	
	function updatenrldannchecks(formId,rescheckId,flag){
		
		var formId = formId		
		 
		 var customformid="#"+formId;
	
		
		
		
		$('#action_alert').empty();

	
		
		if(flag=='true'){	
			
			
		if ($('form[name=mainformname]').parsley().isValid()) {  	
				
				//alert("kal2");
		if ($('form[id=' + formId + ']').parsley().isValid()) {

			//alert("kal3");

		

			$
					.ajax({
						url : "../invtsimis/update-inspectmst2info",
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

								 $('#action_alert').html('<p style="margin: 0px !important;">Data updated Successfully</p>');
									$("html,body").animate({scrollTop:$('#action_alert').offset().top-175}, 500);
									
									 $(customformid).trigger("reset"); 	
									 
									 getresmst2mst1byfreqyear(1);
									 
									 
							}
							
							
						
							if (response == 0 ||response ==null ) {
								
								//alert("kal2"+response);

								 $('#action_alert').html('<p style="margin: 0px !important;">Failed to Update data</p>');
						    		$("html,body").animate({scrollTop:$('#action_alert').offset().top-175}, 500);
							}
                         
							
							
							
							 

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
		
		
	}
	
function AddRemarksInfo(formId,flag){
		
	
	var damannRemarksMst1ReviewId=$('#damannRemarksMst1ReviewId').val();
	
	var formId = formId		
	 
	 var customformid="#"+formId;
	
	var year= $('#year').val();
	var tankId= $('#tankId').val();
	var dutyFrequencyId= $('#dutyFrequencyId').val();
		
		var reservoirId=$('#resId').val();
		
		var projId=$('#resmainprojectId').val();
			
			var conditionofDamId=$('#conditionofDamId').val();
			
		   var nextPostId=$('#nextPostId').val();
		   
		   var nextEmpId=$('#nextEmpId').val();
		
		$('.mainresId').val(reservoirId);
		$('.maintankId').val(tankId);
		$('.mainyear').val(year);
		$('.mainprojId').val(projId);
		$('.maindutyFrequencyId').val(dutyFrequencyId);
		
		$('.mainconditionofDamId').val(conditionofDamId);
		
		$('.mainnextPostId').val(nextPostId);
		
		$('.mainnextEmpId').val(nextEmpId);
		

	
	$('#action_alert').empty();

  if(flag=='false' && damannRemarksMst1ReviewId==0){
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
		  document.getElementById('inspectcaptcha_idr').src = '../captcha2.jpg?' + Math.random();
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
		
		if(response==-3){
			
			$('#action_alert').html('<p style="margin: 0px !important;">Please Enter the Captcha Text </p>'); 
			  $("html,body").animate({scrollTop:0}, 500);
		}
		
	if(response==-2){
			
			$('#action_alert').html('<p style="margin: 0px !important;">Captcha does not match </p>'); 
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
  
  if(flag=='true' && damannRemarksMst1ReviewId>0){
	  
	  updateRemarks(formId,flag,damannRemarksMst1ReviewId);
	  
  }

	}

function updateRemarks(formId,flag,damannRemarksMst1ReviewId){
	
	
	var formId = formId		
	 
	 var customformid="#"+formId;

	
	$('#action_alert').empty();
	
	if(flag=='true' && damannRemarksMst1ReviewId>0){


		if ($('form[name=mainformname]').parsley().isValid()) {  
			
	//alert("kal2 insert inspection info");
	if ($('form[id='+formId+']').parsley()
			.isValid()) {		 
   $.ajax({	          
url: "../invtsimis/update-DamRemarksinfo" ,
method:"POST",
dataType: 'json',

async: false,
data: $('form[id=' + formId+ ']').serialize() ,


success: function (response) {

	  
	//  console.log(response);
	
	if(response>0){
	  
	  $('#reviewformremann1').trigger("reset"); 
	  
	  $("#damannareviewinfoid").text("Submit");

	  $('#action_alert').html('<p style="margin: 0px !important;">Data Updated Successfully</p>');
	  $("html,body").animate({scrollTop:0}, 500);
	  
	  getDamRemarksinfo()
	  document.getElementById('inspectcaptcha_idr').src = '../captcha2.jpg?' + Math.random();
	//  getDamInspectioninfo();
	  
	}if(response==0 || response==null){
		
		

		  $('#action_alert').html('<p style="margin: 0px !important;">Failed to Update</p>');
		  $("html,body").animate({scrollTop:0}, 500);
		
		
	}
	
	if(response==-3){
		
		$('#action_alert').html('<p style="margin: 0px !important;">Please Enter the Captcha Text </p>'); 
		  $("html,body").animate({scrollTop:0}, 500);
	}
	
if(response==-2){
		
		$('#action_alert').html('<p style="margin: 0px !important;">Captcha does not match </p>'); 
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
	
	
}


function AddInspectionInfo(formId,flag){
	
	//alert("flag"+flag);
	
	//
	var resinspectInfoId= $('#hiddeninsresinspectInfoId').val();	
	
	var formId = formId		
	 
	 var customformid="#"+formId;
	
	var year= $('#year').val();
	var tankId= $('#tankId').val();
	var dutyFrequencyId= $('#dutyFrequencyId').val();
		
		var reservoirId=$('#resId').val();
		
		var projId=$('#resmainprojectId').val();
			
			var conditionofDamId=$('#conditionofDamId').val();
			
		   var nextPostId=$('#nextPostId').val();
		   
		   var nextEmpId=$('#nextEmpId').val();
		
		$('.mainresId').val(reservoirId);
		$('.maintankId').val(tankId);
		$('.mainyear').val(year);
		$('.mainprojId').val(projId);
		$('.maindutyFrequencyId').val(dutyFrequencyId);
		
		$('.mainconditionofDamId').val(conditionofDamId);
		
		$('.mainnextPostId').val(nextPostId);
		
		$('.mainnextEmpId').val(nextEmpId);
		

	
	$('#action_alert').empty();
	
	if(flag=='false' && resinspectInfoId==0){

		//alert("inside add"+resinspectInfoId);
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
		  
		  getDamInspectioninfo();
		  
		  getResInspectioninfo();
		  
		  document.getElementById('inspectcaptcha_id').src = '../captcha.jpg?' + Math.random();
		  
		}if(response==0 || response==null){
			
			

			  $('#action_alert').html('<p style="margin: 0px !important;">Failed to Insert</p>');
			  $("html,body").animate({scrollTop:0}, 500);
			
			
		}
		if(response==-3){
			
			$('#action_alert').html('<p style="margin: 0px !important;">Please Enter the Captcha Text </p>'); 
			$("html,body").animate({scrollTop:0}, 500);
		}
		
	if(response==-2){
			
			$('#action_alert').html('<p style="margin: 0px !important;">Captcha does not match </p>'); 
			$("html,body").animate({scrollTop:0}, 500);
		}
	
	if(response==-4){
		
		$('#action_alert').html('<p style="margin: 0px !important;">Already Added Inspection Details </p>'); 
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

	if (flag=='true'  &&  resinspectInfoId >0 ){
		
		//alert("kal update"+flag);
		
		updateinspectinfo(formId,flag,resinspectInfoId);
		
		
	}

	}


function updateinspectinfo(formId,flag,resinspectInfoId){
	
//	alert("kal update"+formId);
	
	//alert("kal flag"+flag);
	
//	alert("kal resinspectInfoId"+resinspectInfoId);
	
	var formId = formId		
	 
	 var customformid="#"+formId;

	
	$('#action_alert').empty();
	
	if(flag=='true' && resinspectInfoId>0){


		if ($('form[name=mainformname]').parsley().isValid()) {  
			
	//alert("kal2 insert inspection info");
	if ($('form[id='+formId+']').parsley()
			.isValid()) {		 
    $.ajax({	          
url: "../invtsimis/update-inspectinfo" ,
method:"POST",
dataType: 'json',

async: false,
data: $('form[id=' + formId+ ']').serialize() ,


success: function (response) {

	  
	//  console.log(response);
	
	if(response>0){
	  
	  $('#addinspect').trigger("reset"); 
	  
	  $("#submitinspectinf").text("Submit");

	  $('#action_alert').html('<p style="margin: 0px !important;">Data Updated Successfully</p>');
	  $("html,body").animate({scrollTop:0}, 500);
	  
	  getDamInspectioninfo();
	  getResInspectioninfo();
	  document.getElementById('inspectcaptcha_id').src = '../captcha.jpg?' + Math.random();
	  
	}if(response==0 || response==null){
		
		

		  $('#action_alert').html('<p style="margin: 0px !important;">Failed to Update</p>');
		  $("html,body").animate({scrollTop:0}, 500);
		
		
	}
	
	if(response==-3){
		
		$('#action_alert').html('<p style="margin: 0px !important;">Please Enter the Captcha Text </p>'); 
		  $("html,body").animate({scrollTop:0}, 500);
	}
	
if(response==-2){
		
		$('#action_alert').html('<p style="margin: 0px !important;">Captcha does not match </p>'); 
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
	
	
	
}


function AddRecommendationInfo(formId,flag,checkId,dialno){
		
	
	var formId = formId		
	 
	 var customformid="#"+formId;
	
	var year= $('#year').val();
	var tankId= $('#tankId').val();
	var dutyFrequencyId= $('#dutyFrequencyId').val();
		
		var reservoirId=$('#resId').val();
		
		var projId=$('#resmainprojectId').val();
			
			var conditionofDamId=$('#conditionofDamId').val();
			
		   var nextPostId=$('#nextPostId').val();
		   
		   var nextEmpId=$('#nextEmpId').val();
		
		$('.mainresId').val(reservoirId);
		$('.maintankId').val(tankId);
		$('.mainyear').val(year);
		$('.mainprojId').val(projId);
		$('.maindutyFrequencyId').val(dutyFrequencyId);
		
		$('.mainconditionofDamId').val(conditionofDamId);
		
		$('.mainnextPostId').val(nextPostId);
		
		$('.mainnextEmpId').val(nextEmpId);
		

	
	$('#action_alert').empty();


	if(flag=='false'){
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
			
			
			  getrecommendationsbyyeartank();
		
		  
		 

		  $('#action_alert').html('<p style="margin: 0px !important;">Data Inserted Successfully</p>');
		  $("html,body").animate({scrollTop:0}, 500);
		  
		  if(dialno==1){
		  $('#addrecpmmend').trigger("reset"); 
		  
		  if ($('#addrecommend_dialogue').dialog('isOpen') === true) {
			  
				//  alert("kal2");
				  $('#addrecommend_dialogue').dialog("close"); 
				}
		  }else if (dialno==2){
			  
			  
			  $('#addrecpmmendhealth').trigger("reset"); 
			  
			  if ($('#addhealthremarks_dialogue').dialog('isOpen') === true) {
				  
					//  alert("kal2");
					  $('#addhealthremarks_dialogue').dialog("close"); 
					}
		  }
		  
		//  alert($('#addrecommend_dialogue').dialog('isOpen'));
		  
		
		 
		  
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
	
	if(flag=='true'){
		
		updateAnnRecommendationInfo(formId,flag,checkId,dialno);
	}
		

	}


function updateAnnRecommendationInfo(formId,flag,checkId,dialno){
	
	
	
	if(flag=='true'){
		//alert("kal2 recommendatiion info");
		if ($('form[id='+formId+']').parsley()
				.isValid()) {		 
	    $.ajax({	          
	url: "../invtsimis/update-damremarksbyrecId" ,
	method:"POST",
	dataType: 'json',

	async: false,
	data: $('form[id=' + formId+ ']').serialize() ,


	success: function (response) {

		  
		//  console.log(response);
		
		if(response>0){
			
			if(dialno==1){
				
				
		  
		  $('#addrecpmmend').trigger("reset"); 
		  
		  $('#annreseditflag').val(false);
		  
		  $('#addrecommend_dialogue').dialog('close');
		  
			}else if(dialno==2){
				
				
				 $('#addrecpmmendhealth').trigger("reset"); 
				  
				  $('#healtheditFlag').val(false);
				  
				  $('#addhealthremarks_dialogue').dialog('close');
				
			}
		  
		  $('#action_alert').html('<p style="margin: 0px !important;">Data updated Successfully</p>');
		  $("html,body").animate({scrollTop:0}, 500);
		  
		  getResDamRecommendations(checkId );
		  
		}if(response==0 || response==null){
			
			

			  $('#action_alert').html('<p style="margin: 0px !important;">Failed to Update</p>');
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
	
}


function deleteresrecommendations(resannRecommendId,checkId){
	
	
	
	
		//alert("kal2 recommendatiion info");
		
	    $.ajax({	          
	url: "../invtsimis/delete-damremarksbyrecId" ,
	method:"POST",
	dataType: 'json',

	async: false,
	async: false,
	data: {
		  
		resannRecommendId:resannRecommendId,
		
		  
	},


	success: function (response) {

		  
		//  console.log(response);
		
		if(response>0){
			
		
		  
		  $('#addrecpmmend').trigger("reset"); 
		  
		

		  $('#action_alert').html('<p style="margin: 0px !important;">Data deleted Successfully</p>');
		  $("html,body").animate({scrollTop:0}, 500);
		  
		  getResDamRecommendations(checkId );
		  
		}if(response==0 || response==null){
			
			

			  $('#action_alert').html('<p style="margin: 0px !important;">Failed to delete</p>');
			  $("html,body").animate({scrollTop:0}, 500);
			
			
		}
		   
		//  gettankfeeddata(tankId) ; 
		

	},
	error : function(){
		 alert(error);

	}
	}); 	
		 
			
	
	
}



function getresmst2mst1byfreqyear(hkey){
	
	$(".annbuttoninf").removeClass('shviewinf');
	
	 $(".annbuttoninf").removeAttr('style');
	 
	 $(".installno").attr("readonly", false);
	 $(".installno").val(0);
	 
	 $(".locat").attr("readonly", false);
	 $(".locat").val('');
	 
	 $(".chfrmann1").attr("readonly", false);
	 $(".chfrmann1").val(0.01);
	 
	 $(".chtoann1").attr("readonly", false);
	 $(".chtoann1").val(0.01);
	 
	 $(".instmonth").attr("readonly", false);
	 $(".instmonth").val(0);
	 

	 $(".datelstcalb").val(' ');
	 
	
	 $(".datenxtcalb").val(' ');
	 
	
	  $(".instwrkcond").attr('disabled', false);
	  $(".rd1wrkn").prop("checked" , true); 
	  
	  $(".obsmain").attr('disabled', false);
	  $(".rd1obsn").prop("checked" , true); 
	  
	  $(".agresp").attr('disabled', false);
	  $(".rd1agn").prop("checked" , true); 
	  
	  $(".analysedata").attr('disabled', false);
	  $(".rd1ann").prop("checked" , true); 
	  
	  $(".analysedata").attr('disabled', false);
	  $(".rd1ann").prop("checked" , true); 
	  
	  $(".datadso").attr('disabled', false);
	  $(".rd1dson").prop("checked" , true); 
	  
	  $(".datadso").attr('disabled', false);
	  $(".rd1dson").prop("checked" , true); 
	 
	  $(".remks").attr("readonly", false);
		 $(".remks").val('');
	  
		 $(".resannvieweditdata").hide();
		 
		 $(".damresp").attr('disabled', false);
		  $(".rd1damn").prop("checked" , true); 
		  
		  $(".ann2rmks").attr("readonly", false);
		  $(".ann2rmks").val(' '); 
		  
		  $(".irrchfrm2ann").attr("readonly", false);
		  $(".irrchfrm2ann").val(0.01); 
		  
		  $(".irrchto2ann").attr("readonly", false);
		  $(".irrchto2ann").val(0.01); 
		  
		  $(".condcheck").attr("disabled", false);
		  $(".condcheck").val(''); 
		  
		
		
		 
	  
	  
	
	
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
		  
		  var year=0;  
		  var reservoirId=0;
		  var tankId=0
		  var dutyFrequencyId=0;
		  var postId=0;
		  
		  var conditionofDamId=0;

		  if(hkey==1){
	
			  year= $('#year').val();
	
			  reservoirId=$('#resId').val();
	
	
	
			  tankId=$('#tankId').val();
	
	//alert("tankId"+tankId);
	
            dutyFrequencyId=$('#dutyFrequencyId').val();
	        conditionofDamId=$('#conditionofDamId').val();
	
	        postId=$('.mainpostId').val();
	
		  }
		  
	
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
	    	  
	    	// console.log(msg);
	    		//alert('kalhere1') 
	    	 
	    	 if(msg===null||msg===0 || msg==='[]'){
		    		
		    		//alert('coming here in year mst2 inspect msg null')
	    		  
	    		  $('#action_alert').html(''); 
	    		  
	    				    		  
		    		
	    	 }
	    	 
	    	// alert("kal"+msg.length);
	    	 
	    	 if(msg.length ==2){
	    		 
	    		// 
	    		 if(year>0 && (dutyFrequencyId==9|| dutyFrequencyId==10)){
	    		 
	    		 $('#action_alert').html('<p style="margin: 0px !important;">No data</p>');
				  $("html,body").animate({scrollTop:0}, 500);
	    		 
	    		 }
	    		 
	    	 }
		    	
	    	 
	    	
	    	if(msg!=null){  
	    		
	    	
	    		 // alert("msg"+msg);
		    	  
		    	 
	    		
	    		//alert('kalhere')
	    		  var obj = JSON.parse(msg);
	    		
	    		if(obj!=null){
	    			
	    			
	    			// $("#previnfodata").show();
		    		
		    	//	 $("#previnfodata").removeAttribute('style');
	    			//  $("#previnfodata").hide(); 
			    		
                   // $("#prevrecommenddata").show();
		    		 
		    		// $("#prevrecommenddata").removeAttribute('style');
	    		  
	    		 
	    		  
	    		
	    		
		    	
		    	    
		    	 
		    		 
	    		
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
	    		  
	    		  var dbpostId=obj[i].postId
	    		  // alert("dbconditionofDamId"+dbconditionofDamId);
	    		  
	    		 
	    		  
	    		  
	    		  var conditionofDamId="#conditionofDamId"
			    		$(conditionofDamId).val(dbconditionofDamId);
	    		  
	    			$(conditionofDamId).multiselect('rebuild');
	    		  
	    		  
	    			$("#editDamStatus12").show(); 
	    			
	    			 $(".mainresInspectMst1Id").val(dbmst1); 
	    		  
	    		  
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
	    		  
	    		  var viewconditionofCheckId="#"+"conditionofCheckId"+dbcheckid+" option";
	    		  
	    		  var dataconditionofCheckId="#"+"conditionofCheckId"+dbcheckid ;
	    		  
	    		  
	    		 var  rescheckbutton="#"+"rescheckbutton"+dbcheckid ;
	    		
	    		  var resann1editFlag="#"+"resann1editFlag"+dbcheckid;
	    		  var resann2editFlag="#"+"resann2editFlag"+dbcheckid;
	    		  
	    		  var tableid="#gen-frm-table-"+dbcheckid
	    		  
	    		  
	    		 // alert("postId"+postId);
	    		  
	    		//  alert("dbpostId"+dbpostId);
	    		  
	    		
	    		  
	    		 $(rescheckbutton).text("Submit"); 
	    		 
	    		
	    		 
	    		  
	    		 $(resann1editFlag).val(false);	
	    		 
	    		 $(resann2editFlag).val(false);	
	    		//  $(".mainresInspectMst1Id").val(dbmst1); 
	    		  
	    		  $(hiddenann2mst1Id).val(dbmst1); 
	    		  $(hiddenann2mst2Id).val(dbmst2); 
	    		  
	    		  $(hiddenhealthmst1Id).val(dbmst1); 
	    		  $(hiddenhealthmst2Id).val(0); 
	    		  
	    		  
	    		  $(hiddenatsmst1Id).val(dbmst1); 
	    		  $(hiddenatsmst2Id).val(0); 
	    		  
	    		  
	    		  
	    		  
	    		  
	    		  $(buttonid).addClass("shviewinf");
	    		  
	    		 
	    		  if($(buttonid).hasClass('shviewinf')){	                    
						var greencolorid=$(this).prop('id');			    				
					
						
						var newgreencolorid="#"+greencolorid;		    				
		        
						 $(buttonid).css('background-color', 'green'); 
						  
						
				 }	
				
	    		  
	    		
	    		  
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
	    			  $(viewdamcheckResponseIdy).prop("disabled" , true);   
	    			  $(viewdamcheckResponseIdna).prop("disabled" , true);   
	    			  
	    		  }else if(dbdamcheckResponseId==2){
	    			  
	    			  $(viewdamcheckResponseIdn).prop("checked" , false);   
                      $(viewdamcheckResponseIdy).prop("checked" , true);   
	    			  
	    			  $(viewdamcheckResponseIdna).prop("checked" , false); 
	    			  $(viewdamcheckResponseIdn).prop("disabled" , true);  
	    			  $(viewdamcheckResponseIdy).prop("disabled" , true);   
	    			  $(viewdamcheckResponseIdna).prop("disabled" , true);   
	    			 
	    		  }else if (dbdamcheckResponseId==3){
	    			  $(viewdamcheckResponseIdn).prop("checked" , false);   
                      $(viewdamcheckResponseIdy).prop("checked" , false);   
	    			  
	    			  $(viewdamcheckResponseIdna).prop("checked" , true); 
	    			  
	    			  $(viewdamcheckResponseIdn).prop("disabled" , true);  
	    			  $(viewdamcheckResponseIdy).prop("disabled" , true);   
	    			  $(viewdamcheckResponseIdna).prop("disabled" , true);   
	    			  
	    		  }
	    		  
	    		  
	    
			    
	    		  
	    		  $(viewconditionofCheckId).each(function () {    			  
	    			
	    			  var x=$(this).val();
	    			  //  alert("this.val"+x)
		    			 if (x == dbconditionofCheckId) {
				    	        //	alert("equal"+actionrequirereq+"*"+obj[i].actionrequireqId+"--"+$(this).val());
				    	         
				    	            
				    	        

				    	  		  $(dataconditionofCheckId).val(dbconditionofCheckId);
				    	  		$(dataconditionofCheckId).attr('disabled', true);	
				    	  		 
				    	            
				    	        } 
				    	       
		    	});
	    		  
	    		  var editbutton="#reseditobs"+dbcheckid;
	    			  
	    			  var deletebutton="#resdeleteobs"+dbcheckid;
	    			  
	    			 
	    		
	    		
	    		    if (postId==dbpostId){
    			  
    			  $(editbutton).show();
    			  
    			  $(deletebutton).show();
    		  }
    		  
    		  if(postId!=dbpostId){
    			  
    			  $(editbutton).hide();
    			  
    			  $(deletebutton).hide();
    		  }
    		  
	    		  
	    		  
	    		  
	    		 // getresgenchecklist(dbcheckid,2);
	    	  
	    		 
	    	}//end of obj if not null
	    	
	    	
	    	
	    	
	    	
	    	  
	    	  
	    	} // end of if msg is not null
	    		
	    	}
	    	 
	      },
	      error : function(){
	    	  alert(error);
	      }
	  });
	
	getrecommendationsbyyeartank();
	
	}else{
		
		$('#action_alert').html('<p style="margin: 0px !important;" >please select  Monsoon </p>'); 
		
	}
	
	
}


function getrecommendationsbyyeartank (){
	
//alert("i am iin recommnd");


	
	

var year= $('#year').val();
	
	var reservoirId=$('#resId').val();
	
	
	
	var tankId=$('#tankId').val();
	
	//alert("tankId"+tankId);
	
	var dutyFrequencyId=$('#dutyFrequencyId').val();
	//var conditionofDamId=$('#conditionofDamId').val();
	//alert("year"+year);
	
	//alert("tankId"+tankId);
	
	var checknum=0;
	var editann2=null;
	var deleteann2=null;
	
	$.ajax({
		url : "../invtsimis/get-damremarksbyresyeartank",
		type : "POST",
		data: {reservoirId :  reservoirId,
			tankId:tankId,
			dutyFrequencyId:dutyFrequencyId,
			year:year,
			
			},
		success : function(response) {
			
		//alert("response"+response);
			var obj = JSON.parse(response);
			
		//	alert("obj"+obj);
			
			
			 
			 for(i in obj){
				 
				var remarks=obj[i].remarks;
				var resInspectMst1Id=obj[i].resInspectMst1Id;
				
				var resInspectMst2Id=obj[i].resInspectMst2Id;
				
				var resDamHealthId=obj[i].resDamHealthId;
				
				var inspectOfficeInfoId=obj[i].inspectOfficeInfoId
				
				var inspectOfficeName=obj[i].inspectOfficeName
				
				if(resInspectMst2Id>0){
					
					
					$(".annbuttoninf").each(function() {
						var butid=$(this).prop('id');
						var greenbutton="#"+butid;
						
						
							
						//alert("shflag"+shflag);
						 if($(greenbutton).hasClass("shviewinf")){	                    
									    				
								//alert("sluid"+sluid);
							  checknum=butid.substring(6,butid.length);
							 
							var mst2id= "#ann2mst2Id"+checknum ;
							
							var mst2data=$(mst2id).val();
							
							//alert("mst2data"+mst2data);
							
							if(resInspectMst2Id==mst2data){
								
								//alert("checknum"+checknum);
								var newbutid="#"+butid;		
								
								 $(newbutid).css('background-color', 'red');
					    		  
					    		  $(newbutid).addClass("shrecinf");
					    		  
					    			 editann2="#reseditobs"+checknum;
									
									 deleteann2="#resdeleteobs"+checknum;
									
									 $(editann2).addClass("sheditann2inf");
									 
									 $(deleteann2).addClass("shdelann2inf");
									
									 
				       	
							}
									   
					         }
						});
				}
				
			
				// alert("editann2"+editann2);
				// alert("deleteann2"+deleteann2);
				 
				 if($(editann2).hasClass("sheditann2inf")==true || $(deleteann2).hasClass("shdelann2inf")==true ){
				 
				 $(".sheditann2inf").hide();
				 
				 $(".shdelann2inf").hide();
				 }
				 
			 }
			
			

		},
		error : function() {
			alert(error);
		}
	});
	
	
 
	
}



function getResDamRecommendations(checkId ) {
	
	
	 $('#getrecommendation_dialogue').dialog('option', 'title', 'View Recommendation Info');
	  $('#getrecommendation_dialogue').dialog('open');
	
	
	$("#viewrecdatahead").empty();
	$("#viewrecdatabody").empty();
	
var year= $('#year').val();

var mst2id="#ann2mst2Id"+checkId;

var mst2data=$(mst2id).val();


	
	var reservoirId=$('#resId').val();
	
var tankId= $('#tankId').val();
	
	var dutyFrequencyId=$('#dutyFrequencyId').val();
	
	var postId=$('.mainpostId').val();
	
	//alert("postId"+postId);

	$.ajax({
		url : "../invtsimis/get-damremarksbyresyeartank",
		type : "POST",
		data: {year :  year,
			reservoirId: reservoirId,
			tankId:tankId,
			dutyFrequencyId:dutyFrequencyId},
		success : function(response) {
			
			//alert("response"+response);
			
			if(response!=null){
			
			var obj = JSON.parse(response);
			
			 $('#viewrevommends table thead').append( '<tr style="font-size: 18px; color: gray; font-weight: bold;"><th>Sl.No</th>'+
	    	    		
	    	    		'<th>Inspection office</th>'+
	    	    		
	    	    		'  <th>Inspection Date</th>'+
	    	    		'  <th>Remedial Measures Suggested </th>'+
	    	    	
	    	    		/*'  <th>Latest</th>'+*/
	    	    		'  <th>Is Latest</th>'+
	    	    		
	    	    		'  <th>Recommendation Entry Date</th>'+
	    	    		
	    	    		'  <th>Edit / Delete </th>'+
	    	    		
	    	    		
	    	    		
	    	    	
	    	    		'</tr>'); 	  

				var j=0;

			 for(i in obj){
				 
				 
	    	    	
	    	    	//var k=obj[i].tabId;
	    	    	var s= obj[i].postId ;
	    	    	var latest= obj[i].isLatest;
	    	    	//alert(obj[i].deficiencyCategoryName);
	    	    	
	    	    	var officeName="'"+obj[i].inspectOfficeName+"'" ;
	    	    	
	    	    	//alert("mst2data"+mst2data);
	    	    	
	    	    	//alert("obj[i].resInspectMst2Id"+obj[i].resInspectMst2Id);
	    	    	
	    	    
	    	    	
	    	    if(mst2data==obj[i].resInspectMst2Id){
	    	    	
	    	    	j=j+1;
	    	    	
	    	    	   $('#viewrevommends table tbody').append(  '<tr style="font-size: 16px">' +
	    	    			                                '<td style="text-align: center;">'+j+'</td>' +
	    	    			                               
	    	    			                                '<td><b>'+obj[i].inspectOfficeName+'</b></td>' +
	    	    			                                '<td><b>'+obj[i].inspectDate+'</b></td>' +
		    	    			                            
	    	    			                         
	    	    			                                
	    	    			                                '<td><b>'+obj[i].remarks+'</b></td>' +
	    	    			                                
	    	    			                        (latest==true ?      '<td><b>Yes</b></td>' : '<td><b>No</b></td>') +
	    	    			                        
	    	    			                        '<td><b>'+obj[i].createDate+'</b></td>' +
	    	    			                                
	    	    			                       (s==postId ?         '<td><b><button type="button" name="editmst1remarks" id="editdamremarks'+j+'" class="btn btn-1 btn-primary center-block mst1reedit" onclick="editresrecommendations('+obj[i].resannRecommendId+','+checkId+')"  >Edit </button></b>'+
	    	    			                                '<br>'+
	    	    			                                '<b><button type="button" name="editmst1remarks" id="deldamremdeatils'+j+'" class="btn btn-1 btn-primary center-block mst1reedit" onclick="deleteresrecommendations('+obj[i].resannRecommendId+','+checkId+')"  >Delete </button>'+
	    	    			                                '</td>' : '<td></td>') +
	    	    			                                
	    	    			                               
	    	    			                            
	    	    			                                	    	    			                               
	    	    			                             /*(s==postId? */  
	    	    			                                '<br>'+
	    	    	                                     '</tr>');
	    	    	   
	    	    	   
	    	    	  
	    	    	   
	    	    	
	    	    	  /* (k==1? '<td><b>Bund Remarks</b></td>': '')+
                       (k==2? '<td><b>Sluice Remarks</b></td>': '')+
                       (k==3? '<td><b>Weir Remarks</b></td>': '')+
                         */
	    	    	   
	    	    }
	    	    
	    	    if(mst2data!=obj[i].resInspectMst2Id && obj[i].resInspectMst2Id==null){
	    	    	
	    	    	var reseditobs="#reseditobs"+checkId;
					
					$(reseditobs).removeAttr("style");
					
		          var resdeleteobs="#resdeleteobs"+checkId;
					
					$(resdeleteobs).removeAttr("style");
	    	    	
	    	    }
	    	  //  j++;   
	    	    
	    	    }
			 
			}
			
		
				
				
			
				
			

		},
		error : function() {
			alert(error);
		}
	});
}




function getResDamHealthRecommendations(healthId ) {
	
	
	 $('#getrecommendation_dialogue').dialog('option', 'title', 'View Health Recommendation Info');
	  $('#getrecommendation_dialogue').dialog('open');
	
	
	
	
var year= $('#year').val();

//var mst2id="#ann2mst2Id"+checkId;

//var mst2data=$(mst2id).val();


	
	var reservoirId=$('#resId').val();
	
var tankId= $('#tankId').val();
	
	var dutyFrequencyId=$('#dutyFrequencyId').val();
	
	var postId=$('.mainpostId').val();
	
	//alert("postId"+postId);

	$.ajax({
		url : "../invtsimis/get-damremarksbyresyeartank",
		type : "POST",
		data: {year :  year,
			reservoirId: reservoirId,
			tankId:tankId,
			dutyFrequencyId:dutyFrequencyId},
		success : function(response) {
			
			
			
			
			var obj = JSON.parse(response);
			
			$("#viewrecdatahead").empty();
			$("#viewrecdatabody").empty();
			
			 $('#viewrevommends table thead').append( '<tr style="font-size: 18px; color: gray; font-weight: bold;"><th>Sl.No</th>'+
	    	    		
	    	    		'<th>Inspection office</th>'+
	    	    		
	    	    		'  <th>Inspection Date</th>'+
	    	    		'  <th>Remedial Measures Suggested </th>'+
	    	    	
	    	    		/*'  <th>Latest</th>'+*/
	    	    		'  <th>Is Latest</th>'+
	    	    		
	    	    		'  <th>Recommendation Entry Date</th>'+
	    	    		
	    	    		'  <th>Edit / Delete </th>'+
	    	    		
	    	    		
	    	    		
	    	    	
	    	    		'</tr>'); 	  

				var j=0;

			 for(i in obj){
				 
				 
	    	    	
	    	    	//var k=obj[i].tabId;
	    	    	var s= obj[i].postId ;
	    	    	var latest= obj[i].isLatest;
	    	    	//alert(obj[i].deficiencyCategoryName);
	    	    	
	    	    	var officeName="'"+obj[i].inspectOfficeName+"'" ;
	    	    	
	    	    	var resDamHealthId=obj[i].resDamHealthId;
	    	    	
	    	    	//alert("mst2data"+mst2data);
	    	    	
	    	    	//alert("obj[i].resInspectMst2Id"+obj[i].resInspectMst2Id);
	    	    	
	    	    
	    	    	
	    	    if(resDamHealthId==healthId){
	    	    	
	    	    	j=j+1;
	    	    	
	    	    	   $('#viewrevommends table tbody').append(  '<tr style="font-size: 16px">' +
	    	    			                                '<td style="text-align: center;">'+j+'</td>' +
	    	    			                               
	    	    			                                '<td><b>'+obj[i].inspectOfficeName+'</b></td>' +
	    	    			                                '<td><b>'+obj[i].inspectDate+'</b></td>' +
		    	    			                            
	    	    			                         
	    	    			                                
	    	    			                                '<td><b>'+obj[i].remarks+'</b></td>' +
	    	    			                                
	    	    			                        (latest==true ?      '<td><b>Yes</b></td>' : '<td><b>No</b></td>') +
	    	    			                        
	    	    			                        '<td><b>'+obj[i].createDate+'</b></td>' +
	    	    			                                
	    	    			                       (s==postId ?         '<td><b><button type="button" name="editmst1remarks" id="editdamremarks'+j+'" class="btn btn-1 btn-primary center-block mst1reedit" onclick="editreshealthrecommendations('+obj[i].resannRecommendId+','+healthId+')"  >Edit </button></b>'+
	    	    			                                '<br>'+
	    	    			                                '<b><button type="button" name="editmst1remarks" id="deldamremdeatils'+j+'" class="btn btn-1 btn-primary center-block mst1reedit" onclick="deleteresrecommendations('+obj[i].resannRecommendId+','+healthId+')"  >Delete </button>'+
	    	    			                                '</td>' : '<td></td>') +
	    	    			                                
	    	    			                               
	    	    			                            
	    	    			                                	    	    			                               
	    	    			                             /*(s==postId? */  
	    	    			                                '<br>'+
	    	    	                                     '</tr>');
	    	    	   
	    	    	   
	    	    	  
	    	    	   
	    	    	
	    	    	  /* (k==1? '<td><b>Bund Remarks</b></td>': '')+
                      (k==2? '<td><b>Sluice Remarks</b></td>': '')+
                      (k==3? '<td><b>Weir Remarks</b></td>': '')+
                        */
	    	    	   
	    	    }
	    	  //  j++;   
	    	    
	    	    }
			 
			 

		},
		error : function() {
			alert(error);
		}
	});
}

function editresrecommendations(resannRecommendId,checkId){
	
	 $('#addrecommend_dialogue').dialog('option', 'title', 'Edit Recommendations');
	  $('#addrecommend_dialogue').dialog('open');
 
	  $('#addrecpmmend').trigger("reset"); 		  
	
	
	$.ajax({
		url : "../invtsimis/get-damremarksbyrecId",
		type : "POST",
		data: {resannRecommendId :  resannRecommendId,
		},
		success : function(response) {
			
		
			var obj = JSON.parse(response);
			
			
				var s= obj[0].postId ;
    	    	var latest= obj[0].isLatest;    	    	
    	    	var officeName="'"+obj[0].inspectOfficeName+"'" ;
    	    	
    	    	var resInspectMst2Id= obj[0].resInspectMst2Id;   
    	    	
    	    	var resInspectMst1Id= obj[0].resInspectMst1Id;   
    	    	
    	    	var resDamHealthId= obj[0].resDamHealthId; 
    	    	
    	    	var inspectOfficeInfoId= obj[0].inspectOfficeInfoId; 
    	    	
    	    	var resannRecommendId= obj[0].resannRecommendId;
    	    	
    	    	var remarks= obj[0].remarks;
    	    	
    	    	//alert("remarks"+remarks);
    	    	
    	    	$('#rec2resInspectMst1Id').val(resInspectMst1Id);
    	    	
    	    	$('#rec2resInspectMst2Id').val(resInspectMst2Id);
    	    	
    	    	$('#rec2resDamHealthId').val(resDamHealthId);
    	    	
    	    	//$('#selectedhealthinspectOfficeId').val(inspectOfficeInfoId);
    	    	
    	    	$('#rec2inspectOfficeInfoId').val(inspectOfficeInfoId);
    	    	
    	    	$('#rec2inspectOfficeInfoId').multiselect('rebuild');
    	    	
    	    	$('#damannrecemremarks').val(remarks);
    	    	
    	    	$('#annreseditflag').val(true);
    	    	
    	    	$('#rec2resannRecommendId').val(resannRecommendId);
    	    	
    	    	$('#rec2checkId').val(checkId);
    	    	
    	    
    	    	
    	    	
    	    	//selectedhealthinspectOfficeId
    	    	
    	    	
    	    	
    	    	
    	    	
    	    	

			
		},
		error : function() {
			alert(error);
		}
	});
	
	
	
}


function editreshealthrecommendations(resannRecommendId,checkId){
	
	 $('#addhealthremarks_dialogue').dialog('option', 'title', 'Edit Health Status Recommendations');
	  $('#addhealthremarks_dialogue').dialog('open');

	  $('#addrecpmmendhealth').trigger("reset"); 		  
	
	
	$.ajax({
		url : "../invtsimis/get-damremarksbyrecId",
		type : "POST",
		data: {resannRecommendId :  resannRecommendId,
		},
		success : function(response) {
			
		
			var obj = JSON.parse(response);
			
			
				var s= obj[0].postId ;
   	    	var latest= obj[0].isLatest;    	    	
   	    	var officeName="'"+obj[0].inspectOfficeName+"'" ;
   	    	
   	    	var resInspectMst2Id= obj[0].resInspectMst2Id;   
   	    	
   	    	var resInspectMst1Id= obj[0].resInspectMst1Id;   
   	    	
   	    	var resDamHealthId= obj[0].resDamHealthId; 
   	    	
   	    	var inspectOfficeInfoId= obj[0].inspectOfficeInfoId; 
   	    	
   	    	var resannRecommendId= obj[0].resannRecommendId;
   	    	
   	    	var remarks= obj[0].remarks;
   	    	
   	    	var officeName2=obj[0].inspectOfficeName+"("+obj[0].inspectDate+")" ;
   	    	
   	    	//alert("remarks"+remarks);
   	    	
   	    	$('#healthresInspectMst1Id').val(resInspectMst1Id);
   	    	
   	    	$('#healthresInspectMst2Id').val(resInspectMst2Id);
   	    	
   	    	$('#healthresDamHealthId').val(resDamHealthId);
   	    	
   	    	$('#healthOfficeInfoId').val(inspectOfficeInfoId);
   	    	
   	    	
   	    	
   	    	//$('#selectedhealthinspectOfficeId').val(inspectOfficeInfoId);
   	    	
   	    	$('#inspectInfo').val(officeName2);
   	    	
   	    	//$('#inspectInfo').multiselect('rebuild');
   	    	
   	    	$('#recemremarks').val(remarks);
   	    	
   	    	$('#healtheditFlag').val(true);
   	    	
   	    	$('#healthannRecommendId').val(resannRecommendId);
   	    	
   	    
   	    	
   	    
   	    	
   	    	
   	    	//selectedhealthinspectOfficeId
   	    	
   	    	
   	    	
   	    	
   	    	
   	    	

			
		},
		error : function() {
			alert(error);
		}
	});
	
	
	
}

function addrecmmn (checkId,hkey){

	 
		 $('#addrecommend_dialogue').dialog('option', 'title', 'part 2a Recommendations');
		  $('#addrecommend_dialogue').dialog('open');
	  
		  $('#addrecpmmend').trigger("reset"); 		
		  
		if(( hkey==1 || hkey==2 ) ){
		  var fmst1Id="#ann2mst1Id"+checkId;
		  
		  var fmst2Id="#ann2mst2Id"+checkId;
		  
		  var dmst1Id=$(fmst1Id).val(); 
		  var dmst2Id=$(fmst2Id).val(); 
		  
		  $("#rec2resInspectMst1Id").val(dmst1Id); 
		  $("#rec2resInspectMst2Id").val(dmst2Id); 
		  
		  $("#rec2checkId").val(checkId); 
		  
		  
		  
		}
		
	  
		
}


function addhealthrecmmn (healthId,hkey,officeId,officeName){
//	alert("addhealthrecmmn"+officeName);

	
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
		data: {resinspectInfoId :  id,
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

function addresdamhealth(formId,flag,resDamHealthId){
	
	//alert("resDamHealthIdin add"+resDamHealthId);
	
	//alert("flag add"+ flag);
	
	
	var formId = formId		
	 
	 var customformid="#"+formId;
	$('#action_alert').empty();

	if(flag =='false' && resDamHealthId==0){
	


		
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
	
	//alert("iam coming here");
	//alert("iam coming here"+resDamHealthId);
	
	//alert("iam coming hereflag "+ flag);
	
	
	if(flag == 'true' && resDamHealthId>0){
		
		//alert("i am here in update");
		
		updateResDamHealthDetails(formId,flag,resDamHealthId);
	}
	
}


function updateResDamHealthDetails(formId,flag,resDamHealthId){
	
	//alert("resDamHealthId i m in updtate"+resDamHealthId);
	
//	alert("flag"+flag);
	
	
	if(flag=='true' && resDamHealthId>0){
	
	if ($('form[id='+formId+']').parsley()
			.isValid()) {		 
    $.ajax({	          
url: "../invtsimis/update-damHealthByHealthId" ,
method:"POST",
dataType: 'json',

async: false,
data: $('form[id=' + formId+ ']').serialize() ,


success: function (response) {

	  
	//  console.log(response);
	
	if(response>0){
	  
	  $('#reshealthform5').trigger("reset"); 
	  
	  $('#reshealtheditFlag').val(false);
	  
	
	  
	  $('#action_alert').html('<p style="margin: 0px !important;">Data updated Successfully</p>');
	  $("html,body").animate({scrollTop:0}, 500);
	  
	  getResDamHealthDetails();
	  
	}if(response==0 || response==null){
		
		

		  $('#action_alert').html('<p style="margin: 0px !important;">Failed to Update</p>');
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
	
}


function getResDamHealthDetails( ) {
	
	var userunitId= $('#healthunitId').val();
	var usercircleId= $('#healthcircleId').val();
	var userdivisionId= $('#healthdivisionId').val();
	var usersubdivisionId= $('#healthsubdivisionId').val();
	var userdesignationId= $('#healthdesignationId').val();
	
	
	$("#reshealthhead5").empty();
	$("#reshealthbody5").empty();
	
var year= $('#year').val();
	
	var reservoirId=$('#resId').val();
	
var tankId= $('#tankId').val();
	
	var dutyFrequencyId=$('#dutyFrequencyId').val();
	
	var postId=$(".mainpostId").val();
	

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
	    	    			                                
	    	    			                         ( s==postId?     '<td><b><button type="button" name="editmst1remarks" id="editmst1remarks'+j+'" class="btn btn-1 btn-primary center-block mst1reedit" onclick="editResHealthDetails('+obj[i].resDamHealthId+')"  >Edit </button></b>'+
	    	    			                                '<br>'+
	    	    			                                '<b><button type="button" name="editmst1remarks" id="delhealthdeatils'+j+'" class="btn btn-1 btn-primary center-block mst1reedit" onclick="deleteResHealthDetails('+obj[i].resDamHealthId+')"  >Delete </button>'+
	    	    			                                '</td>': '<td></td>' )+
	    	    			                                
	    	    			                               
	    	    			                            
	    	    			                                	    	    			                               
	    	    			                            /* (s==postId?  */ '<td > <br>'+
	    	    	 (((userunitId>0 && usercircleId==0 && userdivisionId==0 && usersubdivisionId==0) && (userunitId!=9 || userunitId !=4 || userunitId!=9832 || userunitId!=9830) && (userdesignationId==2 || userdesignationId==8 || userdesignationId==4 || userdesignationId==5 || userdesignationId==7 || userdesignationId==9 || userdesignationId==10 ) ) ?       '<button type="button" name="editmst1remarks" id="editmst1remarks'+j+'" class="btn btn-1 btn-primary center-block mst1reedit" onclick="addhealthrecmmn('+obj[i].resDamHealthId+',3,'+obj[i].inspectOfficeInfoId+','+officeName+')"  >Add  Recommendations</button> &emsp; &emsp; ' : '') +
	    	    			                                '<button type="button" name="deletemst1remarksname" id="deletemst1remarks'+j+'" class="btn btn-1 btn-primary center-block mst1redelete " onclick=" getResDamHealthRecommendations('+obj[i].resDamHealthId+' )"  >View/ Edit/Delete Recommendations</button>&emsp;&emsp; '+
	    	    			                                
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

 
function editResHealthDetails (resDamHealthId){
	
	
	 $("#resdamhealthbutton").text("Edit");
	 $("#reshealtheditFlag").val(true);
	
	$.ajax({
		url : "../invtsimis/get-resHealthDetails-byhealthid",
		type : "POST",
		data: {resDamHealthId :  resDamHealthId,
			},
		success : function(response) {
			
			var obj = JSON.parse(response);
			var deficiencyCategory=obj[0].deficiencyCategory
			var healthinspectOfficeInfoId=obj[0].inspectOfficeInfoId
			var reshealth6remarks=obj[0].remarks
			
			$('#deficiencyCategory').val(deficiencyCategory);
			 $("#deficiencyCategory").multiselect('rebuild');
			
			$('#healthinspectOfficeInfoId').val(healthinspectOfficeInfoId);
			 $("#healthinspectOfficeInfoId").multiselect('rebuild');
			
			$('#reshealth6remarks').val(reshealth6remarks);
			
			 $("#resresDamHealthId").val(resDamHealthId);
			 
			
			 
			 

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
	
function  addactionStatusInfo(formId,flag,actionId){
	
	
	
	
	var formId = formId		
	 
	 var customformid="#"+formId;

	
	$('#action_alert').empty();


		if(flag=='false' && actionId==0){
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
		
		if(flag=='true' && actionId>0){
	
			updateactionStatusInfo(formId,flag,actionId);
		}
}


function updateactionStatusInfo(formId,flag,actionId){
	
	
	
	if(flag=='true' && actionId>0){
		
		if ($('form[id='+formId+']').parsley()
				.isValid()) {		 
	    $.ajax({	          
	url: "../invtsimis/updateActionTakenActionId" ,
	method:"POST",
	dataType: 'json',

	async: false,
	data: $('form[id=' + formId+ ']').serialize() ,


	success: function (response) {

		  
		//  console.log(response);
		
		if(response>0){
		  
		  $('#resatsform').trigger("reset"); 
		  
		  $('#atseditFlag').val(false);
		  
		
		  
		  $('#action_alert').html('<p style="margin: 0px !important;">Data updated Successfully</p>');
		  $("html,body").animate({scrollTop:0}, 500);
		  
		  getActionStatusDetails( );
		  
		}if(response==0 || response==null){
			
			

			  $('#action_alert').html('<p style="margin: 0px !important;">Failed to Update</p>');
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
	
}



function getActionStatusDetails( ) {
	
	
	$("#resatshead7").empty();
	$("#resatsbody7").empty();
	
	var postId=$(".mainpostId").val();
	
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
	    	    			                                
	    	    			                          ( s==postId ?     '<td><b><button type="button" name="editmst1remarks" id="editmst1remarks'+j+'" class="btn btn-1 btn-primary center-block mst1reedit" onclick=" getActionStatusActionId( '+obj[i].resDamActionId+')"  >Edit </button></b>'+
	    	    			                                '<br>'+
	    	    			                                '<b><button type="button" name="editmst1remarks" id="editmst1remarks'+j+'" class="btn btn-1 btn-primary center-block mst1reedit" onclick="deleteResActionTakenDetails('+obj[i].resDamActionId+')"  >Delete </button>'+
	    	    			                                '</td>' : '<td> </td>' ) +
	    	    			                                
	    	    			                               
	    	    			                            
	    	    			                                	    	    			                               
	    	    			                           
	    	    			                              
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






function getActionStatusActionId( resDamActionId) {
	
	
	
	

	$.ajax({
		url : "../invtsimis/getActionTakenActionId",
		type : "POST",
		data: {
			resDamActionId: resDamActionId,
		},
		success : function(response) {
			
		
			
			 var j=1;
			
			var obj = JSON.parse(response);
			
			var resDamActionId=obj[0].resDamActionId;
			
			var resInspectMst1Id=obj[0].resInspectMst1Id;
			var inspectOfficeInfoId=obj[0].inspectOfficeInfoId
			
					
		
			var actionTakeninit= obj[0].actionTakeninit;
			var actionTakencomplete= obj[0].actionTakencomplete;
			var remarks=obj[0].remarks;
			
			
			
			$('#atsremarks').val(remarks);
			
			$('#atseditFlag').val(true);
			
			$('#atsresDamActionId').val(resDamActionId);
			
			
			
			if(actionTakeninit==true){
				
				$('#atsactionTakeninity').prop("checked",true);
			}
              if(actionTakeninit==false){
				
				$('#atsactionTakeninitn').prop("checked",true);
			}
              
              if(actionTakencomplete==true){
  				
  				$('#atsactionTakencompletey').prop("checked",true);
  			}
                if(actionTakencomplete==false){
  				
  				$('#atsactionTakencompleten').prop("checked",true);
  			}
                
              
                if(inspectOfficeInfoId>0){
                	
                	$('#resatc71inspectDate').val(inspectOfficeInfoId);	
                getResDamHealthDetailsByInspectInfo(inspectOfficeInfoId);
                getHealthRecommendationinfoId(inspectOfficeInfoId,resInspectMst1Id,0 );
                }
                $("#resatc71inspectDate").multiselect('rebuild');
			 

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
    	    		
					'<th>Dam Operator</th>'+
					'<th>Owner of Dam</th>'+
    	    		'<th>Inspect Office,Designation</th>'+
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
    	    	
    	    	//alert(obj[i].deficiencyCategoryName);
    	    	
    	    	var officeName="'"+obj[i].inspectOfficeName+"'" ;
    	    	
    	    	   $('#inspectdata table tbody').append(  '<tr style="font-size: 16px">' +
    	    			                                '<td style="text-align: center;">'+j+'</td>' +
    	    			                                
    	    			                                '<th><b>'+obj[i].damOperator+'</b></th>'+
    	    			            					'<th><b>'+obj[i].ownerOfDam+'</b></th>'+
    	    			                               
    	    			                                '<td><b>'+obj[i].inspectOfficeName+' , '+obj[i].inspectdesignationName+'</b></td>' +
    	    			                                
	    	    			                            
    	    			                         
    	    			                                
    	    			                                '<td><b>'+obj[i].inspectOfficerData+'</b></td>' +
    	    			                                
    	    			                                '<td><b>'+obj[i].fieldOfficerData+'</b></td>' +
    	    			                                
    	    			                                '<td><b>'+obj[i].inspectDate+'</b></td>' +
    	    			                                
    	    			                                '<td><b>'+obj[i].presentWaterlevel+'</b></td>' +
    	    			                                
    	    			                          
    	    			                                
    	    			                                '<td><b>'+obj[i].typeofinspection+'</b></td>' +
    	    			                                
    	    			                                '<td><b>'+obj[i].storageCapacity+'</b></td>' +
    	    			                                
    	    			                                '<td><b>'+obj[i].weathercondition+'</b></td>' +
    	    			                                
    	    			                           (s==postId ?     '<td><b><button type="button" name="editmst1remarks" id="editinspectiondetails'+j+'" class="btn btn-1 btn-primary center-block mst1reedit" onclick="editResInspectionDetails('+obj[i].resinspectInfoId+')"  >Edit </button></b>'+
    	    			                                '<br>'+
    	    			                                '<b><button type="button" name="editinspectremarks" id="editinspectremarksinf'+j+'" class="btn btn-1 btn-primary center-block mst1reedit" onclick="deleteResInspectionDetails('+obj[i].resinspectInfoId+')" >Delete </button>'+
    	    			                                '</td>' : '<td> </td>') +
    	    			                                
    	    			                               
    	    			                            
    	    			                                	    	    			                               
    	    			                           
    	    			                              
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

function editResInspectionDetails(resinspectInfoId){
	
	
	$.ajax({
		url : "../invtsimis/getresInspectInfobyInspectInfo",
		type : "POST",
		data: {resinspectInfoId :  resinspectInfoId,
			},
		success : function(response) {
			
				
				
				
				
				

			

			
			var obj = JSON.parse(response);
			
			var resInspectMst1Id=obj[0].resInspectMst1Id;
			
			var resinspectInfoId=obj[0].resinspectInfoId;
			
			var resinspectdesgId=obj[0].inspectdesignationId;
			
			
			
			var inspectOfficeId=obj[0].inspectOfficeId;
			
			var inspectinspectDate=obj[0].inspectDate;
			
			var inspectOfficerData=obj[0].inspectOfficerData;
			
			var fieldOfficerData=obj[0].fieldOfficerData;
			
			var typeofinspection=obj[0].typeofinspection;
			
			var presentWaterlevel=obj[0].presentWaterlevel;
			
			var storageCapacity=obj[0].storageCapacity;
			
			var weatherconditionId=obj[0].weatherconditionId;
			
			var damOperator=obj[0].damOperator;
			
			var ownerOfDam=obj[0].ownerOfDam;
			
			var owner= $("#hiddenuserdamowner").val();
			
			var operator= $("#hiddenuserdampop").val();
			
			//alert("inspectinspectDate"+inspectinspectDate);
			var dfreq=  $("#dutyFrequencyId").val();
			
			 $("#inspectOfficeId1").val(inspectOfficeId); 	
			 $("#inspectinspectDate1").val(inspectinspectDate); 
			 $("#inspectOfficerData1").val(inspectOfficerData); 
			 $("#fieldOfficerData1").val(fieldOfficerData);
			 
			 $("#rec2inspectdesignation").val(resinspectdesgId);
			 
			 
			 
			 if(typeofinspection==null){
			 $("#typeofinspection1").val(typeofinspection);
			 }else {
				 
				 $("#typeofinspection1").val(typeofinspection);
			 }
			 $("#presentWaterlevel1").val(presentWaterlevel);
			 $("#storageCapacity1").val(storageCapacity);
			 $("#weatherconditionId1").val(weatherconditionId);
			 
			 $("#hiddeninsresinspectInfoId").val(resinspectInfoId);
			 
		//alert("owner"+owner);
		//alert("operator"+damOperator);
		
			 if(damOperator=='NA'|| damOperator=="NA"){
			
				 $("#damOperator").val(operator); 
			// alert("damOperator1"+damOperator);
			 }else{
				 
				 $("#damOperator").val(damOperator);
				// alert("damOperator2"+damOperator);
				
				 
			 }
			 if(ownerOfDam=='NA' || ownerOfDam=="NA"){
				 
				 $("#ownerOfDam").val(owner); 
			
			 }else {
			
				 $("#ownerOfDam").val(ownerOfDam);
				
				 
			 }
			
			 $("#inspecteditFlag").val(true);
			
			 $("#submitinspectinf").text("Edit");
		
		},
		error : function() {
			alert(error);
		}
	}); 
	
	 $('html,body').animate({ scrollTop: $("#inspect").offset().top}, 'slow');
	
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
	
	var postId=$(".mainpostId").val();
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
    	    			                                
    	    			                                
    	    			                      (s==postId?          '<td> <br>'+
    	    	                                       '<b><button type="button" name="editmst1remarks" id="editremarksrev'+j+'" class="btn btn-1 btn-primary center-block mst1reedit" onclick="editRemarksReview('+obj[i].resRemarksMst1ReviewId+')"  >Edit Remarks</button></b>'+
    	    			                                '<br>'+
    	    			                                '<b><button type="button" name="editmst1remarks" id="delrevremarks'+j+'" class="btn btn-1 btn-primary center-block mst1reedit" onclick="deleteRmarksReview('+obj[i].resRemarksMst1ReviewId+')"  >Delete Remarks</button>'+
    	    			                                ' <br></td>' : '<td></td>' ) +
    	    			                                
    	    			                               
    	    			                            
    	    			                                	    	    			                               
    	    			                           
    	    			                              
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
	

	var postId=$(".mainpostId").val();
	
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
			
			//console.log("response"+response);	

			$('#inspectphtup table thead').append( '<tr style="font-size: 18px; color: gray; font-weight: bold;"><th>Sl.No</th>'+
    	    		
    	    		'<th>Inspect Office</th>'+
    	    		'  <th>Document Title</th>'+
    	    	
    	    		'  <th>Download</th>'+
    	    	
    	    		' <th> Delete </th>'+
    	    		
    	    	
    	    		'</tr>'); 	  

		

		 for(i in obj){
    	    	
    	    	//var k=obj[i].tabId;
    	    	var s= obj[i].postId ;
    	    	
    	    	//alert(obj[i].deficiencyCategoryName);
    	    	
    	    	var officeName="'"+obj[i].inspectOfficeName+"'" ;
    	    	
    	    	
    	    	
    	    	   $('#inspectphtup table tbody').append(  '<tr style="font-size: 16px">' +
    	    			                                '<td style="text-align: center;">'+j+'</td>' +
    	    			                               
    	    			                                '<td><b>'+obj[i].inspectOfficeName+'</b></td>' +
    	    			                                
	    	    			                           
    	    			                                '<td><b>'+obj[i].docTitle+'</b></td>' +
    	    			                                
    	    			                                '<td style="color:blue"><b><a target="_blank" href="../invtsimis/viewDamphotos?fileName='+obj[i].damDocName+'" download ><u>'+obj[i].damDocOriginalName+'<u></a></b></td>' +
    	    			                                
    	    			                              
    	    			                                
    	    			                                
    	    			                          (s==postId ?      '<td> <br>'+
    	    	                                      
    	    			                                '<b><button type="button" name="editmst1remarks" id="deleteinspectpht'+j+'" class="btn btn-1 btn-primary center-block mst1reedit" onclick="deleteAnnInspectDocs('+obj[i].damdocId+')"  >Delete </button>'+
    	    			                                ' <br></td>' : '<td></td>') +
    	    			                                
    	    			                               
    	    			                            
    	    			                                	    	    			                               
    	    			                           
    	    			                              
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
	    //console.log("is in array");
	    return true;
	  } else {
	    //console.log("is NOT in array");
	    return false;
	  }
	}, 32)
	.addMessage('en', 'fileextension', 'The file should be ,.jpeg,.jpg,.png,.pdf');



/*	window.Parsley.addValidator('uppercase', {
		  requirementType: 'number',
		  validateString: function(value, requirement) {
		    var uppercases = value.match(/[A-Z]/g) || [];
		    return uppercases.length >= requirement;
		  },
		  messages: {
		    en: 'Your Canal Name must contain at least (%s) uppercase letter.'
		  }
		});*/

		
	});


/*function resDamInfo(reservoirId ) {
	
	 $("#adddambasicinf").trigger("reset"); 	
	

	var reservoirId=reservoirId;
	$.ajax({
		url : "../invtsimis/getResDaminfoDetails",
		type : "POST",
		data: {
			reservoirId: reservoirId},
		success : function(response) {
		
			var obj = JSON.parse(response);

		  var typeOfDamId=obj[0].typeOfDamId;
		  
		  var ownerOfDam=obj[0].ownerOfDam;
		  
		  var damOperator=obj[0].damOperator;
		  
		  var commisionDate=obj[0].commisionDate;
		  
		  var hazardClassId=obj[0].hazardClassId;
		  
		  var damPurposeId=obj[0].damPurposeId;
		  
		  var reservoirId=obj[0].reservoirId
		  
		  
		  
		  $('#typeOfDamId').val(typeOfDamId);
		  $('#ownerOfDam').val(ownerOfDam);
		  $('#damOperator').val(damOperator);
		  $('#commisionDate').val(commisionDate);
		  $('#hazardClassId').val(hazardClassId);
		  $('#damPurposeId').val(damPurposeId);
		  
		  $('#dminfreservoirIddata').val(reservoirId);
		  
		  
		  $('#typeOfDamId').prop('disabled', true);
		  
		  $('#ownerOfDam').prop("readonly", true); 
		  
		  $('#damOperator').prop("readonly", true); 
		  
		  $('#commisionDate').prop("readonly", true);
		  
		  $('#hazardClassId').prop('disabled', true);
		  
		  $('#damPurposeId').prop("disabled", true); 
		
		

		

		
				
				
			

		},
		error : function() {
			alert(error);
		}
	});
}*/

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
		  
		  
		  var typeOfDamId=obj[0].typeOfDamId;
		  
			/*  var ownerOfDam=obj[0].ownerOfDam;
			  
			  var damOperator=obj[0].damOperator;
			  */
			  var commisionDate=obj[0].commisionDate;
			  
			  var hazardClassId=obj[0].hazardClassId;
			  
			  var damPurposeId=obj[0].damPurposeId;
			  
			  var resLatitude=obj[0].resLatitude;
			  
			  var resLongitude=obj[0].resLongitude;
			  
            var res_lat_d=obj[0].res_lat_d;
			  
			  var res_lat_m=obj[0].res_lat_m;
			  
			  var res_lat_s=obj[0].res_lat_s;
			  
            var res_long_d=obj[0].res_long_d;
			  
			  var res_long_m=obj[0].res_long_m;
			  
			  var res_long_s=obj[0].res_long_s;
			  
			
			  
			  
			  $('#typeOfDamId').val(typeOfDamId);
			 // $('#ownerOfDam').val(ownerOfDam);
			 // $('#damOperator').val(damOperator);
			  $('#commisionDate').val(commisionDate);
			  $('#hazardClassId').val(hazardClassId);
			  $('#damPurposeId').val(damPurposeId);
			  
			  $('#dminfreservoirIddata').val(reservoirId);
			  
			  
			  $('#typeOfDamId').prop('disabled', true);
			  
			 // $('#ownerOfDam').prop("readonly", true); 
			  
			//  $('#damOperator').prop("readonly", true); 
			  
			  $('#commisionDate').prop("readonly", true);
			  
			  $('#hazardClassId').prop('disabled', true);
			  
			  $('#damPurposeId').prop("disabled", true); 
			
			  $("#res_long_d").prop("readonly", true); 
			  
			  $("#res_long_m").prop("readonly", true); 
			  
			  $("#res_long_s").prop("readonly", true); 
			  
              $("#res_lat_d").prop("readonly", true); 
			  
			  $("#res_lat_m").prop("readonly", true); 
			  
			  $("#res_lat_s").prop("readonly", true); 
		  
		  $('#frlLevel').val(frlLevel);
		  $('#trlLevel').val(trlLevel);
		  $('#mwlLevel').val(mwlLevel);
		  $('#spillWayCrestLevel').val(spillWayCrestLevel);
		  $('#mddlLevel').val(mddlLevel);
		  $('#lowestRiverBed').val(lowestRiverBed);
		  $('#deepestfoundationLevel').val(deepestfoundationLevel);
		  $('#grossStorageatFrl').val(grossStorageatFrl);
		  
		  $('#dmctrlreservoirIddata').val(reservoirId);
		  
		  $("#resLatitude").val(resLatitude);
		  
		  $("#resLongitude").val(resLongitude); 
  
		  $('#frlLevel').prop("readonly", true); 
		  
		  $('#trlLevel').prop("readonly", true); 
		  
		  $('#mwlLevel').prop("readonly", true);
		  
		  $('#spillWayCrestLevel').prop("readonly", true);
		  
		  $('#mddlLevel').prop("readonly", true);
		  
		  $('#lowestRiverBed').prop("readonly", true);
		  
		  $('#deepestfoundationLevel').prop("readonly", true);
		  
		  $('#grossStorageatFrl').prop("readonly", true);

		  var res_lat_d=obj[0].res_lat_d;
		  
		  var res_lat_m=obj[0].res_lat_m;
		  
		  var res_lat_s=obj[0].res_lat_s;
		  
        var res_long_d=obj[0].res_long_d;
		  
		  var res_long_m=obj[0].res_long_m;
		  
		  var res_long_s=obj[0].res_long_s;
		  
		  $('#res_lat_d').val(res_lat_d);
		  $('#res_lat_m').val(res_lat_m);
		  $('#res_lat_s').val(res_lat_s);
		  $('#res_long_d').val(res_long_d);
		  $('#res_long_m').val(res_long_m);
		  $('#res_long_s').val(res_long_s);
		 
		  
		  
				
				
			

		},
		error : function() {
			alert(error);
		}
	});
}





function resDamSalientLvlInfo(reservoirId ) {
	
	 $("#addsalientinf9").trigger("reset"); 	
	 $("#addsalientinf8").trigger("reset"); 	
	 $("#addsalientinf7").trigger("reset"); 
	 $("#addsalientinf5").trigger("reset"); 
	 $("#addsalientinf4").trigger("reset"); 
	 $("#addsalientinf3").trigger("reset"); 
	 $("#addsalientinf2").trigger("reset"); 
	 $("#addsalientinf1").trigger("reset"); 
	

	var reservoirId=reservoirId;
	
	
	$('#dmsalientreservoirIddata9').val(reservoirId);
	$('#dmsalientreservoirIddata8').val(reservoirId);
	$('#dmsalientreservoirIddata7').val(reservoirId);
	$('#dmsalientreservoirIddata5').val(reservoirId);
	$('#dmsalientreservoirIddata4').val(reservoirId);
	$('#dmsalientreservoirIddata3').val(reservoirId);
	$('#dmsalientreservoirIddata2').val(reservoirId);
	$('#dmsalientreservoirIddata1').val(reservoirId);
	$.ajax({
		url : "../invtsimis/getResDamSalientDetails",
		type : "POST",
		data: {
			reservoirId: reservoirId},
		success : function(response) {
			
		
				
			var obj = JSON.parse(response);

		  var emergencyActionPlanPreparedId=obj[0].emergencyActionPlanPreparedId;
		  
		  var emergencyActionShared=obj[0].emergencyActionShared;
		  
		  var damGateNumberFine=obj[0].damGateNumberFine;
		  

		  var disaster_manage_prepared=obj[0].disaster_manage_prepared;
		  
		  var mwlLevel=obj[0].mwlLevel;
		  
		  var damBreakAnalysisId=obj[0].damBreakAnalysisId;
		  
		  var damretrofitMeausreAdopted=obj[0].damretrofitMeausreAdopted;
		  
		  var damRetrofitTime=obj[0].damRetrofitTime;
		  
		  var damRetrofitStatus=obj[0].damRetrofitStatus;
		  
		  var damFoundSafe=obj[0].damFoundSafe;
		  
		  
		  var structuralSafetyPerformedId=obj[0].structuralSafetyPerformedId
		  
		
		  
		  var reservoirId=obj[0].reservoirId
		  
		  
		  var peakWaterLeakage=obj[0].peakWaterLeakage;
		  
			  var lostPercentageReservoirCapacity=obj[0].lostPercentageReservoirCapacity;
			  
			  var reservoirSiltedId=obj[0].reservoirSiltedId;
			  
			  var OanMManualPreparedTime=obj[0].OanMManualPreparedTime;
			  
			  var OanMManualPreparedId=obj[0].OanMManualPreparedId;
			  
			  var gateOperationMethodId=obj[0].gateOperationMethodId;
			  
			  var GalleryDryStatus=obj[0].GalleryDryStatus;
			  
			  var galleryElevation=obj[0].galleryElevation;
			  
           var unusualDamDesignId=obj[0].unusualDamDesignId;
			  
			  var unusualDamDesigndetails=obj[0].unusualDamDesigndetails;
			  
			  var specialDifficultFoundationIssues=obj[0].specialDifficultFoundationIssues;
			  
           var mfdobservedflood=obj[0].mfdobservedflood;
			  
			  var capacitydeadstorage=obj[0].capacitydeadstorage;
			  
			  var capacityactivestorage=obj[0].capacityactivestorage;
			  
			  var salienttopwidth=obj[0].salienttopwidth;
			  var salientbottomwidth=obj[0].salientbottomwidth;
			  var salientlengthcrest=obj[0].salientlengthcrest;
			  var salientheightdfl=obj[0].salientheightdfl;
			  
			  var resgatesize=obj[0].resgatesize;
			  
			  var resgatenumber=obj[0].resgatenumber;
			  
			  var damGalleryNumber=obj[0].damGalleryNumber;
			  
			  var mfddesignflood=obj[0].mfddesignflood;
			  
			  var grossCapacityMwl=obj[0].grossCapacityMwl;
			  
			  
			  $('#emergencyActionPlanPreparedId').val(emergencyActionPlanPreparedId);
			  
			  $('#emergencyActionShared').val(emergencyActionShared);
			  
			  $('#resgatesize').val(resgatesize);
			  
			  $('#resgatenumber').val(resgatenumber);
			  
			  $('#damGalleryNumber').val(damGalleryNumber);
			  
			  $('#damGateNumberFine').val(damGateNumberFine);
			  
			  
			
			  $('#disaster_manage_prepared').val(disaster_manage_prepared);
			  $('#damBreakAnalysisId').val(damBreakAnalysisId);
			  $('#damretrofitMeausreAdopted').val(damretrofitMeausreAdopted);
			  
			  $('#damRetrofitTime').val(damRetrofitTime);
			  
			  
			  $('#damRetrofitStatus').val(damRetrofitStatus);
				
			  $('#damFoundSafe').val(damFoundSafe);
			  $('#structuralSafetyPerformedId').val(structuralSafetyPerformedId);
			  $('#peakWaterLeakage').val(peakWaterLeakage);			  
			  $('#lostPercentageReservoirCapacity').val(lostPercentageReservoirCapacity);
			  
				
			  $('#reservoirSiltedId').val(reservoirSiltedId);
			  $('#OanMManualPreparedTime').val(OanMManualPreparedTime);
			  $('#OanMManualPreparedId').val(OanMManualPreparedId);			  
			  $('#gateOperationMethodId').val(gateOperationMethodId);
			  
			  $('#GalleryDryStatus').val(GalleryDryStatus);			  
			  $('#galleryElevation').val(galleryElevation);
			  
			  $('#unusualDamDesignId').val(unusualDamDesignId);			  
			  $('#unusualDamDesigndetails').val(unusualDamDesigndetails);
			  
			  $('#specialDifficultFoundationIssues').val(specialDifficultFoundationIssues);
			  $('#mfddesignflood').val(mfddesignflood);
			  $('#mfdobservedflood').val(mfdobservedflood);
			  $('#capacitydeadstorage').val(capacitydeadstorage);
			  
			  $('#capacityactivestorage').val(capacityactivestorage);
			  
			  
			  $('#salienttopwidth').val(salienttopwidth);
			  
			  $('#salientbottomwidth').val(salientbottomwidth);			  
			  $('#salientlengthcrest').val(salientlengthcrest);
			  
			  $('#salientheightdfl').val(salientheightdfl);	
			  
			  $('#grossCapacityMwl').val(grossCapacityMwl);	
			  
			  
			 
			  $('#grossCapacityMwl').prop("readonly", true);
			  
			  $('#emergencyActionPlanPreparedId').prop('disabled', true);
			  
			  $('#OanMManualPreparedId').prop('disabled', true);
	
			  $('#disaster_manage_prepared').prop("readonly", true);
			  
			  $('#damBreakAnalysisId').prop('disabled', true);
			  
			  $('#structuralSafetyPerformedId').prop('disabled', true);		  
			
			  $("#damretrofitMeausreAdopted").prop("readonly", true); 
			  
			  $("#damRetrofitTime").prop("readonly", true); 
			  
			  $("#damRetrofitStatus").prop("readonly", true); 
			  
             $("#damFoundSafe").prop("readonly", true); 
			 
             $('#reservoirSiltedId').prop('disabled', true);
		  
 
		  $('#peakWaterLeakage').prop("readonly", true); 
		  
		  $('#OanMManualPreparedTime').prop("readonly", true); 
		  
		  $('#lostPercentageReservoirCapacity').prop("readonly", true); 
		  
		  $('#OanMManualPrepared').prop("readonly", true);
		  
	
		  
		    $('#gateOperationMethodId').prop('disabled', true);
		    
		    $('#unusualDamDesignId').prop('disabled', true);
		  
		    
		  
		  $('#GalleryDryStatus').prop("readonly", true);
		  
		  $('#galleryElevation').prop("readonly", true);
		  
		  $('#unusualDamDesigndetails').prop("readonly", true);
		  
		  $('#specialDifficultFoundationIssues').prop("readonly", true);
		  
		  $('#mfdobservedflood').prop("readonly", true);
		  
		  $('#mfddesignflood').prop("readonly", true);
		  
		  $('#capacitydeadstorage').prop("readonly", true);
		  
		  $('#capacityactivestorage').prop("readonly", true);
		  
		  
		  
		  $('#salienttopwidth').prop("readonly", true);
		  
		  $('#salientbottomwidth').prop("readonly", true);
		  
 $('#salientlengthcrest').prop("readonly", true);
		  
		  $('#salientheightdfl').prop("readonly", true);

		  $('#resgatesize').prop("readonly", true);
		  
		  $('#resgatenumber').prop("readonly", true);
		  
		  $('#damGalleryNumber').prop("readonly", true);
		  
		  $('#emergencyActionShared').prop("readonly", true);
		  
		  $('#damGateNumberFine').prop("readonly", true);
		  
		  
		  
		  
				
				
			

		},
		error : function() {
			alert(error);
		}
	});
}



function tankSalientLvlInfo(tankid ) {
	
	 $("#addsalientinf9").trigger("reset"); 	
	 $("#addsalientinf8").trigger("reset"); 	
	 $("#addsalientinf7").trigger("reset"); 
	 $("#addsalientinf5").trigger("reset"); 
	 $("#addsalientinf4").trigger("reset"); 
	 $("#addsalientinf3").trigger("reset"); 
	 $("#addsalientinf2").trigger("reset"); 
	 $("#addsalientinf1").trigger("reset"); 
	

	var tankid=tankid;
	
	
	$('#dmsalienttankdata9').val(tankid);
	$('#dmsalienttankdata8').val(tankid);
	$('#dmsalienttankdata7').val(tankid);
	$('#dmsalienttankdata5').val(tankid);
	$('#dmsalienttankdata4').val(tankid);
	$('#dmsalienttankdata3').val(tankid);
	$('#dmsalienttankdata2').val(tankid);
	$('#dmsalienttankdata1').val(tankid);
	$.ajax({
		url : "../invtsimis/getTankDamSalientDetails",
		type : "POST",
		data: {
			tankId: tankid},
		success : function(response) {
			
		
				
			var obj = JSON.parse(response);

		  var emergencyActionPlanPreparedId=obj[0].emergencyActionPlanPreparedId;
		  
		  var emergencyActionShared=obj[0].emergencyActionShared;
		  
		  var damGateNumberFine=obj[0].damGateNumberFine;
		  

		  var disaster_manage_prepared=obj[0].disaster_manage_prepared;
		  
		  var mwlLevel=obj[0].mwlLevel;
		  
		  var damBreakAnalysisId=obj[0].damBreakAnalysisId;
		  
		  var damretrofitMeausreAdopted=obj[0].damretrofitMeausreAdopted;
		  
		  var damRetrofitTime=obj[0].damRetrofitTime;
		  
		  var damRetrofitStatus=obj[0].damRetrofitStatus;
		  
		  var damFoundSafe=obj[0].damFoundSafe;
		  
		  
		  var structuralSafetyPerformedId=obj[0].structuralSafetyPerformedId
		  
		
		  
		  var tankId=obj[0].tankId
		  
		  
		  var peakWaterLeakage=obj[0].peakWaterLeakage;
		  
			  var lostPercentageReservoirCapacity=obj[0].lostPercentageReservoirCapacity;
			  
			  var reservoirSiltedId=obj[0].reservoirSiltedId;
			  
			  var OanMManualPreparedTime=obj[0].OanMManualPreparedTime;
			  
			  var OanMManualPreparedId=obj[0].OanMManualPreparedId;
			  
			  var gateOperationMethodId=obj[0].gateOperationMethodId;
			  
			  var GalleryDryStatus=obj[0].GalleryDryStatus;
			  
			  var galleryElevation=obj[0].galleryElevation;
			  
          var unusualDamDesignId=obj[0].unusualDamDesignId;
			  
			  var unusualDamDesigndetails=obj[0].unusualDamDesigndetails;
			  
			  var specialDifficultFoundationIssues=obj[0].specialDifficultFoundationIssues;
			  
          var mfdobservedflood=obj[0].mfdobservedflood;
			  
			  var capacitydeadstorage=obj[0].capacitydeadstorage;
			  
			  var capacityactivestorage=obj[0].capacityactivestorage;
			  
			  
			  
			  var salienttopwidth=obj[0].salienttopwidth;
			  var salientbottomwidth=obj[0].salientbottomwidth;
			  var salientlengthcrest=obj[0].salientlengthcrest;
			  var salientheightdfl=obj[0].salientheightdfl;
			  
			  var resgatesize=obj[0].resgatesize;
			  
			  var resgatenumber=obj[0].resgatenumber;
			  
			  var damGalleryNumber=obj[0].damGalleryNumber;
			  
			  var mfddesignflood=obj[0].mfddesignflood;
			  
			  var grossCapacityMwl=obj[0].grossCapacityMwl;
			  
			  
			  $('#emergencyActionPlanPreparedId').val(emergencyActionPlanPreparedId);
			  
			  $('#emergencyActionShared').val(emergencyActionShared);
			  
			  $('#resgatesize').val(resgatesize);
			  
			  $('#resgatenumber').val(resgatenumber);
			  
			  $('#damGalleryNumber').val(damGalleryNumber);
			  
			  $('#damGateNumberFine').val(damGateNumberFine);
			  
			  
			  
			  
			
			  $('#disaster_manage_prepared').val(disaster_manage_prepared);
			  $('#damBreakAnalysisId').val(damBreakAnalysisId);
			  $('#damretrofitMeausreAdopted').val(damretrofitMeausreAdopted);
			  
			  $('#damRetrofitTime').val(damRetrofitTime);
			  
			  
			  $('#damRetrofitStatus').val(damRetrofitStatus);
				
			  $('#damFoundSafe').val(damFoundSafe);
			  $('#structuralSafetyPerformedId').val(structuralSafetyPerformedId);
			  $('#peakWaterLeakage').val(peakWaterLeakage);			  
			  $('#lostPercentageReservoirCapacity').val(lostPercentageReservoirCapacity);
			  
				
			  $('#reservoirSiltedId').val(reservoirSiltedId);
			  $('#OanMManualPreparedTime').val(OanMManualPreparedTime);
			  $('#OanMManualPreparedId').val(OanMManualPreparedId);			  
			  $('#gateOperationMethodId').val(gateOperationMethodId);
			  
			  $('#GalleryDryStatus').val(GalleryDryStatus);			  
			  $('#galleryElevation').val(galleryElevation);
			  
			  $('#unusualDamDesignId').val(unusualDamDesignId);			  
			  $('#unusualDamDesigndetails').val(unusualDamDesigndetails);
			  
			  $('#specialDifficultFoundationIssues').val(specialDifficultFoundationIssues);
			  $('#mfddesignflood').val(mfddesignflood);
			  $('#mfdobservedflood').val(mfdobservedflood);
			  $('#capacitydeadstorage').val(capacitydeadstorage);
			  
			  $('#capacityactivestorage').val(capacityactivestorage);

			  
			  $('#salienttopwidth').val(salienttopwidth);
			  
			  $('#salientbottomwidth').val(salientbottomwidth);			  
			  $('#salientlengthcrest').val(salientlengthcrest);
			  
			  $('#salientheightdfl').val(salientheightdfl);	
			  
			  $('#grossCapacityMwl').val(grossCapacityMwl);	
			  
			 
			  
			  
			 
			  $('#grossCapacityMwl').prop("readonly", true);
			  
			  $('#emergencyActionPlanPreparedId').prop('disabled', true);
			  
			  $('#OanMManualPreparedId').prop('disabled', true);
	
			  $('#disaster_manage_prepared').prop("readonly", true);
			  
			  $('#damBreakAnalysisId').prop('disabled', true);
			  
			  $('#structuralSafetyPerformedId').prop('disabled', true);		  
			
			  $("#damretrofitMeausreAdopted").prop("readonly", true); 
			  
			  $("#damRetrofitTime").prop("readonly", true); 
			  
			  $("#damRetrofitStatus").prop("readonly", true); 
			  
            $("#damFoundSafe").prop("readonly", true); 
			 
            $('#reservoirSiltedId').prop('disabled', true);
		  

		  $('#peakWaterLeakage').prop("readonly", true); 
		  
		  $('#OanMManualPreparedTime').prop("readonly", true); 
		  
		  $('#lostPercentageReservoirCapacity').prop("readonly", true); 
		  
		  $('#OanMManualPrepared').prop("readonly", true);
		  
	
		  
		    $('#gateOperationMethodId').prop('disabled', true);
		    
		    $('#unusualDamDesignId').prop('disabled', true);
		  
		    
		  
		  $('#GalleryDryStatus').prop("readonly", true);
		  
		  $('#galleryElevation').prop("readonly", true);
		  
		  $('#unusualDamDesigndetails').prop("readonly", true);
		  
		  $('#specialDifficultFoundationIssues').prop("readonly", true);
		  
		  $('#mfdobservedflood').prop("readonly", true);
		  
		  $('#mfddesignflood').prop("readonly", true);
		  
		  $('#capacitydeadstorage').prop("readonly", true);
		  
		  $('#capacityactivestorage').prop("readonly", true);
		  
		  
		  
		  $('#salienttopwidth').prop("readonly", true);
		  
		  $('#salientbottomwidth').prop("readonly", true);
		  
$('#salientlengthcrest').prop("readonly", true);
		  
		  $('#salientheightdfl').prop("readonly", true);

		  $('#resgatesize').prop("readonly", true);
		  
		  $('#resgatenumber').prop("readonly", true);
		  
		  $('#damGalleryNumber').prop("readonly", true);
		  
		  $('#emergencyActionShared').prop("readonly", true);
		  
		  $('#damGateNumberFine').prop("readonly", true);
		  
		  
		  
				
				
			

		},
		error : function() {
			alert(error);
		}
	});
}













/*function TankDamInfo(tankId ) {
	
	 $("#adddambasicinf").trigger("reset"); 
	// alert("TankDamInfo"+tankId)

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
}*/

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
		  
		  
		  var typeOfDamId=obj[0].typeOfDamId;
		  
			/*  var ownerOfDam=obj[0].ownerOfDam;
			  
			  var damOperator=obj[0].damOperator;
			  */
			  var commisionDate=obj[0].commisionDate;
			  
			  var hazardClassId=obj[0].hazardClassId;
			  
			  var damPurposeId=obj[0].damPurposeId;
			  
			  
			  
			
			  
			  
			  $('#typeOfDamId').val(typeOfDamId);
			 // $('#ownerOfDam').val(ownerOfDam);
			 // $('#damOperator').val(damOperator);
			  $('#commisionDate').val(commisionDate);
			  $('#hazardClassId').val(hazardClassId);
			  $('#damPurposeId').val(damPurposeId);
		 // $('#dminftankdata').val(tankId);
		
		 
			  $('#typeOfDamId').prop('disabled', true);
			  
				 // $('#ownerOfDam').prop("readonly", true); 
				  
				//  $('#damOperator').prop("readonly", true); 
				  
				  $('#commisionDate').prop("readonly", true);
				  
				  $('#hazardClassId').prop('disabled', true);
				  
				  $('#damPurposeId').prop("disabled", true); 
				
		
		  
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


/*function updatetankdaminfo(formId){
	
	
	
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
			

		
	
	
	
}*/


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
		  
		  document.getElementById('contcaptcha_id').src = '../captcha3.jpg?' + Math.random();
		 // getResDamHealthDetails();
		  
		}if(response==-1){
			
			

			  $('#action_alert').html('<p style="margin: 0px !important;">please select Tank</p>');
			  $("html,body").animate({scrollTop:0}, 500);
			
			
		}if(response==0 || response==null){
			
			

			  $('#action_alert').html('<p style="margin: 0px !important;">Failed to Update</p>');
			  $("html,body").animate({scrollTop:0}, 500);
			
			
		}
		
		if(response==-3){
    		
    		$('#action_alert').html('<p style="margin: 0px !important;">Please Enter the Captcha Text </p>'); 
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
		 }else {
				
				$('form[id='+formId+']').parsley().validate();
				//alert("kal4");
				
		} 
			

		
	
	
	
}


/*function updateResdaminfo(formId){
	
	
	
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
			

		
	
	
	
}*/


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
		  
		  document.getElementById('contcaptcha_id').src = '../captcha3.jpg?' + Math.random();
		 // getResDamHealthDetails();
		  
		}if(response==-1){
			
			

			  $('#action_alert').html('<p style="margin: 0px !important;">please select Tank</p>');
			  $("html,body").animate({scrollTop:0}, 500);
			
			
		}if(response==0 || response==null){
			
			

			  $('#action_alert').html('<p style="margin: 0px !important;">Failed to Update</p>');
			  $("html,body").animate({scrollTop:0}, 500);
			
			
		}
		
if(response==-3){
    		
    		$('#action_alert').html('<p style="margin: 0px !important;">Please Enter the Captcha Text </p>'); 
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
	
	
	
/*if( flaginf=="false" && tankId>0 && reservoirId==0 && hkey==1  ){
	
	//alert("i am 1");
		
	$('#typeOfDamId').attr("disabled", false); 
	  $('#ownerOfDam').prop("readonly", false); 
	  $('#damOperator').prop("readonly", false); 
	  $('#commisionDate').prop("readonly", false); 
	  $('#hazardClassId').attr("disabled", false);
	  $('#damPurposeId').attr("disabled", false);
	  
	  $("#daminfeditFlag").attr('value', true);
	  
	  $("#dminftankdata").val(tankId);
	  
	  
	  
	  $("#daminfupdate").attr('value', 'Submit');
		
	}*/
	
   if(tankId>0 && reservoirId==0 && hkey==2 && flaginf=="false"){
	   
	   
	   
		
		$('#typeOfDamId').attr("disabled", false); 
		 // $('#ownerOfDam').prop("readonly", false); 
		 // $('#damOperator').prop("readonly", false); 
		  $('#commisionDate').prop("readonly", false); 
		  $('#hazardClassId').attr("disabled", false);
		  $('#damPurposeId').attr("disabled", false);
		  
		 // $("#daminfeditFlag").attr('value', true);
		  
		 // $("#dminftankdata").val(tankId);
		  
		  
		  
		 // $("#daminfupdate").attr('value', 'Submit');
	   
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
   
  /* if(tankId>0 && reservoirId==0 && hkey==1 && flaginf=="true" ){
	   
		//alert("i am 3");
		
		
	   updatetankdaminfo(formid);
	   
	   $("#daminfeditFlag").attr('value', false);
		  
		  $("#daminfupdate").attr('value', 'Edit');
		
	   
	
			
		}*/
		
	   if(tankId>0 && reservoirId==0 && hkey==2 && flaginf=="true"){
		   
		   //alert("i am 4");
		   
		  
			
		   updatetankImpControlinfo(formid);
		   
		   $("#damctrleditFlag").attr('value', false);
			  
			  $("#damcontrolinf").text( 'Edit');
			  
		   
			
			  
		}
	   
	  /* if( flaginf=="false" && tankId==0 && reservoirId>0 && hkey==1  ){
			
			//alert("i am 5");
				
			$('#typeOfDamId').prop("disabled", false); 
			  $('#ownerOfDam').prop("readonly", true); 
			  $('#damOperator').prop("readonly", true); 
			  $('#commisionDate').prop("readonly", false); 
			  $('#hazardClassId').prop("disabled", false); 
			  
			  $('#damPurposeId').attr("disabled", false);
			  $("#daminfeditFlag").attr('value', true);
			  
			  $("#dminfreservoirIddata").val(reservoirId);
			  
			  var ownerdam= $('#userdamunitName').val(); 
			  var damoperator= $('#userdamdivisionName').val(); 
			  $('#ownerOfDam').val(ownerdam); 
			  $('#damOperator').val(damoperator); 
			  
			  
			  
			  $("#daminfupdate").attr('value', 'Submit');
				
			}*/
			
		   if(tankId==0 && reservoirId>0 && hkey==2 && flaginf=="false"){
			   
			   
			   $('#typeOfDamId').prop("disabled", false); 
				 // $('#ownerOfDam').prop("readonly", true); 
				//  $('#damOperator').prop("readonly", true); 
				  $('#commisionDate').prop("readonly", false); 
				  $('#hazardClassId').prop("disabled", false); 
				  
				  $('#damPurposeId').attr("disabled", false);
				 // $("#daminfeditFlag").attr('value', true);
				  
				//  $("#dminfreservoirIddata").val(reservoirId);
				  
				 // var ownerdam= $('#userdamunitName').val(); 
				 // var damoperator= $('#userdamdivisionName').val(); 
				//  $('#ownerOfDam').val(ownerdam); 
				//  $('#damOperator').val(damoperator); 
			   
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
				  
				  $("#resLatitude").prop("readonly", false); 
				  
				  $("#resLongitude").prop("readonly", false); 
				  
				  $("#res_long_d").prop("readonly", false); 
				  
				  $("#res_long_m").prop("readonly", false); 
				  
				  $("#res_long_s").prop("readonly", false); 
				  
	              $("#res_lat_d").prop("readonly", false); 
				  
				  $("#res_lat_m").prop("readonly", false); 
				  
				  $("#res_lat_s").prop("readonly", false); 
				  
				  $("#dmctrlreservoirIddata").val(reservoirId);
				  
				  $("#damcontrolinf").text( 'Submit');
				  
			}
	   
	 /*   if(tankId==0 && reservoirId>0 && hkey==1 && flaginf=="true"){
		
	    	  // alert("i am 7");
	    	updateResdaminfo(formid);
	    	
	    	 $("#daminfeditFlag").attr('value', false);
			  
			  $("#daminfupdate").attr('value', 'Edit');
		
	}*/
	
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
	//  alert("mst1Id" +mst1Id);
	  
	  var tstatusId= $('#editdamStatusId').val(); 
	//  alert("tstatusId" +tstatusId); 
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

function deleteResInspectionDetails(resinspectInfoId){
	
//	alert("HI");
//	alert("capacityReviewId "+capacityReviewId+"capacityId "+capacityId+"tabId "+tabId);
	
	 $.ajax({	          
			url: "../invtsimis/delete-res-inspection-details" ,
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

function deleteanndata(annmst2inf,rescheckid){
	
	//alert("annmst2inf"+annmst2inf);
	 $.ajax({	          
			url: "../invtsimis/delete-annmst" ,
			method:"POST",
			dataType: 'json',

			async: false,
			data: {
				  
				resInspectMst2Id:annmst2inf,
				
				  
			},


			success: function (response) {

				  
				//  console.log(response);
				  
				if(response>0){

				  $('#action_alert').html('<p style="margin: 0px !important;">Data Deleted Successfully</p>');
				  $("html,body").animate({scrollTop:0}, 500);
				  
				
				  
				  getresmst2mst1byfreqyear(1);
				 
				  
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

function deleteRmarksReview(reviewId){
	
//	alert("HI");
//	alert("capacityReviewId "+capacityReviewId+"capacityId "+capacityId+"tabId "+tabId);
	
	 $.ajax({	          
			url: "../invtsimis/delete-reviewid" ,
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


function deleteResActionTakenDetails(resDamActionId){
	
//	alert("HI");
//	alert("capacityReviewId "+capacityReviewId+"capacityId "+capacityId+"tabId "+tabId);
	
	 $.ajax({	          
			url: "../invtsimis/delete_res_act_details" ,
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

function editRemarksReview(resRemarksMst1ReviewId){
	
	
	$.ajax({
		url : "../invtsimis/get-damremarks-review",
		type : "POST",
		data: {resRemarksMst1ReviewId :  resRemarksMst1ReviewId,
			 },
		success : function(response) {
			
			
			 var j=1;
				
				

				
			var obj = JSON.parse(response);

			
    	    	var damannRemarksMst1ReviewId=   obj[0].resRemarksMst1ReviewId;
    	    	
    	    	var resinspectInfoId=obj[0].resinspectInfoId;
    	    	
    	    	
    	    	
    	    	var remarksinclindoc=obj[0].remarksinclindoc;
    	    	
    	    	var  remarksremann1=obj[0].remarks
    	    	  
    	    	 
    	    	 $('#damremarkseditflag').val(true);
    	    	
    	    	$('#damannRemarksMst1ReviewId').val(damannRemarksMst1ReviewId);
    	    	
    	    	$('#reminspectOfficeInfoId').val(resinspectInfoId);
    	    	
    	    	$("#reminspectOfficeInfoId").multiselect('rebuild');
    	    	
    	    	if(remarksinclindoc==false){
    	    		
    	    		
    	    		$('#remarksinclindocn').attr("checked", true);
    	    		
    	    	}
    	    	
                     if(remarksinclindoc==true){
    	    		
    	    		
    	    		$('#remarksinclindocy').attr("checked", true);
    	    		
    	    	}
    	    
                     $('#remarksremann1').val(remarksremann1);
                     
                     
                     $('#damannareviewinfoid').text("Update Remarks");
				
                     
                     
			

		},
		error : function() {
			alert(error);
		}
	});
	
}


function handleMonsoonInfo(getinfoId){
	

	var valid = "Do you want to copy?";
	
	var id="#"+getinfoId;
	
	 //$("#previnfodata").hide();
	
	  if (confirm(valid)) { 
		  
	

	
	

	
	
//	alert("id"+id);
	
	var monsooncheck=$(id).prop('checked');
	
	//alert("monsooncheck"+monsooncheck);
	
	if(monsooncheck == true){
		
		  $(id).attr("disabled", true);
		
	/*	if(hkey==2){*/
		
   var nextPostId=$('#nextPostId').val();
		   
		   var nextEmpId=$('#nextEmpId').val();
			  
			  var h = new Date();
			  
			  var newyear =h.getFullYear();
			  
			  var dutyfreq=$('#dutyFrequencyId').val();
			  
			  var currentselectyear= $('#year').val();
			  
			if((newyear==currentselectyear) && dutyfreq==9 ){
				
				prevYear=currentselectyear-1;
				prevFreq=10;
			}else if ((newyear==currentselectyear) && dutyfreq==10){
				
				prevYear=currentselectyear;
				prevFreq= 9;
				
			}else if ((newyear==(currentselectyear+1))&& dutyfreq==10){
				
				prevYear=currentselectyear;
				prevFreq= 9;
			}else if ((newyear==(currentselectyear+1))&& dutyfreq==9){
				
				prevYear=currentselectyear-1;
				prevFreq= 10;
			}
			  
			  
			  
			 
				
			  reservoirId=$('#resId').val();
	
	
	
			  tankId=$('#tankId').val();
	
	//alert("tankId"+tankId);
			  
			
			  
			 
			  
	        conditionofDamId=$('#conditionofDamId').val();
	
	        postId=$('.mainpostId').val();
			  
			  
		  /*}*/
	        
	        
	    
	        
	        $.ajax({
	    		url : "../invtsimis/getprevmst2mst1byyearfreq",
	    		type : "POST",
	    		data: {year :  currentselectyear,
	    			tankId:tankId,
	    			dutyFrequencyId:dutyfreq,
	    			reservoirId:reservoirId,	    			
	        conditionofDamId:conditionofDamId,
	        postId:postId,
	        nextPostId:nextPostId,
	        nextEmpId:nextEmpId,
	        prevYear:prevYear,
	        prevFreq:prevFreq
	    			 },
	    		success : function(response) {
	    			
	    	
	    				

	    				
	    			var obj = JSON.parse(response);
	    			
	    			if(response>0){

	    			getresmst2mst1byfreqyear(1);
	    			getDamInspectioninfo();
	    			getResDamHealthDetails();
	    			getDamRemarksinfo();
	    			getDamInspectPhotosinfo()
	    			getResInspectioninfo();
	    			}
	        	    	
	                         
	    			

	    		},
	    		error : function() {
	    			alert(error);
	    		}
	    	});
		
		
      
   }
	
    /*if(monsooncheck == false){
		
		//alert("i am  not checked");
      
     }*/
	 return true;
	  
	  }
       else{
    	   
    	   $(id).prop('checked', false);
       	
       	return false;
         
       }
	
	
}




function handleRecomandationInfo(getinfoId){
	
	var id="#"+getinfoId;
	
	//alert("id"+id);
	
	var recommendcheck=$(id).prop('checked');
	
	//alert("Recommendationcheck"+recommendcheck);
	
	if(recommendcheck == true){
		
		  $(id).attr("disabled", true);
		
	/*	if(hkey==2){*/
		
   var nextPostId=$('#nextPostId').val();
		   
		   var nextEmpId=$('#nextEmpId').val();
			  
			  var h = new Date();
			  
			  var newyear =h.getFullYear();
			  
			  var dutyfreq=$('#dutyFrequencyId').val();
			  
			  var currentselectyear= $('#year').val();
			  
			if((newyear==currentselectyear) && dutyfreq==9 ){
				
				prevYear=currentselectyear-1;
				prevFreq=10;
			}else if ((newyear==currentselectyear) && dutyfreq==10){
				
				prevYear=currentselectyear;
				prevFreq= 9;
				
			}else if ((newyear==(currentselectyear+1))&& dutyfreq==10){
				
				prevYear=currentselectyear;
				prevFreq= 9;
			}else if ((newyear==(currentselectyear+1))&& dutyfreq==9){
				
				prevYear=currentselectyear-1;
				prevFreq= 10;
			}
			  
			  
			  
			 
				
			  reservoirId=$('#resId').val();
	
	
	
			  tankId=$('#tankId').val();
	
	//alert("tankId"+tankId);
			  
			
			  
			 
			  
	        conditionofDamId=$('#conditionofDamId').val();
	
	        postId=$('.mainpostId').val();
			  
			  
		  /*}*/
	        
	        
	    
	        
	        $.ajax({
	    		url : "../invtsimis/getprevrecommendmst1Id",
	    		type : "POST",
	    		data: {year :  currentselectyear,
	    			tankId:tankId,
	    			dutyFrequencyId:dutyfreq,
	    			reservoirId:reservoirId,	    			
	        conditionofDamId:conditionofDamId,
	        postId:postId,
	        nextPostId:nextPostId,
	        nextEmpId:nextEmpId,
	        prevYear:prevYear,
	        prevFreq:prevFreq
	    			 },
	    		success : function(response) {
	    			
	    	
	    				

	    				
	    			var obj = JSON.parse(response);
	    			
	    			if(response>0){

	    			getresmst2mst1byfreqyear(1);
	    			getDamInspectioninfo();
	    			getResDamHealthDetails();
	    			getDamRemarksinfo();
	    			getDamInspectPhotosinfo()
	    			getResInspectioninfo();
	    			}
	        	    	
	                         
	    			

	    		},
	    		error : function() {
	    			alert(error);
	    		}
	    	});
		
		
      
   }
	
    if(monsooncheck == false){
		
		//alert("i am  not checked");
      
     }
  
	
	
}

function getprevmonsoonData(){
	
	 var dutyFre= $("#dutyFrequencyId").val();
	   
	   var yeard= $('#year').val();
	   
	   var disign=$('#design').val();
	   var uid=$('#uid').val();
	   
	   var cid=$('#cid').val();
	   
	   var diid=$('#diid').val();
	  
	   var suid=$('#suid').val();
	  
	   if((yeard>0 && (dutyFre==9 || dutyFre==10 )) ){
			 
			
		 if((uid>0&&cid>0&&diid>0&&suid>0)&&(disign==2|| disign==8)){
			 
			if( $("#previnfodata").css('display') == 'none'	){
		 $("#previnfodata").show();
		 
		// $("#previnfodata").removeAttribute('style');
			}
		 }
		 
		 if((uid>0&&cid==0&&diid==0&&suid==0)&&(disign==5||disign==2|| disign==8 || disign==4 || disign==7|| disign==9|| disign==10)){
		 
			 if( $("#prevrecommenddata").css('display') == 'none'	){
		 $("#prevrecommenddata").show();
		 
		// $("#prevrecommenddata").removeAttribute('style');
			 }
		 }
		 
	   } 
	
	
}



$(function() {
	
	
	
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
	 
	 
	 
	
});


function saleditinfo9(tankId, reservoirId,formid, hkey ,flag){
	
	
	
	var flaginf= flag
	
	
	
   if(tankId>0 && reservoirId==0 && hkey==3 && flaginf=="false"){
	   
	   
	   
		
		$('#emergencyActionPlanPreparedId').attr("disabled", false); 
	
		  $('#emergencyActionShared').prop("readonly", false); 
		
		  
		  $("#damsalienteditFlag9").attr('value', true);
	
		  $("#salientchecksres9").text( 'Submit');
		  
	}
   
 
		
	   if(tankId>0 && reservoirId==0 && hkey==3 && flaginf=="true"){
		   
		 //  alert("i am 4");
		   
		  
			
		   updateTankSalientinfo9(formid);
		   
		   $("#damsalienteditFlag9").attr('value', false);
			  
			  $("#salientchecksres9").text( 'Edit');
			  
		   
			
			  
		}
	   
	  
			
		   if(tankId==0 && reservoirId>0 && hkey==3 && flaginf=="false"){
			   
			  // alert("i am in res")
			   
			   
			   $('#emergencyActionPlanPreparedId').prop("disabled", false); 
				
				  $('#emergencyActionShared').prop("readonly", false); 
				  $("#damsalienteditFlag9").attr('value', true);
				
			  
				  
				  $("#salientchecksres9").text( 'Submit');
				  
			}
	   
	
	
 if(tankId==0 && reservoirId>0 && hkey==3 && flaginf=="true"){
	 
	// alert("i am 8");
		
	 updateResSalientinfo9(formid);
	 
	   $("#damsalienteditFlag9").attr('value', false);
		  
		  $("#salientchecksres9").text( 'Edit');
		
	}
	
	
	
	
}



function updateResSalientinfo9(formId){
	
	
	var reservoirId= $("#dmsalientreservoirIddata9").val(); 
	
	var formId = formId		
	 
	 var customformid="#"+formId;

	
	$('#action_alert').empty();


		
		//alert("kal2 recommendatiion info");
		if ($('form[id='+formId+']').parsley()
				.isValid()) {		 
	    $.ajax({	          
	url: "../invtsimis/editResSalientInfo9" ,
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
		  
		  
		  resDamSalientLvlInfo(reservoirId );
		  
		  document.getElementById('salientcaptcha_id9').src = '../captcha3.jpg?' + Math.random();
		 // getResDamHealthDetails();
		  
		}if(response==-1){
			
			

			  $('#action_alert').html('<p style="margin: 0px !important;">please select Tank</p>');
			  $("html,body").animate({scrollTop:0}, 500);
			
			
		}if(response==0 || response==null){
			
			

			  $('#action_alert').html('<p style="margin: 0px !important;">Failed to Update</p>');
			  $("html,body").animate({scrollTop:0}, 500);
			
			
		}
		
if(response==-3){
    		
    		$('#action_alert').html('<p style="margin: 0px !important;">Please Enter the Captcha Text </p>'); 
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
		 }else {
				
				$('form[id='+formId+']').parsley().validate();
				//alert("kal4");
				
		} 
			

		
	
	
	
}


function updateTankSalientinfo9(formId){
	
	
	var tankId= $("#dmsalienttankdata9").val(); 
	
	var formId = formId		
	 
	 var customformid="#"+formId;

	
	$('#action_alert').empty();


		
		//alert("kal2 recommendatiion info");
		if ($('form[id='+formId+']').parsley()
				.isValid()) {		 
	    $.ajax({	          
	url: "../invtsimis/editTankSalientInfo9" ,
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
		  
		  
		  tankSalientLvlInfo(tankId );
		  
		  document.getElementById('salientcaptcha_id9').src = '../captcha3.jpg?' + Math.random();
		 // getResDamHealthDetails();
		  
		}if(response==-1){
			
			

			  $('#action_alert').html('<p style="margin: 0px !important;">please select Tank</p>');
			  $("html,body").animate({scrollTop:0}, 500);
			
			
		}if(response==0 || response==null){
			
			

			  $('#action_alert').html('<p style="margin: 0px !important;">Failed to Update</p>');
			  $("html,body").animate({scrollTop:0}, 500);
			
			
		}
		
if(response==-3){
    		
    		$('#action_alert').html('<p style="margin: 0px !important;">Please Enter the Captcha Text </p>'); 
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
		 }else {
				
				$('form[id='+formId+']').parsley().validate();
				//alert("kal4");
				
		} 
			

		
	
	
	
}


function saleditinfo8(tankId, reservoirId,formid, hkey ,flag){
	
	
	
	var flaginf= flag
	
	
	
   if(tankId>0 && reservoirId==0 && hkey==3 && flaginf=="false"){
	   
	   
	   
		
		$('#damBreakAnalysisId').attr("disabled", false); 
	
		  $('#disaster_manage_prepared').prop("readonly", false); 
		
		  
		  $("#damsalienteditFlag8").attr('value', true);
	
		  $("#salientchecksres8").text( 'Submit');
		  
	}
   
 
		
	   if(tankId>0 && reservoirId==0 && hkey==3 && flaginf=="true"){
		   
		 //  alert("i am 4");
		   
		  
			
		   updateTankSalientinfo8(formid);
		   
		   $("#damsalienteditFlag8").attr('value', false);
			  
			  $("#salientchecksres8").text( 'Edit');
			  
		   
			
			  
		}
	   
	  
			
		   if(tankId==0 && reservoirId>0 && hkey==3 && flaginf=="false"){
			   
			  // alert("i am in res")
			   
			   
			   $('#damBreakAnalysisId').prop("disabled", false); 
				
				  $('#disaster_manage_prepared').prop("readonly", false); 
				  $("#damsalienteditFlag8").attr('value', true);
				
			  
				  
				  $("#salientchecksres8").text( 'Submit');
				  
			}
	   
	
	
 if(tankId==0 && reservoirId>0 && hkey==3 && flaginf=="true"){
	 
	// alert("i am 8");
		
	 updateResSalientinfo8(formid);
	 
	   $("#damsalienteditFlag8").attr('value', false);
		  
		  $("#salientchecksres8").text( 'Edit');
		
	}
	
	
	
	
}



function updateResSalientinfo8(formId){
	
	
	var reservoirId= $("#dmsalientreservoirIddata8").val(); 
	
	var formId = formId		
	 
	 var customformid="#"+formId;

	
	$('#action_alert').empty();


		
		//alert("kal2 recommendatiion info");
		if ($('form[id='+formId+']').parsley()
				.isValid()) {		 
	    $.ajax({	          
	url: "../invtsimis/editResSalientInfo8" ,
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
		  
		  
		  resDamSalientLvlInfo(reservoirId );
		  
		  document.getElementById('salientcaptcha_id8').src = '../captcha3.jpg?' + Math.random();
		 // getResDamHealthDetails();
		  
		}if(response==-1){
			
			

			  $('#action_alert').html('<p style="margin: 0px !important;">please select Tank</p>');
			  $("html,body").animate({scrollTop:0}, 500);
			
			
		}if(response==0 || response==null){
			
			

			  $('#action_alert').html('<p style="margin: 0px !important;">Failed to Update</p>');
			  $("html,body").animate({scrollTop:0}, 500);
			
			
		}
		
if(response==-3){
    		
    		$('#action_alert').html('<p style="margin: 0px !important;">Please Enter the Captcha Text </p>'); 
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
		 }else {
				
				$('form[id='+formId+']').parsley().validate();
				//alert("kal4");
				
		} 
			

		
	
	
	
}

function updateTankSalientinfo8(formId){
	
	
	var tankId= $("#dmsalienttankdata8").val(); 
	
	var formId = formId		
	 
	 var customformid="#"+formId;

	
	$('#action_alert').empty();


		
		//alert("kal2 recommendatiion info");
		if ($('form[id='+formId+']').parsley()
				.isValid()) {		 
	    $.ajax({	          
	url: "../invtsimis/editTankSalientInfo8" ,
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
		  
		  
		  tankSalientLvlInfo(tankId );
		  
		  document.getElementById('salientcaptcha_id8').src = '../captcha3.jpg?' + Math.random();
		 // getResDamHealthDetails();
		  
		}if(response==-1){
			
			

			  $('#action_alert').html('<p style="margin: 0px !important;">please select Tank</p>');
			  $("html,body").animate({scrollTop:0}, 500);
			
			
		}if(response==0 || response==null){
			
			

			  $('#action_alert').html('<p style="margin: 0px !important;">Failed to Update</p>');
			  $("html,body").animate({scrollTop:0}, 500);
			
			
		}
		
if(response==-3){
    		
    		$('#action_alert').html('<p style="margin: 0px !important;">Please Enter the Captcha Text </p>'); 
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
		 }else {
				
				$('form[id='+formId+']').parsley().validate();
				//alert("kal4");
				
		} 
			

		
	
	
	
}



function saleditinfo7(tankId, reservoirId,formid, hkey ,flag){
	
	
	
	var flaginf= flag
	
	
	
   if(tankId>0 && reservoirId==0 && hkey==3 && flaginf=="false"){
	   
	   
	   
		
		$('#structuralSafetyPerformedId').attr("disabled", false); 
	
		  $('#damFoundSafe').prop("readonly", false); 
		  $('#damRetrofitStatus').prop("readonly", false); 
		  $('#damRetrofitTime').prop("readonly", false); 
		  $('#damretrofitMeausreAdopted').prop("readonly", false); 
		
		  
		  $("#damsalienteditFlag7").attr('value', true);
	
		  $("#salientchecksres7").text( 'Submit');
		  
	}
   
 
		
	   if(tankId>0 && reservoirId==0 && hkey==3 && flaginf=="true"){
		   
		 //  alert("i am 4");
		   
		  
			
		   updateTankSalientinfo7(formid);
		   
		   $("#damsalienteditFlag7").attr('value', false);
			  
			  $("#salientchecksres7").text( 'Edit');
			  
		   
			
			  
		}
	   
	  
			
		   if(tankId==0 && reservoirId>0 && hkey==3 && flaginf=="false"){
			   
			  // alert("i am in res")
			   
			   
			   $('#structuralSafetyPerformedId').prop("disabled", false); 
				
				  $('#damFoundSafe').prop("readonly", false); 
				  $('#damRetrofitStatus').prop("readonly", false); 
				  $('#damRetrofitTime').prop("readonly", false); 
				  $('#damretrofitMeausreAdopted').prop("readonly", false); 
				  $("#damsalienteditFlag7").attr('value', true);
				
			  
				  
				  $("#salientchecksres7").text( 'Submit');
				  
			}
	   
	
	
 if(tankId==0 && reservoirId>0 && hkey==3 && flaginf=="true"){
	 
	// alert("i am 8");
		
	 updateResSalientinfo7(formid);
	 
	   $("#damsalienteditFlag7").attr('value', false);
		  
		  $("#salientchecksres7").text( 'Edit');
		
	}
	
	
	
	
}



function updateResSalientinfo7(formId){
	
	
	var reservoirId= $("#dmsalientreservoirIddata7").val(); 
	
	var formId = formId		
	 
	 var customformid="#"+formId;

	
	$('#action_alert').empty();


		
		//alert("kal2 recommendatiion info");
		if ($('form[id='+formId+']').parsley()
				.isValid()) {		 
	    $.ajax({	          
	url: "../invtsimis/editResSalientInfo7" ,
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
		  
		  
		  resDamSalientLvlInfo(reservoirId );
		  
		  document.getElementById('salientcaptcha_id7').src = '../captcha3.jpg?' + Math.random();
		 // getResDamHealthDetails();
		  
		}if(response==-1){
			
			

			  $('#action_alert').html('<p style="margin: 0px !important;">please select Tank</p>');
			  $("html,body").animate({scrollTop:0}, 500);
			
			
		}if(response==0 || response==null){
			
			

			  $('#action_alert').html('<p style="margin: 0px !important;">Failed to Update</p>');
			  $("html,body").animate({scrollTop:0}, 500);
			
			
		}
		
if(response==-3){
    		
    		$('#action_alert').html('<p style="margin: 0px !important;">Please Enter the Captcha Text </p>'); 
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
		 }else {
				
				$('form[id='+formId+']').parsley().validate();
				//alert("kal4");
				
		} 
			

		
	
	
	
}

function updateTankSalientinfo7(formId){
	
	
	var tankId= $("#dmsalienttankdata7").val(); 
	
	var formId = formId		
	 
	 var customformid="#"+formId;

	
	$('#action_alert').empty();


		
		//alert("kal2 recommendatiion info");
		if ($('form[id='+formId+']').parsley()
				.isValid()) {		 
	    $.ajax({	          
	url: "../invtsimis/editTankSalientInfo7" ,
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
		  
		  
		  tankSalientLvlInfo(tankId );
		  
		  document.getElementById('salientcaptcha_id7').src = '../captcha3.jpg?' + Math.random();
		 // getResDamHealthDetails();
		  
		}if(response==-1){
			
			

			  $('#action_alert').html('<p style="margin: 0px !important;">please select Tank</p>');
			  $("html,body").animate({scrollTop:0}, 500);
			
			
		}if(response==0 || response==null){
			
			

			  $('#action_alert').html('<p style="margin: 0px !important;">Failed to Update</p>');
			  $("html,body").animate({scrollTop:0}, 500);
			
			
		}
		
if(response==-3){
    		
    		$('#action_alert').html('<p style="margin: 0px !important;">Please Enter the Captcha Text </p>'); 
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
		 }else {
				
				$('form[id='+formId+']').parsley().validate();
				//alert("kal4");
				
		} 
			

		
	
	
	
}



function saleditinfo5(tankId, reservoirId,formid, hkey ,flag){
	
	
	
	var flaginf= flag
	
	
	
   if(tankId>0 && reservoirId==0 && hkey==3 && flaginf=="false"){
	   
	   
	   
		
		$('#reservoirSiltedId').attr("disabled", false); 
	
		  $('#lostPercentageReservoirCapacity').prop("readonly", false); 
		  $('#peakWaterLeakage').prop("readonly", false); 
		
		
		  
		  $("#damsalienteditFlag5").attr('value', true);
	
		  $("#salientchecksres5").text( 'Submit');
		  
	}
   
 
		
	   if(tankId>0 && reservoirId==0 && hkey==3 && flaginf=="true"){
		   
		 //  alert("i am 4");
		   
		  
			
		   updateTankSalientinfo5(formid);
		   
		   $("#damsalienteditFlag5").attr('value', false);
			  
			  $("#salientchecksres5").text( 'Edit');
			  
		   
			
			  
		}
	   
	  
			
		   if(tankId==0 && reservoirId>0 && hkey==3 && flaginf=="false"){
			   
			  // alert("i am in res")
			   
			   
			   $('#reservoirSiltedId').prop("disabled", false); 
				
			   $('#lostPercentageReservoirCapacity').prop("readonly", false); 
				  $('#peakWaterLeakage').prop("readonly", false);
				
				  $("#damsalienteditFlag5").attr('value', true);
				
			  
				  
				  $("#salientchecksres5").text( 'Submit');
				  
			}
	   
	
	
 if(tankId==0 && reservoirId>0 && hkey==3 && flaginf=="true"){
	 
	// alert("i am 8");
		
	 updateResSalientinfo5(formid);
	 
	   $("#damsalienteditFlag5").attr('value', false);
		  
		  $("#salientchecksres5").text( 'Edit');
		
	}
	
	
	
	
}



function updateResSalientinfo5(formId){
	
	
	var reservoirId= $("#dmsalientreservoirIddata5").val(); 
	
	var formId = formId		
	 
	 var customformid="#"+formId;

	
	$('#action_alert').empty();


		
		//alert("kal2 recommendatiion info");
		if ($('form[id='+formId+']').parsley()
				.isValid()) {		 
	    $.ajax({	          
	url: "../invtsimis/editResSalientInfo5" ,
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
		  
		  
		  resDamSalientLvlInfo(reservoirId );
		  
		  document.getElementById('salientcaptcha_id5').src = '../captcha3.jpg?' + Math.random();
		 // getResDamHealthDetails();
		  
		}if(response==-1){
			
			

			  $('#action_alert').html('<p style="margin: 0px !important;">please select Tank</p>');
			  $("html,body").animate({scrollTop:0}, 500);
			
			
		}if(response==0 || response==null){
			
			

			  $('#action_alert').html('<p style="margin: 0px !important;">Failed to Update</p>');
			  $("html,body").animate({scrollTop:0}, 500);
			
			
		}
		
if(response==-3){
    		
    		$('#action_alert').html('<p style="margin: 0px !important;">Please Enter the Captcha Text </p>'); 
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
		 }else {
				
				$('form[id='+formId+']').parsley().validate();
				//alert("kal4");
				
		} 
			

		
	
	
	
}


function updateTankSalientinfo5(formId){
	
	
	var tankId= $("#dmsalienttankdata5").val(); 
	
	var formId = formId		
	 
	 var customformid="#"+formId;

	
	$('#action_alert').empty();


		
		//alert("kal2 recommendatiion info");
		if ($('form[id='+formId+']').parsley()
				.isValid()) {		 
	    $.ajax({	          
	url: "../invtsimis/editTankSalientInfo5" ,
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
		  
		  
		  tankSalientLvlInfo(tankId );
		  
		  document.getElementById('salientcaptcha_id5').src = '../captcha3.jpg?' + Math.random();
		 // getResDamHealthDetails();
		  
		}if(response==-1){
			
			

			  $('#action_alert').html('<p style="margin: 0px !important;">please select Tank</p>');
			  $("html,body").animate({scrollTop:0}, 500);
			
			
		}if(response==0 || response==null){
			
			

			  $('#action_alert').html('<p style="margin: 0px !important;">Failed to Update</p>');
			  $("html,body").animate({scrollTop:0}, 500);
			
			
		}
		
if(response==-3){
    		
    		$('#action_alert').html('<p style="margin: 0px !important;">Please Enter the Captcha Text </p>'); 
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
		 }else {
				
				$('form[id='+formId+']').parsley().validate();
				//alert("kal4");
				
		} 
			

		
	
	
	
}


function saleditinfo4(tankId, reservoirId,formid, hkey ,flag){
	
	
	
	var flaginf= flag
	
	
	
   if(tankId>0 && reservoirId==0 && hkey==3 && flaginf=="false"){
	   
	   
	   
		
		$('#OanMManualPreparedId').attr("disabled", false); 
	
		  $('#OanMManualPreparedTime').prop("readonly", false); 
		
		
		
		  
		  $("#damsalienteditFlag4").attr('value', true);
	
		  $("#salientchecksres4").text( 'Submit');
		  
	}
   
 
		
	   if(tankId>0 && reservoirId==0 && hkey==3 && flaginf=="true"){
		   
		 //  alert("i am 4");
		   
		  
			
		   updateTankSalientinfo4(formid);
		   
		   $("#damsalienteditFlag4").attr('value', false);
			  
			  $("#salientchecksres4").text( 'Edit');
			  
		   
			
			  
		}
	   
	  
			
		   if(tankId==0 && reservoirId>0 && hkey==3 && flaginf=="false"){
			   
			  // alert("i am in res")
			   
			   
			   $('#OanMManualPreparedId').attr("disabled", false); 
				
				  $('#OanMManualPreparedTime').prop("readonly", false); 
				
				
				  $("#damsalienteditFlag4").attr('value', true);
				
			  
				  
				  $("#salientchecksres4").text( 'Submit');
				  
			}
	   
	
	
 if(tankId==0 && reservoirId>0 && hkey==3 && flaginf=="true"){
	 
	// alert("i am 8");
		
	 updateResSalientinfo4(formid);
	 
	   $("#damsalienteditFlag4").attr('value', false);
		  
		  $("#salientchecksres4").text( 'Edit');
		
	}
	
	
	
	
}



function updateResSalientinfo4(formId){
	
	
	var reservoirId= $("#dmsalientreservoirIddata4").val(); 
	
	var formId = formId		
	 
	 var customformid="#"+formId;

	
	$('#action_alert').empty();


		
		//alert("kal2 recommendatiion info");
		if ($('form[id='+formId+']').parsley()
				.isValid()) {		 
	    $.ajax({	          
	url: "../invtsimis/editResSalientInfo4" ,
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
		  
		  
		  resDamSalientLvlInfo(reservoirId );
		  
		  document.getElementById('salientcaptcha_id4').src = '../captcha3.jpg?' + Math.random();
		 // getResDamHealthDetails();
		  
		}if(response==-1){
			
			

			  $('#action_alert').html('<p style="margin: 0px !important;">please select Tank</p>');
			  $("html,body").animate({scrollTop:0}, 500);
			
			
		}if(response==0 || response==null){
			
			

			  $('#action_alert').html('<p style="margin: 0px !important;">Failed to Update</p>');
			  $("html,body").animate({scrollTop:0}, 500);
			
			
		}
		
if(response==-3){
    		
    		$('#action_alert').html('<p style="margin: 0px !important;">Please Enter the Captcha Text </p>'); 
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
		 }else {
				
				$('form[id='+formId+']').parsley().validate();
				//alert("kal4");
				
		} 
			

		
	
	
	
}

function updateTankSalientinfo4(formId){
	
	
	var tankId= $("#dmsalienttankdata4").val(); 
	
	var formId = formId		
	 
	 var customformid="#"+formId;

	
	$('#action_alert').empty();


		
		//alert("kal2 recommendatiion info");
		if ($('form[id='+formId+']').parsley()
				.isValid()) {		 
	    $.ajax({	          
	url: "../invtsimis/editTankSalientInfo4" ,
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
		  
		  
		  tankSalientLvlInfo(tankId );
		  
		  document.getElementById('salientcaptcha_id4').src = '../captcha3.jpg?' + Math.random();
		 // getResDamHealthDetails();
		  
		}if(response==-1){
			
			

			  $('#action_alert').html('<p style="margin: 0px !important;">please select Tank</p>');
			  $("html,body").animate({scrollTop:0}, 500);
			
			
		}if(response==0 || response==null){
			
			

			  $('#action_alert').html('<p style="margin: 0px !important;">Failed to Update</p>');
			  $("html,body").animate({scrollTop:0}, 500);
			
			
		}
		
if(response==-3){
    		
    		$('#action_alert').html('<p style="margin: 0px !important;">Please Enter the Captcha Text </p>'); 
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
		 }else {
				
				$('form[id='+formId+']').parsley().validate();
				//alert("kal4");
				
		} 
			

		
	
	
	
}


function saleditinfo3(tankId, reservoirId,formid, hkey ,flag){
	
	
	
	var flaginf= flag
	
	
	
   if(tankId>0 && reservoirId==0 && hkey==3 && flaginf=="false"){
	   
	   
	   
		
		$('#gateOperationMethodId').attr("disabled", false); 
	
		  $('#resgatesize').prop("readonly", false);
		  
		  $('#resgatenumber').prop("readonly", false); 
		  
		  $('#damGateNumberFine').prop("readonly", false); 
		
		
		
		  
		  $("#damsalienteditFlag3").attr('value', true);
	
		  $("#salientchecksres3").text( 'Submit');
		  
	}
   
 
		
	   if(tankId>0 && reservoirId==0 && hkey==3 && flaginf=="true"){
		   
		 //  alert("i am 4");
		   
		  
			
		   updateTankSalientinfo3(formid);
		   
		   $("#damsalienteditFlag3").attr('value', false);
			  
			  $("#salientchecksres3").text( 'Edit');
			  
		   
			
			  
		}
	   
	  
			
		   if(tankId==0 && reservoirId>0 && hkey==3 && flaginf=="false"){
			   
			  // alert("i am in res")
			   
			   
				
				$('#gateOperationMethodId').attr("disabled", false); 
			
				  $('#resgatesize').prop("readonly", false);
				  
				  $('#resgatenumber').prop("readonly", false); 
				  
				  $('#damGateNumberFine').prop("readonly", false); 
				
				  $("#damsalienteditFlag3").attr('value', true);
				
			  
				  
				  $("#salientchecksres3").text( 'Submit');
				  
			}
	   
	
	
 if(tankId==0 && reservoirId>0 && hkey==3 && flaginf=="true"){
	 
	// alert("i am 8");
		
	 updateResSalientinfo3(formid);
	 
	   $("#damsalienteditFlag3").attr('value', false);
		  
		  $("#salientchecksres3").text( 'Edit');
		
	}
	
	
	
	
}



function updateResSalientinfo3(formId){
	
	
	var reservoirId= $("#dmsalientreservoirIddata3").val(); 
	
	var formId = formId		
	 
	 var customformid="#"+formId;

	
	$('#action_alert').empty();


		
		//alert("kal2 recommendatiion info");
		if ($('form[id='+formId+']').parsley()
				.isValid()) {		 
	    $.ajax({	          
	url: "../invtsimis/editResSalientInfo3" ,
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
		  
		  
		  resDamSalientLvlInfo(reservoirId );
		  
		  document.getElementById('salientcaptcha_id3').src = '../captcha3.jpg?' + Math.random();
		 // getResDamHealthDetails();
		  
		}if(response==-1){
			
			

			  $('#action_alert').html('<p style="margin: 0px !important;">please select Tank</p>');
			  $("html,body").animate({scrollTop:0}, 500);
			
			
		}if(response==0 || response==null){
			
			

			  $('#action_alert').html('<p style="margin: 0px !important;">Failed to Update</p>');
			  $("html,body").animate({scrollTop:0}, 500);
			
			
		}
		
if(response==-3){
    		
    		$('#action_alert').html('<p style="margin: 0px !important;">Please Enter the Captcha Text </p>'); 
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
		 }else {
				
				$('form[id='+formId+']').parsley().validate();
				//alert("kal4");
				
		} 
			

		
	
	
	
}


function updateTankSalientinfo3(formId){
	
	
	var tankId= $("#dmsalienttankdata3").val(); 
	
	var formId = formId		
	 
	 var customformid="#"+formId;

	
	$('#action_alert').empty();


		
		//alert("kal2 recommendatiion info");
		if ($('form[id='+formId+']').parsley()
				.isValid()) {		 
	    $.ajax({	          
	url: "../invtsimis/editTankSalientInfo3" ,
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
		  
		  
		  tankSalientLvlInfo(tankId );
		  
		  document.getElementById('salientcaptcha_id3').src = '../captcha3.jpg?' + Math.random();
		 // getResDamHealthDetails();
		  
		}if(response==-1){
			
			

			  $('#action_alert').html('<p style="margin: 0px !important;">please select Tank</p>');
			  $("html,body").animate({scrollTop:0}, 500);
			
			
		}if(response==0 || response==null){
			
			

			  $('#action_alert').html('<p style="margin: 0px !important;">Failed to Update</p>');
			  $("html,body").animate({scrollTop:0}, 500);
			
			
		}
		
if(response==-3){
    		
    		$('#action_alert').html('<p style="margin: 0px !important;">Please Enter the Captcha Text </p>'); 
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
		 }else {
				
				$('form[id='+formId+']').parsley().validate();
				//alert("kal4");
				
		} 
			

		
	
	
	
}


function saleditinfo2(tankId, reservoirId,formid, hkey ,flag){
	
	
	
	var flaginf= flag
	
	
	
   if(tankId>0 && reservoirId==0 && hkey==3 && flaginf=="false"){
	   
	   
	   
		
		$('#damGalleryNumber').attr("readonly", false); 
	
		  $('#galleryElevation').prop("readonly", false);
		  
		  $('#GalleryDryStatus').prop("readonly", false); 
		
		
		
		  
		  $("#damsalienteditFlag2").attr('value', true);
	
		  $("#salientchecksres2").text( 'Submit');
		  
	}
   
 
		
	   if(tankId>0 && reservoirId==0 && hkey==3 && flaginf=="true"){
		   
		 //  alert("i am 4");
		   
		  
			
		   updateTankSalientinfo2(formid);
		   
		   $("#damsalienteditFlag2").attr('value', false);
			  
			  $("#salientchecksres2").text( 'Edit');
			  
		   
			
			  
		}
	   
	  
			
		   if(tankId==0 && reservoirId>0 && hkey==3 && flaginf=="false"){
			   
			  // alert("i am in res")
			   
			   
				
			   $('#damGalleryNumber').attr("readonly", false); 
				
				  $('#galleryElevation').prop("readonly", false);
				  
				  $('#GalleryDryStatus').prop("readonly", false); 
				  $("#damsalienteditFlag2").attr('value', true);
				
			  
				  
				  $("#salientchecksres2").text( 'Submit');
				  
			}
	   
	
	
 if(tankId==0 && reservoirId>0 && hkey==3 && flaginf=="true"){
	 
	// alert("i am 8");
		
	 updateResSalientinfo2(formid);
	 
	   $("#damsalienteditFlag2").attr('value', false);
		  
		  $("#salientchecksres2").text( 'Edit');
		
	}
	
	
	
	
}



function updateResSalientinfo2(formId){
	
	
	var reservoirId= $("#dmsalientreservoirIddata2").val(); 
	
	var formId = formId		
	 
	 var customformid="#"+formId;

	
	$('#action_alert').empty();


		
		//alert("kal2 recommendatiion info");
		if ($('form[id='+formId+']').parsley()
				.isValid()) {		 
	    $.ajax({	          
	url: "../invtsimis/editResSalientInfo2" ,
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
		  
		  
		  resDamSalientLvlInfo(reservoirId );
		  
		  document.getElementById('salientcaptcha_id2').src = '../captcha3.jpg?' + Math.random();
		 // getResDamHealthDetails();
		  
		}if(response==-1){
			
			

			  $('#action_alert').html('<p style="margin: 0px !important;">please select Tank</p>');
			  $("html,body").animate({scrollTop:0}, 500);
			
			
		}if(response==0 || response==null){
			
			

			  $('#action_alert').html('<p style="margin: 0px !important;">Failed to Update</p>');
			  $("html,body").animate({scrollTop:0}, 500);
			
			
		}
		
if(response==-3){
    		
    		$('#action_alert').html('<p style="margin: 0px !important;">Please Enter the Captcha Text </p>'); 
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
		 }else {
				
				$('form[id='+formId+']').parsley().validate();
				//alert("kal4");
				
		} 
			

		
	
	
	
}

function updateTankSalientinfo2(formId){
	
	
	var tankId= $("#dmsalienttankdata2").val(); 
	
	var formId = formId		
	 
	 var customformid="#"+formId;

	
	$('#action_alert').empty();


		
		//alert("kal2 recommendatiion info");
		if ($('form[id='+formId+']').parsley()
				.isValid()) {		 
	    $.ajax({	          
	url: "../invtsimis/editTankSalientInfo2" ,
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
		  
		  
		  tankSalientLvlInfo(tankId );
		  
		  document.getElementById('salientcaptcha_id2').src = '../captcha3.jpg?' + Math.random();
		 // getResDamHealthDetails();
		  
		}if(response==-1){
			
			

			  $('#action_alert').html('<p style="margin: 0px !important;">please select Tank</p>');
			  $("html,body").animate({scrollTop:0}, 500);
			
			
		}if(response==0 || response==null){
			
			

			  $('#action_alert').html('<p style="margin: 0px !important;">Failed to Update</p>');
			  $("html,body").animate({scrollTop:0}, 500);
			
			
		}
		
if(response==-3){
    		
    		$('#action_alert').html('<p style="margin: 0px !important;">Please Enter the Captcha Text </p>'); 
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
		 }else {
				
				$('form[id='+formId+']').parsley().validate();
				//alert("kal4");
				
		} 
			

		
	
	
	
}



function saleditinfo1(tankId, reservoirId,formid, hkey ,flag){
	
	
	
	var flaginf= flag
	
	
	
   if(tankId>0 && reservoirId==0 && hkey==3 && flaginf=="false"){
	   
	   
	   
		
		$('#salientheightdfl').attr("readonly", false); 
	
		  $('#salientlengthcrest').prop("readonly", false);
		  
		  $('#salientbottomwidth').prop("readonly", false); 
		  
		  $('#salienttopwidth').prop("readonly", false); 
		  
		  $('#grossCapacityMwl').prop("readonly", false); 
		  
		  $('#capacitydeadstorage').prop("readonly", false); 
		  
		  $('#capacityactivestorage').prop("readonly", false);
		  
		  $('#mfddesignflood').prop("readonly", false);
		  $('#mfdobservedflood').prop("readonly", false);
		  
		  $('#specialDifficultFoundationIssues').prop("readonly", false);
		  
		  $('#unusualDamDesignId').prop("disabled", false);
		  
		  $('#unusualDamDesigndetails').prop("readonly", false);
		
		  
		
		  
		  $("#damsalienteditFlag1").attr('value', true);
	
		  $("#salientchecksres1").text( 'Submit');
		  
	}
   
 
		
	   if(tankId>0 && reservoirId==0 && hkey==3 && flaginf=="true"){
		   
		 //  alert("i am 4");
		   
		  
			
		   updateTankSalientinfo1(formid);
		   
		   $("#damsalienteditFlag1").attr('value', false);
			  
			  $("#salientchecksres1").text( 'Edit');
			  
		   
			
			  
		}
	   
	  
			
		   if(tankId==0 && reservoirId>0 && hkey==3 && flaginf=="false"){
			   
			  // alert("i am in res")
			   
			   
				
			   $('#salientheightdfl').attr("readonly", false); 
				
				  $('#salientlengthcrest').prop("readonly", false);
				  
				  $('#salientbottomwidth').prop("readonly", false); 
				  
				  $('#salienttopwidth').prop("readonly", false); 
				  
				  $('#grossCapacityMwl').prop("readonly", false); 
				  
				  $('#capacitydeadstorage').prop("readonly", false); 
				  
				  $('#capacityactivestorage').prop("readonly", false);
				  
				  $('#mfddesignflood').prop("readonly", false);
				  $('#mfdobservedflood').prop("readonly", false);
				  
				  $('#specialDifficultFoundationIssues').prop("readonly", false);
				  
				  $('#unusualDamDesignId').prop("disabled", false);
				  
				  $('#unusualDamDesigndetails').prop("readonly", false);
				  $("#damsalienteditFlag1").attr('value', true);
				
			  
				  
				  $("#salientchecksres1").text( 'Submit');
				  
			}
	   
	
	
 if(tankId==0 && reservoirId>0 && hkey==3 && flaginf=="true"){
	 
	// alert("i am 8");
		
	 updateResSalientinfo1(formid);
	 
	   $("#damsalienteditFlag1").attr('value', false);
		  
		  $("#salientchecksres1").text( 'Edit');
		
	}
	
	
	
	
}



function updateResSalientinfo1(formId){
	
	
	var reservoirId= $("#dmsalientreservoirIddata1").val(); 
	
	var formId = formId		
	 
	 var customformid="#"+formId;

	
	$('#action_alert').empty();


		
		//alert("kal2 recommendatiion info");
		if ($('form[id='+formId+']').parsley()
				.isValid()) {		 
	    $.ajax({	          
	url: "../invtsimis/editResSalientInfo1" ,
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
		  
		  
		  resDamSalientLvlInfo(reservoirId );
		  
		  document.getElementById('salientcaptcha_id1').src = '../captcha3.jpg?' + Math.random();
		 // getResDamHealthDetails();
		  
		}if(response==-1){
			
			

			  $('#action_alert').html('<p style="margin: 0px !important;">please select Tank</p>');
			  $("html,body").animate({scrollTop:0}, 500);
			
			
		}if(response==0 || response==null){
			
			

			  $('#action_alert').html('<p style="margin: 0px !important;">Failed to Update</p>');
			  $("html,body").animate({scrollTop:0}, 500);
			
			
		}
		
if(response==-3){
    		
    		$('#action_alert').html('<p style="margin: 0px !important;">Please Enter the Captcha Text </p>'); 
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
		 }else {
				
				$('form[id='+formId+']').parsley().validate();
				//alert("kal4");
				
		} 
			

		
	
	
	
}


function updateTankSalientinfo1(formId){
	
	
	var tankId= $("#dmsalienttankdata1").val(); 
	
	var formId = formId		
	 
	 var customformid="#"+formId;

	
	$('#action_alert').empty();


		
		//alert("kal2 recommendatiion info");
		if ($('form[id='+formId+']').parsley()
				.isValid()) {		 
	    $.ajax({	          
	url: "../invtsimis/editTankSalientInfo1" ,
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
		  
		  
		  tankSalientLvlInfo(tankId );
		  
		  document.getElementById('salientcaptcha_id1').src = '../captcha3.jpg?' + Math.random();
		 // getResDamHealthDetails();
		  
		}if(response==-1){
			
			

			  $('#action_alert').html('<p style="margin: 0px !important;">please select Tank</p>');
			  $("html,body").animate({scrollTop:0}, 500);
			
			
		}if(response==0 || response==null){
			
			

			  $('#action_alert').html('<p style="margin: 0px !important;">Failed to Update</p>');
			  $("html,body").animate({scrollTop:0}, 500);
			
			
		}
		
if(response==-3){
    		
    		$('#action_alert').html('<p style="margin: 0px !important;">Please Enter the Captcha Text </p>'); 
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
		 }else {
				
				$('form[id='+formId+']').parsley().validate();
				//alert("kal4");
				
		} 
			

		
	
	
	
}



	//end of nrld functions