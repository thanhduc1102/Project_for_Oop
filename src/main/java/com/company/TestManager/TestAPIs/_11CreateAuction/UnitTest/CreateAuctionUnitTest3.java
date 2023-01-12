package com.company.TestManager.TestAPIs._11CreateAuction.UnitTest;

import com.company.TestManager.Test;
import com.company.TestManager.TestAPIs._11CreateAuction.CreateAuctionResponse;
import com.company.TestManager.TestAPIs._11CreateAuction.CreateAuctionTest;
import com.company.TestManager.UnitTest;

import java.io.IOException;

public class CreateAuctionUnitTest3 extends UnitTest {
    public CreateAuctionUnitTest3(Test test) {
        super(test, "no 'category_id' field entered or the value exists, Server will return code 1001");
    }

    @Override
    public void test() throws IOException {
        this.params = CreateAuctionTest.generateDefaultParams();
        this.params.put("category_id", "");

        CreateAuctionResponse res = sendPostRequestWithAccessToken(CreateAuctionResponse.class);
        this.assertion.assertEquals(res.code, 1001);
        this.assertion.assertInstanceOf(res.message, String.class);
        this.assertion.assertEquals(res.data, null);

    }
}
