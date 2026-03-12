
<!--main code block-->
<!-- sec-section -->

<!-- create component start here -->
<%@include file="/jsp/header/taglib_includes.jsp"%>
<title>O&M Tank Checks</title>



<link rel="stylesheet" href="../css/bootstrap-multiselect.css"
	type="text/css">
<script type="text/javascript" src="../js/bootstrap-multiselect.js"></script>
<script type="text/javascript" src="../js/jquery-ui.js"></script>
<link rel="stylesheet" media="screen" href="../css/jquery-ui.css">
<script type="text/javascript" src="../js/invomReports/res_ann1_abs.js"></script>

<script src="../js/newcharts/core.js"></script>
<script src="../js/newcharts/charts.js"></script>
<script src="../js/newcharts/animated.js"></script>


<link rel="stylesheet"
	href="../css/Html5DataTable/jquery.dataTables.min.css" />
<link rel="stylesheet"
	href=" ../css/Html5DataTable/buttons.dataTables.min.css" />






<script type="text/javascript">
		$(function() {
			/* $("#tree").treeview({
				collapsed: true,
				animated: "medium",
				control:"#sidetreecontrol",
				persist: "location"
			});
			 */
			


		})
		
	</script>

<script>
$(document).ready(function(){

	
	
	
	
	

	MergeCommonRows($("#table1"), 1);
	MergeCommonRows($("#table1"), 2);
	
	
	
	
	
	
	
	 


	 
	  
			
});


function MergeCommonRows(table, columnIndexToMerge) {
	
    previous = null;
    cellToExtend = null;
    table.find("td:nth-child(" + columnIndexToMerge + ")").each(
            function() {
                jthis = $(this);
                content = jthis.text();
                if (previous == content) {
                	
                    jthis.remove();
                    if (cellToExtend.attr("rowspan") == undefined) {
                        cellToExtend.attr("rowspan", 2);
                    } else {
                        currentrowspan = parseInt(cellToExtend
                                .attr("rowspan"));
                        cellToExtend.attr("rowspan",
                                currentrowspan + 1);
                    }
                } else {
                    previous = content;
                    cellToExtend = jthis;
                }
            });
};






