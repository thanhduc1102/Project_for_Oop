package com.company.TestManager.TestAPIs._21AcceptMaxBid.UnitTest;

import com.company.TestManager.Connection;
import com.company.TestManager.Test;
import com.company.TestManager.TestAPIs._21AcceptMaxBid.AcceptMaxBidResponse;
import com.company.TestManager.TestAPIs._21AcceptMaxBid.AcceptMaxBidTest;
import com.company.TestManager.UnitTest;

import java.io.IOException;

public class AcceptMaxBidUnitTest4 extends UnitTest {
    public AcceptMaxBidUnitTest4(Test test){
        super(test, "if Auction_id is not created by you then you are not authorized to accept, the server will return code 1006");
    }

    public void test() throws IOException{
        this.params = AcceptMaxBidTest.generateDefaultParams();
        AcceptMaxBidResponse res= Connection.sendPostRequest(this.fullURLString +"/1", this.params, AcceptMaxBidResponse.class, AcceptMaxBidTest.access_token);

        this.assertion.assertNotEquals(res, null);
        this.assertion.assertEquals(res.code, 1006);
        this.assertion.assertTrue(res.message.length() > 0);
        this.assertion.assertEquals(res.data, null);

    }
}