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
import java.util.HashMap;

public class CreateItemUnitTest10 extends UnitTest {
    HashMap<String, String> tempParams = new HashMap<>();

    public CreateItemUnitTest10(Test test) {
        super(test, "if the series field matches the existing one , response code 1001 and data must be null ");
    }

    @Override
    public void test() throws IOException {

        this.params = CreateItemTest.generateDefaultParams();
        tempParams.put("name", this.params.get("name"));
        tempParams.put("starting_price", this.params.get("starting_price"));
        tempParams.put("brand_id", this.params.get("brand_id"));
        tempParams.put("description", this.params.get("description"));
        tempParams.put("series", this.params.get("series"));
        CreateItemResponse res1 = Connection.sendPostRequest(this.fullURLString + "/" + CreateItemTest.auction_idForCreateItem, this.params, CreateItemResponse.class, CreateItemTest.accessToken);

        this.params = CreateAuctionTest.generateDefaultParams();
        CreateAuctionResponse resAuction1 = Connection.sendPostRequest(this.baseURLString + "/" + EndpointConstants.CREATE_AUCTION, this.params, CreateAuctionResponse.class, CreateItemTest.accessToken);

        CreateItemResponse res = Connection.sendPostRequest(this.fullURLString + "/" + resAuction1.data.auction_id, tempParams, CreateItemResponse.class, CreateItemTest.accessToken);

        this.assertion.assertNotEquals(res, null);

        this.assertion.assertEquals(res.code, 1001);

        this.assertion.assertEquals(res.data, null);


    }
}
