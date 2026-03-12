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
			
			
			var cyear = (new Date).getFullYear();
			 // var lyear = (new Date).getFullYear()+1;
			 
			$(".datepick").datepicker({
					changeYear : true,
					changeMonth : true,
					
				     
					
					 dateFormat: "dd/mm/yy"+" "+ getCurrentTime(),
					   
					
				/* 
				 dateFormat : "dd/mm/yy", onSelect: function(selected) {
				   $("#month").datepicker("option","minDate", selected)
				 } */
				});
		
		//	var pos = { my: "center center", at: "center top+150", of: window };
		
		
		
		 var d = new Date();
	  var e=new Date();
	 e= e.getFullYear() - 39;
	  var j=00;
    for (var i = 40; i >= 0; i--) {
  	 // alert(i);
        var option = "<option value=" + parseInt(d.getFullYear() - i) +"-"+e+ ">" + parseInt(d.getFullYear() - i) +"-"+e+ "</option>"
       // alert(option);
        
        $('[id*=financialYear]').append(option);
        e++;
       // j++;
    }
    
	
	

	$('#financialYear').multiselect({
		 
		 enableCaseInsensitiveFiltering: true
		 
	});
	
	$('#cagGistId').multiselect({
		 
		 enableCaseInsensitiveFiltering: true
		 
	});
			
			
			 $('.para_dialog').dialog({
				  autoOpen:false,
				  width:800
				 
				  /* position:pos,
					 buttons: {
					     "Close ": function() {
					      $( this ).dialog( "close" );
					      },
					     "Submit ": function(){
					   //  $('#msg').html($("#f1").serialize());
					     $( this ).dialog( "close" );
					     } */
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
			 
			 $('#action_docsalert').dialog({
				  autoOpen:false
				 });
			 
			 
			 $('#spara_dialogue').dialog({
				  autoOpen:false,
				  width:1200,
				  close: function() {
					  
					
						  $(this).dialog("close");
						  }
				 });
			 
			  
			/*  $('#showpara_dialog').dialog({
				  autoOpen:false,
				  width:800
				   /* , position:pos,
					 buttons: {
					     "Close ": function() {
					      $( this ).dialog( "close" );
					      },
					     "Submit ": function(){
					   //  $('#msg').html($("#f1").serialize());
					     $( this ).dialog( "close" );
					     } 
					 } */
			//   });  */
			 
			 
			
			 
			 
			 
			
			 $('#doc_dialog').dialog({
				  autoOpen:false,
				  width:1200
				   /* , position:pos,
					 buttons: {
					     "Close ": function() {
					      $( this ).dialog( "close" );
					      },
					     "Submit ": function(){
					   //  $('#msg').html($("#f1").serialize());
					     $( this ).dialog( "close" );
					     } 
					 } */
			   }); 
			
			
			 $('#status_dialog').dialog({
				  autoOpen:false,
				  width:1200
				   
			   }); 
			 
			 
			 
			
			 
			 var m = $(this).find('.ckedit')
				m.ckeditor();

				//alert("coming here")
				$('.ckedit').ckeditor();
				clicked();
				
				
				
				 $('#savereply').click(function(){
					 
				//alert("kal");
						var n= $('#savereply').text() ;
						
					//	alert("kal"+n);
					 
					if(n=='Edit'){
						
						
					//	alert("coming inside"+n);
						 
						 $('#action_alert').empty();
						 
						 
						 if ($('form[id=myreplys]').parsley().isValid()) { 
						 
						 var   paraReplyId= $('#paraReplyIdhide').val(); 
						  var replyAction= $('#replyAction').val(); 
						  var replyRemarks= $('#replyRemarks').val(); 
						  var replyDate= $('#replyDate').val(); 
						  var cagGistId= $('#cagGistIdhide').val(); 
						  var cagParaId= $('#cagParaIdhide').val(); 
						  var subParaUnitId= $('#subParaUnitIdhide').val(); 
						//  var paraStatusId= $('#paraStatusId').val(); 
						 
						////alert("paraReplyId"+paraReplyId);
						//alert("replyAction"+replyAction);
						 if(paraReplyId  > "0" && replyAction!=null)
						  {
							  
			 				 // alert("kal1"+replyRemarks);
							  
							
							 
								
								 
					  $.ajax({	          
					      url: "../parastsimis/editcagreply" ,
					      method:"POST",
					      dataType: 'json',
					     
					      async: false,
					      data: {
					    	
					    	
					    	  paraReplyId:paraReplyId,
					    	  replyAction : replyAction,
					    	  replyRemarks : replyRemarks,
					    	  replyDate : replyDate,
					    	//  paraStatusId: paraStatusId,
					    	  cagParaId: cagParaId,
					    	  subParaUnitId: subParaUnitId
					      },
					     
						
					      success: function (response) {
					   
					    	 // alert("kal response"+response);
					    	 
					    	 //  alert(finYear);
							   //getSubParaList(cagGistId);
							    
							    if(response>0){
							    	
							    	
					    	 
					    	  $('#action_alert').html('<p>Data Updated Successfully</p>');
					    	  
					    	  $("#myreplys").trigger("reset"); 	
					    	  
					    	  viewreplys(cagGistId,cagParaId,subParaUnitId);
					    	  
					    	  $('#reply_dialog').dialog('close'); 
					    	  
					    	
							    }
							    if(response==0){
							    	
							    	  $('#action_alert').html('<p>Failed to Update data</p>');
							    }
							  //  $('#action_alert').dialog('open'); 
							  
							   // getunitData(unitId,circleId,divisionId) ;
							    $("#myreplys").trigger("reset"); 	

					      },
					      error : function(){
					    	 alert(error);
					     // $('#action_alert').dialog('open');
					      }
					
					  
					  }); 	
					  
						 
					} 
						 
						 }else{
						   	 
						   	 $('form[id=myreplys]').parsley().validate();
						   	 
						    }
					 
					 
					}
					 });
				
		})
		
	</script>
	
	<script type="text/javascript">

function clicked(){
	
	$("#replyAction").attr('required', '');

	for ( instance in CKEDITOR.instances ){
		
		CKEDITOR.instances[instance].getData();
	//alert("ckeditor values : " + CKEDITOR.instances[instance].getData());
	}
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


</script>


<script type="text/javascript">

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
function viewreplys(cagGistId,cagParaId,unitId){
	
	//alert("unitId"+unitId);
	
	 $('#view-reply').empty();   
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
	        "close reply": function() {
	            $(this).dialog("close");
	        }
	    }
	});

	
	// url: "../parastsimis/getcagReplys",	
