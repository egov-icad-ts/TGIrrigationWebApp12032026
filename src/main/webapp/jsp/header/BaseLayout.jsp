<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ include file="/jsp/header/taglib_includes.jsp" %>
<!DOCTYPE html>
<html class="no-js" lang="en">

<head>
<meta http-equiv="content-type" content="text/html" charset="windows-1252">

<title>TG Irrigation Management Information System</title>
 <meta charset="UTF-8">
 <meta name="viewport" content="width=device-width, initial-scale=1.0">
<!-- Meta tag Keywords -->

<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false);
function hideURLbar(){ window.scrollTo(0,1); } </script>
<!--// Meta tag Keywords -->
<!-- css files -->
<link rel="stylesheet" href="../css/bootstrap.min.css"> <!-- Bootstrap-Core-CSS -->
<link rel="stylesheet" href="../css/style.css" type="text/css" media="all" /> <!-- Style-CSS --> 
<link rel="stylesheet" href="../css/font-awesome.css"> <!-- Font-Awesome-Icons-CSS -->
<link rel="stylesheet" href="../css/owl.carousel.css" type="text/css" media="all"/> <!-- Owl-Carousel-CSS -->
<link rel="stylesheet" href="../css/easy-responsive-tabs.css">
<link href="../css/popuo-box.css" rel="stylesheet" type="text/css" media="all" /> <!-- pop-up-box -->




  <script type="text/javascript" src="../js/jquery-2.1.4.min.js"></script>

</head>

<body>          
      
       <div style="position:fixed;top:0px;left:0px;width:0;height:0;" id="scrollzipPoint"></div>     
    
<div id="content">
<tiles:insertAttribute name="headerhome" />
<tiles:insertAttribute name="headerweb" />
<tiles:insertAttribute name="headeradmin" />
<div class="w3l-main" id="borderStyle">	
<tiles:insertAttribute name="menu" />
<tiles:insertAttribute name="adminMenu" />

<tiles:insertAttribute name="body" />
 </div>
<tiles:insertAttribute name="footer" />
 

</div>
 	
<!-- js-scripts -->		
<!-- js -->
<!-- //js -->
<!-- smooth scrolling -->
<script src="../js/SmoothScroll.min.js"></script>
<!-- //smooth scrolling -->
<!-- menu-script -->
<script>
	$("span.menu").click(function(){
		$(".nav1 ul").slideToggle(500, function(){
		});
	});
</script>

	<script src="../js/easy-responsive-tabs.js"></script>
	<script>
		$(document).ready(function () {
		$('#verticalTab').easyResponsiveTabs({
		type: 'vertical',
		width: 'auto',
		fit: true
		});
		});
	</script>

<script type="text/javascript" src="../js/numscroller-1.0.js"></script>

<script type="text/javascript">
	$(window).load( function() {

		
 
	switch(window.location.protocol) {
	case 'http:':
	case 'https:':
	// running on a server, should be good.
	break;
	case 'file:':
	alert('Just a heads-up, events will not work when run locally.');
	}

	});
</script>
<script type="text/javascript" src="../js/dscountdown.min.js"></script>

	
<script type="text/javascript" src="../js/bootstrap.min.js"></script>


</body>
</html>