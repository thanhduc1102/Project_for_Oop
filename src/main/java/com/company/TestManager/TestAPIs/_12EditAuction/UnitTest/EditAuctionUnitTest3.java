package com.company.TestManager.TestAPIs._12EditAuction.UnitTest;

import com.company.TestManager.Connection;
import com.company.TestManager.Test;
import com.company.TestManager.TestAPIs._12EditAuction.EditAuctionResponse;
import com.company.TestManager.TestAPIs._12EditAuction.EditAuctionTest;
import com.company.TestManager.UnitTest;

import java.io.IOException;

public class EditAuctionUnitTest3 extends UnitTest {
    public EditAuctionUnitTest3(Test test) {
        super(test,
                "Non-editable (Approved auctions cannot be edited),  response code should be 1005 and data should be null ");
    }

    @Override
    public void test() throws IOException {
        this.params = EditAuctionTest.generateDefaultParams();

        EditAuctionResponse res = Connection.sendPostRequest(this.fullURLString + "/372" , this.params, EditAuctionResponse.class, EditAuctionTest.access_token);

        this.assertion.assertNotEquals(res, null);
        this.assertion.assertEquals(res.code, 1005);
        this.assertion.assertEquals(res.data, null);


    }
}
