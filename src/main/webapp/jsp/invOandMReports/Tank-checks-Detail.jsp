
<!--main code block-->
<!-- sec-section -->

<!-- create component start here -->
<%@include file="/jsp/header/taglib_includes.jsp"%>
<title>O&M Tank Checks</title>

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



<script type="text/javascript">
var tableToExcel = (function() {
  var uri = 'data:application/vnd.ms-excel;base64,'
    , template = '<html xmlns:o="urn:schemas-microsoft-com:office:office"<head><!--[if gte mso 9]><xml><x:ExcelWorkbook><x:ExcelWorksheets><x:ExcelWorksheet><x:Name>{worksheet}</x:Name><x:WorksheetOptions><x:DisplayGridlines/></x:WorksheetOptions></x:ExcelWorksheet></x:ExcelWorksheets></x:ExcelWorkbook></xml><![endif]--></head><body><table>{table}</table></body></html>'
    , base64 = function(s) { return window.btoa(unescape(encodeURIComponent(s))) }
    , format = function(s, c) { return s.replace(/{(\w+)}/g, function(m, p) { return c[p]; }) }
  return function(table, name) {
    if (!table.nodeType) table = document.getElementById(table);
    var ctx = {worksheet:  'Worksheet', table: table.innerHTML};
    window.location.href = uri + base64(format(template, ctx));
  }
})()




</script>

