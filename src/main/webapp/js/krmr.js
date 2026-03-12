function CallPrint(strid){
	//alert("kal");
	    var str= $('.'+strid).html();
	    //alert("str"+str);
	//	str=document.getElementById(strid).innerHTML
		newwin=window.open('','printwin','left=100,top=100,width=400,height=400')
		newwin.document.write('<HTML>\n<HEAD>\n')
		newwin.document.write('<TITLE>Print Page</TITLE>\n')
		newwin.document.write('<link href="../css/style.css" type="text/css" rel="stylesheet" />')
		newwin.document.write('<script>\n')
		newwin.document.write('function chkstate(){\n')
		newwin.document.write('if(document.readyState=="complete"){\n')
		newwin.document.write('window.close()\n')
		newwin.document.write('}\n')
		newwin.document.write('else{\n')
		newwin.document.write('setTimeout("chkstate()",2000)\n')
		newwin.document.write('}\n')
		newwin.document.write('}\n')
		newwin.document.write('function print_win(){\n')
		//newwin.document.write('document.getElementById("divPrint").style.display = "none";\n')
		newwin.document.write('window.print();\n')
		newwin.document.write('chkstate();\n')
		newwin.document.write('}\n')
		newwin.document.write('<\/script>\n')
		newwin.document.write('</HEAD>\n')
		newwin.document.write('<BODY onload="print_win()">\n')
		newwin.document.write(str)
		newwin.document.write('</BODY>\n')
		newwin.document.write('</HTML>\n')
		newwin.document.close()
}

$(function() {
	
	$('#bookmark').click(function(e) {
		var bookmarkURL = "http://test.cgg.gov.in:8084/ICADLeagalWebApp/leagal/home";
		var bookmarkTitle = "Irrigation & CAD Krmr Project System";
		var triggerDefault = false;
				
		if (window.sidebar && window.sidebar.addPanel) {
			window.sidebar.addPanel(bookmarkTitle, bookmarkURL, '');
		} else if ((window.sidebar && (navigator.userAgent.toLowerCase().indexOf('firefox') > -1)) || (window.opera && window.print)) {
			var $this = $(this);
			$this.attr('href', bookmarkURL);
			$this.attr('title', bookmarkTitle);
			$this.attr('rel', 'sidebar');
			$this.off(e);
			triggerDefault = true;
		} else if (window.external && ('AddFavorite' in window.external)) {
			window.external.AddFavorite(bookmarkURL, bookmarkTitle);
		} else {
			alert('Press ' + (navigator.userAgent.toLowerCase().indexOf('mac') != -1 ? 'Cmd' : 'Ctrl') + '+D to bookmark this page.');
		}
		
		return triggerDefault;
	});
	
	

	$('#theme a').click(function(){
			var relattr = $(this).attr('rel');	
			//alert("relattr"+relattr);
			setStyle(relattr);								
		});
					
		function setStyle(theme){
			//alert("kal");
			if(theme != "theme-blue"){
				//alert("kalhere"+theme)
				$.cookie("currenttheme", theme , {expires:30});
				$('#theme-style').attr("href","../css/"+theme+".css");
			} else {
				$.cookie("currenttheme", "" , {expires:30});
				$('#theme-style').attr("href","");
			}
		}
					
		if(!($.cookie("currenttheme"))) {
			$('#theme-style').attr("href","");
		} else {
			$('#theme-style').attr("href","../css/"+$.cookie("currenttheme")+".css");
		}
		


	
	
	/*function mailThisUrl()
	{
		u = window.location;
		m = "Irrigation&cad";
		window.location = "mailto:"+''+"?subject="+m+"&body="+document.title+" "+u;
	}	
	
	//cssdropdown.startchrome("mainnav","sidemenu");	
	//$('#slider').bjqs({ height:236, width:459, showcontrols:false, showmarkers:false, hoverpause:false, randomstart:false, responsive:true });

	$("ul.grid li").each(function(){
		var height = $(this).height()-14;
		$(this).find('span').height(height);
	});
	*/
	

	
});