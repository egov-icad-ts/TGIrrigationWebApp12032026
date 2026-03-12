
$(document).ready(function(){
	
	
	// $('#spinner').hide();
	
	
	
	
	 
	 
	 
	

	}); 


$(function() {
	
	 $( "#tabs" ).tabs();
	
	//$('#tankId').change(tankSearch);

});



/*var canalurl = '../js/geojson/canallayer.geojson';*/

/*
var mandalurl='../js/geojson/mandal.geojson';
var villageurl='../js/geojson/village.geojson';

var knrtanksurl='../js/geojson/tanks/knrtanks.geojson';
var wgltanksurl='../js/geojson//tanks/wgltanks.geojson'
*/
var mylayer=null;
var tankfeature=null;
var districturl= null;//'../js/geojson/district.geojson';
var villageurl=null; //'../js/geojson/village.geojson';
var mandalurl=null; //'../js/geojson/mandal.geojson';
var canalurl=null; //'../js/geojson/canallayer.geojson';
var knrtanksurl=null; //'../js/geojson/tanks/knrtanks.geojson';
var wgltanksurl=null;//'../js/geojson//tanks/wgltanks.geojson';
//var districturl=null;





mapboxgl.accessToken = 'pk.eyJ1Ijoidmlzd2EyMDkiLCJhIjoiY2tkNXQ1cjduMGIzdTJzcmEwcGdvNXA5NSJ9.rXeVjnrgUuTgubPSQV4Crw';
var map = new mapboxgl.Map({
container: 'map',
style: 'mapbox://styles/viswa209/ckgbxlna32n7c19qugnao2p9a',
preserveDrawingBuffer: true
	
	//'mapbox://styles/viswa209/ckd78868j019c1ipd9czgohj3'
	
	//mapbox://styles/viswa209/ckechqddp28go1aqlgijuvy3i
	
	//'mapbox://styles/viswa209/ckd78868j019c1ipd9czgohj3'

	

});



var knrtanks = [];