$.ajax({
    type: "GET", //rest Type
    dataType: 'json', //mispelled
    url: "../parastsimis/getcagReplys",
    async : false ,
    contentType: "application/json; charset=utf-8",
    data :{
    	cagParaId:cagParaId
    	
    
    },
    success: function (msg2) {
       // console.log(msg); 
       
         if(msg2.length>0){
        $('#view-reply').empty();   
      
     
     
       
         for(i in  msg2 ){
        	 var j=parseInt(i)+1;
    
       
        var userN=msg2[i].userName;
    
    
      if(unitId==msg2[i].subParaUnitId || unitId==9832  ){
    	  var k=msg2[i].paraStatusId;
      
    	 // alert("k"+k);
    	 // alert("k"+k);
      
    	
      if(unitId==9832  || msg2[i].subParaUnitId!=unitId ){
    	  
    	  // if(k==7 || k==9 &&  k==10 &&  k==8 ){  
    	
      //  $("#view-reply").append('<div  class="col-md-12 " style="background-color:grey; color:white; font-weight:bold; float:left;"> <div class="col-md-2" style="text-align:left;">Reply No '+ j  +'  </div><div class="col-md-2" style="text-align:left;">Unit Name: '+ msg2[i].unitName  +'  </div> <div class="col-md-2" style="text-align:left;">Reply Date: '+ msg2[i].replyDate  +'  </div></div>');
    	   //  <div  class="col-md-2 " > <button type="button" class="btn btn-danger " onclick="deleteReply('+msg2[i].paraReplyId+','+msg2[i].subParaUnitId+','+cagGistId+','+cagParaId+')"  >Delete Reply</button> </div> <div  class="col-md-2 " > <button type="button" class="btn btn-primary " onclick="editReply('+msg2[i].paraReplyId+')"  >Edit Reply</button> </div>}
    	}
      if(msg2[i].subParaUnitId==unitId  ){
    	  
    	   if(k==20  ){     
          $("#view-reply").append('<div  class="col-md-12 " style="background-color:grey; color:white; font-weight:bold; float:left;"> <div class="col-md-2" style="text-align:left;">Reply No '+ j  +'  </div><div class="col-md-2" style="text-align:left;">Unit Name: '+ msg2[i].unitName  +'  </div> <div class="col-md-2" style="text-align:left;">Reply Date: '+ msg2[i].replyDate  +'  </div> <div  class="col-md-2 " > <button type="button" class="btn btn-danger " onclick="deleteReply('+msg2[i].paraReplyId+','+msg2[i].subParaUnitId+','+cagGistId+','+cagParaId+')"  >Delete Reply</button> </div> <div  class="col-md-2 " > <button type="button" class="btn btn-primary " onclick="editReply('+msg2[i].paraReplyId+')"  >Edit Reply</button> </div></div>');
          
         // $("#view-reply").append('<div  class="col-md-12 " style="background-color:grey; color:white; font-weight:bold; float:left;"> <div class="col-md-2" style="text-align:left;">Reply No '+ j  +'  </div> <div class="col-md-2" style="text-align:left;">Unit Name: '+ msg2[i].unitName  +'  </div><div class="col-md-2" style="text-align:left;">Reply Date: '+ msg2[i].replyDate  +'  </div> </div>');
    	   }
    	   if((k==7 || k==8|| k==9 || k==10 || k==3) && unitId==9832){     
    	          $("#view-reply").append('<div  class="col-md-12 " style="background-color:grey; color:white; font-weight:bold; float:left;"> <div class="col-md-2" style="text-align:left;">Reply No '+ j  +'  </div><div class="col-md-2" style="text-align:left;">Unit Name: '+ msg2[i].unitName  +'  </div> <div class="col-md-2" style="text-align:left;">Reply Date: '+ msg2[i].replyDate  +'  </div> <div  class="col-md-2 " > <button type="button" class="btn btn-danger " onclick="deleteReply('+msg2[i].paraReplyId+','+msg2[i].subParaUnitId+','+cagGistId+','+cagParaId+')"  >Delete Reply</button> </div> <div  class="col-md-2 " > <button type="button" class="btn btn-primary " onclick="editReply('+msg2[i].paraReplyId+')"  >Edit Reply</button> </div></div>');
    	          
    	         // $("#view-reply").append('<div  class="col-md-12 " style="background-color:grey; color:white; font-weight:bold; float:left;"> <div class="col-md-2" style="text-align:left;">Reply No '+ j  +'  </div> <div class="col-md-2" style="text-align:left;">Unit Name: '+ msg2[i].unitName  +'  </div><div class="col-md-2" style="text-align:left;">Reply Date: '+ msg2[i].replyDate  +'  </div> </div>');
    	    	   }
      } 
      
     
     
      /*  if(unitId!=msg2[i].subParaUnitId ){
    	  if(msg2[i].subParaUnitId==9832){
    	  $("#view-reply").append('<div  class="col-md-12 " style="background-color:grey; color:white; font-weight:bold; float:left;"> <div class="col-md-2" style="text-align:left;">Reply No '+ j  +'  </div> <div class="col-md-2" style="text-align:left;">Unit Name: updated by '+ msg2[i].unitName  +'  </div><div class="col-md-2" style="text-align:left;">Reply Date: '+ msg2[i].replyDate  +'  </div> </div>');
    	  }
    	  if(msg2[i].subParaUnitId!=9832){
        	  $("#view-reply").append('<div  class="col-md-12 " style="background-color:grey; color:white; font-weight:bold; float:left;"> <div class="col-md-2" style="text-align:left;">Reply No '+ j  +'  </div> <div class="col-md-2" style="text-align:left;">Unit Name: '+ msg2[i].unitName  +'  </div><div class="col-md-2" style="text-align:left;">Reply Date: '+ msg2[i].replyDate  +'  </div> </div>');
        	  } 
      } */
      
        $("#view-reply").append(' <div  class="col-md-12 " > '+  msg2[i].replyAction +' </div>'); 
        $("#view-reply").append('<div  class="col-md-12 " style="background-color:#f0f0f5; color:black; font-weight:bold; float:left;"> <div  style="text-align:left;">Remarks</div> </div>'); 
        $("#view-reply").append(' <div  class="col-md-12 " > '+  msg2[i].replyRemarks +' </div>'); 
                   
         }else{
        	 
        	 if(unitId!=9832  && msg2[i].subParaUnitId!=unitId ){
           	  
           	  // if(k==7 || k==9 &&  k==10 &&  k==8 ){  
           	
               $("#view-reply").append('<div  class="col-md-12 " style="background-color:grey; color:white; font-weight:bold; float:left;"> <div class="col-md-2" style="text-align:left;">Reply No '+ j  +'  </div><div class="col-md-2" style="text-align:left;">Unit Name: '+ msg2[i].unitName  +'  </div> <div class="col-md-2" style="text-align:left;">Reply Date: '+ msg2[i].replyDate  +'  </div></div>');
           	   //  <div  class="col-md-2 " > <button type="button" class="btn btn-danger " onclick="deleteReply('+msg2[i].paraReplyId+','+msg2[i].subParaUnitId+','+cagGistId+','+cagParaId+')"  >Delete Reply</button> </div> <div  class="col-md-2 " > <button type="button" class="btn btn-primary " onclick="editReply('+msg2[i].paraReplyId+')"  >Edit Reply</button> </div>}
           	}
        	 
        	  $("#view-reply").append(' <div  class="col-md-12 " > '+  msg2[i].replyAction +' </div>'); 
              $("#view-reply").append('<div  class="col-md-12 " style="background-color:#f0f0f5; color:black; font-weight:bold; float:left;"> <div  style="text-align:left;">Remarks</div> </div>'); 
              $("#view-reply").append(' <div  class="col-md-12 " > '+  msg2[i].replyRemarks +' </div>'); 
                         
         
         }         
         
         $("#main3").append(	'</div>' );
     
         } 
         
         if(msg2.length==0){
       	  
       	  
        	 // alert("not cmoing here");
        	  
        	//  $("#view-reply").dialog('close');
        	
        	  
          
          }
         
         }
         
    }



    
});
}
function viewdocs(cagGistId,cagParaId,unitId){
	
	 $('#view-docs').empty();   
	
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
	        "close docs": function() {
	            $(this).dialog("close");
	        }
	    }
	});


