package com.hb.zuul.filter;

import com.hb.common.crypto.JwtUtils;
import com.hb.common.resp.HttpResp;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import java.io.IOException;
import java.util.Date;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_TYPE;

@Component
@Slf4j
public class JwtFilter extends ZuulFilter {

    @Resource
    RedisTemplate redisTemplate;


    public static final String LOGIN_URL = "/user-service/api/user/login";

    @Override
    public String filterType() {
        return PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return 4;
    }

    @Override
    public boolean shouldFilter() {
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();
        //设置需要拦截的路径
        if (LOGIN_URL.equalsIgnoreCase(request.getRequestURI())) {

            //放行
            return false;
        }
        //拦住了
        return true;
    }

    @Override
    public Object run() throws ZuulException {

        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();
        String token = request.getHeader("Authorization");

        String errorMessage = null;


        if (token == null || "".equals(token.trim())) {
            errorMessage = "token为空";
        } else {

            Claims claims = JwtUtils.parseToken(token);
            if (claims == null) {
                errorMessage = "token有问题";
            } else {


                Date exp = claims.getExpiration();
                if (exp.before(new Date())) {
                    errorMessage = "token已过期";
                } else if (!claims.getSubject().equals(JwtUtils.SUBJECT)) {
                    errorMessage = "token解密出现问题";
                } else if (redisTemplate.opsForValue().get(claims.getId()) == null) {
                    errorMessage = "token已经失效，请重新登录";
                }
            }


        }

        if (StringUtils.isNotBlank(errorMessage)) {
            requestContext.setSendZuulResponse(false);
            requestContext.getResponse().setContentType("application/json;charset=utf-8");
            try {
                requestContext.getResponse().getWriter().write("{\"code\": -1,\"message\": \"" + errorMessage + "\"}");
            } catch (IOException e) {
                e.printStackTrace();
            }

        }


        return null;
    }
}