map.on('load', function(m) {
    // Add GeoJSON data

	
     map.addSource('village', {
        'type': 'geojson',
        'data': villageurl
    });
    
    map.addLayer({
        'id': 'village',
        'type': 'line',
        'source': 'village',
      
        'layout': {
        	
        },'paint': {
            'line-color': '#ffff00',
            'line-opacity': 1
        }
        
        
       
       
    });
    
    map.addLayer({
        'id': 'poi-labels2',
        'type': 'symbol',
        'source': 'village',
      
        'layout': {
        	"text-field": ['get', 'Name'],
        	"text-font": ['Arial Unicode MS Bold'],
    'text-justify': 'right',
    'text-anchor': 'right',
    'text-allow-overlap' : true,
    "text-size": 16,
   'text-allow-overlap' : false,
    'text-offset': [-1,0],
    'symbol-z-order': 'source'
        },'paint': {
            'text-color': '#ffff00',
            'text-halo-width': 0,
            'text-halo-color': '#ffff00'
          }
        
       
       
    }); 
	  
	  
	 
    
    map.addSource('mandal', {
        'type': 'geojson',
        'data': mandalurl
    });
    
    map.addLayer({
        'id': 'mandal',
        'type': 'line',
        'source': 'mandal',
      
        'layout': {
        	
        },'paint': {
            'line-color': '#00ff00',
            'line-opacity': 1
        }
        
        
       
       
    });
    
    map.addLayer({
        'id': 'poi-labels1',
        'type': 'symbol',
        'source': 'mandal',
      
        'layout': {
        	"text-field": ['get', 'Name'],
        	"text-font": ['Arial Unicode MS Bold'],
    'text-justify': 'right',
    'text-anchor': 'right',
    'text-allow-overlap' : true,
    "text-size": 16,
    'text-allow-overlap' : false,
    'text-offset': [-1,0],
    'symbol-z-order': 'source'
        },'paint': {
            'text-color': '#00ff00',
            'text-halo-width': 0,
            'text-halo-color': '#00ff00'
          }
        
        
       
       
    }); 
    
	  
	  
	

  
	   
	  
    map.addSource('district', {
        'type': 'geojson',
        'data': districturl
    });
    
    map.addLayer({
    	'id': 'district',
        'type': 'line',
        'source': 'district',
        
        'layout': {
        	
        	
        },
        'paint': {
            'line-color': '#fffff0',
            'line-opacity': 1
        }
        
        
       
       
    });
    
    map.addLayer({
    	'id': 'poi-labels',
        'type': 'symbol',
        'source': 'district',
        
        'layout': {
        	 // get the title name from the source's "title" prope
        	  'visibility': 'visible',
          	
        	"text-field": ['get', 'Name'],
        	"text-font": ['Arial Unicode MS Bold'],
        	 'text-justify': 'right',
        	    'text-anchor': 'right',
        	    'text-allow-overlap' : true,
        	    "text-size": 16,
        	    'text-allow-overlap' : false,
        	    'text-offset': [-1,0],
        	    'symbol-z-order': 'source'
  
    
        },
        'paint': {
            'text-color': '#fffff0',
            'text-halo-width': 0,
            'text-halo-color': '#fffff0'
          }
        
       
       
    });
    

   
    map.addSource('canal', {
        'type': 'geojson',
        'data': canalurl
    });
    
    map.addLayer({
        'id': 'canal',
        'type': 'line',
        'source': 'canal',
       
        'layout': {
        
        },
        'paint': {
            'line-color': '#0000cd',
            'line-opacity': 1
        }
        
       
       
    }
    );
   
   

    
    map.addSource('knrtanks', {
        'type': 'geojson',
        'data': knrtanksurl
    });
    
    map.addLayer({
        'id': 'poi-labels3',
        'type': 'symbol',
        'source': 'knrtanks',
        'layout': {
       	 // get the title name from the source's "title" prope
       	"text-field":['concat', ['get', 'Name'],' @ ', ['get', 'tank_name']], //['get', 'tank_name'],
       	"text-font": ['Arial Unicode MS Bold'],
       	 'text-justify': 'right',
       	    'text-anchor': 'right',
       	    'text-allow-overlap' : true,
       	    "text-size": 16,
       	   'text-allow-overlap' : false,
       	    'text-offset': [-1,0],
       	    'symbol-z-order': 'source'
       	//'icon-image': ['au-state-4']
 
   
       },
       'paint': {
           'text-color': '#00ccff',
           'text-halo-width': 0,
           'text-halo-color': '#00ccff'
         }
         
       
       
    }
    );
    
   
   
 
   
    map.addSource('wgltanks', {
        'type': 'geojson',
        'data': wgltanksurl
    });
    
    map.addLayer({
        'id': 'poi-labels4',
        'type': 'symbol',
        'source': 'wgltanks',
        'layout': {
       	 // get the title name from the source's "title" prope
       	"text-field":['concat', ['get', 'Name'],' @ ', ['get', 'tank_name']], //['get', 'tank_name'],
       	"text-font": ['Arial Unicode MS Bold'],
       	 'text-justify': 'right',
       	    'text-anchor': 'right',
       	    'text-allow-overlap' : true,
       	    "text-size": 16,
       	    'text-allow-overlap' : false,
       	    'text-offset': [-1,0],
       	    'symbol-z-order': 'source'
 
   
       },
       'paint': {
           'text-color': '#00ffff',
           'text-halo-width': 0,
           'text-halo-color': '#00ffff'
         }
         //'filter': ["in", ['get', 'Name']]
       
       
    }
    );
   
   
    
   
    
   
    
 // Create a popup, but don't add it to the map yet.
    var popup = new mapboxgl.Popup({
    closeButton: false,
    closeOnClick: false
    });
    
    map.on('mouseenter', 'canal', function() {
    	 map.getCanvas().style.cursor = 'pointer';
        	 });
   
 // When a click event occurs on a feature in the places layer, open a popup at the
 // location of the feature, with description HTML from its properties.
 map.on('mouseenter', 'canal', function(e) {
	 
	 $("#mapthead1").empty();
	 $("#maptbody1").empty();
		
	
	// document.getElementById('info').innerHTML =
		// e.point is the x, y coordinates of the mousemove event relative
		// to the top-left corner of the map
	//console.log(JSON.stringify(e.point));
	
	var epoint=JSON.stringify(e.point);
  	 var lngl=e.lngLat.wrap();
  	 var pname=e.features[0].properties.Name;
		 
		 $('#map1data table thead').append(  
 	    		'<tr >'+
 	    		' <th>Point </th>'+
 	    		' <th>LngLat </th>'+
 	    		
 	    		'<th>Name</th>	'+
 	    	
 	    	
 	    		'</tr>'); 	 
		 
		 
		  $('#map1data table tbody').append(  '<tr >' +
                  '<td >'+epoint+'</td>' +
                  '<td>'+lngl+'</td>' +
                  '<td>'+pname+'</td>' +
                  '</tr>');
                                                     

		 /* $('#map1data table tbody').append(  '<tr style="font-size: 12px">' +
				  '<td>Description</td><td><pre><b>'+$.trim(JSON.stringify(e.features[0].properties.description)).replace(/\n/g(<meta http-equiv="\&quot;Content-Type\&quot;" content="\&quot;text/html\&quot;"><meta http-equiv="\&quot;content-type\&quot;" content="\&quot;text/html;" charset="UTF-8\&quot;">),'')+'</b></pre></td> </tr>');
	 */
		/* +
		'<br />' +
		// e.lngLat is the longitude, latitude geographical position of the event
		+
		'<br />' +
		JSON.stringify(e.features[0].properties.Name)+
		'<br />' +
		JSON.stringify(e.features[0].properties.description);*/
		
	
		 var features = map.queryRenderedFeatures(e.point, {
             layers: ['canal']
         });
         if (!features.length) {
             return;
         }
         var feature = features[0];

        
 // wrap each coordinate pair in `extend` to include them in the bounds
 // result. A variation of this technique could be applied to zooming
 // to the bounds of multiple Points or Polygon geomteries - it just
 // requires wrapping all the coordinates with the extend method.
  
 
 
 
  
  
  // Populate the popup and set its coordinates
  // based on the feature found.
   popup
   .setLngLat(map.unproject(e.point))
   .setHTML(e.features[0].properties.description)
   .addTo(map);
 });
 
 //.setLngLat(coordinates[0],coordinates[0])
  
 // Change the cursor to a pointer when the mouse is over the places layer.
 
  
 // Change it back to a pointer when it leaves.
 map.on('mouseleave', 'canal', function() {
 map.getCanvas().style.cursor = '';
 popup.remove();
 });
 
/* map.on('moveend', updateLocationInputs).on('zoomend', updateLocationInputs);
 updateLocationInputs();*/
 

 /* var filtered = knrtanks.filter(function(feature) {
	 alert("i am here"+feature.properties.Name);
	 console.log(feature.properties.Name); */
	/*  var name = normalize(feature.properties.name);
	 var code = normalize(feature.properties.abbrev);
	 return name.indexOf(value) > -1 || code.indexOf(value) > -1; */
	/*  }); */
 
 //alert("tankfeatures"+tankfeatures.length);

  
   

   
  
 map.addControl(new mapboxgl.NavigationControl());

  

});

