package com.company.TestManager.TestAPIs._11CreateAuction.UnitTest;

import com.company.TestManager.Test;
import com.company.TestManager.TestAPIs._11CreateAuction.CreateAuctionResponse;
import com.company.TestManager.TestAPIs._11CreateAuction.CreateAuctionTest;
import com.company.TestManager.UnitTest;

import java.io.IOException;

public class CreateAuctionUnitTest1 extends UnitTest {
    public CreateAuctionUnitTest1(Test test) {
        super(test, "With correct params, response code should be 1000 and data should not be null ");
    }

    @Override
    public void test() throws IOException {
        this.params = CreateAuctionTest.generateDefaultParams();

        CreateAuctionResponse res = sendPostRequestWithAccessToken(CreateAuctionResponse.class);
        this.assertion.assertNotEquals(res, null);
        this.assertion.assertEquals(res.code, 1000);
        this.assertion.assertTrue(res.message.length() > 0);
        this.assertion.assertNotEquals(res.data, null);

        this.assertion.assertEquals(res.data.category_id, this.params.get("category_id"));
        this.assertion.assertEquals(res.data.start_date, this.params.get("start_date"));
        this.assertion.assertEquals(res.data.end_date, this.params.get("end_date"));
        this.assertion.assertEquals(res.data.title, this.params.get("title_ni"));



    }

}
