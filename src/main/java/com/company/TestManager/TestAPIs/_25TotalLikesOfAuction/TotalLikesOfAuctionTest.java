package com.company.TestManager.TestAPIs._25TotalLikesOfAuction;

import com.company.BaseURL;
import com.company.TestManager.Test;
import com.company.TestManager.TestAPIs._25TotalLikesOfAuction.UnitTest.TotalLikesOfAuctionUnitTest1;

import java.util.List;

public class TotalLikesOfAuctionTest extends Test {
    public TotalLikesOfAuctionTest(BaseURL baseURL, String apiName) {
        super(baseURL, apiName);
    }

    @Override
    protected void initUnitTests() {
        this.unitTests.addAll(List.of(new TotalLikesOfAuctionUnitTest1(this)));
    }
}