$(function() {
	
	

	
	
	
	
	
});
</script>

 <script type="text/javascript">
  function getResInfo(rescode,year,unitId){
	
	//alert(rescode+year+unitId);
	
	
$.ajax({
    type: "GET", //rest Type
    dataType: 'json', //mispelled
    url: "../invReport/res-ann1-res-Info?reservoirId="+rescode+"&year="+year+"&unitId="+unitId,
    async: false,
    contentType: "application/json; charset=utf-8",
    success: function (msg) {
        console.log(""+msg); 
    	 $('#dialog-para1').empty();
         $('#dialog-para1').append( '<div  class="col-md-12 invDiv " style="font-weight:bold;color:black">Reservoir info  </div>');            
       



 	
 	 
         $("#dialog-para1").append('<div  class="col-md-3 " style="font-weight:bold;" >  Reservoir Name </div> <div  class="col-md-3 " style="font-weight:bold;" > : '+msg[0].resName +'</div><div  class="col-md-3 " style="font-weight:bold;" > ReservoirStatus</div> <div  class="col-md-3 " style="font-weight:bold;" > : '+msg[0].resStatus+'</div>'); 

       


         $("#dialog-para1").append('<div  class="col-md-3 " style="font-weight:bold;" >  unit Name </div> <div  class="col-md-3 " style="font-weight:bold;" > : '+msg[0].unitName +'</div><div  class="col-md-3 " style="font-weight:bold;" >  Circle Name </div> <div  class="col-md-3 " style="font-weight:bold;" > : '+msg[0].circleName  +'</div>');



         $("#dialog-para1").append('<div  class="col-md-3 " style="font-weight:bold;" >   division Name </div> <div  class="col-md-3 " style="font-weight:bold;" > : '+msg[0].divisionName  +'</div><div  class="col-md-3 " style="font-weight:bold;" >  Sub Division Name </div> <div  class="col-md-3 " style="font-weight:bold;" > : '+msg[0].subdivisionName  +'</div>');

         $("#dialog-para1").append('<div  class="col-md-3 " style="font-weight:bold;" > Circle Name  </div> <div  class="col-md-3 " style="font-weight:bold;" > : '+msg[0].projectName +'</div><div  class="col-md-3 " style="font-weight:bold;" >  year </div> <div  class="col-md-3 " style="font-weight:bold;" > : '+ msg[0].year  +'</div>');
         
        


             
    }
}); 

$.ajax({
    type: "GET", //rest Type
    dataType: 'json', //mispelled
    url: "../invReport/res-ann1-gen-Info?reservoirId="+rescode+"&year="+year+"&unitId="+unitId,
    async: false,
    contentType: "application/json; charset=utf-8",
    success: function (msg2) {
        console.log("gen"+msg2); 
      //  alert("kal"+msg2);
        
        
    	 $('#gen').empty();
      /*    $('#emb').append('<div id="main3" class="col-md-12 "> '+
 		 '<div  class="col-md-12 " style="background-color:grey; color:white; font-weight:bold; float:left;">Tank info  </div>');            
       
 */
 
 $('#gen').append('<div  class="row col-md-12 invDiv" style="font-weight:bold;color:black" ><h3>A.GENERAL</h3></div>')
 $("#gen").append('<div  class="row col-md-12 invDiv" style="font-weight:bold;color:blue" > <div  class="col-md-4 " style="font-weight:bold;" >Inspection Name</div><div  class="col-md-4 " style="font-weight:bold;" >  Remarks</div> <div  class="col-md-4 " style="font-weight:bold;" >Status</div></div>');
 for(i in  msg2 ){
	 var j=parseInt(i)+1; 
 	
	 
         $("#gen").append('<div  class="row col-md-12" > <div  class="col-md-4 invDiv" style="font-weight:bold;" > '+msg2[i].resCheckName+' </div> <div  class="col-md-4 " style="font-weight:bold;" >  '+msg2[i].remarks+'</div>  <div  class="col-md-4 " style="font-weight:bold;" >  msg2[i].statusName </div> </div>'); 

         
  } 

         

             
    }
});

$.ajax({
    type: "GET", //rest Type
    dataType: 'json', //mispelled
    url: "../invReport/res-ann1-ear-Info?reservoirId="+rescode+"&year="+year+"&unitId="+unitId,
    async: false,
    contentType: "application/json; charset=utf-8",
    success: function (msg2) {
        console.log("ear"+msg2); 
      //  alert("kal"+msg2);
        
        
    	 $('#ear').empty();
      /*    $('#emb').append('<div id="main3" class="col-md-12 "> '+
 		 '<div  class="col-md-12 " style="background-color:grey; color:white; font-weight:bold; float:left;">Tank info  </div>');            
       
 */
 
 $('#ear').append('<div  class="row col-md-12 invDiv" style="font-weight:bold;color:black" ><h3>B.EARTH / ROCK FILL DAMS</h3></div>')
 $("#ear").append('<div  class="row col-md-12 invDiv" style="font-weight:bold;color:blue" > <div  class="col-md-4 " style="font-weight:bold;" >Inspection Name</div><div  class="col-md-4 " style="font-weight:bold;" >  Remarks</div> <div  class="col-md-4 " style="font-weight:bold;" >Status</div></div>');
 for(i in  msg2 ){
	 var j=parseInt(i)+1; 
 	
	 
         $("#ear").append('<div  class="row col-md-12" > <div  class="col-md-4 invDiv" style="font-weight:bold;" > '+msg2[i].resCheckName+' </div> <div  class="col-md-4 " style="font-weight:bold;" >  '+msg2[i].remarks+'</div>  <div  class="col-md-4 " style="font-weight:bold;" >  msg2[i].statusName</div> </div>'); 

         
  } 

         

             
    }
}); 

$.ajax({
    type: "GET", //rest Type
    dataType: 'json', //mispelled
    url: "../invReport/res-ann1-con-Info?reservoirId="+rescode+"&year="+year+"&unitId="+unitId,
    async: false,
    contentType: "application/json; charset=utf-8",
    success: function (msg2) {
       console.log("con"+msg2); 
      //  alert("kal"+msg2);
        
        
    	 $('#con').empty();
      /*    $('#emb').append('<div id="main3" class="col-md-12 "> '+
 		 '<div  class="col-md-12 " style="background-color:grey; color:white; font-weight:bold; float:left;">Tank info  </div>');            
       
 */
 
 $('#con').append('<div  class="row col-md-12 invDiv" style="font-weight:bold;color:black" ><h3>C.CONCRETE / MASONRY DAMS</h3></div>')
 $("#con").append('<div  class="row col-md-12 invDiv" style="font-weight:bold;color:blue" > <div  class="col-md-4 " style="font-weight:bold;" >Inspection Name</div><div  class="col-md-4 " style="font-weight:bold;" >  Remarks</div> <div  class="col-md-4 " style="font-weight:bold;" >Status</div></div>');
 for(i in  msg2 ){
	 var j=parseInt(i)+1; 
 	
	 
         $("#con").append('<div  class="row col-md-12" > <div  class="col-md-4 invDiv" style="font-weight:bold;" > '+msg2[i].resCheckName+' </div> <div  class="col-md-4 " style="font-weight:bold;" >  '+msg2[i].remarks+'</div>  <div  class="col-md-4 " style="font-weight:bold;" >  msg2[i].statusName</div> </div>'); 

         
  } 

         

             
    }
}); 

$.ajax({
    type: "GET", //rest Type
    dataType: 'json', //mispelled
    url: "../invReport/res-ann1-om-Info?reservoirId="+rescode+"&year="+year+"&unitId="+unitId,
    async: false,
    contentType: "application/json; charset=utf-8",
    success: function (msg2) {
        console.log("om"+msg2); 
      //  alert("kal"+msg2);
        
        
    	 $('#ope').empty();
      /*    $('#emb').append('<div id="main3" class="col-md-12 "> '+
 		 '<div  class="col-md-12 " style="background-color:grey; color:white; font-weight:bold; float:left;">Tank info  </div>');            
       
 */
 
 $('#ope').append('<div  class="row col-md-12 invDiv" style="font-weight:bold;color:black" ><h3>D.OPERATION AND MAINTENANCE</h3></div>')
 $("#ope").append('<div  class="row col-md-12 invDiv" style="font-weight:bold;color:blue" > <div  class="col-md-4 " style="font-weight:bold;" >Inspection Name</div><div  class="col-md-4 " style="font-weight:bold;" >  Remarks</div> <div  class="col-md-4 " style="font-weight:bold;" >Status</div></div>');
 for(i in  msg2 ){
	 var j=parseInt(i)+1; 
 	
	 
         $("#ope").append('<div  class="row col-md-12" > <div  class="col-md-4 invDiv" style="font-weight:bold;" > '+msg2[i].resCheckName+' </div> <div  class="col-md-4 " style="font-weight:bold;" >  '+msg2[i].remarks+'</div>  <div  class="col-md-4 " style="font-weight:bold;" >  msg2[i].statusName</div> </div>'); 

         
  } 

         

             
    }
}); 





	
	$("#dialog-para").dialog({
	    modal: true,
	    draggable: true,
	    resizable: true,
	    position: ['center', 'center'],
	    show: 'blind',
	    hide: 'blind',
	    width: 1200,
	    height:600,
	    dialogClass: 'ui-dialog-osx',
	    buttons: {
	        "close para": function() {
	            $(this).dialog("close");
	        }
	    },
	    open: function() {
	       // $('#infotabs').tabs( );
	        //intabs function 
	        /*  create: function(e, ui) {
                $('#closeBtn').click(function() {
                    $('#dialog-para').dialog('close');
                });
            } */
	      // $(this).parent().children('.ui-dialog-titlebar').remove();
	    }
	});getResAnnexureinfo

} 