$('#downloadLink').click(function() {
    var img = map.getCanvas().toDataURL('image/png')
    this.href = img
})

/*

*/

/*var typeFilter = ['match', ['get', 'breweryType'], ['Irish','American'], true, false]
map.setFilter('breweriesLayer',typeFilter)
setFilter(layerId: string, filter: ?FilterSpecification,  options: StyleSetterOptions = {})
var breweryFilter=[
                   "all",
                   ["in", "stateNam", 'Utah','Texas','Florida'],
                   ["in", "breweryType", 'Irish','American']
               ]
               map.setFilter('breweriesLayer',breweryFilter)
 */

/* function tankSearch() {

	   var searchString = $('#tankId').val().toLowerCase();
	  
	  alert("searchString"+searchString);

	 
	

	  alert("i am here"+tankfeature.properties.Name);

	  function showTank(tankfeature) {
		  
		  alert("coming here"+tankfeature.properties.Name);
		

	    if (tankfeature.properties.Name == searchString) {
	      map.setView([tankfeature.geometry.coordinates[1], tankfeature.geometry.coordinates[0]], 17);
	    } else {
	      return tankfeature.properties.Name
	        .toLowerCase()
	        .indexOf(searchString) !== -1;
	    }
	    return true;
	  }
	  
	  map.setFilter('poi-labels3','==',showTank);

	} */

