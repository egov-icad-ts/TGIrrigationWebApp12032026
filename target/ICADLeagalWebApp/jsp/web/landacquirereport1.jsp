
<%@include file="/jsp/header/taglib_includes.jsp"%>
<script type="text/javascript" src="../js/chartist.min.js.map"></script>
<script type="text/javascript" src="../js/chartist.js"></script>
<script type="text/javascript" src="../js/chartist.min.js"></script>
<script type="text/javascript" src="../js/jquery.js"></script>
<link rel="stylesheet" media="screen" href="../css/chartist.min.css">

<script>

$(document).ready(function() {
	
	var labelProjectArray = [];
    var totalLandReqArray = [];
    var totalAcquiredArray = [];

    $.getJSON("http://localhost:8080/PMSWebApp/landacquired", function(json) {
    	
    	//alert(json)

      
        for (var i in json){
        	//alert(json[i].projectName);
        	
        	//if(parseFloat(json[i].totalLandReq)>0){
        		//alert(json[i].projectName);
        	labelProjectArray.push(json[i].projectName);
        	
        	//}
        };

        for (var i in json){
        	//if(parseFloat(json[i].totalLandReq)>0){
        	//alert(json[i].totalLandReq)
        	totalLandReqArray.push(json[i].totalLandReq);
        	
        	//}
        };
        
        for (var i in json){
        	//alert(json[i].totalLandAcq)
        	//if(parseFloat(json[i].totalLandReq)>0){
        	totalAcquiredArray.push(json[i].totalLandAcq);
        	
        	//}
        };

      

        console.log(labelProjectArray); 
        console.log(totalLandReqArray); 
        console.log(totalAcquiredArray); 
        // this will show the info it in firebug console
        
        
      var data = {
  labels: [labelProjectArray],
  series: [
          		    {className: 'mycolorblue' , data :totalLandReqArray },  
          		    {className: 'mycolorgreen', data :totalAcquiredArray }  ]
};  
        
        var options = {
        		 seriesBarDistance: 2,
  axisX: {
	  showGrid: false,
    labelInterpolationFnc: function(value) {
      return  value;
    }
  }
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
        new Chartist.Bar('#ct-chart1', data, options, responsiveOptions);
    /* 	new Chartist.Bar('.ct-chart', {
     		
  		  labels: [labelProjectArray],
  		  series: [
  		    {className: 'mycolorblue' , data :totalLandReqArray },  
  		    {className: 'mycolorgreen', data :totalAcquiredArray }  ]
  		}, {
  		  seriesBarDistance: 2,
  		  
  		  axisX: {
  		    showGrid: false,
  		 
  		   
  		    // Only return first letter of weekday names
  		     labelInterpolationFnc: function(value) {
  		    	
  		      return value;
  		    }, 
  		   
  		  
  		  }
  		
  		}, [
  		  // Over 300px, we change the bar distance and show the first three letters of the weekdays
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
  		]);
         */
        
    	
    });
    
    
    
    
    var labelProject = 0;
    var totalLandReq = 0;
    var totalAcquired = 0;

    $.getJSON("http://localhost:8080/PMSWebApp/landacqproj", function(json) {
    	
    	//alert(json);

      
        for (var i in json){
        	
        labelProject=json[i].projectName;
        	
        	
        };

        for (var i in json){
        	
        	totalLandReq=json[i].totalLandReq;
        	
        };
        
        for (var i in json){
        	
        	totalAcquired=json[i].totalLandAcq;
        	
        };
        
        var m =parseFloat(totalLandReq);
        var n =parseFloat(totalAcquired);
        var l=(m-n);
        var j=l/m;
        var k=n/m
        
        console.log(labelProject); 
        console.log(totalLandReq); 
        console.log(totalAcquired); 
        
      

    var data = {
    		
    		 //labels:['BalanceLand' ,'CompletedLand' ],
    		  series: [j,k ]
    		  //series: [5, 3]
    		};

    		/* var sum = function(a, b) { 
    			alert(a+"suma");
    			alert(b+"sum b");
    			return a-b };
    		 */
    		 var options = {
    				 labelInterpolationFnc: function(value) {
    					
    	        		    return Math.round( value * 100) + '%';
    	        		  }
    		     };
    		 
    		  var responsiveOptions = [
    		                           ['screen and (min-width: 640px)', {
    		                               chartPadding: 30,
    		                               labelOffset: 100,
    		                               labelDirection: 'explode',
    		                               labelInterpolationFnc: function (value) {
    		                                   return  Math.round( value * 100) + '%';
    		                               }
    		                           }],
    		                           ['screen and (min-width: 1024px)', {
    		                               labelOffset: 40,
    		                               chartPadding: 20
    		                           }]
    		                         ];
    		
    		 var chart = new Chartist.Pie('#ct-chart2', data,options ,responsiveOptions );

    		

   
    
	

	
});
    
    var labelProjectArray1 = [];
    var totalLandReqArray1 = [];
    var totalAcquiredArray1 = [];

    $.getJSON("http://localhost:8080/PMSWebApp/landacqprojpack", function(json) {
    	
    	//alert(json)

      
        for (var i in json){
        	//alert(json[i].projectName);
        	
        	//if(parseFloat(json[i].totalLandReq)>0){
        		//alert(json[i].projectName);
        	labelProjectArray1.push(json[i].packageName);
        	
        	//}
        };

        for (var i in json){
        	//if(parseFloat(json[i].totalLandReq)>0){
        	//alert(json[i].totalLandReq)
        	totalLandReqArray1.push(json[i].totalLandReq);
        	
        	//}
        };
        
        for (var i in json){
        	//alert(json[i].totalLandAcq)
        	//if(parseFloat(json[i].totalLandReq)>0){
        	totalAcquiredArray1.push(json[i].totalLandAcq);
        	
        	//}
        };

      

        console.log(labelProjectArray); 
        console.log(totalLandReqArray); 
        console.log(totalAcquiredArray); 
        // this will show the info it in firebug console
        
        
      var data = {
  labels: [labelProjectArray1],
  series: [
          		    {className: 'mycolorblue' , data :totalLandReqArray1 },  
          		    {className: 'mycolorgreen', data :totalAcquiredArray1 }  ]
};  
        
        var options = {
        		 seriesBarDistance: 2,
  axisX: {
	  showGrid: false,
    labelInterpolationFnc: function(value) {
      return  value;
    }
  }
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
        new Chartist.Bar('#ct-chart3', data, options, responsiveOptions);
    });

	//alert("i am here"+labelProjectAcrray);
	
    var data = {
    		  labels: ['package1', 'package2', 'package3'],
    		  series: [20, 15, 40]
    		};

    		var options = {
    		  labelInterpolationFnc: function(value) {
    		    return value[0]
    		  }
    		};

    		var responsiveOptions = [
    		  ['screen and (min-width: 640px)', {
    		    chartPadding: 30,
    		    labelOffset: 100,
    		    labelDirection: 'explode',
    		    labelInterpolationFnc: function(value) {
    		      return value;
    		    }
    		  }],
    		  ['screen and (min-width: 1024px)', {
    		    labelOffset: 80,
    		    chartPadding: 20
    		  }]
    		];

    		new Chartist.Pie('#ct-chart4', data, options, responsiveOptions);
		

});
		
</script>

<div class='container'>
				<div class="row col-md-12 toppad ">
				<div class="row show-grid">
				<div class="col-md-6">
  <div class="ct-chart ct-golden-section  " id = "ct-chart1"></div>
  </div>
  
  <div class="col-md-6">
  <div class="ct-chart ct-golden-section  " id = "ct-chart2"></div>
  </div>
  </div>

  </div>
  
  <div class="row col-md-12 toppad ">
				<div class="row show-grid">
				<div class="col-md-6">
  <div class="ct-chart ct-golden-section  " id = "ct-chart3"></div>
  </div>
  
  <div class="col-md-6">
  <div class="ct-chart ct-golden-section  " id = "ct-chart4"></div>
  </div>
  </div>

  </div>
  </div>

