package in.ts.icad.leagal.util;

import java.util.Enumeration;

import javax.servlet.ServletContext;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

public abstract class SecurityWebApplicationContextUtils extends WebApplicationContextUtils {
	public static WebApplicationContext findRequiredWebApplicationContext(ServletContext servletContext) {
		WebApplicationContext wac = _findWebApplicationContext(servletContext);
		if (wac == null) {
			throw new IllegalStateException("No WebApplicationContext found: no ContextLoaderListener registered?");
		}
		return wac;
	}

	private static WebApplicationContext _findWebApplicationContext(ServletContext sc) {
		WebApplicationContext wac = getWebApplicationContext(sc);
		if (wac == null) {
			Enumeration<String> attrNames = sc.getAttributeNames();
			while (attrNames.hasMoreElements()) {
				String attrName = attrNames.nextElement();
				Object attrValue = sc.getAttribute(attrName);
				if (attrValue instanceof WebApplicationContext) {
					if (wac != null) {
						throw new IllegalStateException("No unique WebApplicationContext found: more than one " +
								"DispatcherServlet registered with publishContext=true?");
					}
					wac = (WebApplicationContext) attrValue;
				}
			}
		}
		return wac;
	}

}
