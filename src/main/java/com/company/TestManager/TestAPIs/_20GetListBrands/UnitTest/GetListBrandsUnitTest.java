package com.company.TestManager.TestAPIs._20GetListBrands.UnitTest;

import com.company.TestManager.Test;
import com.company.TestManager.TestAPIs._20GetListBrands.GetListBrandsResponse;
import com.company.TestManager.UnitTest;

import java.io.IOException;

public class GetListBrandsUnitTest extends UnitTest {
    public GetListBrandsUnitTest(Test test){
        super(test, "With correct params format, the response code and message strings shall be not null as well as non-empty");

    }
    public void test() throws IOException {
        GetListBrandsResponse res= this.sendGetRequest(GetListBrandsResponse.class);
        this.assertion.assertEquals(res.code,1000);
        this.assertion.assertInstanceOf(res.message,String.class);
    }
}
