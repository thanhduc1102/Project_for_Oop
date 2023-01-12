package com.company.TestManager.TestAPIs._11CreateAuction;

import com.company.BaseURL;
import com.company.TestManager.Test;
import com.company.TestManager.TestAPIs._11CreateAuction.UnitTest.*;
import com.company.utils.Util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CreateAuctionTest extends Test {
    public CreateAuctionTest(BaseURL baseURL, String apiName) {
        super(baseURL, apiName);
    }

    public static HashMap<String, String> generateDefaultParams() {

        String category_id = Util.randomNumberString(1, 1, 7);
        String start_date = "2023/06/20 11:03";
        String end_date = "2023/06/21 11:03";
        String title_ni = "Tui xach " + Util.randomAlphabetString(20);
        return new HashMap<>(Map.of(
                "category_id", category_id,
                "start_date", start_date,
                "end_date", end_date,
                "title_ni", title_ni

        ));
    }

    @Override
    protected void initUnitTests() {
        this.unitTests.addAll(List.of(new CreateAuctionUnitTest1(this), new CreateAuctionUnitTest2(this), new CreateAuctionUnitTest3(this),
                new CreateAuctionUnitTest4(this), new CreateAuctionUnitTest5(this), new CreateAuctionUnitTest6(this),
                new CreateAuctionUnitTest7(this), new CreateAuctionUnitTest8(this), new CreateAuctionUnitTest9(this),
                new CreateAuctionUnitTest10(this), new CreateAuctionUnitTest11(this)));
    }
}
