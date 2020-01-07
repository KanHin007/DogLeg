package com.hb.user.controller;

import com.hb.common.constant.RedisConstant;
import com.hb.common.crypto.JwtUtils;
import com.hb.common.resp.HttpResp;
import com.hb.user.form.LoginForm;
import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.Objects;

@Slf4j
@RestController
@RequestMapping("/api/user")
public class LoginController {

    @Resource
    RedisTemplate redisTemplate;


    @PostMapping("login")
    public HttpResp login(@RequestBody LoginForm loginForm) {
        if (Objects.equals("123456789", loginForm.getPhone()) && Objects.equals("123456789", loginForm.getPassword())) {
            String token = (String) redisTemplate.opsForValue().get(RedisConstant.USER_TOKEN_KEY + 7);
            boolean needGen = false;
            if (token != null) {
                Claims claims = JwtUtils.parseToken(token);
                if (claims.getExpiration().before(new Date())) {
                    redisTemplate.delete(RedisConstant.USER_TOKEN_KEY + 7);
                    needGen = true;
                }
            } else {
                needGen = true;
            }
            if(needGen){
                token = JwtUtils.generateToken(7L);
            }
            // 存入Redis
            redisTemplate.opsForValue().set(RedisConstant.USER_TOKEN_KEY + 7, token);
            return HttpResp.success(token);
        }
        return HttpResp.error(new Exception("登陆失败"));
    }


    @PostMapping("logout")
    public HttpResp login(HttpServletRequest request) {
        Long userId = (Long) request.getAttribute("userId");
        if (userId != null) {
            redisTemplate.delete(RedisConstant.USER_TOKEN_KEY + userId);
        }
        return HttpResp.success(null);
    }

}