$.ajax({
    type: "GET", //rest Type
    dataType: 'json', //mispelled
    url: "../parastsimis/getcagDocs",
    async: false,
    data : {
    	cagParaId:cagParaId
    	
    },
    
    contentType: "application/json; charset=utf-8",
    success: function (msg3) {
      // console.log(msg3); 
     //  alert(msg3);
     
      
     if(msg3.length>0){
       $('#view-docs').empty();   
        
        
       
         for(k in  msg3 ){
        	 var m=parseInt(k)+1;
      /*  $("#view-docs").append(' <div  class="col-md-12 " style="font-weight:bold;" >  Reply S.No  '+ m +' </div>'); */ 
       
        var userN=msg3[k].userName;
      // alert("userN"+userN); 
     
    // alert( msg2[i].replyAction);
        
       if(msg3[k].unitId==unitId){
    	   
       
     if(msg3[k].unitId==9832){
         $("#view-docs").append('<div  class="col-md-12 " style="background-color:grey; color:white; font-weight:bold; float:left;"> <div class="col-md-3" style="text-align:left;">Document No '+ m  +' </div><div class="col-md-3" style="text-align:left;">Document Title: '+ msg3[k].doctitle  +'  </div> <div class="col-md-3" style="text-align:left;">Document Date: '+ msg3[k].docdate  +'  </div> <div  class="col-md-3 " > <button type="button" class="btn btn-danger " onclick="deleteDocs('+msg3[k].docId+','+cagGistId+','+cagParaId+','+unitId+')"  >Delete Document</button> </div> </div>');
       }
     if(msg3[k].unitId!=9832){
         $("#view-docs").append('<div  class="col-md-12 " style="background-color:grey; color:white; font-weight:bold; float:left;"> <div class="col-md-3" style="text-align:left;">Document No '+ m  +' </div><div class="col-md-3" style="text-align:left;">Document Title: '+ msg3[k].doctitle  +'  </div> <div class="col-md-3" style="text-align:left;">Document Date: '+ msg3[k].docdate  +'  </div><div  class="col-md-3 " > <button type="button" class="btn btn-danger " onclick="deleteDocs('+msg3[k].docId+','+cagGistId+','+cagParaId+','+unitId+')"  >Delete Document</button> </div> </div>');
       }
       }
       
       if(msg3[k].unitId!=unitId){
    	 
    	   if(msg3[k].unitId==9832){
           $("#view-docs").append('<div  class="col-md-12 " style="background-color:grey; color:white; font-weight:bold; float:left;"> <div class="col-md-4"  style="text-align:left;">Document No '+ m  +' </div><div class="col-md-4" style="text-align:left;">Unit Name: updated by '+ msg3[k].unitName  +'  </div></div>');
         }
    	   if(msg3[k].unitId!=9832){
               $("#view-docs").append('<div  class="col-md-12 " style="background-color:grey; color:white; font-weight:bold; float:left;"> <div class="col-md-4"  style="text-align:left;">Document No '+ m  +' </div><div class="col-md-4" style="text-align:left;">Unit Name: '+ msg3[k].unitName  +'  </div></div>');
             }
       }
        $("#view-docs").append(' <div  class="col-md-12 " > <a href="../uploadedFiles/CAGParas/'+  msg3[k].paraDocName +'" target="_blank" > '+  msg3[k].paraDocOriginalName +'</a> </div>');  
                   
         }         
         $("#main3").append(	'</div>' );
       /*   $("#main1").append(	'</div>' ); */
     }if(msg3.length==0){
    	 
    	// $("#view-docs").dialog('close');
   	  
     
     
     }
         
    }
});
	
	



}

