package com.company.TestManager.TestAPIs._23LikeAuction;

import com.company.BaseURL;
import com.company.TestManager.Test;
import com.company.TestManager.TestAPIs._23LikeAuction.UnitTest.LikeAuctionUnitTest1;
import com.company.TestManager.TestAPIs._23LikeAuction.UnitTest.LikeAuctionUnitTest2;

import java.util.List;

public class LikeAuctionTest extends Test {
    public LikeAuctionTest(BaseURL baseURL, String apiName) {
        super(baseURL, apiName);
    }

    @Override
    protected void initUnitTests() {
        this.unitTests.addAll(List.of(new LikeAuctionUnitTest1(this), new LikeAuctionUnitTest2(this)));


    }
}
