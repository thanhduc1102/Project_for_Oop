package com.company.TestManager.TestAPIs._13CreateItem.UnitTest;

import com.company.TestManager.Connection;
import com.company.TestManager.Test;
import com.company.TestManager.TestAPIs._11CreateAuction.CreateAuctionResponse;
import com.company.TestManager.TestAPIs._11CreateAuction.CreateAuctionTest;
import com.company.TestManager.TestAPIs._13CreateItem.CreateItemResponse;
import com.company.TestManager.TestAPIs._13CreateItem.CreateItemTest;
import com.company.TestManager.UnitTest;
import com.company.constants.EndpointConstants;

import java.io.IOException;

public class CreateItemUnitTest3 extends UnitTest {
    public CreateItemUnitTest3(Test test) {
        super(test, "if the brand_id field is not set, response code 1001 and data must be null ");
    }

    @Override
    public void test() throws IOException {
        this.params = CreateAuctionTest.generateDefaultParams();
        CreateAuctionResponse resAuction = Connection.sendPostRequest(this.baseURLString + "/" + EndpointConstants.CREATE_AUCTION, this.params, CreateAuctionResponse.class, CreateItemTest.accessToken);

        this.params = CreateItemTest.generateDefaultParams();
        this.params.put("brand_id", "");
        CreateItemResponse res = Connection.sendPostRequest(this.fullURLString + "/" + resAuction.data.auction_id, this.params, CreateItemResponse.class, CreateItemTest.accessToken);

        this.assertion.assertNotEquals(res, null);
        this.assertion.assertEquals(res.code, 1001);
        this.assertion.assertEquals(res.data, null);


    }
}
