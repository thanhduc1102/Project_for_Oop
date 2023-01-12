package com.company.TestManager.TestAPIs._10GetDetailsAuctions.UnitTest;

import com.company.TestManager.Connection;
import com.company.TestManager.Test;
import com.company.TestManager.TestAPIs._10GetDetailsAuctions.GetDetailsAuctionsResponse;
import com.company.TestManager.UnitTest;

import java.io.IOException;

public class GetDetailsAuctionsUnitTest1 extends UnitTest {
    public GetDetailsAuctionsUnitTest1(Test test) {
        super(test, "With correct params, response code should be 1000 and data should not be null ");
    }

    @Override
    public void test() throws IOException {
        GetDetailsAuctionsResponse res = Connection.sendGetRequest(this.fullURLString + "/1", this.params, GetDetailsAuctionsResponse.class, this.getAccessToken());

        this.assertion.assertNotEquals(res, null);
        this.assertion.assertEquals(res.code, 1000);
        this.assertion.assertTrue(res.message.length() > 0);
        this.assertion.assertNotEquals(res.data, null);
        this.assertion.assertNotEquals(res.data.auctions, null);
        this.assertion.assertNotEquals(res.data.category, null);
        this.assertion.assertNotEquals(res.data.items, null);
        this.assertion.assertNotEquals(res.data.selling_user, null);


    }
}
