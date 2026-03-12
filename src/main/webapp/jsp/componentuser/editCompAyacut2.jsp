
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
function getProjects(){
	
	 
    var   unitId=$('#unitId').val();
      
  //  alert("procId"+procId);
	$('#projectId').multiselect('rebuild');


	$.ajax({	          
	      url: "../web/getProjects?unitId="+unitId,
	      type: "GET",
	      success: function (response) {
	    	  var $select = $('#projectId');
	  			//	$select.find('option').remove();
	  				
	  				var selectedProj=$('#selectedProjectId').val();
	  					
	  					var obj = JSON.parse(response);
	  					
	  				$('#projectId').append( '<option value=" "> --select--</option>' );
	  					
	  					$.each(obj, function(key, value) {
	  						
	  						if(selectedProj==value.projectId){	
	  							
	  							/* $('#projectId').val(value.projectId);
	  							$('#projectName').val(value.projectName); */
	  						
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
	    	 
	    	  var $select = $('#packageId');
	  				$select.find('option').remove();
	  			
	  				var selectedPack=$('#selectpackId').val();
	  				
	  				
	  					
	  					var obj = JSON.parse(response);
	  					
	  				$('#packageId').append( '<option value="0"> --select--</option>' );
	  				
	  					
	  					$.each(obj, function(key, value) {
	  						
	  					
	  					if(selectedPack==value.pkgId){	
	  						
	  						
	  						
	  					$('#packageId').append( '<option value="'+value.pkgId+'" selected="selected" > '+value.pkgName+'</option>' );
	  					}
	  						if(selectedPack==null||selectedPack!=value.pkgId){
	  							
	  						$('#packageId').append( '<option value="'+value.pkgId+'"> '+value.pkgName+'</option>' );	
	  						
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
						if(selectedMandal==null||selectedMandal!=value.mandalCode){
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
		  
		  var selectedvillage=$('#selectvillage').val();
    	  
    	  
    	 
		
		  $('#villageId').append( '<option value="0"> --select--</option>' );
				var obj = JSON.parse(response);
				
				  
				$.each(obj, function(key, value) {
					
					//alert("coming1"+selectedvillage);
					
					if(selectedvillage==parseInt(value.villageCode)){	
						//alert("coming2"+value.villageCode);
						$('#villageId').append( '<option value="'+parseInt(value.villageCode)+'" selected="selected" > '+value.villageName+'</option>' );
						
					}
					if(selectedvillage==null||selectedvillage!=value.villageCode){
						//alert("coming2");
						$('#villageId').append( '<option value="'+parseInt(value.villageCode)+'"  > '+value.villageName+'</option>' );
					
					}
					
	  					
  	  				
						
				
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


  
	$(document).ready(function() {
		
		
		
		
		$('#packId').hide();
		
		//$('#conName').hide();
		
		
		/* 
		$('#unitId').multiselect({
			 
			 enableCaseInsensitiveFiltering: true
			 
		});
		 */
		$('#packageId').multiselect({
			 
			 enableCaseInsensitiveFiltering: true
			 
		});
		 
/* $('#oldDistrictId').multiselect({
			 
			 enableCaseInsensitiveFiltering: true
			 
		}); */
		 
		 
		 
		
		
		/* $('#projectId').multiselect({
			 
			 enableCaseInsensitiveFiltering: true
			 
		}); */
		$('#circleId').multiselect({
			 
			 enableCaseInsensitiveFiltering: true
			 
		});
		$('#divisionId').multiselect({
			 
			 enableCaseInsensitiveFiltering: true
			 
		});
		$('#subdivisionId').multiselect({
			 
			 enableCaseInsensitiveFiltering: true
			 
		});
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
				//alert(myproj+"myproj");
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
				
				
			
			} */
			
			/* $("#editcompbutton").click(function(){
				
				
				 $("#presentAyacutCreated").attr("readonly", false);
				 $("#stableAyacut").attr("readonly", false);
				 $("#remarks").attr("readonly", false);
				 
				
				 $("#editFlag").val(true);
				 
				 var j= $("#selectedUnitId").val();
				 $("#unitId").val(j);
				 var k= $("#unitId").val();
				// alert("k"+k);
				 
				 
			});  */
			
		

	});
	
	
	 
</script>
<script>
    window.onunload = refreshParent;
    function refreshParent() {
    	 self.close();
       window.opener.location.reload(true);
       
    }
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
			<h3 class="panel-title">Edit Ayacut Input</h3>
		</div>
		<form:form id="editcompayacutinput" method="post" modelAttribute="editcompayacutinput"
			data-parsley-validate-if-empty="">
			

             <!--  <div class="alert alert-info" role="alert">
				
				<strong>Note: Please Click on the Edit Button Before Submit</strong>

			</div>
               -->
   <div class="show-grid">
<div class="alert alert-info" role="alert">
				<strong> Note: Village and Package are Optional</strong>
				

			</div>
			</div>
   

				<div class="row col-md-12 toppad formText">
				
				<input type="hidden" class="form-control"  id="selectedProjectId" name="selectedProjectId" value="${selectedProjectId}" />
				<input type="hidden" class="form-control"  id="selectedUnitId" name="selectedUnitId" value="${selectedUnitId}"/>
				<input type="hidden" class="form-control"  id="selectedPackName" name="selectedPackName" value="${selectedPackName}" />
				<input type="hidden" class="form-control"  id="selectedDistrictId" name="selectedDistrictId" value="${selectedDistrictId}"/>
				<input type="hidden" class="form-control"  id="selectedMandalId" name="selectedMandalId" value="${selectedMandalId}"/>
				<input type="hidden" class="form-control"  id="selectedConstId" name="selectedConstId" value="${selectedConstId}"/>
                       <input type="hidden" class="form-control"  id="selectpackId" name="selectpackId" value="${selectpackId}"/>
                         <input type="hidden" class="form-control"  id="selectvillage" name="selectvillage" value="${selectvillage}"/>
                           <input type="hidden" class="form-control"  id="projAyacutId" name="projAyacutId" value="${projAyacutId}"/>
                            <input type="hidden" class="form-control"  id="	" name="constdistMapId" value="${constdistMapId}"/>
                           
                            <input type="hidden" class="form-control"  id="editFlag" name="editFlag" value="false"/>
                              <input type="hidden" class="form-control"  id="selectedolddistId" name="selectedolddistId" value="${selectedolddistId}"/>


					<div class="col-md-6">
						<div class="col-md-6">
							<label class="label-controlPMS rowlebel ">Unit<font color=red>*</font></label>
							
							
						</div>
						
						<div class="col-md-6">
						<input type="hidden" class="form-control" id="unitId"  
								name="unitId"  value="${ selectedUnitId}" readonly="readonly"/>
								
								<input type="text" class="form-control" id="unitName"  
								name="unitName"  value="${ unitName}" readonly="readonly"/>
						
						</div>
					<%-- 	<div class="col-md-6">
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



						<div class="col-md-6">
							<label class="label-controlPMS rowlebel ">Project<font color=red>*</font></label>
							
							
						</div>
						
						
						
						<%-- 	<div class="col-md-6">
							<input type="hidden" class="form-control" id="projectId"  
								name="projectId"  value="${ selectedProjectId}" readonly="readonly"/>
								
								<input type="text" class="form-control" id="projectName"  
								name="projectName"  value="${ projectName}" readonly="readonly"/>
							
							</div> --%>

						 <div class="col-md-6"> 


							 <select class="form-control" id="projectId" name="projectId" required
								onchange="getPackages(this.value)">

								<%-- <c:forEach items="${newprList}" var="u">
									<option value="${u.projectId}">${u.projectName}</option>

								</c:forEach> --%>

							</select> 
					</div>

						<div class="col-md-6">

							<label class="label-control rowlebel ">Package Name</label>
						</div>
						<div class="col-md-3">
							<select class="form-control" id="packageId"  name="packageId"   >
							</select>
						
						</div>

						<div class="col-md-3" id="packId">

							<input type="text" class="form-control" id="packageName"
								name="packageName" placeholder="EX:Package No-1" value=" " />
						</div>
						
						<div class="col-md-6">
							<label class="label-controlPMS rowlebel ">Select
								District <font color=red>*</font></label>
						</div>
						<div class="col-md-6">
							<select class="form-control" id="districtId" name="districtId"
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
						</div>
						
						<div class="col-md-6">
							<label class="label-controlPMS rowlebel ">Select Mandal <font color=red>*</font></label>
						</div>

						<div class="col-md-6">
							<select class="form-control" id="mandalId" name="mandalId"
								onchange="getConstituencies(districtId.value,this.value),getVillages(districtId.value,this.value)" required>

								<option value="">--select--</option>



							</select>
						</div>
						<div class="col-md-6">

							<label class="label-control rowlebel ">Constituency
								<font color=red>*</font></label>
						</div>
						<div class="col-md-6">
							<select class="form-control" id="constId" name="constId"
								 required>

								<option value="">--select--</option>
                               
							<%-- 	<c:forEach items="${constlist}" var="d">
								<c:choose>
								<c:when test="${d.constId==selectedConstId }">
									<option value="${d.constId}"selected="selected">${d.constName}</option>
									</c:when>
									<c:otherwise>
									<option value="${d.constId}">${d.constName}</option>
									</c:otherwise>
									</c:choose>

								</c:forEach> --%>


							</select>
						</div>
						
						<div class="col-md-6">
							<label class="label-controlPMS rowlebel ">Select Village</label>
						</div>
						<div class="col-md-6">
							<select class="form-control" id="villageId" name="villageId"
								>

								<option value="0">--select--</option>



							</select>
						</div>
						
                        
                        
                        
						<%-- <div class="col-md-6 ">
							<label class="label-controlPMS rowlebel ">Select Old District*</label>
						</div>
						<div class="col-md-6 ">
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


						<div class="col-md-6">
							<label class="label-controlPMS rowlebel ">Component
								Category</label>
						</div>
						<div class="col-md-6">
							<select class="form-control" id="componentCategoryId"
								name="componentCategoryId" required  onchange="getCompTypes()">

								<option value="0">--select--</option>
								<option value="1">Reservoir</option>
								<option value="2">Lift</option>
								<option value="3">Canal</option>
								<c:forEach items="${caseGenList}" var="p">
									<option value="${p.caseGenId}">${p.caseGeneral}</option>

								</c:forEach>


							</select>
						</div>


						<div class="col-md-6">
							<label class="label-controlPMS rowlebel ">Component Type</label>
						</div>
						<div class="col-md-6">
							<select class="form-control" id="componentTypeId"
								name="componentTypeId" required >

								<option value="0">--select--</option>
								
							


							</select>
						</div>
						</div> --%>
						
						<!-- <div class="col-md-6">
												<label class="label-control rowlebel ">Parent
													Component*</label>
											</div>

											<div class="col-md-3">
												<select class="form-control" id="parentComponentId" name="parentComponentId"
													required>
													<option value="0">--select--</option>
													<option value="-1">No Parent--</option>


												</select>




											</div>
 -->










					</div>
					<div class="col-md-6">

						<!-- <div class="col-md-6" id="component">


							<label class="label-control rowlebel ">From
								Location(Name)</label>
						</div>
						<div class="col-md-3">
							<input type="text" class="form-control" id="fromlocation"
								name="fromlocation" placeholder="from location" required />
						</div>
						<div class="col-md-3">
							<input type="text" class="form-control" id="fromlocation"
								name="fromKM" placeholder="from Km" required />
						</div>
						<div class="col-md-6">
							<label class="label-control rowlebel ">TO Location(Name)</label>
						</div>
						<div class="col-md-3">
							<input type="text" class="form-control" id="tolocation"
								name="tolocation" placeholder="to location" required />
						</div>
						<div class="col-md-3">
							<input type="text" class="form-control" id="toKM" name="toKM"
								placeholder="To Km" required />




						</div>
 -->

						<!-- <div class="col-md-6" id="component">


							<label class="label-control rowlebel ">Component Length</label>
						</div>

						<div class="col-md-6">
							<input type="text" class="form-control" id="componentLength"
								name="componentLength" placeholder="length in Km" required />




						</div> -->

						<!-- <div class="col-md-6">

							<label class="label-control rowlebel ">Component
								Direction*</label>
						</div>

						<div class="col-md-6">
							<select class="form-control" id="componentDirection"
								name="componentDirection" required>

								<option value="0">--select--</option>
								<option value="1">Left</option>
								<option value="2">Right</option>


							</select>
						</div> -->

						

						
						
						

						<!-- <div class="col-md-3" id="conName">

							<input type="text" class="form-control" id="constName"
								name="constName" placeholder="ex:Constituency"  />
						</div> -->


						
						

						

    
						 		

                    <%--    <div class="col-md-6">

							<label class="label-control rowlebel ">Ayacut Year<font color=red>*</font></label>
						</div>
						
						<div class="col-md-5">

								<input type="text" class=" form-control "  id="datepicker2" name="ayacutYear" placeholder="ayacutYear"  value="${selectedAyacutYear}"   readonly="readonly"/> 
						</div>
 --%>


						<div class="col-md-6">

							<label class="label-control rowlebel ">New Ayacut Proposed (Contemplated) in Acres<font color=red>*</font></label>
						</div>

						<div class="col-md-5">

							<input type="text" class="form-control" id="contemplatedAyacut"  data-parsley-pattern="^[0-9]*\.[0-9]{2}$" data-parsley-trigger="blur" 
								data-parsley-error-message="You must enter in Acres upto two decimals ex:10.01" name="contemplatedAyacut" placeholder="10.01" required  value="${selectAyacutContemplatedAcres}"/>
						</div>
						
						<div class="col-md-6">

							<label class="label-control rowlebel ">Ayacut Created in Acres<font color=red>*</font></label>
						</div>

						<div class="col-md-5">

							<input type="text" class="form-control" id="ayacutCreated"  data-parsley-pattern="^[0-9]*\.[0-9]{2}$" data-parsley-trigger="blur"
								data-parsley-error-message="You must enter in Acres upto two decimals ex:10.01" name="ayacutCreated" placeholder="in Acres" required  value="${selectAyacutCreatedAcres}"/>
						</div>
						 <div class="col-md-6">

							<label class="label-control rowlebel ">Irrigated Ayacut in Acres<font color=red>*</font></label>
						</div>

						<div class="col-md-5">

							<input type="text" class="form-control" id="irriagtedAyacut"  data-parsley-pattern="^[0-9]*\.[0-9]{2}$" data-parsley-trigger="blur"
							data-parsley-error-message="You must enter in Acres upto two decimals ex:10.01"	name="irriagtedAyacut" placeholder="10.01" required  value="${selectIrriAyacutAcres}"/>
						</div>
 
						<!--  <div class="col-md-6">

							<label class="label-control rowlebel "></label>
							
							 Stabilized Ayacut  in Acres
						</div> -->

						<div class="col-md-5">

							<input type="hidden" class="form-control" id="stableAyacut"   data-parsley-pattern="^[0-9]*\.[0-9]{2}$" data-parsley-trigger="blur" value="0.01" readonly="readonly"
							data-parsley-error-message="You must enter in Acres upto two decimals ex:10.01"	name="stableAyacut" placeholder="10.01" value="${ selectStableAcres}"/>
						</div>
						 












					</div>




					<div id="addedRows"></div>


					<div class="row show-grid">

						<div class="col-md-1"></div>
						<div class="col-md-1"></div>
					</div>



					<div class="row show-grid">


						<div class="col-md-12">
							<label class="label-control rowlebel ">Remarks</label>
							<textarea class="form-control" id="remarks" name="remarks" ><c:out value="${ selectremarks}"></c:out> </textarea>
						</div>

					</div>


				
									  <div class="row show-grid ">
                   <!--     <div class="col-md-4 ">
							<label class="label-control rowlebel "></label><input
								type="button" class="btn btn-1 btn-primary center-block"
								id="editcompbutton" value="Edit" >
						</div> -->
						<div class="col-md-4 "></div>
						<div class="col-md-4 ">
							<label class="label-control rowlebel "></label><input
								type="submit" class="btn btn-1 btn-primary center-block"
								id="submitcomp" value="Submit" ></div>
						 <div class="col-md-4 ">
						
						</div>
						</div>

				</div>
				<!-- row -->




			
		</form:form>
		
		<div class="row show-grid">
		</div>
	<%-- 	<form:form id="cancelcompform" method="post" modelAttribute="editcomp"  data-parsley-validate-if-empty=""  >
 
<div class="row show-grid">
					<br></br>
					<div class="col-md-5"></div>
					<div class="col-md-2">
					<input type="hidden" class="form-control"  id="projAyacutId" name="projAyacutId" value="<c:out value="${projAyacutId}"></c:out>"/>
					<input type="hidden" class="form-control"  id="editFlag" name="editFlag" value="false" />
						<input type="submit" class="btn btn-1 btn-primary center-block"
							id="caseeditId" value="Cancel Edit" >
					</div>
					<div class="col-md-5"></div>
					
					</div>	
 

 </form:form> --%>
		

	</div>







</div>

<!-- //main-content -->
<script type="text/javascript" src="../js/parsley.js"></script>



<script type="text/javascript" class="example">
$(function() {
	$('#editcompayacutinput').parsley().on('field:validated', function() {
		var ok = $('.parsley-error').length === 0;

		 //alert('hi');

	})

	.on('form:submit', function() {
		// alert("coming here");
		  $("#editFlag").val(true);

		document.forms.editcompayacutinput.action = "../comptsimis/editCompAyacut";
		document.forms.editcompayacutinput.submit();

		// Don't submit form for this demo
	});
});
</script>

<!-- <script type="text/javascript" class="example">
$(function () {
 $('#cancelcompform').parsley().on('field:validated', function() {
	    var ok = $('.parsley-error').length === 0;
	
	   // alert('hi');
	    
	  })
	  
	  .on('form:submit', function() {
		 // alert("coming here");
		  
		 
			
		  document.forms.cancelcompform.action="../comptsimis/editCompAyacut";
			 document.forms.cancelcompform.submit(); 
			
		
			
		  
		  
		    // Don't submit form for this demo
		  });
});
</script> -->


