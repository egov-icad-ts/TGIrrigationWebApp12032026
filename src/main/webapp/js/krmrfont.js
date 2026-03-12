// JavaScript Document


var min=13;
var max=16;
function increaseFontSize(obj) 
{
	//alert("kal");
	
	 // var p= $('.'+obj).divhtml();
var p=   document.getElementsByClassName(obj)[0];
//var p = document.getElementById(obj);
	//alert("p"+p);

var nodelist;	// local scope variables
var count;
nodelist = p.childNodes;
count = nodelist.length;
// alert(count) ; 

  for(i = 0; i < count; i++)
  {
	  
 	if (nodelist[i].nodeName=="TABLE") 
	{ 
	
	// alert(nodelist[i].style.fontSize) ; 	
	// alert(nodelist[i].nodeName) ; 	
	

var nodelist1;	// local scope variables
var count1;
nodelist1 = nodelist[i].childNodes;
count1 = nodelist1.length;

// alert(count1) ; 

for(j = 0; j < count1; j++)
{
// alert(nodelist1[j].nodeName) ; 

 	if (nodelist1[j].nodeName=="TBODY") 
	{ 
	
var nodelist2;	// local scope variables
var count2;
nodelist2 = nodelist1[j].childNodes;
count2 = nodelist2.length;

// alert(count2) ; 

for(k = 0; k < count2; k++)
{
	
// alert(nodelist2[k].nodeName) ; 

 	if (nodelist2[k].nodeName=="TR") 
	{ 
	


var nodelist3;	// local scope variables
var count3;
nodelist3 = nodelist2[k].childNodes;
count3 = nodelist3.length;

// alert(count3) ; 

for(m = 0; m < count3; m++)
{

// alert(nodelist3[m].nodeName) ; 

 	if (nodelist3[m].nodeName=="TD") 
	{ 
	
      if(nodelist3[m].style.fontSize) {
         var s = parseInt(nodelist3[m].style.fontSize.replace("px",""));
      } else {
         var s = 13;
      }
      if(s!=max) {
         s += 1;
      }
      nodelist3[m].style.fontSize = s+"px"


 	
	}
	

}


}
	

}


	}
	

}

	

    }
  
  }

   


   

  

   
      if(p.style.fontSize) {
         var s = parseInt(p.style.fontSize.replace("px",""));
      } else {
         var s = 13;
      }
      if(s!=max) {
         s += 1;
      }
      p.style.fontSize = s+"px"



}

function decreaseFontSize(obj) 
{

	var p=   document.getElementsByClassName(obj)[0];

var nodelist;	// local scope variables
var count;
nodelist = p.childNodes;
count = nodelist.length;
// alert(count) ; 

  for(i = 0; i < count; i++)
  {
	  
 	if (nodelist[i].nodeName=="TABLE") 
	{ 
	
	// alert(nodelist[i].style.fontSize) ; 	
	// alert(nodelist[i].nodeName) ; 	
	

var nodelist1;	// local scope variables
var count1;
nodelist1 = nodelist[i].childNodes;
count1 = nodelist1.length;

// alert(count1) ; 

for(j = 0; j < count1; j++)
{
// alert(nodelist1[j].nodeName) ; 

 	if (nodelist1[j].nodeName=="TBODY") 
	{ 
	
var nodelist2;	// local scope variables
var count2;
nodelist2 = nodelist1[j].childNodes;
count2 = nodelist2.length;

// alert(count2) ; 

for(k = 0; k < count2; k++)
{
	
// alert(nodelist2[k].nodeName) ; 

 	if (nodelist2[k].nodeName=="TR") 
	{ 
	


var nodelist3;	// local scope variables
var count3;
nodelist3 = nodelist2[k].childNodes;
count3 = nodelist3.length;

// alert(count3) ; 

for(m = 0; m < count3; m++)
{

// alert(nodelist3[m].nodeName) ; 

 	if (nodelist3[m].nodeName=="TD") 
	{ 
	
      if(nodelist3[m].style.fontSize) {
         var s = parseInt(nodelist3[m].style.fontSize.replace("px",""));
      } else {
         var s = 13;
      }
      if(s!=min) {
         s -= 1;
      }
      nodelist3[m].style.fontSize = s+"px"


 	
	}
	

}


}
	

}


	}
	

}

	

    }
  
  }

   


   

  

   
      if(p.style.fontSize) {
         var s = parseInt(p.style.fontSize.replace("px",""));
      } else {
         var s = 13;
      }
      if(s!=min) {
         s -= 1;
      }
      p.style.fontSize = s+"px"



}

function keepitsame(obj) 
{

	var p=   document.getElementsByClassName(obj)[0];

var nodelist;	// local scope variables
var count;
nodelist = p.childNodes;
count = nodelist.length;
// alert(count) ; 

  for(i = 0; i < count; i++)
  {
	  
 	if (nodelist[i].nodeName=="TABLE") 
	{ 
	
	// alert(nodelist[i].style.fontSize) ; 	
	// alert(nodelist[i].nodeName) ; 	
	

var nodelist1;	// local scope variables
var count1;
nodelist1 = nodelist[i].childNodes;
count1 = nodelist1.length;

// alert(count1) ; 

for(j = 0; j < count1; j++)
{
// alert(nodelist1[j].nodeName) ; 

 	if (nodelist1[j].nodeName=="TBODY") 
	{ 
	
var nodelist2;	// local scope variables
var count2;
nodelist2 = nodelist1[j].childNodes;
count2 = nodelist2.length;

// alert(count2) ; 

for(k = 0; k < count2; k++)
{
	
// alert(nodelist2[k].nodeName) ; 

 	if (nodelist2[k].nodeName=="TR") 
	{ 
	


var nodelist3;	// local scope variables
var count3;
nodelist3 = nodelist2[k].childNodes;
count3 = nodelist3.length;

// alert(count3) ; 

for(m = 0; m < count3; m++)
{

// alert(nodelist3[m].nodeName) ; 

 	if (nodelist3[m].nodeName=="TD") 
	{ 
	
      if(nodelist3[m].style.fontSize) {
         var s = parseInt(nodelist3[m].style.fontSize.replace("px",""));
      } else {
         var s = 14;
      }
      if(s!=max) {
         s += 1;
      }
      nodelist3[m].style.fontSize = "13px"
 	
	}
	}
	}
	}
	}
	}
    }  
	}

   


   

  

   
      if(p.style.fontSize) {
         var s = parseInt(p.style.fontSize.replace("px",""));
      } else {
         var s = 14;
      }
      if(s!=max) {
         s += 1;
      }
      p.style.fontSize = "13px"



}