/* function getresabstractdata(year,dutyFrequencyId,formId,flag)
{
	
	
	
	 $("#formyear1").val(year);
	//alert("formId"+formId);
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
		
	
	
		

	
	
		
		
	
	//	alert(" "+year+" "+formId+ " " +flag);
		
	
		/* var unit = $("#uformUnitId").val();
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
		
		$('#formyear1').val(year);
		
		$('#uformdutyFrequencyId').val(dutyFrequencyId);
		
		
		
		
	//	alert("officeaccess" +officeaccess);

	//alert("tanks uform abdata officeaccess" +officeaccess+"unit"+unit+"circle"+circle+"division"+division+"subdivision"+subdivision+"designation"+designation+"year"+year);

		var act1 = "../invReport/res-ann1-abstract";
		var newformId1 = "#" + formId;

		$(newformId1).attr("action", act1);

		$(newformId1).submit();
		
	

	
	
	} 
	 */
	
	
	
	
	function getresabstractdata(year,dutyFrequencyId,formId,flag)
	{
		 
		
		 
		 var formIdtarget="#"+formId;
			
			var attr = $(formIdtarget).attr('target');

			// For some browsers, `attr` is undefined; for others,
			// `attr` is false.  Check for both.
			
			//alert("attr"+attr);
			if (typeof attr !== 'undefined' || attr !== false) {
			   
				 $(formIdtarget).removeAttr('target');
			}
			
		 
		
		 $("#formyear1").val(year);
		 	
	 	 $("#uformdutyFrequencyId").val(dutyFrequencyId);
		
	//alert(cagGistId);
		/*document.forms[0].urlvalue.value="../invReport/res-ann1-abstract";
		
		   $("#year").val(year);
		   
		   $("#dutyFrequencyId").val(dutyFrequencyId);
		   
		
		var act = "../invReport/res-ann1-abstract";
		var formId = "#" + formId;
		$(formId).attr("action", act);
		$(formId).submit();*/
		
		
		
		if(flag==true){
			$('#year').removeAttr('required'); 
			
			$('#dutyFrequencyId').removeAttr('required'); 
			
		}
			
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

								//alert("2 designation"+designation);
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
								//alert("3 designation"+designation);
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
		
	
	
function getResAnnexureinfo(resInspectAnn1Mst1Id,resId,tankId,resinspectInfoId,annId,formId){
	
//alert("resInspectAnn1Mst1Id"+resInspectAnn1Mst1Id);
	
	$("#resInspectMst1Id").val(resInspectAnn1Mst1Id);
	
	$("#reservoirId").val(resId);
	
	$("#tankId").val(tankId);
	
	
	
	$("#annexureId").val(annId);
	
	$("#resinspectInfoId").val(resinspectInfoId);
	
	var xy=$("#resInspectAnn1Mst1Id").val();
	
	var formIdtarget="#"+formId;
	
	var attr = $(formIdtarget).attr('target');

	// For some browsers, `attr` is undefined; for others,
	// `attr` is false.  Check for both.
	
	//alert("attr"+attr);
	if (typeof attr == 'undefined' || attr == false) {
	   
		 $(formIdtarget).attr('target', '_blank');
	}
	
	
	//alert("xy"+xy);
	
	var act = "../invomReport/downloadResAnnexure1";
	var formId = "#" + formId;
	$(formId).attr("action", act);
	$(formId).submit();
	
}



function getResSalientinfo(resInspectAnn1Mst1Id,tankId, reservoirId,resinspectInfoId, formId){
	
	//alert("resInspectAnn1Mst1Id"+resInspectAnn1Mst1Id);
	
	$("#resInspectMst1Id").val(resInspectAnn1Mst1Id);
	$("#tankId").val(tankId);
	$("#reservoirId").val(reservoirId);
	$("#resinspectInfoId").val(resinspectInfoId);
	
var formIdtarget="#"+formId;
	
	var attr = $(formIdtarget).attr('target');

	// For some browsers, `attr` is undefined; for others,
	// `attr` is false.  Check for both.
	
	//alert("attr"+attr);
	if (typeof attr == 'undefined' || attr == false) {
	   
		 $(formIdtarget).attr('target', '_blank');
	}
	
	//alert("xy"+xy);
	
	var act = "../invomReport/pdfReservoirSalient";
	var formId = "#" + formId;
	$(formId).attr("action", act);
	$(formId).submit();
	
}


function getResHealthStatusinfo(resInspectAnn1Mst1Id,tankId, reservoirId,formId){
	
	//alert("resInspectAnn1Mst1Id"+resInspectAnn1Mst1Id);
	
	$("#resInspectMst1Id").val(resInspectAnn1Mst1Id);
	$("#tankId").val(tankId);
	$("#reservoirId").val(reservoirId);
	
	
var formIdtarget="#"+formId;
	
	var attr = $(formIdtarget).attr('target');

	// For some browsers, `attr` is undefined; for others,
	// `attr` is false.  Check for both.
	
	//alert("attr"+attr);
	if (typeof attr == 'undefined' || attr == false) {
	   
		 $(formIdtarget).attr('target', '_blank');
	}
	
	//alert("xy"+xy);
	
	var act = "../invomReport/pdfhealthstatus";
	var formId = "#" + formId;
	$(formId).attr("action", act);
	$(formId).submit();
	
}

function getEvalResAnnexureinfo(resInspectAnn1Mst1Id,reservoirId,tankId, resinspectInfoId,annId,formId){
	
$("#resInspectMst1Id").val(resInspectAnn1Mst1Id);
	
	$("#annexureId").val(annId);
	
	$("#tankId").val(tankId);
	$("#reservoirId").val(reservoirId);
	
	$("#resinspectInfoId").val(resinspectInfoId);
	
	
	
	var xy=$("#resInspectAnn1Mst1Id").val();
	
var formIdtarget="#"+formId;
	
	var attr = $(formIdtarget).attr('target');

	// For some browsers, `attr` is undefined; for others,
	// `attr` is false.  Check for both.
	
	//alert("attr"+attr);
	if (typeof attr == 'undefined' || attr == false) {
	   
		 $(formIdtarget).attr('target', '_blank');
	}
	
	//alert("xy"+xy);
	
	var act = "../invomReport/EvaluatAnn2";
	var formId = "#" + formId;
	$(formId).attr("action", act);
	$(formId).submit();
	
}

function getGenResinfo(resInspectAnn1Mst1Id,formId){
	
	$("#resInspectMst1Id").val(resInspectAnn1Mst1Id);
		
	//	$("#annexureId").val(annId);
		
		var xy=$("#resInspectAnn1Mst1Id").val();
		
		//alert("xy"+xy);
		
		var formIdtarget="#"+formId;
	
	var attr = $(formIdtarget).attr('target');

	// For some browsers, `attr` is undefined; for others,
	// `attr` is false.  Check for both.
	
	//alert("attr"+attr);
	if (typeof attr == 'undefined' || attr == false) {
	   
		 $(formIdtarget).attr('target', '_blank');
	}
		
		var act = "../invomReport/resgeninf";
		var formId = "#" + formId;
		$(formId).attr("action", act);
		$(formId).submit();
		
	}
	
	
function getGenResinfo(resInspectAnn1Mst1Id,tankId, reservoirId,resinspectInfoId,formId){
	
	$("#resInspectMst1Id").val(resInspectAnn1Mst1Id);
	$("#tankId").val(tankId);
	$("#reservoirId").val(reservoirId);
	
	$("#resinspectInfoId").val(resinspectInfoId);
	
	
	
		
	//	$("#annexureId").val(annId);
		
		var xy=$("#resInspectAnn1Mst1Id").val();
		
		//alert("xy"+xy);
		
		var formIdtarget="#"+formId;
		
		var attr = $(formIdtarget).attr('target');

		// For some browsers, `attr` is undefined; for others,
		// `attr` is false.  Check for both.
		
		//alert("attr"+attr);
		if (typeof attr == 'undefined' || attr == false) {
		   
			 $(formIdtarget).attr('target', '_blank');
		}
		
		
		var act = "../invomReport/resgeninf";
		var formId = "#" + formId;
		$(formId).attr("action", act);
		$(formId).submit();
		
	}
	
	function getinspectdetails(resInspectAnn1Mst1Id,tankId, reservoirId,resinspectInfoId,formId){
		
		$("#resInspectMst1Id").val(resInspectAnn1Mst1Id);
		$("#tankId").val(tankId);
		$("#reservoirId").val(reservoirId);
		
		$("#resinspectInfoId").val(resinspectInfoId);
		
		
		
			
		//	$("#annexureId").val(annId);
			
			var xy=$("#resInspectAnn1Mst1Id").val();
			
			var formIdtarget="#"+formId;
			
			var attr = $(formIdtarget).attr('target');

			// For some browsers, `attr` is undefined; for others,
			// `attr` is false.  Check for both.
			
			//alert("attr"+attr);
			if (typeof attr == 'undefined' || attr == false) {
			   
				 $(formIdtarget).attr('target', '_blank');
			}
			
			//alert("xy"+xy);
			
			var act = "../invomReport/resinspectinf";
			var formId = "#" + formId;
			$(formId).attr("action", act);
			$(formId).submit();
		
		
	}
	
	
	function viewdamphtfnserver(resInspectmst1Id,tankId, reservoirId,sourceName,formId){
		
		//alert("formdataId"+formdataId)
		
		//alert("formId"+formId);
		
			$("#resInspectMst1Id").val(resInspectmst1Id);
		$("#tankId").val(tankId);
		$("#reservoirId").val(reservoirId);
		
		$("#sourceName").val(sourceName);
		
		
	var formIdtarget="#"+formId;
		
		var attr = $(formIdtarget).attr('target');

		// For some browsers, `attr` is undefined; for others,
		// `attr` is false.  Check for both.
		
		//alert("attr"+attr);
		if (typeof attr == 'undefined' || attr == false) {
		   
			 $(formIdtarget).attr('target', '_blank');
		}
		
		
			
			
			var act1 = "../invReport/get-daminspect-photos"
	var newformId1 = "#"+formId ;

	$(newformId1).attr("action", act1);

	$(newformId1).submit();
		
		

			
			
		
	}
	
	
function getResRemarksStatusinfo(resInspectmst1Id,tankId, reservoirId,formId){
		
		//alert("formdataId"+formdataId)
		
		//alert("formId"+formId);
		
			$("#resInspectMst1Id").val(resInspectmst1Id);
		$("#tankId").val(tankId);
		$("#reservoirId").val(reservoirId);
		
	
		
		
	var formIdtarget="#"+formId;
		
		var attr = $(formIdtarget).attr('target');

		// For some browsers, `attr` is undefined; for others,
		// `attr` is false.  Check for both.
		
		//alert("attr"+attr);
		if (typeof attr == 'undefined' || attr == false) {
		   
			 $(formIdtarget).attr('target', '_blank');
		}
		
		
			
			
			var act1 = "../invomReport/getRemarksinfo"
	var newformId1 = "#"+formId ;

	$(newformId1).attr("action", act1);

	$(newformId1).submit();
		
	
		
	}
	
function viewdaminformation(resInspectmst1Id,tankId, reservoirId,sourceName,formId){
		
		//alert("formdataId"+formdataId)
		
		//alert("formId"+formId);
		
			$("#resInspectMst1Id").val(resInspectmst1Id);
		$("#tankId").val(tankId);
		$("#reservoirId").val(reservoirId);
		
		$("#sourceName").val(sourceName);
		
		
	var formIdtarget="#"+formId;
		
		var attr = $(formIdtarget).attr('target');

		// For some browsers, `attr` is undefined; for others,
		// `attr` is false.  Check for both.
		
		//alert("attr"+attr);
		if (typeof attr == 'undefined' || attr == false) {
		   
			 $(formIdtarget).attr('target', '_blank');
		}
		
		
			
			
			var act1 = "../invReport/get-dam-total-info"
	var newformId1 = "#"+formId ;

	$(newformId1).attr("action", act1);

	$(newformId1).submit();
		
		

			
			
		
	}






       
    </script>



<div class="col-md-9">
	

	

	<div>

		

	

	
	
		
	





		<div class="panel panel-primary  " >
			<div class="panel-heading">
				<h3 class="panel-title"> Reservoir Inspection Checklist Detail</h3>
			</div>

			




				<div class="panel-body">


		
<div class="alert alert-info" role="alert">
 <strong>Note : Please Use A4(landscape) Size Paper for Print. Also Selected Data Can be Exported and Printed</strong>
</div>





				

				
<form:form id="resann1report" method="post" modelAttribute="resann1reportattr"  >

<!-- backbutton start -->

 <c:if test="${userObj!=null}">	
					 
					 <input name="unitId" value="${userObj.unitId}" class=" form-control " id="uformUnitId" type="hidden" />
					  <input name="circleId" value="${userObj.circleId}" class=" form-control " id="uformCircleId" type="hidden" />
					  <input name="divisionId" value="${userObj.divisionId}" class=" form-control " id="uformDivisionId" type="hidden" />
					   <input name="subdivisionId" value="${userObj.subdivisionId}" class=" form-control " id="uformSubdivisionId" type="hidden" />
					    <input name="designationId" value="${userObj.designationId}" class=" form-control " id="uformdrilldesgId" type="hidden" />
					    <input name="listDesignationId"  class=" form-control " id="uformlistdesgId" type="hidden" />
					     <input name="postId" value="${userObj.post}" class=" form-control " id="uformPostId" type="hidden" />
					      <input name="year"  class=" form-control "  id="formyear1" value="0" type="hidden" />
					       <input name="dutyFrequencyId"  class=" form-control "  id="uformdutyFrequencyId" value="0" type="hidden" />
					        <input    name="offAccess" class=" form-control " id="uformOfficeAccess" type="hidden" />
					        
					          <input  value="${userObj.designationId}" class=" form-control " id="uformDesignationId" type="hidden" />
					        
					        </c:if>

<!-- backbutton end -->

	<input name=resInspectMst1Id id="resInspectMst1Id" value="0" type=hidden>
	<input name=annexureId id="annexureId" value="0" type=hidden>
	
	<input name=tankId id="tankId" value="0" type=hidden>
	
	<input name=reservoirId id="reservoirId" value="0" type=hidden>
	
	<input name=resinspectInfoId id="resinspectInfoId" value="0" type=hidden>
	
	<input name=sourceName id="sourceName" value="NA" type=hidden>
	
	<input name=resinspectInfoId id="resinspectInfoId" value="NA" type=hidden>
	
	
	
	
	 <br><br>
	 
	 	<div class="row show-grid ">
		<c:if test="${resUnitData!=null}">
		
			
		<div class="col-md-12"  id="rebackdata">
		
		<button type="button" name="backtoreportinint" id="backtoreport1" class="btn btn-1 btn-primary center-block " onclick="getresabstractdata(${resUnitData[0].year},${resUnitData[0].dutyFrequencyId},'resann1report','true')"><b>Back to Initial Abstract Data</b></button>
				
				<br><br>
				</div>	
				</c:if>
				
	 
	</div>

					<div
						class="show-grid gridList mainprint pagecontent"
						>

<%-- <c:if test="${compCapList!=null}"> --%>

						<div class="table-responsive" id="printarea">

							<table class=" display table-bordered " style="width:100%" id="table1">
								<thead >
									
									<tr style="font-size: 12px">
									<th  style="text-align: center;">Sl.No</th>
									<th  style="text-align: center;">Reservoir Name</th>
									<th  style="text-align: center;">Office</th>
									<th  style="text-align: center;">Project Name</th>	
									
								<!-- 	<th  style="text-align: center;">General Details</th>			 -->		
									
									<th  style="text-align: center;">Inspection Details (Downloads)
									</th>
									<!-- <th  style="text-align: center;">Downloads (Inspection photographs)
										</th>
										
										<th  style="text-align: center;">Health Status
										</th>
										
										<th  style="text-align: center;">Remarks Info
										</th>
									 -->
								
								
									
									
									
								






								</tr>

									

									

								</thead> 

                             
									<tbody>

								<c:forEach items="${resUnitData}" var="t" varStatus="count">
								
								
								<tr style="font-size: 11px">	<td style="text-align: center;"><b><c:out
												value="${count.count}"></c:out></b></td>
												
										<td  style="text-align: center;color: blue; font-weight: bold;">
										
										<button type="button" name="rescom" id="resgetinf${count.count}" class="btn btn-1 btn-link center-block "    style="white-space:normal;color:black;"  onclick="viewdaminformation('${t.resInspectMst1Id}','${t.tankId}','${t.reservoirId}','${t.resName}','resann1report')"  >   <b><c:out
													value="${t.resName}"></c:out></b> </button>
										
										</td>
										
										
										<%-- <a href="javascript:void(null);"
											onclick="getResInfo('${t.resInspectMst1Id}','${t.tankId}','${t.reservoirId}','${t.year}','${t.unitId}');"><c:out
													value="${t.resName}"></c:out></a> --%>
												<td><b><c:out value="${t.unitName}"></c:out></b>
										<br>
										<b style="color:green"><c:out value="${t.circleName}"></c:out></b>
										<br>
										<b style="color:blue"><c:out value="${t.divisionName}"></c:out></b>
										<br>
										<b><c:out value="${t.subdivisionName}"></c:out></b>
										
										</td>
										<c:choose>
										<c:when test="${t.projectName!='0'}">
										<td><b><c:out value="${t.projectName}"></c:out></b></td>
										</c:when> 
										<c:otherwise><td><b>NA</b></td></c:otherwise>
										</c:choose>
										
									   
										<c:choose>
										
										<c:when test="${catinfo==4}">
										<td style="color: red"> To download reports please complete categorization i.e Health status of the Dam.  </td>
										
										</c:when>
										<c:otherwise>
										<td><table>	
											
										<!-- 	start -->
											 
										<c:if test="${resInspectinf!=null}">
										
									
										
										
										<!-- <tr><td  ><b>General Details</b></td><td><b>Inspection Info</b></td><td><b>Annexure1</b></td><td><b>Part 2a (Inspection checklist)</b></td><td><b>Evaluation reports</b></td></tr> -->
										<c:forEach items="${resInspectinf}" var="d"   varStatus="newcount">
										
								
									
										<c:if test="${(d.reservoirId==t.reservoirId && d.resInspectMst1Id==t.resInspectMst1Id) || (d.tankId==t.tankId && d.resInspectMst1Id==t.resInspectMst1Id)}">
									
									
									
									
									<tr>	
										<td><table class=" display table-bordered " style="width:100%">
										
										<tr style="font-size: 11px"><td><b>Salient Features</b></td>
										 <td>
														
										
										<b><button type="button" name="rescom" id="resann1${count.count}" class="btn btn-1 btn-link btn-sm center-block "    style="white-space:normal;color:blue"  onclick="getResSalientinfo('${t.resInspectMst1Id}','${t.tankId}','${t.reservoirId}',${d.resinspectInfoId},'resann1report')"  >   <b> &emsp; &emsp; Salient Features</b> </button></b>
									
										
														</td>
										
										</tr>
										
										
										
										<tr><td><b>Annexure - I</b></td>
										  <td>
														
										
										<b><button type="button" name="rescom" id="resann1${count.count}" class="btn btn-1 btn-link btn-sm center-block "    style="white-space:normal;color:blue"  onclick="getResAnnexureinfo(${t.resInspectMst1Id},${ t.reservoirId}, ${ t.tankId},0,1, 'resann1report')"  >   <b> &emsp; &emsp; Annexure1</b> </button></b>
									
										
														</td>
										
										</tr>
										
										
										<tr><td><b>General Details</b></td>
										<td>
													
														<b><button type="button" name="rescom" id="resgen${count.count}" class="btn btn-1 btn-link btn-sm center-block "    style="white-space:normal;color:blue"  onclick="getGenResinfo('${t.resInspectMst1Id}','${t.tankId}','${t.reservoirId}',${d.resinspectInfoId},'resann1report')"  >   <b>General Information(Part 1a & Part 1b) &emsp; &emsp; </b> </button></b>
														</td>
										
										
										</tr>
									
										<tr><td  ><b>Inspection Info</b></td>			
										<td>
										
										<b><button type="button" name="resinspect" id="resinspect${newcount.count}" class="btn btn-1 btn-link btn-sm center-block "    style="white-space:normal;color:blue"  onclick="getinspectdetails('${t.resInspectMst1Id}','${t.tankId}','${t.reservoirId}',${d.resinspectInfoId},'resann1report')"  >   <b>Inspection by ${d.inspectOfficeName} &emsp;&emsp; on (${d.inspectDate})</b> </button></b>
										
										</td></tr>
										
										
										<tr><td  ><b>Part 2a (Inspection checklist)</b></td><td>
										<b><button type="button" name="rescom" id="resann2${count.count}" class="btn btn-1 btn-link  btn-sm center-block "    style="white-space:normal;color:blue"  onclick="getResAnnexureinfo(${t.resInspectMst1Id},'${t.reservoirId}','${t.tankId}',${d.resinspectInfoId},2,'resann1report')" >   <b> Part 2a (Inspection Checklist) by ${d.inspectOfficeName}</b> </button></b>
										<br></td></tr>
										<tr><td  ><b>Evaluation reports</b></td>
										<td><b><button type="button" name="rescom" id="reser${count.count}" class="btn btn-1 btn-link  btn-sm  center-block "    style="white-space:normal;color:blue"  onclick="getEvalResAnnexureinfo(${t.resInspectMst1Id},'${t.reservoirId}','${t.tankId}',${d.resinspectInfoId},2,'resann1report')"  >   <b>Evaluation Report by ${d.inspectOfficeName}</b> </button></b><br><br>	</td>
										
										
										</tr>
										
										<tr><td  ><b>Inspection photographs/ Documents</b></td>
										<td>
										<b><button type="button" name="rescom" id="reser${count.count}" class="btn btn-1 btn-link btn-sm center-block "    style="white-space:normal;color:blue"  onclick="viewdamphtfnserver('${t.resInspectMst1Id}','${t.tankId}','${t.reservoirId}','${t.resName}','resann1report')"  >   <b>Inspection photographs / Documents</b> </button></b>
										
										</td>
										
										
										</tr>
										
										<tr><td  ><b>Health Status</b></td>
										<td>
										<b><button type="button" name="rescom" id="reser${count.count}" class="btn btn-1 btn-link btn-sm center-block "    style="white-space:normal;color:blue"  onclick="getResHealthStatusinfo('${t.resInspectMst1Id}','${t.tankId}','${t.reservoirId}','resann1report')"  >   <b>Health Status</b> </button></b>
										
										</td>
										
										
										</tr>
										
										<tr><td  ><b>Remarks Info</b></td>
										
										<td>
										<b><button type="button" name="rescom" id="remarks${count.count}" class="btn btn-1 btn-link btn-sm center-block "    style="white-space:normal;color:blue"  onclick="getResRemarksStatusinfo('${t.resInspectMst1Id}','${t.tankId}','${t.reservoirId}','resann1report')"  >   <b>Remarks info</b> </button></b>
										
										</td>
										
										
										</tr>
										
										</table>
										</td>
										</tr>
										
										</c:if>
										</c:forEach>
										</c:if>
										
											
											
											
										<!-- 	end -->
											
											
											</table></td>	
											
											</c:otherwise>	
										</c:choose>
									
									
												
												</tr>

									
                                 
							

									

									
								
										
							
										
													
													
										
									


										
								

							<!-- 	</tr> -->

								</c:forEach>

							</tbody>


							</table>
							
							
						
							
							
							
							
							
							</div>
</div>
								
							
	</form:form>

						</div>
					<%-- 	</c:if> --%>
					

					</div>



				</div>
				
				
			
		</div>
		
	



	


		



	





<script src="../js/Html5DataTable/jquery.dataTables.min.js" type="text/javascript"></script>	
	<script src=" ../js/Html5DataTable/dataTables.buttons.min.js" type="text/javascript"></script>	
	<script src=" ../js/Html5DataTable/jszip.min.js" type="text/javascript"></script>	
	<script src="../js/Html5DataTable/pdfmake.min.js" type="text/javascript"></script>	
	<script src=" ../js/Html5DataTable/vfs_fonts.js" type="text/javascript"></script>	
	<script src="../js/Html5DataTable/buttons.html5.min.js" type="text/javascript"></script>
	<script src="../js/Html5DataTable/buttons.print.min.js" type="text/javascript"></script>
	<script src="../js/Html5DataTable/dataTables.select.min.js" type="text/javascript"></script>
	<script src="../js/Html5DataTable/buttons.colVis.min.js" type="text/javascript"></script>
	
	<script type="text/javascript">			
							
    $('#table1').DataTable( {
        dom: 'Bfrtip',
        responsive: true,
        "paging": false,
        "autoWidth": true,
        "lengthChange": false,
        "pageLength": 20,
        buttons: [
           
            
            
            {
                extend:  'copyHtml5',
               
               
               
                className: 'btn btn-1 btn-primary ',
              
                
                
            },
            {
                extend: 'excelHtml5',
                autoFilter: true,
                sheetName: 'Exported  data',
                text:  'Save To Excel',
                className: 'btn btn-1 btn-primary ',
                messageTop: 'Abstract Details'
                
                
            },
            
             {
                extend: 'pdfHtml5',
                className: 'btn btn-1 btn-primary ',
                text:  'PDF View / Download',
                orientation: 'landscape',
                pageSize: 'A4',
                download: 'open',
            
               
                filename: 'Abstract_Detail',
                exportOptions: {
					columns: ':visible',
					search: 'applied',
					order: 'applied'
				},
				
               
                title: 'Reservoir Abstract Detail',
                customize: function (doc) {        
                	doc.defaultStyle.fontSize = 11;
                	doc.defaultStyle.alignment = 'center';
                	doc.styles.tableHeader.fontSize = 14;
                	doc.pageMargins = [90, 80,80,90];
                	
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
                className: 'btn btn-1 btn-primary ',
                exportOptions: {
                    modifier: {
                        selected: null
                    }
                }
               
                
                
            },
            ,{
                extend: 'print',
                text: 'Print Selected',
                className: 'btn btn-1 btn-primary '
                
                
                
            }
        ],
        select: true
       
    } );
    
    </script>
    <script type="text/javascript" src="../js/parsley.js"></script>
