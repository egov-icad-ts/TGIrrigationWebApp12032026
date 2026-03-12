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



public class CaptchaGenServlet2 extends HttpServlet {

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

        	String captchaStr2="";
        	
        	//System.out.println("In captcha");
            	
        	captchaStr2=UtilCaptcha.generateCaptchaTextMethod3(2);
            	        

            try {

            	int width=100;     	int height=40;
            	
            	Color bg = new Color(0,255,255);
            	Color fg = new Color(0,100,0);
            	
            	Font font = new Font("Arial", Font.BOLD, 20);
            	BufferedImage cpimg2 =new BufferedImage(width,height,BufferedImage.OPAQUE);
            	Graphics g2 = cpimg2.createGraphics();

            	g2.setFont(font);
                g2.setColor(bg);
                g2.fillRect(0, 0, width, height);
                g2.setColor(fg);
            	g2.drawString(captchaStr2,10,25);   
            	
                HttpSession session2 = request.getSession();
                session2.setAttribute("CAPTCHA2", captchaStr2);
               

               OutputStream outputStream2 = response.getOutputStream();
                   
               ImageIO.write(cpimg2, FILE_TYPE, outputStream2);
               outputStream2.close();
               
              // System.out.println("captchaStr2"+captchaStr2);
               
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
