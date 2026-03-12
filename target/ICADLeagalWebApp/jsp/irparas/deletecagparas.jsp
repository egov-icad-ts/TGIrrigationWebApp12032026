	<!--main code block-->
	<!-- sec-section -->
	
	<!-- create component start here -->
<%@include file="/jsp/header/taglib_includes.jsp"%> 

<!-- <link rel="stylesheet" type="text/css" href="../css/print.css" /> -->

<link rel="stylesheet" href="../css/bootstrap-multiselect.css"
	type="text/css">
<script type="text/javascript" src="../js/bootstrap-multiselect.js"></script>
<script type="text/javascript" src="../js/jquery-ui.js"></script>
<link rel="stylesheet" media="screen" href="../css/jquery-ui.css">
 
 
 <link rel="stylesheet" href="../css/treeview/jquery.treeview.css" />
<!-- <link rel="stylesheet" href="../red-treeview.css" /> -->

<!-- <script src="../js/treeview/lib/jquery.js" type="text/javascript"></script> -->
<script src="../js/treeview/lib/jquery.cookie.js" type="text/javascript"></script>
<script src="../js/treeview/jquery.treeview.js" type="text/javascript"></script>
<script type="text/javascript" src="../js/ckeditor/ckeditor.js"></script>
 <script type="text/javascript" src="../js/ckeditor/adapters/jquery.js"></script>
 

 
<script type="text/javascript">
		$(function() {
			$("#tree").treeview({
				collapsed: true,
				animated: "medium",
				control:"#sidetreecontrol",
				persist: "location"
			});
			
			
			$(".datepick").datepicker({
				changeYear : true,
				changeMonth : true,
				dateFormat : "dd/mm/yy",
			/*  onSelect: function(selected) {
			   $("#month").datepicker("option","minDate", selected)
			 } */
			});
		
		//	var pos = { my: "center center", at: "center top+150", of: window };
			
			
			 $('.edit_dialog').dialog({
				  autoOpen:false,
				  width:1200
				  
				 });
			 
			 $('#reply_dialog').dialog({
				  autoOpen:false,
				  width:800
				 });
			 
			 $('#action_paraalert').dialog({
				  autoOpen:false
				 });
			 
			 $('#action_replyalert').dialog({
				  autoOpen:false
				 });
			 
			 $('#action_docsalert').dialog({
				  autoOpen:false
				 });
			 

			 $('#editunitId').multiselect({
			 		 
			 		 enableCaseInsensitiveFiltering: true
			 		 
			 	});

			 	$('#editcircleId').multiselect({
			 		 
			 		 enableCaseInsensitiveFiltering: true
			 		 
			 	});

			 	$('#editdivisionId').multiselect({
			 		 
			 		 enableCaseInsensitiveFiltering: true
			 		 
			 	});
			 	
			 	$('#editsubdivisionId').multiselect({
			 		 
			 		 enableCaseInsensitiveFiltering: true
			 		 
			 	});
			 	
			 	$('#financialYear').multiselect({
			 		 
			 		 enableCaseInsensitiveFiltering: true
			 		 
			 	});
			 
			 	$('#paraNumber').multiselect({
					 
					 enableCaseInsensitiveFiltering: true
					 
				});
				
				$('#paraStatusId').multiselect({
					 
					 enableCaseInsensitiveFiltering: true
					 
				});
				
				
				
				
				$('#tunitId').multiselect({
					 
					 enableCaseInsensitiveFiltering: true
					 
				});
				$('#tcircleId').multiselect({
					 
					 enableCaseInsensitiveFiltering: true
					 
				});
				$('#tdivisionId').multiselect({
					 
					 enableCaseInsensitiveFiltering: true
					 
				});
				
				$('#tsubdivisionId').multiselect({
					 
					 enableCaseInsensitiveFiltering: true
					 
				});
				
				  $("#toffice").hide();
				  var d = new Date();
				  var e=new Date();
				 e= e.getFullYear() - 39;
				  var j=00;
				  
				  var selectedFinancialYear=$('#hiddenFinancialYear').val();  
					
					   
			      for (var i = 40; i >= 0; i--) {
			    	 // alert(i); 
			    	 var ye=parseInt(d.getFullYear() - i) +"-"+e ;
			    	 
			    	
			    	 
			    	 if(selectedFinancialYear==ye){
			          var option = "<option value=" + parseInt(d.getFullYear() - i) +"-"+e+ "    selected >" + parseInt(d.getFullYear() - i) +"-"+e+ "</option>"
			         // alert(option);
			    	 }
			    	 if(selectedFinancialYear!=ye){
			    		 var option = "<option value=" + parseInt(d.getFullYear() - i) +"-"+e+ "     >" + parseInt(d.getFullYear() - i) +"-"+e+ "</option>" 
			    		 
			    	 }
			          $('[id*=financialYear]').append(option);
			          e++;
			         // j++;
			      }
				
			 
			 
			
			 
			 var m = $(this).find('.ckedit')
				m.ckeditor();

				//alert("coming here")
				$('.ckedit').ckeditor();
				clicked();
				
				
				 var cm =$('input:radio[name=transferFlag]:checked').val();
					// alert("cm"+cm);
					 
				            if (cm == 'true') {
				            	 $("#toffice").show();
				            }
				            if (cm == 'false') {
				            	$("#toffice").hide();
				            }
				       
					
					
					var myunit= parseInt($("#unitId").val()); 
					if(myunit!=null && myunit>0){
						//alert(myunit+"myunit");
						getCircles();	
						
						
						var mycir= parseInt($("#hiddenCircleId").val()); 
						//alert("m"+myproj);
						var m=mycir;
						if(m!=null && m>0){
							//alert(myproj+"myproj");
							getDivisions(m);
							
							var mydiv= parseInt($("#hiddenDivisionId").val()); 	
							var n=mydiv;
							if(n!=null && n>0){
								
								getSubDivisions(n);
								
								
							}
							
							
							
						}
						
						
							
							
						
					}
					
					var trunit= parseInt($("#tunitId").val()); 
					if(trunit!=null && trunit>0){
						//alert(myunit+"myunit");
						gettCircles();	
						
						
						var trcir= parseInt($("#hiddenTrCircleId").val()); 
						//alert("m"+myproj);
						var ab=trcir;
						if(ab!=null && ab>0){
							//alert(myproj+"myproj");
							gettDivisions(m);
							
							var trdiv= parseInt($("#hiddenTrDivisionId").val()); 	
							var mn=trdiv;
							if(mn!=null && mn>0){
								
								gettSubDivisions(mn);
								
								
							}
							
							
							
						}
						
						
							
							
						
					}
					
		})
		
	</script>
	
	<script type="text/javascript">

function clicked(){
	for ( instance in CKEDITOR.instances ){
		
		CKEDITOR.instances[instance].getData();
	//alert("ckeditor values : " + CKEDITOR.instances[instance].getData());
	}
	}
	
	</script>
	
	
	 <script type="text/javascript">

