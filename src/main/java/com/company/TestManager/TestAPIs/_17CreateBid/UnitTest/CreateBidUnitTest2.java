package com.company.TestManager.TestAPIs._17CreateBid.UnitTest;

import com.company.TestManager.Test;
import com.company.TestManager.TestAPIs._17CreateBid.CreateBidResponse;
import com.company.TestManager.TestAPIs._17CreateBid.CreateBidTest;
import com.company.TestManager.UnitTest;
import com.company.TestManager.Connection;

import java.io.IOException;

public class CreateBidUnitTest2 extends UnitTest {
    public CreateBidUnitTest2(Test test){super(test, "if you bid on a closed auction, the code response will be 1008 and the data should be null");}

    @Override
    public void test() throws IOException{
        this.params= CreateBidTest.generateDefaultParams();

        CreateBidResponse res = Connection.sendPostRequest(this.fullURLString + "/1", this.params, CreateBidResponse.class,CreateBidTest.accessToken);

        this.assertion.assertNotEquals(res, null);
        this.assertion.assertEquals(res.code, 1008);
        this.assertion.assertEquals(res.data,null);
    }

}
