package com.company.TestManager.TestAPIs._18GetListBids;

import com.company.BaseURL;
import com.company.TestManager.Test;
import com.company.TestManager.TestAPIs._18GetListBids.UnitTest.GetListBidsUnitTest1;

import java.util.List;

public class GetListBidsTest extends Test {
    public GetListBidsTest(BaseURL baseURL, String apiName) {
        super(baseURL, apiName);
    }

    @Override
    protected void initUnitTests() {
        this.unitTests.addAll(List.of(new GetListBidsUnitTest1(this)));
    }
}
