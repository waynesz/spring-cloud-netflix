package com.terry;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/***
 * *
 * 名称：     ErrorFilter.
 * 作者：     Terry Tan
 * 创建时间：  on 2017/7/7.
 * 说明：     
 * *
 ***/

@Component
public class ErrorFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return "error";
    }

    @Override
    public int filterOrder() {
        return 10;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    private static final Logger logger = LoggerFactory.getLogger(MyFilter.class);

    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        Throwable throwable = ctx.getThrowable();
        logger.error("ddddfff : {}", throwable.toString());
//        ctx.set("error.status_code", HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
//        ctx.set("error.exception", throwable.getCause());
        return null;
    }
}
