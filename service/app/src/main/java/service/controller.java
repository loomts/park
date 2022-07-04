package service;

import java.io.*;

import com.sun.net.httpserver.*;

import java.net.InetSocketAddress;

public class controller {
    public static void main(String[] args) throws Exception {
        HttpServer server = HttpServer.create(new InetSocketAddress(2333), 0);
        server.createContext("/", new hello());
        server.createContext("/hello", new hello());
        server.createContext("/deviceDetail", new deviceDetailHandler());
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
            FileInputStream fis = new FileInputStream("src\\main\\out\\deviceDetail.out");
            System.setIn(fis);
            BufferedReader cin = new BufferedReader(new InputStreamReader(System.in));
            StringBuilder sb = new StringBuilder();
            for (int i = 1; i <= 1000; i++) {
                String str = null;
                try {
                    str = cin.readLine();
//                    System.out.println(str);
                    sb.append(str).append("\n");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            String response = sb.toString();
            t.getResponseHeaders().set("Content-Type", "application/json");
            t.sendResponseHeaders(200, response.length());
            OutputStream os = t.getResponseBody();
            os.write(response.getBytes());
            os.close();
        }
    }

    static class deviceTrafficHandler implements HttpHandler {
        public void handle(HttpExchange t) throws IOException {
            FileInputStream fis = new FileInputStream("src\\main\\out\\deviceTraffic.out");
            System.setIn(fis);
            BufferedReader cin = new BufferedReader(new InputStreamReader(System.in));
            StringBuilder sb = new StringBuilder();
            for (int i = 1; i <= 25; i++) {
                String str = null;
                try {
                    str = cin.readLine();
//                    System.out.println(str);
                    sb.append(str).append("\n");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            String response = sb.toString();
            t.getResponseHeaders().set("Content-Type", "application/json");
            t.sendResponseHeaders(200, response.length());
            OutputStream os = t.getResponseBody();
            os.write(response.getBytes());
            os.close();
        }
    }

    static class histFlowHandler implements HttpHandler {
        public void handle(HttpExchange t) throws IOException {
            FileInputStream fis = new FileInputStream("src\\main\\out\\histFlow.out");
            System.setIn(fis);
            BufferedReader cin = new BufferedReader(new InputStreamReader(System.in));
            StringBuilder sb = new StringBuilder();
            for (int i = 1; i <= 168; i++) {
                String str = null;
                try {
                    str = cin.readLine();
                    sb.append(str).append("\n");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            String response = sb.toString();
            t.getResponseHeaders().set("Content-Type", "application/json");
            t.sendResponseHeaders(200, response.length());
            OutputStream os = t.getResponseBody();
            os.write(response.getBytes());
            os.close();
        }
    }

    static class nowFlowHandler implements HttpHandler {
        public void handle(HttpExchange t) throws IOException {
            FileInputStream fis = new FileInputStream("src\\main\\out\\nowFlow.out");
            System.setIn(fis);
            BufferedReader cin = new BufferedReader(new InputStreamReader(System.in));
            StringBuilder sb = new StringBuilder();
            for (int i = 1; i <= 3600; i++) {
                String str = null;
                try {
                    str = cin.readLine();
//                    System.out.println(str);
                    sb.append(str).append("\n");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            String response = sb.toString();
            t.getResponseHeaders().set("Content-Type", "application/json");
            t.sendResponseHeaders(200, response.length());
            OutputStream os = t.getResponseBody();
            os.write(response.getBytes());
            os.close();
        }
    }

    static class sitesFlowHandler implements HttpHandler {
        public void handle(HttpExchange t) throws IOException {
            FileInputStream fis = new FileInputStream("src\\main\\out\\sitesFlow.out");
            System.setIn(fis);
            BufferedReader cin = new BufferedReader(new InputStreamReader(System.in));
            StringBuilder sb = new StringBuilder();
            for (int i = 1; i <= 6; i++) {
                String str = null;
                try {
                    str = cin.readLine();
//                    System.out.println(str);
                    sb.append(str).append("\n");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            String response = sb.toString();
            t.getResponseHeaders().set("Content-Type", "application/json");
            t.sendResponseHeaders(200, response.length());
            OutputStream os = t.getResponseBody();
            os.write(response.getBytes());
            os.close();
        }
    }

    static class sitesHealthHandler implements HttpHandler {
        public void handle(HttpExchange t) throws IOException {
            FileInputStream fis = new FileInputStream("src\\main\\out\\sitesHealth.out");
            System.setIn(fis);
            BufferedReader cin = new BufferedReader(new InputStreamReader(System.in));
            StringBuilder sb = new StringBuilder();
            for (int i = 1; i <= 1000; i++) {
                String str = null;
                try {
                    str = cin.readLine();
//                    System.out.println(str);
                    sb.append(str).append("\n");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            String response = sb.toString();
            t.getResponseHeaders().set("Content-Type", "application/json");
            t.sendResponseHeaders(200, response.length());
            OutputStream os = t.getResponseBody();
            os.write(response.getBytes());
            os.close();
        }
    }

    static class sitesUserNumberHandler implements HttpHandler {
        public void handle(HttpExchange t) throws IOException {
            FileInputStream fis = new FileInputStream("src\\main\\out\\sitesUserNumber.out");
            System.setIn(fis);
            BufferedReader cin = new BufferedReader(new InputStreamReader(System.in));
            StringBuilder sb = new StringBuilder();
            for (int i = 1; i <= 1000; i++) {
                String str = null;
                try {
                    str = cin.readLine();
//                    System.out.println(str);
                    sb.append(str).append("\n");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            String response = sb.toString();
            t.getResponseHeaders().set("Content-Type", "application/json");
            t.sendResponseHeaders(200, response.length());
            OutputStream os = t.getResponseBody();
            os.write(response.getBytes());
            os.close();
        }
    }

    static class sitesWlanHandler implements HttpHandler {
        public void handle(HttpExchange t) throws IOException {
            FileInputStream fis = new FileInputStream("src\\main\\out\\sitesWlan.out");
            System.setIn(fis);
            BufferedReader cin = new BufferedReader(new InputStreamReader(System.in));
            StringBuilder sb = new StringBuilder();
            for (int i = 1; i <= 6; i++) {
                String str = null;
                try {
                    str = cin.readLine();
//                    System.out.println(str);
                    sb.append(str).append("\n");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            String response = sb.toString();
            t.getResponseHeaders().set("Content-Type", "application/json");
            t.sendResponseHeaders(200, response.length());
            OutputStream os = t.getResponseBody();
            os.write(response.getBytes());
            os.close();
        }
    }
}