function deleteReply(replyId,unitId,gistId,paraId){
	
	//,unitId,circleId,divisionId
	
	var cagreplyId=parseInt(replyId);
	
	//alert(cagreplyId);
	
	 var valid = "Are you sure you want to delete reply?";
		  if (confirm(valid)) { 
		
		  $.ajax({	          
		      url: "../parastsimis/deleteCagReply",
		      method:"POST",
		      async : false ,
		      data :{
		    	  cagReplyId:cagreplyId
		      	
		      
		      },
			 
		      success: function (response) {
		   
		    	//  alert("kal"+response);
		    	 if(response>0){
		    		 
		    	 
		    	  $('#action_paraalert').html('<p>Data Deleted Successfully</p>');
		    	  
		   
		    	  
		    	      viewreplys(gistId,paraId,unitId);
				 
				  //  getunitData(unitId,circleId,divisionId) ;
		    	 }

		      },
		      error : function(){
		    	 alert(error);
		     
		      }
		  }); 	
			 
}
else{
	
	return false;
  
}
			
	
	
	}
	
	function deleteDocs(docId,cagGistId,cagParaId,unitId){
		
		
		//,unitId,circleId,divisionId
		
		 var valid = "Are you sure you want to delete documents?";
		  if (confirm(valid)) { 
		
		
		  $.ajax({	          
		      url: "../parastsimis/deleteCagDocs" ,
		      method:"POST",
		      async : false ,
		    
		      data :{
		    	  cagDocId:docId
		      	
		      
		      },
			 
			 
		      success: function (response) {
		   
		    	 // alert("kal"+response);
		    	 if(response>0){
		    	
		    	 
		    	  $('#action_paraalert').html('<p>Data Deleted Successfully</p>');
		    	  
		    	  viewdocs(cagGistId,cagParaId,unitId);
				  
				//    getunitData(unitId,circleId,divisionId) ;
		    	 }

		      },
		      error : function(){
		    	 alert(error);
		    //  $('#action_paraalert').dialog('open');
		      }
		  }); 	
			   
		  }
		  else{
		  	
		  	return false;
		    
		  }
	
	
	}
	
	function editReply(replyId){
		
		
	//	alert("replyId"+replyId);
		
		
		  $.ajax({	          
		      url: "../parastsimis/getcagreplybyreplyId ",
		      method:"POST",
		      async : false,
		      data : {
		    	  cagReplyId:replyId 
		      },
			 
		      success: function (response) {
		   
		    	  //console.log(response);
		    	
		    	  var obj = JSON.parse(response);
		    	  //console.log(obj.replyDate);
		    	//  alert("kal"+response);
		    	 
		    	//  $('#action_paraalert').html('<p>Data Deleted Successfully</p>');
				  //  $('#action_paraalert').dialog('open'); 
				  //  getunitData(unitId,circleId,divisionId) ;
		    	
		    	 $('#replyDate').val(obj.replyDate);  
		    	 $('#replyAction').val(obj.replyAction);  
		    	 $('#replyRemarks').val(obj.replyRemarks);  
		    	 $('#paraReplyIdhide').val(replyId);  
		    	 $('#cagGistIdhide').val(obj.cagGistId);  
		    	 $('#cagParaIdhide').val(obj.cagParaId);  
		    	 $('#subParaUnitIdhide').val(obj.subParaUnitId);  
		    	 $('#paraStatusId').val(obj.paraStatusId);  
		    	
		    	 

		      },
		      error : function(){
		    	 alert(error);
		    //  $('#action_paraalert').dialog('open');
		      }
		  }); 	
		
		  
		  $('#reply_dialog').dialog('option', 'title', 'Edit Reply');
			
		  $('#reply_dialog').dialog('open');
		  $('#savereply').text('Edit');
			
		  
		  
			
		  
	
	
	}
	
	
	
	





       
    </script>



<script>

function getcagGist(finYear){
//	alert("cmoing here"+finYear);
	//var districtId=document.getElementById("districtId").value;
	//var finYear=document.getElementById("financialYear").value;
	//alert(cagGistId);
  
   $('#action_alert').empty();
	  $.ajax({	          
      url: "../parastsimis/getParagistbyFinYear",
      type: "GET",
      async: false,
      data: {
    	  financialYear: finYear
      },
     
     
      success: function (response) {
    	  
    	
         
          

    	  var $select = $('#cagGistId');
    	 
		  $select.find('option').remove();
		 // alert("kal1");
		  
		  var obj = JSON.parse(response);
		 // alert("kal2");
		 
		
		  $('#cagGistId').append( '<option value="0"> --select--</option>' );
				
				 
				  
				$.each(obj, function(key, value) {
					
						$('#cagGistId').append( '<option value="'+value.cagGistId+'" > '+value.paraNumber+' '+value.actionTitle+'</option>' );
				
						$('#cagGistId').multiselect('rebuild');
				});
                   
      },
      error : function(){
    	  alert(error);
      }
  }); 	
}



	
	
	
</script>


<script >

	
	


