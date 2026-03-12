<%@include file="/jsp/header/taglib_includes.jsp"%> 

<!-- <script type="text/javascript" src="../js/chart/Chart.min.js" ></script>
<script type="text/javascript" src="../js/chart/Chart.bundle.min.js" ></script>
<script type="text/javascript" src="../js/chart/utils.js" ></script>
<link rel="stylesheet" media="screen" href="../css/chart/Chart.min.css" >  -->


<div class="col-md-9">       
		 


		<div >
			 

				<!--   panel start here -->
				<div class="panel panel-primary">
					<div class="panel-heading">
						<h3 class="panel-title" style="color:#fff" >Welcome to     <c:if test="${userObj!=null}">	
						
					 <c:if test="${userObj.employeeName!=null && userObj.employeeName!='NA'  }">	
						   
			Er. <c:out value="${userObj.employeeName}"></c:out>	
			 
			 </c:if>
			 
			 <c:if test="${userObj.designationName!=null && userObj.designationName!='NA'  }">	
						   
			, <c:out value="${userObj.designationName}"></c:out>	
			 
			 </c:if>
			 <br></br>
						
						  <c:if test="${userObj.unitId!=0 && userObj.circleId==0 && userObj.divisionId==0 && userObj.subdivisionId==0 }">	
						   <c:if test="${userObj.unitId>0  }">	
			 <c:if test="${userObj.userName!='icad_test'  &&  userObj.userName != 'cs_telangana'  }">	 <c:out value="${userObj.unitName}"></c:out></c:if>
			   <c:if test="${userObj.userName=='icad_test'  }">	 AG AUDIT</c:if>
			   <c:if test="${userObj.userName=='cs_telangana'  }">	 CS Telangana</c:if>
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
	</c:if></h3>
					</div>
					<div class="panel-body">
				
					<div class="row show-grid">
					
					
			
  </div>
  
  <div class="row show-grid">
			
  </div>

						<!--   table starts here -->
						<div class="table-responsive">
							<table class="table table-bordered table-striped">
								<colgroup>
									<col class="col-xs-2">
									<col class="col-xs-3">
								</colgroup>

								<tbody>
									<%-- <tr>
										<th scope="row"><code><c:if test="${userObj!=null}">
	
			<c:out value="${userObj.userName}"></c:out>
		
	</c:if></code></th>
										<td>user info</td>
									</tr>
									<tr>
										<th scope="row"><code>user name</code></th>
										<td>user info</td>
									</tr>
									<tr>
										<th scope="row"><code>user name</code></th>
										<td>user info</td>
									</tr>

 --%>
								</tbody>
							</table>
						</div>
						<!-- table ends here -->
					</div>
				</div>
				<!--  panel ends here -->

			 
			<!-- /.col-sm-4 -->


		</div>
		<!-- row -->
		 
	 
</div>


<!-- container --> <!-- </div> -->
<style>
.ct-series-a .ct-bar {
  /* Set the colour of this series line */
  stroke: red;
  /* Control the thikness of your lines */
  stroke-width: 20px;
  /* Create a dashed line with a pattern */
  /* stroke-dasharray: 10px 20px; */
}
.ct-series-b .ct-bar {
  /* Set the colour of this series line */
  stroke: green;
  /* Control the thikness of your lines */
  stroke-width: 20px;
  /* Create a dashed line with a pattern */
  /* stroke-dasharray: 10px 20px; */
}
.ct-series-c .ct-bar {
  /* Set the colour of this series line */
  stroke: orange;
  /* Control the thikness of your lines */
  stroke-width: 20px;
  /* Create a dashed line with a pattern */
  /* stroke-dasharray: 10px 20px; */
}

      .ct-label {
    font-size: 12px;
    color: black;
    font-weight: bold;
}
</style>

