package com.company.TestManager.TestAPIs._17CreateBid.UnitTest;

import com.company.TestManager.Objects.Bid;
import com.company.TestManager.Test;
import com.company.TestManager.TestAPIs._17CreateBid.CreateBidResponse;
import com.company.TestManager.TestAPIs._17CreateBid.CreateBidTest;
import com.company.TestManager.UnitTest;
import com.company.TestManager.Connection;
import java.io.IOException;

public class CreateBidUnitTest1 extends UnitTest {
    public CreateBidUnitTest1(Test test){super(test, "With correct params, response code should be 1000 and data should not be null and comment contains submitted Bids");}

    @Override
    public void test() throws IOException {
        this.params = CreateBidTest.generateDefaultParams();

       CreateBidResponse res = Connection.sendPostRequest(this.fullURLString + "/12",this.params, CreateBidResponse.class, CreateBidTest.accessToken);

       this.assertion.assertNotEquals(res,null);
       this.assertion.assertEquals(res.code, 1000);
       this.assertion.assertNotEquals(res.data, null);

       this.assertion.assertNotEquals(res.data.total, null);
       this.assertion.assertNotEquals(res.data.bids, null);
       for(Bid s : res.data.bids){
           this.assertion.assertNotEquals(s, null);
       }
    }

}
