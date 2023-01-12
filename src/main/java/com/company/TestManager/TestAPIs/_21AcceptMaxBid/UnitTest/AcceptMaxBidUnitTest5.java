package com.company.TestManager.TestAPIs._21AcceptMaxBid.UnitTest;

import com.company.TestManager.Connection;
import com.company.TestManager.Test;
import com.company.TestManager.TestAPIs._21AcceptMaxBid.AcceptMaxBidResponse;
import com.company.TestManager.TestAPIs._21AcceptMaxBid.AcceptMaxBidTest;
import com.company.TestManager.UnitTest;

import java.io.IOException;

public class AcceptMaxBidUnitTest5 extends UnitTest {
    public AcceptMaxBidUnitTest5(Test test){
        super(test, "If the auction has not ended, the price offered by the buyer cannot be accepted, the server will return code 1009");
    }

    public void test() throws IOException{
        this.params = AcceptMaxBidTest.generateDefaultParams();
        AcceptMaxBidResponse res= Connection.sendPostRequest(this.fullURLString +"/372", this.params, AcceptMaxBidResponse.class, AcceptMaxBidTest.access_token);

        this.assertion.assertNotEquals(res, null);
        this.assertion.assertEquals(res.code, 1009);
        this.assertion.assertTrue(res.message.length() > 0);
        this.assertion.assertEquals(res.data, null);

    }
}