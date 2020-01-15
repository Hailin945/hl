package com.hl.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author Hailin
 * @date 2019/12/27
 */
@Component
public class PerFilter extends ZuulFilter {

    @Override
    public String filterType() {
        return FilterTypeEnum.PRE.getCode();
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();
        System.out.println(String.format("%s %s", request.getMethod(), request.getRequestURL()));
        String token = request.getParameter("token");
        if (token == null || "".equals(token)) {
            requestContext.setSendZuulResponse(false);
            requestContext.setResponseStatusCode(401);
            try {
                requestContext.getResponse().getWriter().write("token不可为空");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("success");
        return null;
    }
}
