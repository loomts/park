public class EndpointApi {
    EndpointApi(){
        String siteId = "e5917eda-cce2-4658-9d01-c52694cd774f";
        String tagId = "31f35021-e656-472a-8937-9c6d6da76e6e";
        String deviceId = "ea25fdbf-8dee-4823-bac2-5bfe8e3359ca";
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
        EndpointanlsOpenApiUtil.DwellTime dwellTime = apiUtil.new DwellTime("0",iStartTime,iEndTime,"day",tagId);
        String dwellTimeRes = dwellTime.getRes();
        EndpointanlsOpenApiUtil.TerminalStatistics terminalStatistics = apiUtil.new TerminalStatistics(siteId);
        String terminalStatisticsRes = terminalStatistics.getRes();
        EndpointanlsOpenApiUtil.DeviceDetail deviceDetail = apiUtil.new DeviceDetail(deviceId);
        String deviceDetailRes = deviceDetail.getRes();
        System.out.println(tagsRes);
        System.out.println(realtimeFlowRes);
        System.out.println(historyFlowRes);
        System.out.println(loyaltyRes);
        System.out.println(deviceTrafficRes);
        System.out.println(sitesHealthRes);
        System.out.println(topNSsidTrafficRes);
        System.out.println(dwellTimeRes);
        System.out.println(terminalStatisticsRes);
        System.out.println(deviceDetailRes);
    }
    public static void main(String[]args){
        new EndpointApi();
    }
}