/* 
	function updateLocationInputs() {
	    var center = map.getCenter().toArray();

	    var zoom = parseFloat(map.getZoom()).toFixed(2),
	        lat = parseFloat(center[1]).toFixed(4),
	        lon = parseFloat(center[0]).toFixed(4);
	    
	   // alert("lat"+lat);
	   // alert("lon"+lon);

	   $('#latInput').val(lat);
	   $('#lonInput').val(lon);
	   $('#zoomInput').val(zoom);
	    //form.zoomInput.value = zoom;
	    //form.latInput.value = lat;
	   // form.lonInput.value = lon;
	} */



	/* function generateMap() {
	    'use strict';

	  

	    document.getElementById('spinner').style.display = 'inline-block';
	    document.getElementById('generate-btn').classList.add('disabled');

	    var width =800// Number(form.widthInput.value);
	    var height =800 // Number(form.heightInput.value);

	    var dpi = 300   //Number(form.dpiInput.value);

	    var format = 'png'//form.outputOptions[0].checked ? 'png' : 'pdf';

	    var unit = 'in'  //form.unitOptions[0].checked ? 'in' : 'mm';

	    var style = 'mapbox://styles/viswa209/ckechqddp28go1aqlgijuvy3i'  //form.styleSelect.value;

	    var zoom = map.getZoom();
	    var center = map.getCenter();
	    var bearing = map.getBearing();
	    var pitch = map.getPitch();

	    createPrintMap(width, height, dpi, format, unit, zoom, center,
	        bearing, style, pitch);
	} */ 


	/* function toPixels(length) {
	    'use strict';
	    var unit = 'in'
	    var conversionFactor = 96;
	    if (unit == 'mm') {
	        conversionFactor /= 25.4;
	    }

	    return conversionFactor * length + 'px';
	} */


	/* function createPrintMap(width, height, dpi, format, unit, zoom, center,
	    bearing, style, pitch) {
	    'use strict';
	    
	    alert(width+height+dpi+format+unit+zoom+center+bearing+style+pitch);

	    // Calculate pixel ratio
	    var actualPixelRatio = window.devicePixelRatio;
	    Object.defineProperty(window, 'devicePixelRatio', {
	        get: function() {return dpi / 96}
	    });
  alert(' i am here');
	    // Create map container
	    var hidden = document.createElement('div');
	    hidden.className = 'hidden-map';
	    document.body.appendChild(hidden);
	    var container = document.createElement('div');
	    container.style.width = toPixels(width);
	    container.style.height = toPixels(height);
	    hidden.appendChild(container);
	    
	    var lat=$('#latInput').val();
	    var lon=$('#lonInput').val();
	    var zoom=$('#zoomInput').val();
	    alert(' i am here2');

	    // Render map
	    mapboxgl.accessToken = 'pk.eyJ1Ijoidmlzd2EyMDkiLCJhIjoiY2tkNXQ1cjduMGIzdTJzcmEwcGdvNXA5NSJ9.rXeVjnrgUuTgubPSQV4Crw';
	    alert(' i am here'+3);
	    var renderMap = new mapboxgl.Map({
	        container: container,
	        center: center,
	        zoom: zoom,
	        style: 'mapbox://styles/viswa209/ckechqddp28go1aqlgijuvy3i',
	        //+lon+','+lat+','+zoom+','+bearing+'/800x900?access_token=pk.eyJ1Ijoidmlzd2EyMDkiLCJhIjoiY2tkNXQ1cjduMGIzdTJzcmEwcGdvNXA5NSJ9.rXeVjnrgUuTgubPSQV4Crw'
	        bearing: bearing,
	      pitch: pitch,
	        interactive: false,
	       attributionControl: false,
	       preserveDrawingBuffer: true
	    });
	    alert(' i am here3');
	    renderMap.once('load', function() {
	        if (format == 'png') {
	            renderMap.getCanvas().toBlob(function(blob) {
	                saveAs(blob, 'map3.png');
	            });
	        } else {
	        	alert("i am pdf")
	            var pdf = new jsPDF({
	                orientation: width > height ? 'l' : 'p',
	                unit: unit,
	                format: [width, height],
	                compress: true
	            });

	            pdf.addImage(renderMap.getCanvas().toDataURL('image/png'),
	                'png', 0, 0, width, height, null, 'FAST');

	            var title = map.getStyle().name,
	                subject = "center: [" + lon   + ", " + lat + ", " + zoom + "]",
	                attribution = ', (c) OpenStreetMap'; 
	                    
	           // (form.styleSelect.value.indexOf('mapbox') >= 0 ? 'Mapbox' : 'OpenMapTiles') +

	            pdf.setProperties({
	                title: title,
	                subject: subject,
	                creator: 'Print Maps',
	                author: attribution
	            })

	            pdf.save('map.pdf');
	        }

	        renderMap.remove();
	        hidden.parentNode.removeChild(hidden);
	        Object.defineProperty(window, 'devicePixelRatio', {
	            get: function() {return actualPixelRatio}
	        });
	        document.getElementById('spinner').style.display = 'none';
	        document.getElementById('generate-btn').classList.remove('disabled');
	    });
	} */
	
