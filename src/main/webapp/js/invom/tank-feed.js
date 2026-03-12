$(function() {
	
	

	$('#tank-feed-dialogue').dialog({
	    
	    autoOpen:false,
	    width:1200,
	    buttons: {
	        confirm: function () {
	            $.alert('Confirmed!');
	        },
	        cancel: function () {
	            $.alert('Canceled!');
	        }
	        
	    }
	});
	
	 $('.addtankfeedinfcls').click(function(){
			
		 $('#tank-feed-dialogue').dialog('option', 'title', 'Tank Feed Details');
		  $('#tank-feed-dialogue').dialog('open');
		 
	      
		 });
	
	
});