function getCircles(){
	//alert("kal");
	//var districtId=document.getElementById("districtId").value;
	
	$('#editcircleId').multiselect('rebuild');
	var unitId=document.getElementById("editunitId").value;
	//alert(unitId);

	  $.ajax({	          
      url: "../task/getCircles?unitId="+unitId,
      type: "GET",
      success: function (response) {
    //	alert(response);
    
    	  var $select = $('#editcircleId');
    	 
		  $select.find('option').remove();
		 // alert("kal1");
		  
		  var obj = JSON.parse(response);
		 // alert("kal2");
		 
		
		  $('#editcircleId').append( '<option value="0"> --select--</option>' );
				
				 
				  
				$.each(obj, function(key, value) {
					
						$('#editcircleId').append( '<option value="'+value.circleId+'" > '+value.circleName+'</option>' );
				
						$('#editcircleId').multiselect('rebuild');
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
	var circleId=document.getElementById("editcircleId").value;
	//alert(mandalId);

	  $.ajax({	          
      url: "../web/getDivisions?circleId="+circleId,
      type: "GET",
      success: function (response) {
    	
    	
    	
    	  var $select = $('#editdivisionId');
    	 
		  $select.find('option').remove();
		  
		  var obj = JSON.parse(response);
		
		 
				
				  $('#editdivisionId').append( '<option value="0"> --select--</option>' );
				  
				$.each(obj, function(key, value) {
					
						$('#editdivisionId').append( '<option value="'+value.divisionId+'" > '+value.divisionName+'</option>' );
				
  	  				$('#editdivisionId').multiselect('rebuild');
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
	var divisionId=document.getElementById("editdivisionId").value;
	//alert(mandalId);

	  $.ajax({	          
      url: "../web/getSubDivisions?divisionId="+divisionId,
      type: "GET",
      success: function (response) {
    	
    	
    	
    	  var $select = $('#editsubdivisionId');
    	 
		  $select.find('option').remove();
		  
		 
		
		 
				var obj = JSON.parse(response);
				  $('#editsubdivisionId').append( '<option value="0"> --select--</option>' );
				  
				$.each(obj, function(key, value) {
					
						$('#editsubdivisionId').append( '<option value="'+value.subdivisionId+'" > '+value.subdivisionName+'</option>' );
				
  	  				$('#editsubdivisionId').multiselect('rebuild');
				});
    	 

      },
      error : function(){
    	  alert(error);
      }
  }); 	
}






function gettCircles(){
	//alert("kal");
	//var districtId=document.getElementById("districtId").value;
	
	$('#tcircleId').multiselect('rebuild');
	var unitId=document.getElementById("tunitId").value;
	//alert(mandalId);

	  $.ajax({	          
      url: "../task/getCircles?unitId="+unitId,
      type: "GET",
      success: function (response) {
    //	alert(response);
    
    	  var $select = $('#tcircleId');
    	 
		  $select.find('option').remove();
		 // alert("kal1");
		  
		  var obj = JSON.parse(response);
		 // alert("kal2");
		 
		
		  $('#tcircleId').append( '<option value="0"> --select--</option>' );
				
				 
				  
				$.each(obj, function(key, value) {
					
						$('#tcircleId').append( '<option value="'+value.circleId+'" > '+value.circleName+'</option>' );
				
						$('#tcircleId').multiselect('rebuild');
				});
    	 

      },
      error : function(){
    	  alert(error);
      }
  }); 	
}


function gettDivisions(){
	//alert("kal");
	//var districtId=document.getElementById("districtId").value;
	var circleId=document.getElementById("tcircleId").value;
	//alert(mandalId);

	  $.ajax({	          
      url: "../web/getDivisions?circleId="+circleId,
      type: "GET",
      success: function (response) {
    	
    	
    	
    	  var $select = $('#tdivisionId');
    	 
		  $select.find('option').remove();
		  
		  var obj = JSON.parse(response);
		
		 
				
				  $('#tdivisionId').append( '<option value="0"> --select--</option>' );
				  
				$.each(obj, function(key, value) {
					
						$('#tdivisionId').append( '<option value="'+value.divisionId+'" > '+value.divisionName+'</option>' );
				
  	  				$('#tdivisionId').multiselect('rebuild');
				});
    	 

      },
      error : function(){
    	  alert(error);
      }
  }); 	
}


function gettSubDivisions(){
	//alert("kal");
	//var districtId=document.getElementById("districtId").value;
	var divisionId=document.getElementById("tdivisionId").value;
	//alert(mandalId);

	  $.ajax({	          
      url: "../web/getSubDivisions?divisionId="+divisionId,
      type: "GET",
      success: function (response) {
    	
    	
    	
    	  var $select = $('#tsubdivisionId');
    	 
		  $select.find('option').remove();
		  
		 
		
		 
				var obj = JSON.parse(response);
				  $('#tsubdivisionId').append( '<option value="0"> --select--</option>' );
				  
				$.each(obj, function(key, value) {
					
						$('#tsubdivisionId').append( '<option value="'+value.subdivisionId+'" > '+value.subdivisionName+'</option>' );
				
  	  				$('#tsubdivisionId').multiselect('rebuild');
				});
    	 

      },
      error : function(){
    	  alert(error);
      }
  }); 	
}



	
</script>

    

<script>



$(document).ready(function(){

	 for(var f=1 ; f< 20 ;f++) {
   	  
   	  var option = "<option value=" + parseInt(f) + " > "+ parseInt(f) + "</option>"
         // alert(option);
          
          $('.paraSequence').append(option);
           
   	  
   	  
     }
	

	 
	  
			
});







/* function printDiv(divName) {
    var printContents = document.getElementById(divName).innerHTML;
    //var originalContents = document.body.innerHTML;

   // document.body.innerHTML = printContents;
    document.body.innerHTML = '<link href="./I and CAD  Court Cases Monitoring System_files/bootstrap.min.css" rel="stylesheet" type="text/css"  media="print"><link rel="stylesheet" href="./I and CAD Court Cases Monitoring System_files/custom.css" type="text/css"  media="print"><body>';
    document.body.innerHTML += printContents+'</body>';
  //  alert(document.body.innerHTML);
    //alert(printContents);
    window.print();
    window.close();
    

   // document.body.innerHTML = originalContents;
} */

function printDiv(divName) {
    var toPrint = document.getElementById(divName);
    var popupWin = window.open('', '_blank', 'width=350,height=150,location=no,left=200px');
    popupWin.document.open();
    popupWin.document.write('<html><title>::Preview::</title><link rel="stylesheet" type="text/css" href="print.css" /></head><body onload="window.print()">')
    popupWin.document.write(toPrint.innerHTML);
    popupWin.document.write('</html>');
    popupWin.document.close();
}
/*--This JavaScript method for Print Preview command--*/
function PrintPreview(divName) {
    var toPrint = document.getElementById(divName);
    var popupWin = window.open('', '_blank', 'width=350,height=150,location=no,left=200px');
    popupWin.document.open();
    popupWin.document.write('<html><title>::Print Preview::</title><link rel="stylesheet" type="text/css" href="Print.css" media="screen"/></head><body">')
    popupWin.document.write(toPrint.innerHTML);
    popupWin.document.write('</html>');
    popupWin.document.close();
}


</script>


<script type="text/javascript">
function viewreplys(cagGistId,cagParaId){
	
	
	$("#view-reply").dialog({
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
	    }
	});

	
	
$.ajax({
    type: "GET", //rest Type
    dataType: 'json', //mispelled
    url: "../parastsimis/getcagReplys?cagParaId="+cagParaId,
  
    contentType: "application/json; charset=utf-8",
    success: function (msg2) {
    	//alert("msg2"+msg2.length);
    
    	
  if(msg2.length>0){
	 // alert("cmoing here");
  
       // console.log(msg); 
        $('#view-reply').empty();   
      
     
        		 
        /*  $('#view-reply').append('<div id="main3" class="col-md-6 "> '+ */
        		/*  '<div  class="col-md-12 " style="background-color:grey; color:white; font-weight:bold; float:left;"> '+
                   
                    '<div  style="text-align:left;">Reply</div>'+
                   
                '</div>');    */
        
       
         for(i in  msg2 ){
        	 var j=parseInt(i)+1;
     /*   $("#view-reply").append(' <div  class="col-md-12 " style="font-weight:bold;" >  Reply S.No  '+ j  +' </div>'); */ 
       
        var userN=msg2[i].userName;
      // alert("userN"+userN); 
     
    // alert( msg2[i].replyAction);
        
       
      /*  $("#view-docs").append(' <div  class="col-md-12 " style="font-weight:bold;" >  Reply Updated by  '+  msg2[i].userName  +' </div>');  */
         $("#view-reply").append('<div  class="col-md-12 " style="background-color:grey; color:white; font-weight:bold; float:left;"> <div class="col-md-4" style="text-align:left;">Reply No '+ j  +'  </div> <div class="col-md-4" style="text-align:left;">Reply Date: '+ msg2[i].replyDate  +'  </div> <div  class="col-md-4 " > <button type="button" class="btn btn-danger " onclick="deleteReply('+msg2[i].paraReplyId+')"  >Delete Reply</button> </div></div>'); 
        $("#view-reply").append(' <div  class="col-md-12 " > '+  msg2[i].replyAction +' </div>'); 
        $("#view-reply").append('<div  class="col-md-12 " style="background-color:#f0f0f5; color:black; font-weight:bold; float:left;"> <div  style="text-align:left;">Remarks</div> </div>'); 
        $("#view-reply").append(' <div  class="col-md-12 " > '+  msg2[i].replyRemarks +' </div>'); 
      /*   $("#view-reply").append(' <div  class="col-md-4 " ></div><div  class="col-md-4 " > <button type="button" class="btn btn-danger " onclick="deleteReply('+msg2[i].paraReplyId+')"  >Delete</button> </div><div  class="col-md-4 " ></div>'); */
                   
         }         
         $("#main3").append(	'</div>' );
       /*   $("#main1").append(	'</div>' ); */
  }
  if(msg2.length==0){
	  
	  
	 // alert("not cmoing here");
	  
	  $("#view-reply").dialog('close');
	  $('#action_paraalert').html('<p>No Replys</p>');
	    $('#action_paraalert').dialog('open'); 
  
  }
             
    }
});




}
function viewdocs(cagGistId,cagParaId){
	
	
	$("#view-docs").dialog({
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
	    }
	});


$.ajax({
    type: "GET", //rest Type
    dataType: 'json', //mispelled
    url: "../parastsimis/getcagDocs?cagParaId="+cagParaId,
    async: false,
    contentType: "application/json; charset=utf-8",
    success: function (msg3) {
       console.log(msg3); 
     //  alert(msg3);
     
     if(msg3.length>0){
       $('#view-docs').empty();   
        
        
       
         for(k in  msg3 ){
        	 var m=parseInt(k)+1;
      /*  $("#view-docs").append(' <div  class="col-md-12 " style="font-weight:bold;" >  Reply S.No  '+ m +' </div>'); */ 
       
        var userN=msg3[k].userName;
      // alert("userN"+userN); 
     
    // alert( msg2[i].replyAction);
        
       
      /*  $("#view-docs").append(' <div  class="col-md-12 " style="font-weight:bold;" >  Reply Updated by  '+  msg2[i].userName  +' </div>');  */
         $("#view-docs").append('<div  class="col-md-12 " style="background-color:grey; color:white; font-weight:bold; float:left;"> <div   class="col-md-6 " style="text-align:left;">Document No '+ m  +' </div> <div  class="col-md-6 " > <button type="button" class="btn btn-danger " onclick="deleteDocs('+msg3[k].docId+')"  >Delete Document</button> </div> </div>');
      /*   $("#view-docs").append(' <div  class="col-md-12 " > '+  msg3[k].paraDocName +' </div>'); */ 
        $("#view-docs").append(' <div  class="col-md-12 " > <a href="../uploadedFiles/IRParas/'+  msg3[k].paraDocName +'" target="_blank" > '+  msg3[k].paraDocOriginalName +'</a> </div>');  
       /*  $("#view-docs").append('<div  class="col-md-4 " ></div> <div  class="col-md-4 " > <button type="button" class="btn btn-danger " onclick="deleteDocs('+msg3[k].docId+')"  >Delete Document</button> </div><div  class="col-md-4 " ></div>'); */          
         }         
         $("#main3").append(	'</div>' );
       /*   $("#main1").append(	'</div>' ); */
     }
     
     if(msg3.length==0){
    	 
    	 $("#view-docs").dialog('close');
   	  $('#action_paraalert').html('<p>No Documents</p>');
   	    $('#action_paraalert').dialog('open'); 
     
     
     }
         
    }
});
	
	



}







       
    </script>


<script >

	
	


function getData(unitId){
	
	
	 $("#deleteFlag").val(false);
	  $("#unitId").val(unitId);
	 
	 document.forms[0].urlvalue.value="../parastsimis/deletecagparas";
		
	
	 
	
		 document.forms[0].submit(); 
	
	
}

function getCircleData(unitId,circleId){
	
	////alert("kal")
	//alert(unitId);
	//alert(circleId);
	 $("#deleteFlag").val(false);
	  $("#unitId").val(unitId);
	  $("#circleId").val(circleId);
	 
	 document.forms[0].urlvalue.value="../parastsimis/deletecagparas";
		
	
	 
	
		 document.forms[0].submit(); 
	
	
}

function getDivisionData(unitId,circleId,divisionId){
	
	//alert("kal2")
	 $("#deleteFlag").val(false);
	  $("#unitId").val(unitId);
	  $("#circleId").val(circleId);
	  $("#divisionId").val(divisionId);
	 
	 document.forms[0].urlvalue.value="../parastsimis/deletecagparas";
		
	
	 
	
		 document.forms[0].submit(); 
	
	
}
	

	

	
	function editGistPara(gistId,unitId,circleId,divisionId){
		
		
		 

		
	//	alert(gistId+"kal");
		
		
		  
		  
		  geteditData(gistId);
		  
		  
	
		
		  
		  
		/* 	 $('#savepara').click(function(){
				 
			 	 alert("coming here")
				  var error_paraSequence = ''; 
				  var error_parasAction = '';
				  var error_paraTitle = '';
				 
				 
				  
				   var paraSequence = ' '; 
				  var parasAction = '';
				  var paraTitle = '';
				  
				 
				 
				   if($('#paraSequence').val() == ' ')
				  {
					  error_paraSequence = 'para sequence is required';
				   $('#error_paraSequence').text(error_paraSequence);
				   $('#paraSequence').css('border-color', '#cc0000');
				   paraSequence = ' ';
				  // alert("kal"+replylatest);
				  }
				  else
				  {
					  
					  var latestparaSequence=$('#paraSequence').val();
					 // alert("rlatest"+rlatest);
					  error_paraSequence = '';
				   $('#error_paraSequence').text(error_paraSequence);
				   $('#c').css('border-color', '');
				   paraSequence = latestparaSequence;
				  }  
				  if($('#parasAction').val() == '')
				  {
					  error_parasAction = 'parasAction is required';
				   $('#error_parasAction').text(error_parasAction);
				   $('#parasAction').css('border-color', '#cc0000');
				   parasAction = '';
				  }
				  else
				  {
					  error_parasAction = '';
				   $('#error_parasAction').text(error_parasAction);
				   $('#parasAction').css('border-color', '');
				   parasAction = $('#parasAction').val();
				  }
				  
				  if($('#paraTitle').val() == '')
				  {
					  error_paraTitle = 'paraTitle is required';
				   $('#error_paraTitle').text(error_paraTitle);
				   $('#paraTitle').css('border-color', '#cc0000');
				   paraTitle = '';
				  }
				  else
				  {
					  error_paraTitle = '';
				   $('#error_paraTitle').text(error_parasAction);
				   $('#paraTitle').css('border-color', '');
				   paraTitle = $('#paraTitle').val();
				  }
				  
				// alert("paraTitle"+paraTitle+"seq"+paraSequence);
				  if(error_parasAction.length>0& error_paraSequence.length>0 )
				  {
					  
					// alert("here1");
				   return false;
				  }
				   
				  alert(error_parasAction.length +"------"+error_paraSequence.length);
				  if(error_parasAction.length=="0" && error_paraSequence.length=="0")
				  {
					  
					 alert("else");
					  var paraseq=$('#paraSequence').val();
					  var paraTit=$('#paraTitle').val();
					  var paraact=$('#parasAction').val();
					  
					  
					  var data = 'cagGistId='+ gistId+ ' &paraSequence='+ paraseq+ '&parasAction='+ paraact + '&paraTitle='+ paraTit;
					
					  alert("kal3");
					  $.ajax({	          
					      url: "../parastsimis/addnewpara?cagGistId="+ gistId+" &paraSequence="+ paraseq+" &parasAction= "+ paraact+" &paraTitle="+ paraTit,
					      method:"POST",
						 
					      success: function (response) {
					   
					    	//  alert("kal"+response);
					    	  $('.para_dialog').dialog('close'); 
					    	  $('#action_paraalert').html('<p>Data Inserted Successfully</p>');
							    $('#action_paraalert').dialog('open'); 
							    getunitData(unitId,circleId,divisionId) ;
							  

					      },
					      error : function(){
					    	 alert(error);
					      $('#action_paraalert').dialog('open');
					      }
					  }); 	
						   
						
						 
						 
					  
					
					
				   }
				   

				  
				
				   
				  
				 
				 }); */
		
		
	}
	function addcagparareply(gistId, paraId,unitId,circleId,divisionId){
		
		

			
			  $('#reply_dialog').dialog('option', 'title', 'Add Reply Data');
			  
			
			  $('#replyDate').val('0'); 
			  $('#replyAction').val('');
			  $('#replyRemarks').val('');
			 
			 
			   $('#error_replyDate').text(''); 
			  $('#error_replyAction').text('');
			  $('#error_replyremarks').text('');
			 
			
			  
			   $('#replyDate').css('border-color', ''); 
			  $('#replyAction').css('border-color', '');
			  $('#replyRemarks').css('border-color', '');
			  
			
			  $('#savereply').text('Submit');
			  $('#reply_dialog').dialog('open');
			

			 $('#savereply').click(function(){
			  var error_replylatest = ''; 
			  var error_replyAction = '';
			  var error_replyRemarks= '';
			 
			  
			   var replyDate = '0'; 
			  var replyAction = '';
			  var replyRemarks = '';
			 
			 
			   if($('#replyDate').val() == '0')
			  {
				  error_replyDate = 'reply Date is required';
			   $('#error_replyDate').text(error_replyDate);
			   $('#replyDate').css('border-color', '#cc0000');
			   replyDate = '0';
			  // alert("kal"+replylatest);
			  }
			  else
			  {
				  
				  var rlatest=$('#replyDate').val();
				 // alert("rlatest"+rlatest);
				  error_replyDate = '';
			   $('#error_replyDate').text(error_replyDate);
			   $('#replyDate').css('border-color', '');
			   replyDate = rlatest;
			  }  
			  if($('#replyAction').val() == '')
			  {
				  error_replyAction = 'replyAction is required';
			   $('#error_replyAction').text(error_replyAction);
			   $('#replyAction').css('border-color', '#cc0000');
			   replyAction = '';
			  }
			  else
			  {
				  error_replyAction = '';
			   $('#error_replyAction').text(error_replyAction);
			   $('#replyAction').css('border-color', '');
			   replyAction = $('#replyAction').val();
			  }
			   if($('#replyRemarks').val() == ' ')
			  {
				  error_replyRemarks = 'Remarks is required';
			   $('#error_replyRemarks').text(error_replyRemarks);
			   $('#replyRemarks').css('border-color', '#cc0000');
			   replyRemarks = '';
			  }
			  else
			  {
				  error_replyRemarks = ' ';
			   $('#error_replyRemarks').text(error_replyRemarks);
			   $('#replyRemarks').css('border-color', '');
			   replyRemarks = $('#replyRemarks').val();
			  } 
			 
			   
			 //  alert("lenaction"+gistId);
			 //  alert("datae"+paraId);
			  // alert("reply"+replyAction);
			   
			  if(gistId ==null && paraId==null )
			  {
			   return false;
			  }
 			  if(gistId  > "0" && paraId  > "0"  && replyAction!=null)
			  {
				  
 				  //alert("kal1");
				  
				  var cagGistId=parseInt(gistId);
					  
					  var cagParaId=parseInt(paraId);
				  
				  
					 // addreplyajax(cagGistId,cagParaId,replyAction,replyRemarks,replyDate);
					 
					 
					 
					 
		  $.ajax({	          
		      url: "../parastsimis/addcagreply?cagGistId="+cagGistId+" &cagParaId="+cagParaId+" &replyAction= "+replyAction+" &replyRemarks="+replyRemarks+"&replyDate="+replyDate,
		      method:"POST",
			 
		      success: function (response) {
		   
		    	 // alert("kalreply"+response);
		    	   $('#reply_dialog').dialog('close');
		    	  $('#action_replyalert').html('<p>Data Inserted Successfully</p>');
				    $('#action_replyalert').dialog('open'); 
				    
				    getunitData(unitId,circleId,divisionId) ;

		      },
		      error : function(){
		    	 alert(error);
		      $('#action_replyalert').dialog('open');
		      }
		  }); 	
			 // alert("kal3");
				
			  
			   }
 
			 
			 
			 });
		
		
		
	}
	
	
	
	
	
	function getunitData(unitId,circleId,divisionId){
		
		 //$('#action_paraalert').dialog('close');
		  // $('#action_replyalert').dialog('close');
	
		if(unitId>0 && (circleId==null || circleId=="0") && (divisionId==null || divisionId=="0")){
		 getData(unitId);
		}
		if(unitId>0 && (circleId>0) && (divisionId==null || divisionId=="0")){
		 getCircleData(unitId,circleId);
		}
		if(unitId>0 && (circleId>0) && (divisionId>0)){ 
		 getDivisionData(unitId,circleId,divisionId);
		}
		
	}
	
	
	
	
	function deleteGist(gistId,unitId,circleId,divisionId){
		
		  $.ajax({	          
		      url: "../parastsimis/deleteCagGist?cagGistId="+ gistId ,
		      method:"POST",
			 
		      success: function (response) {
		   
		    	 // alert("kal"+response);
		    	 
		    	  $('#action_paraalert').html('<p>Data Deleted Successfully</p>');
				    $('#action_paraalert').dialog('open'); 
				    getunitData(unitId,circleId,divisionId) ;
				  

		      },
		      error : function(){
		    	 alert(error);
		      }
		  }); 	
			   
			
	
	
	}
	
	function deletePara(cagParaId,unitId,circleId,divisionId){
		
		  $.ajax({	          
		      url: "../parastsimis/deleteCagPara?cagParaId="+ cagParaId ,
		      method:"POST",
			 
		      success: function (response) {
		   
		    	//  alert("kal"+response);
		    	 
		    	  $('#action_paraalert').html('<p>Data Deleted Successfully</p>');
				    $('#action_paraalert').dialog('open'); 
				    getunitData(unitId,circleId,divisionId) ;
				  

		      },
		      error : function(){
		    	 alert(error);
		      $('#action_paraalert').dialog('open');
		      }
		  }); 	
			   
			
	
	
	}
	
	function deleteReply(replyId){
		
	//,unitId,circleId,divisionId
		
		  $.ajax({	          
		      url: "../parastsimis/deleteCagReply?cagReplyId="+ replyId ,
		      method:"POST",
			 
		      success: function (response) {
		   
		    	//  alert("kal"+response);
		    	 
		    	  $('#action_paraalert').html('<p>Data Deleted Successfully</p>');
				    $('#action_paraalert').dialog('open'); 
				  //  getunitData(unitId,circleId,divisionId) ;
				  

		      },
		      error : function(){
		    	 alert(error);
		      $('#action_paraalert').dialog('open');
		      }
		  }); 	
			   
			
	
	
	}
	
	function deleteDocs(docId){
		
		
		//,unitId,circleId,divisionId
		
		  $.ajax({	          
		      url: "../parastsimis/deleteCagDocs?cagDocId="+ docId ,
		      method:"POST",
			 
		      success: function (response) {
		   
		    	 // alert("kal"+response);
		    	 
		    	  $('#action_paraalert').html('<p>Data Deleted Successfully</p>');
				    $('#action_paraalert').dialog('open'); 
				//    getunitData(unitId,circleId,divisionId) ;
				  

		      },
		      error : function(){
		    	 alert(error);
		      $('#action_paraalert').dialog('open');
		      }
		  }); 	
			   
			
	
	
	}
	
function geteditData(gistId){
		
		
		//,unitId,circleId,divisionId
		
		  $.ajax({	          
		      url: "../parastsimis/editCAGGist?cagGistId="+ gistId ,
		      method:"POST",
			 
		      success: function (response) {
		   
		    	  $('.edit_dialog').dialog('option', 'title', 'Edit CAG Gist');
				  
		    	  $('.edit_dialog').dialog('open'); 
		    	 // alert(response);
		    	 
		    	  
		    	  
		    		var obj = JSON.parse(response);
		    		 console.log(obj);
		    	  
		    	
		    	
		    	
		    	  var dbunitId=obj.unitId ;
		    	//  alert("m"+dbunitId);
		    	//  $("#editunitId option[value= " '+ dbunitId + '"]').attr("selected", true);
		    	  
		    	   $('#editunitId option[value="'+dbunitId+'"]').attr("selected","selected");	
		    	   $('#editunitId ').text(obj.unitName);
		    	
		    	 //$('#editunitId').val(dbunitId); 
		    /* 	if($('#editunitId').val()!=null){
		    		
		    		$('select["#editunitId"] option[value="'+obj.unitId+'"]').attr("selected","selected");	
		    		
		    	} */
		    	
		    	

			
				/* 
				$.each(obj, function(key, value) {
				  
					alert(value.unitId)
				$('select["#editunitId"] option:selected').attr("selected",null); 
			
				
						//$('#editunitId').append( '<option value="'+value.unitId+'" selected="selected" > '+value.unitName+'</option>' );
				
  	  				//$('#editunitId').multiselect('rebuild');
				});
		    	 */
		    	
		    	 
				
				  

		      },
		      error : function(){
		    	 alert(error);
		      $('#action_paraalert').dialog('open');
		      }
		  }); 	
			   
			
	
	
	}
	 
	 
	
</script>



<c:if test="${userObj!=null}">
	<div class="row-fluid  ">

		<div class="span6 pull-right">
			<p class="rowBlue" > <c:out value="${userObj.employeeName}"></c:out></p>
		</div>
	</div>
	</c:if>	<c:if test="${msg!=null || err!=null }">


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




<div class="w3l-main" id="borderStyle">

	
	 
<form:form id="delirparas" method="post"
				modelAttribute="deletecagparas" >
				<input name=urlvalue  id="urlvalue" type=hidden >
				<input name=paravalue id="paravalue" type=hidden >
				
				
		 		<input name=unitId     id="unitId" type=hidden   />
				<input name=circleId     id="circleId" type=hidden   />
				<input name=divisionId     id="divisionId" type=hidden   />
	   
				
				
			
				<input name=deleteFlag  id="deleteFlag" type=hidden value="false" >
				<input name=cagGistId  id="cagGistId" type=hidden >
				
					<input name=userObjUserName  id="userObjUserName" type=hidden value="${userObj.userName}" >
				
				
				
				
	
				
<c:if test="${userObj.unitId!=null}">				
		
	<!-- 	<div class="col-md-3 w3layouts-second"> -->
<div > 	

		<c:forEach items="${unitList}" var="m">					
								
		
	<c:if test="${userObj.unitId==m.unitId  && userObj.divisionId==0 && userObj.circleId==0 }">
	
<div class="row "> 

	<div class="col-md-2  "> 
	<a class="myunit"  href="javascript:void(0)"  style="text-decoration: none; border-bottom: 1px solid black; color: #000000;" onclick="getData(<c:out value="${m.unitId}"></c:out>)"><strong><c:out value="${m.unitName}"></c:out></strong></a>
	</div>
	
	<div class=" col-md-4 alert alert-info">
  <strong>To Edit Click on this link.</strong>
</div>
</div>
		
	</c:if>
	
	</c:forEach>
	
	
	
	<c:forEach items="${circleList}" var="n">
	
	

	
		
		<c:if test="${userObj.circleId==n.circleId  && userObj.divisionId==0 }">	
		<div class="col-md-2 "> 
		<a class="mycircle" href="javascript:void(0)"  style="text-decoration: none; border-bottom: 1px solid black; color: #000000;" onclick="getCircleData(<c:out value="${n.unitId}"></c:out>,<c:out value="${n.circleId}"></c:out>)" ><c:out value="${n.circleName}"></c:out></a>
			</div>
			<div class=" col-md-4 alert alert-info">
  <strong>To Edit Click on this link.</strong>
</div>
			</c:if>
			
			
			</c:forEach>
			
		
			<c:forEach items="${divisionList}" var="p">
		
			
		
			<c:if test="${userObj.divisionId==p.divisionId}">	
			<div class="col-md-2 "> 
			<a class="mydivision" href="javascript:void(0)"  style="text-decoration: none; border-bottom: 1px solid black; color: #000000;" onclick="getDivisionData(<c:out value="${userObj.unitId}"></c:out>,<c:out value="${p.circleId}"></c:out>,<c:out value="${p.divisionId}"></c:out>)" ><c:out value="${p.divisionName}"></c:out></a>
			</div>
			<div class=" col-md-4 alert alert-info">
  <strong>To Edit Click on this link.</strong>
</div>
			</c:if>			
			
			
			
			
			</c:forEach>
		
	</div>	
	
	</c:if>
		
	 
	<div > 
		
	
		
	 <c:if test="${userObj.unitId==null || userObj.unitId==5 }">	

 <div id="sidetree">
<div class="treeheader">&nbsp;</div>
<div id="sidetreecontrol"><a href="?#">Collapse All</a> | <a href="?#">Expand All</a></div>

<ul id="tree">


	
	<c:forEach items="${unitList}" var="u">		
	
	 <li><a class="myunit"  href="javascript:void(0)" onclick="getData(<c:out value="${u.unitId}"></c:out>)" ><strong><c:out value="${u.unitName}"></c:out></strong></a>
	<ul>
	<c:forEach items="${circleList}" var="c">
	<c:if test="${u.unitId==c.unitId}">
	<%-- ../task/taskreport2?unitId=<c:out value="${u.unitId}"></c:out>&circleId=<c:out value="${c.circleId}"></c:out> --%>
		<li><a class="mycircle" href="javascript:void(0) "  onclick="getCircleData(<c:out value="${u.unitId}"></c:out>,<c:out value="${c.circleId}"></c:out>)"><c:out value="${c.circleName}"></c:out></a>
			<ul>
			<c:forEach items="${divisionList}" var="d">
			<c:if test="${c.circleId==d.circleId}">
			<%-- ../task/taskreport2?unitId=<c:out value="${u.unitId}"></c:out>&circleId=<c:out value="${c.circleId}"></c:out>&divisionId=<c:out value="${d.divisionId}"></c:out> --%>
			<li><a class="mydivision" href="javascript:void(0)"  onclick="getDivisionData(<c:out value="${c.unitId}"></c:out>,<c:out value="${d.circleId}"></c:out>,<c:out value="${d.divisionId}"></c:out>)"><c:out value="${d.divisionName}"></c:out></a>
		
			
			
			
			</li>
			</c:if>
			
			</c:forEach>
		</ul>
		
		
		</li>
		</c:if>
		</c:forEach>
		
		


	</ul>
	</li>
	 
	 
	
	
	</c:forEach>  
	
		
		
		
	</ul>
	
</div> 
</c:if>

		<div class="col-md-10">
		</div>
		<div class="col-md-2">
				<a href="../parastsimis/deletecagparas">	<input type="button" class="btn btn-1 btn-primary center-block"
						id="getcomps" value="Back"   >
						</a>
				</div>
			
							
		<c:if test="${parasList!=null}">
		
		
					
	
		
		<div class="col-md-2" style="color:blue; font-weight: bold; font-size: 18px;">Unit:</div>
					<div class="col-md-2" style="color:red ;font-weight: bold;font-size: 14px;">
					
					<c:out value="${parasList[0].unitName}"></c:out>
					</div>
					<div class="col-md-2" style="color:blue; font-weight: bold;font-size: 18px;">Circle:</div>
					<div class="col-md-2" style="color:red;font-weight: bold;font-size: 14px;">
				
				<c:out value="${parasList[0].circleName}"></c:out>
				</div>
				<div class="col-md-2" style="color:blue;font-weight: bold;font-size: 18px;">Division:</div>
				<div class="col-md-2" style="color:red;font-weight: bold;font-size: 14px;">
				<c:out value="${parasList[0].divisionName}"></c:out> 
				</div>
					
			
	
		</c:if>
		


	
	
		
			
				
				
		
	
	
	
	<div class="panel panel-primary  col-md-12">
			<div class="panel-heading">
				<h3 class="panel-title">Delete CAG Para/Reply/Docs</h3>
			</div>


					<c:forEach items="${parasList}" var="t" varStatus="count">			
							
				<div >

					<div
						class="show-grid gridList " >
							
							<div class="table-responsive"  >
	
								<table class=" display table-bordered " style="width:100%" id="table1">	
								
									<thead >
									<tr  >
									<th colspan="2" style="text-align: center; font-weight: bold; color:red ;">Financial Year :</th>
									<th colspan="2" style="text-align: center; font-weight: bold"><c:out value="${t.financialYear}"></c:out></th>
									<th colspan="2" style="text-align: center; font-weight: bold; color:red ;">Para Number :</th>
									<th colspan="2" style="text-align: center; font-weight: bold"><c:out value="${t.paraNumber}"></c:out></th>
									</tr>
									
									<tr  >
									<th colspan="2" style="text-align: center; font-weight: bold; color:red ;">Para Status :</th>
									<th colspan="2" style="text-align: center; font-weight: bold"><c:out value="${t.paraStatus}"></c:out></th>
									<th colspan="2" style="text-align: center; font-weight: bold; color:red ;">Discussed in PAC</th>
									<th  colspan="2" style="text-align: center; font-weight: bold"><c:out value="${t.printCagStatus}"></c:out></th>
									</tr>
									<tr  >
									<th colspan="2" style="text-align: center; font-weight: bold; color:red ;">Gist of Para </th>
									<th colspan="6" style="text-align: center; font-weight: bold"><c:out value="${t.actionTitle}"></c:out></th>
									</tr>
									<tr  >
									<th colspan="2" style="text-align: center; font-weight: bold; color:red ;">	Edit CAG Gist Para  </th>
									<th colspan="2" style="text-align: center; font-weight: bold; "><a target="_blank" href="../parastsimis/editcagparas?cagGistId=${t.cagGistId}&editFlag=false">Edit Gist</a>	 </th>
									<th colspan="2" style="text-align: center; font-weight: bold;color:red ;">	Delete CAG Gist Para  </th>
									<th colspan="2" style="text-align: center; font-weight: bold"><button type="button" id="addPara"  onclick='deleteGist(<c:out value="${t.cagGistId}"></c:out>,<c:out value="${t.unitId}"></c:out>,<c:out value="${t.circleId}"></c:out>,<c:out value="${t.divisionId}"></c:out> )' class="btn btn-danger " >Delete CAG Gist Para</button>	 </th>
									</tr>
									
									
									</thead>
									
									<tbody>
									<c:if test="${parasData!=null}">
									<tr style="color: maroon;" >
									<td colspan="1" style="text-align: center; font-weight: bold">	Para Sequence  </td>
									<td colspan="2" style="text-align: center; font-weight: bold">	Para Title </td>
									<td colspan="4" style="text-align: center; font-weight: bold">	Para  </td>
									<td colspan="2" style="text-align: center; font-weight: bold">	Delete / Edit / View </td>
									</tr>
									<c:forEach items="${parasData}" var="m" varStatus="pcount">
									
								
									<c:if test="${t.cagGistId==m.cagGistId}">
									
									<tr><td colspan="1"><c:out value="${m.paraSequence}"></c:out></td>	
									<td colspan="2"><c:out value="${m.paraTitle}"></c:out></td>	
									<td colspan="4	"><c:out value="${m.parasAction}" escapeXml="false"></c:out></td>
									<td colspan="2">
									<button type="button" class="btn btn-danger " onclick='deletePara(<c:out value="${m.cagParaId}"></c:out>,<c:out value="${t.unitId}"></c:out>,<c:out value="${t.circleId}"></c:out>,<c:out value="${t.divisionId}"></c:out>)'  >Delete Para/Replys</button>
									<a target="_blank" href="../parastsimis/editcagparareply?cagParaId=${m.cagParaId}&editFlag=false"><button type="button" class="btn btn-primary "   >Edit Para/Replys</button> </a>
									<button type="button" class="btn btn-info " onclick='viewreplys(<c:out value="${t.cagGistId}"></c:out>,<c:out value="${m.cagParaId}"></c:out>)'  >View/Delete Replys</button>
									<button type="button" class="btn btn-info " onclick='viewdocs(<c:out value="${t.cagGistId}"></c:out>,<c:out value="${m.cagParaId}"></c:out>)'  >View/Delete Docs</button>
									
									
									
									</td>	</tr>
									
									
									
									
									
									
									
									
									</c:if>
									</c:forEach>
										</c:if>
									</tbody>
								
									
									</table>
										
									</div>
									</div>
									</div>
									</c:forEach>
									
								
				
									
									
									
									
		
</div>
</div>
		
</form:form>

	</div> 	
	
	<div class="row show-grid">
		
					</div>
		

<!-- //main-content -->


 <div id="edit_dialog" title="Para Data" class="col-md-12 edit_dialog">
 
 
							 
							<form:form id="caggistedit" method="post" modelAttribute="cagparas"
								data-parsley-validate-if-empty=""  enctype="multipart/form-data" >
								
						
				<input name=editFlag id="editFlag" type=hidden  value="false" >
				
				 <input name=cagGistId id="cagGistId" type=hidden  value="${paraListforedit.cagGistId }" > 
				<input name=hiddenCircleId id="hiddenCircleId" type=hidden  value="${paraListforedit.circleId }" >
				<input name=hiddenDivisionId id="hiddenDivisionId" type=hidden  value="${paraListforedit.divisionId }" >
				<input name=hiddenSubdivisionId id="hiddenSubdivisionId" type=hidden  value="${paraListforedit.subdivisionId }" >
				
				<input name=hiddenFinancialYear id="hiddenFinancialYear" type=hidden  value="${paraListforedit.financialYear }" >
				
				<input name=hiddenTrCircleId id="hiddenTrCircleId" type=hidden  value="${paraListforedit.tcircleId }" >
				<input name=hiddenTrDivisionId id="hiddenTrDivisionId" type=hidden  value="${paraListforedit.tdivisionId }" >
				<input name=hiddenTrSubdivisionId id="hiddenTrSubdivisionId" type=hidden  value="${paraListforedit.tsubdivisionId }" >
								<div class='container'>




								<!-- 	<div > -->


<div class="col-md-6">
										



											<div class="col-md-6">
												<label class="label-controlPMS rowlebel ">Select Unit  <font color=red>*</font> 
													</label></div>
													
													<div class="col-md-6">
													<select class="form-control" id="editunitId" name="unitId"  onchange="getCircles()" required>
												 <option value=" ">--select--</option>
												
												 <c:forEach items="${unitList}" var="u">
												    <option value="${u.unitId}">${u.unitName}</option>
												 
									           

								</c:forEach>
 
												
												
												</select>
											</div>
										

											
											
												<div class="col-md-6">
												<label class="label-control rowlebel ">Select Circle</label>
												</div>
												<div class="col-md-6">
												<select class="form-control" id="editcircleId" name="circleId" 
													 onchange="getDivisions()">
													<option value="0">--select--</option>
													


												</select>

											</div>
										
											


											<div class="col-md-6">
												<label class="label-controlPMS rowlebel ">Select Division</label>
												</div>
												<div class="col-md-6">
												<select class="form-control" id="editdivisionId" name="divisionId" onchange="getSubDivisions()">
	</select>
											</div>
											
											
											
											
                             
												<div class="col-md-6">
												<label class="label-control rowlebel ">Select SubDivision
													</label></div>
													<div class="col-md-6">
														<select class="form-control" id="editsubdivisionId" name="subdivisionId"  
													>
													


												</select>
													
											</div>
											
										
										<div class="col-md-6">
											<label class="label-control rowlebel ">Financial Year <font color=red>*</font> </label>
											</div>
											
											<div class="col-md-6">
											 <select class="form-control" id="financialYear" name="financialYear" required> 
											 <option value=" ">--select--</option>
											
											 </select></div> 
											 
											 
										    	<div class="col-md-6">
										    <label class="label-controlPMS rowlebel ">
										    Para Number  <font color=red>*</font>  </label>
										    </div>
										    <div class="col-md-6">
										    <select class="form-control" id="paraNumber" name="paraNumber"  required>
										     <option value=" ">--select--</option> 
										     <option value="I">I</option> 
										     <option value="II">II</option> 
										     <option value="III">III</option>
										      <option value="IV">IV</option>
										      <option value="V">V</option>
										      <option value="VI">VI</option>
										      <option value="VII">VII</option>
										      <option value="VIII">VIII</option>
										      <option value="IX">IX</option>
										      <option value="X">X</option>
										      <option value="XI">XI</option>
										      <option value="XII">XII</option>
										      </select> </div>
										      
										      
											 
					
				
										
										
										
										      
										      
										        <div class="col-md-6">
										<label class="label-controlPMS rowlebel ">
										Select Para Status  <font color=red>*</font>  </label>
										</div>
										<div class="col-md-6">
										<select class="paratrunit form-control" id="paraStatusId" name="paraStatusId"  required> 
										<option value=" ">--select--</option> 
										<!--  <option value="1">Reply Sent to AG</option> -->
										<option value="4">Reply Sent to Government</option> 
									    <option value="2">Reply Not Sent</option> 										
									
										<option value="3">Dropped</option> 
									   <!--   <option value="4">Reply Sent to Government</option>  -->
									     
										 </select>
									     </div>
								
										
											</div>
											
											 <div class="col-md-6">
										  <br></br>
									      
										
										
									
										
										<div class="col-md-6">
											 <label class="label-control rowlebel ">Date of Audit <font color=red>*</font> </label>
											 </div>
											 
											 <div class="col-md-3">
											 <label class="label-control rowlebel ">from</label>
											  <input type="text" class="datepick form-control datepicker"  id="auditDateFrom" name="auditDateFrom" placeholder="auditDateFrom"  readonly="readonly" value="0" required/> 
											  </div>
											  
											   <div class="col-md-3">
											   <label class="label-control rowlebel ">to</label>
											  <input type="text" class="datepick form-control datepicker"  id="auditDateTo" name="auditDateTo" placeholder="auditDateto"  readonly="readonly" value="0"  /> 
											  </div>
										
							<br></br>
													
											
											

											  <div class="col-md-6" id="pac" >
										 <label class="label-controlPMS rowlebel ">Discussed in PAC <font color=red>*</font> </label>
										 </div>
						
						
										
									
									
										<div class="col-md-6">
							<div class="form-group">
      
        <div class="col-sm-8" id="statusdiv">
       
        
        <label class="radio-inline"> <input type="radio" name="printCAG" id="printCAG"  checked="checked"    value="false"  required >NO</label>
        <label class="radio-inline"> <input type="radio" name="printCAG" id="printCAG"     value="true"  required >Yes</label>
       
       
        
       
       
          
         
        </div>
    </div>
						</div>
						
						
						 <div class="col-md-6"  >
										 <label class="label-controlPMS rowlebel ">Transferred to Other Office <font color=red>*</font> </label>
										 </div>
						
						<div class="col-md-6">
							<div class="form-group">
      
        <div class="col-sm-8" >
       
        
        <label class="radio-inline"> <input type="radio" name="transferFlag" id="transferFlag"  checked="checked"    value="false"  required >NO</label>
        <label class="radio-inline"> <input type="radio" name="transferFlag" id="transferFlag"     value="true"  required >Yes</label>
       
       
        
       
       
          
         
        </div>
    </div>
						</div>
						
						<div class="col-md-12" id="toffice">
						<br></br>
						<div class="col-md-6">
												<label class="label-controlPMS rowlebel ">Transferred
													Unit</label>
													
													</div>
													<div class="col-md-6">
													<select class="form-control" id="tunitId" name="tunitId"  onchange="gettCircles()">
											<option value="0">--select--</option>
												
												 <c:forEach items="${unitList}" var="u">
									              <option value="${u.unitId}">${u.unitName}</option>

								</c:forEach>
 
												
												
												</select>
											</div>
										

											
											
												<div class="col-md-6">
												<label class="label-control rowlebel ">Transferred Circle</label>
												</div>
												<div class="col-md-6">
												<select class="form-control" id="tcircleId" name="tcircleId"  onchange="gettDivisions()"
													>
													<option value="0">--select--</option>
													


												</select>

											</div>
										
											


											<div class="col-md-6">
												<label class="label-controlPMS rowlebel ">Transferred Division</label>
												</div>
												
												<div class="col-md-6">
												<select class="form-control" id="tdivisionId" name="tdivisionId" onchange="gettSubDivisions()"		>
	</select>
											</div>
											
											
												<div class="col-md-6">
												<label class="label-control rowlebel ">Transferred Sub Division
													</label>
													</div>
													
													<div class="col-md-6">
														<select class="form-control" id="tsubdivisionId" name="tsubdivisionId" 
													>
													


												</select>
													
											</div>				
						
						
						</div>
						
						
		
										
									
									
									

									</div>
									
								
									
		<div class="col-md-12"  >
		<div class="col-md-4"  >
 <label class="label-controlPMS rowlebel ">Gist Of Para<font color=red>*</font> </label>
 </div>
 <div class="col-md-8"  >
        <textarea  name="actionTitle" id="actionTitle" class="  form-control "  rows="2" cols="80"   required > </textarea>
        </div>
											 </div>							

								
								

									

											 

									<div class="col-sm-12">
										<div class="col-md-4 "></div>
										<div class="col-md-8" align="center">
											<label class="label-control rowlebel "></label><input
												type="submit" class="btn btn-1 btn-primary center-block"
												id="submitcaggist" value="Submit CAG Paras">
										</div>
									</div>







							<!-- 	</div> -->
								</div>
								<!-- row -->





							</form:form>
   

  </div>
  <div  id="action_paraalert" title="Action" >  </div>		
  
 <div id="reply_dialog" title="Reply Data" class="col-md-12">
   <div class="form-group">
     <div class="col-md-6">
     <label class="label-controlPMS rowlebel "> Reply Date<font color=red>*</font> </label>
	</div>
	 <div class="col-md-6">
        <input type="text" name="replyDate" id="replyDate" class=" datepick form-control datepicker"  value="0"  readonly="readonly"   required />
       
       </div>
     				
										
    <span id="error_replyDate" class="text-danger"></span>
   </div> 
   <div class="form-group">
   	<label class="label-control rowlebel ">Reply*</label> 
	<textarea class="ckedit form-control "  id="replyAction" name="replyAction" rows="10" cols="80" placeholder="Reply"  ></textarea>
    <span id="error_replyAction" class="text-danger"></span>
   </div>
    <div class="form-group">
    <label class="label-control rowlebel ">Reply Remarks*</label>
<textarea class="form-control"  id="replyRemarks" name="replyRemarks"  rows="10" cols="80" placeholder="Reply Remarks"  ></textarea> 
    <span id="error_replyRemarks" class="text-danger"></span>
   </div>
  
   <div class="form-group" align="center">
    <input type="hidden" name="replyrow_id" id="replyrow_id" />
    <button type="button" name="savereply" id="savereply" class="btn btn-info">Submit</button>
   </div>
  </div>
  <div id="action_replyalert" title="Action">

  </div>	
  
  
	
  
  
  <div id="view-reply" title="View-Replys" style="display:none">
		
		
		
		</div>
		
		<div id="view-docs" title="View-Documents" style="display:none">
		
		
		
		</div>
  



	




		
		
	
	 
	
	 
	 
	 <script type="text/javascript" src="../js/parsley.js"></script>

    
  
 