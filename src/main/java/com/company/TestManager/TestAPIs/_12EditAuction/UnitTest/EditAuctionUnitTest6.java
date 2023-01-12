package com.company.TestManager.TestAPIs._12EditAuction.UnitTest;

import com.company.TestManager.Connection;
import com.company.TestManager.Test;
import com.company.TestManager.TestAPIs._12EditAuction.EditAuctionResponse;
import com.company.TestManager.TestAPIs._12EditAuction.EditAuctionTest;
import com.company.TestManager.UnitTest;

import java.io.IOException;

public class EditAuctionUnitTest6 extends UnitTest {
    public EditAuctionUnitTest6(Test test) {
        super(test,
                "if the start_date field is not set, response code 1001 and data must be null");
    }

    @Override
    public void test() throws IOException {
        this.params = EditAuctionTest.generateDefaultParams();
        this.params.put("start_date", "");

        EditAuctionResponse res = Connection.sendPostRequest(this.fullURLString + "/" + EditAuctionTest.idAuctionTest, this.params, EditAuctionResponse.class, EditAuctionTest.access_token);

        this.assertion.assertNotEquals(res, null);
        this.assertion.assertEquals(res.code, 1001);
        this.assertion.assertEquals(res.data, null);


    }
}
