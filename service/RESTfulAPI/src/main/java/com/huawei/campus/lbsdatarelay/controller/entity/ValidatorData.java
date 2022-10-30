/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2019-2020. All rights reserved
 */

package com.huawei.campus.lbsdatarelay.controller.entity;

import lombok.Data;


@Data
public class ValidatorData  {
    //根据云平台要求的校验格式 新建entity类
    public String validator;
    public ValidatorData(String validator){
        this.validator = validator;
    }
}
