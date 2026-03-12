package in.ts.icad.leagal.util;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.servlet.http.*;

import java.io.*;



public class CaptchaGenServlet3 extends HttpServlet {

         /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		public static final String FILE_TYPE = "jpeg";
      
        @Override
        protected void doPost(HttpServletRequest request, HttpServletResponse response)
                        throws ServletException, IOException {

            response.setHeader("Cache-Control", "no-cache");
            response.setDateHeader("Expires", 0);
            response.setHeader("Pragma", "no-cache");
            response.setDateHeader("Max-Age", 0);
            response.setContentType("image/jpeg");

        	String captchaStr3="";
        	
        	//System.out.println("In captcha");
            	
        	captchaStr3=UtilCaptcha.generateCaptchaTextMethod3(2);
            	        

            try {

            	int width=100;     	int height=40;
            	
            	Color bg = new Color(0,255,255);
            	Color fg = new Color(0,100,0);
            	
            	Font font = new Font("Arial", Font.BOLD, 20);
            	BufferedImage cpimg3 =new BufferedImage(width,height,BufferedImage.OPAQUE);
            	Graphics g3 = cpimg3.createGraphics();

            	g3.setFont(font);
                g3.setColor(bg);
                g3.fillRect(0, 0, width, height);
                g3.setColor(fg);
            	g3.drawString(captchaStr3,10,25);   
            	
                HttpSession session3 = request.getSession();
                session3.setAttribute("CAPTCHA3", captchaStr3);
               

               OutputStream outputStream3 = response.getOutputStream();
                   
               ImageIO.write(cpimg3, FILE_TYPE, outputStream3);
               outputStream3.close();
               
              //System.out.println("captchaStr3"+captchaStr3);
               
            } catch (Exception e) {
                    e.printStackTrace();
            }
        }



        @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response)
                        throws ServletException, IOException {
        	doPost(request, response);
        }

        
       
       
  

}