/* 	https://api.mapbox.com/styles/v1/mapbox/light-v10/static/-94.7791,33.7022,4.67,0/300x200?access_token=pk.eyJ1Ijoidmlzd2EyMDkiLCJhIjoiY2tkNXQ1cjduMGIzdTJzcmEwcGdvNXA5NSJ9.rXeVjnrgUuTgubPSQV4Crw */


var newmap = new mapboxgl.Map({
	container: 'map2',
	style: 'mapbox://styles/viswa209/ckechqddp28go1aqlgijuvy3i',
	preserveDrawingBuffer: true
		
		//'mapbox://styles/viswa209/ckd78868j019c1ipd9czgohj3'
		
		//mapbox://styles/viswa209/ckechqddp28go1aqlgijuvy3i
		
		//'mapbox://styles/viswa209/ckd78868j019c1ipd9czgohj3'

		

	});

newmap.on('load', function(m) {
    // Add GeoJSON data
   
    
	newmap.addSource('village', {
        'type': 'geojson',
        'data': villageurl
    });
    
	newmap.addLayer({
        'id': 'village',
        'type': 'line',
        'source': 'village',
      
        'layout': {
        	
        },'paint': {
            'line-color': 'green',
            'line-opacity': 1
        }
        
        
       
       
    });
    
	newmap.addLayer({
        'id': 'poi-labels2',
        'type': 'symbol',
        'source': 'village',
      
        'layout': {
        	"text-field": ['get', 'Name'],
        	"text-font": ['Arial Unicode MS Bold'],
    'text-justify': 'right',
    'text-anchor': 'right',
    'text-allow-overlap' : true,
    "text-size": 16,
    'text-allow-overlap' : false,
    'text-offset': [-1,0],
    'symbol-z-order': 'source'
        },'paint': {
            'text-color': 'green',
            'text-halo-width': 0,
            'text-halo-color': 'green'
          }
        
       
       
    }); 
    
	newmap.addSource('mandal', {
        'type': 'geojson',
        'data': mandalurl
    });
    
	newmap.addLayer({
        'id': 'mandal',
        'type': 'line',
        'source': 'mandal',
      
        'layout': {
        	
        },'paint': {
            'line-color': 'red',
            'line-opacity': 1
        }
        
        
       
       
    });
    
	newmap.addLayer({
        'id': 'poi-labels1',
        'type': 'symbol',
        'source': 'mandal',
      
        'layout': {
        	"text-field": ['get', 'Name'],
        	"text-font": ['Arial Unicode MS Bold'],
    'text-justify': 'right',
    'text-anchor': 'right',
    'text-allow-overlap' : true,
    "text-size": 16,
    'text-allow-overlap' : false,
    'text-offset': [-1,0],
    'symbol-z-order': 'source'
        },'paint': {
            'text-color': 'red',
            'text-halo-width': 0,
            'text-halo-color': 'red'
          }
        
        
       
       
    }); 
    
	newmap.addSource('district', {
        'type': 'geojson',
        'data': districturl
    });
    
	newmap.addLayer({
    	'id': 'district',
        'type': 'line',
        'source': 'district',
        
        'layout': {
        	
        },
        'paint': {
            'line-color': 'black',
            'line-opacity': 1
        }
        
        
       
       
    });
    
	newmap.addLayer({
    	'id': 'poi-labels',
        'type': 'symbol',
        'source': 'district',
        
        'layout': {
        	 // get the title name from the source's "title" prope
        	"text-field": ['get', 'Name'],
        	"text-font": ['Arial Unicode MS Bold'],
        	 'text-justify': 'right',
        	    'text-anchor': 'right',
        	    'text-allow-overlap' : true,
        	    "text-size": 16,
        	    'text-allow-overlap' : false,
        	    'text-offset': [-1,0],
        	    'symbol-z-order': 'source'
  
    
        },
        'paint': {
            'text-color': 'black',
            'text-halo-width': 0,
            'text-halo-color': 'black'
          }
        
       
       
    });
    
	newmap.addSource('canal', {
        'type': 'geojson',
        'data': canalurl
    });
    
	newmap.addLayer({
        'id': 'canal',
        'type': 'line',
        'source': 'canal',
       
        'layout': {
        
        },
        'paint': {
            'line-color': '#088',
            'line-opacity': 1
        }
        
       
       
    }
    );
    
	newmap.addSource('knrtanks', {
        'type': 'geojson',
        'data': knrtanksurl
    });
    
	newmap.addLayer({
        'id': 'poi-labels3',
        'type': 'symbol',
        'source': 'knrtanks',
        'layout': {
       	 // get the title name from the source's "title" prope
       	"text-field":['concat', ['get', 'Name'],' @ ', ['get', 'tank_name']], //['get', 'tank_name'],
       	"text-font": ['Arial Unicode MS Bold'],
       	 'text-justify': 'right',
       	    'text-anchor': 'right',
       	    'text-allow-overlap' : true,
       	    "text-size": 16,
       	    'text-allow-overlap' : false,
       	    'text-offset': [-1,0],
       	    'symbol-z-order': 'source'
       	//'icon-image': ['au-state-4']
 
   
       },
       'paint': {
           'text-color': '#0000FF',
           'text-halo-width': 0,
           'text-halo-color': '#0000FF'
         }
         
       
       
    }
    );
    
    
   
	newmap.addSource('wgltanks', {
        'type': 'geojson',
        'data': wgltanksurl
    });
    
	newmap.addLayer({
        'id': 'poi-labels4',
        'type': 'symbol',
        'source': 'wgltanks',
        'layout': {
       	 // get the title name from the source's "title" prope
       	"text-field":['concat', ['get', 'Name'],' @ ', ['get', 'tank_name']], //['get', 'tank_name'],
       	"text-font": ['Arial Unicode MS Bold'],
       	 'text-justify': 'right',
       	    'text-anchor': 'right',
       	    'text-allow-overlap' : true,
       	    "text-size": 16,
       	    'text-allow-overlap' : false,
       	    'text-offset': [-1,0],
       	    'symbol-z-order': 'source'
 
   
       },
       'paint': {
           'text-color': '#FF00FF',
           'text-halo-width': 0,
           'text-halo-color': '#FF00FF'
         }
         //'filter': ["in", ['get', 'Name']]
       
       
    }
    );
    
   
    
   
    
   
    
 // Create a popup, but don't add it to the map yet.
    var popup2 = new mapboxgl.Popup({
    closeButton: false,
    closeOnClick: false
    });
    
    newmap.on('mouseenter', 'canal', function() {
    	 newmap.getCanvas().style.cursor = 'pointer';
        	 });
   
 // When a click event occurs on a feature in the places layer, open a popup at the
 // location of the feature, with description HTML from its properties.
    newmap.on('mouseenter', 'canal', function(e) {
	 
    	$("#mapthead2").empty();
   	 $("#maptbody2").empty();
   	 
   	 var epoint=JSON.stringify(e.point);
   	 var lngl=e.lngLat.wrap();
   	 var pname=e.features[0].properties.Name;
    	
    	 $('#map2data table thead').append(  
  	    		'<tr >'+
  	    		' <th>Point </th>'+
  	    		' <th>LngLat </th>'+
  	    		
  	    		'<th>Name</th>	'+
  	    	
  	    	
  	    		'</tr>'); 	 
 		 
 		 
 		  $('#map2data table tbody').append(  '<tr >' +
                   '<td >'+epoint+'</td>' +
                   '<td>'+lngl+'</td>' +
                   '<td>'+pname+'</td>' +
                   '</tr>');
                                           

	/* document.getElementById('info2').innerHTML =
		// e.point is the x, y coordinates of the mousemove event relative
		// to the top-left corner of the map
	
		JSON.stringify(e.point) +
		'<br />' +
		// e.lngLat is the longitude, latitude geographical position of the event
		JSON.stringify(e.lngLat.wrap())+
		'<br />' +
		JSON.stringify(e.features[0].properties.Name)+
		'<br />' +
		JSON.stringify(e.features[0].properties.description);*/
		
	
		 var features = map.queryRenderedFeatures(e.point, {
             layers: ['canal']
         });
         if (!features.length) {
             return;
         }
         var feature = features[0];

        
 // wrap each coordinate pair in `extend` to include them in the bounds
 // result. A variation of this technique could be applied to zooming
 // to the bounds of multiple Points or Polygon geomteries - it just
 // requires wrapping all the coordinates with the extend method.
  
 
 
 
  
  
  // Populate the popup and set its coordinates
  // based on the feature found.
   popup2
   .setLngLat(newmap.unproject(e.point))
   .setHTML(e.features[0].properties.description)
   .addTo(newmap);
 });
 
 //.setLngLat(coordinates[0],coordinates[0])
  
 // Change the cursor to a pointer when the mouse is over the places layer.
 
  
 // Change it back to a pointer when it leaves.
    newmap.on('mouseleave', 'canal', function() {
    	newmap.getCanvas().style.cursor = '';
 popup2.remove();
 });
 
    /*
    newmap.on('moveend', updateLocationInputs).on('zoomend', updateLocationInputs);
 updateLocationInputs();*/
 

    /* var filtered = knrtanks.filter(function(feature) {
	 alert("i am here"+feature.properties.Name);
	 console.log(feature.properties.Name); 
	  var name = normalize(feature.properties.name);
	 var code = normalize(feature.properties.abbrev);
	 return name.indexOf(value) > -1 || code.indexOf(value) > -1; 
	  }); 
  */
 //alert("tankfeatures"+tankfeatures.length);

  
 
    
    newmap.addControl(new mapboxgl.NavigationControl());

 
 
});

