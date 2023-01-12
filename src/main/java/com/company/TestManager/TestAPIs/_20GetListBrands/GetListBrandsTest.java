package com.company.TestManager.TestAPIs._20GetListBrands;

import com.company.BaseURL;
import com.company.TestManager.Test;
import com.company.TestManager.TestAPIs._20GetListBrands.UnitTest.GetListBrandsUnitTest;

import java.util.List;

public class GetListBrandsTest extends Test {
    public GetListBrandsTest(BaseURL baseURL, String apiName) {
        super(baseURL, apiName);
    }

    @Override
    protected void initUnitTests() {
        this.unitTests.addAll(List.of(new GetListBrandsUnitTest(this)));
    }
}
