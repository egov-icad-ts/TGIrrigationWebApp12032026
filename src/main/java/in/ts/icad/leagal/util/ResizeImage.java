package in.ts.icad.leagal.util;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

import org.springframework.web.multipart.MultipartFile;

public class ResizeImage {
	
	 public static void resize(MultipartFile inputimageFile,
	            String outputImagePath, int scaledWidth, int scaledHeight)
	            throws IOException {
	        // reads input image
	      //  File inputFile = new File(inputImagePath);
		// FileMultipartData part =  new FileMultipartData();
		// part.getFileMultipart().get(0).getByteStream();
		 
		
		 //InputStream inputStream = inputimageFile.getInputStream();
		 
		
		
		/// System.out.println("inputStream"+inputimageFile.getInputStream());
		 
		 byte [] byteArr=inputimageFile.getBytes();
		 InputStream inputStream = new ByteArrayInputStream(byteArr);
	        BufferedImage inputImage = javax.imageio.ImageIO.read(inputStream);
	        
	       // System.out.println("inputImage"+inputImage);
	 
	        // creates output image
	        
	       // System.out.println("scaledWidth"+scaledWidth);
	      //  System.out.println("scaledHeight"+scaledHeight);
	       // System.out.println("inputImage.getType()"+inputImage.getType());
	        BufferedImage outputImage = new BufferedImage(scaledWidth, scaledHeight, inputImage.getType());
	 
	        // scales the input image to the output image
	        Graphics2D g2d = outputImage.createGraphics();
	        g2d.drawImage(inputImage, 0, 0, scaledWidth, scaledHeight, null);
	        g2d.dispose();
	 
	        // extracts extension of output file
	        String formatName = outputImagePath.substring(outputImagePath.lastIndexOf(".") + 1);
	 
	        // writes to output file
	        ImageIO.write(outputImage, formatName, new File(outputImagePath));
	    }
	    
	

}
