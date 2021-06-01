package in.nareshit.raghu.filter;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

@Component
public class MyRequestFilter extends ZuulFilter {
	
	private static final Logger LOG = LoggerFactory.getLogger(MyRequestFilter.class);

	public boolean shouldFilter() {
		return true;
	}
	
	public Object run() throws ZuulException {
		RequestContext context = RequestContext.getCurrentContext();
		
		HttpServletRequest request = context.getRequest();
		LOG.info("URL => " + request.getRequestURL());
		LOG.info("HEADER => " + request.getHeaderNames());
		LOG.info("METHOD => " + request.getMethod());
		
		return null;
		//return context;
	}
	
	public String filterType() {
		//return "pre";
		return FilterConstants.PRE_TYPE;
	}
	
	public int filterOrder() {
		return 0;
	}
}
