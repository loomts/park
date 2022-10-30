/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2019-2020. All rights reserved
 */

package com.huawei.campus.lbsdatarelay.controller.entity;


import lombok.Data;

import java.util.List;

@Data
public class NceUploadData {


    //根据云平台上报数据格式创建entity类
    private List<ApUploadData> data;
    private String secret;
    private String type;


    @Data
    public static class ApUploadData {
        private String apMac;
        private List<TerminalData> terminalList;
        public String getApMac(){
            return new ApUploadData().apMac;
        }
        public List<TerminalData> getTerminalList(){
            return new ApUploadData().terminalList;
        }
    }


    @Data
    public static class TerminalData {
        private int rssi;
        private String terminalMac;
        private Long timestamp;
        public int getRssi(){
            return rssi;
        }
        public String getTerminalMac(){
            return terminalMac;
        }
        public Long getTimestamp(){
            return timestamp;
        }
    }

    public List<ApUploadData> getData(){
        return data;
    }
    public String getSecret(){
        return secret;
    }
    public String getType(){
        return type;
    }
}
