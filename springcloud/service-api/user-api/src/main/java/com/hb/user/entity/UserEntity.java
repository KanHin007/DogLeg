package com.hb.user.entity;

import com.hb.wallet.entity.WalletEntity;
import lombok.Data;

import java.util.Date;

@Data
public class UserEntity {


    private Long id;

    private String name;

    private Date createTime;

    private Date updateTime;

    public static UserEntity mock(){
        UserEntity userEntity = new UserEntity();
        userEntity.setId(1L);
        userEntity.setName("hanbin");
        Date now = new Date();
        userEntity.setCreateTime(now);
        userEntity.setUpdateTime(now);
        return userEntity;
    }

    private WalletEntity wallet;

}
