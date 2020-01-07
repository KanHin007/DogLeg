package com.hb.user.controller;

import com.hb.common.resp.HttpResp;
import com.hb.user.entity.UserEntity;
import com.hb.user.form.UserForm;
import com.hb.wallet.entity.WalletEntity;
import com.hb.wallet.feign.WalletFeignClient;
import com.hb.wallet.form.WalletForm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

@Slf4j
@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    WalletFeignClient walletFeignClient;


    @PostMapping("/getById")
    public HttpResp<UserEntity> getUserById(@RequestBody UserForm userForm){
        log.info("userForm is {}",userForm);
        UserEntity userEntity = UserEntity.mock();
        WalletForm walletForm = new WalletForm();
        walletForm.setUserId(userEntity.getId());
        HttpResp<WalletEntity> httpResp =  walletFeignClient.getByUserId(walletForm);
        WalletEntity walletEntity = httpResp.getModel();
        if(httpResp.getCode() != HttpServletResponse.SC_OK && walletEntity == null){
            throw new RuntimeException("调用出错");
        }else{
            userEntity.setWallet(walletEntity);
        }

        return HttpResp.success(userEntity);
    }


}