$('#downloadLink2').click(function() {
    var img2 = newmap.getCanvas().toDataURL('image/png')
    this.href = img2
})


$('.boundaryCheck').click(function(e){
	
	var checkId= $(this).attr("id");
	
	//alert("checkId"+checkId);
	
	var checkStatus= $(this).prop('checked')
	
	if(checkId=='district'){
		
		districturl='../js/geojson/district.geojson';
		 map.getSource('district').setData(districturl);
		 newmap.getSource('district').setData(districturl);
		
		
	}
	
if(checkId=='mandal'){
		
	mandalurl='../js/geojson/mandal.geojson';
		 map.getSource('mandal').setData(mandalurl);
		 newmap.getSource('mandal').setData(mandalurl);
		
		
	}

if(checkId=='village'){
	
	villageurl='../js/geojson/village.geojson';
		 map.getSource('village').setData(villageurl);
		 
		 newmap.getSource('village').setData(villageurl);
		
		
	}

if(checkId=='canal'){
	
	canalurl='../js/geojson/canallayer.geojson';
		 map.getSource('canal').setData(canalurl);
		 
		 newmap.getSource('canal').setData(canalurl);
		
		
	}

if(checkId=='knrtanks'){
	
	knrtanksurl='../js/geojson/tanks/knrtanks.geojson';
		 map.getSource('knrtanks').setData(knrtanksurl);
		 newmap.getSource('knrtanks').setData(knrtanksurl);
		
		
	}

if(checkId=='wgltanks'){
	
	wgltanksurl='../js/geojson//tanks/wgltanks.geojson';
		 map.getSource('wgltanks').setData(wgltanksurl);
		 
		 newmap.getSource('wgltanks').setData(wgltanksurl);
		
		
	}
	
	map.setLayoutProperty(
			checkId,
			'visibility',
			e.target.checked ? 'visible' : 'none'
			);
	
	newmap.setLayoutProperty(
			checkId,
			'visibility',
			e.target.checked ? 'visible' : 'none'
			);

	
	 });

