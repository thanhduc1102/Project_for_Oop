package com.company.TestManager.TestAPIs._10GetDetailsAuctions;

import com.company.BaseURL;
import com.company.TestManager.Test;
import com.company.TestManager.TestAPIs._10GetDetailsAuctions.UnitTest.GetDetailsAuctionsUnitTest1;
import java.util.List;

public class GetDetailsAuctionsTest extends Test {
    public GetDetailsAuctionsTest(BaseURL baseURL, String apiName) {
        super(baseURL, apiName);
    }

    @Override
    protected void initUnitTests() {
        this.unitTests.addAll(List.of(new GetDetailsAuctionsUnitTest1(this)));
    }
}