<script type="text/javascript">
	$(function() {
		var data={
				  labels: ['PRE MONSOON', 'POST MONSOON', 'DURING MONSOON'],
				  series: [
				      [{meta: 'Tanks Count', value: 10000 },
				       {meta: 'Tanks Count', value: 20000 }, 
				       {meta: 'Tanks Count', value: 26000}],
				      [{meta: 'res Count', value: 40000}, 
				       {meta: 'description', value: 2500}, 
				       {meta: 'description', value: 2500}],
				       [{meta: 'description', value: 8000}, 
				        {meta: 'description', value: 30000}, 
				        {meta: 'description', value: 17000}]
				  ]
				};
		
		  var options = {
				  seriesBarDistance: 10,
				  axisX: {
					 
					    offset: 30,
					      
				  },
				  axisY: {
					  type: Chartist.AutoScaleAxis,
					    showGrid:true,
					    offset: 80,
					    scaleMinSpace: 15
 
				    },
				  
				  
				};
		  
		  var responsiveOptions = [
	                                  ['screen and (min-width: 300px)', {
	  		    seriesBarDistance: 10,
	  		    axisX: {
	  		      labelInterpolationFnc: function(value) {
	  		        return value.slice(0, 3);
	  		      }
	  		    }
	  		  }],
	  		  // Over 600px, we increase the bar distance one more time and show the full weekdays
	  		  ['screen and (min-width: 600px)', {
	  		    seriesBarDistance: 15,
	  		    axisX: {
	  		      labelInterpolationFnc: function(value) { return value; }
	  		    }
	  		  }],
	  		 ['screen and (min-width: 1200px)', {
	   		    seriesBarDistance: 15,
	   		    axisX: {
	   		      labelInterpolationFnc: function(value) { return value; }
	   		    }
	   		  }],
	   		 ['screen and (min-width: 768px) and (max-width: 991px)', {
	    		    seriesBarDistance: 15,
	    		    axisX: {
	    		      labelInterpolationFnc: function(value) { return value; }
	    		    }
	    		  }],
	    		  ['screen and (min-width: 992px) and (max-width: 1199px) ', {
	      		    seriesBarDistance: 15,
	      		    axisX: {
	      		      labelInterpolationFnc: function(value) { return value; }
	      		    }
	      		  }]
	                               ];
		  
	
		  
var chart1=new Chartist.Bar('#ct-chart1', data, options,responsiveOptions ,{
	  low: 0,
	    showPoint: true,
	  showArea: true,
	  lineSmooth: Chartist.Interpolation.cardinal({
	    divisor: 3
	  }),
	    
	    plugins: [
	    Chartist.plugins.tooltip({
	        appendToBody: true,
	        pointClass: 'my-cool-point'
	      })
	  ]});
var chart2=new Chartist.Bar('#ct-chart2', data, options,responsiveOptions);
var chart3=new Chartist.Bar('#ct-chart3', data, options,responsiveOptions);
var chart4=new Chartist.Bar('#ct-chart4', data, options,responsiveOptions);







//var $tooltip2 = $('<div class="tooltip tooltip-hidden"></div>').appendTo($('#ct-chart2'));
//var $tooltip3 = $('<div class="tooltip tooltip-hidden"></div>').appendTo($('#ct-chart3'));
//var $tooltip4 = $('<div class="tooltip tooltip-hidden"></div>').appendTo($('#ct-chart4'));
// var id=$('.ct-chart').attr('id');
  
//  alert("id"+id);

 var $tooltip = $('<div class="tooltip tooltip-hidden"></div>').appendTo($('#ct-chart1'));

$(document).on('mouseenter', '.ct-bar', function() {
  var seriesDesc = $(this).attr('ct:meta'),
      value = $(this).attr('ct:value');
  
 
  $tooltip.text(value + " --" + seriesDesc);
  // $tooltip.css({
  //   left: $(this).attr('x2') - 1,
  //   top: $(this).attr('y2') - $tooltip.height() + 20
  // });
  $tooltip.removeClass('tooltip-hidden');
});

$(document).on('mouseleave', '.ct-bar', function() {
  $tooltip.addClass('tooltip-hidden');
});

$(document).on('mousemove', '.ct-bar', function(event) {
  $tooltip.css({
    left: event.offsetX + 5,
    top: event.offsetY - $tooltip.height() - 30
  });
});








//var barWidthMain = 14;
//var barWidth = 7;
//var seriesBarDistSubDiff = Math.floor( (barWidthMain - barWidth)/2 ) + 1;
/* chart1.on('draw', function(data) {
	//alert("data"+data.type);
 if(data.type === 'bar') {
    
      // reposition the smaller bar series gap
      alert({x1:data.x1, x2:data.x2});
    
          data.element.attr( {x1:data.x1, x2:data.x2});
     
  
  }
	}); */

/* chart1.on('created', function(bar) {
	  $('.ct-bar').on('mouseover', function() {
	    $('#tooltip').html('<b>Selected Value: </b>' + $(this).attr('ct:meta')+'--'+ $(this).attr('ct:value'));
	  });

	  $('.ct-bar').on('mouseout', function() {
	    $('#tooltip').html('<b>Selected Value:</b>');
	  });
	});
chart2.on('created', function(bar) {
	  $('.ct-bar').on('mouseover', function() {
	    $('#tooltip').html('<b>Selected Value: </b>' + $(this).attr('ct:meta')+'--'+ $(this).attr('ct:value'));
	  });

	  $('.ct-bar').on('mouseout', function() {
	    $('#tooltip').html('<b>Selected Value:</b>');
	  });
	});
chart3.on('created', function(bar) {
	  $('.ct-bar').on('mouseover', function() {
	    $('#tooltip').html('<b>Selected Value: </b>' + $(this).attr('ct:meta')+'--'+ $(this).attr('ct:value'));
	  });

	  $('.ct-bar').on('mouseout', function() {
	    $('#tooltip').html('<b>Selected Value:</b>');
	  });
	});
chart4.on('created', function(bar) {
	  $('.ct-bar').on('mouseover', function() {
	    $('#tooltip').html('<b>Selected Value: </b>' + $(this).attr('ct:meta')+'--'+ $(this).attr('ct:value'));
	  });

	  $('.ct-bar').on('mouseout', function() {
	    $('#tooltip').html('<b>Selected Value:</b>');
	  });
	}); */
		});
	</script>
