package com.hb.wallet.feign.callback;

import com.hb.common.resp.HttpResp;
import com.hb.wallet.entity.WalletEntity;
import com.hb.wallet.feign.WalletFeignClient;
import com.hb.wallet.form.WalletForm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class WalletFiegnClientFallback implements WalletFeignClient {
    @Override
    public HttpResp<WalletEntity> getByUserId(WalletForm walletForm) {
        log.error("触发了熔断器");
        return new HttpResp<WalletEntity>(200,"",null);
    }
}
