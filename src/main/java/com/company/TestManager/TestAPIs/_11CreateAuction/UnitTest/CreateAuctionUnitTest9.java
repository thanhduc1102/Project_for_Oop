package com.company.TestManager.TestAPIs._11CreateAuction.UnitTest;

import com.company.TestManager.Test;
import com.company.TestManager.TestAPIs._11CreateAuction.CreateAuctionResponse;
import com.company.TestManager.TestAPIs._11CreateAuction.CreateAuctionTest;
import com.company.TestManager.UnitTest;

import java.io.IOException;

public class CreateAuctionUnitTest9 extends UnitTest {
    public CreateAuctionUnitTest9(Test test) {
        super(test, "the end time must be greater than the start time, Server will return code 1001");
    }

    @Override
    public void test() throws IOException {
        this.params = CreateAuctionTest.generateDefaultParams();
        this.params.put("end_date", "2023/06/19 11:03 ");

        CreateAuctionResponse res = sendPostRequestWithAccessToken(CreateAuctionResponse.class);
        this.assertion.assertEquals(res.code, 1001);
        this.assertion.assertInstanceOf(res.message, String.class);
        this.assertion.assertEquals(res.data, null);

    }
}
