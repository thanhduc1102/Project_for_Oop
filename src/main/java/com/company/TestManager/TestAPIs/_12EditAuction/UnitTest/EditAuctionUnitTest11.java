package com.company.TestManager.TestAPIs._12EditAuction.UnitTest;

import com.company.TestManager.Connection;
import com.company.TestManager.Test;
import com.company.TestManager.TestAPIs._12EditAuction.EditAuctionResponse;
import com.company.TestManager.TestAPIs._12EditAuction.EditAuctionTest;
import com.company.TestManager.UnitTest;

import java.io.IOException;

public class EditAuctionUnitTest11 extends UnitTest {
    public EditAuctionUnitTest11(Test test) {
        super(test,
                "if the end time is earlier than the start time, the response code will be 1001 and the data should be null");
    }

    @Override
    public void test() throws IOException {
        this.params = EditAuctionTest.generateDefaultParams();
        this.params.put("end_date", "2023/06/19 11:03");

        EditAuctionResponse res = Connection.sendPostRequest(this.fullURLString + "/" + EditAuctionTest.idAuctionTest, this.params, EditAuctionResponse.class, EditAuctionTest.access_token);

        this.assertion.assertNotEquals(res, null);
        this.assertion.assertEquals(res.code, 1001);
        this.assertion.assertEquals(res.data, null);


    }
}
