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

    EndpointanlsOpenApiUtil() {
        super();
    }

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

    // 获取设备标签
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

    // 查询实时接入客户数量
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

    // 查询历史接入客户数量
    class HistoryFlow {
        private String res = null;

        HistoryFlow(Long startTime, Long endTime, String siteId, String tagId) {
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

        public String getRes() {
            return res;
        }
    }

    // 查询回头客记录
    class Loyalty {
        private String res = null;

        Loyalty(String tagType, Integer startTime, Integer endTime, String timeUnit, String tagId) {
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

        public String getRes() {
            return res;
        }
    }

    // 查询站点维度TopN设备或者所有设备的上行流量、下行流量
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

        public String getRes() {
            return res;
        }
    }

    // 基于站点的站点健康度查询
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

        public String getRes() {
            return res;
        }
    }

    // 查询TOP N SSID流量和最近在线用户数
    class TopNSsidTraffic {
        private String res = null;

        TopNSsidTraffic(String siteId, Long beginTime, Long endTime, String timeGranularity, String top, String deviceType) {
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

    // 查询访客驻留时长的历史趋势
    class DwellTime {
        private String res = null;

        DwellTime(String tagType, Integer startTime, Integer endTime, String timeUnit, String tagId) {
            gson = getGson();
            EndpointanlsOpenApiApi api = new EndpointanlsOpenApiApi(apiClient);
            try {
                // access api
                FlowDistrResp response = api.queryDwellTimeDistr(tagId, tagType, startTime, endTime, timeUnit);
                res = gson.toJson(response);
            } catch (ApiException e) {
                e.printStackTrace();
            }
        }

        public String getRes() {
            return res;
        }
    }

    // 查询站点维度下用户在线时长信息
    class TerminalStatistics {
        private String res = null;

        TerminalStatistics(String siteId) {
            gson = getGson();
            StationOpenApiApi api = new StationOpenApiApi(apiClient);
            try {
                // access api
                ClientStatisticalInfoDto response = api.queryTerminalStatistics(siteId);
                res = gson.toJson(response);
            } catch (ApiException e) {
                e.printStackTrace();
            }
        }

        public String getRes() {
            return res;
        }
    }

    // 查询单设备的性能数据
    class DeviceDetail {
        private String res = null;

        DeviceDetail(String deviceId) {
            gson = getGson();
            PerformanceOpenApiApi api = new PerformanceOpenApiApi(getApi());
            try {
                // access api
                UUID uDeviceId = UUID.fromString(deviceId);
                DevicePerformanceResp response = api.singleDevicePerformanceDetail(uDeviceId);
                String result = gson.toJson(response);
                System.out.println(result);
            } catch (ApiException e) {
                e.printStackTrace();
            }
        }

        public String getRes() {
            return res;
        }
    }
}
