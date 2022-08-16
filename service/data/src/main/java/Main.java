import java.io.*;
import  java.util.*;
import  net.sf.json.JSONObject;
/*
    一些显示在文档介绍显示有，但在样例没有
    多个功能可能只用一个函数
    迪士尼客流量：5000-100000（大部分在20000-50000） / 3

*/
public class Main{
    //返回人数
    public static JSONObject getFlow(JSONObject jsonobject) throws IOException{
        String errcode=jsonobject.get("errcode").toString();
        String errmsg=jsonobject.get("errmsg").toString();
        String dataString=jsonobject.get("data").toString();
        JSONObject dataObject=JSONObject.fromObject(dataString.substring(1,dataString.length()-1));
        String targetName=dataObject.get("targetName").toString();
        String countsString=dataObject.get("counts").toString();
        JSONObject countsObject=JSONObject.fromObject(countsString.substring(1,countsString.length()-1));
        String count=countsObject.get("count").toString();
        String ReVisitedRate=countsObject.get("ReVisitedRate").toString();
        String stamp=countsObject.get("stamp").toString();
        String returnStr="{" +
                            "count: "+count+","+
                            "ReVisitedRate: "+ReVisitedRate+
                        "}";
        return JSONObject.fromObject(returnStr); // 把字符串转成 JSONArray  对象
    }
    public static void test1(){
        String str="{" +
                "errcode: \"0.0\"," +
                "errmsg: \"\"," +
                "data: [" +
                "{" +
                "targetName: \"humanflow\"," +
                "counts: [" +
                "{" +
                "count: \"123.0\"," +
                "ReVisitedRate: \"0.0\"," +
                "stamp: 0" +
                "}" +
                "]" +
                "}" +
                "]" +
                "}";
        JSONObject jsonobject = JSONObject.fromObject(str);
        JSONObject endJson= null;
        try {
            endJson = getFlow(jsonobject);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(endJson.toString());
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
    public static void test2(){
        String str="{" +
                "errcode: \"0.0\"," +
                "errmsg: \"\"," +
                "totalRecords: 0," +
                "data: [" +
                "{" +
                "timestamp: 0," +
                "unit: \"bps\"," +
                "uplinkRate: 0," +
                "downlinkRate: 0" +
                "}" +
                "]" +
                "}";
        JSONObject jsonobject = JSONObject.fromObject(str);
        JSONObject endJson= null;
        try {
            endJson = getWlan(jsonobject);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(endJson.toString());
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
    public static void test3(){
        String str="{" +
                "errcode: \"0.0\"," +
                "errmsg: \"\"," +
                "data: [" +
                "{" +
                "deviceId: \"ea25fdbf-8dee-4823-bac2-5bfe8e3359ca\"," +
                "deviceName: \"device1\"," +
                "upTraffic: 0," +
                "downTraffic: 0," +
                "unit: \"Byte\"" +
                "}" +
                "]" +
                "}";
        JSONObject jsonobject = JSONObject.fromObject(str);
        JSONObject endJson= null;
        try {
            endJson = getDeviceFlow(jsonobject);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(endJson.toString());
    }
    //查询具体站点的历史人数
    public static JSONObject getSiteFlow(JSONObject jsonobject) throws IOException{
        String errcode=jsonobject.get("errcode").toString();
        String errmsg=jsonobject.get("errmsg").toString();
        String dataString=jsonobject.get("data").toString();
        JSONObject dataObject=JSONObject.fromObject(dataString.substring(1,dataString.length()-1));
        String timestamp=dataObject.get("timestamp").toString();
        String user24G=dataObject.get("user24G").toString();
        String user5G=dataObject.get("user5G").toString();
        String returnStr="{" +
                "timestamp: "+timestamp+","+
                "user24G: "+user24G+","+
                "user5G: "+user5G+
                "}";
        return JSONObject.fromObject(returnStr); // 把字符串转成 JSONArray  对象
    }
    public static void test4(){
        String str="{" +
                "errcode: \"0.0\"," +
                "errmsg: \"\"," +
                "data: [" +
                "{" +
                "timestamp: 0," +
                "user24G: 0," +
                "user5G: 0" +
                "}" +
                "]" +
                "}";
        JSONObject jsonobject = JSONObject.fromObject(str);
        JSONObject endJson= null;
        try {
            endJson = getSiteFlow(jsonobject);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(endJson.toString());
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
        System.out.println("insert into devicedetail values("+"\""+id+"\""+","+"\""+name+"\""+","+"\""+esn+"\""+","+"\""+deviceIp+"\""+","+"\""+neType+"\""+","+status+","+gisLon+","+gisLat+","+traffic+","+onlineUsers+","+cpuRate+","+upwardSpeed+","+downwardSpeed+","+"\""+mac+"\");");
        return JSONObject.fromObject(returnStr); // 把字符串转成 JSONArray  对象
    }
    public static void test5(){
        FileInputStream fis = null;
        try {
            fis = new FileInputStream("D:\\idea_project\\temp5-master\\temp3\\src\\main\\java\\test5.out");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.setIn(fis);
        PrintStream ps = null;
        try {
            ps = new PrintStream(new FileOutputStream("D:\\idea_project\\temp5-master\\temp3\\src\\main\\java\\test555.out"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.setOut(ps);
        BufferedReader cin=new BufferedReader(new InputStreamReader(System.in));
        for(int i=1;i<=1e2;i++){
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
            //System.out.println(endJson.toString());
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
        System.out.println("insert into siteHealth values("+"\""+siteId+"\""+","+deviceHealth+","+radioHealth+","+siteHealth+");");
        return JSONObject.fromObject(returnStr); // 把字符串转成 JSONArray  对象
    }
    public static void test6(){
        FileInputStream fis = null;
        try {
            fis = new FileInputStream("D:\\idea_project\\temp5-master\\temp3\\src\\main\\java\\test6.out");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.setIn(fis);
        PrintStream ps = null;
        try {
            ps = new PrintStream(new FileOutputStream("D:\\idea_project\\temp5-master\\temp3\\src\\main\\java\\test666.out"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.setOut(ps);
        BufferedReader cin=new BufferedReader(new InputStreamReader(System.in));
        for(int i=1;i<=1e2;i++){
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
            //System.out.println(endJson.toString());
        }
    }
    //查询站点内的各时长长度的用户数据
    public static JSONObject getSiteUserNumber(JSONObject jsonobject,int ind) throws IOException{
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
        System.out.println("insert into userNumber values("+"\""+ind+"\""+","+exprWorse+","+exprBad+","+exprGood+","+exprBetter+","+oneHour+","+oneToTwoHour+","+twoToFourHour+","+fourToSixHour+","+sixToEightHour+","+eightHour+");");
        return JSONObject.fromObject(returnStr); // 把字符串转成 JSONArray  对象
    }
    public static void test7(){
        FileInputStream fis = null;
        try {
            fis = new FileInputStream("D:\\idea_project\\temp5-master\\temp3\\src\\main\\java\\test7.out");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.setIn(fis);
        PrintStream ps = null;
        try {
            ps = new PrintStream(new FileOutputStream("D:\\idea_project\\temp5-master\\temp3\\src\\main\\java\\test777.out"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.setOut(ps);
        BufferedReader cin=new BufferedReader(new InputStreamReader(System.in));
        for(int i=1;i<=1e2;i++){
            String str= null;
            try {
                str = cin.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            JSONObject jsonobject = JSONObject.fromObject(str);
            JSONObject endJson= null;
            try {
                endJson = getSiteUserNumber(jsonobject,i);
            } catch (IOException e) {
                e.printStackTrace();
            }
            //System.out.println(endJson.toString());
        }
    }
    public static void main(String[] args) throws IOException {
        //test1();
        //test2();
        //test3();
        //test4();
        test5();
        test6();
        test7();
    }
}
