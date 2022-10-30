package service;

import java.io.*;

import com.alibaba.fastjson.JSON;
import com.sun.net.httpserver.*;
import org.apache.commons.io.IOUtils;
import database.Utils;

import java.net.InetSocketAddress;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class controller {
    public static void main(String[] args) throws Exception {
        HttpServer server = HttpServer.create(new InetSocketAddress(2333), 0);
//        server.createContext("/", new hello());
        server.createContext("/hello", new hello());
        server.createContext("/portalTraveller", new portalTravellerHandler());
        server.createContext("/unportalTraveller", new unportalTravellerHandler());
        server.createContext("/exceptionManage", new exceptionManageHandler());
        server.createContext("/disinfectionInformation", new disinfectionInformationHandler());
        server.createContext("/flowWarning", new flowWarningHandler());
        server.createContext("/APFailure", new APFailureHandler());
        server.createContext("/deviceDetail", new deviceDetailHandler());
        server.createContext("/deviceDetailByName", new deviceDetailByNameHandler());
        server.createContext("/deviceTraffic", new deviceTrafficHandler());
        server.createContext("/histFlow", new histFlowHandler());
        server.createContext("/nowFlow", new nowFlowHandler());
        server.createContext("/sitesFlow", new sitesFlowHandler());
        server.createContext("/sitesHealth", new sitesHealthHandler());
        server.createContext("/sitesUserNumber", new sitesUserNumberHandler());
        server.createContext("/sitesWlan", new sitesWlanHandler());
        server.setExecutor(null);
        System.out.println("Starting server on port: 2333");
        server.start();
    }

    public static String getLimitString(HttpExchange t) {
        String postString = null;
        try {
            postString = IOUtils.toString(t.getRequestBody());
        } catch (IOException e) {
            e.printStackTrace();
        }
        Map<String, String> postInfo = formData2Dic(postString);
        String QueryKey = "", QueryValue = "";
        Collection<String> keys = postInfo.keySet();
        Collection<String> cvalues = postInfo.values();
        Iterator<String> iterk = keys.iterator();
        Iterator<String> itery = cvalues.iterator();
        if (iterk.hasNext()) {
            QueryKey = iterk.next().toString();
        }
        if (itery.hasNext()) {
            QueryValue = itery.next().toString();
        }
        if (QueryValue == "") return "";
        return "where " + QueryKey + " = " + "'" + QueryValue + "'";
    }

    public static String getLimitStringByName(HttpExchange t) {
        String postString = null;
        try {
            postString = IOUtils.toString(t.getRequestBody());
        } catch (IOException e) {
            e.printStackTrace();
        }
        Map<String, String> postInfo = formData2Dic(postString);
        String QueryKey = "", QueryValue = "";
        Collection<String> keys = postInfo.keySet();
        Collection<String> cvalues = postInfo.values();
        Iterator<String> iterk = keys.iterator();
        Iterator<String> itery = cvalues.iterator();
        if (iterk.hasNext()) {
            QueryKey = iterk.next().toString();
        }
        if (itery.hasNext()) {
            QueryValue = itery.next().toString();
        }
        if (QueryValue == "") return "order by name";
        return "where " + QueryKey + " like " + "'%" + QueryValue + "%' order by name";
    }

    public static void OSwrite(HttpExchange t, List res) throws IOException {
        String response = JSON.toJSONString(res);
        t.getResponseHeaders().set("Content-Type", "application/json");
        t.getResponseHeaders().set("Access-Control-Allow-Origin", "*");
        try {
            t.sendResponseHeaders(200, response.length());
        } catch (IOException e) {
            e.printStackTrace();
        }
        OutputStream os = t.getResponseBody();
        os.write(response.getBytes());
        os.close();
    }

    public static Map<String, String> formData2Dic(String formData) {
        Map<String, String> result = new HashMap<>();
        if (formData == null || formData.trim().length() == 0) {
            return result;
        }
        final String[] items = formData.split("&");
        Arrays.stream(items).forEach(item -> {
            final String[] keyAndVal = item.split("=");
            if (keyAndVal.length == 2) {
                final String key = URLDecoder.decode(keyAndVal[0], StandardCharsets.UTF_8);
                final String val = URLDecoder.decode(keyAndVal[1], StandardCharsets.UTF_8);
                result.put(key, val);
            }
        });
        return result;
    }

    static class hello implements HttpHandler {
        public void handle(HttpExchange t) throws IOException {
            String response = "Hello, World!";
            t.getResponseHeaders().set("Content-Type", "application/json");
            t.sendResponseHeaders(200, response.length());
            OutputStream os = t.getResponseBody();
            os.write(response.getBytes());
            os.close();
        }
    }

    static class portalTravellerHandler implements HttpHandler {
        public void handle(HttpExchange t) throws IOException {
            String res = "[" +
                    "        {" +
                    "          id: '1'," +
                    "          IPAddress: '192.168.2.105'," +
                    "          userGroup: '无线组——华为手机'," +
                    "          ifPortal: '已认证'," +
                    "          visitTime: '2022-07-02 20:27:30'," +
                    "        }," +
                    "        {" +
                    "          id: '2'," +
                    "          IPAddress: '192.168.1.108'," +
                    "          userGroup: 'R&D——BRUSE电脑'," +
                    "          ifPortal: '已认证'," +
                    "          visitTime: '2022-07-02 19:16:07'," +
                    "        }," +
                    "        {" +
                    "          id: '3'," +
                    "          IPAddress: '192.168.2.35'," +
                    "          userGroup: '无线组——iPhone'," +
                    "          ifPortal: '已认证'," +
                    "          visitTime: '2022-07-02 19:03:52'," +
                    "        }," +
                    "        {" +
                    "          id: '4'," +
                    "          IPAddress: '192.168.3.141'," +
                    "          userGroup: '无线组——华为手机'," +
                    "          ifPortal: '已认证'," +
                    "          visitTime: '2022-07-02 18:55:48'," +
                    "        }," +
                    "        {" +
                    "          id: '5'," +
                    "          IPAddress: '192.168.1.33'," +
                    "          userGroup: '无线组——荣耀手机'," +
                    "          ifPortal: '已认证'," +
                    "          visitTime: '2022-07-02 18:47:03'," +
                    "        }," +
                    "        {" +
                    "          id: '6'," +
                    "          IPAddress: '192.168.3.76'," +
                    "          userGroup: 'R&D——BRUSE电脑'," +
                    "          ifPortal: '已认证'," +
                    "          visitTime: '2022-07-02 18:44:27'," +
                    "        }," +
                    "        {" +
                    "          id: '7'," +
                    "          IPAddress: '192.168.3.9'," +
                    "          userGroup: '无线组——小米手机'," +
                    "          ifPortal: '已认证'," +
                    "          visitTime: '2022-07-02 18:42:11'," +
                    "        }," +
                    "        {" +
                    "          id: '8'," +
                    "          IPAddress: '192.168.2.104'," +
                    "          userGroup: '无线组——OPPO手机'," +
                    "          ifPortal: '已认证'," +
                    "          visitTime: '2022-07-02 18:31:09'," +
                    "        }," +
                    "      ]";
            //res = "[{\"cpuRate\":43,\"name\":\"device12\",\"upwardSpeed\":8328.6,\"gisLon\":121.0,\"downwardSpeed\":8454.0,\"deviceId\":\"vx21yffl-7ryd-3000-oqd6-6san53rox36l\",\"gisLat\":31.2,\"traffic\":5713.6}]";
            String response = res;
            //String response = JSON.toJSONString(JSON.parseObject(res));
            t.getResponseHeaders().set("Content-Type", "application/json");
            t.getResponseHeaders().set("Access-Control-Allow-Origin", "*");
            try {
                t.sendResponseHeaders(200, response.length());
            } catch (IOException e) {
                e.printStackTrace();
            }
            OutputStream os = t.getResponseBody();
            os.write(response.getBytes());
            os.close();
        }
    }

    static class unportalTravellerHandler implements HttpHandler {
        public void handle(HttpExchange t) throws IOException {
            String res = "[" +
                    "{" +
                    "id:'1'," +
                    "IPAddress:'192.168.2.45'," +
                    "userGroup:'无线组——iPhone'," +
                    "ifPortal:'未认证'," +
                    "visitTime:'2022-07-02 21:15:58'," +
                    "}," +
                    "{" +
                    "id:'2'," +
                    "IPAddress:'192.168.3.103'," +
                    "userGroup:'无线组——OPPO手机'," +
                    "ifPortal:'未认证'," +
                    "visitTime:'2022-07-02 19:56:03'," +
                    "}," +
                    "{" +
                    "id:'3'," +
                    "IPAddress:'192.168.1.48'," +
                    "userGroup:'无线组——iPhone'," +
                    "ifPortal:'未认证'," +
                    "visitTime:'2022-07-02 19:48:01'," +
                    "}," +
                    "{" +
                    "id:'4'," +
                    "IPAddress:'192.168.2.61'," +
                    "userGroup:'无线组——华为手机'," +
                    "ifPortal:'未认证'," +
                    "visitTime:'2022-07-02 18:37:27'," +
                    "}," +
                    "{" +
                    "id:'5'," +
                    "IPAddress:'192.168.3.84'," +
                    "userGroup:'R&D——Tina电脑'," +
                    "ifPortal:'未认证'," +
                    "visitTime:'2022-07-02 18:20:18'," +
                    "}," +
                    "{" +
                    "id:'6'," +
                    "IPAddress:'192.168.1.15'," +
                    "userGroup:'R&D——BRUSE电脑'," +
                    "ifPortal:'未认证'," +
                    "visitTime:'2022-07-02 18:15:29'," +
                    "}," +
                    "{" +
                    "id:'7'," +
                    "IPAddress:'192.168.2.17'," +
                    "userGroup:'无线组——小米手机'," +
                    "ifPortal:'未认证'," +
                    "visitTime:'2022-07-02 18:13:52'," +
                    "}," +
                    "{" +
                    "id:'8'," +
                    "IPAddress:'192.168.1.88'," +
                    "userGroup:'无线组——华为手机'," +
                    "ifPortal:'未认证'," +
                    "visitTime:'2022-07-02 18:11:35'," +
                    "}," +
                    "]";
            String response = res;
            t.getResponseHeaders().set("Content-Type", "application/json");
            t.getResponseHeaders().set("Access-Control-Allow-Origin", "*");
            try {
                t.sendResponseHeaders(200, response.length());
            } catch (IOException e) {
                e.printStackTrace();
            }
            OutputStream os = t.getResponseBody();
            os.write(response.getBytes());
            os.close();
        }
    }

    static class exceptionManageHandler implements HttpHandler {
        public void handle(HttpExchange t) throws IOException {
            String res = "[" +
                    "        {" +
                    "          priority: 'P1'," +
                    "          date: '2022-07-02'," +
                    "          time: '06:22'," +
                    "          place: '探险岛'," +
                    "          way: '3281'," +
                    "          reason: '人群过密'," +
                    "        }," +
                    "        {" +
                    "          priority: 'P1'," +
                    "          date: '2022-07-02'," +
                    "          time: '09:22'," +
                    "          place: '明日世界'," +
                    "          way: '6341'," +
                    "          reason: '人群过密'," +
                    "        }," +
                    "        {" +
                    "          priority: 'P2'," +
                    "          date: '2022-07-02'," +
                    "          time: '09:25'," +
                    "          place: '梦幻世界'," +
                    "          way: '1201'," +
                    "          reason: '小范围聚集'," +
                    "        }," +
                    "        {" +
                    "          priority: 'P1'," +
                    "          date: '2022-07-02'," +
                    "          time: '12:22'," +
                    "          place: '梦幻世界'," +
                    "          way: '5287'," +
                    "          reason: '人群过密'," +
                    "        }," +
                    "        {" +
                    "          priority: 'P2'," +
                    "          date: '2022-07-02'," +
                    "          time: '19:22'," +
                    "          place: '奇想花园'," +
                    "          way: '6701'," +
                    "          reason: '小范围聚集'," +
                    "        }," +
                    "        {" +
                    "          priority: 'P1'," +
                    "          date: '2022-07-02'," +
                    "          time: '06:22'," +
                    "          place: '探险岛'," +
                    "          way: '3281'," +
                    "          reason: '人群过密'," +
                    "        }," +
                    "        {" +
                    "          priority: 'P1'," +
                    "          date: '2022-07-02'," +
                    "          time: '09:22'," +
                    "          place: '明日世界'," +
                    "          way: '6341'," +
                    "          reason: '人群过密'," +
                    "        }," +
                    "        {" +
                    "          priority: 'P2'," +
                    "          date: '2022-07-02'," +
                    "          time: '09:25'," +
                    "          place: '梦幻世界'," +
                    "          way: '1201'," +
                    "          reason: '小范围聚集'," +
                    "        }," +
                    "        {" +
                    "          priority: 'P1'," +
                    "          date: '2022-07-02'," +
                    "          time: '12:22'," +
                    "          place: '梦幻世界'," +
                    "          way: '5287'," +
                    "          reason: '人群过密'," +
                    "        }," +
                    "        {" +
                    "          priority: 'P2'," +
                    "          date: '2022-07-02'," +
                    "          time: '19:22'," +
                    "          place: '奇想花园'," +
                    "          way: '6701'," +
                    "          reason: '小范围聚集'," +
                    "        }," +
                    "      ]";
            String response = res;
            t.getResponseHeaders().set("Content-Type", "application/json");
            t.getResponseHeaders().set("Access-Control-Allow-Origin", "*");
            try {
                t.sendResponseHeaders(200, response.length());
            } catch (IOException e) {
                e.printStackTrace();
            }
            OutputStream os = t.getResponseBody();
            os.write(response.getBytes());
            os.close();
        }
    }

    static class disinfectionInformationHandler implements HttpHandler {
        public void handle(HttpExchange t) throws IOException {
            String res = "[" +
                    "        {" +
                    "          date: '2022-07-02'," +
                    "          time: '...'," +
                    "          place: '探险岛'," +
                    "          way: '...'," +
                    "          people: '...'," +
                    "          result: '尚未完成！'," +
                    "        }," +
                    "        {" +
                    "          date: '2022-07-02'," +
                    "          time: '17:45'," +
                    "          place: '明日世界'," +
                    "          way: '喷洒'," +
                    "          people: '小张'," +
                    "          result: '消毒完成'," +
                    "        }," +
                    "        {" +
                    "          date: '2022-07-02'," +
                    "          time: '17:42'," +
                    "          place: '奇想花园'," +
                    "          way: '喷洒'," +
                    "          people: '小黄'," +
                    "          result: '消毒完成'," +
                    "        }," +
                    "        {" +
                    "          date: '2022-07-02'," +
                    "          time: '17:37'," +
                    "          place: '梦幻世界'," +
                    "          way: '喷洒'," +
                    "          people: '小甘'," +
                    "          result: '消毒完成'," +
                    "        }," +
                    "        {" +
                    "          date: '2022-07-02'," +
                    "          time: '17:30'," +
                    "          place: '皮克斯玩具总动员'," +
                    "          way: '喷洒'," +
                    "          people: '小郑'," +
                    "          result: '消毒完成'," +
                    "        }," +
                    "        {" +
                    "          date: '2022-07-02'," +
                    "          time: '17:30'," +
                    "          place: '宝藏湾'," +
                    "          way: '喷洒'," +
                    "          people: '小陆'," +
                    "          result: '消毒完成'," +
                    "        }," +
                    "      ]";
            String response = res;
            t.getResponseHeaders().set("Content-Type", "application/json");
            t.getResponseHeaders().set("Access-Control-Allow-Origin", "*");
            try {
                t.sendResponseHeaders(200, response.length());
            } catch (IOException e) {
                e.printStackTrace();
            }
            OutputStream os = t.getResponseBody();
            os.write(response.getBytes());
            os.close();
        }
    }

    static class flowWarningHandler implements HttpHandler {
        public void handle(HttpExchange t) throws IOException {
            String res = "[" +
                    "        {" +
                    "          priority: 'P1'," +
                    "          date: '2022-07-02'," +
                    "          time: '16:45'," +
                    "          place: '接入耗时过久'," +
                    "          number: 'User327'," +
                    "          reason: '奇想花园'," +
                    "        }," +
                    "        {" +
                    "          priority: 'P1'," +
                    "          date: '2022-07-02'," +
                    "          time: '14:42'," +
                    "          place: '接入耗时过久'," +
                    "          number: 'User109'," +
                    "          reason: '奇想花园'," +
                    "        }," +
                    "        {" +
                    "          priority: 'P1'," +
                    "          date: '2022-07-02'," +
                    "          time: '13:32'," +
                    "          place: '漫游达标率过低'," +
                    "          number: 'User531'," +
                    "          reason: '明日世界'," +
                    "        }," +
                    "        {" +
                    "          priority: 'P1'," +
                    "          date: '2022-07-02'," +
                    "          time: '10:51'," +
                    "          place: 'AP上传速率出现异常'," +
                    "          number: 'User017'," +
                    "          reason: '探险岛'," +
                    "        }," +
                    "        {" +
                    "          priority: 'P1'," +
                    "          date: '2022-07-02'," +
                    "          time: '10:05'," +
                    "          place: '接入耗时过久'," +
                    "          number: 'User629'," +
                    "          reason: '奇想花园'," +
                    "        }," +
                    "      ]";
            String response = res;
            t.getResponseHeaders().set("Content-Type", "application/json");
            t.getResponseHeaders().set("Access-Control-Allow-Origin", "*");
            try {
                t.sendResponseHeaders(200, response.length());
            } catch (IOException e) {
                e.printStackTrace();
            }
            OutputStream os = t.getResponseBody();
            os.write(response.getBytes());
            os.close();
        }
    }

    static class APFailureHandler implements HttpHandler {
        public void handle(HttpExchange t) throws IOException {
            String res = "[" +
                    "        {" +
                    "          priority: 'P1'," +
                    "          date: '2022-07-02'," +
                    "          time: '17:45'," +
                    "          way: '探险岛'," +
                    "          id: '距离不当'," +
                    "          area: '疑似盗窃'," +
                    "        }," +
                    "        {" +
                    "          priority: 'P1'," +
                    "          date: '2022-07-02'," +
                    "          time: '16:45'," +
                    "          way: '探险岛'," +
                    "          id: '距离不当'," +
                    "          area: '疑似盗窃'," +
                    "        }," +
                    "        {" +
                    "          priority: 'P1'," +
                    "          date: '2022-07-02'," +
                    "          time: '13:22'," +
                    "          way: '明日世界'," +
                    "          id: '设备故障'," +
                    "          area: '极速光轮操纵按键失灵'," +
                    "        }," +
                    "        {" +
                    "          priority: 'P1'," +
                    "          date: '2022-07-02'," +
                    "          time: '12:41'," +
                    "          way: '梦幻世界'," +
                    "          id: '设备故障'," +
                    "          area: '晶彩奇航受雨暂停营业'," +
                    "        }," +
                    "        {" +
                    "          priority: 'P1'," +
                    "          date: '2022-07-02'," +
                    "          time: '10:45'," +
                    "          way: 'P3停车场'," +
                    "          id: '设备故障'," +
                    "          area: '升降杆损坏'," +
                    "        }," +
                    "        {" +
                    "          priority: 'P1'," +
                    "          date: '2022-07-02'," +
                    "          time: '10:25'," +
                    "          way: '奇想花园'," +
                    "          id: '游客纠纷'," +
                    "          area: '游客出现争吵'," +
                    "        }," +
                    "      ]";
            String response = res;
            t.getResponseHeaders().set("Content-Type", "application/json");
            t.getResponseHeaders().set("Access-Control-Allow-Origin", "*");
            try {
                t.sendResponseHeaders(200, response.length());
            } catch (IOException e) {
                e.printStackTrace();
            }
            OutputStream os = t.getResponseBody();
            os.write(response.getBytes());
            os.close();
        }
    }


    static class deviceDetailHandler implements HttpHandler {
        public void handle(HttpExchange t) throws IOException {
            String limitString = getLimitString(t);
            List res = Utils.deviceDetail(limitString);
            OSwrite(t, res);
        }
    }

    static class deviceDetailByNameHandler implements HttpHandler {
        public void handle(HttpExchange t) throws IOException {
            String limitString = getLimitStringByName(t);
            List res = Utils.deviceDetail(limitString);
            OSwrite(t, res);
        }
    }

    static class deviceTrafficHandler implements HttpHandler {
        public void handle(HttpExchange t) throws IOException {
            String limitString = getLimitString(t);
            List res = Utils.deviceTraffic(limitString);
            OSwrite(t, res);
        }
    }

    static class histFlowHandler implements HttpHandler {
        public void handle(HttpExchange t) throws IOException {
            String limitString = getLimitString(t);
            List res = Utils.histFlow(limitString);
            OSwrite(t, res);
        }
    }

    static class nowFlowHandler implements HttpHandler {
        public void handle(HttpExchange t) throws IOException {
            String limitString = getLimitString(t);
            List res = Utils.nowFlow(limitString);
            OSwrite(t, res);
        }
    }

    static class sitesFlowHandler implements HttpHandler {
        public void handle(HttpExchange t) throws IOException {
            String limitString = getLimitString(t);
            List res = Utils.siteFlow(limitString);
            OSwrite(t, res);
        }
    }

    static class sitesHealthHandler implements HttpHandler {
        public void handle(HttpExchange t) throws IOException {
            String limitString = getLimitString(t);
            List res = Utils.siteHealth(limitString);
            OSwrite(t, res);
        }
    }

    static class sitesUserNumberHandler implements HttpHandler {
        public void handle(HttpExchange t) throws IOException {
            String limitString = getLimitString(t);
            List res = Utils.siteUserNumber(limitString);
            OSwrite(t, res);
        }
    }

    static class sitesWlanHandler implements HttpHandler {
        public void handle(HttpExchange t) throws IOException {
            String limitString = getLimitString(t);
            List res = Utils.siteWlan(limitString);
            OSwrite(t, res);
        }
    }

}
