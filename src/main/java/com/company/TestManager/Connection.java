package com.company.TestManager;

import com.company.TestManager.TestAPIs._2Login.LoginResponse;
import com.company.constants.AccountConstants;
import com.company.constants.EndpointConstants;
import com.company.constants.HttpMethod;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;


// class chứa các phương thức cần thiết để gửi request đến server
public class Connection {
    private static StringBuilder createQueryString(HashMap<String, String> params) {
        if (params == null) return new StringBuilder();
        StringBuilder query = new StringBuilder();
        for (Map.Entry<String, String> param : params.entrySet()) {
            if (query.length() != 0) {
                query.append('&');
            }
            query.append(URLEncoder.encode(param.getKey(), StandardCharsets.UTF_8));
            query.append('=');
            query.append(URLEncoder.encode(String.valueOf(param.getValue()), StandardCharsets.UTF_8));
        }
        return query;
    }

    private static HttpURLConnection createHttpConnection(String fullURLString, HttpMethod httpMethod, String accessToken) throws IOException {
        URL url = new URL(fullURLString);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod(httpMethod.name());
        connection.setInstanceFollowRedirects(true);
        HttpURLConnection.setFollowRedirects(true);
        if (accessToken != null) connection.setRequestProperty("Authorization", "Bearer " + accessToken);
        return connection;
    }

    private static <T> T getResponseData(HttpURLConnection connection, byte[] postDataBytes, Class<T> cl, String accessToken) throws IOException {
        if (connection.getRequestMethod().equals(HttpMethod.POST.name()) && postDataBytes != null) {
            connection.setDoOutput(true);
            DataOutputStream writer = new DataOutputStream(connection.getOutputStream());
            writer.write(postDataBytes);
            writer.flush();
            writer.close();
        }
        String line;
        StringBuilder content = new StringBuilder();
        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        while ((line = in.readLine()) != null) {
            content.append(line);
            content.append(System.lineSeparator());
        }
//        System.out.println(content);
        in.close();
        try {
            return new Gson().fromJson(content.toString(), cl);
        } catch (JsonSyntaxException ignored) {
            Document doc = convertStringToXMLDocument(content.toString());
            if (doc == null) return null;
            String redirectURL = ((Element) doc.getElementsByTagName("a").item(0)).getAttribute("href");
            return sendGetRequest(redirectURL, null, cl, accessToken);
        }
    }

    private static Document convertStringToXMLDocument(String xmlString) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder;
        try {
            builder = factory.newDocumentBuilder();
            return builder.parse(new InputSource(new StringReader(xmlString)));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    //    phương thức gửi post request cần dùng ở các class khác
    public static <T> T sendPostRequest(String fullURLString, HashMap<String, String> params, Class<T> cl, String accessToken) throws IOException {
        HttpURLConnection connection = Connection.createHttpConnection(fullURLString, HttpMethod.POST, accessToken);
        byte[] requestBytes = createQueryString(params).toString().getBytes(StandardCharsets.UTF_8);
        T res = getResponseData(connection, requestBytes, cl, accessToken);
        connection.disconnect();
        return res;
    }

    public static <T> T sendPostRequest(String fullURLString, HashMap<String, String> params, Class<T> cl) throws IOException {
        return sendPostRequest(fullURLString, params, cl, null);
    }


    //    phương thức gửi get request cần dùng ở các class khác
    public static <T> T sendGetRequest(String fullURLString, HashMap<String, String> params, Class<T> cl, String accessToken) throws IOException {
        HttpURLConnection connection = Connection.createHttpConnection(fullURLString + "?" + createQueryString(params), HttpMethod.GET, accessToken);
        T res = getResponseData(connection, null, cl, accessToken);
        connection.disconnect();
        return res;
    }

    public static <T> T sendGetRequest(String fullURLString, HashMap<String, String> params, Class<T> cl) throws IOException {
        return sendGetRequest(fullURLString, params, cl, null);
    }

    public static String getAccessToken(String baseUrl, String email, String password) {
        try {
            HashMap<String, String> tempParams = new HashMap<>();
            tempParams.put("email", email);
            tempParams.put("password", password);
            LoginResponse res = Connection.sendPostRequest(baseUrl + "/" + EndpointConstants.LOG_IN, tempParams, LoginResponse.class, null);
            return res.data.access_token;
        } catch (IOException e) {
            System.out.println("Can not get access token!");
            return null;
        }
    }

    public static String getAccessToken(String baseUrl) {
        return getAccessToken(baseUrl, AccountConstants.USER_EMAIL, AccountConstants.USER_PASSWORD);
    }
}
