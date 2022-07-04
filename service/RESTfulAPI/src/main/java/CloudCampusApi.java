
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.HttpClientConnectionManager;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

import javax.websocket.Endpoint;

public class CloudCampusApi {
        public static void main(String[] args) throws IOException, JSONException, KeyStoreException, NoSuchAlgorithmException, KeyManagementException {

            String nbiName ="c4_usr_202";
            String nbiPwd = "1qaz@WSX_202";
            String host = "cn2.naas.huaweicloud.com";
            String port = "18002";
            String tokenId = "";
            final String USERNAME = "userName";
            final String PASSWORD = "password";
            final String POST_TOKEN_URL = "/controller/v2/tokens";
            final String GET_SITES_URL = "/controller/campus/v3/sites?pageIndex=0&pageSize=20";


            HttpClientBuilder custom = HttpClients.custom();

            //设置HTTPS忽略证书校验
            SSLContextBuilder builder = new SSLContextBuilder();
            builder.loadTrustMaterial(null, (X509Certificate[] x509Certificates, String s) -> true);
            SSLConnectionSocketFactory socketFactory = new SSLConnectionSocketFactory(builder.build(), new String[]{"SSLv2Hello", "SSLv3", "TLSv1", "TLSv1.2"}, null, NoopHostnameVerifier.INSTANCE);
            Registry<ConnectionSocketFactory> registry = RegistryBuilder.<ConnectionSocketFactory>create()
                    .register("http", new PlainConnectionSocketFactory())
                    .register("https", socketFactory).build();
            HttpClientConnectionManager connManager = new PoolingHttpClientConnectionManager(registry);
            custom.setConnectionManager(connManager);

            CloseableHttpClient httpclient = custom.build();

            //设置POST的URL,Header和超时时间
            String postTokenUrl = "https://" + host + ":" + port + POST_TOKEN_URL;
            HttpPost postToken = new HttpPost(postTokenUrl);

            postToken.setHeader("Content-Type", "application/json");
            postToken.setHeader("Accept","application/json");

            RequestConfig requestConfig = RequestConfig.custom()
                    .setConnectTimeout(5 * 1000).setConnectionRequestTimeout(5 * 1000)
                    .setSocketTimeout(3 * 1000).setRedirectsEnabled(true).build();
            postToken.setConfig(requestConfig);

            //设置POST的json内容(用户名密码)
            JSONObject jsonObject = new JSONObject();
            jsonObject.put(USERNAME, nbiName);
            jsonObject.put(PASSWORD, nbiPwd);
            String json = jsonObject.toString();
            StringEntity jsonEntity = new StringEntity(json);
            postToken.setEntity(jsonEntity);


            //发起Post请求并解析出token_id
            HttpResponse postResponse = httpclient.execute(postToken);
            HttpEntity entity = postResponse.getEntity();
            String responseStr = EntityUtils.toString(entity);
            System.out.println(responseStr);
            if (HttpStatus.SC_OK == postResponse.getStatusLine().getStatusCode()) {
                System.out.println("----------------------------------------");
                System.out.println("1.【Get TokenId】");
                System.out.println("【PostURL】:"+postTokenUrl);
                JSONObject jsonResponse = new JSONObject(responseStr);
                tokenId = jsonResponse.getJSONObject("data").getString("token_id");
                System.out.println("【TokenId】:"+tokenId);
                System.out.println("----------------------------------------");
            }

            //设置GET的URL,Header和超时时间（注意tokenId需要加入）
            String getSitesUrl = "https://" + host + ":" + port + GET_SITES_URL;
            HttpGet getSites = new HttpGet(getSitesUrl);
            getSites.setHeader("Content-Type", "application/json");
            getSites.setHeader("Accept","application/json");
            getSites.setHeader("X-AUTH-TOKEN",tokenId);
            getSites.setConfig(requestConfig);

            //发起Get请求并展示结果
            HttpResponse getResponse = httpclient.execute(getSites);
            entity = getResponse.getEntity();
            responseStr = EntityUtils.toString(entity);
            System.out.println(responseStr);
            if (HttpStatus.SC_OK == getResponse.getStatusLine().getStatusCode()) {
                System.out.println("----------------------------------------");
                System.out.println("2.【Get Sites Info】");
                System.out.println("【GetURL】:"+getSitesUrl);
                JSONObject jsonResponse = new JSONObject(responseStr);
                int totalRecords = jsonResponse.getInt("totalRecords");
                System.out.println("【TotalRecords】:"+totalRecords);
                System.out.println(responseStr);
                System.out.println("----------------------------------------");
            }
            EndpointApi endpointApi = new EndpointApi();
            httpclient.close();
        }

}