function getDatamain(financialYear){
	
	
	//alert("financialYear"+financialYear);
	
	$("#mainfinancialYear").val(financialYear);
	//  $("#unitId").val(unitId);
	var unitid= $("#userunitId").val();
	// alert(unitid);
	 
	 var circleid= $("#usercircleId").val();
	// alert(circleid);
	 document.forms[0].urlvalue.value="../parasreport/cagparas";

		 document.forms[0].submit(); 
	
	
}




	
	

	function addcagparareply(gistId, paraId,unitId,finyear){
		
		 
//alert("paraId"+paraId);
//alert("unitId"+unitId);
		  
		    $("#myreplys").trigger("reset"); 	
		   $('#action_alert').empty();  
			
			  $('#reply_dialog').dialog('option', 'title', 'Add Reply Data');
			  
			
			  $('#savereply').text('Submit');
			  $('#reply_dialog').dialog('open');
			  
			
			
			  
			  $("#myreplys").trigger("reset"); 	
			  
			  $('#replyAction').val(' '); 
			  
			  $('#replyRemarks').val('  '); 
			

			 $('#savereply').click(function(){
				 
				 
				
				 
				var m= $('#savereply' ).text();
				
				if(m=='Submit'){
			  
			 
			
		if ($('form[id=myreplys]').parsley().isValid()) {	
			
			
			  var replyAction= $('#replyAction').val(); 
			  var replyRemarks= $('#replyRemarks').val(); 
			  var replyDate= $('#replyDate').val(); 
			  var cagGistId= parseInt(gistId);
			  var cagParaId= parseInt(paraId);
			  var unitId= unitId ;
			
		
					 
		  $.ajax({	          
		      url: "../parastsimis/addcagreply" ,
		      method:"POST",
		      dataType: 'json',
		     
		      async: false,
		      data: {
		    	  cagGistId:cagGistId,
		    	  cagParaId :cagParaId,
		    	 
		    	  subParaUnitId:unitId,
		    	//  paraStatusId:paraStatusId,
		    	  replyAction : replyAction,
		    	  replyRemarks : replyRemarks,
		    	  replyDate : replyDate
		      },
		     
			 
		      success: function (response) {
		   
		    	 // alert("kalreply"+response);
		    	 if(response>0)  {
		    	  $('#action_alert').html('<p  style="margin: 0px !important;">Data Inserted Successfully</p>');
		    	
				    
		    	  getmainData(finyear);
				   
				    $("#myreplys").trigger("reset"); 	
				    
				    $('#reply_dialog').dialog('close');
		    	 }
		    	 if(response==0 || response==null){
		    		 
		    		  $('#action_alert').html('<p  style="margin: 0px !important;">Failed to Insert data</p>');
		    	 }
		    	 
		    	 $("#myreplys").trigger("reset"); 	
				    

		      },
		      error : function(){
		    	 alert(error);
		     // $('#action_replyalert').dialog('open');
		      }
		  }); 	
			 // alert("kal3");
		}else{
		   	 
		   	 $('form[id=myreplys]').parsley().validate();
		   	 
		    }
			  
			   
 
				}
			 
			 });
		
		
		
	}
	
	function getmainData(financialYear){
		
	
		  $('#action_alert').empty();
	
		if(financialYear!=null){
			getDatamain(financialYear)
		}
		
		
	}
	
	
	function addnewdocs(gistId, paraId, unitId,finyear ){
		 
		
		  $('#action_alert').empty();
		 
		  $('#doc_dialog').dialog('option', 'title', 'Add Documents');
	  
		  $('#savedocs').text('Submit');
		  $('#doc_dialog').dialog('open');
		  
		
		  
		  $('#savedocs').text('Submit');
		  
		
		  var customformid=document.getElementById("myFormdoc");
		  $(customformid).trigger("reset"); 	
		  $('#action_alert').empty(); 
		  
  var cagGistId=parseInt(gistId);
		  
		  var cagParaId=parseInt(paraId);
		  
		  $('#cagGistIddochidden').val(cagGistId);
		  $('#cagParaIddochidden').val(cagParaId);
		  
		  $('#savedocs').click(function(){
			  
			
			  
			  if ($('form[id=myFormdoc]').parsley().isValid()) {
			  
			  var fileInput = document.getElementById("uploadFile");

			  if (!fileInput.value) {
			   // console.log("No files selected.")
			    return;
			  }
			
			  
			  
			  
			  var form = $(customformid).closest("form");
				 var formData = new FormData(form[0]);
			  
			
				
		
		  if(gistId  > "0" && paraId  > "0"  && uploadFile!=null)
		  {
			  
				//alert("gistId"+gistId);
				
				//alert("paraId"+paraId);
			 
				 
				  $.ajax({	          
				      url: "../parastsimis/addcagdocs",
				      method:"POST",
				      async: false,
				      data:  formData,
				    
			          contentType: false,
			          processData: false,
				      success: function (response) {
				    	  
				    	 // alert( "response"+response);
				      
				    	  
				    	  if(response>0){
					    		 
						    		//alert("i am in kal Data inserttedd Successfully");
						
							  $('#action_alert').html('<p style="margin: 0px !important;">Documents updated Successfully</p>');
							
								$("html,body").animate({scrollTop:$('#action_alert').offset().top-175}, 500);
								
								
								 
								 $(customformid).trigger("reset"); 
								 
								  
								 getmainData(finyear);
								  
								  $('#doc_dialog').dialog('close'); 
								  
								  
								 
								
								 
							    }
								
								if(response==0||response==null){
							    	
							    	  $('#action_alert').html('<p style="margin: 0px !important;">Failed to Update Documents</p>');
							    		$("html,body").animate({scrollTop:$('#action_alert').offset().top-175}, 500);
							    }
								
								 $(customformid).trigger("reset"); 	
								
				      },
				      error : function(){
				    	  alert(error);
				      }
				  });
				 
	
		  
		   }
		  
			  }else{
				   	 
				   	 $('form[id=myFormdoc]').parsley().validate();
				   	 
				    }
	
		 
		 
		 });
		  
		 
	
	 }
	
	
	
	function addstatus(gistId, paraId, unitId , finyear){
		
		//alert("finyear"+finyear);
		// alert("paraId"+paraId);
			//alert("unitId"+unitId);
			
			var cagGistId=parseInt(gistId);
			var cagParaId=parseInt(paraId);
			
			 $('#cagGistIdstatushidden').val(cagGistId);
			 $('#cagParaIdstatushidden').val(cagParaId);
			 
			 var finnew="'"+finyear+"'";
		 
		
		  $('#status_dialog').dialog('option', 'title', 'Add Status/Remarks');
	  
		 
		  $('#status_dialog').dialog('open');
		  
		  
		
			 var customformid="#myFormstatus";		  
						 
		  $(customformid).trigger("reset"); 	

							 $('#savestatus').click(function(){
								 
								var m= $('#savestatus' ).text();
								
								if(m=='Submit'){
									
									
								
									  
									  var form = $(customformid).closest("form");
										 var formData = new FormData(form[0]);
										 
										 if ($('form[id=myFormstatus]').parsley().isValid()) {

										 
							
				 			  if(gistId  > "0" && paraId  > "0"  )
							  {
							
									 
						  $.ajax({	          
						      url: "../parastsimis/add-status" ,
						      method:"POST",
						      async: false,
						      data:  formData,
						    
					          contentType: false,
					          processData: false,
						     
							 
						      success: function (response) {
						   
						    	 // alert("kalreply"+response);
						    	 
						    	  $('#action_alert').html('<p  style="margin: 0px !important;">Status updated Successfully</p>');
								   
						    	  $(customformid).trigger("reset"); 
						    	  
						    	  getDatamain(finyear);
						    	  
						    	  $('#status_dialog').dialog('close');
								   // getunitData(unitId) ;

						      },
						      error : function(){
						    	 alert(error);
						     // $('#action_replyalert').dialog('open');
						      }
						  }); 	
							 // alert("kal3");
								
							  
							   }
				 			  
										 } else{
				 			   	 
				 			   	 $('form[id=myFormstatus]').parsley().validate();
				 			   	 
				 			    }
				 
								}
							 
							 });
		
	 }
	
	function openpara(count){
		//alert("coming here"+count);
	
		
		 $('#spara_dialogue').dialog('option', 'title', 'View Para/Sub Para');
		  $('#spara_dialogue').dialog('open');
		  $('.pdata').hide();
	
		  var dataid="#viewdata"+count;
		//  alert("dataid"+dataid);

		  $(dataid).removeAttr('style');
		 
		  
		  
		//  $('#addsluiceformbutton').show();
		//  $('#editsluiceformbutton').hide();
		
		
	}
		
	
		
		 
	 
	
</script>




<div class="col-md-9">
	


<div>


	<div class="panel panel-primary  ">
			<div class="panel-heading">
				<h3 class="panel-title">Add Reply/Docs of CAG Paras	<c:if test="${userObj!=null}">	
				<div class="span6 pull-right">
				
				Welcome to    
						
						 
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
		
		<div class="alert alert-info col-md-12" style="padding: 0px" id="action_alert">
					
				</div>	
		
			 
