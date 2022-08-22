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
