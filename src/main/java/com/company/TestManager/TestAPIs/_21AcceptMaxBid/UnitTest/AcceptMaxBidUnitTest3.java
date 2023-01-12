package com.company.TestManager.TestAPIs._21AcceptMaxBid.UnitTest;

import com.company.TestManager.Connection;
import com.company.TestManager.Test;
import com.company.TestManager.TestAPIs._21AcceptMaxBid.AcceptMaxBidResponse;
import com.company.TestManager.TestAPIs._21AcceptMaxBid.AcceptMaxBidTest;
import com.company.TestManager.UnitTest;

import java.io.IOException;

public class AcceptMaxBidUnitTest3 extends UnitTest {
    public AcceptMaxBidUnitTest3(Test test){
        super(test, "If you are not logged in, the server will return code 1004");
    }

    public void test() throws IOException{
        this.params = AcceptMaxBidTest.generateDefaultParams();
        AcceptMaxBidResponse res= Connection.sendPostRequest(this.fullURLString +"/430", this.params, AcceptMaxBidResponse.class, null);

        this.assertion.assertNotEquals(res, null);
        this.assertion.assertEquals(res.code, 1004);
        this.assertion.assertTrue(res.message.length() > 0);
        this.assertion.assertEquals(res.data, null);

    }
}