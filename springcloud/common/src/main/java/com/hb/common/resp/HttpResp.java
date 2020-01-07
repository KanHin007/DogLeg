package com.hb.common.resp;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author lawrence
 * @param <T>
 */
@Data
@NoArgsConstructor
public class HttpResp<T> {

    private static final int OK_STATUS = 200;

    private static final String OK_STR = "调用成功";

    private static final int ERROR_STATUS = 500;

  //  private static final String OK_STR = "调用成功";

    private int code;

    private String msg;

    private T model;

    public HttpResp(int code, String msg, T model) {
        this.code = code;
        this.msg = msg;
        this.model = model;
    }



    public static <T> HttpResp<T> success(T model){
        return new HttpResp<>(OK_STATUS,OK_STR,model);
    }

    public static <T> HttpResp<T> error(Exception e){
        return new HttpResp<>(ERROR_STATUS,e.getMessage(),null);
    }
}
