package com.zxx.demo.module.dto;

import lombok.Data;
import lombok.ToString;

import java.util.Date;

/**
 * @author zhouxx
 * @Description:
 * @date 2022/3/3  16:37
 */
@Data
@ToString
public class BaseDto {

    private Date beginTime;
    private Date endTime;
}
