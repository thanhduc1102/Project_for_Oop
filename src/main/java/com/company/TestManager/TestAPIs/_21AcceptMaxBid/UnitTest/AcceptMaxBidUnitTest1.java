package com.company.TestManager.TestAPIs._21AcceptMaxBid.UnitTest;

import com.company.TestManager.Connection;
import com.company.TestManager.Test;
import com.company.TestManager.TestAPIs._21AcceptMaxBid.AcceptMaxBidResponse;
import com.company.TestManager.TestAPIs._21AcceptMaxBid.AcceptMaxBidTest;
import com.company.TestManager.UnitTest;

import java.io.IOException;

public class AcceptMaxBidUnitTest1 extends UnitTest {
    public AcceptMaxBidUnitTest1(Test test){
        super(test, "With correct params, response code should be 1000 and data should not be null");
    }

    public void test() throws IOException{
        this.params = AcceptMaxBidTest.generateDefaultParams();
        AcceptMaxBidResponse res= Connection.sendPostRequest(this.fullURLString +"/420", this.params, AcceptMaxBidResponse.class, AcceptMaxBidTest.access_token);

        this.assertion.assertNotEquals(res, null);
        this.assertion.assertEquals(res.code, 1000);
        this.assertion.assertTrue(res.message.length() > 0);
        this.assertion.assertNotEquals(res.data, null);

        this.assertion.assertNotEquals(res.data.auction_info, null);
        this.assertion.assertNotEquals(res.data.item_info, null);
        this.assertion.assertNotEquals(res.data.item_info.selling_user, null);
        this.assertion.assertNotEquals(res.data.item_info.buying_user, null);
}
}