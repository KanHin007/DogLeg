package com.hb.wallet.feign;

import com.hb.common.resp.HttpResp;
import com.hb.wallet.entity.WalletEntity;
import com.hb.wallet.feign.callback.WalletFiegnClientFallback;
import com.hb.wallet.form.WalletForm;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "wallet-service",fallback = WalletFiegnClientFallback.class)
public interface WalletFeignClient {

    String WALLET_BASE_URL = "/api/wallet/";

    @PostMapping(WALLET_BASE_URL + "/getByUserId")
    HttpResp<WalletEntity> getByUserId(@RequestBody WalletForm walletForm);

}
