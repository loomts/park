
/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2019-2020. All rights reserved
 */

package com.huawei.campus.lbsdatarelay.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.huawei.campus.lbsdatarelay.controller.entity.NceUploadData;
import com.huawei.campus.lbsdatarelay.controller.entity.ValidatorData;
import com.huawei.cloudcampus.api.ApiClient;
import com.huawei.cloudcampus.api.ApiException;
import com.huawei.cloudcampus.api.model.StationDataResp;
import com.huawei.cloudcampus.api.service.SiteManagerApi;
import com.huawei.cloudcampus.api.service.StationOpenApiApi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@RestController
@RequestMapping("/")
public class UrlController {

    @Autowired
    private Environment env;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ResponseBody
    public String GetRequest() throws JsonProcessingException {
        //在云平台请求时，返回数据格式为 {"validator":xxxxxxxx-xxxx-xxxx-xxxx-xxxxxxxxxxxx}
        //请在此编码
        ValidatorData validatorData = new ValidatorData(env.getProperty("validator"));
        System.out.println("validator : " + validatorData);
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(validatorData);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    @ResponseBody
    public String PostRequest(@RequestBody String body) throws IOException, ApiException {
        //将云平台上上报的终端位置信息解析并输出为csv文件
        //请在此编码
        System.out.println("PostBody : " + body);
        ObjectMapper mapper = new ObjectMapper();
        NceUploadData lbsEntity = mapper.readValue(body, NceUploadData.class);
        String TITLE_LINE = "terminalMac" + "," + "rssi" + "," + "timestamp" + "," + "apMac" + "," + "secret" + "," + "type";
        String terminalMac = "";
        String rssi = "";
        String timestamp = "";
        String apMac = "";
        String secret = lbsEntity.getSecret();
        String type = lbsEntity.getType();

        //校验secret与预设是否相符
        if (!secret.equals(env.getProperty("secret"))) {
            return body;
        }
        //新建csv文件
        File tempFile = new File("./" + new SimpleDateFormat("yyyyMMdd-HHmmss-SSSS").format(new Date()) + ".csv");
        BufferedWriter bw = new BufferedWriter(new FileWriter(tempFile, true));
        bw.write(TITLE_LINE);

        //将终端位置信息输出至csv文件，输出完成后关闭
        for (NceUploadData.ApUploadData data : lbsEntity.getData()) {
            apMac = data.getApMac();
            for (NceUploadData.TerminalData terminalData : data.getTerminalList()) {
                rssi = String.valueOf(terminalData.getRssi());
                terminalMac = terminalData.getTerminalMac();
                timestamp = String.valueOf(terminalData.getTimestamp());
                bw.newLine();
                bw.write(terminalMac + "," + rssi + "," + timestamp + "," + apMac + "," + secret + "," + type);
            }
        }
        bw.newLine();
        bw.flush();
        bw.close();


        //调用API查询AP接入的用户信息与终端流量
        //请在此编码
        ApiClient apiClient = new ApiClient();
        apiClient.setTenantName("c4_usr_202");
        apiClient.setTenantPwd("1qaz@WSX_202");
        apiClient.setHost("cn2.naas.huaweicloud.com");
        apiClient.setPort("18002");
        //根据Sitename查询siteId
        String siteName = "site01";
        SiteManagerApi siteManagerApi = new SiteManagerApi(apiClient);
        UUID siteId = UUID.fromString(siteManagerApi.querySites(1, 20, siteName).getData().get(0).getId());
        System.out.println("siteId : " + siteId);

        //将用户和流量信息打印出来
        StationOpenApiApi stationOpenApiApi = new StationOpenApiApi(apiClient);
        StationDataResp stationDataResp = stationOpenApiApi.querySiteStationInfo(siteId, 1, 20, null, null, null, null, null, null);

        System.out.println("START print traffic data");
        stationDataResp.getData().forEach((data) -> System.out.println("station traffic : " + data));
        System.out.println("Traffic END");

        return body;
    }
}
