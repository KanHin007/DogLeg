package com.hb.wallet.entity;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class WalletEntity {

    Long id;

    Long userId;

    BigDecimal total;

    BigDecimal freezed;

    BigDecimal usable;

    public static WalletEntity mock(){
        WalletEntity wallet =  new WalletEntity();
        wallet.setId(1L);
        wallet.setUserId(1L);
        wallet.setTotal(BigDecimal.TEN);
        wallet.setFreezed(BigDecimal.TEN);
        wallet.setUsable(BigDecimal.TEN);
        return wallet;
    }

}
