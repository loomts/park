import com.huawei.cloudcampus.api.ApiClient;
import com.huawei.cloudcampus.api.ApiException;
import com.huawei.cloudcampus.api.model.*;
import com.huawei.cloudcampus.api.service.*;
import com.google.gson.Gson;

import java.util.UUID;

public class EndpointanlsOpenApiUtil {
    // init Api
    private static final String tenantName = "c4_usr_202";
    private static final String tenantPwd = "1qaz@WSX_202";
    private static final String host = "cn2.naas.huaweicloud.com";
    private static final String port = "18002";
    private static ApiClient apiClient = null;
    private static Gson gson = null;

    public static ApiClient getApi() {
        if (apiClient == null) {
            apiClient = new ApiClient();
            apiClient.setTenantName(tenantName);
            apiClient.setTenantPwd(tenantPwd);
            apiClient.setHost(host);
            apiClient.setPort(port);
        }
        return apiClient;
    }

    public static Gson getGson() {
        if (gson == null)
            gson = new Gson();
        return gson;
    }

    class Tags {
        private String res = null;

        Tags(String siteId, Integer pageSize, Integer pageIndex) {
            EndpointanlsOpenApiApi api = new EndpointanlsOpenApiApi(getApi());
            Gson gson = getGson();
            try {
                // access api
                DeviceGroupTagResp response = api.getDeviceGroupTags(siteId, pageSize, pageIndex);
                res = gson.toJson(response);
            } catch (ApiException e) {
                e.printStackTrace();
            }
        }

        public String getRes() {
            return res;
        }
    }

    class RealtimeFlow {
        private String res = null;
        RealtimeFlow(String siteId, String tagId) {
            gson = getGson();
            EndpointanlsOpenApiApi api = new EndpointanlsOpenApiApi(getApi());
            try {
                // access api
                FlowDistrResp response = api.getRealtimeFlowDistr(siteId, tagId);
                res = gson.toJson(response);
            } catch (ApiException e) {
                e.printStackTrace();
            }
        }
        public String getRes() {
            return res;
        }
    }

    class HistoryFlow {
        private String res = null;

        HistoryFlow(Long startTime,Long endTime,String siteId,String tagId) {
            gson = getGson();
            EndpointanlsOpenApiApi api = new EndpointanlsOpenApiApi(getApi());
            try {
                // access api
                FlowDistrResp response = api.getHistoryFlowDistr(siteId, startTime, endTime, tagId);
                res = gson.toJson(response);
            } catch (ApiException e) {
                e.printStackTrace();
            }
        }
        public String getRes(){
            return res;
        }
    }

    class Loyalty {
        private String res = null;
        Loyalty(String tagType,Integer startTime,Integer endTime,String timeUnit,String tagId) {
            gson = getGson();
            EndpointanlsOpenApiApi api = new EndpointanlsOpenApiApi(getApi());
            try {
                // access api
                FlowDistrResp response = api.queryLoyaltyDistr(tagId, tagType, startTime, endTime, timeUnit);
                res = gson.toJson(response);
            } catch (ApiException e) {
                e.printStackTrace();
            }
        }
        public String getRes(){
            return res;
        }
    }

    class DeviceTraffic {
        private String res = null;
        DeviceTraffic(String siteId, String timeDimension, Integer top, Long beginTime, Long endTime) {
            gson = getGson();
            PerformanceOpenApiApi api = new PerformanceOpenApiApi(getApi());
            try {
                UUID siteUid = UUID.fromString(siteId);
                // access api
                DeviceTrafficStatisticResp response = api.queryDeviceTraffic(siteUid, timeDimension, top, beginTime, endTime);
                res = gson.toJson(response);
            } catch (
                    ApiException e) {
                e.printStackTrace();
            }
        }
        public String getRes(){
            return res;
        }
    }

    class SitesHealth {
        private String res = null;
        SitesHealth(String siteId) {
            gson = getGson();
            PerformanceOpenApiApi api = new PerformanceOpenApiApi(getApi());
            try {
                // access api
                SiteHealthOutputDto response = api.querySiteHealthList(siteId);
                res = gson.toJson(response);
            } catch (ApiException e) {
                e.printStackTrace();
            }
        }
        public String getRes(){
            return res;
        }
    }

    class TopNSsidTraffic {
        private String res = null;
        TopNSsidTraffic(String siteId,Long beginTime,Long endTime,String timeGranularity,String top,String deviceType) {
            gson = getGson();
            PerformanceOpenApiApi api = new PerformanceOpenApiApi(getApi());
            try {

                // access api
                TopNSSIDTrafficListDto response = api.queryTopNSSIDTraffic(siteId, beginTime, endTime, timeGranularity, top, deviceType);
                res = gson.toJson(response);
            } catch (ApiException e) {
                e.printStackTrace();
            }
        }

        public String getRes() {
            return res;
        }
    }
}
