package com.company.TestManager.TestAPIs._17CreateBid.UnitTest;

import com.company.TestManager.Test;
import com.company.TestManager.TestAPIs._17CreateBid.CreateBidResponse;
import com.company.TestManager.TestAPIs._17CreateBid.CreateBidTest;
import com.company.TestManager.UnitTest;
import com.company.TestManager.Connection;
import com.company.utils.Util;

import java.io.IOException;

public class CreateBidUnitTest4 extends UnitTest {
    public CreateBidUnitTest4(Test test){super(test, "if the field 'price' contains a character other than , response code 1001 and data must be empty");}

    @Override
    public void test() throws IOException {
        this.params = CreateBidTest.generateDefaultParams();
        this.params.put("price", Util.randomAlphabetOrNumberString(10,10));

        CreateBidResponse res = Connection.sendPostRequest(this.fullURLString + "/12",this.params, CreateBidResponse.class, CreateBidTest.accessToken);

        this.assertion.assertNotEquals(res,null);
        this.assertion.assertEquals(res.code, 1001);
        this.assertion.assertEquals(res.data, null);
    }

}
