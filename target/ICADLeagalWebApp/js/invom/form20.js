


$(document).ready(function(){
	
	//$("#nextPostId").('select>option:eq(1)').prop('selected', true);
	// $("#nextPostId").val($("#nextPostId option:first").val());
	
	/*
	 var d = new Date();
	  var e=new Date();
	
	// e= e.getFullYear() ;
	
   for (var i = 1; i >= 1; i--) {
	   
	  var dataval=parseInt(e);
	  // alert("dataval"+dataval);
	   $('#year').val(dataval);
 	
       var option = '<option value="'+dataval+'" selected="selected" >'+dataval+'</option>'
      // alert(option);
       
      
       $('#year').multiselect('rebuild');
       e++;
      // j++;
       
   }
   */
   var today = new Date();
   var currentYear = today.getFullYear();
   var currentMonth = today.getMonth() + 1; // January = 0

   var $year = $("#year");
   $year.empty(); // Clear existing options

   $year.append('<option value="">--select--</option>');

   // If month is Jan–June → show previous + current year
   if (currentMonth <= 6) {
       $year.append('<option value="' + (currentYear - 1) + '">' + (currentYear - 1) + '</option>');
   }

   // Always show current year
   $year.append('<option value="' + currentYear + '">' + currentYear + '</option>');

   // If using bootstrap multiselect
   $year.multiselect('rebuild');
   
   
	
		 
	
	
	
	
	$('#nextEmpId').multiselect({
		 
		 enableCaseInsensitiveFiltering: true
		 
	});
	
	

	
	
	
	
	
	
	$('#damageType').multiselect({
		 
		 enableCaseInsensitiveFiltering: true
		 
	});
	
	$('#canalId').multiselect({
		 
		 enableCaseInsensitiveFiltering: true
		 
	});
	
	$('#candistrictId').multiselect({
		 
		 enableCaseInsensitiveFiltering: true
		 
	});
	$('#canmandalId').multiselect({
		 
		 enableCaseInsensitiveFiltering: true
		 
	});
	$('#canvillageId').multiselect({
		 
		 enableCaseInsensitiveFiltering: true
		 
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
	
	$('#canalTypeId').multiselect({
		 
		 enableCaseInsensitiveFiltering: true
		 
	});
	
	$('#canalReservoirId').multiselect({
		 
		 enableCaseInsensitiveFiltering: true
		 
	});
	
	
	
	
	
	
	
	 $('#mkinfo').hide();
	 
	 $('#pmsresinfo').hide();
	 
	 $('#pmscaninfo').hide();
	 
	 $('#tanksflitems').hide();
	 
	// $('#sheditcanalsinfo').hide();
	 
	// $('#shaddcanalsinf').hide();
	 
	 $('#frm20').hide();
	 
	 $( "#form20tabs" ).tabs({ });
	 
	 
	 
	 
	 
	 $('a[data-toggle="tab"]').on('show.bs.tab', function(e) {
	        localStorage.setItem('activeTab', $(e.target).attr('href'));
	    });
	    var activeTab = localStorage.getItem('activeTab');
	    if(activeTab){
	    	//alert(activeTab);
	        $('#tmsreportstab a[href="' + activeTab + '"]').click();
	    }
	
	
	  
	  //form20 vars start
	  
	  $('#flreg').hide();
	  $('#flrain').hide();
	  
	  $('#flbld').hide();
	  
	  for(var i=1 ; i<15; i++){
		  
		  var str="#flani"+i;
		  
		  $(str).hide();
	  }
	 
	//  $('#flwr').hide();
	///  $('#flsl').hide();
	//  $('#flret').hide();
	///  $('#flapr').hide();
	// $('#fltb').hide();
	//  $('#flcha').hide();
	 // $('#floth').hide();
	  
	 
	  
	  
	  
	  
	  //form20 vars end
	  
	  
	
	  
	  
	  
		
		
	   
	   
	   
	  
			  var id =  $("#nextPostId").val();
	//		  alert("nextPostId" +id);
			  if(id!=null){
			  if(parseInt(id)>0){
			  $("#nextPostId1").val(id);
			
			  $('#nextPostId2').val(id);
			  $('#nextPostId3').val(id);
			//  $('#empId4').val(id);
			  $('#nextPostId5').val(id);
			  $('#nextPostId6').val(id);
			  $('#nextPostId7').val(id);
			  $('#nextPostId8').val(id);
			  $('#editnextPostId').val(id);
			  }
			  }
			  
			  
			  var nextempid =  $("#nextEmpId").val();
				//		  alert("nextempid" +nextempid);
						  if(nextempid!=null){
						  if(parseInt(nextempid)>0){
						  $("#nextEmpId1").val(nextempid);
						
						  $('#nextEmpId2').val(nextempid);
						  $('#nextEmpId3').val(nextempid);
						//  $('#empId4').val(nextempid);
						  $('#nextEmpId5').val(nextempid);
						  $('#nextEmpId6').val(nextempid);
						  $('#nextEmpId7').val(nextempid);
						  $('#nextEmpId8').val(nextempid);
						  $('#editnextEmpId').val(nextempid);
						  }
						  }
			  
		
						  
						  
					/*var m=	  $('#nextPostId option').length ;
					
					//$('#nextPostId').multiselect('rebuild');
					alert("m"+m);
					
                          if(m==2){
						
						alert("iam inside1");
						
						$('#nextPostId option:eq(2)').prop('selected', true);
						
						 $("#nextPostId").val("${u.postId}");
						 $("#nextEmpId").val("${u.empId}")
						
					//	$('#nextPostId').multiselect('rebuild');
						
						
						
					}
					
					if(m>2){
						
						alert("iam inside2");
						
						$('#nextPostId').prop('selected', false);
						
						 $("#nextPostId option:selected"). each(function () {
							 $(this). removeAttr('selected'); 
							
							
							 });
						
					
						
					}*/

	

	}); 







	
	

	
	
	
	


	
	
	
	
	
	
	
	
	
	
	
	//doller function
	
	$(function() {
		
		$('#getprojects_dialogue').dialog({
			  autoOpen:false,
			  width:1200,
			  close: function() {
				  
				
					  $(this).dialog("close");
					  }
			 });
		
		
		$('#getprojectscanals_dialogue').dialog({
			  autoOpen:false,
			  width:1200,
			  close: function() {
				  
				
					  $(this).dialog("close");
					  }
			 });
		
		$('#addcanals_dialogue').dialog({
			  autoOpen:false,
			  width:800,
			  close: function() {
				  
				
					  $(this).dialog("close");
					  }
			 });
		
		
		$('#addresloc_dialogue').dialog({
			  autoOpen:false,
			  width:800,
			  close: function() {
				  
				
					  $(this).dialog("close");
					  }
			 });
		
		 
		
		
		
		 $('#shaddcanalsinf').click(function(){
				
			 $('#addcanals_dialogue').dialog('option', 'title', 'Add Canal location');
			  $('#addcanals_dialogue').dialog('open');
			 
		      
			  
			  $('#addcanalsloc').trigger("reset"); 
			  $('#addcanalsloc1').trigger("reset");
			  $('#addcanalsloc2').trigger("reset");
			  
			  $('#cancanId').val(0);
			  $('#canalName').val('');
			  
			  
			  var projectId=  $('#canmainprojectId').val();
			  $('#canProjectId').val(projectId);
			  
			  $('#editFlag').val(false);
			  $('#editFlag2').val(false);
			
			  
			 
			  		$('#canalTypeId').val('');
			  		
			  		$('#canalTypeId').multiselect('rebuild');
			  		
			  		$('#canalReservoirId').val('');
			  		
			  		$('#canalReservoirId').multiselect('rebuild');
			  		
			  		$('#canselectedDistrictId').val(0);
			  		getDistricts(2);
			  		
			  		$('#canselectedMandalId').val(0);
			  		$('#canselectedVillageId').val(0);
			  		
			  		$('#canmandalId').val('');
			  		
			  		$('#canmandalId').multiselect('rebuild');
			  		
			  		$('#canvillageId').val(0);
			  		
			  		$('#canvillageId').multiselect('rebuild');
			  		
			  		$('#canreamarksVillageName').val('');
			  		
			  		getCanalsInfo(projectId,1);
			  		getCanalsNameedit(projectId)
			  		
			  		 getCanalsList(projectId);
			  		
			  		getProjectCode(projectId);
			  		
			  		
			  		document.getElementById('cancaptcha_id').src = '../captcha2.jpg?' + Math.random();
			  		document.getElementById('cancaptcha_id2').src = '../captcha3.jpg?' + Math.random();
			  		//document.getElementById('mainformcaptcha_id').src = '../captcha.jpg?' + Math.random();
			  		
			  	
			  		
			  		
			  
			 });
		 
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
			  
			  
			  
			  document.getElementById('rescaptcha_id').src = '../captcha2.jpg?' + Math.random();  
			 
		      
			 });
		 
		 
		 
		 $('#showprojectsdata').click(function(){
				
			 $('#getprojects_dialogue').dialog('option', 'title', 'Projects');
			  $('#getprojects_dialogue').dialog('open');
			 
		      
			 });
		 
		 $('#showprojectscaninfo').click(function(){
				
			 $('#getprojectscanals_dialogue').dialog('option', 'title', 'Projects');
			  $('#getprojectscanals_dialogue').dialog('open');
			 
		      
			 });
		
		

		//form20 start 
		
		$('.frmchk').click(function(){
			  
			var fchk =  $(this).prop('id');
		
			if(fchk=="regchkid"){
			
			var regchk = $('#regchkid').prop('checked');
			
			if(regchk) {
				
				$('#flreg').show();
			}else{
				
				$('#flreg').hide()
			}
			}else if(fchk=="rainchkid"){
				
				var rainchk = $('#rainchkid').prop('checked');
			
				if(rainchk) {
					
					$('#flrain').show();
				}else{
					
					$('#flrain').hide()
				}
			}else if(fchk=="bldchkid"){
				
				var bldchk = $('#bldchkid').prop('checked');
			
				if(bldchk) {
					
					$('#flbld').show();
				}else{
					
					$('#flbld').hide()
				}
			}else if(fchk=="anichkid1"){
				
				var anchk = $('#anichkid1').prop('checked');
			
				if(anchk) {
					
					$('#flani1').show();
				}else{
					
					$('#flani1').hide()
				}
			}else if(fchk=="anichkid2"){
				
				var wrchk = $('#anichkid2').prop('checked');
				
			
				if(wrchk) {
					
					$('#flani2').show();
				}else{
					
					$('#flani2').hide()
				}
			}else if(fchk=="anichkid3"){
				
				var slchk = $('#anichkid3').prop('checked');
			
				if(slchk) {
					
					$('#flani3').show();
				}else{
					
					$('#flani3').hide()
				}
			}
            else if(fchk=="anichkid4"){
				
				var retchk = $('#anichkid4').prop('checked');
			
				if(retchk) {
					
					$('#flani4').show();
				}else{
					
					$('#flani4').hide()
				}
			}else if(fchk=="anichkid5"){
				
				var aprchk = $('#anichkid5').prop('checked');
			
				if(aprchk) {
					
					$('#flani5').show();
				}else{
					
					$('#flani5').hide()
				}
			}else if(fchk=="anichkid6"){
				
				var tkchk = $('#anichkid6').prop('checked');
			
				if(tkchk) {
					
					$('#flani6').show();
				}else{
					
					$('#flani6').hide()
				}
			}else if(fchk=="anichkid7"){
				
				var chchk = $('#anichkid7').prop('checked');
			
				if(chchk) {
					
					$('#flani7').show();
				}else{
					
					$('#flani7').hide()
				}
			}else if(fchk=="anichkid8"){
				
				var otchk = $('#anichkid8').prop('checked');
			
				if(otchk) {
					
					$('#flani8').show();
				}else{
					
					$('#flani8').hide()
				}
			}else if(fchk=="anichkid9"){
				
				var otchk = $('#anichkid9').prop('checked');
			
				if(otchk) {
					
					$('#flani9').show();
				}else{
					
					$('#flani9').hide()
				}
			}
else if(fchk=="anichkid10"){
				
				var otchk = $('#anichkid10').prop('checked');
			
				if(otchk) {
					
					$('#flani10').show();
				}else{
					
					$('#flani10').hide()
				}
			}
else if(fchk=="anichkid11"){
	
	var otchk = $('#anichkid11').prop('checked');

	if(otchk) {
		
		$('#flani11').show();
	}else{
		
		$('#flani11').hide()
	}
}else if(fchk=="anichkid12"){
	
	var otchk = $('#anichkid12').prop('checked');

	if(otchk) {
		
		$('#flani12').show();
	}else{
		
		$('#flani12').hide()
	}
}else if(fchk=="anichkid13"){
	
	var otchk = $('#anichkid13').prop('checked');

	if(otchk) {
		
		$('#flani13').show();
	}else{
		
		$('#flani13').hide()
	}
}else if(fchk=="anichkid14"){
	
	var otchk = $('#anichkid14').prop('checked');

	if(otchk) {
		
		$('#flani14').show();
	}else{
		
		$('#flani14').hide()
	}
}
else if(fchk=="anichkid15"){
	
	var otchk = $('#anichkid15').prop('checked');

	if(otchk) {
		
		$('#flani15').show();
	}else{
		
		$('#flani15').hide()
	}
}
else if(fchk=="anichkid16"){
	
	var otchk = $('#anichkid16').prop('checked');

	if(otchk) {
		
		$('#flani16').show();
	}else{
		
		$('#flani16').hide()
	}
}
else if(fchk=="anichkid17"){
	
	var otchk = $('#anichkid17').prop('checked');

	if(otchk) {
		
		$('#flani17').show();
	}else{
		
		$('#flani17').hide()
	}
}
			
			else{
				
				
			}
         	
		});
		


		
		$('.regacres').blur(function(){
			
			var regsum=0;
			
			 $( ".regacres" ).each(function() {
				
				 
				 var acresval=  parseFloat($(this).val());	   
				 
				 regsum=regsum+acresval;
				 
				// alert("inside"+regsum)
			
			
			 });
			 
			// alert("regsum"+regsum);
			 
			 var regtotid="#"+"regTotalAcres";
			 
			 $(regtotid).val(regsum);
		
		});
		
          $('.pcost').blur(function(){
        	  
        	  var approxid="#"+"approxRepPermanent";
        	  
        	  var approxtt="#"+"approxRepTotal";
			
			var psum=0;
			
			var appsum=0;
			
			 $( ".pcost" ).each(function() {
				
				 
				 var pval=  parseFloat($(this).val());	  
				 
			
				 
				 psum=psum+pval;
				 
			
				 
				// alert("inside"+regsum)
				 $(approxid).val(psum);
				
			
			
			 });
			 
			 
			 $( ".appval" ).each(function() {
 				
				 
				 var apval=  parseFloat($(this).val());	   
				 
				 appsum=appsum+apval;
				 
				// alert("inside"+regsum)
			
				 $(approxtt).val(appsum);	
			 });
			 
			// alert("regsum"+regsum);
		
			 
		
			
			 
			
		});
          
          $('.tcost').blur(function(){
  			
  			var tsum=0;
  			var appsum=0;
  			
  			 var approxid="#"+"approxRepTemp";
  			 var approxtt="#"+"approxRepTotal";
  			
  			 $( ".tcost" ).each(function() {
  				
  				 
  				 var tval=  parseFloat($(this).val());	   
  				 
  				tsum=tsum+tval;
  				
  				 $(approxid).val(tsum);
  				
  				 var apvat=  parseFloat($('#approxRepTemp').val())>0
  		        
  				
  				// alert("inside"+regsum)
  			
  			
  			 });
  			 
  			 $( ".appval" ).each(function() {
	 				
					 
					 var apval=  parseFloat($(this).val());	   
					 
					 appsum=appsum+apval;
					 
					// alert("inside"+regsum)
				
					 $(approxtt).val(appsum);	
				 });
				 
  			 
  			// alert("regsum"+regsum);
  			 
  			
  			 
  			
  		
  		});
          
       
          
      
          
          

		//form30 end
		
		

		
		
		
		
		
		$('#frm20_view_dia').dialog({
			  autoOpen:false,
			  width:1200,
			  close: function() {
				  
				
					  $(this).dialog("close");
					  }
			 });
		
		$('#frm20_doc_dia').dialog({
			  autoOpen:false,
			  width:1200,
			  close: function() {
				  
				
					  $(this).dialog("close");
					  }
			 });
		
		
		
		$('#frm20_doc_update').dialog({
			  autoOpen:false,
			  width:1200,
			  close: function() {
				  
				
					  $(this).dialog("close");
					  }
			 });
		
		
		
		
		
		
		
		
		$('#confirmdia').dialog({
		    
		    autoOpen:false,
		    width:600,
		    buttons: {
		        confirm: function () {
		            $.alert('Confirmed!');
		        },
		        cancel: function () {
		            $.alert('Canceled!');
		        }
		        
		    }
		});
		



	
		
		
		
		$('.table1').DataTable( {
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
		
		
		
		 
		
		 
		
		 
		 $('#gettanks_dialogue').dialog({
			  autoOpen:false,
			  width:1200,
			  close: function() {
				  
				
					  $(this).dialog("close");
					  }
			 });
		 
		 $('#getanicut_dialogue').dialog({
			  autoOpen:false,
			  width:1200,
			  close: function() {
				  
				
					  $(this).dialog("close");
					  }
			 });
		 
		 $('#getcheckdam_dialogue').dialog({
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
		 
		 $('#anicutdata').click(function(){
				
			 $('#getanicut_dialogue').dialog('option', 'title', 'View Anicut Info');
			  $('#getanicut_dialogue').dialog('open');
			 
		      
			 });
		 
		 $('#showcheckdamdata').click(function(){
				
			 $('#getcheckdam_dialogue').dialog('option', 'title', 'View CheckDam Info');
			  $('#getcheckdam_dialogue').dialog('open');
			 
		      
			 });
		
		
		 
		
		 
	
		
		 
		
		 
		 
	
		 
		 
		 
		
		 
		 
	
		 
		 
		
		 
		
		 
		 
		
		  
		 
		 


		
		
		 
		
		
		 
		
		
	$("#addresjuris").click(function() {
		  var link = $(this).attr('href');
		  
		//  alert(link);
		
		  $('#whereFormWillLive').load(link);
		 

		 // $(".content").load(link);
		});
		
	/* 
	$( "#tabs" ).tabs().addClass( "ui-tabs-vertical ui-helper-clearfix" );
	$( "#tabs li" ).removeClass( "ui-corner-top" ).addClass( "ui-corner-left" );
	 */
	 $( "#tabs" ).tabs({
			 
			 beforeActivate: function( event, ui )
			    {   
			        var valid = "Are you sure you want to move to  other tab ";
			        var userdesg=parseInt($("#designationId1").val());
			       // alert("userdesg"+userdesg);
			        if(userdesg==2 || userdesg==8){
			        if (confirm(valid)) {
			           
			        	 return true;  
			          
			        }
			        else{
			        	
			        	return false;
			          
			        }
			        }
			    }
			 
	 
	 });
	 
	 
	 
	 $( "#tabs2" ).tabs({ });
 
	

		$("#verticaltii").tabs().addClass("ui-tabs-vertical ui-helper-clearfix");
		$("#verticaltii li").removeClass("ui-corner-top").addClass("ui-corner-left");
		
	
		
		

	  var cyear = (new Date).getFullYear();
	 // var lyear = (new Date).getFullYear()+1;
	 
	$(".datepick").datepicker({
			changeYear : false,
			changeMonth : true,
			// minDate: new Date(cyear, 0, 1),
		      //  maxDate: new Date(cyear, 11, 31),
		     
			
			 dateFormat: "dd/mm/yy"+" "+ getCurrentTime(),
			 
			   beforeShow: function (input, inst) {

			        var selectedYear = parseInt($("#year").val());

			        if (!selectedYear) return;

			        var minDate = new Date(selectedYear, 0, 1);      // Jan 1 of selected year
			        var maxDate = new Date(selectedYear + 1, 11, 31); // June 30 of next year

			        $(this).datepicker("option", "minDate", minDate);
			        $(this).datepicker("option", "maxDate", maxDate);
			    }
			   
			
		/* 
		 dateFormat : "dd/mm/yy", onSelect: function(selected) {
		   $("#month").datepicker("option","minDate", selected)
		 } */
		});
	
	$('#damageTime').datetimepicker({
		
		  format: 'HH:mm'
    });
	 
	 

	 
	 $("#miCompIdParent").change(function() {
		  var id = $(this).val();
		  
		//  alert(id);
		
		  $('#compparentId').val(id);
		
		 

		 // $(".content").load(link);
		});
	 
	
	 
	 
	 
	 
	 $("#nextPostId").change(function() {
		  var id = $(this).val();
		//  alert("id" +id);
		//  $("#nextPostId option:eq(1)").prop("selected", true);
		//  alert("nextPostId: "+$("#nextPostId option:first-child").text());
		  
		  $('#nextPostId8').val(id);
		  $('#editnextPostId').val(id);
		  
		  var neid = $('#nextEmpId').val();
			//  alert("neid" +neid);
			 
			  $('#nextEmpId8').val(neid);
			  $('#editnextEmpId').val(neid);
		});
	 
	 $("#nextEmpId").change(function() {
		 var neid = $('#nextEmpId').val();
			
			 
			  $('#nextEmpId8').val(neid);
			  $('#editnextEmpId').val(neid);
			  
			  var npid = $('#nextPostId').val();
			  
			  $('#nextPostId8').val(npid);
			  $('#editnextPostId').val(npid);
		});
	 
	 
	// var yearval=parseInt($("#year").val());
	/* if(yearval!='Nan' && yearval!=null){
		 
		 if(yearval>0){
			 
			  $('#miyear1').val(yearval);
			  $('#miyear2').val(yearval);
			  $('#miyear3').val(yearval);
			  $('#miyear4').val(0);
			  $('#miyear5').val(0);
			  $('#miyear6').val(0);
			  $('#miyear7').val(0);
			  $('#editmiyear').val(yearval);
			 
			 
		 }
		 
		 
	 }*/
	
	
	
	 //  use this

	/* $('#sheditcanalsinfo').click(function(){
			
		 $('#addcanals_dialogue').dialog('option', 'title', 'Edit Canal location');
		  $('#addcanals_dialogue').dialog('open');
		 
		  $('#addcanalsloc').trigger("reset"); 
		  
		  var canalId=$('#canalId').val();
		  
		  $.ajax({	          
		      url: "../invtsimis/get-canal-location",
		      method:"POST",
			   dataType: 'json',				
		      async: false,
		      data: {canalId:canalId},
		      success: function (msg) {
		    	  
		    	//console.log(msg);
		    	 
		    	len=msg.length;
			    //	alert(msg);		
			    	
			  	  if(len>0){	
			  		  
			  		  var canalName=msg[0].canalName;
			  			  
			  		  var canalId=msg[0].canalId;
			  		  
			  		  var canalTypeId=msg[0].canalTypeId;
			  		  
			  		 var districtId=msg[0].districtId;
			  		 
			  		 var mandalId=msg[0].mandalId;
			  		 
			  		 var villageId=msg[0].villageId;
			  		 
			  		 var remarksVillage=msg[0].remarksVillage;
			  		 
			  		 var projectId=msg[0].projectId;
			  		 
			  		 var resId=msg[0].reservoirId;
			  		 
			  		//alert("projectId"+projectId);
			  		 
			  		$('#editFlag').val(true);
			  			  
			  		$('#cancanId').val(canalId);
			  		$('#canalName').val(canalName);
			  		
			  		$('#canProjectId').val(projectId);
			  		
			  		if(parseInt(canalTypeId)>0){
			  		$('#canalTypeId').val(canalTypeId);
			  		
			  		$('#canalTypeId').multiselect('rebuild');
			  		}
			  		
			  		
			  		if(parseInt(resId)>0){
				  		$('#canalReservoirId').val(resId);
				  		
				  		$('#canalReservoirId').multiselect('rebuild');
				  		}
			  		if(parseInt(districtId)>0){
			  			
			  		//	alert("canaldistrict"+districtId)
			  			
			  			$('#canselectedDistrictId').val(districtId);
			  			
			  			getDistricts(2);
			  		
							    	
			  			
			  			 $("#candistrictId").each(function () {
							 
							  $(this).val(districtId);
						    	            $(this).attr("selected", "selected");
						    	  		  
				    	});
				  	
				  		
				  		
				  		
				  		$('#candistrictId').multiselect('rebuild');
				  		
				  		
				  		$('#canselectedMandalId').val(mandalId);
				  		$('#canselectedVillageId').val(villageId);
				  		
				  		
				  		
				  		getMandals(districtId,2);
				  		
				  		getVillages(districtId,mandalId,2)
				  		}
			  		
			  		//alert("remarksVillage"+remarksVillage);
			  		
			  		$('#canreamarksVillageName').val(remarksVillage);
			  	
						
							  }
							  
							  if(len==0){	
								  
								
							  
							  }
							
		    	
		    	 

		      },
		      error : function(){
		    	  alert(error);
		      }
		  });
		 
	      
		 });*/
	





		
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











































//form 20 functions start

function addformdata(frmname){
	//alert("frmname"+frmname);
	
	var subbutton=	$("#addmichecks8").text();
	
	  var valid = "Are you sure you want to submit form 20?";
	  
	  var customformid="#"+frmname;
		 
		// alert("customformid"+customformid);
	  
	  
	
			
				var tankId=$("#mitankId8").val();
				
				var canId=$("#canalId8").val();
				
			//	var canId=$("#canalId").val();
				
				var resId=$("#resId8").val();
				
				var category=$("#catId8").val();
				
				var districtId=0;
			
		            if(category==1){
		            	
		            	districtId=0;
		            }
                     if(category==2){
		            	
		            	districtId=$("#resMainDistrictId").val();;
		            }
                     if(category==3){
 		            	
 		            	districtId=$("#canMainDistrictId").val();;
 		            }
			
	  
	  if(subbutton=='Submit'){ 
		  
		  if (confirm(valid)) {
			  
			  //alert("category"+category);
			 // alert("tankId"+tankId);
			 // alert("canId"+canId);
			 // alert("resId"+resId);
			 // alert("districtId"+districtId);
			  
				if((category==1 && tankId>0) || (category==3 && canId>0 && districtId>0) || (category==2 && resId>0 && districtId>0)  ){
					
					
					
		  

	//alert("coming kal");
		
			
		
			
			
			
			
			
	//		var m=$('#inspectDateinflows').val();
	//		alert("inspectDateinflows" + m);
		var nextemp=$("#nextEmpId").val();
		
		 $('#action_alert').empty();
		 
		// $('form[name='+frmname+']').serialize(),
		 
		 var form = $("#michecks8").closest("form");
		 var formData = new FormData(form[0]);
		 
		// console.log("formData"+formData);
		 
		 if ( $('form[name=mainformname]').parsley().isValid() ) {
		 
		  if ( $('form[name='+frmname+']').parsley().isValid() ) {
	
		  // var formData = new FormData(document.getElementsByName(frmname));  enctype: 'multipart/form-data',
	 	 $.ajax({	          
		      url: "../invtsimis/addFormData",
		      method:"POST",
		      async: false,
		      data:  formData,
		    
              contentType: false,
              processData: false,
		      
		       
		     
			 
		      success: function (response) {
		   
		    	//alert("kal"+response);
		    	 
		    	 if(response>0){
		    		 
		    	//	alert("i am in kal Data inserttedd Successfully");
		
			  $('#action_alert').html('<p style="margin: 0px !important;">Data inserted Successfully</p>');
				$("html,body").animate({scrollTop:$('#action_alert').offset().top-175}, 500);
				
				  $('#flreg').hide();
				  $('#flrain').hide();
				  
				  $('#flbld').hide();
				  
				  for(var i=1 ; i<12; i++){
					  
					  var str="#flani"+i;
					  
					  $(str).hide();
				  }
				 
				  getfrmsentlist(tankId,resId,canId)
				 
					 $(customformid).trigger("reset"); 	
				  document.getElementById('mainformcaptcha_id').src = '../captcha.jpg?' + Math.random();
				 
			    }
				
				if(response==0||response==null){
			    	
			    	  $('#action_alert').html('<p style="margin: 0px !important;">Failed to Update data</p>');
			    		$("html,body").animate({scrollTop:$('#action_alert').offset().top-175}, 500);
			    }
				
				if(response==-3){
					
					 $('#action_alert').html('<p style="margin: 0px !important;">Please Enter the Captcha Text</p>');
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
	 	 
	  
		  
	  }else{
		  
		 
				
				$('form[name='+frmname+']').parsley().validate();
				//alert("kal4");
			
	  }
		  
		 }else{
			  
				 
				
				$('form[name=mainformname]').parsley().validate();
				//alert("kal4");
			
	  }
		  
		    return true;
			
				}else {
					
					
					
					$('#action_alert').html('<p style="margin: 0px !important;">Tank/Reservoir/Canal not selected</p>');
		    		$("html,body").animate({scrollTop:$('#action_alert').offset().top-175}, 500);
					
					return false;
				}
			return true;
			
			
		  
		  }
	       else{
	       	
	       	return false;
	         
	       }
		  
	  }
	
}

function getfrmsentlist(tankId,resId,canId){
	
	//alert("canId"+canId);
	
		//alert("kal"+tankId);
	$("#addmichecks8").text( 'Submit');
	$(".updatepht").show();
	$("#regLeftChnnAcres").val('0.00');
	$("#regRightChnnAcres").val('0.00');
	$("#regOthAcres").val('0.00');
	$("#rainRGStation").val("");
	$("#rainQty").val('0.00');
	$("#rainDate").val(0);
		
	
	//var xdate=$("#regLeftChnnAcres").val();
	//alert("regLeftChnnAcres"+xdate)
	
	$("#quartName").val("");
	$("#quartType").val("");
	$("#bldgTypeName").val("");
	$("#bldgDescDamage").val("");
	$("#approxRepTemp").val('0.00');
	
	$("#approxRepPermanent").val('0.00');
	
	$("#frmBookValue").val('0.00');
	$("#effAyacutAcres").val('0.00');
	$("#effAyacutValue").val('0.00');
	$("#actionStdCrops").val("");
	$("#damageBreaches").val("");
	$("#usefulRemarks").val("");
	$("#tsfcFormDate").val(' ');
	
	$("#damageDate").val(0);
	$("#damageTime").val("0.00");
	$("#damageCause").val("");
	$("#frmProposed").val("");
	$("#writeOffValue").val('0.00');
	$("#writeOffAction").val("");				
	$("#regchkid").prop('checked', false);
	$("#rainchkid").prop('checked', false);
	$("#bldchkid").prop('checked', false);
	$("#bldchkid").prop('checked', false);
	
	$("#bldchkid").prop('checked', false);
	
	for(var i=0; i<15 ; i++){
		var anchk="#anichkid"+i ;
		$(anchk).prop('checked', false);
		
		}
	
	chkshowdata();
	
	 for(var h=1; h<15; h++){
		 
			// alert(t+"t");
		 
		 m=h-1;
		 
		 var irrchfrom="#irrChFrm"+m;
		 var irrchto="#irrChTo"+m;
		 var irrl="#irrL"+m;
		 var irrb="#irrB"+m;
		 var irrd="#irrD"+m;
		 var irrpcost="#irrPermcost"+m;
		 var irrtcost="#irrTempcost"+m;
		 
		// alert("m"+m);
		 
		// $(irrsrcname).val(obj[i].irrSrcName);
		 $(irrchfrom).val('0.00');
		 $(irrchto).val('0.00');
		 $(irrl).val('0.00');
		 $(irrb).val('0.00');
		 $(irrd).val('0.00');
		 $(irrpcost).val('0.00');
		 $(irrtcost).val('0.00');
			 
		
		 }

		
		$("#thead8").empty();
		$("#tbody8").empty();
	
	

		$.ajax({	          
		      url: "../invtsimis/frm-list",
		      type: "GET",
		      dataType: 'json',				
		      async: false,
		      data: { tankId : tankId,
		    	       resId : resId,
		    	       canId : canId },
		      success: function (obj) {
		    	  
		    
		    	
		    	  var j=1;
		    	  
		    	  $('#frm20data table thead').append( '<tr style="font-size: 18px; color: gray; font-weight: bold;"><th>Sl.No</th>'+
		    	    		
		    	    		'<th>Form20Sent Date</th>'+
		    	    	
		    	    		/*'  <th>Latest</th>'+*/
		    	    		'  <th>View Form 20</th>'+
		    	    		
		    	    		' <th>Edit Form 20 </th>'+
		    	    		
		    	    		' <th>Update Photos </th>'+
		    	    		
		    	    		'  <th>Delete form 20</th>'+
		    	    		
		    	    		'  <th>View/Delete Photos</th>'+
		    	    		
		    	    		
		    	    		
		    	    		'</tr>'); 	 
				 
		    	  //alert("obj"+obj);
						//var obj = JSON.parse(response);
						
						
						$.each(obj, function(key, value) {
							
						
						   var finaldate=value.createDate;
							
							//var finaldate="07/07/2022";
							
						    //alert(finaldate+"finaldate");
						     

							
							 var submittedDate = moment(finaldate, "DD/MM/YYYY").add(7, 'days').format('DD/MM/YYYY');
							 
							 var date = submittedDate.substring(0, 2);
							 var month = submittedDate.substring(3, 5);
							 var year = submittedDate.substring(6, 10);
							 
							// alert(date+"---"+month+"---"+year);
							 //.format('DD/MM/YYYY');
							//var sdate= submittedDate.toDate();
							
							 ;
							 
							 var dateToCompare = new Date(year, month-1 , date);
							var currentdate= new Date();
							
							//alert("dateToCompare"+dateToCompare);
							
							var latestdate=currentdate;
							
							//alert("latestdate"+latestdate);
							
						
								//moment(currentdate, "DD/MM/YYYY").format('DD/MM/YYYY');
							//alert("latestdate"+new Date(latestdate));
							//alert("submittedDate"+new Date(submittedDate));
							
					  // var sdate=new Date(finaldate);
					 // var sdatenew= sdate.toString('dd/mm/yyyy');
					//  alert(sdatenew);
					 //  var ldate=new Date(latestdate);
					  
					   
					 //  alert(sdatenew+"---"+ldate);
							
							//and userdesignation is 2 or 4 or 8
							// in case of 4 then show ok to proceed button 
							//click on ok insert in apprv table 
							// get the STATUS from apprv table THEN SHOW EDIT BUTTON 
							
						
							
							  $('#frm20data table tbody').append(  '<tr style="font-size: 16px">' +
		                                '<td style="text-align: center;">'+j+'</td>' +
		                               
		                                '<td><b>'+value.tsfcFormDate+'</b></td>' +
		                             
		                                /*'<td><b>'+obj[i].latestRemarks+'</b></td>' +*/
		                                '<td><b><button type="button" name="viewfrmdata" id="viewfrmdata'+j+'" class="btn btn-1 btn-primary center-block frmview"  onclick="viewfrmdatafn('+value.formDataId+')"  >View Form 20</button> </b></td>' +
		                                
		                                ((dateToCompare> latestdate)?'<td><b><button type="button" name="editfrmdata" id="editfrmdata'+j+'" class="btn btn-1 btn-primary center-block frmedit"  onclick="editfrmdatafn('+value.formDataId+')"  >Edit Form 20</button> </b></td>': '<td></td') +
		                                ((dateToCompare > latestdate)? '<td><b><button type="button" name="editphotosdata" id="editphotosdata'+j+'" class="btn btn-1 btn-primary center-block frmphtedit"  onclick="editphotosdatafn('+value.formDataId+')"  >Update Photos</button> </b></td>': '<td></td') +
		                                
		                                ((dateToCompare> latestdate)? '<td><b><button type="button" name="deletefrmdata" id="deletefrmdata'+j+'" class="btn btn-1 btn-primary center-block frmdelete"  onclick="deletefrmdatafn('+value.formDataId+','+value.tankId+','+value.resId+','+value.canId+')"  >Delete Form20</button> </b></td>': '<td></td') +
		                                ((dateToCompare >latestdate)? '<td><b><button type="button" name="deletefrmpht" id="deletefrmpht'+j+'" class="btn btn-1 btn-primary center-block frmphtdelete"  onclick="deletefrmphtfn('+value.formDataId+')"  >View/Delete Photos</button> </b></td>': '<td></td') +
		                              
		                                 			                               
		                               
		                                '</tr>');
						
							
							
							  
							   j++;
							  
							 
						});

		      },
		      error : function(){
		    	  alert(error);
		      }
		  });	
		
	
}


function viewfrmdatafn(formdataId){
	
	
	//alert("kal"+formdataId);
	
	$("#view-thead9").empty();
	$("#view-tbody9").empty();

	
	 $('#frm20_view_dia').dialog('option', 'title', 'View Form 20 Info');
	  $('#frm20_view_dia').dialog('open');

	



	$.ajax({	          
	      url: "../invtsimis/get-frm-data?formDataId="+formdataId,
	      type: "GET",
	      async:false,
	     
		    contentType: "application/json; charset=utf-8",
	      success: function (response) {
	    	// alert(response);
	    	  
	    	//  console.log(response);
	    	
	    	
	    	  var j=1;
	    	  
	    	 
			 
			
				var obj = JSON.parse(response);
				
						
						  $('#viewfrm20 table tbody').append(  
	                              
	                               
								  '<tr><td><b>Damage Type</b></td><td><b>'+obj[0].damageTypeName+'</b></td></tr>' +
	                                '<tr><td><b>Date of Damage </b></td><td><b>'+obj[0].damageDate+'</b></td></tr>' +
	                                '<tr><td><b>Damage Time</b></td><td><b>'+obj[0].damageTime+'</b></td></tr>' +
	                                '<tr><td><b>Cause of Damage</b></td><td><b>'+obj[0].damageCause+'</b></td></tr>' +
	                                '<tr><td><b>Proposed Replace or Reconstruction </b></td><td><b>'+obj[0].frmProposed+'</b></td></tr>' +
	                                '<tr><td><b>If it is not proposed to replace or reconstruct the damaged portion of the property that the amount to be written off. The capital value of the property?(The amount should be estimated in the absense of the recorded book value)  </b></td><td><b>'+obj[0].writeOffValue+'</b></td></tr>' +
	                                '<tr><td><b>Action being taken to effect write off. </b></td><td><b>'+obj[0].writeOffAction+'</b></td></tr>' +
	                                '<tr><td style="color:blue"><b>Registered Ayacut</b></td><td  style="color:blue"><b>under left side Channel: '+obj[0].regLeftChnnAcres+' Acres</b></td><td  style="color:blue"><b>Under right side Channel: '+obj[0].regRightChnnAcres+' Acres</b></td><td  style="color:blue"><b>Other Ayacut:'+obj[0].regOthAcres+' Acres</b></td></tr>' +
'<tr ><td style="color:blue"><b>If due to rain fall</b></td><td  style="color:blue"><b>Name of nearest Rain Gauge Station.: '+obj[0].rainRGStation+'</b></td><td  style="color:blue"><b>Quantity of Rain fall : '+obj[0].rainQty+' </b></td><td  style="color:blue"><b>Date :'+obj[0].rainDate+' </b></td></tr>' +
	                                
'<tr ><td style="color:blue"><b>Incase of buldings, if the damages are due to cyclone or fire accidents</b></td><td  style="color:blue"><b>a) Name of Quarter : '+obj[0].quartName+'</b></td><td  style="color:blue"><b>b) Quarter Type  : '+obj[0].quartType+' </b></td><td  style="color:blue"><b>c) Residential or Non Residential :'+obj[0].bldgTypeName+' </b></td><td  style="color:blue"><b>d) Description of damage  :'+obj[0].bldgDescDamage+' </b></td></tr>'+
'<tr ><td ><b>Approximate estimate for Repairs or Reconstruction</b></td><td  ><b> Temporary Measure : '+obj[0].approxRepTemp+'</b></td><td  ><b>Permanent Repairs  : '+obj[0].approxRepPermanent+' </b></td></tr>'+
'<tr><td><b>Book value </b></td><td><b>'+obj[0].frmBookValue+'</b></td></tr>' +
'<tr><td><b>Ayacut effected </b></td><td><b>acres </b></td><td><b>'+obj[0].effAyacutAcres+' Acres</b></td> <td><b>value  </b></td><td><b>'+obj[0].effAyacutValue+'  </b></td></tr>' +
'<tr><td><b>Whether action is being taken to protect the standing crops: Proposed for Temporary restoration </b></td><td><b>'+obj[0].actionStdCrops+'</b></td></tr>' +
'<tr><td><b>Indicate Whether the damages due to breaches. Scours washed off and silted up </b></td><td><b>'+obj[0].damageBreaches+'</b></td></tr>' +
'<tr><td><b>Any useful information/Remarks </b></td><td><b>'+obj[0].usefulRemarks+'</b></td></tr>' +
'<tr><td><b>Any useful information/Remarks </b></td><td><b>'+obj[0].usefulRemarks+'</b></td></tr>' +
'<tr><td><b>TSFC Form 20 sent date to Accountant General </b></td><td><b>'+obj[0].tsfcFormDate+'</b></td></tr>' 
						 
						  
						  );   

	          	   j++;
			
	      },
	      error : function(){
	    	  alert(error);
	      }
	  });	
	
	//alert("completed");
	
	$.ajax({	          
	      url: "../invtsimis/get-frm-datail?formDataId="+formdataId,
	      type: "GET",
	      async:false,
	     
		    contentType: "application/json; charset=utf-8",
	      success: function (response) {
	    	// alert(response);
	    	  
	    	//  console.log(response);
	    	
	    	
	    	  var j=1;
	    	  
	    	 
			 
			
					var obj = JSON.parse(response);
				
					 for(i in obj){	
						// alert("kal here"+i);
						  $('#viewfrm20 table tbody').append( 
								  '<tr >'+
								  '<td style="color:blue"><b>'+j+')  '+obj[i].irrSrcName+'</b></td>'+
	                                
	                              
								  '<td><b> Chainage (from)  : '+obj[i].irrChFrm+'</b></td>'+
								  '<td><b> Chainage(to)  : '+obj[i].irrChTo+' </b></td>'+
								  '<td><b>Measurement L.B. or Depth (to) :'+obj[i].irrL+'-'+obj[i].irrB+'-'+obj[i].irrD+' </b></td>'+
								  '<td><b>Permanent Measure(Rs)  :'+obj[i].irrPermcost+' </b></td>'+
								  '<td><b>Temporary Measure(Rs)  :'+obj[i].irrTempcost+' </b></td>'+
								 
								
								  '</tr>'                     
	                                         
						  );   

	          	   j++;
	          	   
					 }
			
	      },
	      error : function(){
	    	  alert(error);
	      }
	  });	
	

}


function editfrmdatafn(formdataId){
	
	$("#formDataId").val(0);
	$("#regLeftChnnAcres").val('0.00');
	$("#regRightChnnAcres").val('0.00');
	$("#regOthAcres").val('0.00');
	
	$("#rainRGStation").val("");
	$("#rainQty").val('0.00');
	$("#rainDate").val(0);
	
	$("#quartName").val("");
	$("#quartType").val("");
	$("#bldgTypeName").val("");
	$("#bldgDescDamage").val("");
	$("#approxRepTemp").val('0.00');
	
	$("#approxRepPermanent").val('0.00');
	
	$("#frmBookValue").val('0.00');
	$("#effAyacutAcres").val('0.00');
	$("#effAyacutValue").val('0.00');
	$("#actionStdCrops").val("");
	$("#damageBreaches").val("");
	$("#usefulRemarks").val("");
	$("#tsfcFormDate").val(0);
	
	$("#damageDate").val(0);
	$("#damageTime").val("0.00");
	$("#damageCause").val("");
	$("#frmProposed").val("	");
	$("#writeOffValue").val('0.00');
	$("#writeOffAction").val("");				
	$("#regchkid").prop('checked', false);
	$("#rainchkid").prop('checked', false);
	$("#bldchkid").prop('checked', false);
	$("#bldchkid").prop('checked', false);
	
	$("#bldchkid").prop('checked', false);
	
	$("#damageType").val(0);
	$('#damageType').multiselect('rebuild');
	
	for(var i=0; i<15 ; i++){
		var anchk="#anichkid"+i ;
		$(anchk).prop('checked', false);
		
		}
	
	chkshowdata();
	
	$("#addmichecks8").text( 'Submit');
	$(".updatepht").show();
	

	$.ajax({	          
	      url: "../invtsimis/get-frm-data?formDataId="+formdataId,
	      type: "GET",
	      async:false,
	     
		    contentType: "application/json; charset=utf-8",
	      success: function (response) {
	    	
	    	  var j=1;
	    	  
				var obj = JSON.parse(response);
				
				$("#formDataId").val(obj[0].formDataId);
				$("#damageDate").val(obj[0].damageDate);
				$("#damageTime").val(obj[0].damageTime);
				$("#damageCause").val(obj[0].damageCause);
				$("#frmProposed").val(obj[0].frmProposed);
				//$("#irrStrDmaPort").val(obj[0].irrStrDmaPort);
				if(obj[0].writeOffValue>0){
				$("#writeOffValue").val(obj[0].writeOffValue);
				}else{
					
					$("#writeOffValue").val('0.00');
				}
				$("#writeOffAction").val(obj[0].writeOffAction);				
				$("#regchkid").prop('checked', true);
				$("#rainchkid").prop('checked', true);
				$("#bldchkid").prop('checked', true);
				$("#bldchkid").prop('checked', true);
				
				$("#bldchkid").prop('checked', true);
				
				$("#damageType").val(obj[0].damageType);
				
				$('#damageType').multiselect('rebuild');
				
				//alert("obj[0].catId"+obj[0].catId);
				if(obj[0].catId==1){
					
					for(var i=1; i<15 ; i++){
						
						if(i!=8 &&  i!=9 && i!=10 && i!=11 && i!=12 && i!=13 ){
							
							
						var anchk="#anichkid"+i ;
						
						//alert("anchk--cat1"+anchk);
						
						$("#anichkid7").prop('checked', true);
						
						$(anchk).prop('checked', true);
						}
						
						if(i==8 || i==9 || i==10 || i==11 || i==12 || i==13){
							
							var anchk="#anichkid"+i ;
							
							$(anchk).prop('checked', false);
						 var str="#flani"+i;
						  
						  $(str).hide();
						}
						
						}
					
				
                		
               		
               	
               	
					
					
				}
				
				if(obj[0].catId==2){
					
					for(var i=1; i<15 ; i++){
						
						if(i!=1 &&  i!=3 && i!=6 && i!=7 && i!=13 ){
							
						
							
						var anchk="#anichkid"+i ;
						
					//	$("#anichkid2").prop('checked', true);
					//	$("#anichkid5").prop('checked', true);
					//	$("#anichkid12").prop('checked', true);
						
						//alert("anchk"+anchk);
						$(anchk).prop('checked', true);
						
						}
						
						if(i==1 || i==3 ||  i==7  || i==6 || i==13 ){
							
                             //    alert("i am in   value " +i);
							
							var anchk="#anichkid"+i ;
							
							$(anchk).prop('checked', false);
							
							
													
                            var str="#flani"+i;
                            
                            //$(str).removeAttr("style");
                            
                            //$("#flani13").hide();
							  
							  $(str).hide();
							  
							 // alert("str"+str);
						}
						
						
					}
					
					
				}
				
                if(obj[0].catId==3){
                	
                 	for(var i=1; i<15 ; i++){
                	if(i==13 || i==14){
						var anchk="#anichkid"+i ;
						$(anchk).prop('checked', true);
						
						}
                	
               if(i!=13 && i!=14){
                		
                		var anchk="#anichkid"+i ;
						$(anchk).prop('checked', false);
						
					
						 var str="#flani"+i;
						  
						  $(str).hide();
						
               }
               
          	
                		
                		                	
                	}
					
					
				}
				
				
			
				chkshowdata();
				
			
				
				if(obj[0].regLeftChnnAcres>0){
				
				$("#regLeftChnnAcres").val(obj[0].regLeftChnnAcres);
				}else{
					
					$("#regLeftChnnAcres").val('0.00');
					
				}
				if(obj[0].regRightChnnAcres>0){
				$("#regRightChnnAcres").val(obj[0].regRightChnnAcres);
				}else{
					
					$("#regRightChnnAcres").val('0.00');
					
				}
				if(obj[0].regOthAcres>0){
				$("#regOthAcres").val(obj[0].regOthAcres);
                }else{
					
					$("#regOthAcres").val('0.00');
					
				}
				$("#rainRGStation").val(obj[0].rainRGStation);
				if(obj[0].rainQty>0){
				$("#rainQty").val(obj[0].rainQty);
                     }else{
					
					$("#rainQty").val('0.00');
					
				}
				$("#rainDate").val(obj[0].rainDate);
				
				
				$("#quartName").val(obj[0].quartName);
				$("#quartType").val(obj[0].quartType);
				$("#bldgTypeName").val(obj[0].bldgTypeName);
				$("#bldgDescDamage").val(obj[0].bldgDescDamage);
				if(obj[0].approxRepTemp>0){
				$("#approxRepTemp").val(obj[0].approxRepTemp);
				}else{
					$("#approxRepTemp").val('0.00');
					
				}
				if(obj[0].approxRepPermanent>0){
				$("#approxRepPermanent").val(obj[0].approxRepPermanent);
				}else {
					$("#approxRepPermanent").val('0.00');
					
				}
				if(obj[0].approxRepPermanent>0){
				$("#frmBookValue").val(obj[0].frmBookValue);
				}else{
					$("#frmBookValue").val('0.00');
					
				}
				if(obj[0].effAyacutAcres>0){
				$("#effAyacutAcres").val(obj[0].effAyacutAcres);
				}else {
					$("#effAyacutAcres").val('0.00');
					
				}
				if(obj[0].effAyacutValue>0){
				$("#effAyacutValue").val(obj[0].effAyacutValue);
				}else{
					$("#effAyacutValue").val('0.00');
					
				}
				$("#actionStdCrops").val(obj[0].actionStdCrops);
				$("#damageBreaches").val(obj[0].damageBreaches);
				$("#usefulRemarks").val(obj[0].usefulRemarks);
				$("#tsfcFormDate").val(obj[0].tsfcFormDate);
				
			
	      },
	      error : function(){
	    	  alert(error);
	      }
	  });	
	
	//alert("completed");
	
	
	 for(var h=1; h<15; h++){
		 
			// alert(t+"t");
		 
		 m=h-1;
		 
		 var irrchfrom="#irrChFrm"+m;
		 var irrchto="#irrChTo"+m;
		 var irrl="#irrL"+m;
		 var irrb="#irrB"+m;
		 var irrd="#irrD"+m;
		 var irrpcost="#irrPermcost"+m;
		 var irrtcost="#irrTempcost"+m;
		 var frmdetailId="#formDetailId"+m;
		 
		// alert("m"+m);
		 
		// $(irrsrcname).val(obj[i].irrSrcName);
		 $(irrchfrom).val('0.00');
		 $(irrchto).val('0.00');
		 $(irrl).val('0.00');
		 $(irrb).val('0.00');
		 $(irrd).val('0.00');
		 $(irrpcost).val('0.00');
		 $(irrtcost).val('0.00');
		 $(frmdetailId).val(0);
			 
		
		 }
		 
		// var irrsrcname="#irrSrcName"+m;
		
	
	$.ajax({	          
	      url: "../invtsimis/get-frm-datail?formDataId="+formdataId,
	      type: "GET",
	      async:false,
	     
		    contentType: "application/json; charset=utf-8",
	      success: function (response) {
	    	// alert(response);
	    	  
	    	//  console.log(response);
	    	
	    	
	    	  var j=1;
	    	  
	    	 
			 
			
					var obj = JSON.parse(response);
					
					var k=1;
				
					 for(i in obj){	
						 
						
						 
						 for(var t=0; t<14; t++){
							 
							 var irrsrc="#irrSrcId"+t
							 
							// alert("irrsrc"+irrsrc)
							 
							 var irsrcvalue=$(irrsrc).val();
							 
							 //alert("irsrcvalue"+irsrcvalue)
							 
							 // alert("obj[i].irrSrcId"+obj[i].irrSrcId)
							//
						 
						 if(obj[i].irrSrcId==irsrcvalue){
							
							 
							// alert(t+"t");
						 m=t;
						 }
						 
						 }
						 
						// var irrsrcname="#irrSrcName"+m;
						 var irrchfrom="#irrChFrm"+m;
						 var irrchto="#irrChTo"+m;
						 var irrl="#irrL"+m;
						 var irrb="#irrB"+m;
						 var irrd="#irrD"+m;
						 var irrpcost="#irrPermcost"+m;
						 var irrtcost="#irrTempcost"+m;
						 
						 var frmdetailId="#formDetailId"+m;
						 
						// alert("m"+m);
						 
						// $(irrsrcname).val(obj[i].irrSrcName);
						 if(obj[i].irrChFrm>0){
						 $(irrchfrom).val(obj[i].irrChFrm);
						 }else{
							 
							 $(irrchfrom).val('0.00');
						 }
						 if(obj[i].irrChTo>0){
						 $(irrchto).val(obj[i].irrChTo);
						 }else{
							 
							 $(irrchto).val('0.00');
						 }
						 if(obj[i].irrL>0){
						 $(irrl).val(obj[i].irrL);
						 }else {
							 $(irrl).val('0.00');
							 
						 }
						 if(obj[i].irrB>0){
						 $(irrb).val(obj[i].irrB);
						 }else{
							 
							 $(irrb).val('0.00');
						 }
						 if(obj[i].irrD>0){
						 $(irrd).val(obj[i].irrD);
						 }else{
							 $(irrd).val('0.00');
							 
						 }
						 if(obj[i].irrPermcost>0){
						 $(irrpcost).val(obj[i].irrPermcost);
						 }else{
							 $(irrpcost).val('0.00');
							 
						 }
						 if(obj[i].irrTempcost>0){
						 $(irrtcost).val(obj[i].irrTempcost);
						 }else{
							 $(irrtcost).val('0.00');
							 
						 }
						 
						// alert("alert"+obj[i].formDetailId);
						 if(obj[i].formDetailId>0){
						 $(frmdetailId).val(obj[i].formDetailId);
						 }else{
							 
							 $(frmdetailId).val(0);
							 
						 }
						 
					
						
	          	   j++;
	          	   
					 }
			
	      },
	      error : function(){
	    	  alert(error);
	      }
	  });	
	
	$("#addmichecks8").text( 'Edit');
	$(".updatepht").hide();

}

function chkshowdata(){
	
	var regchk = $('#regchkid').prop('checked');
	
	if(regchk) {
		
		$('#flreg').show();
	}else{
		
		$('#flreg').hide()
	}
	
		
	var rainchk = $('#rainchkid').prop('checked');
	
		if(rainchk) {
			
			$('#flrain').show();
		}else{
			
			$('#flrain').hide()
		}

		
		var bldchk = $('#bldchkid').prop('checked');
	
		if(bldchk) {
			
			$('#flbld').show();
		}else{
			
			$('#flbld').hide()
		}
	
		
		var anchk = $('#anichkid1').prop('checked');
	
		if(anchk) {
			
			//alert("i am anchk"+anchk);
			
			$('#flani1').show();
		}else{
			
			$('#flani1').hide()
		}
	
		
		var wrchk = $('#anichkid2').prop('checked');
		
	
		if(wrchk) {
			
			$('#flani2').show();
		}else{
			
			$('#flani2').hide()
		}
	
		
		var slchk = $('#anichkid3').prop('checked');
	
		if(slchk) {
			
		//	alert("i am slchk"+slchk);
			
			$('#flani3').show();
		}else{
			
			$('#flani3').hide()
		}
	
		
		var retchk = $('#anichkid4').prop('checked');
	
		if(retchk) {
			
			$('#flani4').show();
		}else{
			
			$('#flani4').hide()
		}
	
		
		var aprchk = $('#anichkid5').prop('checked');
	
		if(aprchk) {
			
			$('#flani5').show();
		}else{
			
			$('#flani5').hide()
		}
	
		
		var tkchk = $('#anichkid6').prop('checked');
	
		if(tkchk) {
			
			$('#flani6').show();
		}else{
			
			$('#flani6').hide()
		}

		var chchk = $('#anichkid7').prop('checked');
	
		if(chchk) {
			
			$('#flani7').show();
		}else{
			
			$('#flani7').hide()
		}
	
		
		var earthbundk = $('#anichkid8').prop('checked');
	
		if(earthbundk) {
			
			$('#flani8').show();
		}else{
			
			$('#flani8').hide()
		}
		
		
		var gudechk = $('#anichkid9').prop('checked');
		
		if(gudechk) {
			
			$('#flani9').show();
		}else{
			
			$('#flani9').hide()
		}
		
      var rivetchk = $('#anichkid10').prop('checked');
		
		if(rivetchk) {
			
			$('#flani10').show();
		}else{
			
			$('#flani10').hide()
		}
		
		 var regu = $('#anichkid11').prop('checked');
			
			if(regu) {
				
				//alert("i am canalchk"+canalchk);
				
				$('#flani11').show();
			}else{
				
				$('#flani11').hide()
			}
			
			 var fooldchk = $('#anichkid12').prop('checked');
				
				if(fooldchk) {
					
					//alert("i am canalchk"+canalchk);
					
					$('#flani12').show();
				}else{
					
					$('#flani12').hide()
				}
				
				 var canals = $('#anichkid13').prop('checked');
					
					if(canals) {
						
						//alert("i am canalchk"+canalchk);
						
						$('#flani13').show();
					}else{
						
						$('#flani13').hide()
					}
					
					 var oth = $('#anichkid14').prop('checked');
						
						if(oth) {
							
							//alert("i am canalchk"+canalchk);
							
							$('#flani14').show();
						}else{
							
							$('#flani14').hide()
						}
}


function editformdata(frmname){
	//alert("frmname"+frmname);
	
  var subbutton=	$("#addmichecks8").text();
  
  var tankId=$("#mitankId8").val();
	
	var canId=$("#canalId8").val();
	
//	var canId=$("#canalId").val();
	
	var resId=$("#resId8").val();
	
	var category=$("#catId8").val();
  
  if(subbutton=='Edit'){
	  
	  var valid = "Are you sure you want to update form 20?";
	  
	  if (confirm(valid)) {

	 var customformid="#"+frmname;
	 
	// alert("i am in edit");
	 
	 var m =$('#damageType').val();
	 
	// alert("damageType"+m);
	 
	 $('#formPhotosnew').removeAttr( "required" )
		
			var tankId=$("#tankId").val();
			
	//		var m=$('#inspectDateinflows').val();
	//		alert("inspectDateinflows" + m);
		var nextemp=$("#nextEmpId").val();
		
		 $('#action_alert').empty();
		 
		// $('form[name='+frmname+']').serialize(),
		 
		 var form = $("#michecks8").closest("form");
		 var formData = new FormData(form[0]);
		 
		// console.log("formData"+formData);
		 if ( $('form[id=michecks8]').parsley().isValid() ) {	
		  // var formData = new FormData(document.getElementsByName(frmname));  enctype: 'multipart/form-data',
	 	 $.ajax({	          
		      url: "../invtsimis/editFormData",
		      method:"POST",
		      async: false,
		      data:  formData,
		    
              contentType: false,
              processData: false,
		      
		       
		     
			 
		      success: function (response) {
		   
		    	//alert("kal"+response);
		    	 
		    	 if(response>0){
		    		 
		    	//	alert("i am in kal Data inserttedd Successfully");
		
			  $('#action_alert').html('<p style="margin: 0px !important;">Data Updated Successfully</p>');
				$("html,body").animate({scrollTop:$('#action_alert').offset().top-175}, 500);
				
				  $('#flreg').hide();
				  $('#flrain').hide();
				  
				  $('#flbld').hide();
				  
				  for(var i=1 ; i<15; i++){
					  
					  var str="#flani"+i;
					  
					  $(str).hide();
				  }
				  
				  $("#damageType").val(0);
				  $('#damageType').multiselect('rebuild');
				  
				  $(customformid).trigger("reset"); 	
				  
					getfrmsentlist(tankId,resId,canId)
					
					document.getElementById('mainformcaptcha_id').src = '../captcha.jpg?' + Math.random();  
				 
			    }
				
				if(response==0||response==null){
			    	
			    	  $('#action_alert').html('<p style="margin: 0px !important;">Failed to Update data</p>');
			    		$("html,body").animate({scrollTop:$('#action_alert').offset().top-175}, 500);
			    }
				
				if(response==-3){
		    		
		    		$('#action_alertcan2').html('<p style="margin: 0px !important;">Please Enter the Captcha Text </p>'); 
		    		
		    	}
		    	
           if(response==-2){
		    		
		    		$('#action_alertcan2').html('<p style="margin: 0px !important;">Captcha does not match </p>'); 
		    		
		    	}
		    	    
				
				
				
  },
		      
		      error : function(){
		    	 alert(error);
		    
		      }

		  
		  });   
	 	 
		 }else{
			  
			 
				
				$('form[id=michecks8]').parsley().validate();
				//alert("kal4");
			
	  }
		 return true;
	  }
      else{
      	
      	return false;
        
      }
	 	 
  }
  

	
}

function editphotosdatafn(formdataId){
	
	 
	
	 $('#frm20_doc_update').dialog('option', 'title', 'Update Photos');
	  $('#frm20_doc_update').dialog('open');
	  
	  
	  $('#action_alert').empty();
		 
		 $("#editformdataId").val(formdataId);
	  
	
		  document.getElementById('photocaptcha_id').src = '../captcha3.jpg?' + Math.random();  
	
	
}


function updatephotosdatafn(formname){
	
//	alert("form name "+fromname);
	  $('#action_alert').empty();
	
  var customformid="#editdoc9";
	  
	  var form = $("#editdoc9").closest("form");
		 var formData = new FormData(form[0]);
		 var valid = "Are you sure you want to submit?";
		  if (confirm(valid)) { 
		 
		  if ( $('form[name='+formname+']').parsley().isValid() ) {	
			
	  $.ajax({	          
	      url: "../invtsimis/updatephotos",
	      method:"POST",
	      async: false,
	      data:  formData,
	    
          contentType: false,
          processData: false,
	      success: function (response) {
	    	  
	    	  if(response>0){
		    		 
			    	//	alert("i am in kal Data inserttedd Successfully");
			
				  $('#action_alert').html('<p style="margin: 0px !important;">Photos updated Successfully</p>');
				  $('#frm20_doc_update').dialog('close'); 
					$("html,body").animate({scrollTop:$('#action_alert').offset().top-175}, 500);
					
					 $(customformid).trigger("reset"); 	
					 
				    }
					
					if(response==0||response==null){
				    	
				    	  $('#action_alert').html('<p style="margin: 0px !important;">Failed to Update data</p>');
				    		$("html,body").animate({scrollTop:$('#action_alert').offset().top-175}, 500);
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
	  
		  }else{
			  
				 
				
				$('form[name='+formname+']').parsley().validate();
				//alert("kal4");
			
	  }
			  return true;
			  
		  }
	       else{
	       	
	       	return false;
	         
	       }
}


function deletefrmphtfn(formdataId){
	
	
	 $('#frm20_doc_dia').dialog('option', 'title', 'View/ Delete Photos');
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
		    	    		
		    	    		' <th>Delete </th>'+
		    	    		
		    	    		
		    	    		'</tr>'); 	 
				 
				
						var obj = JSON.parse(response);
						$.each(obj, function(key, value) {
							
							
							  $('#docfrm20 table tbody').append(  '<tr style="font-size: 16px">' +
		                                '<td style="text-align: center;">'+j+'</td>' +
		                                
		                                '<td><b>'+value.formDocOriginalName+'</b></td>' +
		                               
		                                '<td style="color:blue"><b><a target="_blank" href="../invtsimis/viewphotos?fileName=' + value.formDocName + '" download><u>Download File<u></a></b></td>' +
		                                
		                               
		                             
		                                /*'<td><b>'+obj[i].latestRemarks+'</b></td>' +*/
		                                '<td><b><button type="button" name="deletedoc" id="deletedoc'+j+'" class="btn btn-1 btn-primary center-block docview"  onclick="deletedocfn('+value.formdocId+','+formdataId+')"  >Delete File</button> </b></td>' +
		                               	                               
		                               
		                                '</tr>');
						
							   j++;
							  
							 
						});

		      },
		      error : function(){
		    	  alert(error);
		      }
		  });	
		
	
}

function deletedocfn(formdocId,formdataId){
	
	 $('#action_alert').empty();
	 var valid = "Are you sure you want to delete document?";
	 if (confirm(valid)) {
	 $.ajax({	          
	      url: "../invtsimis/del-frm-docs?formdocId="+formdocId,
	      method:"POST",
	      async: false,    
        
	      success: function (response) {
	    	  
	    	  if(response>0){
		    		 
			    	//	alert("i am in kal Data inserttedd Successfully");
	    		  
	    		  deletefrmphtfn(formdataId);
			
				  $('#action_alert').html('<p style="margin: 0px !important;">Photos Deleted Successfully</p>');
				
					$("html,body").animate({scrollTop:$('#action_alert').offset().top-175}, 500);
					
					
					 
				    }
					
					if(response==0||response==null){
				    	
				    	  $('#action_alert').html('<p style="margin: 0px !important;">Failed to Delete Photo</p>');
				    		$("html,body").animate({scrollTop:$('#action_alert').offset().top-175}, 500);
				    }
					
					 $(customformid).trigger("reset"); 	
					
	      },
	      error : function(){
	    	  alert(error);
	      }
	  });	
	 
	 return true;  
	
	 }
     else{
     	
     	return false;
       
     }
	
}


function deletefrmdatafn(formdataId,tankId,resId,canId){
	
	 $('#action_alert').empty();
	 
	 var valid = "Are you sure you want to delete form 20?";
	   if (confirm(valid)) {
	 $.ajax({	          
	      url: "../invtsimis/del-frm-data?formDataId="+formdataId,
	      method:"POST",
	      async: false,    
       
	      success: function (response) {
	    	  
	    	  if(response>0){
		    		 
			    	//	alert("i am in kal Data inserttedd Successfully");
			
				  $('#action_alert').html('<p style="margin: 0px !important;">Form 20 Deleted Successfully</p>');
				
					$("html,body").animate({scrollTop:$('#action_alert').offset().top-175}, 500);
					
					getfrmsentlist(tankId,resId,canId)
					 
				    }
					
					if(response==0||response==null){
				    	
				    	  $('#action_alert').html('<p style="margin: 0px !important;">Failed to Delete Form 20</p>');
				    		$("html,body").animate({scrollTop:$('#action_alert').offset().top-175}, 500);
				    }
					
					 $(customformid).trigger("reset"); 	
					
	      },
	      error : function(){
	    	  alert(error);
	      }
	  });	
	
	 return true;  
     
       }
       else{
       	
       	return false;
         
       }
	
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



window.Parsley.addValidator('uppercase', {
	  requirementType: 'number',
	  validateString: function(value, requirement) {
	    var uppercases = value.match(/[A-Z]/g) || [];
	    return uppercases.length >= requirement;
	  },
	  messages: {
	    en: 'Your Canal Name must contain at least (%s) uppercase letter.'
	  }
	});

	
});

//form 20 functions end

//reservoir start

function showtankdata (tankName,tankId,tankCode,districtId,mcode,vcode,acode,hcode,manName,villName,formId){
	
	
	var projectId=0;
	 $('#tanksflitems').show();
	 
	 
	

	
	$('#tankId').val(tankId);
	
	// $('#tankdata').html('<p style="margin: 0px !important; font-weight:bold; color:blue">'+tankCode+'-'+tankName+'</p>');
	// $('#mandata').html('<p style="margin: 0px !important; font-weight:bold; color:blue">'+manName+'</p>');
	// $('#villdata').html('<p style="margin: 0px !important; font-weight:bold; color:blue">'+villName+'</p>');
	 var tanknewname=tankCode+"-"+tankName ; 
	 $('#mandata').val(manName);
	 $('#villdata').val(villName);
	 $('#tankdata').val(tanknewname);
	 
	
	  
	 
	 
	
	
	  
	  var tankId = tankId;
	
	  if(tankId>0){
		  
		 
		  
		  
		  $('#canMainDistrictId').val(0);
			 $('#canmainprojectId').val(0);
			 $('#canalId').val(0);
			  $('#canalId').multiselect('rebuild');
			 $('#resId').val(0);
			 
			 $('#resmainprojectId').val(0);
			 
			 $('#resMainDistrictId').val(0);
			 
			 
			 

	 
	  $('#mitankId8').val(tankId);
	  
	  $('#resId8').val(0);
	  
	  $('#canalId8').val(0);
	  
	  $('#catId8').val(1);
	  
	  $('#projectId8').val(0);
	  
	  $('#frm20').show();
	
	  
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
		 $('#pmscaninfo').hide();
		 
		 $('#srcleft1').show();
		 $('#srcleft2').show();
		 $('#srcleft3').show();
		 $('#srcleft4').show();
		 $('#srcleft5').show();
		 $('#srcleft6').show();
		 $('#srcleft7').show();
		 $('#srcleft8').hide();
		 
		 $('#srcleft9').hide();
		 $('#srcleft10').hide();
		 $('#srcleft11').hide();
		 $('#srcleft12').hide();
		 $('#srcleft13').hide();
		 $('#srcleft14').show();
	 }else{
		 
		 $('#mkinfo').hide();
		 
		 $('#srcleft1').hide();
		 $('#srcleft2').hide();
		 $('#srcleft3').hide();
		 $('#srcleft4').hide();
		 $('#srcleft5').hide();
		 $('#srcleft6').hide();
		 $('#srcleft7').hide();
		 $('#srcleft8').hide();
		 $('#srcleft14').hide();
	 }
	 
	 
	
}

function showprojectsdata(projectName,projectId,reservoirId,reservoirName,unitId,formId){
	
	//alert("kal");
	
	//alert("reservoirId"+reservoirId);
	
	 $('#tanksflitems').show();
	
	 $('#projectName').val(projectName);
	 $('#reservoirName').val(reservoirName);
	 $('#resmainprojectId').val(projectId);
	 $('#resId').val(reservoirId);
	 
	 $('#frm20').hide();
	
	 
	 $('#projectId8').val(projectId);
	 getDistricts(1);
	 
	 
	 
	 if(reservoirId>0){
		 
			//	 alert("reservoirId"+reservoirId+"-22----"+reservoirName) 
				 
				 $('#canMainDistrictId').val(0);
				 $('#canmainprojectId').val(0);
				 $('#canalId').val(0);
				  $('#canalId').multiselect('rebuild');
				 $('#tankId').val(0);
				 
				 getResList(reservoirId);
				 
				 $('#resdianew').val(reservoirName);
				 
				 
				 $('#mitankId8').val(0);
				  $('#resId8').val(reservoirId);
				  
				  $('#canalId8').val(0);
				  
				  $('#catId8').val(2);
				  
				  $('#resdia').val(reservoirName);
				  
				 
			 }
	 
	
	 
	 $('#getprojects').trigger("reset"); 
	 
	 if(formId==4){
		 
		// alert("formId"+formId);
		 
		 $('#getprojects_dialogue').dialog('close');
		
		 
		 $('#pmsresinfo').show();
		 $('#mkinfo').hide();
		 $('#pmscaninfo').hide();
		 
		 $('#srcleft1').hide();
		 $('#srcleft3').hide();		
		 $('#srcleft2').show();		
		 $('#srcleft4').show();
		 $('#srcleft5').show();
		 $('#srcleft6').hide();
		 $('#srcleft7').hide();
		 $('#srcleft8').show();
		 $('#srcleft9').show();
		 $('#srcleft10').show();
		 $('#srcleft11').show();
		 $('#srcleft12').show();
		 $('#srcleft13').hide();
		 $('#srcleft14').show();
		 
		 
		 
	 }else {
		 $('#pmsresinfo').hide();
		 
		 
		 
		 $('#srcleft2').hide();		
		 $('#srcleft4').hide();
		 $('#srcleft5').hide();
		
		
		 $('#srcleft8').hide();
		 $('#srcleft9').hide();
		
		 $('#srcleft10').hide();
		
		 $('#srcleft12').hide();
		 $('#srcleft11').hide();
		 $('#srcleft14').hide();
		
		 
	 }
	 
	 
	
	 
	 
	
	
}

function showprojectscandata(projectName,projectId,formId){
	
	 getDistricts(2);
	
	 $('#projectNamecan').val(projectName);
	 $('#tanksflitems').show();
	 $('#projectId8').val(projectId);
	 
	 $('#canmainprojectId').val(projectId);
	 
	 $('#frm20').hide();
	 
	 
	 
	 $('#canProjectId').val(projectId);
	 
	 $('#canProjectId2').val(projectId);
	 
	 getResListByProjId();
	 
	 
	 
	 $('#mitankId8').val(0);
	 
	 if(projectId>0){
		 
		 $('#resMainDistrictId').val(0);
		 $('#resmainprojectId').val(0);
		 $('#resId').val(0);
		 $('#tankId').val(0);
		 
		
		 
		 
		 $('#mitankId8').val(0);
		  $('#resId8').val(0);
		  
		  $('#canalId8').val(canalId);
		  
		  $('#catId8').val(3);
		  
		 // alert("projectId canal"+projectId);
		  
		  getCanalsList(projectId);
		  getCanalsInfo(projectId,1);
	 }
	 
	 
	 
if(formId==5){
		 
		 $('#getprojectscanals_dialogue').dialog('close');
		 
		 
		 
		
		 
		 $('#pmscaninfo').show();
		 $('#pmsresinfo').hide();
		 $('#mkinfo').hide();
		 
		 $('#srcleft1').hide();
		 $('#srcleft2').hide();
		 $('#srcleft3').hide();
		 $('#srcleft4').hide();
		 $('#srcleft5').hide();
		 $('#srcleft6').hide();
		 $('#srcleft7').hide();
		 $('#srcleft8').hide();
		 $('#srcleft9').hide();
		 $('#srcleft10').hide();
		 $('#srcleft11').hide();
		 $('#srcleft12').hide();
		 $('#srcleft13').show();
		 $('#srcleft14').show();
		 
		 
		 
	 }else {
		 $('#pmscaninfo').hide();
		 
		 $('#srcleft13').hide();
		 $('#srcleft14').hide();
		 
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
	    	  
	    	  if(hkey==2){
		    	  var $select = $('#candistrictId');
				  $select.find('option').remove();
				  
				  var canselectedDistrict=$('#canselectedDistrictId').val();
				// alert("selected"+canselectedDistrict);
				 
				  $('#candistrictId').append( '<option value=" "> --select--</option>' );
				  
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
						
						  if(hkey==2){
						
						if(canselectedDistrict==parseInt(value.districtId)){	
							//alert("coming1");
							$('#candistrictId').append( '<option value="'+parseInt(value.districtId)+'" selected="selected" > '+value.districtName+'</option>' );
						}
						if(canselectedDistrict==null||canselectedDistrict!=parseInt(value.districtId)){
							//alert("coming2");
							$('#candistrictId').append( '<option value="'+parseInt(value.districtId)+'"  > '+value.districtName+'</option>' );
						
						}
						
		  					
	  	  				$('#candistrictId').multiselect('rebuild');
	  	  				
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

if(hkey==2){
	
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
	    	  
	    	  if(hkey==2){
		    	  var $select = $('#canmandalId');
				  $select.find('option').remove();
				  
				  var canselectedMandal=$('#canselectedMandalId').val();
				// alert("selected"+canselectedMandal);
				 
				  $('#canmandalId').append( '<option value=" "> --select--</option>' );
				  
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
						
						  if(hkey==2){
						
						if(canselectedMandal==parseInt(value.mandalCode)){	
							//alert("coming1");
							$('#canmandalId').append( '<option value="'+parseInt(value.mandalCode)+'" selected="selected" > '+value.mandalName+'</option>' );
						}
						if(canselectedMandal==null||canselectedMandal!=parseInt(value.mandalCode)){
							//alert("coming2");
							$('#canmandalId').append( '<option value="'+parseInt(value.mandalCode)+'"  > '+value.mandalName+'</option>' );
						
						}
						
		  					
	  	  				$('#canmandalId').multiselect('rebuild');
	  	  				
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
	    	if(hkey==2){
		    	  var $select = $('#canvillageId');
		    	 
				  $select.find('option').remove();
				  
				 
				  var canselectedVillage=$('#canselectedVillageId').val();
				 
						var obj = JSON.parse(response);
						  $('#canvillageId').append( '<option value="0"> --select--</option>' );
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
						
							//$('#resvillageId').append( '<option value="'+parseInt(value.villageCode)+'" > '+value.villageName+'</option>' );
					
	  	  				$('#resvillageId').multiselect('rebuild');
	  	  				
						}
						if(hkey==2){
							
							if(canselectedVillage==parseInt(value.villageCode)){	
								//alert("coming1");
								$('#canvillageId').append( '<option value="'+parseInt(value.villageCode)+'" selected="selected" > '+value.villageName+'</option>' );
							}
							if(canselectedVillage==null||canselectedVillage!=parseInt(value.villageCode)){
								//alert("coming2");
								$('#canvillageId').append( '<option value="'+parseInt(value.villageCode)+'" > '+value.villageName+'</option>' );
							
							}
							
							
					
	  	  				$('#canvillageId').multiselect('rebuild');
	  	  				
						}
					});
	    	 

	      },
	      error : function(){
	    	  alert(error);
	      }
	  }); 	
	}
	

//reservoir end 
	
	
function addCanals(){
		
		var editinfo=$('#editFlag2').val();
		
		if(editinfo=="false"){
		
 var projectId =   $('#canmainprojectId').val();  
		 
		
		
		  if ($('form[name=addcanalsloc2form]').parsley().isValid()) {  
		 
		// alert("editrepairCompId"+$('#editrepairCompId').val());
		// alert("editunitMeasureId"+$('#editunitMeasureId').val());
		/* if ($('form[name=weirform]').parsley().isValid()) {  */
				$.ajax({	          
				      url: "../invtsimis/add-canals",
				      method:"POST",
					   dataType: 'json',				
				      async: false,
				      data: $('form[name=addcanalsloc2form]').serialize(),   
				      success: function (msg) {
				    	  
				    	// console.log(msg);
				    	  
				    	 // alert("msg"+msg);
				    	 
				    	if(msg>0) {
				    		
						 
						  
						 
						  
						  $('#action_alertcan2').html('<p style="margin: 0px !important;" >Canal  added Successfully</p>'); 
						 // $("html,body").animate({scrollTop:0}, 500);
						  
						 // alert("projectId in add canals"+projectId)
						  getCanalsNameedit(projectId);
						  getCanalsList(projectId);
						  
						  $('#addcanalsloc2').trigger("reset"); 
						  
						  $('#canalReservoirId option:selected').each(function() {
						        $(this).prop('selected', false);
						        $(this).val(0);
						    })
						    
						    
						    $('#canalReservoirId').multiselect('rebuild');
						  
						  $('#canalTypeId option:selected').each(function() {
						        $(this).prop('selected', false);
						        $(this).val(0);
						    })
						    $('#canalTypeId').multiselect('rebuild');
						  
						  $('#canalName').val(' ');
						  
						  
						  
						  document.getElementById('cancaptcha_id').src = '../captcha2.jpg?' + Math.random();  
						  return false;
				    	 
				    	}
				    	 
				    	if(msg==0) {
				    		
						 // $('#editcheckformid').trigger("reset"); 
						  
						

						  $('#action_alertcan2').html('<p style="margin: 0px !important;">Failed to add canal </p>'); 
						 // $("html,body").animate({scrollTop:0}, 500);
				    	 
				    	}
				    	if(msg==-3){
				    		
				    		$('#action_alertcan2').html('<p style="margin: 0px !important;">Please Enter the Captcha Text </p>'); 
				    		
				    	}
				    	
                   if(msg==-2){
				    		
				    		$('#action_alertcan2').html('<p style="margin: 0px !important;">Captcha does not match </p>'); 
				    		
				    	}
                   
                   if(msg==-4){
			    		
			    		$('#action_alertcan2').html('<p style="margin: 0px !important;">Canal Name exists. please use same canal name. </p>'); 
			    		
			    	}
				    	    
				    	
				    	 

				      },
				      error : function(){
				    	  alert(error);
				      }
				  });
				
		  }
				
		 else {
				
				$('form[name=addcanalsloc2form]').parsley().validate();
				//alert("kal4");
			}
		  
		}
		
		if(editinfo=="true"){
				
				//alert("coming to edit");
				
				UpdateCanalInfo();
				
			}
		
		
	}
	
	function addCanalLocation(){
		
		var editinfo=$('#editFlag').val();
		
		var projectId=$('#canProjectId').val();
		
		if(editinfo=="false"){
		

		 
		
		
		  if ($('form[name=addcanalslocform]').parsley().isValid()) {  
		 
		// alert("editrepairCompId"+$('#editrepairCompId').val());
		// alert("editunitMeasureId"+$('#editunitMeasureId').val());
		/* if ($('form[name=weirform]').parsley().isValid()) {  */
				$.ajax({	          
				      url: "../invtsimis/add-canalloc",
				      method:"POST",
					   dataType: 'json',				
				      async: false,
				      data: $('form[name=addcanalslocform]').serialize(),   
				      success: function (msg) {
				    	  
				    	// console.log(msg);
				    	 
				    	if(msg>0) {
				    		
						  $('#addcanalsloc').trigger("reset"); 
						  
				
						  $('#action_alertcan').html('<p style="margin: 0px !important;" >Canal Location added Successfully</p>'); 
						 // $("html,body").animate({scrollTop:0}, 500);
						  
						  getCanalsInfo(projectId,1);
						  
						  document.getElementById('cancaptcha_id2').src = '../captcha3.jpg?' + Math.random();  
						  
						  getCanalsList(projectId);
						  
						  $('#canalId option:selected').each(function() {
						        $(this).prop('selected', false);
						    })
						    
						    
						    $('#canalId').multiselect('rebuild');
						  
						  $('#candistrictId option:selected').each(function() {
						        $(this).prop('selected', false);
						        $(this).val(0);
						    })
						    $('#candistrictId').multiselect('rebuild');
						  $('#canmandalId option:selected').each(function() {
						        $(this).prop('selected', false);
						        $(this).val(0);
						    })
						    $('#canmandalId').multiselect('rebuild');
						  $('#canvillageId option:selected').each(function() {
						        $(this).prop('selected', false);
						        $(this).val(0);
						    })
						    $('#canvillageId').multiselect('rebuild');
						 // $('#canalId').val(0);
						 // $('#canalId').multiselect('rebuild');
						//  $('#candistrictId').val(0);
						//  $('#candistrictId').multiselect('rebuild');
						 // $('#canmandalId').val(0);
						 // $('#canmandalId').multiselect('rebuild');
						 // $('#canvillageId').val(0);
						 // $('#canvillageId').multiselect('rebuild');
						  
						  $('#canreamarksVillageName').val('');
						  
						  
						  return false;
				    	 
				    	}
				    	 
				    	if(msg==0 || msg==null) {
				    		
						 // $('#editcheckformid').trigger("reset"); 
						  
					

						  $('#action_alertcan').html('<p style="margin: 0px !important;">Failed to add canal Location</p>'); 
						 // $("html,body").animate({scrollTop:0}, 500);
				    	 
				    	}	
				    	
	                  if(msg==-3){
				    		
				    		$('#action_alertcan').html('<p style="margin: 0px !important;">Please Enter the Captcha Text </p>'); 
				    		
				    	}
				    	
                   if(msg==-2){
				    		
				    		$('#action_alertcan').html('<p style="margin: 0px !important;">Captcha does not match </p>'); 
				    		
				    	}
				    	    
				    	
				    	 

				      },
				      error : function(){
				    	  alert(error);
				      }
				  });
				
		  }
				
		 else {
				
				$('form[name=addcanalslocform]').parsley().validate();
				//alert("kal4");
			}
		  
		}
		
		if(editinfo=="true"){
				
				//alert("coming to edit");
				
				UpdateCanalLocInfo();
				
			}
		
		
	}
	
	
	function UpdateCanalInfo(){
		
		//alert("UpdateSeaAyacutInfo");
		
		var projectId=$('#canProjectId').val();
		
		if ($('form[id=addcanalsloc2]').parsley().isValid()) {
		
		var finaldatatoSend=$('form[id=addcanalsloc2]').serialize();
		
			 
			 $.ajax({	          
					url: "../invtsimis/update_canals" ,
					method:"GET",
					dataType: 'json',

					async: false,
					   data:finaldatatoSend,


					success: function (obj) {

						  
						if(obj!=null || obj>0 ){
							
							 $('#action_alertcan2').html('<p style="margin: 0px !important;">Updated Data Successfully</p>');
							 //$("html,body").animate({scrollTop:0}, 500);
							 
							  $('#addcanalsloc2').trigger("reset"); 
							
							 
							 
							
							  getCanalsNameedit(projectId);
							  getCanalsInfo(projectId,1);
							  getCanalsList(projectId);
							  
							  $('#canalReservoirId option:selected').each(function() {
							        $(this).prop('selected', false);
							        $(this).val(0);
							    })
							    
							    
							    $('#canalReservoirId').multiselect('rebuild');
							  
							  $('#canalTypeId option:selected').each(function() {
							        $(this).prop('selected', false);
							        $(this).val(0);
							    })
							    $('#canalTypeId').multiselect('rebuild');
							  
							  $('#canalName').val(' ');
							  document.getElementById('cancaptcha_id').src = '../captcha2.jpg?' + Math.random();  
							  return false;
							 
							}
							
							if(obj==0 || obj==null){
								 $('#action_alertcan2').html('<p style="margin: 0px !important;">Failed to Update data</p>');
								// $("html,body").animate({scrollTop:0}, 500);
							} 
							 if(obj==-3){
						    		
						    		$('#action_alertcan2').html('<p style="margin: 0px !important;">Please Enter the Captcha Text </p>'); 
						    		
						    	}
						    	
		                   if(obj==-2){
						    		
						    		$('#action_alertcan2').html('<p style="margin: 0px !important;">Captcha does not match </p>'); 
						    		
						    	}
						    	
				
					},
					error : function(){
						 alert(error);

					}
					}); 
			 
		}else{
	    	 
	    	 $('form[id=addcanalsloc2]').parsley().validate();
	    	 
	     }
		
	}
	
	
function UpdateCanalLocInfo(){
		
		//alert("UpdateSeaAyacutInfo");
		
		var projectId=$("#canProjectId").val();
		//alert("UpdateCanalLocInfo"+projectId);
		
		if ($('form[id=addcanalsloc]').parsley().isValid()) {
		
		var finaldatatoSend=$('form[id=addcanalsloc]').serialize();
		
			 
			 $.ajax({	          
					url: "../invtsimis/update_canal_location" ,
					method:"GET",
					dataType: 'json',

					async: false,
					   data:finaldatatoSend,


					success: function (obj) {

						  
						if( obj>0 ){
							
							 getCanalsInfo(projectId,1);
							
							 $('#action_alertcan').html('<p style="margin: 0px !important;">Updated Data Successfully</p>');
							// $("html,body").animate({scrollTop:0}, 500);
							 
							  $('#addcanalsloc').trigger("reset"); 
							
							 
							  
							  document.getElementById('cancaptcha_id2').src = '../captcha3.jpg?' + Math.random();  
							  
							  getCanalsList(projectId);
							  
							  $('#canalId option:selected').each(function() {
							        $(this).prop('selected', false);
							    })
							    
							    
							    $('#canalId').multiselect('rebuild');
							  
							  $('#candistrictId option:selected').each(function() {
							        $(this).prop('selected', false);
							        $(this).val(0);
							    })
							    $('#candistrictId').multiselect('rebuild');
							  $('#canmandalId option:selected').each(function() {
							        $(this).prop('selected', false);
							        $(this).val(0);
							    })
							    $('#canmandalId').multiselect('rebuild');
							  $('#canvillageId option:selected').each(function() {
							        $(this).prop('selected', false);
							        $(this).val(0);
							    })
							    $('#canvillageId').multiselect('rebuild');
							 // $('#canalId').val(0);
							 // $('#canalId').multiselect('rebuild');
							//  $('#candistrictId').val(0);
							//  $('#candistrictId').multiselect('rebuild');
							 // $('#canmandalId').val(0);
							 // $('#canmandalId').multiselect('rebuild');
							 // $('#canvillageId').val(0);
							 // $('#canvillageId').multiselect('rebuild');
							  
							  $('#canreamarksVillageName').val('');
							  
							  
							  return false;
							 
							}
							
							if(obj==0 || obj==null){
								 $('#action_alertcan').html('<p style="margin: 0px !important;">Failed to Update data</p>');
								// $("html,body").animate({scrollTop:0}, 500);
							} 
							
							 if(obj==-3){
						    		
						    		$('#action_alertcan').html('<p style="margin: 0px !important;">Please Enter the Captcha Text </p>'); 
						    		
						    	}
						    	
		                   if(obj==-2){
						    		
						    		$('#action_alertcan').html('<p style="margin: 0px !important;">Captcha does not match </p>'); 
						    		
						    	}
						    	
				
					},
					error : function(){
						 alert(error);

					}
					}); 
			 
		}else{
	    	 
	    	 $('form[id=addcanalsloc]').parsley().validate();
	    	 
	     }
		
	}

	
	
	
	function getCanalsList(projectId){
		
		// var projectId =   $('#projectId').val();  
		$("#canalId8").val(0);
				
				//alert("projectId"+projectId);
				
						$.ajax({	          
						      url: "../invtsimis/get-canalsnotinloc",
						      method:"POST",
							   dataType: 'json',				
						      async: false,
						      data: {projectId:projectId},
						      success: function (msg) {
						    	  
						    	  var len = msg.length;
								  
								  //alert(len);
								
								
								if(len>0){
						    	  
						    
						    
						    	
							    	  var $select = $('#canalId');
							    	 
									  $select.find('option').remove();
									  
									 
									
									 
											//var obj = JSON.parse(msg);
											  $('#canalId').append( '<option value=" "> --select--</option>' );
							    
							    
											  if(msg!==null){	  
											$.each(msg, function(key, value) {
												
												
												
													$('#canalId').append( '<option value="'+parseInt(value.canalId)+'" > '+value.canalName+'</option>' );
											
							  	  				$('#canalId').multiselect('rebuild');
										
											
											
												
												
											});
											  }
											  
											 
										    	
										    	//  $('#shaddcanalsinf').show();	
												//  $('#sheditcanalsinfo').hide();
											  
											 
											  
											 
						    	
								}
								 if(len==0){	
									 
									
									 
									 $('#canselectedDistrictId').val(0);	
									 
									 
									// $('#canalId').val(0);
									 var $selectnew = $('#canalId');
							    	 
									  $selectnew.find('option').remove();
									  $('#canalId').multiselect('rebuild');
									
								  }

						      },
						      error : function(){
						    	  alert(error);
						      }
						  });
						
				
				  
				
				
				
			}
	
	
function getCanalsLocation(canalId,canalLocId){
	
var canalId=canalId;
var canalLocId=canalLocId;

		
		// var projectId =   $('#projectId').val();  
	
	//var userunit=$('#userunit').val(); 
	//var usercircle=$('#usercircle').val(); 
	//var userdivision=$('#userdivision').val(); 
	//var usersubdivision=$('#usersubdivision').val(); 
	//var userpost=$('#userpost').val(); 
				 
				
				//alert("canalId"+canalId);
				
						$.ajax({	          
						      url: "../invtsimis/get-canal-location",
						      method:"POST",
							   dataType: 'json',				
						      async: false,
						      data: {canalId:canalId,canalLocId:canalLocId},
						      success: function (msg) {
						    	  
						    	//console.log(msg);
						    	 var len=msg.length;
						    	
							    //	alert(msg);		
							    	
							  	  if(len>0){	
							  		  
							  		 /// var dbunit=msg[0].unitId;
							  		  
							  		 // alert("dbunit"+dbunit);
							  			  
							  		//  var dbcircle=msg[0].circleId;
							  			  
							  		//   var dbdivision=msg[0].divisionId;
							  	//	var dbsubdivision=msg[0].subdivisionId;
							  		
							  	//	var dbpost=msg[0].postId;
							  		
							  		var districtId=msg[0].districtId;
							  		
							  		var canlocId=msg[0].canalLocId;
							  		
							  		var canchfromkm=msg[0].chainageFromkm;
							  		
							  		var canchtokm=msg[0].chainageTokm;
							  		
							  		var canaltype=msg[0].canalType;
							  		
							  
							  		var canalname=msg[0].canalName +'@'+canaltype+'@ch.From'+canchfromkm+'km@ch.To'+canchtokm+'km';
									
							    	$('#districtNamecan').val(msg[0].districtName); 
							    	$('#mandalNamecan').val(msg[0].mandalName);  
							    	$('#canMainDistrictId').val(districtId);
							    	
							   	     $('#canalNamecan').val(canalname);
							    	
							    	$("#canalId8").val(msg[0].canalId);
							    	
							    	$("#canalLocId8").val(msg[0].canalLocId);
							    	
							    	
							    	
							    	 $('#canselectedDistrictId').val(districtId);	
							    	
							    	
							    	if(msg[0].villageId>0){
							    	$('#villageNamecan').val(msg[0].villageName); 
							    	}
							    	
							    	if(msg[0].villageId==0){
								    	$('#villageNamecan').val(msg[0].remarksVillage); 
								    	}
							    			//var obj = JSON.parse(msg);
							    	
							    /*	if(dbunit==userunit && dbcircle==usercircle && dbdivision==userdivision && dbsubdivision==usersubdivision && dbpost==userpost){
							    		
							    	 $('#sheditcanalsinfo').show();	
							    
							    	}*/
							    	
							    	if(districtId>0){
							    		
							    		 // $('#shaddcanalsinf').show();	
							    		  
							    		  
							    		  
							    		  
							    		  $('#frm20').show();
							    		  
							    			
									  		$('#irrChFrm12').val(canchfromkm); 
									  		$('#irrChTo12').val(canchtokm); 
									  		
										 
							    	}
										
										
											  }
											  
											  if(len==0){	
												  
												//  $('#shaddcanalsinf').show();	
												 // $('#sheditcanalsinfo').hide();
												  
												  $('#canMainDistrictId').val(0);
												  
													$('#districtNamecan').val(''); 
													$('#mandalNamecan').val('');  
												
													$('#villageNamecan').val(''); 
													 $('#canalNamecan').val('');
													
													$("#canalId8").val(0);
													$("#canalLocId8").val(0);
												  
												 // alert("i am here");
													
													  $('#frm20').hide();
												  
												//  $('#canalId').multiselect('rebuild');
											  
											  }
											  
											 
						    	 

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


/*function getCanalsLocation(resId){
	
	// var projectId =   $('#projectId').val();  

var userunit=$('#userunit').val(); 
var usercircle=$('#usercircle').val(); 
var userdivision=$('#userdivision').val(); 
var usersubdivision=$('#usersubdivision').val(); 
var userpost=$('#userpost').val(); 
			 
			
			//alert("canalId"+canalId);
			
					$.ajax({	          
					      url: "../invtsimis/get-res-location",
					      method:"POST",
						   dataType: 'json',				
					      async: false,
					      data: {resId:resId},
					      success: function (msg) {
					    	  
					    	//console.log(msg);
					    	 
					    	
						    //	alert(msg);		
						    	
						  	  if(msg!==null){	
						  		  
						  		  var dbunit=msg[0].unitId;
						  		  
						  		 // alert("dbunit"+dbunit);
						  			  
						  		  var dbcircle=msg[0].circleId;
						  			  
						  		   var dbdivision=msg[0].divisionId;
						  		var dbsubdivision=msg[0].subdivisionId;
						  		
						  		var dbpost=msg[0].postId;
						  		
								
						    	$('#districtNameres').val(msg[0].districtName); 
						    	$('#mandalNameres').val(msg[0].mandalName);  
						    	
						    	if(msg[0].villageId>0){
						    	$('#villageNameres').val(msg[0].villageName); 
						    	}
						    	
						    	if(msg[0].villageId==0){
							    	$('#villageNameres').val(msg[0].remarksVillage); 
							    	}
						    			//var obj = JSON.parse(msg);
						    	
						    	if(dbunit==userunit && dbcircle==usercircle && dbdivision==userdivision && dbsubdivision==usersubdivision && dbpost==userpost){
						    		
						    	 $('#sheditcanalsinfo').show();	
						    
						    	}
									
									
										  }
										  
										  if(msg===null){	
											  
											//  $('#canalId').multiselect('rebuild');
										  
										  }
										
					    	
					    	 

					      },
					      error : function(){
					    	  alert(error);
					      }
					  });
					
			
			  
			
			
			
		}*/


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
					  		 
					  		
					  		 
					  		//alert("projectId"+projectId);
					  		 
					  
					  			  
					  		
					  		//$('#resProjectId').val(projectId);
					  		
					  	
					  		if(parseInt(districtId)>0){
					  			
					  			 $('#frm20').show();
						  		$('#resdistrictId').val(districtId);
						  		
						  		$('#resdistrictId').multiselect('rebuild');
						  		
						  		$('#resselectedDistrictId').val(districtId);
						  		
						  		
						  		
						  		
						  		$('#resselectedMandalId').val(mandalId);
						  		$('#resselectedVillageId').val(villageId);
						  		
						  		$('#resMainDistrictId').val(villageId);
						  		
						  		
						  		
						  		
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



function getResListByProjId(){
	
	// var projectId =   $('#projectId').val();  

			var projectId=$("#canProjectId").val();
			
			//alert("projectId in gerreslist"+projectId);
		
					$.ajax({	          
					      url: "../invtsimis/get_res_list_projid",
					      method:"POST",
						   dataType: 'json',				
					      async: false,
					      data: {projectId:projectId},
					      success: function (msg) {
					    	  
					    	
					    	  var len = msg.length;
							  
							  //alert(len);
							
							
							if(len>0){
					    	  
					    
					    
					    	
						    	  var $select = $('#canalReservoirId');
						    	 
								  $select.find('option').remove();
								  
								 
								
								 
										//var obj = JSON.parse(msg);
										  $('#canalReservoirId').append( '<option value="0"> --select--</option>' );
						    
						    
										  if(msg!==null){	  
										$.each(msg, function(key, value) {
											
											
											
												$('#canalReservoirId').append( '<option value="'+parseInt(value.reservoirId)+'" > '+value.resName+'</option>' );
										
						  	  				$('#canalReservoirId').multiselect('rebuild');
									
										
										
											
											
										});
										  }
										  
										 
										  
										 
										  
										 
					    	
							}
							 if(len==0){	
								 
								
								 $('#canalReservoirId').val(0);
								  
								  $('#canalReservoirId').multiselect('rebuild');
								
							  }
					    	 

					      },
					      error : function(){
					    	  alert(error);
					      }
					  });
					
			
			  
			
			
			
		}

// start of canal new functions 


function getCanalsInfo(projectId,hkey){
	
	 //alert("projectId"+projectId);
	// alert("hkey"+hkey);
	 
	$("#canalId8").val(0);
	
	 $('#action_alert').empty();
	  
	  
		$("#view-thead13").empty();
		$("#view-tbody13").empty();
		
		$("#view-thead15").empty();
		$("#view-tbody15").empty();
		
		
		var userunit=$('#userunit').val(); 
		var usercircle=$('#usercircle').val(); 
		var userdivision=$('#userdivision').val(); 
		var usersubdivision=$('#usersubdivision').val(); 
		var userpost=$('#userpost').val(); 
			
			//alert("projectId"+projectId);
			
					$.ajax({	          
					      url: "../invtsimis/get-canal-data",
					      method:"POST",
						   dataType: 'json',				
					      async: false,
					      data: {projectId:projectId},
					      success: function (msg) {
					    	  
					    	  var len = msg.length;
							  
							  //alert(len);
							
							
							if(len>0){
								
								///alert("projectIdhere"+projectId);
								
							if(hkey==1 || hkey==2){
								
								 var j=1;
								 
								 
								
								
								$('#viewcnlinfo table thead').append( '<tr style="font-size: 18px; color: gray; font-weight: bold;"><th>Sl.No</th>'+
					    	    		
					    	    		'<th>Canal Name</th>'+
					    	    	
					    	    		
					    	    		' <th>District Name</th>'+
					    	    		
					    	    		' <th>Mandal Name </th>'+
					    	    		
					    	    		' <th>Village Name </th>'+
					    	    		
					    	    		' <th>Action</th>'+
					    	    		
					    	    		
					    	    		'</tr>'); 	
								
                            $('#viewcnllocinfo table thead').append( '<tr style="font-size: 18px; color: gray; font-weight: bold;"><th>Sl.No</th>'+
					    	    		
					    	    		'<th>Canal Name</th>'+
					    	    	
					    	    		
					    	    		' <th>District Name</th>'+
					    	    		
					    	    		' <th>Mandal Name </th>'+
					    	    		
					    	    		' <th>Village Name </th>'+
					    	    		
					    	    		' <th>Action</th>'+
					    	    		
					    	    		
					    	    		'</tr>'); 
							 
							
									var obj =msg;
									$.each(obj, function(key, value) {
										
										var villId=value.villageId;
										
										 var dbunit=value.unitId;
										 var dbcircle=value.circleId;
										 var dbdivision=value.divisionId;
										 var dbsubdivision=value.subdivisionId;
										 var dbpost=value.postId;
										
										
										  $('#viewcnlinfo table tbody').append(  '<tr style="font-size: 16px">' +
					                                '<td style="text-align: center;">'+j+'</td>' +
					                                
					                                '<td><b>'+value.canalName+'</b></td>' +
					                               
					                                '<td style="color:blue"><b>'+value.districtName+'</b></td>' +
					                                '<td style="color:blue"><b>'+value.mandalName+'</b></td>' +
					                               ( (villId> 0) ?    '<td style="color:blue"><b>'+value.villageName+'</b></td>': '<td style="color:blue"><b>'+value.remarksVillage+'</b></td>') +
					                                
					                                '<td><b><button type="button" name="getcnl" id="getcnl'+j+'" class="btn btn-1 btn-primary center-block "  onclick="getfrmsentlist(0,0,'+value.canalId+'),getCanalsLocation('+value.canalId+','+value.canalLocId+'),getcanalclose()"  >Select Canal</button> </b></td>' +
					                               	                               
					                               
					                                '</tr>');
										  
										  
										  $('#viewcnllocinfo table tbody').append(  '<tr style="font-size: 16px">' +
					                                '<td style="text-align: center;">'+j+'</td>' +
					                                
					                                '<td><b>'+value.canalName+'</b></td>' +
					                               
					                                '<td style="color:blue"><b>'+value.districtName+'</b></td>' +
					                                '<td style="color:blue"><b>'+value.mandalName+'</b></td>' +
					                               ( (villId> 0) ?    '<td style="color:blue"><b>'+value.villageName+'</b></td>': '<td style="color:blue"><b>'+value.remarksVillage+'</b></td>') +
					                                
					                           ((dbunit==userunit && dbcircle==usercircle && dbdivision==userdivision && dbsubdivision==usersubdivision && dbpost==userpost) ?    '<td><b><button type="button" name="getcnl" id="getcnl'+j+'" class="btn btn-1 btn-primary center-block "  onclick="EditCanalLocationinfo('+projectId+','+value.canalLocId+')"  >Edit Canal Location</button> </b></td>':  '<td></td>') +
					                               	                               
					                               
					                                '</tr>');
									
										   j++;
										  
										 
									});
					    	  
					    
					    
					    	
						    	 
										  
										  $('#districtNamecan').val(''); 
									    	$('#mandalNamecan').val('');  
									    	 $('#villageNamecan').val('');
									    	 $('#canalNamecan').val('');
									    	
									    	
									    	
									    	//  $('#shaddcanalsinf').show();	
											 // $('#sheditcanalsinfo').hide();
										  
							}	 
							
							if(hkey==2){
								
								  var $select = $('#canalId');
							    	 
								  $select.find('option').remove();
								  
								 
								
								 
										//var obj = JSON.parse(msg);
										  $('#canalId').append( '<option value=" "> --select--</option>' );
						    
						    
										  if(msg!==null){	  
										$.each(msg, function(key, value) {
											
											
											
												$('#canalId').append( '<option value="'+parseInt(value.canalId)+'" > '+value.canalName+'</option>' );
										
						  	  				$('#canalId').multiselect('rebuild');
									
										
										
											
											
										});
										  }
								
								
								
								
							}
										  
										 
					    	
							}
							 if(len==0){	
								 
								//  $('#shaddcanalsinf').show();	
								 // $('#sheditcanalsinfo').hide();	
								 
								
								 
								 $('#canselectedDistrictId').val(0);	
								 
								 
								// $('#canalId').val(0);
								 var $selectnew = $('#canalId');
						    	 
								  $selectnew.find('option').remove();
								  $('#canalId').multiselect('rebuild');
								  $('#districtNamecan').val('');
									 $('#mandalNamecan').val('');
									 $('#villageNamecan').val('');
									 $('#canMainDistrictId').val(0);
									 $('#canalNamecan').val('');
							  
							  }

					      },
					      error : function(){
					    	  alert(error);
					      }
					  });
					
			
			  
			
			
			
		}



function getCanalsNameedit(projectId){
	
	// var projectId =   $('#projectId').val();  
	$("#canalId8").val(0);
	
	 $('#action_alertcan').empty();
	  
	  
		$("#view-thead14").empty();
		$("#view-tbody14").empty();
			
			//alert("projectId"+projectId);
		
		
		var userunit=$('#userunit').val(); 
		var usercircle=$('#usercircle').val(); 
		var userdivision=$('#userdivision').val(); 
		var usersubdivision=$('#usersubdivision').val(); 
		var userpost=$('#userpost').val(); 
					 
			
					$.ajax({	          
					      url: "../invtsimis/get-canalsedit",
					      method:"POST",
						   dataType: 'json',				
					      async: false,
					      data: {projectId:projectId},
					      success: function (msg) {
					    	  
					    	  var len = msg.length;
							  
							  //alert(len);
							
							
							if(len>0){
								
								
						  	
							
								
								 var j=1;
								
								$('#viewcnlnameinfo table thead').append( '<tr style="font-size: 18px; color: gray; font-weight: bold;"><th>Sl.No</th>'+
					    	    		
					    	    		'<th>Canal Name</th>'+
					    	    	
					    	    		
					    	    		' <th>Canal Type</th>'+
					    	    		
					    	    		' <th>Reservoir Name</th>'+
					    	    		
					    	    	
					    	    		
					    	    		' <th>Action</th>'+
					    	    		
					    	    		
					    	    		'</tr>'); 	 
							 
							
									var obj =msg;
									$.each(obj, function(key, value) {
										
										
										 var dbunit=value.unitId;
								  		  
								  		 
							  			  
								  		  var dbcircle=value.circleId;
								  			  
								  		   var dbdivision=value.divisionId;
								  		var dbsubdivision=value.subdivisionId;
								  		
								  		var dbpost=value.postId;
								  		
								  		
																		  
								  		 
								  	
										
									
										  $('#viewcnlnameinfo table tbody').append(  '<tr style="font-size: 16px">' +
					                                '<td style="text-align: center;">'+j+'</td>' +
					                                
					                                '<td><b>'+value.canalName+'</b></td>' +
					                               
					                                '<td style="color:blue"><b>'+value.canalType+'</b></td>' +
					                                '<td style="color:blue"><b>'+value.resName+'</b></td>' +
					                             
					                                
					                        ( (dbunit==userunit && dbcircle==usercircle && dbdivision==userdivision && dbsubdivision==usersubdivision && dbpost==userpost)    ?   '<td><b><button type="button" name="getcnlname" id="getcnlname'+j+'" class="btn btn-1 btn-primary center-block "  onclick="EditCanalinfo('+value.canalId+')"  >Edit Canal</button> </b></td>':'<td></td>') +
					                               	                               
					                               
					                                '</tr>');
									
										   j++;
										  
										 
									});
					    	  
					    
					    
					    	
						    	 
										  
										  $('#districtNamecan').val(''); 
									    	$('#mandalNamecan').val('');  
									    	 $('#villageNamecan').val('');
									    	 $('#canalNamecan').val('');
									    	
									    	
									    	
									    	//  $('#shaddcanalsinf').show();	
											 // $('#sheditcanalsinfo').hide();
										  
										 
										  
										 
					    	
							}
							 if(len==0){	
								 
								//  $('#shaddcanalsinf').show();	
								 // $('#sheditcanalsinfo').hide();	
								 
								
								 
								 $('#canselectedDistrictId').val(0);	
								 
								 
								// $('#canalId').val(0);
								 var $selectnew = $('#canalId');
						    	 
								  $selectnew.find('option').remove();
								  $('#canalId').multiselect('rebuild');
								  $('#districtNamecan').val('');
									 $('#mandalNamecan').val('');
									 $('#villageNamecan').val('');
									 $('#canMainDistrictId').val(0);
									 $('#canalNamecan').val('');
							  
							  }

					      },
					      error : function(){
					    	  alert(error);
					      }
					  });
					
			
			  
			
			
			
		}


function EditCanalinfo(canalId){
	
	
	$.ajax({	          
	      url: "../invtsimis/get-canalseditbycanalid",
	      method:"POST",
		   dataType: 'json',				
	      async: false,
	      data: {canalId:canalId},
	      success: function (msg) {
	    	  
	    	  var len = msg.length;
			  
			  //alert(len);
			
			
			if(len>0){
				
				
			
				
				 var canalName=msg[0].canalName;
	  			  
		  		  var canalId=msg[0].canalId;
		  		  
		  		  var canalTypeId=msg[0].canalTypeId;
		  		  
		  		 
		  		 
		  		 var projectId=msg[0].projectId;
		  		 
		  		 var resId=msg[0].reservoirId;
		  		 
		  		
		  		 
		  		$('#editFlag2').val(true);
		  			  
		  		$('#cancanId2').val(canalId);
		  		$('#canalName').val(canalName);
		  		
		  		$('#canProjectId2').val(projectId);
		  		
		  		if(parseInt(canalTypeId)>0){
		  		$('#canalTypeId').val(canalTypeId);
		  		
		  		$('#canalTypeId').multiselect('rebuild');
		  		}
		  		
		  		
		  		if(parseInt(resId)>0){
			  		$('#canalReservoirId').val(resId);
			  		
			  		$('#canalReservoirId').multiselect('rebuild');
			  		}
		  		
		  		
		  		 document.getElementById('cancaptcha_id').src = '../captcha2.jpg?' + Math.random(); 
	    	
			}
			 if(len==0){	
				 
					$('#editFlag2').val(false);
					$('#cancanId2').val(0);
					$('#canalName').val('');
					
					$('#canProjectId2').val(0);
					$('#canalTypeId').val(0);
					$('#canalTypeId').multiselect('rebuild');
					$('#canalReservoirId').val(0);
					$('#canalReservoirId').multiselect('rebuild');
				 
				
			  
			  }

	      },
	      error : function(){
	    	  alert(error);
	      }
	  });
	
	
	
	
	
	
}



function EditCanalLocationinfo(projectId,canallocId){
	
	//alert("kal"+projectId);
	
	
	$.ajax({	          
	      url: "../invtsimis/get-canalslocationbylocid",
	      method:"POST",
		   dataType: 'json',				
	      async: false,
	      data: {canalLocId:canallocId},
	      success: function (msg) {
	    	  
	    	  var len = msg.length;
			  
			  //alert(len);
			
			
			if(len>0){
				
				
			
				
				
	  			  
		  		  var canalId=msg[0].canalId;
		  		 
		  		 
		  		 var projectIdnew=projectId;
		  		 
		  		 var districtId=msg[0].districtId;
		  		 var mandalId=msg[0].mandalId;
		  		 
		  		var villageId=msg[0].villageId;
		  		
		  		var remarksVillage=msg[0].remarksVillage;
		  		
		  		var fromkm=msg[0].chainageFromkm;
		  		
		  		var tokm=msg[0].chainageTokm;
		  		
		  		//alert("projectIdnew"+projectIdnew);
		  		
		  		getCanalsInfo(projectIdnew,2);
		  		 
		  		$('#canalLocId').val(msg[0].canalLocId); 
		  		$('#editFlag').val(true);
	  			  
		  		$('#canalId').val(canalId);
		  		$('#canalId').multiselect('rebuild');
		  		
		  		$('#chainageFromkm').val(fromkm);
		  		
		  		$('#chainageTokm').val(tokm);
		  		 
		  		if(parseInt(districtId)>0){
		  			
			  		//	alert("canaldistrict"+districtId)
			  			
			  			$('#canselectedDistrictId').val(districtId);
			  			
			  			getDistricts(2);
			  		
							    	
			  			
			  			 $("#candistrictId").each(function () {
							 
							  $(this).val(districtId);
						    	            $(this).attr("selected", "selected");
						    	  		  
				    	});
				  	
				  		
				  		
				  		
				  		$('#candistrictId').multiselect('rebuild');
				  		
				  		
				  		$('#canselectedMandalId').val(mandalId);
				  		$('#canselectedVillageId').val(villageId);
				  		
				  		
				  		
				  		getMandals(districtId,2);
				  		
				  		getVillages(districtId,mandalId,2)
				  		}
		  		
		  		$('#canreamarksVillageName').val(remarksVillage);
		  		 
		  	
		  		 
		  		
		  		 document.getElementById('cancaptcha_id2').src = '../captcha3.jpg?' + Math.random();  
		  	
		  	
		  		
		  		
		  
	    	
			}
			 if(len==0){	
				 
				 $('#canreamarksVillageName').val('');
				 
					$('#canselectedMandalId').val(0);
			  		$('#canselectedVillageId').val(0);
			  		$('#canselectedDistrictId').val(0);
			  		
			  		$('#editFlag').val(false);
			  
			  }

	      },
	      error : function(){
	    	  alert(error);
	      }
	  });
	
	
	
	
	
	
}





function getcanalclose(){
	
	 $('#addcanals_dialogue').dialog('close');
	
}


function getProjectCode(projectId){
	
	//alert("kal"+projectId);
	
	 $("#projCodeviewid").empty();
		 
		$("#projnameviewid").empty();
	
	
	$.ajax({	          
	      url: "../invtsimis/get-project-code",
	      method:"POST",
		   dataType: 'json',				
	      async: false,
	      data: {projectId:projectId},
	      success: function (msg) {
	    	  
	    	  var len = msg.length;
			  
			  //alert(len);
			
			
			if(len>0){
				
				
			
				
				
	  			  
		  		  var projectCode=msg[0].projectCode;
		  		 
		  		 
		  		 var projectName=msg[0].projectName;;
		  		 
		  		 $("#projCodeviewid").append("Project Code : "+projectCode);
		  		 
		  		$("#projnameviewid").append("Project Name: "+projectName);
		  		 
		  		
		  		
		  		
		  		
		  
	    	
			}
			 if(len==0){	
				 
				 $("#projCodeviewid").append("NA");
		  		 
			  		$("#projnameviewid").append("NA");
			  		
				 
				 
			  }

	      },
	      error : function(){
	    	  alert(error);
	      }
	  });
	
	
	
	
	
	
}





function getempId(empId){
	
//	alert("kal"+empId);
	
	
	$.ajax({	          
	      url: "../invtsimis/get-emp-approve",
	      method:"POST",
		   dataType: 'json',				
	      async: false,
	      data: {selectedEmpId:empId},
	      success: function (msg) {
	    	  
	    	  var len = msg.length;
			  
			//  alert(len);
			
			
			if(len>0){
				
			//	alert("empId"+msg[0].empId)
			//	alert("postId"+msg[0].postId)
				
				
				 $("#nextPostId8").val(msg[0].postId);
		  		 
			  		$("#nextEmpId8").val(msg[0].empId);
		  		 
		  		
		  		
		  		
		  		
		  
	    	
			}
			 if(len==0){	
				 
				 $("#nextPostId8").val(0);
		  		 
			  		$("#nextEmpId8").append(empId);
			  		
				 
				 
			  }

	      },
	      error : function(){
	    	  alert(error);
	      }
	  });
	
	
	
	
	
	
}
