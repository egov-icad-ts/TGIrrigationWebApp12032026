
<!--main code block-->
<!-- sec-section -->

<!-- create component start here -->
<%@include file="/jsp/header/taglib_includes.jsp"%>


<link rel="stylesheet" href="../css/bootstrap-multiselect.css"
	type="text/css">
<!--  <script type="text/javascript" src="../js/bootstrap.min.js"></script> -->
<script type="text/javascript" src="../js/bootstrap-multiselect.js"></script>

<!-- <link rel="stylesheet" media="screen" href="../js/1.13.2jquery/jquery-ui.css">
<script type="text/javascript" src="../js/1.13.2jquery/jquery-ui.js"></script> -->

<link rel="stylesheet" media="screen" href="../css/jquery-ui.css">
<script type="text/javascript" src="../js/jquery-ui.js"></script>





<script>
function getProjects(){
	
	 
    var   unitId=$('#unitId').val();
      
  //  alert("procId"+procId);
	$('#projectId').multiselect('rebuild');


	$.ajax({	          
	      url: "../web/getProjects?unitId="+unitId,
	      type: "GET",
	      success: function (response) {
	    	  var $select = $('#projectId');
	  				$select.find('option').remove();
	  				
	  				var selectedProj=$('#selectedProjectId').val();
	  					
	  					var obj = JSON.parse(response);
	  					
	  				$('#projectId').append( '<option value=" "> --select--</option>' );
	  					
	  					$.each(obj, function(key, value) {
	  						
	  						if(selectedProj==value.projectId){	
	  						
	  					$('#projectId').append( '<option value="'+value.projectId+'" selected="selected"> '+value.projectName+'</option>' );
	  					
	  						}
	  						
	  						if(selectedProj==null||selectedProj!=value.projectId){
	  							$('#projectId').append( '<option value="'+value.projectId+'"> '+value.projectName+'</option>' );	
	  						
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
	      error : function(){
	    	  alert(error);
	      }
	  });	
	} 

function getPackages(e){
	
	 //alert("e"+e);
    var   projectId=e;
    	//$('#projectId').val();
      
  //  alert("procId"+procId);
	$('#packageId').multiselect('rebuild');


	$.ajax({	          
	      url: "../comptsimis/getProjPacks?projectId="+projectId,
	      type: "GET",
	      success: function (response) {
	    	  
	    	//  alert("response"+response);
	    	  
	    	 
	    	 
	    	  var $select = $('#packageId');
	  				$select.find('option').remove();
	  			
	  				var selectedPack=$('#selectpackId').val();
	  				
	  			//	if(response!=null){
	  					
	  					
	  					var obj = JSON.parse(response);
	  					
	  				$('#packageId').append( '<option value="0"> --select--</option>' );
	  				
	  				
	  					
	  					$.each(obj, function(key, value) {
	  						
	  					
	  					if(selectedPack==value.pkgId){	
	  						
	  						
	  						
	  					$('#packageId').append( '<option value="'+value.pkgId+'" selected="selected" > '+value.pkgName+'</option>' );
	  					}
	  						if(selectedPack==null||selectedPack!=value.pkgId){
	  							
	  						//	alert("coming heer1")
	  							
	  						$('#packageId').append( '<option value="'+value.pkgId+'"> '+value.pkgName+'</option>' );	
	  						
	  					}
	  					
	  					
	  						$('#packageId').multiselect('rebuild');
	  				
	  				
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
	  					
	  				//}
	  				
	  				/* if(response==null){
	  					
	  					$('#packageId').append( '<option value="0"> --select--</option>' );
	  					$('#packageId').append( '<option value="1"> --Other Package--</option>' );
	  					$('#packageId').multiselect('rebuild');
	  					
	  					
	  				} */
	      },
	      error : function(){
	    	  alert(error);
	      }
	  });	
	} 
		
function getMandals(b){
	
	//alert("kal"+b);

	
	var districtId=b
		//document.getElementById("districtId").value;
	
	//alert(districtId);

	$.ajax({	          
	      url: "../web/getMandals?districtId="+districtId,
	      type: "GET",
	      success: function (response) {
	    	  var $select = $('#mandalId');
			  $select.find('option').remove();
			  
			  var selectedMandal=$('#selectedMandalId').val();
			//  alert("selected"+selectedMandal);
			 
			  $('#mandalId').append( '<option value=" "> --select--</option>' );
					var obj = JSON.parse(response);
					$.each(obj, function(key, value) {
						
						if(selectedMandal==parseInt(value.mandalCode)){	
							//alert("coming1");
							$('#mandalId').append( '<option value="'+parseInt(value.mandalCode)+'" selected="selected" > '+value.mandalName+'</option>' );
						}
						if(selectedMandal==null||selectedMandal!=parseInt(value.mandalCode)){
							//alert("coming2");
							$('#mandalId').append( '<option value="'+parseInt(value.mandalCode)+'"  > '+value.mandalName+'</option>' );
						
						}
						
		  					
	  	  				$('#mandalId').multiselect('rebuild');
					});

	      },
	      error : function(){
	    	  alert(error);
	      }
	  });	
	} 

	function getVillages(dcode,mcode){
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
	    	
	    	
	    	
	    	  var $select = $('#villageId');
	    	 
			  $select.find('option').remove();
			  
			 
			
			 
					var obj = JSON.parse(response);
					  $('#villageId').append( '<option value="0"> --select--</option>' );
					  
					$.each(obj, function(key, value) {
						
							$('#villageId').append( '<option value="'+parseInt(value.villageCode)+'" > '+value.villageName+'</option>' );
					
	  	  				$('#villageId').multiselect('rebuild');
					});
	    	 

	      },
	      error : function(){
	    	  alert(error);
	      }
	  }); 	
	}
	
	
	function getConstituencies(districtId,mcode){
		//alert("kal");
		//var districtId=document.getElementById("districtId").value;
		var districtId=districtId;
			//document.getElementById("mandalId").value;
	//	alert("olddistrictId"+olddistrictId);
	
		  $.ajax({	          
	      url: "../comptsimis/getConstolddistList?districtId="+districtId+"&mcode="+mcode,
	      type: "GET",
	      success: function (response) {
	    	//alert("response"+response);
	    	
	    	
	    	  var $select = $('#constId');
	    	 
			  $select.find('option').remove();
			  
			  var selectedConstId=$('#selectedConstId').val();
			
			 
					var obj = JSON.parse(response);
					  $('#constId').append( '<option value=" "> --select--</option>' );
					  
					$.each(obj, function(key, value) {
						
						if(selectedConstId==value.constId){	
						
							$('#constId').append( '<option value="'+value.constId+'" selected="selected" > '+value.constName+'</option>' );
						}
						
						if(selectedConstId==null||selectedConstId!=value.constId){
							$('#constId').append( '<option value="'+value.constId+'" > '+value.constName+'</option>' );
						
						}
					
	  	  				$('#constId').multiselect('rebuild');
					});
	    	 

	      },
	      error : function(){
	    	  alert(error);
	      }
	  }); 	
	}
	
	
	
	
	/* function getCircles(){
		//alert("kal");
		//var districtId=document.getElementById("districtId").value;
		var unitId=document.getElementById("unitId").value;
		//alert(mandalId);
	
		  $.ajax({	          
	      url: "../web/getCircles?unitId="+unitId,
	      type: "GET",
	      success: function (response) {
	    	
	    	
	    	
	    	  var $select = $('#circleId');
	    	 
			  $select.find('option').remove();
			  
			 
			
			 
					var obj = JSON.parse(response);
					  $('#circleId').append( '<option value="0"> --select--</option>' );
					  
					$.each(obj, function(key, value) {
						
							$('#circleId').append( '<option value="'+value.circleId+'" > '+value.circleName+'</option>' );
					
	  	  				$('#circleId').multiselect('rebuild');
					});
	    	 

	      },
	      error : function(){
	    	  alert(error);
	      }
	  }); 	
	}
	
	
	function getDivisions(){
		//alert("kal");
		//var districtId=document.getElementById("districtId").value;
		var circleId=document.getElementById("circleId").value;
		//alert(mandalId);
	
		  $.ajax({	          
	      url: "../web/getDivisions?circleId="+circleId,
	      type: "GET",
	      success: function (response) {
	    	
	    	
	    	
	    	  var $select = $('#divisionId');
	    	 
			  $select.find('option').remove();
			  
			 
			
			 
					var obj = JSON.parse(response);
					  $('#divisionId').append( '<option value="0"> --select--</option>' );
					  
					$.each(obj, function(key, value) {
						
							$('#divisionId').append( '<option value="'+value.divisionId+'" > '+value.divisionName+'</option>' );
					
	  	  				$('#divisionId').multiselect('rebuild');
					});
	    	 

	      },
	      error : function(){
	    	  alert(error);
	      }
	  }); 	
	}
	
	
	function getSubDivisions(){
		//alert("kal");
		//var districtId=document.getElementById("districtId").value;
		var divisionId=document.getElementById("divisionId").value;
		//alert(mandalId);
	
		  $.ajax({	          
	      url: "../web/getSubDivisions?divisionId="+divisionId,
	      type: "GET",
	      success: function (response) {
	    	
	    	
	    	
	    	  var $select = $('#subdivisionId');
	    	 
			  $select.find('option').remove();
			  
			 
			
			 
					var obj = JSON.parse(response);
					  $('#subdivisionId').append( '<option value="0"> --select--</option>' );
					  
					$.each(obj, function(key, value) {
						
							$('#subdivisionId').append( '<option value="'+value.subdivisionId+'" > '+value.subdivisionName+'</option>' );
					
	  	  				$('#subdivisionId').multiselect('rebuild');
					});
	    	 

	      },
	      error : function(){
	    	  alert(error);
	      }
	  }); 	
	}
 */

	/* function getParents(){
		
		 
	    var   projectId=$('#projectId').val();
	      
	  //  alert("kal"+projectId);
		$("#componentId").multiselect('rebuild');
		
		//  alert("kal2");

		$.ajax({	          
		      url: "../comptsimis/getparent?projectId="+projectId,
		      type: "GET",
		      success: function (response) {
		    	  //alert("res"+response)
		    	  var $select = $('#componentId');
		  				$select.find('option').remove();
		  				
		  			
		  					
		  					var obj = JSON.parse(response);
		  					
		  				$('#componentId').append( '<option value="0"> --select--</option>' );
		  				$('#componentId').append( '<option value="-2"> Other</option>' );
		  					
		  					$.each(obj, function(key, value) {
		  						
		  						
		  						
		  					$('#componentId').append( '<option value="'+value.componentId+'"> '+value.componentName+'</option>' );
		  					
		  				$('#componentId').multiselect('rebuild')
		  				
		  				
		  		 	$(this).removeAttr('selected').prop('selected', false);
					  
				    if($('li').hasClass('active')){
				    	if($('input').prop('checked', true)){
				    		
				    		 $('input').prop('checked', false);
				    		
				    	var spantext=	$("span.multiselect-selected-text").text();
				    	$("span.multiselect-selected-text").text('None Selected')
				    		
				    		
				    	}
				    	$('li').removeClass('active');
				       
				    } 
		  				
		  					});
		      },
		      error : function(){
		    	  alert(error);
		      }
		  });	
		} 
	
	function getCompTypes(){
		
		 
	    var   componentCategoryId=$('#componentCategoryId').val();
	      
	  //  alert("procId"+procId);
		$('#componentTypeId').multiselect('rebuild');


		$.ajax({	          
		      url: "../comptsimis/getCompType?componentCategoryId="+componentCategoryId,
		      type: "GET",
		      success: function (response) {
		    	  var $select = $('#componentTypeId');
		  				$select.find('option').remove();
		  				
		  			
		  					
		  					var obj = JSON.parse(response);
		  					
		  				$('#componentTypeId').append( '<option value="0"> --select--</option>' );
		  				
		  					
		  					$.each(obj, function(key, value) {
		  						
		  						
		  						
		  					$('#componentTypeId').append( '<option value="'+value.componentTypeId+'"> '+value.componentType+'</option>' );
		  					
		  				$('#componentTypeId').multiselect('rebuild')
		  				
		  				
		  			$(this).removeAttr('selected').prop('selected', false);
					  
				    if($('li').hasClass('active')){
				    	if($('input').prop('checked', true)){
				    		
				    		 $('input').prop('checked', false);
				    		
				    	var spantext=	$("span.multiselect-selected-text").text();
				    	$("span.multiselect-selected-text").text('None Selected')
				    		
				    		
				    	}
				    	$('li').removeClass('active');
				       
				    } 
		  				
		  					});
		      },
		      error : function(){
		    	  alert(error);
		      }
		  });	
		} 
	
	function getcompParent(){
		
		 
	    var   componentId=$('#componentId').val();
	      
	   // alert("kal"+projectId);
		$('#parentComponentId').multiselect('rebuild');
		
		//  alert("kal2");

		$.ajax({	          
		      url: "../comptsimis/getParentComp?componentId="+componentId,
		      type: "GET",
		      success: function (response) {
		    	//  alert("res"+response)
		    	  var $select = $('#parentComponentId');
		  				$select.find('option').remove();
		  				
		  			
		  					
		  					var obj = JSON.parse(response);
		  					
		  				$('#parentComponentId').append( '<option value="0"> --select--</option>' );
		  					
		  					$.each(obj, function(key, value) {
		  						
		  						
		  					if(value.componentId==-1){
		  					$('#parentComponentId').append( '<option value="'+value.componentId+'"> No parent </option>' );
		  					}
		  					if(value.componentId!=-1){
		  						
		  						$('#parentComponentId').append( '<option value="'+value.componentId+'" selected="selected">'+value.componentName+'</option>' );	
		  						
		  					}
		  					
		  				$('#parentComponentId').multiselect('rebuild')
		  				
		  				
		  		 	$(this).removeAttr('selected').prop('selected', false);
					  
				    if($('li').hasClass('active')){
				    	if($('input').prop('checked', true)){
				    		
				    		 $('input').prop('checked', false);
				    		
				    	var spantext=	$("span.multiselect-selected-text").text();
				    	$("span.multiselect-selected-text").text('None Selected')
				    		
				    		
				    	}
				    	$('li').removeClass('active');
				       
				    } 
		  				
		  					});
		      },
		      error : function(){
		    	  alert(error);
		      }
		  });	
		}  */
	
	
	
	function getConstituency(){
		
		 
	    var   districtId=$('#districtId').val();
	      
	   // alert("kal"+projectId);
		$('#constId').multiselect('rebuild');
		
		//  alert("kal2");

		$.ajax({	          
		      url: "../comptsimis/getConstituency?districtId="+districtId,
		      type: "GET",
		      success: function (response) {
		    	 // alert("res"+response)
		    	  var $select = $('#constId');
		  				$select.find('option').remove();
		  				
		  			
		  					
		  					var obj = JSON.parse(response);
		  					
		  				$('#constId').append( '<option value="0"> --select--</option>' );
		  					
		  					$.each(obj, function(key, value) {
		  						
		  						
		  					
		  					
		  						
		  						$('#constId').append( '<option value="'+value.constId+'" >'+value.constName+'</option>' );	
		  						
		  					
		  					
		  				$('#constId').multiselect('rebuild')
		  				
		  				
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
		      error : function(){
		    	  alert(error);
		      }
		  });	
		} 
	
	
</script>




<script>

$(function() { 
	  $('#datepicker2').datepicker( {
	    yearRange: "c-100:c",
	    changeMonth: false,
	    changeYear: true,
	    showButtonPanel: true,
	    closeText:'Select',
	    currentText: 'This year',
	    onClose: function(dateText, inst) {
	      var year = $("#ui-datepicker-div .ui-datepicker-year :selected").val();
	      $(this).val($.datepicker.formatDate("yy", new Date(year, 0, 1)));
	    },
	    beforeShow: function(input, inst){
	      if ($(this).val()!=''){
	        var tmpyear = $(this).val();
	        $(this).datepicker('option','defaultDate',new Date(tmpyear, 0, 1));
	      }
	    }
	  }).focus(function () {
	    $(".ui-datepicker-month").hide();
	    $(".ui-datepicker-calendar").hide();
	    $(".ui-datepicker-current").hide();
	    /*$(".ui-datepicker-close").hide();*/
	    $(".ui-datepicker-prev").hide();
	    $(".ui-datepicker-next").hide();
	    $("#ui-datepicker-div").position({
	      my: "left top",
	      at: "left bottom",
	      of: $(this)
	    });
	  }).attr("readonly", true);
	});

$(function() { 
	
	/* $("#datepicker2").datepicker({	
		 changeYear : true,
		 changeMonth: false,
		 showButtonPanel: false,
		  dateFormat : "yy",
		  yearRange: "c-100:c",
		  closeText:'Select',
		    currentText: 'This year',
		    onClose: function(dateText, inst) {
		      var year = $("#ui-datepicker-div .ui-datepicker-year :selected").val();
		      $(this).val($.datepicker.formatDate("yy", new Date(year, 0, 1)));
		    },
		    beforeShow: function(input, inst){
		      if ($(this).val()!=''){
		        var tmpyear = $(this).val();
		        $(this).datepicker('option','defaultDate',new Date(tmpyear, 0, 1));
		      }
		    }
		  
		  
		       
		    
	}).focus(function () {
	    $(".ui-datepicker-month").hide();
	    $(".ui-datepicker-calendar").hide();
	    $(".ui-datepicker-current").hide();
	   
	    $(".ui-datepicker-prev").hide();
	    $(".ui-datepicker-next").hide();
	    $("#ui-datepicker-div").position({
	      my: "left top",
	      at: "left bottom",
	      of: $(this)
	    });
	  }).attr("readonly", false); */
	 /*$(".ui-datepicker-close").hide();*/
	 
/* 	$('#datepicker2').datetimepicker({
	    format      :   "YYYY",
	    viewMode    :   "years", 
	}); */
	
	
	
});

  
	$(document).ready(function() {
		
		
		
		
		
		$('#packId').hide();
		
		//$('#conName').hide();
		
		
		
		/* $('#unitId').multiselect({
			 
			 enableCaseInsensitiveFiltering: true
			 
		});
		 */
	/* 	
		$('#oldDistrictId').multiselect({
			 
			 enableCaseInsensitiveFiltering: true
			 
		}); */
		
		$('#packageId').multiselect({
			 
			 enableCaseInsensitiveFiltering: true
			 
		});
		
		
		$('#projectId').multiselect({
			 
			 enableCaseInsensitiveFiltering: true
			 
		});
		/* $('#circleId').multiselect({
			 
			 enableCaseInsensitiveFiltering: true
			 
		});
		$('#divisionId').multiselect({
			 
			 enableCaseInsensitiveFiltering: true
			 
		});
		$('#subdivisionId').multiselect({
			 
			 enableCaseInsensitiveFiltering: true
			 
		}); */
		$('#districtId').multiselect({
			 
			 enableCaseInsensitiveFiltering: true
			 
		});
		$('#mandalId').multiselect({
			 
			 enableCaseInsensitiveFiltering: true
			 
		});
		$('#villageId').multiselect({
			 
			 enableCaseInsensitiveFiltering: true
			 
		});

	/* 	$('#componentCategoryId').multiselect({
			 
			 enableCaseInsensitiveFiltering: true
			 
		});
		$('#componentTypeId').multiselect({
			 
			 enableCaseInsensitiveFiltering: true
			 
		}); */
		
		/* $('#componentDirection').multiselect({
			 
			 enableCaseInsensitiveFiltering: true
			 
		}); */
		
		

		
		
		
		
		/* $('#componentId').multiselect({
			 
			 enableCaseInsensitiveFiltering: true
			 
		}); */
		
		$('#constId').multiselect({
			 
			 enableCaseInsensitiveFiltering: true
			 
		});
		
		
		
		/* $('#parentComponentId').multiselect({
			 
			 enableCaseInsensitiveFiltering: true
			 
		}); */
		
		

	});

	$(function() {
		
		
		/* $("#presentAyacutmonth").datepicker({
			changeYear : true,
			changeMonth : true,
			dateFormat : "dd/mm/yy",
		  onSelect: function(selected) {
		   $("#month").datepicker("option","minDate", selected)
		 } 
		});*/
		 
		
		
	/* 	$("#presentAyacutCreated").keyup(function(){
			   
			 var a =   $("#presentAyacutCreated").val();
			 
			 var b =   $("#previousAyacutCreated").val();
			
			 var c =parseFloat(a)+parseFloat(b)
			 
			 $("#totalayacutCreated").val(c);
			   
		   }); */
		
		
		/* $("#presentAyacutContemplated").keyup(function(){
			   
			 var a =   $("#presentAyacutContemplated").val();
			 
			 var b =   $("#previousAyacutContemplated").val();
			 
			
			 
			 var c =parseFloat(a)+parseFloat(b);
			 
			 $("#totalayacutContemplated").val(c);
			   
		   }); */

		/* $('#componentId').change(function(){
			
			var x=$(this).val();
			//alert("x"+x);
			
			if(x==-2){
			
			$('#othercomp').show();
			}else{
				
				$('#othercomp').hide();
			}
			
		}); */
		
		/* var uvalue=$('#unitId').val();
		
		if(uvalue!=null){
			
			getProjects();
		} */
		
		
		 $('#packageId').change(function(){
		
		var x=$(this).val();
		//alert("x"+x);
		
		if(x==1){
		
		$('#packId').show();
		} else{
			
			$('#packId').hide();
		} 
		
	}); 
		
		/*  $('#constId').change(function(){
				
				var x=$(this).val();
				//alert("x"+x);
				
				if(x==3){
				
					 $('#conName').show();
				}else{
					
					 $('#conName').hide();
				}
				
			});  */
		
		 var myunit= parseInt($("#unitId").val()); 
			//alert("m"+myunit);
			var a=myunit;
			if(a!=null && a>0){
				//alert(myunit+"myunit");
				getProjects();
			
			}
			 var myproj= parseInt($("#selectedProjectId").val()); 
			//alert("m"+myproj);
			var e=myproj;
			if(e!=null && e>0){
				//alert(myproj+"myproj");
				getPackages(e);
			
			}
			 
			var mdistrict= parseInt($("#districtId").val()); 
			//alert("b"+mdistrict);
			var b=mdistrict;
			if(b!=null && b>0){
			//	alert(b+"b");
				getMandals(b);
				
			
			}
			
			var mmandal= parseInt($("#selectedMandalId").val()); 
			//alert("c"+mmandal);
			var c=mmandal;
			if(c!=null && c>0){
				//alert(myproj+"myproj");
				getVillages(b,c);
				getConstituencies(b,c);
				
			
			}
			
			
			/* var cconst= parseInt($("#selectedolddistId").val()); 
			//alert("c"+mmandal);
			var d=cconst;
			if(d!=null && d>0){
				//alert(myproj+"myproj");
				
				
			
			}
			 */
			 
			 
			
			
			 $('#faqSpopup').dialog({
				  autoOpen:false,
				  width:1200,
				  close: function() {
					  
					
						  $(this).dialog("close");
						  }
				 });
			 
			 
			 
			 $('#helpId').click(function(){
					
				 $('#faqSpopup').dialog('option', 'title', 'Clarifications');
				  $('#faqSpopup').dialog('open');
				
				 });
			
		

	});
	
	
	 
</script>






<div class="col-md-9">
	


<div>



	<div class="panel panel-primary ">
		<div class="panel-heading">
			<h3 class="panel-title">Ayacut Input<c:if test="${userObj!=null}">	
				<div class="span6 pull-right">
				
				Welcome to    
						
						 <c:if test="${userObj.employeeName!=null  }">	
						   
			Er. <c:out value="${userObj.employeeName}"></c:out>	
			 
			 </c:if>
			 
			 <c:if test="${userObj.designationName!=null  }">	
						   
			, <c:out value="${userObj.designationName}"></c:out>	
			 
			 </c:if>
			 </div>
			 <br></br>
			 <div class="span6 pull-right">
			
						  <c:if test="${userObj.unitId!=0 && userObj.circleId==0 && userObj.divisionId==0 && userObj.subdivisionId==0 }">	
						   <c:if test="${userObj.unitId>0  }">	
			 <c:out value="${userObj.unitName}"></c:out>	
			 </c:if>
			 </c:if>	
			 
			   <c:if test="${userObj.unitId!=0 && userObj.circleId!=0 && userObj.divisionId==0 && userObj.subdivisionId==0 }">	
						   <c:if test="${userObj.unitId>0 &&  userObj.circleId>0  }">	
			 <c:out value="${userObj.circleName}"></c:out>	
			 </c:if>
			 </c:if>	
			 
			   <c:if test="${userObj.unitId!=0 && userObj.circleId!=0 && userObj.divisionId!=0 && userObj.subdivisionId==0  }">	
						   <c:if test="${userObj.unitId>0  &&  userObj.circleId>0  &&  userObj.divisionId>0 }">	
			 <c:out value="${userObj.divisionName}"></c:out>	
			 </c:if>
			 </c:if>	
			 
			   <c:if test="${userObj.unitId!=0 && userObj.circleId!=0 && userObj.divisionId!=0 && userObj.subdivisionId!=0 }">	
						   <c:if test="${userObj.unitId>0 &&  userObj.circleId>0  &&  userObj.divisionId>0 &&  userObj.subdivisionId>0  }">	
			 <c:out value="${userObj.subdivisionName}"></c:out>	
			 </c:if>
			 </c:if>
			 
			   <c:if test="${userObj.unitId==null && userObj.circleId==null && userObj.divisionId==null && userObj.subdivisionId==null }">	
						   
			 <c:out value="${userObj.userName}"></c:out>	
			 
			 </c:if>
			 
	</div></c:if> &emsp;&emsp;</h3>
		</div>
		
		<div class="panel-body">
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

	<div class="row show-grid ">
<div class="alert alert-info" role="alert">
				<strong style="color:#CA3F22"> Note1: Village and Package are Optional (With out village/package data can be submitted. please use remarks for future purpose.)</strong>
				<br>
				<strong style="color:#CA3F22"> Note2: Submit buttton is available in CE/DCE logins of Respective CE Office</strong>
				

			</div>
			</div>
			<div class="row show-grid ">
				<div class="col-md-4">
				</div>
					<div class="col-md-4">
				</div>
				
			<div class="col-md-4" >
									
									<label class="label-controlPMS rowlebel "><b><a id="helpId" href="#">Click Here For Clarifications</a></b>
										
									</label> 
					 
					
											
									 </div>
							
			</div>
			
		
		
		<form:form id="compayacutinput" method="post" modelAttribute="compayacutinput"
			data-parsley-validate-if-empty="">
		




				<div class="row col-md-12 toppad formText" style="padding:35px 8px;">
				
				<input type="hidden" class="form-control"  id="selectedProjectId" name="selectedProjectId" value="${selectedProjectId}" />
				<input type="hidden" class="form-control"  id="selectedUnitId" name="selectedUnitId" value="${selectedUnitId}"/>
				<input type="hidden" class="form-control"  id="selectedPackName" name="selectedPackName" value="${selectedPackName}" />
				<input type="hidden" class="form-control"  id="selectedDistrictId" name="selectedDistrictId" value="${selectedDistrictId}"/>
				<input type="hidden" class="form-control"  id="selectedMandalId" name="selectedMandalId" value="${selectedMandalId}"/>
				<input type="hidden" class="form-control"  id="selectedConstId" name="selectedConstId" value="${selectedConstId}"/>
                       <input type="hidden" class="form-control"  id="selectpackId" name="selectpackId" value="${selectpackId}"/>
                         <input type="hidden" class="form-control"  id="selectedolddistId" name="selectedolddistId" value="${selectedolddistId}"/>
                         
                         
                         <input type="hidden" class="form-control"  id="unitId" name="unitId" value="${userObj.unitId}" />
                         <input type="hidden" class="form-control"  id="circleId" name="circleId" value="${userObj.circleId}" />
                            <input type="hidden" class="form-control"  id="divisionId" name="divisionId" value="${userObj.divisionId}" />
                             <input type="hidden" class="form-control"  id="subdivisionId" name="subdivisionId" value="${userObj.subdivisionId}" />
                         



					<div class="col-md-6 cellMargin" >
						<%-- <div class="col-md-6 cellMargin">
							<label class="label-controlPMS rowlebel ">Select Unit*</label>
						</div>
						<div class="col-md-6 cellMargin">
							<select class="form-control" id="unitId" name="unitId"
								 required onchange="getProjects()">
								<option value="">--select --</option>
							
								<c:forEach items="${unitList}" var="u">
								<c:choose>
									<c:when test="${u.unitId==selectedUnitId}">
									<option value="${u.unitId}" selected="selected">${u.unitName}</option>
									</c:when>
									<c:otherwise>
									<option value="${u.unitId}">${u.unitName}</option>
									</c:otherwise>
									</c:choose>

								</c:forEach>


							</select>
						</div>  --%>



						<div class="col-md-6 cellMargin">
							<label class="label-controlPMS rowlebel ">Select Project<font color=red>*</font></label>
						</div>

						<div class="col-md-6 cellMargin">


							<select class="form-control" id="projectId" name="projectId" required
								onchange="getPackages(this.value)" data-parsley-errors-container="#ProjectError">

								<%-- <c:forEach items="${newprList}" var="u">
									<option value="${u.projectId}">${u.projectName}</option>

								</c:forEach> --%>

							</select>
							<span id="ProjectError" ></span> 
						</div>

						<div class="col-md-6 cellMargin">

							<label class="label-control rowlebel ">Package Name</label>
						</div>
						<div class="col-md-3 cellMargin">
							<select class="form-control" id="packageId"  name="packageId"    >
							</select>
						
						</div>

						<div class="col-md-3 cellMargin" id="packId">

							<input type="text" class="form-control" id="packageName"
								name="packageName" placeholder="EX:Package No-1" value=" " />
						</div>
						
						
						<div class="col-md-6 cellMargin">
							<label class="label-controlPMS rowlebel ">Select
								District<font color=red>*</font></label>
						</div>
						<div class="col-md-6 cellMargin">
							<select class="form-control" id="districtId" data-parsley-errors-container="#DistrictError" name="districtId"
								onchange="getMandals(this.value)" required>

								<option value="">--select--</option>
								<c:forEach items="${districtList}" var="d">
								<c:choose>
								<c:when test="${d.districtId==selectedDistrictId }">
									<option value="${d.districtId}" selected="selected">${d.districtName}</option>
									</c:when>
									<c:otherwise>
									<option value="${d.districtId}">${d.districtName}</option>
									</c:otherwise>
									</c:choose>

								</c:forEach>


							</select>
							<span id="DistrictError" ></span> 
						</div>
						

						<!-- <div class="col-md-3" id="conName">

							<input type="text" class="form-control" id="constName"
								name="constName" placeholder="ex:Constituency"  />
						</div> -->


						<div class="col-md-6 cellMargin">
							<label class="label-controlPMS rowlebel ">Select Mandal<font color=red>*</font></label>
						</div>

						<div class="col-md-6 cellMargin">
							<select class="form-control" id="mandalId" data-parsley-errors-container="#MandalError" name="mandalId"
								onchange="getConstituencies(districtId.value,this.value),getVillages(districtId.value,this.value)" required>

								<option value="">--select--</option>



							</select>
							<span id="MandalError" ></span> 
						</div>
						
						
						<div class="col-md-6 cellMargin">

							<label class="label-control rowlebel ">Constituency
								<font color=red>*</font></label>
						</div>
						<div class="col-md-6 cellMargin">
							<select class="form-control" id="constId" data-parsley-errors-container="#ConstError" name="constId"
								 required>

								<option value="">--select--</option>
                               
								<%-- <c:forEach items="${constlist}" var="d">
								<c:choose>
								<c:when test="${d.constId==selectedConstId }">
									<option value="${d.constId}"selected="selected">${d.constName}</option>
									</c:when>
									<c:otherwise>
									<option value="${d.constId}">${d.constName}</option>
									</c:otherwise>
									</c:choose>

								</c:forEach>
 --%>

							</select>
							<span id="ConstError" ></span> 
						</div>
						

						<div class="col-md-6 cellMargin">
							<label class="label-controlPMS rowlebel ">Select Village</label>
						</div>
						<div class="col-md-6 cellMargin">
							<select class="form-control" id="villageId" name="villageId"
								>

								<option value="0">--select--</option>



							</select>
						</div>
						
						
						
						<%-- <div class="col-md-6 cellMargin">
							<label class="label-controlPMS rowlebel ">Select Old District*</label>
						</div>
						<div class="col-md-6 cellMargin">
							<select class="form-control" id="oldDistrictId" name="oldDistrictId"
								 required onchange="getConstituencies(this.value)">
								<option value="">--select --</option>
							
								<c:forEach items="${distList}" var="u">
								<c:choose>
									<c:when test="${u.districtId==selectedolddistId}">
									<option value="${u.districtId}" selected="selected">${u.districtName}</option>
									</c:when>
									<c:otherwise>
									<option value="${u.districtId}">${u.districtName}</option>
									</c:otherwise>
									</c:choose>

								</c:forEach>


							</select>
						</div>  --%>
						


						<!-- <div class="col-md-6">
							<label class="label-controlPMS rowlebel ">Select Circle</label>
						</div>


						<div class="col-md-6">
							<select class="form-control" id="circleId" name="circleId"
								onchange="getDivisions()">
							</select>
						</div> -->

						<!-- <div class="col-md-6">
							<label class="label-controlPMS rowlebel ">Select Division</label>
						</div>
						<div class="col-md-6">
							<select class="form-control" id="divisionId" name="divisionId"
								onchange="getSubDivisions()">
							</select>
						</div> -->

						<!-- <div class="col-md-6">
							<label class="label-controlPMS rowlebel ">Select
								SubDivision</label>
						</div>

						<div class="col-md-6">
							<select class="form-control" id="subdivisionId"
								name="subdivisionId">
							</select>
						</div> -->
<!-- 
						<div class="col-md-6">
							<label class="label-control rowlebel ">Select Component*</label>

						</div>
						<div class="col-md-6">

							<select class="form-control" id="componentId" name="componentId"
								required onchange="getcompParent()">
								<option value="0">--select--</option>
								<option value="-2">Other</option>


							</select>




						</div> -->
                         <%--  <div id="othercomp">
						<div class="col-md-6">

							<label class="label-control rowlebel ">Component Name*</label>
						</div>

						<div class="col-md-6">

							<input type="text" class="form-control" id="componentName"
								name="componentName" placeholder="EX:Mid Manair Dam" required />
						</div>


						<div class="col-md-6 " id="component">

							<label class="label-control rowlebel ">Component
								Description*</label>
						</div>

						<div class="col-md-6">
							<input type="text" class="form-control" id="componentDesc"
								name="componentDesc" placeholder="ex:Mid Manair Description"
								required />





						</div>


						

						 --%>
						





					</div>
					<div class="col-md-6 cellMargin">

						

					

				<!--  <div class="row" >

						<div class="col-md-6 cellMargin">

							<label class="label-control rowlebel ">Select Year<font color=red>*</font></label>
							
							 
						</div>

						<div class="col-md-6 cellMargin">
                   
						
					 	<input type="text" class=" form-control "  id="datepicker2" name="ayacutYear" placeholder="ayacutYear"  value="0"    readonly="readonly" /> 
						</div>
						</div> -->
						 		

						

						






	<div class="row" >
						<div class=" col-md-6 cellMargin">

							<label class="label-control rowlebel ">New Ayacut Proposed (Contemplated) in Acres<font color=red>*</font></label>
						</div>

						<div class="col-md-6 cellMargin">

							<input type="text" class="form-control" id="contemplatedAyacut" data-parsley-pattern="^[0-9]*\.[0-9]{2}$" data-parsley-trigger="blur" 
							data-parsley-error-message="You must enter in Acres upto two decimals ex:10.01"	name="contemplatedAyacut" placeholder="10.01" required />
						</div>
						
						</div>
						
					<div class="row" >

						<div class="col-md-6 cellMargin">

							<label class="label-control rowlebel ">Ayacut created
								in Acres<font color=red>*</font></label>
						</div>

						<div class="col-md-6 cellMargin">

							<input type="text" class="form-control" id="ayacutCreated"  data-parsley-pattern="^[0-9]*\.[0-9]{2}$" data-parsley-trigger="blur"
								data-parsley-error-message="You must enter in Acres upto two decimals ex:10.01" name="ayacutCreated" placeholder="10.01" required />
						</div>
						</div>
						
						<div class="row" >
						<div class="col-md-6 cellMargin">

							<label class="label-control rowlebel ">Irrigated Ayacut in Acres<font color=red>*</font></label>
						</div>

						<div class="col-md-6 cellMargin">

							<input type="text" class="form-control" id="irriagtedAyacut" data-parsley-pattern="^[0-9]*\.[0-9]{2}$" data-parsley-trigger="blur"
								data-parsley-error-message="You must enter in Acres upto two decimals ex:10.01" name="irriagtedAyacut" placeholder="10.01" required />
						</div>
						
						</div>
						
						
						
						 <div class="row" >

					<!-- 	<div class="col-md-6 cellMargin">

							<label class="label-control rowlebel "><font color=red>*</font></label>
							
							 Stabilized Ayacut  in Acres 
						</div>
 -->
						<div class="col-md-6 cellMargin">

							<input type="hidden" class="form-control" id="stableAyacut"  data-parsley-pattern="^[0-9]*\.[0-9]{2}$" data-parsley-trigger="blur" value="0.01"
							data-parsley-error-message="You must enter in Acres upto two decimals ex:10.01"	name="stableAyacut" placeholder="10.01" required readonly="readonly" />
						</div>
						</div>
						 












					</div>




					<div id="addedRows"></div>


					<div class="row show-grid">

						<div class="col-md-1"></div>
						<div class="col-md-1"></div>
					</div>














					<div class="row col-md-10">


					
							<label class="label-control rowlebel ">Remarks</label>
							<textarea class="form-control" id="remarks" name="remarks"></textarea>
						

					</div>


              <c:if test="${userObj.unitId!=0 && userObj.circleId==0 && userObj.divisionId==0 && userObj.subdivisionId==0 }">	
						   <c:if test="${userObj.unitId>0 && (userObj.designationId==5 || userObj.designationId==7 || userObj.designationId==9 || userObj.designationId==10 ) }">	
			
					<div class="row show-grid">
						<div class="col-md-2 "></div>
						<div class="col-md-12 ">
							<label class="label-control rowlebel "></label><input
								type="submit" class="btn btn-1 btn-primary center-block"
								id="addpowerinfo" value="Submit">
						</div>
					</div>
					
					 </c:if>
			 </c:if>	
					







				</div>
				<!-- row -->




		
		</form:form>

	</div>
	
	</div>




</div>





</div>

<div id="faqSpopup" class="ayucutFaq container">
    

   

    <div class="panel-group" id="accordion">
        <div class="faqHeader">General Clarifications</div>
        <div class="panel panel-default">
            <div class="panel-heading">
                <h4 class="panel-title">
                    <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion" href="#collapseOne"><b>Below Logins can be used to Enter ayacut Data</b></a>
                </h4>
            </div>
            <div id="collapseOne" class="panel-collapse collapse in">
                <div class="panel-body">
                     CE office CE/DCE logins are allowed to enter Ayacut data.
                    (Initially data has been accepted from  Subdivision Office (AEE,DEE), Division office  (AEE,DEE,EE) , Circle Office(AEE,DEE,EE) ,CE office(AEE,DEE,EE).)
                     Please ensure that data is not Duplicated.
                </div>
            </div>
        </div>
        <div class="panel panel-default">
            <div class="panel-heading">
                <h4 class="panel-title">
                    <a class="accordion-toggle collapsed" data-toggle="collapse" data-parent="#accordion" href="#collapseTen"><b>Tanks Ayacut is not included in this Ayacut Entry</b></a>
                </h4>
            </div>
            <div id="collapseTen" class="panel-collapse collapse in">
                <div class="panel-body">
                   Major and Medium project ayacut can be  entered village wise. If Village(optional) is available  or Mandal(Mandatory) wise.
                </div>
            </div>
        </div>
        <div class="panel panel-default">
            <div class="panel-heading">
                <h4 class="panel-title">
                    <a class="accordion-toggle collapsed" data-toggle="collapse" data-parent="#accordion" href="#collapseEleven"><b>Project</b></a>
                </h4>
            </div>
            <div id="collapseEleven" class="panel-collapse collapse in">
                <div class="panel-body">
                If you can not see the project in the project list. kindly give a message to the concerned Technical officer(E-gov Team). By confirming  the project should be added to that respective CE office along with Employee Details who is requesting.
                
                    
                </div>
            </div>
        </div>

        <div class="panel panel-default">
            <div class="panel-heading">
                <h4 class="panel-title">
                    <a class="accordion-toggle collapsed" data-toggle="collapse" data-parent="#accordion" href="#collapse1"><b>Package</b></a>
                </h4>
            </div>
            <div id="collapse1" class="panel-collapse collapse in">
                <div class="panel-body">
                   If Package is available in the list then select package. If package is not available in the Package list. Submit data with out package. By mentioning the package name in the remarks for future purpose.<br>
                   Package Names are from PMS. They will be Changed according to PMS.
                </div>
            </div>
        </div>
        
        <div class="panel panel-default">
            <div class="panel-heading">
                <h4 class="panel-title">
                    <a class="accordion-toggle collapsed" data-toggle="collapse" data-parent="#accordion" href="#collapse2"><b>Ayacut fields</b></a>
                </h4>
            </div>
            <div id="collapse2" class="panel-collapse collapse in">
                <div class="panel-body">
                New Ayacut Proposed in Acres*=Proposed Ayacut <br>
                Ayacut created in Acres*=Distributory Network is completed. But water is not given due to non completion of System. <br>
                Irrigated Ayacut in Acres*=Water is being fed. <br>
                Stabilized Ayacut in Acres*=Other Project Ayacut as proposed in DPR. <br>
                If data is not available please enter 0.00 in the above respective fields to submit form.
                </div>
            </div>
        </div>
        
        <div class="panel panel-default">
            <div class="panel-heading">
                <h4 class="panel-title">
                    <a class="accordion-toggle collapsed" data-toggle="collapse" data-parent="#accordion" href="#collapse3"><b>Villages</b></a>
                </h4>
            </div>
            <div id="collapse3" class="panel-collapse collapse in">
                <div class="panel-body">
                   Village is an  Optional field ( if data not available). If (2 or 3)Village data is not available  add cumulative ayacut pertaining to the respective Villages to the respective Mandals.
                   please use remarks field for future purpose.
                </div>
            </div>
        </div>
        
      
        
      
        
            
        </div>
    </div>


<!-- //main-content -->
<script type="text/javascript" src="../js/parsley.js"></script>



<script type="text/javascript" class="example">
	$(function() {
		$('#compayacutinput').parsley().on('field:validated', function() {
			var ok = $('.parsley-error').length === 0;

			 //alert('hi');

		})

		.on('form:submit', function() {
			 //alert("coming here");

			document.forms.compayacutinput.action = "../comptsimis/compayacutinput";
			document.forms.compayacutinput.submit();

			// Don't submit form for this demo
		});
	});
</script>

