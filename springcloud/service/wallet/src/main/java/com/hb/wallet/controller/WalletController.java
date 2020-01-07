package com.hb.wallet.controller;

import com.hb.common.resp.HttpResp;
import com.hb.wallet.entity.WalletEntity;
import com.hb.wallet.form.WalletForm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@Slf4j
@RestController
@RequestMapping("/api/wallet")
public class WalletController {


    @PostMapping("getByUserId")
    public HttpResp<WalletEntity> getWalletByUserId(@RequestBody WalletForm walletForm) {
        log.info("walletForm is {}", walletForm);
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return HttpResp.success(WalletEntity.mock());
    }


}
