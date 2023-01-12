package com.company.TestManager.TestAPIs._17CreateBid.UnitTest;

import com.company.TestManager.Test;
import com.company.TestManager.TestAPIs._17CreateBid.CreateBidResponse;
import com.company.TestManager.TestAPIs._17CreateBid.CreateBidTest;
import com.company.TestManager.UnitTest;
import com.company.TestManager.Connection;

import java.io.IOException;

public class CreateBidUnitTest5 extends UnitTest {
    public CreateBidUnitTest5(Test test){super(test, "if the 'price' field is less than or equal to the previous highest price, response code 1001 and data must be empty");}

    @Override
    public void test() throws IOException {
        this.params = CreateBidTest.generateDefaultParams();
        this.params.put("price", "1");

        CreateBidResponse res = Connection.sendPostRequest(this.fullURLString + "/12",this.params, CreateBidResponse.class, CreateBidTest.accessToken);

        this.assertion.assertNotEquals(res,null);
        this.assertion.assertEquals(res.code, 1001);
        this.assertion.assertEquals(res.data, null);
    }

}