<form:form id="delirparas" method="post" 	modelAttribute="cagreplydocs" >
				<input name=urlvalue  id="urlvalue" type=hidden >
				<input name=paravalue id="paravalue" type=hidden >
				
				
				<input name=unitId     id="userunitId" type=hidden   value="${userObj.unitId}" />
			<!-- <input name=financialYear   id="hiddenfinancialYear" type=hidden   /> -->
				<!-- <input name=circleId     id="circleId" type=hidden   /> -->
				<input name=circleId     id="usercircleId" type=hidden  value="${userObj.circleId}" />
				<input name=divisionId     id="divisionId" type=hidden   />
	  
				
				
				<input name=editFlag  id="editFlag" type=hidden value="false" >
				
				<input name=deleteFlag  id="deleteFlag" type=hidden value="false" >
				<input name=paraId  id="paraId" type=hidden >
				
					<input name=userObjUserName  id="userObjUserName" type=hidden value="${userObj.userName}" >



		
		<input name=financialYear id="mainfinancialYear" type=hidden >
		
		
		
		
		
		<div id="sidetree">
<div class="treeheader">&nbsp;</div>
<!-- <div id="sidetreecontrol"><a href="?#">Collapse All</a> | <a href="?#">Expand All</a></div> -->


 <div id="accordion1" class="treeDiv">
<ul id="tree">


<c:forEach items="${selectCAGparaFYear}" var="d" varStatus="count">
									

								
	<li><a class="myunit"  href="#" onclick="getDatamain('${d.financialYear}')" ><strong><c:out value="${d.financialYear}"></c:out></strong></a>
	<%-- <a class="myunit"  href="#" ><strong><c:out value="${d.unitName}"></c:out></strong></a> --%>
	
	
	</li>
	
	</c:forEach>  
	
		
		
		
	</ul>
	</div>
	
</div>
		


















<%-- <div class="col-md-12 "> 
				
<c:if test="${userObj.unitId!=null}">				
		

		<c:forEach items="${unitList}" var="m">					
								
		
	<c:if test="${userObj.unitId==m.unitId  }">
	


	<div class="col-md-4  "> 
	<a class="myunit"  href="javascript:void(0)"  style="text-decoration: none; border-bottom: 1px solid black; color: #000000;" onclick="getData(<c:out value="${m.unitId}"></c:out>)"><strong><c:out value="${m.unitName}"></c:out></strong></a>
	</div>
	
	</c:if>
	
	</c:forEach>
	

	</c:if>
	
	
	   <select class="paratrunit form-control" id="financialYear" name="financialYear"  required onchange="getDatamain(this.value)"> 
										<option value=" ">--select--</option> 
																			
									
										 </select>
	
	
	
	
