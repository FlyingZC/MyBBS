package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EncodingFilter implements Filter {
	private String characterEncoding;
	//在web.xml中配置是否使用该Filter
	private boolean enabled;
	public void init(FilterConfig config) throws ServletException {
		characterEncoding=config.getInitParameter("characterEncoding");
		enabled="true".equalsIgnoreCase(config.getInitParameter("enabled").trim());
	}

	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		if(enabled&&characterEncoding!=null){
			req.setCharacterEncoding(characterEncoding);
			resp.setCharacterEncoding(characterEncoding);
		}
		chain.doFilter(req, resp);
	}

	public void destroy() {
		characterEncoding=null;
	}
}