<script type="text/javascript">
		$(function() {
			$("#tree").treeview({
				collapsed: true,
				animated: "medium",
				control:"#sidetreecontrol",
				persist: "location"
			});
			
			


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



/* function loadForm(){
	
	
	
	

	
		
	
		  $('#casesReport').attr('action', "../webReports/abstractCounterFiles");
          $("#casesReport").submit();
         
	
	
	
	
    
} */

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

$(function() {
	
	 $( "#tabs" ).tabs();
	
	
	$("input[name='taskTypeId']").change(function(){
        var radioValue = $("input[name='taskTypeId']:checked").val();
        if(radioValue){
          //  alert("Your are a  " + radioValue);
        	$("#hiddentaskTypeId").val(radioValue);
        /* 	var page_url = $(".myunit").prop("href"); 
        	alert("page_url"+page_url);
        	$(".myunit").prop("href", page_url+'&taskTypeId='+$("#hiddentaskTypeId").val()); */
        	
        	
            
        }
    });
	
	/* var b = $("#taskTypeId").val();
	
	$("#hiddentaskTypeId").val(b); */
	
	/* $(".mycircle").click(function() {
		 var $this = $(this);      
		
		var m =$("#hiddentaskTypeId").val();
		
	      $("#taskTypeId").val(m);
	      var page_url = $this.prop("href"); 
	      alert("page_url"+page_url);
	   
		   $this.prop("href", page_url+'&taskTypeId='+m);
		  
		}); */
	
	
	/* $(".myunit").click(function() {
		 var $this = $(this);      
		
		var m =$("#hiddentaskTypeId").val();
		
	      $("#taskTypeId").val(m);
	      var page_url = $this.prop("href"); 
	      alert("page_url"+page_url);
	   
		   $this.prop("href", page_url+'&taskTypeId='+m);
		  
		}); */
	
	
	
	/* $(".mydivision").click(function() {
		 var $this = $(this);   
		 
		
		var m =$("#hiddentaskTypeId").val();
		
	      $("#taskTypeId").val(m);
	      var page_url = $this.prop("href"); 
	      alert("page_url"+page_url);
	   
		   $this.prop("href", page_url+'&taskTypeId='+m);
		   
		});
	 */
	/* $(".mysubdivision").click(function() {
		
		
		event.preventDefault();
		
		 var $this = $(this);  
		 
		
		var m =$("#hiddentaskTypeId").val();
		
	      $("#taskTypeId").val(m);
	      var page_url = $this.prop("href"); 
	      alert("page_url"+page_url);
	      
	      window.location.replace(page_url+'&taskTypeId='+m);
	   
		 //  $this.prop("href", page_url+'&taskTypeId='+m);
		   
		  
		});
	 */
	
	 $('#viewRemarks_dialogue').dialog({
		  autoOpen:false,
		  width:1200,
		  close: function() {
			  
			
				  $(this).dialog("close");
				  }
		 });
	
	
});
</script>

<script type="text/javascript">
function gettankinfo(tankId,miid,year){
	
	
$.ajax({
    type: "GET", //rest Type
    dataType: 'json', //mispelled
    url: "../invReport/Tank-Info?tankId="+tankId+"&miInpsectMst1Id="+miid,
    async: false,
    contentType: "application/json; charset=utf-8",
    success: function (msg) {
       // console.log(msg); 
    	 $('#dialog-para1').empty();
         $('#dialog-para1').append(
 		 '<div class="col-md-12 invDiv" >  <h3>Tank info  </h3></div>');            
       



 	
 	 
         $("#dialog-para1").append('<div  class="col-md-3 " style="font-weight:bold;" >  Tank Name </div> <div  class="col-md-3 " style="font-weight:bold;" > : '+msg[0].tankName +'</div><div  class="col-md-3 " style="font-weight:bold;" >   Tank Id </div> <div  class="col-md-3 " style="font-weight:bold;" > : '+msg[0].tankCode+'</div>'); 

       


         $("#dialog-para1").append('<div  class="col-md-3 " style="font-weight:bold;" >  District Name </div> <div  class="col-md-3 " style="font-weight:bold;" > : '+msg[0].districtName +'</div><div  class="col-md-3 " style="font-weight:bold;" >  Mandal Name </div> <div  class="col-md-3 " style="font-weight:bold;" > : '+msg[0].mandalName  +'</div>');



         $("#dialog-para1").append('<div  class="col-md-3 " style="font-weight:bold;" >   Village Name </div> <div  class="col-md-3 " style="font-weight:bold;" > : '+msg[0].villageName  +'</div><div  class="col-md-3 " style="font-weight:bold;" >  Unit Name </div> <div  class="col-md-3 " style="font-weight:bold;" > : '+msg[0].unitName  +'</div>');

         $("#dialog-para1").append('<div  class="col-md-3 " style="font-weight:bold;" > Circle Name  </div> <div  class="col-md-3 " style="font-weight:bold;" > : '+msg[0].circleName +'</div><div  class="col-md-3 " style="font-weight:bold;" >  Division Name </div> <div  class="col-md-3 " style="font-weight:bold;" > : '+ msg[0].divisionName  +'</div>');
         
         $("#dialog-para1").append('<div  class="col-md-3 " style="font-weight:bold;" > Sub Division Name  </div> <div  class="col-md-3 " style="font-weight:bold;" > : '+msg[0].subdivisionName +'</div><div  class="col-md-3 " style="font-weight:bold;" > Frequency  </div> <div  class="col-md-3 " style="font-weight:bold;" > : '+ msg[0].activityFrequency  +'</div>');


             
    }
}); 

$.ajax({
    type: "GET", //rest Type
    dataType: 'json', //mispelled
    url: "../invReport/embInfo?tankId="+tankId+"&miInpsectMst1Id="+miid,
    async: false,
    contentType: "application/json; charset=utf-8",
    success: function (msg2) {
      //  console.log(msg2); 
       // alert("kal"+msg2);
        
        
    	// $('#emb').empty();
    	 $('.top').empty();
    	 $('.up').empty();
    	 $('.down').empty();
      /*    $('#emb').append('<div id="main3" class="col-md-12 "> '+
 		 '<div  class="col-md-12 " style="background-color:grey; color:white; font-weight:bold; float:left;">Tank info  </div>');            
       
 */
 
 
 $(".top").append('<div  class="row col-md-12 invDiv" style="font-weight:bold;color:blue" > <div  class="col-md-2 " style="font-weight:bold;" >Inspection Name</div><div  class="col-md-2 " style="font-weight:bold;" >Inspection Date</div> <div  class="col-md-2 " style="font-weight:bold;" >  Action Required</div><div  class="col-md-2 " style="font-weight:bold;" >   Action Required Type </div> <div  class="col-md-2 " style="font-weight:bold;" >  Remarks</div><div  class="col-md-2 " style="font-weight:bold;" > Inspection Done By</div> </div>');
 
  $(".top").append(' <div class="col-md-12" style="color:maroon; "><h4><b>Bund</b></h4></div>');
 /* $(".up").append(' <div class="col-md-12" style="color:maroon; "><h4><b>Up Stream Slope</b></h4></div>');
 $(".down").append(' <div class="col-md-12" style="color:maroon; "><h4><b>Down Stream Slope</b></h4></div>');  */
 

 
 
  var tankweirid=msg2[0].tankWeirSluiceId;
 // alert("tankweirId"+tankweirid);
 if(parseInt(tankweirid)==0){
	// alert("coming here"+tankweirid);	
	 
	 $('.top').append('<div  class="col-md-12 invDiv" style="color:green ; font-weight:bold; " ><div  class="col-md-4 " ><h4></h4></div><div  class="col-md-4 "  ><h4></h4></div><div  class="col-md-4"  ><h4><button type="button" name="viewallbundReviews" id="viewallbundReviews" class="btn btn-1 btn-primary center-block allBundRemarks" onclick="getallremarks('+msg2[0].miInpsectMst1Id+','+msg2[0].tabId+','+msg2[0].tankWeirSluiceId+')"  >View All Inspection Remarks</button></h4></div> </div>')
	 
 


 
} 

 
 for(i in  msg2 ){
	 var j=parseInt(i)+1; 
	 
	
	 
	
 	
	 if(msg2[i].miCompId==2){
		 
		
	 
         $(".top").append('<div  class="row col-md-12" > <div  class="col-md-2 invDiv" style="font-weight:bold;" > '+msg2[i].miInspectTypeName+' </div> <div  class="col-md-2 " style="font-weight:bold;" >  '+msg2[i].inspectDate +'</div><div  class="col-md-2 " style="font-weight:bold;" >  '+msg2[i].actionReqName +'</div><div  class="col-md-2 " style="font-weight:bold;" >   '+msg2[i].miActionReqTypeName +' </div> <div  class="col-md-2 " style="font-weight:bold;" >  '+msg2[i].remarks+'</div>  <div  class="col-md-2 " style="font-weight:bold;" >  '+msg2[i].tankInspectApproveStatus+'</div> </div>'); 
	 }
if(msg2[i].miCompId==3){
		 
		
	 
         $(".up").append('<div  class="row col-md-12" > <div  class="col-md-2 invDiv" style="font-weight:bold;" > '+msg2[i].miInspectTypeName+' </div> <div  class="col-md-2 " style="font-weight:bold;" >  '+msg2[i].inspectDate +'</div><div  class="col-md-2 " style="font-weight:bold;" >  '+msg2[i].actionReqName +'</div><div  class="col-md-2 " style="font-weight:bold;" >   '+msg2[i].miActionReqTypeName +' </div> <div  class="col-md-2 " style="font-weight:bold;" >  '+msg2[i].remarks+'</div>  <div  class="col-md-2 " style="font-weight:bold;" >  '+msg2[i].tankInspectApproveStatus+'</div></div>'); 
	 }
if(msg2[i].miCompId==4){
	 
	

    $(".down").append('<div  class="row col-md-12" > <div  class="col-md-2 invDiv" style="font-weight:bold;" > '+msg2[i].miInspectTypeName+' </div> <div  class="col-md-2 " style="font-weight:bold;" >  '+msg2[i].inspectDate +'</div><div  class="col-md-2 " style="font-weight:bold;" >  '+msg2[i].actionReqName +'</div><div  class="col-md-2 " style="font-weight:bold;" >   '+msg2[i].miActionReqTypeName +' </div> <div  class="col-md-2 " style="font-weight:bold;" >  '+msg2[i].remarks+'</div><div  class="col-md-2 " style="font-weight:bold;" >  '+msg2[i].tankInspectApproveStatus+'</div> </div>');
    
  // $(".down").append(' <div class="row show-grid" style="color:maroon; "></div>');
}
         
  } 

         

             
    }
}); 


$.ajax({
    type: "GET", //rest Type
    dataType: 'json', //mispelled
    url: "../invReport/sluInfo?tankId="+tankId+"&miInpsectMst1Id="+miid,
    async: false,
    contentType: "application/json; charset=utf-8",
    success: function (msg2) {
      //  console.log(msg2); 
      //  alert("kal"+msg2);
        
        
    	 $('#slu').empty();
      /*    $('#emb').append('<div id="main3" class="col-md-12 "> '+
 		 '<div  class="col-md-12 " style="background-color:grey; color:white; font-weight:bold; float:left;">Tank info  </div>');            
 */       

 $('#slu').append('<div  class="row col-md-12 invDiv" style="color:Maroon; ><h3>Sluice</h3></div>')

 $("#slu").append('<div  class="row col-md-12 invDiv" style="font-weight:bold;color:blue" > <div  class="col-md-2 " style="font-weight:bold;" >Inspection Name</div><div  class="col-md-2 " style="font-weight:bold;" >Inspection Date</div> <div  class="col-md-2 " style="font-weight:bold;" >  Action Required</div><div  class="col-md-2 " style="font-weight:bold;" >   Action Required Type </div> <div  class="col-md-2 " style="font-weight:bold;" >  Remarks</div><div  class="col-md-2 " style="font-weight:bold;" >  Inspection Done By</div> </div>');
 
 var newvalue=0;
 var oldvalue=0;
 for(i in  msg2 ){
	 var j=parseInt(i)+1; 
	 
	 if(msg2[i].tankWeirSluiceId>0){
		 newvalue= msg2[i].tankWeirSluiceId;
		 if(oldvalue!=newvalue){
			// alert("oldvalue"+oldvalue);
			// alert("newvalue"+newvalue);
			 oldvalue=newvalue;
			 
			  $('#slu').append('<div  class="col-md-12 invDiv" style="color:green ; font-weight:bold; " ><div  class="col-md-6 " ><h4>Sluice Name</h4></div><div  class="col-md-6 "  ><h4>'+msg2[i].tankWeirSluiceName+'</h4></div></div>') 
			  
			  //<div  class="col-md-4 "  ><h4><button type="button" name="viewallReviews" id="viewallReviews'+j+'" class="btn btn-1 btn-primary center-block allSluRemarks"  onclick="getallremarks('+msg2[i].miInpsectMst1Id+','+msg2[i].tabId+','+msg2[i].tankWeirSluiceId+')" >View All Inspection Remarks</button></h4></div> 
			 
		 }
		
		
		 
	 }
	 

 	
	 
         $("#slu").append('<div  class="row col-md-12" > <div  class="col-md-2 invDiv" style="font-weight:bold;" > '+msg2[i].miInspectTypeName+' </div> <div  class="col-md-2 " style="font-weight:bold;" >  '+msg2[i].inspectDate +'</div><div  class="col-md-2 " style="font-weight:bold;" >  '+msg2[i].actionReqName +'</div><div  class="col-md-2 " style="font-weight:bold;" >   '+msg2[i].miActionReqTypeName +' </div> <div  class="col-md-2 " style="font-weight:bold;" >  '+msg2[i].remarks+'</div> <div  class="col-md-2 " style="font-weight:bold;" >  '+msg2[i].tankInspectApproveStatus+'</div></div>'); 

         
  } 

         

             
    }
}); 

$.ajax({
    type: "GET", //rest Type
    dataType: 'json', //mispelled
    url: "../invReport/weirInfo?tankId="+tankId+"&&miInpsectMst1Id="+miid,
    async: false,
    contentType: "application/json; charset=utf-8",
    success: function (msg2) {
       // console.log(msg2); 
      //  alert("kal"+msg2);
        
        
    	 $('.wall').empty();
    	
      /*    $('#emb').append('<div id="main3" class="col-md-12 "> '+
 		 '<div  class="col-md-12 " style="background-color:grey; color:white; font-weight:bold; float:left;">Tank info  </div>');            
       
 */
 $(".wall").append('<div  class="row col-md-12 invDiv" style="font-weight:bold;color:blue" > <div  class="col-md-2 " style="font-weight:bold;" >Inspection Name</div><div  class="col-md-2 " style="font-weight:bold;" >Inspection Date</div> <div  class="col-md-2 " style="font-weight:bold;" >  Action Required</div><div  class="col-md-2 " style="font-weight:bold;" >   Action Required Type </div> <div  class="col-md-2 " style="font-weight:bold;" >  Remarks</div> <div  class="col-md-2 " style="font-weight:bold;" >  Inspection Done By</div> </div>');
/*  $(".wall").append(' <div class="col-md-12" style="color:maroon; "><h3><b>Body Wall</b></h3></div>'); */
 
 var newweirvalue=0;
 var oldweirvalue=0;
 for(i in  msg2 ){
	 var j=parseInt(i)+1; 
	 
	 
	 
	 if(msg2[i].tankWeirSluiceId>0){
		 newweirvalue= msg2[i].tankWeirSluiceId;
		 if(oldweirvalue!=newweirvalue){
			// alert("oldvalue"+oldvalue);
			// alert("newvalue"+newvalue);
			 oldweirvalue=newweirvalue;
			 
			 $('.wall').append('<div  class="col-md-12 invDiv" style="color:green ; font-weight:bold; " ><div  class="col-md-6 " ><h4>Weir Name</h4></div><div  class="col-md-6 "  ><h4>'+msg2[i].tankWeirSluiceName+'</h4></div> </div>')
			 
			// <div  class="col-md-4 "  ><h4><button type="button" name="viewallweirReviews" id="viewallweirReviews'+j+'" class="btn btn-1 btn-primary center-block allWeirRemarks" onclick="getallremarks('+msg2[i].miInpsectMst1Id+','+msg2[i].tabId+','+msg2[i].tankWeirSluiceId+')"  >View All Inspection Remarks</button></h4></div>
			 
		 }
		
		
		 
	 }
 	
	 
         $(".wall").append('<div  class="row col-md-12" > <div  class="col-md-2 invDiv" style="font-weight:bold;" > '+msg2[i].miInspectTypeName+' </div> <div  class="col-md-2 " style="font-weight:bold;" >  '+msg2[i].inspectDate +'</div><div  class="col-md-2 " style="font-weight:bold;" >  '+msg2[i].actionReqName +'</div><div  class="col-md-2 " style="font-weight:bold;" >   '+msg2[i].miActionReqTypeName +' </div> <div  class="col-md-2 " style="font-weight:bold;" >  '+msg2[i].remarks+'</div> <div  class="col-md-2 " style="font-weight:bold;" >  '+msg2[i].tankInspectApproveStatus+'</div> </div>'); 

         
  } 

         

             
    }
}); 



//alert(year+tankId+freq);
$("#thead5").empty();
$("#tbody5").empty();


$.ajax({	          
      url: "../invReport/Tank-repairs?tankId="+tankId+"&year="+year,
      type: "GET",
      contentType: "application/json; charset=utf-8",
      success: function (msg) {
    	  
    	//console.log("repairdata"+msg);
    	  if(msg!=null){
    	  var obj = JSON.parse(msg);
    	  
    	  var j=1;
    	  
    	
    	    $('#dialog-para3 table thead').append(  '<tr style="font-size: 18px">'+
    	    		'<th style="color: blue">District</th><th style="color: red">'+obj[0].districtName+'</th>'+
    	    		'<th style="color: blue">Mandal</th><th style="color: red">'+obj[0].mandalName+' </th>'+
    	    		'<th style="color: blue">Village</th><th style="color: red">'+obj[0].villageName+'</th>'+
    	    		'<th style="color: blue">Tank Name</th><th style="color: red">'+obj[0].tankName+'</th></tr>'+
    	    		'<tr style="font-size: 18px; color: gray; font-weight: bold;"><th>Sl.No</th>'+
    	    		' <th>ComponentName </th>'+
    	    		'<th>Rate</th>'+
    	    		'<th>Quantity</th>	'+
    	    		' <th>Amount</th>'+
    	    		'<th>Units</th>'+
    	    		' <th>StartDate-EndDate</th>'+
    	    		' <th>Scheme Taken</th>'+
    	    		' <th>Description of Repair</th>'+
    	    		'</tr>'); 	  
    	    
    	    for(i in obj){
    	    	
    	    	   $('#dialog-para3 table tbody').append(  '<tr style="font-size: 16px">' +
    	    			                                '<td style="text-align: center;">'+j+'</td>' +
    	    			                                '<td><b>'+obj[i].miCompName+'</b></td>' +
    	    			                                '<td><b>'+obj[i].rate+'</b></td>' +
    	    			                                '<td><b>'+obj[i].quantity+'</b></td>' +
    	    			                                '<td><b>'+obj[i].amount+'</b></td>' +
    	    			                                '<td><b>'+obj[i].unitMeasureName+'</b></td>' +	    	    			                               
    	    			                                '<td><b>'+obj[i].repairStartDate+'-'+obj[i].repairEndDate+'</b></td>'+
    	    			                                '<td><b>'+obj[i].schemeTaken+'</b></td>' +
    	    			                                '<td><b>'+obj[i].repairDescription+'</b><input  value="'+obj[i].ommirepairId+'" name="mitankRepairsId" id="dbrepairId'+j+'" class="dbrepairId" type="hidden" /> </td>' +
    	    			                                
    	    			                                '</tr>');
    	    	   
    	    	   
    	    	  
    	    	   
    	    	   j++;
    	    }
    	    
    	  
	    	  
	    	  
	    	  
    	   
    	
    	  } 
    	    
    	
    	

      },
      error : function(){
    	  alert(error);
      }
  });


$("#thead6").empty();
$("#tbody6").empty();


$.ajax({	          
    url: "../invtsimis/getMiCapacity?tankId="+tankId,
    type: "GET",
    contentType: "application/json; charset=utf-8",
    success: function (msg) {
  	  
  	// console.log(msg);
  	 if(msg!=null){ 
  	  var obj = JSON.parse(msg);
  	  
  	  var j=1;
  	  
  	
  	    $('#dialog-para4 table thead').append(  '<tr style="font-size: 18px">'+
  	    		'<th style="color: blue">District</th><th style="color: red">'+obj[0].districtName+'</th>'+
  	    		'<th style="color: blue">Mandal</th><th style="color: red">'+obj[0].mandalName+' </th>'+
  	    		'<th style="color: blue">Village</th><th style="color: red">'+obj[0].villageName+'</th>'+
  	    		'<th style="color: blue">Tank Name</th><th style="color: red">'+obj[0].tankName+'</th></tr>'+
  	    		'<tr style="font-size: 18px; color: gray; font-weight: bold;"><th>Sl.No</th>'+
  	    		' <th>Gross Capacity </th>'+
  	    		'<th>Available Capacity</th>'+
  	    		'<th>Tank Level</th>'+
  	    		'<th>Inflow</th>'+
  	    		'<th>Outflow</th>'+
  	    		'<th>Ayacut</th>'+
  	    	
  	    		'  <th>Surplus</th>'+
  	    		' <th>Inspect Date</th>'+
  	    		'</tr>'); 	  
  	    
  	    for(i in obj){
  	    	
  	    	   $('#dialog-para4 table tbody').append(  '<tr style="font-size: 16px">' +
  	    			                                '<td style="text-align: center;">'+j+'</td>' +
  	    			                                '<td><b>'+obj[i].grossCapacity+'</b></td>' +
  	    			                                '<td><b>'+obj[i].availableCapacity+'</b></td>' +
  	    			                                '<td><b>'+obj[i].tankLevel+'</b></td>' +
  	    			                                '<td><b>'+obj[i].inflow+'</b></td>' +
  	    			                                '<td><b>'+obj[i].outfow+'</b></td>' +
  	    			                                '<td><b>'+obj[i].ayacut+'</b></td>' +
  	    			                             
  	    			                                
  	    			                                '<td><b>'+obj[i].surplus+'</b></td>' +
  	    			                                '<td><b>'+obj[i].inspectDate+'</b><input  value="'+obj[i].ommicapacityId+'" name="mitankCapacityId" id="dbcapacityId'+j+'" class="dbcapacityId" type="hidden" /> </td>' +
  	    			                                	    	    			                               
  	    			                                
  	    			                                '</tr>');
  	    	   
  	    	   
  	    	  
  	    	   
  	    	   j++;
  	    }
  	    
  	   
	    	 
	    	  
	    	  
  	   
  	 }
    },
    error : function(){
  	  alert(error);
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
	        "close Tanks Info": function() {
	            $(this).dialog("close");
	        }
	    },
	    open: function() {
	     //   $('#infotabs').tabs( );
	        //intabs function 
	        /*  create: function(e, ui) {
                $('#closeBtn').click(function() {
                    $('#dialog-para').dialog('close');
                });
            } */
	      // $(this).parent().children('.ui-dialog-titlebar').remove();
	    }
	});

}

function getallremarks(mst1Id,tabId,sluiceId){
	 $('#viewRemarks_dialogue').dialog('option', 'title', 'View All Inspection Remarks');
	  $('#viewRemarks_dialogue').dialog('open');
	  
	  $('#viewremarksid').trigger("reset"); 
	  
	  $("#viewhead1").empty();
		$("#viewbody1").empty();
		
	    var sluiceId=sluiceId;
	

	$.ajax({
	    type: "GET", //rest Type
	    dataType: 'json', //mispelled
	    url: "../invtsimis/get-mst1-remarks-bysluiceid",
	    async: false,
	    data: {
			  
			miInpsectMst1Id:mst1Id,
			tabId:tabId
			
			  
		},
	    contentType: "application/json; charset=utf-8",
	    success: function (obj) {
	      //  console.log(obj); 
	       // alert("kal"+obj);
	        
	        var j=1;
	    	  
	    	//alert("kalhere");
	    	    $('#viewmst1data table thead').append( '<tr style="font-size: 18px; color: gray; font-weight: bold;"><th>Sl.No</th>'+
	    	    		' <th>Submitted By </th>'+
	    	    		'<th>Remarks</th>'+
	    	    	
	    	    		'  <th>Latest</th>'+
	    	    		
	    	    		'  <th>Submitted To</th>'+
	    	    		
	    	    		'  <th>Remarks for</th>'+
	    	    		
	    	    		'</tr>'); 	  
	    	    
	    	    for(i in obj){
	    	    	
	    	    	var k=obj[i].tabId;
	    	    
	    	    /* 	if(sluiceId==obj[i].tankWeirSluiceId){ */
	    	    	   $('#viewmst1data table tbody').append(  '<tr style="font-size: 16px">' +
	    	    			                                '<td style="text-align: center;">'+j+'</td>' +
	    	    			                                '<td><b>'+obj[i].remarksSubmittedBy+'</b></td>' +
	    	    			                                '<td><b>'+obj[i].remarks+'</b></td>' +
	    	    			                             
	    	    			                                '<td><b>'+obj[i].latestRemarks+'</b></td>' +
	    	    			                                
	    	    			                                '<td><b>'+obj[i].submittedToEmpName+'</b></td>' +
	    	    			                                
	    	    			                             (k==1? '<td><b>Bund Remarks</b></td>': '')+
	    	    			                             (k==2? '<td><b>'+obj[i].tankWeirSluiceName+'</b></td>': '')+
	    	    			                             (k==3? '<td><b>'+obj[i].tankWeirSluiceName+'</b></td>': '')+
	    	    			                               
	    	    			                                	    	    			                               
	    	    			                             
	    	    			                                '</tr>');
	    	    	   
	    	    	   
	    	    	/* } */
	    	    	   
	    	    	  
	    	    	 
	    	    	   
	    	    	   j++;
	    	    	   
	    	    
	    	    }
	    	
	    	 
		
		 
	       //  $(".wall").append('+msg2[i].miInspectTypeName+'); 

	         
	  } 

	         

	             
	    
	}); 

	
	
	
}


       
    </script>

<script>
function gettaskunitList(unitId)
{
	
	var m =$("#hiddentaskTypeId").val();
	//alert("minscript"+m);
	
	$("#unitId").val(unitId);
$("#taskTypeId").val(m);

   var page_url="../task/taskreport2?unitId="+unitId+"& taskTypeId="+m;
     window.location.assign(page_url);

     
     $("#myunit").attr('href',page_url);

	/*  document.forms[0].urlvalue.value="../task/taskreport2";
	
	   $("#unitId").val(unitId);
	   $("#taskTypeId").val(m);
	  
	
		 document.forms[0].submit(); 
		 return false;
		  */
		
		 
		   /*   document.forms.casesReport.action="../task/taskreport2?unitId="+unitId+"& taskTypeId="+m; */
		 /* document.forms.casesReport.submit();  */
	
	
	
	
	}
function gettaskcircleList(unitId,circleId)
{
	
	var m =$("#hiddentaskTypeId").val();
	document.forms[0].urlvalue.value="../task/taskreport2";
	
	   $("#unitId").val(unitId);
	   $("#circleId").val(circleId);
	   $("#taskTypeId").val(m);
	
		 document.forms[0].submit(); 
	
	
	
	}
function gettaskdivisionList(unitId,circleId,divisionId)
{
	
	var m =$("#hiddentaskTypeId").val();
	document.forms[0].urlvalue.value="../task/taskreport2";
	
	   $("#unitId").val(unitId);
	   $("#circleId").val(circleId);
	   $("#divisionId").val(divisionId);
	   $("#taskTypeId").val(m);
	
		 document.forms[0].submit(); 
	
	
	
	
	}
function gettasksubdivisionList(unitId,circleId,divisionId,subdivisionId)
{
	
	var m =$("#hiddentaskTypeId").val();
	document.forms[0].urlvalue.value="../task/taskreport2";
	
	   $("#unitId").val(unitId);
	   $("#circleId").val(circleId);
	   $("#divisionId").val(divisionId);
	   $("#subdivisionId").val(subdivisionId);
	   $("#taskTypeId").val(m);
	
		 document.forms[0].submit(); 
	
	
	
	}
</script>

<div class="col-md-9">
	

	

	<div>

		<%-- <c:if test="${userObj!=null}">
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
		</c:if> --%>



<!-- <div class="w3l-main" id="borderStyle"> -->

	<form:form id="casesReport" method="post" modelAttribute="taskreport2">

		<input name=urlvalue type=hidden>
		<input name=unitId id="unitId" type=hidden>
		<input name=circleId id="circleId" type=hidden>
		<input name=divisionId id="divisionId" type=hidden>
		<input name=subdivisionId id="subdivisionId" type=hidden>
		
	


<%-- <c:if test="${selectedunitId!=null && selectedabstract==true }">
<div align="center">
		
		<h1><a target="_blank" href="../parasreport/downloadabstarctviewPDF?unitId=${selectedunitId} &sectionId=${selectedsectionId} &paraStatusId=${selectedParaStatusId} &transferFlag=${selectedTransferFlag}">Download PDF Document</a></h1>
	</div>
</c:if>

<c:if test="${selectedunitId==null && selectedabstract==true}">
<div align="center">
		
		<h1><a target="_blank" href="../parasreport/downloadabstarctviewPDF?sectionId=${selectedsectionId} &paraStatusId=${selectedParaStatusId} &transferFlag=${selectedTransferFlag}">Download PDF Document</a></h1>
	</div>
</c:if>

<c:if test="${selectedunit!=null && selectedabs==false}">
<div align="center">
		
		<h1><a target="_blank" href="../parasreport/downloadabstarctofficeviewPDF?unitId=${selectedunit} &sectionId=${selectedSectionId} &paraStatusId=${selectedParaStatusId} &transferFlag=${selectedTransferFlag} &circleId=${selectedCircleId} &divisionId=${selectedDivisionId}&circleTotal=${selectedcircleTotal}&unitTotal=${selectedunitTotal}">Download PDF Document</a></h1>
	</div>
</c:if> --%>



		<div class="panel panel-primary  " >
			<div class="panel-heading">
				<h3 class="panel-title">O&M of Irrigation Tanks:Tank Abstract Detail</h3>
			</div>

			




				<div class="panel-body">


		
<div class="alert alert-info" role="alert">
 <strong>Note : Please Use A4(landscape) Size Paper for Print. Also Selected Data Can be Exported and Printed</strong>
</div>





				

	
 <c:if test="${miTankdetail!=null}"> 	



					<div
						class="show-grid gridList mainprint pagecontent"
						>


						<div class="table-responsive" id="printarea">

							<table class="display table-bordered table1" style="width:100%" id="capacitytable">
								<thead >
									
									<tr style=" font-size: 18px" >
										<th  style="text-align: center;">Sl.No</th>
										<th  style="text-align: center;">Year</th>
										<th   style="text-align: center;">Frequency</th>										
										<th   style="text-align: center;">District Name</th>
										<th style="text-align: center;" >Unit Name</th>
										<th   style="text-align: center;">Circle Name</th>	
															
										
										<th  style="text-align: center;">Division Name</th>
									
										<th style="text-align: center;">Sub Division Name</th>
										<th  style="text-align: center;">Tank Name</th>									
									
									</tr>
									
									

									

								</thead>


								<tbody>
									
										<c:forEach items="${miTankdetail}" var="t" varStatus="count">
										<%--   <c:if test="${t.unitId>0&&t.circleId<=0&&t.divisionId<=0}">	 --%>
											<tr>

												<td style="text-align: center;"><c:out
														value="${count.count}"></c:out></td>
											  
												<td><b><c:out value="${t.year}"></c:out></b></td>
												
												
											
												
												
												<td><c:out value="${t.activityFrequency}"></c:out></td>
												<td><c:out value="${t.districtName}"></c:out></td>
												<td><c:out value="${t.unitName}"></c:out></td>
											
											
												<td><c:out value="${t.circleName}"></c:out></td>
																						
												
											
												
												
											
												
												
												<td><c:out value="${t.divisionName}"></c:out></td>
												
												<td><c:out value="${t.subdivisionName}"></c:out></td>
												
												<td><a href="javascript:void(null);" onclick="gettankinfo(${t.tankId},${t.miInpsectMst1Id},${t.year});"><c:out value="${t.tankName}"></c:out></a></td>
																							
												
												
												
											
												
												
												
												
												
										</tr>
										
									
										
									
										</c:forEach>
									


								
									
									
								</tbody>


							</table>
							
							
							
							
							
								
							


						</div>
				
					

					</div>
					
					
					 	</c:if> 	
					 	
					 	
					 	 <c:if test="${miTankUnitdetail!=null}"> 	
					
									<div
						class="show-grid gridList mainprint pagecontent"
						>



						<div class="table-responsive" id="printarea">

							<table class=" display table-bordered table1 " style="width:100%" id="table1">
								<thead >
									
									<tr style=" font-size: 18px" >
										<th  style="text-align: center;">Sl.No</th>
										<th  style="text-align: center;">Year</th>
										<th   style="text-align: center;">Frequency</th>										
										<th   style="text-align: center;">District Name</th>
										<th style="text-align: center;" >Unit Name</th>
										<th   style="text-align: center;">Circle Name</th>	
															
										
										<th  style="text-align: center;">Division Name</th>
									
										<th style="text-align: center;">Sub Division Name</th>
										<th  style="text-align: center;">Tank Name</th>									
									
									</tr>
									
									

									

								</thead>


								<tbody>
									
										<c:forEach items="${miTankUnitdetail}" var="t" varStatus="count">
										<%--   <c:if test="${t.unitId>0&&t.circleId<=0&&t.divisionId<=0}">	 --%>
											<tr>

												<td style="text-align: center;"><c:out
														value="${count.count}"></c:out></td>
											  
												<td><b><c:out value="${t.year}"></c:out></b></td>
												
												
											
												
												
												<td><c:out value="${t.activityFrequency}"></c:out></td>
												<td><c:out value="${t.districtName}"></c:out></td>
												<td><c:out value="${t.unitName}"></c:out></td>
											
											
												<td><c:out value="${t.circleName}"></c:out></td>
																						
												
											
												
												
											
												
												
												<td><c:out value="${t.divisionName}"></c:out></td>
												
												<td><c:out value="${t.subdivisionName}"></c:out></td>
												
												<td><a href="javascript:void(null);" onclick="gettankinfo(${t.tankId},${t.miInpsectMst1Id},${t.year});"><c:out value="${t.tankName}"></c:out></a></td>
																							
												
												
												
											
												
												
												
												
												
										</tr>
										
									
										
									
										</c:forEach>
									


								
									
									
								</tbody>


							</table>
							
							
							
							
							
								
							


						</div>
					
					

					</div>
					
						</c:if> 
						
						 <c:if test="${miTankcapayacutdetail!=null}"> 	
					
									<div
						class="show-grid gridList mainprint pagecontent"
						>



						<div class="table-responsive" id="printarea">

							<table class=" display table-bordered table1 " style="width:100%" id="table1">
								<thead >
									
									<tr style=" font-size: 18px" >
										<th  style="text-align: center;">Sl.No</th>
																			
										
										<th style="text-align: center;" >Unit Name</th>
										<th   style="text-align: center;">Circle Name</th>	
															
										
										<th  style="text-align: center;">Division Name</th>
									
										<th style="text-align: center;">Sub Division Name</th>
										<th  style="text-align: center;">Tank Name</th>	
											<th  style="text-align: center;">Total Ayacut (acres)</th>	
											<th  style="text-align: center;">Cultivated Ayacut (acres)</th>	
											<th  style="text-align: center;">Gross Capacity (mcft)</th>
											<th  style="text-align: center;">Available Capacity (mcft)</th>								
									
									</tr>
									
									

									

								</thead>


								<tbody>
									
										<c:forEach items="${miTankcapayacutdetail}" var="t" varStatus="count">
										<%--   <c:if test="${t.unitId>0&&t.circleId<=0&&t.divisionId<=0}">	 --%>
											<tr>

												<td style="text-align: center;"><c:out
														value="${count.count}"></c:out></td>
											  
											
												<td style="color: blue;"><c:out value="${t.unitName}"></c:out></td>
											
											
												<td><c:out value="${t.circleName}"></c:out></td>
																						
												
											
												
												
											
												
												
												<td><c:out value="${t.divisionName}"></c:out></td>
												
												<td><c:out value="${t.subdivisionName}"></c:out></td>
												
												<td style="color: blue;"><c:out value="${t.tankName}"></c:out></td>
												<td style="color: red;"><c:out value="${t.grossAyacut}"></c:out></td>
												<td style="color: green;"><c:out value="${t.ayacut}"></c:out></td>
												<td style="color: red;"><c:out value="${t.grossCapacity}"></c:out></td>
												<td style="color: green;"><c:out value="${t.availableCapacity}"></c:out></td>
																							
												
												
												
											
												
												
												
												
												
										</tr>
										
									
										
									
										</c:forEach>
									


								
									
									
								</tbody>


							</table>
							
							
							
							
							
								
							


						</div>
					
					

					</div>
					
						</c:if> 
						



				</div>
				
				
			
		</div>
		
	



	


		<div class="row show-grid">
			<div class="clearfix"></div>
			<div class="clearfix"></div>
			<div class="col-md-4"></div>
			<!-- <div class="col-md-4">
						<input type="button" class="btn btn-1 btn-primary center-block"
							id="getCasesId" value="Excel Export" onclick="tableToExcel('table1', 'countertable')" >
					</div>
 -->
			<!-- <div class="col-md-2">
				<input type="button" value="Print Preview"
					class="btn btn-1 btn-primary center-block"
					onclick="PrintPreview('printarea')" />
			</div>
			<div class="col-md-2">
				<input type="button" class="btn btn-1 btn-primary center-block"
					id="getCasesId" value="Print" onclick="printDiv('printarea')">
			</div>
 -->

		</div>

	</form:form>
<!-- </div> -->
<!-- //main-content -->
</div>
</div>


	<div id="dialog-para"  style="display:none">
	
		<div class="panel panel-primary" >
			<div class="panel-heading">
				<h3 class="panel-title">Irrigation Tanks: Irrigation Tanks Abstract Detail</h3>
			</div>
<div class="panel-body">
	
	
		<div id="tabs">
				<ul class="left-tabs"> 
						 <li><a href="#tii" >TANK INSPECTION INFO</a></li>
						
						   <li><a href="#rh" >TANK REPAIR HISTORY</a></li>						   
						     <li><a href="#cp" >TANK CAPACITY</a></li>
						     <!--   <li><a href="#feed" >TANK FEED DETAILS</a></li> -->
						</ul> <!-- tabs -->
	
	<div class="left-content" >	
						 	<div id="tii" >
		<div class="invDiv" id="dialog-para1"> </div>
		<div class="invDiv" id="dialog-para2">
		
		
   
    <div id="emb" style="font-weight:bold;color:black;" class="invDiv"><h3 style="color:maroon;"><b>Condition of Bund Top, Upstream Slope, Down Stream Slope , Revetment, Sluice and Weirs. </b></h3>
     <div class="top">
     </div>
      <div class="up">
      </div>
       <div class="down">
       </div>
    
    </div>
    <div id="slu" class="invDiv" style="font-weight:bold;color:Black"> <h3> Sluice </h3> 
      
    </div>
     <div id="weir" class="invDiv" style="font-weight:bold;color:Maroon" ><h3>Weirs</h3>
      <div class="wall" >
      </div>
 
</div> 
</div>
</div>

	<div id="rh" ><div  id="dialog-para3">
	
								<div class="show-grid gridList mainprint pagecontent"
									style="display: block">
									<div class="table-responsive" id="printarea">
										<table class="display table-bordered table1" style="width: 100%"
											id="table5">
											<thead id="thead5">

											</thead>


											<tbody id="tbody5">


											</tbody>
										</table>

									</div>

								</div>
							</div>
	   </div>
	<div id="cp" ><div  id="dialog-para4"> 
	<div class="show-grid gridList mainprint pagecontent"
									style="display: block">
									<div class="table-responsive" id="printarea">
										<table class="display table-bordered table1" style="width: 100%"
											id="table6">
											<thead id="thead6">

											</thead>


											<tbody id="tbody6">


											</tbody>
										</table>

									</div>

								</div></div>  </div>
</div>
</div>
</div>
</div>
	
		</div>
		
		<div id="viewRemarks_dialogue">

	<form:form id="viewremarksid" method="post" modelAttribute="weir"
		name="weirform" data-parsley-validate-if-empty=""
		enctype="multipart/form-data">



<div id="viewmst1data">
								<div class="show-grid gridList mainprint pagecontent"
									style="display: block">
									<div class="table-responsive" id="printarea">
										<table class=" display table-bordered" style="width: 100%"
											id="view1">
											<thead id="viewhead1">

											</thead>


											<tbody id="viewbody1">

											</tbody>
										</table>
									</div>


								</div>
							</div>
							

							
	
	
		
		


		

	</form:form>

</div>

















<script src="../js/Html5DataTable/jquery.dataTables.min.js" type="text/javascript"></script>	
	<script src=" ../js/Html5DataTable/dataTables.buttons.min.js" type="text/javascript"></script>	
	<script src=" ../js/Html5DataTable/jszip.min.js" type="text/javascript"></script>	
	<script src="../js/Html5DataTable/pdfmake.min.js" type="text/javascript"></script>	
	<script src=" ../js/Html5DataTable/vfs_fonts.js" type="text/javascript"></script>	
	<script src="../js/Html5DataTable/buttons.html5.min.js" type="text/javascript"></script>
	<script src="../js/Html5DataTable/buttons.print.min.js" type="text/javascript"></script>
	<script src="../js/Html5DataTable/dataTables.select.min.js" type="text/javascript"></script>
	
	<script type="text/javascript">			
							
    $('.table1').DataTable( {
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
                sheetName: 'Exported Paras data',
                text:  'Save To Excel',
                className: 'btn btn-1 btn-primary ',
                messageTop: 'Tank Abstract Detail'
                
                
            },
            
             {
                extend: 'pdfHtml5',
                className: 'btn btn-1 btn-primary ',
                text:  'PDF View / Download',
                orientation: 'landscape',
                pageSize: 'A4',
                download: 'open',
            
               
                filename: 'Tank_Abstract_Detail',
                exportOptions: {
					columns: ':visible',
					search: 'applied',
					order: 'applied'
				},
				
               
                title: 'Tank Abstract Detail',
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
							

<!-- //main-content -->