</div> --%>

	
		
		

	
	
		
<%-- 	<c:out value="${parasData[0].financialYear}"></c:out> 
 --%>
		
			



					
						<br><br><br>
						
                             <div class="table-responsive" >    
						
						<table class="table-bordered " >
								 <thead >
										
									
									<tr style=" font-size: 18px;color:blue;font-weight:bold" >
										<th >Sl.No</th>
										<th >Unit Name</th>
										<th  >financial Year</th>
										<th  >Para Number</th>
										<th >Gist of Para</th>
										<th >Sub Para Number</th>
											<th >Sub Para Title</th>
											<th >Sub Para</th>	 	
										
										<th >Action</th>	
										<th >Replies Status</th>	
													
									    <th >Discussed in PAC</th>	
									       <th >PAC Recommendations</th>	
									    <th >Para Status</th>							
									
									</tr>
									

									

								</thead> 


								<tbody>
								
								<c:forEach items="${parasData}" var="t" varStatus="count">
								<tr >
								<td style="text-align: center;"><c:out
														value="${count.count}"></c:out></td>
								<td ><c:out value="${t.unitName}"></c:out></td>
								<td ><c:out value="${t.financialYear}"></c:out></td>
								<td ><c:out value="${t.paraNumber}"></c:out></td>
								<td ><b><c:out value="${t.cagGistPara}"></c:out></b></td>
								<c:choose>
								<c:when test="${t.subParaNumber=='0'}">
								<td ><b>--</b></td>
								</c:when>
								<c:otherwise>
								<td ><b><c:out value="${t.subParaNumber}"></c:out></b></td>
								</c:otherwise>
								</c:choose>
								
								<c:choose>
								<c:when test="${t.paraTitle=='0'}">
								<td ><b>--</b></td>
								</c:when>
								<c:otherwise>
								<td ><b><c:out value="${t.paraTitle}"></c:out></b></td>
								</c:otherwise>
								</c:choose>
								
								
								<td ><button type="button" id="showp" class="btn btn-success viewparashow"  onclick='openpara(${count.count})'  >Show Sub Para</button></td> 
							
								
						
						<c:choose>
						
						<c:when test="${(userObj.unitId!=9832 && userObj.circleId!=21614) && (userObj.unitId!=4)}">
								
							<td>  
							<c:if test="${t.paraStatusId==20  }">
							<br>  	<button type="button" id="addreply"  onclick="addcagparareply(<c:out value="${t.cagGistId}"></c:out>,<c:out value="${t.cagParaId}"></c:out>,<c:out value="${t.subParaUnitId}"></c:out>,'${t.financialYear}' )" class="btn btn-success " >Add Replies ${t.subParaNumber}</button>  
								<br> <button type="button" id="adddocs"  onclick="addnewdocs(<c:out value="${t.cagGistId}"></c:out> ,<c:out value="${t.cagParaId}"></c:out>,<c:out value="${t.subParaUnitId}"></c:out>,'${t.financialYear}')" class="btn btn-success" >Add Documents ${t.subParaNumber}</button> 
								<%--  <br> <button type="button" id="addsts"  onclick="addstatus(<c:out value="${t.cagGistId}"></c:out> ,<c:out value="${t.cagParaId}"></c:out>,<c:out value="${t.subParaUnitId}"></c:out>,'${t.financialYear}')" class="btn btn-success" >Add Status/Remarks ${t.subParaNumber}</button> --%>
								
								</c:if>
								 
							<%-- <br> <button type="button" id="editsts"  onclick='editstatus(<c:out value="${t.cagGistId}"></c:out> ,<c:out value="${t.cagParaId}"></c:out>,<c:out value="${t.subParaUnitId}"></c:out>)' class="btn btn-success" >Edit Status/Remarks</button>  --%>
									
								<br> 	<button type="button" class="btn btn-primary " onclick='viewreplys(<c:out value="${t.cagGistId}"></c:out>,<c:out value="${t.cagParaId}"></c:out>,<c:out value="${t.subParaUnitId}"></c:out> )'  >View /Edit /Delete Replies ${t.subParaNumber}</button> 
								<br> 	<button type="button" class="btn btn-primary " onclick='viewdocs(<c:out value="${t.cagGistId}"></c:out>,<c:out value="${t.cagParaId}"></c:out>,<c:out value="${t.subParaUnitId}"></c:out> )'  >View /Delete Documents ${t.subParaNumber}</button> 
								<br> 
							</td>	
							</c:when>	
							
							<c:when test="${(userObj.unitId!=9832 && userObj.circleId!=21614) && (userObj.unitId==4)}">
								
							<td>  <br>  	<button type="button" id="addreply"  onclick="addcagparareply(<c:out value="${t.cagGistId}"></c:out>,<c:out value="${t.cagParaId}"></c:out>,${userObj.unitId},'${t.financialYear}')" class="btn btn-success " >Add Replies ${t.subParaNumber}</button>  
								<br> <button type="button" id="adddocs"  onclick="addnewdocs(<c:out value="${t.cagGistId}"></c:out> ,<c:out value="${t.cagParaId}"></c:out>,${userObj.unitId},'${t.financialYear}')" class="btn btn-success" >Add Documents ${t.subParaNumber}</button> 
								<br> <button type="button" id="addsts"  onclick="addstatus(<c:out value="${t.cagGistId}"></c:out> ,<c:out value="${t.cagParaId}"></c:out>,${userObj.unitId},'${t.financialYear}')" class="btn btn-success" >Add Status/Remarks ${t.subParaNumber}</button> 
							<%-- <br> <button type="button" id="editsts"  onclick='editstatus(<c:out value="${t.cagGistId}"></c:out> ,<c:out value="${t.cagParaId}"></c:out>,${userObj.unitId})' class="btn btn-success" >Edit Status/Remarks</button>  --%>
									
								<br> 	<button type="button" class="btn btn-primary " onclick='viewreplys(<c:out value="${t.cagGistId}"></c:out>,<c:out value="${t.cagParaId}"></c:out>,${userObj.unitId})'  >View /Edit /Delete Replies ${t.subParaNumber}</button> 
								<br> 	<button type="button" class="btn btn-primary " onclick='viewdocs(<c:out value="${t.cagGistId}"></c:out>,<c:out value="${t.cagParaId}"></c:out>,${userObj.unitId})'  >View /Delete Documents ${t.subParaNumber}</button> 
								<br> 
							</td>	
							</c:when>	
							<c:otherwise>
							
							
							
							<td> <br>  	<button type="button" id="addreply"  onclick="addcagparareply(<c:out value="${t.cagGistId}"></c:out>,<c:out value="${t.cagParaId}"></c:out>,${userObj.unitId},'${t.financialYear}')" class="btn btn-success " >Add Replies ${t.subParaNumber}</button>  
								<br> <button type="button" id="adddocs"  onclick="addnewdocs(<c:out value="${t.cagGistId}"></c:out> ,<c:out value="${t.cagParaId}"></c:out>,${userObj.unitId},'${t.financialYear}')" class="btn btn-success" >Add Documents ${t.subParaNumber}</button> 
								<br> <button type="button" id="addsts"  onclick="addstatus(<c:out value="${t.cagGistId}"></c:out> ,<c:out value="${t.cagParaId}"></c:out>,${userObj.unitId},'${t.financialYear}')" class="btn btn-success" >Add Status/Remarks ${t.subParaNumber}</button> 
<%-- 							<br> <button type="button" id="editsts"  onclick='editstatus(<c:out value="${t.cagGistId}"></c:out> ,<c:out value="${t.cagParaId}"></c:out>,${userObj.unitId})' class="btn btn-success" >Edit Status/Remarks</button>  --%>
									
								<br> 	<button type="button" class="btn btn-primary " onclick='viewreplys(<c:out value="${t.cagGistId}"></c:out>,<c:out value="${t.cagParaId}"></c:out>,${userObj.unitId} )'  >View /Edit /Delete Replies ${t.subParaNumber}</button> 
								<br> 	<button type="button" class="btn btn-primary " onclick='viewdocs(<c:out value="${t.cagGistId}"></c:out>,<c:out value="${t.cagParaId}"></c:out>,${userObj.unitId} )'  >View /Delete Documents ${t.subParaNumber}</button> 
								<br> 
							</td>	
							
							</c:otherwise>					
							</c:choose>
							
							<td >
							<c:forEach items="${replyData}" var="m" varStatus="count">
							<c:set var="c" value="1" scope="page" />
												<c:if test="${m.cagGistId==t.cagGistId && m.cagParaId==t.cagParaId}">
												<table>
												
												<tr><td style="font-weight: bold; "> <c:out 	value="${c}"></c:out>) &emsp;  ${m.unitName} &emsp; &emsp;${m.replyDate}</td></tr>
												<br></br>
												
												
												
												</table>
												</c:if>
												 <c:set var="c" value="${c + 1}" scope="page"/>
												</c:forEach></td>		
							 <td ><b><c:out value="${t.discussPac}"></c:out></b></td>
							  <td ><b><c:out value="${t.pacincluded}"></c:out></b></td>
							 <td ><b><c:out value="${t.paraStatus}"></c:out></b></td>
								</tr>
							
								
								</c:forEach>
								</tbody>
								</table>
								</div>
				
							
									</form:form>	
									</div>
									</div>	
									
						
									
									
	<div id="view-reply" title="View-Replies" style="display:none">
		
		
		
		</div>
		<div id="view-docs" title="View-Documents" style="display:none">
		
		
		
		</div>
		
		<div id="spara_dialogue"  class="col-md-12">
 
 <c:forEach items="${parasData}" var="t" varStatus="count">
  <div class="col-md-12 pdata" id="viewdata${count.count}">
  <div class="col-md-3">
     <label class="label-control rowlebel ">Para/Sub-para<font color=red>*</font> </label>
	</div>
	 <div class="col-md-6">
       <p id="showparadata">
       <c:out value="${t.parasAction}" escapeXml="false"></c:out>
       </p>
       
       </div>
       <div class="col-md-5">
      
       </div>
       </div>
       </c:forEach>
     			

  </div>
  
  
  <div id="reply_dialog" title="Reply Data" class="col-md-12">
 <form:form id="myreplys" method="post"
				modelAttribute="cagreplys" data-parsley-validate-if-empty=""  enctype="multipart/form-data" >	
   <div class="form-group">
     <div class="col-md-6">
     <label class="label-controlPMS rowlebel "> Reply Date<font color=red>*</font> </label>
	</div>
	 <div class="col-md-6">
        <input type="text" name="replyDate" id="replyDate" class=" datepick form-control datepicker"  value=" "  readonly="readonly"   required  data-parsley-required-message="Please Enter Reply Date!"/>
       
       </div>
     				
										
    <span id="error_replyDate" class="text-danger"></span>
   </div> 
   
										 
   <div class="form-group">
   	<label class="label-control rowlebel ">Reply*</label> 
	<textarea class="ckedit form-control "  id="replyAction" name="replyAction" rows="10" cols="80" placeholder="Reply" 
	data-parsley-errors-container="#purpose-errors" data-parsley-required-message="Please Enter Reply Information!" data-parsley-group="block1" ></textarea>
    <span id="error_replyAction" class="text-danger"></span>
   </div>
    <div class="form-group">
    <label class="label-control rowlebel ">Reply Remarks</label>
