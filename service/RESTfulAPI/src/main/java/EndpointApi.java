public class EndpointApi {
    public static void main(){
        String siteId = "9dffc44b-1824-42a4-ac48-616e3f0eaa2a";
        String tagId = "31f35021-e656-472a-8937-9c6d6da76e6e";
        Long startTime = 1568563200000L;
        Long endTime = 1568573200000L;
        Integer iStartTime = 1567526400;
        Integer iEndTime = 1567527800;
        EndpointanlsOpenApiUtil apiUtil = new EndpointanlsOpenApiUtil();
        EndpointanlsOpenApiUtil.Tags tags =  apiUtil.new Tags(siteId, 20, 1);
        String tagsRes = tags.getRes();
        EndpointanlsOpenApiUtil.RealtimeFlow realtimeFlow =  apiUtil.new RealtimeFlow(siteId, tagId);
        String realtimeFlowRes = realtimeFlow.getRes();
        EndpointanlsOpenApiUtil.HistoryFlow historyFlow =  apiUtil.new HistoryFlow(startTime, endTime, siteId, tagId);
        String historyFlowRes = historyFlow.getRes();
        EndpointanlsOpenApiUtil.Loyalty loyalty =  apiUtil.new Loyalty("0", iStartTime, iEndTime, "day", tagId);
        String loyaltyRes = loyalty.getRes();
        EndpointanlsOpenApiUtil.DeviceTraffic deviceTraffic = apiUtil.new DeviceTraffic(siteId,"day",5,startTime,endTime);
        String deviceTrafficRes = deviceTraffic.getRes();
        EndpointanlsOpenApiUtil.SitesHealth sitesHealth = apiUtil.new SitesHealth(siteId);
        String sitesHealthRes = sitesHealth.getRes();
        EndpointanlsOpenApiUtil.TopNSsidTraffic topNSsidTraffic = apiUtil.new TopNSsidTraffic(siteId,startTime,endTime,"day","5","1");
        String topNSsidTrafficRes = topNSsidTraffic.getRes();

    }
}
