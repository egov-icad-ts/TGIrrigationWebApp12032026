package in.ts.icad.leagal.controller;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.attribute.PosixFilePermissions;
import java.util.Set;

import javax.servlet.ServletContext;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;





@Controller
public class GenericViewController {
	
	@Autowired
	private ServletContext servletContext;
	
	 @GetMapping("/generic/dynamicViewForm")
	    public ModelAndView showDynamicViewForm() {
		 
		 ModelAndView mav= new ModelAndView();
		 
		 mav.setViewName("dynamicViewForm");
	        return mav;
	    }

	    @PostMapping("/addDynamicView")
	    public String addDynamicView(@RequestParam("viewName") String viewName,
	                                  @RequestParam("jspPath") String jspPath) {
	    	
	    	System.out.println("viewName"+viewName);
	    	System.out.println("jspPath"+jspPath);
	        // Add logic to add the view name and JSP path to Apache Tiles configuration
	        // For demonstration purposes, we'll just return the view name as a redirect
	        return "redirect:/" + viewName;
	    }
	    
	    @RequestMapping(value = "/generateTileDefinition", method = RequestMethod.POST)
	    @ResponseBody
	    public String generateTileDefinition(@RequestParam String viewName, @RequestParam String jspPath) {
	        // Use viewName and jspPath to generate the tile definition
	    	
	    	
	    	System.out.println("viewName"+viewName);
	    	System.out.println("jspPath"+jspPath);
	    	String headerpath="/jsp/header/headeradmin.jsp";
	    	String menupath="/jsp/header/budgetLeft.jsp";
	    	
	    	String pathpage="/jsp/header/"+jspPath+".jsp";

	        String definition = "<definition name=\"" + viewName + "\" extends=\"baseLayoutLeftMenu\">\n"
	        		       + "    <put-attribute name=\"headeradmin\" value=\"" + headerpath + "\" />\n"
	        		        + "    <put-attribute name=\"menu\" value=\"" + menupath + "\" />\n"
	                             + "    <put-attribute name=\"body\" value=\"" + pathpage + "\" />\n"
	                             + "</definition>";
	        // Write the definition to tiles.xml file (You need to implement this)
	        writeToTilesXml(definition);
	        createcustomjspfile(jspPath);
	        return "Success";
	    }

	    private void writeToTilesXml(String definition) {
	        // Implement logic to write the definition to tiles.xml file
	        // This is a simplified example, in reality, you'd need to use a proper XML parsing library
	    	
	    	System.out.println("definition"+definition);
	        try {
	            String tilesXmlPath =  servletContext.getRealPath("/WEB-INF/tiles.xml");
	            
	            String  filePath = "E:/MainLiveProjects/TSIMIS-LIVE-19092023/src/main/webapp/WEB-INF/tiles.xml";
	            
	            System.out.println("tilesXmlPath"+tilesXmlPath);
	            
	            System.out.println("filePath"+filePath);
	            
	            File file = new File(filePath);
	            FileOutputStream fop = null;
	          
	         // Read the existing content of the tiles.xml file
	            StringBuilder contentBuilder = new StringBuilder();
	            BufferedReader reader = new BufferedReader(new FileReader(file));
	            String line;
	            while ((line = reader.readLine()) != null) {
	                contentBuilder.append(line).append("\n");
	            }
	            reader.close();
	            String content = contentBuilder.toString();
	            
	         // Find the index of the closing </tiles-definitions> tag
	            int index = content.lastIndexOf("</tiles-definitions>");
	            
	            System.out.println("index"+index);

	            // Insert the new definition before the closing tag
	            StringBuilder updatedContentBuilder = new StringBuilder();
	            updatedContentBuilder.append(content, 0, index)
	                    .append(definition)
	                    .append("\n")
	                    .append(content, index, content.length());
	            String updatedContent = updatedContentBuilder.toString();
	            
	            System.out.println("Updated Content1:\n" + updatedContent);

	            // Write the modified content back to the tiles.xml file
	           // BufferedWriter writer = new BufferedWriter(new FileWriter(file));
	           // writer.write(updatedContent);
	          //  writer.close();
	            fop = new FileOutputStream(file);
	            byte[] contentInBytes = updatedContent.getBytes();
	            fop.write(contentInBytes);
                fop.flush();
                fop.close();
                
            
	            
	            System.out.println("Definition added to tiles.xml successfully.");
	           
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
    
	    
	    public static void createcustomjspfile (String jspFileName) {
	        // Specify the path to the folder where you want to create the JSP file
	        String folderPath = "E:/MainLiveProjects/TSIMIS-LIVE-19092023/src/main/webapp/jsp/header/";
	        
	        // Specify the name of the JSP file
	        String fileName = jspFileName;
	        
	        // Specify the content of the JSP file
	        String content = "<%@ page language=\"java\" contentType=\"text/html; charset=UTF-8\" pageEncoding=\"UTF-8\"%>\n"
	                        + "<!DOCTYPE html>\n"
	                        + "<html>\n"
	                        + "<head>\n"
	                        + "    <meta charset=\"UTF-8\">\n"
	                        + "    <title>Example JSP</title>\n"
	                        + "</head>\n"
	                        + "<body>\n"
	                        + "    <h1>Hello, World!</h1>\n"
	                        + "</body>\n"
	                        + "</html>";
	        
	        // Create the folder if it doesn't exist
	      /*  File folder = new File(folderPath);
	        if (!folder.exists()) {
	            folder.mkdirs(); // Create the folder and any necessary parent folders
	        }
	        */
	        // Create the JSP file
	        
	        File folder = new File(folderPath);
	        File file = new File(folder, fileName);
	        try (FileWriter writer = new FileWriter(file)) {
	            writer.write(content);
	            System.out.println("JSP file created successfully at: " + file.getAbsolutePath());
	        } catch (IOException e) {
	            System.err.println("Error creating JSP file: " + e.getMessage());
	        }
	    }
    
}

