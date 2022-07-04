import java.io.*;

import  net.sf.json.JSONObject;
/*
    一些显示在文档介绍显示有，但在样例没有
    多个功能可能只用一个函数
    迪士尼日流量：5000-100000（大部分在20000-50000）
*/
public class Main{
    //返回人数
    public static JSONObject getFlow(JSONObject jsonobject) throws IOException{
        String errcode = jsonobject.get("errcode").toString();
        String errmsg = jsonobject.get("errmsg").toString();
        String humanFlow = jsonobject.getJSONArray("data").get(0).toString();
        String reVisitedRate = jsonobject.getJSONArray("data").get(1).toString();
        JSONObject humanFlowObject = JSONObject.fromObject(humanFlow);
        JSONObject reVisitedRateObject = JSONObject.fromObject(reVisitedRate);
        String hCountsString=humanFlowObject.get("counts").toString();
        String rCountsString=reVisitedRateObject.get("counts").toString();
        JSONObject humanFlowCountsObject = JSONObject.fromObject(hCountsString.substring(1,hCountsString.length()-1));
        JSONObject reVisitedRateCountObject = JSONObject.fromObject(rCountsString.substring(1,rCountsString.length()-1));
        String humanFlowCount = humanFlowCountsObject.get("count").toString();
        String reVisitedRateCount = reVisitedRateCountObject.get("count").toString();
        String stamp = humanFlowCountsObject.get("stamp").toString();
        String returnStr="{" +
                            "humanFlow: "+humanFlowCount+","+
                            "reVisitedRate: "+reVisitedRateCount+","+
                            "stamp: "+stamp+
                        "}";
        return JSONObject.fromObject(returnStr); // 把字符串转成 JSONArray  对象
    }
    public static void convNowFlow(){
        FileInputStream fis = null;
        try {
            fis = new FileInputStream("src\\main\\in\\nowFlow.in");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.setIn(fis);
        PrintStream ps = null;
        try {
            ps = new PrintStream(new FileOutputStream("src\\main\\out\\nowFlow.out"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.setOut(ps);
        BufferedReader cin=new BufferedReader(new InputStreamReader(System.in));
        for(int i=1;i<=3600;i++){
            String str= null;
            try {
                str = cin.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            JSONObject jsonobject = JSONObject.fromObject(str);
            JSONObject endJson= null;
            try {
                endJson = getFlow(jsonobject);
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println(endJson);
        }
    }
    public static void convHistFlow(){
        FileInputStream fis = null;
        try {
            fis = new FileInputStream("src\\main\\in\\histFlow.in");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.setIn(fis);
        PrintStream ps = null;
        try {
            ps = new PrintStream(new FileOutputStream("src\\main\\out\\histFlow.out"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.setOut(ps);
        BufferedReader cin=new BufferedReader(new InputStreamReader(System.in));
        for(int i=1;i<=168;i++){
            String str= null;
            try {
                str = cin.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            JSONObject jsonobject = JSONObject.fromObject(str);
            JSONObject endJson= null;
            try {
                endJson = getFlow(jsonobject);
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println(endJson);
        }
    }
    public static void convSitesFlow(){
        FileInputStream fis = null;
        try {
            fis = new FileInputStream("src\\main\\in\\sitesFlow.in");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.setIn(fis);
        PrintStream ps = null;
        try {
            ps = new PrintStream(new FileOutputStream("src\\main\\out\\sitesFlow.out"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.setOut(ps);
        BufferedReader cin=new BufferedReader(new InputStreamReader(System.in));
        for(int i=1;i<=6;i++){
            String str= null;
            try {
                str = cin.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            JSONObject jsonobject = JSONObject.fromObject(str);
            JSONObject endJson= null;
            try {
                endJson = getFlow(jsonobject);
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println(endJson);
        }
    }
    //查询网络数据
    public static JSONObject getWlan(JSONObject jsonobject) throws IOException{
        String errcode=jsonobject.get("errcode").toString();
        String errmsg=jsonobject.get("errmsg").toString();
        String totalRecords=jsonobject.get("totalRecords").toString();
        String dataString=jsonobject.get("data").toString();
        JSONObject dataObject=JSONObject.fromObject(dataString.substring(1,dataString.length()-1));
        String timestamp=dataObject.get("timestamp").toString();
        String unit=dataObject.get("unit").toString();
        String uplinkRate=dataObject.get("uplinkRate").toString();
        String downlinkRate=dataObject.get("downlinkRate").toString();
        String returnStr="{" +
                "timestamp: "+timestamp+","+
                "unit: "+"\""+unit+"\""+","+
                "uplinkRate: "+uplinkRate+","+
                "downlinkRate: "+downlinkRate+
                "}";
        return JSONObject.fromObject(returnStr); // 把字符串转成 JSONArray  对象
    }
    public static void convWlan(){
        FileInputStream fis = null;
        try {
            fis = new FileInputStream("src\\main\\in\\sitesWlan.in");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.setIn(fis);
        PrintStream ps = null;
        try {
            ps = new PrintStream(new FileOutputStream("src\\main\\out\\sitesWlan.out"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.setOut(ps);
        BufferedReader cin=new BufferedReader(new InputStreamReader(System.in));
        for(int i=1;i<=6;i++){
            String str= null;
            try {
                str = cin.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            JSONObject jsonobject = JSONObject.fromObject(str);
            JSONObject endJson= null;
            try {
                endJson = getWlan(jsonobject);
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println(endJson);
        }
    }
    //查询设备流量
    public static JSONObject getDeviceFlow(JSONObject jsonobject) throws IOException{
        String errcode=jsonobject.get("errcode").toString();
        String errmsg=jsonobject.get("errmsg").toString();
        String dataString=jsonobject.get("data").toString();
        JSONObject dataObject=JSONObject.fromObject(dataString.substring(1,dataString.length()-1));
        String deviceId=dataObject.get("deviceId").toString();
        String deviceName=dataObject.get("deviceName").toString();
        String upTraffic=dataObject.get("upTraffic").toString();
        String downTraffic=dataObject.get("downTraffic").toString();
        String unit=dataObject.get("unit").toString();
        String returnStr="{" +
                "deviceId: "+"\""+deviceId+"\""+","+
                "deviceName: "+"\""+deviceName+"\""+","+
                "upTraffic: "+upTraffic+","+
                "downTraffic: "+downTraffic+","+
                "unit: "+"\""+unit+"\""+
                "}";
        return JSONObject.fromObject(returnStr); // 把字符串转成 JSONArray  对象
    }
    public static void convDeviceFlow(){
        FileInputStream fis = null;
        try {
            fis = new FileInputStream("src\\main\\in\\deviceTraffic.in");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.setIn(fis);
        PrintStream ps = null;
        try {
            ps = new PrintStream(new FileOutputStream("src\\main\\out\\deviceTraffic.out"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.setOut(ps);
        BufferedReader cin=new BufferedReader(new InputStreamReader(System.in));
        for(int i=1;i<=25;i++){
            String str= null;
            try {
                str = cin.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            JSONObject jsonobject = JSONObject.fromObject(str);
            JSONObject endJson= null;
            try {
                endJson = getDeviceFlow(jsonobject);
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println(endJson);
        }
    }

    //查询单个设备的的性能数据
    public static JSONObject getDeviceDetail(JSONObject jsonobject) throws IOException{
        String errcode=jsonobject.get("errcode").toString();
        String errmsg=jsonobject.get("errmsg").toString();
        String dataString=jsonobject.get("data").toString();
        JSONObject dataObject=JSONObject.fromObject(dataString.substring(1,dataString.length()-1));
        String id=dataObject.get("id").toString();
        String name=dataObject.get("name").toString();
        String esn=dataObject.get("esn").toString();
        String deviceIp=dataObject.get("deviceIp").toString();
        String neType=dataObject.get("neType").toString();
        String status=dataObject.get("status").toString();
        String gisLon=dataObject.get("gisLon").toString();
        String gisLat=dataObject.get("gisLat").toString();
        String traffic=dataObject.get("traffic").toString();
        String onlineUsers=dataObject.get("onlineUsers").toString();
        String cpuRate=dataObject.get("cpuRate").toString();
        String upwardSpeed=dataObject.get("upwardSpeed").toString();
        String downwardSpeed=dataObject.get("downwardSpeed").toString();
        String mac=dataObject.get("mac").toString();
        String returnStr="{" +
                "name: "+"\""+name+"\""+","+
                "gisLon: "+gisLon+","+
                "gisLat: "+gisLat+","+
                "traffic: "+traffic+","+
                "upwardSpeed: "+upwardSpeed+","+
                "downwardSpeed: "+downwardSpeed+","+
                "cpuRate: "+cpuRate+
                "}";
        return JSONObject.fromObject(returnStr); // 把字符串转成 JSONArray  对象
    }
    public static void convDeviceDetail(){
        FileInputStream fis = null;
        try {
            fis = new FileInputStream("src\\main\\in\\deviceDetail.in");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.setIn(fis);
        PrintStream ps = null;
        try {
            ps = new PrintStream(new FileOutputStream("src\\main\\out\\deviceDetail.out"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.setOut(ps);
        BufferedReader cin=new BufferedReader(new InputStreamReader(System.in));
        for(int i=1;i<=1e3;i++){
            String str= null;
            try {
                str = cin.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            JSONObject jsonobject = JSONObject.fromObject(str);
            JSONObject endJson= null;
            try {
                endJson = getDeviceDetail(jsonobject);
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println(endJson);
        }
    }
    //查询站点的的健康度
    public static JSONObject getSiteHealth(JSONObject jsonobject) throws IOException{
        String errcode=jsonobject.get("errcode").toString();
        String errmsg=jsonobject.get("errmsg").toString();
        String dataString=jsonobject.get("data").toString();
        JSONObject dataObject=JSONObject.fromObject(dataString.substring(1,dataString.length()-1));
        String siteId=dataObject.get("siteId").toString();
        String deviceHealth=dataObject.get("deviceHealth").toString();
        String radioHealth=dataObject.get("radioHealth").toString();
        String siteHealth=dataObject.get("siteHealth").toString();
        String returnStr="{" +
                "siteId: "+"\""+siteId+"\""+","+
                "deviceHealth: "+deviceHealth+","+
                "radioHealth: "+radioHealth+","+
                "siteHealth: "+siteHealth+
                "}";
        return JSONObject.fromObject(returnStr); // 把字符串转成 JSONArray  对象
    }
    public static void convSitesHealth(){
        FileInputStream fis = null;
        try {
            fis = new FileInputStream("src\\main\\in\\sitesHealth.in");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.setIn(fis);
        PrintStream ps = null;
        try {
            ps = new PrintStream(new FileOutputStream("src\\main\\out\\sitesHealth.out"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.setOut(ps);
        BufferedReader cin=new BufferedReader(new InputStreamReader(System.in));
        for(int i=1;i<=1e3;i++){
            String str= null;
            try {
                str = cin.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            JSONObject jsonobject = JSONObject.fromObject(str);
            JSONObject endJson= null;
            try {
                endJson = getSiteHealth(jsonobject);
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println(endJson);
        }
    }
    //查询站点内的各时长长度的用户数据
    public static JSONObject getSiteUserNumber(JSONObject jsonobject) throws IOException{
        String errcode=jsonobject.get("errcode").toString();
        String errmsg=jsonobject.get("errmsg").toString();
        String dataString=jsonobject.get("data").toString();
        JSONObject dataObject=JSONObject.fromObject(dataString);
        String exprWorse=dataObject.get("exprWorse").toString();
        String exprBad=dataObject.get("exprBad").toString();
        String exprGood=dataObject.get("exprGood").toString();
        String exprBetter=dataObject.get("exprBetter").toString();
        String oneHour=dataObject.get("oneHour").toString();
        String oneToTwoHour=dataObject.get("oneToTwoHour").toString();
        String twoToFourHour=dataObject.get("twoToFourHour").toString();
        String fourToSixHour=dataObject.get("fourToSixHour").toString();
        String sixToEightHour=dataObject.get("sixToEightHour").toString();
        String eightHour=dataObject.get("eightHour").toString();
        String returnStr="{" +
                "exprWorse: "+exprWorse+","+
                "exprBad: "+exprBad+","+
                "exprGood: "+exprGood+","+
                "exprBetter: "+exprBetter+","+
                "oneHour: "+oneHour+","+
                "oneToTwoHour: "+oneToTwoHour+","+
                "twoToFourHour: "+twoToFourHour+","+
                "fourToSixHour: "+fourToSixHour+","+
                "sixToEightHour: "+sixToEightHour+","+
                "eightHour: "+eightHour+
                "}";
        return JSONObject.fromObject(returnStr); // 把字符串转成 JSONArray  对象
    }
    public static void convSitesUserNumber(){
        FileInputStream fis = null;
        try {
            fis = new FileInputStream("src\\main\\in\\sitesUserNumber.in");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.setIn(fis);
        PrintStream ps = null;
        try {
            ps = new PrintStream(new FileOutputStream("src\\main\\out\\sitesUserNumber.out"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.setOut(ps);
        BufferedReader cin=new BufferedReader(new InputStreamReader(System.in));
        for(int i=1;i<=1e3;i++){
            String str= null;
            try {
                str = cin.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            JSONObject jsonobject = JSONObject.fromObject(str);
            JSONObject endJson= null;
            try {
                endJson = getSiteUserNumber(jsonobject);
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println(endJson);
        }
    }
    public static void main(String[] args) {
        convNowFlow();
        convHistFlow();
        convSitesFlow();
        convWlan();
        convDeviceFlow();
        convDeviceDetail();
        convSitesHealth();
        convSitesUserNumber();
    }
}
