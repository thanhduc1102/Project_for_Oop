package com.company.TestManager.TestAPIs._19GetListCategories.UnitTest;

import com.company.TestManager.Test;
import com.company.TestManager.TestAPIs._19GetListCategories.GetListCategoriesResponse;
import com.company.TestManager.UnitTest;

import java.io.IOException;

public class GetListCategoriesUnitTest extends UnitTest {
    public GetListCategoriesUnitTest(Test test) {
        super(test, "With correct params format, the response code and message strings shall be not null as well as non-empty ");
    }

    public void test() throws IOException {
        //        create request object
        GetListCategoriesResponse res = this.sendGetRequest(GetListCategoriesResponse.class);
        this.assertion.assertEquals(res.code, 1000);
        this.assertion.assertInstanceOf(res.message, String.class);
    }
}

