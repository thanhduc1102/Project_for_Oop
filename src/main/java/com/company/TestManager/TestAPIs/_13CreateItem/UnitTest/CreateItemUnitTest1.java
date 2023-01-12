package com.company.TestManager.TestAPIs._13CreateItem.UnitTest;

import com.company.TestManager.Connection;
import com.company.TestManager.Test;
import com.company.TestManager.TestAPIs._13CreateItem.CreateItemResponse;
import com.company.TestManager.TestAPIs._13CreateItem.CreateItemTest;
import com.company.TestManager.UnitTest;

import java.io.IOException;

public class CreateItemUnitTest1 extends UnitTest {
    public CreateItemUnitTest1(Test test) {
        super(test, "With correct params, response code should be 1000 and data should not be null ");
    }

    @Override
    public void test() throws IOException {

        this.params = CreateItemTest.generateDefaultParams();
        CreateItemResponse res = Connection.sendPostRequest(this.fullURLString + "/" + CreateItemTest.auction_idForCreateItem, this.params, CreateItemResponse.class, CreateItemTest.accessToken);

        this.assertion.assertNotEquals(res, null);
        this.assertion.assertEquals(res.code, 1000);
        this.assertion.assertTrue(res.message.length() > 0);
        this.assertion.assertNotEquals(res.data, null);

        this.assertion.assertEquals(res.data.name, this.params.get("name"));
        this.assertion.assertEquals(res.data.series, this.params.get("series"));
        this.assertion.assertEquals(res.data.description, this.params.get("description"));
        this.assertion.assertEquals(res.data.brand_id, this.params.get("brand_id"));


    }
}
