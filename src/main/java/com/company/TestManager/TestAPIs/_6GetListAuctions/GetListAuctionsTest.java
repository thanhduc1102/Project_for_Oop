package com.company.TestManager.TestAPIs._6GetListAuctions;

import com.company.BaseURL;
import com.company.TestManager.Test;
import com.company.TestManager.TestAPIs._6GetListAuctions.UnitTests.GetListAuctionsUnitTest1;

import java.util.List;

public class GetListAuctionsTest extends Test {

    public GetListAuctionsTest(BaseURL baseURL, String apiName) {
        super(baseURL, apiName);
    }

    @Override
    protected void initUnitTests() {
        this.unitTests.addAll(List.of(new GetListAuctionsUnitTest1(this)));
    }
}
