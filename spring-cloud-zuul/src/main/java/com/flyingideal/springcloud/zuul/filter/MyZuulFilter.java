package com.flyingideal.springcloud.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author yanchao
 * @date 2019/3/13 21:15
 */
@Component
public class MyZuulFilter extends ZuulFilter {

    private static final Logger logger = LoggerFactory.getLogger(MyZuulFilter.class);
    /**
     * 返回一个字符串代表过滤器的类型，在zuul中定义了四种不同生命周期的过滤器类型，具体如下：
     *    pre：    路由之前
     *    routing：路由之时
     *    post：   路由之后
     *    error：  发送错误调用
     * @return     过滤器的类型
     */
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * 过滤器的顺序
     * @return  过滤器顺序值
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * 可以写逻辑判断，是否要过滤，返回true表示永远过滤
     * @return  true
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * 过滤器具体逻辑，可以连接数据库等
     * @return
     * @throws ZuulException
     */
    @Override
    public Object run() throws ZuulException {
        RequestContext context = RequestContext.getCurrentContext();
        HttpServletRequest request = context.getRequest();
        logger.info("Executing {} method, URL is {}!", request.getMethod(), request.getRequestURL().toString());
        Object accessToken = request.getParameter("token");
        if (accessToken == null) {
            String message = "token is empty";
            logger.warn(message);
            context.setSendZuulResponse(false);
            context.setResponseStatusCode(401);
            try {
                context.getResponse().getWriter().write(message);
            } catch (IOException exception) {
                logger.error("Response Error!");
            }
            return null;
        }
        logger.info("Filter success executed!");
        return null;
    }
}