<textarea class="form-control"  id="replyRemarks" name="replyRemarks"  rows="10" cols="80" placeholder="Reply Remarks" 
 ></textarea> 
    <span id="error_replyRemarks" class="text-danger"></span>
   </div>
  
   <div class="form-group" align="center">
    <input type="hidden" name="paraReplyId" id="paraReplyIdhide" />
     <input type="hidden" name="cagGistId" id="cagGistIdhide" />
      <input type="hidden" name="cagParaId" id="cagParaIdhide" />
       <input type="hidden" name="subParUunitId" id="subParaUnitIdhide" />
   
    <input type="hidden" name="replyrow_id" id="replyrow_id" />
    <button type="button" name="savereply" id="savereply" class="btn btn-info">Submit</button>
   </div>
   </form:form>
  </div>
  
  <div id="doc_dialog" title="Docs Data" class="col-md-12">
  
  <form:form  id="myFormdoc" method="POST" enctype="multipart/form-data" data-parsley-validate-if-empty="" >
   <div class="form-group">
   
     <div class="col-md-6">
     <label class="label-controlPMS rowlebel ">Document title<font color=red>*</font> </label>
	</div>
	 <div class="col-md-6">
    
        <input type="text" name="doctitle" id="doctitle" class="  form-control " required />
       
       
       </div>
       
        <div class="col-md-6">
     <label class="label-controlPMS rowlebel ">Document Date<font color=red>*</font> </label>
	</div>
	 <div class="col-md-6">
    
        <input type="text" name="docdate" id="docdate" class=" datepick form-control  datepicker" readonly="readonly" required />
       
       
       </div>
       
        <div class="col-md-12">
<div class="alert alert-info" role="alert">
				<strong style="color:#CA3F22"> Note *: Size of uploaded multiple photos together should not exceed 10mb(.jpg,.png,.pdf are allowed) </strong>
				
			
			</div>
			</div>
     				
     <div class="col-md-6">
     <label class="label-controlPMS rowlebel ">Upload multiple Docs<font color=red>*</font> </label>
	</div>
	 <div class="col-md-6">
        <input type="file" name="uploadFile" id="uploadFile" class="  form-control " multiple="multiple"   required  data-parsley-max-file-size="10240"  data-parsley-fileextension='pdf,jpg,png'   />
         <input type="hidden" name="cagGistId" id="cagGistIddochidden" class="  form-control " />
        <input type="hidden" name="cagParaId" id="cagParaIddochidden" class="  form-control "  /> 
       
        
       
       </div>
       
        
         
      
     				
										
    <span id="error_uploadFile" class="text-danger"></span>
   </div> 
  
  
   <div class="form-group" align="center">
    <input type="hidden" name="docsrow_id" id="docsrow_id" />
    <button type="button" name="savedocs" id="savedocs" class="btn btn-info">Submit</button>
   </div>
   
   </form:form>
  </div>
  
  
  <div id="status_dialog" title="status Data" class="col-md-12">
  
  <form:form id="myFormstatus" method="post"  modelAttribute="cagparasdata" >
   <div class="form-group">
   
  
     <div class="col-md-12">
        <div class="col-md-6">
       <label class="label-controlPMS rowlebel "> Select Para/ Sub Para Status<font color=red>*</font> </label>
       </div>
       
         <div class="col-md-6">
   <select class=" form-control"  name="paraStatusId"   id="statusparaStatusId"  required> 
										<option value=" ">--select--</option> 
										 <option value="20">Reply not sent by CE</option>
										<option value="7">Reply by CE to ENC</option> 
										
									<c:if test="${userObj.unitId==4|| (userObj.unitId==9832 && userObj.circleId==21614 )}">
										<option value="8">Reply by ENC to Government.</option> 
									    <option value="9">Reply by Government to AG</option>
									    <option value="10">Reply by Government to ASSEMBLY</option>
									    <option value="3">Dropped</option> 
										</c:if>
											
									
									     
										 </select>
										 </div>
										 
										 </div>
       
       
       <br>
       <div class="col-md-12"> 
        <div class="col-md-6">
     <label class="label-controlPMS rowlebel ">Remarks<font color=red>*</font> </label>
	</div>
	 <div class="col-md-6">
    
        <textarea  name="remarks" id="subremarks" class="  form-control "  rows="2" cols="8"     > </textarea>
       
        <span id="purpose-errors" class="text-danger" style="margin-bottom: 20px;color: red; text-align: center;"></span>
       </div>
       
       </div>
     				
 
     				
										

   </div> 
  
  
   <div class=" col-md-12 form-group" align="center">
   <br>
   
   <input type="hidden" name="cagGistId" id="cagGistIdstatushidden" class="  form-control " />
        <input type="hidden" name="cagParaId" id="cagParaIdstatushidden" class="  form-control "  /> 

    <button type="button" name="savestatus" id="savestatus" class="btn btn-info">Submit</button>
   </div>
   
 </form:form>
  </div>
	
</div>
</div>

								
								  
  
		
		
  



		
	
		

	

<!-- //main-content -->

 


	 
	 <script type="text/javascript" src="../js/parsley.js"></script>
	 
	  <script type="text/javascript" >
	 
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
.addMessage('en', 'fileextension', 'The file should be .pdf,.jpg,.png');



	
});
	
	</script>

 