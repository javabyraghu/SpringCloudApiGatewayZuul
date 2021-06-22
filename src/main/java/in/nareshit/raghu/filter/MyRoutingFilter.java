package in.nareshit.raghu.filter;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

@Component
public class MyRoutingFilter extends ZuulFilter {
	
	private static final Logger LOG = LoggerFactory.getLogger(MyRoutingFilter.class);

	public boolean shouldFilter() {
		return true;
	}

	public Object run() throws ZuulException {
		RequestContext context = RequestContext.getCurrentContext();
		HttpServletRequest request = context.getRequest();
		String auth = request.getHeader("Authorization");
		if(!StringUtils.hasText(auth)) {
			LOG.warn("SEND TO LOGIN SERVICE");
			//RequestDispatcher dispatcher = request.getRequestDispatcher(loginPath);
		} else {
			LOG.info("Nice! Authorization Found!!");
		}
		
		return null;
	}

	public String filterType() {
		return FilterConstants.ROUTE_TYPE;
	}

	public int filterOrder() {
		return 0;
	}

}
