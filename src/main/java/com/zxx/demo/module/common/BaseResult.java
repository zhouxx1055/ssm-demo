package com.zxx.demo.module.common;

import com.zxx.demo.util.BaseResultError;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author zhouxx
 * @Description:
 * @date 2022/3/3  13:21
 */
@Data
@ToString
public class BaseResult implements Serializable {
    private int status;
    private Object data;
    private String msg;

    public BaseResult(){

    }
    public BaseResult(BaseResultError baseResultError){
        this.setStatus(baseResultError.getStatus());
        this.setMsg(baseResultError.getMsg());
    }
}
