package com.company.TestManager.TestAPIs._21AcceptMaxBid;

import com.company.BaseURL;
import com.company.TestManager.Connection;
import com.company.TestManager.Test;
import com.company.TestManager.TestAPIs._21AcceptMaxBid.UnitTest.*;
import com.company.TestManager.TestAPIs._2Login.LoginResponse;
import com.company.constants.EndpointConstants;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AcceptMaxBidTest extends Test {
    public static String access_token;


    public AcceptMaxBidTest(BaseURL baseURL, String apiName) {
        super(baseURL, apiName);
    }
    public static HashMap<String, String> generateDefaultParams() {


        String selling_info = "ok!";
        return new HashMap<>(Map.of(
                "selling_info", selling_info
        ));
    }


    @Override
    protected void beforeAll() throws IOException {
        HashMap<String, String> tempParams = new HashMap<>();
        tempParams.put("email", "Cube@gmail.com");
        tempParams.put("password", "12345678");
        LoginResponse res = Connection.sendPostRequest(EndpointConstants.DEFAULT_BASE_URL + "/" + EndpointConstants.LOG_IN, tempParams, LoginResponse.class, null);
        AcceptMaxBidTest.access_token = res.data.access_token;
    }
    @Override
    protected void initUnitTests() {
            this.unitTests.addAll(List.of(new AcceptMaxBidUnitTest1(this),
                                          new AcceptMaxBidUnitTest2(this),
                                          new AcceptMaxBidUnitTest3(this),
                                          new AcceptMaxBidUnitTest4(this),
                                          new AcceptMaxBidUnitTest5(this),
                                          new AcceptMaxBidUnitTest6(this),
                                          new AcceptMaxBidUnitTest7(this)));
    }
}
