package com.company.TestManager.TestAPIs._13CreateItem.UnitTest;

import com.company.TestManager.Connection;
import com.company.TestManager.Test;
import com.company.TestManager.TestAPIs._13CreateItem.CreateItemResponse;
import com.company.TestManager.TestAPIs._13CreateItem.CreateItemTest;
import com.company.TestManager.UnitTest;
import com.company.utils.Util;

import java.io.IOException;

public class CreateItemUnitTest5 extends UnitTest {
    public CreateItemUnitTest5(Test test) {
        super(test, "If more than 255 characters are entered in the name field, the response code will be 1001 and the data should be null");
    }

    @Override
    public void test() throws IOException {

        this.params = CreateItemTest.generateDefaultParams();
        this.params.put("name", Util.randomAlphabetString(257));
        CreateItemResponse res = Connection.sendPostRequest(this.fullURLString + "/" + CreateItemTest.auction_idForCreateItem, this.params, CreateItemResponse.class, CreateItemTest.accessToken);

        this.assertion.assertNotEquals(res, null);
        this.assertion.assertEquals(res.code, 1001);
        this.assertion.assertEquals(res.data, null);


    }
}