/*$('#mandalbd').click(function(){
	
	var mandb=$('#mandalbd').prop('checked')
	//alert("distdb"+distdb);
	if(mandb==true){
		mandalurl='../js/geojson/mandal.geojson';
	
	 
	 map.getSource('mandal').setData(mandalurl);
	 newmap.getSource('mandal').setData(mandalurl);
	 	
	}
	if(mandb==false){
		//alert("cming here"+distdb);
		mandalurl='';
		
		 
		 map.getSource(' ').setData(mandalurl);
		 newmap.getSource(' ').setData(mandalurl);
		 	
		}
	

	 });

$('#villagebd').click(function(){
	
	var villdb=$('#villagebd').prop('checked')
	//alert("distdb"+distdb);
	if(villdb==true){
		villageurl='../js/geojson/village.geojson';
	
	 
	 map.getSource('village').setData(villageurl);
	 newmap.getSource('village').setData(villageurl);
	 	
	}
	if(villdb==false){
		//alert("cming here"+distdb);
		villageurl='';
		
		 
		 map.getSource(' ').setData(villageurl);
		 newmap.getSource(' ').setData(villageurl);
		 	
		}
	

	 });

$('#canalsbd').click(function(){
	
	var canaldb=$('#canalsbd').prop('checked')
	//alert("distdb"+distdb);
	if(canaldb==true){
		canalurl='../js/geojson/canallayer.geojson';
	
	 
	 map.getSource('canal').setData(canalurl);
	 newmap.getSource('canal').setData(canalurl);
	 	
	}
	if(canaldb==false){
		//alert("cming here"+distdb);
		canalurl='';
		
		 
		 map.getSource(' ').setData(canalurl);
		 newmap.getSource(' ').setData(canalurl);
		 	
		}
	

	 });

$('#knartanks').click(function(){
	
	var knrtanksdb=$('#knartanks').prop('checked')
	//alert("distdb"+distdb);
	if(knrtanksdb==true){
		knrtanksurl='../js/geojson/tanks/knrtanks.geojson';
	
	 
	 map.getSource('knrtanks').setData(knrtanksurl);
	 newmap.getSource('knrtanks').setData(knrtanksurl);
	 	
	}
	if(knrtanksdb==false){
		//alert("cming here"+distdb);
		knrtanksurl='';
		
		 
		 map.getSource(' ').setData(knrtanksurl);
		 newmap.getSource(' ').setData(knrtanksurl);
		 	
		}
	

	 });

$('#wgltanks').click(function(){
	
	var wgltanksdb=$('#wgltanks').prop('checked')
	//alert("distdb"+distdb);
	if(wgltanksdb==true){
		wgltanksurl='../js/geojson//tanks/wgltanks.geojson';
	
	 
	 map.getSource('wgltanks').setData(wgltanksurl);
	 newmap.getSource('wgltanks').setData(wgltanksurl);
	 	
	}
	if(wgltanksdb==false){
		//alert("cming here"+distdb);
		wgltanksurl='';
		
		 
		 map.getSource(' ').setData(wgltanksurl);
		 newmap.getSource(' ').setData(wgltanksurl);
		 	
		}
	

	 });*/


/*var toggleableLayerIds = ['district', 'mandal' , 'village'  ];

//set up the corresponding toggle button for each layer
for (var i = 0; i < toggleableLayerIds.length; i++) {
var id = toggleableLayerIds[i];

var link = document.createElement('a');
link.href = '#';
link.className = 'active';
link.textContent = id;

link.onclick = function (e) {
var clickedLayer = this.textContent;
e.preventDefault();
e.stopPropagation();

var visibility = map.getLayoutProperty(clickedLayer, 'visibility');

//toggle layer visibility by changing the layout object's visibility property
if (visibility === 'visible') {
map.setLayoutProperty(clickedLayer, 'visibility', 'none');
this.className = '';
} else {
this.className = 'active';
map.setLayoutProperty(clickedLayer, 'visibility', 'visible');
}
};

var layers = document.getElementById('menu');
layers.appendChild(link);
}*/

/*$('#downloadLink3').click(function() {
    run(JSON.parse());
});*/



