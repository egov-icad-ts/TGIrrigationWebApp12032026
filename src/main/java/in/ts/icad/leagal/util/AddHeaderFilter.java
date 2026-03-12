package in.ts.icad.leagal.util;

import java.io.IOException;


import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.filter.OncePerRequestFilter;

public class AddHeaderFilter extends OncePerRequestFilter {

    private static final Logger LOG = LoggerFactory.getLogger(AddHeaderFilter.class);
    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response, FilterChain filterChain)throws ServletException, IOException {
    	 String sessionid=request.getSession().getId();
    	 
    	 String uri=request.getRequestURI();
    	 
    	// System.out.println("uri"+uri);
    	 
    	 
            response.setHeader("X-XSS-Protection", "1; mode=block");
            response.setHeader("Strict-Transport-Security", "max-age=0; includeSubDomains"); 
            response.setHeader("X-Content-Type-Options", "nosniff"); 
            response.setHeader("Cache-control", "no-store, no-cache"); 
            response.setHeader("X-Frame-Options", "DENY"); 
           // response.setHeader("Set-Cookie", "XSRF-TOKEN=NDKDdfdsfkldsfNd3SZAJfwLsTl5WUgOkE; Path=/; Secure;HttpOnly");
   /* added */ //  max-age=31536000    response.addHeader("Content-Security-Policy", "connect-src");
            
           response.addHeader("Content-Security-Policy", "connect-src 'self' https://irrigationpms.cgg.gov.in");

   /* added */           response.addHeader("X-Permitted-Cross-Domain-Policies", "none");
            response.setHeader("Set-Cookie", "JSESSIONID="+sessionid+"; Path=/; Secure;HttpOnly; SameSite=Strict");
            filterChain.doFilter(request, response);

         //   LOG.info("Exit: AddHeaderFilter");


    }
	

}
