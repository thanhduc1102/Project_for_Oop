package com.company.TestManager.TestAPIs._21AcceptMaxBid.UnitTest;

import com.company.TestManager.Connection;
import com.company.TestManager.Test;
import com.company.TestManager.TestAPIs._21AcceptMaxBid.AcceptMaxBidResponse;
import com.company.TestManager.TestAPIs._21AcceptMaxBid.AcceptMaxBidTest;
import com.company.TestManager.UnitTest;

import java.io.IOException;

public class AcceptMaxBidUnitTest2 extends UnitTest {
    public AcceptMaxBidUnitTest2(Test test){
        super(test, "if the 'selling_info' field is not set, response code 1001 and data must be null");
    }

    public void test() throws IOException{
        this.params = AcceptMaxBidTest.generateDefaultParams();
        this.params.put("selling_info", "");
        AcceptMaxBidResponse res= Connection.sendPostRequest(this.fullURLString +"/430", this.params, AcceptMaxBidResponse.class, AcceptMaxBidTest.access_token);

        this.assertion.assertNotEquals(res, null);
        this.assertion.assertEquals(res.code, 1001);
        this.assertion.assertTrue(res.message.length() > 0);
        this.assertion.assertEquals(res.data, null);

    }
}